<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<portlet:defineObjects />
<liferay-theme:defineObjects />

<portlet:actionURL var="addDefaultPermissionsToDeptUsersActionUrl" name="addDefaultPermissionsToDeptUsers">
</portlet:actionURL>
<portlet:renderURL portletMode="view" var="viewURL" />


<aui:form name="addPermissions" action="<%=addDefaultPermissionsToDeptUsersActionUrl%>">
	Note: Implemented for data patch. Default permissions will be assigned for files and folders uploaded by external user
	<aui:button name="Add Permissions" type="submit"
		value="Add Permissions" />
</aui:form>

