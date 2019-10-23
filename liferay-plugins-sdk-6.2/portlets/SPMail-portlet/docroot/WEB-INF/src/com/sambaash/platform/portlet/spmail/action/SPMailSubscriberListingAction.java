package com.sambaash.platform.portlet.spmail.action;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.sambaash.platform.portlet.spmail.util.MailConst;
import com.sambaash.platform.srv.mail.model.SPMailBlackList;
import com.sambaash.platform.srv.mail.model.SPMailCampaign;
import com.sambaash.platform.srv.mail.model.SPMailCampaignEDM;
import com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers;
import com.sambaash.platform.srv.mail.service.SPMailBlackListLocalServiceUtil;
import com.sambaash.platform.srv.mail.service.SPMailCampaignEDMLocalServiceUtil;
import com.sambaash.platform.srv.mail.service.SPMailCampaignLocalServiceUtil;
import com.sambaash.platform.srv.mail.service.SPMailCampaignSubscribersLocalServiceUtil;
import com.sambaash.platform.util.SambaashUtil;
import com.sambaash.platform.portlet.spmail.util.CampaignListingComparator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

/**
 * Portlet implementation class SPMailSubscriberListingAction
 */
public class SPMailSubscriberListingAction extends MVCPortlet {

	private static Log _log = LogFactoryUtil.getLog(SPMailSubscriberListingAction.class);
	private static final int totalCount = 50;

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		List<SPMailCampaignSubscribers> mailCampaignList = null;
		List<SPMailCampaign> campaignList = null;
		JSONObject subscriberJsonObject = JSONFactoryUtil.createJSONObject();
		ThemeDisplay themeDisplay = (ThemeDisplay)renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		int listCount = 0;
		SPMailCampaign mCamp = null;
		List<SPMailCampaign>campaignListSorted = new ArrayList<SPMailCampaign>();
		try {
			listCount = SPMailCampaignSubscribersLocalServiceUtil.getSPMailCampaignSubscribersesCount();
			campaignList = SPMailCampaignLocalServiceUtil.getActiveCampaigns(-1, -1);
			
			if (!campaignList.isEmpty()) {
				
				for (SPMailCampaign info : campaignList) {
					if(info != null){
						campaignListSorted.add(info);
					}else{
						_log.error("Found no object classNameid#entityid " + info);
					}
				}
				
				Comparator<SPMailCampaign> comparator = new Comparator<SPMailCampaign>() {

					@Override
					public int compare(SPMailCampaign o1, SPMailCampaign o2) {
						try {
							Date date1 = o1.getCreateDate();
							Date date2 = o2.getCreateDate();

							return date2.compareTo(date1);
						} catch (Exception e) {
							_log.error(" Error occured in comparison " + e.getMessage());
						}

						return 0;
					}
				};
				Collections.sort(campaignListSorted, comparator);
				//Collections.sort(campaignList);
			SPMailCampaign spMailCampaign = campaignList.get(0);
			mailCampaignList = SPMailCampaignSubscribersLocalServiceUtil.findByCampaignId(
					spMailCampaign.getSpMailCampaignId(), 0, totalCount);
			_log.error("campaignList " + mailCampaignList.size());
			_log.error("campaignList " + mailCampaignList);
			if(mailCampaignList.isEmpty()){
				renderRequest.setAttribute("noresults", "No Subscribers uploaded for this campaign");
			}else{
			
			SPMailCampaignEDM edm;
			
			List<SPMailCampaignEDM> edmList = SPMailCampaignEDMLocalServiceUtil.findByCampaignId(spMailCampaign.getSpMailCampaignId());
			renderRequest.setAttribute("noresults", "");
			renderRequest.setAttribute("edmList", edmList);
			for (SPMailCampaignSubscribers subscriber : mailCampaignList) {
				JSONObject mailSubscriberJsonObject = JSONFactoryUtil.createJSONObject();
				mCamp = SPMailCampaignLocalServiceUtil.getSPMailCampaign(subscriber.getSpMailCampaignId());
				mailSubscriberJsonObject.put("cName", mCamp.getCampaignName());
				int mailTypeSeq = subscriber.getSpMailType();
				if(mailTypeSeq >  MailConst.SEQ_NO_START){
					try{
						edm = SPMailCampaignEDMLocalServiceUtil.getSPMailCampaignEDM(mailTypeSeq);
						mailSubscriberJsonObject.put("mailType", edm.getName());
						_log.error("edm name " + edm.getName() + " mCamp " + mCamp.getCampaignName());
					}catch(Exception ex){
						_log.error("Error while fetching edm for campaignId, seqn = " +spMailCampaign.getSpMailCampaignId() + "," + mailTypeSeq);
					}
					
				}else{
					switch (subscriber.getSpMailType()) {
					case 0:
						mailSubscriberJsonObject.put("mailType", "Main");
						break;
					case 1:
						mailSubscriberJsonObject.put("mailType", "Reminder1");
						break;
					case 2:
						mailSubscriberJsonObject.put("mailType", "Reminder2");
						break;
					case 3:
						mailSubscriberJsonObject.put("mailType", "Reminder3");
						break;
					}
				}
				mailSubscriberJsonObject.put("fName", subscriber.getFirstName());
				mailSubscriberJsonObject.put("lName", subscriber.getLastName());
				mailSubscriberJsonObject.put("email", subscriber.getEmailAddress());
				if (subscriber.getOpened()) {
					mailSubscriberJsonObject.put("Opened", "Opened");
				} else {
					try {
						SPMailBlackList blkList = SPMailBlackListLocalServiceUtil.findByEmailAddress(subscriber
								.getEmailAddress());

						if (blkList != null) {
							boolean bounced = blkList.getBounced();
							boolean bouncedSoft = blkList.getBounce_soft();
							boolean Complain = blkList.getComplain();

							if (bounced) {
								mailSubscriberJsonObject.put("Opened", "Bounced");
							} else if (bouncedSoft) {
								mailSubscriberJsonObject.put("Opened", "Bounced-Soft");
							} else if (Complain) {
								mailSubscriberJsonObject.put("Opened", "Complain");
							}
						}
					} catch (Exception e) {
						mailSubscriberJsonObject.put("Opened", "Not-Opened");
						_log.error("no Black mail list found for the mail " + e.getMessage());
					}
				}

				switch (subscriber.getStatus()) {
				case 0:
					mailSubscriberJsonObject.put("status", "Not_Scheduled");
					break;
				case 1:
					mailSubscriberJsonObject.put("status", "Scheduled");
					break;
				case 2:
					mailSubscriberJsonObject.put("status", "Processing");
					break;
				case 3:
					mailSubscriberJsonObject.put("status", "Sent");
					break;
				}
				mailSubscriberJsonObject.put("statusValue", subscriber.getStatus());
				subscriberJsonObject.put(String.valueOf(subscriber.getSpMailCampaignSubscribersId()),
						mailSubscriberJsonObject);
			}
			}
		}	
		} catch (SystemException e) {
			_log.error(e);
		} catch (PortalException e) {
			_log.error(e);
		}
		renderRequest.setAttribute("hasAccess", (SambaashUtil.isAdmin(themeDisplay.getScopeGroupId(),
				themeDisplay.getUserId()) || SambaashUtil.isSupportRole(themeDisplay.getScopeGroupId(),
				themeDisplay.getUserId())));
		renderRequest.setAttribute("subscriberJsonObject", subscriberJsonObject);
		renderRequest.setAttribute("campaignList", campaignListSorted);
		renderRequest.setAttribute("listCount", listCount);
		
		super.doView(renderRequest, renderResponse);
	}

	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException,
			PortletException {

		String type = resourceRequest.getParameter("type");
		String campaignId = resourceRequest.getParameter("campaignId");
		String mailTypeId = resourceRequest.getParameter("mailTypeId");
		String mailStatusId = resourceRequest.getParameter("mailStatusId");
		boolean mStatus = false;
		if(Validator.isNotNull(mailStatusId)){
			mStatus = Long.parseLong(mailStatusId) > 0 ? true : false;
		}
		String cId = resourceRequest.getParameter("cId");
		//String actionId = resourceRequest.getParameter("actionId");
		String nValue = resourceRequest.getParameter("nextValue");
		String pValue = resourceRequest.getParameter("prevValue");
		String loadMore = resourceRequest.getParameter("loadMore");
		String filterName = resourceRequest.getParameter("filterName");
		if(Validator.isNotNull(filterName)){
			filterName = resourceRequest.getParameter("filterName").trim();
		}
		String filterValue = resourceRequest.getParameter("filterValue");
		if(Validator.isNotNull(filterValue)){
			filterValue = resourceRequest.getParameter("filterValue").trim();
		}
		_log.debug("type " + type + " nValue " + nValue + " campaignId " + campaignId);
		int nextValue = 50;
		int prevValue = 0;
		int listCount = 0;
		String isList = "false";
		int c = 0;
		int tCount = c + totalCount;
		if (nValue != null)
			nextValue = Integer.parseInt(nValue);
		if (pValue != null)
			prevValue = Integer.parseInt(pValue);
		if ((type.equalsIgnoreCase("loadMore")) && (loadMore.equalsIgnoreCase("true"))) {
			c = nextValue;
			tCount = c + totalCount;
		} else if (type.equalsIgnoreCase("loadPrev")) {
			c = prevValue;
			tCount = c - totalCount;
		}
		
		JSONObject subscriberJsonObject = JSONFactoryUtil.createJSONObject();
		JSONObject campaignEDMJsonObject = JSONFactoryUtil.createJSONObject();
		List<SPMailCampaignSubscribers> subscribers = null;
		SPMailCampaignSubscribers spMailCampaign = null;
		List<SPMailBlackList> bList = null;
		try {
			if (type.equalsIgnoreCase("getMailType")) {
				JSONObject countJSONObject = JSONFactoryUtil.createJSONObject();
				List<SPMailCampaignEDM> mailCampaignEdms = null;
				JSONObject campEdmJSONObject = JSONFactoryUtil.createJSONObject();
				try {
					mailCampaignEdms = SPMailCampaignEDMLocalServiceUtil.findByCampaignId(Long.parseLong(campaignId));
					_log.error("mailCampaignEdms " + mailCampaignEdms + " mailCampaignEdms size " + mailCampaignEdms.size());
					if(mailCampaignEdms.size() > 0){
						for(SPMailCampaignEDM mailCampaignEdm : mailCampaignEdms){
							subscriberJsonObject.put(String.valueOf(mailCampaignEdm.getSeqNo()),mailCampaignEdm.getName());
						}
					}else{
						subscriberJsonObject.put(String.valueOf("-1"),"All");
						subscriberJsonObject.put(String.valueOf("0"),"Main");
						subscriberJsonObject.put(String.valueOf("1"),"Reminder1");
						subscriberJsonObject.put(String.valueOf("2"),"Reminder2");
						subscriberJsonObject.put(String.valueOf("3"),"Reminder3");
					}
				} catch (NumberFormatException | SystemException e) {
					_log.error(e.getMessage());
				}
				
			} else if (type.equalsIgnoreCase("delete")) {
				SPMailCampaignSubscribersLocalServiceUtil.deleteSPMailCampaignSubscribers(Long.parseLong(cId));
				_log.info("delete " + subscribers);
			}
			if (type.equalsIgnoreCase("searchAction")) {
				if (filterName.equalsIgnoreCase("email")) {
					if ((Long.parseLong(mailTypeId) >= 0) && ((Long.parseLong(mailStatusId) < 0))) {
						spMailCampaign = SPMailCampaignSubscribersLocalServiceUtil
								.findByCampaignIdMailTypeAndEmailAddress(Long.parseLong(campaignId),
										Integer.parseInt(mailTypeId), filterValue);
					} else if ((Long.parseLong(mailTypeId) < 0) && ((Long.parseLong(mailStatusId) >= 0))) {
						subscribers = SPMailCampaignSubscribersLocalServiceUtil
								.findByCampaignIdOpenedAndEmailAddress(Long.parseLong(campaignId), mStatus, filterValue);
					} else if ((Long.parseLong(mailTypeId) < 0) && ((Long.parseLong(mailStatusId) < 0))) {
						subscribers = SPMailCampaignSubscribersLocalServiceUtil.findByCampaignIdAndEmailAddress(
								Long.parseLong(campaignId), filterValue);
					} else {
						subscribers = SPMailCampaignSubscribersLocalServiceUtil
								.findByCampaignIdMailTypeOpenedAndEmailAddress(Long.parseLong(campaignId),
										Integer.parseInt(mailTypeId), mStatus, filterValue);
					}
				}
				if (filterName.equalsIgnoreCase("fName")) {
					if ((Long.parseLong(mailTypeId) >= 0) && ((Long.parseLong(mailStatusId) < 0))) {
						subscribers = SPMailCampaignSubscribersLocalServiceUtil
								.findByCampaignIdMailTypeAndFirstName(Long.parseLong(campaignId),
										Integer.parseInt(mailTypeId), filterValue);
					} else if ((Long.parseLong(mailTypeId) < 0) && ((Long.parseLong(mailStatusId) >= 0))) {
						subscribers = SPMailCampaignSubscribersLocalServiceUtil
								.findByCampaignIdOpenedAndFirstName(Long.parseLong(campaignId), mStatus, filterValue);
					} else if ((Long.parseLong(mailTypeId) < 0) && ((Long.parseLong(mailStatusId) < 0))) {
						subscribers = SPMailCampaignSubscribersLocalServiceUtil.findByCampaignIdAndFirstName(
								Long.parseLong(campaignId), filterValue);
					} else {
						subscribers = SPMailCampaignSubscribersLocalServiceUtil
								.findByCampaignIdMailTypeOpenedAndFirstName(Long.parseLong(campaignId),
										Integer.parseInt(mailTypeId), mStatus, filterValue);
					}
				}
				if (filterName.equalsIgnoreCase("lName")) {
					if ((Long.parseLong(mailTypeId) >= 0) && ((Long.parseLong(mailStatusId) < 0))) {
						subscribers = SPMailCampaignSubscribersLocalServiceUtil
								.findByCampaignIdMailTypeAndLastName(Long.parseLong(campaignId),
										Integer.parseInt(mailTypeId), filterValue);
					} else if ((Long.parseLong(mailTypeId) < 0) && ((Long.parseLong(mailStatusId) >= 0))) {
						subscribers = SPMailCampaignSubscribersLocalServiceUtil.findByCampaignIdOpenedAndLastName(
								Long.parseLong(campaignId), mStatus, filterValue);
					} else if ((Long.parseLong(mailTypeId) < 0) && ((Long.parseLong(mailStatusId) < 0))) {
						subscribers = SPMailCampaignSubscribersLocalServiceUtil.findByCampaignIdAndLastName(
								Long.parseLong(campaignId), filterValue);
					} else {
						subscribers = SPMailCampaignSubscribersLocalServiceUtil
								.findByCampaignIdMailTypeOpenedAndLastName(Long.parseLong(campaignId),
										Integer.parseInt(mailTypeId), mStatus, filterValue);
					}
				}
			} else {
				if (Long.parseLong(campaignId) > 0) {
					if ((Long.parseLong(mailTypeId) >= 0)) {
						if ((Long.parseLong(mailStatusId) == 0) || (Long.parseLong(mailStatusId) == 1)) {
							//boolean mStatus = Long.parseLong(mailStatusId) > 0 ? true :false;
							listCount = SPMailCampaignSubscribersLocalServiceUtil.countByCampaignIdMailTypeAndOpened(
									Long.parseLong(campaignId), Integer.parseInt(mailTypeId), mStatus);
							_log.error("listCount0 " + listCount);
							if (listCount > tCount)
								isList = "true";
							subscribers = SPMailCampaignSubscribersLocalServiceUtil
									.findByCampaignIdMailTypeAndOpened(Long.parseLong(campaignId),
											Integer.parseInt(mailTypeId), mStatus, c, tCount);
							if(tCount < c){
								subscribers = SPMailCampaignSubscribersLocalServiceUtil.findByCampaignIdMailTypeAndOpened(Long.parseLong(campaignId),
										Integer.parseInt(mailTypeId), mStatus, tCount,c);
							}
						} else if ((Long.parseLong(mailStatusId) == 2) || (Long.parseLong(mailStatusId) == 3)
								|| (Long.parseLong(mailStatusId) == 4)) {
							listCount = SPMailCampaignSubscribersLocalServiceUtil.countByCampaignId(Long
									.parseLong(campaignId));
							_log.error("listCount1 " + listCount);
							if (listCount > tCount)
								isList = "true";
							bList = SPMailBlackListLocalServiceUtil.findByCampaignId(Long.parseLong(campaignId));
							for (SPMailBlackList blackLst : bList) {
								if ((Long.parseLong(mailStatusId) == 2) && (blackLst.isBounced())) {
									subscribers = SPMailCampaignSubscribersLocalServiceUtil.findByEmailAddress(
											blackLst.getEmailAddress(), c, tCount);
									if(tCount < c){
										subscribers = SPMailCampaignSubscribersLocalServiceUtil.findByEmailAddress(
												blackLst.getEmailAddress(), tCount,c);
									}
								} else if ((Long.parseLong(mailStatusId) == 3) && (blackLst.isBounce_soft())) {
									subscribers = SPMailCampaignSubscribersLocalServiceUtil.findByEmailAddress(
											blackLst.getEmailAddress(), c, tCount);
									if(tCount < c){
										subscribers = SPMailCampaignSubscribersLocalServiceUtil.findByEmailAddress(
												blackLst.getEmailAddress(), tCount,c);
									}
								} else if ((Long.parseLong(mailStatusId) == 4) && (blackLst.isComplain())) {
									subscribers = SPMailCampaignSubscribersLocalServiceUtil.findByEmailAddress(
											blackLst.getEmailAddress(), c, tCount);
									if(tCount < c){
										subscribers = SPMailCampaignSubscribersLocalServiceUtil.findByEmailAddress(
												blackLst.getEmailAddress(), tCount,c);
									}
								}
							}
						} else if ((Long.parseLong(mailStatusId) < 0)) {
							listCount = SPMailCampaignSubscribersLocalServiceUtil.countByCampaignIdAndMailType(
									Long.parseLong(campaignId), Integer.parseInt(mailTypeId));
							_log.error("listCount2 " + listCount);
							if (listCount > tCount){
								isList = "true";
							}
							subscribers = SPMailCampaignSubscribersLocalServiceUtil.findByCampaignIdAndMailType(
									Long.parseLong(campaignId), Integer.parseInt(mailTypeId), c, tCount);
							if(tCount < c){
								subscribers = SPMailCampaignSubscribersLocalServiceUtil.findByCampaignIdAndMailType(
										Long.parseLong(campaignId), Integer.parseInt(mailTypeId), tCount,c);
							}
							_log.error("subscribers " + subscribers.size() + " tCount " + tCount + " cc " + c);
						}
					} else if (Long.parseLong(mailTypeId) < 0) {
						if ((Long.parseLong(mailStatusId) == 0) || (Long.parseLong(mailStatusId) == 1)) {
							//boolean mStatus = Long.parseLong(mailStatusId) > 0 ? true : false;
							listCount = SPMailCampaignSubscribersLocalServiceUtil.countByCampaignIdAndOpened(
									Long.parseLong(campaignId), mStatus);
							_log.error("listCount3 " + listCount);
							if (listCount > tCount)
								isList = "true";
							subscribers = SPMailCampaignSubscribersLocalServiceUtil.findByCampaignIdAndOpened(
									Long.parseLong(campaignId), mStatus, c, tCount);
							if(tCount < c){
								subscribers = SPMailCampaignSubscribersLocalServiceUtil.findByCampaignIdAndOpened(
										Long.parseLong(campaignId), mStatus, tCount,c);
							}
						} else if ((Long.parseLong(mailStatusId) == 2) || (Long.parseLong(mailStatusId) == 3)
								|| (Long.parseLong(mailStatusId) == 4)) {
							listCount = SPMailCampaignSubscribersLocalServiceUtil.countByCampaignId(Long
									.parseLong(campaignId));
							_log.error("listCount4 " + listCount);
							if (listCount > tCount)
								isList = "true";
							bList = SPMailBlackListLocalServiceUtil.findByCampaignId(Long.parseLong(campaignId));
							for (SPMailBlackList blackLst : bList) {
								if ((Long.parseLong(mailStatusId) == 2) && (blackLst.isBounced())) {
									subscribers = SPMailCampaignSubscribersLocalServiceUtil.findByEmailAddress(
											blackLst.getEmailAddress(), c, tCount);
									if(tCount < c){
										subscribers = SPMailCampaignSubscribersLocalServiceUtil.findByEmailAddress(
												blackLst.getEmailAddress(), tCount,c);
									}
								} else if ((Long.parseLong(mailStatusId) == 3) && (blackLst.isBounce_soft())) {
									subscribers = SPMailCampaignSubscribersLocalServiceUtil.findByEmailAddress(
											blackLst.getEmailAddress(), c, tCount);
									if(tCount < c){
										subscribers = SPMailCampaignSubscribersLocalServiceUtil.findByEmailAddress(
												blackLst.getEmailAddress(), tCount,c);
									}
								} else if ((Long.parseLong(mailStatusId) == 4) && (blackLst.isComplain())) {
									subscribers = SPMailCampaignSubscribersLocalServiceUtil.findByEmailAddress(
											blackLst.getEmailAddress(), c, tCount);
									if(tCount < c){
										subscribers = SPMailCampaignSubscribersLocalServiceUtil.findByEmailAddress(
												blackLst.getEmailAddress(), tCount,c);
									}
								}
							}
						} else if ((Long.parseLong(mailStatusId) < 0)) {
							listCount = SPMailCampaignSubscribersLocalServiceUtil.countByCampaignId(Long
									.parseLong(campaignId));
							_log.error("listCount5 " + listCount);
							if (listCount > tCount)
								isList = "true";
							subscribers = SPMailCampaignSubscribersLocalServiceUtil.findByCampaignId(
									Long.parseLong(campaignId), c, tCount);
							if(tCount < c){
								subscribers = SPMailCampaignSubscribersLocalServiceUtil.findByCampaignId(
										Long.parseLong(campaignId), tCount,c);
							}
							_log.error("subscribers listCount5 " + subscribers.size());
						}
					}
				}
			}
			if (subscribers != null) {
				SPMailCampaignEDM edm;
				for (SPMailCampaignSubscribers subscriber : subscribers) {
					_log.info("mailCampaign " + subscriber + " id " + subscriber.getSpMailCampaignSubscribersId());
					SPMailCampaign mCamp = null;
					JSONObject mailSubscriberJsonObject = JSONFactoryUtil.createJSONObject();
					//JSONObject subscriberJsonObject = JSONFactoryUtil.createJSONObject();
					try {
						mCamp = SPMailCampaignLocalServiceUtil.getSPMailCampaign(subscriber.getSpMailCampaignId());
					} catch (Exception e) {

					}
					mailSubscriberJsonObject.put("cName", mCamp.getCampaignName());
					int mailTypeSeq = subscriber.getSpMailType();
					if(mailTypeSeq >  MailConst.SEQ_NO_START){
						try{
							edm = SPMailCampaignEDMLocalServiceUtil.findByCampaignIdMailType(subscriber.getSpMailCampaignId(), subscriber.getSpMailType());
							mailSubscriberJsonObject.put("mailType", edm.getName());
						}catch(Exception ex){
							_log.error("Error while fetching edm for campaignId, seqn = " +spMailCampaign.getSpMailCampaignId() + "," + mailTypeSeq);
						}
						
					}else{
						switch (subscriber.getSpMailType()) {
						case 0:
							mailSubscriberJsonObject.put("mailType", "Main");
							break;
						case 1:
							mailSubscriberJsonObject.put("mailType", "Reminder1");
							break;
						case 2:
							mailSubscriberJsonObject.put("mailType", "Reminder2");
							break;
						case 3:
							mailSubscriberJsonObject.put("mailType", "Reminder3");
							break;
						}
						
					}
					mailSubscriberJsonObject.put("fName", subscriber.getFirstName());
					mailSubscriberJsonObject.put("lName", subscriber.getLastName());
					mailSubscriberJsonObject.put("email", subscriber.getEmailAddress());
					if (subscriber.getOpened()) {
						mailSubscriberJsonObject.put("Opened", "Opened");
					} else {
						try {
							SPMailBlackList blkList = SPMailBlackListLocalServiceUtil.findByEmailAddress(subscriber
									.getEmailAddress());
							if (blkList != null) {
								boolean bounced = blkList.getBounced();
								boolean bouncedSoft = blkList.getBounce_soft();
								boolean Complain = blkList.getComplain();
								if (bounced) {
									mailSubscriberJsonObject.put("Opened", "Bounced");
								} else if (bouncedSoft) {
									mailSubscriberJsonObject.put("Opened", "Bounced-Soft");
								} else if (Complain) {
									mailSubscriberJsonObject.put("Opened", "Complain");
								}
							}
						} catch (Exception e) {
							mailSubscriberJsonObject.put("Opened", "Not-Opened");
							_log.error("no Black mail list found for the mail " + e.getMessage());
						}
					}

					switch (subscriber.getStatus()) {
					case 0:
						mailSubscriberJsonObject.put("status", "Not_Scheduled");
						break;
					case 1:
						mailSubscriberJsonObject.put("status", "Scheduled");
						break;
					case 2:
						mailSubscriberJsonObject.put("status", "Processing");
						break;
					case 3:
						mailSubscriberJsonObject.put("status", "Sent");
						break;
					}
					mailSubscriberJsonObject.put("statusValue", subscriber.getStatus());
					mailSubscriberJsonObject.put("listCount", listCount);
					mailSubscriberJsonObject.put("isList", isList);
					mailSubscriberJsonObject.put("tCount", tCount);
					_log.error("isList " + isList + " listCount " + listCount);
					subscriberJsonObject.put(String.valueOf(subscriber.getSpMailCampaignSubscribersId()),
							mailSubscriberJsonObject);
				}
			} else {
				SPMailCampaign mCamp = null;
				JSONObject mailSubscriberJsonObject = JSONFactoryUtil.createJSONObject();
				//JSONObject subscriberJsonObject = JSONFactoryUtil.createJSONObject();
				try {
					mCamp = SPMailCampaignLocalServiceUtil.getSPMailCampaign(spMailCampaign.getSpMailCampaignId());
				} catch (Exception e) {

				}
				mailSubscriberJsonObject.put("cName", mCamp.getCampaignName());
				switch (spMailCampaign.getSpMailType()) {
				case 0:
					mailSubscriberJsonObject.put("mailType", "Main");
					break;
				case 1:
					mailSubscriberJsonObject.put("mailType", "Reminder1");
					break;
				case 2:
					mailSubscriberJsonObject.put("mailType", "Reminder2");
					break;
				case 3:
					mailSubscriberJsonObject.put("mailType", "Reminder3");
					break;
				}
				mailSubscriberJsonObject.put("fName", spMailCampaign.getFirstName());
				mailSubscriberJsonObject.put("lName", spMailCampaign.getLastName());
				mailSubscriberJsonObject.put("email", spMailCampaign.getEmailAddress());
				if (spMailCampaign.getOpened()) {
					mailSubscriberJsonObject.put("Opened", "Opened");
				} else {
					try {
						SPMailBlackList blkList = SPMailBlackListLocalServiceUtil.findByEmailAddress(spMailCampaign
								.getEmailAddress());
						if (blkList != null) {
							boolean bounced = blkList.getBounced();
							boolean bouncedSoft = blkList.getBounce_soft();
							boolean Complain = blkList.getComplain();
							if (bounced) {
								mailSubscriberJsonObject.put("Opened", "Bounced");
							} else if (bouncedSoft) {
								mailSubscriberJsonObject.put("Opened", "Bounced-Soft");
							} else if (Complain) {
								mailSubscriberJsonObject.put("Opened", "Complain");
							}
						}
					} catch (Exception e) {
						mailSubscriberJsonObject.put("Opened", "Not-Opened");
						_log.error("no Black mail list found for the mail " + e.getMessage());
					}
				}

				switch (spMailCampaign.getStatus()) {
				case 0:
					mailSubscriberJsonObject.put("status", "Not_Scheduled");
					break;
				case 1:
					mailSubscriberJsonObject.put("status", "Scheduled");
					break;
				case 2:
					mailSubscriberJsonObject.put("status", "Processing");
					break;
				case 3:
					mailSubscriberJsonObject.put("status", "Sent");
					break;
				}
				mailSubscriberJsonObject.put("statusValue", spMailCampaign.getStatus());
				mailSubscriberJsonObject.put("listCount", listCount);
				mailSubscriberJsonObject.put("isList", isList);
				_log.info("isList " + isList + " listCount " + listCount);
				subscriberJsonObject.put(String.valueOf(spMailCampaign.getSpMailCampaignSubscribersId()),
						mailSubscriberJsonObject);
				_log.info("subscriberJsonObject " + subscriberJsonObject);
			}

		} catch (Exception e) {
			_log.error(e.getMessage());
		}
		resourceResponse.getWriter().append(subscriberJsonObject.toString());
	}

	@Override
	public void processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException,
			PortletException {
		String[] selectedCampaign = actionRequest.getParameterValues("mailSelectCkhs");
		String mailStatus = actionRequest.getParameter("mailSchStatus");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String viewStatus = "";
		long campaignId = 0;
		try {
			if (selectedCampaign != null) {
				for (int i = 0; i < selectedCampaign.length; ++i) {
					campaignId = Long.parseLong(selectedCampaign[i]);
					viewStatus = actionRequest.getParameter("viewSatus_" + campaignId);
					long spMailCampaignSubscribersId = CounterLocalServiceUtil
							.increment("SPMailCampaignSubscribers.class");
					SPMailCampaignSubscribers spMailCampaignSubscribers = SPMailCampaignSubscribersLocalServiceUtil
							.createSPMailCampaignSubscribers(spMailCampaignSubscribersId);
					SPMailCampaignSubscribers spMailCampaignSubscribersExt = SPMailCampaignSubscribersLocalServiceUtil
							.getSPMailCampaignSubscribers(campaignId);
					spMailCampaignSubscribers.setAreaCode(spMailCampaignSubscribersExt.getAreaCode());
					spMailCampaignSubscribers.setCity(spMailCampaignSubscribersExt.getCity());
					spMailCampaignSubscribers.setCountryName(spMailCampaignSubscribersExt.getCountryName());
					spMailCampaignSubscribers.setCreateBy(themeDisplay.getUserId());
					spMailCampaignSubscribers.setCreateDate(new Date());
					spMailCampaignSubscribers.setEmailAddress(spMailCampaignSubscribersExt.getEmailAddress());
					spMailCampaignSubscribers.setFirstName(spMailCampaignSubscribersExt.getFirstName());
					spMailCampaignSubscribers.setIpAddress(spMailCampaignSubscribersExt.getIpAddress());
					spMailCampaignSubscribers.setLastName(spMailCampaignSubscribersExt.getLastName());
					spMailCampaignSubscribers.setLatitude(spMailCampaignSubscribersExt.getLatitude());
					spMailCampaignSubscribers.setLongitude(spMailCampaignSubscribersExt.getLongitude());
					spMailCampaignSubscribers.setMessageId("");
					spMailCampaignSubscribers.setModifiedBy(themeDisplay.getUserId());
					spMailCampaignSubscribers.setModifiedDate(new Date());
					spMailCampaignSubscribers.setOpened(false);
					spMailCampaignSubscribers.setOpenedDate(null);
					spMailCampaignSubscribers.setParentSubscriberId(spMailCampaignSubscribersExt
							.getParentSubscriberId());
					spMailCampaignSubscribers.setRegionName(spMailCampaignSubscribersExt.getRegionName());
					spMailCampaignSubscribers.setSpMailCampaignId(spMailCampaignSubscribersExt.getSpMailCampaignId());
					spMailCampaignSubscribers.setUserId(themeDisplay.getUserId());
					spMailCampaignSubscribers.setWebVersion(spMailCampaignSubscribersExt.getWebVersion());
					switch (Integer.parseInt(mailStatus)) {
					case 0:
						spMailCampaignSubscribers.setSpMailType(0);
						break;
					case 1:
						spMailCampaignSubscribers.setSpMailType(1);
						break;
					case 2:
						spMailCampaignSubscribers.setSpMailType(2);
						break;
					case 3:
						spMailCampaignSubscribers.setSpMailType(3);
						break;
					case 4:
						spMailCampaignSubscribers.setSpMailType(4);
						break;
					case 5:
						spMailCampaignSubscribers.setSpMailType(5);
						break;
					}
					spMailCampaignSubscribers.setStatus(1);
					SPMailCampaignSubscribersLocalServiceUtil.addSPMailCampaignSubscribers(spMailCampaignSubscribers);
				}
			}
		} catch (Exception e) {
			_log.error(e.getMessage());
		}
	}

}
