var subScheduleList = [];
var subjectProgrammeList = [];
var sessionsList = [];
var HolidayList = [];
var actStatus = "Active";
var modelName = "Schedule";
var buttonstatus;
// displayMessage('danger', data.error,3000);
function SubSchedule(SubScheduleID, Name, Subject, FDate, TDate, FTime, TTime,
		SubStatus, visible) {
	this.SubScheduleID = SubScheduleID;
	this.Subject = Subject;
	this.Name = Subject
	this.FDate = FDate;
	this.TDate = TDate;
	this.FTime = FTime;
	this.TTime = TTime;
	this.SubStatus = SubStatus;
	this.Visible = visible;
}
function drawTable() {
	var count = 0;
	var i;
	var scheduleCategory = getEID(namespace + "scheduleCategory");
	while (subSheduleHolder.hasChildNodes()) {
		subSheduleHolder.removeChild(subSheduleHolder.lastChild);
	}
	for (i = 0; i < subScheduleList.length; i++) {
		var node = sheduleBase.cloneNode(true);

		var subID = node.getElementsByClassName("subScheduleID")[0];
		var SubStatus = node.getElementsByClassName("SubStatus")[0];
		var Visible = node.getElementsByClassName("Visible")[0];
		var header = node.getElementsByClassName("header")[0]
				.getElementsByTagName("div")[0];
		var startDate = node.getElementsByClassName("subStartDate")[0];
		var endDate = node.getElementsByClassName("subEndDate")[0];
		var startTime = node.getElementsByClassName("startTime")[0];
		var endTime = node.getElementsByClassName("endTime")[0];
		var subjectProgramme = node.getElementsByClassName("subjectProgramme")[0];
		var subSheduleContent = node
				.getElementsByClassName("subSheduleContent")[0];
		var expandCollapse = node.getElementsByClassName("expandCollapse")[0];
;
		subID.innerHTML = subScheduleList[i].SubScheduleID;
		SubStatus.innerHTML = subScheduleList[i].SubStatus;
		Visible.innerHTML = subScheduleList[i].Visible;
		startDate.value = subScheduleList[i].FDate;
		endDate.value = subScheduleList[i].TDate;
		startTime.value = subScheduleList[i].FTime;
		endTime.value = subScheduleList[i].TTime;
		subjectProgramme.value = subScheduleList[i].Subject;
		if (subScheduleList[i].Visible == "hide") {
			subSheduleContent.style.display = "none";
			expandCollapse.className = expandCollapse.className.replace(
					/\bminusIcon\b/g, "addIcon");
		} else {
			subSheduleContent.style.display = "block";
			expandCollapse.className = expandCollapse.className.replace(
					/\baddIcon\b/g, "minusIcon");
		}

		if (subScheduleList[i].SubStatus != "Remove") {
			count = count + 1;
			header.innerText = count + " Sub-Schedule";
			node.style.display = "block";
		} else {
			node.style.display = "none";
		}
		subSheduleHolder.appendChild(node);

	}

}

function addAllDataToArray() {
	while (subScheduleList.length > 0) {
		subScheduleList.pop();
	}
	var c = subSheduleHolder.childElementCount;
	for (var i = 0; i < c; i++) {
		var node = subSheduleHolder.childNodes[i];
		if (node.getElementsByClassName("SubStatus")[0].innerHTML != "Remove") {
			//Visible
			var subID = node.getElementsByClassName("subScheduleID")[0];

			//var selectedText = skillsSelect.options[skillsSelect.selectedIndex].text;
			var subjectProgramme = node
					.getElementsByClassName("subjectProgramme")[0];
			var name = "";
			if (subjectProgramme.value.length > 0) {
				name = subjectProgramme.options[subjectProgramme.selectedIndex].text;
			}
			var startDate = node.getElementsByClassName("subStartDate")[0];
			var endDate = node.getElementsByClassName("subEndDate")[0];
			var startTime = node.getElementsByClassName("startTime")[0];
			var endTime = node.getElementsByClassName("endTime")[0];
			var visible = node.getElementsByClassName("Visible")[0];

			var ss = new SubSchedule(subID.innerHTML, name,
					subjectProgramme.value, startDate.value, endDate.value,
					startTime.value, endTime.value, SubStatus.innerHTML,
					visible.innerHTML);
			subScheduleList.push(ss);
		}

	}

}
var hasClassAddSubFacility = false;
function AddSubSchedule() {
	if (!hasClassAddSubFacility) {
		var element = document.getElementsByClassName("addSubFacilityBtn")[0];
		element.classList.add("posChange");
		hasClassAddSubFacility = true;
	}

	addAllDataToArray()
	var ss = new SubSchedule("", "", "", "", "", "", "", "", "");
	subScheduleList.push(ss);
	drawTable()
}
var parentt;
var elemm;
function RemoveSubSchedule(e) {
	parentt = findAncestor(e, "sheduleContainer");
	parentt.getElementsByClassName("SubStatus")[0].innerHTML = "Remove";
	addAllDataToArray();
	drawTable();
}

function CopySubSchedule(e) {
	var cpy = e.parentElement.parentElement.parentElement.parentElement
	var node = cpy.cloneNode(true);
	node.getElementsByClassName("SubStatus")[0].innerHTML = "Active";
	node.getElementsByClassName("subScheduleID")[0].innerHTML = "";

	subSheduleHolder.appendChild(node);
	addAllDataToArray();
	drawTable();
}

function ShowHideDiv() {

	if (getEID(namespace + 'radio1').checked) {
		getEID('repeat_period').style.display = 'block';
	}
	if (getEID(namespace + 'radio2').checked) {
		getEID('repeat_period').style.display = 'none';
	}

}

function run() {
	var e = getEID(namespace + "drp_value");
	if (e != null && e.options[e.selectedIndex] != null) {
		var selectedOp = e.options[e.selectedIndex].text;
		var date = getEID(namespace + "endOn").value;
		var months = [ "January", "February", "March", "April", "May", "June",
				"July", "August", "September", "October", "November",
				"December" ];
		var dateArr = date.split("/");
		var month = months[dateArr[1]];
		var dateofMonth = getEID(namespace + "dayOfMonth").value;
		var dateofWeek = getEID(namespace + "dayOfWeek").value;
		var messageText = "";

		var repeatEvery = getEID(namespace + "repeatEvery");
		if (selectedOp == "Daily") {
			getEID(namespace + 'daily').style.display = 'block';
			getEID('weekly').style.display = 'none';
			getEID(namespace + 'monthly').style.display = 'none';
			messageText = "Repeats every Daily, until" + " " + date;
		} else if (selectedOp == "Weekly") {
			getEID(namespace + 'monthly').style.display = 'none';
			getEID(namespace + 'monthly').style.display = 'none';
			getEID('weekly').style.display = 'block';
			getEID(namespace + 'daily').style.display = 'block';
			messageText = "Repeats every " + repeatEvery.value + " Weeks on "
					+ dateofWeek + ", until" + " " + date;
		} else if (selectedOp == "Monthly") {
			getEID(namespace + 'monthly').style.display = 'block';
			getEID('weekly').style.display = 'none';
			getEID(namespace + 'daily').style.display = 'block';
			messageText = "Repeats every " + repeatEvery.value + " Month on "
					+ dateofMonth + " " + dateofWeek + ", until " + " " + date;
		} else if (selectedOp == "Yearly") {
			getEID(namespace + 'monthly').style.display = 'block';
			getEID('weekly').style.display = 'none';
			getEID(namespace + 'daily').style.display = 'block';
			messageText = "Repeats every " + repeatEvery.value
					+ " Year on the " + dateofMonth + " " + dateofWeek + " of "
					+ month + ", until " + " " + date;
		}  else if (selectedOp != "") {
			getEID(namespace + 'monthly').style.display = 'block';
			getEID('monthly').style.display = 'block';
			getEID('weekly').style.display = 'none';
			getEID(namespace + 'daily').style.display = 'block';
		}

		if (date != "" && getEID(namespace + "radio15").checked) {
			getEID("text_changed").innerHTML = messageText;
		} else {
			getEID("text_changed").innerHTML = "";
		}

	}

}

function GenerateSubjectCode() {
	var scheduleCategory = getEID(namespace + "scheduleCategory");
	if(scheduleCategory.value.length>0){
		var scheduleStatus = getEID(namespace + "scheduleStatus");
		var scheduleCode = getEID(namespace + "scheduleCode");
		var minBeforeScheduleStart = getEID(namespace + "minBeforeScheduleStart");
		var minAfterScheduleEnd = getEID(namespace + "minAfterScheduleEnd");
		minBeforeScheduleStart.style.display = "block";
		minAfterScheduleEnd.style.display = "block";
		scheduleStatus.value = "Pending"
		var exmCode = "UOL";
		var subCode = "";
		if (scheduleCategory.value == "Briefing") {
			getEID(namespace + "briefing_reporting").style.display = 'block';
		} else {
			getEID(namespace + "briefing_reporting").style.display = 'none';
		}
		if (scheduleCategory.value == ""
				|| scheduleCategory.value == "Please select category") {
			getEID(namespace + "briefing_reporting").style.display = 'none';
		} else {
			var e = document.getElementById(namespace + 'scheduleCategory');
			var r = e.parentElement.parentElement;
			r.children[2].classList.add('hide');
		}
		if (scheduleCategory.value == "Programme") {
			subCode = exmCode + ":" + new Date().getFullYear()
			scheduleStatus.value = "Confirmed"
			getEID(namespace + "startTime").value = "12:00";
//			getEID(namespace + "startTime").disabled = true;
//			getEID(namespace + "endTime").value = "23:59";
//			getEID(namespace + "endTime").disabled = true;
		} else if (scheduleCategory.value == "Subject") {
			subCode = exmCode + "/" + new Date().toLocaleDateString("en-US");
		} else if (scheduleCategory.value == "Briefing") {
			minBeforeScheduleStart.style.display = "";
			minAfterScheduleEnd.style.display = "";
		}
	}else{
		var e = document.getElementById(namespace + 'scheduleCategory');
		var r = e.parentElement.parentElement;
		r.children[2].classList.add('hide');
	}
	
	if (mode == "copy") {
		subCode = "Copy-of-" + subCode;
	}else if (mode != "edit"||mode != "view") {
		//scheduleCode.value = subCode;
	}

	
	if(scheduleCategory.value.length>0){
		loadScheduleCategoryData();
	}
}

function validateFields(e) {
	buttonname = e.name;
	addAllDataToArray()
	if (checkIsValide()) {
		ValidateUniqueIDAndSubmit();
	}

}

function ValidateUniqueIDAndSubmit() {
	if (mode == "copy"
			|| mode == "create"
			|| (mode == "edit" && formStorageId != document
					.getElementById(namespace + "scheduleCode").value)) {
		var dataV = {
			"limit" : 4,
			"modelName" : "schedule",
			"page" : 0,
			"formType" : "schedule"
		};
		dataV.conditions = [ "contentJson.ScheduleCode="
				+ getEID(namespace + "scheduleCode").value ];
		dataV.sortBy = "contentJson.ScheduleCode";
		ajaxCallAPI('GET', 'searchList', dataV, function() {

			var response = this.get("responseData");
			if (_.isEmpty(response)) {
				console.log("error");

			} else {
				if (response.numberOfElements > 0) {
					displayMessage('danger', "Duplicate Schedule Code", 3000);

				} else {
					submitSchedule();
				}
			}
		}, function() {

		});
	} else {
		submitSchedule();
	}
}
function getEID(element) {
	return document.getElementById(element);
}
var saveDraft = false;
function saveDraftFields() {
	var scheduleCode = getEID(namespace + "scheduleCode");
	if(scheduleCode.value.length>0){
		addAllDataToArray();
		saveDraft = true;
		if (checkIsValide()) {
			ValidateUniqueIDAndSubmit();
		}
	}else{
		selected_1 = unhide("scheduleCode");
		displayMessage('danger', "Schedule Code is required", 3000);
	}
	
}

function unhide(id) {
	var e = document.getElementById(namespace + id);
	var r = e.parentElement.parentElement;
	r.children[2].classList.remove('hide');
	return 0
}
function hide(id) {
	var e = document.getElementById(namespace + id);
	var r = e.parentElement.parentElement;
	r.children[2].classList.add('hide');
	return 1
}

function submitSchedule() {
	var scheduleStatus = getEID(namespace + "scheduleStatus");
	var scheduleCategory = getEID(namespace + "scheduleCategory");
	var scheduleSubCategory = getEID(namespace + "scheduleSubCategory");
	var scheduleCode = getEID(namespace + "scheduleCode");
	var scheduleName = getEID(namespace + "scheduleName");
	var endDate = getEID(namespace + "endDate");
	var startDate = getEID(namespace + "startDate");
	var sessionType = getEID(namespace + "sessionType");
	var startTime = getEID(namespace + "startTime");
	var endTime = getEID(namespace + "endTime");
	var minBeforeScheduleStart = getEID(namespace + "minBeforeScheduleStart");
	var minAfterScheduleEnd = getEID(namespace + "minAfterScheduleEnd");
	var RepeatRadio1 = getEID(namespace + "radio1");
	var ovwelapRadio3 = getEID(namespace + "radio3");
	var ovwelapRadio4 = getEID(namespace + "radio4");
	var ovwelapRadio5 = getEID(namespace + "radio5");

	var repeatOnRadio1 = getEID(namespace + "repeaton1");
	var repeatOnRadio2 = getEID(namespace + "repeaton2");

	var endsNeverRadio = getEID(namespace + "radio13");
	var endsAfterRadio = getEID(namespace + "radio14");
	var endsOnRadio = getEID(namespace + "radio15");
	var occurence = getEID(namespace + "occurence");
	var endOn = getEID(namespace + "endOn");

	var RepeatPeriod = getEID(namespace + "drp_value");
	var repeatEvery = getEID(namespace + "repeatEvery");

	var week_value;
	// getting week type value
	if (getEID(namespace + 'm').checked) {
		week_value = getEID(namespace + 'm').value;
	}
	if (getEID(namespace + 't').checked) {
		week_value = getEID(namespace + 't').value;
	}
	if (getEID(namespace + 'w').checked) {
		week_value = getEID(namespace + 'w').value;
	}
	if (getEID(namespace + 'th').checked) {
		week_value = getEID(namespace + 'th').value;
	}
	if (getEID(namespace + 'f').checked) {
		week_value = getEID(namespace + 'f').value;
	}
	if (getEID(namespace + 'sat').checked) {
		week_value = getEID(namespace + 'sat').value;
	}
	if (getEID(namespace + 'sun').checked) {
		week_value = getEID(namespace + 'sun').value;
	}

	var schedule = {};
	schedule.ScheduleStatus = scheduleStatus.value;
	schedule.Category = scheduleCategory.value;
	schedule.SubCategory = scheduleSubCategory.value;
	schedule.ScheduleCode = scheduleCode.value;

	schedule.formType = modelName;

	schedule.SubScheduleCount = subScheduleList.length;
	schedule.SubScheduleList = subScheduleList;
	if (RepeatRadio1.checked) {
		schedule.RepeatPeriod = RepeatPeriod.value;
		schedule.RepeatEvery = repeatEvery.value;
	} else {
		schedule.RepeatPeriod = "";
		schedule.RepeatEvery = "0";
	}

	schedule.MinBeforeScheduleStart = minBeforeScheduleStart.value;
	schedule.MinAfterScheduleEnd = minAfterScheduleEnd.value;
	schedule.WeekValue = week_value;
	schedule.Name = scheduleName.value;
	schedule.StartDate = startDate.value;
	schedule.ModelName = modelName;
	schedule.EndDate = endDate.value;
	schedule.SessionType = sessionType.value;
	schedule.StartTime = startTime.value;
	schedule.EndTime = endTime.value;
	schedule.RepeatSchedule = RepeatRadio1.checked;
	schedule.DayOfMonth = getEID(namespace + 'dayOfMonth').value;
	schedule.DayOfWeek = getEID(namespace + 'dayOfWeek').value;
	var validdata = false;
	if (ovwelapRadio3.checked) {
		schedule.OverLap = "Yes";
	} else if (ovwelapRadio4.checked) {
		schedule.OverLap = "No";
	} else if (ovwelapRadio5.checked) {
		schedule.OverLap = "Not Applicable";
	}
	if (repeatOnRadio1.checked) {
		schedule.RepeatOn = "DayOfMonth";
	} else if (repeatOnRadio2.checked) {
		schedule.RepeatOn = "DayOfWeek";
	}
	if (repeatOnRadio1.checked) {
		schedule.RepeatOn = "DayOfMonth";
	} else if (repeatOnRadio2.checked) {
		schedule.RepeatOn = "DayOfWeek";
	}

	if (endsNeverRadio.checked) {
		schedule.Ends = "Never";
	} else if (endsAfterRadio.checked) {
		schedule.Ends = "After";
		schedule.Occurence = occurence.value;
	} else if (endsOnRadio.checked) {
		schedule.Ends = "On";
		schedule.Occurence = endOn.value;
	}
	if (mode == "copy" || mode == "create") {
		formStorageId = "";
	}

	if (saveDraft) {
		modelStatus = "Draft";
	} else {
		modelStatus = actStatus;
	}
	if (mode == 'edit' && actStatus == "Draft") {
		modelStatus = "Active";
	}
	schedule.Status = modelStatus;
	schedule.formStorageId = formStorageId;
	//

	console.log("Schedule=>" + JSON.stringify(schedule));

	if (validdata == false) {
		ajaxCallAPI('POST', 'persist', schedule, function() {
			var data = this.get("responseData");
			if (data.error) {
				displayMessage('danger', data.error);
			} else {
				//window.location = baseUrl;
				//submitSubSchedule();
				if (data.contentJson.Status == "Draft") {
					submitDraftConfirmation();

				}/*else if(buttonname == "active" ) {
										 activatiionsucess();						 
									}else if(buttonname == "deactive"){
										deactivationsucess();
				 *///}
				else if (data.contentJson.Status == "Active"
						|| data.contentJson.Status == "Inactive") {
					if (buttonname == 'reactive' || buttonname == 'active'
							|| buttonname == "deactive") {

					} else {
						submitFormConfirmation();
					}
				}

			}
		}, function() {
			displayMessage('danger', "Error in persisting dynamic form data.");
		});
	} else {
		displayMessage('danger', "Error in persisting dynamic form data.");

	}
}

var subSdulPst = 0
function submitSubSchedule() {
	if (subSdulPst < subScheduleList.length) {
		var sub = subScheduleList[subSdulPst];
		sub.ModelName = "subschedule";
		sub.formType = "subschedule";
		sub.Status = "Active";
		sub.ScheduleStorageID = formStorageId;
		if (mode == "copy" || mode == "create") {
			sub.SubScheduleID = formStorageId + "_" + new Date().getTime();
		} else if (mode == "edit") {

			if (sub.SubScheduleID == null
					|| typeof sub.SubScheduleID == 'undefined'
					|| sub.SubScheduleID.length == 0) {

				sub.SubScheduleID = formStorageId + "_" + new Date().getTime();
			} else {
				sub.formStorageId = sub.SubScheduleID
			}
		}
		ajaxCallAPI('POST', 'persist', sub, function() {
			var data = this.get("responseData");
			if (data.error) {
				displayMessage('danger', data.error);
			} else {
				displayMessage('danger', data);
			}
			subSdulPst = subSdulPst + 1;
			submitSubSchedule();
		}, function() {
			displayMessage('danger', "Error in persisting dynamic form data.");
		});
	} else {
		displayMessage('success', 'Form successfully submitted.', 3000);
		//  window.location = baseUrl;

	}
}

function loadDropdownList(strSubURI, elementDrpDwn) {
	var ajaxUrl = vocabularyURL.replace("$VCNAME", strSubURI);

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
													var responseData = this.get('responseData');
													var opt = new Option( "",
															"");
													elementDrpDwn.options[elementDrpDwn.options.length] = opt;
													for (var i = 0; i < responseData.length; i++) {
														var opt = new Option( responseData[i].name,
																responseData[i].name);
														elementDrpDwn.options[elementDrpDwn.options.length] = opt;
													}
//													if (mode == "create" && strSubURI == "Schedule%20Status"){
//														document.getElementById(namespace + "scheduleStatus").value = "Confirmed";
//													}
												},
												failure : function() {
													console
															.log("Error in the ajax call.");
												}
											}
										});
					});

}

// /Schedule%20Sub-Category
var data, contentdata;
function fetchDetails(formStorageId) {
	if (formStorageId != "") {
		data = {};

		data.formStorageId = formStorageId;
		data.formType = "schedule";
		ajaxCallAPI(
				'GET',
				"loadData",
				data,
				function() {
					data = this.get("responseData");
					contentdata = this.get("responseData");
					if (data.error) {
						displayMessage('danger', data.error);
					} else {
						var sc = contentdata.contentJson.ScheduleCode;
						if (mode == "copy") {
							sc = "Copy-of-" + sc;
						}
						actStatus = contentdata.contentJson.Status;
						getEID(namespace + "scheduleCode").value = sc;
						getEID(namespace + "scheduleCode").disabled = (mode != "copy");
						if (mode == "view") {
							getEID("formStatus").classList
									.remove("view_holder");
						}
						getEID("formStatus").classList.add("form_"
								+ actStatus.toLowerCase());
						buttonstatus = contentdata.contentJson.Status;
						getEID("formStatus").innerHTML = actStatus;
						if (mode == "view" && buttonstatus == "Active") {
							document.getElementById('deactive')
									.removeAttribute('disabled');
						}
						if (mode == "view" && buttonstatus == "Inactive") {
							document.getElementById('deactive').style.display = "none";
							document.getElementById('reactive')
									.removeAttribute('disabled');
							document.getElementById('reactive')
									.removeAttribute('style')
						}
						if (mode == "edit" && buttonstatus == "Draft") {
							document.getElementById('deactive').style.display = "none";
							document.getElementById('saveDraft').style.display = "inline-block";
							document.getElementById('save').innerHTML="PUBLISH";
							document.getElementById('clear').style.display = "none";

						}else if(mode == "edit"){
							document.getElementById('clear').style.display = "none";
							document.getElementById('saveDraft').style.display = "none";
						}
						if (contentdata.contentJson.Category == "Briefing") {
							document.getElementById(namespace
									+ 'briefing_reporting').style.display = "block";
						} else {
							document.getElementById(namespace
									+ 'briefing_reporting').style.display = "none";
						}
						getEID(namespace + "scheduleName").value = contentdata.contentJson.Name;
						getEID(namespace + "scheduleName").disabled = (mode != "copy");
						getEID(namespace + "startDate").value = dbDateToUserDateConverter(contentdata.contentJson.StartDate);
						getEID(namespace + "endDate").value = dbDateToUserDateConverter(contentdata.contentJson.EndDate);

						getEID(namespace + "startTime").value = contentdata.contentJson.StartTime;
						getEID(namespace + "endTime").value = contentdata.contentJson.EndTime;
						getEID(namespace + "scheduleStatus").value = contentdata.contentJson.ScheduleStatus;
						getEID(namespace + "scheduleCategory").value = contentdata.contentJson.Category;
						getEID(namespace + "scheduleSubCategory").value = contentdata.contentJson.SubCategory;
						getEID(namespace + "sessionType").value = contentdata.contentJson.SessionType;
						buttonstatus = contentdata.contentJson.Status;
						getEID(namespace + "minBeforeScheduleStart").value = contentdata.contentJson.MinBeforeScheduleStart;
						getEID(namespace + "minAfterScheduleEnd").value = contentdata.contentJson.MinAfterScheduleEnd;
						if (new Date() >= stringToDate(
								getEID(namespace + "startDate").value,
								"dd/MM/yyyy", "/")) {
							getEID(namespace + "startDate").disabled = (mode != "copy");
							getEID(namespace + "endDate").disabled = (mode != "copy");
						}
						if (contentdata.contentJson.repeat) {
							getEID(namespace + "radio1").checked = true;
							getEID("repeat_period").style.display = "";
							if (contentdata.contentJson.WeekValue.length > 0)
								var wv = contentdata.contentJson.weekValue;
							getEID(namespace + wv.toLowerCase()).checked = true;
							getEID(namespace + "drp_value").value = contentdata.contentJson.RepeatPeriod;
							getEID(namespace + "repeatEvery").value = contentdata.contentJson.RepeatEvery;
							if (contentdata.contentJson.Ends == "On") {
								getEID(namespace + "endOn").value = contentdata.contentJson.Occurence;
								getEID(namespace + "radio15").checked = true;
							} else if (contentdata.contentJson.Ends == "After") {
								getEID(namespace + "occurence").value = contentdata.contentJson.Occurence;
								getEID(namespace + "radio14").checked = true;
							} else {
								getEID(namespace + "radio13").checked = true;
							}

						} else {
							getEID(namespace + "radio2").checked = true;
						}
						if(contentdata.contentJson.OverLap=="Yes"){
							getEID(namespace + "radio3").checked=true;
						}else if(contentdata.contentJson.OverLap=="No"){
							getEID(namespace + "radio4").checked=true;
						}else{
							getEID(namespace + "radio5").checked=true;
						}

						if (mode == "edit" && actStatus == "Inactive") {
							document.getElementsByClassName("btn-reactive")[0].style.display = "inline-block";
							document.getElementsByClassName("btn-deactive")[0].style.display = "none";
						} else if (mode == "edit" && actStatus == "Active") {
							document.getElementsByClassName("btn-reactive")[0].style.display = "none";
							document.getElementsByClassName("btn-deactive")[0].style.display = "inline-block";
						}
						 if (mode == "edit") {
								var scheduleStatus = getEID(namespace + "scheduleStatus");
								if(scheduleStatus.value=="Cancelled"){
									scheduleStatus.readOnly = true;
									scheduleStatus.disabled = true;
								}
						}
						if(getEID(namespace + "scheduleCategory").value.length>0){
								loadScheduleCategoryData();
						}
						fetchSubSchedules();
					}
				}, function() {
					displayMessage('danger',
							"Error in persisting dynamic form data.");
				});
	}
	if (mode == "view") {
		enableViewMode();
	}
}

function enableViewMode() {
	var form = document.getElementById("view_holder");
	var elements = form.elements;
	for (var i = 0, len = elements.length; i < len; ++i) {
		elements[i].readOnly = true;
		elements[i].disabled = true;
	}
	document.getElementById('cancel').removeAttribute('disabled');
	document.getElementById('edit').removeAttribute('style');
	document.getElementById('edit').removeAttribute('disabled');

	document.getElementById('deactive').removeAttribute('style');
	document.getElementById('deactive').removeAttribute('disabled');
	
	document.getElementById('save').style.display = "none";
	document.getElementById('saveDraft').style.display = "none";
}

function editSchedude() {
	editFormIoPage();
}

function loadDefaultData() {
	loadDropdownList("Schedule%20Category", document.getElementById(namespace + "scheduleCategory"));
	loadDropdownList("Schedule%20Status", document.getElementById(namespace + "scheduleStatus"));
	loadDropdownList("Schedule%20Sub-Category", document.getElementById(namespace + "scheduleSubCategory"));
	// loadDropdownList("Session%20Type", document.getElementById(namespace+
	// "sessionType"));

	
	loadDropdownList("Repeat%20Period", document.getElementById(namespace
			+ "drp_value"));
	loadDropdownList("Repeat%20Every", document.getElementById(namespace
			+ "repeatEvery"));

	//loadSubjects();
	var scheduleCategory = getEID(namespace + "scheduleCategory");
	if(scheduleCategory.value.length>0){
		loadScheduleCategoryData();
	}
	
	loadSessions();
	getCountriesList();
	if (mode != "create") {
		fetchDetails(formStorageId);
	}
	

}


var subjects;
function loadSubjects() {
	
	AUI().use('aui-io-request-deprecated', 'aui-base', function(A) {
			var _data = {};
			var sURL="/api/jsonws/SystemModelSetup-portlet.system/get-entity-link/group-id/21424/query-by-example-json-string/%7BModelLeft%3A%22Programme%22%2CModelRight%3A%22Subject%22%7D/return-field-list/ModelLeftDetails.ProgrammeTitle%2CModelRightDetails.SubjectTitle%2CstorageId/retrieve-model-details/ModelLeft%2CModelRight/flatten/true"
			A.io.request(sURL, {
				dataType : 'json',
				method : "GET",
				data : _data,
				on : {
					success : function() {
					      var subjects = this.get("responseData");
					      if (_.isEmpty(subjects)) {
					        console.log("error");
					      } else {
					    	 
					    	  for(var i =0; i < subjects.length; i++ ){
					    		  var subject = {
					  					"id" : subjects[i].storageId,
					  					"name" : subjects[i].ProgrammeTitle + " / " +subjects[i].SubjectTitle
					  				};
					  				subjectProgrammeList.push(subject);
					    	  }
					    	  
					    	  
					      }
					    },
					failure : function() {

					}
				}
			});
		});
	
}


function loadSessions() {

	var data1 = {
		"limit" : 10,
		"modelName" : "Session",
		"page" : 0,
		"formType" : "Session"
	};
	data1.conditions = [ "contentJson.Status=" + "Active" ];
	data1.sortBy = "contentJson.sessionTypeName";

	ajaxCallAPI('GET', 'searchList', data1, function() {

		var response = this.get("responseData");

		if (_.isEmpty(response)) {
			console.log("error");
		} else {

			var sessions = this.get("responseData").content;
			var elementDrpDwn = document.getElementById(namespace + "sessionType");
			
			elementDrpDwn.options[elementDrpDwn.options.length] = new Option("","");
			for (var i = 0; i < sessions.length; i++) {
				var sessionData = sessions[i].contentJson;
				var session = new Session(sessionData.SessionTypeName,
						sessionData.StartTime, sessionData.EndTime);
				sessionsList[sessionData.SessionTypeName] = session;

				var opt = new Option(sessionData.SessionTypeName,
						sessionData.SessionTypeName);
				elementDrpDwn.options[elementDrpDwn.options.length] = opt;
			}
			var opt = new Option("Not Applicable","Not Applicable");
			elementDrpDwn.options[elementDrpDwn.options.length] = opt;
			/// 
			fillTimings();
			if (mode != "create") {
				fetchDetails(formStorageId);
			}
		}
	}, function() {

	});
}


function loadScheduleCategoryData() {
	var scheduleCategory = getEID(namespace + "scheduleCategory");
	var subjectProgrammeName=sheduleBase.getElementsByClassName("subjectProgrammeName")[0];
	var subjectProgramme=sheduleBase.getElementsByClassName("subjectProgramme")[0];
	subjectProgrammeName.innerHTML=scheduleCategory.value+" Code and "+scheduleCategory.value+" Name";

	subjectProgrammeList=[];
	
	var modelName=scheduleCategory.value
	
	var data1 = {
		"limit" : 1000,
		"modelName" : modelName,
		"page" : 0,
		"formType" : modelName
	};
	data1.conditions = [ "contentJson.Status=" + "Active" ];
	
	ajaxCallAPI('GET', 'searchList', data1, function() {
		var data = this.get("responseData");

		if (_.isEmpty(data)) {
			console.log("error");
		} else {
			subjectProgrammeList=[];
			var response = this.get("responseData").content;
			var subject = {"id" : "", "name" : "" };
	  		subjectProgrammeList.push(subject);
			
			for (var i = 0; i < response.length; i++) {
				var contentJson = response[i].contentJson;
				switch(modelName) {
				  case "Facility":
					  var subject = {
		  					"id" : response[i].storageId,
		  					"name" : contentJson.FacilityName+ " / " +response[i].storageId
		  				};
		  				subjectProgrammeList.push(subject);
				    break;
				  case "Subject":
					  var subject = {
		  					"id" : response[i].storageId,
		  					"name" : contentJson.SubjectTitle+ " / " +response[i].storageId
		  				};
		  				subjectProgrammeList.push(subject);
					    break;
				  case "Programme":
					  var subject = {
		  					"id" : response[i].storageId,
		  					"name" : contentJson.ProgrammeTitle+ " / " +response[i].storageId
		  				};
		  				subjectProgrammeList.push(subject);
					    break;
				  case "Briefing":
					  var subject = {
		  					"id" : response[i].storageId,
		  					"name" : contentJson.BriefingName+ " / " +response[i].storageId
		  				};
		  				subjectProgrammeList.push(subject);
					    break;
				  case "Course":
					  var subject = {
		  					"id" : response[i].storageId,
		  					"name" : contentJson.CourseName+ " / " +response[i].storageId
		  				};
		  				subjectProgrammeList.push(subject);
					    break;
				  case "Fees":
					  var subject = {
		  					"id" : response[i].storageId,
		  					"name" : contentJson.FeesName+ " / " +response[i].storageId
		  				};
		  				subjectProgrammeList.push(subject);
					    break;
				  case "Module":
					  var subject = {
		  					"id" : response[i].storageId,
		  					"name" : contentJson.ModuleName+ " / " +response[i].storageId
		  				};
		  				subjectProgrammeList.push(subject);
					    break;
				  default:
					    
				}
			}
			var subjectProgramme=sheduleBase.getElementsByClassName("subjectProgramme")[0];
			while (subjectProgramme.options.length>0) {
				subjectProgramme.options[0] = null;
			}
			for (var j = 0; j < subjectProgrammeList.length; j++) {
	  			var opt = new Option(subjectProgrammeList[j].name, subjectProgrammeList[j].id);
	  			subjectProgramme.options[subjectProgramme.options.length] = opt;
			}
			drawTable();
		}
	}, function() {

	});
}
function Session(sessionTypeName, startTime, endTime) {
	this.SessionTypeName = sessionTypeName;
	this.StartTime = startTime;
	this.EndTime = endTime;
}

var subschedule;
function fetchSubSchedules() {
	var ScheduleCode = contentdata.contentJson.ScheduleCode;
	var data1 = {
		"limit" : 400,
		"modelName" : "SubSchedule",
		"page" : 0,
		"formType" : "SubSchedule"
	};
	data1.conditions = [ "contentJson.ScheduleStorageID=" + ScheduleCode ];
	data1.sortBy = "contentJson.ScheduleStorageID";
	ajaxCallAPI(
			'GET',
			'searchList',
			data1,
			function() {
				subScheduleList = [];
				var response = this.get("responseData");

				subschedule = this.get("responseData");
				for (var i = 0; i < subschedule.content.length; i++) {

					//					"ScheduleStorageID": "UOL:2019-128",
					//			        "FTime": "12:00 AM",
					//			        "TDate": "01\/02\/2019",
					//			        "SubScheduleID": "UOL:2019-1281203",
					//			        "TTime": "02:30 AM",
					//			        "FDate": "31\/01\/2019",
					//			        "Subject": "1203",
					//			        "Name": "1203"

					var Name = subschedule.content[i].contentJson.Name;
					var Subject = subschedule.content[i].contentJson.Subject;
					var TDate = subschedule.content[i].contentJson.TDate;
					var FDate = subschedule.content[i].contentJson.FDate;
					var FTime = subschedule.content[i].contentJson.FTime;
					var TTime = subschedule.content[i].contentJson.TTime;
					var SubScheduleID = subschedule.content[i].contentJson.SubScheduleID;
					var SubStatus = subschedule.content[i].contentJson.SubStatus;
					var visible = (subschedule.content[i].contentJson
							.hasOwnProperty("Visible") ? subschedule.content[i].contentJson.Visible
							: "show");

					var ss = new SubSchedule(SubScheduleID, Name, Subject,
							FDate, TDate, FTime, TTime, SubStatus, visible);

					subScheduleList.push(ss);
				}
				drawTable();
				if (_.isEmpty(response)) {
					console.log("error");

				}
			}, function() {

			});
	if (mode == "view") {
		enableViewMode();
	}
}


function fillTimings() {
	var sessionSelectBox = document.getElementById(namespace + "sessionType");
	if (sessionSelectBox.value!=""&&sessionSelectBox.value != "Not Applicable") {
		var startTime = sessionsList[sessionSelectBox.value].StartTime;
		var endTime = sessionsList[sessionSelectBox.value].EndTime;
		getEID(namespace + "startTime").value = startTime.substr(0, 5);
		getEID(namespace + "endTime").value = endTime.substr(0, 5);
		getEID(namespace + "startTime").disabled = true;
		getEID(namespace + "endTime").disabled = true;
	} else {
		getEID(namespace + "startTime").disabled = false;
		getEID(namespace + "endTime").disabled = false;
	}
}

function showAlertDiv(msg) {
	var showAlertDiv = getEID('form-error-div');
	var errorDiv = getEID('error_msg');
	showAlertDiv.style.display = "block";
	errorDiv.innerHTML = msg;
}

/** ****************** Date Piker ********************* */
function GetFormattedDate(date1) {
    var todayTime = new Date();
    var month = ('0' + ( date1 .getMonth() + 1)).slice(-2);
    var day = ('0' + date1 .getDate()).slice(-2);
    var year = date1 .getFullYear();
    return day + "/" + month + "/" + year;
}
var d = new Date();
var m = (d.getMonth() + 1);
var t = d.getDate();
var y = d.getFullYear();
var s =  t+ "/" + m + "/" + y;
var today = stringToDate(s, "dd/MM/yyyy", "/");

var toDatepicker;
var subStartDatePicker;
var subEndDatePicker;
var SchstartDate ;
var SchendDate;

setTimeout(function(){ 
	SchstartDate = document.getElementById(namespace + 'startDate');
	SchendDate = document.getElementById(namespace + 'endDate');
}, 3000);
YUI().use(
		'aui-datepicker',
		'aui-form-validator',
		function(Y) {
			var toDatePicker;
			var fromDatePicker = new Y.DatePicker({

				trigger : '#' + namespace + 'startDate',
				mask : '%d/%m/%Y',
				popover : {
					zIndex : "99999 !important"
				},
				calendar : {
					dateFormat : '%Y-%m-%d',
					minimumDate : today,
				},
				on : {
					selectionChange : function(event) {
						
						var r = SchstartDate.parentElement.parentElement;
						r.children[2].classList.add('hide');
						if(GetFormattedDate(event.newSelection[0]) > SchendDate.value){
							SchendDate.value = "";
						}
						if (event.newSelection[0]) {
							toDatePicker.getCalendar().set('minimumDate',
									event.newSelection[0]);
							subStartDatePicker.getCalendar().set('minimumDate',
									event.newSelection[0]);
							subEndDatePicker.getCalendar().set('minimumDate',
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
						if(SchstartDate.value > GetFormattedDate(event.newSelection[0])){
							SchstartDate.value = "";
						}
						if (event.newSelection[0]) {
							fromDatePicker.getCalendar().set('maximumDate',	event.newSelection[0]);
							subStartDatePicker.getCalendar().set('maximumDate',
									event.newSelection[0]);
							subEndDatePicker.getCalendar().set('maximumDate',
									event.newSelection[0]);
						} else {
							fromDatePicker.getCalendar().set('minimumDate',
									today);
						}

					}
				}

			});
			subStartDatePicker = new Y.DatePicker({
				trigger : '.' + 'subStartDate',
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
			subEndDatePicker = new Y.DatePicker({
				trigger : '.' + 'subEndDate',
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
					zIndex : "99999 !important"
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
	run();
}, 2000);
function stringToDate(_date, _format, _delimiter) {
	var formatLowerCase = _format.toLowerCase();
	var formatItems = formatLowerCase.split(_delimiter);
	var dateItems = _date.split(_delimiter);
	var monthIndex = formatItems.indexOf("MM");
	var dayIndex = formatItems.indexOf("dd");
	var yearIndex = formatItems.indexOf("yyyy");
	var month = parseInt(dateItems[monthIndex]);
	month -= 1;
	var formatedDate = new Date(dateItems[yearIndex], month, dateItems[dayIndex]);
	return formatedDate;
}

/** ****************** Time Piker ********************* */
YUI().use('aui-timepicker', function(Y) {
	new Y.TimePicker({
		trigger : '#' + namespace + 'startTime',
		 mask: '%H:%M',
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
		 mask: '%H:%M',
		popover : {
			zIndex : 1
		},
		on : {
			selectionChange : function(event) {
			}
		}
	});
});

function checkForm1() {
	if (document.getElementById(namespace + "scheduleCode").value != ""
			&& document.getElementById(namespace + "scheduleName").value != ""
			&& document.getElementById(namespace + "scheduleStatus").value != ""
			&& document.getElementById(namespace + "scheduleCategory").value != "") {
		document.getElementById("saveDraft").style.display = "";
		//document.getElementById("save").style.display = "";

	} else {
		document.getElementById("saveDraft").style.display = "none";
		//document.getElementById("save").style.display = "none";
	}
}

function checkIsValide() {
	var eValid = true;
	saveDraft = false;
	var ovwelapRadio5 = getEID(namespace + "radio4");
	var scheduleCode = getEID(namespace + 'scheduleCode');
	var scheduleName = getEID(namespace + 'scheduleName');
	var scheduleCountry = getEID(namespace + 'scheduleCountry');
	var startDate = getEID(namespace + 'startDate');
	var endDate = getEID(namespace + 'endDate');
	var scheduleCategory = getEID(namespace + 'scheduleCategory');
	var scheduleStatus = getEID(namespace + 'scheduleStatus');
	var startTime=getEID(namespace + 'startTime').value;
	var endTime=getEID(namespace + 'endTime').value;

	addAllDataToArray();
	if (buttonname != 'reactive' || buttonname != 'deactive') {
		if (scheduleCategory.value == ""
			|| scheduleCategory.value == "Please select category") {
			validdata = true;
			eValid = false;
			selected_1 = unhide("scheduleCategory");
		} else {
			selected_1 = hide("scheduleCategory");
		}
		if (scheduleStatus.value == "") {
			validdata = true;
			selected_1 = unhide("scheduleStatus");
			eValid = false;
		} else {
			selected_1 = hide("scheduleStatus");
		}
		if (scheduleCode.value == "") {
			validdata = true;
			selected_1 = unhide("scheduleCode");
			eValid = false;
		} else {
			selected_1 = hide("scheduleCode");
		}
		if (scheduleName.value == "") {
			validdata = true;
			eValid = false;
			selected_1 = unhide("scheduleName");
		} else {
			selected_1 = hide("scheduleName");
		}
		if (startDate.value == "") {
			validdata = true;
			eValid = false;
			selected_1 = unhide("startDate");
		} else {
			selected_1 = hide("startDate");
		}
		if (endDate.value == "") {
			validdata = true;
			eValid = false;
			selected_1 = unhide("endDate");
		} else {
			selected_1 = hide("endDate");
		}
		
		if (scheduleCountry.value == "") {
			validdata = true;
			eValid = false;
			selected_1 = unhide("scheduleCountry");
		} else {
			selected_1 = hide("scheduleCountry");
		}
		//
		for (var i = 1; (i < subScheduleList.length && eValid); i++) {
			if (subScheduleList[i].Name == "") {
				eValid = false;
				displayMessage('danger', "Sub-Schedule Name Code is Mandatory",
						3000);
				break;
			}
		}
		
		var data = subScheduleList;
		var timeValStatus=true;
		for(var i = 0; (i<data.length && eValid);i++){
			if(ValidateTime(startTime,data[i].FTime)){
				eValid=false;
				timeValStatus=false;
			}if(ValidateTime(data[i].TTime,endTime)){
				eValid=false
				timeValStatus=false;
			}
		}
		if(!eValid && !timeValStatus) 
			displayMessage('danger', "Sub-Schedule Time have to schedule between " +startTime+" to "+endTime, 3000);
		
		for(var h=0;(h<HolidayList.length && eValid);h++){
			if(HolidayList[h].Date==startDate.value){
				displayMessage('danger', startDate.value+" Schedule Date is holiday" , 3000);
				eValid=false
				break;
			}else if(endDate.value==HolidayList[h].Date){
				displayMessage('danger', endDate.value+" Schedule Date is holiday" , 3000);
				eValid=false
				break;
			}
			for(var i = 0; i<data.length;i++){
				if(HolidayList[h].Date==data[i].FDate){
					displayMessage('danger', data[i].FDate+" Sub-Schedule Date is holiday" , 3000);
					eValid=false
					break;
				}else if(data[i].TDate==HolidayList[h].Date){
					displayMessage('danger', data[i].TDate+" Sub-Schedule Date is holiday" , 3000);
					eValid=false
					break;
				}
			}
		}
		
		
		
		for (var i = 0; (i < data.length && eValid); i++) {
			var fromDate1 = getStringToDate(data[i].FDate);
			var toDate1 = getStringToDate(data[i].TDate);
			if (ovwelapRadio5.checked && eValid) {
				for (var j = i + 1; j < data.length; j++) {
					var fromDate2 = getStringToDate(data[j].FDate);
					var toDate2 = getStringToDate(data[j].TDate);

					if (fromDate1 <= fromDate2 && toDate1 >= fromDate2) {
						if(TimeDifference(data[i].FTime,data[j].FTime)>=0&&TimeDifference(data[i].TTime,data[j].FTime)<=0){
							eValid = false;
							break;
						}else if(TimeDifference(data[i].FTime,data[j].TTime)>=0&&TimeDifference(data[i].TTime,data[j].TTime)<=0){
							eValid = false;
							break;
						}
					} else if (fromDate1 <= toDate2 && toDate1 >= toDate2) {
						if(TimeDifference(data[i].FTime,data[j].FTime)>=0&&TimeDifference(data[i].TTime,data[j].FTime)<=0){
							eValid = false;
							break;
						}else if(TimeDifference(data[i].FTime,data[j].TTime)>=0&&TimeDifference(data[i].TTime,data[j].TTime)<=0){
							eValid = false;
							break;
						}
					}
				}if (!eValid){
					displayMessage('danger', "Sub-Schedule Date and Time Range is overlapping", 3000);
					break;
				}	
			}
		}
	}
	return eValid;
}

function getHolidayList(country) {
	var scheduleCountry = getEID(namespace + "scheduleCountry");
	var data1 = {};
	data1.limit = "1000";
	data1.page = 0;
	data1.filterdata = [];
	data1.formType = "HolidayCalendar";
	data1.ModelName = "HolidayCalendar";
	data1.limit = "1000";
	data1.page = 0;
	var filterdata = [];
	
	var filter = {};
	if(scheduleCountry.value != ""){
		filter["contentJson.Country"] = [scheduleCountry.value];
	}
	filterdata.push(filter);
	data1["filterdata"] = filterdata;
	
	
	ajaxCallAPI(
			'GET',
			'elastiSearchList',
			data1,
			function() {
				HolidayList=[];
				var response = this.get("responseData");
				if (response.error) {
					displayMessage('danger', data.error);
				} else {
					var content=response.content;
					for(var i=0;i<content.length;i++){
						HolidayList.push(content[i].contentJson)
					}
				}
				
				

			}, function() {

			});
}

function getCountriesList(){
	var ajaxUrl = countryListUrl;
	AUI().use('aui-io-request-deprecated','aui-base',
			function(A) {
				var _data = {};
				A.io.request(ajaxUrl,
								{
							dataType : 'json',
							method : "GET",
							data : _data,
							on : {
								success : function() {
									var responseData = this.get('responseData');
									
									var select = getEID(namespace + "scheduleCountry");
									for(var i = 0; i <  responseData.length; i++) {
									    select.options[select.options.length] = new Option(responseData[i].nameCurrentValue, responseData[i].nameCurrentValue);
									    if (select.options[i].text == "Singapore") {
									    	select.selectedIndex = i;
									    }
									}
									getHolidayList(select);
								},
								failure : function() {
									
								}
							}
						});
			});
}

function getStringToDate(strDate) {
	var parts = strDate.split("/");
	var dt = new Date(parseInt(parts[2], 10), parseInt(parts[1], 10) - 1,
			parseInt(parts[0], 10));
	return dt;
}

function ebableOnceValide() {
	setInterval(function() {
		checkIsValide();
	}, 1000);
}
var buttonname;
function Active(e) {
	actStatus = "Active";
	buttonname = e.name;
	submitSchedule();
	//validateFields();
	activatiionsucess();
}

function confirm(e) {
	if (document.getElementById("deactivate_reason").value.length > 4) {
		actStatus = "Inactive";
		buttonname = e.name;
		// validateFields();
		submitSchedule();
		deactivationsucess();
	} else {
		document.getElementById("deactivate_msg").classList.add("alert");
		document.getElementById("deactivate_msg").classList.add("alert-error");
	}
}

function Deactive() {
	deactivate_msg();
}

function deactivationsucess() {
	var boundingBox = '#deactivation-success';
	var contentBox = '#inactive-success-box';
	AUI().use('aui-base', function(A) {
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
			Y.all('.close').on('click', function() {
				reload();
				modal.hide();
			});
		});
	});
}

function activatiionsucess() {
	var boundingBox = '#activation-success';
	var contentBox = '#active-success-box';
	AUI().use('aui-base', function(A) {
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
			Y.all('.close').on('click', function() {
				reload();
				modal.hide();
			});
		});
	});
}

function deactivate_msg() {
	var boundingBox = '#deactive-record';
	var contentBox = '#deactive-record-box';
	AUI().use('aui-base', function(A) {
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
			Y.all('.close').on('click', function() {
				reload();
				modal.hide();
			});
		});
	});
}
function cancelbtn() {
	var boundingBox = '#deactive-record';
	var contentBox = '#deactive-record-box';
	AUI().use('aui-base', function(A) {
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
			Y.all('.close1').on('click', function() {
				//reload();
				modal.hide();
			});
		});
	});
}

function submitFormConfirmation() {
	var boundingBox = '#sucess-popup';
	var contentBox = '#sucess-popup-box';
	AUI().use('aui-base', function(A) {
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
			Y.all('.close1').on('click', function() {
				//reload();
				modal.hide();
			});
		});
	});
}

function submitDraftConfirmation() {
	var boundingBox = '#sucess-popup1';
	var contentBox = '#sucess-popup-box1';
	AUI().use('aui-base', function(A) {
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
			Y.all('.close1').on('click', function() {
				//reload();
				modal.hide();
			});
		});
	});
}

function validatevalue() {
	var scheduleCode = getEID(namespace + "scheduleCode");
	var scheduleName = getEID(namespace + "scheduleName");
	var startDate = getEID(namespace + "startDate");
	if (scheduleCode.value != "") {
		var e = document.getElementById(namespace + 'scheduleCode');
		var r = e.parentElement.parentElement;
		r.children[2].classList.add('hide');
	}
	if (scheduleName.value != "") {
		var e = document.getElementById(namespace + 'scheduleName');
		var r = e.parentElement.parentElement;
		r.children[2].classList.add('hide');
	}
	if (startDate.value != "") {
		var e = document.getElementById(namespace + 'startDate');
		var r = e.parentElement.parentElement;
		r.children[2].classList.add('hide');
	}
}

function collapsOrExpand(e) {
	parentt = findAncestor(e, "sheduleContainer");
	if (parentt.getElementsByClassName("Visible")[0].innerHTML == "hide") {
		parentt.getElementsByClassName("Visible")[0].innerHTML = "show";
	} else {
		parentt.getElementsByClassName("Visible")[0].innerHTML = "hide";
	}
	addAllDataToArray();
	drawTable();
}
function AvoidSpace(event) {
	var k = event ? event.which : window.event.keyCode;
	if (k == 32)
		return false;
}

function backtolist() {
	window.location = baseUrl;
}

//Function for reset the for value
function resetForm(myFormElement){

	getEID("schedule_form").reset();
	
	var select = getEID(namespace + "scheduleCountry");
	select.value="Singapore";
}


function convertTime24to12(time24) {
	var tmpArr = time24.split(':'), time12;
	if (+tmpArr[0] == 12) {
		time12 = tmpArr[0] + ':' + tmpArr[1] + ' pm';
	} else {
		if (+tmpArr[0] == 00) {
			time12 = '12:' + tmpArr[1] + ' am';
		} else {
			if (+tmpArr[0] > 12) {
				time12 = (+tmpArr[0] - 12) + ':' + tmpArr[1] + ' pm';
			} else {
				time12 = (+tmpArr[0]) + ':' + tmpArr[1] + ' am';
			}
		}
	}
	return time12;
}

function ValidateTime(FromTime,ToTime){
	 var time1Seconds = toSeconds(FromTime.substr(0,2), FromTime.substr(3));
     var time2Seconds = toSeconds(ToTime.substr(0,2), ToTime.substr(3));

     if (!time1Seconds || !time2Seconds){
         return false;
     }
     var difference = time2Seconds-time1Seconds;
     if (difference < 0){
     	return true;
     }else{
     	return false;
     }
}



function TimeDifference(FromTime,ToTime){
	 var time1Seconds = toSeconds(FromTime.substr(0,2), FromTime.substr(3));
    var time2Seconds = toSeconds(ToTime.substr(0,2), ToTime.substr(3));

    if (!time1Seconds || !time2Seconds){
        return false;
    }
    var difference = time2Seconds-time1Seconds;
    return difference;
}

function toSeconds(hours, minutes){
    var seconds = 0;
    if ( (hours >= 0 && hours < 24) && (minutes >= 0 && minutes < 60)){
        seconds += (parseInt(hours)*3600) + (parseInt(minutes)*60);
        return seconds
    } else {
        return false;
    }
}

function dbDateToUserDateConverter(dbDate){
	var dateParts = dbDate.split("/");
	var today = new Date(+dateParts[2], dateParts[1] - 1, +dateParts[0]);
	if(today.toString() != "Invalid Date"){
		var dd = String(today.getDate()).padStart(2, '0');
		var mm = String(today.getMonth() + 1).padStart(2, '0'); //January is 0!
		var yyyy = today.getFullYear();
		return dd + '/' + mm + '/' + yyyy;
	}
	return dbDate;
	
}


