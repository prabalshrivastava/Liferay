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

<%@ page contentType="text/javascript; charset=UTF-8" %>

<%@ page import="com.liferay.util.PwdGenerator" %>

<%@ page import="java.util.List" %>

<%
List<String> sessionKeepAliveURLs = (List<String>)request.getAttribute("SAML_SESSION_KEEP_ALIVE_URLS");

if (sessionKeepAliveURLs != null) {
	for (String sessionKeepAliveURL : sessionKeepAliveURLs) {
%>

		document.write('<img alt="Session Alive" src="<%= sessionKeepAliveURL %>?r=<%= PwdGenerator.getPassword() %>" />');

<%
	}
}
%>
