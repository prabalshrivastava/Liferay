package com.sambaash.platform.sociallogin.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.CalendarFactoryUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Company;
import com.liferay.portal.model.Contact;
import com.liferay.portal.model.User;
import com.liferay.portal.model.UserGroupRole;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portlet.expando.service.ExpandoValueLocalServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public class SocialLoginUtils {
	
	private static Log _log = LogFactoryUtil.getLog(SocialLoginUtils.class);
	
	public static long randLong(long min, long max) {
		return new Random().nextLong() % (max - min) + min;
	}

	public static User addUser(HttpSession session, long companyId, String emailAddress, String firstName,
			String lastName, String gender, String sessionAttribute, String pictureUrl, String profileUrl)
			throws Exception {
		long creatorUserId = 0L;
		boolean autoPassword = true;
		String password1 = StringPool.BLANK;
		String password2 = StringPool.BLANK;
		boolean autoScreenName = true;
		String screenName = StringPool.BLANK;
		String openId = StringPool.BLANK;
		Locale locale = LocaleUtil.getDefault();
		String middleName = StringPool.BLANK;
		int prefixId = 0;
		int suffixId = 0;
		boolean male = Validator.isNotNull(gender) ? Validator.equals(gender, "male") : true;
		int birthdayMonth = 0;
		int birthdayDay = 1;
		int birthdayYear = 1970;
		String jobTitle = StringPool.BLANK;
		long[] groupIds = null;
		long[] organizationIds = null;
		long[] roleIds = null;
		long[] userGroupIds = null;
		boolean sendEmail = false;

		ServiceContext serviceContext = new ServiceContext();

		User user = UserLocalServiceUtil.addUser(creatorUserId, companyId, autoPassword, password1, password2,
				autoScreenName, screenName, emailAddress, 0L, openId, locale, firstName, middleName, lastName, prefixId,
				suffixId, male, birthdayMonth, birthdayDay, birthdayYear, jobTitle, groupIds, organizationIds, roleIds,
				userGroupIds, sendEmail, serviceContext);

	//	user = UserLocalServiceUtil.updateLastLogin(user.getUserId(), user.getLoginIP());

		user = UserLocalServiceUtil.updatePasswordReset(user.getUserId(), false);

		user = UserLocalServiceUtil.updateEmailAddressVerified(user.getUserId(), true);

		if (Validator.isNotNull(pictureUrl)) {
			UserLocalServiceUtil.updatePortrait(user.getUserId(), urlToByte(pictureUrl));
		}

		session.setAttribute(sessionAttribute, emailAddress);

		return user;
	}

	public static User updateUser(User user, String emailAddress, String firstName, String lastName, String gender,
			String pictureUrl, String profileUrl) throws Exception {
		boolean male = Validator.isNotNull(gender)
				? (("male".equalsIgnoreCase(gender) || "m".equalsIgnoreCase(gender)) ? true : false) : true;

		if (user.getPortraitId() < 1 && Validator.isNotNull(pictureUrl)) {
			UserLocalServiceUtil.updatePortrait(user.getUserId(), urlToByte(pictureUrl));
		}

		if ((emailAddress.equals(user.getEmailAddress())) && (firstName.equals(user.getFirstName()))
				&& (lastName.equals(user.getLastName())) && (male == user.isMale())) {
			return user;
		}

		Contact contact = user.getContact();

		Calendar birthdayCal = CalendarFactoryUtil.getCalendar();

		birthdayCal.setTime(contact.getBirthday());

		int birthdayMonth = birthdayCal.get(2);
		int birthdayDay = birthdayCal.get(5);
		int birthdayYear = birthdayCal.get(1);

		long[] groupIds = null;
		long[] organizationIds = null;
		long[] roleIds = null;
		List<UserGroupRole> userGroupRoles = null;
		long[] userGroupIds = null;

		ServiceContext serviceContext = new ServiceContext();

		if (!StringUtil.equalsIgnoreCase(emailAddress, user.getEmailAddress())) {
			UserLocalServiceUtil.updateEmailAddress(user.getUserId(), StringPool.BLANK, emailAddress, emailAddress);
		}

		UserLocalServiceUtil.updateEmailAddressVerified(user.getUserId(), true);
		
		user = UserLocalServiceUtil.updateLastLogin(user.getUserId(), user.getLoginIP());

		return UserLocalServiceUtil.updateUser(user.getUserId(), StringPool.BLANK, StringPool.BLANK, StringPool.BLANK,
				false, user.getReminderQueryQuestion(), user.getReminderQueryAnswer(), user.getScreenName(),
				emailAddress, 0L, user.getOpenId(), user.getLanguageId(), user.getTimeZoneId(), user.getGreeting(),
				user.getComments(), firstName, user.getMiddleName(), lastName, contact.getPrefixId(),
				contact.getSuffixId(), male, birthdayMonth, birthdayDay, birthdayYear, contact.getSmsSn(),
				contact.getAimSn(), contact.getFacebookSn(), contact.getIcqSn(), contact.getJabberSn(),
				contact.getMsnSn(), contact.getMySpaceSn(), contact.getSkypeSn(), contact.getTwitterSn(),
				contact.getYmSn(), contact.getJobTitle(), groupIds, organizationIds, roleIds, userGroupRoles,
				userGroupIds, serviceContext);
	}

	public static String getSkin(long companyId) throws PortalException, SystemException {
		String expandoField = "skin";
		return getExpandoStringValue(companyId, expandoField, "sp_social_login_skin_1");
	}

	public static boolean getEnableLiferayLogin(long companyId) throws PortalException, SystemException {
		String expandoField = "enableLiferayLogin";
		return getExpandoBooleanValue(companyId, expandoField, true);
	}

	public static boolean isLoginEnabled(long companyId, int socialNetwork) throws PortalException, SystemException {
		String expandoField = "";
		if (socialNetwork == 0)
			expandoField = SocialLoginConstants.GOOGLE_LOGIN_ENABLED;
		else if (socialNetwork == 1)
			expandoField = SocialLoginConstants.FACEBOOK_LOGIN_ENABLED;
		else if (socialNetwork == 2)
			expandoField = SocialLoginConstants.TWITTER_LOGIN_ENABLED;
		else if (socialNetwork == 3)
			expandoField = SocialLoginConstants.LINKEDIN_LOGIN_ENABLED;
		else if (socialNetwork == 4) {
			expandoField = SocialLoginConstants.MICROSOFT_LOGIN_ENABLED;
		}
		return getExpandoBooleanValue(companyId, expandoField, false);
	}

	public static String getClientId(long companyId, int socialNetwork) throws PortalException, SystemException {
		String expandoField = "";
		if (socialNetwork == 0)
			expandoField = SocialLoginConstants.GOOGLE_LOGIN_CLIENT_ID;
		else if (socialNetwork == 1)
			expandoField = SocialLoginConstants.FACEBOOK_LOGIN_CLIENT_ID;
		else if (socialNetwork == 2)
			expandoField = SocialLoginConstants.TWITTER_LOGIN_CLIENT_ID;
		else if (socialNetwork == 3)
			expandoField = SocialLoginConstants.LINKEDIN_LOGIN_CLIENT_ID;
		else if (socialNetwork == 4) {
			expandoField = SocialLoginConstants.MICROSOFT_LOGIN_CLIENT_ID;
		}
		return getExpandoStringValue(companyId, expandoField, "");
	}

	public static String getClientSecret(long companyId, int socialNetwork) throws PortalException, SystemException {
		String expandoField = "";
		if (socialNetwork == 0)
			expandoField = SocialLoginConstants.GOOGLE_LOGIN_CLIENT_SECRET;
		else if (socialNetwork == 1)
			expandoField = SocialLoginConstants.FACEBOOK_LOGIN_CLIENT_SECRET;
		else if (socialNetwork == 2)
			expandoField = SocialLoginConstants.TWITTER_LOGIN_CLIENT_SECRET;
		else if (socialNetwork == 3)
			expandoField = SocialLoginConstants.LINKEDIN_LOGIN_CLIENT_SECRET;
		else if (socialNetwork == 4) {
			expandoField = SocialLoginConstants.MICROSOFT_LOGIN_CLIENT_SECRET;
		}
		return getExpandoStringValue(companyId, expandoField, "");
	}

	public static String getGoogleLoginHostedDomain(long companyId) throws PortalException, SystemException {
		String expandoField = SocialLoginConstants.GOOGLE_LOGIN_HOSTED_DOMAIN;

		return getExpandoStringValue(companyId, expandoField, "");
	}

	private static boolean getExpandoBooleanValue(long companyId, String expandoField, boolean defaultValue)
			throws PortalException, SystemException {
		return ExpandoValueLocalServiceUtil.getData(companyId, Company.class.getName(),
				SocialLoginConstants.SOCIALLOGIN_EXPANDO_TABLE, expandoField, companyId, defaultValue);
	}

	private static String getExpandoStringValue(long companyId, String expandoField, String defaultValue)
			throws PortalException, SystemException {
		return ExpandoValueLocalServiceUtil.getData(companyId, Company.class.getName(),
				SocialLoginConstants.SOCIALLOGIN_EXPANDO_TABLE, expandoField, companyId, defaultValue);
	}

	public static byte[] urlToByte(String pictureUrl) throws IOException {
		URL url = new URL(pictureUrl);
		InputStream is = null;
		try {
			is = url.openStream();
			byte[] imageBytes = IOUtils.toByteArray(is);
			return imageBytes;
		} catch (IOException e) {
			_log.error(e.getMessage());
		} finally {
			if (is != null) {
				is.close();
			}
		}
		return null;
	}

}
