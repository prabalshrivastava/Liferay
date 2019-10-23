console.log("--:"+(typeof mode === "undefined"));
console.log("--:"+(typeof mode == "undefined"));
var modelName = "TransactionMaster";
var mode = mode;
var sendEmailToCandidate = sendEmailToCandidate;

function doProcessPaymentAction(action, linkelement){
	var storageId = linkelement=="none"?formStorageId:getStorageIdFromList(linkelement);
	if(action == "approve"){
		processRecord(action, storageId);
	}
	else if(action == "reject"){
		doInvoiceAction(action, linkelement)
	}
	else if(action == "samendments"){
		doInvoiceAction("return", linkelement)
	}
}

function doInvoiceGlobalAction(action) {
	getEID("action_msg").innerHTML = "Please key in your reasons below and confirm your action.";
	getEID("action_msg").placeholder = "Enter Reasons..."
	getEID("popup-submit-action").innerHTML = "SUBMIT";
	getEID("popup-cancel-action").innerHTML = "CANCEL";
	getEID("selectReasonDiv").style.display = "none";
	var title;
	if(action=="void") {
		title = "Void Receipts ?";
	} else if(action=="cancel") {
		title = "Cancel Receipts ?";
	} else if(action=="approve") {
		for(var ri in currentList) {
 			var receipt = currentList[ri];
 			processRecord(action, receipt.storageId);
 		}
		return;
	} else if(action=="reject") {
		title = "Reject ?";
	} else if(action=="return") {
		title = "Return for Amendments ?";
	}
	actionDialog(title, action, null, true);
}

function doInvoiceAction(action, linkElement) {
	getEID("action_msg").innerHTML = "Please key in your reasons below and confirm your action.";
	getEID("action_msg").placeholder = "Enter Reasons..."
	getEID("popup-submit-action").innerHTML = "SUBMIT";
	getEID("popup-cancel-action").innerHTML = "CANCEL";
	getEID("selectReasonDiv").style.display = "none";
	var title;
	if(action=="submit") {
		title = "Submit for Approval ?";
	} else if(action=="edit" && categoryType=="IN") {
		editDetails(formStorageId);
		return;
	} else if(action=="pdf") {
		if((typeof mode === "undefined")) {
			console.log("mode : ");
			console.log("getStorageIdFromList(linkElement) : "+getStorageIdFromList(linkElement));
			exportPdf(getStorageIdFromList(linkElement), null);
		} else {
			console.log("mode : "+mode);
			exportPdf(formStorageId, null);
		}
		return;
	} else if(action=="approve-receipt") {
		if((typeof mode === "undefined")) {
	    		processRecord("approve", getStorageIdFromList(linkElement));
	    	} else {
	    		processRecord("approve", formStorageId);
	    	}
		return;
	} else if(action=="approve" || action=="view") {
		goToDetails(getStorageIdFromList(linkElement));
		return;
	} else if(action=="reject") {
		title = "Reject ?";
	} else if(action=="return") {
		title = "Return for Amendments ?";
	} else if(action=="void" && categoryType=="IN") {
		title = "Void / Cancel Invoice ?";
	} else if(action=="void" && categoryType=="RE") {
		title = "Void Receipt ?";
		getEID("action_msg").innerHTML = "You are about to void a receipt. This action cannot be undone. " +
				"Please key in your reasons below and confirm your action.";
		getEID("popup-submit-action").innerHTML = "YES";
		getEID("popup-cancel-action").innerHTML = "NO";
	} else if(action=="gvoid" && categoryType=="RE") {
		title = "Void Receipts ?";
		getEID("action_msg").innerHTML = "You are about to void receipts. This action cannot be undone. " +
				"Please key in your reasons below and confirm your action.";
		getEID("popup-submit-action").innerHTML = "YES";
		getEID("popup-cancel-action").innerHTML = "NO";
	} else if(action=="cancel" && categoryType=="IN") {
		title = "Void / Cancel Invoice ?";
	} else if(action=="cancel" && categoryType=="RE") {
		title = "Cancel Receipt ?";
		getEID("action_msg").innerHTML = "You are about to cancel a receipt. This action cannot be undone. " +
		"Please key in your reasons below and confirm your action.";
		getEID("popup-submit-action").innerHTML = "SUBMIT";
		getEID("popup-cancel-action").innerHTML = "EXIT";
		getEID("action_reason").placeholder = "Elaborate with more details...";
		getEID("selectReasonDiv").style.display = "block";
	} else if(action=="pendingApproval"){
		title = "Submit for Approval ?";
		getEID("action_msg").innerHTML = "Please state any remarks (if any) and confirm your action.";
		getEID("action_reason").placeholder = "Enter Remarks..."
	} else if(action=="edit" && categoryType=="RE"){
		if(linkElement) {
			goToEdit(getStorageIdFromList(linkElement));
		} else {
			goToEdit(formStorageId);
		}
		return;
	} else {
		return;
	}
	actionDialog(title, action, linkElement);
}

function actionDialog(title, action, linkElement, global) {
	console.log("1 : "+document.getElementById("action_title").innerHTML);
	console.log("1 : "+title);
	document.getElementById("action_title").innerHTML = title;
	
	var popupdiv = "#action-dialog";
	var popupdivbox = "#action-dialog-box";
	AUI().use('aui-base', function(A) {
		   A.one(popupdiv).set('hidden', false);
		     YUI().use('aui-modal', function(Y) {
		        var modal = new Y.Modal({
		                             boundingBox: popupdiv,
		                             contentBox: popupdivbox,
		                             headerContent: '',
		                             centered: true,
		                             destroyOnHide: false,
		                             modal: true,
		                             resizable: false,
		                             draggable: true,
		         }).render();
		         Y.one('.close').on(
		         	      'click',
		         	      function() {
		         	        modal.hide();
		         	       modal = null;
		         	      }
		         	    );
		         Y.one('.popup-cancel-action').on(
		         	      'click',
		         	      function() {
		         	    	  console.log("popup-cancel-action...");
		         	        modal.hide();
		         	       modal = null;
		         	      }
		         	    );
		         
		         Y.one('.popup-submit-action').on(
		         	      'click',
		         	      function() {
		         	    	console.log("popup-submit-action...");
		         	    	modal.hide();
		         	    	modal = null;
		         	    	if(action=="pendingApproval"){
		         	    		processRecord(action, formStorageId);
		         	    	} else {
		         	    		if(global) {
			         	    		for(var ri in currentList) {
			         	    			var receipt = currentList[ri];
			         	    			processRecord(action, receipt.storageId);
			         	    		}
			         	    	} else {
			         	    		if((typeof mode === "undefined")) {
				         	    		processRecord(action, getStorageIdFromList(linkElement));
				         	    	} else {
				         	    		processRecord(action, formStorageId);
				         	    	}
			         	    	}
		         	    	}
		         	      }
		         	    );
		     });
		 });
}

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

function getDateByFormat(d) {
	var m = (d.getMonth() + 1);
	var t = d.getDate();
	var y = d.getFullYear();
	var s = t + "/" + m + "/" + y;
	return s;
}

function dateInitialization() {
	/** ****************** Date Piker ********************* */
	//var today1 = stringToDate(getDateByFormat(new Date()), "dd/mm/yyyy", "/");
	YUI().use('aui-datepicker', 'aui-form-validator', function(Y) {
		new Y.DatePicker({
			trigger : '#' + namespace + 'valueDate',
			mask : '%d/%m/%Y',
			popover : {
				zIndex : 1
			},
			calendar : {
				dateFormat : '%Y-%m-%d'
			}
		});
	});

	//var today2 = stringToDate(getDateByFormat(new Date()), "dd/mm/yyyy", "/");
	YUI().use('aui-datepicker', 'aui-form-validator', function(Y) {
		new Y.DatePicker({
			trigger : '#' + namespace + 'creditDate',
			mask : '%d/%m/%Y',
			popover : {
				zIndex : 1
			},
			calendar : {
				dateFormat : '%Y-%m-%d'
			}
		});
	});

}

function isError(e, m){
	var result = false;
	var t = document.getElementsByClassName(e)[0];
	if(t.value == ""){
		t.className ="field form-control " + e + " input-error";
		if(t.parentElement.previousElementSibling!=null){ t.parentElement.previousElementSibling.style="color:#c00;"; }
		document.getElementsByClassName(e+"-error")[0].innerHTML=""+m;
		result = true;
	}
	else{
		t.className ="field form-control " + e + " ";
		if(t.parentElement.previousElementSibling!=null){ t.parentElement.previousElementSibling.style=""; }
		document.getElementsByClassName(e+"-error")[0].innerHTML="";
	}
	return result;
}

function doMassPaymentValidation(){
	var validate = true;
	var msg = (palabelerrormsgrquired==undefined)?"This field is required.":palabelerrormsgrquired;
	if(isError("mass-process-valueDate", msg)){
		validate = false;
	}
	if(isError("mass-process-creditDate", msg)){
		validate = false;
	}
	if(isError("mass-process-paymentSetCode", msg)){
		validate = false;
	}
	if(validate){
		var vD = document.getElementsByClassName("mass-process-valueDate")[0].value;
		var cD = document.getElementsByClassName("mass-process-creditDate")[0].value
		validate = (stringToDate(cD, "dd/mm/yyyy", "/") > stringToDate(vD, "dd/mm/yyyy", "/"));
		if(!validate){
			var vdValue = document.getElementsByClassName("mass-process-valueDate")[0].value;
			msg = (palabelerrormsgvaluedate==undefined)?"Value date must be earlier than Credit date":palabelerrormsgvaluedate;
			document.getElementsByClassName("mass-process-valueDate")[0].value = "";
			isError("mass-process-valueDate", msg);
			document.getElementsByClassName("mass-process-valueDate")[0].value = vdValue;
		}
	}
	
	return validate;
}

function doMassProcessPayment(){
	var popupdiv = "#mass-process-action-dialog";
	var popupdivbox = "#mass-process-action-dialog-box";
	AUI().use('aui-base', function(A) {
		   A.one(popupdiv).set('hidden', false);
		     YUI().use('aui-modal', function(Y) {
		        var modal = new Y.Modal({
		                             boundingBox: popupdiv,
		                             contentBox: popupdivbox,
		                             headerContent: '<h2 class="PROCESS-PAYMENT" align="center">PROCESS PAYMENT</h2>',
		                             centered: true,
		                             destroyOnHide: false,
		                             modal: true,
		                             resizable: false,
		                             draggable: true,
		         }).render();
		         Y.one('.close').on(
		         	      'click',
		         	      function() {
		         	        modal.hide();
		         	       modal = null;
		         	      }
		         	    );
		         Y.one('.mass-process-popup-cancel-action').on(
		         	      'click',
		         	      function() {
		         	    	  console.log("popup-cancel-action...");
		         	    	 resetMassProcessPayment();
		         	        modal.hide();
		         	       modal = null;
		         	      }
		         	    );
		         
		         Y.one('.mass-process-popup-submit-action').on(
		         	      'click',
		         	      function() {
		         	    	console.log("popup-submit-action...");
		         	    	if(doMassPaymentValidation()){
		         	    	modal.hide();
		         	    	modal = null;
		         	    	massProcessRecord();
		         	    	showLoading(true);
		         	      }
		         	      }
		         	    );
		     });
		 });
	
}

dateInitialization();
function resetMassProcessPayment(){
	document.getElementsByClassName("mass-process-notes")[0].value = "none";
	document.getElementsByClassName("mass-process-valueDate")[0].value = "none";
	document.getElementsByClassName("mass-process-creditDate")[0].value = "none";
	isError("mass-process-valueDate", "");
	isError("mass-process-creditDate", "");
	isError("mass-process-paymentSetCode", "");
	document.getElementsByClassName("mass-process-notes")[0].value = "";
	document.getElementsByClassName("mass-process-valueDate")[0].value = "";
	document.getElementsByClassName("mass-process-creditDate")[0].value = "";
	document.getElementsByClassName("mass-process-paymentSetCode")[0].value = "";
}

function dateYYYYmmdd(ddmmYYYY){
	var dates = ddmmYYYY.split("/");
	return dates[2]+"-"+dates[1]+"-"+dates[0];
}

function recursiveProcessRecord(index, list){
	if(index == list.length){
		showLoading(false);
		//alert("Record Updated Successfully");
		resetMassProcessPayment();
		goToList();
		return;
	}
	var data = {};
	data.reason = document.getElementsByClassName("mass-process-notes")[0].value;
	data.valueDate = dateYYYYmmdd(document.getElementsByClassName("mass-process-valueDate")[0].value);
	data.creditDate = dateYYYYmmdd(document.getElementsByClassName("mass-process-creditDate")[0].value);
	data.paymentSetCode = document.getElementsByClassName("mass-process-paymentSetCode")[0].value;

	data.action = "process_payment";
	data.categoryMap = JSON.stringify(categoryMap);
	data.formType = modelName;
	data.formStorageId = list[index].storageId;

	ajaxCallAPI('POST', 'process', data, function() {
		setTimeout(function() {
			index++;
			recursiveProcessRecord(index, list);
		}, 500)
		
	}, function() {
		displayMessage('danger', "Error in processing record.", 3000);
		return;
	});
	
}

function doPDFExport(type){		 
	if(type == "PDF"){
		var data = {};
		data.formType = "transactionmaster";
		data.categoryMap = categoryMap;
		data.productSubtypeMap = productSubtypeMap;
		data.type = type;
		data.claimMap = claimMap;
		ajaxCallAPI(
				'POST',
				"exportPaymentAdvicePdf",
				data,
				function() {
					data = this.get("responseData");
					if (data.error) {
						displayMessage('danger', data.error, 3000);
					} else {
						let responseText = this.get("responseData");
						window.open(downloadPdfUrl+"&"+namespace+"filePath="+encodeURIComponent(responseText));	
						
					}
				}, function() {
					displayMessage('danger', "Error in processing record.", 3000);
				});
	}else{
		var globalexportlisturlcopy = exportPaymentAdviceExcel;
	    globalexportlisturlcopy += "&" + namespace + "formType=transactionmaster&" + namespace + "categoryMap="+categoryMap;
	    window.open(globalexportlisturlcopy);
			  
	}
}

function massProcessRecord(){

	var tddata = {};
	tddata.formType = modelName;
	tddata.conditions = ["transactionStatus=Pending",
	                     "categoryType=" + categoryMap[categoryType],
	                     "status=Active",
	                     "size=" + 2147483647 ];
	ajaxCallAPI('GET', "searchList", tddata, function(response) {
		var resData = this.get("responseData");
		if(resData.hasOwnProperty("content") && resData.content.length > 0){
			recursiveProcessRecord(0,resData.content)
		}
	}, function() {
		displayMessage('danger', "Error in fetching data.", 3000);
	});
}

function processRecord(action, storageId) {
	var preMode;
	if((typeof mode === "undefined")) {
		mode = "edit";
	} else {
		preMode = mode;
	}
	console.log("storageId : "+storageId);
	var data = {};
	console.log("action L "+action);
	console.log("action L "+categoryType);
	if(action=="cancel" && categoryType=="RE") {
		var selReason = getSelectedReason();
		console.log("selReason L "+selReason);
		console.log("action_reason L "+document.getElementById("action_reason").value);
		if(document.getElementById("action_reason").value!="") {
			data.reason = selReason + " - " + document.getElementById("action_reason").value;
		} else {
			data.reason = selReason;
		}
		console.log("Others L "+selReason.indexOf("Others"));
		if(selReason.indexOf("Others")>=0) {
			data.creditToBalance = true;
		} else {
			data.creditToBalance = false;
		}
	}
	else {
		data.reason = document.getElementById("action_reason").value;
	}
	if(action=="pendingApproval"){
		action="submit";
		data["transactionDetails"] = getMiscDetails();
		//data.reason = document.getElementsByClassName("mass-process-notes")[0].value;
		data.valueDate = dateYYYYmmdd(document.getElementsByClassName("mass-process-valueDate")[0].value);
		data.creditDate = dateYYYYmmdd(document.getElementsByClassName("mass-process-creditDate")[0].value);
		data.paymentSetCode = document.getElementsByClassName("mass-process-paymentSetCode")[0].value;
	}
	data.action = action;
	data.categoryMap = JSON.stringify(categoryMap);
	data.formType = modelName;
	data.formStorageId = storageId;
	data.categoryType = categoryType;
	ajaxCallAPI('POST', 'process', data, function() {
		console.log("--"+this.get("status"));
		console.log("--"+this.get("responseStatus"));
		let data = this.get("responseData");
		console.log("data : "+JSON.stringify(data));
		mode = preMode;
		if (data.error) {
			displayMessage('danger', data.error, 3000);
		} else {
			console.log("DONE...");
			if(action == "approve"){
				sendEmailToCandidate = true;
				exportPdf(storageId);
			}
				var popupdiv = "#action-feedback-dialog";
				var popupdivbox = "#action-feedback-dialog-box";
				AUI().use('aui-base', function(A) {
					   A.one(popupdiv).set('hidden', false);
					     YUI().use('aui-modal', function(Y) {
					        var modal = new Y.Modal({
					                             boundingBox: popupdiv,
					                             contentBox: popupdivbox,
					                             headerContent: '',
					                             centered: true,
					                             destroyOnHide: false,
					                             modal: true,
					                             resizable: false,
					                             draggable: true,
					         }).render();
					         Y.one('.close').on(
					         	      'click',
					         	      function() {
					         	    	 console.log("cloase...");
					         	        modal.hide();
					         	       window.location.reload();
					         	      }
					         	    );
					         Y.one('.popup-ok-action').on(
					         	      'click',
					         	      function() {
					         	    	  console.log("popup-ok-action...");
					         	        modal.hide();
					         	       window.location.reload();
					         	      }
					         	    );
					     });
					 });
		}
	}, function() {
		displayMessage('danger', "Error in processing record.", 3000);
	});
	
}

function getStorageIdFromList(linkElement) {
	console.log("linkElement : "+linkElement);
	var c = findAncestor(linkElement, "Row");
	console.log("c : "+c.id);
	var a = [];
	for (var b = 0; b < c.childElementCount; b++) {
		console.log("c.children[b].textContent : "+c.children[b].textContent);
		a.push(c.children[b].textContent.trim())
	}
	return a[0];
}

function doPaymentProcessAction(linkElement){
	formStorageId = getStorageIdFromList(linkElement);
	console.log("formStorageId : "+formStorageId);
	AUI().use('liferay-portlet-url', function(A) {
		var e = Liferay.PortletURL.createRenderURL();
		e.options.basePortletURL = baseUrl;
		e.setParameter("jspPage", config.paymentProcessPage);
		e.setParameter("formTypeName", modelName);
		e.setParameter("storageId", formStorageId);
		e.setPortletId(namespace.replace(/(^\_+|\_+$)/mg, ''));
		e.setWindowState("normal");
		console.log("e : "+e.toString());
		window.location.href = e.toString();
	});
}

function goToDetails(formStorageId) {
	console.log("formStorageId : "+formStorageId);
	AUI().use('liferay-portlet-url', function(A) {
		var e = Liferay.PortletURL.createRenderURL();
		e.options.basePortletURL = baseUrl;
		e.setParameter("jspPage", config.detailPage);
		e.setParameter("formTypeName", modelName);
		e.setParameter("storageId", formStorageId);
		e.setPortletId(namespace.replace(/(^\_+|\_+$)/mg, ''));
		e.setWindowState("normal");
		console.log("e : "+e.toString());
		window.location.href = e.toString();
	});
}

function goToEdit(formStorageId) {
	console.log("formStorageId : "+formStorageId);
	AUI().use('liferay-portlet-url', function(A) {
		var e = Liferay.PortletURL.createRenderURL();
		e.options.basePortletURL = baseUrl;
		e.setParameter("jspPage", config.collectPaymentEditPage);
		e.setParameter("formTypeName", modelName);
		e.setParameter("storageId", formStorageId);
		e.setPortletId(namespace.replace(/(^\_+|\_+$)/mg, ''));
		e.setWindowState("normal");
		console.log("e : "+e.toString());
		window.location.href = e.toString();
	});
}

function goToList() {
	window.location.href = baseUrl;
}

function editDetails(formStorageId) {
	console.log("formStorageId : "+formStorageId);
	AUI().use('liferay-portlet-url', function(A) {
		var e = Liferay.PortletURL.createRenderURL();
		e.options.basePortletURL = baseUrl;
		e.setParameter("jspPage", "/html/transaction/edit.jsp");
		e.setParameter("formTypeName", modelName);
		e.setParameter("storageId", formStorageId);
		e.setPortletId(namespace.replace(/(^\_+|\_+$)/mg, ''));
		e.setWindowState("normal");
		console.log("e : "+e.toString());
		window.location.href = e.toString();
	});
}

function exportPdf(formStorageId, contentJson) {
	showLoading(true);
	//get transaction master
	var preMode;
	if((typeof mode === "undefined")) {
		mode = "edit";
	} else {
		preMode = mode;
	}
	console.log("contentJson : ");
	console.log(contentJson);
	getTransactionMaster(formStorageId, contentJson, "transactionmaster", function(tmcontent, preview) {
		var tmcontentJson = tmcontent.contentJson;
		if(tmcontentJson != null) {
			var pt = tmcontentJson.ProductType;
			var pst = tmcontentJson.ProductSubType;
			var ct = tmcontentJson.CategoryType;
			var fc = tmcontentJson.FunctionalComponent;
			var type = tmcontentJson.Type;
			console.log("no..."+preview);
			if(!preview) {
				console.log("yess...");
				pt = productMap[tmcontentJson.ProductType];
				pst = productSubtypeMap[tmcontentJson.ProductSubType];
				ct = categoryMap[categoryType];
				fc = functionalDispMap[tmcontentJson.FunctionalComponent];
				type = clientTypeMap[tmcontentJson.Type];
			}
			pst = (pst==undefined?"2005":pst);
			getTemplateUrl(pt, pst, ct, fc, type , function(templateUrl) {
				mode = preMode;
				if(templateUrl == null) {
					getTemplateUrl(pt, null, ct, fc, type , function(templateUrl) {
						if(templateUrl == null) {
							showLoading(false);
							exportPdfError("Failed to get template url.");
						} else {
							var pdfData = preparePdfData(tmcontent, templateUrl);
							openPdf(pdfData);
						}
					});
				} else {
					var pdfData = preparePdfData(tmcontent, templateUrl);
					openPdf(pdfData);
				}
			});
		} else {
			showLoading(false);
			mode = preMode;
			exportPdfError("Failed to get transaction data.");
		}
	});
}

function getTransactionMaster(formStorageId, contentJson, formType, callback) {
	if(contentJson) {
		callback(contentJson, true);
		return;
	}
	var tmdata = {};
	tmdata.formStorageId = formStorageId;
	tmdata.formType = formType;
	tmdata.indetail = "true";
	console.log("tmdata : "+JSON.stringify(tmdata));
	ajaxCallAPI(
			'GET',
			"loadData",
			tmdata,
			function() {
				var tmcontentdata = this.get("responseData");
				console.log("tmcontentdata : " + JSON.stringify(tmcontentdata));
				if(typeof tmcontentdata === "undefined" || tmcontentdata == null || tmcontentdata.error) {
					callback(null, false);
				} else {
					callback(tmcontentdata, false);
				}
			}, function() {
				callback(null, false);
			});
}

function exportPdfError(error) {
	displayMessage('danger', error, 6000);
}

function getTemplateUrl(pt, pst, ct, fc, type, callback) {
	console.log("pt : "+pt);
	console.log("pst : "+pst);
	console.log("ct : "+ct);
	console.log("fc : "+fc);
	console.log("type : "+type);
	var tddata = {};
	tddata.formType = "transactiondocument";
	tddata.conditions = ["productType=" + pt,
	                     "productSubType=" + pst,
	                     "categoryType=" + ct,
	                     "functionalComponent=" + fc,
	                     "type=" + type,
	                     "status=Active",
			"size=" + 2147483647 ];
	ajaxCallAPI('GET', "searchList", tddata, function(response) {
		var tdcontentdata = this.get("responseData").content[0];
		console.log("tdcontentdata : " + JSON.stringify(tdcontentdata));
		if(typeof tdcontentdata === "undefined" || tdcontentdata == null || tdcontentdata.error) {
			callback(null);
		} else {
			callback(tdcontentdata.contentJson.TransactionTemplates[0].template);
		}
	}, function() {
		displayMessage('danger',
				"Error in fetching data.", 3000);
		callback(null);
	});
}

function filterValue(json, key, def) {
	var value = json.hasOwnProperty(key) ? json[key] : "";
	return value == "" ? (def==""?"":(" "+def)) : (" "+value);
}

function preparePdfData(tmcontent, templateUrl) {
	var addressLine1,addressLine2;
	var contentJson = tmcontent.contentJson;
	var docType = "";
	var number = typeof contentJson.ExtRefNumber === "undefined" ? "DRAFT" : contentJson.ExtRefNumber;
	var txnDate = typeof contentJson.TxnDate === "undefined" ? "" : contentJson.TxnDate;
	var duedate = typeof contentJson.DueDate === "undefined" ? "" : contentJson.DueDate;
	var nameOfPayer = typeof contentJson.NameOfPayer === "undefined" ? "" : contentJson.NameOfPayer;
	var addressOfPayer = typeof contentJson.AddressOfPayer === "undefined" ? "" : contentJson.AddressOfPayer;
	
	if(getEID("invoiceTypeIN") && getEID("invoiceTypeIN").checked && nameOfPayer!="" && !isNaN(nameOfPayer)){
		nameOfPayer = candidateMap[nameOfPayer];
	}
	if(addressOfPayer == "" && (contentJson.Type == "Individual" || contentJson.Type == clientTypeMap["Individual"])){
		if(typeof candidateDetailMap != "undefined"){
			var userData = candidateDetailMap[contentJson.UserId];
			if(userData!=undefined && userData.hasOwnProperty("contentJson"))
			{
				var cd = userData["contentJson"];
				var postCode = filterValue(cd,"PostalCode","").trim();
				postCode = postCode==""?"":(" ("+postCode+")");
				var unitNo = filterValue(cd,"UnitNo","");
				unitNo = unitNo == "" ? "" : "Unit " + unitNo;
				addressLine1 = filterValue(cd, "HouseBlockNo", "")
						+ filterValue(cd, "BuildingName", "")
						+ filterValue(cd, "StreetName", "");
				addressLine2 = unitNo + filterValue(cd, "Country", "Singapore")
						+ postCode;
				addressLine1 = addressLine1.trim();
				addressLine2 = addressLine2.trim();
			}
		}
	}
	
	var custDetails = [nameOfPayer, addressLine1, addressLine2];
	var docInfoValues=[];
	var docInfoColumns = [];
	var itemDetailsColumns = [];
	var itemDetailsColumnWidth = [];
	var itemDetailsValues = [];
	var itemDetailsValueAlignments = [];
	var totalUpperLeftValues = [];
	var totalUpperLeftColumns = [];
	var totalBottomLeftValues = [];
	var totalBottomLeftColumns = [];
	var totalRightValues = [];
	var totalRightColumns = [];
	var footerValues = [];
	var footerColumns = [];
	var paymentAdviceColumns = [];
	var paymentAdviceValues = [];
	var paymentModeColumns = [];
	var paymentModeValues = [];
	
	var grandTotal = 0;
	var totalAmount = 0;
	var totalTax = 0;
	var grandTotalB = 0;
	var totalAmountB = 0;
	var totalTaxB = 0;
	var baseCurrency;
	var currency;
	var exchRate;
	var itemDetailsDescWidthInChars = 20;
	console.log("categoryType : "+categoryType);
	console.log("contentJson.Type : "+contentJson.Type);
	if(categoryType=="IN") {
		docType = "TAX INVOICE";
		docInfoValues = [number,txnDate,duedate,"1 OF 1"];
		docInfoColumns = ["INVOICE NO", "INVOICE DATE", "DUE DATE", "PAGE"];
		itemDetailsColumns = ["S/N", "Description", "Currency", "Unit Price", "Quantity", "GST Tax Code", "Amt(excl. GST)"];
		itemDetailsColumnWidth = [5,20,15,20,10,15,15];
		itemDetailsValueAlignments = ["l","l","l","r","r","l","r"];
		var customerId = "";
		for(var i=0;i<contentJson.TransactionDetails.length;i++) {
			var detail = contentJson.TransactionDetails[i];
			if(contentJson.Type == "Individual" || contentJson.Type == clientTypeMap["Individual"]) {
				customerId =  detail.userId;
			}else{
				customerId =  detail.organisationId;
			}
			var title = (typeof detail.title === "undefined" ? "" : detail.title).trim();
			var desc = (typeof detail.description === "undefined" ? "" : detail.description).trim();
			var final_desc = "";
			if(title==undefined || title=="undefined" || title=="") {
				final_desc = desc;
			} else {
				final_desc = title+", "+desc;
			}
			if (detail.transactionStatus == "Waived") {
				final_desc = final_desc + " [Waived]";
			}
			
			currency = detail.currency;
			baseCurrency = detail.baseCurrency;
			exchRate = detail.exchangeRate;
			if(typeof miscFeeAllMap != "undefined"){
				title = miscFeeAllMap[title];
			}
			var item = [(i+1), final_desc,
					detail.currency,typeof detail.unitPrice === "undefined" ? "" : formatNumbers(detail.unitPrice),
							detail.quantity,(typeof detail.taxCode === "undefined" ||  detail.taxCode==null) ? "" : detail.taxCode,formatNumbers(detail.amount)
			];
			if (detail.transactionStatus != "Waived") {
				totalAmount = totalAmount + parseFloat(detail.amount);
				totalTax = totalTax + parseFloat(detail.tax);
				totalAmountB = totalAmountB + parseFloat(detail.amountAtBaseCurrency);
				totalTaxB = totalTaxB + parseFloat(detail.taxAtBaseCurrency);				
			}
			itemDetailsValues.push(item);
			tax=detail.tax*100/(detail.unitPrice*detail.quantity);
		}
		grandTotal = formatNumbers(parseFloat(totalAmount) + parseFloat(totalTax));
		grandTotalB = formatNumbers(parseFloat(totalAmountB) + parseFloat(totalTaxB));
		totalAmount = formatNumbers(totalAmount);
		totalTax = formatNumbers(totalTax);
		totalUpperLeftValues = [currency+"/"+baseCurrency+" "+exchRate,"$"+parseFloat(totalAmountB).toFixed(2),"$"+parseFloat(totalTaxB).toFixed(2),"$"+grandTotalB];
		totalUpperLeftColumns = ["Exchange rate","Total Amount payable excluding GST","Total GST payable","Total Amount Payable Including GST"];
		totalBottomLeftValues = ["GST 7% - $"+totalAmount];
		totalBottomLeftColumns = ["Amount subject to GST"];
		totalRightValues = [currency+" $"+totalAmount,currency+" $"+totalTax,currency+" $"+grandTotal];
		totalRightColumns = ["TOTAL INVOICE AMOUNT (Excluding GST)","7% GST","TOTAL INVOICE AMOUNT (Including GST)"];
		footerColumns = ["Generated ID","Date/Time Printed"];
		footerValues = [tmcontent.createdBy, formatDate(new Date())];
		paymentAdviceColumns = ["Customer No.","Invoice Number","Invoice Amount","Payment Amount"];
		paymentAdviceValues = [customerId, number, currency+" "+grandTotal, currency+" "+grandTotal];
	} else if(categoryType=="RE") {
		docType = "OFFICIAL RECEIPT";
		if(contentJson.Type == "Individual" || contentJson.Type == clientTypeMap["Individual"]) {
			var tax;
			if(contentJson.SourceType == sourceTypeMap["MS"]) {
				docInfoValues = [number,formatStringDate(txnDate),"1 OF 1"];
				docInfoColumns = ["TAX INVOICE / OFFICIAL RECEIPT NO", "TAX INVOICE / OFFICIAL RECEIPT DATE", "PAGE"];
				itemDetailsColumns = ["S/N","Description","Unit Price","Quantity","GST Tax Code","Amt Excl. GST"];
				itemDetailsColumnWidth = [10,35,15,10,15,35];
				itemDetailsValueAlignments = ["l","l","r","r","l","r"];
				
				for(i=0;i<contentJson.TransactionDetails.length;i++) {
					detail = contentJson.TransactionDetails[i];
					console.log("detail");
					console.log(detail);

					var title = (typeof detail.title === "undefined" ? "" : detail.title).trim();
					var desc = (typeof detail.description === "undefined" ? "" : detail.description).trim();
					var final_desc = "";
					if(title=="undefined" || title=="") {
						final_desc = desc;
					} else {
						final_desc = title+", "+desc;
					}
					if(typeof miscFeeAllMap != "undefined"){
						title = miscFeeAllMap[title];
					}
					
					item = [(i+1), final_desc,
							typeof detail.unitPrice === "undefined" ? "" : formatNumbers(detail.unitPrice),
							detail.quantity,typeof detail.taxCode === "undefined" ? "" : detail.taxCode,formatNumbers(detail.amount)];
					totalAmount = totalAmount + parseFloat(detail.amount);
					totalTax = totalTax + parseFloat(detail.tax);
					totalAmountB = totalAmountB + parseFloat(detail.amountAtBaseCurrency);
					totalTaxB = totalTaxB + parseFloat(detail.taxAtBaseCurrency);
					itemDetailsValues.push(item);
					tax=detail.tax*100/(detail.unitPrice*detail.quantity);
					
				}
				
				grandTotal = formatNumbers(parseFloat(totalAmount) + parseFloat(totalTax));
				totalAmount = formatNumbers(totalAmount);
				totalTax = formatNumbers(totalTax);
				
				totalBottomLeftValues.push("GST 7.00% - $" +formatNumbers(totalAmount));
				totalRightValues = ["$"+totalAmount,"$"+totalTax,"$"+grandTotal];
				totalRightColumns = ["TOTAL AMOUNT RECEIVED (Excluding GST)","7% GST","TOTAL AMOUNT RECEIVED (Including GST)"];
				footerColumns = ["Cashier ID","Date/Time Printed"];
				footerValues = [tmcontent.createdBy, formatDate(new Date())];
			} else {
				docInfoValues = [nameOfPayer,number,formatStringDate(txnDate),"1 OF 1"];
				docInfoColumns = ["CANDIDATE SRN", "OFFICIAL RECEIPT NO", "OFFICIAL RECEIPT DATE", "PAGE"];
				itemDetailsColumns = ["Exam/Test Code","Exam Description <if applicable>","Details of Payment","GST Tax Code","Amt Excl. GST"];
				itemDetailsColumnWidth = [15,30,30,12,13];
				itemDetailsValueAlignments = ["l","l","l","l","r"];
				for(i=0;i<contentJson.TransactionDetails.length;i++) {
					detail = contentJson.TransactionDetails[i];
					console.log("detail");
					console.log(detail);
					item = [typeof contentJson.Title === "undefined" ? "" : contentJson.Title, 
							typeof contentJson.Description === "undefined" ? "" : contentJson.Description, 
							(typeof detail.title === "undefined" ? "" : detail.title) + (typeof detail.description === "undefined" ? "" : ", "+detail.description), 
							(typeof detail.taxCode === "undefined" || detail.taxCode == null) ? "" : detail.taxCode, 
					        "$"+formatNumbers(detail.amount)];
					totalAmount = totalAmount + parseFloat(detail.amount);
					totalTax = totalTax + parseFloat(detail.tax);
					totalAmountB = totalAmountB + parseFloat(detail.amountAtBaseCurrency);
					totalTaxB = totalTaxB + parseFloat(detail.taxAtBaseCurrency);
					itemDetailsValues.push(item);
					tax=detail.tax*100/(detail.unitPrice*detail.quantity);
				}
				
				grandTotal = formatNumbers(parseFloat(totalAmount) + parseFloat(totalTax));
				totalAmount = formatNumbers(totalAmount);
				totalTax = formatNumbers(totalTax);
				totalBottomLeftValues.push("GST 7.00% - $" +formatNumbers(totalAmount));
				totalRightValues = ["$"+totalAmount,"$"+totalTax,"$"+grandTotal];
				totalRightColumns = ["TOTAL AMOUNT RECEIVED (Excluding GST)","7% GST","TOTAL AMOUNT RECEIVED (Including GST)"];
				footerColumns = ["Cashier ID","Date/Time Printed"];
				footerValues = [tmcontent.createdBy, formatDate(new Date())];
			}
			totalBottomLeftColumns = ["Amount subject to GST"];
		} else {
			docInfoValues = [number,formatStringDate(txnDate),"1 OF 1"];
			docInfoColumns = ["RECEIPT NO", "RECEIPT DATE", "PAGE"];
			itemDetailsColumns = ["S/N","Document Date","Document No","Amt Incl. GST"];
			itemDetailsColumnWidth = [5,30,55,10];
			itemDetailsValueAlignments = ["l","l","l","r"];
			for(i=0;i<contentJson.TransactionDetails.length;i++) {
				detail = contentJson.TransactionDetails[i];
				item = [(i+1), formatStringDate(txnDate), contentJson.ComponentRefNumber, "$"+formatNumbers(parseFloat(detail.amount)
						+ parseFloat(detail.tax))];
				totalAmount = totalAmount + parseFloat(detail.amount);
				totalTax = totalTax + parseFloat(detail.tax);
				totalAmountB = totalAmountB + parseFloat(detail.amountAtBaseCurrency);
				totalTaxB = totalTaxB + parseFloat(detail.taxAtBaseCurrency);
				itemDetailsValues.push(item);
			}
			totalTax = formatNumbers(totalTax);
			grandTotal = formatNumbers(parseFloat(totalAmount) + parseFloat(totalTax));
			totalRightValues = ["$"+grandTotal];
			totalRightColumns = ["TOTAL AMOUNT RECEIVED"];
			footerColumns = ["Cashier ID","Date/Time Printed"];
			footerValues = [tmcontent.createdBy, formatDate(new Date())];
		}
		var modes = "";
		var refNums = "";
		paymentModeColumns = ["PAYMENT MODE", "REFERENCE"];
		for(i=0;i<contentJson.PaymentDetails.length;i++) {
			modes = modes + contentJson.PaymentDetails[i].paymentModeType + ", ";
			if(typeof contentJson.PaymentDetails[i].paymentRefNo !=="undefined") {
				refNums = refNums + contentJson.PaymentDetails[i].paymentRefNo + ", ";
			}
		}
		modes = modes.slice(0, -2);
		refNums = refNums.slice(0, -2);
		modes = modes.toUpperCase()
		paymentModeValues = [modes, refNums];
		// misc fees?	
		
	} else if(categoryType=="CN") {
		docType = "CREDIT NOTE";
		docInfoValues = [number,formatStringDate(txnDate),formatStringDate(duedate),"1 OF 1"];
		docInfoColumns = ["CREDIT NOTE NO", "CREDIT NOTE DATE", "DUE DATE", "PAGE"];
		itemDetailsColumns = ["S/N", "Description", "Currency", "Unit Price(excl. GST)", "Quantity", "GST Tax Code", "Amt(excl. GST)"];
		itemDetailsColumnWidth = [5,20,15,20,10,15,15];
		itemDetailsValueAlignments = ["l","l","l","l","r","l","r"];
		for(i=0;i<contentJson.TransactionDetails.length;i++) {
			detail = contentJson.TransactionDetails[i];
			currency = detail.currency;
			baseCurrency = detail.baseCurrency;
			exchRate = detail.exchangeRate;
			item = [
					(i+1),
					typeof detail.description === "undefined" ? "" : detail.description,
					detail.currency,
					typeof detail.unitPrice === "undefined" ? "" : detail.unitPrice,
					detail.quantity,
					typeof detail.taxCode === "undefined" ? "" : detail.taxCode,
					detail.amount
			];
			totalAmount = totalAmount + parseFloat(detail.amount);
			totalTax = totalTax + parseFloat(detail.tax);
			totalAmountB = totalAmountB + parseFloat(detail.amountAtBaseCurrency);
			totalTaxB = totalTaxB + parseFloat(detail.taxAtBaseCurrency);
			itemDetailsValues.push(item);
		}
		grandTotal = formatNumbers(parseFloat(totalAmount) + parseFloat(totalTax));
		grandTotalB = formatNumbers(parseFloat(totalAmountB) + parseFloat(totalTaxB));
		totalAmount = formatNumbers(totalAmount);
		totalTax = formatNumbers(totalTax);
		totalUpperLeftValues = [currency+"/"+baseCurrency+" "+exchRate,"$"+totalAmountB,"$"+totalTaxB,"$"+grandTotalB];
		totalUpperLeftColumns = ["Exchange rate","Total Amount payable excluding GST","Total GST payable","Total Amount Payable Including GST"];
		totalBottomLeftValues = ["GST 7% - $"+totalAmount];
		totalBottomLeftColumns = ["Amount subject to GST"];
		totalRightValues = [currency+" "+totalAmount,currency+" "+totalTax,currency+" "+grandTotal];
		totalRightColumns = ["TOTAL AMOUNT RECEIVED (Excluding GST)","7% GST","TOTAL AMOUNT RECEIVED (Including GST)"];
		footerColumns = ["Generated ID","Date/Time Printed"];
		footerValues = [tmcontent.createdBy, formatDate(new Date())];
		
	}
	
	if(currency == baseCurrency){
		totalUpperLeftValues = ["","","",""];
		totalUpperLeftColumns = ["","","",""];
	}
	
	var data = {};
	data.docType = docType;
	data.custDetails = custDetails;
	data.mainDescription = contentJson.Description;
	data.docInfoColumns = docInfoColumns;
	data.docInfoValues = docInfoValues;
	data.invoiceDetails = {};
	data.invoiceDetails.itemDetailsValues = itemDetailsValues;
	data.invoiceDetails.itemDetailsColumns = itemDetailsColumns;
	data.invoiceDetails.itemDetailsColumnWidth = itemDetailsColumnWidth;
	data.invoiceDetails.itemDetailsValueAlignments = itemDetailsValueAlignments;
	data.invoiceDetails.totalUpperLeftValues = totalUpperLeftValues;
	data.invoiceDetails.totalUpperLeftColumns = totalUpperLeftColumns;
	data.invoiceDetails.totalBottomLeftValues = totalBottomLeftValues;
	data.invoiceDetails.totalBottomLeftColumns = totalBottomLeftColumns;
	data.invoiceDetails.totalRightValues = totalRightValues;
	data.invoiceDetails.totalRightColumns = totalRightColumns;
	data.invoiceDetails.paymentAdviceColumns = paymentAdviceColumns;
	data.invoiceDetails.paymentAdviceValues = paymentAdviceValues;
	data.invoiceDetails.paymentModeColumns = paymentModeColumns;
	data.invoiceDetails.paymentModeValues = paymentModeValues;
	data.footerColumns = footerColumns;
	data.footerValues = footerValues;
	data.itemDetailsDescWidthInChars = itemDetailsDescWidthInChars;
	var pdfData = {};
	pdfData.data = data;
	pdfData.templateUrl = templateUrl;
	if(number=="DRAFT") {
		pdfData.preview = true;
	} else {
		pdfData.preview = false;
	}
	console.log(pdfData);
	return JSON.stringify(pdfData);
}

var monthNames = [
          	    "Jan", "Feb", "Mar",
          	    "Apr", "May", "Jun", "Jul",
          	    "Aug", "Sep", "Oct",
          	    "Nov", "Dec"
          	  ];

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

function formatStringDate(dateString) {
	if(dateString == "")
		return "";
	var day = dateString.split("/")[0];
	var mon = dateString.split("/")[1];
	var year = dateString.split("/")[2];
	year = year.toString().slice(2,4);
	return day+"-"+monthNames[parseInt(mon)-1]+"-"+year;
}

function formatDate(date) {
	  var day = date.getDate();
	  var monthIndex = date.getMonth();
	  var year = date.getFullYear();
	  year = year.toString().slice(2,4);
	  var hr = date.getHours();
	  var min = date.getMinutes();

	  return day + ' ' + monthNames[monthIndex] + ' ' + year + ' '+hr+":"+min;
	}

function getTableJson(columns, items) {
	var jsonObj = {};
	var itemDescHeaderColumnList = columns;
	var itemDescHeaderColumnListValues = [];
	
	for(var i=0;i<items.length;i++) {
		var itemValues = items[i];
		var itemJson = {};
		for(var j=0;j<itemValues.length;j++) {
			itemJson[columns[j]] = itemValues[j];
		}
		itemDescHeaderColumnListValues.push(itemJson);
	}
	jsonObj.itemDescHeaderColumnList = itemDescHeaderColumnList;
	jsonObj.itemDescHeaderColumnListValues = itemDescHeaderColumnListValues;
	return jsonObj;
}

function getGenericJson(columns, values) {
	var jsonObj = {};
	var columnList = [];
	var columnListValues = {};
	for(var i=0;i<columns.length;i++) {
		columnList.push(columns[i]);
		columnListValues[columns[i]] = values[i];
	}
	jsonObj.columnList = columnList;
	jsonObj.columnListValues = columnListValues;
	return jsonObj;
}

function sendNotificationToCandidate(path){
	var data = {};
	data.formStorageId = formStorageId;
	data.formType = "transactionmaster";
	if(typeof invoiceType == "string"){
	if(invoiceType=="BOTH" || invoiceType==""){
		if(getEID("invoiceTypeIN").checked){
			data.individual = "individual";
		}
		else {
			data.corporate = "corporate";
		}
		
	}
	else if(invoiceType == "I"){
			data.individual = "individual";
		}
		else{
			data.corporate = "corporate";
		}
	}
	else if(typeof invoiceTypeDetail == "string"){
		if(invoiceTypeDetail.toLowerCase() == "individual"){
			data.individual = "individual";
		}
		else{
			data.corporate = "corporate";
		}
	}
	
	data.pdfLocation = path;
	ajaxCallAPI('GET', 'sendNotification', data, function() {
		var data = this.get("responseData");
		console.log(data);
		if (data == null){
			displayMessage('danger', "Something went wrong", 3000);
		}else if(data.error) {
			displayMessage('danger', data.error, 3000);
		}else {
			console.log("email sent : " + data.toString());			
		}
		showLoading(false);
	}, function() {
		displayMessage('danger', "Error in persisting dynamic form data.", 3000);
		showLoading(false);
	});
}

function openPdf(pdfData) {
	var data = JSON.parse(pdfData);
	data.formType = modelName;
	console.log('pdfData === ');
	ajaxCallAPI('POST', 'preparePdf', data, function() {
		showLoading(false);
		let responseText = this.get("responseData");
		console.log(responseText);
		if(sendEmailToCandidate){
			sendNotificationToCandidate(responseText);
			sendEmailToCandidate = false;
		}
		else{
			window.open(downloadPdfUrl+"&"+namespace+"filePath="+encodeURIComponent(responseText));
			// Below code for open preview in same tab
			/*
			if(isPreviewPDF !=undefined && isPreviewPDF){
				document.getElementById("previewPdf").style="display:block"; 
				document.getElementById("invoicePDF").src=downloadPdfUrl+"&"+namespace+"filePath="+encodeURIComponent(responseText);
				setTimeout(function() {
					isPreviewPDF = false;
				}, 3000)
				
			}else{
				window.open(downloadPdfUrl+"&"+namespace+"filePath="+encodeURIComponent(responseText));
			}
			*/
		}
	});
}

function simpleStringify (object){
    var simpleObject = {};
    for (var prop in object ){
        if (!object.hasOwnProperty(prop)){
            continue;
        }
        if (typeof(object[prop]) == 'object'){
            continue;
        }
        if (typeof(object[prop]) == 'function'){
            continue;
        }
        simpleObject[prop] = object[prop];
    }
    return JSON.stringify(simpleObject); // returns cleaned up JSON
}

function getEID(id) {
	return document.getElementById(id);
}

function getSelectedReason() {
	var reasons = document.getElementsByName('reasonsCb');
	for(var i = 0; i < reasons.length; i++){
	    if(reasons[i].checked){
	    	return reasons[i].value;
	    }
	}
}

function checkAndSubmitLOR() {
	if(categoryType=="RE" && !disableLOR) {
		generateAndSubmitLOR();
	}
}

function generateAndSubmitLOR() {
	if(categoryType=="RE" && !disableLOR) {
		showLoading(true);
		console.log(currentList);
		var receiptDate;
		var division = "Examination Bureau";
		var receiptIds="";
		var receiptNumbersRange="";
		var issueReceipts=0;
		var voidReceipts=0;
		var cancelReceipts=0;
		var amountReceived=0;
		var mop="";
		for(var ri in currentList) {
			var receipt = currentList[ri].contentJson;
			receiptDate = receipt.TxnDate;
			if(ri==0 && currentList.length>1) {
				receiptIds = receipt.TransactionMasterCode + ",";
				receiptNumbersRange = receipt.ExtRefNumber +" - ";
			} else if(ri==0 && currentList.length==1) { 
				receiptIds = receipt.TransactionMasterCode;
				receiptNumbersRange = receipt.ExtRefNumber +" - " + receipt.ExtRefNumber;
			} else if(ri == (currentList.length -1)) {
				receiptNumbersRange = receiptNumbersRange + receipt.ExtRefNumber;
				receiptIds = receiptIds + receipt.TransactionMasterCode
			} else {
				receiptIds = receiptIds + receipt.TransactionMasterCode + ",";
			}
			if(receipt.TransactionStatus == "Confirmed") {
				issueReceipts++;
			} else if (receipt.TransactionStatus == "Void") {
				voidReceipts++;
			} else if (receipt.TransactionStatus == "Cancelled") {
				cancelReceipts++;
			}
			amountReceived = amountReceived + receipt.TotalAmountBaseCurrency;
			var paymentList = receipt.PaymentDetails;
			for(var pi in paymentList) {
				var payment = paymentList[pi];
				console.log("payment.paymentModeType : "+payment.paymentModeType);
				if(mop=="") {
					mop = payment.paymentModeType;
				} else {
					if(mop!=payment.paymentModeType) {
						mop = "All";
					}
				}
			}
		}
		var lorContentJson = {};
		lorContentJson.LORReportCode=generateCode("LOR-");
		lorContentJson.ReceiptDate=receiptDate;
		lorContentJson.Division=division;
		lorContentJson.ReceiptNumbers=receiptNumbersRange;
		lorContentJson.ReceiptIds=receiptIds;
		lorContentJson.IssueReceipts=issueReceipts;
		lorContentJson.CancelReceipts=cancelReceipts;
		lorContentJson.VoidReceipts=voidReceipts;
		lorContentJson.AmountReceived=amountReceived;
		lorContentJson.WorkflowStatus="PENDING";
		lorContentJson.ApprovalStatus="PENDING SUBMISSION";
		lorContentJson.ModeOfPayment=mop;
		lorContentJson.Status="Active";
		lorContentJson.formType = "lorreport";
		lorContentJson.CurrencyCode = baseCurrency;
		console.log(lorContentJson);
		ajaxCallAPI('POST', 'persist', lorContentJson, function() {
			let data = this.get("responseData");
			console.log(data);
			var errorf = "";
			if (data.error && data.error=="duplicate") {
				errorf = "Failed to submit LOR report. The filtered receipts have already report generated."
			} else if (data.error || Object.keys(data).length === 0) {
				console.log("data : "+data);
				errorf = "Failed to submit LOR report. Please check if there is already report created toady and is in process."
			}
			openDialog("lor", function(dialog){
				dialog.hide();
				showLoading(true);
				getOpenCounters(function(openCounters) {
					console.log(openCounters);
					if(openCounters.length!=0) {
						openDialog("message-failed", function(dialog) {
							dialog.hide();
						}, null);
					} else {
						if(errorf && errorf!="") {
							displayMessage('danger', errorf, 3000);
						} else {
							processLOR(data.storageId, "SUBMITTED FOR VERIFICATION", "PENDING VERIFICATION", document.getElementById("lor_action_reason").value);
						}
					}
					showLoading(false);
				});
			}, function() {
				
			});
			var old_element = document.getElementById("lor-pdf-link");
			var new_element = old_element.cloneNode(true);
			old_element.parentNode.replaceChild(new_element, old_element);
			document.getElementById("lor-pdf-link").addEventListener("click", function(){
				if(errorf && errorf!="") {
					exportLorPdf(lorContentJson, false);
				} else {
					exportLorPdf(data.storageId, false);
				}
			});
			showLoading(false);
		}, function() {
			displayMessage('danger', "Error in persisting dynamic form data.", 3000);
			showLoading(false);
		});
	}
}

function voidCancelReceipts() {
	doInvoiceAction("gvoid", null)
}
