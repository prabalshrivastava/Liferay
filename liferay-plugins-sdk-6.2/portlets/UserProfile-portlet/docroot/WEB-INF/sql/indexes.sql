create unique index IX_C35410 on SPExamBodyUser (emailAddress, examBody);

create unique index IX_55E28E1D on SPSocialProfile (companyId, userId);
create unique index IX_5D2C9247 on SPSocialProfile (companyId, userId, userRegistrationStatus);
create index IX_F9A683EF on SPSocialProfile (uuid_);
create index IX_968D04D9 on SPSocialProfile (uuid_, companyId);
create unique index IX_C912ED9B on SPSocialProfile (uuid_, groupId);

create index IX_C67BED50 on SPSocialProfileDetail (userId);
create unique index IX_241181 on SPSocialProfileDetail (userJobId, userId);
create index IX_4C1399DE on SPSocialProfileDetail (uuid_);
create index IX_2F6A338A on SPSocialProfileDetail (uuid_, companyId);
create unique index IX_F81E148C on SPSocialProfileDetail (uuid_, groupId);

create index IX_19421359 on SPSocialProfileFriends (companyId, belongsToUserId);
create unique index IX_286162B0 on SPSocialProfileFriends (companyId, belongsToUserId, socialNetworkProfileId);
create index IX_719043D2 on SPSocialProfileFriends (companyId, belongsToUserId, socialNetworkType);

create unique index IX_B5CC1EED on SPSocialProfileLike (socialNetworkLikeId, socialNetworkProfileId, socialNetworkType);
create index IX_B127C9F8 on SPSocialProfileLike (socialNetworkProfileId, socialNetworkType);

create index IX_7535195C on SPSocialProfilePullAudit (companyId, userId, socialNetworkProfileId);

create unique index IX_4E300401 on SPSocialProfileViewAudit (loggedInUserId, profileUserId);
create index IX_C1AC0437 on SPSocialProfileViewAudit (uuid_);