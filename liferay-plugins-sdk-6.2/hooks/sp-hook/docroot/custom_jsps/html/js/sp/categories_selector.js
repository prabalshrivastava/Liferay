function CategoriesSelector(param) {

	var that = this;

	this.j_categories_selector_entries_holder = null;
	this.j_categories_selector_select_btn = null;
	this.j_categories_selector_popup_select_btn = null;
	this.j_categories_selector_popup_tree_node_checkbox = null;

	function __construct(p) {
	try{
		for(pkey in p) {
			if(pkey[0] != "_") {
				that[pkey] = p[pkey];
			}
		}

		for(var i=0; i<that.j_categories_selector_entries_holder.length; i++) {
			addEventHandler(that.j_categories_selector_entries_holder[i], "click", categoriesSelectorEntriesHolderClick);
		}
		
		for(var i=0; i<that.j_categories_selector_select_btn.length; i++) {
			addEventHandler(that.j_categories_selector_select_btn[i], "click", categoriesSelectorSelectBtnClick);
		}

		for(var i=0; i<that.j_categories_selector_popup_select_btn.length; i++) {
			addEventHandler(that.j_categories_selector_popup_select_btn[i], "click", categoriesSelectorPopupCloseBtnClick);
		}

		for(var i=0; i<that.j_categories_selector_popup_tree_node_checkbox.length; i++) {
			addEventHandler(that.j_categories_selector_popup_tree_node_checkbox[i], "click", categoriesSelectorPopupTreeNodeCheckboxClick);
		}

	}catch(err) {
		alert(err);
	}
	}
	
	function categoriesSelectorEntriesHolderClick(e) {
	try{
		var target = getEventTarget(e);
		var category_dom_id = target.getAttribute("data-category-dom-id");
		if(category_dom_id == "categories-selector-close-btn") {
			categoriesSelectorCloseBtnClick(e);
		}

	}catch(err) {
		alert(err);
	}
	}
	
	function categoriesSelectorSelectBtnClick(e) {
	try{
		var target = getEventTarget(e);
		var categories_selector_container = getClosestParentByAttribute(target, "data-category-dom-id", "categories-selector-container");
		var categories_selector_popup = getFirstElementsByAttribute(categories_selector_container, "div", "data-category-dom-id", "categories-selector-popup");
		var categories_selector_popup_tree_container = getFirstElementsByAttribute(categories_selector_popup, "ul", "data-category-dom-id", "categories-selector-popup-tree-container");
		var categories_selector_hidden_input = getFirstElementsByAttribute(categories_selector_container, "input", "data-category-dom-id", "categories-selector-hidden-input");
		var hidden_input_val = categories_selector_hidden_input.value;
        
		var popup_tree_node_checkboxes = getElementsByAttribute(categories_selector_popup_tree_container, "div", "data-category-dom-id", "categories-selector-popup-tree-node-checkbox");
		
		for(var i=0; i<popup_tree_node_checkboxes.length; i++) {
			removeClass(popup_tree_node_checkboxes[i].parentNode, "aui-tree-node-checked");
		}
		
		if(hidden_input_val.length > 0) {
        	var category_id_array = hidden_input_val.split(",");
	        for(var i=0; i<category_id_array.length; i++) {
		        var category_id = trimStr(category_id_array[i]);
		        var tree_node_checkbox = getFirstElementsByAttribute(categories_selector_popup_tree_container, "div", "data-category-id", category_id);
		        addClass(tree_node_checkbox.parentNode, "aui-tree-node-checked");
	        }
        }
		
	    removeClass(categories_selector_popup, "aui-helper-hidden");
		
	}catch(err) {
		alert(err);
	}
	}
	
	function categoriesSelectorCloseBtnClick(e) {
	try{
		var target = getEventTarget(e);
		var category_entry = getClosestParentByAttribute(target, "data-category-dom-id", "categories-selector-entry");
		var deleted_category_id = category_entry.getAttribute("data-category-id");
		
		var categories_selector_container = getClosestParentByAttribute(target, "data-category-dom-id", "categories-selector-container");
        var categories_selector_hidden_input = getFirstElementsByAttribute(categories_selector_container, "input", "data-category-dom-id", "categories-selector-hidden-input");
        var hidden_input_val = categories_selector_hidden_input.value;

        var new_hidden_input_val = "";
        if(hidden_input_val.length > 0) {
        	var category_id_array = hidden_input_val.split(",");
	        for(var i=0; i<category_id_array.length; i++) {
		        var category_id = trimStr(category_id_array[i]);
		        if(category_id != deleted_category_id) {
		        	if(new_hidden_input_val.length > 0) {
		        		new_hidden_input_val += ",";
		        	}
		        	new_hidden_input_val += category_id;
		        }
	        }
        }
        
        categories_selector_hidden_input.value = new_hidden_input_val;
    	category_entry.parentNode.removeChild(category_entry);

	}catch(err) {
		alert(err);
	}
	}

	function categoriesSelectorPopupCloseBtnClick(e) {
	try{
		var target = getEventTarget(e);
		var categories_selector_popup = getClosestParentByAttribute(target, "data-category-dom-id", "categories-selector-popup");
		addClass(categories_selector_popup, "aui-helper-hidden");

	}catch(err) {
		alert(err);
	}
	}
	
	function categoriesSelectorPopupTreeNodeCheckboxClick(e) {
	try{
		var target = getEventTarget(e);
		var categories_selector_container = getClosestParentByAttribute(target, "data-category-dom-id", "categories-selector-container");
		var categories_selector_entries_holder = getFirstElementsByAttribute(categories_selector_container, "ul", "data-category-dom-id", "categories-selector-entries-holder");
		
		var categories_selector_hidden_input = getFirstElementsByAttribute(categories_selector_container, "input", "data-category-dom-id", "categories-selector-hidden-input");
        var hidden_input_val = categories_selector_hidden_input.value;
        
		var toggled_category_id = target.getAttribute("data-category-id");
		var toggled_category_name = getNextSibling(target).innerHTML;
		var target_parent_node = target.parentNode;
		if (hasClass(target_parent_node, "aui-tree-node-checked")) {
			removeClass(target_parent_node, "aui-tree-node-checked");
	        var new_hidden_input_val = "";
	        if(hidden_input_val.length > 0) {
	        	var category_id_array = hidden_input_val.split(",");
		        for(var i=0; i<category_id_array.length; i++) {
			        var category_id = trimStr(category_id_array[i]);
			        if(category_id != toggled_category_id) {
			        	if(new_hidden_input_val.length > 0) {
			        		new_hidden_input_val += ",";
			        	}
			        	new_hidden_input_val += category_id;
			        }
		        }
	        }
	        categories_selector_hidden_input.value = new_hidden_input_val;
	        var category_entry = getFirstElementsByAttribute(categories_selector_entries_holder, "li", "data-category-id", toggled_category_id);
	        if(category_entry) {
		    	category_entry.parentNode.removeChild(category_entry);
	        }
		}else {
			addClass(target_parent_node, "aui-tree-node-checked");
			var category_existing = false;
	        if(hidden_input_val.length > 0) {
	        	categories_selector_hidden_input.value += ",";
	        }
			categories_selector_hidden_input.value += toggled_category_id;
	        var category_entry = document.createElement("li");
	        category_entry.className = "textboxlistentry";
	        category_entry.setAttribute("data-category-dom-id", "categories-selector-entry");
	        category_entry.setAttribute("data-category-id", toggled_category_id);
	        var text_span = document.createElement("span");
	        text_span.appendChild(document.createTextNode(toggled_category_name));
	        var close_span = document.createElement("span");
	        close_span.className = "icon icon-close textboxlistentry-close";
	        close_span.setAttribute("data-category-dom-id", "categories-selector-close-btn");
	        category_entry.appendChild(text_span);
	        category_entry.appendChild(close_span);
	        categories_selector_entries_holder.appendChild(category_entry);
		}
	}catch(err) {
		alert(err);
	}
	}
	
	__construct(param);
	
}
