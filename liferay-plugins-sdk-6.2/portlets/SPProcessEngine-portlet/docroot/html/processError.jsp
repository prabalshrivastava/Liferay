<%@ page import="com.sambaash.platform.pe.PEError" %>
<%@ page import="com.sambaash.platform.pe.PEOutput" %>
<%@ include file="init.jsp" %>

<%
PEOutput output =(PEOutput) renderRequest.getAttribute(PEConstants.ATTR_OUTPUT);

PEError error = output.getError();
if (error != null) {
	%>

	<div class="alert alert-error">
		<%= ( Validator.isNotNull(error.getCode()) ?( error.getCode() + " - ") : "") + error.getMsg() %>
	</div>

<%
}

List<String> msgs = output.getValidationMsgs();
if (msgs != null && !msgs.isEmpty()) {
	  for (String msg : msgs) {
%>

	<div style="color:red">
		<%= msg %>
	</div>

<%
	  }
}
%>