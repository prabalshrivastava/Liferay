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
	String toDate = renderRequest.getPreferences().getValue("toDate","");
	//String rightModel = renderRequest.getPreferences().getValue("rightModel","");
	
%>

<aui:row cssClass="ps-pref-container" style="margin:10px auto; max-width:640px">
	<aui:col span="12">
		<aui:form name="editPreferences" action="<%=savePreferencesActionURL%>">			
			<aui:input name="htmlFormIdPref" label="Load the form with this ID" value='<%=formId%>'></aui:input>
			<aui:input name="modelNamePref" label="Load the Listing for this Model" value='<%=modelName%>'></aui:input>
			<aui:input name="containerStylePref" label="Form Container Inline Style" value='<%=cStyle%>'></aui:input>
			<aui:input name="baseUrlPref" label="Base URL" value='<%=baseUrl%>'></aui:input>
			<aui:input name="toDate" label="To Date" value='<%=toDate%>'></aui:input>
			
			<aui:button-row>
				<aui:button name="saveButton" type="submit" value="label.save" />
				<aui:button type="cancel" onClick="<%=viewURL%>" />
			</aui:button-row>
		</aui:form>
	</aui:col>
</aui:row>