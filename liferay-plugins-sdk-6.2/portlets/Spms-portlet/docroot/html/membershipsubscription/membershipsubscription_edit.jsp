<%@ include file="init.jsp" %>

<%@ page import="sambaash.platform.srv.membershipsubscription.model.MembershipSubscription" %>
<%@ page import="sambaash.platform.srv.membershipsubscription.service.MembershipSubscriptionLocalServiceUtil" %>

<%
	String recId = (String) request.getAttribute("recId");
	MembershipSubscription record = MembershipSubscriptionLocalServiceUtil.getMembershipSubscription(Long.parseLong(recId));

	actionURL.setParameter("struts_action", "/spms/membershipsubscription_action");
	actionURL.setParameter("CMD", "edit");
	actionURL.setParameter("recId", recId);

	renderURL.setParameter("struts_action", "/spms/membershipsubscription_action");
%>

<form action="<%= actionURL %>" id="fm" method="POST" name="<portlet:namespace/>fm">
	<table class="taglib-search-iterator" width="90%">
		<tr class="portlet-section-body results-row">
			<td width="30%">Name<font color="red">*</font></td>
			<td><input class="required" maxlength="75" name="<portlet:namespace/>name" type="text" value="<%= record.getName() %>" /></td>
		</tr>
		<tr class="portlet-section-body results-row alt">
			<td>Description</td>
			<td><textarea cols="18" maxlength="75" name="<portlet:namespace/>description"  rows="4"><%= record.getDescription() %></textarea></td>
		</tr>
		<tr class="portlet-section-body results-row">
			<td>Mporder_1<font color="red">*</font></td>
			<td><input class="required" maxlength="75" name="<portlet:namespace/>mporder_1" type="text" value="<%= record.getMporder_1() %>" /></td>
		</tr>
		<tr class="portlet-section-body results-row alt">
			<td>Mp Id_1<font color="red">*</font></td>
			<td><input class="required" maxlength="75" name="<portlet:namespace/>mpId_1" type="text" value="<%= record.getMpId_1() %>" /></td>
		</tr>
		<tr class="portlet-section-body results-row">
			<td>Mp Name_1<font color="red">*</font></td>
			<td><input class="required" maxlength="75" name="<portlet:namespace/>mpName_1" type="text" value="<%= record.getMpName_1() %>" /></td>
		</tr>
		<tr class="portlet-section-body results-row alt">
			<td>Mp Qty_1<font color="red">*</font></td>
			<td><input class="required number" name="<portlet:namespace/>mpQty_1" type="text" value="<%= record.getMpQty_1() %>" /></td>
		</tr>
		<tr class="portlet-section-body results-row">
			<td>Mp Price_1</td>
			<td><input name="<portlet:namespace/>mpPrice_1" type="text" value="<%= record.getMpPrice_1() %>"  /></td>
		</tr>
		<tr class="portlet-section-body results-row alt">
			<td>Mp Price Currency_1<font color="red">*</font></td>
			<td><input class="required" maxlength="75" name="<portlet:namespace/>mpPriceCurrency_1" type="text" value="<%= record.getMpPriceCurrency_1() %>" /></td>
		</tr>
		<tr class="portlet-section-body results-row">
			<td>Mporder_2<font color="red">*</font></td>
			<td><input class="required" maxlength="75" name="<portlet:namespace/>mporder_2" type="text" value="<%= record.getMporder_2() %>" /></td>
		</tr>
		<tr class="portlet-section-body results-row alt">
			<td>Mp Id_2<font color="red">*</font></td>
			<td><input class="required" maxlength="75" name="<portlet:namespace/>mpId_2" type="text" value="<%= record.getMpId_2() %>" /></td>
		</tr>
		<tr class="portlet-section-body results-row">
			<td>Mp Name_2<font color="red">*</font></td>
			<td><input class="required" maxlength="75" name="<portlet:namespace/>mpName_2" type="text" value="<%= record.getMpName_2() %>" /></td>
		</tr>
		<tr class="portlet-section-body results-row alt">
			<td>Mp Qty_2<font color="red">*</font></td>
			<td><input class="required number" name="<portlet:namespace/>mpQty_2" type="text" value="<%= record.getMpQty_2() %>" /></td>
		</tr>
		<tr class="portlet-section-body results-row">
			<td>Mp Price_2</td>
			<td><input name="<portlet:namespace/>mpPrice_2" type="text" value="<%= record.getMpPrice_2() %>"  /></td>
		</tr>
		<tr class="portlet-section-body results-row alt">
			<td>Mp Price Currency_2<font color="red">*</font></td>
			<td><input class="required" maxlength="75" name="<portlet:namespace/>mpPriceCurrency_2" type="text" value="<%= record.getMpPriceCurrency_2() %>" /></td>
		</tr>
		<tr class="portlet-section-body results-row">
			<td>Mporder_3<font color="red">*</font></td>
			<td><input class="required" maxlength="75" name="<portlet:namespace/>mporder_3" type="text" value="<%= record.getMporder_3() %>" /></td>
		</tr>
		<tr class="portlet-section-body results-row alt">
			<td>Mp Id_3<font color="red">*</font></td>
			<td><input class="required" maxlength="75" name="<portlet:namespace/>mpId_3" type="text" value="<%= record.getMpId_3() %>" /></td>
		</tr>
		<tr class="portlet-section-body results-row">
			<td>Mp Name_3<font color="red">*</font></td>
			<td><input class="required" maxlength="75" name="<portlet:namespace/>mpName_3" type="text" value="<%= record.getMpName_3() %>" /></td>
		</tr>
		<tr class="portlet-section-body results-row alt">
			<td>Mp Qty_3<font color="red">*</font></td>
			<td><input class="required number" name="<portlet:namespace/>mpQty_3" type="text" value="<%= record.getMpQty_3() %>" /></td>
		</tr>
		<tr class="portlet-section-body results-row">
			<td>Mp Price_3</td>
			<td><input name="<portlet:namespace/>mpPrice_3" type="text" value="<%= record.getMpPrice_3() %>"  /></td>
		</tr>
		<tr class="portlet-section-body results-row alt">
			<td>Mp Price Currency_3<font color="red">*</font></td>
			<td><input class="required" maxlength="75" name="<portlet:namespace/>mpPriceCurrency_3" type="text" value="<%= record.getMpPriceCurrency_3() %>" /></td>
		</tr>
		<tr class="portlet-section-body results-row">
			<td>Mporder_4<font color="red">*</font></td>
			<td><input class="required" maxlength="75" name="<portlet:namespace/>mporder_4" type="text" value="<%= record.getMporder_4() %>" /></td>
		</tr>
		<tr class="portlet-section-body results-row alt">
			<td>Mp Id_4<font color="red">*</font></td>
			<td><input class="required" maxlength="75" name="<portlet:namespace/>mpId_4" type="text" value="<%= record.getMpId_4() %>" /></td>
		</tr>
		<tr class="portlet-section-body results-row">
			<td>Mp Name_4<font color="red">*</font></td>
			<td><input class="required" maxlength="75" name="<portlet:namespace/>mpName_4" type="text" value="<%= record.getMpName_4() %>" /></td>
		</tr>
		<tr class="portlet-section-body results-row alt">
			<td>Mp Qty_4<font color="red">*</font></td>
			<td><input class="required number" name="<portlet:namespace/>mpQty_4" type="text" value="<%= record.getMpQty_4() %>" /></td>
		</tr>
		<tr class="portlet-section-body results-row">
			<td>Mp Price_4</td>
			<td><input name="<portlet:namespace/>mpPrice_4" type="text" value="<%= record.getMpPrice_4() %>"  /></td>
		</tr>
		<tr class="portlet-section-body results-row alt">
			<td>Mp Price Currency_4<font color="red">*</font></td>
			<td><input class="required" maxlength="75" name="<portlet:namespace/>mpPriceCurrency_4" type="text" value="<%= record.getMpPriceCurrency_4() %>" /></td>
		</tr>
		<tr class="portlet-section-body results-row">
			<td>Mp Subtotal</td>
			<td><input name="<portlet:namespace/>mpSubtotal" type="text" value="<%= record.getMpSubtotal() %>"  /></td>
		</tr>
		<tr class="portlet-section-body results-row alt">
			<td>Mp Subtotal Currency<font color="red">*</font></td>
			<td><input class="required" maxlength="75" name="<portlet:namespace/>mpSubtotalCurrency" type="text" value="<%= record.getMpSubtotalCurrency() %>" /></td>
		</tr>
		<tr class="portlet-section-body results-row">
			<td>Add On Subtotal</td>
			<td><input name="<portlet:namespace/>addOnSubtotal" type="text" value="<%= record.getAddOnSubtotal() %>"  /></td>
		</tr>
		<tr class="portlet-section-body results-row alt">
			<td>Add On Subtotal Currency<font color="red">*</font></td>
			<td><input class="required" maxlength="75" name="<portlet:namespace/>addOnSubtotalCurrency" type="text" value="<%= record.getAddOnSubtotalCurrency() %>" /></td>
		</tr>
		<tr class="portlet-section-body results-row">
			<td>Tax<font color="red">*</font></td>
			<td><input class="required number" name="<portlet:namespace/>tax" type="text" value="<%= record.getTax() %>" /></td>
		</tr>
		<tr class="portlet-section-body results-row alt">
			<td>Comments<font color="red">*</font></td>
			<td><textarea class="required" cols="18" maxlength="75" name="<portlet:namespace/>comments" rows="4"><%= record.getComments() %></textarea></td>
		</tr>
		<tr class="portlet-section-body results-row">
			<td>Promotion Code<font color="red">*</font></td>
			<td><input class="required" maxlength="75" name="<portlet:namespace/>promotionCode" type="text" value="<%= record.getPromotionCode() %>" /></td>
		</tr>
		<tr class="portlet-section-body results-row alt">
			<td>Promotion From<font color="red">*</font></td>
			<td><liferay-ui:input-date
			  dayParam="promotionFrom_day"
			  monthParam="promotionFrom_month"
			  yearParam="promotionFrom_year"
			  dayValue="<%= record.getPromotionFrom().getDate() %>"
			  monthValue="<%= record.getPromotionFrom().getMonth() %>"
			  yearValue="<%= record.getPromotionFrom().getYear() + 1900 %>"
			  yearRangeStart="1960"
			  yearRangeEnd="2010"
			/></td>
		</tr>
		<tr class="portlet-section-body results-row">
			<td>Promotion To<font color="red">*</font></td>
			<td><liferay-ui:input-date
			  dayParam="promotionTo_day"
			  monthParam="promotionTo_month"
			  yearParam="promotionTo_year"
			  dayValue="<%= record.getPromotionTo().getDate() %>"
			  monthValue="<%= record.getPromotionTo().getMonth() %>"
			  yearValue="<%= record.getPromotionTo().getYear() + 1900 %>"
			  yearRangeStart="1960"
			  yearRangeEnd="2010"
			/></td>
		</tr>
		<tr class="portlet-section-body results-row alt">
			<td>Discount</td>
			<td><input maxlength="75" name="<portlet:namespace/>discount" type="text" value="<%= record.getDiscount() %>"  /></td>
		</tr>
		<tr class="portlet-section-body results-row">
			<td>Nettotal</td>
			<td><input name="<portlet:namespace/>nettotal" type="text" value="<%= record.getNettotal() %>"  /></td>
		</tr>
		<tr class="portlet-section-body results-row alt">
			<td>Nettotal Currency<font color="red">*</font></td>
			<td><input class="required" maxlength="75" name="<portlet:namespace/>nettotalCurrency" type="text" value="<%= record.getNettotalCurrency() %>" /></td>
		</tr>
		<tr class="portlet-section-body results-row">
			<td>Pp Txn Id</td>
			<td><input maxlength="75" name="<portlet:namespace/>ppTxnId" type="text" value="<%= record.getPpTxnId() %>"  /></td>
		</tr>
		<tr class="portlet-section-body results-row alt">
			<td>Pp Payment Status</td>
			<td><input maxlength="75" name="<portlet:namespace/>ppPaymentStatus" type="text" value="<%= record.getPpPaymentStatus() %>"  /></td>
		</tr>
		<tr class="portlet-section-body results-row">
			<td>Pp Payment Gross</td>
			<td><input name="<portlet:namespace/>ppPaymentGross" type="text" value="<%= record.getPpPaymentGross() %>"  /></td>
		</tr>
		<tr class="portlet-section-body results-row alt">
			<td>Pp Receiver Email</td>
			<td><input maxlength="75" name="<portlet:namespace/>ppReceiverEmail" type="text" value="<%= record.getPpReceiverEmail() %>"  /></td>
		</tr>
		<tr class="portlet-section-body results-row">
			<td>Pp Payer Email</td>
			<td><input maxlength="75" name="<portlet:namespace/>ppPayerEmail" type="text" value="<%= record.getPpPayerEmail() %>"  /></td>
		</tr>
		<tr class="portlet-section-body results-row alt">
			<td>Send Order Email</td>
			<td><input maxlength="75" name="<portlet:namespace/>sendOrderEmail" type="text" value="<%= record.getSendOrderEmail() %>"  /></td>
		</tr>
		<tr class="portlet-section-body results-row">
			<td>Send Shipping Email</td>
			<td><input maxlength="75" name="<portlet:namespace/>sendShippingEmail" type="text" value="<%= record.getSendShippingEmail() %>"  /></td>
		</tr>
	</table>

	<br />

	<table width="90%">
		<tr>
			<td width="5%"><input type="submit" value="Update"></td>
			<td><input onClick="location.href='<%= renderURL.toString() %>'" type="button" value="Cancel"></td>
		</tr>
	</table>
</form>