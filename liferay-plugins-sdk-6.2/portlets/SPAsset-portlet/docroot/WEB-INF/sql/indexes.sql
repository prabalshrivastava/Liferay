create index IX_253F0137 on SPAssetEntry (spAssetTypeId, groupId);
create index IX_1DA0191D on SPAssetEntry (spAssetTypeId, groupId, status);
create index IX_9ACFC8A8 on SPAssetEntry (urlTitle, groupId);

create index IX_2751D517 on SPAssetType (groupId);
create index IX_E75D9CD9 on SPAssetType (status);