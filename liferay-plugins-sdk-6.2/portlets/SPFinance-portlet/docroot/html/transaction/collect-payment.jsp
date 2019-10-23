<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.liferay.compat.portal.kernel.util.HttpUtil"%>
<%@page import="com.sambaash.platform.srv.spservices.service.SPParameterLocalServiceUtil"%>
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
<link rel='stylesheet'
	href='/html/css/sp/formio.full.min.css?minifierType=css'>
<script type="text/javascript"
	src="/html/js/sp/hook.js?<%=System.currentTimeMillis()%>"
	language="javascript1.2"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/billing.js?<%=System.currentTimeMillis()%>"
	language="javascript1.2"></script>
<%@ taglib uri="/tld/sp-formio" prefix="sp-formio"%>
<portlet:defineObjects />
<jsp:include page="payment-section.jsp" />
<div class="newPortlets">
	<%
		if (PermissionUtil.canAddModel((PortletRequest) request.getAttribute("javax.portlet.request"))) {
	%>
	<%
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			long userId = themeDisplay.getUserId();
			String formId = "2021";
			String dashBoardLink = SambaashUtil.getDashBoard();
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY HH:MM");
			String serverCurrDate = sdf.format(new Date());
			Map<String, String> categoryMap = SPFinanceLocalServiceUtil.getCategoryMap(request);
			Map<String, String> sourceTypeMap = SPFinanceLocalServiceUtil
					.getSpListTypeMap("finance.transaction.sourcetype", request);
			ObjectMapper objectMapper = new ObjectMapper();
			objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
			HttpServletRequest rq = PortalUtil.getHttpServletRequest(renderRequest);
			String receiptFor = PortalUtil.getOriginalServletRequest(rq).getParameter("receiptFor");
			String candidateId = PortalUtil.getOriginalServletRequest(rq).getParameter("userId");
			String candidateName = PortalUtil.getOriginalServletRequest(rq).getParameter("userName");
			String candidateNumber = PortalUtil.getOriginalServletRequest(rq).getParameter("idNumber");
			String showPending = portletPreferences.getValue("showPendingPref", "");
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
	<div class="yui3-skin-sam payment-action-dialog">
		<div id="action-dialog" hidden="true" class="modalpopupBox">
			<div id="action-dialog-box"
				class="modalpopupContent corporate-dialog"
				style="padding-bottom: 1px;">
				<form class="formContainer">
					<aui:row>
						<aui:col span="12" style="text-align:center;">
							<h5 id="action_title" class="corporate-dialog-heading">PENDING
								TRANSACTIONS</h5>
						</aui:col>
					</aui:row>
					<aui:row>
						<input type="text" id="myInput" onkeyup="searchInvoices()"
							placeholder="Search for Invoices" title="Search for Invoices">
					</aui:row>
					<aui:row>
						<aui:col span="12" style="overflow-y: auto;max-height: 200px;">
							<aui:row>
								<aui:col span="12" cssClass="formio-component-checkbox"
									style="min-height: 10px;height: 25px;">
									<label class=""> <input type="checkbox"
										name="enrollment" class="form-control" id="enrollment"
										onchange=""> <span class="headingSpan">ENROLLMENT
											INVOICES</span>
									</label>
								</aui:col>
							</aui:row>
							<aui:row>
								<aui:col span="12" cssClass="formio-component-checkbox">
									<div id="enrollmentDiv"></div>
								</aui:col>
							</aui:row>
							<aui:row>
								<aui:col span="12" cssClass="formio-component-checkbox"
									style="min-height: 10px;height: 25px;">
									<label class=""> <input type="checkbox"
										name="miscellaneous" class="form-control" id="miscellaneous"
										onchange=""> <span class="headingSpan">MISCELLANEOUS
											INVOICES</span>
									</label>
								</aui:col>
							</aui:row>
							<aui:row>
								<aui:col span="12" cssClass="formio-component-checkbox">
									<div id="miscellaneousDiv"></div>
								</aui:col>
							</aui:row>
						</aui:col>
					</aui:row>
					<aui:row cssClass="corporate-dialog-buttons">
						<aui:col span="6">
							<button type="button" id="popup-submit-action"
								class="btn-primary btn btn-sm popup-submit-action">PROCEED</button>
						</aui:col>
						<aui:col span="6">
							<button type="button" id="popup-cancel-action"
								class="btn-default btn btn-sm popup-cancel-action">Cancel</button>
						</aui:col>
					</aui:row>
				</form>
			</div>
		</div>
	</div>
</div>


<script type="text/javascript">
	var candidateId = "<%=candidateId%>";
	var candidateNumber = "<%=candidateNumber%>";
	var candidateName = "<%=candidateName%>";
	var receiptFor = "<%=receiptFor%>";
	var showPending = "<%=showPending%>";
	var threedot = document.getElementById("threedot");
	var sourceTypeMap =
<%=objectMapper.writeValueAsString(sourceTypeMap)%>
	;
	var formInstance;
	var select;
	var mode = "view";
	var table;
	var tableHead;
	var tableRef;
	var pendingTrncMap = {};
	var enrollList = [];
	var miscList = [];
	var output = {};
	var invoiceList = [];
	var selectedInvoiceList = [];
	output.cropData = [];
	var caregoryMap =
<%=objectMapper.writeValueAsString(categoryMap)%>
	;
	function afterFormLoadedFormIOForm(thisInstance) {
		var element = document.getElementById("formio");
		element.classList.add("custom-background");
		formInstance = thisInstance;
		createTableHeader();
		tableHead = document.getElementsByClassName("candidateTable")[0].getElementsByTagName('thead')[0];
		tableRef = document.getElementsByClassName("candidateTable")[0].getElementsByTagName('tbody')[0];
		rmvRow();
		corporateChange(thisInstance);
		thisInstance.components.SaveDraft.buttonElement.style.display = "none";
		setInterval(function() {
			checkCPForm(thisInstance);
		}, 1);
		document.getElementsByClassName("collect-payment-btn")[0]
				.addEventListener(
						"click",
						function() {
							showLoading(true);
							getHoldReceipt(function(receipt) {
								showLoading(false);
								console.log("showPaymentSection...");
								if (formInstance.form.submission.data.source == "CORPORATE") {
									showPaymentSection(
											receipt,
											"SGD",
											totalInvAmt,
											totalTaxAmt,
											"normal",
											formInstance.form.submission.data.source,
											thisInstance.form.submission.data.searchValueCorporate,
											formInstance.components.notes.value);
								} else {
									showPaymentSection(
											receipt,
											"SGD",
											totalInvAmt,
											totalTaxAmt,
											"normal",
											formInstance.form.submission.data.source,
											thisInstance.form.submission.data.searchValue,
											formInstance.components.notes.value);
								}
							});
						});
		thisInstance.components.Submit.disabled = true;
		
		if(receiptFor && receiptFor=="candidate") {
			thisInstance.components.source.setValue("CANDIDATE");
		}
		if(candidateId && candidateId!="null") {
			var selectedValues = [];
			var selectedValue = {
					"IDNumber": candidateNumber,
					"UserId": candidateId,
					"FullName": candidateName
			}
			selectedValues.push(selectedValue);
			thisInstance.components.searchValue.setValue(selectedValues);
			changeUser();
		}
	}

	function checkCPForm(thisInstance) {
		if (checkIsValide(thisInstance)) {
			thisInstance.components.Submit.disabled = false;
		} else {
			thisInstance.components.Submit.disabled = true;
		}
	}

	function _displayMessage(type, message, duration) {
		scrollToTop();
		var alert_div = document.getElementById("alert_msg_id");
		alert_div.innerHTML = message;
		alert_div.classList.add("alert-" + type);
		alert_div.style.display = "block";
		setTimeout(function() {
			alert_div.style.display = "none";
		}, duration);
	}

	function checkIsValide(thisInstance) {
		var eValid = true;
		var source = formInstance.form.submission.data.source;
		if (source == "CORPORATE"
				&& (thisInstance.form.submission.data.searchValueCorporate == "" || thisInstance.form.submission.data.searchValueCorporate.length <= 0)) {
			eValid = false;
		} else if (source == "CANDIDATE"
				&& (thisInstance.form.submission.data.searchValue == "")) {
			eValid = false;
		} else if (selectedInvoiceList.length <= 0) {
			eValid = false;
		}

		return eValid;
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

	function corporateChange(thisInstance) {
		var selectEle = document.getElementsByClassName("corporateSelect")[0]
				.getElementsByTagName("select")[0];
		selectEle
				.addEventListener(
						'change',
						function() {
							showLoading(true);
							var cropList = thisInstance.form.submission.data.searchValueCorporate;
							var orgList = [];
							cropList.forEach(function(item, index) {
								orgList.push(item.organizationId);
							});
							var obj = {};
							obj.clientType = 'CORPORATE';
							obj.candidateOrCorporateId = orgList;
							getTransactionInfo(obj, 'CORPORATE');
						});

		var selectCandidateElm = document
				.getElementsByClassName("candidateSelect")[0]
				.getElementsByTagName("select")[0];
		selectCandidateElm.addEventListener('change', changeUser);

		formInstance.on('partial', function(changePayload) {
			if (changePayload.changed.component.key === "source") {
				setDataInTable(null);
			}
		});
	}
	
	function changeUser() {
		showLoading(true);
		var cropList = formInstance.form.submission.data.searchValue;
		var orgList = [];
		cropList.forEach(function(item, index) {
			orgList.push(item.UserId);
		});
		var obj = {};
		obj.clientType = 'CANDIDATE';
		obj.candidateOrCorporateId = orgList;
		getTransactionInfo(obj, 'CANDIDATE');
	}

	function setCropPopupData(lists) {
		enrollList = [];
		miscList = [];
		pendingTrncMap = {};
		for (var i = 0; i < lists.length; i++) {
			var list = lists[i];
			if (JSON.parse(list.contentJson).SourceType == sourceTypeMap['MS']) {
				miscList.push(list);
			} else {
				enrollList.push(list);
			}
			pendingTrncMap[list.invoiceOrProgram] = list;
		}
		if (lists && lists.length > 0) {
			openTransactionModal(miscList, enrollList);
			showLoading(false);
		} else {
			setDataInTable(null);
			showLoading(false);
		}

	}

	function getTransactionInfo(obj, type) {
		var data = {};
		data.formType = 'TransactionMaster';
		data.ModelName = 'TransactionMaster';
		obj.categoryMap = JSON.stringify(categoryMap);
		obj.showPendingInvoice = showPending;
		data = obj;
		var response = [];
		
		if(formInstance.form.submission.data.source=="CORPORATE") {
			var corps = formInstance.form.submission.data.searchValueCorporate;
			var corpMap = {};
			for(var svi in corps) {
				corpMap[corps[svi].organizationId] = corps[svi].name;
			}
			data.corporateMap = JSON.stringify(corpMap);
		}
		
		console.log("obj.candidateOrCorporateId: "+obj.candidateOrCorporateId);
		if(obj.candidateOrCorporateId && obj.candidateOrCorporateId!="") {
			ajaxCallAPI('POST', 'fetchReceiptInfo', data, function() {
				var list = this.get("responseData");
				console.log("list : " + JSON.stringify(list));
				if (list != null && list.length != 0 && type == "CORPORATE") {
					setCropPopupData(list);
				} else {
					setDataInTable(list);
				}
			}, function() {
			});
		} else {
			setDataInTable([]);
		}
	}

	function setDataInTable(datas) {
		invoiceList = [];
		totalInvAmt = 0;
		totalTaxAmt = 0;
		rmvRow();
		if (datas == null || datas.length == 0) {
			formInstance.components.noRecordInstance.element.style.display = "";
		} else {
			formInstance.components.noRecordInstance.element.style.display = "none";
			for (var i = 0; i < datas.length; i++) {
				invoiceList.push(datas[i]);
				addRow(datas[i], tableRef);
			}
			var source = formInstance.form.submission.data.source;
			if (source != "CORPORATE") {
				selectedInvoiceList = invoiceList;
			}
		}
		showLoading(false);
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

	var totalInvAmt = 0;
	var totalTaxAmt = 0;
	function addRow(data, tableRef) {
		var dataContentJson = JSON.parse(data.contentJson);
		var newRow = tableRef.insertRow(tableRef.rows.length);
		// Insert a cell in the row at index 0
		var newCell = newRow.insertCell(0);
		newCell.appendChild(document
						.createTextNode((typeof data.id === "undefined") ? ""
								: data.id));

		newCell = newRow.insertCell(1);
		newCell.appendChild(document
				.createTextNode((typeof data.name === "undefined") ? ""
						: data.name));
		
		var source = formInstance.form.submission.data.source;
		if (source == "CORPORATE") {
			newCell = newRow.insertCell(2);
			newCell.appendChild(document.createTextNode(dataContentJson.ExtRefNumber));

			newCell = newRow.insertCell(3);
			newCell.appendChild(document.createTextNode(dataContentJson.Description));

			newCell = newRow.insertCell(4);
			var schedule = "";
			newCell.appendChild(document.createTextNode(dataContentJson.DueDate));
		} else {
			newCell = newRow.insertCell(2);
			var programme = getValue(dataContentJson.Title);
			newCell.appendChild(document.createTextNode(programme));

			newCell = newRow.insertCell(3);
			var details = dataContentJson.TransactionDetails;
			
			var titles = [];
			for ( var dind in details) {
				var title = getValue(details[dind].title);
				if(titles.indexOf(title) < 0){
					titles.push(title) ;
				}
			}
			console.log(titles)
			var subject = "";
			for(var i=0; i < titles.length; i++){
				subject += titles[i] + "</br>";
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
		}
		
		newCell = newRow.insertCell(5);
		newCell.appendChild(document.createTextNode(formatMoney(data.totalFee)));
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
		
		totalInvAmt = totalInvAmt + parseFloat(data.totalFee);
		totalTaxAmt = totalTaxAmt + parseFloat(data.totalTax);
		
	}
	
	function formatMoney(num){
		num = round(parseFloat(num),2).toFixed(2);
		return addCommas(num);
	}

	function round(value, decimals) {
		return Number(Math.round(value+'e'+decimals)+'e-'+decimals);
	}
	
	function addCommas(nStr) {
		nStr += '';
		var x = nStr.split('.');
		var x1 = x[0];
		var x2 = x.length > 1 ? '.' + x[1] : '';
		var rgx = /(\d+)(\d{3})/;
		while (rgx.test(x1)) {
			x1 = x1.replace(rgx, '$1' + ',' + '$2');
		}
		return x1 + x2;
	}

	function getValue(val) {
		if (typeof val === "undefined") {
			return "";
		} else {
			return val;
		}
	}

	function openTransactionModal() {
		var popupdiv = "#action-dialog";
		var popupdivbox = "#action-dialog-box";
		AUI()
				.use(
						'aui-base',
						function(A) {
							A.one(popupdiv).set('hidden', false);
							YUI()
									.use(
											'aui-modal',
											function(Y) {
												var modal = new Y.Modal({
													boundingBox : popupdiv,
													contentBox : popupdivbox,
													headerContent : '',
													centered : true,
													destroyOnHide : false,
													modal : true,
													resizable : false,
													draggable : true,
												}).render();
												setDataInPopup(miscList,
														enrollList);
												Y.one('.close').on('click',
														function() {
															modal.hide();
														});
												Y
														.one(
																'.popup-cancel-action')
														.on(
																'click',
																function() {
																	modal
																			.hide();
																});
												Y
														.one(
																'.popup-submit-action')
														.on(
																'click',
																function() {
																	modal
																			.hide();
																	var list = [];
																	selectedInvoiceList = [];
																	invoiceList = [];
																	for ( var key in pendingTrncMap) {
																		if (document
																				.getElementById(pendingTrncMap[key].invoiceOrProgram)
																				&& document
																						.getElementById(pendingTrncMap[key].invoiceOrProgram).checked) {
																			list
																					.push(pendingTrncMap[key]);
																			selectedInvoiceList
																					.push(pendingTrncMap[key].invoiceOrProgram);
																		}
																	}
																	setDataInTable(list);
																});
											});
						});
	}

	function setDataInPopup(miscList, enrollList) {
		var enrnDiv = document.getElementById('enrollmentDiv');
		enrnDiv.innerHTML = '';
		var misclDiv = document.getElementById('miscellaneousDiv');
		misclDiv.innerHTML = '';

		for (var i = 0; i < enrollList.length; i++) {
			createCheckBox(enrnDiv, enrollList[i].invoiceOrProgram,
					enrollList[i].name, enrollList, 'enrollment', miscList,
					'miscellaneous');
		}

		for (var i = 0; i < miscList.length; i++) {
			createCheckBox(misclDiv, miscList[i].invoiceOrProgram,
					miscList[i].name, miscList, 'miscellaneous', enrollList,
					'enrollment');
		}
		applyOnChangeEvents(document.getElementById('enrollment'), enrollList,
				'miscellaneous', miscList);
		applyOnChangeEvents(document.getElementById('miscellaneous'), miscList,
				'enrollment', enrollList);
		enableDisableCheckbox();
	}

	function searchInvoices() {
		var input, filter, ul, li, a, i, txtValue;
		input = document.getElementById("myInput");
		filter = input.value.toUpperCase();
		var enrnDiv = document.getElementById('enrollmentDiv');
		labels = enrnDiv.getElementsByTagName("label");
		for (i = 0; i < labels.length; i++) {
			input = labels[i].getElementsByTagName("input")[0];
			txtValue = labels[i].textContent || labels[i].innerText
					|| labels[i].innerHTML;
			if (txtValue.toUpperCase().indexOf(filter) > -1) {
				labels[i].style.display = "";
			} else {
				labels[i].style.display = "none";
			}
		}
		var misclDiv = document.getElementById('miscellaneousDiv');
		labels = misclDiv.getElementsByTagName("label");
		for (i = 0; i < labels.length; i++) {
			input = labels[i].getElementsByTagName("input")[0];
			txtValue = labels[i].textContent || labels[i].innerText
					|| labels[i].innerHTML;
			if (txtValue.toUpperCase().indexOf(filter) > -1) {
				labels[i].style.display = "";
			} else {
				labels[i].style.display = "none";
			}
		}
	}

	function createCheckBox(divElm, id, name, list, mainId, uncheckList,
			uncheckId) {
		var label = document.createElement('label');
		label.setAttribute('for', name);
		label.setAttribute('id', id + name);
		
		var input = document.createElement('input');
		input.type = 'checkbox';
		if(mainId=="enrollment") {
			input.setAttribute('name', 'enrollment[]');
		} else {
			input.setAttribute('name', 'miscellaneous[]');
		}
		input.setAttribute('class', 'form-control input-sm');
		input.setAttribute('id', id);
		if (selectedInvoiceList.includes("" + id)) {
			input.setAttribute('checked', true);
		}
		label.appendChild(input);
		var span = document.createElement('span');
		span.innerHTML = id;
		span.addEventListener('click', function(event) {
			if(!input.disabled) {
				if(input.checked) {
					input.checked = false;
					enableDisableCheckbox();
				} else {
					input.checked = true;
					enableDisableCheckbox();
				}
			}
		});
		label.appendChild(span);
		divElm.appendChild(label);
	}

	function checkAllSelect(divElm, list, mainId, uncheckList, uncheckId) {
		var len = list.length;
		var count = 0;
		for (i = 0; i < list.length; i++) {
			if (document.getElementById(list[i].invoiceOrProgram)) {
				if (document.getElementById(list[i].invoiceOrProgram).checked) {
					count = count + 1;
				}
				;
			}
		}
		if (len == count) {
			document.getElementById(mainId).checked = true;
		} else {
			document.getElementById(mainId).checked = false;
		}

		if (count > 0) {
			toggleCheckOther(uncheckList, uncheckId, true);
		} else {
			toggleCheckOther(uncheckList, uncheckId, false);
		}
	}

	function enableDisableCheckbox() {
		var enrolCheckboxEles = document.getElementsByName("enrollment[]");
		var miscellaneousCheckboxEles = document.getElementsByName("miscellaneous[]");
		var enrolEnable = false;
		toggleCheckOther(miscList, "miscellaneous", false);
		toggleCheckOther(enrollList, "enrollment", false);
		for(var ci in enrolCheckboxEles) {
			if(enrolCheckboxEles[ci].checked) {
				enrolEnable = true;
				toggleCheckOther(miscList, "miscellaneous", true);
				break;
			}
		}
		if(!enrolEnable) {
			for(var mi in miscellaneousCheckboxEles) {
				if(miscellaneousCheckboxEles[mi].checked) {
					toggleCheckOther(enrollList, "enrollment", true);
					break;
				}
			}
		}
	}
	
	function toggleCheckOther(uncheckList, uncheckId, disable) {
		for (i = 0; i < uncheckList.length; i++) {
			var div = document.getElementById(uncheckList[i].invoiceOrProgram);
			var parentElm = div.parentElement;
			div.disabled = disable;
			if (disable) {
				div.checked = false;
				parentElm.style.color = "#beb8b8";
			} else {
				parentElm.style.color = "#555";
			}
		}
		document.getElementById(uncheckId).disabled = disable;
		if (disable) {
			document.getElementById(uncheckId).checked = false;
			document.getElementById(uncheckId).parentElement.style.color = "#beb8b8";
		} else {
			document.getElementById(uncheckId).parentElement.style.color = "#221fc8";
		}
	};

	function applyOnChangeEvents(mainCheckbox, list, toggleId, toggleList) {
		mainCheckbox.checked = false;
		mainCheckbox
				.addEventListener(
						'change',
						function(event) {
							var isChecked = event.target.checked;
							for (i = 0; i < list.length; i++) {
								if (document
										.getElementById(list[i].invoiceOrProgram)) {
									document
											.getElementById(list[i].invoiceOrProgram).checked = isChecked;
								}
							}
							toggleCheckOther(toggleList, toggleId, isChecked);
						});
	}

	function showLoading(show) {
		if (show) {
			getEID("loadingDiv").style.display = "block";
		} else {
			getEID("loadingDiv").style.display = "none";
		}
	}
	function getHoldReceipt(callback) {
		var compRefNumber="";
		for(var ii=0;ii<invoiceList.length;ii++) {
			compRefNumber = compRefNumber + JSON.parse(invoiceList[ii].contentJson).TransactionMasterCode + ",";
		}
		compRefNumber = compRefNumber.substring(0, compRefNumber.length-1);
		console.log("compRefNumber : "+compRefNumber);
		var data = {};
		data.formType = "TransactionMaster";
		data.conditions = ["categoryType="+categoryMap["RE"],"TransactionStatus=Pending",
		                   "contentJson.ComponentRefNumber="+compRefNumber,"size=1"];
		ajaxCallAPI(
				'GET',
				"searchList",
				data,
				function() {
					var data = this.get("responseData");
					console.log(data);
					var responseData = [];
					if (data.error) {
						displayMessage('danger', data.error, 3000);
					} else {
						responseData = data.content[0];
					}
					callback(responseData);
				}, function() {
					displayMessage('danger',
							"Error in getting exchange rates.", 3000);
					callback(null);
				});
	}
</script>
<% } %>

