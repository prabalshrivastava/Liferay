<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<portlet:defineObjects />

<portlet:actionURL var="savePreferencesActionURL" name="savePreferences">
</portlet:actionURL>
<portlet:renderURL portletMode="view" var="viewURL" />

<aui:form name="editPreferences" action="<%=savePreferencesActionURL%>">

	<h2>Select <liferay-ui:message key="label.challenge.title" /> Vocabularies</h2>
	
	<aui:select name="challengeCategoryVocId"
		label="label.select.category.vocab">
		<c:forEach var="assetVocabulary" items="${assetVocabularies}">
			<aui:option value="${assetVocabulary.vocabularyId}"
				selected="${challengeCategoryVocId == assetVocabulary.vocabularyId}"
				label="${assetVocabulary.name}" />
		</c:forEach>
	</aui:select>

	<aui:input name="itemsPerPage" label="Items per Page" value="${itemsPerPage}"></aui:input>

	<aui:button-row>
		<aui:button name="saveButton" type="submit" value="Save" />
		<aui:button type="cancel" onClick="<%=viewURL%>" />
	</aui:button-row>
</aui:form>