<%@page import="com.sambaash.platform.pe.PEDataSource"%>
<%@page import="com.sambaash.platform.pe.adapter.PEProcessStateDataAdapter"%>
<%@page import="com.liferay.portal.kernel.util.DateUtil"%>
<%@page import="org.apache.commons.lang.StringUtils"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.sambaash.platform.srv.model.Course"%>
<%@page import="com.sambaash.platform.srv.service.CourseLocalServiceUtil"%>
<%@ page import="com.sambaash.platform.srv.model.Product" %>
<%@ page import="com.sambaash.platform.srv.processbuilder.model.PEProcessState" %>
<%@ page import="com.sambaash.platform.srv.service.ProductLocalServiceUtil" %>

<%@ include file="/html/init.jsp" %>

<%
PEOutput output =(PEOutput) request.getAttribute(PEConstants.ATTR_OUTPUT);
PEProcessState processState = output.getProcessState();
PEDataSource dataSource = output.getDataSource();
PEProcessStateDataAdapter dataAdapter = PEProcessStateDataAdapter.getProcessStateDataAdapter(dataSource.getProcessState());

String numberOfParticipants = dataAdapter.getDataFromProcessState("numberOfParticipants");
String participantDetails = dataAdapter.getDataFromProcessState("participantDetails");

long processStateId = 0;
if (output.getProcessState() != null && output.getProcessState().getUserIdProcess() != 0) {
	processStateId = output.getProcessState().getSpPEProcessStateId();
}

String actionType = "submit";
if (processState.getNodeId() != output.getNodeId()) {
	// not current node, meaning this is a previous step
	actionType = "save";
}
%>

<portlet:actionURL name="process" var ="participantsSubmitUrl">
   <portlet:param name="action" value="participants"/>
</portlet:actionURL>

<jsp:include page="/html/formData.jsp"></jsp:include>

<style>
.particpantFormWrap{
	border:1px solid #666;
}

.particpantForminnerWrap{
	padding:20px;
}

.addMoreButton{
	text-align:right;
	margin:20px;
}

.participantSubmitDiv{
	text-align:left;
	    margin: 20px 0;
}

.participantSubmit{
	margin-top:10px;
}

.formFieldInstance{
	border:1px solid #efefef;
	padding:20px;
}

.participantCount{
	text-align:left;
	display:inline-block;
	width:49%;
}

.removeInstance{
	text-align:right;
	padding-bottom:10px;
	display:inline-block;
	width:49%;
}

.participantDetails{
	width: 50%;
	text-align: center;
	margin: 0 auto;
}

.validationMsg{
	text-align:left;
}
</style>

<div class="participantDetails">
<form id="particpantForm" action="<%= participantsSubmitUrl %>" method="POST" name="particpantForm">
<div class="particpantFormWrap">

	<div>
		<aui:input name="formData"  type="hidden"></aui:input>
		<aui:input name="processStateId"  type="hidden" value="<%= processStateId %>"></aui:input>
		<aui:input name="nodeId"  type="hidden" value="<%= output.getNodeId() %>"></aui:input>
		<aui:input name="classPK"  type="hidden" value="<%= output.getClassPk() %>"></aui:input>
		<aui:input name="classNameId"  type="hidden" value="<%= output.getClassNameId() %>"></aui:input>
		<aui:input name="processId"  type="hidden" value="<%= output.getProcessId() %>"></aui:input>
		<aui:input name="actionType"  type="hidden" value="<%=actionType%>"></aui:input>
		<input type="hidden" id="numberOfParticipants" name="numberOfParticipants" value="1">
		<div class="formFields" id="formFields">
		
		</div>
		<div class="addMoreButton">
			<input type="button" class="btn-default btn choose-btn" onclick="addFormFields('', '','','','')" value="Add more">
			
		</div>

	</div>

</div>
<div class="participantSubmitDiv">
<input type="button" class="btn-default btn participantSubmit choose-btn" onclick="submitForm()" value="Submit">
	
</div>
</form>
<div id="basicFormFields" class="hide">
		<div>
			<div class="participantCount" id="participantCount_"></div>
			<div class="removeInstance"><input type="button" class="" value="X" onclick="removeInstance(this)" id="removeInstance" style="border:none"></div>
		</div>
		
		<div class="has-float-label md-form">
		<input type="text" placeholder="First Name" maxlength="75" id="firstName_"/>
		 <label for="fistname">First Name</label>
  	</div>
  	
    <div class="has-float-label md-form">
    	<input type="text" placeholder="Last Name"  maxlength="75" id="lastName_"/>
	<label for="lastname">Last Name</label>
  	</div>
  	
  	
  	<input type="text" class="hide" id="emailAddressVerification"/>
  	<div class="has-float-label md-form">
  		<input type="text" maxlength="150" placeholder="Email Addrress"  id="email_"/>
		<label for="emailaddress">Email Address</label>
		<div id="emailValidationerror_" class="validationMsg error hide">Please enter a valid email</div>
  	</div>
  	
		
  	<div  class="has-float-label md-form">
  		<input type="text" placeholder="Mobile Number"  maxlength="20" id="mobileNumber_" />
		<label for="mobilenumber">Mobile Number</label>
		<div id="mobileNumbererror_" class="validationMsg error hide">Please enter numbers only</div>
  	</div>
  	
  	<div  class="has-float-label md-form">
  		<input type="text" placeholder="Designation"  maxlength="75" id="designation_" />
		<label for="mobilenumber">Designation</label>
  	</div>
  	
</div>
</div>

<script src="/SPProcessEngine-portlet/js/custom/enrollmentcourse/productsWithInventory.js?t=<%=DateUtil.newTime() %>">
</script>

<script>

var formFieldDetail = null;//${formFieldDetailListJSON};
function addFormFields(firstName, lastName, emailAddress,mobileNumber,designation){
	var instances = parseInt(document.getElementById('numberOfParticipants').value);
	var totalInstances = instances;
	var basicFormFieldsElms = document.getElementById("basicFormFields").innerHTML;
	
	var formFieldInstance = document.createElement("div");
	formFieldInstance.setAttribute("id","formFieldInstance"+totalInstances);
	formFieldInstance.setAttribute("class","formFieldInstance");
	formFieldInstance.innerHTML = basicFormFieldsElms;
	
	var formFieldElms = document.getElementById("formFields");
	formFieldElms.appendChild(formFieldInstance);
	
	var participantCount = document.getElementById("participantCount_");
	participantCount.setAttribute("id","participantCount_"+totalInstances);
	participantCount.innerHTML = "Participant " + totalInstances;
	var firstNameIp = document.getElementById("firstName_");
	firstNameIp.setAttribute("id","firstName_"+totalInstances);
	firstNameIp.setAttribute("name","firstName_"+totalInstances);
	var lastNameIp = document.getElementById("lastName_");
	lastNameIp.setAttribute("id","lastName_"+totalInstances);
	lastNameIp.setAttribute("name","lastName_"+totalInstances);
	var emailAddressIp = document.getElementById("email_");
	var emailId = "email_"+totalInstances;
	emailAddressIp.setAttribute("id",emailId);
	emailAddressIp.setAttribute("name","email_"+totalInstances);
	emailAddressIp.setAttribute("onblur","javascript:validateEmail('" +totalInstances + "')");
	var emailValidationerror = document.getElementById("emailValidationerror_");
	emailValidationerror.setAttribute("id","emailValidationerror_"+totalInstances);
	var mobileNumberIp = document.getElementById("mobileNumber_");
	mobileNumberIp.setAttribute("id","mobileNumber_"+totalInstances);
	mobileNumberIp.setAttribute("name","mobileNumber_"+totalInstances);
	mobileNumberIp.setAttribute("onblur","javascript:validateMobileNumber('" +totalInstances + "')");
	var mobileNumbererror = document.getElementById("mobileNumbererror_");
	mobileNumbererror.setAttribute("id","mobileNumbererror_"+totalInstances);
	var designationIp = document.getElementById("designation_");
	designationIp.setAttribute("id","designation_"+totalInstances);
	designationIp.setAttribute("name","designation_"+totalInstances);
	var removeIp = document.getElementById("removeInstance");
	removeIp.setAttribute("id",totalInstances);
	removeIp.setAttribute("name","removeInstance_"+totalInstances);
	document.getElementById("numberOfParticipants").value = instances + 1;
	
	document.getElementById("firstName_"+totalInstances).value=firstName?firstName:'';
	document.getElementById("lastName_"+totalInstances).value=lastName?lastName:'';
	document.getElementById("email_"+totalInstances).value=emailAddress?emailAddress:'';
	document.getElementById("mobileNumber_"+totalInstances).value=mobileNumber?mobileNumber:'';
	document.getElementById("designation_"+totalInstances).value=designation?designation:'';
	//return false;
}	

function removeInstance(obj){
	var inst = obj.getAttribute("id");
	var elmToRemove = document.getElementById("formFieldInstance"+inst);
	elmToRemove.remove();
}

function validateEmail(id){
	var exp=/^[a-z0-9!#$%&*+/=?^_`{|}~-]+(?:\.[a-z0-9!#$%&'*+/=?^_{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\.)+(?:[A-Z]{2}|com|org|net|edu|gov|mil|biz|info|mobi|name|aero|asia|jobs|museum)/;
	var emailElm;
	if(id != ""){
		emailElm = document.getElementById("email_"+id);
		var emailValid = document.getElementById("emailValidationerror_"+id);
		//
		if(emailElm){
			if(emailElm.value != ""){
				if(!exp.test(emailElm.value)) {
					emailValid.classList.remove("hide");
					return false;
				}else{
					emailValid.classList.add("hide");
					return true;
				}
			}else{
				return true;
			}	
		}	
	}else{
		var instCnt = document.getElementById("numberOfParticipants").value;
		var validity = false;
		for(var i=0;i<instCnt;i++){
			var emailElm = document.getElementById("email_"+id);
			if(emailElm){
				if(emailElm.value != ""){
					validity = validateEmail(i);
				}else{
					validity = true;
				}	
			}
		}
		return validity;
	}
}

function validateMobileNumber(id){
	var exp = /^[0-9]*$/;
	var mobElm;
	var validity = false;
	if(id != ""){
		mobElm = document.getElementById("mobileNumber_"+id);
		var mobValid = document.getElementById("mobileNumbererror_"+id);
		//
		if(mobElm){
			if(mobElm.value != ""){
				if(!exp.test(mobElm.value)) {
					mobValid.classList.remove("hide");
					return false;
				}else{
					mobValid.classList.add("hide");
					return true;
				}
			}else{
				return true;
			}	
		}	
	}else{
		var instCnt = document.getElementById("numberOfParticipants").value;
		for(var i=0;i<instCnt;i++){
			mobElm = document.getElementById("mobileNumber_"+id);
			if(mobElm){
				if(mobElm.value != ""){
					validity = validateMobileNumber(i);
				}else{
					validity = true;
				}	
			}
		}
		return validity;
	}
}

function submitForm(){
	var emailValdation = validateEmail('');
	var mobileValdation = validateMobileNumber('');
	if(emailValdation && mobileValdation){
		document.getElementById("particpantForm").submit();
	}
}


function initializeFormFields(){
	var numberOfParticipants = <%= StringUtils.isEmpty(numberOfParticipants)?"0": numberOfParticipants%>;
	var participantDetails = <%= StringUtils.isEmpty(participantDetails)?"[]": participantDetails%>;
	
	if (numberOfParticipants>0) {
		for (var index=0; index < participantDetails.length; index++) {
			var participant = participantDetails[index];
			if (Object.keys(participant).length > 0) {
	             var firstName = participant.firstName;
	             var lastName = participant.lastName;
	             var emailAddress = participant.email;
	             var mobileNumber = participant.mobile;
	             var designation = participant.designation;
	             addFormFields(firstName, lastName, emailAddress,mobileNumber,designation);				
			}
		}
	} else {
		addFormFields('', '','','','');
	}
}

AUI().ready(function(A) {
	initializeFormFields();
	var disabled = <%= !output.isCanEdit() && !output.isCanSubmit() %>;
	ProductsWithInventoryUtil.disableScreen(disabled);
});
</script>
