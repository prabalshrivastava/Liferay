<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page import="java.util.*" %>

<portlet:defineObjects />

<liferay-theme:defineObjects />

<%
String imgPath = themeDisplay.getPathThemeImages();
%>

<div class="showdowheader">
	<span>
		<font class="header-pretitle">Jobs</font>
		<font class="header-posttitle"> by location</font>
	</span>
</div>
<c:forEach items="${locationJobsMap}" var="entry">
	<div class="job-by-location" data-dom-id="spjobs-location">
		<c:out value="${entry.key}" />
		<img alt="Down Arrow" class="spjobs-arrow" src="<%= themeDisplay.getPathThemeImages() %>/arrows/downarrow1.png">
	</div>
	<div class="job-by-location-list" style="margin-left: 20px; display: none;">
		<c:forEach items="${entry.value}" var="job">
			<p><a href="/${nameOfDetailPage}?id=${job.jobId}"><c:out value="${job.title}"></c:out></a></p>
		</c:forEach>
	</div>
</c:forEach>

<script type="text/javascript">

var locations = getElementsByAttribute(document, "div", "data-dom-id", "spjobs-location");

for (var i=0; i<locations.length; i++) {
	addEventHandler(locations[i], "click", locationOnclick);
}

function locationOnclick(e) {
	var target = getEventTarget(e);
	if (target == "[object HTMLImageElement]") {
	target = target.parentNode;
}
	var jobs = getNextSibling(target);
	var jobsArrow = getFirstChild(target);

	if (jobs) {
		if (jobs.style.display == "none") {
			for (var i=0; i<locations.length; i++) {
				var location = locations[i];
				if (location != target) {
					if (getNextSibling(location)) {
						getNextSibling(location).style.display = "none";
						getFirstChild(location).setAttribute("src","<%= themeDisplay.getPathThemeImages() %>/arrows/downarrow1.png");
					}
				}
			}
			jobs.style.display = "block";
			jobsArrow.setAttribute("src","<%= themeDisplay.getPathThemeImages() %>/arrows/uparrow.png");
		}else if (jobs.style.display == "block") {
			jobs.style.display = "none";
			jobsArrow.setAttribute("src","<%= themeDisplay.getPathThemeImages() %>/arrows/downarrow1.png");
		}
	}
}

</script>
