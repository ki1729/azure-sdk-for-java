// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.devcenter.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.devcenter.fluent.models.AttachedNetworkConnectionInner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public final class AttachedNetworkConnectionInnerTests {
    @Test
    public void testDeserialize() {
        AttachedNetworkConnectionInner model =
            BinaryData
                .fromString(
                    "{\"properties\":{\"provisioningState\":\"Deleted\",\"networkConnectionId\":\"od\",\"networkConnectionLocation\":\"hc\",\"healthCheckStatus\":\"Passed\",\"domainJoinType\":\"HybridAzureADJoin\"},\"id\":\"t\",\"name\":\"kwh\",\"type\":\"soifiyipjxsqw\"}")
                .toObject(AttachedNetworkConnectionInner.class);
        Assertions.assertEquals("od", model.networkConnectionId());
    }

    @Test
    public void testSerialize() {
        AttachedNetworkConnectionInner model = new AttachedNetworkConnectionInner().withNetworkConnectionId("od");
        model = BinaryData.fromObject(model).toObject(AttachedNetworkConnectionInner.class);
        Assertions.assertEquals("od", model.networkConnectionId());
    }
}
