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
String blogPageName = portletPreferences.getValue("blogPageName", "spblogs");
String groupDetailPageName = portletPreferences.getValue("groupDetailPageName", "group-detail");
String groupDiscussionDetailPageName = portletPreferences.getValue("groupDiscussionDetailPageName", "discussion-detail");
String eventDetailPageName = portletPreferences.getValue("eventDetailPageName", "event-details");
String spAssetEntryDetailPageName = portletPreferences.getValue("spAssetEntryDetailPageName", "spassetentry");
%>

<aui:form action="<%= editActionURL %>" method="post" name="fm" onSubmit='<%= "event.preventDefault();" %>'>
	<aui:input label="Name of Blog Page" name="blogPageName" value="<%= blogPageName %>" />
	<aui:input label="Name of Group Detail Page" name="groupDetailPageName" value="<%= groupDetailPageName %>" />
	<aui:input label="Name of Group Discussion Detail Page" name="groupDiscussionDetailPageName" value="<%= groupDiscussionDetailPageName %>" />
	<aui:input label="Name of Event Detail Page" name="eventDetailPageName" value="<%= eventDetailPageName %>" />
	<aui:input label="Name of Asset Entry Detail Page" name="spAssetEntryDetailPageName" value="<%= spAssetEntryDetailPageName %>" />
	<br /><br />
	<aui:button name="saveButton" onClick='<%= renderResponse.getNamespace() + "saveConfigurations();" %>' type="submit" value="Save Changes" />
</aui:form>

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