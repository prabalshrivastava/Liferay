var modelName = "TransactionMaster";
hideAllButtons();
showLoading(true);
function init() {
	console.log("onload...");
	fetchDetails(formStorageId);
}
if (document.readyState == 'complete') {
	init();
} else {
	window.addEventListener('load', init);
}

function fetchDetails(formStorageId) {
	if (formStorageId != "") {
		populateDetails(formStorageId);
		populateRemarks(formStorageId);
	}
}

function populateRemarks(formStorageId) {
	var data = {};
	data.formType = "InvoiceRemarks";
	data.conditions = [ "contentJson.ReferenceId=" + formStorageId,
			"size=" + 2147483647, "sort=created_date,desc" ];
	ajaxCallAPI(
			'GET',
			"searchList",
			data,
			function() {
				data = this.get("responseData");
				var contentdata = this.get("responseData");
				var responseData = [];
				if (data.error) {
					displayMessage('danger', data.error, 3000);
				} else {
					responseData = contentdata.content;
					console.log("responseData : ");
					console.log(responseData);
					var olderAdded = false;
					var todayAdded = false;
					for (var i = 0; i < responseData.length; i++) {
						var remark = responseData[i];
						var remarkTemplate = getEID(
								namespace + "remarkTemplate").cloneNode(true);
						var remarksAction = remarkTemplate
								.getElementsByClassName("remarksAction")[0];
						var remarksTime = remarkTemplate
								.getElementsByClassName("remarksTime")[0];
						var remarksText = remarkTemplate
								.getElementsByClassName("remarksText")[0];
						var dayRow = remarkTemplate
								.getElementsByClassName("dayRow")[0];
						var dayText = remarkTemplate
								.getElementsByClassName("dayText")[0];

						if (remark.contentJson.ApprovalStatus == "Pending Approval") {
							remarksAction.innerHTML = "<b>" + remark.createdBy
									+ "</b> submitted for approval";
						} else if (remark.contentJson.ApprovalStatus == "Approved") {
							remarksAction.innerHTML = "<b>" + remark.createdBy
									+ "</b> approved";
						} else if (remark.contentJson.ApprovalStatus == "Rejected") {
							remarksAction.innerHTML = "<b>" + remark.createdBy
									+ "</b> rejected";
						} else if (remark.contentJson.ApprovalStatus == "Return for Amendments") {
							remarksAction.innerHTML = "<b>" + remark.createdBy
									+ "</b> returned for amendments";
						} else if (remark.contentJson.ApprovalStatus == "Void") {
							remarksAction.innerHTML = "<b>" + remark.createdBy
									+ "</b> voided";
						} else {
							remarksAction.innerHTML = "<b>" + remark.createdBy
									+ "</b> created";
						}
						var dt = new Date(Date.parse(remark.createdDate));
						if (isToday(dt)) {
							if (todayAdded) {
								dayRow.style.display = "none";
							} else {
								dayRow.style.display = "block";
								dayText.innerHTML = "<b>Today</b>";
								todayAdded = true;
							}
							remarksTime.innerHTML = formatNumber(dt.getHours())
									+ ":" + formatNumber(dt.getMinutes());
						} else {
							if (olderAdded) {
								dayRow.style.display = "none";
							} else {
								olderAdded = true;
								dayRow.style.display = "block";
								dayText.innerHTML = "<b>Older</b>";
							}
							remarksTime.innerHTML = formatNumber(dt.getDate())
									+ "/" + formatNumber(dt.getMonth() + 1)
									+ "/" + formatNumber(dt.getFullYear())
									+ " " + formatNumber(dt.getHours()) + ":"
									+ formatNumber(dt.getMinutes());
						}
						remarksText.innerHTML = remark.contentJson.Remark;
						remarkTemplate.style.display = "block";
						getEID("invoiceRemarksContainer").appendChild(
								remarkTemplate);
					}
					getEID("totalRemarks").innerHTML = "(Total: "
							+ responseData.length + " Remarks)";
				}
			}, function() {
				displayMessage('danger', "Error in populating remarks.", 3000);
			});
}

function isToday(date) {
	var argDate = new Date(date);
	var todaysDate = new Date();
	if (argDate.setHours(0, 0, 0, 0) == todaysDate.setHours(0, 0, 0, 0)) {
		return true;
	}
	return false;
}

function formatNumber(number) {
	return parseInt(number) < 10 ? "0" + number : number;
}

function doProcessPayment() {

	console.log("formStorageId : " + formStorageId);
	AUI().use('liferay-portlet-url', function(A) {
		var e = Liferay.PortletURL.createRenderURL();
		e.options.basePortletURL = baseUrl;
		e.setParameter("jspPage", config.paymentProcessPage);
		e.setParameter("formTypeName", modelName);
		e.setParameter("storageId", formStorageId);
		e.setPortletId(namespace.replace(/(^\_+|\_+$)/mg, ''));
		e.setWindowState("normal");
		console.log("e : " + e.toString());
		window.location.href = e.toString();
	});
}

function displayDetailsByStatus(status) {
	if (status == "Pending") {
		getEID("paymentStatus").className = "payment-status pending";
		getEID("amountToBePaidRow").style = "display:none";
		getEID("miscFeeRow").style = "display:none";
		getEID("paymentModeRow").style = "display:none";
		getEID("valueDateRow").style = "display:none";
		getEID("creditDateRow").style = "display:none";
		getEID("paymentSetCodeRow").style = "display:none";
		getEID("notesRow").style = "display:none";
	} else if (status == "Confirmed") {
		getEID("paymentStatus").className = "payment-status confirmed";
		getEID("amountToBePaidRow").style = "display:none";
		getEID("miscFeeRow").style = "display:none";
	} else if (status == "Pending Approval" || status == "Pending Amendment") {
		getEID("paymentStatus").className = "payment-status pending-approval";
		if (status == "Pending Amendment") {
			getEID("btnProcessPayment").innerHTML = "MAKE AMENDMENTS";
		} else {
			getEID("btnProcessPayment").style = "display:none";
		}

	}
}

function populateDetails(formStorageId) {
	var data = {};
	data.formStorageId = formStorageId;
	data.formType = modelName;
	data.indetail = "true";
	console.log("data : " + JSON.stringify(data));
	ajaxCallAPI(
			'GET',
			"loadData",
			data,
			function() {
				data = this.get("responseData");
				var contentdata = this.get("responseData");
				console.log("contentdata : " + JSON.stringify(contentdata));
				if (data.error) {
					displayMessage('danger', data.error, 3000);
				} else {

					if(typeof invoiceTypeDetail == "string"){
						invoiceTypeDetail = contentdata.contentJson.Type;
					}
					
					if (categoryType == "CN") {
						getEID(namespace + "idName").value = contentdata.contentJson.IdName ? contentdata.contentJson.IdName
								.replace(/^\D+|\D.*$/g, "")
								: "";
						getEID(namespace + "name").value = contentdata.contentJson.NameOfPayer ? contentdata.contentJson.NameOfPayer
								: "";
						getEID(namespace + "creditNoteDt").value = contentdata.contentJson.TxnDate ? contentdata.contentJson.TxnDate
								: "";
						getEID(namespace + "creditNoteNo").value = contentdata.contentJson.ExtRefNumber ? contentdata.contentJson.ExtRefNumber
								: "";
						getEID(namespace + "receiptNo").value = contentdata.contentJson.ComponentRefNumber ? contentdata.contentJson.ComponentRefNumber
								: "";
						getEID(namespace + "description").value = contentdata.contentJson.Description ? contentdata.contentJson.Description
								: "";
						getEID(namespace + "natureOfCredit").value = contentdata.contentJson.SourceType ? contentdata.contentJson.SourceType
								: "";
						getEID(namespace + "amount").value = contentdata.contentJson.TotalAmount ? contentdata.contentJson.TotalAmount
								: "";

						getEID("invoiceRemarksDiv").style.display = "none";
						getEID("remarksHeader").style.display = "none";
						showLoading(false);
						return;
					}
					if (categoryType == "PA") {
						displayDetailsByStatus(contentdata.contentJson.TransactionStatus);
						getEID(namespace + "idAndName").value = contentdata.contentJson.IdName;
						getEID(namespace + "productType").value = contentdata.contentJson.ProductType
								+ " - "
								+ contentdata.contentJson.ProductSubType;
						getEID(namespace + "description").value = contentdata.contentJson.Description;
						getEID(namespace + "amountPayable").value = contentdata.contentJson.TotalAmountBaseCurrency
								.toFixed(2);
						getEID("paymentStatus").innerHTML = contentdata.contentJson.TransactionStatus;

						if (contentdata.contentJson.TransactionStatus == "Pending") {
							getEID("paymentStatus").className = "payment-status pending";
						} else if (contentdata.contentJson.TransactionStatus == "Confirmed") {
							getEID("paymentStatus").className = "payment-status confirmed";
							getEID(namespace + "paymentMode").value = contentdata.contentJson.PaymentMode === undefined ? ""
									: contentdata.contentJson.PaymentMode;
							getEID(namespace + "creditDate").value = contentdata.contentJson.CreditDate;
							getEID(namespace + "valueDate").value = contentdata.contentJson.ValueDate;
							getEID(namespace + "paymentSetCode").value = contentdata.contentJson.PaymentSetCode;
							getEID(namespace + "notes").value = contentdata.contentJson.Notes === undefined ? ""
									: contentdata.contentJson.Notes;
						} else if (contentdata.contentJson.TransactionStatus == "Pending Approval"
								|| contentdata.contentJson.TransactionStatus == "Pending Amendment") {
							getEID("paymentStatus").className = "payment-status pending-approval";
							getEID(namespace + "paymentMode").value = contentdata.contentJson.PaymentMode === undefined ? ""
									: contentdata.contentJson.PaymentMode;
							getEID(namespace + "creditDate").value = contentdata.contentJson.CreditDate;
							getEID(namespace + "valueDate").value = contentdata.contentJson.ValueDate;
							getEID(namespace + "paymentSetCode").value = contentdata.contentJson.PaymentSetCode;
							getEID(namespace + "notes").value = contentdata.contentJson.Notes === undefined ? ""
									: contentdata.contentJson.Notes;

							var miscFee = 0;
							if (contentdata.contentJson
									.hasOwnProperty("TransactionDetails")) {
								for (var i = 0; i < contentdata.contentJson.TransactionDetails.length; i++) {
									var fee = contentdata.contentJson.TransactionDetails[i];
									if (fee.amountType == "Misc. Fee") {
										miscFee = miscFee
												+ (fee.quantity * fee.unitPrice);
									}
								}
							}
							getEID(namespace + "miscFee").value = "- "
									+ miscFee;
							getEID(namespace + "amountPayable").value = (contentdata.contentJson.TotalAmountBaseCurrency - miscFee)
									.toFixed(2);
							getEID(namespace + "amountToBePaid").value = contentdata.contentJson.TotalAmountBaseCurrency
									.toFixed(2);
						}
						var as = data.contentJson.ApprovalStatus.toUpperCase();
						if (as == "PENDING APPROVAL") {
							showHideElement(document.getElementById("approve"),
									"block");
							showHideElement(document.getElementById("reject"),
									"block");
							showHideElement(document
									.getElementById("samendment"), "block");
							showHideElement(document
									.getElementById("vamendment"), "block");
						}
						if (as == "APPROVED" || as == "PENDING AMENDMENTS"
								|| as == "PENDING") {
							showHideElement(document
									.getElementById("btnProcessPayment"),
									"block");
						}
						showLoading(false);
						return;
					}
					getEID(namespace + "txnDate").value = contentdata.contentJson.TxnDate;
					console.log("contentdata.contentJson.ExtRefNumber : "
							+ contentdata.contentJson.ExtRefNumber);
					getEID(namespace + "number").value = (typeof contentdata.contentJson.ExtRefNumber === "undefined") ? "DRAFT"
							: contentdata.contentJson.ExtRefNumber;
					getEID(namespace + "nameOfPayer").value = contentdata.contentJson.NameOfPayer;
					
					getEID(namespace + "amount").value = contentdata.contentJson.Currency
							+ " "
							+ Number(contentdata.contentJson.TotalAmountBaseCurrency).toFixed(2);
					getEID(namespace + "requestType").value = contentdata.contentJson.RequestType;
					if (typeof contentdata.createdBy !== "undefined") {
						getEID(namespace + "processedBy").value = contentdata.createdBy;
					}
					if (contentdata.contentJson.CategoryType == "Invoice") {
						getEID(namespace + "dueDate").value = contentdata.contentJson.DueDate;
						getEID(namespace + "approvalStatus").value = contentdata.contentJson.ApprovalStatus;
						getEID(namespace + "description").value = contentdata.contentJson.Description;
					} else if (contentdata.contentJson.CategoryType == "Receipt") {
						var paymentModes = "";
						if (contentdata.contentJson.PaymentDetails) {
							for (var i = 0; i < contentdata.contentJson.PaymentDetails.length; i++) {
								paymentModes = paymentModes
										+ contentdata.contentJson.PaymentDetails[i].paymentModeType
										+ ", ";
							}
							paymentModes = paymentModes.slice(0, -2);
						}
						getEID(namespace + "paymentModes").value = paymentModes;
						getEID(namespace + "paymentStatus").value = contentdata.contentJson.TransactionStatus;
						getEID(namespace + "notes").value = "-";
						getEID(namespace + "source").value = contentdata.contentJson.Source;
					}
					console.log("contentdata.contentJson.ApprovalStatus : "
							+ contentdata.contentJson.ApprovalStatus);

					var as = contentdata.contentJson.ApprovalStatus;
					var type = contentdata.contentJson.Type;
					var rt = contentdata.contentJson.RequestType;
					var ct = contentdata.contentJson.CategoryType;
					var td = contentdata.contentJson.TxnDate;
					if (ct == "Invoice") {
						if ((as == "Pending" || as == "Return for Amendments")) {
							showHideElementById("edit", "block");
						} else {
							showHideElementById("edit", "none");
						}
						if (ct == "Invoice"
								&& (as == "Pending" || as == "Return for Amendments")) {
							showHideElementById("submit", "block");
						} else {
							showHideElementById("submit", "none");
						}
						if (as == "Pending Approval"
								&& (rt == "Cancel" || rt == "New Invoice")) {
							showHideElementById("approve", "block");
						} else {
							showHideElementById("approve", "none");
						}
						if (as == "Pending Approval"
								&& (rt == "Cancel" || rt == "New Invoice")) {
							showHideElementById("reject", "block");
						} else {
							showHideElementById("reject", "none");
						}
						if (as == "Pending Approval" && rt != "Cancel"
								&& rt != "Void") {
							showHideElementById("return", "block");
						} else {
							showHideElementById("return", "none");
						}
						if (rt == "New Invoice"
								&& (as == "Pending" || as == "Pending Approval" || as == "Return for Amendments")) {
							showHideElementById("void", "block");
						} else {
							showHideElementById("void", "none");
						}
						if (rt == "New Invoice" && as == "Approved") {
							showHideElementById("cancel", "block");
						} else {
							showHideElementById("cancel", "none");
						}
						if(as == "Pending Approval"){
							showHideElementById("void", "none");
							if(getEID("showBackToListing") != null){
								getEID("back").innerText = "BACK TO LIST OF INVOICES";
								getEID("back").style = "width:230px;";
							}
						}
					} else if (ct == "Receipt") {
						if (as == "Return for Amendments"
								|| (as == "Approved" && rt == "New Invoice")) {
							showHideElementById("edit", "block");
						} else {
							showHideElementById("edit", "none");
						}
						if (as == "Pending Approval") {
							showHideElementById("approve", "block");
							showHideElementById("reject", "block");
							showHideElementById("return", "block");
						} else {
							showHideElementById("approve", "none");
							showHideElementById("reject", "none");
							showHideElementById("return", "none");
						}

						if ((as == "Approved" && rt == "New Invoice")
								|| as == "Return for Amendments") {
							if (serverCurrDate == td) {
								showHideElementById("void", "block");
								showHideElementById("cancel", "none");
							} else {
								showHideElementById("void", "none");
								showHideElementById("cancel", "block");
							}
						} else {
							showHideElementById("void", "none");
							showHideElementById("cancel", "none");
						}
					}
					enableFormViewMode("invoiceDetailsForm");
					showLoading(false);
				}
			}, function() {
				displayMessage('danger',
						"Error in persisting dynamic form data.", 3000);
				showLoading(false);
			});
}

function hideAllButtons() {
	showHideElementById("submit", "none");
	showHideElementById("approve", "none");
	showHideElementById("reject", "none");
	showHideElementById("return", "none");
	showHideElementById("void", "none");
	showHideElementById("cancel", "none");
	showHideElementById("edit", "none");
	showHideElement(document.getElementById("samendment"), "none");
	showHideElement(document.getElementById("vamendment"), "none");
	showHideElement(document.getElementById("btnProcessPayment"), "none");
}