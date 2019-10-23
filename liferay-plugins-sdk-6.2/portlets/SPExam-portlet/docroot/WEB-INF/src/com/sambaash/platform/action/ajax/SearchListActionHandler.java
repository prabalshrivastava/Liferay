package com.sambaash.platform.action.ajax;

import java.io.IOException;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.sambaash.platform.action.ServeResourceActionHandler;
import com.sambaash.platform.srv.exam.service.SPExamLocalServiceUtil;

public class SearchListActionHandler implements ServeResourceActionHandler {

	private Log log = LogFactoryUtil.getLog(this.getClass().getName());

	@Override
	public void handle(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		try {
			String modelData = SPExamLocalServiceUtil.getSearchListing(resourceRequest, resourceResponse);
			resourceResponse.getWriter().write(modelData);
		} catch (IOException e) {
			log.error(e);
		}
	}
}
