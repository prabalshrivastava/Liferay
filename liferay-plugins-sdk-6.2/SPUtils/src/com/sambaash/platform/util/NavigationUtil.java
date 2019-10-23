package com.sambaash.platform.util;

import java.util.HashMap;
import java.util.List;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.Layout;
import com.liferay.portal.theme.ThemeDisplay;
import com.sambaash.platform.systemmodelsetup.service.SystemLocalServiceUtil;

public class NavigationUtil {

	private static Log _log = LogFactoryUtil.getLog(NavigationUtil.class);

	public static HashMap<Long, List<Layout>> getNavigationLayouts(ThemeDisplay themeDisplay) {
		HashMap<Long, List<Layout>> map = SystemLocalServiceUtil.getUserLayoutsOne(themeDisplay);
		return map;
	}

	public static String sayHello() {
		return "hello";
	}

}
