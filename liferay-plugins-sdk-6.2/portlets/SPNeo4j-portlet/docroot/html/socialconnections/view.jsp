<%@ page import="com.liferay.portal.service.UserLocalServiceUtil" %>

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

<portlet:resourceURL var="retrievePostsURL">
	<portlet:param name="action" value="retrievePosts"></portlet:param>
</portlet:resourceURL>
<portlet:resourceURL var="retrieveLikesURL">
	<portlet:param name="action" value="retrieveLikes"></portlet:param>
</portlet:resourceURL>
<portlet:resourceURL var="retrieveActivityURL">
	<portlet:param name="action" value="retrieveActivity"></portlet:param>
</portlet:resourceURL>
<portlet:resourceURL var="retrieveFollowersURL">
	<portlet:param name="action" value="retrieveFollowers"></portlet:param>
</portlet:resourceURL>
<portlet:resourceURL var="retrieveFollowingURL">
	<portlet:param name="action" value="retrieveFollowing"></portlet:param>
</portlet:resourceURL>

<%
String communityName = com.sambaash.platform.util.SambaashUtil.getCommunityName(themeDisplay.getScopeGroupId());
long profileUserId = com.sambaash.platform.util.SambaashUtil.getUserIdByScreenName(themeDisplay.getCompanyId(), themeDisplay.getURLCurrent());
int userPostsCount = SPNeoforjLocalServiceUtil.findUserPostsCount(profileUserId, themeDisplay.getCompanyId(), themeDisplay.getScopeGroupId(), themeDisplay.getLayout().getLayoutId());
int assetEntitiesUserLikesCount = SPNeoforjLocalServiceUtil.findAssetEntitiesUserLikesCount(profileUserId, themeDisplay.getCompanyId(), themeDisplay.getScopeGroupId(), themeDisplay.getLayout().getLayoutId());
int userFollowersCount = SPNeoforjLocalServiceUtil.findUserFollowersCount(profileUserId, themeDisplay.getCompanyId(), themeDisplay.getScopeGroupId(), themeDisplay.getLayout().getLayoutId());
int userFollowingCount = SPNeoforjLocalServiceUtil.findUserFollowingCount(profileUserId, themeDisplay.getCompanyId(), themeDisplay.getScopeGroupId(), themeDisplay.getLayout().getLayoutId());

com.liferay.portal.model.User profileUser = null;
if (profileUserId > 0) {
	try{
		profileUser = com.liferay.portal.service.UserLocalServiceUtil.getUser(profileUserId);
	}catch(com.liferay.portal.NoSuchUserException nsue) {
		// do nothing
	}
String showAboutClass = !portletPreferences.getValue("showAboutTab", "hide").equals("showAboutTab") ? "hide":"";
String showFollowersClass = !portletPreferences.getValue("showFollowersTab", "hide").equals("showFollowersTab") ? "hide":"";
String showActivitiesClass = !portletPreferences.getValue("showActivitiesTab", "hide").equals("showActivitiesTab") ? "hide":"";
String showFollowingsClass = !portletPreferences.getValue("showFollowingsTab", "hide").equals("showFollowingsTab") ? "hide":"";
String showLikesClass = !portletPreferences.getValue("showLikesTab", "hide").equals("showLikesTab") ? "hide":"";
String showPostsClass = !portletPreferences.getValue("showPostsTab", "hide").equals("showPostsTab") ? "hide":"";
%>
<div class="max-width">
<section class="sp-feeds">
	<div class="sp-feeds-wrap padding-bottom-half">
		
		<nav class="sp-feeds-tabs">
		
			<ul class="sp-tabs-index helper-clearfix">
				<li class="<%=showAboutClass%>">
					<a data-loaded="false" href="javascript:;" id="sp_tab_about">About</a></li>
				<li class="<%=showPostsClass%>">
					<a data-loaded="false" href="javascript:;" id="sp_tab_posts"><b><%= userPostsCount %></b> Post(s)</a></li>
				<li class="<%=showLikesClass%>">
					<a data-loaded="false" href="javascript:;" id="sp_tab_likes"><b><%= assetEntitiesUserLikesCount %></b> Like(s)</a></li>
				<li class="<%=showActivitiesClass%>">
					<a data-loaded="false" href="javascript:;" id="sp_tab_activity">Activity</a></li>
				<li  class="<%=showFollowingsClass%>" style="float: right;">
					<a data-loaded="false" href="javascript:;" id="sp_tab_following"><b><%= userFollowingCount %></b> Following</a></li>
				<li  class="<%=showFollowersClass%>" style="float: right;">
					<a data-loaded="false" href="javascript:;" id="sp_tab_followers"><b><%= userFollowersCount %></b> Follower(s)</a></li>
			</ul>
		
		</nav>
		
		<div class="sp-tab-content-wrap padding-half white-bg">
			<div class="sp-tab-content" id="sp_tab_about_content">
				<c:if test="<%= profileUser != null %>">
					<c:out value="<%= profileUser.getFullName() %>" />
				</c:if>
			</div>
			<div class="sp-tab-content" id="sp_tab_posts_content">
				<div data-loadmore-dom-id="loadmore-container">
					<ul data-comment-dom-id="entry-container" data-loadmore-dom-id="items-container" >
					</ul>
					<div align="center" data-loadmore-dom-id="view-more-link-container" style="display: none;"><a id="sp_tab_posts_view_more_link" data-loadmore-dom-id="view-more-link" href="#" data-loadmore="{ &quot;retrieve_url&quot; : &quot;<%= retrievePostsURL %>&quot;, &quot;retrieve_params&quot; : { &quot;currentURL&quot; : &quot;<%= themeDisplay.getURLCurrent() %>&quot;, &quot;offset&quot; : 20, &quot;cur_showing_no&quot; : 0, &quot;init_total&quot; : 0 }, &quot;no_results_msg&quot; : &quot;NO RESULTS FOUND&quot;, &quot;no_more_results_msg&quot; : &quot;NO MORE RESULTS&quot;, &quot;error_msg&quot; : &quot;This stream is unavailable at this time. Please try again soon.&quot; }" class="sp-stream-load-more">Load More</a></div>
					<div align="center" class="sp-stream-load-more" data-loadmore-dom-id="loading-status" style="display: none;"><span>Loading...</span></div>
					<div align="center" class="sp-stream-load-more" data-loadmore-dom-id="load-msg" style="display: none;"></div>
				</div>
			</div>
			<div class="sp-tab-content" id="sp_tab_likes_content">
				<div data-loadmore-dom-id="loadmore-container">
					<ul class="sp-horizontal sp-col3" data-comment-dom-id="entry-container" data-loadmore-dom-id="items-container">
					</ul>
					<div align="center" data-loadmore-dom-id="view-more-link-container" style="display: none;"><a id="sp_tab_likes_view_more_link" data-loadmore-dom-id="view-more-link" href="#" data-loadmore="{ &quot;retrieve_url&quot; : &quot;<%= retrieveLikesURL %>&quot;, &quot;retrieve_params&quot; : { &quot;currentURL&quot; : &quot;<%= themeDisplay.getURLCurrent() %>&quot;, &quot;offset&quot; : 20, &quot;cur_showing_no&quot; : 0, &quot;init_total&quot; : 0 }, &quot;no_results_msg&quot; : &quot;NO RESULTS FOUND&quot;, &quot;no_more_results_msg&quot; : &quot;NO MORE RESULTS&quot;, &quot;error_msg&quot; : &quot;This stream is unavailable at this time. Please try again soon.&quot; }" class="sp-stream-load-more">Load More</a></div>
					<div align="center" class="sp-stream-load-more" data-loadmore-dom-id="loading-status" style="display: none;"><span>Loading...</span></div>
					<div align="center" class="sp-stream-load-more" data-loadmore-dom-id="load-msg" style="display: none;"></div>
				</div>
			</div>
			<div class="sp-tab-content" id="sp_tab_activity_content">
				<div data-loadmore-dom-id="loadmore-container">
					<ul data-comment-dom-id="entry-container" data-loadmore-dom-id="items-container" >
					</ul>
					<div align="center" data-loadmore-dom-id="view-more-link-container" style="display: none;"><a id="sp_tab_activity_view_more_link" data-loadmore-dom-id="view-more-link" href="#" data-loadmore="{ &quot;retrieve_url&quot; : &quot;<%= retrieveActivityURL %>&quot;, &quot;retrieve_params&quot; : { &quot;currentURL&quot; : &quot;<%= themeDisplay.getURLCurrent() %>&quot;, &quot;offset&quot; : 20, &quot;cur_showing_no&quot; : 0, &quot;init_total&quot; : 0 }, &quot;no_results_msg&quot; : &quot;NO RESULTS FOUND&quot;, &quot;no_more_results_msg&quot; : &quot;NO MORE RESULTS&quot;, &quot;error_msg&quot; : &quot;This stream is unavailable at this time. Please try again soon.&quot; }" class="sp-stream-load-more">Load More</a></div>
					<div align="center" class="sp-stream-load-more" data-loadmore-dom-id="loading-status" style="display: none;"><span>Loading...</span></div>
					<div align="center" class="sp-stream-load-more" data-loadmore-dom-id="load-msg" style="display: none;"></div>
				</div>
			</div>
			<div class="sp-tab-content sp-tab-follow" id="sp_tab_following_content">
				<div data-loadmore-dom-id="loadmore-container">
					<ul class="sp-horizontal sp-col3" data-comment-dom-id="entry-container" data-loadmore-dom-id="items-container">
					</ul>
					<div align="center" data-loadmore-dom-id="view-more-link-container" style="display: none;"><a id="sp_tab_following_view_more_link" data-loadmore-dom-id="view-more-link" href="#" data-loadmore="{ &quot;retrieve_url&quot; : &quot;<%= retrieveFollowingURL %>&quot;, &quot;retrieve_params&quot; : { &quot;currentURL&quot; : &quot;<%= themeDisplay.getURLCurrent() %>&quot;, &quot;offset&quot; : 20, &quot;cur_showing_no&quot; : 0, &quot;init_total&quot; : 0 }, &quot;no_results_msg&quot; : &quot;NO RESULTS FOUND&quot;, &quot;no_more_results_msg&quot; : &quot;NO MORE RESULTS&quot;, &quot;error_msg&quot; : &quot;This stream is unavailable at this time. Please try again soon.&quot; }" class="sp-stream-load-more">Load More</a></div>
					<div align="center" class="sp-stream-load-more" data-loadmore-dom-id="loading-status" style="display: none;"><span>Loading...</span></div>
					<div align="center" class="sp-stream-load-more" data-loadmore-dom-id="load-msg" style="display: none;"></div>
				</div>
			</div>
			<div class="sp-tab-content sp-tab-follow" id="sp_tab_followers_content">
				<div data-loadmore-dom-id="loadmore-container">
					<ul class="sp-horizontal sp-col3" data-comment-dom-id="entry-container" data-loadmore-dom-id="items-container">
					</ul>
					<div align="center" data-loadmore-dom-id="view-more-link-container" style="display: none;"><a id="sp_tab_followers_view_more_link" data-loadmore-dom-id="view-more-link" href="#" data-loadmore="{ &quot;retrieve_url&quot; : &quot;<%= retrieveFollowersURL %>&quot;, &quot;retrieve_params&quot; : { &quot;currentURL&quot; : &quot;<%= themeDisplay.getURLCurrent() %>&quot;, &quot;offset&quot; : 20, &quot;cur_showing_no&quot; : 0, &quot;init_total&quot; : 0 }, &quot;no_results_msg&quot; : &quot;NO RESULTS FOUND&quot;, &quot;no_more_results_msg&quot; : &quot;NO MORE RESULTS&quot;, &quot;error_msg&quot; : &quot;This stream is unavailable at this time. Please try again soon.&quot; }" class="sp-stream-load-more">Load More</a></div>
					<div align="center" class="sp-stream-load-more" data-loadmore-dom-id="loading-status" style="display: none;"><span>Loading...</span></div>
					<div align="center" class="sp-stream-load-more" data-loadmore-dom-id="load-msg" style="display: none;"></div>
				</div>
			</div>
		</div>
		
	</div>
</section>
</div>
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

<script type="text/javascript">

AUI().ready('aui-carousel', function(A) {

	var view_more_link = getElementsByAttribute(document, "a", "data-loadmore-dom-id", "view-more-link");

	var load_more_obj = new LoadMoreNeo4j({
		'j_view_more_link' : view_more_link
	});

	new SimpleTabSheet({
		'j_tabsheet' : [
							{ 'j_tab' : document.getElementById("sp_tab_about"), 'j_tab_selected_by_default' : true },
							{ 'j_tab' : document.getElementById("sp_tab_posts"), 'j_tab_selected_by_default' : false },
							{ 'j_tab' : document.getElementById("sp_tab_likes"), 'j_tab_selected_by_default' : false },
							{ 'j_tab' : document.getElementById("sp_tab_activity"), 'j_tab_selected_by_default' : false },
							{ 'j_tab' : document.getElementById("sp_tab_followers"), 'j_tab_selected_by_default' : false },
							{ 'j_tab' : document.getElementById("sp_tab_following"), 'j_tab_selected_by_default' : false }
					   ]
	});

	A.one('#sp_tab_posts').on('click', function(event) {
		var tab_posts_node = event.currentTarget;
		var loaded = tab_posts_node.getAttribute('data-loaded');
		if (loaded === "false") {
			tab_posts_node.setAttribute('data-loaded', 'true');
			simulate(document.getElementById("sp_tab_posts_view_more_link"), "click");
		}
	});

	A.one('#sp_tab_likes').on('click', function(event) {
		var tab_likes_node = event.currentTarget;
		var loaded = tab_likes_node.getAttribute('data-loaded');
		if (loaded === "false") {
			tab_likes_node.setAttribute('data-loaded', 'true');
			simulate(document.getElementById("sp_tab_likes_view_more_link"), "click");
		}
	});

	A.one('#sp_tab_activity').on('click', function(event) {
		var tab_activity_node = event.currentTarget;
		var loaded = tab_activity_node.getAttribute('data-loaded');
		if (loaded === "false") {
			tab_activity_node.setAttribute('data-loaded', 'true');
			simulate(document.getElementById("sp_tab_activity_view_more_link"), "click");
		}
	});

	A.one('#sp_tab_followers').on('click', function(event) {
		var tab_followers_node = event.currentTarget;
		var loaded = tab_followers_node.getAttribute('data-loaded');
		if (loaded === "false") {
			tab_followers_node.setAttribute('data-loaded', 'true');
			simulate(document.getElementById("sp_tab_followers_view_more_link"), "click");
		}
	});

	A.one('#sp_tab_following').on('click', function(event) {
		var tab_following_node = event.currentTarget;
		var loaded = tab_following_node.getAttribute('data-loaded');
		if (loaded === "false") {
			tab_following_node.setAttribute('data-loaded', 'true');
			simulate(document.getElementById("sp_tab_following_view_more_link"), "click");
		}
	});

});

</script>
<%
}
%>