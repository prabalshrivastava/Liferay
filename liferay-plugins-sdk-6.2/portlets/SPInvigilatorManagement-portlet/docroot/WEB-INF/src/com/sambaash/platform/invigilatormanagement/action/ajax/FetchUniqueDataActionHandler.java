package com.sambaash.platform.invigilatormanagement.action.ajax;

import java.io.IOException;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.sambaash.platform.action.ServeResourceActionHandler;
import com.sambaash.platform.invigilatormanagement.service.InvigilatorLocalServiceUtil;
import com.sambaash.platform.invigilatormanagement.service.InvigilatorServiceUtil;

public class FetchUniqueDataActionHandler implements ServeResourceActionHandler {
	private Log log = LogFactoryUtil.getLog(FetchUniqueDataActionHandler.class.getName());

	@Override
	public void handle(ResourceRequest request, ResourceResponse response) {

		
		String modelData = InvigilatorLocalServiceUtil.getUniqueData(request, response);
		try {
			response.getWriter().write(modelData);
		} catch (IOException e) {
			log.error(e);
		}

	}

}
