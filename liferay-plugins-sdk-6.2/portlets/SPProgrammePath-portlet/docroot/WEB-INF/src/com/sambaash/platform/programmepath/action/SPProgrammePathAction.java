package com.sambaash.platform.programmepath.action;

import java.io.IOException;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.sambaash.platform.action.DefaultServeResourceManager;
import com.sambaash.platform.action.ServeResourceActionManager;
import com.sambaash.platform.programmepath.action.ajax.LoadDataActionHandler;

/**
 * Portlet implementation class SPProgrammePathAction
 */
public class SPProgrammePathAction extends MVCPortlet {
	private static final ServeResourceActionManager SERVE_RESOURCE_MANAGER;

	static {
		SERVE_RESOURCE_MANAGER = new DefaultServeResourceManager();
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("loadData", LoadDataActionHandler.class);
	}
	
	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		super.doView(renderRequest, renderResponse);
	}

	@Override
	public void serveResource(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws IOException,
			PortletException {
		String action = ParamUtil.getString(resourceRequest, "action");
		SERVE_RESOURCE_MANAGER.newHandler(action).handle(resourceRequest, resourceResponse);
	}
	
}
