package com.sambaash.platform.product.util;

import javax.portlet.PortletConfig;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.JavaConstants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.sambaash.platform.product.permissions.ProductPermissionsUtil;
import com.sambaash.platform.srv.model.FeeType;
import com.sambaash.platform.srv.service.FeeTypeLocalServiceUtil;
import com.sambaash.platform.util.LabelUtil;

public class SPFeeTypeUtil {

	private static Log _log = LogFactoryUtil.getLog(SPFeeTypeUtil.class);

	public static JSONObject addUpdateFeeType(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {

		JSONObject response = JSONFactoryUtil.createJSONObject();
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		PortletConfig portletConfig = (PortletConfig) resourceRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
		try {
			_log.error("Add/Update FeeType");

			long spFeeTypeId = ParamUtil.getLong(resourceRequest, "spFeeTypeId");
			boolean hasPermission = false;
			if(spFeeTypeId > 0){
				// update permission check
				hasPermission = ProductPermissionsUtil.hasUpdatePermission(themeDisplay);
			}else{
			    // create permission check
				hasPermission = ProductPermissionsUtil.hasAddPermission(themeDisplay);
			}
			
			if(!hasPermission){
				response.put("error", LabelUtil.getLabel(portletConfig, themeDisplay, "label.product.noauth.add.feeType"));
				return response;
			}
			
			String feeType = resourceRequest.getParameter("spFeeTypeCode");
			String feeTypeName = resourceRequest.getParameter("feeTypeName");
			String feeTypeDesc = resourceRequest.getParameter("feeTypeDesc");
			String misc = resourceRequest.getParameter("misc");

			// check for Fee Type uniqueness
			try {
				FeeType dbFeeType = FeeTypeLocalServiceUtil.findByFeeType(feeType);
				
				if(spFeeTypeId <= 0 && feeType.equalsIgnoreCase(dbFeeType.getFeeType())) {
					response.put("error", LabelUtil.getLabel(portletConfig,themeDisplay, "label.product.feeType.exist") 
							+ feeType + LabelUtil.getLabel(portletConfig,themeDisplay,"label.product.unique.feeType"));
					return response;
				}
				
			} catch (Exception e) {
							
			}
			
			FeeType nuFeeType = null;

			if (spFeeTypeId > 0) {
				nuFeeType = FeeTypeLocalServiceUtil.fetchFeeType(spFeeTypeId);
				nuFeeType.setModifiedDate(DateUtil.newDate());
			} else {
				nuFeeType = FeeTypeLocalServiceUtil.create();
				nuFeeType.setCreateDate(DateUtil.newDate());
				nuFeeType.setCompanyId(themeDisplay.getCompanyId());
				nuFeeType.setGroupId(themeDisplay.getScopeGroupId());
			}

			nuFeeType.setUserId(themeDisplay.getUser().getUserId());
			nuFeeType.setUserName(themeDisplay.getUser().getFullName());

			nuFeeType.setFeeType(feeType);
			nuFeeType.setFeeTypeName(feeTypeName);
			nuFeeType.setFeeTypeDesc(feeTypeDesc);
			nuFeeType.setMisc(GetterUtil.getBoolean(misc));
			
			FeeTypeLocalServiceUtil.updateFeeType(nuFeeType);
			FeeTypeLocalServiceUtil.clearCache();

			response.put("saveFlag", "success");
			response.put("spFeeTypeId", nuFeeType.getSpFeeTypeId());

		} catch (Exception e) {
			_log.error(e);
			response.put("error", LabelUtil.getLabel(portletConfig, themeDisplay, "label.product.create.feeComponent.save.error"));
		}

		return response;

	}

}
