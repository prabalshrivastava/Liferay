package com.sambaash.platform.pricingengine.action.ajax;


import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.sambaash.platform.action.ServeResourceActionHandler;
import com.sambaash.platform.systemmodelsetup.service.SystemLocalServiceUtil;


public class ExportListActionHandler implements ServeResourceActionHandler {
	private Log log = LogFactoryUtil.getLog(ExportListActionHandler.class.getName());
	@Override
	public void handle(ResourceRequest request, ResourceResponse response) {
		log.debug("BEFORE: exportRowToExcelFile invoked");
		SystemLocalServiceUtil.exportListToExcelFile(request,response);
	}
}
