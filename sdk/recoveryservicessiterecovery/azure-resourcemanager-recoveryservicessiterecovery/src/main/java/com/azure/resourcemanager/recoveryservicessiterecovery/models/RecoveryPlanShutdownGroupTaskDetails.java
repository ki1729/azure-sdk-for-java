// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.recoveryservicessiterecovery.models;

import com.azure.core.annotation.Fluent;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.util.List;

/** This class represents the recovery plan shutdown group task details. */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "instanceType")
@JsonTypeName("RecoveryPlanShutdownGroupTaskDetails")
@Fluent
public final class RecoveryPlanShutdownGroupTaskDetails extends RecoveryPlanGroupTaskDetails {
    /** Creates an instance of RecoveryPlanShutdownGroupTaskDetails class. */
    public RecoveryPlanShutdownGroupTaskDetails() {
    }

    /** {@inheritDoc} */
    @Override
    public RecoveryPlanShutdownGroupTaskDetails withName(String name) {
        super.withName(name);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public RecoveryPlanShutdownGroupTaskDetails withGroupId(String groupId) {
        super.withGroupId(groupId);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public RecoveryPlanShutdownGroupTaskDetails withRpGroupType(String rpGroupType) {
        super.withRpGroupType(rpGroupType);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public RecoveryPlanShutdownGroupTaskDetails withChildTasks(List<AsrTask> childTasks) {
        super.withChildTasks(childTasks);
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
