// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.network.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.management.SubResource;
import com.fasterxml.jackson.annotation.JsonProperty;

/** The effective network security group association. */
@Fluent
public final class EffectiveNetworkSecurityGroupAssociation {
    /*
     * The ID of the Azure network manager if assigned.
     */
    @JsonProperty(value = "networkManager")
    private SubResource networkManager;

    /*
     * The ID of the subnet if assigned.
     */
    @JsonProperty(value = "subnet")
    private SubResource subnet;

    /*
     * The ID of the network interface if assigned.
     */
    @JsonProperty(value = "networkInterface")
    private SubResource networkInterface;

    /** Creates an instance of EffectiveNetworkSecurityGroupAssociation class. */
    public EffectiveNetworkSecurityGroupAssociation() {
    }

    /**
     * Get the networkManager property: The ID of the Azure network manager if assigned.
     *
     * @return the networkManager value.
     */
    public SubResource networkManager() {
        return this.networkManager;
    }

    /**
     * Set the networkManager property: The ID of the Azure network manager if assigned.
     *
     * @param networkManager the networkManager value to set.
     * @return the EffectiveNetworkSecurityGroupAssociation object itself.
     */
    public EffectiveNetworkSecurityGroupAssociation withNetworkManager(SubResource networkManager) {
        this.networkManager = networkManager;
        return this;
    }

    /**
     * Get the subnet property: The ID of the subnet if assigned.
     *
     * @return the subnet value.
     */
    public SubResource subnet() {
        return this.subnet;
    }

    /**
     * Set the subnet property: The ID of the subnet if assigned.
     *
     * @param subnet the subnet value to set.
     * @return the EffectiveNetworkSecurityGroupAssociation object itself.
     */
    public EffectiveNetworkSecurityGroupAssociation withSubnet(SubResource subnet) {
        this.subnet = subnet;
        return this;
    }

    /**
     * Get the networkInterface property: The ID of the network interface if assigned.
     *
     * @return the networkInterface value.
     */
    public SubResource networkInterface() {
        return this.networkInterface;
    }

    /**
     * Set the networkInterface property: The ID of the network interface if assigned.
     *
     * @param networkInterface the networkInterface value to set.
     * @return the EffectiveNetworkSecurityGroupAssociation object itself.
     */
    public EffectiveNetworkSecurityGroupAssociation withNetworkInterface(SubResource networkInterface) {
        this.networkInterface = networkInterface;
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
    }
}
