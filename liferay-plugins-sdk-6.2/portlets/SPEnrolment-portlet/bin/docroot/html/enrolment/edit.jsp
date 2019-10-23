<%@page import="org.apache.commons.lang.StringUtils"%>
<%@page import="com.sambaash.platform.enrolement.EnrolmentConstants"%>
<%@page import="com.sambaash.platform.util.PermissionUtil"%>
<%@page import="com.sambaash.platform.util.SambaashUtil"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@page import="javax.portlet.PortletRequest"%>
<%@page import="com.sambaash.platform.constant.SystemSetupConstants"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib 	uri="http://liferay.com/tld/security" prefix="liferay-security"%>
<%@ taglib 	uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib 	uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib 	uri="http://liferay.com/tld/util" prefix="liferay-util"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel='stylesheet' href='/html/css/hook.css?minifierType=css'>
<link rel='stylesheet' 	href='/html/css/sp/formio.full.min.css?minifierType=css'>
<link rel='stylesheet'	href='<%=request.getContextPath()%>/css/main.css?c=sddssssd'>
<script type="text/javascript" 	src="/html/js/sp/hook.js?<%=System.currentTimeMillis()%>"
	language="javascript1.2""></script>
<%@ taglib uri="/tld/sp-formio" prefix="sp-formio"%>
<%@ page import="java.io.*,java.util.*"%>

<portlet:defineObjects />
<liferay-theme:defineObjects />

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
	if (PermissionUtil.canEditModel((PortletRequest) request.getAttribute("javax.portlet.request"))) {
%>
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
//	String formType=request.getParameter("formTypeName"); 
	String dashBoardLink = SambaashUtil.getDashBoard();
	long userId = themeDisplay.getUserId();
	String formStorageId=request.getParameter("storageId");
	String sponsorshipType = request.getParameter("sponsorshiptype");
	String corporateName = request.getParameter("corporatename");
	if(request.getParameter("storageId")!="null"){
		formStorageId = request.getParameter("storageId");
	}else{
		formStorageId = "0";
	}
		
%>




<div class="newPortlets enrolment-body enrolment-center-align">
	<div class="subHeader">
		<div class="container">
			<div class="inner-container">
				<aui:row>
					<aui:col span="10" cssClass="text-center header-title">
						<h2><span>PROCESS ENROLMENT</span></h2>
					</aui:col>
					<aui:col span="2" cssClass="text-right header-home-link">
						<a href="<%=homePage%>" title="Back to Home">Back to Home</a>
					</aui:col>
				</aui:row>
			</div>
		</div>
	</div>

	<div class="container mt-5">
		<div class="text-center">
			<div class="enrolment-center-align tabs mt-50">
				<div class="tab ">SPONSORSHIP</div>

				<div class="tab tab-selected">CANDIDATE</div>

				<div class="tab">PROGRAMME & SUBJECTS</div>

				<div class="tab">FEE</div>
			</div>
		</div>

		<div>
			<c:set var="formId" value="<%= formId %>"/>
			<%-- <c:set var="formType" value='<%= request.getParameter("formTypeName") %>' />--%>
		
		 	<sp-formio:FormIO cssClass="formContainer" modelName="<%=formType%>"
				formId="<%= formId %>" readOnly="false"
				formStorageId="<%=formStorageId%>" />
		</div>

		<div class="text-center">
			<aui:button-row>
				<aui:button onClick="backToSponsor()" type="button" value="PREVIOUS" />
				<aui:button onClick="proceedToProgram()" cssClass="btn-primary"
					type="button" value="NEXT" />
				<aui:button cssClass="btn-primary" disabled="false" type="button"
					onClick="save()" value="SAVE" />
				<aui:button type="button" onClick="onCancelProcess()" value="CANCEL" />
			</aui:button-row>
		</div>
	</div>

</div>

<script type="text/javascript">
	
	var formStorageId = "<%=formStorageId %>"; 
	var formId = "<%=formId%>"; 
	var programUrl = "<%=program%>";
	var sponsorUrl = "<%=sponsor%>";
	var sponsorshipType = "individual";
	var corporateName = "<%=corporateName%>";
	var namespace = "<portlet:namespace/>";
	var mode = formStorageId === '0' || formStorageId=="null" ? "create" : "edit";
	var homeUrl = "<%=cancelUrl%>";
	var buttonClick;
	var isFormSaved = false;
	if(formStorageId==="null"){
		formStorageId = 0;
		mode='create';
	}
	var instance;
	//document.getElementsByClassName("submitFormButton").style.display = "none";

	function afterFormLoadedFormIOForm(thisInstance) {
		instance = thisInstance;
	//	thisInstance.components["Enrolment"].disabled = true;
		//thisInstance.components.Submit.buttonElement.textContent = "Update";
	}
	function validateFormIOForm(thisInstance) {
		if (formStorageId && formStorageId !=='null' && formStorageId !== '0') {
			thisInstance.components["UserId"].setValue(formStorageId);
			thisInstance.components["SponsorshipType"].setValue(sponsorshipType);
			thisInstance.components["CorporateName"].setValue(corporateName);
			thisInstance.components["EnrolmentStatus"].setValue("Pending");
			thisInstance.components["FormId"].setValue(formId);
			thisInstance.customSubmission(thisInstance.form.submission);
		} else {
			var formdata = thisInstance.form.submission.data;
			console.log(formdata);
			ajaxCallAPI(
					'POST',
					'createUser',
					formdata,
					function() {
						createCandidate();
					}, function() {});
		}
	}

	function afterFormSubmissionFormIOForm(thisInstance){
		isFormSaved = true;
		if(buttonClick =="next" && isFormSaved)
		{
			if(formStorageId==="null"){
				location.href = programUrl;
			}else{
				location.href = programUrl+"&" + namespace + "formStorageId=" + formStorageId;
			}	
		}
	}
	function createCandidate(){
		var email = instance.form.submission.data.PrimaryEmailAddress;
		ajaxCallAPI(
				'GET',
				'searchList',
				email,
				function() {
					var response = this.get("responseData");
					if (response){
						instance.components["UserId"].setValue(response.userId);
						instance.components["EnrolmentStatus"].setValue("Pending");
						instance.components["SponsorshipType"].setValue(sponsorshipType);
						instance.components["CorporateName"].setValue(corporateName);
						instance.components["FormId"].setValue(formId);
						instance.customSubmission(instance.form.submission);
					}
				}, function() {

				});
		
	}
	
	function proceedToProgram() {
		if(isFormSaved == true)
		{
			location.href = programUrl;
			return;
		}
		document.getElementsByClassName("submitFormButton")[1].click();
		buttonClick = "next";
	}
	
	function save(){
		document.getElementsByClassName("submitFormButton")[1].click();
		buttonClick = "save";
	}
	
	function backToSponsor() {
		if(formStorageId==="null"){
			location.href = sponsorUrl;
		}else{
			location.href = sponsorUrl+"&" + namespace + "formStorageId=" + formStorageId;
		}
		
	}
	function onCancelProcess() {
		location.href = homeUrl;
	}
	
	
</script>

<%
	}
%>
