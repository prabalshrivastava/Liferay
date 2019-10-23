package com.sambaash.platform.portlet.spneo4j.util;

import java.util.Date;

import org.htmlparser.Node;
import org.htmlparser.Parser;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.tags.ImageTag;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Hours;
import org.joda.time.Minutes;
import org.joda.time.Months;
import org.joda.time.Seconds;
import org.joda.time.Years;
public class Util {

	public static final String DEFAULT_CHARSET = "UTF-8";

	public static String getImageUrlFromHtml(String content) throws ParserException {
		String imageUrl = "";

		Parser parser = Parser.createParser(content, DEFAULT_CHARSET);
		TagNameFilter filter = new TagNameFilter("img");
		NodeList nodeList = parser.parse(filter);
		Node node = null;

		if (nodeList.size() > 0) {
			node = nodeList.elementAt(0);
			imageUrl = ((ImageTag) node).getAttribute("src");
		}

		return imageUrl;
	}

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

	public static int safeLongToInt(long l) {
		if (l < Integer.MIN_VALUE || l > Integer.MAX_VALUE) {
			throw new IllegalArgumentException(l + " cannot be cast to int without changing its value.");
		}

		return (int)l;
	}

}