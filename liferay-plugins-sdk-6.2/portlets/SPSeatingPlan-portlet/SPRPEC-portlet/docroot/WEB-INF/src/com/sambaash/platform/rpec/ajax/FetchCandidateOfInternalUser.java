package com.sambaash.platform.rpec.ajax;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.sambaash.platform.action.ServeResourceActionHandler;
import com.sambaash.platform.rpec.service.SPRPECLocalServiceUtil;

public class FetchCandidateOfInternalUser implements ServeResourceActionHandler{
	private Log log = LogFactoryUtil.getLog(FetchCandidateOfInternalUser.class.getName());
	@Override
	public void handle(ResourceRequest request, ResourceResponse response) {
		try {
			String modelData = SPRPECLocalServiceUtil.getCandidateListOfInternalUser(request, response);
			response.getWriter().write(modelData);
		} catch (Exception e) {
			log.error(e);
		}
	}
} 