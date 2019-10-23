package com.sambaash.platform.spmicroservice.action.ajax;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.sambaash.platform.action.ServeResourceActionHandler;
import com.sambaash.platform.srv.spdynamicforms.service.SPDynamicFormsLocalServiceUtil;

public class FileUploadActionHandler implements ServeResourceActionHandler {

	@Override
	public void handle(ResourceRequest request, ResourceResponse response) {
		SPDynamicFormsLocalServiceUtil.handleFileUpload(request, response);
	}

}
