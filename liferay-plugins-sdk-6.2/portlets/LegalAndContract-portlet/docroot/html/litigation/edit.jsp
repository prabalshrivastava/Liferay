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
<portlet:actionURL var="sendMailsActionURL" name="sendMailsForRoles">
</portlet:actionURL>
<portlet:actionURL var="sendMailsToUsersHavingPermissionsURL" name="sendMailsToUsersHavingPermissions">
</portlet:actionURL>
<portlet:renderURL portletMode="view" var="viewURL" />
<aui:form name="editPreferences" action="<%=savePreferencesActionURL%>">
	<aui:fieldset>
		<aui:select name="proceedingTypeVocId" label="Proceedings">
			<c:forEach var="assetVocabulary" items="${assetVocabularies}">
				<aui:option value=" ${assetVocabulary.vocabularyId}"
					selected="${proceedingTypeVocId == assetVocabulary.vocabularyId}"
					label="${assetVocabulary.name}" />
			</c:forEach>
		</aui:select>
		<aui:select name="alertBeforeVocId" label="Alert Before">
			<c:forEach var="assetVocabulary" items="${assetVocabularies}">
				<aui:option value=" ${assetVocabulary.vocabularyId}"
					selected="${alertBeforeVocId == assetVocabulary.vocabularyId}"
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
		<aui:select name="customList3VocId" label="Custom List 2">
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
<aui:form name="sendMails" action="<%=sendMailsActionURL%>">
	<aui:input name="roleNames" label="Rola Names (Comma Separated)"></aui:input>
	<aui:button name="Send Mails" type="submit"
		value="Send Mails to given roles" />
	<aui:button name="Trigger Mails" onClick="<%=sendMailsToUsersHavingPermissionsURL %>" value="Send Mails To Users Having Permissions (Above roles names will not be considered. Users having Permissions will get mails.)"/>	
</aui:form>