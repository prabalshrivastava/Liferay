<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page import="java.util.*" %>

<portlet:defineObjects />

<liferay-theme:defineObjects />

<style type="text/css">
	a.selected {
		font-weight: bold;
	}
</style>

<%
String filterType = (String) renderRequest.getParameter("filterType");
if (com.liferay.portal.kernel.util.Validator.isNull(filterType)) {
	filterType = "community";
}
%>
<section class="sp-feeds">
	<div class="sp-feeds-content sp-feeds-filter">
		<div class="sp-feeds-section-title">
			Feed Preference
		</div>
		<ul class="sp-feeds-activity-filter">
			<li>
				<a href="<portlet:actionURL name="pitchFilter"><portlet:param name="filterType" value="community"></portlet:param></portlet:actionURL>" <c:if test='<%= "community".equalsIgnoreCase(filterType) %>'>class="selected"</c:if>>News Feed From Community</a>
			</li>
			<li>
				<a href="<portlet:actionURL name="pitchFilter"><portlet:param name="filterType" value="following"></portlet:param></portlet:actionURL>" <c:if test='<%= "following".equalsIgnoreCase(filterType) %>'>class="selected"</c:if>>News Feed From Following</a>
			</li>
			<li>
				<a href="<portlet:actionURL name="pitchFilter"><portlet:param name="filterType" value="groups"></portlet:param></portlet:actionURL>" <c:if test='<%= "groups".equalsIgnoreCase(filterType) %>'>class="selected"</c:if>>News Feed From Groups</a>
			</li>
		</ul>
	</div>
</section>