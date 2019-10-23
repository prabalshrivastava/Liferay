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

<portlet:actionURL var="populateExistingDataURL">
	<portlet:param name="action" value="populateExistingData"></portlet:param>
</portlet:actionURL>

<aui:form action="<%= populateExistingDataURL %>" method="post" name="fm2" onSubmit='<%= "event.preventDefault();" %>'>
	<aui:button name="saveButton" onClick='<%= renderResponse.getNamespace() + "populateExistingData();" %>' type="submit" value="Populate Existing Data" />
</aui:form>

<aui:script>

	Liferay.provide(
		window,
		'<portlet:namespace />populateExistingData',
		function() {
			var A = AUI();
			if (confirm("Are you sure you wanna populate the existing data!")) {
				submitForm(document.<portlet:namespace />fm2);
			}
		}
	);

</aui:script>