package com.sambaash.platform.portlet.spblogs.notification;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.notifications.BaseUserNotificationHandler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.UserNotificationEvent;
import com.liferay.portal.service.ServiceContext;

public class SPBlogsNotificationHandler extends BaseUserNotificationHandler {

	public SPBlogsNotificationHandler() {
		setPortletId(SPBlogsNotificationConstants.PORTLET_ID);
	}
	
	@Override
	protected String getBody(UserNotificationEvent userNotificationEvent,
			ServiceContext serviceContext) throws Exception {

		String payload = userNotificationEvent.getPayload();
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject(payload);
		int notificationType = jsonObject
				.getInt(SPBlogsNotificationConstants.NOTIFICATION_TYPE);
		String link = jsonObject.getString(SPBlogsNotificationConstants.LINK);
		String userName = jsonObject.getString(SPBlogsNotificationConstants.USER_NAME);
		String title = jsonObject.getString(SPBlogsNotificationConstants.TITLE);
		String body = null;
		StringBuilder sb = new StringBuilder();
			sb.append("<div class=\"notification-body\">[$USERNAME$] [$BODY_TEXT$]<a class=\"");
			sb.append("view-challenge\" href=\"[$URL$]\">[$TITLE$]</a></div>");
		
		switch (notificationType) {
		case SPBlogsNotificationConstants.NOTIFICATION_TYPE_BLOG_CREATED:
			body = "created a new blog ";
			break;
		case SPBlogsNotificationConstants.NOTIFICATION_TYPE_BLOG_MODIFIED:	
			body = "modified a blog ";			
			break;
		case SPBlogsNotificationConstants.NOTIFICATION_TYPE_BLOG_DELETED:	
			body = "deleted a blog ";
			link = "javascript: void(0)";
			break;
		default:
			throw new IllegalArgumentException("Invalid/Missing notification type!!");
		}
		
		return StringUtil.replace(sb.toString(), new String[] {
				"[$BODY_TEXT$]", "[$URL$]", "[$USERNAME$]", "[$TITLE$]" }, new String[] { body, link,
				userName, title });
	}

	@Override
	protected String getLink(UserNotificationEvent userNotificationEvent,
			ServiceContext serviceContext) throws Exception {
		String payload = userNotificationEvent.getPayload();
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject(payload);
		String link = jsonObject.getString(SPBlogsNotificationConstants.LINK);
		return Validator.isNull(link) ? "" : link;
	}

}