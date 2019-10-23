<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<portlet:defineObjects />

<liferay-theme:defineObjects />

<portlet:actionURL var="editActionURL">
	<portlet:param name="action" value="mailTemplate"></portlet:param>
</portlet:actionURL>

<form action="<%= editActionURL %>" method="post">
<div style="padding:10px;border:1px solid #666666;width:96%;">
	<div style="width:100%;padding:10px;">
		<div style="width:20%;display:inline-block;color:#000000;font-weight:bold;"> Mail Template Page</div>
		<div style="width:80%;display:inline;"><input type="text" name="<portlet:namespace />templatePage" id="templatePage" value="${templatePage}" /></div>
	</div>
	<input type="submit" value="Save Changes" />
</div>
</form>