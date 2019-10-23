package com.sambaash.platform.spdashboard.action;

import java.io.IOException;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.sambaash.platform.spdashboard.SPDashboardConstants;
import com.sambaash.platform.srv.spdashboard.model.SPAnalyticsConfig;
import com.sambaash.platform.srv.spdashboard.service.SPAnalyticsConfigLocalServiceUtil;

/**
 * Portlet implementation class SPDashboardAction
 */
public class SPDashboardAction extends MVCPortlet {
	
	private static final Log logger = LogFactoryUtil
			.getLog(SPDashboardAction.class);
	
	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		super.doView(renderRequest, renderResponse);
	}
	
	@Override
	public void serveResource(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws IOException,
			PortletException {

		String warId = ParamUtil.getString(resourceRequest,
				"warId");
		Integer type = ParamUtil.getInteger(resourceRequest, "type");
		JSONObject obj = JSONFactoryUtil.createJSONObject();
		try {
			List<SPAnalyticsConfig> configs = SPAnalyticsConfigLocalServiceUtil.findByWarIdAndType(warId, type);
			StringBuilder builder = new StringBuilder();
			for (SPAnalyticsConfig anaConfig : configs) {
				builder.append("<option value='" + anaConfig.getSpAnalyticsConfigId()
						+ "'>" + anaConfig.getName() + "</option>\n");
			}
			obj.put("options", builder.toString());
			resourceResponse.getWriter().append(obj.toString());
		} catch (Exception e) {
			obj.put(SPDashboardConstants.RESP_MSG,
					"Error getting indexed fields");
			logger.error("Error getting indexed fields", e);
			resourceResponse.getWriter().append(obj.toString());
		}
	
	}
}
