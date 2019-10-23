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
	String dashBoardLink = SambaashUtil.getDashBoard();
	String categoryType = portletPreferences.getValue(FinanceConstants.PREF_CATEGORY_TYPE, "IN");
	Map<String, String> categoryMap = SPFinanceLocalServiceUtil.getCategoryMap(request);
	Map<String, String> transactionTypeMap = SPFinanceLocalServiceUtil.getTransactionTypeMap(request);
	Map<String, String> clientTypeMap = SPFinanceLocalServiceUtil.getClientTypeMap(request);
	Map<String, String> functionalComponentMap = SPFinanceLocalServiceUtil.getFunctionalComponentMap(request);
	Map<String, String> functionalComponentDisplayMap = SPFinanceLocalServiceUtil.getFunctionalComponentDisplayMap(request);
	Map<String, String> productMap = SPFinanceLocalServiceUtil.getProductTypeMap(request);
	Map<String, String> productSubtypeMap = SPFinanceLocalServiceUtil.getProductSubTypeMap(request);
	Map<String, String> sourceTypeMap = SPFinanceLocalServiceUtil.getSpListTypeMap("finance.transaction.sourcetype", request);
	ObjectMapper objectMapper = new ObjectMapper();
	objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
	String serverCurrDate = sdf.format(new Date());

List<SPListType> miscFeeList = SPListTypeLocalServiceUtil
.getByKey("priceengine.pricesubscheme.miscfees.pricesubtype", groupId);
%>
<portlet:resourceURL var="resourceURL">
	<portlet:param name="sp_p_auth"
		value="<%=AuthTokenUtil.getToken(request)%>" />
</portlet:resourceURL>
<portlet:resourceURL var="downloadPdfUrl">
	<portlet:param name="action" value="downloadPdf" />
</portlet:resourceURL>

<style>
.row-hr{
	margin-bottom: 12px !important;
    margin-top: 0px !important;
}
.pending{
	background-color: #ffc48b;
	color: #996029;
}
.confirmed{
	background-color: #8bdb7c;
	color: #327d24;
}
.pending-approval{
	background-color: #ffd724;
	color: #967c0c;
}
.payment-status{
    border-radius: 50px;
    width: 50%;
    display: inline-block;
    text-align: center;
   }
</style>
<script>
var config = {
	    createPage: "/html/transaction/create.jsp",
	    editPage: "/html/transaction/edit.jsp",
	    detailPage: "/html/transaction/view.jsp",
	    copyPage: "/html/transaction/copy.jsp",
	    collectPaymentPage: "/html/transaction/collect-payment.jsp",
	    collectPaymentEditPage: "/html/transaction/collect-payment-edit.jsp",
	    paymentProcessPage: "/html/transaction/process-payment.jsp"
	};
</script>
<div class="newPortlets">
	<div class="subHeader">
		<div class="container">
			<div class="inner-container">
				<aui:row>
					<aui:col span="10" cssClass="text-center">
						<% if(categoryType.equals("IN")) { %>
						<h2><span>INVOICE DETAILS</span></h2>
						<% } %>
						<% if(categoryType.equals("RE")) { %>
						<h2><span>RECEIPT DETAILS</span></h2>
						<% } %>
						<% if(categoryType.equals("CN")) { %>
						<h2><span>CREDIT NOTE DETAILS</span></h2>
						<% } %>
						<% if(categoryType.equals("RF")) { %>
						<h2><span>REFUND DETAILS</span></h2>
						<% } %>
						<% if(categoryType.equals("PA")) { %>
						<h2><span><%=LabelUtil.getLabel(pageContext, td, "pa.detail.title")%></span></h2>
						<% } %>
					</aui:col>
					<aui:col span="2" cssClass="text-right">
						<aui:a href="<%=dashBoardLink%>" title="Back to Home">Back to Home</aui:a>
					</aui:col>
				</aui:row>
			</div>
		</div>
	</div>

	<div class="invoiceDetailsFormDiv">
		<div class="formRoot">
			<div class="innerFormRoot">
				<div class="formContainer container formio-form">
					<form class="aui" id="invoiceDetailsForm" name="invoiceDetailsForm"
						action="">
						<aui:row>
							<aui:col span="10" cssClass="offset1">
								<div style="display: none;" class="alert alert-danger"
									role="showAlert" id="alert_msg">Select Facility Type.</div>
								<% if(categoryType.equals("IN")) { %>	
								<aui:row>
									<aui:col span="3">
										<div class="form-group">
											<label class="control-label">
												Invoice Date
											</label>
										</div>
									</aui:col>
									<aui:col span="8" cssClass="formio-component-textfield">
										<div class="form-group">
											<aui:input type="text" name="" readonly="readonly" id="txnDate"
												cssClass="form-control" />
										</div>
									</aui:col>
								</aui:row>
								<aui:row>
									<aui:col span="3">
										<div class="form-group">
											<label class="control-label">
												Invoice Number
											</label>
										</div>
									</aui:col>
									<aui:col span="8" cssClass="formio-component-textfield">
										<div class="form-group">
											<aui:input type="text" name="" readonly="readonly" id="number"
												cssClass="form-control" />
										</div>
									</aui:col>
								</aui:row>
								<aui:row>
									<aui:col span="3">
										<div class="form-group">
											<label class="control-label">Name of Payer</label>
										</div>
									</aui:col>
									<aui:col span="8" cssClass="formio-component-textfield">
										<div class="form-group">
											<aui:input type="text" name="" readonly="readonly" id="nameOfPayer"
												cssClass="form-control" />
										</div>
									</aui:col>
								</aui:row>
								<aui:row>
									<aui:col span="3">
										<div class="form-group">
											<label class="control-label">Description</label>
										</div>
									</aui:col>
									<aui:col span="8" cssClass="formio-component-textfield">
										<div class="form-group">
											<aui:input type="text" name="" readonly="readonly" id="description"
												cssClass="form-control" />
										</div>
									</aui:col>
								</aui:row>
								<aui:row>
									<aui:col span="3">
										<div class="form-group">
											<label class="control-label">Invoice Due Date</label>
										</div>
									</aui:col>
									<aui:col span="8" cssClass="formio-component-textfield">
										<div class="form-group">
											<aui:input type="text" name="" readonly="readonly" id="dueDate"
												cssClass="form-control" />
										</div>
									</aui:col>
								</aui:row>
								<aui:row>
									<aui:col span="3">
										<div class="form-group">
											<label class="control-label">Approval Status</label>
										</div>
									</aui:col>
									<aui:col span="8" cssClass="formio-component-textfield">
										<div class="form-group">
											<aui:input type="text" name="" readonly="readonly" id="approvalStatus"
												cssClass="form-control" />
										</div>
									</aui:col>
								</aui:row>
								<aui:row>
									<aui:col span="3">
										<div class="form-group">
											<label class="control-label">
												Invoice Amount
											</label>
										</div>
									</aui:col>
									<aui:col span="8" cssClass="formio-component-textfield">
										<div class="form-group">
											<aui:input type="text" name="" readonly="readonly" id="amount"
												cssClass="form-control" />
										</div>
									</aui:col>	
								</aui:row>
								<aui:row>
									<aui:col span="3">
										<div class="form-group">
											<label class="control-label">Request Type</label>
										</div>
									</aui:col>
									<aui:col span="8" cssClass="formio-component-textfield">
										<div class="form-group">
											<aui:input type="text" name="" readonly="readonly" id="requestType"
												cssClass="form-control" />
										</div>
									</aui:col>
								</aui:row>
								<aui:row>
									<aui:col span="3">
										<div class="form-group">
											<label class="control-label">Processed by</label>
										</div>
									</aui:col>
									<aui:col span="8" cssClass="formio-component-textfield">
										<div class="form-group">
											<aui:input type="text" name="" readonly="readonly" id="processedBy"
												cssClass="form-control" />
										</div>
									</aui:col>
								</aui:row>
								<% } %>
								<% if(categoryType.equals("RE")) { %>
								<aui:row>
									<aui:col span="3">
										<div class="form-group">
											<label class="control-label">
												Receipt Date & Time
											</label>
										</div>
									</aui:col>
									<aui:col span="8" cssClass="formio-component-textfield">
										<div class="form-group">
											<aui:input type="text" name="" readonly="readonly" id="txnDate"
												cssClass="form-control" />
										</div>
									</aui:col>
								</aui:row>
								<aui:row>
									<aui:col span="3">
										<div class="form-group">
											<label class="control-label">
												Receipt Number
											</label>
										</div>
									</aui:col>
									<aui:col span="8" cssClass="formio-component-textfield">
										<div class="form-group">
											<aui:input type="text" name="" readonly="readonly" id="number"
												cssClass="form-control" />
										</div>
									</aui:col>
								</aui:row>	
								<aui:row>
									<aui:col span="3">
										<div class="form-group">
											<label class="control-label">
												Receipt Type
											</label>
										</div>
									</aui:col>
									<aui:col span="8" cssClass="formio-component-textfield">
										<div class="form-group">
											<aui:input type="text" name="" readonly="readonly" id="source"
												cssClass="form-control" />
										</div>
									</aui:col>
								</aui:row>
								<aui:row>
									<aui:col span="3">
										<div class="form-group">
											<label class="control-label">Name</label>
										</div>
									</aui:col>
									<aui:col span="8" cssClass="formio-component-textfield">
										<div class="form-group">
											<aui:input type="text" name="" readonly="readonly" id="nameOfPayer"
												cssClass="form-control" />
										</div>
									</aui:col>
								</aui:row>
								<aui:row>
									<aui:col span="3">
										<div class="form-group">
											<label class="control-label">
												Payment Mode(s)
											</label>
										</div>
									</aui:col>
									<aui:col span="8" cssClass="formio-component-textfield">
										<div class="form-group">
											<aui:input type="text" name="" readonly="readonly" id="paymentModes"
												cssClass="form-control" />
										</div>
									</aui:col>
								</aui:row>
								<aui:row>
									<aui:col span="3">
										<div class="form-group">
											<label class="control-label">
												Payment Status
											</label>
										</div>
									</aui:col>
									<aui:col span="8" cssClass="formio-component-textfield">
										<div class="form-group">
											<aui:input type="text" name="" readonly="readonly" id="paymentStatus"
												cssClass="form-control" />
										</div>
									</aui:col>
								</aui:row>
								<aui:row>
									<aui:col span="3">
										<div class="form-group">
											<label class="control-label">
												Amount Received
											</label>
										</div>
									</aui:col>
									<aui:col span="8" cssClass="formio-component-textfield">
										<div class="form-group">
											<aui:input type="text" name="" readonly="readonly" id="amount"
												cssClass="form-control" />
										</div>
									</aui:col>	
								</aui:row>
								<aui:row>
									<aui:col span="3">
										<div class="form-group">
											<label class="control-label">Notes</label>
										</div>
									</aui:col>
									<aui:col span="8" cssClass="formio-component-textfield">
										<div class="form-group">
											<aui:input type="text" name="" readonly="readonly" id="notes"
												cssClass="form-control" />
										</div>
									</aui:col>
								</aui:row>
								<aui:row>
									<aui:col span="3">
										<div class="form-group">
											<label class="control-label">Request Type</label>
										</div>
									</aui:col>
									<aui:col span="8" cssClass="formio-component-textfield">
										<div class="form-group">
											<aui:input type="text" name="" readonly="readonly" id="requestType"
												cssClass="form-control" />
										</div>
									</aui:col>
								</aui:row>
								<aui:row>
									<aui:col span="3">
										<div class="form-group">
											<label class="control-label">Processed by</label>
										</div>
									</aui:col>
									<aui:col span="8" cssClass="formio-component-textfield">
										<div class="form-group">
											<aui:input type="text" name="" readonly="readonly" id="processedBy"
												cssClass="form-control" />
										</div>
									</aui:col>
								</aui:row>
								<% } %>
								
								<% if(categoryType.equals("PA")) { %>
							<div id="idAndNameRow">
								<aui:row>
									<aui:col span="3">
										<div class="form-group">
											<label class="control-label">
												ID & Name
											</label>
										</div>
									</aui:col>
									<aui:col span="9" cssClass="formio-component-textfield">
										<div class="form-group">
											<aui:input type="text" name="" readonly="readonly" id="idAndName"
												cssClass="form-control" />
										</div>
									</aui:col>
								</aui:row>
								<hr class="row-hr" />
							</div>
							<div id="productTypeRow">
								<aui:row>
									<aui:col span="3">
										<div class="form-group">
											<label class="control-label">
												Product type & Sub-type
											</label>
										</div>
									</aui:col>
									<aui:col span="9" cssClass="formio-component-textfield">
										<div class="form-group">
											<aui:input type="text" name="" readonly="readonly" id="productType"
												cssClass="form-control" />
										</div>
									</aui:col>
								</aui:row>
								<hr class="row-hr" />
							</div>
							<div id="descriptionRow">
								<aui:row>
									<aui:col span="3">
										<div class="form-group">
											<label class="control-label">
												Description
											</label>
										</div>
									</aui:col>
									<aui:col span="9" cssClass="formio-component-textfield">
										<div class="form-group">
											<aui:input type="text" name="" readonly="readonly" id="description"
												cssClass="form-control" />
										</div>
									</aui:col>
								</aui:row>
								<hr class="row-hr" />
							</div>
							<div id="amountToBePaidRow">
								<aui:row>
									<aui:col span="3">
										<div class="form-group">
											<label class="control-label">
												Original Amount to be paid (SGD)
											</label>
										</div>
									</aui:col>
									<aui:col span="9" cssClass="formio-component-textfield">
										<div class="form-group">
											<aui:input type="text" name="" readonly="readonly" id="amountToBePaid"
												cssClass="form-control" />
										</div>
									</aui:col>
								</aui:row>
								<hr class="row-hr" />
							</div>
							<div id="miscFeeRow">
								<aui:row>
									<aui:col span="3">
										<div class="form-group">
											<label class="control-label">
												Misc - Admin Fee (SGD)
											</label>
										</div>
									</aui:col>
									<aui:col span="9" cssClass="formio-component-textfield">
										<div class="form-group">
											<aui:input type="text" name="" readonly="readonly" id="miscFee"
												cssClass="form-control" />
										</div>
									</aui:col>
								</aui:row>
								<hr class="row-hr" />
							</div>
							<div id="amountPayableRow">
								<aui:row>
									<aui:col span="3">
										<div class="form-group">
											<label class="control-label">
												Total Amount Payable (SGD)
											</label>
										</div>
									</aui:col>
									<aui:col span="9" cssClass="formio-component-textfield">
										<div class="form-group">
											<aui:input type="text" name="" readonly="readonly" id="amountPayable"
												cssClass="form-control" />
										</div>
									</aui:col>
								</aui:row>
								<hr class="row-hr" />
							</div>
							<div id="paymentModeRow">
								<aui:row>
									<aui:col span="3">
										<div class="form-group">
											<label class="control-label">
												Payment Mode
											</label>
										</div>
									</aui:col>
									<aui:col span="9" cssClass="formio-component-textfield">
										<div class="form-group">
											<aui:input type="text" name="" readonly="readonly" id="paymentMode"
												cssClass="form-control" />
										</div>
									</aui:col>
								</aui:row>
								<hr class="row-hr" />
							</div>
							<div id="valueDateRow">
								<aui:row>
									<aui:col span="3">
										<div class="form-group">
											<label class="control-label">
												Value Date
											</label>
										</div>
									</aui:col>
									<aui:col span="6" cssClass="formio-component-textfield" >
										<div class="form-group">
											<aui:input type="text" name="" readonly="readonly" id="valueDate"
												cssClass="form-control" />
											<span class="input-group-addon" style="cursor: pointer">
												<i class="glyphicon glyphicon-calendar dtPickerIcon" style="top: 15px;"></i>
											</span>
										</div>
									</aui:col>
								</aui:row>
								<hr class="row-hr" />
							</div>
							<div id="creditDateRow">
								<aui:row>
									<aui:col span="3">
										<div class="form-group">
											<label class="control-label">
												Credit Date
											</label>
										</div>
									</aui:col>
									<aui:col span="6" cssClass="formio-component-textfield" >
										<div class="form-group">
											<aui:input type="text" name="" readonly="readonly" id="creditDate"
												cssClass="form-control" />
											<span class="input-group-addon" style="cursor: pointer">
												<i class="glyphicon glyphicon-calendar dtPickerIcon" style="top: 15px;"></i>
											</span>
										</div>
									</aui:col>
								</aui:row>
								<hr class="row-hr" />
							</div>
							<div id="paymentSetCodeRow">
								<aui:row>
									<aui:col span="3">
										<div class="form-group">
											<label class="control-label">
												Payment Set Code
											</label>
										</div>
									</aui:col>
									<aui:col span="6" cssClass="formio-component-textfield" >
										<div class="form-group">
											<aui:input type="text" name="" readonly="readonly" id="paymentSetCode"
												cssClass="form-control" />
										</div>
									</aui:col>
								</aui:row>
								<hr class="row-hr" />
							</div>
							<div id="paymentStatusRow">
								<aui:row>
									<aui:col span="3">
										<div class="form-group">
											<label class="control-label">
												Payment Status
											</label>
										</div>
									</aui:col>
									<aui:col span="9" cssClass="formio-component-textfield">
										<div class="form-group">
											<label class="control-label" style="line-height: 30px !important;">
												<span class="payment-status" style="margin-top: 5px;"  id="paymentStatus">PENDING</span>
											</label>
										</div>
									</aui:col>
								</aui:row>
								<hr class="row-hr" />
							</div>
							<div id="notesRow">
								<aui:row>
									<aui:col span="3">
										<div class="form-group">
											<label class="control-label">
												Notes
											</label>
										</div>
									</aui:col>
									<aui:col span="9" cssClass="formio-component-textfield">
										<div class="form-group">
											<aui:input type="text" name="" readonly="readonly" id="notes"
												cssClass="form-control" />
										</div>
									</aui:col>
								</aui:row>
								<hr class="row-hr" />
							</div>
								
								<% } %>
								<% if(categoryType.equals("CN")) { %>
					<div id="idNoRow">
						<aui:row>
							<aui:col span="3">
								<div class="form-group">
									<label class="control-label">
										ID No.
									</label>
								</div>
							</aui:col>
							<aui:col span="9" cssClass="formio-component-textfield">
								<div class="form-group">
									<aui:input type="text" name="" readonly="readonly" id="idName"
										cssClass="form-control" />
								</div>
							</aui:col>
						</aui:row>
						<hr class="row-hr" />
					</div>
					<div id="nameRow">
						<aui:row>
							<aui:col span="3">
								<div class="form-group">
									<label class="control-label">
										Name
									</label>
								</div>
							</aui:col>
							<aui:col span="9" cssClass="formio-component-textfield">
								<div class="form-group">
									<aui:input type="text" name="" readonly="readonly" id="name"
										cssClass="form-control" />
								</div>
							</aui:col>
						</aui:row>
						<hr class="row-hr" />
					</div>
					<div id="creditNoteDtRow">
						<aui:row>
							<aui:col span="3">
								<div class="form-group">
									<label class="control-label">
										Credit Note Date
									</label>
								</div>
							</aui:col>
							<aui:col span="9" cssClass="formio-component-textfield">
								<div class="form-group">
									<aui:input type="text" name="" readonly="readonly" id="creditNoteDt"
										cssClass="form-control" />
								</div>
							</aui:col>
						</aui:row>
						<hr class="row-hr" />
					</div>
					<div id="creditNoteNoRow">
						<aui:row>
							<aui:col span="3">
								<div class="form-group">
									<label class="control-label">
										Credit Note Number
									</label>
								</div>
							</aui:col>
							<aui:col span="9" cssClass="formio-component-textfield">
								<div class="form-group">
									<aui:input type="text" name="" readonly="readonly" id="creditNoteNo"
										cssClass="form-control" />
								</div>
							</aui:col>
						</aui:row>
						<hr class="row-hr" />
					</div>
					<div id="receiptNoRow">
						<aui:row>
							<aui:col span="3">
								<div class="form-group">
									<label class="control-label">
										Receipt Number
									</label>
								</div>
							</aui:col>
							<aui:col span="9" cssClass="formio-component-textfield">
								<div class="form-group">
									<aui:input type="text" name="" readonly="readonly" id="receiptNo"
										cssClass="form-control" />
								</div>
							</aui:col>
						</aui:row>
						<hr class="row-hr" />
					</div>
					<div id="descriptionRow">
						<aui:row>
							<aui:col span="3">
								<div class="form-group">
									<label class="control-label">
										Description
									</label>
								</div>
							</aui:col>
							<aui:col span="9" cssClass="formio-component-textfield">
								<div class="form-group">
									<aui:input type="text" name="" readonly="readonly" id="description"
										cssClass="form-control" />
								</div>
							</aui:col>
						</aui:row>
						<hr class="row-hr" />
					</div>
					<div id="natureOfCreditRow">
						<aui:row>
							<aui:col span="3">
								<div class="form-group">
									<label class="control-label">
										Nature of Credit
									</label>
								</div>
							</aui:col>
							<aui:col span="9" cssClass="formio-component-textfield">
								<div class="form-group">
									<aui:input type="text" name="" readonly="readonly" id="natureOfCredit"
										cssClass="form-control" />
								</div>
							</aui:col>
						</aui:row>
						<hr class="row-hr" />
					</div>
					<div id="amountRow">
						<aui:row>
							<aui:col span="3">
								<div class="form-group">
									<label class="control-label">
										Amount (SGD)
									</label>
								</div>
							</aui:col>
							<aui:col span="9" cssClass="formio-component-textfield" >
								<div class="form-group">
									<aui:input type="text" name="" readonly="readonly" id="amount"
										cssClass="form-control" />
								</div>
							</aui:col>
						</aui:row>
						<hr class="row-hr" />
					</div>
						<% } %>
							</aui:col>
						</aui:row>
					</form>
					<aui:row cssClass="userAction">
						<aui:col span="4"></aui:col>
						<aui:col span="4">
							<% if(categoryType.equals("IN")) { %>
							<button type="button" style="width: 160px;" onclick="doInvoiceAction('pdf')" class="btn btn-primary">VIEW INVOICE</button>
							<% } %>
							<% if(categoryType.equals("RE")) { %>
							<button type="button" style="width: 160px;" onclick="doInvoiceAction('pdf')" class="btn btn-primary">VIEW RECEIPT</button>
							<% } %>
							<% if(categoryType.equals("CN")) { %>
							<button type="button" style="width: 250px;" onclick="doInvoiceAction('pdf')" class="btn btn-primary">VIEW CREDIT NOTE ADVICE</button>
							<% } %>
							<% if(categoryType.equals("RF")) { %>
							<button type="button" style="width: 160px;" onclick="doInvoiceAction('pdf')" class="btn btn-primary">VIEW REFUND</button>
							<% } %>
							<% if(categoryType.equals("PA")) { %>
							
							<% } %>
						</aui:col>
						<aui:col span="4"></aui:col>
					</aui:row>
				</div>
			</div>
		</div>
	</div>
	
	<div class="remarksHeader" id="remarksHeader">
		<div class="container">
			<aui:row>
				<aui:col span="12" cssClass="text-center">
				<h4 style="float:left">REMARKS LOG</h4>
				<h4 id="totalRemarks" style="float:right">(Total: 0 Remarks)</h4>
			</aui:col>
			</aui:row>
		</div>
	</div>
	<div class="invoiceRemarksDiv" id="invoiceRemarksDiv">
		<div class="formContainer container formio-form" id="invoiceRemarksContainer">
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
								<p class="remarksAction"><b>Amy Marshall returned</b> for amendments</p>
								<p class="remarksTime">11:15</p>
							</aui:row>
							<aui:row>
								<p class="remarksText">This is sample remarks for testing.This is sample remarks
									for testing.This is sample remarks for testing.This is sample
									remarks for testing.123</p>
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
				<% if(categoryType.equals("PA")) { %>
					<% if(SPFinanceLocalServiceUtil.checkRole(request, FinanceConstants.FINANCE_SUBMITTER_ROLE)) { %>
						<button id="btnProcessPayment" type="button" style="width: 195px;" onclick="doProcessPayment();" class="btn btn-primary"><%=LabelUtil.getLabel(pageContext, td, "pa.global.contextmenu.processpayment")%></button>
					<% } %>
					<% if(SPFinanceLocalServiceUtil.checkRole(request, FinanceConstants.FINANCE_APPROVER_ROLE)) { %>
						<button type="button" class="btn btn-primary submit-invoice-button" id="approve"
							onClick="doProcessPaymentAction('approve', 'none')">
							<%=LabelUtil.getLabel(pageContext, td, "workflow.approve")%>
						</button>
						<button type="button" class="btn btn-default submit-invoice-button" id="reject"
							onClick="doProcessPaymentAction('reject', 'none')">
							<%=LabelUtil.getLabel(pageContext, td, "pa.row.btn.reject")%>
						</button>
						<button type="button" class="btn btn-default submit-invoice-button" id="samendment"
							onClick="doProcessPaymentAction('samendments', 'none')" style="font-size: 10px;width: 250px!important">
							<%=LabelUtil.getLabel(pageContext, td, "workflow.return.submitter")%>
						</button><!-- 
						<button type="button" class="btn btn-default submit-invoice-button" id="vamendment"
							onClick="doProcessPaymentAction('vamendments', 'none')" style="font-size: 10px;">
							<%=LabelUtil.getLabel(pageContext, td, "workflow.return.verifier")%>
							-->
						</button>
					<% } %>
						<button id="btnBackToListing" type="button" style="width: 195px;" class="btn btn-default" id="back" onclick="goBack();" ><%=LabelUtil.getLabel(pageContext, td, "pa.payment.advice.backtolistings")%></button>
				<% } else { %>
					<% if(SPFinanceLocalServiceUtil.checkRole(request, FinanceConstants.FINANCE_SUBMITTER_ROLE)) { %>
					<input type="hidden" id="showBackToListing" />
						<button type="button"
							class="edit-invoice-button btn btn-default" id="edit"
							onClick="doInvoiceAction('edit')">
							<%=LabelUtil.getLabel(pageContext, td, "label.edit")%>	
						</button>
						<button type="button"
							class="btn btn-primary submit-invoice-button" id="submit"
							onClick="doInvoiceAction('submit')">
							<%=LabelUtil.getLabel(pageContext, td, "workflow.submit.approval")%>	
						</button>
							<% if(categoryType.equals("IN")) { %>
						<button type="button" onclick="doInvoiceAction('void');" id="void"
							class="btn btn-default void-invoice-button">
							<%=LabelUtil.getLabel(pageContext, td, "workflow.invoice.voidcancel")%>
						</button>
						<button type="button" onclick="doInvoiceAction('cancel');" id="cancel"
							class="btn btn-default void-invoice-button">
							<%=LabelUtil.getLabel(pageContext, td, "workflow.invoice.voidcancel")%>
						</button>
							<% } else if(categoryType.equals("RE")) {%>
							<button type="button" onclick="doInvoiceAction('void');" id="void"
							class="btn btn-default void-invoice-button">
							<%=LabelUtil.getLabel(pageContext, td, "workflow.receipt.voidcancel")%>
						</button>
						<button type="button" onclick="doInvoiceAction('cancel');" id="cancel"
							class="btn btn-default void-invoice-button">
							<%=LabelUtil.getLabel(pageContext, td, "workflow.receipt.voidcancel")%>
						</button>
							<% } else if(categoryType.equals("CN")) {%>
							<% } %>
					<% } %>
					<% if(SPFinanceLocalServiceUtil.checkRole(request, FinanceConstants.FINANCE_APPROVER_ROLE)) { %>
						<button type="button" class="btn btn-primary" id="approve"
							onClick="processRecord('approve','<%=formStorageId %>')" style="width: 125px">
							<%=LabelUtil.getLabel(pageContext, td, "workflow.approve")%>
						</button>
						<button type="button" class="btn btn-danger" id="reject"
							onClick="doInvoiceAction('reject')" style="width: 100px;">
							<%=LabelUtil.getLabel(pageContext, td, "workflow.reject")%>
						</button>
						<button type="button" onclick="doInvoiceAction('return')" class="btn btn-default" id="return"
							style="width: 240px;">
							<%=LabelUtil.getLabel(pageContext, td, "workflow.return.amendments")%>
						</button>
					<% } %>	
					<button type="button" class="btn btn-default" id="back"
							onclick="goBack();" style="width:100px">
						<%=LabelUtil.getLabel(pageContext, td, "label.cancel")%>		
					</button>
				<% } %>
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
										<input type="radio" name="reasonsCb" value="Cheque Dishonoured" checked="checked">
										Cheque Dishonoured<br />
										<input type="radio" name="reasonsCb" value="Cheque Rejected">
										Cheque Rejected<br />
										<input type="radio" name="reasonsCb" value="Others (Refund to Credit Balance)">
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
								class="btn-primary popup-submit-action pull-left" style="padding: 8px 12px !important">Submit</button>
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
							<button type="button"
								class="btn btn-default" onclick="goBack();" style="margin: 0 auto; display:block">Back To List</button>
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
var sourceTypeMap = <%=objectMapper.writeValueAsString(sourceTypeMap)%>;
var invoiceTypeDetail = "";

var miscFeeList = <%=objectMapper.writeValueAsString(miscFeeList)%>;
var miscFeeAllMap = {};
var candidateMap={};
var candidateDetailMap={};
</script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/billing.js?<%=System.currentTimeMillis()%>"
	language="javascript1.2"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/invoice-details.js?<%=System.currentTimeMillis()%>"
	language="javascript1.2"></script>
	<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/invoice-actions.js?<%=System.currentTimeMillis()%>"
	language="javascript1.2"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/main.js?<%=System.currentTimeMillis()%>"
	language="javascript1.2"></script>
<script>
	for(var i=0;i<miscFeeList.length;i++){
		var value = miscFeeList[i];
		miscFeeAllMap[value.itemValue] = value.displayName;
	}

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
								candidateDetailMap[val.storageId] = val;
							}
						}
						for(var k in candidateMap){
							if(k != undefined){
								opt = opt + "<option value='"+k+"'>"+candidateMap[k]+"</option>";
							}
						}
						//getEID(namespace + "candidateids").innerHTML = opt;
					}
				}, function() {
					
				});
	}
	getCandidateList("active");
	getCandidateList("Active");
</script>