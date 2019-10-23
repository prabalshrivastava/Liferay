package com.sambaash.platform.portlet.spevent.action;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;

import com.sambaash.platform.srv.rsvp.model.Rsvp;
import com.sambaash.platform.srv.rsvp.model.RsvpTicket;
import com.sambaash.platform.srv.rsvp.service.RsvpLocalServiceUtil;
import com.sambaash.platform.srv.rsvp.service.RsvpTicketLocalServiceUtil;
import com.sambaash.platform.util.SambaashUtil;

import java.io.IOException;

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

/**
 * Portlet implementation class SPRsvpTicketListingAction
 */
public class SPRsvpTicketListingAction extends MVCPortlet {

	@Override
	public void doEdit(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		try {
			PortletPreferences preferences = renderRequest.getPreferences();
			String pageName = preferences.getValue("pageName", StringPool.BLANK);

			renderRequest.setAttribute("pageName", pageName);
		} catch (Exception e) {
		}

		super.doEdit(renderRequest, renderResponse);
	}

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		_log.info("---- SPRsvpTicketAction doView ------");
		ThemeDisplay themeDisplay = (ThemeDisplay)renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		boolean hasAccess = false;
		try {
			if (SambaashUtil.isAdmin(themeDisplay.getScopeGroupId(), themeDisplay.getUserId())
					|| SambaashUtil.isReportRole(themeDisplay.getScopeGroupId(), themeDisplay.getUserId())) {
				hasAccess = true;
			}

			List<Rsvp> lstRsvp = RsvpLocalServiceUtil.getRsvps(0, RsvpLocalServiceUtil.getRsvpsCount());
			renderRequest.setAttribute("lstRsvp", lstRsvp);

			PortletPreferences preferences = renderRequest.getPreferences();
			renderRequest.setAttribute("createPageName", preferences.getValue("pageName", StringPool.BLANK));
			renderRequest.setAttribute("hasAccess", hasAccess);

		} catch (Exception e) {
			_log.error(e.getMessage());
		}

		super.doView(renderRequest, renderResponse);
	}

	@Override
	public void processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException,
			PortletException {

		String action = actionRequest.getParameter("action");
		PortletPreferences preferences = actionRequest.getPreferences();

		if ("editPreferences".equalsIgnoreCase(action)) {
			String pageName = actionRequest.getParameter("pageName");
			preferences.setValue("pageName", pageName);
			preferences.store();

			actionResponse.setPortletMode(PortletMode.VIEW);
		}
	}

	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException,
			PortletException {
		String action = resourceRequest.getParameter("action");

		if ("loadTickets".equalsIgnoreCase(action)) {
			String spRsvpId = resourceRequest.getParameter("spRsvpId");
			JSONObject lstObjectObject = JSONFactoryUtil.createJSONObject();

			if (Validator.isNotNull(spRsvpId)) {
				try {
					if (Validator.isNotNull(spRsvpId)) {
						List<RsvpTicket> lstSPRsvpTicket = RsvpTicketLocalServiceUtil.findByrsvpId(Long
								.parseLong(spRsvpId));

						for (RsvpTicket sp : lstSPRsvpTicket) {
							JSONObject spRsvpTicketObj = JSONFactoryUtil.createJSONObject();
							spRsvpTicketObj.put("price", sp.getPrice());
							spRsvpTicketObj.put("quantity", sp.getQuantity());
							spRsvpTicketObj.put("soldquantity", sp.getSoldQuantity());
							String startingticket = sp.getSequencePrefix() + (sp.getTicketSequence()) +
									sp.getSequenceSuffix();
							String currentticket = sp.getSequencePrefix() + (sp.getLastSequenceNumber()) +
									sp.getSequenceSuffix();
							spRsvpTicketObj.put("startingticket", startingticket);
							spRsvpTicketObj.put("currentticket", currentticket);
							spRsvpTicketObj.put("createdBy", UserLocalServiceUtil.getUser(sp.getUserId())
									.getFullName());
							spRsvpTicketObj.put("createDate", sp.getCreateDate());

							if (Validator.isNotNull(sp.getModifiedBy())) {
								spRsvpTicketObj.put("modifiedBy", UserLocalServiceUtil.getUser(sp.getModifiedBy())
										.getFullName());
							} else {
								spRsvpTicketObj.put("modifiedBy", "");
							}

							spRsvpTicketObj.put("modifiedDate", sp.getModifiedDate());
							lstObjectObject.put(String.valueOf(sp.getRsvpTicketId()), spRsvpTicketObj);
						}
					}
				} catch (Exception e) {
					_log.error(e.getMessage());
				}
			}

			resourceResponse.getWriter().write(lstObjectObject.toString());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(SPRsvpTicketListingAction.class);

}