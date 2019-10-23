<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="/tld/sp-ui" prefix="sp-ui" %>

<%@ page import="java.util.*" %>

<portlet:defineObjects />

<liferay-theme:defineObjects />

<%
String communityName = com.sambaash.platform.util.SambaashUtil.getCommunityName(themeDisplay.getScopeGroupId());
long profileUserId = com.sambaash.platform.util.SambaashUtil.getUserIdByScreenName(themeDisplay.getCompanyId(), themeDisplay.getURLCurrent());

com.liferay.portal.model.User profileUser = null;
if (profileUserId > 0) {
	try{
		profileUser = com.liferay.portal.service.UserLocalServiceUtil.getUser(profileUserId);
	}catch(com.liferay.portal.NoSuchUserException nsue) {
		// do nothing
	}
}
%>
<section class="sp-feeds">

<c:if test="<%= profileUserId > 0 && profileUserId != themeDisplay.getUserId() %>">
	<div>
		<sp-ui:follow className="<%= com.liferay.portal.model.User.class.getName() %>" classPK="<%= profileUserId %>" communityName="<%= communityName %>" />
		<%-- <span><c:out value="<%= profileUser.getFullName() %>" /></span> --%>
	</div>
</c:if>

</section>
