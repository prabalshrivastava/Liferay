package com.sambaash.platform.product.util;

import java.util.List;

import javax.portlet.PortletConfig;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.JavaConstants;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.sambaash.platform.product.permissions.ProductPermissionsUtil;
import com.sambaash.platform.srv.NoSuchFrameworkException;
import com.sambaash.platform.srv.model.Framework;
import com.sambaash.platform.srv.service.FrameworkLocalServiceUtil;
import com.sambaash.platform.util.LabelUtil;

public class SPFrameworkUtil {

	private static Log _log = LogFactoryUtil.getLog(SPFrameworkUtil.class);

	public static JSONArray getFramework(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {

		JSONArray jsonResults = JSONFactoryUtil.createJSONArray();
		try {

			_log.error("Get Framework");

			List<Framework> frameworkList = FrameworkLocalServiceUtil.getFrameworks(-1, -1);

			for (Framework framework : frameworkList) {
				JSONObject jsonCells = JSONFactoryUtil.createJSONObject();
				jsonCells.put("frameworkCode", framework.getFrameworkCode());
				jsonCells.put("id", framework.getSpFrameworkId());
				jsonCells.put("frameworkName", framework.getFrameworkName());
				jsonResults.put(jsonCells);
			}

		} catch (SystemException e) {
			_log.error(e);
		}

		return jsonResults;
	}

	public static JSONObject addFramework(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {

		JSONObject response = JSONFactoryUtil.createJSONObject();
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		PortletConfig portletConfig = (PortletConfig) resourceRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
		try {

			_log.error("Adding Framework");

			String frameworkId = resourceRequest.getParameter("spFrameworkId");
			boolean hasPermission = false;
			if(GetterUtil.getLong(frameworkId) > 0){
				// update permission check
				hasPermission = ProductPermissionsUtil.hasUpdatePermission(themeDisplay);
			}else{
			    // create permission check
				hasPermission = ProductPermissionsUtil.hasAddPermission(themeDisplay);
			}
			
			if(!hasPermission){
				response.put("error", LabelUtil.getLabel(portletConfig,themeDisplay,"label.product.noauth.add.framework"));
				return response;
			}
			String frameworkCode = resourceRequest.getParameter("frameworkCode");
			//check for uniqness
			try{
				Framework existing = FrameworkLocalServiceUtil.findByFramworkCode(frameworkCode);
				if(existing.getSpFrameworkId() != GetterUtil.getLong(frameworkId)){
					response.put("error", LabelUtil.getLabel(portletConfig,themeDisplay,"label.product.framework.exist") + frameworkCode +LabelUtil.getLabel(portletConfig,themeDisplay,"label.product.unique.framework"));
					return response;
				}
			}catch(NoSuchFrameworkException ex){
				//doesn't exist.. so fine.
			}
			
			String frameworkName = resourceRequest.getParameter("frameworkName");
			String newFrameworkImageId = resourceRequest.getParameter("frameworkImageId");
			Framework framework = null;
			if (Validator.isNumber(frameworkId)) {
				framework = FrameworkLocalServiceUtil.fetchFramework(Long.parseLong(frameworkId));
				framework.setModifiedDate(DateUtil.newDate());
			} else {
				long spFrameworkId = CounterLocalServiceUtil.increment("Framework.class");
				framework = FrameworkLocalServiceUtil.createFramework(spFrameworkId);
				framework.setCreateDate(DateUtil.newDate());
				framework.setCompanyId(themeDisplay.getCompanyId());
				framework.setGroupId(themeDisplay.getScopeGroupId());

			}
			
			long oldFrameworkImageId = GetterUtil.getLong(framework.getFrameworkImageId());
			
			if (Validator.isNumber(newFrameworkImageId)) {
				framework.setFrameworkImageId(Long.parseLong(newFrameworkImageId));
			}

			framework.setUserId(themeDisplay.getUser().getUserId());
			framework.setUserName(themeDisplay.getUser().getFullName());
			framework.setFrameworkCode(frameworkCode);
			framework.setFrameworkName(frameworkName);

			FrameworkLocalServiceUtil.updateFramework(framework);
			response.put("spFrameworkId", framework.getSpFrameworkId());
			FrameworkLocalServiceUtil.clearCache();
			
			/*
			 * As the framework image id is stored in product indexer, we reindex the ProductIndexer whenever a new framework image is uploaded.
			 */
			if (oldFrameworkImageId != GetterUtil.getLong(newFrameworkImageId)){
				SPFrameworkProductIndexerThread frameworkProductIndexerUpdate = new SPFrameworkProductIndexerThread(framework, themeDisplay.getUser());
				Thread frameworkProductIndexerThread = new Thread(frameworkProductIndexerUpdate);
				frameworkProductIndexerThread.setName("Framework Product Indexer Updater Thread");
				frameworkProductIndexerThread.start();
			}

			response.put("saveFlag", "success");

		} catch (SystemException e) {
			response.put("error", LabelUtil.getLabel(portletConfig,themeDisplay,"label.product.create.framework.save.error"));
			_log.error(e);
		}

		return response;
	}

}
