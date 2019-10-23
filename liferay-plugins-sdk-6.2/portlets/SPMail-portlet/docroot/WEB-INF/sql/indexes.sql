create index IX_2429E6C4 on SPEMailAudit (processStateId, nodeId);
create index IX_E2A58ECB on SPEMailAudit (processStateId, nodeId, orgId);
create index IX_15063AFE on SPEMailAudit (processStateId, nodeId, userId);
create index IX_EE06E551 on SPEMailAudit (processStateId, nodeId, userId, orgId);

create unique index IX_560ED5DB on SPMailBlackList (emailAddress);
create index IX_FDA1FA02 on SPMailBlackList (spMailCampaignId);
create index IX_EC5888AF on SPMailBlackList (spMailCampaignId, bounce_soft);
create index IX_1EDEEB4A on SPMailBlackList (spMailCampaignId, bounced);
create index IX_EB31851F on SPMailBlackList (spMailCampaignId, complain);

create index IX_EBEDE7C3 on SPMailCampaignEDM (spMailCampaignId);
create index IX_CDA6880D on SPMailCampaignEDM (spMailCampaignId, seqNo);

create index IX_FE497379 on SPMailCampaignSubscribers (emailAddress);
create index IX_BCB9B705 on SPMailCampaignSubscribers (messageId);
create index IX_A5F898A0 on SPMailCampaignSubscribers (spMailCampaignId);
create index IX_CFB7FD4C on SPMailCampaignSubscribers (spMailCampaignId, emailAddress);
create index IX_6CE269AB on SPMailCampaignSubscribers (spMailCampaignId, firstName);
create index IX_36082595 on SPMailCampaignSubscribers (spMailCampaignId, lastName);
create index IX_963DEE3D on SPMailCampaignSubscribers (spMailCampaignId, opened);
create index IX_5914BC29 on SPMailCampaignSubscribers (spMailCampaignId, opened, emailAddress);
create index IX_C3585FEE on SPMailCampaignSubscribers (spMailCampaignId, opened, firstName);
create index IX_93A8DAF2 on SPMailCampaignSubscribers (spMailCampaignId, opened, lastName);
create index IX_9111EAA2 on SPMailCampaignSubscribers (spMailCampaignId, spMailType);
create unique index IX_D6D0A3CE on SPMailCampaignSubscribers (spMailCampaignId, spMailType, emailAddress);
create index IX_BE852269 on SPMailCampaignSubscribers (spMailCampaignId, spMailType, firstName);
create index IX_40EC5D17 on SPMailCampaignSubscribers (spMailCampaignId, spMailType, lastName);
create index IX_6C6E1E3F on SPMailCampaignSubscribers (spMailCampaignId, spMailType, opened);
create index IX_72E7C0AB on SPMailCampaignSubscribers (spMailCampaignId, spMailType, opened, emailAddress);
create index IX_8D8D7AAC on SPMailCampaignSubscribers (spMailCampaignId, spMailType, opened, firstName);
create index IX_79267074 on SPMailCampaignSubscribers (spMailCampaignId, spMailType, opened, lastName);
create index IX_D9146788 on SPMailCampaignSubscribers (spMailCampaignId, spMailType, status);
create index IX_22202CC7 on SPMailCampaignSubscribers (userId);
create index IX_21FE6B64 on SPMailCampaignSubscribers (userId, opened);

create index IX_CE7D68B4 on SPMailLinkTracking (spMailCampaignId, spMailCampaignSubscribersId);

create unique index IX_E670AE5B on SPMailSubscriberUserAgent (spMailCampaignId, spMailCampaignSubscribersId);

create index IX_9B879491 on SPMailTemplate (productTypeId, subProductTypeId, templateName);
create unique index IX_BE582600 on SPMailTemplate (productTypeId, subProductTypeId, templateName, versionNumber);
create index IX_79D75D7A on SPMailTemplate (status);
create index IX_EAC4426D on SPMailTemplate (templateName);
create unique index IX_FBE684A4 on SPMailTemplate (templateName, versionNumber);

create index IX_B8A1406F on SPMailUnsubscribe (emailAddress);
create index IX_92BB78DC on SPMailUnsubscribe (emailAddress, categoryId);
create index IX_39BA6A3D on SPMailUnsubscribe (userId);