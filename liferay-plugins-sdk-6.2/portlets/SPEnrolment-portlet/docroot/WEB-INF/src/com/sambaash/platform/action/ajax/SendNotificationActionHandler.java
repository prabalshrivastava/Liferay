package com.sambaash.platform.action.ajax;

import java.io.IOException;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.apache.commons.lang.StringUtils;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.security.auth.CompanyThreadLocal;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.sambaash.platform.action.ServeResourceActionHandler;
import com.sambaash.platform.security.util.SPAuthenticationUtil;
import com.sambaash.platform.srv.mail.service.SPMailLocalServiceUtil;
import com.sambaash.platform.srv.mail.service.SPMailTemplateLocalServiceUtil;
import com.sambaash.platform.systemmodelsetup.service.SystemLocalServiceUtil;
import com.sambaash.platform.util.SPStringUtils;

public class SendNotificationActionHandler implements ServeResourceActionHandler {
	private Log LOG = LogFactoryUtil.getLog(SendNotificationActionHandler.class.getName());

	@Override
	public void handle(ResourceRequest request, ResourceResponse response) {
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		String output = SystemLocalServiceUtil.sendRequest(request, response);
		try {
			String dataParamStr = request.getParameter("data");
			JSONObject params = JSONFactoryUtil.createJSONObject(dataParamStr);
			
			JSONArray arr = JSONFactoryUtil.createJSONArray(output);
			arr.getJSONObject(0);
			for (int i = 0; i < arr.length(); i++) {
				long candidateId = arr.getJSONObject(i).getLong("CandidateId");
				User user = UserLocalServiceUtil.getUserById(candidateId);
				sendEmail(themeDisplay, user, arr.getJSONObject(i), params);
			}

			response.getWriter().write(output);
		} catch (IOException | PortalException | SystemException e) {
			LOG.error(e);
		}
	}

	private void sendEmail(ThemeDisplay themeDisplay, User user, JSONObject enrolData, JSONObject params) {
		try {
			
			ServiceContext serviceContext = new ServiceContext();
			serviceContext.setScopeGroupId(themeDisplay.getScopeGroupId());

			String fromAddress = PrefsPropsUtil.getString(themeDisplay.getCompanyId(), PropsKeys.ADMIN_EMAIL_FROM_ADDRESS);
			String fromName = PrefsPropsUtil.getString(themeDisplay.getCompanyId(), PropsKeys.ADMIN_EMAIL_FROM_NAME);
			if (StringUtils.isEmpty(fromAddress) || "test@liferay.com".equalsIgnoreCase(fromAddress)) {
				User fromuser = UserLocalServiceUtil.getUserByEmailAddress(CompanyThreadLocal.getCompanyId(),
						"alerts@sambaash.com");
				fromAddress = fromuser.getEmailAddress();
				fromName = fromuser.getFullName();
			}

			String subject = null;
			String body = null;
			com.sambaash.platform.model.MailMessage mailMessage = null;
			String notificationType = params.getString("notificationType");

			String mailTemplateIdParameter = "template.id.enrolment."+notificationType+".notification";

			mailMessage = SPMailTemplateLocalServiceUtil.getMailMessage(mailTemplateIdParameter,
					serviceContext.getScopeGroupId(), true);

			if (mailMessage != null) {
				subject = mailMessage.getSubject();
				body = mailMessage.getHtmlBody();
			} else {
				return;
			}

			String toName = user.getFullName();
			String toAddress = user.getEmailAddress();

			// add other standard tokens
			enrolData.put("NAME", toName);
			enrolData.put("USER_FULL_NAME", toName);
			enrolData.put("TO_FIRST_NAME", user.getFirstName());
			enrolData.put("TO_LAST_NAME", user.getLastName());
			enrolData.put("TO_ADDRESS", toAddress);
			boolean isNewUser = (user.getLoginDate() == null);
			if (!isNewUser && "tempcredential".equals(notificationType)) {
				// tempcredential notification will be available for new users only
				return;
			}
			if (isNewUser) {
				String defaultTempPw = SPAuthenticationUtil.getEnrolmentDefaultTempPassword(themeDisplay);
				// for new user, make sure default temp credential is set and password reset
				// so what temp credential received on email is correct
				user.setPassword(defaultTempPw);
				user.setPasswordEncrypted(false);
				user.setPasswordReset(true);
				enrolData.put("NEW_USER_LOGIN_CREDENTIAL", String.format("Your temporary login password is %s", defaultTempPw));
			} else {
				enrolData.put("NEW_USER_LOGIN_CREDENTIAL","");
			}

			body = SPStringUtils.replaceTokensFromJson(enrolData, body, false);

			mailMessage.setFromAddress(fromAddress);
			mailMessage.setFromName(fromName);
			mailMessage.setToAddress(toAddress);
			mailMessage.setHtmlBody(body);
			mailMessage.setSubject(subject);
			SPMailLocalServiceUtil.sendMail(mailMessage);

		} catch (PortalException | SystemException e) {
			LOG.error("error" + e.toString());
		}

	}

}
