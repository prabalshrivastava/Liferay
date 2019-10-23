package com.sambaash.platform.finance.ajax;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.sambaash.platform.action.ServeResourceActionHandler;
import com.sambaash.platform.finance.service.SPFinanceLocalServiceUtil;

public class ExportPdfActionHandler implements ServeResourceActionHandler {
	private Log log = LogFactoryUtil.getLog(ExportPdfActionHandler.class.getName());

	@Override
	public void handle(ResourceRequest request, ResourceResponse response) {
		log.debug("BEFORE: exportPdf invoked");
		String model = request.getParameter("formType");
		try {
			if (model != null && (model.equalsIgnoreCase("TransactionMaster") || model.equalsIgnoreCase("Invoicing")
					|| model.equalsIgnoreCase("creditbalance"))) {
				String filePath = SPFinanceLocalServiceUtil.preparePdf(request, response);
				response.getWriter().write(filePath);
			} else if(model != null && model.equalsIgnoreCase("dccreport")) {
				String filePath = SPFinanceLocalServiceUtil.prepareDccPdf(request, response);
				response.getWriter().write(filePath);
			} else {
				String filePath = SPFinanceLocalServiceUtil.prepareLorPdf(request, response);
				response.getWriter().write(filePath);
			}
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}
}
