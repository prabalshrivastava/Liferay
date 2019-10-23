package com.sambaash.platform.pricingengine.linking;

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
import com.sambaash.platform.pricingengine.action.ajax.CreateActionHandler;
import com.sambaash.platform.pricingengine.action.ajax.ElasticSearchListActionHandler;
import com.sambaash.platform.pricingengine.action.ajax.FetchEntityActionHandler;
import com.sambaash.platform.pricingengine.action.ajax.LoadDataActionHandler;
import com.sambaash.platform.pricingengine.action.ajax.LoadListActionHandler;
import com.sambaash.platform.pricingengine.action.ajax.SearchListActionHandler;
import com.sambaash.platform.pricingengine.action.ajax.SendRequestActionHandler;

/**
 * Portlet implementation class PriceSchemeLinkingPortlet
 */
public class PriceSchemeLinkingPortlet extends MVCPortlet {
	private static final ServeResourceActionManager SERVE_RESOURCE_MANAGER;
	static {
		SERVE_RESOURCE_MANAGER = new DefaultServeResourceManager();
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("persist", CreateActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("searchList", SearchListActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("loadList",  LoadListActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("elastiSearchList",  ElasticSearchListActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("loadData",  LoadDataActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("fetchEntity",  FetchEntityActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("sendRequest", SendRequestActionHandler.class);
	}
	/**
     * This is an object of Log class
     */
    private Log log = LogFactoryUtil.getLog(PriceSchemeLinkingPortlet.class.getName());
    
    @Override
    public void serveResource(ResourceRequest resourceRequest,ResourceResponse resourceResponse)throws  IOException, PortletException {
	    try {
		    String action = resourceRequest.getParameter( "action");
			SERVE_RESOURCE_MANAGER.newHandler(action).handle(resourceRequest, resourceResponse);
	    }
	    catch (Exception e) {
	    	log.error(e);
	    }
    }
    public void savePreferences(ActionRequest actionRequest,
			ActionResponse actionResponse)  {
		PortletPreferences preferences = actionRequest.getPreferences();
		String leftModel = ParamUtil.getString(actionRequest, "leftModel", "0");
		String rightModel = ParamUtil.getString(actionRequest, "rightModel", "");
		
		try {
			preferences.setValue("leftModel", leftModel);
			preferences.setValue("rightModel", rightModel);
			
			preferences.store();
			actionResponse.setPortletMode(PortletMode.VIEW);
		} catch (ReadOnlyException | ValidatorException | IOException | PortletModeException e) {
			log.error(e);
		}
		
	}

}
