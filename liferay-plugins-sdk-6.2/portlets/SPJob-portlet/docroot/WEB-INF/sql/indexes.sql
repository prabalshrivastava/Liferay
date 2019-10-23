create index IX_2DF35E6A on SPJob (corporateId);
create index IX_8712EC9A on SPJob (corporateName);
create index IX_787D51A9 on SPJob (createdBy);
create index IX_4D6FDB84 on SPJob (groupId);
create index IX_F501A01C on SPJob (jobLocation);
create index IX_5EEE3935 on SPJob (jobTitle);
create index IX_EB2944E1 on SPJob (jobType);
create index IX_15E94CC on SPJob (status);
create index IX_CF0E7F0E on SPJob (uuid_);
create index IX_466D305A on SPJob (uuid_, companyId);
create unique index IX_AE5A055C on SPJob (uuid_, groupId);

create index IX_3FC5C913 on SPJobApplicants (groupId);
create index IX_19400D11 on SPJobApplicants (jobId);
create index IX_605C52B1 on SPJobApplicants (userId);

create index IX_CDB2967C on SPJobApplicantsCustomizedPortfolio (jobApplyId);