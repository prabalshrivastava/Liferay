function AutoComplete(param) {

	var that = this;
	
	var find_suggestions_url = "";
	var portlet_namespace = "";
	
	var j_ip_form = null;
	var j_autocomplete_sis_holder = null;
	var j_autocomplete_input = null;
	var j_autocomplete_suggestions_board = null;
	var j_autocomplete_close_btn = null;
	var j_autocomplete_options = null;
	var j_autocomplete_selected_items = null;
	var pasted = false;
	var action = 'notefToSuggestions';
	
	var shareEmailList = [];
	
	var old_input_value = "";
	
	var xhr = null;
	
	function __construct(p) {
		
		for(pkey in p) {
			if(pkey[0] != "_") {
				that[pkey] = p[pkey];
			}
			if(p._find_suggestions_url) {
				find_suggestions_url = p._find_suggestions_url;
			}
			if(p._portlet_namespace) {
				portlet_namespace = p._portlet_namespace;
			}
		}
		
		shareEmailList= p.shareEmailList;
		action = p.action
		
		if (navigator.appName == 'Microsoft Internet Explorer') {
			addEventHandler(that.j_autocomplete_input, "focusin", inputOnFocus);
			addEventHandler(that.j_autocomplete_input, "focusout", inputOnBlur);
			addEventHandler(that.j_autocomplete_input, "keydown", inputOnKeydown);
			addEventHandler(that.j_autocomplete_input, "keyup", inputOnKeyup);
			addEventHandler(that.j_autocomplete_close_btn, "click", closeBtnOnClick);
		}else {
			that.j_autocomplete_input.addEventListener ("focus", inputOnFocus, false);
			that.j_autocomplete_input.addEventListener ("blur", inputOnBlur, false);
			that.j_autocomplete_input.addEventListener ("keydown", inputOnKeydown, false);
			that.j_autocomplete_input.addEventListener ("keyup", inputOnKeyup, false);
			that.j_autocomplete_close_btn.addEventListener ("click", closeBtnOnClick, false);
		}

		if (navigator.appName == 'Microsoft Internet Explorer') {
			addEventHandler(that.j_ip_form, "click", ipFormOnClick);
			addEventHandler(that.j_ip_form, "mouseover", ipFormOnMouseover);
		}else {
			that.j_ip_form.addEventListener ("click", ipFormOnClick, false);
			that.j_ip_form.addEventListener ("mouseover", ipFormOnMouseover, false);
		}
		
	}
	
	function inputOnFocus(e) {
	try{
		
	}catch(err) {
		// alert(err);
	}
	}
	
	function inputOnBlur(e) {
	try{
		
		
	}catch(err) {
		// alert(err);
	}
	}

	function inputOnKeydown(e) {
	try{
		var keycode = (e.keyCode ? e.keyCode : e.which);
		pasted = (e.metaKey || e.ctrlKey) && (e.keyCode == 86);
	    if(keycode == 13 || keycode == 188) {

			// enter and comma keydown code
	    	preventDefault(e);
	    	
			var options = getElementsByAttribute(that.j_autocomplete_options, "div", "data-autocomplete-dom-id", "option");
			
			var selected_option_to_be = null;
			
			for(var i = 0; i < options.length; i++) {
				var option = options[i];
				if(hasClass(option, "hover")) {
					selected_option_to_be = option;
				}
			}
			if(selected_option_to_be) {
				
				var user_id = selected_option_to_be.getAttribute("data-user-id");
				var user_img = getFirstElementsByAttribute(selected_option_to_be, "img", "data-autocomplete-dom-id", "option-img").getAttribute("src");
				var username =getFirstElementsByAttribute(selected_option_to_be, "span", "data-autocomplete-dom-id", "option-name").innerHTML;
				var email = selected_option_to_be.getAttribute("data-user-mail");
				createSelectedItem(email,user_id, user_img, username);

			}
			
	    }else if(keycode == 38 || keycode == 40) {
	    	
	    	// go up or down

			var options = getElementsByAttribute(that.j_autocomplete_options, "div", "data-autocomplete-dom-id", "option");
			
			if(options.length > 0) {
		    	preventDefault(e);
			}

	    }

	}catch(err) {
		 //alert(err);
		console.log(err);
	}
	}
	
	this.createMailIds=function(mailIds){
		if(mailIds){
			var inputVal = mailIds;
			var emailArray = inputVal.match(/([a-zA-Z0-9._-]+@[a-zA-Z0-9._-]+\.[a-zA-Z0-9._-]+)/gi);
			for (var i = 0; i < emailArray.length; i++) {
				createSelectedItemByEmail(emailArray[i]);
			}
		}
	}
	function inputOnKeyup(e) {
	try{
		var keycode = (e.keyCode ? e.keyCode : e.which);
		
		if(pasted) {
			var inputVal = that.j_autocomplete_input.value;
			var emailArray = inputVal.match(/([a-zA-Z0-9._-]+@[a-zA-Z0-9._-]+\.[a-zA-Z0-9._-]+)/gi);
			for (var i = 0; i < emailArray.length; i++) {
				createSelectedItemByEmail(emailArray[i]);
				//alert(emailArray[i]);
			}
			pasted = false;
	    } else if(keycode == 13 || keycode == 188) {
	    	
			// enter and comma keydown code
	    	
	    	// do nothing
	    	
	    }else if(keycode == 8) {
	    	
	    	// delete
	    	
	    	var input_vaule = that.j_autocomplete_input.value;
	    	
	    	if(input_vaule.length == 0) {
	    		
	    		if(old_input_value == 0) {

	    			var last_si = getLastChild(that.j_autocomplete_selected_items);
					
					if(last_si) {
						var elmnt = getFirstElementsByAttribute(last_si, "span", "data-autocomplete-dom-id", "si-name");
						if(elmnt){
							var username = elmnt.innerHTML;
							last_si.parentNode.removeChild(last_si);
							that.j_autocomplete_input.value = username;
							simulateServerProcess();
						}
						//that.j_autocomplete_suggestions_board.style.display = "block";
					}
	    		}else {
					that.j_autocomplete_options.scrollTop = 0;
					that.j_autocomplete_options.innerHTML = "";
					that.j_autocomplete_suggestions_board.style.display = "none";
	    		}
				
	    	}else {

				simulateServerProcess();
				//that.j_autocomplete_suggestions_board.style.display = "block";
	    	}

	    	old_input_value = input_vaule;
	    	
	    }else if(keycode == 38) {
	    	
	    	// go up
	    	
			var options = getElementsByAttribute(that.j_autocomplete_options, "div", "data-autocomplete-dom-id", "option");
			
			var cur_selected_option = null;
			
			for(var i = 0; i < options.length; i++) {
				var option = options[i];
				if(hasClass(option, "hover")) {
					cur_selected_option = option;
					break;
				}
			}
			
			if(cur_selected_option) {
				var prev_option = getPreviousSibling(cur_selected_option);
				if(prev_option) {
					removeClass(cur_selected_option, "hover");
					addClass(prev_option, "hover");
					
					var scroll_height = Math.max(that.j_autocomplete_options.scrollHeight, that.j_autocomplete_options.clientHeight);
					var prev_option_offset_top = prev_option.offsetTop;

					if((prev_option_offset_top) < (160 + that.j_autocomplete_options.scrollTop)) {
						that.j_autocomplete_options.scrollTop = prev_option_offset_top;
					}
				}
			}
	    	
	    }else if(keycode == 40) {
	    	
	    	// go down
			var options = getElementsByAttribute(that.j_autocomplete_options, "div", "data-autocomplete-dom-id", "option");
			
			var cur_selected_option = null;
			
			for(var i = 0; i < options.length; i++) {
				var option = options[i];
				if(hasClass(option, "hover")) {
					cur_selected_option = option;
					break;
				}
			}

			if(cur_selected_option) {
				var next_option = getNextSibling(cur_selected_option);
				if(next_option) {
					removeClass(cur_selected_option, "hover");
					addClass(next_option, "hover");

					var scroll_height = Math.max(that.j_autocomplete_options.scrollHeight, that.j_autocomplete_options.clientHeight);
					var next_option_offset_top = next_option.offsetTop;
					
					if((next_option_offset_top + 48) > (160 + that.j_autocomplete_options.scrollTop)) {
						that.j_autocomplete_options.scrollTop = next_option_offset_top + 48 - 160;
					}
					
				}
			}
	    	
	    }else {
			simulateServerProcess();
			//that.j_autocomplete_suggestions_board.style.display = "block";
	    }

	}catch(err) {
		 //alert(err);
		console.log(err);
	}
	}
	
	function ipFormOnClick(e) {
	try{
		
		var target = getEventTarget(e);
		var autocomplete_dom_id = target.getAttribute("data-autocomplete-dom-id");
		
		var optionOnClick = false;
		var selected_option_to_be = null;
		
		if(autocomplete_dom_id == "option") {
			optionOnClick = true;
			selected_option_to_be = target;
			
		}else if(autocomplete_dom_id == "si-x") {
			var close_btn = target;
			
			var si = getClosestParentByAttribute(close_btn, "data-autocomplete-dom-id", "si");
			si.parentNode.removeChild(si);

			that.j_autocomplete_input.value = "";
			that.j_autocomplete_input.focus();
			old_input_value = "";
		}else {

			var closest_option = getClosestParentByAttribute(target, "data-autocomplete-dom-id", "option");
			if(closest_option) {
				optionOnClick = true;
				selected_option_to_be = closest_option;
			}
		
		}
		
		if(optionOnClick == true) {

			var user_id = selected_option_to_be.getAttribute("data-user-id");

			var user_img = getFirstElementsByAttribute(selected_option_to_be, "img", "data-autocomplete-dom-id", "option-img").getAttribute("src");
			var username =getFirstElementsByAttribute(selected_option_to_be, "span", "data-autocomplete-dom-id", "option-name").innerHTML;
			var email = selected_option_to_be.getAttribute("data-user-mail");
			createSelectedItem(email,user_id, user_img, username);
		

		}
		
	}catch(err) {
		// alert(err);
		console.log(err);
	}	
	}
	
	function ipFormOnMouseover(e) {
	try{

		var target = getEventTarget(e);
		var autocomplete_dom_id = target.getAttribute("data-autocomplete-dom-id");
		
		if(autocomplete_dom_id == "option") {
			var cur_option = target;

			var options = getElementsByAttribute(that.j_autocomplete_options, "div", "data-autocomplete-dom-id", "option");
			
			var cur_selected_option = null;
			
			for(var i = 0; i < options.length; i++) {
				var option = options[i];
				if(hasClass(option, "hover")) {
					cur_selected_option = option;
					break;
				}
			}
			
			removeClass(cur_selected_option, "hover");
			
			addClass(cur_option, "hover");
		}

	}catch(err) {
		// alert(err);
		console.log(err);
	}
	}
	
	function createSelectedItem(email,user_id, user_img, username) {
	try{	
		var emailExists = false;
		var si_html = "<li data-autocomplete-dom-id=\"si\" class=\"ip-si sp-group-maxs\"><div class=\"sp-group-clearfix\"><div class=\"sp-group-lfloat sp-group-mrm\" style=\"line-height: 0;\"><img alt=\"Auto Complete Image\" data-autocomplete-dom-id=\"si-img\" src=\"\" class=\"sp-group-thumb_32\" /></div><div class=\"sp-group-ui-dib\"><div class=\"sp-group-ui-dib sp-group-ui-vam\" style=\"height:32px;\"></div><div class=\"sp-group-ui-dib sp-group-ui-vam\"><span data-autocomplete-dom-id=\"si-name\"></span>(<span userIdCheck=\"userId\" data-autocomplete-dom-id=\"si-email\"></span>)</div></div>"
			+ "<div class=\"sp-group-ui-dib\"><div class=\"sp-group-ui-dib sp-group-ui-vam\"><span data-autocomplete-dom-id=\"si-x\" class=\"ip-si-x sp-group-mlm sp-group-mrs\">X</span></div></div></div></li>";
//			+ "<div style=\"float:right\"></div> </div></li>";

		var temp_div = document.createElement('div');
		temp_div.innerHTML = si_html;
		si = getFirstChild(temp_div);
		var email_ul = getElementsByAttribute(document, "span", "userIdCheck", "userId");
		if(email_ul.length > 0){
			for(var i=0; i<email_ul.length;i++){
				var existingEmail = email_ul[i].innerHTML;
				if(existingEmail.indexOf(email) >-1){
					emailExists = true;
					alert(userAreadyUse);
					that.j_autocomplete_input.value = "";
					break;
				}
			}
		}
		
		if(emailExists == false){
			si.setAttribute("data-user-id", user_id);
			getFirstElementsByAttribute(si, "img", "data-autocomplete-dom-id", "si-img").setAttribute("src", user_img);
			getFirstElementsByAttribute(si, "span", "data-autocomplete-dom-id", "si-name").innerHTML = username;
			getFirstElementsByAttribute(si, "span", "data-autocomplete-dom-id", "si-email").innerHTML = email;
				
			that.j_autocomplete_selected_items.appendChild(si);
	
			that.j_autocomplete_options.scrollTop = 0;
			that.j_autocomplete_options.innerHTML = "";
			that.j_autocomplete_suggestions_board.style.display = "none";
			that.j_autocomplete_input.value = "";
			that.j_autocomplete_input.focus();
			old_input_value = "";
	}
		
	}catch(err) {
		 //alert(err);
		console.log(err);
	}
	}
	
	function createSelectedItemByEmail(email) {
		//alert("createSelectedItemByEmail " + email);
	try{	
		var si_html = "<li emailCheck=\"email\" data-autocomplete-dom-id=\"si\" class=\"ip-si sp-group-maxs\"><div class=\"sp-group-clearfix\"><div class=\"sp-group-lfloat sp-group-mrm\" style=\"line-height: 0;\"><img alt=\"Auto Complete Image\" data-autocomplete-dom-id=\"si-img\" src=\"/../image/user_male_portrait?img_id=0\" class=\"sp-group-thumb_32\" /></div><div class=\"sp-group-ui-dib\"><div class=\"sp-group-ui-dib sp-group-ui-vam\" style=\"height:32px;\"></div><div class=\"sp-group-ui-dib sp-group-ui-vam\"><span data-autocomplete-dom-id=\"si-email\"></span></div></div> " 
			+ "<div class=\"sp-group-ui-dib\"><div class=\"sp-group-ui-dib sp-group-ui-vam\"><span data-autocomplete-dom-id=\"si-x\" class=\"ip-si-x sp-group-mlm sp-group-mrs\">X</span></div></div></div></li>"; 
			 //+ "<div style=\"float:right\"><div style=\"margin-left:10px\" class=\"sp-group-ui-dib sp-group-ui-vam\"><span data-autocomplete-dom-id=\"si-duration\"></span></div><div class=\"sp-group-ui-dib sp-group-ui-vam\"><span  data-autocomplete-dom-id=\"si-x\" class=\"ip-si-x sp-group-mlm sp-group-mrs\">X</span></div></div></div></li>";
		var email_ul = getElementsByAttribute(document, "li", "emailCheck", "email");
		//alert("email_ul " + email_ul);
		 var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
		if (!filter.test(email)) {
	        alert("Not a valid e-mail address");
	        that.j_autocomplete_input.value = "";
	    }else{
			var emailExists = false;
			if(email_ul && email_ul.length > 0){
				for(var i=0; i< email_ul.length; i++){
					var emailStr = email_ul[i].innerHTML;
					if(emailStr.indexOf(email) != -1){
						alert(userAreadyUse);
						that.j_autocomplete_input.value = "";
						emailExists = true;
						break;
					}
				}
			}
		
			
			
			if(!emailExists){
				var temp_div = document.createElement('div');
				temp_div.innerHTML = si_html;
				si = getFirstChild(temp_div);
		
				si.setAttribute("data-user-id", 0);
				getFirstElementsByAttribute(si, "span", "data-autocomplete-dom-id", "si-email").innerHTML = email;
				
				
				that.j_autocomplete_selected_items.appendChild(si);
		
				that.j_autocomplete_options.scrollTop = 0;
				that.j_autocomplete_options.innerHTML = "";
				that.j_autocomplete_suggestions_board.style.display = "none";
				that.j_autocomplete_input.value = "";
				that.j_autocomplete_input.focus();
				old_input_value = "";
			}
		}
	}catch(err) {
		// alert(err);
		console.log(err);
	}
	}
	
	function simulateServerProcess() {
	try{
		//alert("simulateServerProcess");
    	var input_vaule = that.j_autocomplete_input.value;
    	//alert("input_vaule " + input_vaule);
    	if(input_vaule.length > 0) {
    		if(xhr) {
				xhr.abort();
			}
    		var input_value = that.j_autocomplete_input.value;
    		old_input_value = input_value;
    		
    		var group_id = that.j_autocomplete_sis_holder.getAttribute("data-group-id");
//    		var invite_by = that.j_ip_form.elements[portlet_namespace + "inviteBy"].value;
    		
//    		var temp_url = find_suggestions_url + "&group_id=" + group_id + "&q=" + input_value + "&invite_by=" + invite_by +"&sharedTypeToGetUserList=internalShare";
    		var temp_url = find_suggestions_url + "&group_id=" + group_id + "&q=" + input_value + "&action=" + that.action;

    		AjaxGet(temp_url, simulateServerSuccess, simulateServerError);
    	}
		
	}catch(err) {
		// alert(err);
		console.log(err);
	}
	}
	
	function simulateServerSuccess() {
	try{
		that.j_autocomplete_options.scrollTop = 0;
		that.j_autocomplete_options.innerHTML = "";
		var data = JSON.parse(xhr.responseText);
		//alert("items data " + data);
    	var items = data.items;
		for(var i = 0; i < items.length; i++) {
			var temp_div = document.createElement('div');
			temp_div.innerHTML = items[i].html;
			that.j_autocomplete_options.appendChild(temp_div.firstChild);
		}
		if(items){
			if(items.length < 1){
				that.j_autocomplete_suggestions_board.style.display = "none";
				//that.j_autocomplete_input.style.font.color = "red !important";
				that.j_autocomplete_input.setAttribute('style', 'color:red !important');
				
			}else{
				that.j_autocomplete_suggestions_board.style.display = "block";
				that.j_autocomplete_input.setAttribute('style', 'color:#333 !important');
			}
		}else {
			that.j_autocomplete_suggestions_board.style.display = "none";
		} 
		// after complete
		simulateServerComplete();
		
	}catch(err) {
		// alert(err);
		console.log(err);
	}
	}

	function simulateServerError() {
	try{
		
		// after complete
		simulateServerComplete();
		
	}catch(err) {
		// alert(err);
		console.log(err);
	}
	}
	
	function simulateServerComplete() {
	try{
		
		
	}catch(err) {
		// alert(err);
	}
	}
	
	function closeBtnOnClick(e) {
	try{
		that.j_autocomplete_suggestions_board.style.display = "none";

		that.j_autocomplete_input.value = "";
		old_input_value = "";

		that.j_autocomplete_input.focus();
		
	}catch(err) {
		// alert(err);
		console.log(err);
	}
	}
	
	function AjaxGet(url, successFunc, errorFunc) {
	try{
		if(window.XMLHttpRequest) {
			// code for IE7+, Firefox, Chrome, Opera, Safari
		  	xhr = new XMLHttpRequest();
		}
		else {
			// code for IE6, IE5
		 	xhr = new ActiveXObject("Microsoft.XMLHTTP");
		}
		xhr.onreadystatechange = function() {
			if(xhr.readyState == 4) {
			    if(xhr.status == 200) {
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
		// alert(err);
		console.log(err);
	}
	}

	__construct(param);

	this.getSelectedIds = function() {
		var send_to = "";
		try {
			var selected_items = that.j_autocomplete_selected_items;
			var sis = getElementsByAttribute(selected_items, "li",
					"data-autocomplete-dom-id", "si");
			var userIdOrEmail = '';

			for (var i = 0; i < sis.length; i++) {

				var si = sis[i];

				var user_id = si.getAttribute("data-user-id");
				var si_email_span = getFirstElementsByAttribute(si, "span",
						"data-autocomplete-dom-id", "si-email");
				userIdOrEmail = si_email_span.innerHTML;
				/*
				 * if(user_id == 0) { var si_email_span =
				 * getFirstElementsByAttribute(si, "span",
				 * "data-autocomplete-dom-id", "si-email"); userIdOrEmail =
				 * si_email_span.innerHTML; }else { userIdOrEmail = user_id; }
				 */

				if (send_to.length > 0) {
					send_to += ";";
				}
				send_to += userIdOrEmail;
			}
		} catch (err) {
			// alert(err);
			console.log(err);
		}
		return send_to;
	}
}
