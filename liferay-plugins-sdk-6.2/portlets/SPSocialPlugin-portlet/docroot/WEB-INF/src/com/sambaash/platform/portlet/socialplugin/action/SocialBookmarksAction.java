package com.sambaash.platform.portlet.socialplugin.action;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.sambaash.platform.constant.SambaashConstants;
import com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException;
import com.sambaash.platform.srv.spsocialprofile.model.SocialProfile;
import com.sambaash.platform.srv.spsocialprofile.service.SocialProfileLocalServiceUtil;
import com.sambaash.platform.util.SambaashUtil;

/**
 * Portlet implementation class SocialBookmarksAction
 */
public class SocialBookmarksAction extends MVCPortlet {

	@Override
	public void doEdit(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		PortletPreferences prefs = renderRequest.getPreferences();
		String socialBookmarksDisplayStyle = prefs.getValue(
				"socialBookmarksDisplayStyle", StringPool.FALSE);// show by
																	// default
		String socialBookmarksDisplayPosition = prefs.getValue(
				"socialBookmarksDisplayPosition", "horizontal");

		String isStatic = prefs.getValue("isStatic", StringPool.FALSE);
		String pageTitle = prefs.getValue("pageTitle", StringPool.BLANK);
		String pageSubtitle = prefs.getValue("pageSubtitle", StringPool.BLANK);
		String pageDescription = prefs.getValue("pageDescription",
				StringPool.BLANK);
		String ogImage = prefs.getValue("ogImage", StringPool.BLANK);
		String ogAudio = prefs.getValue("ogAudio", StringPool.BLANK);
		String ogUrl = prefs.getValue("ogUrl", StringPool.BLANK);
		String ogType = prefs.getValue("ogType", StringPool.BLANK);
		String ogTitle = prefs.getValue("ogTitle", StringPool.BLANK);
		String ogDescription = prefs
				.getValue("ogDescription", StringPool.BLANK);
		String ogSiteName = prefs.getValue("ogSiteName", StringPool.BLANK);
		String ogVideo = prefs.getValue("ogVideo", StringPool.BLANK);
		String title = prefs.getValue("title", StringPool.BLANK);
		String bookmarkUrl = prefs.getValue("bookmarkUrl", StringPool.BLANK);

		renderRequest.setAttribute("displayPosition",
				socialBookmarksDisplayPosition);
		renderRequest.setAttribute("displayStyle", socialBookmarksDisplayStyle);

		renderRequest.setAttribute("isStatic", isStatic);
		renderRequest.setAttribute("pageTitle", pageTitle);
		renderRequest.setAttribute("pageSubtitle", pageSubtitle);
		renderRequest.setAttribute("pageDescription", pageDescription);
		renderRequest.setAttribute("ogImage", ogImage);
		renderRequest.setAttribute("ogAudio", ogAudio);
		renderRequest.setAttribute("ogUrl", ogUrl);
		renderRequest.setAttribute("ogType", ogType);
		renderRequest.setAttribute("ogTitle", ogTitle);
		renderRequest.setAttribute("ogDescription", ogDescription);
		renderRequest.setAttribute("ogSiteName", ogSiteName);
		renderRequest.setAttribute("ogVideo", ogVideo);
		renderRequest.setAttribute("title", title);
		renderRequest.setAttribute("bookmarkUrl", bookmarkUrl);

		include(editTemplate, renderRequest, renderResponse);
	}

	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest
				.getAttribute(WebKeys.THEME_DISPLAY);

		PortletPreferences preferences = renderRequest.getPreferences();
		String socialBookmarksDisplayStyle = preferences.getValue(
				"socialBookmarksDisplayStyle", StringPool.FALSE);
		String socialBookmarksDisplayPosition = preferences.getValue(
				"socialBookmarksDisplayPosition", "horizontal");

		String isStatic = preferences.getValue("isStatic", StringPool.FALSE);
		String ogImage = preferences.getValue("ogImage", StringPool.BLANK);
		String ogAudio = preferences.getValue("ogAudio", StringPool.BLANK);
		String ogUrl = preferences.getValue("ogUrl", StringPool.BLANK);
		String ogType = preferences.getValue("ogType", StringPool.BLANK);
		String ogTitle = preferences.getValue("ogTitle", StringPool.BLANK);
		String ogDescription = preferences.getValue("ogDescription",
				StringPool.BLANK);
		String ogSiteName = preferences
				.getValue("ogSiteName", StringPool.BLANK);
		String ogVideo = preferences.getValue("ogVideo", StringPool.BLANK);
		String title = preferences.getValue("title", StringPool.BLANK);
		String bookmarkUrl = preferences.getValue("bookmarkUrl",
				StringPool.BLANK);

		HttpServletRequest httpRequest = PortalUtil
				.getOriginalServletRequest(PortalUtil
						.getHttpServletRequest(renderRequest));
		String currentUrl = PortalUtil.getCurrentURL(httpRequest);
		String screenName = themeDisplay.getUser().getScreenName();
		long remoteUserId = themeDisplay.getUserId();
		long userProfileId = remoteUserId;
		SocialProfile socialProfile = null;
		User user = null;
		long companyId = themeDisplay.getCompanyId();

		try {
			if (!currentUrl.endsWith(screenName)) {
				userProfileId = SambaashUtil.getUserIdByScreenName(companyId,
						currentUrl);

				if (Validator.isNull(userProfileId)) {
					userProfileId = remoteUserId;
				}
			}

			socialProfile = SocialProfileLocalServiceUtil
					.getSocialProfile(userProfileId);
		} catch (NoSuchSocialProfileException e) {
			_log.error("No such social profile existing with primary key: "
					+ userProfileId);
		} catch (Exception e) {
			_log.error(e.getMessage());
		}

		if (Validator.isNotNull(socialProfile)) {
			try {
				user = UserLocalServiceUtil.getUser(socialProfile.getUserId());

				String siteURL = PortalUtil.getPortalURL(httpRequest);
				String portraitURL = SambaashUtil.getProfileImageURL(siteURL
						+ "/image", user);
				String profileURL = siteURL + StringPool.SLASH
						+ user.getScreenName();

				if (StringPool.TRUE.equalsIgnoreCase(isStatic)) {
					SambaashUtil.setOGImage(ogImage, httpRequest);
					SambaashUtil.setOGAudio(ogAudio, httpRequest);
					SambaashUtil.setOGUrl(ogUrl, httpRequest);
					SambaashUtil.setOGType(ogType, httpRequest);
					SambaashUtil.setOGTitle(ogTitle, httpRequest);
					SambaashUtil.setOGDescription(ogDescription, httpRequest);
					SambaashUtil.setOGSiteName(ogSiteName, httpRequest);
					SambaashUtil.setOGVideo(ogVideo, httpRequest);

					renderRequest.setAttribute("title", title);
					renderRequest.setAttribute("bookmarkUrl", bookmarkUrl);

				} else {
					SambaashUtil.setOGTitle(socialProfile.getTitle(),
							httpRequest);
					SambaashUtil.setOGType(SambaashConstants.FB_TYPES.PROFILE,
							httpRequest);
					SambaashUtil.setOGImage(portraitURL, httpRequest);
					SambaashUtil.setOGUrl(profileURL, httpRequest);
					SambaashUtil.setOGSiteName(siteURL, httpRequest);
					renderRequest.setAttribute("title",
							socialProfile.getTitle());
					renderRequest.setAttribute("bookmarkUrl", profileURL);
				}

				renderRequest.setAttribute("socialBookmarksDisplayStyle",
						socialBookmarksDisplayStyle);
				renderRequest.setAttribute("socialBookmarksDisplayPosition",
						socialBookmarksDisplayPosition);

			} catch (Exception e) {
				_log.error("No such user exist with primary key: "
						+ userProfileId);
			}
		}

		include(viewTemplate, renderRequest, renderResponse);
	}

	@Override
	public void processAction(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {

		PortletPreferences prefs = actionRequest.getPreferences();
		String action = actionRequest.getParameter("action");

		if ("editFormSubmit".equalsIgnoreCase(action)) {
			String displayStyle = actionRequest.getParameter("displayStyle");
			String displayPosition = actionRequest
					.getParameter("displayPosition");

			String isStatic = actionRequest.getParameter("isStatic");
			String pageTitle = actionRequest.getParameter("pageTitle");
			String pageSubtitle = actionRequest.getParameter("pageSubtitle");
			String pageDescription = actionRequest
					.getParameter("pageDescription");
			String ogImage = actionRequest.getParameter("ogImage");
			String ogAudio = actionRequest.getParameter("ogAudio");
			String ogUrl = actionRequest.getParameter("ogUrl");
			String ogType = actionRequest.getParameter("ogType");
			String ogTitle = actionRequest.getParameter("ogTitle");
			String ogDescription = actionRequest.getParameter("ogDescription");
			String ogSiteName = actionRequest.getParameter("ogSiteName");
			String ogVideo = actionRequest.getParameter("ogVideo");
			String title = actionRequest.getParameter("title");
			String bookmarkUrl = actionRequest.getParameter("bookmarkUrl");

			if (Validator.isNotNull(displayStyle)) {
				prefs.setValue("socialBookmarksDisplayStyle", displayStyle); // hide
																				// bookmarks
																				// toolbar
			} else {
				prefs.setValue("socialBookmarksDisplayStyle", StringPool.FALSE);// display
																				// by
																				// default
			}

			if (Validator.isNotNull(displayPosition)) {
				prefs.setValue("socialBookmarksDisplayPosition",
						displayPosition);
			} else {
				prefs.setValue("socialBookmarksDisplayPosition", "horizontal");
			}

			if (Validator.isNotNull(isStatic)) {
				prefs.setValue("isStatic", isStatic);
			} else {
				prefs.setValue("isStatic", StringPool.FALSE);
			}

			if (Validator.isNotNull(pageTitle)) {
				prefs.setValue("pageTitle", pageTitle);
			} else {
				prefs.setValue("pageTitle", StringPool.BLANK);
			}

			if (Validator.isNotNull(pageSubtitle)) {
				prefs.setValue("pageSubtitle", pageSubtitle);
			} else {
				prefs.setValue("pageSubtitle", StringPool.BLANK);
			}

			if (Validator.isNotNull(pageDescription)) {
				prefs.setValue("pageDescription", pageDescription);
			} else {
				prefs.setValue("pageDescription", StringPool.BLANK);
			}

			if (Validator.isNotNull(ogImage)) {
				prefs.setValue("ogImage", ogImage);
			} else {
				prefs.setValue("ogImage", StringPool.BLANK);
			}

			if (Validator.isNotNull(ogAudio)) {
				prefs.setValue("ogAudio", ogAudio);
			} else {
				prefs.setValue("ogAudio", StringPool.BLANK);
			}

			if (Validator.isNotNull(ogUrl)) {
				prefs.setValue("ogUrl", ogUrl);
			} else {
				prefs.setValue("ogUrl", StringPool.BLANK);
			}

			if (Validator.isNotNull(ogType)) {
				prefs.setValue("ogType", ogType);
			} else {
				prefs.setValue("ogType", StringPool.BLANK);
			}

			if (Validator.isNotNull(ogTitle)) {
				prefs.setValue("ogTitle", ogTitle);
			} else {
				prefs.setValue("ogTitle", StringPool.BLANK);
			}

			if (Validator.isNotNull(ogDescription)) {
				prefs.setValue("ogDescription", ogDescription);
			} else {
				prefs.setValue("ogDescription", StringPool.BLANK);
			}

			if (Validator.isNotNull(ogSiteName)) {
				prefs.setValue("ogSiteName", ogSiteName);
			} else {
				prefs.setValue("ogSiteName", StringPool.BLANK);
			}

			if (Validator.isNotNull(ogVideo)) {
				prefs.setValue("ogVideo", ogVideo);
			} else {
				prefs.setValue("ogVideo", StringPool.BLANK);
			}

			if (Validator.isNotNull(title)) {
				prefs.setValue("title", title);
			} else {
				prefs.setValue("title", StringPool.BLANK);
			}

			if (Validator.isNotNull(bookmarkUrl)) {
				prefs.setValue("bookmarkUrl", bookmarkUrl);
			} else {
				prefs.setValue("bookmarkUrl", StringPool.BLANK);
			}

			actionResponse.setPortletMode(PortletMode.VIEW);
			prefs.store();
		}
	}

	private static Log _log = LogFactoryUtil
			.getLog(SocialBookmarksAction.class);

}