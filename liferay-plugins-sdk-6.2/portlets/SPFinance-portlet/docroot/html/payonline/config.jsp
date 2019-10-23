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
	String cStyle = renderRequest.getPreferences().getValue("containerStylePref","");
	String baseUrl = renderRequest.getPreferences().getValue("baseUrlPref","");
	String modelName = renderRequest.getPreferences().getValue("modelNamePref","");
	String isNotify = renderRequest.getPreferences().getValue("isNotifyPref","");
	String emailAddresses = renderRequest.getPreferences().getValue("emailAddressesPref","");
	
%>

<aui:row cssClass="ps-pref-container" style="margin:10px auto; max-width:640px">
	<aui:col span="12">
		<aui:form name="editPreferences" action="<%=savePreferencesActionURL%>">			
			<aui:input name="containerStylePref" label="Form Container Inline Style" value='<%=cStyle%>'></aui:input>
			<aui:input name="baseUrlPref" label="Base URL" value='<%=baseUrl%>'></aui:input>
			<aui:select cssClass="isNotifyPref" name="isNotifyPref" label="Notification">
				<aui:option value="disabled">Disabled</aui:option>
				<aui:option value="enabled">Enabled</aui:option>
			</aui:select>
			<aui:input name="emailAddressesPref" label="Email Addresses" value='<%=emailAddresses%>'></aui:input>
			<aui:button-row>
				<aui:button name="saveButton" type="submit" value="label.save" />
				<aui:button type="cancel" onClick="<%=viewURL%>" />
			</aui:button-row>
		</aui:form>
	</aui:col>
</aui:row>

<script>
var isNotify = "<%=isNotify%>";
document.getElementsByClassName("isNotifyPref")[0].value = isNotify==""?"disabled":isNotify;
</script>