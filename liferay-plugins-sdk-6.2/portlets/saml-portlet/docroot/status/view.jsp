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

<%@ include file="init.jsp" %>

<%
int status = ParamUtil.getInteger(request, "status");

if (status > 0) {
	response.setStatus(status);
}

String exception = ParamUtil.getString(request, "exception");

%>
<h3 class="alert alert-error">
	<liferay-ui:message key="login-error-header" />
</h3>

<liferay-ui:message key="login-error" />

<br /><br />

<code class="lfr-url-error"><%= exception %></code>

<ul>
<%
for (String key : SessionErrors.keySet(request)) {
	Object value = SessionErrors.get(request, key);

	if (value instanceof Exception) {
		Exception e = (Exception)value;

		_log.error(e.getMessage());
		%>
			<li><%= e.getClass().getName() %>: <%= e.getMessage() %></li>
		<%

		if (_log.isDebugEnabled()) {
			_log.debug(e, e);
		}
	}
	else {
		%>
		<li><%= key %> = <%= value.toString() %></li>
		<%
	}
}
%>
</ul>

<div style="width: 90%; height: 400px; border: 2px solid black; overflow: auto; padding: 5px;">
	<%
	SimpleDateFormat dateFmt = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
	SimpleDateFormat logEntryFmt = new SimpleDateFormat("HH:mm", Locale.US);
	
	Calendar today = Calendar.getInstance();
	today.add(Calendar.SECOND, -2);
	
	String logFile = PortalUtil.getPortalWebDir() + "../../logs/saml." + dateFmt.format(today.getTime()).toString() + ".log";
	String logEntryPrefix = logEntryFmt.format(today.getTime());
	
	BufferedReader br = null;
	try {
		br = new BufferedReader(new FileReader(logFile));
		String line = null;
		while ((line = br.readLine()) != null) {
			if (!line.startsWith(logEntryPrefix)) continue;
			%>
			<%= HtmlUtil.escape(line) %><br/>
			<%
		}
	}
	catch (Exception e) {
		_log.error(e.getMessage());
	}
	finally {
		if (br != null)
			br.close();
	}
	%>
</div>
<%!
private static Log _log = LogFactoryUtil.getLog("status.view_jsp");
%>
