create index IX_6E669067 on ConfigurationProperty (companyId, groupId, key_);
create index IX_2B0C9321 on ConfigurationProperty (userId, companyId, groupId, key_);
create index IX_852A7EC3 on ConfigurationProperty (uuid_);
create index IX_A5C5BD85 on ConfigurationProperty (uuid_, companyId);
create unique index IX_8639E147 on ConfigurationProperty (uuid_, groupId);