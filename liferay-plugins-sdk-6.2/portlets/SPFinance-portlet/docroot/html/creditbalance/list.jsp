<%@page import="com.fasterxml.jackson.databind.SerializationFeature"%>
<%@page import="com.fasterxml.jackson.databind.ObjectMapper"%>
<%@page import="java.util.Map"%>
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
.pd-15 {
    padding: 15px !important;
    font-weight: 600 !important;
}
.bg-transparent {
	background: transparent !important;
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
String creditNotesUrl = portletPreferences.getValue("creditNotesUrlPref", "");
%>
<c:set var="formType" value='<%= modelName %>' />
<script>
var config = {
		createPage: "/html/creditbalance/create.jsp",
	    editPage: "/html/creditbalance/edit.jsp",
	    detailPage: "/html/creditbalance/view.jsp",
	    viewRevenuePage : "/html/creditbalance/view-revenue.jsp",
	    refundPage : "/html/creditbalance/process-refund.jsp"
	};
</script>
<!-- context menu -->
<div id="threedot">
	<a href="#" class="threedot addInfo"><img
		src="/html/images/big.png" alt="Details"></a>
	<div id="popoverId" class="Pop-Action listingPopover hide">
	<ul>
		<li class="view-detail">
			<img src="<%=request.getContextPath()%>/images/detail.png" alt="View Detail">
			<a href="javascript:void(0);" onclick="doCreditAction('detail',this);">
			<%=LabelUtil.getLabel(pageContext, themeDisplay, "cb.row.contextmenu.viewdetails")%></a></li>
		
		<li class="refund-advice">
			<img src="<%=request.getContextPath()%>/images/detail.png" alt="Refund Advice">
			<a href="javascript:void(0);" onclick="doCreditAction('refundAdvice',this);">
			<%=LabelUtil.getLabel(pageContext, themeDisplay, "cb.row.contextmenu.refundadvice")%></a></li>
		
		<li class="credit-notes">
			<img src="<%=request.getContextPath()%>/images/detail.png" alt="Credit Notes">
			<a href="javascript:void(0);" onclick="doCreditAction('creditnotes',this);">
			<%=LabelUtil.getLabel(pageContext, themeDisplay, "cb.row.contextmenu.creditnotes")%></a></li>
		
		<%if(SPFinanceLocalServiceUtil.checkRole(request, FinanceConstants.FINANCE_SUBMITTER_ROLE)){ %>
			<li class="recognise-as-revenue">
				<img src="<%=request.getContextPath()%>/images/submit.png" alt="Recognise As Revenue">
				<a href="javascript:void(0);" onclick="doCreditAction('recogniseAsRevenue',this);">
					<%=LabelUtil.getLabel(pageContext, themeDisplay, "cb.row.contextmenu.recogniseasrevenue")%>
				</a>
			</li>
			
			<li class="make-refund">
				<img src="<%=request.getContextPath()%>/images/submit.png" alt="Make Refund">
				<a href="javascript:void(0);" onclick="doCreditAction('makerefund',this);">
					<%=LabelUtil.getLabel(pageContext, themeDisplay, "cb.row.contextmenu.makerefund")%>
				</a>
			</li>
			
			<li class="make-amendments">
				<img src="<%=request.getContextPath()%>/images/submit.png" alt="Make Amendments">
				<a href="javascript:void(0);" onclick="doCreditAction('makeAmendments',this);">
					<%=LabelUtil.getLabel(pageContext, themeDisplay, "cb.row.contextmenu.makeamendments")%>
				</a>
			</li>
		<%} %>
		<%if(SPFinanceLocalServiceUtil.checkRole(request, FinanceConstants.FINANCE_VERIFIER_ROLE)){ %>
			<li class="submit-for-approval">
				<img src="<%=request.getContextPath()%>/images/submit.png" alt="Submit For Approval">
				<a href="javascript:void(0);" onclick="doCreditAction('approval',this);">
				<%=LabelUtil.getLabel(pageContext, themeDisplay, "pa.row.contextmenu.submitforapproval")%></a></li>
		
			<li class="return-a">
				<img src="<%=request.getContextPath()%>/images/return.png" alt="Return for Amendments">
				<a href="javascript:void(0);" onclick="doCreditAction('amendments',this);">
				<%=LabelUtil.getLabel(pageContext, themeDisplay, "pa.row.contextmenu.returnforamendments")%></a></li>
		<%} %>
		<%if(SPFinanceLocalServiceUtil.checkRole(request, FinanceConstants.FINANCE_VERIFIER_ROLE) || 
				SPFinanceLocalServiceUtil.checkRole(request, FinanceConstants.FINANCE_APPROVER_ROLE)){ %>
			<li class="reject" >
				<img src="<%=request.getContextPath()%>/images/invalid-records.png" alt="Reject">
				<a href="javascript:void(0);" onclick="doCreditAction('reject',this);">
				<%=LabelUtil.getLabel(pageContext, themeDisplay, "pa.row.contextmenu.reject")%></a></li>
			
		<%} %>
		<%if(SPFinanceLocalServiceUtil.checkRole(request, FinanceConstants.FINANCE_APPROVER_ROLE)){ %>
			<li class="approve">
				<img src="<%=request.getContextPath()%>/images/submit.png" alt="Approve">
				<a href="javascript:void(0);" onclick="doCreditAction('approve',this);">
				<%=LabelUtil.getLabel(pageContext, themeDisplay, "pa.row.contextmenu.approve")%></a></li>
			<li class="return-to-submitter-a">
				<img src="<%=request.getContextPath()%>/images/return.png" alt="Return to submitter for Amendments">
				<a href="javascript:void(0);" onclick="doCreditAction('returnToSubmitter',this);">
				<%=LabelUtil.getLabel(pageContext, themeDisplay, "pa.row.contextmenu.returntosubmitterforamendments")%></a></li>
			<li class="return-to-verifier-a">
				<img src="<%=request.getContextPath()%>/images/return.png" alt="Return to verifier for Amendments">
				<a href="javascript:void(0);" onclick="doCreditAction('returnToVerifier',this);">
				<%=LabelUtil.getLabel(pageContext, themeDisplay, "pa.row.contextmenu.returntoverifierforamendments")%></a></li>
		<%} %>
	</ul>
	</div>
</div>
<sp-formio:Listing cssClass="formContainer" modelName="${formType}" />
<div style="display: none;" class="alert alert-danger"
							role="showAlert" id="alert_msg"></div>
<div id="MultirowPopActionNew" class="Multi-Pop-Action threedot hide">
	<ul>
	<%if(SPFinanceLocalServiceUtil.checkRole(request, FinanceConstants.FINANCE_SUBMITTER_ROLE)){ %>
			<li id="g-recognise-as-revenue">
				<img src="<%=request.getContextPath()%>/images/submit.png" alt="Recognise As Revenue">
				<a href="javascript:void(0);" onclick="doCreditAction('g-recogniseAsRevenue',this);">
					<%=LabelUtil.getLabel(pageContext, themeDisplay, "cb.row.contextmenu.recogniseasrevenue")%>
				</a>
			</li>
		<%} %>
		<%if(SPFinanceLocalServiceUtil.checkRole(request, FinanceConstants.FINANCE_VERIFIER_ROLE)){ %>
			<li id="g-submit-for-approval">
				<img src="<%=request.getContextPath()%>/images/submit.png" alt="Submit For Approval">
				<a href="javascript:void(0);" onclick="doCreditAction('g-submitForApproval',this);">
				<%=LabelUtil.getLabel(pageContext, themeDisplay, "pa.row.contextmenu.submitforapproval")%></a></li>
		
		<%} %>
		<%if(SPFinanceLocalServiceUtil.checkRole(request, FinanceConstants.FINANCE_VERIFIER_ROLE) ||
				SPFinanceLocalServiceUtil.checkRole(request, FinanceConstants.FINANCE_APPROVER_ROLE)){ %>
			<li id="g-reject" >
				<img src="<%=request.getContextPath()%>/images/invalid-records.png" alt="Reject">
				<a href="javascript:void(0);" onclick="doCreditAction('g-reject',this);">
				<%=LabelUtil.getLabel(pageContext, themeDisplay, "pa.row.contextmenu.reject")%></a></li>
		<%} %>
	
	
		<%if(SPFinanceLocalServiceUtil.checkRole(request, FinanceConstants.FINANCE_APPROVER_ROLE)){ %>
			<li id="g-approve">
				<img src="<%=request.getContextPath()%>/images/submit.png" alt="Approve">
				<a href="javascript:void(0);" onclick="doCreditAction('g-approve',this);">
				<%=LabelUtil.getLabel(pageContext, themeDisplay, "pa.row.contextmenu.approve")%></a></li>
			<li id="g-returnToSubmitter">
				<img src="<%=request.getContextPath()%>/images/return.png" alt="Return to submitter for Amendments">
				<a href="javascript:void(0);" onclick="doCreditAction('g-returnToSubmitter',this);">
				<%=LabelUtil.getLabel(pageContext, themeDisplay, "pa.row.contextmenu.returntosubmitterforamendments")%></a></li>
			<li id="g-returnToVerifier">
				<img src="<%=request.getContextPath()%>/images/return.png" alt="Return to verifier for Amendments">
				<a href="javascript:void(0);" onclick="doCreditAction('g-returnToVerifier',this);">
				<%=LabelUtil.getLabel(pageContext, themeDisplay, "pa.row.contextmenu.returntoverifierforamendments")%></a></li>
		<%} %>
		<li><img src="/html/images/export.png" alt="List Export"><a
														href="javascript:void(0);"
														onclick="globalExportList(event);">Export</a></li>

	</ul>
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
							<br />
							<textarea placeholder="Add your text here..." cols="" rows=""
								id="credit_action_reason"></textarea>
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
	<div class="yui3-skin-sam invoice-action-feedback-dialog">
		<div id="action-feedback-dialog" hidden="true" class="modalpopupBox">
			<div id="action-feedback-dialog-box" class="modalpopupContent">
				<form class="formContainer" action="">
					<aui:row>
						<aui:col span="12">
							<h3><%=LabelUtil.getLabel(pageContext, themeDisplay, "workflow.feedback.title")%></h3>
						</aui:col>
					</aui:row>
					<br />
					<aui:row>
						<aui:col span="12">
							<button type="button" class="btn btn-default popup-ok-action" onclick="moveToList();"
								style="margin: 0 auto; display: block"><%=LabelUtil.getLabel(pageContext, themeDisplay, "workflow.feedback.backbtn")%></button>
						</aui:col>
					</aui:row>
				</form>
			</div>
		</div>
	</div>
	
	<!-- Start Recognise as Revenue Process -->

	<div class="yui3-skin-sam invoice-action-dialog">
		<div id="mass-process-action-dialog" hidden="true" class="modalpopupBox" style="min-width: 100%; left: 0px; top: 250px !important;">
			<div id="mass-process-action-dialog-box" class="modalpopupContent" style="min-width: 100%; padding: 0px;">
				<form class="formContainer" id="globalRecoAsRevform" action="">
					<aui:row>
						<aui:col span="2">
						</aui:col>
						<aui:col span="8">
						<aui:row>
							<label class="control-label"><%=LabelUtil.getLabel(pageContext, themeDisplay, "cb.detail.initiatedby")%></label>
							<aui:col span="5" cssClass="formio-component-textfield">
								<input type="radio" name=initiatedBy value="Candidate / Corporate" checked="checked"><%=LabelUtil.getLabel(pageContext, themeDisplay, "cb.detail.recogniseasrevenue.candidate.corporate")%>
							</aui:col>
							<aui:col span="5" cssClass="formio-component-textfield">
								<input type="radio" name="initiatedBy" value="Internal User"><%=LabelUtil.getLabel(pageContext, themeDisplay, "cb.detail.recogniseasrevenue.internal.user")%>
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
						</aui:col>
						<aui:col span="2">
						</aui:col>
					</aui:row>
					<aui:row>
						<aui:col span="3" >
						</aui:col>
						<aui:col span="3" >
							<button type="button" id="mass-process-popup-submit-action"
								class="btn-primary mass-process-popup-submit-action pull-left" style="float:right;width:220px;margin-left: 50px !important; padding: 8px 12px !important">Submit For Verification</button>
						</aui:col>
						<aui:col span="3" >
							<button type="button" id="mass-process-popup-cancel-action"
								class="btn-default mass-process-popup-cancel-action pull-right" style="float:left;margin-right: 50px !important; padding: 8px 12px !important; margin-top: 20px">Cancel</button>
						</aui:col>
						
						<aui:col span="3" >
						</aui:col>
					</aui:row>
					<br />
				</form>
			</div>
		</div>
	</div>
	<!-- End Recognise as Revenue Process -->
</div>
<script type="text/javascript">
var namespace =  "<portlet:namespace/>";
var ajaxUrl = "${resourceURL}";
var baseUrl = "<%=baseUrl%>";
var creditNotesUrl = "<%=creditNotesUrl%>";
var mode = "list";
var model = "CreditBalance";
var downloadPdfUrl="<%=downloadPdfUrl%>";

var categoryMap = <%=objectMapper.writeValueAsString(categoryMap)%>;
var transactionTypeMap = <%=objectMapper.writeValueAsString(transactionTypeMap)%>;
var clientTypeMap = <%=objectMapper.writeValueAsString(clientTypeMap)%>;
var functionalMap = <%=objectMapper.writeValueAsString(functionalComponentMap)%>;
var productMap = <%=objectMapper.writeValueAsString(productMap)%>;
var productSubtypeMap = <%=objectMapper.writeValueAsString(productSubtypeMap)%>;

var records = [];
var totalPaymentAmount = 0;
var totalAddDeducdAmount = 0;
var totalFinalAmount = 0;

var oldJsFilterColumnList = jsFilterColumnList;
var jsFilterColumnList = function() {
	sortbyArray.push({direction: "desc", field: "IdAndName", contentJSON: "true"});
	sortbyArray.push({direction: "asc", field: "Type", contentJSON: "true"});
	sortbyArray.push({direction: "desc", field: "Date", contentJSON: "true"});
	oldJsFilterColumnList.apply(this, []);
}
var oldReload = reloadTable;
var reloadTable = function(a,isSearchList) {
	console.log("a : ");
	console.log(a);
	oldReload.apply(this, [a,isSearchList]);
	var disableGApprove = true;
	var disableGReturn = true;
	var countNull = 0;
	var countVerification = 0;
	var countApproval = 0;
	var countAmendment = 0;
	for (var c = 0; c < a.length; c++) {
		var as = a[c].contentJson.ApprovalStatus;
		if(typeof as !== "undefined" && as !=null) {
			as = as.toUpperCase();
			countNull = countNull + 1;
		}
		if(as != "PENDING VERIFICATION"){
			countVerification = countVerification + 1;
		}
		if(as != "PENDING APPROVAL"){
			countApproval = countApproval + 1;
		}
		
		if(as != "PENDING AMENDMENT"){
			countAmendment = countAmendment + 1;
		}
		setContextInTBl(a[c],c);
	}
	
	console.log("countNull");
	console.log(countNull);
	console.log("countVerification : " + countVerification);
	console.log("countApproval : " + countApproval);
	
	if(countNull > 0){
		enableElement("g-recognise-as-revenue", false);
	}else{
		enableElement("g-recognise-as-revenue", true);
	}
	
	if(countVerification > 0){
		enableElement("g-submit-for-approval", false);
		enableElement("g-return-a", false);
	}else{
		enableElement("g-submit-for-approval", true);
		enableElement("g-return-a", true);
	}
	
	if(countApproval > 0){
		enableElement("g-approve", false);
		enableElement("g-returnToSubmitter", false);
		enableElement("g-returnToVerifier", false);
	}else{
		enableElement("g-approve", true);
		enableElement("g-returnToSubmitter", true);
		enableElement("g-returnToVerifier", true);
	}
	
	if(countVerification == 0 || countApproval == 0){
		enableElement("g-reject", true);		
	}else {
		enableElement("g-reject", false);
	}
	
	/* if(countAmendment > 0){
		enableElement("g-submit-for-approval", false);
	}else{
		enableElement("g-submit-for-approval", true);
	} */
	records = a;
} 

function setContextInTBl(record, c){
	var newPopover = document.getElementsByClassName("listingPopover")[c];
	var as = record.contentJson.ApprovalStatus;
	var ws = record.contentJson.WorkflowStatus;
	var utilisationPurpose = record.contentJson.UtilisationPurpose;
	console.log("utilisationPurpose : " + utilisationPurpose);
	
	if(typeof as === "undefined" || as == "" ){
		showHideElement(
				newPopover.getElementsByClassName("recognise-as-revenue")[0],
				"block");
		showHideElement(
				newPopover.getElementsByClassName("make-refund")[0],
				"block");
		
		showHideElement(
				newPopover.getElementsByClassName("refund-advice")[0],
				"none");
	}else{
		showHideElement(
				newPopover.getElementsByClassName("recognise-as-revenue")[0],
				"none");
		showHideElement(
				newPopover.getElementsByClassName("make-refund")[0],
				"none");
		as = as.toUpperCase();
		console.log("status : "+utilisationPurpose == "Refund");
		if(utilisationPurpose == "Refund"){
			showHideElement(
					newPopover.getElementsByClassName("refund-advice")[0],
					"block");
		}else{
			showHideElement(
					newPopover.getElementsByClassName("refund-advice")[0],
					"none");
		}
	}
	
	if(as!="PENDING VERIFICATION") {
		showHideElement(
				newPopover.getElementsByClassName("reject")[0],
				"none");
	} else {
		showHideElement(
				newPopover.getElementsByClassName("reject")[0],
				"block");
	}
	
	if(as == "PENDING AMENDMENTS"){
		showHideElement(
				newPopover.getElementsByClassName("make-amendments")[0],
				"block");
	}else{
		showHideElement(
				newPopover.getElementsByClassName("make-amendments")[0],
				"none");
	}
	
	if(as == "PENDING VERIFICATION"){
		showHideElement(
				newPopover.getElementsByClassName("submit-for-approval")[0],
				"block");
		showHideElement(
				newPopover.getElementsByClassName("return-a")[0],
				"block");
	} else {
		showHideElement(
				newPopover.getElementsByClassName("submit-for-approval")[0],
				"none");
		showHideElement(
				newPopover.getElementsByClassName("return-a")[0],
				"none");
	}
	
	if(as == "PENDING APPROVAL"){
		showHideElement(
				newPopover.getElementsByClassName("approve")[0],
				"block");
		showHideElement(
				newPopover.getElementsByClassName("return-to-submitter-a")[0],
				"block");
		showHideElement(
				newPopover.getElementsByClassName("return-to-verifier-a")[0],
				"block");
	} else {
		showHideElement(
				newPopover.getElementsByClassName("approve")[0],
				"none");
		showHideElement(
				newPopover.getElementsByClassName("return-to-submitter-a")[0],
				"none");
		showHideElement(
				newPopover.getElementsByClassName("return-to-verifier-a")[0],
				"none");
	}	
}

function enableElement(id, disable) {
	var ele = getEID(id);
	if (ele) {
		if(!disable){
			var aDiv = ele.getElementsByTagName("a")[0];
			if(aDiv){
				aDiv.style.pointerEvents = "none";
				aDiv.style.opacity = "0.7";
				ele.title = "This option is disabled due to results having mixed status";
			}
		}else {
			var aDiv = ele.getElementsByTagName("a")[0];
			if(aDiv){
				aDiv.style.pointerEvents = "painted";
				aDiv.style.opacity = "1";
				ele.title = "";
			}
		}
	}
}
</script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/billing.js?<%=System.currentTimeMillis()%>" language="javascript1.2""></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/credit-balance.js?<%=System.currentTimeMillis()%>" language="javascript1.2""></script>
<% } %>	