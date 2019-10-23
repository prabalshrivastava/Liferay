package com.sambaash.platform.attendance.ajax;

import java.io.IOException;
import com.liferay.portal.kernel.json.JSONException;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.sambaash.platform.action.ServeResourceActionHandler;
import com.sambaash.platform.systemmodelsetup.service.SystemLocalServiceUtil;

public class FetchActionHandler implements ServeResourceActionHandler {
	private Log log = LogFactoryUtil.getLog(CreateActionHandler.class.getName());

	@Override
	public void handle(ResourceRequest request, ResourceResponse response) {
		String modelData = SystemLocalServiceUtil.fetchRecord(request, response);
		try {
			SystemLocalServiceUtil.saveExportQuery("elasticsearch", modelData, request);
			response.getWriter().write(modelData);
		} catch (IOException | JSONException e) {
			log.error(e);
		}
	}
}
