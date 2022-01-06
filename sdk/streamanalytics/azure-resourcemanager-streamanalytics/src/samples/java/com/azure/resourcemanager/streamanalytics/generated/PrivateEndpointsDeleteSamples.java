// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.streamanalytics.generated;

import com.azure.core.util.Context;

/** Samples for PrivateEndpoints Delete. */
public final class PrivateEndpointsDeleteSamples {
    /*
     * x-ms-original-file: specification/streamanalytics/resource-manager/Microsoft.StreamAnalytics/stable/2020-03-01/examples/PrivateEndpoint_Delete.json
     */
    /**
     * Sample code: Delete a private endpoint.
     *
     * @param manager Entry point to StreamAnalyticsManager.
     */
    public static void deleteAPrivateEndpoint(
        com.azure.resourcemanager.streamanalytics.StreamAnalyticsManager manager) {
        manager.privateEndpoints().delete("sjrg", "testcluster", "testpe", Context.NONE);
    }
}