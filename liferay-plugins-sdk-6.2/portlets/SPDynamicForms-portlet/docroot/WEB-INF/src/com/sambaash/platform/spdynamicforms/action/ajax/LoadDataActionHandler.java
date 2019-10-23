package com.sambaash.platform.spdynamicforms.action.ajax;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.sambaash.platform.action.ServeResourceActionHandler;
import com.sambaash.platform.srv.spdynamicforms.service.SPDynamicFormsLocalServiceUtil;

public class LoadDataActionHandler implements ServeResourceActionHandler {

	@Override
	public void handle(ResourceRequest request, ResourceResponse response) {
		SPDynamicFormsLocalServiceUtil.handleLoadData(request, response);
	}

}
