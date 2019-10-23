<%@page import="com.liferay.portal.security.auth.AuthTokenUtil"%>
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
<link rel='stylesheet' href='/html/css/sp/formio.full.min.css?minifierType=css'>
<script type="text/javascript" src="/html/js/sp/hook.js?<%=System.currentTimeMillis()%>" language="javascript1.2""></script>
<%@ taglib	uri="/tld/sp-formio" prefix="sp-formio"%> 
<portlet:defineObjects />

<portlet:resourceURL var="resourceURL" >
	<portlet:param name="sp_p_auth" value="<%= AuthTokenUtil.getToken(request) %>"/>
</portlet:resourceURL>
<%
String dashBoardLink = SambaashUtil.getDashBoard();
%>

<div class="newPortlets navigationForm">	
<div class="subHeader">
	<div class="container">
		<aui:row>
			<aui:col span="10" cssClass="text-center"><h2>CHILD NAVIGATIION SETUP</h2></aui:col>
			<aui:col span="2" cssClass="text-right"><aui:a href="<%= dashBoardLink %>" title="Back to Dashboard">Back to Dashboard</aui:a></aui:col>
		</aui:row>
	</div>
</div>

<% if(PermissionUtil.canAddModel((PortletRequest) request.getAttribute("javax.portlet.request"))){ %>
<%
String formId = portletPreferences.getValue(SystemSetupConstants.PREF_HTML_FORM_ID, "1826");
%>
<c:set var="formId" value="<%= formId %>"/>
<c:set var="formType" value='<%= request.getParameter("formTypeName") %>' />

<sp-formio:FormIO cssClass="formContainer"  modelName ="${formType}" formId="${formId}" readOnly="false" formStorageId="0"  />

</div>

<script type="text/javascript">
var mode = "create";
var namespace =  "<portlet:namespace/>";
function validateFormIOForm(thisInstance){
	mode = "create";
	thisInstance.customSubmission(thisInstance.form.submission);
}
function afterFormLoadedFormIOForm(thisInstance){

}
var ajaxUrl =  "${resourceURL}";
var dataGrid;
function reloadOptions(thisInstance,parentComponentKey,componentKey){
	AUI().use('aui-base','aui-io-request-deprecated',function(A){
		
		let _data = {};
        _data[namespace + 'action'] = "fetchChildLayouts";	
        _data[namespace + 'layoutId'] = thisInstance.components.ParentLayout.value;
		A.io.request(ajaxUrl,{
	        dataType : 'json', method : "GET",
	        data : _data,
	        on : {
	            success : function(){
	            	var response = this.get("responseData");
	            	console.log(response);
	            	thisInstance.components.ChildLayout.setItems(response);
	            	//thisInstance.components.Roles.setItems(response);
	            },
	            failure : function() {
	                thisInstance.debug("Error in the ajax call.");
	            }
	        }
	    }); 
		
		var data = {};
		data.formStorageId = 1; 
		data.formType = "navigation";
		mode = "edit";
	 	ajaxCallAPI('GET', "loadData", data, function() {
				
                var response = this.get("responseData");
                
                if (_.isEmpty(response)) {
                    console.log("error");
                    
                } else {
                	dataGrid = response.contentJson.DataGrid;
                	for(var i =0 ; i < dataGrid.length; i++){
                		if(dataGrid[i].Layout.id == thisInstance.components.ParentLayout.value){
                			thisInstance.components.Roles.setItems(dataGrid[i].Role);
                			
                		}
                	}
                	
                }
            },
            function() {
                
     		});
		
		
	 }); 
	
}

</script>
<% } %>