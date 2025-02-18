// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.recoveryservicesbackup.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.recoveryservicesbackup.models.CreateMode;
import com.azure.resourcemanager.recoveryservicesbackup.models.MabFileFolderProtectedItem;
import com.azure.resourcemanager.recoveryservicesbackup.models.MabFileFolderProtectedItemExtendedInfo;
import java.time.OffsetDateTime;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;

public final class MabFileFolderProtectedItemTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        MabFileFolderProtectedItem model =
            BinaryData
                .fromString(
                    "{\"protectedItemType\":\"MabFileFolderProtectedItem\",\"friendlyName\":\"k\",\"computerName\":\"fabuiyjibu\",\"lastBackupStatus\":\"hdugneiknpg\",\"lastBackupTime\":\"2021-02-15T04:02:17Z\",\"protectionState\":\"iuqhibtozipqwj\",\"deferredDeleteSyncTimeInUTC\":3331007678270504081,\"extendedInfo\":{\"lastRefreshedAt\":\"2021-04-29T21:30:05Z\",\"oldestRecoveryPoint\":\"2021-07-11T21:58:09Z\",\"recoveryPointCount\":1885271789},\"backupManagementType\":\"DefaultBackup\",\"workloadType\":\"AzureFileShare\",\"containerName\":\"ylkmqp\",\"sourceResourceId\":\"yhlfb\",\"policyId\":\"wgcloxoebqinji\",\"lastRecoveryPoint\":\"2021-03-04T16:18:21Z\",\"backupSetName\":\"fujqlafcba\",\"createMode\":\"Default\",\"deferredDeleteTimeInUTC\":\"2021-05-18T22:00:53Z\",\"isScheduledForDeferredDelete\":true,\"deferredDeleteTimeRemaining\":\"iyjwpfilkmkkho\",\"isDeferredDeleteScheduleUpcoming\":true,\"isRehydrate\":false,\"resourceGuardOperationRequests\":[\"auo\",\"phuartv\",\"iukyefchnmna\"],\"isArchiveEnabled\":false,\"policyName\":\"hkxjqirwrweooxf\",\"softDeleteRetentionPeriod\":1908059989}")
                .toObject(MabFileFolderProtectedItem.class);
        Assertions.assertEquals("ylkmqp", model.containerName());
        Assertions.assertEquals("yhlfb", model.sourceResourceId());
        Assertions.assertEquals("wgcloxoebqinji", model.policyId());
        Assertions.assertEquals(OffsetDateTime.parse("2021-03-04T16:18:21Z"), model.lastRecoveryPoint());
        Assertions.assertEquals("fujqlafcba", model.backupSetName());
        Assertions.assertEquals(CreateMode.DEFAULT, model.createMode());
        Assertions.assertEquals(OffsetDateTime.parse("2021-05-18T22:00:53Z"), model.deferredDeleteTimeInUtc());
        Assertions.assertEquals(true, model.isScheduledForDeferredDelete());
        Assertions.assertEquals("iyjwpfilkmkkho", model.deferredDeleteTimeRemaining());
        Assertions.assertEquals(true, model.isDeferredDeleteScheduleUpcoming());
        Assertions.assertEquals(false, model.isRehydrate());
        Assertions.assertEquals("auo", model.resourceGuardOperationRequests().get(0));
        Assertions.assertEquals(false, model.isArchiveEnabled());
        Assertions.assertEquals("hkxjqirwrweooxf", model.policyName());
        Assertions.assertEquals(1908059989, model.softDeleteRetentionPeriod());
        Assertions.assertEquals("k", model.friendlyName());
        Assertions.assertEquals("fabuiyjibu", model.computerName());
        Assertions.assertEquals("hdugneiknpg", model.lastBackupStatus());
        Assertions.assertEquals(OffsetDateTime.parse("2021-02-15T04:02:17Z"), model.lastBackupTime());
        Assertions.assertEquals("iuqhibtozipqwj", model.protectionState());
        Assertions.assertEquals(3331007678270504081L, model.deferredDeleteSyncTimeInUtc());
        Assertions.assertEquals(OffsetDateTime.parse("2021-04-29T21:30:05Z"), model.extendedInfo().lastRefreshedAt());
        Assertions
            .assertEquals(OffsetDateTime.parse("2021-07-11T21:58:09Z"), model.extendedInfo().oldestRecoveryPoint());
        Assertions.assertEquals(1885271789, model.extendedInfo().recoveryPointCount());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        MabFileFolderProtectedItem model =
            new MabFileFolderProtectedItem()
                .withContainerName("ylkmqp")
                .withSourceResourceId("yhlfb")
                .withPolicyId("wgcloxoebqinji")
                .withLastRecoveryPoint(OffsetDateTime.parse("2021-03-04T16:18:21Z"))
                .withBackupSetName("fujqlafcba")
                .withCreateMode(CreateMode.DEFAULT)
                .withDeferredDeleteTimeInUtc(OffsetDateTime.parse("2021-05-18T22:00:53Z"))
                .withIsScheduledForDeferredDelete(true)
                .withDeferredDeleteTimeRemaining("iyjwpfilkmkkho")
                .withIsDeferredDeleteScheduleUpcoming(true)
                .withIsRehydrate(false)
                .withResourceGuardOperationRequests(Arrays.asList("auo", "phuartv", "iukyefchnmna"))
                .withIsArchiveEnabled(false)
                .withPolicyName("hkxjqirwrweooxf")
                .withSoftDeleteRetentionPeriod(1908059989)
                .withFriendlyName("k")
                .withComputerName("fabuiyjibu")
                .withLastBackupStatus("hdugneiknpg")
                .withLastBackupTime(OffsetDateTime.parse("2021-02-15T04:02:17Z"))
                .withProtectionState("iuqhibtozipqwj")
                .withDeferredDeleteSyncTimeInUtc(3331007678270504081L)
                .withExtendedInfo(
                    new MabFileFolderProtectedItemExtendedInfo()
                        .withLastRefreshedAt(OffsetDateTime.parse("2021-04-29T21:30:05Z"))
                        .withOldestRecoveryPoint(OffsetDateTime.parse("2021-07-11T21:58:09Z"))
                        .withRecoveryPointCount(1885271789));
        model = BinaryData.fromObject(model).toObject(MabFileFolderProtectedItem.class);
        Assertions.assertEquals("ylkmqp", model.containerName());
        Assertions.assertEquals("yhlfb", model.sourceResourceId());
        Assertions.assertEquals("wgcloxoebqinji", model.policyId());
        Assertions.assertEquals(OffsetDateTime.parse("2021-03-04T16:18:21Z"), model.lastRecoveryPoint());
        Assertions.assertEquals("fujqlafcba", model.backupSetName());
        Assertions.assertEquals(CreateMode.DEFAULT, model.createMode());
        Assertions.assertEquals(OffsetDateTime.parse("2021-05-18T22:00:53Z"), model.deferredDeleteTimeInUtc());
        Assertions.assertEquals(true, model.isScheduledForDeferredDelete());
        Assertions.assertEquals("iyjwpfilkmkkho", model.deferredDeleteTimeRemaining());
        Assertions.assertEquals(true, model.isDeferredDeleteScheduleUpcoming());
        Assertions.assertEquals(false, model.isRehydrate());
        Assertions.assertEquals("auo", model.resourceGuardOperationRequests().get(0));
        Assertions.assertEquals(false, model.isArchiveEnabled());
        Assertions.assertEquals("hkxjqirwrweooxf", model.policyName());
        Assertions.assertEquals(1908059989, model.softDeleteRetentionPeriod());
        Assertions.assertEquals("k", model.friendlyName());
        Assertions.assertEquals("fabuiyjibu", model.computerName());
        Assertions.assertEquals("hdugneiknpg", model.lastBackupStatus());
        Assertions.assertEquals(OffsetDateTime.parse("2021-02-15T04:02:17Z"), model.lastBackupTime());
        Assertions.assertEquals("iuqhibtozipqwj", model.protectionState());
        Assertions.assertEquals(3331007678270504081L, model.deferredDeleteSyncTimeInUtc());
        Assertions.assertEquals(OffsetDateTime.parse("2021-04-29T21:30:05Z"), model.extendedInfo().lastRefreshedAt());
        Assertions
            .assertEquals(OffsetDateTime.parse("2021-07-11T21:58:09Z"), model.extendedInfo().oldestRecoveryPoint());
        Assertions.assertEquals(1885271789, model.extendedInfo().recoveryPointCount());
    }
}
