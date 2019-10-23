<%@ include file="init.jsp" %>

<%
PEOutput output =(PEOutput) renderRequest.getAttribute(PEConstants.ATTR_OUTPUT);
if (Validator.isNotNull(output.getMsg())) {
%>

	<div class="msg" id="waitMsgContainer">
	    <%= output.getMsg() %>
	</div>

<%
}
%>
