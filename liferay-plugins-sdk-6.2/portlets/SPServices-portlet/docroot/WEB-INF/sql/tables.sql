create table SPApiAuditLogs (
	uuid_ VARCHAR(75) null,
	spApiAuditLogsId BIGINT(20) not null primary key,
	groupId BIGINT(20),
	companyId BIGINT(20),
	userId BIGINT(20),
	userName VARCHAR(75) null,
	createDate DATETIME null,
	modifiedDate DATETIME null,
	apiName VARCHAR(75) null,
	parameters LONGTEXT null,
	result LONGTEXT null
);

create table SPAudit (
	uuid_ VARCHAR(75) null,
	SPAuditId BIGINT(20) not null primary key,
	groupId BIGINT(20),
	companyId BIGINT(20),
	userId BIGINT(20),
	userName VARCHAR(75) null,
	createDate DATETIME null,
	modifiedDate DATETIME null,
	doneByUserId BIGINT(20),
	entityClassNameId BIGINT(20),
	entityId BIGINT(20),
	action VARCHAR(75) null,
	field1Str VARCHAR(75) null,
	field1Long BIGINT(20),
	field2Str VARCHAR(75) null,
	field2Long BIGINT(20),
	data1 LONGTEXT null,
	data2 LONGTEXT null
);

create table SPIPGeoLocation (
	uuid_ VARCHAR(75) null,
	spIPGeoLocationId BIGINT(20) not null primary key,
	ipPrefix VARCHAR(75) null,
	country VARCHAR(75) null
);

create table SPLdapMapping (
	spLdapMappingId BIGINT(20) not null primary key,
	groupId BIGINT(20),
	companyId BIGINT(20),
	userId BIGINT(20),
	userName VARCHAR(75) null,
	createDate DATETIME null,
	modifiedDate DATETIME null,
	countryId BIGINT(20),
	departmentId BIGINT(20),
	countryDepartmentId BIGINT(20),
	ldapCountry VARCHAR(75) null,
	ldapDepartment VARCHAR(75) null,
	ldapCompany VARCHAR(75) null,
	defaultRoleId BIGINT(20)
);

create table SPLdapProfile (
	spLdapProfileId BIGINT(20) not null primary key,
	groupId BIGINT(20),
	companyId BIGINT(20),
	createDate DATETIME null,
	modifiedDate DATETIME null,
	userId BIGINT(20),
	countryId BIGINT(20),
	departmentId BIGINT(20),
	givenName VARCHAR(75) null,
	sn VARCHAR(75) null,
	displayName VARCHAR(75) null,
	company VARCHAR(75) null,
	division VARCHAR(75) null,
	title VARCHAR(75) null,
	mail VARCHAR(75) null,
	samAccountName VARCHAR(75) null,
	employeeId VARCHAR(75) null,
	manager VARCHAR(75) null,
	telephoneNumber VARCHAR(75) null,
	mobile VARCHAR(75) null,
	facsimileTelephoneNumber VARCHAR(75) null
);

create table SPLikes (
	uuid_ VARCHAR(75) null,
	spLikesId BIGINT(20) not null primary key,
	groupId BIGINT(20),
	companyId BIGINT(20),
	userId BIGINT(20),
	userName VARCHAR(75) null,
	createDate DATETIME null,
	modifiedDate DATETIME null,
	layoutSetId BIGINT(20),
	action VARCHAR(75) null,
	actorUserId BIGINT(20),
	classId BIGINT(20),
	className VARCHAR(75) null,
	classPK BIGINT(20)
);

create table SPListType (
	uuid_ VARCHAR(75) null,
	spListTypeId BIGINT(20) not null primary key,
	groupId BIGINT(20),
	companyId BIGINT(20),
	userId BIGINT(20),
	userName VARCHAR(75) null,
	createDate DATETIME null,
	modifiedDate DATETIME null,
	itemKey VARCHAR(75) null,
	itemValue VARCHAR(75) null,
	displayName VARCHAR(75) null,
	displayOrder INTEGER,
	categoryId BIGINT(20),
	modeldata VARCHAR(75) null
);

create table SPMembershipPackage (
	mpId BIGINT(20) not null primary key,
	name VARCHAR(75) null,
	description VARCHAR(75) null,
	status VARCHAR(75) null,
	type_ VARCHAR(75) null,
	version VARCHAR(75) null,
	cost DOUBLE,
	costCurrency VARCHAR(75) null,
	costPeriod VARCHAR(75) null,
	costPeriodType VARCHAR(75) null,
	promotionCode VARCHAR(75) null,
	promotionFrom DATETIME null,
	promotionTo DATETIME null,
	discount VARCHAR(75) null,
	dateAdded DATETIME null,
	dateModified DATETIME null,
	createdBy VARCHAR(75) null,
	modifiedBy VARCHAR(75) null,
	extra1 VARCHAR(75) null,
	extra2 VARCHAR(75) null,
	extra3 VARCHAR(75) null,
	extra4 VARCHAR(75) null,
	extra5 DATETIME null,
	extra6 DATETIME null,
	extra7 VARCHAR(75) null,
	extra8 VARCHAR(75) null,
	extra9 VARCHAR(75) null,
	extra10 VARCHAR(75) null
);

create table SPMembershipPackageAddonServices (
	mpAddonId BIGINT(20) not null primary key,
	scId VARCHAR(75) null,
	scName VARCHAR(75) null,
	paramType VARCHAR(75) null,
	paramFrom VARCHAR(75) null,
	paramUpto VARCHAR(75) null,
	duration VARCHAR(75) null,
	durationType VARCHAR(75) null,
	serviceCharges DOUBLE,
	serviceChargesCurrency VARCHAR(75) null,
	serviceChargesPeriod VARCHAR(75) null,
	serviceChargesPeriodType VARCHAR(75) null,
	status VARCHAR(75) null,
	description VARCHAR(75) null,
	dateAdded DATETIME null,
	dateModified DATETIME null,
	createdBy VARCHAR(75) null,
	modifiedBy VARCHAR(75) null,
	extra1 VARCHAR(75) null,
	extra2 VARCHAR(75) null,
	extra3 VARCHAR(75) null,
	extra4 VARCHAR(75) null,
	extra5 DATETIME null,
	extra6 DATETIME null
);

create table SPMembershipPackageGrpServices (
	mpgsscId BIGINT(20) not null primary key,
	mpId BIGINT(20),
	scorder INTEGER,
	scgId VARCHAR(75) null,
	scId VARCHAR(75) null,
	paramType VARCHAR(75) null,
	paramFrom VARCHAR(75) null,
	paramUpto VARCHAR(75) null,
	duration VARCHAR(75) null,
	durationType VARCHAR(75) null,
	status VARCHAR(75) null,
	description VARCHAR(75) null,
	dateAdded DATETIME null,
	dateModified DATETIME null,
	createdBy VARCHAR(75) null,
	modifiedBy VARCHAR(75) null,
	extra1 VARCHAR(75) null,
	extra2 VARCHAR(75) null,
	extra3 VARCHAR(75) null,
	extra4 VARCHAR(75) null,
	extra5 DATETIME null,
	extra6 DATETIME null,
	serviceCharges DOUBLE,
	costCurrency VARCHAR(75) null,
	costPeriod VARCHAR(75) null,
	costPeriodType VARCHAR(75) null
);

create table SPMembershipPackageIndServices (
	mpgsscId BIGINT(20) not null primary key,
	mpId BIGINT(20),
	scorder VARCHAR(75) null,
	scgId VARCHAR(75) null,
	scId VARCHAR(75) null,
	paramType VARCHAR(75) null,
	paramFrom VARCHAR(75) null,
	paramUpto VARCHAR(75) null,
	duration VARCHAR(75) null,
	durationType VARCHAR(75) null,
	status VARCHAR(75) null,
	description VARCHAR(75) null,
	dateAdded DATETIME null,
	dateModified DATETIME null,
	createdBy VARCHAR(75) null,
	modifiedBy VARCHAR(75) null,
	extra1 VARCHAR(75) null,
	extra2 VARCHAR(75) null,
	extra3 VARCHAR(75) null,
	extra4 VARCHAR(75) null,
	extra5 DATETIME null,
	extra6 DATETIME null,
	serviceCharges DOUBLE,
	costCurrency VARCHAR(75) null,
	costPeriod VARCHAR(75) null,
	costPeriodType VARCHAR(75) null
);

create table SPMembershipPackagePromotionCode (
	promotionCode_id BIGINT(20) not null primary key,
	membershipPackage_id BIGINT(20),
	promotionCode VARCHAR(75) null,
	promotionFrom DATETIME null,
	promotionTo DATETIME null,
	discount VARCHAR(75) null,
	extra1 VARCHAR(75) null,
	extra2 VARCHAR(75) null,
	extra3 VARCHAR(75) null,
	extra4 VARCHAR(75) null,
	extra5 VARCHAR(75) null
);

create table SPMembershipPackageServicesRoles (
	mpgsrlId BIGINT(20) not null primary key,
	mpId BIGINT(20),
	serviceId BIGINT(20),
	classNameId BIGINT(20),
	roleId BIGINT(20),
	extra1 VARCHAR(75) null,
	extra2 VARCHAR(75) null,
	extra3 VARCHAR(75) null,
	extra4 VARCHAR(75) null,
	extra5 DATETIME null,
	extra6 DATETIME null
);

create table SPMembershipSubscribedServices (
	mssId BIGINT(20) not null primary key,
	userid BIGINT(20),
	companyId BIGINT(20),
	scId VARCHAR(75) null,
	scName VARCHAR(75) null,
	count VARCHAR(75) null,
	status VARCHAR(75) null,
	description VARCHAR(75) null,
	dateAdded DATETIME null,
	dateModified DATETIME null,
	createdBy VARCHAR(75) null,
	modifiedBy VARCHAR(75) null,
	effectiveFromDate DATETIME null,
	effectiveToDate DATETIME null,
	paramFrom VARCHAR(75) null,
	paramUpto VARCHAR(75) null,
	duration VARCHAR(75) null,
	durationType VARCHAR(75) null,
	serviceCharges DOUBLE,
	serviceChargesCurrency VARCHAR(75) null,
	serviceChargesPeriod VARCHAR(75) null,
	serviceChargesPeriodType VARCHAR(75) null,
	extra1 VARCHAR(75) null,
	extra2 VARCHAR(75) null,
	extra3 VARCHAR(75) null,
	extra4 VARCHAR(75) null,
	extra5 DATETIME null,
	extra6 DATETIME null
);

create table SPMembershipSubscription (
	msId BIGINT(20) not null primary key,
	name VARCHAR(75) null,
	description VARCHAR(75) null,
	mporder_1 VARCHAR(75) null,
	mpId_1 VARCHAR(75) null,
	mpName_1 VARCHAR(75) null,
	mpQty_1 INTEGER,
	mpPrice_1 DOUBLE,
	mpPriceCurrency_1 VARCHAR(75) null,
	mporder_2 VARCHAR(75) null,
	mpId_2 VARCHAR(75) null,
	mpName_2 VARCHAR(75) null,
	mpQty_2 INTEGER,
	mpPrice_2 DOUBLE,
	mpPriceCurrency_2 VARCHAR(75) null,
	mporder_3 VARCHAR(75) null,
	mpId_3 VARCHAR(75) null,
	mpName_3 VARCHAR(75) null,
	mpQty_3 INTEGER,
	mpPrice_3 DOUBLE,
	mpPriceCurrency_3 VARCHAR(75) null,
	mporder_4 VARCHAR(75) null,
	mpId_4 VARCHAR(75) null,
	mpName_4 VARCHAR(75) null,
	mpQty_4 INTEGER,
	mpPrice_4 DOUBLE,
	mpPriceCurrency_4 VARCHAR(75) null,
	mpSubtotal DOUBLE,
	mpSubtotalCurrency VARCHAR(75) null,
	addOnSubtotal DOUBLE,
	addOnSubtotalCurrency VARCHAR(75) null,
	tax DOUBLE,
	comments VARCHAR(75) null,
	promotionCode VARCHAR(75) null,
	promotionFrom DATETIME null,
	promotionTo DATETIME null,
	discount VARCHAR(75) null,
	nettotal DOUBLE,
	nettotalCurrency VARCHAR(75) null,
	ppTxnId VARCHAR(75) null,
	ppPaymentStatus VARCHAR(75) null,
	ppPaymentGross DOUBLE,
	ppReceiverEmail VARCHAR(75) null,
	ppPayerEmail VARCHAR(75) null,
	sendOrderEmail VARCHAR(75) null,
	sendShippingEmail VARCHAR(75) null,
	effectiveFromDate DATETIME null,
	effectiveToDate DATETIME null,
	altShipping INTEGER,
	shipping DOUBLE,
	requiresShipping BOOLEAN,
	insure BOOLEAN,
	insurance DOUBLE,
	billingFirstName VARCHAR(75) null,
	billingLastName VARCHAR(75) null,
	billingEmailAddress VARCHAR(75) null,
	billingCompany VARCHAR(75) null,
	billingStreet VARCHAR(75) null,
	billingCity VARCHAR(75) null,
	billingState VARCHAR(75) null,
	billingZip VARCHAR(75) null,
	billingCountry VARCHAR(75) null,
	billingPhone VARCHAR(75) null,
	shipToBilling BOOLEAN,
	shippingFirstName VARCHAR(75) null,
	shippingLastName VARCHAR(75) null,
	shippingEmailAddress VARCHAR(75) null,
	shippingCompany VARCHAR(75) null,
	shippingStreet VARCHAR(75) null,
	shippingCity VARCHAR(75) null,
	shippingState VARCHAR(75) null,
	shippingZip VARCHAR(75) null,
	shippingCountry VARCHAR(75) null,
	shippingPhone VARCHAR(75) null,
	ccName VARCHAR(75) null,
	ccType VARCHAR(75) null,
	ccNumber VARCHAR(75) null,
	ccExpMonth INTEGER,
	ccExpYear INTEGER,
	ccVerNumber VARCHAR(75) null,
	groupId BIGINT(20),
	companyId BIGINT(20),
	userId BIGINT(20),
	userName VARCHAR(75) null,
	createDate DATETIME null,
	modifiedDate DATETIME null
);

create table SPMembershipSubscriptionAddonServices (
	msAddonId BIGINT(20) not null primary key,
	msId BIGINT(20),
	scId VARCHAR(75) null,
	scName VARCHAR(75) null,
	paramType VARCHAR(75) null,
	paramFrom VARCHAR(75) null,
	paramUpto VARCHAR(75) null,
	duration VARCHAR(75) null,
	durationType VARCHAR(75) null,
	serviceCharges DOUBLE,
	serviceChargesCurrency VARCHAR(75) null,
	serviceChargesPeriod VARCHAR(75) null,
	serviceChargesPeriodType VARCHAR(75) null,
	status VARCHAR(75) null,
	description VARCHAR(75) null,
	effectiveFromDate DATETIME null,
	effectiveToDate DATETIME null,
	dateAdded DATETIME null,
	dateModified DATETIME null,
	createdBy VARCHAR(75) null,
	modifiedBy VARCHAR(75) null,
	extra1 VARCHAR(75) null,
	extra2 VARCHAR(75) null,
	extra3 VARCHAR(75) null,
	extra4 VARCHAR(75) null,
	extra5 DATETIME null,
	extra6 DATETIME null
);

create table SPParameter (
	uuid_ VARCHAR(75) null,
	spParameterId BIGINT(20) not null primary key,
	groupId BIGINT(20),
	companyId BIGINT(20),
	userId BIGINT(20),
	userName VARCHAR(75) null,
	createDate DATETIME null,
	modifiedDate DATETIME null,
	category VARCHAR(75) null,
	description LONGTEXT null,
	name VARCHAR(500) null,
	value LONGTEXT null
);

create table SPServiceComponentGroup (
	scgId BIGINT(20) not null primary key,
	name VARCHAR(75) null,
	description VARCHAR(75) null,
	phase VARCHAR(75) null,
	status VARCHAR(75) null,
	version VARCHAR(75) null,
	deploymentCluster VARCHAR(75) null,
	community VARCHAR(75) null,
	dateAdded DATETIME null,
	dateModified DATETIME null,
	author VARCHAR(75) null,
	extra1 VARCHAR(75) null,
	extra2 VARCHAR(75) null,
	extra3 VARCHAR(75) null,
	extra4 VARCHAR(75) null,
	extra5 DATETIME null,
	extra6 DATETIME null
);

create table SPServiceComponents (
	scId BIGINT(20) not null primary key,
	scgId BIGINT(20),
	name VARCHAR(75) null,
	description VARCHAR(75) null,
	technologyComponent VARCHAR(75) null,
	phase VARCHAR(75) null,
	status VARCHAR(75) null,
	version VARCHAR(75) null,
	serviceType VARCHAR(75) null,
	ServiceExposureType VARCHAR(75) null,
	userType VARCHAR(75) null,
	platformType VARCHAR(75) null,
	islaCarteService BOOLEAN,
	isExternal BOOLEAN,
	tag VARCHAR(75) null,
	webserviceURL VARCHAR(75) null,
	deploymentCluster VARCHAR(75) null,
	deploymentLocation VARCHAR(75) null,
	channelID VARCHAR(75) null,
	testPlan VARCHAR(75) null,
	performanceProfile VARCHAR(75) null,
	usageStatistics VARCHAR(75) null,
	dateAdded DATETIME null,
	dateModified DATETIME null,
	author VARCHAR(75) null,
	extra1 VARCHAR(75) null,
	extra2 VARCHAR(75) null,
	extra3 VARCHAR(75) null,
	extra4 VARCHAR(75) null,
	extra5 DATETIME null,
	extra6 DATETIME null,
	serviceCharges DOUBLE
);

create table SPSite (
	uuid_ VARCHAR(75) null,
	spSiteId BIGINT(20) not null primary key,
	groupId BIGINT(20),
	companyId BIGINT(20),
	userId BIGINT(20),
	userName VARCHAR(75) null,
	createDate DATETIME null,
	modifiedDate DATETIME null,
	virtualHostId BIGINT(20),
	layoutSetId BIGINT(20),
	authAccessId BIGINT(20),
	loginType BIGINT(20),
	password_ VARCHAR(75) null,
	active_ BOOLEAN
);

create table SPSiteSetup (
	uuid_ VARCHAR(75) null,
	spSiteSetupId BIGINT(20) not null primary key,
	groupId BIGINT(20),
	productId BIGINT(20),
	productName VARCHAR(75) null,
	subProductId BIGINT(20),
	subProductName VARCHAR(75) null,
	virtualHostId BIGINT(20),
	backOfficeVirtualHostId BIGINT(20),
	companyId BIGINT(20),
	createdBy BIGINT(20),
	modifiedBy BIGINT(20),
	createdDate DATETIME null,
	modifiedDate DATETIME null
);

create table SPUserConfig (
	uuid_ VARCHAR(75) null,
	spUserTypeConfigId BIGINT(20) not null primary key,
	userType VARCHAR(75) null,
	userTypeId BIGINT(20),
	virtualHostId BIGINT(20),
	declarationId BIGINT(20),
	declarationYearly BOOLEAN,
	declarationFixedDate DATETIME null,
	pdpaId BIGINT(20),
	accountCreationTemplateName VARCHAR(75) null,
	welcomeTemplateName VARCHAR(75) null,
	passwordChangeTemplateName VARCHAR(75) null,
	passwordResetTemplateName VARCHAR(75) null,
	emailVerificationTemplateName VARCHAR(75) null,
	defauleRoleIds VARCHAR(75) null,
	validations VARCHAR(75) null,
	groupId BIGINT(20),
	companyId BIGINT(20),
	createdBy BIGINT(20),
	modifiedBy BIGINT(20),
	createdDate DATETIME null,
	modifiedDate DATETIME null
);

create table SPUserType (
	uuid_ VARCHAR(75) null,
	spUserTypeId BIGINT(20) not null primary key,
	spSiteId BIGINT(20),
	userId BIGINT(20),
	userTypeId BIGINT(20),
	userStatusId BIGINT(20),
	declarationCompleted BOOLEAN,
	declarationDate BIGINT(20),
	declarationStorageId BIGINT(20),
	pdpaCompleted BOOLEAN,
	pdpaCompletionDate BIGINT(20),
	groupId BIGINT(20),
	companyId BIGINT(20),
	createdBy BIGINT(20),
	modifiedBy BIGINT(20),
	createdDate DATETIME null,
	modifiedDate DATETIME null
);