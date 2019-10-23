create table SPInboxMessage (
	uuid_ VARCHAR(75) null,
	messageId BIGINT(20) not null primary key,
	parentMessageId BIGINT(20),
	groupId BIGINT(20),
	companyId BIGINT(20),
	subject LONGTEXT null,
	content LONGTEXT null,
	from_ VARCHAR(200) null,
	to_ LONGTEXT null,
	allowOpen BOOLEAN,
	sendDate DATETIME null,
	createDate DATETIME null,
	createBy VARCHAR(75) null,
	createByUserId VARCHAR(75) null,
	draft BOOLEAN,
	deleteStatus BOOLEAN,
	draftStatus VARCHAR(75) null,
	sentMeCopy BOOLEAN,
	belongToGroupDetailId BIGINT(20)
);

create table SPInboxMessageDetail (
	ibMsgDetailId BIGINT(20) not null primary key,
	receiverId BIGINT(20),
	messageId BIGINT(20),
	receiverMsgStatus VARCHAR(75) null,
	senderMsgStatus VARCHAR(75) null,
	status VARCHAR(75) null,
	receiveDate DATETIME null,
	receiveBy VARCHAR(75) null,
	archived BOOLEAN,
	updateDate DATETIME null,
	updateBy VARCHAR(75) null,
	category VARCHAR(75) null,
	processId BIGINT(20),
	corpProfileId BIGINT(20)
);