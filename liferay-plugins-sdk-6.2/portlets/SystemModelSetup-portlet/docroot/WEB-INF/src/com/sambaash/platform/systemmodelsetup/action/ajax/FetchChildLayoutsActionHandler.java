package com.sambaash.platform.systemmodelsetup.action.ajax;

import java.io.IOException;
import java.util.List;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Layout;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.sambaash.platform.action.ServeResourceActionHandler;
import com.sambaash.platform.util.SambaashUtil;

public class FetchChildLayoutsActionHandler implements ServeResourceActionHandler {
	private Log log = LogFactoryUtil.getLog(FetchChildLayoutsActionHandler.class.getName());
	@Override
	public void handle(ResourceRequest request, ResourceResponse response) {
		
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			
			long groupId = themeDisplay.getScopeGroupId();
					
			List<Layout> layouts =  LayoutLocalServiceUtil.getLayouts(groupId, false,  Long.valueOf(request.getParameter("layoutId")));
			
			JSONArray categoryArray = JSONFactoryUtil.createJSONArray();
			
		  	  for (Layout llayout :layouts) {
		  		JSONObject js = JSONFactoryUtil.createJSONObject();    
		         js.put("id",  llayout.getLayoutId());
		         js.put("name",llayout.getFriendlyURL());
		         categoryArray.put(js);
		  	  }
			  response.getWriter().write(categoryArray.toString());
				
			} catch (NumberFormatException | IOException | SystemException e) {
				log.error(e);
			}
		
	}

}
