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
<script type="text/javascript" src="<%=request.getContextPath()%>/js/main.js" language="javascript1.2""></script>
<%@ taglib	uri="/tld/sp-formio" prefix="sp-formio"%> 
<portlet:defineObjects />
<% if(PermissionUtil.canCopyModel((PortletRequest) request.getAttribute("javax.portlet.request"))){ %>
<%
String formId = portletPreferences.getValue(SystemSetupConstants.PREF_HTML_FORM_ID, "1941");
String dashBoardLink = SambaashUtil.getDashBoard();
%>
<style>
.formStatus{
    width: 90px;
    padding: 2px 10px;
    text-align: center;
    border-radius: 15px;
    float: po;
    position: absolute;
    top: -25px;
    right: 0;
}
.form_active{
	background: #8bdb7c;
}
.form_inactive{
	background: #ffc48b;
}
.form_draft{
	background: #dfe3e8;
}
.form_blacklist{
	background: black;
	color:white;
}
</style>
<div class="newPortlets">	
	<div class="subHeader">
		<div class="container">
			<div class="inner-container">
				<aui:row>
					<aui:col span="10" cssClass="text-center"><h2><span>CHART OF ACCOUNTS SETUP</span></h2></aui:col>
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
	<sp-formio:MakeCopyTag cssClass="formContainer formPadding" modelName ="${formType}" 
		formId="${formId}" readOnly="false" formStorageId="${formStorageId}"  />
		</div>
	</div>
</div>
<script type="text/javascript">
var mode = "copy";
function validateFormIOForm(thisInstance){
	thisInstance.customSubmission(thisInstance.form.submission);
}
function afterFormDataLoadedFormIOForm(thisInstance){
	thisInstance.components.Submit.buttonElement.textContent = "Publish";
	thisInstance.components.Deactivate.buttonElement.style.display = "none";
	thisInstance.components.GlCode.setValue("Copy-of-"+ thisInstance.components.GlCode.value);
	setInterval(function() {
		checkCOAForm(thisInstance);
	}, 1000);
}
</script>
<% } %>