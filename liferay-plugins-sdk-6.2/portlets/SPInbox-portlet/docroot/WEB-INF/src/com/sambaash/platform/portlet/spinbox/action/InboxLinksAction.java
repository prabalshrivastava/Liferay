package com.sambaash.platform.portlet.spinbox.action;

import java.io.IOException;

import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.sambaash.platform.portlet.spinbox.helper.InboxConstants;
import com.sambaash.platform.portlet.spinbox.helper.InboxRequestHelper;

/**
 * Portlet implementation class SPInboxLinksAction
 */
public class InboxLinksAction extends MVCPortlet {
 
	private static final Log logger = LogFactoryUtil.getLog(InboxLinksAction.class);
	
	private static String INBOX_URL = "inboxUrl";
	private static String INBOX_PAGE_NAME = "inboxPageName";
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		PortletPreferences prefs = renderRequest.getPreferences();
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		String pageName = prefs.getValue(INBOX_PAGE_NAME, "inbox");
		String url = themeDisplay.getPortalURL() + themeDisplay.getPathContext() + "/" + pageName;
		renderRequest.setAttribute(INBOX_URL, url);
		super.doView(renderRequest, renderResponse);
	}
	public void serveResource(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws IOException,
			PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		String action = ParamUtil.getString(resourceRequest, InboxConstants.ACTION);
		if ("unreadCounts".equalsIgnoreCase(action)) {
			try {
				JSONObject data = JSONFactoryUtil.createJSONObject();
				data.put("unreadObj", InboxRequestHelper.setUnreadCounts(themeDisplay.getUser(), themeDisplay.getScopeGroupId()));
				resourceResponse.getWriter().write(data.toString());
			} catch (Exception e) {
				logger.error(e);
			} 
		}
	}

}
