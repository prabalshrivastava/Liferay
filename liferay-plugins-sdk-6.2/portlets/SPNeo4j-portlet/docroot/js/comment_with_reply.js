function CommentWithReply(param) {

	var that = this;

	this.j_comment_container = null;
	this.j_comment_add_form = null;
	this.j_comment_add_textarea = null;

	var comment_adding = false;
	var comment_replying = false;

	var delete_comment_url = "";

	function __construct(p) {
	try{
		for (pkey in p) {
			if (pkey[0] != "_") {
				that[pkey] = p[pkey];
			}
			if (p._delete_comment_url) {
				delete_comment_url = p._delete_comment_url;
			}
		}

		for (var i=0; i<that.j_load_more_delegation.length; i++) {
			if (navigator.appName == 'Microsoft Internet Explorer') {
				addEventHandler(that.j_load_more_delegation[i], "click", loadMoreDelegationClick);
			}else {
				that.j_load_more_delegation[i].addEventListener ("click", loadMoreDelegationClick, false);
			}
		}

		for (var i=0; i<that.j_comment_add_form.length; i++) {
			if (navigator.appName == 'Microsoft Internet Explorer') {
				addEventHandler(that.j_comment_add_form[i], "submit", addCommentFormSubmit);
			}else {
				that.j_comment_add_form[i].addEventListener ("submit", addCommentFormSubmit, false);
			}
		}

		for (var i=0; i<that.j_comment_add_textarea.length; i++) {
			if (navigator.appName == 'Microsoft Internet Explorer') {
				addEventHandler(that.j_comment_add_textarea[i], "focusin", addCommentTextareaFocus);
				addEventHandler(that.j_comment_add_textarea[i], "focusout", addCommentTextareaFocusout);
			}else {
				that.j_comment_add_textarea[i].addEventListener ("focus", addCommentTextareaFocus, false);
				that.j_comment_add_textarea[i].addEventListener ("blur", addCommentTextareaFocusout, false);
			}
		}

		for (var i=0; i<that.j_comment_container.length; i++) {
			if (navigator.appName == 'Microsoft Internet Explorer') {
				addEventHandler(that.j_comment_container[i], "click", commentContainerClick);
			}else {
				that.j_comment_container[i].addEventListener ("click", commentContainerClick, false);
			}
		}

	}catch(err) {
		alert(err);
	}
	}

	function commentContainerClick(e) {
	try{
		var target = getEventTarget(e);
		var comment_dom_id = target.getAttribute("data-comment-dom-id");
		if (comment_dom_id == "delete-link") {
			deleteLinkClick(e);
		}
		if (comment_dom_id == "add-reply-link") {
			addReplyLinkClick(e);
		}
		if (comment_dom_id == "add-reply-form-sumbit-btn") {
			addReplyFormSubmit(e)
		}
	}catch(err) {
		alert(err);
	}
	}

	function addCommentTextareaFocus(e) {
	try{
		var comment_add_textarea = null;
		if (this.addEventListener) {
			comment_add_textarea = this;
		}else {
			/**
			* attachEvent() doesn't give "this" as the element. for ie8-
			*/
			comment_add_textarea = e.srcElement;
		}
		if (comment_add_textarea.value == "Add a comment...") {
			comment_add_textarea.value = "";
		}
		comment_add_textarea.style.height = "28px";

		var form_container = getClosestParentByAttribute(comment_add_textarea, "data-comment-dom-id", "add-comment-form-container");
		getFirstElementsByAttribute(form_container, "img", "data-comment-dom-id", "avatar").style.display = "block";
		getFirstElementsByAttribute(form_container, "div", "data-comment-dom-id", "add-comment-submit").style.display = "block";
		var comment_add_textarea_container = getFirstElementsByAttribute(form_container, "div", "data-comment-dom-id", "add-comment-textarea-container");
		comment_add_textarea_container.style.margin = "0 0 0 58px";
		comment_add_textarea_container.style.minHeight = "50px";

	}catch(err) {
		alert(err);
	}
	}

	function addCommentTextareaFocusout(e) {
	try{
		var comment_add_textarea = null;
		if (this.addEventListener) {
			comment_add_textarea = this;
		}else {
			/**
			* attachEvent() doesn't give "this" as the element. for ie8-
			*/
			comment_add_textarea = e.srcElement;
		}
		var val = comment_add_textarea.value;

		if (val.length == 0) {
			collapseAddCommentTextarea(comment_add_textarea);
		}

	}catch(err) {
		alert(err);
	}
	}

	function collapseAddCommentTextarea(comment_add_textarea) {
	try{
		comment_add_textarea.value = "";
		comment_add_textarea.style.height = "14px";
		comment_add_textarea.value = "Add a comment...";
		var form_container = getClosestParentByAttribute(comment_add_textarea, "data-comment-dom-id", "add-comment-form-container");
		getFirstElementsByAttribute(form_container, "img", "data-comment-dom-id", "avatar").style.display = "none";
		getFirstElementsByAttribute(form_container, "div", "data-comment-dom-id", "add-comment-submit").style.display = "none";
		var comment_add_textarea_container = getFirstElementsByAttribute(form_container, "div", "data-comment-dom-id", "add-comment-textarea-container");
		comment_add_textarea_container.style.margin = "0";
		comment_add_textarea_container.style.minHeight = "0";

	}catch(err) {
		alert(err);
	}
	}

	function addReplyLinkClick(e) {
	try{
		preventDefault(e);
		var target = getEventTarget(e);
		var entry = getClosestParentByAttribute(target, "data-comment-is-parent", "true");
		var comment_reply_form_container = getFirstElementsByAttribute(entry, "div", "data-comment-dom-id", "add-reply-form-container");
		var comment_reply_textarea = getFirstElementsByAttribute(comment_reply_form_container, "textarea", "data-comment-dom-id", "add-reply-textarea");

		// bind focusout event for current reply textarea
		if (navigator.appName == 'Microsoft Internet Explorer') {
			addEventHandler(comment_reply_textarea, "focusout", addReplyTextareaFocusout);
		}else {
			comment_reply_textarea.addEventListener ("blur", addReplyTextareaFocusout, false);
		}

		comment_reply_form_container.style.display = "block";
		comment_reply_textarea.focus();

	}catch(err) {
		alert(err);
	}
	}

	function addReplyTextareaFocusout(e) {
	try{
		var target = getEventTarget(e);
		var val = target.value;
		if (val.length == 0) {
			getClosestParentByAttribute(target, "data-comment-dom-id", "add-reply-form-container").style.display = "none";
		}

	}catch(err) {
		alert(err);
	}
	}

	function addCommentFormSubmit(e) {
	try {
		preventDefault(e);
		if (!comment_adding) {
			comment_adding = true;
			var comment_add_form = null;
			if (this.addEventListener) {
				comment_add_form = this;
			}else {
				/**
				* attachEvent() doesn't give "this" as the element. for ie8-
				*/
				comment_add_form = e.srcElement;
			}
			addComment(comment_add_form);
		}
	}catch(err) {
		alert(err);
	}
	}

	function addComment(comment_add_form) {
	try{
		var url = comment_add_form.getAttribute("action");
		var class_pk = comment_add_form.elements["classPK"].value;
		var class_name = comment_add_form.elements["className"].value;
		var content = getFirstElementsByAttribute(comment_add_form, "textarea", "data-comment-dom-id", "add-comment-textarea").value;
		url += "&class_pk=" + class_pk + "&class_name=" + class_name + "&content=" + content;
		AjaxGet(url, addCommentSuccess, addCommentError);

	}catch(err) {
		alert(err);
	}
	}

	function addCommentSuccess() {
	try{
		var data = JSON.parse(xhr.responseText);
		var class_pk = data.class_pk;

		var comment_entry_container = getFirstElementsByAttribute(document, "div", "data-comment-asset-entity-id", class_pk);

		var add_comment_textarea = getFirstElementsByAttribute(comment_entry_container, "textarea", "data-comment-dom-id", "add-comment-textarea");
		add_comment_textarea.value = "";
		collapseAddCommentTextarea(add_comment_textarea);

		var entry_container = getFirstElementsByAttribute(comment_entry_container, "ul", "data-comment-dom-id", "entry-container");

		var temp_div = document.createElement('div');
		temp_div.innerHTML = data.html;
		entry_container.insertBefore(temp_div.firstChild, entry_container.firstChild);
		if (entry_container.parentNode.style.display === "none") {
			entry_container.parentNode.style.display="";		
		}

		// update counts
		var parent_count = getFirstElementsByAttribute(comment_entry_container, "span", "data-comment-dom-id", "parent-count");
		parent_count.innerHTML = parseInt(parent_count.innerHTML) + 1;

		// after complete
		addCommentComplete();

	}catch(err) {
		alert(err);
	}
	}

	function addCommentError() {
	try{
		alert("Oops! An error occurred while processing your request.");

		// after complete
		addCommentComplete();
	}catch(err) {
		alert(err);
	}
	}

	function addCommentComplete() {
	try{
		comment_adding = false;
	}catch(err) {
		alert(err);
	}
	}

	function addReplyFormSubmit(e) {
	try {
		preventDefault(e);
		if (!comment_replying) {
			comment_replying = true;
			var target = getEventTarget(e);

			addReply(getClosestParentByAttribute(target, "data-comment-dom-id", "add-reply-form"));
		}
	}catch(err) {
		alert(err);
	}
	}

	function addReply(comment_reply_form) {
	try{
		var url = comment_reply_form.getAttribute("action");
		var class_pk = comment_reply_form.elements["classPK"].value;
		var class_name = comment_reply_form.elements["className"].value;
		var content = getFirstElementsByAttribute(comment_reply_form, "textarea", "data-comment-dom-id", "add-reply-textarea").value;

		var parent_entry = getClosestParentByAttribute(comment_reply_form, "data-comment-is-parent", "true");
		var parent_id = parent_entry.getAttribute("data-comment-id");

		url += "&class_pk=" + class_pk + "&class_name=" + class_name + "&parent_id=" + parent_id + "&content=" + content;
		AjaxGet(url, addReplySuccess, addReplyError);

	}catch(err) {
		alert(err);
	}
	}

	function addReplySuccess() {
	try{
		var data = JSON.parse(xhr.responseText);
		var class_pk = data.class_pk;
		var comment_entry_container = getFirstElementsByAttribute(document, "div", "data-comment-asset-entity-id", class_pk);
		var parent_id = data.parent_id;
		var parent_entry = getFirstElementsByAttribute(comment_entry_container, "li", "data-comment-id", parent_id);

		var add_reply_textarea = getFirstElementsByAttribute(parent_entry, "textarea", "data-comment-dom-id", "add-reply-textarea");
		add_reply_textarea.value = "";

		getClosestParentByAttribute(add_reply_textarea, "data-comment-dom-id", "add-reply-form-container").style.display = "none";

		var child_entry_container = getFirstElementsByAttribute(parent_entry, "ul", "data-comment-dom-id", "child-entry-container");

		var temp_div = document.createElement('div');
		temp_div.innerHTML = data.html;
		child_entry_container.insertBefore(temp_div.firstChild, child_entry_container.firstChild);
		if (child_entry_container.parentNode.style.display === "none") {
			child_entry_container.parentNode.style.display="";		
		}

		// after complete
		addReplyComplete();

	}catch(err) {
		alert(err);
	}
	}

	function addReplyError() {
	try{
		alert("Oops! An error occurred while processing your request.");

		// after complete
		addReplyComplete();
	}catch(err) {
		alert(err);
	}
	}

	function addReplyComplete() {
	try{
		comment_replying = false;
	}catch(err) {
		alert(err);
	}
	}

	function deleteLinkClick(e) {
	try{
		preventDefault(e);
		var target = getEventTarget(e);

		deleteComment(target);
	}catch(err) {
		alert(err);
	}
	}

	function deleteComment(entry_options) {
	try{
		if (confirm("Are you sure to delete this comment?")) {
			var comment_entry = getClosestParentByAttributeName(entry_options, "data-comment-id");
			var comment_id = comment_entry.getAttribute("data-comment-id");
			var is_parent = comment_entry.getAttribute("data-comment-is-parent");

			var comment_entry_container = getClosestParentByAttributeName(entry_options, "data-comment-asset-entity-id");
			var class_pk = comment_entry_container.getAttribute("data-comment-asset-entity-id");

			var temp_delete_comment_url = delete_comment_url + "&comment_id=" + comment_id + "&is_parent=" + is_parent + "&class_pk=" + class_pk;
			AjaxGet(temp_delete_comment_url, deleteCommentSuccess, deleteCommentError);
		}
	}catch(err) {
		alert(err);
	}
	}

	function deleteCommentSuccess() {
	try{
		var data = JSON.parse(xhr.responseText);
		var comment_id = data.comment_id;
		var comment_entry = getFirstElementsByAttribute(document, "li", "data-comment-id", comment_id);
		comment_entry.parentNode.removeChild(comment_entry);

		var class_pk = data.class_pk;
		var comment_entry_container = getFirstElementsByAttribute(document, "div", "data-comment-asset-entity-id", class_pk);
		var parent_count = getFirstElementsByAttribute(comment_entry_container, "span", "data-comment-dom-id", "parent-count");
		parent_count.innerHTML = parseInt(parent_count.innerHTML) - 1;

	}catch(err) {
		alert(err);
	}
	}

	function deleteCommentError() {
	try{
		alert("Oops! An error occurred while processing your request.");

	}catch(err) {
		alert(err);
	}
	}

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

	   xhr.open("GET", url,  true);
	   xhr.send(null);

	}catch(err) {
		alert(err);
	}
	}

	__construct(param);

}