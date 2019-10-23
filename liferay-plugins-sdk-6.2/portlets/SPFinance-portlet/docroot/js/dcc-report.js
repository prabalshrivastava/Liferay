if(document.readyState == 'complete') {
	init();
} else {
	window.addEventListener('load', init);
}

function init() {
	if (mode == "list") {
		getEID("MultirowPopAction").innerHTML = document
				.getElementById("MultirowPopActionNew").innerHTML;
		}
	if(mode=="view") {
		showLoading(true);
		getByStorageId(formStorageId, modelName, false, function(dccReportData) {
			console.log(dccReportData);
			getEID(namespace+"DCCReportCode").value = dccReportData.contentJson.DCCReportCode;
			getEID(namespace+"division").value = dccReportData.contentJson.Division;
			getEID(namespace+"collectionDate").value = dccReportData.contentJson.CollectionDate;
			getEID(namespace+"submissionDate").value = dccReportData.contentJson.SubmittedDate ? dccReportData.contentJson.SubmittedDate : "";
			getEID(namespace+"totalCashAmt").value = dccReportData.contentJson.TotalCashAmt;
			getEID(namespace+"totalNetsAmt").value = dccReportData.contentJson.TotalNetsAmt;
			getEID(namespace+"totalCcAmt").value = dccReportData.contentJson.TotalCcAmt;
			getEID(namespace+"totalCreditTransferAmt").value = dccReportData.contentJson.TotalCreditTransferAmt;
			getEID(namespace+"submittedBy").value = dccReportData.submittedBy ? dccReportData.submittedBy : "";
			getEID(namespace+"acknowledgedByAa").value = dccReportData.acknowledgedByAa? dccReportData.acknowledgedByAa : "";
			getEID(namespace+"acknowledgedDateAa").value = dccReportData.contentJson.AcknowledgedDateAa ? dccReportData.contentJson.AcknowledgedDateAa : "";
			getEID(namespace+"noOfCashSealedEnv").value = dccReportData.contentJson.NoOfCashSealedEnv ? dccReportData.contentJson.NoOfCashSealedEnv : "";
			getEID(namespace+"noOfChequeBankDraftSubmitted").value = dccReportData.contentJson.NoOfChequeBankDraftSubmitted;
			getEID(namespace+"totalChequeAmt").value = dccReportData.contentJson.TotalChequeAmt;
			getEID(namespace+"totalBankDraftAmt").value = dccReportData.contentJson.TotalBankDraftAmt;
			getEID(namespace+"totalInwardRemittanceAmt").value = dccReportData.contentJson.TotalInwardRemittanceAmt;
			getEID(namespace+"totalOthersAmt").value = dccReportData.contentJson.TotalOthersAmt;
			getEID(namespace+"acknowledgedByFnd").value = dccReportData.acknowledgedByFnd ? dccReportData.acknowledgedByFnd : "";
			getEID(namespace+"acknowledgedDateFnd").value = dccReportData.contentJson.AcknowledgedDateFnd ? dccReportData.contentJson.AcknowledgedDateFnd : "";
			getEID(namespace+"acknowledgementStatus").value = dccReportData.contentJson.AcknowledgementStatus;
			getEID("notes").value = dccReportData.contentJson.Notes ? dccReportData.contentJson.Notes : "";
			getEID(namespace+"totalAXSAmt").value = dccReportData.contentJson.TotalAxsAmt;
			getEID(namespace+"totalStripeAmt").value = dccReportData.contentJson.TotalStripeAmt;
			populateRemarks(formStorageId, function() {
				showButtons(dccReportData.contentJson.AcknowledgementStatus);
			});
		});
	}
}

function showButtons(as) {
	if(typeof as !== "undefined") {
		as = as.toUpperCase();
	}
	if(as == "PENDING SUBMISSION" || as == "PENDING AMENDMENTS"){
		showHideElementById("submitAckBtn", "block");
	}else{
		showHideElementById("submitAckBtn", "none");
		getEID(namespace + "noOfCashSealedEnv").readOnly = true;
	}
	if(as == "PENDING AA ACKNOWLEDGEMENT"){
		showHideElementById("ackAA", "block");
	}else{
		showHideElementById("ackAA", "none");
	}
	
	if(as == "PENDING FND ACKNOWLEDGEMENT"){
		showHideElementById("ackFND", "block");
	}else{
		showHideElementById("ackFND", "none");
	}
	
	if(as == "PENDING SUBMISSION" || as == "ACKNOWLEDGED"){
		showHideElementById("ammendmentsBtn", "none");
	}else{
		showHideElementById("ammendmentsBtn", "block");
	}
	if(as == "ACKNOWLEDGED"){
		getEID("notes").readOnly = true;
	}
	
	
}

function populateRemarks(formStorageId, callback) {
	var data = {};
	data.formType = "InvoiceRemarks";
	data.conditions = ["contentJson.ReferenceId="+formStorageId,"size="+2147483647,"sort=created_date,desc"];
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
					console.log("responseData : "+responseData.length);
					var olderAdded = false;
					var todayAdded = false;
					var processedBy = "";
					var txtheight = 20;
					var rtDiv = getEID(namespace+"remarkTemplate");
					getEID("invoiceRemarksContainer").innerHTML = "";
					getEID("totalRemarks").innerHTML = "";
					for(var i=0;i<responseData.length;i++) {
						var remark = responseData[i];
						var remarkTemplate = rtDiv.cloneNode(true);
						var remarksAction = remarkTemplate.getElementsByClassName("remarksAction")[0];
						var remarksTime = remarkTemplate.getElementsByClassName("remarksTime")[0];
						var remarksText = remarkTemplate.getElementsByClassName("remarksText")[0];
						var dayRow = remarkTemplate.getElementsByClassName("dayRow")[0];
						var dayText = remarkTemplate.getElementsByClassName("dayText")[0];

						if(remark.contentJson.RequestType.toLowerCase()=="pending"){
							remarksAction.innerHTML = "<b>"+remark.createdBy+"</b> returned for amendments";
						} else {
							remarksAction.innerHTML = "<b>"+remark.createdBy+"</b> "+remark.contentJson.RequestType.toLowerCase();
						}
						
						var dt = new Date(Date.parse(remark.createdDate));
						if(isToday(dt)) {
							if(todayAdded) {
								dayRow.style.display = "none";
							} else {
								dayRow.style.display = "block";
								dayText.innerHTML = "<b>Today</b>";
								todayAdded = true;
							}
							remarksTime.innerHTML = formatNumber(dt.getHours())+":"+formatNumber(dt.getMinutes());
						} else {
							if(olderAdded) {
								dayRow.style.display = "none";
							} else {
								olderAdded = true;
								dayRow.style.display = "block";
								dayText.innerHTML = "<b>Older</b>";
							}
							remarksTime.innerHTML = formatNumber(dt.getDate())+"/"+formatNumber(dt.getMonth()+1)
							+"/"+formatNumber(dt.getFullYear())+" "+formatNumber(dt.getHours())+":"+formatNumber(dt.getMinutes());
						}
						remarksText.innerHTML = remark.contentJson.Remark;
						remarkTemplate.style.display = "block";
						getEID("invoiceRemarksContainer").appendChild(remarkTemplate);
						if(processedBy.indexOf(remark.createdBy) == -1) {
							processedBy = processedBy + remark.createdBy + "\n";
						}
						//getEID("processedby").style.height = txtheight + 20;
					}
					getEID("totalRemarks").innerHTML = "(Total: "+responseData.length+" Remarks)";
					//getEID("processedby").value = processedBy;
					showLoading(false);
					callback();
				}
			}, function() {
				displayMessage('danger',
						"Error in populating remarks.", 3000);
				showLoading(false);
			});
}

function isToday(date) {
	var argDate = new Date(date);
	var todaysDate = new Date();
	if(argDate.setHours(0,0,0,0) == todaysDate.setHours(0,0,0,0)) {
	    return true;
	}
	return false;
}

function formatNumber(number) {
	return parseInt(number)<10?"0"+number:number;
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

function doDccAction(action, linkElement) {

	var as = "";
	var ws = "";
	var title = "";
	var subTitle = "";
	var noOfCashSealedEnv = "";
	if (action == "detail") {
		goToDetailScreen(linkElement);
	} else {
		if(action == "pdf"){
			generatePdf();
			return;
		}
		
		if (action == "ackAA") {
			if(checkIsValide()){
				var value = getEID(namespace+"noOfCashSealedEnv").value;
				if(value){
					noOfCashSealedEnv =  value;
				}
				as = "Pending AA Acknowledgement";
				ws = "Submit for AA Acknowledgement";
			}else{
				return;
			}
			
		}
		if (action == "ackFND") {
			as = "Pending FND Acknowledgement";
			ws = "Submit for FND Acknowledgement";
		}
		if (action == "acknowledge") {
			as = "Acknowledged";
			ws = "Submit for Acknowledged";
		}
		if (action == "ammendments") {
			as = "Pending Amendments";
			ws = "Return For Amendments";
		}
				
		getEID("dcc_action_reason").value = "";
		//getEID("action_title").innerHTML = title;
		/*if(subTitle){
			getEID("action_msg").innerHTML = subTitle;
		}*/
		openDialog("dcc-action", function(modal) {
			modal.hide();
			var sId = "";
			var notes = "";
			if (mode == "list") {
				sId = getStorageIdFromList(linkElement);
			} else {
				sId = formStorageId;
				notes = getEID("notes").value;
			}
			processDcc(sId, ws, as, document
					.getElementById("dcc_action_reason").value, noOfCashSealedEnv, notes);
		}, null);
	}
}

function checkIsValide() {
	var eValid = true;
	if (getEID(namespace + 'noOfCashSealedEnv').value.trim() == "") {
		eValid = false;
		_displayMessage("danger", "No of Cash Sealed Envelope is Mandatory", 3000);
	} 
	return eValid;
}

function _displayMessage(type, message, duration) {
	scrollToTop();
	var alert_div = getEID("alert_msg_id");
	alert_div.innerHTML = message;
	alert_div.classList.add("alert-" + type);
	alert_div.style.display = "block";
	setTimeout(function() {
		alert_div.style.display = "none";
	}, duration);
	console.log(message);
}

function goToDetailScreen(linkElement) {
	formStorageId = getStorageIdFromList(linkElement);
	AUI().use('liferay-portlet-url', function(A) {
		var e = Liferay.PortletURL.createRenderURL();
		e.options.basePortletURL = baseUrl;
		e.setParameter("jspPage", config.detailPage);
		e.setParameter("formTypeName", modelName);
		e.setParameter("storageId", formStorageId);
		e.setPortletId(namespace.replace(/(^\_+|\_+$)/mg, ''));
		e.setWindowState("normal");
		console.log("e : " + e.toString());
		window.location.href = e.toString();
	});
}

function processDcc(storageId, ws, as, remark, noOfCashSealedEnv, notes) {
	var data = {};
	data.formType = "dccreport";
	data.formStorageId = storageId;
	
	var scpObj = {};
	scpObj.storageId = storageId;
	scpObj.workFlowStatus = ws;
	scpObj.acknowledgementStatus = as;
	scpObj.remark = remark;
	scpObj.noOfCashSealedEnv = noOfCashSealedEnv;
	scpObj.notes = notes;
	
	data.processDto = scpObj;
	console.log(data);
	showLoading(true);
	ajaxCallAPI('POST','processWorkflow',data,function() {
		data = this.get("responseData");
		if (data.error) {
			displayMessage('danger', data.error, 3000);
		} else {
			console.log("DONE...");
			var popupdiv = "#action-feedback-dialog";
			var popupdivbox = "#action-feedback-dialog-box";
			AUI().use('aui-base',function(A) {
				A.one(popupdiv).set('hidden', false);
				YUI().use('aui-modal',function(Y) {
					var modal = new Y.Modal({
									boundingBox : popupdiv,
									contentBox : popupdivbox,
									headerContent : '',
									centered : true,
									destroyOnHide : true,
									destroyOnClose : false,
									modal : true,
									resizable : false,
									draggable : true,
									after : {
										destroy : function(event) {
											console.log("function which will call after close the dialog");
											modal.hide();
											//TODO check mode and redirect on apprpiate page
											if(mode == "list"){
												window.location.reload();												
											}else {
												goBack();	
											}
										},
									},
								}).render()
					Y.one('.popup-ok-action').on('click',function() {
						console.log("popup-ok-action...");
						modal.hide();
						//TODO check mode and redirect on apprpiate page
						if(mode == "list"){
							window.location.reload();												
						}else {
							goBack();
						}
					});
				});
			});
		}
		showLoading(false);
	}, function() {
		displayMessage('danger', "Error in processing record.", 3000);
		showLoading(false);
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


function generatePdf(){

	//	TODO set below variables after discussion with respective person
	var pt = productMap['Exam'];
	var pst = productSubtypeMap['SAC'];
	var ct = categoryMap['CN'];
	var fc = "F";
	var type = clientTypeMap['Individual'];
	
	
	getTemplateUrl(pt, pst, ct, fc, type , function(templateUrl) {
//		showLoading(true);
		if(templateUrl == null) {
			getTemplateUrl(pt, null, ct, fc, type , function(templateUrl) {
				if(templateUrl == null) {
					exportPdfError("Failed to get template url.");
				} else {
					exportPdf(formStorageId, templateUrl);
				}
			});
		} else {
			exportPdf(formStorageId, templateUrl);						
		}
	});
}


function exportPdf(storageId, templateUrl) {
	//TODO call export pdf call
	console.log("storageId");
	console.log(storageId);
	showLoading(true);
	var data = {};
	data.formType = "dccreport";
	data.printout = true;
	data.templateUrl = templateUrl;
	
	if(typeof storageId === "string") {
		data.storageId = encodeURIComponent(storageId);
	} else {
		data.lorData = JSON.stringify(storageId);
	}
	console.log('pdfData === ');
	console.log(data);
	ajaxCallAPI('POST', 'preparePdf', data, function() {
		showLoading(false);
		let responseText = this.get("responseData");
		console.log(responseText);
		window.open(downloadPdfUrl+"&"+namespace+"filePath="+encodeURIComponent(responseText));
	});
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
