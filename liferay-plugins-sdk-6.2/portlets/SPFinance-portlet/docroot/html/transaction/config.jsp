<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>

<portlet:defineObjects />
<liferay-theme:defineObjects />

<portlet:actionURL var="savePreferencesActionURL" name="savePreferences">
</portlet:actionURL>
<portlet:renderURL portletMode="view" var="viewURL" />

<%
	String formId = renderRequest.getPreferences().getValue("htmlFormIdPref","");
	String cStyle = renderRequest.getPreferences().getValue("containerStylePref","");
	String baseUrl = renderRequest.getPreferences().getValue("baseUrlPref","");
	String modelName = renderRequest.getPreferences().getValue("modelNamePref","");
	String categoryType = renderRequest.getPreferences().getValue("categoryTypePref","");
	String listHeader = renderRequest.getPreferences().getValue("listHeaderPref","");
	String invoiceType = renderRequest.getPreferences().getValue("invoiceTypePref","");
	String sendNotification = renderRequest.getPreferences().getValue("sendNotificationPref","");
	String enableApproval = renderRequest.getPreferences().getValue("enableApprovalPref","");
	String showPending = renderRequest.getPreferences().getValue("showPendingPref", "");
%>

<aui:row cssClass="ps-pref-container" style="margin:10px auto; max-width:640px">
	<aui:col span="12">
		<aui:form name="editPreferences" action="<%=savePreferencesActionURL%>">			
			<aui:input name="categoryTypePref" label="Category Type" value='<%=categoryType%>'></aui:input>
			<aui:select cssClass="invoiceTypePref" name="invoiceTypePref" label="Invoice Type">
				<aui:option value="">Choose an Invoice Type</aui:option>
				<aui:option value="C">Corporate</aui:option>
				<aui:option value="I">Individual</aui:option>
				<aui:option value="BOTH">Both</aui:option>
			</aui:select>
			<aui:select cssClass="sendNotificationPref" name="sendNotificationPref" label="Notification">
				<aui:option value="enabled">Enabled</aui:option>
				<aui:option value="disabled">Disabled</aui:option>
			</aui:select>
			<aui:select cssClass="enableApprovalPref" name="enableApprovalPref" label="Enable Approval">
				<aui:option value="true">True</aui:option>
				<aui:option value="false">False</aui:option>
			</aui:select>
			<aui:select cssClass="showPendingPref" name="showPendingPref" label="Show Pending Invoices For Receipt">
				<aui:option value="true">True</aui:option>
				<aui:option value="false">False</aui:option>
			</aui:select>
			<aui:input name="listHeaderPref" label="List Header" value='<%=listHeader%>'></aui:input>
			<aui:input name="modelNamePref" label="Load the Listing for this Model" value='<%=modelName%>'></aui:input>
			<aui:input name="containerStylePref" label="Form Container Inline Style" value='<%=cStyle%>'></aui:input>
			<aui:input name="baseUrlPref" label="Base URL" value='<%=baseUrl%>'></aui:input>
			<aui:button-row>
				<aui:button name="saveButton" type="submit" value="label.save" />
				<aui:button type="cancel" onClick="<%=viewURL%>" />
			</aui:button-row>
		</aui:form>
	</aui:col>
</aui:row>
<script>
var sendNotification = "<%=sendNotification%>";
var enableApproval = "<%=enableApproval%>";
var showPending = "<%=showPending%>";
document.getElementsByClassName("invoiceTypePref")[0].value = "<%=invoiceType%>";
document.getElementsByClassName("sendNotificationPref")[0].value = sendNotification==""?"enabled":sendNotification;
document.getElementsByClassName("enableApprovalPref")[0].value = enableApproval==""?"true":enableApproval;
document.getElementsByClassName("showPendingPref")[0].value = showPending==""?"true":showPending;
</script>