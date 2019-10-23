package com.sambaash.platform.util;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;

public class CommunityUtil {

	private static String GROUP_DETAIL_PAGE_NAME = "group.detail.page.url";

	public static final String GROUP_DETAIL_ID = "groupId";

	private static String defaultCommunityName = PropsUtil.get(PropsKeys.VIRTUAL_HOSTS_DEFAULT_SITE_NAME);

	private static String groupDetailPageName = PropsUtil.get(GROUP_DETAIL_PAGE_NAME);

	@Deprecated
	/** Use SambaashUtil.getCommunityName(long scopeGroupId) instead**/
	public static String getCommunityName() {

		return defaultCommunityName;
	}

	public static String getGroupDetailPageName() {

		return groupDetailPageName;
	}

	public static String getPortalURL(ThemeDisplay themeDisplay) throws PortalException, SystemException {

		String portalURL = PortalUtil.getPortalURL(themeDisplay);
		return portalURL;
	}

	public static String getViewGroupDetailURL(String groupId, ThemeDisplay themeDisplay) throws PortalException,
			SystemException {

		return getPortalURL(themeDisplay) + "/web/" + SambaashUtil.getCommunityName(themeDisplay.getScopeGroupId())
				+ "/" + getGroupDetailPageName() + "?" + GROUP_DETAIL_ID + "=" + groupId;
	}

}