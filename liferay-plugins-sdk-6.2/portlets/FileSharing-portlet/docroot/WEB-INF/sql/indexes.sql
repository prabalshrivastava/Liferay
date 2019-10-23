create index IX_56711850 on SPSharing (classPK, classNameId);
create index IX_5B854335 on SPSharing (createdBy, classPK, classNameId);
create index IX_2BBE30A3 on SPSharing (createdBy, startDate, endDate);
create index IX_1FF81BB1 on SPSharing (emailAddress);
create index IX_1937474C on SPSharing (emailAddress, classNameId, classPK, internalShare);
create index IX_9D94F814 on SPSharing (userId, classNameId, classPK);
create index IX_46999CBE on SPSharing (userId, classNameId, classPK, internalShare);
create index IX_370672B8 on SPSharing (userId, startDate, endDate);