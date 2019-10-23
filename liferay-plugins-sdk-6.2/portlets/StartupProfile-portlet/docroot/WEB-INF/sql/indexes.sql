create index IX_D3B9935A on SPATOContacts (organizationId);
create index IX_4011685E on SPATOContacts (primaryPrincipalUserId);
create index IX_864E80AC on SPATOContacts (secondaryPrincipalUserId);

create index IX_E1164E29 on SPATODocument (documentType);
create index IX_13096222 on SPATODocument (organizationId);
create index IX_6E44E4B on SPATODocument (organizationId, documentType);
create index IX_B8C17B34 on SPATODocument (uuid_);

create index IX_AD873105 on SPAccreditation (organizationId);
create index IX_764BD0F1 on SPAccreditation (uuid_);

create index IX_36538A7F on SPAddress (organizationId);
create index IX_784F363C on SPAddress (organizationId, hq);
create index IX_28800637 on SPAddress (uuid_);
create index IX_3604C591 on SPAddress (uuid_, companyId);
create unique index IX_3E737C53 on SPAddress (uuid_, groupId);

create index IX_F6CCA2A1 on SPEmployeeInfo (organizationId);
create index IX_7BFEDFD5 on SPEmployeeInfo (uuid_);

create index IX_3A6C229 on SPFundingRounds (uuid_);
create index IX_10D97E5F on SPFundingRounds (uuid_, companyId);
create unique index IX_211C10A1 on SPFundingRounds (uuid_, groupId);

create index IX_58393328 on SPGuidelines (organizationId);
create index IX_E5BB27FF on SPGuidelines (organizationId, principleId);
create index IX_A4BF4B6E on SPGuidelines (uuid_);

create index IX_EDEBE7DD on SPMentors (organizationId);
create index IX_1A66F9C3 on SPMentors (organizationId, status);
create index IX_BBE61317 on SPMentors (organizationId, userId);
create index IX_F608E21 on SPMentors (status);
create index IX_B0DFA775 on SPMentors (userId);
create index IX_7CED8719 on SPMentors (uuid_);

create index IX_DE1886FF on SPOrgContactUs (organizationId);

create index IX_902F0584 on SPOrganisationRemarks (organizationId);

create index IX_F17B628C on SPOrganization (isATO);
create index IX_C0D3B4E6 on SPOrganization (isBaseOrg, active_);
create index IX_40F55F35 on SPOrganization (name);
create index IX_B82A4C58 on SPOrganization (uen);
create index IX_5B926230 on SPOrganization (userId);
create index IX_71EB08FE on SPOrganization (uuid_);
create index IX_CA1C106A on SPOrganization (uuid_, companyId);
create unique index IX_D561A96C on SPOrganization (uuid_, groupId);

create index IX_C62BD75C on SPPerson (uuid_);
create index IX_14293B4C on SPPerson (uuid_, companyId);
create unique index IX_152024CE on SPPerson (uuid_, groupId);

create index IX_1D0FCF30 on SPPrinciples (siteId);
create index IX_7E9B70FA on SPPrinciples (uuid_);

create index IX_37D920E6 on SPQuestionnaire (entryClassPK, entryClassName);

create index IX_CDD82792 on SPReAccreditation (organizationId);
create index IX_78E9D7C4 on SPReAccreditation (uuid_);