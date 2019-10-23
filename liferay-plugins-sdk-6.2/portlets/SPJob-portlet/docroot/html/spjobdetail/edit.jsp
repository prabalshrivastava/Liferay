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
		<div style="display: inline-block; width: 30%;">Name of Apply Page:</div>
		<div style="display: inline-block;"><input type="text" name="<portlet:namespace />nameOfApplyPage" value="${nameOfApplyPage}" size="10" /></div>
	</div>
	<div style="height: 50px;">
		<div style="display: inline-block; width: 30%;">Name of Landing Page:</div>
		<div style="display: inline-block;"><input type="text" name="<portlet:namespace />nameOfLandingPage" value="${nameOfLandingPage}" size="10" /></div>
	</div>
	<input type="submit" value="Save Changes" />
</form>