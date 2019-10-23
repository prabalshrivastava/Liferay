<%@page import="com.sambaash.platform.util.SambaashUtil"%>
<%@page import="com.liferay.portal.kernel.json.JSONObject"%>
<%@page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>
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
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<link rel='stylesheet' href='/html/css/sp/formio.full.min.css?minifierType=css'>
<link rel='stylesheet' href='/html/css/hook.css?minifierType=css'>
<script type="text/javascript" src="/html/js/sp/hook.js?<%=System.currentTimeMillis()%>" language="javascript1.2""></script>
<%@ taglib	uri="/tld/sp-formio" prefix="sp-formio"%>  
<portlet:defineObjects />


<% if(PermissionUtil.canEditModel((PortletRequest) request.getAttribute("javax.portlet.request"))){ %>
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
<style>
	.aui .newPortlets .form-group {
	 	margin-bottom: 15px;
	}
</style>
<div class="newPortlets">
<div class="subHeader">
	<div class="container">
	<div class="inner-container">
		<aui:row>
			<aui:col span="10" cssClass="text-center"><h2><span><%= modelName.toUpperCase() %> SETUP</span></h2></aui:col>
			<aui:col span="2" cssClass="text-right"><a href="<%= dashBoardLink %>" title="Back to Home">Back to Home</a></aui:col>
		</aui:row>
		</div>
	</div>
</div>
<c:set var="formId" value="<%= formId %>"/>
<c:set var="formStorageId" value='<%= request.getParameter("storageId") %>' />
<c:set var="formType" value='<%= request.getParameter("formTypeName") %>' />
	<div class="formRoot">
		<div class="innerFormRoot">
			<sp-formio:FormIO cssClass="formContainer" modelName ="${formType}" formId="${formId}" readOnly="false" formStorageId="${formStorageId}"  />
		</div>
	</div>
</div>
<script type="text/javascript">
var mode = "edit";
var formType = "<%= request.getParameter("formTypeName") %>";

function afterFormLoadedFormIOForm(thisInstance){
	
	if(formType == "Programme"){
		thisInstance.components.ProgrammeCode.disabled = true;
	}
	else if(formType == "Subject"){
		thisInstance.components.SubjectCode.disabled = true;
	}
	
}
function validateFormIOForm(thisInstance){
	thisInstance.customSubmission(thisInstance.form.submission);
}
</script>
<% } %>