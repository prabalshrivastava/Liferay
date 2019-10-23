package com.sambaash.platform.portlet.rule.builder.action;

import java.io.IOException;

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

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.sambaash.platform.action.DefaultServeResourceManager;
import com.sambaash.platform.action.ServeResourceActionManager;
import com.sambaash.platform.constant.SystemSetupConstants;
import com.sambaash.platform.portlet.rule.builder.action.ajax.DeleteRuleSetHandler;
import com.sambaash.platform.portlet.rule.builder.action.ajax.FetchListOptionByNameHandler;
import com.sambaash.platform.portlet.rule.builder.action.ajax.FetchRuleSetHandler;
import com.sambaash.platform.portlet.rule.builder.action.ajax.FetchRuleSetTypeHandler;
import com.sambaash.platform.portlet.rule.builder.action.ajax.ListActionHandler;
import com.sambaash.platform.portlet.rule.builder.action.ajax.SaveRuleSetHandler;

/**
 * Portlet implementation class RuleBuilderPortlet
 */
public class RuleBuilderPortlet extends MVCPortlet {
	private static final Log LOG = LogFactoryUtil.getLog(RuleBuilderPortlet.class);
	private static final ServeResourceActionManager SERVE_RESOURCE_MANAGER;

	static {
		SERVE_RESOURCE_MANAGER = new DefaultServeResourceManager();	
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("fetchRuleSetTypes", FetchRuleSetTypeHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("fetchListOptionByName", FetchListOptionByNameHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("saveRuleSet", SaveRuleSetHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("elastiSearchList",  ListActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("fetchRuleSet",  FetchRuleSetHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("deleteRuleSet",  DeleteRuleSetHandler.class);
	}

	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException {
		try {
			String action = resourceRequest.getParameter("action");

			LOG.info("AJAX Action - > " + action);
			SERVE_RESOURCE_MANAGER.newHandler(action).handle(resourceRequest, resourceResponse);

		} catch (Exception e) {
			LOG.error("Unable to process resource request.", e);
		}
	}

	public void savePreferences(ActionRequest actionRequest, ActionResponse actionResponse)
			throws ValidatorException, IOException {
		PortletPreferences preferences = actionRequest.getPreferences();

		String style = ParamUtil.getString(actionRequest, SystemSetupConstants.PREF_CONTAINER_STYLE, "");
		String modelName = ParamUtil.getString(actionRequest, SystemSetupConstants.PREF_MODEL_NAME, "0");
		String baseUrl = ParamUtil.getString(actionRequest, SystemSetupConstants.PREF_BASE_URL, "");
		try {

			preferences.setValue(SystemSetupConstants.PREF_CONTAINER_STYLE, style);
			preferences.setValue(SystemSetupConstants.PREF_MODEL_NAME, modelName);
			preferences.setValue(SystemSetupConstants.PREF_BASE_URL, baseUrl);
			preferences.store();
		} catch (ReadOnlyException e) {
			LOG.error(e);
		}
		try {
			actionResponse.setPortletMode(PortletMode.VIEW);
		} catch (PortletModeException e) {
			LOG.error(e);
		}
	}
	
}
