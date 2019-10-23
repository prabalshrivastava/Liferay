<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%@ page import="com.liferay.portal.kernel.util.FastDateFormatFactoryUtil" %>
<%@ page import="com.liferay.portal.util.PortalUtil" %>
<%@page import="com.liferay.compat.portal.kernel.util.StringUtil"%>

<%@ page import="java.util.*" %>

<%@ page import="com.sambaash.platform.srv.spgroup.model.SPGroup" %>
<%@ page import="com.sambaash.platform.portlet.spgroup.wrapper.SPGroupDetailWrapper" %>

<portlet:defineObjects />

<liferay-theme:defineObjects />

<script src="<c:url value="/js/json2.js" />" type="text/javascript"></script>
<script src="<c:url value="/js/load_more.js" />" type="text/javascript"></script>
<script src="<c:url value="/js/discussions.js" />" type="text/javascript"></script>

<style type="text/css">

</style>

<%
Date now = new Date();

String currentURL = themeDisplay.getURLCurrent();

java.text.Format dateFormatDateTime = FastDateFormatFactoryUtil.getDateTime(locale, timeZone);

SPGroup spGroup = (SPGroup)request.getAttribute("SP_GROUP");

String showSMsg = renderRequest.getParameter("showSMsg");

String groupCreatePageName = portletPreferences.getValue("groupCreatePageName", "create-group");
%>

<%
if ("true".equalsIgnoreCase(showSMsg)) {
%>

	<div class="portlet-msg-success"><liferay-ui:message key="label.success.message" /></div>

<%
}
%>

	<portlet:renderURL var="viewEntryURL">
		<portlet:param name="struts_action" value="/groups/view_entry" />
		<portlet:param name="urlTitle" value="group_0" />
		<%-- <portlet:param name="redirect" value="<%= currentURL %>" /> --%>
	</portlet:renderURL>

	<%--<h2><aui:a href="<%= viewEntryURL %>">viewEntry</aui:a></h2> --%>

<%
if (spGroup != null) {
%>

	<div class="groupDetail_content" data-channels-classname="<%= SPGroup.class.getName() %>" data-channels-classpk="<%= spGroup.getSpGroupId() %>">
		<c:choose>
			<c:when test="${isSPGroupClosed}">
				<div class="portlet-msg-info"><liferay-ui:message key="label.group.closed" /></div>
			</c:when>
			<c:otherwise>

				<%
				String editSPGroupURL = PortalUtil.getPortalURL(renderRequest) + "/" + groupCreatePageName;
				try {
					String createGroupFriendlyUrl = "/" + groupCreatePageName;
					com.liferay.portal.model.Layout createSPGroupLayout = com.liferay.portal.service.LayoutLocalServiceUtil.getFriendlyURLLayout(themeDisplay.getScopeGroupId(), false, createGroupFriendlyUrl);
					long createSPGroupPlid = createSPGroupLayout.getPlid();

					javax.portlet.PortletURL editSPGroupPortletURL = com.liferay.portlet.PortletURLFactoryUtil.create(renderRequest, "SPGroupCreate_WAR_SPGroupportlet", createSPGroupPlid, javax.portlet.PortletRequest.RENDER_PHASE);

					editSPGroupPortletURL.setWindowState(javax.portlet.WindowState.NORMAL);
					editSPGroupPortletURL.setPortletMode(javax.portlet.PortletMode.VIEW);
					editSPGroupPortletURL.setParameter("saveLastPath", "0");
					editSPGroupPortletURL.setParameter("urlTitle", spGroup.getUrlTitle());
					editSPGroupPortletURL.setParameter("spGroupId", String.valueOf(spGroup.getSpGroupId()));
					editSPGroupPortletURL.setParameter("redirect", currentURL);
					editSPGroupURL = editSPGroupPortletURL.toString();

				}catch (com.liferay.portal.NoSuchLayoutException e) {
					// do nothing
				}

				SPGroupDetailWrapper spGroupDetailWrapper = new SPGroupDetailWrapper(spGroup);
				%>

				<c:set value="${pageContext.request.contextPath}" var="ctx" />

				<portlet:renderURL var="joinSPGroupURL">
					<portlet:param name="action" value="joinSPGroup" />
					<portlet:param name="struts_action" value="/groups/view_entry" />
					<portlet:param name="urlTitle" value="<%= spGroup.getUrlTitle() %>" />
				</portlet:renderURL>

				<portlet:renderURL var="cancelJoinSPGroupRequestURL">
					<portlet:param name="action" value="cancelJoinSPGroupRequest" />
					<portlet:param name="struts_action" value="/groups/view_entry" />
					<portlet:param name="urlTitle" value="<%= spGroup.getUrlTitle() %>" />
				</portlet:renderURL>

				<portlet:renderURL var="acceptJoinSPGroupRequestURL">
					<portlet:param name="action" value="acceptJoinSPGroupRequest" />
					<portlet:param name="struts_action" value="/groups/view_entry" />
					<portlet:param name="urlTitle" value="<%= spGroup.getUrlTitle() %>" />
				</portlet:renderURL>

				<portlet:renderURL var="quitSPGroupURL">
					<portlet:param name="action" value="quitSPGroup" />
					<portlet:param name="struts_action" value="/groups/view_entry" />
					<portlet:param name="urlTitle" value="<%= spGroup.getUrlTitle() %>" />
				</portlet:renderURL>

				<portlet:renderURL var="closeSPGroupURL">
					<portlet:param name="action" value="closeSPGroup" />
					<portlet:param name="struts_action" value="/groups/view_entry" />
					<portlet:param name="urlTitle" value="<%= spGroup.getUrlTitle() %>" />
				</portlet:renderURL>

				<portlet:renderURL var="viewAboutTabURL">
					<portlet:param name="tab1" value="about" />
					<portlet:param name="struts_action" value="/groups/view_entry" />
					<portlet:param name="urlTitle" value="<%= spGroup.getUrlTitle() %>" />
				</portlet:renderURL>

				<portlet:renderURL var="viewDiscussionsTabURL">
					<portlet:param name="tab1" value="discussions" />
					<portlet:param name="struts_action" value="/groups/view_entry" />
					<portlet:param name="urlTitle" value="<%= spGroup.getUrlTitle() %>" />
				</portlet:renderURL>

				<portlet:renderURL var="viewMembersTabURL">
					<portlet:param name="tab1" value="members" />
					<portlet:param name="struts_action" value="/groups/view_entry" />
					<portlet:param name="urlTitle" value="<%= spGroup.getUrlTitle() %>" />
				</portlet:renderURL>

				<portlet:renderURL var="viewAdminTabURL">
					<portlet:param name="tab1" value="admin" />
					<portlet:param name="struts_action" value="/groups/view_entry" />
					<portlet:param name="urlTitle" value="<%= spGroup.getUrlTitle() %>" />
				</portlet:renderURL>

				<portlet:renderURL var="viewSettingsTabURL">
					<portlet:param name="tab1" value="settings" />
					<portlet:param name="struts_action" value="/groups/view_entry" />
					<portlet:param name="urlTitle" value="<%= spGroup.getUrlTitle() %>" />
				</portlet:renderURL>

				<portlet:renderURL var="viewInviteFriendsTabURL">
					<portlet:param name="tab1" value="invite_friends" />
					<portlet:param name="struts_action" value="/groups/view_entry" />
					<portlet:param name="urlTitle" value="<%= spGroup.getUrlTitle() %>" />
				</portlet:renderURL>

				<portlet:renderURL var="viewInviteFriendsGmailTabURL">
					<portlet:param name="tab1" value="invite_friends" />
					<portlet:param name="tab2" value="gmail" />
					<portlet:param name="struts_action" value="/groups/view_entry" />
					<portlet:param name="urlTitle" value="<%= spGroup.getUrlTitle() %>" />
				</portlet:renderURL>

				<portlet:renderURL var="viewInviteFriendsGooglePlusTabURL">
					<portlet:param name="tab1" value="invite_friends" />
					<portlet:param name="tab2" value="google_plus" />
					<portlet:param name="struts_action" value="/groups/view_entry" />
					<portlet:param name="urlTitle" value="<%= spGroup.getUrlTitle() %>" />
				</portlet:renderURL>

				<portlet:renderURL var="viewInviteFriendsFacebookTabURL">
					<portlet:param name="tab1" value="invite_friends" />
					<portlet:param name="tab2" value="facebook" />
					<portlet:param name="struts_action" value="/groups/view_entry" />
					<portlet:param name="urlTitle" value="<%= spGroup.getUrlTitle() %>" />
				</portlet:renderURL>

				<portlet:renderURL var="viewInviteFriendsTwitterTabURL">
					<portlet:param name="tab1" value="invite_friends" />
					<portlet:param name="tab2" value="twitter" />
					<portlet:param name="struts_action" value="/groups/view_entry" />
					<portlet:param name="urlTitle" value="<%= spGroup.getUrlTitle() %>" />
				</portlet:renderURL>

				<portlet:renderURL var="viewInviteFriendsEmailTabURL">
					<portlet:param name="tab1" value="invite_friends" />
					<portlet:param name="tab2" value="email" />
					<portlet:param name="struts_action" value="/groups/view_entry" />
					<portlet:param name="urlTitle" value="<%= spGroup.getUrlTitle() %>" />
				</portlet:renderURL>

				<portlet:resourceURL var="retrieveCommentsURL">
					<portlet:param name="action" value="retrieveComments"></portlet:param>
				</portlet:resourceURL>

				<portlet:resourceURL var="retrieveRepliesURL">
					<portlet:param name="action" value="retrieveReplies"></portlet:param>
				</portlet:resourceURL>

				<portlet:resourceURL var="addCommentURL">
					<portlet:param name="action" value="addComment"></portlet:param>
					<portlet:param name="urlTitle" value="<%= spGroup.getUrlTitle() %>"></portlet:param>
				</portlet:resourceURL>

				<portlet:resourceURL var="addReplyURL">
					<portlet:param name="action" value="addReply"></portlet:param>
				</portlet:resourceURL>

				<portlet:resourceURL var="deleteCommentURL">
					<portlet:param name="action" value="deleteComment"></portlet:param>
				</portlet:resourceURL>

				<portlet:resourceURL var="inviteFriendsURL">
					<portlet:param name="action" value="inviteFriends"></portlet:param>
				</portlet:resourceURL>

				<portlet:resourceURL var="inviteFriendsByEmailURL">
					<portlet:param name="action" value="inviteFriendsByEmail"></portlet:param>
				</portlet:resourceURL>

				<portlet:resourceURL var="inviteFriendsByGmailURL">
					<portlet:param name="action" value="inviteFriendsByGmail"></portlet:param>
				</portlet:resourceURL>

				<portlet:resourceURL var="inviteFriendsByFacebookURL">
					<portlet:param name="action" value="inviteFriendsByFacebook"></portlet:param>
				</portlet:resourceURL>

				<portlet:resourceURL var="inviteFriendsByTwitterURL">
					<portlet:param name="action" value="inviteFriendsByTwitter"></portlet:param>
				</portlet:resourceURL>

				<portlet:resourceURL var="attachLinkURL">
					<portlet:param name="action" value="attachLink"></portlet:param>
				</portlet:resourceURL>

				<portlet:resourceURL var="subscribeToCommentsURL">
					<portlet:param name="action" value="subscribeToComments"></portlet:param>
				</portlet:resourceURL>

				<%--<h2><aui:a href="<%= viewDiscussionURL %>">viewDiscussion79329</aui:a></h2> --%>

				<liferay-ui:error key="LASTOWNEROFTHISGROUP" message="You are the only administrator for this group. Please transfer your administrator role to someone else before you leave." />

				<liferay-ui:error key="HASBEENREJECTED" message="Sorry, we can't accept your request to join this group, as your previous request was not approved by the Group Admin." />

				<%@ include file="include/header.jsp" %>

				<br />

				<%@ include file="include/nav.jsp" %>

				<c:choose>
					<c:when test="${tab1 == 'about'}">
						<%@ include file="include/about.jsp" %>
					</c:when>
					<c:when test="${tab1 == 'members'}">
						<c:choose>
							<c:when test="${(isGroupPublic) || (isGroupMembersOnly && isMember) || (isGroupAdmin && isMember)}">
								<%@ include file="include/members.jsp" %>
							</c:when>
							<c:when test="${isGroupMembersOnly && !isMember && themeDisplay.signedIn}">
								<c:out value="To request membership, click 'Join this group' and your request will be reviewed by the Group Admin." />
							</c:when>
							<c:when test="${isGroupMembersOnly && !themeDisplay.signedIn}">
								<liferay-ui:message key="label.private" /><liferay-ui:message key="label.please" /><a href="/signin"><liferay-ui:message key="label.login" /></a> <liferay-ui:message key="label.to.view" /><liferay-ui:message key="label.not.member" /><a href="/signup">Join Us</a>.
							</c:when>

						</c:choose>
					</c:when>
					<c:when test="${tab1 == 'admin'}">
						<c:choose>
							<c:when test="${(isGroupPublic) || (isGroupMembersOnly && isMember) || (isGroupAdmin && isMember)}">
								<%@ include file="include/admin.jsp" %>
							</c:when>
							<c:when test="${isGroupMembersOnly && !isMember && themeDisplay.signedIn}">
								<c:out value="To request membership, click 'Join this group' and your request will be reviewed by the Group Admin." />
							</c:when>
							<c:when test="${isGroupMembersOnly && !themeDisplay.signedIn}">
								<liferay-ui:message key="label.private" /><liferay-ui:message key="label.please" /><a href="/signin"><liferay-ui:message key="label.login" /></a> <liferay-ui:message key="label.to.view" /><liferay-ui:message key="label.not.member" /><a href="/signup">Join Us</a>.
							</c:when>
						</c:choose>
					</c:when>
					<c:when test="${tab1 == 'invite_friends'}">
						<c:if test="${(isGroupPublic && isMember) || (isGroupMembersOnly && isMember) || (isGroupAdmin && (isAdmin || isOwner))}">
							<%@ include file="include/invite_friends_pure_javascript.jsp" %>
						</c:if>
					</c:when>
					<c:when test="${tab1 == 'settings'}">
						<c:if test="${isAdmin || isOwner}">
							<%@ include file="include/settings.jsp" %>
						</c:if>
					</c:when>
					<c:otherwise>
						<c:choose>
							<c:when test="${(isGroupPublic) || (isGroupMembersOnly && isMember) || (isGroupAdmin && isMember)}">
								<%@ include file="include/discussions_ajax.jsp" %>
							</c:when>
							<c:when test="${isGroupMembersOnly && !isMember && themeDisplay.signedIn}">
								<liferay-ui:message key="label.membership.request" />
							</c:when>
							<c:when test="${isGroupMembersOnly && !themeDisplay.signedIn}">
								<liferay-ui:message key="label.private" /><liferay-ui:message key="label.please" /><a href="/signin"><liferay-ui:message key="label.login" /></a> <liferay-ui:message key="label.to.view" /><liferay-ui:message key="label.not.member" /><a href="/signup">Join Us</a>.
							</c:when>
						</c:choose>
					</c:otherwise>
				</c:choose>

				<script type="text/javascript">
				
					var namespace= '<portlet:namespace/>';

					window.onload = function() {

						var tags_selector_entries_holder = getElementsByAttribute(document, "ul", "data-tag-dom-id", "tags-selector-entries-holder");
						var tags_selector_input = getElementsByAttribute(document, "input", "data-tag-dom-id", "tags-selector-input");
						var tags_selector_add_btn = getElementsByAttribute(document, "a", "data-tag-dom-id", "tags-selector-add-btn");

						new TagsSelector({
							'j_tags_selector_entries_holder' : tags_selector_entries_holder,
							'j_tags_selector_input' : tags_selector_input,
							'j_tags_selector_add_btn' : tags_selector_add_btn
						});

					}

				</script>

				<script type="text/javascript">

					function simulate(element, eventName) {
					    var options = extend(defaultOptions, arguments[2] || {});
					    var oEvent, eventType = null;

					    for (var name in eventMatchers) {
					        if (eventMatchers[name].test(eventName)) { eventType = name; break; }
					    }

					    if (!eventType)
					        throw new SyntaxError('Only HTMLEvents and MouseEvents interfaces are supported');

					    if (document.createEvent) {
					        oEvent = document.createEvent(eventType);
					        if (eventType == 'HTMLEvents')
					        {
					            oEvent.initEvent(eventName, options.bubbles, options.cancelable);
					        }
					        else
					        {
					            oEvent.initMouseEvent(eventName, options.bubbles, options.cancelable, document.defaultView,
					            options.button, options.pointerX, options.pointerY, options.pointerX, options.pointerY,
					            options.ctrlKey, options.altKey, options.shiftKey, options.metaKey, options.button, element);
					        }
					        element.dispatchEvent(oEvent);
					    }
					    else {
					        options.clientX = options.pointerX;
					        options.clientY = options.pointerY;
					        var evt = document.createEventObject();
					        oEvent = extend(evt, options);
					        element.fireEvent('on' + eventName, oEvent);
					    }
					    return element;
					}

					function extend(destination, source) {
					    for (var property in source)
					      destination[property] = source[property];
					    return destination;
					}

					var eventMatchers = {
					    'HTMLEvents': /^(?:load|unload|abort|error|select|change|submit|reset|focus|blur|resize|scroll)$/,
					    'MouseEvents': /^(?:click|dblclick|mouse(?:down|up|over|move|out))$/
					}

					var defaultOptions = {
					    pointerX: 0,
					    pointerY: 0,
					    button: 0,
					    ctrlKey: false,
					    altKey: false,
					    shiftKey: false,
					    metaKey: false,
					    bubbles: true,
					    cancelable: true
					}

				</script>

			</c:otherwise>
		</c:choose>
	</div>

<%
}else {
%>

	<div class="portlet-msg-error"><liferay-ui:message key="label.no.entry" /></div>

<%
}
%>