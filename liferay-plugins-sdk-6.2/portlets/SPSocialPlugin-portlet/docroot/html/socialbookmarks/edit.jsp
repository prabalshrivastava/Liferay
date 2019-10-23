<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>

<portlet:defineObjects />
<portlet:actionURL var="editFormSubmitURL">
	<portlet:param name="action" value="editFormSubmit"></portlet:param>
</portlet:actionURL>

<form action='<c:out value="${editFormSubmitURL}" />' id="<portlet:namespace />socialBookmarksForm" method="post" name="<portlet:namespace />socialBookmarksForm">

	<aui:layout cssClass="ms-row-content">
		<aui:column columnWidth="40" cssClass="left-align" first="true">
			<label>Alignment</label>
		</aui:column>
		<aui:column columnWidth="50" cssClass="left-align" first="true">
			<span>
					Horizontal&nbsp;<input type="radio" name="<portlet:namespace />displayPosition"  id="horizontal" value="horizontal" <c:if test="${displayPosition == 'horizontal'}">checked="checked"</c:if>/>
			</span>
			<span>
					Vertical&nbsp;<input type="radio" name="<portlet:namespace />displayPosition"  id="vertical" value="vertical" <c:if test="${displayPosition == 'vertical'}">checked="checked"</c:if> />
			</span>
		</aui:column>
	</aui:layout>
	<aui:layout cssClass="ms-row-content">
		<aui:column columnWidth="40" cssClass="left-align" first="true">
			<label>Display</label>
		</aui:column>
		<aui:column columnWidth="50" cssClass="left-align" first="true">
			Hidden <input type="checkbox" name="<portlet:namespace />displayStyle" id="displayStyle" value="true" <c:if test="${displayStyle == 'true'}">checked="checked"</c:if> />
		</aui:column>
	</aui:layout>

	<aui:layout cssClass="ms-row-content">
		<aui:column columnWidth="40" cssClass="left-align" first="true">
			<label>Static</label>
		</aui:column>
		<aui:column columnWidth="50" cssClass="left-align" first="true">
			<input id="isStatic" name="<portlet:namespace />isStatic" onchange="enableOrUnEnableStaticFields();" type="checkbox" value="true" <c:if test="${isStatic == 'true'}">checked="checked"</c:if> />
		</aui:column>
	</aui:layout>

	<div id="static-meta-section" <c:if test="${isStatic == 'false'}">style="display: none"</c:if>>
		<aui:layout cssClass="ms-row-content">
			<aui:column columnWidth="40" cssClass="left-align" first="true">
				<label>Page Title</label>
			</aui:column>
			<aui:column columnWidth="50" cssClass="left-align" first="true">
				<input id="pageTitle" name="<portlet:namespace />pageTitle" type="text" value="${pageTitle}" />
			</aui:column>
		</aui:layout>
		<aui:layout cssClass="ms-row-content">
			<aui:column columnWidth="40" cssClass="left-align" first="true">
				<label>Page Subtitle</label>
			</aui:column>
			<aui:column columnWidth="50" cssClass="left-align" first="true">
				<input id="pageSubtitle" name="<portlet:namespace />pageSubtitle" type="text" value="${pageSubtitle}" />
			</aui:column>
		</aui:layout>
		<aui:layout cssClass="ms-row-content">
			<aui:column columnWidth="40" cssClass="left-align" first="true">
				<label>Page Description</label>
			</aui:column>
			<aui:column columnWidth="50" cssClass="left-align" first="true">
				<input id="pageDescription" name="<portlet:namespace />pageDescription" type="text" value="${pageDescription}" />
			</aui:column>
		</aui:layout>

		<aui:layout cssClass="ms-row-content">
			<aui:column columnWidth="40" cssClass="left-align" first="true">
				<label>ogImage</label>
			</aui:column>
			<aui:column columnWidth="50" cssClass="left-align" first="true">
				<input id="ogImage" name="<portlet:namespace />ogImage" type="text" value="${ogImage}" />
			</aui:column>
		</aui:layout>

		<aui:layout cssClass="ms-row-content">
			<aui:column columnWidth="40" cssClass="left-align" first="true">
				<label>ogAudio</label>
			</aui:column>
			<aui:column columnWidth="50" cssClass="left-align" first="true">
				<input id="ogAudio" name="<portlet:namespace />ogAudio" type="text" value="${ogAudio}" />
			</aui:column>
		</aui:layout>

		<aui:layout cssClass="ms-row-content">
			<aui:column columnWidth="40" cssClass="left-align" first="true">
				<label>ogUrl</label>
			</aui:column>
			<aui:column columnWidth="50" cssClass="left-align" first="true">
				<input id="ogUrl" name="<portlet:namespace />ogUrl" type="text" value="${ogUrl}" />
			</aui:column>
		</aui:layout>

		<aui:layout cssClass="ms-row-content">
			<aui:column columnWidth="40" cssClass="left-align" first="true">
				<label>ogType</label>
			</aui:column>
			<aui:column columnWidth="50" cssClass="left-align" first="true">
				<input id="ogType" name="<portlet:namespace />ogType" type="text" value="${ogType}" />
			</aui:column>
		</aui:layout>

		<aui:layout cssClass="ms-row-content">
			<aui:column columnWidth="40" cssClass="left-align" first="true">
				<label>ogTitle</label>
			</aui:column>
			<aui:column columnWidth="50" cssClass="left-align" first="true">
				<input id="ogTitle" name="<portlet:namespace />ogTitle" type="text" value="${ogTitle}" />
			</aui:column>
		</aui:layout>

		<aui:layout cssClass="ms-row-content">
			<aui:column columnWidth="40" cssClass="left-align" first="true">
				<label>ogDescription</label>
			</aui:column>
			<aui:column columnWidth="50" cssClass="left-align" first="true">
				<input id="ogTitle" name="<portlet:namespace />ogDescription" type="text" value="${ogDescription}" />
			</aui:column>
		</aui:layout>

		<aui:layout cssClass="ms-row-content">
			<aui:column columnWidth="40" cssClass="left-align" first="true">
				<label>ogSiteName</label>
			</aui:column>
			<aui:column columnWidth="50" cssClass="left-align" first="true">
				<input id="ogSiteName" name="<portlet:namespace />ogSiteName" type="text" value="${ogSiteName}" />
			</aui:column>
		</aui:layout>

		<aui:layout cssClass="ms-row-content">
			<aui:column columnWidth="40" cssClass="left-align" first="true">
				<label>ogVideo</label>
			</aui:column>
			<aui:column columnWidth="50" cssClass="left-align" first="true">
				<input id="ogVideo" name="<portlet:namespace />ogVideo" type="text" value="${ogVideo}" />
			</aui:column>
		</aui:layout>

		<aui:layout cssClass="ms-row-content">
			<aui:column columnWidth="40" cssClass="left-align" first="true">
				<label>Title</label>
			</aui:column>
			<aui:column columnWidth="50" cssClass="left-align" first="true">
				<input id="title" name="<portlet:namespace />title" type="text" value="${title}" />
			</aui:column>
		</aui:layout>

		<aui:layout cssClass="ms-row-content">
			<aui:column columnWidth="40" cssClass="left-align" first="true">
				<label>BookmarkUrl</label>
			</aui:column>
			<aui:column columnWidth="50" cssClass="left-align" first="true">
				<input id="bookmarkUrl" name="<portlet:namespace />bookmarkUrl" type="text" value="${bookmarkUrl}" />
			</aui:column>
		</aui:layout>
	</div>

	<div>
		<input name="<portlet:namespace />submit" type="submit" value="Submit" />
	</div>
</form>

<script type="text/javascript">

function enableOrUnEnableStaticFields() {
	try{
	var isStatic = document.getElementById("isStatic");
	var staticMetaSection = document.getElementById("static-meta-section");
	if (isStatic.checked) {
		staticMetaSection.style.display="block";
	}else {
		staticMetaSection.style.display="none";
	}
	}catch(err) {
		alert(err);
	}

}

</script>