// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.recoveryservicesbackup.implementation;

import com.azure.core.http.rest.Response;
import com.azure.core.http.rest.SimpleResponse;
import com.azure.core.util.Context;
import com.azure.core.util.logging.ClientLogger;
import com.azure.resourcemanager.recoveryservicesbackup.fluent.ProtectionPolicyOperationResultsClient;
import com.azure.resourcemanager.recoveryservicesbackup.fluent.models.ProtectionPolicyResourceInner;
import com.azure.resourcemanager.recoveryservicesbackup.models.ProtectionPolicyOperationResults;
import com.azure.resourcemanager.recoveryservicesbackup.models.ProtectionPolicyResource;

public final class ProtectionPolicyOperationResultsImpl implements ProtectionPolicyOperationResults {
    private static final ClientLogger LOGGER = new ClientLogger(ProtectionPolicyOperationResultsImpl.class);

    private final ProtectionPolicyOperationResultsClient innerClient;

    private final com.azure.resourcemanager.recoveryservicesbackup.RecoveryServicesBackupManager serviceManager;

    public ProtectionPolicyOperationResultsImpl(
        ProtectionPolicyOperationResultsClient innerClient,
        com.azure.resourcemanager.recoveryservicesbackup.RecoveryServicesBackupManager serviceManager) {
        this.innerClient = innerClient;
        this.serviceManager = serviceManager;
    }

    public Response<ProtectionPolicyResource> getWithResponse(
        String vaultName, String resourceGroupName, String policyName, String operationId, Context context) {
        Response<ProtectionPolicyResourceInner> inner =
            this.serviceClient().getWithResponse(vaultName, resourceGroupName, policyName, operationId, context);
        if (inner != null) {
            return new SimpleResponse<>(
                inner.getRequest(),
                inner.getStatusCode(),
                inner.getHeaders(),
                new ProtectionPolicyResourceImpl(inner.getValue(), this.manager()));
        } else {
            return null;
        }
    }

    public ProtectionPolicyResource get(
        String vaultName, String resourceGroupName, String policyName, String operationId) {
        ProtectionPolicyResourceInner inner =
            this.serviceClient().get(vaultName, resourceGroupName, policyName, operationId);
        if (inner != null) {
            return new ProtectionPolicyResourceImpl(inner, this.manager());
        } else {
            return null;
        }
    }

    private ProtectionPolicyOperationResultsClient serviceClient() {
        return this.innerClient;
    }

    private com.azure.resourcemanager.recoveryservicesbackup.RecoveryServicesBackupManager manager() {
        return this.serviceManager;
    }
}
