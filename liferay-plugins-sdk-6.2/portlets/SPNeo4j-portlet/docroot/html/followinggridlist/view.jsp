<%@page import="com.sambaash.platform.model.spneo4j.wrapper.UserGraphWrapper"%>
<%@page import="com.liferay.portal.model.UserConstants"%>
<%@ page import="com.sambaash.platform.srv.graph.service.SPNeoforjLocalServiceUtil" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="/tld/sp-ui" prefix="sp-ui" %>

<%@ page import="java.util.*" %>

<portlet:defineObjects />

<liferay-theme:defineObjects />
<%
String communityName = com.sambaash.platform.util.SambaashUtil.getCommunityName(themeDisplay.getScopeGroupId());
List<com.sambaash.platform.model.spneo4j.wrapper.UserGraphWrapper> userFollowing = SPNeoforjLocalServiceUtil.findUserFollowing(themeDisplay.getUserId(), themeDisplay.getCompanyId(), themeDisplay
		.getScopeGroupId(), themeDisplay
		.getLayoutSet().getLayoutSetId(), 0, 20);

if(userFollowing!=null && userFollowing.size() > 0) {
%>
<section class="sp-feeds">
	<div class="sp-feeds-content sp-feeds-section">
		<div class="sp-feeds-section-title">
			Who I am following <span class="callout-counter"><%= userFollowing.size() %></span>
		</div>
		<ul>
			<c:forEach items="<%= userFollowing %>" var="uf">
				<li>
					<div class="sp-feeds-follow-avatar inline-block align-middle">
						<a href="/${uf.screenName}" style="line-height: 0; display: block;">
							<%-- <img src="/../image/user_male_portrait?img_id=${uf.portraitId}" width="50" height="50"  /> --%>
							<img alt="User image ${uf.screenName}" src="<%= UserConstants.getPortraitURL(themeDisplay.getPathImage(), true, ((UserGraphWrapper)pageContext.getAttribute("uf")).getPortraitId()) %>" width="50" height="50"  />
						</a>
					</div>
					<div class="sp-feeds-follow-action inline-block margin-left-quarter align-middle">
						<div><a href="/${uf.screenName}">${uf.firstName} ${uf.lastName}</a></div>
					</div>
					
				</li>
			</c:forEach>
		</ul>
	
	</div>
</section>

<%
}
%>
