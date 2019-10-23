package com.sambaash.platform.rpec.ajax;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.sambaash.platform.action.ServeResourceActionHandler;
import com.sambaash.platform.rpec.service.SPRPECLocalServiceUtil;
import com.sambaash.platform.systemmodelsetup.service.SystemLocalServiceUtil;

public class ExportRowActionHandler implements ServeResourceActionHandler {
	private Log log = LogFactoryUtil.getLog(ExportRowActionHandler.class.getName());

	@Override
	public void handle(ResourceRequest request, ResourceResponse response) {
		log.debug("BEFORE: exportRowToExcelFile invoked");
		System.out.print("storageId :: " + request.getParameter("formStorageId"));
		SPRPECLocalServiceUtil.exportRowToExcelFile(request, response);
	}
}