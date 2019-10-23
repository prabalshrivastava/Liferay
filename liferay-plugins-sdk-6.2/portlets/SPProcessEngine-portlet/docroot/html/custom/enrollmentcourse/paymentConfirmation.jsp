<%@page import="com.liferay.portal.kernel.util.DateUtil"%>
<%@page import="com.sambaash.platform.pe.payment.PEPaymentHelper"%>
<%@page import="com.sambaash.platform.pe.actions.PEPaymentConfirmationInitialization"%>
<%@page import="com.sambaash.platform.model.payment.PaymentProvider"%>
<%@page import="com.sambaash.platform.pe.adapter.PEProcessStateDataAdapter"%>
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
PEProcessStateDataAdapter dataAdapter = PEProcessStateDataAdapter.getProcessStateDataAdapter(output.getDataSource().getProcessState());

long processStateId = 0;
if (output.getProcessState() != null && output.getProcessState().getUserIdProcess() != 0) {
	processStateId = output.getProcessState().getSpPEProcessStateId();
}
String paymentConfirmationStatus = dataAdapter.getDataFromProcessState("paymentConfirmationStatus");
String paymentConfirmationRemarks = dataAdapter.getDataFromProcessState("paymentConfirmationRemarks");
int payQty = 1;
try {
	long payNodeId = Long.parseLong(dataAdapter.getDataFromProcessState(PEPaymentConfirmationInitialization.CONFIRM_PAYMENT_NODE_ID));
	String payQtyStr = PEPaymentHelper.retrieveNodeData(payNodeId, dataAdapter, PaymentProvider.PAY_QUANTITY_FIELD);
	payQty = Integer.parseInt(payQtyStr);
} catch (Exception e) {
	// leave as 1
	_log.error(e.getMessage());
}
%>

<portlet:actionURL name="process" var ="payConfirmSubmitUrl">
   <portlet:param name="action" value="paymentConfirmation"/>
</portlet:actionURL>

<jsp:include page="/html/formData.jsp"></jsp:include>

<aui:form action="<%= payConfirmSubmitUrl %>" id="payConfirmForm" name="payConfirmForm">
		<aui:input name="formData"  type="hidden"></aui:input>
		<aui:input name="processStateId"  type="hidden" value="<%= processStateId %>"></aui:input>
		<aui:input name="nodeId"  type="hidden" value="<%= output.getNodeId() %>"></aui:input>
		<aui:input name="classPK"  type="hidden" value="<%= output.getClassPk() %>"></aui:input>
		<aui:input name="classNameId"  type="hidden" value="<%= output.getClassNameId() %>"></aui:input>
		<aui:input name="processId"  type="hidden" value="<%= output.getProcessId() %>"></aui:input>
		<aui:input name="actionType"  type="hidden" value="submit"></aui:input>
		
		<aui:input name="confirmStatus" id="confirmStatus"  type="hidden" value="" ></aui:input>
		<aui:input name="validateInventory" id="validateInventory"  type="hidden" value="true" ></aui:input>

	<div id="confirmation_container" >
		<div>
			<aui:input name="remarks" id="remarks" type="textarea" placeholder="Remarks" label="Remarks"></aui:input>
		</div>
		<aui:button-row>
			<aui:button name="approveStatusBtn" id="approveStatusBtn" value="Approve" onClick="return submitPayConfirmForm('Approved');"> </aui:button>
			<aui:button name="rejectStatusBtn" id="rejectStatusBtn" value="Reject" onClick="return submitPayConfirmForm('Rejected');"> </aui:button>
		</aui:button-row>
	</div>	
</aui:form>

<script src="/SPProcessEngine-portlet/js/custom/enrollmentcourse/productsWithInventory.js?t=<%=DateUtil.newTime() %>">
</script>

<script>
var ns = '<portlet:namespace />';
var payQty = <%= payQty%>;
var _validateInventory = function(qty, callBack) {
    var wsUrl = '/api/jsonws/SPShopping-portlet.spshopping/has-enough-inventory';
        wsUrl += '/class-name-id/' + <%= processState.getEntityClassId()%>;
        wsUrl += '/class-pk/' + <%= processState.getEntityId()%>;
        wsUrl += '/inventory-needed/' + qty;
        console.log('validate url: '+wsUrl);
    _doGet(wsUrl, callBack);
}

var _doGet = function (url, callback) {
    var xhr = new XMLHttpRequest();
    xhr.open("GET", url, true);
    xhr.onload = function () {
      if (callback) {
          callback(JSON.parse(xhr.responseText));
      }
    };
    xhr.send();
};

var setPayConfirmStatus = function(status) {
	document.getElementById(ns+"confirmStatus").value = status;
}

var submitPayConfirmForm = function (status){
	if ('Approved'===status) {
		_validateInventory(payQty, function(data){
			if (data == false) {
				var r = confirm("Available seats is not sufficient for this update.  Please confirm");
				if (r == true) {
					setPayConfirmStatus(status);
					document.getElementById(ns+"validateInventory").value = "false";
					document.getElementById(ns+"payConfirmForm").submit();
				} else {
				    alert('Please adjust the number of participants accordingly.');
				}
			} else {
				setPayConfirmStatus(status);
				document.getElementById(ns+"payConfirmForm").submit();		
			}
			return false;
		});
	} else {
		setPayConfirmStatus(status);
		document.getElementById(ns+"payConfirmForm").submit();
	}
	return false;
}

AUI().ready(function(A) {

	var disabled = <%= !output.isCanEdit() && !output.isCanSubmit() %>;
	var paymentConfirmationStatus = '<%= Validator.isNotNull(paymentConfirmationStatus) ? paymentConfirmationStatus: "" %>';
	ProductsWithInventoryUtil.disableScreen(disabled);
	
	document.getElementById(ns+"remarks").value = '<%= Validator.isNotNull(paymentConfirmationRemarks) ? paymentConfirmationRemarks: "" %>';
	if ("Approved" === paymentConfirmationStatus) {
		A.one('#'+ns+'approveStatusBtn').addClass('btn-primary');
	} else if ("Rejected" === paymentConfirmationStatus) {
		A.one('#'+ns+'rejectStatusBtn').addClass('btn-primary');
	}
});
</script>

<%!
private static Log _log = LogFactoryUtil.getLog("html.custom.enrollmentcourse.paymentConfirmation_jsp");
%> 
