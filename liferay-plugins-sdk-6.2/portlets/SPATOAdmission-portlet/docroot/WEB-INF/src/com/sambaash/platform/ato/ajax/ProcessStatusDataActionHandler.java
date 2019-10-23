package com.sambaash.platform.ato.ajax;

import java.io.IOException;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.sambaash.platform.action.ServeResourceActionHandler;
import com.sambaash.platform.ato.service.SPATOAdmissionLocalServiceUtil;



public class ProcessStatusDataActionHandler implements ServeResourceActionHandler {
	private Log log = LogFactoryUtil.getLog(ProcessStatusDataActionHandler.class.getName());

	@Override
	public void handle(ResourceRequest request, ResourceResponse response) {
		String modelData = SPATOAdmissionLocalServiceUtil.changeProcessStatus(request,response);
		try {
			response.getWriter().write(modelData);
		} catch (IOException e) {
			log.error(e);
		}
	}
}
