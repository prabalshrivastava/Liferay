//settlement method dashed-box
var settlementMethodHolder = document.getElementById('settlementMethodHolder');
var settlementMethodContainer = document
		.getElementById('settlementMethodContainer');
var settlementMethodScreen = document.getElementById('settlementMethodBase');


var paymentModeList = [];
var data, contentdata;
var productSubTypeList = [];
var modelName = "FinanceParameter";
showLoading(true);
console.log("document.readyState : "+document.readyState);
function init() {
	console.log("onload...");
	console.log("onload - settlementMethodHolder : "+settlementMethodHolder.hasChildNodes());
	while (settlementMethodHolder.hasChildNodes()) {
		settlementMethodHolder.removeChild(settlementMethodHolder.lastChild);
	}
	loadDefaultData(function() {
		
		setInterval(function() {
			checkForm();
		}, 1000);
		console.log("onload - mode : "+mode);
		if (mode == "create") {
			AddAnotherPaymentMode();
		}
	});
	
}
if(document.readyState == 'complete') {
	init();
} else {
	window.addEventListener('load', init);
}

function Payment(paymentMode,settlementGlCodeId , deleteStatus) {
	this.paymentMode = paymentMode;
	this.settlementGlCodeId = settlementGlCodeId;
	this.deleteStatus = deleteStatus;
}

function loadDefaultData(callback) {
	console.log("loadDefaultData - mode : "+mode);
	downloadDropdownData("Exam");
		if (mode != "create") {
			fetchDetails(formStorageId);
		} else {
			getEID("formStatus").innerHTML = "Draft";
			getEID("formStatus").className = "";
			getEID("formStatus").classList.add("formStatus");
			getEID("formStatus").classList.add("form_draft");
			showLoading(false);
		}
		callback();
	}




function fetchDetails(formStorageId) {
	showLoading(true);
	if (formStorageId != "") {
		data = {};
		data.formStorageId = formStorageId;
		data.formType = "financeParameter";
		ajaxCallAPI(
				'GET',
				"loadData",
				data,
				function() {
					data = this.get("responseData");
					contentdata = this.get("responseData");
					console.log("contentdata : " + JSON.stringify(contentdata));
					if (data.error) {
						displayMessage('danger', data.error, 3000);
					} else {
						var sc = contentdata.contentJson.ParameterSetupCode;
						if (mode == "copy") {
							sc = "Copy-of-" + sc;
						}
						getEID(namespace + "parameterSetupCode").value = sc;
						if(mode=="edit") {
							if(contentdata.contentJson.Status=="Draft") {
								getEID("status").value = "Active";
								
							} else {
								getEID("status").value = contentdata.contentJson.Status;
							}
						}
						getEID(namespace + "productType").value = contentdata.contentJson.ProductType;
						getEID(namespace + "productSubType").value = contentdata.contentJson.ProductSubType;
						getEID(namespace + "assetSuspenseGlCode").value = contentdata.contentJson.AssetSuspenseGlCode;
						getEID(namespace + "liabilitySuspenseGlCode").value = contentdata.contentJson.LiabilitySuspenseGlCode;
						getEID(namespace + "defaultProfitCentre").value = contentdata.contentJson.DefaultProfitCentre;
						getEID(namespace + "glPostingOption").value = contentdata.contentJson.GlPostingOption;
						getEID(namespace + "internalClient").value = contentdata.contentJson.InternalClient;
						
						var settlementMethods = contentdata.contentJson.SettlementMethods;

						settlementMethodContainer = settlementMethodScreen;
						getEID("formStatus").innerHTML = contentdata.contentJson.Status;
						getEID("formStatus").className = "";
						getEID("formStatus").classList.add("formStatus");
						getEID("formStatus").classList.add("form_"+contentdata.contentJson.Status.toLowerCase());
						addAllDataToArray();
						for (var i = 0; i < settlementMethods.length; i++) {
							var ss = new Payment(settlementMethods[i].paymentMode,
									settlementMethods[i].settlementGlCodeId,"Active");
							paymentModeList.push(ss);
						}
						drawPaymentMode();
						if (mode == "edit"
								&& contentdata.contentJson.Status == "Inactive") {
							getEID("activate").style.display = "";
							getEID("deactivate").style.display = "none";
						} else if (mode == "edit") {
							getEID("activate").style.display = "none";
							getEID("deactivate").style.display = "";
							getEID(namespace + "assetSuspenseGlCode").disabled = true;
							getEID(namespace + "liabilitySuspenseGlCode").disabled = true;
							/*document.getElementsByClassName("removeBtn")[0].style.visibility = 'hidden';*/
						}
					}
					if (mode == "view") {
						enableViewMode();
					}
					showLoading(false);
				}, function() {
					displayMessage('danger',
							"Error in persisting dynamic form data.", 3000);
					showLoading(false);
				});
	}
}

function storageStatus1(status, storageId) {
	var popupdiv;
	var popupdivbox;
	if (status == 'Active') {
		popupdiv = "#active-record";
		popupdivbox = "#active-record-box";
		updateStorageStatus1(status, storageId);
	} else if (status == 'Inactive') {
		popupdiv = "#deactive-record";
		popupdivbox = "#deactive-record-box";
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

												Y.one('.close').on('click',
														function() {
															modal.hide();
														});
												Y
														.one(
																'.popup-cancel-deactivate')
														.on(
																'click',
																function() {
																	modal
																			.hide();
																});

												Y
														.one(
																'.popup-confirm-deactivate')
														.on(
																'click',
																function() {

																	if (document
																			.getElementById("deactivate_reason").value.length > 4) {
																		updateStorageStatus1(
																				status,
																				storageId);
																		modal
																				.hide();
																	} else {
																		document
																				.getElementById("deactivate_msg").classList
																				.add("alert");
																		document
																				.getElementById("deactivate_msg").classList
																				.add("alert-error");
																	}

																});

											});

						});
	}

}
function updateStorageStatus1(status, storageId) {
	showLoading(true);
	var inactiveReason = "";
	if (status.toLowerCase() == 'inactive') {
		inactiveReason = document.getElementById("deactivate_reason").value;
	}

	ajaxCall('GET', 'loadData', ajaxUrl, {
		"formType" : modelName,
		"formStorageId" : encodeURIComponent(storageId)
	}, function() {
		var data = this.get("responseData");
		if (data == null || data == "") {
			console.log("error");

		} else {
			var data1 = data.contentJson;
			data1.Status = status;
			data1.InactiveReason = inactiveReason;
			data1.formType = modelName;
			data1.formStorageId = encodeURIComponent(storageId);

			ajaxCall('GET', 'update', ajaxUrl, data1, function() {
				console.log("hhh");
				var data = this.get("responseData");
				console.log("data : "+JSON.stringify(data));
				if (_.isEmpty(data)) {
					console.log("error");
				} else {
					//loadList();
					showPopupSuccess(status, storageId);
				}
				showLoading(false);
				//window.location.reload();
			}, function() {
				console.log("eee");
				showLoading(false);
			});
		}
	}, function() {
		showLoading(false);
	});
}

function showPopupSuccess(status, d) {

	AUI().use('aui-base', function(A) {
		var boundingBox, contentBox;
		if (status.toLowerCase() == 'inactive') {
			boundingBox = "#deactivation-success";
			contentBox = "#inactive-success-box";
		}
		if (status.toLowerCase() == 'active') {
			boundingBox = "#activation-success";
			contentBox = "#active-success-box";
		}
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

			Y.one('.close').on('click', function() {

				modal.hide();
			});
		});

	});
}

function enableViewMode() {
	var form = document.getElementById("financeParameter_form");
	var elements = form.elements;
	for (var i = 0, len = elements.length; i < len; ++i) {
		elements[i].readOnly = true;
		elements[i].disabled = true;
	}
}

function drawPaymentMode() {
	console.log("drawPaymentMode - settlementMethodHolder : "+settlementMethodHolder.hasChildNodes());
	var count = 0;
	var i;
	while (settlementMethodHolder.hasChildNodes()) {
		settlementMethodHolder.removeChild(settlementMethodHolder.lastChild);
	}
	console.log("drawPaymentMode - paymentModeList : "+JSON.stringify(paymentModeList));
	for (i = 0; i < paymentModeList.length; i++) {
		var node = settlementMethodContainer.cloneNode(true);
		var header = node.getElementsByClassName("header")[0]
				.getElementsByTagName("div")[0];
		
		
		var paymentMode=node.getElementsByClassName("paymentMode")[0];
		var settlementGlCodeId=node.getElementsByClassName("settlementGlCodeId")[0];
		
		settlementGlCodeId.value = paymentModeList[i].settlementGlCodeId;
		var paymentModeOptionArray = paymentMode
				.getElementsByTagName("option");
		for (var j = 0; j < paymentModeOptionArray.length; j++) {
			if (paymentModeOptionArray[j].value === paymentModeList[i].paymentMode) {
				paymentModeOptionArray[j].selected = true;
				break;
			}
		}
		
		node.getElementsByClassName("deleteStatus")[0].innerHTML = paymentModeList[i].status;
		
		console.log("paymentModeList[i].deleteStatus : "
				+ paymentModeList[i].deleteStatus);
		if (paymentModeList[i].deleteStatus != "Remove") {
			count = count + 1;
				if (count < 9) {
					header.innerText = "0"+ count+" SETTLEMENT METHOD";
				} else {
					header.innerText = count+" SETTLEMENT METHOD";
				}
			node.style.display = "block";
			settlementMethodHolder.appendChild(node);
		}
	}
}



function addAllDataToArray() {
	console.log("addAllDataToArray - paymentModeList : "+paymentModeList.length);
	while (paymentModeList.length > 0) {
		paymentModeList.pop();
	}
	console.log("addAllDataToArray - settlementMethodHolder.childElementCount : "+settlementMethodHolder.childElementCount);
	var c = settlementMethodHolder.childElementCount;
	for (var i = 0; i < c; i++) {
		var node = settlementMethodHolder.childNodes[i];
		console.log("node : "+node.html);
		var ss = null;
		var paymentMode = node.getElementsByClassName("paymentMode")[0];
		var settlementGlCodeId = node.getElementsByClassName("settlementGlCodeId")[0];
		var deleteStatus = node.getElementsByClassName("deleteStatus")[0];
		console.log("deleteStatus : " + deleteStatus.innerHTML);
		if (deleteStatus.innerHTML != "Remove") {
			ss = new Payment(paymentMode.options[paymentMode.selectedIndex].value, settlementGlCodeId.value,
					 deleteStatus.innerHTML);
			paymentModeList.push(ss);
		}
	}
}


function AddAnotherPaymentMode() {
	settlementMethodContainer = settlementMethodScreen;
	addAllDataToArray();
	var ss = new Payment("", "null", "");
	paymentModeList.push(ss);
	drawPaymentMode();
}

function RemovePaymentMode(e) {
	var eRmv = e.parentElement.parentElement.parentElement.parentElement;
	eRmv.getElementsByClassName("deleteStatus")[0].innerHTML = "Remove";
	addAllDataToArray();
	drawPaymentMode();
	console.log("paymentModeList.length : " + paymentModeList.length);
	if (paymentModeList.length == 0) {
		AddAnotherPaymentMode();
	}
}

function validateFields(action) {
	if (checkIsValide()) {
		submitFinanceParameter(action);
	}
}

function checkIsValide() {
	var eValid = true;
	addAllDataToArray();
	if (getEID(namespace + 'productType').value.trim() == "") {
		eValid = false;
		displayMessage('danger', "Product Type is Mandatory", 3000);
	} else if (getEID(namespace + 'assetSuspenseGlCode').value.trim() == "" || getEID(namespace + 'assetSuspenseGlCode').value=="null") {
		eValid = false;
		displayMessage('danger', "Asset Suspense GlCode is Mandatory", 3000);
	} else if (getEID(namespace + 'liabilitySuspenseGlCode').value.trim() == "" || getEID(namespace + 'liabilitySuspenseGlCode').value=="null") {
		eValid = false;
		displayMessage('danger', "Liability  Suspense GlCode is Mandatory", 3000);
	} else if (getEID(namespace + 'defaultProfitCentre').value.trim() == "" || getEID(namespace + 'defaultProfitCentre').value=="null") {
		eValid = false;
		displayMessage('danger', "Default Profit Centre is Mandatory", 3000);
	} else if (getEID(namespace + 'glPostingOption').value.trim() == "") {
		eValid = false;
		displayMessage('danger', "Gl Posting Option is Mandatory", 3000);
	} else if (getEID(namespace + 'internalClient').value.trim() == "") {
		eValid = false;
		displayMessage('danger', "Internal Client is Mandatory", 3000);
	} else if (paymentModeList.length == 0) {
		eValid = false;
		displayMessage('danger', "At least one settlement method is required",
				3000);
	} else {
		for (var i = 0; i < paymentModeList.length; i++) {
			console.log("paymentModeList[i].settlementGlCodeId : "
					+ paymentModeList[i].settlementGlCodeId);
			if (paymentModeList[i].settlementGlCodeId == "" || paymentModeList[i].settlementGlCodeId=="null") {
				eValid = false;
				displayMessage('danger', "Settlement GlCode is Mandatory", 3000);
				break;
			}
			if (paymentModeList[i].paymentMode == "") {
				eValid = false;
				displayMessage('danger', "PaymentMode is Mandatory", 3000);
				break;
			}
		}
	}
	
	return eValid;
}

function submitFinanceParameter(action) {
	showLoading(true);
	var productType = getEID(namespace + "productType");
	var productSubType = getEID(namespace + "productSubType");
	var assetSuspenseGlCode = getEID(namespace + "assetSuspenseGlCode");
	var liabilitySuspenseGlCode = getEID(namespace + "liabilitySuspenseGlCode");
	var defaultProfitCentre = getEID(namespace + "defaultProfitCentre");
	var glPostingOption=getEID(namespace + "glPostingOption");
	var internalClient=getEID(namespace + "internalClient");
	
	
	var payment={};
	payment.ParameterSetupCode=generateParameterSetupCode();
	payment.ProductType=productType.value;
	payment.ProductSubType=productSubType.value;
	payment.AssetSuspenseGlCode=assetSuspenseGlCode.value.trim();
	payment.LiabilitySuspenseGlCode=liabilitySuspenseGlCode.value.trim();
	payment.DefaultProfitCentre=defaultProfitCentre.value.trim();
	payment.GlPostingOption=glPostingOption.value;
	payment.InternalClient=internalClient.value.trim();
	
	payment.SettlementMethods = [];
	
	for (var i = 0; i < paymentModeList.length; i++) {
		var settlementMethod = {};
		var settlementMethodData = paymentModeList[i];
		settlementMethod.paymentMode = settlementMethodData.paymentMode;
		settlementMethod.settlementGlCodeId = settlementMethodData.settlementGlCodeId.trim();
		
		console.log("Settlement data, Payment Mode ::"+settlementMethod.paymentMode +" , SettlementGlCodeId="+settlementMethod.settlementGlCodeId)
		payment.SettlementMethods.push(settlementMethod);
	}
	if(mode=="edit") {
		payment.Status = getEID("status").value;
		payment.formStorageId = formStorageId;
	} else {
		if (action == "publish") {
			payment.Status = "Active";
		} else {
			payment.Status = "Draft";
		}
	}
	payment.formType = "financeParameter";
	console.log(payment);
	console.log(JSON.stringify(payment));
	ajaxCallAPI('POST', 'persist', payment, function() {
		let data = this.get("responseData");
		if (data.error) {
			displayMessage('danger', data.error, 3000);
		} else if (Object.keys(data).length === 0) {
			console.log("data : "+data);
			displayMessage('danger', 'Form submission failed.', 3000);
		} else {
			console.log(data.toString());
			var message = "Form successfully submitted.";
			if (payment.Status == "Draft")
				message = "Record is saved in draft";
			displayMessage('success', message, 3000);
			afterFormSubmissionFormIOForm(payment);
		}
		showLoading(false);
	}, function() {
		displayMessage('danger', "Error in persisting dynamic form data.", 3000);
		showLoading(false);
	});
}

function afterFormSubmissionFormIOForm(data) {
	console.log("data : " + JSON.stringify(data));
	console.log("data.formStorageId : " + data.formStorageId);
	var status = data.Status;
	var formType = "Finance Parameter";
	console.log("status : " + status);
	var msg = "";
	var boundingBox = "#sucess-popup";
	var contentBox = "#sucess-popup-box";
	if (status == "Draft") {
		msg = formType + " saved to Draft";
	} else if (data.formStorageId == "0" || data.formStorageId == ""
			|| data.formStorageId == null
			|| typeof data.formStorageId === 'undefined') {
		msg = formType + " Created!";
	} else if (status == "Active" && data.reactive) {
		msg = formType + " Updated!";
		boundingBox = "#activation-success";
		contentBox = "#active-success-box";
	} else if (status == "Active") {
		msg = formType + " Updated!";
	} else if (status == "Inactive") {
		msg = formType + " Updated!";
		boundingBox = "#deactivation-success";
		contentBox = "#inactive-success-box";
	}
	document.getElementById('success-msg').innerHTML = msg;
	AUI().use('aui-base', function(A) {

		A.one(boundingBox).set('hidden', false);

		YUI().use('aui-modal', function(Y) {
			new Y.Modal({
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
		});

	});
}

function ebableOnceValide() {
	setInterval(function() {
		checkIsValide();
	}, 1000);
}

function checkForm() {
	if (document.getElementById(namespace + "assetSuspenseGlCode").value.trim() != ""
			&& document.getElementById(namespace + "liabilitySuspenseGlCode").value.trim() != ""
				&& document.getElementById(namespace + "defaultProfitCentre").value.trim() != ""
					/*&& document.getElementById(namespace + "internalClient").value.trim() != ""*/) {
		if (mode == "copy" || mode == "create") {
			document.getElementById("draft").disabled = false;
			document.getElementById("publish").disabled = false;
		} else if (mode == "edit") {
			document.getElementById("deactivate").disabled = false;
			document.getElementById("update").disabled = false;
		}
	} else {
		if (mode == "copy" || mode == "create") {
			document.getElementById("draft").disabled = true;
			document.getElementById("publish").disabled = true;
		} else if (mode == "edit") {
			document.getElementById("deactivate").disabled = true;
			document.getElementById("update").disabled = true;
		}
	}
}

function reset() {
	document.getElementById("financeParameter_form").reset();
}

function getEID(element) {
	return document.getElementById(element);
}

function showAlertDiv(msg) {
	var showAlertDiv = getEID('form-error-div');
	var errorDiv = getEID('error_msg');
	showAlertDiv.style.display = "block";
	errorDiv.innerHTML = msg;
}

function showLoading(show) {
	if(show) {
		getEID("loadingDiv").style.display = "block";
	} else {
		getEID("loadingDiv").style.display = "none";
	}
}

function moveToList() {
	window.location.href = baseUrl;
}
function generateParameterSetupCode() {
	if(mode=="edit") {
		 return getEID(namespace +"parameterSetupCode").value;
	} else if (mode=="copy") {
		return getEID(namespace+"parameterSetupCode").value;
	} else {
		var date = new Date();
		var now_utc =  Date.UTC(date.getUTCFullYear(), date.getUTCMonth(), date.getUTCDate(),
				 date.getUTCHours(), date.getUTCMinutes(), date.getUTCSeconds());
		return "FP-"+now_utc;
	}
}

function closeSettlementMethod(closeIcon) {
	var eRmv = closeIcon.parentElement.parentElement.parentElement.parentElement;
	console.log("eRmv : "+eRmv.id);
	var subSchemeDiv = eRmv.getElementsByClassName("settlementMethodContent")[0];
	if(subSchemeDiv.style.display!="none") {
		subSchemeDiv.style.display = "none";
		closeIcon.style.background = "url(/html/images/expand.png) no-repeat";
	} else {
		subSchemeDiv.style.display = "block";
		closeIcon.style.background = "url(/html/images/close-minus.png) no-repeat";
	}
}


function downloadDropdownData(productType) {
	var strSubURI ="finance.accountingtable."+productType.toLowerCase()+".producsubtype";
	console.log("dashBoardLink : "+window.location.origin);
	var listUrl=window.location.origin+"/api/jsonws/SPServices-portlet.splisttype/get-list-by-key/key/$VCNAME/group-id/"+groupId;
	var ajaxUrl =listUrl.replace("$VCNAME", strSubURI);
	console.log("ajaxUrl : "+ajaxUrl);
	AUI()
			.use(
					'aui-base',
					'aui-io-request-deprecated',
					function(A) {
						var _data = {};

						A.io
								.request(
										ajaxUrl,
										{
											dataType : 'json',
											method : "GET",
											data : _data,
											on : {
												success : function() {
													var responseData = this
															.get('responseData');
													productSubTypeList = responseData;
													console.log("productSubTypeList : "+productSubTypeList.length);
													populateProductSubType();
												},
												failure : function() {
													console
															.log("Error in the ajax call.");
												}
											}
										});
					});


}	

function populateProductSubType() {
	var productSubType = getEID(namespace+"productSubType");
	getEID(namespace+"productSubType").innerHTML="";
	var opt = new Option(
			"Select Product Sub Type...",
			"");
	productSubType.options[productSubType.options.length] = opt;
	for (var j = 0; j < productSubTypeList.length; j++) {
		console.log("productSubTypeList[j] : "+JSON.stringify(productSubTypeList[j]));
		var option = new Option(
				productSubTypeList[j].displayName,
				productSubTypeList[j].itemValue);
		productSubType.options[productSubType.options.length] = option;
	}
}
