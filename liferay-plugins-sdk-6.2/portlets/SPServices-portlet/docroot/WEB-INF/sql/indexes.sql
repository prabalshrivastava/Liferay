create index IX_9C0C8FA1 on SPApiAuditLogs (uuid_);
create index IX_940715E7 on SPApiAuditLogs (uuid_, companyId);
create unique index IX_7C59EA29 on SPApiAuditLogs (uuid_, groupId);

create index IX_151AF570 on SPAudit (uuid_);
create index IX_D51C48B8 on SPAudit (uuid_, companyId);
create unique index IX_D40F9D3A on SPAudit (uuid_, groupId);

create index IX_BB9AD3D5 on SPIPGeoLocation (ipPrefix);
create index IX_63642E2C on SPIPGeoLocation (uuid_);

create index IX_3AB0F0EA on SPLdapMapping (ldapCountry, ldapDepartment, ldapCompany);

create index IX_4F4F5925 on SPLdapProfile (userId);

create index IX_96C7517 on SPLikes (companyId, groupId, className, classPK);
create unique index IX_4AB39551 on SPLikes (companyId, groupId, userId, className, classPK);
create index IX_897D9AAF on SPLikes (uuid_);
create index IX_93C83619 on SPLikes (uuid_, companyId);
create unique index IX_A1E96EDB on SPLikes (uuid_, groupId);

create index IX_6E61F67C on SPListType (groupId, categoryId);
create index IX_A5EA4DE9 on SPListType (itemKey, groupId);
create index IX_69455F97 on SPListType (itemValue, groupId);
create index IX_72B6F859 on SPListType (uuid_);
create index IX_81FA8A2F on SPListType (uuid_, companyId);
create unique index IX_EFADD071 on SPListType (uuid_, groupId);

create index IX_FD146A0E on SPMembershipPackage (extra1);
create index IX_E37406B8 on SPMembershipPackage (name);
create index IX_F19191FC on SPMembershipPackage (type_);

create index IX_BC5BC7D5 on SPMembershipPackageAddonServices (extra1, scName);
create index IX_40FEF3D0 on SPMembershipPackageAddonServices (scId);

create index IX_A9663588 on SPMembershipPackageGrpServices (mpId);
create index IX_A088BE9E on SPMembershipPackageGrpServices (mpId, extra2);
create index IX_B2EC17B5 on SPMembershipPackageGrpServices (scId);
create index IX_AC32358C on SPMembershipPackageGrpServices (scgId);

create index IX_6A7D0882 on SPMembershipPackageIndServices (mpId);
create index IX_D981F3D7 on SPMembershipPackageIndServices (mpId, extra1);
create index IX_7402EAAF on SPMembershipPackageIndServices (scId);

create index IX_44956721 on SPMembershipPackagePromotionCode (membershipPackage_id);
create index IX_BE7A7DBD on SPMembershipPackagePromotionCode (promotionCode);

create index IX_E89C42E4 on SPMembershipPackageServicesRoles (mpId);
create index IX_371F88EA on SPMembershipPackageServicesRoles (mpId, classNameId);
create index IX_60935336 on SPMembershipPackageServicesRoles (mpId, classNameId, serviceId);
create index IX_BF9AC39 on SPMembershipPackageServicesRoles (mpId, extra1);
create index IX_67E8BE49 on SPMembershipPackageServicesRoles (mpId, roleId);
create index IX_40ED9F37 on SPMembershipPackageServicesRoles (roleId);
create index IX_CC4FC94E on SPMembershipPackageServicesRoles (serviceId);

create index IX_85881750 on SPMembershipSubscribedServices (scId);
create index IX_71686FFF on SPMembershipSubscribedServices (scId, createdBy);

create index IX_771EE6D4 on SPMembershipSubscription (groupId);
create index IX_9E38265A on SPMembershipSubscription (mpId_1);
create index IX_4D901DD5 on SPMembershipSubscription (name);
create index IX_F5CF1E10 on SPMembershipSubscription (shippingEmailAddress);
create index IX_AC77F8D0 on SPMembershipSubscription (userId);
create index IX_76DA8580 on SPMembershipSubscription (userName);

create index IX_4ADFDB98 on SPMembershipSubscriptionAddonServices (description);
create index IX_32BBD369 on SPMembershipSubscriptionAddonServices (extra1);
create index IX_9E447829 on SPMembershipSubscriptionAddonServices (msId);
create index IX_A7A013D3 on SPMembershipSubscriptionAddonServices (scId);

create unique index IX_CE238417 on SPParameter (groupId, name);
create index IX_E2E49EE2 on SPParameter (uuid_);
create index IX_72FAA406 on SPParameter (uuid_, companyId);
create unique index IX_BCC87408 on SPParameter (uuid_, groupId);

create index IX_7BE1103F on SPServiceComponentGroup (name);

create index IX_E2E2DBD3 on SPServiceComponents (name);
create index IX_85010C2E on SPServiceComponents (scgId);
create index IX_C98A00AD on SPServiceComponents (technologyComponent);

create index IX_2433D844 on SPSite (userId);
create index IX_3C814CDF on SPSite (userId, authAccessId);
create index IX_9211203A on SPSite (userId, virtualHostId);
create index IX_CAF8806A on SPSite (uuid_);
create index IX_9BFFD7E on SPSite (uuid_, companyId);
create unique index IX_8D85CB80 on SPSite (uuid_, groupId);

create index IX_E45FC03C on SPSiteSetup (backOfficeVirtualHostId);
create index IX_1795631B on SPSiteSetup (productId);
create unique index IX_A2A2A759 on SPSiteSetup (productId, subProductId);
create index IX_9046890B on SPSiteSetup (productName);
create index IX_8EE33C5D on SPSiteSetup (subProductId);
create index IX_6B8319CD on SPSiteSetup (subProductName);
create index IX_55AC69B5 on SPSiteSetup (uuid_);
create index IX_D1BBE753 on SPSiteSetup (uuid_, companyId);
create unique index IX_C5AC2695 on SPSiteSetup (uuid_, groupId);
create index IX_FF7DB7FF on SPSiteSetup (virtualHostId);

create unique index IX_85444415 on SPUserConfig (userType, virtualHostId);
create index IX_D506B684 on SPUserConfig (userTypeId);
create unique index IX_C5DDF9FA on SPUserConfig (userTypeId, virtualHostId);
create index IX_6FD83D44 on SPUserConfig (uuid_);
create index IX_F6399464 on SPUserConfig (uuid_, companyId);
create unique index IX_E923E3E6 on SPUserConfig (uuid_, groupId);
create index IX_F8608C8E on SPUserConfig (virtualHostId);

create index IX_BAE01F1B on SPUserType (spSiteId);
create index IX_F1462C55 on SPUserType (spSiteId, userId);
create unique index IX_169264E9 on SPUserType (spSiteId, userId, userTypeId);
create index IX_98285EAF on SPUserType (spSiteId, userTypeId);
create index IX_6AA70E4C on SPUserType (uuid_);
create index IX_143B4E5C on SPUserType (uuid_, companyId);
create unique index IX_CDBBBBDE on SPUserType (uuid_, groupId);