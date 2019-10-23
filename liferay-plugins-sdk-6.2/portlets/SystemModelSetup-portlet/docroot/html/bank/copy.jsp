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
<portlet:renderURL var="bankCodeListing">
	<portlet:param name="jspPage"
		value="/html/bank/list.jsp" />
</portlet:renderURL>


<% if(PermissionUtil.canCopyModel((PortletRequest) request.getAttribute("javax.portlet.request"))){ %>

<%
String formId = portletPreferences.getValue(SystemSetupConstants.PREF_HTML_FORM_ID, "1720");
String dashBoardLink = SambaashUtil.getDashBoard();
%>
<div class="newPortlets">	
<div class="subHeader">
	<div class="container">
		<div class="inner-container">
			<aui:row>
				<aui:col span="10" cssClass="text-center"><h2><span>BANK CODE SETUP</span></h2></aui:col>
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
<sp-formio:MakeCopyTag cssClass="formContainer" modelName ="${formType}" formId="${formId}" readOnly="false" formStorageId="${formStorageId}"  />
</div>
</div></div>

<script type="text/javascript">
var mode = "copy";
function validateFormIOForm(thisInstance){
	var formdata = thisInstance.form.submission.data;
	if(formdata.BankCode == ""){
		thisInstance.form.setAlert("error","Please Fill up Bank Code");
	}
	else{
		var bankCode = formdata.BankCode;
	 	var data1 = {"limit":4,"modelName":modelName,"page":0,"formType":modelName};
	 	data1.conditions = ["contentJson.BankCode="+bankCode];
	 	data1.sortBy = "contentJson.BankCode";
		ajaxCallAPI('GET','searchList',data1,
			function() {
					
               var response = this.get("responseData");
               
               if (_.isEmpty(response)) {
                   console.log("error");
                   
               } else {
               	if(response.numberOfElements > 1){
               		thisInstance.form.setAlert("","Duplicate Record");
               	}else if(response.numberOfElements == 1 && response.content[0].storageId == thisInstance.formStorageId){
               		thisInstance.form.setAlert("","Duplicate Record");
               	}
				else{
               		thisInstance.customSubmission(thisInstance.form.submission);
               	}
               }
           },
           function() {
               
    		});
	}
	
	 
}
function afterFormDataLoadedFormIOForm(thisInstance){
	thisInstance.components.Deactivate.buttonElement.style.display = "none";
	thisInstance.components.BankCode.setValue("Copy-of-"+ thisInstance.components.BankCode.value);
}
</script>

<% } %>