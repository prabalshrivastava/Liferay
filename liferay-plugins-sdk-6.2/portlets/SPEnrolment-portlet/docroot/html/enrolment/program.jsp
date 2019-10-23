<%@page import="com.sambaash.platform.enrolement.EnrolmentConstants"%>
<%@page import="org.apache.commons.lang.StringUtils"%>
<%@page import="com.liferay.portal.security.auth.AuthTokenUtil"%>
<%@ page import="com.sambaash.platform.util.PermissionUtil"%>
<%@ page import="com.sambaash.platform.util.SambaashUtil"%>
<%@ page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@ page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@ page import="javax.portlet.PortletRequest"%>
<%@ page import="com.sambaash.platform.constant.SystemSetupConstants"%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link rel='stylesheet' href='/html/css/hook.css?minifierType=css'>
<link rel='stylesheet' href='/html/css/sp/formio.full.min.css?minifierType=css'>

<link rel='stylesheet' href='<%=request.getContextPath()%>/css/main.css?<%=System.currentTimeMillis()%>'>

<script type="text/javascript" src="/html/js/sp/hook.js?<%=System.currentTimeMillis()%>" language="javascript1.2"></script>

<%@ taglib uri="/tld/sp-formio" prefix="sp-formio"%>

<c:set var="candidateId"	value='<%=request.getParameter("candidateId")%>' />

<portlet:defineObjects />
<liferay-theme:defineObjects />

<portlet:renderURL var="candidate">
	<portlet:param name="jspPage" value="/html/enrolment/candidate.jsp" />
	<portlet:param name="candidateId" value="${candidateId}" />
</portlet:renderURL>

<portlet:renderURL var="homePage">
	<portlet:param name="jspPage" value="/html/enrolment/view.jsp" />
</portlet:renderURL>

<portlet:renderURL var="fee">
	<portlet:param name="jspPage" value="/html/enrolment/fee.jsp" />
</portlet:renderURL>

<portlet:actionURL var="proceedToFees" name="proceedToFees">
</portlet:actionURL>

<portlet:resourceURL var="resourceURL" >
	<portlet:param name="sp_p_auth" value="<%= AuthTokenUtil.getToken(request) %>"/>
</portlet:resourceURL>
<c:set var="formStorageId" value='<%= request.getParameter("storageId") %>' />

<%
		String formId = portletPreferences.getValue(EnrolmentConstants.PREF_ENROLMENT_FORM_ID, EnrolmentConstants.DEFAULT_ENROLMENT_FORM_ID);
		if (StringUtils.isEmpty(formId)) {
			formId = EnrolmentConstants.DEFAULT_ENROLMENT_FORM_ID;
		}
		String cancelUrl = portletPreferences.getValue(EnrolmentConstants.PREF_ENROLMENT_CANCEL_URL, EnrolmentConstants.DEFAULT_ENROLMENT_CANCEL_URL);
		if (StringUtils.isEmpty(cancelUrl)) {
			cancelUrl = EnrolmentConstants.DEFAULT_ENROLMENT_CANCEL_URL;
		}
		String formType = "Enrolment";
		String dashBoardLink = SambaashUtil.getDashBoard();
		long userId = themeDisplay.getUserId();
		String candidateId = request.getParameter("candidateId");
		String sponsorshipType = request.getParameter("sponsorshiptype");
		String corporateName = request.getParameter("corporatename");
		String corporateCode = request.getParameter("corporatecode");
	String vm = (String) request.getParameter(EnrolmentConstants.VIEW_MODE_PARAM);
%>

<div class="newPortlets">
	<div class="subHeader">
		<div class="container">
			<div class="inner-container">
			<aui:row>
				<aui:col span="10" cssClass="text-center header-title">
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
	
					<div class="tab">CANDIDATE</div>
	
					<div class="tab tab-selected">PROGRAMME & SUBJECTS</div>
	
					<div class="tab">FEE</div>
				</div>
			</div>
			<div class="enrolment-center-align formComponent">
				<sp-formio:FormIO cssClass="formContainer" modelName="Enrolment"
				formId="<%= formId %>" readOnly="false" formStorageId="${formStorageId}"  />
			</div>
			<div class="text-center">
				<aui:button-row>
					<aui:button onClick="backToCandidate()" type="button"
						value="PREVIOUS" />
					<% if(PermissionUtil.canEditModel((PortletRequest) request.getAttribute("javax.portlet.request"))){ %>
					<aui:button type="submit" cssClass="btn-primary"
						value="NEXT" onClick="proceedToFee()"/>
					<aui:button type="submit" cssClass="btn-primary" disabled="false" 
						onClick="onSaveProgramm()" value="SAVE" id="saveBtn" />
					<% }else { %>
					<aui:button type="submit" cssClass="btn-primary"
						value="NEXT" onClick="proceedToFee1()"/>
					
					<% } %>
					<aui:button type="button" onClick="onCancelProcess()" value="CANCEL" />
				</aui:button-row>
			</div>
	
		</div>
	</div>
</div>

<script type="text/javascript">
	
	var mode = "edit";
	var feeUrl = "<%=fee%>";
	var candidateId = "<%=candidateId%>";
	var namespace = "<portlet:namespace/>";
	var candidateUrl = "<%=candidate%>";
	var homeUrl = "<%=cancelUrl%>";
	var formInstance;
	var EnrolmentId = "";
	var noUpdate = <%=EnrolmentConstants.VIEW_MODE.equals(vm) ? "true" : "false"%>;
	var sponsorshipType = "<%=sponsorshipType == null ? "" : sponsorshipType %>";
	var corporateName = "<%=corporateName == null ? "" : corporateName %>";
	var corporateCode = "<%=corporateCode == null ? "" : corporateCode %>";

	function shouldDisableForm(formInstance, enrolmentStatus) {
		// speficy in the array the statuses that will not make form enabled
		// e.g. form is enabled when status is Pending
		console.log("shouldDisableForm->"+enrolmentStatus);
		if (!noUpdate && ["PENDING"].indexOf(enrolmentStatus.toUpperCase()) > -1) {
// 			console.log("enabling form");
			if (formInstance.form.disabled) { formInstance.form.disabled = false; }
			AUI().one('#saveBtn').removeAttribute('disabled');
		} else {
// 			console.log("disabling form");
			noUpdate = true;
			formInstance.form.disabled = true;
			if (noUpdate) {
				AUI().one('#saveBtn').hide();
			} else {
				AUI().one('#saveBtn').setAttribute('disabled','true');
			}
		}
	}
	
	function afterFormDataLoadedFormIOForm(thisInstance) {
		if (thisInstance.form.data.enrolmentId) {
			EnrolmentId = thisInstance.form.data.enrolmentId;
			console.log("existing enrolmentId", EnrolmentId);
		}
		formInstance.components.candidateId.setValue(candidateId);
		shouldDisableForm(thisInstance, thisInstance.form.data.EnrolmentStatus);		
	}
	
	function afterFormLoadedFormIOForm(thisInstance) 
	{
		formInstance = thisInstance;
		formInstance.components.candidateId.setValue(candidateId);
		formInstance.on('partial', function(changePayload){
			if (changePayload.changed.component.key === "programSemester") {
				formInstance.components.subjects.setValue(null);
				var qbe = {
					"contentJson.candidateId" : "<%=candidateId%>",
					"contentJson.programSemester.storageId.keyword" : formInstance.form.data.programSemester.storageId
				};
				Liferay.Service(
				  '/SystemModelSetup-portlet.system/get-model-list',
				  {
				    modelName: 'enrolment',
				    fieldList: '',
				    groupId: <%=SambaashUtil.getScopeGroupId(themeDisplay.getScopeGroupId())%>,
				    matchJsonString: JSON.stringify(qbe),
				    sortString: ''
				  },
				  function(enrolmentList) {
				    if (enrolmentList && enrolmentList.length > 0 && enrolmentList[0].EnrolmentStatus && enrolmentList[0].EnrolmentStatus.toLocaleLowerCase() == "pending") {
			    		formInstance.components.enrolmentId.setValue(enrolmentList[0].storageId);
			    		formInstance.components.EnrolmentStatus.setValue(enrolmentList[0].EnrolmentStatus);
				    	var subjects = enrolmentList[0].subjects;
				    	console.log("got subjects");
				    	console.log(subjects);
				    	// cannot directly assign yet as select option is not yet existing at this point
				    	// use settimeout to assign data after promise had been resolved
				    	formInstance.components.subjects.setValue([]);
				    	setTimeout(function(){
				    		console.log("setting subjects");
				    		formInstance.components.subjects.setValue(subjects); 
				    		shouldDisableForm(formInstance,enrolmentList[0].EnrolmentStatus);
				    	});
				    } else {
			    		formInstance.components.enrolmentId.setValue(null);
			    		formInstance.components.EnrolmentStatus.setValue("Pending");
				    	setTimeout(function(){
				    		console.log("clearing subjects");
// 				    		formInstance.components.subjects.setValue([]); 
				    		shouldDisableForm(formInstance, "Pending");
				    	});
				    }
				  }
				);				
			}
		});
	}
	function saveProgramSubject(){
		var data1 = {"CandidateId":candidateId,"formType":"CandidateProgramme","ModelName":"CandidateProgramme",
				"programSemester":formInstance.components.programSemester.value,"subjects":formInstance.components.subjects.value,
				"EnrolmentStatus":formInstance.components.EnrolmentStatus.value,"enrolmentId":EnrolmentId,
				};
	 	
		ajaxCallAPI('POST','persist',data1,
			 function() {
					
	               var response = this.get("responseData");
	               
	               if (_.isEmpty(response)) {
	                   console.log("error");
	                   
	               } else {
	            	   var programSemester = formInstance.components.programSemester.data.programSemester.storageId;
	           		feeUrl += "&" + namespace + "programSemester="+ programSemester +
	           			"&" + namespace + "enrolmentId="+ formInstance.form.data.enrolmentId
	           			"&" + namespace + "candidateId="+ candidateId;
	           		feeUrl += "&" + namespace + "sponsorshiptype=" + sponsorshipType ;
	                if(corporateName)
	                {
	                	feeUrl += "&" + namespace + "corporatecode=" + corporateCode;
	                	feeUrl += "&" + namespace + "corporatename=" + corporateName;
	                }
	           		location.href = feeUrl;
	               }
	           },
	           function() {
	               
	    		});
		
		
	}
	
	function proceedToFee() 
	{	
		console.log("noUpdate",noUpdate);
		if(noUpdate) {
			proceedToFee1();
		} else {
			onSaveProgramm(function(){
				if (typeof candidateId !== 'undefined' || candidateId !== null) 
				{
					saveProgramSubject();
				}			
			});
		}
	}
	function proceedToFee1() {
		
		var _goToUrl = feeUrl + "&" + namespace + "programSemester=" + form1.components.programSemester.value.storageId + "&" + namespace + "enrolmentId=" + EnrolmentId + "&" + namespace + "candidateId="+ candidateId
		if (noUpdate) {
			_goToUrl += "&" + namespace + "_vm=000";
		}
		location.href = _goToUrl;
	}

	function onSaveProgramm(successCallback)
	{
		// trigger FormIO internal validation
    	formInstance.form.submitForm().then(result => {
    	  var ajaxUrl = '<%= resourceURL.toString() %>';
  		  var program = formInstance.form.data.programSemester.ModelRightDetails;
  		  var gotSelectedSubjects = formInstance.form.data.subjects[0] ? true : false;
  		  console.log("gotSelectedSubjects",gotSelectedSubjects,formInstance.form.data.subjects);

		  if (gotSelectedSubjects) {
			  var enrolment = {
				 "ModelName": "Enrolment",
				 "CandidateId": candidateId,
				 "programSemester": formInstance.form.data.programSemester,
				 "ScheduleCode": formInstance.components.programSemester.value.ScheduleCode,
				 "ProgrammeCode": formInstance.components.programSemester.value.ProgrammeCode,
				 "subjects": formInstance.form.data.subjects,
				 "RouteCode": formInstance.components.RouteCode.value,
				 "EnrolmentStatus" : formInstance.components.EnrolmentStatus.getValue()
			  };
			  var formStorageId = "0";
			  if (EnrolmentId) {
				  enrolment.enrolmentId = EnrolmentId;
				  formStorageId = enrolment.enrolmentId;
			  }
			  var fType = 
			  SambaashUtils.resourceActionWithParamsActionCall(ajaxUrl, 
					  "persist", {"<portlet:namespace/>formType":"Enrolment", "<portlet:namespace/>formStorageId":formStorageId},"POST", 
					  namespace, enrolment,
  			  function success() {
            	  formInstance.displayMessage('success', 'Enrolment saved.', 2000);
            	  var data = this.get("responseData");
            	  EnrolmentId = data.storageId;
            	  console.log('enrolment saved');
            	  formInstance.components.enrolmentId.setValue(data.storageId);
                  if (successCallback) {
                	  successCallback(data);
                  }
  			  });
		  } else {
			const _err = "No subjects to enrol.";
  			SPFormControl.displayComponentErrorMessage('subjects', _err, true);
  			formInstance.loading(false);
            return Promise.reject(_err);
		  }  		  
    	});
	}
	
	function backToCandidate() {
		var _gotoUrl;
		if (candidateId == "null" || candidateId == null) 
		{
			_gotoUrl = candidateUrl;
		} 
		else 
		{
			_gotoUrl = candidateUrl + "&" + namespace + "userId="+ candidateId;
		}
		if (noUpdate) {
			_gotoUrl += "&" + namespace + "_vm=000";
		}
		_gotoUrl += "&" + namespace + "sponsorshiptype=" + sponsorshipType ;
		location.href = _gotoUrl;
	}
	
	function onCancelProcess() {
		location.href = homeUrl;
	}
	
</script>
