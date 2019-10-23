package com.sambaash.platform.action.ajax;

import java.io.IOException;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.sambaash.platform.action.ServeResourceActionHandler;
import com.sambaash.platform.systemmodelsetup.service.SystemLocalServiceUtil;

public class CreateActionHandler implements ServeResourceActionHandler {

	private Log _log = LogFactoryUtil.getLog(CreateActionHandler.class.getName());

	@Override
	public void handle(ResourceRequest request, ResourceResponse response) {
		String output = StringPool.BLANK;
		if (request.getParameter("formStorageId").isEmpty() || request.getParameter("formStorageId").equals("0")) {
			output = SystemLocalServiceUtil.createRecord(request, response);
		} else {
			output = SystemLocalServiceUtil.updateRecord(request, response);
		}
		try {
			response.getWriter().write(output);
		} catch (IOException e) {
			_log.error(e);
		}

	}

}
