package com.sambaash.platform.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.sambaash.platform.constant.SambaashConstants;
import com.sambaash.platform.model.notification.Notification;
import com.sambaash.platform.model.notification.NotificationImpl;
import com.sambaash.platform.srv.spinbox.model.IBMessage;
import com.sambaash.platform.srv.spinbox.model.IBMessageDetail;
import com.sambaash.platform.srv.spinbox.service.IBMessageDetailLocalServiceUtil;
import com.sambaash.platform.srv.spinbox.service.IBMessageLocalServiceUtil;

public class NotificationUtils {

   public static final String UNREAD = "unread";
   public static final String READ = "read";
	
	public static  List<Notification>  getNotifications(User user){

		String category = "";
		String receiverMsgStatus = UNREAD;
		String senderMsgStatus = "";
		List<Notification> noteList = new ArrayList<Notification>();
		try {
			List<IBMessageDetail> unreadMDs = IBMessageDetailLocalServiceUtil.getAvailableMDListByReceiveId(user, user.getUserId(), false, category,
					receiverMsgStatus, senderMsgStatus, -1, -1,"",SambaashUtil.getGroupId(user.getCompanyId()));
			if(Validator.isNotNull(unreadMDs)){
				IBMessage msg;
				for (IBMessageDetail msgDetail : unreadMDs) {
					msg = null;
					try {
						msg = IBMessageLocalServiceUtil.getIBMessage(msgDetail.getMessageId());
					} catch (PortalException e) {
					}
					if(Validator.isNotNull(msg)){
						Notification note = new NotificationImpl();
						note.setStatus(UNREAD);
						note.setSubject(msg.getSubject());
						note.setContent(getMsgContent(msg));
						note.setDetailLink(getSpGroupLink(msg.getSubject(), msg.getContent()));
						note.setMsgDetailId(String.valueOf(msgDetail.getMessageId()));
						noteList.add(note);
					}
				}
			}
		} catch (SystemException e) {
			_log.error("Error while getting unread messages");
		} catch(Exception ex){
			_log.error("Error while getting unread messages" + ex.getMessage());
		}
		
		return noteList;
	
	}
	
	public static String GRP_REQ_APPROVED_TEMPLATE = "%s has approved your request";
	public static String GRP_REQ_DECLINED_TEMPLATE = "%s has declined your request";
	public static String GRP_REQ_INVITATION_TEMPLATE = "Group Request";
	public static String GRP_JOIN_REQ_TEMPLATE = "%s wants to join the group";
	public static String GRP_INVITATION_TEMPLATE = "%s invited you to join the group";
	public static String NEW_DISCUSSION_TEMPLATE = "%s has started new discussion";
	public static String NEW_COMMENT_TEMPLATE = "%s has added new comment";
	
	public static String getMsgContent(IBMessage msg){
		String subject = GetterUtil.getString(msg.getSubject());
		String content = subject;
		long userId = GetterUtil.getLong(SambaashUtil.getParameter(SambaashConstants.PARAM.ID_ADMIN_USER, 0));
		User admin;
		try {
			admin = UserLocalServiceUtil.getUser(userId);
			User user = UserLocalServiceUtil.getUserByEmailAddress(admin.getCompanyId(), msg.getFrom());
			if(subject.toLowerCase().startsWith(SambaashConstants.SPGroup.GRP_JOIN_REQUEST_PREFIX.toLowerCase())){
				content = String.format(GRP_JOIN_REQ_TEMPLATE, user.getFullName());
			}
			
			if(subject.toLowerCase().startsWith(SambaashConstants.SPGroup.GRP_REQ_NOTIFICAITON_PREFIX.toLowerCase())){
				content = GRP_REQ_INVITATION_TEMPLATE;//String.format(GRP_JOIN_INVITATION_TEMPLATE, user.getFullName());
				String temp = GetterUtil.getString(msg.getContent());
				if(temp.toLowerCase().endsWith("approved.</p>")){
					content = String.format(GRP_REQ_APPROVED_TEMPLATE, user.getFullName());
				}else if(temp.toLowerCase().endsWith("rejected.</p>")){
					content = String.format(GRP_REQ_DECLINED_TEMPLATE, user.getFullName());
				}
			}
			
			if(subject.toLowerCase().startsWith(SambaashConstants.SPGroup.GRP_INTERNAL_INVITATION_PREFIX.toLowerCase())){
				content = String.format(GRP_INVITATION_TEMPLATE, user.getFullName());
			}
			if(subject.toLowerCase().startsWith(SambaashConstants.SPGroup.NEW_DISCUSSION.toLowerCase())){
				content = String.format(NEW_DISCUSSION_TEMPLATE, user.getFullName());//String.format(GRP_INVITATION_TEMPLATE, user.getFullName());
			}
			if(subject.toLowerCase().startsWith(SambaashConstants.SPGroup.NEW_COMMENT.toLowerCase())){
				content =  String.format(NEW_COMMENT_TEMPLATE, user.getFullName());;
			}
			
			
		} catch (PortalException | SystemException e) {
			_log.error(e.getMessage());
		}
		return content;
	} 
	
	public static String getSpGroupLink(String subject,String content){
		String link = "";
		subject = GetterUtil.getString(subject);
		//Join request
		if(subject.toLowerCase().startsWith(SambaashConstants.SPGroup.GRP_JOIN_REQUEST_PREFIX.toLowerCase())){
			link = getJoinGroupRequestLink(content);
		}
		
		// Request for joining group has accepted/rejected
		if(subject.toLowerCase().startsWith(SambaashConstants.SPGroup.GRP_REQ_NOTIFICAITON_PREFIX.toLowerCase())){
			link = getGroupRequestStatusLink(content);
		}
		
		// Internal Group invitation
		if(subject.toLowerCase().contains(SambaashConstants.SPGroup.GRP_INTERNAL_INVITATION_PREFIX.toLowerCase())){
			link = getInternalInvitationRequestLink(content);
		}
		
		if(subject.toLowerCase().startsWith(SambaashConstants.SPGroup.NEW_DISCUSSION.toLowerCase())){
			link = getDisscussionUrl(content);
		}
		if(subject.toLowerCase().startsWith(SambaashConstants.SPGroup.NEW_COMMENT.toLowerCase())){
			link = getCommentUrl(content);
		}
		return link;
	}
	
	public static String getJoinGroupRequestLink(String content) {
		
		Pattern p = Pattern.compile("href=\"(.*?)\"", Pattern.DOTALL);
		Matcher m = p.matcher(content);
		
		int i = 0;
		String link = "";
		while (m.find()) 
		{
		    _log.debug(m.group(1));
		    i++;
		    if(i== 2){
		    	link = m.group(1);
		    	break;
		    }
		}

		return link;
	}
	public static String getInternalInvitationRequestLink(String content) {
		
		Pattern p = Pattern.compile("href=\"(.*?)\"", Pattern.DOTALL);
		Matcher m = p.matcher(content);
		
		int i = 0;
		String link = "";
		while (m.find()) 
		{
			_log.debug(m.group(1));
			i++;
			if(i== 2){
				link = m.group(1);
				break;
			}
		}
		
		return link;
	}
	public static String getDisscussionUrl(String content) {
		
		Pattern p = Pattern.compile("href=\"(.*?)\"", Pattern.DOTALL);
		Matcher m = p.matcher(content);
		
		int i = 0;
		String link = "";
		while (m.find()) 
		{
			_log.debug(m.group(1));
			i++;
			if(i== 2){
				link = m.group(1);
				break;
			}
		}
		
		return link;
	}
	public static String getCommentUrl(String content) {
		
		Pattern p = Pattern.compile("href=\"(.*?)\"", Pattern.DOTALL);
		Matcher m = p.matcher(content);
		
		int i = 0;
		String link = "";
		while (m.find()) 
		{
			_log.debug(m.group(1));
			i++;
			if(i== 2){
				link = m.group(1);
				break;
			}
		}
		
		return link;
	}
	public static String getGroupRequestStatusLink(String content) {
		
		Pattern p = Pattern.compile("href=\"(.*?)\"", Pattern.DOTALL);
		Matcher m = p.matcher(content);
		
		String link = "";
		while (m.find()) 
		{
			_log.debug(m.group(1));
			link = m.group(1);
			break;
		}
		
		return link;
	}
	
	public static String getCommunityName(){
		return PropsUtil.get(PropsKeys.VIRTUAL_HOSTS_DEFAULT_SITE_NAME);
	}
	
	public static String getWebSocketUrl(){
		return SambaashUtil.getWebSocketHostUrl();// + "/push_realtime_notifications";
	}

	private static Log _log = LogFactoryUtil.getLog(NotificationUtils.class);
}
