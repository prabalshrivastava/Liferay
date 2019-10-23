<%@page import="com.fasterxml.jackson.databind.SerializationFeature"%>
<%@page import="com.fasterxml.jackson.databind.ObjectMapper"%>
<%@page import="com.sambaash.platform.finance.service.SPFinanceLocalServiceUtil"%>
<%@page import="com.sambaash.platform.constant.SystemSetupConstants"%>
<%@page import="com.sambaash.platform.util.LabelUtil"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page
	import="com.sambaash.platform.finance.constants.FinanceConstants"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
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
<script type="text/javascript"
	src="/html/js/sp/hook.js?<%=System.currentTimeMillis()%>"
	language="javascript1.2""></script>
<portlet:defineObjects />
<%
	String formStorageId = request.getParameter("storageId");
	String modelName = portletPreferences.getValue(SystemSetupConstants.PREF_MODEL_NAME, SystemSetupConstants.DEFAULTMODELAME);
	String baseUrl = portletPreferences.getValue("baseUrlPref", "");
	ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
	Long groupId = themeDisplay.getLayout().getGroupId();
	String dashBoardLink = SambaashUtil.getDashBoard();
	
	Map<String, String> categoryMap = SPFinanceLocalServiceUtil.getCategoryMap(request);
	Map<String, String> transactionTypeMap = SPFinanceLocalServiceUtil.getTransactionTypeMap(request);
	Map<String, String> clientTypeMap = SPFinanceLocalServiceUtil.getClientTypeMap(request);
	Map<String, String> functionalComponentMap = SPFinanceLocalServiceUtil.getFunctionalComponentMap(request);
	Map<String, String> productMap = SPFinanceLocalServiceUtil.getProductTypeMap(request);
	Map<String, String> productSubtypeMap = SPFinanceLocalServiceUtil.getProductSubTypeMap(request);
	ObjectMapper objectMapper = new ObjectMapper();
	objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);

%>
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
						<h2><span><%=LabelUtil.getLabel(pageContext, themeDisplay, "dcc.detail.title")%></span></h2>
					</aui:col>
					<aui:col span="2" cssClass="text-right">
						<aui:a href="<%=dashBoardLink%>" title="Back to Home">Back to Home</aui:a>
					</aui:col>
				</aui:row>
			</div>
		</div>
	</div>
	<div class="invoiceDetailsFormDiv">
		<div class="">
			<div class="formContainer container formio-form">
				<form class="aui" id="invoiceDetailsForm" name="invoiceDetailsForm" action="">
					<div style="display: none;" class="alert alert-danger"
						role="showAlert" id="alert_msg_id"></div>
						<aui:input name="" type="hidden" id="DCCReportCode" />
				<aui:row>
					<aui:col span="10" cssClass="offset1">
						<aui:col span="6">	
							<aui:row>
								<aui:col span="4">
									<div class="form-group">
										<label class="control-label"> <%=LabelUtil.getLabel(pageContext, themeDisplay, "dcc.detail.division")%>
										</label>
									</div>
								</aui:col>
								<aui:col span="8" cssClass="formio-component-textfield">
									<div class="form-group">
										<aui:input type="text" name="" readonly="readonly"
											id="division" cssClass="form-control" />
									</div>
								</aui:col>
							</aui:row>
							<aui:row>
								<aui:col span="4">
									<div class="form-group">
										<label class="control-label"> <%=LabelUtil.getLabel(pageContext, themeDisplay, "dcc.detail.cd")%>
										</label>
									</div>
								</aui:col>
								<aui:col span="8" cssClass="formio-component-textfield">
									<div class="form-group">
										<aui:input type="text" name="" readonly="readonly" id="collectionDate"
											cssClass="form-control" />
									</div>
								</aui:col>
							</aui:row>
							<aui:row>
								<aui:col span="4">
									<div class="form-group">
										<label class="control-label"> <%=LabelUtil.getLabel(pageContext, themeDisplay, "dcc.detail.sd")%>
										</label>
									</div>
								</aui:col>
								<aui:col span="8" cssClass="formio-component-textfield">
									<div class="form-group">
										<aui:input type="text" name="" readonly="readonly"
											id="submissionDate" cssClass="form-control" />
									</div>
								</aui:col>
							</aui:row>
							<aui:row>
								<aui:col span="4">
									<div class="form-group">
										<label class="control-label"> <%=LabelUtil.getLabel(pageContext, themeDisplay, "dcc.detail.tac")%>
										</label>
									</div>
								</aui:col>
								<aui:col span="8" cssClass="formio-component-textfield">
									<div class="form-group">
										<aui:input type="text" name="" readonly="readonly"
											id="totalCashAmt" cssClass="form-control" />
									</div>
								</aui:col>
							</aui:row>
							<aui:row>
								<aui:col span="4">
									<div class="form-group">
										<label class="control-label"> <%=LabelUtil.getLabel(pageContext, themeDisplay, "dcc.detail.tan")%>
										</label>
									</div>
								</aui:col>
								<aui:col span="8" cssClass="formio-component-textfield">
									<div class="form-group">
										<aui:input type="text" name="" readonly="readonly"
											id="totalNetsAmt" cssClass="form-control" />
									</div>
								</aui:col>
							</aui:row>
							<aui:row>
								<aui:col span="4">
									<div class="form-group">
										<label class="control-label"> <%=LabelUtil.getLabel(pageContext, themeDisplay, "dcc.detail.tacc")%>
										</label>
									</div>
								</aui:col>
								<aui:col span="8" cssClass="formio-component-textfield">
									<div class="form-group">
										<aui:input type="text" name="" readonly="readonly"
											id="totalCcAmt" cssClass="form-control" />
									</div>
								</aui:col>
							</aui:row>
							<aui:row>
								<aui:col span="4">
									<div class="form-group">
										<label class="control-label"  style="line-height: 22px !important;"> <%=LabelUtil.getLabel(pageContext, themeDisplay, "dcc.detail.tact")%>
										</label>
									</div>
								</aui:col>
								<aui:col span="8" cssClass="formio-component-textfield">
									<div class="form-group">
										<aui:input type="text" name="" readonly="readonly"
											id="totalCreditTransferAmt" cssClass="form-control" />
									</div>
								</aui:col>
							</aui:row>
							<aui:row>
								<aui:col span="4">
									<div class="form-group">
										<label class="control-label"  style="line-height: 22px !important;"> <%=LabelUtil.getLabel(pageContext, themeDisplay, "dcc.detail.tact")%>
										</label>
									</div>
								</aui:col>
								<aui:col span="8" cssClass="formio-component-textfield">
									<div class="form-group">
										<aui:input type="text" name="" readonly="readonly"
											id="totalCreditTransferAmt" cssClass="form-control" />
									</div>
								</aui:col>
							</aui:row>
							<aui:row>
								<aui:col span="4">
									<div class="form-group">
										<label class="control-label"  style="line-height: 22px !important;"> <%=LabelUtil.getLabel(pageContext, themeDisplay, "dcc.detail.taaxs")%>
										</label>
									</div>
								</aui:col>
								<aui:col span="8" cssClass="formio-component-textfield">
									<div class="form-group">
										<aui:input type="text" name="" readonly="readonly"
											id="totalAXSAmt" cssClass="form-control" />
									</div>
								</aui:col>
							</aui:row>
							<aui:row>
								<aui:col span="4">
									<div class="form-group">
										<label class="control-label"> <%=LabelUtil.getLabel(pageContext, themeDisplay, "dcc.detail.submitBy")%>
										</label>
									</div>
								</aui:col>
								<aui:col span="8" cssClass="formio-component-textfield">
									<div class="form-group">
										<aui:input type="text" name="" readonly="readonly"
											id="submittedBy" cssClass="form-control" />
									</div>
								</aui:col>
							</aui:row>
							<aui:row>
								<aui:col span="4">
									<div class="form-group">
										<label class="control-label"> <%=LabelUtil.getLabel(pageContext, themeDisplay, "dcc.detail.ackByAA")%>
										</label>
									</div>
								</aui:col>
								<aui:col span="8" cssClass="formio-component-textfield">
									<div class="form-group">
										<aui:input type="text" name="" readonly="readonly"
											id="acknowledgedByAa" cssClass="form-control" />
									</div>
								</aui:col>
							</aui:row>
							<aui:row>
							<aui:col span="4">
								<div class="form-group">
									<label class="control-label"> <%=LabelUtil.getLabel(pageContext, themeDisplay, "dcc.detail.ackDateAA")%>
									</label>
								</div>
							</aui:col>
							<aui:col span="8" cssClass="formio-component-textfield">
								<div class="form-group">
									<aui:input type="text" name="" readonly="readonly"
										id="acknowledgedDateAa" cssClass="form-control" />
								</div>
							</aui:col>
						</aui:row>
						</aui:col>
						<aui:col span="6">	
						<aui:row>
							<aui:col span="4">
								<div class="form-group">
									<label class="control-label "  style="line-height: 22px !important;"> <%=LabelUtil.getLabel(pageContext, themeDisplay, "dcc.detail.ncse")%>
									</label>
								</div>
							</aui:col>
							<aui:col span="8" cssClass="formio-component-textfield">
								<div class="form-group">
									<aui:input type="text" name="" id="noOfCashSealedEnv" cssClass="form-control" />
								</div>
							</aui:col>
						</aui:row>
						<aui:row>
							<aui:col span="4">
								<div class="form-group">
									<label class="control-label"  style="line-height: 22px !important;"> <%=LabelUtil.getLabel(pageContext, themeDisplay, "dcc.detail.ncds")%>
									</label>
								</div>
							</aui:col>
							<aui:col span="8" cssClass="formio-component-textfield">
								<div class="form-group">
									<aui:input type="text" name="" readonly="readonly"
										id="noOfChequeBankDraftSubmitted" cssClass="form-control" />
								</div>
							</aui:col>
						</aui:row>
						<aui:row>
							<aui:col span="4">
								<div class="form-group">
									<label class="control-label"> <%=LabelUtil.getLabel(pageContext, themeDisplay, "dcc.detail.taic")%>
									</label>
								</div>
							</aui:col>
							<aui:col span="8" cssClass="formio-component-textfield">
								<div class="form-group">
									<aui:input type="text" name="" readonly="readonly"
										id="totalChequeAmt" cssClass="form-control" />
								</div>
							</aui:col>
						</aui:row>
						<aui:row>
							<aui:col span="4">
								<div class="form-group">
									<label class="control-label"> <%=LabelUtil.getLabel(pageContext, themeDisplay, "dcc.detail.taibd")%>
									</label>
								</div>
							</aui:col>
							<aui:col span="8" cssClass="formio-component-textfield">
								<div class="form-group">
									<aui:input type="text" name="" readonly="readonly"
										id="totalBankDraftAmt" cssClass="form-control" />
								</div>
							</aui:col>
						</aui:row>
						<aui:row>
							<aui:col span="4">
								<div class="form-group">
									<label class="control-label"  style="line-height: 22px !important;"> <%=LabelUtil.getLabel(pageContext, themeDisplay, "dcc.detail.tair")%>
									</label>
								</div>
							</aui:col>
							<aui:col span="8" cssClass="formio-component-textfield">
								<div class="form-group ">
									<aui:input type="text" name="" readonly="readonly"
										id="totalInwardRemittanceAmt" cssClass="form-control" />
								</div>
							</aui:col>
						</aui:row>
						
						<aui:row>
							<aui:col span="4">
								<div class="form-group">
									<label class="control-label"> <%=LabelUtil.getLabel(pageContext, themeDisplay, "dcc.detail.tasa")%>
									</label>
								</div>
							</aui:col>
							<aui:col span="8" cssClass="formio-component-textfield">
								<div class="form-group">
									<aui:input type="text" name="" readonly="readonly"
										id="totalStripeAmt" cssClass="form-control" />
								</div>
							</aui:col>
						</aui:row>
						<aui:row>
							<aui:col span="4">
								<div class="form-group">
									<label class="control-label"> <%=LabelUtil.getLabel(pageContext, themeDisplay, "dcc.detail.tao")%>
									</label>
								</div>
							</aui:col>
							<aui:col span="8" cssClass="formio-component-textfield">
								<div class="form-group">
									<aui:input type="text" name="" readonly="readonly"
										id="totalOthersAmt" cssClass="form-control" />
								</div>
							</aui:col>
						</aui:row>
						<aui:row>
							<aui:col span="4">
								<div class="form-group">
									<label class="control-label"> <%=LabelUtil.getLabel(pageContext, themeDisplay, "dcc.detail.ackByFND")%>
									</label>
								</div>
							</aui:col>
							<aui:col span="8" cssClass="formio-component-textfield">
								<div class="form-group">
									<aui:input type="text" name="" readonly="readonly"
										id="acknowledgedByFnd" cssClass="form-control" />
								</div>
							</aui:col>
						</aui:row>
						<aui:row>
							<aui:col span="4">
								<div class="form-group">
									<label class="control-label"> <%=LabelUtil.getLabel(pageContext, themeDisplay, "dcc.detail.ackDateFND")%>
									</label>
								</div>
							</aui:col>
							<aui:col span="8" cssClass="formio-component-textfield">
								<div class="form-group">
									<aui:input type="text" name="" readonly="readonly"
										id="acknowledgedDateFnd" cssClass="form-control" />
								</div>
							</aui:col>
						</aui:row>
						<aui:row>
						<aui:col span="4">
							<div class="form-group">
								<label class="control-label"> <%=LabelUtil.getLabel(pageContext, themeDisplay, "dcc.detail.as")%>
								</label>
							</div>
						</aui:col>
						<aui:col span="8" cssClass="formio-component-textfield">
							<div class="form-group">
								<aui:input type="text" name="" readonly="readonly"
									id="acknowledgementStatus" cssClass="form-control" />
							</div>
						</aui:col>
					</aui:row>
					</aui:col>
					</aui:col>
				</aui:row>
				<aui:row>
					<aui:col span="10" cssClass="offset1">
						<aui:col span="12">	
							<aui:row>
								<aui:col span="2">
									<div class="form-group">
										<label class="control-label"> <%=LabelUtil.getLabel(pageContext, themeDisplay, "cb.detail.notes")%>
										</label>
									</div>
								</aui:col>
								<aui:col span="10" cssClass="formio-component-textfield">
									<div class="form-group" style="margin-left: -20px !important;">
										<textarea placeholder="Enter Notes" cols="" rows="3"
										id="notes"></textarea>
									</div>
								</aui:col>
							</aui:row>
						</aui:col>
					</aui:col>
				</aui:row>
				</form>
				<aui:row cssClass="userAction">
					<aui:col span="2"></aui:col>
					<aui:col span="8">
						<button type="button" style="width: 180px;"
							onclick="doDccAction('pdf')" class="btn btn-primary">
							<%=LabelUtil.getLabel(pageContext, themeDisplay, "dcc.detail.dccBtn")%>
						</button>
					</aui:col>
					<aui:col span="2"></aui:col>
				</aui:row>
			</div>
		</div>
	</div>
	<div class="remarksHeader">
		<div class="container">
			<aui:row>
				<aui:col span="12" cssClass="text-center">
					<h4 style="float: left"><%=LabelUtil.getLabel(pageContext, themeDisplay, "lordetail.remarks.title")%></h4>
					<h4 id="totalRemarks" style="float: right">(Total: 0 Remarks)</h4>
				</aui:col>
			</aui:row>
		</div>
	</div>
	<div class="invoiceRemarksDiv">
		<div class="formContainer container formio-form"
			id="invoiceRemarksContainer">
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
								<p class="remarksAction">
									<b>Amy Marshall returned</b> for amendments
								</p>
								<p class="remarksTime">11:15</p>
							</aui:row>
							<aui:row>
								<p class="remarksText">This is sample remarks for
									testing.This is sample remarks for testing.This is sample
									remarks for testing.This is sample remarks for testing.123</p>
							</aui:row>
						</aui:col>
					</aui:row>
				</aui:col>
			</aui:row>
		</div>
	</div>
	<div class="invoiceDetailsButtonDiv" id="submitterButtons">
		<div class="formContainer container formio-form">
			<aui:row cssClass="userAction">
				<aui:col span="12" cssClass="buttonContainer">
					<div>
						<%
							if (SPFinanceLocalServiceUtil.checkRole(request, FinanceConstants.EB_SUBMITTER_ROLE)) {
						%>
							<button type="button" class="btn btn-primary workflow-submit-for-akn" id="submitAckBtn"
								onClick="doDccAction('ackAA')" style="display: none; width: 315px;">
								<%=LabelUtil.getLabel(pageContext, themeDisplay, "dcc.detail.submitAckBtn")%>
							</button>
						<%
							}
						%>
						<%
							if (SPFinanceLocalServiceUtil.checkRole(request, FinanceConstants.AA_EXECUTIVE_ROLE)) {
						%>
							<button type="button" class="btn btn-primary workflow-submit-for-approval" id="ackAA"
								onClick="doDccAction('ackFND')" style="display: none;">
								<%=LabelUtil.getLabel(pageContext, themeDisplay, "dcc.detail.ackBtn")%>
							</button>
						<%
							}
						%>
						<%
							if (SPFinanceLocalServiceUtil.checkRole(request, FinanceConstants.FINANCE_EXECUTIVE_ROLE)) {
						%>
							<button type="button" class="btn btn-primary workflow-submit-for-approval" id="ackFND"
								onClick="doDccAction('acknowledge')" style="display: none;">
								<%=LabelUtil.getLabel(pageContext, themeDisplay, "dcc.detail.ackBtn")%>
							</button>
						<%
							}
						%>
						<button type="button" class="btn btn-default workflow-return-for-amendments" id="ammendmentsBtn"
							onClick="doDccAction('ammendments')" style="display: none">
							<%=LabelUtil.getLabel(pageContext, themeDisplay, "cb.button.returnamendment")%>
						</button>
						<button type="button" class="btn btn-default" id="back"
							onclick="goBack();" style="width: 100px">
							<%=LabelUtil.getLabel(pageContext, themeDisplay, "cb.button.cancel")%>
						</button>
					</div>
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
		<div id="dcc-action-dialog-bound" hidden="true" class="modalpopupBox">
			<div id="dcc-action-dialog-content" class="modalpopupContent">
				<form class="formContainer" action="">
					<aui:row>
						<aui:col span="12">
							<h3 id="action_title">Add Remarks</h3>
							<p id="action_msg">Please key in your reasons below and
								confirm your action.</p>
							<br />
							<textarea placeholder="Enter Reasons..." cols="" rows=""
								id="dcc_action_reason"></textarea>
						</aui:col>
					</aui:row>
					<aui:row>
						<aui:col span="12">
							<button type="button" id="popup-submit-action"
								class="btn-primary dcc-action-dialog-submit popup-submit-action pull-left"
								style="padding: 8px 12px !important">Submit</button>
							<button type="button" id="popup-cancel-action"
								class="btn-default dcc-action-dialog-cancel popup-cancel-action pull-right">Cancel</button>
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
<script type="text/javascript">
var namespace =  "<portlet:namespace/>";

var downloadPdfUrl="<%=downloadPdfUrl%>";

var categoryMap = <%=objectMapper.writeValueAsString(categoryMap)%>;
var transactionTypeMap = <%=objectMapper.writeValueAsString(transactionTypeMap)%>;
var clientTypeMap = <%=objectMapper.writeValueAsString(clientTypeMap)%>;
var functionalMap = <%=objectMapper.writeValueAsString(functionalComponentMap)%>;
var productMap = <%=objectMapper.writeValueAsString(productMap)%>;
var productSubtypeMap = <%=objectMapper.writeValueAsString(productSubtypeMap)%>;


var ajaxUrl = "${resourceURL}";
var formStorageId = "<%=formStorageId%>";
var modelName = "<%=modelName%>";
var baseUrl = "<%=baseUrl%>";
var mode = "view";
</script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/billing.js?<%=System.currentTimeMillis()%>"
	language="javascript1.2"></script>
	<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/dcc-report.js?<%=System.currentTimeMillis()%>"
	language="javascript1.2"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/main.js?<%=System.currentTimeMillis()%>"
	language="javascript1.2"></script> 