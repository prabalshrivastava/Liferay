create table SPGroup (
	uuid_ VARCHAR(75) null,
	spGroupId BIGINT(20) not null primary key,
	groupId BIGINT(20),
	companyId BIGINT(20),
	userId BIGINT(20),
	userName VARCHAR(75) null,
	createDate DATETIME null,
	modifiedDate DATETIME null,
	title VARCHAR(75) null,
	urlTitle VARCHAR(75) null,
	description VARCHAR(256) null,
	imageId BIGINT(20),
	type_ INTEGER,
	status INTEGER
);

create table SPGroupPref (
	spGroupPrefId BIGINT(20) not null primary key,
	groupId BIGINT(20),
	companyId BIGINT(20),
	userId BIGINT(20),
	userName VARCHAR(75) null,
	createDate DATETIME null,
	modifiedDate DATETIME null,
	dIn BOOLEAN,
	dGoogle BOOLEAN,
	dFb BOOLEAN,
	dTw BOOLEAN,
	cIn BOOLEAN,
	cGoogle BOOLEAN,
	cFb BOOLEAN,
	cTw BOOLEAN,
	enableSubscribeToComments BOOLEAN,
	enableGroupUpdateNotification BOOLEAN,
	enableMemberUpdate BOOLEAN,
	enableDiscussionUpdate BOOLEAN,
	updateFrequency VARCHAR(75) null
);

create table SPGroupUser (
	spGroupId BIGINT(20) not null,
	userId BIGINT(20) not null,
	groupId BIGINT(20),
	companyId BIGINT(20),
	userName VARCHAR(75) null,
	createDate DATETIME null,
	modifiedDate DATETIME null,
	joinDate DATETIME null,
	role INTEGER,
	status INTEGER,
	primary key (spGroupId, userId)
);