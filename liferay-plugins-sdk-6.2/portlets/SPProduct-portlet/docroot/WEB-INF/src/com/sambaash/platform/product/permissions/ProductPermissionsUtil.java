package com.sambaash.platform.product.permissions;

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
import com.sambaash.platform.product.util.SPProductConstants;
import com.sambaash.platform.util.SambaashUtil;

public class ProductPermissionsUtil {
	
	private static final Log _log = LogFactoryUtil.getLog(ProductPermissionsUtil.class);
	
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
			authorize(themeDisplay, SPProductConstants.PORTLET_ID, SPProductConstants.ACTION_EXPORT);
			hasPermission = true;
		} catch (PrincipalException pe) {
			_log.error("Not authorized to export process states");
		} catch (PortalException e) {
			_log.error(e);
		} catch (SystemException e) {
			_log.error(e);
		}
		return hasPermission;
	}
	public static boolean hasAddPermission(ThemeDisplay themeDisplay){
		boolean hasPermission = false;
		try {
			authorize(themeDisplay, SPProductConstants.PORTLET_ID, SPProductConstants.ACTION_ADD);
			hasPermission = true;
		} catch (PrincipalException pe) {
			_log.error("Not authorized to add");
		} catch (PortalException e) {
			_log.error(e);
		} catch (SystemException e) {
			_log.error(e);
		}
		return hasPermission;
	}
	public static boolean hasUpdatePermission(ThemeDisplay themeDisplay){
		boolean hasPermission = false;
		try {
			authorize(themeDisplay, SPProductConstants.PORTLET_ID, SPProductConstants.ACTION_UPDATE);
			hasPermission = true;
		} catch (PrincipalException pe) {
			_log.error("Not authorized to update");
		} catch (PortalException e) {
			_log.error(e);
		} catch (SystemException e) {
			_log.error(e);
		}
		return hasPermission;
	}
	public static boolean hasDeletePermission(ThemeDisplay themeDisplay){
		boolean hasPermission = false;
		try {
			authorize(themeDisplay, SPProductConstants.PORTLET_ID, SPProductConstants.ACTION_DELETE);
			hasPermission = true;
		} catch (PrincipalException pe) {
			_log.error("Not authorized to delete");
		} catch (PortalException e) {
			_log.error(e);
		} catch (SystemException e) {
			_log.error(e);
		}
		return hasPermission;
	}
	public static boolean hasPublishPermission(ThemeDisplay themeDisplay){
		boolean hasPermission = false;
		try {
			authorize(themeDisplay, SPProductConstants.PORTLET_ID, SPProductConstants.ACTION_PUBLISH);
			hasPermission = true;
		} catch (PrincipalException pe) {
			_log.error("Not authorized to publish/unpublish");
		} catch (PortalException e) {
			_log.error(e);
		} catch (SystemException e) {
			_log.error(e);
		}
		return hasPermission;
	}
	public static boolean hasListViewPermission(ThemeDisplay themeDisplay){
		boolean hasPermission = false;
		try {
			authorize(themeDisplay, SPProductConstants.PORTLET_ID, SPProductConstants.ACTION_LIST_VIEW);
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
	public static boolean hasAnalyticsPermission(ThemeDisplay themeDisplay){
		boolean hasPermission = false;
		try {
			authorize(themeDisplay, SPProductConstants.PORTLET_ID, SPProductConstants.ACTION_ANALYTICS);
			hasPermission = true;
		} catch (PrincipalException pe) {
			_log.error("Not authorized to export process states");
		} catch (PortalException e) {
			_log.error(e);
		} catch (SystemException e) {
			_log.error(e);
		}
		return hasPermission;
	}
	public static boolean hasSearchPermission(ThemeDisplay themeDisplay){
		boolean hasPermission = false;
		try {
			authorize(themeDisplay, SPProductConstants.PORTLET_ID, SPProductConstants.ACTION_SEARCH);
			hasPermission = true;
		} catch (PrincipalException pe) {
			_log.error("Not authorized to SEARCH");
		} catch (PortalException e) {
			_log.error(e);
		} catch (SystemException e) {
			_log.error(e);
		}
		return hasPermission;
	}
	public static boolean hasPreviewPermission(ThemeDisplay themeDisplay){
		boolean hasPermission = false;
		try {
			authorize(themeDisplay, SPProductConstants.PORTLET_ID, SPProductConstants.ACTION_PREVIEW);
			hasPermission = true;
		} catch (PrincipalException pe) {
			_log.error("Not authorized to preview");
		} catch (PortalException e) {
			_log.error(e);
		} catch (SystemException e) {
			_log.error(e);
		}
		return hasPermission;
	}
}
