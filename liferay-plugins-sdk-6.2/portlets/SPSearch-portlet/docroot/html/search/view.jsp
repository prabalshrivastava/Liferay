<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page import="javax.portlet.*" %>

<script src="<c:url value="/js/json2.js" />" type="text/javascript"></script>

<portlet:defineObjects />

<liferay-theme:defineObjects />

<portlet:resourceURL var="retrieveURL">
	<portlet:param name="action" value="retrieve"></portlet:param>
	<portlet:param name="currentURL" value="<%= themeDisplay.getURLCurrent() %>"></portlet:param>
</portlet:resourceURL>

<div class="search-stream-wrapper search-stream-${listingStyle}" id="search-stream-wrapper-<portlet:namespace />">

	<c:if test="${!(headerTitle == null || empty headerTitle)}">
		<div class="search-stream-mosaic-header showdowheader clearfix">
			<span class="search-stream-mosaic-header-title"><font class="header-pretitle">${preTitle}</font><font class="header-posttitle">${postTitle}</font></span>
			<div class="search-stream-pagination">
				<a class="search-stream-pagination-prev" href="#" id="search-stream-pagination-prev-<portlet:namespace />" style="display: none;" title="Previous">
					<img alt="Previous" src="<%= themeDisplay.getPathThemeImages() %>/arrows/up.png"></a>
				<a class="search-stream-pagination-next" href="#" id="search-stream-pagination-next-<portlet:namespace />" style="display: none;" title="Next"><img alt="Next" src="<%= themeDisplay.getPathThemeImages() %>/arrows/down.png"></a>
			</div>
		</div>
	</c:if>
	<ul class="search-stream-mosaic-container" id="search-stream-mosaic-container-<portlet:namespace />">
	</ul>
</div>

<script type="text/javascript">

	var <portlet:namespace />retrieveURL = '<%= retrieveURL.toString() %>';
	var <portlet:namespace />count = 0;
	var <portlet:namespace />currentPage = 0;
	var <portlet:namespace />delta = '${pageItems}';
	var <portlet:namespace />maxPages = 0;

	var <portlet:namespace />xhr;

	var <portlet:namespace />prev_btn = document.getElementById("search-stream-pagination-prev-<portlet:namespace />");
	var <portlet:namespace />next_btn = document.getElementById("search-stream-pagination-next-<portlet:namespace />");

	addEventHandler(<portlet:namespace />prev_btn, "click", <portlet:namespace />prevBtnOnClick);
	addEventHandler(<portlet:namespace />next_btn, "click", <portlet:namespace />nextBtnOnClick);

	function <portlet:namespace />prevBtnOnClick(e) {
		preventDefault(e);
		if ((<portlet:namespace />currentPage - 1) <= 0) {
			if (<portlet:namespace />prev_btn.style.display == "block" || <portlet:namespace />prev_btn.style.display == "inline-block") {
				<portlet:namespace />prev_btn.style.display = "none";
			}
		}
		if ((<portlet:namespace />currentPage - 1) < (<portlet:namespace />maxPages - 1)) {
			if (<portlet:namespace />next_btn.style.display == "none") {
				<portlet:namespace />next_btn.style.display = "inline-block";
			}
		}
		<portlet:namespace />currentPage = <portlet:namespace />currentPage - 1;
		<portlet:namespace />retrieve(<portlet:namespace />retrieveURL + "&<portlet:namespace />currentPage=" + <portlet:namespace />currentPage);
	}

	function <portlet:namespace />nextBtnOnClick(e) {
		preventDefault(e);
		if ((<portlet:namespace />currentPage + 1) >= (<portlet:namespace />maxPages - 1)) {
			if (<portlet:namespace />next_btn.style.display == "block" || <portlet:namespace />next_btn.style.display == "inline-block") {
				<portlet:namespace />next_btn.style.display = "none";
			}
		}
		if ((<portlet:namespace />currentPage + 1) > 0) {
			if (<portlet:namespace />prev_btn.style.display == "none") {
				<portlet:namespace />prev_btn.style.display = "inline-block";
			}
		}
		<portlet:namespace />currentPage = <portlet:namespace />currentPage + 1;
		<portlet:namespace />retrieve(<portlet:namespace />retrieveURL + "&<portlet:namespace />currentPage=" + <portlet:namespace />currentPage);
	}

	function <portlet:namespace />retrieve(url) {
	try{
		<portlet:namespace />AjaxGet(url, <portlet:namespace />retrieveSuccess, <portlet:namespace />retrieveError);

	}catch(err) {
		alert(" -retrieve: " + err);
	}
	}

	function <portlet:namespace />AjaxGet(url, successFunc, errorFunc) {
	try{
		if (window.XMLHttpRequest) {
			// code for IE7+, Firefox, Chrome, Opera, Safari
		  	<portlet:namespace />xhr=new XMLHttpRequest();
		}
		else {
			// code for IE6, IE5
		 	<portlet:namespace />xhr=new ActiveXObject("Microsoft.XMLHTTP");
		}
		<portlet:namespace />xhr.onreadystatechange = function() {
			if (<portlet:namespace />xhr.readyState == 4) {
			    if (<portlet:namespace />xhr.status == 200) {
			    	successFunc();
			    }
			    else {
			    	errorFunc();
			    }
			}
		};

	   <portlet:namespace />xhr.open("GET", url, true);
	   <portlet:namespace />xhr.send(null);

	}catch(err) {
		alert(" -AjaxGet: " + err);
	}
	}

	function <portlet:namespace />retrieveSuccess() {
	try{
		var data = JSON.parse(<portlet:namespace />xhr.responseText);
		<portlet:namespace />count = data.count.value;
		<portlet:namespace />maxPages = <portlet:namespace />count / <portlet:namespace />delta;
		var mod=<portlet:namespace />count % <portlet:namespace />delta;
		if (mod > 0) {
			<portlet:namespace />maxPages++;
		}
		<portlet:namespace />maxPages = parseInt(<portlet:namespace />maxPages);
		var stream_container = document.getElementById("search-stream-mosaic-container-<portlet:namespace />");
		var items = data.items;
		stream_container.innerHTML = "";

		if (items.length == 0) {
			stream_container.innerHTML = "No records available for viewing.";
		}else {
			for (var i = 0; i < items.length; i++) {
				stream_container.innerHTML += items[i].html;
			}
		}

		if (!(<portlet:namespace />currentPage <= 0)) {
			if (<portlet:namespace />prev_btn.style.display == "none") {
				<portlet:namespace />prev_btn.style.display = "inline-block";
			}
		}
		if (!(<portlet:namespace />currentPage >= (<portlet:namespace />maxPages - 1)) && <portlet:namespace />maxPages > 0) {
			if (<portlet:namespace />next_btn.style.display == "none") {
				<portlet:namespace />next_btn.style.display = "inline-block";
			}
		}

	}catch(err) {
		alert(" -retrieveSuccess: " + err);
	}
	}

	function <portlet:namespace />retrieveError() {
		alert("Oops! An unexpected error occurred while processing your request.");
	}

	/*
	function init() {
		var stream_container = document.getElementById("search-stream-mosaic-container-<portlet:namespace />");
		var blocks = stream_container.getElementsByClassName("search-stream-mosaic-block");
		for (var i = 0; i < blocks.length; i++) {
			<portlet:namespace />count++;
		}
		<portlet:namespace />maxPages = <portlet:namespace />count / <portlet:namespace />delta;
		var mod=<portlet:namespace />count % <portlet:namespace />delta;
		if (mod > 0) {
			<portlet:namespace />maxPages++;
		}
		<portlet:namespace />maxPages = parseInt(<portlet:namespace />maxPages);

		if (!(<portlet:namespace />currentPage <= 0)) {
			if (<portlet:namespace />prev_btn.getStyle('display') == "none") {
				<portlet:namespace />prev_btn.setStyle('display', 'inline-block');
			}
		}
		if (!(<portlet:namespace />currentPage >= (<portlet:namespace />maxPages - 1)) && <portlet:namespace />maxPages > 0) {
			if (<portlet:namespace />next_btn.getStyle('display') == "none") {
				<portlet:namespace />next_btn.setStyle('display', 'inline-block');
			}
		}
	}
	*/

	<portlet:namespace />retrieve(<portlet:namespace />retrieveURL + "&<portlet:namespace />currentPage=" + <portlet:namespace />currentPage);

</script>

<script type="text/javascript">

	AUI().ready('', function(A) {

		var channels_detail = getFirstElementsByAttributeName(document, "div", "data-channels-classname");

		if (channels_detail) {
			var channels_classname = channels_detail.getAttribute("data-channels-classname");
			var channels_classpk = channels_detail.getAttribute("data-channels-classpk");
		}

	});

</script>
