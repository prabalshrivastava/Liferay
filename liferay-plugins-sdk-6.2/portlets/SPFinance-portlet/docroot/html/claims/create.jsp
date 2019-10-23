<%@page import="com.sambaash.platform.finance.constants.FinanceConstants"%>
<%@page import="org.apache.commons.lang.StringUtils"%>
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
String formStorageId = request.getParameter("storageId");
String scheduleId = request.getParameter("scheduleId");
String claimTypeId = request.getParameter("claimTypeId");
String submittedClaimCode = request.getParameter("submittedClaimCode");
String userId = String.valueOf(themeDisplay.getUserId());
if(!StringUtils.isEmpty(formStorageId)) {
	userId = formStorageId;
}
String formId = portletPreferences.getValue(SystemSetupConstants.PREF_HTML_FORM_ID, "2040");
String disclaimerHyperLink = portletPreferences.getValue(FinanceConstants.PREF_DISCLAIMER_HYPERLINK, "");
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

.form-check-input{
	display: block !important;
}

.disclaimer-class {
	font-size: 14px !important;
    font-weight: 500 !important;
    font-style: normal !important;
    line-height: 1.29 !important;
    letter-spacing: 0.2px !important;
    color: #0f349f !important;
}

.cursor-text{
	cursor: default !important;
}
.disclaimer {
	width: 30px;
	text-align: right;
    clear: both;
    float:left;
    margin-right: 7px;
    margin-left: 5px;
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

#disclaimer-hyper-id {
	font :400 13px 'Work Sans',sans-serif !important;
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
				<aui:col span="2" cssClass="text-right"><a href="<%= dashBoardLink %>" title="Back to Home">Back to Home</a></aui:col>
			</aui:row>
			</div>
		</div>
	</div>
	<c:set var="formId" value="<%= formId %>"/>
	<c:set var="formType" value='<%= request.getParameter("formTypeName") %>' />
	<c:set var="formStorageId" value ='0'/>
		<div class="formRoot">
		<div class="innerFormRoot">
			<sp-formio:FormIO cssClass="formContainer formPadding"   modelName ="${formType}" 
				formId="${formId}" readOnly="false" formStorageId ="${formStorageId} } "  />
		</div>
	</div>
</div>

<script type="text/javascript">
var InvigilatorId = "<%=userId%>";
var disclaimerHyperLink = "<%= disclaimerHyperLink == null || disclaimerHyperLink == "" ? "#": disclaimerHyperLink%>";
var scheduleId = "<%=scheduleId%>";
var claimTypeId = "<%=claimTypeId%>";
var submittedClaimCode ="<%=submittedClaimCode%>";
var mode = "create";
var modelName = "submittedClaim";
var viewName = "submittedClaim";
var formInstance;

var ClaimTypeMap = <%=objectMapper.writeValueAsString(claimTypeMap)%>;
function validateFormIOForm(thisInstance){
	if(checkIsValide()){
		
	        if (submittedClaimCode && submittedClaimCode != "null")
				thisInstance.form.submission.data.SubmittedClaimCode = submittedClaimCode;
			else
				thisInstance.form.submission.data.SubmittedClaimCode = generateCode("SC-");
			thisInstance.form.submission.data.WorkFlowStatus = "Pending Submission";
			thisInstance.form.submission.data.ApprovalStatus = "Pending Submission";
			thisInstance.form.submission.data.PaymentType = "Claim";
			thisInstance.form.submission.data.InvigilatorID = InvigilatorId;
			thisInstance.form.submission.data.Status = "Submitted";
			thisInstance.form.submission.data.ProofUri = JSON
					.stringify(thisInstance.form.submission.data.ProofUri[0]);
			thisInstance.form.submission.data.mode = mode;
			thisInstance.customSubmission(thisInstance.form.submission);
		}
	}

	function afterFormLoadedFormIOForm(thisInstance) {
		formInstance = thisInstance;
		thisInstance.components.Submit.disabled = true;
		var str = "hyperlink";
		var result = str.link(disclaimerHyperLink);
		document.getElementById("disclaimer-hyper-id").innerHTML = "I have read and agree to the terms and conditions specified in the "
				+ result
				+ " above. I agree that RELC reserves the right to change the terms and conditions without prior notice.";

		setInterval(function() {
			checkPCForm(thisInstance);
		}, 1000);
		console.log(scheduleId);
		if (scheduleId && scheduleId != "null") {
			form1.components.ScheduleID.setValue(scheduleId);
		}
		if (submittedClaimCode && submittedClaimCode != "null") {
			searchBy(
					[ {
						"contentJson.SubmittedClaimCode" : [ submittedClaimCode ]
					} ],
					[],
					[],
					"submittedclaim",
					false,
					ajaxUrl,
					function(list) {
						if (list && list.content && list.content.length > 0
								&& list.content.length == 1) {
							mode = "edit";
							form1.components.ScheduleID.disabled=true;
							var content = list.content;
							for (var contenti = 0; contenti < content.length; contenti++) {
								var data = content[contenti];
								var claimType = data.contentJson.ClaimType;
								form1.components.ClaimType
										.setValue(ClaimTypeMap[claimType]);
								form1.components.ClaimType.disabled=true;
								var claimVal = data.contentJson.ClaimVal;
								form1.components.ClaimVal.setValue(claimVal);
								var status = data.contentJson.Status;
								document.getElementById("claim-status").innerHTML = status;
								form1.components.Status.setValue(status);
								var relcRemark = data.contentJson.RelcRemark;
								form1.components.RelcRemark
										.setValue(relcRemark);
								var invigilatorRemark = data.contentJson.InvigilatorRemark;
								form1.components.InvigilatorRemark
										.setValue(invigilatorRemark);
								var proofUri = [];
								proofUri.push(JSON
										.parse(data.contentJson.ProofUri));
								form1.components.ProofUri.setValue(proofUri);
								form1.formStorageId = data.contentJson.SubmittedClaimCode;
							}
						} else {
							form1.formStorageId = 0;
						}

					});
		}
	}

	function checkPCForm(thisInstance) {
		if (checkIsValide(thisInstance)
				&& formInstance.form.submission.data.Disclaimer) {
			thisInstance.components.Submit.disabled = false;
		} else {
			thisInstance.components.Submit.disabled = true;
		}
	}

	function checkIsValide() {
		var eValid = true;
		var source = formInstance.form.submission.data.ScheduleID;
		if (formInstance.form.submission.data.ScheduleID == "") {
			console.log("Inside schedule check");
			eValid = false;
		} else if (formInstance.form.submission.data.ClaimType == "") {
			console.log("Inside claim check");
			eValid = false;
		} else if (formInstance.form.submission.data.ClaimVal == null
				|| formInstance.form.submission.data.ClaimVal == "") {
			console.log("Inside claim val check");

			eValid = false;
		} else if (formInstance.form.submission.data.ProofUri == "") {
			console.log("Inside Proog uri val check");
			eValid = false;
		} else {
			console.log("Inside disclaimer check");
			eValid = formInstance.form.submission.data.Disclaimer;
		}
		return eValid;
	}

	function afterFormSubmissionFormIOForm(data) {
		var formMode = data.form.data.mode;
		var formType = viewName;
		var msg = "";
		var boundingBox = "#sucess-popup";
		var contentBox = "#sucess-popup-box";
		if (formMode == 'create') {
			msg = formType + " Created!";
		} else if (formMode == 'edit') {
			msg = formType + " Updated!";
		}
		document.getElementById('success-msg').innerHTML = msg;
		AUI().use('aui-base', function(A) {
			A.one(boundingBox).set('hidden', false);
			YUI().use('aui-modal', function(Y) {
				new Y.Modal({
					boundingBox : boundingBox,
					contentBox : contentBox,
					headerContent : '',
					centered : true,
					destroyOnHide : false,
					modal : true,
					resizable : false,
					draggable : false,
				}).render();
				Y.one('.close').hide();
			});
		});
	}
</script>
<% } %>