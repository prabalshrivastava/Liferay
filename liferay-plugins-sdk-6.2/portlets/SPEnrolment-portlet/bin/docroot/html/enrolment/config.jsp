<%@page import="com.sambaash.platform.enrolement.EnrolmentConstants"%>
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
	String candidateFormId = renderRequest.getPreferences().getValue(EnrolmentConstants.PREF_CANDIDATE_FORM_ID,EnrolmentConstants.DEFAULT_CANDIDATE_FORM_ID);
	String enrolmentFormId = renderRequest.getPreferences().getValue(EnrolmentConstants.PREF_ENROLMENT_FORM_ID,EnrolmentConstants.DEFAULT_ENROLMENT_FORM_ID);
	String cStyle = renderRequest.getPreferences().getValue("containerStylePref","");
	String baseUrl = renderRequest.getPreferences().getValue("baseUrlPref","");
	String cancelUrl = renderRequest.getPreferences().getValue(EnrolmentConstants.DEFAULT_ENROLMENT_CANCEL_URL,EnrolmentConstants.DEFAULT_ENROLMENT_CANCEL_URL);
	String collectPaymentBaseUrl = renderRequest.getPreferences().getValue("collectPaymentBaseUrlPref","");
	String modelName = renderRequest.getPreferences().getValue("modelNamePref","");
	
%>

<aui:row cssClass="ps-pref-container" style="margin:10px auto; max-width:640px">
	<aui:col span="12">
		<aui:form name="editPreferences" action="<%=savePreferencesActionURL%>">			
			<aui:input name="<%=EnrolmentConstants.PREF_CANDIDATE_FORM_ID%>" label="Candidate Form ID" value='<%=candidateFormId%>'></aui:input>
			<aui:input name="<%=EnrolmentConstants.PREF_ENROLMENT_FORM_ID%>" label="Enrolment Form ID" value='<%=enrolmentFormId%>'></aui:input>
			<aui:input name="modelNamePref" label="Load the Listing for this Model" value='<%=modelName%>'></aui:input>
			<aui:input name="containerStylePref" label="Form Container Inline Style" value='<%=cStyle%>'></aui:input>
			<aui:input name="baseUrlPref" label="Listing Page URL" value='<%=baseUrl%>'></aui:input>
			<aui:input name="<%=EnrolmentConstants.PREF_ENROLMENT_CANCEL_URL%>" label="Cancel URL" value='<%=baseUrl%>'></aui:input>
			<aui:input name="collectPaymentBaseUrlPref" label="Collect Payment URL" value='<%=collectPaymentBaseUrl%>'></aui:input>
			<aui:button-row>
				<aui:button name="saveButton" type="submit" value="label.save" />
				<aui:button type="cancel" onClick="<%=viewURL%>" />
			</aui:button-row>
		</aui:form>
	</aui:col>
</aui:row>