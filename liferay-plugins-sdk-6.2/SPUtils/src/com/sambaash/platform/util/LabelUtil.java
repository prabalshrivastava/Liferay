package com.sambaash.platform.util;

import java.util.Locale;

import javax.portlet.PortletConfig;
import javax.servlet.jsp.PageContext;

import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.theme.ThemeDisplay;

public class LabelUtil {

	public static String getLabel(PageContext pageContext, ThemeDisplay themeDisplay,
			String key) {

		// by groupId
		String prefixedLabelKey = getGroupLabelKey(themeDisplay.getScopeGroupId(), key);
		String label = getLabelByKey(pageContext, prefixedLabelKey);
		
		if (label.equals(prefixedLabelKey)) {
			// then by community name
			prefixedLabelKey = getCommunityLabelKey(themeDisplay.getScopeGroupId(), key);
			label = getLabelByKey(pageContext, prefixedLabelKey);
			if (label.equals(prefixedLabelKey)) {
				// then by default label
				label = getLabelByKey(pageContext, key);
			}
		}
		return label;
		
	}
	
	public static String getLabel(PortletConfig portletConfig,Locale locale, ThemeDisplay themeDisplay,
			String key) {
		// by groupId
		String prefixedLabelKey = getGroupLabelKey(themeDisplay.getScopeGroupId(), key);
		String label = getLabelByKey(portletConfig, locale, prefixedLabelKey);
		
		if (label.equals(prefixedLabelKey)) {
			// then by community name
			prefixedLabelKey = getCommunityLabelKey(themeDisplay.getScopeGroupId(), key);
			label = getLabelByKey(portletConfig, locale, prefixedLabelKey);
			if (label.equals(prefixedLabelKey)) {
				// then by default label
				label = getLabelByKey(portletConfig, locale, key);
			}
		}
		return label;

	}

	public static String getLabel(PortletConfig portletConfig,ThemeDisplay themeDisplay,
			String key) {

		return getLabel(portletConfig, themeDisplay.getLocale(), themeDisplay, key);

	}

	private static String getLabelByKey(PageContext pageContext, String labelKey) {
		return LanguageUtil.get(pageContext, labelKey);
	}

	private static String getLabelByKey(PortletConfig portletConfig, Locale locale, String labelKey) {
		return LanguageUtil.get(portletConfig,locale, labelKey);
	}

	private static String getGroupLabelKey(long groupId, String labelKey) {
		return String.format("%d.%s",groupId,labelKey);
	}
	
	private static String getCommunityLabelKey(long groupId, String labelKey) {
		String communityName = SambaashUtil.getCommunityName(groupId);
		return String.format("%s.%s",communityName,labelKey);
	}
}