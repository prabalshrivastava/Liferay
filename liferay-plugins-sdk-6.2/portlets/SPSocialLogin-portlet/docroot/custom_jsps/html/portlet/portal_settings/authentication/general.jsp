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
<%@page import="com.sambaash.platform.constant.SambaashConstants"%>
<%@page import="com.sambaash.platform.srv.spservices.model.SPListType"%>
<%@page import="com.sambaash.platform.srv.spservices.service.SPListTypeLocalServiceUtil"%>

<%@ include file="/html/portlet/portal_settings/init.jsp" %>

<%
String companySecurityAuthType = company.getAuthType();
boolean companySecurityAutoLogin = company.isAutoLogin();
boolean companySecuritySendPassword = company.isSendPassword();
boolean companySecuritySendPasswordResetLink = company.isSendPasswordResetLink();
boolean companySecurityStrangers = company.isStrangers();
boolean companySecurityStrangersWithMx = company.isStrangersWithMx();
boolean companySecurityStrangersVerify = company.isStrangersVerify();
String spLoginType = PrefsPropsUtil.getString(company.getCompanyId(), SambaashConstants.SP_LOGIN_TYPE, SambaashConstants.SP_DEFAULT_LIFERAY_LOGIN);

List<SPListType> loginTypes = SPListTypeLocalServiceUtil.getByKey(SambaashConstants.SP_LOGIN_TYPE, 0);
%>

<aui:fieldset>
	<aui:select label="how-do-users-authenticate" name='<%= "settings--" + PropsKeys.COMPANY_SECURITY_AUTH_TYPE + "--" %>'>
		<aui:option label="by-email-address" selected="<%= companySecurityAuthType.equals(CompanyConstants.AUTH_TYPE_EA) %>" value="<%= CompanyConstants.AUTH_TYPE_EA %>" />
		<aui:option label="by-screen-name" selected="<%= companySecurityAuthType.equals(CompanyConstants.AUTH_TYPE_SN) %>" value="<%= CompanyConstants.AUTH_TYPE_SN %>" />
		<aui:option label="by-user-id" selected="<%= companySecurityAuthType.equals(CompanyConstants.AUTH_TYPE_ID) %>" value="<%= CompanyConstants.AUTH_TYPE_ID %>" />
	</aui:select>

	<aui:input label="allow-users-to-automatically-login" name='<%= "settings--" + PropsKeys.COMPANY_SECURITY_AUTO_LOGIN + "--" %>' type="checkbox" value="<%= companySecurityAutoLogin %>" />

	<aui:input helpMessage="allow-users-to-request-forgotten-passwords-help" label="allow-users-to-request-forgotten-passwords" name='<%= "settings--" + PropsKeys.COMPANY_SECURITY_SEND_PASSWORD + "--" %>' type="checkbox" value="<%= companySecuritySendPassword %>" />

	<aui:input helpMessage="allow-users-to-request-password-reset-links-help" label="allow-users-to-request-password-reset-links" name='<%= "settings--" + PropsKeys.COMPANY_SECURITY_SEND_PASSWORD_RESET_LINK + "--" %>' type="checkbox" value="<%= companySecuritySendPasswordResetLink %>" />

	<aui:input label="allow-strangers-to-create-accounts" name='<%= "settings--" + PropsKeys.COMPANY_SECURITY_STRANGERS + "--" %>' type="checkbox" value="<%= companySecurityStrangers %>" />

	<aui:input label="allow-strangers-to-create-accounts-with-a-company-email-address" name='<%= "settings--" + PropsKeys.COMPANY_SECURITY_STRANGERS_WITH_MX + "--" %>' type="checkbox" value="<%= companySecurityStrangersWithMx %>" />

	<aui:input label="require-strangers-to-verify-their-email-address" name='<%= "settings--" + PropsKeys.COMPANY_SECURITY_STRANGERS_VERIFY + "--" %>' type="checkbox" value="<%= companySecurityStrangersVerify %>" />

	<aui:select label="what-is-sp-login-type" name='<%= "settings--" + SambaashConstants.SP_LOGIN_TYPE + "--" %>'>
	<% 
	for(SPListType loginType: loginTypes)
	{
	%>
		<aui:option value="<%= loginType.getItemValue() %>"
			selected="<%= loginType.getItemValue().equalsIgnoreCase(spLoginType) %>"
			label="<%= loginType.getDisplayName() %>" />					
	<% 
	}
	%>
	</aui:select>

</aui:fieldset>