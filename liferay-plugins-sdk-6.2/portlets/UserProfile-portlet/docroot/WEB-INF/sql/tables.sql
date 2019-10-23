create table SPExamBodyUser (
	examBodyUserId BIGINT(20) not null primary key,
	groupId BIGINT(20),
	companyId BIGINT(20),
	createDate DATETIME null,
	modifiedDate DATETIME null,
	emailAddress VARCHAR(75) null,
	examBody VARCHAR(75) null,
	active_ BOOLEAN
);

create table SPSocialProfile (
	uuid_ VARCHAR(75) null,
	userId BIGINT(20) not null primary key,
	groupId BIGINT(20),
	companyId BIGINT(20),
	createDate DATETIME null,
	modifiedDate DATETIME null,
	userType VARCHAR(75) null,
	memberPackage BIGINT(20),
	userRegistrationStatus VARCHAR(75) null,
	classPK BIGINT(20),
	location VARCHAR(75) null,
	profileViewCount INTEGER,
	interest LONGTEXT null,
	honors LONGTEXT null,
	groupAssociation LONGTEXT null,
	skillsQualification LONGTEXT null,
	title VARCHAR(1000) null,
	trainingEducation LONGTEXT null,
	about LONGTEXT null,
	documentId BIGINT(20),
	userInfo LONGTEXT null,
	status INTEGER,
	twitterId VARCHAR(1024) null,
	linkedinId VARCHAR(1024) null,
	yahooId VARCHAR(1024) null,
	googleId VARCHAR(1024) null,
	facebookAuthToken LONGTEXT null,
	openIdAuthToken LONGTEXT null,
	twitterAuthToken LONGTEXT null,
	linkedinAuthToken LONGTEXT null,
	yahooAuthToken LONGTEXT null,
	googleAuthToken LONGTEXT null,
	facebookAuthSecret LONGTEXT null,
	openIdAuthSecret LONGTEXT null,
	twitterAuthSecret LONGTEXT null,
	linkedinAuthSecret LONGTEXT null,
	yahooAuthSecret LONGTEXT null,
	googleAuthSecret LONGTEXT null,
	loginCount INTEGER,
	updateInterestsStatus INTEGER
);

create table SPSocialProfileDetail (
	uuid_ VARCHAR(75) null,
	spSocialProfileDetailId BIGINT(20) not null primary key,
	groupId BIGINT(20),
	companyId BIGINT(20),
	userId BIGINT(20),
	userName VARCHAR(75) null,
	createDate DATETIME null,
	modifiedDate DATETIME null,
	userJobId VARCHAR(75) null,
	companyName VARCHAR(75) null
);

create table SPSocialProfileFriends (
	spSocialProfileFriendsId BIGINT(20) not null primary key,
	companyId BIGINT(20),
	belongsToUserId BIGINT(20),
	socialNetworkProfileId BIGINT(20),
	firstName VARCHAR(75) null,
	lastName VARCHAR(75) null,
	birthday VARCHAR(75) null,
	location VARCHAR(75) null,
	pictureUrl VARCHAR(3000) null,
	userName VARCHAR(75) null,
	gender INTEGER,
	socialNetworkType INTEGER,
	createDate DATETIME null,
	modifiedDate DATETIME null
);

create table SPSocialProfileLike (
	spSocialProfileLikeId BIGINT(20) not null primary key,
	socialNetworkProfileId BIGINT(20),
	name VARCHAR(3000) null,
	category VARCHAR(75) null,
	socialNetworkLikeId BIGINT(20),
	socialNetworkType INTEGER,
	socialNetworkCreateDate DATETIME null,
	createDate DATETIME null,
	modifiedDate DATETIME null
);

create table SPSocialProfilePullAudit (
	userId BIGINT(20) not null,
	socialNetworkProfileId BIGINT(20) not null,
	companyId BIGINT(20),
	createDate DATETIME null,
	lastQueriedDate DATETIME null,
	primary key (userId, socialNetworkProfileId)
);

create table SPSocialProfileViewAudit (
	uuid_ VARCHAR(75) null,
	spSocialProfileViewAuditId BIGINT(20) not null primary key,
	loggedInUserId BIGINT(20),
	profileUserId BIGINT(20),
	lastViewDate DATETIME null
);

create table SPUserAvailabilityCalendar (
	spUserAvailabilityCalendarId BIGINT(20) not null primary key,
	groupId BIGINT(20),
	companyId BIGINT(20),
	createDate DATETIME null,
	modifiedDate DATETIME null,
	userId BIGINT(20),
	availableFor VARCHAR(75) null,
	startDate DATETIME null,
	endDate DATETIME null,
	active_ BOOLEAN
);