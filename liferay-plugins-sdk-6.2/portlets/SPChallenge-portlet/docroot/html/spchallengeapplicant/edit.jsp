<%@page import="com.sambaash.platform.spchallenge.helper.SPChallengeConstants"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<portlet:defineObjects />

<div>
	<span>Preferences</span>
</div>
<%
	String viewMode = portletPreferences.getValue(
	SPChallengeConstants.VOC_VIEW_MODE, SPChallengeConstants.VOC_VIEW_SLIDER);
	String itemsPerPage = portletPreferences.getValue(
		SPChallengeConstants.VOC_ITEMS_PER_PAGE, "3");
%>
<portlet:actionURL var="savePreferencesActionURL" name="savePreferences">
</portlet:actionURL>
<portlet:renderURL portletMode="view" var="viewURL" />

<aui:form name="editPreferences" action="<%=savePreferencesActionURL%>">
	<div class="">

		<aui:input name="viewMode"
			label="Please select view mode('List' or 'Slider')"
			value="<%=viewMode%>"></aui:input>
			
			
		<aui:input name="itemsPerPage"
			label="Items per page(for Slider only)"
			value="<%=itemsPerPage%>"></aui:input>	

		<aui:button-row>
			<aui:button name="saveButton" type="submit" value="Save" />
			<aui:button type="cancel" onClick="<%=viewURL%>" />
		</aui:button-row>

	</div>
</aui:form>