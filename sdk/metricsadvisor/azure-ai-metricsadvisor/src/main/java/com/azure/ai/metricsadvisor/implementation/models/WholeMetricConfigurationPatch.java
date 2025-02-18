// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.ai.metricsadvisor.implementation.models;

import com.azure.core.annotation.Fluent;
import com.fasterxml.jackson.annotation.JsonProperty;

/** The WholeMetricConfigurationPatch model. */
@Fluent
public final class WholeMetricConfigurationPatch {
    /*
     * condition operator
     *
     * should be specified when combining multiple detection conditions
     */
    @JsonProperty(value = "conditionOperator")
    private AnomalyDetectionConfigurationLogicType conditionOperator;

    /*
     * The smartDetectionCondition property.
     */
    @JsonProperty(value = "smartDetectionCondition")
    private SmartDetectionConditionPatch smartDetectionCondition;

    /*
     * The hardThresholdCondition property.
     */
    @JsonProperty(value = "hardThresholdCondition")
    private HardThresholdConditionPatch hardThresholdCondition;

    /*
     * The changeThresholdCondition property.
     */
    @JsonProperty(value = "changeThresholdCondition")
    private ChangeThresholdConditionPatch changeThresholdCondition;

    /** Creates an instance of WholeMetricConfigurationPatch class. */
    public WholeMetricConfigurationPatch() {}

    /**
     * Get the conditionOperator property: condition operator
     *
     * <p>should be specified when combining multiple detection conditions.
     *
     * @return the conditionOperator value.
     */
    public AnomalyDetectionConfigurationLogicType getConditionOperator() {
        return this.conditionOperator;
    }

    /**
     * Set the conditionOperator property: condition operator
     *
     * <p>should be specified when combining multiple detection conditions.
     *
     * @param conditionOperator the conditionOperator value to set.
     * @return the WholeMetricConfigurationPatch object itself.
     */
    public WholeMetricConfigurationPatch setConditionOperator(
            AnomalyDetectionConfigurationLogicType conditionOperator) {
        this.conditionOperator = conditionOperator;
        return this;
    }

    /**
     * Get the smartDetectionCondition property: The smartDetectionCondition property.
     *
     * @return the smartDetectionCondition value.
     */
    public SmartDetectionConditionPatch getSmartDetectionCondition() {
        return this.smartDetectionCondition;
    }

    /**
     * Set the smartDetectionCondition property: The smartDetectionCondition property.
     *
     * @param smartDetectionCondition the smartDetectionCondition value to set.
     * @return the WholeMetricConfigurationPatch object itself.
     */
    public WholeMetricConfigurationPatch setSmartDetectionCondition(
            SmartDetectionConditionPatch smartDetectionCondition) {
        this.smartDetectionCondition = smartDetectionCondition;
        return this;
    }

    /**
     * Get the hardThresholdCondition property: The hardThresholdCondition property.
     *
     * @return the hardThresholdCondition value.
     */
    public HardThresholdConditionPatch getHardThresholdCondition() {
        return this.hardThresholdCondition;
    }

    /**
     * Set the hardThresholdCondition property: The hardThresholdCondition property.
     *
     * @param hardThresholdCondition the hardThresholdCondition value to set.
     * @return the WholeMetricConfigurationPatch object itself.
     */
    public WholeMetricConfigurationPatch setHardThresholdCondition(HardThresholdConditionPatch hardThresholdCondition) {
        this.hardThresholdCondition = hardThresholdCondition;
        return this;
    }

    /**
     * Get the changeThresholdCondition property: The changeThresholdCondition property.
     *
     * @return the changeThresholdCondition value.
     */
    public ChangeThresholdConditionPatch getChangeThresholdCondition() {
        return this.changeThresholdCondition;
    }

    /**
     * Set the changeThresholdCondition property: The changeThresholdCondition property.
     *
     * @param changeThresholdCondition the changeThresholdCondition value to set.
     * @return the WholeMetricConfigurationPatch object itself.
     */
    public WholeMetricConfigurationPatch setChangeThresholdCondition(
            ChangeThresholdConditionPatch changeThresholdCondition) {
        this.changeThresholdCondition = changeThresholdCondition;
        return this;
    }
}
