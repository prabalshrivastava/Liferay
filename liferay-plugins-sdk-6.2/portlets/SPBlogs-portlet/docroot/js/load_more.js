function LoadMore(param) {
try{
	var newObj = new Object();
	
	var that = this;

	this.j_view_more_link = null;

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

	newObj.initViewMoreLinkClickEvent = false;
	newObj.completed = false;

	function __construct(p) {
	try{
		for (pkey in p) {
			if (pkey[0] != "_") {
				that[pkey] = p[pkey];
			}
		}

		for (var i=0; i<that.j_view_more_link.length; i++) {
			if (navigator.appName == 'Microsoft Internet Explorer') {
				addEventHandler(that.j_view_more_link[i], "click", viewMoreLinkClick);
			}else {
				that.j_view_more_link[i].addEventListener ("click", viewMoreLinkClick, false);
			}
		}

		newObj.initViewMoreLinkClickEvent = true;

	}catch(err) {
		console.log("construct: " + err);
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

		//document.title += "-offset: " + retrieve_params.offset;

	}catch(err) {
		console.log("init: " + err);
	}
	}

	/*
	function loadMoreDelegationClick(e) {
	try{
		var target = getEventTarget(e);
		var loadmore_dom_id = target.getAttribute("data-loadmore-dom-id");
		if (loadmore_dom_id == "view-more-link") {
			viewMoreLinkClick(e);
		}
	}catch(err) {
		console.log(err);
	}
	}
	*/

	function viewMoreLinkClick(e) {
	try{
		// document.title += " -viewMoreLinkClick";
		/*
		triggered_view_more_button = that.j_view_more_link;
		*/

		preventDefault(e);
		var target = getEventTarget(e);
		triggered_view_more_button = target;

		/*
		if (this.addEventListener) {
			triggered_view_more_button = this;
		}else {
			//attachEvent() doesn't give "this" as the element. for ie8-
			triggered_view_more_button = e.srcElement;
		}
		*/

		init();
		view_more_link_container.style.display = "none";
		retrieve();

	}catch(err) {
		console.log("viewMoreLinkClick: " + err);
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
		console.log("retrieve: " + err);
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
		console.log(err);
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

		if (cur_showing_no == 0) {
			load_msg.innerHTML = no_results_msg;
			load_msg.style.display = "block";
		}else if (cur_showing_no < init_total) {
			if (unshown_status) {
				unshown_status.innerHTML = getUnshowingStatus();
			}
			view_more_link_container.style.display = "block";
		}else if (cur_showing_no >= init_total) {
			load_msg.innerHTML = no_more_results_msg;
			load_msg.style.display = "block";
		}

		// after complete
		retrieveComplete();
		if (showingBlog)
			checkIfAutoLoadMoreNeeded();
	}catch(err) {
		console.log("retrieveSuccess: " + err);
	}
	}

	function retrieveError() {
	try{
		load_msg.innerHTML = error_msg;
		load_msg.style.display = "block";

		// after complete
		retrieveComplete();

	}catch(err) {
		console.log(err);
	}
	}

	function retrieveComplete() {
	try{
		newObj.completed = true;
		loading_status.style.display = "none";
		retrieving = false;

	}catch(err) {
		console.log(err);
	}
	}

	function getUnshowingStatus() {
	try{
		return init_total - cur_showing_no;
	}catch(err) {
		console.log("getUnshowingStatus: " + err);
	}
	}

	__construct(param);

	return newObj;

}catch(err) {
	console.log(err);
}
}


function checkIfAutoLoadMoreNeeded() {
	AUI().use('aui-node', 'aui-base', function(A) {
		var temp = A.one('#spblogs-stream-list .active');
		if (!temp) {
			if (A.one("#spblogs-stream-view-more-link")) {
				simulate(document.getElementById("spblogs-stream-view-more-link"), "click");
			} else {
				return;
			}
		} else {
			scrollToActiveElement();
		}
	});
}
// for the categories panel to auto select and click on loadmore if there are behind load more..
function scrollToActiveElement() {
	AUI().use('aui-node', 'aui-base', function(A) {
		var activeEle = A.one('#spblogs-stream-list .active');
		var parentEle = activeEle.getDOM().offsetParent;
		parentEle.scrollTop = activeEle.getDOM().offsetTop;
		if (activeEle.getDOM().offsetParent.scrollTop != activeEle.getDOM().offsetTop) {
			if (A.one("#spblogs-stream-view-more-link") && A.one("#spblogs-stream-view-more-link").get("parentNode").getStyle("display") != 'none') {
				simulate(document.getElementById("spblogs-stream-view-more-link"), "click");
			}
		}
	});
}

function initFixedCats() {
	var profNav = null;
	YUI().use('event-hover', 'node', 'transition', 'event', function(Y) {
		try {
			profNav = Y.one('.profile_form_navigation');

			if (profNav) {
				profNav.addClass('animate');
				Y.on('scroll', function(e) {
					checkOffset(e);
				});
			}
		}catch(err) {}

		function checkOffset(e) {
			try {
				var val = profNav.get("offsetTop") + profNav.get('offsetHeight');
				var footerOffsetTop = Y.one('footer').get('offsetTop');
				if((((window.scrollY  || window.pageYOffset ) + val)) >= (footerOffsetTop)){
					profNav.removeClass('spblogs-fixed');
					profNav.addClass('spblogs-abs');
				}
				if(((window.scrollY  || window.pageYOffset ) + window.innerHeight) < (footerOffsetTop)){
					profNav.removeClass('spblogs-abs');	
					profNav.addClass('spblogs-fixed');
				}
			}catch(err){}
		}
	});
}
