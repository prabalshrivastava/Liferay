create table ConfigurationProperty (
	uuid_ VARCHAR(75) null,
	configurationPropertyId BIGINT(20) not null primary key,
	groupId BIGINT(20),
	companyId BIGINT(20),
	userId BIGINT(20),
	userName VARCHAR(75) null,
	createDate DATETIME null,
	modifiedDate DATETIME null,
	key_ VARCHAR(75) null,
	value VARCHAR(75) null
);