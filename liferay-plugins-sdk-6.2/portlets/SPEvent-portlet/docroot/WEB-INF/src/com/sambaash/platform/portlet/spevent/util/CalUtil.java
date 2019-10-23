package com.sambaash.platform.portlet.spevent.util;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

import javax.portlet.PortletMode;
import javax.portlet.PortletModeException;
import javax.portlet.PortletURL;
import javax.portlet.WindowStateException;

import com.liferay.calendar.model.CalendarBooking;
import com.liferay.calendar.model.CalendarResource;
import com.liferay.calendar.service.permission.CalendarPermission;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.LiferayWindowState;
import com.liferay.portal.kernel.util.CalendarFactoryUtil;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Time;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.PortletDisplay;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortletKeys;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil;
import com.liferay.portlet.calendar.model.CalEvent;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.model.DLFolderConstants;
import com.liferay.portlet.dynamicdatamapping.model.DDMStructure;
import com.liferay.portlet.dynamicdatamapping.service.DDMStructureLocalServiceUtil;
import com.liferay.portlet.journal.model.JournalArticle;
public class CalUtil {

	public static final String MANAGE_BOOKINGS = "MANAGE_BOOKINGS";
	
	public static Date getEndTime(CalendarBooking calEvent) {
		long startTime = calEvent.getStartTime();

		long endTime = startTime + (Time.HOUR * calEvent.getDuration()) +
				(Time.MINUTE * calEvent.getDuration());

		return new Date(endTime);
	}

	public static boolean isAllDay(CalEvent event, TimeZone timeZone,
			Locale locale) {

		Calendar cal = null;

		if (event.getTimeZoneSensitive()) {
			cal = CalendarFactoryUtil.getCalendar(timeZone, locale);
		} else {
			cal = CalendarFactoryUtil.getCalendar();
		}

		cal.setTime(event.getStartDate());

		int hour = cal.get(Calendar.HOUR_OF_DAY);
		int minute = cal.get(Calendar.MINUTE);
		int second = cal.get(Calendar.SECOND);
		int millisecond = cal.get(Calendar.MILLISECOND);

		int dHour = event.getDurationHour();
		int dMinute = event.getDurationMinute();

		if ((hour == 0) && (minute == 0) && (second == 0) && (millisecond == 0) &&
			(dHour == 24) && (dMinute == 0)) {

			return true;
		}

		return false;
	}

	public static String toString(Calendar cal, String[] types) {

		StringBundler sb = new StringBundler(9);

		if (cal != null) {
			sb.append(cal.get(Calendar.YEAR));
			sb.append(StringPool.PERIOD);
			sb.append(cal.get(Calendar.MONTH));
			sb.append(StringPool.PERIOD);
			sb.append(cal.get(Calendar.DATE));
			sb.append(StringPool.PERIOD);
			sb.append(cal.getTimeZone().getRawOffset());
		}

		if ((types != null) && (types.length > 0) &&
			((types.length > 1) || Validator.isNotNull(types[0]))) {

			sb.append(StringPool.PERIOD);
			sb.append(StringUtil.merge(types, StringPool.PERIOD));
		}

		return sb.toString();
	}
	
	public static PortletURL getURLAdd(
			LiferayPortletRequest liferayPortletRequest,
			LiferayPortletResponse liferayPortletResponse)
		throws PortalException, SystemException, PortletModeException, WindowStateException {

		ThemeDisplay themeDisplay =
			(ThemeDisplay)liferayPortletRequest.getAttribute(
				WebKeys.THEME_DISPLAY);

		CalendarResource calendarResource =
			CalendarResourceUtil.getScopedGroupCalendarResource(
				liferayPortletRequest, themeDisplay.getScopeGroupId());

		if (calendarResource == null) {
			return null;
		}

		com.liferay.calendar.model.Calendar calendar = calendarResource.getDefaultCalendar();

		if (!CalendarPermission.contains(
				themeDisplay.getPermissionChecker(), calendar.getCalendarId(),
				MANAGE_BOOKINGS)) {

			return null;
		}

		PortletURL portletURL = liferayPortletResponse.createRenderURL(
			PortletKeys.CALENDAR);

		portletURL.setParameter("mvcPath", "/edit_calendar_booking.jsp");
		portletURL.setParameter(
			"calendarId", String.valueOf(calendar.getCalendarId()));
		
		
		String referringPortletResource = ParamUtil.getString(
				liferayPortletRequest, "portletResource");

			if (Validator.isNotNull(referringPortletResource)) {
				portletURL.setParameter(
					"referringPortletResource", referringPortletResource);
			}
			else {
				PortletDisplay portletDisplay = themeDisplay.getPortletDisplay();

				portletURL.setParameter(
					"referringPortletResource", portletDisplay.getId());

			}

			portletURL.setPortletMode(PortletMode.VIEW);
			portletURL.setWindowState(LiferayWindowState.POP_UP);
		
		
		return portletURL;
	}
	
}
