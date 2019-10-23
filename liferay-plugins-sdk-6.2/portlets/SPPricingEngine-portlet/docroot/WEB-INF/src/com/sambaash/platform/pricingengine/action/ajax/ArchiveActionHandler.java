package com.sambaash.platform.pricingengine.action.ajax;

import java.io.IOException;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.sambaash.platform.action.ServeResourceActionHandler;
import com.sambaash.platform.pricingengine.service.SPPricingEngineLocalServiceUtil;
import com.sambaash.platform.systemmodelsetup.service.SystemLocalServiceUtil;

public class ArchiveActionHandler implements ServeResourceActionHandler {

	private Log log = LogFactoryUtil.getLog(this.getClass().getName());

	@Override
	public void handle(ResourceRequest request, ResourceResponse response) {
		log.info("ArchiveActionHandler list called.");
		String modelData = SystemLocalServiceUtil.archiveRecord(request, response);
		try {
			response.getWriter().write(modelData);
		} catch (IOException e) {
			log.error(e);
		}
	}
}
