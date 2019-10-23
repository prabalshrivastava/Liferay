<%@page import="com.liferay.portal.security.auth.AuthTokenUtil"%>
<%@page import="com.sambaash.platform.util.SambaashUtil"%>
<%@page import="java.util.Arrays"%>
<%@page import="org.apache.commons.lang.StringUtils"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>

<link rel='stylesheet' href='/html/css/sp/bootstrap.min.css?minifierType=css'>
<link rel='stylesheet' href='/html/css/sp/formio.full.min.css?minifierType=css'>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/main.css"/>
<liferay-theme:defineObjects />
<portlet:defineObjects />
<script>
var form1 ;
var modelName = "TaxCode";
var namespace =  "<portlet:namespace />";
</script>
<portlet:resourceURL var="resourceURL" >
<portlet:param name="sp_p_auth" value="<%= AuthTokenUtil.getToken(request) %>"/>
</portlet:resourceURL>

<!-- Example style to set in portlet preference: "margin:5px auto; max-width: 640px" -->
<div id='formio' style="<%= renderRequest.getPreferences().getValue("containerStylePref","")%>"></div>
 
<aui:script use="aui-base,aui-node,aui-io-request">
	var apiUrl = '<%= SambaashUtil.getFormV2BaseUrl() %>';
	var userInfo = <%= SambaashUtil.getUserInfo(themeDisplay).toString() %>;
	
	// these data may have been set via friendly url
	// otherwise, the formId set in the portlet preference will be loaded
	var readOnly = <%= request.getParameter("readOnly") %>;
	var formId = "1787";
	console.log('formId 1='+formId);
	if (!formId) {
		formId = '<%= renderRequest.getPreferences().getValue("htmlFormIdPref","")%>';
		console.log('formId 2='+formId);
	}

	var formStorageId = <%= request.getParameter("formStorageId") %>;
	
	window.onload = function() {
		initializeView(apiUrl,modelName, userInfo, 'formio', formId, formStorageId, '<portlet:namespace />', '<%=resourceURL%>', readOnly);		
	}
	
	function initializeView(apiUrl,formType, userInfo, formContainerId, formId, formStorageId, namespace, ajaxUrl, readOnly) {
		var form = new SPDynamicForm(apiUrl,formType, formContainerId, formId, formStorageId, ajaxUrl, namespace);
		form.userInfo = userInfo;
		form.load({readOnly : readOnly});
		if(formStorageId != 0 || formStorageId != ""){
			form.mode = "edit";
		}else{
			form.mode = "create";
		}
		form1 = form;
	}
	
</aui:script>
<script>
var instance;
function afterFormLoadedFormIOForm(thisInstance){
	instance = thisInstance;
}
</script>
