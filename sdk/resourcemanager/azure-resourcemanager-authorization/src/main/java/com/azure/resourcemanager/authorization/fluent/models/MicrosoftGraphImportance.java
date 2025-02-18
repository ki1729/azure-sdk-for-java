// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.authorization.fluent.models;

import com.azure.core.util.ExpandableStringEnum;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.Collection;

/** importance. */
public final class MicrosoftGraphImportance extends ExpandableStringEnum<MicrosoftGraphImportance> {
    /** Static value low for MicrosoftGraphImportance. */
    public static final MicrosoftGraphImportance LOW = fromString("low");

    /** Static value normal for MicrosoftGraphImportance. */
    public static final MicrosoftGraphImportance NORMAL = fromString("normal");

    /** Static value high for MicrosoftGraphImportance. */
    public static final MicrosoftGraphImportance HIGH = fromString("high");

    /**
     * Creates or finds a MicrosoftGraphImportance from its string representation.
     *
     * @param name a name to look for.
     * @return the corresponding MicrosoftGraphImportance.
     */
    @JsonCreator
    public static MicrosoftGraphImportance fromString(String name) {
        return fromString(name, MicrosoftGraphImportance.class);
    }

    /**
     * Gets known MicrosoftGraphImportance values.
     *
     * @return known MicrosoftGraphImportance values.
     */
    public static Collection<MicrosoftGraphImportance> values() {
        return values(MicrosoftGraphImportance.class);
    }
}
