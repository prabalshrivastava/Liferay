<%@page import="com.sambaash.platform.util.SambaashUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%
String twShareText = portletPreferences.getValue("twShareText", StringPool.BLANK);
String gplusShareText = portletPreferences.getValue("gplusShareText", StringPool.BLANK);
String googleClientId = portletPreferences.getValue("googleClientId", StringPool.BLANK);

joinSPGroupURL += SambaashUtil.getPortalURL(themeDisplay.getCompanyId(), themeDisplay.getScopeGroupId()) + "/signin?redirect=" + joinSPGroupURL;
%>

<%--<div align="center" class="sp-group-if-guideline">
	<div align="left" class="sp-group-clearfix" style="width: 400px">
		<div class="sp-group-lfloat sp-group-mrm" style="line-height: 1;"><img src="${ctx}/images/InviteFriends_icon.png" /></div>
		<div class="sp-group-ui-oh">
			<div class="sp-group-ui-dib">
				<div class="sp-group-ui-dib sp-group-ui-vam" style="height: 51px;"></div><div class="sp-group-ui-dib sp-group-ui-vam">
					<h1 style="color: #FFFFFF; margin-bottom: 5px;;"><liferay-ui:message key="label.invite.friends" /></h1>
					<p><liferay-ui:message key="label.click.to.invite.friends" /></p>
				</div>
			</div>
		</div>
	</div>
</div>

 <ul class="sp-group-tabs horizontal" id="<portlet:namespace />inviteFriendsTabsContainer" style="padding-bottom: 8px; border-bottom: 0 none; <c:choose><c:when test="${tab2 == 'facebook'}">background-color: #406290;</c:when><c:when test="${tab2 == 'email'}">background-color: #795B9B;</c:when><c:otherwise></c:otherwise></c:choose>">
	<li style="width: 25%;">
		
		<a href="<%= viewInviteFriendsFacebookTabURL %>" id="<portlet:namespace />inviteFriendsFacebookTab" style="background-color: #406290; padding: 15px 0; text-align: center;"><img src="${ctx}/images/Facebook.png" /><span style="display: block;">Facebook</span></a>
		
		<% if (SambaashUtil.isSocialShareEnabled()) { %>
			<a href="javascript:;" id="<portlet:namespace />inviteFriendsFacebookTab" style="background-color: #406290; padding: 15px 0; text-align: center;"><img src="${ctx}/images/Facebook.png" /><span style="display: block;">Facebook</span></a></li><li style="width: 25%;">
			<a data-text="<%= twShareText %>" data-url="<%= viewDiscussionsTabURL %>" href="javascript:;" id="<portlet:namespace />inviteFriendsTwitterTab" style="background-color: #56B0CA; padding: 15px 0; text-align: center;"><img src="${ctx}/images/Twitter.png" /><span style="display: block;">Twitter</span></a></li><li style="width: 25%;">
			
			<a href="<%= viewInviteFriendsGmailTabURL %>" id="<portlet:namespace />inviteFriendsGmailTab" style="background-color: #D45648; padding: 15px 0; text-align: center;"><img src="${ctx}/images/Gmail.png" /><span style="display: block;">Gmail</span></a>
			<a href="javascript:;" id="<portlet:namespace />inviteFriendsGmailTab" style="background-color: #D45648; padding: 15px 0; text-align: center;"
				class="g-interactivepost"
				data-clientid="<%= googleClientId %>"
			    data-contenturl="<%= viewDiscussionsTabURL %>"
			    data-calltoactionlabel="JOIN_ME"
			    data-calltoactionurl="<%= joinSPGroupURL %>"
			    data-cookiepolicy="single_host_origin"
			    data-prefilltext="<%= gplusShareText %>"><img src="${ctx}/images/gplus.png" /><span style="display: block;">Google+</span></a></li><li style="width: 25%;">
		<% } %> 
		<a href="<%= viewInviteFriendsEmailTabURL %>" id="<portlet:namespace />inviteFriendsEmailTab" style="background-color: #795B9B; padding: 15px 0; text-align: center;"><img src="${ctx}/images/email.png" /><span style="display: block;">Email</span></a></li>
</ul>--%>

<%--
<c:choose>
	<c:when test="${tab2 == 'facebook'}">
		<%@ include file="../include/invite_friends/facebook.jsp" %>
	</c:when>
	<c:when test="${tab2 == 'gmail'}">
		<%@ include file="../include/invite_friends/gmail.jsp" %>
	</c:when>
	<c:when test="${tab2 == 'email'}">
		<%@ include file="../include/invite_friends/email.jsp" %>
	</c:when>
	<c:otherwise>
	</c:otherwise>
</c:choose>
--%>

		<%@ include file="../include/inviteFriends/email.jsp" %>


<script type="text/javascript">

	AUI().ready('', function(A) {

		var inviteFriendsFacebookTab = A.one("#<portlet:namespace />inviteFriendsFacebookTab");

		if (inviteFriendsFacebookTab) {
			inviteFriendsFacebookTab.on('click', function() {
				FB.ui({
				  method: 'send',
				  link: '<%= viewDiscussionsTabURL %>'
				});
		    });
		}

		var inviteFriendsTwitterTab = document.getElementById("<portlet:namespace />inviteFriendsTwitterTab");

		if (inviteFriendsTwitterTab) {

			if (navigator.appName == 'Microsoft Internet Explorer') {
				addEventHandler(inviteFriendsTwitterTab, "click", inviteFriendsTwitterTabOnClick);
			}else {
				inviteFriendsTwitterTab.addEventListener ("click", inviteFriendsTwitterTabOnClick, false);
			}

		}

		function inviteFriendsTwitterTabOnClick(e) {
			var text = inviteFriendsTwitterTab.getAttribute("data-text");
			var url = inviteFriendsTwitterTab.getAttribute("data-url");
			var encoded_url = encodeURIComponent(url);
			var tweet_url = "https://twitter.com/intent/tweet?text=" + text + "&url=" + encoded_url;

			var screen_w = screen.width;
			var screen_h = screen.height;

			var tweet_window_w = 550;
			var tweet_window_h = 500;

			var tweet_window_left = (screen_w - tweet_window_w)/2;
			var tweet_window_top = (screen_h - tweet_window_h)/2;

			var tweet_window = window.open(tweet_url, "Share a link on Twitter", 'width=550,height=450,left=' + tweet_window_left + ',top=' + tweet_window_top);
			tweet_window.focus();

		}

	});

</script>