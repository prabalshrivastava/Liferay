var subSchemeHolder = document.getElementById('subSchemeHolder');
var subSchemeContainer = document.getElementById('subSchemeBase');
var subSchemeList = [];
var currencyList = [];
var priceSubSchemeList = [];
var taxCodeList = [];
var discountList = [];
var data, contentdata;
var subSchemes;
var modelName = "PriceScheme";
var ssLoaded = false;
var tcLoaded = false;
var ccLoaded = false;
var dcLoaded = false;
showLoading(true);
console.log("document.readyState : "+document.readyState);

function init() {
	console.log("onload...");
	console.log("onload - subSchemeHolder : "+subSchemeHolder.hasChildNodes());
	ssLoaded = false;
	tcLoaded = false;
	ccLoaded = false;
	dcLoaded = false;
	while (subSchemeHolder.hasChildNodes()) {
		subSchemeHolder.removeChild(subSchemeHolder.lastChild);
	}
	loadDefaultData(function() {
		setInterval(function() {
			checkForm();
		}, 1000);
		console.log("onload - mode : "+mode);
		if (mode == "create") {
			addAnotherSubScheme();
		}
		var promoCode = document.getElementById(namespace+"promotionCode");
		populatePromoCodeDropDown(promoCode, discountList, "DiscountCode", "DiscountCode");
	});
}
if(document.readyState == 'complete') {
	init();
} else {
	window.addEventListener('load', init);
}

function priceSubSchemeChange(subSchemeDropdown) {
	console.log("parentElement : "+subSchemeDropdown.parentElement.parentElement.parentElement.parentElement.parentElement.parentElement.id);
	var header = subSchemeDropdown.parentElement.parentElement.parentElement.parentElement.parentElement.parentElement.getElementsByClassName("header")[0]
		.getElementsByTagName("div")[0];
	header.innerText = subSchemeDropdown.options[subSchemeDropdown.selectedIndex].text;
}

function getDiscount(storageId) {
	for(var i=0;i<discountList.length;i++) {
		console.log(discountList[i].storageId+ " = "+ storageId);
		if(discountList[i].storageId == storageId) {
			return discountList[i];
		}
	}
}

function loadDefaultData(callback) {
	console.log("loadDefaultData - mode : "+mode);
	loadDropdowns(function() {
		console.log("ssLoaded : "+ssLoaded);
		console.log("tcLoaded : "+tcLoaded);
		console.log("ccLoaded : "+ccLoaded);
		console.log("dcLoaded : "+dcLoaded);
		if(ssLoaded == true && tcLoaded == true && ccLoaded == true
				&& dcLoaded == true) {
			if (mode != "create") {
				fetchDetails(formStorageId);
			} else {
				showLoading(false);
			}
			callback();
		}
	});
}

function fetchDetails(formStorageId) {
	showLoading(true);
	if (formStorageId != "") {
		data = {};
		data.formStorageId = formStorageId;
		data.formType = "priceScheme";
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
						var sc = contentdata.contentJson.PricingSchemeCode;
						if (mode == "copy") {
							sc = "Copy-of-" + sc;
						}
						getEID(namespace + "priceSchemeCode").value = sc;
						if(mode=="edit") {
							if(contentdata.contentJson.Status=="Draft") {
								getEID("status").value = "Active";
							} else {
								getEID("status").value = contentdata.contentJson.Status;
							}
						}
						getEID(namespace + "priceSchemeName").value = contentdata.contentJson.PricingSchemeName;
						if(mode=="view") {
							getEID(namespace + "pricingDescription").value = 
								(contentdata.contentJson.PricingDescription === "")?"Not Specified":contentdata.contentJson.PricingDescription;
							getEID(namespace + "promotionCode").value = 
								(contentdata.contentJson.PromoCode === "")?"Not Specified":contentdata.contentJson.PromoCode;
							getEID(namespace + "startDate").value = 
								(typeof contentdata.contentJson.StartDate === "undefined")?
										"-":contentdata.contentJson.StartDate;
							getEID(namespace + "endDate").value = 
								(typeof contentdata.contentJson.EndDate === "undefined")?
										"-":contentdata.contentJson.EndDate;
						} else {
							getEID(namespace + "pricingDescription").value = contentdata.contentJson.PricingDescription;
							getEID(namespace + "promotionCode").value = 
								(contentdata.contentJson.PromoCode === "")?"":contentdata.contentJson.PromoCode;
							getEID(namespace + "startDate").value = 
								(typeof contentdata.contentJson.StartDate === "undefined")?
										"":contentdata.contentJson.StartDate;
							getEID(namespace + "endDate").value = 
								(typeof contentdata.contentJson.EndDate === "undefined")?
										"":contentdata.contentJson.EndDate;
						}
						getEID(namespace + "grantCode").value = "";
						
						var subschemes = contentdata.contentJson.SubSchemeDetails;
						addAllDataToArray();
						for (var i = 0; i < subschemes.length; i++) {
							var ss = new SubScheme(subschemes[i].priceSubSchemeId,
									subschemes[i].taxCodeId,
									subschemes[i].includeTax,
									subschemes[i].ccyCode,
									subschemes[i].amount,
									subschemes[i].discountId,"Active");
							console.log("ss : "+JSON.stringify(ss));
							subSchemeList.push(ss);
						}
						drawSubSchemes();
						if (mode == "edit"
								&& contentdata.contentJson.Status == "Inactive") {
							getEID("activate").style.display = "";
							getEID("deactivate").style.display = "none";
						} else if (mode == "edit") {
							getEID("activate").style.display = "none";
							getEID("deactivate").style.display = "";
							getEID(namespace + "priceSchemeCode").disabled = true;
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

function enableViewMode() {
	var form = document.getElementById("pricing_scheme_form");
	var elements = form.elements;
	for (var i = 0, len = elements.length; i < len; ++i) {
		elements[i].readOnly = true;
		elements[i].disabled = true;
	}
}

function loadDropdowns(callback) {
	downloadVocabularyData("Currency%20Code", function(data) {
		currencyList = data;
		ccLoaded = true;
		callback();
	});
	downloadDropdownData("priceSubScheme", function(data) {
		priceSubSchemeList = data;
		ssLoaded = true;
		callback();
	});
	downloadDropdownData("taxCode", function(data) {
		taxCodeList = data;
		tcLoaded = true;
		callback();
	});
	downloadDropdownData("discount", function(data) {
		discountList = data;
		dcLoaded = true;
		callback();
	});
}

function populateVocabularyDropDown(elementDrpDwn, data, keyColumn, valueColumn) {
	for(var i=0; i<data.length; i++) {
		var opt = new Option(data[i][keyColumn], 
				data[i][valueColumn]);
		elementDrpDwn.options[elementDrpDwn.options.length] = opt;
	}
}

function populateDropDown(elementDrpDwn, data, keyColumn, valueColumn) {
	for(var i=0; i<data.length; i++) {
		var opt = new Option(data[i].contentJson[valueColumn], 
				data[i].contentJson[keyColumn]);
		elementDrpDwn.options[elementDrpDwn.options.length] = opt;
	}
}

function populateTaxDropDown(elementDrpDwn, data) {
	for(var i=0; i<data.length; i++) {
		var opt = new Option(data[i].contentJson.Country + " | " + data[i].contentJson.TaxCode, 
				data[i].storageId);
		elementDrpDwn.options[elementDrpDwn.options.length] = opt;
	}
}

function populateDiscountDropDown(elementDrpDwn, data, keyColumn, valueColumn) {
	for(var i=0; i<data.length; i++) {
		if(data[i].contentJson["Category"]!="DiscountPriceWithPromoCode") {
			var opt = new Option(data[i].contentJson[keyColumn], 
					data[i].contentJson[valueColumn]);
			elementDrpDwn.options[elementDrpDwn.options.length] = opt;
		}
	}
}

function populatePromoCodeDropDown(elementDrpDwn, data, keyColumn, valueColumn) {
	for(var i=0; i<data.length; i++) {
		if(data[i].contentJson["Category"]=="DiscountPriceWithPromoCode") {
			var opt = new Option(data[i].contentJson[keyColumn], 
					data[i].contentJson[valueColumn]);
			elementDrpDwn.options[elementDrpDwn.options.length] = opt;
		}
	}
}

function downloadDropdownData(model, callback) {
	data = {};
	data.formType = model;
	data.conditions = ["contentJson.Status=Active","size="+2147483647];
	ajaxCallAPI(
			'GET',
			"searchList",
			data,
			function() {
				data = this.get("responseData");
				contentdata = this.get("responseData");
				var responseData = [];
				if (data.error) {
					displayMessage('danger', data.error, 3000);
				} else {
					responseData = contentdata.content;
				}
				callback(responseData);
			}, function() {
				displayMessage('danger',
						"Error in persisting dynamic form data.", 3000);
				callback();
			});
}	

function downloadVocabularyData(vocabulary, callback) {
	var strSubURI = vocabulary;
	console.log("strSubURI : "+strSubURI);
	var ajaxUrl = vocabularyURL.replace("$VCNAME", strSubURI);
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
													callback(responseData);
												},
												failure : function() {
													console
															.log("Error in the ajax call.");
													callback([]);
												}
											}
										});
					});

}

function SubScheme(subScheme, taxCode, includeTax, currencyCode, amount, discountCode, deleteStatus) {
	this.subScheme = subScheme;
	this.taxCode = taxCode;
	this.includeTax = includeTax;
	this.currencyCode = currencyCode;
	this.amount = amount;
	this.discountCode = discountCode;
	this.deleteStatus = deleteStatus;
}

function addAnotherSubScheme() {
	addAllDataToArray();
	var ss = new SubScheme("", "", "", "", "", "", "");
	subSchemeList.push(ss);
	drawSubSchemes();
}

function removeSubScheme(e) {
	var eRmv = e.parentElement.parentElement.parentElement.parentElement;
	eRmv.getElementsByClassName("deleteStatus")[0].innerHTML = "Remove";
	addAllDataToArray();
	drawSubSchemes();
	if (subSchemeList.length == 0) {
		addAnotherSubScheme();
	}
}

function closeSubScheme(closeIcon) {
	var eRmv = closeIcon.parentElement.parentElement.parentElement.parentElement;
	console.log("eRmv : "+eRmv.id);
	var subSchemeDiv = eRmv.getElementsByClassName("subSchemeContent")[0];
	if(subSchemeDiv.style.display!="none") {
		subSchemeDiv.style.display = "none";
		closeIcon.style.background = "url(/html/images/expand.png) no-repeat";
	} else {
		subSchemeDiv.style.display = "block";
		closeIcon.style.background = "url(/html/images/close-minus.png) no-repeat";
	}
}

function addAllDataToArray() {
	while (subSchemeList.length > 0) {
		subSchemeList.pop();
	}
	var c = subSchemeHolder.childElementCount;
	for (var i = 0; i < c; i++) {
		var node = subSchemeHolder.childNodes[i];
		var subScheme = node.getElementsByClassName("priceSubScheme")[0];
		var taxCode = node.getElementsByClassName("taxCode")[0];
		var currecyCode = node.getElementsByClassName("currencyCode")[0];
		var discountCode = node.getElementsByClassName("discountCode")[0];
		var amount = node.getElementsByClassName("amount")[0];
		var deleteStatus = node.getElementsByClassName("deleteStatus")[0];
		var includeTax = node.getElementsByClassName("includeTax")[0];
		if (deleteStatus.innerHTML != "Remove") {
			subSchemeList.push(new SubScheme(subScheme.value, taxCode.value, includeTax.checked, currecyCode.value,
					amount.value, discountCode.value, deleteStatus.innerHTML));
		}
	}
}

function drawSubSchemes() {
	var count = 0;
	var i;
	while (subSchemeHolder.hasChildNodes()) {
		subSchemeHolder.removeChild(subSchemeHolder.lastChild);
	}
	console.log("drawSubSchemes - subSchemeList : "+JSON.stringify(subSchemeList));
	for (i = 0; i < subSchemeList.length; i++) {
		var node = subSchemeContainer.cloneNode(true);
		var header = node.getElementsByClassName("header")[0]
				.getElementsByTagName("div")[0];
		var subScheme = node.getElementsByClassName("priceSubScheme")[0];
		var taxCode = node.getElementsByClassName("taxCode")[0];
		var currencyCode = node.getElementsByClassName("currencyCode")[0];
		var discountCode = node.getElementsByClassName("discountCode")[0];
		var amount = node.getElementsByClassName("amount")[0];
		var includeTax = node.getElementsByClassName("includeTax")[0];
		
		populateVocabularyDropDown(currencyCode, currencyList, "id", "name");
		populateDropDown(subScheme, priceSubSchemeList, "PriceSubSchemeCode", "PriceSubSchemeName");
		populateTaxDropDown(taxCode, taxCodeList);
		populateDiscountDropDown(discountCode, discountList, "DiscountCode", "DiscountCode");
		
		subScheme.value = subSchemeList[i].subScheme;
		taxCode.value = subSchemeList[i].taxCode;
		discountCode.value = subSchemeList[i].discountCode;
		currencyCode.value = subSchemeList[i].currencyCode;
		amount.value = subSchemeList[i].amount;
		console.log("subSchemeList[i].includeTax : "+subSchemeList[i].includeTax);
		console.log("includeTax: "+includeTax);
		includeTax.checked = subSchemeList[i].includeTax;
		if(mode=="view") {
			taxCode.value = subSchemeList[i].taxCode==""?"Not Specified":subSchemeList[i].taxCode;
			discountCode.value = subSchemeList[i].discountCode==""?"Not Specified":subSchemeList[i].discountCode;
		}
		node.getElementsByClassName("deleteStatus")[0].innerHTML = subSchemeList[i].status;
		console.log("subSchemeList[i].deleteStatus : "
				+ subSchemeList[i].deleteStatus);
		if (subSchemeList[i].deleteStatus != "Remove") {
			count = count + 1;
			if(subScheme.value == "") {
				if (count <= 9) {
					header.innerText = "SUB-SCHEME 0" + count;
				} else {
					header.innerText = "SUB-SCHEME " + count;
				}
			} else {
				header.innerText = subScheme.options[subScheme.selectedIndex].text;
			}
			node.style.display = "block";
			subSchemeHolder.appendChild(node);
		}
	}
}

function checkForm() {
	if (document.getElementById(namespace + "priceSchemeCode").value.trim() != ""
			&& document.getElementById(namespace + "priceSchemeName").value.trim() != "") {
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

function validateFields(action) {
	if (checkIsValide()) {
		submitPriceScheme(action);
	}
}

function checkIsValide() {
	var eValid = true;
	addAllDataToArray();
	if (getEID(namespace + 'priceSchemeCode').value.trim() == "") {
		eValid = false;
		displayMessage('danger', "Price scheme code is Mandatory", 3000);
	} else if (getEID(namespace + 'priceSchemeName').value.trim() == "") {
		eValid = false;
		displayMessage('danger', "Price scheme name is Mandatory", 3000);
	} else if (subSchemeList.length == 0) {
		eValid = false;
		displayMessage('danger', "At least one sub-scheme is required",
				3000);
	} else {
		var subSchemeType = null;
		var selectedSubSchemes = [];
		for (var i = 0; i < subSchemeList.length; i++) {
			if (subSchemeList[i].subScheme == "") {
				eValid = false;
				displayMessage('danger', "Price Sub-Scheme is Mandatory", 3000);
				break;
			}
			if (subSchemeList[i].currencyCode == "") {
				eValid = false;
				displayMessage('danger', "Currency code is Mandatory", 3000);
				break;
			}
			if (subSchemeList[i].amount == "") {
				eValid = false;
				displayMessage('danger', "Amount is Mandatory", 3000);
				break;
			}
			// price-scheme of same price type
			var priceType = getPriceType(subSchemeList[i].subScheme);
			if(subSchemeType == null) {
				subSchemeType = priceType;
			} else if(priceType != subSchemeType) {
				eValid = false;
				displayMessage('danger', "Only same Pricing Type is allowed within a Pricing Scheme", 3000);
				break;
			}
			
			//currency code match?
			var discCCyCode = getDiscount(subSchemeList[i].discountCode);
			console.log("discCCyCode : "+discCCyCode);
			if(subSchemeList[i].discountCode!="" && discCCyCode!=null
					&& discCCyCode!="" && (typeof discCCyCode !== "undefined") && discCCyCode.ccyCode!=null &&
					discCCyCode.ccyCode!="" && subSchemeList[i].currencyCode != discCCyCode.ccyCode) {
				eValid = false;
				console.log("discCCyCode : "+discCCyCode.ccyCode);
				displayMessage('danger', "Currency code must be match with the currency code of selected discount", 3000);
				break;
			}
			
			//duplicate sub schemes
			if(selectedSubSchemes.includes(subSchemeList[i].subScheme)) {
				eValid = false;
				displayMessage('danger', "Same sub-scheme selected multiple times", 3000);
				break;
			}
			selectedSubSchemes.push(subSchemeList[i].subScheme);
		}
	}
	return eValid;
}

function getPriceType(subSchemeCode) {
	for(var i=0;i<priceSubSchemeList.length;i++) {
		if(priceSubSchemeList[i].priceSubSchemeCode == subSchemeCode) {
			return priceSubSchemeList[i].priceType;
		}
	}
}

function submitPriceScheme(action) {
	showLoading(true);
	var priceSchemeCode = getEID(namespace + "priceSchemeCode");
	var priceSchemeName = getEID(namespace + "priceSchemeName");
	var startDate = getEID(namespace + "startDate");
	var endDate = getEID(namespace + "endDate");
	var priceDescription = getEID(namespace + "pricingDescription");
	var promoCode = getEID(namespace + "promotionCode");
	var priceScheme = {};
	priceScheme.PricingSchemeCode = priceSchemeCode.value.trim().replace(/\s+/g, '-');
	priceScheme.PricingSchemeName = priceSchemeName.value.trim();
	priceScheme.StartDate = startDate.value;
	priceScheme.EndDate = endDate.value;
	priceScheme.SubSchemeDetails = [];
	priceScheme.PricingDescription = priceDescription.value;
	priceScheme.PromoCode = promoCode.value;
	for (var i = 0; i < subSchemeList.length; i++) {
		var subScheme = {};
		var subSchemeData = subSchemeList[i];
		subScheme.priceSubSchemeId = subSchemeData.subScheme;
		subScheme.taxCodeId = subSchemeData.taxCode;
		subScheme.discountId = subSchemeData.discountCode;
		subScheme.ccyCode = subSchemeData.currencyCode;
		subScheme.amount = subSchemeData.amount;
		subScheme.includeTax = subSchemeData.includeTax;
		priceScheme.SubSchemeDetails.push(subScheme);
	}
	if(mode=="edit") {
		priceScheme.Status = getEID("status").value;
		priceScheme.formStorageId = formStorageId;
	} else {
		if (action == "publish") {
			priceScheme.Status = "Active";
		} else {
			priceScheme.Status = "Draft";
		}
	}
	priceScheme.formType = "priceScheme";
	console.log(JSON.stringify(priceScheme));
	ajaxCallAPI('POST', 'persist', priceScheme, function() {
		let data = this.get("responseData");
		if (data.error) {
			displayMessage('danger', data.error, 3000);
		} else if (Object.keys(data).length === 0) {
			console.log("data : "+data);
			displayMessage('danger', 'Form submission failed.', 3000);
		} else {
			console.log(data.toString());
			var message = "Form successfully submitted.";
			if (priceScheme.Status == "Draft")
				message = "Record is saved in draft";
			displayMessage('success', message, 3000);
			afterFormSubmissionFormIOForm(priceScheme);
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
	var formType = "Price Scheme";
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

function promoCodeChange() {
	var promoCode = getEID(namespace + "promotionCode");
	console.log("promoCode : "+promoCode.value);
	if(promoCode.value == "none") {
		promoCode.selectedIndex = "0";
	}
}

function taxCodeChange(taxCode) {
	console.log("taxCode : "+taxCode.value);
	if(taxCode.value == "none") {
		taxCode.selectedIndex = "0";
	}
}

function discountCodeChange(discountCode) {
	console.log("discountCode : "+discountCode.value);
	if(discountCode.value == "none") {
		discountCode.selectedIndex = "0";
	}
}

//=============

function reset() {
	document.getElementById("price_scheme_form").reset();
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

//===================

/** ****************** Date Piker ********************* */

var d = new Date();
var m = (d.getMonth() + 1);
var t = d.getDate();
var y = d.getFullYear();
var s = m + "/" + t + "/" + y;
var today = stringToDate(s, "mm/dd/yyyy", "/");

var toDatepicker;
YUI().use(
		'aui-datepicker',
		'aui-form-validator',
		function(Y) {
			var toDatePicker;
			var fromDatePicker = new Y.DatePicker({
				trigger : '#' + namespace + 'startDate',
				mask : '%d/%m/%Y',
				popover : {
					zIndex : 1
				},
				calendar : {
					dateFormat : '%Y-%m-%d',
					minimumDate : today,
				},
				on : {
					selectionChange : function(event) {
						if (event.newSelection[0]) {
							toDatePicker.getCalendar().set('minimumDate',
									event.newSelection[0]);
						} else {
							toDatePicker.getCalendar()
									.set('minimumDate', today);
						}
					}

				}
			}
			);
			toDatePicker = new Y.DatePicker({
				trigger : '#' + namespace + 'endDate',
				mask : '%d/%m/%Y',
				popover : {
					zIndex : 1
				},
				calendar : {
					dateFormat : '%Y-%m-%d',
					minimumDate : today,
				},
				on : {
					selectionChange : function(event) {
						fromDatePicker.getCalendar().set('minimumDate', today);
					}
				}

			});
			new Y.DatePicker({
				trigger : '#' + namespace + 'endOn',
				mask : '%d/%m/%Y',
				popover : {
					zIndex : 1
				},
				calendar : {
					dateFormat : '%Y-%m-%d',
					minimumDate : today,
				},
				on : {
					selectionChange : function(event) {
						console.log("hello");

					}
				}

			});
		});
setInterval(function() {
	//run();
}, 2000);

function stringToDate(_date, _format, _delimiter) {
	var formatLowerCase = _format.toLowerCase();
	var formatItems = formatLowerCase.split(_delimiter);
	var dateItems = _date.split(_delimiter);
	var monthIndex = formatItems.indexOf("mm");
	var dayIndex = formatItems.indexOf("dd");
	var yearIndex = formatItems.indexOf("yyyy");
	var month = parseInt(dateItems[monthIndex]);
	month -= 1;
	var formatedDate = new Date(dateItems[yearIndex], month,
			dateItems[dayIndex]);
	return formatedDate;
}
