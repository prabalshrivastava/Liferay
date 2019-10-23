package com.sambaash.platform.action.ajax;

import java.io.IOException;
import com.sambaash.platform.systemmodelsetup.service.SystemLocalServiceUtil;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.sambaash.platform.action.ServeResourceActionHandler;

public class ArchiveActionHandler implements ServeResourceActionHandler {

	private Log log = LogFactoryUtil.getLog(ArchiveActionHandler.class.getName());
	@Override
	public void handle(ResourceRequest request, ResourceResponse response) {
		
		String modelData = SystemLocalServiceUtil.archiveRecord(request, response);
		try {
			response.getWriter().write(modelData);
			
		} catch (IOException e) {
			log.error(e);
		}
		
	}

}
