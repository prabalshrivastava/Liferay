create table SPAttrRate (
	uuid_ VARCHAR(75) null,
	spAttrRateId BIGINT(20) not null primary key,
	groupId BIGINT(20),
	companyId BIGINT(20),
	userId BIGINT(20),
	userName VARCHAR(75) null,
	createDate DATETIME null,
	modifiedDate DATETIME null,
	objId VARCHAR(75) null,
	classNameId BIGINT(20),
	ratingAttrId BIGINT(20),
	value DOUBLE
);

create table SPRatingAttr (
	uuid_ VARCHAR(75) null,
	spRatingAttrId BIGINT(20) not null primary key,
	groupId BIGINT(20),
	companyId BIGINT(20),
	userId BIGINT(20),
	userName VARCHAR(75) null,
	createDate DATETIME null,
	modifiedDate DATETIME null,
	ratingComponentId BIGINT(20),
	name VARCHAR(75) null,
	weight DOUBLE,
	visible BOOLEAN
);

create table SPRatingComponent (
	uuid_ VARCHAR(75) null,
	spRatingComponentId BIGINT(20) not null primary key,
	groupId BIGINT(20),
	companyId BIGINT(20),
	userId BIGINT(20),
	userName VARCHAR(75) null,
	createDate DATETIME null,
	modifiedDate DATETIME null,
	name VARCHAR(75) null,
	classNameId BIGINT(20)
);