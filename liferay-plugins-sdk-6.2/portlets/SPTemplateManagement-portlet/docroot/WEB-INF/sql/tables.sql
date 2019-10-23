create table SPComponentTemplate (
	uuid_ VARCHAR(75) null,
	spComponentTemplateId BIGINT(20) not null primary key,
	groupId BIGINT(20),
	companyId BIGINT(20),
	userId BIGINT(20),
	userName VARCHAR(75) null,
	createDate DATETIME null,
	modifiedDate DATETIME null,
	createBy BIGINT(20),
	modifiedBy BIGINT(20),
	spTemplateId BIGINT(20),
	level0ClassNameId BIGINT(20),
	level0FormId BIGINT(20),
	level1ClassNameId BIGINT(20),
	level1FormId BIGINT(20),
	level2ClassNameId BIGINT(20),
	level2FormId BIGINT(20),
	level3ClassNameId BIGINT(20),
	level3FormId BIGINT(20),
	level4ClassNameId BIGINT(20),
	level4FormId BIGINT(20),
	level5ClassNameId BIGINT(20),
	level5FormId BIGINT(20),
	level6ClassNameId BIGINT(20),
	level6FormId BIGINT(20),
	level7ClassNameId BIGINT(20),
	level7FormId BIGINT(20),
	level8ClassNameId BIGINT(20),
	level8FormId BIGINT(20),
	level9ClassNameId BIGINT(20),
	level9FormId BIGINT(20),
	level10ClassNameId BIGINT(20),
	level10FormId BIGINT(20),
	status INTEGER
);

create table SPTemplate (
	uuid_ VARCHAR(75) null,
	spTemplateId BIGINT(20) not null primary key,
	groupId BIGINT(20),
	companyId BIGINT(20),
	userId BIGINT(20),
	userName VARCHAR(75) null,
	createDate DATETIME null,
	modifiedDate DATETIME null,
	createBy BIGINT(20),
	modifiedBy BIGINT(20),
	classNameId BIGINT(20),
	classPK BIGINT(20),
	templateName VARCHAR(75) null,
	status INTEGER
);

create table SPTemplateManagement_SPComponentTemplate (
	uuid_ VARCHAR(75) null,
	spComponentTemplateId BIGINT(20) not null primary key,
	groupId BIGINT(20),
	companyId BIGINT(20),
	userId BIGINT(20),
	userName VARCHAR(75) null,
	createDate DATETIME null,
	modifiedDate DATETIME null,
	createBy BIGINT(20),
	modifiedBy BIGINT(20),
	spTemplateId BIGINT(20),
	level0ClassNameId BIGINT(20),
	level0FormId BIGINT(20),
	level1ClassNameId BIGINT(20),
	level1FormId BIGINT(20),
	level2ClassNameId BIGINT(20),
	level2FormId BIGINT(20),
	level3ClassNameId BIGINT(20),
	level3FormId BIGINT(20),
	level4ClassNameId BIGINT(20),
	level4FormId BIGINT(20),
	level5ClassNameId BIGINT(20),
	level5FormId BIGINT(20),
	level6ClassNameId BIGINT(20),
	level6FormId BIGINT(20),
	level7ClassNameId BIGINT(20),
	level7FormId BIGINT(20),
	level8ClassNameId BIGINT(20),
	level8FormId BIGINT(20),
	level9ClassNameId BIGINT(20),
	level9FormId BIGINT(20),
	level10ClassNameId BIGINT(20),
	level10FormId BIGINT(20),
	status INTEGER
);

create table SPTemplateManagement_SPTemplate (
	uuid_ VARCHAR(75) null,
	spTemplateId BIGINT(20) not null primary key,
	groupId BIGINT(20),
	companyId BIGINT(20),
	userId BIGINT(20),
	userName VARCHAR(75) null,
	createDate DATETIME null,
	modifiedDate DATETIME null,
	createBy BIGINT(20),
	modifiedBy BIGINT(20),
	classNameId BIGINT(20),
	classPK BIGINT(20),
	templateName VARCHAR(75) null,
	status INTEGER
);