package com.sambaash.platform.pe.permissions;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.Layout;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.security.permission.PermissionThreadLocal;
import com.liferay.portal.service.permission.PortletPermissionUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.sambaash.platform.pe.constants.PEConstants;
import com.sambaash.platform.util.SambaashUtil;

public class PermissionsUtil {
	
	private static final Log _log = LogFactoryUtil.getLog(PermissionsUtil.class);
	
	public static void authorize(ThemeDisplay themeDisplay, String portletName,String action)
			throws PrincipalException, PortalException, SystemException {
		Layout layout = themeDisplay.getLayout();
		if(SambaashUtil.isAdmin(themeDisplay.getScopeGroupId(), themeDisplay.getUserId())){
			return;
		}
		long plid = layout.getPlid();
		PermissionChecker permissionChecker = PermissionThreadLocal
				.getPermissionChecker();
		try {
			PortletPermissionUtil.check(permissionChecker, plid,
					portletName, action);
		} catch (PrincipalException pe) {
			throw new PrincipalException(pe);
		}
	}
	public static boolean hasExportPermission(ThemeDisplay themeDisplay){
		boolean hasPermission = false;
		try {
			authorize(themeDisplay, PEConstants.PORTLET_ID_PROCESS_STATE, PEConstants.ACTION_EXPORT);
			hasPermission = true;
		} catch (PrincipalException pe) {
			_log.error("Not authorized to export process states");
		} catch (PortalException  | SystemException e) {
			_log.error(e);
		}
		return hasPermission;
	}
	public static boolean hasAssignPermission(ThemeDisplay themeDisplay){
		boolean hasPermission = false;
		try {
			authorize(themeDisplay, PEConstants.PORTLET_ID_PROCESS_STATE, PEConstants.ACTION_ASSIGN);
			hasPermission = true;
		} catch (PrincipalException pe) {
			_log.error("Not authorized to assign process states");
		} catch (PortalException  | SystemException e) {
			_log.error(e);
		}
		return hasPermission;
	}
	public static boolean hasApplicationClosePermission(ThemeDisplay themeDisplay){
		boolean hasPermission = false;
		try {
			authorize(themeDisplay, PEConstants.PORTLET_ID_PROCESS_STATE, PEConstants.ACTION_CLOSE);
			hasPermission = true;
		} catch (PrincipalException pe) {
			_log.error("Not authorized to close process state");
		} catch (PortalException  | SystemException e) {
			_log.error(e);
		}
		return hasPermission;
	}
	public static boolean hasApplicationChangeStatusPermission(ThemeDisplay themeDisplay){
		boolean hasPermission = false;
		try {
			authorize(themeDisplay, PEConstants.PORTLET_ID_PROCESS_STATE, PEConstants.ACTION_CHANGE_STATUS);
			hasPermission = true;
		} catch (PrincipalException pe) {
			_log.error("Not authorized to change the status of process state");
		} catch (PortalException  | SystemException e) {
			_log.error(e);
		}
		return hasPermission;
	}
	public static boolean hasSearchSectionPermission(ThemeDisplay themeDisplay){
		boolean hasPermission = false;
		try {
			authorize(themeDisplay, PEConstants.PORTLET_ID_PROCESS_STATE, PEConstants.ACTION_DISPLAY_SEARCH_SECTION);
			hasPermission = true;
		} catch (PrincipalException pe) {
			_log.error("Not authorized to view the search section");
		} catch (PortalException  | SystemException e) {
			_log.error(e);
		}
		return hasPermission;
	}
	public static boolean hasBulkUploadPermission(ThemeDisplay themeDisplay){
		boolean hasPermission = false;
		try {
			authorize(themeDisplay, PEConstants.PORTLET_ID_PROCESS_STATE, PEConstants.ACTION_BULK_UPLOAD);
			hasPermission = true;
		} catch (PrincipalException pe) {
			_log.error("Not authorized to change the status of process state");
		} catch (PortalException  | SystemException e) {
			_log.error(e);
		}
		return hasPermission;
	}
}
