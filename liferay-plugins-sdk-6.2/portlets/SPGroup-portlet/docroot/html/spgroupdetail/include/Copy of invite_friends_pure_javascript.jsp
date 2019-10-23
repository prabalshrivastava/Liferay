<script src="<c:url value="/js/auto_complete_pure_javascript.js" />" type="text/javascript"></script>

<portlet:resourceURL var="findInvitePeopleSuggestionsURL">
	<portlet:param name="action" value="findInvitePeopleSuggestions"></portlet:param>
</portlet:resourceURL>

<div align="center" class="sp-group-if-guideline">
	<div align="left" class="sp-group-clearfix" style="width: 400px">
		<div class="sp-group-lfloat sp-group-mrm" style="line-height: 1;"><img alt="Invite" src="${ctx}/images/InviteFriends_icon.png" /></div>
		<div class="sp-group-ui-oh">
			<div class="sp-group-ui-dib">
				<div class="sp-group-ui-dib sp-group-ui-vam" style="height: 51px;"></div><div class="sp-group-ui-dib sp-group-ui-vam">
					<h1 style="color: #FFFFFF; margin-bottom: 5px;;">Invite Friends</h1>
					<p>Click on any of the following modes to invite your friends</p>
				</div>
			</div>
		</div>
	</div>
</div>

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
		// alert("-AjaxGet: " + err);
	}
	}

</script>

<ul class="sp-group-tabs horizontal" id="<portlet:namespace />inviteFriendsTabsContainer" style="padding-bottom: 8px; border-bottom: 0 none;">
	<li style="width: 25%;"><a id="<portlet:namespace />inviteFriendsGmailTab" href="javascript:;" data-loaded="false" style="background-color: #D45648; padding: 15px 0; text-align: center;"><img alt="Gmail" src="${ctx}/images/Gmail.png" /><span style="display: block;">Gmail</span></a></li><li style="width: 25%;">
		<a data-loaded="false" href="javascript:;" id="<portlet:namespace />inviteFriendsFacebookTab" style="background-color: #406290; padding: 15px 0; text-align: center;"><img alt="Facebook" src="${ctx}/images/Facebook.png" /><span style="display: block;">Facebook</span></a></li><li style="width: 25%;">
		<a data-loaded="false" href="javascript:;" id="<portlet:namespace />inviteFriendsTwitterTab" style="background-color: #56B0CA; padding: 15px 0; text-align: center;"><img alt="Twitter" src="${ctx}/images/Twitter.png" /><span style="display: block;">Twitter</span></a></li><li style="width: 25%;">
		<a href="javascript:;" id="<portlet:namespace />inviteFriendsEmailTab" style="background-color: #795B9B; padding: 15px 0; text-align: center;"><img alt="Email" src="${ctx}/images/email.png" /><span style="display: block;">Email</span></a></li>
</ul>

<div id="<portlet:namespace />inviteFriendsGmailContent" style="display: none;">
	<br />
	<div data-loadmore-dom-id="loadmore-container">
		<ul class="sp-gd-entry-container" data-comment-dom-id="entry-container" data-loadmore-dom-id="items-container">
		</ul>
		<div align="center" class="sp-gd-more sp-group-mts" data-loadmore-dom-id="view-more-link-container" style="display: none;"><a id="<portlet:namespace />gm_view_more_link" data-loadmore-dom-id="view-more-link" href="#" data-loadmore="{ &quot;retrieve_url&quot; : &quot;<%= inviteFriendsByGmailURL %>&quot;, &quot;retrieve_params&quot; : { &quot;offset&quot; : 20, &quot;cur_showing_no&quot; : 0 }, &quot;no_results_msg&quot; : &quot;NO RESULTS FOUND&quot;, &quot;no_more_results_msg&quot; : &quot;NO MORE RESULTS&quot;, &quot;error_msg&quot; : &quot;This stream is unavailable at this time. Please try again soon.&quot; }">View more</a></div>
		<div align="center" class="sp-group-pas"  data-loadmore-dom-id="loading-status" style="display: none;"><span>Loading...</span></div>
		<div align="center" class="sp-group-pas"  data-loadmore-dom-id="load-msg" style="display: none;"></div>
	</div>
</div>
<div id="<portlet:namespace />inviteFriendsFacebookContent" style="display: none;">
	<br />
	<div data-loadmore-dom-id="loadmore-container">
		<ul class="sp-gd-entry-container" data-comment-dom-id="entry-container" data-loadmore-dom-id="items-container">
		</ul>
		<div align="center" class="sp-gd-more sp-group-mts" data-loadmore-dom-id="view-more-link-container" style="display: none;"><a id="<portlet:namespace />fb_view_more_link" data-loadmore-dom-id="view-more-link" href="#" data-loadmore="{ &quot;retrieve_url&quot; : &quot;<%= inviteFriendsByFacebookURL %>&quot;, &quot;retrieve_params&quot; : { &quot;offset&quot; : 20, &quot;cur_showing_no&quot; : 0 }, &quot;no_results_msg&quot; : &quot;NO RESULTS FOUND&quot;, &quot;no_more_results_msg&quot; : &quot;NO MORE RESULTS&quot;, &quot;error_msg&quot; : &quot;This stream is unavailable at this time. Please try again soon.&quot; }">View more</a></div>
		<div align="center" class="sp-group-pas"  data-loadmore-dom-id="loading-status" style="display: none;"><span>Loading...</span></div>
		<div align="center" class="sp-group-pas"  data-loadmore-dom-id="load-msg" style="display: none;"></div>
	</div>

</div>
<div id="<portlet:namespace />inviteFriendsTwitterContent" style="display: none;">
	<br />
	<div data-loadmore-dom-id="loadmore-container">
		<ul class="sp-gd-entry-container" data-comment-dom-id="entry-container" data-loadmore-dom-id="items-container">
		</ul>
		<div align="center" class="sp-gd-more sp-group-mts" data-loadmore-dom-id="view-more-link-container" style="display: none;"><a id="<portlet:namespace />tw_view_more_link" data-loadmore-dom-id="view-more-link" href="#" data-loadmore="{ &quot;retrieve_url&quot; : &quot;<%= inviteFriendsByTwitterURL %>&quot;, &quot;retrieve_params&quot; : { &quot;offset&quot; : 20, &quot;cur_showing_no&quot; : 0 }, &quot;no_results_msg&quot; : &quot;NO RESULTS FOUND&quot;, &quot;no_more_results_msg&quot; : &quot;NO MORE RESULTS&quot;, &quot;error_msg&quot; : &quot;This stream is unavailable at this time. Please try again soon.&quot; }">View more</a></div>
		<div align="center" class="sp-group-pas"  data-loadmore-dom-id="loading-status" style="display: none;"><span>Loading...</span></div>
		<div align="center" class="sp-group-pas"  data-loadmore-dom-id="load-msg" style="display: none;"></div>
	</div>
</div>
<div id="<portlet:namespace />inviteFriendsEmailContent" style="display: none;">

	<form action="<%= inviteFriendsByEmailURL %>" class="s1" id="ip_form" method="POST" onsubmit="sendInvitations(event)">
		<input name="<portlet:namespace />urlTitle" type="hidden" value="<%= spGroup.getUrlTitle() %>" />
		<input name="<portlet:namespace />spGroupId" type="hidden" value="<%= spGroup.getSpGroupId() %>" />
		<div class="fieldset">
			<div><label class="sp-group-column sp-group-of-ten" for="ip_to" style="vertical-align: top;"><span class="sp-group-ui-db">To:</span></label><div class="sp-group-nonuple-column sp-group-column sp-group-of-ten"><div data-autocomplete-dom-id="sis-holder" data-group-id="<%= spGroup.getSpGroupId() %>" class="ip-to">
				<ul class="horizontal sp-group-ui-dib sp-group-ui-vam" data-autocomplete-dom-id="selected-items">

				</ul>
				<span class="ip-to-input-outer" style="width:270px"><span style="visibility: hidden; z-index: -10000; position: relative; width: 100%;">+ Add names or email addresses&nbsp;</span><input data-autocomplete-dom-id="input" id="ip_to" type="text" tabindex="0" placeholder="+ Add names or email addresses" autocomplete="off" value="" class="ip-to-input" /></span></div>
				<div class="ip-sb" data-autocomplete-dom-id="suggestions-board" style="display: none;">
					<div class="ip-sb-c" data-autocomplete-dom-id="close-btn"></div>
					<div class="ip-sb-options" data-autocomplete-dom-id="options">

					</div>

				</div>
			</div></div>
		</div>
		<div class="fieldset">
			<div>
				<span class="sp-group-column sp-group-of-ten"></span><textarea id="ip_comment" tabindex="2" maxlength="250" placeholder="Add a comment..." class="sp-group-nonuple-column sp-group-column sp-group-of-ten" style="height: 60px;"></textarea>
				<div>
					<span class="sp-group-column sp-group-of-ten"></span><span class="sp-group-fcl sp-group-fss">Less than 250 characters.</span>
				</div>
			</div>
		</div>
		<div>
			<span class="sp-group-column sp-group-of-ten"></span><input id="ag_submit" type="submit" value="Send" tabindex="3" class="sp-group-column" />
		</div>
	</form>

</div>

<script type="text/javascript">

	var view_more_link = getElementsByAttribute(document, "a", "data-loadmore-dom-id", "view-more-link");

	var load_more_obj = new LoadMore({
		'j_view_more_link' : view_more_link
	});

	function isInitViewMoreLinkClickEvent(type) {
		if (load_more_obj.initViewMoreLinkClickEvent == true) {
			var view_more_link = null;
			if (type == "facebook") {
				view_more_link = document.getElementById("<portlet:namespace />fb_view_more_link");
			}else if (type == "twitter") {
				view_more_link = document.getElementById("<portlet:namespace />tw_view_more_link");
			}if (type == "gmail") {
				view_more_link = document.getElementById("<portlet:namespace />gm_view_more_link");
			}
			simulate(view_more_link, "click");
		}else {
		   	window.setTimeout(function() {
				isInitViewMoreLinkClickEvent();
	        }, 1000);
		}
	}

	var inviteFriendsTabsContainer = document.getElementById("<portlet:namespace />inviteFriendsTabsContainer");

	var inviteFriendsGmailTab = document.getElementById("<portlet:namespace />inviteFriendsGmailTab");
	var inviteFriendsFacebookTab = document.getElementById("<portlet:namespace />inviteFriendsFacebookTab");
	var inviteFriendsTwitterTab = document.getElementById("<portlet:namespace />inviteFriendsTwitterTab");
	var inviteFriendsEmailTab = document.getElementById("<portlet:namespace />inviteFriendsEmailTab");

	var inviteFriendsGmailContent = document.getElementById("<portlet:namespace />inviteFriendsGmailContent");
	var inviteFriendsFacebookContent = document.getElementById("<portlet:namespace />inviteFriendsFacebookContent");
	var inviteFriendsTwitterContent = document.getElementById("<portlet:namespace />inviteFriendsTwitterContent");
	var inviteFriendsEmailContent = document.getElementById("<portlet:namespace />inviteFriendsEmailContent");

	var inviteFriendsFacebookFriendsContainer = document.getElementById("<portlet:namespace />inviteFriendsFacebookFriendsContainer");

	addEventHandler(inviteFriendsGmailTab, "click", inviteFriendsGmailTabOnClick);
	addEventHandler(inviteFriendsFacebookTab, "click", inviteFriendsFacebookTabOnClick);
	addEventHandler(inviteFriendsTwitterTab, "click", inviteFriendsTwitterTabOnClick);
	addEventHandler(inviteFriendsEmailTab, "click", inviteFriendsEmailTabOnClick);

	function inviteFriendsGmailTabOnClick(e) {
	try{
		preventDefault(e);
		inviteFriendsTabsContainer.style.backgroundColor = "#D45648";

		addClass(inviteFriendsGmailTab, "active");
		removeClass(inviteFriendsFacebookTab, "active");
		removeClass(inviteFriendsTwitterTab, "active");
		removeClass(inviteFriendsEmailTab, "active");

		inviteFriendsGmailContent.style.display = "block";
		inviteFriendsFacebookContent.style.display = "none";
		inviteFriendsTwitterContent.style.display = "none";
		inviteFriendsEmailContent.style.display = "none";

		var loaded = inviteFriendsGmailTab.getAttribute("data-loaded");
		if (loaded == "false") {
			inviteFriendsGmailTab.setAttribute("data-loaded", "true");
			isInitViewMoreLinkClickEvent("gmail");
		}

	}catch(err) {
		alert(err);
	}
	}

	function inviteFriendsFacebookTabOnClick(e) {
	try{
		preventDefault(e);
		inviteFriendsTabsContainer.style.backgroundColor = "#406290";

		removeClass(inviteFriendsGmailTab, "active");
		addClass(inviteFriendsFacebookTab, "active");
		removeClass(inviteFriendsTwitterTab, "active");
		removeClass(inviteFriendsEmailTab, "active");

		inviteFriendsGmailContent.style.display = "none";
		inviteFriendsFacebookContent.style.display = "block";
		inviteFriendsTwitterContent.style.display = "none";
		inviteFriendsEmailContent.style.display = "none";

		var loaded = inviteFriendsFacebookTab.getAttribute("data-loaded");
		if (loaded == "false") {
			inviteFriendsFacebookTab.setAttribute("data-loaded", "true");
			isInitViewMoreLinkClickEvent("facebook");
		}

	}catch(err) {
		alert(err);
	}
	}

	function inviteFriendsTwitterTabOnClick(e) {
	try{
		preventDefault(e);
		inviteFriendsTabsContainer.style.backgroundColor = "#56B0CA";

		removeClass(inviteFriendsGmailTab, "active");
		removeClass(inviteFriendsFacebookTab, "active");
		addClass(inviteFriendsTwitterTab, "active");
		removeClass(inviteFriendsEmailTab, "active");

		inviteFriendsGmailContent.style.display = "none";
		inviteFriendsFacebookContent.style.display = "none";
		inviteFriendsTwitterContent.style.display = "block";
		inviteFriendsEmailContent.style.display = "none";

		var loaded = inviteFriendsTwitterTab.getAttribute("data-loaded");
		if (loaded == "false") {
			inviteFriendsTwitterTab.setAttribute("data-loaded", "true");
			isInitViewMoreLinkClickEvent("twitter");
		}

	}catch(err) {
		alert(err);
	}
	}

	function inviteFriendsEmailTabOnClick(e) {
	try{
		preventDefault(e);
		inviteFriendsTabsContainer.style.backgroundColor = "#795B9B";

		removeClass(inviteFriendsGmailTab, "active");
		removeClass(inviteFriendsFacebookTab, "active");
		removeClass(inviteFriendsTwitterTab, "active");
		addClass(inviteFriendsEmailTab, "active");

		inviteFriendsGmailContent.style.display = "none";
		inviteFriendsFacebookContent.style.display = "none";
		inviteFriendsTwitterContent.style.display = "none";
		inviteFriendsEmailContent.style.display = "block";
	}catch(err) {
		alert(err);
	}
	}

</script>

<script type="text/javascript">

	function sendInvitations(e) {
	try{
		preventDefault(e);
		var ip_form = getEventTarget(e);

		var selected_items = getFirstElementsByAttribute(ip_form, "ul", "data-autocomplete-dom-id", "selected-items");

		// document.title += " -selected_items:" + selected_items;

		var sis = getElementsByAttribute(selected_items, "li", "data-autocomplete-dom-id", "si");

		// document.title += " -sis:" + sis;

		var send_to = "";

		for (var i=0; i<sis.length; i++) {

			var si = sis[i];

			var user_id = si.getAttribute("data-user-id");

			// document.title += " -user_id:" + user_id;

			if (user_id == 0) {

				var si_email_span = getFirstElementsByAttribute(si, "span", "data-autocomplete-dom-id", "si-email");
				var si_email = si_email_span.innerHTML;

				if (send_to.length > 0) {
					send_to += ",";
				}
				send_to += si_email;

			}else {
				if (send_to.length > 0) {
					send_to += ",";
				}
				send_to += user_id;
			}
		}

		var url_title = ip_form.elements["<portlet:namespace />urlTitle"].value;
		var sp_group_id = ip_form.elements["<portlet:namespace />spGroupId"].value;
		var comment = document.getElementById("ip_comment").value;

		if (send_to.length == 0) {
			alert("Please at least input one email address.");
		}else {

			var temp_url = ip_form.getAttribute("action");
			temp_url += "&url_title=" + url_title + "&sp_group_id=" + sp_group_id + "&send_to=" + send_to + "&comment=" + comment;
			AjaxGet(temp_url, sendInvitationsSuccess, sendInvitationsError);

		}
	}catch(err) {
		alert(err);
	}
	}

	function sendInvitationsSuccess() {
	try{
		var data = JSON.parse(xhr.responseText);

		var selected_items_container = getFirstElementsByAttribute(ip_form, "ul", "data-autocomplete-dom-id", "selected-items");
		selected_items_container.innerHTML = "";

		var success_msg = data.success_msg;
		alert(success_msg);

	}catch(err) {
		alert(err);
	}
	}

	function sendInvitationsError() {
	try{
		alert("Oops! An error occurred while processing your request.");
	}catch(err) {
		alert(err);
	}
	}

</script>

<script type="text/javascript">
	var j_ip_form = document.getElementById("ip_form");
	var j_autocomplete_sis_holder = getFirstElementsByAttribute(document, "div", "data-autocomplete-dom-id", "sis-holder");
	var j_autocomplete_input = getFirstElementsByAttribute(document, "input", "data-autocomplete-dom-id", "input");
	var j_autocomplete_suggestions_board = getFirstElementsByAttribute(document, "div", "data-autocomplete-dom-id", "suggestions-board");
	var j_autocomplete_close_btn = getFirstElementsByAttribute(document, "div", "data-autocomplete-dom-id", "close-btn");
	var j_autocomplete_options = getFirstElementsByAttribute(document, "div", "data-autocomplete-dom-id", "options");
	var j_autocomplete_selected_items = getFirstElementsByAttribute(document, "ul", "data-autocomplete-dom-id", "selected-items");

	new AutoComplete({
		'j_ip_form' : j_ip_form,
		'j_autocomplete_sis_holder' : j_autocomplete_sis_holder,
		'j_autocomplete_input' : j_autocomplete_input,
		'j_autocomplete_suggestions_board' : j_autocomplete_suggestions_board,
		'j_autocomplete_close_btn' : j_autocomplete_close_btn,
		'j_autocomplete_options' : j_autocomplete_options,
		'j_autocomplete_selected_items' : j_autocomplete_selected_items,
		'_find_suggestions_url' : '<%= findInvitePeopleSuggestionsURL %>'
	});

</script>
