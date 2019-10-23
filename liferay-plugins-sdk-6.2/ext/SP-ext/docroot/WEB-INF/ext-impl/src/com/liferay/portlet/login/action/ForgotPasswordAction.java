/**
q * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.portlet.login.action;

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.liferay.portal.NoSuchUserException;
import com.liferay.portal.RequiredReminderQueryException;
import com.liferay.portal.SendPasswordException;
import com.liferay.portal.UserActiveException;
import com.liferay.portal.UserEmailAddressException;
import com.liferay.portal.UserLockoutException;
import com.liferay.portal.UserReminderQueryException;
import com.liferay.portal.kernel.captcha.CaptchaException;
import com.liferay.portal.kernel.captcha.CaptchaTextException;
import com.liferay.portal.kernel.captcha.CaptchaUtil;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Company;
import com.liferay.portal.model.User;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.struts.PortletAction;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portal.util.PropsValues;
import com.liferay.portal.util.WebKeys;
import com.liferay.portlet.login.util.LoginUtil;
import com.sambaash.platform.srv.mail.model.SPMailTemplate;
import com.sambaash.platform.srv.mail.service.SPMailTemplateServiceUtil;
import com.sambaash.platform.srv.spservices.model.SPSiteSetup;
import com.sambaash.platform.srv.spservices.model.SPUserTypeConfig;
import com.sambaash.platform.srv.spservices.service.SPSiteSetupLocalServiceUtil;
import com.sambaash.platform.srv.spservices.service.SPUserTypeConfigLocalServiceUtil;
import com.sambaash.platform.util.SambaashUtil;

/**
 * @author Brian Wing Shun Chan
 * @author Tibor Kovacs
 */
public class ForgotPasswordAction extends PortletAction {

	private static final Log _log = LogFactoryUtil.getLog(ForgotPasswordAction.class);
	@Override
	public void processAction(
			ActionMapping actionMapping, ActionForm actionForm,
			PortletConfig portletConfig, ActionRequest actionRequest,
			ActionResponse actionResponse)
		throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		Company company = themeDisplay.getCompany();

		if (!company.isSendPassword() && !company.isSendPasswordResetLink()) {
			throw new PrincipalException();
		}

		try {
			if (PropsValues.USERS_REMINDER_QUERIES_ENABLED) {
				checkReminderQueries(actionRequest, actionResponse);
			}
			else {
				// March 22, 2016 Added by Naresh - Reset password is applicable to non-ad users only in case if ldap service is enabled
				User user = getUser(actionRequest);
				if(SambaashUtil.isLdapEnabled()){
					boolean isNonAdUser  = SambaashUtil.isNonAdUser(user);
					_log.debug("SambaashUtil.isNonAdUser() = " + isNonAdUser + " ->for userId " + user.getUserId() + " and screenName " + user.getScreenName()  );
					if(SambaashUtil.isNonAdUser(user)){
						// Pass for external users
					}else{
						// do not allow for internal users
						//SessionErrors.add(actionRequest, "forgot.password.not.applicable.internal.user");
						//return;
						throw new PasswordResetInternalUserException();
					}
				}
				checkCaptcha(actionRequest);
				sendPassword(actionRequest, actionResponse);
			}
		}
		catch (Exception e) {
			if (e instanceof CaptchaTextException ||
				e instanceof UserEmailAddressException ||
				e instanceof PasswordResetInternalUserException) {

				SessionErrors.add(actionRequest, e.getClass());
			}
			else if (e instanceof NoSuchUserException ||
					 e instanceof RequiredReminderQueryException ||
					 e instanceof SendPasswordException ||
					 e instanceof UserActiveException ||
					 e instanceof UserLockoutException ||
					 e instanceof UserReminderQueryException) {

				if (PropsValues.LOGIN_SECURE_FORGOT_PASSWORD) {
					sendRedirect(actionRequest, actionResponse);
				}
				else {
					SessionErrors.add(actionRequest, e.getClass());
				}
			}
			else {
				PortalUtil.sendError(e, actionRequest, actionResponse);
				
			}
		}
	}

	@Override
	public ActionForward render(
			ActionMapping actionMapping, ActionForm actionForm,
			PortletConfig portletConfig, RenderRequest renderRequest,
			RenderResponse renderResponse)
		throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay)renderRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		Company company = themeDisplay.getCompany();

		if (!company.isSendPassword() && !company.isSendPasswordResetLink()) {
			return actionMapping.findForward("portlet.login.login");
		}

		renderResponse.setTitle(themeDisplay.translate("forgot-password"));

		return actionMapping.findForward("portlet.login.forgot_password");
	}

	protected void checkCaptcha(ActionRequest actionRequest)
		throws CaptchaException {

		if (PropsValues.CAPTCHA_CHECK_PORTAL_SEND_PASSWORD) {
			CaptchaUtil.check(actionRequest);
		}
	}

	protected void checkReminderQueries(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		PortletSession portletSession = actionRequest.getPortletSession();

		int step = ParamUtil.getInteger(actionRequest, "step");

		if (step == 1) {
			checkCaptcha(actionRequest);

			portletSession.removeAttribute(
				WebKeys.FORGOT_PASSWORD_REMINDER_ATTEMPTS);
			portletSession.removeAttribute(
				WebKeys.FORGOT_PASSWORD_REMINDER_USER_EMAIL_ADDRESS);
		}

		User user = getUser(actionRequest);

		portletSession.setAttribute(
			WebKeys.FORGOT_PASSWORD_REMINDER_USER_EMAIL_ADDRESS,
			user.getEmailAddress());

		actionRequest.setAttribute(WebKeys.FORGOT_PASSWORD_REMINDER_USER, user);

		if (step == 2) {
			Integer reminderAttempts = (Integer)portletSession.getAttribute(
				WebKeys.FORGOT_PASSWORD_REMINDER_ATTEMPTS);

			if (reminderAttempts == null) {
				reminderAttempts = 0;
			}
			else if (reminderAttempts > 2) {
				checkCaptcha(actionRequest);
			}

			reminderAttempts++;

			portletSession.setAttribute(
				WebKeys.FORGOT_PASSWORD_REMINDER_ATTEMPTS, reminderAttempts);

			sendPassword(actionRequest, actionResponse);
		}
	}

	protected User getUser(ActionRequest actionRequest) throws Exception {
		PortletSession portletSession = actionRequest.getPortletSession();

		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		String sessionEmailAddress = (String)portletSession.getAttribute(
			WebKeys.FORGOT_PASSWORD_REMINDER_USER_EMAIL_ADDRESS);

		User user = null;

		if (Validator.isNotNull(sessionEmailAddress)) {
			user = UserLocalServiceUtil.getUserByEmailAddress(
				themeDisplay.getCompanyId(), sessionEmailAddress);
		}
		else {
			long userId = ParamUtil.getLong(actionRequest, "userId");
			String screenName = ParamUtil.getString(
				actionRequest, "screenName");
			String emailAddress = ParamUtil.getString(
				actionRequest, "emailAddress");

			if (Validator.isNotNull(emailAddress)) {
				user = UserLocalServiceUtil.getUserByEmailAddress(
					themeDisplay.getCompanyId(), emailAddress);
			}
			else if (Validator.isNotNull(screenName)) {
				user = UserLocalServiceUtil.getUserByScreenName(
					themeDisplay.getCompanyId(), screenName);
			}
			else if (userId > 0) {
				user = UserLocalServiceUtil.getUserById(userId);
			}
			else {
				throw new NoSuchUserException();
			}
		}

		if (!user.isActive()) {
			throw new UserActiveException();
		}

		if (user.isLockout()) {
			throw new UserLockoutException();
		}

		return user;
	}

	@Override
	protected boolean isCheckMethodOnProcessAction() {
		return _CHECK_METHOD_ON_PROCESS_ACTION;
	}

	protected void sendPassword(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		HttpServletRequest request = PortalUtil.getHttpServletRequest(actionRequest);
		
		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		Company company = themeDisplay.getCompany();

		User user = getUser(actionRequest);

		if (PropsValues.USERS_REMINDER_QUERIES_ENABLED) {
			if (PropsValues.USERS_REMINDER_QUERIES_REQUIRED &&
				!user.hasReminderQuery()) {

				throw new RequiredReminderQueryException(
					"No reminder query or answer is defined for user " +
						user.getUserId());
			}

			String answer = ParamUtil.getString(actionRequest, "answer");

			if (!user.getReminderQueryAnswer().equals(answer)) {
				throw new UserReminderQueryException();
			}
		}

		PortletPreferences portletPreferences = actionRequest.getPreferences();

		String languageId = LanguageUtil.getLanguageId(actionRequest);

		String emailFromName = portletPreferences.getValue(
			"emailFromName", null);
		String emailFromAddress = portletPreferences.getValue(
			"emailFromAddress", null);
		
		_log.error("emailFromName " + emailFromName);
		_log.error("emailFromAddress " + emailFromAddress);
		
		
		
		
		String emailToAddress = user.getEmailAddress();

		String emailParam = "emailPasswordSent";

		if (company.isSendPasswordResetLink()) {
			emailParam = "emailPasswordReset";
		}

		String subject = portletPreferences.getValue(
			emailParam + "Subject_" + languageId, null);
		String body = portletPreferences.getValue(
			emailParam + "Body_" + languageId, null);
		
		try {

			String userType = "General User";
			long subProductId = SambaashUtil.getSubProductId(request);

			if (_log.isDebugEnabled()) {
				_log.debug("From ServiceContact attribute subProductId " + subProductId);
				_log.debug("From ServiceContact attribute userType " + userType);
			}

			List<SPSiteSetup> spSiteSetupList = SPSiteSetupLocalServiceUtil.findBySubProductId(subProductId);

			for (SPSiteSetup spSiteSetup : SambaashUtil.emptyIfNull(spSiteSetupList)) {
				long virtualHostId = spSiteSetup.getVirtualHostId();
				SPUserTypeConfig spUserTypeConfig = SPUserTypeConfigLocalServiceUtil
						.findByUserTypeAndVirtualHostId(userType, virtualHostId);
				if (spUserTypeConfig != null) {
					SPMailTemplate template = SPMailTemplateServiceUtil.getTemplateByName(spSiteSetup.getProductId(),
							spSiteSetup.getSubProductId(), spUserTypeConfig.getPasswordResetTemplateName());
					if (Validator.isNotNull(template)) {
						if (_log.isDebugEnabled()) {
							_log.error(String.format(" template.getSubject() : %s, templateId %s ",
									template.getSubject(), template.getSpMailTemplateId()));
						}
						
						subject = template.getSubject();
						body = template.getHtmlContent();
						
						emailFromName = SambaashUtil.getEmailFromName(PortalUtil.getDefaultCompanyId(), template);
						emailFromAddress =  SambaashUtil.getEmailFromAddress(PortalUtil.getDefaultCompanyId(), template);
					}
				}

				break;
			}

		} catch (Exception e) {
			if (_log.isDebugEnabled()) {
				_log.debug("Customised Forgot Password template not found, will use default template.");
			}
		}

		LoginUtil.sendPassword(
			actionRequest, emailFromName, emailFromAddress, emailToAddress,
			subject, body);

		sendRedirect(actionRequest, actionResponse);
	}

	private static final boolean _CHECK_METHOD_ON_PROCESS_ACTION = false;

}