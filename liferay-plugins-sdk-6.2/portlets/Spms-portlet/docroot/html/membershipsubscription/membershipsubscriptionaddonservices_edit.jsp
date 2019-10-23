<%@ include file="init.jsp" %>

<%@ page import="sambaash.platform.srv.membershipsubscription.model.MembershipSubscriptionAddonServices" %>
<%@ page import="sambaash.platform.srv.membershipsubscription.service.MembershipSubscriptionAddonServicesLocalServiceUtil" %>

<%
	String recId = (String) request.getAttribute("recId");
	MembershipSubscriptionAddonServices record = MembershipSubscriptionAddonServicesLocalServiceUtil.getMembershipSubscriptionAddonServices(Long.parseLong(recId));

	actionURL.setParameter("struts_action", "/spms/membershipsubscriptionaddonservices_action");
	actionURL.setParameter("CMD", "edit");
	actionURL.setParameter("recId", recId);

	renderURL.setParameter("struts_action", "/spms/membershipsubscriptionaddonservices_action");
%>

<form action="<%= actionURL %>" id="fm" method="POST" name="<portlet:namespace/>fm">
	<table class="taglib-search-iterator" width="90%">
		<tr class="portlet-section-body results-row">
			<td width="30%">Sc Id<font color="red">*</font></td>
			<td><input class="required" maxlength="75" name="<portlet:namespace/>scId" type="text" value="<%= record.getScId() %>" /></td>
		</tr>
		<tr class="portlet-section-body results-row alt">
			<td>Sc Name<font color="red">*</font></td>
			<td><input class="required" maxlength="75" name="<portlet:namespace/>scName" type="text" value="<%= record.getScName() %>" /></td>
		</tr>
		<tr class="portlet-section-body results-row">
			<td>Param Type<font color="red">*</font></td>
			<td><input class="required" maxlength="75" name="<portlet:namespace/>paramType" type="text" value="<%= record.getParamType() %>" /></td>
		</tr>
		<tr class="portlet-section-body results-row alt">
			<td>Param From<font color="red">*</font></td>
			<td><input class="required" maxlength="75" name="<portlet:namespace/>paramFrom" type="text" value="<%= record.getParamFrom() %>" /></td>
		</tr>
		<tr class="portlet-section-body results-row">
			<td>Param Upto<font color="red">*</font></td>
			<td><input class="required" maxlength="75" name="<portlet:namespace/>paramUpto" type="text" value="<%= record.getParamUpto() %>" /></td>
		</tr>
		<tr class="portlet-section-body results-row alt">
			<td>Duration<font color="red">*</font></td>
			<td><input class="required" maxlength="75" name="<portlet:namespace/>duration" type="text" value="<%= record.getDuration() %>" /></td>
		</tr>
		<tr class="portlet-section-body results-row">
			<td>Duration Type<font color="red">*</font></td>
			<td><input class="required" maxlength="75" name="<portlet:namespace/>durationType" type="text" value="<%= record.getDurationType() %>" /></td>
		</tr>
		<tr class="portlet-section-body results-row alt">
			<td>Service Charges</td>
			<td><input name="<portlet:namespace/>serviceCharges" type="text" value="<%= record.getServiceCharges() %>"  /></td>
		</tr>
		<tr class="portlet-section-body results-row">
			<td>Service Charges Currency<font color="red">*</font></td>
			<td><input class="required" maxlength="75" name="<portlet:namespace/>serviceChargesCurrency" type="text" value="<%= record.getServiceChargesCurrency() %>" /></td>
		</tr>
		<tr class="portlet-section-body results-row alt">
			<td>Service Charges Period<font color="red">*</font></td>
			<td><input class="required" maxlength="75" name="<portlet:namespace/>serviceChargesPeriod" type="text" value="<%= record.getServiceChargesPeriod() %>" /></td>
		</tr>
		<tr class="portlet-section-body results-row">
			<td>Service Charges Period Type<font color="red">*</font></td>
			<td>
			<% String optionId1 = record.getServiceChargesPeriodType(); %>
			<select class="required" name="<portlet:namespace/>serviceChargesPeriodType">
			<option <%= (optionId1.equalsIgnoreCase("Weekly"))?"selected" : "" %> value="Weekly">Weekly</option>
			<option <%= (optionId1.equalsIgnoreCase("Monthly"))?"selected" : "" %> value="Monthly">Monthly</option>
			<option <%= (optionId1.equalsIgnoreCase("Yearly"))?"selected" : "" %> value="Yearly">Yearly</option>
			<option <%= (optionId1.equalsIgnoreCase("Hybrid"))?"selected" : "" %> value="Hybrid">Hybrid</option>
			</select>
			</td>
		</tr>
		<tr class="portlet-section-body results-row alt">
			<td>Status<font color="red">*</font></td>
			<td>
			<% String optionId2 = record.getStatus(); %>
			<select class="required" name="<portlet:namespace/>status">
			<option <%= (optionId2.equalsIgnoreCase("Enable"))?"selected" : "" %> value="Enable">enable</option>
			<option <%= (optionId2.equalsIgnoreCase("Disable"))?"selected" : "" %> value="Disable">disable</option>
			</select>
			</td>
		</tr>
		<tr class="portlet-section-body results-row">
			<td>Description</td>
			<td><textarea cols="18" maxlength="75" name="<portlet:namespace/>description"  rows="4"><%= record.getDescription() %></textarea></td>
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