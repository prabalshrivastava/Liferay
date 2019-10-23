//discount period dashed-box
var discountPeriodHolder = document.getElementById('discountPeriodHolder');
var discountPeriodContainer = document
		.getElementById('discountPeriodContainer');
var discountPriceScreen = document.getElementById('discountPriceBase');
var discountPriceForBulkPurchase = document
		.getElementById('discountPriceForBulkPurchaseBase');
var discountPriceWithPromocode = document
		.getElementById('discountPriceWithPromocodeBase');
var selectedDiscountCategory = null;
var discountPeriodList = [];
var discountTypeList = [];
var sessionsList = [];
var currencyList = [];
var data, contentdata;
var discountPeriods;
var modelName = "Discount";
showLoading(true);
console.log("document.readyState : "+document.readyState);
function init() {
	console.log("onload...");
	console.log("onload - discountPeriodHolder : "+discountPeriodHolder.hasChildNodes());
	while (discountPeriodHolder.hasChildNodes()) {
		discountPeriodHolder.removeChild(discountPeriodHolder.lastChild);
	}
	loadDefaultData(function() {
		populateCurrencyCode();
		setInterval(function() {
			checkForm();
		}, 1000);
		console.log("onload - mode : "+mode);
		if (mode == "create") {
			AddAnotherPeriod();
		}
	});
	
}
if(document.readyState == 'complete') {
	init();
} else {
	window.addEventListener('load', init);
}

function Period(startDate, endDate, discountType, discountValue, 
		minQty, maxQty, extPromoCode, deleteStatus) {
	this.startDate = startDate;
	this.endDate = endDate;
	this.discountType = discountType;
	this.discountValue = discountValue;
	this.minQty = minQty;
	this.maxQty = maxQty;
	if(typeof extPromoCode !== "undefined" && extPromoCode!=null) {
		this.extPromoCode = extPromoCode.trim();
	}
	this.deleteStatus = deleteStatus;
}

function loadDefaultData(callback) {
	console.log("loadDefaultData - mode : "+mode);
	loadDropdownList("Currency%20Code", document.getElementById(namespace
			+ "currencyCode"), function(){
		if (mode != "create") {
			fetchDetails(formStorageId);
		} else {
			showLoading(false);
		}
		callback();
	});
}

function loadDropdownList(strSubURI, elementDrpDwn, callback) {

	console.log("strSubURI : "+strSubURI);
	console.log("vocabularyURL : "+vocabularyURL);
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
													currencyList = responseData;
													console.log("currencyList : "+currencyList.length);
													callback();
												},
												failure : function() {
													console
															.log("Error in the ajax call.");
													callback();
												}
											}
										});
					});

}

function fetchDetails(formStorageId) {
	showLoading(true);
	if (formStorageId != "") {
		data = {};
		data.formStorageId = formStorageId;
		data.formType = "discount";
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
						var sc = contentdata.contentJson.DiscountCode;
						if (mode == "copy") {
							sc = "Copy-of-" + sc;
						}
						getEID(namespace + "discountCode").value = sc;
						if(mode=="edit") {
							if(contentdata.contentJson.Status=="Draft") {
								getEID("status").value = "Active";
							} else {
								getEID("status").value = contentdata.contentJson.Status;
							}
						}
						getEID(namespace + "discountName").value = contentdata.contentJson.DiscountName;
						if(mode=="view") {
							getEID(namespace + "discountDescription").value = 
								(contentdata.contentJson.Description === "")?"Not Specified":contentdata.contentJson.Description;
							getEID(namespace + "currencyCode").value = 
								(contentdata.contentJson.CurrencyCode === "")?"Not Specified":contentdata.contentJson.CurrencyCode;
						} else {
							getEID(namespace + "discountDescription").value = contentdata.contentJson.Description;
							getEID(namespace + "currencyCode").value = contentdata.contentJson.CurrencyCode;
						}
						getEID(namespace + "discountCategory").value = contentdata.contentJson.Category;
						var periods = contentdata.contentJson.Periods;
						var selectOption = document.getElementById(namespace
								+ 'discountCategory');
						selectedDiscountCategory = selectOption.options[selectOption.selectedIndex].value;
						if (selectedDiscountCategory === 'DiscountPrice') {
							discountPeriodContainer = discountPriceScreen;
						} else if (selectedDiscountCategory === 'DiscountPriceForBulk') {
							discountPeriodContainer = discountPriceForBulkPurchase;
						} else if (selectedDiscountCategory === 'DiscountPriceWithPromoCode') {
							discountPeriodContainer = discountPriceWithPromocode;
						}
						addAllDataToArray();
						for (var i = 0; i < periods.length; i++) {
							var ss = new Period(periods[i].startDate,
									periods[i].endDate, periods[i].discType,
									periods[i].value,
									periods[i].minQty, periods[i].maxQty,
									periods[i].extPromoCode, "Active");
							discountPeriodList.push(ss);
						}
						drawDiscountPeriod();
						if (mode == "edit"
								&& contentdata.contentJson.Status == "Inactive") {
							getEID("activate").style.display = "";
							getEID("deactivate").style.display = "none";
						} else if (mode == "edit") {
							getEID("activate").style.display = "none";
							getEID("deactivate").style.display = "";
							getEID(namespace + "discountCode").disabled = true;
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
	var form = document.getElementById("discountPromotion_form");
	var elements = form.elements;
	for (var i = 0, len = elements.length; i < len; ++i) {
		elements[i].readOnly = true;
		elements[i].disabled = true;
	}
}

function drawDiscountPeriod() {
	console.log("drawDiscountPeriod - discountPeriodHolder : "+discountPeriodHolder.hasChildNodes());
	var count = 0;
	var i;
	while (discountPeriodHolder.hasChildNodes()) {
		discountPeriodHolder.removeChild(discountPeriodHolder.lastChild);
	}
	console.log("drawDiscountPeriod - discountPeriodList : "+JSON.stringify(discountPeriodList));
	for (i = 0; i < discountPeriodList.length; i++) {
		var node = discountPeriodContainer.cloneNode(true);
		var header = node.getElementsByClassName("header")[0]
				.getElementsByTagName("div")[0];
		var startDate = node.getElementsByClassName("startDate")[0];
		var endDate = node.getElementsByClassName("endDate")[0];
		var discountValue = node.getElementsByClassName("discountValue")[0];
		var discountType = node.getElementsByClassName("discountType")[0];
		if(mode=="view") {
			startDate.value = (typeof discountPeriodList[i].startDate === "undefined")?"-":discountPeriodList[i].startDate;
			endDate.value = (typeof discountPeriodList[i].endDate === "undefined")?"-":discountPeriodList[i].endDate;
		} else if(mode=="edit" || mode=="copy") {
			startDate.value = (typeof discountPeriodList[i].startDate === "undefined")?"":discountPeriodList[i].startDate;
			endDate.value = (typeof discountPeriodList[i].endDate === "undefined")?"":discountPeriodList[i].endDate;
		} else {
			startDate.value = discountPeriodList[i].startDate;
			endDate.value = discountPeriodList[i].endDate;
		}
		discountValue.value = discountPeriodList[i].discountValue;
		var discountTypeOptionArray = discountType
				.getElementsByTagName("option");
		for (var j = 0; j < discountTypeOptionArray.length; j++) {
			if (discountTypeOptionArray[j].value === discountPeriodList[i].discountType) {
				discountTypeOptionArray[j].selected = true;
				break;
			}
		}
		
		node.getElementsByClassName("deleteStatus")[0].innerHTML = discountPeriodList[i].status;
		var minQuantity, maxQuantity;
		if (selectedDiscountCategory === 'DiscountPriceForBulk') {
			minQuantity = node.getElementsByClassName("minQuantity")[0];
			maxQuantity = node.getElementsByClassName("maxQuantity")[0];
			if(mode=="view") {
				if(typeof discountPeriodList[i].minQty === "undefined") {
					minQuantity.placeholder = "Not Specified";
				} else {
					minQuantity.value = discountPeriodList[i].minQty;
				}
				if(typeof discountPeriodList[i].maxQty === "undefined") {
					maxQuantity.placeholder = "Not Specified";
				} else {
					maxQuantity.value = discountPeriodList[i].maxQty;
				}
			} else {
				minQuantity.value = discountPeriodList[i].minQty;
				maxQuantity.value = discountPeriodList[i].maxQty;
			}
		} else if (selectedDiscountCategory === 'DiscountPriceWithPromoCode') {
			var extPromoCode = node.getElementsByClassName("extPromoCode")[0];
			minQuantity = node.getElementsByClassName("minQuantity")[0];
			maxQuantity = node.getElementsByClassName("maxQuantity")[0];
			if(mode=="view") {
				if(typeof discountPeriodList[i].minQty === "undefined") {
					minQuantity.placeholder = "Not Specified";
				} else {
					minQuantity.value = discountPeriodList[i].minQty;
				}
				if(typeof discountPeriodList[i].maxQty === "undefined") {
					maxQuantity.placeholder = "Not Specified";
				} else {
					maxQuantity.value = discountPeriodList[i].maxQty;
				}
			} else {
				minQuantity.value = discountPeriodList[i].minQty;
				maxQuantity.value = discountPeriodList[i].maxQty;
			}
			extPromoCode.value = discountPeriodList[i].extPromoCode;
		}
		console.log("discountPeriodList[i].deleteStatus : "
				+ discountPeriodList[i].deleteStatus);
		if (discountPeriodList[i].deleteStatus != "Remove") {
			count = count + 1;
			if (selectedDiscountCategory === 'DiscountPrice') {
				if (count < 9) {
					header.innerText = "PERIOD 0" + count;
				} else {
					header.innerText = "PERIOD " + count;
				}
			} else {
				if (count < 9) {
					header.innerText = "QUANTITY 0" + count;
				} else {
					header.innerText = "QUANTITY " + count;
				}
			}
			node.style.display = "block";
			discountPeriodHolder.appendChild(node);
		}
	}
}

function populateCurrencyCode() {
	var currencyCode = getEID(namespace+"currencyCode");
	var opt = new Option(
			"Select Currency Code...",
			"");
	currencyCode.options[currencyCode.options.length] = opt;
	for (j = 0; j < currencyList.length; j++) {
		var opt = new Option(
				currencyList[j].name,
				currencyList[j].id);
		currencyCode.options[currencyCode.options.length] = opt;
	}
}

function addAllDataToArray() {
	console.log("addAllDataToArray - discountPeriodList : "+discountPeriodList.length);
	while (discountPeriodList.length > 0) {
		discountPeriodList.pop();
	}
	console.log("addAllDataToArray - discountPeriodHolder.childElementCount : "+discountPeriodHolder.childElementCount);
	var c = discountPeriodHolder.childElementCount;
	for (var i = 0; i < c; i++) {
		var node = discountPeriodHolder.childNodes[i];
		console.log("node : "+node.html);
		var ss = null;
		var startDate = node.getElementsByClassName("startDate")[0];
		var endDate = node.getElementsByClassName("endDate")[0];
		var discountValue = node.getElementsByClassName("discountValue")[0];
		var discountType = node.getElementsByClassName("discountType")[0];
		var deleteStatus = node.getElementsByClassName("deleteStatus")[0];
		console.log("deleteStatus : " + deleteStatus.innerHTML);
		if (deleteStatus.innerHTML != "Remove") {
			if (selectedDiscountCategory === 'DiscountPrice') {
				ss = new Period(startDate.value, endDate.value,
						discountType.options[discountType.selectedIndex].value,
						discountValue.value,
						"", "", "", deleteStatus.innerHTML);
			} else if (selectedDiscountCategory === 'DiscountPriceForBulk' 
				|| selectedDiscountCategory === 'DiscountPriceWithPromoCode') {
				var minQuantity = node.getElementsByClassName("minQuantity")[0];
				var maxQuantity = node.getElementsByClassName("maxQuantity")[0];
				console.log("minQuantity : "+minQuantity.value);
				console.log("maxQuantity : "+maxQuantity.value);
				var extPromoCode = "";
				if(selectedDiscountCategory === 'DiscountPriceWithPromoCode') {
					extPromoCode = node.getElementsByClassName("extPromoCode")[0];
				}
				ss = new Period(startDate.value, endDate.value,
						discountType.options[discountType.selectedIndex].value,
						discountValue.value,
						minQuantity.value, maxQuantity.value, extPromoCode.value,
						deleteStatus.innerHTML);
			}
			discountPeriodList.push(ss);
		}
	}
}
function changeDiscountCategory() {
	var selectOption = document.getElementById(namespace + 'discountCategory');
	selectedDiscountCategory = selectOption.options[selectOption.selectedIndex].value;
	console.log("selectedDiscountCategory : " + selectedDiscountCategory);
	if (selectedDiscountCategory === 'DiscountPrice') {
		getEID("addPeriodButton").value = "ADD PERIOD";
		getEID("addPeriodButton").innerHTML = "ADD PERIOD";
	} else if (selectedDiscountCategory === 'DiscountPriceForBulk'
		|| selectedDiscountCategory === 'DiscountPriceWithPromoCode') {
		getEID("addPeriodButton").value = "ADD QUANTITY";
		getEID("addPeriodButton").innerHTML = "ADD QUANTITY";
	}
	console.log("getEID : " + getEID("addPeriodButton").value);
	discountPeriodList = [];
	drawDiscountPeriod();
	AddAnotherPeriod();
}

function AddAnotherPeriod() {
	var selectOption = document.getElementById(namespace + 'discountCategory');
	console.log("AddAnotherPeriod - selectOption : "+selectOption);
	selectedDiscountCategory = selectOption.options[selectOption.selectedIndex].value;
	console.log("AddAnotherPeriod - selectedDiscountCategory : "+selectedDiscountCategory);
	if (selectedDiscountCategory === 'DiscountPrice') {
		discountPeriodContainer = discountPriceScreen;
	} else if (selectedDiscountCategory === 'DiscountPriceForBulk') {
		discountPeriodContainer = discountPriceForBulkPurchase;
	} else if (selectedDiscountCategory === 'DiscountPriceWithPromoCode') {
		discountPeriodContainer = discountPriceWithPromocode;
	}
	addAllDataToArray();
	var ss = new Period("", "", "", "", "", "", "", "", "");
	discountPeriodList.push(ss);
	drawDiscountPeriod();
}

function RemoveDiscountPeriod(e) {
	var eRmv = e.parentElement.parentElement.parentElement.parentElement;
	eRmv.getElementsByClassName("deleteStatus")[0].innerHTML = "Remove";
	addAllDataToArray();
	drawDiscountPeriod();
	console.log("discountPeriodList.length : " + discountPeriodList.length);
	if (discountPeriodList.length == 0) {
		AddAnotherPeriod();
	}
}

function validateFields(action) {
	if (checkIsValide()) {
		submitDiscount(action);
	}
}

function checkIsValide() {
	var eValid = true;
	addAllDataToArray();
	if (getEID(namespace + 'discountCode').value.trim() == "") {
		eValid = false;
		displayMessage('danger', "Discount Code is Mandatory", 3000);
	} else if (getEID(namespace + 'discountName').value.trim() == "") {
		eValid = false;
		displayMessage('danger', "Discount Name is Mandatory", 3000);
	} else if (discountPeriodList.length == 0) {
		eValid = false;
		displayMessage('danger', "At least one discount period is required",
				3000);
	}  else {
		var selectOption = document.getElementById(namespace
				+ 'discountCategory');
		selectedDiscountCategory = selectOption.options[selectOption.selectedIndex].value;
		console.log("discountPeriodList.length : " + discountPeriodList.length);
		var promoQtyMap = {};
		for (var i = 0; i < discountPeriodList.length; i++) {
			console.log("discountPeriodList[i].discountValue : "
					+ discountPeriodList[i].discountValue);
			if (discountPeriodList[i].discountValue == "") {
				eValid = false;
				displayMessage('danger', "Discount Value is Mandatory", 3000);
				break;
			}
			if (selectedDiscountCategory == 'DiscountPriceWithPromoCode') {
				if (discountPeriodList[i].extPromoCode.trim() == "") {
					eValid = false;
					displayMessage('danger',
							"Discount Promo Code is Mandatory", 3000);
					break;
				}
			}
			console.log("--"+selectedDiscountCategory == 'DiscountPriceWithPromoCode');
			if (selectedDiscountCategory == 'DiscountPriceWithPromoCode'
					|| selectedDiscountCategory == 'DiscountPriceForBulk') {
				console.log("discountPeriodList[i].extPromoCode : "
						+ discountPeriodList[i].extPromoCode);
				console.log("promoQtyMap : "+JSON.stringify(promoQtyMap));
				var val = promoQtyMap[discountPeriodList[i].extPromoCode==""?"-":discountPeriodList[i].extPromoCode];
				console.log("val : "+val);
				if(val == null) {
					val = {
							minQty : discountPeriodList[i].minQty == ""?0:discountPeriodList[i].minQty,
							maxQty : discountPeriodList[i].maxQty == ""?Number.POSITIVE_INFINITY:discountPeriodList[i].maxQty
					}
					promoQtyMap[discountPeriodList[i].extPromoCode==""?"-":discountPeriodList[i].extPromoCode] = val;
					console.log("val : "+JSON.stringify(val));
				} else {
					var currMinQty = discountPeriodList[i].minQty == ""?0:discountPeriodList[i].minQty;
					var currMaxQty = discountPeriodList[i].maxQty == ""?Number.POSITIVE_INFINITY:discountPeriodList[i].maxQty;
					console.log("currMinQty : "+currMinQty);
					console.log("currMaxQty : "+currMaxQty);
					console.log("1 : "+(currMinQty>=val.minQty && currMaxQty<=val.maxQty));
					console.log("2 : "+(currMaxQty>=val.minQty && currMaxQty<=val.maxQty));
					if(parseFloat(currMinQty) <= parseFloat(val.maxQty) && 
							parseFloat(val.minQty) <= parseFloat(currMaxQty)) {
						eValid = false;
						displayMessage(
								'danger',
								"A quantity range must not overlap with other period's qunatity range",
								3000);
						break;
					}
				}
				console.log(discountPeriodList[i].minQty+" | "+discountPeriodList[i].maxQty);
				console.log(discountPeriodList[i].minQty > discountPeriodList[i].maxQty);
				if (discountPeriodList[i].minQty != ""
						&& discountPeriodList[i].maxQty != ""
						&& parseFloat(discountPeriodList[i].minQty) > parseFloat(discountPeriodList[i].maxQty)) {
					eValid = false;
					displayMessage(
							'danger',
							"Min Quantity must be less than or equal to Max Quantity",
							3000);
					break;
				}
			}
			if(discountPeriodList[i].discountType=="Percentage" && parseFloat(discountPeriodList[i].discountValue)>100) {
				eValid = false;
				displayMessage(
						'danger',
						"Invalid percentage value",
						3000);
				break;
			}
		}
	}
	
	var discTypes = document.getElementsByClassName("discountType");
	for(var i = 0; i < discTypes.length; i++)
	{
		console.log("discTypes.item(i).value : "+discTypes.item(i).value);
	   if(discTypes.item(i).value=="Amount") {
		   var currencyCode = getEID(namespace+"currencyCode");
		   console.log("currencyCode.value : "+currencyCode.value);
		   if(currencyCode.value=="") {
			   eValid = false;
				displayMessage(
						'danger',
						"Currency code is mandatory",
						3000);
				break;
		   }
	   }
	}
	
	return eValid;
}

function submitDiscount(action) {
	showLoading(true);
	var discountCode = getEID(namespace + "discountCode");
	var discountName = getEID(namespace + "discountName");
	var discountDescription = getEID(namespace + "discountDescription");
	var discountCategory = getEID(namespace + "discountCategory");
	var discountCCyCode = getEID(namespace + "currencyCode");
	var discount = {};
	discount.DiscountCode = discountCode.value.trim().replace(/\s+/g, '-');
	discount.DiscountName = discountName.value.trim();
	discount.Description = discountDescription.value;
	discount.Category = discountCategory.value;
	discount.CurrencyCode = discountCCyCode.value;
	discount.Periods = [];
	for (var i = 0; i < discountPeriodList.length; i++) {
		var discountPeriod = {};
		var discountPeriodData = discountPeriodList[i];
		discountPeriod.discType = discountPeriodData.discountType;
		discountPeriod.value = discountPeriodData.discountValue;
		discountPeriod.startDate = discountPeriodData.startDate;
		discountPeriod.endDate = discountPeriodData.endDate;
		var selectOption = document.getElementById(namespace+ 'discountCategory');
		selectedDiscountCategory = selectOption.options[selectOption.selectedIndex].value;
		console.log("selectedDiscountCategory : "+selectedDiscountCategory);
		console.log("minQty : "+discountPeriodData.minQty);
		console.log("maxQty : "+discountPeriodData.maxQty);
		if (selectedDiscountCategory === 'DiscountPriceWithPromoCode') {
			discountPeriod.extPromoCode = discountPeriodData.extPromoCode.trim();
		} 
		if (selectedDiscountCategory === 'DiscountPriceForBulk' || 
				selectedDiscountCategory === 'DiscountPriceWithPromoCode') {
			discountPeriod.minQty = discountPeriodData.minQty;
			discountPeriod.maxQty = discountPeriodData.maxQty;
		}
		discount.Periods.push(discountPeriod);
	}
	if(mode=="edit") {
		discount.Status = getEID("status").value;
		discount.formStorageId = formStorageId;
	} else {
		if (action == "publish") {
			discount.Status = "Active";
		} else {
			discount.Status = "Draft";
		}
	}
	discount.formType = "discount";
	console.log(discount);
	console.log(JSON.stringify(discount));
	ajaxCallAPI('POST', 'persist', discount, function() {
		let data = this.get("responseData");
		if (data.error) {
			displayMessage('danger', data.error, 3000);
		} else if (Object.keys(data).length === 0) {
			console.log("data : "+data);
			displayMessage('danger', 'Form submission failed.', 3000);
		} else {
			console.log(data.toString());
			var message = "Form successfully submitted.";
			if (discount.Status == "Draft")
				message = "Record is saved in draft";
			displayMessage('success', message, 3000);
			afterFormSubmissionFormIOForm(discount);
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
	var formType = "Promo/Discount";
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
	if (document.getElementById(namespace + "discountCode").value.trim() != ""
			&& document.getElementById(namespace + "discountName").value.trim() != "") {
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
	document.getElementById("discountPromotion_form").reset();
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

/** ****************** Time Piker ********************* */

YUI().use('aui-timepicker', function(Y) {
	new Y.TimePicker({
		trigger : '#' + namespace + 'startTime',
		popover : {
			zIndex : 1
		},
		on : {
			selectionChange : function(event) {
			}
		}
	});
	new Y.TimePicker({
		trigger : '#' + namespace + 'endTime',
		popover : {
			zIndex : 1
		},
		on : {
			selectionChange : function(event) {
			}
		}
	});
});
