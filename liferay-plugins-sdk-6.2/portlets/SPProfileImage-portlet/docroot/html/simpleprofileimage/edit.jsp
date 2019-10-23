<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@ page import="com.liferay.portal.kernel.util.Constants" %>

<portlet:defineObjects />

<liferay-theme:defineObjects />

<portlet:actionURL var="editActionURL">
	<portlet:param name="action" value="<%=Constants.EDIT %>"></portlet:param>
</portlet:actionURL>

<form action="<%=editActionURL %>" method="post" >
	<div><input type="checkbox" name="<portlet:namespace />editable" <c:if test="${editable == 'true'}"><c:out value="checked=\"checked\""></c:out></c:if> value="true" /><span>Editable</span></div>
	<div><input type="text" name="<portlet:namespace />redirectPageName" value="${redirectPageName}" /><span>(specify the name of page you wanna redirect to)</span></div>
	<input type="submit" value="Save Changes"/>
</form>