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
<jsp:include page="refund-section.jsp" />
<portlet:defineObjects />
<%
	String formStorageId = request.getParameter("storageId");
	String fromAmendments =  request.getParameter("fromAmendments");
	String baseUrl = portletPreferences.getValue("baseUrlPref", "");
	ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
	Long groupId = themeDisplay.getLayout().getGroupId();
	String dashBoardLink = SambaashUtil.getDashBoard();
	String globalPriceScheme = SambaashUtil.getParameter("miscellaneous.receipt.price.scheme.code", groupId);
	String globalBaseCurrency = SambaashUtil.getParameter("base_currency", groupId);
	List<SPListType> miscFeeList = SPListTypeLocalServiceUtil
			.getByKey("priceengine.pricesubscheme.miscfees.pricesubtype", groupId);
	//List<SPListType> paymentModeList = SPListTypeLocalServiceUtil.getByKey("finance.payment.mode", groupId);
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

.checkbox-custom-label {
	padding-left: 30px !important;
}

.checkbox-custom {
	padding-right: 10px !important;
    margin-top: 1px !important;
    opacity : 1 !important;
    display: block !important;
}

.text-centre{
	text-align: center !important;
}
</style>
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
			<aui:row>
				<aui:col span="10" cssClass="text-center">
				<h2><%=LabelUtil.getLabel(pageContext, themeDisplay, "cb.refund.label")%></h2>
					
				</aui:col>
				<aui:col span="2" cssClass="text-right">
					<aui:a href="<%=dashBoardLink%>" title="Back to Dashboard">Back to Dashboard</aui:a>
				</aui:col>
			</aui:row>
		</div>
	</div>

	<div class="">
		<div class="formContainer container formio-form" style="padding: 0px 70px !important;">
			<form class="aui" id="paymentAdviceForm" name="paymentAdviceForm" action="">
				<aui:col span="10" cssClass="offset1">
					<aui:row>
						<aui:col span="10" cssClass="offset1">
								<div style="display: none;" class="alert alert-danger"
							role="showAlert" id="alert_msg">Select Facility Type.</div>
								<aui:input name="" type="hidden" id="CreditBalanceCode" />
								<aui:input name="" type="hidden" id="UserType" />
								<aui:input name="" type="hidden" id="UserId" />
						</aui:col>
					</aui:row>
				
					<aui:row>
						<aui:col span="12" cssClass="">
							<table id="processRefundTableId" style="width:100%!important;margin-top:10px!important; border: 1px solid #dfdfdf!important; box-shadow: 0 0 0px 0 #e1e6eb !important;">
								<thead>
									<tr>
										<th><%=LabelUtil.getLabel(pageContext, themeDisplay, "cb.detail.userid")%></th>
										<th><%=LabelUtil.getLabel(pageContext, themeDisplay, "cb.detail.username")%></th>
										<th><%=LabelUtil.getLabel(pageContext, themeDisplay, "cb.detail.credibalance")%></th>
										<th><%=LabelUtil.getLabel(pageContext, themeDisplay, "cb.detail.paymentmode")%></th>
										<th><%=LabelUtil.getLabel(pageContext, themeDisplay, "cb.detail.amountprocessed")%></th>
									</tr>
								</thead>
								<tr id="processRefundContainerRow" class="processRefundContainerRow">
									<td id="userId" class="userId"></td>
									<td id="userName" class="userName"></td>
									<td id="creditBalanceAmt" class="creditBalanceAmt"></td>
									<td>
										<aui:select name="" id="paymentMode"
											class="form-control" >
											<%
												List<SPListType> catList = 
													SPListTypeLocalServiceUtil.getByKey("finance.transaction.paymentmode", groupId);
												for(SPListType type : catList) {
													%><aui:option value="<%=type.getItemValue() %>"><%=type.getDisplayName() %></aui:option>
											<%
												}
											%>
										</aui:select>
									</td>
									<td><aui:input type="number" name=""
										class="form-control quantity" id="amountProcessed"
										placeholder="Amount to be processed" oninput="validateAmountProcessed('amountProcessed', 'creditBalanceAmt')"/></td>
								</tr>
							</table>
						</aui:col>
					</aui:row>
					<div id="miscRefundDivId">
						<aui:row>
							<aui:col span="12">
								<table id="miscRefundTableId" style="width:100%!important;margin-top:10px!important; border: 1px solid #dfdfdf!important; box-shadow: 0 0 0px 0 #e1e6eb !important;">
									<thead>
										<tr>
											<th><%=LabelUtil.getLabel(pageContext, themeDisplay, "cb.refund.misc")%></th>
											<th><%=LabelUtil.getLabel(pageContext, themeDisplay, "cb.refund.taxable")%></th>
											<th><%=LabelUtil.getLabel(pageContext, themeDisplay, "cb.refund.currency")%></th>
											<th><%=LabelUtil.getLabel(pageContext, themeDisplay, "cb.refund.amount")%></th>
											<th><%=LabelUtil.getLabel(pageContext, themeDisplay, "cb.refund.waive")%></th>
											<th><%=LabelUtil.getLabel(pageContext, themeDisplay, "cb.refund.waive.reason")%></th>
								</thead>
									<tr id="miscRefundContainerRow" class="miscRefundContainerRow">
										<td id="title" class="title"></td>
										<td id="taxable" class="taxable"></td>
										<td id="currency" class="currency"></td>
										<td id="amount" class="amount-class"></td>
										<td>
											<label class="checkbox-custom-label"> <input type="checkbox" 
											class="form-control checkbox-custom" id="waive"></label></td>
										<td><aui:input type="text" name=""
											class="form-control quantity" id="waive-reason"
											placeholder="Key in your reason" /></td>
									</tr>
									<tr id="miscRefundTotalContainerRow" class="totalContainer">
										<td></td>
										<td></td>
										<td><label>Total</label></td>
										<td class="amountTotal"></td>
										<td></td>
										<td></td>
									</tr>
								</table>
							</aui:col>
						</aui:row>
					</div>
					
					<aui:row>
						<aui:col span="12" cssClass="formio-component-textfield">
							<div class="form-group">
								<label cssClass="control-label">Misc. Fees(Fee Scheme)<span
									class="red-star">*</span></label>
								<aui:select name="" id="feeSchemeId" cssClass="form-control"
								OnChange="feeSchemeDDChange(this)">
									<aui:option value="" hidden="true">
										Choose a Miscellaneous Fee...
									</aui:option>
								</aui:select>
							</div>
						</aui:col>
					</aui:row>
					<aui:row>
						<aui:col span="12" cssClass="">
							<table id="feeSchemeTableId"  style="width:100%!important;margin-top:10px!important; border: 1px solid #dfdfdf!important; box-shadow: 0 0 0px 0 #e1e6eb !important;">
								<thead>
									<tr>
										<th width="30%">Misc Fees</th>
										<th width="10%">Taxable</th>
										<th width="10%">Currency</th>
										<th width="18%">Unit Price (Excl GST)</th>
										<th width="10%">Quantity</th>
										<th width="20%">Fee($)</th>
										<th width="2%"></th>
									</tr>
								</thead>
								<tr id="feeSchemeContainerRow" class="feeSchemeContainerRow text-center">
									<td class="title"></td>
									<td></td>
									<td></td>
									<td class="unit-price"></td>
									<td><input type="number" name="quantity"
										class="form-control quantity" id="quantity"
										onChange="changePriceQnty(this)" placeholder="Quantity" /></td>
									<td>
										<input type="number" name="amount" disabled
										class="form-control amount" id="amount" placeholder="Amount" />
									</td>
									<td class="action"><input type="text" style="display: none;"
										id="deleteStatus" value="" class="deleteStatus">
										<a href="javascript:void(0);" style="padding: 1px 1px 0px 1px !important;"
											class="btn closeIcon" onclick="removeFeeSchemeRow(this)">&#10006;</a>
									</td>
								</tr>
								<tr id="feeSchemeTotalContainerRow" class="totalContainer text-center">
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td><b>Total</b></td>
									<td class="total" style="padding-right: 28px !important;"></td>
									<td></td>
								</tr>
							</table>
						</aui:col>
					</aui:row>
					<aui:row>
						<aui:col span="12" cssClass="formio-component-textfield">
							<div class="form-group">
								<label class="control-label"><%=LabelUtil.getLabel(pageContext, themeDisplay, "cb.detail.notes")%> </label>
								<aui:input type="textarea" name="" rows="5" cssClass="form-control mass-process-notes" id="notes" style="height:100px" placeholder=" Enter important notes" />
							</div>
						</aui:col>
					</aui:row>
					
					<aui:row cssClass="userAction">
						<aui:col span="6">
								<button type="button" id="mass-process-popup-submit-action" onclick="calculateAmount()" 
									class="btn-primary btn" style="float:right;width:230px;">CALCULATE AMOUNT</button>
						</aui:col>
						<aui:col span="6" >
							<button type="button" id="mass-process-popup-cancel-action" onclick="goBack();"
								class="btn-default btn mass-process-popup-cancel-action pull-right" style="float:left;">Cancel</button>
						</aui:col>
					</aui:row>
				</aui:col>
			</form>
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
		<div id="claim-action-dialog-bound" hidden="true" class="modalpopupBox">
			<div id="claim-action-dialog-content" class="modalpopupContent">
				<form class="formContainer" action="">
					<aui:row>
						<aui:col span="12">
							<h3 id="action_title">Add Remarks</h3>
							<p id="action_msg">Please key in your remarks justifying your comment action</p>
							<br/>
							<textarea placeholder="Add your text here..." cols="" rows="" id="claim_action_reason"></textarea>
						</aui:col>
					</aui:row>
					<aui:row>
						<aui:col span="12">
							<button type="button" id="popup-submit-action"
								class="btn-primary claim-action-dialog-submit popup-submit-action pull-left"
								style="padding: 8px 12px !important">Submit</button>
							<button type="button" id="popup-cancel-action"
								class="btn-default claim-action-dialog-cancel popup-cancel-action pull-right">Cancel</button>
						</aui:col>
					</aui:row>
				</form>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/main.js?<%=System.currentTimeMillis()%>" language="javascript1.2"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/credit-balance.js?<%=System.currentTimeMillis()%>" language="javascript1.2"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/process-refund.js?<%=System.currentTimeMillis()%>" language="javascript1.2"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/billing.js?<%=System.currentTimeMillis()%>" language="javascript1.2"></script>


<script type="text/javascript">
var serverCurrDate ="<%=serverCurrDate%>";
var namespace =  "<portlet:namespace/>";
var ajaxUrl = "${resourceURL}";
var formStorageId = "<%=formStorageId%>";
var fromAmendments = "<%=fromAmendments%>"
var baseUrl = "<%=baseUrl%>";
var mode = "refund";
var downloadPdfUrl="<%=downloadPdfUrl%>";
var serverCurrDate ="<%=serverCurrDate%>";
var globalBaseCurrency ="<%=globalBaseCurrency%>";
var globalPriceScheme ="<%=globalPriceScheme%>";
var miscFeeList = <%=objectMapper.writeValueAsString(miscFeeList)%>;


var categoryMap = <%=objectMapper.writeValueAsString(categoryMap)%>;
var transactionTypeMap = <%=objectMapper.writeValueAsString(transactionTypeMap)%>;
var clientTypeMap = <%=objectMapper.writeValueAsString(clientTypeMap)%>;
var functionalMap = <%=objectMapper.writeValueAsString(functionalComponentMap)%>;
var productMap = <%=objectMapper.writeValueAsString(productMap)%>;
var productSubtypeMap = <%=objectMapper.writeValueAsString(productSubtypeMap)%>;
</script>