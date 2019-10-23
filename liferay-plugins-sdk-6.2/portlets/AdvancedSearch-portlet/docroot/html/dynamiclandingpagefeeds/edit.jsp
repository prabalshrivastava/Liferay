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

<portlet:resourceURL id="myResourceID01" var="ajaxUrl">
</portlet:resourceURL>
<div id="RoleMapping_contents">

	<div class="maindiv" style="margin-bottom:20px">
		<div class="search-stream-style2UI-content-title">
			Select Search Priority
			<div class="seperatedline"></div>
		</div>
		<form action="<%= editActionURL %>" method="post"  name="categoriesMappingForm">
			<div>
				<div>Feed Search Criteria</div>
					<input type="radio" id='countryDeparment' name="<portlet:namespace />feedSearchCriteria" value="countryRegion" ${countryRegion} style="margin: 0 10px 10px 0;">Country or Region<br>
						<div id="cdDiv" class="maindivpersonalInfo search-stream-style2UI-content-desc">
							<input type="radio" name="<portlet:namespace />searchPriority" value="country" ${country} style="margin: 0 10px 10px 10px;">Search by Country first<br>
							<input type="radio" name="<portlet:namespace />searchPriority" value="region" ${region} style="margin: 0 10px 10px 10px;">Search by Region first<br>
						</div>
					<input type="radio" id='custom' name="<portlet:namespace />feedSearchCriteria" value="custom" ${custom} style="margin: 0 10px 10px 0;" >Custom Value<br>
						<div id="criteriaDiv" style='display:none'>
								<select name="<portlet:namespace />feedSearchVocId" id="feedSearchVocId">
									<c:forEach var="assetVocabulary" items="${assetVocabularies}">
									  <c:if test="${feedSearchVocId == assetVocabulary.vocabularyId}">
										<option value="${assetVocabulary.vocabularyId}"
											selected>${assetVocabulary.name}</option>
									  </c:if>
									  <c:if test="${feedSearchVocId != assetVocabulary.vocabularyId}">
										<option value="${assetVocabulary.vocabularyId}"
											>${assetVocabulary.name}</option>
									  </c:if>
									</c:forEach>
								</select>
								<select id="feedSearchCatId" name="<portlet:namespace />feedSearchCatId">
								</select>
						</div>
				
			</div>
			
			<div style="font-size: 1.3em; letter-spacing: 2px; line-height: 1.5em; overflow: hidden;">
				<div style="margin-bottom:10px">
					<b>Enter page name for Events</b>
					<input type="text" name="<portlet:namespace />eventsPageUrl" id="eventsPageUrl" value="${eventsPageUrl }">
				</div>
				<div style="margin-bottom:10px">
					<b>Enter page name for Media</b>
					<input type="text" name="<portlet:namespace />mediaPageUrl" id="mediaPageUrl" value="${mediaPageUrl }">
				</div>
				<div style="margin-bottom:10px">	
					<b>Enter page name for Blogs</b>
					<input type="text" name="<portlet:namespace />blogsPageUrl" id="blogsPageUrl" value="${blogsPageUrl }">
				</div>	
				<div style="margin-bottom:10px">	
					<b>Enter page name for Group Detail</b>
					<input type="text" name="<portlet:namespace />groupDetailPageName" id="groupDetailPageName" value="${groupDetailPageName }">
				</div>	
				<div style="margin-bottom:10px">	
					<b>Enter page name for Discussion Detail</b>
					<input type="text" name="<portlet:namespace />dscDetailPageName" id="dscDetailPageName" value="${dscDetailPageName }">
				</div>	
				<div style="margin-bottom:10px">	
					<b>Enter page name for Document Library</b>
					<input type="text" name="<portlet:namespace />docLibPageName" id="docLibPageName" value="${docLibPageName }">
				</div>	
			</div>
			<c:if test="${empty noFilter}">
				<div>
					<input type="submit" value="Save">
	 			</div>
 			</c:if>
		</form>
	</div>
	
</div>
<script type="text/javascript" src="/AdvancedSearch-portlet/js/main.js" >
</script>

<script type="text/javascript">
var ajaxurl = '<%= ajaxUrl %>';
onchangeVocs(ajaxurl);
fillCats("",ajaxurl,'${feedSearchCatId}');
criteriaClickListener();
showHideCriteriaDiv();
//setCatgSelected()
</script>
