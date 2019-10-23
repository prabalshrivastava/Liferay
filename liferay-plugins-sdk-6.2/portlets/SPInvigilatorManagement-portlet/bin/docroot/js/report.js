var scheduleFacility;
var step_2, step_3, buttonHolder;
var groupName, appointType;
var buttonHolder
var tbl, tbody, tr_base;
var planList = [];
var JSONInvList = [];
var sesInvList = [];
var responseData = [];
var timeout = null;
var grpName = "";
var scheduleData ;
var dateofAppointment = "29/09/2018";
var InvigilatorAppointmentModel = "InvigilatorAppointment";

function init() {
	scheduleFacility = document.getElementById("scheduleFacility");
	step_2 = document.getElementById("step-2");
	step_3 = document.getElementById("step-3");
	buttonHolder = document.getElementById("buttonHolder");
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
	for (var i = 0; i < opts.length; i++) {
		if (opts[i].value.toLowerCase() == val.toLowerCase()) {

			break;
		}
	}

	clearTimeout(timeout);
	timeout = setTimeout(function() {
		getAppointInvigilatorsList();

		visibleStep3();

	}, 500);

}
function generateReport(){
	
	var appointType = document.getElementById("appointType").value;
	var appointStatus = document.getElementById("appointStatus").value;
	var opts = document.getElementById('GroupNameDL').childNodes;
	for (var i = 0; i < opts.length; i++) {
		if (opts[i].value.toLowerCase() == groupName.value.toLowerCase()) {

			break;
		}
	}

	clearTimeout(timeout);
	timeout = setTimeout(function() {
		getAppointInvigilatorsList();

	}, 500);
}

function visibleStep3() {
	if ((groupName.value != "" && groupName.value != "Select Option")
			&& (appointType.value != "" && appointType.value != "Select Option")) {
		step_3.style.display = "block";
		buttonHolder.style.display = "block";
	} else {
		step_3.style.display = "none";
		buttonHolder.style.display = "none";
	}
}


var tr;
function drawTable() {
	while (tbody.hasChildNodes()) {
		tbody.removeChild(tbody.lastChild);
	}

	for (var i = 0; i < planList.length; i++) {
		tr = tr_base.cloneNode(true);
		
		var object = planList[i].contentJson;
		if(typeof object.ReportingTime == "undefined"){
			object.ReportingTime = "";
		}
		
		tr.getElementsByClassName("Invigilator")[0].innerHTML = object.FullName;
		tr.getElementsByClassName("ContactNumber")[0].innerHTML = object.ContactNo;

		tr.getElementsByClassName("GroupName")[0].innerHTML = object.GroupName;
		tr.getElementsByClassName("AppType")[0].innerHTML = object.AppointType;
		tr.getElementsByClassName("InvID")[0].innerHTML = object.UserId;
		tr.getElementsByClassName("Status")[0].innerHTML = object.AppointmentStatus;
		tr.getElementsByClassName("timeNotified")[0].innerHTML = object.ReportingTime;
		tbody.appendChild(tr);
	}
}

function onChecked(e) {
	var tr = e.parentElement.parentElement;
	setTimeout(
			function() {
				for (var i = 0; i < planList.length; i++) {
					if (e.id == "chkAll") {
						planList[i].checked = e.checked;
					} else {
						if (tr.getElementsByClassName("Lead")[0].id == planList[i].UserId) {
							planList[i].Lead = tr
									.getElementsByClassName("Lead")[0].checked;
							planList[i].checked = tr
									.getElementsByClassName("checked")[0].checked;
						}
					}
				}
				drawTable();
			}, 0);
}


function getGroupNameBySchedule() {
	debugger;
	var ScheduleModel = "schedule";
	ScheduleFacilityId = scheduleFacility.value;
	ScheduleId = ScheduleFacilityId.slice(0, ScheduleFacilityId.indexOf("|"));
	FacilityId = ScheduleFacilityId.slice(ScheduleFacilityId.indexOf("||") + 2, ScheduleFacilityId.length);
	var data = {};
	data.formStorageId = ScheduleId
	data.formType = ScheduleModel;
	data.ModelName = ScheduleModel;
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
			var grpName = data.group_name;
			step_2.style.display = "block";
			var options = '';
			if(grpName.length>0){
				
			}
			for (var i = 0; i < grpName.length; i++) {
				options += '<option value="' + grpName[i] + '"/>';
			}
			document.getElementById('GroupNameDL').innerHTML = options;
			getScheduleData();
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
	data1.filterdata = [];
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
					var YrsOfExp = 0;
					for (var e = 0; e < contentJson.InvigilationExperienceList.length; e++) {
						YrsOfExp = YrsOfExp
								+ parseFloat(contentJson.InvigilationExperienceList[e].YearsExperience);
					}
					JSONInvList[i].TotalExperience = YrsOfExp

				}

			}, function() {

			});
}

function getAppointInvigilatorsList() {

	var filterdata = [];
	var jsonsearchparameter = {
		"limit" : 1000,
		"page" : 0,
		"modelName" : InvigilatorAppointmentModel,
		"formType" : InvigilatorAppointmentModel
	};
	jsonsearchparameter["conditions"] = "";
	var filter = {};
	if(groupName.value != ""){
		filter["contentJson.GroupName"] = [groupName.value];
	}
	if(appointType.value != ""){
		filter["contentJson.AppointType"] = [appointType.value];
	}
	if(appointStatus.value != ""){
		filter["contentJson.AppointmentStatus"] = [appointStatus.value];
	}
	filter["contentJson.ScheduleId"] = [scheduleData.ScheduleCode];
	filter["contentJson.FacilityId"] = [FacilityId];
	filter["contentJson.Date"] = [scheduleData.StartDate];
	filterdata.push(filter);
	jsonsearchparameter["sortby"] =  [
	                                  {
                                      "direction": "asc",
                                      "field": "GroupName",
                                      "contentJSON": "true"
                                    }
                                  ];
	jsonsearchparameter["filterdata"] = filterdata;
	planList = [];
	ajaxCallAPI('GET', 'elastiSearchList', jsonsearchparameter, function() {
		var response = this.get("responseData");
		var appointedInvigilatorsList = response.content;
		for (var i = 0; i < appointedInvigilatorsList.length; i++) {
			planList.push(appointedInvigilatorsList[i])
		}
		drawTable();
		document.getElementById('step-3').style.display= "block";
		
	}, function() {

	});
}
function exportReport(){
	var filterdata = [];
	var jsonsearchparameter = {
		"limit" : 1000,
		"page" : 0,
		"modelName" : InvigilatorAppointmentModel,
		"formType" : InvigilatorAppointmentModel
	};
	jsonsearchparameter["conditions"] = "";
	var filter = {};
	groupName  = document.getElementById("groupName");
	if(groupName.value != ""){
		filter["contentJson.GroupName"] = [groupName.value];
	}
	if(appointType.value != ""){
		filter["contentJson.AppointType"] = [appointType.value];
	}
	if(appointStatus.value != ""){
		filter["contentJson.AppointmentStatus"] = [appointStatus.value];
	}
	
	filterdata.push(filter);
	jsonsearchparameter["sortby"] =  [
	                                  {
                                      "direction": "asc",
                                      "field": "GroupName",
                                      "contentJSON": "true"
                                    }
                                  ];
	jsonsearchparameter["filterdata"] = filterdata;
	planList = [];
	ajaxCallAPI('GET', 'exportReport', jsonsearchparameter, function() {
		var response = this.get("responseData");
		window.open(this._ATTR_E_FACADE.newVal.responseURL,"_blank");
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
				scheduleFacility.options[scheduleFacility.options.length] = new Option(
						index, contentJson.StorageID);
				
				if(scheduleFacility != "" && scheduleFacility == contentJson.StorageIdLeft){
					scheduleFacility.options[scheduleFacility.options.length - 1].selected = true;
					getScheduleData();
				}
			}
		}, function() {

		});
}

function getScheduleData() {
	if (scheduleFacility.value != "" && scheduleFacility.value != "Select Option") {
		var data = {};
		data.formStorageId = ScheduleId;
		data.formType = "schedule";
		data.ModelName = "schedule";
		ajaxCallAPI('GET', 'loadData', data, function() {
			var response = this.get("responseData");
			scheduleData = response.contentJson;
			step_2.style.display = "block";
			generateReport();
		}, function() {
			step_2.style.display = "none";
		});
	} else {
		step_2.style.display = "none";
	}
}

function submitForm(e) {

	mode = "create"
	var _data = {};
	if (e.value == "Save") {
		_data.Status = "Active";
	} else {
		_data.Status = "Draft";
	}
	_data.formStorageId = "0";
	_data.formType = "Appointment";
	_data.ModelName = "Appointment";
	_data.UserId = userId;
	_data.appointmentDate = dateofAppointment;
	_data.scheduleFacility = document.getElementById("scheduleFacility").value;
	_data.ScheduleId = document.getElementById("scheduleFacility").value;
	_data.Date = document.getElementById("Date").innerHTML;
	_data.Session = document.getElementById("Session").innerHTML;
	_data.Time = document.getElementById("Time").innerHTML;
	_data.GroupName = document.getElementById("groupName").value;
	_data.AppointType = document.getElementById("appointType").value;

	var arrInvigilators = [];

	for (var i = 0; i < planList.length; i++) {
		if (planList[i].checked) {
			planList[i].AppointType = document.getElementById("appointType").value
			planList[i].Date = _data.appointmentDate;
			planList[i].Session = document.getElementById("Session").innerHTML;
			planList[i].Venue = "";
			planList[i].AppointmentStatus = "Pending";
			planList[i].Remarks = "";
			arrInvigilators.push(planList[i]);
		}
	}
	_data.Invigilators = arrInvigilators;

	ajaxCallAPI('POST', 'persist', _data, function() {
		var response = this.get("responseData");
		var cont = response.content;

	}, function() {

	});

}
