package com.sambaash.platform.startupprofile;

import java.util.Locale;

import com.liferay.compat.portal.kernel.util.LocaleUtil;
import com.liferay.portal.UserEmailAddressException;
import com.liferay.portal.UserPasswordException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.MethodKey;
import com.liferay.portal.kernel.util.PortalClassInvoker;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.PasswordPolicy;
import com.liferay.portal.model.User;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.service.PasswordPolicyLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.sambaash.platform.security.util.SPAuthenticationUtil;
import com.sambaash.platform.util.SambaashUtil;

public class StartupSignupUtil {
	private static Log LOG = LogFactoryUtil.getLog(StartupSignupUtil.class);
	private static final String _CLASS_NAME = "com.liferay.portal.security.pwd.PwdToolkitUtil";

	public static User getStartupProfileUser(ServiceContext serviceContext,
			long companyId, String emailAddress, String firstName,
			String lastName, ThemeDisplay themeDisplay) throws UserPasswordException, UserEmailAddressException {
		return getStartupProfileUser(serviceContext, companyId, emailAddress,
				firstName, lastName, StringPool.BLANK, StringPool.BLANK, themeDisplay);
	}

	public static User getStartupProfileUser(ServiceContext serviceContext, long companyId, String emailAddress, String firstName,
			String lastName, String password1, String password2, ThemeDisplay themeDisplay) throws UserPasswordException, UserEmailAddressException {
		if (Validator.isNull(emailAddress)) {
			return null;
		}
		User user;
		try {
			user = UserLocalServiceUtil.fetchUserByEmailAddress(companyId, emailAddress);
			if (user == null) {
				user = addStartupUser(serviceContext, companyId, emailAddress, firstName, lastName, null, password1, password2, themeDisplay);
			} else {
				throw new UserEmailAddressException("Email address already in used.");
			}
		} catch (UserPasswordException e) {
			throw e;
		} catch (UserEmailAddressException e) {
			throw e;
		} catch (Exception e) {
			LOG.error(e);
			user = null;
		}
		
		return user;
	}

	public static User addStartupUser(ServiceContext serviceContext,
			long companyId, String emailAddress, String firstName,
			String lastName, String gender, String password1, String password2, ThemeDisplay themeDisplay)
			throws Exception {
		
		String userType = "General User";
		long creatorUserId = 0L;
		boolean autoPassword = false;
		boolean autoScreenName = true;
		String screenName = StringPool.BLANK;
		String openId = StringPool.BLANK;
		Locale locale = LocaleUtil.getDefault();
		String middleName = StringPool.BLANK;
		int prefixId = 0;
		int suffixId = 0;
		boolean male = Validator.isNotNull(gender) ? Validator.equals(gender,
				"male") : true;
		int birthdayMonth = 0;
		int birthdayDay = 1;
		int birthdayYear = 1970;
		String jobTitle = StringPool.BLANK;
		long[] groupIds = new long[] { SPAuthenticationUtil.getSiteGroupId(serviceContext.getLiferayPortletRequest()) };
		long[] organizationIds = null;
		long[] roleIds = null;
		long[] userGroupIds = null;
		boolean sendEmail = true;

		// create a new empty context so that user gets redirected to default
		// page after email address verification
		// pass the portal url and path which is used in constructing the
		// verification url
		ServiceContext serviceContext2 = getSigninServiceContext(serviceContext);
		
		long subProductId = SambaashUtil
				.getSubProductId(PortalUtil.getHttpServletRequest(serviceContext.getLiferayPortletRequest()));

		serviceContext2.setAttribute("userType", userType);
		serviceContext2.setAttribute("subProductId", subProductId);

		LOG.error(String.format("userType %s, subProductId %s", userType, subProductId));

		User user = UserLocalServiceUtil.addUserWithWorkflow(creatorUserId,
				companyId, autoPassword, password1, password2, autoScreenName,
				screenName, emailAddress, -1, openId, locale, firstName,
				middleName, lastName, prefixId, suffixId, male, birthdayMonth,
				birthdayDay, birthdayYear, jobTitle, groupIds, organizationIds,
				roleIds, userGroupIds, sendEmail, serviceContext2);

		user = UserLocalServiceUtil.updateLastLogin(user.getUserId(),
				user.getLoginIP());

		user = UserLocalServiceUtil
				.updatePasswordReset(user.getUserId(), false);

		// user =
		// UserLocalServiceUtil.updateEmailAddressVerified(user.getUserId(),
		// true);
		
		SPAuthenticationUtil.addSiteMembership(serviceContext.getLiferayPortletRequest(), user);
		SPAuthenticationUtil.addOrUpdateSPSiteUser(serviceContext.getLiferayPortletRequest(), user.getUserId(), user.getPassword());
		return user;
	}

	private static ServiceContext getSigninServiceContext(ServiceContext serviceContext) {
		ServiceContext serviceContext2 = new ServiceContext();
		serviceContext2.setPortalURL(serviceContext.getPortalURL());
		serviceContext2.setPathMain(serviceContext.getPathMain());
		try {
			long plid = LayoutLocalServiceUtil.getFriendlyURLLayout(serviceContext.getScopeGroupId(), false, "/signin").getPlid();	
			serviceContext2.setPlid(plid);
		} catch (Exception e) {
			// don't set plid
		}

		return serviceContext2;
	}

	public static PasswordPolicy getPasswordPolicy(ThemeDisplay themeDisplay) {
		PasswordPolicy passwordPolicy = null;
		try {
			passwordPolicy = themeDisplay.getUser().getPasswordPolicy();
			return passwordPolicy;
		} catch (Exception e) {
			LOG.debug("Unable to retrieve user password policy, returning default company password policy.", e);
			try {
				passwordPolicy = PasswordPolicyLocalServiceUtil.getDefaultPasswordPolicy(themeDisplay.getCompanyId());				
			} catch (Exception e2) {
				LOG.debug("Unable to retrieve default company password policy, returning null", e);
			}
		}
		return passwordPolicy;
	}
	
	public static void validatePassword(ThemeDisplay themeDisplay, String password1, String password2) throws Exception {
		validatePassword(themeDisplay.getCompanyId(), themeDisplay.getUserId(), password1, password2, getPasswordPolicy(themeDisplay));
	}
	
	public static void validatePassword(long companyId, long userId, String password1, String password2, PasswordPolicy passwordPolicy) throws Exception {
		ClassLoader portalClassLoader = PortalClassLoaderUtil.getClassLoader();
		Class<?> pwdToolkitUtilClass = portalClassLoader.loadClass(_CLASS_NAME);
		MethodKey _validateMethodKey = new MethodKey(pwdToolkitUtilClass,
				"validate", long.class, long.class, String.class, String.class,
				PasswordPolicy.class);
		PortalClassInvoker.invoke(false, _validateMethodKey, companyId, userId,
				password1, password2, passwordPolicy);
	}
	
}
