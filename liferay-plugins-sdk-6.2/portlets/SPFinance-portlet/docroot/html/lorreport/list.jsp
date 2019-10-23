<%@page import="com.sambaash.platform.finance.constants.FinanceConstants"%>
<%@page import="com.sambaash.platform.finance.service.SPFinanceLocalServiceUtil"%>
<%@page import="com.liferay.portal.security.auth.AuthTokenUtil"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.sambaash.platform.util.LabelUtil"%>
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
<link rel='stylesheet' type="text/css"
	href='<%=request.getContextPath()%>/css/billing.css?minifierType=css'></link>
<%@taglib	uri="/tld/sp-formio" prefix="sp-formio"%>  
<style>
#togglerSortColumn {
	float: right
}
#addnew {
	display: none
}
</style>
<portlet:resourceURL var="resourceURL">
	<portlet:param name="sp_p_auth"
		value="<%= AuthTokenUtil.getToken(request) %>" />
</portlet:resourceURL>
<portlet:defineObjects />
<portlet:resourceURL var="downloadPdfUrl">
	<portlet:param name="action" value="downloadPdf" />
</portlet:resourceURL>
<% if(PermissionUtil.canViewListing( (PortletRequest) request.getAttribute("javax.portlet.request"))){ 
String modelName = portletPreferences.getValue(SystemSetupConstants.PREF_MODEL_NAME, SystemSetupConstants.DEFAULTMODELAME);

%>
<c:set var="formType" value='<%= modelName %>' />
<script>
var config = {
	    detailPage: "/html/lorreport/view.jsp"
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
				<a href="javascript:void(0);" onclick="doLorAction('details',this);">
				<%=LabelUtil.getLabel(pageContext, themeDisplay, "workflow.view.details")%>
				</a>
			</li>
			<li class="pdf">
				<img src="<%=request.getContextPath()%>/images/report.png" alt="View" />
				<a href="javascript:void(0);" onclick="doLorAction('pdf',this);">
				<%=LabelUtil.getLabel(pageContext, themeDisplay, "workflow.lorreport.view")%>
				</a>
			</li>
			<li class="ppdf">
				<img src="<%=request.getContextPath()%>/images/report.png" alt="View" />
				<a href="javascript:void(0);" onclick="doLorAction('ppdf',this);">
				<%=LabelUtil.getLabel(pageContext, themeDisplay, "workflow.lorreport.pview")%>
				</a>
			</li>
			<% if(SPFinanceLocalServiceUtil.checkRole(request, FinanceConstants.FINANCE_SUBMITTER_ROLE)) { %>
			<li class="submitv">
				<img src="<%=request.getContextPath()%>/images/submit.png" alt="Submit For Verification" />
				<a href="javascript:void(0);" onclick="doLorAction('submitv',this);">
				<%=LabelUtil.getLabel(pageContext, themeDisplay, "workflow.submit.verification")%>
				</a>
			</li>
			<% } if(SPFinanceLocalServiceUtil.checkRole(request, FinanceConstants.FINANCE_VERIFIER_ROLE)) { %>
			<li class="submita">
				<img src="<%=request.getContextPath()%>/images/submit.png" alt="Submit For Approval" />
				<a href="javascript:void(0);" onclick="doLorAction('submita',this);">
				<%=LabelUtil.getLabel(pageContext, themeDisplay, "workflow.submit.approval")%>
				</a>
			</li>
			<li class="returnv">
				<img src="<%=request.getContextPath()%>/images/return.png" alt="Return" />
				<a href="javascript:void(0);" onclick="doLorAction('return',this);">
				<%=LabelUtil.getLabel(pageContext, themeDisplay, "workflow.return.amendments")%>
				</a>
			</li>
			<% } if(SPFinanceLocalServiceUtil.checkRole(request, FinanceConstants.FINANCE_APPROVER_ROLE)) { %>
			<li class="approve">
				<img src="<%=request.getContextPath()%>/images/submit.png" alt="Approve" />
				<a href="javascript:void(0);" onclick="doLorAction('approve',this);">
				<%=LabelUtil.getLabel(pageContext, themeDisplay, "workflow.approve")%>
				</a>
			</li>
			<li class="returna">
				<img src="<%=request.getContextPath()%>/images/return.png" alt="Return" />
				<a href="javascript:void(0);" onclick="doLorAction('return',this);">
				<%=LabelUtil.getLabel(pageContext, themeDisplay, "workflow.return.amendments")%>
				</a>
			</li>
			<% } %>
		</ul>
	</div>
</div>
<sp-formio:Listing cssClass="formContainer" modelName="${formType}" />
<div id="MultirowPopActionNew" class="Multi-Pop-Action threedot hide">
	<ul>
		<% if(SPFinanceLocalServiceUtil.checkRole(request, FinanceConstants.FINANCE_SUBMITTER_ROLE)) { %>
			<li id="gsubmitv">
				<img src="<%=request.getContextPath()%>/images/submit.png" alt="Submit For Verification" />
				<a href="javascript:void(0);" onclick="doLorAction('submitv', null, true);">
				<%=LabelUtil.getLabel(pageContext, themeDisplay, "workflow.submit.verification")%>
				</a>
			</li>
		<% } if(SPFinanceLocalServiceUtil.checkRole(request, FinanceConstants.FINANCE_VERIFIER_ROLE)) { %>
			<li id="gsubmita">
				<img src="<%=request.getContextPath()%>/images/submit.png" alt="Submit For Approval" />
				<a href="javascript:void(0);" onclick="doLorAction('submita', null, true);">
				<%=LabelUtil.getLabel(pageContext, themeDisplay, "workflow.submit.approval")%>
				</a>
			</li>
			<li id="greturnv">
				<img src="<%=request.getContextPath()%>/images/return.png" alt="Return" />
				<a href="javascript:void(0);" onclick="doLorAction('return', null, true);">
				<%=LabelUtil.getLabel(pageContext, themeDisplay, "workflow.return.amendments")%>
				</a>
			</li>
		<% } if(SPFinanceLocalServiceUtil.checkRole(request, FinanceConstants.FINANCE_APPROVER_ROLE)) { %>
			<li id="gapprove">
				<img src="<%=request.getContextPath()%>/images/submit.png" alt="Approve" />
				<a href="javascript:void(0);" onclick="doLorAction('approve', null, true);">
				<%=LabelUtil.getLabel(pageContext, themeDisplay, "workflow.approve")%>
				</a>
			</li>
			<li id="greturna">
				<img src="<%=request.getContextPath()%>/images/return.png" alt="Return" />
				<a href="javascript:void(0);" onclick="doLorAction('return', null, true);">
				<%=LabelUtil.getLabel(pageContext, themeDisplay, "workflow.return.amendments")%>
				</a>
			</li>
		<% } %>
	</ul>
</div>
<div class="newPortlets">
<div class="yui3-skin-sam invoice-action-dialog">
		<div id="lor-action-dialog-bound" hidden="true" class="modalpopupBox">
			<div id="lor-action-dialog-content" class="modalpopupContent">
				<form class="formContainer" action="">
					<aui:row>
						<aui:col span="12">
							<h3 id="action_title">Submit for Approval ?</h3>
							<p id="action_msg">Please key in your reasons below and
								confirm your action.</p>
							<br />
							<textarea placeholder="Enter Reasons..." cols="" rows=""
								id="lor_action_reason"></textarea>
						</aui:col>
					</aui:row>
					<aui:row>
						<aui:col span="12">
							<button type="button" id="popup-submit-action"
								class="btn-primary lor-action-dialog-submit popup-submit-action pull-left"
								style="padding: 8px 12px !important">
								<%=LabelUtil.getLabel(pageContext, themeDisplay, "label.submit")%>	
							</button>
							<button type="button" id="popup-cancel-action"
								class="btn-default lor-action-dialog-cancel popup-cancel-action pull-right">
								<%=LabelUtil.getLabel(pageContext, themeDisplay, "label.cancel")%>	
							</button>
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
							<button type="button" class="btn btn-default" onclick="moveToList();"
								style="margin: 0 auto; display: block"><%=LabelUtil.getLabel(pageContext, themeDisplay, "workflow.feedback.backbtn")%></button>
						</aui:col>
					</aui:row>
				</form>
			</div>
		</div>
	</div>
</div>
<script>
var mode = "list";
var formStorageId = "";
var ajaxUrl = "${resourceURL}";
var records = [];
var downloadPdfUrl="<%=downloadPdfUrl%>";
if(document.readyState == 'complete') {
	init();
} else {
	window.addEventListener('load', init);
}
function init() {
	console.log("abc....");
	document.getElementById("MultirowPopAction").innerHTML = document.getElementById("MultirowPopActionNew").innerHTML;
}
var oldReload = reloadTable;
var reloadTable = function(a,isSearchList) {
	console.log('a');
	console.log(a);
	oldReload.apply(this, [a,isSearchList]);
	var disableGApprove = true;
	var disableGReturnv = true;
	var disableGReturna = true;
	var disableGSubmitv = true;
	var disableGSubmita = true;
	for (var c = 0; c < a.length; c++) {
		var as = a[c].contentJson.ApprovalStatus;
		var ws = a[c].contentJson.WorkflowStatus;
		if(typeof as !== "undefined") {
			as = as.toUpperCase();
		}
		if(typeof ws !== "undefined") {
			ws = ws.toUpperCase();
		}
		var newPopover = document.getElementsByClassName("listingPopover")[c];
		console.log("newPopover : "+newPopover.innerHTML);
		console.log("as : "+as);
		console.log("ws : "+ws);
		if(newPopover.getElementsByClassName("submitv")[0]) {
			if(ws == "PENDING") {
				disableGSubmitv = false;
				newPopover.getElementsByClassName("submitv")[0].style.display = "block";
			} else {
				newPopover.getElementsByClassName("submitv")[0].style.display = "none";
			}
		}
		if(newPopover.getElementsByClassName("submita")[0]) {
			if(ws == "SUBMITTED FOR VERIFICATION") {
				disableGSubmita = false;
				newPopover.getElementsByClassName("submita")[0].style.display = "block";
			} else {
				newPopover.getElementsByClassName("submita")[0].style.display = "none";
			}
		}
		if(newPopover.getElementsByClassName("returnv")[0]) {
			if(ws == "SUBMITTED FOR VERIFICATION") {
				disableGReturnv = false;
				newPopover.getElementsByClassName("returnv")[0].style.display = "block";
			} else {
				newPopover.getElementsByClassName("returnv")[0].style.display = "none";
			}
		}
		if(newPopover.getElementsByClassName("returna")[0]) {
			if(ws == "SUBMITTED FOR APPROVAL") {
				disableGReturna = false;
				newPopover.getElementsByClassName("returna")[0].style.display = "block";
			} else {
				newPopover.getElementsByClassName("returna")[0].style.display = "none";
			}
		}
		if(newPopover.getElementsByClassName("approve")[0]) {
			if(ws == "SUBMITTED FOR APPROVAL") {
				disableGApprove = false;
				newPopover.getElementsByClassName("approve")[0].style.display = "block";
			} else {
				newPopover.getElementsByClassName("approve")[0].style.display = "none";
			}
		}
		if(newPopover.getElementsByClassName("returnv")[0] && 
				newPopover.getElementsByClassName("returnv")[0].style.display=="block"
				&& newPopover.getElementsByClassName("returna")[0]) {
			newPopover.getElementsByClassName("returna")[0].style.display="none";
		}
	}
	console.log("disableGSubmitv : "+disableGSubmitv);
	console.log("disableGSubmita : "+disableGSubmita);
	console.log("disableGApprove : "+disableGApprove);
	console.log("disableGReturnv : "+disableGReturnv);
	console.log("disableGReturna : "+disableGReturna);
	if (disableGSubmitv) {
		showHideElementById("gsubmitv", "none");
	}
	if (disableGSubmita) {
		showHideElementById("gsubmita", "none");
	}
	if (disableGApprove) {
		showHideElementById("gapprove", "none");
	}
	if (disableGReturnv) {
		showHideElementById("greturnv", "none");
	}
	if (disableGReturna) {
		showHideElementById("greturna", "none");
	}
	if(document.getElementById("greturnv") && document.getElementById("greturna") && 
			document.getElementById("greturnv").style.display=="block") {
		document.getElementById("greturna").style.display = "none";
	}
	records = a;
}
</script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/billing.js?<%=System.currentTimeMillis()%>" language="javascript1.2""></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/lorreport.js?<%=System.currentTimeMillis()%>" language="javascript1.2""></script>
<% } %>	