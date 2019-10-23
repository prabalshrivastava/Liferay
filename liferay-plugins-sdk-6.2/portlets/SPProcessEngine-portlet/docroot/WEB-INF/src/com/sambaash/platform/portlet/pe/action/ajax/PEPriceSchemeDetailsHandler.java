package com.sambaash.platform.portlet.pe.action.ajax;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.sambaash.platform.action.ServeResourceActionHandler;
import com.sambaash.platform.srv.spmicroservice.service.PricingMicroserviceLocalServiceUtil;

public class PEPriceSchemeDetailsHandler implements ServeResourceActionHandler {
	private static final Log LOG = LogFactoryUtil.getLog(PEPriceSchemeDetailsHandler.class);

	@Override
	public void handle(ResourceRequest request, ResourceResponse response) {
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			String priceSchemeCode = ParamUtil.getString(request, "priceSchemeCode");
			JSONArray data = PricingMicroserviceLocalServiceUtil.getPEPriceSchemeDetails(themeDisplay.getScopeGroupId(), priceSchemeCode);
			response.getWriter().write(data.toString());
		} catch (Exception e) {
			LOG.error(e);
		}
	}

}
