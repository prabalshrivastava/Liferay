create index IX_28800637 on SPAddress (uuid_);
create index IX_3604C591 on SPAddress (uuid_, companyId);
create unique index IX_3E737C53 on SPAddress (uuid_, groupId);

create index IX_3A6C229 on SPFundingRounds (uuid_);
create index IX_10D97E5F on SPFundingRounds (uuid_, companyId);
create unique index IX_211C10A1 on SPFundingRounds (uuid_, groupId);

create index IX_C0D3B4E6 on SPOrganization (isBaseOrg, active_);
create index IX_40F55F35 on SPOrganization (name);
create index IX_5B926230 on SPOrganization (userId);
create index IX_71EB08FE on SPOrganization (uuid_);
create index IX_CA1C106A on SPOrganization (uuid_, companyId);
create unique index IX_D561A96C on SPOrganization (uuid_, groupId);

create index IX_C62BD75C on SPPerson (uuid_);
create index IX_14293B4C on SPPerson (uuid_, companyId);
create unique index IX_152024CE on SPPerson (uuid_, groupId);

create index IX_37D920E6 on SPQuestionnaire (entryClassPK, entryClassName);