<%@page import="com.sambaash.platform.util.SambaashUtil"%>
<%@page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.json.JSONObject"%>
<%@page import="javax.portlet.PortletRequest"%>
<%@page import="com.sambaash.platform.util.PermissionUtil"%>
<%@page import="com.sambaash.platform.constant.SystemSetupConstants"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%><%@
taglib	uri="http://liferay.com/tld/security" prefix="liferay-security"%><%@
taglib	uri="http://liferay.com/tld/theme" prefix="liferay-theme"%><%@
taglib	uri="http://liferay.com/tld/ui" prefix="liferay-ui"%><%@
taglib	uri="http://liferay.com/tld/util" prefix="liferay-util"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<link rel='stylesheet' href='/html/css/sp/formio.full.min.css?minifierType=css'>
<link rel='stylesheet' href='/SystemModelSetup-portlet/css/main.css'>
<%@ taglib	uri="/tld/sp-formio" prefix="sp-formio"%> 
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<portlet:defineObjects />

 
<portlet:renderURL var="programmeListing">
	<portlet:param name="jspPage"
		value="/html/programme/list.jsp" />
</portlet:renderURL>


<% if(PermissionUtil.canViewModel((PortletRequest) request.getAttribute("javax.portlet.request"))){ %>
<%
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

String formId = stringArray[0];
String baseUrl = portletPreferences.getValue("baseUrlPref", "");
String dashBoardLink = SambaashUtil.getDashBoard();
%>
<c:set var="formId" value="<%= formId %>"/>
<c:set var="formStorageId" value='<%= request.getParameter("storageId") %>' />
<c:set var="formType" value='<%= request.getParameter("formTypeName") %>' />
<div class="newPortlets">
<div class="subHeader">
	<div class="container">
	<div class="inner-container">
		<aui:row>
			<aui:col span="10" cssClass="text-center"><h2><span><%= modelName.toUpperCase() %> SETUP</span></h2></aui:col>
			<aui:col span="2" cssClass="text-right"><a href="<%= dashBoardLink %>" title="Back to Home">Back to Home</a></aui:col>
		</aui:row>
	</div></div>
</div>
	<div class="formRoot">
		<div class="innerFormRoot">
			<sp-formio:FormIO cssClass="formContainer" modelName ="${formType}" formId="${formId}" readOnly="true" formStorageId="${formStorageId}"  />
		</div>
	</div>
</div>
<script type="text/javascript">
var mode = "view";
function afterFormLoadedFormIOForm(thisInstance){
	//setTimeout(function(){ document.getElementsByClassName("actionDiv")[0].innerHTML = ""; }, 1000);
	
}
</script>
<% } %>