<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>

<%@ page import="java.util.*" %>

<portlet:defineObjects />

<liferay-theme:defineObjects />

<%
Calendar curValueDate = com.liferay.portal.kernel.util.CalendarFactoryUtil.getCalendar(timeZone, locale);
%>

<div class="spjobs-container">
	<div class="helper-clearfix">
		<div class="spjobs-tab active" id="<portlet:namespace />spjobs_tab_filter"><liferay-ui:message key="${communityName}.label.landing.job.search.tab.filter" /></div>
		<div class="spjobs-tab" id="<portlet:namespace />spjobs_tab_keywords">Search by keywords</div>
	</div>
	<div class="spjobs-tab-content active" id="<portlet:namespace />spjobs_tab_content_filter">
		<ul>
			<li>
				<label for="<portlet:namespace />spjobs_filter_location">Location</label>
				<select class="spjobs-filter-location" id="<portlet:namespace />spjobs_filter_location">
					<option value=""></option>
					<c:forEach items="${jobLocationAssetCategories}" var="jobLocationAssetCategory">
						<option value="${jobLocationAssetCategory.name}">${jobLocationAssetCategory.name}</option>
					</c:forEach>
				</select>
			</li><li>
				<label for="<portlet:namespace />spjobs_filter_category">Categories</label>
				<select class="spjobs-filter-category" id="<portlet:namespace />spjobs_filter_category">
					<option value=""></option>
					<c:forEach items="${categoryAssetCategories}" var="categoryAssetCategory">
						<option value="${categoryAssetCategory.name}">${categoryAssetCategory.name}</option>
					</c:forEach>
				</select>
			</li><li>
				<label for="<portlet:namespace />spjobs_filter_skills">Skills</label>
				<input class="spjobs-filter-skills" id="<portlet:namespace />spjobs_filter_skills" type="text" value="" />
			</li>
		</ul>
		<ul>
			<li class="spJobs_yearsOfExp">
				<label for="<portlet:namespace />spjobs_filter_experience">Years of experience</label>
				<select class="spjobs-filter-experience" id="<portlet:namespace />spjobs_filter_experience">
					<option value=""></option>
					<c:forEach items="${experienceAssetCategories}" var="experienceAssetCategory">
						<option value="${experienceAssetCategory.name}">${experienceAssetCategory.name}</option>
					</c:forEach>
				</select>
			</li>
		</ul>
		<ul>
			<li>
				<label>Period</label>
				
				<div id="startDateContainer" class='dateContainer lfr-input-date' data-date-container>
 							    <input type="text" name="edmStartDate" id="edmStartDate" placeholder="Start Date"/>
 							</div>
 							
				<div  style="padding: 3px 10px 3px 7px;display:inline-block"><b>To</b></div>
				<div id="endDateContainer" class='dateContainer lfr-input-date' data-date-container>
 							    <input type="text" name="edmEndDate" id="edmEndDate" placeholder="End Date"/>
 							</div>
			</li>
		</ul>
		<input class="spjobs-go-btn btn-primary" id="<portlet:namespace />spjobs_filter_go_btn" type="button" value="Go" />
	</div>
	<div class="spjobs-tab-content" id="<portlet:namespace />spjobs_tab_content_keywords">
		<ul>
			<li style="width: 100%;">
				<label for="<portlet:namespace />spjobs_keywords">Type jobs by keywords (for location, job title, skills, related fields and tags)</label>
				<input id="<portlet:namespace />spjobs_keywords" style="width: 100%;" type="text" value="" />
				<p>Separate keywords using a comma, e.g. singapore, actor, dancing, performing arts</p>
			</li>
		</ul>
		<input class="spjobs-go-btn btn-primary" id="<portlet:namespace />spjobs_keywords_go_btn" type="button" value="Go" />
	</div>

	<ul>
		<li class="spjobs-mrm">
			<c:choose>
				<c:when test="<%= themeDisplay.isSignedIn() %>">
					<c:choose>
						<c:when test="${postServiceHasAccess}">
							<a href="/${nameOfCreatePage}?show=newpost" id="postJob" style="font-size: 11px;"><img alt="Post a job" src="/SPJob-portlet/images/addicon.gif" width="13" height="13" style="vertical-align: middle;" /> Post a job</a>
						</c:when>
						<c:otherwise>
							<a class="spjobs-service-access" style="font-size: 11px;" name="${postServiceUserStatus}"
							title="Permission Denied" id="postJob"><img alt="Post a job" src="/SPJob-portlet/images/addicon.gif" width="13" height="13" style="vertical-align: middle;" /> Post a job</a>
						</c:otherwise>
					</c:choose>
				</c:when>
				<c:otherwise>
					<a class="spjobs-service-access" style="font-size: 11px;" name="${postServiceUserStatus}"
							title="Login to post" id="postJob"><img alt="Post a job" src="/SPJob-portlet/images/addicon.gif" width="13" height="13" style="vertical-align: middle;" /> Post a job</a>
				</c:otherwise>
			</c:choose>
		</li>
		<li><a href="javascript:;" id="<portlet:namespace />spjobs_show_all" style="font-size: 11px;" class="sp-show-all-jobs"><img alt="Show all jobs" src="/SPJob-portlet/images/refresh.gif" width="13" height="13" style="vertical-align: middle;" /> Show all jobs</a></li>
	</ul>

	<ul class="spjobs-stream-container" id="<portlet:namespace />spjobs_stream_container"></ul>

	<a class="spjobs-stream-loadmore" href="#" id="<portlet:namespace />spjobs_stream_loadmore" style="display: none;" title="Next">Load More</a>

</div>

<portlet:resourceURL var="retrieveURL">
	<portlet:param name="action" value="retrieve"></portlet:param>
</portlet:resourceURL>

<aui:script>

AUI().use('aui-base', function(A) {

	var documentBody = A.one('document.body')
	if (documentBody) {
		documentBody.delegate(
			'click',
			function(event) {
				var name = this.get('name');
				var title = this.get('title');
				var popup = Liferay.Util.openWindow(
{
dialog: {
						bodyContent: name,
						centered: true,
						destroyOnClose: true,
						modal: true,
						headerContent: title,
						height: 160,
						width: 515
					}}
				);
			},
			'.spjobs-service-access'
		);
	}

});
</aui:script>

<script type="text/javascript">

	var <portlet:namespace />retrieveURL = '<%= retrieveURL.toString() %>';
	var <portlet:namespace />count = 0;
	var <portlet:namespace />currentPage = 0;
	var <portlet:namespace />delta = '${numberOfItemsPerPage}';
	var <portlet:namespace />maxPages = 0;

	var <portlet:namespace />xhr;

	var <portlet:namespace />tab_index = 0;
	var <portlet:namespace />all = true;

	var <portlet:namespace />load_more = document.getElementById("<portlet:namespace />spjobs_stream_loadmore");

	var <portlet:namespace />filter_go_btn = document.getElementById("<portlet:namespace />spjobs_filter_go_btn");
	var <portlet:namespace />keywords_go_btn = document.getElementById("<portlet:namespace />spjobs_keywords_go_btn");

	var <portlet:namespace />spjobs_tab_filter = document.getElementById("<portlet:namespace />spjobs_tab_filter");
	var <portlet:namespace />spjobs_tab_keywords = document.getElementById("<portlet:namespace />spjobs_tab_keywords");

	var <portlet:namespace />spjobs_tab_content_filter = document.getElementById("<portlet:namespace />spjobs_tab_content_filter");
	var <portlet:namespace />spjobs_tab_content_keywords = document.getElementById("<portlet:namespace />spjobs_tab_content_keywords");

	var <portlet:namespace />spjobs_show_all = document.getElementById("<portlet:namespace />spjobs_show_all");

	addEventHandler(<portlet:namespace />load_more, "click", <portlet:namespace />loadMoreOnClick);
	addEventHandler(<portlet:namespace />filter_go_btn, "click", <portlet:namespace />filterGoBtnOnClick);
	addEventHandler(<portlet:namespace />keywords_go_btn, "click", <portlet:namespace />keywordsGoBtnOnClick);

	addEventHandler(<portlet:namespace />spjobs_tab_filter, "click", <portlet:namespace />tabFilterOnClick);
	addEventHandler(<portlet:namespace />spjobs_tab_keywords, "click", <portlet:namespace />tabKeywordsOnClick);

	addEventHandler(<portlet:namespace />spjobs_show_all, "click", <portlet:namespace />showAllOnClick);

	function <portlet:namespace />showAllOnClick(e) {
	try{
		preventDefault(e);
		var stream_container = document.getElementById("<portlet:namespace />spjobs_stream_container");
		stream_container.innerHTML = "";
		<portlet:namespace />retrieve(<portlet:namespace />retrieveURL + "&tabIndex=0&currentPage=0&all=true");
	}catch(err) {
		// alert(" -showAllOnClick: " + err);
	}
	}

	function <portlet:namespace />tabFilterOnClick(e) {
	try{
		preventDefault(e);
		<portlet:namespace />tab_index = 0;
		addClass(<portlet:namespace />spjobs_tab_filter, "active");
		addClass(<portlet:namespace />spjobs_tab_content_filter, "active");
		removeClass(<portlet:namespace />spjobs_tab_keywords, "active");
		removeClass(<portlet:namespace />spjobs_tab_content_keywords, "active");
	}catch(err) {
		// alert(" -tabFilterOnClick: " + err);
	}
	}

	function <portlet:namespace />tabKeywordsOnClick(e) {
	try{
		preventDefault(e);
		<portlet:namespace />tab_index = 1;
		addClass(<portlet:namespace />spjobs_tab_keywords, "active");
		addClass(<portlet:namespace />spjobs_tab_content_keywords, "active");
		removeClass(<portlet:namespace />spjobs_tab_filter, "active");
		removeClass(<portlet:namespace />spjobs_tab_content_filter, "active");
	}catch(err) {
		// alert(" -tabKeywordsOnClick: " + err);
	}
	}

	function <portlet:namespace />loadMoreOnClick(e) {
	try{
		preventDefault(e);
		if ((<portlet:namespace />currentPage + 1) >= (<portlet:namespace />maxPages - 1)) {
			if (<portlet:namespace />load_more.style.display == "block") {
				<portlet:namespace />load_more.style.display = "none";
			}
		}
		if ((<portlet:namespace />currentPage + 1) > 0) {
			if (<portlet:namespace />load_more.style.display == "none") {
				<portlet:namespace />load_more.style.display = "block";
			}
		}
		<portlet:namespace />currentPage = <portlet:namespace />currentPage + 1;

		if (<portlet:namespace />tab_index == 0) {
			<portlet:namespace />retrieve(<portlet:namespace />getFilterRetrieveUrl(<portlet:namespace />currentPage));
		}else if (<portlet:namespace />tab_index == 1) {
			<portlet:namespace />retrieve(<portlet:namespace />getKeywordsRetrieveUrl(<portlet:namespace />currentPage));
		}
		jobListResize();
	}catch(err) {
		// alert(" -loadMoreOnClick: " + err);
	}
	}

	function <portlet:namespace />getFilterRetrieveUrl(curPage) {
	//try{
	    var locationSelectBox = document.getElementById("<portlet:namespace />spjobs_filter_location");
	    var selectedLocation = locationSelectBox.options[locationSelectBox.selectedIndex].value;
	    var categorySelectBox = document.getElementById("<portlet:namespace />spjobs_filter_category");
	    var selectedCategory = categorySelectBox.options[categorySelectBox.selectedIndex].value;
	    var skillsInput = document.getElementById("<portlet:namespace />spjobs_filter_skills");
	    var selectedSkills = skillsInput.value;
	    var experienceSelectBox = document.getElementById("<portlet:namespace />spjobs_filter_experience");
	    var selectedExperience = experienceSelectBox.options[experienceSelectBox.selectedIndex].value;
	    var edmStartDate = document.getElementById("edmStartDate").value;
	    var edmEndDate = document.getElementById("edmEndDate").value;
	    var tempRetrieveURL = <portlet:namespace />retrieveURL + "&tabIndex=" + <portlet:namespace />tab_index + "&currentPage=" + curPage + "&all=" + <portlet:namespace />all +
	    						"&selectedLocation=" + selectedLocation +
	    						"&selectedCategory=" + selectedCategory +
	    						"&selectedSkills=" + selectedSkills +
	    						"&selectedExperience=" + selectedExperience +
	    						"&edmStartDate=" + edmStartDate +
	    						"&edmEndDate=" + edmEndDate;

		return tempRetrieveURL;
	//}catch(err) {
		// alert(" -getFilterRetrieveUrl: " + err);
	//}
	}

	function <portlet:namespace />getKeywordsRetrieveUrl(curPage) {
	try{
	    var tempRetrieveURL = <portlet:namespace />retrieveURL + "&tabIndex=" + <portlet:namespace />tab_index + "&currentPage=" + curPage + "&all=" + <portlet:namespace />all;
		return tempRetrieveURL;
	}catch(err) {
		// alert(" -getKeywordsRetrieveUrl: " + err);
	}
	}

	function <portlet:namespace />filterGoBtnOnClick(e) {
	try{
		preventDefault(e);
		<portlet:namespace />all = false;

		var stream_container = document.getElementById("<portlet:namespace />spjobs_stream_container");
		stream_container.innerHTML = ""; 

	    <portlet:namespace />retrieve(<portlet:namespace />getFilterRetrieveUrl(0));
	    jobListResize();
	}catch(err) {
		// alert(" -filterGoBtnOnClick: " + err);
	}
	}

	function <portlet:namespace />keywordsGoBtnOnClick(e) {
	//try{
		preventDefault(e);
		<portlet:namespace />all = false;

	    var keywordsInput = document.getElementById("<portlet:namespace />spjobs_keywords");
	    var selectedKeywords = keywordsInput.value;

		var stream_container = document.getElementById("<portlet:namespace />spjobs_stream_container");
		stream_container.innerHTML = "";
	    <portlet:namespace />retrieve(<portlet:namespace />getKeywordsRetrieveUrl(0) + "&selectedKeywords=" + selectedKeywords);
	    jobListResize();
	//}catch(err) {
		// alert(" -keywordsGoBtnOnClick: " + err);
	//}
	}

	function <portlet:namespace />retrieve(url) {
	try{
		<portlet:namespace />AjaxGet(url, <portlet:namespace />retrieveSuccess, <portlet:namespace />processError);
	}catch(err) {
		// alert(" -retrieve: " + err);
	}
	}

	function <portlet:namespace />deleteJob(url) {
	try{
		if (confirm("Are you sure you want to delete this?")) {
			<portlet:namespace />AjaxGet(url, <portlet:namespace />deleteSuccess, <portlet:namespace />processError);
		}
	}catch(err) {
		// alert(" -deleteJob: " + err);
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
		// alert(" -AjaxGet: " + err);
	}
	}

	function <portlet:namespace />deleteSuccess() {
	try{
		var data = JSON.parse(<portlet:namespace />xhr.responseText);
		var job_id = data.id;

		var stream_container = document.getElementById("<portlet:namespace />spjobs_stream_container");
		var job_entry = getFirstElementsByAttribute(stream_container, "li", "data-job-entry-id", job_id);
		job_entry.parentNode.removeChild(job_entry);
	}catch(err) {
		// alert(" -deleteSuccess: " + err);
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
		var stream_container = document.getElementById("<portlet:namespace />spjobs_stream_container");
		var items = data.items;
		if (items.length == 0) {
			stream_container.innerHTML = "No records available for viewing.";
		}else {
			for (var i = 0; i < items.length; i++) {
				stream_container.innerHTML += items[i].html;
			}
		}

		if (!(<portlet:namespace />currentPage >= (<portlet:namespace />maxPages - 1)) && <portlet:namespace />maxPages > 0) {
			if (<portlet:namespace />load_more.style.display == "none") {
				<portlet:namespace />load_more.style.display = "block";
			}
		}else {
			if (<portlet:namespace />load_more.style.display == "block") {
				<portlet:namespace />load_more.style.display = "none";
			}
		}
	}catch(err) {
		// alert(" -retrieveSuccess: " + err);
	}
	}

	function <portlet:namespace />processError() {
		// alert("Oops! An unexpected error occurred while processing your request.");
	}

	<portlet:namespace />retrieve(<portlet:namespace />retrieveURL + "&tabIndex=" + <portlet:namespace />tab_index + "&currentPage=0&all=" + <portlet:namespace />all);

	function jobListResize() {
		var windowWidth = document.documentElement.clientWidth;
		var jobElement = document.getElementsByName("spjobs-list");
		if (windowWidth < 485) {
			document.getElementById("postJob").style.display="none";
			var applyLink = document.getElementsByName("applyJob");
			for (i=0;i<jobElement.length;i++) {
			jobElement[i].style.width = 280 + "px";
			applyLink[i].style.display="none";
			}
		}
		if (windowWidth < 760 && windowWidth > 485) {
			for (i=0;i<jobElement.length;i++) {
				jobElement[i].style.width = 232 + "px";
				}
		}
		if (windowWidth < 1024 && windowWidth > 760) {
			for (i=0;i<jobElement.length;i++) {
				jobElement[i].style.width = 254 + "px";
				}
		}
	}

	AUI().ready(function(A) {
		jobListResize();
	});
</script>


<aui:script>

	AUI().use('aui-base', function(A) {

		var documentBody = A.one('document.body')
		if (documentBody) {
			documentBody.delegate(
				'click',
				function(event) {
					var name = this.get('name');
					var title = this.get('title');
					var popup = Liferay.Util.Window.getWindow(
{
dialog: {
							bodyContent: name,
							centered: true,
							destroyOnClose: true,
							modal: true,
							title: title,
							height: 160,
							width: 515
						}}
					).render();
				},
				'.spjobs-owner-cannot-apply'
			);
		}

	});
	
AUI().use(
		  'aui-datepicker',
		  function(A) {	
		new A.DatePicker(
				{
					container: '#startDateContainer',
					mask: '%m/%d/%Y',
					popover: {
						zIndex: Liferay.zIndex.TOOLTIP
					},
					trigger: '#edmStartDate',
					on: {
				          selectionChange: function(event) {
				        	  document.getElementById("edmStartDate").value= event.newSelection;
				            console.log("date ",event.newSelection)
				          }
					}
				}
			);
		}
	);	  
	
AUI().use(
		  'aui-datepicker',
		  function(A) {	
		new A.DatePicker(
				{
					container: '#endDateContainer',
					mask: '%m/%d/%Y',
					popover: {
						zIndex: Liferay.zIndex.TOOLTIP
					},
					trigger: '#edmEndDate',
					on: {
				          selectionChange: function(event) {
				        	  document.getElementById("edmEndDate").value= event.newSelection;
				            console.log("date ",event.newSelection)
				          }
					}
				}
			);
		}
	);	  

</aui:script>
