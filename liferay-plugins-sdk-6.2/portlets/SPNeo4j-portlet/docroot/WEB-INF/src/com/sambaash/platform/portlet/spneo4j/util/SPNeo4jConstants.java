package com.sambaash.platform.portlet.spneo4j.util;

public interface SPNeo4jConstants {
	
	int NOTIFICATION_TYPE_LIKE = 1;
	int NOTIFICATION_TYPE_COMMENT = 2;

	String NOTIFICATION_TYPE = "notificationType";
	
	String ACTIVITY_FEED_PORTLET_ID = "SPNeo4jActivityFeed_WAR_SPNeo4jportlet";
	
	public interface PARAMS_PAGE_NAME {
		public static final String BLOG = "params.blog.page.name";
		public static final String SPGroup = "params.spgroup.page.name";
		public static final String SPGroup_Discussion = "params.spgroup.discussion.page.name";
		public static final String Event = "params.event.page.name";
		public static final String SPAssetEntry = "params.spassetentry.page.name";
	}
	
	public interface QuerySubFilter {
		public static final String ALL			=	"*";
		public static final String ASSETS		=	"assets";
		public static final String ASSET_TYPES	=	"asset_types";
		public static final String BLOGS		=	"blogs";
		public static final String CHALLENGES	=	"challenges";
		public static final String DISCUSSIONS	=	"discussions";
		public static final String EVENTS		=	"events";
	}
	
}