// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.appcontainers.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.appcontainers.models.DiagnosticRendering;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public final class DiagnosticRenderingTests {
    @Test
    public void testDeserialize() {
        DiagnosticRendering model =
            BinaryData
                .fromString(
                    "{\"type\":1644045294,\"title\":\"lmywwtkgkxnyed\",\"description\":\"gyvudtjuewbc\",\"isVisible\":false}")
                .toObject(DiagnosticRendering.class);
        Assertions.assertEquals(1644045294, model.type());
        Assertions.assertEquals("lmywwtkgkxnyed", model.title());
        Assertions.assertEquals("gyvudtjuewbc", model.description());
        Assertions.assertEquals(false, model.isVisible());
    }

    @Test
    public void testSerialize() {
        DiagnosticRendering model =
            new DiagnosticRendering()
                .withType(1644045294)
                .withTitle("lmywwtkgkxnyed")
                .withDescription("gyvudtjuewbc")
                .withIsVisible(false);
        model = BinaryData.fromObject(model).toObject(DiagnosticRendering.class);
        Assertions.assertEquals(1644045294, model.type());
        Assertions.assertEquals("lmywwtkgkxnyed", model.title());
        Assertions.assertEquals("gyvudtjuewbc", model.description());
        Assertions.assertEquals(false, model.isVisible());
    }
}
