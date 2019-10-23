package com.sambaash.platform.ato.ajax;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.sambaash.platform.action.ServeResourceActionHandler;


public class ExportPdfActionHandler implements ServeResourceActionHandler {
	private Log log = LogFactoryUtil.getLog(ExportPdfActionHandler.class.getName());

	@Override
	public void handle(ResourceRequest request, ResourceResponse response) {
//		log.debug("BEFORE: exportPdf invoked");
//		SPAttendenceLocalServiceUtil.exportPdf(request, response);
	}
}
