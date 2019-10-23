<%@page import="com.sambaash.platform.util.LabelUtil"%>
<%@page import="java.util.Map"%>
<%@page import="com.fasterxml.jackson.databind.SerializationFeature"%>
<%@page import="com.fasterxml.jackson.databind.ObjectMapper"%>
<%@page import="com.sambaash.platform.finance.service.SPFinanceLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
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

<link rel='stylesheet' href='/html/css/hook.css?minifierType=css'>
<link rel='stylesheet' type="text/css"
	href='<%=request.getContextPath()%>/css/main.css?minifierType=css'></link>
<link rel='stylesheet' type="text/css" href='<%=request.getContextPath()%>/css/portlet.css?minifierType=css'></link>
<link rel='stylesheet' href='/html/css/sp/formio.full.min.css?minifierType=css'>
<script type="text/javascript" src="/html/js/sp/hook.js?<%=System.currentTimeMillis()%>" language="javascript1.2""></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/main.js" language="javascript1.2""></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/billing.js" language="javascript1.2""></script>
<%@ taglib	uri="/tld/sp-formio" prefix="sp-formio"%> 
<portlet:defineObjects />

<portlet:renderURL var="profitCentreListing">
	<portlet:param name="jspPage"
		value="/html/claims/list.jsp" />
</portlet:renderURL>

<div class="newPortlets">
<% if(PermissionUtil.canAddModel((PortletRequest) request.getAttribute("javax.portlet.request"))){ %>
<%
ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
long userId = themeDisplay.getUserId();
String formId = portletPreferences.getValue(SystemSetupConstants.PREF_HTML_FORM_ID, "2040");
String dashBoardLink = SambaashUtil.getDashBoard();
Map<Long, String> claimTypeMap = SPFinanceLocalServiceUtil.getSpListTypeIdToDisplayName("finance.payment.claimType", request);
ObjectMapper objectMapper = new ObjectMapper();
objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
%>
<style>
.underline-class {
    border: 0 !important;
    border-bottom: 1px solid #dadfe7 !important;
     margin: 1em 0 !important;
}

.form-check-label span{
	width: 100% !important;
    font-family: WorkSans !important;
    font-size: 12px !important;
}

.disclaimer-class {
	font-size: 14px !important;
    font-weight: 500 !important;
    font-style: normal !important;
    line-height: 1.29 !important;
    letter-spacing: 0.2px !important;
    color: #0f349f !important;
}

.note-class{
    font-size: 12px;
    font-weight: normal;
    font-style: normal;
    font-stretch: normal;
    line-height: 1.5;
    letter-spacing: normal;
}

.mt-40{
	margin-top: 40px;
}

.pl-0{
	padding-left: 0px !important;
}

.claim-status{
		padding: 1px 6px !important;
		border-radius: 15px;
		width: 100%;
        text-align: center;
        background-color:#d5d5d5;
        text-overflow: ellipsis;
	    white-space: nowrap;
	    overflow: hidden;
	    display: inline-block;
    	max-width: 130px;
	}
</style>
	<div class="subHeader">
		<div class="container">
			<div class="inner-container">
				<aui:row>
					<aui:col span="10" cssClass="text-center"><h2><span><%=LabelUtil.getLabel(pageContext, themeDisplay, "submit.claim.form.header.title")%></span></h2></aui:col>
					<aui:col span="2" cssClass="text-right"><aui:a href="<%= dashBoardLink %>" title="Back to Home">Back to Home</aui:a></aui:col>
				</aui:row>
			</div>
		</div>
	</div>
	<c:set var="formId" value="<%= formId %>"/>
	<c:set var="formType" value='<%= request.getParameter("formTypeName") %>' />
	<div class="formRoot">
		<div class="innerFormRoot">
			<sp-formio:FormIO cssClass="formContainer formPadding"  modelName ="${formType}" 
		formId="${formId}" readOnly="false" formStorageId="0"  />
		</div>
	</div>
</div>

<script type="text/javascript">
var InvigilatorId = <%=userId%>;
//var InvigilatorId = "165312"; 
var mode = "create";
var modelName = "submittedClaim";
var viewName = "submittedClaim";
var formInstance;
var ClaimTypeMap = <%=objectMapper.writeValueAsString(claimTypeMap)%>;
function validateFormIOForm(thisInstance){
	if(checkIsValide()){
		thisInstance.form.submission.data.SubmittedClaimCode = generateCode("SC-");
		thisInstance.form.submission.data.WorkFlowStatus = "Pending Submission";
		thisInstance.form.submission.data.ApprovalStatus = "Pending Submission";
		thisInstance.form.submission.data.PaymentType = "Claim";
		thisInstance.form.submission.data.InvigilatorID = InvigilatorId;
		thisInstance.form.submission.data.Status = "Submitted";
		thisInstance.form.submission.data.ProofUri = JSON.stringify(thisInstance.form.submission.data.ProofUri[0]);
		thisInstance.customSubmission(thisInstance.form.submission);
	}
}
function afterFormLoadedFormIOForm(thisInstance){
	formInstance = thisInstance;
	thisInstance.components.Submit.disabled = true;
	setInterval(function() {
		checkPCForm(thisInstance);
	}, 1000);
}

function checkPCForm(thisInstance) {
	if (checkIsValide(thisInstance) && formInstance.form.submission.data.Disclaimer) {
		thisInstance.components.Submit.disabled = false;
	} else {
		thisInstance.components.Submit.disabled = true;
	}
}

function checkIsValide(){
	var eValid = true;
	var source = formInstance.form.submission.data.ScheduleID;
	if (formInstance.form.submission.data.ScheduleID == "") {
		console.log("Inside schedule check");
		eValid = false;
	} else if (formInstance.form.submission.data.ClaimType == "") {
		console.log("Inside claim check");
		eValid = false;
	} else if (formInstance.form.submission.data.ClaimVal == null || formInstance.form.submission.data.ClaimVal == "") {
		console.log("Inside claim val check");
		
		eValid = false;
	}else if (formInstance.form.submission.data.ProofUri == "") {
		console.log("Inside Proog uri val check");
		eValid = false;
	}else {
		console.log("Inside disclaimer check");
		eValid = formInstance.form.submission.data.Disclaimer;
	}
	return eValid;
}

</script>
<% } %>