<%--
/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */
--%>
<%@ include file="/init.jsp" %>

<portlet:actionURL name="updateServiceProvider" var="updateServiceProviderURL">
	<portlet:param name="tabs1" value="service-provider" />
</portlet:actionURL>

<h4><liferay-ui:message key="metadata-url" />: <%= SamlUtil.getSpMetadataLink(companyId, groupId) %></h4>

<aui:form action="<%= updateServiceProviderURL %>">
	<aui:input type="hidden" name="doAsGroupId" value="<%= groupId %>" />
	<aui:fieldset label="general">
		<aui:input 
			label="assertion-signature-required" 
			name='<%= "settings--" + PortletPropsKeys.SAML_SP_ASSERTION_SIGNATURE_REQUIRED + "--" %>' 
			type="checkbox" 
			value="<%= MetadataManagerUtil.isWantAssertionsSigned(companyId, groupId) %>" 
		/>

		<aui:input 
			helpMessage="clock-skew-help" 
			label="clock-skew" 
			name='<%= "settings--" + PortletPropsKeys.SAML_SP_CLOCK_SKEW + "--" %>' 
			value="<%= SamlConfigUtil.getInteger(companyId, groupId, PortletPropsKeys.SAML_SP_CLOCK_SKEW) %>" 
		/>

		<aui:input 
			label="ldap-import-enabled" 
			name='<%= "settings--" + PortletPropsKeys.SAML_SP_LDAP_IMPORT_ENABLED + "--" %>' 
			type="checkbox" 
			value="<%= SamlConfigUtil.getBoolean(companyId, groupId, PortletPropsKeys.SAML_SP_LDAP_IMPORT_ENABLED) %>" 
		/>

		<aui:input 
			label="sign-authn-requests" 
			name='<%= "settings--" + PortletPropsKeys.SAML_SP_SIGN_AUTHN_REQUEST + "--" %>' 
			type="checkbox" 
			value="<%= MetadataManagerUtil.isSignAuthnRequests(companyId, groupId) %>" 
		/>

		<aui:input 
			label="sign-metadata" 
			name='<%= "settings--" + PortletPropsKeys.SAML_SIGN_METADATA + "--" %>' 
			type="checkbox" 
			value="<%= MetadataManagerUtil.isSignMetadata(companyId, groupId) %>" 
		/>

		<aui:input 
			label="ssl-required" 
			name='<%= "settings--" + PortletPropsKeys.SAML_SSL_REQUIRED + "--" %>' 
			type="checkbox" 
			value="<%= MetadataManagerUtil.isSSLRequired(companyId, groupId) %>" 
		/>
		
		<aui:input
			label="saml-default-landing-page"
			name='<%= "settings--" + PortletPropsKeys.SAML_DEFAULT_LANDING_PAGE + "--" %>'
			type="text"
			width="120"
			value="<%= SamlConfigUtil.getString(companyId, groupId, PortletPropsKeys.SAML_DEFAULT_LANDING_PAGE) %>"
		/>
		
		<aui:input 
			label="do-not-use-saml-for-logout"
			name='<%= "settings--" + PortletPropsKeys.SAML_DO_NOT_USE_SAML_FOR_LOGOUT + "--" %>'
			type="checkbox"
			value="<%= SamlUtil.isDoNotUseSamlForLogout(companyId, groupId) %>" 
		/>
	</aui:fieldset>

	<aui:button-row>
		<aui:button type="submit" value="save" />
	</aui:button-row>
</aui:form>