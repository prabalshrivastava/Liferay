package com.sambaash.platform.spchallenge.helper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;
import javax.servlet.jsp.JspWriter;

import org.apache.commons.lang.ArrayUtils;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.User;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.service.UserNotificationEventLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil;
import com.sambaash.platform.model.ProfileType;
import com.sambaash.platform.spchallenge.notification.SPChallengeNotificationConstants;
import com.sambaash.platform.srv.spchallenge.model.SPChallenge;
import com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant;
import com.sambaash.platform.srv.spchallenge.model.impl.SPChallengeApplicantImpl;
import com.sambaash.platform.srv.spchallenge.model.impl.SPChallengeImpl;
import com.sambaash.platform.srv.spchallenge.service.SPChallengeApplicantLocalServiceUtil;
import com.sambaash.platform.srv.spchallenge.service.SPChallengeLocalServiceUtil;
import com.sambaash.platform.srv.startupprofile.model.Organization;
import com.sambaash.platform.util.FormHelper;

public class ChallengeFormHelper extends FormHelper {

	private static final Log logger = LogFactoryUtil
			.getLog(ChallengeFormHelper.class);

	private static final Map<String, String> register = new HashMap<String, String>();

	static {
		register.put(SPChallengeConstants.ATTRIB_CHALLENGE_APPLICANT,
				SPChallengeApplicantImpl.class.getName());
		register.put(SPChallengeConstants.ATTRIB_CHALLENGE,
				SPChallengeImpl.class.getName());
	}

	public ChallengeFormHelper() {
		super(register, ChallengeFormHelper.class.getClassLoader());
	}

	public SPChallenge saveChallengeFormData(PortletRequest request) {
		Long spChallengeId = ParamUtil.getLong(request,
				SPChallengeConstants.CHALLENGE_ID);
		ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);
		Map<String, Object> existingMap = this
				.createExistingChallengeMap(spChallengeId);
		SPChallenge challenge = null;
		try {
			boolean isPrevDraft = true;
			if (existingMap != null
					&& existingMap.containsKey(SPChallengeConstants.ATTRIB_CHALLENGE)) {
				challenge = (SPChallenge) existingMap
						.get(SPChallengeConstants.ATTRIB_CHALLENGE);
				isPrevDraft = challenge.isDraft();
			}
			existingMap = parsedRequestData(
					FormHelper.getRequestParamMap(request, themeDisplay),
					existingMap, StringPool.BLANK);
			logger.debug("parsed & merged request => " + existingMap);
			challenge = (SPChallenge) existingMap
					.get(SPChallengeConstants.ATTRIB_CHALLENGE);
			if (Validator.isNull(challenge))
				return null;
			boolean reindexApplicants = false;
			boolean sendNotification = false;
			if(challenge.isNew()) {
				challenge.setSpChallengeId(CounterLocalServiceUtil.increment("SPChallenge"));
				if (!challenge.isDraft())
					sendNotification = true;
			} else {
				reindexApplicants = true;
				if (isPrevDraft && !challenge.isDraft())
					sendNotification = true;
			}
			if (challenge.isDraft()) {
				if(challenge.getStartDate()==null)
				challenge.setStartDate(Calendar.getInstance().getTime());
				if(challenge.getEndDate() == null) {
					Calendar today = Calendar.getInstance();
					today.add(Calendar.YEAR, 1);
					challenge.setEndDate(today.getTime());
				}
			}
			challenge = SPChallengeLocalServiceUtil.updateSPChallenge(challenge);
			if (reindexApplicants) {
				try {
					List<SPChallengeApplicant> list = SPChallengeApplicantLocalServiceUtil.findBySPChallengeId(challenge.getSpChallengeId());
					for (SPChallengeApplicant applicant : list) {
						reIndex(applicant);
					}
				} catch (Exception e) {
					logger.error("Error while reindexing applicants", e);
				}
			}
			
			addRoleToScouts(request, challenge);

			Set<Entry<String, Object>> entrySet = existingMap.entrySet();
			List<Long> entries = new ArrayList<Long>();
			for (Entry<String, Object> entry : entrySet) {
				try {
					if (entry.getKey().startsWith("asset_")) {
						entries.add(Long.valueOf((String) entry.getValue()));
					}
				} catch (Exception e) {
					// ignore..coz drop down might now be mandatory
				}
			}
			if (challenge!=null && challenge.getBrand()>0) {
				entries.add(challenge.getBrand());
			}
			if (entries.size() > 0) {
				logger.debug("asset categories being saved = " + entries);
				long[] assetEntries = ArrayUtils.toPrimitive(entries
						.toArray(new Long[entries.size()]));
				SPChallengeLocalServiceUtil.updateAssets(
						themeDisplay.getUserId(), challenge, assetEntries);
				reIndex(challenge);
			}

			if (sendNotification) {
				sendCreateChallengeNotification(request, challenge,
						themeDisplay);
			}
		} catch (Exception e) {
			logger.error("Error occured saving data ", e);
		}

		return challenge;
	}

	private void addRoleToScouts(PortletRequest request, SPChallenge challenge) {
		String scoutEmailIds = challenge.getScout();
		if (Validator.isNull(scoutEmailIds)) {
			return;
		}

		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) request
					.getAttribute(WebKeys.THEME_DISPLAY);
			String[] mailIds = scoutEmailIds.split(";");
			for (String mailId : mailIds) {
				User user = UserLocalServiceUtil.getUserByEmailAddress(
						themeDisplay.getCompanyId(), mailId);
				Role role = RoleLocalServiceUtil.getRole(
						themeDisplay.getCompanyId(),
						SPChallengeConstants.SCOUT_ROLE_NAME);
				RoleLocalServiceUtil.addUserRole(user.getUserId(), role);
			}
		} catch (Exception e) {
			logger.error("Adding while adding scout role to user", e);
		}
	}

	private void sendCreateChallengeNotification(PortletRequest request,
			SPChallenge challenge, ThemeDisplay themeDisplay) throws Exception {
		JSONObject payloadJSON = JSONFactoryUtil.createJSONObject();
		payloadJSON.put(Field.USER_ID, themeDisplay.getUserId());
		payloadJSON.put("challengeId", challenge.getSpChallengeId());
		payloadJSON.put(SPChallengeNotificationConstants.USER_NAME, themeDisplay.getUser().getFullName());
		payloadJSON.put(SPChallengeNotificationConstants.TITLE, challenge.getName());
		payloadJSON
				.put(SPChallengeNotificationConstants.NOTIFICATION_TYPE,
						SPChallengeNotificationConstants.NOTIFICATION_TYPE_CHALLENGE_CREATE);
		payloadJSON.put(
				SPChallengeNotificationConstants.LINK,
				SPChallengeHelper.displayChallengeFriendlyURL(themeDisplay,
						challenge.getSpChallengeId(),StringPool.DASH));
		ServiceContext serviceContext = ServiceContextFactory
				.getInstance(request);
		Role role = RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(),
				ProfileType.STARTUP.getValue());
		long[] roleUserIds = UserLocalServiceUtil.getRoleUserIds(role.getRoleId());
		for (int i = 0; i < roleUserIds.length; i++) {
			UserNotificationEventLocalServiceUtil.addUserNotificationEvent(
					roleUserIds[i],
					SPChallengeConstants.PORTLET_ID,
					(new Date()).getTime(), themeDisplay.getUserId(),
					payloadJSON.toString(), false, serviceContext);
		}
	}

	public SPChallengeApplicant saveChallengeApplicationFormData(
			PortletRequest request) {
		Long spChallengeApplicantId = ParamUtil.getLong(request,
				SPChallengeConstants.CHALLENGE_APPLICANT_ID);
		ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);
		Map<String, Object> existingMap = this
				.createExistingChallengeApplicantMap(spChallengeApplicantId);
		SPChallengeApplicant applicant = null;
		try {
			existingMap = this.parsedRequestData(
					FormHelper.getRequestParamMap(request, themeDisplay),
					existingMap, StringPool.BLANK);
			applicant = (SPChallengeApplicant) existingMap
					.get(SPChallengeConstants.ATTRIB_CHALLENGE_APPLICANT);
			if (applicant.isNew()) {
				applicant.setSpChallengeApplicantId(CounterLocalServiceUtil
						.increment("SPChallengeApplicant"));
				applicant.setApplicantRefId(ParamUtil.getLong(request,
						SPChallengeConstants.ORGANIZATION_ID));
				applicant.setSpChallengeId(ParamUtil.getLong(request,
						SPChallengeConstants.CHALLENGE_ID));
			}
			applicant = SPChallengeApplicantLocalServiceUtil
					.updateSPChallengeApplicant(applicant);
			Set<Entry<String, Object>> entrySet = existingMap.entrySet();
			List<Long> entries = new ArrayList<Long>();
			for (Entry<String, Object> entry : entrySet) {
				try {
					if (entry.getKey().startsWith("asset_")) {
						entries.add(GetterUtil.getLong((String) entry
								.getValue()));
					}
				} catch (Exception e) {
				}
			}
			if (entries.size() > 0) {
				long[] assetEntries = ArrayUtils.toPrimitive(entries
						.toArray(new Long[entries.size()]));
				SPChallengeApplicantLocalServiceUtil.updateAssets(
						themeDisplay.getUserId(), applicant, assetEntries);
			}
			// Save categories
			reIndex(applicant);
		} catch (Exception e) {
			logger.error("Error occured saving application data ", e);
		}

		return applicant;
	}

	public void addChallengeDataToRequest(PortletRequest actionRequest,
			long challengeId) throws Exception {
		Map<String, Object> existingMap = this
				.createExistingChallengeMap(challengeId);

		Set<Entry<String, Object>> entrySet = existingMap.entrySet();
		for (Entry<String, Object> entry : entrySet) {
			actionRequest.setAttribute(entry.getKey(), HtmlUtil
					.stripHtml(JSONFactoryUtil.looseSerializeDeep(entry
							.getValue())));
		}
	}

	private Map<String, Object> createExistingChallengeMap(long spChallengeId) {
		Map<String, Object> existingMap = null;
		if (spChallengeId > 0) {
			try {
				SPChallenge challenge = SPChallengeLocalServiceUtil
						.getSPChallenge(spChallengeId);
				existingMap = new HashMap<String, Object>();
				existingMap.put(SPChallengeConstants.ATTRIB_CHALLENGE,
						challenge);
			} catch (Exception e) {
				logger.error("Error occured creating challenge", e);
			}
		}
		return existingMap;
	}

	private Map<String, Object> createExistingChallengeApplicantMap(
			long applicantId) {
		Map<String, Object> existingMap = null;
		if (applicantId > 0) {
			try {
				SPChallengeApplicant challengeApplicant = SPChallengeApplicantLocalServiceUtil
						.getSPChallengeApplicant(applicantId);
				existingMap = new HashMap<String, Object>();
				existingMap.put(
						SPChallengeConstants.ATTRIB_CHALLENGE_APPLICANT,
						challengeApplicant);
			} catch (Exception e) {
				logger.error("Error occured creating challenge application", e);
			}
		}
		return existingMap;
	}

	public static void fillCategoriesChallenge(PortletRequest actionRequest,
			String challengeId) {
		try {
			PortletPreferences preferences = actionRequest.getPreferences();
			String applicantTypeVocId = preferences.getValue(
					SPChallengeConstants.VOC_APPLICANT_TYPE_ID, "0");
			String challengeCategoryId = preferences.getValue(
					SPChallengeConstants.VOC_CHALLENGE_CATEGORY_ID, "0");
			String challengeTypeId = preferences.getValue(
					SPChallengeConstants.VOC_CHALLENGE_TYPE_ID, "0");
			String regionId = preferences.getValue(
					SPChallengeConstants.VOC_REGION_TYPE_ID, "0");

			String collabTypeId = preferences.getValue(
					SPChallengeConstants.VOC_CHALLENGE_COLLAB_TYPE_ID, "0");
			String brandVocId=preferences.getValue(
					SPChallengeConstants.VOC_BRAND_ID,"0");

			List<AssetCategory> applicantTypeList = AssetCategoryLocalServiceUtil
					.getVocabularyCategories(Long.valueOf(applicantTypeVocId),
							-1, -1, null);
			List<AssetCategory> challengeCategoryList = AssetCategoryLocalServiceUtil
					.getVocabularyCategories(Long.valueOf(challengeCategoryId),
							-1, -1, null);
			List<AssetCategory> challengeTypeList = AssetCategoryLocalServiceUtil
					.getVocabularyCategories(Long.valueOf(challengeTypeId), -1,
							-1, null);
			List<AssetCategory> regionList = AssetCategoryLocalServiceUtil
					.getVocabularyCategories(Long.valueOf(regionId), -1, -1,
							null);
			List<AssetCategory> collabTypeList = AssetCategoryLocalServiceUtil
					.getVocabularyCategories(Long.valueOf(collabTypeId), -1,
							-1, null);
			List<AssetCategory> orgBrandList = AssetCategoryLocalServiceUtil
					.getVocabularyCategories(Long.valueOf(brandVocId),
							-1, -1, null);

			JSONObject json = JSONFactoryUtil.createJSONObject();
			for (AssetCategory assetCategory : collabTypeList) {
				String key = SPChallengeConstants.COLLAB_TYPE_PREFIX + assetCategory.getCategoryId();
				json.put(key, preferences.getValue(key, StringPool.BLANK));
			}
			// this one is required to know whether selected collab type is internal, external
			actionRequest.setAttribute("collabTypesWithProps", json.toString());
			

			actionRequest.setAttribute(
					SPChallengeConstants.APPLICANT_TYPES_LIST,
					applicantTypeList);
			actionRequest.setAttribute(
					SPChallengeConstants.CHALLENGE_CATEGORY_LIST,
					challengeCategoryList);
			actionRequest
					.setAttribute(SPChallengeConstants.CHALLENGE_TYPE_LIST,
							challengeTypeList);
			actionRequest.setAttribute(SPChallengeConstants.REGION_LIST,
					regionList);
			actionRequest.setAttribute(SPChallengeConstants.COLLAB_TYPE_LIST,
					collabTypeList);
			actionRequest.setAttribute(
					SPChallengeConstants.ORG_BRAND_LIST,
					orgBrandList);

			if (Validator.isNotNull(challengeId)
					&& GetterUtil.getLong(challengeId) != 0) {
				AssetEntry assetEntry = AssetEntryLocalServiceUtil.fetchEntry(
						SPChallenge.class.getName(),
						GetterUtil.getLong(challengeId));
				if (Validator.isNotNull(assetEntry)) {
					long categoryIds[] = assetEntry.getCategoryIds();
					List<Long> list = Arrays.asList(ArrayUtils
							.toObject(categoryIds));
					actionRequest.setAttribute("cats", list);
				}
			}

		} catch (Exception e) {
			logger.error("Error occured filling categories for challengeId "
					+ challengeId, e);
		}
	}

	public static void fillCategoriesApplication(PortletRequest actionRequest,
			long applicantId, long orgId) {
		try {
			PortletPreferences preferences = actionRequest.getPreferences();
			String regionId = preferences.getValue(
					SPChallengeConstants.VOC_REGION_TYPE_ID, "0");
			String orgIncorporatedVocId = preferences.getValue(
					SPChallengeConstants.VOC_ORG_INCORPORATED_STATUS_ID, "0");
			String orgLifecycleStageVocId = preferences.getValue(
					SPChallengeConstants.VOC_ORG_LIFESTAGE_ID, "0");
			String orgRaisingFundsVocId = preferences.getValue(
					SPChallengeConstants.VOC_ORG_RAISING_FUNDS_ID, "0");
			String orgCategoryVocId = preferences.getValue(
					SPChallengeConstants.VOC_ORG_CATEGORY_ID,"0");
			String orgBenchmarkVocId=preferences.getValue(
					SPChallengeConstants.VOC_ORG_BENCHMARK_ID,"0");
			String orgCostBenchmarkVocId=preferences.getValue(
					SPChallengeConstants.VOC_ORG_COST_BENCHMARK_ID,"0");
			String brandVocId=preferences.getValue(
					SPChallengeConstants.VOC_BRAND_ID,"0");

			List<AssetCategory> regionList = AssetCategoryLocalServiceUtil
					.getVocabularyCategories(Long.valueOf(regionId), -1, -1,
							null);
			List<AssetCategory> orgIncorporatedList = AssetCategoryLocalServiceUtil
					.getVocabularyCategories(
							Long.valueOf(orgIncorporatedVocId), -1, -1, null);
			List<AssetCategory> orgLifecycleStageList = AssetCategoryLocalServiceUtil
					.getVocabularyCategories(
							Long.valueOf(orgLifecycleStageVocId), -1, -1, null);
			List<AssetCategory> orgRaisingFundsList = AssetCategoryLocalServiceUtil
					.getVocabularyCategories(
							Long.valueOf(orgRaisingFundsVocId), -1, -1, null);
			List<AssetCategory> orgCategoryList = AssetCategoryLocalServiceUtil
					.getVocabularyCategories(Long.valueOf(orgCategoryVocId),
							-1, -1, null);
			List<AssetCategory> orgBenchmarkList = AssetCategoryLocalServiceUtil
					.getVocabularyCategories(Long.valueOf(orgBenchmarkVocId),
							-1, -1, null);
			List<AssetCategory> orgCostBenchmarkList = AssetCategoryLocalServiceUtil
					.getVocabularyCategories(Long.valueOf(orgCostBenchmarkVocId),
							-1, -1, null);
			List<AssetCategory> orgBrandList = AssetCategoryLocalServiceUtil
					.getVocabularyCategories(Long.valueOf(brandVocId),
							-1, -1, null);
			

			actionRequest.setAttribute(SPChallengeConstants.REGION_LIST,
					regionList);
			actionRequest.setAttribute(
					SPChallengeConstants.ORG_INCORPORATED_LIST,
					orgIncorporatedList);
			actionRequest.setAttribute(SPChallengeConstants.ORG_LIFESTAGE_LIST,
					orgLifecycleStageList);
			actionRequest.setAttribute(
					SPChallengeConstants.ORG_RAISING_FUNDS_LIST,
					orgRaisingFundsList);
			actionRequest.setAttribute(
					SPChallengeConstants.ORG_CATEGORY_LIST,
					orgCategoryList);
			actionRequest.setAttribute(
					SPChallengeConstants.ORG_BENCHMARK_LIST,
					orgBenchmarkList);
			actionRequest.setAttribute(
					SPChallengeConstants.ORG_COST_BENCHMARK_LIST,
					orgCostBenchmarkList);
			actionRequest.setAttribute(
					SPChallengeConstants.ORG_BRAND_LIST,
					orgBrandList);

			AssetEntry assetEntry = AssetEntryLocalServiceUtil.fetchEntry(
					Organization.class.getName(), orgId);
			long categoryIds[] = new long[0];
			if (Validator.isNotNull(assetEntry)) {
				categoryIds = assetEntry.getCategoryIds();
			}
			if (GetterUtil.getLong(applicantId) != 0) {
				assetEntry = AssetEntryLocalServiceUtil.fetchEntry(
						SPChallengeApplicant.class.getName(), applicantId);
				long applCategoryIds[] = assetEntry.getCategoryIds();
				categoryIds = ArrayUtils.addAll(categoryIds, applCategoryIds);
			}
			List<Long> list = Arrays.asList(ArrayUtils.toObject(categoryIds));
			actionRequest.setAttribute("cats", list);

		} catch (Exception e) {
			logger.error(
					"Error occured filling categories for applicantId, orgId  = "
							+ applicantId + ", " + orgId, e);
		}
	}

	public void reIndex(SPChallenge challenge) {
		Indexer indexer = IndexerRegistryUtil.getIndexer(SPChallenge.class
				.getName());
		if (indexer != null) {
			try {
				indexer.reindex(challenge);
			} catch (SearchException se) {
				logger.error("Error occured while indexing", se);
			}
		}
	}

	public void reIndex(SPChallengeApplicant applicant) {
		Indexer indexer = IndexerRegistryUtil
				.getIndexer(SPChallengeApplicant.class.getName());
		if (indexer != null) {
			try {
				indexer.reindex(applicant);
			} catch (SearchException se) {
				logger.error("Error occured while indexing", se);
			}
		}
	}

	//--Abhinay- get questionnaire objects
	public static void toMultipleFieldHtml(String fieldName, RenderRequest req, JspWriter out) {
		try {
			String temp="";
			if(fieldName.equals("questionnaire")){
				temp=fieldName;
				if (Validator.isNotNull(req.getAttribute(temp))) {
					out.println("var " + temp + " = " + req.getAttribute(temp) + ";");
				} 
			}else{
				for (int i = 1;; i++) {
					temp = fieldName + i;
					if (Validator.isNotNull(req.getAttribute(temp))) {
						out.println("var " + temp + " = " + req.getAttribute(temp) + ";");
					} else {
						break;
					}
				}
			}
			
		} catch (Exception e) {
			logger.error(e.getMessage());
		} 
	}

}