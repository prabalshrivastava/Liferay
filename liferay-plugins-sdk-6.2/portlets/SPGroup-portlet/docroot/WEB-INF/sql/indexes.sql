create unique index IX_EADB5C9F on SPGroup (groupId, urlTitle);
create index IX_81681553 on SPGroup (type_, status);
create index IX_DC4D61A2 on SPGroup (userId);
create index IX_88E8DE88 on SPGroup (userId, status);
create index IX_12F9534C on SPGroup (uuid_);
create index IX_463BE95C on SPGroup (uuid_, companyId);
create unique index IX_2D2716DE on SPGroup (uuid_, groupId);

create index IX_485DCBDA on SPGroupUser (spGroupId);
create index IX_D7DA8744 on SPGroupUser (spGroupId, role);
create index IX_A9E790C0 on SPGroupUser (spGroupId, status);
create index IX_8B1876CD on SPGroupUser (userId);
create unique index IX_690FED46 on SPGroupUser (userId, spGroupId, status);
create index IX_C14D98B3 on SPGroupUser (userId, status);