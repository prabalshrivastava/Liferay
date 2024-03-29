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
<%@ taglib	uri="/tld/sp-formio" prefix="sp-formio"%> 
<portlet:defineObjects />

<portlet:renderURL var="taxCodeListing">
	<portlet:param name="jspPage"
		value="/html/profitcentre/list.jsp" />
</portlet:renderURL>
<% if(PermissionUtil.canViewModel((PortletRequest) request.getAttribute("javax.portlet.request"))){ %>
<%
String formId = portletPreferences.getValue(SystemSetupConstants.PREF_HTML_FORM_ID, "2020");
String dashBoardLink = SambaashUtil.getDashBoard();
%>
<div class="newPortlets">	
	<div class="subHeader">
		<div class="container">
			<aui:row>
				<aui:col span="10" cssClass="text-center"><h2>AWARD TYPE SETUP</h2></aui:col>
				<aui:col span="2" cssClass="text-right"><aui:a href="<%= dashBoardLink %>" title="Back to Dashboard">Back to Dashboard</aui:a></aui:col>
			</aui:row>
		</div>
	</div>
	<c:set var="formId" value="<%= formId %>"/>
	<c:set var="formStorageId" value='<%= request.getParameter("storageId") %>' />
	<c:set var="formType" value='<%= request.getParameter("formTypeName") %>' />
	<sp-formio:FormIO cssClass="formContainer" modelName ="${formType}" formId="${formId}" 
		readOnly="true" formStorageId="${formStorageId}"  />
</div>
<script type="text/javascript">
var mode = "view";
function afterFormDataLoadedFormIOForm(thisInstance){
	var cancelEles = document.getElementsByClassName("cancelBtn");
	for(var i=0;i<cancelEles.length;i++) {
		cancelEles[i].disabled = false;
	}
}
</script>
<% } %>