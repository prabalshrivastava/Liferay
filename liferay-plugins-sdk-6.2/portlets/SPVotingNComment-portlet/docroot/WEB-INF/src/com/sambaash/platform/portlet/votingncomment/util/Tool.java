package com.sambaash.platform.portlet.votingncomment.util;

import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Hours;
import org.joda.time.Minutes;
import org.joda.time.Months;
import org.joda.time.Seconds;
import org.joda.time.Years;
public class Tool {

	public static String getTimeDifferent(Date d1, Date d2) {
		String timeDiff = "";

		DateTime dt1 = new DateTime(d1);
		DateTime dt2 = new DateTime(d2);

		Years yearDiff = Years.yearsBetween(dt1, dt2);
		int years = yearDiff.getYears();

		if (years == 0) {
			Months monthDiff = Months.monthsBetween(dt1, dt2);
			int months = monthDiff.getMonths();

			if (months == 0) {
				Days dayDiff = Days.daysBetween(dt1, dt2);
				int days = dayDiff.getDays();

				if (days == 0) {
					Hours hourDiff = Hours.hoursBetween(dt1, dt2);
					int hours = hourDiff.getHours();

					if (hours == 0) {
						Minutes minDiff = Minutes.minutesBetween(dt1, dt2);
						int minutes = minDiff.getMinutes();

						if (minutes == 0) {
							Seconds secDiff = Seconds.secondsBetween(dt1, dt2);
							int seconds = secDiff.getSeconds();

							if (seconds == 0) {
								timeDiff = "0 second ago";
							} else {
								if (seconds == 1) {
									timeDiff = "1 second ago";
								} else {
									timeDiff = seconds + " seconds ago";
								}
							}
						} else {
							if (minutes == 1) {
								timeDiff = "1 minute ago";
							} else {
								timeDiff = minutes + " minutes ago";
							}
						}
					} else {
						if (hours == 1) {
							timeDiff = "1 hour ago";
						} else {
							timeDiff = hours + " hours ago";
						}
					}
				} else {
					if (days == 1) {
						timeDiff = "1 day ago";
					} else {
						timeDiff = days + " days ago";
					}
				}
			} else {
				if (months == 1) {
					timeDiff = "1 month ago";
				} else {
					timeDiff = months + " months ago";
				}
			}
		} else {
			if (years == 1) {
				timeDiff = "1 year ago";
			} else {
				timeDiff = years + " years ago";
			}
		}

		return timeDiff;
	}

}