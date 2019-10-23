<%@page import="com.sambaash.platform.srv.processbuilder.model.PEProcessState"%>
<%@ page import="com.sambaash.platform.pe.constants.PEConstants" %>
<%@ page import="com.sambaash.platform.pe.helpers.PEJSPDisplayHelper" %>
<%@ page import="com.sambaash.platform.pe.PEOutput" %>
<%@ include file="init.jsp" %>

<%
PEJSPDisplayHelper helper = new PEJSPDisplayHelper(renderRequest);
PEOutput output =(PEOutput) renderRequest.getAttribute(PEConstants.ATTR_OUTPUT);
String path = helper.getJspPath(output.getProcessState().getEntityClassId() ,output.getName());
PEProcessState processState = output.getProcessState();
// If no edit/submit permisisons and user is at jsp node, then just display wait msg.
if ( !output.isCanSubmit() && !output.isCanEdit() && output.getNodeId() == processState.getNodeId()) {
	
	if (path.contains("esign")){
%>
	<jsp:include page="/html/formData.jsp"></jsp:include>
	<jsp:include page="<%= path %>" />
<%
	}
}else {
%>
<jsp:include page="/html/formData.jsp"></jsp:include>
<jsp:include page="<%= path %>" />

<%
}
%>