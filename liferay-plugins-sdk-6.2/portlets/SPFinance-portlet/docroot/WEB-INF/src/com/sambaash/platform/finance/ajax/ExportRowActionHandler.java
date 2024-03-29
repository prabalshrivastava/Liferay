package com.sambaash.platform.finance.ajax;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.sambaash.platform.action.ServeResourceActionHandler;
import com.sambaash.platform.finance.service.SPFinanceLocalServiceUtil;

public class ExportRowActionHandler implements ServeResourceActionHandler {
	private Log log = LogFactoryUtil.getLog(ExportRowActionHandler.class.getName());

	@Override
	public void handle(ResourceRequest request, ResourceResponse response) {
		log.debug("BEFORE: exportRowToExcelFile invoked");
		SPFinanceLocalServiceUtil.exportRowToExcelFile(request, response);
	}
}
