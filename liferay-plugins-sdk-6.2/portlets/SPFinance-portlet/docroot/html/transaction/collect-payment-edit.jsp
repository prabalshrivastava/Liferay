<%@page import="com.sambaash.platform.finance.constants.FinanceConstants"%>
<%@page import="com.fasterxml.jackson.databind.SerializationFeature"%>
<%@page import="com.fasterxml.jackson.databind.ObjectMapper"%>
<%@page import="java.util.Map"%>
<%@page
	import="com.sambaash.platform.finance.service.SPFinanceLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.sambaash.platform.constant.SambaashConstants"%>
<%@page import="com.sambaash.platform.util.SambaashUtil"%>
<%@page import="javax.portlet.PortletRequest"%>
<%@page import="com.sambaash.platform.util.PermissionUtil"%>
<%@page import="com.sambaash.platform.constant.SystemSetupConstants"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%><%@
taglib
	uri="http://liferay.com/tld/security" prefix="liferay-security"%><%@
taglib
	uri="http://liferay.com/tld/theme" prefix="liferay-theme"%><%@
taglib
	uri="http://liferay.com/tld/ui" prefix="liferay-ui"%><%@
taglib
	uri="http://liferay.com/tld/util" prefix="liferay-util"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link rel='stylesheet' type="text/css"
	href='<%=request.getContextPath()%>/css/collect-payment.css?minifierType=css'></link>
<link rel='stylesheet' type="text/css"
	href='<%=request.getContextPath()%>/css/invoicing.css?minifierType=css'></link>
<link rel='stylesheet' href='/html/css/hook.css?minifierType=css'>
<link rel='stylesheet' type="text/css"
	href='<%=request.getContextPath()%>/css/main.css?minifierType=css'></link>
<link rel='stylesheet' type="text/css"
	href='<%=request.getContextPath()%>/css/portlet.css?minifierType=css'></link>
<link rel='stylesheet' type="text/css"
	href='<%=request.getContextPath()%>/css/billing.css?minifierType=css'></link>
<link rel='stylesheet' type="text/css"
	href='<%=request.getContextPath()%>/css/payment.css?minifierType=css'></link>
<link rel='stylesheet'
	href='/html/css/sp/formio.full.min.css?minifierType=css'>
<%@ taglib uri="/tld/sp-formio" prefix="sp-formio"%>
<portlet:defineObjects />
<portlet:resourceURL var="downloadPdfUrl">
	<portlet:param name="action" value="downloadPdf" />
</portlet:resourceURL>
<div class="newPortlets">
	<%
		if (PermissionUtil.canAddModel((PortletRequest) request.getAttribute("javax.portlet.request"))) {
	%>
	<%
		String formStorageId = request.getParameter("storageId");
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		long userId = themeDisplay.getUserId();
		String formId = "2021";
		String dashBoardLink = SambaashUtil.getDashBoard();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY HH:MM");
		String serverCurrDate = sdf.format(new Date());
		Map<String, String> categoryMap = SPFinanceLocalServiceUtil.getCategoryMap(request);
		Map<String, String> sourceTypeMap = SPFinanceLocalServiceUtil
				.getSpListTypeMap("finance.transaction.sourcetype", request);
		Map<Long, String> clientTypeIdToNameMap = SPFinanceLocalServiceUtil
				.getSpListTypeIdToDisplayName("finance.accountingtable.clienttype", request);
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		String modelName = portletPreferences.getValue(SystemSetupConstants.PREF_MODEL_NAME,
					"TransactionMaster");
		Map<String, String> transactionTypeMap = SPFinanceLocalServiceUtil.getTransactionTypeMap(request);
		String categoryType = portletPreferences.getValue(FinanceConstants.PREF_CATEGORY_TYPE, "IN");
		Map<String, String> clientTypeMap = SPFinanceLocalServiceUtil.getClientTypeMap(request);
		Map<String, String> functionalComponentMap = SPFinanceLocalServiceUtil.getFunctionalComponentMap(request);
		Map<String, String> functionalComponentDisplayMap = SPFinanceLocalServiceUtil.getFunctionalComponentDisplayMap(request);
		Map<String, String> productMap = SPFinanceLocalServiceUtil.getProductTypeMap(request);
		Map<String, String> productSubtypeMap = SPFinanceLocalServiceUtil.getProductSubTypeMap(request);
	%>
	<style>
#formio {
	padding: 35px 55px 35px 55px !important;
}

#alert_msg_id {
	display: none;
}

table {
	margin-left: 0px !important;
	margin-right: 0px !important;
	width: 100% !important;
}

.formPadding {
	background: #f7f9fc !important;
}
</style>
<div class="newPortlets">
	<div class="subHeader">
		<div class="container">
			<div class="inner-container">
			<aui:row>
				<aui:col span="10" cssClass="text-center">
					<h2><span>RECEIPTS</span></h2>
				</aui:col>
				<aui:col span="2" cssClass="text-right">
					<aui:a href="<%=dashBoardLink%>" title="Back to Home">Back to Home</aui:a>
				</aui:col>
			</aui:row>
			</div>
		</div>
	</div>
	<div style="display: none;" class="alert alert-danger"
										role="showAlert" id="alert_msg">Select Facility Type.</div>
	<c:set var="formId" value="<%=formId%>" />
	<c:set var="formType"
		value='<%=request.getParameter("formTypeName")%>' />
		<div class="formRoot">
		<div class="innerFormRoot">
	<sp-formio:FormIO cssClass="formContainer formPadding"
		modelName="${formType}" formId="${formId}" readOnly="false"
		formStorageId="0" />
		</div>
	</div>
	
	<div id="threedot">
		<a href="#" class="threedot addInfo"><img
			src="/html/images/big.png" alt="Details"></a>
		<div id="popoverId" class="Pop-Action listingPopover hide">
			<ul>
				<!-- <li class="view"><a href="javascript:void(0);"
					onclick="viewDetails();">VIEW DETAILS</a></li> -->
			</ul>
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
	<div class="yui3-skin-sam receipt-feedback-dialog">
		<div id="receipt-feedback-popup" hidden="true" class="modalpopupBox">
			<div id="receipt-feedback-popup-box" class="modalpopupContent">
				<form class="formContainer" action="">
					<aui:row>
						<aui:col span="12">
							<h3 id="success-msg">Receipt processed Successfully!</h3>
							<p id="action_msg">You may either open & view the Receipt as
								a PDF in a new tab by clicking on the link below.</p>
						</aui:col>
					</aui:row>
					<aui:row>
						<div
							style="text-align: center; margin-top: 10px; font-weight: 500;">
							<a href="javascript:void(0);" onclick="exportReceipt()">VIEW
								RECEIPT (.PDF)</a>
						</div>
					</aui:row>
					<aui:row>
						<aui:col span="2">
						</aui:col>
						<aui:col span="8">
							<button type="button" class="btn-primary popup-backtolist-button"
								id="backToListBtn">BACK TO LIST OF RECEIPTS</button>
						</aui:col>
						<aui:col span="2">
						</aui:col>
					</aui:row>
				</form>
			</div>
		</div>
	</div>
</div>
</div>
<script type="text/javascript">
var mode = "edit";
var formStorageId = "<%=formStorageId%>";
var modelName = "<%=modelName%>";
var formInstance;
var notes = "";
var tableHead;
var tableRef;
var threedot = document.getElementById("threedot");
var receipt;
var clientTypeIdToNameMap = <%=objectMapper.writeValueAsString(clientTypeIdToNameMap)%>;
var categoryMap = <%=objectMapper.writeValueAsString(categoryMap)%>;
var transactionTypeMap = <%=objectMapper.writeValueAsString(transactionTypeMap)%>;
var clientTypeMap = <%=objectMapper.writeValueAsString(clientTypeMap)%>;
var functionalMap = <%=objectMapper.writeValueAsString(functionalComponentMap)%>;
var functionalDispMap = <%=objectMapper.writeValueAsString(functionalComponentDisplayMap)%>;
var productMap = <%=objectMapper.writeValueAsString(productMap)%>;
var productSubtypeMap = <%=objectMapper.writeValueAsString(productSubtypeMap)%>;
var categoryType = "<%=categoryType%>";
var downloadPdfUrl="<%=downloadPdfUrl%>";
var sourceTypeMap = <%=objectMapper.writeValueAsString(sourceTypeMap)%>;
function afterFormLoadedFormIOForm(thisInstance) {
	formInstance = thisInstance;
	formInstance.components.mode.setValue("edit");
	thisInstance.components.SaveDraft.buttonElement.style.display = "none";
	getByStorageId(formStorageId, modelName, false, function(data) {
		console.log(data);
		receipt = data.contentJson;
		notes = (typeof data.contentJson.Notes === "undefined") ? "" : data.contentJson.Notes;
		formInstance.components.notes.setValue(notes);
		if(clientTypeIdToNameMap[data.contentJson.Type]=="Individual") {
			formInstance.components.source.setValue("CANDIDATE");
		} else {
			formInstance.components.source.setValue("CORPORATE");
		}
		formInstance.components.source.disabled = true;
		
		createTableHeader();
		tableHead = document.getElementsByClassName("candidateTable")[0].getElementsByTagName('thead')[0];
		tableRef = document.getElementsByClassName("candidateTable")[0].getElementsByTagName('tbody')[0];
		setInterval(function() {
			checkCPForm(thisInstance);
		}, 1);
		var obj = {};
		obj.clientType = formInstance.components.source.value;
		obj.receiptId = data.storageId;
		getTransactionInfo(obj, formInstance.components.source.value);
		document.getElementsByClassName("save-note-button")[0].addEventListener("click",function() {
			updateReceipt();
		});
	});
}

function updateReceipt() {
	showLoading(true);
	receipt.formStorageId = formStorageId;
	receipt.formType = modelName;
	receipt.Notes = formInstance.components.notes.value;
	receipt.Overpayment = false;
	console.log(JSON.stringify(receipt));
	ajaxCallAPI('POST', 'persist', receipt, function() {
		let data = this.get("responseData");
		if (data.error) {
			displayMessage('danger', data.error, 3000);
		} else if (Object.keys(data).length === 0) {
			console.log("data : "+data);
			displayMessage('danger', 'Form submission failed.', 3000);
		} else {
			console.log(data.toString());
			var message = "Form successfully submitted.";
			var boundingBox = "#receipt-feedback-popup";
			var contentBox = "#receipt-feedback-popup-box";
			AUI().use('aui-base', function(A) {
				A.one(boundingBox).set('hidden', false);
				YUI().use('aui-modal', function(Y) {
					var modal = new Y.Modal({
						boundingBox : boundingBox,
						contentBox : contentBox,
						headerContent : '',
						centered : true,
						destroyOnHide : false,
						modal : true,
						resizable : false,
						draggable : false,
					}).render();
					Y.one('.close').hide();
					Y.one('.popup-backtolist-button').on('click', function() {
						modal.hide();
						window.location = window.location.href.split("?")[0];
					});
				});

			});
		}
		showLoading(false);
	}, function() {
		displayMessage('danger', "Error in persisting dynamic form data.", 3000);
		showLoading(false);
	});
	
}

function getTransactionInfo(obj, type) {
	var data = {};
	data.formType = 'TransactionMaster';
	data.ModelName = 'TransactionMaster';
	obj.categoryMap = JSON.stringify(categoryMap);
	data = obj;
	var response = [];
	
	ajaxCallAPI('POST', 'fetchReceiptInfo', data, function() {
		var list = this.get("responseData");
		console.log("list : " + JSON.stringify(list));
		setDataInTable(list);
	}, function() {
		setDataInTable([]);
	});
}

function createTableHeader() {
	var coporateTitle = [ 'ID No.', 'Name', 'Invoice Number',
			'Description', 'Invoice Due Date', 'Total Fee(Excl GST)', "" ];
	var candidateTitle = [ 'ID No.', 'Name', 'Programme', 'Subject',
			'Schedule', 'Total Fee(Excl GST)', "" ];
	table = document.querySelector('#tableId');
	var header = table.createTHead();
	var rowOne = header.insertRow(0);
	var rowTwo = header.insertRow(1);
	for (var i = 0; i < 7; i++) {
		var headerCell = document.createElement("TH");
		headerCell.innerHTML = coporateTitle[i];
		if (i == 5) {
			headerCell.style.textAlign = "right";
		}
		rowOne.appendChild(headerCell);
		headerCell = document.createElement("TH");
		headerCell.innerHTML = candidateTitle[i];
		if (i == 5) {
			headerCell.style.textAlign = "right";
		}
		rowTwo.appendChild(headerCell);
	}
	table.createTBody();
}

function rmvRow() {
	var rows = tableRef.rows;
	var len = rows.length;
	for (var i = len - 1; i >= 0; i--) {
		tableRef.deleteRow(i);
	}
	var source = formInstance.form.submission.data.source;
	if (source == "CORPORATE") {
		tableHead.rows[1].style.display = 'none';
		tableHead.rows[0].style.display = '';
	} else {
		tableHead.rows[0].style.display = 'none';
		tableHead.rows[1].style.display = '';
	}
}

function checkCPForm(thisInstance) {
	if (checkIsValide(thisInstance)) {
		thisInstance.components.save.disabled = false;
	} else {
		thisInstance.components.save.disabled = true;
	}
}

function checkIsValide(thisInstance) {
	var eValid = true;
	if(formInstance.components.notes.value==notes) {
		return false;
	}
	return eValid;
}

function setDataInTable(datas) {
	rmvRow();
	if (datas == null || datas.length == 0) {
		formInstance.components.noRecordInstance.element.style.display = "";
	} else {
		formInstance.components.noRecordInstance.element.style.display = "none";
		for (var i = 0; i < datas.length; i++) {
			addRow(datas[i], tableRef);
		}
	}
	showLoading(false);
	formInstance.components.searchValueCorporate.disabled = true;
	formInstance.components.searchValue.disabled = true;
}

function addRow(data, tableRef) {
	var dataContentJson = JSON.parse(data.contentJson);
	var newRow = tableRef.insertRow(tableRef.rows.length);
	// Insert a cell in the row at index 0
	
	var id = (typeof data.name === "undefined") ? "" : data.id;
	var newCell = newRow.insertCell(0);
	newCell.appendChild(document.createTextNode(id));

	var name = (typeof data.name === "undefined") ? "" : data.name;
	if(id=="0"){
		name = "Anonymous";
	}
	newCell = newRow.insertCell(1);
	newCell.appendChild(document.createTextNode(name));
	
	var selectedUser = {};
	var source = formInstance.form.submission.data.source;
	if (source == "CORPORATE") {
		selectedUser.organizationId = id;
		selectedUser.name = name;
		newCell = newRow.insertCell(2);
		newCell.appendChild(document.createTextNode(dataContentJson.ExtRefNumber));

		newCell = newRow.insertCell(3);
		newCell.appendChild(document.createTextNode(dataContentJson.Description));

		newCell = newRow.insertCell(4);
		var schedule = "";
		newCell.appendChild(document.createTextNode(dataContentJson.DueDate));
		var curr = formInstance.components.searchValueCorporate.value;
		if((typeof curr) === "string") {
			curr = [];
		}
		curr.push(selectedUser);
		formInstance.components.searchValueCorporate.setValue(curr);
	} else {
		selectedUser.UserId = id;
		selectedUser.FullName = name;
		newCell = newRow.insertCell(2);
		var programme = getValue(dataContentJson.Title) + " "
				+ getValue(dataContentJson.Description);
		newCell.appendChild(document.createTextNode(programme));

		newCell = newRow.insertCell(3);
		console.log(data);
		console.log(data.contentJson);
		var details = dataContentJson.TransactionDetails;
		var subject = "";
		for ( var dind in details) {
			subject = subject + getValue(details[dind].title) + " "
					+ getValue(details[dind].description) + "<br>";
		}
		subject = subject.substring(0, subject.length - 5);
		var ptag = document.createElement("p");
		ptag.innerHTML = "<p>"+subject+"</p>";
		newCell.appendChild(ptag);

		newCell = newRow.insertCell(4);
		var schedule = "";
		newCell.appendChild(document
				.createTextNode((typeof schedule === "undefined") ? ""
						: schedule));
		var curr = formInstance.components.searchValue.value;
		if((typeof curr) === "string") {
			curr = [];
		}
		console.log(curr);
		console.log((typeof curr));
		curr.push(selectedUser);
		formInstance.components.searchValue.setValue(curr);
	}
	
	newCell = newRow.insertCell(5);
	newCell.appendChild(document.createTextNode(parseFloat(data.totalFee)
			.toFixed(2)));
	newCell.style.textAlign = "right";
	
	newCell = newRow.insertCell(6);
	newCell.appendChild(threedot.cloneNode(true));
	YUI().use("node", "event", function(A) {
		var j = A.all(".threedot");
		j.on("click", function(o) {
			o.preventDefault();
			o.stopPropagation();
			var p = document.getElementsByClassName("Pop-Action");
			for (var l = 0; l < p.length; l++) {
				p[l].classList.add("hide")
			}
			var m = o.currentTarget;
			var n = m.next();
			n.removeClass("hide")
		})
	});
	
}

function getValue(val) {
	if (typeof val === "undefined") {
		return "";
	} else {
		return val;
	}
}

function exportReceipt() {
	exportPdf(formStorageId, null);
}

</script>
<script type="text/javascript"
	src="/html/js/sp/hook.js?<%=System.currentTimeMillis()%>"
	language="javascript1.2"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/billing.js?<%=System.currentTimeMillis()%>" language="javascript1.2"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/invoice-actions.js?<%=System.currentTimeMillis()%>"
	language="javascript1.2"></script>
<% } %>

