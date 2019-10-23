package com.sambaash.platform.rpec.ajax;

import java.io.IOException;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.sambaash.platform.action.ServeResourceActionHandler;
import com.sambaash.platform.rpec.service.SPRPECLocalServiceUtil;

public class CompetenceSubjectsQuestionsActionHandler implements ServeResourceActionHandler {
	private Log log = LogFactoryUtil.getLog(CompetenceSubjectsQuestionsActionHandler.class.getName());

	@Override
	public void handle(ResourceRequest request, ResourceResponse response) {
		String modelData = SPRPECLocalServiceUtil.getCompetenceSubjectsQuestions(request, response);
		try {
			response.getWriter().write(modelData);
		} catch (IOException e) {
			log.error(e);
		}
	}
}
