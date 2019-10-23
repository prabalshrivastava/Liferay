<%@page
	import="com.sambaash.platform.srv.spservices.service.SPParameterLocalServiceUtil"%>
<%@page import="com.sambaash.platform.srv.spservices.model.SPParameter"%>
<%@page import="com.sambaash.platform.util.LabelUtil"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page
	import="com.sambaash.platform.finance.constants.FinanceConstants"%>
<%@page
	import="com.sambaash.platform.finance.service.SPFinanceLocalServiceUtil"%>
<%@page import="java.util.Map"%>
<%@page import="com.liferay.portal.model.Country"%>
<%@page import="com.liferay.portal.model.Address"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.fasterxml.jackson.databind.SerializationFeature"%>
<%@page import="com.fasterxml.jackson.databind.ObjectMapper"%>
<%@page
	import="com.sambaash.platform.srv.startupprofile.service.OrganizationLocalServiceUtil"%>
<%@page
	import="com.sambaash.platform.srv.startupprofile.model.Organization"%>
<%@page import="com.sambaash.platform.srv.spservices.model.SPListType"%>
<%@page import="java.util.List"%>
<%@page
	import="com.sambaash.platform.srv.spservices.service.SPListTypeLocalServiceUtil"%>
<%@page
	import="com.sambaash.platform.srv.spservices.service.SPListTypeLocalService"%>
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
	href='<%=request.getContextPath()%>/css/main.css?minifierType=css'></link>
<link rel='stylesheet' type="text/scss"
	href='<%=request.getContextPath()%>/css/custom.scss?minifierType=css'></link>
<link rel='stylesheet' type="text/css"
	href='<%=request.getContextPath()%>/css/billing.css?minifierType=css'></link>
<link rel='stylesheet' type="text/css"
	href='<%=request.getContextPath()%>/css/invoicing.css?minifierType=css'></link>
<script type="text/javascript"
	src="/html/js/sp/hook.js?<%=System.currentTimeMillis()%>"
	language="javascript1.2""></script>
<style>
.preview-pdf {
	display: none;
	position: fixed;
	width: 100%;
	height: 100%;
	top: 0px;
	left: 0px;
	background-color: rgba(1, 1, 1, 0.5);
	z-index: 999999;
}

.preview-pdf-iframe {
	width: 100%;
	height: 90%;
	top: 5%;
}
</style>
<portlet:defineObjects />
<%
	String formStorageId = request.getParameter("storageId");
	String baseUrl = portletPreferences.getValue("baseUrlPref", "");
	String invoiceType = portletPreferences.getValue(FinanceConstants.PREF_INVOICE_TYPE, "");
	String sendNotification = portletPreferences.getValue(FinanceConstants.PREF_SEND_NOTIFICATION, "");
	String enableApproval = portletPreferences.getValue(FinanceConstants.PREF_ENABLE_APPROVAL, "");
	ThemeDisplay td = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
	Long groupId = td.getLayout().getGroupId();
	String dashboardLink = SambaashUtil.getParameter("dashboard.link", groupId);
	String vocabularyURL = SambaashUtil.getParameter(SambaashConstants.API_VOCABULARY_URL, groupId);
	String dashBoardLink = SambaashUtil.getDashBoard();
	List<Organization> organizationList = OrganizationLocalServiceUtil.getService().getAllActiveOrganizations();
	List<SPListType> miscFeeList = SPListTypeLocalServiceUtil
			.getByKey("priceengine.pricesubscheme.miscfees.pricesubtype", groupId);
	long userId = td.getUserId();
	String baseCurrency = "";
	String country = "";
	String categoryType = portletPreferences.getValue(FinanceConstants.PREF_CATEGORY_TYPE, "IN");
	Map<String, String> categoryMap = SPFinanceLocalServiceUtil.getCategoryMap(request);
	Map<String, String> transactionTypeMap = SPFinanceLocalServiceUtil.getTransactionTypeMap(request);
	Map<String, String> clientTypeMap = SPFinanceLocalServiceUtil.getClientTypeMap(request);
	Map<String, String> functionalComponentMap = SPFinanceLocalServiceUtil.getFunctionalComponentMap(request);
	Map<String, String> functionalComponentDisplayMap = SPFinanceLocalServiceUtil
			.getFunctionalComponentDisplayMap(request);
	Map<String, String> productMap = SPFinanceLocalServiceUtil.getProductTypeMap(request);
	Map<String, String> productSubtypeMap = SPFinanceLocalServiceUtil.getProductSubTypeMap(request);
	Map<String, String> sourceTypeMap = SPFinanceLocalServiceUtil
			.getSpListTypeMap("finance.transaction.sourcetype", request);
	ObjectMapper objectMapper = new ObjectMapper();
	objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
	String serverCurrDate = sdf.format(new Date());
	SPParameter baseCurrencyParameter = SPParameterLocalServiceUtil
			.findBySPParameterGroupIdAndName(td.getScopeGroupId(), "base_currency");
	if (baseCurrencyParameter != null) {
		baseCurrency = baseCurrencyParameter.getValue();
	}
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
						<h2>
							<span>CORPORATE INVOICING</span>
						</h2>
					</aui:col>
					<aui:col span="2" cssClass="text-right">
						<aui:a href="<%=dashBoardLink%>" title="Back to Home">Back to Home</aui:a>
					</aui:col>
				</aui:row>
			</div>
		</div>
	</div>
	<div class="invoicingSetup">
		<div class="formRoot">
			<div class="">
				<div class="formContainer container formio-form"
					style="padding: 0px 20px 0px 20px;">
					<form class="aui" id="invoiceForm" name="invoiceForm" action="">
						<aui:input name="" type="hidden" id="transactionMasterCode" />
						<aui:row id="formRow" style="display: flex">
							<aui:col id="formCol" span="8"
								style="padding-top: 30px; margin: 0 auto">
								<div style="display: none;" class="alert alert-danger"
									role="showAlert" id="alert_msg">Select Facility Type.</div>
								<aui:row>
									<aui:col align="center" span="12" cssClass="formio-component-textfield invoiceForBoth" style="display: none;">
										<div class="form-group has-feedback formio-component formio-component-radio formio-component-source  formio-component-label-hidden" style="">
											<label class="control-label control-label--hidden" style=""></label>
											<div class="form-group" >
												<div class="form-check form-check-inline radio-inline radio-selected" >
													<label class="control-label form-check-label" for="invoiceTypeCP">
														<input type="radio" name="invoiceType" value="C" id="invoiceTypeCP" onclick="changeInvoiceType('C')" class="form-check-input" lang="en" >
														<span>Corporate</span>
													</label>
												</div>
												<div class="form-check form-check-inline radio-inline">
													<label class="control-label form-check-label" for="invoiceTypeIN">
														<input type="radio" name="invoiceType" value="I" id="invoiceTypeIN" onclick="changeInvoiceType('I')" class="form-check-input" lang="en" >
														<span>Individual</span>
													</label>
												</div>
											</div>
										</div>
									</aui:col>
								</aui:row>
								<aui:row cssClass="invoiceForCorporate" style="display: none;">
									<aui:col span="12" cssClass="formio-component-textfield">
										<div class="form-group">
											<label cssClass="control-label">Corporate Name<span
												class="red-star">*</span></label>
											<aui:select name="" id="organisationId"
												cssClass="form-control">
												<aui:option value="" hidden="true">
											Choose a Corporate...
										</aui:option>
											</aui:select>
										</div>
									</aui:col>
								</aui:row>
								<aui:row cssClass="invoiceForIndividual"  style="display: none;">
									<aui:col span="12" cssClass="formio-component-textfield">
										<div class="form-group">
											<label cssClass="control-label">Candidate Name<span
												class="red-star">*</span></label>
											<aui:select name="" id="candidateids"
												cssClass="form-control">
												<aui:option value="" hidden="true">
											Choose a Candidate...
										</aui:option>
											</aui:select>
										</div>
									</aui:col>
								</aui:row>
								<aui:row>
									<aui:col span="12"
										cssClass="form-field-type-textarea formio-component-columns2TextArea">
										<div class="form-group">
											<label cssClass="control-label">Description </label>
											<textarea class="aui-field-input aui-field-input-text"
												name="description" id="descriptionMain"
												placeholder="Key in the description" onchange="validateDescription(this);" onkeyup="validateDescription(this);" ></textarea>
										</div>
									</aui:col>
								</aui:row>
								<aui:row>
									<aui:col span="6" cssClass="formio-component-textfield">
										<div class="form-group">
											<label cssClass="control-label">Credit Terms (days) <span
												class="red-star">*</span></label>
											<aui:input type="number" name="" min="0"
												cssClass="form-control validateNumber" id="creditTerm"
												OnChange="creditTermChange(this.value);validateCreditTerms(this);" onkeyup="validateCreditTerms(this);"
												placeholder=" Enter Credit Term" />
										</div>
									</aui:col>
									<aui:col span="6" cssClass="formio-component-textfield">
										<div class="form-group">
											<aui:input type="text" name="dueDate" label="Due Date"
												cssClass="form-control dueDate" id="dueDate"
												placeholder=" DD/MM/YYYY" readonly="true" />
											<span class="input-group-addon" style="cursor: pointer">
												<i class="glyphicon glyphicon-calendar"></i>
											</span>
										</div>

									</aui:col>
								</aui:row>
								<aui:row>
									<aui:col span="6" cssClass="formio-component-textfield">
										<div class="form-group">
											<label cssClass="control-label">Currency Code<span
												class="red-star">*</span></label>
											<aui:select name="" id="currency"
												cssClass="form-control currency">
												<aui:option value="" hidden="true">
											Choose a Currency Code...
										</aui:option>
											</aui:select>
										</div>
									</aui:col>
								</aui:row>
								<aui:row>
									<aui:col span="12"
										cssClass="form-group form-field-type-select formio-component-columns2Select">
										<div class="form-group">
											<label cssClass="control-label">Misc Fees<span
												class="red-star">*</span></label>
											<aui:select name="" id="miscFees"
												cssClass="form-control miscFees" multiple="true"
												OnChange="miscFeeChange(this, null)">
												<aui:option value="" hidden="true">
											Choose a Misc Fee...
										</aui:option>
											</aui:select>
										</div>
									</aui:col>
								</aui:row>
								<aui:row>
									<aui:col span="12" cssClass="">
										<table id="miscFeeTableId" width="100%">
											<thead>
												<tr>
													<th>Misc Fees</th>
													<th width="40%">Description</th>
													<th>Taxable ?</th>
													<th>Unit Price (Excl GST)</th>
													<th>Quantity</th>
													<th>Fee(Excl GST)</th>
													<th></th>
												</tr>
											</thead>
											<tr id="miscContainerRow" class="miscContainerRow">
												<td class="title"></td>
												<td><input type="text" name="description"
													class="form-control description" id="description"
													placeholder="Description"  onchange="validateDescription(this);" onkeyup="validateDescription(this);" /></td>
												<td>
													<select name="taxable" id="taxable"
														class="form-control taxable"
														style="padding: 5px 5px !important; font-size: 13px !important;">
															<option value="No">No</option>
															<option value="Yes">Yes</option>
													</select>
												</td>
												<td><input type="number" name="unitPrice" min="0"
													class="form-control unitPrice" id="unitPrice"
													onchange="changePriceQnty(this)" onkeyup="validateDecimalNumber('For Unit Price',this)" onkeypress="preventOtherCharacters(event)" placeholder="Unit Price" />
												</td>
												<td><input type="number" name="quantity" min="0"
													class="form-control quantity" id="quantity" onkeyup="checkDigitis(this,3);"
													onchange="changePriceQnty(this)" onkeypress="preventOtherCharacters(event)"  placeholder="Quantity" /></td>
												<td><input type="number" name="amount" disabled min="0"
													class="form-control amount" id="amount"
													placeholder="Amount" /></td>
												<td class="action"><label style="display: none;"
													id="deleteStatus" class="deleteStatus"></label> <a
													href="javascript:void(0);"
													style="padding: 1px 1px 0px 1px !important;"
													class="btn closeIcon" onclick="removeMiscFeeRow(this)">&#10006;</a></td>
											</tr>
										</table>
									</aui:col>
								</aui:row>
								<aui:row>
									<aui:col span="12">
										<label
											style="text-align: right; margin-top: 10px; margin-right: 59px"
											cssClass="control-label" id="subTotalId"></label>
									</aui:col>
								</aui:row>
								<aui:row cssClass="userAction">
									<aui:col span="10">
										<button type="button" style="width: 170px;"
											class="btn btn-primary" id="calculateFee"
											onClick="validateFields('CALCULATE')">Calculate Fee</button>
									</aui:col>
								</aui:row>
							</aui:col>
							
						</aui:row>
						<div id="payment-section"
							style="display: none; width: 340px; margin-left: 16px; box-shadow: 0 0 30px 0 #e1e6eb; padding: 16px; padding-top: 35px; position: absolute; top: 0; bottom: 0; right: 0">
							<aui:row>
								<aui:col span="6">
									<label cssClass="control-label">Total Fee(GST Excl)</span></label>
								</aui:col>
								<aui:col span="6">
									<label id="totalFee" cssClass="control-label"
										style="text-align: right"></label>
								</aui:col>
							</aui:row>
							<aui:row>
								<aui:col span="6">
									<label cssClass="control-label">GST(SGD)</label>
								</aui:col>
								<aui:col span="6">
									<label id="totalGST" cssClass="control-label"
										style="text-align: right"></label>
								</aui:col>
							</aui:row>
							<aui:row
								style=" border-bottom: 1px solid black; padding: 0px 20px;"></aui:row>
							<br />
							<aui:row>
								<aui:col span="6">
									<label cssClass="control-label">TOTAL INVOICE AMOUNT</span></label>
								</aui:col>
								<aui:col span="6">
									<label id="totalInvoiceAmount" cssClass="control-label"
										style="text-align: right"></label>
								</aui:col>
							</aui:row>
							<div style="position: absolute; bottom: 0;">
								<aui:row>
									<aui:col span="12">
										<button type="button" class="btn btn-default btn-custom span6"
											style="width: 102px; margin-right: 0;" id="previewBtnId"
											onClick="validateFields('PREVIEW')">Preview</button>
										<button type="button" class="btn btn-primary btn-custom span6"
											style="width: 196px; margin-right: 0px;"
											id="generateInvoiceBtnId"
											onClick="validateFields('GENERATE_INVOICE')">Generate
											Invoice</button>
									</aui:col>
								</aui:row>
								<aui:row>
									<aui:col span="12">
										<button type="button"
											class="btn btn-default btn-custom span12" style="width: 100%"
											id="cancel" onClick="showCancelPopup();">Cancel</button>
									</aui:col>
								</aui:row>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<div class="yui3-skin-sam invoice-action-dialog">
		<div id="sucess-popup" hidden="true" class="modalpopupBox">
			<div id="sucess-popup-box" class="modalpopupContent">
				<form class="formContainer" action="">
					<aui:row>
						<aui:col span="12">
							<h3 id="success-msg" style="line-height: 25px; padding-top: 12px">Invoice
								Updates Successfully !</h3>
							<br />
							<p id="action_msg">You may either open & view the invoice as
								a PDF in a new tab or Submit for futher review.</p>
						</aui:col>
					</aui:row>
					<aui:row>
						<div
							style="text-align: center; margin-top: 10px; font-weight: 500;">
							<a href="javascript:void(0);" onclick="pdfRequest()">VIEW
								INVOICE (.PDF)</a>
						</div>
					</aui:row>
					<aui:row>
						<aui:col span="12">
							<button type="button" style="width: 190px;"
								class="btn-primary popup-submit-button pull-left" id="submit">SUBMIT
								FOR APPROVAL</button>
							<button id="popupexitaction" type="button" style="width: 110px;"
								class="btn cancel lightbluebtn popup-exit-action pull-right"
								onClick="moveToList()">Exit</button>
						</aui:col>
					</aui:row>
				</form>
			</div>
		</div>
	</div>
	<div class="yui3-skin-sam cancel-dialog">
		<div id="cancel-dialog-bound" hidden="true" class="modalpopupBox">
			<div id="cancel-dialog-content" class="modalpopupContent">
				<aui:row>
					<aui:col span="12">
						<h3 style="padding-top: 12px">
							<%=LabelUtil.getLabel(pageContext, td, "invoice.cancel.record")%>
						</h3>
					</aui:col>
				</aui:row>
				<aui:row>
					<aui:col span="12" style="padding-top: 13px;">
						<button type="button"
							class="btn-primary cancel-dialog-submit pull-left" id="submit">
							<%=LabelUtil.getLabel(pageContext, td, "label.yes")%>
						</button>
						<button type="button"
							class="btn cancel lightbluebtn cancel-dialog-cancel pull-right">
							<%=LabelUtil.getLabel(pageContext, td, "label.no")%>
						</button>
					</aui:col>
				</aui:row>
			</div>
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
										<input type="radio" name="reasonsCb"
											value="Cheque Dishonoured" checked="checked">
										Cheque Dishonoured<br />
										<input type="radio" name="reasonsCb" value="Cheque Rejected">
										Cheque Rejected<br />
										<input type="radio" name="reasonsCb"
											value="Others (Refund to Credit Balance)">
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
								class="btn-primary popup-submit-action pull-left"
								style="padding: 8px 12px !important">Submit</button>
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
							<button type="button" class="btn btn-default"
								onclick="moveToList();" style="margin: 0 auto; display: block">Back
								To List</button>
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
							<button type="button" class="btn btn-default popup-ok-action"
								style="margin: 0 auto; display: block">Back To List</button>
						</aui:col>
					</aui:row>
				</form>
			</div>
		</div>
	</div>
	<div id="previewPdf" class="preview-pdf">
		<button type="button" style="float: right; background: white; border-radius: 50%; height: 30px; width: 30px;" onclick="hidePreviewPDF()" >×</button>
		<iframe id="invoicePDF" class="preview-pdf-iframe"></iframe>
		
	</div>
	<div class="loadingDiv" id="loadingDiv">
		<div class="m-blockui"
			style="position: fixed; z-index: 1031; left: 50%; top: 50%;">
			<span>Please Wait</span> <span>
				<div class="m-loader m-loader--brand"></div>
			</span>
		</div>
	</div>
</div>

<script type="text/javascript">
var namespace =  "<portlet:namespace/>";
var ajaxUrl = "${resourceURL}";
var formStorageId = "<%=formStorageId%>";
var vocabularyURL = "<%=vocabularyURL%>";
var organizationList = <%=objectMapper.writeValueAsString(organizationList)%>;
var miscFeeList = <%=objectMapper.writeValueAsString(miscFeeList)%>;
var mode = "edit";
var baseUrl = "<%=baseUrl%>";
var invoiceType = "<%=invoiceType%>";
var sendNotification = "<%=sendNotification%>";
var enableApproval = "<%=enableApproval%>";
enableApproval = (enableApproval==""?"true":enableApproval);
var sendEmailToCandidate = false;
var userId = "<%=userId%>";
var country = "<%=country%>";
var baseCurrency = "<%=baseCurrency%>";
var categoryMap = <%=objectMapper.writeValueAsString(categoryMap)%>;
var transactionTypeMap = <%=objectMapper.writeValueAsString(transactionTypeMap)%>;
var clientTypeMap = <%=objectMapper.writeValueAsString(clientTypeMap)%>;
var functionalMap = <%=objectMapper.writeValueAsString(functionalComponentMap)%>;
var productMap = <%=objectMapper.writeValueAsString(productMap)%>;
var productSubtypeMap = <%=objectMapper.writeValueAsString(productSubtypeMap)%>;
var sourceTypeMap = <%=objectMapper.writeValueAsString(sourceTypeMap)%>;
var downloadPdfUrl="<%=downloadPdfUrl%>";
var categoryType="<%=categoryType%>";
var categoryMap = <%=objectMapper.writeValueAsString(categoryMap)%>;
var transactionTypeMap = <%=objectMapper.writeValueAsString(transactionTypeMap)%>;
var clientTypeMap = <%=objectMapper.writeValueAsString(clientTypeMap)%>;
var functionalMap = <%=objectMapper.writeValueAsString(functionalComponentMap)%>;
var functionalDispMap = <%=objectMapper.writeValueAsString(functionalComponentDisplayMap)%>;
var productMap = <%=objectMapper.writeValueAsString(productMap)%>;
var productSubtypeMap = <%=objectMapper.writeValueAsString(productSubtypeMap)%>;
var serverCurrDate ="<%=serverCurrDate%>";
var candidateMap={};
var isPreviewPDF = false;
</script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/invoice-actions.js?<%=System.currentTimeMillis()%>"
	language="javascript1.2"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/calculation.js?<%=System.currentTimeMillis()%>"
	language="javascript1.2"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/invoicing.js?<%=System.currentTimeMillis()%>"
	language="javascript1.2"></script>

<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/main.js?<%=System.currentTimeMillis()%>"
	language="javascript1.2"></script>
<script>
function hidePreviewPDF(){
	document.getElementById("previewPdf").style="display:none";
}
function changeInvoiceType(t){
	if(t=="I"){
		document.getElementsByClassName("invoiceForCorporate")[0].style = "display:none;";
		document.getElementsByClassName("invoiceForIndividual")[0].style = "";
		getEID("invoiceTypeIN").checked = true;
	}
	else{
		document.getElementsByClassName("invoiceForCorporate")[0].style = "";
		document.getElementsByClassName("invoiceForIndividual")[0].style = "display:none;";
		getEID("invoiceTypeCP").checked = true;
	}
}

if(invoiceType=="BOTH" || invoiceType==""){
	document.getElementsByClassName("invoiceForBoth")[0].style = "";
	document.getElementsByClassName("invoiceForCorporate")[0].style = "";
	document.getElementsByClassName("invoiceForIndividual")[0].style = "display:none;";
	document.getElementById("invoiceTypeCP").checked = true;
}
else{
	document.getElementsByClassName("invoiceForBoth")[0].style = "display:none;";
	changeInvoiceType(invoiceType);
}

var allCC = '<option class="" value="" hidden="true"> Choose a Currency Code... </option> <option value="AFN">AFN</option><option value="ALL">ALL</option><option value="AMD">AMD</option><option value="AOA">AOA</option><option value="ARS">ARS</option><option value="AUD">AUD</option><option value="AWG">AWG</option><option value="AZN">AZN</option><option value="BAM">BAM</option><option value="BBD">BBD</option><option value="BDT">BDT</option><option value="BGN">BGN</option><option value="BHD">BHD</option><option value="BIF">BIF</option><option value="BMD">BMD</option><option value="BND">BND</option><option value="BOB">BOB</option><option value="BOV">BOV</option><option value="BRL">BRL</option><option value="BSD">BSD</option><option value="BTN">BTN</option><option value="BWP">BWP</option><option value="BYR">BYR</option><option value="BZD">BZD</option><option value="CAD">CAD</option><option value="CVE">CVE</option><option value="DKK">DKK</option><option value="DZD">DZD</option><option value="EUR">EUR</option><option value="GBP">GBP</option><option value="INR">INR</option><option value="KHR">KHR</option><option value="MYR">MYR</option><option value="NOK">NOK</option><option value="SGD">SGD</option><option value="USD">USD</option><option value="XAF">XAF</option><option value="XCD">XCD</option><option value="XOF">XOF</option>';
getEID(namespace + "currency").innerHTML = allCC;

function getCandidateList(status){
	var datas = {};
	datas.formType = "candidate";
	//datas.conditions = ["contentJson.Status="+status,"contentJson.SponsorshipType="+sponsorshipType,"size="+2147483647];
	datas.conditions = ["contentJson.Status="+status,"size="+2147483647];
	ajaxCallAPI(
			'GET',
			"searchList",
			datas,
			function(response) {
				if(this.get("responseData") && this.get("responseData").content){
					valueList = this.get("responseData").content;
					var opt = "<option value='' hidden='true'> Choose a Candidate... </option>";
					for(var i=0; i<valueList.length; i++) {
						var val = valueList[i];
						if(val.hasOwnProperty("contentJson") && val.contentJson.hasOwnProperty("SponsorshipType") && (val.contentJson.SponsorshipType == "Self Sponsored" || val.contentJson.SponsorshipType == "Individual")){
							candidateMap[val.storageId] = val.firstName +' '+ (val.hasOwnProperty("lastName") && val.lastName!=null?val.lastName:"");	
						}
					}
					for(var k in candidateMap){
						if(k != undefined){
							opt = opt + "<option value='"+k+"'>"+candidateMap[k]+"</option>";
						}
					}
					getEID(namespace + "candidateids").innerHTML = opt;
				}
			}, function() {
				
			});
}
getCandidateList("active");
getCandidateList("Active");
</script>