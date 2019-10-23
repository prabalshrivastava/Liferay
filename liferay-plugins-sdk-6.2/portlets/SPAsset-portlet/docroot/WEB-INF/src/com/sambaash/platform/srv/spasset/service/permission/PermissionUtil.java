package com.sambaash.platform.srv.spasset.service.permission;

import javax.portlet.PortletRequest;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Layout;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.service.permission.PortletPermissionUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.sambaash.platform.portlet.spasset.helper.SPAssetHelper;
import com.sambaash.platform.srv.spasset.model.SPAssetEntry;

public class PermissionUtil {

	public static void authorize(ThemeDisplay themeDisplay, String portletName,String action) throws PrincipalException, PortalException, SystemException {
		
		// permission checker code
		
		Layout layout = themeDisplay.getLayout();
		long plid = layout.getPlid();
		PermissionChecker permissionChecker =themeDisplay.getPermissionChecker();
		try {
			PortletPermissionUtil.check(permissionChecker, plid,portletName, action);
		} catch (PrincipalException pe) {
			throw new PrincipalException(pe);
		}
		
	}
	
	public static boolean authorizeModel(PortletRequest req, String portletName,String action)
			throws PrincipalException, PortalException, SystemException {
	
		boolean hasPermission = false;
		ThemeDisplay themeDisplay = (ThemeDisplay) req
				.getAttribute(WebKeys.THEME_DISPLAY);
		try {
			authorize(themeDisplay, portletName, action);
			hasPermission = true;
		} catch (PrincipalException pe) {
			_log.error("Not authorized");
		} catch (PortalException e) {
			_log.error(e);
		} catch (SystemException e) {
			_log.error(e);
		}
		return hasPermission;
		
	}
	
	public static boolean authorizeModel(PortletRequest req,long spAssetEntryId,String action)
			throws PrincipalException, PortalException, SystemException {
	
	ThemeDisplay themeDisplay = (ThemeDisplay)
			req.getAttribute(WebKeys.THEME_DISPLAY);
		PermissionChecker permissionChecker = themeDisplay.getPermissionChecker();
		
		return permissionChecker
		                .hasPermission(themeDisplay.getScopeGroupId(),
		                        SPAssetEntry.class.getName(),spAssetEntryId,action);
		
		
	}
	
	private static final Log _log = LogFactoryUtil.getLog(PermissionUtil.class);
}
