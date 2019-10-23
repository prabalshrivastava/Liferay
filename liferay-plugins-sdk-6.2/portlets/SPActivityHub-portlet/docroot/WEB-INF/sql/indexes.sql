create index IX_36D925BF on SPConversation (associatedWith, restricted, entityId, entityClassId, status);
create index IX_7678BA88 on SPConversation (entityClassId, entityId, parentConverstationId);
create index IX_5E708632 on SPConversation (entityClassId, entityId, status);
create index IX_86A253AE on SPConversation (uuid_);
create index IX_10F437BA on SPConversation (uuid_, companyId);
create unique index IX_4BBB64BC on SPConversation (uuid_, groupId);

create index IX_401B8CAE on SPConversationUser (sentToUserId, status, entityClassId, entityId);
create index IX_5BA1ED20 on SPConversationUser (spConversationId);

create index IX_4AEED41E on SPLogActivity (entityClassId, entityId, parentLogActivityId);

create index IX_FE2F20E8 on SPNote (entityClassId, entityId, parentNoteId);