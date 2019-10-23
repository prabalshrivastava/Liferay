package com.sambaash.platform.portlet.pe.action.ajax;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.sambaash.platform.action.ServeResourceActionHandler;
import com.sambaash.platform.srv.processbuilder.service.PEProcessLocalServiceUtil;

public class PEProcessEntityListHandler implements ServeResourceActionHandler {
	private static final Log LOG = LogFactoryUtil.getLog(PEProcessEntityListHandler.class);

	@Override
	public void handle(ResourceRequest request, ResourceResponse response) {
		try {
			long entityClassId = ParamUtil.getLong(request, "entityClassId");
			JSONObject data = PEProcessLocalServiceUtil.getEntitiesListing(request,response,"",entityClassId,true);
			response.getWriter().write(data.toString());
		} catch (Exception e) {
			LOG.error(e);
		}
	}

}
