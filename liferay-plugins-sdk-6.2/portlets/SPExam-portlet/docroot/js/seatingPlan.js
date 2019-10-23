var filter,contentdata;
var data;
var seatingPlanInstanceTemplate={};
var seatingPlanInstance = {};
if(document.readyState == 'complete') {
	invoke();
} else {
	window.addEventListener('load', invoke);
}

function invoke(){
	setInterval(function() {
		checkForm();
	}, 1000);
	getInstanceSeatingLayout();
}

function checkForm(){
	if(getEID(namespace + "formStorageId").value !==""){
		//document.getElementById("draft").disabled = true;
	}
}

function getInstanceSeatingLayout(){
	console.log("facilityId="+facilityId,"subFacilityId="+subFacilityId,"scheduleId="+scheduleId);
	data = {};
	data.formType = "seatingplaninstance";
	data.conditions = ["facilityId="+facilityId,"subFacilityId="+subFacilityId,"scheduleId="+scheduleId,"size="+2147483647];
	
	loadFilterData(data,function(responseData){
		var data = responseData.content;
		console.log("contentdata : " + JSON.stringify(data));
		if(JSON.stringify(data) === "[]"){
			getSeatingPlanDefaultLayout();
			return;
		}
		seatingPlanInstance = data[data.length-1]["contentJson"];
		if(seatingPlanInstance.SeatPlanStatus=="Active"){
			document.getElementById("draft").style = "display:none;";
		}
		data.forEach(function(layout) {
		    console.log(layout);
		    getEID(namespace + "noOfSeatsPerRow").value = layout.noOfColumns;
		    getEID(namespace + "noOfRows").value = layout.noOfRows;
			getEID(namespace + "deakNoFormat").value = layout.deskNoFormat;
			getEID(namespace + "noOfSeatsAvailable").value = layout.hasOwnProperty("subFacilityId") && layout.subFacilityId.hasOwnProperty("contentJson") && layout.subFacilityId.contentJson.hasOwnProperty("SFCapacity") && layout.subFacilityId.contentJson.SFCapacity != "" ? layout.subFacilityId.contentJson.SFCapacity : layout.availSeats;
			getEID(namespace + "formStorageId").value = layout.storageId;
			getEID(namespace + "seatingPlanCode").value = layout.contentJson.SeatingPlanId;
		});
	});
}

function getSeatingPlanDefaultLayout(){
	
	filter = {};
	filter.formType = "seatingPlan";
	filter.conditions = ["facilityId="+facilityId,"subFacilityId="+subFacilityId,"size="+2147483647];
	loadFilterData(filter,function(responseData){
		setInterval(function() {
		}, 1000);
		var data = responseData.content;
		console.log("contentdata : " + JSON.stringify(data));
		data.forEach(function(layout) {
		    console.log(layout);
		    getEID(namespace + "noOfSeatsPerRow").value = layout.noOfColumns;
		    getEID(namespace + "noOfRows").value = layout.noOfRows;
			getEID(namespace + "deakNoFormat").value = layout.deskNoFormat;
			getEID(namespace + "noOfSeatsAvailable").value = layout.seatingCapacity;
			getEID(namespace + "seatingPlanCode").value = layout.storageId;
			setSeatingPlanInstanceTemplate();
		});
	});
}

function setSeatingPlanInstanceTemplate(){
	data = {};
	data.formType = "seatingplaninstance";
	data.conditions = ["facilityId="+facilityId,"subFacilityId="+subFacilityId,"size="+2147483647];
	
	loadFilterData(data,function(responseData){
		setInterval(function() {
		}, 1000);
	
		var spData = responseData.content;

		for(var i=0; i<spData.length; i++){
			var spIData = spData[i];
			if(spIData.hasOwnProperty("template") && spIData.template){
				seatingPlanInstanceTemplate = spIData.contentJson;
			}
		}
		console.log("contentdata : " + JSON.stringify(data));
		
	});
}

function validateFields(action) {
	if (checkIsValide()) {
		if(getEID(namespace + "formStorageId").value == "" || getEID(namespace + "formStorageId").value == "0" ){
			submitCustomiseSeatLayout(action);
		}else{
			var modelName = "seatingplanlayout";
			var data = {};
			data.formType = modelName;
			data.seatingPlanInstace = getEID(namespace + "formStorageId").value;
			data.actionType = "removedbyinstanceid";
			ajaxCall('GET', 'removeUserAssignedSeat', ajaxUrl, data, function() {
				submitCustomiseSeatLayout(action);
			}, function() {

			});
		}
	}
}

function checkIsValide() {
	var eValid = true;
	if (getEID(namespace + 'noOfSeatsPerRow').value.trim() == "") {
		eValid = false;
		displayMessage('danger', "Total No. of Seat/Row is Mandatory", 3000);
	} else if (getEID(namespace + 'noOfRows').value.trim() == "") {
		eValid = false;
		displayMessage('danger', "Total No. of Rows is Mandatory", 3000);
	} else if (getEID(namespace + 'deakNoFormat').value.trim() == "") {
		eValid = false;
		displayMessage('danger', "Desk Number Prefix is Mandatory", 3000);
	} else if (getEID(namespace + 'noOfSeatsAvailable').value.trim() == "") {
		eValid = false;
		displayMessage('danger', "Total No. of available seats is Mandatory", 3000);
	}else if(isNaN(getEID(namespace + 'noOfSeatsPerRow').value.trim())){
		eValid = false;
		displayMessage('danger', "Total No. of Seat/Row should be number", 3000);
	}	else if(isNaN(getEID(namespace + 'noOfRows').value.trim())){
		eValid = false;
		displayMessage('danger', "Total No. of Rows should be number", 3000);
	}else if(isNaN(getEID(namespace + 'noOfSeatsAvailable').value.trim())){
		eValid = false;
		displayMessage('danger', "Total No. of available Seats should be number", 3000);
	}else if(parseInt(getEID(namespace + 'noOfSeatsPerRow').value.trim()) * parseInt(getEID(namespace + 'noOfRows').value.trim()) > parseInt(getEID(namespace + 'noOfSeatsAvailable').value.trim())){
		eValid = false;
		displayMessage('danger', "The Total Number of Available Seats is less than the entered Total Number of Seats per Row times the Total Number of Rows. Please update the numbers.", 3000);
	}
	
	return eValid;
}

function cDataSeatingPlanLayouts(SeatingPlanInstanceId, SeatingPlanLayoutId, FromRow, ToRow, FromCol, ToCol, SeatNoDirection, IsTemplate, AssignMarker, AssignMarkerContent, seatingPlanLayoutParameters) {
	var cData = {
		SeatingPlanInstanceId : SeatingPlanInstanceId,
		SeatingPlanLayoutId : SeatingPlanLayoutId,
		FromRow : FromRow,
		ToRow : ToRow,
		FromCol : FromCol,
		ToCol : ToCol,
		SeatNoDirection : SeatNoDirection,
		IsTemplate : IsTemplate,
		AssignMarker : AssignMarker,
		AssignMarkerContent : AssignMarkerContent,
		seatingPlanLayoutParameters : seatingPlanLayoutParameters
	}
	return cData;
}

function submitCustomiseSeatLayout(action) {
	showLoading(true);
	var noOfSeatsPerRow = getEID(namespace + "noOfSeatsPerRow");
	var noOfRows = getEID(namespace + "noOfRows");
	var deskNoFormat = getEID(namespace + "deakNoFormat");
	var noOfSeatsAvailable = getEID(namespace + "noOfSeatsAvailable");
	var seatingPlanCode = getEID(namespace + "seatingPlanCode").value;
	var assignCand = "";

	var customiseseat={};
	var seatingPlanInstanceCode;
	customiseseat.formStorageId = getEID(namespace + "formStorageId").value;
	if(customiseseat.formStorageId === "" || customiseseat.formStorageId === "0" ){
		seatingPlanInstanceCode = generateSeatingPlanInstanceCode();
		customiseseat = seatingPlanInstanceTemplate;
		var splArr = [];
		if(customiseseat.hasOwnProperty("seatingPlanLayouts")){
			for(var s=0; s<customiseseat.seatingPlanLayouts.length; s++){
				var j = customiseseat.seatingPlanLayouts[s];
				splArr.push(cDataSeatingPlanLayouts(seatingPlanInstanceCode, seatingPlanInstanceCode + "_" + j.FromRow + "_" + j.ToRow + "_" + j.FromCol + "_" + j.ToCol + "_" + j.AssignMarker, j.FromRow, j.ToRow, j.FromCol, j.ToCol, j.SeatNoDirection, "0", j.AssignMarker, j.AssignMarkerContent, []))
			}
		}
		customiseseat["seatingPlanLayouts"] = splArr;
		customiseseat.formStorageId = "";
		customiseseat.SeatPlanStatus = "Draft";
		customiseseat.AssignSeatStatus = "";
	}else{
		seatingPlanInstanceCode = customiseseat.formStorageId;
		customiseseat = seatingPlanInstance;
		customiseseat.formStorageId = seatingPlanInstanceCode;
	}
	if((customiseseat.hasOwnProperty("NoOfColumns") && customiseseat.NoOfColumns < noOfSeatsPerRow.value) || (customiseseat.hasOwnProperty("NoOfRows") && customiseseat.NoOfRows < noOfRows.value)){
		customiseseat["seatingPlanLayouts"] = [];
	}
	
	customiseseat.NoOfColumns = noOfSeatsPerRow.value;
	customiseseat.NoOfRows = noOfRows.value;
	customiseseat.DeskNoFormat = deskNoFormat.value;
	customiseseat.AvailSeats = noOfRows.value * noOfSeatsPerRow.value;
	customiseseat.SeatingPlanId = seatingPlanCode;
	customiseseat.FacilityId = facilityCode;
	customiseseat.SubFacilityId = subFacilityCode;
	customiseseat.ScheduleId = scheduleCode;
	customiseseat.AssignCand = assignCand;
	customiseseat.IsTemplate = false;
	customiseseat.SeatingPlanInstanceId = seatingPlanInstanceCode;

	customiseseat.formType = "seatingplaninstance";
	console.log(customiseseat);
	console.log(JSON.stringify(customiseseat));
	ajaxCallAPI('POST', 'persist', customiseseat, function() {
		let data = this.get("responseData");
		if (data.error) {
			displayMessage('danger', data.error, 3000);
		} else if (Object.keys(data).length === 0) {
			console.log("data : "+data);
			displayMessage('danger', 'Form submission failed.', 3000);
		} else {
			console.log(data.toString());
			var message = "Form successfully submitted.";
			if (action == "draft"){
				message = "Record is saved in draft";
				afterFormSubmissionFormIOForm(customiseseat);
			}else{
				createSettingTemplate(seatingPlanInstanceCode);
			}
		}
		showLoading(false);
	}, function() {
		displayMessage('danger', "Error in persisting dynamic form data.", 3000);
		showLoading(false);
	});
}

function afterFormSubmissionFormIOForm(data){
	console.log("data : " + JSON.stringify(data));
	console.log("data.formStorageId : " + data.formStorageId);
	var status = data.SeatPlanStatus;
	var formType = "Customise layout";
	console.log("status : " + status);
	var msg = "";
	var boundingBox = "#sucess-popup";
	var contentBox = "#sucess-popup-box";
	if (status == "Draft") {
		msg = formType + " saved as draft!";
	} else if (data.formStorageId == "0" || data.formStorageId == ""
			|| data.formStorageId == null
			|| typeof data.formStorageId === 'undefined') {
		msg = formType + " Created!";
	} else if (status == "Active" && data.reactive) {
		msg = formType + " Updated!";
		boundingBox = "#activation-success";
		contentBox = "#active-success-box";
	} else if (status == "Active") {
		msg = formType + " Updated!";
	} else if (status == "Inactive") {
		msg = formType + " Updated!";
		boundingBox = "#deactivation-success";
		contentBox = "#inactive-success-box";
	}
	document.getElementById('success-msg').innerHTML = msg;
	AUI().use('aui-base', function(A) {

		A.one(boundingBox).set('hidden', false);

		YUI().use('aui-modal', function(Y) {
			new Y.Modal({
				boundingBox : boundingBox,
				contentBox : contentBox,
				headerContent : '',
				centered : true,
				destroyOnHide : false,
				modal : true,
				resizable : false,
				draggable : false,
			}).render();
			Y.one('.close').hide();
		});

	});
}

function generateSeatingPlanInstanceCode() {
		var date = new Date();
		var now_utc =  Date.UTC(date.getUTCFullYear(), date.getUTCMonth(), date.getUTCDate(),
				 date.getUTCHours(), date.getUTCMinutes(), date.getUTCSeconds());
		return "SPI-"+now_utc;
}

function getEID(element) {
	return document.getElementById(element);
}

function moveToList() {
	window.location.href = homeUrl;
}

function showLoading(show) {
	if(show) {
		getEID("loadingDiv").style.display = "block";
	} else {
		getEID("loadingDiv").style.display = "none";
	}
}

function resetDefault() {
	getSeatingPlanDefaultLayout();
}

function loadFilterData(filter,callback){
	var data;
	ajaxCallAPI(
			'GET',
			"searchList",
			filter,
			function() {
				data = this.get("responseData");
				contentdata = this.get("responseData");
				if (data.error) {
					displayMessage('danger', data.error, 3000);
				} else {
					//responseData = contentdata.content;
				}
				callback(contentdata);
			}, function() {
				displayMessage('danger',
						"Error in persisting dynamic form data.", 3000);
				callback();
			});
}

function calculateTotalSeats(){
	var rows = getEID(namespace + "noOfRows").value;
	var columns = getEID(namespace + "noOfSeatsPerRow").value;
	
	//getEID(namespace +"noOfSeatsAvailable").value = rows * columns;
}