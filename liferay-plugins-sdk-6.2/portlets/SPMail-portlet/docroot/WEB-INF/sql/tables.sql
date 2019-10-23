create table SPEMailAudit (
	spEMailAudit BIGINT(20) not null primary key,
	groupId BIGINT(20),
	companyId BIGINT(20),
	sentTo VARCHAR(500) null,
	cc VARCHAR(500) null,
	bcc VARCHAR(500) null,
	category VARCHAR(75) null,
	subject VARCHAR(500) null,
	content LONGTEXT null,
	sentDate DATETIME null,
	messasgeId VARCHAR(75) null,
	userId BIGINT(20),
	orgId BIGINT(20),
	processStateId BIGINT(20),
	nodeId BIGINT(20)
);

create table SPMailBlackList (
	spMailBlackListId BIGINT(20) not null primary key,
	spMailCampaignId BIGINT(20),
	userId BIGINT(20),
	emailAddress VARCHAR(75) null,
	bounced BOOLEAN,
	bounce_soft BOOLEAN,
	complain BOOLEAN,
	createDate DATETIME null,
	message LONGTEXT null,
	messageId VARCHAR(500) null
);

create table SPMailCampaign (
	spMailCampaignId BIGINT(20) not null primary key,
	groupId BIGINT(20),
	companyId BIGINT(20),
	campaignName VARCHAR(250) null,
	categoryId BIGINT(20),
	mainTempalteId BIGINT(20),
	rem1TempalteId BIGINT(20),
	rem2TempalteId BIGINT(20),
	rem3TempalteId BIGINT(20),
	thankyouTempalteId BIGINT(20),
	missedyouTempalteId BIGINT(20),
	mainScheduledDate DATETIME null,
	rem1ScheduledDate DATETIME null,
	rem2ScheduledDate DATETIME null,
	rem3ScheduledDate DATETIME null,
	thankYouScheduledDate DATETIME null,
	missedyouScheduledDate DATETIME null,
	rsvpId BIGINT(20),
	dlFileEntryId BIGINT(20),
	sentBy BIGINT(20),
	sentDate DATETIME null,
	createBy BIGINT(20),
	createDate DATETIME null,
	modifiedBy BIGINT(20),
	modifiedDate DATETIME null,
	status INTEGER,
	archive BOOLEAN,
	campaignType VARCHAR(75) null
);

create table SPMailCampaignEDM (
	spMailCampaignEDMId BIGINT(20) not null primary key,
	groupId BIGINT(20),
	companyId BIGINT(20),
	userId BIGINT(20),
	userName VARCHAR(75) null,
	createDate DATETIME null,
	modifiedDate DATETIME null,
	name VARCHAR(250) null,
	spMailCampaignId BIGINT(20),
	spMailTemplateId BIGINT(20),
	seqNo INTEGER,
	dayOfWeek INTEGER,
	dayOfMonth INTEGER,
	delayUnit VARCHAR(75) null,
	status VARCHAR(75) null,
	delayAmount INTEGER,
	croneType VARCHAR(75) null,
	nextScheduleDateTime DATETIME null
);

create table SPMailCampaignSubscribers (
	spMailCampaignSubscribersId BIGINT(20) not null primary key,
	spMailCampaignId BIGINT(20),
	userId BIGINT(20),
	parentSubscriberId BIGINT(20),
	emailAddress VARCHAR(75) null,
	firstName VARCHAR(75) null,
	lastName VARCHAR(75) null,
	spMailType INTEGER,
	messageId VARCHAR(500) null,
	opened BOOLEAN,
	countryName VARCHAR(75) null,
	city VARCHAR(75) null,
	regionName VARCHAR(75) null,
	areaCode INTEGER,
	latitude VARCHAR(50) null,
	longitude VARCHAR(50) null,
	ipAddress VARCHAR(15) null,
	webVersion BOOLEAN,
	openedDate DATETIME null,
	createBy BIGINT(20),
	createDate DATETIME null,
	modifiedBy BIGINT(20),
	modifiedDate DATETIME null,
	status INTEGER
);

create table SPMailLinkTracking (
	spMailLinkTrackingId BIGINT(20) not null primary key,
	spMailCampaignId BIGINT(20),
	spMailCampaignEDMId BIGINT(20),
	spMailCampaignSubscribersId BIGINT(20),
	label VARCHAR(75) null,
	link VARCHAR(2000) null,
	encryptedlink VARCHAR(2000) null,
	status BOOLEAN,
	openedDate DATETIME null,
	createDate DATETIME null
);

create table SPMailSubscriberUserAgent (
	spMailSubscriberUserAgentId BIGINT(20) not null primary key,
	spMailCampaignSubscribersId BIGINT(20),
	spMailCampaignId BIGINT(20),
	name VARCHAR(250) null,
	type VARCHAR(250) null,
	typeName VARCHAR(250) null,
	deviceCategory VARCHAR(250) null,
	family VARCHAR(250) null,
	operatingSystem VARCHAR(250) null,
	versionNumber VARCHAR(75) null,
	userAgent LONGTEXT null
);

create table SPMailTemplate (
	spMailTemplateId BIGINT(20) not null primary key,
	productTypeId BIGINT(20),
	subProductTypeId BIGINT(20),
	templateName VARCHAR(250) null,
	groupId BIGINT(20),
	companyId BIGINT(20),
	subject VARCHAR(550) null,
	htmlContent LONGTEXT null,
	textContent LONGTEXT null,
	htmlUpload BOOLEAN,
	status BOOLEAN,
	createBy BIGINT(20),
	createDate DATETIME null,
	modifiedBy BIGINT(20),
	modifiedDate DATETIME null,
	parentTempalteId BIGINT(20),
	versionNumber VARCHAR(75) null,
	fromAddress VARCHAR(75) null,
	fromName VARCHAR(75) null
);

create table SPMailTemplateAttachment (
	spRsvpTemplateId BIGINT(20) not null primary key,
	templateId BIGINT(20),
	rsvpId BIGINT(20),
	fileEntryId BIGINT(20)
);

create table SPMailUnsubscribe (
	spMailUnsubscribeId BIGINT(20) not null primary key,
	categoryId BIGINT(20),
	userId BIGINT(20),
	emailAddress VARCHAR(75) null,
	unsubscribeDate DATETIME null
);