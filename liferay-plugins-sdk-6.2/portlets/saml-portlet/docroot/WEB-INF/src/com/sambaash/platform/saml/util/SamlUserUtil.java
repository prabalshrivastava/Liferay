package com.sambaash.platform.saml.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.User;

public class SamlUserUtil{

	public static final String SAML_SESSION_ATTRIBUTE_EMAIL = "SAML_USER_EMAIL_ADDRESS";
	
    public static void setLogonInformation(HttpServletRequest request, HttpServletResponse response, User user) {
    	HttpSession session = request.getSession();
    	session.setAttribute(SAML_SESSION_ATTRIBUTE_EMAIL, user.getEmailAddress());
    }

	private final static Log _log = LogFactoryUtil.getLog(SamlUserUtil.class);

}