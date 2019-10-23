package com.sambaash.platform.pricingengine.action.ajax;
import java.io.IOException;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.sambaash.platform.action.ServeResourceActionHandler;
import com.sambaash.platform.systemmodelsetup.service.SystemLocalServiceUtil;


public class SendRequestActionHandler implements ServeResourceActionHandler {
	private Log _log = LogFactoryUtil.getLog(SendRequestActionHandler.class.getName());
	@Override
	public void handle(ResourceRequest request, ResourceResponse response) {
		String output = StringPool.BLANK;
		output = SystemLocalServiceUtil.sendRequest(request, response);
		try {
			response.getWriter().write(output);
		} catch (IOException e) {
			_log.error(e);
		}
	}

}
