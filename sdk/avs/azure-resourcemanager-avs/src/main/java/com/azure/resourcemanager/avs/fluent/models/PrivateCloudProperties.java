// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.avs.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.azure.resourcemanager.avs.models.AvailabilityProperties;
import com.azure.resourcemanager.avs.models.Circuit;
import com.azure.resourcemanager.avs.models.Encryption;
import com.azure.resourcemanager.avs.models.Endpoints;
import com.azure.resourcemanager.avs.models.IdentitySource;
import com.azure.resourcemanager.avs.models.InternetEnum;
import com.azure.resourcemanager.avs.models.ManagementCluster;
import com.azure.resourcemanager.avs.models.PrivateCloudProvisioningState;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/** The properties of a private cloud resource. */
@Fluent
public final class PrivateCloudProperties extends PrivateCloudUpdateProperties {
    @JsonIgnore private final ClientLogger logger = new ClientLogger(PrivateCloudProperties.class);

    /*
     * The provisioning state
     */
    @JsonProperty(value = "provisioningState", access = JsonProperty.Access.WRITE_ONLY)
    private PrivateCloudProvisioningState provisioningState;

    /*
     * An ExpressRoute Circuit
     */
    @JsonProperty(value = "circuit")
    private Circuit circuit;

    /*
     * The endpoints
     */
    @JsonProperty(value = "endpoints", access = JsonProperty.Access.WRITE_ONLY)
    private Endpoints endpoints;

    /*
     * The block of addresses should be unique across VNet in your subscription
     * as well as on-premise. Make sure the CIDR format is conformed to
     * (A.B.C.D/X) where A,B,C,D are between 0 and 255, and X is between 0 and
     * 22
     */
    @JsonProperty(value = "networkBlock", required = true)
    private String networkBlock;

    /*
     * Network used to access vCenter Server and NSX-T Manager
     */
    @JsonProperty(value = "managementNetwork", access = JsonProperty.Access.WRITE_ONLY)
    private String managementNetwork;

    /*
     * Used for virtual machine cold migration, cloning, and snapshot migration
     */
    @JsonProperty(value = "provisioningNetwork", access = JsonProperty.Access.WRITE_ONLY)
    private String provisioningNetwork;

    /*
     * Used for live migration of virtual machines
     */
    @JsonProperty(value = "vmotionNetwork", access = JsonProperty.Access.WRITE_ONLY)
    private String vmotionNetwork;

    /*
     * Optionally, set the vCenter admin password when the private cloud is
     * created
     */
    @JsonProperty(value = "vcenterPassword")
    private String vcenterPassword;

    /*
     * Optionally, set the NSX-T Manager password when the private cloud is
     * created
     */
    @JsonProperty(value = "nsxtPassword")
    private String nsxtPassword;

    /*
     * Thumbprint of the vCenter Server SSL certificate
     */
    @JsonProperty(value = "vcenterCertificateThumbprint", access = JsonProperty.Access.WRITE_ONLY)
    private String vcenterCertificateThumbprint;

    /*
     * Thumbprint of the NSX-T Manager SSL certificate
     */
    @JsonProperty(value = "nsxtCertificateThumbprint", access = JsonProperty.Access.WRITE_ONLY)
    private String nsxtCertificateThumbprint;

    /*
     * Array of cloud link IDs from other clouds that connect to this one
     */
    @JsonProperty(value = "externalCloudLinks", access = JsonProperty.Access.WRITE_ONLY)
    private List<String> externalCloudLinks;

    /*
     * A secondary expressRoute circuit from a separate AZ. Only present in a
     * stretched private cloud
     */
    @JsonProperty(value = "secondaryCircuit")
    private Circuit secondaryCircuit;

    /**
     * Get the provisioningState property: The provisioning state.
     *
     * @return the provisioningState value.
     */
    public PrivateCloudProvisioningState provisioningState() {
        return this.provisioningState;
    }

    /**
     * Get the circuit property: An ExpressRoute Circuit.
     *
     * @return the circuit value.
     */
    public Circuit circuit() {
        return this.circuit;
    }

    /**
     * Set the circuit property: An ExpressRoute Circuit.
     *
     * @param circuit the circuit value to set.
     * @return the PrivateCloudProperties object itself.
     */
    public PrivateCloudProperties withCircuit(Circuit circuit) {
        this.circuit = circuit;
        return this;
    }

    /**
     * Get the endpoints property: The endpoints.
     *
     * @return the endpoints value.
     */
    public Endpoints endpoints() {
        return this.endpoints;
    }

    /**
     * Get the networkBlock property: The block of addresses should be unique across VNet in your subscription as well
     * as on-premise. Make sure the CIDR format is conformed to (A.B.C.D/X) where A,B,C,D are between 0 and 255, and X
     * is between 0 and 22.
     *
     * @return the networkBlock value.
     */
    public String networkBlock() {
        return this.networkBlock;
    }

    /**
     * Set the networkBlock property: The block of addresses should be unique across VNet in your subscription as well
     * as on-premise. Make sure the CIDR format is conformed to (A.B.C.D/X) where A,B,C,D are between 0 and 255, and X
     * is between 0 and 22.
     *
     * @param networkBlock the networkBlock value to set.
     * @return the PrivateCloudProperties object itself.
     */
    public PrivateCloudProperties withNetworkBlock(String networkBlock) {
        this.networkBlock = networkBlock;
        return this;
    }

    /**
     * Get the managementNetwork property: Network used to access vCenter Server and NSX-T Manager.
     *
     * @return the managementNetwork value.
     */
    public String managementNetwork() {
        return this.managementNetwork;
    }

    /**
     * Get the provisioningNetwork property: Used for virtual machine cold migration, cloning, and snapshot migration.
     *
     * @return the provisioningNetwork value.
     */
    public String provisioningNetwork() {
        return this.provisioningNetwork;
    }

    /**
     * Get the vmotionNetwork property: Used for live migration of virtual machines.
     *
     * @return the vmotionNetwork value.
     */
    public String vmotionNetwork() {
        return this.vmotionNetwork;
    }

    /**
     * Get the vcenterPassword property: Optionally, set the vCenter admin password when the private cloud is created.
     *
     * @return the vcenterPassword value.
     */
    public String vcenterPassword() {
        return this.vcenterPassword;
    }

    /**
     * Set the vcenterPassword property: Optionally, set the vCenter admin password when the private cloud is created.
     *
     * @param vcenterPassword the vcenterPassword value to set.
     * @return the PrivateCloudProperties object itself.
     */
    public PrivateCloudProperties withVcenterPassword(String vcenterPassword) {
        this.vcenterPassword = vcenterPassword;
        return this;
    }

    /**
     * Get the nsxtPassword property: Optionally, set the NSX-T Manager password when the private cloud is created.
     *
     * @return the nsxtPassword value.
     */
    public String nsxtPassword() {
        return this.nsxtPassword;
    }

    /**
     * Set the nsxtPassword property: Optionally, set the NSX-T Manager password when the private cloud is created.
     *
     * @param nsxtPassword the nsxtPassword value to set.
     * @return the PrivateCloudProperties object itself.
     */
    public PrivateCloudProperties withNsxtPassword(String nsxtPassword) {
        this.nsxtPassword = nsxtPassword;
        return this;
    }

    /**
     * Get the vcenterCertificateThumbprint property: Thumbprint of the vCenter Server SSL certificate.
     *
     * @return the vcenterCertificateThumbprint value.
     */
    public String vcenterCertificateThumbprint() {
        return this.vcenterCertificateThumbprint;
    }

    /**
     * Get the nsxtCertificateThumbprint property: Thumbprint of the NSX-T Manager SSL certificate.
     *
     * @return the nsxtCertificateThumbprint value.
     */
    public String nsxtCertificateThumbprint() {
        return this.nsxtCertificateThumbprint;
    }

    /**
     * Get the externalCloudLinks property: Array of cloud link IDs from other clouds that connect to this one.
     *
     * @return the externalCloudLinks value.
     */
    public List<String> externalCloudLinks() {
        return this.externalCloudLinks;
    }

    /**
     * Get the secondaryCircuit property: A secondary expressRoute circuit from a separate AZ. Only present in a
     * stretched private cloud.
     *
     * @return the secondaryCircuit value.
     */
    public Circuit secondaryCircuit() {
        return this.secondaryCircuit;
    }

    /**
     * Set the secondaryCircuit property: A secondary expressRoute circuit from a separate AZ. Only present in a
     * stretched private cloud.
     *
     * @param secondaryCircuit the secondaryCircuit value to set.
     * @return the PrivateCloudProperties object itself.
     */
    public PrivateCloudProperties withSecondaryCircuit(Circuit secondaryCircuit) {
        this.secondaryCircuit = secondaryCircuit;
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public PrivateCloudProperties withManagementCluster(ManagementCluster managementCluster) {
        super.withManagementCluster(managementCluster);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public PrivateCloudProperties withInternet(InternetEnum internet) {
        super.withInternet(internet);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public PrivateCloudProperties withIdentitySources(List<IdentitySource> identitySources) {
        super.withIdentitySources(identitySources);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public PrivateCloudProperties withAvailability(AvailabilityProperties availability) {
        super.withAvailability(availability);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public PrivateCloudProperties withEncryption(Encryption encryption) {
        super.withEncryption(encryption);
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
        if (circuit() != null) {
            circuit().validate();
        }
        if (endpoints() != null) {
            endpoints().validate();
        }
        if (networkBlock() == null) {
            throw logger
                .logExceptionAsError(
                    new IllegalArgumentException(
                        "Missing required property networkBlock in model PrivateCloudProperties"));
        }
        if (secondaryCircuit() != null) {
            secondaryCircuit().validate();
        }
    }
}