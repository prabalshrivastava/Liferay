package com.sambaash.platform.rpec.ajax;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.sambaash.platform.action.ServeResourceActionHandler;
import com.sambaash.platform.rpec.service.SPRPECLocalServiceUtil;


public class ListByElastic  implements ServeResourceActionHandler{
	private Log log = LogFactoryUtil.getLog(ListByElastic.class.getName());

	@Override
	public void handle(ResourceRequest request, ResourceResponse response) {
		try {
			String modelData = SPRPECLocalServiceUtil.getGridData(request, response);
			
			response.getWriter().write(modelData);
		} catch (Exception e) {
			log.error(e);
		}
	}
}
