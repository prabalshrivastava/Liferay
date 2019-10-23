<%@page import="com.liferay.portal.kernel.json.JSONArray"%>
<%@page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.json.JSONObject"%>
<%@page import="com.sambaash.platform.util.SambaashUtil"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portlet.PortletURLFactoryUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@page import="javax.portlet.PortletRequest"%>
<%@page import="com.sambaash.platform.util.PermissionUtil"%>
<%@page import="com.sambaash.platform.constant.SystemSetupConstants"%>
<%@page import="com.liferay.portal.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%><%@
taglib	uri="http://liferay.com/tld/security" prefix="liferay-security"%><%@
taglib	uri="http://liferay.com/tld/theme" prefix="liferay-theme"%><%@
taglib	uri="http://liferay.com/tld/ui" prefix="liferay-ui"%><%@
taglib	uri="http://liferay.com/tld/util" prefix="liferay-util"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<link rel='stylesheet' href='/html/css/hook.css?minifierType=css'>

<portlet:defineObjects />
<portlet:renderURL var="facilityListing">
	<portlet:param name="jspPage"
		value="/html/facility/list.jsp" />
</portlet:renderURL>

<portlet:renderURL var="addFacility">
	<portlet:param name="jspPage"
		value="/html/facility/create.jsp" />
</portlet:renderURL>


<% String baseUrl = portletPreferences.getValue("baseUrlPref", "");
%>

<div class="newPortlets">

<div class="subHeader">
	<div class="container">
		<div class="inner-container">
			<aui:row>
				<aui:col span="10" cssClass="text-center"><h2>Facility Setup Success</h2></aui:col>
				<aui:col span="2" cssClass="text-right"><a href="https://ems.sambaash.com" title="Back to Home">Back to Home</a></aui:col>
			</aui:row>
		</div>
	</div>
</div>

<div class="sambaashContent">
	<div class="container formContainer formio-form progSetupSucc">
		<aui:row>
			<aui:col span="12" cssClass="text-center" style="margin-bottom:45px;">
				<h3>Facility created successfully!</h3>
				<p>What would you like to do next?</p>
			</aui:col>
		</aui:row>
		<aui:row>
			
			<aui:col span="12" cssClass="text-center">
				<div class="progSetup" style="margin:auto !important">
					<h4>FACILITY</h4>
					<a href="<%= addFacility.toString() %>" title="Add a new Facility">Add a new Facility</a>
				</div>
			</aui:col>
		</aui:row>
		<aui:row>
			<aui:col span="12" cssClass="text-center">
				OR
			</aui:col>
		</aui:row>
		<aui:row>
			<aui:col span="12" cssClass="text-center">
				
				<a href="<%= facilityListing.toString() %>" class="btn btn-default" style="width:200px;" title="">FACILITY LISTING</a>
			</aui:col>
		</aui:row>
	</div>
</div>
</div>