create table SPFormAttachments (
	spFormAttachmentsId BIGINT(20) not null primary key,
	groupId BIGINT(20),
	companyId BIGINT(20),
	userId BIGINT(20),
	userName VARCHAR(75) null,
	createDate DATETIME null,
	modifiedDate DATETIME null,
	formStorageId BIGINT(20),
	dataKey VARCHAR(75) null,
	name VARCHAR(75) null,
	url VARCHAR(75) null,
	version VARCHAR(75) null
);

create table SPFormStorage (
	formStorageId BIGINT(20) not null primary key,
	groupId BIGINT(20),
	companyId BIGINT(20),
	userId BIGINT(20),
	userName VARCHAR(75) null,
	createDate DATETIME null,
	modifiedDate DATETIME null,
	applicationId VARCHAR(75) null,
	content STRING null,
	htmlFormId BIGINT(20),
	status VARCHAR(75) null
);