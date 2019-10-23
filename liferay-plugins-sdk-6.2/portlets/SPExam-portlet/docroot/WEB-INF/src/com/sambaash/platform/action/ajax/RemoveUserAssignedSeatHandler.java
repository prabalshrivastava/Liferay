package com.sambaash.platform.action.ajax;

import java.io.IOException;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.sambaash.platform.action.ServeResourceActionHandler;
import com.sambaash.platform.srv.exam.service.SPExamLocalServiceUtil;

public class RemoveUserAssignedSeatHandler implements ServeResourceActionHandler{

	private Log log = LogFactoryUtil.getLog(RemoveUserAssignedSeatHandler.class.getName());
	@Override
	public void handle(ResourceRequest request, ResourceResponse response) {
		
		String modelData = SPExamLocalServiceUtil.removeUserAssignedSeats(request, response);
		try {
			response.getWriter().write(modelData);
		} catch (IOException e) {
			log.error(e);
		}
		
	}
}
