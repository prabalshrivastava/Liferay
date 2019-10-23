var bankNameList = [];
var currencyList = [];
var bankLoaded = false;
var currencyLoaded = false;
var taxLoaded = false;
var creditBalanceLoaded = false;
var baseCurrency = "SGD";
var taxRate = 0;
var screen;
var clientType;
var selectedNames;
var formStorageId;
var notes;
var holdReceipt;
function showPaymentSection(receipt, baseCurrency, totalAmt, totalTax, screen, clientType,
		selectedNames, notes) {
	this.notes = notes;
	this.bankNameList = [];
	this.currencyList = [];
	this.bankLoaded = false;
	this.currencyLoaded = false;
	this.taxLoaded = false;
	this.creditBalanceLoaded = false;
	this.baseCurrency = "SGD";
	this.taxRate = 0;
	this.screen = "";
	this.clientType = "";
	this.selectedNames = [];
	document.getElementById(namespace + "paymentMode").innerHTML = '<option value="">Add a mode</option>';

	this.screen = screen;
	this.clientType = clientType;
	this.selectedNames = selectedNames;
	if (screen != "normal") {
		document.getElementById("hold").parentElement.style.display = "none";
		document.getElementById(namespace + "cancelContainer").classList
				.remove("span6");
		document.getElementById(namespace + "cancelContainer").classList
				.add("span12");
		document.getElementById(namespace + "cancelContainer").style.marginLeft = "0px";
	}
	if (clientType == "CORPORATE") {
		document.getElementById(namespace + "payerFullName").value = selectedNames[0].name;
	} else {
		document.getElementById(namespace + "payerFullName").value = selectedNames[0].FullName;
	}
	bankLoaded = false;
	currencyLoaded = false;
	taxLoaded = false;
	creditBalanceLoaded = false;
	showLoading(true);
	this.baseCurrency = baseCurrency;
	loadDropdownData(function() {
		console.log("--receipt :L ");
		console.log(receipt);
		console.log(bankLoaded + " | " + currencyLoaded + " | " + taxLoaded + " | " + creditBalanceLoaded);
		if (bankLoaded == true && currencyLoaded == true && taxLoaded == true && creditBalanceLoaded == true) {
			if(receipt) {
				this.holdReceipt = receipt;
				document.getElementById(namespace + "payerFullName").value = receipt.contentJson.PaymentDetails[0].payerName;
				for(var ip=0;ip<receipt.contentJson.PaymentDetails.length;ip++) {
					var pm = receipt.contentJson.PaymentDetails[ip];
					console.log("pm");
					console.log(pm);
					console.log(pm.paymentModeType);
					if(pm.paymentModeType.toLowerCase() == "other") {
						selectMode(document.getElementById(namespace+"paymentMode"), "Others");
					} else if (pm.paymentModeType == "VISA"
						|| pm.paymentModeType == "MASTER" || pm.paymentModeType == "JCB" 
							|| pm.paymentModeType == "Diners" || pm.paymentModeType == "AMEX") {
						selectMode(document.getElementById(namespace+"paymentMode"), "Credit Card");
					} else {
						selectMode(document.getElementById(namespace+"paymentMode"), pm.paymentModeType);
					}
					showPaymentMode();
					populateMode(pm);
				}
			}
			
			showLoading(false);
			document.getElementById("mainDiv").style.display = "block";
			var elem = document.getElementById("paymentDiv");
			var width = 1;
			elem.style.width = width + '%';
			var id = setInterval(frame, 10);
			function frame() {
				if (width == 35) {
					clearInterval(id);
				} else if (width == 30) {
					document.getElementsByClassName("totalDiv")[0].style.display = "block";
					document.getElementsByClassName("totalDiv")[1].style.display = "block";
					width++;
					elem.style.width = width + '%';
				} else {
					width++;
					elem.style.width = width + '%';
				}
			}
			var paymentAmountInputs = document
					.getElementsByClassName("paymentAmount");
			for (var i = 0; i < paymentAmountInputs.length; i++) {
				paymentAmountInputs[i].addEventListener("blur", function() {
					console.log("this : " + this.id);
					console.log("this : " + this.value);
					changeHeadingAmount(this);
				});
			}
			document.getElementById(namespace + "creditTransferAmount")
					.addEventListener("blur", function() {
						changeCreditTransferBaseAmount();
					});
			var baseCurrencyLabelList = document
					.getElementsByClassName("baseCurrencyLabel");
			for (var ind = 0; ind < baseCurrencyLabelList.length; ind++) {
				baseCurrencyLabelList[ind].innerHTML = baseCurrency;
			}
			document.getElementById("subTotalLabel").value = totalAmt;
			document.getElementById("subTotalLabel").innerHTML = formatNumbers(totalAmt);
			console.log("totalAmt : " + totalAmt);
			console.log("taxRate : " + taxRate);
			document.getElementById("taxRateLabel").value = totalTax;
			document.getElementById("taxRateLabel").innerHTML = formatNumbers(totalTax);
			document.getElementById("totalReceivableAmount").value = totalTax + totalAmt;
			document.getElementById("totalReceivableAmount").innerHTML = formatNumbers(totalTax + totalAmt);
			changeTotalAmount();
		}
	});
	setInterval(function() {
		checkPSForm();
	}, 1000);
}

function selectMode(dd, textToFind) {
	for (var i = 0; i < dd.options.length; i++) {
		console.log("dd.options[i].text : "+dd.options[i].text);
	    if (dd.options[i].text === textToFind) {
	        dd.selectedIndex = i;
	        console.log("dd.selectedIndex : "+dd.selectedIndex);
	        break;
	    }
	}
}

function checkPSForm() {
	var paymentModeRows = document.getElementsByClassName("paymentModeRow");
	var modeAdded = false;
	for (var i = 0; i < paymentModeRows.length; i++) {
		var payMode = paymentModeRows[i];
		if (window.getComputedStyle(payMode).display != "none") {
			modeAdded = true;
		}
	}
	if (modeAdded == false) {
		document.getElementById("previewBtn").disabled = true;
		document.getElementById("acceptPaymentBtn").disabled = true;
	} else {
		document.getElementById("previewBtn").disabled = false;
		document.getElementById("acceptPaymentBtn").disabled = false;
	}
}

function changeHeadingAmount(paymentAmountInput) {
	var headAmountLabel = paymentAmountInput.parentElement.parentElement.parentElement.parentElement.parentElement.parentElement
			.getElementsByClassName("headingAmountLabel")[0];
	headAmountLabel.innerHTML = "$" + formatNumbers(paymentAmountInput.value);
	headAmountLabel.value = paymentAmountInput.value;
	changeTotalAmount();
}

function changeCreditTransferBaseAmount() {
	var amount = document.getElementById(namespace + "creditTransferAmount").value;
	var rate = document
			.getElementById(namespace + "creditTransferExchangeRate").value;
	var bamount = parseFloat(amount) * parseFloat(rate);
	document.getElementById(namespace + "creditTransferBAmount").value = bamount;
	changeHeadingAmount(document.getElementById(namespace
			+ "creditTransferBAmount"));
}

function changeTotalAmount() {
	var headingLabels = document.getElementsByClassName("headingAmountLabel");
	var totalAmount = 0;
	for (var i = 0; i < headingLabels.length; i++) {
		console.log("headingLabels[i].value : " + headingLabels[i].value);
		var parentBlock = headingLabels[i].parentElement.parentElement.parentElement.parentElement;
		console.log("headingLabels[i].style.display : "
				+ window.getComputedStyle(parentBlock).display);
		if (window.getComputedStyle(parentBlock).display != "none") {
			if (typeof headingLabels[i].value === "undefined") {
				totalAmount = totalAmount + 0;
			} else {
				totalAmount = totalAmount + parseFloat(headingLabels[i].value);
			}
		}
	}
	var totalReceivableAmount = parseFloat(document
			.getElementById("totalReceivableAmount").value);
	console.log("totalReceivableAmount : " + totalReceivableAmount);
	console.log("totalAmount : " + totalAmount);
	document.getElementById("totalPaymentAmount").value = totalAmount;
	document.getElementById("totalPaymentAmount").innerHTML = formatNumbers(totalAmount);
	document.getElementById("totalOutstandingAmount").value = (totalReceivableAmount
			- totalAmount).toFixed(2);
	document.getElementById("totalOutstandingAmount").innerHTML = formatNumbers(totalReceivableAmount
			- totalAmount);
}

function loadDropdownData(callback) {
	var newPaymentModeList = paymentModeList.slice(0);
	if (selectedNames.length > 1) {
		for ( var pm in newPaymentModeList) {
			console.log("pm : ");
			console.log(newPaymentModeList[pm]);
			if (newPaymentModeList[pm].displayName == "Credit Balance") {
				newPaymentModeList.splice(pm, 1);
			}
		}
	}
	populateCommonDropdownData("paymentMode", newPaymentModeList, function() {
		console.log("modes loaded...");
	});
	populateCommonDropdownData("creditCardType", creditCardTypeList,
			function() {
			});
	downloadVocabularyDropDownData("Currency%20Code", function(data) {
		currencyList = data;
		populateVocabularyDropDownData('creditTransferCurrency', currencyList,
				'id', 'name', function() {
					currencyLoaded = true;
					callback();
				});
	});
	fetchModelData("bankcode", function(bNList) {
		bankNameList = bNList;
		var bankNameDDs = document.getElementsByClassName("bankName");
		for (var i = 0; i < bankNameDDs.length; i++) {
			var dropDownEle = bankNameDDs[i];
			populateModelDataToDropDown(dropDownEle, bankNameList, "BankCode",
					"BankName");
		}
		bankLoaded = true;
		callback();
	});
	getTaxCodeDetail(function(rate) {
		taxRate = rate;
		taxLoaded = true;
		callback();
	});
	if(selectedNames && selectedNames[0].UserId) {
		searchBy([ {
					"contentJson.Status" : [ "Active" ],"contentJson.UserId":[selectedNames[0].UserId],"contentJson.Type":["Credit Balance"]
				} ],[],[],"creditbalance",false,ajaxUrl,function(list) {
					if (list && list.content && list.content.length > 0
							&& list.content.length == 1) {
						console.log(list.content);
						document.getElementById(namespace+"creditBalanceAvailAmount").value = list.content[0].contentJson.CreditBalanceAmt.toFixed(2);
					}
					creditBalanceLoaded = true;
					callback();
		});
	} else {
		creditBalanceLoaded = true;
		callback();
	}
}

function populateExchangeRate() {
	getCurrencyExchangeActiveRate(baseCurrency,
			document.getElementById(namespace + "creditTransferCurrency").value,function(rate) {
		document.getElementById(namespace
				+ "creditTransferExchangeRate").value = rate;
		changeCreditTransferBaseAmount();
	});
}

function closePaymentSection() {
	var elem = document.getElementById("paymentDiv");
	var width = 35;
	var id = setInterval(frame, 10);
	function frame() {
		if (width == 0) {
			document.getElementById("mainDiv").style.display = "none";
			clearInterval(id);
		} else if (width == 30) {
			document.getElementsByClassName("totalDiv")[0].style.display = "none";
			document.getElementsByClassName("totalDiv")[1].style.display = "none";
			width--;
			elem.style.width = width + '%';
		} else {
			width--;
			elem.style.width = width + '%';
		}
	}
	changeTotalAmount();
}
function hidePaymentMode(closeIcon) {
	var parentContainer = closeIcon.parentElement.parentElement.parentElement.parentElement;
	parentContainer.style.display = "none";
	var paymentModeSelect = document.getElementById(namespace + "paymentMode");
	paymentModeSelect.selectedIndex = 0;
	changeTotalAmount();
}
function showPaymentMode() {
	var paymentModeSelect = document.getElementById(namespace + "paymentMode");
	var paymentMode = paymentModeSelect.options[paymentModeSelect.selectedIndex].text;
	console.log("--" + paymentMode.replace(/\s/g, '').toLowerCase());
	var modeDiv = document.getElementById(namespace
			+ paymentMode.replace(/\s/g, '').toLowerCase() + "Row");
	modeDiv.style.display = "block";
	changeTotalAmount();
}
function minimizePaymentMode(minIcon) {
	var parentContainer = minIcon.parentElement.parentElement.parentElement;
	var contentDiv = parentContainer
			.getElementsByClassName("paymentModeContentDiv")[0];
	contentDiv.style.display = "none";
	minIcon.style.display = "none";
	var maxIcon = parentContainer.getElementsByClassName("maximizeIcon")[0];
	maxIcon.style.display = "block";
}
function maximizePaymentMode(maxIcon) {
	var parentContainer = maxIcon.parentElement.parentElement.parentElement;
	var contentDiv = parentContainer
			.getElementsByClassName("paymentModeContentDiv")[0];
	contentDiv.style.display = "block";
	maxIcon.style.display = "none";
	var minIcon = parentContainer.getElementsByClassName("minimizeIcon")[0];
	minIcon.style.display = "block";
}

// button actions
function acceptPayment() {
	if (validatePaymentSection()) {
		if(screen=="misc") {
			saveInvoice(function(){
				saveReceipt("Approved", "Confirmed");
			});
		} else {
			saveReceipt("Approved", "Confirmed");
		}
	} else {
		document.getElementsByClassName("contentScrollDiv")[0].scrollTop = 0;
	}
}

function holdPayment() {
	saveReceipt("Pending", "Pending");
}

function previewPayment() {
	if (validatePaymentSection()) {
		var receiptData = {
			contentJson : getReceiptModel(invoiceList, "Pending", "Pending")
		}
		if(getEID(namespace+"payerFullName")) {
			receiptData.contentJson.NameOfPayer = getEID(namespace+"payerFullName").value;
		}
		exportPdf(null, receiptData);
	} else {
		document.getElementsByClassName("contentScrollDiv")[0].scrollTop = 0;
	}
}

function exportReceipt() {
	exportPdf(formStorageId, null);
}

function cancelPayment() {
	closePaymentSection();
}

function saveInvoice(callback) {
	showLoading(true);
	var invoicing = JSON.parse(invoiceList[0].contentJson);
	invoicing.formType = "invoicing";
	invoicing.ApprovalStatus = "Approved";
	invoicing.TransactionStatus = "Confirmed";
	invoicing.TransactionMasterCode=generateCode("IN-");
	console.log("invoicing");
	console.log(invoicing);
	ajaxCallAPI('POST', 'persist', invoicing, function() {
		let data = this.get("responseData");
		if (data.error) {
			displayMessage('danger', data.error, 3000);
		} else if (Object.keys(data).length === 0) {
			displayMessage('danger', 'Form submission failed.', 3000);
		} else {
			invoiceList = [{
				"contentJson" : JSON.stringify(invoicing)
			}];
			callback(invoicing);
		}
		showLoading(false);
	}, function() {
		displayMessage('danger', "Failed to save receipt", 3000);
		showLoading(false);
	});
}

function saveReceipt(approvalStatus, transStatus) {
	showLoading(true);
	var receipt = getReceiptModel(invoiceList, approvalStatus, transStatus);
	console.log("receipt : " + JSON.stringify(receipt));
	receipt.formType = "invoicing";
	if(holdReceipt) {
		receipt.formStorageId = holdReceipt.storageId;
	}
	ajaxCallAPI('POST', 'persist', receipt, function() {
		let
		data = this.get("responseData");
		if (data.error) {
			displayMessage('danger', data.error, 3000);
		} else if (Object.keys(data).length === 0) {
			displayMessage('danger', 'Form submission failed.', 3000);
		} else {
			formStorageId = data.storageId;
			console.log("formStorageId : " + formStorageId);
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
	},
			function() {
				displayMessage('danger',
						"Error in persisting dynamic form data.", 3000);
				showLoading(false);
			});
}

function userSelected(userId) {
	for(var si in selectedNames) {
		var suser = selectedNames[si];
		if(userId == suser.UserId) {
			return true;
		}
	}
	return false;
}

function getReceiptModel(invoices, approvalStatus, transStatus) {
	var receipt = {};
	var firstInvoice = JSON.parse(invoices[0].contentJson);
	receipt = firstInvoice;
	receipt.CategoryMap = JSON.stringify(categoryMap);
	receipt.SourceTypeMap = JSON.stringify(sourceTypeMap);
	var out = document.getElementById("totalOutstandingAmount").value;
	if(parseFloat(out)<0) {
		receipt.Overpayment = true;
	}
	receipt.Notes = (typeof notes === "undefined")?"":notes;
	receipt.TransactionMasterCode = generateCode("RC-");
	receipt.CategoryType = categoryMap['RE'];
	receipt.TxnType = categoryMap['RE'];
	receipt.ApprovalStatus = approvalStatus;
	receipt.RequestType = "New Receipt";
	receipt.TransactionStatus = transStatus;
	receipt.ComponentRefNumber = "";
	receipt.IdName = document.getElementById(namespace+"payerFullName").value;
	for (var invInd = 0; invInd < invoices.length; invInd++) {
		var currInv = JSON.parse(invoices[invInd].contentJson);
		receipt.ComponentRefNumber = receipt.ComponentRefNumber
				+ currInv.TransactionMasterCode + ",";
	}
	receipt.ComponentRefNumber = receipt.ComponentRefNumber
			.replace(/,\s*$/, "");
	receipt.TransactionDetails = [];
	console.log("receipt : " + JSON.stringify(receipt));
	console.log("receipt.ApprovalStatus : " + receipt.ApprovalStatus);
	for (var k = 0; k < invoices.length; k++) {
		console.log("invoice : " + invoices[k].contentJson);
		var invoice = JSON.parse(invoices[k].contentJson);
		for (var j = 0; j < invoice.TransactionDetails.length; j++) {
			console.log("details : ")
			console.log(invoice.TransactionDetails[j]);
			if(clientType == "CORPORATE" || clientType == "Anonymous" || userSelected(invoice.TransactionDetails[j].userId)) {
				receipt.TransactionDetails.push(invoice.TransactionDetails[j]);
			} else {
				console.log("not selected...");
			}
		}
	}
	console.log("receipt.TransactionDetails : ");
	console.log(receipt.TransactionDetails);
	var paymentDetailArray = [];
	var paymentModeRows = document.getElementsByClassName("paymentModeRow");
	for (var i = 0; i < paymentModeRows.length; i++) {
		var payMode = paymentModeRows[i];
		var paymentDetails = {};
		if (window.getComputedStyle(payMode).display != "none") {
			if (payMode.id == namespace + "cashRow") {
				paymentDetails.paymentModeType = "Cash";
				paymentDetails.paymentAmount = document
						.getElementById(namespace + "cashPaymentAmount").value;
			} else if (payMode.id == namespace + "creditbalanceRow") {
				paymentDetails.paymentModeType = "Credit Balance";
				paymentDetails.paymentAmount = document
						.getElementById(namespace
								+ "creditBalancePaymentAmount").value;
			} else if (payMode.id == namespace + "chequeRow") {
				paymentDetails.paymentModeType = "Cheque";
				paymentDetails.paymentAmount = document
						.getElementById(namespace + "chequePaymentAmount").value;
				paymentDetails.additionalMetadata = document
					.getElementById(namespace + "chequeAmount").value
				paymentDetails.bankName = document.getElementById(namespace
						+ "chequeBankName").value;
				paymentDetails.paymentRefNo = document.getElementById(namespace
						+ "chequeNumber").value;
			} else if (payMode.id == namespace + "bankdraftRow") {
				paymentDetails.paymentModeType = "Bank Draft";
				paymentDetails.paymentAmount = document
						.getElementById(namespace + "bankDraftPaymentAmount").value;
				paymentDetails.bankName = document.getElementById(namespace
						+ "bankDraftBankName").value;
				paymentDetails.paymentRefNo = document.getElementById(namespace
						+ "bankDraftRefNumber").value;
			} else if (payMode.id == namespace + "creditcardRow") {
				paymentDetails.paymentModeType = creditCardTypeMap[document
				.getElementById(namespace + "creditCardType").value];
				paymentDetails.paymentAmount = document
						.getElementById(namespace + "creditCardPaymentAmount").value;
				paymentDetails.remarks = document.getElementById(namespace
						+ "creditCardName").value;
			} else if (payMode.id == namespace + "axsRow") {
				paymentDetails.paymentModeType = "AXS";
				paymentDetails.paymentAmount = document
						.getElementById(namespace + "axsPaymentAmount").value;
				paymentDetails.paymentRefNo = document.getElementById(namespace
						+ "axsTransNumber").value;
			} else if (payMode.id == namespace + "netsRow") {
				paymentDetails.paymentModeType = "NETS";
				paymentDetails.paymentAmount = document
						.getElementById(namespace + "netsPaymentAmount").value;
				paymentDetails.paymentRefNo = document.getElementById(namespace
						+ "netsRefNumber").value;
			} else if (payMode.id == namespace + "inwardremittanceRow") {
				paymentDetails.paymentModeType = "Inward Remittance";
				paymentDetails.paymentAmount = document
						.getElementById(namespace + "inwardRemitPaymentAmount").value;
				paymentDetails.bankName = document.getElementById(namespace
						+ "inwardRemitBankName").value;
				paymentDetails.paymentRefNo = document.getElementById(namespace
						+ "inwardRemitTransNumber").value;
			} else if (payMode.id == namespace + "credittransferRow") {
				paymentDetails.paymentModeType = "Credit Transfer";
				paymentDetails.paymentAmount = document
						.getElementById(namespace + "creditTransferBAmount").value;
				paymentDetails.paymentRefNo = document.getElementById(namespace
						+ "creditTransferTransactionNumber").value;
			} else if (payMode.id == namespace + "othersRow") {
				paymentDetails.paymentModeType = "Others";
				paymentDetails.paymentAmount = document
						.getElementById(namespace + "othersPaymentAmount").value;
				paymentDetails.description = document.getElementById(namespace
						+ "othersDesc").value;
			}
			paymentDetails.currency = baseCurrency;
			paymentDetails.txnStatus = "Confirmed";
			paymentDetails.payerName = document.getElementById(namespace
					+ "payerFullName").value;
			paymentDetailArray.push(paymentDetails);
		}
	}
	receipt.PaymentDetails = paymentDetailArray;
	return receipt;
}

function validatePaymentSection() {
	changeTotalAmount();
	var payerName = document.getElementById(namespace + "payerFullName").value;
	var outstanding = document.getElementById("totalOutstandingAmount").value
	var paymentModeRows = document.getElementsByClassName("paymentModeRow");
	var creditBalanceUsed = false;
	if (payerName.trim() == "") {
		displayMessage('danger', "Payer name can not be empty", 3000);
		return false;
	}
	if (outstanding > 0) {
		displayMessage('danger', "There is outstanding amount to be paid", 3000);
		return false;
	}
	for (var i = 0; i < paymentModeRows.length; i++) {
		var payMode = paymentModeRows[i];
		if (window.getComputedStyle(payMode).display != "none") {
			if (payMode.id == namespace + "creditbalanceRow") {
				var creditBalance = document.getElementById(namespace
						+ "creditBalanceAvailAmount").value;
				var paymentAmount = document.getElementById(namespace
						+ "creditBalancePaymentAmount").value;
				if (paymentAmount > creditBalance) {
					displayMessage(
							'danger',
							"Payment amount can not be more than credit balance",
							3000);
					return false;
				}
				creditBalanceUsed = true;
			} else if (payMode.id == namespace + "chequeRow") {
				var bankNameCq = document.getElementById(namespace
						+ "chequeBankName").value;
				var refNoCq = document.getElementById(namespace
						+ "chequeNumber").value;
				var checkAmt = document.getElementById(namespace
						+ "chequeAmount").value;
				var payAmt = document.getElementById(namespace
						+ "chequePaymentAmount").value;
				if (bankNameCq.trim() == "") {
					displayMessage('danger', "Please select bank name", 3000);
					return false;
				}
				if (refNoCq.trim() == "") {
					displayMessage('danger', "Cheque number can not be empty",
							3000);
					return false;
				}
				if (checkAmt.trim() == "") {
					displayMessage('danger', "Cheque amount can not be empty",
							3000);
					return false;
				}
				console.log(payAmt + ">" + checkAmt + " : "
						+ (payAmt > checkAmt));
				if (parseFloat(payAmt) > parseFloat(checkAmt)) {
					displayMessage(
							'danger',
							"Payment amount can not be more than cheque amount",
							3000);
					return false;
				}
			} else if (payMode.id == namespace + "bankdraftRow") {
				var bankNameBd = document.getElementById(namespace
						+ "bankDraftBankName").value;
				var refNoBd = document.getElementById(namespace
						+ "bankDraftRefNumber").value;
				if (bankNameBd.trim() == "") {
					displayMessage('danger', "Please select bank name", 3000);
					return false;
				}
				if (refNoBd.trim() == "") {
					displayMessage('danger', "Draft number can not be empty",
							3000);
					return false;
				}
			} else if (payMode.id == namespace + "creditcardRow") {
				var cardType = document.getElementById(namespace
						+ "creditCardType").value;
				var nameOnCard = document.getElementById(namespace
						+ "creditCardName").value;
				if (cardType.trim() == "") {
					displayMessage('danger', "Please select credit card type",
							3000);
					return false;
				}
				if (nameOnCard.trim() == "") {
					displayMessage('danger', "Name on card can not be empty",
							3000);
					return false;
				}
			} else if (payMode.id == namespace + "axsRow") {
				var refNoAxn = document.getElementById(namespace
						+ "axsTransNumber").value;
				if (refNoAxn.trim() == "") {
					displayMessage('danger',
							"Transaction number can not be empty", 3000);
					return false;
				}
			} else if (payMode.id == namespace + "inwardremittanceRow") {
				var bankNameIr = document.getElementById(namespace
						+ "inwardRemitBankName").value;
				var refNoIr = document.getElementById(namespace
						+ "inwardRemitTransNumber").value;
				if (bankNameIr.trim() == "") {
					displayMessage('danger', "Please select bank name", 3000);
					return false;
				}
				if (refNoIr.trim() == "") {
					displayMessage('danger',
							"Transaction number can not be empty", 3000);
					return false;
				}
			} else if (payMode.id == namespace + "credittransferRow") {
				var currency = document.getElementById(namespace
						+ "creditTransferCurrency").value;
				var refNoCt = document.getElementById(namespace
						+ "creditTransferTransactionNumber").value;
				if (refNoCt.trim() == "") {
					displayMessage('danger',
							"Transaction number can not be empty", 3000);
					return false;
				}
				if (currency.trim() == "") {
					displayMessage('danger', "Please select currency", 3000);
					return false;
				}
			} else if (payMode.id == namespace + "othersRow") {
				var desc = document.getElementById(namespace + "othersDesc").value;
				if (desc.trim() == "") {
					displayMessage('danger', "Description can not be empty",
							3000);
					return false;
				}
			}
		}
	}

	if (creditBalanceUsed && outstanding < 0) {
		displayMessage(
				'danger',
				"Overpayment is not allowed if payment is done via credit balance",
				6000);
		return false;
	}
	if(outstanding < 0 && screen=="normal" && selectedNames && selectedNames.length>1) {
		displayMessage(
				'danger',
				"Overpayment is not allowed for multiple payments",
				6000);
		return false;
	}
	if(outstanding < 0 && screen=="misc") {
		var fullname = "";
		if(selectedNames && selectedNames[0].FullName) {
			fullname = selectedNames[0].FullName;
		}
		if(!fullname || fullname.trim()=="") {
			displayMessage(
					'danger',
					"Overpayment is not allowed for Anonymous",
					6000);
			return false;
		}
	}
	
	return true;
}

function populateMode(pm) {
	var paymentDetails = pm;
	var paymentAmountEle = null;
	if (paymentDetails.paymentModeType=="Cash") {
		paymentAmountEle = document.getElementById(namespace + "cashPaymentAmount");
	} else if (pm.paymentModeType=="Credit Balance") {
		paymentAmountEle = document.getElementById(namespace+ "creditBalancePaymentAmount");
	} else if (pm.paymentModeType=="Cheque") {
		paymentAmountEle = document.getElementById(namespace + "chequePaymentAmount");
		document.getElementById(namespace + "chequeBankName").value = paymentDetails.bankName;
		document.getElementById(namespace+ "chequeNumber").value = paymentDetails.paymentRefNo;
		document.getElementById(namespace+ "chequeAmount").value = paymentDetails.additionalMetadata;
	} else if (pm.paymentModeType=="Bank Draft") {
		paymentAmountEle = document.getElementById(namespace + "bankDraftPaymentAmount");
		document.getElementById(namespace + "bankDraftBankName").value = paymentDetails.bankName;
		document.getElementById(namespace + "bankDraftRefNumber").value = paymentDetails.paymentRefNo;
	} else if (pm.paymentModeType == "VISA"
		|| pm.paymentModeType == "MASTER" || pm.paymentModeType == "JCB" 
			|| pm.paymentModeType == "Diners" || pm.paymentModeType == "AMEX") {
		selectMode(document.getElementById(namespace+"creditCardType"), pm.paymentModeType);
		paymentAmountEle = document.getElementById(namespace + "creditCardPaymentAmount");
		document.getElementById(namespace + "creditCardName").value = paymentDetails.remarks;
	} else if (pm.paymentModeType == "AXS") {
		paymentAmountEle = document.getElementById(namespace + "axsPaymentAmount");
		document.getElementById(namespace + "axsTransNumber").value = paymentDetails.paymentRefNo;
	} else if (pm.paymentModeType == "NETS") {
		paymentAmountEle = document.getElementById(namespace + "netsPaymentAmount");
		document.getElementById(namespace + "netsRefNumber").value = paymentDetails.paymentRefNo;
	} else if (pm.paymentModeType=="Inward Remittance") {
		paymentAmountEle = document.getElementById(namespace + "inwardRemitPaymentAmount");
		document.getElementById(namespace + "inwardRemitBankName").value = paymentDetails.bankName;
		document.getElementById(namespace + "inwardRemitTransNumber").value = paymentDetails.paymentRefNo;
	} else if (pm.paymentModeType=="Credit Transfer") {
		paymentAmountEle = document.getElementById(namespace + "creditTransferBAmount");
		document.getElementById(namespace + "creditTransferTransactionNumber").value = paymentDetails.paymentRefNo;
	} else if (pm.paymentModeType=="Other") {
		paymentAmountEle = document.getElementById(namespace + "othersPaymentAmount");
		document.getElementById(namespace + "othersDesc").value = paymentDetails.description;
	}
	if(paymentAmountEle != null) {
		paymentAmountEle.value = paymentDetails.paymentAmount;
		changeHeadingAmount(paymentAmountEle);
	}
}