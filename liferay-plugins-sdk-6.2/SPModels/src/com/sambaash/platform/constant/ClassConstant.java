package com.sambaash.platform.constant;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.liferay.portal.service.ClassNameLocalServiceUtil;

public class ClassConstant {
	private static final String SPCHALLENGE = "com.sambaash.platform.srv.spchallenge.model.SPChallenge";
	private static final String CALENDAR = "com.liferay.calendar.model.CalendarBooking";
	private static final String MBMESSAGE = "com.liferay.portlet.messageboards.model.MBMessage";
	private static final String SPASSET_ENTRY = "com.sambaash.platform.srv.spasset.model.SPAssetEntry";
	private static final String BLOG = "com.liferay.portlet.blogs.model.BlogsEntry";
	private static final String SPGROUP = "com.sambaash.platform.srv.spgroup.model.SPGroup";
	
	public static final long SPGROUP_CLASSNAME_ID = ClassNameLocalServiceUtil.getClassNameId(SPGROUP);
	public static final long BLOGS_ENTRY_CLASSNAME_ID = ClassNameLocalServiceUtil.getClassNameId(BLOG);
	public static final long SPASSET_ENTRY_CLASSNAME_ID = ClassNameLocalServiceUtil.getClassNameId(SPASSET_ENTRY);
	public static final long MBMESSAGE_CLASSNAME_ID = ClassNameLocalServiceUtil.getClassNameId(MBMESSAGE);
	public static final long CALENDAR_BOOKING_CLASSNAME_ID = ClassNameLocalServiceUtil.getClassNameId(CALENDAR);
	public static final long SPCHALLENGE_CLASSNAME_ID = ClassNameLocalServiceUtil.getClassNameId(SPCHALLENGE);
	private static final Map<String, Long> FEEDS_CLASSNAME_ID_MAP;
	
	static {
		Map<String, Long> m = new HashMap<String, Long>();
		m.put(SPGROUP, SPGROUP_CLASSNAME_ID);
		m.put(BLOG, BLOGS_ENTRY_CLASSNAME_ID);
		m.put(SPASSET_ENTRY, SPASSET_ENTRY_CLASSNAME_ID);
		m.put(MBMESSAGE, MBMESSAGE_CLASSNAME_ID);
		m.put(CALENDAR, CALENDAR_BOOKING_CLASSNAME_ID);
		m.put(SPCHALLENGE, SPCHALLENGE_CLASSNAME_ID);
		FEEDS_CLASSNAME_ID_MAP  = Collections.unmodifiableMap(m);
	}
	public static final long classNameId(Class<?> clazz) {
		return classNameId(clazz.getName());
	}
	
	public static final long classNameId(String className) {
		return FEEDS_CLASSNAME_ID_MAP.containsKey(className)
				? FEEDS_CLASSNAME_ID_MAP.get(className)
				: ClassNameLocalServiceUtil.getClassNameId(className);
	}
	
	public static final boolean isActivityFeedClass(String className) {
		return FEEDS_CLASSNAME_ID_MAP.containsKey(className);
	}
}
