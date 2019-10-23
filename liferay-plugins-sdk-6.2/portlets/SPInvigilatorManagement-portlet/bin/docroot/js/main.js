function loadDropdownList(strSubURI, elementDrpDwn) {
	var ajax = vocabularyURL.replace("$VCNAME", strSubURI);
	AUI()
			.use(
					'aui-io-request-deprecated',
					function(A) {
						var _data = {};
						A.io
								.request(
										ajax,
										{
											dataType : 'json',
											method : "GET",
											data : _data,
											on : {
												success : function() {
													responseData = this
															.get('responseData');
													for (var i = 0; i < responseData.length; i++) {
														var opt = new Option(
																responseData[i].name,
																responseData[i].name);
														elementDrpDwn.options[elementDrpDwn.options.length] = opt;
													}
												},
												failure : function() {
													console
															.log("Error in the ajax call.");
												}
											}
										});
					});
}
var ScheduleFacilityId;
var ScheduleId;
var FacilityId;
function getGroupName() {
	var data = {};
	data.formType = "Appointment";
	data.formStorageId = ""
	data.ModelName = "Appointment";
	data.Column = "GroupName";
	data.ScheduleId = ScheduleId;
	data.FacilityId = FacilityId;

	ajaxCallAPI('POST', "groupName", data, function() {
		var data = this.get("responseData");
		if (data.error) {
			displayMessage('danger', data.error, 3000);
		} else {
			var grpName = data.GroupName;
			var options = '';
			for (var i = 0; i < grpName.length; i++) {
				options += '<option value="' + grpName[i] + '"/>';
				
			}
			
			document.getElementById('GroupNameDL').innerHTML = options;
			if(groupNameValue != ""){
				document.getElementById("groupName").value = groupNameValue;
				document.getElementById("groupName").disabled = true;
				onGroupSelect();
			}

		}
	}, function() {

	});
}
function getUniqueData(columnName,elem) {
	var data = {};
	data.formType = "InvigilatorAppointment";
	data.formStorageId = ""
	data.ModelName = "InvigilatorAppointment";
	data.Column = columnName;
	data.ScheduleId = ScheduleId;
	data.FacilityId = FacilityId;

	ajaxCallAPI('POST', "groupName", data, function() {
		var data = this.get("responseData");
		if (data.error) {
			displayMessage('danger', data.error, 3000);
		} else {
			var grpName = data[columnName];
			var options = '<option value=""> All </option>';
			for (var i = 0; i < grpName.length; i++) {
				options += '<option value="' + grpName[i] + '">' + grpName[i] + "</option>";
			}
			document.getElementById(elem).innerHTML = options;

		}
	}, function() {

	});
}
var timeOut;
function scrollToTop() {
	if (document.body.scrollTop != 0 || document.documentElement.scrollTop != 0) {
		window.scrollBy(0, -50);
		timeOut = setTimeout('scrollToTop()', 10);
	} else {
		clearTimeout(timeOut);
	}
}

function goToDashboard() {
	window.location.href = dashBoardLink;
}

function formatDate(myDate) {
	var dd = myDate.getDate();
	var mm = myDate.getMonth() + 1; //January is 0!

	var yyyy = myDate.getFullYear();
	if (dd < 10) {
	  dd = '0' + dd;
	} 
	if (mm < 10) {
	  mm = '0' + mm;
	} 
	return dd + '/' + mm + '/' + yyyy;
}