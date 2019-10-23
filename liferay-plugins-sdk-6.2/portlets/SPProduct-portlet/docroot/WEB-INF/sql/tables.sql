create table SPActivity (
	spActivityId BIGINT(20) not null primary key,
	groupId BIGINT(20),
	companyId BIGINT(20),
	userId BIGINT(20),
	userName VARCHAR(75) null,
	createDate DATETIME null,
	modifiedDate DATETIME null,
	spModuleId BIGINT(20),
	spScheduleId BIGINT(20),
	description LONGTEXT null,
	activityTiming VARCHAR(400) null,
	activityPerformer VARCHAR(400) null,
	activityDuration VARCHAR(400) null
);

create table SPAssessment (
	spAssessmentId BIGINT(20) not null primary key,
	groupId BIGINT(20),
	companyId BIGINT(20),
	userId BIGINT(20),
	userName VARCHAR(75) null,
	createDate DATETIME null,
	modifiedDate DATETIME null,
	spModuleId BIGINT(20),
	assessmentDesc LONGTEXT null,
	assessmentType BIGINT(20),
	assessmentMethod BIGINT(20),
	assessmentMode BIGINT(20),
	locationType BIGINT(20),
	eligibility VARCHAR(75) null,
	gradingType BIGINT(20),
	maximumMarks VARCHAR(75) null,
	passingMarks VARCHAR(75) null
);

create table SPCertificate (
	spCertificatetId BIGINT(20) not null primary key,
	groupId BIGINT(20),
	companyId BIGINT(20),
	userId BIGINT(20),
	userName VARCHAR(75) null,
	createDate DATETIME null,
	modifiedDate DATETIME null,
	countryId BIGINT(20),
	certificateCode VARCHAR(75) null,
	certificateType BIGINT(20),
	title VARCHAR(500) null,
	description LONGTEXT null,
	level BIGINT(20),
	attachmentFolderId BIGINT(20)
);

create table SPCompetencyUnit (
	spCompetencyUnitId BIGINT(20) not null primary key,
	groupId BIGINT(20),
	companyId BIGINT(20),
	userId BIGINT(20),
	userName VARCHAR(75) null,
	createDate DATETIME null,
	modifiedDate DATETIME null,
	countryId BIGINT(20),
	spFrameworkId BIGINT(20),
	competencyUnitCode VARCHAR(75) null,
	competencyUnitDesc LONGTEXT null,
	jobFamily BIGINT(20),
	competencyLevel BIGINT(20),
	creditValue BIGINT(20)
);

create table SPCourse (
	spCourseId BIGINT(20) not null primary key,
	groupId BIGINT(20),
	companyId BIGINT(20),
	userId BIGINT(20),
	userName VARCHAR(75) null,
	createDate DATETIME null,
	modifiedDate DATETIME null,
	countryId VARCHAR(75) null,
	courseCode VARCHAR(75) null,
	courseName VARCHAR(500) null,
	displayCourseName BOOLEAN,
	courseDesc LONGTEXT null,
	courseDurationFullTime VARCHAR(75) null,
	learningDurationFullTime VARCHAR(75) null,
	courseDurationPartTime VARCHAR(75) null,
	learningDurationPartTime VARCHAR(75) null,
	complexityLevel VARCHAR(75) null,
	courseType BIGINT(20),
	frameworkApprovalStatus BOOLEAN,
	graduationCriteriaDesc LONGTEXT null,
	fundingDescPre LONGTEXT null,
	fundingDescPost LONGTEXT null,
	feeDetailsDesc LONGTEXT null,
	testLink VARCHAR(500) null,
	courseOutcomeTitle LONGTEXT null,
	courseOutcomeDesc LONGTEXT null,
	personaDesc LONGTEXT null,
	certificateTitle LONGTEXT null,
	awardingBodyId BIGINT(20),
	courseLevel BIGINT(20),
	miscFeeDesc LONGTEXT null,
	courseDeveloperId BIGINT(20)
);

create table SPCourseCareer (
	spCourseCareerId BIGINT(20) not null primary key,
	groupId BIGINT(20),
	companyId BIGINT(20),
	userId BIGINT(20),
	userName VARCHAR(75) null,
	createDate DATETIME null,
	modifiedDate DATETIME null,
	spCourseId BIGINT(20),
	intro LONGTEXT null
);

create table SPCourseCertificate (
	spCourseCertificateId BIGINT(20) not null primary key,
	groupId BIGINT(20),
	companyId BIGINT(20),
	userId BIGINT(20),
	userName VARCHAR(75) null,
	createDate DATETIME null,
	modifiedDate DATETIME null,
	spCourseId BIGINT(20),
	spCertificatetId BIGINT(20)
);

create table SPCourseDuration (
	spCourseDurationId BIGINT(20) not null primary key,
	groupId BIGINT(20),
	companyId BIGINT(20),
	userId BIGINT(20),
	userName VARCHAR(75) null,
	createDate DATETIME null,
	modifiedDate DATETIME null,
	spCourseId BIGINT(20),
	spCourseLearningId BIGINT(20),
	title VARCHAR(500) null
);

create table SPCourseDurationType (
	spCourseDurationTypeId BIGINT(20) not null primary key,
	groupId BIGINT(20),
	companyId BIGINT(20),
	userId BIGINT(20),
	userName VARCHAR(75) null,
	createDate DATETIME null,
	modifiedDate DATETIME null,
	spCourseDurationId BIGINT(20),
	spCourseId BIGINT(20),
	title1 VARCHAR(500) null,
	duration1 VARCHAR(75) null,
	title2 VARCHAR(500) null,
	duration2 VARCHAR(75) null
);

create table SPCourseEnrollContract (
	spCourseContractId BIGINT(20) not null primary key,
	groupId BIGINT(20),
	companyId BIGINT(20),
	userId BIGINT(20),
	userName VARCHAR(75) null,
	createDate DATETIME null,
	modifiedDate DATETIME null,
	countryId VARCHAR(75) null,
	courseType BIGINT(20),
	docType VARCHAR(75) null,
	seqNo INTEGER,
	contractTemplateFileEntryId BIGINT(20),
	dataTemplateFileEntryId BIGINT(20),
	extraInfo LONGTEXT null
);

create table SPCourseEnrollEsignInfo (
	spEsignInfoId BIGINT(20) not null primary key,
	groupId BIGINT(20),
	companyId BIGINT(20),
	userId BIGINT(20),
	userName VARCHAR(75) null,
	createDate DATETIME null,
	modifiedDate DATETIME null,
	signerId VARCHAR(75) null,
	packageId VARCHAR(75) null,
	documentId VARCHAR(75) null,
	lastGeneratedUrl LONGTEXT null,
	spPEProcessStateId BIGINT(20),
	extraInfo LONGTEXT null
);

create table SPCourseLearning (
	spCourseLearningId BIGINT(20) not null primary key,
	groupId BIGINT(20),
	companyId BIGINT(20),
	userId BIGINT(20),
	userName VARCHAR(75) null,
	createDate DATETIME null,
	modifiedDate DATETIME null,
	spCourseId BIGINT(20),
	intro LONGTEXT null,
	optionTitle VARCHAR(500) null,
	option1 LONGTEXT null,
	option2 LONGTEXT null,
	note LONGTEXT null
);

create table SPCourseModule (
	spCourseModuleId BIGINT(20) not null primary key,
	groupId BIGINT(20),
	companyId BIGINT(20),
	userId BIGINT(20),
	userName VARCHAR(75) null,
	createDate DATETIME null,
	modifiedDate DATETIME null,
	spCourseId BIGINT(20),
	spModuleId BIGINT(20)
);

create table SPCourseOutcome (
	spCourseOutcomeId BIGINT(20) not null primary key,
	groupId BIGINT(20),
	companyId BIGINT(20),
	userId BIGINT(20),
	userName VARCHAR(75) null,
	createDate DATETIME null,
	modifiedDate DATETIME null,
	spCourseId BIGINT(20),
	outcomeId BIGINT(20),
	outcomeDesc LONGTEXT null
);

create table SPCourseStudyOption (
	spStudyOptionId BIGINT(20) not null primary key,
	groupId BIGINT(20),
	companyId BIGINT(20),
	userId BIGINT(20),
	userName VARCHAR(75) null,
	createDate DATETIME null,
	modifiedDate DATETIME null,
	spCourseId BIGINT(20),
	title VARCHAR(500) null,
	desc_ LONGTEXT null,
	coverImageFileEntryId BIGINT(20)
);

create table SPFeeDetails (
	spFeeDetailsId BIGINT(20) not null primary key,
	groupId BIGINT(20),
	companyId BIGINT(20),
	userId BIGINT(20),
	userName VARCHAR(75) null,
	createDate DATETIME null,
	modifiedDate DATETIME null,
	feeType BIGINT(20),
	feeDesc LONGTEXT null,
	calculationBase VARCHAR(75) null,
	amount VARCHAR(75) null,
	displayOrder BIGINT(20),
	fundId BIGINT(20),
	spCourseId BIGINT(20)
);

create table SPFeeType (
	spFeeTypeId BIGINT(20) not null primary key,
	groupId BIGINT(20),
	companyId BIGINT(20),
	userId BIGINT(20),
	userName VARCHAR(75) null,
	createDate DATETIME null,
	modifiedDate DATETIME null,
	feeType VARCHAR(75) null,
	feeTypeName VARCHAR(75) null,
	feeTypeDesc VARCHAR(75) null,
	misc BOOLEAN
);

create table SPFramework (
	spFrameworkId BIGINT(20) not null primary key,
	groupId BIGINT(20),
	companyId BIGINT(20),
	userId BIGINT(20),
	userName VARCHAR(75) null,
	createDate DATETIME null,
	modifiedDate DATETIME null,
	countryId BIGINT(20),
	frameworkCode VARCHAR(75) null,
	frameworkName LONGTEXT null,
	frameworkImageId BIGINT(20)
);

create table SPFunding (
	spFundingId BIGINT(20) not null primary key,
	groupId BIGINT(20),
	companyId BIGINT(20),
	userId BIGINT(20),
	userName VARCHAR(75) null,
	createDate DATETIME null,
	modifiedDate DATETIME null,
	courseType BIGINT(20),
	fundingDesc LONGTEXT null,
	fundingCriteria LONGTEXT null,
	fundOrder BIGINT(20),
	sponsoredBy BIGINT(20),
	residenceStatus VARCHAR(75) null,
	ageOperator VARCHAR(75) null,
	age DOUBLE,
	earningStatus VARCHAR(75) null,
	salaryOperator VARCHAR(75) null,
	salary DOUBLE,
	fundingHour VARCHAR(75) null,
	fundingAmount DOUBLE,
	netFees DOUBLE,
	absenteePayroll LONGTEXT null,
	fundingCourseFee LONGTEXT null,
	spCourseId BIGINT(20)
);

create table SPGraduationCriteria (
	spGraduationCriteriaId BIGINT(20) not null primary key,
	groupId BIGINT(20),
	companyId BIGINT(20),
	userId BIGINT(20),
	userName VARCHAR(75) null,
	createDate DATETIME null,
	modifiedDate DATETIME null,
	criteriaType BIGINT(20),
	criteriaLevel BIGINT(20),
	criteriaValueRange VARCHAR(75) null,
	criteriaDesc LONGTEXT null,
	spCourseId BIGINT(20)
);

create table SPMiscellaneousFees (
	spMiscFeesId BIGINT(20) not null primary key,
	groupId BIGINT(20),
	companyId BIGINT(20),
	userId BIGINT(20),
	userName VARCHAR(75) null,
	createDate DATETIME null,
	modifiedDate DATETIME null,
	miscFeeType BIGINT(20),
	amount DOUBLE,
	payable BIGINT(20),
	spCourseId BIGINT(20)
);

create table SPModule (
	spModuleId BIGINT(20) not null primary key,
	groupId BIGINT(20),
	companyId BIGINT(20),
	userId BIGINT(20),
	userName VARCHAR(75) null,
	createDate DATETIME null,
	modifiedDate DATETIME null,
	countryId BIGINT(20),
	moduleCode VARCHAR(75) null,
	moduleName VARCHAR(250) null,
	moduleDesc LONGTEXT null,
	moduleType BIGINT(20),
	creditValue BIGINT(20),
	moduleDuration VARCHAR(75) null,
	noOfSessions BIGINT(20),
	generalDesc LONGTEXT null
);

create table SPModuleCertificate (
	spModuleCertificateId BIGINT(20) not null primary key,
	groupId BIGINT(20),
	companyId BIGINT(20),
	userId BIGINT(20),
	userName VARCHAR(75) null,
	createDate DATETIME null,
	modifiedDate DATETIME null,
	spModuleId BIGINT(20),
	spCertificatetId BIGINT(20)
);

create table SPModuleCompetencyUnit (
	spModuleCompetencyUnitId BIGINT(20) not null primary key,
	groupId BIGINT(20),
	companyId BIGINT(20),
	userId BIGINT(20),
	userName VARCHAR(75) null,
	createDate DATETIME null,
	modifiedDate DATETIME null,
	spModuleId BIGINT(20),
	spCompetencyUnitId BIGINT(20)
);

create table SPModuleFramework (
	spModuleFrameworkId BIGINT(20) not null primary key,
	groupId BIGINT(20),
	companyId BIGINT(20),
	userId BIGINT(20),
	userName VARCHAR(75) null,
	createDate DATETIME null,
	modifiedDate DATETIME null,
	spModuleId BIGINT(20),
	spFrameworkId BIGINT(20)
);

create table SPOutcome (
	spOutcomeId BIGINT(20) not null primary key,
	groupId BIGINT(20),
	companyId BIGINT(20),
	userId BIGINT(20),
	userName VARCHAR(75) null,
	createDate DATETIME null,
	modifiedDate DATETIME null,
	countryId BIGINT(20),
	outcomeCode VARCHAR(75) null,
	outcomeDesc LONGTEXT null,
	outcomeType BIGINT(20),
	outcomeFolderId BIGINT(20),
	spCompetencyUnitId BIGINT(20)
);

create table SPOutline (
	spOutlineId BIGINT(20) not null primary key,
	groupId BIGINT(20),
	companyId BIGINT(20),
	userId BIGINT(20),
	userName VARCHAR(75) null,
	createDate DATETIME null,
	modifiedDate DATETIME null,
	spCompetencyUnitId BIGINT(20),
	outlineType BIGINT(20),
	outlineDesc LONGTEXT null
);

create table SPPersona (
	spPersonaId BIGINT(20) not null primary key,
	groupId BIGINT(20),
	companyId BIGINT(20),
	userId BIGINT(20),
	userName VARCHAR(75) null,
	createDate DATETIME null,
	modifiedDate DATETIME null,
	personaType BIGINT(20),
	ageGroup VARCHAR(75) null,
	personaDesc LONGTEXT null,
	personaImageId BIGINT(20),
	spCourseId BIGINT(20)
);

create table SPPersonaAttendee (
	spPersonaAttendeeId BIGINT(20) not null primary key,
	groupId BIGINT(20),
	companyId BIGINT(20),
	userId BIGINT(20),
	userName VARCHAR(75) null,
	createDate DATETIME null,
	modifiedDate DATETIME null,
	description LONGTEXT null,
	imageId BIGINT(20),
	spPersonaId BIGINT(20),
	spCourseId BIGINT(20)
);

create table SPProduct (
	spProductId BIGINT(20) not null primary key,
	groupId BIGINT(20),
	companyId BIGINT(20),
	userId BIGINT(20),
	userName VARCHAR(75) null,
	createDate DATETIME null,
	modifiedDate DATETIME null,
	countryId VARCHAR(75) null,
	productCode VARCHAR(75) null,
	productName VARCHAR(500) null,
	productDesc LONGTEXT null,
	productImageId BIGINT(20),
	spCourseId BIGINT(20),
	productBrochuresFolderId BIGINT(20),
	productVideoFolderId BIGINT(20),
	status INTEGER,
	creditValues BIGINT(20),
	PEProcessId BIGINT(20),
	productTemplateName VARCHAR(75) null,
	productTemplateLanguage VARCHAR(75) null,
	registrationEnabled VARCHAR(75) null,
	samePageRegistration VARCHAR(75) null,
	productFormImageId BIGINT(20),
	productFormName VARCHAR(75) null,
	productFormButtonName VARCHAR(75) null,
	productFormUrl VARCHAR(75) null,
	productBannerImageId BIGINT(20),
	hasInventory BOOLEAN,
	bannerDetailsEnabled VARCHAR(75) null
);

create table SPProductCourse (
	spProductCourseId BIGINT(20) not null primary key,
	groupId BIGINT(20),
	companyId BIGINT(20),
	userId BIGINT(20),
	userName VARCHAR(75) null,
	createDate DATETIME null,
	modifiedDate DATETIME null,
	spProductId BIGINT(20),
	spCourseId BIGINT(20)
);

create table SPProductSupervisor (
	spProductSupervisorId BIGINT(20) not null primary key,
	groupId BIGINT(20),
	companyId BIGINT(20),
	userId BIGINT(20),
	userName VARCHAR(75) null,
	createDate DATETIME null,
	modifiedDate DATETIME null,
	countryName VARCHAR(75) null,
	countryId BIGINT(20),
	productId BIGINT(20),
	supervisorId BIGINT(20)
);

create table SPProgressionPath (
	spProgressionPathId BIGINT(20) not null primary key,
	groupId BIGINT(20),
	companyId BIGINT(20),
	userId BIGINT(20),
	userName VARCHAR(75) null,
	createDate DATETIME null,
	modifiedDate DATETIME null,
	careerLevel BIGINT(20),
	level INTEGER,
	progressionType BIGINT(20),
	progressionCategory BIGINT(20),
	startMonth VARCHAR(75) null,
	endMonth VARCHAR(75) null,
	duration VARCHAR(75) null,
	optionalMandatory VARCHAR(75) null,
	spCourseId BIGINT(20)
);

create table SPSchedule (
	spScheduleId BIGINT(20) not null primary key,
	groupId BIGINT(20),
	companyId BIGINT(20),
	userId BIGINT(20),
	userName VARCHAR(75) null,
	createDate DATETIME null,
	modifiedDate DATETIME null,
	spModuleId BIGINT(20),
	sessionNumber VARCHAR(75) null,
	description LONGTEXT null,
	sessionType BIGINT(20),
	sessionDuration VARCHAR(75) null
);

create table SPStudentCourseFee (
	spStudentCourseFeeId BIGINT(20) not null primary key,
	groupId BIGINT(20),
	companyId BIGINT(20),
	userId BIGINT(20),
	userName VARCHAR(75) null,
	createDate DATETIME null,
	modifiedDate DATETIME null,
	spPEProcessStateId BIGINT(20),
	feeType VARCHAR(75) null,
	amount VARCHAR(75) null,
	order_ INTEGER,
	formula VARCHAR(75) null,
	label VARCHAR(75) null
);

create table SPStudentCourseFeeInstmnt (
	spStudentCourseFeeInstmntId BIGINT(20) not null primary key,
	groupId BIGINT(20),
	companyId BIGINT(20),
	userId BIGINT(20),
	userName VARCHAR(75) null,
	createDate DATETIME null,
	modifiedDate DATETIME null,
	spPEProcessStateId BIGINT(20),
	insmntNo INTEGER,
	amount VARCHAR(75) null,
	date_ DATETIME null
);