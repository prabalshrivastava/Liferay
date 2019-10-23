package com.sambaash.platform.portlet.spjob.action;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.ResourceURL;
import javax.servlet.http.HttpServletRequest;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.BooleanClause;
import com.liferay.portal.kernel.search.BooleanClauseFactoryUtil;
import com.liferay.portal.kernel.search.BooleanClauseOccur;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.BooleanQueryFactoryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.SortFactoryUtil;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.model.AssetVocabulary;
import com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetVocabularyLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.sambaash.platform.portlet.spjob.permissions.JobPermissionsUtil;
import com.sambaash.platform.portlet.spjob.util.SPJobConstants;
import com.sambaash.platform.portlet.spjob.util.SPJobFieldUtil;
import com.sambaash.platform.portlet.spjob.util.SPJobStatus;
import com.sambaash.platform.portlet.spjob.wrapper.SPJobWrapper;
import com.sambaash.platform.srv.spjob.model.SPJob;
import com.sambaash.platform.srv.spjob.service.SPJobLocalServiceUtil;
import com.sambaash.platform.srv.spservices.model.SPParameter;
import com.sambaash.platform.srv.spservices.service.SPParameterLocalServiceUtil;
import com.sambaash.platform.util.SambaashUtil;
//import com.sambaash.platform.srv.servicecomponent.service.ServiceComponentsLocalServiceUtil;

/**
 * Portlet implementation class SPJobLandingAction
 */
public class SPJobLandingAction extends MVCPortlet {

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay)renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		HttpServletRequest request = PortalUtil.getHttpServletRequest(renderRequest);
		HttpServletRequest originalServletRequest = PortalUtil.getOriginalServletRequest(request);
		try {
			PortletPreferences preferences = renderRequest.getPreferences();
			String locationVocabularyIdStr = preferences.getValue("locationVocabularyId", "0");
			long locationVocabularyId = 0;
			try {
				locationVocabularyId = Long.valueOf(locationVocabularyIdStr);
			} catch (NumberFormatException nfe) {

				// do nothing

			}

			String categoryVocabularyIdStr = preferences.getValue("categoryVocabularyId", "0");
			long categoryVocabularyId = 0;
			try {
				categoryVocabularyId = Long.valueOf(categoryVocabularyIdStr);
			} catch (NumberFormatException nfe) {

				// do nothing

			}

			String yearOfExperienceVocabularyIdStr = preferences.getValue("yearOfExperienceVocabularyId", "0");
			long yearOfExperienceVocabularyId = 0;
			try {
				yearOfExperienceVocabularyId = Long.valueOf(yearOfExperienceVocabularyIdStr);
			} catch (NumberFormatException nfe) {

				// do nothing

			}

			List<AssetCategory> jobLocationAssetCategories = AssetCategoryLocalServiceUtil.getVocabularyCategories(
					locationVocabularyId, -1, -1, null);
			renderRequest.setAttribute("jobLocationAssetCategories", jobLocationAssetCategories);
			List<AssetCategory> categoryAssetCategories = AssetCategoryLocalServiceUtil.getVocabularyCategories(
					categoryVocabularyId, -1, -1, null);
			renderRequest.setAttribute("categoryAssetCategories", categoryAssetCategories);
			List<AssetCategory> experienceAssetCategories = AssetCategoryLocalServiceUtil.getVocabularyCategories(
					yearOfExperienceVocabularyId, -1, -1, null);
			renderRequest.setAttribute("experienceAssetCategories", experienceAssetCategories);

			String numberOfItemsPerPage = preferences.getValue("numberOfItemsPerPage",
					String.valueOf(_DEFAULT_NUBER_OF_ITEMS_PER_PAGE));
			renderRequest.setAttribute("numberOfItemsPerPage", numberOfItemsPerPage);

			Calendar calendar = Calendar.getInstance();
			int curYear = calendar.get(Calendar.YEAR);
			int curMonth = calendar.get(Calendar.MONTH);
			int curDay = calendar.get(Calendar.DAY_OF_MONTH);
			int yearRangeStart = curYear - 50;
			int yearRangeEnd = curYear + 50;
			renderRequest.setAttribute("curYear", curYear);
			renderRequest.setAttribute("curMonth", curMonth);
			renderRequest.setAttribute("curDay", curDay);
			renderRequest.setAttribute("yearRangeStart", yearRangeStart);
			renderRequest.setAttribute("yearRangeEnd", yearRangeEnd);

			String postServiceUserStatus = "You do not have the required permission to access this service.";
			/*String postServiceStrutsAction = StringPool.BLANK;
			SPParameter applyServiceParameter = SPParameterLocalServiceUtil.findBySPParameterGroupIdAndName(
					themeDisplay.getScopeGroupId(), SPJobConstants.JOBS.POST_JOB_SERVICE);
			postServiceStrutsAction = applyServiceParameter.getValue();
			Map<String, Object> parameterMap = new HashMap<String, Object>();
			parameterMap.put("struts_action", postServiceStrutsAction);
			parameterMap.put("groupId", new Long(themeDisplay.getScopeGroupId()));*/

			/*Map<String, Object> postServiceHasAccessMap = ServiceComponentsLocalServiceUtil.hasAccess(parameterMap,
					themeDisplay.getUser());
			postServiceHasAccess = (Boolean)postServiceHasAccessMap
					.get(SambaashConstants.MEMBERSHIP.SERVICE_HASACCESS);
			postServiceUserStatus = (String)postServiceHasAccessMap
					.get(SambaashConstants.MEMBERSHIP.SERVICE_REDIRECTURL);
			renderRequest.setAttribute("postServiceHasAccess", postServiceHasAccess);
			renderRequest.setAttribute("postServiceUserStatus", postServiceUserStatus);*/
			String nameOfCreatePage = preferences.getValue("nameOfCreatePage", StringPool.BLANK);
			String signUpUrl = PortalUtil.getCreateAccountURL(request, themeDisplay);
			String signinUrl = "/signin?redirect=/" + nameOfCreatePage;
			if(!themeDisplay.isSignedIn()){
				postServiceUserStatus="Please <a href=" + signinUrl + ">Login</a> to post a job.<br/> Not a Member?<a href="  + signUpUrl + ">Join Us</a>";
			}
			
			if (SambaashUtil.isAdmin(themeDisplay.getScopeGroupId(), themeDisplay.getUserId()) || JobPermissionsUtil.hasCreatePermission(themeDisplay,nameOfCreatePage)) {
				renderRequest.setAttribute("postServiceHasAccess", true);
			}else{
				renderRequest.setAttribute("postServiceHasAccess", false);
				renderRequest.setAttribute("postServiceUserStatus", postServiceUserStatus);
			}
			_log.debug("create permission landing page " + JobPermissionsUtil.hasCreatePermission(themeDisplay,nameOfCreatePage));
			renderRequest.setAttribute("nameOfCreatePage", nameOfCreatePage);

			String communityName = SambaashUtil.getCommunityName(themeDisplay.getScopeGroupId());
			renderRequest.setAttribute("communityName", communityName);

		} catch (Exception e) {
			_log.error(e.getMessage(), e);
		}

		super.doView(renderRequest, renderResponse);
	}

	@Override
	public void doEdit(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		try {
			PortletPreferences preferences = renderRequest.getPreferences();

			String showImage = preferences.getValue("showImage", StringPool.TRUE);
			String showTitle = preferences.getValue("showTitle", StringPool.TRUE);
			String showType = preferences.getValue("showType", StringPool.TRUE);
			String showStartDate = preferences.getValue("showStartDate", StringPool.TRUE);
			String showDescription = preferences.getValue("showDescription", StringPool.TRUE);
			String showCategories = preferences.getValue("showCategories", StringPool.TRUE);
			String showTags = preferences.getValue("showTags", StringPool.TRUE);

			String nameOfDetailPage = preferences.getValue("nameOfDetailPage", StringPool.BLANK);
			String nameOfCreatePage = preferences.getValue("nameOfCreatePage", StringPool.BLANK);
			String nameOfApplyPage = preferences.getValue("nameOfApplyPage", StringPool.BLANK);
			String numberOfItemsPerPage = preferences.getValue("numberOfItemsPerPage",
					String.valueOf(_DEFAULT_NUBER_OF_ITEMS_PER_PAGE));
			String widthOfItem = preferences.getValue("widthOfItem", String.valueOf(_DEFAULT_WIDTH_OF_ITEM));
			String heightOfItem = preferences.getValue("heightOfItem", String.valueOf(_DEFAULT_HEIGHT_OF_ITEM));
			String locationVocabularyId = preferences.getValue("locationVocabularyId", "0");
			String categoryVocabularyId = preferences.getValue("categoryVocabularyId", "0");
			String yearOfExperienceVocabularyId = preferences.getValue("yearOfExperienceVocabularyId", "0");

			String titleMaxLengthStr = preferences.getValue("titleMaxLength",
					String.valueOf(_DEFAULT_MAX_LENGTH_OF_TITLE));
			String descriptionMaxLengthStr = preferences.getValue("descriptionMaxLength",
					String.valueOf(_DEFAULT_MAX_LENGTH_OF_DESCRIPTION));
			String categoriesMaxLengthStr = preferences.getValue("categoriesMaxLength",
					String.valueOf(_DEFAULT_MAX_LENGTH_OF_CATEGORIES));
			String tagsMaxLengthStr = preferences
					.getValue("tagsMaxLength", String.valueOf(_DEFAULT_MAX_LENGTH_OF_TAGS));
			String numberOfItemsPerPageStr = preferences.getValue("numberOfItemsPerPage",
					String.valueOf(_DEFAULT_NUBER_OF_ITEMS_PER_PAGE));

			renderRequest.setAttribute("showImage", showImage);
			renderRequest.setAttribute("showTitle", showTitle);
			renderRequest.setAttribute("showType", showType);
			renderRequest.setAttribute("showStartDate", showStartDate);
			renderRequest.setAttribute("showDescription", showDescription);
			renderRequest.setAttribute("showCategories", showCategories);
			renderRequest.setAttribute("showTags", showTags);

			renderRequest.setAttribute("nameOfDetailPage", nameOfDetailPage);
			renderRequest.setAttribute("nameOfCreatePage", nameOfCreatePage);
			renderRequest.setAttribute("nameOfApplyPage", nameOfApplyPage);

			renderRequest.setAttribute("numberOfItemsPerPage", numberOfItemsPerPage);
			renderRequest.setAttribute("widthOfItem", widthOfItem);
			renderRequest.setAttribute("heightOfItem", heightOfItem);
			renderRequest.setAttribute("locationVocabularyId", locationVocabularyId);
			renderRequest.setAttribute("categoryVocabularyId", categoryVocabularyId);
			renderRequest.setAttribute("yearOfExperienceVocabularyId", yearOfExperienceVocabularyId);

			renderRequest.setAttribute("titleMaxLength", titleMaxLengthStr);
			renderRequest.setAttribute("descriptionMaxLength", descriptionMaxLengthStr);
			renderRequest.setAttribute("categoriesMaxLength", categoriesMaxLengthStr);
			renderRequest.setAttribute("tagsMaxLength", tagsMaxLengthStr);
			renderRequest.setAttribute("numberOfItemsPerPage", numberOfItemsPerPageStr);

			StringBuffer sb = new StringBuffer();
			List<AssetVocabulary> assetVocabularies = AssetVocabularyLocalServiceUtil.getAssetVocabularies(-1, -1);

			for (AssetVocabulary av : assetVocabularies) {
				sb.append(av.getName() + ": " + av.getVocabularyId() + "; ");
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
		try {
			String action = ParamUtil.getString(actionRequest, "action");

			if (Constants.EDIT.equalsIgnoreCase(action)) {
				PortletPreferences preferences = actionRequest.getPreferences();

				boolean showImage = ParamUtil.getBoolean(actionRequest, "showImage", false);
				boolean showTitle = ParamUtil.getBoolean(actionRequest, "showTitle", false);
				boolean showType = ParamUtil.getBoolean(actionRequest, "showType", false);
				boolean showStartDate = ParamUtil.getBoolean(actionRequest, "showStartDate", false);
				boolean showDescription = ParamUtil.getBoolean(actionRequest, "showDescription", false);
				boolean showCategories = ParamUtil.getBoolean(actionRequest, "showCategories", false);
				boolean showTags = ParamUtil.getBoolean(actionRequest, "showTags", false);

				String nameOfDetailPage = ParamUtil.getString(actionRequest, "nameOfDetailPage");
				String nameOfCreatePage = ParamUtil.getString(actionRequest, "nameOfCreatePage");
				String nameOfApplyPage = ParamUtil.getString(actionRequest, "nameOfApplyPage");

				int numberOfItemsPerPage = ParamUtil.getInteger(actionRequest, "numberOfItemsPerPage",
						_DEFAULT_NUBER_OF_ITEMS_PER_PAGE);

				int widthOfItem = ParamUtil.getInteger(actionRequest, "widthOfItem", _DEFAULT_WIDTH_OF_ITEM);
				int heightOfItem = ParamUtil.getInteger(actionRequest, "heightOfItem", _DEFAULT_HEIGHT_OF_ITEM);

				long locationVocabularyId = ParamUtil.getLong(actionRequest, "locationVocabularyId", 0);
				long categoryVocabularyId = ParamUtil.getLong(actionRequest, "categoryVocabularyId", 0);
				long yearOfExperienceVocabularyId = ParamUtil.getLong(actionRequest, "yearOfExperienceVocabularyId", 0);

				int titleMaxLengthStr = ParamUtil.getInteger(actionRequest, "titleMaxLength",
						_DEFAULT_MAX_LENGTH_OF_TITLE);
				int descriptionMaxLengthStr = ParamUtil.getInteger(actionRequest, "descriptionMaxLength",
						_DEFAULT_MAX_LENGTH_OF_DESCRIPTION);
				int categoriesMaxLengthStr = ParamUtil.getInteger(actionRequest, "categoriesMaxLength",
						_DEFAULT_MAX_LENGTH_OF_CATEGORIES);
				int tagsMaxLengthStr = ParamUtil
						.getInteger(actionRequest, "tagsMaxLength", _DEFAULT_MAX_LENGTH_OF_TAGS);

				preferences.setValue("showImage", String.valueOf(showImage));
				preferences.setValue("showTitle", String.valueOf(showTitle));
				preferences.setValue("showType", String.valueOf(showType));
				preferences.setValue("showStartDate", String.valueOf(showStartDate));
				preferences.setValue("showDescription", String.valueOf(showDescription));
				preferences.setValue("showCategories", String.valueOf(showCategories));
				preferences.setValue("showTags", String.valueOf(showTags));

				preferences.setValue("nameOfDetailPage", nameOfDetailPage);
				preferences.setValue("nameOfCreatePage", nameOfCreatePage);
				preferences.setValue("nameOfApplyPage", nameOfApplyPage);
				preferences.setValue("numberOfItemsPerPage", String.valueOf(numberOfItemsPerPage));
				preferences.setValue("widthOfItem", String.valueOf(widthOfItem));
				preferences.setValue("heightOfItem", String.valueOf(heightOfItem));
				preferences.setValue("locationVocabularyId", String.valueOf(locationVocabularyId));
				preferences.setValue("categoryVocabularyId", String.valueOf(categoryVocabularyId));
				preferences.setValue("yearOfExperienceVocabularyId", String.valueOf(yearOfExperienceVocabularyId));
				preferences.setValue("titleMaxLength", String.valueOf(titleMaxLengthStr));
				preferences.setValue("descriptionMaxLength", String.valueOf(descriptionMaxLengthStr));
				preferences.setValue("categoriesMaxLength", String.valueOf(categoriesMaxLengthStr));
				preferences.setValue("tagsMaxLength", String.valueOf(tagsMaxLengthStr));
				preferences.store();

				actionResponse.setPortletMode(PortletMode.VIEW);
			}
		} catch (Exception e) {
			_log.error(e.getMessage(), e);
		}

		super.processAction(actionRequest, actionResponse);
	}

	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException,
			PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay)resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		PortletPreferences preferences = resourceRequest.getPreferences();
		String nameOfDetailPage = preferences.getValue("nameOfDetailPage", StringPool.BLANK);
		String nameOfApplyPage = preferences.getValue("nameOfApplyPage", StringPool.BLANK);
		String nameOfLandingPage = preferences.getValue("nameOfLandingPage", StringPool.BLANK);
		try {
			String action = ParamUtil.getString(resourceRequest, "action");

			if ("retrieve".equalsIgnoreCase(action)) {
				boolean applyServiceHasAccess = false;
				
				String applyServiceUserStatus ="You do not have the required permission to access this service.";
				HttpServletRequest request = PortalUtil.getHttpServletRequest(resourceRequest);
				String signUpUrl = PortalUtil.getCreateAccountURL(request, themeDisplay);
				String signinUrl = "/signin?redirect=/jobs";
				if(!themeDisplay.isSignedIn()){
					applyServiceUserStatus="Please <a href=" + signinUrl + ">Login</a> to apply for this job.<br/> Not a Member?<a href="  + signUpUrl + ">Join Us</a>";
				}

				if (SambaashUtil.isAdmin(themeDisplay.getScopeGroupId(), themeDisplay.getUserId()) || JobPermissionsUtil.hasJobApplyPermission(themeDisplay,nameOfApplyPage)) {
					applyServiceHasAccess = true;
				}
				_log.debug("applyServiceHasAccess landing page " + applyServiceHasAccess);
				/*SPParameter applyServiceParameter = SPParameterLocalServiceUtil.findBySPParameterGroupIdAndName(
						themeDisplay.getScopeGroupId(), SPJobConstants.JOBS.APPLY_JOB_SERVICE);
				applyServiceStrutsAction = applyServiceParameter.getValue();
				Map<String, Object> parameterMap = new HashMap<String, Object>();
				parameterMap.put("struts_action", applyServiceStrutsAction);
				parameterMap.put("groupId", new Long(themeDisplay.getScopeGroupId()));

				Map<String, Object> applyServiceHasAccessMap = ServiceComponentsLocalServiceUtil.hasAccess(
						parameterMap, themeDisplay.getUser());
				applyServiceHasAccess = (Boolean)applyServiceHasAccessMap
						.get(SambaashConstants.MEMBERSHIP.SERVICE_HASACCESS);
				applyServiceUserStatus = (String)applyServiceHasAccessMap
						.get(SambaashConstants.MEMBERSHIP.SERVICE_REDIRECTURL);*/
				boolean all = ParamUtil.getBoolean(resourceRequest, "all", true);
				int tabIndex = ParamUtil.getInteger(resourceRequest, "tabIndex", 0);
				String selectedLocation = ParamUtil.getString(resourceRequest, "selectedLocation");
				String selectedCategory = ParamUtil.getString(resourceRequest, "selectedCategory");
				String selectedSkills = ParamUtil.getString(resourceRequest, "selectedSkills");
				String selectedExperience = ParamUtil.getString(resourceRequest, "selectedExperience");
				String selectedKeywords = ParamUtil.getString(resourceRequest, "selectedKeywords");

				String edmStartDate = ParamUtil.getString(resourceRequest, "edmStartDate");
				String edmEndDate = ParamUtil.getString(resourceRequest, "edmEndDate");
				
				String format = "MM/dd/yyyy";
				SimpleDateFormat df = new SimpleDateFormat(format);
				Date scheduleDate = new Date();
				if (Validator.isNotNull(edmStartDate)) {
					scheduleDate = df.parse(edmStartDate);
				}
				
				Date scheduleEndDate = new Date();
				if (Validator.isNotNull(edmEndDate)) {
					scheduleEndDate = df.parse(edmEndDate);
				}

				Calendar startValueCalendar = Calendar.getInstance(themeDisplay.getTimeZone(), themeDisplay.getLocale());
				startValueCalendar.setTime(scheduleDate);

				Calendar endValueCalendar = Calendar.getInstance(themeDisplay.getTimeZone(), themeDisplay.getLocale());
				endValueCalendar.setTime(scheduleEndDate);

				String showImage = preferences.getValue("showImage", StringPool.TRUE);
				String showTitle = preferences.getValue("showTitle", StringPool.TRUE);
				String showType = preferences.getValue("showType", StringPool.TRUE);
				String showStartDate = preferences.getValue("showStartDate", StringPool.TRUE);
				String showDescription = preferences.getValue("showDescription", StringPool.TRUE);
				String showCategories = preferences.getValue("showCategories", StringPool.TRUE);
				String showTags = preferences.getValue("showTags", StringPool.TRUE);

				String widthOfItem = preferences.getValue("widthOfItem", String.valueOf(_DEFAULT_WIDTH_OF_ITEM));
				String heightOfItem = preferences.getValue("heightOfItem", String.valueOf(_DEFAULT_HEIGHT_OF_ITEM));

				int currentPage = ParamUtil.getInteger(resourceRequest, "currentPage", 0);

				Map<String, Object> paramsMap = new HashMap<String, Object>();
				paramsMap.put("all", all);
				paramsMap.put("tabIndex", tabIndex);
				paramsMap.put("currentPage", currentPage);
				paramsMap.put("selectedLocation", selectedLocation);
				paramsMap.put("selectedCategory", selectedCategory);
				paramsMap.put("selectedSkills", selectedSkills);
				paramsMap.put("selectedExperience", selectedExperience);
				paramsMap.put("selectedKeywords", selectedKeywords);
				paramsMap.put("startValueCalendar", startValueCalendar);
				paramsMap.put("endValueCalendar", endValueCalendar);

				Map<String, Object> resultsMap = search(themeDisplay, preferences, paramsMap);

				@SuppressWarnings("unchecked")
				List<SPJobWrapper> jobWrappers = (List<SPJobWrapper>) resultsMap.get("jobWrappers");
				int count = (Integer) resultsMap.get("count");
				JSONObject data = JSONFactoryUtil.createJSONObject();
				JSONArray items = JSONFactoryUtil.createJSONArray();
				JSONObject countJSONObject = JSONFactoryUtil.createJSONObject();
				countJSONObject.put("value", count);

				for (SPJobWrapper jobWrapper : jobWrappers) {
					JSONObject item = JSONFactoryUtil.createJSONObject();
					StringBuffer sb = new StringBuffer();

					ResourceURL deleteJobURL = resourceResponse.createResourceURL();
					deleteJobURL.setParameter("action", "delete");
					deleteJobURL.setParameter("id", String.valueOf(jobWrapper.getJobId()));

					sb.append("<li data-job-entry-id=\"" + jobWrapper.getJobId()
							+ "\" class=\"spjobs-entry\" name=\"spjobs-list\" style=\"width: " + widthOfItem +
							"px; height: " + heightOfItem + "px; \">");

					if (StringPool.TRUE.equalsIgnoreCase(showImage)) {
						sb.append("<p class=\"spjobs-mbs\"><a href=\"" + jobWrapper.getDetailUrl() + "\"><img alt=\"Job Image\" src=\"" +
								jobWrapper.getPreviewImageUrl()
								+ "\" width=\"100%\" style=\"border:1px solid #000;height:122px\"/></a></p>");
					}

					if (StringPool.TRUE.equalsIgnoreCase(showTitle)) {
						sb.append("<p class=\"spjobs-mbs\"><b>" + jobWrapper.getTitle() + "</b></p>");
					}

					if (StringPool.TRUE.equalsIgnoreCase(showType)) {
						sb.append("<p class=\"spjobs-mbs\">" + jobWrapper.getType() + "</p>");
					}

					if (StringPool.TRUE.equalsIgnoreCase(showStartDate)) {
						sb.append("<label>Start Date: </label>");
						sb.append("<p class=\"spjobs-mbs\">" + jobWrapper.getStartDate() + "</p>");
					}

					if (StringPool.TRUE.equalsIgnoreCase(showDescription)) {
						sb.append("<p><label>Description:</label></p>");
						sb.append("<p class=\"spjobs-mbs\" style=\"min-height:50px;max-height:50px;overflow:hidden\">" +
								jobWrapper.getDescription() + "</p>");
					}

					if (StringPool.TRUE.equalsIgnoreCase(showCategories)) {
						sb.append("<label>Categories: </label>");
						sb.append("<p class=\"spjobs-mbs\" style=\"min-height:18px;max-height:18px;overflow:hidden\">" +
								jobWrapper.getCategoryNames() + "</p>");
					}

					if (StringPool.TRUE.equalsIgnoreCase(showTags)) {
						sb.append("<label>Skills: </label>");
						sb.append("<p class=\"spjobs-mbm\" style=\"min-height:18px;max-height:18px;overflow:hidden\">" +
								jobWrapper.getTagNames() + "</p>");
					}

					sb.append("<a href=\"" + jobWrapper.getDetailUrl() + "\">" + "<b>&gt;&nbsp;More details</b></a>");
					sb.append(StringPool.NBSP + StringPool.NBSP);

					/**if (themeDisplay.isSignedIn()) {
						if (SPJobStatus.ACTIVE.getValue().equalsIgnoreCase(jobWrapper.getStatus())) {
							if (themeDisplay.getUserId() == jobWrapper.getUserId()) {
								sb.append("<a class=\"spjobs-owner-cannot-apply\" name=\"The member who posted the job can't apply for it.\""
										+ "title=\"Application Denied\"><span name=\"applyJob\"><b>&gt;&nbsp;Apply</b></span></a>");

							} else if (applyServiceHasAccess) {
								sb.append("<a href=\"/" + nameOfApplyPage + "?id=" + jobWrapper.getJobId() +
										"&show=apply\">"
										+ "<span class=\"applyjobs\" name=\"applyJob\"><b>&gt;&nbsp;Apply</b></span></a>");
							} else {
								sb.append("<a class=\"spjobs-service-access\" name=\"" +
										applyServiceUserStatus + "\""
										+ "title=\"Permission Denied\"><span name=\"applyJob\"><b>&gt;&nbsp;Apply</b></span></a>");
							}
						}
					} else {
						sb.append("<a class=\"spjobs-service-access\" name=\"" + applyServiceUserStatus +
								"\""
								+ "title=\"Login\"><span name=\"applyJob\"><b>&gt;&nbsp;Apply</b></span></a>");
					}**/

					sb.append(StringPool.NBSP + StringPool.NBSP);

					if (SambaashUtil.isAdmin(themeDisplay.getScopeGroupId(), themeDisplay.getUserId())
							|| themeDisplay.getUserId() == jobWrapper.getUserId()) {
						sb.append("<a href=\"javascript:" + themeDisplay.getPortletDisplay().getNamespace()
								+ "deleteJob('" + deleteJobURL + "');\">" + "<b>&gt;&nbsp;Delete</b></a>");
					}

					sb.append("</li>");

					item.put("html", sb.toString());
					items.put(item);
				}

				data.put("items", items);
				data.put("count", countJSONObject);

				resourceResponse.setContentType("application/json");
				resourceResponse.setCharacterEncoding("utf-8");
				resourceResponse.getWriter().write(data.toString());
			} else if ("delete".equalsIgnoreCase(action)) {
				JSONObject data = JSONFactoryUtil.createJSONObject();
				long spJobId = ParamUtil.getLong(resourceRequest, "id", 0);
				SPJobLocalServiceUtil.closeJob(spJobId);
				data.put("id", spJobId);
				resourceResponse.setContentType("application/json");
				resourceResponse.setCharacterEncoding("utf-8");
				resourceResponse.getWriter().write(data.toString());
			}
		} catch (Exception e) {
			_log.error(e.getMessage(), e);
		}

		super.serveResource(resourceRequest, resourceResponse);
	}

	private Map<String, Object> search(ThemeDisplay themeDisplay, PortletPreferences preferences,
			Map<String, Object> paramsMap) {

		boolean all = (Boolean) paramsMap.get("all");
		int tabIndex = (Integer) paramsMap.get("tabIndex");
		int currentPage = (Integer) paramsMap.get("currentPage");
		String selectedLocation = (String) paramsMap.get("selectedLocation");
		String selectedCategory = (String) paramsMap.get("selectedCategory");
		String selectedSkills = (String) paramsMap.get("selectedSkills");
		String selectedExperience = (String) paramsMap.get("selectedExperience");

		String selectedKeywords = (String) paramsMap.get("selectedKeywords");

		Calendar startValueCalendar = (Calendar) paramsMap.get("startValueCalendar");
		Calendar endValueCalendar = (Calendar) paramsMap.get("endValueCalendar");

		Map<String, Object> resultsMap = new HashMap<String, Object>();
		String titleMaxLengthStr = preferences.getValue("titleMaxLength", String.valueOf(_DEFAULT_MAX_LENGTH_OF_TITLE));
		String descriptionMaxLengthStr = preferences.getValue("descriptionMaxLength", StringPool.BLANK);
		String categoriesMaxLengthStr = preferences.getValue("categoriesMaxLength",
				String.valueOf(_DEFAULT_MAX_LENGTH_OF_CATEGORIES));
		String tagsMaxLengthStr = preferences.getValue("tagsMaxLength", String.valueOf(_DEFAULT_MAX_LENGTH_OF_TAGS));
		String numberOfItemsPerPageStr = preferences.getValue("numberOfItemsPerPage",
				String.valueOf(_DEFAULT_NUBER_OF_ITEMS_PER_PAGE));
		String nameOfDetailPage = preferences.getValue("nameOfDetailPage", StringPool.BLANK);

		int numberOfItemsPerPage = _DEFAULT_NUBER_OF_ITEMS_PER_PAGE;
		int titleMaxLength = _DEFAULT_MAX_LENGTH_OF_TITLE;
		int descriptionMaxLength = _DEFAULT_MAX_LENGTH_OF_DESCRIPTION;
		int categoriesMaxLength = _DEFAULT_MAX_LENGTH_OF_CATEGORIES;
		int tagsMaxLength = _DEFAULT_MAX_LENGTH_OF_TAGS;
		try {
			numberOfItemsPerPage = Integer.valueOf(numberOfItemsPerPageStr);
		} catch (NumberFormatException nfe) {

			// do nothing

		}

		try {
			titleMaxLength = Integer.valueOf(titleMaxLengthStr);
		} catch (NumberFormatException nfe) {

			// do nothing

		}

		try {
			descriptionMaxLength = Integer.valueOf(descriptionMaxLengthStr);
		} catch (NumberFormatException nfe) {

			// do nothing

		}

		try {
			categoriesMaxLength = Integer.valueOf(categoriesMaxLengthStr);
		} catch (NumberFormatException nfe) {

			// do nothing

		}

		try {
			tagsMaxLength = Integer.valueOf(tagsMaxLengthStr);
		} catch (NumberFormatException nfe) {

			// do nothing

		}

		int start = currentPage * numberOfItemsPerPage;
		int end = (currentPage + 1) * numberOfItemsPerPage;

		List<SPJobWrapper> jobWrappers = new ArrayList<SPJobWrapper>();
		int count = 0;
		try {
			SearchContext searchContext = new SearchContext();
			searchContext.setCompanyId(themeDisplay.getCompanyId());
			searchContext.setSorts(jobSorts);
			searchContext.setStart(start);
			searchContext.setEnd(end);

			List<BooleanClause> filterBooleanClauseList = new ArrayList<BooleanClause>();

			if (tabIndex == 0) {
				if (Validator.isNotNull(selectedLocation)) {
					BooleanQuery booleanQuery = BooleanQueryFactoryUtil.create(searchContext);
					booleanQuery.addTerm("jobLocation", "\"" + selectedLocation + "\"");
					BooleanClause booleanClause = BooleanClauseFactoryUtil.create(searchContext, booleanQuery,
							BooleanClauseOccur.MUST.getName());
					filterBooleanClauseList.add(booleanClause);
				}

				if (Validator.isNotNull(selectedCategory)) {
					BooleanQuery booleanQuery = BooleanQueryFactoryUtil.create(searchContext);
					booleanQuery.addTerm("assetCategoryNames", selectedCategory);
					BooleanClause booleanClause = BooleanClauseFactoryUtil.create(searchContext, booleanQuery,
							BooleanClauseOccur.MUST.getName());
					filterBooleanClauseList.add(booleanClause);
				}

				if (Validator.isNotNull(selectedSkills)) {
					BooleanQuery booleanQuery = BooleanQueryFactoryUtil.create(searchContext);
					booleanQuery.addTerm("assetTagNames", selectedSkills);
					BooleanClause booleanClause = BooleanClauseFactoryUtil.create(searchContext, booleanQuery,
							BooleanClauseOccur.MUST.getName());
					filterBooleanClauseList.add(booleanClause);
				}

				if (Validator.isNotNull(selectedExperience)) {
					BooleanQuery booleanQuery = BooleanQueryFactoryUtil.create(searchContext);
					booleanQuery.addTerm("yearsOfExperience", "\"" + selectedExperience + "\"");
					BooleanClause booleanClause = BooleanClauseFactoryUtil.create(searchContext, booleanQuery,
							BooleanClauseOccur.MUST.getName());
					filterBooleanClauseList.add(booleanClause);
				}

				Calendar now = Calendar.getInstance(themeDisplay.getTimeZone(), themeDisplay.getLocale());
				_log.debug("startValueCalendar " + startValueCalendar + " endValueCalendar " + endValueCalendar);
				if (now.get(Calendar.YEAR) == startValueCalendar.get(Calendar.YEAR)
						&& now.get(Calendar.MONTH) == startValueCalendar.get(Calendar.MONTH)
						&& now.get(Calendar.DAY_OF_MONTH) == startValueCalendar.get(Calendar.DAY_OF_MONTH)
						&& now.get(Calendar.YEAR) == endValueCalendar.get(Calendar.YEAR)
						&& now.get(Calendar.MONTH) == endValueCalendar.get(Calendar.MONTH)
						&& now.get(Calendar.DAY_OF_MONTH) == endValueCalendar.get(Calendar.DAY_OF_MONTH)) {

					// no changes

				} else {
		String fromDateStr = indexerDateFormat.format(startValueCalendar.getTime());
		String toDateStr = indexerDateFormat.format(endValueCalendar.getTime());

		BooleanQuery booleanQuery = BooleanQueryFactoryUtil.create(searchContext);
		booleanQuery.addRangeTerm(SPJobFieldUtil.JOB_START_DATE, Long.valueOf(fromDateStr).longValue(), Long.valueOf(toDateStr).longValue());

					BooleanClause booleanClause = BooleanClauseFactoryUtil.create(searchContext, booleanQuery,
							BooleanClauseOccur.MUST.getName());
					filterBooleanClauseList.add(booleanClause);

				}
			}

			List<BooleanClause> allBooleanClauseList = new ArrayList<BooleanClause>();

			// Start -- filter out expired jobs

//			if (!SambaashUtil.isAdmin(themeDisplay.getScopeGroupId(), themeDisplay.getUserId())) {
				Calendar now = Calendar.getInstance(themeDisplay.getTimeZone(), themeDisplay.getLocale());
				Calendar yearsLater = Calendar.getInstance(themeDisplay.getTimeZone(), themeDisplay.getLocale());
				int curYear = now.get(Calendar.YEAR);
				yearsLater.set(Calendar.YEAR, curYear + 100);

	String fromDateStr = indexerDateFormat.format(now.getTime());
	String toDateStr = indexerDateFormat.format(yearsLater.getTime());

	BooleanQuery booleanQuery = BooleanQueryFactoryUtil.create(searchContext);
	booleanQuery.addRangeTerm(SPJobFieldUtil.JOB_CLOSING_DATE, Long.valueOf(fromDateStr).longValue(), Long.valueOf(toDateStr).longValue());

				BooleanClause booleanClause = BooleanClauseFactoryUtil.create(searchContext, booleanQuery,
						BooleanClauseOccur.MUST.getName());
				allBooleanClauseList.add(booleanClause);

//			}

			// End -- filter out expired jobs

			// Start -- filter out draft jobs

			booleanQuery = BooleanQueryFactoryUtil.create(searchContext);

			booleanQuery.addTerm(SPJobFieldUtil.JOB_STATUS, SPJobStatus.ACTIVE.getValue());
			BooleanQuery paramQuery1 = BooleanQueryFactoryUtil.create(searchContext);
			paramQuery1.addTerm(SPJobFieldUtil.JOB_STATUS, SPJobStatus.DRAFT.getValue());
			BooleanQuery paramQuery2 = BooleanQueryFactoryUtil.create(searchContext);
			paramQuery2.addTerm(Field.USER_ID, themeDisplay.getUserId());
			paramQuery1.add(paramQuery2, BooleanClauseOccur.MUST.getName());
			booleanQuery.add(paramQuery1, BooleanClauseOccur.SHOULD.getName());

			booleanClause = BooleanClauseFactoryUtil.create(searchContext, booleanQuery, BooleanClauseOccur.MUST.getName());
			allBooleanClauseList.add(booleanClause);

			// end -- filter out draft jobs

			if (!all) {
				for (int i = 0; i < filterBooleanClauseList.size(); i++) {
					allBooleanClauseList.add(filterBooleanClauseList.get(i));
				}
			}

			BooleanClause[] booleanClauses = new BooleanClause[allBooleanClauseList.size()];

			for (int i = 0; i < allBooleanClauseList.size(); i++) {
				booleanClauses[i] = allBooleanClauseList.get(i);
			}

			searchContext.setBooleanClauses(booleanClauses);
			Indexer indexer = IndexerRegistryUtil.getIndexer(SPJob.class.getName());

			if (tabIndex == 1) {
				if (Validator.isNotNull(selectedKeywords)) {
					searchContext.setKeywords(selectedKeywords);
				}
			}

			Hits results = indexer.search(searchContext);
			count = results.getLength();

			for (int i = 0; i < results.getDocs().length; i++) {
				Document doc = results.doc(i);
				long jobId = GetterUtil.getLong(doc.get(Field.ENTRY_CLASS_PK));
				long userId = GetterUtil.getLong(doc.get(Field.USER_ID));
				String jobTitle = GetterUtil.getString(doc.get(Field.TITLE));
				String jobDescription = GetterUtil.getString(doc.get(Field.DESCRIPTION));
				String jobType = GetterUtil.getString(doc.get(SPJobFieldUtil.JOB_TYPE));
				String jobStatus = GetterUtil.getString(doc.get(SPJobFieldUtil.JOB_STATUS));
				String assetTagNames = GetterUtil.getString(doc.get(Field.ASSET_TAG_NAMES));
				String assetCategoryNames = GetterUtil.getString(doc.get(SPJobFieldUtil.ASSET_CATEGORY_NAMES));

				Date createDate = null;
				Date startDate = null;
				Date endDate = null;
				Date closeDate = null;

				if (Validator.isNotNull(doc.get(SPJobFieldUtil.JOB_CREATE_DATE))) {
					createDate = GetterUtil.getDate(doc.getDate(SPJobFieldUtil.JOB_CREATE_DATE),
							DateFormat.getDateInstance());
				}

				if (Validator.isNotNull(doc.get(SPJobFieldUtil.JOB_START_DISPLAY_DATE))) {
					startDate = GetterUtil.getDate(doc.getDate(SPJobFieldUtil.JOB_START_DISPLAY_DATE),
							DateFormat.getDateInstance());
				}

				if (Validator.isNotNull(doc.get(SPJobFieldUtil.JOB_END_DATE))) {
					endDate = GetterUtil
							.getDate(doc.getDate(SPJobFieldUtil.JOB_END_DATE), DateFormat.getDateInstance());
				}

				if (Validator.isNotNull(doc.get(SPJobFieldUtil.JOB_CLOSING_DATE))) {
					closeDate = GetterUtil.getDate(doc.getDate(SPJobFieldUtil.JOB_CLOSING_DATE),
							DateFormat.getDateInstance());
				}

				String jobSmallImageDocId = GetterUtil.getString(doc.get(SPJobFieldUtil.JOB_SMALL_IMAGE_DOC_ID));
				String jobPreviewImageUrl = "/image/image_gallery?img_id=" + jobSmallImageDocId;

				// String jobPreviewImageUrl =
				// "http://sambaash.emeriocorp.com/image/image_gallery?img_id=34980";

				SPJobWrapper jobWrapper = new SPJobWrapper();
				jobWrapper.setJobId(jobId);
				jobWrapper.setUserId(userId);
				jobWrapper.setType(jobType);
				jobWrapper.setTitle(StringUtil.shorten(jobTitle, titleMaxLength, "..."));
				jobWrapper.setDescription(StringUtil.shorten(HtmlUtil.extractText(jobDescription),
						descriptionMaxLength, "..."));
				jobWrapper.setCategoryNames(StringUtil.shorten(assetCategoryNames, categoriesMaxLength, "..."));
				jobWrapper.setTagNames(StringUtil.shorten(assetTagNames, tagsMaxLength, "..."));
				jobWrapper.setCreateDate(createDate);
				jobWrapper.setStartDate(Validator.isNotNull(startDate) ? DateFormat.getDateInstance().format(startDate)
						: _NOT_AVAILABLE);
				jobWrapper.setEndDate(Validator.isNotNull(endDate) ? DateFormat.getDateInstance().format(endDate)
						: _NOT_AVAILABLE);
				jobWrapper.setCloseDate(Validator.isNotNull(closeDate) ? DateFormat.getDateInstance().format(closeDate)
						: _NOT_AVAILABLE);
				jobWrapper.setStatus(jobStatus);
				jobWrapper.setPreviewImageUrl(jobPreviewImageUrl);
				jobWrapper.setDetailUrl("/" + nameOfDetailPage + "?id=" + jobId);

				jobWrappers.add(jobWrapper);
			}
		} catch (Exception e) {
			_log.error(e.getMessage(), e);
		}

		resultsMap.put("jobWrappers", jobWrappers);
		resultsMap.put("count", count);

		return resultsMap;
	}

	private static Sort[] jobSorts = new Sort[] {
			SortFactoryUtil.create(SPJobFieldUtil.JOB_WEIGHTAGE, Sort.LONG_TYPE, true),
			SortFactoryUtil.create(SPJobFieldUtil.JOB_CREATE_DATE, Sort.LONG_TYPE, true) };

	private static final int _DEFAULT_WIDTH_OF_ITEM = 187;
	private static final int _DEFAULT_HEIGHT_OF_ITEM = 390;
	private static final int _DEFAULT_MAX_LENGTH_OF_TITLE = 150;
	private static final int _DEFAULT_MAX_LENGTH_OF_DESCRIPTION = 150;
	private static final int _DEFAULT_MAX_LENGTH_OF_CATEGORIES = 100;
	private static final int _DEFAULT_MAX_LENGTH_OF_TAGS = 100;
	private static final int _DEFAULT_NUBER_OF_ITEMS_PER_PAGE = 9;

	private static final String _NOT_AVAILABLE = "Not available";
	private static final String SOURCE_DATE_FORMAT_PATTERN = "MM/dd/yyyy";

	private static final SimpleDateFormat sdfSource = new SimpleDateFormat(SOURCE_DATE_FORMAT_PATTERN, Locale.getDefault());

	private static final SimpleDateFormat indexerDateFormat = new SimpleDateFormat(PropsUtil.get(PropsKeys.INDEX_DATE_FORMAT_PATTERN));

	private static Log _log = LogFactoryUtil.getLog(SPJobLandingAction.class);

}
