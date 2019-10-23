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
    padding: 3px;
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

<script>
var config = {
	    detailPage: "/html/creditbalance/view.jsp",
	    viewRevenuePage : "/html/creditbalance/view-revenue.jsp",
	    refundPage : "/html/creditbalance/process-refund.jsp"
	};
</script>
<portlet:resourceURL var="resourceURL">
	<portlet:param name="sp_p_auth"
		value="<%=AuthTokenUtil.getToken(request)%>" />
</portlet:resourceURL>
<portlet:resourceURL var="downloadPdfUrl">
	<portlet:param name="action" value="downloadPdf" />
</portlet:resourceURL>
<div class="newPortlets">
	<div class="subHeader">
		<div class="container">
			<div class="inner-container">
				<aui:row>
					<aui:col span="10" cssClass="text-center">
					<h2><span><%=LabelUtil.getLabel(pageContext, themeDisplay, "cb.detail.title")%></span>
					</h2>
						
					</aui:col>
					<aui:col span="2" cssClass="text-right">
						<aui:a href="<%=dashBoardLink%>" title="Back to Home">Back to Home</aui:a>
					</aui:col>
				</aui:row>
			</div>
		</div>
	</div>

	<div class="invoiceDetailsFormDiv">
		<div class="formRoot">
			<div class="">
				<div class="formContainer container formio-form" style="padding: 50px 70px 10px 70px !important;">
					<form class="aui" id="paymentAdviceForm" name="paymentAdviceForm"
						action="">
						<aui:row>
							<aui:col span="10" cssClass="offset1">
								<div style="display: none;" class="alert alert-danger"
									role="showAlert" id="alert_msg">Select Facility Type.</div>
									<aui:input name="" type="hidden" id="CreditBalanceCode" />
									<aui:input name="" type="hidden" id="IdAndName" />
									<aui:input name="" type="hidden" id="userType" />
								<aui:row cssClass="underline-class">
									<aui:col span="3">
										<div class="form-group">
											<label class="control-label">
												<%=LabelUtil.getLabel(pageContext, themeDisplay, "cb.detail.userid")%>
											</label>
										</div>
									</aui:col>
									<aui:col span="9" cssClass="formio-component-textfield">
										<div class="form-group">
											<aui:input type="text" name="" readonly="readonly" id="userId"
												cssClass="form-control" />
										</div>
									</aui:col>
								</aui:row>
								<aui:row cssClass="underline-class">
									<aui:col span="3">
										<div class="form-group">
											<label class="control-label">
												<%=LabelUtil.getLabel(pageContext, themeDisplay, "cb.detail.username")%>
											</label>
										</div>
									</aui:col>
									<aui:col span="9" cssClass="formio-component-textfield">
										<div class="form-group">
											<aui:input type="text" name="" readonly="readonly" id="userName"
												cssClass="form-control" />
										</div>
									</aui:col>
								</aui:row>
								<aui:row cssClass="underline-class">
									<aui:col span="3">
										<div class="form-group">
											<label class="control-label">
												<%=LabelUtil.getLabel(pageContext, themeDisplay, "cb.detail.date")%>
											</label>
										</div>
									</aui:col>
									<aui:col span="9" cssClass="formio-component-textfield">
										<div class="form-group">
											<aui:input type="text" name="" readonly="readonly" id="date"
												cssClass="form-control" />
										</div>
									</aui:col>
								</aui:row>
								
								<div id="utilisationDivId" >
									<aui:row cssClass="underline-class" >
										<aui:col span="3">
											<div class="form-group">
												<label class="control-label">
													<%=LabelUtil.getLabel(pageContext, themeDisplay, "cb.detail.utilisationpurpose")%>
												</label>
											</div>
										</aui:col>
										<aui:col span="9" cssClass="formio-component-textfield">
											<div class="form-group">
												<aui:input type="text" name="" readonly="readonly" id="utilisationpurpose"
													cssClass="form-control" />
											</div>
										</aui:col>
									</aui:row>
								</div>
								<div id="paymentModeDivId">
									<aui:row cssClass="underline-class">
										<aui:col span="3">
											<div class="form-group">
												<label class="control-label">
													<%=LabelUtil.getLabel(pageContext, themeDisplay, "cb.detail.paymentmode")%>
												</label>
											</div>
										</aui:col>
										<aui:col span="9" cssClass="formio-component-textfield">
											<div class="form-group">
												<aui:input type="text" name="" readonly="readonly" id="paymentMode"
													cssClass="form-control" />
											</div>
										</aui:col>
									</aui:row>
								</div>
								<div id="amountProcessedDivId" >
									<aui:row cssClass="underline-class">
										<aui:col span="3">
											<div class="form-group">
												<label class="control-label">
													<%=LabelUtil.getLabel(pageContext, themeDisplay, "cb.detail.amountprocessed")%>
												</label>
											</div>
										</aui:col>
										<aui:col span="9" cssClass="formio-component-textfield">
											<div class="form-group">
												<aui:input type="text" name="" readonly="readonly" id="amountProcessed"
													cssClass="form-control" />
											</div>
										</aui:col>
									</aui:row>
								</div>
								<div id="miscfeeDivId">
									<aui:row cssClass="underline-class">
										<aui:col span="3">
											<div class="form-group">
												<label class="control-label">
													<%=LabelUtil.getLabel(pageContext, themeDisplay, "cb.detail.miscfee")%>
												</label>
											</div>
										</aui:col>
										<aui:col span="9" cssClass="formio-component-textfield">
											<div class="form-group">
												<aui:input type="number" name="" readonly="readonly" id="miscfee"
													cssClass="form-control" />
											</div>
										</aui:col>	
									</aui:row>
								</div>
								<div id="notesDivId" >
									<aui:row cssClass="underline-class">
										<aui:col span="3">
											<div class="form-group">
												<label class="control-label">
													<%=LabelUtil.getLabel(pageContext, themeDisplay, "cb.detail.notes")%>
												</label>
											</div>
										</aui:col>
										<aui:col span="9" cssClass="formio-component-textfield">
											<div class="form-group">
												<aui:input type="text" name="" readonly="readonly" id="notes"
													cssClass="form-control" />
											</div>
										</aui:col>
									</aui:row>
								</div>
								<div id="approvalStatusDivId">
									<aui:row cssClass="underline-class">
										<aui:col span="3">
											<div class="form-group">
												<label class="control-label">
													<%=LabelUtil.getLabel(pageContext, themeDisplay, "cb.detail.approvalstatus")%>
												</label>
											</div>
										</aui:col>
										<aui:col span="9" cssClass="formio-component-textfield">
											<div class="form-group" style="padding-top: 9px;">
												<p id="workflowStatus_verification" class="form_draft status-css" style=" background-color: #ffc48b; display: none;">
													<%=LabelUtil.getLabel(pageContext, themeDisplay, "workflow.status.verification")%>
												</p>
												<p id="workflowStatus_rejeted" class="form_draft status-css" style=" background-color: #ffc48b; display: none;">
													<%=LabelUtil.getLabel(pageContext, themeDisplay, "workflow.status.rejected")%>
												</p>
												<p id="workflowStatus_confirmed" class="form_draft status-css" style=" background-color: #ffd724; display: none;">
													<%=LabelUtil.getLabel(pageContext, themeDisplay, "workflow.status.confirmed")%>
												</p>
												<p id="workflowStatus_approval" class="form_draft status-css" style=" background-color: #ffd724; display: none;">
													<%=LabelUtil.getLabel(pageContext, themeDisplay, "workflow.status.approval")%>
												</p>
												<p id="workflowStatus_amendments" class="form_draft status-css" style=" background-color: #d5d5d5; display: none;">
													<%=LabelUtil.getLabel(pageContext, themeDisplay, "workflow.status.amendments")%>
												</p>
												<p id="workflowStatus_approved" class="form_draft status-css" style=" background-color: #ffd724; display: none;">
													<%=LabelUtil.getLabel(pageContext, themeDisplay, "workflow.status.approved")%>
												</p>
												<p id="workflowStatus_papproval" class="form_draft status-css" style=" background-color: #ffd724; display: none;">
													<%=LabelUtil.getLabel(pageContext, themeDisplay, "workflow.status.pending.approval")%>
												</p>
											</div>
										</aui:col>
									</aui:row>
								</div>
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
						<aui:col span="8" cssClass="offset2">
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
		</div>
	</div>
	<div class="invoiceDetailsButtonDiv" id="submitterButtons">
		<div class="formContainer container formio-form">
			<aui:row cssClass="userAction">
				<aui:col span="12" cssClass="buttonContainer">
				<%if(SPFinanceLocalServiceUtil.checkRole(request, FinanceConstants.FINANCE_SUBMITTER_ROLE)){ %>
					<button type="button" class="btn btn-primary submit-invoice-button" id="makeRefundBtn"
						onClick="doCreditAction('makerefund')" style="font-size: 14px;display: none;">
						<%=LabelUtil.getLabel(pageContext, themeDisplay, "cb.button.makerefund")%>
					</button>
					
					<button type="button" class="btn btn-default submit-invoice-button" id="recogniseRevenueBtn"
						onClick="doCreditAction('recogniseAsRevenue')" style="font-size: 14px;display: none;">
						<%=LabelUtil.getLabel(pageContext, themeDisplay, "cb.button.recogniseasrevenue")%>
					</button>
					
					<button type="button" class="btn btn-default submit-invoice-button" id="listingBtn"
						onClick="moveToList()" style="font-size: 14px;display: none;">
						<%=LabelUtil.getLabel(pageContext, themeDisplay, "cb.button.backtolisting")%>
					</button>
				<%} %>		
				<%if(SPFinanceLocalServiceUtil.checkRole(request, FinanceConstants.FINANCE_VERIFIER_ROLE)){ %>
					<button type="button" class="btn btn-default submit-invoice-button" id="returnForAmendmentBtn"
						onClick="doCreditAction('amendments')" style="font-size: 14px;display: none;">
						<%=LabelUtil.getLabel(pageContext, themeDisplay, "cb.button.returnamendment")%>
					</button>
					<button type="button" class="btn btn-primary submit-invoice-button" id="submit-for-approval-btn"
						onClick="doCreditAction('approval')" style="font-size: 14px;display: none;">
						<%=LabelUtil.getLabel(pageContext, themeDisplay, "cb.button.submitapproval")%>
					</button>
				<%} %>
				
				<%if(SPFinanceLocalServiceUtil.checkRole(request, FinanceConstants.FINANCE_VERIFIER_ROLE) ||
						SPFinanceLocalServiceUtil.checkRole(request, FinanceConstants.FINANCE_APPROVER_ROLE)){ %>
					<button type="button" class="btn btn-primary submit-invoice-button" id="makeAmendmentBtn"
						onClick="doCreditAction('makeAmendments')" style="font-size: 14px;display: none;">
						<%=LabelUtil.getLabel(pageContext, themeDisplay, "cb.button.makeamendments")%>
					</button>
					<button type="button" class="btn btn-default submit-invoice-button" id="rejectBtn"
						onClick="doCreditAction('reject')" style="font-size: 14px;width: 150px!important;display: none;">
						<%=LabelUtil.getLabel(pageContext, themeDisplay, "cb.button.reject")%>
					</button>
				<%} %>
				
				<%if(SPFinanceLocalServiceUtil.checkRole(request, FinanceConstants.FINANCE_APPROVER_ROLE)){ %>
					<button type="button" class="btn btn-default submit-invoice-button" id="approveBtn"
						onClick="doCreditAction('approve')" style="font-size: 14px;display: none;">
						<%=LabelUtil.getLabel(pageContext, themeDisplay, "cb.button.approve")%>
					</button>
					<select name="" id="approver-returnForAmendmentBtn" style="font-size: 14px;display: none;" class="btn btn-default form-control submit-invoice-button" onChange="doCreditAction(this.value)">
						<option disabled selected><%=LabelUtil.getLabel(pageContext, themeDisplay, "cb.button.returnamendment")%></option>
						<option value="returnToVerifier"><%=LabelUtil.getLabel(pageContext, themeDisplay, "cb.refund.verifier")%></option>
						<option value="returnToSubmitter"><%=LabelUtil.getLabel(pageContext, themeDisplay, "cb.refund.submitter")%></option>
					</select>
				<%} %>	
					<button type="button" class="btn btn-default submit-invoice-button" id="cancelBtn"
						onClick="moveToList()" style="font-size: 14px; display: none;">
						<%=LabelUtil.getLabel(pageContext, themeDisplay, "cb.button.cancel")%>
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
								class="btn btn-default popup-ok-action" onclick="moveToList()" style="margin: 0 auto; display:block">Back To List</button>
						</aui:col>
					</aui:row>
				</form>
			</div>
		</div>
	</div>
</div>
<div class="newPortlets">
<div class="yui3-skin-sam invoice-action-dialog">
		<div id="credit-action-dialog-bound" hidden="true" class="modalpopupBox">
			<div id="credit-action-dialog-content" class="modalpopupContent">
				<form class="formContainer" action="">
					<aui:row>
						<aui:col span="12">
							<h3 id="action_title">Add Remarks</h3>
							<p id="action_msg">Please key in your remarks justifying your comment action</p>
							<br />
							<textarea placeholder="Add your text here..." cols="" rows=""
								id="credit_action_reason"></textarea>
						</aui:col>
					</aui:row>
					<aui:row>
						<aui:col span="12">
							<button type="button" id="popup-submit-action"
								class="btn-primary credit-action-dialog-submit popup-submit-action pull-left"
								style="padding: 8px 12px !important">Submit</button>
							<button type="button" id="popup-cancel-action"
								class="btn-default credit-action-dialog-cancel popup-cancel-action pull-right">Cancel</button>
						</aui:col>
					</aui:row>
				</form>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/main.js?<%=System.currentTimeMillis()%>"
	language="javascript1.2"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/credit-balance.js?<%=System.currentTimeMillis()%>" language="javascript1.2""></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/billing.js?<%=System.currentTimeMillis()%>" language="javascript1.2""></script>


<script type="text/javascript">
var serverCurrDate ="<%=serverCurrDate%>";
var namespace =  "<portlet:namespace/>";
var ajaxUrl = "${resourceURL}";
var formStorageId = "<%=formStorageId%>";
var baseUrl = "<%=baseUrl%>";
var mode = "view";
var downloadPdfUrl="<%=downloadPdfUrl%>";
var serverCurrDate ="<%=serverCurrDate%>";
var globalBaseCurrency ="<%=globalBaseCurrency%>";
var claimTypeMap = <%=objectMapper.writeValueAsString(claimTypeMap)%>;
var categoryMap = <%=objectMapper.writeValueAsString(categoryMap)%>;
var transactionTypeMap = <%=objectMapper.writeValueAsString(transactionTypeMap)%>;
var clientTypeMap = <%=objectMapper.writeValueAsString(clientTypeMap)%>;
var functionalMap = <%=objectMapper.writeValueAsString(functionalComponentMap)%>;
var productMap = <%=objectMapper.writeValueAsString(productMap)%>;
var productSubtypeMap = <%=objectMapper.writeValueAsString(productSubtypeMap)%>;
</script>