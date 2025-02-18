// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.appcontainers.models;

import com.azure.core.management.SystemData;
import com.azure.core.util.Context;
import com.azure.resourcemanager.appcontainers.fluent.models.ConnectedEnvironmentStorageInner;

/** An immutable client-side representation of ConnectedEnvironmentStorage. */
public interface ConnectedEnvironmentStorage {
    /**
     * Gets the id property: Fully qualified resource Id for the resource.
     *
     * @return the id value.
     */
    String id();

    /**
     * Gets the name property: The name of the resource.
     *
     * @return the name value.
     */
    String name();

    /**
     * Gets the type property: The type of the resource.
     *
     * @return the type value.
     */
    String type();

    /**
     * Gets the properties property: Storage properties.
     *
     * @return the properties value.
     */
    ConnectedEnvironmentStorageProperties properties();

    /**
     * Gets the systemData property: Azure Resource Manager metadata containing createdBy and modifiedBy information.
     *
     * @return the systemData value.
     */
    SystemData systemData();

    /**
     * Gets the name of the resource group.
     *
     * @return the name of the resource group.
     */
    String resourceGroupName();

    /**
     * Gets the inner com.azure.resourcemanager.appcontainers.fluent.models.ConnectedEnvironmentStorageInner object.
     *
     * @return the inner object.
     */
    ConnectedEnvironmentStorageInner innerModel();

    /** The entirety of the ConnectedEnvironmentStorage definition. */
    interface Definition
        extends DefinitionStages.Blank, DefinitionStages.WithParentResource, DefinitionStages.WithCreate {
    }
    /** The ConnectedEnvironmentStorage definition stages. */
    interface DefinitionStages {
        /** The first stage of the ConnectedEnvironmentStorage definition. */
        interface Blank extends WithParentResource {
        }
        /** The stage of the ConnectedEnvironmentStorage definition allowing to specify parent resource. */
        interface WithParentResource {
            /**
             * Specifies resourceGroupName, connectedEnvironmentName.
             *
             * @param resourceGroupName The name of the resource group. The name is case insensitive.
             * @param connectedEnvironmentName Name of the Environment.
             * @return the next definition stage.
             */
            WithCreate withExistingConnectedEnvironment(String resourceGroupName, String connectedEnvironmentName);
        }
        /**
         * The stage of the ConnectedEnvironmentStorage definition which contains all the minimum required properties
         * for the resource to be created, but also allows for any other optional properties to be specified.
         */
        interface WithCreate extends DefinitionStages.WithProperties {
            /**
             * Executes the create request.
             *
             * @return the created resource.
             */
            ConnectedEnvironmentStorage create();

            /**
             * Executes the create request.
             *
             * @param context The context to associate with this operation.
             * @return the created resource.
             */
            ConnectedEnvironmentStorage create(Context context);
        }
        /** The stage of the ConnectedEnvironmentStorage definition allowing to specify properties. */
        interface WithProperties {
            /**
             * Specifies the properties property: Storage properties.
             *
             * @param properties Storage properties.
             * @return the next definition stage.
             */
            WithCreate withProperties(ConnectedEnvironmentStorageProperties properties);
        }
    }
    /**
     * Begins update for the ConnectedEnvironmentStorage resource.
     *
     * @return the stage of resource update.
     */
    ConnectedEnvironmentStorage.Update update();

    /** The template for ConnectedEnvironmentStorage update. */
    interface Update extends UpdateStages.WithProperties {
        /**
         * Executes the update request.
         *
         * @return the updated resource.
         */
        ConnectedEnvironmentStorage apply();

        /**
         * Executes the update request.
         *
         * @param context The context to associate with this operation.
         * @return the updated resource.
         */
        ConnectedEnvironmentStorage apply(Context context);
    }
    /** The ConnectedEnvironmentStorage update stages. */
    interface UpdateStages {
        /** The stage of the ConnectedEnvironmentStorage update allowing to specify properties. */
        interface WithProperties {
            /**
             * Specifies the properties property: Storage properties.
             *
             * @param properties Storage properties.
             * @return the next definition stage.
             */
            Update withProperties(ConnectedEnvironmentStorageProperties properties);
        }
    }
    /**
     * Refreshes the resource to sync with Azure.
     *
     * @return the refreshed resource.
     */
    ConnectedEnvironmentStorage refresh();

    /**
     * Refreshes the resource to sync with Azure.
     *
     * @param context The context to associate with this operation.
     * @return the refreshed resource.
     */
    ConnectedEnvironmentStorage refresh(Context context);
}
