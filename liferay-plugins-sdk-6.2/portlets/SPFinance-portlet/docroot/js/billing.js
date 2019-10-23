function round(value, decimals) {
  return Number(Math.round(value+'e'+decimals)+'e-'+decimals);
}

function showLoading(show) {
	if(show) {
		getEID("loadingDiv").style.display = "block";
	} else {
		getEID("loadingDiv").style.display = "none";
	}
}

function reset() {
	document.getElementById("billingForm").reset();
}

function enableViewMode() {
	var form = document.getElementById("billingForm");
	var elements = form.elements;
	for (var i = 0, len = elements.length; i < len; ++i) {
		elements[i].readOnly = true;
		elements[i].disabled = true;
	}
}

function enableFormViewMode(formId) {
	var form = document.getElementById(formId);
	var elements = form.elements;
	for (var i = 0, len = elements.length; i < len; ++i) {
		elements[i].readOnly = true;
		elements[i].disabled = true;
	}
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

function moveToList() {
	window.location.href = baseUrl;
}

function afterFormSubmissionFormIOForm(data) {
	console.log("data : " + JSON.stringify(data));
	console.log("data.formStorageId : " + data.formStorageId);
	var status = data.Status;
	var formType = viewName;
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
	console.log("formType : "+formType);
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
					showPopupError("Failed to perform action");
				} else if(data.error && data.error=="inuse"){
					console.log("error1");
					showPopupError(data[Object.keys(data)[0]]);
				} else if(data.errorCode && data.errorCode=="reference-error"){
					console.log("error2");
					showPopupError(data[Object.keys(data)[0]]);
				} else {
					showPopupSuccess(status,storageId);
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

function showPopupError(message){
	AUI().use('aui-base', function(A) {
		var boundingBox = "#action-error";
		var contentBox = "#action-error-box";
		document.getElementById("action-error-box").getElementsByClassName("message")[0].innerHTML=message;
		A.one(boundingBox).set('hidden', false);
		YUI().use('aui-modal', function(Y) {
			var modal = new Y.Modal({
				boundingBox: boundingBox,
				contentBox: contentBox,
				headerContent: '',
				centered: true,
				destroyOnHide: false,
				modal: true,
				resizable: false,
				draggable: false,
			}).render();
			Y.one('.close').on(
					'click',
					function() {
						window.location.reload();
						modal.hide();
					}
			);
		});

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

function fetchModelData(model, callback) {
	var data = {};
	data.formType = model;
	data.conditions = ["contentJson.Status=Active","size="+2147483647];
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
				}
				callback(responseData);
			}, function() {
				displayMessage('danger',
						"Error in downloading data.", 3000);
				callback();
			});
}	

function populateModelDataToDropDown(elementDrpDwn, data, keyColumn, valueColumn) {
	for(var i=0; i<data.length; i++) {
		var opt = new Option(data[i].contentJson[valueColumn], 
				data[i].contentJson[keyColumn]);
		elementDrpDwn.options[elementDrpDwn.options.length] = opt;
	}
}
function downloadVocabularyDropDownData(vocabulary, callback) {
	var strSubURI = vocabulary;
	var ajaxUrl = vocabularyURL.replace("$VCNAME", strSubURI);
	AUI().use('aui-base','aui-io-request-deprecated',
	function(A) {
		var _data = {};
		A.io.request(ajaxUrl,{
				dataType : 'json',
				method : "GET",
				data : _data,
				on : {
					success : function(){
								var responseData = this.get('responseData');
								callback(responseData);
							},
					failure : function() {
								console.log("Error in the ajax call.");
								callback([]);
							}
					}
			});
		});
}
function populateVocabularyDropDownData(dropdownId, data, keyColumn, valueColumn, callback) {
	var elementDrpDwn = getEID(namespace + dropdownId);
	for(var i=0; i<data.length; i++) {
		var opt = new Option(data[i][valueColumn], data[i][keyColumn]);
		elementDrpDwn.options[elementDrpDwn.options.length] = opt;
	}
	callback();
}

function formatNumbers(num) {
	console.log("num : "+num);
	num = round(parseFloat(num),2).toFixed(2);
	console.log("num : "+num);
	return addCommas(num);
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

function isHidden(el) {
    return (el.offsetParent === null)
}

function populateCommonDropdownData(dropdownId, valueList, callback) {
	var elementDrpDwn = document.getElementById(namespace + dropdownId);
	populateCommonDropdownDataToElement(elementDrpDwn, valueList, callback,
			dropdownId);
}
function populateCommonDropdownDataToElement(elementDrpDwn, valueList,
		callback, dropdownId) {
	for (var i = 0; i < valueList.length; i++) {
		var value = valueList[i];
		var opt = new Option(value.displayName, value.spListTypeId);
		elementDrpDwn.options[elementDrpDwn.options.length] = opt;
	}
	callback();
}

function getCurrencyExchangeRates(baseCurrency, targetCurrency, callback) {
		var data = {};
		data.formType = "CurrencyExchange";
		data.conditions = ["contentJson.Status=Active","contentJson.BaseCurrency=SGD","contentJson.CurrencyCode="+targetCurrency,"size="+2147483647
		                   ,"sort=contentJson.EffectiveDate,desc"];
		ajaxCallAPI(
				'GET',
				"searchList",
				data,
				function() {
					data = this.get("responseData");
					var contentdata = this.get("responseData");
					console.log("contentdata: "+JSON.stringify(contentdata));
					var responseData = [];
					if (data.error) {
						displayMessage('danger', data.error, 3000);
					} else {
						responseData = contentdata.content;
					}
					callback(responseData);
				}, function() {
					displayMessage('danger',
							"Error in getting exchange rates.", 3000);
					callback();
				});
}

function getCurrencyExchangeActiveRate(baseCurrency, targetCurrency, callback) {
	showLoading(true);
	if(baseCurrency==targetCurrency || baseCurrency=="" || targetCurrency=="") {
		showLoading(false);
		return callback(1);
	}
	getCurrencyExchangeRates(baseCurrency, targetCurrency, function(rateList) {
		console.log("rateList : " + JSON.stringify(rateList));
		var rate = 0;
		if ((typeof rateList !== "undefined") && rateList.length != 0) {
			for (var i = 0; i < rateList.length; i++) {
				var rateP = rateList[i];
				console.log("rate.contentJson : "
						+ rateP.contentJson.EffectiveDate);
				var currDate = new Date();
				var rateDate = new Date(rateP.contentJson.EffectiveDate);
				console.log("currDate : " + currDate);
				console.log("rateDate : " + rateDate);
				if (currDate.getTime() >= rateDate.getTime()) {
					rate = rateP.contentJson.ExchangeRate;
					showLoading(false);
					callback(rateP.contentJson.ExchangeRate);
					break;
				}
			}
		}
		showLoading(false);
	})
}

function getByStorageId(formStorageId, modelName, indetail, callback) {
	var data = {};
	data.formStorageId = formStorageId;
	data.formType = modelName;
	if(indetail){
		data.indetail = indetail;
	}
	console.log("data : "+JSON.stringify(data));
	ajaxCallAPI(
			'GET',
			"loadData",
			data,
			function() {
				var contentdata = this.get("responseData");
				console.log("contentdata : " + JSON.stringify(contentdata));
				if (contentdata.error) {
					displayMessage('danger', contentdata.error, 3000);
				} else {
					callback(contentdata);
				}
			}, function() {
				displayMessage('danger',
						"Error in fetching data.", 3000);
			});
}

function checkReceiptExist(storageIds, categoryId, modelName, callback) {
	var data = {};
	data.formStorageId = storageIds;
	data.receiptCategoryId = categoryId;
	data.formType = modelName;
	
	console.log("data : "+JSON.stringify(data));
	ajaxCallAPI(
			'GET',
			"fetchInvoiceReceipt",
			data,
			function() {
				var contentdata = this.get("responseData");
				console.log("contentdata : " + contentdata);
				callback(contentdata);
			}, function() {
				displayMessage('danger',
						"Error in fetching data.", 3000);
			});
}

function getTaxCodeDetail(callback) {
	var c = 'Singapore'
	var datas = {};
	datas.formType = "taxcode";
	datas.conditions = [ "contentJson.DefaultGST=yes",
			"contentJson.Status=Active", "contentJson.Country=" + c,
			"size=" + 2147483647, "sort=created_date,desc" ];
	var perc = 0;
	ajaxCallAPI('GET', "searchList", datas, function(response) {
		var data = this.get("responseData");
		if ((typeof data !== "undefined")
				&& (typeof data.content !== "undefined")
				&& data.content.length != 0) {
			var tax = data.content[0];
			console.log("data : " + tax);
			perc = tax.contentJson.Percentage;
			console.log("data : " + perc);
		}
		callback(perc);
	}, function() {
		showLoading(false);
		callback(perc);
	});
}

function getTaxCodeObject(callback) {
	var c = 'Singapore'
	var datas = {};
	datas.formType = "taxcode";
	datas.conditions = [ "contentJson.DefaultGST=yes",
			"contentJson.Status=Active", "contentJson.Country=" + c,
			"size=" + 2147483647, "sort=created_date,desc" ];
	var tax;
	ajaxCallAPI('GET', "searchList", datas, function(response) {
		var data = this.get("responseData");
		if ((typeof data !== "undefined")
				&& (typeof data.content !== "undefined")
				&& data.content.length != 0) {
			var tax = data.content[0];
			console.log("data : " + tax);
			tax = tax.contentJson;
		}
		callback(tax);
	}, function() {
		showLoading(false);
		callback(perc);
	});
}

function getWalletAmount(clientType, callback) {
	var datas = {};
	datas.clientType = clientType;
	var wamount = 0;
	ajaxCallAPI('GET', "walletamount", datas, function(response) {
		var data = this.get("responseData");
		if (typeof data !== "undefined") {
			wamount = data;
		}
		callback(wamount);
	}, function() {
		showLoading(false);
		callback(wamount);
	});
}

function generateTransactionMasterCode() {
	return generateCode("TMC-");
}

function generateCode(prefix) {
	if (mode == "edit") {
		return getEID(namespace + "transactionMasterCode").value;
	} else {
		var date = new Date();
		var now_utc = Date.UTC(date.getUTCFullYear(), date.getUTCMonth(), date
				.getUTCDate(), date.getUTCHours(), date.getUTCMinutes(), date
				.getUTCSeconds(), date.getUTCMilliseconds());
		console.log(now_utc);
		return prefix + now_utc;
	}
}

function openDialog(dialogName, submitFun, cancelFun) {
	AUI().use('aui-base',function(A) {
		A.one("#"+dialogName+"-dialog-bound").set('hidden', false);
		YUI().use('aui-modal',function(Y) {
			var modal = new Y.Modal({
				boundingBox : "#"+dialogName+"-dialog-bound",
				contentBox : "#"+dialogName+"-dialog-content",
				headerContent : '',
				centered : true,
				destroyOnHide : false,
				modal : true,
				resizable : false,
				draggable : true,
			}).render();
			Y.one('.close').on('click',function() {modal.hide();});
			if(Y.one('.'+dialogName+'-dialog-cancel')) {
				Y.one('.'+dialogName+'-dialog-cancel').on('click',function() {modal.hide();});
			}
			Y.one('.'+dialogName+'-dialog-submit').on('click',function() {
				submitFun(modal);
			});
		});
	});
}

function openDialogNew(dialogName, submitFun, cancelFun) {
	AUI().use('aui-base',function(A) {
		A.one("#"+dialogName+"-dialog-bound").set('hidden', false);
		YUI().use('aui-modal',function(Y) {
			var modal = new Y.Modal({
				boundingBox : "#"+dialogName+"-dialog-bound",
				contentBox : "#"+dialogName+"-dialog-content",
				headerContent : '',
				centered : true,
				destroyOnHide : false,
				modal : true,
				resizable : false,
				draggable : true,
			}).render();
			Y.one('body').on('key', function(event) {
			    modal.once('visibleChange', function(event) {
			        if (event.prevVal === true) {
			            event.newVal = true;
			        }
			    });
			}, 'esc');
			Y.one('.close').on('click',function() {
				if(modal) {
					modal.hide();
				}
				modal = null;
			});
			if(Y.one('.'+dialogName+'-dialog-cancel')) {
				Y.one('.'+dialogName+'-dialog-cancel').on('click',function() {
					if(modal) {
						modal.hide();
					}
					modal = null;
				});
			}
			Y.one('.'+dialogName+'-dialog-submit').on('click',function() {
				submitFun(modal);
			});
		});
	});
}

function getOpenCounters(callback) {
	var datas = {};
	datas.formType = "cashiercounter";
	datas.conditions = [ "contentJson.CounterStatus=OPEN",
			"contentJson.Status=Active", "size=2147483647", "sort=created_date,desc" ];
	ajaxCallAPI('GET', "searchList", datas, function(response) {
		var data = this.get("responseData");
		if ((typeof data !== "undefined")
				&& (typeof data.content !== "undefined")
				&& data.content.length != 0) {
			callback(data.content);
		} else {
			callback([]);
		}
	}, function() {
		showLoading(false);
		callback(perc);
	});
}

function searchBy(filterdata, conditions, sortyBy, modelName, indetail, ajaxurl, callback) {
	var jsonfilterparameter = {"limit":2147483647,"modelName":modelName,"page":0,"formType":modelName};
	jsonfilterparameter["filterdata"]=filterdata;
	jsonfilterparameter["conditions"]= conditions;
	jsonfilterparameter["sortby"]= sortyBy;
	jsonfilterparameter["indetail"]=indetail;
	ajaxCall('GET','elastiSearchList',ajaxurl,jsonfilterparameter,
		function() {
		var data = this.get("responseData");
		callback(data);
	});
}


function showHideElementById(id, display) {
	showHideElement(getEID(id), display);
}

function showHideElement(ele, display) {
	if (ele) {
		ele.style.display = display;
	}
}