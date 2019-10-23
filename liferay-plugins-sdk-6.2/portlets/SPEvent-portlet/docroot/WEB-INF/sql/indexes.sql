create index IX_D2573176 on SPRsvp (uuid_);
create index IX_8B4C6CF2 on SPRsvp (uuid_, companyId);
create unique index IX_2A8F87F4 on SPRsvp (uuid_, groupId);

create index IX_1FA358DE on SPRsvpCoParticipantDetail (spRsvpDetailId);
create index IX_8550DDBB on SPRsvpCoParticipantDetail (spRsvpDetailId, spRsvpPaymentId);
create unique index IX_2EE669EF on SPRsvpCoParticipantDetail (ticketNumber);
create index IX_27A2ECAE on SPRsvpCoParticipantDetail (uuid_);
create index IX_FBC9FEBA on SPRsvpCoParticipantDetail (uuid_, companyId);
create unique index IX_AF56EBBC on SPRsvpCoParticipantDetail (uuid_, groupId);

create index IX_7090AF1B on SPRsvpDetail (emailAddress);
create index IX_3ED24963 on SPRsvpDetail (firstName, spRsvpId);
create index IX_A0048416 on SPRsvpDetail (spRsvpId);
create index IX_B02FA242 on SPRsvpDetail (spRsvpId, emailAddress);
create index IX_5C37C625 on SPRsvpDetail (uuid_);
create index IX_B7764E3 on SPRsvpDetail (uuid_, companyId);
create unique index IX_3049C825 on SPRsvpDetail (uuid_, groupId);

create index IX_8944A306 on SPRsvpDiscount (spRsvpId);
create index IX_FC558D35 on SPRsvpDiscount (uuid_);
create index IX_B9E193D3 on SPRsvpDiscount (uuid_, companyId);
create unique index IX_BC52F315 on SPRsvpDiscount (uuid_, groupId);

create index IX_AEB19D0C on SPRsvpPayment (spRsvpDetailId);
create index IX_85F1AD94 on SPRsvpPayment (spRsvpDetailId, transactionStatus);
create unique index IX_AB73E19D on SPRsvpPayment (ticketNumber);
create index IX_54A49CC0 on SPRsvpPayment (uuid_);
create index IX_57EF68 on SPRsvpPayment (uuid_, companyId);
create unique index IX_3E652FEA on SPRsvpPayment (uuid_, groupId);

create index IX_75845D82 on SPRsvpPromoCode (promoCode);
create index IX_B2F8E231 on SPRsvpPromoCode (spRsvpId);
create index IX_C6F695EA on SPRsvpPromoCode (uuid_);
create index IX_AE6577FE on SPRsvpPromoCode (uuid_, companyId);
create unique index IX_5A47E600 on SPRsvpPromoCode (uuid_, groupId);

create index IX_A04D9651 on SPRsvpTicket (spRsvpId);
create index IX_465B55CA on SPRsvpTicket (uuid_);
create index IX_AE540C1E on SPRsvpTicket (uuid_, companyId);
create unique index IX_770D0220 on SPRsvpTicket (uuid_, groupId);