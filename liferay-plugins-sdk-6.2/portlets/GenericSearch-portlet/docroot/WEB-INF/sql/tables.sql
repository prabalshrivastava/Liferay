create table SPGSFavourite (
	SPGSFavouriteId BIGINT(20) not null primary key,
	groupId BIGINT(20),
	companyId BIGINT(20),
	userId BIGINT(20),
	userName VARCHAR(75) null,
	createDate DATETIME null,
	modifiedDate DATETIME null,
	name VARCHAR(75) null,
	createdBy BIGINT(20),
	layoutId BIGINT(20),
	portletInstanceId VARCHAR(75) null,
	config LONGTEXT null,
	permissionType INTEGER
);