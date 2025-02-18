// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.cdn.models;

import com.azure.core.util.ExpandableStringEnum;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.Collection;

/** Resource status of the endpoint. */
public final class EndpointResourceState extends ExpandableStringEnum<EndpointResourceState> {
    /** Static value Creating for EndpointResourceState. */
    public static final EndpointResourceState CREATING = fromString("Creating");

    /** Static value Deleting for EndpointResourceState. */
    public static final EndpointResourceState DELETING = fromString("Deleting");

    /** Static value Running for EndpointResourceState. */
    public static final EndpointResourceState RUNNING = fromString("Running");

    /** Static value Starting for EndpointResourceState. */
    public static final EndpointResourceState STARTING = fromString("Starting");

    /** Static value Stopped for EndpointResourceState. */
    public static final EndpointResourceState STOPPED = fromString("Stopped");

    /** Static value Stopping for EndpointResourceState. */
    public static final EndpointResourceState STOPPING = fromString("Stopping");

    /**
     * Creates or finds a EndpointResourceState from its string representation.
     *
     * @param name a name to look for.
     * @return the corresponding EndpointResourceState.
     */
    @JsonCreator
    public static EndpointResourceState fromString(String name) {
        return fromString(name, EndpointResourceState.class);
    }

    /**
     * Gets known EndpointResourceState values.
     *
     * @return known EndpointResourceState values.
     */
    public static Collection<EndpointResourceState> values() {
        return values(EndpointResourceState.class);
    }
}
