package com.sambaash.platform.mastertimetable.timetable;

import java.io.IOException;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.model.AssetVocabulary;
import com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetVocabularyLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.sambaash.platform.action.DefaultServeResourceManager;
import com.sambaash.platform.action.ServeResourceActionManager;
import com.sambaash.platform.constant.SystemSetupConstants;
import com.sambaash.platform.mastertimetable.ajax.CreateActionHandler;
import com.sambaash.platform.mastertimetable.ajax.ElasticSearchListActionHandler;
import com.sambaash.platform.mastertimetable.ajax.ExportListActionHandler;
import com.sambaash.platform.mastertimetable.ajax.ExportRowActionHandler;
import com.sambaash.platform.mastertimetable.ajax.FetchActionHandler;
import com.sambaash.platform.mastertimetable.ajax.FetchFormFieldsActionHandler;
import com.sambaash.platform.mastertimetable.ajax.FileDownloadActionHandler;
import com.sambaash.platform.mastertimetable.ajax.FilterColumnListActionHandler;
import com.sambaash.platform.mastertimetable.ajax.LoadListActionHandler;
import com.sambaash.platform.mastertimetable.ajax.SearchListActionHandler;

/**
 * Portlet implementation class InvigilatorAttendance
 */
public class MasterTimetable extends MVCPortlet {
	private static final ServeResourceActionManager SERVE_RESOURCE_MANAGER;
	private static final String SCHEDULE_VOCABUALRY = "Schedule Category";
	private Log log = LogFactoryUtil.getLog(MasterTimetable.class.getName());
	static {
		SERVE_RESOURCE_MANAGER = new DefaultServeResourceManager();
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("loadData",
				FetchActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("fetchFormFields",
				FetchFormFieldsActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("loadList",
				LoadListActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("searchList",
				SearchListActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler(
				"elastiSearchList", ElasticSearchListActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler(
				"filterColumnList", FilterColumnListActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("exportRow",
				ExportRowActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("exportList",
				ExportListActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("fileDownload",
				FileDownloadActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("persist",
				CreateActionHandler.class);
	}

	@Override
	public void doEdit(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest
					.getAttribute(WebKeys.THEME_DISPLAY);

			AssetVocabulary assetVocabulary = AssetVocabularyLocalServiceUtil
					.getGroupVocabulary(themeDisplay.getScopeGroupId(),
							SCHEDULE_VOCABUALRY);

			List<AssetCategory> categories = AssetCategoryLocalServiceUtil
					.getVocabularyCategories(assetVocabulary.getVocabularyId(),
							-1, -1, null);
			JSONArray assetCategoriesJSONArray = JSONFactoryUtil
					.createJSONArray();

			for (AssetCategory ac : categories) {
				assetCategoriesJSONArray.put(ac.getName().trim());
			}
			assetCategoriesJSONArray.put("Subject");
			renderRequest.setAttribute("assetCategoriesJSONOArray",
					assetCategoriesJSONArray.toString());

		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		super.doEdit(renderRequest, renderResponse);
	}

	/**
	 * This is an object of Log class
	 */

	@Override
	public void serveResource(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws IOException,
			PortletException {
		try {
			String action = resourceRequest.getParameter("action");
			SERVE_RESOURCE_MANAGER.newHandler(action).handle(resourceRequest,
					resourceResponse);
		} catch (Exception e) {
			log.error(e);
		}
	}

	public void savePreferences(ActionRequest actionRequest,
			ActionResponse actionResponse) {

		PortletPreferences preferences = actionRequest.getPreferences();
		String formId = ParamUtil.getString(actionRequest,
				SystemSetupConstants.PREF_HTML_FORM_ID, "0");
		String style = ParamUtil.getString(actionRequest,
				SystemSetupConstants.PREF_CONTAINER_STYLE, "");
		String modelName = ParamUtil.getString(actionRequest,
				SystemSetupConstants.PREF_MODEL_NAME, "0");
		String baseUrl = ParamUtil.getString(actionRequest,
				SystemSetupConstants.PREF_BASE_URL, "");
		String selectedCategory = ParamUtil.getString(actionRequest,
				"selectedCategory");
		try {
			preferences
					.setValue(SystemSetupConstants.PREF_HTML_FORM_ID, formId);
			preferences.setValue(SystemSetupConstants.PREF_CONTAINER_STYLE,
					style);
			preferences.setValue(SystemSetupConstants.PREF_MODEL_NAME,
					modelName);
			preferences.setValue(SystemSetupConstants.PREF_BASE_URL, baseUrl);
			preferences.setValue(SystemSetupConstants.PREF_SELECTED_CATEGORY, selectedCategory);
			preferences.store();
			actionResponse.setPortletMode(PortletMode.VIEW);
		} catch (Exception e) {
			log.error(e);
		}
	}
}
