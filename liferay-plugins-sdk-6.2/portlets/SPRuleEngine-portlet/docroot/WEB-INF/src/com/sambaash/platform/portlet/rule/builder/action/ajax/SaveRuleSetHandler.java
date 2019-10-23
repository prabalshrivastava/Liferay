package com.sambaash.platform.portlet.rule.builder.action.ajax;

import java.io.IOException;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.sambaash.platform.action.ServeResourceActionHandler;
import com.sambaash.platform.srv.spmicroservice.service.RulesMicroserviceLocalServiceUtil;

public class SaveRuleSetHandler  implements ServeResourceActionHandler {
	private static final Log _log = LogFactoryUtil.getLog(SaveRuleSetHandler.class);
	
	@Override
	public void handle(ResourceRequest request, ResourceResponse response) {
		String jsonString = ParamUtil.getString(request, "data");
		JSONObject rs;
		try {
			rs = JSONFactoryUtil.createJSONObject(jsonString);
		} catch (Exception e) {
			rs = JSONFactoryUtil.createJSONObject();
		}
		rs = RulesMicroserviceLocalServiceUtil.saveRuleSet(rs);
		
		try {
			response.getWriter().write(rs.toString());
		} catch (IOException e) {
			_log.error(e);
		}	
	}

}
