package com.sambaash.platform.portlet.rule.builder.action.ajax;

import java.io.IOException;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.sambaash.platform.action.ServeResourceActionHandler;
import com.sambaash.platform.srv.spmicroservice.service.RulesMicroserviceLocalServiceUtil;
import com.sambaash.platform.systemmodelsetup.service.SystemLocalServiceUtil;

public class ListActionHandler implements ServeResourceActionHandler {
	private Log log = LogFactoryUtil.getLog(ListActionHandler.class.getName());

	@Override
	public void handle(ResourceRequest request, ResourceResponse response) {
		try {
		JSONArray modelData = RulesMicroserviceLocalServiceUtil.getPERuleSets(true, "");
			response.getWriter().write(modelData.toString());

		} catch (IOException e) {
			log.error(e);
		}

	}

}
