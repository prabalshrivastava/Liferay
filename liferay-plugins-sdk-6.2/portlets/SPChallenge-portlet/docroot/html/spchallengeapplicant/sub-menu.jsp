<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="java.util.Map"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@page import="com.sambaash.platform.util.LabelUtil"%>

<liferay-theme:defineObjects />

<%
	ResultRow row = (ResultRow) request
			.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	Map<String, Object> map = (row==null) ? null : row.getData();
	if (Validator.isNotNull(map)) {
		String viewApplicantUrl = GetterUtil.getString(map
				.get("viewApplicantUrl"));
		String onClickStatusUrl = GetterUtil.getString(map
				.get("onClickStatusUrl"));
		String exportUrl = GetterUtil.getString(map.get("exportUrl"));
		String challengeUrl = GetterUtil.getString(map
				.get("challengeUrl"));
		String startupProfileUrl = GetterUtil.getString(map
				.get("startupProfileUrl"));
%>
<liferay-ui:icon-menu message='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.nothing")%>' showArrow="false">
	<% if (Validator.isNotNull(onClickStatusUrl)) { %>
	 <a class="refreshStatus" href='#' op='refresh' <%=onClickStatusUrl %> ><liferay-ui:icon message='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.refresh.application.status")%>'/></a>
	<% } if (Validator.isNotNull(viewApplicantUrl)) { %>
	<liferay-ui:icon message='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.view.application")%>' url="<%=viewApplicantUrl%>"/>
	<% } if (Validator.isNotNull(startupProfileUrl)) { %>
	<liferay-ui:icon message='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.view.startup")%>' url="<%=startupProfileUrl%>"/>
	<% } if (Validator.isNotNull(challengeUrl)) { %>
	<liferay-ui:icon message='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.view.challenge")%>' url="<%=challengeUrl%>"/>
	<% } if (Validator.isNotNull(exportUrl)) { %>
	<liferay-ui:icon message='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.export.pdf")%>' url="<%=exportUrl%>"/>
	<% }  %>
</liferay-ui:icon-menu>
<% } %>
