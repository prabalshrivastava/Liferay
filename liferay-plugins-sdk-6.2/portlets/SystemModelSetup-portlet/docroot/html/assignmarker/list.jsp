<%@page import="com.liferay.portal.theme.ThemeDisplay"%>

<%@page import="com.sambaash.platform.constant.SystemSetupConstants"%>
<%@page import="javax.portlet.PortletPreferences"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="javax.portlet.PortletRequest"%>
<%@page import="com.sambaash.platform.util.PermissionUtil"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%><%@
taglib	uri="http://liferay.com/tld/security" prefix="liferay-security"%><%@
taglib	uri="http://liferay.com/tld/theme" prefix="liferay-theme"%><%@
taglib	uri="http://liferay.com/tld/ui" prefix="liferay-ui"%><%@
taglib	uri="http://liferay.com/tld/util" prefix="liferay-util"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<link rel='stylesheet' href='/html/css/sp/formio.full.min.css?minifierType=css'>
<link rel='stylesheet' href='/html/css/hook.css?minifierType=css'>
<liferay-theme:defineObjects />

<%@
taglib	uri="/tld/sp-formio" prefix="sp-formio"%>  
<portlet:defineObjects />
<% if(PermissionUtil.canViewListing( (PortletRequest) request.getAttribute("javax.portlet.request"))){ 
String modelName = portletPreferences.getValue(SystemSetupConstants.PREF_MODEL_NAME, "AssignMarker");
%>
<c:set var="formType" value='<%= modelName %>' />
<script>
var config = {
		createPage: "/html/assignmarker/create.jsp",
	    editPage: "/html/assignmarker/edit.jsp",
	    detailPage: "/html/assignmarker/view.jsp",
	    copyPage: "/html/assignmarker/copy.jsp"
	};
</script>
<style>
	li.masterview{
		display:none !important;
	}
	li.blacklist{
		display:none !important;
	}
	li.confirmed{
		display:none !important;
	}
	li.cancelled{
		display:none !important;
	}
	li.deactivate{
		display:none !important;
	}
	li.activate{
		display:none !important;
	}
	li.recordmanually{
		display:none !important;
	}
	li.print{
		display:none !important;
	}
</style>
<sp-formio:Listing cssClass="formContainer" modelName="${formType}" />
<% } %>	