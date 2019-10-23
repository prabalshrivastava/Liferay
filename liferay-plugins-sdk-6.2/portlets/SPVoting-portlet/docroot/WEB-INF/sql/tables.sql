create table SPVoting (
	uuid_ VARCHAR(75) null,
	spVotingId BIGINT(20) not null primary key,
	groupId BIGINT(20),
	companyId BIGINT(20),
	userId BIGINT(20),
	userName VARCHAR(75) null,
	createDate DATETIME null,
	modifiedDate DATETIME null,
	className VARCHAR(75) null,
	classPK BIGINT(20),
	ip VARCHAR(75) null
);