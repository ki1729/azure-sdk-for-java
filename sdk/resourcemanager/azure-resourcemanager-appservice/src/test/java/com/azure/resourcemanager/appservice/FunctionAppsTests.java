// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.resourcemanager.appservice;

import com.azure.core.http.HttpPipeline;
import com.azure.core.http.rest.PagedIterable;
import com.azure.core.http.rest.Response;
import com.azure.core.management.exception.ManagementException;
import com.azure.resourcemanager.appservice.models.AppServicePlan;
import com.azure.resourcemanager.appservice.models.AppSetting;
import com.azure.resourcemanager.appservice.models.FunctionApp;
import com.azure.resourcemanager.appservice.models.FunctionAppBasic;
import com.azure.resourcemanager.appservice.models.FunctionEnvelope;
import com.azure.resourcemanager.appservice.models.FunctionRuntimeStack;
import com.azure.resourcemanager.appservice.models.PricingTier;
import com.azure.resourcemanager.appservice.models.SkuName;
import com.azure.resourcemanager.test.utils.TestUtilities;
import com.azure.core.management.Region;
import com.azure.core.management.profile.AzureProfile;
import com.azure.resourcemanager.resources.fluentcore.utils.ResourceManagerUtils;
import com.azure.resourcemanager.storage.models.StorageAccount;
import com.azure.resourcemanager.storage.models.StorageAccountSkuType;
import com.azure.resourcemanager.storage.StorageManager;
import java.io.File;
import java.time.Duration;
import java.util.Arrays;
import java.util.Map;
import java.util.regex.Pattern;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class FunctionAppsTests extends AppServiceTest {
    private String rgName1 = "";
    private String rgName2 = "";
    private String webappName1 = "";
    private String webappName2 = "";
    private String webappName3 = "";
    private String appServicePlanName1 = "";
    private String appServicePlanName2 = "";
    private String storageAccountName1 = "";

    protected StorageManager storageManager;

    @Override
    protected void initializeClients(HttpPipeline httpPipeline, AzureProfile profile) {
        webappName1 = generateRandomResourceName("java-func-", 20);
        webappName2 = generateRandomResourceName("java-func-", 20);
        webappName3 = generateRandomResourceName("java-func-", 20);
        appServicePlanName1 = generateRandomResourceName("java-asp-", 20);
        appServicePlanName2 = generateRandomResourceName("java-asp-", 20);
        storageAccountName1 = generateRandomResourceName("javastore", 20);
        rgName1 = generateRandomResourceName("javacsmrg", 20);
        rgName2 = generateRandomResourceName("javacsmrg", 20);

        storageManager = buildManager(StorageManager.class, httpPipeline, profile);

        super.initializeClients(httpPipeline, profile);
    }

    @Override
    protected void cleanUpResources() {
        if (rgName1 != null) {
            resourceManager.resourceGroups().beginDeleteByName(rgName1);
        }
        if (rgName2 != null) {
            try {
                resourceManager.resourceGroups().beginDeleteByName(rgName2);
            } catch (ManagementException e) {
                // fine, RG_NAME_2 is not created
            }
        }
    }

    @Test
    public void canCRUDFunctionApp() throws Exception {
        // Create with consumption
        FunctionApp functionApp1 =
            appServiceManager
                .functionApps()
                .define(webappName1)
                .withRegion(Region.US_WEST)
                .withNewResourceGroup(rgName1)
                .create();
        Assertions.assertNotNull(functionApp1);
        Assertions.assertEquals(Region.US_WEST, functionApp1.region());
        AppServicePlan plan1 = appServiceManager.appServicePlans().getById(functionApp1.appServicePlanId());
        Assertions.assertNotNull(plan1);
        Assertions.assertEquals(Region.US_WEST, plan1.region());
        Assertions.assertEquals(new PricingTier("Dynamic", "Y1"), plan1.pricingTier());

        FunctionAppResource functionAppResource1 = getStorageAccount(storageManager, functionApp1);
        // consumption plan requires this 2 settings
        Assertions.assertTrue(functionAppResource1.appSettings.containsKey(KEY_CONTENT_AZURE_FILE_CONNECTION_STRING));
        Assertions.assertTrue(functionAppResource1.appSettings.containsKey(KEY_CONTENT_SHARE));
        Assertions
            .assertEquals(
                functionAppResource1.appSettings.get(KEY_AZURE_WEB_JOBS_STORAGE).value(),
                functionAppResource1.appSettings.get(KEY_CONTENT_AZURE_FILE_CONNECTION_STRING).value());
        // verify accountKey
        Assertions
            .assertEquals(
                functionAppResource1.storageAccount.getKeys().get(0).value(), functionAppResource1.accountKey);

        // Create with the same consumption plan
        FunctionApp functionApp2 =
            appServiceManager
                .functionApps()
                .define(webappName2)
                .withExistingAppServicePlan(plan1)
                .withNewResourceGroup(rgName2)
                .withExistingStorageAccount(functionApp1.storageAccount())
                .create();
        Assertions.assertNotNull(functionApp2);
        Assertions.assertEquals(Region.US_WEST, functionApp2.region());

        // Create with app service plan
        FunctionApp functionApp3 =
            appServiceManager
                .functionApps()
                .define(webappName3)
                .withRegion(Region.US_WEST)
                .withExistingResourceGroup(rgName2)
                .withNewAppServicePlan(PricingTier.BASIC_B1)
                .withExistingStorageAccount(functionApp1.storageAccount())
                .create();
        Assertions.assertNotNull(functionApp2);
        Assertions.assertEquals(Region.US_WEST, functionApp2.region());

        // app service plan does not have this 2 settings
        // https://github.com/Azure/azure-libraries-for-net/issues/485
        FunctionAppResource functionAppResource3 = getStorageAccount(storageManager, functionApp3);
        Assertions.assertFalse(functionAppResource3.appSettings.containsKey(KEY_CONTENT_AZURE_FILE_CONNECTION_STRING));
        Assertions.assertFalse(functionAppResource3.appSettings.containsKey(KEY_CONTENT_SHARE));
        // verify accountKey
        Assertions
            .assertEquals(
                functionAppResource3.storageAccount.getKeys().get(0).value(), functionAppResource3.accountKey);

        // Get
        FunctionApp functionApp = appServiceManager.functionApps().getByResourceGroup(rgName1, functionApp1.name());
        Assertions.assertEquals(functionApp1.id(), functionApp.id());
        functionApp = appServiceManager.functionApps().getById(functionApp2.id());
        Assertions.assertEquals(functionApp2.name(), functionApp.name());

        // List
        PagedIterable<FunctionAppBasic> functionApps = appServiceManager.functionApps().listByResourceGroup(rgName1);
        Assertions.assertEquals(1, TestUtilities.getSize(functionApps));
        functionApps = appServiceManager.functionApps().listByResourceGroup(rgName2);
        Assertions.assertEquals(2, TestUtilities.getSize(functionApps));

        // Update
        functionApp2.update().withNewStorageAccount(storageAccountName1, StorageAccountSkuType.STANDARD_LRS).apply();
        Assertions.assertEquals(storageAccountName1, functionApp2.storageAccount().name());

        FunctionAppResource functionAppResource2 = getStorageAccount(storageManager, functionApp2);
        Assertions.assertTrue(functionAppResource2.appSettings.containsKey(KEY_CONTENT_AZURE_FILE_CONNECTION_STRING));
        Assertions.assertTrue(functionAppResource2.appSettings.containsKey(KEY_CONTENT_SHARE));
        Assertions
            .assertEquals(
                functionAppResource2.appSettings.get(KEY_AZURE_WEB_JOBS_STORAGE).value(),
                functionAppResource2.appSettings.get(KEY_CONTENT_AZURE_FILE_CONNECTION_STRING).value());
        Assertions.assertEquals(storageAccountName1, functionAppResource2.storageAccount.name());
        Assertions
            .assertEquals(
                functionAppResource2.storageAccount.getKeys().get(0).value(), functionAppResource2.accountKey);

        // Update, verify modify AppSetting does not create new storage account
        // https://github.com/Azure/azure-libraries-for-net/issues/457
        int numStorageAccountBefore =
            TestUtilities.getSize(storageManager.storageAccounts().listByResourceGroup(rgName1));
        functionApp1.update().withAppSetting("newKey", "newValue").apply();
        int numStorageAccountAfter =
            TestUtilities.getSize(storageManager.storageAccounts().listByResourceGroup(rgName1));
        Assertions.assertEquals(numStorageAccountBefore, numStorageAccountAfter);
        FunctionAppResource functionAppResource1Updated = getStorageAccount(storageManager, functionApp1);
        Assertions.assertTrue(functionAppResource1Updated.appSettings.containsKey("newKey"));
        Assertions
            .assertEquals(
                functionAppResource1.appSettings.get(KEY_AZURE_WEB_JOBS_STORAGE).value(),
                functionAppResource1Updated.appSettings.get(KEY_AZURE_WEB_JOBS_STORAGE).value());
        Assertions
            .assertEquals(
                functionAppResource1.appSettings.get(KEY_CONTENT_AZURE_FILE_CONNECTION_STRING).value(),
                functionAppResource1Updated.appSettings.get(KEY_CONTENT_AZURE_FILE_CONNECTION_STRING).value());
        Assertions
            .assertEquals(
                functionAppResource1.appSettings.get(KEY_CONTENT_SHARE).value(),
                functionAppResource1Updated.appSettings.get(KEY_CONTENT_SHARE).value());
        Assertions
            .assertEquals(
                functionAppResource1.storageAccount.name(), functionAppResource1Updated.storageAccount.name());

        // Scale
        functionApp3.update().withNewAppServicePlan(PricingTier.STANDARD_S2).apply();
        Assertions.assertNotEquals(functionApp3.appServicePlanId(), functionApp1.appServicePlanId());
    }

    private static final String FUNCTION_APP_PACKAGE_URL =
        "https://raw.githubusercontent.com/Azure/azure-sdk-for-java/main/sdk/resourcemanager/azure-resourcemanager-appservice/src/test/resources/java-functions.zip";

    @Test
    public void canCRUDLinuxFunctionApp() throws Exception {
        rgName2 = null;

        // function app with consumption plan
        FunctionApp functionApp1 =
            appServiceManager
                .functionApps()
                .define(webappName1)
                .withRegion(Region.US_EAST)
                .withNewResourceGroup(rgName1)
                .withNewLinuxConsumptionPlan()
                .withBuiltInImage(FunctionRuntimeStack.JAVA_8)
                .withHttpsOnly(true)
                .withAppSetting("WEBSITE_RUN_FROM_PACKAGE", FUNCTION_APP_PACKAGE_URL)
                .create();
        Assertions.assertNotNull(functionApp1);
        assertLinuxJava(functionApp1, FunctionRuntimeStack.JAVA_8);

        AppServicePlan plan1 = appServiceManager.appServicePlans().getById(functionApp1.appServicePlanId());
        Assertions.assertNotNull(plan1);
        Assertions.assertEquals(Region.US_EAST, plan1.region());
        Assertions.assertEquals(new PricingTier(SkuName.DYNAMIC.toString(), "Y1"), plan1.pricingTier());
        Assertions.assertTrue(plan1.innerModel().reserved());
        Assertions
            .assertTrue(
                Arrays
                    .asList(functionApp1.innerModel().kind().split(Pattern.quote(",")))
                    .containsAll(Arrays.asList("linux", "functionapp")));

        FunctionAppResource functionAppResource1 = getStorageAccount(storageManager, functionApp1);
        // consumption plan requires this 2 settings
        Assertions.assertTrue(functionAppResource1.appSettings.containsKey(KEY_CONTENT_AZURE_FILE_CONNECTION_STRING));
        Assertions.assertTrue(functionAppResource1.appSettings.containsKey(KEY_CONTENT_SHARE));
        Assertions
            .assertEquals(
                functionAppResource1.appSettings.get(KEY_AZURE_WEB_JOBS_STORAGE).value(),
                functionAppResource1.appSettings.get(KEY_CONTENT_AZURE_FILE_CONNECTION_STRING).value());
        // verify accountKey
        Assertions
            .assertEquals(
                functionAppResource1.storageAccount.getKeys().get(0).value(), functionAppResource1.accountKey);

        PagedIterable<FunctionAppBasic> functionApps = appServiceManager.functionApps().listByResourceGroup(rgName1);
        Assertions.assertEquals(1, TestUtilities.getSize(functionApps));

        // function app with app service plan
        FunctionApp functionApp2 =
            appServiceManager
                .functionApps()
                .define(webappName2)
                .withRegion(Region.US_EAST)
                .withExistingResourceGroup(rgName1)
                .withNewLinuxAppServicePlan(PricingTier.STANDARD_S1)
                .withBuiltInImage(FunctionRuntimeStack.JAVA_8)
                .withHttpsOnly(true)
                .withAppSetting("WEBSITE_RUN_FROM_PACKAGE", FUNCTION_APP_PACKAGE_URL)
                .create();
        Assertions.assertNotNull(functionApp2);
        assertLinuxJava(functionApp2, FunctionRuntimeStack.JAVA_8);

        AppServicePlan plan2 = appServiceManager.appServicePlans().getById(functionApp2.appServicePlanId());
        Assertions.assertNotNull(plan2);
        Assertions.assertEquals(PricingTier.STANDARD_S1, plan2.pricingTier());
        Assertions.assertTrue(plan2.innerModel().reserved());

        // one more function app using existing app service plan
        FunctionApp functionApp3 =
            appServiceManager
                .functionApps()
                .define(webappName3)
                .withExistingLinuxAppServicePlan(plan2)
                .withExistingResourceGroup(rgName1)
                .withBuiltInImage(FunctionRuntimeStack.JAVA_8)
                .withHttpsOnly(true)
                .withAppSetting("WEBSITE_RUN_FROM_PACKAGE", FUNCTION_APP_PACKAGE_URL)
                .create();
        Assertions.assertNotNull(functionApp3);
        assertLinuxJava(functionApp3, FunctionRuntimeStack.JAVA_8);

        // wait for deploy
        if (!isPlaybackMode()) {
            ResourceManagerUtils.sleep(Duration.ofMinutes(3));
        }

        functionApps = appServiceManager.functionApps().listByResourceGroup(rgName1);
        Assertions.assertEquals(3, TestUtilities.getSize(functionApps));

        // verify deploy
        PagedIterable<FunctionEnvelope> functions =
            appServiceManager.functionApps().listFunctions(functionApp1.resourceGroupName(), functionApp1.name());
        Assertions.assertEquals(1, TestUtilities.getSize(functions));

        functions =
            appServiceManager.functionApps().listFunctions(functionApp2.resourceGroupName(), functionApp2.name());
        Assertions.assertEquals(1, TestUtilities.getSize(functions));

        functions =
            appServiceManager.functionApps().listFunctions(functionApp3.resourceGroupName(), functionApp3.name());
        Assertions.assertEquals(1, TestUtilities.getSize(functions));
    }

    @Test
    public void canCRUDLinuxFunctionAppPremium() {
        rgName2 = null;

        // function app with premium plan
        FunctionApp functionApp1 =
            appServiceManager
                .functionApps()
                .define(webappName1)
                .withRegion(Region.US_EAST)
                .withNewResourceGroup(rgName1)
                .withNewLinuxAppServicePlan(new PricingTier(SkuName.ELASTIC_PREMIUM.toString(), "EP1"))
                .withBuiltInImage(FunctionRuntimeStack.JAVA_8)
                .withHttpsOnly(true)
                .withAppSetting("WEBSITE_RUN_FROM_PACKAGE", FUNCTION_APP_PACKAGE_URL)
                .create();
        Assertions.assertNotNull(functionApp1);
        AppServicePlan plan1 = appServiceManager.appServicePlans().getById(functionApp1.appServicePlanId());
        Assertions.assertNotNull(plan1);
        Assertions.assertEquals(new PricingTier(SkuName.ELASTIC_PREMIUM.toString(), "EP1"), plan1.pricingTier());
        assertLinuxJava(functionApp1, FunctionRuntimeStack.JAVA_8);

        FunctionAppResource functionAppResource1 = getStorageAccount(storageManager, functionApp1);
        // premium plan requires this 2 settings
        Assertions.assertTrue(functionAppResource1.appSettings.containsKey(KEY_CONTENT_AZURE_FILE_CONNECTION_STRING));
        Assertions.assertTrue(functionAppResource1.appSettings.containsKey(KEY_CONTENT_SHARE));

        // wait for deploy
        if (!isPlaybackMode()) {
            ResourceManagerUtils.sleep(Duration.ofMinutes(3));
        }

        // verify deploy
        PagedIterable<FunctionEnvelope> functions =
            appServiceManager.functionApps().listFunctions(functionApp1.resourceGroupName(), functionApp1.name());
        Assertions.assertEquals(1, TestUtilities.getSize(functions));
    }

    @Test
    @Disabled("Need container registry")
    public void canCRUDLinuxFunctionAppPremiumDocker() {
        // function app with premium plan with private docker
        FunctionApp functionApp1 =
            appServiceManager
                .functionApps()
                .define(webappName1)
                .withRegion(Region.US_EAST)
                .withNewResourceGroup(rgName1)
                .withNewLinuxAppServicePlan(new PricingTier(SkuName.ELASTIC_PREMIUM.toString(), "EP1"))
                .withPrivateRegistryImage(
                    "weidxuregistry.azurecr.io/az-func-java:v1", "https://weidxuregistry.azurecr.io")
                .withCredentials("weidxuregistry", "PASSWORD")
                .withRuntime("java")
                .withRuntimeVersion("~3")
                .create();

        // deploy
        if (!isPlaybackMode()) {
            functionApp1.zipDeploy(new File(FunctionAppsTests.class.getResource("/java-functions.zip").getPath()));
        }
    }

    @Test
    public void canCRUDLinuxFunctionAppJava11() throws Exception {
        rgName2 = null;

        String runtimeVersion = "~4";

        // function app with consumption plan
        FunctionApp functionApp1 = appServiceManager.functionApps().define(webappName1)
            .withRegion(Region.US_EAST)
            .withNewResourceGroup(rgName1)
            .withNewLinuxConsumptionPlan()
            .withBuiltInImage(FunctionRuntimeStack.JAVA_11)
            .withRuntimeVersion(runtimeVersion)
            .withHttpsOnly(true)
            .withAppSetting("WEBSITE_RUN_FROM_PACKAGE", FUNCTION_APP_PACKAGE_URL)
            .create();
        Assertions.assertNotNull(functionApp1);
        assertLinuxJava(functionApp1, FunctionRuntimeStack.JAVA_11, runtimeVersion);

        assertRunning(functionApp1);
    }

    @Test
    public void canCRUDLinuxFunctionAppJava17() throws Exception {
        rgName2 = null;

        // function app with consumption plan
        FunctionApp functionApp1 = appServiceManager.functionApps().define(webappName1)
            .withRegion(Region.US_EAST)
            .withNewResourceGroup(rgName1)
            .withNewLinuxConsumptionPlan()
            .withBuiltInImage(FunctionRuntimeStack.JAVA_17)
            .withHttpsOnly(true)
            .withAppSetting("WEBSITE_RUN_FROM_PACKAGE", FUNCTION_APP_PACKAGE_URL)
            .create();
        Assertions.assertNotNull(functionApp1);
        assertLinuxJava(functionApp1, FunctionRuntimeStack.JAVA_17);

        assertRunning(functionApp1);
    }

    private void assertRunning(FunctionApp functionApp) {
        if (!isPlaybackMode()) {
            // wait
            ResourceManagerUtils.sleep(Duration.ofMinutes(1));

            String name = "linux_function_app";
            Response<String> response = curl("https://" + functionApp.defaultHostname()
                + "/api/HttpTrigger-Java?name=" + name);
            Assertions.assertEquals(200, response.getStatusCode());
            String body = response.getValue();
            Assertions.assertNotNull(body);
            Assertions.assertTrue(body.contains("Hello, " + name));
        }
    }

    private static Map<String, AppSetting> assertLinuxJava(FunctionApp functionApp, FunctionRuntimeStack stack) {
        return assertLinuxJava(functionApp, stack, null);
    }

    private static Map<String, AppSetting> assertLinuxJava(FunctionApp functionApp, FunctionRuntimeStack stack,
                                                           String runtimeVersion) {
        Assertions.assertEquals(stack.getLinuxFxVersion(), functionApp.linuxFxVersion());
        Assertions
            .assertTrue(
                Arrays
                    .asList(functionApp.innerModel().kind().split(Pattern.quote(",")))
                    .containsAll(Arrays.asList("linux", "functionapp")));
        Assertions.assertTrue(functionApp.innerModel().reserved());

        Map<String, AppSetting> appSettings = functionApp.getAppSettings();
        Assertions.assertNotNull(appSettings);
        Assertions.assertNotNull(appSettings.get(KEY_AZURE_WEB_JOBS_STORAGE));
        Assertions.assertEquals(
            stack.runtime(),
            appSettings.get(KEY_FUNCTIONS_WORKER_RUNTIME).value());
        Assertions.assertEquals(
            runtimeVersion == null ? stack.version() : runtimeVersion,
            appSettings.get(KEY_FUNCTIONS_EXTENSION_VERSION).value());

        return appSettings;
    }

    private static final String KEY_AZURE_WEB_JOBS_STORAGE = "AzureWebJobsStorage";
    private static final String KEY_CONTENT_AZURE_FILE_CONNECTION_STRING = "WEBSITE_CONTENTAZUREFILECONNECTIONSTRING";
    private static final String KEY_CONTENT_SHARE = "WEBSITE_CONTENTSHARE";
    private static final String KEY_FUNCTIONS_WORKER_RUNTIME = "FUNCTIONS_WORKER_RUNTIME";
    private static final String KEY_FUNCTIONS_EXTENSION_VERSION = "FUNCTIONS_EXTENSION_VERSION";

    private static final String ACCOUNT_NAME_SEGMENT = "AccountName=";
    private static final String ACCOUNT_KEY_SEGMENT = "AccountKey=";

    private static class FunctionAppResource {
        Map<String, AppSetting> appSettings;

        String accountName;
        String accountKey;

        StorageAccount storageAccount;
    }

    private static FunctionAppResource getStorageAccount(StorageManager storageManager, FunctionApp functionApp) {
        FunctionAppResource resource = new FunctionAppResource();
        resource.appSettings = functionApp.getAppSettings();

        String storageAccountConnectionString = resource.appSettings.get(KEY_AZURE_WEB_JOBS_STORAGE).value();
        String[] segments = storageAccountConnectionString.split(";");
        for (String segment : segments) {
            if (segment.startsWith(ACCOUNT_NAME_SEGMENT)) {
                resource.accountName = segment.substring(ACCOUNT_NAME_SEGMENT.length());
            } else if (segment.startsWith(ACCOUNT_KEY_SEGMENT)) {
                resource.accountKey = segment.substring(ACCOUNT_KEY_SEGMENT.length());
            }
        }
        if (resource.accountName != null) {
            PagedIterable<StorageAccount> storageAccounts = storageManager.storageAccounts().list();
            for (StorageAccount storageAccount : storageAccounts) {
                if (resource.accountName.equals(storageAccount.name())) {
                    resource.storageAccount = storageAccount;
                    break;
                }
            }
        }

        return resource;
    }
}
