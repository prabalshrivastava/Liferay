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
<link rel='stylesheet' type="text/css"
	href='<%=request.getContextPath()%>/css/claim.css?minifierType=css'></link>
<link rel='stylesheet' type="text/css"
	href='<%=request.getContextPath()%>/css/transaction.css?minifierType=css'></link>
<script type="text/javascript"
	src="/html/js/sp/hook.js?<%=System.currentTimeMillis()%>"
	language="javascript1.2""></script>

<portlet:defineObjects />
<%
	String formStorageId = request.getParameter("storageId");
	String baseUrl = portletPreferences.getValue("baseUrlPref", "");
	ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
	Long groupId = themeDisplay.getLayout().getGroupId();
	String dashBoardLink = SambaashUtil.getDashBoard();
	String globalBaseCurrency = SambaashUtil.getParameter("base_currency", groupId);
	Map<Long, String> claimTypeMap = SPFinanceLocalServiceUtil.getSpListTypeIdToDisplayName("finance.payment.claimType", request);
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
			<div class="inner-container">
			<aui:row>
				<aui:col span="10" cssClass="text-center">
				<h2><span>Recongnise As Revenue</span></h2>
					
				</aui:col>
				<aui:col span="2" cssClass="text-right">
					<aui:a href="<%=dashBoardLink%>" title="Back to Home">Back to Home</aui:a>
				</aui:col>
			</aui:row>
			</div>
		</div>
	</div>

	<div class="recoAsRevFormDiv">
	<div class="formRoot">
		<div class="formContainer container formio-form" style="padding-top: 50px !important; padding: 75px 70px !important;">
			<form class="aui" id="paymentAdviceForm" name="paymentAdviceForm"
				action="">
				<aui:row>
					<aui:col span="10" cssClass="offset1">
						<div style="display: none;" class="alert alert-danger"
							role="showAlert" id="alert_msg">Select Facility Type.</div>
							<aui:input name="" type="hidden" id="CreditBalanceCode" />
							<aui:input name="" type="hidden" id="IdAndName" />
							<aui:input name="" type="hidden" id="UserType" />
							<aui:input name="" type="hidden" id="UserId" />
							<aui:input name="" type="hidden" id="UserName" />
					</aui:col>
				</aui:row>
				<aui:row>
					<aui:col span="12" cssClass="">
						<table id="feeSchemeTableId" style="width:100%!important;margin-top:10px!important;">
							<thead>
								<tr>
									<th><%=LabelUtil.getLabel(pageContext, themeDisplay, "cb.detail.userid")%></th>
									<th><%=LabelUtil.getLabel(pageContext, themeDisplay, "cb.detail.username")%></th>
									<th><%=LabelUtil.getLabel(pageContext, themeDisplay, "cb.detail.credibalance")%></th>
									<th><%=LabelUtil.getLabel(pageContext, themeDisplay, "cb.detail.initiatedby")%></th>
									<th><%=LabelUtil.getLabel(pageContext, themeDisplay, "cb.detail.amountprocessed")%></th>
								</tr>
							</thead>
							<tr id="feeSchemeContainerRow" class="feeSchemeContainerRow">
								<td id="userId" class="userId"></td>
								<td id="userName" class="userName"></td>
								<td id="creditBalanceAmt" class="creditBalanceAmt"></td>
								<td><aui:select name="" id="initiatedBy" class="form-control initiatedBy">
											<aui:option value="Candidate/Corporate"><%=LabelUtil.getLabel(pageContext, themeDisplay, "cb.detail.recogniseasrevenue.candidate.corporate")%></aui:option>
											<aui:option value="InternalUser"><%=LabelUtil.getLabel(pageContext, themeDisplay, "cb.detail.recogniseasrevenue.internal.user")%></aui:option>
										</aui:select></td>
								<td><aui:input type="number" name=""
									class="form-control quantity" id="amountProcessed"
									placeholder="Amount to be processed" oninput="validateAmountProcessed('amountProcessed', 'creditBalanceAmt')"/></td>
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
				
				<aui:row  cssClass="userAction" style="margin-top: 200px;">
						<aui:col span="3" >
						</aui:col>
						<aui:col span="3" >
							<button type="button" id="mass-process-popup-submit-action"
								onclick="submitForVerification('single');" class="btn-primary btn mass-process-popup-submit-action pull-left" style="float:right;width:240px;margin-left: 50px !important; padding: 8px 12px !important">Submit For Verification</button>
						</aui:col>
						<aui:col span="3" >
							<button type="button" id="mass-process-popup-cancel-action" onclick="goBack();"
								class="btn-default btn mass-process-popup-cancel-action pull-right" style="float:left;margin-right: 50px !important; padding: 8px 12px !important; margin-top: 20px">Cancel</button>
						</aui:col>
						
						<aui:col span="3" >
						</aui:col>
					</aui:row>
			</form>
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
		<div id="credit-action-dialog-bound" hidden="true" class="modalpopupBox">
			<div id="credit-action-dialog-content" class="modalpopupContent">
				<form class="formContainer" action="">
					<aui:row>
						<aui:col span="12">
							<h3 id="action_title">Add Remarks</h3>
							<p id="action_msg">Please key in your remarks justifying your comment action</p>
							<br/>
							<textarea placeholder="Add your text here..." cols="" rows="" id="credit_action_reason"></textarea>
						</aui:col>
					</aui:row>
					<aui:row>
						<aui:col span="12">
							<button type="button" id="popup-submit-action"
								class="btn-primary credit-action-dialog-submit popup-submit-action pull-left"
								style="padding: 8px 12px !important">Submit</button>
							<button type="button" id="popup-cancel-action"
								class="btn-default credit-action-dialog-cancel popup-cancel-action pull-right">Cancel</button>
						</aui:col>
					</aui:row>
				</form>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/main.js?<%=System.currentTimeMillis()%>"
	language="javascript1.2"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/credit-balance.js?<%=System.currentTimeMillis()%>" language="javascript1.2""></script>
	<%-- <script type="text/javascript" src="<%=request.getContextPath()%>/js/cb-view-revenue.js" language="javascript1.2""></script> --%>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/billing.js?<%=System.currentTimeMillis()%>" language="javascript1.2""></script>


<script type="text/javascript">
var serverCurrDate ="<%=serverCurrDate%>";
var namespace =  "<portlet:namespace/>";
var ajaxUrl = "${resourceURL}";
var formStorageId = "<%=formStorageId%>";
var baseUrl = "<%=baseUrl%>";
var mode = "view-revenue";
var downloadPdfUrl="<%=downloadPdfUrl%>";
var serverCurrDate ="<%=serverCurrDate%>";
var globalBaseCurrency ="<%=globalBaseCurrency%>";
var claimTypeMap = <%=objectMapper.writeValueAsString(claimTypeMap)%>;
var categoryMap = <%=objectMapper.writeValueAsString(categoryMap)%>;
var transactionTypeMap = <%=objectMapper.writeValueAsString(transactionTypeMap)%>;
var clientTypeMap = <%=objectMapper.writeValueAsString(clientTypeMap)%>;
var functionalMap = <%=objectMapper.writeValueAsString(functionalComponentMap)%>;
var productMap = <%=objectMapper.writeValueAsString(productMap)%>;
var productSubtypeMap = <%=objectMapper.writeValueAsString(productSubtypeMap)%>;
</script>