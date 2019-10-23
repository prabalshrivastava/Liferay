package com.sambaash.platform.proctorrostor.ajax;

import java.io.IOException;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.sambaash.platform.action.ServeResourceActionHandler;
import com.sambaash.platform.proctorrostor.service.SPProctorRostorReportLocalServiceUtil;
import com.sambaash.platform.systemmodelsetup.service.SystemLocalServiceUtil;


public class FilterColumnListActionHandler implements ServeResourceActionHandler {

	private Log log = LogFactoryUtil.getLog(FilterColumnListActionHandler.class.getName());

	@Override
	public void handle(ResourceRequest request, ResourceResponse response) {
		try {
		//	String modelData = SPProctorRostorReportLocalServiceUtil.getFilterColumnHeader(request, response);
			String modelData = SystemLocalServiceUtil.getFilterColumnHeader(request, response);
			response.getWriter().write(modelData);	
		} catch (IOException e) {
			log.error(e);
		}
	}
}
