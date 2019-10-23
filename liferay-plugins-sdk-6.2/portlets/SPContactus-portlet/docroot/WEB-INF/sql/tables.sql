create table SPContactUs (
	spContactUsId BIGINT(20) not null primary key,
	groupId BIGINT(20),
	companyId BIGINT(20),
	userId BIGINT(20),
	userName VARCHAR(75) null,
	createDate DATETIME null,
	modifiedDate DATETIME null,
	name VARCHAR(75) null,
	lastName VARCHAR(75) null,
	emailAddress VARCHAR(75) null,
	category VARCHAR(75) null,
	comment VARCHAR(75) null,
	countryName VARCHAR(75) null,
	contactNumber BIGINT(20),
	company VARCHAR(75) null,
	jobTitle VARCHAR(75) null,
	companyUrl VARCHAR(75) null,
	noOfEmployee BIGINT(20),
	rate VARCHAR(75) null,
	typeOfEnquiry VARCHAR(75) null,
	location VARCHAR(75) null
);