<%@page
	import="com.sambaash.platform.srv.spservices.service.SPParameterLocalService"%>
<%@page
	import="com.sambaash.platform.srv.spservices.service.SPParameterLocalServiceUtil"%>
<%@page import="com.sambaash.platform.srv.spservices.model.SPParameter"%>
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
<link rel='stylesheet' type="text/css"
	href='<%=request.getContextPath()%>/css/collect-payment.css?minifierType=css'></link>
<script type="text/javascript"
	src="/html/js/sp/hook.js?<%=System.currentTimeMillis()%>"
	language="javascript1.2""></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/billing.js?<%=System.currentTimeMillis()%>"
	language="javascript1.2"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/calculation.js?<%=System.currentTimeMillis()%>"
	language="javascript1.2"></script>

<portlet:defineObjects />
<%
	String formStorageId = request.getParameter("storageId");
	String baseUrl = portletPreferences.getValue("baseUrlPref", "");
	ThemeDisplay td = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
	Long groupId = td.getLayout().getGroupId();
	String dashboardLink = SambaashUtil.getParameter("dashboard.link", groupId);
	String vocabularyURL = SambaashUtil.getParameter(SambaashConstants.API_VOCABULARY_URL, groupId);
	String globalPriceScheme = SambaashUtil.getParameter("miscellaneous.receipt.price.scheme.code", groupId);

	String dashBoardLink = SambaashUtil.getDashBoard();
	List<SPListType> miscFeeList = SPListTypeLocalServiceUtil
			.getByKey("priceengine.pricesubscheme.miscfees.pricesubtype", groupId);
	ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
	long userId = themeDisplay.getUserId();
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
%>
<portlet:resourceURL var="resourceURL">
	<portlet:param name="sp_p_auth"
		value="<%=AuthTokenUtil.getToken(request)%>" />
</portlet:resourceURL>
<portlet:resourceURL var="downloadPdfUrl">
	<portlet:param name="action" value="downloadPdf" />
</portlet:resourceURL>
<jsp:include page="payment-section.jsp" />
<style>
.formPadding {
	background: #f7f9fc !important;
}
</style>
<div class="newPortlets">
	<div class="subHeader">
		<div class="container">
			<div class="inner-container">
				<aui:row>
					<aui:col span="10" cssClass="text-center">
						<h2>
							<span>MISCELLANEOUS RECEIPT</span>
						</h2>
					</aui:col>
					<aui:col span="2" cssClass="text-right">
						<aui:a href="<%=dashBoardLink%>" title="Back to Home">Back to Home</aui:a>
					</aui:col>
				</aui:row>
			</div>
		</div>
	</div>
	<div class="miscFeeSetup">
		<div class="formRoot">
			<div class="innerFormRoot">
				<div class="formContainer container formio-form"
					style="padding: 30px 55px 35px 55px !important; background-color: #f7f9fc !important;">
					<form class="aui" id="miscFeesForm" name="miscFeesForm" action="">
						<aui:input name="" type="hidden" id="transactionMasterCode" />
						<aui:row>
							<aui:col span="12">
								<div style="display: none;" class="alert alert-danger"
									role="showAlert" id="alert_msg_id">Select Facility Type.</div>

								<aui:row>
									<aui:col span="12"
										cssClass="formio-component-textfield text-center">
										<label>Who are you preparing the Miscellaneous receipt
											for ?</label>
										<input onChange="receiptChange(this.value)" type="radio"
											name="receiptFor" value="Anonymous" checked="checked">Anonymous
								<input onChange="receiptChange(this.value)" type="radio"
											name="receiptFor" value="Candidate">Candidate
							</aui:col>
								</aui:row>
								<aui:row id="candidateDivId" style="display:none">
									<aui:col span="12" cssClass="formio-component-textfield">
										<div class="form-group">
											<label cssClass="control-label">&nbsp;&nbsp;Candidate Name & ID</label>
											<aui:select name="" id="candidateId" cssClass="form-control">
												<aui:option value="" hidden="true">
											Choose a Candidate...
										</aui:option>
											</aui:select>
										</div>
										<br />
									</aui:col>
								</aui:row>
								<aui:row>
									<aui:col span="12" cssClass="formio-component-textfield">
										<div class="form-group" style="margin-bottom: 0px;">
											<label cssClass="control-label">&nbsp;&nbsp;Misc. Fees (Fee
												Scheme)</label>
											<aui:select name="" id="feeSchemeId" cssClass="form-control"
												OnChange="feeSchemeDDChange()">
												<aui:option value="">
											Choose a Miscellaneous Fee...
										</aui:option>
											</aui:select>
										</div>
									</aui:col>
								</aui:row>
								<aui:row>
									<aui:col span="12" cssClass="">
										<table id="feeSchemeTableId"
											style="display: none; width: 100% !important; margin-top: 10px !important;">
											<thead>
												<tr>
													<th width="60%">Misc Fees</th>
													<th width="0%" style="display: none;">Taxable</th>
													<th width="0%" style="display: none;">Currency</th>
													<th width="10%">Unit Price (Excl GST)</th>
													<th width="10%">Quantity</th>
													<th width="18%">Fee($)</th>
													<th width="2%"></th>
												</tr>
											</thead>
											<tr id="feeSchemeContainerRow"
												class="feeSchemeContainerRow text-center">
												<td class="title"></td>
												<td id="taxable" class="taxable"></td>
												<td id="currency" class="currency"></td>
												<td id="unitPrice" class="unitPrice"></td>
												<td><input type="number" name="quantity" step="1"
													class="form-control quantity" id="quantity"
													onChange="changePriceQnty(this, feeSchemeTotalId.id)"
													placeholder="Quantity" /></td>
												<td><input type="number"
													name="amount" disabled class="form-control amount"
													id="amount" placeholder="Amount" />
													<input type="hidden" class="unitTax" /> <input
													type="hidden" class="totalTax" /></td>
												<td class="action"><input type="text"
													style="display: none;" id="deleteStatus" value=""
													class="deleteStatus"> <a href="javascript:void(0);"
													style="padding: 1px 1px 0px 1px !important;"
													class="btn closeIcon" onclick="removeFeeSchemeRow(this)">&#10006;</a>
												</td>
											</tr>
											<tr id="feeSchemeTotalContainerRow"
												class="totalContainer text-center">
												<td></td>
												<td style="display: none;"></td>
												<td style="display: none;"></td>
												<td></td>
												<td><b>Total</b></td>
												<td class="total" style="padding-right: 30px !important;text-align: right;"></td>
												<td></td>
											</tr>
										</table>
										<div style="display: none">
											<label id="feeSchemeTotalId"></label>
										</div>
									</aui:col>
								</aui:row>
								<aui:row>
									<aui:col span="12" cssClass="formio-component-textfield">
										<div class="form-group" style="margin-bottom: 0px;">
											<label cssClass="control-label">&nbsp;&nbsp;Misc Fees (Adhoc)</label>
											<aui:select name="" id="miscAdhocFeesId"
												OnChange="adhocFeeDDChange()" cssClass="form-control">
												<aui:option value="">
											Choose a Misc Fee...
										</aui:option>
											</aui:select>
										</div>
									</aui:col>
								</aui:row>
								<aui:row>
									<aui:col span="12" cssClass="">
										<table id="adhocFeesTableId"
											style="display:none;width: 100% !important; margin-top: 10px !important;">
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
											<tr id="adhocFeesContainerRow"
												class="adhocFeesContainerRow text-center">
												<td class="title"></td>
												<td><input type="text" name="description" onblur="changeAdhocFee(this)"
													class="form-control description" id="description"
													placeholder="Description" /></td>
												<td><select name="taxable" id="taxable"
													class="form-control taxable"
													onchange="changeAdhocFee(this)"
													style="padding: 5px 5px !important; font-size: 13px !important;">
														<option value="No">No</option>
														<option value="Yes">Yes</option>
												</select></td>
												<td><input type="number" name="unitPrice"
													class="form-control unitPrice" id="unitPrice"
													onchange="changeAdhocFee(this)"
													placeholder="Unit Price" />
													<input type="hidden" class="totalTax" /></td>
												<td><input type="number" name="quantity" step="1"
													class="form-control quantity" id="quantity"
													onchange="changeAdhocFee(this)"
													placeholder="Quantity" /></td>
												<td><input type="number" name="amount" disabled
													class="form-control amount" id="amount"
													placeholder="Amount" /></td>
												<td class="action"><label style="display: none;"
													id="deleteStatus" class="deleteStatus"></label> <a
													href="javascript:void(0);"
													style="padding: 1px 1px 0px 1px !important;"
													class="btn closeIcon" onclick="removeAdhocFeeRow(this)">&#10006;</a></td>
											</tr>
											<tr id="adhocTotalContainerRow"
												class="totalContainer text-center">
												<td></td>
												<td></td>
												<td></td>
												<td></td>
												<td><b>Total</b></td>
												<td class="total" style="padding-right: 30px !important;;text-align: right;"></td>
												<td></td>
											</tr>
										</table>
										<div class="text-center" style="display: none">
											<label id="adochTotalId"></label>
										</div>
									</aui:col>
								</aui:row>
								<aui:row>
									<aui:col span="12"
										cssClass="form-field-type-textarea formio-component-columns2TextArea formio-component-textfield">
										<div class="form-group">
											<label cssClass="control-label">&nbsp;&nbsp;Notes</label>
											<textarea class="aui-field-input form-control aui-field-input-text"
												name="description" id="notes" rows="5"
												placeholder="Add your imporatant notes here..." style="height: 80px;"></textarea>
										</div>
									</aui:col>
								</aui:row>
								<aui:row cssClass="userAction">
									<aui:col span="12">
										<button type="button"
											style="width: 176px; padding: 6px 6px !important;"
											class="btn btn-primary" onClick="validateFields()"
											id="collectPaymentId">COLLECT PAYMENT</button>
									</aui:col>
								</aui:row>
							</aui:col>
						</aui:row>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>

<script type="text/javascript">
var namespace =  "<portlet:namespace/>";
var ajaxUrl = "${resourceURL}";
var formStorageId = "<%=formStorageId%>";
var vocabularyURL = "<%=vocabularyURL%>";
var miscFeeList = <%=objectMapper.writeValueAsString(miscFeeList)%>;
var mode = "view";
var baseUrl = "<%=baseUrl%>";
var userId = "<%=userId%>";
var country = "<%=country%>";
var groupId = "<%=groupId%>"
var baseCurrency = "<%=baseCurrency%>";
var categoryMap = <%=objectMapper.writeValueAsString(categoryMap)%>;
var transactionTypeMap = <%=objectMapper.writeValueAsString(transactionTypeMap)%>;
var clientTypeMap = <%=objectMapper.writeValueAsString(clientTypeMap)%>;
var functionalMap = <%=objectMapper.writeValueAsString(functionalComponentMap)%>;
var productMap = <%=objectMapper.writeValueAsString(productMap)%>;
var productSubtypeMap = <%=objectMapper.writeValueAsString(productSubtypeMap)%>;
var downloadPdfUrl="<%=downloadPdfUrl%>";
var categoryType="<%=categoryType%>";
	var categoryMap =
<%=objectMapper.writeValueAsString(categoryMap)%>
	;
	var transactionTypeMap =
<%=objectMapper.writeValueAsString(transactionTypeMap)%>
	;
	var clientTypeMap =
<%=objectMapper.writeValueAsString(clientTypeMap)%>
	;
	var functionalMap =
<%=objectMapper.writeValueAsString(functionalComponentMap)%>
	;
	var functionalDispMap =
<%=objectMapper.writeValueAsString(functionalComponentDisplayMap)%>
	;
	var productMap =
<%=objectMapper.writeValueAsString(productMap)%>;
var productSubtypeMap = <%=objectMapper.writeValueAsString(productSubtypeMap)%>;
var sourceTypeMap = <%=objectMapper.writeValueAsString(sourceTypeMap)%>;
var serverCurrDate ="<%=serverCurrDate%>";
var globalPriceScheme ="<%=globalPriceScheme%>";
</script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/collect-misc-fees.js?<%=System.currentTimeMillis()%>"
	language="javascript1.2"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/main.js?<%=System.currentTimeMillis()%>"
	language="javascript1.2"></script>