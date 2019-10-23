<%@page import="com.sambaash.platform.constant.SystemSetupConstants"%>
<%@page import="com.liferay.portal.security.auth.AuthTokenUtil"%>
<%@page import="com.sambaash.platform.util.SambaashUtil"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%> 
<%@page import="com.liferay.portal.kernel.util.WebKeys"%> 

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


<portlet:resourceURL var="fileUploadURL">
	
</portlet:resourceURL>
<!-- Example style to set in portlet preference: "margin:5px auto; max-width: 640px" -->

<%

String cssClass  = GetterUtil.getString((String)request.getAttribute("sp-formio:FormIO:cssClass"), "social-share margin-top-half text-center");
String formId  = GetterUtil.getString((String)request.getAttribute("sp-formio:FormIO:formId")) ;
String modelName  = GetterUtil.getString((String)request.getAttribute("sp-formio:FormIO:modelName")) ;
String readOnly  = GetterUtil.getString((String)request.getAttribute("sp-formio:FormIO:readOnly")) ;
String formStorageId  = GetterUtil.getString((String)request.getAttribute("sp-formio:FormIO:formStorageId")) ;
String prefStyle = portletPreferences.getValue(SystemSetupConstants.PREF_CONTAINER_STYLE, "");

ThemeDisplay td  = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
String baseUrl = td.getPortalURL();
%> 
<portlet:resourceURL var="resourceURL" >
	<portlet:param name="sp_p_auth" value="<%= AuthTokenUtil.getToken(request) %>"/>
	<portlet:param name="formTypeName" value="<%= modelName %>"/>
</portlet:resourceURL>
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
	      		<button class="btn btn-default popup-confirm-archive pull-left" type="button" onClick="reloadPage()">Start Again</button>
	      		<button class="btn cancel btn-primary popup-cancel pull-right" type="button" onClick="goBack()">Go Back</button>
	      	</aui:col>
	     </aui:row>
	           
	   </form>
	   </div>
	</div>
</div>






<div class="yui3-skin-sam">
	<div id="deactive-record" hidden="true" class="modalpopupBox">
		<div id="deactive-record-box" class="modalpopupContent">
			<form class="formContainer" action="">


				<aui:row>
					<aui:col span="12">
						<h3>Deactivate this record?</h3>
						<p id ="deactivate_msg">Please provide your reasons for deactivating this record</p>
						<textarea cols="" rows="" id="deactivate_reason"></textarea>

					</aui:col>

				</aui:row>
				<aui:row>
					<aui:col span="12">
						<!-- <button type="button"
							class="btn lightbluebtn popup-confirm-deactivate pull-left">Confirm</button> -->
							<button type="button"
							class="btn  btn-primary popup-confirm-deactivate pull-left">Confirm</button>
						<button type="button"
							class="btn cancel  btn-default popup-cancel-deactivate pull-right">Cancel</button>
					</aui:col>
				</aui:row>
			</form>

		</div>
	</div>
</div>

<div class="yui3-skin-sam">
	<div id="blacklist-record" hidden="true" class="modalpopupBox">
		<div id="blacklist-record-box" class="modalpopupContent">
			<form class="formContainer" action="">


				<aui:row>
					<aui:col span="12">
						<h3>Blacklist this record?</h3>
						<p id ="deactivate_msg">Please provide your reasons for blacklisting this record</p>
						<textarea cols="" rows="" id="deactivate_reason"></textarea>

					</aui:col>

				</aui:row>
				<aui:row>
					<aui:col span="12">
						<button type="button"
							class="btn btn-primary popup-confirm-blacklist pull-left">Confirm</button>
						<button type="button"
							class="btn cancel btn-default popup-cancel-blacklist pull-right">Cancel</button>
					</aui:col>
				</aui:row>
			</form>

		</div>
	</div>
</div>

<div class="yui3-skin-sam">
	<div id="deactivation-success" hidden="true" class="modalpopupBox">
		<div id="inactive-success-box" class="modalpopupContent">

			<aui:row>
				<aui:col span="12">
					<h3>De-activation successful!</h3>
					<p>This record will not be in use anymore</p>
				</aui:col>
			</aui:row>
			<aui:row>
				<aui:col span="12" cssClass="userAction">
					<!-- <button class="btn btn-primary popup-reactivate">Re-active</button> -->
					<button type="button"
							class="btn btn-primary popup-confirm-blacklist pull-left" onClick="reloadPage()">Start Again</button>
						<button type="button"
							class="btn cancel btn-default popup-cancel-blacklist pull-right" onClick="moveToDashboard()">Dashboard</button>
				</aui:col>
			</aui:row>

		</div>
	</div>
</div>

<div class="yui3-skin-sam">  
	<div id="activation-success" hidden="true" class="modalpopupBox">
		<div id="active-success-box" class="modalpopupContent">

			<aui:row>
					<aui:col span="12">
						<h3>Reactivation successful!</h3>
					</aui:col>
				</aui:row>
				<aui:row>
					<aui:col span="12" cssClass="userAction">
						<!-- <button type="button"
							class="btn btn-primary cancel popup-cancel-blacklist" onclick= "goBack();">BACK TO LISTING</button> -->
							<button type="button"
							class="btn btn-primary popup-reactivate" onclick= "goBack();">BACK TO LISTING</button>
					</aui:col>
				</aui:row>
		</div>
	</div>

</div>


<div id='formio' class="<%= cssClass %> container" style="<%= prefStyle %>"></div>

<% if(readOnly.equals("true")){ %>

<div id="l5xvf" class="form-group has-feedback formio-component formio-component-button formio-component-columnsColumnsColumnsCancel  form-group" style="margin-top: -57px;float: right;margin-right: 296px;display:none">
	<button name="" type="button" class="btn btn-default" lang="en" onClick="goBack();" >Cancel</button>
</div>
<% } %>

<%@ include file="/html/taglib/logic.jsp" %>

<script>
var form1 ;
var modelName = "<%= modelName %>";
var namespace =  "<portlet:namespace />";
var ajaxUrl =  "<%=resourceURL%>";
var uploadUrl = "<%= fileUploadURL%>";
var formStorageId = encodeURIComponent("<%= formStorageId %>"); 
var listpage = '<%= portletPreferences.getValue(SystemSetupConstants.PREF_BASE_URL, "") %>';
var baseUrl = '<%= baseUrl %>';
</script>

<aui:script use="aui-base,aui-node,aui-io-request">
	var apiUrl = '<%= SambaashUtil.getFormV2BaseUrl() %>';
	var userInfo = <%= SambaashUtil.getUserInfo(themeDisplay).toString() %>;
	var modelName = "<%= modelName %>";
	var readOnly = <%= readOnly %>;
	var formId = "<%= formId %>";
	
	if (!formId) {
		formId = '<%= renderRequest.getPreferences().getValue("htmlFormIdPref","")%>';
		
	}
	var formStorageId = encodeURIComponent("<%= formStorageId %>"); 
	
	
	window.onload = function() {
		initializeView(apiUrl,modelName, userInfo, 'formio', formId, formStorageId, '<portlet:namespace />', '<%=resourceURL%>', readOnly);		
	}
	
	function initializeView(apiUrl,formType, userInfo, formContainerId, formId, formStorageId, namespace, ajaxUrl, readOnly) {
		Formio.setPlatformAuth("<%= AuthTokenUtil.getToken(request) %>");
		var form = new SPDynamicForm(apiUrl,formType, formContainerId, formId, formStorageId, ajaxUrl, namespace);
		form.userInfo = userInfo;
		form.formLogicHandler = new SPFormLogicHandler(form);
		window.SPFormControl = new SPFormController(form);
		form.load({readOnly : readOnly});
		if(formStorageId != 0 && formStorageId != ""){
			form.mode = "edit";
		}else{
			form.mode = "create";
		}
		form1 = form;
	}
	
	
</aui:script>
<script>
var instance;
var actionPerformed = "Created";
function reloadOptions(thisInstance){
	instance = thisInstance;
}
function afterFormLoadedFormIOForm(thisInstance){
	instance = thisInstance;
}
function afterFormDataLoadedFormIOForm(thisInstance){
	
}
function afterPermissionsChecked(thisInstance){
	
}
function validateFormIOForm(thisInstance){
	thisInstance.customSubmission(thisInstance.form.submission);
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
		msg = "Record is saved in draft";
	}else if(formStorageId == "0"){
		msg = formTypeStr + " Created!";
	}
	 else if(actionPerformed == "Activated"){  //rajjan
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
	window.location.href = baseUrl;
}
function showActiveInactivePopup(thisInstance,status){
	console.log(thisInstance);
	if(status == 'Active'){
		var popupdiv = "#active-record";
		var popupdivbox = "#active-record-box";
		thisInstance.customSubmission(thisInstance.form.submission);
	}else if(status == 'Inactive' || status == 'Blacklist'){
		if(status == 'Inactive'){
			var popupdiv = "#deactive-record";
			var popupdivbox = "#deactive-record-box";
			var cacelBtn = '.popup-cancel-deactivate';
			var confirmBtn = '.popup-confirm-deactivate';
		}
		else if(status == 'Blacklist'){
			var popupdiv = "#blacklist-record";
			var popupdivbox = "#blacklist-record-box";
			var cacelBtn = '.popup-cancel-blacklist';
			var confirmBtn = '.popup-confirm-blacklist';
		}
		AUI().use('aui-base', function(A) {
	        
			   A.one(popupdiv).set('hidden', false);
			        
			     YUI().use('aui-modal', function(Y) {
			        var modal = new Y.Modal({
			                             boundingBox: popupdiv,
			                             contentBox: popupdivbox,
			                             headerContent: '',
			                             centered: true,
			                             destroyOnHide: false,
			                             modal: true,
			                             resizable: false,
			                             draggable: true,
			         }).render();
			        
			        
			         Y.all('.close').on(
			         	      'click',
			         	      function() {
			         	    	reload();
			         	        modal.hide();
			         	      }
			         	    );
			         Y.all(cacelBtn).on(
			         	      'click',
			         	      function() {
			         	        modal.hide();
			         	      }
			         	    );
			         
			         Y.one(confirmBtn).on(
			         	      'click',
			         	      function() {
			         	    	 	var inactiveReason = document.getElementById("deactivate_reason").value;
			         	    	 	thisInstance.form.submission.data.InactiveReason = inactiveReason;
			         	    	 	thisInstance.customSubmission(thisInstance.form.submission);
			         	        	modal.hide();
			         	      }
			         	    );
		         Y.one('.popup-reactivate').on(
		        		
								'click',
								function() {
			         	    	 	/* thisInstance.form.submission.data.Status = "Active";
			         	    	 	actionPerformed = "Activated";
			         	    	 	thisInstance.customSubmission(thisInstance.form.submission); */
			         	        	modal.hide();
								}
						); 

			         
			     });
			
			 });
	}	
	
	
}

function ajaxUploadCall(method, action, data, successHandler, failHandler) {
	var thisInstance = this;
	console.log(thisInstance);
    AUI().use('aui-base','aui-io-request-deprecated',function(A){
        var _data = {};
        _data[namespace + 'formId'] = form1.formId;
        if (thisInstance.mode == "edit" ||  (thisInstance.mode == "copy" && method == "GET" )) {
        	_data[namespace + 'formStorageId'] = form1.formStorageId;
        }else{
        	_data[namespace + 'formStorageId'] = "0";
        }
        _data[namespace + 'formType'] = form1.formType;
        _data[namespace + 'action'] = action;
        if (data) {
            _data[namespace + 'file'] = data;              
        }
        A.io.request(thisInstance.uploadUrl,{
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


</script>

