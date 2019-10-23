<%@page import="com.sambaash.platform.pe.PEDataSource"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.json.JSONObject"%>
<%@page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.json.JSONArray"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Arrays"%>
<%@page import="com.sambaash.platform.pe.adapter.PEProcessStateDataAdapter"%>
<%@page import="com.sambaash.platform.pe.helpers.PEUrlHelper"%>
<%@page import="java.util.Iterator" %>
<%@page import="com.sambaash.platform.srv.processbuilder.service.PEProcessStateLocalServiceUtil" %>
<%@page import="com.sambaash.platform.srv.validation.service.SPStudentProgrammeLocalServiceUtil" %>
<%@page import="com.sambaash.platform.pe.error.PEErrors" %>
<%@page import="java.util.Date" %>
<%@page import="com.sambaash.platform.util.SambaashUtil" %>
<%@page import="com.sambaash.platform.util.LabelUtil" %>
<%@page import="com.sambaash.platform.constant.PEConstantsGlobal" %>

<%@ include file="/html/init.jsp" %>

<%

boolean allowedToTakeCourse = false;
String nric = StringPool.BLANK;
String email = StringPool.BLANK;
String programmeCode = StringPool.BLANK;
String outputValidationStr = StringPool.BLANK;
JSONObject outputValidation = JSONFactoryUtil.createJSONObject();

PEOutput output =(PEOutput) renderRequest.getAttribute(PEConstants.ATTR_OUTPUT);
PEDataSource dataSource = output.getDataSource();
PEProcessStateDataAdapter dataAdapter = PEProcessStateDataAdapter.getProcessStateDataAdapter(output.getDataSource().getProcessState());
//long enableTempStorageValidationStepNo = GetterUtil.getLong(portletPreferences.getValue(PEConstants.ENABLE_TEMP_STORAGE_VALIDATION_STEP_NUMBER, "0"));
boolean enableTempStorageValidation = GetterUtil.getBoolean(GetterUtil.getString(portletPreferences.getValue(PEConstants.ENABLE_TEMP_STORAGE_VALIDATION, dataAdapter.getDataFromProcessState("enableTempStorageValidation"))));
   //PEDataSource dataSource = (PEDataSource)request.getAttribute(PEConstants.ATTR_DATA_SOURCE);

long processStateId = 0;
String cancelUrl = "#";
if (output.getProcessState() != null && output.getProcessState().getUserIdProcess() != 0) {
	
	cancelUrl = PEUrlHelper.getUrlHelper(dataSource).getFormattedListingPageURL();
	processStateId = output.getProcessState().getSpPEProcessStateId();
	//long statusTypeId = output.getProcessState().getStatusTypeId();
	//long currentStepNo = PEProcessStatusTypeLocalServiceUtil.getPEProcessStatusType(statusTypeId).getSeqNo();
	//if(currentStepNo == enableTempStorageValidationStepNo){
		nric = dataAdapter.getDataFromProcessState("nric");
		email = dataAdapter.getDataFromProcessState("emailAddress");
		programmeCode = GetterUtil.getString(portletPreferences.getValue(PEConstants.PARAM_CLASS_PK_SAVED_CODE, dataAdapter.getDataFromProcessState("programmeCode")));
		outputValidationStr = SPStudentProgrammeLocalServiceUtil.getStudentProgramme(SambaashUtil.getScopeGroupId(themeDisplay.getScopeGroupId()), programmeCode, nric, email, new Date(), enableTempStorageValidation);
		outputValidation = JSONFactoryUtil.createJSONObject(outputValidationStr);
		allowedToTakeCourse = outputValidation.getBoolean("allowedToTakeCourse");
		
		if(!allowedToTakeCourse && outputValidation.length() > 0){
			//mark the application as inactive
			output.getProcessState().setActiveStatus(PEConstantsGlobal.ACTIVE_STATUS_IN_ACTIVE);
			SambaashUtil.fillAudit(output.getProcessState(), themeDisplay, false);
			PEProcessStateLocalServiceUtil.updatePEProcessState(output.getProcessState());
		}
	//}
}

//outputValidationStr = (String) renderRequest.getAttribute(PEConstants.ATTR_OUTPUT_VALIDATION);
//JSONObject outputValidation = JSONFactoryUtil.createJSONObject(outputValidationStr);


//if (outputValidation.length() == 0){
//	outputValidationStr = dataAdapter.getDataFromProcessState("outputValidationStr");
//	outputValidation = JSONFactoryUtil.createJSONObject(outputValidationStr);
//	allowedToTakeCourse = outputValidation.getBoolean("allowedToTakeCourse");
//}
String selectedSittingType = dataAdapter.getDataFromProcessState("sittingType");
String selectedSubject = dataAdapter.getDataFromProcessState("subject");
String selectedSubPricing = dataAdapter.getDataFromProcessState("selectedSubPricing");

%>

<style>
	.paymentMode {
	    display: inline-block !important;
	    width: 100% !important;
	}

	form.centered {
   		margin: 0 auto;
	}
	fieldset.centered {
	    width: 60% !important;
	    margin: auto !important;
	    border: 0 !important;
	}
	.centered {
   		margin: 0 auto;
   		text-align: center;
	}
	.button-holder.centered {
    	display: table;
    	    margin-bottom: 10px;
	}
</style>

<portlet:actionURL name="process" var ="subjectSelectionUrl">
   <portlet:param name="action" value="subjectSelection"/>
</portlet:actionURL>

<jsp:include page="/html/formData.jsp"></jsp:include>

<aui:form action="<%= subjectSelectionUrl %>" id="subjectselectionForm" name="subjectselectionForm" cssClass="centered">
		<aui:input name="formData"  type="hidden"></aui:input>
		<aui:input name="processStateId"  type="hidden" value="<%= processStateId %>"></aui:input>
		<aui:input name="nodeId"  type="hidden" value="<%= output.getNodeId() %>"></aui:input>
		<aui:input name="classPK"  type="hidden" value="<%= output.getClassPk() %>"></aui:input>
		<aui:input name="classNameId"  type="hidden"  value="<%= output.getClassNameId() %>"></aui:input>
		<aui:input name="processId"  type="hidden" value="<%= output.getProcessId() %>"></aui:input>
		<aui:input name="outputValidationStr"  type="hidden" value="<%= outputValidationStr %>"></aui:input>
		<aui:input name="enableTempStorageValidation"  type="hidden" value="<%= enableTempStorageValidation %>"></aui:input>
		<aui:input name="selectedSubPricing" id="selectedSubPricing"  type="hidden"></aui:input>
		<aui:input name="actionType"  type="hidden" value="submit"></aui:input>
		

	<div class="paymentModeDiv hide subjectSelectionDiv" id="subjectSelectionDiv">
		<p id="sittingTypeErrorDiv" class="hide"></p>
		<p id="subjectErrorDiv" class="hide"></p>
		<label for="sittingType">A. Select an Exam Sitting Type</label>
	    <fieldset class="paymentMode centered" id="sittingType">
	        
	       
	    </fieldset>
	    <label for="subject">B. Select the Papers to be taken</label>
	    <fieldset class="paymentMode centered" id="subject">
	    
	    </fieldset>
	<div class="has-float-label marginTop30">
   		<button type="button" class="btn btn-default choose-btn"  onclick="return submitSubjectSelection()" >Submit</button>
   
   </div>
   </div>
   <div class="failureMessage hide" id="failureMessage">
   <img src="/SPProcessEngine-portlet/images/warning.png">
   
   </div>
   <div class="has-float-label marginTop30 hide" id="exitButton">
   		<button type="button" onclick="location.href='<%= cancelUrl %>';" class="btn btn-default choose-btn">Exit</button>
   </div>
</aui:form>
 

<script type="text/javascript">

var ns = '<portlet:namespace />';
var elementSittingType = document.getElementById("sittingType");
var elementSubject = document.getElementById("subject");

var formSubmissionRequestInitiatedOnce = false;
var fieldStr = "<%= outputValidation.getString("field")%>";
var fullSittingStr = "<%= outputValidation.getString("fullSitting")%>";
var modularSittingStr = "<%= outputValidation.getString("modularSitting")%>";
 
var selectedSittingType = "<%= selectedSittingType%>";
var selectedSubject = "<%= selectedSubject%>";
var selectedSubPricing = "<%= selectedSubPricing%>";

var fieldStrArr = new Array();
fieldStrArr = fieldStr.split(",");

AUI().ready(function(A) {

for(var i = 0; i < fieldStrArr.length; i++) {
	var divElement = document.createElement("div");
	divElement.setAttribute("class",'paymentMode');
	
	var inputElement = document.createElement("input");
	
	inputElement.setAttribute("type", "radio");
	inputElement.setAttribute("value", fieldStrArr[i].trim());
	inputElement.setAttribute("name", "sittingType");
	inputElement.setAttribute("id", fieldStrArr[i].trim());
	inputElement.setAttribute("class", "Requiredfield");
	
		
	var labelElement = document.createElement("label");
	labelElement.setAttribute("for", fieldStrArr[i].trim());
	labelElement.setAttribute("id", fieldStrArr[i].trim()+"Label");
	
	
	if (fullSittingStr.includes("enabled") && modularSittingStr.includes("enabled")){
		
	}else{
		inputElement.setAttribute("disabled",true);
		var inputElementHidden = document.createElement("input");
		
		inputElementHidden.setAttribute("type", "radio");
		inputElementHidden.setAttribute("value", fieldStrArr[i].trim());
		inputElementHidden.setAttribute("name", "sittingType_hidden");
		inputElementHidden.setAttribute("id", fieldStrArr[i].trim()+"_hidden"); 
		inputElementHidden.style.display = "none";
		divElement.appendChild(inputElementHidden);
	}
	
    
	divElement.appendChild(inputElement);
	divElement.appendChild(labelElement);
	elementSittingType.appendChild(divElement);
	
	
}


<% if (allowedToTakeCourse && outputValidation.length() > 0) { %>
var jsonData = JSON.parse('<%= outputValidation.getJSONArray("subject").toString()%>');


	for(var j = 0; j < jsonData.length; j++){
	    for(var key in jsonData[j]){
	        if(jsonData[j].hasOwnProperty(key)){
	           
	           
		        var divElement = document.createElement("div");
		       	divElement.setAttribute("class",'paymentMode');
		       	
		        var inputElement = document.createElement("input");
	
		        	if (fullSittingStr.includes("enabled")){
			        	inputElement.setAttribute("type", "checkbox");
			        }else{
			        	inputElement.setAttribute("type", "radio");
			        }
		        	
		        	if (selectedSittingType.includes("full")){
			        	inputElement.setAttribute("type", "checkbox");
		        	}else if (selectedSittingType != ""){
		        		inputElement.setAttribute("type", "radio");
		        	}
		       	
		       	inputElement.setAttribute("value", jsonData[j][key]);
		       	inputElement.setAttribute("name", "subject");
		       	inputElement.setAttribute("id", "subject_"+key);
		       	inputElement.setAttribute("class", "subjectOptions");
		       	inputElement.setAttribute("code", key);

		       	
		       	var labelElement = document.createElement("label");
		       	labelElement.setAttribute("for", "subject_"+key);
		       	labelElement.innerHTML = jsonData[j][key];
		       
		       	divElement.appendChild(inputElement);
		       	divElement.appendChild(labelElement);
		       	elementSubject.appendChild(divElement);
		       	
		        }
		}
	}
	
	<%}%>
	
	
	

	
	if (selectedSittingType != ""){
		for(var i=0; i <document.getElementsByName('sittingType').length; i++){
			var elem = document.getElementsByName('sittingType')[i];
			if (elem.value == selectedSittingType){
				elem.setAttribute("checked","");
			}
		}
		
		for(var i=0; i <document.getElementsByName('sittingType_hidden').length; i++){
			var elem = document.getElementsByName('sittingType_hidden')[i];
			if (elem.value == selectedSittingType){
				elem.setAttribute("checked","");
			}
		}
	}else if (fullSittingStr.includes("disabled") && modularSittingStr.includes("enabled")){
		A.one("#modularSitting").setAttribute("checked","");
		A.one("#modularSitting_hidden").setAttribute("checked","");
	}else if (fullSittingStr.includes("enabled") && modularSittingStr.includes("disabled")){
		A.one("#fullSitting").setAttribute("checked","");
		A.one("#fullSitting_hidden").setAttribute("checked","");
	}
	
	if (selectedSubject != ""){
		var selectedSubjectArr = new Array();
		selectedSubjectArr = selectedSubject.split(",");
		for(var i = 0; i < selectedSubjectArr.length; i++) {
			for(var j=0; j < document.getElementsByName('subject').length; j++){
				var elem = document.getElementsByName('subject')[j];
				if (elem.value == selectedSubjectArr[i].trim()){
					elem.setAttribute("checked","");
				}
			}
		}
	}else{
		if (fullSittingStr.includes("disabled") && modularSittingStr.includes("enabled")){
			
			<%
			if (allowedToTakeCourse && outputValidation.length() > 0){
			JSONArray subjectArr = outputValidation.getJSONArray("subject");
			for (int i = 0; i < subjectArr.length(); i++){
				JSONObject jsonObject = subjectArr.getJSONObject(i);
				Iterator<String> keysIt = jsonObject.keys();
				while(keysIt.hasNext()) {
					String key = keysIt.next();
					String subjectEnable = outputValidation.getString(key);%>
					
					for(var j=0; j < document.getElementsByName('subject').length; j++){
						var elem = document.getElementsByName('subject')[j];
						
						if (elem.getAttribute("code") == "<%= key%>"){
							if ("<%= subjectEnable%>".includes("enabled")){
								elem.setAttribute("checked","");
							}
						}
					}

				<%	} } }%>

		}else if (fullSittingStr.includes("enabled") && modularSittingStr.includes("disabled")){
			A.all('.subjectOptions').setAttribute("checked","");
		}
	}
	
	
	<%
	String labelNames = outputValidation.getString("field");
	List<String> items = Arrays.asList(labelNames.split(","));
	for (String item : items){
	String labelPricingSubScheme = item + "PricingSubScheme";
	String labelName = item + "Label";
	
	String val1 = outputValidation.getString(labelName.trim());
	String val2 = outputValidation.getString(labelPricingSubScheme.trim());
	%>

	var d = document.getElementById("<%= labelName.trim()%>");
	d.innerHTML = "<%= val1%>";
	
	
	
	var a = document.getElementById("<%= item.trim()%>");
	if (selectedSubPricing != ""){
		document.getElementById(ns+"selectedSubPricing").value = "<%= selectedSubPricing%>";
	}else{
		if (a){
			if(a.checked){
			document.getElementById(ns+"selectedSubPricing").value = "<%= val2%>";
			}
		}
	}
	
	

<%	
	}
%>

var rad = document.getElementsByName('sittingType');
for (var i = 0; i < rad.length; i++) {
	rad[i].addEventListener('change', function(){
		
	for(var j=0; j < document.getElementsByName('subject').length; j++){
		if (this.value.includes("full")){
			document.getElementsByName('subject')[j].setAttribute("type","checkbox");
			A.all('.subjectOptions').setAttribute("checked","");
		}else{
			document.getElementsByName('subject')[j].setAttribute("type","radio");
			A.all('.subjectOptions').removeAttribute("checked");
		}
	}
	
	if(formSubmissionRequestInitiatedOnce){
		validateSittingType();
		validateSubject();
	}
	
	
	<%
		for (String item : items){
			String labelPricingSubScheme = item.trim() + "PricingSubScheme";
			String val2 = outputValidation.getString(labelPricingSubScheme.trim());
		%>
		
			if(this.id == "<%= item.trim()%>"){
				document.getElementById(ns+"selectedSubPricing").value =  "<%= val2%>";
			}
	<%}%>
	
	
});
}


<%
if (allowedToTakeCourse && outputValidation.length() > 0){
JSONArray subjectArr = outputValidation.getJSONArray("subject");
for (int i = 0; i < subjectArr.length(); i++){
	JSONObject jsonObject = subjectArr.getJSONObject(i);
	Iterator<String> keysIt = jsonObject.keys();
	while(keysIt.hasNext()) {
		String key = keysIt.next();
		String subjectEnable = outputValidation.getString(key);%>
		
		for(var j=0; j < document.getElementsByName('subject').length; j++){
			var elem = document.getElementsByName('subject')[j];
			
			elem.addEventListener('change', function(){
				if(formSubmissionRequestInitiatedOnce){
					validateSubject();
				}
			});
			
			if (elem.getAttribute("code") == "<%= key%>"){
				if ("<%= subjectEnable%>".includes("disabled")){
					elem.setAttribute("disabled",true);
				}else{
					elem.classList.add("Requiredfield");
				}
			}
		}

	<%	} } }%>


	
	var disabled = <%= !output.isCanEdit() && !output.isCanSubmit() %>;
	if (disabled != undefined && disabled==true) {
		A.all("input,select,button,textarea").each(function(node){
			node.set("disabled",disabled);
		});
	}
	
	<% if(!allowedToTakeCourse && outputValidation.length() > 0){ %>
	
	var error = document.createElement("p");
	error.setAttribute("class","msg");
	error.innerHTML="You are not allowed to take this Exam. Contact RELC office.";
	
	<%	JSONArray subjectArr = outputValidation.getJSONArray("subject");
		int subLength = subjectArr.length();
		int countEnabled = 0; 
		int countDisabled = 0; 
		for (int i = 0; i < subjectArr.length(); i++){
			JSONObject jsonObject = subjectArr.getJSONObject(i);
			Iterator<String> keysIt = jsonObject.keys();
			while(keysIt.hasNext()) {
				String key = keysIt.next();
				String subjectEnable = outputValidation.getString(key);
				if (subjectEnable.contains("enabled")){
					countEnabled++;
				}else{
					countDisabled++;
				}
				
				}
			} 
		
		if (countEnabled == subLength){%>
			error.innerHTML="<%= LabelUtil.getLabel(pageContext, themeDisplay,"temp.storage.validation.error.msg2")%>";
		<%}else if (countDisabled == subLength){%>
			error.innerHTML="<%= LabelUtil.getLabel(pageContext, themeDisplay,"temp.storage.validation.error.msg1")%>";
		<%}%>
		document.getElementById("failureMessage").appendChild(error);
		document.getElementById("failureMessage").classList.remove("hide");
		document.getElementById("exitButton").classList.remove("hide");
	<%}else{%>
		document.getElementById("failureMessage").classList.add("hide");
		document.getElementById("subjectSelectionDiv").classList.remove("hide");
		document.getElementById("exitButton").classList.add("hide");
		
	<%}%>
	
});


var validateSittingType = function(){
	var contextNode = A.one("#subjectSelectionDiv");
	var nodes = contextNode.all("input[name=sittingType]");
	var result = false;
	var errorDivId = "";
	
	
	for(var i=0; i < nodes.size(); i++){
	var node = nodes.getDOMNodes()[i];
	var cn = node.getAttribute("class");
	errorDivId = fetchErrorDiv(node); 
	var errorDiv = A.one("#" + errorDivId);
	errorDiv.html("");
	errorDiv.addClass("hide");
	if(cn){
		if(cn.includes("Requiredfield")){
			var checked = node.checked;
			if(!checked){
				result = true;
				displayError(result, errorDivId, '<p class="portlet-msg-error">Please select sitting type</p>');
			}else{
				result = false;
				break;
			}

		}
	}
	};
	return result;
}

var validateSubject = function(){
	var contextNode = A.one("#subjectSelectionDiv");
	var nodes = contextNode.all("input[name=subject]");
	var result = false;
	var errorDivId = "";
	var errorMsg = "";
	
	for(var i=0; i < nodes.size(); i++){
	var node = nodes.getDOMNodes()[i];
	var cn = node.getAttribute("class");
	errorDivId = fetchErrorDiv(node); 
	var errorDiv = A.one("#" + errorDivId);
	errorDiv.html("");
	errorDiv.addClass("hide");
	if(cn){
		if(cn.includes("Requiredfield")){
			var checked = node.checked;
			
			
			if (node.type == "checkbox"){
				if(!checked){
					result = true;
					errorMsg = '<p class="portlet-msg-error">Please select all subjects</p>';
					displayError(result, errorDivId, errorMsg);
					break;
				}
			}else{
				if(!checked){
					result = true;
					errorMsg = '<p class="portlet-msg-error">Please select subject</p>';
					displayError(result, errorDivId, errorMsg);
				}else{
					result = false;
					break;
				}
			}

		}
	}
	};
	return result;
}




var displayError = function(result, errorDivId, errorMsg){
	var errorDiv = A.one("#" + errorDivId);
	if(result){
		errorDiv.html(errorMsg);
		errorDiv.removeClass("hide");
	}
	else{
		errorDiv.html("");
		errorDiv.addClass("hide");
	}
}

var fetchErrorDiv = function(node){
	return node.name + "ErrorDiv";
}



var submitSubjectSelection = function (){
	formSubmissionRequestInitiatedOnce = true;
	var result1 = validateSittingType();
	var result2 = validateSubject();
	if(!result1 && !result2){
		document.getElementById(ns+"subjectselectionForm").submit();
		return false;
	}
	
	
	
}



</script>



		
