<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page import="java.util.*" %>
<%@ page import="com.sambaash.platform.util.*" %>
<%@ page import="com.liferay.portal.util.PortalUtil" %>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil" %>
<%@page import="com.liferay.portlet.blogs.model.BlogsEntry" %>

<portlet:defineObjects />

<liferay-theme:defineObjects />


<liferay-util:html-top>                                                                                                                                                    
        <meta property="og:title" content="${ogtitle}"/>                                                                                                                   
        <meta property="og:description" content="${ogdescription}"/>                                                                                                       
        <meta property="og:image" content="${ogimage}"/>                                                                                                                   
        <meta property="og:url" content="${ogurl}"/>                                                                                                                       
        <meta property="og:type" content="Blog"/>                                                                                                                       
</liferay-util:html-top>  
	
<script type="text/javascript" src="<c:url value="/js/load_more.js?minifierType=js"/>" async></script>
<link href="//vjs.zencdn.net/4.4/video-js.css" rel="stylesheet">
<script src="//vjs.zencdn.net/4.4/video.js" async></script>

<portlet:resourceURL var="retrieveURL">
	<portlet:param name="action" value="retrieve"></portlet:param>
	<portlet:param name="urlTitle" value="${spBlogWrapper.urlTitle}"></portlet:param>
</portlet:resourceURL>

<portlet:resourceURL var="retrieveHilightURL">
	<portlet:param name="action" value="retrieveHilight"></portlet:param>
</portlet:resourceURL>

<%
boolean isAdmin = SambaashUtil.isAdmin(themeDisplay.getScopeGroupId(), themeDisplay.getUserId()); 
%>
<div class="spblogs-stream-container screen-max-width margin-top-40 block max-width padding-top-one padding-bottom-one box-sizing-border admin-${isAdmin}">
	<div id="spblogs-stream" class="spblogs-stream spblogs-fixed profile_form_navigation block white-bg  ">
		<div id="spblogs-stream-switcher " class="aui-helper-clearfix block padding-quarter theme-bg-2 border-bottom">
			<div class="spblogs-select relative">
				<span class="block absolute padding-quarter font-up"><%=LanguageUtil.get(pageContext,"label.all.categories")%><c:if test="${not empty channel}"> / ${channel}</c:if></span>
				<select class="spblogs-channel-select" name="channel" id="spblogs-channel-select" style="opacity: 0; display: inline-block;" onchange="channelOnChange(this)">
					<option value=""><%=LanguageUtil.get(pageContext,"label.all.categories")%></option>
					<c:forEach items="${allChannelWrappers}" var="allChannelWrapper">
						<%-- <optgroup label="${allChannelWrapper.vocabularyName}"> --%>
							<c:forEach items="${allChannelWrapper.channelWrappers}" var="channelWrapper">
								<option value="${channelWrapper.categoryName}" <c:if test="${channel eq channelWrapper.categoryName}">selected="selected"</c:if>><c:if test="${channelWrapper.child}">---</c:if>${channelWrapper.categoryName}</option>
							</c:forEach>
						<!-- </optgroup> -->
					</c:forEach>
				</select>
			</div>
		</div>
		<div id="spblogs-stream-list" data-loadmore-dom-id="loadmore-container" class="block ">
			<ul data-comment-dom-id="entry-container" data-loadmore-dom-id="items-container" class="block">
			</ul>
			<div data-loadmore-dom-id="view-more-link-container" style="display: none;" align="center"><a id="spblogs-stream-view-more-link" data-loadmore-dom-id="view-more-link" href="#" data-loadmore="{ &quot;retrieve_url&quot; : &quot;<%=retrieveURL %>&quot;, &quot;retrieve_params&quot; : { &quot;channel&quot; : &quot;${channel}&quot;, &quot;offset&quot; : ${itermsPerPage}, &quot;cur_showing_no&quot; : 0, &quot;init_total&quot; : 0 }, &quot;no_results_msg&quot; : &quot;NO RESULTS FOUND&quot;, &quot;no_more_results_msg&quot; : &quot;NO MORE RESULTS&quot;, &quot;error_msg&quot; : &quot;This stream is unavailable at this time. Please try again soon.&quot; }" class="spblogs-stream-load-more"><%=LanguageUtil.get(pageContext,"label.load.more")%></a></div>
			<div data-loadmore-dom-id="loading-status" class="spblogs-stream-load-more" style="display: none;" align="center"><span>Loading...</span></div>
			<div data-loadmore-dom-id="load-msg" class="spblogs-stream-load-more" style="display: none;" align="center"></div>
			
		</div>
	</div>
	<div class="helper-clearfix block full-width relative" id="spblogs-content">
		<div id="spblogs-main">
			<c:if test="${not empty spBlogWrapper}">
				<div id="spblogs-article-wrapper">
					<div class="spblogs-article white-bg">
						<div class="spblogs-article-head block text-center padding padding-bottom-none helper-clearfix">
							<h1 class="h1 spblogs-article-title inline-block theme-color" >${spBlogWrapper.title}</h1>
							<div class="spblogs-article-author block padding-bottom-half">
								<span class="spblogs-article-author-name author-name">By <a rel="author" title="Posts by ${spBlogWrapper.author}" href="">${spBlogWrapper.author}</a>, </span>
								<span class="spblogs-article-date author-date">${spBlogWrapper.displayDateString}</span>
							</div>
							
							<div class="spblogs-article-meta-wrapper block">
								<div class="spblogs-article-meta helper-clearfix">
									<c:choose>
										<c:when test="${socialShare}">
												<div id="socialBookmarks">
													<liferay-ui:social-bookmarks
														displayStyle="horizontal"
														target="_blank" title="${spBlogWrapper.title}"
														url="${spBlogWrapper.detailUrl}" />
												</div>
										</c:when>
									</c:choose>
									<div class="spblogs-nav-buttons block padding-top-half padding-bottom-half text-right">
										<c:choose>
											<c:when test="${not empty prevSPBlogWrapper}">
												<a title="${prevSPBlogWrapper.title}" class="spblogs-button btn-primary inline-block" href="${prevSPBlogWrapper.detailUrl}"><span class="">Previous</span></a>
											</c:when>
											<c:otherwise>
											</c:otherwise>
										</c:choose>

										<c:choose>
											<c:when test="${not empty nextSPBlogWrapper}">
												<a title="${nextSPBlogWrapper.title}" class="spblogs-button btn-primary inline-block margin-left-quarter" href="${nextSPBlogWrapper.detailUrl}" ><span class="">Next</span></a>
											</c:when>
											<c:otherwise>
											</c:otherwise>
										</c:choose>
									</div>
								</div>
							</div>

						</div>
						<div class="spblogs-article-body-wrapper block padding ">
							<div class="spblogs-article-body helper-clearfix block">
								<div>${spBlogWrapper.content}</div>
							</div>
						</div>
						<c:if test="${enableDisqus}">
							<div id="comments">
							    <div id="disqus_thread">&nbsp;</div>
							    <script type="text/javascript">
							    var disqus_shortname = '${disqusShortname}';
							    (function() {
							        var dsq = document.createElement('script');
							        dsq.type = 'text/javascript';
							        dsq.async = true;
							        dsq.src = '//' + disqus_shortname + '.disqus.com/embed.js';
							        (document.getElementsByTagName('head')[0] || document.getElementsByTagName('body')[0]).appendChild(dsq);
							    })();
							    </script>
							</div>
						</c:if>
						<c:if test="${enableComments}">
						<div id="blogsComments">
						<liferay-ui:panel-container extended="<%=false%>"
						    id="blogsCommentsPanelContainer" persistState="<%=true%>">
						
						    <liferay-ui:panel collapsible="<%=true%>" extended="<%=true%>"
						        id="blogsCommentsPanel" persistState="<%=true%>"
						        title='<%=LanguageUtil.get(pageContext, "comments")%>'>
						
						        <portlet:actionURL name="invokeTaglibDiscussion" var="discussionURL" />
						
						        <%
						        String currentUrl = PortalUtil.getCurrentURL(request);
						        %>
						
						        <liferay-ui:discussion className="<%=BlogsEntry.class.getName()%>"
						            classPK="${spBlogWrapper.entryId}"
						            formAction="<%=discussionURL%>" formName="fm2"
						            ratingsEnabled="<%=true%>" redirect="<%=currentUrl%>"
						            subject=""
						            userId="<%=themeDisplay.getUserId()%>" />
						
						    </liferay-ui:panel>
						</liferay-ui:panel-container>
						</div>
						</c:if>
					</div>
					<c:if test="${not empty relatedSPBlogWrappers}">
						<div class="spblogs-article-more helper-clearfix block padding-top-one">
							<h3>Related stories</h3>
							
							<div class="loopPostWrap block ">
								<c:forEach items="${relatedSPBlogWrappers}" var="relatedSPBlogWrapper" varStatus="status">
									<c:if test="${status.count < 7}">
										<div class="spblogs-loop-post" <c:if test="${status.count == 3 || status.count == 6}">style=""</c:if>>
											<div class="spblogs-loop-post-content helper-clearfix">
												<div class="spblogs-loop-post-image">
													<a class="spblogs-post-link" href="${relatedSPBlogWrapper.detailUrl}" title="${relatedSPBlogWrapper.title}"><img src="${relatedSPBlogWrapper.imageUrl}" alt="${relatedSPBlogWrapper.title}" title="${relatedSPBlogWrapper.title}"></a>
												</div>
												<h2><a class="spblogs-post-link" href="${relatedSPBlogWrapper.detailUrl}" title="${relatedSPBlogWrapper.title}">${relatedSPBlogWrapper.title}</a></h2>
											</div>
										</div>
										
									</c:if>
								</c:forEach>
							</div>
						</div>
					</c:if>
				</div>
			</c:if>

			<c:if test="${not empty landingSPBlogWrappers}">
				<div id="spblogs-highlight">
					<div class="spblogs-highlight-wrapper helper-clearfix">
						<c:forEach var="spBlogLeft" end="0" items="${landingSPBlogWrappers}">
							<div class="spblogs-main-article">
								<div class="spblogs-main-content helper-clearfix">
									<div class="spblogs-main-content-image">
										<a href="${spBlogLeft.detailUrl}"><img alt="Blog Image"
											src="${spBlogLeft.imageUrl}"></a>
									</div>
									<div class="spblogs-main-content-head">
										<div class="spblogs-content-author">
											<span class="spblogs-article-author-name author-name">By <a
												rel="author" title="Posts by ${spBlogLeft.author}" href="">${spBlogLeft.author}</a>,
											</span> <span class="spblogs-article-date author-date">${spBlogLeft.displayDateString}</span>
										</div>
										<a href="${spBlogLeft.detailUrl}"><span
												class="spblogs-content-title">${spBlogLeft.title}</span></a>
									</div>
									<div class="main-content-excerpt">
										<p>
											${spBlogLeft.content} ... <a href="${spBlogLeft.detailUrl}">
												Keep Reading</a>
										</p>
									</div>

								</div>
							</div>
						</c:forEach>
						<div class="spblogs-main-content-right">

							<c:forEach var="spBlogRight" begin="1"
								items="${landingSPBlogWrappers}">
								<div class="spblogs-main">
									<div class="spblogs-main-image">
										<a href="${spBlogRight.detailUrl}"><img alt="Blog Image"
											src="${spBlogRight.imageUrl}"></a>
									</div>
									<div class="spblogs-main-content-head">
										<div class="spblogs-content-author">
											<span class="spblogs-article-author-name author-name">By <a
												rel="author" title="Posts by ${spBlogRight.author}" href="">${spBlogRight.author}</a>,
											</span> <span class="spblogs-article-date author-date">${spBlogRight.displayDateString}</span>
										</div>
										<a href="${spBlogRight.detailUrl}"><span
												class="spblogs-content-right-title">${spBlogRight.title}</span></a>
									</div>
								</div>
							</c:forEach>
						</div>
					</div>
				</div>
				
				<div data-loadmore-dom-id="loadmore-container" class="spblogs-hilight-loadmore-container">
					<ul data-comment-dom-id="entry-container" data-loadmore-dom-id="items-container" class="spblogs-horizontal">
					</ul>
					<div data-loadmore-dom-id="view-more-link-container" class="view-more-link" align="center" ><a data-loadmore-dom-id="view-more-link" href="#" data-loadmore="{ &quot;retrieve_url&quot; : &quot;<%=retrieveHilightURL %>&quot;, &quot;retrieve_params&quot; : { &quot;channel&quot; : &quot;${channel}&quot;, &quot;offset&quot; : 3, &quot;cur_showing_no&quot; : 0, &quot;init_total&quot; : 0 }, &quot;no_results_msg&quot; : &quot;NO RESULTS FOUND&quot;, &quot;no_more_results_msg&quot; : &quot;NO MORE RESULTS&quot;, &quot;error_msg&quot; : &quot;This stream is unavailable at this time. Please try again soon.&quot; }" class="spblogs-stream-load-more"><%=LanguageUtil.get(pageContext,"label.load.more")%></a></div>
					<div data-loadmore-dom-id="loading-status" class="spblogs-stream-load-more" style="display: none;" align="center"><span><%=LanguageUtil.get(pageContext,"label.page.load")%></span></div>
					<div data-loadmore-dom-id="load-msg" class="spblogs-stream-load-more" style="display: none;" align="center"></div>
				</div>

			</c:if>
		</div>
	</div>
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

	function channelOnChange(channelSelect) {
	try{
		var url = window.location.href;
		var baseURL = url;
		var tempArray = url.split("?");
		if (tempArray.length > 1) {
			baseURL = tempArray[0];
		}

		tempArray = baseURL.split("/-/")
		if (tempArray.length > 1) {
			baseURL = tempArray[0];
		}

		var channel = channelSelect.value;
		var finalURL = baseURL + "?channel=" + channel;
		window.location.href = finalURL;

	}catch(err) {
		alert(err);
	}
	}

	var showingBlog = false;

	AUI().ready('', function(A) {
		<c:if test="${not empty spBlogWrapper}">
	 		showingBlog = true;
	 	</c:if>

		var view_more_link = getElementsByAttribute(document, "a", "data-loadmore-dom-id", "view-more-link");

		var load_more_obj = new LoadMore({
			'j_view_more_link' : view_more_link
		});

		function isInitViewMoreLinkClickEvent() {
			if (load_more_obj.initViewMoreLinkClickEvent == true) {
				simulate(document.getElementById("spblogs-stream-view-more-link"), "click");
			}else {
			   	window.setTimeout(function() {
					isInitViewMoreLinkClickEvent();
		        }, 1000);
			}
		}

		isInitViewMoreLinkClickEvent();

		function setStreamListHeight() {
	        var viewportHeight = document.documentElement.clientHeight;
	        var height = viewportHeight - 76 - ${topAlign};
			document.getElementById("spblogs-stream-list").style.height = height + "px";
		}

		window.onresize = function(event) {
	        setStreamListHeight();
		}

		setStreamListHeight();

		initFixedCats();
	});


</script>

<script type="text/javascript">

	var spblogs_stream = document.getElementById("spblogs-stream");
	var spblogs_stream_top = spblogs_stream.offsetTop;

	var htmlElement = document.getElementsByTagName("html")[0];

</script>

<style type="text/css">

#spblogs-stream.spblogs-fixed {
    position: fixed;
    top:0;
    
    bottom: 0;
    
    <% if(isAdmin) { %>
    padding-top: ${topAlign +30}px;
    
    /*top: ${topAlign}px;*/
    <%} else {%>
    padding-top: ${topAlign}px;
    <%}%>
    
}

.vp1024 #spblogs-stream.spblogs-fixed {
    position: fixed;
    top:0;
    
    bottom: 0;
    
    <% if(isAdmin) { %>
    padding-top: 82px;
    
    /*top: ${topAlign}px;*/
    <%} else {%>
    padding-top: 52px;
    <%}%>
    
}

.spblogs-select span {
	font-size: 10pt;
}
</style>
