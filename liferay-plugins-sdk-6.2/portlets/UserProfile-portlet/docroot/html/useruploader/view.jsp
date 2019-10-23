<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>


<%@ page import="com.sambaash.platform.exception.FileFormatException"%>
<%@ page import="com.liferay.portal.kernel.servlet.SessionErrors"%>
<portlet:defineObjects />

<portlet:actionURL var="uploadExcel">
	<portlet:param name="action" value="uploadFiles" />
</portlet:actionURL>
<c:if test="${success eq 'true'}">
	<div class="portlet-msg-success">User excel upload completed
		successfully. Records are being processed. Processing time will vary based on the number of records. Please check user listing.</div>
</c:if>
<c:if
	test="<%=SessionErrors.contains(renderRequest, FileFormatException.class.getName())%>">

	<%
		FileFormatException ffe = (FileFormatException) SessionErrors.get(renderRequest,
				FileFormatException.class.getName());
	%>

	<div class="portlet-msg-error">
		<c:if
			test="<%=ffe.getType() == FileFormatException.FILE_TYPE_EXCEPTION%>">
			<c:out value="Please select valid excel file (xls or xlsx)." />
		</c:if>
		<c:if
			test="<%=ffe.getType() == FileFormatException.METADATA_EXCEPTION%>">
			<c:out
				value="Excel must contains atleast 2 sheets. Meta data sheet and data sheet." />
		</c:if>
		<c:if
			test="<%=ffe.getType() == FileFormatException.METADATA_MISMATCH_EXCEPTION%>">
			<c:out value="Metadata information mismatch with userdata." />
		</c:if>
		<c:if
			test="<%=ffe.getType() == FileFormatException.COLUMN_NOT_FOUND_IN_METADATA%>">
			<c:out value="Column not found in metadata but exists in userdata." />
		</c:if>
		<c:if
			test="<%=ffe.getType() == FileFormatException.DUPLICATE_COLUMN_NAME_IN_USERDATA%>">
			<c:out value="Column name is duplicated in userdata" />
		</c:if>
		<c:if
			test="<%=ffe.getType() == FileFormatException.COLUMN_COUNT_NOT_EQUAL%>">
			<c:out value="Column count is not equal in metadata and userdata." />
		</c:if>
		<c:if
			test="<%=ffe.getType() == FileFormatException.FIXED_COLUMN_EXCEPTION%>">
			<c:out
				value="Fixed columns not found. First 3 columns are fixed in metadata and userdata. (firstName, lastName, emailAddress). " />
		</c:if>
	</div>
</c:if>

<c:choose>
	<c:when test="${!hasAccess}">
		<h3>You don't have the permission to access!"</h3>
	</c:when>
	<c:otherwise>
		<div>
			<aui:form action="<%=uploadExcel%>" enctype="multipart/form-data"
				method="POST" id="fm" name="fm">
				<aui:input label="Select excel file" name="filesToUpload"
					id="filesToUpload" type="file"
					onChange='<%=renderResponse.getNamespace() + "uploadExcel()"%>'
					accept="application/vnd.ms-excel,application/vnd.openxmlformats-officedocument.spreadsheetml.sheet" />
			</aui:form>
		</div>
	</c:otherwise>
</c:choose>



<aui:script>
function <portlet:namespace />uploadExcel() {
	submitForm(document.<portlet:namespace />fm);
}
</aui:script>
	

