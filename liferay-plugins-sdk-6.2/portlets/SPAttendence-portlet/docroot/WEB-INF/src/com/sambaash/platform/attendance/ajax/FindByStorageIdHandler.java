package com.sambaash.platform.attendance.ajax;

import java.io.IOException;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.sambaash.platform.action.ServeResourceActionHandler;
import com.sambaash.platform.attendance.service.SPAttendenceLocalServiceUtil;

public class FindByStorageIdHandler implements ServeResourceActionHandler{

	private Log log = LogFactoryUtil.getLog(FindByStorageIdHandler.class.getName());

	@Override
	public void handle(ResourceRequest request, ResourceResponse response) {
		// TODO Auto-generated method stub
		log.info("FindByStorageIdHandler called.");
		String output = "";
		if (request.getParameter("formStorageId").isEmpty() || request.getParameter("formStorageId").equals("0")) {
			output = SPAttendenceLocalServiceUtil.findByStorageId(request, response);
		} 
		try {
			response.getWriter().write(output);
		} catch (IOException e) {
			log.error(e);
		}
		
	}

}
