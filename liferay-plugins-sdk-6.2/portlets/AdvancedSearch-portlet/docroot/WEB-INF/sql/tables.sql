create table SPSearchFilter (
	uuid_ VARCHAR(75) null,
	spSearchFilterId BIGINT(20) not null primary key,
	groupId BIGINT(20),
	companyId BIGINT(20),
	userId BIGINT(20),
	userName VARCHAR(75) null,
	createDate DATETIME null,
	modifiedDate DATETIME null,
	filterName VARCHAR(150) null,
	filterParameter LONGTEXT null
);