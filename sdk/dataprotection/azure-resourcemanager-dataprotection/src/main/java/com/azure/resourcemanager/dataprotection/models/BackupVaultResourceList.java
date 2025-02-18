// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.dataprotection.models;

import com.azure.core.annotation.Fluent;
import com.azure.resourcemanager.dataprotection.fluent.models.BackupVaultResourceInner;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 * BackupVaultResourceList
 *
 * <p>List of BackupVault resources.
 */
@Fluent
public final class BackupVaultResourceList extends DppResourceList {
    /*
     * List of resources.
     */
    @JsonProperty(value = "value")
    private List<BackupVaultResourceInner> value;

    /** Creates an instance of BackupVaultResourceList class. */
    public BackupVaultResourceList() {
    }

    /**
     * Get the value property: List of resources.
     *
     * @return the value value.
     */
    public List<BackupVaultResourceInner> value() {
        return this.value;
    }

    /**
     * Set the value property: List of resources.
     *
     * @param value the value value to set.
     * @return the BackupVaultResourceList object itself.
     */
    public BackupVaultResourceList withValue(List<BackupVaultResourceInner> value) {
        this.value = value;
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public BackupVaultResourceList withNextLink(String nextLink) {
        super.withNextLink(nextLink);
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    @Override
    public void validate() {
        super.validate();
        if (value() != null) {
            value().forEach(e -> e.validate());
        }
    }
}
