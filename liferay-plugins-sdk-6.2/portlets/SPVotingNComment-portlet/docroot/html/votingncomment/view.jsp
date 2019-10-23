<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page import="java.util.*" %>
<%@ page import="com.liferay.portal.kernel.util.StringPool" %>
<%@ page import="com.liferay.portal.util.PortalUtil" %>

<portlet:defineObjects />

<liferay-theme:defineObjects />

<script type="text/javascript" src="<c:url value="/js/comment_with_reply.js" />" ></script>
<script type="text/javascript" src="<c:url value="/js/load_more.js" />" ></script>

<portlet:resourceURL var="retrieveCommentsURL">
	<portlet:param name="action" value="retrieveComments"></portlet:param>
</portlet:resourceURL>

<portlet:resourceURL var="retrieveRepliesURL">
	<portlet:param name="action" value="retrieveReplies"></portlet:param>
</portlet:resourceURL>

<portlet:resourceURL var="addCommentURL">
	<portlet:param name="action" value="addComment"></portlet:param>
</portlet:resourceURL>

<portlet:resourceURL var="addReplyURL">
	<portlet:param name="action" value="addReply"></portlet:param>
</portlet:resourceURL>

<portlet:resourceURL var="deleteCommentURL">
	<portlet:param name="action" value="deleteComment"></portlet:param>
</portlet:resourceURL>

<script type="text/javascript">

	function <portlet:namespace />simulate(element, eventName) {
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

<%

boolean enableVoting = Boolean.valueOf(portletPreferences.getValue("enableVoting", StringPool.FALSE));
boolean enableComment = Boolean.valueOf(portletPreferences.getValue("enableComment", StringPool.FALSE));
boolean showComments = Boolean.valueOf(portletPreferences.getValue("showComments", StringPool.TRUE));

%>

	
<c:if test="${!noAssetFound}">
	<c:if test="<%=enableVoting %>">
		<c:if test="${commentToVote}">
			<div class="Style3">
				<div class="vote-me" <c:if test="${!themeDisplay.signedIn}">style="display: none;"</c:if> >
					<c:choose>
						<c:when test="${voted}">
							<span>VOTED</span>
						</c:when>
						<c:otherwise>
							<span style="display: none;"></span>
							<c:choose>
								<c:when test="${themeDisplay.signedIn}">
									<a data-vnc-voting-class-pk="${classPK}" class="vnc-vote-up-link" href="javascript:;" data-voteup="{ &quot;className&quot; : &quot;${className}&quot;,&quot;classPK&quot; : ${classPK}, &quot;userId&quot; : ${themeDisplay.userId}, &quot;ip&quot; : &quot;${ip}&quot;, &quot;isSignedIn&quot; : ${themeDisplay.signedIn}, &quot;isContestMember&quot; : ${isContestMember}}" >Vote to comment</a>
								</c:when>
								<c:otherwise>
									<a href="javascript:;" class="vnc-required-login">Vote to comment</a>
								</c:otherwise>
							</c:choose>
							
						</c:otherwise>
					</c:choose>
				</div>
			</div>
		</c:if>
	</c:if>
</c:if>

<c:if test="${commentToVote}">
	<div id="cnv_voted_successfully"></div>
</c:if>

<c:if test="<%=enableComment %>">
	<br/>
	<div data-vnc-comment-class-pk="${classPK}" data-vnc-comment-dom-id="comment-container" class="sp-comment-section">
		<div class="sp-pbs sp-ui-relative" style="<c:if test="${!showComments}">display: none;</c:if>">
			<span data-vnc-comment-dom-id="parent-count" class="sp-fwb sp-fsl"><c:out value="${parentCount}"></c:out></span>&nbsp;<span class="sp-fwb sp-fsn">comment(s)</span>
		</div>
		<c:if test="${themeDisplay.signedIn}">
			<div data-vnc-comment-dom-id="add-comment-form-container" class="sp-comment-composer" style="<c:if test="${commentToVote && !(participantVoting && voted)}">display: none;</c:if>">
				<div class="sp-comment-composer-inner">
					<img alt="User Image" data-vnc-comment-dom-id="avatar" src="/image/user_male_portrait?img_id=${themeDisplay.user.portraitId}" style="display: none;" class="avatar"/>
					<div data-vnc-comment-dom-id="add-comment-textarea-container">
						<form data-vnc-comment-dom-id="add-comment-form" action="<%=addCommentURL %>" method="post">
							<input type="hidden" name="<portlet:namespace />classPK" value="${classPK}" />
							<input type="hidden" name="<portlet:namespace />className" value="${className}"/>
							<input type="hidden" name="<portlet:namespace />commentToVote" value="false"/>
							<div class="sp-comment-textarea-outer">
								<textarea data-vnc-comment-dom-id="add-comment-textarea" style="height: 14px;">Add a comment...</textarea>
							</div>
							<div data-vnc-comment-dom-id="add-comment-submit" class="sp-mts" style="display: none;" align="right">
								<c:choose>
									<c:when test="${!commentServiceHasAccess}">
										<input type="button" value="Comment" class="sp-comment-btn small sp-service-access-check" name="<portlet:namespace />${commentServiceUserStatus}&upload=false" title="Permission Denied" />
									</c:when>
									<c:otherwise>
										<input type="submit" value="Comment" class="sp-comment-btn small"/>
									</c:otherwise>
								</c:choose>
							</div>
						</form>
					</div>
				</div>
			</div>
		</c:if>
		
		<div data-vnc-loadmore-dom-id="loadmore-container">
			<ul data-vnc-comment-dom-id="entry-container" data-vnc-loadmore-dom-id="items-container" class="sp-comment-entry-container" >
			</ul>
			<c:if test="${!noAssetFound}">
				<div data-vnc-loadmore-dom-id="view-more-link-container" class="sp-comment-more sp-mts" style="display: none;" align="center"><a id="vnc-view-more-link" data-vnc-loadmore-dom-id="view-more-link" href="#" data-vnc-loadmore="{ &quot;retrieve_url&quot; : &quot;<%=retrieveCommentsURL %>&quot;, &quot;retrieve_params&quot; : { &quot;class_pk&quot; : ${classPK}, &quot;class_name&quot; : &quot;${className}&quot;, &quot;offset&quot; : ${itermsPerPage}, &quot;cur_showing_no&quot; : 0, &quot;init_total&quot; : 0 }, &quot;no_results_msg&quot; : &quot;NO RESULTS FOUND&quot;, &quot;no_more_results_msg&quot; : &quot;NO MORE RESULTS&quot;, &quot;error_msg&quot; : &quot;This stream is unavailable at this time. Please try again soon.&quot; }">View more (<span data-vnc-loadmore-dom-id="unshown-status">0</span>)</a></div>
				<div data-vnc-loadmore-dom-id="loading-status" class="sp-pas"  style="display: none;" align="center"><span>Loading...</span></div>
				<div data-vnc-loadmore-dom-id="load-msg" class="sp-pas"  style="display: none;" align="center"></div>
			</c:if>
		</div>
		
	</div>
	
</c:if>

<script type="text/javascript">

	function animatedScrollTop(element, to, duration) {
		// document.title += " -to: " + to;
		// document.title += " -element.scrollTop: " + element.scrollTop;
	    if (duration <= 0) return;
	    var difference = to - element.scrollTop;
	    var perTick = difference / duration * 10;
	
	    setTimeout(function() {
	    	element.scrollTop = element.scrollTop + perTick;
	    	animatedScrollTop(element, to, duration - 10);
	    }, 10);
	}

</script>
	
<aui:script>

	AUI().use('event', 'node', function(A) {
	
	   	// Your code goes here
	   	
		var commentToVote = ${commentToVote};
		var enableContextRegistration = ${enableContextRegistration};
	   	
	   	var documentBody = A.one('document.body');
		if(documentBody) {
			documentBody.delegate(
				'click',
				function(event) {
				
					<%-- http://stackoverflow.com/questions/10435481/how-do-i-get-the-dom-node-within-a-yui-event-handler --%>
					var voteUpNode = event.currentTarget;
				   	var voteUpData = JSON.parse(voteUpNode.getAttribute('data-voteup'));
					var isContestMember = voteUpData.isContestMember;
					
					if(commentToVote) {
						if((enableContextRegistration && isContestMember) || !enableContextRegistration) {
						
							var cnv_voted_successfully_div = document.getElementById("cnv_voted_successfully");
							if(cnv_voted_successfully_div) {
								cnv_voted_successfully_div.innerHTML = "";
							}
							
							// document.title += " -commentToVote";
							var vnc_comment_container = getFirstElementsByAttribute(document, "div", "data-vnc-comment-dom-id", "comment-container");
							var vnc_entry_container = getFirstElementsByAttribute(document, "ul", "data-vnc-comment-dom-id", "entry-container");
							vnc_comment_container.setAttribute("data-vnc-comment-class-pk", voteUpData.classPK);
							var vnc_comment_add_textarea = getFirstElementsByAttribute(document, "textarea", "data-vnc-comment-dom-id", "add-comment-textarea");
							var vnc_add_comment_form_container = getFirstElementsByAttribute(document, "div", "data-vnc-comment-dom-id", "add-comment-form-container");
							var vnc_comment_add_form = getFirstElementsByAttribute(document, "form", "data-vnc-comment-dom-id", "add-comment-form");
							if(vnc_add_comment_form_container) {
								vnc_comment_add_form.elements["classPK"].value = voteUpData.classPK;
								vnc_comment_add_form.elements["className"].value = voteUpData.className;
								vnc_comment_add_form.elements["commentToVote"].value = "true";
								vnc_add_comment_form_container.style.display = "block";
								vnc_add_comment_form_container.scrollIntoView();
							}
							if(vnc_entry_container) {
								vnc_entry_container.innerHtml = "";
							}
							if(vnc_comment_add_textarea) {
								// document.title += " -simulate focus";
								<portlet:namespace />simulate(vnc_comment_add_textarea, "focus");
							}
						}else {
							<portlet:namespace />callPopup("", "Please complete contest registration.");
						}
					}else {
						<portlet:namespace />voteUp(voteUpNode, voteUpData);
					}
				},
				'.vnc-vote-up-link'
			);
		}
		
	});
		
	Liferay.provide(
		window,
		'<portlet:namespace />voteUp', 
		function(voteUpNode, voteUpData) {
			var A = AUI();
			
			Liferay.Service.Voting.Voting.voteUp(
				{
					className : voteUpData.className, 
					classPK : voteUpData.classPK, 
					userId : voteUpData.userId, 
					ip : voteUpData.ip, 
					isSignedIn : voteUpData.isSignedIn
				},
		        function(message) {
			    	var exception = message.exception;
			
			        if (!exception) {
	       	     		// Process Success
						var textMsgSpan = voteUpNode.previous();
						var pDiv = A.one(voteUpNode).ancestor("div");
		              	pDiv.setStyle("background-color", "#319c18");
						var newTextMsg = "VOTED";
		              	voteUpNode.remove();
						textMsgSpan.text(newTextMsg).setStyle("display", "inline");
					}else {
		            	// Process Exception
						alert("Oops! An error occurred while processing your request.");
		           	}
		        }
			);
			
		},
		['aui-base']
	);

</aui:script>
	
<script type="text/javascript">

	AUI().ready('', function(A) {
	
		var vnc_comment_container = getElementsByAttribute(document, "div", "data-vnc-comment-dom-id", "comment-container");

		var vnc_comment_add_form = getElementsByAttribute(document, "form", "data-vnc-comment-dom-id", "add-comment-form");
		var vnc_comment_add_textarea = getElementsByAttribute(document, "textarea", "data-vnc-comment-dom-id", "add-comment-textarea");
		new CommentWithReplyVNC({
			'j_comment_container' : vnc_comment_container,
			'j_comment_add_form' : vnc_comment_add_form,
			'j_comment_add_textarea' : vnc_comment_add_textarea,
			'_delete_comment_url' : '<%=deleteCommentURL %>',
			'_comment_to_vote' : ${commentToVote},
			'_participant_voting' : ${participantVoting},
			'_show_comments' : <%=showComments %>
		});

		<c:if test="${!noAssetFound}">
			<c:if test="<%=showComments %>">
				var vnc_load_more_obj = new LoadMoreVNC({
					'j_load_more_delegation' : vnc_comment_container
				});
	
				function isInitVNCViewMoreLinkClickEvent() {
					// document.title += " -isInitViewMoreLinkClickEvent";
					if(vnc_load_more_obj.initViewMoreLinkClickEvent == true) {
						// document.title += " -simulate";
						<portlet:namespace />simulate(document.getElementById("vnc-view-more-link"), "click");
					}else {
						// document.title += " -waitToInitViewMoreLinkClickEvent";
					   	window.setTimeout(function() {
					   		isInitVNCViewMoreLinkClickEvent();
				        }, 1000);
					}
				}
			   	
				isInitVNCViewMoreLinkClickEvent();
	
			</c:if>
		</c:if>
		
	});

</script>

<aui:script use="aui-button-item-deprecated,liferay-util-window">	

	AUI().use('event', 'node', function(A) {
		
		var documentBody = A.one('document.body');
		if(documentBody) {
			documentBody.delegate(
				'click',
				function(event) {
					<portlet:namespace />callPopup("Required Login", '<p>Please <a href="/signin"><b>Login</b></a> to continue !</p>');
				},
				'.vnc-required-login'
			);
		}
		
	});

</aui:script >

<aui:script >

	function <portlet:namespace />callPopup(title, content){
	
		AUI().ready('aui-dialog', 'aui-overlay-manager', 'dd-constrain', function(A) {
		
			var dialog = Liferay.Util.Window.getWindow(
{
dialog: {
			
			title: title,
			
			centered: true,
			
			modal: true,
			
			width: 500,
			
			height: 250,
			
			bodyContent: content
			
			}}).render();
		
		});
	
	}

</aui:script >

	
