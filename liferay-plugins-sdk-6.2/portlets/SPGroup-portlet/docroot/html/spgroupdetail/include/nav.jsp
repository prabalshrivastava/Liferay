<div class="sp-group-clearfix sp-group-nav">
	<ul class="sp-group-tabs horizontal sp-group-lfloat ${isAdmin }" style="margin: 0; border: 0 none;">
		<li><a href="<%= viewAboutTabURL %>" <c:if test="${tab1 == 'about'}">class="active"</c:if> ><liferay-ui:message key="label.about" /></a></li>
		<c:if test="${(isGroupPublic) || (isGroupMembersOnly) || (isGroupAdmin && isMember) || (isAdmin)}">
		<li>
			<a href="<%= viewDiscussionsTabURL %>" <c:if test="${tab1 == 'discussions' || empty tab1}">class="active"</c:if> ><liferay-ui:message key="label.title.discussions" /></a></li><li>
			<a href="<%= viewMembersTabURL %>" <c:if test="${tab1 == 'members'}">class="active"</c:if> ><liferay-ui:message key="label.members" /></a></li><li>
			<a href="<%= viewAdminTabURL %>" <c:if test="${tab1 == 'admin'}">class="active"</c:if> ><liferay-ui:message key="label.admin" /></a></li></c:if><c:if test="${isAdmin || isOwner}"><li>
			<a href="<%= viewSettingsTabURL %>" <c:if test="${tab1 == 'settings'}">class="active"</c:if> ><liferay-ui:message key="label.settings" /></a>
		</li></c:if>
	</ul>
	<ul class="sp-group-tabs horizontal sp-group-rfloat" style="border-width: 0px 0px 0px 1px; border-style: none none none solid; border-color: transparent transparent transparent #5E6170; margin: 0px;">
		<li><div align="center" style="padding: 0 15px; line-height: 1.2;"><div><b>${membersCount}</b></div><span><liferay-ui:message key="label.members" /></span></div></li>
		<li><div align="center" style="padding: 0 15px; line-height: 1.2;"><div><b>${discussionsCount}</b></div><span><liferay-ui:message key="label.title.discussions" /></span></div></li>
		<c:if test="${(isGroupPublic && isMember) || (isGroupMembersOnly && isMember) || (isGroupAdmin && (isAdmin || isOwner))}">
			<li><a class="sp-group-if-btn <c:if test="${tab1 == 'invite_friends'}">active</c:if>" href="<%= viewInviteFriendsTabURL %>">+ <liferay-ui:message key="label.title.invite" /></a></li>
		</c:if>
	</ul>
</div>