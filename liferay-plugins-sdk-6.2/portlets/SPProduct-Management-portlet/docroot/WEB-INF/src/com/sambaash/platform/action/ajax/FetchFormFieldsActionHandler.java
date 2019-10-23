package com.sambaash.platform.action.ajax;

import java.io.IOException;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.sambaash.platform.action.ServeResourceActionHandler;
import com.sambaash.platform.systemmodelsetup.service.SystemLocalServiceUtil;


public class FetchFormFieldsActionHandler implements ServeResourceActionHandler {
	private Log log = LogFactoryUtil.getLog(FetchFormFieldsActionHandler.class.getName());
	@Override
	public void handle(ResourceRequest request, ResourceResponse response) {
		
		String modelData = SystemLocalServiceUtil.getFormV2Fields(request);
		try {
			response.getWriter().write(modelData);
			
		} catch (IOException e) {
			log.error(e);
		}
		
	}

}
