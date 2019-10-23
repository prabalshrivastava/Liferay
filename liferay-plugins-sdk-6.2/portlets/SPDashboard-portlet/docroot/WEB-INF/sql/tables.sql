create table SPAnalyticsConfig (
	spAnalyticsConfigId BIGINT(20) not null primary key,
	name VARCHAR(75) null,
	config LONGTEXT null,
	type_ INTEGER,
	query LONGTEXT null,
	warId VARCHAR(75) null
);