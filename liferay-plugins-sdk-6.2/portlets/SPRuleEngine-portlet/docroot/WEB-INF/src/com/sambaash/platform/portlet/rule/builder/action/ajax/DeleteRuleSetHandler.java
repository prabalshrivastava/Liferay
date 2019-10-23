package com.sambaash.platform.portlet.rule.builder.action.ajax;

import java.io.IOException;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.sambaash.platform.action.ServeResourceActionHandler;
import com.sambaash.platform.srv.spmicroservice.service.RulesMicroserviceLocalServiceUtil;

public class DeleteRuleSetHandler  implements ServeResourceActionHandler {
	private static final Log _log = LogFactoryUtil.getLog(DeleteRuleSetHandler.class);
	
	@Override
	public void handle(ResourceRequest request, ResourceResponse response) {
		try {
			Long ruleSetId = Long.parseLong(request.getParameter("data"));
			JSONObject ruleSet = RulesMicroserviceLocalServiceUtil.deleteRuleSet(ruleSetId);
			response.getWriter().write(ruleSet.toString());
		} catch (IOException e) {
			_log.error(e);
		}	
	}

}
