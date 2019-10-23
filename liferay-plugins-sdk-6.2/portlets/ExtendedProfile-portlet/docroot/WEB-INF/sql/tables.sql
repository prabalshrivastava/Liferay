create table SPCertification (
	classPk BIGINT(20) not null primary key,
	groupId BIGINT(20),
	companyId BIGINT(20),
	userId BIGINT(20),
	userName VARCHAR(75) null,
	createDate DATETIME null,
	modifiedDate DATETIME null,
	certificationId BIGINT(20)
);

create table SPCompetency (
	classpk BIGINT(20) not null primary key,
	groupId BIGINT(20),
	companyId BIGINT(20),
	userId BIGINT(20),
	userName VARCHAR(75) null,
	createDate DATETIME null,
	modifiedDate DATETIME null,
	categoryId BIGINT(20),
	competencyId BIGINT(20),
	competencyLevelId BIGINT(20),
	belongsToJobRole BIGINT(20),
	publicView BOOLEAN
);

create table SPJobRole (
	spJobRoleId BIGINT(20) not null primary key,
	groupId BIGINT(20),
	companyId BIGINT(20),
	userId BIGINT(20),
	userName VARCHAR(75) null,
	createDate DATETIME null,
	modifiedDate DATETIME null,
	functionalGroupId BIGINT(20),
	JobLevelId BIGINT(20),
	careerPathId BIGINT(20)
);