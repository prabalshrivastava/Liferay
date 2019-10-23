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
	String baseUrl = renderRequest.getPreferences().getValue("baseUrlPref","");
	String receiptBaseUrl = renderRequest.getPreferences().getValue("receiptBaseUrlPref","");
	String payOnlineBaseUrl = renderRequest.getPreferences().getValue("payOnlineBaseUrlPref","");
%>

<aui:row cssClass="ps-pref-container" style="margin:10px auto; max-width:640px">
	<aui:col span="12">
		<aui:form name="editPreferences" action="<%=savePreferencesActionURL%>">			
			<aui:input name="baseUrlPref" label="Base URL" value='<%=baseUrl%>'></aui:input>
			<aui:input name="receiptBaseUrlPref" label="Receipt Base URL" value='<%=receiptBaseUrl%>'></aui:input>
			<aui:input name="payOnlineBaseUrlPref" label="Pay Online Base URL" value='<%=payOnlineBaseUrl%>'></aui:input>
			<aui:button-row>
				<aui:button name="saveButton" type="submit" value="label.save" />
				<aui:button type="cancel" onClick="<%=viewURL%>" />
			</aui:button-row>
		</aui:form>
	</aui:col>
</aui:row>