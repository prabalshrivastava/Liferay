<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="java.util.Map"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@page import="com.sambaash.platform.util.LabelUtil"%>

<liferay-theme:defineObjects />

<%
	ResultRow row = (ResultRow) request
			.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	Map<String, Object> map = row.getData();
	if (Validator.isNotNull(map)) {
		String viewUrl = GetterUtil.getString(map.get("viewUrl"));
		String exportUrl = GetterUtil.getString(map.get("exportUrl"));
		String deleteUrl = GetterUtil.getString(map.get("deleteUrl"));
%>
<liferay-ui:icon-menu message='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.nothing")%>' showArrow="false">
	<% if (Validator.isNotNull(viewUrl)) { %>
	<liferay-ui:icon message='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.view.startup")%>' url="<%=viewUrl%>"></liferay-ui:icon>
	<% } if (Validator.isNotNull(exportUrl)) { %>
	<liferay-ui:icon message='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.export.pdf")%>' url="<%=exportUrl%>"></liferay-ui:icon>
	<% } if (Validator.isNotNull(deleteUrl)) { %>
	<liferay-ui:icon message='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.delete.startup")%>' url="<%=deleteUrl%>"></liferay-ui:icon>
	<% }  %>
</liferay-ui:icon-menu>
<% } %>
