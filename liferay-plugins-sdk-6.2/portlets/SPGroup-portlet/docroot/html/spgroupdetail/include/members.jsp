<c:if test="${fn:length(spGroupPendingUserWrappers) > 0}">
<h4 class="sp-group-mbm">Waiting for approval (${fn:length(spGroupPendingUserWrappers)})</h4>
<ul class="sp-group-horizontal">
	<c:forEach items="${spGroupPendingUserWrappers}" var="spGroupPendingUserWrapper">

		<portlet:renderURL var="approveOfJoiningSPGroupURL">
			<portlet:param name="tab1" value="members" />
			<portlet:param name="action" value="approveOfJoiningSPGroup" />
			<portlet:param name="struts_action" value="/groups/view_entry" />
			<portlet:param name="urlTitle" value="<%= spGroup.getUrlTitle() %>" />
			<portlet:param name="selectedUserId" value="${spGroupPendingUserWrapper.userId}" />
		</portlet:renderURL>

		<portlet:renderURL var="rejectOfJoiningSPGroupURL">
			<portlet:param name="tab1" value="members" />
			<portlet:param name="action" value="rejectOfJoiningSPGroup" />
			<portlet:param name="struts_action" value="/groups/view_entry" />
			<portlet:param name="urlTitle" value="<%= spGroup.getUrlTitle() %>" />
			<portlet:param name="selectedUserId" value="${spGroupPendingUserWrapper.userId}" />
		</portlet:renderURL>

		<li class="sp-group-member">
			<div class="sp-group-clearfix">
				<a class="sp-group-lfloat sp-group-mrm" href="/${spGroupPendingUserWrapper.screenName}">
					<img alt="${spGroupPendingUserWrapper.screenName}" src="${spGroupPendingUserWrapper.pic}" style="width: 50px; height: 50px;" />
				</a>
				<div class="sp-group-ui-oh">
					<div class="sp-group-ui-dib">
						<div class="sp-group-ui-dib sp-group-ui-vam" style="height:50px;"></div><div class="sp-group-ui-dib sp-group-ui-vam">
							<p><a href="/${spGroupPendingUserWrapper.screenName}">${spGroupPendingUserWrapper.userName}</a></p>
						</div>
					</div>
				</div>
				<c:if test="${isOwner || isAdmin}">
					<a class="sp-group-settings" data-dom-id="dropdown-link" href="#"></a>
					<ul class="sp-group-dropdown-index" data-dom-id="dropdown-menu">
						<li><a href="${approveOfJoiningSPGroupURL}"><liferay-ui:message key="label.approve" /></a></li>
						<li><a href="${rejectOfJoiningSPGroupURL}"><liferay-ui:message key="label.reject" /></a></li>
					</ul>
				</c:if>
			</div>
		</li>
	</c:forEach>
</ul>
<br />
</c:if>

<h4 class="sp-group-mbm" style="margin:0 12px 10px 12px">Members (${fn:length(spGroupMemberWrappers)})</h4>
<ul class="sp-group-horizontal"><c:forEach items="${spGroupMemberWrappers}" var="spGroupMemberWrapper">

	<portlet:renderURL var="removeFromSPGroupURL">
		<portlet:param name="tab1" value="members" />
		<portlet:param name="action" value="removeFromSPGroup" />
		<portlet:param name="struts_action" value="/groups/view_entry" />
		<portlet:param name="urlTitle" value="<%= spGroup.getUrlTitle() %>" />
		<portlet:param name="selectedUserId" value="${spGroupMemberWrapper.userId}" />
	</portlet:renderURL>

	<portlet:renderURL var="promoteFromMemberToAdminURL">
		<portlet:param name="tab1" value="members" />
		<portlet:param name="action" value="promoteFromMemberToAdmin" />
		<portlet:param name="struts_action" value="/groups/view_entry" />
		<portlet:param name="urlTitle" value="<%= spGroup.getUrlTitle() %>" />
		<portlet:param name="selectedUserId" value="${spGroupMemberWrapper.userId}" />
	</portlet:renderURL>

	<portlet:renderURL var="promoteFromAdminToOwnerURL">
		<portlet:param name="tab1" value="members" />
		<portlet:param name="action" value="promoteFromAdminToOwner" />
		<portlet:param name="struts_action" value="/groups/view_entry" />
		<portlet:param name="urlTitle" value="<%= spGroup.getUrlTitle() %>" />
		<portlet:param name="selectedUserId" value="${spGroupMemberWrapper.userId}" />
	</portlet:renderURL>

	<portlet:renderURL var="demoteFromAdminToMemberURL">
		<portlet:param name="tab1" value="members" />
		<portlet:param name="action" value="demoteFromAdminToMember" />
		<portlet:param name="struts_action" value="/groups/view_entry" />
		<portlet:param name="urlTitle" value="<%= spGroup.getUrlTitle() %>" />
		<portlet:param name="selectedUserId" value="${spGroupMemberWrapper.userId}" />
	</portlet:renderURL>

	<%--

	<portlet:renderURL var="demoteFromOwnerToAdminURL">
		<portlet:param name="tab1" value="members" />
		<portlet:param name="action" value="demoteFromOwnerToAdmin" />
		<portlet:param name="struts_action" value="/groups/view_entry" />
		<portlet:param name="urlTitle" value="<%= spGroup.getUrlTitle() %>" />
		<portlet:param name="selectedUserId" value="${spGroupMemberWrapper.userId}" />
	</portlet:renderURL>

	 --%>

	<portlet:renderURL var="stepDownFromOwnerToAdminURL">
		<portlet:param name="tab1" value="members" />
		<portlet:param name="action" value="stepDownFromOwnerToAdmin" />
		<portlet:param name="struts_action" value="/groups/view_entry" />
		<portlet:param name="urlTitle" value="<%= spGroup.getUrlTitle() %>" />
	</portlet:renderURL>

	<portlet:renderURL var="stepDownFromAdminToMemberURL">
		<portlet:param name="tab1" value="members" />
		<portlet:param name="action" value="stepDownFromAdminToMember" />
		<portlet:param name="struts_action" value="/groups/view_entry" />
		<portlet:param name="urlTitle" value="<%= spGroup.getUrlTitle() %>" />
	</portlet:renderURL>

	<portlet:renderURL var="stepDownFromOwnerToMemberURL">
		<portlet:param name="tab1" value="members" />
		<portlet:param name="action" value="stepDownFromOwnerToMember" />
		<portlet:param name="struts_action" value="/groups/view_entry" />
		<portlet:param name="urlTitle" value="<%= spGroup.getUrlTitle() %>" />
	</portlet:renderURL>

	<li class="sp-group-member">
	<div class="sp-group-clearfix">
		<a class="sp-group-lfloat sp-group-mrm" href="/${spGroupMemberWrapper.screenName}">
			<img alt="${spGroupMemberWrapper.screenName}" src="${spGroupMemberWrapper.pic}" style="width: 50px; height: 50px;" />
		</a>
		<div class="sp-group-ui-oh">
			<div class="sp-group-ui-dib">
				<div class="sp-group-ui-dib sp-group-ui-vam" style="height:50px;"></div><div class="sp-group-ui-dib sp-group-ui-vam">
					<p><a href="/${spGroupMemberWrapper.screenName}">${spGroupMemberWrapper.userName}</a></p>
					<c:choose>
						<c:when test="${spGroupMemberWrapper.role == 2}">
							<span class="sp-group-fcl sp-group-mts sp-group-fss sp-group-fwb"><liferay-ui:message key="label.owner" /></span>
						</c:when>
						<c:when test="${spGroupMemberWrapper.role == 1}">
							<span class="sp-group-fcl sp-group-mts sp-group-fss sp-group-fwb"><liferay-ui:message key="label.admin" /></span>
						</c:when>
					</c:choose>
				</div>
			</div>
		</div>

		<c:choose>
			<c:when test="${isOwner}">
				<c:choose>
					<c:when test="${themeDisplay.userId == spGroupMemberWrapper.userId}">
						<a class="sp-group-settings" data-dom-id="dropdown-link" href="#"></a>
						<ul class="sp-group-dropdown-index" data-dom-id="dropdown-menu">
							<li><a href="${stepDownFromOwnerToAdminURL}"><liferay-ui:message key="label.step.down.owner.to.admin" /></a></li>
							<li><a href="${stepDownFromOwnerToMemberURL}"><liferay-ui:message key="label.step.down.owner.to.member" /></a></li>
						</ul>
					</c:when>
					<c:when test="${spGroupMemberWrapper.role == 1}">
						<a class="sp-group-settings" data-dom-id="dropdown-link" href="#"></a>
						<ul class="sp-group-dropdown-index" data-dom-id="dropdown-menu">
							<li><a href="${removeFromSPGroupURL}">Remove from group</a></li>
							<li><a href="${promoteFromAdminToOwnerURL}"><liferay-ui:message key="label.promote.from.admin.to.owner" /></a></li>
							<li><a href="${demoteFromAdminToMemberURL}"><liferay-ui:message key="label.demote.from.admin.to.member" /></a></li>
						</ul>
					</c:when>
					<c:when test="${spGroupMemberWrapper.role == 0}">
						<a class="sp-group-settings" data-dom-id="dropdown-link" href="#"></a>
						<ul class="sp-group-dropdown-index" data-dom-id="dropdown-menu">
							<li><a href="${removeFromSPGroupURL}"><liferay-ui:message key="label.remove.from.group" /></a></li>
							<li><a href="${promoteFromMemberToAdminURL}"><liferay-ui:message key="label.promote.from.member.to.admin" /></a></li>
						</ul>
					</c:when>
				</c:choose>
			</c:when>
			<c:when test="${isAdmin}">
				<c:choose>
					<c:when test="${themeDisplay.userId == spGroupMemberWrapper.userId}">
						<a class="sp-group-settings" data-dom-id="dropdown-link" href="#"></a>
						<ul class="sp-group-dropdown-index" data-dom-id="dropdown-menu">
							<li><a href="${stepDownFromAdminToMemberURL}"><liferay-ui:message key="label.demote.from.admin.to.member" /></a></li>
						</ul>
					</c:when>
					<c:when test="${spGroupMemberWrapper.role == 0}">
						<a class="sp-group-settings" data-dom-id="dropdown-link" href="#"></a>
						<ul class="sp-group-dropdown-index" data-dom-id="dropdown-menu">
							<li><a href="${removeFromSPGroupURL}"><liferay-ui:message key="label.remove.from.group" /></a></li>
						</ul>
					</c:when>
				</c:choose>
			</c:when>
			<c:otherwise>
				<%-- nothing --%>
			</c:otherwise>
		</c:choose>

	</div>
</li></c:forEach></ul>


<script type="text/javascript">

	/* ------------------------------ dropdown menu ------------------------------ */

	var dropdown_link = getElementsByAttribute(document, "a", "data-dom-id", "dropdown-link");
	var dropdown_menu = getElementsByAttribute(document, "ul", "data-dom-id", "dropdown-menu");

	if (dropdown_link != null) {
		for (var i=0; i<dropdown_link.length; i++) {
			if (navigator.appName == 'Microsoft Internet Explorer') {
				//document.title += "-using ie";
				addEventHandler(dropdown_link[i], "click", dropdownLinkOnClick);
			}else {
				dropdown_link[i].addEventListener ("click", dropdownLinkOnClick, false);
			}
		}
	}

	if (dropdown_menu != null) {
		for (var i=0; i<dropdown_menu.length; i++) {
			if (navigator.appName == 'Microsoft Internet Explorer') {
				//document.title += "-using ie";
				addEventHandler(dropdown_menu[i], "click", dropdownMenuOnClick);
			}else {
				dropdown_menu[i].addEventListener ("click", dropdownMenuOnClick, false);
			}
		}
	}

	if (navigator.appName == 'Microsoft Internet Explorer') {
		//document.title += "-using ie";
		addEventHandler(document, "click", documentOnClick);
	}else {
		document.addEventListener ("click", documentOnClick, false);
	}

	function hideActiveEl() {
	try{
		// hide active dropdown menu
		for (var i=0; i<dropdown_link.length; i++) {
			removeClass(dropdown_link[i], "active");
		}
		for (var i=0; i<dropdown_menu.length; i++) {
			removeClass(dropdown_menu[i], "active");
		}
	}catch(err) {
		alert(err);
	}
	}

	function dropdownLinkOnClick(e) {
		preventDefault(e);
		var target = getEventTarget(e);
		if (!hasClass(target,"active")) {
			hideActiveEl();
		}
		toggleClass(target, "active");
		toggleClass(getFirstElementsByAttribute(target.parentNode, "ul", "data-dom-id", "dropdown-menu"), "active");
	}

	function dropdownMenuOnClick(e) {
		stopPropagation(e);
	}

	function documentOnClick(e) {
		var target = getEventTarget(e);
		var target_dom_id = target.getAttribute("data-dom-id");
		if (target_dom_id != "dropdown-link") {
			hideActiveEl();
		}
	}

</script>
