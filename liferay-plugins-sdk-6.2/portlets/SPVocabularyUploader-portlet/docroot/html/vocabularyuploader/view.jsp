<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<portlet:defineObjects />

<liferay-theme:defineObjects />

<portlet:actionURL var="uploadURL">
</portlet:actionURL>

<h3>File Upload:</h3>

Select a file to upload:
<br />

<form action="<%= uploadURL %>" enctype="multipart/form-data" method="post">
	<input name="<portlet:namespace />file" size="20" type="file" />
	<br />
	<br />
	<input type="submit" value="Upload File" />
</form>