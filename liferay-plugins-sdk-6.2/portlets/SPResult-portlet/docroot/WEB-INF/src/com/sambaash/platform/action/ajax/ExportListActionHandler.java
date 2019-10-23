package com.sambaash.platform.action.ajax;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.sambaash.platform.action.ServeResourceActionHandler;
import com.sambaash.platform.srv.result.service.SPResultLocalServiceUtil;
import com.sambaash.platform.util.SambaashUtil;

public class ExportListActionHandler implements ServeResourceActionHandler {
	private Log log = LogFactoryUtil.getLog(ExportListActionHandler.class.getName());

	@Override
	public void handle(ResourceRequest request, ResourceResponse response) {
		log.debug("BEFORE: exportRowToExcelFile invoked");
		SPResultLocalServiceUtil.exportListToExcelFile(request, response);
	}
}
