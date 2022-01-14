// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.containerregistry.models;

import com.azure.core.util.ExpandableStringEnum;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.Collection;

/** Defines values for ZoneRedundancy. */
public final class ZoneRedundancy extends ExpandableStringEnum<ZoneRedundancy> {
    /** Static value Enabled for ZoneRedundancy. */
    public static final ZoneRedundancy ENABLED = fromString("Enabled");

    /** Static value Disabled for ZoneRedundancy. */
    public static final ZoneRedundancy DISABLED = fromString("Disabled");

    /**
     * Creates or finds a ZoneRedundancy from its string representation.
     *
     * @param name a name to look for.
     * @return the corresponding ZoneRedundancy.
     */
    @JsonCreator
    public static ZoneRedundancy fromString(String name) {
        return fromString(name, ZoneRedundancy.class);
    }

    /** @return known ZoneRedundancy values. */
    public static Collection<ZoneRedundancy> values() {
        return values(ZoneRedundancy.class);
    }
}