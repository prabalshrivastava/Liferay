create table SPConversation (
	uuid_ VARCHAR(75) null,
	spConversationId BIGINT(20) not null primary key,
	groupId BIGINT(20),
	companyId BIGINT(20),
	userId BIGINT(20),
	userName VARCHAR(75) null,
	createDate DATETIME null,
	modifiedDate DATETIME null,
	entityClassId BIGINT(20),
	entityClassName VARCHAR(75) null,
	entityId BIGINT(20),
	sentByUserId BIGINT(20),
	message VARCHAR(75) null,
	fileEntryId VARCHAR(75) null,
	associatedWith BIGINT(20),
	restricted INTEGER,
	status INTEGER,
	parentConverstationId BIGINT(20),
	currentPlId BIGINT(20)
);

create table SPConversationUser (
	spConversationUserId BIGINT(20) not null primary key,
	spConversationId BIGINT(20),
	sentToUserId BIGINT(20),
	status BIGINT(20),
	entityClassId BIGINT(20),
	entityId BIGINT(20)
);

create table SPLogActivity (
	spLogActivityId BIGINT(20) not null primary key,
	groupId BIGINT(20),
	companyId BIGINT(20),
	userId BIGINT(20),
	userName VARCHAR(75) null,
	createDate DATETIME null,
	modifiedDate DATETIME null,
	entityClassId BIGINT(20),
	entityClassName VARCHAR(75) null,
	entityId BIGINT(20),
	savedByUserId BIGINT(20),
	activityTitle VARCHAR(75) null,
	activityType VARCHAR(75) null,
	activityOutcome VARCHAR(75) null,
	activityDate DATETIME null,
	activityTime VARCHAR(75) null,
	activityContent VARCHAR(75) null,
	fileEntryId VARCHAR(75) null,
	associatedWith BIGINT(20),
	status INTEGER,
	parentLogActivityId BIGINT(20)
);

create table SPNote (
	spNoteId BIGINT(20) not null primary key,
	groupId BIGINT(20),
	companyId BIGINT(20),
	userId BIGINT(20),
	userName VARCHAR(75) null,
	createDate DATETIME null,
	modifiedDate DATETIME null,
	entityClassId BIGINT(20),
	entityClassName VARCHAR(75) null,
	entityId BIGINT(20),
	savedByUserId BIGINT(20),
	noteTitle VARCHAR(75) null,
	noteContent VARCHAR(75) null,
	fileEntryId VARCHAR(75) null,
	associatedWith BIGINT(20),
	status INTEGER,
	parentNoteId BIGINT(20)
);