package com.sambaash.platform.portlet.spevent.action;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.sambaash.platform.srv.rsvp.model.Rsvp;
import com.sambaash.platform.srv.rsvp.model.RsvpTicket;
import com.sambaash.platform.srv.rsvp.service.RsvpLocalServiceUtil;
import com.sambaash.platform.srv.rsvp.service.RsvpTicketLocalServiceUtil;
import com.sambaash.platform.util.SambaashUtil;

/**
 * Portlet implementation class SPRsvpTicketCreateAction
 */
public class SPRsvpTicketCreateAction extends MVCPortlet {

	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {

		_log.info("SPRsvpTicketCreateAction doView.....");
		boolean hasAccess = false;
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay)renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

			if (SambaashUtil.isAdmin(themeDisplay.getScopeGroupId(), themeDisplay.getUserId())
					|| SambaashUtil.isReportRole(themeDisplay.getScopeGroupId(), themeDisplay.getUserId())) {
				hasAccess = true;
			}

			if (hasAccess) {
				List<Rsvp> lstRsvp = RsvpLocalServiceUtil.getRsvps(0, RsvpLocalServiceUtil.getRsvpsCount());
				renderRequest.setAttribute("lstRsvp", lstRsvp);
			}

			renderRequest.setAttribute("hasAccess", hasAccess);
		} catch (Exception e) {
			_log.error(e.getMessage());
		}

		super.doView(renderRequest, renderResponse);
	}

	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException,
			PortletException {
		_log.info("++++SPRsvpTicketCreateAction serveResource+++++");
		String txtPrice = resourceRequest.getParameter("txtPrice");
		String txtQuantity = resourceRequest.getParameter("txtQuantity");
		String txtTicketSeq = resourceRequest.getParameter("txtTicketSeq");
		String txtSeqPrefix = resourceRequest.getParameter("txtSeqPrefix");
		String txtSeqPostfix = resourceRequest.getParameter("txtSeqPostfix");
		String txtTicketTemplateURL = resourceRequest.getParameter("txtTicketTemplateURL");
		String spRsvpId = resourceRequest.getParameter("spRsvpId");

		ThemeDisplay themeDisplay = (ThemeDisplay)resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);

		JSONObject ticketObj = JSONFactoryUtil.createJSONObject();
		boolean invalidFlag = true;

		try {
			if (!Validator.isNotNull(txtPrice)) {
				ticketObj.put("txtPrice", "Price should not be empty.");
				invalidFlag = false;
			} else if (!Validator.isNumber(txtPrice)) {
				ticketObj.put("txtPrice", "Price should be number only.");
				invalidFlag = false;
			}

			if (!Validator.isNotNull(txtQuantity)) {
				ticketObj.put("txtQuantity", "Ticket Quantity should not be empty.");
				invalidFlag = false;
			} else if (!Validator.isNumber(txtQuantity)) {
				ticketObj.put("txtQuantity", "Ticket Quantity should be number only.");
				invalidFlag = false;
			}

			if (!Validator.isNotNull(txtTicketSeq)) {
				ticketObj.put("txtTicketSeq", "Ticket Sequence should not be empty.");
				invalidFlag = false;
			} else if (!Validator.isNumber(txtTicketSeq)) {
				ticketObj.put("txtTicketSeq", "Ticket Sequence should be number only.");
				invalidFlag = false;
			} else if (txtTicketSeq.length() > 12) {
				ticketObj.put("txtTicketSeq", "Ticket Sequence's length should not greater than 12.");
				invalidFlag = false;
			}

			if (!Validator.isNotNull(txtSeqPrefix)) {
				ticketObj.put("txtSeqPrefix", "Ticket Sequence Prefix should not be empty.");
				invalidFlag = false;
			} else if (Validator.isNumber(txtSeqPrefix)) {
				ticketObj.put("txtSeqPrefix", "Ticket Sequence Prefix should be alphabet character only.");
				invalidFlag = false;
			} else if (txtSeqPrefix.length() > 2) {
				ticketObj.put("txtSeqPrefix", "Ticket Sequence Prefix should not greater than 2.");
				invalidFlag = false;
			}

			if (Validator.isNotNull(txtSeqPostfix) && Validator.isNumber(txtSeqPostfix)) {
				ticketObj.put("txtSeqPostfix", "Ticket Sequence Suffix should be alphabet character only.");
				invalidFlag = false;
			} else if (txtSeqPostfix.length() > 2) {
				ticketObj.put("txtSeqPostfix", "Ticket Sequence Suffix should not greater than 2.");
				invalidFlag = false;
			}

			if (Validator.isNotNull(txtTicketTemplateURL)) {
				if (!Validator.isUrl(txtTicketTemplateURL)) {
					ticketObj.put("txtTicketTemplateURL", "Please input valid url.");
					invalidFlag = false;
				}
			}

			if (!invalidFlag) {
				ticketObj.put("saveFlag", "fail");

			} else {
				Calendar cal = Calendar.getInstance();
				long spRsvpTicketId = CounterLocalServiceUtil.increment("SPRsvpTicket.class");
				RsvpTicket spRsvpTicket = RsvpTicketLocalServiceUtil.createRsvpTicket(spRsvpTicketId);
				spRsvpTicket.setGroupId(themeDisplay.getScopeGroupId());
				spRsvpTicket.setPrice(Double.parseDouble(txtPrice));
				spRsvpTicket.setQuantity(Integer.parseInt(txtQuantity));
				spRsvpTicket.setTicketSequence(Integer.parseInt(txtTicketSeq));
				spRsvpTicket.setLastSequenceNumber(Integer.parseInt(txtTicketSeq));
				spRsvpTicket.setSequencePrefix(txtSeqPrefix);
				spRsvpTicket.setSequenceSuffix(txtSeqPostfix);
				spRsvpTicket.setTicketTemplateUrl(txtTicketTemplateURL);
				spRsvpTicket.setCreateDate(cal.getTime());
				spRsvpTicket.setUserId(themeDisplay.getUserId());
				spRsvpTicket.setRsvpId(Long.parseLong(spRsvpId));

				RsvpTicketLocalServiceUtil.updateRsvpTicket(spRsvpTicket);

				ticketObj.put("saveFlag", "success");
			}

		} catch (Exception e) {
			_log.error(e.getMessage());
			ticketObj.put("saveFlag", "fail");
		}

		resourceResponse.getWriter().write(ticketObj.toString());
	} 

	private static Log _log = LogFactoryUtil.getLog(SPRsvpTicketCreateAction.class);

}