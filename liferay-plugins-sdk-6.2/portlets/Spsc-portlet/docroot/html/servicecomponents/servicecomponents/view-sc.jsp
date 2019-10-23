<%@ include file="init.jsp" %>

<%@ page import="sambaash.platform.srv.servicecomponent.model.ServiceComponents" %>
<%@ page import="sambaash.platform.srv.servicecomponent.service.ServiceComponentsLocalServiceUtil" %>

<%
	int count = ServiceComponentsLocalServiceUtil.getServiceComponentsesCount();
	List<ServiceComponents> items = ServiceComponentsLocalServiceUtil.getServiceComponentses(0, count);

	PortletURL renderURL2 = renderResponse.createRenderURL();
	renderURL2.setParameter("struts_action", "/spsc/view");

	String strutsPath = "/spsc/servicecomponents_action";
	actionURL.setParameter("struts_action", strutsPath);
	actionURL.setParameter("CMD", "delete");
%>

<liferay-ui:success key="added" message="New Service Component added Successfully" />
<liferay-ui:success key="updated" message="Updated the changes Successfully" />
<liferay-ui:error key="couldnotdelete" message="Unable to delete as it is still associated with Service Component Groups" />

<form action="<%= actionURL %>" method="post" name="<portlet:namespace/>fm">
			<div id="scgtable"> Service Component </div>
	<div class="spsc_viewsc_scglist" id="scglist">
	<%@ include file="action_links.jsp" %>

	<%
	PortletURL renderURL1 = renderResponse.createRenderURL();
	renderURL1.setParameter("struts_action", "/spsc/servicecomponentgroup_action");
	renderURL1.setParameter("CMD", "list");
%>

<div style="padding-bottom:8px;">
<input onClick="location.href='<%= renderURL1.toString() %>'" type="button" value="View Service Groups" />
		</div>

	<%
	if (roleId1) {
		renderURL.setParameter("CMD", "edit");}
	else {
		renderURL.setParameter("CMD", "detail");}
	%>

	<liferay-ui:search-container emptyResultsMessage="Sorry. There are no items to display." iteratorURL="<%= renderURL2 %>">

		<liferay-ui:search-container-results
	 		results="<%= ListUtil.subList(items, searchContainer.getStart(), searchContainer.getEnd()) %>"
	 		total="<%= items.size() %>"
		/>

	 	<liferay-ui:search-container-row modelVar="item" className="sambaash.platform.srv.servicecomponent.model.ServiceComponents">

		 	<%
			 	String recordId = String.valueOf(item.getPrimaryKey());
			 	renderURL.setParameter("recId", recordId);
			 	String checkBox1 = "<input type='checkbox' name='<portlet:namespace />" + plns + "check' onClick='" + plns + "checkAll(this);'/>";
			 	String checkBox2 = "<input type='checkbox' name='<portlet:namespace />" + plns + "deleteItem' value='" + recordId + "' onClick='" + plns + "checkAllRev(this);' />";
		 	%>

		 	<c:if test="<%= roleId1 %>">
		 	<liferay-ui:search-container-column-text name="<%= checkBox1 %>" value="<%= checkBox2 %>" />
		 	</c:if>
			<liferay-ui:search-container-column-text href="<%= renderURL %>" name="Name" property="name" />
			<liferay-ui:search-container-column-text name="Description" property="description" />
			<liferay-ui:search-container-column-text name="Status" property="status" />
			<liferay-ui:search-container-column-text name="Version" property="version" />
	 	</liferay-ui:search-container-row>

	 	<liferay-ui:search-iterator searchContainer="<%= searchContainer %>" />
	</liferay-ui:search-container>
</form>