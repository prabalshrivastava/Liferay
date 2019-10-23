<%@page import="java.util.Map"%>
<%@page import="com.fasterxml.jackson.databind.SerializationFeature"%>
<%@page import="com.fasterxml.jackson.databind.ObjectMapper"%>
<%@page import="com.sambaash.platform.finance.constants.FinanceConstants"%>
<%@page import="com.sambaash.platform.finance.service.SPFinanceLocalServiceUtil"%>
<%@page import="com.liferay.portal.security.auth.AuthTokenUtil"%>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>

<%@page import="com.sambaash.platform.constant.SystemSetupConstants"%>
<%@page import="javax.portlet.PortletPreferences"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="javax.portlet.PortletRequest"%>
<%@page import="com.sambaash.platform.util.PermissionUtil"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%><%@
taglib	uri="http://liferay.com/tld/security" prefix="liferay-security"%><%@
taglib	uri="http://liferay.com/tld/theme" prefix="liferay-theme"%><%@
taglib	uri="http://liferay.com/tld/ui" prefix="liferay-ui"%><%@
taglib	uri="http://liferay.com/tld/util" prefix="liferay-util"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<link rel='stylesheet' href='/html/css/sp/formio.full.min.css?minifierType=css'>
<link rel='stylesheet' href='/html/css/hook.css?minifierType=css'>
<link rel='stylesheet' type="text/css"
	href='<%=request.getContextPath()%>/css/transaction.css?minifierType=css'></link>

<liferay-theme:defineObjects />
<%@taglib	uri="/tld/sp-formio" prefix="sp-formio"%>
<%@page import="com.sambaash.platform.util.LabelUtil"%>  

<link rel='stylesheet' type="text/css"
	href='<%=request.getContextPath()%>/css/billing.css?minifierType=css'></link>

<link rel='stylesheet' type="text/css"
	href='<%=request.getContextPath()%>/css/claim.css?minifierType=css'></link>

<style>
#togglerSortColumn {
	float: right
}
#addnew {
	display: none
}
</style>
<div style="display: none;" class="alert alert-danger"
							role="showAlert" id="alert_msg"></div>
<portlet:defineObjects />
<portlet:resourceURL var="resourceURL">
	<portlet:param name="sp_p_auth"
		value="<%= AuthTokenUtil.getToken(request) %>" />
</portlet:resourceURL>
<portlet:resourceURL var="downloadPdfUrl">
	<portlet:param name="action" value="downloadPdf" />
</portlet:resourceURL>
<% if(PermissionUtil.canViewListing( (PortletRequest) request.getAttribute("javax.portlet.request"))){ 
String modelName = portletPreferences.getValue(SystemSetupConstants.PREF_MODEL_NAME, SystemSetupConstants.DEFAULTMODELAME);
String baseUrl = portletPreferences.getValue("baseUrlPref", "");
Map<String, String> categoryMap = SPFinanceLocalServiceUtil.getCategoryMap(request);
Map<String, String> transactionTypeMap = SPFinanceLocalServiceUtil.getTransactionTypeMap(request);
Map<String, String> clientTypeMap = SPFinanceLocalServiceUtil.getClientTypeMap(request);
Map<String, String> functionalComponentMap = SPFinanceLocalServiceUtil.getFunctionalComponentMap(request);
Map<String, String> productMap = SPFinanceLocalServiceUtil.getProductTypeMap(request);
Map<String, String> productSubtypeMap = SPFinanceLocalServiceUtil.getProductSubTypeMap(request);
ObjectMapper objectMapper = new ObjectMapper();
objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
%>
<c:set var="formType" value='<%= modelName %>' />
<script>
var config = {
	    detailPage: "/html/dccreport/view.jsp",
	    report: "/html/dccreport/report.jsp"
	};
</script>
<!-- context menu -->
<div id="threedot">
	<a href="#" class="threedot addInfo"><img
		src="/html/images/big.png" alt="Details"></a>
	<div id="popoverId" class="Pop-Action listingPopover hide">
		<ul>
			<li class="details">
				<img src="<%=request.getContextPath()%>/images/detail.png" alt="Details" />
				<a href="javascript:void(0);" onclick="doDccAction('detail',this);">
					<%=LabelUtil.getLabel(pageContext, themeDisplay, "cb.row.contextmenu.viewdetails")%>
				</a>
			</li>
			<%
				if (SPFinanceLocalServiceUtil.checkRole(request, FinanceConstants.AA_EXECUTIVE_ROLE)) {
			%>
				<li class="acknowledge-fnd">
					<img src="<%=request.getContextPath()%>/images/submit.png" alt="acknowledge" />
					<a href="javascript:void(0);" onclick="doDccAction('ackFND',this);">
						<%=LabelUtil.getLabel(pageContext, themeDisplay, "workflow.acknowledge")%>
					</a>
				</li>
			<%} %>
			<%
				if (SPFinanceLocalServiceUtil.checkRole(request, FinanceConstants.FINANCE_EXECUTIVE_ROLE)) {
			%>
				<li class="acknowledge">
					<img src="<%=request.getContextPath()%>/images/submit.png" alt="acknowledge" />
					<a href="javascript:void(0);" onclick="doDccAction('acknowledge',this);">
						<%=LabelUtil.getLabel(pageContext, themeDisplay, "workflow.acknowledge")%>
					</a>
				</li>
			<%} %>
			<%
				if (SPFinanceLocalServiceUtil.checkRole(request, FinanceConstants.AA_EXECUTIVE_ROLE) || 
						SPFinanceLocalServiceUtil.checkRole(request, FinanceConstants.FINANCE_EXECUTIVE_ROLE)) {
			%>
			<li class="ammendments">
				<img src="<%=request.getContextPath()%>/images/return.png" alt="Details" />
				<a href="javascript:void(0);" onclick="doDccAction('ammendments',this);">
					<%=LabelUtil.getLabel(pageContext, themeDisplay, "workflow.return.amendments")%>
				</a>
			</li>
			<%} %>
		</ul>
	</div>
</div>
<sp-formio:Listing cssClass="formContainer" modelName="${formType}" />
<div id="MultirowPopActionNew" class="Multi-Pop-Action threedot hide">
	<ul>
		<li><img src="/html/images/export.png" alt="List Export"><a
														href="javascript:void(0);"
														onclick="globalExportList(event);">Export</a></li>

	</ul>
</div>
<div class="newPortlets">
	<div class="yui3-skin-sam invoice-action-dialog">
		<div id="dcc-action-dialog-bound" hidden="true" class="modalpopupBox">
			<div id="dcc-action-dialog-content" class="modalpopupContent">
				<form class="formContainer" action="">
					<aui:row>
						<aui:col span="12">
							<h3 id="action_title">Add Remark</h3>
							<p id="action_msg">Please key in your reasons below and
								confirm your action.</p>
							<br />
							<textarea placeholder="Enter Reasons..." cols="" rows=""
								id="dcc_action_reason"></textarea>
						</aui:col>
					</aui:row>
					<aui:row>
						<aui:col span="12">
							<button type="button" id="popup-submit-action"
								class="btn-primary dcc-action-dialog-submit popup-submit-action pull-left"
								style="padding: 8px 12px !important">Submit</button>
							<button type="button" id="popup-cancel-action"
								class="btn-default dcc-action-dialog-cancel popup-cancel-action pull-right">Cancel</button>
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
<script>
var mode = "list";
var model = "dccreport";
var downloadPdfUrl="<%=downloadPdfUrl%>";

var categoryMap = <%=objectMapper.writeValueAsString(categoryMap)%>;
var transactionTypeMap = <%=objectMapper.writeValueAsString(transactionTypeMap)%>;
var clientTypeMap = <%=objectMapper.writeValueAsString(clientTypeMap)%>;
var functionalMap = <%=objectMapper.writeValueAsString(functionalComponentMap)%>;
var productMap = <%=objectMapper.writeValueAsString(productMap)%>;
var productSubtypeMap = <%=objectMapper.writeValueAsString(productSubtypeMap)%>;




var formStorageId = "";
var ajaxUrl = "${resourceURL}";
var oldReload = reloadTable;
var reloadTable = function(a,isSearchList) {
	oldReload.apply(this, [a,isSearchList]);
	for (var c = 0; c < a.length; c++) {
		var as = a[c].contentJson.AcknowledgementStatus;
		var newPopover = document.getElementsByClassName("listingPopover")[c];
		if(typeof as !== "undefined") {
			as = as.toUpperCase();
		}
		
		if(as == "PENDING AA ACKNOWLEDGEMENT"){
			showHideElement(
					newPopover.getElementsByClassName("acknowledge-fnd")[0],
					"block");
		}else{
			
			showHideElement(
					newPopover.getElementsByClassName("acknowledge-fnd")[0],
					"none");
		}
		
		if(as == "PENDING FND ACKNOWLEDGEMENT"){
			showHideElement(
					newPopover.getElementsByClassName("acknowledge")[0],
					"block");
			
		}else{
			showHideElement(
					newPopover.getElementsByClassName("acknowledge")[0],
					"none");
		}
		
		if(as == "PENDING SUBMISSION" || as == "ACKNOWLEDGED"){
			showHideElement(
					newPopover.getElementsByClassName("ammendments")[0],
					"none");
		}else{
			showHideElement(
					newPopover.getElementsByClassName("ammendments")[0],
					"block");
		}
	}
	records = a;
}
</script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/billing.js?<%=System.currentTimeMillis()%>" language="javascript1.2""></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/dcc-report.js?<%=System.currentTimeMillis()%>" language="javascript1.2""></script>
<% } %>	