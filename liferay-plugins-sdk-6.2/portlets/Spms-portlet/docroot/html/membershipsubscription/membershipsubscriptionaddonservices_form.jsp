<%@ include file="init.jsp" %>

<%
	actionURL.setParameter("struts_action", "/spms/membershipsubscriptionaddonservices_action");
	actionURL.setParameter("CMD", "process");

	renderURL.setParameter("struts_action", "/spms/membershipsubscriptionaddonservices_action");
%>

<form action="<%= actionURL %>" id="fm" method="POST" name="<portlet:namespace/>fm">
	<table class="taglib-search-iterator" width="90%">
		<tr class="portlet-section-body results-row">
			<td width="30%">Sc Id<font color="red">*</font></td>
			<td><input class="required" maxlength="75"  name="<portlet:namespace/>scId" type="text" /></td>
		</tr>
		<tr class="portlet-section-body results-row alt">
			<td>Sc Name<font color="red">*</font></td>
			<td><input class="required" maxlength="75"  name="<portlet:namespace/>scName" type="text" /></td>
		</tr>
		<tr class="portlet-section-body results-row">
			<td>Param Type<font color="red">*</font></td>
			<td><input class="required" maxlength="75"  name="<portlet:namespace/>paramType" type="text" /></td>
		</tr>
		<tr class="portlet-section-body results-row alt">
			<td>Param From<font color="red">*</font></td>
			<td><input class="required" maxlength="75"  name="<portlet:namespace/>paramFrom" type="text" /></td>
		</tr>
		<tr class="portlet-section-body results-row">
			<td>Param Upto<font color="red">*</font></td>
			<td><input class="required" maxlength="75"  name="<portlet:namespace/>paramUpto" type="text" /></td>
		</tr>
		<tr class="portlet-section-body results-row alt">
			<td>Duration<font color="red">*</font></td>
			<td><input class="required" maxlength="75"  name="<portlet:namespace/>duration" type="text" /></td>
		</tr>
		<tr class="portlet-section-body results-row">
			<td>Duration Type<font color="red">*</font></td>
			<td><input class="required" maxlength="75"  name="<portlet:namespace/>durationType" type="text" /></td>
		</tr>
		<tr class="portlet-section-body results-row alt">
			<td>Service Charges</td>
			<td><input name="<portlet:namespace/>serviceCharges" type="text"   /></td>
		</tr>
		<tr class="portlet-section-body results-row">
			<td>Service Charges Currency<font color="red">*</font></td>
			<td><input class="required" maxlength="75"  name="<portlet:namespace/>serviceChargesCurrency" type="text" /></td>
		</tr>
		<tr class="portlet-section-body results-row alt">
			<td>Service Charges Period<font color="red">*</font></td>
			<td><input class="required" maxlength="75"  name="<portlet:namespace/>serviceChargesPeriod" type="text" /></td>
		</tr>
		<tr class="portlet-section-body results-row">
			<td>Service Charges Period Type<font color="red">*</font></td>
			<td>
			<select class="required" name="<portlet:namespace/>serviceChargesPeriodType">
			<option></option>
			<option value="Weekly">Weekly</option>
			<option value="Monthly">Monthly</option>
			<option value="Yearly">Yearly</option>
			<option value="Hybrid">Hybrid</option>
			</select>
			</td>
		</tr>
		<tr class="portlet-section-body results-row alt">
			<td>Status<font color="red">*</font></td>
			<td>
			<select class="required" name="<portlet:namespace/>status">
			<option></option>
			<option value="Enable">enable</option>
			<option value="Disable">disable</option>
			</select>
			</td>
		</tr>
		<tr class="portlet-section-body results-row">
			<td>Description</td>
			<td><textarea cols="18" maxlength="75" name="<portlet:namespace/>description"  rows="4"></textarea></td>
		</tr>
	</table>

	<br />

	<table width="90%">
		<tr>
			<td width="5%"><input type="submit" value="Save"></td>
			<td><input onClick="location.href='<%= renderURL.toString() %>'" type="button" value="Cancel"></td>
		</tr>
	</table>
</form>