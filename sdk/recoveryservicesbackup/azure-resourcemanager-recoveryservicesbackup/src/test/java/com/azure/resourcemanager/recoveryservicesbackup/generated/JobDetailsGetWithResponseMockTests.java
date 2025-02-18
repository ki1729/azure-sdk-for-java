// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.recoveryservicesbackup.generated;

import com.azure.core.credential.AccessToken;
import com.azure.core.http.HttpClient;
import com.azure.core.http.HttpHeaders;
import com.azure.core.http.HttpRequest;
import com.azure.core.http.HttpResponse;
import com.azure.core.management.AzureEnvironment;
import com.azure.core.management.profile.AzureProfile;
import com.azure.resourcemanager.recoveryservicesbackup.RecoveryServicesBackupManager;
import com.azure.resourcemanager.recoveryservicesbackup.models.BackupManagementType;
import com.azure.resourcemanager.recoveryservicesbackup.models.JobResource;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public final class JobDetailsGetWithResponseMockTests {
    @Test
    public void testGetWithResponse() throws Exception {
        HttpClient httpClient = Mockito.mock(HttpClient.class);
        HttpResponse httpResponse = Mockito.mock(HttpResponse.class);
        ArgumentCaptor<HttpRequest> httpRequest = ArgumentCaptor.forClass(HttpRequest.class);

        String responseStr =
            "{\"properties\":{\"jobType\":\"Job\",\"entityFriendlyName\":\"qruqguh\",\"backupManagementType\":\"DefaultBackup\",\"operation\":\"tasvvoqs\",\"status\":\"kfla\",\"startTime\":\"2021-06-30T07:43:41Z\",\"endTime\":\"2021-06-04T02:30:32Z\",\"activityId\":\"yao\"},\"eTag\":\"zowpuohdkcprgukx\",\"location\":\"ztiochluti\",\"tags\":{\"crunfhi\":\"rudjizcbfz\",\"mfbcpaqktkrum\":\"c\",\"dkyzbfvxov\":\"u\",\"hyhlwcjsqg\":\"kxiuxqggvqr\"},\"id\":\"jhffbxrqrkij\",\"name\":\"euqlsdxeqztv\",\"type\":\"wmwwmjswen\"}";

        Mockito.when(httpResponse.getStatusCode()).thenReturn(200);
        Mockito.when(httpResponse.getHeaders()).thenReturn(new HttpHeaders());
        Mockito
            .when(httpResponse.getBody())
            .thenReturn(Flux.just(ByteBuffer.wrap(responseStr.getBytes(StandardCharsets.UTF_8))));
        Mockito
            .when(httpResponse.getBodyAsByteArray())
            .thenReturn(Mono.just(responseStr.getBytes(StandardCharsets.UTF_8)));
        Mockito
            .when(httpClient.send(httpRequest.capture(), Mockito.any()))
            .thenReturn(
                Mono
                    .defer(
                        () -> {
                            Mockito.when(httpResponse.getRequest()).thenReturn(httpRequest.getValue());
                            return Mono.just(httpResponse);
                        }));

        RecoveryServicesBackupManager manager =
            RecoveryServicesBackupManager
                .configure()
                .withHttpClient(httpClient)
                .authenticate(
                    tokenRequestContext -> Mono.just(new AccessToken("this_is_a_token", OffsetDateTime.MAX)),
                    new AzureProfile("", "", AzureEnvironment.AZURE));

        JobResource response =
            manager
                .jobDetails()
                .getWithResponse("tlpqagynoi", "rnzcalinc", "yqxzxaqzibmqim", com.azure.core.util.Context.NONE)
                .getValue();

        Assertions.assertEquals("ztiochluti", response.location());
        Assertions.assertEquals("rudjizcbfz", response.tags().get("crunfhi"));
        Assertions.assertEquals("qruqguh", response.properties().entityFriendlyName());
        Assertions.assertEquals(BackupManagementType.DEFAULT_BACKUP, response.properties().backupManagementType());
        Assertions.assertEquals("tasvvoqs", response.properties().operation());
        Assertions.assertEquals("kfla", response.properties().status());
        Assertions.assertEquals(OffsetDateTime.parse("2021-06-30T07:43:41Z"), response.properties().startTime());
        Assertions.assertEquals(OffsetDateTime.parse("2021-06-04T02:30:32Z"), response.properties().endTime());
        Assertions.assertEquals("yao", response.properties().activityId());
        Assertions.assertEquals("zowpuohdkcprgukx", response.etag());
    }
}
