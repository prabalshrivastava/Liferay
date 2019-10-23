create index IX_8815ACE1 on SPChatEntry (createDate);
create index IX_9771FC65 on SPChatEntry (createDate, fromUserId);
create index IX_EE3E197A on SPChatEntry (createDate, fromUserId, toUserId);
create index IX_8CC5EF6 on SPChatEntry (createDate, toUserId);
create index IX_A6BCF727 on SPChatEntry (fromUserId);
create index IX_14E809BC on SPChatEntry (fromUserId, toUserId);
create index IX_CDAC532D on SPChatEntry (fromUserId, toUserId, content);
create index IX_58BB2238 on SPChatEntry (toUserId);

create index IX_CD7DA138 on SPChatStatus (modifiedDate);
create index IX_A1401664 on SPChatStatus (modifiedDate, online_);
create index IX_74D5F18F on SPChatStatus (online_);
create unique index IX_4EFED4E7 on SPChatStatus (userId);