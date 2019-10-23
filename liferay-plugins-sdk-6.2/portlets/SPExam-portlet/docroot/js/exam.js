
var data, contentdata;
var sessionScheduleList = [];
var ssLoaded = false;
var instance=this;

function init() {
	console.log("onload...");
	if(mode == "view"){
		sessionScheduleDropdown("schedule", function(data) {
		sessionScheduleList = data;
		ssLoaded = true;
		if(ssLoaded == true){
			var sessionSchedule=getEID(namespace + "sessionSchedule");
			populateDropDown(sessionSchedule,sessionScheduleList,"ScheduleCode","ScheduleCode");
			sessionSchedule.value = selectedSchedule;
		}
	});
	}
	
}
if(document.readyState == 'complete') {
	init();
} else {
	window.addEventListener('load', init);
}

function sessionScheduleDropdown(model,callback){
	var criteria = {};
	criteria.formType = model;
	criteria.action = "get/active/Subject";
	ajaxCallAPI(
			'GET',
			"fetchData",
			criteria,
			function() {
				data = this.get("responseData");
				if (data.error) {
					displayMessage('danger', data.error, 3000);
				} else {
					callback(data);
				}
			
			}, function() {
				displayMessage('danger',
						"Error in persisting dynamic form data.", 3000);
				callback([]);
			});
}
function downloadDropdownData(model,callback){
	data = {};
	data.formType = model;
	data.conditions = ["modelLeft=Schedule","modelRight=Facility","linkType=ScheduleFacilityEntityLink","size="+2147483647];
	
	ajaxCallAPI(
			'GET',
			"searchList",
			data,
			function() {
				data = this.get("responseData");
				contentdata = this.get("responseData");
				var responseData = [];
				if (data.error) {
					displayMessage('danger', data.error, 3000);
				} else {
					responseData = contentdata.content;
				}
				callback(responseData);
			}, function() {
				displayMessage('danger',
						"Error in persisting dynamic form data.", 3000);
				callback();
			});
}

function populateDropDown(elementDrpDwn, data, keyColumn, valueColumn) {
	var scheduleMap = new Map();
	for(var i=0; i<data.length; i++) {
		if(data[i].hasOwnProperty(keyColumn) && data[i][keyColumn] != "" ){
			scheduleMap.set(data[i][keyColumn], data[i][valueColumn]);
		}
	}
	
	scheduleMap.forEach(function(value, key, scheduleMap) {
		var opt = new Option(value, key);
		elementDrpDwn.options[elementDrpDwn.options.length] = opt;
	})
}

function getEID(element) {
	return document.getElementById(element);
}

function reset() {
	document.getElementById("seatLayout_form").reset();
}
