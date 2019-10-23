<%@page import="com.sambaash.platform.model.payment.PaymentProvider"%>
<%@page import="com.sambaash.platform.pe.payment.PEPaymentHelper"%>
<%@page import="com.sambaash.platform.pe.actions.PEPaymentConfirmationInitialization"%>
<%@page import="com.sambaash.platform.pe.PEDataSource"%>
<%@page import="com.sambaash.platform.pe.adapter.PEProcessStateDataAdapter"%>
<%@page import="com.liferay.portal.kernel.util.DateUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.sambaash.platform.srv.model.Course"%>
<%@page import="com.sambaash.platform.srv.service.CourseLocalServiceUtil"%>
<%@ page import="com.sambaash.platform.srv.model.Product" %>
<%@ page import="com.sambaash.platform.srv.processbuilder.model.PEProcessState" %>
<%@ page import="com.sambaash.platform.srv.service.ProductLocalServiceUtil" %>

<%@ include file="/html/init.jsp" %>

<%
PEOutput output =(PEOutput) request.getAttribute(PEConstants.ATTR_OUTPUT);
PEProcessState processState = output.getProcessState();
PEDataSource dataSource = output.getDataSource();
PEProcessStateDataAdapter dataAdapter = PEProcessStateDataAdapter.getProcessStateDataAdapter(dataSource.getProcessState());

String modeOfPayment = dataAdapter.getDataFromProcessState("modeOfPayment");
String payModeDisplayText = dataAdapter.getDataFromProcessState("payModeDisplayText");

long processStateId = 0;
if (output.getProcessState() != null && output.getProcessState().getUserIdProcess() != 0) {
	processStateId = output.getProcessState().getSpPEProcessStateId();
}


String actionType = "submit";
if (processState.getNodeId() != output.getNodeId()) {
	// not current node, meaning this is a previous step
	actionType = "save";
}

int payQty = 1;
try {
	long payNodeId = Long.parseLong(dataAdapter.getDataFromProcessState(PEPaymentConfirmationInitialization.CONFIRM_PAYMENT_NODE_ID));
	String payQtyStr = PEPaymentHelper.retrieveNodeData(payNodeId, dataAdapter, PaymentProvider.PAY_QUANTITY_FIELD);
	payQty = Integer.parseInt(payQtyStr);
} catch (Exception e) {
	_log.error(e.getMessage());
}

%>
<style>
	.paymentMode {
	    display: inline-block !important;
	    width: 100% !important;
	}
	form.centered {
		width: 250px;
   		margin: 0 auto;
	}
	fieldset.centered {
	    width: 60% !important;
	    margin: auto !important;
	    border: 0 !important;
	}
	.centered {
   		margin: 0 auto;
   		text-align: center;
	}
	.button-holder.centered {
    	display: table;
    	    margin-bottom: 10px;
	}
</style>

<portlet:actionURL name="process" var ="paymodeSubmitUrl">
   <portlet:param name="action" value="paymentMode"/>
</portlet:actionURL>

<jsp:include page="/html/formData.jsp"></jsp:include>

<aui:form action="<%= paymodeSubmitUrl %>" id="paymentModeForm" name="paymentModeForm" cssClass="centered">
		<aui:input name="formData"  type="hidden"></aui:input>
		<aui:input name="processStateId"  type="hidden" value="<%= processStateId %>"></aui:input>
		<aui:input name="nodeId"  type="hidden" value="<%= output.getNodeId() %>"></aui:input>
		<aui:input name="classPK"  type="hidden" value="<%= output.getClassPk() %>"></aui:input>
		<aui:input name="classNameId"  type="hidden" value="<%= output.getClassNameId() %>"></aui:input>
		<aui:input name="processId"  type="hidden" value="<%= output.getProcessId() %>"></aui:input>
		<aui:input name="actionType"  type="hidden" value="submit"></aui:input>

	<div class="paymentModeDiv">
		<%
		if (Validator.isNotNull(payModeDisplayText)) {
		%>
	    	<p> <%= payModeDisplayText %></p>			
		<%}%>
	    <label for="mode_of_payment" id="lblRadiomode_of_payment" >Select a Mode of Payment</label>
	    <fieldset class="paymentMode centered" id="mode_of_payment">
	        <div class="paymentMode">
	        <input type="radio" id="mode_of_payment_0" value="Online" name="mode_of_payment" <%="Online".equals(modeOfPayment) ? "checked" : "" %> >
	        <label for="mode_of_payment_0">Online</label>
	        </div>
	        <div class="paymentMode">
	        <input type="radio" id="mode_of_payment_1" value="Offline" name="mode_of_payment" <%="Offline".equals(modeOfPayment) ? "checked" : "" %> >
	        <label for="mode_of_payment_1">Offline</label>
	        </div>
	    </fieldset>
		<div class="centered">
			<input type="button" id="submitBtn" value="Submit" class="btn-default btn choose-btn" onclick="return submitPaymentMode();"> 
		</div>
		
	</div>
	
</aui:form>

<script src="/SPProcessEngine-portlet/js/custom/enrollmentcourse/productsWithInventory.js?t=<%=DateUtil.newTime() %>">
</script>

<script>
var ns = '<portlet:namespace />';
var steps = <%= output.getStatusTypes().toString() %>;
var submitPaymentMode = function (){
	document.getElementById("submitBtn").disabled = true;
	var entityClassId = <%= processState.getEntityClassId()%>;
	var entityId = <%= processState.getEntityId()%>;
	var payQty = <%= payQty%>; 
	ProductsWithInventoryUtil.validateInventory(entityClassId, entityId, payQty, function(data){
		if (data == false) {
			var isGroup = payQty > 1;
			var errMsg = "No Seat Available";
			if (isGroup) {
				var step1Link = steps[0].url;
				errMsg = '<p>There is insufficient seat. Please click on <a href="'+step1Link+'">Step 1</a> to revise the number of participants and try again</p>';
			};
			ProductsWithInventoryUtil.displayMessage(errMsg);
			document.getElementById("submitBtn").removeAttribute("disabled");
		} else {
			document.getElementById(ns+"paymentModeForm").submit();
		}
		return false;
	});
};

AUI().ready(function(A) {
	var disabled = <%= !output.isCanEdit() && !output.isCanSubmit() %>;
	ProductsWithInventoryUtil.disableScreen(disabled);
});
</script>

<%!
private static Log _log = LogFactoryUtil.getLog("html.custom.enrollmentcourse.inventoryPaymentMode_jsp");
%> 
