create index IX_79EAA7E6 on SPComponentTemplate (spTemplateId);
create index IX_C8AB70B4 on SPComponentTemplate (uuid_);
create index IX_AD30DAF4 on SPComponentTemplate (uuid_, companyId);
create unique index IX_4F5B8E76 on SPComponentTemplate (uuid_, groupId);

create index IX_5451416 on SPTemplate (templateName);
create index IX_C656B317 on SPTemplate (uuid_);
create index IX_CCFB4CB1 on SPTemplate (uuid_, companyId);
create unique index IX_E9A14B73 on SPTemplate (uuid_, groupId);

create index IX_2A2967C1 on SPTemplateManagement_SPComponentTemplate (spTemplateId);
create index IX_65470139 on SPTemplateManagement_SPComponentTemplate (uuid_);
create index IX_9E06354F on SPTemplateManagement_SPComponentTemplate (uuid_, companyId);
create unique index IX_EAE9C391 on SPTemplateManagement_SPComponentTemplate (uuid_, groupId);

create index IX_5A2501DB on SPTemplateManagement_SPTemplate (templateName);
create index IX_6D8E88F2 on SPTemplateManagement_SPTemplate (uuid_);
create index IX_B0F4CFF6 on SPTemplateManagement_SPTemplate (uuid_, companyId);
create unique index IX_863CDBF8 on SPTemplateManagement_SPTemplate (uuid_, groupId);