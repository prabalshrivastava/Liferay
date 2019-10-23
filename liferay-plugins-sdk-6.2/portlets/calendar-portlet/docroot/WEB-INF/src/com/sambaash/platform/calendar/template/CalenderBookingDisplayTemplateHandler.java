package com.sambaash.platform.calendar.template;

import com.liferay.calendar.model.CalendarBooking;
import com.liferay.portal.kernel.portletdisplaytemplate.BasePortletDisplayTemplateHandler;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.template.TemplateVariableGroup;
import com.liferay.portlet.portletdisplaytemplate.util.PortletDisplayTemplateConstants;

import java.util.List;
import java.util.Locale;
import java.util.Map;
public class CalenderBookingDisplayTemplateHandler
		extends BasePortletDisplayTemplateHandler {

	@Override
	public String getClassName() {
		return CalendarBooking.class.getName();
	}

	@Override
	public String getName(Locale locale) {
		return "Events Display Template";
	}

	@Override
	public String getResourceName() {
		return "1_WAR_calendarportlet";
	}

	public Map<String, TemplateVariableGroup> getTemplateVariableGroups(
			long classPK, String language, Locale locale) throws Exception {

		Map<String, TemplateVariableGroup> templateVariableGroups = super
				.getTemplateVariableGroups(classPK, language, locale);

		TemplateVariableGroup templateVariableGroup = templateVariableGroups
				.get("fields");

		templateVariableGroup.empty();

		templateVariableGroup.addCollectionVariable("events", List.class,
				PortletDisplayTemplateConstants.ENTRIES, "evt",
				CalendarBooking.class, "curEvent", "calendarBookingId");

		templateVariableGroup.addVariable("event", CalendarBooking.class,
				"event");

		templateVariableGroup.addVariable("document", Document.class,
				"document");
		
		templateVariableGroup.addVariable("gsfIndex", Integer.class,
				"gsfIndex");

		return templateVariableGroups;
	}

}