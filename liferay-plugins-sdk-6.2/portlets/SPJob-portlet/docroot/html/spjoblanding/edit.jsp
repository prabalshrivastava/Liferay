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

<h1>Configurations</h1>
<br />

<form action="<%= editActionURL %>" method="post">
	<div style="height: 50px;">
		<div style="display: inline-block; width: 20%;vertical-align:top">Show Image:</div>
		<div style="display: inline-block;"><input type="checkbox" name="<portlet:namespace />showImage" <c:if test="${showImage == 'true'}"><c:out value="checked=\"checked\""></c:out></c:if> value="true" /></div>
	</div>
	<div style="height: 50px;">
		<div style="display: inline-block; width: 20%;vertical-align:top">Show Title:</div>
		<div style="display: inline-block; width: 20%;"><input type="checkbox" name="<portlet:namespace />showTitle" <c:if test="${showTitle == 'true'}"><c:out value="checked=\"checked\""></c:out></c:if> value="true" /></div>
		<div style="display: inline-block;"><input type="text" name="<portlet:namespace />titleMaxLength" value="${titleMaxLength}" size="5" /><span> (maximum length)</span></div>
	</div>
	<div style="height: 50px;">
		<div style="display: inline-block; width: 20%;vertical-align:top">Show Type:</div>
		<div style="display: inline-block;"><input type="checkbox" name="<portlet:namespace />showType" <c:if test="${showType == 'true'}"><c:out value="checked=\"checked\""></c:out></c:if> value="true" /></div>
	</div>
	<div style="height: 50px;">
		<div style="display: inline-block; width: 20%;vertical-align:top">Show Start Date:</div>
		<div style="display: inline-block;"><input type="checkbox" name="<portlet:namespace />showStartDate" <c:if test="${showStartDate == 'true'}"><c:out value="checked=\"checked\""></c:out></c:if> value="true" /></div>
	</div>
	<div style="height: 50px;">
		<div style="display: inline-block; width: 20%;vertical-align:top">Show Description:</div>
		<div style="display: inline-block; width: 20%;"><input type="checkbox" name="<portlet:namespace />showDescription" <c:if test="${showDescription == 'true'}"><c:out value="checked=\"checked\""></c:out></c:if> value="true" /></div>
		<div style="display: inline-block;"><input type="text" name="<portlet:namespace />descriptionMaxLength" value="${descriptionMaxLength}" size="5" /><span> (maximum length)</span></div>
	</div>
	<div style="height: 50px;">
		<div style="display: inline-block; width: 20%;vertical-align:top">Show Categories:</div>
		<div style="display: inline-block; width: 20%;"><input type="checkbox" name="<portlet:namespace />showCategories" <c:if test="${showCategories == 'true'}"><c:out value="checked=\"checked\""></c:out></c:if> value="true" /></div>
		<div style="display: inline-block;"><input type="text" name="<portlet:namespace />categoriesMaxLength" value="${categoriesMaxLength}" size="5" /><span> (maximum length)</span></div>
	</div>
	<div style="height: 50px;">
		<div style="display: inline-block; width: 20%;vertical-align:top">Show Tags:</div>
		<div style="display: inline-block; width: 20%;"><input type="checkbox" name="<portlet:namespace />showTags" <c:if test="${showTags == 'true'}"><c:out value="checked=\"checked\""></c:out></c:if> value="true" /></div>
		<div style="display: inline-block;"><input type="text" name="<portlet:namespace />tagsMaxLength" value="${tagsMaxLength}" size="5" /><span> (maximum length)</span></div>
	</div>
	<div style="height: 50px;">
		<div style="display: inline-block; width: 20%;vertical-align:top">Name of Detail Page:</div>
		<div style="display: inline-block;"><input type="text" name="<portlet:namespace />nameOfDetailPage" value="${nameOfDetailPage}" size="10" /></div>
	</div>
	<div style="height: 50px;">
		<div style="display: inline-block; width: 20%;vertical-align:top">Name of Create Page:</div>
		<div style="display: inline-block;"><input type="text" name="<portlet:namespace />nameOfCreatePage" value="${nameOfCreatePage}" size="10" /></div>
	</div>
	<div style="height: 50px;">
		<div style="display: inline-block; width: 20%;vertical-align:top">Name of Apply Page:</div>
		<div style="display: inline-block;"><input type="text" name="<portlet:namespace />nameOfApplyPage" value="${nameOfApplyPage}" size="10" /></div>
	</div>
	<div style="height: 50px;">
		<div style="display: inline-block; width: 20%;vertical-align:top">No. of Items Per Page:</div>
		<div style="display: inline-block;"><input type="text" name="<portlet:namespace />numberOfItemsPerPage" value="${numberOfItemsPerPage}" size="5" /></div>
	</div>
	<div>
		<div style="display: inline-block; width: 20%;vertical-align:top">Width && Height of Item:</div>
		<div style="display: inline-block;"><input type="text" name="<portlet:namespace />widthOfItem" value="${widthOfItem}" size="5" /> x <input type="text" name="<portlet:namespace />heightOfItem" value="${heightOfItem}" size="5" /></div>
	</div>
	<div style="height: 50px;">
		<div style="display: inline-block; width: 20%;vertical-align:top">Vocabulary Id of Location:</div>
		<div style="display: inline-block;"><input type="text" name="<portlet:namespace />locationVocabularyId" value="${locationVocabularyId}" size="5" /><span> (Choose from below)</span></div>
	</div>
	<div style="height: 50px;">
		<div style="display: inline-block; width: 20%;vertical-align:top">Vocabulary Id of Category:</div>
		<div style="display: inline-block;"><input type="text" name="<portlet:namespace />categoryVocabularyId" value="${categoryVocabularyId}" size="5" /><span> (Choose from below)</span></div>
	</div>
	<div style="height: 50px;">
		<div style="display: inline-block; width: 20%;vertical-align: top;">Vocabulary Id of YearOfExperience:</div>
		<div style="display: inline-block;"><input type="text" name="<portlet:namespace />yearOfExperienceVocabularyId" value="${yearOfExperienceVocabularyId}" size="5" /><span> (Choose from below)</span></div>
	</div>
	<input type="submit" value="Save Changes" />
</form>

<br />
<b>Asset Vocabularies ( name: id; )</b>
<br />
<c:out value="${assetVocabulariesString}"></c:out>