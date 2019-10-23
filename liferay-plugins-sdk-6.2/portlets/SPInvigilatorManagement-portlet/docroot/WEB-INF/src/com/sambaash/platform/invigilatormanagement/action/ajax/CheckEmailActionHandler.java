package com.sambaash.platform.invigilatormanagement.action.ajax;

import java.io.IOException;
import java.util.UUID;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.security.auth.CompanyThreadLocal;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.service.UserServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.sambaash.platform.action.ServeResourceActionHandler;
import com.sambaash.platform.invigilatormanagement.service.InvigilatorLocalServiceUtil;
import com.sambaash.platform.srv.spservices.service.SPParameterLocalServiceUtil;

public class CheckEmailActionHandler implements ServeResourceActionHandler {

	private Log log = LogFactoryUtil.getLog(CheckEmailActionHandler.class.getName());
	private static final String INVIGILATOR_LOGIN_DETAILS_MAIL_TEMPLATE = "invigilator.login.details.mail.template";

	@Override
	public void handle(ResourceRequest request, ResourceResponse response) {
		String emailAddress = request.getParameter("emailId");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		JSONObject responseJson = JSONFactoryUtil.createJSONObject();
		Long companyId = CompanyThreadLocal.getCompanyId();
		try {
			User user = UserLocalServiceUtil.fetchUserByEmailAddress(companyId, emailAddress);
			ServiceContext serviceContext = ServiceContextFactory.getInstance(CheckEmailActionHandler.class.getName(), request);;
			String password = UUID.randomUUID().toString();
			if (user == null) {
				user = UserServiceUtil.addUser(companyId, false, // auto
				        password, password, true, // auto
				        StringPool.BLANK, // screen name
				        emailAddress, new Long(0), // facebookId
				        StringPool.BLANK, // open id
				        LocaleUtil.getDefault(), firstName, StringPool.BLANK, lastName, // middle
				        0, // prefix id
				        0, // suffix id
				        true, 1, 1, 1970, // birthdate
				        StringPool.BLANK, // job title
				        null, // group ids
				        null, // organization ids
				        null, // role ids
				        null, // usegroup ids
				        false, // send email
				        serviceContext);
				user.setStatus(0);
				user.setEmailAddressVerified(true);
				user.setPassword(password);
				user.setPasswordEncrypted(false);
				user.setPasswordReset(true);
				UserLocalServiceUtil.updateUser(user);
				responseJson.put("userId", user.getUserId());
				responseJson.put("status", "New Email");
				ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
				InvigilatorLocalServiceUtil.sendNewUserLoginDetailsEmail(user,
				        SPParameterLocalServiceUtil.findBySPParameterGroupIdAndName(themeDisplay.getScopeGroupId(),
				                INVIGILATOR_LOGIN_DETAILS_MAIL_TEMPLATE).getValue());
			} else {
				responseJson.put("userId", user.getUserId());
				responseJson.put("status", "Email Exists");
			}
			response.getWriter().write(responseJson.toString());
		} catch (SystemException | IOException | PortalException e) {
			log.error(e);
		}
	}

}
