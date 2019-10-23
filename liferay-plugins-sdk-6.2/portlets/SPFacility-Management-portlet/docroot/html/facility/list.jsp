<%@page import="com.sambaash.platform.constant.SystemSetupConstants"%>
<%@page import="javax.portlet.PortletRequest"%>
<%@page import="com.sambaash.platform.util.PermissionUtil"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%><%@
taglib	uri="http://liferay.com/tld/security" prefix="liferay-security"%><%@
taglib	uri="http://liferay.com/tld/theme" prefix="liferay-theme"%><%@
taglib	uri="http://liferay.com/tld/ui" prefix="liferay-ui"%><%@
taglib	uri="http://liferay.com/tld/util" prefix="liferay-util"%>
<link rel='stylesheet' href='/html/css/sp/formio.full.min.css?minifierType=css'>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%@
taglib	uri="/tld/sp-formio" prefix="sp-formio"%> 
<portlet:defineObjects /> 

<% if(PermissionUtil.canViewListing ( (PortletRequest) request.getAttribute("javax.portlet.request"))){ %>

<%
Boolean canAddModel = PermissionUtil.canAddModel((PortletRequest) request.getAttribute("javax.portlet.request"));
Boolean canEditModel = PermissionUtil.canEditModel((PortletRequest) request.getAttribute("javax.portlet.request"));
Boolean canActivateModel = PermissionUtil.canActivateModel((PortletRequest) request.getAttribute("javax.portlet.request"));
Boolean canDeleteModel = PermissionUtil.canDeleteModel((PortletRequest) request.getAttribute("javax.portlet.request"));
Boolean canCopyModel = PermissionUtil.canCopyModel((PortletRequest) request.getAttribute("javax.portlet.request"));

String modelName = portletPreferences.getValue(SystemSetupConstants.PREF_MODEL_NAME, SystemSetupConstants.DEFAULTMODELAME);

%>
<c:set var="formType" value='<%= modelName %>' />
<script>

var config = {
		createPage: "/html/facility/create.jsp",
	    editPage: "/html/facility/edit.jsp",
	    detailPage: "/html/facility/view.jsp",
	    copyPage: "/html/facility/copy.jsp"
	};
var namespace =  "<portlet:namespace/>";
var ajaxUrl = "${resourceURL}";
var mode = "create";
</script>

<sp-formio:Listing cssClass="formContainer" modelName="${formType}" />

<% } %>
