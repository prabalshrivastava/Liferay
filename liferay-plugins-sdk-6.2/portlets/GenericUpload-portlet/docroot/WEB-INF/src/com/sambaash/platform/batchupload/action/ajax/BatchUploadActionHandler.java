package com.sambaash.platform.batchupload.action.ajax;


import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.sambaash.platform.action.ServeResourceActionHandler;
import com.sambaash.platform.srv.genericupload.service.BatchUploadLocalServiceUtil;

public class BatchUploadActionHandler implements ServeResourceActionHandler {

	@Override
	public void handle(ResourceRequest request, ResourceResponse response) {
		BatchUploadLocalServiceUtil.handleBatchUpload(request, response);
	}
	

}
