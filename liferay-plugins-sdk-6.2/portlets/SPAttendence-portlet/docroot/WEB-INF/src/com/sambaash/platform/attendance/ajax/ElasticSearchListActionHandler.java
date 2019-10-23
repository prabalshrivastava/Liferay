package com.sambaash.platform.attendance.ajax;

import java.io.IOException;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.sambaash.platform.action.ServeResourceActionHandler;
import com.sambaash.platform.attendance.service.SPAttendenceLocalServiceUtil;


public class ElasticSearchListActionHandler implements ServeResourceActionHandler {
	private Log log = LogFactoryUtil.getLog(ElasticSearchListActionHandler.class.getName());

	@Override
	public void handle(ResourceRequest request, ResourceResponse response) {
		try {
			String modelData = SPAttendenceLocalServiceUtil.getElasticsearchData(request, response);
			//SystemLocalServiceUtil.saveExportQuery("elasticsearch", modelData, request);
			response.getWriter().write(modelData);
		} catch (IOException e) {
			log.error(e);
		}
	}
}
