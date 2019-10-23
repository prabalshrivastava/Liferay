package com.sambaash.platform.templatemanagement.action.ajax;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.sambaash.platform.action.ServeResourceActionHandler;
import com.sambaash.platform.srv.template.service.SPTemplateLocalServiceUtil;

public class EditTemplateActionHandler implements ServeResourceActionHandler {

	@Override
	public void handle(ResourceRequest request, ResourceResponse response) {
		SPTemplateLocalServiceUtil.updateTemplate(request, response);
	}

}
