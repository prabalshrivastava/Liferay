/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.calendar.notification;

import com.liferay.calendar.model.Calendar;
import com.liferay.calendar.model.CalendarBooking;
import com.liferay.calendar.model.CalendarNotificationTemplate;
import com.liferay.calendar.service.CalendarNotificationTemplateLocalServiceUtil;
import com.liferay.calendar.util.PortletKeys;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.FastDateFormatFactoryUtil;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.Company;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.User;
import com.liferay.portal.service.CompanyLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;

import com.sambaash.platform.constant.SambaashConstants;
import com.sambaash.platform.util.SambaashUtil;

import java.io.Serializable;

import java.text.Format;

import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

import javax.portlet.PortletConfig;
import javax.portlet.WindowState;

/**
 * @author Eduardo Lundgren
 */
public class NotificationTemplateContextFactory {

	public static NotificationTemplateContext getInstance(
			NotificationType notificationType,
			NotificationTemplateType notificationTemplateType,
			CalendarBooking calendarBooking, User user)
		throws Exception {

		CalendarBooking parentCalendarBooking =
			calendarBooking.getParentCalendarBooking();

		Calendar calendar = parentCalendarBooking.getCalendar();

		NotificationTemplateContext notificationTemplateContext =
			new NotificationTemplateContext();

		CalendarNotificationTemplate calendarNotificationTemplate =
			CalendarNotificationTemplateLocalServiceUtil.
				fetchCalendarNotificationTemplate(
					calendar.getCalendarId(), notificationType,
					notificationTemplateType);

		notificationTemplateContext.setCalendarNotificationTemplate(
			calendarNotificationTemplate);

		notificationTemplateContext.setCompanyId(
			calendarBooking.getCompanyId());
		notificationTemplateContext.setGroupId(calendarBooking.getGroupId());
		notificationTemplateContext.setCalendarId(calendar.getCalendarId());
		notificationTemplateContext.setNotificationTemplateType(
			notificationTemplateType);
		notificationTemplateContext.setNotificationType(notificationType);

		// Attributes

		Map<String, Serializable> attributes =
			new HashMap<String, Serializable>();

		TimeZone userTimezone = user.getTimeZone();

		Format dateFormatDateTime = FastDateFormatFactoryUtil.getDateTime(
			user.getLocale(), userTimezone);

		String userTimezoneDisplayName = userTimezone.getDisplayName(
			false, TimeZone.SHORT, user.getLocale());

		String endTime =
			dateFormatDateTime.format(calendarBooking.getEndTime()) +
				StringPool.SPACE + userTimezoneDisplayName;

		attributes.put("endTime", endTime);

		attributes.put("location", calendarBooking.getLocation());

		Group group = user.getGroup();

		String portalURL = _getPortalURL(
			group.getCompanyId(), group.getGroupId());

		attributes.put("portalURL", portalURL);
		attributes.put(
			"portletName",
			LanguageUtil.get(
				getPortletConfig(), user.getLocale(),
				"javax.portlet.title.".concat(PortletKeys.CALENDAR)));

		String startTime =
			dateFormatDateTime.format(calendarBooking.getStartTime()) +
				StringPool.SPACE + userTimezoneDisplayName;

		attributes.put("startTime", startTime);

		attributes.put("title", calendarBooking.getTitle(user.getLocale()));

		String calendarBookingURL = _getCalendarBookingURL(
			user, calendarBooking.getCalendarBookingId());

		attributes.put("url", calendarBookingURL);

		// Naresh May 10,2016 - added logo,headerBkgColor attibutes. Event invite template customized to have community branding.so below two attibutes required
		// Also see NotificationTemplateRenderer.replaceTokens, uses below set attrs.

		String logopath = SambaashUtil.getParameter(SambaashConstants.LOGO_PATH, SambaashUtil.getGroupId(user.getCompanyId()));
		String bkgColor = SambaashUtil.getParameter(SambaashConstants.CALENDAR_EMAIL_HEADER_BKG_COLOR, SambaashUtil.getGroupId(user.getCompanyId()));
		String copyright = SambaashUtil.getParameter(SambaashConstants.COPY_RIGHT, SambaashUtil.getGroupId(user.getCompanyId()));
		attributes.put("logo", logopath);
		attributes.put("headerBkgColor", bkgColor);
		attributes.put("copyright", copyright);

		notificationTemplateContext.setAttributes(attributes);

		return notificationTemplateContext;
	}

	public static PortletConfig getPortletConfig() {
		return _portletConfig;
	}

	public static void setPortletConfig(PortletConfig portletConfig) {
		_portletConfig = portletConfig;
	}

	private static String _getCalendarBookingURL(
			User user, long calendarBookingId)
		throws PortalException, SystemException {

		Group group = user.getGroup();

		// Naresh, may 5,2016 wrapping  layout related code in try/catch as it is throwing error if the private layout does not exists

	//	String layoutActualURL = StringPool.BLANK;
		try {
		//	Layout layout = LayoutLocalServiceUtil.getLayout(
		//			group.getDefaultPrivatePlid());
	//		layoutActualURL = PortalUtil.getLayoutActualURL(layout);
		}catch (Exception ex) {
			_log.error(ex);
		}

		String portalURL = _getPortalURL(
			group.getCompanyId(), group.getGroupId());

		String url = portalURL;

		String namespace = PortalUtil.getPortletNamespace(PortletKeys.CALENDAR);

		url = HttpUtil.addParameter(
			url, namespace + "mvcPath", "/view_calendar_booking.jsp");
		url = HttpUtil.addParameter(url, "p_p_id", PortletKeys.CALENDAR);
		url = HttpUtil.addParameter(url, "p_p_lifecycle", "0");
		url = HttpUtil.addParameter(
			url, "p_p_state", WindowState.MAXIMIZED.toString());
		url = HttpUtil.addParameter(
			url, namespace + "calendarBookingId", calendarBookingId);

		return url;
	}

	private static String _getPortalURL(long companyId, long groupId)
		throws PortalException, SystemException {

		Company company = CompanyLocalServiceUtil.getCompany(companyId);

		String portalURL = company.getPortalURL(groupId);

		/*portalURL = HttpUtil.protocolize(
			portalURL, PortalUtil.getPortalPort(false), false);*/

		return portalURL;
	}

	private static PortletConfig _portletConfig;
	private static Log _log = LogFactoryUtil.getLog(NotificationTemplateContextFactory.class);
}