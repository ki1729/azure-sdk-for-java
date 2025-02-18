// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.resources.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.resourcemanager.resources.models.LocationMetadata;
import com.azure.resourcemanager.resources.models.LocationType;
import com.fasterxml.jackson.annotation.JsonProperty;

/** Location information. */
@Fluent
public final class LocationInner {
    /*
     * The fully qualified ID of the location. For example,
     * /subscriptions/00000000-0000-0000-0000-000000000000/locations/westus.
     */
    @JsonProperty(value = "id", access = JsonProperty.Access.WRITE_ONLY)
    private String id;

    /*
     * The subscription ID.
     */
    @JsonProperty(value = "subscriptionId", access = JsonProperty.Access.WRITE_ONLY)
    private String subscriptionId;

    /*
     * The location name.
     */
    @JsonProperty(value = "name", access = JsonProperty.Access.WRITE_ONLY)
    private String name;

    /*
     * The location type.
     */
    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY)
    private LocationType type;

    /*
     * The display name of the location.
     */
    @JsonProperty(value = "displayName", access = JsonProperty.Access.WRITE_ONLY)
    private String displayName;

    /*
     * The display name of the location and its region.
     */
    @JsonProperty(value = "regionalDisplayName", access = JsonProperty.Access.WRITE_ONLY)
    private String regionalDisplayName;

    /*
     * Metadata of the location, such as lat/long, paired region, and others.
     */
    @JsonProperty(value = "metadata")
    private LocationMetadata metadata;

    /** Creates an instance of LocationInner class. */
    public LocationInner() {
    }

    /**
     * Get the id property: The fully qualified ID of the location. For example,
     * /subscriptions/00000000-0000-0000-0000-000000000000/locations/westus.
     *
     * @return the id value.
     */
    public String id() {
        return this.id;
    }

    /**
     * Get the subscriptionId property: The subscription ID.
     *
     * @return the subscriptionId value.
     */
    public String subscriptionId() {
        return this.subscriptionId;
    }

    /**
     * Get the name property: The location name.
     *
     * @return the name value.
     */
    public String name() {
        return this.name;
    }

    /**
     * Get the type property: The location type.
     *
     * @return the type value.
     */
    public LocationType type() {
        return this.type;
    }

    /**
     * Get the displayName property: The display name of the location.
     *
     * @return the displayName value.
     */
    public String displayName() {
        return this.displayName;
    }

    /**
     * Get the regionalDisplayName property: The display name of the location and its region.
     *
     * @return the regionalDisplayName value.
     */
    public String regionalDisplayName() {
        return this.regionalDisplayName;
    }

    /**
     * Get the metadata property: Metadata of the location, such as lat/long, paired region, and others.
     *
     * @return the metadata value.
     */
    public LocationMetadata metadata() {
        return this.metadata;
    }

    /**
     * Set the metadata property: Metadata of the location, such as lat/long, paired region, and others.
     *
     * @param metadata the metadata value to set.
     * @return the LocationInner object itself.
     */
    public LocationInner withMetadata(LocationMetadata metadata) {
        this.metadata = metadata;
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (metadata() != null) {
            metadata().validate();
        }
    }
}
