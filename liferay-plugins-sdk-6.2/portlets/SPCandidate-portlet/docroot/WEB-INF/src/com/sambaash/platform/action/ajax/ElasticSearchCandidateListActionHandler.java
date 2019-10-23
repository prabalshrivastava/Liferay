package com.sambaash.platform.action.ajax;

import java.io.IOException;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.sambaash.platform.action.ServeResourceActionHandler;
import com.sambaash.platform.systemmodelsetup.service.SystemLocalServiceUtil;

public class ElasticSearchCandidateListActionHandler implements ServeResourceActionHandler {
	private Log log = LogFactoryUtil.getLog(ElasticSearchCandidateListActionHandler.class.getName());

	@Override
	public void handle(ResourceRequest request, ResourceResponse response) {
		try {
		String modelData = SystemLocalServiceUtil.sendRequest(request, response);
		SystemLocalServiceUtil.saveExportQuery("elasticsearch",modelData,request);
			response.getWriter().write(modelData);

		} catch (IOException | JSONException e) {
			log.error(e);
		}

	}

}
