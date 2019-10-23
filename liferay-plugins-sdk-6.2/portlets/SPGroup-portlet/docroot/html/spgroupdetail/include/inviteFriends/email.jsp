<script src="<c:url value="/js/auto_complete_pure_javascript.js" />" type="text/javascript"></script>

<portlet:resourceURL var="findInvitePeopleSuggestionsURL">
	<portlet:param name="action" value="findInvitePeopleSuggestions"></portlet:param>
</portlet:resourceURL>

<div id="<portlet:namespace />inviteFriendsEmailContent" style="margin:20px 14px;">
	<form action="<%= inviteFriendsURL %>" class="s1" id="<portlet:namespace />ip_form" method="POST" onsubmit="sendInvitations(event)">
		<input name="<portlet:namespace />urlTitle" type="hidden" value="<%= spGroup.getUrlTitle() %>" />
		<input name="<portlet:namespace />spGroupId" type="hidden" value="<%= spGroup.getSpGroupId() %>" />
		<input name="<portlet:namespace />inviteBy" type="hidden" value="email" />
		<div class="fieldset">
			<div><label class="sp-group-column sp-group-of-ten" for="ip_to" style="vertical-align: top;"><span class="sp-group-ui-db"><liferay-ui:message key="label.to" />:</span></label><div class="sp-group-nonuple-column sp-group-column sp-group-of-ten"><div data-autocomplete-dom-id="sis-holder" data-group-id="<%= spGroup.getSpGroupId() %>" class="ip-to">
				<ul class="horizontal sp-group-ui-dib sp-group-ui-vam" data-autocomplete-dom-id="selected-items">

				</ul>
				<span class="ip-to-input-outer" style="width:266px"><span style="visibility: hidden; z-index: -10000; position: relative; width: 100%;"><liferay-ui:message key="label.names.email.address" />&nbsp;</span><input data-autocomplete-dom-id="input" id="ip_to" type="text" tabindex="0" placeholder="<%= LanguageUtil.get(pageContext,"label.names.email.address") %>" autocomplete="off" value="" class="ip-to-input" /></span></div>
				<div class="ip-sb" data-autocomplete-dom-id="suggestions-board" style="display: none;">
					<div class="ip-sb-c" data-autocomplete-dom-id="close-btn"></div>
					<div class="ip-sb-options" data-autocomplete-dom-id="options">

					</div>

				</div>
			</div></div>
		</div>
		<div class="fieldset">
			<div>
				<div><span class="sp-group-column sp-group-of-ten"></span><textarea id="ip_comment" tabindex="2" maxlength="250" placeholder="<%= LanguageUtil.get(pageContext,"label.add.comment") %>" class="sp-group-nonuple-column sp-group-column sp-group-of-ten" style="height: 60px;"></textarea></div>
				<div><span class="sp-group-column sp-group-of-ten"></span><span class="sp-group-fcl sp-group-fss"><liferay-ui:message key="label.less.characters" /></span></div>
			</div>
		</div>
		<div>
			<span class="sp-group-column sp-group-of-ten"></span><input id="ag_submit" type="submit" value="<%= LanguageUtil.get(pageContext,"label.send") %>" tabindex="3" class="sp-group-column" />
		</div>
	</form>
</div>

<script type="text/javascript">

	var xhr;

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
		// alert(err);
	}
	}

	function sendInvitations(e) {
	try{
		preventDefault(e);
		var ip_form = getEventTarget(e);

		var selected_items = getFirstElementsByAttribute(ip_form, "ul", "data-autocomplete-dom-id", "selected-items");

		var sis = getElementsByAttribute(selected_items, "li", "data-autocomplete-dom-id", "si");

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
		var invite_by = ip_form.elements["<portlet:namespace />inviteBy"].value;

		// document.title += " -invite_by:" + invite_by;

		if (send_to.length == 0) {
			alert("Please at least input one email address.");
		}else {

			var temp_url = ip_form.getAttribute("action");
			temp_url += "&url_title=" + url_title + "&sp_group_id=" + sp_group_id + "&send_to=" + send_to + "&comment=" + comment + "&invite_by=" + invite_by;

			AjaxGet(temp_url, sendInvitationsSuccess, sendInvitationsError);

		}
	}catch(err) {
		// alert(err);
	}
	}

	function sendInvitationsSuccess() {
	try{
		var data = JSON.parse(xhr.responseText);

		var ip_form = document.getElementById("<portlet:namespace />ip_form");
		var selected_items_container = getFirstElementsByAttribute(ip_form, "ul", "data-autocomplete-dom-id", "selected-items");
		selected_items_container.innerHTML = "";

		var success_msg = data.success_msg;
		alert(success_msg);

	}catch(err) {
		// alert(err);
	}
	}

	function sendInvitationsError() {
	try{
		alert("Oops! An error occurred while processing your request.");
	}catch(err) {
		// alert(err);
	}
	}

</script>

<script type="text/javascript">

	var j_ip_form = document.getElementById("<portlet:namespace />ip_form");
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
		'_find_suggestions_url' : '<%= findInvitePeopleSuggestionsURL %>',
		'_portlet_namespace' : '<portlet:namespace />'
	});

</script>