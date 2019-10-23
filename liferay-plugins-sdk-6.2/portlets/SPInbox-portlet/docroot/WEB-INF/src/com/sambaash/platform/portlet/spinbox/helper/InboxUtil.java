package com.sambaash.platform.portlet.spinbox.helper;

import java.util.List;

import com.liferay.portal.NoSuchUserException;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil;
import com.sambaash.platform.constant.SambaashConstants;
import com.sambaash.platform.srv.mail.NoSuchTemplateException;
import com.sambaash.platform.srv.mail.model.SPMailTemplate;
import com.sambaash.platform.srv.mail.service.SPMailTemplateLocalServiceUtil;
import com.sambaash.platform.srv.spservices.NoSuchSPParameterException;
import com.sambaash.platform.srv.spservices.model.SPParameter;
import com.sambaash.platform.srv.spservices.service.SPParameterLocalServiceUtil;
import com.sambaash.platform.util.SambaashUtil;
public class InboxUtil {

	private static Log _log = LogFactoryUtil.getLog(InboxUtil.class);

/*	public static String getCommunityName() {
		return SambaashUtil.getCommunityName(FacesUtils.getThemeDisplay().getScopeGroupId());
	}

	public static long getScopeGroupId() {
		return FacesUtils.getThemeDisplay().getScopeGroupId();
	} */

	public static String INBOX_ACTION = "inbox_action";

	public static String ACTION_WRITE = "write";
	public static String ACTION_SENT = "sent";
	public static String ACTION_ARCHIVED = "archived";
	public static String ACTION_INBOX = "inbox";
	public static String ACTION_INBOX_REQUEST = "inbox_request";
	public static String ACTION_INBOX_INVITE = "inbox_invite";
	public static String ACTION_INBOX_NOTIFICATION = "inbox_notification";
	public static String ACTION_INBOX_GROUPS_ALERT = "inbox_groups_alert";
	public static String ACTION_INBOX_JOBS_ALERT = "inbox_jobs_alert";
	public static String ACTION_SEARCH = "search";
	public static String ACTION_DRAFTS = "drafts";

	public static String INBOX_RENDER_GROUP = "inbox_render_group";

	public static String ALL = "all";
	public static String READ = "read";
	public static String UNREAD = "unread";
	public static String REPLIED = "replied";
	public static String FORWARDED = "forwarded";

	public static SPMailTemplate getMailTemplate(String parameter,long scopeGroupId) throws SystemException{
		SPMailTemplate mailTemplate = null;
		//long scopeGroupId = FacesUtils.getThemeDisplay().getScopeGroupId();
		String templateId_str = getParameter(parameter, scopeGroupId);
		if (Validator.isNotNull(templateId_str)) {
			try{
				long templateId = Long.valueOf(templateId_str);
		    	mailTemplate = SPMailTemplateLocalServiceUtil.getSPMailTemplate(templateId);
			}catch(Exception e) {
				if (e instanceof NoSuchTemplateException) {
					_log.info("No such mail template exist with primary key: "+templateId_str);
				}else if (e instanceof NumberFormatException) {
					_log.info("SpParameter: "+templateId_str+"can not convert to Long type");
				}else{
					_log.error(e.getMessage(), e);
				}
			}
		}
		return mailTemplate;
	}

	public static String getParameter(String key, long groupId) {
		String value = "";
		try{
			SPParameter parameter = SPParameterLocalServiceUtil.findBySPParameterGroupIdAndName(groupId, key);
			value = parameter.getValue();
		}catch(Exception e) {
			if (e instanceof NoSuchSPParameterException) {
				_log.info("No such spparameter exist with key: "+key+" groupId: "+groupId);
			}else{
				_log.error(e.getMessage(), e);
			}
		}
		return value;
	}

  

    public static boolean isCorporateUser(long userId) {
       return false;
    }

	public static boolean checkAccessForService(User user, String technologyComponent) {
		try {
			// TODO: have to look into below hasAccess method
		/*	Map<String,Object> hasAccessMap = ServiceComponentsLocalServiceUtil.hasAccess(technologyComponent, user);
			boolean hasAccess = (Boolean)hasAccessMap.get(SambaashConstants.MEMBERSHIP.SERVICE_HASACCESS); */
			boolean hasAccess = true;
			return hasAccess;
		} catch (Exception e) {
			_log.error("CheckAccessForService : ", e);
		}
		return false;
	}

	public static String getAccessMessageForService(User user, String technologyComponent) {
		String message = "";
		try {
			//Map<String,Object> hasAccessMap = ServiceComponentsLocalServiceUtil.hasAccess(technologyComponent, user);
			//message = (String)hasAccessMap.get(SambaashConstants.MEMBERSHIP.SERVICE_MESSAGE);

		} catch (Exception e) {
			_log.error("CheckAccessForService : ", e);
		}
		return message;
	}

	public static String getTechComponentByMsgCategory(String MsgCategory,long scopeGroupId) {
		if (InboxConstants.MAIL_TYPE_REQUEST.equalsIgnoreCase(MsgCategory)) {
			return SambaashUtil.getParameter(SambaashConstants.MEMBERSHIP_SERVICECOMPONENTS.INBOX_REQUEST, scopeGroupId);
		}else if (InboxConstants.MAIL_TYPE_INVITATION.equalsIgnoreCase(MsgCategory)) {
			return SambaashUtil.getParameter(SambaashConstants.MEMBERSHIP_SERVICECOMPONENTS.INBOX_INVITATION, scopeGroupId);
		}else if (InboxConstants.MAIL_TYPE_NOTIFICATION.equalsIgnoreCase(MsgCategory)) {
			return SambaashUtil.getParameter(SambaashConstants.MEMBERSHIP_SERVICECOMPONENTS.INBOX_NOTIFICATION, scopeGroupId);
		}else if (InboxConstants.MAIL_TYPE_MESSAGE.equalsIgnoreCase(MsgCategory)) {
			return SambaashUtil.getParameter(SambaashConstants.MEMBERSHIP_SERVICECOMPONENTS.INBOX_MESSAGE, scopeGroupId);
		}else if (InboxConstants.MAIL_TYPE_REPORT_ALERT.equalsIgnoreCase(MsgCategory)) {
			return SambaashUtil.getParameter(SambaashConstants.MEMBERSHIP_SERVICECOMPONENTS.INBOX_GROUPS_ALERT, scopeGroupId);
		}else if (InboxConstants.MAIL_TYPE_JOBS_ALERT.equalsIgnoreCase(MsgCategory)) {
			return SambaashUtil.getParameter(SambaashConstants.MEMBERSHIP_SERVICECOMPONENTS.INBOX_JOBS_ALERT, scopeGroupId);
		}else{
			return "";
		}
	} 



	public static boolean checkUserExist(String emailAddress,long companyId) {
		//TOOD:
		//long companyId =  10154;//FacesUtils.getThemeDisplay().getCompanyId();
		User user = null;
		try{
			user = UserLocalServiceUtil.getUserByEmailAddress(companyId, emailAddress);
        	if (user!=null) {
//            	UserProfileBasic userProfileBasic = UserProfileBasicLocalServiceUtil.getUserProfileBasic(user.getUserId());
//        		SocialProfile socialProfile = SocialProfileLocalServiceUtil.getSocialProfile(user.getUserId());
//            	if (socialProfile!=null) {
//            		if ("active".equalsIgnoreCase(socialProfile.getUserRegistrationStatus())) {
//            			return true;
//            		}
//            	}
        		return true;
        	}
        	return false;
		}catch(NoSuchUserException e) {
			return false;
		}catch(Exception e) {
			if (e instanceof NoSuchUserException) {
				_log.info(" No User exists with the key {companyId="+ companyId +", emailAddress="+emailAddress+"}");
			}else{
				_log.error(e.getMessage(), e);
			}
			return false;
		}
	}

/*	public static String getViewGroupDetailURL(String groupId) {
		String portalURL = getPortalURL();
		return portalURL + SambaashUtil.getCommunityPath(getScopeGroupId()) + "/" + getGroupDetailPageName() + "?" + "groupId=" + groupId;
	} */

/*	public static String getPortalURL() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		ExternalContext externalContext = facesContext.getExternalContext();
		String portalURL = PortalUtil.getPortalURL((PortletRequest) externalContext.getRequest());
		return portalURL;
	} */
/*	public static String getGroupDetailPageName() {
		String groupDetailPageName = "";
		groupDetailPageName = getParameter(SambaashConstants.URL.GROUP_DETAIL, FacesUtils.getThemeDisplay().getScopeGroupId());
		return groupDetailPageName;
	} */

	public static long getUserIdByScreenName(long companyId, String friendlyURL) {
		long userId = 0;
		try {
			String screenName = friendlyURL.replaceAll("/", "");
			userId = UserLocalServiceUtil.getUserIdByScreenName( companyId, screenName );
		} catch (NoSuchUserException e ) {
			_log.info("No user found with the screen name" + friendlyURL);
		} catch (PortalException e) {
			_log.info("No user found with the screen name" + friendlyURL);
		} catch (SystemException e) {
			_log.info("No user found with the screen name" + friendlyURL);
		}
		return userId;
	}

	public static String getAdJAContentBytitle(String title) {
		JournalArticle journalArticle= null;
		try{
			ClassLoader cl = PortalClassLoaderUtil.getClassLoader();
			DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(com.liferay.portlet.journal.model.JournalArticle.class, cl);
			dynamicQuery.add(PropertyFactoryUtil.forName("title").eq(new String(title)));
			List<JournalArticle> journalArticles = JournalArticleLocalServiceUtil.dynamicQuery(dynamicQuery);
			if (Validator.isNotNull(journalArticles) && journalArticles.size()>0) {
				journalArticle = journalArticles.get(0);
			}
		}catch(Exception e) {
			_log.error(e.getMessage(), e);
		}
		if (Validator.isNull(journalArticle)) {
			return "";
		}
		return journalArticle.getContent();
	}

/*	public static boolean isShowInbox(boolean isSignedIn, String userScreenName, long scopeGroupId) {
		if (!isSignedIn) {
			return false;
		}

		FacesContext facesContext = FacesContext.getCurrentInstance();

		HttpServletRequest httpRequest = (HttpServletRequest) FacesUtils.getPortalRequest(facesContext);
		String currentURL = PortalUtil.getCurrentURL(httpRequest);

		if (Validator.isNull(currentURL)) {
			return false;
		}
		currentURL = currentURL.replaceAll("/", "");
		String proifleIndPrivateURL = SambaashUtil.getParameter(SambaashConstants.URL.PROFILE_IND_PRIVATE, scopeGroupId);
		try {
			if (userScreenName.equalsIgnoreCase(currentURL) || proifleIndPrivateURL.equalsIgnoreCase(currentURL)) {
				return true;
			}
		}catch (Exception e) {
			_log.error(e.getMessage(), e);
		}
		return false;
	} */
}