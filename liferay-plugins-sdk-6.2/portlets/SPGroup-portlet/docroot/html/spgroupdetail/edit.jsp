<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%@ page import="com.liferay.portal.kernel.util.Constants" %>
<%@ page import="com.liferay.portal.kernel.util.StringPool" %>

<portlet:defineObjects />

<liferay-theme:defineObjects />

<portlet:actionURL var="editActionURL">
	<portlet:param name="action" value="<%= Constants.EDIT %>"></portlet:param>
</portlet:actionURL>

<%
String twShareText = portletPreferences.getValue("twShareText", StringPool.BLANK);
String gplusShareText = portletPreferences.getValue("gplusShareText", StringPool.BLANK);
String googleClientId = portletPreferences.getValue("googleClientId", StringPool.BLANK);
String groupDetailPageName = portletPreferences.getValue("groupDetailPageName", "group-detail");
String groupCreatePageName = portletPreferences.getValue("groupCreatePageName", "create-group");
%>

<h1>Configurations</h1>

<aui:form action="<%= editActionURL %>" method="post" name="fm" onSubmit='<%= "event.preventDefault();" %>'>

	<div style="font-size: 15px; padding-bottom: 10px; border-bottom: 1px solid #DDDDDD;">Invite Friends</div>

	<div style="padding: 20px;">
		<aui:input cssClass="spgroup-full-width spgroup-textarea-height" label="Twitter Share Text" name="twShareText" type="textarea" value="<%= twShareText %>" />
		<aui:input cssClass="spgroup-full-width spgroup-textarea-height" label="Google+ Share Text" name="gplusShareText" type="textarea" value="<%= gplusShareText %>" />
		<aui:input cssClass="spgroup-full-width"  lable="Google Client ID" name="googleClientId" value="<%= googleClientId %>" />
		<aui:input label="Name of Group Detail Page" name="groupDetailPageName" value="<%= groupDetailPageName %>" />
		<aui:input label="Name of Group Create Page" name="groupCreatePageName" value="<%= groupCreatePageName %>" />
	</div>

	<aui:button name="saveButton" onClick='<%= renderResponse.getNamespace() + "saveConfigurations();" %>' type="submit" value="Save" />

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