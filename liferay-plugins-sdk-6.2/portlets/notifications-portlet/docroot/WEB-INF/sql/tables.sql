create table Ntfctns_UserNotificationEvent (
	notificationEventId BIGINT(20) not null primary key,
	companyId BIGINT(20),
	userId BIGINT(20),
	userNotificationEventId BIGINT(20),
	timestamp BIGINT(20),
	delivered BOOLEAN,
	actionRequired BOOLEAN,
	archived BOOLEAN
);