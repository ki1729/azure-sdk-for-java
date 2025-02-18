// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.security.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.security.fluent.models.JitNetworkAccessRequestInner;
import com.azure.resourcemanager.security.models.JitNetworkAccessRequestVirtualMachine;
import java.time.OffsetDateTime;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;

public final class JitNetworkAccessRequestInnerTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        JitNetworkAccessRequestInner model =
            BinaryData
                .fromString(
                    "{\"virtualMachines\":[{\"id\":\"tmwwi\",\"ports\":[]},{\"id\":\"ehfqpofvwbc\",\"ports\":[]}],\"startTimeUtc\":\"2021-02-06T20:45:07Z\",\"requestor\":\"mbnkb\",\"justification\":\"qvxkd\"}")
                .toObject(JitNetworkAccessRequestInner.class);
        Assertions.assertEquals("tmwwi", model.virtualMachines().get(0).id());
        Assertions.assertEquals(OffsetDateTime.parse("2021-02-06T20:45:07Z"), model.startTimeUtc());
        Assertions.assertEquals("mbnkb", model.requestor());
        Assertions.assertEquals("qvxkd", model.justification());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        JitNetworkAccessRequestInner model =
            new JitNetworkAccessRequestInner()
                .withVirtualMachines(
                    Arrays
                        .asList(
                            new JitNetworkAccessRequestVirtualMachine().withId("tmwwi").withPorts(Arrays.asList()),
                            new JitNetworkAccessRequestVirtualMachine()
                                .withId("ehfqpofvwbc")
                                .withPorts(Arrays.asList())))
                .withStartTimeUtc(OffsetDateTime.parse("2021-02-06T20:45:07Z"))
                .withRequestor("mbnkb")
                .withJustification("qvxkd");
        model = BinaryData.fromObject(model).toObject(JitNetworkAccessRequestInner.class);
        Assertions.assertEquals("tmwwi", model.virtualMachines().get(0).id());
        Assertions.assertEquals(OffsetDateTime.parse("2021-02-06T20:45:07Z"), model.startTimeUtc());
        Assertions.assertEquals("mbnkb", model.requestor());
        Assertions.assertEquals("qvxkd", model.justification());
    }
}
