<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ page import="com.liferay.portal.kernel.util.GetterUtil" %>

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
String jobTypeVocabularyId = portletPreferences.getValue("jobTypeVocabularyId", "0");
String jobLocationVocabularyId = portletPreferences.getValue("jobLocationVocabularyId", "0");
String yoeVocabularyId = portletPreferences.getValue("yoeVocabularyId", "0");
String assetCategoriesVocabularyId = portletPreferences.getValue("assetCategoriesVocabularyId", "0");

String spJobImageMaxSize = portletPreferences.getValue("spJobImageMaxSize", "307200");
String spJobImageExtensions = portletPreferences.getValue("spJobImageExtensions", ".gif,.jpeg,.jpg,.png");
String spJobDetailPageName = portletPreferences.getValue("spJobDetailPageName", "job-detail");

String spJobPostNotiTemplateId = portletPreferences.getValue("spJobPostNotiTemplateId", "0");
boolean enableNotificationTo = GetterUtil.getBoolean(portletPreferences.getValue("enableNotificationTo", "false"));
%>

<h1 style="padding-bottom: 15px; border-bottom: 1px solid #DDDDDD; margin: 0;">Configurations</h1>

<aui:form action="<%= editActionURL %>" method="post" name="fm" onSubmit='<%= "event.preventDefault();" %>'>

	<div style="padding: 20px;">
		<br />
		<aui:input label="Job Type Vocabulary Id" name="jobTypeVocabularyId" placeholder="Find id from below section" value="<%= jobTypeVocabularyId %>" />
		<br />
		<aui:input label="Job Location Vocabulary Id" name="jobLocationVocabularyId" placeholder="Find id from below section" value="<%= jobLocationVocabularyId %>" />
		<br />
		<aui:input label="Years of Experience Vocabulary Id" name="yoeVocabularyId" placeholder="Find id from below section" value="<%= yoeVocabularyId %>" />
		<br />
		<aui:input label="Asset Categories Vocabulary Id" name="assetCategoriesVocabularyId" placeholder="Find id from below section" value="<%= assetCategoriesVocabularyId %>" />
		<br />
		<aui:input label="Group Image Max Size" name="spJobImageMaxSize" value="<%= spJobImageMaxSize %>" />
		<br />
		<aui:input label="Group Image Extensions" name="spJobImageExtensions" value="<%= spJobImageExtensions %>" />
		<br />
		<aui:input label="Name of Group Detail Page" name="spJobDetailPageName" value="<%= spJobDetailPageName %>" />

		<aui:input label="Post Job Notification Template Id" name="spJobPostNotiTemplateId" value="<%= spJobPostNotiTemplateId %>" />
		<br>
		<aui:input checked="<%= enableNotificationTo %>" label="Enable Notification To" name="enableNotificationTo" type="checkbox"> </aui:input>
	</div>

	<aui:button name="saveButton" onClick='<%= renderResponse.getNamespace() + "saveConfigurations();" %>' type="submit" value="Save" />

</aui:form>

<br />
<br />
<div style="font-size: 15px; padding-bottom: 10px; border-bottom: 1px solid #DDDDDD;">Asset Vocabularies ( name: id )</div>
<div style="padding: 20px;">
	<c:out value="${assetVocabulariesString}"></c:out>
</div>
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