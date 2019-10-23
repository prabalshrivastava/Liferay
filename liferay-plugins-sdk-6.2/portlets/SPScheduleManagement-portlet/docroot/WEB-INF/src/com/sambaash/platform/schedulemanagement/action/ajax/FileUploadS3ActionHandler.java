package com.sambaash.platform.schedulemanagement.action.ajax;


import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.sambaash.platform.action.ServeResourceActionHandler;
import com.sambaash.platform.systemmodelsetup.service.SystemLocalServiceUtil;

public class FileUploadS3ActionHandler implements ServeResourceActionHandler {

	@Override
	public void handle(ResourceRequest request, ResourceResponse response) {
		SystemLocalServiceUtil.handleFileUpload(request, response);
		
	}
	

}
