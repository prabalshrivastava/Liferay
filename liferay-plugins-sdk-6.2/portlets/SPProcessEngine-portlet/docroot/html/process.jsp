
<%@page import="org.apache.commons.lang.StringUtils"%>
<%@page import="com.sambaash.platform.srv.processbuilder.service.PEEngineServiceUtil"%>
<%@page import="com.sambaash.platform.pe.helpers.PEProcessHelper"%>
<%@page import="com.sambaash.platform.srv.processbuilder.service.PEProcessStateLocalServiceUtil"%>
<%@page import="com.sambaash.platform.portlet.pe.helper.ProcessStateActionHelper"%>
<%@page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.json.JSONObject"%>
<%@page import="com.sambaash.platform.util.SambaashUtil"%>
<%@page import="com.sambaash.platform.pe.PEDataSource"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.sambaash.platform.pe.helpers.PEUrlHelper"%>
<%@ page import="com.liferay.portal.kernel.util.GetterUtil" %>
<%@page import="com.sambaash.platform.util.LabelUtil"%>
<%@page import="javax.servlet.jsp.PageContext"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ include file="init.jsp" %>

<style type="text/css">
.sectio0nBg

{ box-shadow: 0 6px 15px 0 rgba(37, 38, 94, 0.07), 0 2px 4px 0 rgba(130, 143, 151, 0.2); background-color: #ffffff; box-shadow: 0 6px 15px 0 rgba(37, 38, 94, 0.07); box-shadow: 0 6px 15px 0 rgba(37, 38, 94, 0.07); margin-bottom: 5px !important; }
.subHeadWrap

{ display: flex; align-items: center; justify-content: center; padding: 0 0; width: 100%; max-width: 1200px; margin: 0 auto; position:relative; }
.subHeadWrap h4

{ font-size: 20px; font-weight: 600; padding: 15px 30px; border-bottom: 2px solid #265ba1; }
.aui .rightSide .subHeadWrap a.backtohm

{ position: absolute; right: 0; font-size: 14px; font-weight: 600; color: #12369f!important; }
.subHeadWrap a img

{ transform: rotate(270deg); -ms-transform: rotate(270deg); -moz-transform: rotate(270deg); -webkit-transform: rotate(90deg); -o-transform: rotate(270deg); width: 30px; }

.mainWapper { padding: 0 0 40px 0; }

</style>

<%
PEOutput output =(PEOutput) request.getAttribute(PEConstants.ATTR_OUTPUT);
PEDataSource dataSource = output.getDataSource();
long processStateId = 0;
long currentStatusTypeId = 0;
if (output.getProcessState() != null && output.getProcessState().getUserIdProcess() != 0) {
	processStateId = output.getProcessState().getSpPEProcessStateId();
	currentStatusTypeId = output.getProcessState().getStatusTypeId();
}
boolean isShowApplication = false;
if (output.getProcessState() != null){
	long loggedInUser = themeDisplay.getUserId();
	if(dataSource.isApplicantLoggedInUser() 
			|| (output.getProcessState().getUserIdAgent() == loggedInUser) 
			|| (output.getProcessState().getUserIdCreator() == loggedInUser) 
			|| (output.getProcessState().getUserIdSupervisor() == loggedInUser)
			|| (output.getProcessState().getUserIdProcess() == loggedInUser)
			|| (dataSource.isCurrentStatusApproverLoggedInUser())
			|| SambaashUtil.isAdmin(themeDisplay.getScopeGroupId(), themeDisplay.getUserId())){
		isShowApplication = true;
	}
}

// TODO: get from Preference
// String progressOrientation = "left";   // currently can be left | top
// boolean hideProcessHeader = true;
String progressOrientation = output.getOrientation();
boolean hideProcessHeader = !output.isShowHeader();


JSONObject scheduleDetails = JSONFactoryUtil.createJSONObject();
boolean dateExceeded = false;
boolean dateBehind = false;
if (Validator.isNotNull(dataSource.getProcess()) && Validator.isNotNull(dataSource.getProcess().getScheduleModelId())){
	scheduleDetails = ProcessStateActionHelper.getScheduleDetails(dataSource.getProcess().getScheduleModelId(), themeDisplay.getUserId(), themeDisplay.getScopeGroupId());
	String startDate = scheduleDetails.getString("StartDate");
	String endDate = scheduleDetails.getString("EndDate");
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	Date currentDate = sdf.parse(sdf.format(new Date()));
	Date startDateFormatted = sdf.parse(startDate);
	Date endDateFormatted = sdf.parse(endDate);
	if(currentDate.after(endDateFormatted)){
		dateExceeded = true;
	}else if (currentDate.before(startDateFormatted)){
		dateBehind = true;
	} 
}

//for logged in user, check for previous enrollments
boolean enableSingleSubmissionValidationResult = true;
if (themeDisplay.getUserId() > 0){
	String emailAddress = themeDisplay.getUser().getEmailAddress();
	JSONObject resultJson =	PEProcessStateLocalServiceUtil.checkForPreviousSubmissions(themeDisplay.getUserId(), emailAddress, dataSource.getProcess().getSpPEProcessId(), dataSource.getPeEntity().getClassNameId(), dataSource.getPeEntity().getId()); 
	enableSingleSubmissionValidationResult = resultJson.getBoolean("isAllowed");
}

boolean notAllowedToSubmitAnother = false;
if (dataSource.getProcess().isEnableSingleSubmission() && dataSource.isFirstRequest() && themeDisplay.isSignedIn() && !PEProcessHelper.isAgent(themeDisplay.getUser(), dataSource.getProcess())) {
	// do immediate validation for applicant, otherwise for agent we need to check inputted email address later
	notAllowedToSubmitAnother = PEEngineServiceUtil.getUserApplications(themeDisplay.getUser().getEmailAddress(), dataSource.getProcess().getSpPEProcessId(), dataSource.getPeEntity().getClassNameId(), dataSource.getPeEntity().getId(), 1).length() > 0;
}

%>

<script>
var A;
var processStateId;
var processStateObj = {
		processStateId : <%= processStateId %>,
		currentStatusTypeId : <%= currentStatusTypeId %>
};
processStateId = <%= processStateId %>;

var pns;
pns ="<portlet:namespace/>";
//alert(processStateId);
// Global array stores the functions to be invoked upon aui initilizaiton
// Jsp snippets which wants script intilizaitons can keep in method and that method has to pushed to below array.
var initializeFuncs = [];
</script>

<section class="sectio0nBg">
<div class="subHeadWrap">
<h4><%=output.getDataSource().getProcessName()%></h4>
<a class="backtohm" href="/workspace"><img src="<%=themeDisplay.getPathThemeImages()%>/common/down-arrow@2x.png"> Back to Workspace</a> 
</div>
</section>

<div class="enrollmentContainer screen-max-width " id="mainContainer"> <!-- mainContainer used in js for displaying preloader -->
<div class="enrollmentRow roundedborder">


<%
if (isShowApplication) {

	if (output.isShowProcessProgress()) {
		if (!hideProcessHeader) {
%>

<div class="user-Progress ">
<div class="user-cont">
	<span><%= LabelUtil.getLabel(pageContext, themeDisplay, "user.name")%></span><b><%= output.getFullNameProcessUser() %></b>
</div>
<div class="user-cont">
	<span><%= LabelUtil.getLabel(pageContext, themeDisplay, "email.address")%></span><b><%= output.getEmailProcessUser() %></b>
</div>
<div class="user-cont">
	<span><%= LabelUtil.getLabel(pageContext, themeDisplay, "course.name")%></span><b><%= output.getEntityName() %></b>
</div>
</div>
<!-- TODO: to add if preference here -->
<%-- <jsp:include page="/html/processStepsBar.jsp"  /> --%>
<%
		}
		if ("left".equals(progressOrientation)) {
			%>
			<div class="mainWapper">
			 <jsp:include page="/html/wizProcessStepsBar.jsp"  />
			<%			
		} else { // default to top
			%>
			<jsp:include page="/html/processStepsBar.jsp"  />
			<%
		}
	}
%>
 <div class="WizStepResult">
<div class="Headform-title" id="heading">
	<span id="headingTitle"><%= GetterUtil.getString(output.getHeading()) %></span>
</div>
<!-- Used to load html message  -->
<jsp:include page="/html/loadMsg.jsp" />

<!-- msg.jsp is useful to display success/failure msgs during ajax calls -->
<jsp:include page="/html/msg.jsp" />

<%
if (output.errorExists() || output.validationMsgsExists()) {
%>

	 <jsp:include page="/html/processError.jsp"  />

<%
}
if (output.isForm()) {
	if(output.getStorageId() == 0){
		// if storage id == 0 means, new form to submit, so authorization is required if the user can submit or not 
		if(output.isCanSubmit()){
		if (!enableSingleSubmissionValidationResult && dataSource.isFirstRequest()){
		output.setMsg("You have already enrolled for this exam. Hence cannot enroll");
		%>

		<jsp:include page="/html/loadMsg.jsp"></jsp:include>

		<%
		}else if (!dateBehind && dateExceeded && dataSource.isFirstRequest()){
		output.setMsg("Enrollment is over");
		%>
			
			<jsp:include page="/html/loadMsg.jsp"></jsp:include>
	    <%}else if (dateBehind && !dateExceeded && dataSource.isFirstRequest()){
			output.setMsg("Enrollment is yet to begin");
		%>
				
			<jsp:include page="/html/loadMsg.jsp"></jsp:include>
		<%}else{ %>
			
			<jsp:include page="/html/loadForm.jsp"></jsp:include>
		<%}
		}
	}else {
		%>
	<jsp:include page="/html/loadForm.jsp"></jsp:include>
		<% 
	}
}else if (output.isFormV2()){ // form V2
	if(output.getStorageId() == 0){
		// if storage id == 0 means, new form to submit, so authorization is required if the user can submit or not 
		if(output.isCanSubmit()){
			// new validation used. This is not just for enrolment anymore.
			// entity can also now switch from initial setup along the workflow
		if (notAllowedToSubmitAnother && dataSource.isFirstRequest()){
			String singleSubmissionErrorMsg = dataSource.getProcess().getSingleSubmissionErrorMsg();
			if (StringUtils.isEmpty(singleSubmissionErrorMsg)) {
				singleSubmissionErrorMsg = "You have already applied for this. You are not allowed to apply again.";
			}
		output.setMsg(singleSubmissionErrorMsg);
		%>

		<jsp:include page="/html/loadMsg.jsp"></jsp:include>

		<%
		}else if (!dateBehind && dateExceeded && dataSource.isFirstRequest()){
		output.setMsg("Enrollment is over");
		%>
			
			<jsp:include page="/html/loadMsg.jsp"></jsp:include>
	    <%}else if (dateBehind && !dateExceeded && dataSource.isFirstRequest()){
			output.setMsg("Enrollment is yet to begin");
		%>
				
			<jsp:include page="/html/loadMsg.jsp"></jsp:include>
		<%}else{ %>
			
			<jsp:include page="/html/loadFormV2.jsp"></jsp:include>
		<%}
		}
	}else {
		%>
	<jsp:include page="/html/loadFormV2.jsp"></jsp:include>
		<% 
	}	
}else if (output.isPayment()){ // payment
%>

	<jsp:include page="/html/custom/payment/payment.jsp" />

	<% 	
}else if (output.isPaymentV2()){ // payment V2
%>

	<jsp:include page="/html/custom/payment/paymentV2.jsp" />

	<% 	
}else if (output.isPricing()){ // pricing
%>

	<jsp:include page="/html/custom/pricing/pricing.jsp" />

<%
}else if (output.isJsp()){ // it's jsp to load
%>

	<jsp:include page="/html/loadJsp.jsp" />

<%
}
%>

	
<%
if (output.isCanApprove()) {
%>

	<jsp:include page="/html/approveReject.jsp"></jsp:include>

<%
}
%>

<%
	User lastSavedBy = output.getLastSaveDoneBy();
%>
<c:if test="<%= lastSavedBy != null && !dataSource.isApplicantLoggedInUser() %>">
	<div class="footer-legend msg">
		Last saved by <span><%=lastSavedBy.getFullName() %> (<%=lastSavedBy.getEmailAddress() %>) on </span> <span> <%= output.getLastSaveDateStr() %></span>
	</div>

</c:if>
<%
}else{%>
	<jsp:include page="/html/processAuthError.jsp"></jsp:include>
<%}
%>
</div>
</div>
</div>
<% 
if ("left".equals(progressOrientation)) {
%>
 <div class="WizStepResult"></div>
</div>
<%
}
%>

<script>
AUI().use('aui-node','aui-io-request', 'liferay-util-window','aui-io-plugin-deprecated',function(A1) {
	A = A1;
	initializeFuncs.forEach(function(methodToInvoked){
		methodToInvoked(A);
	});
});
</script>