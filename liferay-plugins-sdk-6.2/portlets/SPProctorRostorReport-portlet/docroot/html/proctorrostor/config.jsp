<%@page import="com.sambaash.platform.util.SambaashUtil"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/security"
	prefix="liferay-security"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util"%>

<script type="text/javascript"
	src="/html/js/sp/hook.js?<%=System.currentTimeMillis()%>"
	language="javascript1.2""></script>
<link rel='stylesheet' href='/html/css/hook.css?minifierType=css'><link rel='stylesheet' type="text/css"
	href='<%=request.getContextPath()%>/css/formio.full.min.css?minifierType=css'>
<link rel='stylesheet' type="text/css"
	href='<%=request.getContextPath()%>/css/portlet.css?minifierType=css'></link>
<link rel='stylesheet' type="text/css"
	href='<%=request.getContextPath()%>/css/main.css?minifierType=css'></link>
<script type="text/javascript"
	src="/html/js/sp/hook.js?<%=System.currentTimeMillis()%>"
	language="javascript1.2""></script>


<portlet:defineObjects />
<liferay-theme:defineObjects />
<portlet:resourceURL var="ajaxUrl">

</portlet:resourceURL>

<portlet:actionURL var="savePreferencesActionURL" name="savePreferences">
</portlet:actionURL>
<portlet:renderURL portletMode="view" var="viewURL" />

<%
	String formId = renderRequest.getPreferences().getValue(
	"htmlFormIdPref", "");
	String cStyle = renderRequest.getPreferences().getValue(
	"containerStylePref", "");
	String baseUrl = renderRequest.getPreferences().getValue(
	"baseUrlPref", "");
	String modelName = renderRequest.getPreferences().getValue(
	"modelNamePref", "");
%>

<aui:row cssClass="ps-pref-container"
	style="margin:10px auto; max-width:640px">
	<aui:col span="12">
		<aui:form name="editPreferences"
			action="<%=savePreferencesActionURL%>">

			<aui:input name="modelNamePref"
				label="Load the Listing for this Model" value='<%=modelName%>'></aui:input>
			<aui:input name="containerStylePref"
				label="Form Container Inline Style" value='<%=cStyle%>'></aui:input>
			<aui:input name="baseUrlPref" label="Base URL" value='<%=baseUrl%>'></aui:input>
           
			<aui:button-row>
				<aui:button name="saveButton" type="submit" value="label.save" />
				<aui:button type="cancel" onClick="<%=viewURL%>" />
			</aui:button-row>


		</aui:form>
	</aui:col>
</aui:row>



