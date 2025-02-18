// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.security.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.security.fluent.models.ApiCollectionResponseInner;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Assertions;

public final class ApiCollectionResponseInnerTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        ApiCollectionResponseInner model =
            BinaryData
                .fromString(
                    "{\"properties\":{\"displayName\":\"qxuwyvca\",\"additionalData\":{\"vbsizusjszlbscm\":\"v\"}},\"id\":\"lzijiufehgmvflnw\",\"name\":\"v\",\"type\":\"kxrerlniylylyfwx\"}")
                .toObject(ApiCollectionResponseInner.class);
        Assertions.assertEquals("qxuwyvca", model.displayName());
        Assertions.assertEquals("v", model.additionalData().get("vbsizusjszlbscm"));
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        ApiCollectionResponseInner model =
            new ApiCollectionResponseInner()
                .withDisplayName("qxuwyvca")
                .withAdditionalData(mapOf("vbsizusjszlbscm", "v"));
        model = BinaryData.fromObject(model).toObject(ApiCollectionResponseInner.class);
        Assertions.assertEquals("qxuwyvca", model.displayName());
        Assertions.assertEquals("v", model.additionalData().get("vbsizusjszlbscm"));
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
