<%@ include file="init.jsp" %>

<%@ page import="sambaash.platform.srv.membershipsubscription.model.MembershipSubscription" %>
<%@ page import="sambaash.platform.srv.membershipsubscription.service.MembershipSubscriptionLocalServiceUtil" %>

<%
	String recId = (String) request.getAttribute("recId");
	MembershipSubscription record = MembershipSubscriptionLocalServiceUtil.getMembershipSubscription(Long.parseLong(recId));
	actionURL.setParameter("struts_action", "/spms/membershipsubscription_action");
	actionURL.setParameter("CMD", "delete");
	actionURL.setParameter("deleteItem", recId);

	renderURL.setParameter("struts_action", "/spms/membershipsubscription_action");
	renderURL.setParameter("CMD", "edit");
	renderURL.setParameter("recId", recId);

	PortletURL renderURL2 = renderResponse.createRenderURL();
	renderURL2.setParameter("struts_action", "/spms/membershipsubscription_action");
%>

<form action="<%= actionURL %>" method="post" name="<portlet:namespace/>fm">
	<table class="taglib-search-iterator" width="90%">
		<tr class="portlet-section-body results-row">
			<td width="30%">Ms Id</td>
			<td><%= record.getMsId() %></td>
		</tr>
		<tr class="portlet-section-body results-row alt">
			<td>Name</td>
			<td><%= record.getName() %></td>
		</tr>
		<tr class="portlet-section-body results-row">
			<td>Description</td>
			<td><%= UIHelper.lf2br(record.getDescription()) %></td>
		</tr>
		<tr class="portlet-section-body results-row alt">
			<td>Mporder_1</td>
			<td><%= record.getMporder_1() %></td>
		</tr>
		<tr class="portlet-section-body results-row">
			<td>Mp Id_1</td>
			<td><%= record.getMpId_1() %></td>
		</tr>
		<tr class="portlet-section-body results-row alt">
			<td>Mp Name_1</td>
			<td><%= record.getMpName_1() %></td>
		</tr>
		<tr class="portlet-section-body results-row">
			<td>Mp Qty_1</td>
			<td><%= record.getMpQty_1() %></td>
		</tr>
		<tr class="portlet-section-body results-row alt">
			<td>Mp Price_1</td>
			<td><%= record.getMpPrice_1() %></td>
		</tr>
		<tr class="portlet-section-body results-row">
			<td>Mp Price Currency_1</td>
			<td><%= record.getMpPriceCurrency_1() %></td>
		</tr>

		<tr class="portlet-section-body results-row alt">
			<td>Mp Subtotal</td>
			<td><%= record.getMpSubtotal() %></td>
		</tr>
		<tr class="portlet-section-body results-row">
			<td>Mp Subtotal Currency</td>
			<td><%= record.getMpSubtotalCurrency() %></td>
		</tr>
		<tr class="portlet-section-body results-row alt">
			<td>Add On Subtotal</td>
			<td><%= record.getAddOnSubtotal() %></td>
		</tr>
		<tr class="portlet-section-body results-row">
			<td>Add On Subtotal Currency</td>
			<td><%= record.getAddOnSubtotalCurrency() %></td>
		</tr>
		<tr class="portlet-section-body results-row alt">
			<td>Tax</td>
			<td><%= record.getTax() %></td>
		</tr>

		<tr class="portlet-section-body results-row alt">
			<td>Nettotal</td>
			<td><%= record.getNettotal() %></td>
		</tr>
		<tr class="portlet-section-body results-row">
			<td>Nettotal Currency</td>
			<td><%= record.getNettotalCurrency() %></td>
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