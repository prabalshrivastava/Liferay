create table SPCategoriesMapping (
	uuid_ VARCHAR(75) null,
	spCategoryMappingId BIGINT(20) not null primary key,
	groupId BIGINT(20),
	companyId BIGINT(20),
	userId BIGINT(20),
	userName VARCHAR(75) null,
	createDate DATETIME null,
	modifiedDate DATETIME null,
	createdVocabularyId BIGINT(20),
	mainCategoryId BIGINT(20),
	subCategoryId BIGINT(20)
);

create table SPRoles (
	uuid_ VARCHAR(75) null,
	spRoleId BIGINT(20) not null primary key,
	groupId BIGINT(20),
	companyId BIGINT(20),
	userId BIGINT(20),
	userName VARCHAR(75) null,
	createDate DATETIME null,
	modifiedDate DATETIME null,
	roleId BIGINT(20),
	categoryId1 BIGINT(20),
	categoryId2 BIGINT(20),
	countryCategoryId BIGINT(20),
	departmentCategoryId BIGINT(20)
);