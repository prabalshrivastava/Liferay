package com.sambaash.platform.portlet.spinbox.helper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletRequest;
import javax.portlet.ResourceRequest;

import com.liferay.portal.NoSuchUserException;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.SortFactoryUtil;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.sambaash.platform.model.notification.NotificationForm;
import com.sambaash.platform.portlet.spinbox.comparator.IBMessageCreateDateComparator;
import com.sambaash.platform.portlet.spinbox.comparator.IBMessageDetailReceiveDateComparator;
import com.sambaash.platform.srv.spgroup.service.SPGroupLocalServiceUtil;
import com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException;
import com.sambaash.platform.srv.spinbox.NoSuchIBMessageException;
import com.sambaash.platform.srv.spinbox.model.IBMessage;
import com.sambaash.platform.srv.spinbox.model.IBMessageDetail;
import com.sambaash.platform.srv.spinbox.service.IBMessageDetailLocalServiceUtil;
import com.sambaash.platform.srv.spinbox.service.IBMessageLocalServiceUtil;
import com.sambaash.platform.util.NotificationUtils;
import com.sambaash.platform.util.SambaashUtil;

public class InboxRequestHelper {
	
	private final static Log logger = LogFactoryUtil.getLog(InboxRequestHelper.class);
	
	
	public static int getPageCount(int totalRows, int pageSize){
		int pageCount = 0;
		if(pageSize != 0){
			pageCount = totalRows / pageSize;
			
			if(totalRows % pageSize != 0){
				pageCount += 1;
			}
			
		}
		return pageCount;
	}
	public static JSONObject setUnreadCounts(User user,long scopeGrpId){
		JSONObject unread = JSONFactoryUtil.createJSONObject();
		unread.put("unreadInbCount", getUnreadCount(user, scopeGrpId));
		unread.put("unreadReqCount", getUnReadRequestCount(user, scopeGrpId));
		unread.put("unreadNotfCount", getUnReadNotificationCount(user, scopeGrpId));
		unread.put("unreadInvCount", getUnReadInviteCount(user, scopeGrpId));
		unread.put("unreadGrpAlertCount", getUnReadGroupsAlertCount(user, scopeGrpId));
		unread.put("unreadJobAlertCount", getUnReadJobsAlertCount(user, scopeGrpId));
		
		return unread;
		
	}
	
	static String totalPageCountStr = "totalPageCount";
	static String pageSizeStr = "pageSize";
	static String totalMails = "totalMails";
	static String currentPage = "currentPage";
	static int pageSize = 10;
	
	private static String getMailCategory(String subcategory){
		String mailCategory= "";
		if (InboxConstants.MAIL_TYPE_REQUEST.equalsIgnoreCase(subcategory)) {
			mailCategory = InboxConstants.MAIL_TYPE_REQUEST;
		}
		if (InboxConstants.MAIL_TYPE_INVITATION.equalsIgnoreCase(subcategory)) {
			mailCategory = InboxConstants.MAIL_TYPE_INVITATION;
		}
		if (InboxConstants.MAIL_TYPE_NOTIFICATION.equalsIgnoreCase(subcategory)) {
			mailCategory = InboxConstants.MAIL_TYPE_NOTIFICATION;
		}
		if (InboxConstants.MAIL_TYPE_REPORT_ALERT.equalsIgnoreCase(subcategory)) {
			mailCategory = InboxConstants.MAIL_TYPE_REPORT_ALERT;
		}
		if (InboxConstants.MAIL_TYPE_JOBS_ALERT.equalsIgnoreCase(subcategory)) {
			mailCategory = InboxConstants.MAIL_TYPE_JOBS_ALERT;
		}
		return mailCategory;
	}
	public static JSONObject getMyInboxList(PortletRequest request) throws SystemException, PortalException {
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		
		String category = ParamUtil.getString(request, "category");
		String subcategory = ParamUtil.getString(request, "subcategory");
		int pageNum = ParamUtil.getInteger(request, "pageNum");
		String selectedFilterTag = ParamUtil.getString(request, "filter"); 
		boolean getUnreads = ParamUtil.getBoolean(request, "getUnreadCounts"); 
		
		JSONObject data = JSONFactoryUtil.createJSONObject();
		if (themeDisplay.isSignedIn()) {
			
			long userId = themeDisplay.getUserId();
			User user = themeDisplay.getUser();
			String receiverMsgStatus = "";
			String senderMsgStatus = "";

			if(getUnreads){
				data.put("unreadObj", setUnreadCounts(user, themeDisplay.getScopeGroupId()));
			}
			if (InboxUtil.UNREAD.equalsIgnoreCase(selectedFilterTag)) {
				receiverMsgStatus = InboxUtil.UNREAD;
			} else if (InboxUtil.READ.equalsIgnoreCase(selectedFilterTag)) {
				receiverMsgStatus = InboxUtil.READ;
			} else if (InboxUtil.REPLIED.equalsIgnoreCase(selectedFilterTag)) {
				senderMsgStatus = InboxUtil.REPLIED;
			} else if (InboxUtil.FORWARDED.equalsIgnoreCase(selectedFilterTag)) {
				senderMsgStatus = InboxUtil.FORWARDED;
			}
			boolean archived = false;
			String mailCategory = StringPool.BLANK;
			if(category.equalsIgnoreCase(InboxConstants.INBOX)){
				mailCategory= getMailCategory(subcategory);
			}
			if(category.equalsIgnoreCase(InboxConstants.ARCHIVED)){
				archived = true;
			}

			int totalRow = 0;

			if (InboxConstants.DRAFTS.equalsIgnoreCase(category)) {
				totalRow = IBMessageLocalServiceUtil.findByCreateUserIdAndDraft(user, String.valueOf(userId), false, true).size();
			}else if(InboxConstants.SENT.equalsIgnoreCase(category)){
				totalRow = IBMessageLocalServiceUtil.findByCreateUserId(user, String.valueOf(userId), false).size();
			}else {
				totalRow = IBMessageDetailLocalServiceUtil.getAvailableMDListByReceiveId(user, userId, archived,
						mailCategory, receiverMsgStatus, senderMsgStatus, -1, -1,
						new IBMessageDetailReceiveDateComparator(), themeDisplay.getScopeGroupId()).size();
			}
			int totalPageCount = getPageCount(totalRow, pageSize);
			//-1 used to indicate last page
			if(pageNum == -1 || pageNum < 0){
				pageNum = totalPageCount;
			}
			if(pageNum > totalPageCount){
				pageNum = totalPageCount;
			}
			if(pageNum < 1){
				pageNum = 1;
			}
			
			int start = (pageNum-1) * pageSize + 1;
			int end = start + pageSize - 1;
			
			int startIndex = start - 1;
			int endIndex = end ;
		
			data.put(totalPageCountStr, totalPageCount);
			data.put(pageSizeStr, pageSize);
			data.put(totalMails, totalRow);
			data.put(currentPage, pageNum);
			data.put("start", start);
			
			JSONArray mails = JSONFactoryUtil.createJSONArray();
			
			if(InboxConstants.DRAFTS.equalsIgnoreCase(category)){
				List<IBMessage> myDraftList = new ArrayList<IBMessage>();

				myDraftList = IBMessageLocalServiceUtil.findByCreateUserIdAndDraft(user, String.valueOf(userId), false, true, startIndex,
						endIndex, new IBMessageCreateDateComparator());
			
				for(IBMessage message : myDraftList){
					mails.put(convertToJson(message, themeDisplay.getUser().getFullName(),themeDisplay.getCompanyId()));
				}
			}else if(InboxConstants.SENT.equalsIgnoreCase(category)){
				List<IBMessage> sent = new ArrayList<IBMessage>();
				sent = IBMessageLocalServiceUtil.findByCreateUserId(user, String.valueOf(userId), false, startIndex,
						endIndex, new IBMessageCreateDateComparator());
				for(IBMessage message : sent){
					mails.put(convertToJson(message, themeDisplay.getUser().getFullName(),themeDisplay.getCompanyId()));
				}
			
			}
			else{
				List<IBMessageDetail> myInboxList = new ArrayList<IBMessageDetail>();
				myInboxList = IBMessageDetailLocalServiceUtil.getAvailableMDListByReceiveId(user, userId, archived,
						mailCategory, receiverMsgStatus, senderMsgStatus, startIndex,end, new IBMessageDetailReceiveDateComparator(),themeDisplay.getScopeGroupId());
				
				for (int i = 0; i < myInboxList.size(); i++) {
					IBMessageDetail msgDetail = (IBMessageDetail) myInboxList.get(i);
					try {
						IBMessage message = IBMessageLocalServiceUtil.getIBMessage(msgDetail.getMessageId());
						
						mails.put(convertToJson(message, msgDetail, themeDisplay.getUser().getEmailAddress(),themeDisplay.getCompanyId()));
					} catch (NoSuchIBMessageException e) {
						logger.info("No IBMessage exists with the primary key " + msgDetail.getMessageId());
					}catch(Exception ex){
						logger.error(ex);
					}
				}
			}
			
			
			data.put("end", start + mails.length()-1);
			data.put("mails", mails);
		}
		return data;
	}
	
	public static void setMsgData(IBMessage message ,PortletRequest request){
		Map<String,String>msg = new HashMap<String,String>();
		ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);
		if(Validator.isNotNull(message)){
			msg.put("from",message.getFrom());
			msg.put("to", getNameAndEmail( themeDisplay.getCompanyId(),message.getTo()));
			msg.put("messageId", String.valueOf(message.getMessageId()));
			msg.put("parentMessageId", String.valueOf(message.getParentMessageId()));
			//msg.put("date", message.getCreateDate());
			msg.put("subject", message.getSubject());
			msg.put("content",message.getContent());
			msg.put("sendBy",message.getCreateBy());
			msg.put("allowOpen", String.valueOf(message.isAllowOpen()));
			msg.put("sentMeCopy", String.valueOf(message.getSentMeCopy()));
		}
		
		request.setAttribute("msg", msg);
	}
	public static JSONObject convertToJson(IBMessage message ,String loggedInUserEmail,long companyId){
		JSONObject json = JSONFactoryUtil.createJSONObject();
		try{
			json.put("from",getFullName(companyId, message.getFrom()));
			json.put("fromEmail",message.getFrom());
			json.put("to",getNameAndEmail( companyId,message.getTo()));
			json.put("msgId",message.getMessageId());
			json.put("parentMessageId",message.getParentMessageId());
			json.put("date",message.getCreateDate());
			json.put("subject", message.getSubject());
			json.put("content",message.getContent());
			json.put("sendBy",message.getCreateBy());
			json.put("allowOpen", message.isAllowOpen());
			json.put("sentMeCopy", message.getSentMeCopy());
			json.put("rowId", message.getMessageId());
			json.put("draft", message.getDraft());
		}catch(Exception ex){
			logger.error(ex);
		}
		return json;
	}
		
	public static JSONObject convertToJson(IBMessage message, IBMessageDetail msgDetail,String loggedInUserEmail,long companyId){
		JSONObject json = JSONFactoryUtil.createJSONObject();
		try{
			json.put("from",getFullName(companyId,message.getFrom()));
			json.put("fromEmail",message.getFrom());
			json.put("to", getNameAndEmail(companyId, getViewTo(message.getTo(), message.getAllowOpen(), message.getFrom(),loggedInUserEmail)));
			json.put("msgId", message.getMessageId());
			json.put("msgDetailId", msgDetail.getIbMsgDetailId());
			json.put("parentMsgId",message.getParentMessageId());
			json.put("date",msgDetail.getReceiveDate());
			if (InboxConstants.MAIL_TYPE_REQUEST.equalsIgnoreCase(msgDetail.getCategory())) {
				json.put("processId",msgDetail.getProcessId());
			}
			if (InboxConstants.MAIL_TYPE_INVITATION.equalsIgnoreCase(msgDetail.getCategory())) {
				json.put("processId",msgDetail.getProcessId());
				json.put("to",loggedInUserEmail);
			}
			if (InboxConstants.MAIL_TYPE_REPORT_ALERT.equalsIgnoreCase(msgDetail.getCategory())) {
				json.put("processId",msgDetail.getProcessId());
				json.put("to",loggedInUserEmail);
			}
			json.put("content",message.getContent());
			json.put("subject", message.getSubject());
			json.put("sendBy",message.getCreateBy());
			json.put("rowId", msgDetail.getIbMsgDetailId());
			json.put("allowOpen", message.isAllowOpen());
			json.put("sentMeCopy", message.getSentMeCopy());
			json.put("status", msgDetail.getStatus());
			json.put("category" ,msgDetail.getCategory());
			if (Validator.isNotNull(msgDetail.getStatus())) {
				json.put("showStatus", true);
			} else {
				json.put("showStatus" ,false);
			}

			if ("read".equalsIgnoreCase(msgDetail.getReceiverMsgStatus())) {
				json.put("read",true);
			} else if ("unread".equalsIgnoreCase(msgDetail.getReceiverMsgStatus())) {
				json.put("unread", true);
			}
			if ("replied".equalsIgnoreCase(msgDetail.getSenderMsgStatus())) {
				json.put("replied", true);
			}
			if ("repliedfromsender".equalsIgnoreCase(msgDetail.getSenderMsgStatus())) {
				json.put("repliedfromsender", true);
			}
		
		}catch(Exception ex){
			logger.error(ex);
		}
		return json;
	}

	public static String getFullName(long companyId,String email){
		String name = email;
		try{
			 User user = UserLocalServiceUtil.getUserByEmailAddress(companyId, email);
			 name = user.getFullName();
		}catch(Exception ex){
			logger.error("Error while getting user name");
		}
		return name;
	}
	public static String getViewTo(String to, boolean allowOpen, String from,String loggedInUserEmail) {
		if (allowOpen) {
			return to;
		} else {
			if (from.equalsIgnoreCase(loggedInUserEmail)) {
				return to;
			} else {
				return loggedInUserEmail;
			}
		}
	}
	
	public static String getNameAndEmail(long companyId,String emailIds){
		StringBuilder sb = new StringBuilder();
		if(Validator.isNotNull(emailIds)){
			String ids[] = emailIds.trim().split(StringPool.COMMA);
			for(int i =0; i < ids.length; i++){
				String id = ids[i];
				if(Validator.isNotNull(id)){
					try{
						 User user =   UserLocalServiceUtil.getUserByEmailAddress(companyId, id);
						 sb.append(user.getFullName());
						 sb.append("(" + user.getEmailAddress() + ")");
						 if(i +1  != ids.length){
							 sb.append(StringPool.COMMA);
						 }
					}catch(Exception ex){
						logger.error(ex);
					}
				}
			}
		}
		return sb.toString();
	}
	
	public static List<Long> archieveMessageDetails(List<Long>msgDetailsIds){
		List<Long>failed = null;
		if(Validator.isNotNull(msgDetailsIds)){
			for (long id : msgDetailsIds) {
				try{
					 IBMessageDetail details = IBMessageDetailLocalServiceUtil.getIBMessageDetail(id);
					 details.setArchived(true);
					 IBMessageDetailLocalServiceUtil.updateIBMessageDetail(details);
				}catch(Exception ex){
					logger.error(ex);
					if(Validator.isNull(failed)){
						failed = new ArrayList<Long>();
					}
					failed.add(id);
				}
			}
		}
		return failed;
	}
	
	public static IBMessage saveAsDraft(PortletRequest request) {
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		IBMessage message = null;
		try {
			if (themeDisplay.isSignedIn()) {
				Date now = new Date();
				String from =  themeDisplay.getUser().getEmailAddress();//ParamUtil.getString(request, "from");
				String to = ParamUtil.getString(request, "to");
				String subject = ParamUtil.getString(request, "subject");
				String content = ParamUtil.getString(request, "content");
				boolean isAllowOpen = ParamUtil.getBoolean(request, "allowOpen");
				boolean isSentMeCopy = ParamUtil.getBoolean(request, "sentMeCopy");
				boolean isForward = ParamUtil.getBoolean(request, "forward");
				boolean isReply = ParamUtil.getBoolean(request, "reply");

				long messageId = ParamUtil.getLong(request, "msgId");
				long parentMessageId = ParamUtil.getLong(request, "parentMsgId");
				long parentMsgDetailId = ParamUtil.getLong(request, "parentMsgDetailId");
				String category = ParamUtil.getString(request, "category");
				String draftStatus = "";
				
				if (Validator.isNull(category)) {
					category = "message";
				}
				if (Validator.isNull(subject)) {
					subject = "no subject";
				}
				if (isForward || isReply) {
					draftStatus = String.valueOf(parentMsgDetailId);
				}
				long groupId = themeDisplay.getScopeGroupId();
				long companyId = themeDisplay.getCompanyId();

				User fromUser = themeDisplay.getUser();
				long fromUserId = fromUser.getUserId();
				LiferayMixUserWrapper fromUserWrapper = new LiferayMixUserWrapper(fromUser);
				String createBy = fromUserWrapper.getFullName();
				if (InboxUtil.isCorporateUser(fromUser.getUserId())) {
					fromUserId = 0;
				}
				String createByUserId = String.valueOf(fromUserId);

				// Save IBMessage As Draft
				if (messageId>0) {
					 message = IBMessageLocalServiceUtil.getIBMessage(messageId);

					message.setTo(to);
					message.setFrom(from);
					message.setAllowOpen(isAllowOpen);
					message.setSentMeCopy(isSentMeCopy);
					message.setSubject(subject);
					message.setContent(content);

					message.setDraft(message.getDraft());
					message.setDraftStatus(message.getDraftStatus());
					IBMessageLocalServiceUtil.updateIBMessage(message);

				}else{
					message = IBMessageLocalServiceUtil.addMessage(null, parentMessageId, groupId, companyId, subject, content,
							now, from, to, createBy, createByUserId, isAllowOpen, true, draftStatus, isSentMeCopy, false, 0);
				}

			} else {
			}
		} catch (Exception e) {
			logger.error(e);
		}
		return message;
	}
	
	public static String sendMessage(PortletRequest request) throws PortalException, SystemException {
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		Date now = new Date();
		String from =  themeDisplay.getUser().getEmailAddress();//ParamUtil.getString(request, "from");
		String to = ParamUtil.getString(request, "to");
//		to = escapeTo(to);
		String result = StringPool.BLANK;
		if (Validator.isNull(to)) {
			result = "Please specify at least one recipient.";
			return result;
		}
		String subject = ParamUtil.getString(request, "subject");
		String content = ParamUtil.getString(request, "content");
		boolean isAllowOpen = ParamUtil.getBoolean(request, "allowOpen");
		boolean isSentMeCopy = ParamUtil.getBoolean(request, "sentMeCopy");
		String parentMsgStatus = ParamUtil.getString(request, "parentMsgStatus");
		boolean isReply = false;
		boolean isForward = false;
		if("replied".equalsIgnoreCase(parentMsgStatus)){
			isReply = true;
		}
		if("forwarded".equalsIgnoreCase(parentMsgStatus)){
			isForward = true;
		}
		long parentMessageId = ParamUtil.getLong(request, "parentMsgId");
		long parentMsgDetailId = ParamUtil.getLong(request, "parentMsgDetailId");
		long messageId = ParamUtil.getLong(request, "msgId");
		String category = ParamUtil.getString(request, "category");
		
		if (Validator.isNull(category)) {
			category = "message";
		}
		if (Validator.isNull(subject)) {
			subject = "(no subject)";
		}

		long groupId = themeDisplay.getScopeGroupId();
		long companyId = themeDisplay.getCompanyId();

		try {
			
			String[] toIds = to.split(StringPool.COMMA) ;
			List<String>toEmailIds = ListUtil.toList(toIds);
			if (themeDisplay.isSignedIn()) {

				if (toIds.length > 50) {
					result = "You only can add as many as 50 recipients from your connection at one time.";
					return result;
				}

				List<String> wrongEmails = checkAllUserExist(toEmailIds,companyId);
				if (wrongEmails.size()<=0) {

				User fromUser = themeDisplay.getUser();
				long userId = fromUser.getUserId();
				from = fromUser.getEmailAddress();
				String createBy = fromUser.getFullName();
				String createByUserId = String.valueOf(userId);

				IBMessage message = null;
				if (messageId > 0) {
					message = IBMessageLocalServiceUtil.getIBMessage(messageId);

					if (message.isDraft()) {
						if (Validator.isNotNull(message.getDraftStatus())){
							parentMsgDetailId = GetterUtil.getLong(message.getDraftStatus());
						}
					}
					message.setTo(to);
					message.setFrom(from);
					message.setAllowOpen(isAllowOpen);
					message.setSentMeCopy(isSentMeCopy);
					message.setSubject(subject);
					message.setContent(content);

					message.setDraft(false);
					message.setDraftStatus(null);
					IBMessageLocalServiceUtil.updateIBMessage(message);
					Indexer indexer = IndexerRegistryUtil.getIndexer(IBMessage.class);
					indexer.reindex(message);
				}else{
					// add IBMessage
					message = IBMessageLocalServiceUtil.addMessage(null,
							parentMessageId, groupId, companyId, subject, content,
							now, from, to, createBy, createByUserId, isAllowOpen, false, "", isSentMeCopy, false, 0);
					result="success";
					Indexer indexer = IndexerRegistryUtil.getIndexer(IBMessage.class);
					indexer.reindex(message);
				}
			
				if (parentMsgDetailId > 0) {
					IBMessageDetail parentMsgDetail = IBMessageDetailLocalServiceUtil
							.getIBMessageDetail(parentMsgDetailId);
					if (isReply && message.getParentMessageId() > 0) {
						parentMsgDetail.setSenderMsgStatus("replied");
					}else if(isForward && message.getParentMessageId() > 0){
						parentMsgDetail.setSenderMsgStatus("forwarded");
					}
					IBMessageDetailLocalServiceUtil.updateIBMessageDetail(parentMsgDetail);
				}

				// add IBMessageDetail

				if (isSentMeCopy) {
					if (!toEmailIds.contains(new String(from))) {
						toEmailIds.add(from);
					}
				}
				for (int i = 0; i < toEmailIds.size(); i++) {
					try{
						String email = toEmailIds.get(i).trim();
						User toUser = null;
						long toUserId = 0;
						long corpProfileId = 0;
						List<String>screenNames = new ArrayList<String>();
						try{
							toUser = UserLocalServiceUtil.getUserByEmailAddress(
									themeDisplay.getCompanyId(), toEmailIds.get(i).trim());
							screenNames.add(toUser.getScreenName());
							toUserId = toUser.getUserId();
						}catch(NoSuchUserException nsue) {
							continue;
						}

						String senderMsgStatus = "";
//						
						LiferayMixUserWrapper toUserWrapper = new LiferayMixUserWrapper(toUserId, corpProfileId);

						IBMessageDetail msgDetails = IBMessageDetailLocalServiceUtil.addMessageDetail(message.getMessageId(), toUserId,
								toUserWrapper.getFullName(), now, category, false, null, null,
								"unread", senderMsgStatus, "", 0, toUserWrapper.getCorpProfileId());

						String communityName = SambaashUtil.getCommunityName(themeDisplay.getScopeGroupId());
						NotificationForm form = new NotificationForm(NotificationUtils.UNREAD,communityName,message.getSubject(), message.getContent(),
								StringPool.BLANK, String.valueOf(msgDetails.getIbMsgDetailId()), screenNames);
						form.setFrom(themeDisplay.getUser().getEmailAddress());
						form.setTarget("inbox");
						//form.setDate(message.getCreateDate());
						SPGroupLocalServiceUtil.pushRealtimeActivityFeed(form);
						
					}catch(Exception ex){
						logger.error(ex);
					}
				}
				result = "success";


				}else{
					StringBuilder sb = new StringBuilder();
					//sb.append("Sorry, ");
					for (int w=0; w<wrongEmails.size(); w++) {
						if (w==0) {
							sb.append("\" "+wrongEmails.get(w)+" \"");
						}else{
							sb.append(", "+"\" "+wrongEmails.get(w)+" \"");
						}
					}
					if (wrongEmails.size()==1) {
						sb.append(" is invalid address. Please make sure that all addresses are correct from your connection.");
					}else{
						sb.append(" are invalid addresses. Please make sure that all addresses are correct from your connection.");
					}
					result = sb.toString();
				}
			} else {
				result = "Sorry, please sign in first.";
			}

		} catch (Exception e) {
			logger.error(e);
		}
		return result;
	}
	
	public static JSONObject search(PortletRequest request){
		ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);
		List<IBMessage> searchList = searchMessages(request);
		String category = ParamUtil.getString(request, "category");
		String subcategory = ParamUtil.getString(request, "subcategory");
		String selectedFilterTag = ParamUtil.getString(request, "filter");
		boolean archived = false;
		boolean inbox = false;
		String mailCategory = StringPool.BLANK;
		if(category.equalsIgnoreCase(InboxConstants.INBOX)){
			inbox = true;
			mailCategory= getMailCategory(subcategory);
		}
		if(InboxConstants.ARCHIVED.equalsIgnoreCase(category)){
			archived = true;
		}
		
		List<IBMessageDetail>detailList = new ArrayList<IBMessageDetail>();
		if(!InboxConstants.DRAFTS.equalsIgnoreCase(category) && !InboxConstants.SENT.equalsIgnoreCase(category)){
			String  receiverMsgStatus = StringPool.BLANK;
			String  senderMsgStatus = StringPool.BLANK;
			if (InboxUtil.UNREAD.equalsIgnoreCase(selectedFilterTag)) {
				receiverMsgStatus = InboxUtil.UNREAD;
			} else if (InboxUtil.READ.equalsIgnoreCase(selectedFilterTag)) {
				receiverMsgStatus = InboxUtil.READ;
			} else if (InboxUtil.REPLIED.equalsIgnoreCase(selectedFilterTag)) {
				senderMsgStatus = InboxUtil.REPLIED;
			} else if (InboxUtil.FORWARDED.equalsIgnoreCase(selectedFilterTag)) {
				senderMsgStatus = InboxUtil.FORWARDED;
			}
			for(IBMessage msg : searchList){
				try{
					IBMessageDetail detail = IBMessageDetailLocalServiceUtil.findByReceiverIdmessageId(themeDisplay.getUserId(), msg.getMessageId());
					if(archived){
						if (Validator.isNotNull(detail) && detail.isArchived()) {
							if (Validator.isNotNull(receiverMsgStatus)) {
								if (receiverMsgStatus.equalsIgnoreCase(detail.getReceiverMsgStatus())) {
									detailList.add(detail);
								}
							} else if (Validator.isNotNull(senderMsgStatus)) {
								if (senderMsgStatus.equalsIgnoreCase(detail.getSenderMsgStatus())) {
									detailList.add(detail);
								}
							}else{
								detailList.add(detail);
							}
						}
					}
					if(inbox){
						if(Validator.isNotNull(detail)  && !detail.isArchived()){
							if(Validator.isNotNull(mailCategory)){
								if(mailCategory.equalsIgnoreCase(detail.getCategory())){
									if (Validator.isNotNull(receiverMsgStatus)) {
										if (receiverMsgStatus.equalsIgnoreCase(detail.getReceiverMsgStatus())) {
											detailList.add(detail);
										}
									} else if (Validator.isNotNull(senderMsgStatus)) {
										if (senderMsgStatus.equalsIgnoreCase(detail.getSenderMsgStatus())) {
											detailList.add(detail);
										}
									}else{
										detailList.add(detail);
									}
								}
							}else{
								if (Validator.isNotNull(receiverMsgStatus)) {
									if (receiverMsgStatus.equalsIgnoreCase(detail.getReceiverMsgStatus())) {
										detailList.add(detail);
									}
								} else if (Validator.isNotNull(senderMsgStatus)) {
									if (senderMsgStatus.equalsIgnoreCase(detail.getSenderMsgStatus())) {
										detailList.add(detail);
									}
								}else{
									detailList.add(detail);
								}
							}
						}
					}
				}catch(Exception ex){
					logger.error(ex);
				}
			}
		}
		
		
		JSONObject data = JSONFactoryUtil.createJSONObject();
		int totalRow = searchList.size();
		if(InboxConstants.DRAFTS.equalsIgnoreCase(category) || InboxConstants.SENT.equalsIgnoreCase(category)){
			 totalRow = searchList.size();
		}else {
			totalRow = detailList.size();
		}
		int totalPageCount = getPageCount(totalRow, pageSize);
		int pageNum = ParamUtil.getInteger(request, "pageNum");
		//-1 used to indicate last page
		if(pageNum == -1){
			pageNum = totalPageCount;
		}
		int start = (pageNum-1) * pageSize + 1;
		int end = start + pageSize - 1;
		
		int startIndex = start - 1;
		int endIndex = end ;
	
		data.put(totalPageCountStr, totalPageCount);
		data.put(pageSizeStr, pageSize);
		data.put(totalMails, totalRow);
		data.put(currentPage, pageNum);
		data.put("start", start);
		
		User loggedInUser  = themeDisplay.getUser();
		JSONArray mails = JSONFactoryUtil.createJSONArray();
		
		if(InboxConstants.DRAFTS.equalsIgnoreCase(category) || InboxConstants.SENT.equalsIgnoreCase(category)){
			for (int i = startIndex; i<=endIndex && i < searchList.size(); i++ ) {
				try{
					IBMessage msg = searchList.get(i);
					mails.put(convertToJson(msg, loggedInUser.getEmailAddress(),themeDisplay.getCompanyId()));
				}catch(Exception ex){
					logger.error(ex);
				}
			}
		}else{
			for (int i = startIndex; i<=endIndex && i < detailList.size(); i++ ) {
				try{
					IBMessageDetail detail  = detailList.get(i);
					if(Validator.isNotNull(detail) && detail.getMessageId() != 0){
						IBMessage msg =  IBMessageLocalServiceUtil.getIBMessage(detail.getMessageId());
						mails.put(convertToJson(msg, detail, loggedInUser.getEmailAddress(),themeDisplay.getCompanyId()));
					}
				}catch(Exception ex){
					logger.error(ex);
				}
			}
			
		}
		
		data.put("end", start + mails.length()-1);
		data.put("mails", mails);
		return data;
		
		
	}
	
	public static List<IBMessage>  searchMessages(PortletRequest request){
		List<IBMessage> searchList = new ArrayList<IBMessage>();
		ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);
		
		String searchKey = ParamUtil.getString(request, "searchText");
		String category = ParamUtil.getString(request, "category");
		try {
			Indexer indexer = IndexerRegistryUtil.getIndexer(IBMessage.class);

			SearchContext searchContext = new SearchContext();
			searchContext.setStart(-1);
			searchContext.setEnd(-1);
			searchContext.setCompanyId(themeDisplay.getUser().getCompanyId());
			
			Sort sort = SortFactoryUtil.create(Field.CREATE_DATE,false);
			Sort[] sorts = new Sort[] { sort };
			searchContext.setSorts(sorts);
			searchContext.setKeywords(searchKey);
			
			if(Validator.isNotNull(searchKey)){
			/*	String query = "( (fromMail:$[SEARCH_KEY]) OR (toMailS:$[SEARCH_KEY]) OR (subject:$[SEARCH_KEY]) OR (content:$[SEARCH_KEY]) )";
				
				String []terms = searchKey.split(StringPool.BLANK);
				String format = "(%s:%s)";
				StringBuilder sb = new StringBuilder();
				sb.append("( ");
				for(int i = 0 ; i < terms.length ;i++){
					String term = terms[i];
					sb.append(String.format(format, InboxConstants.SEARCH_FIELD,term));
					if(i + 1 != terms.length){
						sb.append(" or ");
					}
				}
				sb.append(" ) ");
				query = StringUtil.replace(query, new String[]{"$[SEARCH_KEY]"}, new String[]{searchKey});
				Query stringQuery = StringQueryFactoryUtil.create(query);
				BooleanClause clause = BooleanClauseFactoryUtil.create(searchContext,stringQuery, BooleanClauseOccur.MUST.getName());
				searchContext.setBooleanClauses(new BooleanClause[] { clause }); */
			}

			Hits results = indexer.search(searchContext);
			
			
			int total = results.getLength();

			for (int i = 0; i < results.getDocs().length; i++) {
				Document doc = results.doc(i);
				long msgId = GetterUtil.getLong(doc.get(Field.ENTRY_CLASS_PK));
				try{
					IBMessage msg = IBMessageLocalServiceUtil.getIBMessage(msgId);
					if(InboxConstants.DRAFTS.equalsIgnoreCase(category)  || InboxConstants.SENT.equalsIgnoreCase(category)){
						if(isAuthorizedToViewSentMsg(msg, themeDisplay.getScopeGroupId(), themeDisplay.getUser())){
							searchList.add(msg);
						}
					}else{
						if(isAuthorizedToViewInboxMsg(msg, themeDisplay.getScopeGroupId(), themeDisplay.getUser())){
							searchList.add(msg);
						}
					}
				}catch(NoSuchIBMessageException e) {
					logger.info("No IBMessage exists with the primary key "+msgId);
				}
			}

		} catch (Exception e) {
			logger.error(e);
		}
		return searchList;
	}
	
	public static boolean isAuthorizedToViewInboxMsg(IBMessage msg, long scopeGroupId,User user){
		boolean auth = false;
		try{
			 if(msg.getTo().toLowerCase().contains(user.getEmailAddress().toLowerCase())){
				 auth = true;
			 }
			 if(SambaashUtil.isAdmin(scopeGroupId, user.getUserId())){
			//	 auth = true;
			 }
		}catch(Exception ex){
			logger.error(ex);
		}
		return auth;
	}
	public static boolean isAuthorizedToViewSentMsg(IBMessage msg, long scopeGroupId,User user){
		boolean auth = false;
		try{
			if(msg.getFrom().equalsIgnoreCase(user.getEmailAddress())){
				auth = true;
			}
			if(SambaashUtil.isAdmin(scopeGroupId, user.getUserId())){
				//	 auth = true;
			}
		}catch(Exception ex){
			logger.error(ex);
		}
		return auth;
	}
	public static JSONObject getMessageDetailThread(PortletRequest request){
		JSONObject json = JSONFactoryUtil.createJSONObject();
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		try{
			long msgDetailId = ParamUtil.getLong(request, "msgDetailId");
			JSONArray array = JSONFactoryUtil.createJSONArray();
			IBMessageDetail msgDetail = IBMessageDetailLocalServiceUtil.getIBMessageDetail(msgDetailId);
			IBMessage msg = IBMessageLocalServiceUtil.getIBMessage(msgDetail.getMessageId());
			while(true){
				array.put(convertToJson(msg, msgDetail,themeDisplay.getUser().getEmailAddress(),themeDisplay.getCompanyId()));
				if(msg.getParentMessageId() == 0){
					break;
				}else{
					long parentMsgId = msg.getParentMessageId();
					msg = IBMessageLocalServiceUtil.getIBMessage(parentMsgId);
					msgDetail = IBMessageDetailLocalServiceUtil.findByReceiverIdmessageId(themeDisplay.getUserId(), parentMsgId);
				}
			}
			json.put("msgs", array);
		}catch(Exception ex){
			logger.error(ex);
		}
		
		return json;
	}
	
	public static List<String> checkAllUserExist(List<String> toEmails,long companyId) throws PortalException, SystemException {
		List<String> wrongEamils = new ArrayList<String>(0);
		for (int i = 0; i < toEmails.size(); i++) {
			if (!InboxUtil.checkUserExist(toEmails.get(i).trim(),companyId)) {
//				if (!InboxUtil.checkCorporateExist(toEmails.get(i).trim())) {
					wrongEamils.add(toEmails.get(i).trim());
//				}
			}
		}
		return wrongEamils;
	}
	
	public static boolean updateMsgStatus(long msgDetailId,String status) throws SystemException, PortalException {
		IBMessageDetail msgDetail = null;
		boolean updated = false;
		try {
			msgDetail = IBMessageDetailLocalServiceUtil.getIBMessageDetail(msgDetailId);
			msgDetail.setReceiverMsgStatus(status);
			IBMessageDetailLocalServiceUtil.updateIBMessageDetail(msgDetail);
			updated = true;
		} catch (NoSuchIBMessageDetailException e) {
			logger.error(e);
		}
		return updated;
	}
	
	public static String findUsers(ResourceRequest resourceRequest, long companyId) throws SystemException, PortalException {

		String q = ParamUtil.getString(resourceRequest, "q");
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);

		JSONObject dataJSONObject = JSONFactoryUtil.createJSONObject();
		if(themeDisplay.isSignedIn()){
			String mailIcon = themeDisplay.getPathThemeImages() + "/send_by_email.png";
			JSONArray itemsJSONArray = JSONFactoryUtil.createJSONArray();
			
			String suggestion = "<div data-autocomplete-dom-id=\"option\" data-user-id=\""
					+ "%d"
					+ "\" data-user-mail=\""
					+ "%s"
					+ "\" %s><div class=\"sp-group-clearfix\"><div class=\"sp-group-lfloat sp-group-mrm\" style=\"line-height: 0;\"><img alt=\"Image\" data-autocomplete-dom-id=\"option-img\" src=\""
					+ "%s"
					+ "\" class=\"sp-group-thumb_32\" /></div><div class=\"sp-group-ui-oh\"><div class=\"sp-group-ui-dib\"><div class=\"sp-group-ui-dib sp-group-ui-vam\" style=\"height:32px;\"></div><div class=\"sp-group-ui-dib sp-group-ui-vam\"><span data-autocomplete-dom-id=\"option-name\" class=\"sp-group-fwb\">"
					+ "%s" + "</span>(<span data-autocomplete-dom-id=\"option-email\" class=\"sp-group-fwb\">" + "%s"
					+ "</span>)</div></div></div></div></div>";
			
			String suggestinByMail = "<div data-autocomplete-dom-id=\"option\" data-user-id=\"0\" class=\"ip-sb-option\"><div class=\"sp-group-clearfix\"><div class=\"sp-group-lfloat sp-group-mrm\" style=\"line-height: 0;\"><img alt=\"Image\" src=\""
					+ mailIcon
					+ "\" class=\"sp-group-thumb_32\" /></div><div class=\"sp-group-ui-oh\"><div class=\"sp-group-ui-dib\"><div class=\"sp-group-ui-dib sp-group-ui-vam\" style=\"height:32px;\"></div><div class=\"sp-group-ui-dib sp-group-ui-vam\"><div class=\"sp-group-ui-lh1 mtxs mbs\">Send an email to</div><div data-autocomplete-dom-id=\"option-email\" class=\"sp-group-ui-lh1 sp-group-fwb\">"
					+ "%s" + "</div></div></div></div></div></div>";
			
			List<User> matchedUsers = new ArrayList<User>();
			DynamicQuery dynamicQuery = DynamicQueryFactoryUtil
					.forClass(User.class, PortalClassLoaderUtil.getClassLoader());
			
			if (Validator.isNotNull(q)) {
				try {
					matchedUsers = getMatchedUsers(q);
					long userId;
					String username;
					String userImage;
					String html;
					String email;
					String htmlClass;
					boolean first = true;
					for (User user : matchedUsers) {
						userId = user.getUserId();
						username = user.getScreenName();
						userImage = "/../image/user_male_portrait?img_id=" + user.getPortraitId();
						email = user.getEmailAddress();
						if (first) {
							first = false;
							htmlClass = "class=\"ip-sb-option hover\"";
						} else {
							htmlClass = "class=\"ip-sb-option\"";
						}
						html = String.format(suggestion, userId, email, htmlClass, userImage,
								username, email);
						JSONObject htmlJSONObject = JSONFactoryUtil.createJSONObject();
						htmlJSONObject.put("html", html);
						itemsJSONArray.put(htmlJSONObject);
					}
					
				} catch (Exception nsue) {
					String email = q;
					String html = String.format(suggestinByMail, email);
					JSONObject htmlJSONObject = JSONFactoryUtil.createJSONObject();
					htmlJSONObject.put("html", html);
					itemsJSONArray.put(htmlJSONObject);
				}
			} else {
			}
			dataJSONObject.put("items", itemsJSONArray);
		}
		return dataJSONObject.toString();
	}
	
	private static List<User> getMatchedUsers(String query){
		List<User>matchedUsers = null;
	
		try {
			DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(User.class, PortalClassLoaderUtil.getClassLoader());
			Criterion criterion = RestrictionsFactoryUtil.ilike("emailAddress", query + "%");
			criterion = RestrictionsFactoryUtil.or(criterion, RestrictionsFactoryUtil.ilike("screenName", query + "%"));
			
			String[] firstAndLastnameQ = StringUtil.split(query, StringPool.SPACE);
			if (firstAndLastnameQ.length == 2) {
				String firstNameQ = firstAndLastnameQ[0].trim();
				String lastNameQ = firstAndLastnameQ[1].trim();
				criterion = RestrictionsFactoryUtil.or(criterion,
						RestrictionsFactoryUtil.ilike("firstName", firstNameQ + "%"));
				criterion = RestrictionsFactoryUtil.or(criterion,
						RestrictionsFactoryUtil.ilike("lastName", lastNameQ + "%"));
			}
			
			criterion = RestrictionsFactoryUtil.or(criterion, RestrictionsFactoryUtil.ilike("firstName", query + "%"));
			criterion = RestrictionsFactoryUtil.or(criterion, RestrictionsFactoryUtil.ilike("lastName", query + "%"));
			
			dynamicQuery.add(PropertyFactoryUtil.forName("emailAddressVerified").eq(new Boolean(true)));
			dynamicQuery.add(criterion);
			
			
			matchedUsers = UserLocalServiceUtil.dynamicQuery(dynamicQuery);
		} catch (Exception e) {
			logger.error("Error while getting matched users");
		}
		
		return matchedUsers;
		
	}

	
	public static int getUnReadGroupsAlertCount(User user, long scopeGrpId) {
		int unReadGroupsAlertCount = 0;
		try {
			long userId = user.getUserId();

			List<IBMessageDetail> myInboxList = new ArrayList<IBMessageDetail>();
			myInboxList = IBMessageDetailLocalServiceUtil.getAvailableMDListByReceiveId(user, userId, false,
					InboxConstants.MAIL_TYPE_REPORT_ALERT, InboxUtil.UNREAD, "", -1, -1,
					new IBMessageDetailReceiveDateComparator(),scopeGrpId);
		
			unReadGroupsAlertCount = myInboxList.size();

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return unReadGroupsAlertCount;
	}

	
	public static int getUnReadJobsAlertCount(User user, long scopeGrpId) {
		int unReadJobsAlertCount = 0;
		try {
			long userId = user.getUserId();

			List<IBMessageDetail> myInboxList = new ArrayList<IBMessageDetail>();


			myInboxList = IBMessageDetailLocalServiceUtil.getAvailableMDListByReceiveId(user, userId, false,
					InboxConstants.MAIL_TYPE_JOBS_ALERT, InboxUtil.UNREAD, "", -1, -1,
					new IBMessageDetailReceiveDateComparator(),scopeGrpId);
		
			unReadJobsAlertCount = myInboxList.size();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return unReadJobsAlertCount;

	}


	public static int getUnReadNotificationCount(User user, long scopeGrpId) {
		// DynamicQuery dynamicQuery =
		// DynamicQueryFactoryUtil.forClass(IBMessageDetail.class);
		// dynamicQuery.add(PropertyFactoryUtil.forName("receiverId").eq(new
		// Long(themeDisplay.getUserId())));
		// dynamicQuery.add(PropertyFactoryUtil.forName("archived").eq(new
		// Boolean(false)));
		// dynamicQuery.add(PropertyFactoryUtil.forName("category").eq(MsgCategoryBean.NOTIFICATION));
		// dynamicQuery.add(PropertyFactoryUtil.forName("receiverMsgStatus").eq("unread"));
		// List myInboxList =
		// IBMessageDetailLocalServiceUtil.dynamicQuery(dynamicQuery);

		int unReadNotificationCount = 0;
		try {
			long userId = user.getUserId();
			List<IBMessageDetail> myInboxList = new ArrayList<IBMessageDetail>();


			myInboxList = IBMessageDetailLocalServiceUtil.getAvailableMDListByReceiveId(user, userId, false,
					InboxConstants.MAIL_TYPE_NOTIFICATION, InboxUtil.UNREAD, "", -1, -1,
					new IBMessageDetailReceiveDateComparator(),scopeGrpId);
		

			unReadNotificationCount = myInboxList.size();

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return unReadNotificationCount;

	}

	public static int getUnReadInviteCount(User user, long scopeGrpId) {
		// DynamicQuery dynamicQuery =
		// DynamicQueryFactoryUtil.forClass(IBMessageDetail.class);
		// dynamicQuery.add(PropertyFactoryUtil.forName("receiverId").eq(new
		// Long(themeDisplay.getUserId())));
		// dynamicQuery.add(PropertyFactoryUtil.forName("archived").eq(new
		// Boolean(false)));
		// dynamicQuery.add(PropertyFactoryUtil.forName("category").eq(MsgCategoryBean.INVITATION));
		// dynamicQuery.add(PropertyFactoryUtil.forName("receiverMsgStatus").eq("unread"));
		// List myInboxList =
		// IBMessageDetailLocalServiceUtil.dynamicQuery(dynamicQuery);

		int unReadInviteCount = 0;
		try {
			long userId = user.getUserId();
			List<IBMessageDetail> myInboxList = new ArrayList<IBMessageDetail>();


			myInboxList = IBMessageDetailLocalServiceUtil.getAvailableMDListByReceiveId(user, userId, false,
					InboxConstants.MAIL_TYPE_INVITATION, InboxUtil.UNREAD, "", -1, -1,
					new IBMessageDetailReceiveDateComparator(),scopeGrpId);
		
			unReadInviteCount = myInboxList.size();

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return unReadInviteCount;

	}

	public static int getUnReadRequestCount(User user,long scopeGrpId) {
		// DynamicQuery dynamicQuery =
		// DynamicQueryFactoryUtil.forClass(IBMessageDetail.class);
		// dynamicQuery.add(PropertyFactoryUtil.forName("receiverId").eq(new
		// Long(themeDisplay.getUserId())));
		// dynamicQuery.add(PropertyFactoryUtil.forName("archived").eq(new
		// Boolean(false)));
		// dynamicQuery.add(PropertyFactoryUtil.forName("category").eq(MsgCategoryBean.REQUEST));
		// dynamicQuery.add(PropertyFactoryUtil.forName("receiverMsgStatus").eq("unread"));
		// List myInboxList =
		// IBMessageDetailLocalServiceUtil.dynamicQuery(dynamicQuery);

		int unReadRequestCount = 0;
		try {
			long userId = user.getUserId();
			List<IBMessageDetail> myInboxList = new ArrayList<IBMessageDetail>();

			myInboxList = IBMessageDetailLocalServiceUtil.getAvailableMDListByReceiveId(user, userId, false,
					InboxConstants.MAIL_TYPE_REQUEST, InboxUtil.UNREAD, "", -1, -1,
					new IBMessageDetailReceiveDateComparator(),scopeGrpId);
		
			unReadRequestCount = myInboxList.size();

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}

		return unReadRequestCount;
	}


	public static int getUnreadCount(User user,long scopeGrpId) {
		int unReadCount = 0;
		try {
			long userId = user.getUserId();
			List<IBMessageDetail> myInboxList = new ArrayList<IBMessageDetail>();
			myInboxList = IBMessageDetailLocalServiceUtil.getAvailableMDListByReceiveId(user, userId, false, "",
					InboxUtil.UNREAD, "", -1, -1, new IBMessageDetailReceiveDateComparator(),scopeGrpId);
			unReadCount = myInboxList.size();

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}

		return unReadCount;
	}
	
	public void getUniqueSubject() {
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(IBMessage.class)
				.setProjection(
						ProjectionFactoryUtil.distinct(ProjectionFactoryUtil
								.property("from")));
		try {
			IBMessageLocalServiceUtil.dynamicQuery(query);
		} catch (SystemException e) {
			logger.error(e);
		}
	}
}
