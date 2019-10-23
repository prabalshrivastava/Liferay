<%@page import="javax.portlet.PortletRequest"%>
<%@page import="com.sambaash.platform.util.PermissionUtil"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%><%@
taglib	uri="http://liferay.com/tld/security" prefix="liferay-security"%><%@
taglib	uri="http://liferay.com/tld/theme" prefix="liferay-theme"%><%@
taglib	uri="http://liferay.com/tld/ui" prefix="liferay-ui"%><%@
taglib	uri="http://liferay.com/tld/util" prefix="liferay-util"%>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/holiday.js?<%=System.currentTimeMillis()%>" language="javascript1.2""></script>
<link rel='stylesheet' href='/html/css/sp/formio.full.min.css?minifierType=css'>
<link rel='stylesheet' href='/html/css/hook.css?minifierType=css'>
<%@
taglib	uri="/tld/sp-formio" prefix="sp-formio"%> 
<portlet:defineObjects />

<% if(PermissionUtil.canViewListing( (PortletRequest) request.getAttribute("javax.portlet.request"))){ %>

<script>

var config = {
		createPage: "/html/holidaycalendar/create.jsp",
	    editPage: "/html/holidaycalendar/edit.jsp",
	    detailPage: "/html/holidaycalendar/view.jsp",
	    copyPage: "/html/holidaycalendar/copy.jsp"
	};
var namespace =  "<portlet:namespace/>";
var ajaxUrl = "${resourceURL}";
var mode = "create";
</script>

<sp-formio:Listing cssClass="formContainer" modelName="HolidayCalendar" />

<% } %>
