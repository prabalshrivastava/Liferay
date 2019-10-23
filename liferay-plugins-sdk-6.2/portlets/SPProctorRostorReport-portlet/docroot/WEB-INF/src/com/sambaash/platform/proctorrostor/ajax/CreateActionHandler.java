package com.sambaash.platform.proctorrostor.ajax;

import java.io.IOException;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.sambaash.platform.action.ServeResourceActionHandler;
import com.sambaash.platform.systemmodelsetup.service.SystemLocalServiceUtil;

public class CreateActionHandler implements ServeResourceActionHandler {

	private Log log = LogFactoryUtil.getLog(CreateActionHandler.class.getName());

	@Override
	public void handle(ResourceRequest request, ResourceResponse response) {
		log.info("CreateActionHandler list called.");
		String output = "";
		if (request.getParameter("formStorageId").isEmpty() || request.getParameter("formStorageId").equals("0")) {
			output = SystemLocalServiceUtil.createRecord(request, response);
		} else {
			output = SystemLocalServiceUtil.updateRecord(request, response);
		}
		try {
			response.getWriter().write(output);
		} catch (IOException e) {
			log.error(e);
		}
	}
}
