package com.sambaash.platform.portlet.votingncomment.action;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.ResourceURL;
import javax.servlet.http.HttpServletRequest;

//import com.sambaash.platform.srv.contestmemberinfo.NoSuchContestAssetTypeException;
//import com.sambaash.platform.srv.contestmemberinfo.service.ContestAssetTypeLocalServiceUtil;
//import sambaash.platform.srv.servicecomponent.service.ServiceComponentsLocalServiceUtil;

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
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ClassNameLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.blogs.model.BlogsEntry;
import com.liferay.portlet.messageboards.model.MBMessage;
import com.liferay.portlet.messageboards.model.MBMessageDisplay;
import com.liferay.portlet.messageboards.model.MBThread;
import com.liferay.portlet.messageboards.model.MBTreeWalker;
import com.liferay.portlet.messageboards.service.MBMessageLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.sambaash.platform.constant.SambaashConstants;
import com.sambaash.platform.portlet.votingncomment.util.ActionUtil;
import com.sambaash.platform.portlet.votingncomment.wrapper.CommentBo;
import com.sambaash.platform.portlet.votingncomment.wrapper.CommentJsonBo;
import com.sambaash.platform.portlet.votingncomment.wrapper.CommentJsonListBo;
import com.sambaash.platform.srv.spasset.model.SPAssetType;
import com.sambaash.platform.srv.spasset.service.SPAssetTypeLocalServiceUtil;
import com.sambaash.platform.srv.spservices.model.SPParameter;
import com.sambaash.platform.srv.spservices.service.SPParameterLocalServiceUtil;
import com.sambaash.platform.srv.spvoting.AlreadyVotedException;
import com.sambaash.platform.srv.spvoting.NoSuchSPVotingException;
import com.sambaash.platform.srv.spvoting.service.SPVotingLocalServiceUtil;

/**
 * Portlet implementation class VotingNCommentAction
 */
public class VotingNCommentAction extends MVCPortlet {

	@Override
	public void doEdit(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		try {
			PortletPreferences preferences = renderRequest.getPreferences();

			long selectedSPAssetTypeId = Long.valueOf(preferences.getValue("selectedSPAssetTypeId", "0"));

			List<SPAssetType> assetTypes = getAssetTypes();
			renderRequest.setAttribute("assetTypes", assetTypes);

			renderRequest.setAttribute("selectedSPAssetTypeId", selectedSPAssetTypeId);

		} catch (Exception e) {
			_log.error(e.getMessage(), e);
		}

		super.doEdit(renderRequest, renderResponse);
	}

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay)renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

			String ip = PortalUtil.getHttpServletRequest(renderRequest).getRemoteAddr();
			renderRequest.setAttribute("ip", ip);

			PortletPreferences preferences = renderRequest.getPreferences();
			String itermsPerPageStr = preferences.getValue("itermsPerPage", "8");
			int itermsPerPage = 8;
			try {
				itermsPerPage = Integer.valueOf(itermsPerPageStr);
			} catch (NumberFormatException nfe) {

				// do nothing

			}

			long selectedSPAssetTypeId = Long.valueOf(preferences.getValue("selectedSPAssetTypeId", "0"));
			renderRequest.setAttribute("itermsPerPage", itermsPerPage);

			String blogAlias = preferences.getValue("blogAlias", "blog");

			String currentURL = URLDecoder.decode(themeDisplay.getURLCurrent(), "UTF-8");

			String assetAlias = StringPool.BLANK;
			String urlTitle = StringPool.BLANK;
			String[] currentURLArray = currentURL.split("/-/");

			if (currentURLArray.length >= 2) {
				String assetAliasAndUrlTitle = currentURLArray[1];
				int startOfSlash = assetAliasAndUrlTitle.indexOf("/");
				int startOfQuestionMark = assetAliasAndUrlTitle.indexOf("?");

				if (startOfSlash != -1) {
					assetAlias = assetAliasAndUrlTitle.substring(0, startOfSlash);

					if (startOfQuestionMark != -1) {
						urlTitle = assetAliasAndUrlTitle.substring(startOfSlash + 1, startOfQuestionMark);
					}else {
						urlTitle = assetAliasAndUrlTitle.substring(startOfSlash + 1, assetAliasAndUrlTitle.length());
					}
				}
			}

			boolean enableContextRegistration = Boolean.valueOf(preferences.getValue("enableContextRegistration", StringPool.FALSE));
			renderRequest.setAttribute("enableContextRegistration", enableContextRegistration);

			boolean commentToVote = Boolean.valueOf(preferences.getValue("commentToVote", StringPool.FALSE));
			boolean participantVoting = false;
			HttpServletRequest httpRequest = PortalUtil.getHttpServletRequest(renderRequest);
			HttpServletRequest originalHttpRequest = PortalUtil.getOriginalServletRequest(httpRequest);
			String participant = originalHttpRequest.getParameter("participant");

			if ("voting".equalsIgnoreCase(participant)) {
				commentToVote = true;
				participantVoting = true;
			}

			renderRequest.setAttribute("commentToVote", commentToVote);
			renderRequest.setAttribute("participantVoting", participantVoting);

			long classPK = 0;
			String className = StringPool.BLANK;

			if (blogAlias.equalsIgnoreCase(assetAlias)) {
				BlogsEntry currentBlogsEntry = ActionUtil.getEntry(renderRequest, urlTitle);
				classPK = currentBlogsEntry.getEntryId();
				className = BlogsEntry.class.getName();
			}

			boolean isContestMember = false;
			boolean noAssetFound = true;

			if (classPK > 0 && Validator.isNotNull(className)) {
				noAssetFound = false;
				isContestMember = true;
				/*try {
					//ContestAssetTypeLocalServiceUtil.findByUserIdAndAssetTypeId(themeDisplay.getUserId(), selectedSPAssetTypeId);
					//isContestMember = true;
				}//catch (NoSuchContestAssetTypeException nscate) {

				}*/

				// voting

				boolean voted = false;

				if (themeDisplay.isSignedIn()) {
					long userId = themeDisplay.getUserId();
					try {
						SPVotingLocalServiceUtil.findByEntryAndUserId(className, classPK, userId);
						voted = true;
					}catch (NoSuchSPVotingException nsve) {

						// do nothing

					}
				}else {
					try {
						SPVotingLocalServiceUtil.findByEntryAndIp(className, classPK, ip);
						voted = true;
					}catch (NoSuchSPVotingException nsve) {

						// do nothing

					}
				}

				renderRequest.setAttribute("voted", voted);

				// comment

				renderRequest.setAttribute("classPK", classPK);
				renderRequest.setAttribute("className", className);

				long classNameId = ClassNameLocalServiceUtil.getClassNameId(className);

				String threadView = PropsUtil.get(PropsKeys.DISCUSSION_THREAD_VIEW);

				MBMessageDisplay messageDisplay = MBMessageLocalServiceUtil.getDiscussionMessageDisplay(themeDisplay.getUserId(),
						themeDisplay.getScopeGroupId(), className, classPK, WorkflowConstants.STATUS_ANY, threadView);

				MBThread thread = messageDisplay.getThread();
				MBTreeWalker treeWalker = messageDisplay.getTreeWalker();
				MBMessage rootMessage = null;

				if (treeWalker != null) {
					rootMessage = treeWalker.getRoot();
				} else {
					rootMessage = MBMessageLocalServiceUtil.getMessage(thread.getRootMessageId());
				}

//				int pStart = 0;
//				int pOffset = 5;
//				int cStart = 0;
//				int cOffset = 3;
//
//				List<CommentBo> parentCommentBos = getParentCommentBos(classPK, classNameId, rootMessage.getMessageId(), pStart, pOffset, cStart, cOffset);
//				renderRequest.setAttribute("parentCommentBos", parentCommentBos);

				DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(MBMessage.class, PortalClassLoaderUtil.getClassLoader());
				dynamicQuery.add(PropertyFactoryUtil.forName("messageId").ne(new Long(rootMessage.getMessageId())));
				dynamicQuery.add(PropertyFactoryUtil.forName("parentMessageId").eq(rootMessage.getMessageId()));
				dynamicQuery.add(PropertyFactoryUtil.forName("classPK").eq(new Long(classPK)));
				dynamicQuery.add(PropertyFactoryUtil.forName("classNameId").eq(new Long(classNameId)));
				dynamicQuery.addOrder(OrderFactoryUtil.desc("createDate"));

				long parentCount = MBMessageLocalServiceUtil.dynamicQueryCount(dynamicQuery);

				renderRequest.setAttribute("parentCount", parentCount);
			}

			// membership

			boolean commentServiceHasAccess = false;
			String commentServiceUserStatus = null;
			String commentServiceStrutsAction = StringPool.BLANK;
			SPParameter commentServiceParameter = SPParameterLocalServiceUtil.findBySPParameterGroupIdAndName(
					themeDisplay.getScopeGroupId(), SambaashConstants.MEMBERSHIP_SERVICECOMPONENTS.SPASSET_COMMENT);
			commentServiceStrutsAction = commentServiceParameter.getValue();
			Map<String, Object> parameterMap = new HashMap<String, Object>();
			parameterMap.put("struts_action", commentServiceStrutsAction);
			parameterMap.put("groupId", new Long(themeDisplay.getScopeGroupId()));

/**
			Map<String, Object> commentServiceHasAccessMap = ServiceComponentsLocalServiceUtil
					.hasAccess(parameterMap, themeDisplay.getUser());
			commentServiceHasAccess = (Boolean)commentServiceHasAccessMap.get(SambaashConstants.MEMBERSHIP.SERVICE_HASACCESS);
			commentServiceUserStatus = (String)commentServiceHasAccessMap.get(SambaashConstants.MEMBERSHIP.SERVICE_REDIRECTURL);

			renderRequest.setAttribute("commentServiceHasAccess", commentServiceHasAccess || true);
			renderRequest.setAttribute("commentServiceUserStatus", commentServiceUserStatus);

			_commentServiceHasAccess = commentServiceHasAccess || true;
			_commentServiceUserStatus = commentServiceUserStatus;
	**/
			renderRequest.setAttribute("noAssetFound", noAssetFound);
			renderRequest.setAttribute("isContestMember", isContestMember);

		} catch (Exception e) {
			_log.error(e.getMessage(), e);
		}

		super.doView(renderRequest, renderResponse);
	}

	@Override
	public void processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, PortletException {
		try {
			PortletPreferences preferences = actionRequest.getPreferences();
			String action = actionRequest.getParameter("action");

			if (Constants.EDIT.equalsIgnoreCase(action)) {
				String itermsPerPage = actionRequest.getParameter("itermsPerPage");
				String enableVoting = actionRequest.getParameter("enableVoting");
				String enableComment = actionRequest.getParameter("enableComment");
				String commentToVote = actionRequest.getParameter("commentToVote");
				String showComments = actionRequest.getParameter("showComments");
				String selectedSPAssetTypeId = actionRequest.getParameter("selectedSPAssetTypeId");
				String blogAlias = actionRequest.getParameter("blogAlias");
				String enableContextRegistration = actionRequest.getParameter("enableContextRegistration");

				preferences.setValue("itermsPerPage", itermsPerPage);
				preferences.setValue("enableVoting", enableVoting);
				preferences.setValue("enableComment", enableComment);
				preferences.setValue("commentToVote", commentToVote);
				preferences.setValue("showComments", showComments);
				preferences.setValue("selectedSPAssetTypeId", selectedSPAssetTypeId);
				preferences.setValue("blogAlias", blogAlias);
				preferences.setValue("enableContextRegistration", enableContextRegistration);
				preferences.store();
				addSuccessMessage(actionRequest, actionResponse);
			}
		} catch (Exception e) {
			_log.error(e.getMessage(), e);
		}

		super.processAction(actionRequest, actionResponse);
	}

	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException, PortletException {
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay)resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);

			String action = resourceRequest.getParameter("action");

			if ("retrieveComments".equalsIgnoreCase(action)) {
				resourceResponse.setContentType("application/json");
				resourceResponse.setCharacterEncoding("utf-8");
				resourceResponse.getWriter().write(retrieveCommentsJsonString(resourceRequest, resourceResponse, themeDisplay));
			} else if ("retrieveReplies".equalsIgnoreCase(action)) {
				resourceResponse.setContentType("application/json");
				resourceResponse.setCharacterEncoding("utf-8");
				resourceResponse.getWriter().write(retrieveRepliesJsonString(resourceRequest, themeDisplay));
			} else if ("addComment".equalsIgnoreCase(action)) {
				resourceResponse.setContentType("application/json");
				resourceResponse.setCharacterEncoding("utf-8");
				resourceResponse.getWriter().write(addCommentJsonString(resourceRequest, resourceResponse, themeDisplay));
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

	@SuppressWarnings("unchecked")
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

			DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(MBMessage.class, PortalClassLoaderUtil.getClassLoader());
			dynamicQuery.add(PropertyFactoryUtil.forName("parentMessageId").eq(new Long(commentId)));
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

	private String addCommentJsonString(ResourceRequest resourceRequest, ResourceResponse resourceResponse, ThemeDisplay themeDisplay)
			throws PortalException, SystemException {
		String classPKStr = resourceRequest.getParameter("class_pk");
		String className = resourceRequest.getParameter("class_name");
		String commentToVote = resourceRequest.getParameter("comment_to_vote");

		String content = resourceRequest.getParameter("content");

		long scopeGroupId = themeDisplay.getScopeGroupId();

		long classPK = 0;
		try {
			classPK = Long.valueOf(classPKStr);
		} catch (NumberFormatException nfe) {
		}

		long currentUserId = themeDisplay.getUserId();

		if (StringPool.TRUE.equalsIgnoreCase(commentToVote)) {
			try {
				SPVotingLocalServiceUtil.voteUp(className, classPK, currentUserId, "", true);
			}catch (AlreadyVotedException ave) {

				// do nothing

			}
		}

		String currentUserScreenName = themeDisplay.getUser().getScreenName();
		long portraitId = themeDisplay.getUser().getPortraitId();

		String threadView = PropsUtil.get(PropsKeys.DISCUSSION_THREAD_VIEW);

		MBMessageDisplay messageDisplay = MBMessageLocalServiceUtil.getDiscussionMessageDisplay(currentUserId, scopeGroupId, className, classPK,
				WorkflowConstants.STATUS_ANY, threadView);

		MBThread thread = messageDisplay.getThread();
		MBTreeWalker treeWalker = messageDisplay.getTreeWalker();
		MBMessage rootMessage = null;

		if (treeWalker != null) {
			rootMessage = treeWalker.getRoot();
		} else {
			rootMessage = MBMessageLocalServiceUtil.getMessage(thread.getRootMessageId());
		}

		String subject = StringPool.BLANK;
		String body = content;
		ServiceContext serviceContext = ServiceContextFactory.getInstance(MBMessage.class.getName(), resourceRequest);

		MBMessage mbmsg = MBMessageLocalServiceUtil.addDiscussionMessage(currentUserId, currentUserScreenName, scopeGroupId, className, classPK,
				thread.getThreadId(), rootMessage.getMessageId(), subject, body, serviceContext);

		mbmsg.setBody(content);
		MBMessageLocalServiceUtil.updateMBMessage(mbmsg);

		CommentBo parentCommentBo = new CommentBo(mbmsg);
		parentCommentBo.setScreenName(currentUserScreenName);
		parentCommentBo.setPortraitId(portraitId);

		int cStart = 0;
		int cOffset = 3;
		long childCount = 0;
		parentCommentBo.setChildCount(childCount);

		JSONObject dataJSONObject = JSONFactoryUtil.createJSONObject();
		String html = getParentCommentHtml(resourceResponse, classPK, className, parentCommentBo, themeDisplay, cStart, cOffset);
		dataJSONObject.put("html", html);
		dataJSONObject.put("class_pk", classPK);

		return dataJSONObject.toString();
	}

	private String addReplyJsonString(ResourceRequest resourceRequest, ThemeDisplay themeDisplay) throws PortalException, SystemException {
		String classPKStr = resourceRequest.getParameter("class_pk");
		String className = resourceRequest.getParameter("class_name");
		String parentIdStr = resourceRequest.getParameter("parent_id");
		String content = resourceRequest.getParameter("content");

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
		long portraitId = themeDisplay.getUser().getPortraitId();

		MBMessage mbmsg = MBMessageLocalServiceUtil.addDiscussionMessage(currentUserId, currentUserScreenName, themeDisplay.getScopeGroupId(),
				className, classPK, workflowAction);
		mbmsg.setParentMessageId(parentId);
		mbmsg.setBody(content);
		MBMessageLocalServiceUtil.updateMBMessage(mbmsg);

		CommentBo childCommentBo = new CommentBo(mbmsg);
		childCommentBo.setScreenName(currentUserScreenName);
		childCommentBo.setPortraitId(portraitId);

		JSONObject dataJSONObject = JSONFactoryUtil.createJSONObject();
		String html = getChildCommentHtml(childCommentBo, themeDisplay);
		dataJSONObject.put("html", html);
		dataJSONObject.put("class_pk", classPK);
		dataJSONObject.put("parent_id", parentId);

		return dataJSONObject.toString();
	}

	private String retrieveCommentsJsonString(ResourceRequest resourceRequest, ResourceResponse resourceResponse, ThemeDisplay themeDisplay)
			throws PortalException, SystemException {
		JSONObject dataJSONObject = JSONFactoryUtil.createJSONObject();
		JSONArray itemsJSONArray = JSONFactoryUtil.createJSONArray();
		CommentJsonListBo commentJsonListBo = retrieveComments(resourceRequest, resourceResponse, themeDisplay);
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

	private CommentJsonListBo retrieveComments(ResourceRequest resourceRequest, ResourceResponse resourceResponse, ThemeDisplay themeDisplay)
			throws PortalException, SystemException {
		String classPKStr = resourceRequest.getParameter("class_pk");
		String className = resourceRequest.getParameter("class_name");
		String initTotalStr = resourceRequest.getParameter("init_total");
		String curShowingNoStr = resourceRequest.getParameter("cur_showing_no");
		String offsetStr = resourceRequest.getParameter("offset");

		long classPK = 0;
		int curShowingNo = 0;
		int initTotal = 0;
		int offset = 0;

		try {
			classPK = Long.valueOf(classPKStr);
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

		long classNameId = ClassNameLocalServiceUtil.getClassNameId(className);

		String threadView = PropsUtil.get(PropsKeys.DISCUSSION_THREAD_VIEW);

		MBMessageDisplay messageDisplay = MBMessageLocalServiceUtil.getDiscussionMessageDisplay(themeDisplay.getUserId(),
				themeDisplay.getScopeGroupId(), className, classPK, WorkflowConstants.STATUS_ANY, threadView);

		MBThread thread = messageDisplay.getThread();
		MBTreeWalker treeWalker = messageDisplay.getTreeWalker();
		MBMessage rootMessage = null;

		if (treeWalker != null) {
			rootMessage = treeWalker.getRoot();
		} else {
			rootMessage = MBMessageLocalServiceUtil.getMessage(thread.getRootMessageId());
		}

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(MBMessage.class, PortalClassLoaderUtil.getClassLoader());
		dynamicQuery.add(PropertyFactoryUtil.forName("messageId").ne(new Long(rootMessage.getMessageId())));
		dynamicQuery.add(PropertyFactoryUtil.forName("parentMessageId").eq(new Long(rootMessage.getMessageId())));
		dynamicQuery.add(PropertyFactoryUtil.forName("classPK").eq(new Long(classPK)));
		dynamicQuery.add(PropertyFactoryUtil.forName("classNameId").eq(new Long(classNameId)));
		dynamicQuery.addOrder(OrderFactoryUtil.desc("createDate"));

		long countL = MBMessageLocalServiceUtil.dynamicQueryCount(dynamicQuery);

		// Catch this exception, we'll see ...

		int count = safeLongToInt(countL);

		if (curShowingNo > 0) {
			int balance = 0;
			balance = count - initTotal;
			start += balance;
		}

		int cStart = 0;
		int cOffset = 3;

		return populateParentCommentJsonList(resourceResponse, themeDisplay, classPK, className, start, offset, cStart, cOffset);
	}

	private String retrieveRepliesJsonString(ResourceRequest resourceRequest, ThemeDisplay themeDisplay) throws PortalException, SystemException {
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

	private CommentJsonListBo retrieveReplies(ResourceRequest resourceRequest, ThemeDisplay themeDisplay) throws PortalException, SystemException {
		String parentIdStr = resourceRequest.getParameter("parent_id");
		String initTotalStr = resourceRequest.getParameter("init_total");
		String curShowingNoStr = resourceRequest.getParameter("cur_showing_no");
		String offsetStr = resourceRequest.getParameter("offset");

		long parentId = 0;
		int curShowingNo = 0;
		int initTotal = 0;
		int offset = 0;

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
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(MBMessage.class, PortalClassLoaderUtil.getClassLoader());
		dynamicQuery.add(PropertyFactoryUtil.forName("parentMessageId").eq(new Long(parentId)));
		dynamicQuery.addOrder(OrderFactoryUtil.desc("createDate"));
		long childCountL = MBMessageLocalServiceUtil.dynamicQueryCount(dynamicQuery);
		int childCount = safeLongToInt(childCountL);

		int balance = 0;
		balance = childCount - initTotal;
		start += balance;

		return populateChildJsonList(themeDisplay, parentId, start, offset);
	}

	@SuppressWarnings("unchecked")
	private List<CommentBo> getParentCommentBos(long classPK, long classNameId, long rootMessageId, int pStart, int pOffset, int cStart, int cOffset)
			throws PortalException, SystemException {
		List<CommentBo> parentCommentBos = new ArrayList<CommentBo>();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(MBMessage.class, PortalClassLoaderUtil.getClassLoader());
		dynamicQuery.add(PropertyFactoryUtil.forName("messageId").ne(new Long(rootMessageId)));
		dynamicQuery.add(PropertyFactoryUtil.forName("parentMessageId").eq(new Long(rootMessageId)));
		dynamicQuery.add(PropertyFactoryUtil.forName("classPK").eq(new Long(classPK)));
		dynamicQuery.add(PropertyFactoryUtil.forName("classNameId").eq(new Long(classNameId)));
		dynamicQuery.addOrder(OrderFactoryUtil.desc("createDate"));

		List<MBMessage> parentComments = MBMessageLocalServiceUtil.dynamicQuery(dynamicQuery, pStart, pStart + pOffset);

		for (MBMessage parentComment : parentComments) {
			long parentCommentId = parentComment.getMessageId();
			long userId = parentComment.getUserId();
			User actor = UserLocalServiceUtil.getUserById(userId);
			CommentBo parentCommentBo = new CommentBo(parentComment);
			parentCommentBo.setScreenName(actor.getScreenName());
			parentCommentBo.setPortraitId(actor.getPortraitId());
			List<CommentBo> childCommentBos = getChildCommentBos(parentCommentId, cStart, cOffset);
			parentCommentBo.setChildCommentBos(childCommentBos);

			dynamicQuery = DynamicQueryFactoryUtil.forClass(MBMessage.class, PortalClassLoaderUtil.getClassLoader());
			dynamicQuery.add(PropertyFactoryUtil.forName("parentMessageId").eq(new Long(parentCommentId)));
			dynamicQuery.addOrder(OrderFactoryUtil.desc("createDate"));

			long childCount = MBMessageLocalServiceUtil.dynamicQueryCount(dynamicQuery);
			parentCommentBo.setChildCount(childCount);
			parentCommentBos.add(parentCommentBo);
		}

		return parentCommentBos;
	}

	@SuppressWarnings("unchecked")
	private List<CommentBo> getChildCommentBos(long parentId, int cStart, int cOffset) throws PortalException, SystemException {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(MBMessage.class, PortalClassLoaderUtil.getClassLoader());
		dynamicQuery = DynamicQueryFactoryUtil.forClass(MBMessage.class, PortalClassLoaderUtil.getClassLoader());
		dynamicQuery.add(PropertyFactoryUtil.forName("parentMessageId").eq(new Long(parentId)));
		dynamicQuery.addOrder(OrderFactoryUtil.desc("createDate"));

		List<MBMessage> childComments = MBMessageLocalServiceUtil.dynamicQuery(dynamicQuery, cStart, cStart + cOffset);

		List<CommentBo> childCommentBos = new ArrayList<CommentBo>();

		for (MBMessage childComment : childComments) {
			CommentBo childCommentBo = new CommentBo(childComment);
			long userId = childComment.getUserId();
			User actor = UserLocalServiceUtil.getUserById(userId);
			childCommentBo.setScreenName(actor.getScreenName());
			childCommentBo.setPortraitId(actor.getPortraitId());
			childCommentBos.add(childCommentBo);
		}

		return childCommentBos;
	}

	private CommentJsonListBo populateParentCommentJsonList(ResourceResponse resourceResponse, ThemeDisplay themeDisplay, long classPK,
			String className, int pStart, int pOffset, int cStart, int cOffset) throws PortalException, SystemException {
		List<CommentJsonBo> commentJsonBos = new ArrayList<CommentJsonBo>();
		long classNameId = ClassNameLocalServiceUtil.getClassNameId(className);

		String threadView = PropsUtil.get(PropsKeys.DISCUSSION_THREAD_VIEW);

		MBMessageDisplay messageDisplay = MBMessageLocalServiceUtil.getDiscussionMessageDisplay(themeDisplay.getUserId(),
				themeDisplay.getScopeGroupId(), className, classPK, WorkflowConstants.STATUS_ANY, threadView);

		MBThread thread = messageDisplay.getThread();
		MBTreeWalker treeWalker = messageDisplay.getTreeWalker();
		MBMessage rootMessage = null;

		if (treeWalker != null) {
			rootMessage = treeWalker.getRoot();
		} else {
			rootMessage = MBMessageLocalServiceUtil.getMessage(thread.getRootMessageId());
		}

		List<CommentBo> parentCommentBos = getParentCommentBos(classPK, classNameId, rootMessage.getMessageId(), pStart, pOffset, cStart, cOffset);

		for (CommentBo parentCommentBo : parentCommentBos) {
			String html = getParentCommentHtml(resourceResponse, classPK, className, parentCommentBo, themeDisplay, cStart, cOffset);
			CommentJsonBo commentJsonBo = new CommentJsonBo(html);
			commentJsonBos.add(commentJsonBo);
		}

		CommentJsonListBo commentJsonListBo = new CommentJsonListBo(commentJsonBos);
		return commentJsonListBo;
	}

	private CommentJsonListBo populateChildJsonList(ThemeDisplay themeDisplay, long parentId, int cStart, int cOffset) throws PortalException,
			SystemException {
		List<CommentJsonBo> commentJsonBos = new ArrayList<CommentJsonBo>();
		List<CommentBo> childCommentBos = getChildCommentBos(parentId, cStart, cOffset);

		for (CommentBo childCommentBo : childCommentBos) {
			String html = getChildCommentHtml(childCommentBo, themeDisplay);
			CommentJsonBo commentJsonBo = new CommentJsonBo(html);
			commentJsonBos.add(commentJsonBo);
		}

		CommentJsonListBo commentJsonListBo = new CommentJsonListBo(commentJsonBos);
		return commentJsonListBo;
	}

	private String getParentCommentHtml(ResourceResponse resourceResponse, long classPK, String className, CommentBo parentCommentBo,
			ThemeDisplay themeDisplay, int cStart, int cOffset) throws PortalException, SystemException {
		long parentCommentId = parentCommentBo.getCommentId();
		String content = parentCommentBo.getContent();
		String displayDate = parentCommentBo.getDisplayDate();
		long actorId = parentCommentBo.getUserId();
		String screenName = parentCommentBo.getScreenName();
		String userThumbnailURL = "/image/user_male_portrait?img_id=" + parentCommentBo.getPortraitId();
		String profileURL = "/" + screenName;

		String html = "<li data-vnc-comment-is-parent=\"true\" data-vnc-comment-id=\"" + parentCommentId + "\" class=\"sp-comment-entry level1\">"
				+ "<div class=\"sp-comment-entry-inner\">" + "<a href=\"" + profileURL + "\"><img alt=\""+ screenName +"\" class=\"avatar\" src=\"" + userThumbnailURL
				+ "\"/></a>" + "<div class=\"sp-comment-content-wrap\">" + "<div class=\"sp-comment-content\">" + "<a class=\"sp-fwb\" href=\""
				+ profileURL + "\">" + screenName + "</a>" + " - <span class=\"sp-fcl\">" + displayDate + "</span>" + "<div>" + content + "</div>";

		long currentUserId = themeDisplay.getUserId();

		if (themeDisplay.isSignedIn()) {
			boolean isOwner = (actorId == currentUserId) ? true : false;
			html += "<div class=\"sp-fss\"><a data-vnc-comment-dom-id=\"add-reply-link\" href=\"#\">Reply</a>";

			if (isOwner) {
				html += "&nbsp;<a href=\"#\" data-vnc-comment-dom-id=\"delete-link\">Delete</a></div>";
			}
		}

		html += "</div>";

		html += "<div data-vnc-loadmore-dom-id=\"loadmore-container\" class=\"sp-comment-reply-container\">"
				+ "<ul data-vnc-comment-dom-id=\"child-entry-container\" data-vnc-loadmore-dom-id=\"items-container\" class=\"sp-child-entry-container\">";

		long childCount = parentCommentBo.getChildCount();
		List<CommentBo> childCommentBos = this.getChildCommentBos(parentCommentId, cStart, cOffset);

		for (CommentBo childCommentBo : childCommentBos) {
			html += getChildCommentHtml(childCommentBo, themeDisplay);
		}

		html += "</ul>";
		html += "<div ";

		if (childCount <= childCommentBos.size()) {
			html += "style=\"display: none;\"";
		}

		ResourceURL retrieveRepliesResourceURL = resourceResponse.createResourceURL();
		retrieveRepliesResourceURL.setParameter("action", "retrieveReplies");

		html += "data-vnc-loadmore-dom-id=\"view-more-link-container\" class=\"sp-comment-children-more\"><a data-vnc-loadmore-dom-id=\"view-more-link\" data-vnc-loadmore=\"{ &quot;retrieve_url&quot; : &quot;" +
				retrieveRepliesResourceURL.toString()
				+ "&quot;, &quot;retrieve_params&quot; : {&quot;parent_id&quot; : &quot;" +
				parentCommentId +
				"&quot;, &quot;offset&quot; : " +
				cOffset +
				", &quot;cur_showing_no&quot; : " +
				childCommentBos.size() +
				", &quot;init_total&quot; : " +
				childCount
				+ "}, &quot;no_results_msg&quot; : &quot;&quot;, &quot;no_more_results_msg&quot; : &quot;&quot;, &quot;error_msg&quot; : &quot;This stream is unavailable at this time. Please try again soon.&quot; }\" href=\"#\">View <span data-vnc-loadmore-dom-id=\"unshown-status\">" +
				(childCount - childCommentBos.size())
				+ "</span> more <span class=\"arrow arrow-down arrow-down-lightblue arrow-down-small\"></span></a></div>";
		html += "<div data-vnc-loadmore-dom-id=\"loading-status\" style=\"display: none;\" align=\"center\"><span>Loading...</span></div>";
		html += "<div data-vnc-loadmore-dom-id=\"load-msg\" style=\"display: none;\" align=\"center\"></div>";

		if (themeDisplay.isSignedIn()) {
			html += getReplyFormHtml(resourceResponse, themeDisplay, classPK, className);
		}

		html += "</div></div></div></li>";

		return html;
	}

	private String getChildCommentHtml(CommentBo commentBo, ThemeDisplay themeDisplay) {
		long commentId = commentBo.getCommentId();
		String content = commentBo.getContent();
		String displayDate = commentBo.getDisplayDate();
		long actorId = commentBo.getUserId();
		String screenName = commentBo.getScreenName();
		String profileURL = "/" + screenName;
		String userThumbnailURL = "/image/user_male_portrait?img_id=" + commentBo.getPortraitId();

		String html = "<li data-vnc-comment-id=\"" + commentId + "\" data-vnc-comment-is-parent=\"false\" class=\"sp-comment-entry level2\">"
				+ "<div class=\"sp-comment-entry-inner\">" + "<a href=\"" + profileURL + "\"><img alt=\""+ screenName +"\" src=\"" + userThumbnailURL
				+ "\" class=\"avatar\"/></a>" + "<div class=\"sp-comment-content-wrap\">" + "<div class=\"sp-comment-content\">" + "<a href=\""
				+ profileURL + "\" class=\"sp-fwb\">" + screenName + "</a> - <span class=\"sp-fcl\">" + displayDate + "</span>" + "<div>" + content +
				"</div>";

		long currentUserId = themeDisplay.getUserId();

		if (themeDisplay.isSignedIn()) {
			html += "<div class=\"sp-fss\"><a data-vnc-comment-dom-id=\"add-reply-link\" href=\"#\">Reply</a>";
			boolean isOwner = (actorId == currentUserId) ? true : false;
			;

			if (isOwner) {
				html += "&nbsp;<a href=\"#\" data-vnc-comment-dom-id=\"delete-link\">Delete</a></div>";
			}
		}

		html += "</div></div></div></li>";
		return html;
	}

	private String getReplyFormHtml(ResourceResponse resourceResponse, ThemeDisplay themeDisplay, long classPK, String className) {
		String currentUserThumbnailURL = "/image/user_male_portrait?img_id=" + themeDisplay.getUser().getPortraitId();

		ResourceURL addReplyResourceURL = resourceResponse.createResourceURL();
		addReplyResourceURL.setParameter("action", "addReply");

		String html = "<div data-vnc-comment-dom-id=\"add-reply-form-container\" class=\"sp-comment-entry level2\" style=\"display: none;\">"
				+ "<div class=\"sp-comment-entry-inner\">" + "<img alt=\"User Image\" data-vnc-comment-dom-id=\"avatar\" src=\"" + currentUserThumbnailURL
				+ "\" class=\"avatar\"/>" + "<div style=\"margin: 0 0 8px 58px; min-height: 50px;\">"
				+ "<form data-vnc-comment-dom-id=\"add-reply-form\" action=\"" + addReplyResourceURL + "\" method=\"post\">"
				+ "<input type=\"hidden\" name=\"classPK\" value=\"" + classPK + "\"/>" + "<input type=\"hidden\" name=\"className\" value=\""
				+ className + "\"/>" + "<div class=\"sp-comment-textarea-outer\">"
				+ "<textarea data-vnc-comment-dom-id=\"add-reply-textarea\" style=\"height: 28px;\"></textarea>" + "</div>" +
				"<div align=\"right\" class=\"sp-mts\">";

		if (!_commentServiceHasAccess) {
			html += "<input type=\"button\" value=\"Reply\" class=\"sp-comment-btn small sp-service-access-check\" name=\""
					+ _commentServiceUserStatus + "&upload=false\" title=\"Permission Denied\" />";
		} else {
			html += "<input data-vnc-comment-dom-id=\"add-reply-form-sumbit-btn\" type=\"submit\" class=\"sp-comment-btn small\" value=\"Reply\" />";
		}

		html += "</div></form>" + "</div></div></div>";
		return html;
	}

	private int safeLongToInt(long l) {
		if (l < Integer.MIN_VALUE || l > Integer.MAX_VALUE) {
			throw new IllegalArgumentException(l + " cannot be cast to int without changing its value.");
		}

		return (int)l;
	}

	private List<SPAssetType> getAssetTypes() {
		List<SPAssetType> assetTypes = new ArrayList<SPAssetType>();
		try {
			int assetTypeCount = SPAssetTypeLocalServiceUtil.getSPAssetTypesCount();
			assetTypes = SPAssetTypeLocalServiceUtil.getSPAssetTypes(0, assetTypeCount);
		} catch (SystemException e) {
			_log.error(e);
		}

		return assetTypes;
	}

	private boolean _commentServiceHasAccess = false;
	private String _commentServiceUserStatus = StringPool.BLANK;

	private static Log _log = LogFactoryUtil.getLog(VotingNCommentAction.class);

}
