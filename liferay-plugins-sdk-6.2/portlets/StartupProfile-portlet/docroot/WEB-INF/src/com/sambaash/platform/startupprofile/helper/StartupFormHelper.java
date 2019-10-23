package com.sambaash.platform.startupprofile.helper;

import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Set;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.RenderRequest;
import javax.servlet.jsp.JspWriter;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.CharPool;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.Http;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.model.Country;
import com.liferay.portal.model.User;
import com.liferay.portal.service.CountryServiceUtil;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.model.AssetVocabulary;
import com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetVocabularyLocalServiceUtil;
import com.sambaash.platform.constant.SambaashConstants;
import com.sambaash.platform.srv.processbuilder.model.PEProcessStage;
import com.sambaash.platform.srv.processbuilder.service.PEProcessStageLocalServiceUtil;
import com.sambaash.platform.srv.spchallenge.model.SPChallenge;
import com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant;
import com.sambaash.platform.srv.spchallenge.service.SPChallengeApplicantLocalServiceUtil;
import com.sambaash.platform.srv.spchallenge.service.SPChallengeLocalServiceUtil;
import com.sambaash.platform.srv.startupprofile.model.ATODocument;
import com.sambaash.platform.srv.startupprofile.model.Accreditation;
import com.sambaash.platform.srv.startupprofile.model.Address;
import com.sambaash.platform.srv.startupprofile.model.ApprovedMentors;
import com.sambaash.platform.srv.startupprofile.model.EmployeeInfo;
import com.sambaash.platform.srv.startupprofile.model.Guidelines;
import com.sambaash.platform.srv.startupprofile.model.Organization;
import com.sambaash.platform.srv.startupprofile.model.SPATOContacts;
import com.sambaash.platform.srv.startupprofile.model.SPOrgContactUs;
import com.sambaash.platform.srv.startupprofile.model.impl.AccreditationImpl;
import com.sambaash.platform.srv.startupprofile.model.impl.AddressImpl;
import com.sambaash.platform.srv.startupprofile.model.impl.ApprovedMentorsImpl;
import com.sambaash.platform.srv.startupprofile.model.impl.EmployeeInfoImpl;
import com.sambaash.platform.srv.startupprofile.model.impl.FundingRoundImpl;
import com.sambaash.platform.srv.startupprofile.model.impl.GuidelinesImpl;
import com.sambaash.platform.srv.startupprofile.model.impl.OrganizationImpl;
import com.sambaash.platform.srv.startupprofile.model.impl.PersonImpl;
import com.sambaash.platform.srv.startupprofile.model.impl.QuestionnaireImpl;
import com.sambaash.platform.srv.startupprofile.model.impl.SPATOContactsImpl;
import com.sambaash.platform.srv.startupprofile.model.impl.SPOrgContactUsImpl;
import com.sambaash.platform.srv.startupprofile.service.ATODocumentLocalServiceUtil;
import com.sambaash.platform.srv.startupprofile.service.AccreditationLocalServiceUtil;
import com.sambaash.platform.srv.startupprofile.service.AddressLocalServiceUtil;
import com.sambaash.platform.srv.startupprofile.service.ApprovedMentorsLocalServiceUtil;
import com.sambaash.platform.srv.startupprofile.service.EmployeeInfoLocalServiceUtil;
import com.sambaash.platform.srv.startupprofile.service.GuidelinesLocalServiceUtil;
import com.sambaash.platform.srv.startupprofile.service.OrganizationLocalServiceUtil;
import com.sambaash.platform.srv.startupprofile.service.SPATOContactsLocalServiceUtil;
import com.sambaash.platform.srv.startupprofile.service.SPOrgContactUsLocalServiceUtil;
import com.sambaash.platform.srv.startupprofile.service.impl.AddressLocalServiceImpl;
import com.sambaash.platform.startupprofile.StartupConstants;
import com.sambaash.platform.tag.handlers.CommentTagProcess;
import com.sambaash.platform.util.FormHelper;
import com.sambaash.platform.util.SambaashUtil;

public class StartupFormHelper {

	private static final String DEFAULT_IFRAME_WEB_PROTOCOL = "https";
	private static final Log logger = LogFactoryUtil.getLog(StartupFormHelper.class);
	private static Map<String, String> register = new HashMap<String, String>();
	private static final HashMap<String, String> colorCssMap = new HashMap<String, String>();

	{
		register.put(StartupConstants.ATTRIB_ORGANIZATION, OrganizationImpl.class.getName());//
		register.put(StartupConstants.ATTRIB_ADDRESS, AddressImpl.class.getName());//
		register.put(StartupConstants.ATTRIB_CONTACT, SPOrgContactUsImpl.class.getName());//

		register.put(StartupConstants.ATTRIB_EMPLOYEE_INFO, EmployeeInfoImpl.class.getName());//
		register.put(StartupConstants.ATTRIB_SPATO_CONTACTS, SPATOContactsImpl.class.getName());
		register.put(StartupConstants.ATTRIB_APPROVED_MENTORS, ApprovedMentorsImpl.class.getName());
		register.put(StartupConstants.ATTRIB_GUIDELINES, GuidelinesImpl.class.getName());
		register.put(StartupConstants.ATTRIB_ACCREDITATION, AccreditationImpl.class.getName());

		register.put(StartupConstants.ATTRIB_HQ, AddressImpl.class.getName());//
		register.put(StartupConstants.ATTRIB_FUNDING_ROUND, FundingRoundImpl.class.getName());
		register.put(StartupConstants.ATTRIB_TEAM_MEMBER, PersonImpl.class.getName());
		register.put(StartupConstants.ATTRIB_QUESTIONNAIRE, QuestionnaireImpl.class.getName());

		colorCssMap.put("Consumer and Market Intelligence", "cmi_tagbg");
		colorCssMap.put("Enterprise Tech", "et_tagbg");
		colorCssMap.put("Marketing, AdTech & Ecommerce", "mae_tagbg");
		colorCssMap.put("Product & Ingredients", "pi_tagbg");
		colorCssMap.put("Sustainability & Social Entrepreneurs", "sse_tagbg");
	}

	public StartupFormHelper() {
		this.register = register;
		this.claassLoader = StartupFormHelper.class.getClassLoader();

	}

	public void addOrgDataToRequest(PortletRequest actionRequest, long organizationId) throws Exception {

		Map<String, Object> existingMap = OrganizationLocalServiceUtil.createOrgDataMap(organizationId);

		if (organizationId != 0) {
			Organization org;
			try {
				org = (Organization) existingMap.get(StartupConstants.ATTRIB_ORGANIZATION);
				SPStartupDLHelper.addOrgFilesToRequest(actionRequest, org);
				// actionRequest.setAttribute("objUUID", org.getUuid());
				addOrgVideoLinksToRequest(actionRequest, org);
				addOrgProjectsToRequest(actionRequest, org);
				addOrgTagsToRequest(actionRequest, org);
				addOrgChallengeApplications(actionRequest, org);
				actionRequest.setAttribute("dfsdfsdf", "555555555555");
				addOrgAddressesToRequest(actionRequest, org);
				addOrgContactsToRequest(actionRequest, org);

				addEmployeeInfoToRequest(actionRequest, org);
				addSPATOContactsToRequest(actionRequest, org);
				addAccreditationToRequest(actionRequest, org);
				addGuidelinesToRequest(actionRequest, org);
				addMentorsToRequest(actionRequest, org);
				addATODocumentsToRequest(actionRequest, org);

				actionRequest.setAttribute(StartupConstants.IS_PROFILE_COMPLETE, org.isCompleteness());
				if (StringUtils.isNotEmpty(org.getTotalFunds())) {
					actionRequest.setAttribute("formattedTotalFunds",
							SambaashUtil.formattedAmount(org.getTotalFunds()));
				}
			} catch (Exception e) {
				logger.error("Error while setting logourl");
			}
		}
		Set<Entry<String, Object>> entrySet = existingMap.entrySet();
		for (Entry<String, Object> entry : entrySet) {
			String jsonString = JSONFactoryUtil.looseSerializeDeep(entry.getValue());
			if (entry.getKey() == StartupConstants.ATTRIB_ORGANIZATION) {
				JSONObject o = JSONFactoryUtil.createJSONObject(jsonString);
				Organization org = ((Organization) entry.getValue());
				o.put("foundedOnH5Format", StartupFormHelper.toHtlm5DateFormat(org.getFoundedOn(), "dd MMM yyyy"));
				User user = UserLocalServiceUtil.getUser(org.getUserId());
				o.put("fname", user.getFirstName());
				o.put("lname", user.getLastName());
				jsonString = o.toString();
			}
			actionRequest.setAttribute(entry.getKey(), jsonString);
		}
		logger.debug("addOrgDataToRequest - org data existingMap = " + existingMap);
	}

	private void addOrgAddressesToRequest(PortletRequest actionRequest, Organization org) {
		try {
			List<Address> addresses = AddressLocalServiceUtil.findByOrganizationId(org.getOrganizationId());
			String addressesJson = JSONFactoryUtil.looseSerializeDeep(addresses);
			actionRequest.setAttribute(StartupConstants.ORG_ADDRESSES, addressesJson);

		} catch (Exception e) {
			logger.error("Error retrieving addresses for organizationId " + org.getOrganizationId());
		}
	}

	private void addOrgContactsToRequest(PortletRequest actionRequest, Organization org) {
		try {
			List<SPOrgContactUs> contacts = SPOrgContactUsLocalServiceUtil
					.findByOrganizationId(org.getOrganizationId());
			String contactsJson = JSONFactoryUtil.looseSerializeDeep(contacts);
			actionRequest.setAttribute(StartupConstants.ORG_CONTACTS, contactsJson);

		} catch (Exception e) {
			logger.error("Error retrieving contacts for organizationId " + org.getOrganizationId());
		}
	}

	private void addEmployeeInfoToRequest(PortletRequest actionRequest, Organization org) {
		try {
			List<EmployeeInfo> employeeInfo = EmployeeInfoLocalServiceUtil
					.findByOrganizationId(org.getOrganizationId());
			String employeeInfoJson = JSONFactoryUtil.looseSerializeDeep(employeeInfo.get(employeeInfo.size() - 1));
			actionRequest.setAttribute(StartupConstants.ATTRIB_EMPLOYEE_INFO, employeeInfoJson);

		} catch (Exception e) {
			logger.error("Error retrieving contacts for organizationId " + org.getOrganizationId());
		}
	}

	private void addSPATOContactsToRequest(PortletRequest actionRequest, Organization org) {
		try {
			List<SPATOContacts> spatocontacts = SPATOContactsLocalServiceUtil
					.findByOrganizationId(org.getOrganizationId());
			String spatocontactsJson = JSONFactoryUtil.looseSerializeDeep(spatocontacts.get(spatocontacts.size() - 1));
			JSONObject sPATOContacts = JSONFactoryUtil.createJSONObject(spatocontactsJson);
			User user = null;
			try {
				user = UserLocalServiceUtil.getUser(Long.valueOf(sPATOContacts.getString("primaryPrincipalUserId")));
				sPATOContacts.put("primaryPrincipalUserFirstName", user.getFirstName());
				sPATOContacts.put("primaryPrincipalUserLastName", user.getLastName());
				sPATOContacts.put("primaryPrincipalUserEmail", user.getEmailAddress());
			} catch (Exception e) {

			}
			try {
				user = UserLocalServiceUtil.getUser(Long.valueOf(sPATOContacts.getString("secondaryPrincipalUserId")));
				sPATOContacts.put("secondaryPrincipalUserFirstName", user.getFirstName());
				sPATOContacts.put("secondaryPrincipalUserLastName", user.getLastName());
				sPATOContacts.put("secondaryPrincipalUserEmail", user.getEmailAddress());
			} catch (Exception e) {

			}
			// actionRequest.setAttribute(StartupConstants.ATTRIB_SPATO_CONTACTS,
			// sPATOContacts.toString());

		} catch (Exception e) {
			logger.error("Error retrieving contacts for organizationId " + org.getOrganizationId());
		}
	}

	private void addAccreditationToRequest(PortletRequest actionRequest, Organization org) {
		try {
			List<Accreditation> accreditations = AccreditationLocalServiceUtil
					.findByOrganizationId(org.getOrganizationId());
			String accreditationsJson = JSONFactoryUtil
					.looseSerializeDeep(accreditations.get(accreditations.size() - 1));
			actionRequest.setAttribute(StartupConstants.ATTRIB_ACCREDITATION, accreditationsJson);

		} catch (Exception e) {
			logger.error("Error retrieving contacts for organizationId " + org.getOrganizationId());
		}
	}

	private void addGuidelinesToRequest(PortletRequest actionRequest, Organization org) {
		try {
			List<Guidelines> guidelines = GuidelinesLocalServiceUtil.findByOrganizationId(org.getOrganizationId());
			String guidelinesJson = JSONFactoryUtil.looseSerializeDeep(guidelines);
			actionRequest.setAttribute(StartupConstants.ATTRIB_GUIDELINES, guidelinesJson);

		} catch (Exception e) {
			logger.error("Error retrieving contacts for organizationId " + org.getOrganizationId());
		}
	}

	private void addMentorsToRequest(PortletRequest actionRequest, Organization org) {
		try {
			List<ApprovedMentors> mentors = ApprovedMentorsLocalServiceUtil
					.findByOrganizationId(org.getOrganizationId());

			for (int i = 0; i < mentors.size(); i++) {
				if (mentors.get(i).getStatus() == 1) {
					User user = UserLocalServiceUtil.getUser(Long.valueOf(mentors.get(i).getUserId()));

					mentors.get(i).setEmail(user.getEmailAddress());
					mentors.get(i).setFirstName(user.getFirstName());
					mentors.get(i).setLastName(user.getLastName());
					mentors.get(i).setTitleId(user.getContact().getPrefixId());
					mentors.get(i).setJobTitle(user.getContact().getJobTitle());
					mentors.get(i).setMobile(user.getContact().getSmsSn());
				}

			}
			// String mentorsJson = JSONFactoryUtil.looseSerializeDeep(mentors);
			actionRequest.setAttribute(StartupConstants.ATTRIB_APPROVED_MENTORS, mentors);

		} catch (Exception e) {
			logger.error("Error retrieving contacts for organizationId " + org.getOrganizationId());
		}
	}

	private void addATODocumentsToRequest(PortletRequest actionRequest, Organization org) {
		try {
			List<ATODocument> financialStatementDocuments = ATODocumentLocalServiceUtil
					.findByOrganizationAndDocumentType(org.getOrganizationId(), "financialStatement");

			actionRequest.setAttribute("financialStatement", financialStatementDocuments);

			List<ATODocument> policyDocuments = ATODocumentLocalServiceUtil
					.findByOrganizationAndDocumentType(org.getOrganizationId(), "policy");

			actionRequest.setAttribute("policy", policyDocuments);

			List<ATODocument> businessConductDocuments = ATODocumentLocalServiceUtil
					.findByOrganizationAndDocumentType(org.getOrganizationId(), "businessConduct");

			actionRequest.setAttribute("businessConduct", businessConductDocuments);

			List<ATODocument> jobDescriptionDocuments = ATODocumentLocalServiceUtil
					.findByOrganizationAndDocumentType(org.getOrganizationId(), "jobDescription");

			actionRequest.setAttribute("jobDescription", jobDescriptionDocuments);

			List<ATODocument> appraisalFormDocuments = ATODocumentLocalServiceUtil
					.findByOrganizationAndDocumentType(org.getOrganizationId(), "appraisalForm");

			actionRequest.setAttribute("appraisalForm", appraisalFormDocuments);

			List<ATODocument> timesheetsDocuments = ATODocumentLocalServiceUtil
					.findByOrganizationAndDocumentType(org.getOrganizationId(), "timesheets");

			actionRequest.setAttribute("timesheets", timesheetsDocuments);

			List<ATODocument> jobDescriptionsDocuments = ATODocumentLocalServiceUtil
					.findByOrganizationAndDocumentType(org.getOrganizationId(), "jobDescriptions");

			actionRequest.setAttribute("jobDescriptions", jobDescriptionsDocuments);

			List<ATODocument> businessRegistrationDocuments = ATODocumentLocalServiceUtil
					.findByOrganizationAndDocumentType(org.getOrganizationId(), "businessRegistration");

			actionRequest.setAttribute("businessRegistration", businessRegistrationDocuments);

			List<ATODocument> supplementaryDocuments = ATODocumentLocalServiceUtil
					.findByOrganizationAndDocumentType(org.getOrganizationId(), "supplementary");

			actionRequest.setAttribute("supplementaryDocuments", supplementaryDocuments);

		} catch (Exception e) {
			logger.error("Error retrieving contacts for organizationId " + org.getOrganizationId());
		}
	}

	private void addOrgChallengeApplications(PortletRequest actionRequest, Organization org) {
		try {
			List<SPChallengeApplicant> applications = SPChallengeApplicantLocalServiceUtil
					.findByApplicantRefId(org.getOrganizationId());
			if (applications != null && applications.size() > 0) {
				List<SPChallenge> orgChallengeList = new ArrayList<SPChallenge>();
				for (SPChallengeApplicant application : applications) {
					SPChallenge orgChallenge = SPChallengeLocalServiceUtil
							.getSPChallenge(application.getSpChallengeId());
					orgChallengeList.add(orgChallenge);
				}
				actionRequest.setAttribute(StartupConstants.ORG_CHALLENGE_APPLICATIONS, applications);
				actionRequest.setAttribute(StartupConstants.ORG_CHALLENGE_DETAILS, orgChallengeList);
			}
		} catch (Exception e) {
			logger.error("Error retrieving challenge applications for organizationId " + org.getOrganizationId());
		}
	}

	private void addOrgVideoLinksToRequest(PortletRequest actionRequest, Organization org) {
		try {
			String videoLinksJsonStr = org.getVideoLinks();
			// String videoLinksJsonStr =
			// "[\"https://www.youtube.com/watch?v=rad1YaahZWs\",
			// \"https://www.youtube.com/watch?v=7eQaKx3c64M\"]";
			if (StringUtils.isNotEmpty(videoLinksJsonStr)) {
				JSONArray videoLinksArr = JSONFactoryUtil.createJSONArray(videoLinksJsonStr);
				List<String> videoLinkList = new ArrayList<String>();
				List<String> sliderVideoLinkList = new ArrayList<String>();
				for (int i = 0; i < videoLinksArr.length(); i++) {
					String videoLink = videoLinksArr.getString(i);
					if (StringUtils.isNotEmpty(videoLink)) {
						sliderVideoLinkList.add(generateVideoEmbedLink(actionRequest, videoLink));
						videoLinkList.add(videoLink);
					}
				}
				actionRequest.setAttribute(StartupConstants.ORG_VIDEO_LINK_LIST, videoLinkList);
				actionRequest.setAttribute(StartupConstants.ORG_SLIDER_VIDEO_LINK_LIST, sliderVideoLinkList);
			}
		} catch (Exception e) {
			logger.debug("Error reading video links.", e);
		}
	}

	private void addOrgProjectsToRequest(PortletRequest actionRequest, Organization org) {
		List<String> brandList = new ArrayList<String>();
		List<String> projectsList = new ArrayList<String>();
		try {
			String projectsJsonStr = org.getProjectsWorkedOn();
			if (StringUtils.isNotEmpty(projectsJsonStr)) {
				JSONArray projectsArr = JSONFactoryUtil.createJSONArray(projectsJsonStr);
				for (int i = 0; i < projectsArr.length(); i++) {
					JSONObject projectObj = projectsArr.getJSONObject(i);
					String brand = projectObj.getString("brand");
					String project = projectObj.getString("project");
					if (StringUtils.isNotEmpty(brand) && StringUtils.isNotEmpty(project)) {
						projectsList.add(getCategoryName(project));
						brandList.add(brand);
					}
				}
			}
		} catch (Exception e) {
			logger.debug("Error reading projects worked on.", e);
		}
		actionRequest.setAttribute(StartupConstants.ORG_BRAND_LIST, brandList);
		actionRequest.setAttribute(StartupConstants.ORG_PROJECT_LIST, projectsList);
	}

	private void addOrgTagsToRequest(PortletRequest actionRequest, Organization org) {
		long orgTagsVocId = GetterUtil
				.getLong(actionRequest.getPreferences().getValue(StartupConstants.VOC_ORG_TAGS_ID, "0"));
		List<String> tagsList = new ArrayList<String>();
		try {
			List<AssetCategory> catList = AssetCategoryLocalServiceUtil.getCategories(Organization.class.getName(),
					org.getOrganizationId());
			for (AssetCategory cat : catList) {
				if (cat.getVocabularyId() == orgTagsVocId) {
					tagsList.add(String.format("%s:%s", cat.getCategoryId(), cat.getName()));
				}
			}
		} catch (Exception e) {
			logger.debug("Error reading startup tags.", e);
		}
		actionRequest.setAttribute(StartupConstants.ORG_TAG_LIST, tagsList);
	}

	private String getCategoryName(String brand) throws Exception {
		return AssetCategoryLocalServiceUtil.getAssetCategory(Long.parseLong(brand)).getName();
	}

	private String generateVideoEmbedLink(PortletRequest request, String videoLink) {
		try {
			// String protocol = request.getScheme();
			String protocol = StartupProfileHelper.getIframeWebProtocol();
			if (videoLink.toLowerCase().contains("youtube.com")) {
				// String protocol =
				// Http.HTTPS.equals(PropsUtil.get(PropsKeys.WEB_SERVER_PROTOCOL))
				// ? "https" : "http";
				String videoId = getYoutubeVideoId(videoLink);
				String newLink = String.format("%s://www.youtube.com/embed/%s?autoplay=0&rel=0&enablejsapi=1", protocol,
						videoId);
				return newLink;
			} else if (videoLink.toLowerCase().contains("vimeo.com")) {
				String videoId = getVimeoVideoId(videoLink);
				String newLink = String.format("%s://player.vimeo.com/video/%s?api=1&wmode=transparent", protocol,
						videoId);
				// String newLink = videoLink.replace("http://", protocol+"://")
				// + "&api=1&wmode=transparent";
				return newLink;
			}
		} catch (Exception e) {
			logger.debug("Error generating youtube embed link.", e);
		}
		return videoLink;
	}

	private String getVimeoVideoId(String videoLink) {
		Pattern p = Pattern.compile("(.*)/(\\d*)$");
		Matcher matcher = p
				.matcher(videoLink.contains("?") ? videoLink.substring(0, videoLink.lastIndexOf("?")) : videoLink);
		String videoId = "";

		while (matcher.find()) {
			videoId = matcher.group(2);
		}
		return videoId;
	}

	private String getYoutubeVideoId(String videoLink) {
		Pattern p = Pattern.compile("(.*)www\\.youtube\\.com(.*)v=(.*)\\&(.*)=(.*)");
		Matcher matcher = p.matcher(videoLink);

		String videoId = videoLink.substring(videoLink.indexOf("?v=") + 3);

		while (matcher.find()) {
			videoId = matcher.group(3);
		}
		return videoId;
	}

	public static void fillCategories(PortletRequest actionRequest, String orgId) {
		try {
			PortletPreferences preferences = actionRequest.getPreferences();
			String orgIncorpStatusId = preferences.getValue(StartupConstants.VOC_ORG_INCORPORATED_STATUS_ID, "0");
			String orgLifeStageId = preferences.getValue(StartupConstants.VOC_ORG_LIFESTAGE_ID, "0");
			String orgRaisingFundsId = preferences.getValue(StartupConstants.VOC_ORG_RAISING_FUNDS_ID, "0");
			String orgCategoryId = preferences.getValue(StartupConstants.VOC_ORG_CATEGORY_ID, "0");
			String orgBenchmarkId = preferences.getValue(StartupConstants.VOC_ORG_BENCHMARK_ID, "0");
			String orgCostBenchmarkId = preferences.getValue(StartupConstants.VOC_ORG_COST_BENCHMARK_ID, "0");
			String orgMethodologyVocId = preferences.getValue(StartupConstants.VOC_ORG_METHODOLOGY_ID, "0");
			String orgBrandVocId = preferences.getValue(StartupConstants.VOC_ORG_BRAND_ID, "0");
			String orgProjectsVocId = preferences.getValue(StartupConstants.VOC_ORG_PROJECTS_ID, "0");

			// String orgTagsVocId = preferences.getValue(
			// StartupConstants.VOC_ORG_TAGS_ID, "0");
			String orgCollabStageVocId = preferences.getValue(StartupConstants.VOC_ORG_COLLAB_STAGE_ID, "0");

			String orgTagsVocId = preferences.getValue(StartupConstants.VOC_ORG_TAGS_ID, "0");
			String prevBusinessDevManagerList = preferences
					.getValue(StartupConstants.ORG_PREV_BUSINESS_DEV_MANAGER_LIST, "");
			String businessDevManagerList = preferences.getValue(StartupConstants.ORG_BUSINESS_DEV_MANAGER_LIST, "");
			String pipelineStatusList = preferences.getValue(StartupConstants.ORG_PIPELINE_STATUS_LIST, "");

			String orgCorporateTypeId = preferences.getValue(StartupConstants.VOC_ORG_CORPORATE_TYPE_ID, "0");
			String orgCorporateCategoryId = preferences.getValue(StartupConstants.VOC_ORG_CORPORATE_CATEGORY_ID, "0");
			String orgSalutationId = preferences.getValue(StartupConstants.VOC_ORG_SALUTATION_ID, "0");

			List<AssetCategory> orgIncorpStatusList = AssetCategoryLocalServiceUtil
					.getVocabularyCategories(Long.valueOf(orgIncorpStatusId), -1, -1, null);
			List<AssetCategory> orgLifeStageList = AssetCategoryLocalServiceUtil
					.getVocabularyCategories(Long.valueOf(orgLifeStageId), -1, -1, null);
			List<AssetCategory> orgRaisingFundsList = AssetCategoryLocalServiceUtil
					.getVocabularyCategories(Long.valueOf(orgRaisingFundsId), -1, -1, null);
			List<AssetCategory> orgCategoryList = AssetCategoryLocalServiceUtil
					.getVocabularyCategories(Long.valueOf(orgCategoryId), -1, -1, null);
			List<AssetCategory> orgBenchmarkList = AssetCategoryLocalServiceUtil
					.getVocabularyCategories(Long.valueOf(orgBenchmarkId), -1, -1, null);
			List<AssetCategory> orgCostBenchmarkList = AssetCategoryLocalServiceUtil
					.getVocabularyCategories(Long.valueOf(orgCostBenchmarkId), -1, -1, null);
			List<AssetCategory> orgMethodologyTypeList = AssetCategoryLocalServiceUtil
					.getVocabularyRootCategories(Long.valueOf(orgMethodologyVocId), -1, -1, null);
			List<AssetCategory> brandList = AssetCategoryLocalServiceUtil
					.getVocabularyRootCategories(Long.valueOf(orgBrandVocId), -1, -1, null);
			List<AssetCategory> projectList = AssetCategoryLocalServiceUtil
					.getVocabularyRootCategories(Long.valueOf(orgProjectsVocId), -1, -1, null);

			List<AssetCategory> orgCorporateTypeList = AssetCategoryLocalServiceUtil
					.getVocabularyRootCategories(Long.valueOf(orgCorporateTypeId), -1, -1, null);
			List<AssetCategory> orgCorporateCategoryList = AssetCategoryLocalServiceUtil
					.getVocabularyRootCategories(Long.valueOf(orgCorporateCategoryId), -1, -1, null);
			List<AssetCategory> orgSalutationList = AssetCategoryLocalServiceUtil
					.getVocabularyRootCategories(Long.valueOf(orgSalutationId), -1, -1, null);

			// JSONArray stageList = getOrgStageList();
			// List<AssetCategory> orgTagList = AssetCategoryLocalServiceUtil
			// .getVocabularyRootCategories(Long.valueOf(orgTagsVocId), -1, -1,
			// null);
			List<AssetCategory> orgCollabStageList = AssetCategoryLocalServiceUtil
					.getVocabularyRootCategories(Long.valueOf(orgCollabStageVocId), -1, -1, null);

			JSONArray stageList = getOrgStageList();
			JSONArray pipelineStatus;

			try {
				pipelineStatus = getPipelineStatusOptionsToDisplay(pipelineStatusList);
			} catch (Exception e) {
				pipelineStatus = JSONFactoryUtil.createJSONArray();
			}

			JSONArray businessDevManagerUsers = getBusinessDevManagerOptionsToDisplay(businessDevManagerList);
			JSONArray prevBusinessDevManagerUsers = getBusinessDevManagerOptionsToDisplay(prevBusinessDevManagerList);

			List<AssetCategory> orgTagList = AssetCategoryLocalServiceUtil
					.getVocabularyRootCategories(Long.valueOf(orgTagsVocId), -1, -1, null);

			actionRequest.setAttribute(StartupConstants.ORG_INCORPORATED_LIST, orgIncorpStatusList);
			actionRequest.setAttribute(StartupConstants.ORG_LIFESTAGE_LIST, orgLifeStageList);
			actionRequest.setAttribute(StartupConstants.ORG_RAISING_FUNDS_LIST, orgRaisingFundsList);
			actionRequest.setAttribute(StartupConstants.ORG_CATEGORY_LIST, orgCategoryList);
			actionRequest.setAttribute(StartupConstants.ORG_BENCHMARK_LIST, orgBenchmarkList);
			actionRequest.setAttribute(StartupConstants.ORG_COST_BENCHMARK_LIST, orgCostBenchmarkList);
			actionRequest.setAttribute(StartupConstants.ORG_METHODOLOGY_TYPE_LIST, orgMethodologyTypeList);
			actionRequest.setAttribute(StartupConstants.BRAND_LIST, brandList);
			actionRequest.setAttribute(StartupConstants.PROJECT_LIST, projectList);
			actionRequest.setAttribute(StartupConstants.ORG_STAGE_LIST, stageList);
			actionRequest.setAttribute(StartupConstants.ORG_PIPELINE_STATUS_LIST, pipelineStatus);
			actionRequest.setAttribute(StartupConstants.ORG_BUSINESS_DEV_MANAGER_LIST, businessDevManagerUsers);
			actionRequest.setAttribute(StartupConstants.ORG_PREV_BUSINESS_DEV_MANAGER_LIST,
					prevBusinessDevManagerUsers);
			// actionRequest.setAttribute(StartupConstants.ORG_TAG_LIST,
			// orgTagList);
			actionRequest.setAttribute(StartupConstants.ORG_COLLAB_STAGE_LIST, orgCollabStageList);

			actionRequest.setAttribute(StartupConstants.ORG_CORPORATE_TYPE_LIST, orgCorporateTypeList);
			actionRequest.setAttribute(StartupConstants.ORG_CORPORATE_CATEGORY_LIST, orgCorporateCategoryList);
			actionRequest.setAttribute(StartupConstants.ORG_SALUTATION_LIST, orgSalutationList);
			List<AssetCategory> items = (List<AssetCategory>) actionRequest.getAttribute("orgCorporateTypeList");
			if (items == null) {
				logger.debug("categories for orgid " + orgId);
			}
			if (Validator.isNotNull(orgId)) {
				AssetEntry assetEntry = AssetEntryLocalServiceUtil.fetchEntry(Organization.class.getName(),
						Long.valueOf(orgId));
				if (Validator.isNotNull(assetEntry)) {
					long categoryIds[] = assetEntry.getCategoryIds();
					List<Long> list = Arrays.asList(ArrayUtils.toObject(categoryIds));
					actionRequest.setAttribute("cats", list);
					logger.debug("categories for orgid " + orgId + list);
				}
				// methodology
				Organization org = OrganizationLocalServiceUtil.fetchOrganization(Long.parseLong(orgId));
				long mType = org.getMethodologyType();
				if (mType > 0) {
					// get methodology sub type list
					List<AssetCategory> orgMethodologySubTypeList = AssetCategoryLocalServiceUtil
							.getVocabularyCategories(mType, Long.valueOf(orgMethodologyVocId), -1, -1, null);
					actionRequest.setAttribute(StartupConstants.ORG_METHODOLOGY_SUBTYPE_LIST,
							orgMethodologySubTypeList);
					List<Long> list = Arrays.asList(mType, org.getMethodologySubType());
					actionRequest.setAttribute("methodologyCats", list);
				}
			}

		} catch (Exception e) {
			logger.error("Error filling categories", e);
		}
	}

	private static JSONArray getPipelineStatusOptionsToDisplay(String str) {
		JSONArray list = JSONFactoryUtil.createJSONArray();
		String[] strArr = str.split(",");
		try {
			for (String id : strArr) {
				PEProcessStage peProcessStage = PEProcessStageLocalServiceUtil
						.getPEProcessStage(GetterUtil.getLong(id));
				JSONObject stage = newJsonSelectOption(String.valueOf(peProcessStage.getSpPEProcessStageId()),
						peProcessStage.getName());
				list.put(stage);
			}
		} catch (Exception e) {
			logger.error("Error fetching pipeline stages " + e.getMessage());
		}
		return list;
	}

	private static JSONArray getBusinessDevManagerOptionsToDisplay(String str) {
		JSONArray list = JSONFactoryUtil.createJSONArray();
		String[] strArr = str.split(",");
		try {
			for (String id : strArr) {
				if (!id.equalsIgnoreCase(StringPool.BLANK)) {
					User user = UserLocalServiceUtil.getUser(GetterUtil.getLong(id));
					JSONObject obj = newJsonSelectOption(String.valueOf(user.getUserId()), user.getFullName());
					list.put(obj);
				}
			}
		} catch (Exception e) {
			logger.error("Error fetching the list of users");
		}
		return list;
	}

	private static JSONArray getOrgStageList() {
		JSONArray list = JSONFactoryUtil.createJSONArray();
		JSONObject stage1 = newJsonSelectOption("1", "Pitch");
		JSONObject stage2 = newJsonSelectOption("2", "Pilot");
		JSONObject stage3 = newJsonSelectOption("3", "Partner");
		list.put(stage1).put(stage2).put(stage3);
		return list;
	}

	private static JSONObject newJsonSelectOption(String value, String label) {
		JSONObject option = JSONFactoryUtil.createJSONObject();
		option.put("value", value);
		option.put("label", label);
		return option;
	}

	public static long[] getOrgAssetCategories(long orgId) {
		long[] categoryIds = null;
		try {
			AssetEntry assetEntry = AssetEntryLocalServiceUtil.fetchEntry(Organization.class.getName(),
					Long.valueOf(orgId));
			if (Validator.isNotNull(assetEntry)) {
				categoryIds = assetEntry.getCategoryIds();
			}
		} catch (Exception e1) {
			logger.error("Error fetching categories", e1);
		}

		return categoryIds;
	}

	public static void preparePreferencesData(PortletRequest portletRequest, PortletResponse portletResponse)
			throws IOException, PortletException {
		try {

			PortletPreferences preferences = portletRequest.getPreferences();

			portletRequest.setAttribute(StartupConstants.VOC_ORG_INCORPORATED_STATUS_ID,
					preferences.getValue(StartupConstants.VOC_ORG_INCORPORATED_STATUS_ID, "0"));
			portletRequest.setAttribute(StartupConstants.VOC_ORG_LIFESTAGE_ID,
					preferences.getValue(StartupConstants.VOC_ORG_LIFESTAGE_ID, "0"));
			portletRequest.setAttribute(StartupConstants.VOC_ORG_RAISING_FUNDS_ID,
					preferences.getValue(StartupConstants.VOC_ORG_RAISING_FUNDS_ID, "0"));
			portletRequest.setAttribute(StartupConstants.VOC_ORG_CATEGORY_ID,
					preferences.getValue(StartupConstants.VOC_ORG_CATEGORY_ID, "0"));
			portletRequest.setAttribute(StartupConstants.VOC_ORG_BENCHMARK_ID,
					preferences.getValue(StartupConstants.VOC_ORG_BENCHMARK_ID, "0"));
			portletRequest.setAttribute(StartupConstants.VOC_ORG_COST_BENCHMARK_ID,
					preferences.getValue(StartupConstants.VOC_ORG_COST_BENCHMARK_ID, "0"));
			portletRequest.setAttribute(StartupConstants.VOC_ORG_METHODOLOGY_ID,
					preferences.getValue(StartupConstants.VOC_ORG_METHODOLOGY_ID, "0"));
			portletRequest.setAttribute(StartupConstants.VOC_ORG_BRAND_ID,
					preferences.getValue(StartupConstants.VOC_ORG_BRAND_ID, "0"));
			portletRequest.setAttribute(StartupConstants.VOC_ORG_PROJECTS_ID,
					preferences.getValue(StartupConstants.VOC_ORG_PROJECTS_ID, "0"));
			portletRequest.setAttribute(StartupConstants.VOC_ORG_TAGS_ID,
					preferences.getValue(StartupConstants.VOC_ORG_TAGS_ID, "0"));
			portletRequest.setAttribute(StartupConstants.VOC_ORG_COLLAB_STAGE_ID,
					preferences.getValue(StartupConstants.VOC_ORG_COLLAB_STAGE_ID, "0"));

			portletRequest.setAttribute(StartupConstants.VOC_ORG_CORPORATE_CATEGORY_ID,
					preferences.getValue(StartupConstants.VOC_ORG_CORPORATE_CATEGORY_ID, "0"));
			portletRequest.setAttribute(StartupConstants.VOC_ORG_CORPORATE_TYPE_ID,
					preferences.getValue(StartupConstants.VOC_ORG_CORPORATE_TYPE_ID, "0"));
			portletRequest.setAttribute(StartupConstants.VOC_ORG_SALUTATION_ID,
					preferences.getValue(StartupConstants.VOC_ORG_SALUTATION_ID, "0"));

			portletRequest.setAttribute(StartupConstants.ORG_LABEL_CONTACT_NAME,
					preferences.getValue(StartupConstants.ORG_LABEL_CONTACT_NAME, ""));

			portletRequest.setAttribute(StartupConstants.ORG_LABEL_FAX_NUMBER,
					preferences.getValue(StartupConstants.ORG_LABEL_FAX_NUMBER, ""));

			portletRequest.setAttribute(StartupConstants.ORG_LABEL_DESIGNATION,
					preferences.getValue(StartupConstants.ORG_LABEL_DESIGNATION, ""));

			portletRequest.setAttribute(StartupConstants.ORG_LABEL_PIPELINE_STATUS,
					preferences.getValue(StartupConstants.ORG_LABEL_PIPELINE_STATUS, ""));

			portletRequest.setAttribute(StartupConstants.ORG_LABEL_BUSINESS_DEV_MANAGER,
					preferences.getValue(StartupConstants.ORG_LABEL_BUSINESS_DEV_MANAGER, ""));

			portletRequest.setAttribute(StartupConstants.ORG_LABEL_PREV_BUSINESS_DEV_MANAGER,
					preferences.getValue(StartupConstants.ORG_LABEL_PREV_BUSINESS_DEV_MANAGER, ""));

			portletRequest.setAttribute(StartupConstants.ORG_BUSINESS_DEV_MANAGER_LIST,
					preferences.getValue(StartupConstants.ORG_BUSINESS_DEV_MANAGER_LIST, ""));

			portletRequest.setAttribute(StartupConstants.ORG_PREV_BUSINESS_DEV_MANAGER_LIST,
					preferences.getValue(StartupConstants.ORG_PREV_BUSINESS_DEV_MANAGER_LIST, ""));

			portletRequest.setAttribute(StartupConstants.ORG_PIPELINE_STATUS_LIST,
					preferences.getValue(StartupConstants.ORG_PIPELINE_STATUS_LIST, ""));

			ThemeDisplay themeDisplay = (ThemeDisplay) portletRequest.getAttribute(WebKeys.THEME_DISPLAY);

			portletRequest.setAttribute(StartupConstants.SP_PARAM_STARTUP_CREATE,
					StartupProfileHelper.getStartupCreatePath(themeDisplay.getScopeGroupId()));

			portletRequest.setAttribute(StartupConstants.SP_PARAM_STARTUP_DISP,
					StartupProfileHelper.getStartupDisplayPath(themeDisplay.getScopeGroupId()));
			portletRequest.setAttribute(StartupConstants.IFRAME_WEB_PROTOCOL,
					StartupProfileHelper.getIframeWebProtocol());

			portletRequest.setAttribute(CommentTagProcess.COMMENT_DISPLAY_DATE_FORMAT,
					preferences.getValue(CommentTagProcess.COMMENT_DISPLAY_DATE_FORMAT, ""));

			List<AssetVocabulary> assetVocabularies = AssetVocabularyLocalServiceUtil.getAssetVocabularies(-1, -1);
			portletRequest.setAttribute(StartupConstants.VOC_ALL_VOCS, assetVocabularies);

		} catch (SystemException e) {
			logger.error("preparePreferencesData " + e.getMessage(), e);
		}
	}

	public static void savePreferences(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		PortletPreferences preferences = actionRequest.getPreferences();

		String orgorgIncorpStatusId = ParamUtil.getString(actionRequest,
				StartupConstants.VOC_ORG_INCORPORATED_STATUS_ID, "0");
		String orgLifeStageId = ParamUtil.getString(actionRequest, StartupConstants.VOC_ORG_LIFESTAGE_ID, "0");
		String orgRaisingFundsId = ParamUtil.getString(actionRequest, StartupConstants.VOC_ORG_RAISING_FUNDS_ID, "0");
		String orgCategoryId = ParamUtil.getString(actionRequest, StartupConstants.VOC_ORG_CATEGORY_ID, "0");
		String orgBenchmarkId = ParamUtil.getString(actionRequest, StartupConstants.VOC_ORG_BENCHMARK_ID, "0");
		String orgCostBenchmarkId = ParamUtil.getString(actionRequest, StartupConstants.VOC_ORG_COST_BENCHMARK_ID, "0");
		String orgMethodologyVocId = ParamUtil.getString(actionRequest, StartupConstants.VOC_ORG_METHODOLOGY_ID, "0");
		String orgBrandVocId = ParamUtil.getString(actionRequest, StartupConstants.VOC_ORG_BRAND_ID, "0");
		String orgProjectsVocId = ParamUtil.getString(actionRequest, StartupConstants.VOC_ORG_PROJECTS_ID, "0");
		String orgTagsVocId = ParamUtil.getString(actionRequest, StartupConstants.VOC_ORG_TAGS_ID, "0");
		String orgCollabStageVocId = ParamUtil.getString(actionRequest, StartupConstants.VOC_ORG_COLLAB_STAGE_ID, "0");
		String commentDisplayDateFormat = ParamUtil.getString(actionRequest,
				CommentTagProcess.COMMENT_DISPLAY_DATE_FORMAT, "");

		String orgCorporateTypeVocId = ParamUtil.getString(actionRequest, StartupConstants.VOC_ORG_CORPORATE_TYPE_ID,
				"0");
		String orgCorporateCategoryVocId = ParamUtil.getString(actionRequest,
				StartupConstants.VOC_ORG_CORPORATE_CATEGORY_ID, "0");
		String orgSalutationVocId = ParamUtil.getString(actionRequest, StartupConstants.VOC_ORG_SALUTATION_ID, "0");

		String startupCreateHome = HtmlUtil.stripHtml(
				ParamUtil.getString(actionRequest, StartupConstants.SP_PARAM_STARTUP_CREATE, "/startup/create"));

		String startupDispHome = HtmlUtil
				.stripHtml(ParamUtil.getString(actionRequest, StartupConstants.SP_PARAM_STARTUP_DISP, "/startup/view"));

		String iframeWebProtocol = ParamUtil.getString(actionRequest, StartupConstants.IFRAME_WEB_PROTOCOL,
				DEFAULT_IFRAME_WEB_PROTOCOL);
		if (StringUtils.isEmpty(iframeWebProtocol)) {
			iframeWebProtocol = DEFAULT_IFRAME_WEB_PROTOCOL;
		}

		String orgEnableMembers = ParamUtil.getString(actionRequest, StartupConstants.ORG_ENABLE_MEMBERS, "false");

		String orgEnableContactName = ParamUtil.getString(actionRequest, StartupConstants.ORG_ENABLE_CONTACT_NAME,
				"false");

		String orgRequiredContactName = ParamUtil.getString(actionRequest, StartupConstants.ORG_REQUIRED_CONTACT_NAME,
				"false");

		String orgEnableFirstLastName = ParamUtil.getString(actionRequest, StartupConstants.ORG_ENABLE_FIRST_LAST_NAME,
				"false");

		String orgRequiredFirstLastName = ParamUtil.getString(actionRequest,
				StartupConstants.ORG_REQUIRED_FIRST_LAST_NAME, "false");

		String orgEnableFaxNumber = ParamUtil.getString(actionRequest, StartupConstants.ORG_ENABLE_FAX_NUMBER, "false");

		String orgRequiredFaxNumber = ParamUtil.getString(actionRequest, StartupConstants.ORG_REQUIRED_FAX_NUMBER,
				"false");

		String orgLabelContactName = HtmlUtil
				.stripHtml(ParamUtil.getString(actionRequest, StartupConstants.ORG_LABEL_CONTACT_NAME, ""));

		String orgLabelFaxNumber = HtmlUtil
				.stripHtml(ParamUtil.getString(actionRequest, StartupConstants.ORG_LABEL_FAX_NUMBER, ""));

		String orgLabelDesignation = HtmlUtil
				.stripHtml(ParamUtil.getString(actionRequest, StartupConstants.ORG_LABEL_DESIGNATION, ""));

		String orgEnableDesignation = ParamUtil.getString(actionRequest, StartupConstants.ORG_ENABLE_DESIGNATION,
				"false");

		String orgEnableATO = ParamUtil.getString(actionRequest, StartupConstants.ORG_ENABLE_ATO, "false");

		String orgEnablePrinciple1 = ParamUtil.getString(actionRequest, StartupConstants.ORG_ENABLE_PRINCIPLE1,
				"false");
		String orgEnablePrinciple2 = ParamUtil.getString(actionRequest, StartupConstants.ORG_ENABLE_PRINCIPLE2,
				"false");
		String orgEnablePrinciple3 = ParamUtil.getString(actionRequest, StartupConstants.ORG_ENABLE_PRINCIPLE3,
				"false");
		String orgEnablePrinciple4 = ParamUtil.getString(actionRequest, StartupConstants.ORG_ENABLE_PRINCIPLE4,
				"false");
		String orgEnablePrinciple5 = ParamUtil.getString(actionRequest, StartupConstants.ORG_ENABLE_PRINCIPLE5,
				"false");
		String orgEnablePrinciple6 = ParamUtil.getString(actionRequest, StartupConstants.ORG_ENABLE_PRINCIPLE6,
				"false");

		String orgRequiredDesignation = ParamUtil.getString(actionRequest, StartupConstants.ORG_REQUIRED_DESIGNATION,
				"false");

		String orgLabelPipelineStatus = HtmlUtil
				.stripHtml(ParamUtil.getString(actionRequest, StartupConstants.ORG_LABEL_PIPELINE_STATUS, ""));

		String orgEnablePipelineStatus = ParamUtil.getString(actionRequest, StartupConstants.ORG_ENABLE_PIPELINE_STATUS,
				"false");

		String orgRequiredPipelineStatus = ParamUtil.getString(actionRequest,
				StartupConstants.ORG_REQUIRED_PIPELINE_STATUS, "false");

		String orgLabelBusinessDevManager = HtmlUtil
				.stripHtml(ParamUtil.getString(actionRequest, StartupConstants.ORG_LABEL_BUSINESS_DEV_MANAGER, ""));

		String orgEnableBusinessDevManager = ParamUtil.getString(actionRequest,
				StartupConstants.ORG_ENABLE_BUSINESS_DEV_MANAGER, "false");

		String orgRequiredBusinessDevManager = ParamUtil.getString(actionRequest,
				StartupConstants.ORG_REQUIRED_BUSINESS_DEV_MANAGER, "false");

		String orgLabelPrevBusinessDevManager = HtmlUtil.stripHtml(
				ParamUtil.getString(actionRequest, StartupConstants.ORG_LABEL_PREV_BUSINESS_DEV_MANAGER, ""));

		String orgEnablePrevBusinessDevManager = ParamUtil.getString(actionRequest,
				StartupConstants.ORG_ENABLE_PREV_BUSINESS_DEV_MANAGER, "false");

		String orgRequiredPrevBusinessDevManager = ParamUtil.getString(actionRequest,
				StartupConstants.ORG_REQUIRED_PREV_BUSINESS_DEV_MANAGER, "false");

		String[] prevBusinessDevManagerList = ParamUtil.getParameterValues(actionRequest,
				StartupConstants.ORG_PREV_BUSINESS_DEV_MANAGER_LIST, new String[0], false);

		String[] businessDevManagerList = ParamUtil.getParameterValues(actionRequest,
				StartupConstants.ORG_BUSINESS_DEV_MANAGER_LIST, new String[0], false);

		String[] pipelineStatusList = ParamUtil.getParameterValues(actionRequest,
				StartupConstants.ORG_PIPELINE_STATUS_LIST, new String[0], false);

		String orgEnableStartupEvaluation = ParamUtil.getString(actionRequest,
				StartupConstants.ORG_ENABLE_STARTUP_EVALUATION, "false");

		String orgEnableCorporate = ParamUtil.getString(actionRequest, StartupConstants.ORG_ENABLE_CORPORATE, "false");
		String orgEnableHeadquater = ParamUtil.getString(actionRequest, StartupConstants.ORG_ENABLE_HEADQUATER,
				"false");
		String orgEnableProjects = ParamUtil.getString(actionRequest, StartupConstants.ORG_ENABLE_PROJECTS, "false");
		String orgEnableFunding = ParamUtil.getString(actionRequest, StartupConstants.ORG_ENABLE_FUNDING, "false");
		String orgEnableAddress = ParamUtil.getString(actionRequest, StartupConstants.ORG_ENABLE_ADDRESS, "false");
		String orgEnableOldContact = ParamUtil.getString(actionRequest, StartupConstants.ORG_ENABLE_OLD_CONTACT,
				"false");
		String orgEnableNewContact = ParamUtil.getString(actionRequest, StartupConstants.ORG_ENABLE_NEW_CONTACT,
				"false");

		String isDocumentsMandatory = ParamUtil.getString(actionRequest, "isDocumentsMandatory", "true");

		try {
			SambaashUtil.saveSPParameter(StartupConstants.SP_PARAM_STARTUP_CREATE, startupCreateHome);
			SambaashUtil.saveSPParameter(StartupConstants.SP_PARAM_STARTUP_DISP, startupDispHome);
			SambaashUtil.saveSPParameter(StartupConstants.IFRAME_WEB_PROTOCOL, iframeWebProtocol);
			SambaashUtil.saveSPParameter(SambaashConstants.STARTUP_INCORP_VOC_ID, orgorgIncorpStatusId);
			SambaashUtil.saveSPParameter(SambaashConstants.STARTUP_LIFECYCLE_STAGE_VOC_ID, orgLifeStageId);
			SambaashUtil.saveSPParameter(SambaashConstants.STARTUP_CATGEORY_VOC_ID, orgCategoryId);
			SambaashUtil.saveSPParameter(SambaashConstants.STARTUP_RAISINGFUNDS_VOC_ID, orgRaisingFundsId);
			// hard coded for now, have to be in SambaashConstants
			SambaashUtil.saveSPParameter("startup.benchmark.voc.id", orgBenchmarkId);
			SambaashUtil.saveSPParameter("startup.costbenchmark.voc.id", orgCostBenchmarkId);

		} catch (Exception e) {
			logger.error("error saving path", e);
		}

		try {
			preferences.setValue(StartupConstants.VOC_ORG_INCORPORATED_STATUS_ID, orgorgIncorpStatusId);
			preferences.setValue(StartupConstants.VOC_ORG_LIFESTAGE_ID, orgLifeStageId);
			preferences.setValue(StartupConstants.VOC_ORG_RAISING_FUNDS_ID, orgRaisingFundsId);
			preferences.setValue(StartupConstants.VOC_ORG_CATEGORY_ID, orgCategoryId);
			preferences.setValue(StartupConstants.VOC_ORG_BENCHMARK_ID, orgBenchmarkId);
			preferences.setValue(StartupConstants.VOC_ORG_COST_BENCHMARK_ID, orgCostBenchmarkId);
			preferences.setValue(StartupConstants.VOC_ORG_METHODOLOGY_ID, orgMethodologyVocId);
			preferences.setValue(StartupConstants.VOC_ORG_BRAND_ID, orgBrandVocId);
			preferences.setValue(StartupConstants.VOC_ORG_PROJECTS_ID, orgProjectsVocId);
			preferences.setValue(StartupConstants.VOC_ORG_TAGS_ID, orgTagsVocId);
			preferences.setValue(StartupConstants.VOC_ORG_COLLAB_STAGE_ID, orgCollabStageVocId);
			preferences.setValue(StartupConstants.ORG_ENABLE_MEMBERS, orgEnableMembers);
			preferences.setValue(StartupConstants.ORG_ENABLE_CONTACT_NAME, orgEnableContactName);
			preferences.setValue(StartupConstants.ORG_LABEL_CONTACT_NAME, orgLabelContactName);
			preferences.setValue(StartupConstants.ORG_REQUIRED_CONTACT_NAME, orgRequiredContactName);
			preferences.setValue(StartupConstants.ORG_ENABLE_FIRST_LAST_NAME, orgEnableFirstLastName);
			preferences.setValue(StartupConstants.ORG_REQUIRED_FIRST_LAST_NAME, orgRequiredFirstLastName);
			preferences.setValue(StartupConstants.ORG_ENABLE_FAX_NUMBER, orgEnableFaxNumber);
			preferences.setValue(StartupConstants.ORG_REQUIRED_FAX_NUMBER, orgRequiredFaxNumber);
			preferences.setValue(StartupConstants.ORG_LABEL_FAX_NUMBER, orgLabelFaxNumber);
			preferences.setValue(StartupConstants.ORG_LABEL_DESIGNATION, orgLabelDesignation);
			preferences.setValue(StartupConstants.ORG_ENABLE_DESIGNATION, orgEnableDesignation);
			preferences.setValue(StartupConstants.ORG_ENABLE_ATO, orgEnableATO);
			preferences.setValue(StartupConstants.ORG_ENABLE_PRINCIPLE1, orgEnablePrinciple1);
			preferences.setValue(StartupConstants.ORG_ENABLE_PRINCIPLE2, orgEnablePrinciple2);
			preferences.setValue(StartupConstants.ORG_ENABLE_PRINCIPLE3, orgEnablePrinciple3);
			preferences.setValue(StartupConstants.ORG_ENABLE_PRINCIPLE4, orgEnablePrinciple4);
			preferences.setValue(StartupConstants.ORG_ENABLE_PRINCIPLE5, orgEnablePrinciple5);
			preferences.setValue(StartupConstants.ORG_ENABLE_PRINCIPLE6, orgEnablePrinciple6);

			preferences.setValue(StartupConstants.ORG_REQUIRED_DESIGNATION, orgRequiredDesignation);
			preferences.setValue(StartupConstants.ORG_LABEL_PIPELINE_STATUS, orgLabelPipelineStatus);
			preferences.setValue(StartupConstants.ORG_ENABLE_PIPELINE_STATUS, orgEnablePipelineStatus);
			preferences.setValue(StartupConstants.ORG_REQUIRED_PIPELINE_STATUS, orgRequiredPipelineStatus);
			preferences.setValue(StartupConstants.ORG_LABEL_BUSINESS_DEV_MANAGER, orgLabelBusinessDevManager);
			preferences.setValue(StartupConstants.ORG_ENABLE_BUSINESS_DEV_MANAGER, orgEnableBusinessDevManager);
			preferences.setValue(StartupConstants.ORG_REQUIRED_BUSINESS_DEV_MANAGER, orgRequiredBusinessDevManager);
			preferences.setValue(StartupConstants.ORG_LABEL_PREV_BUSINESS_DEV_MANAGER, orgLabelPrevBusinessDevManager);
			preferences.setValue(StartupConstants.ORG_ENABLE_PREV_BUSINESS_DEV_MANAGER,
					orgEnablePrevBusinessDevManager);
			preferences.setValue(StartupConstants.ORG_REQUIRED_PREV_BUSINESS_DEV_MANAGER,
					orgRequiredPrevBusinessDevManager);
			preferences.setValue(StartupConstants.ORG_PREV_BUSINESS_DEV_MANAGER_LIST,
					Arrays.toString(prevBusinessDevManagerList).replaceAll("[\\[\\]]", StringPool.BLANK));
			preferences.setValue(StartupConstants.ORG_BUSINESS_DEV_MANAGER_LIST,
					Arrays.toString(businessDevManagerList).replaceAll("[\\[\\]]", StringPool.BLANK));
			preferences.setValue(StartupConstants.ORG_PIPELINE_STATUS_LIST,
					Arrays.toString(pipelineStatusList).replaceAll("[\\[\\]]", StringPool.BLANK));
			preferences.setValue(CommentTagProcess.COMMENT_DISPLAY_DATE_FORMAT, commentDisplayDateFormat);

			preferences.setValue(StartupConstants.ORG_ENABLE_STARTUP_EVALUATION, orgEnableStartupEvaluation);
			preferences.setValue(StartupConstants.ORG_ENABLE_CORPORATE, orgEnableCorporate);
			preferences.setValue(StartupConstants.ORG_ENABLE_HEADQUATER, orgEnableHeadquater);
			preferences.setValue(StartupConstants.ORG_ENABLE_PROJECTS, orgEnableProjects);
			preferences.setValue(StartupConstants.ORG_ENABLE_FUNDING, orgEnableFunding);
			preferences.setValue(StartupConstants.ORG_ENABLE_ADDRESS, orgEnableAddress);
			preferences.setValue(StartupConstants.ORG_ENABLE_OLD_CONTACT, orgEnableOldContact);
			preferences.setValue(StartupConstants.ORG_ENABLE_NEW_CONTACT, orgEnableNewContact);

			preferences.setValue(StartupConstants.VOC_ORG_CORPORATE_TYPE_ID, orgCorporateTypeVocId);
			preferences.setValue(StartupConstants.VOC_ORG_CORPORATE_CATEGORY_ID, orgCorporateCategoryVocId);
			preferences.setValue(StartupConstants.VOC_ORG_SALUTATION_ID, orgSalutationVocId);

			preferences.setValue("isDocumentsMandatory", isDocumentsMandatory);

			preferences.store();
			actionResponse.setPortletMode(PortletMode.VIEW);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}

	// --Abhinay- get questionnaire objects
	public static void toMultipleFieldHtml(String fieldName, RenderRequest req, JspWriter out) {
		try {
			String temp = "";
			if (fieldName.equals("questionnaire")) {
				temp = fieldName;
				if (Validator.isNotNull(req.getAttribute(temp))) {
					out.println("var " + temp + " = " + req.getAttribute(temp) + ";");
				}
			} else {
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

	public static void createCategoryTags(String allOptionsListName, String selectedOptionName, RenderRequest req,
			JspWriter out) throws Exception {
		createCategoryTags(allOptionsListName, selectedOptionName, req, out, null);
	}

	@SuppressWarnings("unchecked")
	public static void createCategoryTags(String allOptionsListName, String selectedOptionName, RenderRequest req,
			JspWriter out, String cssClass) throws Exception {
		List<AssetCategory> items = (List<AssetCategory>) req.getAttribute(allOptionsListName);
		if (Validator.isNull(items)) {
			return;
		}
		List<Long> selectedOptions = null;
		if (Validator.isNotNull(req.getAttribute(selectedOptionName))) {
			selectedOptions = (List<Long>) req.getAttribute(selectedOptionName);
		}
		for (AssetCategory assetCategory : items) {
			String str = "";
			if (Validator.isNotNull(selectedOptions) && selectedOptions.contains(assetCategory.getCategoryId())) {
				str = "<div  class='st-tags " + getCategoryCssClass(assetCategory, cssClass) + "'>";
				str += assetCategory.getName() + "</div>";
			}
			if (!str.equals(""))
				out.print(str);
		}
	}

	@SuppressWarnings("unchecked")
	public static void createCategoryTagsFromStringList(String allOptionsListName, String selectedOptionName,
			RenderRequest req, JspWriter out, String cssClass) throws Exception {
		List<String> items = (List<String>) req.getAttribute(allOptionsListName);
		if (Validator.isNull(items)) {
			return;
		}
		List<Long> selectedOptions = null;
		if (Validator.isNotNull(req.getAttribute(selectedOptionName))) {
			selectedOptions = (List<Long>) req.getAttribute(selectedOptionName);
		}
		for (String assetCategoryValueLabelSet : items) {
			String str = "";
			Long catId = Long.valueOf(assetCategoryValueLabelSet.split(":")[0]);
			String catName = assetCategoryValueLabelSet.split(":")[1];
			if (Validator.isNotNull(selectedOptions) && selectedOptions.contains(catId)) {
				str = "<div  class='st-tags " + cssClass + "'>" + catName + "</div>";
			}
			if (!str.equals(""))
				out.print(str);
		}
	}

	private static String getCategoryCssClass(AssetCategory assetCategory, String cssClass) {
		String c = cssClass == null ? colorCssMap.get(assetCategory.getName()) : cssClass;
		return c == null ? "" : c;
	}

	public static String toHtlm5DateFormat(String dateStrToFormat, String currentFormat) {
		try {
			SimpleDateFormat currFormat = new SimpleDateFormat(currentFormat);
			Date d = currFormat.parse(dateStrToFormat);
			SimpleDateFormat html5DateFormat = new SimpleDateFormat("dd/MM/yyyy");
			return html5DateFormat.format(d);
		} catch (Exception e) {
			return dateStrToFormat;
		}
	}

	private ClassLoader claassLoader;

	public static Map<String, String> getRequestParamMap(PortletRequest resourceRequest, ThemeDisplay themeDisplay)
			throws SystemException {
		Map<String, String> paramMap = SambaashUtil.getParameterMap(resourceRequest);
		paramMap.put("audituserName", themeDisplay.getUser().getFullName());
		paramMap.put("audituserId", "" + themeDisplay.getUserId());
		paramMap.put("auditgroupId", "" + themeDisplay.getScopeGroupId());
		paramMap.put("auditcompanyId", "" + themeDisplay.getCompanyId());
		return paramMap;
	}

	public Map<String, Object> parsedRequestData(Map<String, String> paramMap, Map<String, Object> existingMap,
			String prefix) throws SystemException {
		if (logger.isInfoEnabled())
			logger.info("existingMap -> " + existingMap);

		Map<String, Object> results = null;

		if (Validator.isNull(existingMap)) {
			results = new HashMap<String, Object>();
		} else {
			results = existingMap;
		}

		Set<Entry<String, String>> set = paramMap.entrySet();
		Date date = new Date();
		for (Entry<String, String> entry : set) {
			String classkey = null;
			try {
				if (Validator.isNull(entry.getValue()) && Validator.isNull(existingMap)) {
					continue;
				}
				if (entry.getKey().indexOf("_") <= 0) {
					if (entry.getKey().equalsIgnoreCase("mentors")) {
						String tt = "dfsdf";
					}
					results.put(entry.getKey(), entry.getValue());
					continue;
				}
				classkey = entry.getKey().split("_")[0];
				String attrib = entry.getKey().split("_")[1];
				Object obj = results.get(classkey);
				if (Validator.isNull(obj)) {
					String clazz = register.get(classkey.replaceAll("\\d", ""));

					obj = Class.forName(clazz, false, claassLoader).newInstance();
					results.put(classkey, obj);

					// if uuid generation is enabled
					setFieldValue(obj, "uuid", PortalUUIDUtil.generate());
					setFieldValue(obj, "new", true);
					setFieldValue(obj, "createDate", date);
					setFieldValue(obj, "userName", paramMap.get("audituserName"));
					setFieldValue(obj, "userId", paramMap.get("audituserId"));
					setFieldValue(obj, "groupId", paramMap.get("auditgroupId"));
					setFieldValue(obj, "companyId", paramMap.get("auditcompanyId"));
				}
				// if no diff then below
				boolean removeNonPrintable = !"budgetCcySign".equals(attrib);
				if ("challenge_background".equalsIgnoreCase(entry.getKey())
						|| "challenge_description".equalsIgnoreCase(entry.getKey())
						|| "challenge_benefits".equalsIgnoreCase(entry.getKey())) {
					setFieldValue(obj, attrib, entry.getValue(), false);
				} else {
					setFieldValue(obj, attrib, entry.getValue(), removeNonPrintable);
				}
				setFieldValue(obj, "modifiedDate", date);
				setFieldValue(obj, "active", true);
			} catch (NullPointerException e) {
				if (logger.isDebugEnabled()) {
					logger.error("No class for key = " + classkey.replaceAll("\\d", ""));
				}
				results.put(entry.getKey(), entry.getValue());
			} catch (Exception e) {
				logger.error("Error while parsing form data", e);
				throw new SystemException(e);
			}
		}
		logger.debug(results);
		return results;
	}

	private void setFieldValue(Object obj, String field, Object value) {
		setFieldValue(obj, field, value, true);
	}

	private void setFieldValue(Object obj, String field, Object value, boolean removeNonPrintableValues) {
		Method mthd = null;
		field = field.substring(0, 1).toUpperCase() + field.substring(1);
		try {
			if (field.contains("UserId")) {
				String yy = "rteew";
			}
			mthd = obj.getClass().getMethod("set" + field, String.class);
			if (Validator.isNotNull(value)) {
				String temp = HtmlUtil.stripHtml((String) value);
				if (removeNonPrintableValues) {
					temp = temp.replaceAll("\\P{Print}", ""); // remove all non
																// printable
																// characters
				}
				mthd.invoke(obj, temp);
			} else {
				mthd.invoke(obj, value);
			}
			return;
		} catch (NoSuchMethodException e) {
			if (field.equalsIgnoreCase("uuid"))
				return;
		} catch (ClassCastException e) {
			// ignore
		} catch (Exception e) {
			logger.warn("Error while invoking setter method", e);
		}
		try {
			mthd = obj.getClass().getMethod("set" + field, Date.class);
			if (value instanceof Date) {
				mthd.invoke(obj, (Date) value);
			} else {
				mthd.invoke(obj, new SimpleDateFormat("MM/dd/yyyy").parse((String) value));
			}
			return;
		} catch (Exception e) {
		}
		try {
			mthd = obj.getClass().getMethod("set" + field, boolean.class);
			mthd.invoke(obj, Boolean.valueOf(value.toString()).booleanValue());
			return;
		} catch (Exception e) {
		}
		try {
			mthd = obj.getClass().getMethod("set" + field, int.class);
			mthd.invoke(obj, Integer.valueOf(value.toString()).intValue());
			return;
		} catch (Exception e) {
		}
		try {
			mthd = obj.getClass().getMethod("set" + field, long.class);
			mthd.invoke(obj, Long.valueOf(value.toString()).longValue());
			return;
		} catch (Exception e) {
		}
		logger.warn("no setter method for field" + field);
	}

	@SuppressWarnings("unchecked")
	public static void createDropDownOptions(String allOptionsListName, String selectedOptionName, RenderRequest req,
			JspWriter out) throws Exception {
		List<AssetCategory> items = (List<AssetCategory>) req.getAttribute(allOptionsListName);
		if (items == null) {
			logger.warn(allOptionsListName + " was not found on the request data");
			return;
		}
		List<Long> selectedOptions = null;
		if (Validator.isNotNull(req.getAttribute(selectedOptionName))) {
			selectedOptions = (List<Long>) req.getAttribute(selectedOptionName);
		}
		for (AssetCategory assetCategory : items) {
			String str = "<option value='" + assetCategory.getCategoryId() + "'";
			if (Validator.isNotNull(selectedOptions) && selectedOptions.contains(assetCategory.getCategoryId()))
				str += " selected ";
			str += ">" + assetCategory.getName() + "</option>";
			out.print(str);
		}
	}

	@SuppressWarnings("unchecked")
	public static void createCheckBoxes(String allOptionsListName, String selectedOptionsName, RenderRequest req,
			javax.portlet.RenderResponse res, JspWriter out) throws Exception {
		List<AssetCategory> items = (List<AssetCategory>) req.getAttribute(allOptionsListName);
		List<Long> selectedOptions = null;
		if (Validator.isNotNull(req.getAttribute(selectedOptionsName))) {
			selectedOptions = (List<Long>) req.getAttribute(selectedOptionsName);
		}

		for (AssetCategory assetCategory : items) {
			String name = res.getNamespace() + "asset_" + assetCategory.getCategoryId();
			String str = "<div class='checkItem'><label for='" + name + "'>" + assetCategory.getName() + "</label>"
					+ "<input type='checkbox' class='aui-field-input' value='" + assetCategory.getCategoryId()
					+ "' name='" + name + "' id='" + name + "' ";
			if (Validator.isNotNull(selectedOptions) && selectedOptions.contains(assetCategory.getCategoryId()))
				str += " checked ";
			str += " /></div>";
			out.print(str);
		}
	}

	@SuppressWarnings("unchecked")
	public static void createCountryDDOptions(String selectedOptionName, RenderRequest req, JspWriter out)
			throws Exception {
		List<Country> items = CountryServiceUtil.getCountries(true);
		List<Long> selectedOptions = null;
		if (Validator.isNotNull(req.getAttribute(selectedOptionName))) {
			selectedOptions = (List<Long>) req.getAttribute(selectedOptionName);
		}
		String languageId = LanguageUtil.getLanguageId(req);
		int pos = languageId.indexOf(CharPool.UNDERLINE);
		Locale locale = LocaleUtil.getDefault();
		if (pos >= 0) {
			String language = languageId.substring(0, pos);
			locale = LocaleUtil.fromLanguageId(language);
		}
		for (Country country : items) {
			String str = "<option value='" + country.getCountryId() + "'";
			if (Validator.isNotNull(selectedOptions) && selectedOptions.contains(country.getCountryId()))
				str += " selected ";
			str += ">" + StringUtil.upperCaseFirstLetter(country.getName(locale)) + "</option>";
			out.print(str);
		}
	}

	@SuppressWarnings("unchecked")
	public static void createJsonSelectOptions(String jsonOptionsList, String selectedValueAttrib, RenderRequest req,
			JspWriter out) {
		try {
			String selectOptionFormat = "<option value='%s' %s>%s</option>";
			JSONArray items = (JSONArray) req.getAttribute(jsonOptionsList);
			List<String> selectedOptions = null;
			if (Validator.isNotNull(req.getAttribute(selectedValueAttrib))) {
				selectedOptions = (List<String>) req.getAttribute(selectedValueAttrib);
			}
			for (int i = 0; i < items.length(); i++) {
				JSONObject o = items.getJSONObject(i);
				String value = o.getString("value");
				String label = o.getString("label");
				if (Validator.isNotNull(selectedOptions) && selectedOptions.contains(value)) {
					out.print(String.format(selectOptionFormat, value, "selected", label));
				} else {
					out.print(String.format(selectOptionFormat, value, "", label));
				}
			}
		} catch (Exception e) {
			logger.warn("Error generating selct options.", e);
		}
	}

}