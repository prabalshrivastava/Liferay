/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
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

package com.liferay.portal.action;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.liferay.portal.NoSuchTicketException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CompanyConstants;
import com.liferay.portal.model.PasswordPolicy;
import com.liferay.portal.model.Ticket;
import com.liferay.portal.model.User;
import com.liferay.portal.security.auth.AuthTokenUtil;
import com.liferay.portal.security.pwd.PwdToolkitUtil;
import com.liferay.portal.service.PasswordPolicyLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.TicketLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.struts.ActionConstants;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portal.util.PortletKeys;
import com.liferay.portal.util.WebKeys;
import com.liferay.portlet.PortletURLImpl;
import com.liferay.portlet.login.util.LoginUtil;
import com.sambaash.platform.util.SambaashUtil;

/**
 * @author Mika Koivisto
 */
public class VerifyEmailAddressAction extends Action {

	@Override
	public ActionForward execute(
			ActionMapping actionMapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response)
		throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(
			WebKeys.THEME_DISPLAY);

		String cmd = ParamUtil.getString(request, Constants.CMD);

		if (Validator.isNull(cmd)) {
			return actionMapping.findForward("portal.verify_email_address");
		}

		if (themeDisplay.isSignedIn() && cmd.equals(Constants.SEND)) {
			sendEmailAddressVerification(request, response, themeDisplay);

			return actionMapping.findForward("portal.verify_email_address");
		}

		// March 23 Naresh - customized logic for file sharing. This value modulename set in ShareFileAndFolderAction.java in activationUrl.
		// verify_email_address.jsp just responsible for sending params in activationUrl to here.
		String moduleName= ParamUtil.getString(request, "modulename");
		if("esnSharing".equalsIgnoreCase(moduleName)){
			// customized logic
			String redirectUrl  =  ParamUtil.getString(request, "destinationUrl");
			try{
				String ticketKey = ParamUtil.getString(request, "ticketKey");
				Ticket ticket = TicketLocalServiceUtil.getTicket(ticketKey);
				String emailAddress = ticket.getExtraInfo();
				User user = UserLocalServiceUtil.getUserByEmailAddress(themeDisplay.getCompanyId(), emailAddress);
				
				if(!user.isEmailAddressVerified()){
					 verifyEmailAddress(request, response, themeDisplay);
				 }else{
					if (!user.isPasswordReset()) {
						String signinUrl = SambaashUtil.getSignInUrlFromSPParamDefaultGrp(themeDisplay);
						if (Validator.isNotNull(redirectUrl)) {
							signinUrl = HttpUtil.addParameter(signinUrl, "redirect", redirectUrl);
						}
						response.sendRedirect(signinUrl);
						return null;
					}
				 }
				
				// Let the user logged in
				PasswordPolicy passwordPolicy = PasswordPolicyLocalServiceUtil.getDefaultPasswordPolicy(themeDisplay
						.getCompanyId());
				String password = PwdToolkitUtil.generate(passwordPolicy);
				UserLocalServiceUtil.updatePassword(user.getUserId(), user.getPassword(), password, true,true);
				LoginUtil.login(request, response, user.getScreenName(), user.getPassword(), false, CompanyConstants.AUTH_TYPE_SN);
				
				// Getting signin pag using spparam. signin page contains login portlet which can handle redirect parameter  also when ntlm is enabled
				// users in application who are outside ldap domain will face with issue using default url /c/portal/login ( ntlm login ). To overcome this
				// getting signin page url.
				String signinUrl = SambaashUtil.getSignInUrlFromSPParamDefaultGrp(themeDisplay);
				signinUrl = HttpUtil.addParameter(signinUrl, "firstTimeLogin", true);
				if(Validator.isNotNull(redirectUrl)){
					signinUrl = HttpUtil.addParameter(signinUrl, "redirect", redirectUrl);
					signinUrl = HttpUtil.addParameter(signinUrl, "ticketKey", ticketKey);
				}
				response.sendRedirect(signinUrl);
				return null;
				
			}catch(NoSuchTicketException ex){
				String signinUrl = SambaashUtil.getSignInUrlFromSPParamDefaultGrp(themeDisplay);
				//String redirectUrl =  ParamUtil.getString(request, "destinationUrl");
			/*	if(Validator.isNotNull(redirectUrl)){
					signinUrl = HttpUtil.addParameter(signinUrl, "redirect", redirectUrl);
				}
				if("esnSharing".equalsIgnoreCase(moduleName) && Validator.isNotNull(user)){
					LoginUtil.login(request, response, user.getScreenName(), user.getPassword(), false, CompanyConstants.AUTH_TYPE_SN);
					signinUrl = HttpUtil.addParameter(signinUrl, "firstTimeLogin", true);
				}*/
				response.sendRedirect(signinUrl);
				return null;
			}
			catch(Exception ex){
				return null;
			}
			
		}else{
			// Existing logic from liferay
				try {
					verifyEmailAddress(request, response, themeDisplay);
					
					if (!themeDisplay.isSignedIn()) {
						PortletURL portletURL = new PortletURLImpl(
								request, PortletKeys.LOGIN, themeDisplay.getPlid(),
								PortletRequest.RENDER_PHASE);
						
						response.sendRedirect(portletURL.toString());
						
						return null;
					}
					else {
						return actionMapping.findForward(
								ActionConstants.COMMON_REFERER_JSP);
					}
				}
				catch (Exception e) {
					if (e instanceof PortalException || e instanceof SystemException) {
						SessionErrors.add(request, e.getClass());
						
						return actionMapping.findForward("portal.verify_email_address");
					}
					
					PortalUtil.sendError(e, request, response);
					
					return null;
				}
			
		}
	}

	protected void sendEmailAddressVerification(
			HttpServletRequest request, HttpServletResponse response,
			ThemeDisplay themeDisplay)
		throws Exception {

		User user = themeDisplay.getUser();

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
			request);

		UserLocalServiceUtil.sendEmailAddressVerification(
			user, user.getEmailAddress(), serviceContext);
	}

	protected void verifyEmailAddress(
			HttpServletRequest request, HttpServletResponse response,
			ThemeDisplay themeDisplay)
		throws Exception {

		AuthTokenUtil.checkCSRFToken(
			request, VerifyEmailAddressAction.class.getName());

		String ticketKey = ParamUtil.getString(request, "ticketKey");

		UserLocalServiceUtil.verifyEmailAddress(ticketKey);
	}

}