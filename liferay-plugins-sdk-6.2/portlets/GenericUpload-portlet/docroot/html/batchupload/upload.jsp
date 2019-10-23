<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@page import="com.sambaash.platform.constant.SystemSetupConstants"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@page import="com.liferay.portal.security.auth.AuthTokenUtil"%>
<link rel='stylesheet' href='/html/css/hook.css?minifierType=css'>
<link rel='stylesheet' href='/html/css/sp/formio.full.min.css?minifierType=css'>
<script type="text/javascript" src="/html/js/sp/hook.js?<%=System.currentTimeMillis()%>" language="javascript1.2""></script>
<link rel='stylesheet' href='<%=request.getContextPath()%>/css/main.css?<%=System.currentTimeMillis()%>'>
<%@ taglib	uri="/tld/sp-formio" prefix="sp-formio"%>  
<portlet:defineObjects />
<portlet:renderURL var="homePage">
    <portlet:param name="jspPage" value="/html/enrolment/view.jsp" />
</portlet:renderURL>
<portlet:actionURL var="batchUpload" name="uploadFiles">
    <portlet:param name="action" value="uploadFiles" />
    
</portlet:actionURL>

<portlet:resourceURL var="resourceURL" >
	<portlet:param name="sp_p_auth" value="<%= AuthTokenUtil.getToken(request) %>"/>
	<portlet:param name="formType" value="TaxCode"/>
</portlet:resourceURL>
<link rel='stylesheet' href='<%=request.getContextPath()%>/css/batchupload.css?<%=System.currentTimeMillis()%>'>
<style>
.disable-css{
	pointer-events: none;
  	opacity:0.7;
  }
</style>
<%
String modelNames = portletPreferences.getValue(SystemSetupConstants.PREF_MODEL_NAME, "TaxCode");
String[] array = modelNames.split(",");

%>
<div class="newPortlets">
    <!-- header -->

    <div class="subHeader">
        <div class="container">
        	 <div class="inner-container">
	            <aui:row>
	                <aui:col span="10" cssClass="text-center header-title">
	                    <h2><span>BATCH UPLOADER</span></h2>
	                </aui:col>
	                <aui:col span="2" cssClass="text-right header-home-link">
	                    <aui:a href="<%=homePage%>" title="Back to Home">Back to Home</aui:a>
	                </aui:col>
	            </aui:row>
	          </div>
        </div>
    </div>
    <div class="container enrolment-body enrolment-center-align">
     
        <div class="uc-box enrolment-center-align">
            <aui:row>
                <aui:col span="12" cssClass="text-center">
                    <img src="<%=request.getContextPath()%>/img/background-batch-upload.png">
                </aui:col>
            </aui:row>
            <div class="uc-box-bottom">
                <aui:form action="<%=batchUpload %>" enctype="multipart/form-data" method="POST" id="myForm" name="myForm">
                    <div style="display: none; margin-top:10px;" class="alert alert-danger"
									role="showAlert" id="alert_msg_id">Select Facility Type.</div>
                    <div class="text-center batchUploadBox">
                      	<aui:select name="formType" id="component" label="Component" onchange="getfilepath()">
	                      	<aui:option value="">
	                      		Select
	                      	</aui:option>
	                      	<% for(int i = 0; i < array.length; i++ ){ %>
		                      	<aui:option value="<%= array[i].toString() %>">
		                      		<%= array[i].toString() %>
		                      	</aui:option>
	                      	<% } %>
                      	</aui:select>
                        <br>
                        <span class="btn-file disable-css" id="file-upload-id">
    						UPLOAD <aui:input disabled="true" type="file" accept="application/vnd.openxmlformats-officedocument.spreadsheetml.sheet, application/vnd.ms-excel" name="myFile"  label=""></aui:input>
						</span>
						
						<br>
                        <br><a id="filepath" class="disable-css" href="javascript: void(0)" target="_blank">[ Download sample CSV template]</a>
                    </div>
                </aui:form>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
var mode = "view";
var modelName = "taxcode";
var namespace =  "<portlet:namespace/>";
var ajaxUrl = "${resourceURL}";
var formInstance;
function afterFormLoadedFormIOForm(thisInstance) {
    formInstance = thisInstance;
}

function getfilepath(){
	var component = document.getElementById(namespace +"component").value;
	console.log(component);
	var hDiv = document.getElementById('filepath');
	var fileUploadDiv = document.getElementById('file-upload-id');
	if(component == "" && !component){
		hDiv.href = 'javascript: void(0)';
		hDiv.style.pointerEvents = "none";
		hDiv.style.opacity = "0.7";
		fileUploadDiv.style.pointerEvents = "none";
		fileUploadDiv.style.opacity = "0.7";
		document.getElementById("_batchupload_WAR_GenericUploadportlet_myFile").disabled = true;
	}else{
		fileUploadDiv.style.pointerEvents = "painted";
		fileUploadDiv.style.opacity = "1";
		document.getElementById("_batchupload_WAR_GenericUploadportlet_myFile").disabled = false;
		hDiv.style.pointerEvents = "painted";
		hDiv.style.opacity = "1";
		var path = "<%=request.getContextPath()%>/assets/" + component.toLowerCase() + ".xlsx";
		hDiv.href = path;
	}
}

document.getElementById("_batchupload_WAR_GenericUploadportlet_myFile").onchange = function () {
	console.log(this);
	if(this.files[0] != null && this.files[0].name){
		var fileName = this.files[0].name;
		if(fileName && checkFileExtension(fileName)){
			this.form.submit();
		}else{
			_displayMessage('danger', "File with extension .xlsx is allowed to upload.", 5000);
		}
	}
}; 

function checkFileExtension(fileName){
	var isValid = false;
	if(fileName){
		var ext = fileName.substring(fileName.lastIndexOf('.') + 1).toLowerCase();
		if(ext == "xlsx" || ext == "XLSX"){
			isValid = true;
		}
	}
	return isValid;
}

function _displayMessage(type, message, duration) {
	//scrollToTop();
	var alert_div = document.getElementById("alert_msg_id");
	alert_div.innerHTML = message;
	alert_div.classList.add("alert-" + type);
	alert_div.style.display = "block";
	setTimeout(function() {
		alert_div.style.display = "none";
	}, duration);
}
var timeOut;
function scrollToTop() {
	if (document.body.scrollTop != 0 || document.documentElement.scrollTop != 0) {
		window.scrollBy(0, -50);
		timeOut = setTimeout('scrollToTop()', 10);
	} else {
		clearTimeout(timeOut);
	}

}

</script>