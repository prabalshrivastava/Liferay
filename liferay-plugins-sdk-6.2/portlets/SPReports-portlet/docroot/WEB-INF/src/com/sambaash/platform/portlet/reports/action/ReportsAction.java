package com.sambaash.platform.portlet.reports.action;

import com.liferay.util.bridges.mvc.MVCPortlet;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.sambaash.platform.srv.rsvp.NoSuchRsvpException;
import com.sambaash.platform.srv.rsvp.model.Rsvp;
import com.sambaash.platform.srv.rsvp.model.RsvpDetail;
import com.sambaash.platform.srv.rsvp.service.RsvpDetailLocalServiceUtil;
import com.sambaash.platform.srv.rsvp.service.RsvpLocalServiceUtil;
import com.sambaash.platform.srv.spservices.model.SPParameter;
import com.sambaash.platform.srv.spservices.service.SPParameterLocalServiceUtil;
import com.sambaash.platform.util.SambaashUtil;
import com.sambaash.platform.util.ThumbnailUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.calendar.model.CalEvent;
import com.liferay.portlet.calendar.service.CalEventLocalServiceUtil;
import com.sambaash.platform.srv.spasset.model.SPAssetType;
import com.sambaash.platform.srv.spasset.service.SPAssetTypeLocalServiceUtil;
import com.sambaash.platform.srv.mail.model.SPMailCampaign;
import com.sambaash.platform.srv.mail.model.SPMailCampaignEDM;
import com.sambaash.platform.srv.mail.service.SPMailBlackListLocalServiceUtil;
import com.sambaash.platform.srv.mail.service.SPMailCampaignEDMLocalServiceUtil;
import com.sambaash.platform.srv.mail.service.SPMailCampaignLocalServiceUtil;
import com.sambaash.platform.srv.mail.service.SPMailCampaignSubscribersLocalServiceUtil;
import com.sambaash.platform.srv.mail.service.SPMailLinkTrackingLocalServiceUtil;
import com.sambaash.platform.srv.mail.service.SPMailLocalServiceUtil;
import com.sambaash.platform.srv.mail.service.SPMailSubscriberUserAgentLocalServiceUtil;

/**
 * Portlet implementation class ReportsAction
 */
public class ReportsAction extends MVCPortlet {
	


	private static Log _log = LogFactoryUtil.getLog(ReportsAction.class);

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {

		Rsvp rsvp = null;
		List<RsvpDetail> rsvpDetailList = null;
		List<SPMailCampaign> mailCampaignList = null;
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		CalEvent events = null;
		SPAssetType assetType = null;
		JSONObject eventsJSONObject = JSONFactoryUtil.createJSONObject();
		JSONObject rsvpJSONObject = JSONFactoryUtil.createJSONObject();
		JSONObject campJSONObject = JSONFactoryUtil.createJSONObject();
		JSONObject assetJSONObject = JSONFactoryUtil.createJSONObject();
		boolean isAdmin = false;
		boolean isReport = true;

		try {
			isAdmin = SambaashUtil.isAdmin(themeDisplay.getScopeGroupId(), themeDisplay.getUserId());
			isReport = SambaashUtil.isReportRole(themeDisplay.getScopeGroupId(), themeDisplay.getUserId());
			mailCampaignList = SPMailCampaignLocalServiceUtil.getActiveCampaigns(-1, -1);
			//getSPMailCampaigns(-1, -1);
			for (SPMailCampaign campList : mailCampaignList) {
				try{
					//rsvpList = RsvpLocalServiceUtil.getRsvp(campList.getRsvpId());
					campJSONObject.put(String.valueOf(campList.getSpMailCampaignId()), campList.getCampaignName());
					//for (Rsvp rsvps : rsvpList) {
					rsvp = RsvpLocalServiceUtil.getRsvp(campList.getRsvpId());
					rsvpJSONObject.put(String.valueOf(rsvp.getRsvpId()), rsvp.getTitle());
					try {
						events = CalEventLocalServiceUtil.getCalEvent(rsvp.getEventId());
						eventsJSONObject.put(String.valueOf(events.getEventId()), events.getTitle());
					} catch (Exception e) {
						_log.error("No cal Event is available " + e.getMessage());
					}
					if (rsvp.getSpAssetTypeId() > 0) {
						assetType = SPAssetTypeLocalServiceUtil.getSPAssetType(rsvp.getSpAssetTypeId());
						assetJSONObject.put(String.valueOf(assetType.getSpAssetTypeId()), assetType.getSpAssetTypeName());
					}
					
				}catch(Exception ez){
					_log.error(ez);
					
				}
				//}
			}
		} catch (Exception e) {
			_log.error("No RSVP Detail list available " + e.getMessage());
		}
		_log.error("campJSONObject " + campJSONObject);
		renderRequest.setAttribute("isAdmin",
				(isAdmin || SambaashUtil.isSupportRole(themeDisplay.getScopeGroupId(), themeDisplay.getUserId())));
		renderRequest.setAttribute("isReport", isReport);
		renderRequest.setAttribute("eventsJSONObject", eventsJSONObject);
		renderRequest.setAttribute("rsvpJSONObject", rsvpJSONObject);
		renderRequest.setAttribute("campJSONObject", campJSONObject);
		renderRequest.setAttribute("assetJSONObject", assetJSONObject);
		super.doView(renderRequest, renderResponse);
	}

	@Override
	public void doEdit(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {

		super.doEdit(renderRequest, renderResponse);
	}

	@Override
	public void processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException,
			PortletException {

	}

	public JSONObject getRsvpCounts(long rsvpId, long campaignId, int mailType) throws SystemException, PortalException {
		int inviteCount = 0;
		int adminCount = 0;
		int selfCount = 0;
		int yesConfirm = 0;
		int mayBe = 0;
		int waiting = 0;
		int noConfirm = 0;
		int attended = 0;
		int notAttended = 0;
		int mailSentMain = 0;

		//		int mailSentRem1 = 0;
		//		int mailSentRem2 = 0;
		//		int mailSentRem3 = 0;
		//		int mailDelivered = 0;

		int mailBouncedMain = 0;
		int mailBounceSoftMain = 0;
		int mailComplainMain = 0;
		int mailOpenedMain = 0;
		int mailNotOpenedMain = 0;
		int mailDeliveredMain = 0;
		int totalRsvp = 0; //create custom-sql -similar to spparameterfinder
		List<RsvpDetail> rsvpDetail = null;

		JSONObject countJSONObject = JSONFactoryUtil.createJSONObject();
		JSONObject sourceJSONObject = JSONFactoryUtil.createJSONObject();
		JSONObject statusJSONObject = JSONFactoryUtil.createJSONObject();
		JSONObject atdJSONObject = JSONFactoryUtil.createJSONObject();
		JSONObject mailJSONObject = JSONFactoryUtil.createJSONObject();
		JSONObject countryJSONObject = JSONFactoryUtil.createJSONObject();
		JSONObject linkJSONObject = JSONFactoryUtil.createJSONObject();
		JSONObject typeNameJSONObject = JSONFactoryUtil.createJSONObject();
		JSONObject oSJSONObject = JSONFactoryUtil.createJSONObject();
		JSONObject familyJSONObject = JSONFactoryUtil.createJSONObject();
		JSONObject deviceJSONObject = JSONFactoryUtil.createJSONObject();
		JSONObject nameJSONObject = JSONFactoryUtil.createJSONObject();
		JSONObject typeJSONObject = JSONFactoryUtil.createJSONObject();

		if (rsvpId > 0) {
			for (int i = 0; i < 4; i++) {
				rsvpDetail = RsvpDetailLocalServiceUtil.findByrsvpIdAndSource(rsvpId, i);
				switch (i) {
				case 1:
					inviteCount = rsvpDetail.size();
					sourceJSONObject.put("Invitation", inviteCount);
					break;
				case 2:
					selfCount = rsvpDetail.size();
					sourceJSONObject.put("Registration", selfCount);
					break;
				case 3:
					adminCount = rsvpDetail.size();
					sourceJSONObject.put("Admin-Registration", adminCount);
					break;
				}
			}
			for (int j = 0; j < 4; j++) {
				rsvpDetail = RsvpDetailLocalServiceUtil.findByrsvpStatusAndRsvpId(rsvpId, j);
				switch (j) {
				case 0:
					waiting = rsvpDetail.size();
					statusJSONObject.put("Waiting", waiting);
					break;
				case 1:
					yesConfirm = rsvpDetail.size();
					statusJSONObject.put("Attending", yesConfirm);
					break;
				case 2:
					noConfirm = rsvpDetail.size();
					statusJSONObject.put("Not-Attending", noConfirm);
					break;
				case 3:
					mayBe = rsvpDetail.size();
					statusJSONObject.put("MayBe", mayBe);
					break;
				}
			}
			for (int k = 0; k < 2; k++) {
				rsvpDetail = RsvpDetailLocalServiceUtil.findByrsvpIdAndAttendance(rsvpId, k);
				switch (k) {
				case 0:
					notAttended = rsvpDetail.size();
					atdJSONObject.put("Not-Attended", notAttended);
					break;
				case 1:
					attended = rsvpDetail.size();
					atdJSONObject.put("Attended", attended);
					break;
				}
			}

			rsvpDetail = RsvpDetailLocalServiceUtil.findByRsvpId(rsvpId);
			Iterator<RsvpDetail> rsvpItr = rsvpDetail.iterator();
			while (rsvpItr.hasNext()) {
				RsvpDetail rsvp = RsvpDetailLocalServiceUtil.getRsvpDetail(rsvpItr.next().getRsvpDetailId());
				totalRsvp = totalRsvp + rsvp.getNumberOfPeople();
			}

		}

		mailSentMain = SPMailCampaignSubscribersLocalServiceUtil.countByCampaignIdMailTypeAndStatus(campaignId,
				mailType, 3);
		mailOpenedMain = SPMailCampaignSubscribersLocalServiceUtil.countByCampaignIdMailTypeAndOpened(campaignId,
				mailType, true);

		mailJSONObject.put("Sent", mailSentMain);
		mailJSONObject.put("Opened", mailOpenedMain);
		if (mailType == 0) {
			mailBouncedMain = SPMailBlackListLocalServiceUtil.countByCampaignIdAndBounced(campaignId, true);
			mailBounceSoftMain = SPMailBlackListLocalServiceUtil.countByCampaignIdAndBouncedSoft(campaignId, true);
			mailComplainMain = SPMailBlackListLocalServiceUtil.countByCampaignIdAndComplain(campaignId, true);
			mailJSONObject.put("Complain", mailComplainMain);
			mailJSONObject.put("Bounced", mailBouncedMain);
			mailJSONObject.put("Bounce-Soft", mailBounceSoftMain);
			mailDeliveredMain = mailSentMain;
		}
		mailDeliveredMain = mailSentMain - (mailBouncedMain + mailBounceSoftMain);
		mailJSONObject.put("Delivered", mailDeliveredMain);
		mailNotOpenedMain = mailDeliveredMain - mailOpenedMain;
		mailJSONObject.put("Not-Opened", mailNotOpenedMain);
		_log.error("mailSentMain " + mailSentMain + " mailBouncedMain " + mailBouncedMain + " mailBounceSoftMain "
				+ mailBounceSoftMain);
		_log.error("mailComplainMain " + mailComplainMain + " mailOpenedMain " + mailOpenedMain);

		List<Object[]> mailSubList = SPMailCampaignSubscribersLocalServiceUtil.countOpenedMailByCountry(campaignId,
				mailType);
		List<Object[]> mailSubTypeList = SPMailSubscriberUserAgentLocalServiceUtil
				.countMailSubscriberByTypeName(campaignId);
		for (Object[] obj1 : mailSubTypeList) {
			String tname = (String) obj1[1];
			if((tname == null) || (tname.isEmpty())){
				tname = "unKnown";
			}
			typeNameJSONObject.put(tname, (Long) obj1[0]);
		}
		List<Object[]> mailSubOSList = SPMailSubscriberUserAgentLocalServiceUtil.countMailSubscriberByOS(campaignId);
		for (Object[] obj1 : mailSubOSList) {
			String tname = (String) obj1[1];
			if((tname == null) || (tname.isEmpty())){
				tname = "unKnown";
			}
			oSJSONObject.put(tname, (Long) obj1[0]);
		}
		List<Object[]> mailSubUserList = SPMailSubscriberUserAgentLocalServiceUtil.countMailSubscriberByFamily(campaignId);
		for (Object[] obj1 : mailSubUserList) {
			String tname = (String) obj1[1];
			if((tname == null) || (tname.isEmpty())){
				tname = "unKnown";
			}
			familyJSONObject.put(tname, (Long) obj1[0]);
		}
		List<Object[]> mailSubDevList = SPMailSubscriberUserAgentLocalServiceUtil.countMailSubscriberByDeviceCatogory(campaignId);
		for (Object[] obj1 : mailSubDevList) {
			String tname = (String) obj1[1];
			if((tname == null) || (tname.isEmpty())){
				tname = "unKnown";
			}
			deviceJSONObject.put(tname, (Long) obj1[0]);
		}
		List<Object[]> mailSubNameList = SPMailSubscriberUserAgentLocalServiceUtil.countMailSubscriberByName(campaignId);
		for (Object[] obj1 : mailSubNameList) {
			String tname = (String) obj1[1];
			if((tname == null) || (tname.isEmpty())){
				tname = "unKnown";
			}
			nameJSONObject.put(tname, (Long) obj1[0]);
		}
		List<Object[]> mailSubTypesList = SPMailSubscriberUserAgentLocalServiceUtil.countMailSubscriberByType(campaignId);
		for (Object[] obj1 : mailSubTypesList) {
			String tname = (String) obj1[1];
			if((tname == null) || (tname.isEmpty())){
				tname = "unKnown";
			}
			typeJSONObject.put(tname, (Long) obj1[0]);
		}
		for (Object[] obj : mailSubList) {
			String cName = (String) obj[1];
			if (cName.contains(",")) {
				cName = cName.replaceAll(",", " ");
			}
			countryJSONObject.put(cName, ((Long) obj[0]));
			_log.error(String.valueOf(((Long) obj[0])));
			_log.error((String) obj[1]);
		}

		List<Object[]> linkList = SPMailLinkTrackingLocalServiceUtil.countOpenedMailByLink(campaignId);
		String link = "";
		String linkUrl = "";
		for (Object[] obj : linkList) {
			linkUrl = (String) obj[1];
			boolean isOpened = (Boolean) obj[2];
			String linkOpn = (String) obj[3];
			if((linkOpn == null) || (linkOpn.isEmpty())){
				linkOpn = (String) obj[1];
				if(linkOpn.length() > 75){
					linkOpn = linkOpn.substring(0, 74) + "...";
				}
			}
			if (isOpened) {
				linkJSONObject.put(linkOpn, ((Long) obj[0]));
				_log.error("opened " + linkJSONObject);
			} else {
				if (!link.equalsIgnoreCase(linkOpn)) {
					linkJSONObject.put(linkOpn, 0);
					_log.error("Not opened " + linkJSONObject);
				}
			}
			link = (String) obj[1];
			_log.error(String.valueOf(((Long) obj[0])));
			_log.error((String) obj[1]);
			_log.error(String.valueOf(((Boolean) obj[2])));
		}

		if(sourceJSONObject.length() > 0)
		countJSONObject.put("sourceCount", sourceJSONObject);
		if(statusJSONObject.length() > 0)
		countJSONObject.put("statusCount", statusJSONObject);
		if(atdJSONObject.length() > 0)
		countJSONObject.put("atdCount", atdJSONObject);
		if(mailJSONObject.length() > 0)
		countJSONObject.put("mailCount", mailJSONObject);
		if(countryJSONObject.length() > 0)
		countJSONObject.put("countryCount", countryJSONObject);
		if(linkJSONObject.length() > 0)
		countJSONObject.put("linkJSONObject", linkJSONObject);
		if(typeNameJSONObject.length() > 0)
		countJSONObject.put("typeNameJSONObject", typeNameJSONObject);
		if(oSJSONObject.length() > 0)
		countJSONObject.put("oSJSONObject", oSJSONObject);
		if(familyJSONObject.length() > 0)
		countJSONObject.put("familyJSONObject", familyJSONObject);
		if(deviceJSONObject.length() > 0)
		countJSONObject.put("deviceJSONObject", deviceJSONObject);
		if(nameJSONObject.length() > 0)
		countJSONObject.put("nameJSONObject", nameJSONObject);
		if(typeJSONObject.length() > 0)
		countJSONObject.put("typeJSONObject", typeJSONObject);

		countJSONObject.put("totalRsvp", totalRsvp);

		return countJSONObject;
	}

	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException,
			PortletException {
		super.serveResource(resourceRequest, resourceResponse);
		
		String action = ParamUtil.getString(resourceRequest,"action");
		
		if("fetchEdms".equalsIgnoreCase(action)){
			JSONObject data = JSONFactoryUtil.createJSONObject();
			long campaignId = ParamUtil.getLong(resourceRequest, "campaignId");
			try{
				List<SPMailCampaignEDM>edms = SPMailCampaignEDMLocalServiceUtil.findByCampaignId(campaignId);
				JSONArray jsonEdms = JSONFactoryUtil.createJSONArray();
				for(SPMailCampaignEDM edm:edms){
					JSONObject jedm = JSONFactoryUtil.createJSONObject();
					jedm.put("name", edm.getName());
					jedm.put("mailTypeId", edm.getSeqNo());
					jsonEdms.put(jedm);
				}
				data.put("edms", jsonEdms);
			}catch(Exception ex){
				data.put("error", "error");
			}
					
			resourceResponse.getWriter().append(data.toString());
			return;
		}

		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);

		JSONObject eventsJSONObject = JSONFactoryUtil.createJSONObject();
		JSONObject rsvpJSONObject = JSONFactoryUtil.createJSONObject();
		JSONObject assetJSONObject = JSONFactoryUtil.createJSONObject();
		JSONObject selectedRsvpJSONObject = JSONFactoryUtil.createJSONObject();
		JSONObject chartNameJSONObject = JSONFactoryUtil.createJSONObject();

		JSONObject countJSONObject = JSONFactoryUtil.createJSONObject();

		String type = resourceRequest.getParameter("type");
		int mailType = Integer.parseInt(resourceRequest.getParameter("mailType"));
		int selectedCamp = Integer.parseInt(resourceRequest.getParameter("campSelect"));
		String selectedChartType = resourceRequest.getParameter("chartType");
		long selectedRsvp = 0; //Integer.parseInt(resourceRequest.getParameter("rsvpSelect"));
		String selectedRsvpName = StringPool.BLANK;
		String selectedCampaignName = StringPool.BLANK;
		try {
			if (selectedCamp > 0) {
				SPMailCampaign mailCamp = SPMailCampaignLocalServiceUtil.getSPMailCampaign(selectedCamp);
				selectedRsvp = mailCamp.getRsvpId();
				selectedCampaignName = SPMailLocalServiceUtil.getMailSubject(mailCamp, mailType);
			}
			if (selectedRsvp > 0) {
				selectedRsvpName = RsvpLocalServiceUtil.getRsvp(selectedRsvp).getTitle();
			}
		} catch (Exception e) {
			_log.error("No Mail Campaign found " + e.getMessage());
		}

		chartNameJSONObject.put("campaignName", selectedCampaignName);
		selectedRsvpJSONObject.put(String.valueOf(selectedRsvp), selectedRsvpName);
		_log.error("selectedRsvpJSONObject " + selectedRsvpJSONObject);
		if(!(type.equalsIgnoreCase("htmltopdf")))
		countJSONObject.put("selectedRsvpName", selectedRsvpJSONObject);
		int selectedEvent = 0;// Integer.parseInt(resourceRequest.getParameter("eventsSelect"));
		int selectedAssetType = 0;// Integer.parseInt(resourceRequest.getParameter("assetTypeSelect"));

		String[] svg = new String[11];

		svg[0] = resourceRequest.getParameter("svg1").trim();
		svg[1] = resourceRequest.getParameter("svg2").trim();
		svg[2] = resourceRequest.getParameter("svg3").trim();
		svg[3] = resourceRequest.getParameter("svg4").trim();
		svg[4] = resourceRequest.getParameter("svg5").trim();
		svg[5] = resourceRequest.getParameter("svg6").trim();
		svg[6] = resourceRequest.getParameter("svg7").trim();
		svg[7] = resourceRequest.getParameter("svg8").trim();
		svg[8] = resourceRequest.getParameter("svg9").trim();
		svg[9] = resourceRequest.getParameter("svg10").trim();
		svg[10] = resourceRequest.getParameter("svg11").trim();

		Rsvp rsvp = null;
		CalEvent events = null;
		SPAssetType assettype = null;
		String rsvpName = "";
		String eventName = "";
		String contest = "";

		if (type.equalsIgnoreCase("getCount")) {
			if ((selectedEvent > 0) && (selectedAssetType > 0) && (selectedRsvp == 0)) {
				try {
					rsvp = RsvpLocalServiceUtil.findByeventIdAndSpAssetTypeId(selectedEvent, selectedAssetType);
					assettype = SPAssetTypeLocalServiceUtil.getSPAssetType(selectedAssetType);
					countJSONObject = getRsvpCounts(rsvp.getRsvpId(), selectedCamp, mailType);
				} catch (NoSuchRsvpException e) {
					_log.error(e);
				} catch (SystemException e) {
					_log.error(e);
				} catch (PortalException e) {
					_log.error(e);
				}
			} else if (((selectedEvent == 0) && (selectedAssetType == 0) && (selectedRsvp > 0))
					|| ((selectedEvent > 0) && (selectedAssetType > 0) && (selectedRsvp > 0))) {
				try {
					rsvp = RsvpLocalServiceUtil.getRsvp(selectedRsvp);
					countJSONObject = getRsvpCounts(rsvp.getRsvpId(), selectedCamp, mailType);
				} catch (Exception e) {

				}
			} else if (((selectedEvent > 0) && (selectedAssetType == 0) && (selectedRsvp == 0))
					|| ((selectedEvent > 0) && (selectedAssetType == 0) && (selectedRsvp > 0))) {
				try {
					rsvp = RsvpLocalServiceUtil.findByeventId(selectedEvent);
					countJSONObject = getRsvpCounts(rsvp.getRsvpId(), selectedCamp, mailType);
					_log.info("rsvp filter by event " + rsvp);
				} catch (Exception e) {
					_log.error(e);
				}
			} else if (((selectedEvent == 0) && (selectedAssetType > 0) && (selectedRsvp == 0))
					|| ((selectedEvent == 0) && (selectedAssetType > 0) && (selectedRsvp > 0))) {
				try {
					rsvp = RsvpLocalServiceUtil.findByspAssetTypeId(selectedAssetType);
					countJSONObject = getRsvpCounts(rsvp.getRsvpId(), selectedCamp, mailType);
					_log.info("rsvp filter by assettype " + rsvp);
				} catch (Exception e) {
					_log.error(e);
				}
			} else if ((selectedRsvp == 0) && (selectedCamp > 0)) {
				try {
					_log.error("selectedCamp " + selectedCamp);
					countJSONObject = getRsvpCounts(0, selectedCamp, mailType);
				} catch (Exception e) {
					_log.error(e);
				}
			}
		} else if (type.equalsIgnoreCase("filters")) {
			if (selectedEvent > 0) {
				try {
					rsvp = RsvpLocalServiceUtil.findByeventId(selectedEvent);
					events = CalEventLocalServiceUtil.getEvent(rsvp.getEventId());
					rsvpJSONObject.put(String.valueOf(rsvp.getRsvpId()), rsvp.getTitle());
					countJSONObject.put("rsvp", rsvpJSONObject);
					rsvpName = rsvp.getTitle();
					eventName = events.getTitle();
					chartNameJSONObject.put("rsvpName", rsvpName);
					chartNameJSONObject.put("eventName", eventName);
					if (rsvp.getSpAssetTypeId() > 0) {
						assettype = SPAssetTypeLocalServiceUtil.getSPAssetType(rsvp.getSpAssetTypeId());
						assetJSONObject.put(String.valueOf(rsvp.getSpAssetTypeId()), assettype.getSpAssetTypeName());
						countJSONObject.put("assetType", assetJSONObject);
						contest = assettype.getSpAssetTypeName();
						chartNameJSONObject.put("rsvpName", rsvpName);
						chartNameJSONObject.put("contest", contest);
					}
					countJSONObject.put("chartName", chartNameJSONObject);
				} catch (NoSuchRsvpException e) {
					_log.error(e);
				} catch (SystemException e) {
					_log.error(e);
				} catch (PortalException e) {
					_log.error(e);
				}
			} else if (selectedAssetType > 0) {
				try {
					rsvp = RsvpLocalServiceUtil.findByspAssetTypeId(selectedAssetType);
					assettype = SPAssetTypeLocalServiceUtil.getSPAssetType(selectedAssetType);
					rsvpJSONObject.put(String.valueOf(rsvp.getRsvpId()), rsvp.getTitle());
					rsvpName = rsvp.getTitle();
					contest = assettype.getSpAssetTypeName();
					chartNameJSONObject.put("rsvpName", rsvpName);
					chartNameJSONObject.put("contest", contest);
					if (rsvp.getEventId() > 0) {
						events = CalEventLocalServiceUtil.getEvent(rsvp.getEventId());
						eventsJSONObject.put(String.valueOf(rsvp.getEventId()), events.getTitle());
						countJSONObject.put("events", eventsJSONObject);
						eventName = events.getTitle();
						chartNameJSONObject.put("eventName", eventName);
					}
					countJSONObject.put("rsvp", rsvpJSONObject);
					countJSONObject.put("chartName", chartNameJSONObject);
				} catch (NoSuchRsvpException e) {
					_log.error(e);
				} catch (SystemException e) {
					_log.error(e);
				} catch (PortalException e) {
					_log.error(e);
				}
			} else if (selectedRsvp > 0) {
				try {
					rsvp = RsvpLocalServiceUtil.getRsvp(selectedRsvp);
					rsvpName = rsvp.getTitle();
					if (rsvp.getSpAssetTypeId() > 0) {
						assettype = SPAssetTypeLocalServiceUtil.getSPAssetType(rsvp.getSpAssetTypeId());
						assetJSONObject.put(String.valueOf(rsvp.getSpAssetTypeId()), assettype.getSpAssetTypeName());
						countJSONObject.put("assetType", assetJSONObject);
						contest = assettype.getSpAssetTypeName();
						chartNameJSONObject.put("rsvpName", rsvpName);
						chartNameJSONObject.put("contest", contest);
					}
					if (rsvp.getEventId() > 0) {
						events = CalEventLocalServiceUtil.getEvent(rsvp.getEventId());
						eventsJSONObject.put(String.valueOf(rsvp.getEventId()), events.getTitle());
						countJSONObject.put("events", eventsJSONObject);
						eventName = events.getTitle();
						chartNameJSONObject.put("rsvpName", rsvpName);
						chartNameJSONObject.put("eventName", eventName);
					}
					if ((rsvp.getSpAssetTypeId() > 0) && (rsvp.getEventId() > 0)) {
						eventName = events.getTitle();
						contest = assettype.getSpAssetTypeName();
						chartNameJSONObject.put("rsvpName", rsvpName);
						chartNameJSONObject.put("eventName", eventName);
						chartNameJSONObject.put("contest", contest);
					}
					countJSONObject.put("chartName", chartNameJSONObject);
				} catch (NoSuchRsvpException e) {
					_log.error(e);
				} catch (SystemException e) {
					_log.error(e);
				} catch (PortalException e) {
					_log.error(e);
				}
			} else if ((selectedRsvp == 0) && (selectedCamp > 0)) {
				chartNameJSONObject.put("campaignName", selectedCampaignName);
				countJSONObject.put("chartName", chartNameJSONObject);
				if((selectedChartType != null) && (!selectedChartType.equals("0"))){
					try {
						_log.error("selectedCamp " + selectedCamp);
						countJSONObject = getRsvpCounts(0, selectedCamp, mailType);
					} catch (Exception e) {
						_log.error(e);
					}
				}
				_log.error("chartNameJSONObject " + chartNameJSONObject);
			}
		} else if (type.equalsIgnoreCase("htmltopdf")) {
			_log.info("htmltopdf");
			String zipFile = generateSVGFile(svg, themeDisplay);
			countJSONObject.put("zipFile", zipFile);
			// HtmlToPdfConverter convert = new
			// HtmlToPdfConverter("reportPDF.pdf");
		}
		resourceResponse.getWriter().append(countJSONObject.toString());
	}

	private String generateSVGFile(String[] svg, ThemeDisplay themeDisplay) {
		_log.error("htmltopdf generatesvgfile");

		String zipFile = StringPool.BLANK;
		FileOutputStream out;
		String filePath = "/usr/sambaashplatform/Reports";

		try {
			SPParameter param = SPParameterLocalServiceUtil.findBySPParameterGroupIdAndName(
					themeDisplay.getScopeGroupId(), "rsvp.reports.filepath");
			if (param != null) {
				filePath = param.getValue();
			}
		} catch (Exception e) {
			_log.error("Services Error " + e.getMessage());
		}

		try {
			File reportDir = new File(filePath);
			if (!reportDir.exists()) {
				reportDir.mkdirs();
			}
		} catch (Exception e) {
			_log.error("Exception in creating the image upload directory");
		}
		int svgLength = 0;
		for (int i = 0; i < svg.length; i++) {
			if (svg[i].getBytes().length > 0)
				svgLength = svgLength + 1;
		}
		String[] filePathArray = new String[svgLength];

		String outputFile = filePath + "/pdfFile_" + themeDisplay.getUserId() + "_" + (new Date().getTime()) + ".pdf";
		try {
			for (int i = 0; i < svg.length; i++) {
				byte[] dataToWrite = svg[i].getBytes();
				if (svg[i].getBytes().length > 0) {
					filePathArray[i] = filePath + "/svgFile" + i + StringPool.UNDERLINE + themeDisplay.getUserId()
							+ StringPool.UNDERLINE + (new Date().getTime()) + ".svg";
					out = new FileOutputStream(filePathArray[i]);
					out.write(dataToWrite);
					out.close();
				}
			}

			zipFile = ThumbnailUtil.generatePdfFromSVG(filePathArray, outputFile, filePath);

		} catch (FileNotFoundException e) {
			_log.error(e);
		} catch (IOException e) {
			_log.error(e);
		} catch (Exception e) {
			_log.error(e);
		}
		return zipFile;
	}



}