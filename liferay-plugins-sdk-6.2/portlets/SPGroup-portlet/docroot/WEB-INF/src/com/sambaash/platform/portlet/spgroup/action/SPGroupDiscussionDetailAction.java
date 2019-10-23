package com.sambaash.platform.portlet.spgroup.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.model.Layout;
import com.liferay.portal.model.User;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.service.UserNotificationEventLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.messageboards.model.MBMessage;
import com.liferay.portlet.messageboards.service.MBMessageLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.sambaash.platform.constant.SambaashConstants;
import com.sambaash.platform.model.SPGroupUserStatus;
import com.sambaash.platform.portlet.spgroup.util.ActionUtil;
import com.sambaash.platform.portlet.spgroup.util.SPGroupConstants;
import com.sambaash.platform.portlet.spgroup.util.Util;
import com.sambaash.platform.portlet.spgroup.wrapper.CommentBo;
import com.sambaash.platform.portlet.spgroup.wrapper.CommentJsonBo;
import com.sambaash.platform.portlet.spgroup.wrapper.CommentJsonListBo;
import com.sambaash.platform.srv.spgroup.NoSuchSPGroupException;
import com.sambaash.platform.srv.spgroup.NoSuchUserException;
import com.sambaash.platform.srv.spgroup.model.SPGroup;
import com.sambaash.platform.srv.spgroup.model.SPGroupUser;
import com.sambaash.platform.srv.spgroup.service.SPGroupLocalServiceUtil;
import com.sambaash.platform.srv.spgroup.service.SPGroupUserLocalServiceUtil;
import com.sambaash.platform.srv.spgroup.service.persistence.SPGroupUserPK;
import com.sambaash.platform.srv.spinbox.model.IBMessage;
import com.sambaash.platform.srv.spservices.model.SPParameter;
import com.sambaash.platform.srv.spservices.service.SPParameterLocalServiceUtil;
//import com.sambaash.platform.srv.servicecomponent.service.ServiceComponentsLocalServiceUtil;

/**
 * Portlet implementation class SPGroupDiscussionDetailAction
 */
public class SPGroupDiscussionDetailAction extends MVCPortlet {

	@Override
	public void doEdit(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		super.doEdit(renderRequest, renderResponse);
	}

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay)renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		try {
			long discussionId = ParamUtil.getLong(renderRequest, "discussionId");

			SPGroup spGroup = null;

			boolean isMember = false;

			try {
				spGroup = ActionUtil.getSPGroup(renderRequest);

				if (spGroup != null) {
					long spGroupId = spGroup.getSpGroupId();

					SPGroupUser spGroupUser = null;
					try {
						spGroupUser = SPGroupUserLocalServiceUtil.findByUserIdAndGroupIdAndStatus(
								themeDisplay.getUserId(), spGroupId, SPGroupUserStatus.APPROVE.getValue());

						if (spGroupUser != null) {
							isMember = true;
						}
					} catch (NoSuchUserException nsue) {
					}

					/*
					 * Start comment -- Clark
					 */
					int cStart = 0;
					int cOffset = 1;

					CommentBo parentCommentBo = this.getParentCommentBo(discussionId, cStart, cOffset);
					renderRequest.setAttribute("parentCommentBo", parentCommentBo);

					boolean commentServiceHasAccess = true;
					String commentServiceUserStatus = "";
					String commentServiceStrutsAction = StringPool.BLANK;
					SPParameter commentServiceParameter = SPParameterLocalServiceUtil
							.findBySPParameterGroupIdAndName(themeDisplay.getScopeGroupId(),
									SambaashConstants.MEMBERSHIP_SERVICECOMPONENTS.SPGROUP_COMMENT);
					commentServiceStrutsAction = commentServiceParameter.getValue();
					Map<String, Object> parameterMap = new HashMap<String, Object>();
					parameterMap.put("struts_action", commentServiceStrutsAction);
					parameterMap.put("groupId", new Long(themeDisplay.getScopeGroupId()));

					/**Map<String, Object> commentServiceHasAccessMap = ServiceComponentsLocalServiceUtil.hasAccess(
							parameterMap, themeDisplay.getUser());
					commentServiceHasAccess = (Boolean)commentServiceHasAccessMap
							.get(SambaashConstants.MEMBERSHIP.SERVICE_HASACCESS);
					commentServiceUserStatus = (String)commentServiceHasAccessMap
							.get(SambaashConstants.MEMBERSHIP.SERVICE_REDIRECTURL);
					*/
					// need to remove

					renderRequest.setAttribute("commentServiceHasAccess", commentServiceHasAccess);
					renderRequest.setAttribute("commentServiceUserStatus", commentServiceUserStatus);

					/*
					 * End comment
					 */
				}

			} catch (NoSuchSPGroupException nsspge) {
			}

			renderRequest.setAttribute("isMember", isMember);

		} catch (Exception e) {
			_log.error(e.getMessage(), e);
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
		ThemeDisplay themeDisplay = (ThemeDisplay)resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		try {
			String action = ParamUtil.getString(resourceRequest, "action");

			if ("retrieveReplies".equalsIgnoreCase(action)) {
				resourceResponse.setContentType("application/json");
				resourceResponse.setCharacterEncoding("utf-8");
				resourceResponse.getWriter().write(retrieveRepliesJsonString(resourceRequest, themeDisplay));
			} else if ("addReply".equalsIgnoreCase(action)) {
				resourceResponse.setContentType("application/json");
				resourceResponse.setCharacterEncoding("utf-8");
				resourceResponse.getWriter().write(addReplyJsonString(resourceRequest, themeDisplay));
			} else if ("deleteComment".equalsIgnoreCase(action)) {
				resourceResponse.setContentType("application/json");
				resourceResponse.setCharacterEncoding("utf-8");
				resourceResponse.getWriter().write(deleteCommentJsonString(resourceRequest));
			}

		} catch (Exception e) {
			_log.error(e.getMessage(), e);
		}

		super.serveResource(resourceRequest, resourceResponse);
	}

	private String retrieveRepliesJsonString(ResourceRequest resourceRequest, ThemeDisplay themeDisplay)
			throws PortalException, SystemException {
		JSONObject dataJSONObject = JSONFactoryUtil.createJSONObject();
		JSONArray itemsJSONArray = JSONFactoryUtil.createJSONArray();
		CommentJsonListBo commentJsonListBo = retrieveReplies(resourceRequest, themeDisplay);
		List<CommentJsonBo> commentJsonBos = commentJsonListBo.getItems();

		for (CommentJsonBo commentJsonBo : commentJsonBos) {
			String html = commentJsonBo.getHtml();
			JSONObject htmlJSONObject = JSONFactoryUtil.createJSONObject();
			htmlJSONObject.put("html", html);
			itemsJSONArray.put(htmlJSONObject);
		}

		dataJSONObject.put("items", itemsJSONArray);

		return dataJSONObject.toString();
	}

	private CommentJsonListBo retrieveReplies(ResourceRequest resourceRequest, ThemeDisplay themeDisplay)
			throws PortalException, SystemException {
		String spGroupIdStr = resourceRequest.getParameter("sp_group_id");
		String parentIdStr = resourceRequest.getParameter("parent_id");
		String initTotalStr = resourceRequest.getParameter("init_total");
		String curShowingNoStr = resourceRequest.getParameter("cur_showing_no");
		String offsetStr = resourceRequest.getParameter("offset");
_log.debug("offset" + offsetStr);
		long parentId = 0;
		int curShowingNo = 0;
		int initTotal = 0;
		int offset = 0;

		long spGroupId = 0;
		try {
			spGroupId = Long.valueOf(spGroupIdStr);
		} catch (NumberFormatException nfe) {
		}

		boolean isMember = false;
		SPGroupUser spGroupUser = null;
		try {
			spGroupUser = SPGroupUserLocalServiceUtil.getSPGroupUser(new SPGroupUserPK(spGroupId, themeDisplay.getUserId()));

			if (spGroupUser.getStatus() == SPGroupUserStatus.APPROVE.getValue()) {
				isMember = true;
			}

		} catch (NoSuchUserException nsue) {
		}

		try {
			parentId = Long.valueOf(parentIdStr);
		} catch (NumberFormatException nfe) {
		}

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
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(MBMessage.class,
				PortalClassLoaderUtil.getClassLoader());
		dynamicQuery.add(PropertyFactoryUtil.forName("parentMessageId").eq(new Long(parentId)));
		dynamicQuery.addOrder(OrderFactoryUtil.desc("createDate"));
		long childCountL = MBMessageLocalServiceUtil.dynamicQueryCount(dynamicQuery);
		int childCount = Util.safeLongToInt(childCountL);

		int balance = 0;
		balance = childCount - initTotal;
		start += balance;

		return populateChildJsonList(themeDisplay, parentId, start, offset, isMember);
	}

	private String addReplyJsonString(ResourceRequest resourceRequest, ThemeDisplay themeDisplay)
			throws PortalException, SystemException {
		String classPKStr = resourceRequest.getParameter("class_pk");
		String className = resourceRequest.getParameter("class_name");
		String parentIdStr = resourceRequest.getParameter("parent_id");
		String content = resourceRequest.getParameter("content");
		String linkContent = content.replaceAll("[\r\n]", StringPool.SPACE);
		String linkUrlList = SPGroupConstants.URL_LINKS_GROUP_COMMENTS;
		String[] linkUrls = linkUrlList.split(StringPool.SEMICOLON);
		for(String linkUrl : linkUrls){
			if(linkContent.contains(linkUrl)){
				String[] gethttpsurl = linkContent.split(StringPool.SPACE);
				for(int i = 0;i<gethttpsurl.length;i++){
					if(gethttpsurl[i].contains(linkUrl)){
						String setLink = "<a href=" + gethttpsurl[i] + " target='_blank'>" + gethttpsurl[i] + "</a>";
						content = content.replace(gethttpsurl[i], setLink);
					}
				}
			}
		}	
		_log.error("themeDisplay.getPortalURL() " + themeDisplay.getPortalURL());
		if(linkContent.contains(themeDisplay.getPortalURL())){
			String[] gethttpsurl = linkContent.split(StringPool.SPACE);
			for(int i = 0;i<gethttpsurl.length;i++){
				if(gethttpsurl[i].contains(themeDisplay.getPortalURL())){
					String setLink = "<a href=" + gethttpsurl[i] + " target='_blank'>" + gethttpsurl[i] + "</a>";
					content = content.replace(gethttpsurl[i], setLink);
				}
			}
		}
		long classPK = 0;
		try {
			classPK = Long.valueOf(classPKStr);
		} catch (NumberFormatException nfe) {
		}

		long parentId = 0;
		try {
			parentId = Long.valueOf(parentIdStr);
		} catch (NumberFormatException nfe) {
		}

		int workflowAction = WorkflowConstants.ACTION_PUBLISH;
		long currentUserId = themeDisplay.getUserId();
		String currentUserScreenName = themeDisplay.getUser().getScreenName();
		String currentUserFullName = themeDisplay.getUser().getFullName();
		long portraitId = themeDisplay.getUser().getPortraitId();

		MBMessage mbmsg = MBMessageLocalServiceUtil.addDiscussionMessage(currentUserId, currentUserScreenName,
				themeDisplay.getScopeGroupId(), className, classPK, workflowAction);
		mbmsg.setParentMessageId(parentId);
		// show all messages in a separate and replace all newline characters with <br>
		mbmsg.setBody("<br>" + content.replaceAll("[\r\n]", "<br>"));
		MBMessageLocalServiceUtil.updateMBMessage(mbmsg);
		
		try{
			MBMessage parentMessage = MBMessageLocalServiceUtil.getMBMessage(mbmsg.getParentMessageId());
			parentMessage.setModifiedDate(new Date());
			MBMessageLocalServiceUtil.updateMBMessage(parentMessage);
		}catch(Exception e){
			_log.error("No Parent message found" + e.getMessage());
		}
		CommentBo childCommentBo = new CommentBo(mbmsg);
		childCommentBo.setFullName(currentUserFullName);
		childCommentBo.setScreenName(currentUserScreenName);
		childCommentBo.setPortraitId(portraitId);

		JSONObject dataJSONObject = JSONFactoryUtil.createJSONObject();
		String html = getChildCommentHtml(childCommentBo, themeDisplay, true);
		dataJSONObject.put("html", html);
		dataJSONObject.put("class_pk", classPK);
		dataJSONObject.put("parent_id", parentId);

		// Notifications

		try {
			List<SPGroupUser> members =
					SPGroupUserLocalServiceUtil.findBySPGroupIdAndStatus(
							classPK, SPGroupUserStatus.APPROVE.getValue());
			StringBuilder toEmailsSb = new StringBuilder();
			List<Long> toUserIds = new ArrayList<Long>();
			List<String> toUsernames = new ArrayList<String>();

			for (int i = 0; i < members.size(); i++) {
				long userId = members.get(i).getUserId();
				try {
					User user = UserLocalServiceUtil.getUser(userId);
					toEmailsSb.append(user.getEmailAddress());
					toUserIds.add(user.getUserId());
					toUsernames.add(user.getFullName());

					if ( i != members.size() - 1) {
						toEmailsSb.append(StringPool.COMMA);
					}
				}catch (Exception ex) {
				}
			}

			String portalURL = PortalUtil.getPortalURL(resourceRequest);
			String portalSigninUrl = portalURL + "/signin?redirect=";
			String senderProfileURL = portalURL + StringPool.SLASH + themeDisplay.getUser().getScreenName();
			String senderName = themeDisplay.getUser().getFullName();
			SPGroup spGroup = SPGroupLocalServiceUtil.getSPGroup(classPK);
			String groupTitle = spGroup.getTitle();

			Layout spGroupDetailLayout = null;
			String groupDetailPageName = resourceRequest.getPreferences().getValue("groupDetailPageName", "group-detail");
			try {
				spGroupDetailLayout =
						LayoutLocalServiceUtil.getFriendlyURLLayout(themeDisplay.getScopeGroupId(), false, "/" +
								groupDetailPageName);
			}
			catch (com.liferay.portal.NoSuchLayoutException e) {

				// do nothing

			}

		 String spGroupDetailURL1 = "";
			if (spGroupDetailLayout != null) {
				long spGroupDetailPlid = spGroupDetailLayout.getPlid();

				javax.portlet.PortletURL spGroupDetailPortletURL =
						com.liferay.portlet.PortletURLFactoryUtil.create(
								resourceRequest, SPGroupConstants.PORTLET_ID_GROUP_DETAIL, spGroupDetailPlid,
								PortletRequest.RENDER_PHASE);
				spGroupDetailPortletURL.setWindowState(javax.portlet.WindowState.NORMAL);
				spGroupDetailPortletURL.setPortletMode(javax.portlet.PortletMode.VIEW);
				spGroupDetailPortletURL.setParameter("struts_action", "/groups/view_entry");
//				spGroupDetailPortletURL.setParameter("urlTitle", urlTitle);
				spGroupDetailPortletURL.setParameter("spGroupId", String.valueOf(classPK));
				spGroupDetailURL1 = spGroupDetailPortletURL.toString();
			} 

			javax.portlet.PortletURL viewSPGroupDiscussionPortletURL = null;
			try {
				com.liferay.portal.model.Layout createSPGroupLayout =
					com.liferay.portal.service.LayoutLocalServiceUtil.getFriendlyURLLayout(
						themeDisplay.getScopeGroupId(), false, "/discussion-detail");
				long viewSPGroupDiscussionPlid = createSPGroupLayout.getPlid();

				viewSPGroupDiscussionPortletURL =
					com.liferay.portlet.PortletURLFactoryUtil.create(
						resourceRequest, "SPGroupDiscussionDetail_WAR_SPGroupportlet", viewSPGroupDiscussionPlid,
						javax.portlet.PortletRequest.RENDER_PHASE);
				viewSPGroupDiscussionPortletURL.setWindowState(javax.portlet.WindowState.NORMAL);
				viewSPGroupDiscussionPortletURL.setPortletMode(javax.portlet.PortletMode.VIEW);
				viewSPGroupDiscussionPortletURL.setParameter("struts_action", "/discussions/view_discussion");
			//	viewSPGroupDiscussionPortletURL.setParameter("urlTitle", urlTitle);
				viewSPGroupDiscussionPortletURL.setParameter("spGroupId", String.valueOf(classPK));

			}
			catch (com.liferay.portal.NoSuchLayoutException e) {

			}

			String spGroupDetailURL = "";

			if (viewSPGroupDiscussionPortletURL != null) {
				viewSPGroupDiscussionPortletURL.setParameter("discussionId", String.valueOf(mbmsg.getParentMessageId()));
				spGroupDetailURL = viewSPGroupDiscussionPortletURL.toString();
			}
			
			MBMessage parentMessage = MBMessageLocalServiceUtil.getMBMessage(parentId);
			addNewCommentNotification(spGroup, spGroupDetailURL1,
					viewSPGroupDiscussionPortletURL.toString(),parentMessage.getSubject(),
					themeDisplay.getUserId(), resourceRequest);

			Map<String, Object> paramsMap = new HashMap<String, Object>();
			paramsMap.put("senderProfileURL", senderProfileURL);
			paramsMap.put("discussionUrl", spGroupDetailURL);
			paramsMap.put("groupTitle", groupTitle);
			paramsMap.put("senderId", themeDisplay.getUserId());
			paramsMap.put("senderName", senderName);
			paramsMap.put("portalSigninUrl", portalSigninUrl);

			String array[] = getNewCommentThreadSubjectBody(paramsMap);
			IBMessage ibmessage =
					ActionUtil.addIBMessage(
							themeDisplay.getScopeGroupId(), themeDisplay.getCompanyId(), classPK,
							themeDisplay.getUser().getFullName(),
							themeDisplay.getUser().getUserId(),
							themeDisplay.getUser().getEmailAddress(), toEmailsSb.toString(),
							array[0], array[1]);

			for (int i = 0; i < toUserIds.size(); i++) {
				ActionUtil.addIBMessageDetail(
					themeDisplay.getCompanyId(), ibmessage, toUserIds.get(i), toUsernames.get(i),
					"Pending", "notification", toUserIds.get(i));

			}

		}catch (Exception ex) {

		}

		return dataJSONObject.toString();
	}

	private String deleteCommentJsonString(ResourceRequest resourceRequest) throws PortalException, SystemException {
		String commentIdStr = resourceRequest.getParameter("comment_id");
		String isParentStr = resourceRequest.getParameter("is_parent");
		String classPK = resourceRequest.getParameter("class_pk");
		long commentId = 0;
		try {
			commentId = Long.valueOf(commentIdStr);
		} catch (NumberFormatException nfe) {
		}

		if ("true".equalsIgnoreCase(isParentStr)) {

			// delete children comments

			DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(MBMessage.class,
					PortalClassLoaderUtil.getClassLoader());
			dynamicQuery.add(PropertyFactoryUtil.forName("parentMessageId").eq(new Long(commentId)));
			@SuppressWarnings("unchecked")
			List<MBMessage> childComments = MBMessageLocalServiceUtil.dynamicQuery(dynamicQuery);

			for (MBMessage childComment : childComments) {
				MBMessageLocalServiceUtil.deleteMBMessage(childComment.getMessageId());
			}
		}

		// delete comment

		MBMessageLocalServiceUtil.deleteMBMessage(commentId);
		JSONObject dataJSONObject = JSONFactoryUtil.createJSONObject();
		dataJSONObject.put("comment_id", commentId);
		dataJSONObject.put("class_pk", classPK);
		return dataJSONObject.toString();
	}

	private List<CommentBo> getChildCommentBos(long parentId, int cStart, int cOffset) throws PortalException,
			SystemException {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(MBMessage.class,
				PortalClassLoaderUtil.getClassLoader());
		dynamicQuery = DynamicQueryFactoryUtil.forClass(MBMessage.class, PortalClassLoaderUtil.getClassLoader());
		dynamicQuery.add(PropertyFactoryUtil.forName("parentMessageId").eq(new Long(parentId)));
		dynamicQuery.addOrder(OrderFactoryUtil.desc("createDate"));

		@SuppressWarnings("unchecked")
		List<MBMessage> childComments = MBMessageLocalServiceUtil.dynamicQuery(dynamicQuery, cStart, cStart + cOffset);

		List<CommentBo> childCommentBos = new ArrayList<CommentBo>();

		for (MBMessage childComment : childComments) {
			CommentBo childCommentBo = new CommentBo(childComment);
			long userId = childComment.getUserId();
			User actor = UserLocalServiceUtil.getUserById(userId);
			childCommentBo.setScreenName(actor.getScreenName());
			childCommentBo.setFullName(actor.getFullName());
			childCommentBo.setPortraitId(actor.getPortraitId());
			childCommentBos.add(childCommentBo);
		}

		return childCommentBos;
	}

	private String[] getNewCommentThreadSubjectBody( Map<String, Object> paramsMap) {

		String senderProfileURL = (String) paramsMap.get("senderProfileURL");
		String groupDetailURL = (String) paramsMap.get("discussionUrl");
		String groupTitle = (String) paramsMap.get("groupTitle");
		String senderName = (String) paramsMap.get("senderName");
		String portalSigninUrl = (String) paramsMap.get("portalSigninUrl");
		String subject = "New comment added";
		String body =
				"<p>Greetings,</p>"
						+ "<p><a href=\"" + portalSigninUrl + "[$PROFILE_URL$]\" target=\"_blank\">[$FROM_NAME$]</a> added new comment in the discussion <a href=\"[$GROUP_DETAIL_URL$]\" target=\"_blank\">[$GROUP_TITLE$]</a>.</p>";

		body =
				StringUtil.replace(body, new String[] {
						"[$PROFILE_URL$]", "[$FROM_NAME$]", "[$GROUP_TITLE$]", "[$GROUP_DETAIL_URL$]"
				}, new String[] {
						senderProfileURL, senderName, groupTitle, groupDetailURL
				});
		return new String[] {
				subject, body
		};
	}

	private String getChildCommentHtml(CommentBo commentBo, ThemeDisplay themeDisplay, boolean isMember) {
		long commentId = commentBo.getCommentId();
		String content = commentBo.getContent();
		String displayDate = commentBo.getDisplayDate();
		long actorId = commentBo.getUserId();
		String screenName = commentBo.getScreenName();
		String fullName = commentBo.getFullName();
		String profileURL = "/" + screenName;
		String userThumbnailURL = commentBo.getPortraitUrl();

		String html = "<li data-comment-id=\"" + commentId
				+ "\" data-comment-is-parent=\"false\" class=\"sp-gd-entry level22\">"
				+ "<div class=\"sp-gd-entry-inner\">" + "<div class=\"avatar-wrap\"><a href=\"" + profileURL
				+ "\"><img alt=\"" + screenName +"\" src=\"" + userThumbnailURL + "\" class=\"avatar\"/></a></div>"
				+ "<div class=\"sp-gd-content-wrap\">" + "<div class=\"sp-gd-content\">" + "<a href=\"" + profileURL
				+ "\" class=\"sp-group-fwb\">" + fullName + "</a> - " + "<span>" + content + "</span>";

		long currentUserId = themeDisplay.getUserId();
		html += "<div class=\"sp-group-fss\"><span class=\"sp-group-fcl\">" + displayDate + "</span>";

		if (themeDisplay.isSignedIn() && isMember) {
			html += "<span> - </span><a data-comment-dom-id=\"add-reply-link\" href=\"#\">Reply</a>";
			boolean isOwner = (actorId == currentUserId) ? true : false;

			if (isOwner) {
				html += "<span> - </span><a href=\"#\" data-comment-dom-id=\"delete-link\">Delete</a>";
			}
		}

		html += "</div></div></div></div></li>";
		return html;
	}

	private CommentJsonListBo populateChildJsonList(ThemeDisplay themeDisplay, long parentId, int cStart, int cOffset, boolean isMember)
			throws PortalException, SystemException {
		List<CommentJsonBo> commentJsonBos = new ArrayList<CommentJsonBo>();
		List<CommentBo> childCommentBos = getChildCommentBos(parentId, cStart, cOffset);

		for (CommentBo childCommentBo : childCommentBos) {
			String html = getChildCommentHtml(childCommentBo, themeDisplay, isMember);
			CommentJsonBo commentJsonBo = new CommentJsonBo(html);
			commentJsonBos.add(commentJsonBo);
		}

		CommentJsonListBo commentJsonListBo = new CommentJsonListBo(commentJsonBos);
		return commentJsonListBo;
	}

	private CommentBo getParentCommentBo(long discussionId, int cStart, int cOffset) throws SystemException,
			PortalException {
		MBMessage parentComment = MBMessageLocalServiceUtil.getMBMessage(discussionId);
		long parentCommentId = parentComment.getMessageId();
		long userId = parentComment.getUserId();
		User actor = UserLocalServiceUtil.getUserById(userId);
		CommentBo parentCommentBo = new CommentBo(parentComment);
		parentCommentBo.setFullName(actor.getFullName());
		parentCommentBo.setScreenName(actor.getScreenName());
		parentCommentBo.setPortraitId(actor.getPortraitId());
		List<CommentBo> childCommentBos = getChildCommentBos(parentCommentId, cStart, cOffset);
		parentCommentBo.setChildCommentBos(childCommentBos);

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(MBMessage.class,
				PortalClassLoaderUtil.getClassLoader());
		dynamicQuery.add(PropertyFactoryUtil.forName("parentMessageId").eq(new Long(parentCommentId)));
		dynamicQuery.addOrder(OrderFactoryUtil.desc("createDate"));

		long childCount = MBMessageLocalServiceUtil.dynamicQueryCount(dynamicQuery);
		parentCommentBo.setChildCount(childCount);

		return parentCommentBo;
	}
	
	private void addNewCommentNotification(SPGroup spGroup,
			String spGroupDetailURL, String discussionUrl, String discussionName, Long commenterUserId,
			ResourceRequest resourceRequest) throws Exception {
		Date now = new Date();
		ServiceContext serviceContext = ServiceContextFactory
				.getInstance(resourceRequest);

		List<SPGroupUser> members = SPGroupUserLocalServiceUtil
				.findBySPGroupId(spGroup.getSpGroupId());
		JSONObject payloadJSON = JSONFactoryUtil.createJSONObject();
		payloadJSON.put(Field.USER_ID, commenterUserId);
		payloadJSON.put(SPGroupConstants.NOTIFICATIONS.USER_NAME,
				UserLocalServiceUtil.getUser(commenterUserId).getFullName());
		payloadJSON.put(SPGroupConstants.NOTIFICATIONS.GROUP_URL,
				spGroupDetailURL);
		payloadJSON.put(SPGroupConstants.NOTIFICATIONS.GROUP_NAME,
				spGroup.getTitle());
		payloadJSON.put(SPGroupConstants.NOTIFICATIONS.DISC_URL,
				discussionUrl);
		payloadJSON.put(SPGroupConstants.NOTIFICATIONS.DISC_NAME,
				discussionName);
		payloadJSON.put(SPGroupConstants.NOTIFICATIONS.GROUP_IMAGE,
				PortalUtil.getPortalURL(resourceRequest) + "/image/image_gallery?img_id="
						+ spGroup.getImageId() + "&t=" + now.getTime());
		payloadJSON.put(SPGroupConstants.NOTIFICATIONS.NOTIFICATION_TYPE,
				SPGroupConstants.NOTIFICATIONS.NOTIFICATION_TYPE_USER_COMMENT);
		for (SPGroupUser spGroupUser : members) {
			if (commenterUserId == spGroupUser.getUserId())
				continue;
			UserNotificationEventLocalServiceUtil
					.addUserNotificationEvent(spGroupUser.getUserId(),
							SPGroupConstants.PORTLET_ID_GROUP_DETAIL, now.getTime(),
							commenterUserId, payloadJSON.toString(), false,
							serviceContext);
		}
	}

	private static Log _log = LogFactoryUtil.getLog(SPGroupDiscussionDetailAction.class);

}
