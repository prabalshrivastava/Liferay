create table enrolment_EnrollBatchUpload (
	uploadStatId BIGINT(20) not null primary key,
	uploadTransactId VARCHAR(75) null,
	errorField VARCHAR(75) null,
	errorReason VARCHAR(75) null,
	uploadedRecId BIGINT(20),
	userId BIGINT(20),
	createDate DATETIME null,
	modifiedDate DATETIME null
);

create table enrolment_EnrollUploadedTempRecords (
	uploadedRecId BIGINT(20) not null primary key,
	uploadTransactId VARCHAR(75) null,
	sprCode VARCHAR(75) null,
	title VARCHAR(75) null,
	fullOfficialName VARCHAR(75) null,
	gender VARCHAR(75) null,
	dateofBirth VARCHAR(75) null,
	email VARCHAR(75) null,
	userId BIGINT(20),
	createDate DATETIME null,
	modifiedDate DATETIME null
);