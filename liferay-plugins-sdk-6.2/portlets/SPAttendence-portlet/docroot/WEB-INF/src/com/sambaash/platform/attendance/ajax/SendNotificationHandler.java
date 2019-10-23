package com.sambaash.platform.attendance.ajax;

import java.io.IOException;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.sambaash.platform.action.ServeResourceActionHandler;
import com.sambaash.platform.attendance.service.SPAttendenceLocalServiceUtil;

public class SendNotificationHandler  implements ServeResourceActionHandler{
	
	private Log log = LogFactoryUtil.getLog(SendNotificationHandler.class.getName());

	@Override
	public void handle(ResourceRequest request, ResourceResponse response) {
		// TODO Auto-generated method stub
		log.info("SendNotificationHandler called.");
		String output = "";
		output = SPAttendenceLocalServiceUtil.sendNotification(request, response); 
		try {
			response.getWriter().write(output);
		} catch (IOException e) {
			log.error(e);
		}
		
	}
}