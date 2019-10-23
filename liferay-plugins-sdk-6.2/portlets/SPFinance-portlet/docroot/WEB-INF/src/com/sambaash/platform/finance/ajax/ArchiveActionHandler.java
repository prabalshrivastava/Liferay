package com.sambaash.platform.finance.ajax;

import java.io.IOException;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.SystemEventModel;
import com.sambaash.platform.action.ServeResourceActionHandler;
import com.sambaash.platform.finance.service.SPFinanceLocalServiceUtil;
import com.sambaash.platform.systemmodelsetup.service.SystemLocalService;
import com.sambaash.platform.systemmodelsetup.service.SystemLocalServiceUtil;

public class ArchiveActionHandler implements ServeResourceActionHandler {
	private Log log = LogFactoryUtil.getLog(LoadListActionHandler.class.getName());

	@Override
	public void handle(ResourceRequest request, ResourceResponse response) {
		String modelData = SystemLocalServiceUtil.archiveRecord(request, response);
		try {
			response.getWriter().write(modelData);
		} catch (IOException e) {
			log.error(e);
		}
	}
}
