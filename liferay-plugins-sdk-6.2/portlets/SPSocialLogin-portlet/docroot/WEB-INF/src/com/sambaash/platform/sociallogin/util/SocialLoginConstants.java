package com.sambaash.platform.sociallogin.util;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.scribe.model.Token;

@SuppressWarnings("serial")
public class SocialLoginConstants {

	public static final Token EMPTY_TOKEN = null;
	public static final int GOOGLE = 0;
	public static final int FACEBOOK = 1;
	public static final int TWITTER = 2;
	public static final int LINKEDIN = 3;
	public static final int MICROSOFT = 4;

	public static final String SOCIALLOGIN_SKIN_TYPE_1 = "social_login_skin_1";
	public static final String SOCIALLOGIN_SKIN_TYPE_2 = "social_login_skin_2";
	public static final String STARTUPLOGIN_SKIN_TYPE_1 = "startup_login_skin_1";

	public static final List<String> SOCIALLOGIN_SKIN_TYPES = new LinkedList<String>() {
		{
			add(SOCIALLOGIN_SKIN_TYPE_1);
			add(SOCIALLOGIN_SKIN_TYPE_2);
			add(STARTUPLOGIN_SKIN_TYPE_1);
		}
	};
	public static final String GOOGLE_REDIRECT_URI = "/c/portal/google_social_login?cmd=token";
	public static final String GOOGLE_RESOURCE_URL = "https://www.googleapis.com/userinfo/v2/me";
	public static final String GOOGLE_SCOPES_LOGIN_EMAIL = "https://www.googleapis.com/auth/userinfo.email";
	public static final String GOOGLE_SCOPES_LOGIN_PROFILE = "https://www.googleapis.com/auth/userinfo.profile";
	public static final String GOOGLE_SESSION_ATTRIBUTE_EMAIL = "GOOGLE_USER_EMAIL_ADDRESS";
	public static final String GOOGLE_FIELD_EMAIL = "email";
	public static final String GOOGLE_FIELD_FIRSTNAME = "given_name";
	public static final String GOOGLE_FIELD_LASTNAME = "family_name";
	public static final String GOOGLE_FIELD_GENDER = "gender";
	public static final String GOOGLE_FIELD_PICTURE = "picture";

	public static final String FACEBOOK_REDIRECT_URI = "/c/portal/facebook_social_login?cmd=token";
	public static final String FACEBOOK_RESOURCE_URL = "https://graph.facebook.com/me?fields=id,picture.width(9999),name,first_name,middle_name,last_name,gender,link,birthday,email,location";
	public static final String FACEBOOK_FIELD_EMAIL = "email";
	public static final String FACEBOOK_FIELD_FIRSTNAME = "first_name";
	public static final String FACEBOOK_FIELD_LASTNAME = "last_name";
	public static final String FACEBOOK_FIELD_PICTURE = "picture";
	public static final String FACEBOOK_SESSION_ATTRIBUTE_EMAIL = "FACEBOOK_USER_EMAIL_ADDRESS";

	public static final String TWITTER_REDIRECT_URI = "/c/portal/twitter_social_login?cmd=token";
	public static final String TWITTER_RESOURCE_URL = "https://api.twitter.com/1.1/account/verify_credentials.json";
	public static final String TWITTER_FIELD_EMAIL = "email";
	public static final String TWITTER_FIELD_FIRSTNAME = "first_name";
	public static final String TWITTER_FIELD_LASTNAME = "last_name";
	public static final String TWITTER_FIELD_GENDER = "gender";
	public static final String TWITTER_FIELD_SCREENNAME = "screen_name";
	public static final String TWITTER_FIELD_TWITTERID = "id_str";
	public static final String TWITTER_SESSION_ATTRIBUTE_EMAIL = "TWITTER_USER_EMAIL_ADDRESS";
	public static final String TWITTER_SESSION_ATTRIBUTE_ID = "TWITTER_USER_ID";
	public static final String TWITTER_SESSION_LOGINPENDING = "TWITTER_USER_LOGIN_PENDING";
	public static final String TWITTER_FIELD_PICTURE = "profile_image_url_https";
	public static final String TWITTER_FIELD_PICTURE_URL = "pictureUrl";
	public static final String TWITTERID = "twitterId";

	public static final String LINKEDIN_REDIRECT_URI = "/c/portal/linkedin_social_login?cmd=token";
	public static final String LINKEDIN_RESOURCE_URL1 = "http://api.linkedin.com/v1/people/~:(id,first-name,last-name,picture-url,location,summary,specialties,positions,public-profile-url,picture-urls::(original))";
	public static final String LINKEDIN_RESOURCE_URL2 = "http://api.linkedin.com/v1/people/~/email-address";
	public static final String LINKEDIN_SCOPES_LOGIN = "r_basicprofile r_emailaddress";
	public static final String LINKEDIN_FIELD_EMAIL = "email-address";
	public static final String LINKEDIN_FIELD_FIRSTNAME = "firstName";
	public static final String LINKEDIN_FIELD_LASTNAME = "lastName";
	public static final String LINKEDIN_FIELD_PICTURE = "picture-url";
	public static final String LINKEDIN_FIELD_PROFILE_URL = "publicProfileUrl";
	public static final String LINKEDIN_SESSION_ATTRIBUTE_EMAIL = "LINKEDIN_USER_EMAIL_ADDRESS";

	public static final String MICROSOFT_REDIRECT_URI = "/c/portal/microsoft_social_login_token";
	public static final String MICROSOFT_RESOURCE_URL = "https://apis.live.net/v5.0/me";
	public static final String MICROSOFT_SCOPES_LOGIN_EMAIL = "wl.emails";
	public static final String MICROSOFT_SCOPES_LOGIN_PROFILE = "wl.basic";
	public static final String MICROSOFT_SESSION_ATTRIBUTE_EMAIL = "MICROSOFT_USER_EMAIL_ADDRESS";
	public static final String MICROSOFT_FIELD_EMAIL = "emails";
	public static final String MICROSOFT_FIELD_EMAIL_ACCOUNT = "account";
	public static final String MICROSOFT_FIELD_FIRSTNAME = "first_name";
	public static final String MICROSOFT_FIELD_LASTNAME = "last_name";
	public static final String MICROSOFT_FIELD_GENDER = "gender";

	public static final String SOCIALLOGIN_EXPANDO_TABLE = "SP_SOCIAL_LOGIN";
	public static final String SOCIALLOGIN_SKIN = "skin";
	public static final String SOCIALLOGIN_SKIN_ENABLE_LIFERAY_LOGIN = "enableLiferayLogin";

	public static final String GOOGLE_LOGIN_ENABLED = "googleLoginEnabled";
	public static final String GOOGLE_LOGIN_CLIENT_ID = "googleLoginClientId";
	public static final String GOOGLE_LOGIN_CLIENT_SECRET = "googleLoginClientSecret";
	public static final String GOOGLE_LOGIN_HOSTED_DOMAIN = "googleLoginHostedDomain";

	public static final String FACEBOOK_LOGIN_ENABLED = "facebookLoginEnabled";
	public static final String FACEBOOK_LOGIN_CLIENT_ID = "facebookLoginClientId";
	public static final String FACEBOOK_LOGIN_CLIENT_SECRET = "facebookLoginClientSecret";

	public static final String TWITTER_LOGIN_ENABLED = "twitterLoginEnabled";
	public static final String TWITTER_LOGIN_CLIENT_ID = "twitterLoginClientId";
	public static final String TWITTER_LOGIN_CLIENT_SECRET = "twitterLoginClientSecret";

	public static final String LINKEDIN_LOGIN_ENABLED = "linkedinLoginEnabled";
	public static final String LINKEDIN_LOGIN_CLIENT_ID = "linkedinLoginClientId";
	public static final String LINKEDIN_LOGIN_CLIENT_SECRET = "linkedinLoginClientSecret";

	public static final String MICROSOFT_LOGIN_ENABLED = "microsoftLoginEnabled";
	public static final String MICROSOFT_LOGIN_CLIENT_ID = "microsoftLoginClientId";
	public static final String MICROSOFT_LOGIN_CLIENT_SECRET = "microsoftLoginClientSecret";

	public static final String TWITTER_USER_ID = "socialLoginTwitterId";

	public static final Map<String, Integer> mapGeneralFields = new LinkedHashMap<String, Integer>() {
		{

			put(SOCIALLOGIN_SKIN_ENABLE_LIFERAY_LOGIN, 1);
			put(GOOGLE_LOGIN_ENABLED, 1);
			put(FACEBOOK_LOGIN_ENABLED, 1);
			put(TWITTER_LOGIN_ENABLED, 1);
			put(LINKEDIN_LOGIN_ENABLED, 1);
			put(MICROSOFT_LOGIN_ENABLED, 1);

			put(SOCIALLOGIN_SKIN, 15);
			put(GOOGLE_LOGIN_CLIENT_ID, 15);
			put(GOOGLE_LOGIN_CLIENT_SECRET, 15);
			put(GOOGLE_LOGIN_HOSTED_DOMAIN, 15);
			put(FACEBOOK_LOGIN_CLIENT_ID, 15);
			put(FACEBOOK_LOGIN_CLIENT_SECRET, 15);
			put(TWITTER_LOGIN_CLIENT_ID, 15);
			put(TWITTER_LOGIN_CLIENT_SECRET, 15);
			put(LINKEDIN_LOGIN_CLIENT_ID, 15);
			put(LINKEDIN_LOGIN_CLIENT_SECRET, 15);
			put(MICROSOFT_LOGIN_CLIENT_ID, 15);
			put(MICROSOFT_LOGIN_CLIENT_SECRET, 15);

		}
	};

	public static final Map<String, Integer> mapGoogleFields = new LinkedHashMap<String, Integer>() {
		{
			put(GOOGLE_FIELD_EMAIL, 15);
			put(GOOGLE_FIELD_FIRSTNAME, 15);
			put(GOOGLE_FIELD_LASTNAME, 15);
			put(GOOGLE_FIELD_GENDER, 15);

		}
	};

	public static final Map<String, Integer> mapFacebookFields = new LinkedHashMap<String, Integer>() {
		{
			put(FACEBOOK_FIELD_EMAIL, 15);
			put(FACEBOOK_FIELD_FIRSTNAME, 15);
			put(FACEBOOK_FIELD_LASTNAME, 15);

		}
	};

	public static final Map<String, Integer> mapTwitterFields = new LinkedHashMap<String, Integer>() {
		{
			put(TWITTER_FIELD_TWITTERID, 15);
			put(TWITTER_FIELD_SCREENNAME, 15);
			put(TWITTER_FIELD_EMAIL, 15);
			put(TWITTER_FIELD_FIRSTNAME, 15);
			put(TWITTER_FIELD_LASTNAME, 15);
			put(TWITTER_FIELD_GENDER, 15);
			put(TWITTER_USER_ID, 15);
		}
	};

	public static final Map<String, Integer> mapLinkedinFields = new LinkedHashMap<String, Integer>() {
		{
			put(LINKEDIN_FIELD_EMAIL, 15);
			put(LINKEDIN_FIELD_FIRSTNAME, 15);
			put(LINKEDIN_FIELD_LASTNAME, 15);

		}
	};

	public static final Map<String, Integer> mapMicrosoftFields = new LinkedHashMap<String, Integer>() {
		{
			put(MICROSOFT_FIELD_EMAIL, 15);
			put(MICROSOFT_FIELD_EMAIL_ACCOUNT, 15);
			put(MICROSOFT_FIELD_FIRSTNAME, 15);
			put(MICROSOFT_FIELD_LASTNAME, 15);
			put(MICROSOFT_FIELD_GENDER, 15);
		}
	};

	public static final String ERROR_CLIENT_ID_SECRET_KEY = "Error. ClientId/ClientSecret not configured properly";

}