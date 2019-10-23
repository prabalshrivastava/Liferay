<%@ include file="init.jsp" %>

<%@ page import="sambaash.platform.srv.servicecomponent.model.ServiceComponents" %>
<%@ page import="sambaash.platform.srv.servicecomponent.service.ServiceComponentsLocalServiceUtil" %>

<%
	int count = ServiceComponentsLocalServiceUtil.getServiceComponentsesCount();
	List<ServiceComponents> items = ServiceComponentsLocalServiceUtil.getServiceComponentses(0, count);

	PortletURL renderURL2 = renderResponse.createRenderURL();
	renderURL2.setParameter("CMD", "iterate");

	PortletURL renderURL3 = renderResponse.createRenderURL();
	renderURL3.setParameter("CMD", "list");
%>

	<portlet:actionURL name="componentAction" var="actionURLs">
		<portlet:param name="CMD" value="delete" />
	</portlet:actionURL>

<liferay-ui:success key="added" message="New Service Component added Successfully" />
<liferay-ui:success key="updated" message="Updated the changes Successfully" />

<%
	List sessionList = (List)session.getAttribute("inUseList");
	if (sessionList!=null) {
		String inUseMPMessage ="";

		Iterator itr = sessionList.iterator();
		while (itr.hasNext()) {
			inUseMPMessage+="\'"+(String)itr.next()+"\' ";

		}
		String msg = "You cannot delete service component(s) "+inUseMPMessage+" as they are in use.";

		if (sessionList.size()>0) {
	%>

		<liferay-ui:success key="deleted" message="<%= msg %>" />

	<%
		}else {
		%>

			<liferay-ui:success key="deleted" message="Deleted Service Components Successfully" />

		<%
		}
	}else {
%>

<liferay-ui:success key="deleted" message="Deleted Service Components Successfully" />

<%
	}
	session.removeAttribute("inUseList");
	 if (SambaashUtil.isAdmin(themeDisplay.getScopeGroupId(), themeDisplay.getUserId())) {
%>

<liferay-ui:error key="couldnotdelete" message="Unable to delete as it is still associated with Service Component Groups" />

			<div id="scgtable"> Service Component </div>
	<div class="spsc_servicecomponent_scglist" id="scglist">
	<portlet:actionURL name="componentAction" var="renderURLs">
	<portlet:param name="CMD" value="formView" />
</portlet:actionURL>

<c:if test="<%= roleId1 %>">

<div style="width:104px;float:left">
<input onClick="location.href='<%= renderURLs.toString() %>'" type="button" value="Add" />&nbsp;
<c:if test="<%= items.size()!=0 %>">
<input onClick="<%= plns %>confirmDel('delmultiple');" type="button" value="Delete" />
</c:if>

</div>
</c:if>

<portlet:actionURL name="componentAction" var="serviceUrl">
		<portlet:param name="CMD" value="list" />
	</portlet:actionURL>
<div style="padding-bottom:8px;">
<input onClick="location.href='<%= serviceUrl.toString() %>'" type="button" value="View Service Groups" />
		</div></div>

	<form action="<%= actionURLs %>" method="post" name="<portlet:namespace/>fm">

	<liferay-ui:search-container emptyResultsMessage="Sorry. There are no items to display." iteratorURL="<%= renderURL3 %>">

		<liferay-ui:search-container-results
	 		results="<%= ListUtil.subList(items, searchContainer.getStart(), searchContainer.getEnd()) %>"
	 		total="<%= items.size() %>"
		/>

	 	<liferay-ui:search-container-row modelVar="item" className="sambaash.platform.srv.servicecomponent.model.ServiceComponents">

		 	<%
				String recordId = String.valueOf(item.getPrimaryKey());
			%>

			<portlet:actionURL name="componentAction" var="editURL">

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