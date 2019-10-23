<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%@ page import="com.liferay.portal.kernel.util.Constants" %>

<portlet:defineObjects />

<liferay-theme:defineObjects />

<h1>Advanced Search Configurations</h1>
<br />

<portlet:actionURL var="editActionURL">
	<portlet:param name="action" value="<%= Constants.EDIT %>"></portlet:param>
</portlet:actionURL>

<h3>Asset Vocabulary Detail ( name: id; )</h3>
<br />
<c:out value="${assetVocabulariesString}"></c:out>
<br />
<br />
<form action="<%= editActionURL %>" method="post">
	<ul>
		<c:forEach items="${availablePortletWrappers}" var="availablePortletWrapper">
			<li class="as-stream-edit-row">
				<div class="as-stream-edit-col1">
					<c:out value="${availablePortletWrapper.portletTitle}"></c:out>:
					<br/>
					<input name="<portlet:namespace />${availablePortletWrapper.portletId}_label" placeholder="New Lable" type="text" value="${availablePortletWrapper.portletIdLabel}"/>
					<br/>
					Disabled: <input type="checkbox" name="<portlet:namespace />${availablePortletWrapper.portletId}_disabled" <c:if test="${availablePortletWrapper.disabled == 'true'}"><c:out value="checked=\"checked\""></c:out></c:if> value="true" />
				</div>
				<textarea name="<portlet:namespace />${availablePortletWrapper.portletId}" rows="" cols="">${availablePortletWrapper.searchFieldsJson}</textarea>
			</li>
		</c:forEach>
		<li class="as-stream-edit-row">
			<span class="as-stream-edit-col1">Show Image:</span>
			<input type="checkbox" name="<portlet:namespace />isShowImage" <c:if test="${isShowImage == 'true'}"><c:out value="checked=\"checked\""></c:out></c:if> value="true" class="as-stream-edit-col2"/>
		</li>
		<li class="as-stream-edit-row">
			<span class="as-stream-edit-col1">Show Title:</span>
			<input type="checkbox" name="<portlet:namespace />isShowTitle" <c:if test="${isShowTitle == 'true'}"><c:out value="checked=\"checked\""></c:out></c:if> value="true" class="as-stream-edit-col2" />
			<input type="text" name="<portlet:namespace />titleMaxLength" value="${titleMaxLength}" size="5" />
		</li>
		<li class="as-stream-edit-row">
			<span class="as-stream-edit-col1">Show Content:</span>
			<input type="checkbox" name="<portlet:namespace />isShowContent" <c:if test="${isShowContent == 'true'}"><c:out value="checked=\"checked\""></c:out></c:if> value="true" class="as-stream-edit-col2" />
			<input type="text" name="<portlet:namespace />contentMaxLength" value="${contentMaxLength}" size="5" />
		</li>
		<li class="as-stream-edit-row">
			<span class="as-stream-edit-col1">Show Author:</span>
			<input type="checkbox" name="<portlet:namespace />isShowAuthor" <c:if test="${isShowAuthor == 'true'}"><c:out value="checked=\"checked\""></c:out></c:if> value="true" class="as-stream-edit-col2"/>
		</li>
		<li class="as-stream-edit-row">
			<span class="as-stream-edit-col1">Page Items:</span>
			<input type="text" name="<portlet:namespace />pageItems" value="${pageItems}" size="5" />
		</li>
		<li class="search-stream-edit-row">
			<span class="as-stream-edit-col1">Listing Style:</span>
			<select name="<portlet:namespace />listingStyle">
				<option value="vertical" <c:if test="${listingStyle == 'vertical'}"><c:out value="selected=\"selected\""></c:out></c:if> >Vertical</option>
				<option value="horizontal" <c:if test="${listingStyle == 'horizontal'}"><c:out value="selected=\"selected\""></c:out></c:if> >Horizontal</option>
				<option value="fullhorizontal" <c:if test="${listingStyle == 'fullhorizontal'}"><c:out value="selected=\"selected\""></c:out></c:if> >Full-Horizontal</option>
				<option value="horizontal-custom-rect" <c:if test="${listingStyle == 'hz-cust-rect'}"><c:out value="selected=\"selected\""></c:out></c:if> >Horizontal Rectangle</option>
				<option value="horizontal-custom-round" <c:if test="${listingStyle == 'hz-cust-round'}"><c:out value="selected=\"selected\""></c:out></c:if> >Horizontal Round</option>
			</select>
		</li>
		<!--  added to include profile user based on Marketer / Mentor search criteria -->
		<li class="as-stream-edit-row">
			<span class="as-stream-edit-col1">Show Marketers only</span>
			<input type="checkbox" name="<portlet:namespace />isProfileType1" <c:if test="${isProfileType1 == 'true'}"><c:out value="checked=\"checked\""></c:out></c:if> value="true" class="as-stream-edit-col2"/>
		</li>
		<li class="as-stream-edit-row">
			<span class="as-stream-edit-col1">Show Mentors only</span>
			<input type="checkbox" name="<portlet:namespace />isProfileType2" <c:if test="${isProfileType2 == 'true'}"><c:out value="checked=\"checked\""></c:out></c:if> value="true" class="as-stream-edit-col2"/>
		</li>
		<!-- ** / ** -->
		<li class="as-stream-edit-row">
			<span class="as-stream-edit-col1">Default Component:</span>
			<select name="<portlet:namespace />defaultSelectedPortletId">
				<option value=""></option>
				<c:forEach items="${availablePortletWrappers}" var="availablePortletWrapper">
					<option value="${availablePortletWrapper.portletId}" <c:if test="${availablePortletWrapper.portletId == defaultSelectedPortletId}">selected="selected"</c:if> >
						<c:choose>
							<c:when test="${availablePortletWrapper.portletIdLabel == null || empty availablePortletWrapper.portletIdLabel}">
								${availablePortletWrapper.portletTitle}
							</c:when>
							<c:otherwise>
								${availablePortletWrapper.portletIdLabel}
							</c:otherwise>
						</c:choose>
					</option>
				</c:forEach>
			</select>
		</li>
		<li class="as-stream-edit-row">
			<span class="as-stream-edit-col1">Disable component selector:</span>
			<input type="checkbox" name="<portlet:namespace />disableComponentSelector" <c:if test="${disableComponentSelector == 'true'}"><c:out value="checked=\"checked\""></c:out></c:if> value="true" class="as-stream-edit-col2"/>
		</li>
		<li class="as-stream-edit-row">
			<span class="as-stream-edit-col1">Enable auto search:</span>
			<input type="checkbox" name="<portlet:namespace />enableAutoSearch" <c:if test="${enableAutoSearch == 'true'}"><c:out value="checked=\"checked\""></c:out></c:if> value="true" class="as-stream-edit-col2"/>
		</li>
		<li class="as-stream-edit-row">
			<span class="as-stream-edit-col1">Hide search bar:</span>
			<input type="checkbox" name="<portlet:namespace />hideSearchBar" <c:if test="${hideSearchBar == 'true'}"><c:out value="checked=\"checked\""></c:out></c:if> value="true" class="as-stream-edit-col2"/>
		</li>
		<li class="as-stream-edit-row">
			<span class="as-stream-edit-col1">Hide results bar:</span>
			<input type="checkbox" name="<portlet:namespace />hideResultsBar" <c:if test="${hideResultsBar == 'true'}"><c:out value="checked=\"checked\""></c:out></c:if> value="true" class="as-stream-edit-col2"/>
		</li>
		<li class="as-stream-edit-row">
			<span class="as-stream-edit-col1">Hide search bar header:</span>
			<input type="checkbox" name="<portlet:namespace />hideSearchBarHeader" <c:if test="${hideSearchBarHeader == 'true'}"><c:out value="checked=\"checked\""></c:out></c:if> value="true" class="as-stream-edit-col2"/>
		</li>
		<li class="as-stream-edit-row">
			<span class="as-stream-edit-col1">Show advanced search button:</span>
			<input type="checkbox" name="<portlet:namespace />showAdvancedSearchBtn" <c:if test="${showAdvancedSearchBtn == 'true'}"><c:out value="checked=\"checked\""></c:out></c:if> value="true" class="as-stream-edit-col2"/>
		</li>
		<li class="as-stream-edit-row">
			<span class="as-stream-edit-col1">Open detail page on a new tab:</span>
			<input type="checkbox" name="<portlet:namespace />openDetailPageOnANewTab" <c:if test="${openDetailPageOnANewTab == 'true'}"><c:out value="checked=\"checked\""></c:out></c:if> value="true" class="as-stream-edit-col2"/>
		</li>
		<li class="as-stream-edit-row">
			<span class="as-stream-edit-col1">Redirect while searching:</span>
			<input type="checkbox" name="<portlet:namespace />redirectWhileSearching" <c:if test="${redirectWhileSearching == 'true'}"><c:out value="checked=\"checked\""></c:out></c:if> value="true" class="as-stream-edit-col2"/>
		</li>
		<li class="as-stream-edit-row">
			<span class="as-stream-edit-col1">Search By Keywords:</span>
			<input type="text" name="<portlet:namespace />searchByKeywords" value="${searchByKeywords}"/>&nbsp;
			<input type="checkbox" name="<portlet:namespace />searchKeywordsFields" value="title" <c:if test="${fn:contains(searchKeywordsFields,'title')}">checked="checked"</c:if> />&nbsp;Title&nbsp;
			<input type="checkbox" name="<portlet:namespace />searchKeywordsFields" value="description" <c:if test="${fn:contains(searchKeywordsFields,'description')}">checked="checked"</c:if> />&nbsp;Description&nbsp;
		</li>
		<li class="as-stream-edit-row">
			<span class="as-stream-edit-col1">Search By Tag:</span>
			<input type="text" name="<portlet:namespace />searchByTag" value="${searchByTag}"/>
		</li>
		<li class="as-stream-edit-row">
			<span class="as-stream-edit-col1">Search By Category:</span>
			<input type="text" name="<portlet:namespace />searchByCategory" value="${searchByCategory}"/>
		</li>
		<li class="as-stream-edit-row">
			<span class="as-stream-edit-col1">Minimum item width:</span>
			<input type="text" name="<portlet:namespace />minItemWidth" value="${minItemWidth}"/>
		</li>
		<li class="as-stream-edit-row">
			<span class="as-stream-edit-col1">Group Detail Page Name:</span>
			<input type="text" name="<portlet:namespace />groupDetailPageName" value="${groupDetailPageName}"/>
		</li>
		<li class="as-stream-edit-row">
			<span class="as-stream-edit-col1">Group Discussion Detail Page Name:</span>
			<input type="text" name="<portlet:namespace />groupDiscussionDetailPageName" value="${groupDiscussionDetailPageName}"/>
		</li>
		<li class="as-stream-edit-row">
			<span class="as-stream-edit-col1">Event Detail Page Name:</span>
			<input type="text" name="<portlet:namespace />eventDetailPageName" value="${eventDetailPageName}"/>
		</li>
		<li class="as-stream-edit-row">
			<br />
			<h1>Individual Profile Configurations</h1>
			<br />
			<c:out value="${membershipPackagesString}"></c:out>
			<br />
			<br />
		</li>
		<li class="as-stream-edit-row">
			<div class="as-stream-edit-col1">
				<c:out value="Membership Packages"></c:out>:
			</div>
			<textarea name="<portlet:namespace />membershipPackages" rows="" cols="">${membershipPackages}</textarea>
		</li>
		<li class="as-stream-edit-row">
			<br />
			<h1>SPAsset Configurations</h1>
			<br />
		</li>
		<li class="as-stream-edit-row">
			<span class="as-stream-edit-col1">SPAsset Type:</span>
			<select name="<portlet:namespace />selectedSPAssetTypeId">
				<option value=""></option>
				<c:forEach items="${spAssetTypes}" var="spAssetType">
					<option value="${spAssetType.spAssetTypeId}" <c:if test="${spAssetType.spAssetTypeId == selectedSPAssetTypeId}">selected="selected"</c:if> >${spAssetType.spAssetTypeName}</option>
				</c:forEach>
			</select>
		</li>
		<li class="as-stream-edit-row">
			<span class="as-stream-edit-col1">Download Location</span>
			<input type="text" name="<portlet:namespace />downloadLocation" value="${downloadLocation}"/>
		</li>

	</ul>

<br />

<input type="submit" value="Save Changes" />
</form>
