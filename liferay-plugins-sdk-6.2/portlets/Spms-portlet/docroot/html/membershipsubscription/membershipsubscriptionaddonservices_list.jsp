<%@ include file="init.jsp" %>

<%@ page import="sambaash.platform.srv.membershipsubscription.model.MembershipSubscriptionAddonServices" %>
<%@ page import="sambaash.platform.srv.membershipsubscription.service.MembershipSubscriptionAddonServicesLocalServiceUtil" %>

<%
	int count = MembershipSubscriptionAddonServicesLocalServiceUtil.getMembershipSubscriptionAddonServicesesCount();
	List<MembershipSubscriptionAddonServices> items = MembershipSubscriptionAddonServicesLocalServiceUtil.getMembershipSubscriptionAddonServiceses(0, count);

	PortletURL renderURL2 = renderResponse.createRenderURL();
	renderURL2.setParameter("struts_action", "/spms/view");

	String strutsPath = "/spms/membershipsubscriptionaddonservices_action";
	actionURL.setParameter("struts_action", strutsPath);
	actionURL.setParameter("CMD", "delete");
%>

<form action="<%= actionURL %>" method="post" name="<portlet:namespace/>fm">
	<%@ include file="action_links.jsp" %>

	<%
		renderURL.setParameter("CMD", "detail");
	%>

	<liferay-ui:search-container emptyResultsMessage="Sorry. There are no items to display." iteratorURL="<%= renderURL2 %>">

		<liferay-ui:search-container-results
	 		results="<%= ListUtil.subList(items, searchContainer.getStart(), searchContainer.getEnd()) %>"
	 		total="<%= items.size() %>"
		/>

	 	<liferay-ui:search-container-row modelVar="item" className="sambaash.platform.srv.membershipsubscription.model.MembershipSubscriptionAddonServices">

		 	<%
			 	String recordId = String.valueOf(item.getPrimaryKey());
			 	renderURL.setParameter("recId", recordId);
			 	String checkBox1 = "<input type='checkbox' name='<portlet:namespace />" + plns + "check' onClick='" + plns + "checkAll(this);'/>";
			 	String checkBox2 = "<input type='checkbox' name='<portlet:namespace />" + plns + "deleteItem' value='" + recordId + "' onClick='" + plns + "checkAllRev(this);' />";
		 	%>

			<liferay-ui:search-container-column-text href="<%= renderURL %>" name="Sc Id" property="scId" />
			<liferay-ui:search-container-column-text name="Sc Name" property="scName" />
			<liferay-ui:search-container-column-text name="Param Type" property="paramType" />
			<liferay-ui:search-container-column-text name="Param From" property="paramFrom" />
			<liferay-ui:search-container-column-text name="Param Upto" property="paramUpto" />
			<liferay-ui:search-container-column-text name="Duration" property="duration" />
			<liferay-ui:search-container-column-text name="Duration Type" property="durationType" />
			<liferay-ui:search-container-column-text name="Service Charges" property="serviceCharges" />
			<liferay-ui:search-container-column-text name="Service Charges Currency" property="serviceChargesCurrency" />
			<liferay-ui:search-container-column-text name="Service Charges Period" property="serviceChargesPeriod" />
			<liferay-ui:search-container-column-text name="Service Charges Period Type" property="serviceChargesPeriodType" />
			<liferay-ui:search-container-column-text name="Status" property="status" />
			<liferay-ui:search-container-column-text name="Description" property="description" />
			<liferay-ui:search-container-column-jsp name="Actions" path="/html/membershipsubscriptionaddonservices_actiontab.jsp" />
			<liferay-ui:search-container-column-text name="<%= checkBox1 %>" value="<%= checkBox2 %>" />
	 	</liferay-ui:search-container-row>

	 	<liferay-ui:search-iterator searchContainer="<%= searchContainer %>" />
	</liferay-ui:search-container>
</form>