var modelName = "submittedClaim";
var detailScreenUrl = "";
getDetailUrl();
function getDetailUrl() {
	if (typeof config !== 'undefined') {
		AUI().use('liferay-portlet-url', function(A) {
			var e = Liferay.PortletURL.createRenderURL();
			e.options.basePortletURL = baseUrl;
			e.setParameter("jspPage", config.detailPage);
			e.setParameter("formTypeName", modelName);
			e.setParameter("storageId", "[$storageId$]");
			e.setPortletId(namespace.replace(/(^\_+|\_+$)/mg, ''));
			e.setWindowState("normal");
			console.log("e : " + e.toString());
			detailScreenUrl = e.toString();
		});
	}
}

if (document.readyState == 'complete') {
	init();
} else {
	window.addEventListener('load', init);
}
function init() {
	if (mode == "list") {
		document.getElementById("MultirowPopAction").innerHTML = document
				.getElementById("MultirowPopActionNew").innerHTML;
	} else {
		if (mode && mode != "create") {
			fetchDetails(formStorageId);
		}
	}
}

function fetchDetails(formStorageId) {
	showLoading(true);
	if (formStorageId != "") {
		var data = {};
		data.formStorageId = formStorageId;
		data.formType = modelName;
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
						getEID(namespace + "SubmittedClaimCode").value = data.submittedClaimCode;
						getEID(namespace + "idAndName").value = data.contentJson.IdAndName;
						getEID(namespace + "appointmentType").value = data.appointmentType;
						getEID(namespace + "examDate").value = data.contentJson.ExamDate;
						getEID(namespace + "venue").value = (typeof data.venue === "undefined") ? "":data.venue;
						getEID(namespace + "typeOfPayment").value = claimTypeMap[parseInt(data.contentJson.ClaimType)];
						getEID(namespace + "paymentUnitType").value = globalBaseCurrency;
						getEID(namespace + "paymentAmount").value = Number(data.contentJson.ClaimVal).toFixed(2);
						var finalAmount = data.contentJson.ClaimVal;
						var adType = data.contentJson.AddDedType;
						var addDedAmt = data.contentJson.AddDedAmt;
						addDedAmt = addDedAmt ? addDedAmt : 0;
						if (adType) {
							setSelectedRadio("addDeductType", "Add");
							finalAmount = finalAmount + addDedAmt;
						} else {
							setSelectedRadio("addDeductType", "Deduct");
							finalAmount = finalAmount - addDedAmt;
						}
						getEID(namespace + "finalAmount").value = Number(finalAmount).toFixed(2);
						getEID(namespace + "addDeductAmount").value = Number(data.contentJson.AddDedAmt).toFixed(2);
						getEID(namespace + "notes").value = data.contentJson.RelcRemark;
						getEID(namespace + "submittedDate").value = formatDate(new Date(data.createdDate));
						getEID(namespace + "addDeductAmount").readonly = true;
						var ws = data.contentJson.WorkFlowStatus.toUpperCase();
						var as = data.contentJson.ApprovalStatus.toUpperCase();
						document.getElementById("workflowStatus").innerHTML = as;
						var statusCell = document.getElementById("workflowStatus");

						if (statusCell.innerHTML == "Approved".toUpperCase()) {
							statusCell.classList.add("approved");
						} else if (statusCell.innerHTML == "Rejected".toUpperCase()) {
							statusCell.classList.add("rejected");
						} else if (statusCell.innerHTML == "Pending Submission".toUpperCase()) {
							statusCell.classList.add("pending-submission");
						} else if (statusCell.innerHTML == "Pending Verification".toUpperCase()) {
							statusCell.classList.add("pending-verification");
						} else if (statusCell.innerHTML == "Pending Amendments".toUpperCase()) {
							statusCell.classList.add("pending-amendments");
						} else if (statusCell.innerHTML == "Pending Approval".toUpperCase()) {
							statusCell.classList.add("pending-approval");
						}
						
						populateRemarks(formStorageId, function() {
							if (data.contentJson.PaymentType == "Claim" && as != "APPROVED" && as != "REJECTED") {
								showHideElementById("reject-btn", "block");
							}
							showButtons(ws, data.contentJson.PaymentType);
							if((submitter && (as=="PENDING SUBMISSION" || as == "PENDING AMENDMENTS")) 
									|| (verifier && (as=="PENDING VERIFICATION" || as == "PENDING AMENDMENTS"))) {
								getEID(namespace + "addDeductAmount").readOnly = false;
								enableRadioButton();
								getEID(namespace + "notes").readOnly = false;
							}
						});

					}
					showLoading(false);
				}, function() {
					displayMessage('danger',
							"Error in persisting dynamic form data.", 3000);
					showLoading(false);
				});
	}
}

function populateRemarks(formStorageId, callback) {
	console.log("Inisde remark")
	var data = {};
	data.formType = "InvoiceRemarks";
	data.conditions = [ "contentJson.ReferenceId=" + formStorageId,
			"size=" + 2147483647, "sort=created_date,desc" ];
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
					console.log("responseData : " + responseData);
					var olderAdded = false;
					var todayAdded = false;
					var processedBy = "";
					// var txtheight = 20;
					if (responseData.length <= 0) {
						getEID("remarkNoRecordTemplate").style.display = "block";
						getEID("invoiceRemarksContainer").style.display = "none";
					} else {
						getEID("remarkNoRecordTemplate").style.display = "none";
						getEID("invoiceRemarksContainer").style.display = "block";
						for (var i = 0; i < responseData.length; i++) {
							var remark = responseData[i];
							var remarkTemplate = getEID(
									namespace + "remarkTemplate").cloneNode(
									true);
							var remarksAction = remarkTemplate
									.getElementsByClassName("remarksAction")[0];
							var remarksTime = remarkTemplate
									.getElementsByClassName("remarksTime")[0];
							var remarksText = remarkTemplate
									.getElementsByClassName("remarksText")[0];
							var dayRow = remarkTemplate
									.getElementsByClassName("dayRow")[0];
							var dayText = remarkTemplate
									.getElementsByClassName("dayText")[0];

							if (remark.contentJson.RequestType.toLowerCase() == "pending") {
								remarksAction.innerHTML = "<b>"
										+ remark.createdBy
										+ "</b> returned for amendments";
							} else {
								remarksAction.innerHTML = "<b>"
										+ remark.createdBy
										+ "</b> "
										+ remark.contentJson.ApprovalStatus
												.toLowerCase();
							}

							var dt = new Date(Date.parse(remark.createdDate));
							if (isToday(dt)) {
								if (todayAdded) {
									dayRow.style.display = "none";
								} else {
									dayRow.style.display = "block";
									dayText.innerHTML = "<b>Today</b>";
									todayAdded = true;
								}
								remarksTime.innerHTML = formatNumber(dt
										.getHours())
										+ ":" + formatNumber(dt.getMinutes());
							} else {
								if (olderAdded) {
									dayRow.style.display = "none";
								} else {
									olderAdded = true;
									dayRow.style.display = "block";
									dayText.innerHTML = "<b>Older</b>";
								}
								remarksTime.innerHTML = formatNumber(dt
										.getDate())
										+ "/"
										+ formatNumber(dt.getMonth() + 1)
										+ "/"
										+ formatNumber(dt.getFullYear())
										+ " "
										+ formatNumber(dt.getHours())
										+ ":" + formatNumber(dt.getMinutes());
							}
							remarksText.innerHTML = remark.contentJson.Remark;
							remarkTemplate.style.display = "block";
							getEID("invoiceRemarksContainer").appendChild(
									remarkTemplate);
							if (processedBy.indexOf(remark.createdBy) == -1) {
								processedBy = processedBy + remark.createdBy
										+ "\n";
							}
							// document.getElementById("processedby").style.height
							// = txtheight + 20;
						}
					}

					getEID("totalRemarks").innerHTML = "(Total: "
							+ responseData.length + " Remarks)";
					// document.getElementById("processedby").value =
					// processedBy;
					showLoading(false);
					callback();
				}
			}, function() {
				displayMessage('danger', "Error in populating remarks.", 3000);
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

function showButtons(ws, paymentType) {
	if (ws == "SUBMITTED FOR APPROVAL") {
		showHideElementById("approve", "block");
		if(paymentType == "Claim"){
			showHideElementById("return-submitter-amendment", "block");
			showHideElementById("return-verifier-amendment", "block");
		}
	} else {
		showHideElementById("approve", "none");
	}

	if (ws == "PENDING SUBMISSION") {
		showHideElementById("verification", "block");
	} else {
		showHideElementById("verification", "none");
	}

	if (ws == "SUBMITTED FOR VERIFICATION") {
		showHideElementById("approval", "block");
	} else {
		showHideElementById("approval", "none");
	}

	if ((ws == "PENDING SUBMISSION" || ws == "SUBMITTED FOR VERIFICATION") && paymentType == "Claim") {
		showHideElementById("returnForAmmendments", "block");
	} else {
		showHideElementById("returnForAmmendments", "none");
	}
}

function enableRadioButton() {
	var radio = document.getElementsByName("addDeductType");
	var len = radio.length;
	for (var i = 0; i < len; i++) {
		radio[i].disabled = false;
	}
}

function changeFinalAmount() {
	var adType = getSelectedRadio("addDeductType").value;
	var amt = getEID(namespace + "paymentAmount").value;
	var diffAmt = getEID(namespace + "addDeductAmount").value;
	if (diffAmt) {
		if (adType == "Add") {
			getEID(namespace + "finalAmount").value = parseFloat(amt)
					+ parseFloat(diffAmt);
		} else {
			getEID(namespace + "finalAmount").value = parseFloat(amt)
					- parseFloat(diffAmt);
		}
	} else {
		getEID(namespace + "finalAmount").value = amt;
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

function doClaimAction(action, linkElement) {

	getEID("popup-submit-action").innerHTML = "SUBMIT";
	getEID("popup-cancel-action").innerHTML = "CANCEL";
	getEID("action-value").value = action;
	var as = "";
	var ws = "";
	var addDedAmt = ""
	var addDedType = ""
	var finalAmt = ""
	if (action == "detail") {
		goToDetailScreen(linkElement);
	} else {
		if (mode != "list") {
			addDedAmt = getEID(namespace + "addDeductAmount").value;
			var val = getSelectedRadio("addDeductType").value;
			addDedType = false;
			if (val == "Add") {
				addDedType = true;
			}
			finalAmt = getEID(namespace + "finalAmount").value;
		}

		if (action == "reject") {
			as = "Rejected";
			ws = "Rejected";
		}
		if (action == "amendments" || action == "samendments") {
			as = "Pending Amendments";
			ws = "Pending Submission";
		}
		if (action == "vamendments") {
			as = "Pending Amendments";
			ws = "Submitted For Verification";
		}
		if (action == 'approve') {
			as = "Approved";
			ws = "Confirmed"; // TODO check once
		}
		if (action == "verification") {
			as = "Pending Verification";
			ws = "Submitted For Verification";
		}
		if (action == "approval") {
			as = "Pending Approval";
			ws = "Submitted For Approval";
		}
		if (action == "gverification") {
			as = "Pending Verification";
			ws = "Submitted For Verification";
			openDialog("claim-action", function(modal) {
				modal.hide();
				for ( var ri in records) {
					var rec = records[ri];
					if (rec.contentJson.ApprovalStatus.toUpperCase() == "PENDING SUBMISSION") {
						processClaim(rec.storageId, ws, as, document
								.getElementById("claim_action_reason").value, addDedAmt,
								addDedType, finalAmt);
					}
				}
			});
			return;
		}

		if (action == "gapprove") {
			as = "Approved";
			ws = "Confirmed";
			openDialog("claim-action", function(modal) {
				modal.hide();
				for ( var ri in records) {
					var rec = records[ri];
					if (rec.contentJson.ApprovalStatus.toUpperCase() == "PENDING APPROVAL") {
						processClaim(rec.storageId, ws, as, document
								.getElementById("claim_action_reason").value, addDedAmt,
								addDedType, finalAmt);
					}
				}
			});
			return;
		}

		if (action == "gapproval") {
			as = "Pending Approval";
			ws = "Submitted For Approval";
			openDialog("claim-action", function(modal) {
				modal.hide();
				for ( var ri in records) {
					var rec = records[ri];
					if (rec.contentJson.ApprovalStatus.toUpperCase() == "PENDING VERIFICATION") {
						processClaim(rec.storageId, ws, as, document
								.getElementById("claim_action_reason").value, addDedAmt,
								addDedType, finalAmt);
					}
				}
			});
			return;
		}

		if (action == "gamendments") {
			as = "Pending Amendments";
			ws = "Pending Submission";
			openDialog("claim-action", function(modal) {
				if (getEID("claim_action_reason").value.trim().length==0)
				{
					showHideElementById("error-remarks", "block");
				}
				else
				{
				modal.hide();
				for ( var ri in records) {
					var rec = records[ri];
					if (rec.contentJson.ApprovalStatus.toUpperCase() == "PENDING SUBMISSION"
							|| rec.contentJson.ApprovalStatus.toUpperCase() == "PENDING VERIFICATION") {
						processClaim(rec.storageId, ws, as, document
								.getElementById("claim_action_reason").value, addDedAmt,
								addDedType, finalAmt);
					}
				}
				}
			});
			return;
		}

		if (action == "gsamendments") {
			as = "Pending Amendments";
			ws = "Pending Submission";
			openDialog("claim-action", function(modal) {
				if (getEID("claim_action_reason").value.trim().length==0)
				{
					showHideElementById("error-remarks", "block");
				}
				else
				{
				modal.hide();
				for ( var ri in records) {
					var rec = records[ri];
					if (rec.contentJson.ApprovalStatus.toUpperCase() == "PENDING APPROVAL") {
						processClaim(rec.storageId, ws, as, document
								.getElementById("claim_action_reason").value, addDedAmt,
								addDedType, finalAmt);
					}
				}
				}
			});
			return;
		}

		if (action == "gvamendments") {
			as = "Pending Amendments";
			ws = "Submitted For Verification";
			openDialog("claim-action", function(modal) {
				if (getEID("claim_action_reason").value.trim().length==0)
				{
					showHideElementById("error-remarks", "block");
				}
				else
				{
				modal.hide();
				for ( var ri in records) {
					var rec = records[ri];
					if (rec.contentJson.ApprovalStatus.toUpperCase() == "PENDING APPROVAL") {
						processClaim(rec.storageId, ws, as, document
								.getElementById("claim_action_reason").value, addDedAmt,
								addDedType, finalAmt);
					}
				}
				}	
			});
			return;
		}

		if (action == "greject") {
			as = "Rejected";
			ws = "Rejected";
			openDialog("claim-action", function(modal) {
				if (getEID("claim_action_reason").value.trim().length==0)
				{
					showHideElementById("error-remarks", "block");
				}
				else
				{
				modal.hide();
				for ( var rir in records) {
					var recr = records[rir];
					if (recr.contentJson.ApprovalStatus.toUpperCase() == "PENDING SUBMISSION"
							|| recr.contentJson.ApprovalStatus.toUpperCase() == "PENDING VERIFICATION"
							|| recr.contentJson.ApprovalStatus.toUpperCase() == "PENDING APPROVAL") {
						processClaim(recr.storageId, ws, as, document
								.getElementById("claim_action_reason").value,
								addDedAmt, addDedType, finalAmt);
					}
				}
			}
			});

			return;
		}

		getEID("claim_action_reason").value = "";
		openDialog("claim-action", function(modal) {
			var sId = "";
			var claimReason =getEID("claim_action_reason").value.trim() ;
			if (mode == "list") {
				sId = getStorageIdFromList(linkElement);
			} else {
				sId = formStorageId;
			}
			if ((action == 'reject' || action == 'amendments'
				|| action == 'samendments' || action == 'vamendments')
				&& claimReason.length==0)
			{
				showHideElementById("error-remarks", "block");
			}
			else 
			{
			modal.hide();
			processClaim(sId, ws, as, claimReason,addDedAmt, addDedType, finalAmt);
			}
		}, null);
	}
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
function processClaim(storageId, ws, as, remark, addDedAmt, addDedType,
		finalAmt) {
	var data = {};
	data.formType = "submittedclaim";
	data.formStorageId = storageId;
	
	var scpObj = {};
	scpObj.storageId = storageId;
	scpObj.workFlowStatus = ws;
	scpObj.approvalStatus = as;
	scpObj.remark = remark;
	scpObj.addDedAmt = parseFloat(addDedAmt);
	scpObj.addDedType = addDedType;
	scpObj.finalAmt = parseFloat(finalAmt);
	scpObj.productType = productMap['Exam'];
	scpObj.productSubType = productSubtypeMap['SAC'];
	scpObj.functionalComponent = functionalMap["F"];
	scpObj.txnType = transactionTypeMap['Invoice'];
	scpObj.type = clientTypeMap['Individual'];
	scpObj.categoryType = categoryMap['PA'];
	scpObj.viewUrl = detailScreenUrl.replace("[$storageId$]", storageId);
	if (getEID(namespace + "notes"))
		scpObj.relcRemark = getEID(namespace + "notes").value;
	data.processDto = scpObj;
	console.log(data);
	showLoading(true);
	ajaxCallAPI(
			'POST',
			'processWorkflow',
			data,
			function() {
				data = this.get("responseData");
				if (data.error) {
					displayMessage('danger', data.error, 3000);
				} else {
					console.log("DONE...");
					var popupdiv = "#action-feedback-dialog";
					var popupdivbox = "#action-feedback-dialog-box";
					AUI()
							.use(
									'aui-base',
									function(A) {
										A.one(popupdiv).set('hidden', false);
										YUI()
												.use(
														'aui-modal',
														function(Y) {
															var modal = new Y.Modal(
																	{
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
																			},
																		},
																	}).render()
															Y
																	.one(
																			'.process-popup-ok-action')
																	.on(
																			'click',
																			function() {
																				console
																						.log("popup-ok-action...");
																				modal
																						.hide();
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

function formatDate(date) {
	var dd = date.getDate();
	var mm = date.getMonth() + 1; //January is 0!
	var yyyy = date.getFullYear();
	if (dd < 10) {
	  dd = '0' + dd;
	} 
	if (mm < 10) {
	  mm = '0' + mm;
	} 
	return dd + '/' + mm + '/' + yyyy;
}

function hideDiv() {
	showHideElementById("error-remarks", "none");
}

function validateRemarks()
 {
	var action = getEID("action-value").value;
	var remarks = getEID("claim_action_reason").value.trim();

	if ((action == 'reject' || action == 'amendments'
			|| action == 'samendments' || action == 'vamendments'
			|| action == "greject" || action == "gvamendments"
			|| action == "gsamendments" || action == "gamendments")
			&& remarks.length == 0) {
		showHideElementById("error-remarks", "block");
	} else {
		showHideElementById("error-remarks", "none");
	}
}

