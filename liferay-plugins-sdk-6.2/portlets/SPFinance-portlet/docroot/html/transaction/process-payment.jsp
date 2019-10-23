<%@page import="com.sambaash.platform.util.LabelUtil"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page
	import="com.sambaash.platform.finance.constants.FinanceConstants"%>
<%@page import="com.fasterxml.jackson.databind.SerializationFeature"%>
<%@page import="com.fasterxml.jackson.databind.ObjectMapper"%>
<%@page import="java.util.Map"%>
<%@page
	import="com.sambaash.platform.finance.service.SPFinanceLocalServiceUtil"%>
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
	String baseUrl = portletPreferences.getValue("baseUrlPref", "");
	ThemeDisplay td = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
	Long groupId = td.getLayout().getGroupId();
	String globalPriceScheme = SambaashUtil.getParameter("miscellaneous.receipt.price.scheme.code", groupId);
	String dashBoardLink = SambaashUtil.getDashBoard();
	String categoryType = portletPreferences.getValue(FinanceConstants.PREF_CATEGORY_TYPE, "IN");
	Map<String, String> categoryMap = SPFinanceLocalServiceUtil.getCategoryMap(request);
	Map<String, String> transactionTypeMap = SPFinanceLocalServiceUtil.getTransactionTypeMap(request);
	Map<String, String> clientTypeMap = SPFinanceLocalServiceUtil.getClientTypeMap(request);
	Map<String, String> functionalComponentMap = SPFinanceLocalServiceUtil.getFunctionalComponentMap(request);
	Map<String, String> functionalComponentDisplayMap = SPFinanceLocalServiceUtil
			.getFunctionalComponentDisplayMap(request);
	Map<String, String> productMap = SPFinanceLocalServiceUtil.getProductTypeMap(request);
	Map<String, String> productSubtypeMap = SPFinanceLocalServiceUtil.getProductSubTypeMap(request);
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

<style>
.row-hr {
	margin-bottom: 12px !important;
	margin-top: 0px !important;
}

.pending {
	background-color: #ffc48b;
	color: #996029;
}

.confirmed {
	background-color: #8bdb7c;
	color: #327d24;
}

.pending-approval {
	background-color: #ffd724;
	color: #967c0c;
}

.payment-status {
	border-radius: 50px;
	width: 50%;
	display: inline-block;
	text-align: center;
}
.aui .newPortlets table.aui td {
    padding: 10px;
    text-align: left;
    font: 400 14px "Work Sans",sans-serif;
    vertical-align: top;
}
.processPaymentDiv{
    margin: 0px 100px;
}
.miscFees{
	-webkit-appearance: none !important; 
	height: 50px;
}

.Payment-Info {
padding-top:50px;
padding-left:70px;
  width: 131px;
  height: 21px;
  font: 400 18px "Work Sans",sans-serif;
  font-size: 18px;
  font-weight: normal;
  font-style: normal;
  font-stretch: normal;
  line-height: normal;
  letter-spacing: normal;
  color: #152935;
  border : 3px solid rgba(77, 161, 255, 0.2);
  border-radius: 6px;
}

.input-error{
	border:1px solid #c00 !important;
}
</style>
<link rel='stylesheet' type="text/css"
	href='<%=request.getContextPath()%>/css/main.css?minifierType=css'></link>
<link rel='stylesheet' type="text/css"
	href='<%=request.getContextPath()%>/css/payment.css?minifierType=css'></link>
<!-- Scroll Div Start -->
<div class="mainDiv" id="mainDiv">
	<div class="paymentDiv" id="paymentDiv">
		<div class="heading">
			<img class="headingImage" alt=""
				src="<%=request.getContextPath()%>/images/fee.png" />
			<p class="payment-info">PAYMENT INFO</p>
			<!-- <img class="headingCloseImage" alt="" onclick="closePaymentSection()"
				src="<%=request.getContextPath()%>/images/cancel.png" /> -->
		</div>
		<div class="contentScrollDiv">
			<div class="contentDiv">
				<div class="totalDiv">
					<div class="subTotalDiv">
						<label class="leftLabel">Sub Total</label> <label
							class="rightLabel" id="subTotalLabel">0.00</label>
					</div>
					<div id="gstDiv" class="gstDiv" style="display:none;">
						<label class="leftLabel">Miscellaneous Fee
						</label> <label class="rightLabel" id="miscFeesLabel">0.00</label>
					</div>
					<div id="grandTotalDiv" class="grandTotalDiv">
						<label class="leftLabel">Total Payable (<span
							class="baseCurrencyLabel">SGD</span>)
						</label> <label class="rightLabel grandTotal" id="totalPayableAmount">0.00</label>
					</div>
				</div>
				<!-- 
				<div style="display:none;" class="totalDiv paymentTotalDiv">
				
					<div class="subTotalDiv">
						<label class="leftLabel">Total (<span
							class="baseCurrencyLabel">SGD</span>)
						</label> <label class="rightLabel" id="totalPaymentAmount">0.00</label>
					</div>
					<div class="grandTotalDiv">
						<label class="leftLabel">Outstanding (<span
							class="baseCurrencyLabel">SGD</span>)
						</label> <label class="rightLabel" id="totalOutstandingAmount">0.00</label>
					</div>
				</div>
				-->
			</div>
		</div>
		<div class="buttonDiv formContainer">
			<aui:row>
				<aui:col span="6">
					<button type="button" class="btn btn-primary" id="previewBtn"
						onclick="confirmPayment()">CONFIRM PAYMENT</button>
				</aui:col>
				<aui:col span="6">
					<button type="button" class="btn btn-default" id="acceptPaymentBtn"
						onclick="goToList()">CANCEL</button>
				</aui:col>
			</aui:row>
		</div>
	</div>
</div>
<!-- Scroll Div End -->
<div class="newPortlets">
	<div class="subHeader">
		<div class="container">
			<div class="inner-container">
				<aui:row>
					<aui:col span="10" cssClass="text-center">
						<%
							if (categoryType.equals("PA")) {
						%>
						<h2><span><%=LabelUtil.getLabel(pageContext, td, "pa.payment.advice.processpayments")%></span></h2>
						<%
							}
						%>
					</aui:col>
					<aui:col span="2" cssClass="text-right">
						<aui:a href="<%=dashBoardLink%>" title="Back to Home">Back to Home</aui:a>
					</aui:col>
				</aui:row>
			</div>
		</div>
	</div>

	<div class="processPaymentDiv">
		<div class="formRoot">
			<aui:row>
				<aui:col span="12" style="display: contents;">
				</aui:col>
				<aui:col span="12">
					<div>
						<table id="tableId" class="aui">
							<thead>
								<tr class="Heading">
									<th>Ref. No</th>
									<th>ID & Name</th>
									<th>Description</th>
									<th>Value Date</th>
									<th>Credit Date</th>
									<th>Payment Set Code</th>
									<th>Amount Payable (SGD)</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td id="refNo"></td>
									<td id="idAndName"></td>
									<td id="description"></td>
									<td>
										<div class="form-group">
											<aui:input type="text" name=""
												id="valueDate" cssClass="form-control mass-process-valueDate" />
											<span class="input-group-addon" style="cursor: pointer">
												<i class="glyphicon glyphicon-calendar dtPickerIcon"
												style="top: 15px;"></i>
											</span>
											<div class="mass-process-valueDate-error error"></div>
										</div>
									</td>
									<td>
										<div class="form-group">
											<aui:input type="text" name=""
												id="creditDate" cssClass="form-control mass-process-creditDate" />
											<span class="input-group-addon" style="cursor: pointer">
												<i class="glyphicon glyphicon-calendar dtPickerIcon"
												style="top: 15px;"></i>
											</span>
											<div class="mass-process-creditDate-error error"></div>
										</div>
									</td>
									<td>
										<div class="form-group">
											<aui:input type="text" name=""
												id="paymentSetCode" cssClass="form-control mass-process-paymentSetCode" />
											<div class="mass-process-paymentSetCode-error error"></div>
										</div>
									</td>
									<td style="text-align: right;" align="right" id="amountPayable"></td>
								</tr>
							</tbody>
						</table>
					</div>
				</aui:col>

				<aui:col span="12">
					<aui:row>
						<aui:col span="12" cssClass="formio-component-textfield">
							<div class="form-group">
								<label style="margin-left: 15px;">Misc. Fees (Fee Scheme)
								</label>
								<aui:select name="" id="miscFees" type="text"
									cssClass="miscFees form-control"
									onChange="changeMiscFees(this)"
									placeholder="Choose a Miscellaneous fee..." style="-webkit-appearance: none !important; height: 50px;">
									<aui:option value="">
								    	Choose a Miscellaneous fee...
								    </aui:option>
								</aui:select>
							</div>
						</aui:col>
					</aui:row>
				</aui:col>

				<aui:col span="12" style="margin-top:-35px;">
					<div>
						<table id="tableId" class="aui">
							<thead>
								<tr class="Heading">
									<th>Misc. Fee</th>
									<th>Taxable?</th>
									<th>Currency Code</th>
									<th>Unit Price(excl GST)</th>
									<th>Quantity</th>
									<th>Amount (SGD)</th>
									<th></th>
								</tr>
							</thead>
							<tbody id="miscFeesDetails">
							</tbody>
							<tbody>
								<tr>
									<td colspan="5" style="text-align: right; margin-right: 30px;" > Total</td>
									<td style="text-align: right;" id="totalAmount"></td>
									<td></td>
								</tr>
							</tbody>
						</table>
					</div>
				</aui:col>

				<aui:col span="12">
					<aui:row>
						<aui:col span="12" cssClass="formio-component-textfield">
							<div class="form-group">
								<label style="margin-left: 15px;">Notes</label>
								<textarea class="mass-process-notes" placeholder="Add your inportant notes here..." cols=""
									rows="5" id="notes"></textarea>
							</div>
						</aui:col>
					</aui:row>
				</aui:col>

			</aui:row>

			<aui:row cssClass="userAction">
				<aui:col span="4"></aui:col>
				<aui:col span="4">

					<button type="button" style="width: 160px;height: 40px;"
						onclick="doCalculateFee()" class="btn btn-primary">CALCULATE FEE
						</button>
					
				</aui:col>
				<aui:col span="4"></aui:col>
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
<div id="selectReasonDiv" style="display: none;"></div>
	<div class="yui3-skin-sam invoice-action-dialog">
		<div id="action-dialog" hidden="true" class="modalpopupBox">
			<div id="action-dialog-box" class="modalpopupContent">
				<form class="formContainer" action="">
					<aui:row>
						<aui:col span="12">
						
							<h3 id="action_title">Submit for Approval ?</h3>
							<p id="action_msg">Please state any remarks (if any) and confirm your action.</p>
							<br />
							<textarea placeholder="Enter Remarks..." cols="" rows=""
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
							<button type="button" class="btn btn-default" onclick="goBack();"
								style="margin: 0 auto; display: block">Back To List</button>
						</aui:col>
					</aui:row>
				</form>
			</div>
		</div>
	</div>
</div>

<script type="text/javascript">
var namespace =  "<portlet:namespace/>";
var ajaxUrl = "${resourceURL}";
var formStorageId = "<%=formStorageId%>";
var baseUrl = "<%=baseUrl%>";
var mode = "view";
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
var globalPriceScheme ="<%=globalPriceScheme%>";
var closePng = "<%=request.getContextPath()%>/images/close-red.png";
var palabelerrormsgrquired="<%=LabelUtil.getLabel(pageContext, td, "pa.mass.process.payment.errormsg.rquired")%>";
var palabelerrormsgvaluedate="<%=LabelUtil.getLabel(pageContext, td, "pa.mass.process.payment.errormsg.valuedate")%>";

</script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/billing.js?<%=System.currentTimeMillis()%>"
	language="javascript1.2"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/process-payment.js?<%=System.currentTimeMillis()%>"
	language="javascript1.2"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/invoice-actions.js?<%=System.currentTimeMillis()%>"
	language="javascript1.2"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/main.js?<%=System.currentTimeMillis()%>"
	language="javascript1.2"></script>