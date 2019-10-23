<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<portlet:defineObjects />
<liferay-theme:defineObjects />

<portlet:actionURL var="savePreferencesActionURL" name="savePreferences">
</portlet:actionURL>
<portlet:renderURL portletMode="view" var="viewURL" />

<aui:form name="editPreferences" action="<%=savePreferencesActionURL%>">
	<aui:fieldset>
		<aui:select name="countryVocId" label="Law Firm Country">
			<c:forEach var="assetVocabulary" items="${assetVocabularies}">
				<aui:option value=" ${assetVocabulary.vocabularyId}"
					selected="${countryVocId == assetVocabulary.vocabularyId}"
					label="${assetVocabulary.name}" />
			</c:forEach>
		</aui:select>
		<aui:select name="typeVocId" label="Law Firm Type">
			<c:forEach var="assetVocabulary" items="${assetVocabularies}">
				<aui:option value="${assetVocabulary.vocabularyId}"
					selected="${typeVocId == assetVocabulary.vocabularyId}"
					label="${assetVocabulary.name}" />
			</c:forEach>
		</aui:select>
		<aui:select name="customList1VocId" label="Custom List 1">
			<c:forEach var="assetVocabulary" items="${assetVocabularies}">
				<aui:option value="${assetVocabulary.vocabularyId}"
					selected="${customList1VocId == assetVocabulary.vocabularyId}"
					label="${assetVocabulary.name}" />
			</c:forEach>
		</aui:select>
		<aui:select name="customList2VocId" label="Custom List 2">
			<c:forEach var="assetVocabulary" items="${assetVocabularies}">
				<aui:option value="${assetVocabulary.vocabularyId}"
				    selected="${customList2VocId == assetVocabulary.vocabularyId}"
					label="${assetVocabulary.name}" />
			</c:forEach>
		</aui:select>
		<aui:select name="customList3VocId" label="Custom List 3">
			<c:forEach var="assetVocabulary" items="${assetVocabularies}">
				<aui:option value="${assetVocabulary.vocabularyId}"
					selected="${customList3VocId == assetVocabulary.vocabularyId}"
					label="${assetVocabulary.name}" />
			</c:forEach>
		</aui:select>
		
		<aui:button-row>
			<aui:button name="saveButton" type="submit" value="Save" />
			<aui:button type="cancel" onClick="<%= viewURL %>" />
		</aui:button-row>
	</aui:fieldset>
</aui:form>