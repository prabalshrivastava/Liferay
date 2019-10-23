package com.sambaash.platform.portlet.votingncomment.util;

import com.liferay.portal.kernel.util.CharPool;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.blogs.NoSuchEntryException;
import com.liferay.portlet.blogs.model.BlogsEntry;
import com.liferay.portlet.blogs.service.BlogsEntryServiceUtil;

import javax.portlet.PortletRequest;

import javax.servlet.http.HttpServletRequest;
public class ActionUtil {
	
	public static BlogsEntry getEntry(HttpServletRequest request, String urlTitle) throws Exception {
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		BlogsEntry entry = null;

		if (Validator.isNotNull(urlTitle)) {
			try {
				entry = BlogsEntryServiceUtil.getEntry(themeDisplay.getScopeGroupId(), urlTitle);
			} catch (NoSuchEntryException nsee) {
				if (urlTitle.indexOf(CharPool.UNDERLINE) != -1) {

					// Check another URL title for backwards compatibility. See
					// LEP-5733.

					urlTitle = StringUtil.replace(urlTitle, CharPool.UNDERLINE, CharPool.DASH);

					entry = BlogsEntryServiceUtil.getEntry(themeDisplay.getScopeGroupId(), urlTitle);
				} else {
					throw nsee;
				}
			}
		}

		return entry;
	}

	public static BlogsEntry getEntry(HttpServletRequest request) throws Exception {
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

		long entryId = ParamUtil.getLong(request, "entryId");

		String urlTitle = ParamUtil.getString(request, "urlTitle");

		BlogsEntry entry = null;

		if (entryId > 0) {
			entry = BlogsEntryServiceUtil.getEntry(entryId);
		} else if (Validator.isNotNull(urlTitle)) {
			try {
				entry = BlogsEntryServiceUtil.getEntry(themeDisplay.getScopeGroupId(), urlTitle);
			} catch (NoSuchEntryException nsee) {
				if (urlTitle.indexOf(CharPool.UNDERLINE) != -1) {

					// Check another URL title for backwards compatibility. See
					// LEP-5733.

					urlTitle = StringUtil.replace(urlTitle, CharPool.UNDERLINE, CharPool.DASH);

					entry = BlogsEntryServiceUtil.getEntry(themeDisplay.getScopeGroupId(), urlTitle);
				} else {
					throw nsee;
				}
			}
		}

		return entry;
	}

	public static BlogsEntry getEntry(PortletRequest portletRequest, String urlTitle) throws Exception {

		HttpServletRequest request = PortalUtil.getHttpServletRequest(portletRequest);

		return getEntry(request, urlTitle);
	}

	public static BlogsEntry getEntry(PortletRequest portletRequest) throws Exception {

		HttpServletRequest request = PortalUtil.getHttpServletRequest(portletRequest);

		return getEntry(request);
	}

}
