package com.sambaash.platform.rpec.ajax;

import java.io.IOException;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.sambaash.platform.action.ServeResourceActionHandler;
import com.sambaash.platform.rpec.service.SPRPECLocalServiceUtil;

public class CheckCompetencyProficiencyActionHandler implements ServeResourceActionHandler {
	private Log log = LogFactoryUtil.getLog(CheckCompetencyProficiencyActionHandler.class.getName());

	@Override
	public void handle(ResourceRequest request, ResourceResponse response) {
		try {
			String modelData = SPRPECLocalServiceUtil.checkCompetencyProficiency(request, response);
			response.getWriter().write(modelData);
		} catch (IOException e) {
			log.error(e);
		}
	}
}
