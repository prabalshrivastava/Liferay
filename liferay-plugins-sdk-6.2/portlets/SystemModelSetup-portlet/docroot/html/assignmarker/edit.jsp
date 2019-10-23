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
<link rel='stylesheet' href='/html/css/sp/formio.full.min.css?minifierType=css'>
<link rel='stylesheet' href='/html/css/hook.css?minifierType=css'>
<link rel='stylesheet' type="text/css"
	href='<%=request.getContextPath()%>/css/main.css?minifierType=css'></link>
<link rel='stylesheet' type="text/css" href='<%=request.getContextPath()%>/css/portlet.css?minifierType=css'></link>
<script type="text/javascript" src="/html/js/sp/hook.js?<%=System.currentTimeMillis()%>" language="javascript1.2""></script>
<%@ taglib	uri="/tld/sp-formio" prefix="sp-formio"%> 
<portlet:defineObjects />
<% if(PermissionUtil.canEditModel((PortletRequest) request.getAttribute("javax.portlet.request"))){ %>
<%
String formId = portletPreferences.getValue(SystemSetupConstants.PREF_HTML_FORM_ID, "1943");
String dashBoardLink = SambaashUtil.getDashBoard();
%>
<div class="newPortlets">	
	<div class="subHeader">
		<div class="container">
			<aui:row>
				<aui:col span="10" cssClass="text-center"><h2>LAYOUT MARKER SETUP</h2></aui:col>
				<aui:col span="2" cssClass="text-right"><aui:a href="<%= dashBoardLink %>" title="Back to Dashboard">Back to Dashboard</aui:a></aui:col>
			</aui:row>
		</div>
	</div>
	<c:set var="formId" value="<%= formId %>"/>
	<c:set var="formType" value='<%= request.getParameter("formTypeName") %>' />
	<c:set var="formStorageId" value='<%= request.getParameter("storageId") %>' />
	<sp-formio:FormIO cssClass="formContainer formPadding" modelName ="${formType}" 
		formId="${formId}" readOnly="false" formStorageId="${formStorageId}"  />
</div>
<script type="text/javascript">
var mode = "edit";
function afterFormDataLoadedFormIOForm(thisInstance){
	if(thisInstance.components.FormStat.element.innerText!="Draft") {
		//thisInstance.components["MarkerName"].disabled = true;
		//thisInstance.components["MarkerIdentifier"].disabled = true;
		
		setInterval(function() {
			checkAMForm(thisInstance);
		}, 1000);
	}
	
	thisInstance.components.Submit.buttonElement.textContent = "Update";
}
function validateFormIOForm(thisInstance){
	thisInstance.customSubmission(thisInstance.form.submission);
}

</script>
<% } %>