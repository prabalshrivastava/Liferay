<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib	uri="/tld/sp-ui" prefix="sp-ui"%>

<portlet:defineObjects />
<liferay-theme:defineObjects />

<c:choose>
	<c:when test="<%=themeDisplay.isSignedIn()%>">
		<%@ include file="/html/managestartupprofile/addOrEditFullProfile.jspf" %>
	</c:when>
 	<c:otherwise>
 		<%@ include file="/html/managestartupprofile/profileSignup.jspf" %>
 	</c:otherwise>
</c:choose>

<%-- <%@ include file="/html/managestartupprofile/addOrEditFullProfile.jspf" %> --%>

<%-- <%@ include file="/html/managestartupprofile/profileSignup.jspf" %> --%>