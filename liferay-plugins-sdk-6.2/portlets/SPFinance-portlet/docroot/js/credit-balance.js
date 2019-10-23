var modelName = "CreditBalance";
if (document.readyState == 'complete') {
	init();
} else {
	window.addEventListener('load', init);
}
function init() {
	if (mode == "list") {
		document.getElementById("MultirowPopAction").innerHTML = document
				.getElementById("MultirowPopActionNew").innerHTML;
	}else if(mode == "refund"){
		initProcessRefund();	
	} else {
		if (mode && mode != "create") {
			fetchDetails(formStorageId, false, false);
		}
	}
}

function fetchDetails(formStorageId, isGeneratePdf, isSendEmail) {
	showLoading(true);
	if (formStorageId != "") {
		var data = {};
		data.formStorageId = formStorageId;
		data.formType = modelName;
		data.indetail = true;
		ajaxCallAPI(
				'GET',
				"loadData",
				data,
				function() {
					data = this.get("responseData");
					console.log(data)
					if (data.error) {
						displayMessage('danger', data.error, 3000);
					} else {
						
						if(mode == "view"){
							setViewDetail(data);
						}
						if(mode === "view-revenue"){
							getEID(namespace + "CreditBalanceCode").value = data.contentJson.CreditBalanceCode;
							getEID(namespace + "IdAndName").value = data.contentJson.IdAndName;
							getEID(namespace + "UserType").value = data.contentJson.UserType;
							getEID(namespace + "UserId").value = data.contentJson.UserId;
							getEID(namespace + "UserName").value = data.contentJson.UserName;
							getEID("userId").innerHTML = getIdFromIdName(data.contentJson.IdAndName);
							getEID("creditBalanceAmt").innerHTML = data.contentJson.CreditBalanceAmt;
							getEID("userName").innerHTML = data.contentJson.UserName;
							
							if(data.contentJson.Amount){
								getEID(namespace + "amountProcessed").value = data.contentJson.Amount;
							}else{
								getEID(namespace + "amountProcessed").value = data.contentJson.CreditBalanceAmt;
							}
							
							if(data.contentJson.InitiatedBy){
								getEID(namespace + "initiatedBy").value = data.contentJson.InitiatedBy;
							}
							
							if(data.contentJson.Notes){
								getEID(namespace + "notes").value = data.contentJson.Notes;
							}else{
								getEID(namespace + "notes").value = "";
							}
						}
					}
					showLoading(false);
					if(isGeneratePdf){
						exportPdf(data.contentJson.CreditBalanceCode, data.contentJson, data.createdDate);
					}
					else if(isSendEmail){
						exportPdf(data.contentJson.CreditBalanceCode, data.contentJson, data.createdDate, isSendEmail);
					}
				}, function() {
					displayMessage('danger',
							"Error in persisting dynamic form data.", 3000);
					showLoading(false);
				});
	}
}

function setViewDetail(data){
	getEID(namespace + "CreditBalanceCode").value = data.contentJson.CreditBalanceCode;
	getEID(namespace + "IdAndName").value = data.contentJson.IdAndName;
	//getEID(namespace + "creditBalanceAmt").value = data.contentJson.CreditBalanceAmt;
	getEID(namespace + "userId").value = getIdFromIdName(data.contentJson.IdAndName);
	getEID(namespace + "userName").value = data.contentJson.UserName;
	getEID(namespace + "date").value = data.contentJson.Date;
	getEID(namespace + "userType").value = data.contentJson.UserType;
	if(data.contentJson.Type){
		getEID(namespace + "utilisationpurpose").value = data.contentJson.Type;
	}else{
		getEID(namespace + "utilisationpurpose").value = "";
	}
	getEID(namespace + "miscfee").value = data.contentJson.MiscFee;
	//getEID(namespace + "initiatedby").value = data.contentJson.InitiatedBy;
	if(data.contentJson.Amount){
		getEID(namespace + "amountProcessed").value = data.contentJson.Amount;
	}else{
		getEID(namespace + "amountProcessed").value = "";
	}
	
	if(data.contentJson.PaymentMode){
		getEID(namespace + "paymentMode").value = data.contentJson.PaymentMode;
	}else{
		getEID(namespace + "paymentMode").value = "";
	}
	
	if(data.contentJson.Notes){
		getEID(namespace + "notes").value = data.contentJson.Notes;
	}else{
		getEID(namespace + "notes").value = "";
	}

	populateRemarks(formStorageId, function() {
		var as = "";
		if(data.contentJson.ApprovalStatus){
			as = data.contentJson.ApprovalStatus.toUpperCase();
		}
		showButtons(as, data.contentJson.Type);
	});
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
	if (argDate.setHours(0, 0, 0, 0) == todaysDate.setHours(0, 0, 0, 0)) {
		return true;
	}
	return false;
}

function formatNumber(number) {
	return parseInt(number) < 10 ? "0" + number : number;
}

function showGlobalButtons() {
	
}

function showButtons(as, up) {
	console.log("up : ", up);
	if(typeof as === "undefined" || as == "" ){
		showHideElementById("recogniseRevenueBtn", "block");
		showHideElementById("makeRefundBtn", "block");
		showHideElementById("listingBtn", "block");
		
		showHideElementById("utilisationDivId", "none");
		showHideElementById("miscfeeDivId", "none");
		showHideElementById("amountProcessedDivId", "none");
		showHideElementById("paymentModeDivId", "none");
		showHideElementById("notesDivId", "none");
		showHideElementById("approvalStatusDivId", "none");
		showHideElementById("initiatedByDivId", "none");
	}else{
		showHideElementById("cancelBtn", "block");
		if(up == "Refund") {
			showHideElementById("initiatedByDivId", "none");
		}else {
			showHideElementById("miscfeeDivId", "none");
			showHideElementById("paymentModeDivId", "none");
		}
	}
	
	if(as == "PENDING AMENDMENTS"){
		showHideElementById("makeAmendmentBtn", "block");
		showHideElementById("workflowStatus_amendments", "block");
	}
	
	if(as == "PENDING VERIFICATION"){
		showHideElementById("submit-for-approval-btn", "block");
		showHideElementById("rejectBtn", "block");
		showHideElementById("returnForAmendmentBtn", "block");
		showHideElementById("workflowStatus_verification", "block");
	}
	
	if(as == "PENDING APPROVAL".toUpperCase()){
		showHideElementById("approveBtn", "block");
		showHideElementById("rejectBtn", "block");
		showHideElementById("approver-returnForAmendmentBtn", "block");
		
		showHideElementById("workflowStatus_approval", "block");
	} 
	
	if (as == "APPROVED") {
		document.getElementById("workflowStatus_approved").style.display = "block";
	}
}

function disableRadioButton() {
	var radio = document.getElementsByName("addDeductType");
	var len = radio.length;
	for (var i = 0; i < len; i++) {
		radio[i].disabled = false;
	}
}

function setSelectedRadio(radioName, value) {
	var rbs = document.getElementsByName(radioName);
	for (var i = 0; i < rbs.length; i++) {
		if (rbs[i].value == value) {
			rbs[i].checked = true;
		} else {
			rbs[i].checked = false;
		}
	}
}


function getSelectedRadio(radioName) {
	var rbs = document.getElementsByName(radioName);
	for (var i = 0; i < rbs.length; i++) {
		if (rbs[i].checked) {
			return rbs[i];
		}
	}
}


function saveCreditBalance(as, ws, userId, userName, userType, creditAmt, up, amtProcess, initiatedBy, notes, miscFeesDetails, refundMiscDetails, miscFee, remark, paymentMode){
	var cbObj = {};
	cbObj.CreditBalanceCode = generateCode("CBC-");
	cbObj.UserId = userId;
	cbObj.UserName = userName;
	cbObj.UserType = userType;
	cbObj.CreditBalanceAmt = creditAmt;
	cbObj.Type = up;
	cbObj.Amount = amtProcess;
	cbObj.WorkflowStatus = ws;
	cbObj.ApprovalStatus = as;
	cbObj.Notes = notes;
	cbObj.MiscFee = miscFee;
	cbObj.Status = "Active";
	cbObj.MiscFeesDetails = miscFeesDetails;
	cbObj.RefundMiscDetails = refundMiscDetails;
	cbObj.PaymentMode = paymentMode;
	if(initiatedBy != ""){
		cbObj.InitiatedBy = initiatedBy;
	}
	cbObj.formType = modelName;
	
	if(typeof fromAmendments != "undefined" && fromAmendments=="1"){
		cbObj.formStorageId = formStorageId;
		mode = "edit";
	}
	console.log("cbObj : ");
	console.log(cbObj);
	
	ajaxCallAPI('POST', 'persist', cbObj, function() {
		var data = this.get("responseData");
		if (data.error) {
			displayMessage('danger', data.error, 3000);
		} else if (Object.keys(data).length === 0) {
			console.log("data : "+data);
			displayMessage('danger', 'Form submission failed.', 3000);
		} else {
			console.log(data.toString());
//			var message = "Form successfully submitted.";
//			displayMessage('success', message, 3000);
//			afterFormSubmissionFormIOForm(data);
//			if(page == "list"){
//				location.reload();
//			}else {
//				goBack();				
//			}
				processRefund(cbObj.CreditBalanceCode, ws, as, remark, null, null, null, null);
			}
		showLoading(false);
	}, function() {
		displayMessage('danger', "Error in persisting dynamic form data.", 3000);
		showLoading(false);
	});
	
	
	
}

function goToMakeRefundScreen(formStorageId, fromAmendments){
	
	AUI().use('liferay-portlet-url', function(A) {
		var e = Liferay.PortletURL.createRenderURL();
		e.options.basePortletURL = baseUrl;
		e.setParameter("jspPage", config.refundPage);
		e.setParameter("formTypeName", modelName);
		e.setParameter("storageId", formStorageId);
		e.setParameter("fromAmendments", fromAmendments);
		e.setPortletId(namespace.replace(/(^\_+|\_+$)/mg, ''));
		e.setWindowState("normal");
		console.log("e : " + e.toString());
		window.location.href = e.toString();
	});
}

function doCreditAction(action, linkElement) {
	getEID("popup-submit-action").innerHTML = "SUBMIT";
	getEID("popup-cancel-action").innerHTML = "CANCEL";
	var as = "";
	var ws = "";
	var title = "";
	var subTitle = "";
	if (action == "detail") {
		goToDetailScreen(linkElement);
	} else {
		if (action == "g-recogniseAsRevenue") {
			doGlobalRecogniseAsRevenue();
			return;
		}
		if (action == "recogniseAsRevenue") {
			if(linkElement){
				formStorageId = getStorageIdFromList(linkElement);
			}
			doSingleRecogniseAsRevenue(formStorageId);
			return;
		}
		
		if (action == "reject") {
			as = "Rejected";
			ws = "Rejected";
			title = "Add Remarks";
			subTitle = "Please key in your remarks justifying your current action";
		}
		
		if (action == 'refundAdvice') {	
			refundAdvicePdfGeneration(linkElement);
//			formStorageId = getStorageIdFromList(linkElement);
//			sendEmail(formStorageId);
			return;
		}
		
		if (action == 'creditnotes') {
			redirectToCreditNotes(linkElement);
			return;
		}
		
		if (action == 'makerefund') {	
			if(linkElement){
				formStorageId = getStorageIdFromList(linkElement);
			}
			goToMakeRefundScreen(formStorageId, false);
			return;
		}
		if(action == 'makeAmendments') {
			if(linkElement){
				formStorageId = getStorageIdFromList(linkElement);
			}
			goToMakeRefundScreen(formStorageId, true);
			return;
		}
		if (action == "approval") {
			title = "Submit for Approval?";
			subTitle = "Please state any remarks (if any) and confirm your action.";
			as = "Pending Approval";
			ws = "Submitted For Approval";
		}
		
		
		if (action == 'approve') {	
			as = "Approved";
			ws = "Confirmed";
		}
		
		if (action == "verification") {
			title = "Submit for Verification?";
			subTitle = "Please state any remarks (if any) and confirm your action.";
			as = "Pending Verification";
			ws = "Submitted For Verification";
		}
		
		if (action == "returnToVerifier" || action == "returnToSubmitter" || action == "amendments") {
			title = "Return To Amendments?";
			subTitle = "Please state any remarks (if any) and confirm your action.";
			as = "Pending Amendments";
			ws = "Pending Amendments";
		}
		
		var isGlobal = false;
		if(action == "g-submitForApproval"){
			as = "Pending Approval";
			ws = "Submitted For Approval";
			title = "Submit for Approval?";
			subTitle = "Please state any remarks (if any) and confirm your action.";
			isGlobal = true;
		}
		if(action == "g-reject"){
			as = "Rejected";
			ws = "Rejected";
			title = "Add Remarks";
			subTitle = "Please key in your remarks justifying your current action";
			isGlobal = true;
		}
		if(action == "g-approve"){
			as = "Approved";
			ws = "Confirmed";
			isGlobal = true;
		}
		if(action == "g-returnToSubmitter" || action == "g-returnToVerifier" || action == "g-returnAmendments"){
			as = "Pending Amendments";
			ws = "Pending Amendments";
			title = "Return To Amendments?";
			subTitle = "Please state any remarks (if any) and confirm your action.";
			isGlobal = true;
		}
		
		document.getElementById("credit_action_reason").value = "";
		document.getElementById("action_title").innerHTML = title;
		if(subTitle){
			document.getElementById("action_msg").innerHTML = subTitle;
		}
		openDialogNew("credit-action", function(modal) {
			modal.hide();
			if(isGlobal) {
				for ( var ri in records) {
					var rec = records[ri];
						processRefund(rec.storageId, ws, as, document
								.getElementById("credit_action_reason").value, null, null, null, null);
				}
			}else {
				var sId = "";
				if (mode == "list") {
					sId = getStorageIdFromList(linkElement);
				} else {
					sId = formStorageId;
				}
				processRefund(sId, ws, as, document
						.getElementById("credit_action_reason").value, null, null, null, null);
			}
		}, null);
	}
}

function refundAdvicePdfGeneration(linkElement){
	let formStorageId = getStorageIdFromList(linkElement);
	var data = fetchDetails(formStorageId, true, false);
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

function getStorageIdFromList(linkElement) {
	var c = findAncestor(linkElement, "Row");
	var a = [];
	for (var b = 0; b < c.childElementCount; b++) {
		a.push(c.children[b].textContent.trim())
	}
	return a[0];
}

function moveToList() {
	window.location.href = baseUrl;
}
function processRefund(storageId, ws, as, remark, utilisationPurpose, initiatedBy, notes, amtToProcess) {
	var data = {};
	data.formType = "creditbalance";
	data.formStorageId = storageId;
	
	var scpObj = {};
	scpObj.storageId = storageId;
	scpObj.workFlowStatus = ws;
	scpObj.approvalStatus = as;
	scpObj.remark = remark;
	scpObj.initiatedBy = initiatedBy;
	scpObj.notes = notes;
	if(amtToProcess){
		scpObj.amtToProcess = parseFloat(amtToProcess);		
	}
	if(utilisationPurpose){
		scpObj.utilisationPurpose = utilisationPurpose;
	}
	
	scpObj.productType = productMap['Exam'];
	scpObj.productSubType = productSubtypeMap['SAC'];
	scpObj.functionalComponent = "F";
	scpObj.txnType = categoryMap['PA'];
	scpObj.type = clientTypeMap['Individual'];
	scpObj.categoryType = categoryMap['PA'];
	scpObj.miscTxnType =transactionTypeMap['Refund'];
	scpObj.categoryMap = JSON.stringify(categoryMap);
	scpObj.clientTypeMap = JSON.stringify(clientTypeMap);
	scpObj.formType = "creditbalance";
	data.processDto = scpObj;
	console.log(data);
	showLoading(true);
	ajaxCallAPI('POST','processWorkflow',data,function() {
		data = this.get("responseData");
		showLoading(false);
		if (data.error) {
			displayMessage('danger', data.error, 3000);
		} else {
			if(as == "Approved") {
				sendEmail(storageId);
			}
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
	}, function() {
		displayMessage('danger', "Error in processing record.", 3000);
		showLoading(false);
	});
}

function doGlobalRecogniseAsRevenue(){
	resetGlobalRecogniseAsRevenueForm();
	var popupdiv = "#mass-process-action-dialog";
	var popupdivbox = "#mass-process-action-dialog-box";
	AUI().use('aui-base', function(A) {
	   A.one(popupdiv).set('hidden', false);
	     YUI().use('aui-modal', function(Y) {
	        var modal = new Y.Modal({
                 boundingBox: popupdiv,
                 contentBox: popupdivbox,
                 headerContent: '<h2 class="PROCESS-PAYMENT" align="center">RECOGNISE AS REVENUE</h2>',
                 centered: true,
                 destroyOnHide: false,
                 modal: true,
                 resizable: false,
                 draggable: true,
	         }).render();
	         Y.one('.mass-process-popup-cancel-action').on('click',function() {
	        	 console.log("popup-cancel-action...");
	         	 modal.hide();
	         	 modal = null;
	         });
	         Y.one('.mass-process-popup-submit-action').on('click',function() {
     	    	console.log("popup-submit-action...");
     	    	if(modal){
     	    		modal.hide();
     	    		modal = null;         	    		
     	    	}
	         	submitForVerification("global");
     	     });
	     });
	 });	
}

function resetGlobalRecogniseAsRevenueForm(){
	document.getElementById("globalRecoAsRevform").reset();
}

function doSingleRecogniseAsRevenue(formStorageId) {
	AUI().use('liferay-portlet-url', function(A) {
		var e = Liferay.PortletURL.createRenderURL();
		e.options.basePortletURL = baseUrl;
		e.setParameter("jspPage", config.viewRevenuePage);
		e.setParameter("formTypeName", modelName);
		e.setParameter("storageId", formStorageId);
		e.setPortletId(namespace.replace(/(^\_+|\_+$)/mg, ''));
		e.setWindowState("normal");
		console.log("e : " + e.toString());
		window.location.href = e.toString();
	});
}

function validateAmountProcessed(id, creditBalanceId) {
	console.log(id);
	let isValidate = false;
	let value = Number(getEID(namespace + id).value);
	console.log(value);
	let creditBalanceAmt = Number(getEID(creditBalanceId).innerHTML);
	console.log(creditBalanceAmt);
	if(!value || value == "") { 
		displayMessage('danger', "Please enter the correct amount to be processed.", 3000);
	}else if(value<=0){
		displayMessage('danger', "Please enter the correct amount to be processed.", 3000);
	}else if(value>creditBalanceAmt) {
		displayMessage('danger', "Amount must not more than the amount available in the credit balance.", 3000);
	}else {
		isValidate = true;	
	}
	return isValidate;
}

function submitForVerification(type) {
	openDialogNew("credit-action", function(modal) {
		modal.hide();
		var remark = document.getElementById("credit_action_reason").value;
		var as = "Pending Verification";
		var ws = "Submit For Verification";
		if(type === "global"){
			var initiatedBy = getSelectedRadio("initiatedBy").value;
			var notes = getEID(namespace + "notes").value;
			for ( var ri in records) {
				var rec = records[ri];
				if (!rec.contentJson.ApprovalStatus || rec.contentJson.ApprovalStatus == "") {
					saveCreditBalance(as, ws, rec.contentJson.UserId, rec.contentJson.UserName, rec.contentJson.UserType, 
								rec.contentJson.CreditBalanceAmt, "Revenue", rec.contentJson.CreditBalanceAmt, initiatedBy, notes, null, null, null, remark, "");
				}
			}	
		}else {
			let isValidate = validateAmountProcessed("amountProcessed","creditBalanceAmt");
			if(isValidate){
				var initiatedBy = getEID(namespace + "initiatedBy").value;
				var notes = getEID(namespace + "notes").value;
				var amountProcessed = getEID(namespace + "amountProcessed").value;
				var userId = getEID(namespace + "UserId").value;
				var userName = getEID(namespace + "UserName").value;
				var userType = getEID(namespace + "UserType").value;
				saveCreditBalance(as, ws, userId, userName, userType, amountProcessed, "Revenue", amountProcessed, initiatedBy, notes, null, null, null, remark, "");
			}		
		}
		}, null);
	
	
	
	
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


function exportPdf(formStorageId, contentJson, createdDate, isSendEmail) {
	showLoading(true);
	
//	get template url
//	TODO set below variables after discussion with respective person
	var pt = productMap['Exam'];
	var pst = productSubtypeMap['SAC'];
	var ct = categoryMap["RF"];
	var fc = "F";
	var type = clientTypeMap['Individual'];
	getTemplateUrl(pt, pst, ct, fc, type , function(templateUrl) {
		if(templateUrl == null) {
			getTemplateUrl(pt, null, ct, fc, type , function(templateUrl) {
				if(templateUrl == null) {
					showLoading(false);
					exportPdfError("Failed to get template url.");
				} else {
					var pdfData = preparePdfDataForCreditBalance(contentJson, createdDate, templateUrl);
					openPdf(pdfData, isSendEmail, contentJson.Type, contentJson.CreditBalanceCode);
				}
			});
		} else {
			var pdfData = preparePdfDataForCreditBalance(contentJson, createdDate, templateUrl);
			openPdf(pdfData, isSendEmail, contentJson.Type, contentJson.CreditBalanceCode);						
		}
	});
}

Date.prototype.mmddyyyy = function() {
	  var mm = this.getMonth() + 1; // getMonth() is zero-based
	  var dd = this.getDate();

	  return [(dd>9 ? '' : '0') + dd,
	          (mm>9 ? '' : '0') + mm,
	          this.getFullYear()
	         ].join('/');
	};

function preparePdfDataForCreditBalance(contentJson, createdDate, templateUrl) {
	var docType = "";
	console.log(contentJson);
	var approvalStatus = (contentJson.ApprovalStatus && contentJson.ApprovalStatus.toUpperCase() == "Approved".toUpperCase()) ? contentJson.ApprovalStatus : "DRAFT";
	console.log("approvalStatus : " + approvalStatus);
	var candidateId = typeof contentJson.UserId === "undefined" ? "" : contentJson.UserId;
	var candidateName = typeof contentJson.UserName === "undefined" ? "" : contentJson.UserName;
	
	var custDetails = ["Candidate Name: "+candidateName, "Candidate ID: "+candidateId];
	var docInfoValues=[];
	var docInfoColumns = [];
	var itemDetailsColumns = [];
	var itemDetailsColumnWidth = [];
	var itemDetailsValues = [];
	var itemDetailsValueAlignments = [];
	var totalAmount = 0;
	
	var date = new Date(createdDate);
	createdDate = date.mmddyyyy();
	
	docType = "REFUND ADVICE";
	if(approvalStatus=="DRAFT") {
		docInfoValues = [approvalStatus, "","1 OF 1"];
	} else {
		docInfoValues = [contentJson.ExternalRefNumber, createdDate,"1 OF 1"];
	}
	
	docInfoColumns = ["REFUND ADVICE NO", "REFUND ADVICE DATE", "PAGE"];
	itemDetailsColumns = ["Description", "Amt"];
	itemDetailsColumnWidth = [95,10];
	itemDetailsValueAlignments = ["l","r"];
	//data from credit balance - amount to be refunded
	console.log("contentJson.AmtToProcess" + contentJson.Amount);
	var description = contentJson.Type == "Refund"? "Credit Balance to be Refunded" : "Recognised Credit Balance as Revenue";
	let creditBalanceAmt = contentJson.CreditBalanceAmt!=="undefined" ? formatNumbers(contentJson.CreditBalanceAmt) : 0;
	console.log("creditBalanceAmt : " + creditBalanceAmt);
	var item = [description, "$"+ creditBalanceAmt];
	totalAmount = parseFloat(contentJson.CreditBalanceAmt!=="undefined" ? Number(contentJson.CreditBalanceAmt) : 0);
	itemDetailsValues.push(item);
	if(contentJson.MiscFeesDetails && contentJson.MiscFeesDetails.length >0){
		for(var i=0;i<contentJson.MiscFeesDetails.length;i++) {
			var detail = contentJson.MiscFeesDetails[i];
			var item = [typeof detail.description === "undefined" ? "Less : " : "Less : "+detail.description,
					"$"+formatNumbers(detail.amount)
						];
			totalAmount = totalAmount - parseFloat(detail.amount);
			itemDetailsValues.push(item);
		}
	}
	totalAmount = formatNumbers(totalAmount);
	itemDetailsValues.push(["Total Payable", "$"+totalAmount]);
	
	var data = {};
	data.docType = docType;
	data.custDetails = custDetails;
	data.docInfoColumns = docInfoColumns;
	data.docInfoValues = docInfoValues;
	data.invoiceDetails = {};
	data.invoiceDetails.itemDetailsValues = itemDetailsValues;
	data.invoiceDetails.itemDetailsColumns = itemDetailsColumns;
	data.invoiceDetails.itemDetailsColumnWidth = itemDetailsColumnWidth;
	data.invoiceDetails.itemDetailsValueAlignments = itemDetailsValueAlignments;

	var pdfData = {};
	pdfData.data = data;
	pdfData.templateUrl = templateUrl;
	pdfData.fileName = contentJson.CreditBalanceCode;
	pdfData.moduleName = "creditBalance";
	if(approvalStatus=="DRAFT") {
		pdfData.preview = true;
	} else {
		pdfData.preview = false;
	}
	console.log(pdfData);
	return JSON.stringify(pdfData);
}

function openPdf(pdfData, isSendEmail, utilisationPurpose, creditBalanceCode) {
	if(utilisationPurpose == "Refund"){
		var data = JSON.parse(pdfData);
		data.formType = modelName;
		console.log('pdfData === ');
		ajaxCallAPI('POST', 'preparePdf', data, function() {
			showLoading(false);
			var responseText = this.get("responseData");
			console.log(responseText);
			console.log("isSendEmail : " + isSendEmail);
			if(isSendEmail){
				console.log("reached to send email : " + responseText)
				triggerEmail(creditBalanceCode,responseText);
			}else{
				window.open(downloadPdfUrl+"&"+namespace+"filePath="+encodeURIComponent(responseText));			
			}
		});	
	} else if(isSendEmail){
		triggerEmail(creditBalanceCode,null);
		showLoading(true);
	}
}

function redirectToCreditNotes(linkElement){
//	window.location.href = creditNotesUrl+ "?fromUrl=creditBalance";
//	alert(namespace);
	var userId = "";
	userId = getUserIdFromList(linkElement);
	
	AUI().use('liferay-portlet-url', function(A) {
		var e = Liferay.PortletURL.createRenderURL();
		e.options.basePortletURL = creditNotesUrl;
		e.setParameter("fromUrl", "creditBalance");
		e.setParameter("userId", userId);
		e.setPortletId("_transaction_WAR_SPFinanceportlet_".replace(/(^\_+|\_+$)/mg, ''));
		e.setWindowState("normal");
		console.log("e : " + e.toString());
		window.open(e.toString());
	});
}

function getUserIdFromList(linkElement) {
	var c = findAncestor(linkElement, "Row");
	var a = [];
	for (var b = 0; b < c.childElementCount; b++) {
		a.push(c.children[b].textContent.trim())
	}
	return a[1].replace(/^\D+|\D.*$/g, "");
}

function showSuccessModal(){
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
					destroy : function(
							event) {
						console
								.log("function which will call after close the dialog");
						modal
								.hide();
						window.location
								.reload();
					},
				},
			}).render()
			Y.one('.popup-ok-action').on('click',function() {
				console.log("popup-ok-action...");
				modal.hide();
				window.location.reload();
			});
		});
	});
}

function sendEmail(storageId){
	fetchDetails(storageId, false, true);
}

function exportPdfError(error) {
	displayMessage('danger', error, 6000);
}

function triggerEmail(storageId, pdfLocation){
	var data = {};
	data.formStorageId = storageId;
	data.formType = "creditBalance";
	data.pdfLocation = pdfLocation;
	
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

function getIdFromIdName(idname) {
	var id = idname.split(" ")[0];
	return id.substring(1, id.length-1);
}