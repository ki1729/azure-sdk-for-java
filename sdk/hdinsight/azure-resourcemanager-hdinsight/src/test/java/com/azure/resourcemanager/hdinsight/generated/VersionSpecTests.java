// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.hdinsight.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.hdinsight.models.VersionSpec;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public final class VersionSpecTests {
    @Test
    public void testDeserialize() {
        VersionSpec model =
            BinaryData
                .fromString(
                    "{\"friendlyName\":\"rdvstkwqqtch\",\"displayName\":\"lmfmtdaay\",\"isDefault\":false,\"componentVersions\":{\"xg\":\"gpiohgwxrtfudxe\",\"pkukghi\":\"qagvrvm\",\"wi\":\"dblx\"}}")
                .toObject(VersionSpec.class);
        Assertions.assertEquals("rdvstkwqqtch", model.friendlyName());
        Assertions.assertEquals("lmfmtdaay", model.displayName());
        Assertions.assertEquals(false, model.isDefault());
        Assertions.assertEquals("gpiohgwxrtfudxe", model.componentVersions().get("xg"));
    }

    @Test
    public void testSerialize() {
        VersionSpec model =
            new VersionSpec()
                .withFriendlyName("rdvstkwqqtch")
                .withDisplayName("lmfmtdaay")
                .withIsDefault(false)
                .withComponentVersions(mapOf("xg", "gpiohgwxrtfudxe", "pkukghi", "qagvrvm", "wi", "dblx"));
        model = BinaryData.fromObject(model).toObject(VersionSpec.class);
        Assertions.assertEquals("rdvstkwqqtch", model.friendlyName());
        Assertions.assertEquals("lmfmtdaay", model.displayName());
        Assertions.assertEquals(false, model.isDefault());
        Assertions.assertEquals("gpiohgwxrtfudxe", model.componentVersions().get("xg"));
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
