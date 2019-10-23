package com.sambaash.platform.portlet.spjob.permissions;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.Layout;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.security.permission.PermissionThreadLocal;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.service.permission.PortletPermissionUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.sambaash.platform.portlet.spjob.util.SPJobConstants;
import com.sambaash.platform.util.SambaashUtil;

public class JobPermissionsUtil {
	
	private static final Log _log = LogFactoryUtil.getLog(JobPermissionsUtil.class);
	
	public static void authorize(ThemeDisplay themeDisplay, String portletName,String action,String pageName)
			throws PrincipalException, PortalException, SystemException {
		Layout layout = themeDisplay.getLayout();
		if(SambaashUtil.isAdmin(themeDisplay.getScopeGroupId(), themeDisplay.getUserId())){
			return;
		}
		long plid = layout.getPlid();
		_log.debug("Pliid currentpage "+plid);
		if(!pageName.isEmpty()){
			try {
			plid = LayoutLocalServiceUtil.getFriendlyURLLayout(themeDisplay.getScopeGroupId(), false, "/"+pageName).getPlid();
			_log.debug("Pliid==>"+plid);
			} catch (Exception e) {
				_log.error(e.getMessage());
			} 
		}
		PermissionChecker permissionChecker = PermissionThreadLocal
				.getPermissionChecker();
		try {
			PortletPermissionUtil.check(permissionChecker, plid,
					portletName, action);
		} catch (PrincipalException pe) {
			//_log.error("pe pe " + pe.getMessage() + " portletName " + portletName + " action " + action);
			throw new PrincipalException(pe);
		}
	}
	
	public static boolean hasCreatePermission(ThemeDisplay themeDisplay,String pageName){
		boolean hasPermission = false;
		try {
			authorize(themeDisplay, SPJobConstants.CREATE_PORTLET_ID, SPJobConstants.ACTION_CREATE,pageName);
			hasPermission = true;
		} catch (PrincipalException pe) {
			_log.error("Not authorized to post new jobs");
		} catch (PortalException e) {
			_log.error(e);
		} catch (SystemException e) {
			_log.error(e);
		}
		return hasPermission;
	}
	public static boolean hasEditPermission(ThemeDisplay themeDisplay,String pageName){
		boolean hasPermission = false;
		try {
			authorize(themeDisplay, SPJobConstants.CREATE_PORTLET_ID, SPJobConstants.ACTION_EDIT,pageName);
			hasPermission = true;
		} catch (PrincipalException pe) {
			_log.error("Not authorized to edit jobs");
		} catch (PortalException e) {
			_log.error(e);
		} catch (SystemException e) {
			_log.error(e);
		}
		return hasPermission;
	}
	public static boolean hasDeletePermission(ThemeDisplay themeDisplay,String pageName){
		boolean hasPermission = false;
		try {
			authorize(themeDisplay, SPJobConstants.CREATE_PORTLET_ID, SPJobConstants.ACTION_DELETE,pageName);
			hasPermission = true;
		} catch (PrincipalException pe) {
			_log.error("Not authorized to delete jobs");
		} catch (PortalException e) {
			_log.error(e);
		} catch (SystemException e) {
			_log.error(e);
		}
		return hasPermission;
	}
	public static boolean hasJobApplyPermission(ThemeDisplay themeDisplay,String pageName){
		boolean hasPermission = false;
		try {
			authorize(themeDisplay, SPJobConstants.APPLY_PORTLET_ID, SPJobConstants.ACTION_JOB_APPLY,pageName);
			hasPermission = true;
		} catch (PrincipalException pe) {
			_log.error("Not authorized to apply for jobs");
		} catch (PortalException e) {
			_log.error(e);
		} catch (SystemException e) {
			_log.error(e);
		}
		return hasPermission;
	}
	public static boolean hasJobViewPermission(ThemeDisplay themeDisplay,String pageName){
		boolean hasPermission = false;
		try {
			authorize(themeDisplay, SPJobConstants.APPLY_PORTLET_ID, SPJobConstants.ACTION_JOB_VIEW,pageName);
			hasPermission = true;
		} catch (PrincipalException pe) {
			_log.error("Not authorized to view listing");
		} catch (PortalException e) {
			_log.error(e);
		} catch (SystemException e) {
			_log.error(e);
		}
		return hasPermission;
	}
}
