<%@page import="com.liferay.portal.kernel.util.StringPool"%>
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
<%@taglib	uri="http://liferay.com/tld/theme" prefix="theme"%>
<link rel='stylesheet' href='/html/css/hook.css?minifierType=css'>
<link rel='stylesheet' href='/html/css/sp/formio.full.min.css?minifierType=css'>
<script type="text/javascript" src="/html/js/sp/hook.js?<%=System.currentTimeMillis()%>" language="javascript1.2""></script>
<%@ taglib	uri="/tld/sp-formio" prefix="sp-formio"%> 
<portlet:defineObjects />
<theme:defineObjects />
<portlet:resourceURL var="ajaxUrl">
	
</portlet:resourceURL>
<%
String formId = portletPreferences.getValue(SystemSetupConstants.PREF_HTML_FORM_ID, "2144");
String configData = portletPreferences.getValue("config", StringPool.BLANK);
String dashBoardLink = SambaashUtil.getDashBoard();

String url = themeDisplay.getURLCurrent();
%>
<div class="newPortlets">
<div class="subHeader">
	<div class="container">
		<div class="inner-container">
			<aui:row>
				<aui:col span="10" cssClass="text-center"><h2><span>TAX CODE SETUP</span></h2></aui:col>
				<aui:col span="2" cssClass="text-right">
					<a href="<%= dashBoardLink %>" title="Back to Home">Back to Home</a>
				</aui:col>
			</aui:row>
		</div>
	</div>
</div>
<c:set var="formId" value="<%= formId %>"/>
<c:set var="formType" value='<%= request.getParameter("formTypeName") %>' />

	<div class="formRoot">
		<div class="innerFormRoot">
		<sp-formio:FormIO cssClass="formContainer formPadding"  modelName ="${formType}" formId="${formId}" readOnly="false" formStorageId="0"  />
	</div>
	</div>

</div>

<script>
var mode = "edit";
var url = "<%= url %>";
var ajaxUrl = "<%= ajaxUrl %>";
var configData = '<%= configData %>';
function validateFormIOForm(thisInstance){
	var formdata = thisInstance.form.submission.data;
	if(formdata.FirstName == ""){
		thisInstance.form.setAlert("","Please Fill up First Name");
	}
	else{
		savePreference(thisInstance,formdata);
	}
}
function savePreference(thisInstance,formdata){
	var dd = JSON.stringify(formdata);
	var _data = {};
	_data[thisInstance.namespace + 'formdata'] =  dd;
	_data[thisInstance.namespace + 'action'] =  "savePreference";
	 AUI().use('aui-base','aui-io-request-deprecated',function(A){
		A.io.request(ajaxUrl,{
	        dataType : 'json', method : "POST",
	        data : _data,
	        on : {
	            success : function() {
	            	var data = this.get("responseData");
	            	url = url.replace("edit","view");
	            	window.location.href = url;
	            	//thisInstance.components.UserId.setValue(data.userId.toString());
	            	//thisInstance.customSubmission(thisInstance.form.submission);
	            },
	            failure : function() {
	            	thisInstance.form.setAlert("","Internal Issue");
	            }
	        }
	    });  
	});  
}
function afterFormLoadedFormIOForm(thisInstance){
	thisInstance.populate(JSON.parse(configData));
}


</script>