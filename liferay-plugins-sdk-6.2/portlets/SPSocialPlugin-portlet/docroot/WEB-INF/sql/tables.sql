create table SPSocialSharing (
	uuid_ VARCHAR(75) null,
	spSocialSharingId BIGINT(20) not null primary key,
	groupId BIGINT(20),
	companyId BIGINT(20),
	userId BIGINT(20),
	userName VARCHAR(75) null,
	createDate DATETIME null,
	modifiedDate DATETIME null,
	classNameId BIGINT(20),
	classPK BIGINT(20),
	facebook INTEGER,
	twitter INTEGER,
	linkedin INTEGER,
	yahoo INTEGER,
	google INTEGER,
	facebookPage INTEGER
);