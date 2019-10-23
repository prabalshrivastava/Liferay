<%--
/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
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
--%>

<%@ include file="/html/common/init.jsp" %>

<%@ page import="com.liferay.portlet.calendar.service.permission.CalendarPermission" %>

<%
PortletPreferences preferences = renderRequest.getPreferences();

String portletResource = ParamUtil.getString(request, "portletResource");

if (Validator.isNotNull(portletResource)) {
	preferences = PortletPreferencesFactoryUtil.getPortletSetup(request, portletResource);
}

String tabs1Names = "summary,day,week,month,year,events";

if (CalendarPermission.contains(permissionChecker, scopeGroupId, ActionKeys.EXPORT_ALL_EVENTS) || CalendarPermission.contains(permissionChecker, scopeGroupId, ActionKeys.ADD_EVENT)) {
	tabs1Names += ",export-import";
}

String[] tabs1NamesArray = StringUtil.split(tabs1Names);

String tabs1Default = preferences.getValue("tabs1Default", tabs1NamesArray[0]);

String summaryTabOrientation = preferences.getValue("summaryTabOrientation", "horizontal");
boolean summaryTabShowMiniMonth = GetterUtil.getBoolean(preferences.getValue("summaryTabShowMiniMonth", "true"));
boolean summaryTabShowTodaysEvents = GetterUtil.getBoolean(preferences.getValue("summaryTabShowTodaysEvents", "true"));
boolean enableRelatedAssets = GetterUtil.getBoolean(preferences.getValue("enableRelatedAssets", null), true);
boolean enableRatings = PropsValues.CALENDAR_EVENT_RATINGS_ENABLED && GetterUtil.getBoolean(preferences.getValue("enableRatings", null), true);
boolean enableComments = PropsValues.CALENDAR_EVENT_COMMENTS_ENABLED && GetterUtil.getBoolean(preferences.getValue("enableComments", null), true);

String monthParam = request.getParameter("month");
String dayParam = request.getParameter("day");
String yearParam = request.getParameter("year");

Calendar selCal = CalendarFactoryUtil.getCalendar(timeZone, locale);

try {
	selCal.set(Calendar.YEAR, Integer.parseInt(yearParam));
}
catch (NumberFormatException nfe) {
}

try {
	if (dayParam != null) {
		selCal.set(Calendar.DATE, 1);
	}

	selCal.set(Calendar.MONTH, Integer.parseInt(monthParam));
}
catch (NumberFormatException nfe) {
}

try {
	int maxDayOfMonth = selCal.getActualMaximum(Calendar.DATE);

	int dayParamInt = Integer.parseInt(dayParam);

	if (dayParamInt > maxDayOfMonth) {
		dayParamInt = maxDayOfMonth;
	}

	selCal.set(Calendar.DATE, dayParamInt);
}
catch (NumberFormatException nfe) {
}

int selMonth = selCal.get(Calendar.MONTH);
int selDay = selCal.get(Calendar.DATE);
int selYear = selCal.get(Calendar.YEAR);

Calendar curCal = CalendarFactoryUtil.getCalendar(timeZone, locale);

int curMonth = curCal.get(Calendar.MONTH);
int curDay = curCal.get(Calendar.DATE);
int curYear = curCal.get(Calendar.YEAR);

int[] monthIds = CalendarUtil.getMonthIds();
String[] months = CalendarUtil.getMonths(locale);

String[] days = CalendarUtil.getDays(locale);

Format dateFormatDate = FastDateFormatFactoryUtil.getDate(locale);
Format dateFormatDateTime = FastDateFormatFactoryUtil.getDateTime(locale);
Format dateFormatTime = FastDateFormatFactoryUtil.getTime(locale);
DateFormat dateFormatISO8601 = DateUtil.getISO8601Format();
%>