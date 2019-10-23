<%@ include file="init.jsp" %>

<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.List" %>

<%@ page import="sambaash.platform.srv.servicecomponent.model.ServiceComponentGroup" %>
<%@ page import="sambaash.platform.srv.servicecomponent.service.ServiceComponentGroupLocalServiceUtil" %>

<%
	int count = ServiceComponentGroupLocalServiceUtil.getServiceComponentGroupsCount();
	List<ServiceComponentGroup> items = ServiceComponentGroupLocalServiceUtil.getServiceComponentGroups(0, count);

	PortletURL renderURL2 = renderResponse.createRenderURL();
	renderURL2.setParameter("struts_action", "/spsc/view");

	String keywords = ParamUtil.getString(request, "keywords");
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setWindowState(WindowState.MAXIMIZED);
	portletURL.setParameter("keywords", keywords);
%>

<portlet:actionURL name="componentGroupAction" var="actionURLs">
	<portlet:param name="CMD" value="delete"></portlet:param>
</portlet:actionURL>

<liferay-ui:success key="added" message="New Service Group added Successfully" />

<%
	List sessionList = (List)session.getAttribute("inUseList");
	if (sessionList!=null) {
		String inUseMPMessage ="";

		Iterator itr = sessionList.iterator();
		while (itr.hasNext()) {
			inUseMPMessage+="\'"+(String)itr.next()+"\' ";
		}
		String msg = "You cannot delete/edit service group(s) "+inUseMPMessage+" as they are in use.";

		if (sessionList.size()>0) {
	%>

		<liferay-ui:success key="deleted" message="<%= msg %>" />
		<liferay-ui:success key="updated" message="<%= msg %>" />

	<%
		}else {
		%>

			<liferay-ui:success key="deleted" message="Deleted Service Groups Successfully" />
			<liferay-ui:success key="updated" message="Updated the changes Successfully" />

		<%
		}
	}else {
%>

<liferay-ui:success key="deleted" message="Deleted Service Groups Successfully" />
<liferay-ui:success key="updated" message="Updated the changes Successfully" />

<%
	}
	session.removeAttribute("inUseList");
	if (SambaashUtil.isAdmin(themeDisplay.getScopeGroupId(), themeDisplay.getUserId())) {
%>

<div id="scgtable"> Service Groups </div>

	<div class="membership_scglist" id="scglist">
	<%@ include file="action_links.jsp" %>

	<portlet:actionURL name="componentGroupAction" var="serviceUrl">
		<portlet:param name="CMD" value="list" />
	</portlet:actionURL>
	<input onClick="location.href='<%= serviceUrl.toString() %>'" type="button" value="View Service Component" />

	<!--
	<div class="spsc_search">
		<c:if test="<!--%= roleId1 %>">
			<liferay-portlet:renderURL varImpl="searchURL" windowState="<!--%= WindowState.NORMAL.toString() %>"><portlet:param name="struts_action" value="/spsc/search" /></liferay-portlet:renderURL>
			<form action="<!--%= searchURL %>" method="post" name="<portlet:namespace />searchfm" onSubmit="submitForm(this); return false;">
				<liferay-portlet:renderURLParams varImpl="searchURL" />
				<input name="<portlet:namespace />CMD" type="hidden" value="search" />
				<input name="<portlet:namespace />keywords" size="30" type="text" value="<!--%= HtmlUtil.escape(keywords) %>" />
				<input align="absmiddle" border="0" src="/html/themes/classic/images/common/search.png" title="<liferay-ui:message key="search" />" type="image" />
				<!--<input type="submit" value="<liferay-ui:message key="search" />" />
				<input align="absmiddle" border="0" src="/html/themes/classic/images/common/search.png" title="Search" type="image">-->
	<!-- </form>
	 	</c:if>
	</div>
	 -->
</div>
<form action="<%= actionURLs %>" method="post" name="<portlet:namespace/>fm">

	<liferay-ui:search-container emptyResultsMessage="Sorry. There are no items to display." iteratorURL="<%= renderURL2 %>">

		<liferay-ui:search-container-results
	 		results="<%= ListUtil.subList(items, searchContainer.getStart(), searchContainer.getEnd()) %>"
	 		total="<%= items.size() %>"
		/>
	 	<liferay-ui:search-container-row modelVar="item" className="sambaash.platform.srv.servicecomponent.model.ServiceComponentGroup">

		 	<%
				String recordId = String.valueOf(item.getPrimaryKey());
			%>

			<portlet:actionURL name="componentGroupAction" var="editURL">

			<%
			if (roleId1){ %>
				<portlet:param name="CMD" value="editView"></portlet:param>
			<% }
			else { %>
				<portlet:param name="CMD" value="detailView"></portlet:param>
			<%} %>
	<portlet:param name="recId" value="<%= recordId %>"></portlet:param>
	</portlet:actionURL>

		 	<%
			 	String checkBox1 = "<input type='checkbox' name='<portlet:namespace />" + plns + "check' onClick='" + plns + "checkAll(this);'/>";
			 	String checkBox2 = "<input type='checkbox' name='<portlet:namespace />" + plns + "deleteItem' value='" + recordId + "' onClick='" + plns + "checkAllRev(this);' />";
		 	%>

		 	<c:if test="<%= roleId1 %>">
		 	<liferay-ui:search-container-column-text name="<%= checkBox1 %>" value="<%= checkBox2 %>" />
		 	</c:if>
			<liferay-ui:search-container-column-text href="<%= editURL %>" name="Name" property="name" />
			<liferay-ui:search-container-column-text name="Description" property="description" />
			<liferay-ui:search-container-column-text name="Status" property="status" />
			<liferay-ui:search-container-column-text name="Version" property="version" />
	 	</liferay-ui:search-container-row>

	 	<liferay-ui:search-iterator searchContainer="<%= searchContainer %>" />
	</liferay-ui:search-container>
</form>

<%
}
else { %>
	<div class="portlet-msg-error">You do not have the roles required to access this portlet.</div>

<%
}
%>