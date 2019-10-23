package com.sambaash.platform.portlet.spgroup.notifications;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.notifications.BaseUserNotificationHandler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.UserNotificationEvent;
import com.liferay.portal.service.ServiceContext;
import com.sambaash.platform.portlet.spgroup.util.SPGroupConstants;

public class SPGroupNotificationHandler extends BaseUserNotificationHandler {

	public SPGroupNotificationHandler() {
		setPortletId(SPGroupConstants.PORTLET_ID_GROUP_DETAIL);
	}

	@Override
	protected String getBody(UserNotificationEvent userNotificationEvent,
			ServiceContext serviceContext) throws Exception {

		String payload = userNotificationEvent.getPayload();
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject(payload);
		int notificationType = jsonObject
				.getInt(SPGroupConstants.NOTIFICATIONS.NOTIFICATION_TYPE);
		String userName = jsonObject
				.getString(SPGroupConstants.NOTIFICATIONS.USER_NAME);
		String groupUrl = jsonObject
				.getString(SPGroupConstants.NOTIFICATIONS.GROUP_URL);
		String groupName = jsonObject
				.getString(SPGroupConstants.NOTIFICATIONS.GROUP_NAME);
		String discUrl = jsonObject
				.getString(SPGroupConstants.NOTIFICATIONS.DISC_URL);
		String discName = jsonObject
				.getString(SPGroupConstants.NOTIFICATIONS.DISC_NAME);
		String ignoreUrl = jsonObject
				.getString(SPGroupConstants.NOTIFICATIONS.IGNORE_URL);

		StringBuilder sb = null;
		if (SPGroupConstants.NOTIFICATIONS.NOTIFICATION_TYPE_USER_COMMENT == notificationType) {
			sb = new StringBuilder();
			sb.append("<div class='notification-body'>[$USERNAME$] added a new comment on <a class='view-discussion'");
			sb.append(" href='[$DISC_URL$]'>[$DISC_NAME$]</a> in the group <a class='view-group' href='[$GROUP_URL$]'>[$GROUP_NAME$]</a></div>");
		} else if (SPGroupConstants.NOTIFICATIONS.NOTIFICATION_TYPE_USER_JOINED == notificationType) {
			sb = new StringBuilder();
			sb.append("<div class='notification-body'>[$USERNAME$] joined a discussion group <a class='view-group' href='[$GROUP_URL$]'>[$GROUP_NAME$]</a>");
		} else if (SPGroupConstants.NOTIFICATIONS.NOTIFICATION_TYPE_NEW_DICUSSION == notificationType) {
			sb = new StringBuilder();
			sb.append("<div class='notification-body'>[$USERNAME$] added a new discussion <a class='view-discussion'");
			sb.append(" href='[$DISC_URL$]'>[$DISC_NAME$]</a> in the group <a class='view-group' href='[$GROUP_URL$]'>[$GROUP_NAME$]</a></div>");
		} else if (SPGroupConstants.NOTIFICATIONS.NOTIFICATION_TYPE_APPROVE_INVITE_REQUEST == notificationType) {
			sb = new StringBuilder();
			sb.append("<div class='notification-body'>[$USERNAME$] has invited you to a discussion group <b>[$GROUP_NAME$]</b>.<br><br>");
			sb.append(" <div class='text-right'> <button class='btn btn-success accept' onclick=\"javascript:document.location.href='[$GROUP_URL$]'\">Accept</button>");
			sb.append(" <button class='btn margin-left-half' onclick=\"javascript:document.location.href='[$IGNORE_URL$]'\">Ignore</button></div></div>");
		} else if (SPGroupConstants.NOTIFICATIONS.NOTIFICATION_TYPE_APPROVE_JOINER == notificationType) {
			sb = new StringBuilder();
			sb.append("<div class='notification-body'>[$USERNAME$] has requested to join discussion group <b>[$GROUP_NAME$]</b>.<br><br>");
			sb.append(" <div class='text-right'> <button class='btn btn-success accept' onclick=\"javascript:document.location.href='[$GROUP_URL$]'\">Accept</button>");
			sb.append(" <button class='btn margin-left-half' onclick=\"javascript:document.location.href='[$IGNORE_URL$]'\">Reject</button></div></div>");
		} else if (SPGroupConstants.NOTIFICATIONS.NOTIFICATION_TYPE_JOIN_REQUEST_APPROVED == notificationType 
				|| SPGroupConstants.NOTIFICATIONS.NOTIFICATION_TYPE_JOIN_REQUEST_REJECTED == notificationType) {
			String status = "approved";
			if (SPGroupConstants.NOTIFICATIONS.NOTIFICATION_TYPE_JOIN_REQUEST_REJECTED == notificationType) {
				status = "rejected";
			}
			sb = new StringBuilder();
			sb.append("<div class='notification-body'>Your request to join the discussion group <a class='view-group' href='[$GROUP_URL$]'>[$GROUP_NAME$]</a> has been ");
			sb.append(status);
		}
		if (Validator.isNotNull(sb)) {
			return StringUtil.replace(sb.toString(), new String[] {
					"[$USERNAME$]", "[$GROUP_URL$]", "[$GROUP_NAME$]",
					"[$DISC_URL$]", "[$DISC_NAME$]", "[$IGNORE_URL$]" }, new String[] { userName,
					groupUrl, groupName, discUrl, discName, ignoreUrl });
		} else {
			throw new IllegalArgumentException(
					"Invalid/Missing notification type!!");
		}

	}

	@Override
	protected String getLink(UserNotificationEvent userNotificationEvent,
			ServiceContext serviceContext) throws Exception {
		String payload = userNotificationEvent.getPayload();
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject(payload);
		int notificationType = jsonObject
				.getInt(SPGroupConstants.NOTIFICATIONS.NOTIFICATION_TYPE);
		String link = null;
		if (SPGroupConstants.NOTIFICATIONS.NOTIFICATION_TYPE_USER_JOINED == notificationType 
				|| SPGroupConstants.NOTIFICATIONS.NOTIFICATION_TYPE_JOIN_REQUEST_APPROVED == notificationType 
				|| SPGroupConstants.NOTIFICATIONS.NOTIFICATION_TYPE_JOIN_REQUEST_REJECTED == notificationType) {
			link = jsonObject.getString(SPGroupConstants.NOTIFICATIONS.GROUP_URL);
		} else if (SPGroupConstants.NOTIFICATIONS.NOTIFICATION_TYPE_USER_COMMENT == notificationType 
				|| SPGroupConstants.NOTIFICATIONS.NOTIFICATION_TYPE_NEW_DICUSSION == notificationType) {
			link = jsonObject.getString(SPGroupConstants.NOTIFICATIONS.DISC_URL);
		} else if (SPGroupConstants.NOTIFICATIONS.NOTIFICATION_TYPE_APPROVE_INVITE_REQUEST == notificationType 
				|| SPGroupConstants.NOTIFICATIONS.NOTIFICATION_TYPE_APPROVE_JOINER == notificationType) {
			link = jsonObject.getString(SPGroupConstants.NOTIFICATIONS.GROUP_URL);
			link = link.substring(0, link.indexOf("?"));
		}
		return Validator.isNull(link) ? "" : link;
	}

}