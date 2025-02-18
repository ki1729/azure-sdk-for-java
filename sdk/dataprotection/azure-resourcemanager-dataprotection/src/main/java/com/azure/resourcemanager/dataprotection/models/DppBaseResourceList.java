// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.dataprotection.models;

import com.azure.core.annotation.Fluent;
import com.azure.resourcemanager.dataprotection.fluent.models.DppBaseResourceInner;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/** Base for all lists of V2 resources. */
@Fluent
public final class DppBaseResourceList {
    /*
     * List of Dpp resources.
     */
    @JsonProperty(value = "value")
    private List<DppBaseResourceInner> value;

    /*
     * The uri to fetch the next page of resources. Call ListNext() fetches next page of resources.
     */
    @JsonProperty(value = "nextLink")
    private String nextLink;

    /** Creates an instance of DppBaseResourceList class. */
    public DppBaseResourceList() {
    }

    /**
     * Get the value property: List of Dpp resources.
     *
     * @return the value value.
     */
    public List<DppBaseResourceInner> value() {
        return this.value;
    }

    /**
     * Set the value property: List of Dpp resources.
     *
     * @param value the value value to set.
     * @return the DppBaseResourceList object itself.
     */
    public DppBaseResourceList withValue(List<DppBaseResourceInner> value) {
        this.value = value;
        return this;
    }

    /**
     * Get the nextLink property: The uri to fetch the next page of resources. Call ListNext() fetches next page of
     * resources.
     *
     * @return the nextLink value.
     */
    public String nextLink() {
        return this.nextLink;
    }

    /**
     * Set the nextLink property: The uri to fetch the next page of resources. Call ListNext() fetches next page of
     * resources.
     *
     * @param nextLink the nextLink value to set.
     * @return the DppBaseResourceList object itself.
     */
    public DppBaseResourceList withNextLink(String nextLink) {
        this.nextLink = nextLink;
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (value() != null) {
            value().forEach(e -> e.validate());
        }
    }
}
