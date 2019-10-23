create table SPPurchase (
	spPurchaseId BIGINT(20) not null primary key,
	groupId BIGINT(20),
	cartId BIGINT(20),
	extPaymentId VARCHAR(75) null,
	extStatus VARCHAR(75) null,
	extErrorCode BIGINT(20),
	extErrorMsg VARCHAR(75) null,
	companyId BIGINT(20),
	userId BIGINT(20),
	userName VARCHAR(75) null,
	createDate DATETIME null,
	modifiedDate DATETIME null
);