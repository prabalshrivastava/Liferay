package com.sambaash.platform.finance.ajax;

import java.io.IOException;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.sambaash.platform.action.ServeResourceActionHandler;
import com.sambaash.platform.finance.service.SPFinanceLocalServiceUtil;

public class ExportPaymentAdviceExcelActionHandler implements ServeResourceActionHandler {
	private Log log = LogFactoryUtil.getLog(ExportPaymentAdviceExcelActionHandler.class.getName());

	@Override
	public void handle(ResourceRequest request, ResourceResponse response) {
		SPFinanceLocalServiceUtil.exportPaymentAdviceExcel(request, response);
		/*try {
			response.getWriter().write(modelData);
		} catch (IOException e) {
			log.error(e);
		}*/
	}
}
