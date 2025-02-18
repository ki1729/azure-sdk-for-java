// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.loganalytics.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.resourcemanager.loganalytics.models.PrivateLinkScopedResource;
import com.azure.resourcemanager.loganalytics.models.PublicNetworkAccessType;
import com.azure.resourcemanager.loganalytics.models.WorkspaceCapping;
import com.azure.resourcemanager.loganalytics.models.WorkspaceEntityStatus;
import com.azure.resourcemanager.loganalytics.models.WorkspaceFeatures;
import com.azure.resourcemanager.loganalytics.models.WorkspaceSku;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/** Workspace properties. */
@Fluent
public final class WorkspaceProperties {
    /*
     * The provisioning state of the workspace.
     */
    @JsonProperty(value = "provisioningState", access = JsonProperty.Access.WRITE_ONLY)
    private WorkspaceEntityStatus provisioningState;

    /*
     * This is a read-only property. Represents the ID associated with the
     * workspace.
     */
    @JsonProperty(value = "customerId", access = JsonProperty.Access.WRITE_ONLY)
    private String customerId;

    /*
     * The SKU of the workspace.
     */
    @JsonProperty(value = "sku")
    private WorkspaceSku sku;

    /*
     * The workspace data retention in days. Allowed values are per pricing
     * plan. See pricing tiers documentation for details.
     */
    @JsonProperty(value = "retentionInDays")
    private Integer retentionInDays;

    /*
     * The daily volume cap for ingestion.
     */
    @JsonProperty(value = "workspaceCapping")
    private WorkspaceCapping workspaceCapping;

    /*
     * Workspace creation date.
     */
    @JsonProperty(value = "createdDate", access = JsonProperty.Access.WRITE_ONLY)
    private String createdDate;

    /*
     * Workspace modification date.
     */
    @JsonProperty(value = "modifiedDate", access = JsonProperty.Access.WRITE_ONLY)
    private String modifiedDate;

    /*
     * The network access type for accessing Log Analytics ingestion.
     */
    @JsonProperty(value = "publicNetworkAccessForIngestion")
    private PublicNetworkAccessType publicNetworkAccessForIngestion;

    /*
     * The network access type for accessing Log Analytics query.
     */
    @JsonProperty(value = "publicNetworkAccessForQuery")
    private PublicNetworkAccessType publicNetworkAccessForQuery;

    /*
     * Indicates whether customer managed storage is mandatory for query
     * management.
     */
    @JsonProperty(value = "forceCmkForQuery")
    private Boolean forceCmkForQuery;

    /*
     * List of linked private link scope resources.
     */
    @JsonProperty(value = "privateLinkScopedResources", access = JsonProperty.Access.WRITE_ONLY)
    private List<PrivateLinkScopedResource> privateLinkScopedResources;

    /*
     * Workspace features.
     */
    @JsonProperty(value = "features")
    private WorkspaceFeatures features;

    /*
     * The resource ID of the default Data Collection Rule to use for this
     * workspace. Expected format is -
     * /subscriptions/{subscriptionId}/resourceGroups/{resourceGroupName}/providers/Microsoft.Insights/dataCollectionRules/{dcrName}.
     */
    @JsonProperty(value = "defaultDataCollectionRuleResourceId")
    private String defaultDataCollectionRuleResourceId;

    /**
     * Get the provisioningState property: The provisioning state of the workspace.
     *
     * @return the provisioningState value.
     */
    public WorkspaceEntityStatus provisioningState() {
        return this.provisioningState;
    }

    /**
     * Get the customerId property: This is a read-only property. Represents the ID associated with the workspace.
     *
     * @return the customerId value.
     */
    public String customerId() {
        return this.customerId;
    }

    /**
     * Get the sku property: The SKU of the workspace.
     *
     * @return the sku value.
     */
    public WorkspaceSku sku() {
        return this.sku;
    }

    /**
     * Set the sku property: The SKU of the workspace.
     *
     * @param sku the sku value to set.
     * @return the WorkspaceProperties object itself.
     */
    public WorkspaceProperties withSku(WorkspaceSku sku) {
        this.sku = sku;
        return this;
    }

    /**
     * Get the retentionInDays property: The workspace data retention in days. Allowed values are per pricing plan. See
     * pricing tiers documentation for details.
     *
     * @return the retentionInDays value.
     */
    public Integer retentionInDays() {
        return this.retentionInDays;
    }

    /**
     * Set the retentionInDays property: The workspace data retention in days. Allowed values are per pricing plan. See
     * pricing tiers documentation for details.
     *
     * @param retentionInDays the retentionInDays value to set.
     * @return the WorkspaceProperties object itself.
     */
    public WorkspaceProperties withRetentionInDays(Integer retentionInDays) {
        this.retentionInDays = retentionInDays;
        return this;
    }

    /**
     * Get the workspaceCapping property: The daily volume cap for ingestion.
     *
     * @return the workspaceCapping value.
     */
    public WorkspaceCapping workspaceCapping() {
        return this.workspaceCapping;
    }

    /**
     * Set the workspaceCapping property: The daily volume cap for ingestion.
     *
     * @param workspaceCapping the workspaceCapping value to set.
     * @return the WorkspaceProperties object itself.
     */
    public WorkspaceProperties withWorkspaceCapping(WorkspaceCapping workspaceCapping) {
        this.workspaceCapping = workspaceCapping;
        return this;
    }

    /**
     * Get the createdDate property: Workspace creation date.
     *
     * @return the createdDate value.
     */
    public String createdDate() {
        return this.createdDate;
    }

    /**
     * Get the modifiedDate property: Workspace modification date.
     *
     * @return the modifiedDate value.
     */
    public String modifiedDate() {
        return this.modifiedDate;
    }

    /**
     * Get the publicNetworkAccessForIngestion property: The network access type for accessing Log Analytics ingestion.
     *
     * @return the publicNetworkAccessForIngestion value.
     */
    public PublicNetworkAccessType publicNetworkAccessForIngestion() {
        return this.publicNetworkAccessForIngestion;
    }

    /**
     * Set the publicNetworkAccessForIngestion property: The network access type for accessing Log Analytics ingestion.
     *
     * @param publicNetworkAccessForIngestion the publicNetworkAccessForIngestion value to set.
     * @return the WorkspaceProperties object itself.
     */
    public WorkspaceProperties withPublicNetworkAccessForIngestion(
        PublicNetworkAccessType publicNetworkAccessForIngestion) {
        this.publicNetworkAccessForIngestion = publicNetworkAccessForIngestion;
        return this;
    }

    /**
     * Get the publicNetworkAccessForQuery property: The network access type for accessing Log Analytics query.
     *
     * @return the publicNetworkAccessForQuery value.
     */
    public PublicNetworkAccessType publicNetworkAccessForQuery() {
        return this.publicNetworkAccessForQuery;
    }

    /**
     * Set the publicNetworkAccessForQuery property: The network access type for accessing Log Analytics query.
     *
     * @param publicNetworkAccessForQuery the publicNetworkAccessForQuery value to set.
     * @return the WorkspaceProperties object itself.
     */
    public WorkspaceProperties withPublicNetworkAccessForQuery(PublicNetworkAccessType publicNetworkAccessForQuery) {
        this.publicNetworkAccessForQuery = publicNetworkAccessForQuery;
        return this;
    }

    /**
     * Get the forceCmkForQuery property: Indicates whether customer managed storage is mandatory for query management.
     *
     * @return the forceCmkForQuery value.
     */
    public Boolean forceCmkForQuery() {
        return this.forceCmkForQuery;
    }

    /**
     * Set the forceCmkForQuery property: Indicates whether customer managed storage is mandatory for query management.
     *
     * @param forceCmkForQuery the forceCmkForQuery value to set.
     * @return the WorkspaceProperties object itself.
     */
    public WorkspaceProperties withForceCmkForQuery(Boolean forceCmkForQuery) {
        this.forceCmkForQuery = forceCmkForQuery;
        return this;
    }

    /**
     * Get the privateLinkScopedResources property: List of linked private link scope resources.
     *
     * @return the privateLinkScopedResources value.
     */
    public List<PrivateLinkScopedResource> privateLinkScopedResources() {
        return this.privateLinkScopedResources;
    }

    /**
     * Get the features property: Workspace features.
     *
     * @return the features value.
     */
    public WorkspaceFeatures features() {
        return this.features;
    }

    /**
     * Set the features property: Workspace features.
     *
     * @param features the features value to set.
     * @return the WorkspaceProperties object itself.
     */
    public WorkspaceProperties withFeatures(WorkspaceFeatures features) {
        this.features = features;
        return this;
    }

    /**
     * Get the defaultDataCollectionRuleResourceId property: The resource ID of the default Data Collection Rule to use
     * for this workspace. Expected format is -
     * /subscriptions/{subscriptionId}/resourceGroups/{resourceGroupName}/providers/Microsoft.Insights/dataCollectionRules/{dcrName}.
     *
     * @return the defaultDataCollectionRuleResourceId value.
     */
    public String defaultDataCollectionRuleResourceId() {
        return this.defaultDataCollectionRuleResourceId;
    }

    /**
     * Set the defaultDataCollectionRuleResourceId property: The resource ID of the default Data Collection Rule to use
     * for this workspace. Expected format is -
     * /subscriptions/{subscriptionId}/resourceGroups/{resourceGroupName}/providers/Microsoft.Insights/dataCollectionRules/{dcrName}.
     *
     * @param defaultDataCollectionRuleResourceId the defaultDataCollectionRuleResourceId value to set.
     * @return the WorkspaceProperties object itself.
     */
    public WorkspaceProperties withDefaultDataCollectionRuleResourceId(String defaultDataCollectionRuleResourceId) {
        this.defaultDataCollectionRuleResourceId = defaultDataCollectionRuleResourceId;
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (sku() != null) {
            sku().validate();
        }
        if (workspaceCapping() != null) {
            workspaceCapping().validate();
        }
        if (privateLinkScopedResources() != null) {
            privateLinkScopedResources().forEach(e -> e.validate());
        }
        if (features() != null) {
            features().validate();
        }
    }
}
