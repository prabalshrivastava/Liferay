<%@page import="com.sambaash.platform.finance.constants.FinanceConstants"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.sambaash.platform.util.SambaashUtil"%>
<%@page import="javax.portlet.PortletRequest"%>
<%@page import="com.sambaash.platform.util.PermissionUtil"%>
<%@page import="com.sambaash.platform.constant.SystemSetupConstants"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%><%@
taglib	uri="http://liferay.com/tld/security" prefix="liferay-security"%><%@
taglib	uri="http://liferay.com/tld/theme" prefix="liferay-theme"%><%@
taglib	uri="http://liferay.com/tld/ui" prefix="liferay-ui"%><%@
taglib	uri="http://liferay.com/tld/util" prefix="liferay-util"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<link rel='stylesheet' type="text/css"
	href='<%=request.getContextPath()%>/css/cashiercounter.css?minifierType=css'></link>
<link rel='stylesheet' href='/html/css/sp/formio.full.min.css?minifierType=css'>
<link rel='stylesheet' href='/html/css/hook.css?minifierType=css'>
<link rel='stylesheet' type="text/css"	href='<%=request.getContextPath()%>/css/main.css?minifierType=css'></link>
<link rel='stylesheet' type="text/css" href='<%=request.getContextPath()%>/css/portlet.css?minifierType=css'></link>
<script type="text/javascript" src="/html/js/sp/hook.js?<%=System.currentTimeMillis()%>" language="javascript1.2""></script>
<%@ taglib	uri="/tld/sp-formio" prefix="sp-formio"%> 
<portlet:defineObjects />
<% 
if(PermissionUtil.canEditModel((PortletRequest) request.getAttribute("javax.portlet.request"))){ %>
<%
ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
long userId = themeDisplay.getUserId();
String baseUrl = portletPreferences.getValue("baseUrlPref", "");
String formId = portletPreferences.getValue(SystemSetupConstants.PREF_HTML_FORM_ID, "2015");
String receiptBaseUrl = portletPreferences.getValue(FinanceConstants.PREF_RECEIPT_BASE_URL, "");
String dashBoardLink = SambaashUtil.getDashBoard();
SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY HH:MM");
String serverCurrDate = sdf.format(new Date());
%>
<div class="newPortlets">	
	<div class="subHeader">
		<div class="container">
			<div class="inner-container">
				<aui:row>
					<aui:col span="10" cssClass="text-center"><h2><span>OPEN/CLOSE COUNTER</span></h2></aui:col>
					<aui:col span="2" cssClass="text-right"><aui:a href="<%= dashBoardLink %>" title="Back to Home">Back to Home</aui:a></aui:col>
				</aui:row>
			</div>
		</div>
	</div>
	<c:set var="formId" value="<%= formId %>"/>
	<c:set var="formType" value='<%= request.getParameter("formTypeName") %>' />
	<c:set var="formStorageId" value='<%= request.getParameter("storageId") %>' />
	<div class="formRoot">
		<div class="innerFormRoot">
			<sp-formio:FormIO cssClass="formContainer formPadding" modelName ="${formType}" 
		formId="${formId}" readOnly="false" formStorageId="${formStorageId}"  />
		</div>
	</div>
	<div class="yui3-skin-sam invoice-action-dialog">
		<div id="action-dialog" hidden="true" class="modalpopupBox">
			<div id="action-dialog-box" class="modalpopupContent">
				<form class="formContainer" action="">
					<aui:row>
						<aui:col span="12" style="text-align:center;">
							<h3 id="action_title">Counter can not be opened!</h4>
						</aui:col>
					</aui:row>
					<aui:row>
						<p id="pmessage" class="no-data-listing-message">
						Since the LOR processing is still in progress, you will not be allowed to access the counter for any transactions.
						Please contact Admin/Supervisor for help.
						</p>
					</aui:row>
					<aui:row>
						<aui:col span="6" cssClass="offset3">
							<span>
								<button type="button" id="popup-cancel-action"
									class="btn-primary popup-cancel-action">OK</button>
							</span>
						</aui:col>
					</aui:row>
				</form>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
var mode = "edit";
var currTime = "<%=serverCurrDate%>";
var userId = "<%=userId%>";
var receiptBaseUrl = "<%=receiptBaseUrl%>";
var formInst;
var baseUrl = "<%=baseUrl%>"
function afterFormDataLoadedFormIOForm(thisInstance){
	document.addEventListener("view-receipts", function(event){
		console.log("view receipts...");
	});
	document.getElementsByClassName("view-receipt-btn")[0].addEventListener("click", function() {
		console.log("view receipts...111 : "+receiptBaseUrl);
		var win = window.open(receiptBaseUrl, '_blank');
		win.focus();
	});
	formInst = thisInstance
	thisInstance.components.Submit.buttonElement.innerText = "CLOSE COUNTER";
	thisInstance.form.submission.data.Mode = "edit";
	thisInstance.components.ClosedAt.element.innerText = currTime;
}

function validateFormIOForm(thisInstance){
	var lorcheck = checkLORProcessing();
	if(lorcheck){
		console.log("if...");
		openLORModal();
	}else{
		console.log("else...");
		thisInstance.form.submission.data.ClosedAt = currTime;
		thisInstance.form.submission.data.CounterStatus = "CLOSED";
		thisInstance.form.submission.data.TellerName =userId;
		thisInstance.customSubmission(thisInstance.form.submission);
	}
}

function afterFormSubmissionFormIOForm(thisInstance) {
	AUI().use('liferay-portlet-url', function(A) {
		var e = Liferay.PortletURL.createRenderURL();
		e.options.basePortletURL = baseUrl;
		e.setParameter("jspPage", "/html/cashiercounter/create.jsp");
		e.setParameter("formTypeName", "CashierCounter");
		e.setPortletId(namespace.replace(/(^\_+|\_+$)/mg, ''));
		e.setWindowState("normal");
		console.log("e : "+e.toString());
		window.location.href = e.toString();
	});
}

function checkLORProcessing(){
	var result = false;
	var data = {};
	data.formType = "cashiercounter";
	ajaxCallAPI(
		'GET',
		"checkLOR",
		data,
		function() {
			var data = this.get("responseData");
			result = data;
		}, function() {
			displayMessage('danger',
					"Error in persisting dynamic form data.", 3000);
		});
	
	return result;
}

function openLORModal(){
	var popupdiv = "#action-dialog";
	var popupdivbox = "#action-dialog-box";
	AUI().use('aui-base', function(A) {
	   A.one(popupdiv).set('hidden', false);
	     YUI().use('aui-modal', function(Y) {
	        var modal = new Y.Modal({
                boundingBox: popupdiv,
                contentBox: popupdivbox,
                headerContent: '',
                centered: true,
                destroyOnHide: false,
                modal: true,
                resizable: false,
                draggable: true,
	         }).render();
	         Y.one('.close').on('click',function() {
	       	       modal.hide();
	       	       modal = null;
	       	      });
	         Y.one('.popup-cancel-action').on('click',function() {
         	        modal.hide();
         	       	modal = null;
         	      });
	     });
	 });
}

function getDateByFormat(d){
	var m = (d.getMonth() + 1);
	var t = d.getDate();
	var y = d.getFullYear();
	var s = t + "/" + m + "/" + y;
	return s;
}
</script>
<% } %>