<%@ include file="init.jsp" %>

<%@ page import="sambaash.platform.srv.membershipsubscription.model.MembershipSubscription" %>
<%@ page import="sambaash.platform.srv.membershipsubscription.service.MembershipSubscriptionLocalServiceUtil" %>

<%
	int count = MembershipSubscriptionLocalServiceUtil.getMembershipSubscriptionsCount();
	List<MembershipSubscription> items = MembershipSubscriptionLocalServiceUtil.getMembershipSubscriptions(0, count);

	PortletURL renderURL2 = renderResponse.createRenderURL();
	renderURL2.setParameter("struts_action", "/spms/view");

	PortletURL renderURL3 = renderResponse.createRenderURL();
	renderURL3.setParameter("struts_action", "/spms/addItem");

	String strutsPath = "/spms/membershipsubscription_action";
	actionURL.setParameter("struts_action", strutsPath);
	actionURL.setParameter("CMD", "delete");
	 if (SambaashUtil.isAdmin(themeDisplay.getScopeGroupId(), themeDisplay.getUserId())) {
%>

<form action="<%= actionURL %>" method="post" name="<portlet:namespace/>fm">

	<%
		renderURL.setParameter("CMD", "detail");
	%>

	<liferay-ui:search-container emptyResultsMessage="Sorry. There are no items to display." iteratorURL="<%= renderURL2 %>">

		<liferay-ui:search-container-results
	 		results="<%= ListUtil.subList(items, searchContainer.getStart(), searchContainer.getEnd()) %>"
	 		total="<%= items.size() %>"
		/>

	 	<liferay-ui:search-container-row modelVar="item" className="sambaash.platform.srv.membershipsubscription.model.MembershipSubscription">

		 	<%
			 	String recordId = String.valueOf(item.getPrimaryKey());
			 	renderURL.setParameter("recId", recordId);
			 	String checkBox1 = "<input type='checkbox' name='<portlet:namespace />" + plns + "check' onClick='" + plns + "checkAll(this);'/>";
			 	String checkBox2 = "<input type='checkbox' name='<portlet:namespace />" + plns + "deleteItem' value='" + recordId + "' onClick='" + plns + "checkAllRev(this);' />";
		 	%>

		 	<liferay-ui:search-container-column-text name="<%= checkBox1 %>" value="<%= checkBox2 %>" />
			<liferay-ui:search-container-column-text href="<%= renderURL %>" name="Name" property="name" />
			<liferay-ui:search-container-column-text name="Package Name" property="mpName_1" />
			<liferay-ui:search-container-column-text name="Quantity" property="mpQty_1" />

			<liferay-ui:search-container-column-text name="Net Total" property="nettotal" />

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