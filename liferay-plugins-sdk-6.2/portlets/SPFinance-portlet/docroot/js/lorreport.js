

if(document.readyState == 'complete') {
	init();
} else {
	window.addEventListener('load', init);
}
function init() {
	if(mode=="view") {
		showLoading(true);
		console.log(modelName)
		getByStorageId(formStorageId, modelName, false, function(lorReportData) {
			console.log(lorReportData);
			console.log("lorReportData --- ");
			console.log(lorReportData);
			if(lorReportData.contentJson){
				document.getElementById(namespace+"division").value = "Examinations Bureau";
				document.getElementById(namespace+"date").value = lorReportData.contentJson.ReceiptDate;
				document.getElementById(namespace+"modeofpayment").value = lorReportData.contentJson.ModeOfPayment;
				document.getElementById(namespace+"currency").value = lorReportData.contentJson.CurrencyCode;
				populateRemarks(formStorageId, function() {
					showButtons(lorReportData);
				});
			}
		});
	}
}

function showButtons(lorReportData) {
	var sba = document.getElementById("submita");
	var sbv = document.getElementById("submitv");
	var ab = document.getElementById("approve");
	var rb = document.getElementById("return");
	var ws = lorReportData.contentJson.WorkflowStatus;
	console.log("ws : "+ws);
	if(ws=="PENDING" && sbv) {
		console.log("1..");
		sbv.style.display = "block";
	} 
	if(ws=="SUBMITTED FOR VERIFICATION" && sba) {
		console.log("2..");
		sba.style.display = "block";
	} 
	if((ws=="SUBMITTED FOR VERIFICATION" || ws=="SUBMITTED FOR APPROVAL") && rb) {
		console.log("3..");
		rb.style.display = "block";
	} 
	if(ws=="SUBMITTED FOR APPROVAL" && ab) {
		console.log("4..");
		ab.style.display = "block";
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
					console.log("responseData : "+responseData);
					var olderAdded = false;
					var todayAdded = false;
					var processedBy = "";
					var txtheight = 20;
					for(var i=0;i<responseData.length;i++) {
						var remark = responseData[i];
						var remarkTemplate = getEID(namespace+"remarkTemplate").cloneNode(true);
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
						document.getElementById("processedby").style.height = txtheight + 20;
					}
					getEID("totalRemarks").innerHTML = "(Total: "+responseData.length+" Remarks)";
					document.getElementById("processedby").value = processedBy;
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

function doLorAction(action, linkElement, global) {
	getEID("action_msg").innerHTML = "Please key in your reasons below and confirm your action.";
	getEID("action_msg").placeholder = "Enter Reasons..."
	getEID("popup-submit-action").innerHTML = "SUBMIT";
	getEID("popup-cancel-action").innerHTML = "CANCEL";
	var title;
	var as = "";
	var ws = "";
	console.log("action.."+action);
	if(action=="submitv") {
		title = "Submit for Verification ?";
		as = "PENDING VERIFICATION";
		ws = "SUBMITTED FOR VERIFICATION";
	} else if(action=="submita") {
		title = "Submit for Approval ?";
		as = "PENDING APPROVAL";
		ws = "SUBMITTED FOR APPROVAL";
	} else if(action=="pdf") {
		if(mode!="list") {
			exportLorPdf(formStorageId, false);
		} else {
			exportLorPdf(getStorageIdFromList(linkElement), false);
		}
		return;
	} else if(action=="ppdf") {
		if(mode!="list") {
			exportLorPdf(formStorageId, true);
		} else {
			exportLorPdf(getStorageIdFromList(linkElement), true);
		}
		return;
	} else if(action=="details") {
		goToDetails(getStorageIdFromList(linkElement));
		return;
	} else if(action=="approve") {
		as = "APPROVED";
		ws = "CONFIRMED";
	} else if(action=="return") {
		title = "Return for Amendments ?";
		as = "PENDING AMENDMENTS";
		ws = "PENDING";
	} else if(action=="gapprove") {
		as = "APPROVED";
		ws = "CONFIRMED";
		for(var ri in records) {
			var rec = records[ri];
			if(rec.contentJson.WorkflowStatus.toUpperCase()=="SUBMITTED FOR APPROVAL") {
				processLOR(rec.storageId, ws, as, "");
			}
		}
		return;
	} else if(action=="greturn") {
		title = "Return for Amendments ?";
		as = "PENDING AMENDMENTS";
		ws = "PENDING";
		document.getElementById("action_title").innerHTML = title;
		openDialog("lor-action", function(modal) {
			modal.hide();
			for(var rir in records) {
				var recr = records[rir];
				if(recr.contentJson.WorkflowStatus.toUpperCase() == "SUBMITTED FOR VERIFICATION" || 
						recr.contentJson.WorkflowStatus.toUpperCase() == "SUBMITTED FOR APPROVAL") {
					processLOR(recr.storageId, ws, as, document.getElementById("lor_action_reason").value);
				}
			}
		}, null);
		return;
	} else {
		return;
	}
	document.getElementById("action_title").innerHTML = title;
	
	// process
	if(action=="approve") {
		if(global==true) {
			for(var rir in records) {
				var reca = records[rir];
				if(reca.contentJson.ApprovalStatus.toUpperCase() == "PENDING APPROVAL") {
					processLOR(reca.storageId, ws, as, "");
				}
			}
		} else {
			var stId = "";
			if(mode=="list") {
				stId = getStorageIdFromList(linkElement);
			} else {
				stId = formStorageId;
			}
			processLOR(stId, ws, as, "");
		}
	} else {
		openDialog("lor-action", function(modal) {
			modal.hide();
			if(global==true) {
				for(var rir in records) {
					var recr = records[rir];
					if(action=="submitv") {
						if(recr.contentJson.ApprovalStatus.toUpperCase() == "PENDING SUBMISSION" || 
								recr.contentJson.ApprovalStatus.toUpperCase() == "PENDING AMENDMENTS") {
							processLOR(recr.storageId, ws, as, document.getElementById("lor_action_reason").value);
						}
					} else if(action=="submita") {
						if(recr.contentJson.ApprovalStatus.toUpperCase() == "PENDING VERIFICATION") {
							processLOR(recr.storageId, ws, as, document.getElementById("lor_action_reason").value);
						}
					} else if(action=="return") {
						if(recr.contentJson.ApprovalStatus.toUpperCase() == "PENDING APPROVAL" || 
								recr.contentJson.ApprovalStatus.toUpperCase() == "PENDING VERIFICATION") {
							processLOR(recr.storageId, ws, as, document.getElementById("lor_action_reason").value);
						}
					}
				}
			} else {
				var sId = "";
				if(mode=="list") {
					sId = getStorageIdFromList(linkElement);
				} else {
					sId = formStorageId;
				}
				processLOR(sId, ws, as, document.getElementById("lor_action_reason").value);
			}
		}, null);
	}
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

function processLOR(storageId, ws, as, remark) {
	var data = {};
	data.formType = "lorreport";
	data.formStorageId = storageId;
	data.storageId = storageId;
	data.workFlowStatus = ws;
	data.approvalStatus = as;
	data.remark = remark;
	console.log("data");
	console.log(data);
	showLoading(true);
	ajaxCallAPI('POST', 'processWorkflow', data, function() {
		let data = this.get("responseData");
		console.log("data : "+JSON.stringify(data));
		if (data.error) {
			displayMessage('danger', data.error, 3000);
		} else {
			showLoading(false);
			console.log("DONE...");
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
		showLoading(false);
	});
}
function exportLorPdf(storageId, printout) {
	console.log("storageId");
	console.log(storageId);
	showLoading(true);
	var data = {};
	data.formType = "lorreport";
	data.printout = printout;
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