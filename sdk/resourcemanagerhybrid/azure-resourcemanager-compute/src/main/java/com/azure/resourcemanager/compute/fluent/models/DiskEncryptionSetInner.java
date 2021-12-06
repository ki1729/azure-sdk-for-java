// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.compute.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.management.Resource;
import com.azure.core.util.logging.ClientLogger;
import com.azure.resourcemanager.compute.models.EncryptionSetIdentity;
import com.azure.resourcemanager.compute.models.KeyVaultAndKeyReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Map;

/** disk encryption set resource. */
@Fluent
public final class DiskEncryptionSetInner extends Resource {
    @JsonIgnore private final ClientLogger logger = new ClientLogger(DiskEncryptionSetInner.class);

    /*
     * The managed identity for the disk encryption set. It should be given
     * permission on the key vault before it can be used to encrypt disks.
     */
    @JsonProperty(value = "identity")
    private EncryptionSetIdentity identity;

    /*
     * The properties property.
     */
    @JsonProperty(value = "properties")
    private EncryptionSetProperties innerProperties;

    /**
     * Get the identity property: The managed identity for the disk encryption set. It should be given permission on the
     * key vault before it can be used to encrypt disks.
     *
     * @return the identity value.
     */
    public EncryptionSetIdentity identity() {
        return this.identity;
    }

    /**
     * Set the identity property: The managed identity for the disk encryption set. It should be given permission on the
     * key vault before it can be used to encrypt disks.
     *
     * @param identity the identity value to set.
     * @return the DiskEncryptionSetInner object itself.
     */
    public DiskEncryptionSetInner withIdentity(EncryptionSetIdentity identity) {
        this.identity = identity;
        return this;
    }

    /**
     * Get the innerProperties property: The properties property.
     *
     * @return the innerProperties value.
     */
    private EncryptionSetProperties innerProperties() {
        return this.innerProperties;
    }

    /** {@inheritDoc} */
    @Override
    public DiskEncryptionSetInner withLocation(String location) {
        super.withLocation(location);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public DiskEncryptionSetInner withTags(Map<String, String> tags) {
        super.withTags(tags);
        return this;
    }

    /**
     * Get the activeKey property: The key vault key which is currently used by this disk encryption set.
     *
     * @return the activeKey value.
     */
    public KeyVaultAndKeyReference activeKey() {
        return this.innerProperties() == null ? null : this.innerProperties().activeKey();
    }

    /**
     * Set the activeKey property: The key vault key which is currently used by this disk encryption set.
     *
     * @param activeKey the activeKey value to set.
     * @return the DiskEncryptionSetInner object itself.
     */
    public DiskEncryptionSetInner withActiveKey(KeyVaultAndKeyReference activeKey) {
        if (this.innerProperties() == null) {
            this.innerProperties = new EncryptionSetProperties();
        }
        this.innerProperties().withActiveKey(activeKey);
        return this;
    }

    /**
     * Get the previousKeys property: A readonly collection of key vault keys previously used by this disk encryption
     * set while a key rotation is in progress. It will be empty if there is no ongoing key rotation.
     *
     * @return the previousKeys value.
     */
    public List<KeyVaultAndKeyReference> previousKeys() {
        return this.innerProperties() == null ? null : this.innerProperties().previousKeys();
    }

    /**
     * Get the provisioningState property: The disk encryption set provisioning state.
     *
     * @return the provisioningState value.
     */
    public String provisioningState() {
        return this.innerProperties() == null ? null : this.innerProperties().provisioningState();
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (identity() != null) {
            identity().validate();
        }
        if (innerProperties() != null) {
            innerProperties().validate();
        }
    }
}