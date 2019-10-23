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
<link rel='stylesheet' type="text/css"
	href='<%=request.getContextPath()%>/css/cashiercounter.css?minifierType=css'></link>
<liferay-theme:defineObjects />

<%@
taglib	uri="/tld/sp-formio" prefix="sp-formio"%>  
<portlet:defineObjects />
<% if(PermissionUtil.canViewListing( (PortletRequest) request.getAttribute("javax.portlet.request"))){ 
String modelName = portletPreferences.getValue(SystemSetupConstants.PREF_MODEL_NAME, SystemSetupConstants.DEFAULTMODELAME);
%>
<c:set var="formType" value='<%= modelName %>' />
<script>
var config = {
		createPage: "/html/cashiercounter/create.jsp",
	    editPage: "/html/cashiercounter/edit.jsp",
	    detailPage: "/html/cashiercounter/view.jsp"
	};
function init() {
	document.getElementById("addnew").innerHTML = "OPEN/CLOSE";
	document.getElementById("more-popover").style.display = "none";
	var all = document.getElementById("threedot").getElementsByClassName("listingPopover");
	for (var i=0; i < all.length; i++) {
		all[i].innerHTML = "";
	}
}
if(document.readyState == 'complete') {
	init();
} else {
	window.addEventListener('load', init);
}

</script>
<sp-formio:Listing cssClass="formContainer" modelName="${formType}" />
<% } %>	