package com.sambaash.platform.invigilatormanagement.action.ajax;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.sambaash.platform.action.ServeResourceActionHandler;
import com.sambaash.platform.invigilatormanagement.service.InvigilatorLocalServiceUtil;

public class NotifyInvigilatorActionHandler implements ServeResourceActionHandler {
	private Log log = LogFactoryUtil.getLog(NotifyInvigilatorActionHandler.class.getName());
	public void handle(ResourceRequest request, ResourceResponse response) {
		try {
			String output = InvigilatorLocalServiceUtil.notifyInvigilator(request, response);
			response.getWriter().write(output);
		} catch(Exception e) {
			log.error(e);
		}
	}
}