create index IX_FBBB8B98 on SPActivity (groupId);
create index IX_57212B30 on SPActivity (groupId, spModuleId);
create index IX_1F04A01B on SPActivity (groupId, spScheduleId);

create index IX_A1B4FD45 on SPAssessment (groupId);
create index IX_D404815D on SPAssessment (groupId, spModuleId);

create index IX_EAA14014 on SPCertificate (certificateCode);
create index IX_36BA5349 on SPCertificate (countryId, groupId);
create index IX_91F6DC6A on SPCertificate (groupId);
create index IX_27303AE2 on SPCertificate (title, groupId);

create index IX_ADFC0E86 on SPCompetencyUnit (competencyUnitCode);
create index IX_7304540D on SPCompetencyUnit (countryId, groupId);
create index IX_DFD0331F on SPCompetencyUnit (countryId, groupId, spFrameworkId);
create index IX_7365AE26 on SPCompetencyUnit (groupId);

create index IX_FDC6B163 on SPCourse (countryId);
create index IX_9A81B2BA on SPCourse (courseCode);
create index IX_4A2C7BCC on SPCourse (groupId);

create index IX_769DE083 on SPCourseCareer (spCourseId);

create index IX_DFDDD0A5 on SPCourseCertificate (groupId);
create index IX_AA57C2DC on SPCourseCertificate (spCertificatetId, groupId);
create index IX_BB73323E on SPCourseCertificate (spCourseId, groupId);

create index IX_79956A19 on SPCourseDuration (spCourseId);

create index IX_BEAF3A7 on SPCourseDurationType (spCourseDurationId);
create index IX_6C83E1F3 on SPCourseDurationType (spCourseId);

create index IX_5785D114 on SPCourseEnrollContract (countryId, courseType);
create index IX_54BCA4AE on SPCourseEnrollContract (countryId, courseType, docType);

create index IX_D3E09542 on SPCourseEnrollEsignInfo (documentId);
create index IX_DCBA87B9 on SPCourseEnrollEsignInfo (packageId);
create index IX_2ED0CA51 on SPCourseEnrollEsignInfo (signerId);
create index IX_B6C3E73B on SPCourseEnrollEsignInfo (spPEProcessStateId);

create index IX_38C81623 on SPCourseLearning (spCourseId);

create index IX_B19B5BC0 on SPCourseModule (groupId);
create index IX_2609ECD9 on SPCourseModule (spCourseId, groupId);
create index IX_31FB228 on SPCourseModule (spModuleId, groupId);

create index IX_C3E9F40A on SPCourseOutcome (groupId);
create index IX_F1146623 on SPCourseOutcome (spCourseId, groupId);

create index IX_5A3E59B3 on SPCourseStudyOption (spCourseId);

create index IX_C35E7E98 on SPFeeDetails (feeType, spCourseId);
create index IX_48E5C6D3 on SPFeeDetails (fundId);
create index IX_8DD5499D on SPFeeDetails (fundId, feeType);
create index IX_2852301A on SPFeeDetails (fundId, spCourseId);
create index IX_8476C3EB on SPFeeDetails (groupId);
create index IX_8E284936 on SPFeeDetails (spCourseId, fundId, feeType);
create index IX_D30B6C84 on SPFeeDetails (spCourseId, groupId);

create index IX_2386FCD2 on SPFeeType (feeTypeName);
create index IX_B27A00E9 on SPFeeType (misc);

create index IX_676A9930 on SPFramework (countryId, groupId);
create index IX_554B0474 on SPFramework (frameworkCode);
create index IX_CD8DF758 on SPFramework (frameworkName, groupId);
create index IX_DCD740E3 on SPFramework (groupId);

create index IX_AB0485C4 on SPFunding (groupId);
create index IX_DCCE2E6D on SPFunding (spCourseId);
create index IX_831030DD on SPFunding (spCourseId, groupId);
create index IX_11F6EE53 on SPFunding (spCourseId, sponsoredBy);

create index IX_AE7D1F3A on SPGraduationCriteria (groupId);
create index IX_51D04953 on SPGraduationCriteria (spCourseId, groupId);

create index IX_DA457F1F on SPMiscellaneousFees (spCourseId, groupId);
create index IX_32AA7079 on SPMiscellaneousFees (spCourseId, miscFeeType);

create index IX_F45E6638 on SPModule (countryId, groupId);
create index IX_669E7CE5 on SPModule (countryId, groupId, moduleCode);
create index IX_994148DB on SPModule (groupId);
create index IX_59D99CDC on SPModule (moduleCode);

create index IX_D11F9436 on SPModuleCertificate (groupId);
create index IX_7350242D on SPModuleCertificate (spCertificatetId, groupId);
create index IX_9674E99E on SPModuleCertificate (spModuleId, groupId);

create index IX_56CA52DA on SPModuleCompetencyUnit (groupId);
create index IX_3AB002CD on SPModuleCompetencyUnit (spCompetencyUnitId, groupId);
create index IX_F7E2D242 on SPModuleCompetencyUnit (spModuleId, groupId);

create index IX_3E237BAF on SPModuleFramework (groupId);
create index IX_E5F385B9 on SPModuleFramework (spFrameworkId, groupId);
create index IX_8DC46397 on SPModuleFramework (spModuleId, groupId);

create index IX_30C65444 on SPOutcome (countryId, groupId);
create index IX_5BEF94F1 on SPOutcome (countryId, groupId, spCompetencyUnitId);
create index IX_D101AA4F on SPOutcome (groupId);
create index IX_7DB6777C on SPOutcome (groupId, spCompetencyUnitId);

create index IX_9D08B35F on SPOutline (groupId);
create index IX_4DE7E2CD on SPOutline (groupId, outlineType);
create index IX_2A6E588C on SPOutline (groupId, spCompetencyUnitId);

create index IX_354505B5 on SPPersona (groupId);
create index IX_36E34F4E on SPPersona (spCourseId, groupId);

create index IX_64F079B on SPPersonaAttendee (groupId);
create index IX_95ABA834 on SPPersonaAttendee (spCourseId, groupId);
create index IX_13DC14DF on SPPersonaAttendee (spPersonaId, groupId);

create index IX_1F554CA9 on SPProduct (countryId);
create index IX_3153092 on SPProduct (groupId);
create index IX_3E20AEF on SPProduct (groupId, countryId);
create index IX_C56DF359 on SPProduct (groupId, spCourseId);
create index IX_A76331CF on SPProduct (productName, countryId);
create index IX_A13DD965 on SPProduct (spProductId);
create index IX_6A5365FE on SPProduct (status);

create index IX_992A16F7 on SPProductCourse (groupId);
create index IX_1C7E8D90 on SPProductCourse (spCourseId, groupId);
create index IX_1D6C2A0 on SPProductCourse (spProductId, groupId);

create index IX_B1410E61 on SPProgressionPath (groupId);
create index IX_F11BB5FA on SPProgressionPath (spCourseId, groupId);

create index IX_5A776710 on SPSchedule (groupId);
create index IX_595792A8 on SPSchedule (groupId, spModuleId);

create index IX_39B39176 on SPStudentCourseFee (spPEProcessStateId);
create index IX_B1ADC65A on SPStudentCourseFee (spPEProcessStateId, feeType);

create index IX_46F4DB89 on SPStudentCourseFeeInstmnt (spPEProcessStateId);
create index IX_B62B2AA3 on SPStudentCourseFeeInstmnt (spPEProcessStateId, insmntNo);