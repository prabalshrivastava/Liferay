package com.sambaash.platform.action.ajax;

import java.io.IOException;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.sambaash.platform.action.ServeResourceActionHandler;
import com.sambaash.platform.srv.exam.service.SPExamLocalServiceUtil;

public class FetchDataActionHandler implements ServeResourceActionHandler{

	private Log log = LogFactoryUtil.getLog(FetchDataActionHandler.class.getName());
	@Override
	public void handle(ResourceRequest request, ResourceResponse response) {
		log.error("Inside Handler fetchActionData()");
		log.error(request);
		log.error("model data");
		try {
			String modelData = SPExamLocalServiceUtil.fetchActionData(request, response);
			log.error(modelData);
			response.getWriter().write(modelData);
		} catch (IOException e) {
			log.error(e);
		}
		
	}
}
