package com.sambaash.platform.enquiry;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.PortletModeException;
import javax.portlet.PortletPreferences;
import javax.portlet.ReadOnlyException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.ValidatorException;

import org.json.JSONObject;

import com.liferay.compat.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletClassLoaderUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.sambaash.platform.action.DefaultServeResourceManager;
import com.sambaash.platform.action.ServeResourceActionManager;
import com.sambaash.platform.action.ajax.ArchiveActionHandler;
import com.sambaash.platform.action.ajax.CreateActionHandler;
import com.sambaash.platform.action.ajax.ElasticSearchListActionHandler;
import com.sambaash.platform.action.ajax.FetchActionHandler;
import com.sambaash.platform.action.ajax.FetchDataTypeListActionHandler;
import com.sambaash.platform.action.ajax.FetchFormFieldsActionHandler;
import com.sambaash.platform.action.ajax.LoadListActionHandler;
import com.sambaash.platform.action.ajax.SearchListActionHandler;
import com.sambaash.platform.action.ajax.UpdateSettingsListActionHandler;
import com.sambaash.platform.constant.PEConstantsGlobal;
import com.sambaash.platform.srv.processbuilder.model.PEProcessAudit;
import com.sambaash.platform.srv.processbuilder.model.PEProcessState;
import com.sambaash.platform.srv.processbuilder.service.PEProcessAuditLocalServiceUtil;
import com.sambaash.platform.srv.processbuilder.service.PEProcessStateLocalServiceUtil;

/**
 * Portlet implementation class EnquiryPortlet
 */
public class EnquiryPortlet extends MVCPortlet {

	private static final ServeResourceActionManager SERVE_RESOURCE_MANAGER;
	static {
		SERVE_RESOURCE_MANAGER = new DefaultServeResourceManager();
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("persist", CreateActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("loadData", FetchActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("fetchFormFields", FetchFormFieldsActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("loadList", LoadListActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("archive", ArchiveActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("searchList", SearchListActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("elastiSearchList", ElasticSearchListActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("fetchList", FetchDataTypeListActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("updateSettings", UpdateSettingsListActionHandler.class);

	}
	/**
	 * This is an object of Log class
	 */

	private Log _log = LogFactoryUtil.getLog(EnquiryPortlet.class.getName());

	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException {
		try {
			String action = resourceRequest.getParameter("action");

			SERVE_RESOURCE_MANAGER.newHandler(action).handle(resourceRequest, resourceResponse);
		} catch (Exception e) {
			_log.error(e);
		}
	}

	public void savePreferences(ActionRequest actionRequest, ActionResponse actionResponse) {
		PortletPreferences preferences = actionRequest.getPreferences();
		String processId = ParamUtil.getString(actionRequest, "processId", "");
		String layout = ParamUtil.getString(actionRequest, "layout", "");
		String userType = ParamUtil.getString(actionRequest, "userType", "");
		String modelName = ParamUtil.getString(actionRequest, "modelName", "");
		String processStateUrl = ParamUtil.getString(actionRequest, "processStateUrl", "");

		_log.debug("processId = " + processId);
		_log.debug("layout = " + layout);
		_log.debug("userType = " + userType);
		_log.debug("processStateUrl = " + processStateUrl);

		long[] roleIdList = ParamUtil.getLongValues(actionRequest, "roles");
		String[] strRoleList = new String[roleIdList.length];
		for (int i = 0; i < roleIdList.length; i++) {
			try {
				preferences.setValue("RoleID_" + i, "" + roleIdList[i]);
			} catch (ReadOnlyException e) {
				_log.error(e);
			}
		}
		loadOption(actionRequest, processId);
		try {
			preferences.setValue("processId", processId);
			preferences.setValue("layout", layout);
			preferences.setValue("RoleSize", "" + strRoleList.length);
			preferences.setValue("userType", userType);
			preferences.setValue("modelName", modelName);
			preferences.setValue("processStateUrl", processStateUrl);
			preferences.store();
			actionResponse.setPortletMode(PortletMode.VIEW);
		} catch (ReadOnlyException | ValidatorException | IOException | PortletModeException e) {
			_log.error(e);
		}

	}

	public void loadOption(ActionRequest request, String processId) {

		PortletPreferences preferences = request.getPreferences();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(PEProcessState.class,
				PortletClassLoaderUtil.getClassLoader(PEConstantsGlobal.PORTLET_ID));

		JSONObject objMain = new JSONObject();

		try {
					
			dynamicQuery.add(PropertyFactoryUtil.forName("spPEProcessId").eq(Long.valueOf(processId)));
			dynamicQuery.addOrder(OrderFactoryUtil.desc("spPEProcessStateId"));

			@SuppressWarnings("unchecked")
			List<PEProcessState> processState = PEProcessStateLocalServiceUtil.dynamicQuery(dynamicQuery);

			ArrayList<String> arrJson = new ArrayList<>();
			if (processState.size() > 0) {
				objMain = new JSONObject(processState.get(0).getData());
				
				Iterator<?> i = objMain.keys();
				do {
					String k = i.next().toString();
					arrJson.add(k);

				} while (i.hasNext());
			}

			preferences.setValue("dataOption", arrJson.toString());
			preferences.store();
		} catch (Exception e) {
			_log.error(e);
		}
	}
}
