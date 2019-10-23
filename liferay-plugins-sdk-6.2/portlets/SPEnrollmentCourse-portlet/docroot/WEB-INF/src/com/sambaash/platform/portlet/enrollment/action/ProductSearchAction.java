package com.sambaash.platform.portlet.enrollment.action;

import java.io.IOException;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.sambaash.platform.portlet.enrollment.helper.ApplicantSearchHelper;
import com.sambaash.platform.portlet.enrollment.helper.ProductSearchHelper;

public class ProductSearchAction extends MVCPortlet {

	@Override
	public void doView(RenderRequest request, RenderResponse response) {

	}

	public void serveResource(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws IOException,
			PortletException {
		JSONObject data = JSONFactoryUtil.createJSONObject();

		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest
				.getAttribute(WebKeys.THEME_DISPLAY);

		String action = ParamUtil.getString(resourceRequest, "action");
		if ("fetchProducts".equals(action)) {
			try{
				data = ProductSearchHelper.searchProducts(resourceRequest);
			}catch(Exception ex){
				data.put("error", "Error while fetching products");
			}
		}else if ("fetchApplicants".equals(action)) {
			try{
				data = ApplicantSearchHelper.searchApplicants(resourceRequest);
			}catch(Exception ex){
				data.put("error", "Error while fetching products");
			}
		}
		resourceResponse.getWriter().write(data.toString());
	}
}
