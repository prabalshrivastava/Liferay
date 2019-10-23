<%@page import="com.sambaash.platform.enrolement.EnrolmentConstants"%>
<%@page import="org.apache.commons.lang.StringUtils"%>
<%@page import="com.sambaash.platform.util.SambaashUtil"%>
<%@page import="com.sambaash.platform.constant.SystemSetupConstants"%>
<%@ include file="/html/init.jsp" %>

<%@ page import="java.io.*,java.util.*"%>

<portlet:renderURL var="program">
	<portlet:param name="jspPage" value="/html/enrolment/program.jsp" />
</portlet:renderURL>

<portlet:renderURL var="sponsor" copyCurrentRenderParameters="true">
	<portlet:param name="jspPage" value="/html/enrolment/sponsorship.jsp" />
</portlet:renderURL>

<portlet:renderURL var="homePage">
  <portlet:param name="jspPage" value="/html/enrolment/view.jsp" />
</portlet:renderURL>


<%
	String formId = portletPreferences.getValue(EnrolmentConstants.PREF_CANDIDATE_FORM_ID, EnrolmentConstants.DEFAULT_CANDIDATE_FORM_ID);
	if (StringUtils.isEmpty(formId)) {
		formId = EnrolmentConstants.DEFAULT_CANDIDATE_FORM_ID;
	}
	String cancelUrl = portletPreferences.getValue(EnrolmentConstants.PREF_ENROLMENT_CANCEL_URL, EnrolmentConstants.DEFAULT_ENROLMENT_CANCEL_URL);
	if (StringUtils.isEmpty(cancelUrl)) {
		cancelUrl = EnrolmentConstants.DEFAULT_ENROLMENT_CANCEL_URL;
	}
	String formType = "Candidate";
	String dashBoardLink = SambaashUtil.getDashBoard();
	String userId;
	String sponsorshipType = request.getParameter("sponsorshiptype");
	String corporateName = request.getParameter("corporatename");
	String corporateCode = request.getParameter("corporatecode");
	String enrolmentIdParam = request.getParameter("enrolmentId");
	if(Validator.isNotNull(request.getParameter("userId"))) {
		userId = request.getParameter("userId");
	}else{
		userId = "0";
	}
	String vm = (String) request.getParameter(EnrolmentConstants.VIEW_MODE_PARAM);
%>

<div class="newPortlets">

	<div class="subHeader">
		<div class="container">
			<div class="inner-container">
				<aui:row>
					<aui:col span="10" cssClass="text-center">
						<h2><span>PROCESS ENROLMENT</span></h2>
					</aui:col>
					<aui:col span="2" cssClass="text-right header-home-link">
						<a href="<%=dashBoardLink%>" title="Back to Home">Back to Home</a>
					</aui:col>
				</aui:row>
			</div>
		</div>
	</div>
	<div class="enrolment-body enrolment-center-align">

	<div class="container">
		<div class="text-center">
			<div class="enrolment-center-align tabs mt-50">
				<div class="tab ">SPONSORSHIP</div>

				<div class="tab tab-selected">CANDIDATE</div>

				<div class="tab">PROGRAMME & SUBJECTS</div>

				<div class="tab">FEE</div>
			</div>
		</div>

		<div class="enrolment-center-align formComponent">
			<sp-formio:FormIO cssClass="formContainer" modelName="<%=formType%>"
				formId="<%=formId%>" readOnly="false"
				formStorageId="<%=userId%>" />
		</div>

		<div class="text-center">
			<aui:button-row>
				<aui:button onClick="backToSponsor()" type="button" value="PREVIOUS" />
				<% if(PermissionUtil.canEditModel((PortletRequest) request.getAttribute("javax.portlet.request"))){ %>
				<aui:button onClick="proceedToProgram()" cssClass="btn-primary"
					type="button" value="NEXT" />
					<% if(EnrolmentConstants.VIEW_MODE.equals(vm)) {%>
						<aui:button cssClass="btn-primary hidden" disabled="false" type="button"
							onClick="save()" value="SAVE" />
					<% } else {%>
						<aui:button cssClass="btn-primary" disabled="false" type="button"
							onClick="save()" value="SAVE" />
					<% }%>
				<% }else { %>
				<aui:button onClick="proceedToProgram1()" cssClass="btn-primary"
					type="button" value="NEXT" />
				<% } %>
				
				
				<aui:button type="button" onClick="onCancelProcess()" value="CANCEL" />
			</aui:button-row>
		</div>
	</div>
</div>
</div>

<script type="text/javascript">
	var scopeGroupId = "<%=SambaashUtil.getScopeGroupId(themeDisplay.getScopeGroupId())%>"; 
	var candidateId = "<%=userId%>"; 
	var formId = "<%=formId%>"; 
	var programUrl = "<%=program%>";
	var sponsorUrl = "<%=sponsor%>";
	var enrolmentIdParam = '<%= enrolmentIdParam == null ? "" : enrolmentIdParam %>';
	var sponsorshipType = "<%=sponsorshipType == null ? "" : sponsorshipType %>";
	var corporateName = "<%=corporateName == null ? "" : corporateName %>";
	var corporateCode = "<%=corporateCode == null ? "" : corporateCode %>";
	var namespace = "<portlet:namespace/>";
	var mode = candidateId === '0' && candidateId=="null" ? "create" : "edit";
	var homeUrl = "<%=cancelUrl%>";
	var buttonClick;
	var isFormSaved = false;
	var existingEnrolmentId = enrolmentIdParam ? enrolmentIdParam : 0;
	var isEditMode = candidateId && candidateId !=='null' && candidateId !== '0'
	var instance;
	//document.getElementsByClassName("submitFormButton").style.display = "none";
	var vm = "<%=vm%>";
	var isViewMode = vm === "000";

	function afterFormLoadedFormIOForm(thisInstance) {
		instance = thisInstance;

		instance.components["SponsorshipType"].setValue(sponsorshipType);
		instance.components["CorporateName"].setValue(corporateName);
		instance.components["CorporateCode"].setValue(corporateCode);
		
		instance.on("persistFailed", function(response) {
			console.log("Got Persist Failure response: ");
			console.log(response);
			return Promise.reject(response);
		});
// 		checkExistingEnrolment(candidateId);
		if (isViewMode) {
			thisInstance.form.disabled = true;
		}
	}
	function afterFormDataLoadedFormIOForm(thisInstance){
		if(sponsorshipType){
			SPFormControl.setValue("SponsorshipType", sponsorshipType, true, true);
		} else {
			SPFormControl.setValue("SponsorshipType", "Individual", true, true);
		}
		if (corporateCode) {
			SPFormControl.setValue("CorporateName", corporateName, true, true);
			SPFormControl.setValue("CorporateCode", corporateCode, true, true);			
		}
		if (isViewMode) {
			thisInstance.form.disabled = true;
			AUI().all(".formio-component-panel5EditGrid .btn").each( (b) => b.hide() )
		}
	}
	
	function validateFormIOForm(thisInstance) {
		var validRecord = true;
		var errorMsg = "Validation issue";
		if((thisInstance.components.IDNumber.value == thisInstance.components.IDNumber2.value) && 
				(thisInstance.components.IDType.value == thisInstance.components.IDType2.value)){
			validRecord = false;
			errorMsg = "IDNumber and IDNumber2 should not be same";
		}else if(thisInstance.components.ContactNumberSingapore.value.length < 5 && thisInstance.components.ContactNumberOthers.value.length < 5 ){
			validRecord = false;
			errorMsg = "Contact Number required";
		}
		else if(thisInstance.components.Country.value == "Singapore" && ( 
				(thisInstance.components.HouseBlockNo.value.length < 2) || (thisInstance.components.StreetName.value.length < 4) )){
			validRecord = false;
			errorMsg = "Address details required";
		}
		
		if(!validRecord){
			form1.displayMessage("error",errorMsg);
		}
		else{
			
			// trigger FormIO internal validation
	    	thisInstance.form.submitForm().then(result => {
	    		if (thisInstance.form.data.panel5EditGrid.length < 1) {
	    			const _err = "SRN Number is required";
	    			SPFormControl.displayComponentErrorMessage('panel5EditGrid', _err, true);
		        	thisInstance.loading(false);
		            return Promise.reject(_err);
	    		}
	            var dataValue = result.submission;
	            // if all valid in formio, do business logic
				var formdata = thisInstance.form.submission.data;
				console.log(formdata);
				if (!isEditMode) {
					// do pre-validation for create
					Liferay.Service(
							  '/SPMicroservice-portlet.spmicroservice/validate-candidate',
					  {
					    scopeGroupId: scopeGroupId,
					    candidateJsonString: JSON.stringify(formdata)
					  },
					  function(response) {
						  if (response.error) {
							thisInstance.displayResponseErrors(response.error);
						  } else {
							// pre-validation of candidate passed
							// create Liferay user
							ajaxCallAPI(
									'POST',
									'createUser',
									formdata,
									function() {
										var responseUserId = this.get("responseData");
										candidateId = responseUserId;
										console.log("created user with ID: "+responseUserId);
										// then create candidate model
										thisInstance.components["UserId"].setValue(responseUserId);
										thisInstance.components["SponsorshipType"].setValue(sponsorshipType);
										thisInstance.components["CorporateName"].setValue(corporateName);
										thisInstance.components["CorporateCode"].setValue(corporateCode);
										thisInstance.components["EnrolmentStatus"].setValue("Pending");
										thisInstance.components["FormId"].setValue(formId);
										thisInstance.customSubmission(thisInstance.form.submission);
										thisInstance.loading(false);
										return Promise.resolve(dataValue);
									}, function() {
										var err = this.get("responseData");
										thisInstance.loading(false);
										return Promise.reject(err);
							});
						  }
					  }
					);				
				} else {
					// update candidate model
					console.log("updating candidate model",thisInstance.form.submission,thisInstance.form.data);
					thisInstance.customSubmission(thisInstance.form.submission);
					thisInstance.loading(false);
					return Promise.resolve(dataValue);
				}
	          }).catch(err => {
	        	thisInstance.form.onSubmissionError(err);
	        	thisInstance.loading(false);
	            return Promise.reject(err);
	          });
		}
		
	}

	function afterFormSubmissionFormIOForm(thisInstance)
	{
		isFormSaved = true;
		if(buttonClick =="next" && isFormSaved)
		{
			var url = programUrl;
			if(candidateId==="null"){
				
			}else{
				url += "&" + namespace + "candidateId=" + candidateId; 
				if(existingEnrolmentId != 0){
					url += "&" + namespace + "storageId=" + existingEnrolmentId;
				}
				url += "&" + namespace + "sponsorshiptype=" + sponsorshipType ;
		        if(corporateName && corporateName !== 'null')
		        {
		        	url += "&" + namespace + "corporatecode=" + corporateCode;
		        	url += "&" + namespace + "corporatename=" + corporateName;
		        }
			}
			location.href = url;
		}
	}
	
	function createCandidate(thisInstance)
	{
		var email = instance.form.submission.data.PrimaryEmailAddress;
		
		ajaxCallAPI(
				'GET',
				'searchList',
				email,
				function() {
					var response = this.get("responseData");
					if (response){
						candidateId = response.userId;
						instance.components["UserId"].setValue(response.userId);
						instance.components["EnrolmentStatus"].setValue("Pending");
						instance.components["SponsorshipType"].setValue(sponsorshipType);
						instance.components["CorporateName"].setValue(corporateName);
						instance.components["CorporateCode"].setValue(corporateCode);
						instance.components["FormId"].setValue(formId);
						instance.components["UserId"].setValue(candidateId);
						
						thisInstance.customSubmission(instance.form.submission);
					}
				}, function() {
					
		});
	}
	function checkExistingEnrolment(candidateId)
	{
		if(candidateId != "0" && candidateId != ""){
			var data1 = {"CandidateId":candidateId,"endPoint":"checkExistingEnrolment","formType":"Enrolment"};
		 	
			ajaxCallAPI('POST','sendRequest',data1,
			 function() {
	               var response = this.get("responseData");
	               
	               if (_.isEmpty(response)) {
	                   console.log("error");
	                   
	               } else {
	            	   existingEnrolmentId = response.enrolmentId;
	               }
	           },
	           function() {
	               
	    		});
		}
		
		
	}
	
	function checkExistingCandidate(){
		var email = instance.form.submission.data.PrimaryEmailAddress;
		ajaxCallAPI(
				'GET',
				'searchList',
				email,
				function() {
					var response = this.get("responseData");
					if (response){
						form1.displayMessage("error","Student already exists");
					}
					else
					{
						document.getElementsByClassName("submitFormButton")[1].click();
						buttonClick = "save";
					}
				}, function() {

				});
		
	}
	
	function proceedToProgram() {
		if(isFormSaved == true || isViewMode)
		{
			proceedToProgram1();
		}
		if (!isViewMode) {
			document.getElementsByClassName("submitFormButton")[1].click();
			buttonClick = "next";
		}
	}
	function proceedToProgram1() {
		var link = programUrl + "&" + namespace + "candidateId=" + candidateId + "&" + namespace + "storageId=" + existingEnrolmentId;
        if (isViewMode) {
        	link += "&" + namespace + "_vm=000";
        }
        link += "&" + namespace + "sponsorshiptype=" + sponsorshipType ;
        if(corporateName && corporateName !== 'null')
        {
        	link += "&" + namespace + "corporatecode=" + corporateCode;
        	link += "&" + namespace + "corporatename=" + corporateName;
        }
        location.href = link;
	}
	
	function save(){
// 		checkExistingCandidate();
		document.getElementsByClassName("submitFormButton")[1].click();
		buttonClick = "save";
	}
	
	function backToSponsor() {
		console.log("back to sponsor", form1.components.SponsorshipType.value, sponsorshipType);
		sponsorUrl += "&" + namespace + "sponsorshiptype=" + (form1.components.SponsorshipType.value && "null" !== form1.components.SponsorshipType.value ? form1.components.SponsorshipType.value : sponsorshipType);
		if(candidateId && candidateId !== "null"){
			sponsorUrl += "&" + namespace + "candidateId=" + candidateId;
		}
        if (isViewMode) {
        	sponsorUrl += "&" + namespace + "_vm=000";
        }
        if(form1.form.data.CorporateCode && form1.form.data.CorporateCode !== 'null')
        {
        	sponsorUrl += "&" + namespace + "corporatecode=" + form1.form.data.CorporateCode;
        	sponsorUrl += "&" + namespace + "corporatename=" + form1.form.data.CorporateName;
        }
        if (enrolmentIdParam) {
        	sponsorUrl += "&" + namespace + "enrolmentId=" + enrolmentIdParam;
        }
		location.href = sponsorUrl;
	}
	function onCancelProcess() {
		location.href = homeUrl;
	}
</script>

