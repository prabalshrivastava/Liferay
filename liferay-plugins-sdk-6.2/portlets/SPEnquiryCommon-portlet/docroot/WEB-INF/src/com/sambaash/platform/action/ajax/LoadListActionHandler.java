package com.sambaash.platform.action.ajax;

import java.io.IOException;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.sambaash.platform.action.ServeResourceActionHandler;
import com.sambaash.platform.systemmodelsetup.service.SystemLocalServiceUtil;

public class LoadListActionHandler implements ServeResourceActionHandler {

	private Log _log = LogFactoryUtil.getLog(LoadListActionHandler.class.getName());

	@Override
	public void handle(ResourceRequest request, ResourceResponse response) {

		String modelData = SystemLocalServiceUtil.getListing(request, response);
		try {
			response.getWriter().write(modelData);

		} catch (IOException e) {
			_log.error(e);
		}

	}

}
