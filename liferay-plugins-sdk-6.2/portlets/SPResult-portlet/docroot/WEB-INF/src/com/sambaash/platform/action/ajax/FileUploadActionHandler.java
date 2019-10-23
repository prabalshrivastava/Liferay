package com.sambaash.platform.action.ajax;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.sambaash.platform.action.ServeResourceActionHandler;
import com.sambaash.platform.srv.result.service.SPResultLocalServiceUtil;

public class FileUploadActionHandler implements ServeResourceActionHandler {

	@Override
	public void handle(ResourceRequest request, ResourceResponse response) {
		SPResultLocalServiceUtil.handleFileUpload(request, response);
	}

}
