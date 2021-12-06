// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.compute.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/** This is the data disk image. */
@Fluent
public final class GalleryDataDiskImage extends GalleryDiskImage {
    @JsonIgnore private final ClientLogger logger = new ClientLogger(GalleryDataDiskImage.class);

    /*
     * This property specifies the logical unit number of the data disk. This
     * value is used to identify data disks within the Virtual Machine and
     * therefore must be unique for each data disk attached to the Virtual
     * Machine.
     */
    @JsonProperty(value = "lun", required = true)
    private int lun;

    /**
     * Get the lun property: This property specifies the logical unit number of the data disk. This value is used to
     * identify data disks within the Virtual Machine and therefore must be unique for each data disk attached to the
     * Virtual Machine.
     *
     * @return the lun value.
     */
    public int lun() {
        return this.lun;
    }

    /**
     * Set the lun property: This property specifies the logical unit number of the data disk. This value is used to
     * identify data disks within the Virtual Machine and therefore must be unique for each data disk attached to the
     * Virtual Machine.
     *
     * @param lun the lun value to set.
     * @return the GalleryDataDiskImage object itself.
     */
    public GalleryDataDiskImage withLun(int lun) {
        this.lun = lun;
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public GalleryDataDiskImage withHostCaching(HostCaching hostCaching) {
        super.withHostCaching(hostCaching);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public GalleryDataDiskImage withSource(GalleryArtifactVersionSource source) {
        super.withSource(source);
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
    }
}