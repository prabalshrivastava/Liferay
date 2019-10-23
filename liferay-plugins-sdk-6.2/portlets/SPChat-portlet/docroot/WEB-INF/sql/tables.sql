create table SPChatEntry (
	entryId BIGINT(20) not null primary key,
	createDate BIGINT(20),
	fromUserId BIGINT(20),
	toUserId BIGINT(20),
	content VARCHAR(200) null,
	flag INTEGER
);

create table SPChatStatus (
	statusId BIGINT(20) not null primary key,
	userId BIGINT(20),
	modifiedDate BIGINT(20),
	online_ BOOLEAN,
	awake BOOLEAN,
	activePanelIds VARCHAR(75) null,
	message VARCHAR(75) null,
	playSound BOOLEAN
);