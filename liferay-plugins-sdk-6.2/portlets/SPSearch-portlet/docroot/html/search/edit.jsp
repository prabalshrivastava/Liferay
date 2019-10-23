<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%@ page import="com.liferay.portal.kernel.util.Constants" %>

<%@ page import="java.util.*" %>

<%@ page import="javax.portlet.*" %>

<portlet:defineObjects />

<liferay-theme:defineObjects />

<h1>Search Configurations</h1>
<br />

<portlet:actionURL var="editActionURL">
	<portlet:param name="action" value="<%= Constants.EDIT %>"></portlet:param>
</portlet:actionURL>

<form action="<%= editActionURL %>" method="post">
	<ul>
		<li class="search-stream-edit-row">
			<span class="search-stream-edit-col1">Header Title:</span>
			<input name="<portlet:namespace />headerTitle" size="10" type="text" value="${headerTitle}" />
		</li>
		<li class="search-stream-edit-row">
			<span class="search-stream-edit-col1">Category:</span>
			<select name="<portlet:namespace />category">
				<option value=""></option>
				<option value="Logined User" <c:if test="${category == 'Logined User'}"><c:out value="selected=\"selected\""></c:out></c:if> >Logined User</option>
				<option value="Public Profile" <c:if test="${category == 'Public Profile'}"><c:out value="selected=\"selected\""></c:out></c:if> >Public Profile</option>
				<option value="All" <c:if test="${category == 'All'}"><c:out value="selected=\"selected\""></c:out></c:if> >All</option>
			</select>
		</li>
		<li class="search-stream-edit-row">
			<span class="search-stream-edit-col1">Show Blog:</span>
			<input name="<portlet:namespace />isShowBlog" type="checkbox" <c:if test="${isShowBlog == 'true'}"><c:out value="checked=\"checked\""></c:out></c:if> value="true" class="search-stream-edit-col2" />
			<input name="<portlet:namespace />blogNum" size="5" type="text" value="${blogNum}" />
		</li>
		<li class="search-stream-edit-row">
			<span class="search-stream-edit-col1">Show Group:</span>
			<input name="<portlet:namespace />isShowGroup" type="checkbox" <c:if test="${isShowGroup == 'true'}"><c:out value="checked=\"checked\""></c:out></c:if> value="true" class="search-stream-edit-col2" />
			<input type="text" name="<portlet:namespace />groupNum" value="${groupNum}" size="5" /> <input type="text" placeholder="Detail Page Name" name="<portlet:namespace />groupDetailPageName" value="${groupDetailPageName}" size="10" />
		</li>
		<li class="search-stream-edit-row">
			<span class="search-stream-edit-col1">Show Event:</span>
			<input name="<portlet:namespace />isShowEvent" type="checkbox" <c:if test="${isShowEvent == 'true'}"><c:out value="checked=\"checked\""></c:out></c:if> value="true" class="search-stream-edit-col2" />
			<input type="text" name="<portlet:namespace />eventNum" value="${eventNum}" size="5" /> <input type="text" placeholder="Detail Page Name" name="<portlet:namespace />eventDetailPageName" value="${eventDetailPageName}" size="10" />
		</li>
		<li class="search-stream-edit-row">
			<span class="search-stream-edit-col1">Show Gallery:</span>
			<input name="<portlet:namespace />isShowGallery" type="checkbox" <c:if test="${isShowGallery == 'true'}"><c:out value="checked=\"checked\""></c:out></c:if> value="true" class="search-stream-edit-col2" />
			<input name="<portlet:namespace />galleryNum" size="5" type="text" value="${galleryNum}" />
		</li>
		<li class="search-stream-edit-row">
			<span class="search-stream-edit-col1">Show Job:</span>
			<input name="<portlet:namespace />isShowJob" type="checkbox" <c:if test="${isShowJob == 'true'}"><c:out value="checked=\"checked\""></c:out></c:if> value="true" class="search-stream-edit-col2" />
			<input name="<portlet:namespace />jobNum" size="5" type="text" value="${jobNum}" />
		</li>
		<li class="search-stream-edit-row">
			<span class="search-stream-edit-col1">Show Knowledge Center:</span>
			<input name="<portlet:namespace />isShowKC" type="checkbox" <c:if test="${isShowKC == 'true'}"><c:out value="checked=\"checked\""></c:out></c:if> value="true" class="search-stream-edit-col2" />
			<input name="<portlet:namespace />kcNum" size="5" type="text" value="${kcNum}" />
		</li>
		<li class="search-stream-edit-row">
			<span class="search-stream-edit-col1">Show Individual Profile:</span>
			<input name="<portlet:namespace />isShowIndiProfile" type="checkbox" <c:if test="${isShowIndiProfile == 'true'}"><c:out value="checked=\"checked\""></c:out></c:if> value="true" class="search-stream-edit-col2" />
			<input name="<portlet:namespace />indiProfileNum" size="5" type="text" value="${indiProfileNum}" />
		</li>
		<li class="search-stream-edit-row">
			<span class="search-stream-edit-col1">Show Corporate Profile:</span>
			<input name="<portlet:namespace />isShowCorpProfile" type="checkbox" <c:if test="${isShowCorpProfile == 'true'}"><c:out value="checked=\"checked\""></c:out></c:if> value="true" class="search-stream-edit-col2" />
			<input name="<portlet:namespace />corpProfileNum" size="5" type="text" value="${corpProfileNum}" />
		</li>
		<li class="search-stream-edit-row">
			<span class="search-stream-edit-col1">Show SPAsset:</span>
			<input name="<portlet:namespace />isShowSPAsset" type="checkbox" <c:if test="${isShowSPAsset == 'true'}"><c:out value="checked=\"checked\""></c:out></c:if> value="true" class="search-stream-edit-col2" />
			<input name="<portlet:namespace />spAssetNum" size="5" type="text" value="${spAssetNum}" />
		</li>

		<li class="search-stream-edit-row">
			<span class="search-stream-edit-col1">Show Image:</span>
			<input name="<portlet:namespace />isShowImage" type="checkbox" <c:if test="${isShowImage == 'true'}"><c:out value="checked=\"checked\""></c:out></c:if> value="true" class="search-stream-edit-col2" />
		</li>
		<li class="search-stream-edit-row">
			<span class="search-stream-edit-col1">Show Title:</span>
			<input name="<portlet:namespace />isShowTitle" type="checkbox" <c:if test="${isShowTitle == 'true'}"><c:out value="checked=\"checked\""></c:out></c:if> value="true" class="search-stream-edit-col2" />
			<input name="<portlet:namespace />titleMaxLength" size="5" type="text" value="${titleMaxLength}" />
		</li>
		<li class="search-stream-edit-row">
			<span class="search-stream-edit-col1">Show Content:</span>
			<input name="<portlet:namespace />isShowContent" type="checkbox" <c:if test="${isShowContent == 'true'}"><c:out value="checked=\"checked\""></c:out></c:if> value="true" class="search-stream-edit-col2" />
			<input name="<portlet:namespace />contentMaxLength" size="5" type="text" value="${contentMaxLength}" />
		</li>
		<li class="search-stream-edit-row">
			<span class="search-stream-edit-col1">Show Author:</span>
			<input name="<portlet:namespace />isShowAuthor" type="checkbox" <c:if test="${isShowAuthor == 'true'}"><c:out value="checked=\"checked\""></c:out></c:if> value="true" class="search-stream-edit-col2" />
		</li>

		<li class="search-stream-edit-row">
			<span class="search-stream-edit-col1">Page Items:</span>
			<input name="<portlet:namespace />pageItems" size="5" type="text" value="${pageItems}" />
		</li>
		<li class="search-stream-edit-row">
			<span class="search-stream-edit-col1">Item Min-Width</span>
			<input name="<portlet:namespace />itemMinWidth" size="5" type="text" value="${itemMinWidth}" />
		</li>
		<li class="search-stream-edit-row">
			<span class="search-stream-edit-col1">Listing Style:</span>
			<select name="<portlet:namespace />listingStyle">
				<option value="vertical" <c:if test="${listingStyle == 'vertical'}"><c:out value="selected=\"selected\""></c:out></c:if> >Vertical</option>
				<option value="horizontal" <c:if test="${listingStyle == 'horizontal'}"><c:out value="selected=\"selected\""></c:out></c:if> >Horizontal</option>
			</select>
		</li>

		<li class="search-stream-edit-row">
			<span class="search-stream-edit-col1">Search By Keywords:</span>
			<input name="<portlet:namespace />searchByKeywords" size="10" type="text" value="${searchByKeywords}" />&nbsp;
			<input name="<portlet:namespace />searchKeywordsFields" type="checkbox" value="title" <c:if test="${fn:contains(searchKeywordsFields,'title')}">checked="checked"</c:if> />&nbsp;Title&nbsp;
			<input name="<portlet:namespace />searchKeywordsFields" type="checkbox" value="description" <c:if test="${fn:contains(searchKeywordsFields,'description')}">checked="checked"</c:if> />&nbsp;Description&nbsp;
		</li>

		<li class="search-stream-edit-row">
			<span class="search-stream-edit-col1">Search By Tag:</span>
			<input name="<portlet:namespace />searchByTag" type="text" value="${searchByTag}" />
		</li>

		<li class="search-stream-edit-row">
			<span class="search-stream-edit-col1">Search By Category:</span>
			<input name="<portlet:namespace />searchByCategory" type="text" value="${searchByCategory}" />
		</li>

		<li class="search-stream-edit-row">
			<span class="search-stream-edit-col1">SPAsset Type:</span>
			<select name="<portlet:namespace />selectedSPAssetTypeId">
				<option value=""></option>
				<c:forEach items="${spAssetTypes}" var="spAssetType">
					<option value="${spAssetType.spAssetTypeId}" <c:if test="${spAssetType.spAssetTypeId == selectedSPAssetTypeId}">selected="selected"</c:if> >${spAssetType.spAssetType}</option>
				</c:forEach>
			</select>
		</li>

	</ul>

<br />
<br />
<input type="submit" value="Save Changes" />
</form>