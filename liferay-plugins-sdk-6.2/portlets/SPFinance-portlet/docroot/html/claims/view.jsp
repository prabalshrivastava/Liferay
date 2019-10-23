<%@page import="org.apache.commons.lang.StringUtils"%>
<%@page import="com.sambaash.platform.util.LabelUtil"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.sambaash.platform.finance.constants.FinanceConstants"%>
<%@page import="com.fasterxml.jackson.databind.SerializationFeature"%>
<%@page import="com.fasterxml.jackson.databind.ObjectMapper"%>
<%@page import="java.util.Map"%>
<%@page import="com.sambaash.platform.finance.service.SPFinanceLocalServiceUtil"%>
<%@page import="com.sambaash.platform.srv.spservices.model.SPListType"%>
<%@page import="java.util.List"%>
<%@page import="com.sambaash.platform.srv.spservices.service.SPListTypeLocalServiceUtil"%>
<%@page import="com.sambaash.platform.srv.spservices.service.SPListTypeLocalService"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@page import="com.sambaash.platform.constant.SambaashConstants"%>
<%@page import="com.sambaash.platform.util.SambaashUtil"%>
<%@page import="com.liferay.portal.security.auth.AuthTokenUtil"%>
<%@page import="com.liferay.portal.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/security"
	prefix="liferay-security"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util"%>
<%@ taglib uri="/tld/sp-formio" prefix="sp-formio"%>

<link rel='stylesheet'
	href='/html/css/sp/formio.full.min.css?minifierType=css'>
<link rel='stylesheet' href='/html/css/hook.css?minifierType=css'>
<link rel='stylesheet' type="text/css"
	href='<%=request.getContextPath()%>/css/portlet.css?minifierType=css'></link>
<link rel='stylesheet' type="text/css"
	href='<%=request.getContextPath()%>/css/billing.css?minifierType=css'></link>
<link rel='stylesheet' type="text/css"
	href='<%=request.getContextPath()%>/css/main.css?minifierType=css'></link>
<link rel='stylesheet' type="text/scss"
	href='<%=request.getContextPath()%>/css/custom.scss?minifierType=css'></link>
<link rel='stylesheet' type="text/css"
	href='<%=request.getContextPath()%>/css/claim.css?minifierType=css'></link>
<script type="text/javascript"
	src="/html/js/sp/hook.js?<%=System.currentTimeMillis()%>"
	language="javascript1.2""></script>

<portlet:defineObjects />
<%
	String formStorageId = request.getParameter("storageId");
	String baseUrl = portletPreferences.getValue("baseUrlPref", "");
	ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
	Long groupId = themeDisplay.getLayout().getGroupId();
	String dashBoardLink = SambaashUtil.getDashBoard();
	String globalBaseCurrency = SambaashUtil.getParameter("base_currency", groupId);
	Map<Long, String> claimTypeMap = SPFinanceLocalServiceUtil.getSpListTypeIdToDisplayName("finance.payment.claimType", request);
	Map<String, String> categoryMap = SPFinanceLocalServiceUtil.getCategoryMap(request);
	Map<String, String> transactionTypeMap = SPFinanceLocalServiceUtil.getTransactionTypeMap(request);
	Map<String, String> clientTypeMap = SPFinanceLocalServiceUtil.getClientTypeMap(request);
	Map<String, String> functionalComponentMap = SPFinanceLocalServiceUtil.getFunctionalComponentMap(request);
	Map<String, String> productMap = SPFinanceLocalServiceUtil.getProductTypeMap(request);
	Map<String, String> productSubtypeMap = SPFinanceLocalServiceUtil.getProductSubTypeMap(request);
	ObjectMapper objectMapper = new ObjectMapper();
	objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
	String serverCurrDate = sdf.format(new Date());
	boolean[] roles = SPFinanceLocalServiceUtil.checkUserRoles(themeDisplay);
	boolean submitter = roles[0];
	boolean verifier = roles[1];
	boolean approver = roles[2];
	String subProduct = themeDisplay.getLayout().getTypeSettingsProperty("subProduct");
	if(!StringUtils.isEmpty(subProduct)) {
		SPListType spListType = SPListTypeLocalServiceUtil.fetchSPListType(Long.parseLong(subProduct));
		if(spListType != null) {
			subProduct = spListType.getDisplayName();
		}
	}
%>
<style>
.underline-class {
    border: 0 !important;
    border-bottom: 1px solid #dadfe7 !important;
     margin: 1em 0 !important;
}

.padding-remark {
    border-bottom: 1px solid #e0e7ee;
    padding-top: 8px;
}

.status-css {
    width: 200px;
    height: 24px;
    object-fit: contain;
    border-radius: 100px;
    text-align: center;
    font-size: 10px;
}

.no-record{
	text-align: center;
    width: 200px;
    height: 147px;
    left: 0;
    right: 0;
    margin: auto;
}
</style>
<portlet:resourceURL var="resourceURL">
	<portlet:param name="sp_p_auth"
		value="<%=AuthTokenUtil.getToken(request)%>" />
</portlet:resourceURL>
<div class="newPortlets">
	<div class="subHeader">
		<div class="container">
			<div class="inner-container">
			<aui:row>
				<aui:col span="10" cssClass="text-center">
				<h2><span>PAYMENT ADVICE DETAILS</span></h2>
					
				</aui:col>
				<aui:col span="2" cssClass="text-right">
					<aui:a href="<%=dashBoardLink%>" title="Back to Home">Back to Home</aui:a>
				</aui:col>
			</aui:row>
		</div>
	</div>
	</div>
	<div class="formRoot">
		<div class="innerFormRoot">
	<div class="invoiceDetailsFormDiv">

		<div class="formContainer container formio-form" style="padding-top: 50px !important; padding: 75px 70px !important;">
			<form class="aui" id="paymentAdviceForm" name="paymentAdviceForm"
				action="">
				<aui:row>
					<aui:col span="10" cssClass="offset1">
						<div style="display: none;" class="alert alert-danger"
							role="showAlert" id="alert_msg">Select Facility Type.</div>
							<aui:input name="" type="hidden" id="SubmittedClaimCode" />
						<aui:row cssClass="underline-class">
							<aui:col span="3">
								<div class="form-group">
									<label class="control-label">
										<%=LabelUtil.getLabel(pageContext, themeDisplay, "pa.detail.exambody")%>
									</label>
								</div>
							</aui:col>
							<aui:col span="9" cssClass="formio-component-textfield">
								<div class="form-group">
									<aui:input type="text" name="" readonly="readonly" id="examBody"
										cssClass="form-control" value="<%=subProduct %>" />
								</div>
							</aui:col>
						</aui:row>
						<aui:row cssClass="underline-class">
							<aui:col span="3">
								<div class="form-group">
									<label class="control-label">
										<%=LabelUtil.getLabel(pageContext, themeDisplay, "pa.detail.idName")%>
									</label>
								</div>
							</aui:col>
							<aui:col span="9" cssClass="formio-component-textfield">
								<div class="form-group">
									<aui:input type="text" name="" readonly="readonly" id="idAndName"
										cssClass="form-control" />
								</div>
							</aui:col>
						</aui:row>
						<aui:row cssClass="underline-class">
							<aui:col span="3">
								<div class="form-group">
									<label class="control-label">
										<%=LabelUtil.getLabel(pageContext, themeDisplay, "pa.detail.appointmenttype")%>
									</label>
								</div>
							</aui:col>
							<aui:col span="9" cssClass="formio-component-textfield">
								<div class="form-group">
									<aui:input type="text" name="" readonly="readonly" id="appointmentType"
										cssClass="form-control" />
								</div>
							</aui:col>
						</aui:row>
						<aui:row cssClass="underline-class">
							<aui:col span="3">
								<div class="form-group">
									<label class="control-label">
										<%=LabelUtil.getLabel(pageContext, themeDisplay, "pa.detail.examdate")%>
									</label>
								</div>
							</aui:col>
							<aui:col span="9" cssClass="formio-component-textfield">
								<div class="form-group">
									<aui:input type="text" name="" readonly="readonly" id="examDate"
										cssClass="form-control" />
								</div>
							</aui:col>
						</aui:row>
						<aui:row cssClass="underline-class">
							<aui:col span="3">
								<div class="form-group">
									<label class="control-label">
										<%=LabelUtil.getLabel(pageContext, themeDisplay, "pa.detail.venue")%>
									</label>
								</div>
							</aui:col>
							<aui:col span="9" cssClass="formio-component-textfield">
								<div class="form-group">
									<aui:input type="text" name="" readonly="readonly" id="venue"
										cssClass="form-control" />
								</div>
							</aui:col>
						</aui:row>
						<aui:row cssClass="underline-class">
							<aui:col span="3">
								<div class="form-group">
									<label class="control-label">
										<%=LabelUtil.getLabel(pageContext, themeDisplay, "pa.detail.typeOfPayment")%>
									</label>
								</div>
							</aui:col>
							<aui:col span="9" cssClass="formio-component-textfield">
								<div class="form-group">
									<aui:input type="text" name="" readonly="readonly" id="typeOfPayment"
										cssClass="form-control" />
								</div>
							</aui:col>
						</aui:row>
						<aui:row cssClass="underline-class">
							<aui:col span="3">
								<div class="form-group">
									<label class="control-label">
										<%=LabelUtil.getLabel(pageContext, themeDisplay, "pa.detail.paymentUnitType")%>
									</label>
								</div>
							</aui:col>
							<aui:col span="9" cssClass="formio-component-textfield">
								<div class="form-group">
									<aui:input type="text" name="" readonly="readonly" id="paymentUnitType"
										cssClass="form-control" />
								</div>
							</aui:col>
						</aui:row>
						<aui:row cssClass="underline-class">
							<aui:col span="3">
								<div class="form-group">
									<label class="control-label">
										<%=LabelUtil.getLabel(pageContext, themeDisplay, "pa.detail.paymentAmount")%>
									</label>
								</div>
							</aui:col>
							<aui:col span="9" cssClass="formio-component-textfield">
								<div class="form-group">
									<aui:input type="number" name="" readonly="readonly" id="paymentAmount"
										cssClass="form-control" />
								</div>
							</aui:col>	
						</aui:row>
						<aui:row cssClass="underline-class">
							<aui:col span="3">
								<div class="form-group">
									<label class="control-label">
										<%=LabelUtil.getLabel(pageContext, themeDisplay, "pa.detail.addDeductAmount")%>
									</label>
								</div>
							</aui:col>
							<aui:col span="4" cssClass="formio-component-textfield text-center" style="word-spacing: 50px;text-align: left;padding-top: 12px;">
								<label class="control-label" style="float:left; padding-right:35px"><input type="radio" onChange="changeFinalAmount()" name="addDeductType" value="Add" disabled="disabled">Add</label>
								<label class="control-label"><input type="radio" onChange="changeFinalAmount()" name="addDeductType" value="Deduct" disabled="disabled">Deduct</label>
							</aui:col>
							<aui:col span="4" cssClass="formio-component-textfield">
								<div class="form-group">
									<aui:input type="number" onChange="changeFinalAmount()" name="" id="addDeductAmount"
										cssClass="form-control" readonly="true" />
								</div>
							</aui:col>	
						</aui:row>
						<aui:row cssClass="underline-class">
							<aui:col span="3">
								<div class="form-group">
									<label class="control-label">
									<%=LabelUtil.getLabel(pageContext, themeDisplay, "pa.detail.notes")%>
									</label>
								</div>
							</aui:col>
							<aui:col span="9" cssClass="formio-component-textfield">
								<div class="form-group">
									<aui:input type="text" name="" placeholder="Enter important notes" readonly="readonly" id="notes"
										cssClass="form-control" />
								</div>
							</aui:col>
						</aui:row>
						<aui:row cssClass="underline-class"> 
							<aui:col span="3">
								<div class="form-group">
									<label class="control-label">
										
										<%=LabelUtil.getLabel(pageContext, themeDisplay, "pa.detail.finalamount")%>
									</label>
								</div>
							</aui:col>
							<aui:col span="9" cssClass="formio-component-textfield">
								<div class="form-group">
									<aui:input type="number" name="" readonly="readonly" id="finalAmount"
										cssClass="form-control" />
								</div>
							</aui:col>	
						</aui:row>
						<aui:row cssClass="underline-class">
							<aui:col span="3">
								<div class="form-group">
									<label class="control-label">
										<%=LabelUtil.getLabel(pageContext, themeDisplay, "pa.detail.submitteddate")%>
									</label>
								</div>
							</aui:col>
							<aui:col span="9" cssClass="formio-component-textfield">
								<div class="form-group">
									<aui:input type="text" name="" readonly="readonly" id="submittedDate"
										cssClass="form-control" />
								</div>
							</aui:col>
						</aui:row>
						<aui:row cssClass="underline-class">
							<aui:col span="3">
								<div class="form-group">
									<label class="control-label">
										<%=LabelUtil.getLabel(pageContext, themeDisplay, "pa.detail.status")%>
									</label>
								</div>
							</aui:col>
							<aui:col span="9" cssClass="formio-component-textfield">
								<div class="form-group" style="padding-top: 9px;">
									<p id="workflowStatus" class="form_draft status-css">
										
									</p>
								</div>
							</aui:col>
						</aui:row>
					</aui:col>
				</aui:row>	
			</form>
		</div>
	</div>
	<div class="remarksHeader">
		<div class="container" style="background-color: #ffffff">
			<aui:row>
				<aui:col span="12" cssClass="text-center padding-remark">
					<h4 style="float:left; font-size: 12px; border-bottom: 1px solid #4169e1; width: 200px;"><%=LabelUtil.getLabel(pageContext, themeDisplay, "pa.detail.remark")%></h4>
					<h4 id="totalRemarks" style="float:right; font-size: 10px; color: rgba(85, 85, 85, 0.7);"><b>0</b> <%=LabelUtil.getLabel(pageContext, themeDisplay, "pa.detail.remark.small")%></h4>
				</aui:col>
			</aui:row>
		</div>
	</div>
	<div class="invoiceRemarksDiv">
		<div class="formContainer container formio-form" id="invoiceRemarksContainer">
			<aui:row style="display:none" id="remarkTemplate">
				<aui:col span="12">
					<aui:row cssClass="dayRow">
						<aui:col span="12">
							<p class="dayText">Today</p>
						</aui:col>
					</aui:row>
					<aui:row>
						<aui:col span="1" cssClass="bulletDiv">
							<p class="bullet"></p>
						</aui:col>
						<aui:col span="11">
							<aui:row>
								<p class="remarksAction"><b>Amy Marshall returned</b> for amendments</p>
								<p class="remarksTime">11:15</p>
							</aui:row>
							<aui:row>
								<p class="remarksText">This is sample remarks for testing. This is sample remarks
									for testing.This is sample remarks for testing.This is sample
									remarks for testing.123</p>
							</aui:row>
						</aui:col>
					</aui:row>
				</aui:col>
			</aui:row>
		</div>
		<div class="formContainer container formio-form no-record" style="display:none" id="remarkNoRecordTemplate">
			<aui:row >
				<img src='<%=request.getContextPath()%>/images/no-record.png' /><label class='zrecords'>0 Records</label>
			</aui:row>
		</div>
	</div>
	<div class="invoiceDetailsButtonDiv" id="submitterButtons">
		<div class="formContainer container formio-form">
			<aui:row cssClass="userAction">
				<aui:col span="12" cssClass="buttonContainer">
				<%if(submitter){ %>
					<button type="button" class="btn btn-primary submit-invoice-button" id="verification"
						onClick="doClaimAction('verification')" style="font-size: 14px;display: none;">
						<%=LabelUtil.getLabel(pageContext, themeDisplay, "workflow.submit.verification")%>
					</button>
				<%} %>		
				<%if(verifier){ %>
					<button type="button" class="btn btn-primary submit-invoice-button" id="approval"
						onClick="doClaimAction('approval')" style="font-size: 14px;display: none;">
						<%=LabelUtil.getLabel(pageContext, themeDisplay, "workflow.submit.approval")%>
					</button>
				<%} %>
					<button type="button" class="btn reject-btn" id="reject-btn"
						onClick="doClaimAction('reject')" style="font-size:14px; display: none;">
						<%=LabelUtil.getLabel(pageContext, themeDisplay, "pa.row.btn.reject")%>
					</button>
				<%if(submitter || verifier){ %>
					<button type="button" class="btn btn-default submit-invoice-button" id="returnForAmmendments"
						onClick="doClaimAction('amendments')" style="font-size: 14px;display: none;">
						<%=LabelUtil.getLabel(pageContext, themeDisplay, "workflow.return.amendments")%>
					</button>
				<%} %>
				<%if(approver){ %>
					<button type="button" class="btn btn-default submit-invoice-button" id="approve"
						onClick="doClaimAction('approve')" style="font-size: 14px;display: none;">
						<%=LabelUtil.getLabel(pageContext, themeDisplay, "workflow.approve")%>
					</button>
					<button type="button" class="btn btn-default submit-invoice-button" id="return-submitter-amendment"
						onClick="doClaimAction('samendments')" style="font-size: 11px;width: 348px!important;display: none;">
						<%=LabelUtil.getLabel(pageContext, themeDisplay, "workflow.return.submitter")%>
					</button>
					<button type="button" class="btn btn-default submit-invoice-button" id="return-verifier-amendment"
						onClick="doClaimAction('vamendments')" style="font-size: 11px;width: 348px!important;display: none;">
						<%=LabelUtil.getLabel(pageContext, themeDisplay, "workflow.return.verifier")%>
					</button>
				<%} %>	
					<button type="button" class="btn btn-default submit-invoice-button" id="cancel"
						onClick="moveToList()" style="font-size: 14px;">
						<%=LabelUtil.getLabel(pageContext, themeDisplay, "label.cancel")%>
					</button>
				</aui:col>
				
			</aui:row>
		</div>
	</div>
	<div class="loadingDiv" id="loadingDiv">
		<div class="m-blockui"
			style="position: fixed; z-index: 1031; left: 50%; top: 50%;">
			<span>Please Wait</span> <span>
				<div class="m-loader m-loader--brand"></div>
			</span>
		</div>
	</div>
	<div class="yui3-skin-sam invoice-action-dialog">
		<div id="action-dialog" hidden="true" class="modalpopupBox">
			<div id="action-dialog-box" class="modalpopupContent">
				<form class="formContainer" action="">
					<aui:row>
						<aui:col span="12">
							<h3 id="action_title">Submit for Approval ?</h3>
							<p id="action_msg">Please key in your reasons below and
								confirm your action.</p>
							<br />
							<div id="selectReasonDiv" style="display: none">
								<aui:row>
									<aui:col span="12">
									Choose a reason
									</aui:col>
								</aui:row>
								<aui:row>
									<aui:col span="12">
										<input type="radio" name="reasonsCb" value="Cheque Dishonoured" checked="checked">
										Cheque Dishonoured<br />
										<input type="radio" name="reasonsCb" value="Cheque Rejected">
										Cheque Rejected<br />
										<input type="radio" name="reasonsCb" value="Others (Refund to Credit Balance)">
										Others (Refund to Credit Balance)
									</aui:col>
								</aui:row>
							</div>
							<br />
							<textarea placeholder="Enter Reasons..." cols="" rows=""
								id="action_reason"></textarea>
						</aui:col>
					</aui:row>
					<aui:row>
						<aui:col span="12">
							<button type="button" id="popup-submit-action"
								class="btn-primary popup-submit-action pull-left" style="padding: 8px 12px !important">Submit</button>
							<button type="button" id="popup-cancel-action"
								class="btn-default popup-cancel-action pull-right">Cancel</button>
						</aui:col>
					</aui:row>
				</form>
			</div>
		</div>
	</div>
	<div class="yui3-skin-sam invoice-action-feedback-dialog">
		<div id="action-feedback-dialog" hidden="true" class="modalpopupBox">
			<div id="action-feedback-dialog-box" class="modalpopupContent">
				<form class="formContainer" action="">
					<aui:row>
						<aui:col span="12">
							<h3>Action performed successfully.</h3>
						</aui:col>
					</aui:row>
					<br />
					<aui:row>
						<aui:col span="12">
							<button type="button"
								class="btn btn-default process-popup-ok-action" onclick="moveToList()" style="margin: 0 auto; display:block">Back To List</button>
						</aui:col>
					</aui:row>
				</form>
			</div>
		</div>
	</div>

<div class="yui3-skin-sam invoice-action-dialog">
		<div id="claim-action-dialog-bound" hidden="true" class="modalpopupBox">
			<div id="claim-action-dialog-content" class="modalpopupContent">
				<form class="formContainer" action="">
			       <input type="hidden" id="action-value" value=""/>
				   <aui:row>
						<aui:col span="12">
							<h3 id="action_title">Add Remarks</h3>
							<p id="action_msg">Please key in your remarks justifying your comment action</p>
							<br/>
							<textarea placeholder="Add your text here..." cols="" rows="" id="claim_action_reason" oninput="validateRemarks()"></textarea>
						</aui:col>
				   </aui:row>
							<div id="error-remarks" style="display: none;">
								<h5 class="help-block">Please enter the reason for your
									action</h5>
							</div>
				  <aui:row>
						<aui:col span="12">
							<button type="button" id="popup-submit-action"
								class="btn-primary claim-action-dialog-submit popup-submit-action pull-left"
								style="padding: 8px 12px !important">Submit</button>
							<button type="button" id="popup-cancel-action"
								class="btn-default claim-action-dialog-cancel popup-cancel-action pull-right" onclick="hideDiv()">Cancel</button>
						</aui:col>
					</aui:row>
					
				</form>
			</div>
		</div>
	</div>
</div>
</div>
</div>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/main.js?<%=System.currentTimeMillis()%>"
	language="javascript1.2"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/billing.js?<%=System.currentTimeMillis()%>" language="javascript1.2""></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/claims.js?<%=System.currentTimeMillis()%>" language="javascript1.2""></script>

<script type="text/javascript">
var serverCurrDate ="<%=serverCurrDate%>";
var namespace =  "<portlet:namespace/>";
var ajaxUrl = "${resourceURL}";
var formStorageId = "<%=formStorageId%>";
var baseUrl = "<%=baseUrl%>";
var mode = "view";
var serverCurrDate ="<%=serverCurrDate%>";
var globalBaseCurrency ="<%=globalBaseCurrency%>";
var claimTypeMap = <%=objectMapper.writeValueAsString(claimTypeMap)%>;
var categoryMap = <%=objectMapper.writeValueAsString(categoryMap)%>;
var transactionTypeMap = <%=objectMapper.writeValueAsString(transactionTypeMap)%>;
var clientTypeMap = <%=objectMapper.writeValueAsString(clientTypeMap)%>;
var functionalMap = <%=objectMapper.writeValueAsString(functionalComponentMap)%>;
var productMap = <%=objectMapper.writeValueAsString(productMap)%>;
var productSubtypeMap = <%=objectMapper.writeValueAsString(productSubtypeMap)%>;
var submitter = <%=submitter%>;
var verifier = <%=verifier%>;
var approver = <%=approver%>;
</script>