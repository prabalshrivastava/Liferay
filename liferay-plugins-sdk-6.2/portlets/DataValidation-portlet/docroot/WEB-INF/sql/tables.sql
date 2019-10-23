create table SPStudentProgramme (
	spStudentCourseId BIGINT(20) not null primary key,
	companyId BIGINT(20),
	userId BIGINT(20),
	userName VARCHAR(75) null,
	createDate DATETIME null,
	modifiedDate DATETIME null,
	nric VARCHAR(75) null,
	emailAddress VARCHAR(75) null,
	programme VARCHAR(75) null,
	courseCentre VARCHAR(75) null,
	courseStartDate DATETIME null,
	courseEndDate DATETIME null
);

create table SPStudentProgrammeResult (
	spStudentProgrammeResultId BIGINT(20) not null primary key,
	companyId BIGINT(20),
	userId BIGINT(20),
	userName VARCHAR(75) null,
	createDate DATETIME null,
	modifiedDate DATETIME null,
	nric VARCHAR(75) null,
	emailAddress VARCHAR(75) null,
	courseCentre VARCHAR(75) null,
	courseStartDate DATETIME null,
	courseEndDate DATETIME null,
	programme VARCHAR(75) null,
	exam DATETIME null,
	examType VARCHAR(75) null,
	paper1Result VARCHAR(75) null,
	paper2Result VARCHAR(75) null,
	overallResult VARCHAR(75) null
);