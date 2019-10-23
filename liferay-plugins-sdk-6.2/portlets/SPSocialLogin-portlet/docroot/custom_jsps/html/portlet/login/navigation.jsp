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
<%@page import="com.liferay.portlet.expando.service.ExpandoValueLocalServiceUtil"%>
<%@page import="com.sambaash.platform.srv.spservices.service.SPParameterLocalServiceUtil"%>
<%@page import="com.sambaash.platform.srv.spservices.model.SPParameter"%>
<%@page import="com.sambaash.platform.util.SambaashUtil"%>
<%@page import="com.sambaash.platform.util.LabelUtil"%>
<%@page import="com.liferay.portal.kernel.log.Log" %>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil" %>
<%@page import="com.wtberks.configuration.service.ConfigurationPropertyLocalServiceUtil"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/html/portlet/login/init.jsp" %>

<%
String strutsAction = ParamUtil.getString(request, "struts_action");

boolean showCreateAccountIcon = false;
boolean showSignInIcon = false;
long companyId = company.getCompanyId();
if (!strutsAction.equals("/login/create_account") && company.isStrangers() && !portletName.equals(PortletKeys.FAST_LOGIN)) {
	showCreateAccountIcon = true;
}

if (Validator.isNotNull(strutsAction) && !strutsAction.equals("/login/login")) {
	showSignInIcon = true;
}

boolean isStartupSkinEnabled = false;
String socialLoginSkin = "";
SPParameter spParam = null;
try {
	spParam = SPParameterLocalServiceUtil.findSPParameterOrAdd("login.skin", "social_login_skin_1", "Login Skin", "Login",
			themeDisplay.getScopeGroupId());

} catch (Exception ex) {
	_log.error(ex.getMessage());
}

if(Validator.isNull(spParam) || "".equalsIgnoreCase(spParam.getValue())) { 
	socialLoginSkin = "social_login_skin_1";
} else {
	socialLoginSkin = spParam.getValue();
}

isStartupSkinEnabled = "startup_login_skin_1".equals(socialLoginSkin);

%>

<c:if test="<%= showCreateAccountIcon %>">
	<div class="sp-login-new-user">
		<span class="sp-login-header">New User?</span>
		<div class="sp-login-callout">			
			<span><button class="btn-callout" name="name" onclick="window.location.href='<%= PortalUtil.getCreateAccountURL(request, themeDisplay) %>'"><%= LabelUtil.getLabel(pageContext, themeDisplay, "create.account.candidate")%></button></span>
			<c:if test="<%= isStartupSkinEnabled %>">
			
				<%
					String startupSignupUrl = SambaashUtil.getStartupSignupUrl(themeDisplay);
				%>
			
				<span><button class="btn-callout" name="name" onclick="window.location.href='<%= startupSignupUrl %>'"><%= LabelUtil.getLabel(pageContext, themeDisplay, "create.account.corporate")%></button></span>
			</c:if>			
		</div>

	</div>
</c:if>
<c:if test="<%= showSignInIcon %>">
	<%
	String signInURL = themeDisplay.getURLSignIn();

	if (portletName.equals(PortletKeys.FAST_LOGIN)) {
		PortletURL fastLoginURL = PortletURLFactoryUtil.create(request, PortletKeys.FAST_LOGIN, themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);

		fastLoginURL.setParameter("saveLastPath", Boolean.FALSE.toString());
		fastLoginURL.setParameter("struts_action", "/login/login");
		fastLoginURL.setPortletMode(PortletMode.VIEW);
		fastLoginURL.setWindowState(LiferayWindowState.POP_UP);

		signInURL = fastLoginURL.toString();
	}
	%>
	
	<div class="sp-login-current-user">
		<span class="sp-login-header line-30">Already a Registered User?</span>
		<div class="sp-login-callout">
			<span class="sp-login-calloutText"><%= LabelUtil.getLabel(pageContext, themeDisplay, "signup.login.callout")%></span>
			<div class="sp-login-callout" style="text-align: center;">	
				<button  class="btn-callout" name="name"  onclick="window.location.href='<%= signInURL%>'" ><%= LabelUtil.getLabel(pageContext, themeDisplay, "signup.login.button.label")%></button>
				<%
	            long groupId = themeDisplay.getScopeGroupId();
	            Boolean isSamlEnabled = ConfigurationPropertyLocalServiceUtil.getBoolean(companyId, groupId, "saml.enabled");
	            if (isSamlEnabled) {
	            %>  
	            	<button class="btn-callout" name="saml" onclick="window.location.href='/c/portal/login?groupId=<%= groupId %>'"><liferay-ui:message key="saml-login-button-label" /></button>
            	<% } %>
            </div>
		</div>
	</div>
</c:if>

<%!
private static Log _log = LogFactoryUtil.getLog("html.portlet.login.navigation_jsp");
%> 
