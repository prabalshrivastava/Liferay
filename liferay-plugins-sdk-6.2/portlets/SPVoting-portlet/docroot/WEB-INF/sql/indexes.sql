create index IX_EB164DDA on SPVoting (className, classPK);
create index IX_BCFB44B5 on SPVoting (className, classPK, ip);
create index IX_767D2C14 on SPVoting (className, classPK, userId);
create index IX_12901CA on SPVoting (uuid_);
create index IX_7C82E01E on SPVoting (uuid_, companyId);
create unique index IX_EAE0D620 on SPVoting (uuid_, groupId);