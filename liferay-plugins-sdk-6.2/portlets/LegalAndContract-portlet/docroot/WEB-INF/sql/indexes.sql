create index IX_67D07628 on SPAgency (number_, country);
create unique index IX_EDE6CE0 on SPAgency (number_, country, version);
create index IX_875C1CAC on SPAgency (uuid_);
create index IX_FE0F83FC on SPAgency (uuid_, companyId);
create unique index IX_CC60D97E on SPAgency (uuid_, groupId);

create index IX_579F2B27 on SPClassMaster (code_, country);
create index IX_7F663C71 on SPClassMaster (uuid_);
create index IX_EA804717 on SPClassMaster (uuid_, companyId);
create unique index IX_20CDA759 on SPClassMaster (uuid_, groupId);

create index IX_51279A9 on SPLitigationDetails (uuid_);
create index IX_649816DF on SPLitigationDetails (uuid_, companyId);
create unique index IX_2CA6C921 on SPLitigationDetails (uuid_, groupId);

create index IX_33A2132F on SPLitigationRDL (spLitigationId);
create index IX_A179B7D1 on SPLitigationRDL (spRdlId, spLitigationId);
create index IX_BA4D7CF1 on SPLitigationRDL (uuid_);
create index IX_EB63B697 on SPLitigationRDL (uuid_, companyId);
create unique index IX_BAC6F6D9 on SPLitigationRDL (uuid_, groupId);

create index IX_19FF372C on SPTrademarksMaster (applicationNo, country);
create unique index IX_1FDE905C on SPTrademarksMaster (applicationNo, country, version);
create index IX_94B3DCA9 on SPTrademarksMaster (registrationNumber, country);
create index IX_7F82E6D on SPTrademarksMaster (uuid_);
create index IX_DCDC7F9B on SPTrademarksMaster (uuid_, companyId);
create unique index IX_472630DD on SPTrademarksMaster (uuid_, groupId);