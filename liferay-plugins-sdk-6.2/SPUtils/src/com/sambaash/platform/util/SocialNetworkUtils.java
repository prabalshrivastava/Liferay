
package com.sambaash.platform.util;

import javax.portlet.PortletRequest;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.sambaash.platform.util.SambaashUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public class SocialNetworkUtils {
	
	private static Log _log = LogFactoryUtil.getLog(SocialNetworkUtils.class);

	public static final String TWITTER_TYPE_SUMMARY = "summary";

	public static final String TWITTER_TYPE_SUMMARY_LARGE_IMAGE = "summary_large_image";

	public static void addSocialShareAttributes(PortletRequest request,
			String title, String description, String friendlyUrl, String type,
			String twitterCardType, long imageEntryId) {
		ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);
		if (themeDisplay == null)
			return;
		String siteName = "";
		try {
			siteName = GroupLocalServiceUtil.getGroup(
					themeDisplay.getScopeGroupId()).getDescription();
		} catch (Exception e) {
			_log.error(e.getMessage());
		}
		String imageUrl = SambaashUtil.getDLFileIconUrl(request, imageEntryId);
		SambaashUtil.setOGTitle(title, themeDisplay.getRequest());
		SambaashUtil.setOGUrl(friendlyUrl, themeDisplay.getRequest());
		SambaashUtil.setOGDescription(description, themeDisplay.getRequest());
		SambaashUtil.setOGType(type, themeDisplay.getRequest());
		SambaashUtil.setOGImage(imageUrl, themeDisplay.getRequest());
		SambaashUtil.setOGSiteName(siteName, themeDisplay.getRequest());
		SambaashUtil.setTwitterImage(imageUrl, themeDisplay.getRequest());
		SambaashUtil.setTwitterCard(twitterCardType, themeDisplay.getRequest());
		SambaashUtil.setTwitterDescription(description,
				themeDisplay.getRequest());
		SambaashUtil.setTwitterSite(siteName, themeDisplay.getRequest());
		SambaashUtil.setTwitterUrl(friendlyUrl, themeDisplay.getRequest());
		SambaashUtil.setTwitterTitle(title, themeDisplay.getRequest());
	}

	public static String generateFacebookShareUrl(String urlToShare) {
		return getFBShareUrlPrefix() + urlToShare;
	}

	public static String generateTwitterShareUrl(String urlToShare) {
		
		return getTwitterShareUrlPrefix() + urlToShare;
	}

	public static String generateGooglePlusShareUrl(String urlToShare) {
		
		return getGooglePlusShareUrlPrefix() + urlToShare;
	}

	public static String generateLinkedInShareUrl(String urlToShare) {
		
		return getLinkedInShareUrlPrefix() + urlToShare;
	}
	
	public static String getFBShareUrlPrefix(){
		String prefix = SambaashUtil.getParameter("fb.share.url", 0);
		if (Validator.isNull(prefix))
			prefix = "https://www.facebook.com/sharer/sharer.php?u=";
		return prefix;
	}
	
	public static String getTwitterShareUrlPrefix() {
		String prefix = SambaashUtil.getParameter("twitter.share.url", 0);
		if (Validator.isNull(prefix))
			prefix = "https://twitter.com/intent/tweet?url=";
		return prefix;
	}

	public static String getGooglePlusShareUrlPrefix() {
		String prefix = SambaashUtil.getParameter("gplus.share.url", 0);
		if (Validator.isNull(prefix))
			prefix = "https://plus.google.com/share?url=";
		return prefix;
	}

	public static String getLinkedInShareUrlPrefix() {
		String prefix = SambaashUtil.getParameter("linkedin.share.url", 0);
		if (Validator.isNull(prefix))
			prefix = "https://www.linkedin.com/shareArticle?mini=true&url=";
		return prefix;
	}
}
