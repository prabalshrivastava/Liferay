<%@page import="com.sambaash.platform.rpec.service.SPRPECLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>
<%@page import="org.apache.commons.lang.StringUtils"%>
<%@page import="com.liferay.portal.kernel.json.JSONArray"%>
<%@page import="com.sambaash.platform.systemmodelsetup.service.SystemServiceUtil"%>
<%@page import="com.sambaash.platform.util.SambaashUtil"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.sambaash.platform.util.LabelUtil"%>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@page import="com.sambaash.platform.constant.SystemSetupConstants"%>
<%@page import="javax.portlet.PortletPreferences"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="javax.portlet.PortletRequest"%>
<%@page import="com.sambaash.platform.util.PermissionUtil"%>
<%@page import="com.liferay.portal.security.auth.AuthTokenUtil"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.sambaash.platform.systemmodelsetup.service.SystemServiceUtil"%>
<%@page import="com.sambaash.platform.systemmodelsetup.service.SystemLocalServiceUtil"%>
<%@page import="org.json.JSONObject"%>
<%@page import="org.json.JSONException"%>
<%@page import="java.lang.ClassCastException"%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%><%@
taglib
	uri="http://liferay.com/tld/security" prefix="liferay-security"%><%@
taglib
	uri="http://liferay.com/tld/theme" prefix="liferay-theme"%><%@
taglib
	uri="http://liferay.com/tld/ui" prefix="liferay-ui"%><%@
taglib
	uri="http://liferay.com/tld/util" prefix="liferay-util"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link rel='stylesheet'
	href='/html/css/sp/formio.full.min.css?minifierType=css'>
<link rel='stylesheet' href='/html/css/hook.css?minifierType=css'>
<link rel='stylesheet' type="text/css"
	href='<%=request.getContextPath()%>/css/formio.full.min.css?minifierType=css'>
<!-- <link rel='stylesheet' type="text/css" -->
<%-- 	href='<%=request.getContextPath()%>/css/portlet.css?minifierType=css'></link> --%>
<!-- <link rel='stylesheet' type="text/css" -->
<%-- 	href='<%=request.getContextPath()%>/css/main.css?minifierType=css'></link> --%>
<link rel='stylesheet' type="text/css"
	href='<%=request.getContextPath()%>/css/erpec-candidates/portlet.css?minifierType=css'></link>
<link rel='stylesheet' type="text/css"
	href='<%=request.getContextPath()%>/css/erpec-candidates/main.css?minifierType=css'></link>
<script type="text/javascript"
	src="/html/js/sp/hook.js?<%=System.currentTimeMillis()%>"
	language="javascript1.2""></script>
<liferay-theme:defineObjects />

<%@
taglib uri="/tld/sp-formio" prefix="sp-formio"%>
<portlet:defineObjects />
<%
	if(PermissionUtil.canViewListing( (PortletRequest) request.getAttribute("javax.portlet.request"))){ 
	    String csvCandidates = "";
		String userType=(String)  request.getAttribute("userType");
		String modelName = renderRequest.getPreferences().getValue("modelNamePref", "");
		String baseUrl = portletPreferences.getValue("baseUrlPref", "");
		String userId = String.valueOf(PortalUtil.getUserId(request));
		ThemeDisplay td = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String userName = td.getRealUser().getFullName();
		Long groupId = td.getLayout().getGroupId();
		String userDetails = "";
		String candidatesList = "";
		boolean showAddRPEC = false;
		if(userType.equals("Candidate"))
		{
			userDetails = SystemServiceUtil.getRecord(userId, "Candidate", Long.parseLong(userId), groupId);
			//userDetails = "{\"createdDate\":\"2019-06-22 13:27:05.000\",\"modelId\":152,\"lastModifiedDate\":\"2019-06-26 11:08:32.000\",\"createdBy\":\"321169\",\"lastModifiedBy\":\"321169\",\"contentJson\":{\"SalutationLOV\":{\"displayName\":\"Mr\",\"groupId\":0,\"itemValue\":\"Mr\",\"displayOrder\":4,\"userName\":\"Admin RELC\",\"userId\":20199,\"uuid\":\"86e15904-5a77-11e9-a59b-027cdf543d18\",\"itemKey\":\"basic.info.salutation\",\"companyId\":20155,\"modifiedDate\":1554751702000,\"spListTypeId\":14,\"modeldata\":\"\",\"categoryId\":0,\"createDate\":1554751702000},\"CRNNumber\":\"SAC/201906/254\",\"modelname\":\"candidate\",\"MentorId\":\"{\\\"lastName\\\":\\\"jc84mentor-last\\\",\\\"columnBitmask\\\":0,\\\"originalUuid\\\":\\\"b74d4218-8e75-4346-aefa-01f96f78d02a\\\",\\\"cachedModel\\\":false,\\\"uuid\\\":\\\"b74d4218-8e75-4346-aefa-01f96f78d02a\\\",\\\"modelClassName\\\":\\\"com.sambaash.platform.srv.startupprofile.model.ApprovedMentors\\\",\\\"organizationId\\\":6201,\\\"originalUserId\\\":\\\"321504\\\",\\\"email\\\":\\\"\\\",\\\"createDate\\\":null,\\\"expandoBridge\\\":{\\\"attributeColumns\\\":[],\\\"classPK\\\":5601,\\\"companyId\\\":20155,\\\"attributeNames\\\":{},\\\"indexEnabled\\\":true,\\\"attributes\\\":{},\\\"className\\\":\\\"com.sambaash.platform.srv.startupprofile.model.ApprovedMentors\\\",\\\"table\\\":{\\\"companyId\\\":20155,\\\"name\\\":\\\"CUSTOM_FIELDS\\\",\\\"tableId\\\":263116,\\\"classNameId\\\":238102}},\\\"new\\\":false,\\\"modelClass\\\":\\\"com.sambaash.platform.srv.startupprofile.model.ApprovedMentors\\\",\\\"originalOrganizationId\\\":6201,\\\"userId\\\":\\\"321504\\\",\\\"approvedDate\\\":1561179636000,\\\"escapedModel\\\":false,\\\"firstName\\\":\\\"jc84mentor-first\\\",\\\"originalStatus\\\":1,\\\"primaryKeyObj\\\":5601,\\\"modelAttributes\\\":{\\\"organizationId\\\":6201,\\\"approvedDate\\\":1561179636000,\\\"uuid\\\":\\\"b74d4218-8e75-4346-aefa-01f96f78d02a\\\",\\\"mentorId\\\":5601,\\\"userId\\\":\\\"321504\\\",\\\"remarks\\\":\\\"\\\",\\\"createDate\\\":null,\\\"status\\\":1},\\\"mentorId\\\":5601,\\\"remarks\\\":\\\"\\\",\\\"primaryKey\\\":5601,\\\"status\\\":1}\",\"Gender\":\"Male\",\"scheduleModelId\":\"0\",\"CurrentEmploymentOrganizationName\":\"corp81\",\"CurrentEmploymentStartingDate\":\"2014-06-14T21:30:00+05:30\",\"SponsorshipType\":\"Self Sponsored\",\"enableTempStorageValidation\":\"false\",\"Status\":\"Active\",\"DateOfBirth\":\"1980-06-14T21:30:00+05:30\",\"IDNumber2\":\"\",\"GraduatationExceed\":\"\",\"declaration1\":\"\",\"formType\":\"candidate\",\"data-cart-id\":\"PE-71602-205407\",\"CurrentlyPursuing\":[],\"ProductSubType\":\"2005\",\"ProductType\":\"1005\",\"declaration5\":\"noIAmNotAMember\",\"declaration4\":\"yes\",\"declaration3\":\"\",\"declaration2\":\"\",\"_lastPricingNodeSubmitted_\":\"67\",\"HouseBlockNo\":\"504\",\"Country\":\"Singapore\",\"PastEmployments\":[],\"status\":\"active\",\"ClientType\":\"309\",\"CurrentEmploymentDesignation\":\"\",\"BuildingName\":\"ELIAS PARKS ESTATE\",\"sponsorName\":\"\",\"CategoryType\":\"2008\",\"Salutation\":\"Mr\",\"CurrentEmploymentOtherOrganizationName\":\"\",\"TrainingAgreement\":\"[{\\\"originalName\\\":\\\"2.png\\\",\\\"size\\\":350139,\\\"data\\\":{\\\"size\\\":350139,\\\"name\\\":\\\"2.png\\\",\\\"url\\\":\\\"https://sac.sambaash.com/documents/237101/321601/2.png?version=1.0\\\",\\\"fileEntryId\\\":321701},\\\"name\\\":\\\"2-3ea0bb3f-d6ea-4e35-b6bc-0b5caf193493.png\\\",\\\"storage\\\":\\\"url\\\",\\\"type\\\":\\\"image/png\\\",\\\"url\\\":\\\"https://sac.sambaash.com/documents/237101/321601/2.png?version=1.0\\\"}]\",\"AwardsGrid\":[],\"IDType2\":\"\",\"GraduateCurrentlyPursuing\":\"[]\",\"CurrentEmploymentIndustrySector\":\"\",\"atoId\":\"\",\"_lastPricingInvoiceExtRef_\":\"SAC/INV/20190622/834\",\"IDNumber\":\"ABCD12345\",\"ContactNumberSingapore\":96515728,\"FirstName\":\"Ram Chelvan\",\"CountryofStay\":\"Singapore\",\"CurrentEmploymentJobCategory\":\"\",\"TrainingPrincipal\":\"{\\\"lastName\\\":\\\"\\\",\\\"secondaryPrincipalUserFirstName\\\":\\\"jc83sc-first\\\",\\\"columnBitmask\\\":0,\\\"cachedModel\\\":true,\\\"secondaryPrincipalUserEmail\\\":\\\"josechristian.lee.elico+83@sambaash.com\\\",\\\"groupId\\\":0,\\\"modelClassName\\\":\\\"com.sambaash.platform.srv.startupprofile.model.SPATOContacts\\\",\\\"organizationId\\\":6201,\\\"primaryPrincipalUserFirstName\\\":\\\"jc82tp-first\\\",\\\"secondaryPrincipalUserLastName\\\":\\\"jc83sc-last\\\",\\\"createDate\\\":null,\\\"expandoBridge\\\":{\\\"attributeColumns\\\":[],\\\"classPK\\\":4601,\\\"companyId\\\":20155,\\\"attributeNames\\\":{},\\\"indexEnabled\\\":true,\\\"attributes\\\":{},\\\"className\\\":\\\"com.sambaash.platform.srv.startupprofile.model.SPATOContacts\\\",\\\"table\\\":{\\\"companyId\\\":20155,\\\"name\\\":\\\"CUSTOM_FIELDS\\\",\\\"tableId\\\":263113,\\\"classNameId\\\":238105}},\\\"new\\\":false,\\\"modelClass\\\":\\\"com.sambaash.platform.srv.startupprofile.model.SPATOContacts\\\",\\\"originalSecondaryPrincipalUserId\\\":\\\"321497\\\",\\\"primaryPrincipalUserId\\\":\\\"321490\\\",\\\"spATOContactId\\\":4601,\\\"originalOrganizationId\\\":6201,\\\"userId\\\":0,\\\"secondaryPrincipalUserId\\\":\\\"321497\\\",\\\"escapedModel\\\":false,\\\"firstName\\\":\\\"\\\",\\\"originalPrimaryPrincipalUserId\\\":\\\"321490\\\",\\\"primaryKeyObj\\\":4601,\\\"primaryPrincipalUserLastName\\\":\\\"jc82tp-last\\\",\\\"modelAttributes\\\":{\\\"organizationId\\\":6201,\\\"firstName\\\":\\\"\\\",\\\"lastName\\\":\\\"\\\",\\\"primaryPrincipalUserId\\\":\\\"321490\\\",\\\"groupId\\\":0,\\\"spATOContactId\\\":4601,\\\"modifiedDate\\\":null,\\\"userId\\\":0,\\\"createDate\\\":null,\\\"secondaryPrincipalUserId\\\":\\\"321497\\\"},\\\"modifiedDate\\\":null,\\\"primaryPrincipalUserEmail\\\":\\\"josechristian.lee.elico+82@sambaash.com\\\",\\\"userUuid\\\":\\\"\\\",\\\"primaryKey\\\":4601}\",\"PrimaryEmailAddress\":\"mangalram.prasanna+64@sambaash.com\",\"userIdProcessRoles\":\"244412\",\"AtoDetails\":{\"CandidateJobTitle\":\"Financial Accountant\",\"TrainingAgreement\":[{\"originalName\":\"2.png\",\"size\":350139,\"data\":{\"size\":350139,\"name\":\"2.png\",\"url\":\"https://sac.sambaash.com/documents/237101/321601/2.png?version=1.0\",\"fileEntryId\":321701},\"name\":\"2-3ea0bb3f-d6ea-4e35-b6bc-0b5caf193493.png\",\"storage\":\"url\",\"type\":\"image/png\",\"url\":\"https://sac.sambaash.com/documents/237101/321601/2.png?version=1.0\"}],\"RoleDateTo\":\"\",\"RoleDateFrom\":\"2014-04-14T21:30:00+05:30\",\"FirstName\":\"jc84mentor-first\",\"Existingmembercontact\":\"yes\",\"ApprovedMentors\":{\"lastName\":\"jc84mentor-last\",\"columnBitmask\":0,\"originalUuid\":\"b74d4218-8e75-4346-aefa-01f96f78d02a\",\"cachedModel\":false,\"uuid\":\"b74d4218-8e75-4346-aefa-01f96f78d02a\",\"modelClassName\":\"com.sambaash.platform.srv.startupprofile.model.ApprovedMentors\",\"organizationId\":6201,\"originalUserId\":\"321504\",\"email\":\"\",\"createDate\":null,\"expandoBridge\":{\"attributeColumns\":[],\"classPK\":5601,\"companyId\":20155,\"attributeNames\":{},\"indexEnabled\":true,\"attributes\":{},\"className\":\"com.sambaash.platform.srv.startupprofile.model.ApprovedMentors\",\"table\":{\"companyId\":20155,\"name\":\"CUSTOM_FIELDS\",\"tableId\":263116,\"classNameId\":238102}},\"new\":false,\"modelClass\":\"com.sambaash.platform.srv.startupprofile.model.ApprovedMentors\",\"originalOrganizationId\":6201,\"userId\":\"321504\",\"approvedDate\":1561179636000,\"escapedModel\":false,\"firstName\":\"jc84mentor-first\",\"originalStatus\":1,\"primaryKeyObj\":5601,\"modelAttributes\":{\"organizationId\":6201,\"approvedDate\":1561179636000,\"uuid\":\"b74d4218-8e75-4346-aefa-01f96f78d02a\",\"mentorId\":5601,\"userId\":\"321504\",\"remarks\":\"\",\"createDate\":null,\"status\":1},\"mentorId\":5601,\"remarks\":\"\",\"primaryKey\":5601,\"status\":1},\"LastName\":\"jc84mentor-last\",\"TrainingPrincipal\":{\"lastName\":\"\",\"secondaryPrincipalUserFirstName\":\"jc83sc-first\",\"columnBitmask\":0,\"cachedModel\":true,\"secondaryPrincipalUserEmail\":\"josechristian.lee.elico+83@sambaash.com\",\"groupId\":0,\"modelClassName\":\"com.sambaash.platform.srv.startupprofile.model.SPATOContacts\",\"organizationId\":6201,\"primaryPrincipalUserFirstName\":\"jc82tp-first\",\"secondaryPrincipalUserLastName\":\"jc83sc-last\",\"createDate\":null,\"expandoBridge\":{\"attributeColumns\":[],\"classPK\":4601,\"companyId\":20155,\"attributeNames\":{},\"indexEnabled\":true,\"attributes\":{},\"className\":\"com.sambaash.platform.srv.startupprofile.model.SPATOContacts\",\"table\":{\"companyId\":20155,\"name\":\"CUSTOM_FIELDS\",\"tableId\":263113,\"classNameId\":238105}},\"new\":false,\"modelClass\":\"com.sambaash.platform.srv.startupprofile.model.SPATOContacts\",\"originalSecondaryPrincipalUserId\":\"321497\",\"primaryPrincipalUserId\":\"321490\",\"spATOContactId\":4601,\"originalOrganizationId\":6201,\"userId\":0,\"secondaryPrincipalUserId\":\"321497\",\"escapedModel\":false,\"firstName\":\"\",\"originalPrimaryPrincipalUserId\":\"321490\",\"primaryKeyObj\":4601,\"primaryPrincipalUserLastName\":\"jc82tp-last\",\"modelAttributes\":{\"organizationId\":6201,\"firstName\":\"\",\"lastName\":\"\",\"primaryPrincipalUserId\":\"321490\",\"groupId\":0,\"spATOContactId\":4601,\"modifiedDate\":null,\"userId\":0,\"createDate\":null,\"secondaryPrincipalUserId\":\"321497\"},\"modifiedDate\":null,\"primaryPrincipalUserEmail\":\"josechristian.lee.elico+82@sambaash.com\",\"userUuid\":\"\",\"primaryKey\":4601},\"EmailAddress\":\"josechristian.lee.elico+84@sambaash.com\",\"AtoName\":{\"groupId\":237101,\"corporateCode\":\"\",\"emailId\":\"josechristian.lee.elico+81@sambaash.com\",\"videos\":\"\",\"completeness\":false,\"uuid\":\"ed81a8dd-1303-4cbb-a9de-afac3d1d8269\",\"feedback\":\"\",\"organizationId\":6201,\"twitter\":\"\",\"capitalRaised\":\"\",\"apiPath\":\"\",\"raisingFunds\":\"\",\"links\":\"\",\"contactDesignation\":\"\",\"contactName\":\"\",\"active\":true,\"linkedIn\":\"\",\"companyId\":20155,\"showInBlackbook\":false,\"stockSymbol\":\"\",\"listedCo\":\"\",\"modifiedDate\":1561179051000,\"name\":\"corp81\",\"noOfEmployees\":0,\"pipelineStatus\":0,\"corporateType\":\"\",\"logoId\":0,\"status\":1,\"approvalDate\":1561179042000,\"uniqueDesc\":\"\",\"description\":\"\",\"extras\":\"\",\"prevBusinessDevManager\":0,\"lifecycleStage\":\"\",\"isBaseOrg\":true,\"imageUrl\":\"\",\"methodologySubType\":0,\"shortPitch\":\"\",\"categories\":\"\",\"methodologyType\":0,\"createDate\":1561178085000,\"uen\":\"corp81UEN\",\"website\":\"\",\"foundedOn\":\"\",\"corporateCategory\":\"\",\"facebook\":\"\",\"mobile\":\"\",\"userName\":\"corp81-first corp-last\",\"userId\":321490,\"businessDevManager\":0,\"isATO\":true,\"crunchbase\":\"\",\"noOfPotentialCandidates\":0,\"stage\":0,\"faxNumber\":\"\",\"projectsWorkedOn\":\"\",\"profileOutline\":\"\",\"totalFunds\":\"\",\"videoLinks\":\"\",\"isIncorporated\":false}},\"StreetName\":\"PASIR RIS STREET 52\",\"declaration3reason\":\"\",\"MaritialStatusLOV\":{\"displayName\":\"Married\",\"groupId\":0,\"itemValue\":\"Married\",\"displayOrder\":1,\"userName\":\"\",\"userId\":0,\"uuid\":\"17fb533b-927c-11e9-8d55-029915cc7ed6\",\"itemKey\":\"basic.info.marital\",\"companyId\":0,\"modifiedDate\":null,\"spListTypeId\":2357,\"modeldata\":\"\",\"categoryId\":0,\"createDate\":null},\"CurrentEmploymentLetter\":[],\"IDType\":\"Passport\",\"CurrentEmploymentCountry\":\"Singapore\",\"programmeCode\":\"PP\",\"AtoName\":\"{\\\"groupId\\\":237101,\\\"corporateCode\\\":\\\"\\\",\\\"emailId\\\":\\\"josechristian.lee.elico+81@sambaash.com\\\",\\\"videos\\\":\\\"\\\",\\\"completeness\\\":false,\\\"uuid\\\":\\\"ed81a8dd-1303-4cbb-a9de-afac3d1d8269\\\",\\\"feedback\\\":\\\"\\\",\\\"organizationId\\\":6201,\\\"twitter\\\":\\\"\\\",\\\"capitalRaised\\\":\\\"\\\",\\\"apiPath\\\":\\\"\\\",\\\"raisingFunds\\\":\\\"\\\",\\\"links\\\":\\\"\\\",\\\"contactDesignation\\\":\\\"\\\",\\\"contactName\\\":\\\"\\\",\\\"active\\\":true,\\\"linkedIn\\\":\\\"\\\",\\\"companyId\\\":20155,\\\"showInBlackbook\\\":false,\\\"stockSymbol\\\":\\\"\\\",\\\"listedCo\\\":\\\"\\\",\\\"modifiedDate\\\":1561179051000,\\\"name\\\":\\\"corp81\\\",\\\"noOfEmployees\\\":0,\\\"pipelineStatus\\\":0,\\\"corporateType\\\":\\\"\\\",\\\"logoId\\\":0,\\\"status\\\":1,\\\"approvalDate\\\":1561179042000,\\\"uniqueDesc\\\":\\\"\\\",\\\"description\\\":\\\"\\\",\\\"extras\\\":\\\"\\\",\\\"prevBusinessDevManager\\\":0,\\\"lifecycleStage\\\":\\\"\\\",\\\"isBaseOrg\\\":true,\\\"imageUrl\\\":\\\"\\\",\\\"methodologySubType\\\":0,\\\"shortPitch\\\":\\\"\\\",\\\"categories\\\":\\\"\\\",\\\"methodologyType\\\":0,\\\"createDate\\\":1561178085000,\\\"uen\\\":\\\"corp81UEN\\\",\\\"website\\\":\\\"\\\",\\\"foundedOn\\\":\\\"\\\",\\\"corporateCategory\\\":\\\"\\\",\\\"facebook\\\":\\\"\\\",\\\"mobile\\\":\\\"\\\",\\\"userName\\\":\\\"corp81-first corp-last\\\",\\\"userId\\\":321490,\\\"businessDevManager\\\":0,\\\"isATO\\\":true,\\\"crunchbase\\\":\\\"\\\",\\\"noOfPotentialCandidates\\\":0,\\\"stage\\\":0,\\\"faxNumber\\\":\\\"\\\",\\\"projectsWorkedOn\\\":\\\"\\\",\\\"profileOutline\\\":\\\"\\\",\\\"totalFunds\\\":\\\"\\\",\\\"videoLinks\\\":\\\"\\\",\\\"isIncorporated\\\":false}\",\"userIdProcess\":\"321169\",\"RoleDateFrom\":\"2014-04-15T00:00:00+08:00\",\"GenderLOV\":{\"displayName\":\"Male\",\"groupId\":0,\"itemValue\":\"Male\",\"displayOrder\":1,\"userName\":\"Admin RELC\",\"userId\":20199,\"uuid\":\"86e1284c-5a77-11e9-a59b-027cdf543d18\",\"itemKey\":\"basic.info.gender\",\"companyId\":20155,\"modifiedDate\":1554751702000,\"spListTypeId\":2,\"modeldata\":\"\",\"categoryId\":0,\"createDate\":1554751702000},\"_lastPricingInvoice_\":\"PE-71602-205407\",\"exemptionNotificationContent\":\"\",\"ModelName\":\"Candidate\",\"CurrentEmploymentAppointment\":\"\",\"CurrentEmploymentStatus\":\"Employed\",\"IDTypeLOV\":{\"displayName\":\"Passport\",\"groupId\":0,\"itemValue\":\"Passport\",\"displayOrder\":5,\"userName\":\"Admin RELC\",\"userId\":20199,\"uuid\":\"86e1445c-5a77-11e9-a59b-027cdf543d18\",\"itemKey\":\"basic.info.id.type\",\"companyId\":20155,\"modifiedDate\":1554751702000,\"spListTypeId\":9,\"modeldata\":\"\",\"categoryId\":0,\"createDate\":1554751702000},\"Modelname\":\"candidate\",\"CandidateJobTitle\":\"Financial Accountant\",\"pay_error_code\":\"\",\"LastName\":\"\",\"CurrentEmploymentStatusLOV\":{\"displayName\":\"Employed\",\"groupId\":0,\"itemValue\":\"Employed\",\"displayOrder\":2,\"userName\":\"Admin RELC\",\"userId\":20199,\"uuid\":\"9188a04a-5c37-11e9-a59b-027cdf543d18\",\"itemKey\":\"employment.status\",\"companyId\":20155,\"modifiedDate\":1554912000000,\"spListTypeId\":501,\"modeldata\":\"\",\"categoryId\":0,\"createDate\":1554912000000},\"CurrentEmploymentDesignation2\":\"\",\"CountryofNationality\":\"India\",\"processStateId\":\"71602\",\"ExamBody\":\"SAC\",\"submit\":true,\"PostalCode\":\"510504\",\"FunctionalComponent\":\"AD\",\"CurrrentJobResponsibilities\":\"\",\"UnitNo\":\"123\",\"AcademicQualification\":[{\"ClassofDegreeorDiploma\":\"First Class Honours / Summa Cum Laude\",\"NameofQualification\":\"Bachelor of Business Administration (Accountancy)\",\"QualificationToDate\":\"2012-06-14T00:00:00+08:00\",\"TypeofQualification\":\"Direct Entry Degree\",\"AwardingInstitution\":\"National University of Singapore\",\"Country\":\"Singapore\",\"DegreeCertificate\":[{\"originalName\":\"Screenshot 2019-06-21 at 10.33.31 AM.png\",\"size\":158105,\"data\":{\"size\":158105,\"name\":\"Screenshot 2019-06-21 at 10.33.31 AM.png\",\"url\":\"https://sac.sambaash.com/documents/237101/321601/Screenshot%202019-06-21%20at%2010.33.31%20AM.png?version=1.0\",\"fileEntryId\":321605},\"name\":\"screenshot-40f691e9-567e-4717-8061-0f2a9ba6f327.png\",\"storage\":\"url\",\"type\":\"image/png\",\"url\":\"https://sac.sambaash.com/documents/237101/321601/Screenshot%202019-06-21%20at%2010.33.31%20AM.png?version=1.0\"}],\"QualificationFromDate\":\"2010-06-10T00:00:00+08:00\"}],\"pay_status\":\"success\",\"entryRoute\":\"1\",\"SrnNumber\":\"\",\"ProgrammeTitle\":\"Professional Programme\",\"FormId\":\"1999\",\"GraduateAwardsGrid\":\"\",\"MaritialStatus\":\"Married\",\"Others\":\"\",\"isExistingMentor\":\"yes\",\"Mode\":\"edit\",\"StatusLOV\":{\"displayName\":\"Active\",\"groupId\":0,\"itemValue\":\"1\",\"displayOrder\":1,\"userName\":\"Admin RELC\",\"userId\":20199,\"uuid\":\"59b8c47e-7df7-11e9-a59b-027cdf543d18\",\"itemKey\":\"candidate.status\",\"companyId\":20155,\"modifiedDate\":1554751702000,\"spListTypeId\":2014,\"modeldata\":\"\",\"categoryId\":0,\"createDate\":1554751702000},\"ProfessionalQualification\":[{\"Attainedon\":\"2014-06-15T00:00:00+08:00\",\"NameofProfQualification\":\"Financial Accountant\",\"ProfessionalBody\":\"Chartered Professional Accountants of Canada (CPA Canada)\"}],\"charge_ref_code\":\"ch_1Eo1khFxkufXIZX1SZGbHhn1\",\"selectedATOs\":[\"6201\"],\"UserId\":\"321169\",\"FullName\":\"Ram Chelvan\",\"CurrentEmploymentPeopleReporting\":\"\",\"Undergraduate\":\"no\"},\"storageId\":\"321169\"}";
			JSONObject candidatesData = new JSONObject();
			candidatesData = (JSONObject)new JSONObject(userDetails).get("contentJson");
			try
			{
// 				if(candidatesData.has("SponsorshipType") && !candidatesData.getString("SponsorshipType").equals("Self Sponsored"))
// 				{
// 					if(candidatesData.has("AtoDetails") && candidatesData.getJSONArray("AtoDetails").length() >= 1)
// 					{
// 						showAddRPEC = true;
// 					}					
// 				}
				if(candidatesData.has("AtoDetails") && candidatesData.getJSONArray("AtoDetails").length() >= 1)
				{
					showAddRPEC = true;
				}
			}catch(Exception ce)
			{
				if(candidatesData.has("AtoDetails"))
				{
					if(candidatesData.getJSONObject("AtoDetails").has("AtoName"))
					{
						showAddRPEC = true;
					}
				}
// 				if(candidatesData.has("SponsorshipType") && !candidatesData.getString("SponsorshipType").equals("Self Sponsored"))
// 				{
// 					if(candidatesData.has("AtoDetails"))
// 					{
// 						if(candidatesData.getJSONObject("AtoDetails").has("AtoName"))
// 						{
// 							showAddRPEC = true;
// 						}
// 					}
// 				}
				
			}
			
			System.out.println("userDetails list.jsp -->" + userDetails + " - userType = " + userType);
		}
		
		
		
		
%>
<c:set var="formType" value='<%=modelName%>' />
<portlet:resourceURL var="resourceURL">

</portlet:resourceURL>

<portlet:renderURL var="homePage">
	<portlet:param name="jspPage" value="" />
</portlet:renderURL>
<portlet:resourceURL var="globalexportlisturl">
	<portlet:param name="action" value="exportRow" />
</portlet:resourceURL>
<div class="newPortlets">
	<%
		HttpServletRequest httpReq = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest)); 
			
		
		
		if (PermissionUtil.canAddModel((PortletRequest) request.getAttribute("javax.portlet.request"))) {
	%>
	<%
		String dashBoardLink = SambaashUtil.getDashBoard();
	%>


<div style="display: none; margin-top: 45px;" class="alert"
	role="showAlert" id="alert_msg1"></div>
<!-- 	<div style="display: none;" class="alert" role="showAlert"
		id="alert_msg"></div> -->


<!-- 	<div -->
<!-- 		class="formContainer container formio-form dataListing p-0 grid-container" -->
<!-- 		style="padding-bottom: 0px; background-color: #f7f9fc !important;"> -->

	<div class="formContainer container formio-form dataListing p-0 grid-container">

		<div class="subHeader">
			<div class="container">
				<aui:row>

					<aui:col span="10" cssClass="text-center">
						<h2>RPEC SUMMARY</h2>
					</aui:col>
					<aui:col class="span2 text-right" span="2" style="margin-left: 0;">
						<aui:a href="/workspace" title="Back to Workspace">Back to Workspace</aui:a>
					</aui:col>
				</aui:row>
			</div>
		</div>
		<%
			if(PermissionUtil.canReviewContext((PortletRequest) request.getAttribute("javax.portlet.request"))){
		%>
		<div class="row-fluid"> 
		<div class="span4 " id=""> </div>
			<div class="card-body panel-body span4 choices formio-choices" style="display: block; margin-top: 10px; border: none;" hidden="true" id="panel1Div">
				<label cssClass="control-label">Candidate Name</label>
				<div class="form-control dropdown-container" tabindex="0" id="container1">
				
					<%
						JSONArray users = JSONFactoryUtil.createJSONArray();
						if(userType.toLowerCase().equals("mentor")) {
						    users = SPRPECLocalServiceUtil.getCandidateListOfMentor(themeDisplay.getUserId(), themeDisplay.getScopeGroupId());
						} else if (userType.toLowerCase().equals("trainingprincipal")){
						    users = SPRPECLocalServiceUtil.getCandidateListOfTp(themeDisplay.getUserId(), themeDisplay.getScopeGroupId());
						} else {
						    users = SystemServiceUtil.getModelList("candidate",
				                    "UserId,IDNumber,FirstName,LastName", themeDisplay.getScopeGroupId(), 
				                    "{\"contentJson.Status\":\"Active\"}",
				                    "[{\"direction\":\"asc\",\"field\":\"FirstName\",\"contentJSON\":\"true\"}]", 2147483647);
						}
						candidatesList = users.toString().replace("\"", "\'");
						System.out.println("candidatesList --> " + candidatesList);
					%>
		   			<button class="col-sm-12 form-control select-button text-grey search-close" lang="en" tabindex="-1" onclick="propogateCandidateSearchOptions()" id="candidateSearchButton" style="text-align: left; font-size: 16px">Select Candidate</button>
		   			<input type="text" placeholder="Type &amp; Search..." style="display: none; background-color: rgb(245, 247, 251);" id="Candidatesearchbar" oninput="propogateCandidateSearchResults(this.value)" class="">
		   			<div class="choices__list" style="display: none;" id="choicesList">
						
						<%
								//JSONArray users = JSONFactoryUtil.createJSONArray();
	// 							if(userType.toLowerCase().equals("mentor")) {
	// 							    users = SPRPECLocalServiceUtil.getCandidateListOfMentor(themeDisplay.getUserId(), themeDisplay.getScopeGroupId());
	// 							} else if (userType.toLowerCase().equals("trainingprincipal")){
	// 							    users = SPRPECLocalServiceUtil.getCandidateListOfTp(themeDisplay.getUserId(), themeDisplay.getScopeGroupId());
	// 							} else {
	// 							    users = SystemServiceUtil.getModelList("candidate",
	// 					                    "UserId,IDNumber,FirstName,LastName", themeDisplay.getScopeGroupId(), 
	// 					                    "{\"contentJson.Status\":\"Active\"}",
	// 					                    "[{\"direction\":\"asc\",\"field\":\"FirstName\",\"contentJSON\":\"true\"}]", 2147483647);
	// 							}
								for (int i = 0; i < users.length(); i++) {
								    if(users.getJSONObject(i)!=null) {
									    String fullName = users.getJSONObject(i).getString("FirstName") + " "
						                            + users.getJSONObject(i).getString("LastName");
						                String usrId = users.getJSONObject(i).getString("UserId");
						                csvCandidates = csvCandidates + usrId + ",";
						                String idNumber = users.getJSONObject(i).getString("IDNumber");
						                %>
						                <div class="choices__item choices__item--choice choices__item--selectable is-highlighted" id="<%=usrId%>" onclick="selectCandidate('[<%=idNumber%>] <%=fullName%>', '<%=usrId%>')"><span>[<%=idNumber%>] <%=fullName%></span></div>
						                <%
								    }
								}
								
	// 							candidatesList = users.toString();
	// 							System.out.println("candidatesList --> " + candidatesList);
								%>
								
				  	</div>
				</div>
			</div>
		</div>

		
		<%
			}
		%>
		<%
			if(PermissionUtil.canViewListing((PortletRequest) request.getAttribute("javax.portlet.request"))){
		%>

		<div id="no-data" class="p-30 hide">
			<%-- <aui:row>
					<aui:col span="4">
					</aui:col>
					<aui:col span="4" cssClass="choices formio-choices">
						<div class="form-group">
							<label cssClass="control-label">Candidate Name</label>
							<aui:select name="" id="candidates" cssClass="form-control"
								placeholder="Choose a Session Schedule"
								onChange="fetchEntityLink(this.value);">
								<aui:option value="" hidden="true">
								</aui:option>
							</aui:select>
						</div>
					</aui:col>
				</aui:row> --%>
			<br>
			<div class="text-center">
				<img src="/SPRPEC-portlet/img/empty.png" height="150px" width="150" />

				<div class="no-data-text-one">No record of Practical
					Experience yet!</div>
				<div class="no-data-text-two">A new record can be created
					using the button below.</div>
			</div>
		</div>
		<div id="have-data" class="p-30">
			<br>
			<div class="Table-Layout" id="entityLinkContainer">
				<div class="Row addInfo">
					<!-- 				<div class="Heading"> -->
					<div class="Cell listsortasc" onclick="sortData(this,'reviewPeriodNumber')">
						<div class="d-flex">
							<p><%=LabelUtil.getLabel(pageContext, themeDisplay, "repc.revPerNo")%></p>
							<i></i>
						</div>
					</div>
					<div class="Cell listsortasc" onclick="sortData(this,'candidateName')">
					<div class="d-flex" id="candidateName">
						<p><%=LabelUtil.getLabel(pageContext, themeDisplay, "rpec.candidateName")%></p>
						<i></i>
					</div>
					
					</div>
					<div class="Cell listsortasc" onclick="sortData(this,'reviewFromDate')">
					<div class="d-flex" id="stageClmn">
						<p><%=LabelUtil.getLabel(pageContext, themeDisplay, "rpec.startDate")%></p>
						<i></i>
					</div>
					</div>
					<div class="Cell listsortasc" onclick="sortData(this,'reviewToDate')">
					<div class="d-flex">
						<p><%=LabelUtil.getLabel(pageContext, themeDisplay, "rpec.endDate")%></p>
						<i></i>
					</div>
					</div>
					<div class="Cell listsortasc" onclick="sortData(this,'accreditedTrainingOrganisation')">
					<div class="d-flex">
						<p><%=LabelUtil.getLabel(pageContext, themeDisplay, "rpec.ato")%></p>
						<i></i>
					</div>
					</div>
					<div class="Cell listsortasc" onclick="sortData(this,'mentorName')">
					<div class="d-flex">
						<p><%=LabelUtil.getLabel(pageContext, themeDisplay, "rpec.mentorName")%></p>
						<i></i>
					</div>
					</div>
					<div class="Cell listsortasc" onclick="sortData(this,'candidateJobRole')">
					<div class="d-flex">
						<p><%=LabelUtil.getLabel(pageContext, themeDisplay, "rpec.role")%></p>
						<i></i>
					</div>
					</div>
					<div class="Cell listsortasc" onclick="sortData(this,'totalDaysSpentOnPracticalExperience')">
					<div class="d-flex">
						<p><%=LabelUtil.getLabel(pageContext, themeDisplay, "rpec.totalExp")%></p>
						<i></i>
					</div>
					</div>
				<div class="Cell listsortasc" onclick="sortData(this,'rpecStatus')">
					<div class="d-flex">
						<p><%=LabelUtil.getLabel(pageContext, themeDisplay, "rpec.recordStatus")%></p>
						<i></i>
					</div>
					</div>
					<div class="Cell">
						<p>
							<input type="hidden" id="comDet">
						</p>
					</div>
					<div class="Cell">
						<p>
							<input type="hidden" id="contextMenu">
						</p>
					</div>
					<!-- 				</div> -->
				</div>
			</div>
			<!-- <div class="" id="mainRow"> -->
			<div id="sampleEntityLinkRow" class="hide Row addInfo">
				<div class="Cell hide">
					<p id="id"></p>
				</div>
				<div class="Cell hide">
					<p id="candidateId"></p>
				</div>
				<div class="Cell">
					<p id="reviewPeriodNumber"></p>

				</div>
				<div class="Cell">
					<p id="candidateName"></p>
				</div>
				<div class="Cell">
					<p id="startDate"></p>
				</div>
				<div class="Cell">
					<p id="endDate"></p>
				</div>
				<div class="Cell">
					<p id="accreditedTrainingOrganisation"></p>
				</div>
				<div class="Cell">
					<p id="mentorName"></p>
				</div>
				<div class="Cell">
					<p id="candidateJobRole"></p>
				</div>
				<div class="Cell text-right" style="max-width: 100px;">
					<p id="totalDaysSpentOnPracticalExperience"></p>
				</div>
				<div class="Cell">
			
					<p class="status-rpec" id="statusOfRpec"></p>
				</div>
				<div class="Cell">
					<p id="context"></p>
					<div id="menu"></div>
				</div>
				<div class="Cell">
					<p id="expandCell"></p>
				</div>
				<div class="Cell hide">
					<p id="isStandardReview"></p>
				</div>
				<div class="Cell hide">
					<p id="isFinalReview"></p>
				</div>
				<div class="Cell hide">
					<p id="isSignOff"></p>
				</div>
			</div>
			<div class="Row addInfo pt-0 hide" id="expandDet">
				<aui:row id="detRow" style="padding: 15px;" cssClass="d-flex table-responsive">
					<aui:col span="6" id="leftTbl" cssClass="w-50 text-left p-0 table borderless">
					</aui:col>
					<aui:col span="6" id="rightTbl"
						style="margin-left: 3px; margin-right: -3px;background-color:white "
						cssClass="w-50 text-left p-0 table borderless"></aui:col>
<%-- 						<aui:col id="nodata" style="text-align: center !important; color:rgb(154, 158, 162) !important;" cssClass="hide">No data</aui:col> --%>
				</aui:row>
				<aui:row id="nodata"  cssClass="d-flex hide">
					<aui:col id="" style="text-align: center !important; color:rgb(154, 158, 162) !important;" cssClass="">No Detail Available!</aui:col>
				</aui:row>
			</div>
			<!-- 	</div> -->
			<div id="MultirowPopAction"
				class="Multi-Pop-Action threedot contextmenu hide"
				style="z-index: 1;">
				<ul>

					<%
						if(PermissionUtil.canViewRPEC((PortletRequest) request.getAttribute("javax.portlet.request"))){
					%>
					<li><img src="/SPRPEC-portlet/img/details@3x.png"
						alt="View Detail"><a href="javascript:void(0);"
						onclick="doAction('detail',this);">View Detail</a></li>
					<%
						}
					%>
					<%
						if(PermissionUtil.canEditRPEC((PortletRequest) request.getAttribute("javax.portlet.request"))){
					%>
					<li><img src="/SPRPEC-portlet/img/edit@3x.png"
						alt="Edit Detail"><a href="javascript:void(0);"
						onclick="doAction('edit',this);">Edit Detail</a></li>
					<%
						}
					%>
					<%
						if(PermissionUtil.canAmendRPEC((PortletRequest) request.getAttribute("javax.portlet.request"))){
					%>
					<li><img src="/SPRPEC-portlet/img/edit@3x.png"
						alt="Update/Amend Detail"><a href="javascript:void(0);"
						onclick="doAction('amend',this);">Update/Amend Detail</a></li>
					<%
						}
					%>
					<%
						if(PermissionUtil.canNullifyRecord((PortletRequest) request.getAttribute("javax.portlet.request"))){
					%>

					<li class="hide"><img
						src="/SPRPEC-portlet/img/process-enrolment@3x.png"
						alt="Nullify Record"><a href="javascript:void(0); "
						onclick="nullifyThisRecord(this);">Nullify Record</a></li>
					<%
						}
					%>
					<%
						if(PermissionUtil.canReviewContext((PortletRequest) request.getAttribute("javax.portlet.request"))){
					%>
					<li><img src="/SPRPEC-portlet/img/process-enrolment@3x.png"
						alt="Review RPEC Record"><a href="javascript:void(0);"
						onclick="doAction('review',this);">Review RPEC Record</a></li>
					<%
						}
					%>
					<%
						if(PermissionUtil.canApprovedRPEC((PortletRequest) request.getAttribute("javax.portlet.request"))){
					%>
					<li><img src="/SPRPEC-portlet/img/process-enrolment@3x.png"
						alt="Mark As Approved"><a href="javascript:void(0);"
						onclick="markAsApproved(this);">Mark As Approved</a></li>
					<%
						}
					%>

					<li><img src="/html/images/export.png" alt="List Export"><a
						href="javascript:void(0);" onclick="exportStorage1(event,this);">Export</a></li>
					<%
						if(PermissionUtil.canArchiveRPECRecord((PortletRequest) request.getAttribute("javax.portlet.request"))){
					%>
					<li><img src="/html/images/archive.png" alt="Archive"><a
						href="javascript:void(0);" onclick="archiveRecord(this)">Archive</a></li>
					<%
						}
					%>
				</ul>
			</div>

			<table id="tbl" class="hide">
				<tr>
					<th>Sr.No</th>
					<th>Competency Type</th>
					<th>Average Profenciency</th>
				</tr>

			</table>

			<div class="pagination"
				style="background-color: #d9eaff; padding: 0px;">
				<aui:row>
					<aui:col span="4" cssClass="text-left p-15">
						<div style="color: #c51212; font-size: 10px;">&#10038; -
							Recognition Of prior work experience approved by SAC/ISAC</div>
					</aui:col>
					<aui:col span="8" cssClass="text-right">
						<div class="d-flex pull-right">

							<div class="grid-footer-cell">
								<p>
									<b>Total Practical Experience </b>
								</p>
							</div>
							<div class="grid-footer-cell" style="width: 100px;">
								<b id="selectedCount">0</b>
							</div>
							<div style="width: 241px !important;" class="grid-footer-cell">
								<p></p>
							</div>
						</div>
					</aui:col>


				</aui:row>
			</div>


		</div>
		<%
			}
		%>
		<%
		/* System.out.println("PermissionUtil.canAddRPECRecord((PortletRequest) request.getAttribute::"+PermissionUtil.canAddRPECRecord((PortletRequest) request.getAttribute("javax.portlet.request")));*/
			if(PermissionUtil.canCreateRPECRecord((PortletRequest) request.getAttribute("javax.portlet.request"))){ 
		%>
		<aui:row cssClass="text-center" style="margin-top: 50px;">

			<aui:col span="12" cssClass="choices formio-choices">
				<div class="add-tooltip" id="tooltip" style="display: none">
					<img src="/html/images/info.png"
						style="float: left; margin: 5px 0px 5px 10px;"> <span
						style="vertical-align: middle;" id="tooltipmsg"></span>
				</div>
				<div class="form-group" onmouseover="toggleToolTip(true)" onmouseleave="toggleToolTip(false)"
					style="margin: 0 auto; display: table;">
<!-- 					<button type="button" class="btn btn-default" id="addRpec" -->
<!-- 						style="background: #18a216 !important; width: 180px !important; color: #eff4fb !important" -->
<!-- 						onClick="doAction('add',this)">ADD RPEC RECORD</button> -->
						
						<button type="button" class="btn btn-default rpec-rcbtn rpec-rcbtn-margin" id="addRpec"
						onClick="doAction('add',this)">ADD RPEC RECORD</button>
				</div>	
			</aui:col>
		</aui:row>
		<%
	 	} 
		%>
	</div>
</div>

<%
	}
%>
<div class="yui3-skin-sam">
	<div id="nullify-confirm" hidden="true" class="modalpopupBox nullify">
		<div id="nullify-confirm-box" class="modalpopupContent">
			<form class="formContainer" action="">
				<aui:row>
					<aui:col span="12">
						<h3 class="nullify-h3">Nullify this record?</h3>
					</aui:col>
				</aui:row>
				<aui:row>
					<aui:col span="12" style="text-align:center">
						<span class="nullify-text">Please provide your reasons
							justifying this action.</span>
					</aui:col>
				</aui:row>
				<aui:row>
					<aui:col span="12">
						<input type="text" name="nullify-reason" class="nullify-reason"
							id="nullifyreason" placeholder="Add your reasons here..." />
					</aui:col>
				</aui:row>
				<aui:row>
					<aui:col span="12">
						<button type="button"
							class="btn  btn-default popup-confirm-nullify pull-left"
							style="margin-left: 0; margin-right: 0; font-size: 12px !important">CONFIRM</button>
						<button type="button"
							class="btn btn-primary popup-cancel-nullify pull-right"
							style="width: 131px; margin-left: 0; margin-right: 0; font-size: 12px !important">CANCEL
						</button>
					</aui:col>
				</aui:row>

			</form>
		</div>
	</div>
</div>
<div class="yui3-skin-sam">
			<div id="success-status-update" hidden="true" class="modalpopupBox">
				<div id="success-status-update-box" class="modalpopupContent">
					<form class="formContainer" action="">
						<aui:row>
							<aui:col span="12">
								<h3>RPEC Review Completed Successfully!</h3>
							</aui:col>
						</aui:row>
						<aui:row>
							<aui:col span="12">
								<button type="button"
									class="btn btn-primary popup-back-to-record-status pull-left"
									style="width: 200px; margin-left: 0; margin-right: 0; font-size: 12px !important">BACK
									TO RPEC SUMMARY</button>
								<button type="button"
									class="btn btn-default popup-back-to-home-status pull-right"
									style="width: 131px; margin-left: 0; margin-right: 0; font-size: 12px !important">GO
									TO HOME</button>
							</aui:col>
						</aui:row>

					</form>
				</div>
			</div>
</div>
<div class="loadingDiv" id="loadingDiv" style="left:0">
			<div class="m-blockui"
				style="position: fixed; z-index: 1031; left: 50%; top: 50%;">
				<span>Please Wait</span> <span>
					<div class="m-loader m-loader--brand"></div>
				</span>
			</div>
</div>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/erpec-candidates/erpec-candidates.js?<%=System.currentTimeMillis()%>"
	language="javascript1.2"></script>




<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/erpec-candidates/schedule.js?<%=System.currentTimeMillis()%>"
	language="javascript1.2"></script>






<script>
var config = {
		createPage: "/html/RPEC/addrpec.jsp",
	};
var namespace =  "<portlet:namespace/>";
var ajaxUrl = "${resourceURL}";
var modelName = "<%=modelName%>";
var mode = "view";
var isDDCan=false;
var isAddRpecVisible=false;
var userIdDD;
var sortFlag='false';
var homeUrl = "<%=homePage%>";
var globalexportlisturl="<%=globalexportlisturl%>";
var userType = "<%=userType%>";
var showAddRPEC = <%=showAddRPEC%>;
var baseUrl = "<%=baseUrl%>";
var userId = "<%=userId%>";
var userName = "<%=userName%>";
var csvCandidates = "<%=csvCandidates%>";
<%-- var candidatesList = JSON.stringify(<%=candidatesList%>); --%>
<%-- var candidatesList = "<%=candidatesList%>"; --%>

if(!showAddRPEC && document.getElementById("tooltipmsg") !== null)
{
	document.getElementById("tooltipmsg").innerText = 'Sorry, you are not allowed to submit a new record since you are currently not associated with any ATO. Please update in \'Candidate Details\' if you\'re part of an ATO already.';
}

if(userType.toLowerCase() == "candidate")
{
	isAddRpecVisible=true;
}
if(document.getElementById("addRpec")!=null)
{
document.getElementById("addRpec").disabled = true;
}
var filePath="<%=request.getContextPath()%>";
document.getElementById("selectedCount").innerHTML = 0;
var pageRequested = 1, totalRecords = 0, totalPages = 0;
document.getElementById("selectedCount").innerHTML = 0;
function fetchEntityLink(d) {
    isDDCan = true;
	isAddRpecVisible = true;
	userIdDD = d;
	if(userIdDD=="") {
		reloadTable();
	} else {
		loadCandidate("false");
	}
}
</script>


<style>
.borderless table {
    border-top-style: none;
    border-left-style: none;
    border-right-style: none;
    border-bottom-style: none;
}
.borderless td, .borderless th {
    border: none;
    border-top: unset !important;
    border-bottom: unset !important;
}
input[type=checkbox] {
	display: block !important;;
	float: left !important;;
	/* 	opacity: 1 !important; */ * {
	box-sizing: border-box;
}

table td {
	text-align: center !important;
}

.Table-Layout .Row .expandDivDe {
	display: table-row;
	position: relative;
	vertical-align: top;
}

/* Create two equal columns that sits next to each other */
.Table-Layout {
	flex: 50%;
	padding: 10px;
	height: 300px; /* Should be removed. Only for demonstration */
}

</style>


<%-- <sp-formio:Listing cssClass="formContainer" modelName="${formType}" /> --%>

<%
	}
%>


