<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<portlet:defineObjects />

<liferay-theme:defineObjects />

<portlet:resourceURL var="retrieveURL" />

<c:if test="${searchArea == 'Functional Group' }">
<div>
	<span class="panel-hd-text"><font class="header-pretitle">Recommended </font><font class="header-posttitle">Training</font></span>
</div>
<div class="showdowheader-profile"></div>

<div class="nicf_url" onClick="window.open('${careerpath}','StatusBar','width=850,menubar=no,toolbar=no,resizable=yes,scrollbars=yes,location=0,height=700,top=100,left=100');">
	Recommended training programmes to upgrade yourself
</div>

<ul class="upcoming-event-mosaic-container" id="<portlet:namespace/>upcoming-event-mosaic-container"></ul>
<div class="upcoming-event-pagination helper-clearfix">
	<a class="upcoming-event-pagination-prev" href="#" id="<portlet:namespace/>upcoming-event-pagination-prev" style="display: none;" title="Previous">Prev</a>
	<a class="upcoming-event-pagination-next" href="#" id="<portlet:namespace/>upcoming-event-pagination-next" style="display: none;" title="Next">Next</a>
</div>

</c:if>
<c:if test="${searchArea == 'Domain Names' }">
<div class="domainAreaEventsList" id="<portlet:namespace/>domainAreaEventsList">
<div>
	<span class="panel-hd-text"><font class="header-pretitle">Upcoming Events </font><font class="header-posttitle">( ${processName })</font></span>
</div>
<div class="showdowheader-profile"></div>

<ul class="upcoming-event-mosaic-container" id="<portlet:namespace/>upcoming-event-mosaic-container-domainArea"></ul>
<div class="upcoming-event-pagination helper-clearfix">
	<a class="upcoming-event-pagination-prev" href="#" id="<portlet:namespace/>upcoming-event-pagination-domainArea-prev" style="display: none;" title="Previous">Prev</a>
	<a class="upcoming-event-pagination-next" href="#" id="<portlet:namespace/>upcoming-event-pagination-domainArea-next" style="display: none;" title="Next">Next</a>
</div>
</div>
</c:if>

<script type="text/javascript">
AUI().ready(function(A) {
try{
	var retrieveURL = '<portlet:resourceURL id="" />';
	var count = 0;
	var currentPage = 0;
	var delta = 3;
	var start = 0;
	var end = 0;
	var maxPages = 0;
	var displayArea = "${searchArea}";
	var displayAreaId = "";
	var prev_btn = "";
	var next_btn = "";
	if(displayArea == "Functional Group"){
		displayAreaId = "<portlet:namespace/>upcoming-event-mosaic-container";
		var prevBtn = "<portlet:namespace/>upcoming-event-pagination-domainArea-prev";
		prev_btn = A.one("#"+prevBtn);
		var nextBtn = "<portlet:namespace/>upcoming-event-pagination-domainArea-next";
		next_btn = A.one("#"+nextBtn);
	}else{
		displayAreaId = "<portlet:namespace/>upcoming-event-mosaic-container-domainArea";
		var prevBtn = "<portlet:namespace/>upcoming-event-pagination-domainArea-prev";
		prev_btn = A.one("#"+prevBtn);
		var nextBtn = "<portlet:namespace/>upcoming-event-pagination-domainArea-next";
		next_btn = A.one("#"+nextBtn);
	}	
	var xhr;

	// implement JSON.parse de-serialization
	JSON.parse = JSON.parse || function(str) {
	    if (str === "") str = '""';
	    eval("var p=" + str + ";");
	    return p;
	};

	// implement JSON.stringify serialization
	JSON.stringify = JSON.stringify || function(obj) {
	    var t = typeof (obj);
	    if (t != "object" || obj === null) {
	        // simple data type
	        if (t == "string") obj = '"'+obj+'"';
	        return String(obj);
	    }
	    else {
	        // recurse array or object
	        var n, v, json = [], arr = (obj && obj.constructor == Array);
	        for (n in obj) {
	            v = obj[n]; t = typeof(v);
	            if (t == "string") v = '"'+v+'"';
	            else if (t == "object" && v !== null) v = JSON.stringify(v);
	            json.push((arr ? "" : '"' + n + '":') + String(v));
	        }
	        return (arr ? "[" : "{") + String(json) + (arr ? "]" : "}");
	    }
	};

	function retrieve(url,displayArea) {
	try{
		AjaxGet(url, retrieveSuccess, retrieveError);

	}catch(err) {
		alert(err);
	}
	}

	function AjaxGet(url, successFunc, errorFunc) {
	try{
		if (window.XMLHttpRequest) {
			// code for IE7+, Firefox, Chrome, Opera, Safari
		  	xhr=new XMLHttpRequest();
		}
		else {
			// code for IE6, IE5
		 	xhr=new ActiveXObject("Microsoft.XMLHTTP");
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
		alert(err);
	}
	}

	function retrieveSuccess() {
	try{
		var data = JSON.parse(xhr.responseText);
		count = data.count.value;
		maxPages = count / delta;
		var mod=count % delta;
		if (mod > 0) {
			maxPages++;
		}
		maxPages = parseInt(maxPages);
		var stream_container = document.getElementById(displayAreaId);
		var items = data.items;
		if(items.length > 0){
			stream_container.innerHTML = "";
			for (var i = 0; i < items.length; i++) {
				stream_container.innerHTML += items[i].html;
			}
		}else{
			var domainAreaEventsList = document.getElementById("<portlet:namespace/>domainAreaEventsList");
			if(domainAreaEventsList){
				domainAreaEventsList.style.display ="none";
			}	
		}	

		if (!(currentPage <= 0)) {
			if(prev_btn){
				if (prev_btn.getStyle('display') == "none") {
					prev_btn.setStyle('display', 'inline-block');
				}
			}	
		}
		if (!(currentPage >= (maxPages - 1)) && maxPages > 0) {
			if(next_btn){
				if (next_btn.getStyle('display') == "none") {
					next_btn.setStyle('display', 'inline-block');
				}
			}	
		}

	}catch(err) {
		alert(err);
	}
	}

	function retrieveError() {
		alert("Oops! An unexpected error occurred while processing your request.");
	}

	if (prev_btn) {
		prev_btn.on('click', function(event) {
			event.preventDefault();
			if ((currentPage - 1) <= 0) {
				if(prev_btn){
					if (prev_btn.getStyle('display') == "block" || prev_btn.getStyle('display') == "inline-block") {
						prev_btn.setStyle('display', 'none');
					}
				}	
			}
			if ((currentPage - 1) < (maxPages - 1)) {
				if(next_btn){
		  			if (next_btn.getStyle('display') == "none") {
		  				next_btn.setStyle('display', 'inline-block');
		  			}
				}	
			}
			currentPage = currentPage - 1;
			retrieve(retrieveURL + "&currentPage=" + currentPage);
		});
	}

	if (next_btn) {
		next_btn.on('click', function(event) {
			event.preventDefault();
			if ((currentPage + 1) >= (maxPages - 1)) {
				if(next_btn){
					if (next_btn.getStyle('display') == "block" || next_btn.getStyle('display') == "inline-block") {
						next_btn.setStyle('display', 'none');
					}
				}	
			}
			if ((currentPage + 1) > 0) {
				if(prev_btn){
		  			if (prev_btn.getStyle('display') == "none") {
		  				prev_btn.setStyle('display', 'inline-block');
		  			}
				}	
			}
			currentPage = currentPage + 1;
			retrieve(retrieveURL + "&currentPage=" + currentPage);
		});
	}

	retrieve(retrieveURL + "&currentPage=" + currentPage);

}catch(err) {
	alert(err);
}
});

</script>