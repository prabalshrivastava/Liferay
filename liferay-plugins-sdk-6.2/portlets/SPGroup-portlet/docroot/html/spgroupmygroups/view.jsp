<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page import="java.util.*" %>

<portlet:defineObjects />

<liferay-theme:defineObjects />

<c:choose>

<c:when test="${themeDisplay.signedIn}">

	<script src="<c:url value="/js/json2.js" />" type="text/javascript"></script>
	<script src="<c:url value="/js/load_more.js" />" type="text/javascript"></script>

	<style type="text/css">

	</style>

	<%
	Date now = new Date();
	%>

	<portlet:resourceURL var="retrieveURL">
		<portlet:param name="action" value="retrieve"></portlet:param>
	</portlet:resourceURL>

	<div data-dom-id="load-more-delegation">

		<h2 class="sp-group-mbl"><liferay-ui:message key="label.my.groups" /></h2>

		<c:choose>
			<c:when test="${totalCount <= 0}">
				<p class="fsm fcl"><liferay-ui:message key="label.not.joined" /></p>
			</c:when>
			<c:otherwise>

				<div class="sp-group-pam" data-loadmore-dom-id="loadmore-container">
					<ul data-loadmore-dom-id="items-container">
					</ul>
					<div align="center" class="sp-gd-more sp-group-mts" data-loadmore-dom-id="view-more-link-container" style="display: none;"><a data-loadmore-dom-id="view-more-link" href="#" data-loadmore="{ &quot;retrieve_url&quot; : &quot;<%= retrieveURL %>&quot;, &quot;retrieve_params&quot; : { &quot;offset&quot; : 5, &quot;cur_showing_no&quot; : 0, &quot;init_total&quot; : ${totalCount} }, &quot;no_results_msg&quot; : &quot;NO RESULTS FOUND&quot;, &quot;no_more_results_msg&quot; : &quot;NO MORE RESULTS&quot;, &quot;error_msg&quot; : &quot;This stream is unavailable at this time. Please try again soon.&quot; }"><liferay-ui:message key="label.view.more" /> (<span data-loadmore-dom-id="unshown-status">${totalCount - 0}</span>)</a></div>
					<div align="center" class="sp-group-pas"  data-loadmore-dom-id="loading-status" style="display: none;"><span><liferay-ui:message key="label.loading" /></span></div>
					<div align="center" class="sp-group-pas"  data-loadmore-dom-id="load-msg" style="display: none;"></div>
				</div>

			</c:otherwise>
		</c:choose>

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

		var load_more_delegation = getFirstElementsByAttribute(document, "div", "data-dom-id", "load-more-delegation");

		var view_more_link = getElementsByAttribute(document, "a", "data-loadmore-dom-id", "view-more-link");

		var load_more_obj = new LoadMore({
			'j_view_more_link' : view_more_link
		});

		function isInitViewMoreLinkClickEvent() {
			if (load_more_obj.initViewMoreLinkClickEvent == true) {
				for (var i=0; i<view_more_link.length; i++) {
					simulate(view_more_link[i], "click");
				}
			}else {
			   	window.setTimeout(function() {
					isInitViewMoreLinkClickEvent();
		        }, 1000);
			}
		}

		isInitViewMoreLinkClickEvent();

	</script>

</c:when>

<c:otherwise>

</c:otherwise>

</c:choose>