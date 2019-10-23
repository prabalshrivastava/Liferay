create table SPCart (
	spCartId BIGINT(20) not null primary key,
	groupId BIGINT(20),
	discount VARCHAR(75) null,
	totalPrice VARCHAR(75) null,
	userRemarks VARCHAR(75) null,
	status INTEGER,
	transactionDetails VARCHAR(75) null,
	orderPage VARCHAR(75) null,
	rsvpDetailId BIGINT(20),
	companyId BIGINT(20),
	userId BIGINT(20),
	userName VARCHAR(75) null,
	createDate DATETIME null,
	modifiedDate DATETIME null
);

create table SPCartPackage (
	spCartPackageId BIGINT(20) not null primary key,
	groupId BIGINT(20),
	cartId BIGINT(20),
	packageId BIGINT(20),
	selectedCurrency VARCHAR(75) null,
	usedDiscountRefId BIGINT(20),
	usedDiscountRefPCId BIGINT(20),
	discount VARCHAR(75) null,
	initialPrice VARCHAR(75) null,
	totalPrice VARCHAR(75) null,
	remarks VARCHAR(75) null,
	companyId BIGINT(20),
	userId BIGINT(20),
	userName VARCHAR(75) null,
	createDate DATETIME null,
	modifiedDate DATETIME null
);

create table SPCartPackageItem (
	spCartPackageItemId BIGINT(20) not null primary key,
	groupId BIGINT(20),
	spCartPackageId BIGINT(20),
	title VARCHAR(75) null,
	itemCode VARCHAR(75) null,
	quantity INTEGER,
	entityClassPk BIGINT(20),
	entityClassName VARCHAR(75) null,
	totalPrice VARCHAR(75) null,
	companyId BIGINT(20),
	userId BIGINT(20),
	userName VARCHAR(75) null,
	createDate DATETIME null,
	modifiedDate DATETIME null
);

create table SPDiscount (
	spDiscountId BIGINT(20) not null primary key,
	groupId BIGINT(20),
	title VARCHAR(75) null,
	percent BOOLEAN,
	packageId BIGINT(20),
	value VARCHAR(75) null,
	couponCode VARCHAR(75) null,
	description VARCHAR(75) null,
	startDate DATETIME null,
	endDate DATETIME null,
	minQuantity INTEGER,
	maxQuantity INTEGER,
	active_ BOOLEAN,
	companyId BIGINT(20),
	userId BIGINT(20),
	userName VARCHAR(75) null,
	createDate DATETIME null,
	modifiedDate DATETIME null
);

create table SPPackageItems (
	spPackageItemsId BIGINT(20) not null primary key,
	groupId BIGINT(20),
	packageId BIGINT(20),
	itemId BIGINT(20),
	quantity INTEGER,
	companyId BIGINT(20),
	userId BIGINT(20),
	userName VARCHAR(75) null,
	createDate DATETIME null,
	modifiedDate DATETIME null
);

create table SPSellingItem (
	spSellingItemId BIGINT(20) not null primary key,
	groupId BIGINT(20),
	title VARCHAR(500) null,
	itemCode VARCHAR(75) null,
	entityClassPk BIGINT(20),
	entityClassNameId BIGINT(20),
	entityClassName VARCHAR(75) null,
	shortDescription VARCHAR(500) null,
	longDescription LONGTEXT null,
	active_ BOOLEAN,
	companyId BIGINT(20),
	userId BIGINT(20),
	userName VARCHAR(75) null,
	createDate DATETIME null,
	modifiedDate DATETIME null
);

create table SPSellingPackage (
	spSellingPackageId BIGINT(20) not null primary key,
	groupId BIGINT(20),
	title VARCHAR(500) null,
	pkgCode VARCHAR(75) null,
	shortDescription VARCHAR(500) null,
	longDescription LONGTEXT null,
	currencyCode VARCHAR(75) null,
	startDate DATETIME null,
	endDate DATETIME null,
	notify VARCHAR(75) null,
	needsPayment BOOLEAN,
	orderPage VARCHAR(75) null,
	orderSequence VARCHAR(75) null,
	active_ BOOLEAN,
	companyId BIGINT(20),
	userId BIGINT(20),
	userName VARCHAR(75) null,
	createDate DATETIME null,
	modifiedDate DATETIME null
);

create table SPSellingPrice (
	spSellingPriceId BIGINT(20) not null primary key,
	groupId BIGINT(20),
	priceRefId BIGINT(20),
	priceRefTypeId BIGINT(20),
	currencyCode VARCHAR(75) null,
	basePrice VARCHAR(75) null,
	taxName VARCHAR(75) null,
	taxValue VARCHAR(75) null,
	totalPrice VARCHAR(75) null,
	companyId BIGINT(20),
	userId BIGINT(20),
	userName VARCHAR(75) null,
	createDate DATETIME null,
	modifiedDate DATETIME null
);

create table SPTax (
	spTaxId BIGINT(20) not null primary key,
	groupId BIGINT(20),
	currencyCode VARCHAR(75) null,
	taxName VARCHAR(75) null,
	taxValue BIGINT(20),
	companyId BIGINT(20),
	userId BIGINT(20),
	userName VARCHAR(75) null,
	createDate DATETIME null,
	modifiedDate DATETIME null
);