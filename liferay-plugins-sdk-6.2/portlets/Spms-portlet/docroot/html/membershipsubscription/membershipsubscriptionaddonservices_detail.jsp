<%@ include file="init.jsp" %>

<%@ page import="sambaash.platform.srv.membershipsubscription.model.MembershipSubscriptionAddonServices" %>
<%@ page import="sambaash.platform.srv.membershipsubscription.service.MembershipSubscriptionAddonServicesLocalServiceUtil" %>

<%
	String recId = (String) request.getAttribute("recId");
	MembershipSubscriptionAddonServices record = MembershipSubscriptionAddonServicesLocalServiceUtil.getMembershipSubscriptionAddonServices(Long.parseLong(recId));
	actionURL.setParameter("struts_action", "/spms/membershipsubscriptionaddonservices_action");
	actionURL.setParameter("CMD", "delete");
	actionURL.setParameter("deleteItem", recId);

	renderURL.setParameter("struts_action", "/spms/membershipsubscriptionaddonservices_action");
	renderURL.setParameter("CMD", "edit");
	renderURL.setParameter("recId", recId);

	PortletURL renderURL2 = renderResponse.createRenderURL();
	renderURL2.setParameter("struts_action", "/spms/membershipsubscriptionaddonservices_action");
%>

<form action="<%= actionURL %>" method="post" name="<portlet:namespace/>fm">
	<table class="taglib-search-iterator" width="90%">
		<tr class="portlet-section-body results-row">
			<td width="30%">Ms Addon Id</td>
			<td><%= record.getMsAddonId() %></td>
		</tr>
		<tr class="portlet-section-body results-row alt">
			<td>Sc Id</td>
			<td><%= record.getScId() %></td>
		</tr>
		<tr class="portlet-section-body results-row">
			<td>Sc Name</td>
			<td><%= record.getScName() %></td>
		</tr>
		<tr class="portlet-section-body results-row alt">
			<td>Param Type</td>
			<td><%= record.getParamType() %></td>
		</tr>
		<tr class="portlet-section-body results-row">
			<td>Param From</td>
			<td><%= record.getParamFrom() %></td>
		</tr>
		<tr class="portlet-section-body results-row alt">
			<td>Param Upto</td>
			<td><%= record.getParamUpto() %></td>
		</tr>
		<tr class="portlet-section-body results-row">
			<td>Duration</td>
			<td><%= record.getDuration() %></td>
		</tr>
		<tr class="portlet-section-body results-row alt">
			<td>Duration Type</td>
			<td><%= record.getDurationType() %></td>
		</tr>
		<tr class="portlet-section-body results-row">
			<td>Service Charges</td>
			<td><%= record.getServiceCharges() %></td>
		</tr>
		<tr class="portlet-section-body results-row alt">
			<td>Service Charges Currency</td>
			<td><%= record.getServiceChargesCurrency() %></td>
		</tr>
		<tr class="portlet-section-body results-row">
			<td>Service Charges Period</td>
			<td><%= record.getServiceChargesPeriod() %></td>
		</tr>
		<tr class="portlet-section-body results-row alt">
			<td>Service Charges Period Type</td>
			<td><%= record.getServiceChargesPeriodType() %></td>
		</tr>
		<tr class="portlet-section-body results-row">
			<td>Status</td>
			<td><%= record.getStatus() %></td>
		</tr>
		<tr class="portlet-section-body results-row alt">
			<td>Description</td>
			<td><%= UIHelper.lf2br(record.getDescription()) %></td>
		</tr>
	</table>

	<br />

	<table width="90%">
		<tr>
			<td width="5%"><input type="button" value="Delete" onClick="<%= plns %>confirmDel('del');"></td>
			<td width="5%"><input type="button" value="Edit" onClick="location.href='<%= renderURL.toString() %>'"></td>
			<td><input onClick="location.href='<%= renderURL2.toString() %>'" type="button" value="Back"></td>
		</tr>
	</table>
</form>