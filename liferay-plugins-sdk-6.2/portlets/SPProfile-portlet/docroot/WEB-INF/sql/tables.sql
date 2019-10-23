create table SPProfilePreferences (
	proferenceId BIGINT(20) not null primary key,
	groupId BIGINT(20),
	companyId BIGINT(20),
	userId BIGINT(20),
	userName VARCHAR(75) null,
	createDate DATETIME null,
	modifiedDate DATETIME null,
	layoutId VARCHAR(75) null,
	portletId VARCHAR(75) null,
	preferenceName VARCHAR(75) null,
	portletPreferences VARCHAR(75) null
);