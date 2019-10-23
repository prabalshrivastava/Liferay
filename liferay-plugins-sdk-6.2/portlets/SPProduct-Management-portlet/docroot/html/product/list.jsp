<%@page import="com.liferay.portal.kernel.json.JSONObject"%>
<%@page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>
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


<%@
taglib	uri="/tld/sp-formio" prefix="sp-formio"%>  
<portlet:defineObjects />

<% if(PermissionUtil.canViewListing( (PortletRequest) request.getAttribute("javax.portlet.request"))){ 

	
	
String preference = renderRequest.getPreferences().getValue("preference","");
JSONObject prefData = JSONFactoryUtil.createJSONObject(preference);
String mixedModelName = prefData.getString("model1",""); 
String 	modelName = "";

String[] stringArray = mixedModelName.split(",");
if(stringArray.length > 1 &&  stringArray[1].split("-").length > 0){
	modelName = stringArray[1].split("-")[0];
}

if(request.getParameter("formTypeName") != "" && request.getParameter("formTypeName") != null){
	modelName = request.getParameter("formTypeName");
}

%>
<c:set var="formType" value='<%= modelName %>' />

<script>
var config = {
		createPage: "/html/product/create.jsp",
	    editPage: "/html/product/edit.jsp",
	    detailPage: "/html/product/view.jsp",
	    copyPage: "/html/product/copy.jsp",
	    masterViewPage:"/html/product/masterview.jsp",
	};
//alert();
</script>

<sp-formio:Listing cssClass="formContainer" modelName="${formType}" />

<% } %>	