<%@page import="com.sambaash.platform.constant.SambaashConstants"%>
<%@page import="com.sambaash.platform.util.SambaashUtil"%>
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
<script type="text/javascript" src="/SystemModelSetup-portlet/js/main.js" ></script>

<link rel='stylesheet' href='/html/css/sp/formio.full.min.css?minifierType=css'>
<script type="text/javascript" src="/html/js/sp/hook.js?<%=System.currentTimeMillis()%>" language="javascript1.2""></script>
<%@ taglib	uri="/tld/sp-formio" prefix="sp-formio"%> 
<portlet:defineObjects />
 <%
String baseUrl = portletPreferences.getValue("baseUrlPref", "");
String vocabularyURL = SambaashUtil.getParameter(SambaashConstants.API_VOCABULARY_URL, 21424);

%>

<% if(PermissionUtil.canAddModel((PortletRequest) request.getAttribute("javax.portlet.request"))){ %>
<%
String formId = portletPreferences.getValue(SystemSetupConstants.PREF_HTML_FORM_ID, "1750");
String dashBoardLink = SambaashUtil.getDashBoard();
%>

<div class="newPortlets">
<div class="subHeader">
	<div class="container">
		<div class="inner-container">
			<aui:row>
				<aui:col span="10" cssClass="text-center"><h2><span>SESSION TYPE SETUP</span></h2></aui:col>
				<aui:col span="2" cssClass="text-right"><aui:a href="<%= dashBoardLink %>" title="Back to Home">Back to Home</aui:a></aui:col>
			</aui:row>
		</div>
	</div>
</div>
<c:set var="formId" value="<%= formId %>"/>
<c:set var="formStorageId" value='<%= request.getParameter("storageId") %>' />
<c:set var="formType" value='<%= request.getParameter("formTypeName") %>' />
<div class="formRoot">
	<div class="innerFormRoot">
		<sp-formio:FormIO cssClass="formContainer"  modelName ="${formType}" formId="${formId}" readOnly="false" formStorageId="${formStorageId}" />
	</div>
</div>
</div>

<script type="text/javascript">
var mode = "edit";
function afterFormLoadedFormIOForm(thisInstance){
	thisInstance.components["SessionTypeName"].disabled = true;
	thisInstance.components.Submit.buttonElement.textContent = "Update";
}
function validateFormIOForm(thisInstance){
	
	var formdata = thisInstance.form.submission.data;
	if(isNotNull(formdata.SessionTypeName)){
		thisInstance.customSubmission(thisInstance.form.submission);
	}
	else{
		thisInstance.form.setAlert("","Please Select Session Type Name");
	}
}
</script>
<% } %>