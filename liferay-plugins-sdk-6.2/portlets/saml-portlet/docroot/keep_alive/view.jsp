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

<%
if (!isGlobalGroup && 
		SamlUtil.isEnabled(companyId, groupId) && 
		SamlUtil.isRoleSp(companyId) && 
		!user.isDefaultUser()) {
	String entityId = SamlConfigUtil.getString(companyId, groupId, PortletPropsKeys.SAML_ENTITY_ID);
	String keepAliveURL = null;
	try {
		SamlSpIdpConnection samlSpIdpConnection = 
				SamlSpIdpConnectionLocalServiceUtil.getSamlSpIdpConnection(companyId, groupId);
		keepAliveURL = samlSpIdpConnection.getKeepAliveUrl();
	} catch (Exception e) {}
	
	if (Validator.isNotNull(keepAliveURL)) {
%>
<%--
<h4>Keep Alive URL: <%= keepAliveURL %></h4>
<h4>EntityId: <%= entityId %></h4>
--%>
	<script src="<%= keepAliveURL %>?entityId=<%= entityId %>" type="text/javascript"></script>

<%
	}
}
%>