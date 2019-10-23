<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.sambaash.platform.constant.SambaashConstants"%>
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
<link rel='stylesheet' href='/html/css/hook.css?minifierType=css'>
<link rel='stylesheet' type="text/css"
	href='<%=request.getContextPath()%>/css/main.css?minifierType=css'></link>
<link rel='stylesheet' type="text/css" href='<%=request.getContextPath()%>/css/portlet.css?minifierType=css'></link>
<link rel='stylesheet' href='/html/css/sp/formio.full.min.css?minifierType=css'>
<script type="text/javascript" src="/html/js/sp/hook.js?<%=System.currentTimeMillis()%>" language="javascript1.2"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/main.js" language="javascript1.2"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/billing.js" language="javascript1.2"></script>
<%@ taglib	uri="/tld/sp-formio" prefix="sp-formio"%> 
<portlet:defineObjects />
<portlet:renderURL var="cashierCounterListing">
	<portlet:param name="jspPage"
		value="/html/chashiercounter/list.jsp" />
</portlet:renderURL>
<div class="newPortlets">
<div class="loadingDiv" id="loadingDiv">
		<div class="m-blockui"
			style="position: fixed; z-index: 1031; left: 50%; top: 50%;">
			<span>Please Wait</span> <span>
				<div class="m-loader m-loader--brand"></div>
			</span>
		</div>
	</div>
<% if(PermissionUtil.canAddModel((PortletRequest) request.getAttribute("javax.portlet.request"))){ %>
<%
ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
long userId = themeDisplay.getUserId();
String baseUrl = portletPreferences.getValue("baseUrlPref", "");
String formId = portletPreferences.getValue(SystemSetupConstants.PREF_HTML_FORM_ID, "2015");
String dashBoardLink = SambaashUtil.getDashBoard();
SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY HH:MM");
String serverCurrDate = sdf.format(new Date());
%>
<script type="text/javascript">
var baseCCUrl = "<%=baseUrl%>";
showLoading(true);
var data = {};
var modelName = "CashierCounter";
data.formType = modelName;
ajaxCallAPI(
		'GET',
		"todayRecord",
		data,
		function() {
			data = this.get("responseData");
			console.log(data);
			if(data && data.content) {
				for(cci in data.content) {
					if(data.content[cci].contentJson.CounterStatus == "OPEN") {
						goToEdit(data.content[cci].storageId);
					}
				}
			}
			showLoading(false);
		}, function() {
			displayMessage('danger',
					"Error in persisting dynamic form data.", 3000);
			showLoading(false);
		});

function goToEdit(storageId) {	 
	AUI().use('liferay-portlet-url', function(A) {
		var e =  Liferay.PortletURL.createRenderURL();
		e.options.basePortletURL = baseCCUrl;
		console.log("baseCCUrl : "+baseCCUrl);
		e.setParameter("jspPage", "/html/cashiercounter/edit.jsp");   
		e.setParameter("formTypeName", modelName);
		e.setParameter("storageId", storageId);
		e.setPortletId(namespace.replace(/(^\_+|\_+$)/mg, ''));
		e.setWindowState("normal");
		console.log("path :: " + e.toString());
		window.location.href = e.toString();
	});
}

</script>
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
	<div class="formRoot">
		<div class="innerFormRoot">
	<sp-formio:FormIO cssClass="formContainer formPadding"  modelName ="${formType}" 
		formId="${formId}" readOnly="false" formStorageId="0"  />
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
var mode = "create";
var currTime = "<%=serverCurrDate%>";
var userId = "<%=userId%>";

function validateFormIOForm(thisInstance){
	checkLORProcessing(function(lorcheck) {
		console.log("lorcheck : "+lorcheck);
		if(lorcheck){
			console.log("if...");
			openLORModal();
			thisInstance.form.setAlert("","Faile to open counter");
		}else{
			console.log("else...");
			thisInstance.form.submission.data.OpenedAt = currTime;
			thisInstance.form.submission.data.TellerName = userId;
			thisInstance.customSubmission(thisInstance.form.submission);
		} 
	});
}

function afterFormSubmissionFormIOForm(thisInstance) {
	window.location.reload();
}

function checkLORProcessing(callback){
	var result = false;
	var data = {};
	data.formType = "cashiercounter";
	ajaxCallAPI(
		'GET',
		"checkLOR",
		data,
		function() {
			var data = this.get("responseData");
			callback(data);
		}, function() {
			displayMessage('danger',
					"Error in persisting dynamic form data.", 3000);
			callbac(false);
		});
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

function afterFormLoadedFormIOForm(thisInstance){
	thisInstance.form.submission.data.CashierCounterCode = generateCashierCounterCode();
	thisInstance.components.OpenedAt.element.innerText = currTime;
	thisInstance.components.Deactivate.buttonElement.style.display = "none";
	setInterval(function() {
		checkPCForm(thisInstance);
	}, 1000);
}

function generateCashierCounterCode() {
	var date = new Date();
	var now_utc =  Date.UTC(date.getUTCFullYear(), date.getUTCMonth(), date.getUTCDate(),
			 date.getUTCHours(), date.getUTCMinutes(), date.getUTCSeconds());
	return "CC-"+now_utc;
}
</script>
<% } %>