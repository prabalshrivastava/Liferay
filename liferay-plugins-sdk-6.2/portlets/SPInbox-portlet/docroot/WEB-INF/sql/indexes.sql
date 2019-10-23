create index IX_66791E7C on SPInboxMessage (createBy, deleteStatus);
create index IX_FDC70A15 on SPInboxMessage (createBy, deleteStatus, draft);
create index IX_B24A1622 on SPInboxMessage (createByUserId, deleteStatus);
create index IX_66454BAF on SPInboxMessage (createByUserId, deleteStatus, draft);
create index IX_D6F07F50 on SPInboxMessage (uuid_);
create index IX_D917D2D8 on SPInboxMessage (uuid_, companyId);
create unique index IX_5FA72F5A on SPInboxMessage (uuid_, groupId);

create index IX_4E2D862B on SPInboxMessageDetail (corpProfileId, archived);
create index IX_A2259CDD on SPInboxMessageDetail (corpProfileId, archived, category);
create index IX_B8425657 on SPInboxMessageDetail (corpProfileId, archived, category, receiverMsgStatus);
create index IX_297BB457 on SPInboxMessageDetail (corpProfileId, archived, category, receiverMsgStatus, senderMsgStatus);
create index IX_AA298A91 on SPInboxMessageDetail (corpProfileId, archived, category, senderMsgStatus);
create index IX_48471E49 on SPInboxMessageDetail (corpProfileId, archived, receiverMsgStatus);
create index IX_5AA58EA5 on SPInboxMessageDetail (corpProfileId, archived, receiverMsgStatus, senderMsgStatus);
create index IX_5843A703 on SPInboxMessageDetail (corpProfileId, archived, senderMsgStatus);
create index IX_89F833FD on SPInboxMessageDetail (messageId);
create index IX_7C200A09 on SPInboxMessageDetail (receiverId, archived);
create index IX_AF63633B on SPInboxMessageDetail (receiverId, archived, category);
create index IX_D91F8739 on SPInboxMessageDetail (receiverId, archived, category, receiverMsgStatus);
create index IX_216E23B5 on SPInboxMessageDetail (receiverId, archived, category, receiverMsgStatus, senderMsgStatus);
create index IX_21018BF3 on SPInboxMessageDetail (receiverId, archived, category, senderMsgStatus);
create index IX_501FA1AB on SPInboxMessageDetail (receiverId, archived, receiverMsgStatus);
create index IX_E45BFB83 on SPInboxMessageDetail (receiverId, archived, receiverMsgStatus, senderMsgStatus);
create index IX_A9C99AE5 on SPInboxMessageDetail (receiverId, archived, senderMsgStatus);
create index IX_94FCC15F on SPInboxMessageDetail (receiverId, messageId);