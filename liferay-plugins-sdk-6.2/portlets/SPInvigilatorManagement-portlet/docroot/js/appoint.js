var scheduleFacility;
var step_2, step_3;
var groupName, appointType;
var bt_submit;
var bt_clear;
var tbl, tbody, tr_base;
var selectedInvigilators = [];
var JSONInvList = [];
var sesInvList = [];
var responseData = [];
var timeout = null;
var AppointToDL = null;
var scheduleData;
var formStorageId = "0";
var InvigilatorAppointmentModel = "InvigilatorAppointment";

function init() {
	scheduleFacilitySelect = document.getElementById("scheduleFacility");
	AppointToDL = document.getElementById('AppointToDL');
	step_2 = document.getElementById("step-2");
	step_3 = document.getElementById("step-3");
	bt_submit = document.getElementById("bt_submit");
	bt_clear = document.getElementById("bt_clear");
	appointType = document.getElementById("appointType");
	groupName = document.getElementById("groupName");
	tbl = document.getElementById('tb_DateDescription');
	tbody = tbl.getElementsByTagName('tbody')[0];
	tr_base = tbody.getElementsByTagName("tr")[0];
	drawTable();
	getInvigilatorsList();
	getScheduleFacilityLinkData();
	
	
}



function onGroupSelect() {
	
	var val = document.getElementById("groupName").value;
	var opts = document.getElementById('GroupNameDL').childNodes;
	var appointType = document.getElementById('appointType');
	for (var i = 0; i < opts.length; i++) {
		if (opts[i].value.toLowerCase() == val.toLowerCase()) {

			break;
		}
	}

	clearTimeout(timeout);
	timeout = setTimeout(function() {
		visibleStep3();
	}, 500);

}

function visibleStep3() {
	if ((groupName.value != "" && groupName.value != "Select Option")
			&& (appointType.value != "" && appointType.value != "Choose a type")) {
		step_3.style.display = "block";
		bt_submit.style.display = "inline-block";
		bt_clear.style.display = "inline-block";
	} else {
		step_3.style.display = "none";
		bt_submit.style.display = "none";
		bt_clear.style.display = "none";
	}
	getAppointInvigilatorsListByGroup(groupName.value,appointType.value,"");
}

function addToAppointList(e) {

	var val = document.getElementById("appoint_to").value;
	var opts = AppointToDL.childNodes;

	clearTimeout(timeout);
	timeout = setTimeout(function() {
		var id =  e.value.split("-")[0].trim();
		for (var i = 0; i < opts.length; i++) {
			if (opts[i].value.toLowerCase() == val.toLowerCase()) {
				var AppointToDL = document.getElementById("AppointToDL");
				AppointToDL.removeChild(opts[i]);
				for (var i = 0; i < JSONInvList.length; i++) {
					var obj = JSONInvList[i];
					var pExist = false;
					for (var p = 0; p < selectedInvigilators.length; p++) {
						if (id == selectedInvigilators[p].UserId) {
							pExist = true;
							break;
						}
					}
					if (id == obj.UserId && !pExist) {
						obj.Lead = false;
						obj.checked = false;
						if(!obj.Score){
							obj.Score = 0;
						}
						selectedInvigilators.push(obj);
					}
				}
				planListShort();
				drawTable();
				appoint_to.value = "";
				break;
			}
		}
		var test = document.getElementById('available');
		test.innerText = selectedInvigilators.length;
	}, 500);
	
}

function planListShort() {
	for (var i = 0; i < selectedInvigilators.length; i++) {
		for (var j = i; j > 0; j--) {
			if (selectedInvigilators[j].TotalExperience > selectedInvigilators[j - 1].TotalExperience) {
				var temp = selectedInvigilators[j];
				selectedInvigilators[j] = selectedInvigilators[j - 1];
				selectedInvigilators[j - 1] = temp;
			}
		}
	}
	
	for (var i = 0; i < selectedInvigilators.length; i++) {
		for (var j = i; j > 0; j--) {
			if (selectedInvigilators[j].Score > selectedInvigilators[j - 1].Score) {
				var temp = selectedInvigilators[j];
				selectedInvigilators[j] = selectedInvigilators[j - 1];
				selectedInvigilators[j - 1] = temp;
			}
		}
	}
}

var tr;
function drawTable() {
	
	while (tbody.hasChildNodes()) {
		tbody.removeChild(tbody.lastChild);
	}
	var selected=0;
	for (var i = 0; i < selectedInvigilators.length; i++) {
		tr = tr_base.cloneNode(true);
		var object = selectedInvigilators[i];
		var internalCategory = "";
		if(typeof object.InternalCategory != "undefined"){
			internalCategory = object.InternalCategory;
		}
		tr.getElementsByClassName("Lead")[0].id = object.UserId;
		tr.getElementsByClassName("LeadLBL")[0].setAttribute("for",object.UserId)
		var isLead = (object.Lead == 'true' || object.Lead == true);
		tr.getElementsByClassName("Lead")[0].checked = isLead;
		tr.getElementsByClassName("Invigilator")[0].innerHTML = object.FullName;
		tr.getElementsByClassName("IONumber")[0].innerHTML = object.NRICNumberID;

		tr.getElementsByClassName("YrsOfExp")[0].innerHTML = object.TotalExperience;
		var score = 0;
		if(object.Score){
			score = object.Score;
		}
		tr.getElementsByClassName("EvalScore")[0].innerHTML = score;
		tr.getElementsByClassName("IntCategory")[0].innerHTML = internalCategory;
		tr.getElementsByClassName("Status")[0].innerHTML = object.AppointmentStatus.toUpperCase();
		tr.getElementsByClassName("checked")[0].checked = object.checked;

		tr.getElementsByClassName("checked")[0].id = 'Chk-' + i;
		tr.getElementsByClassName("ChkLBL")[0].setAttribute("for", 'Chk-' + i)

		tbody.appendChild(tr);
	}
	var test = document.getElementById('available');
	test.innerText = selectedInvigilators.length;
	
	var count = 0;
	var form = document.getElementById("myform");
	for (var i = 0; i < form.elements.length; i++) {
		obj = form.elements[i];
		if (obj.type == "checkbox" && obj.checked) {
			count++;
		}
	}
	var test = document.getElementById('selected');
	test.innerText = count;
	
}

function onChecked(e) {
	var tr = e.parentElement.parentElement;
	var leadSelection=e.className=="Lead";
	setTimeout(
			function() {
				for (var i = 0; i < selectedInvigilators.length; i++) {
					if (e.id == "chkAll") {
						selectedInvigilators[i].checked = e.checked;
					} else {
						if (tr.getElementsByClassName("Lead")[0].id == selectedInvigilators[i].UserId) {
							selectedInvigilators[i].Lead = tr.getElementsByClassName("Lead")[0].checked;
							selectedInvigilators[i].checked = tr.getElementsByClassName("checked")[0].checked;
						} else if(leadSelection){
							selectedInvigilators[i].Lead=false;
						}
					}
				}
				drawTable();
			}, 0);
	
	var obj;
	var count = 0;
	var form = document.getElementById("myform");
	for (var i = 0; i < form.elements.length; i++) {
		obj = form.elements[i];
		if (obj.type == "checkbox" && obj.checked) {
			count++;
		}
	}
	var test = document.getElementById('selected');
	test.innerText = count;
}


function getGroupNameBySchedule() {
	
	var data = {};
	data.formType = "Appointment";
	data.ModelName = "Appointment";
	data.Column = "group_name";
	data.ScheduleId = ScheduleId;
	data.FacilityId = FacilityId;

	ajaxCallAPI('GET', "groupName", data, function() {
		var data = this.get("responseData");
		if (data.error) {
			displayMessage('danger', data.error, 3000);
		} else {
			var grpName = data.GroupName;
			step_2.style.display = "block";
			var options = '';
			if(grpName.length>0){
				
			}
			for (var i = 0; i < grpName.length; i++) {
				options += '<option value="' + grpName[i] + '"/>';
			}
			document.getElementById('GroupNameDL').innerHTML = options;

		}
	}, function() {

	});
}

function getInvigilatorsList() {
	
	var data1 = {};
	data1.limit = "1000";
	data1.page = 0;
	data1.filterdata = [];
	data1.formType = "Invigilator";
	data1.ModelName = "Invigilator";
	data1.limit = "1000";
	data1.page = 0;
	var filter = {};
	var filterdata = [];
	filter["contentJson.Status"] = ["Active"];
	filterdata.push(filter);
	data1.filterdata = filterdata;
	ajaxCallAPI(
			'GET',
			'elastiSearchList',
			data1,
			function() {
				var response = this.get("responseData");
				var cont = response.content;
				for (var i = 0; i < cont.length; i++) {

					var contentJson = cont[i].contentJson;
					JSONInvList[i] = contentJson;
					if(!JSONInvList[i].Score ){
						JSONInvList[i].Score = 0;
					}
					var YrsOfExp = 0;
					if(contentJson.InvigilationExperienceList){
						for (var e = 0; e < contentJson.InvigilationExperienceList.length; e++) {
							YrsOfExp = YrsOfExp
									+ parseFloat(contentJson.InvigilationExperienceList[e].YearsExperience);
						}
					}
					
					if(JSONInvList[i].Status == "Active"){
						JSONInvList[i].AppointmentStatus = "Available";
					}else{
						JSONInvList[i].AppointmentStatus = "Not Available";
					}
					JSONInvList[i].TotalExperience = YrsOfExp

				}

			}, function() {

			});
}

function getAppointInvigilatorsListByGroup(grpName,appointType,appointStatus) {
	var filterdata = [];
	var jsonsearchparameter = {
		"limit" : 1000,
		"page" : 0,
		"modelName" : InvigilatorAppointmentModel,
		"formType" : InvigilatorAppointmentModel
	};
	jsonsearchparameter["conditions"] = [];
	var filter = {};
	//filter["contentJson.GroupName"] = [grpName];
	if(appointType != ""){
		//filter["contentJson.AppointType"] = [appointType];
	}
	if(appointStatus != ""){
		filter["contentJson.AppointmetStatus"] = [appointStatus];
	}
	filter["contentJson.ScheduleId"] = [ScheduleId];
	//filter["contentJson.FacilityId"] = [FacilityId];
	filter["contentJson.Date"] = [scheduleData.StartDate];
	filterdata.push(filter);
	jsonsearchparameter["filterdata"] = filterdata;
	selectedInvigilators = [];
	ajaxCallAPI('GET', 'elastiSearchList', jsonsearchparameter, function() {
		
		var GroupNameDL=document.getElementById('GroupNameDL');
		var groupName=document.getElementById('groupName');
		for (i=0;i<GroupNameDL.options.length;  i++) {
			if(groupName.value==GroupNameDL .options[i].value){
				formStorageId=ScheduleFacilityId;
				break;
			}else{
				formStorageId="0";
			}
		}
		var response = this.get("responseData");
		var cont = [];
		if (response != null && response.hasOwnProperty('content')) {
			for(var i=0;i<response.content.length;i++){
				cont.push(response.content[i].contentJson)
			}
		}
		var options = '';
		for (var i = 0; i < JSONInvList.length; i++) {
			var isExist = false;
			for (var s = 0; s < cont.length; s++) {
				if (cont[s].UserId == JSONInvList[i].UserId) {
					JSONInvList[i].AppointmentStatus = cont[s].AppointmentStatus;
					if (JSONInvList[i].TotalExperience >=0  ) { // && !isExist
						JSONInvList[i].checked =  true;
						JSONInvList[i].Lead =  cont[s].Lead;
						selectedInvigilators.push(JSONInvList[i]);
						isExist=true;
						break;
					}
				}
			}if(!isExist && "Lead Proctor"==appointType){
				if (JSONInvList[i].TotalExperience >=5  ) {
					selectedInvigilators.push(JSONInvList[i]);
					isExist=true;
				}
			}if (isExist && response != null) {
				for (var c = 0; c < cont.length; c++) {
					var contentJson = cont[c];
					if (contentJson.UserId == JSONInvList[i].UserId) {
						isExist = true;
						break;
					}
				}
			}

			if (!isExist) {
				options += '<option value="' + JSONInvList[i].UserId + " - " +  JSONInvList[i].FirstName + JSONInvList[i].LastName + " - " +JSONInvList[i].NRICNumberID +'">'
				+ '</option>';
			}
		}
		
		AppointToDL.innerHTML = options;
		
		loadInvigilatorSuggestion();
	}, function() {

	});
}

function getAppointInvigilatorsListByAppointmentId(appointmentId) {

	
	var filterdata = [];
	var jsonsearchparameter = {
		"limit" : 1000,
		"page" : 0,
		"modelName" : InvigilatorAppointmentModel,
		"formType" : InvigilatorAppointmentModel
	};
	jsonsearchparameter["conditions"] = [];
	var filter = {};
	filter["contentJson.AppointmentID"] =   [appointmentId]; 
	filterdata.push(filter);
	jsonsearchparameter["filterdata"] = filterdata;
	selectedInvigilators = [];
	ajaxCallAPI('GET', 'elastiSearchList', jsonsearchparameter, function() {
		var response = this.get("responseData");
		var cont = response.content;
		for (var i = 0; i < cont.length; i++) {
			var contentJson = cont[i].contentJson;
			sesInvList[i] = contentJson;
		}
	}, function() {

	});
}

function getScheduleFacilityLinkData() {
	
	var data1 = {};
	data1.limit = "1000";
	data1.page = 0;
	data1.filterdata = [];
	data1.formType = "EntityLink";
	data1.ModelName = "EntityLink";
	ajaxCallAPI(
			'GET',
			'uocommingFacilitySchedule',
			data1,
			function() {
				var response = this.get("responseData");
				var cont = response;
				for (var i = 0; i < cont.length; i++) {
					var contentJson = cont[i];
					var index = contentJson.StorageIdLeft + "-"
							+ contentJson.StorageIdLeft1 + " + "
							+ contentJson.StorageIdRight + "-"
							+ contentJson.StorageIdRight1;
					scheduleFacilitySelect.options[scheduleFacilitySelect.options.length] = new Option(
							index, contentJson.StorageID);
					
					if(scheduleFacility != "" && scheduleFacility == contentJson.StorageID){
						scheduleFacilitySelect.options[scheduleFacilitySelect.options.length - 1].selected = true;
						document.getElementById("scheduleFacility").value = scheduleFacility;
						document.getElementById("scheduleFacility").disabled = true;
						getScheduleData();
					}
				}
			}, function() {

			});
}
function addMinutes(time, minsToAdd) {
  function D(J){ return (J<10? '0':'') + J;};
  var piece = time.split(':');
  var mins = piece[0]*60 + +piece[1] + +minsToAdd;

  return D(mins%(24*60)/60 | 0) + ':' + D(mins%60);  
}  
	
function getScheduleData() {
	step_2.style.display = "none";
	step_3.style.display = "none";
	var GroupNameDL=document.getElementById('GroupNameDL').innerHTML = '';
	for (i=0;i<GroupNameDL.length;  i++) {
		GroupNameDL.remove(i);
	}
	
	if (scheduleFacilitySelect.value != "" && scheduleFacilitySelect.value != "Select Option") {
		var data = {};
		var ScheduleModel = "schedule";
		ScheduleFacilityId = scheduleFacilitySelect.value;
		ScheduleId = ScheduleFacilityId.slice(0, ScheduleFacilityId.indexOf("|"));
		FacilityId = ScheduleFacilityId.slice(ScheduleFacilityId.indexOf("||") + 2, ScheduleFacilityId.length);
		data.formStorageId = ScheduleId
		data.formType = ScheduleModel;
		data.ModelName = ScheduleModel;
		ajaxCallAPI('GET', 'loadData', data, function() {
			var response = this.get("responseData");
			scheduleData = response.contentJson;
			//document.getElementById("Date").innerHTML = cont.StartDate + "-"+ cont.EndDate;
			dateofAppointment = scheduleData.StartDate;
			document.getElementById("Date").innerHTML = dateofAppointment;		
			document.getElementById("Session").innerHTML = scheduleData.SessionType
			if(scheduleData.SessionType == "" || scheduleData.SessionType == "Not Applicable"){
				document.getElementById("bt_submit").style.display = "none";
				alert("Not a valid Session Type");
			}else{
				document.getElementById("bt_submit").style.display = "block";
			}
			
			document.getElementById("Time").innerHTML = scheduleData.StartTime.slice(0,5) + "-"	+ scheduleData.EndTime.slice(0,5);
				
			step_2.style.display = "block";
			getGroupName();
			getAppointInvigilatorsListByAppointmentId(dateofAppointment + "|" + ScheduleFacilityId);
		}, function() {
			step_2.style.display = "none";
		});
	} else {
		step_2.style.display = "none";
	}
}
var dateofAppointment = "29/09/2018";
function submitForm(e) {
	
	var _data = {};
	if (e.value == "Save") {
		_data.Status = "Active";
	} else {
		_data.Status = "Draft";
	}
	
	/*if(formStorageId.length!="0"){
		mode = "edit"
	}else{
		mode = "create"
	}*/
	
	_data.formStorageId = "0";
	_data.formType = "Appointment";
	_data.ModelName = "Appointment";
	_data.UserId = userId;
	_data.appointmentDate = dateofAppointment;
	_data.scheduleFacility = ScheduleFacilityId;
	
	_data.ScheduleId = ScheduleId;
	_data.FacilityId = FacilityId;
	_data.Date = document.getElementById("Date").innerHTML;
	_data.SessionType = document.getElementById("Session").innerHTML;
	_data.Time = document.getElementById("Time").innerHTML;
	_data.GroupName = document.getElementById("groupName").value;
	_data.AppointType = document.getElementById("appointType").value;

	var arrInvigilators = [];
	var deselectedInvigilators = [];

	for (var i = 0; i < selectedInvigilators.length; i++) {
		if (selectedInvigilators[i].checked && (selectedInvigilators[i].AppointmentStatus == "Available" || selectedInvigilators[i].AppointmentStatus == "Not Available")) {
			selectedInvigilators[i].AppointmentType = document.getElementById("appointType").value
			selectedInvigilators[i].Date = _data.appointmentDate;
			selectedInvigilators[i].SessionType = document.getElementById("Session").innerHTML;
			selectedInvigilators[i].Venue = "";
			selectedInvigilators[i].ReportingTime = addMinutes(scheduleData.StartTime,scheduleData.MinBeforeScheduleStart);
			
			selectedInvigilators[i].AppointmentStatus = "Pending Notification";
			selectedInvigilators[i].Remarks = "";
			arrInvigilators.push(selectedInvigilators[i]);
		}else if(!selectedInvigilators[i].checked){
			deselectedInvigilators.push(selectedInvigilators[i]);
		}
		if(selectedInvigilators[i].Lead){
			_data.leadUserId = selectedInvigilators[i].UserId;
		}
	}
	_data.Invigilators = arrInvigilators;
	_data.deSelectedInvigilators = deselectedInvigilators;

	ajaxCallAPI('POST', 'persist', _data, 
		function() {
			var response = this.get("responseData");
			
			if (response.error) {
				displayMessage('danger', response.error, 3000);
			} else {
				if(response!=0){
					var cont = response.content;
					showpopup();
				}else{
					displayMessage('danger', "Schedule Already exist", 3000);
				}
			}
		}, function() {
	
		});

}
function showpopup(){
	
	var boundingBox = "#sucess-popup";
	var contentBox = "#sucess-popup-box";
	AUI().use('aui-base', function(A) {
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

function displayMessage(type, message, duration) {
	scrollToTop();
	var alert_div = document.getElementById("alert_msg");
	alert_div.innerHTML = message;
	alert_div.classList.add("alert-" + type);
	alert_div.style.display = "block";
	setTimeout(function() {
		alert_div.style.display = "none";
	}, duration);
	console.log(message);
}
