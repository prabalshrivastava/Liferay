<%@page import="com.sambaash.platform.srv.processbuilder.model.PEProcess"%>
<%@page import="com.sambaash.platform.util.ConvertUtil"%>
<%@page import="com.sambaash.platform.srv.spmicroservice.service.PricingMicroserviceLocalServiceUtil"%>
<%@page import="com.sambaash.platform.srv.processbuilder.model.PEProcessAudit"%>
<%@page import="com.sambaash.platform.pe.payment.PEPaymentV2Helper"%>
<%@page import="com.sambaash.platform.pe.jaxb.PEPaymentV2"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="com.liferay.portal.service.ClassNameLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.json.JSONArray"%>
<%@page import="com.sambaash.platform.pe.course.enroll.CourseEnrollFeeHelper"%>
<%@page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>
<%@page import="com.sambaash.platform.model.payment.PaymentProvider"%>
<%@page import="com.liferay.portal.service.UserLocalServiceUtil"%>
<%@page import="org.apache.commons.lang.StringUtils"%>
<%@page import="com.sambaash.platform.pe.adapter.PEProcessStateDataAdapter"%>
<%@page import="com.sambaash.platform.util.SambaashUtil"%>
<%@page import="com.sambaash.platform.pe.jaxb.PEPayment"%>
<%@page import="com.sambaash.platform.pe.payment.PEPaymentHelper"%>
<%@page import="com.liferay.portal.kernel.json.JSONObject"%>
<%@page import="com.sambaash.platform.pe.PEDataSource"%>
<%@ page import="com.sambaash.platform.srv.processbuilder.model.PEProcessState" %>
<%@page import="com.sambaash.platform.pe.payment.PEPaymentUtil"%>

<%@ include file="/html/init.jsp" %>

<%
PEOutput output =(PEOutput) renderRequest.getAttribute(PEConstants.ATTR_OUTPUT);
PEDataSource dataSource = output.getDataSource();
PEProcessStateDataAdapter dataAdapter = PEProcessStateDataAdapter.getProcessStateDataAdapter(dataSource.getProcessState());
PEPaymentV2 payNode = (PEPaymentV2) dataSource.getDirectory().getNode(output.getNodeId());
PEPaymentV2Helper helper = new PEPaymentV2Helper(dataSource,payNode);
long processStateId = 0;
if (output.getProcessState() != null && output.getProcessState().getUserIdProcess() != 0) {
	processStateId = output.getProcessState().getSpPEProcessStateId();
}

PEProcessAudit completedPaymentAudit = helper.retrievePaymentAudit();
boolean isCompleted = completedPaymentAudit != null;
JSONObject completedPaymentInfo = null;
// information that will be saved along with the payment audit log
JSONObject preparedPaymentAuditInfo = JSONFactoryUtil.createJSONObject();

long pricingNodeId = 0;
JSONArray tranCodesForPayment = null;
JSONArray paidTranCodes = null;
JSONObject payDetails = null;
String payChargeRefId = null;
String payRefundRefId = null;

if (isCompleted) {
	completedPaymentInfo = JSONFactoryUtil.createJSONObject(completedPaymentAudit.getData1());
	pricingNodeId = completedPaymentInfo.getLong("pricingNodeId");
	paidTranCodes = completedPaymentInfo.getJSONArray("paidTranCodes");
	tranCodesForPayment = paidTranCodes;
	payDetails = completedPaymentInfo.getJSONObject("payDetails");
	payChargeRefId = completedPaymentInfo.getString(PaymentProvider.PAY_CHARGE_ID);
	payRefundRefId = completedPaymentInfo.getString(PaymentProvider.PAY_REFUND_ID);
} else {
	pricingNodeId = Long.parseLong(dataAdapter.getDataFromProcessState("_lastPricingNodeSubmitted_"));
	preparedPaymentAuditInfo.put("pricingNodeId", pricingNodeId);
	tranCodesForPayment = JSONFactoryUtil.createJSONArray();
	preparedPaymentAuditInfo.put("paidTranCodes", tranCodesForPayment);
}

// get pricing info
PEProcessAudit pricingAudit = helper.retrievePricingAudit(pricingNodeId);
JSONObject feeInfo = JSONFactoryUtil.createJSONObject(pricingAudit.getData1());
JSONObject invoiceInfo = JSONFactoryUtil.createJSONObject(pricingAudit.getData2());
String tranCodeListStr = "";
if (!isCompleted) {
	// add pricing invoice tran code to list of payment codes
	tranCodesForPayment.put(invoiceInfo.getJSONObject("contentJson").getString("TransactionMasterCode"));
	// add other tran codes saved in pricing node (consolidate/outstanding) for payment
	for (String txnCode : feeInfo.getString("transactionMasterCodes").split(",")) {
		if (StringUtils.isNotEmpty(txnCode)) {
			tranCodesForPayment.put(txnCode); 
		}
	};
	List<String> codesList = ConvertUtil.Json.jsonArrayToStringList(tranCodesForPayment);
	payDetails = PricingMicroserviceLocalServiceUtil.getTransactionFees(themeDisplay.getScopeGroupId(), 
			true, codesList);
	preparedPaymentAuditInfo.put("payDetails", payDetails);
	tranCodeListStr = StringUtils.join(codesList.toArray(),",");
}

String payAmount = BigDecimal.valueOf(payDetails.getDouble("totalFee")).setScale(2).toString();
String payCcy = payDetails.getString("currency");
int payQty = 1;
boolean isPaid = StringUtils.isNotEmpty(payChargeRefId) && !dataSource.isReProcessing();
boolean isGuest = !themeDisplay.isSignedIn();
String payDesc = "Pay "+tranCodeListStr;

String paymentCancel = payNode.getPaymentCancel();
String enableOfflinePayment = payNode.getEnableOfflinePayment();
String payUserEmail = UserLocalServiceUtil.fetchUser(output.getProcessState().getUserIdProcess()).getEmailAddress();
String provider = payNode.getProvider();
String payItemClassName = String.valueOf(dataSource.getProcessState().getEntityClassId());
String payItemClassPk = String.valueOf(dataSource.getProcessState().getEntityId());
String payCartId = tranCodesForPayment.length()>1 ? tranCodeListStr : tranCodesForPayment.getString(0);

boolean isApplicant = (isGuest && payNode.isAllowGuest()) || (output.getProcessState().getUserIdProcess() == themeDisplay.getUserId());
String providerBase = "/html/custom/payment/provider";
String checkoutPage = String.format("%s/%s/checkout.jspf", providerBase, provider);
String refundPage = String.format("%s/%s/refund.jspf", providerBase, provider);
boolean isApprover = dataSource.isSupervisorLoggedInUser();
boolean isRefunded = StringUtils.isNotEmpty(payRefundRefId);
if (!Boolean.valueOf(payNode.getPaymentRefundOn())) {
	isApprover = false; // don't allow refund
}
String refundReason = isRefunded ? PEPaymentHelper.retrieveNodeData(payNode.getNodeId(), dataAdapter, PaymentProvider.PAY_REFUND_REASON_FIELD) : "";
String currentNodeId = String.valueOf(payNode.getNodeId());

boolean isRefundInProgress = "true".equalsIgnoreCase(dataAdapter.getDataFromProcessState(PaymentProvider.PAY_REFUND_IN_PROGRESS));
String refundNodeId = null;
if (isRefundInProgress) {
	JSONObject lastStateJson = JSONFactoryUtil.createJSONObject(dataAdapter.getDataFromProcessState(PaymentProvider.PAY_REFUND_RESUME_STATE));
	refundNodeId = lastStateJson.getString("nodeId");
}

String stripePayCancelUrl = payNode.getDatamap(dataSource, "stripe.pay.cancelUrl");
if ("_REDIRECT_".equals(stripePayCancelUrl)) {
	PEProcess process = dataSource.getProcess();
	stripePayCancelUrl = isApplicant ? process.getUserPageName() : 
		dataSource.isSupervisorLoggedInUser() ? process.getSupervisorPageName() : 
		dataSource.isAgentLoggedInUser() ? process.getAgentPageName() : process.getApproverPageName();
}
%>

<portlet:actionURL name="process" var ="paymentSubmitUrl">
   <portlet:param name="action" value="payment"/>
</portlet:actionURL>

<% if (StringUtils.isNotEmpty(payNode.getTermsAndCondition()) && isApplicant && !isPaid) { %>
	<div class="msg">
	    <%= dataSource.replaceTokensInData(payNode.getTermsAndCondition()) %>
	</div>
<%} %>

<div style="text-align: center;margin: auto;">
<% 
if(Boolean.valueOf(enableOfflinePayment) && !isPaid && isApplicant) {
%>
	<h3>Payment Mode</h3>
	<div class="payment-mode-selection">
		<input type="radio" name="paymentMode" class="online-payment" value="online" onclick="peTogglePaymentMode()" checked>Online
		<input type="radio" name="paymentMode" class="offline-payment" value="offline" onclick="peTogglePaymentMode()">Offline
	</div>

	<div class="pe-offline-payment" style="display: none;">
		<%@ include file="/html/custom/payment/offlinePayment.jspf"  %>
		<%if(Boolean.valueOf(paymentCancel)) {%>
			<%@ include file="/html/custom/payment/cancelPayment.jspf"  %>
		<%} %>
	</div>
	<div class="pe-online-payment">
<%
}
%>
<div style="display: inline-flex;">
	<aui:form action="<%= paymentSubmitUrl %>" name="form">
		<aui:input name="formData"  type="hidden"></aui:input>
		<aui:input name="processStateId"  type="hidden" value="<%= processStateId %>"></aui:input>
		<aui:input name="nodeId"  type="hidden" value="<%= output.getNodeId() %>"></aui:input>
		<aui:input name="classPK"  type="hidden" value="<%= output.getClassPk() %>"></aui:input>
		<aui:input name="classNameId"  type="hidden" value="<%= output.getClassNameId() %>"></aui:input>
		<aui:input name="processId"  type="hidden" value="<%= output.getProcessId() %>"></aui:input>
		<aui:input name="actionType"  type="hidden" value="submit"></aui:input>

		<input type="hidden" value="<%=payAmount%>" name="pay_amount" />
		<input type="hidden" value="<%=payCcy%>" name="pay_currency" />
		<input type="hidden" value="<%=payDesc%>" name="pay_description" />
		<input type="hidden" value="<%=paymentCancel%>" name="payment_cancel" />
		
		<input type="hidden" value="<%=payItemClassName%>" name="pay_item_className" />
		<input type="hidden" value="<%=payItemClassPk%>" name="pay_item_classPk" />
		<input type="hidden" value="<%=payCartId%>" name="<%=PaymentProvider.CART_ID%>" />
		
		<input type="hidden" value="<%=provider%>" name="pay_provider" />
		<input type="hidden" value="<%=tranCodeListStr%>" name="paid_txn_codes" />
		<% 
		if (isApplicant && !isPaid) {
		%>
			<%@ include file="/html/custom/payment/router/checkoutRouter.jspf"  %>
		<%
		} else if (isPaid) {
			if (isApprover && !isRefunded && !(isRefundInProgress && !currentNodeId.equals(refundNodeId))) {
		%> 
			<%@ include file="/html/custom/payment/router/refundRouter.jspf"  %>							
			
			<script>
			AUI().use('aui-node',function(A) {
				var waitMsgCont = A.one('#waitMsgContainer');
				if (waitMsgCont) waitMsgCont.remove();
	         });
			var htitle = document.getElementById('headingTitle').innerHTML;
			document.getElementById('headingTitle').innerHTML = htitle + ' Refund';			
			</script>
		<% 
			} else if (isRefunded) {
		%>
			<script>
			AUI().use('aui-node',function(A) {
				var waitMsgCont = A.one('#waitMsgContainer');
				if (waitMsgCont) waitMsgCont.remove();
	         });
			</script>
				<div class="msg">
                     <%=dataSource.replaceTokensInData(payNode.getRefundedMsg())%>
                </div>								
		      <div>
		      	  <span class="msg">Reason </span>
		          <textarea rows="10" cols="100" name="<%=PaymentProvider.PAY_REFUND_REASON_FIELD %>" readonly="true"><%=refundReason%></textarea>
		      </div>
		      <div>
		      </div>
		<%		
			} else {
		%>
				<div class="msg">
                     <%=dataSource.replaceTokensInData(payNode.getPaidMsg())%>
                </div>										
		<%
			}
		}
		%>
		
		
	</aui:form>
	<% 
		if (isApplicant && !isPaid) {
		%>
			
			
			<%if(StringUtils.isNotEmpty(stripePayCancelUrl)) { %>
				<button class="stripe-button-el" onclick="window.location.href='<%=stripePayCancelUrl%>'">
				<span style="display: block; min-height: 30px;" >Cancel Payment</span>
				</button>
			<%} else if(Boolean.valueOf(paymentCancel)) {%>
				<%@ include file="/html/custom/payment/cancelPayment.jspf"  %>
			<%} %>
			
		<%}%>
	
</div>
</div>

<% 
if(Boolean.valueOf(enableOfflinePayment) && !isPaid && isApplicant) {
%>
</div>
<script type="text/javascript">
function peTogglePaymentMode() {
  var payMode = document.querySelector("input[name='paymentMode']:checked").value;
  if ("offline" === payMode) {
    document.querySelector(".pe-offline-payment").style.display="inline-flex";
    document.querySelector(".pe-online-payment").style.display="none";
  } else {
  	document.querySelector(".pe-offline-payment").style.display="none";
    document.querySelector(".pe-online-payment").style.display="inline-flex";
  }
}
</script>
<%
}
%>

  
      