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

<%@ include file="/html/portal/init.jsp" %>

<%
String referer = ParamUtil.getString(request, WebKeys.REFERER, themeDisplay.getPathMain());

if (referer.equals(themeDisplay.getPathMain() + "/portal/update_email_address")) {
	referer = themeDisplay.getPathMain() + "?doAsUserId=" + themeDisplay.getDoAsUserId();
}

PasswordPolicy passwordPolicy = user.getPasswordPolicy();

String ticketKey = ParamUtil.getString(request, "ticketKey");
String moduleName = ParamUtil.getString(request, "modulename");
String fileShareId = ParamUtil.getString(request, "fileShareId");
String destinationUrl = ParamUtil.getString(request, "destinationUrl");
%>

<script type="text/javascript">
	var module = '<%=moduleName%>';
	AUI().ready('aui-base', function(A) {
		
		if( module == 'esnSharing'){
			var b = A.one("#<portlet:namespace />submitButton");
			if(b){
				b.setAttribute("disabled",true);
			}
			var t = A.one("#<portlet:namespace />ticketKey");
			if(t){
				t.setAttribute("readonly",true);
			}
			A.one("#<portlet:namespace />fm").submit();
			
		}
	});
</script>

<aui:form action='<%= themeDisplay.getPathMain() + "/portal/verify_email_address" %>' method="post" name="fm">
	<aui:input name="p_l_id" type="hidden" value="<%= layout.getPlid() %>" />
	<aui:input name="p_auth" type="hidden" value="<%= AuthTokenUtil.getToken(request) %>" />
	<aui:input name="doAsUserId" type="hidden" value="<%= themeDisplay.getDoAsUserId() %>" />
	<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />
	<aui:input name="<%= WebKeys.REFERER %>" type="hidden" value="<%= referer %>" />
	<aui:input name="modulename" type="hidden" value="<%= moduleName %>" />
	<aui:input name="destinationUrl" type="hidden" value="<%= destinationUrl %>" />

	<div class="alert alert-info">
		<liferay-ui:message key="please-enter-your-verification-code" />
	</div>

	<c:if test="<%= !SessionErrors.isEmpty(request) %>">
		<c:choose>
			<c:when test="<%= SessionErrors.contains(request, DuplicateUserEmailAddressException.class.getName()) %>">
				<div class="alert alert-error">
					<liferay-ui:message key="the-email-address-you-requested-is-already-taken" />
				</div>
			</c:when>
			<c:when test="<%= SessionErrors.contains(request, ReservedUserEmailAddressException.class.getName()) %>">
				<div class="alert alert-error">
					<liferay-ui:message key="the-email-address-you-requested-is-reserved" />
				</div>
			</c:when>
			<c:when test="<%= SessionErrors.contains(request, UserEmailAddressException.class.getName()) %>">
				<div class="alert alert-error">
					<liferay-ui:message key="please-enter-a-valid-email-address" />
				</div>
			</c:when>
			<c:otherwise>
				<div class="alert alert-error">
					<liferay-ui:message key="please-enter-a-valid-verification-code" />
				</div>
			</c:otherwise>
		</c:choose>
	</c:if>

	<aui:input autoFocus="<%= true %>" class="lfr-input-text-container" label="email-verification-code" name="ticketKey" size="36" type="text" value="<%= ticketKey %>" />

	<aui:button-row>
		<aui:button type="submit" value="verify"  id="submitButton" name="submitButton"/>

		<c:if test="<%= themeDisplay.isSignedIn() && !user.isEmailAddressVerified() %>">
			<aui:button href='<%= themeDisplay.getPathMain() + "/portal/verify_email_address?p_l_id=" + layout.getPlid() + "&cmd=" + Constants.SEND + "&referer=" + HttpUtil.encodeURL(referer) %>' value="send-new-verification-code" />

			<aui:button href='<%= themeDisplay.getPathMain() + "/portal/update_email_address?p_l_id=" + layout.getPlid() + "&referer=" + HttpUtil.encodeURL(referer) %>' value="change-email-address" />
		</c:if>
	</aui:button-row>
</aui:form>