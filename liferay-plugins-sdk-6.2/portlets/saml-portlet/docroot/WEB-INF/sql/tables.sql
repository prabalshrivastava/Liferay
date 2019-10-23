create table SamlIdpSpConnection (
	samlIdpSpConnectionId BIGINT(20) not null primary key,
	companyId BIGINT(20),
	userId BIGINT(20),
	userName VARCHAR(75) null,
	createDate DATETIME null,
	modifiedDate DATETIME null,
	samlSpEntityId VARCHAR(1024) null,
	assertionLifetime INTEGER,
	attributeNames STRING null,
	attributesEnabled BOOLEAN,
	attributesNamespaceEnabled BOOLEAN,
	enabled BOOLEAN,
	metadataUrl VARCHAR(1024) null,
	metadataXml LONGTEXT null,
	metadataUpdatedDate DATETIME null,
	name VARCHAR(75) null,
	nameIdAttribute VARCHAR(1024) null,
	nameIdFormat VARCHAR(1024) null
);

create table SamlIdpSpSession (
	samlIdpSpSessionId BIGINT(20) not null primary key,
	companyId BIGINT(20),
	userId BIGINT(20),
	userName VARCHAR(75) null,
	createDate DATETIME null,
	modifiedDate DATETIME null,
	samlIdpSsoSessionId BIGINT(20),
	samlSpEntityId VARCHAR(1024) null,
	nameIdFormat VARCHAR(1024) null,
	nameIdValue VARCHAR(1024) null
);

create table SamlIdpSsoSession (
	samlIdpSsoSessionId BIGINT(20) not null primary key,
	companyId BIGINT(20),
	userId BIGINT(20),
	userName VARCHAR(75) null,
	createDate DATETIME null,
	modifiedDate DATETIME null,
	samlIdpSsoSessionKey VARCHAR(75) null
);

create table SamlSpAuthRequest (
	samlSpAuthnRequestId BIGINT(20) not null primary key,
	companyId BIGINT(20),
	groupId BIGINT(20),
	createDate DATETIME null,
	samlIdpEntityId VARCHAR(1024) null,
	samlSpAuthRequestKey VARCHAR(75) null
);

create table SamlSpIdpConnection (
	samlSpIdpConnectionId BIGINT(20) not null primary key,
	companyId BIGINT(20),
	groupId BIGINT(20),
	userId BIGINT(20),
	userName VARCHAR(75) null,
	createDate DATETIME null,
	modifiedDate DATETIME null,
	samlIdpEntityId VARCHAR(1024) null,
	assertionSignatureRequired BOOLEAN,
	clockSkew BIGINT(20),
	enabled BOOLEAN,
	ldapImportEnabled BOOLEAN,
	metadataUrl VARCHAR(1024) null,
	metadataXml LONGTEXT null,
	metadataUpdatedDate DATETIME null,
	name VARCHAR(75) null,
	nameIdFormat VARCHAR(1024) null,
	signAuthnRequest BOOLEAN,
	userAttributeMappings STRING null,
	keepAliveUrl VARCHAR(75) null,
	primaryKeyType VARCHAR(75) null,
	primaryKeyAttribute VARCHAR(75) null
);

create table SamlSpMessage (
	samlSpMessageId BIGINT(20) not null primary key,
	companyId BIGINT(20),
	groupId BIGINT(20),
	createDate DATETIME null,
	samlIdpEntityId VARCHAR(1024) null,
	samlIdpResponseKey VARCHAR(512) null,
	expirationDate DATETIME null
);

create table SamlSpSession (
	samlSpSessionId BIGINT(20) not null primary key,
	companyId BIGINT(20),
	groupId BIGINT(20),
	userId BIGINT(20),
	userName VARCHAR(75) null,
	createDate DATETIME null,
	modifiedDate DATETIME null,
	samlSpSessionKey VARCHAR(512) null,
	assertionXml LONGTEXT null,
	jSessionId VARCHAR(75) null,
	nameIdFormat VARCHAR(1024) null,
	nameIdValue VARCHAR(1024) null,
	sessionIndex VARCHAR(75) null,
	terminated_ BOOLEAN
);