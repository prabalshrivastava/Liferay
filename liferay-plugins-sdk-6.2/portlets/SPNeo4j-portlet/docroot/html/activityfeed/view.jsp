<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page import="java.util.*" %>
<%@ page import="com.sambaash.platform.portlet.spneo4j.util.SPNeo4jConstants.QuerySubFilter" %>

<portlet:defineObjects />

<liferay-theme:defineObjects />
<portlet:actionURL name="processAction" var="renderUrl" >
	<portlet:param name="action" value="filter"></portlet:param>
</portlet:actionURL> 
<portlet:resourceURL var="retrieveRealtimeActivityFeedsURL">
	<portlet:param name="action" value="retrieveRealtimeActivityFeeds"></portlet:param>
</portlet:resourceURL>

<portlet:resourceURL var="retrieveActivityFeedsURL">
	<portlet:param name="action" value="retrieveActivityFeeds"></portlet:param>
</portlet:resourceURL>

<portlet:resourceURL var="deleteCommentURL">
	<portlet:param name="action" value="deleteComment"></portlet:param>
</portlet:resourceURL>

<%
String filterType = (String) renderRequest.getParameter("filterType");
if (com.liferay.portal.kernel.util.Validator.isNull(filterType)) {
	filterType = "community";
}
String commSel = "community".equalsIgnoreCase(filterType) ? "selected" : "";
String follSel = "following".equalsIgnoreCase(filterType) ? "selected" : "";
String grpSel = "groups".equalsIgnoreCase(filterType) ? "selected" : "";
%>
<section class="sp-feeds margin-top-40">
	<div class="sp-feeds-wrap">
		<a class="btn-callout" data-activity-feed-dom-id="realtime-activity-feed-notification-btn" href="javascript:;" style="display: none;"><span data-activity-feed-dom-id="realtime-activity-feed-count"></span> New Stories</a>
		
		<div data-activity-feed-dom-id="activity-feed-container" data-loadmore-dom-id="loadmore-container">
			 <div class="sp-feeds-head">
			 	<!-- <h2>Recent Activity</h2> --> 
				 <div class="sp-feeds-select">
				    <select id="filterType">
				    	<option value="community" <%= commSel %>>Community</option>
				    	<option value="following" <%= follSel %>>Following</option>
<%-- 				    	<option value="groups" <%= grpSel %>>Groups</option> --%>
				    	<option value="community[<%= QuerySubFilter.ASSETS %>]" <%= grpSel %>>Album</option>
<%-- 				    	<option value="community[<%= QuerySubFilter.ASSET_TYPES %>]" <%= grpSel %>>Asset Types</option> --%>
				    	<option value="community[<%= QuerySubFilter.BLOGS %>]" <%= grpSel %>>Blogs</option>
				    	<option value="community[<%= QuerySubFilter.CHALLENGES %>]" <%= grpSel %>>Challenges</option>
				    	<option value="community[<%= QuerySubFilter.DISCUSSIONS %>]" <%= grpSel %>>Discussion Groups</option>
				    	<option value="community[<%= QuerySubFilter.EVENTS %>]" <%= grpSel %>>Events</option>
				    </select>
	    		</div>
	    	</div>
			<ul class="sp-feeds-activity" data-activity-feed-dom-id="container" data-comment-dom-id="entry-container" data-loadmore-dom-id="items-container">
				<li id="first_element_do_not_remove"></li>
			</ul>
			<div class="sp-feeds-loadmore" align="center" data-loadmore-dom-id="view-more-link-container" style="display: none;"><a id="sp_activity_feeds_view_more_link"   data-loadmore="{ &quot;retrieve_url&quot; : &quot;<%= retrieveActivityFeedsURL %>&quot;, &quot;retrieve_params&quot; : { &quot;filter_type&quot; : &quot;<%= filterType %>&quot;, &quot;offset&quot; : 10, &quot;cur_showing_no&quot; : 0, &quot;init_total&quot; : 0 }, &quot;no_results_msg&quot; : &quot;NO RESULTS FOUND&quot;, &quot;no_more_results_msg&quot; : &quot;NO MORE RESULTS&quot;, &quot;error_msg&quot; : &quot;This stream is unavailable at this time. Please try again soon.&quot; }" data-loadmore-dom-id="view-more-link" href="#"  class="sp-stream-load-more">Load More</a></div>
			<div  align="center" class="sp-stream-load-more width-75" data-loadmore-dom-id="loading-status" style="display: none;"><span>Loading...</span></div>
			<div  align="center" class="sp-stream-load-more width-75" data-loadmore-dom-id="load-msg" style="display: none;"></div>
		</div>
	</div>

</section>

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

	var realtime_activity_feed_count = 0;
	var realtime_activity_feed = {
		    activities: []
		};
	var realtime_activity_feed_notification_btn = getFirstElementsByAttribute(document, "a", "data-activity-feed-dom-id", "realtime-activity-feed-notification-btn");
	var realtime_activity_feed_count_span = getFirstElementsByAttribute(realtime_activity_feed_notification_btn, "span", "data-activity-feed-dom-id", "realtime-activity-feed-count");
	var retrieve_attempts_limit = 5;
	var retrieve_attempts = 0;

	var realtime_activity_feed_container = getFirstElementsByAttribute(document, "ul", "data-activity-feed-dom-id", "container");

	function showRealtimeActivityFeedNotification() {
	try{
		realtime_activity_feed_notification_btn.style.display = "block";
	}catch(err) {
		//alert(err);
		console.log(err);
	}
	}

	var stompClient = null;
	var username = '<%= themeDisplay.getUser().getScreenName() %>';
	var communityName = '${communityName}';
	var websocketUrl = '${websocketUrl}/connect';
	var filterType = '<%= filterType %>';

	function setConnected(connected) {
		realtime_activity_feed_count_span.innerHTML = '';
		realtime_activity_feed_notification_btn.style.display = "none";
	}

	function connect(username) {
	try{
		var socket = new SockJS(websocketUrl);
		stompClient = Stomp.over(socket);
		stompClient.connect({}, function(frame) {
		    setConnected(true);
		    console.log('Connected: ' + frame);
		    var subscribeUrl = '/user/' + username + '/' + communityName + '/activity_feed';
		    if (filterType == 'community') {
		    	subscribeUrl = '/topic/' + communityName + '/activity_feed';
		    }else if (filterType == "groups") {
		    	subscribeUrl = '/user/' + username + '/' + communityName + '/activity_feed/groups';
		    }
		    stompClient.subscribe(subscribeUrl, function(activityFeed) {
		    	/* {"className":"com.liferay.portlet.blogs.model.BlogsEntry","classPK":1,"type":1} */
		        realtime_activity_feed.activities.push(JSON.parse(activityFeed.body));
		    	realtime_activity_feed_count += 1;
		    	realtime_activity_feed_count_span.innerHTML = realtime_activity_feed_count;
		        /* showRealtimeActivityFeedNotification(); */

			   	window.setTimeout(function() {
					simulate(realtime_activity_feed_notification_btn, "click");
		        }, 0);
		    });
		});
	}catch(err) {
		//alert(err);
		console.log(err);
	}
	}

	function disconnect() {
		stompClient.disconnect();
		setConnected(false);
		console.log("Disconnected");
	}

	function sendName() {
		var name = document.getElementById('name').value;
		stompClient.send("/app/connect", {}, JSON.stringify({ 'name': name }));
	}

	<c:if test="${websocketEnabled}">
		connect(username);
	</c:if>

	var xhr = null;

	/**
	* Ajax Get
	*/
	function AjaxGet(url, successFunc, errorFunc) {
	try{
		if (window.XMLHttpRequest) {
			/* code for IE7+, Firefox, Chrome, Opera, Safari */
		  	xhr = new XMLHttpRequest();
		}
		else {
			/* code for IE6, IE5 */
		 	xhr = new ActiveXObject("Microsoft.XMLHTTP");
		}
		xhr.onreadystatechange = function() {
			if (xhr.readyState == 4) {
			    if (xhr.status == 200) {
			    	successFunc();
			    }
			    else {
			    	errorFunc();
			    }
			}
		};

	   xhr.open("GET", url, true);
	   xhr.send(null);

	}catch(err) {
		/* alert("-AjaxGet: " + err); */
	}
	}

	/*
	 * element.style.opacity = .5; //For real browsers;
	 * element.style.filter = "alpha(opacity=50)"; //For IE;
	 */
	function animatedToShow(element, duration) {
	    if (duration <= 0) return;
		var difference = 1 - parseFloat(element.style.opacity);
	    var perTick = difference / duration * 10;

	    setTimeout(function() {
	    	element.style.opacity = parseFloat(element.style.opacity) + perTick;
	    	animatedToShow(element, duration - 10);
	    }, 10);
	}

	function realtimeActivityFeedNotificationOnClick() {
		var temp_url = '<%= retrieveRealtimeActivityFeedsURL %>';
		var activitiesString = JSON.stringify(realtime_activity_feed.activities);
		temp_url += "&activitiesString=" + activitiesString;
		AjaxGet(temp_url, showRealtimeActivityFeedNotificationSuccess, showRealtimeActivityFeedNotificationError);
	}

	function showRealtimeActivityFeedNotificationSuccess() {
	try{
		var data = JSON.parse(xhr.responseText);
		var items = data.items;
		if (items.length == 0) {
			if (retrieve_attempts < retrieve_attempts_limit) {
	    		retrieve_attempts += 1;
			   	window.setTimeout(function() {
					simulate(realtime_activity_feed_notification_btn, "click");
		        }, 5000);

			}else {
				/* give up and reset */
				reset();
			}
		}else {
			reset();
			for (var i = 0; i < items.length; i++) {
				var temp_div = document.createElement('div');
				temp_div.innerHTML = items[i].html;
				realtime_activity_feed_container.insertBefore(temp_div.firstChild, getFirstChild(realtime_activity_feed_container));
				animatedToShow(getFirstChild(realtime_activity_feed_container), 600);
			}
		}
	}catch(err) {
		//alert("-showRealtimeActivityFeedNotificationSuccess: " + err);
		console.log(err);
	}
	}

	function showRealtimeActivityFeedNotificationError() {
	try{
		alert("Oops! An error occurred while processing your request.");
	}catch(err) {
		alert("-showRealtimeActivityFeedNotificationError: " + err);
	}
	}

	function reset() {
		realtime_activity_feed_count = 0;
		realtime_activity_feed = {
		    activities: []
		};
		retrieve_attempts = 0;
		realtime_activity_feed_count_span.innerHTML = '';
		realtime_activity_feed_notification_btn.style.display = "none";
	}

	if (navigator.appName == 'Microsoft Internet Explorer') {
		addEventHandler(realtime_activity_feed_notification_btn, "click", realtimeActivityFeedNotificationOnClick);
	}else {
		realtime_activity_feed_notification_btn.addEventListener ("click", realtimeActivityFeedNotificationOnClick, false);
	}

	/*
	var view_more_link = getElementsByAttribute(document, "a", "data-loadmore-dom-id", "view-more-link");

	var load_more_obj = new LoadMore({
		'j_view_more_link' : view_more_link
	});
	*/

	var activity_feed_container = getElementsByAttribute(document, "div", "data-activity-feed-dom-id", "activity-feed-container");


	new LoadMoreNeo4j({
		'j_load_more_delegation' : activity_feed_container
	});

	new CommentWithReply({
		'j_comment_delegation' : activity_feed_container,
		'_delete_comment_url' : '<%= deleteCommentURL %>'
	});

	simulate(document.getElementById("sp_activity_feeds_view_more_link"), "click");

});

</script>

<aui:script>

AUI().use('event', 'node', function(A) {

	// Your code goes here

	var documentBody = A.one('document.body');
	if (documentBody) {
		documentBody.delegate(
			'click',
			function(event) {
				<%-- http://stackoverflow.com/questions/10435481/how-do-i-get-the-dom-node-within-a-yui-event-handler --%>
				var likeNode = event.currentTarget;
				document.title += " -before like action";
				<portlet:namespace />like(likeNode);
			},
			'.splike-link-like'
		);
	}

});

Liferay.provide(
	window,
	'<portlet:namespace />like',
	function(likeNode) {
	   	var likeData = JSON.parse(likeNode.getAttribute('data-like'));
		document.title += " -likeData: " + likeData;
		var A = AUI('aui-node','aui-base','aui-io-request-deprecated');
		var ajaxUrl = "/api/jsonws/SPNeo4j-portlet.spneoforj/like?p_auth=" + Liferay.authToken;
		A.io.request(ajaxUrl,{
			dataType : 'json',
			method : 'POST',
			data : {
				companyId : likeData.companyId,
				groupId: likeData.groupId,
				layoutSetId: likeData.layoutSetId,
				action : likeData.action,
				startUserId : likeData.startUserId,
				endEntityClassName : likeData.endEntityClassName,
				endEntityId : likeData.endEntityId
			},
			on : {
				success : function() {
					var data = this.get('responseData');
					var exception = data.exception;
					if(!exception) {
						var action = likeData.action;
	
						if (action === "like") {
							action = "unlike";
						} else if (action === "unlike") {
							action = "like";
						}
						likeData["action"] = action;
						likeNode.setAttribute("data-like", JSON.stringify(likeData, "", ""));
	
						var likeCountElem = likeNode.ancestor(".sp-activity-like-comment").one('.sp-lc');
						var likeCount = parseInt(likeCountElem.text());
	
						if (action === "like") {
							likeNode.removeClass("splike-liking");
							likeNode.addClass("splike-like");
							likeCountElem.text(likeCount - 1);
						} else if (action === "unlike") {
							likeNode.removeClass("splike-like");
							likeNode.addClass("splike-liking");
							likeCountElem.text(likeCount + 1);
						}
					}
				},
				failure : function() {
					console.log("Oops! An error occurred while processing your request.")
					//alert("Oops! An error occurred while processing your request.");
				} 
			}
		});
		
	},
	['aui-base']
);

</aui:script>