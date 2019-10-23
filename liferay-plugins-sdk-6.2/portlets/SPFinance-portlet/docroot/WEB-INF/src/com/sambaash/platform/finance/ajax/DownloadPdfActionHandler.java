package com.sambaash.platform.finance.ajax;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.sambaash.platform.action.ServeResourceActionHandler;
import com.sambaash.platform.finance.service.SPFinanceLocalServiceUtil;

public class DownloadPdfActionHandler implements ServeResourceActionHandler {
	private Log log = LogFactoryUtil.getLog(DownloadPdfActionHandler.class.getName());

	@Override
	public void handle(ResourceRequest request, ResourceResponse response) {
		SPFinanceLocalServiceUtil.downloadPdfFromServer(request, response);
	}
}

