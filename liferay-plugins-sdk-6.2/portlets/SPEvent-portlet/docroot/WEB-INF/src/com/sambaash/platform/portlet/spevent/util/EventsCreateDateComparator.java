package com.sambaash.platform.portlet.spevent.util;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portlet.calendar.model.CalEvent;

import java.util.Comparator;
import java.util.Date;
public class EventsCreateDateComparator implements Comparator<CalEvent> {

	public int compare(CalEvent o1, CalEvent o2) {

		try {
			Date date1 = o1.getStartDate();
			Date date2 = o2.getStartDate();

			return date1.compareTo(date2);
		} catch (Exception e) {
			logger.error(" Error occured in comparison " + e.getMessage());
		}

		return 0;
	}

	private static Log logger = LogFactoryUtil
			.getLog(EventsCreateDateComparator.class);

}