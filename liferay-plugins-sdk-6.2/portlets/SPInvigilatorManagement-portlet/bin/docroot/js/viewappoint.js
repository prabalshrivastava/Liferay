var scheduleFacility;
var step_2, step_3, bt_edit;
var groupName, appointType;
var bt_edit
var tbl, tbody, tr_base;
var planList = [];
var JSONInvList = [];
var sesInvList = [];
var responseData = [];
var timeout = null;
var InvigilatorAppointmentModel = "InvigilatorAppointment";
var dateofAppointment = "29/09/2018";
var scheduleData;
function init() {
	scheduleFacility = document.getElementById("scheduleFacility");
	step_2 = document.getElementById("step-2");
	step_3 = document.getElementById("step-3");
	bt_edit = document.getElementById("bt_edit");
	appointType = document.getElementById("appointType");
	groupName = document.getElementById("groupName");
	tbl = document.getElementById('tb_DateDescription');
	tbody = tbl.getElementsByTagName('tbody')[0];
	tr_base = tbody.getElementsByTagName("tr")[0];
	drawTable();
	getScheduleFacilityLinkData();
}
function ScheduleFacilityOnChange() {
	if (scheduleFacility.value != ""
			&& scheduleFacility.value != "Select Option") {
		step_2.style.display = "block";
		getAppointInvigilatorsListBySession(scheduleFacility.value)
	} else {
		step_2.style.display = "none";
	}
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
		visibleStep3();
	}, 500);

}
function getScheduleData() {
	step_2.style.display = "none";
	step_3.style.display = "none";
	var GroupNameDL=document.getElementById('GroupNameDL').innerHTML = '';
	for (i=0;i<GroupNameDL.length;  i++) {
		GroupNameDL.remove(i);
	}
	
	if (scheduleFacility.value != "" && scheduleFacility.value != "Select Option") {
		var data = {};
		var ScheduleModel = "schedule";
		ScheduleFacilityId = scheduleFacility.value;
		ScheduleId = ScheduleFacilityId.slice(0, ScheduleFacilityId.indexOf("|"));
		FacilityId = ScheduleFacilityId.slice(ScheduleFacilityId.indexOf("||") + 2, ScheduleFacilityId.length);
		data.formStorageId = ScheduleId
		data.formType = ScheduleModel;
		data.ModelName = ScheduleModel;
		ajaxCallAPI('GET', 'loadData', data, function() {
			var response = this.get("responseData");
			scheduleData = response.contentJson;
			document.getElementById("Date").innerHTML = scheduleData.StartDate ;
			document.getElementById("Session").innerHTML = scheduleData.SessionType
			document.getElementById("Time").innerHTML = scheduleData.StartTime.slice(0,5) + "-"	+ scheduleData.EndTime.slice(0,5);
				

			step_2.style.display = "block";
			getGroupName();
			getUniqueData("AppointmentType","appointType");
		}, function() {
			step_2.style.display = "none";
		});
	} else {
		step_2.style.display = "none";
	}
}
function visibleStep3() {
	if ((groupName.value != "" && groupName.value != "Select Option")) {
		step_3.style.display = "block";
		
	} else {
		step_3.style.display = "none";
		
	}
	if(appointType.value != ""){
		bt_edit.disabled = false;
	}else{
		bt_edit.disabled = true;
	}
	
	getAppointInvigilatorsList();
}

var tr;
function drawTable() {
	while (tbody.hasChildNodes()) {
		tbody.removeChild(tbody.lastChild);
	}

	for (var i = 0; i < planList.length; i++) {
		tr = tr_base.cloneNode(true);
		var object = planList[i].contentJson;
		var internalCategory = "";
		var notificationDate = "";
		if(typeof object.InternalCategory != "undefined"){
			internalCategory = object.InternalCategory;
		}
		if(typeof object.NotificationDate != "undefined"){
			notificationDate = object.NotificationDate;
		}else {
			var date = new Date(planList[i].lastModifiedDate);
			notificationDate =  date.getDate()+'/'+(date.getMonth()+1)+'/'+date.getFullYear()+'  '
			+date.getHours() + ":" + date.getMinutes() + ":" + date.getSeconds();
		}
		tr.getElementsByClassName("Lead")[0].id = object.UserId;
		tr.getElementsByClassName("LeadLBL")[0].setAttribute("for",	object.UserId)
		tr.getElementsByClassName("Lead")[0].checked = object.Lead;
		tr.getElementsByClassName("Invigilator")[0].innerHTML = object.FullName;
		tr.getElementsByClassName("ContactNumber")[0].innerHTML = object.ContactNo;

		tr.getElementsByClassName("GroupName")[0].innerHTML = object.GroupName;
		tr.getElementsByClassName("AppType")[0].innerHTML = object.AppointType;
		tr.getElementsByClassName("InvID")[0].innerHTML = object.UserId;
		tr.getElementsByClassName("IntCategory")[0].innerHTML = internalCategory;
		tr.getElementsByClassName("Status")[0].innerHTML = object.AppointmentStatus.toUpperCase();
		tr.getElementsByClassName("timeNotified")[0].innerHTML = notificationDate;
		tbody.appendChild(tr);
	}
}


function getAppointInvigilatorsList() {
	
	var filterdata = [];
	var jsonsearchparameter = {
		"limit" : 2147483647,
		"page" : 0,
		"modelName" : InvigilatorAppointmentModel,
		"formType" : InvigilatorAppointmentModel
	};
	jsonsearchparameter["conditions"] = [];
	var filter = {};
	if(groupName.value != ""){
	filter["contentJson.GroupName"] = [groupName.value];
	}
	if(appointType.value != ""){
		filter["contentJson.AppointType"] = [appointType.value];
	}
	
	filter["contentJson.ScheduleId"] = [ScheduleId];
	filter["contentJson.FacilityId"] = [FacilityId];
	filter["contentJson.Date"] = [scheduleData.StartDate];
	filterdata.push(filter);
	jsonsearchparameter["filterdata"] = filterdata;
	planList = [];
	ajaxCallAPI('GET', 'elastiSearchList', jsonsearchparameter, function() {
		var response = this.get("responseData");
		var appointedInvigilatorsList = response.content;
		for (var i = 0; i < appointedInvigilatorsList.length; i++) {
			planList.push(appointedInvigilatorsList[i])
		}
		drawTable();
		document.getElementById('totalseinvig').innerHTML = appointedInvigilatorsList.length;
		document.getElementById('availableinvig').style.display= "block";
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
				
					
				}
			}, function() {

			});
}




