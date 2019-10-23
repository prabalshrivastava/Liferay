package com.sambaash.platform.action.ajax;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.sambaash.platform.action.ServeResourceActionHandler;
import com.sambaash.platform.systemmodelsetup.service.SystemLocalServiceUtil;

public class ExportRowActionHandler implements ServeResourceActionHandler {
	private Log log = LogFactoryUtil.getLog(ExportRowActionHandler.class.getName());

	@Override
	public void handle(ResourceRequest request, ResourceResponse response) {
		log.debug("BEFORE: exportRowToExcelFile invoked");
		SystemLocalServiceUtil.exportRowToExcelFile(request,response);
	}
}
