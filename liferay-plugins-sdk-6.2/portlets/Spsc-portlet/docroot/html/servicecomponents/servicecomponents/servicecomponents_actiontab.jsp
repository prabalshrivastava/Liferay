<%@ include file="init.jsp" %>
<%@ page import="sambaash.platform.srv.servicecomponent.model.ServiceComponents" %>

<%
	ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	ServiceComponents record = (ServiceComponents)row.getObject();
	String recId = String.valueOf(record.getPrimaryKey());

	String strutsPath = "/spsc/servicecomponents_action";

	renderURL.setParameter("struts_action", strutsPath);
	renderURL.setParameter("CMD", "detail");
	renderURL.setParameter("recId", recId);
%>

<liferay-ui:icon-menu>
	<liferay-ui:icon image="page" message="Detail" url="<%= renderURL.toString() %>" />

	<%
		renderURL.setParameter("CMD", "edit");
		String confirmDel = "javascript:" + plns + "confirmDel('"+ recId +"')";
	%>

	<liferay-ui:icon image="edit"  message="Modify" url="<%= renderURL.toString() %>" />
	<liferay-ui:icon image="close" message="Delete" url="<%= confirmDel %>" />
</liferay-ui:icon-menu>