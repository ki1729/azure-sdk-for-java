// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.recoveryservicesbackup.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.recoveryservicesbackup.models.ContainerIdentityInfo;
import com.azure.resourcemanager.recoveryservicesbackup.models.GenericContainerExtendedInfo;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Assertions;

public final class GenericContainerExtendedInfoTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        GenericContainerExtendedInfo model =
            BinaryData
                .fromString(
                    "{\"rawCertData\":\"sjvh\",\"containerIdentityInfo\":{\"uniqueName\":\"ftkwq\",\"aadTenantId\":\"pmvssehaep\",\"servicePrincipalClientId\":\"mcxtczhu\",\"audience\":\"uknijduyye\"},\"serviceEndpoints\":{\"hulrtywikdmhla\":\"djfbocyv\",\"ufr\":\"uflgbhgauacdixm\"}}")
                .toObject(GenericContainerExtendedInfo.class);
        Assertions.assertEquals("sjvh", model.rawCertData());
        Assertions.assertEquals("ftkwq", model.containerIdentityInfo().uniqueName());
        Assertions.assertEquals("pmvssehaep", model.containerIdentityInfo().aadTenantId());
        Assertions.assertEquals("mcxtczhu", model.containerIdentityInfo().servicePrincipalClientId());
        Assertions.assertEquals("uknijduyye", model.containerIdentityInfo().audience());
        Assertions.assertEquals("djfbocyv", model.serviceEndpoints().get("hulrtywikdmhla"));
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        GenericContainerExtendedInfo model =
            new GenericContainerExtendedInfo()
                .withRawCertData("sjvh")
                .withContainerIdentityInfo(
                    new ContainerIdentityInfo()
                        .withUniqueName("ftkwq")
                        .withAadTenantId("pmvssehaep")
                        .withServicePrincipalClientId("mcxtczhu")
                        .withAudience("uknijduyye"))
                .withServiceEndpoints(mapOf("hulrtywikdmhla", "djfbocyv", "ufr", "uflgbhgauacdixm"));
        model = BinaryData.fromObject(model).toObject(GenericContainerExtendedInfo.class);
        Assertions.assertEquals("sjvh", model.rawCertData());
        Assertions.assertEquals("ftkwq", model.containerIdentityInfo().uniqueName());
        Assertions.assertEquals("pmvssehaep", model.containerIdentityInfo().aadTenantId());
        Assertions.assertEquals("mcxtczhu", model.containerIdentityInfo().servicePrincipalClientId());
        Assertions.assertEquals("uknijduyye", model.containerIdentityInfo().audience());
        Assertions.assertEquals("djfbocyv", model.serviceEndpoints().get("hulrtywikdmhla"));
    }

    @SuppressWarnings("unchecked")
    private static <T> Map<String, T> mapOf(Object... inputs) {
        Map<String, T> map = new HashMap<>();
        for (int i = 0; i < inputs.length; i += 2) {
            String key = (String) inputs[i];
            T value = (T) inputs[i + 1];
            map.put(key, value);
        }
        return map;
    }
}
