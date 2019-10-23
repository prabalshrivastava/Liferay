package com.sambaash.platform.portlet.rule.builder.action.ajax;

import java.io.IOException;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.sambaash.platform.action.ServeResourceActionHandler;
import com.sambaash.platform.srv.spmicroservice.service.RulesMicroserviceLocalServiceUtil;

public class FetchRuleSetTypeHandler  implements ServeResourceActionHandler {
	private static final Log _log = LogFactoryUtil.getLog(FetchRuleSetTypeHandler.class);
	
	@Override
	public void handle(ResourceRequest request, ResourceResponse response) {
		JSONArray formList = RulesMicroserviceLocalServiceUtil.fetchRuleSetTypes(false);
		try {
			response.getWriter().write(formList.toString());
		} catch (IOException e) {
			_log.error(e);
		}	
	}

}
