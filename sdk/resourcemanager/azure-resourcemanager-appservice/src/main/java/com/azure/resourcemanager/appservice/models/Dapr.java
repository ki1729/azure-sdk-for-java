// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.appservice.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/** Container App Dapr configuration. */
@Fluent
public final class Dapr {
    @JsonIgnore private final ClientLogger logger = new ClientLogger(Dapr.class);

    /*
     * Boolean indicating if the Dapr side car is enabled
     */
    @JsonProperty(value = "enabled")
    private Boolean enabled;

    /*
     * Dapr application identifier
     */
    @JsonProperty(value = "appId")
    private String appId;

    /*
     * Port on which the Dapr side car
     */
    @JsonProperty(value = "appPort")
    private Integer appPort;

    /*
     * Collection of Dapr components
     */
    @JsonProperty(value = "components")
    private List<DaprComponent> components;

    /**
     * Get the enabled property: Boolean indicating if the Dapr side car is enabled.
     *
     * @return the enabled value.
     */
    public Boolean enabled() {
        return this.enabled;
    }

    /**
     * Set the enabled property: Boolean indicating if the Dapr side car is enabled.
     *
     * @param enabled the enabled value to set.
     * @return the Dapr object itself.
     */
    public Dapr withEnabled(Boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    /**
     * Get the appId property: Dapr application identifier.
     *
     * @return the appId value.
     */
    public String appId() {
        return this.appId;
    }

    /**
     * Set the appId property: Dapr application identifier.
     *
     * @param appId the appId value to set.
     * @return the Dapr object itself.
     */
    public Dapr withAppId(String appId) {
        this.appId = appId;
        return this;
    }

    /**
     * Get the appPort property: Port on which the Dapr side car.
     *
     * @return the appPort value.
     */
    public Integer appPort() {
        return this.appPort;
    }

    /**
     * Set the appPort property: Port on which the Dapr side car.
     *
     * @param appPort the appPort value to set.
     * @return the Dapr object itself.
     */
    public Dapr withAppPort(Integer appPort) {
        this.appPort = appPort;
        return this;
    }

    /**
     * Get the components property: Collection of Dapr components.
     *
     * @return the components value.
     */
    public List<DaprComponent> components() {
        return this.components;
    }

    /**
     * Set the components property: Collection of Dapr components.
     *
     * @param components the components value to set.
     * @return the Dapr object itself.
     */
    public Dapr withComponents(List<DaprComponent> components) {
        this.components = components;
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (components() != null) {
            components().forEach(e -> e.validate());
        }
    }
}