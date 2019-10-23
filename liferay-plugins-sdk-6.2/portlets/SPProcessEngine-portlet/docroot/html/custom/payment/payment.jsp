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
PEPayment payNode = (PEPayment) dataSource.getDirectory().getNode(output.getNodeId());
PEPaymentHelper helper = new PEPaymentHelper(dataSource,payNode);
long processStateId = 0;
if (output.getProcessState() != null && output.getProcessState().getUserIdProcess() != 0) {
	processStateId = output.getProcessState().getSpPEProcessStateId();
}

boolean isCompleted = helper.isCompleted();
String payAmount = dataAdapter.getDataFromProcessState(payNode.getPayAmount());
String payCcy = dataAdapter.getDataFromProcessState(payNode.getPayCcy());
String payQtyStr = PEPaymentHelper.retrieveNodeData(payNode.getNodeId(), dataAdapter, PaymentProvider.PAY_QUANTITY_FIELD);
int payQty = 1;
String payChargeRefId = PEPaymentHelper.retrieveNodeData(payNode.getNodeId(), dataAdapter, PaymentProvider.PAY_CHARGE_ID);
boolean isPaid = StringUtils.isNotEmpty(payChargeRefId);
try {
	payQty = Integer.parseInt(payQtyStr);
	if (payQty>1 && isPaid) {	// group registration && already paid
		payQty = 1;				// set to 1, so the amount will not change
	}
} catch (Exception e) {
	// leave as 1
}

if (StringUtils.isEmpty(payAmount)) {
	JSONArray feeDtlArray = CourseEnrollFeeHelper.getCourseFeeDetails(dataSource);
	payAmount = "0";
	JSONObject otherInfo = CourseEnrollFeeHelper.getOtherCourseFeeInfo(dataSource);
	payCcy = otherInfo.getString("ccy");
	dataAdapter.store("ccy", payCcy);
	dataAdapter.store("courseId", otherInfo.getString("courseId"));
	for (int i=0; i < feeDtlArray.length(); i++) {
		JSONObject feeDtl = feeDtlArray.getJSONObject(i);
		if (feeDtl.getString("feeType").equals(payNode.getPayAmount())) {
			payAmount = feeDtl.getString("feeAmount");
			dataAdapter.store(payNode.getPayAmount(), payAmount);
			break;
		}
	}
}
BigDecimal amt = new BigDecimal(payAmount);
BigDecimal qty = new BigDecimal(payQty);
payAmount = amt.multiply(qty).toString();
if (StringUtils.isEmpty(PEPaymentHelper.retrieveNodeData(payNode.getNodeId(), dataAdapter, PaymentProvider.PAY_AMOUNT_FIELD))  || !isPaid) {
	PEPaymentHelper.storeNodeData(payNode.getNodeId(), dataAdapter, PaymentProvider.PAY_AMOUNT_FIELD, payAmount);
	PEPaymentHelper.storeNodeData(payNode.getNodeId(), dataAdapter, "pay_quantity_computed", "true");
	com.sambaash.platform.srv.processbuilder.service.PEProcessStateLocalServiceUtil.updatePEProcessState(dataSource.getProcessState());	
}

boolean isGuest = !themeDisplay.isSignedIn();
String payDesc = dataAdapter.getDataFromProcessState(payNode.getPayDesc());

String paymentCancel = payNode.getPaymentCancel();
//String payUserEmail = UserLocalServiceUtil.fetchUser(output.getProcessState().getUserIdProcess()).getEmailAddress();
String payUserEmail = isGuest && payNode.isAllowGuest() ? dataAdapter.getDataFromProcessState("emailAddress") 
		: UserLocalServiceUtil.fetchUser(output.getProcessState().getUserIdProcess()).getEmailAddress();
String provider = payNode.getProvider();
String payRefundRefId = PEPaymentHelper.retrieveNodeData(payNode.getNodeId(), dataAdapter, PaymentProvider.PAY_REFUND_ID);
String payItemClassName = ClassNameLocalServiceUtil.getClassName(dataSource.getProcessState().getEntityClassId()).getClassName();
String payItemClassPk = String.valueOf(dataSource.getProcessState().getEntityId());
String payCartId = PEPaymentHelper.retrieveNodeData(payNode.getNodeId(), dataAdapter, PaymentProvider.CART_ID);

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
%>

<portlet:actionURL name="process" var ="paymentSubmitUrl">
   <portlet:param name="action" value="payment"/>
</portlet:actionURL>

<div style="text-align: center;margin: auto;">
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
			
			
			<%if(Boolean.valueOf(paymentCancel)){ %>
			<aui:form action="<%= paymentSubmitUrl %>" name="formPayCancel">
				<aui:input name="formData"  type="hidden"></aui:input>
				<aui:input name="processStateId"  type="hidden" value="<%= processStateId %>"></aui:input>
				<aui:input name="nodeId"  type="hidden" value="<%= output.getNodeId() %>"></aui:input>
				<aui:input name="classPK"  type="hidden" value="<%= output.getClassPk() %>"></aui:input>
				<aui:input name="classNameId"  type="hidden" value="<%= output.getClassNameId() %>"></aui:input>
				<aui:input name="processId"  type="hidden" value="<%= output.getProcessId() %>"></aui:input>
				<aui:input name="actionType"  type="hidden" value="submit"></aui:input>
				<aui:input name="paymentAction" type="hidden" value="paymentCancel" ></aui:input>
		
				<input type="hidden" value="<%=payAmount%>" name="pay_amount" />
				<input type="hidden" value="<%=payCcy%>" name="pay_currency" />
				<input type="hidden" value="<%=payDesc%>" name="pay_description" />
				<input type="hidden" value="<%=paymentCancel%>" name="payment_cancel" />
				
				<input type="hidden" value="<%=payItemClassName%>" name="pay_item_className" />
				<input type="hidden" value="<%=payItemClassPk%>" name="pay_item_classPk" />
				<input type="hidden" value="<%=payCartId%>" name="<%=PaymentProvider.CART_ID%>" />
		
				<input type="hidden" value="<%=provider%>" name="pay_provider" />
				&nbsp;&nbsp;<button type="submit" class="stripe-button-el">
				<span style="display: block; min-height: 30px;">Cancel Payment</span>
				</button>
				
			</aui:form>
			<%} %>
			
		<%}%>
	
</div>
</div>
     

  
      