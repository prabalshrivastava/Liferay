<%--
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
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="com.liferay.portlet.expando.service.ExpandoValueLocalServiceUtil"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.sambaash.platform.srv.spservices.service.SPParameterLocalServiceUtil"%>
<%@page import="com.sambaash.platform.srv.spservices.model.SPParameter"%>
<%@page import="com.sambaash.platform.util.LabelUtil"%>
<%@page import="javax.servlet.http.HttpSession"%>
<%@page import="com.liferay.portal.kernel.log.Log" %>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil" %>

<%@ include file="/html/portlet/login/init.jsp" %>

<style type="text/css">
.portlet-login .sp-login-callout {
    padding: 0 10px;
}
.sp-login-callout .btn-callout {
    max-width: 195px;
    margin-top: 10px;
}

</style>

<c:choose>
	<c:when test="<%= themeDisplay.isSignedIn() %>">

		<%
		String signedInAs = HtmlUtil.escape(user.getFullName());
		String redirect = ParamUtil.getString(request, "redirect");
		String redirect58 = "";
		if(redirect.isEmpty()){
			redirect58 = ParamUtil.getString(request, "_58_redirect");
			redirect = redirect58;
		}
		if(Validator.isNull(redirect)){
			redirect = PortalUtil.getOriginalServletRequest(request).getParameter("redirect");
		}
		
		if(Validator.isNull(redirect58)){
			redirect = PortalUtil.getOriginalServletRequest(request).getParameter("_58_redirect");
		}
		
		if(Validator.isNotNull(redirect)){
			out.write("<script> window.location.replace('" + redirect + "');</script>");
		}

		if (themeDisplay.isShowMyAccountIcon() && (themeDisplay.getURLMyAccount() != null)) {
			String myAccountURL = String.valueOf(themeDisplay.getURLMyAccount());

			if (PropsValues.DOCKBAR_ADMINISTRATIVE_LINKS_SHOW_IN_POP_UP) {
				signedInAs = "<a class=\"signed-in\" href=\"javascript:Liferay.Util.openWindow({dialog: {destroyOnHide: true}, title: '" + HtmlUtil.escapeJS(LanguageUtil.get(pageContext, "my-account")) + "', uri: '" + HtmlUtil.escapeJS(myAccountURL) + "'});\">" + signedInAs + "</a>";
			}
			else {
				myAccountURL = HttpUtil.setParameter(myAccountURL, "controlPanelCategory", PortletCategoryKeys.MY);

				signedInAs = "<a class=\"signed-in\" href=\"" + HtmlUtil.escape(myAccountURL) + "\">" + signedInAs + "</a>";
			}
		}
		%>

		<%= LanguageUtil.format(pageContext, "you-are-signed-in-as-x", signedInAs, false) %>
	</c:when>
	<c:otherwise>

		<%
		String redirect = ParamUtil.getString(request, "redirect");
		String redirect58 = "";
		if(redirect.isEmpty()){
			redirect58 = ParamUtil.getString(request, "_58_redirect");
			redirect = redirect58;
		}
		if(Validator.isNull(redirect)){
			redirect = PortalUtil.getOriginalServletRequest(request).getParameter("redirect");
		}
		
		if(Validator.isNull(redirect58)){
			redirect = PortalUtil.getOriginalServletRequest(request).getParameter("_58_redirect");
		}
		String login = LoginUtil.getLogin(request, "login", company);
		String password = StringPool.BLANK;
		boolean rememberMe = ParamUtil.getBoolean(request, "rememberMe");

		if (Validator.isNull(authType)) {
			authType = company.getAuthType();
		}
		
//Custom code for SocialLogin Portlet //
		
		
		boolean enableLiferayLogin = true;
		long companyId = company.getCompanyId();
			try {
				
				SPParameter liferaySPParam = SPParameterLocalServiceUtil.findSPParameterOrAdd("login.liferay.enabled", "true", "Liferay Login enabled", "Login",
						themeDisplay.getScopeGroupId());
				
				if(Validator.isNotNull(liferaySPParam) && Validator.isNotNull(liferaySPParam.getValue())) { 
					enableLiferayLogin = Boolean.valueOf(liferaySPParam.getValue());
				}
			
			} catch (Exception ex) {
				_log.error(ex.getMessage());
			}
			

			
//End of Custom code for SocialLogin Portlet//
		
		%>
		
			<portlet:actionURL secure="<%= PropsValues.COMPANY_SECURITY_AUTH_REQUIRES_HTTPS || request.isSecure() %>" var="loginURL">
				<portlet:param name="struts_action" value="/login/login" />
			</portlet:actionURL>
			<section class="sp-social-login-wrap">
				<div class="sp-social-login-content font-none">
					<div class="sp-soclog">
						<div class="sp-social-login-section sp-social-login-section-left inline-block align-top font-std">
							<div class="sl-login-wrap">
							<div class="sl-login-content">
								<c:if test="<%=enableLiferayLogin%>">
									<div class="sl-login-title">
										<span><h1><%= LabelUtil.getLabel(pageContext, themeDisplay, "sign.in")%></h1></span>
									</div>
									<aui:form action="<%= loginURL %>" autocomplete='<%= PropsValues.COMPANY_SECURITY_LOGIN_FORM_AUTOCOMPLETE ? "on" : "off" %>' cssClass="sign-in-form" method="post" name="fm">
										<aui:input name="saveLastPath" type="hidden" value="<%= false %>" />
										<aui:input name="redirect" type="hidden" value="<%= redirect %>" />
										<aui:input name="_58_redirect" type="hidden" value="<%= redirect %>" />
										<aui:input name="doActionAfterLogin" type="hidden" value="<%= portletName.equals(PortletKeys.FAST_LOGIN) ? true : false %>" />
							
										<c:choose>
											<c:when test='<%= SessionMessages.contains(request, "userAdded") %>'>
							
												<%
												String userEmailAddress = (String)SessionMessages.get(request, "userAdded");
												String userPassword = (String)SessionMessages.get(request, "userAddedPassword");
												%>
												
												<div class="alert alert-success">
												<%if((company.isStrangersVerify() || Validator.isNull(userPassword)) && (PrefsPropsUtil.getBoolean(company.getCompanyId(), PropsKeys.ADMIN_EMAIL_USER_ADDED_ENABLED))){ %>
														<%= LanguageUtil.get(pageContext, "thank-you-for-creating-an-account") %>
														<%= LanguageUtil.format(pageContext, "your-email-verification-code-and-password-have-been-sent-to-x", userEmailAddress) %>
												<% }else{ %>
													<c:choose>
														<c:when test="<%= company.isStrangersVerify() || Validator.isNull(userPassword) %>">
															<%= LanguageUtil.get(pageContext, "thank-you-for-creating-an-account") %>
							
															<c:if test="<%= company.isStrangersVerify() %>">
																<%= LanguageUtil.format(pageContext, "your-email-verification-code-has-been-sent-to-x", userEmailAddress) %>
															</c:if>
														</c:when>
														<c:otherwise>
															<%= LanguageUtil.format(pageContext, "thank-you-for-creating-an-account.-your-password-is-x", userPassword, false) %>
														</c:otherwise>
													</c:choose>
							
													<c:if test="<%= PrefsPropsUtil.getBoolean(company.getCompanyId(), PropsKeys.ADMIN_EMAIL_USER_ADDED_ENABLED) %>">
														<%= LanguageUtil.format(pageContext, "your-password-has-been-sent-to-x", userEmailAddress) %>
													</c:if>
												<%} %>	
												</div>
											</c:when>
											<c:when test='<%= SessionMessages.contains(request, "userPending") %>'>
							
												<%
												String userEmailAddress = (String)SessionMessages.get(request, "userPending");
												%>
							
												<div class="alert alert-success">
													<%= LanguageUtil.format(pageContext, "thank-you-for-creating-an-account.-you-will-be-notified-via-email-at-x-when-your-account-has-been-approved", userEmailAddress) %>
												</div>
											</c:when>
										</c:choose>
							
										<liferay-ui:error exception="<%= AuthException.class %>" message="authentication-failed" />
										<liferay-ui:error exception="<%= CompanyMaxUsersException.class %>" message="unable-to-login-because-the-maximum-number-of-users-has-been-reached" />
										<liferay-ui:error exception="<%= CookieNotSupportedException.class %>" message="authentication-failed-please-enable-browser-cookies" />
										<liferay-ui:error exception="<%= NoSuchUserException.class %>" message="authentication-failed" />
										<liferay-ui:error exception="<%= PasswordExpiredException.class %>" message="your-password-has-expired" />
										<liferay-ui:error exception="<%= UserEmailAddressException.class %>" message="authentication-failed" />
										<liferay-ui:error exception="<%= UserLockoutException.class %>" message="this-account-has-been-locked" />
										<liferay-ui:error exception="<%= UserPasswordException.class %>" message="authentication-failed" />
										<liferay-ui:error exception="<%= UserScreenNameException.class %>" message="authentication-failed" />
							
										<aui:fieldset>
							
											<%
											String loginLabel = null;
							
											if (authType.equals(CompanyConstants.AUTH_TYPE_EA)) {
												loginLabel = "email-address";
											}
											else if (authType.equals(CompanyConstants.AUTH_TYPE_SN)) {
												loginLabel = "screen-name";
											}
											else if (authType.equals(CompanyConstants.AUTH_TYPE_ID)) {
												loginLabel = "id";
											}
											%>
							
											<aui:input autoFocus="<%= windowState.equals(LiferayWindowState.EXCLUSIVE) || windowState.equals(WindowState.MAXIMIZED) %>" cssClass="clearable" label="<%= loginLabel %>" name="login" showRequiredLabel="<%= false %>" type="text" value="<%= login %>">
												<aui:validator name="required" />
											</aui:input>
							
											<aui:input name="password" showRequiredLabel="<%= false %>" type="password" value="<%= password %>">
												<aui:validator name="required" />
											</aui:input>
							
											<span id="<portlet:namespace />passwordCapsLockSpan" style="display: none;"><liferay-ui:message key="caps-lock-is-on" /></span>
											<div class="block font-none">
												<div class="remember-me inline-block font-std align-middle text-left half-width">
												
													<c:if test="<%= company.isAutoLogin() && !PropsValues.SESSION_DISABLED %>">
														<aui:input checked="<%= rememberMe %>" name="rememberMe" type="checkbox" />
													</c:if>
												
												</div>
												
												<div class="forgot-password inline-block font-std align-middle text-right half-width">
													<portlet:renderURL var="forgotPasswordURL">
														<portlet:param name="struts_action" value="/login/forgot_password" />
													</portlet:renderURL>
													<a href="<%=forgotPasswordURL%>">Forgot Password</a>
												</div>
											
											
											</div>
											
										</aui:fieldset>
							
										<aui:button-row>
											<aui:button type="submit" value='<%= LabelUtil.getLabel(pageContext, themeDisplay, "sign.in")%>' cssClass="btn-primary"/>
										</aui:button-row>
									</aui:form>
								</c:if>
								</div>
							</div>
							
							<liferay-util:buffer var="navigation">
									<liferay-ui:icon-list>
								
										<%
										for (String section : PropsValues.LOGIN_FORM_NAVIGATION_PRE) {
											if(section.equalsIgnoreCase("forgot-password") || section.equalsIgnoreCase("create-account") || section.equalsIgnoreCase("sign-in")){
												continue;
											}
								
										%>
								
											<liferay-util:include page='<%= "/html/portlet/login/navigation/" + _getSectionJsp(section) + ".jsp" %>' portletId="<%= portletDisplay.getRootPortletId() %>" />
								
										<%
										}
								
										for (String section : PropsValues.LOGIN_FORM_NAVIGATION_POST) {
											if(section.equalsIgnoreCase("forgot-password") || section.equalsIgnoreCase("create-account") || section.equalsIgnoreCase("sign-in")){
												continue;
											}
										%>
								
											<liferay-util:include page='<%= "/html/portlet/login/navigation/" + _getSectionJsp(section) + ".jsp" %>' portletId="<%= portletDisplay.getRootPortletId() %>" />
								
										<%
										}
										%>
								
									</liferay-ui:icon-list>
								</liferay-util:buffer>
								
								<%
								navigation = navigation.trim();
								%>
								
								<c:if test="<%= Validator.isNotNull(navigation) %>">
									<div class="sp-login-callout border-top margin-top-half">
										<span class="sp-login-header hide">Social Login</span>
										<div class="navigation padding-top-half">
											<%= navigation %>
										</div>
									</div>
								</c:if>
						</div>
						<div class="sp-social-login-section sp-social-login-section-right inline-block align-top font-std">
							<liferay-util:include page="/html/portlet/login/navigation.jsp" />
					
						</div>
					</div>
				</div>
			</section>
	
			<aui:script use="aui-base">
				var password = A.one('#<portlet:namespace />password');
	
				if (password) {
					password.on(
						'keypress',
						function(event) {
							Liferay.Util.showCapsLock(event, '<portlet:namespace />passwordCapsLockSpan');
						}
					);
				}
			</aui:script>

<%--
		<c:if test='<%=socialLoginSkin.equals("social_login_skin_2")%>'>
			<%@ include file="/html/portlet/login/loginSocialLoginSkin.jspf" %>
		</c:if>
 		<c:if test='<%=socialLoginSkin.equals("startup_login_skin_1")%>'>
			<%@ include file="/html/portlet/login/loginStartupLoginSkin1.jspf" %>
		</c:if>	 --%>	
<%
//End of Custom code for SocialLogin Portlet//
%>
	</c:otherwise>
</c:choose>
<%!
private String _getSectionJsp(String name) {
	return TextFormatter.format(name, TextFormatter.N);
}
%>

<%!
private static Log _log = LogFactoryUtil.getLog("html.portlet.login.login_jsp");
%> 
