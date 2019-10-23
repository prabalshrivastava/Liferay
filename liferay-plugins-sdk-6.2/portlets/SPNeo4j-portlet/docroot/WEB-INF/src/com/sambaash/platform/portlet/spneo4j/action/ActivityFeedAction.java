package com.sambaash.platform.portlet.spneo4j.action;

import java.io.IOException;
import java.lang.reflect.UndeclaredThrowableException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Event;
import javax.portlet.EventRequest;
import javax.portlet.EventResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletModeException;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.ProcessEvent;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.ResourceURL;
import javax.portlet.WindowStateException;

import org.apache.commons.lang.StringEscapeUtils;
import org.htmlparser.util.ParserException;

import com.liferay.calendar.model.CalendarBooking;
import com.liferay.portal.NoSuchUserException;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.model.Layout;
import com.liferay.portal.model.User;
import com.liferay.portal.model.UserConstants;
import com.liferay.portal.service.ClassNameLocalServiceUtil;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.PortletURLFactoryUtil;
import com.liferay.portlet.blogs.NoSuchEntryException;
import com.liferay.portlet.blogs.model.BlogsEntry;
import com.liferay.portlet.blogs.service.BlogsEntryLocalServiceUtil;
import com.liferay.portlet.messageboards.model.MBMessage;
import com.liferay.portlet.messageboards.model.MBMessageDisplay;
import com.liferay.portlet.messageboards.model.MBThread;
import com.liferay.portlet.messageboards.model.MBTreeWalker;
import com.liferay.portlet.messageboards.service.MBMessageLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.sambaash.platform.constant.ClassConstant;
import com.sambaash.platform.constant.SambaashConstants;
import com.sambaash.platform.model.ActivityFeedType;
import com.sambaash.platform.model.spneo4j.wrapper.ActivityFeedGraphWrapper;
import com.sambaash.platform.model.spneo4j.wrapper.ActivityFeedsWrapper;
import com.sambaash.platform.model.spneo4j.wrapper.AssetEntityGraphWrapper;
import com.sambaash.platform.portlet.spneo4j.util.SPNeo4jConstants;
import com.sambaash.platform.portlet.spneo4j.util.Util;
import com.sambaash.platform.portlet.spneo4j.wrapper.CommentJsonListWrapper;
import com.sambaash.platform.portlet.spneo4j.wrapper.CommentJsonWrapper;
import com.sambaash.platform.portlet.spneo4j.wrapper.CommentWrapper;
import com.sambaash.platform.srv.graph.service.SPNeoforjLocalServiceUtil;
import com.sambaash.platform.srv.spasset.model.SPAssetEntry;
import com.sambaash.platform.srv.spasset.model.SPAssetType;
import com.sambaash.platform.srv.spchallenge.model.SPChallenge;
import com.sambaash.platform.srv.spchallenge.service.SPChallengeLocalServiceUtil;
import com.sambaash.platform.srv.spgroup.NoSuchSPGroupException;
import com.sambaash.platform.srv.spgroup.model.SPGroup;
import com.sambaash.platform.srv.spgroup.model.SPGroupUser;
import com.sambaash.platform.srv.spgroup.service.SPGroupLocalServiceUtil;
import com.sambaash.platform.srv.spgroup.service.SPGroupUserLocalServiceUtil;
import com.sambaash.platform.util.SPHtmlUtil;
import com.sambaash.platform.util.SambaashUtil;

/**
 * Portlet implementation class ActivityFeedAction
 */
public class ActivityFeedAction extends MVCPortlet {

	@ProcessEvent(qname = "{http://liferay.com/events}ipc.pitch")
	public void catchFilter(EventRequest request, EventResponse response) {
		Event event = request.getEvent();
		String filterType = (String) event.getValue();
		response.setRenderParameter("filterType", filterType);
	}

	@Override
	public void doEdit(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		super.doEdit(renderRequest, renderResponse);
	}

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
			long scopeGroupId = themeDisplay.getScopeGroupId();
			String communityName = SambaashUtil.getCommunityName(scopeGroupId);
			renderRequest.setAttribute("communityName", communityName);

			String websocketUrl = SambaashUtil.getParameter(SambaashConstants.WEBSOCKETS.WEBSOCKETS_HOST_URL,
					scopeGroupId);
			renderRequest.setAttribute("websocketUrl", websocketUrl);
			renderRequest.setAttribute("websocketEnabled", SambaashUtil.isWebSocketEnabled());

		} catch (Exception e) {
			_log.error(e.getMessage(), e);
		}
		super.doView(renderRequest, renderResponse);
	}

	@Override
	public void processAction(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
		PortletPreferences portletPreferences = actionRequest.getPreferences();
		try {
			String action = ParamUtil.getString(actionRequest, "action");
			if (Constants.EDIT.equalsIgnoreCase(action)) {
				String blogPageName = ParamUtil.getString(actionRequest, "blogPageName");
				String groupDetailPageName = ParamUtil.getString(actionRequest, "groupDetailPageName");
				String groupDiscussionDetailPageName = ParamUtil.getString(actionRequest,
						"groupDiscussionDetailPageName");
				portletPreferences.setValue("blogPageName", blogPageName);
				portletPreferences.setValue("groupDetailPageName", groupDetailPageName);
				portletPreferences.setValue("groupDiscussionDetailPageName", groupDiscussionDetailPageName);
				portletPreferences.store();
				addSuccessMessage(actionRequest, actionResponse);
			} else if ("filter".equalsIgnoreCase(action)) {
				// include("/html/activityfeed/view.jsp", actionRequest,
				// actionResponse);
				actionResponse.setRenderParameter("jspPage", "/html/activityfeed/view.jsp");
				actionResponse.setRenderParameter("filterType", ParamUtil.getString(actionRequest, "filterType"));

			}
		} catch (Exception e) {
			_log.error(e.getMessage(), e);
		}
		super.processAction(actionRequest, actionResponse);
	}

	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		PortletPreferences preferences = resourceRequest.getPreferences();
		try {
			String action = ParamUtil.getString(resourceRequest, "action");
			if ("retrieveRealtimeActivityFeeds".equalsIgnoreCase(action)) {
				String activitiesString = ParamUtil.getString(resourceRequest, "activitiesString");
				JSONArray activitiesJSONArray = JSONFactoryUtil.createJSONArray(activitiesString);

				resourceResponse.setContentType("application/json");
				resourceResponse.setCharacterEncoding("utf-8");
				resourceResponse.getWriter().write(retrieveRealtimeActivityFeedsJsonString(resourceRequest,
						resourceResponse, themeDisplay, preferences, activitiesJSONArray));
			} else if ("retrieveActivityFeeds".equalsIgnoreCase(action)) {
				String blogPageName = preferences.getValue("blogPageName", "spblogs");
				String groupDetailPageName = preferences.getValue("groupDetailPageName", "group-detail");
				String groupDiscussionDetailPageName = preferences.getValue("groupDiscussionDetailPageName",
						"discussion-detail");
				String eventDetailPageName = preferences.getValue("eventDetailPageName", "event-details");
				String spAssetEntryDetailPageName = preferences.getValue("spAssetEntryDetailPageName", "spassetentry");

				String curShowingNoStr = resourceRequest.getParameter("cur_showing_no");
				String offsetStr = resourceRequest.getParameter("offset");
				String filterType = ParamUtil.getString(resourceRequest, "filter_type");

				int curShowingNo = 0;
				int offset = 0;

				try {
					curShowingNo = Integer.valueOf(curShowingNoStr);
				} catch (NumberFormatException nfe) {
				}
				try {
					offset = Integer.valueOf(offsetStr);
				} catch (NumberFormatException nfe) {
				}

				int start = curShowingNo;

				ActivityFeedsWrapper activityFeedsWrapper = SPNeoforjLocalServiceUtil.findActivityFeeds(
						themeDisplay.getUserId(), themeDisplay.getCompanyId(), themeDisplay.getScopeGroupId(),
						themeDisplay.getLayoutSet().getLayoutSetId(), filterType, start, offset);

				int count = 0;

				JSONObject data = JSONFactoryUtil.createJSONObject();
				JSONArray items = JSONFactoryUtil.createJSONArray();

				if (activityFeedsWrapper != null) {
					List<ActivityFeedGraphWrapper> activityFeedGraphWrappers = activityFeedsWrapper
							.getActivityFeedGraphWrappers();
					count = activityFeedsWrapper.getActivityFeedsCount();

					Map<String, String> pageNames = new HashMap<String, String>();
					pageNames.put(SPNeo4jConstants.PARAMS_PAGE_NAME.BLOG, blogPageName);
					pageNames.put(SPNeo4jConstants.PARAMS_PAGE_NAME.SPGroup, groupDetailPageName);
					pageNames.put(SPNeo4jConstants.PARAMS_PAGE_NAME.SPGroup_Discussion, groupDiscussionDetailPageName);
					pageNames.put(SPNeo4jConstants.PARAMS_PAGE_NAME.Event, eventDetailPageName);
					pageNames.put(SPNeo4jConstants.PARAMS_PAGE_NAME.SPAssetEntry, spAssetEntryDetailPageName);

					for (ActivityFeedGraphWrapper activityFeedGraphWrapper : activityFeedGraphWrappers) {
						try {
							JSONObject item = JSONFactoryUtil.createJSONObject();
							String html = getActivityItemHtml(resourceRequest, resourceResponse, themeDisplay,
									activityFeedGraphWrapper, pageNames);
							item.put("html", html);
							items.put(item);
						} catch (Exception e) {
							_log.error(e.getMessage(), e);
						}
					}
				}

				data.put("items", items);
				data.put("count", count);

				resourceResponse.setContentType("application/json");
				resourceResponse.setCharacterEncoding("utf-8");
				resourceResponse.getWriter().write(data.toString());

			} else if ("retrieveComments".equalsIgnoreCase(action)) {
				resourceResponse.setContentType("application/json");
				resourceResponse.setCharacterEncoding("utf-8");
				resourceResponse.getWriter()
						.write(retrieveCommentsJsonString(resourceRequest, resourceResponse, themeDisplay));
			} else if ("retrieveReplies".equalsIgnoreCase(action)) {
				resourceResponse.setContentType("application/json");
				resourceResponse.setCharacterEncoding("utf-8");
				resourceResponse.getWriter().write(retrieveRepliesJsonString(resourceRequest, themeDisplay));
			} else if ("addComment".equalsIgnoreCase(action)) {
				resourceResponse.setContentType("application/json");
				resourceResponse.setCharacterEncoding("utf-8");
				resourceResponse.getWriter()
						.write(addCommentJsonString(resourceRequest, resourceResponse, themeDisplay));
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

	private String retrieveRealtimeActivityFeedsJsonString(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse, ThemeDisplay themeDisplay, PortletPreferences preferences,
			JSONArray activitiesJSONArray)
			throws SystemException, PortalException, ParserException, WindowStateException, PortletModeException {
		JSONObject data = JSONFactoryUtil.createJSONObject();
		JSONArray items = JSONFactoryUtil.createJSONArray();
		for (int i = 0; i < activitiesJSONArray.length(); i++) {
			JSONObject activityJSONObject = activitiesJSONArray.getJSONObject(i);
			/*
			 * {"className":"com.liferay.portlet.blogs.model.BlogsEntry",
			 * "classPK":1,"type":1}
			 */
			String className = activityJSONObject.getString("className");
			long classPK = activityJSONObject.getLong("classPK");
			int type = activityJSONObject.getInt("type");

			String blogPageName = preferences.getValue("blogPageName", "spblogs");
			String groupDetailPageName = preferences.getValue("groupDetailPageName", "group-detail");
			String groupDiscussionDetailPageName = preferences.getValue("groupDiscussionDetailPageName",
					"discussion-detail");
			String eventDetailPageName = preferences.getValue("eventDetailPageName", "event-details");
			String spAssetEntryDetailPageName = preferences.getValue("spAssetEntryDetailPageName", "spassetentry");

			Map<String, String> pageNames = new HashMap<String, String>();
			pageNames.put(SPNeo4jConstants.PARAMS_PAGE_NAME.BLOG, blogPageName);
			pageNames.put(SPNeo4jConstants.PARAMS_PAGE_NAME.SPGroup, groupDetailPageName);
			pageNames.put(SPNeo4jConstants.PARAMS_PAGE_NAME.SPGroup_Discussion, groupDiscussionDetailPageName);
			pageNames.put(SPNeo4jConstants.PARAMS_PAGE_NAME.Event, eventDetailPageName);
			pageNames.put(SPNeo4jConstants.PARAMS_PAGE_NAME.SPAssetEntry, spAssetEntryDetailPageName);

			String title = StringPool.BLANK;
			String urlTitle = StringPool.BLANK;
			String content = StringPool.BLANK;
			long userId = 0;
			String imageUrl = StringPool.BLANK;
			Date createDate = null;

			int spGroupType = 0;

			long endAssetEntityReferenceId = 0;
			String endAssetEntityReferenceUrlTitle = StringPool.BLANK;
			String endAssetEntityReferenceTitle = StringPool.BLANK;

			if (className != null) {
				if (BlogsEntry.class.getName().equalsIgnoreCase(className)) {
					try {
						BlogsEntry blogsEntry = BlogsEntryLocalServiceUtil.getBlogsEntry(classPK);
						title = blogsEntry.getTitle();
						urlTitle = blogsEntry.getUrlTitle();
						content = blogsEntry.getContent();
						userId = blogsEntry.getUserId();
						imageUrl = Util.getImageUrlFromHtml(content);
						content = SPHtmlUtil.shortenHtmlText(content, 115);
						createDate = blogsEntry.getCreateDate();
					} catch (NoSuchEntryException nsee) {
						// do nothing
					}
				} else if (SPGroup.class.getName().equalsIgnoreCase(className)) {
					try {
						SPGroup spGroup = SPGroupLocalServiceUtil.getSPGroup(classPK);
						title = spGroup.getTitle();
						urlTitle = spGroup.getUrlTitle();
						content = spGroup.getDescription();
						userId = spGroup.getUserId();
						imageUrl = Util.getImageUrlFromHtml(content);
						content = SPHtmlUtil.shortenHtmlText(content, 115);
						createDate = spGroup.getCreateDate();
						spGroupType = spGroup.getType();
					} catch (NoSuchSPGroupException nsspge) {
						// do nothing
					}
				} else if (MBMessage.class.getName().equalsIgnoreCase(className)) {
					try {
						MBMessage discussion = MBMessageLocalServiceUtil.getMBMessage(classPK);
						endAssetEntityReferenceId = discussion.getClassPK();
						try {
							SPGroup spGroup = SPGroupLocalServiceUtil.getSPGroup(endAssetEntityReferenceId);
							endAssetEntityReferenceTitle = spGroup.getTitle();
							endAssetEntityReferenceUrlTitle = spGroup.getUrlTitle();
						} catch (NoSuchSPGroupException nsspge) {
							// do nothing
						}
						title = discussion.getSubject();
						content = discussion.getBody();
						userId = discussion.getUserId();
						content = SPHtmlUtil.shortenHtmlText(content, 115);
						createDate = discussion.getCreateDate();

					} catch (NoSuchSPGroupException nsspge) {
						// do nothing
					}
				}
			}

			// simulate activityFeedGraphWrapper object
			ActivityFeedGraphWrapper activityFeedGraphWrapper = new ActivityFeedGraphWrapper();
			try {
				User user = UserLocalServiceUtil.getUser(userId);
				activityFeedGraphWrapper
						.setCommunityName(SambaashUtil.getCommunityName(themeDisplay.getScopeGroupId()));
				activityFeedGraphWrapper.setStartUserId(userId);
				activityFeedGraphWrapper.setStartUserFirstName(user.getFirstName());
				activityFeedGraphWrapper.setStartUserLastName(user.getLastName());
				activityFeedGraphWrapper.setStartUserScreenName(user.getScreenName());
				activityFeedGraphWrapper.setStartUserPortraitId(user.getPortraitId());

				activityFeedGraphWrapper.setEndClassName(className);
				activityFeedGraphWrapper.setEndClassPK(classPK);

				activityFeedGraphWrapper.setEndAssetEntityTitle(title);
				activityFeedGraphWrapper.setEndAssetEntityContent(content);
				activityFeedGraphWrapper.setEndAssetEntityUrlTitle(urlTitle);
				activityFeedGraphWrapper.setEndAssetEntityImageUrl(imageUrl);

				activityFeedGraphWrapper.setCreateDate(createDate);

				activityFeedGraphWrapper.setType(type);

				activityFeedGraphWrapper.setEndAssetEntityReferenceId(endAssetEntityReferenceId);
				activityFeedGraphWrapper.setEndAssetEntityReferenceTitle(endAssetEntityReferenceTitle);
				activityFeedGraphWrapper.setEndAssetEntityReferenceUrlTitle(endAssetEntityReferenceUrlTitle);

				activityFeedGraphWrapper.setEndAssetEntityType(spGroupType);

				JSONObject item = JSONFactoryUtil.createJSONObject();

				String html = getActivityItemHtml(resourceRequest, resourceResponse, themeDisplay,
						activityFeedGraphWrapper, pageNames);

				item.put("html", html);
				items.put(item);
			} catch (NoSuchUserException nsue) {
				// do nothing
			}
		}

		data.put("items", items);
		return data.toString();
	}

	@SuppressWarnings("unchecked")
	private String deleteCommentJsonString(ResourceRequest resourceRequest) throws SystemException, PortalException {
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

	private String addCommentJsonString(ResourceRequest resourceRequest, ResourceResponse resourceResponse,
			ThemeDisplay themeDisplay) throws PortalException, SystemException {
		String classPKStr = resourceRequest.getParameter("class_pk");
		String className = resourceRequest.getParameter("class_name");
		String content = resourceRequest.getParameter("content");
		if (Validator.isNull(content))
			content = content.replaceAll("[\r\n]", "<br>");
		long scopeGroupId = themeDisplay.getScopeGroupId();

		long classPK = 0;
		try {
			classPK = Long.valueOf(classPKStr);
		} catch (NumberFormatException nfe) {
		}

		long currentUserId = themeDisplay.getUserId();
		String currentUserScreenName = themeDisplay.getUser().getScreenName();
		long portraitId = themeDisplay.getUser().getPortraitId();

		String threadView = PropsUtil.get(PropsKeys.DISCUSSION_THREAD_VIEW);

		MBMessageDisplay messageDisplay = MBMessageLocalServiceUtil.getDiscussionMessageDisplay(currentUserId,
				scopeGroupId, className, classPK, WorkflowConstants.STATUS_ANY, threadView);

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

		long parentId = rootMessage.getMessageId();
		long threadId = thread.getThreadId();
		if (className.endsWith("MBMessage")) {
			// check if SPGroup Discussion
			MBMessage probableGrpDiscussion = MBMessageLocalServiceUtil.fetchMBMessage(classPK);
			if (probableGrpDiscussion!=null && probableGrpDiscussion.getClassNameId()==ClassConstant.SPGROUP_CLASSNAME_ID) {
				SPGroup spGroup = SPGroupLocalServiceUtil.fetchSPGroup(probableGrpDiscussion.getClassPK());
				if (spGroup !=null) {
					parentId = classPK;
					className = SPGroup.class.getName();
					classPK = spGroup.getSpGroupId();
					threadId = probableGrpDiscussion.getThreadId();
				}
			}
		}
		
		MBMessage mbmsg = MBMessageLocalServiceUtil.addDiscussionMessage(currentUserId, currentUserScreenName,
				scopeGroupId, className, classPK, threadId, parentId, subject, body,
				serviceContext);

		mbmsg.setBody(content);
		MBMessageLocalServiceUtil.updateMBMessage(mbmsg);

		CommentWrapper parentCommentWrapper = new CommentWrapper(mbmsg);
		parentCommentWrapper.setFirstName(themeDisplay.getUser().getFirstName());
		parentCommentWrapper.setLastName(themeDisplay.getUser().getLastName());
		parentCommentWrapper.setScreenName(currentUserScreenName);
		parentCommentWrapper.setPortraitId(portraitId);

		int cStart = 0;
		int cOffset = 3;
		long childCount = 0;
		parentCommentWrapper.setChildCount(childCount);
		
		boolean canComment = rootMessage.getClassNameId() == ClassConstant.SPGROUP_CLASSNAME_ID
				? isMemberOfDiscussionGroup(themeDisplay.getUserId(), rootMessage.getClassPK()) : true;	
				
		JSONObject dataJSONObject = JSONFactoryUtil.createJSONObject();
		String html = getParentCommentHtml(resourceResponse, classPK, className, parentCommentWrapper, themeDisplay,
				cStart, cOffset, canComment);
		dataJSONObject.put("html", html);
		dataJSONObject.put("class_pk", classPK);

		return dataJSONObject.toString();
	}

	private String addReplyJsonString(ResourceRequest resourceRequest, ThemeDisplay themeDisplay)
			throws PortalException, SystemException {
		String classPKStr = resourceRequest.getParameter("class_pk");
		String className = resourceRequest.getParameter("class_name");
		String parentIdStr = resourceRequest.getParameter("parent_id");		
		String content = resourceRequest.getParameter("content");
		long scopeGroupId = themeDisplay.getScopeGroupId();
		
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
		
		long currentUserId = themeDisplay.getUserId();
		String currentUserScreenName = themeDisplay.getUser().getScreenName();
		long portraitId = themeDisplay.getUser().getPortraitId();

		String threadView = PropsUtil.get(PropsKeys.DISCUSSION_THREAD_VIEW);

		MBMessageDisplay messageDisplay = MBMessageLocalServiceUtil.getDiscussionMessageDisplay(currentUserId,
				scopeGroupId, className, classPK, WorkflowConstants.STATUS_ANY, threadView);

		MBThread thread = messageDisplay.getThread();

		String subject = StringPool.BLANK;
		String body = content;
		ServiceContext serviceContext = ServiceContextFactory.getInstance(MBMessage.class.getName(), resourceRequest);

		long threadId = thread.getThreadId();
		if (className.endsWith("MBMessage")) {
			// check if SPGroup Discussion
			MBMessage probableGrpDiscussion = MBMessageLocalServiceUtil.fetchMBMessage(classPK);
			if (probableGrpDiscussion!=null && probableGrpDiscussion.getClassNameId()==ClassConstant.SPGROUP_CLASSNAME_ID) {
				SPGroup spGroup = SPGroupLocalServiceUtil.fetchSPGroup(probableGrpDiscussion.getClassPK());
				if (spGroup !=null) {
					parentId = classPK;
					className = SPGroup.class.getName();
					classPK = spGroup.getSpGroupId();
					threadId = probableGrpDiscussion.getThreadId();
				}
			}
		}
		
		MBMessage mbmsg = MBMessageLocalServiceUtil.addDiscussionMessage(currentUserId, currentUserScreenName,
				scopeGroupId, className, classPK, threadId, parentId, subject, body,
				serviceContext);

		mbmsg.setBody(content);
		MBMessageLocalServiceUtil.updateMBMessage(mbmsg);

		CommentWrapper childCommentWrapper = new CommentWrapper(mbmsg);
		childCommentWrapper.setFirstName(themeDisplay.getUser().getFirstName());
		childCommentWrapper.setLastName(themeDisplay.getUser().getLastName());
		childCommentWrapper.setScreenName(currentUserScreenName);
		childCommentWrapper.setPortraitId(portraitId);

		boolean canComment = className.endsWith("SPGroup")
				? isMemberOfDiscussionGroup(themeDisplay.getUserId(), classPK) : true;	
				
		JSONObject dataJSONObject = JSONFactoryUtil.createJSONObject();
		String html = getChildCommentHtml(childCommentWrapper, themeDisplay, canComment);
		dataJSONObject.put("html", html);
		dataJSONObject.put("class_pk", classPK);
		dataJSONObject.put("parent_id", parentId);

		return dataJSONObject.toString();
	}

	private String retrieveCommentsJsonString(ResourceRequest resourceRequest, ResourceResponse resourceResponse,
			ThemeDisplay themeDisplay) throws SystemException, PortalException {
		JSONObject dataJSONObject = JSONFactoryUtil.createJSONObject();
		JSONArray itemsJSONArray = JSONFactoryUtil.createJSONArray();
		CommentJsonListWrapper commentJsonListWrapper = retrieveComments(resourceRequest, resourceResponse,
				themeDisplay);
		List<CommentJsonWrapper> commentJsonWrappers = commentJsonListWrapper.getItems();
		for (CommentJsonWrapper commentJsonWrapper : commentJsonWrappers) {
			String html = commentJsonWrapper.getHtml();
			JSONObject htmlJSONObject = JSONFactoryUtil.createJSONObject();
			htmlJSONObject.put("html", html);
			itemsJSONArray.put(htmlJSONObject);
		}
		dataJSONObject.put("items", itemsJSONArray);

		return dataJSONObject.toString();
	}

	private CommentJsonListWrapper retrieveComments(ResourceRequest resourceRequest, ResourceResponse resourceResponse,
			ThemeDisplay themeDisplay) throws SystemException, PortalException {
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

		long countL = SPNeoforjLocalServiceUtil.countDiscussions(themeDisplay.getCompanyId(), 
				themeDisplay.getScopeGroupId(), themeDisplay.getLayoutSet().getLayoutSetId(), ClassConstant.classNameId(className), classPK);

		// Catch this exception, we'll see ...
		int count = Util.safeLongToInt(countL);
		int balance = 0;
		balance = count - initTotal;
		start += balance;

		int cStart = 0;
		int cOffset = 3;

		return populateParentCommentJsonList(resourceResponse, themeDisplay, classPK, className, start, offset, cStart,
				cOffset);
	}

	private String retrieveRepliesJsonString(ResourceRequest resourceRequest, ThemeDisplay themeDisplay)
			throws SystemException, PortalException {
		JSONObject dataJSONObject = JSONFactoryUtil.createJSONObject();
		JSONArray itemsJSONArray = JSONFactoryUtil.createJSONArray();
		CommentJsonListWrapper commentJsonListWrapper = retrieveReplies(resourceRequest, themeDisplay);
		List<CommentJsonWrapper> commentJsonWrappers = commentJsonListWrapper.getItems();
		for (CommentJsonWrapper commentJsonWrapper : commentJsonWrappers) {
			String html = commentJsonWrapper.getHtml();
			JSONObject htmlJSONObject = JSONFactoryUtil.createJSONObject();
			htmlJSONObject.put("html", html);
			itemsJSONArray.put(htmlJSONObject);
		}
		dataJSONObject.put("items", itemsJSONArray);

		return dataJSONObject.toString();
	}

	private CommentJsonListWrapper retrieveReplies(ResourceRequest resourceRequest, ThemeDisplay themeDisplay)
			throws SystemException, PortalException {
		String parentIdStr = resourceRequest.getParameter("parent_id");
		String parentClassIdStr = resourceRequest.getParameter("parent_class_id");
		String initTotalStr = resourceRequest.getParameter("init_total");
		String curShowingNoStr = resourceRequest.getParameter("cur_showing_no");
		String offsetStr = resourceRequest.getParameter("offset");

		long parentId = 0, parentClassId = 0;
		int curShowingNo = 0;
		int initTotal = 0;
		int offset = 0;

		try {
			parentId = Long.valueOf(parentIdStr);
			parentClassId = Long.valueOf(parentClassIdStr);
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
		boolean isDiscussionGroup = isDiscussionGroup(parentClassId);
		long childCount = isDiscussionGroup ?
				SPNeoforjLocalServiceUtil.countDiscussionComments(themeDisplay.getCompanyId(), 
				themeDisplay.getScopeGroupId(), themeDisplay.getLayoutSet().getLayoutSetId(), parentId)
				: 
				SPNeoforjLocalServiceUtil.countDocumentComments(themeDisplay.getCompanyId(), 
				themeDisplay.getScopeGroupId(), themeDisplay.getLayoutSet().getLayoutSetId(), parentClassId, parentId);
		
		int balance = 0;
		balance = (int) childCount - initTotal;
		start += balance;

		return populateChildJsonList(themeDisplay, parentClassId, parentId, start, offset);
	}

	@SuppressWarnings("unchecked")
	// rootMessageId was re-used for "added discussion" as the discussionId
	private List<CommentWrapper> getParentCommentWrappers(
			ThemeDisplay themeDisplay, long classPK, long classNameId, long rootMessageId,
			int pStart, int pOffset, int cStart, int cOffset, boolean discussionOnly) throws SystemException, PortalException {
		List<CommentWrapper> parentCommentWrappers = new ArrayList<CommentWrapper>();
		
		boolean isDiscussionGroup = isDiscussionGroup(classNameId);
		List<AssetEntityGraphWrapper> discussions; 
		if (isDiscussionGroup) {
			discussions = SPNeoforjLocalServiceUtil.findDiscussions(themeDisplay.getCompanyId(), 
					themeDisplay.getScopeGroupId(), themeDisplay.getLayoutSet().getLayoutSetId(), classNameId, classPK, 
					discussionOnly ? 0 : pStart, discussionOnly ? 10000000 : pStart + pOffset);
		} else {
			discussions = new ArrayList<AssetEntityGraphWrapper>();
			discussions.add(
					SPNeoforjLocalServiceUtil
					.findAssetEntityGraph(themeDisplay.getCompanyId(), 
							themeDisplay.getScopeGroupId(), themeDisplay.getLayoutSet().getLayoutSetId(),
							ClassNameLocalServiceUtil.getClassName(classNameId).getClassName(), classPK)
			);
		}
		
		List<AssetEntityGraphWrapper> filteredDiscussions;
		if (discussionOnly) {
			filteredDiscussions = new ArrayList<AssetEntityGraphWrapper>(discussions);
			Iterator<AssetEntityGraphWrapper> it = filteredDiscussions.iterator();
			while (it.hasNext()) {
				AssetEntityGraphWrapper d = it.next();
				if (d.getClassPK() != rootMessageId) {
					it.remove(); // if not the current discussion, then remove from parent discussion list
				}
			}
		} else {
			filteredDiscussions = discussions;
		}
		
		for (AssetEntityGraphWrapper discussion : filteredDiscussions) {
			long discussionId = discussion.getClassPK();
			long userId = discussion.getUserId();
			User actor = UserLocalServiceUtil.getUserById(userId);
			CommentWrapper parentCommentWrapper = new CommentWrapper(discussion);
			parentCommentWrapper.setFirstName(actor.getFirstName());
			parentCommentWrapper.setLastName(actor.getLastName());
			parentCommentWrapper.setScreenName(actor.getScreenName());
			parentCommentWrapper.setPortraitId(actor.getPortraitId());
			
			List<CommentWrapper> childCommentWrappers;
			long childCount;
			if (isDiscussionGroup) {
				childCommentWrappers = getChildCommentWrappers(themeDisplay, discussionId, cStart, cOffset);
				childCount = SPNeoforjLocalServiceUtil.countDiscussionComments(themeDisplay.getCompanyId(), 
						themeDisplay.getScopeGroupId(), themeDisplay.getLayoutSet().getLayoutSetId(), discussionId);
			} else {
				childCommentWrappers = new ArrayList<CommentWrapper>();
				List<AssetEntityGraphWrapper> childComments = SPNeoforjLocalServiceUtil
						.findDocumentComments(themeDisplay.getCompanyId(), 
								themeDisplay.getScopeGroupId(), themeDisplay.getLayoutSet().getLayoutSetId(),
								classNameId, classPK, cStart, cStart + cOffset);
				for (AssetEntityGraphWrapper childComment : childComments) {
					CommentWrapper childCommentWrapper = assetEntityWrapperToCommentWrapper(childComment);
					childCommentWrappers.add(childCommentWrapper);
				}
				childCount = SPNeoforjLocalServiceUtil.countDocumentComments(themeDisplay.getCompanyId(), 
						themeDisplay.getScopeGroupId(), themeDisplay.getLayoutSet().getLayoutSetId(), classNameId, classPK);
			}
			 
			parentCommentWrapper.setChildCommentWrappers(childCommentWrappers);
			parentCommentWrapper.setChildCount(childCount);			
			parentCommentWrappers.add(parentCommentWrapper);
		}
		
		return parentCommentWrappers;
	}

	private CommentWrapper assetEntityWrapperToCommentWrapper(
			AssetEntityGraphWrapper childComment) throws PortalException,
			SystemException {
		long userId = childComment.getUserId();
		User actor = UserLocalServiceUtil.getUserById(userId);
		CommentWrapper childCommentWrapper = new CommentWrapper(childComment);
		childCommentWrapper.setFirstName(actor.getFirstName());
		childCommentWrapper.setLastName(actor.getLastName());
		childCommentWrapper.setScreenName(actor.getScreenName());
		childCommentWrapper.setPortraitId(actor.getPortraitId());
		return childCommentWrapper;
	}
		
	@SuppressWarnings("unchecked")
	private List<CommentWrapper> getChildCommentWrappers(ThemeDisplay themeDisplay, long parentId, int cStart, int cOffset)
			throws PortalException, SystemException {
		
		List<CommentWrapper> childCommentWrappers = new ArrayList<CommentWrapper>();

		List<AssetEntityGraphWrapper> childComments = SPNeoforjLocalServiceUtil.findDiscussionComments(themeDisplay.getCompanyId(), 
				themeDisplay.getScopeGroupId(), themeDisplay.getLayoutSet().getLayoutSetId(), parentId, cStart, cStart + cOffset);

		for (AssetEntityGraphWrapper childComment : childComments) {
			CommentWrapper childCommentWrapper = assetEntityWrapperToCommentWrapper(childComment);
			childCommentWrappers.add(childCommentWrapper);
		}
		return childCommentWrappers;
	}

	private CommentJsonListWrapper populateParentCommentJsonList(ResourceResponse resourceResponse,
			ThemeDisplay themeDisplay, long classPK, String className, int pStart, int pOffset, int cStart, int cOffset)
			throws SystemException, PortalException {
		List<CommentJsonWrapper> commentJsonWrappers = new ArrayList<CommentJsonWrapper>();
		long classNameId = ClassNameLocalServiceUtil.getClassNameId(className);

		String threadView = PropsUtil.get(PropsKeys.DISCUSSION_THREAD_VIEW);

		MBMessageDisplay messageDisplay = MBMessageLocalServiceUtil.getDiscussionMessageDisplay(
				themeDisplay.getUserId(), themeDisplay.getScopeGroupId(), className, classPK,
				WorkflowConstants.STATUS_ANY, threadView);

		MBThread thread = messageDisplay.getThread();
		MBTreeWalker treeWalker = messageDisplay.getTreeWalker();
		MBMessage rootMessage = null;

		if (treeWalker != null) {
			rootMessage = treeWalker.getRoot();
		} else {
			rootMessage = MBMessageLocalServiceUtil.getMessage(thread.getRootMessageId());
		}

		List<CommentWrapper> parentCommentWrappers = getParentCommentWrappers(themeDisplay, classPK, classNameId,
				rootMessage.getMessageId(), pStart, pOffset, cStart, cOffset, false);
		
		boolean canComment = rootMessage.getClassNameId() == ClassConstant.SPGROUP_CLASSNAME_ID
				? isMemberOfDiscussionGroup(themeDisplay.getUserId(), rootMessage.getClassPK()) : true;

		for (CommentWrapper parentCommentWrapper : parentCommentWrappers) {
			String html = getParentCommentHtml(resourceResponse, classPK, className, parentCommentWrapper, themeDisplay,
					cStart, cOffset, canComment);
			CommentJsonWrapper commentJsonWrapper = new CommentJsonWrapper(html);
			commentJsonWrappers.add(commentJsonWrapper);
		}
		CommentJsonListWrapper commentJsonListWrapper = new CommentJsonListWrapper(commentJsonWrappers);
		return commentJsonListWrapper;
	}

	private CommentJsonListWrapper populateChildJsonList(ThemeDisplay themeDisplay, long parentClassId, long parentId, int cStart,
			int cOffset) throws PortalException, SystemException {
		List<CommentJsonWrapper> commentJsonWrappers = new ArrayList<CommentJsonWrapper>();
		List<CommentWrapper> childCommentWrappers = getChildCommentWrappers(themeDisplay, parentId, cStart, cOffset);
		
		boolean isDiscussionGroup = isDiscussionGroup(parentClassId);
		if (isDiscussionGroup) {
			childCommentWrappers = getChildCommentWrappers(themeDisplay, parentId, cStart, cOffset);
		} else {
			childCommentWrappers = new ArrayList<CommentWrapper>();
			List<AssetEntityGraphWrapper> childComments = SPNeoforjLocalServiceUtil
					.findDocumentComments(themeDisplay.getCompanyId(), 
							themeDisplay.getScopeGroupId(), themeDisplay.getLayoutSet().getLayoutSetId(),
							parentClassId, parentId, cStart, cStart + cOffset);
			for (AssetEntityGraphWrapper childComment : childComments) {
				CommentWrapper childCommentWrapper = assetEntityWrapperToCommentWrapper(childComment);
				childCommentWrappers.add(childCommentWrapper);
			}
		}

		for (CommentWrapper childCommentWrapper : childCommentWrappers) {
			String html = getChildCommentHtml(childCommentWrapper, themeDisplay, true);
			CommentJsonWrapper commentJsonWrapper = new CommentJsonWrapper(html);
			commentJsonWrappers.add(commentJsonWrapper);
		}
		CommentJsonListWrapper commentJsonListWrapper = new CommentJsonListWrapper(commentJsonWrappers);
		return commentJsonListWrapper;
	}

	private boolean isDiscussionGroup(long parentClassId) {
		return parentClassId == ClassConstant.SPGROUP_CLASSNAME_ID || parentClassId == ClassConstant.MBMESSAGE_CLASSNAME_ID;
	}

	private String getParentCommentHtml(ResourceResponse resourceResponse, long classPK, String className,
			CommentWrapper parentCommentWrapper, ThemeDisplay themeDisplay, int cStart, int cOffset, boolean canComment)
			throws PortalException, SystemException {
		long parentCommentId = parentCommentWrapper.getCommentId();
		String content = parentCommentWrapper.getContent();
		String displayDate = parentCommentWrapper.getDisplayDate();
		long actorId = parentCommentWrapper.getUserId();
		String screenName = parentCommentWrapper.getScreenName();
		String userThumbnailURL = UserConstants.getPortraitURL(themeDisplay.getPathImage(), true,
				parentCommentWrapper.getPortraitId());
		if (Validator.isNull(userThumbnailURL))
			userThumbnailURL = "/image/user_male_portrait?img_id=" + parentCommentWrapper.getPortraitId();
		String profileURL = "/" + screenName;

		String html = "<li data-comment-is-parent=\"true\" data-comment-id=\"" + parentCommentId
				+ "\" class=\"sp-af-comment-entry level1\">" + "<div class=\"sp-af-comment-entry-inner\">"
				+ "<a href=\"" + profileURL + "\"><img alt=\""+ screenName +"\" class=\"avatar\" src=\"" + userThumbnailURL + "\"/></a>"
				+ "<div class=\"sp-af-comment-content-wrap\">" + "<div class=\"sp-af-comment-content\">"
				+ "<a class=\"sp-fwb\" href=\"" + profileURL + "\">" + parentCommentWrapper.getFirstName()
				+ StringPool.SPACE + parentCommentWrapper.getLastName() + "</a> " + SPHtmlUtil.changeNewLineToBR(content);

		long currentUserId = themeDisplay.getUserId();
		if (themeDisplay.isSignedIn() && canComment) {
			boolean isOwner = (actorId == currentUserId) ? true : false;
			html += "<div class=\"sp-mtxs\"><a data-comment-dom-id=\"add-reply-link\" href=\"#\">Reply</a>";
			if (isOwner) {
				html += "&nbsp;<a href=\"#\" data-comment-dom-id=\"delete-link\">Delete</a>";
			}
		}

		html += " - <span class=\"sp-fcl\">" + displayDate + "</span></div>";

		html += "</div>";

		html += "<div data-loadmore-dom-id=\"loadmore-container\" class=\"sp-af-comment-reply-container\">"
				+ "<ul data-comment-dom-id=\"child-entry-container\" data-loadmore-dom-id=\"items-container\" class=\"sp-child-entry-container\">";

		long childCount = parentCommentWrapper.getChildCount();
		List<CommentWrapper> childCommentWrappers = this.getChildCommentWrappers(themeDisplay, parentCommentId, cStart, cOffset);
		for (CommentWrapper childCommentWrapper : childCommentWrappers) {
			html += getChildCommentHtml(childCommentWrapper, themeDisplay, canComment);
		}

		html += "</ul>";
		html += "<div ";
		if (childCount <= childCommentWrappers.size()) {
			html += "style=\"display: none;\"";
		}

		ResourceURL retrieveRepliesResourceURL = resourceResponse.createResourceURL();
		retrieveRepliesResourceURL.setParameter("action", "retrieveReplies");

		html += "data-loadmore-dom-id=\"view-more-link-container\" class=\"sp-af-comment-children-more\"><a data-loadmore-dom-id=\"view-more-link\" data-loadmore=\"{ &quot;retrieve_url&quot; : &quot;"
				+ retrieveRepliesResourceURL.toString()
				+ "&quot;, &quot;retrieve_params&quot; : {&quot;parent_id&quot; : &quot;" + parentCommentId
				+ "&quot;, &quot;parent_class_id&quot; : &quot;"
				+ parentCommentWrapper.getCommentClassId()				
				+ "&quot;, &quot;offset&quot; : " + cOffset + ", &quot;cur_showing_no&quot; : "
				+ childCommentWrappers.size() + ", &quot;init_total&quot; : " + childCount
				+ "}, &quot;no_results_msg&quot; : &quot;&quot;, &quot;no_more_results_msg&quot; : &quot;&quot;, &quot;error_msg&quot; : &quot;This stream is unavailable at this time. Please try again soon.&quot; }\" href=\"#\">View <span data-loadmore-dom-id=\"unshown-status\">"
				+ (childCount - childCommentWrappers.size())
				+ "</span> more <span class=\"arrow arrow-down arrow-down-lightblue arrow-down-small\"></span></a></div>";
		html += "<div data-loadmore-dom-id=\"loading-status\" style=\"display: none;\" align=\"center\"><span>Loading...</span></div>";
		html += "<div data-loadmore-dom-id=\"load-msg\" style=\"display: none;\" align=\"center\"></div>";
		if (themeDisplay.isSignedIn()) {
			html += getReplyFormHtml(resourceResponse, themeDisplay, classPK, className);
		}
		html += "</div></div></div></li>";

		return html;
	}

	private String getChildCommentHtml(CommentWrapper commentWrapper, ThemeDisplay themeDisplay, boolean canComment) {
		long commentId = commentWrapper.getCommentId();
		String content = commentWrapper.getContent();
		String displayDate = commentWrapper.getDisplayDate();
		long actorId = commentWrapper.getUserId();
		String screenName = commentWrapper.getScreenName();
		String profileURL = "/" + screenName;

		String userThumbnailURL = UserConstants.getPortraitURL(themeDisplay.getPathImage(), true,
				commentWrapper.getPortraitId());
		if (Validator.isNull(userThumbnailURL))
			userThumbnailURL = "/image/user_male_portrait?img_id=" + commentWrapper.getPortraitId();

		String html = "<li data-comment-id=\"" + commentId
				+ "\" data-comment-is-parent=\"false\" class=\"sp-af-comment-entry level2\">"
				+ "<div class=\"sp-af-comment-entry-inner\">" + "<a href=\"" + profileURL + "\"><img alt=\""+ screenName +"\" src=\""
				+ userThumbnailURL + "\" class=\"avatar\"/></a>" + "<div class=\"sp-af-comment-content-wrap\">"
				+ "<div class=\"sp-af-comment-content\">" + "<a href=\"" + profileURL + "\" class=\"sp-fwb\">"
				+ commentWrapper.getFirstName() + StringPool.SPACE + commentWrapper.getLastName() + "</a> " + SPHtmlUtil.changeNewLineToBR(content);

		long currentUserId = themeDisplay.getUserId();
		if (themeDisplay.isSignedIn() && canComment) {
			html += "<div class=\"sp-mtxs\"><a data-comment-dom-id=\"add-reply-link\" href=\"#\">Reply</a>";
			boolean isOwner = (actorId == currentUserId) ? true : false;
			if (isOwner) {
				html += "&nbsp;<a href=\"#\" data-comment-dom-id=\"delete-link\">Delete</a>";
			}
		}

		html += " - <span class=\"sp-fcl\">" + displayDate + "</span></div>";

		html += "</div></div></div></li>";
		return html;
	}

	private String getReplyFormHtml(ResourceResponse resourceResponse, ThemeDisplay themeDisplay, long classPK,
			String className) {
		String currentUserThumbnailURL = "/image/user_male_portrait?img_id=" + themeDisplay.getUser().getPortraitId();
		try {
			currentUserThumbnailURL = themeDisplay.getUser().getPortraitURL(themeDisplay);
		} catch (Exception e) {
		}
		ResourceURL addReplyResourceURL = resourceResponse.createResourceURL();
		addReplyResourceURL.setParameter("action", "addReply");

		String html = "<div data-comment-dom-id=\"add-reply-form-container\" class=\"sp-af-comment-entry level2\" style=\"display: none;\">"
				+ "<div class=\"sp-af-comment-entry-inner\">" + "<img alt=\"User Image\" data-comment-dom-id=\"avatar\" src=\""
				+ currentUserThumbnailURL + "\" class=\"avatar\"/>"
				+ "<div style=\"margin: 0 0 8px 40px; min-height: 32px;\">"
				+ "<form data-comment-dom-id=\"add-reply-form\" action=\"" + addReplyResourceURL + "\" method=\"post\">"
				+ "<input type=\"hidden\" name=\"classPK\" value=\"" + classPK + "\"/>"
				+ "<input type=\"hidden\" name=\"className\" value=\"" + className + "\"/>"
				+ "<div class=\"sp-af-comment-textarea-outer\">"
				+ "<textarea data-comment-dom-id=\"add-reply-textarea\" style=\"height: 60px;\"></textarea>" + "</div>"
				+ "<div align=\"right\" class=\"sp-mts\">";

		html += "<input data-comment-dom-id=\"add-reply-form-sumbit-btn\" type=\"submit\" class=\"sp-af-comment-btn small\" value=\"Reply\" />";
		html += "</div></form>" + "</div></div></div>";
		return html;
	}

	private String getActivityItemHtml(ResourceRequest resourceRequest, ResourceResponse resourceResponse,
			ThemeDisplay themeDisplay, ActivityFeedGraphWrapper activityFeedGraphWrapper, Map<String, String> pageNames)
			throws PortalException, SystemException, WindowStateException, PortletModeException {
		String blogPageName = pageNames.get(SPNeo4jConstants.PARAMS_PAGE_NAME.BLOG);
		String groupDetailPageName = pageNames.get(SPNeo4jConstants.PARAMS_PAGE_NAME.SPGroup);
		String groupDiscussionDetailPageName = pageNames.get(SPNeo4jConstants.PARAMS_PAGE_NAME.SPGroup_Discussion);
		String eventDetailPageName = pageNames.get(SPNeo4jConstants.PARAMS_PAGE_NAME.Event);
		String spAssetEntryDetailPageName = pageNames.get(SPNeo4jConstants.PARAMS_PAGE_NAME.SPAssetEntry);
		String assetEntityDetailURL = StringPool.BLANK;
		String assetEntityName = StringPool.BLANK;
		String referenceString = StringPool.BLANK;
		if (BlogsEntry.class.getName().equalsIgnoreCase(activityFeedGraphWrapper.getEndClassName())) {
			assetEntityName = "blog";
			Layout spBlogDetailLayout = retrieveDetailPageLayout(themeDisplay, blogPageName);

			if (spBlogDetailLayout != null) {
				long spBlogDetailPlid = spBlogDetailLayout.getPlid();

				PortletURL spBlogDetailPortletURL = PortletURLFactoryUtil.create(resourceRequest,
						"SPBlogs_WAR_SPBlogsportlet", spBlogDetailPlid, PortletRequest.RENDER_PHASE);
				spBlogDetailPortletURL.setWindowState(javax.portlet.WindowState.NORMAL);
				spBlogDetailPortletURL.setPortletMode(javax.portlet.PortletMode.VIEW);
				spBlogDetailPortletURL.setParameter("struts_action", "/spblogs/view_entry");
				spBlogDetailPortletURL.setParameter("urlTitle", activityFeedGraphWrapper.getEndAssetEntityUrlTitle());
				spBlogDetailPortletURL.setParameter("entryId",
						String.valueOf(activityFeedGraphWrapper.getEndClassPK()));
				assetEntityDetailURL = spBlogDetailPortletURL.toString();
			}
		} else if (SPGroup.class.getName().equalsIgnoreCase(activityFeedGraphWrapper.getEndClassName())) {
			assetEntityName = "group";
			Layout spGroupDetailLayout = retrieveDetailPageLayout(themeDisplay, groupDetailPageName);

			if (spGroupDetailLayout != null) {
				long spGroupDetailPlid = spGroupDetailLayout.getPlid();

				PortletURL spGroupDetailPortletURL = PortletURLFactoryUtil.create(resourceRequest,
						"SPGroupDetail_WAR_SPGroupportlet", spGroupDetailPlid, PortletRequest.RENDER_PHASE);
				spGroupDetailPortletURL.setWindowState(javax.portlet.WindowState.NORMAL);
				spGroupDetailPortletURL.setPortletMode(javax.portlet.PortletMode.VIEW);
				spGroupDetailPortletURL.setParameter("struts_action", "/groups/view_entry");
				spGroupDetailPortletURL.setParameter("urlTitle", activityFeedGraphWrapper.getEndAssetEntityUrlTitle());
				spGroupDetailPortletURL.setParameter("spGroupId",
						String.valueOf(activityFeedGraphWrapper.getEndClassPK()));
				assetEntityDetailURL = spGroupDetailPortletURL.toString();
			}
		} else if (MBMessage.class.getName().equalsIgnoreCase(activityFeedGraphWrapper.getEndClassName())) {
			assetEntityName = "discussion";
			Layout spGroupDiscussionDetailLayout = retrieveDetailPageLayout(themeDisplay,
					groupDiscussionDetailPageName);

			if (spGroupDiscussionDetailLayout != null) {
				long viewSPGroupDiscussionPlid = spGroupDiscussionDetailLayout.getPlid();

				PortletURL spGroupDiscussionPortletURL = com.liferay.portlet.PortletURLFactoryUtil.create(
						resourceRequest, "SPGroupDiscussionDetail_WAR_SPGroupportlet", viewSPGroupDiscussionPlid,
						javax.portlet.PortletRequest.RENDER_PHASE);
				spGroupDiscussionPortletURL.setWindowState(javax.portlet.WindowState.NORMAL);
				spGroupDiscussionPortletURL.setPortletMode(javax.portlet.PortletMode.VIEW);
				spGroupDiscussionPortletURL.setParameter("struts_action", "/discussions/view_discussion");
				spGroupDiscussionPortletURL.setParameter("urlTitle",
						GetterUtil.getString(activityFeedGraphWrapper.getEndAssetEntityReferenceUrlTitle()));
				spGroupDiscussionPortletURL.setParameter("spGroupId",
						String.valueOf(activityFeedGraphWrapper.getEndAssetEntityReferenceId()));
				spGroupDiscussionPortletURL.setParameter("discussionId",
						String.valueOf(activityFeedGraphWrapper.getEndClassPK()));
				assetEntityDetailURL = spGroupDiscussionPortletURL.toString();
			}

			Layout spGroupDetailLayout = retrieveDetailPageLayout(themeDisplay, groupDetailPageName);

			String spGroupDetailURL = StringPool.BLANK;
			if (spGroupDetailLayout != null) {
				long spGroupDetailPlid = spGroupDetailLayout.getPlid();

				PortletURL spGroupDetailPortletURL = PortletURLFactoryUtil.create(resourceRequest,
						"SPGroupDetail_WAR_SPGroupportlet", spGroupDetailPlid, PortletRequest.RENDER_PHASE);
				spGroupDetailPortletURL.setWindowState(javax.portlet.WindowState.NORMAL);
				spGroupDetailPortletURL.setPortletMode(javax.portlet.PortletMode.VIEW);
				spGroupDetailPortletURL.setParameter("struts_action", "/groups/view_entry");
				spGroupDetailPortletURL.setParameter("urlTitle",
						activityFeedGraphWrapper.getEndAssetEntityReferenceUrlTitle());
				spGroupDetailPortletURL.setParameter("spGroupId",
						String.valueOf(activityFeedGraphWrapper.getEndAssetEntityReferenceId()));
				spGroupDetailURL = spGroupDetailPortletURL.toString();
			}
			String spGroupTitle = activityFeedGraphWrapper.getEndAssetEntityReferenceTitle();
			referenceString = " in group <a href=\"" + spGroupDetailURL + "\">" + spGroupTitle + "</a>";
		} else if (SPChallenge.class.getName().equalsIgnoreCase(activityFeedGraphWrapper.getEndClassName())) {
			assetEntityName = "challenge";
			long challengeId = GetterUtil.getLong(activityFeedGraphWrapper.getEndClassPK());
			if (challengeId != 0) {
				assetEntityDetailURL = SPChallengeLocalServiceUtil.displayChallengeFriendlyURL(themeDisplay,
						challengeId);
			}
		} else if (SPAssetEntry.class.getName().equalsIgnoreCase(activityFeedGraphWrapper.getEndClassName())) {
			assetEntityName = "album";
			Layout spAssetDetailLayout = retrieveDetailPageLayout(themeDisplay, spAssetEntryDetailPageName);

			if (spAssetDetailLayout != null) {
				long spAssetDetailPlid = spAssetDetailLayout.getPlid();

				PortletURL spAssetDetailPortletURL = PortletURLFactoryUtil.create(resourceRequest,
						"spassetdetailview_WAR_SPAssetportlet", spAssetDetailPlid, PortletRequest.RENDER_PHASE);
				spAssetDetailPortletURL.setWindowState(javax.portlet.WindowState.NORMAL);
				spAssetDetailPortletURL.setPortletMode(javax.portlet.PortletMode.VIEW);
				spAssetDetailPortletURL.setParameter("assetEntryId",
						String.valueOf(activityFeedGraphWrapper.getEndClassPK()));
				assetEntityDetailURL = spAssetDetailPortletURL.toString();
			}
		} else if (SPAssetType.class.getName().equalsIgnoreCase(activityFeedGraphWrapper.getEndClassName())) {
			assetEntityName = "asset type";
		} else if (CalendarBooking.class.getName().equalsIgnoreCase(activityFeedGraphWrapper.getEndClassName())) {
			assetEntityName = "event";
			assetEntityDetailURL = String.format("/%s?eventId=%d", eventDetailPageName,
					activityFeedGraphWrapper.getEndClassPK());
		}

		String actionText = StringPool.BLANK;
		if (activityFeedGraphWrapper.getType() == ActivityFeedType.ADD_ENTITY.getValue()) {
			actionText = " added ";
		} else if (activityFeedGraphWrapper.getType() == ActivityFeedType.ADD_COMMENT.getValue()) {
			actionText = " commented ";
		}

		boolean isSignedIn = themeDisplay.isSignedIn();
		boolean canShowGroupComments = activityFeedGraphWrapper.getEndClassName().endsWith("SPGroup") && ( 
				activityFeedGraphWrapper.getEndAssetEntityType() == 0 ||
				(activityFeedGraphWrapper.getEndAssetEntityType() > 0 && isMemberOfDiscussionGroup(themeDisplay.getUserId(), activityFeedGraphWrapper.getEndClassPK()))
			);
		boolean canShowDiscussionComments = activityFeedGraphWrapper.getEndClassName().endsWith("MBMessage") 
				&& (   (activityFeedGraphWrapper.getType()==1 && activityFeedGraphWrapper.getEndAssetEntityType() == 0)
					|| (activityFeedGraphWrapper.getType()==1 && activityFeedGraphWrapper.getEndAssetEntityType() > 0
				       && isMemberOfDiscussionGroup(themeDisplay.getUserId(), activityFeedGraphWrapper.getEndAssetEntityReferenceId()))
					|| (activityFeedGraphWrapper.getType()==3 && isMemberOfDiscussionGroup(themeDisplay.getUserId(), activityFeedGraphWrapper.getEndAssetEntityReferenceId()))
				);
		boolean isNotDiscussionFeed = !activityFeedGraphWrapper.getEndClassName().endsWith("SPGroup") && !activityFeedGraphWrapper.getEndClassName().endsWith("MBMessage");
		boolean canShowComments = isNotDiscussionFeed || canShowGroupComments || canShowDiscussionComments;

		long userId = themeDisplay.getUserId();

		// Like

		int usersWhoLikeCount = SPNeoforjLocalServiceUtil.findUsersWhoLikeCount(themeDisplay.getCompanyId(),
				themeDisplay.getScopeGroupId(), themeDisplay.getLayoutSet().getLayoutSetId(),
				activityFeedGraphWrapper.getEndClassName(), activityFeedGraphWrapper.getEndClassPK());

		boolean isLiking = false;

		String likeAction = "like";
		if (isSignedIn) {
			isLiking = SPNeoforjLocalServiceUtil.isLiking(themeDisplay.getCompanyId(), themeDisplay.getScopeGroupId(),
					themeDisplay.getLayoutSet().getLayoutSetId(), userId, activityFeedGraphWrapper.getEndClassName(),
					activityFeedGraphWrapper.getEndClassPK());
		}
		if (isLiking) {
			likeAction = "unlike";
		}

		String likeData = "{ &quot;companyId&quot; : &quot;" + themeDisplay.getCompanyId()
				+ "&quot;,&quot;groupId&quot; : &quot;" + themeDisplay.getScopeGroupId()
				+ "&quot;,&quot;layoutSetId&quot; : &quot;" + themeDisplay.getLayoutSet().getLayoutSetId()
				+ "&quot;,&quot;action&quot; : &quot;" + likeAction + "&quot;,&quot;startUserId&quot; : " + userId
				+ ", &quot;endEntityClassName&quot; : &quot;" + activityFeedGraphWrapper.getEndClassName()
				+ "&quot;, &quot;endEntityId&quot; : " + activityFeedGraphWrapper.getEndClassPK() + "}";
		String likeLinkClass = "splike-like";
		if (isLiking) {
			likeLinkClass = "splike-liking";
		}

		String html = StringPool.BLANK;

		User actor = UserLocalServiceUtil.getUserById(activityFeedGraphWrapper.getStartUserId());
		String userProfileImageUrl = UserConstants.getPortraitURL(themeDisplay.getPathImage(), true,
				actor.getPortraitId());

		if (Validator.isNull(userProfileImageUrl)) {
			userProfileImageUrl = "/image/user_male_portrait?img_id="
					+ activityFeedGraphWrapper.getStartUserPortraitId();
		}

		String profileUrl = StringPool.SLASH + activityFeedGraphWrapper.getStartUserScreenName();
		String screenName1 = activityFeedGraphWrapper.getStartUserScreenName();

		String entityImageHtml = (Validator.isNotNull(activityFeedGraphWrapper.getEndAssetEntityImageUrl())
				? "<div style=\"line-height: 0; margin-bottom: 10px;\"> " + "<img src=\""
						+ activityFeedGraphWrapper.getEndAssetEntityImageUrl()
						+ "\" style=\"max-width: 100%; max-height: 400px;\" /> " + "</div> "
				: StringPool.BLANK);
		if (!canShowComments) {
			assetEntityDetailURL = "javascript:;";
		}
		html = "<li>" + "<div class=\"activity-feed-content block\">"
				+"<div class=\"activity-feed-head block padding-bottom-half\">"
				+ "<figure class=\"activity-feed-avatar inline-block align-middle\">" + "<a class=\"block\" href=\""
				+ profileUrl + "\">" + "<img alt=\""+ screenName1 +"\" src=\"" + userProfileImageUrl + "\" /> " + "</a>" + "</figure> "
				+ "<div class=\"activity-feed-name align-middle\">" + "<a href=\"" + profileUrl + "\">"
				+ activityFeedGraphWrapper.getStartUserFirstName() + StringPool.SPACE
				+ activityFeedGraphWrapper.getStartUserLastName() + "</a>" + "<span>" + actionText + " a </span>"
				+ "<a href=\"" + assetEntityDetailURL + "\" target=\"_blank\" >" + assetEntityName + "</a>"
				+ referenceString + "</div>" + "</div>" + "<div class=\"activity-feed-body block\">" + entityImageHtml
				+ "<div class=\"activity-feed-title block padding-bottom-quarter\">" + "<a href=\""
				+ assetEntityDetailURL + "\" target=\"_blank\" class=\"block bold\">"
				+ SPHtmlUtil.changeNewLineToBR(activityFeedGraphWrapper.getEndAssetEntityTitle()) + "</a>" + "<div class=\"activity-feed-date pin-top-right padding-top-half bold font-10\">"
				+ lFormat.format(activityFeedGraphWrapper.getCreateDate()) + "</div>"
				+ "</div>";
		if ("event".equals(assetEntityName)) {
			String eventTitle = Validator.isNotNull(activityFeedGraphWrapper.getEndAssetEntityTitle())
					? activityFeedGraphWrapper.getEndAssetEntityTitle()
					// un-escape 2x because some are escaped 2x as well, e.g. "&amp;nbsp;"
					: StringEscapeUtils.unescapeHtml(StringEscapeUtils.unescapeHtml(activityFeedGraphWrapper.getEndAssetEntityContent()));
			html += "<div class=\"activity-feed-body-content block padding-bottom-half\">"
					+ SPHtmlUtil.changeNewLineToBR(SPHtmlUtil.shortenHtmlText(eventTitle, 400)) + "</div>";
		} else if (Validator.isNotNull(activityFeedGraphWrapper.getEndAssetEntityContent())) {
			html += "<div class=\"activity-feed-body-content block padding-bottom-half\">"
					+ (canShowComments ? SPHtmlUtil.changeNewLineToBR(activityFeedGraphWrapper.getEndAssetEntityContent()) : "") + "</div>";
		}
		html += "</div></div>";

		ResourceURL retrieveCommentsURL = resourceResponse.createResourceURL();
		retrieveCommentsURL.setParameter("action", "retrieveComments");

		ResourceURL retrieveRepliesURL = resourceResponse.createResourceURL();
		retrieveRepliesURL.setParameter("action", "retrieveReplies");

		ResourceURL addCommentURL = resourceResponse.createResourceURL();
		addCommentURL.setParameter("action", "addComment");

		ResourceURL addReplyURL = resourceResponse.createResourceURL();
		addReplyURL.setParameter("action", "addReply");

		long classNameId = ClassConstant.classNameId(activityFeedGraphWrapper.getEndClassName());

		int pStart = 0;
		int pOffset = 2;
		int cStart = 0;
		int cOffset = 1;
		List<CommentWrapper> parentCommentWrappers = new ArrayList<CommentWrapper>();
		long parentCount = 0, totalCommentsAndReplies = 0;
		
		long discussionPk = canShowDiscussionComments ? activityFeedGraphWrapper.getEndAssetEntityReferenceId() : activityFeedGraphWrapper.getEndClassPK();
		if (canShowComments) {
			long discussionClassnameId = canShowDiscussionComments 
					? ClassConstant.SPGROUP_CLASSNAME_ID : classNameId;

			parentCommentWrappers = this.getParentCommentWrappers(themeDisplay,
					discussionPk, discussionClassnameId, activityFeedGraphWrapper.getEndClassPK(), pStart, pOffset,
					cStart, cOffset, canShowDiscussionComments);

			if (canShowDiscussionComments) {
				if (activityFeedGraphWrapper.getType()==3) {
					parentCommentWrappers = new ArrayList<CommentWrapper>();
					parentCount = 0;
				} else {
					parentCount = 1;					
				}
			} else {
				parentCount = SPNeoforjLocalServiceUtil.countDiscussions(themeDisplay.getCompanyId(), 
						themeDisplay.getScopeGroupId(), themeDisplay.getLayoutSet().getLayoutSetId(), 
						discussionClassnameId, discussionPk);
				totalCommentsAndReplies += parentCount;
			}
			
			if (ClassConstant.SPGROUP_CLASSNAME_ID == discussionClassnameId && !canShowDiscussionComments) {
				totalCommentsAndReplies +=  SPNeoforjLocalServiceUtil.countGroupComments(themeDisplay.getCompanyId(), 
						themeDisplay.getScopeGroupId(), themeDisplay.getLayoutSet().getLayoutSetId(), 
						discussionPk);
			} else {
				for (CommentWrapper parentCommentWrapper : parentCommentWrappers) {
					totalCommentsAndReplies +=  parentCommentWrapper.getChildCount();
				}
			}
		}

		// comment

		html += "<div data-comment-asset-entity-id=\"" + discussionPk
				+ "\" data-comment-dom-id=\"comment-container\" class=\"sp-af-comment-section\">";

		// like and comment
		String likeNeoImgPath = "/SPNeo4j-portlet/images/like.svg";;
		String cmtNeoImgPath = "/SPNeo4j-portlet/images/comment.svg";
//		boolean canComment = activityFeedGraphWrapper.getEndClassName().endsWith("SPGroup")
//				? isMemberOfDiscussionGroup(themeDisplay.getUserId(), activityFeedGraphWrapper.getEndClassPK()) : true;	
		boolean canComment = canShowComments;	
		String commentLabel = activityFeedGraphWrapper.getEndClassName().endsWith("SPGroup")
				? "POST NEW DISCUSSION" : "COMMENT";	
		html += "<div class=\"sp-activity-like-comment font-none\"><div class=\"sp-activity-like-comment-cta inline-block font-10 text-left \"><a href=\"javascript:;\" data-like=\""
				+ likeData + "\" class=\"splike-link-like " + likeLinkClass + "\"><span class=\"text-like\">LIKE</span><span class=\"text-unlike\">UNLIKE</span></a>"
				+  (canComment ? "<a href=\"javascript:;\" data-comment-dom-id=\"comment-link\" class=\"comment-link\">"+commentLabel+"</a>" : "" )
				+ "</div><div class=\"sp-activity-like-comment-stat inline-block font-10 text-left\"><img alt=\"Like Image\" src=\"" + likeNeoImgPath + "\" /><b class=\"sp-lc\">"
				+ usersWhoLikeCount
				+ "</b><img alt=\"Comment Image\" src=\"" + cmtNeoImgPath + "\" /><span data-comment-dom-id=\"parent-count\" class=\"sp-fwb sp-fsn\">"
				+ totalCommentsAndReplies
				+ "</div></div>";

		/**
		 * html += "<div class=\"sp-pbs sp-ui-relative\">" + "<span
		 * data-comment-dom-id=\"parent-count\" class=\"sp-fwb sp-fsn\">" +
		 * parentCount + "</span>&nbsp;<span class=\"sp-fsn\">comment(s)</span>"
		 * + "</div>";
		 */
		if (themeDisplay.isSignedIn()) {
			String userImgUrl = themeDisplay.getUser().getPortraitURL(themeDisplay);

			html += "<div data-comment-dom-id=\"add-comment-form-container\" class=\"sp-af-comment-composer hide-content\">"
					+ "<div class=\"sp-af-comment-composer-inner\">" + "<img alt=\"User Image\" data-comment-dom-id=\"avatar\" src=\""
					+ userImgUrl + "\" style=\"display: none;\" class=\"avatar\"/>"
					+ "<div data-comment-dom-id=\"add-comment-textarea-container\">"
					+ "<form data-comment-dom-id=\"add-comment-form\" action=\"" + addCommentURL.toString()
					+ "\" method=\"post\">" + "<input type=\"hidden\" name=\"classPK\" value=\""
					+ activityFeedGraphWrapper.getEndClassPK() + "\" />"
					+ "<input type=\"hidden\" name=\"className\" value=\"" + activityFeedGraphWrapper.getEndClassName()
					+ "\"/>" + "<div class=\"sp-af-comment-textarea-outer\">"
					+ "<textarea data-comment-dom-id=\"add-comment-textarea\" >Add a comment...</textarea>" + "</div>"
					+ "<div data-comment-dom-id=\"add-comment-submit\" class=\"sp-mts\" style=\"display: none;\" align=\"right\">"
					+ "<input data-comment-dom-id=\"add-comment-form-sumbit-btn\" type=\"submit\" value=\"Comment\" class=\"sp-af-comment-btn small\"/>"
					+ "</div>" + "</form>" + "</div>" + "</div>" + "</div>";
		}

		boolean needToloadMore = (parentCommentWrappers.size() > 1) || canShowGroupComments || (parentCommentWrappers.size() == 1 && parentCommentWrappers.get(0).getChildCommentWrappers().size() > 0);
		html += "<div data-loadmore-dom-id=\"loadmore-container\""
				+ (needToloadMore ? "" : " style=\"display: none;\"")
				+ "><ul data-comment-dom-id=\"entry-container\" data-loadmore-dom-id=\"items-container\" class=\"sp-af-comment-entry-container\" >";

		boolean isDiscussionGroup = isDiscussionGroup(classNameId);
		
		for (CommentWrapper parentCommentWrapper : parentCommentWrappers) {
			String parentUserImgUrl = UserConstants.getPortraitURL(themeDisplay.getPathImage(), true,
					parentCommentWrapper.getPortraitId());
			if (Validator.isNull(parentUserImgUrl)) {
				parentUserImgUrl = "/image/user_male_portrait?img_id=" + parentCommentWrapper.getPortraitId();
			}
			if (canShowDiscussionComments || !isDiscussionGroup) {
				html += "<li data-comment-is-parent=\"true\" data-comment-id=\"" + parentCommentWrapper.getCommentId()
						+ "\" class=\"sp-af-comment-entry level1\">" + "<div >";
			} else {
				html += "<li data-comment-is-parent=\"true\" data-comment-id=\"" + parentCommentWrapper.getCommentId()
						+ "\" class=\"sp-af-comment-entry level1\">" + "<div class=\"sp-af-comment-entry-inner\">"
						+ "<a href=\"/" + themeDisplay.getUser().getScreenName() + "\">" + "<img alt=\"" + themeDisplay.getUser().getScreenName() +"\" src=\"" + parentUserImgUrl
						+ "\" class=\"avatar\"/>" + "</a>" + "<div class=\"sp-af-comment-content-wrap\">"
						+ "<div class=\"sp-af-comment-content\">" + "<a class=\"sp-fwb\" href=\"/"
						+ parentCommentWrapper.getScreenName() + "\">" + parentCommentWrapper.getFirstName()
						+ StringPool.SPACE + parentCommentWrapper.getLastName() + "</a> "
						+ SPHtmlUtil.changeNewLineToBR(HtmlUtil.stripHtml(SPHtmlUtil.changeBRtoNewLine(parentCommentWrapper.getParentContent())));				
				if (isSignedIn && canComment) {
					html += "<div class=\"sp-mtxs\">" + "<a data-comment-dom-id=\"add-reply-link\" href=\"#\">Reply</a>";
					if (themeDisplay.getUser().getUserId() == parentCommentWrapper.getUserId()) {
						html += "&nbsp;<a href=\"#\" data-comment-dom-id=\"delete-link\">Delete</a>";
					}
					html += " - <span class=\"sp-fcl\">" + parentCommentWrapper.getDisplayDate() + "</span>";
					html += "</div>";
				}
			}

			html += "</div>" +

					"<div data-loadmore-dom-id=\"loadmore-container\" class=\"sp-af-comment-reply-container\">"
					+ "<ul data-comment-dom-id=\"child-entry-container\" data-loadmore-dom-id=\"items-container\" class=\"sp-child-entry-container\">";

			for (CommentWrapper childCommentWrapper : parentCommentWrapper.getChildCommentWrappers()) {
				String childUserImgUrl = UserConstants.getPortraitURL(themeDisplay.getPathImage(), true,
						childCommentWrapper.getPortraitId());
				if (Validator.isNull(childUserImgUrl)) {
					childUserImgUrl = "/image/user_male_portrait?img_id=" + childCommentWrapper.getPortraitId();
				}
				html += "<li data-comment-id=\"" + childCommentWrapper.getCommentId()
						+ "\" data-comment-is-parent=\"false\" class=\"sp-af-comment-entry level2\">"
						+ "<div class=\"sp-af-comment-entry-inner\">" + "<a href=\"/"
						+ childCommentWrapper.getScreenName() + "\"><img alt=\""+ childCommentWrapper.getScreenName() + "\" src=\"" + childUserImgUrl
						+ "\" class=\"avatar\"/></a>" + "<div class=\"sp-af-comment-content-wrap\">"
						+ "<div class=\"sp-af-comment-content\">" + "<a href=\"/" + childCommentWrapper.getScreenName()
						+ "\" class=\"sp-fwb\">" + childCommentWrapper.getFirstName() + StringPool.SPACE
						+ childCommentWrapper.getLastName() + "</a> " + SPHtmlUtil.changeNewLineToBR(childCommentWrapper.getContent());

				if (isSignedIn && canComment) {
					html += "<div class=\"sp-mtxs\">"
							+ "<a data-comment-dom-id=\"add-reply-link\" href=\"#\">Reply</a>";
					if (themeDisplay.getUser().getUserId() == childCommentWrapper.getUserId()) {
						html += "&nbsp;<a href=\"#\" data-comment-dom-id=\"delete-link\">Delete</a>";
					}
					html += " - <span class=\"sp-fcl\">" + childCommentWrapper.getDisplayDate() + "</span>";
					html += "</div>";
				}

				html += "</div>" + "</div>" + "</div>" + "</li>";
			}
			html += "</ul>";

			String loadMoreStyleDisplay = StringPool.BLANK;
			if (parentCommentWrapper.getChildCount() <= parentCommentWrapper.getChildCommentWrappers().size()) {
				loadMoreStyleDisplay = "display: none;";
			}

			int unshownCount = Util.safeLongToInt(parentCommentWrapper.getChildCount())
					- parentCommentWrapper.getChildCommentWrappers().size();

			html += "<div data-loadmore-dom-id=\"view-more-link-container\" class=\"sp-af-comment-children-more\" style=\""
					+ loadMoreStyleDisplay
					+ "\"><a data-loadmore-dom-id=\"view-more-link\" data-loadmore=\"{ &quot;retrieve_url&quot; : &quot;"
					+ retrieveRepliesURL.toString()
					+ "&quot; ,&quot;retrieve_params&quot; : { &quot;parent_id&quot; : &quot;"
					+ parentCommentWrapper.getCommentId()
					+ "&quot;, &quot;parent_class_id&quot; : &quot;"
					+ parentCommentWrapper.getCommentClassId()
					+ "&quot;, &quot;offset&quot; : 5, &quot;cur_showing_no&quot; : "
					+ parentCommentWrapper.getChildCommentWrappers().size() + ", &quot;init_total&quot; : "
					+ parentCommentWrapper.getChildCount()
					+ " }, &quot;no_results_msg&quot; : &quot;&quot;, &quot;no_more_results_msg&quot; : &quot;&quot;, &quot;error_msg&quot; : &quot;This stream is unavailable at this time. Please try again soon.&quot; }\" href=\"#\">View <span data-loadmore-dom-id=\"unshown-status\">"
					+ unshownCount + "</span> more</a></div>"
					+ "<div data-loadmore-dom-id=\"loading-status\" style=\"display: none;\" align=\"center\"><span>Loading...</span></div>"
					+ "<div data-loadmore-dom-id=\"load-msg\" style=\"display: none;\" align=\"center\"></div>";
			if (isSignedIn) {
				html += "<div data-comment-dom-id=\"add-reply-form-container\" class=\"sp-af-comment-entry level2\" style=\"display: none;\">"
						+ "<div class=\"sp-af-comment-entry-inner\">" + "<img alt=\"User Image\" src=\""
						+ themeDisplay.getUser().getPortraitURL(themeDisplay) + "\" class=\"avatar\"/>"
						+ "<div style=\"margin: 0 0 8px 36px; min-height: 28px;\">"
						+ "<form data-comment-dom-id=\"add-reply-form\" action=\"" + addReplyURL.toString()
						+ "\" method=\"post\">" + "<input type=\"hidden\" name=\"classPK\" value=\""
						+ activityFeedGraphWrapper.getEndClassPK() + "\"/>"
						+ "<input type=\"hidden\" name=\"className\" value=\""
						+ activityFeedGraphWrapper.getEndClassName() + "\"/>"
						+ "<div class=\"sp-af-comment-textarea-outer\">"
						+ "<textarea data-comment-dom-id=\"add-reply-textarea\" style=\"height: 60px;\" tabindex=\"-1\"></textarea>"
						+ "</div>" + "<div align=\"right\" class=\"sp-mts\">"
						+ "<input data-comment-dom-id=\"add-reply-form-sumbit-btn\" type=\"submit\" class=\"sp-af-comment-btn small\" value=\"Reply\" />"
						+ "</div>" + "</form>" + "</div>" + "</div>" + "</div>";
			}
			html += "</div>" + "</div>" + "</div>" + "</li>";
		}
		html += "</ul>";

		String loadMoreStyleDisplay = StringPool.BLANK;
		if (parentCount <= parentCommentWrappers.size()) {
			loadMoreStyleDisplay = "display: none;";
		}

		int unshownCount = Util.safeLongToInt(parentCount) - parentCommentWrappers.size();

		html += "<div data-loadmore-dom-id=\"view-more-link-container\" class=\"sp-af-comment-more sp-mts\" style=\""
				+ loadMoreStyleDisplay
				+ "\" align=\"center\"><a data-loadmore-dom-id=\"view-more-link\" href=\"#\" data-loadmore=\"{ &quot;retrieve_url&quot; : &quot;"
				+ retrieveCommentsURL.toString()
				+ "&quot;, &quot;retrieve_params&quot; : { &quot;class_pk&quot; : &quot;"
				+ activityFeedGraphWrapper.getEndClassPK() + "&quot;, &quot;class_name&quot; : &quot;"
				+ activityFeedGraphWrapper.getEndClassName()
				+ "&quot;, &quot;offset&quot; : 5, &quot;cur_showing_no&quot; : " + parentCommentWrappers.size()
				+ ", &quot;init_total&quot; : " + parentCount
				+ " }, &quot;no_results_msg&quot; : &quot;NO RESULTS FOUND&quot;, &quot;no_more_results_msg&quot; : &quot;&quot;, &quot;error_msg&quot; : &quot;This stream is unavailable at this time. Please try again soon.&quot; }\">View more (<span data-loadmore-dom-id=\"unshown-status\">"
				+ unshownCount + "</span>)</a></div>"
				+ "<div data-loadmore-dom-id=\"loading-status\" class=\"sp-mts\" style=\"display: none;\" align=\"center\"><span>Loading...</span></div>"
				+ "<div data-loadmore-dom-id=\"load-msg\" class=\"sp-mts\"  style=\"display: none;\" align=\"center\"></div>"
				+ "</div>";

		html += "</div></div></li>";

		// end comment
		return html;
	}

	private boolean isMemberOfDiscussionGroup(long userId, long discussionGroupId) {
		try {
			for (SPGroupUser user: SPGroupUserLocalServiceUtil.findBySPGroupId(discussionGroupId)) {
				if (user.getUserId()==userId && user.getStatus()==0) {
					return true;
				}
			}
		} catch (SystemException e) {
			_log.debug("isMemberOfDiscussionGroup exception:" + e.getMessage());
		}
		return false;
	}

	protected Layout retrieveDetailPageLayout(ThemeDisplay themeDisplay, String pageDetailName)
			throws PortalException, SystemException {
		Layout spBlogDetailLayout = null;
		try {
			spBlogDetailLayout = LayoutLocalServiceUtil.getFriendlyURLLayout(themeDisplay.getScopeGroupId(), false,
					"/" + pageDetailName);
		} catch (com.liferay.portal.NoSuchLayoutException e) {
			// do nothing
		}
		return spBlogDetailLayout;
	}

	/*
	 * private String getCommunityName(long scopeGroupId) {
	 * if(Validator.isNull(communityName)) { communityName =
	 * SambaashUtil.getCommunityName(scopeGroupId); } return communityName; }
	 */

	private SimpleDateFormat lFormat = new SimpleDateFormat("MMM dd, yyyy 'at' hh:mm a");

	private Log _log = LogFactoryUtil.getLog(ActivityFeedAction.class);

}
