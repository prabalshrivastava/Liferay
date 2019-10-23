<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%@ page import="com.liferay.portal.kernel.util.Constants" %>

<portlet:defineObjects />

<liferay-theme:defineObjects />

<portlet:actionURL var="editActionURL">
	<portlet:param name="action" value="<%= Constants.EDIT %>"></portlet:param>
</portlet:actionURL>

<%
String spJobDetailPageName = portletPreferences.getValue("spJobDetailPageName", "job-detail");
String spJobAppNotiTemplateIdForPoster = portletPreferences.getValue("spJobAppNotiTemplateIdForPoster", "0");
String spJobAppNotiTemplateIdForApplicant = portletPreferences.getValue("spJobAppNotiTemplateIdForApplicant", "0");
%>

<h1 style="padding-bottom: 15px; border-bottom: 1px solid #DDDDDD; margin: 0;">Configurations</h1>

<aui:form action="<%= editActionURL %>" method="post" name="fm" onSubmit='<%= "event.preventDefault();" %>'>

	<div style="padding: 20px;">
		<br />
		<aui:input label="Name of Group Detail Page" name="spJobDetailPageName" value="<%= spJobDetailPageName %>" />
		<br />
		<aui:input label="Job Application Notification Template Id for Poster" name="spJobAppNotiTemplateIdForPoster" value="<%= spJobAppNotiTemplateIdForPoster %>" />
		<br />
		<aui:input label="Job Application Notification Template Id for Applicant" name="spJobAppNotiTemplateIdForApplicant" value="<%= spJobAppNotiTemplateIdForApplicant %>" />
	</div>

	<aui:button name="saveButton" onClick='<%= renderResponse.getNamespace() + "saveConfigurations();" %>' type="submit" value="Save" />

</aui:form>

<br />

<aui:script>

	Liferay.provide(
		window,
		'<portlet:namespace />saveConfigurations',
		function() {
			var A = AUI();

			submitForm(document.<portlet:namespace />fm);
		}
	);

</aui:script>