var panelVisible = {
	ato : false,
	review : false,
	competence : false
}
var dateFrom;
var dateTo;
var practicalExperience;
var subjectsByPanel = {};
var competenceById = {};
var subjectsById = {};
var questionsById = {};
var competencyObj = {};
var oldCompetencyObj = {};
var todaysRemark = {};
var olderRemark = {};
var todaysNullifyRemark = {};
var olderNullifyRemarks = {};
var createModeFormStorageId = "0";
var remarksObj = {};
var subjectsStorageID = {};
var isStandardReview = false;
var isFinalReview = false;
var isSignOff = false;
var trainingPrincipalId;
var mentorId;
if (formStorageId === "0") {
	createModeFormStorageId = uuidv4();
	if (getEID("forFinalReview") !== null) {
		// getEID("forFinalReview").disabled = "true";
		// getEID("forFinalReview").style.opacity = 0.5;
		// getEID("forFinalReview").style.cursor = "not-allowed";
//		getEID("forFinalReview").disabled = "true";
		getEID("forFinalReview").classList.add("disable-final-review");
	}
}
var isErrorFormDate = false;
var isErrorPracticalExp = false;
var storedResponse = {};

if (document.readyState == 'complete') {
	convertResponseToMap();
} else {
	window.addEventListener('load', function() {
		convertResponseToMap();
	}, false);
}

// window.onload = convertResponseToMap();
function convertResponseToMap() {

	getEID("loadingDiv").style.display = "block";

	if (formStorageId !== "0") {
		var storageId = formStorageId;
		var fdata = [ storageId ];
		var filters = {
			"contentJson.storageId" : fdata
		}
		var farray = [ filters ];
		var remarksData = {
			"formType" : "erpec",
			"storageId" : storageId,
			"filters" : farray
		}
		var remarks = [];

		console.log("convertResponseToMap:FetchRemarks--->" + remarksData);
		ajaxCallAPI(
				'POST',
				'fetchRemarks',
				remarksData,
				function() {
					debugger;
					console
							.log("After WS convertResponseToMap:FetchRemarks--->"
									+ this.get("responseData"));
					if (this.get("responseData") !== undefined
							&& this.get("responseData") !== null) {
						if (this.get("responseData").error) {
							displayMessageDivConstant('danger', data.error);
							getEID("loadingDiv").style.display = "none";
						} else {
							var response = this.get("responseData");
							storedResponse = response;
							loadCompetenceData();
							var competence = response.content[0].contentJson.competency;
							competence
									.forEach(function(comp) {
										loadCompetenceSubjectOnEdit(comp.competencyId);
										competencyObj[comp.competencyId] = {};
										oldCompetencyObj[comp.competencyId] = {};
										comp.competencyDetail
												.forEach(function(subjects) {
													subjectsStorageID[subjects.subjectId] = subjects;
													competencyObj[comp.competencyId][subjects.subjectId] = {};
													oldCompetencyObj[comp.competencyId][subjects.subjectId] = {};
													subjects.questionList
															.forEach(function(
																	questions) {
																competencyObj[comp.competencyId][subjects.subjectId][questions.questionId] = questions;
																oldCompetencyObj[comp.competencyId][subjects.subjectId][questions.questionId] = questions;
															})
												})
									});
							mentorId = response.content[0].contentJson.mentorId;
							trainingPrincipalId = response.content[0].contentJson.trainingPrincipalId;
							reviewPeriodNumber = response.content[0].contentJson.reviewPeriodNumber;
							isStandardReview = response.content[0].contentJson.isStandardReview;
							isFinalReview = response.content[0].contentJson.isFinalReview;
							isSignOff = response.content[0].contentJson.isSignOff;
							if ((rpecStatus === "Approved" || rpecStatus === "Approved By Mentor")
									&& isStandardReview === true) {
								if (getEID("standardReview") !== null) {
									getEID("standardReview").style.display = "none";
								}
							}
							if ((rpecStatus === "Pending Standard Approval" && isStandardReview === false)
									|| ((rpecStatus === "Approved" || rpecStatus === "Approved By Mentor")
											&& isStandardReview == true && isFinalReview == true)
									|| (rpecStatus === "Pending Sign Off"
											&& isStandardReview == true && isStandardReview == true)
									|| rpecStatus === "Pending Final Approval") {
								if (getEID("standardReview") !== null) {
									getEID("standardReview").style.display = "none";
								}
								if (getEID("forFinalReview") !== null) {
									getEID("forFinalReview").style.display = "none";
								}
							}
							if (rpecStatus === "Completed") {
								if (getEID("standardReview") !== null) {
									getEID("standardReview").style.display = "none";
								}
								if (getEID("forFinalReview") !== null) {
									getEID("forFinalReview").style.display = "none";
								}
								if (getEID("publishRecord") !== null) {
									getEID("publishRecord").style.display = "none";
								}
								if (getEID("approveRecord") !== null) {
									getEID("approveRecord").style.display = "none";
								}
								if (getEID("rejectRecord") !== null) {
									getEID("rejectRecord").style.display = "none";
								}
								if (getEID("save") !== null) {
									getEID("save").style.display = "none";
								}
							}
							if (rpecStatus === "Nullified") {
								if (getEID("publishRecord") != null) {
									getEID("publishRecord").style.display = "none";
								}
							}
							if (rpecStatus === "Rejected") {
								if (getEID("forFinalReview") !== null) {
									getEID("forFinalReview").style.display = "none";
								}
								if (getEID("approveRecord") !== null) {
									getEID("approveRecord").style.display = "none";
								}
								if (getEID("rejectRecord") !== null) {
									getEID("rejectRecord").style.display = "none";
								}
							}
							if (rpecStatus == "Draft") {
								if (getEID("forFinalReview") !== null) {
									// getEID("forFinalReview").style.disable =
									// "true";
									// getEID("forFinalReview").style.opacity =
									// 0.5;
									// getEID("forFinalReview").style.cursor =
									// "not-allowed";
//									getEID("forFinalReview").disabled = "true";
									getEID("forFinalReview").classList
											.add("disable-final-review");
								}
							}
							if (getEID('atoName') != null) {
								getEID('atoName').value = response.content[0].contentJson.accreditedTrainingOrganisation;
							}
							getEID("mentorName").value = response.content[0].contentJson.mentorName;
							getEID("jobRole").value = response.content[0].contentJson.candidateJobRole;
							getEID("dateFromJobRole").value = response.content[0].contentJson.startDate;
							getEID("trainingPrincipal").value = response.content[0].contentJson.trainingPrincipalName;
							getEID("dateToJobRole").value = response.content[0].contentJson.endDate;

							getEID("reviewPeriod").innerHTML = response.content[0].contentJson.reviewPeriodNumber;
							document.getElementById("dateFrom").value = convertToAnotherFormatDate(response.content[0].contentJson.reviewFromDate);
							document.getElementById("dateTo").value = convertToAnotherFormatDate(response.content[0].contentJson.reviewToDate);
							document.getElementById("practicalExp").value = response.content[0].contentJson.totalDaysSpentOnPracticalExperience;

							if (userType.toLowerCase() === 'mentor'
									|| userType.toLowerCase() === 'trainingprincipal') {
								document.getElementById("dateFrom").disabled = true;
								document.getElementById("dateTo").disabled = true;
								document.getElementById("practicalExp").disabled = true;

							}

							if (document.getElementById("reviewRejected") !== null) {
								document.getElementById("reviewRejected").innerHTML = 'REPC Record <strong>'
										+ response.content[0].contentJson.reviewPeriodNumber
										+ '</strong>'
										+ ' reviewed and rejected by <strong>'
										+ response.content[0].contentJson.modifiedByName
										+ '</strong> on '
										+ parseDateForRPECNotification(response.content[0].lastModifiedDate);
							} else if (document
									.getElementById("reviewApproved") !== null) {
								document.getElementById("reviewApproved").innerHTML = 'REPC Record <strong>'
										+ response.content[0].contentJson.reviewPeriodNumber
										+ '</strong>'
										+ ' reviewed and approved by <strong>'
										+ response.content[0].contentJson.modifiedByName
										+ '</strong> on '
										+ parseDateForRPECNotification(response.content[0].lastModifiedDate);
							} else if (document
									.getElementById("reviewNullified") !== null) {
								document.getElementById("reviewNullified").innerHTML = 'REPC Record <strong>'
										+ response.content[0].contentJson.reviewPeriodNumber
										+ '</strong>'
										+ ' was nullified by <strong>'
										+ response.content[0].contentJson.modifiedByName
										+ '</strong> on '
										+ parseDateForRPECNotification(response.content[0].lastModifiedDate);
								createRemarks("Nullify");
							}
							getEID("loadingDiv").style.display = "none";
						}
					}
				}, function() {
					getEID("loadingDiv").style.display = "none";
				});
		console.log("competencyObj data :: " + JSON.stringify(competencyObj));
	} else {
		getEID("loadingDiv").style.display = "none";
	}
	
	if(mode === 'view' || userType.toLowerCase() === 'mentor'
		|| userType.toLowerCase() === 'trainingprincipal')
	{
		disableForView();
	}
	
}

function getDateFromDate() {
	dateFrom = getEID("dateFrom").value;
	dateTo = getEID("dateTo").value;
	getEID("dateFrom").style.borderColor = "#b1bed7";
	getEID("mandatoryDateFrom").style.display = "none";
	if (Date.parse(getEID("dateFrom").value) > Date.parse(dateTo)) {
		getEID("error_date").innerHTML = "<img src= '/html/images/error.png'></img>Date To must be greater than Date From";
		getEID("error_date").style.display = "block";
		isErrorFormDate = true;
		getEID("dateTo").style.borderColor = "#c03643"
		if (getEID("save") != null) {
			getEID("save").disabled = true;
		}
		if (getEID("standardReview") != null) {
			getEID("standardReview").disabled = true;
		}
	} else {
		getEID("error_date").innerHTML = "";
		getEID("error_date").style.display = "none";
		isErrorFormDate = false;
		getEID("dateTo").style.borderColor = "#b1bed7"
		if (!isErrorFormDate && !isErrorPracticalExp) {
			if (getEID("save") != null) {
				getEID("save").disabled = false;
			}
			if (getEID("standardReview") != null) {
				getEID("standardReview").disabled = false;
			}
		}
	}

}
function getDateToDate() {
	dateTo = getEID("dateTo").value;
	getEID("dateTo").style.borderColor = "#b1bed7"
	getEID("error_date").style.display = "none"
	if (Date.parse(getEID("dateFrom").value) > Date.parse(dateTo)) {
		getEID("error_date").innerHTML = "<img src= '/html/images/error.png'></img>Date To must be greater than Date From";
		getEID("error_date").style.display = "block";
		getEID("dateTo").style.borderColor = "#c03643"
		isErrorFormDate = true;
		if (getEID("save") != null) {
			getEID("save").disabled = true;
		}
		if (getEID("standardReview") != null) {
			getEID("standardReview").disabled = true;
		}
	} else {
		getEID("error_date").innerHTML = "";
		getEID("error_date").style.display = "none";
		getEID("dateTo").style.borderColor = "#b1bed7"
		isErrorFormDate = false;
		if (!isErrorFormDate && !isErrorPracticalExp) {
			if (getEID("save") != null) {
				getEID("save").disabled = false;
			}
			if (getEID("standardReview") != null) {
				getEID("standardReview").disabled = false;
			}
		}
	}
	validatePracticalExperience();
}
function validatePracticalExperience() {
	practicalExperience = getEID("practicalExp").value;
	getEID("practicalExp").style.borderColor = "#b1bed7"
	getEID("prcExp").style.display = "none"
	if (getEID("dateTo").value !== "" && getEID("dateFrom").value !== "") {
		var differencetime = Date.parse(getEID("dateTo").value)
				- Date.parse(getEID("dateFrom").value);
		var differenceDays = Math.ceil(differencetime / (1000 * 60 * 60 * 24));
		if (differenceDays < practicalExperience) {
			isErrorPracticalExp = true;
			if (getEID("save") != null) {
				getEID("save").disabled = true;
			}
			if (getEID("standardReview") != null) {
				getEID("standardReview").disabled = true;
			}
			getEID("practicalExp").style.borderColor = "#c03643";
			getEID("prcExp").innerHTML = "<img src= '/html/images/error.png'></img>The number of days entered are more than the selected Dates difference";
			getEID("prcExp").style.display = "block";
		} else if (parseInt(practicalExperience, 10) > parseInt(maximumDays, 10)) {
			isErrorPracticalExp = true;
			if (getEID("save") != null) {
				getEID("save").disabled = true;
			}
			if (getEID("standardReview") != null) {
				getEID("standardReview").disabled = true;
			}
			getEID("practicalExp").style.borderColor = "#c03643";
			getEID("prcExp").innerHTML = "<img src= '/html/images/error.png'></img>Maximum Duration for \"Days spent on Practical Experience in this ATO\" is 120 calendar days.";
			getEID("prcExp").style.display = "block";
		} else {
			if (!isErrorFormDate) {
				if (getEID("save") != null) {
					getEID("save").disabled = false;
				}
				if (getEID("standardReview") != null) {
					getEID("standardReview").disabled = false;
				}
			}
			getEID("prcExp").innerHTML = "";
			getEID("prcExp").style.display = "none";
			getEID("practicalExp").style.borderColor = "#b1bed7"
		}
	} else {
		if (parseInt(practicalExperience, 10) > parseInt(maximumDays, 10)) {
			isErrorPracticalExp = true;
			if (getEID("save") != null) {
				getEID("save").disabled = true;
			}
			if (getEID("standardReview") != null) {
				getEID("standardReview").disabled = true;
			}
			getEID("practicalExp").style.borderColor = "#c03643";
			getEID("prcExp").innerHTML = "<img src= '/html/images/error.png'></img>Maximum Duration for \"Days spent on Practical Experience in this ATO\" is 120 calendar days.";
			getEID("prcExp").style.display = "block";
		} else {
			if (!isErrorFormDate) {
				if (getEID("save") != null) {
					getEID("save").disabled = false;
				}
				if (getEID("standardReview") != null) {
					getEID("standardReview").disabled = false;
				}
			}
			getEID("prcExp").innerHTML = "";
			getEID("prcExp").style.display = "none";
			getEID("practicalExp").style.borderColor = "#b1bed7"
		}
	}
}
function validateMandatoryFields(status) {
	// if (status === "Pending Final Approval"
	// && (rpecStatus === "null" || rpecStatus.toLowerCase() === "draft")) {
	// return false;
	// }
	var isError = false;
	if (getEID("dateTo").value === "" || getEID("dateTo").value === null
			|| getEID("dateTo").value === undefined) {
		getEID("error_date").innerHTML = "<img src= '/html/images/error.png'></img>Date To is mandatory";
		getEID("error_date").style.display = "block";
		getEID("dateTo").style.borderColor = "#c03643"
		isError = true;
	}
	if (getEID("dateFrom").value === "" || getEID("dateFrom").value === null
			|| getEID("dateFrom").value === undefined) {
		getEID("mandatoryDateFrom").innerHTML = "<img src= '/html/images/error.png'></img>Date From is mandatory";
		getEID("mandatoryDateFrom").style.display = "block";
		getEID("dateFrom").style.borderColor = "#c03643"
		isError = true;
	}
	if (getEID("practicalExp").value === ""
			|| getEID("practicalExp").value === null
			|| getEID("practicalExp").value === undefined) {
		getEID("prcExp").innerHTML = "<img src= '/html/images/error.png'></img>Practical Experience is mandatory";
		getEID("prcExp").style.display = "block";
		getEID("practicalExp").style.borderColor = "#c03643"
		isError = true;
	}
	
	debugger;
	if(status === 'Pending Final Approval')
	{
		if(!document.getElementById("forFinalReview").classList
				.contains("disable-final-review"))
		{
			var isRemarksSave = isRemarksRemain();
			
			if (!panelVisible.review && isError) {
				togglePanels('Review', null);
			}else if(!isRemarksSave){
				openSuccessPopup("#remarks-fails", "#remarks-fails-box", status);
			}
			
			if (!isError && isRemarksSave) {
				saveRPECData(status, false);
			}
		}
	}
	else
	{
		var isRemarksSave = isRemarksRemain();
		
		if (!panelVisible.review && isError) {
			togglePanels('Review', null);
		}else if(!isRemarksSave){
			openSuccessPopup("#remarks-fails", "#remarks-fails-box", status);
		}
		
		if (!isError && isRemarksSave) {
			saveRPECData(status, false);
		}
	}
	
	
}

function createCompetencyList() {
	var competencyData = [];
	Object
			.keys(competencyObj)
			.forEach(
					function(ck) {
						var competence = {};
						competence.competencyName = competenceById[ck].typeName;
						competence.competencyId = ck;
						var competencyDetailList = [];
						Object
								.keys(competencyObj[ck])
								.forEach(
										function(sk) {
											var competencyDetail = {};
											if (formStorageId === "0") {
												competencyDetail.storageId = uuidv4();
											} else {
												if (subjectsStorageID[sk] !== undefined
														&& subjectsStorageID[sk] !== null
														&& subjectsStorageID[sk].storageId !== undefined) {
													competencyDetail.storageId = subjectsStorageID[sk].storageId;
												} else {
													competencyDetail.storageId = uuidv4();
												}
											}
											competencyDetail.subjectId = sk;
											competencyDetail.subjectName = subjectsById[sk].subjectName;
											var questionList = [];
											Object
													.keys(competencyObj[ck][sk])
													.forEach(
															function(qk) {
																questionList
																		.push(competencyObj[ck][sk][qk]);
															});
											competencyDetail.questionList = questionList;
											competencyDetailList
													.push(competencyDetail);
										});
						competence.competencyDetail = competencyDetailList;
						competencyData.push(competence);
					});
	console.log(JSON.stringify(competencyData));
	return competencyData;
}

function validateRPECData(RPECData, status) {
	var validate = true;

	if (status === "Pending Standard Approval"
			|| status === "Pending Final Approval") {
		if (RPECData.competency !== "undefined"
				&& RPECData.competency.length > 0) {
			for (var i = 0; i < RPECData.competency.length; i++) {
				if (RPECData.competency[i].competencyDetail !== "undefined"
						&& RPECData.competency[i].competencyDetail.length > 0) {
					for (var j = 0; j < RPECData.competency[i].competencyDetail.length; j++) {
						if (RPECData.competency[i].competencyDetail[j].questionList !== "undefined"
								&& !RPECData.competency[i].competencyDetail[j].questionList.length > 0) {
							validate = false;
							break;
						}
					}
					if (!validate) {
						break;
					}
				} else {
					validate = false;
					break;
				}
			}
		} else {
			validate = false;
		}

		if (!validate) {
			openSuccessPopup("#submitting-fails", "#submitting-fails-box", "");
			showLoading(false);
		}
	}

	return validate;
}

function saveRPECData(status, isCheckProficiency) {
	showLoading(true);
	var RPECData = {};

	RPECData.totalDaysSpentOnPracticalExperience = document
			.getElementById("practicalExp").value;
	RPECData.rpecStatus = status;
	if (status === "Draft") {
		isStandardReview = false;
		isFinalReview = false;
		isSignOff = false;
	}
	RPECData.reviewFromDate = parseDateForRPEC(document
			.getElementById("dateFrom").value)
			+ " 00:00:00";
	RPECData.reviewToDate = parseDateForRPEC(document.getElementById("dateTo").value)
			+ " 00:00:00";
	RPECData.candidateId = candidateId;
	RPECData.candidateName = candidatesData.FullName;
	console.log("candidatesData --> " + candidatesData.FullName);
	RPECData.isPublished = false;
	// RPECData.userType = userType;
	RPECData.reviewPeriodNumber = reviewPeriodNumber;
	RPECData.formType = modelName.toLowerCase();
	RPECData.formStorageId = formStorageId;
	RPECData.storageId = formStorageId;
	var competencyList = createCompetencyList();
	RPECData.competency = competencyList;
	// RPECData.modifiedByName = userName;
	RPECData.isStandardReview = isStandardReview;
	RPECData.isFinalReview = isFinalReview;
	RPECData.isSignOff = isSignOff;
	RPECData.isDeleted = false;
	if (formStorageId === "0") {
		RPECData.trainingPrincipalId = finalData.CandidateRole.TrainingPrincipalUserId;
		RPECData.mentorId = finalData.ApprovedMentors.userId;
		RPECData.accreditedTrainingOrganisationId = finalData.AtoName.organizationId;
		RPECData.startDate = parseDateForRPECNotification(finalData.CandidateRole.RoleDateFrom);
		RPECData.endDate = parseDateForRPECNotification(finalData.CandidateRole.RoleDateTo);
		RPECData.accreditedTrainingOrganisation = finalData.AtoName.name;
		RPECData.mentorName = finalData.ApprovedMentors.firstName + " "
				+ finalData.ApprovedMentors.lastName;
		RPECData.candidateJobRole = finalData.CandidateRole.CandidateJobTitle;
		RPECData.trainingPrincipalName = finalData.CandidateRole.TrainingPrincipalName;
		RPECData.userType = userType;
		RPECData.modifiedByName = "";
	} else {
		RPECData.trainingPrincipalId = storedResponse.content[0].contentJson.trainingPrincipalId;
		RPECData.mentorId = storedResponse.content[0].contentJson.mentorId;
		RPECData.accreditedTrainingOrganisationId = storedResponse.content[0].contentJson.accreditedTrainingOrganisationId;
		RPECData.startDate = storedResponse.content[0].contentJson.startDate;
		RPECData.endDate = storedResponse.content[0].contentJson.endDate;
		RPECData.accreditedTrainingOrganisation = storedResponse.content[0].contentJson.accreditedTrainingOrganisation;
		RPECData.mentorName = storedResponse.content[0].contentJson.mentorName;
		RPECData.candidateJobRole = storedResponse.content[0].contentJson.candidateJobRole;
		RPECData.trainingPrincipalName = storedResponse.content[0].contentJson.trainingPrincipalName;
		RPECData.userType = storedResponse.content[0].contentJson.userType;
		if (userType.toLowerCase() === "relcuser"
				|| userType.toLowerCase() === "mentor") {
			RPECData.modifiedByName = userName;
		} else {
			RPECData.modifiedByName = storedResponse.content[0].contentJson.modifiedByName;
		}
	}

	console.log(JSON.stringify(RPECData));
	if (formStorageId !== "0") {
		mode = "edit";
		if (status === "Completed") {
			RPECData.isPublished = true;
		}
	} else {
		RPECData.storageId = createModeFormStorageId;
	}

	if (validateRPECData(RPECData, status)) {
		if (!isCheckProficiency) {
			ajaxCallAPI('POST', 'persist', RPECData, function() {
				var data = this.get("responseData");
				if (this.get("responseData").checkErrorFlag) {
					displayMessageDivConstant('danger', this
							.get("responseData").message);
					showLoading(false);
					return;
				}
				if (data.error) {
					displayMessageDivConstant('danger', data.error);
				} else if (Object.keys(data).length === 0) {
					console.log("data : " + data);
					displayMessageDivConstant('danger',
							'Form submission failed.');
				} else {
					console.log(data.toString());
					// var message = "RPEC Record added successfully.";
					if(status == "Approved" && userType.toLowerCase() == "relcuser") {
						openSuccessPopup("#success-review-approved", "#success-review-approved-box", "");
					} else {
					openSuccessPopup("#success-submit", "#success-submit-box", "");
					}
					// displayMessageDiv("success", message, 3000);
					// clearRPECForm();
				}
				showLoading(false);
			}, function() {
				displayMessageDivConstant('danger',
						"Error in persisting dynamic form data.");
				showLoading(false);
			});
		} else {
			ajaxCallAPI('POST', 'checkCompetencyProficiency', RPECData,
					function() {
						var data = this.get("responseData");
						if (getEID("forFinalReview") !== null) {
							if (data.checkErrorFlag) {
								getEID("forFinalReview").disabled = false;
								getEID("forFinalReview").classList
										.remove("disable-final-review");
							} else {
								//getEID("forFinalReview").disabled = "true";
								getEID("forFinalReview").classList
										.add("disable-final-review");
							}
						}

						showLoading(false);
					}, function() {
						displayMessageDivConstant('danger',
								"Error in persisting dynamic form data.");
						showLoading(false);
					});
		}
	}
}

function parseDateForRPEC(date) {
	if (date != "") {
		var t = new Date(date);
		var dt = ((t.getDate() + '').length === 1) ? '0' + t.getDate() : t
				.getDate();
		var month = t.getMonth() + 1;
		month = ((month + '').length === 1) ? '0' + month : month;
		var year = t.getFullYear();
		return dt + '-' + month + '-' + year;
	}
	return "";
}

function parseDateForRPECNotification(date) {
	if (date != "") {
		var t = new Date(date);
		var dt = ((t.getDate() + '').length === 1) ? '0' + t.getDate() : t
				.getDate();
		var month = t.getMonth() + 1;
		month = ((month + '').length === 1) ? '0' + month : month;
		var year = t.getFullYear();
		return dt + '/' + month + '/' + year;
	}
	return "";
}

function displayMessageDiv(type, message, duration) {
	var alert_div = getEID("alert_msg");
	alert_div.innerHTML = message;
	alert_div.className = "";
	alert_div.classList.add("alert-" + type);
	alert_div.classList.add("alert");
	alert_div.style.display = "block";
	setTimeout(function() {
		alert_div.style.display = "none";
	}, duration);
	console.log(message);
}
function displayMessageDivConstant(type, message) {
	var alert_div = getEID("alert_msg");
	alert_div.innerHTML = message;
	alert_div.className = "";
	alert_div.classList.add("alert-" + type);
	alert_div.classList.add("alert");
	alert_div.style.display = "block";

	console.log(message);
}
function clearRPECForm() {
	getEID("dateFrom").value = "";
	getEID("dateTo").value = "";
	getEID("practicalExp").value = "";
}
function showToolTip(flag) {
	if(flag)
	{
		if (document.getElementById("forFinalReview") != null) {
			if (document.getElementById("forFinalReview").classList
					.contains("disable-final-review")) {
				if (document.getElementById("finalReviewtooltip").style.display === "none") {
					document.getElementById("finalReviewtooltip").style.display = "block";
				}
			}
		}
	}else
	{
		if (document.getElementById("forFinalReview") != null) {
			if (document.getElementById("forFinalReview").classList
					.contains("disable-final-review")) {
				if (document.getElementById("finalReviewtooltip").style.display === "block") {
					document.getElementById("finalReviewtooltip").style.display = "none";
				}
			}
		}
	}
	
}
function setImpInfoWidth() {
	var w = document.body.clientWidth;
	var ml = (w - 1200) / 2;
	var el = document.getElementsByClassName('info-block')[0];
	var el2 = document.getElementsByClassName('top-info')[0];
	if (el) {
		el.style.width = w + 'px';
		el.style.marginLeft = '-' + ml + 'px';
		el.style.paddingLeft = ml + 'px';
	}
	if (el2) {
		el2.style.width = w + 'px';
		el2.style.marginLeft = '-' + ml + 'px';
		el2.style.paddingLeft = ml + 'px';
	}
}
function loadCompetenceData() {
	if (getEID('panelCompetenceDiv').innerHTML === "") {
		var competenceData = {
			"formType" : "erpec"
		}
		ajaxCallAPI('POST', 'competenceType', competenceData, function() {
			var competencies = this.get("responseData");
			if (competencies !== null && competencies !== undefined
					&& competencies.error) {
				displayMessage('danger', competencies.error, 3000);
			}
			if (getEID('panelCompetenceDiv').innerHTML === "") {

				if (competencies !== null && competencies !== undefined) {
					competencies.forEach(function(comp) {
						competenceById[comp.typeId] = comp;
						// competencyObj[comp.typeId] = {};
						// console.log("competence Object :: " +
						// JSON.stringify(competencyObj));
						getEID('panelCompetenceDiv').innerHTML += createPanel(
								comp.typeName, comp.typeId,
								'CompetenceSubject', false);
					});
					console.log("competenceById   ::"
							+ JSON.stringify(competenceById));
				}
			}

		}, function() {

		});
	}
}
function createPanel(panelName, panelId, panelType, isRemovable) {
	if (!isRemovable) {
		return '<div class= "mb-2 card border panel panel-default">'
				+ '<div class="card-header bg-default panel-heading formio-clickable" onclick="togglePanels('
				+ panelId
				+ ',\''
				+ panelType
				+ '\')">'
				+ '<h4 class="mb-0 card-title panel-title">'
				+ '<i class="glyphicon formio-collapse-icon expand" id="panel'
				+ panelId
				+ 'plus"></i>'
				+ '<i class="more pop collapse" style="display: none;" id="panel'
				+ panelId
				+ 'minus"></i> '
				+ panelName.toUpperCase()
				+ '</h4>'
				+ '</div>'
				+ '<div class="card-body panel-body" style="display: none;"	hidden="true" id="panel'
				+ panelId + 'Div" >' + '</div>' + '</div>';
	} else {
		
		var panelReturn = '<div class = "d-flex" id="panel'
			+ panelId
			+ 'parent"><div class= "mb-2 card border panel panel-default left-panel">'
			+ '<div class="card-header bg-default panel-heading formio-clickable" style="margin-top:0px" onclick="togglePanels(\''
			+ panelId
			+ '\',\''
			+ panelType
			+ '\')">'
			+ '<h4 class="mb-0 card-title panel-title">'
			+ '<i class="glyphicon formio-collapse-icon expand" id="panel'
			+ panelId
			+ 'plus"></i>'
			+ '<i class="more pop collapse" style="display: none;" id="panel'
			+ panelId
			+ 'minus"></i> '
			+ panelName.toUpperCase()
			+ '</h4>'
			+ '</div>'
			+ '<div class="card-body panel-body" style="display: none;"	hidden="true" id="panel'
			+ panelId + 'Div" >' + '</div>';
		
		if(mode !== 'view' && (userType.toLowerCase() !== 'mentor'
			&& userType.toLowerCase() !== 'trainingprincipal'))
		{
			panelReturn += '</div><div class = "remove-icon" onclick = "removePanel(\''
			+ panelId + '\',\'' + panelName
			+ '\')"><img src = "/html/images/close-02.svg" /> </div></div>';
		}
		
		return panelReturn;
	}
}
function togglePanels(panelId, panelType) {
	var panelMinus = getEID('panel' + panelId + 'minus');
	var panelPlus = getEID('panel' + panelId + 'plus');
	var panelDiv = getEID('panel' + panelId + 'Div');
	if (panelMinus.style.display === 'none') {
		debugger
		if (panelType === 'CompetenceType') {
			loadCompetenceData();
		} else if (panelType === 'CompetenceSubject') {
			loadCompetenceSubject(panelId);
		} else if (panelType === 'CompetenceQuestion') {
			loadCompetenceQuestions(panelId);
			
		}

		panelDiv.style.display = "block";
		panelPlus.style.display = "none";
		panelMinus.style.display = "block";
		
	} else {
		panelDiv.style.display = "none";
		panelPlus.style.display = "block";
		panelMinus.style.display = "none";
	}

}
function convertToAnotherFormatDate(inputDate) {
	var date1 = inputDate.split(" ");
	return (date1[0].split("-")[2] + "-" + date1[0].split("-")[1] + "-" + date1[0]
			.split("-")[0]);
}
function generateSelectedSubjectPanels(panelId) {
	if (competencyObj[panelId] !== undefined) {
		Object
				.keys(competencyObj[panelId])
				.forEach(
						function(subjects) {
							var panelDiv = getEID('panel' + panelId + 'Div');
							var newsubjectId = panelId + '_'
									+ subjectsById[subjects].subjectId;
							panelDiv.innerHTML += createPanel(
									subjectsById[subjects].subjectName,
									newsubjectId, 'CompetenceQuestion', true);
							var competenciesSubjects = subjectsByPanel[panelId];
							var found = competenciesSubjects
									.filter(function(i) {
										return i.subjectId === subjectsById[subjects].subjectId;
									})
							if (found.length > 0) {
								var idx = competenciesSubjects
										.indexOf(found[0]);
								competenciesSubjects.splice(idx, 1);
							}
						})
	}
}

function loadCompetenceSubject(panelId) {
	var panelDiv = getEID('panel' + panelId + 'Div');
	if (panelDiv.innerHTML === "") {
		var competenceSubjectData = {
			"formType" : "erpec",
			"competenceTypeId" : panelId
		}
		ajaxCallAPI('POST', 'competenceSubject', competenceSubjectData,
				function() {
					var competenciesSubjects = this.get("responseData");
					if (competenciesSubjects !== null
							&& competenciesSubjects !== undefined
							&& competenciesSubjects.error) {
						displayMessage('danger', competenciesSubjects.error,
								3000);
					} else {
						subjectsByPanel[panelId] = competenciesSubjects;
						panelDiv.innerHTML = createSearchBar(panelId);
						
						if(mode === 'view' || userType.toLowerCase() === 'mentor'
							|| userType.toLowerCase() === 'trainingprincipal')
						{
							disableCompetenceSubject();
						}
						
						competenciesSubjects.forEach(function(comp) {
							subjectsById[comp.subjectId] = comp;
						});
						console.log("subjects by id :: "
								+ JSON.stringify(subjectsById));
						if (formStorageId !== "0") {
							generateSelectedSubjectPanels(panelId);
						}
					}

				}, function() {

				});

	}
}
// load subjects while edit form
function loadCompetenceSubjectOnEdit(panelId) {
	var competenceSubjectData = {
		"formType" : "erpec",
		"competenceTypeId" : panelId
	}
	ajaxCallAPI('POST', 'competenceSubject', competenceSubjectData, function() {
		var competenciesSubjects = this.get("responseData");
		if (competenciesSubjects !== null && competenciesSubjects !== undefined
				&& !competenciesSubjects.error) {
			subjectsByPanel[panelId] = competenciesSubjects;
			competenciesSubjects.forEach(function(comp) {
				subjectsById[comp.subjectId] = comp;
			});
		}
	}, function() {

	});

}

function loadCompetenceQuestions(panelId) {
	var panelDiv = getEID('panel' + panelId + 'Div');
	var ids = panelId.split('_');
	if (panelDiv.innerHTML === "") {
		var competenceData = {
			"formType" : "erpec",
			"competenceTypeId" : ids[0],
			"competenceSubjectId" : ids[1],
			"candidateId" : candidateId
		}
		ajaxCallAPI('POST', 'competenceQuestions', competenceData, function() {
			var competencyQuestions = this.get("responseData");
			if (competencyQuestions !== null
					&& competencyQuestions !== undefined
					&& this.get("responseData").error) {
				displayMessageDivConstant('danger', data.error);
			} else {
				panelDiv.innerHTML = '<table id= "table' + panelId
						+ '" class="table-border"> </table>';
				createQuestionsHeader('table' + panelId, competencyQuestions);
				panelDiv.innerHTML += '<div class="remarks-div" id = "remark_'
						+ panelId + '"> </div>';
				createRemarks(panelId);
			}
		}, function() {

		});
	}
}
function createRemarks(panelId) {
	var storageId = formStorageId + "_" + panelId;
	var fdata = [ storageId ];
	var filters = {
		"contentJson.ReferenceId" : fdata
	}
	var farray = [ filters ];
	var remarksData = {
		"formType" : "invoiceremarks",
		"storageId" : storageId,
		"filters" : farray
	}
	var remarks = [];
	ajaxCallAPI(
			'POST',
			'fetchRemarks',
			remarksData,
			function() {
				if (this.get("responseData") !== undefined
						&& this.get("responseData") !== null
						&& this.get("responseData").error) {
					displayMessageDivConstant('danger', data.error);
				} else {
					if (this.get("responseData") !== "0") {
						remarks = this.get("responseData").content;
						remarks.sort(function(a, b) {
							return new Date(b.createdDate)
									- new Date(a.createdDate);
						});
					}
				}
				var remarksDiv = getEID('remark_' + panelId);
				if (panelId === "Nullify") {
					if (remarks.length > 0) {
						remarksDiv.innerHTML = '<div class="col-sm-12 border-bottom-gray"><div class="col-sm-2 remarks-tab">'
								+ '<h4 class="text-center">REMARKS</h4></div><div class="col-sm-10 counter text-right">'
								+ '<strong id="counter_'
								+ panelId
								+ '">'
								+ remarks.length
								+ '</strong> <span class="text-grey"> Remarks</span></div></div>';

						remarks.forEach(function(remObj) {
							remarksDiv.innerHTML += createRemarksdata(panelId,
									remObj);
						});
						remarksObj[panelId] = remarks;
					}
				} else {
					remarksDiv.innerHTML = '<div class="col-sm-12 border-bottom-gray"><div class="col-sm-2 remarks-tab">'
							+ '<h4 class="text-center">REMARKS</h4></div><div class="col-sm-10 counter text-right">'
							+ '<strong id="counter_'
							+ panelId
							+ '">'
							+ remarks.length
							+ '</strong> <span class="text-grey"> Remarks</span></div></div>';
					if (remarks.length <= 0) {
						remarksDiv.innerHTML += loadNodataRemarksDiv();
					} else {
						remarks.forEach(function(remObj) {
							remarksDiv.innerHTML += createRemarksdata(panelId,
									remObj);
						});
					}
					remarksObj[panelId] = remarks;
					remarksDiv.innerHTML += '<div style="padding:20px" class="remarks-comment"> <textarea type = "text" id="remark_input_'
							+ panelId
							+ '"+ class="remark-log" placeholder = "Log a remark..." style="width: 93%;" oninput="addRemarks(event,\''
							+ panelId
							+ '\')"></textarea><img src="/html/images/inactive.svg" id="inactive_'
							+ panelId
							+ '" class="inactive-icon"/><img src="/html/images/active.svg" id="remarks_active_'
							+ panelId
							+ '" class="inactive-icon" style="display:none" onclick="pushRemarks(\''
							+ panelId + '\')"/></div>'
				}
				
				if(mode === 'view')
				{
					disableRemarks();
				}

			}, function() {

			});

}
function loadRemarksData(panelId, remarks) {
	var remarksLog = getEID('remark_' + panelId);
	remarksLog.innerHTML = "";
	var remarksDiv = getEID('remark_' + panelId);
	remarksDiv.innerHTML = '<div class="col-sm-12 border-bottom-gray"><div class="col-sm-2 remarks-tab">'
			+ '<h4 class="text-center">REMARKS</h4></div><div class="col-sm-10 counter text-right">'
			+ '<strong id="counter_'
			+ panelId
			+ '">'
			+ remarks.length
			+ '</strong> <span class="text-grey"> Remarks</span></div></div>';
	remarks.forEach(function(remObj) {
		remarksDiv.innerHTML += createRemarksdata(panelId, remObj);
	});
	remarksObj[panelId] = remarks;
	if (panelId !== "Nullify") {
		remarksDiv.innerHTML += '<div style="padding:20px" class="remarks-comment"> <textarea type = "text" id="remark_input_'
				+ panelId
				+ '"+ class="remark-log" placeholder = "Log a remark..." style="width: 93%;" oninput="addRemarks(event,\''
				+ panelId
				+ '\')"></textarea><img src="/html/images/inactive.svg" id="inactive_'
				+ panelId
				+ '" class="inactive-icon"/><img src="/html/images/active.svg" id="remarks_active_'
				+ panelId
				+ '" class="inactive-icon" style="display:none" onclick="pushRemarks(\''
				+ panelId + '\')"/></div>'
	}
	if(mode === 'view')
	{
		disableRemarks();
	}
	

}
function addRemarks(event, panelId) {
	if (document.getElementById('remark_input_' + panelId).value !== "") {
		document.getElementById('inactive_' + panelId).style.display = "none";
		document.getElementById('remarks_active_' + panelId).style.display = "inline-flex";
	} else {
		document.getElementById('inactive_' + panelId).style.display = "inline-flex";
		document.getElementById('remarks_active_' + panelId).style.display = "none";
	}
}
function uuidv4() {
	return 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g, function(c) {
		var r = Math.random() * 16 | 0, v = c == 'x' ? r : (r & 0x3 | 0x8);
		return v.toString(16);
	});
}
function pushRemarks(panelId, remark) {
	var icode = new Date().getTime();
	var refID = formStorageId + "_" + panelId;
	if (formStorageId === "0" && panelId !== "Nullify") {
		refID = createModeFormStorageId + "_" + panelId;
	}
	var newRemark;
	if (panelId === "Nullify") {
		newRemark = remark;
	} else {
		newRemark = document.getElementById('remark_input_' + panelId).value;
	}
	var contentJson = {
		"InvoiceRemarkCode" : icode,
		"ReferenceId" : refID,
		"ApprovalStatus" : "pending",
		"RequestType" : "RPEC",
		"Remark" : newRemark,
		"UserName" : userName
	}
	var remark = {
		"invoiceRemarkCode" : icode,
		"referenceId" : refID,
		"approvalStatus" : "pending",
		"requestType" : "RPEC",
		"remark" : newRemark,
		"contentJson" : contentJson
	}
	remark.formType = "invoiceremarks";
	remark.formStorageId = "0";

	ajaxCallAPI('POST', 'addRemarks', remark, function() {
		var data = this.get("responseData");
		if (data.error) {
			// displayMessageDiv('danger', data.error, 3000);
		} else if (Object.keys(data).length === 0) {
			console.log("data : " + data);
		} else {
			if (panelId === "Nullify") {
				todaysNullifyRemark = {};
				olderNullifyRemarks = {}
			} else {
				todaysRemark = {};
				olderRemark = {};
			}
			remark.createdDate = new Date();
			remark.contentJson.UserName = userName;
			var tempRemarks = remarksObj[panelId] || [];
			tempRemarks.push(remark);
			tempRemarks.sort(function(a, b) {
				return new Date(b.createdDate) - new Date(a.createdDate);
			});
			loadRemarksData(panelId, tempRemarks);
			// createRemarks(panelId);
		}
		showLoading(false);
	}, function() {
		displayMessageDivConstant('danger',
				"Error in persisting dynamic form data.");
		showLoading(false);
	});
}
function pushNullifyRemarks(remark) {
	pushRemarks("Nullify", remark);
}
function createRemarksdata(panelId, remObj) {
	var remarksHeader = ' ';
	if (panelId === "Nullify") {
		remarksHeader = ' nullified this record';
	}
	return '<div class="remarks-data col-sm-12"><div class="col-sm-10"><div><h5 class="r-label">'
			+ displayRemarkLabel(remObj.createdDate, panelId)
			+ '</h5></div>'
			+ '<div class="col-sm-12 d-flex"><div class="col-sm-1 remarks-info"><img src="/html/images/note.svg"/></div>'
			+ '<div class="col-sm-10"><p class="r-header">'
			+ remObj.contentJson.UserName
			+ remarksHeader
			+ '</p><span class="r-data">'
			+ remObj.contentJson.Remark
			+ '</span></div> </div></div>'
			+ '<div class="col-sm-2 text-right text-grey"><span>'
			+ getRemarksDate(remObj.createdDate) + '</span></div></div>'
}
function getRemarksDate(createdDate) {
	var remarkDate = new Date(createdDate);
	var minutes = remarkDate.getMinutes();
	if (minutes < 10) {
		minutes = "0" + remarkDate.getMinutes();
	}

	if (isTodaysRemark(createdDate)) {
		return remarkDate.getHours() + ":" + minutes;
	} else {
		return remarkDate.getDate() + "/" + (remarkDate.getMonth() + 1) + "/"
				+ remarkDate.getFullYear() + " at " + remarkDate.getHours()
				+ ":" + minutes;
	}
}
function displayRemarkLabel(createdDate, panelId) {
	if (panelId === "Nullify") {
		if (isTodaysRemark(createdDate)
				&& todaysNullifyRemark[panelId] === undefined) {
			todaysNullifyRemark[panelId] = "";
			return "Today";
		} else if (!isTodaysRemark(createdDate)
				&& olderNullifyRemarks[panelId] === undefined) {
			olderNullifyRemarks[panelId] = "";
			return "Older";
		} else {
			return "";
		}
	} else {
		if (isTodaysRemark(createdDate) && todaysRemark[panelId] === undefined) {
			todaysRemark[panelId] = "";
			return "Today";
		} else if (!isTodaysRemark(createdDate)
				&& olderRemark[panelId] === undefined) {
			olderRemark[panelId] = "";
			return "Older";
		} else {
			return "";
		}
	}

}
function isTodaysRemark(createdDate) {
	var remarkDate = new Date(createdDate)
	if (remarkDate.getDate() === new Date().getDate()
			&& remarkDate.getMonth() === new Date().getMonth()
			&& remarkDate.getYear() === new Date().getYear()) {
		return true;
	}
	return false;
}
function loadNodataRemarksDiv() {
	return '<div><div class="text-center"><img src="/html/images/remarks.svg"></img></div><div class="no-remarks-label"><h3>No Remarks yet!</h3></div></div>';
}
function propogateSearchOptions(panelId) {
	var competenciesSubjects = subjectsByPanel[panelId];
	if (getEID('choices' + panelId).style.display === "none") {
		competenciesSubjects.forEach(function(sub) {
			getEID('choices' + panelId).innerHTML += createOptions(
					sub.subjectName, sub.subjectId, panelId);
		});
		getEID('choices' + panelId).style.display = "block";
		getEID('searchbar' + panelId).style.display = "block";
		getEID('selectButton' + panelId).classList.add("search-open");
		getEID('selectButton' + panelId).classList.remove("search-close");
	} else {
		getEID('choices' + panelId).innerHTML = "";
		getEID('searchbar' + panelId).innerHTML = "";
		getEID('choices' + panelId).style.display = "none";
		getEID('searchbar' + panelId).style.display = "none";
		getEID('selectButton' + panelId).classList.remove("search-open");
		getEID('selectButton' + panelId).classList.add("search-close");
	}
}
function propogateSearchResults(searchTerm, panelId) {
	var competenciesSubjects = subjectsByPanel[panelId];
	getEID('choices' + panelId).innerHTML = "";
	if (searchTerm !== undefined && searchTerm.length > 0) {
		searchTerm = searchTerm.toLowerCase();
		var filtered = competenciesSubjects.filter(function(i) {
			return i.subjectName.toLowerCase().includes(searchTerm);
		});
		filtered.forEach(function(sub) {
			getEID('choices' + panelId).innerHTML += createOptions(
					sub.subjectName, sub.subjectId, panelId);
		});
	} else {
		competenciesSubjects.forEach(function(sub) {
			getEID('choices' + panelId).innerHTML += createOptions(
					sub.subjectName, sub.subjectId, panelId);
		});
	}
}
function getEID(element) {
	return document.getElementById(element);
}
function createSearchBar(panelId) {

	var div;

	div = '<div class="choices form-group formio-choices" id="parentSearch'
			+ panelId
			+ '">'
			+ '<div class="form-control dropdown-container" tabindex="0" id="container'
			+ panelId + '">';
	if (userType.toLowerCase() === 'mentor'
			|| userType.toLowerCase() === 'trainingprincipal') {
		div += '<Button disabled="" class="col-sm-12 form-control select-button search-close text-grey not-allowed" lang="en" tabindex="-1" onclick="propogateSearchOptions(\'';
	} else {
		div += '<Button class="col-sm-12 form-control select-button search-close text-grey" lang="en" tabindex="-1" onclick="propogateSearchOptions(\'';
	}

	div += panelId
			+ '\')" id="selectButton'
			+ panelId
			+ '"'
			+ 'style="text-align: left; font-size: 18px">Choose a Competence</Button>'
			+ '<input type="text" placeholder="Type & Search..." style="display: none;background-color: #f5f7fb;" id="searchbar'
			+ panelId + '" oninput="propogateSearchResults(this.value , \''
			+ panelId + '\')">'
			+ '<div class="choices__list" style="display: none;" id="choices'
			+ panelId + '">' + '</div></div></div>';

	return div;
}
function createQuestionsHeader(tableId, competencyQuestions) {
	var table = getEID(tableId);
	table.innerHTML = '<thead id= "thead'
			+ tableId
			+ '"><tr id = "tr'
			+ tableId
			+ '" style="border-top: 1px solid #b1bed7;"><th class="first-td header-border">Statement Of Competence</th></tr></thead>';
	var proficiencies = competencyQuestions.proficiencyList;
	var tr = getEID('tr' + tableId);
	proficiencies.forEach(function(prof) {
		tr.innerHTML += createDynamicHeader(prof.levelValue);
	})
	tr.innerHTML += "<th style='border-left:1px solid #b1bed7' class='header-border'>Reset to Previous State</th>"
	createQuestionTable(tableId, competencyQuestions);
}
function createDynamicHeader(levelValue) {
	return '<th class="header-border">' + levelValue + '</th>';
}
function createQuestionTable(tableId, competencyQuestions) {

	var table = getEID(tableId);
	table.innerHTML += '<tbody id = "tbody' + tableId + '"></tbody>';
	var questions = competencyQuestions.question;
	var oldScore = "-1";
	var tbody = getEID('tbody' + tableId);
	questions
			.forEach(function(que) {
				debugger
				if (formStorageId !== "0") {
					var ids = tableId.split('table')[1].split('_');
					if (oldCompetencyObj[ids[0]] !== undefined
							&& oldCompetencyObj[ids[0]][ids[1]] !== undefined
							&& oldCompetencyObj[ids[0]][ids[1]][que.questionId] !== undefined) {
						oldScore = oldCompetencyObj[ids[0]][ids[1]][que.questionId].score;
					}
				}
				tbody.innerHTML += createTableRows(que.questionDesc,
						competencyQuestions, que.questionId, tableId);
				fillReviewProficienctTable(que.questionDesc,
						que.questionHistory, que.questionId, tableId);
				var temp = 0;
				Object.keys(que.questionHistory).forEach(function(key, value) {
					if (temp <= key && parseInt(key) !== reviewPeriodNumber) {
						temp = key;
					}
				})

				var ids = tableId.split('table')[1].split('_');
				var profmapping = {};
				competencyQuestions.proficiencyList.forEach(function(prof) {
					console.log(prof)
					profmapping[prof.levelValue] = prof.score;
				});

				if (parseInt(temp) !== 0
						&& competencyObj[ids[0]][ids[1]][que.questionId] === undefined) {

					// var profmapping = {};
					// competencyQuestions.proficiencyList.forEach(function(prof)
					// {
					// console.log(prof)
					// profmapping[prof.levelValue] = prof.score;
					// });

					var question = {
						'questionId' : que.questionId,
						'levelName' : que.questionHistory[temp],
						'score' : profmapping[que.questionHistory[temp]],
						'storageId' : uuidv4()
					}
					competencyObj[ids[0]][ids[1]][que.questionId] = question;

					if (oldCompetencyObj[ids[0]] == undefined) {
						oldCompetencyObj[ids[0]] = {};
						oldCompetencyObj[ids[0]][ids[1]] = {};
					}
					if (oldCompetencyObj[ids[0]][ids[1]] === undefined) {
						oldCompetencyObj[ids[0]][ids[1]] = {};
					}
					if (oldCompetencyObj[ids[0]][ids[1]][que.questionId] === undefined) {
						oldCompetencyObj[ids[0]][ids[1]][que.questionId] = question;
					}

				}

				console.log("new Competence Object :: "
						+ JSON.stringify(competencyObj));

				// if(oldScore === "-1" && temp !== 0)
				// {
				// oldScore = que.questionHistory[temp];
				// }

				var quetr = getEID('que_' + tableId + '_' + que.questionId);
				var proficiencies = competencyQuestions.proficiencyList;
				proficiencies
						.forEach(function(prof) {
							var isDisabled = false;
							if (parseInt(temp) !== 0) {
								if (profmapping[que.questionHistory[temp]] > parseInt(prof.score))
									isDisabled = true;
							}
							// if(rpecStatus !== "Draft" )
							// {
							// if (oldScore !== "-1" && (parseInt(oldScore) >
							// parseInt(prof.score)))
							// isDisabled = true;
							// }

							if (userType.toLowerCase() === 'mentor'
									|| userType.toLowerCase() === 'trainingprincipal'
									|| mode === 'view') {
								isDisabled = true;
							}

							quetr.innerHTML += createDynamicButtons(
									que.questionId, prof.levelValue,
									prof.score, tableId, isDisabled);
						})

				setTimeout(
						function() {
							debugger;
							if (formStorageId !== "0" || rpecStatus === "null") {
								var ids = tableId.split('table')[1].split('_');
								if (competencyObj[ids[0]] !== undefined
										&& competencyObj[ids[0]][ids[1]] !== undefined
										&& competencyObj[ids[0]][ids[1]][que.questionId] !== undefined) {
									var dynamicId = que.questionId
											+ '_'
											+ competencyObj[ids[0]][ids[1]][que.questionId].levelName
											+ '_'
											+ competencyObj[ids[0]][ids[1]][que.questionId].score;
									var radioButton = document
											.getElementById(dynamicId);
									if (radioButton !== undefined
											&& radioButton !== null) {
										radioButton.checked = true;
									}
								}
							}
						}, 200);
				var refreshId = tableId.split('table')[1].split('_')[0] + "_"
						+ tableId.split('table')[1].split('_')[1] + "_"
						+ que.questionId;
				quetr.innerHTML += '<td class="radio-baseline"><img class="pointer" src = "/html/images/refresh.svg" onclick="refreshProficiencyLevel(\''
						+ refreshId + '\')"/ ></td>';
			})
}
function refreshProficiencyLevel(tableId) {
	debugger;
	var ids = tableId.split('_');
	if (oldCompetencyObj[ids[0]] !== undefined
			&& oldCompetencyObj[ids[0]][ids[1]] !== undefined
			&& oldCompetencyObj[ids[0]][ids[1]][ids[2]]) {
		var questionData = oldCompetencyObj[ids[0]][ids[1]][ids[2]];
		var oldRadioID = ids[2] + '_' + questionData.levelName + '_'
				+ questionData.score;
		document.getElementById(oldRadioID).checked = true;
	}else
	{
		if(competencyObj[ids[0]][ids[1]][ids[2]] !== undefined)
		{
			var questionObj = competencyObj[ids[0]][ids[1]][ids[2]];
			var oldRadioID = questionObj.questionId + '_' + questionObj.levelName + '_' + questionObj.score;
			document.getElementById(oldRadioID).checked = false;
			delete competencyObj[ids[0]][ids[1]][ids[2]];
		}
	}
}
function createDynamicButtons(questionId, levelVal, score, tableId, isDisabled) {
	var ids = tableId.split('table')[1].split('_');
	var dynamicId = questionId + '_' + levelVal + '_' + score;
	if (!isDisabled) {
		return '<td class="form-group radio-baseline"><div class="form-check form-check-inline radio-inline"><label class="control-label form-check-label"><input name="button'
				+ questionId
				+ '" type="radio" class="form-check-input" lang="en" id="'
				+ dynamicId
				+ '" value="no" onchange = "selectQuestionsLevel(\''
				+ dynamicId
				+ '\' , \''
				+ ids[0]
				+ '\' , \''
				+ ids[1]
				+ '\')"><span></span></label></div></td>';
	} else {
		return '<td class="form-group radio-baseline"><div class="form-check form-check-inline radio-inline"><label class="control-label form-check-label not-allowed"><input name="button'
				+ questionId
				+ '" type="radio" class="form-check-input" lang="en" id="'
				+ dynamicId
				+ '" value="no" onchange = "selectQuestionsLevel(\''
				+ dynamicId
				+ '\' , \''
				+ ids[0]
				+ '\' , \''
				+ ids[1]
				+ '\')" disabled><span></span></label></div></td>';
	}
}
function createTableRows(questionDesc, competencyQuestions, questionId, tableId) {

	return '<tr id="que_'
			+ tableId
			+ '_'
			+ questionId
			+ '" class="table-border-bottom"><td class="first-td"><span>'
			+ questionDesc
			+ '</span><br/><br/><div class="d-flex"><div class="col-sm-3" id = "review_'
			+ tableId
			+ '_'
			+ questionId
			+ '"><h5 style="color: #0f349f;">Review</h5></div> <div class="col-sm-3"id = "proficiency_'
			+ tableId
			+ '_'
			+ questionId
			+ '"><h5 style="color: #0f349f;">Proficiency</h5></div></div><br/></td></tr>'

}

function fillReviewProficienctTable(questionDesc, questionHistory, questionId,
		tableId) {
	var reviewDiv = getEID('review_' + tableId + '_' + questionId);
	var proficienctDiv = getEID('proficiency_' + tableId + '_' + questionId);
	Object.keys(questionHistory).forEach(
			function(key, value) {
				reviewDiv.innerHTML += '<span>' + key + '</span></br>';
				proficienctDiv.innerHTML += '<span>' + questionHistory[key]
						+ '</span></br>';
				console.log("key :: " + key + "value " + questionHistory[key])
			})
}
function createOptions(subjectName, subjectId, panelId) {
	return '<div class="choices__item choices__item--choice choices__item--selectable is-highlighted" id= '
			+ subjectId
			+ ' onclick = "selectSubject(\''
			+ subjectName
			+ '\', \''
			+ panelId
			+ '\',\''
			+ subjectId
			+ '\')">'
			+ '<span>'
			+ subjectName + '</span></div>';
}
function selectQuestionsLevel(buttonId, competenceId, subjectId) {
	var questionsData = buttonId.split('_');
	var questions = {
		'questionId' : questionsData[0],
		'levelName' : questionsData[1],
		'score' : questionsData[2]
	}
	if (competencyObj[competenceId] == undefined) {
		competencyObj[competenceId] = {};
		competencyObj[competenceId][subjectId] = {};
	}
	if (competencyObj[competenceId][subjectId] === undefined) {
		competencyObj[competenceId][subjectId] = {};
	}
	if (competencyObj[competenceId][subjectId][questionsData[0]] != undefined
			&& competencyObj[competenceId][subjectId][questionsData[0]] !== null
			&& competencyObj[competenceId][subjectId][questionsData[0]].storageId !== undefined) {
		questions.storageId = competencyObj[competenceId][subjectId][questionsData[0]].storageId;
	} else {
		questions.storageId = uuidv4();
	}
	competencyObj[competenceId][subjectId][questionsData[0]] = questions;
	console.log("competetence object after selecting answers ::"
			+ JSON.stringify(competencyObj));
	saveRPECData("DRAFT", true);
}
function selectSubject(subjectName, panelId, subjectId) {
	getEID('selectButton' + panelId).classList.remove("text-grey");
	getEID('selectButton' + panelId).innerHTML = subjectName;
	getEID('choices' + panelId).innerHTML = "";
	getEID('choices' + panelId).style.display = "none";
	getEID('searchbar' + panelId).style.display = "none";
	getEID('selectButton' + panelId).classList.remove("search-open");
	getEID('selectButton' + panelId).classList.add("search-close");
	var panelDiv = getEID('panel' + panelId + 'Div');
	var subPanelDiv = getEID("panel" + panelId + '_' + subjectId + "parent")
	if (subPanelDiv !== null && subPanelDiv !== undefined) {
		toggleClass("panel" + panelId + '_' + subjectId + "parent", "d-flex",
				"d-none");
		// getEID("panel"+subjectId +"parent").style.display = "block";
	} else {
		var newsubjectId = panelId + '_' + subjectId;
		panelDiv.innerHTML += createPanel(subjectName, newsubjectId,
				'CompetenceQuestion', true);
		// competencyObj[panelId][subjectId] = {};
		// console.log("competence Object :: " + JSON.stringify(competencyObj));
	}
	var competenciesSubjects = subjectsByPanel[panelId];
	var found = competenciesSubjects.filter(function(i) {
		return i.subjectId === subjectId
	})
	if (found.length > 0) {
		var idx = competenciesSubjects.indexOf(found[0]);
		competenciesSubjects.splice(idx, 1);
	}
	debugger
	if (competencyObj[panelId] === undefined)
		competencyObj[panelId] = {};
	competencyObj[panelId][subjectId] = {};
	// propogateDropDownOptions(subjects , panelId);
}
function propogateDropDownOptions(subjectsArray, panelId) {
	getEID('choices' + panelId).innerHTML = "";
	subjectsArray.forEach(function(sub) {
		getEID('choices' + panelId).innerHTML += createOptions(sub.subjectName,
				sub.subjectId, panelId);
	});
}
window.onresize = function() {
	setImpInfoWidth();
}
function removePanel(panelId, panelName) {
	var ids = panelId.split('_');
	// var panel = getEID('panel' + panelId + 'parent');
	// var searchId = panel.parentNode.childNodes[0].id;
	// var searchBarID = searchId.substr(12);
	getEID('selectButton' + ids[0]).classList.add("text-grey");
	getEID('selectButton' + ids[0]).innerHTML = "Choose a Competence";
	toggleClass('panel' + panelId + 'parent', 'd-none', 'd-flex');
	var competenciesSubjects = subjectsByPanel[ids[0]];
	var found = competenciesSubjects.filter(function(i) {
		return i.subjectId === ids[1]
	})
	if (found.length === 0) {
		var sub = {
			subjectId : ids[1] + '',
			subjectName : panelName
		}
		competenciesSubjects.push(sub);
	}
	delete competencyObj[(ids[0])][(ids[1])];
	if (Object.keys(competencyObj[(ids[0])]).length === 0) {
		delete competencyObj[(ids[0])];
	}
	console.log("competence Object :: " + JSON.stringify(competencyObj));

	saveRPECData("DRAFT", true);
}
setImpInfoWidth()

function toggleClass(id, addClasses, removeClasses) {
	var el = getEID(id);
	el.classList.remove(removeClasses);
	el.classList.add(addClasses);
}

function validateUpdateStatus(status)
{
	var isRemarksSave = isRemarksRemain();
	if(isRemarksSave){
		updateStatus(status)
	}else
	{
		openSuccessPopup("#remarks-fails", "#remarks-fails-box", status);
	}
}

function updateStatus(status) {

	debugger;
	showLoading(true);
	if (userType.toLowerCase() == "mentor" && status == "Approved") {
		status = "Approved";
	}

	var contentJson = {
		"status" : status,
		"userType" : userType,
		"statusUpdateBy" : loggedInUser,
		"modifiedByName" : userName,
		"trainingPrincipalId" : trainingPrincipalId,
		"mentorId" : mentorId
	}
	var statusData = {
		"contentJson" : contentJson,
		"storageId" : formStorageId,
		"formType" : "erpec",
	}

	ajaxCallAPI('POST', 'updateStatus', statusData, function() {
		showLoading(false);
		if (this.get("responseData") !== undefined
				&& this.get("responseData") !== null) {
			if (this.get("responseData").checkErrorFlag) {
				displayMessageDivConstant('danger',
						this.get("responseData").message, 3000);
			} else {
				if (status !== "Nullified") {

					if (status === 'Pending Sign Off') {
						openSuccessPopup("#success-Submit-for-final-sign-off",
								"#success-Submit-for-final-sign-off-box", "");
					} else if (status === "Approved" && (userType.toLowerCase() == "mentor" || userType.toLowerCase() == "relcuser")) {
						openSuccessPopup("#success-review-approved",
								"#success-review-approved-box", "");
					} else if (status === "Rejected") {
						openSuccessPopup("#success-review-rejected",
								"#success-review-rejected-box", "");
					} else {
						openSuccessPopup("#success-status-update",
								"#success-status-update-box", "");
					}
				}
			}
		}

	}, function() {
		showLoading(false);
	});
}
function onCancel() {
	// window.history.back();
	window.location.href = "/workspace";
}

function onBackToSummary() {
	 window.history.back();
	//window.location.href = "/workspace";
}
function showPopUpNullify() {
	openSuccessPopup("#nullify-confirm", "#nullify-confirm-box", "");
}
function nullifyThisRecordWithRemarks(remark) {
	updateStatus("Nullified");
	pushRemarks("Nullify", remark);
}
function openSuccessPopup(boundingBox, contentBox, Status) {
	AUI()
			.use(
					'aui-base',
					function(A) {
						// var boundingBox = "#success-submit";
						// var contentBox = "#success-submit-box";
						A.one(boundingBox).set('hidden', false);
						YUI()
								.use(
										'aui-modal',
										function(Y) {
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
											document.getElementById(contentBox
													.substring(1)).childNodes[0].childNodes[0].childNodes[0].style.display = 'none';

											Y.one('.popup-back-to-record-submit').on('click', function() {
//														window.history.back();
														window.location.href = baseUrl;
														modal.hide();
													});
											Y.one('.popup-back-to-record-status').on('click', function() {
//														window.history.back();
														window.location.href = baseUrl;
														modal.hide();
													});
											Y.one('.popup-back-to-record-submit-review-reject').on('click', function() {
//														window.history.back();
													window.location.href = baseUrl;
														modal.hide();
													});
											Y.one('.popup-back-to-record-submit-review').on('click', function() {
//														window.history.back();
														window.location.href = baseUrl;
														modal.hide();
													});
											Y.one('.popup-back-to-record-sign-off').on('click', function() {
														debugger;
//														window.history.back();
														window.location.href = baseUrl;
														modal.hide();
													});
											Y.one('.popup-back-to-home-submit').on('click',function() {
														window.location.href = dashBoardLink;
														modal.hide();
													});
											Y.one('.popup-back-to-home-status').on('click',function() {
														window.location.href = dashBoardLink;
														modal.hide();
													});
											Y.one('.popup-back-to-home-submit-review').on('click',function() {
														window.location.href = dashBoardLink;
														modal.hide();
													});
											Y.one('.popup-back-to-home-submit-review-reject').on('click',function() {
														window.location.href = dashBoardLink;
														modal.hide();
													});
											Y.one('.popup-back-to-home-sign-off').on('click',function() {
														window.location.href = dashBoardLink;
														modal.hide();
													});
											Y.one('.popup-confirm-nullify').on('click',function() {
														var remark = getEID("nullifyreason").value;
														nullifyThisRecordWithRemarks(remark);
														modal.hide();
													});
											Y.one('.popup-cancel-nullify').on('click', function() {
														modal.hide();
													});
											Y.one('.popup-ok').on('click',function() {
														modal.hide();
													});
											Y.one('.popup-remarks-yes').on('click',function() {
												modal.hide();
												if (Status === 'Pending Sign Off') {
													updateStatus(Status);
												} else if (Status === "Approved") {
													updateStatus(Status);
												} else if (Status === "Rejected") {
													updateStatus(Status);
												} else {
													saveRPECData(Status, false);
												}
											});
											Y.one('.popup-remarks-no').on('click',function() {
												modal.hide();
											});
									
											

										});

					});
}

function disableForView()
{
	getEID("dateFrom").disabled = true;
	getEID("dateTo").disabled = true;
	getEID("practicalExp").disabled = true;
}

function disableCompetenceSubject()
{
	document.querySelectorAll('[id^="selectButton"]').forEach(function(node){
		if(node.id !== undefined)
		{
			getEID(node.id).disabled = true;
		}
	});
}

function isRemarksRemain()
{
	var remarksNodeList = document.querySelectorAll('[id^="remarks_active_"]');
	var isRemarkSave = true;
	if(remarksNodeList !== undefined)
	{
		for(var i = 0 ; i < remarksNodeList.length ; i++)
		{
			if(document.querySelectorAll('[id^="remarks_active_"]')[i].style.display === 'none')
			{
				isRemarkSave = true;
			}
			else
			{
				isRemarkSave = false;
				break;
			}
		}
	}
	
	return isRemarkSave;
}


function disableRemarks()
{
	document.querySelectorAll('[id^="remark_input_"]').forEach(function(node){
		if(node.id !== undefined)
		{
			getEID(node.id).disabled = true;
		}
	});
}