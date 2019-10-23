package com.sambaash.platform.portlet.spblogs.util;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.CharPool;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.blogs.NoSuchEntryException;
import com.liferay.portlet.blogs.model.BlogsEntry;
import com.liferay.portlet.blogs.service.BlogsEntryServiceUtil;
import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.model.ExpandoColumnConstants;

import java.io.Serializable;

import javax.portlet.PortletRequest;
import javax.servlet.http.HttpServletRequest;
public class ActionUtil {

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
					_log.error("Can't find blog : entryId : " + entryId + " : urlTitle : " + urlTitle);
				}
			}
		}

		return entry;
	}

	public static BlogsEntry getEntry(PortletRequest portletRequest) throws Exception {

		HttpServletRequest request = PortalUtil.getHttpServletRequest(portletRequest);

		return getEntry(request);
	}

	public static String getAuthor(BlogsEntry blogsEntry) {

		String author = StringPool.BLANK;

		//Get display author from expando column
		ExpandoBridge expandoBridge = blogsEntry.getExpandoBridge();
		if (expandoBridge.hasAttribute(author) && Validator.isNotNull(expandoBridge.getAttribute(AUTHOR))) {
			int type = expandoBridge.getAttributeType(AUTHOR);
			if (type == ExpandoColumnConstants.STRING) {
				Serializable authorName = expandoBridge.getAttribute(AUTHOR);
				if (Validator.isNotNull(authorName)) {
					author = (String) authorName;
				}
			}
		}

		if (Validator.isNull(author)) {
			author = HtmlUtil.escape(PortalUtil.getUserName(blogsEntry.getUserId(), blogsEntry.getUserName()));
		}
		
		return author;

	}

	private final static String AUTHOR = "External-Author";

	private static Log _log = LogFactoryUtil.getLog(ActionUtil.class);

}
