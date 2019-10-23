package com.sambaash.platform.finance.notifications;

import com.liferay.compat.portal.kernel.notifications.BaseUserNotificationHandler;
import com.liferay.compat.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.model.UserNotificationEvent;
import com.liferay.portal.service.ServiceContext;
import com.sambaash.platform.finance.constants.FinanceConstants;
import com.sambaash.platform.util.SambaashUtil;

public class ReceiptNotificationHandler extends BaseUserNotificationHandler {

	public ReceiptNotificationHandler() {
		setPortletId(FinanceConstants.RECEIPT_NOTIFICATION);
	}

	@Override
	protected String getBody(UserNotificationEvent userNotificationEvent, ServiceContext serviceContext)
			throws Exception {
		String payload = userNotificationEvent.getPayload();
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject(payload);
		String notificationType = jsonObject.getString(FinanceConstants.NOTIFICATION_TYPE);
		String link = jsonObject.getString(FinanceConstants.NOTIFICATION_LINK);
		String receiptNumber = jsonObject.getString(FinanceConstants.NOTIFICATION_RECEIPT_NUMBER);
		String body = null;
		switch (notificationType) {
		case FinanceConstants.NOTIFICATION_TYPE_VOID_RECEIPT:
		case FinanceConstants.NOTIFICATION_TYPE_CANCEL_RECEIPT:
			body = FinanceConstants.APPROVER_RECEIPT_NOTIFICATION_BODY
					.replace(FinanceConstants.NOTIFICATION_RECEIPT_NUMBER, receiptNumber).replace("link", link);
			break;
		case FinanceConstants.NOTIFICATION_TYPE_RETURN_RECEIPT:
			body = FinanceConstants.SUBMITTER_RECEIPT_NOTIFICATION_BODY
					.replace(FinanceConstants.NOTIFICATION_RECEIPT_NUMBER, receiptNumber).replace("link", link);
			break;
		default:
			throw new IllegalArgumentException("Invalid/Missing notification type!!");
		}

		return body;
	}

	@Override
	protected String getLink(UserNotificationEvent userNotificationEvent, ServiceContext serviceContext)
			throws Exception {
		String payload = userNotificationEvent.getPayload();
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject(payload);
		return jsonObject.getString(FinanceConstants.NOTIFICATION_LINK);
	}

}
