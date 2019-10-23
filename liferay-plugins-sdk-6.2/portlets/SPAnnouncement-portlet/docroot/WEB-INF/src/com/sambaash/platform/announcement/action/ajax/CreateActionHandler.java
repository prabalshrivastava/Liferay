package com.sambaash.platform.announcement.action.ajax;

import java.io.IOException;
import java.util.List;

import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.sambaash.platform.action.ServeResourceActionHandler;
import com.sambaash.platform.announcement.config.GenericSearchConfig;
import com.sambaash.platform.announcement.config.GenericSearchConstants;
import com.sambaash.platform.announcement.helper.GenericSearchHelper;
import com.sambaash.platform.announcement.helper.GenericSearchHelper.GSSearchItems;
import com.sambaash.platform.srv.genericsearch.model.GSFavourite;
import com.sambaash.platform.srv.genericsearch.service.GSFavouriteLocalServiceUtil;
import com.sambaash.platform.systemmodelsetup.service.SystemLocalServiceUtil;

public class CreateActionHandler implements ServeResourceActionHandler {

	private Log _log = LogFactoryUtil.getLog(CreateActionHandler.class.getName());

	@Override
	public void handle(ResourceRequest request, ResourceResponse response) {
		String output = "";// formType
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		GSFavourite gsfavourite;
		String searchText = "bi";
		if (request.getParameter("formType").equalsIgnoreCase("Announcement")) {
			JSONObject jsonData;
			try {

				jsonData = JSONFactoryUtil.createJSONObject(request.getParameter("data"));
				gsfavourite = GSFavouriteLocalServiceUtil.getGSFavourite(jsonData.getLong("TargetAudience"));
				JSONObject jsonConfig = JSONFactoryUtil.createJSONObject(gsfavourite.getConfig());
				searchText = jsonConfig.getString("textSearchInput");
			} catch (SystemException | PortalException e) {
				_log.error(e);
			}
			request.setAttribute("searchText", searchText);
			String loadObjects = "loadObject";
			GenericSearchConfig config = readConfig(request, themeDisplay);
			if (Validator.isNotNull(loadObjects)) {
				try {
					List<Document> documents = determineAndSearch(request, themeDisplay, config, false);
					JSONArray userList = JSONFactoryUtil.createJSONArray();
					for (int i = 0; i < documents.size(); i++) {
						userList.put(documents.get(i).get("userId"));
					}
					String userList1 = "";
					for (int i = 0; i < userList.length(); i++) {
						userList1 = userList1 + "--" + userList.getString((i));
					}
					request.setAttribute("userList", userList1);

					output = SystemLocalServiceUtil.multiCreateRecord(request, response);
					// return;
				} catch (Exception e) {
					_log.error("Error while loading objects", e);
				}
			}
		} else {
			if (request.getParameter("formStorageId").isEmpty() || request.getParameter("formStorageId").equals("0")) {
				output = SystemLocalServiceUtil.createRecord(request, response);
			} else {
				output = SystemLocalServiceUtil.updateRecord(request, response);
			}
		}

		try {
			response.getWriter().write(output);
		} catch (IOException e) {
			_log.error(e);
		}
	}

	private GenericSearchConfig readConfig(PortletRequest renderRequest, ThemeDisplay themeDisplay) {

		GenericSearchHelper helper = new GenericSearchHelper();
		String[] enabledComponentClasses = GenericSearchHelper.getEnabledComponentClasses(renderRequest);
		GenericSearchConfig config = null;
		if (enabledComponentClasses != null && enabledComponentClasses.length > 0) {
			config = helper.parseConfiguration(renderRequest.getPreferences());
			renderRequest.setAttribute(GenericSearchConstants.ATTRIB_CONFIG_OBJ, config);
		}
		return config;
	}

	private List<Document> determineAndSearch(PortletRequest req, ThemeDisplay themeDisp, GenericSearchConfig config,
			Boolean returnAllDocs) throws Exception {
		return searchNew(req, themeDisp, config, returnAllDocs);
	}

	private List<Document> searchNew(PortletRequest req, ThemeDisplay themeDisp, GenericSearchConfig config,
			Boolean returnAllDocs) throws Exception {
		String[] classes = GenericSearchHelper.getEnabledComponentClasses(req);
		PortletPreferences preferences = req.getPreferences();

		if (ArrayUtil.isEmpty(classes) || (classes.length == 1 && ArrayUtil.contains(classes, StringPool.BLANK))) {

			return null;
		}
		int start = 0;
		int end = 10000;
		GenericSearchHelper.GSSearchItems searchItems = getSearchItems(req);
		GenericSearchHelper helper = new GenericSearchHelper();
		return helper.search(themeDisp.getCompanyId(), themeDisp.getScopeGroupId(), start, end, config, searchItems);
	}

	private GSSearchItems getSearchItems(PortletRequest request) throws JSONException {

		String searchItemsStr = ParamUtil.getString(request, GenericSearchConstants.ATTRIB_SEARCH_ITEMS); // set
		JSONObject searchItemsJson = JSONFactoryUtil.createJSONObject(searchItemsStr);
		String[] classes = GenericSearchHelper.getEnabledComponentClasses(request);
		GenericSearchHelper.GSSearchItems searchItems = new GenericSearchHelper.GSSearchItems(searchItemsJson, classes);
		searchItems.setSearchText(request.getAttribute("searchText").toString());
		return searchItems;
	}

}
