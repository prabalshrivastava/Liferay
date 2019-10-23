package com.sambaash.platform.portlet.security.action;

import com.liferay.portal.NoSuchUserException;
import com.liferay.portal.UserEmailAddressException;
import com.liferay.portal.UserPasswordException;
import com.liferay.portal.UserReminderQueryException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.MethodKey;
import com.liferay.portal.kernel.util.PortalClassInvoker;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.PasswordPolicy;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.sambaash.platform.exception.UpdateFailedException;
import com.sambaash.platform.portlet.security.exception.UserPasswordNotMatchException;
import com.sambaash.platform.portlet.security.exception.ValidatorPasswordException;
import com.sambaash.platform.portlet.security.exception.WrongTempPasswordException;
import com.sambaash.platform.portlet.security.pwd.PwdEncryptor;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

/**
 * Portlet implementation class SecurityAction
 */
public class SecurityAction extends MVCPortlet {

	public void addPasswordError(ActionRequest actionRequest, UserPasswordException upe) {

		if (upe.getType() == UserPasswordException.PASSWORD_ALREADY_USED) {
			SessionErrors.add(actionRequest, "ErrPasswordAlreadyUsed");
		} else if (upe.getType() == UserPasswordException.PASSWORD_CONTAINS_TRIVIAL_WORDS) {
			SessionErrors.add(actionRequest, "ErrPasswordTrival");
		} else if (upe.getType() == UserPasswordException.PASSWORD_INVALID) {
			SessionErrors.add(actionRequest, "ErrPasswordInvalid");
		} else if (upe.getType() == UserPasswordException.PASSWORD_LENGTH) {
			SessionErrors.add(actionRequest, "ErrPasswordLength");
		} else if (upe.getType() == UserPasswordException.PASSWORD_NOT_CHANGEABLE) {
			SessionErrors.add(actionRequest, "ErrPasswordCantChng");
		} else if (upe.getType() == UserPasswordException.PASSWORD_SAME_AS_CURRENT) {
			SessionMessages.add(actionRequest, "SuccessPasswordChange");
		} else if (upe.getType() == UserPasswordException.PASSWORD_TOO_TRIVIAL) {
			SessionErrors.add(actionRequest, "ErrPasswordTrival");
		} else if (upe.getType() == UserPasswordException.PASSWORD_TOO_YOUNG) {
			SessionErrors.add(actionRequest, "ErrPasswordChngWaitTime");
		} else if (upe.getType() == UserPasswordException.PASSWORDS_DO_NOT_MATCH) {
			SessionErrors.add(actionRequest, "ErrPasswordMatch");
		} else {
			SessionErrors.add(actionRequest, "ErrPasswordUnknown");
		}
	}

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		super.doView(renderRequest, renderResponse);
	}

	@Override
	public void processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, PortletException {

		String formAction = actionRequest.getParameter("formAction");

		try {
			if ("changePassword".equalsIgnoreCase(formAction)) {
				_processChangePasswordRequest(actionRequest, actionResponse);
			} else if ("changePasswordUser".equalsIgnoreCase(formAction)) {
				_processChangePasswordByAdmin(actionRequest, actionResponse);
			} else if ("cancel".equalsIgnoreCase(formAction)) {
			}

		} catch (Exception e) {
			logger.error(" Error occured in password change. " + (logger.isDebugEnabled() ? e : StringPool.BLANK));

			if (e instanceof UserEmailAddressException || e instanceof WrongTempPasswordException || e instanceof ValidatorPasswordException
					|| e instanceof UserPasswordNotMatchException || e instanceof UserReminderQueryException) {
				SessionErrors.add(actionRequest, e.getClass().getName(), e);
			} else if (e instanceof UserPasswordException) {
				logger.error("Password update failed for " + ((UserPasswordException) e).getType());
				addPasswordError(actionRequest, (UserPasswordException)e);
			} else if (e instanceof NoSuchUserException) {
					SessionErrors.add(actionRequest, e.getClass().getName(), e);
			} else if (e instanceof UpdateFailedException) {
				SessionErrors.add(actionRequest, e.getClass().getName(), e.getMessage());
			} else {
				SessionErrors.add(actionRequest, e.getClass().getName(), e);
			}
		}
	}

	public void validatePassword(long companyId, long userId, String password1, String password2, PasswordPolicy passwordPolicy) throws Exception {
		ClassLoader portalClassLoader = PortalClassLoaderUtil.getClassLoader();
		Class<?> pwdToolkitUtilClass = portalClassLoader.loadClass(_CLASS_NAME);
		MethodKey _validateMethodKey = new MethodKey(pwdToolkitUtilClass,
				"validate", long.class, long.class, String.class, String.class,
				PasswordPolicy.class);
		PortalClassInvoker.invoke(false, _validateMethodKey, companyId, userId,
				password1, password2, passwordPolicy);
	}

	private void _processChangePasswordByAdmin(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		String emailAddress = actionRequest.getParameter("emailAddress");
		String password1 = actionRequest.getParameter("userPassword1");
		String password2 = actionRequest.getParameter("userPassword2");

		if (Validator.isNull(emailAddress) || !Validator.isEmailAddress(emailAddress) || "admin@sambaash.com".equalsIgnoreCase(emailAddress)) {
			throw new UserEmailAddressException();
		}

		ThemeDisplay _themeDisplay = (ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

		PasswordPolicy passwordPolicy = _themeDisplay.getUser().getPasswordPolicy();

		validatePassword(_themeDisplay.getCompanyId(), 0, password1, password2, passwordPolicy);

		User user = UserLocalServiceUtil.getUserByEmailAddress(_themeDisplay.getCompanyId(), emailAddress.toLowerCase());

		UserLocalServiceUtil.updatePassword(user.getUserId(), password1, password2, false);

		SessionMessages.add(actionRequest, "SuccessPasswordChange", "");
	}

	private void _processChangePasswordRequest(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		String currentPassword = actionRequest.getParameter("currentPassword");
		String password1 = actionRequest.getParameter("password1");
		String password2 = actionRequest.getParameter("password2");

		ThemeDisplay _themeDisplay = (ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		User user = _themeDisplay.getUser();
		long userId = _themeDisplay.getUserId();

		String encCurrentPassword = PwdEncryptor.encrypt(currentPassword);
		String encUserPwd = user.getPassword();

		if (!encUserPwd.equals(encCurrentPassword)) {
			throw new WrongTempPasswordException();
		}

		PasswordPolicy passwordPolicy = user.getPasswordPolicy();

		validatePassword(_themeDisplay.getCompanyId(), 0, password1, password2, passwordPolicy);

		UserLocalServiceUtil.updatePassword(userId, password1, password2, false);

		SessionMessages.add(actionRequest, "SuccessPasswordChange", "");
	}

	private static final String _CLASS_NAME = "com.liferay.portal.security.pwd.PwdToolkitUtil";

	private static final Log logger = LogFactoryUtil.getLog(SecurityAction.class);

}