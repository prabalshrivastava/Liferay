<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%@ page import="com.liferay.portal.kernel.util.Constants"%>

<portlet:defineObjects />
<liferay-theme:defineObjects />

<portlet:actionURL var="editActionURL">
	<portlet:param name="action" value="<%=Constants.EDIT  %>"></portlet:param>
</portlet:actionURL>

<div>
	<div class="callOut-maindiv" style="margin-bottom:20px">
		<div class="callOut-title">
			Please set the Image & URLs based on user status
			<div class="seperatedline"></div>
		</div>
		<form method="post" action="<%=editActionURL %>"  name="categoriesMappingForm">

			<div class="calloutDiv">
				<ul>
					<li class="as-stream-edit-row">
						<span class="as-stream-edit-col1">Image for User</span>
						<input type="text" name="<portlet:namespace />userImage" value="${userImage}" size="5" />
					</li>
					<li class="as-stream-edit-row">
						<span class="as-stream-edit-col1">CallOut URL for User</span>
						<input type="text" name="<portlet:namespace />userCalloutUrl" value="${userCalloutUrl}" size="5" />
					</li>
				</ul>
				<ul>	
					<li class="as-stream-edit-row">
						<span class="as-stream-edit-col1">Image for Startup</span>
						<input type="text" name="<portlet:namespace />startUpImage" value="${startUpImage}" size="5" />
					</li>
					<li class="as-stream-edit-row">
						<span class="as-stream-edit-col1">CallOut URL for Startup</span>
						<input type="text" name="<portlet:namespace />startupCalloutUrl" value="${startupCalloutUrl}" size="5" />
					</li>
				</ul>
				<ul>	
					<li class="as-stream-edit-row">
						<span class="as-stream-edit-col1">Image for Marketer</span>
						<input type="text" name="<portlet:namespace />marketerImage" value="${marketerImage}" size="5" />
					</li>
					<li class="as-stream-edit-row">
						<span class="as-stream-edit-col1">CallOut URL for Marketer</span>
						<input type="text" name="<portlet:namespace />marketerCalloutUrl" value="${marketerCalloutUrl}" size="5" />
					</li>
				</ul>
				<ul>	
					<li class="as-stream-edit-row">
						<span class="as-stream-edit-col1">Image for Mentor</span>
						<input type="text" name="<portlet:namespace />mentorImage" value="${mentorImage}" size="5" />
					</li>
					<li class="as-stream-edit-row">
						<span class="as-stream-edit-col1">CallOut URL for Mentor</span>
						<input type="text" name="<portlet:namespace />mentorCalloutUrl" value="${mentorCalloutUrl}" size="5" />
					</li>
				</ul>
			</div>
			<input type="submit" value="Save" />
		</form>
	</div>
	
	
	
