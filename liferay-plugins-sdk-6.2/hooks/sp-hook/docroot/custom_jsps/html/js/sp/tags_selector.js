function TagsSelector(param) {

	var that = this;

	this.j_tags_selector_entries_holder = null;
	this.j_tags_selector_input = null;
	this.j_tags_selector_add_btn = null;

	function __construct(p) {
	try{
		for(pkey in p) {
			if(pkey[0] != "_") {
				that[pkey] = p[pkey];
			}
		}

		for(var i=0; i<that.j_tags_selector_entries_holder.length; i++) {
			addEventHandler(that.j_tags_selector_entries_holder[i], "click", tagsSelectorEntriesHolderClick);
		}
		
		for(var i=0; i<that.j_tags_selector_add_btn.length; i++) {
			addEventHandler(that.j_tags_selector_add_btn[i], "click", tagsSelectorAddBtnClick);
		}

		for(var i=0; i<that.j_tags_selector_input.length; i++) {
			addEventHandler(that.j_tags_selector_input[i], "keydown", tagsSelectorInputKeydown);
		}
		

	}catch(err) {
		alert(err);
	}
	}
	
	function tagsSelectorEntriesHolderClick(e) {
	try{
		//document.title += "-tagsSelectorEntriesHolderClick";
		
//		var tags_selector_entries_holder = null;
//		if(this.addEventListener) {
//			tags_selector_entries_holder = this;
//		}else {
//			/**
//			* attachEvent() doesn't give "this" as the element. for ie8-
//			*/
//			tags_selector_entries_holder = e.srcElement;
//		}
//		var tags_selector_input = getFirstElementsByAttribute(tags_selector_entries_holder, "input", "data-tag-dom-id", "tags-selector-input");
		
		var target = getEventTarget(e);
		var tag_dom_id = target.getAttribute("data-tag-dom-id");
		if(tag_dom_id == "tags-selector-entries-holder") {
			var tags_selector_input = getFirstElementsByAttribute(target, "input", "data-tag-dom-id", "tags-selector-input");
			tags_selector_input.focus();
		}else if(tag_dom_id == "tags-selector-close-btn") {
			tagsSelectorCloseBtnClick(e);
		}

	}catch(err) {
		alert(err);
	}
	}
	
	function tagsSelectorAddBtnClick(e) {
	try{
		var target = getEventTarget(e);
		var tags_selector_container = getClosestParentByAttribute(target, "data-tag-dom-id", "tags-selector-container");
		
		var tags_selector_entries_holder = getFirstElementsByAttribute(tags_selector_container, "ul", "data-tag-dom-id", "tags-selector-entries-holder");
		var tags_selector_input = getFirstElementsByAttribute(tags_selector_container, "input", "data-tag-dom-id", "tags-selector-input");
		var input_val = trimStr(tags_selector_input.value);
		if(input_val.length > 0) {
	        var tags_selector_hidden_input = getFirstElementsByAttribute(tags_selector_container, "input", "data-tag-dom-id", "tags-selector-hidden-input");
	        var hidden_input_val = tags_selector_hidden_input.value;
	        var tag_existing = false;
	        if(hidden_input_val.length > 0) {
		        var tag_name_array = hidden_input_val.split(",");
		        for(var i=0; i<tag_name_array.length; i++) {
			        var tag_name = trimStr(tag_name_array[i]);
			        if(input_val == tag_name) {
			        	tag_existing = true;
			        }
		        }
		        if(!tag_existing) {
		        	tags_selector_hidden_input.value += ",";
		        }
	        }
			if(!tag_existing) {
	        	tags_selector_hidden_input.value += input_val;
	        	
		        var tag_entry = document.createElement("li");
		        tag_entry.className = "textboxlistentry";
		        tag_entry.setAttribute("data-tag-dom-id", "tags-selector-entry");
		        var text_span = document.createElement("span");
		        text_span.appendChild(document.createTextNode(input_val));
		        var close_span = document.createElement("span");
		        close_span.className = "icon icon-close textboxlistentry-close";
		        close_span.setAttribute("data-tag-dom-id", "tags-selector-close-btn");
		        tag_entry.appendChild(text_span);
		        tag_entry.appendChild(close_span);
		        tags_selector_entries_holder.insertBefore(tag_entry, getLastChild(tags_selector_entries_holder));
			}
		}
		
		tags_selector_input.value = "";
		tags_selector_input.focus();
		
	}catch(err) {
		alert(err);
	}
	}
	
	function tagsSelectorCloseBtnClick(e) {
	try{
		var target = getEventTarget(e);
		var tag_entry = getClosestParentByAttribute(target, "data-tag-dom-id", "tags-selector-entry");
		var text_span = getFirstChild(tag_entry);
		//document.title += "-tag_span: " + text_span;
		var deleted_tag_name = text_span.innerHTML;
		//document.title += "-deleted_tag_name: " + deleted_tag_name;
		deleted_tag_name = trimStr(deleted_tag_name);
		
		var tags_selector_container = getClosestParentByAttribute(target, "data-tag-dom-id", "tags-selector-container");
        var tags_selector_hidden_input = getFirstElementsByAttribute(tags_selector_container, "input", "data-tag-dom-id", "tags-selector-hidden-input");
        var hidden_input_val = tags_selector_hidden_input.value;

        var new_hidden_input_val = "";
        if(hidden_input_val.length > 0) {
	        var tag_name_array = hidden_input_val.split(",");
	        for(var i=0; i<tag_name_array.length; i++) {
		        var tag_name = trimStr(tag_name_array[i]);
		        if(tag_name != deleted_tag_name) {
		        	if(new_hidden_input_val.length > 0) {
		        		new_hidden_input_val += ",";
		        	}
		        	new_hidden_input_val += tag_name;
		        }
	        }
        }
        
    	tags_selector_hidden_input.value = new_hidden_input_val;
		tag_entry.parentNode.removeChild(tag_entry);

	}catch(err) {
		alert(err);
	}
	}
	
	function tagsSelectorInputKeydown(e) {
	try{
		if (e.which == 13 || e.keyCode == 13) {
			preventDefault(e);
			tagsSelectorAddBtnClick(e);
		}
	}catch(err) {
		alert(err);
	}
	}
	
	__construct(param);
	
}
