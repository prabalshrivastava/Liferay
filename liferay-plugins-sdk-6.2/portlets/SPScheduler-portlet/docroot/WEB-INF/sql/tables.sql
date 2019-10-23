create table SP_JOB_ENTRY (
	uuid_ VARCHAR(75) null,
	spJobEntryId BIGINT(20) not null primary key,
	groupId BIGINT(20),
	jobName VARCHAR(100) null,
	jobClass VARCHAR(200) null,
	portletId VARCHAR(200) null,
	status INTEGER,
	statusMsg VARCHAR(500) null,
	cronExpression VARCHAR(75) null,
	companyId BIGINT(20),
	userId BIGINT(20),
	userName VARCHAR(75) null,
	createDate DATETIME null,
	modifiedDate DATETIME null
);