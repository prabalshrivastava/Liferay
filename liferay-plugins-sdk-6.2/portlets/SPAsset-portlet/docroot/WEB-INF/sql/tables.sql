create table SPAssetEntry (
	uuid_ VARCHAR(75) null,
	spAssetEntryId BIGINT(20) not null primary key,
	groupId BIGINT(20),
	companyId BIGINT(20),
	userId BIGINT(20),
	userName VARCHAR(75) null,
	createDate DATETIME null,
	modifiedDate DATETIME null,
	dlFolderId BIGINT(20),
	coverFileEntryId BIGINT(20),
	spAssetTypeId BIGINT(20),
	spAssetEntrySubType VARCHAR(75) null,
	corporateProfileUserId BIGINT(20),
	classNameId BIGINT(20),
	title VARCHAR(255) null,
	urlTitle VARCHAR(300) null,
	description LONGTEXT null,
	content VARCHAR(75) null,
	link VARCHAR(75) null,
	status BOOLEAN,
	statusByUserName VARCHAR(75) null,
	type_ VARCHAR(75) null,
	modifiedBy VARCHAR(75) null,
	allowPingbacks BOOLEAN,
	allowTrackbacks BOOLEAN,
	trackbacks VARCHAR(75) null,
	permissionType INTEGER,
	agreedToTermsOfUse BOOLEAN
);

create table SPAssetType (
	uuid_ VARCHAR(75) null,
	spAssetTypeId BIGINT(20) not null primary key,
	groupId BIGINT(20),
	companyId BIGINT(20),
	userId BIGINT(20),
	userName VARCHAR(75) null,
	createDate DATETIME null,
	modifiedDate DATETIME null,
	spAssetTypeName VARCHAR(75) null,
	status BOOLEAN,
	modifiedBy VARCHAR(75) null,
	spAssetTypeCreateUrl VARCHAR(75) null,
	spAssetTypeDetailUrl VARCHAR(75) null,
	spAssetTypeInnerDetailUrl VARCHAR(75) null,
	requiredTermsOfUse BOOLEAN,
	requiredLogin BOOLEAN,
	categoryMandatory BOOLEAN,
	notifyUponCreation BOOLEAN,
	notificationTemplateId BIGINT(20),
	allowedFileTypes VARCHAR(255) null,
	maxFileSize INTEGER,
	minImageHeight INTEGER,
	minImageWidth INTEGER
);