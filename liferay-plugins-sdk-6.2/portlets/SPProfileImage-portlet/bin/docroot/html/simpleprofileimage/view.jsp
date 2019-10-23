<%@page import="com.liferay.portal.model.UserConstants"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<portlet:defineObjects />

<liferay-theme:defineObjects />

<style>

.pi-portrait-img {
	max-width: 200px;
}

</style>

<c:choose>
	<c:when test="${editable == 'true'}">
		<a href="/${redirectPageName}?redirect=<%=themeDisplay.getURLCurrent()%>"><img alt="User Image" src="<%=UserConstants.getPortraitURL(themeDisplay.getPathImage(), true, (Long)request.getAttribute("portraitId")) %>" class="pi-portrait-img"/></a>
	</c:when>
	<c:otherwise>
		<img alt="User Image" src="<%=UserConstants.getPortraitURL(themeDisplay.getPathImage(), true, (Long)request.getAttribute("portraitId")) %>" class="pi-portrait-img"/>
	</c:otherwise>
</c:choose>
