create table SPGUUploadLog (
	SPGUUploadLogId BIGINT(20) not null primary key,
	groupId BIGINT(20),
	companyId BIGINT(20),
	userId BIGINT(20),
	userName VARCHAR(75) null,
	createDate DATETIME null,
	modifiedDate DATETIME null,
	successCount INTEGER,
	errorCount INTEGER,
	startTime DATETIME null,
	endTime DATETIME null,
	uploadedFileEntryId BIGINT(20),
	errorFileEntryId BIGINT(20),
	errors VARCHAR(75) null,
	msgs VARCHAR(75) null,
	status VARCHAR(75) null
);