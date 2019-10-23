<%@page import="com.liferay.portal.model.UserConstants"%>
<%@page import="com.sambaash.platform.model.spneo4j.wrapper.UserGraphWrapper"%>
<%@ page import="com.sambaash.platform.srv.graph.service.SPNeoforjLocalServiceUtil" %>

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
	List<com.sambaash.platform.model.spneo4j.wrapper.UserGraphWrapper> peopleUserMayFollowWrappers = SPNeoforjLocalServiceUtil
			.findPeopleUserMayFollow(themeDisplay.getUserId(),
					themeDisplay.getCompanyId(), themeDisplay
							.getScopeGroupId(), themeDisplay
							.getLayoutSet().getLayoutSetId(), 0, 20);

	if (peopleUserMayFollowWrappers != null
			&& peopleUserMayFollowWrappers.size() > 0) {
%>
		
<section class="sp-feeds">
	<div class="sp-feeds-content sp-feeds-section">
	
		
	
		<div class="sp-feeds-section-title" >
			Follow People
		</div>
		
		<ul >
			<c:forEach items="<%= peopleUserMayFollowWrappers %>" var="peopleUserMayFollowWrapper">
				<li>
					<div class="helper-clearfix">
						<div class="sp-feeds-follow-avatar inline-block align-middle">
							<a href="/${peopleUserMayFollowWrapper.screenName}" style="line-height: 0; display: block;">
							<%-- <img src="/../image/user_male_portrait?img_id=${peopleUserMayFollowWrapper.portraitId}" width="50" height="50" /></a> --%>
							<img alt="Image ${peopleUserMayFollowWrapper.screenName}" src="<%= UserConstants.getPortraitURL(themeDisplay.getPathImage(), true, ((UserGraphWrapper)pageContext.getAttribute("peopleUserMayFollowWrapper")).getPortraitId()) %>" width="50" height="50"  /></a>
							
						</div>
						<div class="sp-feeds-follow-action inline-block margin-left-quarter align-middle">
							<div><a href="/${peopleUserMayFollowWrapper.screenName}">${peopleUserMayFollowWrapper.firstName} ${peopleUserMayFollowWrapper.lastName}</a></div>
							<div style="margin-top: 5px;"><sp-ui:follow communityName="<%= communityName %>" className=" <%= com.liferay.portal.model.User.class.getName() %>" classPK="${peopleUserMayFollowWrapper.userId}" linkOrBtn="link" /></div>
						</div>
						
					</div>
				</li>
			</c:forEach>
		</ul>
	</div>
</section>

<% } %>
