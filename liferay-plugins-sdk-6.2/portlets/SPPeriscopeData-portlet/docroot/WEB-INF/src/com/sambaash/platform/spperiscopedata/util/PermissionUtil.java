package com.sambaash.platform.spperiscopedata.util;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletPreferences;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.Role;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.sambaash.platform.spperiscopedata.SPPeriscopeDataConstant;
import com.sambaash.platform.util.SambaashUtil;

public class PermissionUtil {
	private static Log logger = LogFactoryUtil.getLog(PermissionUtil.class);
	
	public static String getPermittedNavConfig(ThemeDisplay themeDisplay, PortletPreferences portletPreferences) {
		String navConfigStr = portletPreferences.getValue(SPPeriscopeDataConstant.NAV_CONFIG, "{}");
		if (SambaashUtil.isAdmin(themeDisplay.getScopeGroupId(), themeDisplay.getUserId())) {
			return navConfigStr;
		}
		JSONObject updatedConfig = JSONFactoryUtil.createJSONObject();
		try {
			JSONObject configObj = JSONFactoryUtil.createJSONObject(navConfigStr);
			debugIfOn("configObj = " + configObj);
			updatedConfig.put("navTitle", configObj.getString("navTitle"));
			if(configObj.has("menus") && configObj.getJSONArray("menus").length()>0) {
				JSONArray updatedMenuArr = updateMenus(getUserRoleNames(themeDisplay.getUserId()), configObj);
				updatedConfig.put("menus", updatedMenuArr);
			}			
		} catch (Exception e) {
			logger.error(e);
			debugIfOn("error processing nav config = " + navConfigStr);
		}
		debugIfOn("Final nav config = " + updatedConfig);
		return updatedConfig.toString();
	}
	
	private static void debugIfOn(String debugMessage) {
		if (logger.isDebugEnabled()) {
			logger.debug(debugMessage);
		}
	}
	
	private static List<String> getUserRoleNames(long userId) {
		List<String> retList = new ArrayList<String>();
		try {
			for(Role r: RoleLocalServiceUtil.getUserRoles(userId)) {
				retList.add(r.getName().toLowerCase());
			}
		} catch (Exception e) {
			debugIfOn(e.toString());
		}
		return retList;
	}

	private static JSONArray updateMenus(List<String> userRoles, JSONObject configObj) {
		JSONArray menuArr = configObj.getJSONArray("menus");
		JSONArray updatedMenuArr = JSONFactoryUtil.createJSONArray();
		for (int i=0; i<menuArr.length(); i++) {
			JSONObject menuObj = menuArr.getJSONObject(i);
			JSONObject updatedMenuObj = JSONFactoryUtil.createJSONObject();
			updatedMenuObj.put("menuName", menuObj.getString("menuName"));
			JSONArray menuItemsArr = menuObj.getJSONArray("menuItems");
			JSONArray updatedMenuItemsArr = JSONFactoryUtil.createJSONArray();
			for(int j=0; j < menuItemsArr.length(); j++) {
				JSONObject menuItemObj = menuItemsArr.getJSONObject(j);
				JSONArray subMenuItemsArr = menuItemObj.getJSONArray("subMenuItems");
				if (subMenuItemsArr.length()>0) {
					JSONArray updatedSubMenuItemsArr = JSONFactoryUtil.createJSONArray();
					for (int k=0; k<subMenuItemsArr.length(); k++) {
						JSONObject subMenuItemObj = subMenuItemsArr.getJSONObject(k);
						updateViewableMenuItems(userRoles, subMenuItemObj,
								updatedSubMenuItemsArr);
					}
					if (updatedSubMenuItemsArr.length()>0) {
						menuItemObj.put("subMenuItems", updatedSubMenuItemsArr);
						updatedMenuItemsArr.put(menuItemObj);	
					}
				} else {
					updateViewableMenuItems(userRoles, menuItemObj,
							updatedMenuItemsArr);
				}
			}
			if (updatedMenuItemsArr.length()>0) {
				updatedMenuObj.put("menuItems", updatedMenuItemsArr);
				updatedMenuArr.put(updatedMenuObj);
			}
		}
		return updatedMenuArr;
	}

	private static void updateViewableMenuItems(List<String> userRoles,
			JSONObject menuItemObj, JSONArray updatedMenuItemsArr) {
		if (menuItemObj.has("viewableBy")) {
			JSONArray viewableByArr = menuItemObj.getJSONArray("viewableBy");
			boolean viewOk = false;
			for (int n=0; n<viewableByArr.length(); n++) {
				if (userRoles.contains(viewableByArr.getString(n).toLowerCase())) {
					viewOk = true;
					break;
				}
			}
			if (viewOk) {
				updatedMenuItemsArr.put(menuItemObj);						
			}
		}
	}
}
