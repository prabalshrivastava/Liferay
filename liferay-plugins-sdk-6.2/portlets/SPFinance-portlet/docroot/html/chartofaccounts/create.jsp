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

<link rel='stylesheet' href='/html/css/hook.css?minifierType=css'>
<link rel='stylesheet' type="text/css"
	href='<%=request.getContextPath()%>/css/main.css?minifierType=css'></link>
<link rel='stylesheet' type="text/css" href='<%=request.getContextPath()%>/css/portlet.css?minifierType=css'></link>
<link rel='stylesheet' href='/html/css/sp/formio.full.min.css?minifierType=css'>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/main.js" language="javascript1.2""></script>
<script type="text/javascript" src="/html/js/sp/hook.js?<%=System.currentTimeMillis()%>" language="javascript1.2""></script>
<%@ taglib	uri="/tld/sp-formio" prefix="sp-formio"%> 
<portlet:defineObjects />

<portlet:renderURL var="profitCentreListing">
	<portlet:param name="jspPage"
		value="/html/chartofaccounts/list.jsp" />
</portlet:renderURL>
<div class="newPortlets">
<% if(PermissionUtil.canAddModel((PortletRequest) request.getAttribute("javax.portlet.request"))){ %>
<%
String formId = portletPreferences.getValue(SystemSetupConstants.PREF_HTML_FORM_ID, "1941");
String dashBoardLink = SambaashUtil.getDashBoard();
%>
	<div class="subHeader">
		<div class="container">
			<div class="inner-container">
				<aui:row>
					<aui:col span="10" cssClass="text-center"><h2><span>CHART OF ACCOUNTS SETUP</span></h2></aui:col>
					<aui:col span="2" cssClass="text-right"><aui:a href="<%= dashBoardLink %>" title="Back to Dashboard">Back to Dashboard</aui:a></aui:col>
				</aui:row>
			</div>
		</div>
	</div>
	<c:set var="formId" value="<%= formId %>"/>
	<c:set var="formType" value='<%= request.getParameter("formTypeName") %>' />
	<div class="formRoot">
		<div class="innerFormRoot">
			<sp-formio:FormIO cssClass="formContainer formPadding"  modelName ="${formType}" 
		formId="${formId}" readOnly="false" formStorageId="0"  />
		</div>
	</div>
</div>

<script type="text/javascript">
var mode = "create";
function validateFormIOForm(thisInstance){
	thisInstance.customSubmission(thisInstance.form.submission);
}
function afterFormLoadedFormIOForm(thisInstance){
	thisInstance.components.FormStat.element.innerText = "Draft";
	thisInstance.components.FormStat.element.classList.add("form_draft");
	thisInstance.components.Deactivate.buttonElement.style.display = "none";
	setInterval(function() {
		checkCOAForm(thisInstance);
	}, 1000);
}
</script>
<% } %>