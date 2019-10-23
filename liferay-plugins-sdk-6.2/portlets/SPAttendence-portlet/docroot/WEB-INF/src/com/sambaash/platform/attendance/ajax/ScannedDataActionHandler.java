package com.sambaash.platform.attendance.ajax;

import java.io.IOException;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.sambaash.platform.action.ServeResourceActionHandler;
import com.sambaash.platform.attendance.service.SPAttendenceLocalServiceUtil;

public class ScannedDataActionHandler implements ServeResourceActionHandler {
	private Log log = LogFactoryUtil.getLog(ScannedDataActionHandler.class.getName());

	@Override
	public void handle(ResourceRequest request, ResourceResponse response) {
		String modelData = SPAttendenceLocalServiceUtil.scannedDataRecord(request, response);
		try {
			response.getWriter().write(modelData);
		} catch (IOException e) {
			log.error(e);
		}
	}
}
