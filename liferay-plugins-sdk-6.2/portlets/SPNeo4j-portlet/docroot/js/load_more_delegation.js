function LoadMoreNeo4j(param) {
try{
	var that = this;

	this.j_load_more_delegation = null;

	var xhr = null;
	var retrieving = false;

	var loadmore_container = null;
	var items_container = null;
	var loading_status = null;
	var view_more_link_container = null;
	var unshown_status = null;
	var load_msg = null;

	var loadmore_data = null;

	var retrieve_url = "";
	var retrieve_params = {};
	var offset = 0;
	var order_by = "";
	var no_results_msg = "";
	var no_more_results_msg = "";
	var error_msg = "";
	var cur_showing_no = 0;
	var init_total = 0;

	var triggered_view_more_button = null;

	function __construct(p) {
	try{
		for (pkey in p) {
			if (pkey[0] != "_") {
				that[pkey] = p[pkey];
			}
		}
		
	//	loadmore_data = p.initialConfig;

		for (var i=0; i<that.j_load_more_delegation.length; i++) {
			if (navigator.appName == 'Microsoft Internet Explorer') {
				addEventHandler(that.j_load_more_delegation[i], "click", loadMoreDelegationClick);
			}else {
				that.j_load_more_delegation[i].addEventListener ("click", loadMoreDelegationClick, false);
			}
		}
		
		initFilter();

	}catch(err) {
		alert(err);
	}
	}

	function init() {
	try{
		loadmore_container = getClosestParentByAttribute(triggered_view_more_button, "data-loadmore-dom-id", "loadmore-container");

		items_container = getFirstElementsByAttribute(loadmore_container, "ul", "data-loadmore-dom-id", "items-container");
		loading_status = getLastElementsByAttribute(loadmore_container, "div", "data-loadmore-dom-id", "loading-status");
		view_more_link_container = getLastElementsByAttribute(loadmore_container, "div", "data-loadmore-dom-id", "view-more-link-container");
		unshown_status = getLastElementsByAttribute(loadmore_container, "span", "data-loadmore-dom-id", "unshown-status");
		load_msg = getLastElementsByAttribute(loadmore_container, "div", "data-loadmore-dom-id", "load-msg");

		// temp fix..consider the 'load more' data from the attribute only if load more 'comments' 
		loadmore_data = JSON.parse(triggered_view_more_button.getAttribute("data-loadmore"), "");

		retrieve_url = loadmore_data.retrieve_url;
		retrieve_params = loadmore_data.retrieve_params;
		offset = retrieve_params.offset;
		order_by = retrieve_params.order_by;
		cur_showing_no = retrieve_params.cur_showing_no;
		init_total = retrieve_params.init_total;
		no_results_msg = loadmore_data.no_results_msg;
		no_more_results_msg = loadmore_data.no_more_results_msg;
		error_msg = loadmore_data.error_msg;

	}catch(err) {
		alert(err);
	}
	}
	function initFilter(){
		AUI().use('event', 'node', function(A) {
			A.one("#filterType").on("change",function(){
				A.one(items_container).all("li").remove();
				view_more_link_container.style.display = "none";
				load_msg.style.display = "none";
				var temp_view_more_button = document.getElementById("sp_activity_feeds_view_more_link");
				var temp_loadmore_data = JSON.parse(triggered_view_more_button.getAttribute("data-loadmore"), "");
				console.log(temp_loadmore_data);
				temp_loadmore_data.retrieve_params.filter_type = this.val();
				temp_loadmore_data.retrieve_params.offset = 10;
				temp_loadmore_data.retrieve_params.cur_showing_no = 0;
				temp_loadmore_data.retrieve_params.init_total = 0;
				triggered_view_more_button.setAttribute("data-loadmore", JSON.stringify(temp_loadmore_data, "", ""));
				simulate(document.getElementById("sp_activity_feeds_view_more_link"), "click");
			});
		});
	}

	function loadMoreDelegationClick(e) {
	try{
		var target = getEventTarget(e);
		var loadmore_dom_id = target.getAttribute("data-loadmore-dom-id");
		if (loadmore_dom_id == "view-more-link") {
			viewMoreLinkClick(e);
		}
	}catch(err) {
		alert(err);
	}
	}

	function viewMoreLinkClick(e) {
	try{
		preventDefault(e);
		var target = getEventTarget(e);
		triggered_view_more_button = target;

		init();
		view_more_link_container.style.display = "none";
		retrieve();

	}catch(err) {
		alert(err);
	}
	}

	function retrieve() {
	try{
		if (!retrieving) {
			retrieving = true;
			loading_status.style.display = "block";
			var temp_retrieve_url = retrieve_url;
			for (var key in retrieve_params) {
				temp_retrieve_url += "&" + key + "=" + retrieve_params[key];
			}
			AjaxGet(temp_retrieve_url, retrieveSuccess, retrieveError);
		}
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

	function retrieveSuccess() {
	try{
		var data = JSON.parse(xhr.responseText);

		var items = data.items;
		for (var i = 0; i < items.length; i++) {
			var temp_div = document.createElement('div');
			temp_div.innerHTML = items[i].html;
			items_container.appendChild(temp_div.firstChild);
		}

		if (cur_showing_no == 0) {
			init_total = data.count;
			loadmore_data.retrieve_params["init_total"] = init_total;
		}

		cur_showing_no += items.length;

		loadmore_data.retrieve_params["cur_showing_no"] = cur_showing_no;
		triggered_view_more_button.setAttribute("data-loadmore", JSON.stringify(loadmore_data, "", ""));

		if (cur_showing_no == 0 || items.length == 0) {
			load_msg.innerHTML = no_results_msg;
			load_msg.style.display = "block";
		}else if (cur_showing_no < init_total) {
			if (unshown_status && triggered_view_more_button.classList.contains('sp-stream-load-more') == false) {
				unshown_status.innerHTML = getUnshowingStatus();
			}
			view_more_link_container.style.display = "block";
		}else if (cur_showing_no >= init_total) {
			load_msg.innerHTML = no_more_results_msg;
			load_msg.style.display = "block";
		}

		// after complete
		retrieveComplete();

	}catch(err) {
		//alert(err);
		console.log(err);
		retrieveError();
		//load_msg.innerHTML = no_results_msg;
		//load_msg.style.display = "block";
	}
	}

	function retrieveError() {
	try{
		load_msg.innerHTML = error_msg;
		load_msg.style.display = "block";

		// after complete
		retrieveComplete();

	}catch(err) {
		alert(err);
	}
	}

	function retrieveComplete() {
	try{
		loading_status.style.display = "none";
		retrieving = false;

	}catch(err) {
		alert(err);
	}
	}

	function getUnshowingStatus() {
	try{
		return init_total - cur_showing_no;
	}catch(err) {
		alert(err);
	}
	}

	__construct(param);

}catch(err) {
	alert(err);
}
}