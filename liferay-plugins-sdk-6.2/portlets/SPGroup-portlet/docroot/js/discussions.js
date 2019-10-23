function CommentWithReply(param) {

	var that = this;

	this.j_comment_container = null;
	this.j_comment_add_form = null;
	//this.j_comment_reply_form = null;
	this.j_comment_add_textarea = null;
	this.j_comment_add_textarea_detail = null;
	this.j_attach_a_link = null;
	this.j_attach_link = null;
	this.j_attach_input_containter = null;
	this.j_attach_input = null;
	this.j_attach_content_container = null;
	this.j_attach_content = null;
	this.j_attach_loading_status = null;
	this.j_attach_remove_link = null;

	this.j_attach_nav_container = null;
	this.j_attach_nav_left = null;
	this.j_attach_nav_right = null;

	//this.j_comment_reply_textarea = null;
	//this.j_comment_entry_content = null;
	//this.j_comment_entry_options = null;
	//this.j_comment_add_reply_link = null;

	var comment_adding = false;
	var comment_replying = false;

	var delete_comment_url = "";
	var attach_link_url = "";

	function __construct(p) {
	try{
		for (pkey in p) {
			if (pkey[0] != "_") {
				that[pkey] = p[pkey];
			}
			if (p._delete_comment_url) {
				delete_comment_url = p._delete_comment_url;
			}
			if (p._attach_link_url) {
				attach_link_url = p._attach_link_url;
			}
		}

		if (that.j_comment_add_form != null) {
			for (var i=0; i<that.j_comment_add_form.length; i++) {
				addEventHandler(that.j_comment_add_form[i], "submit", addCommentFormSubmit);
			}
		}

		/*
		for (var i=0; i<that.j_comment_reply_form.length; i++) {
			addEventHandler(that.j_comment_reply_form[i], "submit", addReplyFormSubmit);
		}
		*/

		if (that.j_comment_add_textarea_detail != null) {
			for (var i=0; i<that.j_comment_add_textarea_detail.length; i++) {
				if (navigator.appName == 'Microsoft Internet Explorer') {
					//document.title += "-using ie";

					addEventHandler(that.j_comment_add_textarea_detail[i], "focusout", addCommentTextareaDetailFocusout);
					addEventHandler(that.j_comment_add_textarea_detail[i], "focusin", addCommentTextareaDetailFocus);
				}else {
					that.j_comment_add_textarea_detail[i].addEventListener ("blur", addCommentTextareaDetailFocusout, false);
					that.j_comment_add_textarea_detail[i].addEventListener ("focus", addCommentTextareaDetailFocus, false);
				}
			}
		}

		if (that.j_comment_add_textarea != null) {

			for (var i=0; i<that.j_comment_add_textarea.length; i++) {
				if (navigator.appName == 'Microsoft Internet Explorer') {
					//document.title += "-using ie";
					addEventHandler(that.j_comment_add_textarea[i], "focusout", addCommentTextareaFocusout);
					addEventHandler(that.j_comment_add_textarea[i], "focusin", addCommentTextareaFocus);
				}else {
					that.j_comment_add_textarea[i].addEventListener ("blur", addCommentTextareaFocusout, false);
					that.j_comment_add_textarea[i].addEventListener ("focus", addCommentTextareaFocus, false);
				}
			}
		}


		/*
		for (var i=0; i<that.j_comment_reply_textarea.length; i++) {
			if (navigator.appName == 'Microsoft Internet Explorer') {
				document.title += "-using ie";
				addEventHandler(that.j_comment_reply_textarea[i], "focusin", addReplyTextareaFocus);
				addEventHandler(that.j_comment_reply_textarea[i], "focusout", addReplyTextareaFocusout);
			}else {
				that.j_comment_reply_textarea[i].addEventListener ("focus", addReplyTextareaFocus, false);
				that.j_comment_reply_textarea[i].addEventListener ("blur", addReplyTextareaFocusout, false);
			}
		}

		for (var i=0; i<that.j_comment_entry_content.length; i++) {
			addEventHandler(that.j_comment_entry_content[i], "mouseenter", entryContentMouseenter);
			addEventHandler(that.j_comment_entry_content[i], "mouseleave", entryContentMouseleave);
		}

		for (var i=0; i<that.j_comment_entry_options.length; i++) {
			addEventHandler(that.j_comment_entry_options[i], "click", closeCommentEntryClick);
		}
		*/

		if (navigator.appName == 'Microsoft Internet Explorer') {
			//document.title += "-using ie";
			addEventHandler(that.j_comment_container, "click", commentContainerClick);
			addEventHandler(that.j_comment_container, "mouseover", commentContainerMouseover);
		}else {
			that.j_comment_container.addEventListener ("click", commentContainerClick, false);
			that.j_comment_container.addEventListener ("mouseover", commentContainerMouseover, false);
		}

		if (navigator.appName == 'Microsoft Internet Explorer') {
			//document.title += "-using ie";
			if (that.j_attach_a_link != null) {
				addEventHandler(that.j_attach_a_link, "click", attachALinkClick);
			}
			if (that.j_attach_link != null) {
				addEventHandler(that.j_attach_link, "click", attachLinkClick);
			}
			if (that.j_attach_input != null) {
				addEventHandler(that.j_attach_input, "focusin", attachInputFocus);
				addEventHandler(that.j_attach_input, "focusout", attachInputFocusout);
				addEventHandler(that.j_attach_input, "keypress", attachInputKeypress);
			}
			if (that.j_attach_remove_link != null) {
				addEventHandler(that.j_attach_remove_link, "click", attachRemoveLinkClick);
			}
			if (that.j_attach_nav_left != null) {
				addEventHandler(that.j_attach_nav_left, "click", attachNavLeftClick);
			}
			if (that.j_attach_nav_right != null) {
				addEventHandler(that.j_attach_nav_right, "click", attachNavRightClick);
			}
		}else {
			if (that.j_attach_a_link != null) {
				that.j_attach_a_link.addEventListener ("click", attachALinkClick, false);
			}
			if (that.j_attach_link != null) {
				that.j_attach_link.addEventListener ("click", attachLinkClick, false);
			}
			if (that.j_attach_input != null) {
				that.j_attach_input.addEventListener ("focus", attachInputFocus, false);
				that.j_attach_input.addEventListener ("blur", attachInputFocusout, false);
				that.j_attach_input.addEventListener ("keypress", attachInputKeypress, false);
			}
			if (that.j_attach_remove_link != null) {
				that.j_attach_remove_link.addEventListener ("click", attachRemoveLinkClick, false);
			}
			if (that.j_attach_nav_left != null) {
				that.j_attach_nav_left.addEventListener ("click", attachNavLeftClick, false);
			}
			if (that.j_attach_nav_right != null) {
				that.j_attach_nav_right.addEventListener ("click", attachNavRightClick, false);
			}
		}

		/*
		for (var i=0; i<that.j_comment_add_reply_link.length; i++) {
			addEventHandler(that.j_comment_add_reply_link[i], "click", addReplyLinkClick);
		}
		*/

	}catch(err) {
		alert(err);
	}
	}

	function attachNavRightClick(e) {
	try{
		preventDefault(e);
		var attach_nav_right = null;
		if (this.addEventListener) {
			attach_nav_right = this;
		}else {
			/**
			* attachEvent() doesn't give "this" as the element. for ie8-
			*/
			attach_nav_right = e.srcElement;
		}

		var attach_images = getElementsByAttribute(that.j_attach_content_container, "img", "data-comment-dom-id", "attach-image");
		if (attach_images != null && attach_images.length > 1) {
			var attach_images_length = attach_images.length;
			for (var i=0; i<attach_images_length; i++) {
				var attach_image = attach_images[i];
				if (attach_image.style.display == "block") {
					if ((i+1) < attach_images_length) {
						attach_image.style.display = "none";
						attach_images[i+1].style.display = "block";
					}
				}
			}
		}

	}catch(err) {
		alert(err);
	}
	}


	function attachNavLeftClick(e) {
	try{
		preventDefault(e);
		var attach_nav_left = null;
		if (this.addEventListener) {
			attach_nav_left = this;
		}else {
			/**
			* attachEvent() doesn't give "this" as the element. for ie8-
			*/
			attach_nav_left = e.srcElement;
		}

		var attach_images = getElementsByAttribute(that.j_attach_content_container, "img", "data-comment-dom-id", "attach-image");
		if (attach_images != null && attach_images.length > 1) {
			var attach_images_length = attach_images.length;
			for (var i=0; i<attach_images_length; i++) {
				var attach_image = attach_images[i];
				if (attach_image.style.display == "block") {
					if (i > 0) {
						attach_image.style.display = "none";
						attach_images[i-1].style.display = "block";
					}
				}
			}
		}

	}catch(err) {
		alert(err);
	}
	}


	function attachInputKeypress(e) {
	try{
		if (e.which == 13 || e.keyCode == 13) {
			preventDefault(e);
			var attach_input = null;
			if (this.addEventListener) {
				attach_input = this;
			}else {
				/**
				* attachEvent() doesn't give "this" as the element. for ie8-
				*/
				attach_input = e.srcElement;
			}
			var attach_input_value = attach_input.value;
			if (isUrl(attach_input_value)) {
				if (attach_input_value.length == 0 || attach_input_value == "Add a link...") {
					// do nothing
				}else {
					that.j_attach_input_containter.style.display = "none";
					that.j_attach_loading_status.style.display = "block";
					that.j_attach_content_container.style.display = "block";
					var temp_attach_link_url = attach_link_url + "&link=" + attach_input.value;
					AjaxGet(temp_attach_link_url, attachLinkSuccess, attachLinkError);
				}
			}else {
				alert("Please enter a valid url start with 'http:// or https://'.");
			}
		}
	}catch(err) {
		alert(err);
	}
	}

	function attachRemoveLinkClick(e) {
	try{
		preventDefault(e);
		var attach_remove_link = null;
		if (this.addEventListener) {
			attach_remove_link = this;
		}else {
			/**
			* attachEvent() doesn't give "this" as the element. for ie8-
			*/
			attach_remove_link = e.srcElement;
		}
		that.j_attach_nav_container.style.display = "none";
		that.j_attach_content_container.style.display = "none";
		that.j_attach_content.style.display = "none";
		that.j_attach_content.innerHTML = "";
		that.j_attach_input.value = "Add a link...";
		that.j_attach_input_containter.style.display = "block";

	}catch(err) {
		alert(err);
	}
	}

	function attachALinkClick(e) {
	try{
		preventDefault(e);
		var attach_a_link = null;
		if (this.addEventListener) {
			attach_a_link = this;
		}else {
			/**
			* attachEvent() doesn't give "this" as the element. for ie8-
			*/
			attach_a_link = e.srcElement;
		}
		attach_a_link.style.display = "none";
		that.j_attach_input_containter.style.display = "block";

	}catch(err) {
		alert(err);
	}
	}

	function attachLinkClick(e) {
	try{
		preventDefault(e);
		var attach_link = null;
		if (this.addEventListener) {
			attach_link = this;
		}else {
			/**
			* attachEvent() doesn't give "this" as the element. for ie8-
			*/
			attach_link = e.srcElement;
		}


		var attach_input_value = attach_input.value;
		if (isUrl(attach_input_value)) {
			if (attach_input_value.length == 0 || attach_input_value == "Add a link...") {
				// do nothing
			}else {
				that.j_attach_input_containter.style.display = "none";
				that.j_attach_loading_status.style.display = "block";
				that.j_attach_content_container.style.display = "block";
				var temp_attach_link_url = attach_link_url + "&link=" + attach_input.value;
				AjaxGet(temp_attach_link_url, attachLinkSuccess, attachLinkError);
			}
		}else {
			alert("Please enter a valid url.");
		}

	}catch(err) {
		alert(err);
	}
	}

	function attachLinkSuccess() {
	try{
		var data = JSON.parse(xhr.responseText);
		var html = data.html;

		that.j_attach_loading_status.style.display = "none";

		var temp_div = document.createElement('div');
		temp_div.innerHTML = data.html;
		that.j_attach_content.appendChild(temp_div.firstChild);
		that.j_attach_content.style.display = "block";

		var attach_images = getElementsByAttribute(document, "img", "data-comment-dom-id", "attach-image");

		if (attach_images != null && attach_images.length > 1) {
			that.j_attach_nav_container.style.display = "block";
		}

		that.j_attach_remove_link.style.display = "block";

	}catch(err) {
		alert(err);
	}
	}


	function attachInputFocus(e) {
	try{
		var attach_input = null;
		if (this.addEventListener) {
			attach_input = this;
		}else {
			/**
			* attachEvent() doesn't give "this" as the element. for ie8-
			*/
			attach_input = e.srcElement;
		}
		if (attach_input.value == "Add a link...") {
			attach_input.value = "";
		}
	}catch(err) {
		alert(err);
	}
	}

	function attachLinkError() {
	try{
		alert("Oops! An error occurred while processing your request.");
	}catch(err) {
		alert(err);
	}
	}

	function attachInputFocusout(e) {
	try{
		var attach_input = null;
		if (this.addEventListener) {
			attach_input = this;
		}else {
			/**
			* attachEvent() doesn't give "this" as the element. for ie8-
			*/
			attach_input = e.srcElement;
		}
		var val = attach_input.value;

		if (val.length == 0) {
			attach_input.value = "Add a link...";
		}

	}catch(err) {
		alert(err);
	}
	}

	function commentContainerMouseover(e) {
	try{
		var target = getEventTarget(e);
		var comment_dom_id = target.getAttribute("data-comment-dom-id");

		if (comment_dom_id == "child-avatar") {
			var child_entry_container = getClosestParentByAttribute(target, "data-comment-dom-id", "child-entry-container");
			var child_content_wraps = getElementsByAttribute(child_entry_container, "div", "data-comment-dom-id", "child-content-wrap");

			for (var i=0; i<child_content_wraps.length; i++) {
				var child_content_wrap = child_content_wraps[i];
				child_content_wrap.style.display = "none";
			}

			var child_entry = getClosestParentByAttribute(target, "data-comment-is-parent", "false");
			var cur_child_content_wrap = getFirstElementsByAttribute(child_entry, "div", "data-comment-dom-id", "child-content-wrap");
			cur_child_content_wrap.style.display = "block";
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
		//document.title += "-addCommentTextareaFocus";
		var comment_add_textarea = null;
		if (this.addEventListener) {
			//document.title += "-addEventListener";
			comment_add_textarea = this;
		}else {
			/**
			* attachEvent() doesn't give "this" as the element. for ie8-
			*/
			//document.title += "-attachEvent";
			comment_add_textarea = e.srcElement;
		}
		if (comment_add_textarea.value == "Start a discussion...") {
			comment_add_textarea.value = "";
		}

		var form_container = getClosestParentByAttribute(comment_add_textarea, "data-comment-dom-id", "add-comment-form-container");
		//getFirstElementsByAttribute(form_container, "div", "data-comment-dom-id", "avatar").style.display = "block";
		//getFirstElementsByAttribute(form_container, "div", "data-comment-dom-id", "add-comment-submit").style.display = "block";
		var comment_add_textarea_detail = getFirstElementsByAttribute(form_container, "textarea", "data-comment-dom-id", "add-comment-textarea-detail");
		comment_add_textarea_detail.parentNode.style.display = "block";
		//var comment_add_textarea_container = getFirstElementsByAttribute(form_container, "div", "data-comment-dom-id", "add-comment-textarea-container");
		//comment_add_textarea_container.style.margin = "0 0 0 90px";
		//comment_add_textarea_container.style.minHeight = "80px";

	}catch(err) {
		alert(err);
	}
	}

	function addCommentTextareaFocusout(e) {
	try{
		//document.title += "-addCommentTextareaFocusout";
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
			comment_add_textarea.value = "";
			comment_add_textarea.style.height = "14px";
			comment_add_textarea.value = "Start a discussion...";
		}

	}catch(err) {
		alert(err);
	}
	}

	function collapseAddCommentTextarea(comment_add_textarea, add_comment_textarea_detail) {
	try{
		comment_add_textarea.value = "";
		comment_add_textarea.style.height = "14px";
		comment_add_textarea.value = "Start a discussion...";
		add_comment_textarea_detail.value = "Add more details...";

		var form_container = getClosestParentByAttribute(comment_add_textarea, "data-comment-dom-id", "add-comment-form-container");
		//getFirstElementsByAttribute(form_container, "div", "data-comment-dom-id", "avatar").style.display = "none";
		//getFirstElementsByAttribute(form_container, "div", "data-comment-dom-id", "add-comment-submit").style.display = "none";
		var comment_add_textarea_detail = getFirstElementsByAttribute(form_container, "textarea", "data-comment-dom-id", "add-comment-textarea-detail");
		comment_add_textarea_detail.parentNode.style.display = "none";
		//var comment_add_textarea_container = getFirstElementsByAttribute(form_container, "div", "data-comment-dom-id", "add-comment-textarea-container");
		//comment_add_textarea_container.style.margin = "0";
		//comment_add_textarea_container.style.minHeight = "0";

	}catch(err) {
		alert(err);
	}
	}

	function addCommentTextareaDetailFocus(e) {
	try{
		//document.title += "-addCommentTextareaFocus";
		var comment_add_textarea_detail = null;
		if (this.addEventListener) {
			//document.title += "-addEventListener";
			comment_add_textarea_detail = this;
		}else {
			/**
			* attachEvent() doesn't give "this" as the element. for ie8-
			*/
			//document.title += "-attachEvent";
			comment_add_textarea_detail = e.srcElement;
		}
		if (comment_add_textarea_detail.value == "Add more details...") {
			comment_add_textarea_detail.value = "";
		}

	}catch(err) {
		alert(err);
	}
	}

	function addCommentTextareaDetailFocusout(e) {
	try{
		//document.title += "-addCommentTextareaFocusout";
		var comment_add_textarea_detail = null;
		if (this.addEventListener) {
			comment_add_textarea_detail = this;
		}else {
			/**
			* attachEvent() doesn't give "this" as the element. for ie8-
			*/
			comment_add_textarea_detail = e.srcElement;
		}
		var val = comment_add_textarea_detail.value;

		if (val.length == 0) {
			comment_add_textarea_detail.value = "Add more details...";
		}

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
			//document.title += "-using ie";
			addEventHandler(comment_reply_textarea, "focusout", addReplyTextareaFocusout);
		}else {
			comment_reply_textarea.addEventListener ("blur", addReplyTextareaFocusout, false);
		}

		comment_reply_form_container.style.display = "block";
		comment_reply_textarea.focus();

		//setInterval(function() { comment_reply_textarea.focus() }, 1000);

	}catch(err) {
		alert(err);
	}
	}

	/*
	function addReplyTextareaFocus(e) {
	try{
		var target = getEventTarget(e);

		document.title += "addReplyTextareaFocus";

	}catch(err) {
		alert(err);
	}
	}
	*/

	function addReplyTextareaFocusout(e) {
	try{
		var target = getEventTarget(e);
		var val = target.value;
		//document.title += "-val: " + val;
		if (val.length == 0) {
			getClosestParentByAttribute(target, "data-comment-dom-id", "add-reply-form-container").style.display = "none";
		}

	}catch(err) {
		alert(err);
	}
	}

	/*
	function hideReplyFormContainer(e) {
	try{
		var target = getEventTarget(e);
		var val = target.value;
		document.title += "-val: " + val;
		if (val.length == 0) {
			var all_reply_form_container = getElementsByAttribute(target, "data-comment-dom-id", "add-reply-form-container")


			.style.display = "none";
		}

	}catch(err) {
		alert(err);
	}
	}
	*/

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
		//document.title += "-addComment";
		var url = comment_add_form.getAttribute("action");
		var class_pk = comment_add_form.elements[namespace + "classPK"].value;
		var class_name = comment_add_form.elements[namespace + "className"].value;
		var group_image_id = comment_add_form.elements[namespace + "groupImageId"].value;

		var title = getFirstElementsByAttribute(comment_add_form, "textarea", "data-comment-dom-id", "add-comment-textarea").value;
		if (title.length == 0 || title == "Start a discussion...") {
			comment_adding = false;
		}else {
			var content = getFirstElementsByAttribute(comment_add_form, "textarea", "data-comment-dom-id", "add-comment-textarea-detail").value;
			if (content == "Add more details...") {
				content = "";
			}
			var attach_content = that.j_attach_content.innerHTML;

			var attach_content_image_img = getFirstElementsByAttribute(that.j_attach_content, "img", "data-comment-dom-id", "attach-content-image");
			var attach_content_title_span = getFirstElementsByAttribute(that.j_attach_content, "span", "data-comment-dom-id", "attach-content-title");
			var attach_content_link_p = getFirstElementsByAttribute(that.j_attach_content, "p", "data-comment-dom-id", "attach-content-link");
			var attach_content_description_p = getFirstElementsByAttribute(that.j_attach_content, "p", "data-comment-dom-id", "attach-content-description");

			var attach_content_image = "";
			var attach_content_title = "";
			var attach_content_link = "";
			var attach_content_description = "";
			if (attach_content_image_img) {
				attach_content_image = attach_content_image_img.getAttribute("src");
			}
			if (attach_content_title_span) {
				attach_content_title = attach_content_title_span.innerHTML;
			}
			if (attach_content_link_p) {
				attach_content_link = attach_content_link_p.innerHTML;
			}
			if (attach_content_description_p) {
				attach_content_description = attach_content_description_p.innerHTML;
			}

			url += "&class_pk=" + class_pk + "&class_name=" + class_name + "&title=" + encodeURIComponent(title) + "&content=" + encodeURIComponent(content) + "&group_image_id=" + group_image_id +
				"&attach_content_image=" + attach_content_image + "&attach_content_title=" + attach_content_title +
				"&attach_content_link=" + attach_content_link + "&attach_content_description=" + encodeURIComponent(attach_content_description);

			AjaxPost(url, addCommentSuccess, addCommentError);
		}
	}catch(err) {
		alert(err);
	}
	}

	function addCommentSuccess() {
	try{
		var data = JSON.parse(xhr.responseText);
		var class_pk = data.class_pk;

		var comment_entry_container = getFirstElementsByAttribute(document, "div", "data-comment-entry-id", class_pk);

		var add_comment_textarea = getFirstElementsByAttribute(comment_entry_container, "textarea", "data-comment-dom-id", "add-comment-textarea");
		var add_comment_textarea_detail = getFirstElementsByAttribute(comment_entry_container, "textarea", "data-comment-dom-id", "add-comment-textarea-detail");
		add_comment_textarea.value = "";
		add_comment_textarea_detail.value = "";
		collapseAddCommentTextarea(add_comment_textarea, add_comment_textarea_detail);

		var entry_container = getFirstElementsByAttribute(comment_entry_container, "ul", "data-comment-dom-id", "entry-container");

		var temp_div = document.createElement('div');
		temp_div.innerHTML = data.html;
		entry_container.insertBefore(temp_div.firstChild, entry_container.firstChild);

		// update counts
		var parent_count = getFirstElementsByAttribute(comment_entry_container, "span", "data-comment-dom-id", "parent-count");
		if (parent_count) {
			parent_count.innerHTML = parseInt(parent_count.innerHTML) + 1;
		}

		that.j_attach_content_container.style.display = "none";
		that.j_attach_content.style.display = "none";
		that.j_attach_content.innerHTML = "";
		that.j_attach_input.value = "Add a link...";
		that.j_attach_input_containter.style.display = "block";

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

			//document.title += "-addReplyFormSubmit";
			addReply(getClosestParentByAttribute(target, "data-comment-dom-id", "add-reply-form"));
		}
	}catch(err) {
		alert(err);
	}
	}

	function addReply(comment_reply_form) {
	try{
		//document.title += "-addReply";
		var url = comment_reply_form.getAttribute("action");
		//document.title += "-url: " + url;
		var class_pk = comment_reply_form.elements[namespace + "classPK"].value;
		var class_name = comment_reply_form.elements[namespace + "className"].value;
		var url_title = comment_reply_form.elements[namespace + "urlTitle"].value;
		var content = getFirstElementsByAttribute(comment_reply_form, "textarea", "data-comment-dom-id", "add-reply-textarea").value;

		var parent_entry = getClosestParentByAttribute(comment_reply_form, "data-comment-is-parent", "true");
		var parent_id = parent_entry.getAttribute("data-comment-id");

		url += "&class_pk=" + class_pk + "&class_name=" + class_name + "&parent_id=" + parent_id + "&url_title=" + encodeURIComponent(url_title) + "&content=" + encodeURIComponent(content);
		AjaxPost(url, addReplySuccess, addReplyError);

	}catch(err) {
		alert(err);
	}
	}

	function addReplySuccess() {
	try{
		var data = JSON.parse(xhr.responseText);
		var class_pk = data.class_pk;
		var comment_entry_container = getFirstElementsByAttribute(document, "div", "data-comment-entry-id", class_pk);
		var parent_id = data.parent_id;
		//document.title += "-parentId: " + parent_id;
		var parent_entry = getFirstElementsByAttribute(comment_entry_container, "li", "data-comment-id", parent_id);

		var add_reply_textarea = getFirstElementsByAttribute(parent_entry, "textarea", "data-comment-dom-id", "add-reply-textarea");
		add_reply_textarea.value = "";

		getClosestParentByAttribute(add_reply_textarea, "data-comment-dom-id", "add-reply-form-container").style.display = "none";

		var child_entry_container = getFirstElementsByAttribute(parent_entry, "ul", "data-comment-dom-id", "child-entry-container");

		var temp_div = document.createElement('div');
		temp_div.innerHTML = data.html;
		child_entry_container.insertBefore(temp_div.firstChild, child_entry_container.firstChild);


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
		//document.title += "-deleteComment";
		if (confirm("Are you sure to delete this post?")) {
			var comment_entry = getClosestParentByAttributeName(entry_options, "data-comment-id");
			var comment_id = comment_entry.getAttribute("data-comment-id");
			var is_parent = comment_entry.getAttribute("data-comment-is-parent");

			var comment_entry_container = getClosestParentByAttributeName(entry_options, "data-comment-entry-id");
			var class_pk = comment_entry_container.getAttribute("data-comment-entry-id");

			var temp_delete_comment_url = delete_comment_url + "&comment_id=" + comment_id + "&is_parent=" + is_parent + "&class_pk=" + class_pk;
			AjaxGet(temp_delete_comment_url, deleteCommentSuccess, deleteCommentError);

		}

	}catch(err) {
		alert(err);
	}
	}

	function deleteCommentSuccess() {
	try{
		//document.title += "-deleteCommentSuccess";
		var data = JSON.parse(xhr.responseText);
		var comment_id = data.comment_id;
		var comment_entry = getFirstElementsByAttribute(document, "li", "data-comment-id", comment_id);
		comment_entry.parentNode.removeChild(comment_entry);

		var class_pk = data.class_pk;
		var comment_entry_container = getFirstElementsByAttribute(document, "div", "data-comment-entry-id", class_pk);
		var parent_count = getFirstElementsByAttribute(comment_entry_container, "span", "data-comment-dom-id", "parent-count");
		if (parent_count) {
			parent_count.innerHTML = parseInt(parent_count.innerHTML) - 1;
		}

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
	
	function AjaxPost(url, successFunc, errorFunc) {
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
		   var params = url.substring(url.indexOf('?') + 1); 
		   url = url.substring(0, url.indexOf('?'));
		   xhr.open("POST", url,  true);
		   xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
		   xhr.send(params);

		}catch(err) {
			alert(err);
		}
		}

	function isUrl(s) {
		var regexp = /(ftp|http|https):\/\/(\w+:{0,1}\w*@)?(\S+)(:[0-9]+)?(\/|\/([\w#!:.?+=&%@!\-\/]))?/;
		return regexp.test(s);
	}

	__construct(param);


	/**
	function entryContentMouseenter(e) {
	try{
		var comment_entry_content = null;
		if (this.addEventListener) {
			comment_entry_content = this;
		}else {
			// attachEvent() doesn't give "this" as the element. for ie8-
			comment_entry_content = e.srcElement;
		}
		getFirstElementsByAttribute(comment_entry_content, "div", "data-comment-dom-id", "entry-options").style.display = "block";

	}catch(err) {
		alert(err);
	}
	}

	function entryContentMouseleave(e) {
	try{
		var comment_entry_content = null;
		if (this.addEventListener) {
			comment_entry_content = this;
		}else {
			// attachEvent() doesn't give "this" as the element. for ie8-
			comment_entry_content = e.srcElement;
		}
		getFirstElementsByAttribute(comment_entry_content, "div", "data-comment-dom-id", "entry-options").style.display = "none";

	}catch(err) {
		alert(err);
	}
	}
	*/


}