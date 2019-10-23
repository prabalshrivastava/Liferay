<%@page import="com.sambaash.platform.constant.SystemSetupConstants"%>
<%@page import="com.liferay.portal.security.auth.AuthTokenUtil"%>
<%@page import="com.sambaash.platform.util.SambaashUtil"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>



<%@page import="java.util.Arrays"%>

<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>

<link rel='stylesheet' href='/html/css/hook.css?minifierType=css'>
<script type="text/javascript" src="/html/js/sp/hook.js?<%=System.currentTimeMillis()%>" language="javascript1.2""></script>
<liferay-theme:defineObjects />
<portlet:defineObjects />

<portlet:resourceURL var="resourceURL" >
	<portlet:param name="sp_p_auth" value="<%= AuthTokenUtil.getToken(request) %>"/>
</portlet:resourceURL>
<portlet:resourceURL var="fileUploadURL">
	<portlet:param name="action" value="upload" />
</portlet:resourceURL>
<!-- Example style to set in portlet preference: "margin:5px auto; max-width: 640px" -->

<%

String cssClass  = GetterUtil.getString((String)request.getAttribute("sp-formio:CopyFormIO:cssClass"), "social-share margin-top-half text-center");
String formId  = GetterUtil.getString((String)request.getAttribute("sp-formio:CopyFormIO:formId")) ;
String modelName  = GetterUtil.getString((String)request.getAttribute("sp-formio:CopyFormIO:modelName")) ;
String readOnly  = GetterUtil.getString((String)request.getAttribute("sp-formio:CopyFormIO:readOnly")) ;
String formStorageId  = GetterUtil.getString((String)request.getAttribute("sp-formio:CopyFormIO:formStorageId")) ;
String prefStyle = portletPreferences.getValue(SystemSetupConstants.PREF_CONTAINER_STYLE, "");
%> 

<div class="yui3-skin-sam">
<div id="sucess-popup" hidden="true" class="modalpopupBox">
   <div id="sucess-popup-box" class="modalpopupContent">
   <form class="formContainer" >
     <aui:row>
         <aui:col span="12">
       	  <h3 id="success-msg"><%= modelName %> Created!</h3>
       	  </aui:col>
       
     </aui:row>
     <aui:row>
      	<aui:col span="12">
      		<button class="btn btn-default" type="button" onClick="reloadPage()">Start Again</button>
      		<button class="btn cancel btn-primary pull-right" onclick="goBack()">Go Back</button>
      	</aui:col>
     </aui:row>
           
   </form>
   </div>
</div>
</div>
<div id='formio' class="<%= cssClass %> container" style="<%= prefStyle %>"></div>

<%@ include file="/html/taglib/logic.jsp" %>

<script>
var form1 ;
var modelName = "<%= modelName %>";
var namespace =  "<portlet:namespace />";
var ajaxUrl =  "<%=resourceURL%>";
var uploadUrl = "<%= fileUploadURL%>";
var formStorageId = encodeURIComponent("<%= formStorageId %>"); 
var listpage = '<%= portletPreferences.getValue(SystemSetupConstants.PREF_BASE_URL, "") %>';
</script>

<aui:script use="aui-base,aui-node,aui-io-request">
	var apiUrl = '<%= SambaashUtil.getFormV2BaseUrl() %>';
	var userInfo = <%= SambaashUtil.getUserInfo(themeDisplay).toString() %>;
	var modelName = "<%= modelName %>";
	var readOnly = <%= readOnly %>;
	var formId = "<%= formId %>";
	console.log('formId 1='+formId);
	if (!formId) {
		formId = '<%= renderRequest.getPreferences().getValue("htmlFormIdPref","")%>';
		console.log('formId 2='+formId);
	}
	var formStorageId = encodeURIComponent("<%= formStorageId %>"); 
	
	
	window.onload = function() {
		initializeView(apiUrl,modelName, userInfo, 'formio', formId, formStorageId, '<portlet:namespace />', '<%=resourceURL%>', readOnly);		
	}
	
	function initializeView(apiUrl,formType, userInfo, formContainerId, formId, formStorageId, namespace, ajaxUrl, readOnly) {
		Formio.setPlatformAuth("<%= AuthTokenUtil.getToken(request) %>");
		var form = new SPDynamicForm(apiUrl,formType, formContainerId, formId, formStorageId, ajaxUrl, namespace);
		form.userInfo = userInfo;
		form.load({readOnly : readOnly});
		form.mode = "copy";
		form1 = form;
		form1.formLogicHandler = new SPFormLogicHandler(form1);
	}
	
	
</aui:script>
<script>
var instance;
var actionPerformed = "Created";
function afterFormLoadedFormIOForm(thisInstance){
	instance = thisInstance;
}
function afterFormDataLoadedFormIOForm(thisInstance){
	
}
function afterPermissionsChecked(thisInstance){
	
}
function validateFormIOForm(thisInstance){

}
function failedFormSubmissionFormIOForm(thisInstance){
	
}
function afterFormSubmissionFormIOForm(thisInstance){
	var status = thisInstance.form.submission.data.Status;
	var msg = "";
	var boundingBox = "#sucess-popup";
	var contentBox = "#sucess-popup-box";
	var formTypeStr = thisInstance.formType.replace(/([a-zA-Z])(?=[A-Z])/g, '$1 ');
	if(actionPerformed == "Draft"){
		msg = thisInstance.formType + " saved to Draft";
	}else if(formStorageId == "0"){
		msg = formTypeStr + " Created!";
	}
	else if(actionPerformed == "Activated"){
		msg = formTypeStr + " Activated!";
		boundingBox = "#activation-success";
    	contentBox = "#active-success-box";
	}
	else if(actionPerformed == "Deactivated" ){
		msg = formTypeStr + " Deactivated!";
		boundingBox = "#deactivation-success";
    	contentBox = "#inactive-success-box";
	}
	else {
		msg = formTypeStr + " Updated!";
	}
	document.getElementById('success-msg').innerHTML = msg;  
	AUI().use('aui-base', function(A) {
		
        A.one(boundingBox).set('hidden', false);
        
        YUI().use('aui-modal', function(Y) {
           var modal = new Y.Modal({
                           boundingBox: boundingBox,
                           contentBox: contentBox,
                           headerContent: '',
                           centered: true,
                           destroyOnHide: false,
                           modal: true,
                           resizable: false,
                           draggable: false,
            }).render();
           Y.all('.close').on(
	         	      'click',
	         	      function() {
	         	    	reload();
	         	        modal.hide();
	         	      }
	         	    );
        });

    });
}
function moveToDashboard(){
	window.location.href = "http://localhost:8081/";
}

function ajaxUploadCall(method, action, data, successHandler, failHandler) {
    
    AUI().use('aui-base','aui-io-request-deprecated',function(A){
        var _data = {};
        _data[instance.namespace + 'formId'] = thisInstance.formId;
        if (instance.mode == "edit" ||  (instance.mode == "copy" && method == "GET" )) {
        	_data[instance.namespace + 'formStorageId'] = instance.formStorageId;
        }else{
        	_data[instance.namespace + 'formStorageId'] = "0";
        }
        _data[instance.namespace + 'formType'] = instance.formType;
        _data[instance.namespace + 'action'] = action;
        if (data) {
            _data[instance.namespace + 'file'] = data;              
        }
        A.io.request(instance.uploadUrl,{
            method : 'POST',
            enctype : 'multipart/form-data',
            upload: true,
            data : _data,
            on : {
                success : successHandler,
                failure : failHandler || function() {
                    thisInstance.debug("Error in the ajaxUploadCall.");
                }
            }
        });             
    });
};
var spFileService = function(){
    var base64 = Formio.providers.storage.base64(Formio);  
    var dropbox = Formio.providers.storage.dropbox(Formio);  
    var s3 = Formio.providers.storage.s3(Formio);  
    var url = Formio.providers.storage.url(Formio);
    
    var download = function(storage, file) {
        return Formio.providers.storage[storage](Formio).downloadFile(file); 
    };

    var upload = function(storage, file, fileName, dir, progressCallback, url) {
    	var thisInstance = this;
    	return	ajaxUploadCall('POST', 'upload', file, 			    	
			    	function() {
			            var respdata = this.get("responseData");
			    		console.log(respdata);
			            if (respdata!=null && respdata.error) {
			            	instance.displayMessage('danger', respdata.error);
			            } else {
			            	console.log("success");
			            	if (respdata!=null){
			            		guid = respdata.guid;
			            		
			            	}
			            }
			           
			        },
			        function() {
			        	instance.displayMessage('danger', "Error in uploading to form storage");
    				}
				); 
    };
    
    return {
        downloadFile : download,
        uploadFile : upload
    };
}();

</script>