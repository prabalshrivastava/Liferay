/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.sambaash.platform.systemmodelsetup.service.impl;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

import javax.portlet.ResourceRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.liferay.portal.NoSuchUserException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.User;
import com.liferay.portal.security.ac.AccessControlled;
import com.liferay.portal.security.auth.CompanyThreadLocal;
import com.liferay.portal.security.membershippolicy.RoleMembershipPolicyUtil;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.security.permission.PermissionThreadLocal;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.model.AssetVocabulary;
import com.liferay.portlet.asset.service.AssetVocabularyLocalServiceUtil;
import com.liferay.util.PwdGenerator;
import com.sambaash.platform.constant.SambaashConstants;
import com.sambaash.platform.srv.processbuilder.model.PEProcessState;
import com.sambaash.platform.srv.processbuilder.service.PEProcessStateLocalServiceUtil;
import com.sambaash.platform.srv.spsocialprofile.service.SocialProfileLocalServiceUtil;
import com.sambaash.platform.srv.startupprofile.service.OrganizationLocalServiceUtil;
import com.sambaash.platform.systemmodelsetup.service.SystemLocalServiceUtil;
import com.sambaash.platform.systemmodelsetup.service.base.SystemServiceBaseImpl;
import com.sambaash.platform.util.PermissionUtil;
import com.sambaash.platform.util.SambaashUtil;

/**
 * The implementation of the system remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.sambaash.platform.systemmodelsetup.service.SystemService}
 * interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have
 * security checks based on the propagated JAAS credentials because this service
 * can be accessed remotely.
 * </p>
 *
 * @author biswo
 * @see com.sambaash.platform.systemmodelsetup.service.base.SystemServiceBaseImpl
 * @see com.sambaash.platform.systemmodelsetup.service.SystemServiceUtil
 */
public class SystemServiceImpl extends SystemServiceBaseImpl {
	private static final int DEFAULT_PAGE_SIZE = 1000;
	private static Log logger = LogFactoryUtil.getLog(SystemServiceImpl.class);
	private static final String CONTENT_JSON = "contentJson";
	private static final String STORAGE_ID = "storageId";
	private static String requestURL = "Request URL";
	private static final String APPROVED_MENTORS = "ApprovedMentors";
	private static final String USER_ID = "userId";
	private static final String ATO_NAME = "AtoName";
	private static final String ATO_DETAILS = "AtoDetails";
	private static final String CANDIDATE_MODEL = "candidate";
	private static final String SCHEDULE_MODEL = "schedule";
	private static final String PREPARE_CLAIM_MODEL = "preparedclaim";

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link
	 * com.sambaash.platform.systemmodelsetup.service.SystemServiceUtil} to
	 * access the system remote service.
	 */
	@AccessControlled(guestAccessEnabled = true)
	public JSONArray getCategory(String vocabularyName, long groupId)
			throws JSONException, SystemException, org.json.JSONException {
		List<AssetCategory> assetCategories = new ArrayList<>();
		JSONArray categoryArray = JSONFactoryUtil.createJSONArray();
		try {
			AssetVocabulary vocabulary = AssetVocabularyLocalServiceUtil.getGroupVocabulary(groupId, vocabularyName);

			if (Validator.isNotNull(vocabulary)) {
				assetCategories = vocabulary.getCategories();
				for (AssetCategory assetCategory : assetCategories) {
					JSONObject js = JSONFactoryUtil.createJSONObject();
					js.put("id", assetCategory.getName());
					js.put("name", assetCategory.getName());
					categoryArray.put(js);
				}
				return categoryArray;
			}
		} catch (PortalException e) {
			return categoryArray;
		}
		return categoryArray;
	}

	@AccessControlled(guestAccessEnabled = true)
	public JSONArray getModelList(String modelName, String fieldList, long groupId, String matchJsonString,
			String sortString) throws JSONException, SystemException, org.json.JSONException {
		return getModelList(modelName, fieldList, groupId, matchJsonString, sortString, DEFAULT_PAGE_SIZE);
	}
	
	@AccessControlled(guestAccessEnabled = true)
	public JSONArray getModelList(String modelName, String fieldList, long groupId, String matchJsonString,
			String sortString, int pageSize) throws JSONException, SystemException, org.json.JSONException {

		JSONArray resultList = JSONFactoryUtil.createJSONArray();
		try {
			String response = SystemLocalServiceUtil.getElasticSearchListForModel(modelName, groupId, matchJsonString,
					sortString, pageSize);
			JSONObject jsonResponse = JSONFactoryUtil.createJSONObject(response);
			JSONArray content = jsonResponse.getJSONArray("content");
			JSONObject record;
			String[] fields = fieldList.split(",");
			if (Validator.isNotNull(content)) {
				JSONObject js;
				for (int i = 0; i < content.length(); i++) {
					record = content.getJSONObject(i);
					if (StringUtils.isNotEmpty(fieldList)) {
						js = populateReturnFields(record, fields);
					} else {
						// return all contentJson fields
						js = record.getJSONObject(CONTENT_JSON);
						// and storageId
						js.put(STORAGE_ID, record.getString(STORAGE_ID));
					}
					resultList.put(js);
				}
				return resultList;
			}
		} catch (PortalException e) {
			return resultList;
		}
		return resultList;
	}

	public JSONArray getModelList(String modelName, String fieldList, long groupId, String matchJsonString)
			throws JSONException, SystemException, org.json.JSONException {
		return getModelList(modelName, fieldList, groupId, matchJsonString, StringPool.BLANK);
	}

	@AccessControlled(guestAccessEnabled = true)
	public User getUserByEmail(long companyId, String emailAddress) throws PortalException, SystemException {

		String decodedemailAddress = decode(emailAddress);
		User user = userLocalService.getUserByEmailAddress(companyId, decodedemailAddress);

		return user;
	}
	
	
	@AccessControlled(guestAccessEnabled = true)
	public String createRecord(String modeldata, long userId, long siteId, String model) {

		String response = StringPool.BLANK;
		try {
			String decodedModeldata = HttpUtil.decodeURL(modeldata);
			logger.debug("creating data" + decodedModeldata);
			String apiModelData = convertToAPIModel(userId, siteId, decodedModeldata, "{}");
			logger.debug("api model data is " + apiModelData);
			String subUrl = model.toLowerCase() + "/new";
			response = new APICall(userId, siteId).postForObject(apiModelData, subUrl);
			logger.debug("response" + response);
		} catch (Exception e) {
			logger.error(e);
		}
		return response;
	}

	@AccessControlled(guestAccessEnabled = true)
	public String createRecordNew(long processStateId, long userId, long siteId, String model) {

		String response = StringPool.BLANK;
		try {
			PEProcessState state = PEProcessStateLocalServiceUtil.getPEProcessState(processStateId);
			state = PEProcessStateLocalServiceUtil.clearCacheAndGetProcessState(state);
			JSONObject stateData = JSONFactoryUtil.createJSONObject(state.getData());

			logger.debug("model data is " + stateData);
			String apiModelData = convertToAPIModel(userId, siteId, stateData.toString(), "{}");
			logger.debug("api model data is " + apiModelData);
			String subUrl = model.toLowerCase() + "/new";
			logger.debug("create data new" + apiModelData);
			response = new APICall(userId, siteId).postForObject(apiModelData, subUrl);
			logger.debug("response" + response);

		} catch (Exception e) {
			logger.error(e);
		}
		return response;
	}

	@AccessControlled(guestAccessEnabled = true)
	public String updateRecordFromProcessState(String processStateId, String userId) {
		String response = StringPool.BLANK;
		try {
			PEProcessState processState = PEProcessStateLocalServiceUtil
					.getPEProcessState(Long.parseLong(processStateId));
			logger.debug("state data " + processState.getData());
			JSONObject dataJsonObj = JSONFactoryUtil.createJSONObject(processState.getData());
			String modelName = dataJsonObj.getString("Modelname");
			if (modelName.equalsIgnoreCase(StringPool.BLANK)) {
				modelName = CANDIDATE_MODEL;
			}
			logger.info("dataJsonObj : "+dataJsonObj.toString());
			
			String atoName = dataJsonObj.getString(ATO_NAME);
			logger.info("atoName : "+atoName);
			if(!StringUtils.isEmpty(atoName)) {
				String currentAtoString = getCandidateCurrentAto(Long.parseLong(userId), Long.parseLong(userId), processState.getGroupId());
				if(StringUtils.isEmpty(currentAtoString)) {
					currentAtoString = "{}";
				}
				JSONObject currentAto = JSONFactoryUtil.createJSONObject(currentAtoString);
				if(!currentAto.has(ATO_NAME)) {
					String subUrl = modelName.toLowerCase() + "/get/"+userId;
					String existingData = new APICall(processState.getUserId(), processState.getGroupId()
							).exchange(subUrl, HttpMethod.GET);
					mapAtoDetails(dataJsonObj);
					JSONObject contentJson = JSONFactoryUtil.createJSONObject(existingData).getJSONObject(CONTENT_JSON);
					JSONArray newAtoDetails = JSONFactoryUtil.createJSONArray();
					try {
						JSONObject atoDetails = contentJson.getJSONObject(ATO_DETAILS);
						newAtoDetails.put(atoDetails);
						newAtoDetails.put(dataJsonObj.getJSONObject(ATO_DETAILS));
					} catch(Exception e) {
						if(contentJson.has(ATO_DETAILS)) {
							newAtoDetails = contentJson.getJSONArray(ATO_DETAILS);
						}
						newAtoDetails.put(dataJsonObj.getJSONObject(ATO_DETAILS));
					}
					contentJson.put(ATO_DETAILS, newAtoDetails);
					JSONObject apiMD = JSONFactoryUtil.createJSONObject();
					apiMD.put(CONTENT_JSON, contentJson);
					String apiModelData = apiMD.toString();
					logger.debug("api model data is " + apiModelData);
					subUrl = modelName.toLowerCase() + "/edit/"+userId;
					logger.debug("create data" + apiModelData);
					response = new APICall(processState.getUserId(), processState.getGroupId()).putForObject(apiModelData,
							subUrl);
					logger.debug("response" + response);
				}
			}
		} catch(Exception e) {
			logger.error(e);
		}
		return response;
	}
	
	@AccessControlled(guestAccessEnabled = true)
	public String createRecordFromProcessState(String processStateId) {
		String response = StringPool.BLANK;
		logger.debug("processStateId :  " + processStateId);
		try {
			PEProcessState processState = PEProcessStateLocalServiceUtil
					.getPEProcessState(Long.parseLong(processStateId));
			logger.debug("state data " + processState.getData());
			JSONObject dataJsonObj = JSONFactoryUtil.createJSONObject(processState.getData());
			String modelName = dataJsonObj.getString("ModelName");
			if (modelName.equalsIgnoreCase(StringPool.BLANK)) {
				modelName = dataJsonObj.getString("formType");
			}
			dataJsonObj = convertStateData(modelName.toLowerCase(), dataJsonObj);
			String apiModelData = convertToAPIModel(processState.getUserId(), processState.getGroupId(),
					dataJsonObj.toString(), "{}");
			logger.debug("api model data is " + apiModelData);
			String subUrl = modelName.toLowerCase() + "/new";
			logger.debug("create data" + apiModelData);
			response = new APICall(processState.getUserId(), processState.getGroupId()).postForObject(apiModelData,
					subUrl);
			logger.debug("response" + response);
		} catch (NumberFormatException | PortalException | SystemException e) {
			logger.error(e);
		}
		return response;
	}

	private JSONObject convertStateData(String modelname, JSONObject data) {
		try {
			if (modelname.equalsIgnoreCase(CANDIDATE_MODEL)) {
				data.put("Country", data.getString("CountryofStay"));
				mapCurrentlyPursuing(data);
				mapAwards(data);
				mapQualifications(data);
				mapEmployments(data);
				mapAtoDetails(data);
			}
		} catch (Exception e) {
			logger.error(e);
		}
		return data;
	}

	private void mapAtoDetails(JSONObject data) {
		try {
			JSONObject atoDetails = JSONFactoryUtil.createJSONObject();
			String atoName = data.getString(ATO_NAME);
			if (atoName != null && !StringUtils.isEmpty(atoName)) {
				JSONObject atoObj = JSONFactoryUtil.createJSONObject(atoName);
				atoDetails.put(ATO_NAME, atoObj);
			} else {
				return;
			}
			String mentorId = data.getString("MentorId");
			if (!StringUtils.isEmpty(mentorId)
					&& (mentorId.equalsIgnoreCase("Other") || mentorId.equalsIgnoreCase("Others"))) {
				atoDetails.put(APPROVED_MENTORS,
						data.getString("MentorFirstName") + " " + data.getString("MentorLastName"));
				atoDetails.put("Salutation", data.getString("MentorSalutation"));
				atoDetails.put("FirstName", data.getString("MentorFirstName"));
				atoDetails.put("LastName", data.getString("MentorLastName"));
				atoDetails.put("EmailAddress", data.getString("MentorEmailAddress"));
			} else if (!StringUtils.isEmpty(mentorId)) {
				JSONObject mentorObj = JSONFactoryUtil.createJSONObject(mentorId);
				User mentor = UserLocalServiceUtil.fetchUser(mentorObj.getLong(USER_ID));
				atoDetails.put(APPROVED_MENTORS, mentorObj);
				atoDetails.put("FirstName", mentor.getFirstName());
				atoDetails.put("LastName", mentor.getLastName());
				atoDetails.put("EmailAddress", mentor.getEmailAddress());
			}

			atoDetails.put("CandidateJobTitle", data.getString("CandidateJobTitle"));
			String tpName = data.getString("TrainingPrincipal");
			if (tpName != null) {
				JSONObject tpObj = JSONFactoryUtil.createJSONObject(tpName);
				atoDetails.put("TrainingPrincipal",tpObj);
			}
			atoDetails.put("RoleDateFrom", data.getString("RoleDateFrom"));
			String trainingAgreement = data.getString("TrainingAgreement");
			if (trainingAgreement != null) {
				atoDetails.put("TrainingAgreement", JSONFactoryUtil.createJSONArray(trainingAgreement));
			}
			atoDetails.put("Existingmembercontact", "yes");
			data.put(ATO_DETAILS, atoDetails);
		} catch (Exception e) {
			logger.error(e);
		}
	}

	private void mapAwards(JSONObject data) {
		String undergraduate = data.getString("Undergraduate");
		try {
			String awards;
			if (undergraduate != null && undergraduate.equalsIgnoreCase("yes")) {
				awards = data.getString("AwardsGrid");
			} else {
				awards = data.getString("GraduateAwardsGrid");
			}
			if (awards == null) {
				awards = data.getString("GraduateAwardsGrid");
			}
			if (awards != null) {
				awards = awards.replaceAll("\"ANameofAward\"", "\"NameofAward\"");
				awards = awards.replaceAll("\"AYearofAward\"", "\"YearofAward\"");
				data.put("AwardsGrid", JSONFactoryUtil.createJSONArray(awards));
			}
		} catch (JSONException e) {
			logger.error(e);
		}
	}

	private void mapCurrentlyPursuing(JSONObject data) {
		String undergraduate = data.getString("Undergraduate");
		try {
			String cp;
			if (undergraduate != null && undergraduate.equalsIgnoreCase("yes")) {
				cp = data.getString("CurrentlyPursuing");
			} else {
				cp = data.getString("GraduateCurrentlyPursuing");
			}
			if (cp != null) {
				String tocString = "TypeofCourse";
				cp = cp.replaceAll("\"CountryofStudy\"", "\"CurrentlyPursuingCountry\"");
				cp = cp.replaceAll("\"CYCPCoursesofStudy\"", "\"CoursesofStudy\"");
				cp = cp.replaceAll("\"CYCPCountry\"", "\"CurrentlyPursuingCountry\"");
				cp = cp.replaceAll("\"CYCPTypeofCourse\"", "\"TypeofCourse\"");
				cp = cp.replaceAll("\"CYCPInstitution\"", "\"Institution\"");
				cp = cp.replaceAll("\"CYCPExpectedCompletionDate\"", "\"ExpectedCompletionDate\"");
				JSONArray cpArray = JSONFactoryUtil.createJSONArray(cp);
				for (int i = 0; i < cpArray.length(); i++) {
					JSONObject cpObj = cpArray.getJSONObject(i);
					if (cpObj.getJSONObject(tocString) != null) {
						cpObj.put(tocString, cpObj.getJSONObject(tocString).getString("name"));
					}
				}
				data.put("CurrentlyPursuing", cpArray);
			}
		} catch (Exception e) {
			logger.error(e);
		}
	}

	private void mapQualifications(JSONObject data) {
		String aq = data.getString("AcademicQualification");
		String pq = data.getString("ProfessionalQualification");
		if (aq != null) {
			aq = aq.replaceAll("panelEditGridModeofLearning", "ModeofLearning");
			aq = aq.replaceAll("AQCountry", "Country");
			aq = aq.replaceAll("ClassofDegreeDiploma", "ClassofDegreeorDiploma");
			aq = aq.replaceAll("ToDate", "QualificationToDate");
			aq = aq.replaceAll("FromDate", "QualificationFromDate");
			aq = aq.replaceAll("UploadDegreeCertificate", "DegreeCertificate");
			try {
				data.put("AcademicQualification", JSONFactoryUtil.createJSONArray(aq));
			} catch (JSONException e) {
				logger.error(e);
			}
		}
		if (pq != null) {
			pq = pq.replaceAll("PQStatus", "Status");
			pq = pq.replaceAll("\"ProfessionalQualification\"", "\"NameofProfQualification\"");
			pq = pq.replaceAll("PQMethodofLearning", "ProfessionalMethodofLearning");
			pq = pq.replaceAll("panelPanelColumnsProfessionalBody", "ProfessionalBody");
			pq = pq.replaceAll("PQAttainedOn", "Attainedon");
			pq = pq.replaceAll("CountryofProfessionalQualification", "ProfessionalCountry");
			pq = pq.replaceAll("panelPanelColumns2Others", "Others");
			try {
				data.put("ProfessionalQualification", JSONFactoryUtil.createJSONArray(pq));
			} catch (Exception e) {
				logger.error(e);
			}
		}
	}

	private void mapEmployments(JSONObject data) {
		String cea = data.getString("CurrentEmploymentAppointment");
		String ceis = data.getString("CurrentEmploymentIndustrySector");
		String cejc = data.getString("CurrentEmploymentJobCategory");
		String cel = data.getString("CurrentEmploymentLetter");
		String pe = data.getString("PastEmployments");
		String ceon = data.getString("CurrentEmploymentOrganizationName");
		if (ceon.equalsIgnoreCase("Others") || ceon.equalsIgnoreCase("Other")) {
			data.put("CurrentEmploymentOrganizationName", data.getString("CurrentEmploymentOtherOrganizationName"));
		}
		String peisString = "PastEmploymentIndustrySector";
		convertToJsonObject(data, "CurrentEmploymentAppointment", cea);
		convertToJsonObject(data, "CurrentEmploymentIndustrySector", ceis);
		convertToJsonObject(data, "CurrentEmploymentJobCategory", cejc);
		if (cel != null) {
			try {
				data.put("CurrentEmploymentLetter", JSONFactoryUtil.createJSONArray(cel));
			} catch (Exception e) {
				logger.error(e);
			}
		}
		if (pe != null) {
			try {
				pe = pe.replaceAll("ECountry", "PastEmploymentCountry");
				pe = pe.replaceAll("EEndDate", "PastEmploymentDateTo");
				pe = pe.replaceAll("UploadEmploymentcertificate", "PastEmploymentCertificate");
				pe = pe.replaceAll("EIndustrySector", peisString);
				pe = pe.replaceAll("EDesignation", "PastEmploymentDesignation");
				pe = pe.replaceAll("ECompanyOrganisation", "PastEmploymentOrganization");
				pe = pe.replaceAll("EStartingDate", "PastEmploymentDateFrom");
				JSONArray peArray = JSONFactoryUtil.createJSONArray(pe);
				for (int i = 0; i < peArray.length(); i++) {
					JSONObject peObj = peArray.getJSONObject(i);
					if (!peObj.isNull(peisString) && !StringUtils.isEmpty(peObj.getString(peisString))) {
						peObj.put(peisString, peObj.getJSONObject(peisString).getString("displayName"));
					}
				}
				data.put("PastEmployments", peArray);
			} catch (Exception e) {
				logger.error(e);
			}
		}
	}

	private void convertToJsonObject(JSONObject data, String key, String jsonString) {
		if (jsonString != null) {
			try {
				data.put(key, JSONFactoryUtil.createJSONObject(jsonString).getString("displayName"));
			} catch (Exception e) {
				logger.error(e);
			}
		}
	}

	@AccessControlled(guestAccessEnabled = true)
	public String getRecord(String storageId, String model, long userId, long siteId) {
		String response = StringPool.BLANK;
		try {
			String subUrl = model.toLowerCase() + "/get/" + storageId;
			response = new APICall(userId, siteId).exchange(subUrl, HttpMethod.GET);
		} catch (Exception e) {
			logger.error(e);
		}
		return response;
	}
	
	@AccessControlled(guestAccessEnabled = true)
	public JSONArray getActiveSchedules(long siteId, String category) {
		logger.error("category : "+category);
		logger.error("siteId : "+siteId);
		JSONArray response = JSONFactoryUtil.createJSONArray();
		String responseString = StringPool.BLANK;
		try {
			String subUrl = SCHEDULE_MODEL + "/get/active/"+category;
			responseString = new APICall(SambaashUtil.getAdminUserId(), siteId).exchange(subUrl, HttpMethod.GET);
			response = JSONFactoryUtil.createJSONArray(responseString);
			logger.error("response : "+response);
		} catch (Exception e) {
			logger.error(e);
		}
		return response;
	}
	
	@AccessControlled(guestAccessEnabled = true)
	public JSONArray getPrepareClaimSchedules(long siteId, String invigilatorId) {
		logger.error("invigilatorId : "+invigilatorId);
		logger.error("siteId : "+siteId);
		JSONArray response = JSONFactoryUtil.createJSONArray();
		String responseString = StringPool.BLANK;
		try {
			String subUrl = PREPARE_CLAIM_MODEL + "/invigilator/"+invigilatorId+"/schedules";
			responseString = new APICall(SambaashUtil.getAdminUserId(), siteId).exchange(subUrl, HttpMethod.GET);
			response = JSONFactoryUtil.createJSONArray(responseString);
			logger.error("response : "+response);
		} catch (Exception e) {
			logger.error(e);
		}
		return response;
	}

	@AccessControlled(guestAccessEnabled = true)
	public JSONArray getSchedulesForEnroledProgramme(long candidateId, long userId, long siteId) {

		JSONArray response = JSONFactoryUtil.createJSONArray();
		try {
			JSONObject programme = getProgrammeEnroled(candidateId, userId, siteId);
			if (Validator.isNotNull(programme)) {
				String queryByExampleJsonString = "{'ModelLeft':'Schedule','ModelRight':'Programme','StorageIdRight':'"
						+ programme.getString("ProgrammeCode") + "'}";
				String returnFieldList = "ModelLeftDetails.ScheduleCode,ModelLeftDetails.Name";
				response = getEntityLink(siteId, queryByExampleJsonString, returnFieldList, "ModelLeft", true);
			}

		} catch (Exception e) {
			logger.error(e);
		}
		return response;
	}

	@AccessControlled(guestAccessEnabled = true)
	public JSONObject getProgrammeEnroled(long candidateId, long userId, long siteId) {

		JSONObject response = JSONFactoryUtil.createJSONObject();
		try {
			String candidateRecordResponse = getRecord(String.valueOf(candidateId), CANDIDATE_MODEL, userId, siteId);
			if (Validator.isNotNull(candidateRecordResponse)) {
				JSONObject jsonObject = JSONFactoryUtil.createJSONObject(candidateRecordResponse);
				JSONObject jsonObjectContentJson = JSONFactoryUtil
						.createJSONObject(jsonObject.getString("contentJson"));
				response.put("ProgrammeCode", jsonObjectContentJson.getString("programmeCode"));
				response.put("ProgrammeTitle", jsonObjectContentJson.getString("ProgrammeTitle"));
			}

		} catch (Exception e) {
			logger.error(e);
		}
		return response;
	}
	
	@AccessControlled(guestAccessEnabled = true)
	public String getCandidateCurrentAto(long candidateId, long userId, long siteId) {
		String response = StringPool.BLANK;
		try {
			String subUrl = "/candidate/get/currentATO/" + candidateId;
			response = new APICall(userId, siteId).exchange(subUrl, HttpMethod.GET);
		} catch (Exception e) {
			logger.error(e);
		}
		return response;
	}

	@AccessControlled(guestAccessEnabled = true)
	public JSONArray getModules(long candidateId, long userId, long siteId) {

		JSONArray response = JSONFactoryUtil.createJSONArray();
		try {
			JSONObject programme = getProgrammeEnroled(candidateId, userId, siteId);
			if (Validator.isNotNull(programme)) {
				String queryByExampleJsonString = "{'ModelLeft':'Programme','ModelRight':'Subject','StorageIdLeft':'"
						+ programme.getString("ProgrammeCode") + "'}";
				String returnFieldList = "ModelRightDetails.SubjectCode,ModelRightDetails.SubjectTitle,ModelRightDetails.SubjectType,ModelLeftDetails.ProgrammeCode";
				response = getEntityLink(siteId, queryByExampleJsonString, returnFieldList, "ModelRight,ModelLeft",
						true);
			}
		} catch (Exception e) {
			logger.error(e);
		}
		return response;
	}

	@AccessControlled(guestAccessEnabled = true)
	public User createUser(String apiKey, String firstName, String lastName, String emailAdddress) {
		String decodedFirstName = decode(firstName);
		String decodedLastName = decode(lastName);
		String decodedEmailAddress = decode(emailAdddress);

		return addUserRecord(apiKey, decodedFirstName, decodedLastName, decodedEmailAddress, false);
	}

	@AccessControlled(guestAccessEnabled = true)
	public Role getRoleDetails(long companyId, String name) throws PortalException, SystemException {

		Role role = RoleLocalServiceUtil.getRole(companyId, name);

		return role;
	}

	@AccessControlled(guestAccessEnabled = true)
	public User addUserRecord(String apiKey, String firstName, String lastName, String emailAdddress,
			boolean sendPasswordEmail) {

		return addUserRecord(StringPool.BLANK, firstName, lastName, emailAdddress, sendPasswordEmail, StringPool.BLANK,
				0);

	}

	@AccessControlled(guestAccessEnabled = true)
	public User addUserRecord(String apiKey, String firstName, String lastName, String emailAdddress,
			boolean sendPasswordEmail, String userType, long virtualHostId) {

		try {

			apiKey = "cWqb6X63ut+SXix3RESxtIy1W412NbY/MLLZf3v4RA==";
			String password = PwdGenerator.getPassword();

			PermissionChecker orgPermissionChecker = PermissionThreadLocal.getPermissionChecker();

			PermissionUtil.initializeAdminPermissionChecker();

			ServiceContext serviceContext = new ServiceContext();
			serviceContext.setAttribute("userType", userType);
			serviceContext.setAttribute("virtualHostId", virtualHostId);

			User user = SocialProfileLocalServiceUtil.addUserPlatform(firstName, lastName, emailAdddress, password,
					false, serviceContext);

			PermissionThreadLocal.setPermissionChecker(orgPermissionChecker);

			logger.error(String.format("Created user with userId %s", user.getUserId()));

			return user;
		} catch (Exception e) {
			logger.error(e.getMessage());
		}

		return null;
	}

	@AccessControlled(guestAccessEnabled = true)
	public void assignRolesToUser(long userId, long[] roleIds) throws PortalException, SystemException {

		if (roleIds.length == 0) {
			return;
		}

		RoleMembershipPolicyUtil.checkRoles(new long[] { userId }, roleIds, null);

		RoleLocalServiceUtil.addUserRoles(userId, roleIds);

		RoleMembershipPolicyUtil.propagateRoles(new long[] { userId }, roleIds, null);
	}

	@AccessControlled(guestAccessEnabled = true)
	public void deleteRoleFromUser(long roleId, long userId) throws PortalException, SystemException {

		userLocalService.deleteRoleUser(roleId, userId);
	}

	@AccessControlled(guestAccessEnabled = true)
	public boolean checkIfUserHasRole(long userId, long companyId, String name, boolean inherited)
			throws PortalException, SystemException {

		return RoleLocalServiceUtil.hasUserRole(userId, companyId, name, inherited);
	}

	@AccessControlled(guestAccessEnabled = true)
	public void deleteUserRecord(long userId) throws PortalException, SystemException {

		userLocalService.deleteUser(userId);
	}

	@AccessControlled(guestAccessEnabled = true)
	public void removeTPandSCfromATO(long userId) throws PortalException, SystemException {

		OrganizationLocalServiceUtil.removeTPandSCfromATO(userId);
	}

	@AccessControlled(guestAccessEnabled = true)
	public JSONObject checkExemptionEligibility(String candidateId, long userId, long siteId)
			throws PortalException, SystemException {

		JSONObject json = JSONFactoryUtil.createJSONObject();
		json.put("eligibility", "yes");
		return json;
	}

	public JSONObject checkExemptionEligibility(long siteId, long candidateId, String applicationTranCode)
			throws PortalException {

		String apiUri = String.format("exemptionassessment/eligibility/%d", candidateId);
		boolean specificApplication = StringUtils.isNotEmpty(applicationTranCode);
		if (specificApplication) {
			apiUri += "/" + applicationTranCode;
		}
		
		String responseStr = new APICall(candidateId, siteId).exchange(apiUri, HttpMethod.GET);
		return JSONFactoryUtil.createJSONObject(responseStr);
	}
	
	public String addAdmissionRecord(String modeldata, long userId, long siteId, String model)
			throws PortalException, SystemException {
		try {
			String decodedModeldata = HttpUtil.decodeURL(modeldata);
			JSONObject json = JSONFactoryUtil.createJSONObject(decodedModeldata);
			logger.error("addAdmissionRecord " + json.toString() + " : userId : " + userId + " : siteId : " + siteId
					+ " : model : " + model);
		} catch (Exception e) {
			logger.error(e);
		}
		return StringPool.BLANK;
	}

	public String addExemptionRecord(String modeldata, long userId, long siteId, String model)
			throws PortalException, SystemException {
		try {
			String decodedModeldata = HttpUtil.decodeURL(modeldata);
			JSONObject json = JSONFactoryUtil.createJSONObject(decodedModeldata);
			logger.error("addExemptionRecord " + json.toString() + " : userId : " + userId + " : siteId : " + siteId
					+ " : model : " + model);
		} catch (Exception e) {
			logger.error(e);
		}
		return StringPool.BLANK;
	}

	@AccessControlled(guestAccessEnabled = true)
	public String createEnrolmentRecord(String modeldata, long userId, long siteId, String model) {

		String response = StringPool.BLANK;
		try {
			String decodedModeldata = HttpUtil.decodeURL(modeldata);
			JSONObject json = JSONFactoryUtil.createJSONObject(decodedModeldata);

			JSONArray jsonArrayEnrolment = JSONFactoryUtil.createJSONArray(json.getString("enrolmentDetails"));

			for (int i = 0; i < jsonArrayEnrolment.length(); i++) {
				JSONObject jsonObj = jsonArrayEnrolment.getJSONObject(i);

				JSONArray modulesArr = JSONFactoryUtil.createJSONArray(jsonObj.getString("modules"));

				json.put("subjects", modulesArr);

				JSONObject progSemester = JSONFactoryUtil.createJSONObject(jsonObj.getString("semester"));

				progSemester.put("ProgrammeCode", json.getString("ProgrammeCode"));
				progSemester.put("ProgrammeTitle", json.getString("ProgrammeTitle"));
				json.put("programSemester", progSemester);

				json.put("ScheduleCode", progSemester.getString("ScheduleCode"));

				json.put("CandidateId", json.getString("userIdProcess"));

				String apiModelData = convertToAPIModel(userId, siteId, json.toString(), "{}");

				String subUrl = model.toLowerCase() + "/new";
				response = new APICall(userId, siteId).postForObject(apiModelData, subUrl);

			}

		} catch (Exception e) {
			logger.error(e);
		}
		return response;
	}

	private JSONObject populateReturnFields(JSONObject record, String[] fields) {
		JSONObject js;
		js = JSONFactoryUtil.createJSONObject();
		// has selective fields
		for (int j = 0; j < fields.length; j++) {
			String returnField = fields[j];
			JSONObject contentJson = record.getJSONObject(CONTENT_JSON);
			if (contentJson.has(returnField)) {
				js.put(returnField, contentJson.getString(returnField));
			} else if (record.has(returnField)) {
				js.put(returnField, record.getString(returnField));
			}
		}
		return js;
	}

	@AccessControlled(guestAccessEnabled = true)
	public JSONArray getEntityLink(long groupId, String queryByExampleJsonString, String returnFieldList,
			String retrieveModelDetails, Boolean flatten)
			throws JSONException, SystemException, org.json.JSONException {
		JSONObject qbe = JSONFactoryUtil.createJSONObject();
		JSONObject qbeParam = JSONFactoryUtil.createJSONObject(queryByExampleJsonString);
		Iterator<String> it = qbeParam.keys();
		while (it.hasNext()) {
			String queryField = it.next();
			String queryFieldValue = qbeParam.getString(queryField);
			switch (queryField) {
			case "ModelLeft":
			case "ModelRight":
			case "ModelLeft1":
			case "ModelRight1":
				qbe.put(String.format("contentJson.%s", queryField), queryFieldValue);
				break;

			case "StorageIdLeft":
			case "StorageIdRight":
			case "StorageIdLeft1":
			case "StorageIdRight1":
				qbe.put(String.format("contentJson.%s", queryField), queryFieldValue);
				break;
			default:
				qbe.put(queryField, queryFieldValue);
				break;
			}
		}
		JSONArray sortArray = JSONFactoryUtil.createJSONArray();
		JSONArray searchHits = getModelList("entitylink", StringPool.BLANK, groupId, qbe.toString(),
				sortArray.toString());

		if (StringUtils.isNotEmpty(retrieveModelDetails)) {
			List<String> retrieveList = Arrays.asList(retrieveModelDetails.split(","));
			boolean retrieveLeftModelDetails = retrieveList.contains("ModelLeft");
			boolean retrieveRightModelDetails = retrieveList.contains("ModelRight");
			boolean retrieveRightModel1Details = retrieveList.contains("ModelRight1");

			HashMap<String, JSONObject> leftModelDetailMap = new HashMap<>();
			HashMap<String, JSONObject> rightModelDetailMap = new HashMap<>();
			HashMap<String, JSONObject> rightModel1DetailMap = new HashMap<>();
			if (retrieveLeftModelDetails) {
				mapLinkedModelDescription(leftModelDetailMap, groupId, qbeParam.getString("ModelLeft"));
			}
			if (retrieveRightModelDetails) {
				mapLinkedModelDescription(rightModelDetailMap, groupId, qbeParam.getString("ModelRight"));
			}
			if (retrieveRightModel1Details) {
				mapLinkedModelDescription(rightModel1DetailMap, groupId, qbeParam.getString("ModelRight1"));
			}

			searchHits = extractModelDetailsAsNeeded(searchHits, retrieveLeftModelDetails, retrieveRightModelDetails,
					retrieveRightModel1Details, leftModelDetailMap, rightModelDetailMap, rightModel1DetailMap);
		}

		if (StringUtils.isNotEmpty(returnFieldList)) {
			JSONArray selectiveResult = JSONFactoryUtil.createJSONArray();
			for (int i = 0; i < searchHits.length(); i++) {
				JSONObject record = searchHits.getJSONObject(i);
				JSONObject selectiveRecord = JSONFactoryUtil.createJSONObject();
				retrieveJsonField(returnFieldList, record, selectiveRecord);
				selectiveResult.put(selectiveRecord);
			}
			return flattenWhenApplicable(flatten, selectiveResult);
		}
		return flattenWhenApplicable(flatten, searchHits);
	}

	private JSONArray extractModelDetailsAsNeeded(JSONArray searchHits, Boolean retrieveLeftModelDetails,
			Boolean retrieveRightModelDetails, Boolean retrieveRightModel1Details,
			HashMap<String, JSONObject> leftModelDetailMap, HashMap<String, JSONObject> rightModelDetailMap,
			HashMap<String, JSONObject> rightModel1DetailMap) {
		if (retrieveLeftModelDetails || retrieveRightModelDetails || retrieveRightModel1Details) {
			JSONArray modifiedResult = JSONFactoryUtil.createJSONArray();
			for (int i = 0; i < searchHits.length(); i++) {
				boolean insertRecord = true;
				JSONObject row = searchHits.getJSONObject(i);
				if (retrieveLeftModelDetails) {
					if (leftModelDetailMap.isEmpty()) {
						insertRecord = false;
						continue;
					}
					row.put("ModelLeftDetails", leftModelDetailMap.get(row.getString("StorageIdLeft")));
				}
				if (retrieveRightModelDetails) {
					row.put("ModelRightDetails", rightModelDetailMap.get(row.getString("StorageIdRight")));
					if (rightModelDetailMap.isEmpty()) {
						insertRecord = false;
						continue;
					}
				}
				if (retrieveRightModel1Details) {
					row.put("ModelRight1Details", rightModel1DetailMap.get(row.getString("StorageIdRight1")));
					if (rightModel1DetailMap.isEmpty()) {
						insertRecord = false;
						continue;
					}
				}
				if (insertRecord) {
					modifiedResult.put(row);
				}
			}
			searchHits = modifiedResult;
		}
		return searchHits;
	}

	private JSONArray flattenWhenApplicable(Boolean flatten, JSONArray searchHits) {
		if (flatten) {
			JSONArray flattenedHits = JSONFactoryUtil.createJSONArray();
			for (int i = 0; i < searchHits.length(); i++) {
				JSONObject flattened = JSONFactoryUtil.createJSONObject();
				flatten(searchHits.getJSONObject(i), flattened);
				flattenedHits.put(flattened);
			}
			return flattenedHits;
		} else {
			return searchHits;
		}
	}

	private void retrieveJsonField(String fieldNamePath, JSONObject source, JSONObject target) {
		logger.error(source.toString());
		for (String selectiveField : fieldNamePath.split(",")) {
			try {
				JSONObject currentSource = source;
				JSONObject currentTarget = target;
				String[] fieldPath = selectiveField.split("\\.");
				for (int x = 0; x < fieldPath.length; x++) {
					String path = fieldPath[x];
					if (fieldPath.length > 1 && x < fieldPath.length - 1) {
						currentSource = currentSource.getJSONObject(path);
						if (!currentTarget.has(path)) {
							currentTarget.put(path, JSONFactoryUtil.createJSONObject());
						}
						currentTarget = currentTarget.getJSONObject(path);
					} else {
						currentTarget.put(path, currentSource.getString(path));
					}
				}
			} catch (Exception e) {
				// NOOP ignore non-existing field
				logger.error("Return Field List not found -> " + selectiveField);
			}
		}
	}

	private void flatten(JSONObject source, JSONObject dest) {
		Iterator<String> it = source.keys();
		while (it.hasNext()) {
			String fieldName = it.next();
			try {
				JSONObject childObject = source.getJSONObject(fieldName);
				// recursively flatten
				flatten(childObject, dest);
			} catch (Exception e) {
				// not object, add to dest
				try {
					dest.put(fieldName, source.getString(fieldName));
				} catch (Exception e2) {
					// NOOP
				}
			}
		}
	}

	private void mapLinkedModelDescription(HashMap<String, JSONObject> linkedModelDescMap, long groupId,
			String linkedModel) throws JSONException, SystemException, org.json.JSONException {
		// TODO: should be replaced by an "IN" elasticsearch query instead
		// DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		// Date date = new Date();

		JSONArray conditions = JSONFactoryUtil.createJSONArray();
		if (linkedModel.equalsIgnoreCase("schedule")) {
			JSONObject condition = JSONFactoryUtil.createJSONObject();
			// condition.put("operator", "gte");
			// condition.put("column", "contentJson.StartDate");
			// condition.put("value", "now/d");
			// conditions.put(condition);
			// condition = JSONFactoryUtil.createJSONObject();
			condition.put("operator", "equal");
			condition.put("column", "contentJson.Status.keyword");
			condition.put("value", "Active");
			conditions.put(condition);

		}
		JSONObject condition = JSONFactoryUtil.createJSONObject();
		condition.put("operator", "equal");
		condition.put("column", "contentJson.Status.keyword");
		condition.put("value", "Active");
		conditions.put(condition);

		JSONObject filter = JSONFactoryUtil.createJSONObject();
		filter.put("newFilter", conditions);
		JSONArray sortArray = JSONFactoryUtil.createJSONArray();
		JSONArray leftModelData = getModelList(linkedModel.toLowerCase(), StringPool.BLANK, groupId, filter.toString(),
				sortArray.toString());
		for (int i = 0; i < leftModelData.length(); i++) {
			JSONObject row = leftModelData.getJSONObject(i);
			linkedModelDescMap.put(row.getString(STORAGE_ID), row);
		}
	}

	public String decode(String url) {
		try {
			String prevURL = StringPool.BLANK;
			String decodeURL = url;
			while (!prevURL.equals(decodeURL)) {
				prevURL = decodeURL;
				decodeURL = URLDecoder.decode(decodeURL, "UTF-8");
			}
			return decodeURL;
		} catch (UnsupportedEncodingException e) {
			return "Issue while decoding" + e.getMessage();
		}
	}

	@AccessControlled(guestAccessEnabled = true)
	public JSONObject createUser(String inputJson) {
		JSONObject json;
		User user = null;
		JSONObject response = JSONFactoryUtil.createJSONObject();
		try {
			json = JSONFactoryUtil.createJSONObject(decode(inputJson));
			String emailAddress = json.getString("email").replaceAll(" ", "+");
			long companyId = CompanyThreadLocal.getCompanyId();
			try {
				user = UserLocalServiceUtil.getUserByEmailAddress(companyId, emailAddress);
			} catch (NoSuchUserException e) {
				user = null;
			}
			if (user == null) {
				Date date = new Date();
				ServiceContext serviceContext = new ServiceContext();
				serviceContext.setUuid(UUID.randomUUID().toString());
				serviceContext.setCreateDate(date);

				long creatorUserId = 0;
				boolean autoPassword = true;
				boolean autoScreenName = true;
				boolean male = true;
				boolean sendEmail = json.has("sendEmail") ? json.getBoolean("sendEmail") : true;
				boolean markAsVerified = json.has("markAsVerified") ? json.getBoolean("markAsVerified") : false;
				boolean resetPassword = json.has("resetPassword") ? json.getBoolean("resetPassword") : false;
				
				int prefixId = 1;
				int suffixId = 1;
				int birthdayMonth = 1;
				int birthdayDay = 1;
				int birthdayYear = 1970;
				String screenName = StringPool.BLANK;
				String jobTitle = StringPool.BLANK;
				long[] groupIds = null;
				long[] organizationIds = null;
				long[] userGroupIds = null;

				String password1 = PwdGenerator.getPassword();
				String password2 = password1;
				String firstName = json.getString("name");
				String lastName = json.getString("name");

				long facebookId = 0;
				String openId = StringPool.BLANK;
				Locale locale = LocaleUtil.getDefault();

				user = UserLocalServiceUtil.addUserWithWorkflow(creatorUserId, companyId, autoPassword, password1,
						password2, autoScreenName, screenName, emailAddress, facebookId, openId, locale, firstName,
						StringPool.BLANK, lastName, prefixId, suffixId, male, birthdayMonth, birthdayDay, birthdayYear,
						jobTitle, groupIds, organizationIds, null, userGroupIds, sendEmail, serviceContext);
				if(markAsVerified || resetPassword) {
					user.setEmailAddressVerified(markAsVerified);
					user.setPasswordReset(resetPassword);
					UserLocalServiceUtil.updateUser(user);
				}
			}

		} catch (Exception e1) {
			logger.error(e1.toString());
			response.put("userId", 0);
		}
		response.put("userId", user.getUserId());
		return response;
	}

	RestTemplate restTemplate = new RestTemplate();

	public class APICall {
		long userId = 0;
		long siteId = 0;
		ResourceRequest req;
		HttpHeaders headers;
		HttpEntity<String> httprequest;
		String baseUrl = StringPool.BLANK;

		public APICall(ResourceRequest request) {
			try {
				this.req = request;
				userId = PortalUtil.getUserId(request);
				siteId = PortalUtil.getScopeGroupId(request);
				headers = new HttpHeaders();
				headers.add("X-SCOPEGROUP-ID", StringPool.BLANK + SambaashUtil.getScopeGroupId(siteId));
				headers.add("X-USER-ID", StringPool.BLANK + userId);

				baseUrl = SambaashUtil.getParameter(SambaashConstants.API_STORAGE_ENGINE_BASEURL,
						SambaashConstants.DEFAULT_GROUP_ID_LONG);

			} catch (PortalException | SystemException e1) {
				logger.error(e1);
			}

		}

		public APICall(long userId, long siteId) {
			headers = new HttpHeaders();
			headers.add("X-SCOPEGROUP-ID", StringPool.BLANK + SambaashUtil.getScopeGroupId(siteId));
			headers.add("X-USER-ID", StringPool.BLANK + userId);
			baseUrl = SambaashUtil.getParameter(SambaashConstants.API_STORAGE_ENGINE_BASEURL,
					SambaashConstants.DEFAULT_GROUP_ID_LONG);

		}

		private String exchange(String subUrl, HttpMethod method) {
			String response = StringPool.BLANK;
			httprequest = new HttpEntity<>(headers);
			try {
				URI uri = URI.create(baseUrl + subUrl);
				ResponseEntity<String> httpresponse = restTemplate.exchange(uri, method, httprequest, String.class);
				logger.debug(requestURL + baseUrl + subUrl);
				response = httpresponse.getBody();
				logger.debug(response);

			} catch (Exception e) {
				logger.error(requestURL + baseUrl + subUrl);
				logger.error(e);
			}

			return response;
		}

		private String postForObject(String data, String subUrl) {
			String response = "0";
			try {
				headers.setContentType(MediaType.APPLICATION_JSON);
				httprequest = new HttpEntity<>(data, headers);
				response = restTemplate.postForObject(baseUrl + subUrl, httprequest, String.class);
				logger.debug(baseUrl + subUrl);
				logger.debug(data);
				return response;

			} catch (Exception e) {
				logger.error(requestURL + baseUrl + subUrl);
				logger.error(e);
				return response;
			}
		}
		
		private String putForObject(String data, String subUrl) {
			String response = "0";
			try {
				headers.setContentType(MediaType.APPLICATION_JSON);
				HttpMethod method = HttpMethod.PUT;
				httprequest = new HttpEntity<>(data, headers);
				URI uri = URI.create(baseUrl + subUrl);
				ResponseEntity<String> httpresponse = restTemplate.exchange(uri, method, httprequest, String.class);
				response = httpresponse.getBody();
				logger.debug(baseUrl + subUrl);
				logger.debug(data);
				return response;
			} catch (Exception e) {
				logger.error(requestURL + baseUrl + subUrl);
				logger.error(e);
				return response;
			}
		}
	}

	protected String convertToAPIModel(long userId, long siteId, String modelData, String existingData)
			throws JSONException {
		JSONObject jsonModelData = JSONFactoryUtil.createJSONObject(modelData);
		JSONObject jsonModelExistingData = JSONFactoryUtil.createJSONObject(existingData);

		return FormIOToModelJSON(userId, siteId, jsonModelData, jsonModelExistingData).toString();

	}

	protected JSONObject FormIOToModelJSON(long userId, long siteId, JSONObject inp, JSONObject jsonModelExistingData) {
		try {
			String modelName = inp.getString("ModelName");
			if (modelName.equalsIgnoreCase(StringPool.BLANK)) {
				modelName = inp.getString("formType");
			}
			List<String> columns = getMicroserviceModelColumnList(userId, siteId, modelName);

			if (columns.size() <= 1)
				return noOpFormIOToModelJSON(inp);
			if (jsonModelExistingData.toString().equals("{}")) {

				JSONObject contentJson = JSONFactoryUtil.createJSONObject();
				contentJson.put("Status", "Active");
				jsonModelExistingData.put(CONTENT_JSON, contentJson);
			}
			org.json.JSONObject in = new org.json.JSONObject(inp.toString());
			for (int i = 0; i < in.names().length(); i++) {
				if (columns.contains(in.names().getString(i))) {

					jsonModelExistingData.getJSONObject(CONTENT_JSON).put(in.names().getString(i),
							in.getString(in.names().getString(i)));

					Object json = in.get(in.names().getString(i));
					if (json instanceof org.json.JSONArray) {
						jsonModelExistingData.getJSONObject(CONTENT_JSON).put(in.names().getString(i),
								inp.getJSONArray(in.names().getString(i)));
					} else {
						jsonModelExistingData.getJSONObject(CONTENT_JSON).put(in.names().getString(i),
								in.getString(in.names().getString(i)));
					}
				}
			}
		} catch (Exception e) {
			logger.error(e.toString());
		}

		return jsonModelExistingData;

	}

	protected JSONObject noOpFormIOToModelJSON(JSONObject in) {
		JSONObject apiJsonModelData = JSONFactoryUtil.createJSONObject();
		apiJsonModelData.put(CONTENT_JSON, in.toString());
		return apiJsonModelData;
	}

	protected List<String> getMicroserviceModelColumnList(long userId, long siteId, String modelName) {
		String response = null;
		String[] tempArray = null;
		try {
			String subUrl = modelName.toLowerCase() + "/getColumns";
			response = new APICall(userId, siteId).exchange(subUrl, HttpMethod.GET);
			tempArray = response.split(",");

		} catch (Exception e) {
			logger.error(e);
		}
		return (Arrays.asList(tempArray));

	}

	/**
	 * @param actionLink a String type. Upon action will lead to this link.
     * @param actionLabel a String type. Label to be displayed on Timeline.
     * @param title a String type. Title to be displayed on Timeline Activity.
     * @param description a String type. Description to be displayed on Timeline Activity. Not used currently. 
     * @param imagePath a String type. Image to be displayed on Timeline Activity. Not used currently.
     * @param status a String type. Status to be displayed on Timeline Activity.
     * @param createdByUserId a long type. Person who is creating this Activity..
     * @param activityType a String type. ActivityType to be displayed on Timeline Activity.
     * @param category a String type. Category to be displayed on Timeline Activity.
     * @param subProductId a String type. Should be fetched from SPSiteSetup subProductId.
     * @param content a String type. Not used currently. Can be set blank.
     * @param assignedTo a String type. Person whom this activity should be assigned to and can see it on his/her Timeline.
     * @param groupId a long type. 
	 */
	public void addTimelineActivity(String actionLink, String actionLabel, String title, String description,
			String imagePath, String status, long createdByUserId, String activityType, String category,
			String subProductId, String content, String assignedTo, long groupId) {

		SystemLocalServiceUtil.addTimelineActivity(actionLink, actionLabel, title, description, imagePath, status,
				createdByUserId, activityType, category, subProductId, content, assignedTo, groupId);
	}
	
	public boolean updateUser(String emailAddress) {
		if (Validator.isNotNull(emailAddress)) {
			try {
				User user = UserLocalServiceUtil.getUserByEmailAddress(PortalUtil.getDefaultCompanyId(), emailAddress);
				user.setEmailAddressVerified(true);
				user.setModifiedDate(DateUtil.newDate());
				UserLocalServiceUtil.updateUser(user);
				return true;
			} catch (PortalException | SystemException e) {
				logger.error(e.getMessage());
			}

		}
		return false;
	}

}
