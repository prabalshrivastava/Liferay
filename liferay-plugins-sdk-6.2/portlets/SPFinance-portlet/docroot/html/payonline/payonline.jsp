<%@page import="java.util.Map"%>
<%@page
	import="com.sambaash.platform.finance.service.SPFinanceLocalServiceUtil"%>
<%@page import="com.fasterxml.jackson.databind.SerializationFeature"%>
<%@page import="com.fasterxml.jackson.databind.ObjectMapper"%>
<%@page import="com.sambaash.platform.srv.spservices.model.SPParameter"%>
<%@page
	import="com.sambaash.platform.srv.spservices.service.SPParameterLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page
	import="com.sambaash.platform.finance.constants.FinanceConstants"%>
<%@page import="com.liferay.portal.security.auth.AuthTokenUtil"%>
<%@page import="com.sambaash.platform.util.SambaashUtil"%>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>

<%@page import="com.sambaash.platform.constant.SystemSetupConstants"%>
<%@page import="javax.portlet.PortletPreferences"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="javax.portlet.PortletRequest"%>
<%@page import="com.sambaash.platform.util.PermissionUtil"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%><%@
taglib
	uri="http://liferay.com/tld/security" prefix="liferay-security"%><%@
taglib
	uri="http://liferay.com/tld/theme" prefix="liferay-theme"%><%@
taglib
	uri="http://liferay.com/tld/ui" prefix="liferay-ui"%><%@
taglib
	uri="http://liferay.com/tld/util" prefix="liferay-util"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link rel='stylesheet'
	href='/html/css/sp/formio.full.min.css?minifierType=css'>
<link rel='stylesheet' href='/html/css/hook.css?minifierType=css'>
<liferay-theme:defineObjects />
<script src="https://checkout.stripe.com/checkout.js"></script>
<script type="text/javascript"
	src="/html/js/sp/hook.js?<%=System.currentTimeMillis()%>"
	language="javascript1.2"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/billing.js?<%=System.currentTimeMillis()%>"
	language="javascript1.2"></script>
<%@
taglib uri="/tld/sp-formio" prefix="sp-formio"%>
<portlet:defineObjects />
<portlet:resourceURL var="resourceURL">
	<portlet:param name="sp_p_auth"
		value="<%=AuthTokenUtil.getToken(request)%>" />
</portlet:resourceURL>
<%
	if (PermissionUtil.canViewListing((PortletRequest) request.getAttribute("javax.portlet.request"))) {
		String stripeKey = SambaashUtil.getParameter("stripe.public.key", themeDisplay.getScopeGroupId());
		String dashBoardLink = SambaashUtil.getDashBoard();
		ThemeDisplay td = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String userName = td.getUser().getFullName();
		String userEmail = td.getUser().getEmailAddress();
		long userId = td.getUserId();
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		Map<String, String> categoryMap = SPFinanceLocalServiceUtil.getCategoryMap(request);
		SPParameter baseCurrencyParameter = SPParameterLocalServiceUtil
				.findBySPParameterGroupIdAndName(td.getScopeGroupId(), "base_currency");
		String isNotify = portletPreferences.getValue(FinanceConstants.PREF_IS_NOTIFY, "");
		String emailAddresses = portletPreferences.getValue(FinanceConstants.PREF_EMAIL_ADRESSES, "");
		Map<String, String> productSubtypeMap = SPFinanceLocalServiceUtil.getProductSubTypeMap(request);
		Map<String, String> sourceTypeMap = SPFinanceLocalServiceUtil
				.getSpListTypeMap("finance.transaction.sourcetype", request);
%>


<script>
var categoryMap = <%=objectMapper.writeValueAsString(categoryMap)%>;
var sourceTypeMap = <%=objectMapper.writeValueAsString(sourceTypeMap)%>;
var namespace = "<portlet:namespace/>";
var mode = "view";
var ajaxUrl = "${resourceURL}";
if(document.readyState == 'complete') {
	init();
} else {
	window.addEventListener('load', init);
}

var feePayable = 0;
var taxCode = "GST";
var ratePerc = 7;
var gstAmount = 0;
var subTotal = 0;
var availCreditAmount = 0;
var usedCreditAmount = 0;
var totalPayable = 0;
var formStorageId;
var useCreditBalance = true;
var invoices={};
var invoiceList=[];
var tid;
var arrOfId;
var productSubtypeMap = <%=objectMapper.writeValueAsString(productSubtypeMap)%>;
var title="RELC Staging";
function init() {
	showLoading(true);
	tid = getUrlParameter("id");
	arrOfId=tid.split(",");  
	
	feePayable = 0;
	gstAmount = 0;
	creditAmount = 0;
	
	if(tid) {
		searchBy([{"storageId":arrOfId},{"contentJson.TransactionStatus":["Confirmed"]}],[],[],"transactionmaster",false,ajaxUrl,function(list) {
			console.log("list");
			console.log(list);
			if(list && list.content && list.content.length>0 && list.content.length==arrOfId.length) {
				var content = list.content;
				checkReceiptExist(tid, categoryMap["RE"], "transactionmaster", function(exist) {
					if(exist) {
						showLoading(false);
						if(getUrlParameter("r")!=""){
							document.getElementById("refNo").innerHTML = getUrlParameter("r");
							getEID("stripe-success-msg").style.display = "block";
						}else{
							getEID("paid-msg").style.display = "block";
						}
					} else {
							getTaxCodeObject(function(taxObj){
								ratePerc = taxObj.Percentage;
								taxCode = taxObj.TaxCode;
								getWalletAmount("candidate", function(credit){
									for(var contenti=0;contenti<content.length;contenti++) {
										var data = content[contenti];
										var userInv = invoices[data.contentJson.NameOfPayer];
										if(userInv) {
											invoices[data.contentJson.NameOfPayer].push(data);
										} else {
											invoices[data.contentJson.NameOfPayer] = [data];
										}
										
										if(data.contentJson.ProductSubType==productSubtypeMap['SAC']) {
											title="SAC Staging";
										}
										
										for(var i=0;i<data.contentJson.TransactionDetails.length;i++) {
											console.log("feePayable : "+feePayable);
											console.log(" data.contentJson.TransactionDetails[i].amountAtBaseCurrency : "+ data.contentJson.TransactionDetails[i].amountAtBaseCurrency);
											feePayable = feePayable + data.contentJson.TransactionDetails[i].amountAtBaseCurrency;
											gstAmount = gstAmount + data.contentJson.TransactionDetails[i].taxAtBaseCurrency;
										}
									}
									availCreditAmount = credit;
									showLoading(false);
									getEID("paymentDiv").style.display = "block";
									changeAmounts();
								});
							});
					}
				});
			} else {
				showLoading(false);
				getEID("noinvoice-msg").style.display = "block";
				getEID("noinvoice-msg-p").innerHTML = "Invoice(s) are not present or not confirmed yet !!"
			}
		});
	} else {
		showLoading(false);
		getEID("paymentDiv").style.display = "block";
	}
}

function changeAmounts() {
	subTotal = feePayable + gstAmount;
	if(useCreditBalance) {
		if(subTotal>availCreditAmount) {
			usedCreditAmount = availCreditAmount;
		} else {
			usedCreditAmount = subTotal;
		}
	} else {
		usedCreditAmount = 0;
	}
	totalPayable = subTotal - usedCreditAmount;
	document.getElementById("feePayableLabel").innerHTML = round(feePayable,2).toFixed(2);
	if(taxCode) {
		document.getElementById("taxCode").innerHTML = taxCode;
		document.getElementById("taxCodePerc").innerHTML = ratePerc;
	}
	document.getElementById("gstAmountLabel").innerHTML = round(gstAmount,2).toFixed(2);
	document.getElementById("subTotalLabel").innerHTML = round(subTotal,2).toFixed(2);
	document.getElementById("availCreditAmountLabel").innerHTML = round(availCreditAmount,2).toFixed(2);
	document.getElementById("usedCreditAmountLabel").innerHTML = "-"+usedCreditAmount.toFixed(2);
	document.getElementById("totalPayableLabel").innerHTML = round(totalPayable,2).toFixed(2);
	totalPayable = round(totalPayable,2).toFixed(2);
}

function getUrlParameter(name) {
	
    name = name.replace(/[\[]/, '\\[').replace(/[\]]/, '\\]');
    var regex = new RegExp('[\\?&]' + name + '=([^&#]*)');
    var results = regex.exec(location.search);
    return results === null ? '' : decodeURIComponent(results[1].replace(/\+/g, ' '));
}
</script>
<style>
.switch {
	position: relative;
	display: inline-block !important;
	width: 53px;
	height: 27px;
}

.switch input {
	opacity: 0 !important;
	width: 0 !important;
	height: 0;
}

.slider {
	position: absolute;
	cursor: pointer;
	top: 0;
	left: 0;
	right: 0;
	bottom: 0;
	background: #ccc !important;
	-webkit-transition: .4s !important;
	transition: .4s !important;
	width: 53px !important;
	height: 27px !important;
}

.slider:before {
	position: absolute;
	content: "";
	height: 20px;
	width: 20px;
	left: 4px;
	bottom: 4px;
	background-color: white;
	-webkit-transition: .4s;
	transition: .4s;
}

input:checked+.slider {
	background-color: #5be107 !important;
}

input:focus+.slider {
	box-shadow: 0 0 1px #2196F3 !important;
}

input:checked+.slider:before {
	-webkit-transform: translateX(26px) !important;
	-ms-transform: translateX(26px) !important;
	transform: translateX(26px) !important;
}

/* Rounded sliders */
.slider.round {
	border-radius: 34px;
}

.slider.round:before {
	border-radius: 50%;
}

.right-container {
	text-align: right !important;
	padding-right: 25px !important;
}

.formContainer {
	padding-top: 0px !important;
}

.amountHeader {
	width: 125px;
}

.totalLabel {
	font-weight: bold !important;
	background-color: #fff4f4 !important
}

.slider {
	background: none
}

.itemHeader {
	width: 330px;
}

td {
	height: 50px
}

.paymentOnlineDiv .buttonDiv button {
	width: 100% !important
}

#stripe-success-msg {
	display: none;
	text-align: center;
}

.success-msg-1 {
	color: green;
	font-size: 16px;
	padding-top: 18px;
}

.success-msg-2 {
	color: "black";
	font-size: 14px
}

.success-msg-3 {
	color: red;
	font-size: 16px
}

#stripe-error-msg {
	display: none;
	text-align: center;
}

#error-msg {
	font-size: 16px
}
#paid-msg {
	display: none;
}
#paid-msg p {
	font-size: 20px;
	text-align: center;
}
#noinvoice-msg {
	display: none;
}
#noinvoice-msg p {
	font-size: 20px;
	text-align: center;
}
</style>
<div class="newPortlets">
	<div class="subHeader">
		<div class="container">
			<div class="inner-container">
				<aui:row>
					<aui:col span="10" cssClass="text-center">
						<h2><span>MAKE PAYMENT</span></h2>
					</aui:col>
					<aui:col span="2" cssClass="text-right">
						<aui:a href="<%=dashBoardLink%>" title="Back to Home">Back to Home</aui:a>
					</aui:col>
				</aui:row>
			</div>
		</div>
	</div>
	<div class="paymentOnlineDiv">
		<div class="formRoot">
		<div class="innerFormRoot">
		<div class="formContainer container formio-form">
			<div id="paymentDiv" style="display:none">
				<table class="aui">
					<tr>
						<th class="itemHeader">Item</th>
						<th>&nbsp;</th>
						<th class="right-container amountHeader">Amount(SGD)</th>
					</tr>
					<tr>
						<td colspan="2">Fee Payable (GST Excl)</td>
						<td class="right-container" id="feePayableLabel">0.00</td>
					</tr>
					<tr>
						<td colspan="2"><span id="taxCode">GST</span> <span id="taxCodePerc">7</span>%</td>
						<td class="right-container" id="gstAmountLabel">0.00</td>
					</tr>
					<tr>
						<td colspan="2">Sub-Total</td>
						<td class="right-container" id="subTotalLabel">0.00</td>
					</tr>
					<tr>
						<td>Use Credit Balance (Available Amount: $<span
							id="availCreditAmountLabel"></span>)
						</td>
						<td><label class="switch"> <input type="checkbox"
								id="useCreditBalanceCb" checked> <span
								class="slider round"></span>
						</label></td>
						<td class="right-container" id="usedCreditAmountLabel">0.00</td>
					</tr>
					<tr>
						<td colspan="2" class="totalLabel">TOTAL AMOUNT PAYABLE</td>
						<td class="right-container totalLabel" id="totalPayableLabel">0.00</td>
					</tr>
				</table>
				<aui:row cssClass="buttonDiv">
					<aui:col span="3"></aui:col>
					<aui:col span="3">
						<button class="btn btn-primary" id="payNowBtn" >MAKE PAYMENT</button>
					</aui:col>
					<!--<aui:col span="4">
						<button class="btn btn-default">ENROLMENT DETAILS</button>
					</aui:col> -->
					<aui:col span="3">
						<button class="btn btn-default" onclick="goBack();" >CANCEL</button>
					</aui:col>
					<aui:col span="3"></aui:col>
				</aui:row>
			</div>
			<div id="stripe-success-msg">
				<br />
				<br /> <img
					src="../../<%=application.getContextPath() %>/images/success.png"></img>
				<p class="success-msg-1">Thank you, online payment received.
					Please take note of the payment reference code for your record.</p>
				<p class="success-msg-2">
					The payment reference code is <span id="refNo">1234556</span>
				</p>
				<br />
				<p class="success-msg-3">Please check your email for more
					details.</p><br />
				<center>
					<button type="button" onclick="goToHome();" class="btn btn-default">EXIT</button>
				</center>
			</div>
			<div id="stripe-error-msg">
				<br />
				<br /> <img
					src="../../<%=application.getContextPath() %>/images/warning.png"></img>
				<br />
				<br />
				<p class="error-msg">Payment Failed !</p>
			</div>
			<div id="paid-msg">
				<br />
				<br /> <center><img
					src="../../<%=application.getContextPath() %>/images/success.png"></img></center>
				<br />
				<br />
				<center><p class="">Thank you! The payment has been done.</p></center>
				<br />
				<br />
				<center>
					<button type="button" onclick="goToHome();" class="btn btn-default">EXIT</button>
				</center>
			</div>
			<div id="noinvoice-msg">
			<br />
				<br />
				<center> <img
					src="../../<%=application.getContextPath() %>/images/warning.png"></img></center>
				<br />
				<br />
				<center><p id="noinvoice-msg-p"></p></center>
			</div>
		</div>
</div>
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
</div>
<script>

var isNotify = "<%=isNotify%>"; 
var loggedInEmail = "<%=userEmail%>";
var loggedInName = "<%=userName%>";
var loggedInId = "<%=userId%>";
var emailAddresses = "<%=emailAddresses%>";
var userEmail = "<%=userEmail%>";
if(isNotify == ""){
	isNotify = "disabled";
}
var handler = StripeCheckout.configure({
	  key: '<%=stripeKey%>',
  image: '<%=application.getContextPath()%>/images/fee.png',
  locale: 'auto',
  token: function(token) {
	  console.log("token : "+JSON.stringify(token));
    // You can access the token ID with `token.id`.
    // Get the token ID to your server-side code for use.

    	showLoading(true);
    
    	var data = {};
    	data.description = token.created;
    	data.amount = round(totalPayable*100,0);
    	data.currency = "<%=baseCurrencyParameter.getValue()%>";
    	data.stripeEmail = token.email;
    	data.stripeToken = token.id;
    	console.log("data : ");
    	console.log(data);
	  ajaxCallAPI('POST', 'stripecharge', data, function() {
			let data = this.get("responseData");
			if (typeof data === "undefined" || data=="" || data.status != "succeeded") {
				showError();
			} else {
				var totalR = Object.keys(invoices).length;
				Object.keys(invoices).forEach(function(key) {
					var userInvoices = invoices[key];
					saveEmailReceipt(userInvoices,token,totalR);
				});
				
			}
		},function() {
			displayMessage('danger', "Error in calling api.", 3000);
			showLoading(false);
		});
		
  }
});

var successI = 0;
var userReceipts = [];
function saveEmailReceipt(userInvoices,token,totalR) {
	var traDetArr = [];
	for(var i=0;i<userInvoices.length;i++) {
		for(var k=0;k<userInvoices[i].contentJson.TransactionDetails.length;k++) {
			traDetArr.push(userInvoices[i].contentJson.TransactionDetails[k]);
		}
	}
	console.log("traDetArr:::"+JSON.stringify(traDetArr));
	var receipt = getReceiptModel(token,userInvoices,traDetArr);
	receipt.formType = "invoicing";
	console.log(receipt);
	ajaxCallAPI('POST', 'persist', receipt, function() {
		let receiptData = this.get("responseData");
		successI++;
		userReceipts.push(receiptData.contentJson);
		if(successI==totalR) {
			successI = 0;
			showLoading(false);
			console.log("isNotify : "+isNotify);
			if(isNotify == "enabled"){
				sendNotification(userReceipts, token);
			}
			showSuccess(token.id);
			userReceipts = [];
		}
	},function() {
		showLoading(false);
		showError();
		displayMessage('danger',
						"Error in persisting dynamic form data.", 3000);
	});
}

function showError() {
	showLoading(false);
	document.getElementById("paymentDiv").style.display = "none";
	document.getElementById("stripe-error-msg").style.display = "block";
}

function showSuccess(refNum) {
	document.getElementById("paymentDiv").style.display = "none";
	document.getElementById("stripe-success-msg").style.display = "block";
	document.getElementById("refNo").innerHTML = refNum;
}

function sendNotification(receipts, token){
	var data = {};
	data.formStorageId = getUrlParameter("id");
	data.formType = "transactionmaster";
	data.payonline = "payonline";
	data.pdfLocation = "";
	data.organisationIds = "";
	data.storageIds = "";
	data.numbers = "";
	data.tokenId = token.id;
	for(var ri in receipts) {
		console.log(receipts[ri]);
		if(data.organisationId=="") {
			if(receipts[ri].TransactionDetails[0].organisationId) {
				data.organisationIds = receipts[ri].TransactionDetails[0].organisationId;
			}
		} else {
			if(receipts[ri].TransactionDetails[0].organisationId) {
				data.organisationIds = data.organisationId + "," + receipts[ri].TransactionDetails[0].organisationId;
			}
		}
		if(data.storageIds=="") {
			data.storageIds = receipts[ri].TransactionMasterCode;
		} else {
			data.storageIds = data.storageIds + "," + receipts[ri].TransactionMasterCode;
		}
		if(data.numbers=="") {
			data.numbers = receipts[ri].ExtRefNumber;
		} else {
			data.numbers = data.numbers + "," + receipts[ri].ExtRefNumber;
		}
		
	}
	data.emailAddresses = emailAddresses;
	data.loggedInEmail = loggedInEmail;
	data.loggedInName = loggedInName;
	data.loggedInId = loggedInId;
	data.receipts = receipts;
	ajaxCallAPI('POST', 'sendNotification', data, function() {
		var data = this.get("responseData");
		console.log(data);
		if (data == null){
			displayMessage('danger', "Something went wrong", 3000);
		}else if(data.error) {
			displayMessage('danger', data.error, 3000);
		}else {
			console.log("email sent : " + data.toString());			
		}
		showLoading(false);
	}, function() {
		displayMessage('danger', "Error in persisting dynamic form data.", 3000);
		showLoading(false);
	});
}

document.getElementById('payNowBtn').addEventListener('click', function(e) {
	
  // Open Checkout with further options:
	  console.log("totalPayable : "+totalPayable);
  	handler.open({
    	name: title,
    	description: "<%=userName%>",
    	zipCode: false,
    	amount: round(totalPayable*100,0),
    	currency: "<%=baseCurrencyParameter.getValue()%>",
    	email: userEmail
		});
		e.preventDefault();
	});

	// Close Checkout on page navigation:
	window.addEventListener('popstate', function() {
		handler.close();
	});

	function getReceiptModel(token, userInvoices,traDetArr) {
				var receipt = {};
		console.log("invoice : ");
		console.log(userInvoices);
		receipt = Object.assign({}, userInvoices[0].contentJson);
		receipt.TransactionMasterCode = generateTransactionMasterCode()+""+Math.floor(Math.random() * 1000000000000);
		receipt.CategoryType = categoryMap['RE'];
		receipt.TxnType = categoryMap['RE'];
		receipt.ApprovalStatus = "Approved";
		receipt.RequestType = "New Receipt";
		receipt.TransactionStatus = "Confirmed";
		receipt.ComponentRefNumber = "";
		for (var invInd = 0; invInd < userInvoices.length; invInd++) {
			var currInv = userInvoices[invInd].contentJson;
			receipt.ComponentRefNumber = receipt.ComponentRefNumber
					+ currInv.TransactionMasterCode + ",";
		}
		receipt.ComponentRefNumber = receipt.ComponentRefNumber.replace(/,\s*$/, "");
		receipt.CategoryMap = JSON.stringify(categoryMap);
		receipt.SourceTypeMap = JSON.stringify(sourceTypeMap);
		receipt.TransactionDetails = traDetArr;
		console.log(receipt.TransactionDetails);
		var paymentDetailArray = [];
		var paymentDetails = {};
		paymentDetails.paymentAmount = totalPayable;
		//paymentDetails.additionalMetadata = JSON.stringify(userInvoices);
		paymentDetails.paymentModeType = "Stripe";
		paymentDetails.cardExpireDate = "01/"+token.card.exp_month + "/"+ token.card.exp_year;
		paymentDetails.cardLast4Digit = token.card.last4;
		paymentDetails.currency ="<%=baseCurrencyParameter.getValue()%>";
		paymentDetails.description = token.created;
		paymentDetails.payerName ="<%=userName%>";
		paymentDetails.paymentAmount = totalPayable;
		paymentDetails.paymentRefNo = token.id;
		paymentDetails.txnStatus = "Confirmed";
		paymentDetailArray.push(paymentDetails);
		receipt.PaymentDetails = paymentDetailArray;
		return receipt;
	}
	
	function goToHome() {
		window.location.href = "../";
	}
	
	function goBack() {
// 		window.location.href = "../";
		window.history.go(-1);
	}
</script>
<%
	}
%>