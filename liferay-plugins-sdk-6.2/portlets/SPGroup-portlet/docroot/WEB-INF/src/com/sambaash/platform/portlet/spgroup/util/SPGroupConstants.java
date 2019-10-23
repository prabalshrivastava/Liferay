package com.sambaash.platform.portlet.spgroup.util;

public class SPGroupConstants {

	public interface FIELDS {

		public static final String URL_TITLE = "urlTitle";
		public static final String IMAGE_ID = "imageId";

		public static final String COMPANY_ID = "companyId";
		public static final String SCOPE_GROUP_ID = "scopeGroupId";
		public static final String SP_GROUP_ID = "spGroupId";
		public static final String USER_ID = "userId";
		public static final String UPDATE_FREQUENCY = "updateFrequency";

	}
	
	public static final String PORTLET_ID_GROUP_DETAIL = "SPGroupDetail_WAR_SPGroupportlet";
	public static final String URL_LINKS_GROUP_COMMENTS = "https://docs.google.com;https://drive.google.com";
	
	public interface NOTIFICATIONS {
		int NOTIFICATION_TYPE_USER_JOINED = 1;
		int NOTIFICATION_TYPE_USER_COMMENT = 2;
		int NOTIFICATION_TYPE_NEW_DICUSSION = 3;
		int NOTIFICATION_TYPE_APPROVE_JOINER = 4;
		int NOTIFICATION_TYPE_APPROVE_INVITE_REQUEST = 5;
		int NOTIFICATION_TYPE_JOIN_REQUEST_APPROVED = 6;
		int NOTIFICATION_TYPE_JOIN_REQUEST_REJECTED = 7;
		
		String NOTIFICATION_TYPE = "notificationType";
		String USER_NAME = "userName";
		String GROUP_NAME = "groupName";
		String GROUP_URL = "groupUrl";
		String DISC_URL = "discUrl";
		String IGNORE_URL = "ignoreUrl";
		String DISC_NAME = "discName";
		String GROUP_IMAGE = "groupImage";
		String STATUS = "status";
	}
}