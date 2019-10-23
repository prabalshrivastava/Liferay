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

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page import="com.liferay.portal.service.CountryServiceUtil"%>
<%@ page import="com.sambaash.platform.util.SambaashUtil" %>
<%@page import="com.sambaash.platform.util.LabelUtil"%>
<%@ include file="/html/portlet/login/init.jsp" %>

<%
String redirect = ParamUtil.getString(request, "redirect");

String openId = ParamUtil.getString(request, "openId");
boolean male = ParamUtil.getBoolean(request, "male", true);

Calendar birthdayCalendar = CalendarFactoryUtil.getCalendar();

birthdayCalendar.set(Calendar.MONTH, Calendar.JANUARY);
birthdayCalendar.set(Calendar.DATE, 1);
birthdayCalendar.set(Calendar.YEAR, 1970);

// SocialLogin custom code
boolean twitterPendingLogin = false;
if(session.getAttribute("TWITTER_USER_LOGIN_PENDING") !=null) {
	twitterPendingLogin = (Boolean)session.getAttribute("TWITTER_USER_LOGIN_PENDING");
}
String defaultTwitterFirstName = "";
String defaultTwitterLastName  = "";
String defaultTwitterId = "";
String defaultTwitterScreenName = "";
String defaultTwitterPictureUrl = "";

if(twitterPendingLogin) {
	HttpServletRequest originalRequest = PortalUtil.getOriginalServletRequest(request);
	defaultTwitterFirstName= ParamUtil.getString(originalRequest,"firstName");
	defaultTwitterLastName = ParamUtil.getString(originalRequest,"lastName");
	defaultTwitterScreenName = ParamUtil.getString(originalRequest,"screenName");
	defaultTwitterId         = ParamUtil.getString(originalRequest,"twitterId");
	defaultTwitterPictureUrl         = ParamUtil.getString(originalRequest,"pictureUrl");
}	
// End of SocialLogin custom code

List<Country> countrlyList = CountryServiceUtil.getCountries();
String location = ParamUtil.getString(request,"location");
String mobile_number = ParamUtil.getString(request,"mobile_number");

%>

<portlet:actionURL secure="<%= PropsValues.COMPANY_SECURITY_AUTH_REQUIRES_HTTPS || request.isSecure() %>" var="createAccountURL">
	<portlet:param name="struts_action" value="/login/create_account" />
</portlet:actionURL>

<section class="sp-social-login-wrap sp-social-login-create">
	<div class="sp-social-login-content font-none">
		<div class="sp-soclog">
			<div class="sp-social-login-section sp-social-login-section-left inline-block align-top font-std">
				<div class="sl-login-wrap">
					<div class="sl-login-content">
						<div class="user-cont control-label" style="text-align: center;">
							<span >All fields marked with an asterisk <span class="label-required">* </span> are compulsory</span>
						</div>
						<br /><br />

						<aui:form action="<%= createAccountURL %>" method="post" id="fm" name="fm" autocomplete="off">
						<aui:input name="saveLastPath" type="hidden" value="<%= false %>" />
						<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.ADD %>" />
						<aui:input name="redirect" type="hidden" value="<%= redirect %>" />
						<aui:input name="openId" type="hidden" value="<%= openId %>" />
					
						<liferay-ui:error key="invalid-contact-number" message="mobile.number.not.valid"/>
						<liferay-ui:error key="invalid-country" message="country.not.valid"/>
						<liferay-ui:error key="must-agree-terms-of-use" message="accept.terms.of.use"/>
						<liferay-ui:error exception="<%= AddressCityException.class %>" message="please-enter-a-valid-city" />
						<liferay-ui:error exception="<%= AddressStreetException.class %>" message="please-enter-a-valid-street" />
						<liferay-ui:error exception="<%= AddressZipException.class %>" message="please-enter-a-valid-postal-code" />
						<liferay-ui:error exception="<%= CaptchaMaxChallengesException.class %>" message="maximum-number-of-captcha-attempts-exceeded" />
						<liferay-ui:error exception="<%= CaptchaTextException.class %>" message="text-verification-failed" />
						<liferay-ui:error exception="<%= CompanyMaxUsersException.class %>" message="unable-to-create-user-account-because-the-maximum-number-of-users-has-been-reached" />
						<liferay-ui:error exception="<%= ContactFirstNameException.class %>" message="please-enter-a-valid-first-name" />
						<liferay-ui:error exception="<%= ContactFullNameException.class %>" message="please-enter-a-valid-first-middle-and-last-name" />
						<liferay-ui:error exception="<%= ContactLastNameException.class %>" message="please-enter-a-valid-last-name" />
						<liferay-ui:error exception="<%= DuplicateOpenIdException.class %>" message="a-user-with-that-open-id-already-exists" />
						<liferay-ui:error exception="<%= DuplicateUserEmailAddressException.class %>" message="the-email-address-you-requested-is-already-taken" />
						<liferay-ui:error exception="<%= DuplicateUserIdException.class %>" message="the-user-id-you-requested-is-already-taken" />
						<liferay-ui:error exception="<%= DuplicateUserScreenNameException.class %>" message="the-screen-name-you-requested-is-already-taken" />
						<liferay-ui:error exception="<%= EmailAddressException.class %>" message="please-enter-a-valid-email-address" />
					
						<liferay-ui:error exception="<%= GroupFriendlyURLException.class %>">
					
							<%
							GroupFriendlyURLException gfurle = (GroupFriendlyURLException)errorException;
							%>
					
							<c:if test="<%= gfurle.getType() == GroupFriendlyURLException.DUPLICATE %>">
								<liferay-ui:message key="the-screen-name-you-requested-is-associated-with-an-existing-friendly-url" />
							</c:if>
						</liferay-ui:error>
					
						<liferay-ui:error exception="<%= NoSuchCountryException.class %>" message="please-select-a-country" />
						<liferay-ui:error exception="<%= NoSuchListTypeException.class %>" message="please-select-a-type" />
						<liferay-ui:error exception="<%= NoSuchRegionException.class %>" message="please-select-a-region" />
						<liferay-ui:error exception="<%= PhoneNumberException.class %>" message="please-enter-a-valid-phone-number" />
						<liferay-ui:error exception="<%= RequiredFieldException.class %>" message="please-fill-out-all-required-fields" />
						<liferay-ui:error exception="<%= ReservedUserEmailAddressException.class %>" message="the-email-address-you-requested-is-reserved" />
						<liferay-ui:error exception="<%= ReservedUserIdException.class %>" message="the-user-id-you-requested-is-reserved" />
						<liferay-ui:error exception="<%= ReservedUserScreenNameException.class %>" message="the-screen-name-you-requested-is-reserved" />
						<liferay-ui:error exception="<%= TermsOfUseException.class %>" message="you-must-agree-to-the-terms-of-use" />
						<liferay-ui:error exception="<%= UserEmailAddressException.class %>" message="please-enter-a-valid-email-address" />
						<liferay-ui:error exception="<%= UserIdException.class %>" message="please-enter-a-valid-user-id" />
					
						<liferay-ui:error exception="<%= UserPasswordException.class %>">
					
							<%
							UserPasswordException upe = (UserPasswordException)errorException;
							%>
					
							<c:if test="<%= upe.getType() == UserPasswordException.PASSWORD_CONTAINS_TRIVIAL_WORDS %>">
								<liferay-ui:message key="that-password-uses-common-words-please-enter-in-a-password-that-is-harder-to-guess-i-e-contains-a-mix-of-numbers-and-letters" />
							</c:if>
					
							<c:if test="<%= upe.getType() == UserPasswordException.PASSWORD_INVALID %>">
								<liferay-ui:message key="that-password-is-invalid-please-enter-in-a-different-password" />
							</c:if>
					
							<c:if test="<%= upe.getType() == UserPasswordException.PASSWORD_LENGTH %>">
					
								<%
								PasswordPolicy passwordPolicy = PasswordPolicyLocalServiceUtil.getDefaultPasswordPolicy(company.getCompanyId());
								%>
					
								<%= LanguageUtil.format(pageContext, "that-password-is-too-short-or-too-long-please-make-sure-your-password-is-between-x-and-512-characters", String.valueOf(passwordPolicy.getMinLength()), false) %>
							</c:if>
					
							<c:if test="<%= upe.getType() == UserPasswordException.PASSWORD_TOO_TRIVIAL %>">
								<liferay-ui:message key="that-password-is-too-trivial" />
							</c:if>
					
							<c:if test="<%= upe.getType() == UserPasswordException.PASSWORDS_DO_NOT_MATCH %>">
								<liferay-ui:message key="the-passwords-you-entered-do-not-match-each-other-please-re-enter-your-password" />
							</c:if>
						</liferay-ui:error>
					
						<liferay-ui:error exception="<%= UserScreenNameException.class %>" message="please-enter-a-valid-screen-name" />
						<liferay-ui:error exception="<%= WebsiteURLException.class %>" message="please-enter-a-valid-url" />
					
						<c:if test='<%= SessionMessages.contains(request, "openIdUserInformationMissing") %>'>
							<div class="alert alert-info">
								<liferay-ui:message key="you-have-successfully-authenticated-please-provide-the-following-required-information-to-access-the-portal" />
							</div>
						</c:if>
					
						<aui:model-context model="<%= Contact.class %>" />
					
						<aui:fieldset column="<%= true %>">
							
								<%@ include file="/html/portlet/login/create_account_user_name.jspf" %>
					
								<c:if test="<%= !PrefsPropsUtil.getBoolean(company.getCompanyId(), PropsKeys.USERS_SCREEN_NAME_ALWAYS_AUTOGENERATE) %>">
					<%
						//Social Login Custom Code
					%>				
									<c:choose>
										<c:when test="<%= twitterPendingLogin%>">	
											<aui:input model="<%= User.class %>" name="screenName" value="<%=defaultTwitterScreenName %>"/>
										</c:when>
										<c:otherwise>
											<aui:input model="<%= User.class %>" name="screenName" />
										</c:otherwise>
									</c:choose>
					<%
						//End of Social Login Custom Code
					%>
									
								</c:if>
					
								<aui:input model="<%= User.class %>" name="emailAddress">
									<c:if test="<%= PrefsPropsUtil.getBoolean(company.getCompanyId(), PropsKeys.USERS_EMAIL_ADDRESS_REQUIRED) %>">
										<aui:validator name="required" />
									</c:if>
								</aui:input>
							
					
							
								<c:if test="<%= PropsValues.LOGIN_CREATE_ACCOUNT_ALLOW_CUSTOM_PASSWORD %>">
									<aui:input label="password" name="password1" size="30" type="password" value="">
										<aui:validator name="required" />
									</aui:input>
					
									<aui:input label='<%= LabelUtil.getLabel(pageContext, themeDisplay, "enter-password-again") %>' name="password2" size="30" type="password" value="" required="true">
										<aui:validator name="equalTo">
											'#<portlet:namespace />password1'
										</aui:validator>
									</aui:input>
								</c:if>
					
								<c:choose>
									<c:when test="<%= PrefsPropsUtil.getBoolean(company.getCompanyId(), PropsKeys.FIELD_ENABLE_COM_LIFERAY_PORTAL_MODEL_CONTACT_BIRTHDAY) %>">
										<aui:input name="birthday" value="<%= birthdayCalendar %>" />
									</c:when>
									<c:otherwise>
										<aui:input name="birthdayMonth" type="hidden" value="<%= Calendar.JANUARY %>" />
										<aui:input name="birthdayDay" type="hidden" value="1" />
										<aui:input name="birthdayYear" type="hidden" value="1970" />
									</c:otherwise>
								</c:choose>
					
								<c:if test="<%= PrefsPropsUtil.getBoolean(company.getCompanyId(), PropsKeys.FIELD_ENABLE_COM_LIFERAY_PORTAL_MODEL_CONTACT_MALE) %>">
									<aui:select label="gender" name="male">
										<aui:option label="male" value="1" />
										<aui:option label="female" selected="<%= !male %>" value="0" />
									</aui:select>
								</c:if>

								<c:if test="<%=SambaashUtil.LOGIN_CREATE_ACCOUNT_LOCATION  %>">
									<aui:select showEmptyOption="true" label="country"
										name="location" required="true" style="text-transform: capitalize;">
										<%
											for (Country country : countrlyList) {
												
												if(country.getName().equalsIgnoreCase(location)){
												
										%>
										<option value="<%=country.getName()%>" selected="selected"><%=country.getName()%></option>
										<%
												} else {
										%>
													<option value="<%=country.getName()%>"><%=country.getName()%></option>
										<%
													
												}
											}
										%>
									</aui:select>
								</c:if>

								<c:if test="<%=SambaashUtil.LOGIN_CREATE_ACCOUNT_MOBILE_NUMBER  %>">
									<aui:input label="mobile.number" name="mobile_number" value="<%=mobile_number %>" type="number" required="true">
										<aui:validator name="digit" />
									</aui:input>
								</c:if>

								<c:if test="<%= PropsValues.CAPTCHA_CHECK_PORTAL_CREATE_ACCOUNT %>">
									<portlet:resourceURL var="captchaURL">
										<portlet:param name="struts_action" value="/login/captcha" />
									</portlet:resourceURL>
					
									<liferay-ui:captcha url="<%= captchaURL %>" />
								</c:if>
								
								<%
								String agreeToTerms = "I agree to the <a target=\"_blank\" href=\""+themeDisplay.getPathFriendlyURLPublic()+"/"+themeDisplay.getSiteGroupName()
								+"/terms-of-use\">Terms of Use</a> and <a target=\"_blank\" href=\""
								+themeDisplay.getPathFriendlyURLPublic()
								+"/"+themeDisplay.getSiteGroupName()
								+"/privacy-policy\">"+LabelUtil.getLabel(pageContext, themeDisplay, "privacy.policy")+"</a>";
								%>
								
								<c:if test="<%=SambaashUtil.LOGIN_CREATE_ACCOUNT_TERMS_OF_USE  %>">
									<aui:input model="<%= User.class %>" name="agreedToTermsOfUse" label="<%=agreeToTerms %>" required="true">
										<aui:validator name="required" />
									</aui:input>
								</c:if>
							
						</aui:fieldset>
					
						<aui:button-row>
							<aui:button type="submit" value='<%= LabelUtil.getLabel(pageContext, themeDisplay, "create.account.submit")%>' />
						</aui:button-row>
					</aui:form>
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

<%!
private String _getSectionJsp(String name) {
	return TextFormatter.format(name, TextFormatter.N);
}
%>
