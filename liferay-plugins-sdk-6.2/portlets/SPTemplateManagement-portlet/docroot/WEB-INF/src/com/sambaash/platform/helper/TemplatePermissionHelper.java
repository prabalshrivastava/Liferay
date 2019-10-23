package com.sambaash.platform.helper;

import javax.portlet.PortletRequest;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Layout;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.security.permission.PermissionThreadLocal;
import com.liferay.portal.service.permission.PortletPermissionUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.sambaash.platform.util.SambaashUtil;
import com.sambaash.platform.TemplateConstants; 


public class TemplatePermissionHelper {
	private static final Log logger = LogFactoryUtil.getLog(TemplatePermissionHelper.class);
	
	public static boolean canViewTemplates(PortletRequest request){
		boolean canView = false;
		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
		try {
			if ((authorize(request, TemplateConstants.PORTLET_ID,
					TemplateConstants.ACTION_VIEW_TEMPLATES) )){  
				canView = true;
			}
			if(SambaashUtil.isAdmin(themeDisplay.getScopeGroupId(), themeDisplay.getUserId())){
				canView = true;
			}
			
		} catch (Exception e) {
			logger.error("Error while checking startup view permission for [userId,orgId] =" + themeDisplay.getUserId() + " " ,e);
		}
		if (!canView && logger.isWarnEnabled())
			logger.warn("Unauthorized user with id = " + themeDisplay.getUserId() + " trying to view startup with id = " );
		return canView;
	}
	public static boolean canViewTemplate(PortletRequest request){
		boolean canView = false;
		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
		try {
			if ((authorize(request, TemplateConstants.PORTLET_ID,
				TemplateConstants.ACTION_VIEW_TEMPLATE) )){  
				canView = true;
			}
			if(SambaashUtil.isAdmin(themeDisplay.getScopeGroupId(), themeDisplay.getUserId())){
				canView = true;
			}
		} catch (Exception e) {
			logger.error("Error while checking startup view permission for [userId,orgId] =" + themeDisplay.getUserId() + " " ,e);
		}
		if (!canView && logger.isWarnEnabled())
			logger.warn("Unauthorized user with id = " + themeDisplay.getUserId() + " trying to view template with id = " );
		return canView;
	}
	public static boolean canAddTemplate(PortletRequest request){
		boolean canView = false;
		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
		try {
			if ((authorize(request, TemplateConstants.PORTLET_ID,
				TemplateConstants.ACTION_ADD_TEMPLATE) )){  
				canView = true;
			}
			if(SambaashUtil.isAdmin(themeDisplay.getScopeGroupId(), themeDisplay.getUserId())){
				canView = true;
			}
		} catch (Exception e) {
			logger.error("Error while checking startup view permission for [userId,orgId] =" + themeDisplay.getUserId() + " " ,e);
		}
		if (!canView && logger.isWarnEnabled())
			logger.warn("Unauthorized user with id = " + themeDisplay.getUserId() + " trying to view template with id = " );
		return canView;
	}
	public static boolean canEditTemplate(PortletRequest request){
		boolean canView = false;
		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
		try {
			if ((authorize(request, TemplateConstants.PORTLET_ID,
				TemplateConstants.ACTION_UPDATE_TEMPLATE) )){  
				canView = true;
			}
			if(SambaashUtil.isAdmin(themeDisplay.getScopeGroupId(), themeDisplay.getUserId())){
				canView = true;
			}
		} catch (Exception e) {
			logger.error("Error while checking startup view permission for [userId,orgId] =" + themeDisplay.getUserId() + " " ,e);
		}
		if (!canView && logger.isWarnEnabled())
			logger.warn("Unauthorized user with id = " + themeDisplay.getUserId() + " trying to view template with id = " );
		return canView;
	}
	public static boolean canDeleteTemplate(PortletRequest request){
		boolean canView = false;
		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
		try {
			if ((authorize(request, TemplateConstants.PORTLET_ID,
				TemplateConstants.ACTION_DELETE_TEMPLATE) )){  
				canView = true;
			}
			if(SambaashUtil.isAdmin(themeDisplay.getScopeGroupId(), themeDisplay.getUserId())){
				canView = true;
			}
		} catch (Exception e) {
			logger.error("Error while checking startup view permission for [userId,orgId] =" + themeDisplay.getUserId() + " " ,e);
		}
		if (!canView && logger.isWarnEnabled())
			logger.warn("Unauthorized user with id = " + themeDisplay.getUserId() + " trying to view template with id = " );
		return canView;
	}
	public static boolean authorize(PortletRequest req, String portletName,String action) {
		ThemeDisplay themeDisplay = (ThemeDisplay) req
				.getAttribute(WebKeys.THEME_DISPLAY);
		Layout layout = themeDisplay.getLayout();
		long plid = layout.getPlid();
		PermissionChecker permissionChecker = PermissionThreadLocal
				.getPermissionChecker();
		try {
			PortletPermissionUtil.check(permissionChecker, plid,
					portletName, action);
		} catch (PrincipalException pe) {
			logger.warn("Unauthorized access of " + action + " by user " + themeDisplay.getUserId());
			return false;
		} catch (Exception e) {
			logger.error("System error while checking permission for " + action + " by user " + themeDisplay.getUserId());
			return false;
		}
		return true;
	}
}
