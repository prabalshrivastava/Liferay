<%@page import="com.sambaash.platform.constant.SambaashConstants"%>
<%@page import="com.sambaash.platform.util.SambaashUtil"%>
<%@page import="javax.portlet.PortletRequest"%>
<%@page import="com.sambaash.platform.util.PermissionUtil"%>
<%@page import="com.sambaash.platform.constant.SystemSetupConstants"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@page import="com.liferay.portal.model.User"%>
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
<portlet:resourceURL var="ajaxUrl">
	
</portlet:resourceURL>

<div class="newPortlets">

<% if(PermissionUtil.canAddModel((PortletRequest) request.getAttribute("javax.portlet.request"))){ %>
<%
String formId = portletPreferences.getValue(SystemSetupConstants.PREF_HTML_FORM_ID, "1928");
String formType = request.getParameter("formTypeName");
if(formType == null ||  formType.equals("")){
	formType = portletPreferences.getValue(SystemSetupConstants.PREF_MODEL_NAME, "Invigilator");
}

String dashBoardLink = SambaashUtil.getDashBoard();

String storageId = request.getParameter("storageId");

String userFirstName = user.getFirstName();
String userLastName = user.getLastName();
String userEmailAddress = user.getEmailAddress();
String userId = String.valueOf(themeDisplay.getUserId());
if(storageId != null && !storageId.equalsIgnoreCase("")){
	userId = storageId;
}
%>
<div class="subHeader">
	<div class="container">
		<div class="inner-container">
			<aui:row>
				<aui:col span="10" cssClass="text-center"><h2><span>INVIGILATOR SETUP</span></h2></aui:col>
				<aui:col span="2" cssClass="text-right"><a href="<%= dashBoardLink %>" title="Back to Home">Back to Home</a></aui:col>
			</aui:row>
		</div>
	</div>
</div>
<c:set var="formId" value="<%= formId %>"/>
<c:set var="formType" value='<%= formType %>' />
<c:set var="formStorageId" value='<%= userId %>' />
	<div class="formRoot">
		<div class="innerFormRoot">
			<sp-formio:FormIO cssClass="formContainer" modelName ="${formType}" formId="${formId}" readOnly="false" formStorageId="${formStorageId}"  />
		</div>
	</div>
</div>
<script type="text/javascript">
var mode = "edit";
var userId = "<%= userId %>";
var ajaxUrl = "<%= ajaxUrl %>";

var userFirstName = "<%= userFirstName %>";
var userLastName = "<%= userLastName %>";
var userEmailAddress = "<%= userEmailAddress %>";



function afterFormLoadedFormIOForm(thisInstance){
	thisInstance.components["UserId"].setValue(userId.toString());
	thisInstance.formStorageId = userId;
	
	var data1 = {"limit":4,"modelName":modelName,"page":0,"formType":modelName};
 	data1.conditions = ["contentJson.UserId="+userId];
 	data1.sortBy = "contentJson.UserId";
 	
	ajaxCallAPI('GET','searchList',data1,
		 function() {
               var response = this.get("responseData");
               if (_.isEmpty(response)) {
                   console.log("error");
               } else {
               	if(response.numberOfElements > 1){
               		
               	}else if(response.numberOfElements == 1){
               		thisInstance.formStorageId = userId;
               		thisInstance.components["EmailAddress"].disabled = true;
               	}else{
               		thisInstance.formStorageId = 0;
               		thisInstance.components["EmailAddress"].disabled = true;
               		thisInstance.components["EmailAddress"].setValue(userEmailAddress);
               		thisInstance.components["FirstName"].setValue(userFirstName);
               		thisInstance.components["LastName"].setValue(userLastName);
               		
               	}
               	
               }
           },
           function() {
               
    		});
}
function afterPermissionsChecked(thisInstance){
	console.log(form1.components.IsInvigilator.visible);
	if(form1.components.IsInvigilator.visible==false) {
		form1.form.data.Accept=true;
		form1.components.CriminalRecord.element.getElementsByTagName("label")[0].classList.remove("field-required");
		form1.components.CriminalRecord.component.validate.required = false;
		document.getElementsByName("data[Accept]")[0].checked="checked";
	} else {
		form1.components.CriminalRecord.element.getElementsByTagName("label")[0].classList.add("field-required");
		form1.components.CriminalRecord.component.validate.required = true;
	}
	form1.components.Submit.checkConditions();
}
function validateFormIOForm(thisInstance){
	var formdata = thisInstance.form.submission.data;
	if(formdata.FirstName == ""){
		thisInstance.form.setAlert("","Please Fill up First Name");
	}
	else{
		checkEmailAddress(thisInstance,formdata.EmailAddress,formdata.FirstName,formdata.LastName);
	}
}
function checkEmailAddress(thisInstance,email,firstName,lastName){
	var _data = {};
	_data[thisInstance.namespace + 'emailId'] =  email;
	_data[thisInstance.namespace + 'firstName'] =  firstName;
	_data[thisInstance.namespace + 'lastName'] =  lastName;
	_data[thisInstance.namespace + 'action'] =  "checkEmail";
	 AUI().use('aui-base','aui-io-request-deprecated',function(A){
		A.io.request(ajaxUrl,{
	        dataType : 'json', method : "POST",
	        data : _data,
	        on : {
	            success : function() {
	            	var data = this.get("responseData");
	            	thisInstance.components.UserId.setValue(data.userId.toString());
	            	thisInstance.customSubmission(thisInstance.form.submission);
	            },
	            failure : function() {
	            	thisInstance.form.setAlert("","Internal Issue");
	            }
	        }
	    });  
	});  
}
</script>
<% } %>
