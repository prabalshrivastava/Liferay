package com.sambaash.platform.portlet.socialplugin.util;

public class SocialPluginsConstants {

	public static final String ALREADY_LINK_ERROR = "already.registered.error";

	public static final String EMAIL_NOTIFICATION_EMAIL_ADDRESS = "social.sharing.notification.email";

	public static final String EMAIL_NOTIFICATION_ENABLED = "social.sharing.notification.enabled";

	public static final String FACEBOOK_LINK_SUCCESS = "facebook.profile.linking.success.message";

	public static final String FACEBOOK_PAGE_SHARING = "facebook.page.autoshare.enabled";

	public static final String FACEBOOK_SHARING = "facebook.autoshare.enabled";

	public static final String GOOGLE_LINK_SUCCESS = "google.profile.linking.success.message";

	public static final String GOOGLE_SHARING = "google.autoshare.enabled";

	public static final String LINK_ERROR = "link.error";

	public static final String LINK_PROFILE_LABEL = "link.profile";

	public static final String LINKEDIN_LINK_SUCCESS = "linkedin.profile.linking.success.message";

	public static final String LINKEDIN_SHARING = "linkedin.autoshare.enabled";
	//message resource bundle
	public static final String POST_BLOGS = "blogs.message.post";
	public static final String POST_EVENTS = "events.message.post";

	public static final String POST_GALLERY = "gallery.message.post";

	public static final String POST_GROUPS = "groups.message.post";

	public static final String POST_JOBS = "jobs.message.post";

	public static final String POST_PROFILE = "profile.message.post";

	public static final String TWITTER_LINK_SUCCESS = "twitter.profile.linking.success.message";

	public static final String TWITTER_SHARING = "twitter.autoshare.enabled";

	public static final String YAHOO_LINK_SUCCESS = "yahoo.profile.linking.success.message";

	public interface FACEBOOK {
		public static final String POST = "facebook.protected.resource.feed.url";
		public static final String PROFILE = "facebook.protected.resource.profile.url";
		public static final String PERMISSION = "facebook.oauth.permissions";
		public static final String ADMIN_PERMISSION = "facebook.oauth.permissions.admin";
		public static final String POST_PAGE = "facebook.protected.resource.page.feed.url";
	}

	public interface LINKEDIN {
		public static final String POST = "linkedin.post.api.url";
	}

	public interface PROVIDERS {
		public static final String FACEBOOK = "facebook";
		public static final String LINKEDIN = "linkedin";
		public static final String TWITTER = "twitter";
		public static final String YAHOO = "yahoo";
		public static final String GOOGLE = "google";
	}

	public interface TWITTER {
		public static final String POST = "twitter.post.api.url";
	}

}