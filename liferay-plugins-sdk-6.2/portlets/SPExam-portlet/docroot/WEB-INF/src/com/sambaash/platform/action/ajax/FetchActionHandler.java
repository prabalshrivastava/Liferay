package com.sambaash.platform.action.ajax;

import java.io.IOException;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.sambaash.platform.action.ServeResourceActionHandler;
import com.sambaash.platform.srv.exam.service.SPExamLocalServiceUtil;

public class FetchActionHandler implements ServeResourceActionHandler{
	private Log log = LogFactoryUtil.getLog(FetchActionHandler.class.getName());
	@Override
	public void handle(ResourceRequest request, ResourceResponse response) {
		String modelData = SPExamLocalServiceUtil.fetchRecord(request, response);
		try {
			response.getWriter().write(modelData);
		} catch (IOException e) {
			log.error(e);
		}
		
	}

}
