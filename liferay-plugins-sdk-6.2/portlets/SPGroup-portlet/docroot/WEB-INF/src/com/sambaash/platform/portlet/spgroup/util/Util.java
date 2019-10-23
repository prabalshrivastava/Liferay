package com.sambaash.platform.portlet.spgroup.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import org.apache.commons.io.IOUtils;
import org.htmlparser.Node;
import org.htmlparser.Parser;
import org.htmlparser.filters.AndFilter;
import org.htmlparser.filters.HasAttributeFilter;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.lexer.PageAttribute;
import org.htmlparser.tags.ImageTag;
import org.htmlparser.tags.MetaTag;
import org.htmlparser.tags.TitleTag;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Hours;
import org.joda.time.Minutes;
import org.joda.time.Months;
import org.joda.time.Seconds;
import org.joda.time.Years;

import com.liferay.compat.portal.model.UserConstants;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Base64;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.theme.ThemeDisplay;
import com.sambaash.platform.util.SambaashUtil;

public class Util {

	private static Log _log = LogFactoryUtil.getLog(Util.class);

	public static final String DEFAULT_CHARSET = "UTF-8";
	public static SimpleDateFormat sFormat = new SimpleDateFormat("MMM dd, yyyy");

	public static SimpleDateFormat lFormat = new SimpleDateFormat("MMM dd, yyyy 'at' hh:mm a");

	public static String attachLink(String link, String html, String charset) throws ParserException {

		String title = StringPool.BLANK;
		String description = StringPool.BLANK;

		/**
		 * <title>Yahoo!</title>
		 */
		Parser parser = Parser.createParser(html, StringPool.UTF8);
		TagNameFilter filter = new TagNameFilter("title");
		NodeList nodeList = parser.parse(filter);

		if (nodeList.size() > 0) {
			Node node = nodeList.elementAt(0);
			title = ((TitleTag) node).getStringText();
		}

		/**
		 * <meta name="title" content="Wikipedia" />
		 */
		if (Validator.isNull(title)) {
			AndFilter tFilter = new AndFilter(new TagNameFilter("meta"), new HasAttributeFilter("name", "title"));
			nodeList = parser.parse(tFilter);

			if (nodeList != null && nodeList.size() > 0) {
				Node node = nodeList.elementAt(0);
				title = ((MetaTag) node).getAttribute("content");
			}
		}

		parser = Parser.createParser(html, charset);
		AndFilter tFilter = new AndFilter(new TagNameFilter("meta"), new HasAttributeFilter("name", "description"));
		nodeList = parser.parse(tFilter);

		if (nodeList != null && nodeList.size() > 0) {
			Node node = nodeList.elementAt(0);
			description = ((MetaTag) node).getAttribute("content");
		}

		List<String> imageList = pullImages(html, StringPool.UTF8);

		String content = StringPool.BLANK;
		content = "<div style=\"position: relative;\">";

		if (imageList.size() > 0) {
			content += "<div style=\"position: absolute;\">";

			for (int i = 0; i < imageList.size(); i++) {
				String display = "none";

				if (i == 0) {
					display = "block";
				}

				content += "<img alt=\"Image\" data-comment-dom-id=\"attach-content-image\" style=\"width: 50px; height: 50px; display:"
						+ display + "\" src=\"" + imageList.get(i) + "\">";
			}

			content += "</div><div style=\"margin-left: 60px; min-height: 50px;\">";
		} else {
			content += "<div>";
		}

		content += "<div><span data-comment-dom-id=\"attach-content-title\" class=\"sp-group-fsl\">" + title
				+ "</span></div>"
				+ "<p data-comment-dom-id=\"attach-content-link\" class=\"sp-group-fss sp-group-fcl\"><a href=\""
						+ link + "\">" + link + "</a></p>"
				+ "<p data-comment-dom-id=\"attach-content-description\" class=\"sp-group-mts\">" + description + "</p>"
				+ "</div>" + "</div>";

		return content;
	}

	// public static String pullDescription(String html, String charset) throws
	// ParserException {
	// /**
	// * <meta name="description" content="Wikipedia, the free encyclopedia that
	// anyone can edit." />
	// */
	// String description = StringPool.BLANK;
	// Parser parser = Parser.createParser(html, charset);
	// AndFilter tFilter = new AndFilter(new TagNameFilter("meta"), new
	// HasAttributeFilter("name", "description"));
	// NodeList nodeList = parser.parse(tFilter);
	// if (nodeList != null && nodeList.size() > 0) {
	// Node node = nodeList.elementAt(0);
	// description = ((MetaTag) node).getAttribute("content");
	// }
	// return description;
	// }

	public static String getHtmlByUrl(String urlString) throws IOException {
		StringBuffer html = new StringBuffer();
		URL url = new URL(urlString);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		int status = conn.getResponseCode();
		while (status == HttpURLConnection.HTTP_MOVED_TEMP || status == HttpURLConnection.HTTP_MOVED_PERM
				|| status == HttpURLConnection.HTTP_SEE_OTHER) {
			String newUrl = conn.getHeaderField("Location");
			conn = (HttpURLConnection) new URL(newUrl).openConnection();
			status = conn.getResponseCode();
		}

		InputStreamReader isr = new InputStreamReader(conn.getInputStream());
		BufferedReader br = new BufferedReader(isr);
		String temp;
		while ((temp = br.readLine()) != null) {
			html.append(temp).append("\n");
		}

		br.close();
		isr.close();
		return html.toString();
	}

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

	public static String getLDisplayDate(Date date) {
		return lFormat.format(date);
	}

	public static String getSDisplayDate(Date date) {
		return sFormat.format(date);
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

	public static synchronized String isConnect(String url) {
		URL urlStr;
		HttpURLConnection connection;
		int state = -1;
		String succ;
		int counts = 0;
		succ = null;

		if (url == null || url.length() <= 0) {
			return succ;
		}
		while (counts < 5) {
			try {
				urlStr = new URL(url);
				connection = (HttpURLConnection) urlStr.openConnection();
				state = connection.getResponseCode(); // HTTP/1.0 200 OK

				if (state == 200) {
					succ = connection.getURL().toString();
				}

				break;
			} catch (Exception e) {
				counts++;
				continue;
			}
		}

		return succ;
	}

	@SuppressWarnings("rawtypes")
	public static List<String> pullImages(String html, String charset) throws ParserException {
		/**
		 * <meta content="http://l.yimg.com/dh/ap/default/130215/y_200_a.png"
		 * property="og:image">
		 */

		List<String> imageList = new ArrayList<String>();
		Parser parser = Parser.createParser(html, charset);

		String ogImage = StringPool.BLANK;
		AndFilter tFilter = new AndFilter(new TagNameFilter("meta"), new HasAttributeFilter("property", "og:image"));
		NodeList nodeList = parser.parse(tFilter);

		if (nodeList != null && nodeList.size() > 0) {
			Node node = nodeList.elementAt(0);
			ogImage = ((MetaTag) node).getAttribute("content");
		}

		if (Validator.isNull(ogImage)) {
			parser = Parser.createParser(html, charset);
			TagNameFilter filter = new TagNameFilter("img");
			nodeList = parser.parse(filter);

			if (nodeList != null && nodeList.size() > 0) {
				for (int i = 0; i < nodeList.size(); i++) {
					Node node = nodeList.elementAt(i);
					String image = ((ImageTag) node).getAttribute("src");

					if (isConnect(image) != null) {
						Vector v = ((ImageTag) node).getAttributesEx();
						Iterator ir = v.listIterator();
						int height = 0;
						int width = 0;
						while (ir.hasNext()) {
							PageAttribute pg = (PageAttribute) ir.next();

							if ("width".equalsIgnoreCase(pg.getName())) {
								if (Validator.isNull(pg.getValue())) {
									width = 0;
								} else {
									width = Integer.parseInt(pg.getValue().replaceAll("(\\p{Alpha})", ""));
								}
							} else if ("height".equalsIgnoreCase(pg.getName())) {
								if (Validator.isNull(pg.getValue())) {
									height = 0;
								} else {
									height = Integer.parseInt(pg.getValue().replaceAll("(\\p{Alpha})", ""));
								}
							}

							if (height != 0 && width != 0 && width < 5 && height < 5) {
								break;
							} else if (width > 5 && height > 5) {
								imageList.add(image);
								break;
							}
						}

						imageList.add(image);
					}
				}
			}
		} else {
			imageList.add(ogImage);
		}

		return imageList;
	}

	public static int safeLongToInt(long l) {
		if (l < Integer.MIN_VALUE || l > Integer.MAX_VALUE) {
			throw new IllegalArgumentException(l + " cannot be cast to int without changing its value.");
		}

		return (int) l;
	}

	public static String getUserPortraitUrl(ThemeDisplay themeDisplay) throws PortalException, SystemException {
		return getUserPortraitUrl(themeDisplay, themeDisplay.getUser());
	}

	public static String getUserPortraitUrl(ThemeDisplay themeDisplay, User user)
			throws PortalException, SystemException {
		long portraitID = 0;
		boolean isMale = true;

		if (Validator.isNotNull(user)) {
			portraitID = user.getPortraitId();
			isMale = user.isMale();
		}
		return getUserPortraitUrl(themeDisplay.getPathImage(), isMale, portraitID);
	}

	public static String getUserPortraitUrl(long portraitID) {
		return getUserPortraitUrl(true, portraitID);
	}

	public static String getUserPortraitUrl(boolean isMale, long portraitID) {
		return getUserPortraitUrl("/image", isMale, portraitID);
	}

	public static String getUserPortraitUrl(String imagePath, boolean isMale, long portraitID) {
		return UserConstants.getPortraitURL(imagePath, isMale, portraitID);
	}

	public static String getUserPortraitAsBase64String(long companyId, long groupId, long portraitId) {
		String imageStr = "data:image;base64,";
		try {
			String imageUrl = SambaashUtil.getPortalURL(companyId, groupId) + getUserPortraitUrl(portraitId);
			_log.error(imageUrl);
			URL url = new URL(imageUrl);
			InputStream is = url.openStream();
			byte[] bytes = IOUtils.toByteArray(is);
			imageStr += Base64.encode(bytes);
		} catch (Exception e) {
			_log.error(e);
		}
		return imageStr;
	}
}
