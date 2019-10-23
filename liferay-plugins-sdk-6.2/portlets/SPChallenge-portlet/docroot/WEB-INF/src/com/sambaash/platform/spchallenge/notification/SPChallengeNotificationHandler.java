package com.sambaash.platform.spchallenge.notification;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.notifications.BaseUserNotificationHandler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.UserNotificationEvent;
import com.liferay.portal.service.ServiceContext;
import com.sambaash.platform.spchallenge.helper.SPChallengeConstants;

public class SPChallengeNotificationHandler extends BaseUserNotificationHandler {

	public SPChallengeNotificationHandler() {
		setPortletId(SPChallengeConstants.PORTLET_ID);
	}
	
	@Override
	protected String getBody(UserNotificationEvent userNotificationEvent,
			ServiceContext serviceContext) throws Exception {

		String payload = userNotificationEvent.getPayload();
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject(payload);
		int notificationType = jsonObject
				.getInt(SPChallengeNotificationConstants.NOTIFICATION_TYPE);
		String link = jsonObject.getString(SPChallengeNotificationConstants.LINK);
		String userName = jsonObject.getString(SPChallengeNotificationConstants.USER_NAME);
		String title = jsonObject.getString(SPChallengeNotificationConstants.TITLE);
		String startupUrl = jsonObject.getString(SPChallengeNotificationConstants.STARTUP_LINK);
		String body = null;
		StringBuilder sb = null;
		
		if (SPChallengeNotificationConstants.NOTIFICATION_TYPE_CHALLENGE_CREATE == notificationType) {
			sb = new StringBuilder();
			sb.append("<div class=\"notification-body\">[$USERNAME$] [$BODY_TEXT$]<a class=\"");
			sb.append("view-challenge\" href=\"[$URL$]\">[$TITLE$]</a></div>");

			body = "created a new challenge ";
		} else if (SPChallengeNotificationConstants.NOTIFICATION_TYPE_CHALLENGE_APPLIED == notificationType) {
			sb = new StringBuilder();
			sb.append("<div class=\"notification-body\"><a class=\"");
			sb.append("view-applicant\" href=\"[$STARTUPURL$]\">[$USERNAME$]</a> [$BODY_TEXT$] <a class=\"");
			sb.append("view-challenge\" href=\"[$URL$]\">[$TITLE$]</a></div>");
			
			body = "has applied for ";
		}
		if (Validator.isNotNull(sb)) {
			return StringUtil.replace(sb.toString(), new String[] {
					"[$BODY_TEXT$]", "[$URL$]", "[$USERNAME$]",
					"[$STARTUPURL$]", "[$TITLE$]" }, new String[] { body, link,
					userName, startupUrl, title });
		} else {
			throw new IllegalArgumentException("Invalid/Missing notification type!!");
		}

	}

	@Override
	protected String getLink(UserNotificationEvent userNotificationEvent,
			ServiceContext serviceContext) throws Exception {
		String payload = userNotificationEvent.getPayload();
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject(payload);
		String link = jsonObject.getString(SPChallengeNotificationConstants.LINK);
		return Validator.isNull(link) ? "" : link;
	}

}