package com.sambaash.platform.portlet.spgroup.action;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Layout;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.PortletURLFactoryUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.sambaash.platform.model.SPGroupUserStatus;
import com.sambaash.platform.srv.spgroup.model.SPGroup;
import com.sambaash.platform.srv.spgroup.model.SPGroupUser;
import com.sambaash.platform.srv.spgroup.service.SPGroupLocalServiceUtil;
import com.sambaash.platform.srv.spgroup.service.SPGroupUserLocalServiceUtil;

/**
 * Portlet implementation class SPGroupMyGroupsAction
 */
public class SPGroupMyGroupsAction extends MVCPortlet {

	@Override
	public void doEdit(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		super.doEdit(renderRequest, renderResponse);
	}

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay)renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		if (themeDisplay.isSignedIn()) {
			try {
				long userId = themeDisplay.getUserId();

				int totalCount = SPGroupUserLocalServiceUtil.countByUserIdAndStatus(userId, SPGroupUserStatus.APPROVE.getValue());

				renderRequest.setAttribute("totalCount", totalCount);

			} catch (Exception e) {
				_log.error(e.getMessage(), e);
			}
		}

		super.doView(renderRequest, renderResponse);
	}

	@Override
	public void processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException,
			PortletException {
		PortletPreferences preferences = actionRequest.getPreferences();

		String action = ParamUtil.getString(actionRequest, "action");

		if (Constants.EDIT.equalsIgnoreCase(action)) {
			String groupDetailPageName = ParamUtil.getString(actionRequest, "groupDetailPageName");
			preferences.setValue("groupDetailPageName", groupDetailPageName);
			preferences.store();
		}

		super.processAction(actionRequest, actionResponse);
	}

	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException,
			PortletException {

		PortletPreferences preferences = resourceRequest.getPreferences();

		ThemeDisplay themeDisplay = (ThemeDisplay)resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);

		JSONObject dataJSONObject = JSONFactoryUtil.createJSONObject();
		JSONArray itemsJSONArray = JSONFactoryUtil.createJSONArray();

		if (themeDisplay.isSignedIn()) {
			try {
				long userId = themeDisplay.getUserId();

				String action = ParamUtil.getString(resourceRequest, "action");

				if ("retrieve".equalsIgnoreCase(action)) {

					String initTotalStr = resourceRequest.getParameter("init_total");
					String curShowingNoStr = resourceRequest.getParameter("cur_showing_no");
					String offsetStr = resourceRequest.getParameter("offset");

					int curShowingNo = 0;
					int initTotal = 0;
					int offset = 0;

					Date now = new Date();

					try {
						curShowingNo = Integer.valueOf(curShowingNoStr);
					} catch (NumberFormatException nfe) {
					}

					try {
						initTotal = Integer.valueOf(initTotalStr);
					} catch (NumberFormatException nfe) {
					}

					try {
						offset = Integer.valueOf(offsetStr);
					} catch (NumberFormatException nfe) {
					}

					int start = curShowingNo;

					int count = SPGroupUserLocalServiceUtil.countByUserIdAndStatus(userId, SPGroupUserStatus.APPROVE.getValue());

					// Catch this exception, we'll see ...

					int balance = 0;
					balance = count - initTotal;
					start += balance;

					String groupDetailPageName = preferences.getValue("groupDetailPageName", "group-detail");

					List<SPGroupUser> spGroupUsers = SPGroupUserLocalServiceUtil.findByUserIdAndStatus(userId, SPGroupUserStatus.APPROVE.getValue(), start, start + offset);

					for (SPGroupUser spGroupUser : spGroupUsers) {

						SPGroup spGroup = SPGroupLocalServiceUtil.getSPGroup(spGroupUser.getSpGroupId());

						String spGroupDetailURL = StringPool.BLANK;
						try {
							Layout spGroupDetailLayout = LayoutLocalServiceUtil.getFriendlyURLLayout(
									themeDisplay.getScopeGroupId(), false, "/" + groupDetailPageName);
							long spGroupDetailPlid = spGroupDetailLayout.getPlid();

							PortletURL spGroupDetailPortletURL = PortletURLFactoryUtil.create(resourceRequest,
									"SPGroupDetail_WAR_SPGroupportlet", spGroupDetailPlid, PortletRequest.RENDER_PHASE);
							spGroupDetailPortletURL.setWindowState(javax.portlet.WindowState.NORMAL);
							spGroupDetailPortletURL.setPortletMode(javax.portlet.PortletMode.VIEW);
							spGroupDetailPortletURL.setParameter("struts_action", "/groups/view_entry");
							spGroupDetailPortletURL.setParameter("urlTitle", spGroup.getUrlTitle());
							spGroupDetailPortletURL.setParameter("spGroupId", String.valueOf(spGroup.getSpGroupId()));
							spGroupDetailURL = spGroupDetailPortletURL.toString();
						} catch (com.liferay.portal.NoSuchLayoutException e) {

							// do nothing

						}

						String html = "" +
							"<li class=\"sp-group-mbm\">" +
								"<div class=\"sp-group-clearfix\">" +
									"<a href=\"\" class=\"sp-group-lfloat sp-group-mrm\">" +
										"<img alt=\"Group Image\" src=\"/image/image_gallery?img_id=" + spGroup.getImageId() + "&t=" + now.getTime() + "\" width=\"48\" height=\"48\" />" +
									"</a>" +
									"<div class=\"sp-group-ui-oh\">" +
										"<div class=\"sp-group-ui-dib\">" +
											"<div class=\"sp-group-ui-dib sp-group-ui-vam\" style=\"height:48px;\"></div><div class=\"sp-group-ui-dib sp-group-ui-vam\">" +
												"<p class=\"sp-group-fsm sp-group-mbs\"><a href=\"" + spGroupDetailURL.toString() + "\">" + spGroup.getTitle() + "</a></p>" +
												"<p>" + StringUtil.shorten(spGroup.getDescription(), 200, "...") + "</p>" +
											"</div>" +
										"</div>" +
									"</div>" +
								"</div>" +
							"</li>";

						JSONObject htmlJSONObject = JSONFactoryUtil.createJSONObject();
						htmlJSONObject.put("html", html);
						itemsJSONArray.put(htmlJSONObject);

					}

				}

			} catch (Exception e) {
				_log.error(e.getMessage(), e);
			}
		}

		dataJSONObject.put("items", itemsJSONArray);

		resourceResponse.setContentType("application/json");
		resourceResponse.setCharacterEncoding("utf-8");
		resourceResponse.getWriter().write(dataJSONObject.toString());

		super.serveResource(resourceRequest, resourceResponse);

	}

	private static Log _log = LogFactoryUtil.getLog(SPGroupMyGroupsAction.class);

}
