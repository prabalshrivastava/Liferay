package com.sambaash.platform.invigilatormanagement.action.ajax;

import java.io.IOException;
import java.util.List;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.sambaash.platform.action.ServeResourceActionHandler;
import com.sambaash.platform.invigilatormanagement.service.InvigilatorLocalServiceUtil;
import com.sambaash.platform.invigilatormanagement.service.InvigilatorServiceUtil;
import com.sambaash.platform.systemmodelsetup.service.SystemLocalServiceUtil;


public class UniqueListActionHandler implements ServeResourceActionHandler {
	private Log log = LogFactoryUtil.getLog(CreateActionHandler.class.getName());
	@Override
	public void handle(ResourceRequest request, ResourceResponse response) {
		try {
			
			String modelData = InvigilatorLocalServiceUtil.getUniqueList(request);	
			response.getWriter().write(modelData.toString());
			
		} catch (IOException e) {
			log.error(e);
		}
		
		
	}

}
