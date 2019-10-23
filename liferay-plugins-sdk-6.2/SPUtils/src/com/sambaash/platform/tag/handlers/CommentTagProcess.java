package com.sambaash.platform.tag.handlers;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
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
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.model.Layout;
import com.liferay.portal.model.User;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.security.permission.PermissionThreadLocal;
import com.liferay.portal.service.ClassNameLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.service.permission.PortletPermissionUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.messageboards.model.MBMessage;
import com.liferay.portlet.messageboards.model.MBMessageDisplay;
import com.liferay.portlet.messageboards.model.MBThread;
import com.liferay.portlet.messageboards.model.MBTreeWalker;
import com.liferay.portlet.messageboards.service.MBMessageLocalServiceUtil;
import com.sambaash.platform.util.DateUtils;

public class CommentTagProcess {
	private static final Log _log = LogFactoryUtil.getLog(CommentTagProcess.class);
	public final static List<String> COMMENT_ACTIONS = Arrays.asList("retrieveComments","addComment","updateComment","deleteComment","addReply","retrieveReplies");
	
	public static String SOURCE_COMMENTS_TAG ="commentsTag";
	public static String ACTION_VIEW_COMMENTS = "VIEW_COMMENTS";
	public static String ACTION_ADD_COMMENT = "ADD_COMMENT";
	public static String ACTION_UPDATE_COMMENT = "UPDATE_COMMENT";
	public static String ACTION_DELETE_COMMENT = "DELETE_COMMENT";

	public static String ACTION_VIEW_COMMENTS_PERMISSION = "VIEW_COMMENTS_Permission";
	public static String ACTION_ADD_COMMENT_PERMISSION = "ADD_COMMENT_Permission";
	public static String ACTION_UPDATE_COMMENT_PERMISSION = "UPDATE_COMMENT_Permission";
	public static String ACTION_DELETE_COMMENT_PERMISSION = "DELETE_COMMENT_Permission";

	public static String COMMENT_DISPLAY_DATE_FORMAT = "commentDisplayDateFormat";	
	
	public void serveResource(ResourceRequest resourceRequest,
	        ResourceResponse resourceResponse)
	    throws  IOException, PortletException {
		
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest
					.getAttribute(WebKeys.THEME_DISPLAY);
			User user = themeDisplay.getUser();
			
			String action = ParamUtil.getString(resourceRequest, "action");
			JSONObject data = JSONFactoryUtil.createJSONObject();
			if ("retrieveComments".equalsIgnoreCase(action)) {
				resourceResponse.setContentType("application/json");
				resourceResponse.setCharacterEncoding("utf-8");
				 data  = retrieveComments(resourceRequest, resourceResponse, themeDisplay);
				resourceResponse.getWriter().write(data.toString());
			} else if ("retrieveReplies".equalsIgnoreCase(action)) {
				resourceResponse.setContentType("application/json");
				resourceResponse.setCharacterEncoding("utf-8");
				data = retrieveReplies(resourceRequest, themeDisplay);
				resourceResponse.getWriter().write(data.toString());
			} else if ("addComment".equalsIgnoreCase(action)) {
				resourceResponse.setContentType("application/json");
				resourceResponse.setCharacterEncoding("utf-8");
				MBMessage mbmsg = addComment(resourceRequest, resourceResponse, themeDisplay);
				if(Validator.isNotNull(mbmsg)){
					data = convertToJsonObject(resourceRequest, mbmsg,user,"comment",themeDisplay);
					data.put("msg", "success");
				}
				resourceResponse.getWriter().write(data.toString());
			} else if ("updateComment".equalsIgnoreCase(action)) {
				resourceResponse.setContentType("application/json");
				resourceResponse.setCharacterEncoding("utf-8");
				MBMessage mbmsg = updateComment(resourceRequest, resourceResponse, themeDisplay);
				if(Validator.isNotNull(mbmsg)){
					data = convertToJsonObject(resourceRequest, mbmsg,user,"comment",themeDisplay);
					data.put("msg", "success");
				}
				resourceResponse.getWriter().write(data.toString());
			} else if ("addReply".equalsIgnoreCase(action)) {
				resourceResponse.setContentType("application/json");
				resourceResponse.setCharacterEncoding("utf-8");
				MBMessage mbmsg = addReply(resourceRequest, themeDisplay);
				if(Validator.isNotNull(mbmsg)){
					data = convertToJsonObject(resourceRequest, mbmsg,user,"reply", themeDisplay);
					data.put("msg", "success");
				}
				resourceResponse.getWriter().write(data.toString());
			} else if ("deleteComment".equalsIgnoreCase(action)) {
				resourceResponse.setContentType("application/json");
				resourceResponse.setCharacterEncoding("utf-8");
				data = deleteComment(resourceRequest);
				resourceResponse.getWriter().write(data.toString());
			}
			
		}catch(Exception ex){
			
		}
	}

	@SuppressWarnings("unchecked")
	private JSONObject deleteComment(ResourceRequest resourceRequest) throws PortalException, SystemException {
		//String isParentStr = resourceRequest.getParameter("is_parent");
		//String classPK = resourceRequest.getParameter("classPK");
		long commentId = GetterUtil.getLong(resourceRequest.getParameter("messageId"));

		// delete children comments
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(MBMessage.class, PortalClassLoaderUtil.getClassLoader());
		dynamicQuery.add(PropertyFactoryUtil.forName("parentMessageId").eq(new Long(commentId)));
		List<MBMessage> childComments = MBMessageLocalServiceUtil.dynamicQuery(dynamicQuery);

		for (MBMessage childComment : childComments) {
			try{
				MBMessageLocalServiceUtil.deleteMBMessage(childComment.getMessageId());
			}catch(Exception ex){
				_log.error(ex);
			}
		}
		
		boolean deleted = false;
		try {
			// delete comment
			MBMessageLocalServiceUtil.deleteMBMessage(commentId);
			deleted = true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		JSONObject dataJSONObject = JSONFactoryUtil.createJSONObject();
		dataJSONObject.put("messageId", commentId);
		dataJSONObject.put("deleted", deleted);
		return dataJSONObject;
	}

	private MBMessage addComment(ResourceRequest resourceRequest, ResourceResponse resourceResponse, ThemeDisplay themeDisplay)
			throws PortalException, SystemException {
		String classPKStr = resourceRequest.getParameter("classPK");
		String className = resourceRequest.getParameter("className");

		String content = resourceRequest.getParameter("content");

		long scopeGroupId = themeDisplay.getScopeGroupId();

		long classPK = GetterUtil.getLong(classPKStr);

		long currentUserId = themeDisplay.getUserId();


		String currentUserScreenName = themeDisplay.getUser().getScreenName();

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
		
		return mbmsg;
	}

	private MBMessage updateComment(ResourceRequest resourceRequest, ResourceResponse resourceResponse, ThemeDisplay themeDisplay)
			throws PortalException, SystemException {
		long commentId = GetterUtil.getLong(resourceRequest.getParameter("messageId"));
		String content = resourceRequest.getParameter("content");
		
		MBMessage mbmsg = MBMessageLocalServiceUtil.getMBMessage(commentId);
		mbmsg.setBody(content);
		mbmsg.setUserId(themeDisplay.getUserId());
		mbmsg.setUserName(themeDisplay.getUser().getScreenName());
		
		MBMessageLocalServiceUtil.updateMBMessage(mbmsg);		
		return mbmsg;
	}

	private MBMessage addReply(ResourceRequest resourceRequest, ThemeDisplay themeDisplay) throws PortalException, SystemException {
		String className = GetterUtil.getString(resourceRequest.getParameter("className"));
		String content = GetterUtil.getString(resourceRequest.getParameter("content"));
		long classPK = GetterUtil.getLong(resourceRequest.getParameter("classPK"));
		long parentId = GetterUtil.getLong(resourceRequest.getParameter("parentId"));

		int workflowAction = WorkflowConstants.ACTION_PUBLISH;
		long currentUserId = themeDisplay.getUserId();
		String currentUserScreenName = themeDisplay.getUser().getScreenName();

		MBMessage mbmsg = MBMessageLocalServiceUtil.addDiscussionMessage(currentUserId, currentUserScreenName, themeDisplay.getScopeGroupId(),
				className, classPK, workflowAction);
		mbmsg.setParentMessageId(parentId);
		mbmsg.setBody(content);
		MBMessageLocalServiceUtil.updateMBMessage(mbmsg);
		
		return mbmsg;
	}
	private JSONObject retrieveReplies(ResourceRequest resourceRequest, ThemeDisplay themeDisplay) throws PortalException, SystemException {

		long parentId = GetterUtil.getLong(resourceRequest.getParameter("parentId"));
		int curShowingNo = GetterUtil.getInteger(resourceRequest.getParameter("curShowingNo"));
		int initTotal = GetterUtil.getInteger(resourceRequest.getParameter("total"));
		int offset = GetterUtil.getInteger(resourceRequest.getParameter("offset"));

		int start = curShowingNo;
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(MBMessage.class, PortalClassLoaderUtil.getClassLoader());
		dynamicQuery.add(PropertyFactoryUtil.forName("parentMessageId").eq(new Long(parentId)));
		dynamicQuery.addOrder(OrderFactoryUtil.desc("createDate"));
		long childCountL = MBMessageLocalServiceUtil.dynamicQueryCount(dynamicQuery);
		int childCount = safeLongToInt(childCountL);

	/*	int balance = 0;
		balance = childCount - initTotal;
		start += balance;
*/
		JSONObject dataJSONObject = JSONFactoryUtil.createJSONObject();
		JSONArray comments = getChildComments(resourceRequest,parentId, start, offset);
		dataJSONObject.put("items", comments);
		dataJSONObject.put("msg", "success");
		return dataJSONObject;
	}
	private JSONObject retrieveComments(ResourceRequest resourceRequest, ResourceResponse resourceResponse, ThemeDisplay themeDisplay)
			throws PortalException, SystemException {
		String className = resourceRequest.getParameter("className");
		long classPK = GetterUtil.getLong(resourceRequest.getParameter("classPK"));
		int curShowingNo = GetterUtil.getInteger(resourceRequest.getParameter("curShowingNo"));
		int initTotal = GetterUtil.getInteger(resourceRequest.getParameter("total"));
		int offset = GetterUtil.getInteger(resourceRequest.getParameter("offset"));

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
		JSONArray comments = getCommentsL1(resourceRequest,classPK, classNameId, rootMessage.getMessageId(), start, offset, cStart, cOffset);
		JSONObject dataJSONObject = JSONFactoryUtil.createJSONObject();
		dataJSONObject.put("items", comments);
		dataJSONObject.put("msg", "success");
		return dataJSONObject;
	}
	
	@SuppressWarnings("unchecked")
	private JSONArray getChildComments(ResourceRequest resourceRequest,long parentId, int cStart, int cOffset) throws PortalException, SystemException {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(MBMessage.class, PortalClassLoaderUtil.getClassLoader());
		dynamicQuery = DynamicQueryFactoryUtil.forClass(MBMessage.class, PortalClassLoaderUtil.getClassLoader());
		dynamicQuery.add(PropertyFactoryUtil.forName("parentMessageId").eq(new Long(parentId)));
		dynamicQuery.addOrder(OrderFactoryUtil.desc("createDate"));

		List<MBMessage> childComments = MBMessageLocalServiceUtil.dynamicQuery(dynamicQuery, cStart, cStart + cOffset);

		JSONObject comment;
		JSONArray comments = JSONFactoryUtil.createJSONArray();
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		for (MBMessage childComment : childComments) {
			long userId = childComment.getUserId();
			User actor = UserLocalServiceUtil.getUserById(userId);
		    
			comment = convertToJsonObject(resourceRequest, childComment,actor,"reply",themeDisplay);
			comments.put(comment);
		}

		return comments;
	}
	
	@SuppressWarnings("unchecked")
	private JSONArray getCommentsL1(ResourceRequest resourceRequest,long classPK, long classNameId, long rootMessageId, int pStart, int pOffset, int cStart, int cOffset)
			throws PortalException, SystemException {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(MBMessage.class, PortalClassLoaderUtil.getClassLoader());
		dynamicQuery.add(PropertyFactoryUtil.forName("messageId").ne(new Long(rootMessageId)));
		dynamicQuery.add(PropertyFactoryUtil.forName("parentMessageId").eq(new Long(rootMessageId)));
		dynamicQuery.add(PropertyFactoryUtil.forName("classPK").eq(new Long(classPK)));
		dynamicQuery.add(PropertyFactoryUtil.forName("classNameId").eq(new Long(classNameId)));
		dynamicQuery.addOrder(OrderFactoryUtil.desc("createDate"));

		List<MBMessage> parentComments = MBMessageLocalServiceUtil.dynamicQuery(dynamicQuery, pStart, pStart + pOffset);
		JSONObject comment;
		JSONArray comments = JSONFactoryUtil.createJSONArray();
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		for (MBMessage parentComment : parentComments) {
			long parentCommentId = parentComment.getMessageId();
			long userId = parentComment.getUserId();
			User actor = UserLocalServiceUtil.getUserById(userId);
		    
			comment = convertToJsonObject(resourceRequest, parentComment,actor,"comment",themeDisplay); //JSONFactoryUtil.createJSONObject();
	/*		comment.put("messageId", parentComment.getMessageId());
			comment.put("fullName", actor.getFullName());
			comment.put("userId", parentComment.getUserId());
			comment.put("content", parentComment.getBody());
			comment.put("parentMessageId", parentComment.getParentMessageId());
			comment.put("createDate", parentComment.getCreateDate());
			comment.put("displayDate", getTimeDifferent(parentComment.getCreateDate(),new Date()));
			comment.put("screenName", actor.getScreenName());
			comment.put("portraitId", actor.getPortraitId());
			comment.put("thumbnailImg", "/image/user_male_portrait?img_id=" + actor.getPortraitId());
			comment.put("type", "comment"); */

			dynamicQuery = DynamicQueryFactoryUtil.forClass(MBMessage.class, PortalClassLoaderUtil.getClassLoader());
			dynamicQuery.add(PropertyFactoryUtil.forName("parentMessageId").eq(new Long(parentCommentId)));
			dynamicQuery.addOrder(OrderFactoryUtil.desc("createDate"));

			long childCount = MBMessageLocalServiceUtil.dynamicQueryCount(dynamicQuery);
			comment.put("childCount", childCount);
			
			comments.put(comment);
		}

		return comments;
	}
	
	private JSONObject convertToJsonObject(ResourceRequest resourceRequest, MBMessage parentComment,User actor,String type,ThemeDisplay themeDisplay){
		JSONObject comment = JSONFactoryUtil.createJSONObject();
		if(Validator.isNotNull(comment)){
			comment.put("messageId", parentComment.getMessageId());
			comment.put("fullName", actor.getFullName());
			comment.put("userId", parentComment.getUserId());
			comment.put("content", parentComment.getBody());
			comment.put("parentMessageId", parentComment.getParentMessageId());
			comment.put("createDate", parentComment.getCreateDate());
			String displayDateFormat = retrieveDisplayDateFormat(resourceRequest);
			String displayDate = "default".equals(displayDateFormat)
					? getTimeDifferent(parentComment.getCreateDate(),new Date())
					: DateUtils.toString(parentComment.getCreateDate(), displayDateFormat);
			comment.put("displayDate", displayDate);
			comment.put("screenName", actor.getScreenName());
			comment.put("portraitId", actor.getPortraitId());
//			comment.put("thumbnailImg", "/image/user_male_portrait?img_id=" + actor.getPortraitId());
			try {
				comment.put("thumbnailImg", actor.getPortraitURL(themeDisplay));
			} catch (PortalException e) {
				_log.error(e.getMessage());
			} catch (SystemException e) {
				_log.error(e.getMessage());
			}
			comment.put("type", type);
		}
		return comment;
	}

	private int safeLongToInt(long l) {
		if (l < Integer.MIN_VALUE || l > Integer.MAX_VALUE) {
			throw new IllegalArgumentException(l + " cannot be cast to int without changing its value.");
		}

		return (int)l;
	}

	public static String getTimeDifferent(Date d1, Date d2) {
		String timeDiff = "";

		if(d1 == null || d2 == null){
			return timeDiff;
		}
		
		long diff = d2.getTime() - d1.getTime();

		long seconds = diff / 1000;
		long minutes = diff / (60 * 1000) ;
		long hours = diff / (60 * 60 * 1000) ;
		long days = diff / (24 * 60 * 60 * 1000);
		long years = diff / (24 * 60 * 60 * 1000)/365;
		long months = diff / (24 * 60 * 60 * 1000)/30;
		if (years == 0) {
			if (months == 0) {
				if (days == 0) {
					if (hours == 0) {
						if (minutes == 0) {
							if (seconds == 0) {
								timeDiff = "0 second ago";
							} else {
								if (seconds == 1) {
									timeDiff = "1 second ago";
								} else {
									timeDiff = seconds + " seconds ago";
								}
							}
						} else {
							if (minutes == 1) {
								timeDiff = "1 minute ago";
							} else {
								timeDiff = minutes + " minutes ago";
							}
						}
					} else {
						if (hours == 1) {
							timeDiff = "1 hour ago";
						} else {
							timeDiff = hours + " hours ago";
						}
					}
				} else {
					if (days == 1) {
						timeDiff = "1 day ago";
					} else {
						timeDiff = days + " days ago";
					}
				}
			} else {
				if (months == 1) {
					timeDiff = "1 month ago";
				} else {
					timeDiff = months + " months ago";
				}
			}
		} else {
			if (years == 1) {
				timeDiff = "1 year ago";
			} else {
				timeDiff = years + " years ago";
			}
		}

		return timeDiff;
	}

	public static boolean canViewComments(PortletRequest request, String portletName){
		return hasCommentPermission(ACTION_VIEW_COMMENTS, request, portletName);
	}
	public static boolean canAddComment(PortletRequest request, String portletName){
		return hasCommentPermission(ACTION_ADD_COMMENT, request, portletName);
	}
	public static boolean canUpdateComments(PortletRequest request, String portletName){
		return hasCommentPermission(ACTION_UPDATE_COMMENT, request, portletName);
	}
	public static boolean canDeleteComment(PortletRequest request, String portletName){
		return hasCommentPermission(ACTION_DELETE_COMMENT, request, portletName);
	}
	public static boolean hasCommentPermission(String commentAction, PortletRequest request, String portletName){
		boolean retval = false;
		try {
			retval = authorize(request, portletName, commentAction);	
		} catch (Exception e) {
			// no access
		}
		return retval;
	}

	public static boolean hasCommentPermissionAttribute(PortletRequest request, String permAttribute){
		// default view / add comment to true for portlets that don't have role permission yet like SPAsset
		// The rest will be false if not set. 
		// Such that only the comment owner can do update / delete of his own comment.
		List<String> DEFAULT_TO_TRUE = Arrays.asList(ACTION_VIEW_COMMENTS_PERMISSION, ACTION_ADD_COMMENT_PERMISSION);
		try {
			return request.getAttribute(permAttribute) == null && DEFAULT_TO_TRUE.contains(permAttribute)
					? true : (Boolean) request.getAttribute(permAttribute);
		} catch (Exception e) {
			return DEFAULT_TO_TRUE.contains(permAttribute) ? true : false;
		}
		
	}
	
	public static String retrieveDisplayDateFormat(PortletRequest request){
		try {
			String displayFormat = request.getPreferences().getValue(COMMENT_DISPLAY_DATE_FORMAT, "");
			return "".equals(displayFormat.trim()) ? "default" : displayFormat;
		} catch (Exception e) {
			return "default";
		}
	}
	
	private static boolean authorize(PortletRequest req, String portletName,String action) {
		ThemeDisplay themeDisplay = (ThemeDisplay) req
				.getAttribute(WebKeys.THEME_DISPLAY);
		Layout layout = themeDisplay.getLayout();
		long plid = layout.getPlid();
		PermissionChecker permissionChecker = PermissionThreadLocal.getPermissionChecker();
		try {
			PortletPermissionUtil.check(permissionChecker, plid, portletName, action);
		} catch (PrincipalException pe) {
			_log.warn("Unauthorized access of " + action + " by user " + themeDisplay.getUserId());
			return false;
		} catch (Exception e) {
			_log.error("System error while checking permission for " + action + " by user " + themeDisplay.getUserId());
			return false;
		}
		return true;
	}

	public static final boolean isCommentRequest(PortletRequest resourceRequest) {
		String action = ParamUtil.getString(resourceRequest, "action");
		return CommentTagProcess.COMMENT_ACTIONS.contains(action);
	}
	
	public static final void addCommentPermissionToReq(PortletRequest renderRequest, String portletName) {
		renderRequest.setAttribute(CommentTagProcess.ACTION_VIEW_COMMENTS_PERMISSION,
				CommentTagProcess.canViewComments(renderRequest,portletName)
		);
		renderRequest.setAttribute(CommentTagProcess.ACTION_ADD_COMMENT_PERMISSION,
				CommentTagProcess.canAddComment(renderRequest,portletName)
		);
		renderRequest.setAttribute(CommentTagProcess.ACTION_UPDATE_COMMENT_PERMISSION,
				CommentTagProcess.canUpdateComments(renderRequest,portletName)
		);
		renderRequest.setAttribute(CommentTagProcess.ACTION_DELETE_COMMENT_PERMISSION,
				CommentTagProcess.canDeleteComment(renderRequest,portletName)
		);
	}

	
	public static void main(String[] args) {

		String dateStart = "01/15/2012 10:21:50";
		String dateStop = "01/15/2013 10:31:48";

		//HH converts hour in 24 hours format (0-23), day calculation
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

		Date d1 = null;
		Date d2 = null;

		try {
			d1 = format.parse(dateStart);
			d2 = format.parse(dateStop);

			//in milliseconds
			long diff = d2.getTime() - d1.getTime();

			long diffSeconds = diff / 1000;
			long diffMinutes = diff / (60 * 1000) ;
			long diffHours = diff / (60 * 60 * 1000) ;
			long diffDays = diff / (24 * 60 * 60 * 1000);
			long diffYears = diff / (24 * 60 * 60 * 1000)/365;
			long diffMonths = diff / (24 * 60 * 60 * 1000)/30;

			_log.debug(diffDays + " days, ");
			_log.debug(diffHours + " hours, ");
			_log.debug(diffMinutes + " minutes, ");
			_log.debug(diffSeconds + " seconds.");
			_log.debug(diffMonths + " months.");

		} catch (Exception e) {
			_log.error(e);
		}

	}

}
