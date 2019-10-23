package com.sambaash.platform.invigilatormanagement.viewappointments;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.PortletModeException;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.ReadOnlyException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.ValidatorException;

import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletClassLoaderUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.model.AssetTag;
import com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetTagLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.sambaash.platform.action.DefaultServeResourceManager;
import com.sambaash.platform.action.ServeResourceActionManager;
import com.sambaash.platform.constant.SystemSetupConstants;
import com.sambaash.platform.invigilatormanagement.action.ajax.ArchiveActionHandler;
import com.sambaash.platform.invigilatormanagement.action.ajax.CheckEmailActionHandler;
import com.sambaash.platform.invigilatormanagement.action.ajax.CreateActionHandler;
import com.sambaash.platform.invigilatormanagement.action.ajax.ElasticSearchListActionHandler;
import com.sambaash.platform.invigilatormanagement.action.ajax.ExportListActionHandler;
import com.sambaash.platform.invigilatormanagement.action.ajax.ExportRowActionHandler;
import com.sambaash.platform.invigilatormanagement.action.ajax.FetchActionHandler;
import com.sambaash.platform.invigilatormanagement.action.ajax.FetchFormFieldsActionHandler;
import com.sambaash.platform.invigilatormanagement.action.ajax.FetchGroupActionHandler;
import com.sambaash.platform.invigilatormanagement.action.ajax.FetchUniqueDataActionHandler;
import com.sambaash.platform.invigilatormanagement.action.ajax.FetchUpcommingFacilityScheduleActionHandler;
import com.sambaash.platform.invigilatormanagement.action.ajax.FileDownloadActionHandler;
import com.sambaash.platform.invigilatormanagement.action.ajax.FilterColumnListActionHandler;
import com.sambaash.platform.invigilatormanagement.action.ajax.LoadListActionHandler;
import com.sambaash.platform.invigilatormanagement.action.ajax.SearchListActionHandler;
import com.sambaash.platform.invigilatormanagement.application.InvigilatorApplicationPortlet;

/**
 * Portlet implementation class ViewAppointments
 */
public class ViewAppointments extends MVCPortlet {
	private static final Log logger = LogFactoryUtil.getLog(ViewAppointments.class);
	
	private static final ServeResourceActionManager SERVE_RESOURCE_MANAGER;
	static {

		SERVE_RESOURCE_MANAGER = new DefaultServeResourceManager();
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("elastiSearchList", ElasticSearchListActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("filterColumnList", FilterColumnListActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("loadData", FetchActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("exportList", ExportListActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("fileDownload", FileDownloadActionHandler.class);
		
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("groupName", FetchGroupActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("getUniqueData", FetchUniqueDataActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("uocommingFacilitySchedule",
				FetchUpcommingFacilityScheduleActionHandler.class);

	}
	/**
	 * This is an object of Log class
	 */
	private Log log = LogFactoryUtil.getLog(InvigilatorApplicationPortlet.class.getName());

	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException {
		try {
			String action = resourceRequest.getParameter("action");
			SERVE_RESOURCE_MANAGER.newHandler(action).handle(resourceRequest, resourceResponse);

		} catch (Exception e) {
			log.error(e);
		}
	}

	public void savePreferences(ActionRequest actionRequest, ActionResponse actionResponse) {
		PortletPreferences preferences = actionRequest.getPreferences();
		String style = ParamUtil.getString(actionRequest, SystemSetupConstants.PREF_CONTAINER_STYLE, "");
		String baseUrl = ParamUtil.getString(actionRequest, SystemSetupConstants.PREF_BASE_URL, "");
		try {
			preferences.setValue(SystemSetupConstants.PREF_CONTAINER_STYLE, style);
			preferences.setValue(SystemSetupConstants.PREF_BASE_URL, baseUrl);
			preferences.store();
			actionResponse.setPortletMode(PortletMode.VIEW);
		} catch (ReadOnlyException | ValidatorException | IOException | PortletModeException e) {
			log.error(e);
		}

	}

	
}
