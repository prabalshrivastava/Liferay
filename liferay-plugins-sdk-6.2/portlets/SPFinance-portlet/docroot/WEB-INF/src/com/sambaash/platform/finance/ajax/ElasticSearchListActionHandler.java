package com.sambaash.platform.finance.ajax;

import java.io.IOException;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.sambaash.platform.action.ServeResourceActionHandler;
import com.sambaash.platform.finance.service.SPFinanceLocalServiceUtil;

public class ElasticSearchListActionHandler implements ServeResourceActionHandler {
	private Log log = LogFactoryUtil.getLog(ElasticSearchListActionHandler.class.getName());

	@Override
	public void handle(ResourceRequest request, ResourceResponse response) {
		try {
			String modelData = SPFinanceLocalServiceUtil.getElasticSearchListing(request, response);
			SPFinanceLocalServiceUtil.saveExportQuery("elasticsearch",modelData,request);
			response.getWriter().write(modelData);
		} catch (IOException | JSONException e) {
			log.error(e);
		}
	}
}
