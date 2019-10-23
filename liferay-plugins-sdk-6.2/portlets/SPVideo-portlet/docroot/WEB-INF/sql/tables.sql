create table SPVideoFileEntry (
	spVideoFileEntryId BIGINT(20) not null primary key,
	groupId BIGINT(20),
	companyId BIGINT(20),
	userId BIGINT(20),
	userName VARCHAR(75) null,
	createDate DATETIME null,
	modifiedDate DATETIME null,
	fileEntryId BIGINT(20),
	fileVersionId BIGINT(20),
	folderId BIGINT(20),
	jobId VARCHAR(75) null,
	jobResponse LONGTEXT null,
	status INTEGER
);