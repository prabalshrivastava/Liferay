create index IX_9BD303D1 on SPAttrRate (ratingAttrId);
create index IX_D83DD5B1 on SPAttrRate (ratingAttrId, objId);
create index IX_C1304702 on SPAttrRate (userId, classNameId, objId);
create index IX_757B1C5 on SPAttrRate (userId, classNameId, ratingAttrId, objId);
create index IX_A2F8B9B7 on SPAttrRate (userId, ratingAttrId, objId);
create index IX_B40B00 on SPAttrRate (uuid_);
create index IX_C6611928 on SPAttrRate (uuid_, companyId);
create unique index IX_542DC9AA on SPAttrRate (uuid_, groupId);

create index IX_C46F6A9B on SPRatingAttr (name, ratingComponentId);
create index IX_6D6617FA on SPRatingAttr (ratingComponentId);
create index IX_6D016423 on SPRatingAttr (uuid_);
create index IX_67BBBC25 on SPRatingAttr (uuid_, companyId);
create unique index IX_5CDF07E7 on SPRatingAttr (uuid_, groupId);

create index IX_22C387C8 on SPRatingComponent (name);
create index IX_C9E1F2CB on SPRatingComponent (uuid_);
create index IX_D52AF47D on SPRatingComponent (uuid_, companyId);
create unique index IX_88F0763F on SPRatingComponent (uuid_, groupId);