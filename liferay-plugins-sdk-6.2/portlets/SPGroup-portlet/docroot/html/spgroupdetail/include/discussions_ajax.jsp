<%@page import="com.sambaash.platform.portlet.spgroup.util.Util"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.sambaash.platform.srv.spgroup.model.SPGroup"%>
<%@page import="com.sambaash.platform.srv.spgroup.NoSuchPrefException"%>
<%@page import="com.sambaash.platform.srv.spgroup.service.SPGroupPrefLocalServiceUtil"%>
<%@page import="com.sambaash.platform.srv.spgroup.model.SPGroupPref"%>
<%@page import="com.liferay.compat.portal.model.UserConstants"%>
<%
boolean subscribed = com.liferay.portal.service.SubscriptionLocalServiceUtil.isSubscribed(company.getCompanyId(), themeDisplay.getUserId(), SPGroup.class.getName(), spGroup.getSpGroupId());
SPGroupPref spGroupPref = null;
String portraitUrl = "";
try{
	
	if (themeDisplay.isSignedIn()) {
		portraitUrl = Util.getUserPortraitUrl(themeDisplay);
	}
	spGroupPref = SPGroupPrefLocalServiceUtil.getSPGroupPref(spGroup.getSpGroupId());
}catch(NoSuchPrefException nspe) {
}
%>

<div class="sp-gd-section" data-comment-dom-id="comment-container" data-comment-entry-id="<%= spGroup.getSpGroupId() %>">
	<div class="sp-group-pbs sp-group-ui-relative">
		<span class="sp-group-fwb sp-group-fsl" data-comment-dom-id="parent-count"><c:out value="${parentCount}"></c:out></span>&nbsp;<span class="sp-group-fwb sp-group-fsn"><liferay-ui:message key="label.discussion" /></span>
		<c:if test="${isMember}">

			<%
			if (spGroupPref != null && spGroupPref.getEnableSubscribeToComments()) {
			%>

			<c:choose>
				<c:when test="<%= subscribed %>">
					<a class="sp-mlm" data-subscribe="com.sambaash.platform.srv.spgroup.model.SPGroup_<%= spGroup.getSpGroupId() %>" href="javascript:subscribeToComments(false, 'com.sambaash.platform.srv.spgroup.model.SPGroup', <%= spGroup.getSpGroupId() %>);"><liferay-ui:message key="label.unsubscribe.discussion" /></a>
				</c:when>
				<c:otherwise>
					<a class="sp-mlm" data-subscribe="com.sambaash.platform.srv.spgroup.model.SPGroup_<%= spGroup.getSpGroupId() %>" href="javascript:subscribeToComments(true, 'com.sambaash.platform.srv.spgroup.model.SPGroup', <%= spGroup.getSpGroupId() %>);"><liferay-ui:message key="label.subscribe.discussion" /></a>
				</c:otherwise>
			</c:choose>

			<%
			}
			%>

		</c:if>
	</div>

<c:if test="${isMember || isAdmin}">
	<div class="sp-gd-composer" data-comment-dom-id="add-comment-form-container">
		<div class="sp-gd-composer-inner ${isMember}">
			<div class="avatar-wrap" data-comment-dom-id="avatar"><img alt="User Image" src="<%= portraitUrl %>" class="avatar" /></div>
			<div class="comment-container" data-comment-dom-id="add-comment-textarea-container">
				<form action="<%= addCommentURL %>" class="sp-gd-composer-form" data-comment-dom-id="add-comment-form" method="post">
					<input name="<portlet:namespace />classPK" type="hidden" value="<%= spGroup.getSpGroupId() %>" />
					<input name="<portlet:namespace />groupImageId" type="hidden" value="<%= spGroup.getImageId() %>" />
					<input name="<portlet:namespace />className" type="hidden" value="<%= SPGroup.class.getName() %>" />
					<div class="sp-gd-textarea-outer">
						<textarea data-comment-dom-id="add-comment-textarea" maxlength="75"><liferay-ui:message key="label.start.discussion" /></textarea>
					</div>
					<div class="group-noteText">*Maximum of 75 characters</div>
					<div class="sp-gd-textarea-outer sp-group-mtm" style="display: none;">
						<textarea data-comment-dom-id="add-comment-textarea-detail"><liferay-ui:message key="label.more.details" /></textarea>
					</div>
					<div class="sp-group-mtm" data-comment-dom-id="attach-content-container" style="background-color: white; border: 1px solid #DDDDDD; padding: 3px; display: none; position: relative; min-height: 85px;">
						<div align="center" class="sp-group-fss" data-comment-dom-id="attach-loading-status"><span>Loading...</span></div>
						<a data-comment-dom-id="attach-remove-link" href="#" style="position: absolute; right: 0px; line-height: 1; top: 3px; width: 10px; height: 10px; display: none;">x</a>
						<div data-comment-dom-id="attach-content" style="position: relative; margin-right: 10px; min-height: 50px; display: none;">

						</div>
						<div data-comment-dom-id="attach-nav-containter" style="width: 50px; height: 18px; position: relative; display: none;"><a data-comment-dom-id="attach-nav-left" style="left: 0px; position: absolute;">&lt;</a><a data-comment-dom-id="attach-nav-right" style="right: 0px; position: absolute;">&gt;</a></div>
					</div>
					<div class="attach-input-cont sp-group-clearfix sp-group-mtm" data-comment-dom-id="attach-input-containter" style="display: none;">
						<div class="sp-group-rfloat attach-cta">
							<a data-comment-dom-id="attach-link" href="#" style="line-height: 21px; text-decoration: underline;"><liferay-ui:message key="label.attach" /></a>
						</div>
						<div class="sp-group-ui-oh attach-textfield">
							<div class="sp-group-ui-dib" style="width: 100%;">
								<div class="sp-group-ui-dib sp-group-ui-vam" style="height: 21px;"></div>
								<div class="sp-group-ui-dib sp-group-ui-vam sp-group-fss" style="width: 98%;">
									<div class="sp-gd-textarea-outer">
										<textarea data-comment-dom-id="attach-input"><liferay-ui:message key="label.add.link" /></textarea>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="sp-group-clearfix sp-group-mtm">
						<div class="sp-group-rfloat">
							<div data-comment-dom-id="add-comment-submit">
								<c:choose>
									<c:when test="${!commentServiceHasAccess}">
										<input class="sp-gd-btn small sp-group-comment-service-access-check btn-primary" name="<portlet:namespace />${commentServiceUserStatus}&upload=false" title="Permission Denied" type="button" value='<%= LanguageUtil.get(pageContext,"label.post") %>' />
									</c:when>
									<c:when test="${!isMember}">
										<input class="sp-gd-btn small sp-group-comment-member-check btn-primary" name="<portlet:namespace />Only members can comment." title="Permission Denied" type="button" value='<%= LanguageUtil.get(pageContext,"label.post") %>' />
									</c:when>
									<c:otherwise>
										<input class="sp-gd-btn small btn-primary" type="submit" value='<%= LanguageUtil.get(pageContext,"label.post") %>'/>
									</c:otherwise>
								</c:choose>
							</div>
						</div>
						<div class="sp-group-ui-oh">
							<div class="sp-group-ui-dib">
								<div class="sp-group-ui-dib sp-group-ui-vam" style="height: 25px;"></div>
								<div class="sp-group-ui-dib sp-group-ui-vam">
									<a class="sp-group-fss" data-comment-dom-id="attach-a-link" href="#"><liferay-ui:message key="label.attach.link" /></a>
								</div>
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</c:if>

	<div data-loadmore-dom-id="loadmore-container">
		<ul class="sp-gd-entry-container" data-comment-dom-id="entry-container" data-loadmore-dom-id="items-container">
		</ul>
		<div align="center" class="sp-gd-more sp-group-mts" data-loadmore-dom-id="view-more-link-container" style="display: none;"><a data-loadmore-dom-id="view-more-link" href="#" data-loadmore="{ &quot;retrieve_url&quot; : &quot;<%=retrieveCommentsURL %>&quot;, &quot;retrieve_params&quot; : { &quot;class_pk&quot; : &quot;<%= spGroup.getSpGroupId() %>&quot;, &quot;url_title&quot; : &quot;<%= spGroup.getUrlTitle() %>&quot;, &quot;class_name&quot; : &quot;<%=SPGroup.class.getName() %>&quot;, &quot;offset&quot; : 5, &quot;cur_showing_no&quot; : 0, &quot;init_total&quot; : ${parentCount} }, &quot;no_results_msg&quot; : &quot;NO RESULTS FOUND&quot;, &quot;no_more_results_msg&quot; : &quot;NO MORE RESULTS&quot;, &quot;error_msg&quot; : &quot;This stream is unavailable at this time. Please try again soon.&quot; }"><liferay-ui:message key="label.view.more" /> (<span data-loadmore-dom-id="unshown-status">${parentCount - 0}</span>)</a></div>
		<div align="center" class="sp-group-pas"  data-loadmore-dom-id="loading-status" style="display: none;"><span><liferay-ui:message key="label.loading" /></span></div>
		<div align="center" class="sp-group-pas"  data-loadmore-dom-id="load-msg" style="display: none;"></div>
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

	var comment_container = getFirstElementsByAttribute(document, "div", "data-comment-dom-id", "comment-container");
	var view_more_link = getElementsByAttribute(document, "a", "data-loadmore-dom-id", "view-more-link");

	var load_more_obj = new LoadMore({
		'j_view_more_link' : view_more_link
	});

	var comment_add_form = getElementsByAttribute(document, "form", "data-comment-dom-id", "add-comment-form");
	var comment_add_text = getElementsByAttribute(document, "textarea", "data-comment-dom-id", "add-comment-text");
	var comment_add_textarea = getElementsByAttribute(document, "textarea", "data-comment-dom-id", "add-comment-textarea");
	var comment_add_textarea_detail = getElementsByAttribute(document, "textarea", "data-comment-dom-id", "add-comment-textarea-detail");
	var attach_a_link = getFirstElementsByAttribute(document, "a", "data-comment-dom-id", "attach-a-link");
	var attach_link = getFirstElementsByAttribute(document, "a", "data-comment-dom-id", "attach-link");
	var attach_remove_link = getFirstElementsByAttribute(document, "a", "data-comment-dom-id", "attach-remove-link");

	var attach_input_containter = getFirstElementsByAttribute(document, "div", "data-comment-dom-id", "attach-input-containter");
	var attach_input = getFirstElementsByAttribute(document, "textarea", "data-comment-dom-id", "attach-input");

	var attach_content_container = getFirstElementsByAttribute(document, "div", "data-comment-dom-id", "attach-content-container");
	var attach_content = getFirstElementsByAttribute(document, "div", "data-comment-dom-id", "attach-content");
	var attach_loading_status = getFirstElementsByAttribute(document, "div", "data-comment-dom-id", "attach-loading-status");

	var attach_nav_container = getFirstElementsByAttribute(document, "div", "data-comment-dom-id", "attach-nav-containter");
	var attach_nav_left = getFirstElementsByAttribute(document, "a", "data-comment-dom-id", "attach-nav-left");
	var attach_nav_right = getFirstElementsByAttribute(document, "a", "data-comment-dom-id", "attach-nav-right");

	new CommentWithReply({
		'j_comment_container' : comment_container,
		'j_comment_add_form' : comment_add_form,
		'j_comment_add_textarea' : comment_add_textarea,
		'j_comment_add_textarea_detail' : comment_add_textarea_detail,
		'j_attach_a_link' : attach_a_link,
		'j_attach_link' : attach_link,
		'j_attach_input_containter' : attach_input_containter,
		'j_attach_input' : attach_input,
		'j_attach_content_container' : attach_content_container,
		'j_attach_content' : attach_content,
		'j_attach_remove_link' : attach_remove_link,
		'j_attach_loading_status' : attach_loading_status,
		'j_attach_nav_container' : attach_nav_container,
		'j_attach_nav_left' : attach_nav_left,
		'j_attach_nav_right' : attach_nav_right,
		'_delete_comment_url' : '<%= deleteCommentURL %>',
		'_attach_link_url' : '<%= attachLinkURL %>'
	});

	function isInitViewMoreLinkClickEvent() {
		if (load_more_obj.initViewMoreLinkClickEvent == true) {
			//document.title += " -simulateViewMoreLinkClickEvent";

			for (var i=0; i<view_more_link.length; i++) {
				simulate(view_more_link[i], "click");
			}
		}else {
		   	window.setTimeout(function() {
				//document.title += " -waitInitViewMoreLinkClickEvent";
				isInitViewMoreLinkClickEvent();
	        }, 1000);
		}
	}

	isInitViewMoreLinkClickEvent();

</script>

<aui:script>

	AUI().use('aui-base', function(A) {

		var documentBody = A.one('document.body')
		if (documentBody) {
			documentBody.delegate(
				'click',
				function(event) {
					var name = this.get('name');
					var title = this.get('title');
					var popup = Liferay.Util.Window.getWindow(
{
dialog: {
							bodyContent: name,
							centered: true,
							destroyOnClose: true,
							modal: true,
							title: title,
							height: 219,
							width: 515
						}}
					).render();
				},
				'.sp-group-comment-member-check'
			);
		}

	});

</aui:script>

<aui:script>
	AUI().use('aui-base', function(A) {

		var documentBody = A.one('document.body');
		if (documentBody) {
			documentBody.delegate(
				'click',
				function(event) {
					var name = this.get('name');
					var title = this.get('title');
					_callPopup(name,title);
				},
				'.sp-group-comment-service-access-check'
			);
		}

		function _callPopup(name, title) {
			var popup = Liferay.Util.Window.getWindow(
{
dialog: {
					centered: true,
					destroyOnClose: true,
					title: title,
					modal: true,
					height: 219,
					width: 515
				}}
			).render();

			popup.plug(
				A.Plugin.IO, {
					uri: name
				}
			);
		}

	});
</aui:script>

<script type="text/javascript">

var xhr = null;

/**
* Ajax Get
*/
function AjaxGet(url, successFunc, errorFunc) {
try{
	if (window.XMLHttpRequest) {
		// code for IE7+, Firefox, Chrome, Opera, Safari
	  	xhr = new XMLHttpRequest();
	}
	else {
		// code for IE6, IE5
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
	//alert("-AjaxGet: " + err);
}
}

function subscribeToComments(subscribe, className, classPK) {
try{
	var temp_url = '<%= subscribeToCommentsURL %>';
	temp_url += temp_url + "&subscribe=" + subscribe + "&className=" + className + "&classPK=" + classPK;
	AjaxGet(temp_url, subscribeToCommentsSuccess, subscribeToCommentsError);

}catch(err) {
	//alert("-subscribeToComments: " + err);
}
}

function subscribeToCommentsSuccess() {
try{
	var data = JSON.parse(xhr.responseText);
	var subscribe = data.subscribe;
	var classPK = data.classPK;
	var className = data.className;

	var subscribeLink = getFirstElementsByAttribute(document, "a", "data-subscribe", className + "_" + classPK);
	if (subscribe) {
		subscribeLink.innerHTML = "Unsubscribe from Discussions";
	}else {
		subscribeLink.innerHTML = "Subscribe to Discussions";
	}
	subscribeLink.setAttribute("href", "javascript:subscribeToComments(" + !subscribe + ", '" + className + "', " + classPK + ");");

}catch(err) {
	//alert("-subscribeToCommentsSuccess: " + err);
}
}

function subscribeToCommentsError() {
try{
	alert("Oops! An error occurred while processing your request.");
}catch(err) {
	//alert("-subscribeToCommentsError: " + err);
}
}

</script>
