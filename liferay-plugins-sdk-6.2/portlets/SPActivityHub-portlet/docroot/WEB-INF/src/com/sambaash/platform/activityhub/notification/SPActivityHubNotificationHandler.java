package com.sambaash.platform.activityhub.notification;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.notifications.BaseUserNotificationHandler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.UserNotificationEvent;
import com.liferay.portal.service.ServiceContext;
import com.sambaash.platform.activityhub.constants.SPActivityHubConstants;

public class SPActivityHubNotificationHandler extends
		BaseUserNotificationHandler {

	public SPActivityHubNotificationHandler() {
		setPortletId(SPActivityHubConstants.PORTLET_ID);
	}

	@Override
	protected String getBody(UserNotificationEvent userNotificationEvent,
			ServiceContext serviceContext) throws Exception {

		String payload = userNotificationEvent.getPayload();
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject(payload);
		String userName = jsonObject
				.getString(SPActivityHubNotificationConstants.USER_NAME);
		String title = null;
		String activityHubUrl = jsonObject
				.getString(SPActivityHubNotificationConstants.ACTIVITYHUB_LINK);
		String body = null;
		StringBuilder sb = null;

		sb = new StringBuilder();
		sb.append("<div class=\"notification-body\">[$USERNAME$] [$BODY_TEXT$]<a class=\"");
		sb.append("view-challenge\" href=\"[$URL$]\">[$TITLE$]</a></div>");

		body = "sent you a ";
		title = "message";

		return StringUtil.replace(sb.toString(),
				new String[] { "[$BODY_TEXT$]", "[$USERNAME$]",
						"[$URL$]", "[$TITLE$]" }, new String[] { body,
						userName, activityHubUrl, title });

	}

	@Override
	protected String getLink(UserNotificationEvent userNotificationEvent,
			ServiceContext serviceContext) throws Exception {
		String payload = userNotificationEvent.getPayload();
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject(payload);
		String link = jsonObject
				.getString(SPActivityHubNotificationConstants.ACTIVITYHUB_LINK);
		return Validator.isNull(link) ? "" : link;
	}

}