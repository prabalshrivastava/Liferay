create index IX_AFE60768 on SPChallenge (uuid_);
create index IX_5D84CBC0 on SPChallenge (uuid_, companyId);
create unique index IX_B54D4242 on SPChallenge (uuid_, groupId);

create index IX_58DB8582 on SPChallengeApplicant (applicantRefId);
create index IX_8C031A8F on SPChallengeApplicant (spChallengeId);
create index IX_313A2E2F on SPChallengeApplicant (spChallengeId, applicantRefId);
create index IX_EE3E6F92 on SPChallengeApplicant (uuid_);
create index IX_A6808556 on SPChallengeApplicant (uuid_, companyId);
create unique index IX_3F66958 on SPChallengeApplicant (uuid_, groupId);