package com.sambaash.platform.util;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.sambaash.platform.constant.SambaashConstants;

public class OmnitureUtil {
	private static Log _log = LogFactoryUtil.getLog(OmnitureUtil.class);

	//
	/**
	 * @param currentUrl
	 * @param contentCategory
	 * @param pageType
	 * @param publishDate
	 * @param articleId
	 * @param articleTitle
	 * @return
	 */
	public static String getOmnitureTags(String currentUrl, String contentCategory, String pageType,
			String publishDate, String articleId, String articleTitle) {

		currentUrl = currentUrl.toLowerCase();
		contentCategory = contentCategory.toLowerCase();
		pageType = pageType.toLowerCase();
		articleTitle = articleTitle.toLowerCase();

		String result = StringPool.BLANK;
		if (SambaashUtil.isOmnitureEnabled()) {
			String content = StringPool.BLANK;
			if (SambaashConstants.PAGE_TYPE.LANDING_PAGE.equalsIgnoreCase(pageType)) {
				content = "home";
			} else {
				content = publishDate + StringPool.COLON + articleId + StringPool.UNDERLINE + articleTitle;
			}

			String omnitureConstant = SambaashUtil.getOmnitureConstant();
			StringBuilder omnitureTags = new StringBuilder();

			String heir = "s.hier1=\"{0}|" + contentCategory + StringPool.PIPE + currentUrl + StringPool.PIPE + content
					+ "\";";
			heir = heir.replace("{0}", omnitureConstant).replace(StringPool.COLON, StringPool.PIPE);
			heir = heir.toLowerCase();

			omnitureTags.append("s.prop8=\"").append(pageType).append("\";").append("s.prop70=\"{0}:")
					.append(contentCategory).append("\";").append("s.prop71=\"{0}:").append(contentCategory)
					.append(StringPool.COLON).append(currentUrl).append("\";").append("s.prop72=\"{0}:")
					.append(contentCategory).append(StringPool.COLON).append(currentUrl).append(StringPool.COLON)
					.append("{1}").append("\";").append("s.pageName=\"{0}:").append(contentCategory)
					.append(StringPool.COLON).append(currentUrl).append(StringPool.COLON).append("{1}").append("\";")
					.append(heir);
			result = omnitureTags.toString().replace("{0}", omnitureConstant).replace("{1}", content);
			_log.error("Omniture Tags : " + result);
		}

		return result;

	}
}
