package com.sambaash.platform.portlet.spblogs.notification;

public interface SPBlogsNotificationConstants {
	
	static public final String PORTLET_ID = "SPBlogs_WAR_SPBlogsportlet";

	static public final int NOTIFICATION_TYPE_BLOG_CREATED = 1;
	static public final int NOTIFICATION_TYPE_BLOG_MODIFIED = 2;
	static public final int NOTIFICATION_TYPE_BLOG_DELETED = 3;
	
	static public final String NOTIFICATION_TYPE = "notificationType";

	String LINK = "friendlyUrl";
	String TITLE = "title";
	String USER_NAME = "userName";

}
