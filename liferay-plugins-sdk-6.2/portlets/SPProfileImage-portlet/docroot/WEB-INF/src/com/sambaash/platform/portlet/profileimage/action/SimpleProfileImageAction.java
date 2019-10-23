package com.sambaash.platform.portlet.profileimage.action;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portal.webserver.WebServerServletTokenUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException;
import com.sambaash.platform.util.SambaashUtil;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * Portlet implementation class SimpleProfileImageAction
 */
public class SimpleProfileImageAction extends MVCPortlet {

	@Override
	public void doEdit(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay)renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		try {
			PortletPreferences preferences = renderRequest.getPreferences();
			String editable = preferences.getValue("editable", "false");
			String redirectPageName = preferences.getValue("redirectPageName", StringPool.BLANK);

			renderRequest.setAttribute("editable", editable);
			renderRequest.setAttribute("redirectPageName", redirectPageName);

		}catch (Exception e) {
			_log.error(e.getMessage(), e);
		}

		super.doEdit(renderRequest, renderResponse);
	}

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay)renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		try {
			long remoteUserId = themeDisplay.getUserId();
		String friendlyURL = themeDisplay.getURLCurrent();
		long companyId = themeDisplay.getCompanyId();
		//long profileUserId = SambaashUtil.getUserIdByScreenName(companyId, friendlyURL);
		HttpServletRequest httpRequest = PortalUtil
				.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest));
		String screenNameParam = httpRequest.getParameter("user");
		long profileUserId = 0;
		
		try{
			profileUserId = UserLocalServiceUtil.getUserIdByScreenName(themeDisplay.getCompanyId(), screenNameParam);
		} catch (Exception e) {
			_log.error(e.getMessage());
		}


		if (profileUserId == 0) {
		profileUserId = remoteUserId;
		}

		User profileUser = UserLocalServiceUtil.getUser(profileUserId);
			long portraitId = profileUser.getPortraitId();
			String portraitIdToken = WebServerServletTokenUtil.getToken(portraitId);

			renderRequest.setAttribute("portraitId", portraitId);
			renderRequest.setAttribute("portraitIdToken", portraitIdToken);

			PortletPreferences preferences = renderRequest.getPreferences();
			String editable = preferences.getValue("editable", "false");
			String redirectPageName = preferences.getValue("redirectPageName", StringPool.BLANK);

			renderRequest.setAttribute("editable", editable);
			renderRequest.setAttribute("redirectPageName", redirectPageName);

		}catch (Exception e) {
			_log.error(e.getMessage(), e);
		}

		super.doView(renderRequest, renderResponse);
	}

	@Override
	public void processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		try {
			String action = actionRequest.getParameter("action");

			if (Constants.EDIT.equalsIgnoreCase(action)) {
				PortletPreferences preferences = actionRequest.getPreferences();

				String editable = actionRequest.getParameter("editable");
				String redirectPageName = actionRequest.getParameter("redirectPageName");

				preferences.setValue("editable", editable);
				preferences.setValue("redirectPageName", redirectPageName);

				preferences.store();
				actionResponse.setPortletMode(PortletMode.VIEW);
			}
		}catch (Exception e) {
			_log.error(e.getMessage(), e);
		}

		super.processAction(actionRequest, actionResponse);
	}

	private static Log _log = LogFactoryUtil.getLog(SimpleProfileImageAction.class);

}