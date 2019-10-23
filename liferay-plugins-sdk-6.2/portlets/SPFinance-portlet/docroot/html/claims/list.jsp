<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
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
<liferay-theme:defineObjects />
<%@taglib	uri="/tld/sp-formio" prefix="sp-formio"%>
<%@page import="com.sambaash.platform.util.LabelUtil"%>  

<link rel='stylesheet' type="text/css"
	href='<%=request.getContextPath()%>/css/billing.css?minifierType=css'></link>

<link rel='stylesheet' type="text/css"
	href='<%=request.getContextPath()%>/css/claim.css?<%=System.currentTimeMillis()%>'></link>

<style>
#togglerSortColumn {
	float: right
}
#addnew {
	display: none
}
.pd-15 {
    font-weight: 600 !important;
    height: 42px;
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
<% if(PermissionUtil.canViewListing( (PortletRequest) request.getAttribute("javax.portlet.request"))){ 
String modelName = portletPreferences.getValue(SystemSetupConstants.PREF_MODEL_NAME, SystemSetupConstants.DEFAULTMODELAME);
String baseUrl = portletPreferences.getValue("baseUrlPref", "");
Map<Long, String> claimTypeMap = SPFinanceLocalServiceUtil.getSpListTypeIdToDisplayName("finance.payment.claimType", request);
Map<String, String> categoryMap = SPFinanceLocalServiceUtil.getCategoryMap(request);
Map<String, String> transactionTypeMap = SPFinanceLocalServiceUtil.getTransactionTypeMap(request);
Map<String, String> clientTypeMap = SPFinanceLocalServiceUtil.getClientTypeMap(request);
Map<String, String> functionalComponentMap = SPFinanceLocalServiceUtil.getFunctionalComponentMap(request);
Map<String, String> productMap = SPFinanceLocalServiceUtil.getProductTypeMap(request);
Map<String, String> productSubtypeMap = SPFinanceLocalServiceUtil.getProductSubTypeMap(request);
ObjectMapper objectMapper = new ObjectMapper();
objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
boolean[] roles = SPFinanceLocalServiceUtil.checkUserRoles(themeDisplay);
boolean submitter = roles[0];
boolean verifier = roles[1];
boolean approver = roles[2];
%>
<c:set var="formType" value='<%= modelName %>' />
<script>
var modelName =  "<%=modelName%>";
var config = {
		createPage: "/html/claims/create.jsp",
	    editPage: "/html/claims/edit.jsp",
	    detailPage: "/html/claims/view.jsp",
	};
</script>
<!-- context menu -->
<div id="threedot">
	<a href="#" class="threedot addInfo"><img
		src="/html/images/big.png" alt="Details"></a>
	<div id="popoverId" class="Pop-Action listingPopover hide">
	<ul>
		<li class="detail">
			<img src="<%=request.getContextPath()%>/images/detail.png" alt="Details">
			<a href="javascript:void(0);" onclick="doClaimAction('detail',this);">
			<%=LabelUtil.getLabel(pageContext, themeDisplay, "pa.row.contextmenu.details")%></a></li>
		
		<%if(submitter){ %>
			<li class="submit-for-verification">
				<img src="<%=request.getContextPath()%>/images/submit.png" alt="Submit for Verification">
				<a href="javascript:void(0);" onclick="doClaimAction('verification',this);">
					<%=LabelUtil.getLabel(pageContext, themeDisplay, "pa.row.contextmenu.submitforverification")%>
				</a>
			</li>
		<%} %>
		<%if(verifier){ %>
			<li class="submit-for-approval">
				<img src="<%=request.getContextPath()%>/images/submit.png" alt="Submit For Approval">
				<a href="javascript:void(0);" onclick="doClaimAction('approval',this);">
				<%=LabelUtil.getLabel(pageContext, themeDisplay, "pa.row.contextmenu.submitforapproval")%></a></li>
		<%} %>
			<li class="reject" >
				<img src="<%=request.getContextPath()%>/images/invalid-records.png" alt="Reject">
				<a href="javascript:void(0);" onclick="doClaimAction('reject',this);">
				<%=LabelUtil.getLabel(pageContext, themeDisplay, "pa.row.contextmenu.reject")%></a></li>
		<%if(submitter || verifier){ %>
			<li class="return-a">
				<img src="<%=request.getContextPath()%>/images/return.png" alt="Return for Amendments">
				<a href="javascript:void(0);" onclick="doClaimAction('amendments',this);">
				<%=LabelUtil.getLabel(pageContext, themeDisplay, "pa.row.contextmenu.returnforamendments")%></a></li>
		<%} %>
		<%if(approver){ %>
			<li class="approve">
				<img src="<%=request.getContextPath()%>/images/submit.png" alt="Approve">
				<a href="javascript:void(0);" onclick="doClaimAction('approve',this);">
				<%=LabelUtil.getLabel(pageContext, themeDisplay, "pa.row.contextmenu.approve")%></a></li>
			<li class="return-to-submitter-a">
				<img src="<%=request.getContextPath()%>/images/return.png" alt="Return to submitter for Amendments">
				<a href="javascript:void(0);" onclick="doClaimAction('samendments',this);">
				<%=LabelUtil.getLabel(pageContext, themeDisplay, "pa.row.contextmenu.returntosubmitterforamendments")%></a></li>
			<li class="return-to-verifier-a">
				<img src="<%=request.getContextPath()%>/images/return.png" alt="Return to verifier for Amendments">
				<a href="javascript:void(0);" onclick="doClaimAction('vamendments',this);">
				<%=LabelUtil.getLabel(pageContext, themeDisplay, "pa.row.contextmenu.returntoverifierforamendments")%></a></li>
		<%} %>
	</ul>
	</div>
</div>
<sp-formio:Listing cssClass="formContainer" modelName="${formType}" />
<div style="display: none;" class="alert alert-danger"
							role="showAlert" id="alert_msg"></div>
<div id="MultirowPopActionNew" class="Multi-Pop-Action threedot hide">
	<ul >
		<% if (PermissionUtil.canExportModel((PortletRequest) request.getAttribute("javax.portlet.request"))) { %>
		<li ><img src="/html/images/export.png" alt="List Export"><a href="javascript:void(0);" onclick="globalExportList(event);">Export</a></li>
		<% } %>
		<%if(submitter){ %>
			<li style="display: none;" id="g-submit-verification">
				<img src="<%=request.getContextPath()%>/images/submit.png" alt="submit for verification">
				<a href="javascript:void(0);" onclick="doClaimAction('gverification',this);">
					<%=LabelUtil.getLabel(pageContext, themeDisplay, "pa.row.contextmenu.submitforverification")%>
				</a>
			</li >
		<%} %>
		<%if(verifier){ %>
			<li style="display: none;" id="g-submit-approval">
				<img src="<%=request.getContextPath()%>/images/submit.png" alt="Submit for approval">
				<a href="javascript:void(0);" onclick="doClaimAction('gapproval',this);">
				<%=LabelUtil.getLabel(pageContext, themeDisplay, "pa.row.contextmenu.submitforapproval")%></a></li>
		<%} %>
			<li style="display: none;" id="g-reject">
				<img src="<%=request.getContextPath()%>/images/invalid-records.png" alt="Reject">
				<a href="javascript:void(0);" onclick="doClaimAction('greject',this);">
				<%=LabelUtil.getLabel(pageContext, themeDisplay, "pa.row.contextmenu.reject")%></a></li>
		<%if(submitter || verifier){ %>
			<li style="display: none;" id="g-return-a">
				<img src="<%=request.getContextPath()%>/images/return.png" alt="Return for Amendments">
				<a href="javascript:void(0);" onclick="doClaimAction('gamendments',this);">
				<%=LabelUtil.getLabel(pageContext, themeDisplay, "pa.row.contextmenu.returnforamendments")%></a></li>
			<%} %>
		<%if(approver){ %>
			<li style="display: none;" id="g-approve">
				<img src="<%=request.getContextPath()%>/images/submit.png" alt="Approve">
				<a href="javascript:void(0);" onclick="doClaimAction('gapprove',this);">
				<%=LabelUtil.getLabel(pageContext, themeDisplay, "pa.row.contextmenu.approve")%></a></li>
			<li style="display: none;" id="g-return-submitter-a">
				<img src="<%=request.getContextPath()%>/images/return.png" alt="Return to submitter for Amendments">
				<a href="javascript:void(0);" onclick="doClaimAction('gsamendments',this);">
				<%=LabelUtil.getLabel(pageContext, themeDisplay, "pa.row.contextmenu.returntosubmitterforamendments")%></a></li>
			<li style="display: none;" id="g-return-verifier-a">
				<img src="<%=request.getContextPath()%>/images/return.png" alt="Return to verifier for Amendments">
				<a href="javascript:void(0);" onclick="doClaimAction('gvamendments',this);">
				<%=LabelUtil.getLabel(pageContext, themeDisplay, "pa.row.contextmenu.returntoverifierforamendments")%></a></li>
		<%} %>
	</ul>
</div>
<div class="newPortlets">
<div class="yui3-skin-sam invoice-action-dialog">
		<div id="claim-action-dialog-bound" hidden="true" class="modalpopupBox">
			<div id="claim-action-dialog-content" class="modalpopupContent">
				<form class="formContainer" action="">
			      <input type="hidden" id="action-value" value=""/>
					<aui:row>
						<aui:col span="12">
							<h3 id="action_title">Add Remarks</h3>
							<p id="action_msg">Please key in your remarks justifying your comment action</p>
							<br/>
							<textarea placeholder="Add your text here..." cols="" rows="" id="claim_action_reason" oninput="validateRemarks()"></textarea>
						</aui:col>
					</aui:row>
							<div id="error-remarks" style="display: none;">
								 <h5 class="help-block"> 
								Please enter the reason for your action
								</h5> 
							</div>
					<aui:row>
						<aui:col span="12">
							<button type="button" id="popup-submit-action"
								class="btn-primary claim-action-dialog-submit popup-submit-action pull-left"
								style="padding: 8px 12px !important">Submit</button>
							<button type="button" id="popup-cancel-action"
								class="btn-default claim-action-dialog-cancel popup-cancel-action pull-right" onclick="hideDiv()">Cancel</button>
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
							<button type="button" class="btn btn-default process-popup-ok-action" onclick="moveToList();"
								style="margin: 0 auto; display: block"><%=LabelUtil.getLabel(pageContext, themeDisplay, "workflow.feedback.backbtn")%></button>
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
var baseUrl = "<%=baseUrl%>";
var mode = "list";

var claimTypeMap = <%=objectMapper.writeValueAsString(claimTypeMap)%>;
var categoryMap = <%=objectMapper.writeValueAsString(categoryMap)%>;
var transactionTypeMap = <%=objectMapper.writeValueAsString(transactionTypeMap)%>;
var clientTypeMap = <%=objectMapper.writeValueAsString(clientTypeMap)%>;
var functionalMap = <%=objectMapper.writeValueAsString(functionalComponentMap)%>;
var productMap = <%=objectMapper.writeValueAsString(productMap)%>;
var productSubtypeMap = <%=objectMapper.writeValueAsString(productSubtypeMap)%>;

var records = [];
var totalPaymentAmount = 0;
var totalAddDeducdAmount = 0;
var totalFinalAmount = 0
var oldReload = reloadTable;
var reloadTable = function(a,isSearchList) {
	showHideElementById("g-reject", "none");
	showHideElementById("g-return-submitter-a", "none");
	showHideElementById("g-return-verifier-a", "none");
	showHideElementById("g-approve", "none");
	showHideElementById("g-submit-verification", "none");
	showHideElementById("g-submit-approval", "none");
	showHideElementById("g-return-a", "none");
	oldReload.apply(this, [a,isSearchList]);
	var disableGApprove = true;
	var disableGReturn = true;
	totalPaymentAmount = 0;
	totalAddDeducdAmount = 0;
	totalFinalAmount = 0
	for (var c = 0; c < a.length; c++) {
		setTotalRowButtonInTBl(a[c],c);
		totalPaymentAmount = totalPaymentAmount + parseFloat(a[c].contentJson.ClaimVal);
		totalAddDeducdAmount = totalAddDeducdAmount + parseFloat(a[c].contentJson.AddDedAmt);
		totalFinalAmount = totalFinalAmount + parseFloat(a[c].contentJson.FinalAmt);
	}
	var table = document.getElementById("tableId");
	var tbody = document.querySelector("#tableId tbody");
	var f = document.querySelector("#tableId .Row").cloneNode(true);
	var rowclone = f.cloneNode(true);
	rowclone.classList.add("bg-transparent");
	e = rowclone.querySelectorAll("td");
	for(var td=0; td <e.length;td++){
		if(columnsToShow[td] == "ClaimVal"){
			e[td].innerHTML = totalPaymentAmount.toFixed(2);
		}else if(columnsToShow[td] == "AddDedAmt"){
			e[td].innerHTML = totalAddDeducdAmount.toFixed(2);
		}else if(columnsToShow[td] == "FinalAmt"){
			e[td].innerHTML = totalFinalAmount.toFixed(2);
		}else{
			e[td].innerHTML = "";
		}
		e[td].classList.add("pd-15");
	}
	table.appendChild(rowclone);
	
	if (disableGApprove) {
		showHideElementById("gapprove", "none")
	}
	if (disableGReturn) {
		showHideElementById("greturn", "none")
	}
	
	var statusCellNum = 0;
	var claimValNum = 0;
	var addDedNum = 0;
	var finalAmtNum = 0;
	for(var colnum in columnsToShow) {
		if(columnsToShow[colnum]=="ApprovalStatus") {
			statusCellNum = colnum;
		}
		if(columnsToShow[colnum]=="ClaimVal") {
			claimValNum = colnum;
		}
		if(columnsToShow[colnum]=="AddDedAmt") {
			addDedNum = colnum;
		}
		if(columnsToShow[colnum]=="FinalAmt") {
			finalAmtNum = colnum;
		}
	}
	console.log(statusCellNum);
	var table = document.getElementById("tableId");
	for (var i = 0, row; row = table.rows[i]; i++) {
	   //iterate through rows
	   //rows would be accessed using the "row" variable assigned in the for loop
	   var statusCell = row.cells[statusCellNum];
	   console.log(statusCell.innerHTML);
	   statusCell.classList.add("status-col");
	   if(statusCell.innerHTML=="Approved") {
		   statusCell.classList.add("approved");
	   } else if (statusCell.innerHTML=="Rejected") {
		   statusCell.classList.add("rejected");
	   } else if (statusCell.innerHTML=="Pending Submission") {
		   statusCell.classList.add("pending-submission");
	   } else if (statusCell.innerHTML=="Pending Verification") {
		   statusCell.classList.add("pending-verification");
	   } else if (statusCell.innerHTML=="Pending Amendments") {
		   statusCell.classList.add("pending-amendments");
	   } else if (statusCell.innerHTML=="Pending Approval") {
		   statusCell.classList.add("pending-approval");
	   } else {
		   statusCell.classList.remove("status-col");
	   }
	   statusCell.style.margin = "10px";
	   var claimValCell = row.cells[claimValNum];
	   claimValCell.style.cssText = "text-align:right; padding-right:30px !important";
	   if(Number(Number(claimValCell.innerHTML).toFixed(2)).toString() != "NaN"){
		   claimValCell.innerHTML = Number(claimValCell.innerHTML).toFixed(2);
		}
	   
	   var addDedCell = row.cells[addDedNum];
	   addDedCell.style.cssText = "text-align:right; padding-right:30px !important";
	   if(Number(Number(addDedCell.innerHTML).toFixed(2)).toString() != "NaN"){
		   addDedCell.innerHTML = Number(addDedCell.innerHTML).toFixed(2);
		}
	   
	   var finalAmtCell = row.cells[finalAmtNum];
	   finalAmtCell.style.cssText = "text-align:right; padding-right:30px !important";
	   if(Number(Number(finalAmtCell.innerHTML).toFixed(2)).toString() != "NaN"){
		   finalAmtCell.innerHTML = Number(finalAmtCell.innerHTML).toFixed(2);
		}
		
			
	}
	
	records = a;
}

function setTotalRowButtonInTBl(record, c){
	var newPopover = document.getElementsByClassName("listingPopover")[c];
	var as = record.contentJson.ApprovalStatus;
	var ws = record.contentJson.WorkFlowStatus;
	var paymentType = record.contentJson.PaymentType;
	if(typeof as !== "undefined") {
		as = as.toUpperCase();
	}
	if(typeof ws !== "undefined") {
		ws = ws.toUpperCase();
	}
	if(paymentType == "Claim" && as.toLowerCase() != "approved" && as.toLowerCase() != "rejected"){
		showHideElement(
				newPopover.getElementsByClassName("reject")[0],
				"block");
		showHideElementById("g-reject", "block");
	}else{
		showHideElement(
				newPopover.getElementsByClassName("reject")[0],
				"none");
	}
	
	if(ws == "Submitted For Approval".toUpperCase()){
		showHideElement(
				newPopover.getElementsByClassName("approve")[0],
				"block");
		if(paymentType == "Claim"){
			showHideElement(
					newPopover.getElementsByClassName("return-to-submitter-a")[0],
					"block");
			showHideElement(
					newPopover.getElementsByClassName("return-to-verifier-a")[0],
					"block");
			showHideElementById("g-return-submitter-a", "block");
			showHideElementById("g-return-verifier-a", "block");
		}else{
			showHideElement(
					newPopover.getElementsByClassName("return-to-verifier-a")[0],
					"none");
			showHideElement(
					newPopover.getElementsByClassName("return-to-submitter-a")[0],
					"none");
		}
		
		showHideElementById("g-approve", "block");
	} else {
		showHideElement(
				newPopover.getElementsByClassName("approve")[0],
				"none");
		showHideElement(
				newPopover.getElementsByClassName("return-to-verifier-a")[0],
				"none");
		showHideElement(
				newPopover.getElementsByClassName("return-to-submitter-a")[0],
				"none");
		
	}
	
	if(ws == "Pending Submission".toUpperCase()){
		showHideElement(
				newPopover.getElementsByClassName("submit-for-verification")[0],
				"block");
		showHideElementById("g-submit-verification", "block");
	} else {
		showHideElement(
				newPopover.getElementsByClassName("submit-for-verification")[0],
				"none");
		
	}
	
	if(ws == "Submitted For Verification".toUpperCase()){
		showHideElement(
				newPopover.getElementsByClassName("submit-for-approval")[0],
				"block");
		showHideElementById("g-submit-approval", "block");
	} else {
		showHideElement(
				newPopover.getElementsByClassName("submit-for-approval")[0],
				"none");
	}
	
	if((ws == "Pending Submission".toUpperCase() || ws == "Submitted For Verification".toUpperCase()) && paymentType == "Claim"){
		showHideElement(
				newPopover.getElementsByClassName("return-a")[0],
				"block");
		showHideElementById("g-return-a", "block");
	}else{
		showHideElement(
				newPopover.getElementsByClassName("return-a")[0],
				"none");
	}
	
}
</script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/billing.js?<%=System.currentTimeMillis()%>" language="javascript1.2""></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/claims.js?<%=System.currentTimeMillis()%>" language="javascript1.2""></script>
<% } %>	