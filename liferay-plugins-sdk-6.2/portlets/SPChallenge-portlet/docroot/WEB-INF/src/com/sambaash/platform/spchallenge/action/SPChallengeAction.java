package com.sambaash.platform.spchallenge.action;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.WindowState;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.facebook.FacebookConnectUtil;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.JavaConstants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.security.auth.AuthTokenUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.service.UserNotificationEventLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.model.AssetVocabulary;
import com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetVocabularyLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.sambaash.platform.spchallenge.helper.ChallengeFormHelper;
import com.sambaash.platform.spchallenge.helper.SPChallengeConstants;
import com.sambaash.platform.spchallenge.helper.SPChallengeDLHelper;
import com.sambaash.platform.spchallenge.helper.SPChallengeHelper;
import com.sambaash.platform.spchallenge.helper.SPChallengeMailHelper;
import com.sambaash.platform.spchallenge.helper.SPChallengePermissionHelper;
import com.sambaash.platform.spchallenge.listener.ChallengeListener;
import com.sambaash.platform.spchallenge.notification.SPChallengeNotificationConstants;
import com.sambaash.platform.srv.spchallenge.model.SPChallenge;
import com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant;
import com.sambaash.platform.srv.spchallenge.service.SPChallengeApplicantLocalServiceUtil;
import com.sambaash.platform.srv.spchallenge.service.SPChallengeLocalServiceUtil;
import com.sambaash.platform.srv.spservices.model.SPParameter;
import com.sambaash.platform.srv.spservices.service.SPParameterLocalServiceUtil;
import com.sambaash.platform.srv.startupprofile.model.Organization;
import com.sambaash.platform.srv.startupprofile.service.OrganizationLocalServiceUtil;
import com.sambaash.platform.util.LabelUtil;
import com.sambaash.platform.util.SambaashUtil;
import com.sambaash.platform.util.SocialNetworkUtils;

/**
 * Portlet implementation class SPChallengeAction
 */
public class SPChallengeAction extends MVCPortlet {

	private static final String PAGE_APPLY = "/html/spchallenge/applyChallenge.jsp";
	private static final String PAGE_ADD_CHALLENGE = "/html/spchallenge/addOrEditChallenge.jsp";
	private static final String PAGE_DISP_CHALLENGE = "/html/spchallenge/displayChallenge.jsp";
	private static final String PAGE_DISP_APPLICANT = "/html/spchallenge/displayApplicant.jsp";
	private static final String PAGE_ERROR = "/html/common/error.jsp";

	private static final Log logger = LogFactoryUtil.getLog(SPChallengeAction.class);

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		String action = renderRequest.getParameter("actionp");

		if (Validator.isNotNull(action)) {
			String renderPage = handleFriendlyUrlRouting(renderRequest, renderResponse, action);
			include(renderPage, renderRequest, renderResponse);
			return;
		}
		// default listing
//		ChallengeFormHelper.fillCategoriesChallenge(renderRequest, null);
		super.doView(renderRequest, renderResponse);
	}

	@SuppressWarnings("unchecked")
	public void uploadLogoForLowerVersionBrowsers(ActionRequest request, ActionResponse response) throws Exception {
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			logger.debug("Uploading logo for challenge, userId =  " + themeDisplay.getUserId());

			Object objs[] = null;
			FileEntry fe = null;
			try {
				objs = SPChallengeDLHelper.parseFileUploadRequest(request, response);
				Map<String, String> paramMap = (Map<String, String>) objs[0];
				String challengeId = paramMap.get(response.getNamespace() + "challengeId");
				prepareAddChallenge(challengeId, request);

				List<FileItem> files = (List<FileItem>) objs[1];
				if (Validator.isNotNull(files) && !files.isEmpty()) {
					if (SPChallengeDLHelper.isLogoTypAllowed(files.get(0).getContentType())) {
						fe = SPChallengeDLHelper.uploadLogoToTemp(request, files.get(0));
						if (Validator.isNotNull(fe)) {
							String logoUrl = SambaashUtil.getDLFileUrl(request, fe.getFileEntryId());
							// Logo url should set after showAddStartup to
							// override the url attribute in request
							request.setAttribute(SPChallengeConstants.LOGO_URL, logoUrl);
							logger.info("logo uploaded for by user = " + themeDisplay.getUserId() + " logoUrl = "
									+ logoUrl);
						} else {
							request.setAttribute("logoError", SPChallengeConstants.MSG_LOGO_ERROR);
						}
					} else {
						request.setAttribute("logoError", SPChallengeConstants.MSG_LOGO_ERROR);
					}
				}
				request.setAttribute("lowerVBrowser", "true");

			} catch (FileUploadException e) {
				logger.error("Error while parsing file upload request" + e.getMessage());
			}
		} catch (Exception e) {
			logger.error("Error while fetching users");
		}
		response.setWindowState(WindowState.MAXIMIZED);
		response.setRenderParameter("jspPage", PAGE_ADD_CHALLENGE);
	}

	protected String handleFriendlyUrlRouting(PortletRequest request, PortletResponse response, String action) {
		long orgId = ParamUtil.getLong(request, SPChallengeConstants.ORGANIZATION_ID);
		long challengeId = ParamUtil.getLong(request, SPChallengeConstants.CHALLENGE_ID);
		long applicantId = ParamUtil.getLong(request, SPChallengeConstants.CHALLENGE_APPLICANT_ID);

		if (action.equals(SPChallengeConstants.PARAM_DISPLAY_CHALLENGE) || SPChallengeConstants.PARAM_APPLY_TO_CHALLENGE.equals(action)) {
			try {
				if (prepareAddChallenge(ParamUtil.getString(request, SPChallengeConstants.CHALLENGE_ID), request)) {
					prepareDisplayChallenge(request);
					addSocialShareAttributes(request, SPChallengeLocalServiceUtil.getSPChallenge(challengeId));
					request.setAttribute("apply_internal", "false");
					request.setAttribute("apply_external", "false");
					if (SPChallengeConstants.PARAM_APPLY_TO_CHALLENGE.equals(action)) {
						String applyType = request.getParameter("type");
						request.setAttribute("apply_"+applyType, "true");						
					}
				} else {
					return PAGE_ERROR;
				}
			} catch (Exception e) {
				logger.error("Unable to add social share attributes", e);
				return PAGE_ERROR;
			}
			return PAGE_DISP_CHALLENGE;
		} else if (action.equals(SPChallengeConstants.PARAM_VIEW_APPLICATION)) {

			if (!SPChallengePermissionHelper.authorize(request, SPChallengeConstants.PORTLET_ID,
					SPChallengeConstants.ACTION_VIEW_APPLICATION)) {
				return PAGE_ERROR;
			}

			if (Validator.isNull(ParamUtil.getLong(request, SPChallengeConstants.CHALLENGE_APPLICANT_ID)))
				return PAGE_ERROR;
			prepareApplyChallenge(request);
			prepareDisplayApplicant(request);
			return PAGE_DISP_APPLICANT;
		} else if (action.equals(SPChallengeConstants.PARAM_EDIT_APPLICATION)
				|| action.equals(SPChallengeConstants.PARAM_APPLY_CHALLENGE)) {

			if (action.equals(SPChallengeConstants.PARAM_EDIT_APPLICATION)) {
				// As of now implemented like, only marketer or admin can update
				// application
				if (!SPChallengePermissionHelper.canUpdateApplication(request, applicantId)) {
					return PAGE_ERROR;
				}
			}
			if (action.equals(SPChallengeConstants.PARAM_APPLY_CHALLENGE)) {
				if (!SPChallengePermissionHelper.canApplyChallenge(request, orgId, challengeId)) {
					return PAGE_ERROR;
				}
			}
			prepareApplyChallenge(request);
			return PAGE_APPLY;
		} else if (action.equals(SPChallengeConstants.PARAM_EDIT_CHALLENGE)
				|| action.equals(SPChallengeConstants.PARAM_CREATE_CHALLENGE)) {
			if (action.equals(SPChallengeConstants.PARAM_EDIT_CHALLENGE)) {
				if (!SPChallengePermissionHelper.canUpdateChallenge(request, challengeId)) {
					return PAGE_ERROR;
				}
			}
			if (action.equals(SPChallengeConstants.PARAM_CREATE_CHALLENGE)) {
				if (!SPChallengePermissionHelper.canCreateChallenge(request)) {
					return PAGE_ERROR;
				}
			}
			try {
				boolean exists = prepareAddChallenge(ParamUtil.getString(request, SPChallengeConstants.CHALLENGE_ID),
						request);
				if (!exists && action.equals(SPChallengeConstants.PARAM_EDIT_CHALLENGE)) {
					return PAGE_ERROR;
				}
			} catch (Exception e) {
				logger.error("Error while adding challenge", e);
			}
			return PAGE_ADD_CHALLENGE;
		}
		logger.error("Invalid param for friendly url action = " + action);
		return null;
	}

	private void addSocialShareAttributes(PortletRequest request, SPChallenge challenge) {
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		int pos = GetterUtil.getInteger(request.getParameter(SPChallengeConstants.POSITION_INDEX));
		String friendlyUrl = SPChallengeHelper.displayChallengeFriendlyURL(themeDisplay, challenge.getSpChallengeId(),
				"" + pos);

		SocialNetworkUtils.addSocialShareAttributes(request, challenge.getName(), challenge.getBackground(),
				friendlyUrl, "Challenge", SocialNetworkUtils.TWITTER_TYPE_SUMMARY_LARGE_IMAGE, challenge.getLogoId());
	}

	private void prepareDisplayApplicant(PortletRequest request) {
		Long applicantId = ParamUtil.getLong(request, SPChallengeConstants.CHALLENGE_APPLICANT_ID);
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		if (Validator.isNull(applicantId)) {
			logger.warn("Missing applicant Id");
			return;
		}
		try {
			SPChallengeApplicant applicant = SPChallengeApplicantLocalServiceUtil.getSPChallengeApplicant(applicantId);
			if (Validator.isNull(applicant)) {
				logger.warn("No applicant id with Id " + applicantId);
				return;
			}
			request.setAttribute(SPChallengeConstants.ATTRIB_CHALLENGE_APPLICANT,
					HtmlUtil.stripHtml(JSONFactoryUtil.looseSerializeDeep(applicant)));
			SPChallenge challenge = SPChallengeLocalServiceUtil.getSPChallenge(applicant.getSpChallengeId());
			Organization org = OrganizationLocalServiceUtil.fetchOrganization(applicant.getApplicantRefId());
			request.setAttribute(SPChallengeConstants.ORGANIZATION_NAME, org.getName());
			request.setAttribute(SPChallengeConstants.LOGO_URL, SambaashUtil.getDLFileUrl(request, org.getLogoId()));

			request.setAttribute(SPChallengeConstants.CHALLENGE_NAME, challenge.getName());
			request.setAttribute(SPChallengeConstants.FRIENDLY_URL, SPChallengeHelper
					.displayChallengeFriendlyURL(themeDisplay, challenge.getSpChallengeId(), StringPool.DASH));
			request.setAttribute("startupUrl",
					SPChallengeHelper.displayStartupProfileFriendlyURL(themeDisplay, org.getOrganizationId()));
			request.setAttribute("applicationDate",
					DateUtil.getDate(applicant.getCreateDate(), "MMM dd, yyyy", Locale.ENGLISH));
		} catch (Exception ee) {
			logger.error("Error while getting challengeApplicant", ee);
		}

	}

	private void prepareDisplayChallenge(PortletRequest request) {
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		HttpServletRequest req = PortalUtil.getHttpServletRequest(request);
		HttpServletRequest Httprequest = PortalUtil.getOriginalServletRequest(req);

		try {
			Long challengeId = ParamUtil.getLong(request, SPChallengeConstants.CHALLENGE_ID);
			request.setAttribute(SPChallengeConstants.CHALLENGE_ID, challengeId);
			SPChallenge challenge = SPChallengeLocalServiceUtil.getSPChallenge(challengeId);
			request.setAttribute(SPChallengeConstants.CHALLENGE_NAME, HtmlUtil.stripHtml(challenge.getName()));

			if (Validator.isNotNull(challenge.getBudget()) && !challenge.getBudget().equals("0")) {
				request.setAttribute("challengeBudget", SambaashUtil.formattedAmount(challenge.getBudget()));
				request.setAttribute("challengeBudgetCcySign", challenge.getBudgetCcySign());
			}
			Date now = new Date();
			int challengeDaysLeft = DateUtil.getDaysBetween(now, challenge.getEndDate());
			if (now.getTime() > challenge.getEndDate().getTime() && challengeDaysLeft>0) {
				challengeDaysLeft=0;
			}
			request.setAttribute("challengeDaysLeft", challengeDaysLeft);

			boolean canEdit = SPChallengePermissionHelper.canUpdateChallenge(request, challengeId);
			if (canEdit)
				request.setAttribute(SPChallengeConstants.FRIENDLY_EDIT_URL,
						SPChallengeHelper.editChallengeFriendlyURL(themeDisplay, challengeId));
			boolean canApply = false;
			try {
				Date date = new Date();
				canApply = DateUtils.isSameDay(date, challenge.getStartDate())
						|| DateUtils.isSameDay(date, challenge.getEndDate())
						|| (date.after(challenge.getStartDate()) && date.before(challenge.getEndDate()));
				request.setAttribute("canApply", canApply);
				logger.debug("challenge start/endDate/canApply = " + challenge.getStartDate() + ","
						+ challenge.getEndDate() + "," + canApply);
			} catch (Exception e) {
				logger.warn("Error checking dates" + challenge.getStartDate() + challenge.getEndDate(), e);
			}

			SPChallengeHelper.prepareNextPrevUrls(request, themeDisplay);

			AssetEntry assetEntry = AssetEntryLocalServiceUtil.fetchEntry(SPChallenge.class.getName(), challengeId);
			List<String> challengeTypeList = new ArrayList<String>();
			if (Validator.isNotNull(assetEntry)) {
				List<AssetCategory> assets = assetEntry.getCategories();
				PortletPreferences preferences = request.getPreferences();
				for (AssetCategory assetCategory : assets) {
					if (Long.valueOf(preferences.getValue(SPChallengeConstants.VOC_CHALLENGE_COLLAB_TYPE_ID, "0"))
							.equals(assetCategory.getVocabularyId())) {
						if (canApply) {
							String temp = GetterUtil.getString(preferences
									.getValue(getCollabTypePrefKey(assetCategory.getCategoryId()), StringPool.BLANK));
							if (temp.toLowerCase().contains(SPChallengeConstants.COLLAB_TYPE_EXTERRNAL)) {
								request.setAttribute("canApplyOpen", true);
							}
							if (temp.toLowerCase().contains(SPChallengeConstants.COLLAB_TYPE_INTERNAL)) {
								request.setAttribute("canApplyClosed", true);
							}
						}
					} else if (Long.valueOf(preferences.getValue(SPChallengeConstants.VOC_CHALLENGE_TYPE_ID, "0"))
							.equals(assetCategory.getVocabularyId())) {
						challengeTypeList.add(assetCategory.getName());
					}
				}

			}
			request.setAttribute("challengeTypeList", challengeTypeList);
			PortalUtil.setPageSubtitle(HtmlUtil.stripHtml(challenge.getName()), Httprequest);
			PortalUtil.setPageDescription(HtmlUtil.stripHtml(challenge.getDescription()), Httprequest);
			
			request.setAttribute("ogtitle",HtmlUtil.stripHtml(challenge.getName()));
			request.setAttribute("ogdescription", HtmlUtil.stripHtml(challenge.getDescription()));
			try {
				request.setAttribute("ogurl", URLEncoder.encode(themeDisplay.getPortalURL() + themeDisplay.getURLCurrent(), "UTF-8"));
				request.setAttribute("fbappid",FacebookConnectUtil.getAppId(themeDisplay.getCompanyId()));
			} catch (UnsupportedEncodingException | SystemException e) {
				logger.error(e.getMessage());
			}

		} catch (Exception e) {
			logger.error("Error while preparing for display challenge", e);
		}
	}

	private void prepareApplyChallenge(PortletRequest request) {
		Long orgId = ParamUtil.getLong(request, SPChallengeConstants.ORGANIZATION_ID);
		Long challengeId = ParamUtil.getLong(request, SPChallengeConstants.CHALLENGE_ID);
		Long applicantId = ParamUtil.getLong(request, SPChallengeConstants.CHALLENGE_APPLICANT_ID);
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

		logger.debug("apply for [chalId, orgId, applId] =" + challengeId + orgId + applicantId);
		if (applicantId == 0) {
			SPChallengeApplicant applicant = SPChallengeApplicantLocalServiceUtil
					.findByChallengeIdApplicantRefId(challengeId, orgId);
			if (Validator.isNotNull(applicant)) {
				applicantId = applicant.getSpChallengeApplicantId();
				logger.error("!!!! trying to edit application !!!!! applicant already exists = " + applicantId);
			}
		}

		ChallengeFormHelper.fillCategoriesApplication(request, applicantId, orgId);

		SPChallengeApplicant applicant = null;
		if (Validator.isNotNull(applicantId)) {
			try {
				applicant = SPChallengeApplicantLocalServiceUtil.getSPChallengeApplicant(applicantId);
				challengeId = applicant.getSpChallengeId();
				orgId = applicant.getApplicantRefId();
			} catch (Exception ee) {
				logger.error("Error while getting challengeApplicant", ee);
			}
		}

		if (Validator.isNotNull(orgId) && Validator.isNotNull(challengeId)) {
			try {
				long organizationId = Long.valueOf(orgId);
				Map<String, Object> existingMap = OrganizationLocalServiceUtil.createOrgDataMap(organizationId);

				Set<Entry<String, Object>> entrySet = existingMap.entrySet();
				for (Entry<String, Object> entry : entrySet) {
					request.setAttribute(entry.getKey(),
							HtmlUtil.stripHtml(JSONFactoryUtil.looseSerializeDeep(entry.getValue())));
				}

				if (Validator.isNotNull(applicant)) {
					request.setAttribute(SPChallengeConstants.ATTRIB_CHALLENGE_APPLICANT,
							HtmlUtil.stripHtml(JSONFactoryUtil.looseSerializeDeep(applicant)));
				}

				request.setAttribute(SPChallengeConstants.ATTRIB_CHALLENGE, HtmlUtil.stripHtml(JSONFactoryUtil
						.looseSerializeDeep(SPChallengeLocalServiceUtil.getSPChallenge(Long.valueOf(challengeId)))));
				request.setAttribute(SPChallengeConstants.FRIENDLY_URL,
						SPChallengeHelper.editOrgFriendlyURL(themeDisplay, orgId));
			} catch (Exception e) {
				logger.error("Error while fetching data for orgId" + orgId, e);
			}
		} else {
			logger.error("Organization/Challenge not found" + challengeId + orgId + applicantId);
		}

	}

	/**
	 * Returns false if the challenge doesnt exists and true if it does.
	 */
	private boolean prepareAddChallenge(String challengeId, PortletRequest request) throws Exception {
		ChallengeFormHelper.fillCategoriesChallenge(request, challengeId);

		if (Validator.isNotNull(challengeId)) {
			try {
				ChallengeFormHelper helper = new ChallengeFormHelper();
				helper.addChallengeDataToRequest(request, GetterUtil.getLong(challengeId));
				SPChallenge challenge = SPChallengeLocalServiceUtil.getSPChallenge(GetterUtil.getLong(challengeId));
				request.setAttribute(SPChallengeConstants.LOGO_URL,
						SambaashUtil.getDLFileUrl(request, challenge.getLogoId()));
				return true;
			} catch (Exception e) {
				logger.error("Error while fetching data for challengeId" + challengeId, e);
				throw e;
			}
		}
		return false;
	}

	public void showAddChallenge(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		prepareAddChallenge(ParamUtil.getString(actionRequest, SPChallengeConstants.CHALLENGE_ID), actionRequest);
		actionResponse.setWindowState(WindowState.MAXIMIZED);
		actionResponse.setRenderParameter("jspPage", PAGE_ADD_CHALLENGE);
	}

	public void showApplyChallenge(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		prepareApplyChallenge(actionRequest);
		actionResponse.setWindowState(WindowState.MAXIMIZED);
		actionResponse.setRenderParameter("jspPage", PAGE_APPLY);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException {

		Object multiPartData[] = new Object[2];
		HttpServletRequestWrapper httpRequest = null;
		if (ServletFileUpload.isMultipartContent(PortalUtil.getHttpServletRequest(resourceRequest))) {
			try {
				multiPartData = SPChallengeDLHelper.parseFileUploadRequest(resourceRequest, resourceResponse);
				httpRequest = SPChallengeHelper.getHttpRequestWrapperMultiPart(resourceRequest,
						((Map<String, String>) multiPartData[0]));
			} catch (Exception e) {
				logger.error(e.getMessage());
			}

		} else {
			httpRequest = SPChallengeHelper.getHttpRequestWrapper(resourceRequest);
		}

		try {
			AuthTokenUtil.checkCSRFToken(httpRequest, SPChallengeAction.class.getName());
		} catch (PortalException e1) {
			JSONObject obj = JSONFactoryUtil.createJSONObject();
			obj.put(SPChallengeConstants.ERROR_MSG, SPChallengeConstants.MSG_UNAUTH);
			logger.error("Error Authenticating user", e1);
			resourceResponse.getWriter().write(obj.toString());
			return;
		}

		String action = ParamUtil.getString(resourceRequest, SPChallengeConstants.ACTION);
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		PortletConfig portletConfig = (PortletConfig) resourceRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
		String errorMsg = LabelUtil.getLabel(portletConfig,themeDisplay,"label.error.applying.for.challenge");
		String alreadyAppliedMsg = LabelUtil.getLabel(portletConfig,themeDisplay,"label.already.applied");
		String incompletMsg = LabelUtil.getLabel(portletConfig,themeDisplay,"label.incomplete");
		if (action.equals(SPChallengeConstants.ACTION_FILTER_RESULTS)) {
			PortletPreferences preferences = resourceRequest.getPreferences();
			JSONObject obj = SPChallengeHelper.handleSearch(resourceRequest,
					Integer.parseInt(preferences.getValue(SPChallengeConstants.VOC_ITEMS_PER_PAGE, "6")));
			resourceResponse.getWriter().write(HtmlUtil.stripHtml(obj.toString()));
		} else if (action.equals(SPChallengeConstants.ACTION_GET_SIMILAR_CHALLENGES)) {
			JSONObject obj = null;
			try {
				PortletPreferences preferences = resourceRequest.getPreferences();
				String cats = StringPool.BLANK;
				long challengeId = ParamUtil.getLong(resourceRequest, SPChallengeConstants.CHALLENGE_ID);
				AssetEntry assetEntry = AssetEntryLocalServiceUtil.fetchEntry(SPChallenge.class.getName(), challengeId);
				if (Validator.isNotNull(assetEntry)) {
					List<AssetCategory> assets = assetEntry.getCategories();
					for (AssetCategory assetCategory : assets) {
						if (Long.valueOf(preferences.getValue(SPChallengeConstants.VOC_CHALLENGE_CATEGORY_ID, "0"))
								.equals(assetCategory.getVocabularyId())) {
							cats += assetCategory.getCategoryId() + " ";
						} else if (Long.valueOf(preferences.getValue(SPChallengeConstants.VOC_CHALLENGE_TYPE_ID, "0"))
								.equals(assetCategory.getVocabularyId())) {
							cats += assetCategory.getCategoryId() + " ";
						}
					}
				}

				String query = "(assetCategoryIds:(%s))";
				if (Validator.isNull(cats)) {
					query = null;
				} else {
					query = String.format(query, cats);
				}
				obj = SPChallengeHelper.handleSearch(null, query, 1, 2, SPChallengeConstants.ATTRIB_CHALLENGE,
						resourceRequest);
				resourceResponse.getWriter().write(HtmlUtil.stripHtml(obj.toString()));
			} catch (Exception e) {
				logger.error("Error getting similar challenges for challenge", e);
				obj.put(SPChallengeConstants.ERROR_MSG, errorMsg);
				resourceResponse.getWriter().write(SPChallengeConstants.FAIL);
			}
		} else if (action.equals(SPChallengeConstants.ACTION_CHLG_APPLICATION_SAVE)) {
			SPChallengeApplicant challengeApplicant = null;
			JSONObject obj = JSONFactoryUtil.createJSONObject();
			try {
				long applicantId = ParamUtil.getLong(resourceRequest, SPChallengeConstants.CHALLENGE_APPLICANT_ID);
				long orgId = ParamUtil.getLong(resourceRequest, SPChallengeConstants.ORGANIZATION_ID);
				long challengeId = ParamUtil.getLong(resourceRequest, SPChallengeConstants.CHALLENGE_ID);

				boolean authorize = false;
				if (applicantId == 0) {
					if (SPChallengePermissionHelper.canApplyChallenge(resourceRequest, orgId, challengeId)) {
						authorize = true;
					}
				} else {
					if (SPChallengePermissionHelper.canUpdateApplication(resourceRequest, applicantId)) {
						authorize = true;
					}
				}

				if (!authorize) {
					obj.put(SPChallengeConstants.ERROR_MSG, SPChallengeConstants.MSG_UNAUTH);
					resourceResponse.getWriter().write(obj.toString());
					return;
				}
				Organization org = OrganizationLocalServiceUtil.getOrganization(orgId);
				if (!org.getCompleteness()) {
					obj.put(SPChallengeConstants.ERROR_MSG, SPChallengeConstants.MSG_ORG_INCOMPLETE);
					resourceResponse.getWriter().write(obj.toString());
					logger.error(
							"User trying to apply with incomplete organization, challengeId" + orgId + challengeId);
					return;
				}
				ChallengeFormHelper formHelper = new ChallengeFormHelper();
				challengeApplicant = formHelper.saveChallengeApplicationFormData(resourceRequest);
				// Send notification to startup who applied for
				// challenge
				SPChallengeMailHelper.sendMailToApplicant(challengeApplicant, themeDisplay,resourceRequest);
				// Send notification to configured users
				SPChallengeMailHelper.sendMailToChallengeCreator(challengeApplicant, themeDisplay);
				resourceResponse.getWriter().write(SPChallengeConstants.SUCCESS);

				addNotifications(resourceRequest, themeDisplay, challengeId, org, challengeApplicant);

			} catch (Exception e) {
				logger.error("Error applying for challenge", e);
				obj.put(SPChallengeConstants.ERROR_MSG, errorMsg);
				resourceResponse.getWriter().write(SPChallengeConstants.FAIL);
			}
		} else if (action.equals(SPChallengeConstants.ACTION_CHLG_SAVE)) {
			SPChallenge challenge = null;
			JSONObject obj = JSONFactoryUtil.createJSONObject();
			try {
				long spChallengeId = ParamUtil.getLong(resourceRequest, SPChallengeConstants.CHALLENGE_ID);
				boolean authorized = false;
				if (spChallengeId == 0) {
					if (SPChallengePermissionHelper.canCreateChallenge(resourceRequest)) {
						authorized = true;
					}
				} else {
					if (SPChallengePermissionHelper.canUpdateChallenge(resourceRequest, spChallengeId)) {
						authorized = true;
					}
				}

				if (!authorized) {
					obj.put(SPChallengeConstants.ERROR_MSG, SPChallengeConstants.MSG_UNAUTH);
					resourceResponse.getWriter().write(obj.toString());
					return;
				}

				ChallengeFormHelper formHelper = new ChallengeFormHelper();
				challenge = formHelper.saveChallengeFormData(resourceRequest);
				if (Validator.isNull(challenge))
					return;
				long logoId = challenge.getLogoId();
				boolean removeLogo = ParamUtil.getBoolean(resourceRequest, "removeLogo");
				String challengeLogo = resourceRequest.getParameter("challengeLogo");
				if (removeLogo) {
					if (logoId != 0) {
						challenge.setLogoId(0);
						SPChallengeLocalServiceUtil.updateSPChallenge(challenge);
					}
				} else if(StringUtils.isNotEmpty(challengeLogo)) {
					// only add or update when logo field is not empty
					try {
						// Move logo from temp folder to actual folder
						FileEntry fe = SPChallengeDLHelper.updateOrMoveLogo(resourceRequest, logoId);
						if (Validator.isNotNull(fe) && logoId != fe.getFileEntryId()) {
							/*
							 * This snippets executes only first time (or) when
							 * logo deletion followed by logo upload logo
							 * uploaded for challenge. FileEntryId will not
							 * change if existinglogo updated to new.
							 */
							challenge.setLogoId(fe.getFileEntryId());
							SPChallengeLocalServiceUtil.updateSPChallenge(challenge);
						}
					} catch (Exception e) {
						logger.error("Error while uploading logo" + e.getMessage());
					}
				}
				resourceResponse.getWriter().write(SPChallengeConstants.SUCCESS);
				try {
					ChallengeListener.onAfterUpdate(challenge);
				} catch (Exception e) {
				}
			} catch (Exception e) {
				logger.error("Error while saving challenge", e);
				resourceResponse.getWriter().write(SPChallengeConstants.FAIL);
			}
		} else if (action.equalsIgnoreCase(SPChallengeConstants.ACTION_GET_APPLY_INFOS)) {
			Long userId = themeDisplay.getUserId();
			List<Organization> orgs = null;
			Long challengeId = ParamUtil.getLong(resourceRequest, SPChallengeConstants.CHALLENGE_ID);
			try {
				orgs = OrganizationLocalServiceUtil.getUserOrganizations(userId);
			} catch (Exception e) {
				logger.error("Error getting user organziaitons");
			}
			if (orgs == null) {
				logger.warn("orgs are empty");
				return;
			}
			JSONArray array = JSONFactoryUtil.createJSONArray();
			for (Organization organization : orgs) {
				JSONObject obj = JSONFactoryUtil.createJSONObject();
				String orgName = HtmlUtil.stripHtml(organization.getName());
				if (organization.getCompleteness()) {
					if (SPChallengeHelper.hasUserAppliedForChallenge(challengeId, organization.getOrganizationId())) {
						obj.put(SPChallengeConstants.NAME, orgName + " ( " + alreadyAppliedMsg + ")");
					} else {
						obj.put(SPChallengeConstants.NAME, orgName);
						obj.put(SPChallengeConstants.FRIENDLY_URL, SPChallengeHelper.applyChallengeFriendlyURL(
								themeDisplay, challengeId, organization.getOrganizationId()));
					}
				} else {
					obj.put(SPChallengeConstants.NAME, orgName + " (" + incompletMsg + ")");
					obj.put(SPChallengeConstants.FRIENDLY_URL,
							SPChallengeHelper.editOrgFriendlyURL(themeDisplay, organization.getOrganizationId()));
				}
				obj.put(SPChallengeConstants.ORGANIZATION_ID, organization.getOrganizationId());
				array.put(obj);
			}
			if (array.length() < 1) {
				JSONObject obj = JSONFactoryUtil.createJSONObject();
				obj.put(SPChallengeConstants.FRIENDLY_URL, SPChallengeHelper.createOrgFriendlyURL(themeDisplay));
				obj.put("noOrgs", "true");
				resourceResponse.getWriter().write(obj.toString());
			} else {
				resourceResponse.getWriter().write(array.toString());
			}
		} else if (action.equalsIgnoreCase(SPChallengeConstants.ACTION_MAIL_ID_SUGGESTIONS)
				|| action.equalsIgnoreCase(SPChallengeConstants.ACTION_SCOUT_SUGGESTIONS)) {

			resourceResponse.setContentType("application/json");
			resourceResponse.setCharacterEncoding("utf-8");
			try {
				resourceResponse.getWriter()
						.write(SPChallengeHelper.findUsers(resourceRequest, themeDisplay.getCompanyId()));
			} catch (Exception e) {
				logger.error("Error while fetching users", e);
			}
		} else if (action.equalsIgnoreCase(SPChallengeConstants.ACTION_REMOVE_LOGO)) {

		} else {
			// Any file uploads will be handled by this block
			try {
				FileEntry fe = null;
				JSONObject obj = JSONFactoryUtil.createJSONObject();
				if (ArrayUtil.isNotEmpty(multiPartData)) {
					List<FileItem> files = (List<FileItem>) multiPartData[1];
					if (Validator.isNotNull(files) && !files.isEmpty()) {
						if (SPChallengeDLHelper.isLogoTypAllowed(files.get(0).getContentType())) {
							fe = SPChallengeDLHelper.uploadLogoToTemp(resourceRequest, files.get(0));
						}
					}
				}
				if (Validator.isNotNull(fe)) {
					String logoUrl = SambaashUtil.getDLFileUrl(resourceRequest, fe.getFileEntryId());
					obj.put(SPChallengeConstants.LOGO_URL, logoUrl);
					obj.put(SPChallengeConstants.FILE_ENTRY_ID, fe.getFileEntryId());
				} else {
					obj.put(SPChallengeConstants.ERROR_MSG, SPChallengeConstants.MSG_LOGO_ERROR);
				}
				resourceResponse.getWriter().write(obj.toString());
			} catch (Exception e) {
				logger.error("Error while uploading images", e);
			}
		}
	}

	private void addNotifications(PortletRequest resourceRequest, ThemeDisplay themeDisplay, long challengeId,
			Organization org, SPChallengeApplicant challengeApplicant) {
		try {
			JSONObject payloadJSON = JSONFactoryUtil.createJSONObject();
			payloadJSON.put(Field.USER_ID, themeDisplay.getUserId());
			payloadJSON.put(SPChallengeNotificationConstants.USER_NAME, org.getName());
			SPChallenge challenge = SPChallengeLocalServiceUtil.getSPChallenge(challengeId);
			payloadJSON.put(SPChallengeNotificationConstants.TITLE, challenge.getName());
			payloadJSON.put(SPChallengeNotificationConstants.NOTIFICATION_TYPE,
					SPChallengeNotificationConstants.NOTIFICATION_TYPE_CHALLENGE_APPLIED);
			payloadJSON.put(SPChallengeNotificationConstants.STARTUP_LINK, SPChallengeHelper
					.displayApplicationFriendlyURL(themeDisplay, challengeApplicant.getSpChallengeApplicantId()));
			payloadJSON.put(SPChallengeNotificationConstants.LINK,
					SPChallengeHelper.displayChallengeFriendlyURL(themeDisplay, challengeId, StringPool.DASH));
			ServiceContext serviceContext = ServiceContextFactory.getInstance(resourceRequest);
			String emailStr = GetterUtil.getString(challenge.getNotifyTo());
			if (Validator.isNotNull(emailStr)) {
				String[] emailIds = emailStr.split(StringPool.SEMICOLON);
				for (int i = 0; i < emailIds.length; i++) {
					try {
						User user = UserLocalServiceUtil.getUserByEmailAddress(themeDisplay.getCompanyId(),
								emailIds[i]);
						UserNotificationEventLocalServiceUtil.addUserNotificationEvent(user.getUserId(),
								SPChallengeConstants.PORTLET_ID, DateUtil.newTime(), themeDisplay.getUserId(),
								payloadJSON.toString(), false, serviceContext);
					} catch (Exception e) {
						logger.error("Error sending notification", e);
					}
				}
			}
			try {
				long[] userIds = SPChallengeHelper.getFoundryAdminIds(themeDisplay);
				if (Validator.isNotNull(userIds)) {
					for (int i = 0; i < userIds.length; i++) {
						UserNotificationEventLocalServiceUtil.addUserNotificationEvent(userIds[i],
								SPChallengeConstants.PORTLET_ID, DateUtil.newTime(), themeDisplay.getUserId(),
								payloadJSON.toString(), false, serviceContext);
					}
				}
			} catch (Exception e) {
				logger.error("Error sending notification to foundry admin", e);
			}
		} catch (Exception e) {

		}

	}

	// prefs code

	@Override
	public void doEdit(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		try {
			PortletPreferences preferences = renderRequest.getPreferences();

			renderRequest.setAttribute(SPChallengeConstants.VOC_APPLICANT_TYPE_ID,
					preferences.getValue(SPChallengeConstants.VOC_APPLICANT_TYPE_ID, "0"));
			renderRequest.setAttribute(SPChallengeConstants.VOC_CHALLENGE_CATEGORY_ID,
					preferences.getValue(SPChallengeConstants.VOC_CHALLENGE_CATEGORY_ID, "0"));
			renderRequest.setAttribute(SPChallengeConstants.VOC_CHALLENGE_TYPE_ID,
					preferences.getValue(SPChallengeConstants.VOC_CHALLENGE_TYPE_ID, "0"));
			renderRequest.setAttribute(SPChallengeConstants.VOC_REGION_TYPE_ID,
					preferences.getValue(SPChallengeConstants.VOC_REGION_TYPE_ID, "0"));
			String challengeCollabVocId = preferences.getValue(SPChallengeConstants.VOC_CHALLENGE_COLLAB_TYPE_ID, "0");
			renderRequest.setAttribute(SPChallengeConstants.VOC_CHALLENGE_COLLAB_TYPE_ID, challengeCollabVocId);
			List<Map<String, String>> list = new ArrayList<Map<String, String>>();
			Map<String, String> map;
			String props;
			List<AssetCategory> ctypes = SambaashUtil.getCategories(GetterUtil.getLong(challengeCollabVocId));
			for (AssetCategory assetCategory : ctypes) {
				props = preferences.getValue(getCollabTypePrefKey(assetCategory.getCategoryId()), StringPool.BLANK);
				map = new HashMap<String, String>();
				map.put("id", String.valueOf(assetCategory.getCategoryId()));
				map.put("name", assetCategory.getName());
				if (props.contains(SPChallengeConstants.COLLAB_TYPE_INTERNAL)) {
					map.put("internal", "true");
				}
				if (props.contains(SPChallengeConstants.COLLAB_TYPE_EXTERRNAL)) {
					map.put("external", "true");
				}
				map.put("props", props);
				list.add(map);
			}
			renderRequest.setAttribute("challengeCollabCats", list);
			renderRequest.setAttribute(SPChallengeConstants.VOC_ORG_INCORPORATED_STATUS_ID,
					preferences.getValue(SPChallengeConstants.VOC_ORG_INCORPORATED_STATUS_ID, "0"));
			renderRequest.setAttribute(SPChallengeConstants.VOC_CHALLENGE_COLLAB_TYPE_ID,
					preferences.getValue(SPChallengeConstants.VOC_CHALLENGE_COLLAB_TYPE_ID, "0"));
			renderRequest.setAttribute(SPChallengeConstants.VOC_ORG_INCORPORATED_STATUS_ID,
					preferences.getValue(SPChallengeConstants.VOC_ORG_INCORPORATED_STATUS_ID, "0"));
			renderRequest.setAttribute(SPChallengeConstants.VOC_ORG_LIFESTAGE_ID,
					preferences.getValue(SPChallengeConstants.VOC_ORG_LIFESTAGE_ID, "0"));
			renderRequest.setAttribute(SPChallengeConstants.VOC_ORG_RAISING_FUNDS_ID,
					preferences.getValue(SPChallengeConstants.VOC_ORG_RAISING_FUNDS_ID, "0"));

			renderRequest.setAttribute(SPChallengeConstants.VOC_ITEMS_PER_PAGE,
					preferences.getValue(SPChallengeConstants.VOC_ITEMS_PER_PAGE, "3"));

			renderRequest.setAttribute(SPChallengeConstants.VOC_ORG_CATEGORY_ID,
					preferences.getValue(SPChallengeConstants.VOC_ORG_CATEGORY_ID, "0"));

			renderRequest.setAttribute(SPChallengeConstants.VOC_ORG_BENCHMARK_ID,
					preferences.getValue(SPChallengeConstants.VOC_ORG_BENCHMARK_ID, "0"));

			renderRequest.setAttribute(SPChallengeConstants.VOC_ORG_COST_BENCHMARK_ID,
					preferences.getValue(SPChallengeConstants.VOC_ORG_COST_BENCHMARK_ID, "0"));
			renderRequest.setAttribute(SPChallengeConstants.VOC_BRAND_ID,
					preferences.getValue(SPChallengeConstants.VOC_BRAND_ID, "0"));			

			renderRequest.setAttribute(SPChallengeConstants.SP_PARAM_CHALLENGE_HOME,
					HtmlUtil.stripHtml(SPChallengeHelper.getChallengesPath()));
			
			renderRequest.setAttribute(SPChallengeConstants.SP_PARAM_CHALLENGE_LIST_HOME,
					HtmlUtil.stripHtml(SPChallengeHelper.getChallengesListPath()));
			
			List<AssetVocabulary> assetVocabularies = AssetVocabularyLocalServiceUtil.getAssetVocabularies(-1, -1);
			renderRequest.setAttribute(SPChallengeConstants.VOC_ALL_VOCS, assetVocabularies);

		} catch (SystemException e) {
			logger.error(e.getMessage(), e);
		}
		super.doEdit(renderRequest, renderResponse);
	}

	public void savePreferences(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		PortletPreferences preferences = actionRequest.getPreferences();
		String applicantTypeVocId = ParamUtil.getString(actionRequest, SPChallengeConstants.VOC_APPLICANT_TYPE_ID, "0");
		String challengeCategoryId = ParamUtil.getString(actionRequest, SPChallengeConstants.VOC_CHALLENGE_CATEGORY_ID,
				"0");
		String challengeTypeId = ParamUtil.getString(actionRequest, SPChallengeConstants.VOC_CHALLENGE_TYPE_ID, "0");
		String regionId = ParamUtil.getString(actionRequest, SPChallengeConstants.VOC_REGION_TYPE_ID, "0");
		String collabTypeId = ParamUtil.getString(actionRequest, SPChallengeConstants.VOC_CHALLENGE_COLLAB_TYPE_ID,
				"0");

		List<AssetCategory> ctypes = SambaashUtil.getCategories(GetterUtil.getLong(collabTypeId));
		boolean internal;
		boolean external;
		String props;
		for (AssetCategory assetCategory : ctypes) {
			props = StringPool.BLANK;
			internal = ParamUtil.getBoolean(actionRequest, "internal_" + assetCategory.getCategoryId());
			external = ParamUtil.getBoolean(actionRequest, "external_" + assetCategory.getCategoryId());
			if (internal) {
				props = SPChallengeConstants.COLLAB_TYPE_INTERNAL;
			}
			if (external) {
				props = props + "," + SPChallengeConstants.COLLAB_TYPE_EXTERRNAL;
			}
			preferences.setValue(getCollabTypePrefKey(assetCategory.getCategoryId()), props);
		}
		String incorpId = ParamUtil.getString(actionRequest, SPChallengeConstants.VOC_ORG_INCORPORATED_STATUS_ID, "0");
		String lifestageId = ParamUtil.getString(actionRequest, SPChallengeConstants.VOC_ORG_LIFESTAGE_ID, "0");
		String raisingFundsId = ParamUtil.getString(actionRequest, SPChallengeConstants.VOC_ORG_RAISING_FUNDS_ID, "0");
		String itemsPerPage = ParamUtil.getString(actionRequest, SPChallengeConstants.VOC_ITEMS_PER_PAGE, "3");
		String challengesHome = ParamUtil.getString(actionRequest, SPChallengeConstants.SP_PARAM_CHALLENGE_HOME,
				"/challenges");
		String challengesListHome = ParamUtil.getString(actionRequest, SPChallengeConstants.SP_PARAM_CHALLENGE_LIST_HOME,
				"/briefs");
		String orgCategoryId = ParamUtil.getString(actionRequest, SPChallengeConstants.VOC_ORG_CATEGORY_ID, "0");
		String orgBenchmarkId = ParamUtil.getString(actionRequest, SPChallengeConstants.VOC_ORG_BENCHMARK_ID, "0");
		String orgCostBenchmarkId = ParamUtil.getString(actionRequest, SPChallengeConstants.VOC_ORG_COST_BENCHMARK_ID,
				"0");
		String brandVocId = ParamUtil.getString(actionRequest, SPChallengeConstants.VOC_BRAND_ID, "0");

		if (Validator.isNotNull(challengesHome))
			challengesHome = HtmlUtil.stripHtml(challengesHome);

		try {
			SPParameter param = SPParameterLocalServiceUtil.findBySPParameterGroupIdAndName(0,
					SPChallengeConstants.SP_PARAM_CHALLENGE_HOME);
			param.setValue(challengesHome);
			SPParameterLocalServiceUtil.updateSPParameter(param);
			SPParameterLocalServiceUtil.clearSPParameterPool(0, SPChallengeConstants.SP_PARAM_CHALLENGE_HOME);
		} catch (Exception e) {
			logger.error("error saving path", e);
		}

		try {
			SPParameter param = SPParameterLocalServiceUtil.findBySPParameterGroupIdAndName(0,
					SPChallengeConstants.SP_PARAM_CHALLENGE_LIST_HOME);
			param.setValue(challengesListHome);
			SPParameterLocalServiceUtil.updateSPParameter(param);
			SPParameterLocalServiceUtil.clearSPParameterPool(0, SPChallengeConstants.SP_PARAM_CHALLENGE_LIST_HOME);
		} catch (Exception e) {
			logger.error("error saving path", e);
		}

		try {
			preferences.setValue(SPChallengeConstants.VOC_APPLICANT_TYPE_ID, applicantTypeVocId);
			preferences.setValue(SPChallengeConstants.VOC_CHALLENGE_CATEGORY_ID, challengeCategoryId);
			preferences.setValue(SPChallengeConstants.VOC_CHALLENGE_TYPE_ID, challengeTypeId);
			preferences.setValue(SPChallengeConstants.VOC_REGION_TYPE_ID, regionId);
			preferences.setValue(SPChallengeConstants.VOC_CHALLENGE_COLLAB_TYPE_ID, collabTypeId);
			preferences.setValue(SPChallengeConstants.VOC_ORG_INCORPORATED_STATUS_ID, incorpId);
			preferences.setValue(SPChallengeConstants.VOC_ORG_LIFESTAGE_ID, lifestageId);
			preferences.setValue(SPChallengeConstants.VOC_ORG_RAISING_FUNDS_ID, raisingFundsId);
			preferences.setValue(SPChallengeConstants.VOC_ITEMS_PER_PAGE, itemsPerPage);
			preferences.setValue(SPChallengeConstants.VOC_ORG_CATEGORY_ID, orgCategoryId);
			preferences.setValue(SPChallengeConstants.VOC_ORG_BENCHMARK_ID, orgBenchmarkId);
			preferences.setValue(SPChallengeConstants.VOC_ORG_COST_BENCHMARK_ID, orgCostBenchmarkId);
			preferences.setValue(SPChallengeConstants.VOC_BRAND_ID, brandVocId);
			preferences.store();
			actionResponse.setPortletMode(PortletMode.VIEW);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}

	private String getCollabTypePrefKey(long categoryId) {
		return SPChallengeConstants.COLLAB_TYPE_PREFIX + categoryId;
	}
}
