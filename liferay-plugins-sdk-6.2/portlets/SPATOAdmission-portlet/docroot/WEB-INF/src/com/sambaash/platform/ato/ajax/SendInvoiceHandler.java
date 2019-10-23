package com.sambaash.platform.ato.ajax;
import java.io.IOException;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.sambaash.platform.action.ServeResourceActionHandler;
import com.sambaash.platform.ato.service.SPATOAdmissionLocalServiceUtil;

public class SendInvoiceHandler implements ServeResourceActionHandler {
	@Override
	public void handle(ResourceRequest request, ResourceResponse response) {
		String modelData = SPATOAdmissionLocalServiceUtil.sendInvoice(request,response);
		try {
			response.getWriter().write(modelData);
		} catch (IOException e) {
//			log.error(e);
		}
	}
}

