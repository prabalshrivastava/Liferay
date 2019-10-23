<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<portlet:defineObjects />
<liferay-theme:defineObjects />

<portlet:actionURL var="savePreferencesActionURL" name="savePreferences">
</portlet:actionURL>
<portlet:renderURL portletMode="view" var="viewURL" />
<div class="sp-challenges-preferences max-width padding-left-75 padding-right-75 padding-top-one padding-bottom-one box-sizing-border">
	<aui:form name="editPreferences" action="<%=savePreferencesActionURL%>">
	
		<h2>Select <liferay-ui:message key="label.challenge.title" /> Vocabularies</h2>
		
		<aui:fieldset>
			<aui:select name="applicantTypeVocId"
				label="select-applicant-type-vocab">
				<c:forEach var="assetVocabulary" items="${assetVocabularies}">
					<aui:option value="${assetVocabulary.vocabularyId}"
						selected="${applicantTypeVocId == assetVocabulary.vocabularyId}"
						label="${assetVocabulary.name}" />
				</c:forEach>
			</aui:select>
	
			<aui:select name="challengeCategoryVocId"
				label="select-category-vocab">
				<c:forEach var="assetVocabulary" items="${assetVocabularies}">
					<aui:option value="${assetVocabulary.vocabularyId}"
						selected="${challengeCategoryVocId == assetVocabulary.vocabularyId}"
						label="${assetVocabulary.name}" />
				</c:forEach>
			</aui:select>
	
			<aui:select name="challengeTypeVocId"
				label="select-challenge-type-vocab">
				<c:forEach var="assetVocabulary" items="${assetVocabularies}">
					<aui:option value="${assetVocabulary.vocabularyId}"
						selected="${challengeTypeVocId == assetVocabulary.vocabularyId}"
						label="${assetVocabulary.name}" />
				</c:forEach>
			</aui:select>
			<aui:select name="regionTypeVocId" label="select-region-vocab">
				<c:forEach var="assetVocabulary" items="${assetVocabularies}">
					<aui:option value="${assetVocabulary.vocabularyId}"
						selected="${regionTypeVocId == assetVocabulary.vocabularyId}"
						label="${assetVocabulary.name}" />
				</c:forEach>
			</aui:select>
			
			<aui:select name="orgIncorporatedVocId"
				label="select-startup-incorp-vocab">
				<c:forEach var="assetVocabulary" items="${assetVocabularies}">
					<aui:option value="${assetVocabulary.vocabularyId}"
						selected="${orgIncorporatedVocId == assetVocabulary.vocabularyId}"
						label="${assetVocabulary.name}" />
				</c:forEach>
			</aui:select>
	
			<aui:select name="orgLifecycleStageVocId"
				label="Select Startup Lifecycle Stage Vocabulary">
				<c:forEach var="assetVocabulary" items="${assetVocabularies}">
					<aui:option value="${assetVocabulary.vocabularyId}"
						selected="${orgLifecycleStageVocId == assetVocabulary.vocabularyId}"
						label="${assetVocabulary.name}" />
				</c:forEach>
			</aui:select>
	
			<aui:select name="orgRaisingFundsVocId"
				label="Select Startup Raising Funds Vocabulary">
				<c:forEach var="assetVocabulary" items="${assetVocabularies}">
					<aui:option value="${assetVocabulary.vocabularyId}"
						selected="${orgRaisingFundsVocId == assetVocabulary.vocabularyId}"
						label="${assetVocabulary.name}" />
				</c:forEach>
			</aui:select>
			
			<aui:select name="challengeCollabVocId" label="Select Brief Collaboration Vocabulary">
				<c:forEach var="assetVocabulary" items="${assetVocabularies}">
					<aui:option value="${assetVocabulary.vocabularyId}"
						selected="${challengeCollabVocId == assetVocabulary.vocabularyId}"
						label="${assetVocabulary.name}" />
				</c:forEach>
			</aui:select>
			
			<aui:select name="orgCategoryVocId"
			label="select-startup-categ-vocab">
			<c:forEach var="assetVocabulary" items="${assetVocabularies}">
				<aui:option value="${assetVocabulary.vocabularyId}"
					selected="${orgCategoryVocId == assetVocabulary.vocabularyId}"
					label="${assetVocabulary.name}" />
			</c:forEach>
		</aui:select>
		
		<aui:select name="orgBenchmarkVocId"
				label="select-startup-benchmark-vocab">
				<c:forEach var="assetVocabulary" items="${assetVocabularies}">
					<aui:option value="${assetVocabulary.vocabularyId}"
						selected="${orgBenchmarkVocId == assetVocabulary.vocabularyId}"
						label="${assetVocabulary.name}" />
				</c:forEach>
			</aui:select>
			
			<aui:select name="orgCostBenchmarkVocId"
				label="select-startup-cost-benchmark-vocab">
				<c:forEach var="assetVocabulary" items="${assetVocabularies}">
					<aui:option value="${assetVocabulary.vocabularyId}"
						selected="${orgCostBenchmarkVocId == assetVocabulary.vocabularyId}"
						label="${assetVocabulary.name}" />
				</c:forEach>
			</aui:select>

		<aui:select name="brandVocId"
			label="select-brand-vocab">
			<c:forEach var="assetVocabulary" items="${assetVocabularies}">
				<aui:option value="${assetVocabulary.vocabularyId}"
					selected="${brandVocId == assetVocabulary.vocabularyId}"
					label="${assetVocabulary.name}" />
			</c:forEach>
		</aui:select>
			
			<div>
				<span>Brief Collaboration Categories: <span style='font-size:10px'>( In case,  challenge vocubalary changes to another vocabulary then below list of categories can be refreshed only after saving the 
				preferences and reopening it )</span></span>
				<br><br>
				<ul style='margin-left:20px'>
					<c:forEach var="cat" items="${challengeCollabCats }">
						<li>
							${cat.name }
							<ul>
								<li>
									<aui:input name="internal_${cat.id }" type="checkbox"  checked="${cat.internal}" label="Internal"></aui:input>
								</li>
								<li>
									<aui:input name="external_${cat.id }" type="checkbox" checked="${cat.external}" label="External"></aui:input>
								</li>
							</ul>
						</li>
					</c:forEach>
				</ul>
			</div>
		</aui:fieldset>
		
		<aui:input name="challengesHomePage" label="Brief Home URL Path" value="${challengesHomePage}"></aui:input>
	
		<aui:input name="challengesListPage" label="Briefs Listing URL Path" value="${challengesListPage}"></aui:input>

		<aui:input name="itemsPerPage" label="Items per Page" value="${itemsPerPage}"></aui:input>
	
		<aui:button-row>
			<aui:button name="saveButton" type="submit" value="Save" />
			<aui:button type="cancel" onClick="<%=viewURL%>" />
		</aui:button-row>
	</aui:form>
</div>