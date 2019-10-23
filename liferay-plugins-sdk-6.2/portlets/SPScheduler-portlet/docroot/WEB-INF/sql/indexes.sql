create index IX_3893D873 on SP_JOB_ENTRY (jobName, jobClass);
create index IX_715E0520 on SP_JOB_ENTRY (uuid_);
create index IX_F3CB8B08 on SP_JOB_ENTRY (uuid_, companyId);
create unique index IX_D34B338A on SP_JOB_ENTRY (uuid_, groupId);