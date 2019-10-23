create table SPFeedback_SPFeedback (
	spFeedbackId BIGINT(20) not null primary key,
	groupId BIGINT(20),
	companyId BIGINT(20),
	userId BIGINT(20),
	userName VARCHAR(75) null,
	createDate DATETIME null,
	modifiedDate DATETIME null,
	type_ VARCHAR(2000) null,
	description LONGTEXT null
);