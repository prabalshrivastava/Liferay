var modelName = "TransactionFee";
var data, contentdata;
var priceSchemeList = [];
var priceSubSchemeList = [];
var fcLoaded = false;
var asLoaded = false;
var psLoaded = false;
var pssLoaded = false;

showLoading(true);
console.log("document.readyState : "+document.readyState);
function init() {
	fcLoaded = false;
	asLoaded = false;
	psLoaded = false;
	pssLoaded = false;
	console.log("onload...");
	loadDefaultData();
}
if(document.readyState == 'complete') {
	init();
} else {
	window.addEventListener('load', init);
}

function loadDefaultData() {
	console.log("loadDefaultData - mode : "+mode);
	loadDropdowns(function() {
		console.log("fcLoaded : "+fcLoaded);
		console.log("asLoaded : "+asLoaded);
		console.log("psLoaded : "+psLoaded);
		if(fcLoaded == true && asLoaded == true && psLoaded == true) {
			if (mode != "create") {
				fetchDetails(formStorageId);
			} else {
				showLoading(false);
			}
		}
	});
}

function loadDropdowns(callback) {
	loadFunctionalComponent(callback);
	loadActionStatus(callback);
	loadPriceScheme(callback);
}

function fetchDetails(formStorageId) {
	showLoading(true);
	if (formStorageId != "") {
		data = {};
		data.formStorageId = formStorageId;
		data.formType = "transactionFee";
		ajaxCallAPI(
				'GET',
				"loadData",
				data,
				function() {
					data = this.get("responseData");
					contentdata = this.get("responseData");
					console.log("contentdata : " + JSON.stringify(contentdata));
					if (data.error) {
						displayMessage('danger', data.error);
					} else {
						if(mode=="edit") {
							if(contentdata.contentJson.Status=="Draft") {
								getEID("status").value = "Active";
							} else {
								getEID("status").value = contentdata.contentJson.Status;
							}
						}
						getEID("transactionFeeCode").value = contentdata.contentJson.TransactionFeeCode;
						getEID(namespace + "functionalComponent").value = contentdata.contentJson.FunctionalComponent;
						getEID(namespace + "actionStatus").value = contentdata.contentJson.Action;
						getEID(namespace + "pricingScheme").value = contentdata.contentJson.PriceScheme;
						changePriceScheme();
						getEID(namespace + "pricingSubScheme").value = contentdata.contentJson.PriceSubScheme;
						
						if (mode == "edit" && contentdata.contentJson.Status == "Inactive") {
							getEID("activate").style.display = "";
							getEID("deactivate").style.display = "none";
						} else if (mode == "edit") {
							getEID("activate").style.display = "none";
							getEID("deactivate").style.display = "";
						}
					}
					showLoading(false);
				}, function() {
					displayMessage('danger',
							"Error in persisting dynamic form data.");
					showLoading(false);
				});
	}
	if (mode == "view") {
		enableViewMode();
	}
}

function enableViewMode() {
	var form = document.getElementById("transaction_fee_form");
	var elements = form.elements;
	for (var i = 0, len = elements.length; i < len; ++i) {
		elements[i].readOnly = true;
		elements[i].disabled = true;
	}
}

function loadFunctionalComponent(callback) {
	var elementDrpDwn = getEID(namespace + "functionalComponent");
	for(var i=0; i<functionalComponentList.length; i++) {
		var opt = new Option(functionalComponentList[i].displayName, functionalComponentList[i].itemValue);
		elementDrpDwn.options[elementDrpDwn.options.length] = opt;
	}
	fcLoaded = true;
	callback();
}

function loadActionStatus(callback) {
	var elementDrpDwn = getEID(namespace + "actionStatus");
	for(var i=0; i<actionStatusList.length; i++) {
		var opt = new Option(actionStatusList[i].displayName, actionStatusList[i].itemValue);
		elementDrpDwn.options[elementDrpDwn.options.length] = opt;
	}
	asLoaded = true;
	callback();
}

function loadPriceScheme(callback) {
	data = {};
	data.formType = "priceScheme";
	data.conditions = ["contentJson.Status=Active","size="+2147483647];
	ajaxCallAPI(
			'GET',
			"searchList",
			data,
			function() {
				data = this.get("responseData");
				contentdata = this.get("responseData");
				console.log("contentdata : " + JSON.stringify(contentdata));
				if (data.error) {
					displayMessage('danger', data.error, 3000);
				} else {
					priceScheme = contentdata.content;
					var elementDrpDwn = getEID(namespace + "pricingScheme");
					for(var i=0; i<priceScheme.length; i++) {
						var opt = new Option(priceScheme[i].contentJson.PricingSchemeCode, 
								priceScheme[i].contentJson.PricingSchemeCode);
						elementDrpDwn.options[elementDrpDwn.options.length] = opt;
					}
				}
				loadPriceSubScheme();
				psLoaded = true;
				callback();
			}, function() {
				displayMessage('danger',
						"Error in persisting dynamic form data.", 3000);
				psLoaded = true;
				callback();
			});
}

function loadPriceSubScheme() {
	var pricingSchemeDrpDwn = getEID(namespace + "pricingScheme");
	for(var i=0; i<priceScheme.length; i++) {
		console.log(pricingSchemeDrpDwn.value+" | "+priceScheme[i].contentJson.PricingSchemeCode);
		if(pricingSchemeDrpDwn.value == priceScheme[i].contentJson.PricingSchemeCode) {
			var elementDrpDwn = getEID(namespace + "pricingSubScheme");
			elementDrpDwn.innerText = null;
			var subSchemeDetails = priceScheme[i].contentJson.SubSchemeDetails;
			elementDrpDwn.options[elementDrpDwn.options.length] = 
				new Option("Choose a Price Sub-Scheme...","");
			elementDrpDwn.options[elementDrpDwn.options.length-1].setAttribute("hidden", "true");
			for(var j=0; j<subSchemeDetails.length; j++) {
				var opt = new Option(subSchemeDetails[j].priceSubSchemeId, 
							subSchemeDetails[j].priceSubSchemeId);
				elementDrpDwn.options[elementDrpDwn.options.length] = opt;
			}
		}
	}
}

function changePriceScheme() {
	// get sub schemes
	loadPriceSubScheme();
}

function validateFields(action) {
	if (checkIsValide()) {
		submitTransactionFee(action);
	}
}

function checkIsValide() {
	var eValid = true;
	var functionalComponent = getEID(namespace + "functionalComponent");
	var actionStatus = getEID(namespace + "actionStatus");
	var priceScheme = getEID(namespace + "pricingScheme");
	var priceSubScheme = getEID(namespace + "pricingSubScheme");
	if (priceScheme.value.trim() == "" || priceScheme.value == null 
			|| typeof priceScheme.value === "undefined") {
		eValid = false;
		displayMessage('danger', "Price scheme is Mandatory", 3000);
	} else if (priceSubScheme.value.trim() == "" || priceSubScheme.value == null 
			|| typeof priceSubScheme.value === "undefined") {
		eValid = false;
		displayMessage('danger', "Price sub-scheme is Mandatory", 3000);
	} else if (functionalComponent.value.trim() == "" || functionalComponent.value == null 
			|| typeof functionalComponent.value === "undefined") {
		eValid = false;
		displayMessage('danger', "Functional Component is Mandatory", 3000);
	} else if (actionStatus.value.trim() == "" || actionStatus.value == null 
			|| typeof actionStatus.value === "undefined") {
		eValid = false;
		displayMessage('danger', "Action / Status is Mandatory", 3000);
	}
	return eValid;
}

function submitTransactionFee(action) {
	showLoading(true);
	var transactionFee = {};
	var functionalComponent = getEID(namespace + "functionalComponent");
	var actionStatus = getEID(namespace + "actionStatus");
	var priceScheme = getEID(namespace + "pricingScheme");
	var priceSubScheme = getEID(namespace + "pricingSubScheme");
	var transactionFeeCode = generateTransactionFeeCode();
	
	transactionFee.TransactionFeeCode = transactionFeeCode;
	transactionFee.FunctionalComponent = functionalComponent.value;
	transactionFee.Action = actionStatus.value;
	transactionFee.PriceScheme = priceScheme.value;
	transactionFee.PriceSubScheme = priceSubScheme.value;
	
	if(mode=="edit") {
		transactionFee.Status = getEID("status").value;
		transactionFee.formStorageId = formStorageId;
	} else {
		if (action == "publish") {
			transactionFee.Status = "Active";
		} else {
			transactionFee.Status = "Draft";
		}
	}
	transactionFee.formType = "TransactionFee";
	console.log(transactionFee);
	console.log(JSON.stringify(transactionFee));
	ajaxCallAPI('POST', 'persist', transactionFee, function() {
		let data = this.get("responseData");
		if (data.error) {
			displayMessage('danger', data.error);
		} else if (Object.keys(data).length === 0) {
			displayMessage('danger', 'Form submission failed.');
		} else {
			console.log(data.toString());
			var message = "Form successfully submitted.";
			if (transactionFee.Status == "Draft")
				message = "Record is saved in draft";
			displayMessage('success', message);
			afterFormSubmissionFormIOForm(transactionFee);
		}
		showLoading(false);
	}, function() {
		displayMessage('danger', "Error in persisting dynamic form data.");
		showLoading(false);
	});
}

function generateTransactionFeeCode() {
	if(mode=="edit") {
		 return getEID("transactionFeeCode").value;
	} else if (mode=="copy") {
		return "Copy-of-"+getEID("transactionFeeCode").value;
	} else {
		var date = new Date();
		var now_utc =  Date.UTC(date.getUTCFullYear(), date.getUTCMonth(), date.getUTCDate(),
				 date.getUTCHours(), date.getUTCMinutes(), date.getUTCSeconds());
		return "TF-"+now_utc;
	}
}

function afterFormSubmissionFormIOForm(data) {
	console.log("data : " + JSON.stringify(data));
	console.log("data.formStorageId : " + data.formStorageId);
	var status = data.Status;
	var formType = "Transaction Fee";
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
				if (_.isEmpty(data)) {
					console.log("error");
				} else {
					showPopupSuccess(status, storageId);
				}
				showLoading(false);
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

//=============

function reset() {
	document.getElementById("transaction_fee_form").reset();
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