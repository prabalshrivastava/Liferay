create index IX_EE5704AA on SPCategoriesMapping (groupId, createdVocabularyId);
create index IX_3014A295 on SPCategoriesMapping (groupId, mainCategoryId);
create index IX_EE98E054 on SPCategoriesMapping (groupId, mainCategoryId, subCategoryId);
create index IX_201F7899 on SPCategoriesMapping (uuid_);
create index IX_A2AB61EF on SPCategoriesMapping (uuid_, companyId);
create unique index IX_A2319831 on SPCategoriesMapping (uuid_, groupId);

create index IX_DD53404 on SPRoles (groupId, categoryId1);
create index IX_54E5BD1B on SPRoles (groupId, countryCategoryId);
create index IX_9EB68FBA on SPRoles (groupId, countryCategoryId, departmentCategoryId);
create index IX_FC1A6B23 on SPRoles (groupId, departmentCategoryId);
create index IX_408028A9 on SPRoles (groupId, roleId);
create index IX_A08D84BF on SPRoles (groupId, roleId, categoryId1);
create index IX_9B25002A on SPRoles (groupId, roleId, categoryId1, categoryId2);
create index IX_A08D8880 on SPRoles (groupId, roleId, categoryId2);
create index IX_737420CE on SPRoles (uuid_);
create index IX_DF24F69A on SPRoles (uuid_, companyId);
create unique index IX_92CE5B9C on SPRoles (uuid_, groupId);