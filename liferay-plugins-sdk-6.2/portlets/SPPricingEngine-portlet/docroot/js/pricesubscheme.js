var modelName = "PriceSubScheme";
var data, contentdata;
showLoading(true);
console.log("document.readyState : "+document.readyState);
function init() {
	console.log("onload...");
	loadDefaultData();
	setInterval(function() {
		checkForm();
	}, 1000);
}
if(document.readyState == 'complete') {
	init();
} else {
	window.addEventListener('load', init);
}

function checkForm() {
	if (document.getElementById(namespace + "priceSubSchemeCode").value.trim() != ""
			&& document.getElementById(namespace + "priceSubSchemeName").value.trim() != "") {
		console.log("valid...");
		if (mode == "copy" || mode == "create") {
			document.getElementById("draft").disabled = false;
			document.getElementById("publish").disabled = false;
		} else if (mode == "edit") {
			document.getElementById("deactivate").disabled = false;
			document.getElementById("update").disabled = false;
		}
	} else {
		console.log("not valid...");
		if (mode == "copy" || mode == "create") {
			document.getElementById("draft").disabled = true;
			document.getElementById("publish").disabled = true;
		} else if (mode == "edit") {
			document.getElementById("deactivate").disabled = true;
			document.getElementById("update").disabled = true;
		}
	}
}

function loadDefaultData() {
	console.log("loadDefaultData - mode : "+mode);
	loadPriceSubSchemeCategory();
	loadPriceType();
	loadPriceSubType();
	loadSubjectType();
	loadUnits();
	if (mode != "create") {
		fetchDetails(formStorageId);
	} else {
		showLoading(false);
	}
}

function fetchDetails(formStorageId) {
	showLoading(true);
	if (formStorageId != "") {
		data = {};
		data.formStorageId = formStorageId;
		data.formType = "priceSubScheme";
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
						var sc = contentdata.contentJson.PriceSubSchemeCode;
						if (mode == "copy") {
							sc = "Copy-of-" + sc;
						}
						getEID(namespace + "priceSubSchemeCode").value = sc;
						if(mode=="edit") {
							if(contentdata.contentJson.Status=="Draft") {
								getEID("status").value = "Active";
							} else {
								getEID("status").value = contentdata.contentJson.Status;
							}
						}
						getEID(namespace + "priceSubSchemeName").value = contentdata.contentJson.PriceSubSchemeName;
						getEID(namespace + "priceCategory").value = contentdata.contentJson.PriceCategory;
						changePriceCategory();
						getEID(namespace + "priceType").value = contentdata.contentJson.PriceType;
						changePriceType();
						getEID(namespace + "priceSubType").value = contentdata.contentJson.PriceSubType;
						getEID(namespace + "subjectType").value = contentdata.contentJson.SubjectType;
						getEID(namespace + "noOfFullUnits").value = contentdata.contentJson.FullUnitNumber;
						getEID(namespace + "noOfHalfUnits").value = contentdata.contentJson.HalfUnitNumber;
						getEID(namespace + "noOfLawUnits").value = contentdata.contentJson.LawUnitNumber;
						if (mode == "edit" && contentdata.contentJson.Status == "Inactive") {
							getEID("activate").style.display = "";
							getEID("deactivate").style.display = "none";
						} else if (mode == "edit") {
							getEID("activate").style.display = "none";
							getEID("deactivate").style.display = "";
							getEID(namespace + "priceSubSchemeCode").disabled = true;
						}
					}
					showLoading(false);
				}, function() {
					displayMessage('danger',
							"Error in persisting dynamic form data.", 3000);
					showLoading(false);
				});
	}
	if (mode == "view") {
		enableViewMode();
	}
}

function enableViewMode() {
	var form = document.getElementById("price_subscheme_form");
	var elements = form.elements;
	for (var i = 0, len = elements.length; i < len; ++i) {
		elements[i].readOnly = true;
		elements[i].disabled = true;
	}
}

function loadPriceSubSchemeCategory() {
	var elementDrpDwn = getEID(namespace + "priceCategory");
	console.log("priceSubSchemeCategoryList : "+JSON.stringify(priceSubSchemeCategoryList));
	for(var i=0; i<priceSubSchemeCategoryList.length; i++) {
		var opt = new Option(priceSubSchemeCategoryList[i].displayName, priceSubSchemeCategoryList[i].itemValue);
		elementDrpDwn.options[elementDrpDwn.options.length] = opt;
	}
}

function loadPriceType() {
	console.log("loadPriceType...");
	var categoryDrpDwn = getEID(namespace + "priceCategory");
	var elementDrpDwn = getEID(namespace + "priceType");
	var typeList = subjectPriceTypeList;
	if(categoryDrpDwn.value=="Invigilator") {
		typeList = invigilatorPriceTypeList;
	}
	elementDrpDwn.innerText = null;
	for(var i=0; i<typeList.length; i++) {
		var opt = new Option(typeList[i].displayName, typeList[i].itemValue);
		elementDrpDwn.options[elementDrpDwn.options.length] = opt;
	}
}

function loadPriceSubType() {
	console.log("loadPriceSubType...");
	var categoryDrpDwn = getEID(namespace + "priceCategory");
	var priceTypeDrpDwn = getEID(namespace + "priceType");
	var elementDrpDwn = getEID(namespace + "priceSubType");
	var typeList = null;
	console.log("categoryDrpDwn.value : "+categoryDrpDwn.value);
	console.log("priceTypeDrpDwn.value : "+priceTypeDrpDwn.value);
	if(categoryDrpDwn.value=="Invigilator") {
		typeList = invigilatorPriceSubTypeList;
	} else if(categoryDrpDwn.value=="Subject" && priceTypeDrpDwn.value=="MiscFees") {
		typeList = miscFeesPriceSubTypeList;
	} else {
		typeList = examFeesPriceSubTypeList;
	}
	elementDrpDwn.innerText = null;
	for(var i=0; i<typeList.length; i++) {
		var opt = new Option(typeList[i].displayName, typeList[i].itemValue);
		elementDrpDwn.options[elementDrpDwn.options.length] = opt;
	}
}

function loadSubjectType() {
	console.log("loadSubjectType...");
	var priceTypeDrpDwn = getEID(namespace + "priceType");
	var elementDrpDwn = getEID(namespace + "subjectType");
	var elementDrpDwnRow = elementDrpDwn.parentElement.parentElement.parentElement.parentElement.parentElement.getElementsByClassName("subjectTypeRow")[0];
	elementDrpDwn.innerText = null;
	if(priceTypeDrpDwn.value == "ExamModular") {
		for(var i=0; i<subjectTypeList.length; i++) {
			var opt = new Option(subjectTypeList[i].displayName, subjectTypeList[i].itemValue);
			elementDrpDwn.options[elementDrpDwn.options.length] = opt;
		}
		elementDrpDwnRow.style.display = "block";
	} else {
		elementDrpDwnRow.style.display = "none";
	}
}

function loadUnits() {
	console.log("loadUnits...");
	var priceTypeDrpDwn = getEID(namespace + "priceType");
	var elementDrpDwn1 = getEID(namespace + "noOfFullUnits");
	var elementDrpDwn2 = getEID(namespace + "noOfHalfUnits");
	var elementDrpDwn3 = getEID(namespace + "noOfLawUnits");
	var elementDrpDwnRow1 = elementDrpDwn1.parentElement.parentElement.parentElement.parentElement.parentElement.getElementsByClassName("noOfFullUnitsRow")[0];
	var elementDrpDwnRow2 = elementDrpDwn2.parentElement.parentElement.parentElement.parentElement.parentElement.getElementsByClassName("noOfHalfUnitsRow")[0];
	var elementDrpDwnRow3 = elementDrpDwn3.parentElement.parentElement.parentElement.parentElement.parentElement.getElementsByClassName("noOfLawUnitsRow")[0];
	elementDrpDwn1.innerText = null;
	elementDrpDwn2.innerText = null;
	elementDrpDwn3.innerText = null;
	if(priceTypeDrpDwn.value == "ExamNonModular") {
		for(var i=0; i<nofFullUnits.length; i++) {
			var opt = new Option(nofFullUnits[i].displayName, nofFullUnits[i].itemValue);
			elementDrpDwn1.options[elementDrpDwn1.options.length] = opt;
		}
		for(var i=0; i<nofHalfUnits.length; i++) {
			var opt = new Option(nofHalfUnits[i].displayName, nofHalfUnits[i].itemValue);
			elementDrpDwn2.options[elementDrpDwn2.options.length] = opt;
		}
		for(var i=0; i<nofLawUnits.length; i++) {
			var opt = new Option(nofLawUnits[i].displayName, nofLawUnits[i].itemValue);
			elementDrpDwn3.options[elementDrpDwn3.options.length] = opt;
		}
		elementDrpDwnRow1.style.display = "block";
		elementDrpDwnRow2.style.display = "block";
		elementDrpDwnRow3.style.display = "block";
	} else {
		elementDrpDwnRow1.style.display = "none";
		elementDrpDwnRow2.style.display = "none";
		elementDrpDwnRow3.style.display = "none";
	}
}

function changePriceCategory() {
	console.log("changePriceCategory...");
	loadPriceType();
	loadPriceSubType();
	loadSubjectType();
	loadUnits();
}

function changePriceType() {
	console.log("changePriceType...");
	loadPriceSubType();
	loadSubjectType();
	loadUnits();
}

function validateFields(action) {
	if (checkIsValide()) {
		submitSubScheme(action);
	}
}

function checkIsValide() {
	var eValid = true;
	var fullunits = getEID(namespace + "noOfFullUnits").value;
	var halfunits = getEID(namespace + "noOfHalfUnits").value;
	var lawunits = getEID(namespace + "noOfLawUnits").value;
	if (getEID(namespace + 'priceSubSchemeCode').value.trim() == "") {
		eValid = false;
		displayMessage('danger', "Price Sub-Scheme Code is Mandatory", 3000);
	} else if (getEID(namespace + 'priceSubSchemeName').value.trim() == "") {
		eValid = false;
		displayMessage('danger', "Price Sub-Scheme Name is Mandatory", 3000);
	} else if (fullunits == "0" && halfunits == "0" && lawunits == "0") {
		eValid = false;
		displayMessage('danger', "One of the units must be non zero", 3000);
	}
	return eValid;
}

function submitSubScheme(action) {
	showLoading(true);
	var subscheme = {};
	var code = getEID(namespace + "priceSubSchemeCode");
	var name = getEID(namespace + "priceSubSchemeName");
	var category = getEID(namespace + "priceCategory");
	var priceType = getEID(namespace + "priceType");
	var priceSubType = getEID(namespace + "priceSubType");
	subscheme.PriceSubSchemeCode = code.value.trim().replace(/\s+/g, '-');
	subscheme.PriceSubSchemeName = name.value.trim();
	subscheme.PriceCategory = category.value;
	subscheme.PriceType = priceType.value;
	subscheme.PriceSubType = priceSubType.value;
	if(priceType.value=="ExamModular") {
		subscheme.SubjectType = getEID(namespace + "subjectType").value;
	}
	if(priceType.value=="ExamNonModular") {
		subscheme.FullUnitNumber = getEID(namespace + "noOfFullUnits").value;
		subscheme.HalfUnitNumber = getEID(namespace + "noOfHalfUnits").value;
		subscheme.LawUnitNumber = getEID(namespace + "noOfLawUnits").value;
	}
	if(mode=="edit") {
		subscheme.Status = getEID("status").value;
		subscheme.formStorageId = formStorageId;
	} else {
		if (action == "publish") {
			subscheme.Status = "Active";
		} else {
			subscheme.Status = "Draft";
		}
	}
	subscheme.formType = "PriceSubScheme";
	console.log(subscheme);
	console.log(JSON.stringify(subscheme));
	ajaxCallAPI('POST', 'persist', subscheme, function() {
		let data = this.get("responseData");
		if (data.error) {
			displayMessage('danger', data.error, 3000);
		} else if (Object.keys(data).length === 0) {
			displayMessage('danger', 'Form submission failed.', 3000);
		} else {
			console.log(data.toString());
			var message = "Form successfully submitted.";
			if (subscheme.Status == "Draft")
				message = "Record is saved in draft";
			displayMessage('success', message, 3000);
			afterFormSubmissionFormIOForm(subscheme);
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
	var formType = "Price Sub-Scheme";
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
	document.getElementById("price_subscheme_form").reset();
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