package com.sambaash.platform.action.ajax;

import java.io.IOException;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.sambaash.platform.action.ServeResourceActionHandler;
import com.sambaash.platform.srv.exam.service.SPExamLocalServiceUtil;

public class LoadListActionHandler implements ServeResourceActionHandler {

	/**
	 * This is an object of Log class
	 */
	private Log log = LogFactoryUtil.getLog(LoadListActionHandler.class.getName());

	@Override
	public void handle(ResourceRequest request, ResourceResponse response) {
		try {
			String modelData = SPExamLocalServiceUtil.getListing(request, response);
			response.getWriter().write(modelData);
		} catch (IOException  e) {
			log.error(e);
		}
	}
}
