// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.analytics.synapse.artifacts.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.annotation.JsonFlatten;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.util.List;

/**
 * This activity evaluates an expression and executes activities under the cases property that correspond to the
 * expression evaluation expected in the equals property.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonTypeName("Switch")
@JsonFlatten
@Fluent
public class SwitchActivity extends ControlActivity {
    /*
     * An expression that would evaluate to a string or integer. This is used to determine the block of activities in
     * cases that will be executed.
     */
    @JsonProperty(value = "typeProperties.on", required = true)
    private Expression on;

    /*
     * List of cases that correspond to expected values of the 'on' property. This is an optional property and if not
     * provided, the activity will execute activities provided in defaultActivities.
     */
    @JsonProperty(value = "typeProperties.cases")
    private List<SwitchCase> cases;

    /*
     * List of activities to execute if no case condition is satisfied. This is an optional property and if not
     * provided, the activity will exit without any action.
     */
    @JsonProperty(value = "typeProperties.defaultActivities")
    private List<Activity> defaultActivities;

    /** Creates an instance of SwitchActivity class. */
    public SwitchActivity() {}

    /**
     * Get the on property: An expression that would evaluate to a string or integer. This is used to determine the
     * block of activities in cases that will be executed.
     *
     * @return the on value.
     */
    public Expression getOn() {
        return this.on;
    }

    /**
     * Set the on property: An expression that would evaluate to a string or integer. This is used to determine the
     * block of activities in cases that will be executed.
     *
     * @param on the on value to set.
     * @return the SwitchActivity object itself.
     */
    public SwitchActivity setOn(Expression on) {
        this.on = on;
        return this;
    }

    /**
     * Get the cases property: List of cases that correspond to expected values of the 'on' property. This is an
     * optional property and if not provided, the activity will execute activities provided in defaultActivities.
     *
     * @return the cases value.
     */
    public List<SwitchCase> getCases() {
        return this.cases;
    }

    /**
     * Set the cases property: List of cases that correspond to expected values of the 'on' property. This is an
     * optional property and if not provided, the activity will execute activities provided in defaultActivities.
     *
     * @param cases the cases value to set.
     * @return the SwitchActivity object itself.
     */
    public SwitchActivity setCases(List<SwitchCase> cases) {
        this.cases = cases;
        return this;
    }

    /**
     * Get the defaultActivities property: List of activities to execute if no case condition is satisfied. This is an
     * optional property and if not provided, the activity will exit without any action.
     *
     * @return the defaultActivities value.
     */
    public List<Activity> getDefaultActivities() {
        return this.defaultActivities;
    }

    /**
     * Set the defaultActivities property: List of activities to execute if no case condition is satisfied. This is an
     * optional property and if not provided, the activity will exit without any action.
     *
     * @param defaultActivities the defaultActivities value to set.
     * @return the SwitchActivity object itself.
     */
    public SwitchActivity setDefaultActivities(List<Activity> defaultActivities) {
        this.defaultActivities = defaultActivities;
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public SwitchActivity setName(String name) {
        super.setName(name);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public SwitchActivity setDescription(String description) {
        super.setDescription(description);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public SwitchActivity setDependsOn(List<ActivityDependency> dependsOn) {
        super.setDependsOn(dependsOn);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public SwitchActivity setUserProperties(List<UserProperty> userProperties) {
        super.setUserProperties(userProperties);
        return this;
    }
}
