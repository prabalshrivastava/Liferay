create index IX_D4BDD787 on SPPECustomActionInfo (uuid_);
create index IX_E12E0241 on SPPECustomActionInfo (uuid_, companyId);
create unique index IX_53242503 on SPPECustomActionInfo (uuid_, groupId);

create index IX_7CBB0C3E on SPPEDummyEntity (name);
create index IX_9106DFC5 on SPPEDummyEntity (spPEDummyEntityId);
create index IX_AEDAFD15 on SPPEDummyEntity (uuid_);
create index IX_746177F3 on SPPEDummyEntity (uuid_, companyId);
create unique index IX_A7BD5F35 on SPPEDummyEntity (uuid_, groupId);

create index IX_42666702 on SPPEProcess (name);
create index IX_D194C5C5 on SPPEProcess (spPEProcessId);
create index IX_23619169 on SPPEProcess (status);
create index IX_9E9AFAD1 on SPPEProcess (uuid_);
create index IX_BE26CCB7 on SPPEProcess (uuid_, companyId);
create unique index IX_F99914F9 on SPPEProcess (uuid_, groupId);

create index IX_8D9BE1B3 on SPPEProcessAudit (action, type_, field2);
create index IX_3E34EDD4 on SPPEProcessAudit (doneBy, spPEProcessStateId);
create index IX_576A6DA7 on SPPEProcessAudit (spPEProcessStateId);
create index IX_2B963A93 on SPPEProcessAudit (spPEProcessStateId, field2);
create index IX_A5E1FD98 on SPPEProcessAudit (spPEProcessStateId, nodeId);
create index IX_B62451C2 on SPPEProcessAudit (spPEProcessStateId, nodeId, action);
create index IX_9689A24E on SPPEProcessAudit (spPEProcessStateId, type_);
create index IX_7AE5D83A on SPPEProcessAudit (spPEProcessStateId, type_, field2);
create index IX_A7EDFE5E on SPPEProcessAudit (type_, action, spPEProcessStateId);
create index IX_A9680E72 on SPPEProcessAudit (type_, createDate, spPEProcessStateId);
create index IX_24B28C34 on SPPEProcessAudit (type_, spPEProcessStateId);
create index IX_B834A010 on SPPEProcessAudit (uuid_);
create index IX_3F3BBA18 on SPPEProcessAudit (uuid_, companyId);
create unique index IX_101BE69A on SPPEProcessAudit (uuid_, groupId);

create index IX_1A1DD04D on SPPEProcessStage (uuid_);
create index IX_E608F1BB on SPPEProcessStage (uuid_, companyId);
create unique index IX_BF08AAFD on SPPEProcessStage (uuid_, groupId);

create index IX_DE3F560E on SPPEProcessState (spPEProcessId);
create index IX_A0CE23EB on SPPEProcessState (spPEProcessId, userIdProcess);
create index IX_CB2B0C1F on SPPEProcessState (userIdProcess);
create index IX_A203B3A9 on SPPEProcessState (userIdProcess, spPEProcessId);
create index IX_E7F05D37 on SPPEProcessState (userIdProcess, spPEProcessId, entityClassId);
create index IX_12A04F15 on SPPEProcessState (userIdProcess, spPEProcessId, entityClassId, entityId, activeStatus);
create index IX_78C5F03B on SPPEProcessState (userIdProcess, spPEProcessId, entityId);
create index IX_1AA96838 on SPPEProcessState (userIdProcess, spPEProcessId, sourceClassId, sourceEntityID, activeStatus);
create index IX_E79A750F on SPPEProcessState (userIdProcess, spPEProcessStageId);
create index IX_A9BAE41A on SPPEProcessState (uuid_);
create index IX_BAD36BCE on SPPEProcessState (uuid_, companyId);
create unique index IX_82408DD0 on SPPEProcessState (uuid_, groupId);

create index IX_C3755519 on SPPEProcessStatusType (spPEProcessId);
create index IX_3DDA1E25 on SPPEProcessStatusType (uuid_);
create index IX_416E0CE3 on SPPEProcessStatusType (uuid_, companyId);
create unique index IX_43CA7025 on SPPEProcessStatusType (uuid_, groupId);

create index IX_1C94518B on SPPERule (spPERuleSetId);
create index IX_74320BC0 on SPPERule (uuid_);
create index IX_9D5F2068 on SPPERule (uuid_, companyId);
create unique index IX_2584A0EA on SPPERule (uuid_, groupId);

create index IX_150F86D on SPPERuleSet (componentType);
create index IX_EC07AF5A on SPPERuleSet (uuid_);
create index IX_1B93188E on SPPERuleSet (uuid_, companyId);
create unique index IX_64846A90 on SPPERuleSet (uuid_, groupId);