package com.sambaash.platform.event.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liferay.portal.kernel.events.Action;
import com.liferay.portal.kernel.events.ActionException;

public class ExtServicePreAction extends Action {
	public void run(HttpServletRequest request, HttpServletResponse res)
			throws ActionException {
		
//		code moved to FreeMarkerTemplateContextHelper
//		Map<String, Object> ftlVariables = new HashMap<String, Object>();
//		
//		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
//		
//		// Setup some variables
//		ftlVariables.put("hasAccess", SambaashUtil.isAdmin(themeDisplay.getScopeGroupId(),themeDisplay.getUserId()));
//		ftlVariables.put("dashboardUrl", SambaashUtil.getDashboardUrl(themeDisplay.getScopeGroupId(), themeDisplay.getUserId()));
//		request.setAttribute(SambaashConstants.FTL_VARIABLES, ftlVariables);
	}

}