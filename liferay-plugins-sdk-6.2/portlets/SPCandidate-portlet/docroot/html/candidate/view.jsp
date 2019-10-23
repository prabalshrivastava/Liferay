<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.sambaash.platform.util.PermissionUtil"%>
<%@page import="com.sambaash.platform.util.SambaashUtil"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>

<%@page import="javax.portlet.PortletRequest"%>
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
<liferay-theme:defineObjects />

<% if(PermissionUtil.canEditModel((PortletRequest) request.getAttribute("javax.portlet.request"))){ %>
<%
String formId = portletPreferences.getValue(SystemSetupConstants.PREF_HTML_FORM_ID, "1720");
String formType = portletPreferences.getValue(SystemSetupConstants.PREF_MODEL_NAME, "Candidate");
String dashBoardLink = SambaashUtil.getDashBoard();

String storageId = request.getParameter("storageId");
String userId = String.valueOf(themeDisplay.getUserId());
if(storageId != null && !storageId.equalsIgnoreCase("")){
	userId = storageId;
}
%>

<div class="newPortlets">	
<div class="subHeader"> 
	<div class="container">
		<div class="inner-container">
			<aui:row>
				<aui:col span="10" cssClass="text-center"><h2><span>CANDIDATE DETAILS</span></h2></aui:col>
				<aui:col span="2" cssClass="text-right"><a href="<%= dashBoardLink %>" title="Back to Dashboard">Back to Home</a></aui:col>
			</aui:row>
		</div>
	</div>
</div>

<c:set var="formId" value="<%= formId %>"/>
<c:set var="formType" value='<%= formType %>' />
<c:set var="formStorageId" value='<%= userId %>' />
<div class="formRoot">
	<div class="innerFormRoot">
		<sp-formio:FormIO cssClass="formContainer" modelName ="${formType}" formId="${formId}" readOnly="true" formStorageId="${formStorageId}"  />
	</div>
</div>
</div>
<script type="text/javascript">
var mode = "view";
var userId = "<%= userId %>";
function afterFormDataLoadedFormIOForm(thisInstance) {
	thisInstance.components["Mode"].setValue(mode);
	thisInstance.components["submit"].visible = false;
	thisInstance.components["columnsCancel"].disabled = "";
	hideGridElements(document.getElementsByClassName("editRow"));
	hideGridElements(document.getElementsByClassName("removeRow"));
}
function afterFormLoadedFormIOForm(thisInstance){
	
	thisInstance.components["UserId"].setValue(userId.toString());
	thisInstance.formStorageId = userId;
	var data1 = {"limit":4,"modelName":modelName,"page":0,"formType":modelName};
	var filterdata = [{"contentJson.UserId":[userId]}];
 	data1.filterdata = filterdata;
 	data1.sortBy = "UserId";
 	
	ajaxCallAPI('GET','elastiSearchList',data1,
		 function() {
				
               var response = this.get("responseData");
               
               if (_.isEmpty(response)) {
                   console.log("error");
                  
                   
               } else {
               	if(response.numberOfElements > 1){
               		
               	}else if(response.numberOfElements == 1){
               		thisInstance.formStorageId = userId;
               	}else{
               		thisInstance.formStorageId = 0;
               	}
               	
               }
           },
           function() {
               
    		});
}

function hideGridElements(elements) {
	try {
		console.log("elements : "+elements.length);
		for(i=0;i<elements.length;i++) {
			console.log(elements[i]);
			elements[i].style.display="none";
		}
	} catch(ex) {
		console.log(ex);
	}
}

function validateFormIOForm(thisInstance){
	
	var formdata = thisInstance.form.submission.data;
	console.log(formdata);
	
	if(formdata.FirstName == ""){
		thisInstance.form.setAlert("","Please Fill up First Name");
	}
	else{
		thisInstance.customSubmission(thisInstance.form.submission);
	}
}

</script>
<% } %>