package com.sambaash.platform.finance.ajax;

import java.io.IOException;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.sambaash.platform.action.ServeResourceActionHandler;
import com.sambaash.platform.finance.service.SPFinanceLocalServiceUtil;
import com.sambaash.platform.systemmodelsetup.service.SystemLocalServiceUtil;

public class LoadListActionHandler implements ServeResourceActionHandler {

	/**
	 * This is an object of Log class
	 */
	private Log log = LogFactoryUtil.getLog(LoadListActionHandler.class.getName());

	@Override
	public void handle(ResourceRequest request, ResourceResponse response) {
		try {
			String modelData = SPFinanceLocalServiceUtil.getListing(request, response);
			SPFinanceLocalServiceUtil.saveExportQuery("list", modelData, request);
			response.getWriter().write(modelData);
		} catch (IOException | JSONException e) {
			log.error(e);
		}
	}
}
