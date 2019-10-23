<%@page import="com.sambaash.platform.util.NotificationUtils"%>
<%@page import="com.sambaash.platform.util.SambaashUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.security.auth.AuthTokenUtil"%>
<%@page import="com.liferay.portlet.asset.model.AssetCategory"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<portlet:defineObjects />
<liferay-theme:defineObjects />
<portlet:resourceURL var="resourceURL" >
</portlet:resourceURL>

<section class="sp-inbox max-width padding-left-75 padding-right-75 padding-top-one padding-bottom-one box-sizing-border block   font-none">
	<div class="sp-inbox-wrap relative block">
		<section class="sp-inbox-section sp-inbox-section-left font-std inline-block width-20 align-top box-sizing-border ">
			<div class="sp-inbox-menu white">
				<div class="sp-inbox-compose btn-callout full-width text-center"> 
					<span id="compose">Compose</span>
				</div>
				<nav class="sp-inbox-menu-list block">
					<ul>
						<li class="in-menu-item ">
							<span id="inbox">Inbox <span id="unreadInbCount" class="callout-notification-count"></span></span>
							<ul>
								<li> <span id="requests">Request <span id="unreadReqCount" class="callout-notification-count"></span></span> </li>
								<li> <span id="invitations">Invitations <span id="unreadInvCount" class="callout-notification-count"></span></span> </li>
								<li> <span id="notifications">Notifications <span id="unreadNotfCount" class="callout-notification-count"></span></span></li>
								<li> <span id="groupAlerts">Group alerts <span id="unreadGrpAlertCount" class="callout-notification-count"></span></span> </li>
								<li> <span id="jobAlerts">Job alerts <span id="unreadJobAlertCount" class="callout-notification-count"></span></span> </li>
							</ul>
						</li>
						
						<li class="in-menu-item">
							<span id="sentMsgs">Sent</span>
						</li>
						<li  class="in-menu-item">
							<span id=draftMsgs>Drafts</span>
						</li>
						
						<li  class="in-menu-item">
							<span id="archivedMsgs">Archived</span>
						</li>
					
					</ul>
				</nav>
			</div>
		</section>
	</div>
</section>
<script src="/SPInbox-portlet/js/inboxCons.js" type="text/javascript"></script>
<script src="/SPInbox-portlet/js/inboxlinks.js" type="text/javascript"></script>
<script>
var ajax = '<%= resourceURL %>';
var links  = new inboxlinks(ajax, '${inboxUrl}');
</script>
