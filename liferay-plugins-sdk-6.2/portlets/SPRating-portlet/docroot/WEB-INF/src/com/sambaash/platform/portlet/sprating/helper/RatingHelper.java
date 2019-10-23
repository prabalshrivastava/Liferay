package com.sambaash.platform.portlet.sprating.helper;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletRequest;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.ClassName;
import com.liferay.portal.model.Layout;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.security.permission.PermissionThreadLocal;
import com.liferay.portal.service.ClassNameLocalServiceUtil;
import com.liferay.portal.service.permission.PortletPermissionUtil;
import com.liferay.portal.theme.PortletDisplay;
import com.liferay.portal.theme.ThemeDisplay;
import com.sambaash.platform.portlet.sprating.RatingConstants;


public class RatingHelper {
	
	public static Map<Long,String> getModelClassNames(){
		Map<Long,String> map = new LinkedHashMap<Long,String>();
		try{
			List<ClassName>names = ClassNameLocalServiceUtil.getClassNames(-1, -1);
			for(ClassName name:names){
				map.put(name.getClassNameId(), name.getClassName());
			}
		}catch(Exception ex){
			
		}
		return  map;
	}

	public static ThemeDisplay getThemeDisplay(PortletRequest request){
		return (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
	}
	
	public static Date getTodayDate(){
		return new Date();
	}
	public static void authorize(PortletRequest req, String portletName,String action)
			throws PrincipalException, PortalException, SystemException {
		// permission checker code
		ThemeDisplay themeDisplay = getThemeDisplay(req);
		Layout layout = themeDisplay.getLayout();
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
	
	public static boolean checkRatingPermission(PortletRequest req) throws PortalException, SystemException{
		boolean hasPermission = false;
		try{
			ThemeDisplay themeDisplay = getThemeDisplay(req);
			PortletDisplay portletDisplay= themeDisplay.getPortletDisplay();
			  String portletId= portletDisplay.getId();
			 authorize(req, portletId, RatingConstants.ACTION_RATING);
			 hasPermission = true;
		}catch(PrincipalException ex){
			
		}
		return hasPermission;
	}
	
}
