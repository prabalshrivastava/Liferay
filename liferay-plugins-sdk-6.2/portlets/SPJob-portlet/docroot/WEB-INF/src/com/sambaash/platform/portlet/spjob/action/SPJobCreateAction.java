package com.sambaash.platform.portlet.spjob.action;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;

import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.asset.AssetCategoryException;
import com.liferay.portlet.asset.AssetTagException;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.model.AssetVocabulary;
import com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetVocabularyLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.sambaash.platform.constant.SambaashConstants;
import com.sambaash.platform.model.MailMessage;
import com.sambaash.platform.portlet.spjob.permissions.JobPermissionsUtil;
import com.sambaash.platform.portlet.spjob.util.SPJobConstants;
import com.sambaash.platform.portlet.spjob.util.SPJobStatus;
import com.sambaash.platform.srv.spinbox.model.IBMessage;
import com.sambaash.platform.srv.spinbox.service.IBMessageDetailLocalServiceUtil;
import com.sambaash.platform.srv.spinbox.service.IBMessageLocalServiceUtil;
import com.sambaash.platform.srv.mail.NoSuchTemplateException;
import com.sambaash.platform.srv.mail.model.SPMailTemplate;
import com.sambaash.platform.srv.mail.service.SPMailLocalServiceUtil;
import com.sambaash.platform.srv.mail.service.SPMailTemplateLocalServiceUtil;
import com.sambaash.platform.srv.spjob.NoSuchSPJobException;
import com.sambaash.platform.srv.spjob.SPJobCategoriesException;
import com.sambaash.platform.srv.spjob.SPJobDescriptionException;
import com.sambaash.platform.srv.spjob.SPJobImageNameException;
import com.sambaash.platform.srv.spjob.SPJobImageSizeException;
import com.sambaash.platform.srv.spjob.SPJobImageTypeException;
import com.sambaash.platform.srv.spjob.SPJobLocationException;
import com.sambaash.platform.srv.spjob.SPJobNameException;
import com.sambaash.platform.srv.spjob.SPJobTagsException;
import com.sambaash.platform.srv.spjob.SPJobTypeException;
import com.sambaash.platform.srv.spjob.model.SPJob;
import com.sambaash.platform.srv.spjob.service.SPJobLocalServiceUtil;
import com.sambaash.platform.srv.spservices.model.SPParameter;
import com.sambaash.platform.srv.spservices.service.SPParameterLocalServiceUtil;
import com.sambaash.platform.util.SambaashUtil;
//import com.sambaash.platform.srv.servicecomponent.service.ServiceComponentsLocalServiceUtil;

/**
 * Portlet implementation class SPJobCreateAction
 */
public class SPJobCreateAction extends MVCPortlet {

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay)renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		HttpServletRequest request = PortalUtil.getHttpServletRequest(renderRequest);
		HttpServletRequest originalServletRequest = PortalUtil.getOriginalServletRequest(request);
		try {
			PortletPreferences preferences = renderRequest.getPreferences();

			String postServiceUserStatus = "You do not have the required permission to access this service.";
			/*String postServiceStrutsAction = StringPool.BLANK;
			SPParameter applyServiceParameter = SPParameterLocalServiceUtil.findBySPParameterGroupIdAndName(
					themeDisplay.getScopeGroupId(), SPJobConstants.JOBS.POST_JOB_SERVICE);
			postServiceStrutsAction = applyServiceParameter.getValue();
			Map<String, Object> parameterMap = new HashMap<String, Object>();
			parameterMap.put("struts_action", postServiceStrutsAction);
			parameterMap.put("groupId", new Long(themeDisplay.getScopeGroupId()));

			Map<String, Object> postServiceHasAccessMap = ServiceComponentsLocalServiceUtil.hasAccess(parameterMap,
					themeDisplay.getUser());
			postServiceHasAccess = (Boolean)postServiceHasAccessMap
					.get(SambaashConstants.MEMBERSHIP.SERVICE_HASACCESS);
			postServiceUserStatus = (String)postServiceHasAccessMap
					.get(SambaashConstants.MEMBERSHIP.SERVICE_REDIRECTURL);
			renderRequest.setAttribute("postServiceHasAccess", postServiceHasAccess);
			renderRequest.setAttribute("postServiceUserStatus", postServiceUserStatus);*/
			boolean isCommunityAdmin = SambaashUtil.isAdmin(themeDisplay.getScopeGroupId(), themeDisplay.getUserId());
			renderRequest.setAttribute("isCommunityAdmin", isCommunityAdmin);
			String signUpUrl = PortalUtil.getCreateAccountURL(request, themeDisplay);
			if(!themeDisplay.isSignedIn()){
				postServiceUserStatus="Please <a href='/signin'>Login</a> to post a job.<br/> Not a Member?<a href="  + signUpUrl + "Join Us";
			}

			if (SambaashUtil.isAdmin(themeDisplay.getScopeGroupId(), themeDisplay.getUserId()) || JobPermissionsUtil.hasCreatePermission(themeDisplay,StringPool.BLANK)) {
				renderRequest.setAttribute("postServiceHasAccess", true);
			}else{
				renderRequest.setAttribute("postServiceHasAccess", false);
				renderRequest.setAttribute("postServiceUserStatus", postServiceUserStatus);
			}
			_log.debug("create permission create page " + JobPermissionsUtil.hasCreatePermission(themeDisplay,StringPool.BLANK));

			SPJob spJob = null;
			
			String spJobIdStr = originalServletRequest.getParameter("id");
			long spJobId = 0;
			try {
				spJobId = Long.valueOf(spJobIdStr);
			} catch (NumberFormatException nfe) {

				// do nothing

			}

			if (spJobId > 0) {
				try {
					spJob = SPJobLocalServiceUtil.getSPJob(spJobId);
				} catch (NoSuchSPJobException nsje) {

					// do nothing

				}
			}

			request.setAttribute("SP_JOB", spJob);

			String jobTypeVocabularyIdStr = preferences.getValue("jobTypeVocabularyId", "0");
			String jobLocationVocabularyIdStr = preferences.getValue("jobLocationVocabularyId", "0");
			String yoeVocabularyIdStr = preferences.getValue("yoeVocabularyId", "0");
			boolean enableNotificationTo = GetterUtil.getBoolean(preferences.getValue("enableNotificationTo", "false"));
			request.setAttribute("enableNotificationTo", enableNotificationTo);
			long jobTypeVocabularyId = 0;
			try {
				jobTypeVocabularyId = Long.valueOf(jobTypeVocabularyIdStr);
			} catch (NumberFormatException nfe) {

				// do nothing

			}

			long jobLocationVocabularyId = 0;
			try {
				jobLocationVocabularyId = Long.valueOf(jobLocationVocabularyIdStr);
			} catch (NumberFormatException nfe) {

				// do nothing

			}

			long yoeVocabularyId = 0;
			try {
				yoeVocabularyId = Long.valueOf(yoeVocabularyIdStr);
			} catch (NumberFormatException nfe) {

				// do nothing

			}

			List<AssetCategory> jobTypeAssetCategories = AssetCategoryLocalServiceUtil.getVocabularyCategories(
					Long.valueOf(jobTypeVocabularyId), -1, -1, null);
			List<AssetCategory> jobLocationAssetCategories = AssetCategoryLocalServiceUtil.getVocabularyCategories(
					Long.valueOf(jobLocationVocabularyId), -1, -1, null);
			List<AssetCategory> yoeAssetCategories = AssetCategoryLocalServiceUtil.getVocabularyCategories(
					Long.valueOf(yoeVocabularyId), -1, -1, null);

			renderRequest.setAttribute("jobTypeAssetCategories", jobTypeAssetCategories);
			renderRequest.setAttribute("jobLocationAssetCategories", jobLocationAssetCategories);
			renderRequest.setAttribute("yoeAssetCategories", yoeAssetCategories);

			String communityName = SambaashUtil.getCommunityName(themeDisplay.getScopeGroupId());
			renderRequest.setAttribute("communityName", communityName);

			String assetCategoriesVocabularyId = preferences.getValue("assetCategoriesVocabularyId", "0");
			renderRequest.setAttribute("assetCategoriesVocabularyId", assetCategoriesVocabularyId);

		} catch (Exception e) {
			_log.error(e.getMessage(), e);
		}

		super.doView(renderRequest, renderResponse);
	}

	@Override
	public void doEdit(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		try {
			StringBuffer sb = new StringBuffer();
			List<AssetVocabulary> assetVocabularies = AssetVocabularyLocalServiceUtil.getAssetVocabularies(-1, -1);

			for (AssetVocabulary av : assetVocabularies) {
				sb.append(av.getName() + ": " + av.getVocabularyId() + ", ");
			}

			renderRequest.setAttribute("assetVocabulariesString", sb.toString());
		} catch (Exception e) {
			_log.error(e.getMessage(), e);
		}

		super.doEdit(renderRequest, renderResponse);
	}

	@Override
	public void processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException,
			PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		PortletPreferences preferences = actionRequest.getPreferences();

		String action = ParamUtil.getString(actionRequest, "action");

		if (Constants.EDIT.equalsIgnoreCase(action)) {
			try {
				String jobTypeVocabularyId = ParamUtil.getString(actionRequest, "jobTypeVocabularyId");
				String jobLocationVocabularyId = ParamUtil.getString(actionRequest, "jobLocationVocabularyId");
				String yoeVocabularyId = ParamUtil.getString(actionRequest, "yoeVocabularyId");
				String assetCategoriesVocabularyId = ParamUtil.getString(actionRequest, "assetCategoriesVocabularyId");

				String spJobImageMaxSize = ParamUtil.getString(actionRequest, "spJobImageMaxSize");
				String spJobImageExtensions = ParamUtil.getString(actionRequest, "spJobImageExtensions");
				String spJobDetailPageName = ParamUtil.getString(actionRequest, "spJobDetailPageName");

				String spJobPostNotiTemplateId = ParamUtil.getString(actionRequest, "spJobPostNotiTemplateId");

				String enableNotificationTo = ParamUtil.getString(actionRequest, "enableNotificationTo");

				preferences.setValue("jobTypeVocabularyId", jobTypeVocabularyId);
				preferences.setValue("jobLocationVocabularyId", jobLocationVocabularyId);
				preferences.setValue("yoeVocabularyId", yoeVocabularyId);
				preferences.setValue("assetCategoriesVocabularyId", assetCategoriesVocabularyId);

				preferences.setValue("spJobImageMaxSize", spJobImageMaxSize);
				preferences.setValue("spJobImageExtensions", spJobImageExtensions);
				preferences.setValue("spJobDetailPageName", spJobDetailPageName);

				preferences.setValue("spJobPostNotiTemplateId", spJobPostNotiTemplateId);
				preferences.setValue("enableNotificationTo", enableNotificationTo);

				preferences.store();
				SambaashUtil.saveSPParameter(SambaashConstants.SPJOB_ENABLE_NOTIFICATION_TO, enableNotificationTo);
				addSuccessMessage(actionRequest, actionResponse);
			} catch (Exception e) {
				_log.error(e.getMessage(), e);
			}

		} else if ("editSPJob".equalsIgnoreCase(action)) {
			try {
				boolean attachments = ParamUtil.getBoolean(actionRequest, "attachments", true);

				String spJobImageMaxSizeStr = preferences.getValue("spJobImageMaxSize",
						String.valueOf(DEFAULT_SPJOB_IMAGE_MAX_SIZE));
				String spJobImageExtensionsStr = preferences.getValue("spJobImageExtensions",
						String.valueOf(DEFAULT_SPJOB_IMAGE_EXTENSIONS));

				long spJobImageMaxSize = DEFAULT_SPJOB_IMAGE_MAX_SIZE;
				try {
					spJobImageMaxSize = Long.valueOf(spJobImageMaxSizeStr);
				} catch (NumberFormatException nfe) {

					// do nothing

				}

				String[] spJobImageExtensions = StringUtil.split(spJobImageExtensionsStr, StringPool.COMMA);

				String spJobPostNotiTemplateId = preferences.getValue("spJobPostNotiTemplateId", "0");
				String spJobDetailPageName = preferences.getValue("spJobDetailPageName", "job-detail");

				Object[] returnValue = updateSPJob(actionRequest, themeDisplay, attachments, spJobImageMaxSize,
						spJobImageExtensions, spJobPostNotiTemplateId, spJobDetailPageName);

				SPJob spJob = (SPJob)returnValue[0];

				actionResponse.sendRedirect(PortalUtil.getPortalURL(actionRequest) + "/" + spJobDetailPageName + "?id=" +
						spJob.getSpJobId());

			} catch (Exception e) {
				if (e instanceof SPJobNameException || e instanceof SPJobDescriptionException
						|| e instanceof SPJobTypeException || e instanceof SPJobLocationException
						|| e instanceof SPJobTagsException || e instanceof SPJobCategoriesException
						|| e instanceof SPJobImageNameException || e instanceof SPJobImageSizeException
						|| e instanceof SPJobImageTypeException || e instanceof AssetCategoryException ||
					e instanceof AssetTagException) {

					SessionErrors.add(actionRequest, e.getClass().getName(), e);

				} else {
					_log.error(e.getMessage(), e);
				}
			}
		}

		super.processAction(actionRequest, actionResponse);
	}

	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException,
			PortletException {
	//	super.serveResource(resourceRequest, resourceResponse);
		ThemeDisplay themeDisplay = (ThemeDisplay)resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String type = ParamUtil.getString(resourceRequest, "action");

		if (type.equalsIgnoreCase("notefToSuggestions")) {
			String inviteBy = resourceRequest.getParameter("invite_by");
			resourceResponse.setContentType("application/json");
			resourceResponse.setCharacterEncoding("utf-8");
			try {
				resourceResponse.getWriter().write(findUsers(resourceRequest, themeDisplay.getCompanyId()));
			} catch (Exception e) {
				_log.error("Error while fetching users");
			}

		}
	}

	private Object[] updateSPJob(ActionRequest actionRequest, ThemeDisplay themeDisplay, boolean attachments,
			long spJobImageMaxSize, String[] spJobImageExtensions, String spJobPostNotiTemplateId,
			String spJobDetailPageName) throws Exception {

		long spJobId = 0;

		String corporateName = StringPool.BLANK;
		String notefTo = StringPool.BLANK;
		String jobTitle = StringPool.BLANK;
		String jobType = StringPool.BLANK;
		String jobLocation = StringPool.BLANK;
		String yoe = StringPool.BLANK;
		String jobDescription = StringPool.BLANK;

		int startMonth = 0;
		int startDay = 0;
		int startYear = 0;

		// int endMonth = 0; int endDay = 0; int endYear = 0;

		int closingMonth = 0;
		int closingDay = 0;
		int closingYear = 0;

		String currency = StringPool.BLANK;
		String salary = StringPool.BLANK;
		String rate = StringPool.BLANK;

		String imageFileName = null;
		InputStream imageInputStream = null;

		boolean draft = false;
		ServiceContext serviceContext = null;

		if (attachments) {
			UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
			serviceContext = ServiceContextFactory.getInstance(uploadPortletRequest);

			spJobId = ParamUtil.getLong(uploadPortletRequest, "jobId");

			notefTo = ParamUtil.getString(uploadPortletRequest, "notefto");
			corporateName = ParamUtil.getString(uploadPortletRequest, "corporateName");
			jobTitle = ParamUtil.getString(uploadPortletRequest, "jobTitle");
			jobType = ParamUtil.getString(uploadPortletRequest, "jobType");
			jobLocation = ParamUtil.getString(uploadPortletRequest, "jobLocation");
			yoe = ParamUtil.getString(uploadPortletRequest, "yoe");
			jobDescription = ParamUtil.getString(uploadPortletRequest, "jobDescription");

			startMonth = ParamUtil.getInteger(uploadPortletRequest, "startMonth");
			startDay = ParamUtil.getInteger(uploadPortletRequest, "startDay");
			startYear = ParamUtil.getInteger(uploadPortletRequest, "startYear");

			// endMonth = ParamUtil.getInteger(uploadPortletRequest,
			// "endMonth"); endDay = ParamUtil.getInteger(uploadPortletRequest,
			// "endDay"); endYear = ParamUtil.getInteger(uploadPortletRequest,
			// "endYear");

			closingMonth = ParamUtil.getInteger(uploadPortletRequest, "closingMonth");
			closingDay = ParamUtil.getInteger(uploadPortletRequest, "closingDay");
			closingYear = ParamUtil.getInteger(uploadPortletRequest, "closingYear");
			currency = ParamUtil.getString(uploadPortletRequest, "currency");
			salary = ParamUtil.getString(uploadPortletRequest, "salary");
			rate = ParamUtil.getString(uploadPortletRequest, "rate");

			draft = ParamUtil.getBoolean(uploadPortletRequest, "draft", false);

			imageFileName = uploadPortletRequest.getFileName("fileName");
			imageInputStream = uploadPortletRequest.getFileAsStream("fileName");

		} else {

			serviceContext = ServiceContextFactory.getInstance(SPJob.class.getName(), actionRequest);
			spJobId = ParamUtil.getLong(actionRequest, "jobId");
			notefTo = ParamUtil.getString(actionRequest, "notefto");
			corporateName = ParamUtil.getString(actionRequest, "corporateName");
			jobTitle = ParamUtil.getString(actionRequest, "jobTitle");
			jobType = ParamUtil.getString(actionRequest, "jobType");
			jobLocation = ParamUtil.getString(actionRequest, "jobLocation");
			yoe = ParamUtil.getString(actionRequest, "yoe");
			jobDescription = ParamUtil.getString(actionRequest, "jobDescription");

			startMonth = ParamUtil.getInteger(actionRequest, "startMonth");
			startDay = ParamUtil.getInteger(actionRequest, "startDay");
			startYear = ParamUtil.getInteger(actionRequest, "startYear");

			// endMonth = ParamUtil.getInteger(actionRequest, "endMonth");
			// endDay = ParamUtil.getInteger(actionRequest, "endDay"); endYear =
			// ParamUtil.getInteger(actionRequest, "endYear");

			closingMonth = ParamUtil.getInteger(actionRequest, "closingMonth");
			closingDay = ParamUtil.getInteger(actionRequest, "closingDay");
			closingYear = ParamUtil.getInteger(actionRequest, "closingYear");
			currency = ParamUtil.getString(actionRequest, "currency");
			salary = ParamUtil.getString(actionRequest, "salary");
			rate = ParamUtil.getString(actionRequest, "rate");

			draft = ParamUtil.getBoolean(actionRequest, "draft", false);
		}

		Calendar startCalendar = Calendar.getInstance(themeDisplay.getTimeZone(), themeDisplay.getLocale());
		startCalendar.set(Calendar.YEAR, startYear);
		startCalendar.set(Calendar.MONTH, startMonth);
		startCalendar.set(Calendar.DAY_OF_MONTH, startDay);
		startCalendar.set(Calendar.HOUR_OF_DAY, 0);
		startCalendar.set(Calendar.MINUTE, 0);
		startCalendar.set(Calendar.SECOND, 0);

		Calendar endCalendar = Calendar.getInstance(themeDisplay.getTimeZone(), themeDisplay.getLocale());
		endCalendar.set(Calendar.YEAR, endCalendar.get(Calendar.YEAR) + 1);

		// endCalendar.set(Calendar.MONTH, endMonth);
		// endCalendar.set(Calendar.DAY_OF_MONTH, endDay);
		// endCalendar.set(Calendar.HOUR_OF_DAY, 0);
		// endCalendar.set(Calendar.MINUTE, 0); endCalendar.set(Calendar.SECOND,
		// 0);

		Calendar closingCalendar = Calendar.getInstance(themeDisplay.getTimeZone(), themeDisplay.getLocale());
		closingCalendar.set(Calendar.YEAR, closingYear);
		closingCalendar.set(Calendar.MONTH, closingMonth);
		closingCalendar.set(Calendar.DAY_OF_MONTH, closingDay);
		closingCalendar.set(Calendar.HOUR_OF_DAY, 0);
		closingCalendar.set(Calendar.MINUTE, 0);
		closingCalendar.set(Calendar.SECOND, 0);
		SPJob spJob = null;
		String status = SPJobStatus.ACTIVE.getValue();

		if (draft) {
			status = SPJobStatus.DRAFT.getValue();
		}

		if (spJobId <= 0) {

			// Add entry

			spJob = SPJobLocalServiceUtil.addSPJob(themeDisplay.getUserId(), corporateName, jobTitle, jobType,
					jobLocation, yoe, jobDescription, status, imageFileName, imageInputStream, spJobImageMaxSize,
					spJobImageExtensions, currency, salary, rate, startCalendar.getTime(), endCalendar.getTime(),
					closingCalendar.getTime(), notefTo, serviceContext);

			spJobId = spJob.getSpJobId();

			// for poster

			try {
				long spJobPostNotiTemplateIdL = 0;
				try {
					spJobPostNotiTemplateIdL = Long.valueOf(spJobPostNotiTemplateId);
				} catch (NumberFormatException nfe) {

					// do nothing

				}

				if (spJobPostNotiTemplateIdL > 0) {
					SPMailTemplate spMailTemplate = SPMailTemplateLocalServiceUtil
							.getSPMailTemplate(spJobPostNotiTemplateIdL);

					String subject = spMailTemplate.getSubject();
					String htmlContent = spMailTemplate.getHtmlContent();

					Map<String, Object> paramsMap = new HashMap<String, Object>();

					String posterName = themeDisplay.getUser().getFullName();
					String portalUrl = PortalUtil.getPortalURL(actionRequest);
					String jobDetailUrl = portalUrl + "/" + spJobDetailPageName + "?id=" + spJobId;
					String postingDate = getSDisplayDate(new Date());
					String startDate = getSDisplayDate(startCalendar.getTime());
					String endDate = getSDisplayDate(endCalendar.getTime());
					String closingDate = getSDisplayDate(closingCalendar.getTime());
					paramsMap.put("posterName", posterName);
					paramsMap.put("jobDetailUrl", jobDetailUrl);
					paramsMap.put("jobId", String.valueOf(spJobId));
					paramsMap.put("jobTitle", jobTitle);
					paramsMap.put("postingDate", postingDate);
					paramsMap.put("startDate", startDate);
					paramsMap.put("endDate", endDate);
					paramsMap.put("closingDate", closingDate);

					String[] spJobPostingNotificationTitleAndBody = getSPJobPostingNotificationTitleAndBody(subject,
							htmlContent, paramsMap);

					// external

					sendExternalEmail(themeDisplay.getCompanyId(), spJobPostingNotificationTitleAndBody[0],
							spJobPostingNotificationTitleAndBody[1], themeDisplay.getUser().getFullName(), themeDisplay
									.getUser().getEmailAddress(), paramsMap);

					// inbox

					String fromName = PrefsPropsUtil.getString(themeDisplay.getCompanyId(),
							PropsKeys.ADMIN_EMAIL_FROM_NAME);
					String fromAddress = PrefsPropsUtil.getString(themeDisplay.getCompanyId(),
							PropsKeys.ADMIN_EMAIL_FROM_ADDRESS);

					IBMessage ibmessageForPoster = addIBMessage(themeDisplay.getScopeGroupId(),
							themeDisplay.getCompanyId(), fromName, 0, fromAddress, themeDisplay
									.getUser().getEmailAddress(), spJobPostingNotificationTitleAndBody[0],
							spJobPostingNotificationTitleAndBody[1]);

					addIBMessageDetail(themeDisplay.getCompanyId(), ibmessageForPoster, themeDisplay.getUser()
							.getUserId(), themeDisplay.getUser().getFullName(), "", "message");
				}
			} catch (NoSuchTemplateException e) {
				_log.error(e.getMessage(), e);
			}

		} else {

			// Update entry

			spJob = SPJobLocalServiceUtil.getSPJob(spJobId);

			spJob = SPJobLocalServiceUtil.updateSPJob(themeDisplay.getUserId(), spJobId, corporateName, jobTitle,
					jobType, jobLocation, yoe, jobDescription, status, imageFileName, imageInputStream,
					spJobImageMaxSize, spJobImageExtensions, currency, salary, rate, startCalendar.getTime(),
					endCalendar.getTime(), closingCalendar.getTime(), notefTo, serviceContext);

		}

		Indexer indexer = IndexerRegistryUtil.getIndexer(SPJob.class);
		indexer.reindex(spJob);

		return new Object[] { spJob };

	}

	private String[] getSPJobPostingNotificationTitleAndBody(String subject, String body, Map<String, Object> paramsMap) {

		String posterName = (String) paramsMap.get("posterName");
		String jobDetailUrl = (String) paramsMap.get("jobDetailUrl");
		String jobId = (String) paramsMap.get("jobId");
		String jobTitle = (String) paramsMap.get("jobTitle");
		String postingDate = (String) paramsMap.get("postingDate");
		String startDate = (String) paramsMap.get("startDate");
		String endDate = (String) paramsMap.get("endDate");
		String closingDate = (String) paramsMap.get("closingDate");

		body = StringUtil
				.replace(body, new String[] { "[$POSTER_NAME$]", "[$JOB_DETAIL_URL$]", "[$JOB_ID$]", "[$JOB_TITLE$]",
						"[$POSTING_DATE$]", "[$START_DATE$]", "[$END_DATE$]", "[$CLOSING_DATE$]" }, new String[] {
						posterName, jobDetailUrl, jobId, jobTitle, postingDate, startDate, endDate, closingDate });

		return new String[] { subject, body };
	}

	private IBMessage addIBMessage(long scopeGroupId, long companyId, String createBy, long createByUserId,
			String fromEmail, String toEmails, String subject, String body) throws PortalException, SystemException {
		IBMessage ibmessage = IBMessageLocalServiceUtil.addMessage(null, 0, scopeGroupId, companyId, subject, body,
				new Date(), fromEmail, toEmails, createBy, String.valueOf(createByUserId), true, false, "", false, false, 0);
		Indexer indexer = IndexerRegistryUtil.getIndexer(IBMessage.class);
		indexer.reindex(ibmessage);
		return ibmessage;
	}

	private void addIBMessageDetail(long companyId, IBMessage ibmessage, long toUserId, String toUserFullName,
			String ibMsgDetailStatus, String messageCategory) throws PortalException, SystemException {

		// add IBMessageDetail

		IBMessageDetailLocalServiceUtil.addMessageDetail(ibmessage.getMessageId(), toUserId, toUserFullName,
				new Date(), messageCategory, false, null, null, "unread", "", ibMsgDetailStatus, 0, 0);
	}

	private void sendExternalEmail(long companyId, String subject, String body, String toName, String toAddress,
			Map<String, Object> paramsMap) throws Exception {

		String fromName = PrefsPropsUtil.getString(companyId, PropsKeys.ADMIN_EMAIL_FROM_NAME);
		String fromAddress = PrefsPropsUtil.getString(companyId, PropsKeys.ADMIN_EMAIL_FROM_ADDRESS);

		MailMessage mailMessage = new MailMessage();
		mailMessage.setFromAddress(fromAddress);
		mailMessage.setFromName(fromName);
		mailMessage.setSubject(subject);
		mailMessage.setHtmlBody(body);
		mailMessage.setToAddress(toAddress);
		SPMailLocalServiceUtil.sendMail(mailMessage);

	}

	@SuppressWarnings("unchecked")
	private String findUsers(ResourceRequest resourceRequest, long companyId) throws PortalException, SystemException {

		String q = ParamUtil.getString(resourceRequest, "q");

		ThemeDisplay themeDisplay = (ThemeDisplay)resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String mailIcon = themeDisplay.getPathThemeImages() + "/send_by_email.png";
		JSONObject dataJSONObject = JSONFactoryUtil.createJSONObject();
		JSONArray itemsJSONArray = JSONFactoryUtil.createJSONArray();

		String suggestion = "<div data-autocomplete-dom-id=\"option\" data-user-id=\"" +
				"%d" +
				"\" data-user-mail=\"" +
				"%s"
				+ "\" %s><div class=\"sp-group-clearfix\"><div class=\"sp-group-lfloat sp-group-mrm\" style=\"line-height: 0;\"><img alt=\"Auto Complete Image\" data-autocomplete-dom-id=\"option-img\" src=\"" +
				"%s"
				+ "\" class=\"sp-group-thumb_32\" /></div><div class=\"sp-group-ui-oh\"><div class=\"sp-group-ui-dib\"><div class=\"sp-group-ui-dib sp-group-ui-vam\" style=\"height:32px;\"></div><div class=\"sp-group-ui-dib sp-group-ui-vam\"><span data-autocomplete-dom-id=\"option-name\" class=\"sp-group-fwb\">"
				+ "%s" + "</span>(<span data-autocomplete-dom-id=\"option-email\" class=\"sp-group-fwb\">" + "%s" +
				"</span>)</div></div></div></div></div>";

		String suggestinByMail = "<div data-autocomplete-dom-id=\"option\" data-user-id=\"0\" class=\"ip-sb-option\"><div class=\"sp-group-clearfix\"><div class=\"sp-group-lfloat sp-group-mrm\" style=\"line-height: 0;\"><img alt=\"Auto Complete Image\" src=\"" +
				mailIcon
				+ "\" class=\"sp-group-thumb_32\" /></div><div class=\"sp-group-ui-oh\"><div class=\"sp-group-ui-dib\"><div class=\"sp-group-ui-dib sp-group-ui-vam\" style=\"height:32px;\"></div><div class=\"sp-group-ui-dib sp-group-ui-vam\"><div class=\"sp-group-ui-lh1 mtxs mbs\">Send an email to</div><div data-autocomplete-dom-id=\"option-email\" class=\"sp-group-ui-lh1 sp-group-fwb\">" +
				"%s" + "</div></div></div></div></div></div>";

		List<User> matchedUsers = new ArrayList<User>();
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil
				.forClass(User.class, PortalClassLoaderUtil.getClassLoader());

		if (Validator.isNotNull(q)) {
			try {
			/* dynamicQuery = DynamicQueryFactoryUtil.forClass(User.class, PortalClassLoaderUtil.getClassLoader());
				Criterion criterion = RestrictionsFactoryUtil.ilike("emailAddress", q + "%");
				criterion = RestrictionsFactoryUtil.or(criterion, RestrictionsFactoryUtil.ilike("screenName", q + "%"));

				String[] firstAndLastnameQ = StringUtil.split(q, StringPool.SPACE);

				if (firstAndLastnameQ.length == 2) {
					String firstNameQ = firstAndLastnameQ[0].trim();
					String lastNameQ = firstAndLastnameQ[1].trim();
					criterion = RestrictionsFactoryUtil.or(criterion,
							RestrictionsFactoryUtil.ilike("firstName", firstNameQ + "%"));
					criterion = RestrictionsFactoryUtil.or(criterion,
							RestrictionsFactoryUtil.ilike("lastName", lastNameQ + "%"));
				}

				criterion = RestrictionsFactoryUtil.or(criterion, RestrictionsFactoryUtil.ilike("firstName", q + "%"));
				criterion = RestrictionsFactoryUtil.or(criterion, RestrictionsFactoryUtil.ilike("lastName", q + "%"));

				dynamicQuery.add(PropertyFactoryUtil.forName("emailAddressVerified").eq(new Boolean(true)));
				dynamicQuery.add(criterion);

				matchedUsers = UserLocalServiceUtil.dynamicQuery(dynamicQuery); */
				matchedUsers = getMatchedUsers(q);

				long userId;
				String username;
				String userImage;
				String html;
				String email;
				String htmlClass;
				boolean first = true;

				for (User user : matchedUsers) {
					userId = user.getUserId();
					username = user.getScreenName();
					userImage = "/../image/user_male_portrait?img_id=" + user.getPortraitId();
					email = user.getEmailAddress();

					if (first) {
						first = false;
						htmlClass = "class=\"ip-sb-option hover\"";
					} else {
						htmlClass = "class=\"ip-sb-option\"";
					}

					html = String.format(suggestion, userId, email, htmlClass, userImage,
							username, email);
					JSONObject htmlJSONObject = JSONFactoryUtil.createJSONObject();
					htmlJSONObject.put("html", html);
					itemsJSONArray.put(htmlJSONObject);
				}

			} catch (Exception nsue) {
				String email = q;
				String html = String.format(suggestinByMail, email);
				JSONObject htmlJSONObject = JSONFactoryUtil.createJSONObject();
				htmlJSONObject.put("html", html);
				itemsJSONArray.put(htmlJSONObject);

			}

		} else {

		}

		dataJSONObject.put("items", itemsJSONArray);
		return dataJSONObject.toString();
	}

	private static List<User> getMatchedUsers(String query) {
		List<User>matchedUsers = null;

		try {
			DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(User.class, PortalClassLoaderUtil.getClassLoader());
			Criterion criterion = RestrictionsFactoryUtil.ilike("emailAddress", query + "%");
			criterion = RestrictionsFactoryUtil.or(criterion, RestrictionsFactoryUtil.ilike("screenName", query + "%"));

			String[] firstAndLastnameQ = StringUtil.split(query, StringPool.SPACE);

			if (firstAndLastnameQ.length == 2) {
				String firstNameQ = firstAndLastnameQ[0].trim();
				String lastNameQ = firstAndLastnameQ[1].trim();
				criterion = RestrictionsFactoryUtil.or(criterion,
						RestrictionsFactoryUtil.ilike("firstName", firstNameQ + "%"));
				criterion = RestrictionsFactoryUtil.or(criterion,
						RestrictionsFactoryUtil.ilike("lastName", lastNameQ + "%"));
			}

			criterion = RestrictionsFactoryUtil.or(criterion, RestrictionsFactoryUtil.ilike("firstName", query + "%"));
			criterion = RestrictionsFactoryUtil.or(criterion, RestrictionsFactoryUtil.ilike("lastName", query + "%"));

			dynamicQuery.add(PropertyFactoryUtil.forName("emailAddressVerified").eq(new Boolean(true)));
			dynamicQuery.add(criterion);

			matchedUsers = UserLocalServiceUtil.dynamicQuery(dynamicQuery);
		} catch (Exception e) {
			_log.error("Error while getting matched users");
		}

		return matchedUsers;

	}

	private static final long DEFAULT_SPJOB_IMAGE_MAX_SIZE = 307200;

	private static final String DEFAULT_SPJOB_IMAGE_EXTENSIONS = ".gif,.jpeg,.jpg,.png";

	public static String getSDisplayDate(Date date) {
		return sFormat.format(date);
	}

	public static SimpleDateFormat sFormat = new SimpleDateFormat("MMM dd, yyyy");

	private static Log _log = LogFactoryUtil.getLog(SPJobCreateAction.class);

}
