// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.security.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.security.fluent.models.AdaptiveApplicationControlGroupInner;
import com.azure.resourcemanager.security.fluent.models.AdaptiveApplicationControlGroupsInner;
import com.azure.resourcemanager.security.models.EnforcementMode;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;

public final class AdaptiveApplicationControlGroupsInnerTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        AdaptiveApplicationControlGroupsInner model =
            BinaryData
                .fromString(
                    "{\"value\":[{\"properties\":{\"enforcementMode\":\"Audit\",\"configurationStatus\":\"InProgress\",\"recommendationStatus\":\"Recommended\",\"issues\":[],\"sourceSystem\":\"None\",\"vmRecommendations\":[],\"pathRecommendations\":[]},\"location\":\"cojocqwogfnzjvus\",\"id\":\"zldmozuxy\",\"name\":\"fsbtkad\",\"type\":\"ysownbtgkbug\"},{\"properties\":{\"enforcementMode\":\"Enforce\",\"configurationStatus\":\"Failed\",\"recommendationStatus\":\"NotRecommended\",\"issues\":[],\"sourceSystem\":\"None\",\"vmRecommendations\":[],\"pathRecommendations\":[]},\"location\":\"eypefojyqd\",\"id\":\"cuplcplcwkhih\",\"name\":\"hlhzdsqtzbsrgno\",\"type\":\"cjhfgmvecactxmw\"},{\"properties\":{\"enforcementMode\":\"None\",\"configurationStatus\":\"InProgress\",\"recommendationStatus\":\"NotAvailable\",\"issues\":[],\"sourceSystem\":\"Azure_AppLocker\",\"vmRecommendations\":[],\"pathRecommendations\":[]},\"location\":\"qvgqouw\",\"id\":\"fzmpjwyivq\",\"name\":\"kfxcvhrfs\",\"type\":\"huagrttikteusqc\"},{\"properties\":{\"enforcementMode\":\"Audit\",\"configurationStatus\":\"Failed\",\"recommendationStatus\":\"NotAvailable\",\"issues\":[],\"sourceSystem\":\"NonAzure_AuditD\",\"vmRecommendations\":[],\"pathRecommendations\":[]},\"location\":\"mmfblcqcuubgqib\",\"id\":\"talmett\",\"name\":\"wgdsl\",\"type\":\"xih\"}]}")
                .toObject(AdaptiveApplicationControlGroupsInner.class);
        Assertions.assertEquals(EnforcementMode.AUDIT, model.value().get(0).enforcementMode());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        AdaptiveApplicationControlGroupsInner model =
            new AdaptiveApplicationControlGroupsInner()
                .withValue(
                    Arrays
                        .asList(
                            new AdaptiveApplicationControlGroupInner()
                                .withEnforcementMode(EnforcementMode.AUDIT)
                                .withVmRecommendations(Arrays.asList())
                                .withPathRecommendations(Arrays.asList()),
                            new AdaptiveApplicationControlGroupInner()
                                .withEnforcementMode(EnforcementMode.ENFORCE)
                                .withVmRecommendations(Arrays.asList())
                                .withPathRecommendations(Arrays.asList()),
                            new AdaptiveApplicationControlGroupInner()
                                .withEnforcementMode(EnforcementMode.NONE)
                                .withVmRecommendations(Arrays.asList())
                                .withPathRecommendations(Arrays.asList()),
                            new AdaptiveApplicationControlGroupInner()
                                .withEnforcementMode(EnforcementMode.AUDIT)
                                .withVmRecommendations(Arrays.asList())
                                .withPathRecommendations(Arrays.asList())));
        model = BinaryData.fromObject(model).toObject(AdaptiveApplicationControlGroupsInner.class);
        Assertions.assertEquals(EnforcementMode.AUDIT, model.value().get(0).enforcementMode());
    }
}
