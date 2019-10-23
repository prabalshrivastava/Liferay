var data,contentdata;
var facilityList = [];
var subFacilityList = [];
var seatingPlanInstance = {};
var fLoaded = false;
var sfLoaded = false;
var eloaded =false;
var SPID = "";
showLoading(true);

function init() {

	console.log("onload...");
	fLoaded = false;

	loadDefaultData(function() {
		setInterval(function() {
			checkForm();
		}, 1000);
		console.log("onload - mode : "+mode);
		var facilityName = getEID(namespace + "facilityName");
		populateFacilityDropDown(facilityName, facilityList, "FacilityCode", "FacilityName");

	});

}
if(document.readyState == 'complete') {
	init();
} else {
	window.addEventListener('load', init);
}


function checkDigitis(t,d){
	var digits = t.value.length;
	if(digits > d){
		displayMessage('danger', "Please enter only "+d+" digits number.", 3000);
		t.value = t.value.substring(0, d);
		return true;
	}
	return false;
}

function preventOtherCharacters(evt){
	if (evt.which != 8 && evt.which != 0 && evt.which < 48 || evt.which > 57)
    {
		evt.preventDefault();
    }
}


function loadDefaultData(callback) {
	console.log("loadDefaultData - mode : "+mode);
	loadDropdowns(function() {
		console.log("ssLoaded : "+fLoaded);
		console.log("tcLoaded : "+sfLoaded);
		if(fLoaded == true) {
			if (mode != "create") {
				fetchDetails(formStorageId);
			} else {
				showLoading(false);
			}
			callback();
		}
	});
}

function fetchDetails(formStorageId) {
	showLoading(true);
	if (formStorageId != "") {
		data = {};
		console.log("StorageId === "+formStorageId);
		data.formStorageId = encodeURI(formStorageId);
		data.formType = "SeatingPlan";
		ajaxCallAPI(
				'GET',
				"loadData",
				data,
				function() {
					data = this.get("responseData");
					contentdata = this.get("responseData");
					console.log("contentdata : " + JSON.stringify(contentdata));
					if (data.error) {
						displayMessage('danger', data.error, 3000);
					} else {
						eloaded =true;
						var sc = contentdata.storageId;
						if (mode == "copy") {
							sc = "Copy-of-" + sc;
						}
						if(mode=="edit") {


							var subFacilityName = getEID(namespace+"subFacilityName");
							var opt = document.createElement('option');
							opt.value = contentdata.contentJson.hasOwnProperty("SubFacility")?contentdata.contentJson.SubFacility:contentdata.contentJson.SubFacilityName;
							opt.innerHTML = contentdata.contentJson.SubFacilityName;
							subFacilityName.appendChild(opt);


							if(contentdata.contentJson.Status=="Draft") {
								getEID("formStatus").value = "Active";

							} else {
								getEID("formStatus").value = contentdata.contentJson.Status;
							}
						}
						getEID(namespace + "facilityType").value = contentdata.contentJson.FacilityType;
						getEID(namespace + "facilityName").value = contentdata.contentJson.hasOwnProperty("Facility")?contentdata.contentJson.Facility:contentdata.contentJson.FacilityName;
						getEID(namespace + "seatingCapacity").value = contentdata.contentJson.SeatingCapacity;
						getEID(namespace + "seatingLayoutDescription").value = contentdata.contentJson.SeatingLayoutDescription;
						getEID(namespace + "noOfRows").value = contentdata.contentJson.NoOfRows;
						getEID(namespace + "noOfColumns").value = contentdata.contentJson.NoOfColumns;



						getEID("formStatus").innerHTML = contentdata.contentJson.Status;
						getEID("formStatus").className = "";
						getEID("formStatus").classList.add("formStatus");
						getEID("formStatus").classList.add("form_"+contentdata.contentJson.Status.toLowerCase());


						if (mode == "edit"
							&& contentdata.contentJson.Status == "Inactive") {
							getEID("activate").style.display = "";
							getEID("deactivate").style.display = "none";
						} else if (mode == "edit") {
							getEID("activate").style.display = "none";
							getEID("deactivate").style.display = "";
							getEID(namespace + "facilityType").disabled = true;
							getEID(namespace + "facilityName").disabled = true;
							getEID(namespace + "subFacilityName").disabled = true;
						}
					}
					if (mode == "view" && contentdata.contentJson.Status == "Inactive") {
						getEID("activate").style.display = "";
						getEID("deactivate").style.display = "none";
						var subFacilityName = getEID(namespace+"subFacilityName");
						var opt = document.createElement('option');
						opt.value = contentdata.contentJson.hasOwnProperty("Facility")?contentdata.contentJson.Facility: contentdata.contentJson.SubFacilityName;
						opt.innerHTML = contentdata.contentJson.SubFacilityName;
						subFacilityName.appendChild(opt);
						enableViewMode();
						}
						else if(mode == "view" && contentdata.contentJson.Status == "Active"){
						getEID("activate").style.display = "none";
						getEID("deactivate").style.display = "";
						var subFacilityName = getEID(namespace+"subFacilityName");
						var opt = document.createElement('option');
						opt.value = contentdata.contentJson.hasOwnProperty("Facility")?contentdata.contentJson.Facility: contentdata.contentJson.SubFacilityName;
						opt.innerHTML = contentdata.contentJson.SubFacilityName;
						subFacilityName.appendChild(opt);
						enableViewMode();
						}
					if(contentdata.contentJson.hasOwnProperty("CandidateSeatAutoAssignment") && contentdata.contentJson.CandidateSeatAutoAssignment == "Auto"){
						document.getElementById("ecmhdei-Yes").checked=true;
						document.getElementById("allowToOverrideSeatAutoAssignment").checked=contentdata.contentJson.AllowToOverrideSeatAutoAssignment=="true"?true:false;
						document.getElementsByClassName('allowToOverrideSeatAutoAssignment')[0].style='display:block;';
					}
					else{
						document.getElementsByClassName('allowToOverrideSeatAutoAssignment')[0].style='display:none;';
						document.getElementById("allowToOverrideSeatAutoAssignment").checked=false;
						document.getElementById("ecmhdei-No").checked=true;
						
					}
					showLoading(false);
				}, function() {
					displayMessage('danger',
							"Error in persisting dynamic form data.", 3000);
					showLoading(false);
				});
	}
}


function loadSubFacility(facility){
	data = {};
	data.formType = "subfacility";
	data.conditions = ["contentJson.FacilityStorageID="+facility, "size="+2147483647];

	downloadDropDown("subFacility", function(data) {
		subFacilityList = data;
		sfLoaded = true;
		var subFacilityName = getEID(namespace+"subFacilityName");
		populateFacilityDropDown(subFacilityName, subFacilityList, "SubFacilityID", "SFName");
	});

}
function loadDropdowns(callback) {
	data = {};
	data.formType = "facility";
	data.conditions = ["contentJson.Status=Active", "size="+2147483647];
	downloadDropDown("facility", function(data) {
		facilityList = data;
		fLoaded = true;
		callback();
	});
}


function downloadDropDown(model, callback) {

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

function checkForm() {
	if ( document.getElementById(namespace + "facilityType").value.trim() != ""
		&& document.getElementById(namespace + "facilityName").value.trim() != "") {
		if (mode == "copy" || mode == "create") {
			document.getElementById("draft").disabled = false;
			document.getElementById("publish").disabled = false;
		} else if (mode == "edit") {
			document.getElementById("deactivate").disabled = false;
			document.getElementById("update").disabled = false;
		}
	} else {
		if (mode == "copy" || mode == "create") {
			document.getElementById("draft").disabled = true;
			document.getElementById("publish").disabled = true;
		} else if (mode == "edit") {
			document.getElementById("deactivate").disabled = true;
			document.getElementById("update").disabled = true;
		}
	}
}

function loadSeatCapacity(subfacility){

	data = {};
	data.formType = "subfacility";
	data.conditions = ["contentJson.SubFacilityID="+subfacility,"size="+2147483647];

	ajaxCallAPI(
			'GET',
			"searchList",
			data,
			function() {
				data = this.get("responseData");
				contentdata = this.get("responseData");
				if (data.error) {
					displayMessage('danger', data.error, 3000);
				} else {
					var responseData = contentdata.content;

					console.log("contentdata : " + JSON.stringify(responseData));
					responseData.forEach(function(layout) {
						console.log(layout);
						getEID(namespace + "seatingCapacity").value = layout.contentJson.SFCapacity;
					});
				}
			}, function() {
				displayMessage('danger',
						"Error in persisting dynamic form data.", 3000);
				callback();
			});
}
function populateFacilityDropDown(elementDrpDwn, data, keyColumn, valueColumn) {
	var placeholder = "Select Facility...";
	if(elementDrpDwn.id === getEID(namespace+"subFacilityName").id ){
		getEID(namespace+"subFacilityName").innerHTML="";
		placeholder = "Select Sub-Facility..."
	}
	var opt = new Option(
			placeholder,
	"");
	elementDrpDwn.options[elementDrpDwn.options.length] = opt;
	for(var i=0; i<data.length; i++) {
		opt = new Option(data[i].contentJson[valueColumn], 
				data[i].contentJson[keyColumn]);
		elementDrpDwn.options[elementDrpDwn.options.length] = opt;
	}
}

function validateFields(action) {
	if (checkIsValide()) {
		submitSeatingLayoutSetup(action);
	}
}

function checkIsValide() {
	var eValid = true;
	if (getEID(namespace + 'facilityType').value.trim() == "") {
		eValid = false;
		displayMessage('danger', "Facility Type is Mandatory", 3000);
	} else if (getEID(namespace + 'facilityName').value.trim() == "") {
		eValid = false;
		displayMessage('danger', "Facility Name is Mandatory", 3000);
	} else if (getEID(namespace + 'subFacilityName').value.trim() == "") {
		eValid = false;
		displayMessage('danger', "Sub Facility Name is Mandatory", 3000);
	} else if (getEID(namespace + 'seatingCapacity').value.trim() == "") {
		eValid = false;
		displayMessage('danger', "Seating Capacity is Mandatory", 3000);
	} else if (getEID(namespace + 'seatingLayoutDescription').value.trim() == "") {
		eValid = false;
		displayMessage('danger', "Seating Layout Description is Mandatory", 3000);
	} else if (getEID(namespace + 'noOfRows').value.trim() == "") {
		eValid = false;
		displayMessage('danger', "No. of Rows is Mandatory", 3000);
	} else if (getEID(namespace + 'noOfColumns').value.trim() == "") {
		eValid = false;
		displayMessage('danger', "No. of Columns is Mandatory", 3000);
	}else if (isNaN(getEID(namespace + 'noOfColumns').value)) {
		eValid = false;
		displayMessage('danger', "No. of Columns should be number", 3000);
	}else if (isNaN(getEID(namespace + 'noOfRows').value)) {
		eValid = false;
		displayMessage('danger', "No. of Rows should be number", 3000);
	}else if (getEID(namespace + 'noOfRows').value.trim()<=0 || getEID(namespace + 'noOfColumns').value.trim() <= 0) {
		eValid = false;
		displayMessage('danger', "Number must be more than zero (0)", 3000);
	}	else if (getEID(namespace + 'noOfRows').value.trim() * getEID(namespace + 'noOfColumns').value.trim() > getEID(namespace + 'seatingCapacity').value.trim() ) {
		eValid = false;
		displayMessage('danger', "Number of Rows x Number of Columns must not exceed Seating Capacity", 3000);
	}  
	
	return eValid;
}

function submitSeatingLayoutSetup(action) {
	showLoading(true);
	var facilityType = getEID(namespace + "facilityType");
	var facilityName = getEID(namespace + "facilityName");
	var subFacilityName = getEID(namespace + "subFacilityName");
	var seatingCapacity = getEID(namespace + "seatingCapacity");
	var seatingLayoutDescription = getEID(namespace + "seatingLayoutDescription");
	var noOfRows=getEID(namespace + "noOfRows");
	var noOfColumns=getEID(namespace + "noOfColumns");
	var validation = getEID("validation");
    var allowToOverrideSeatAutoAssignment = getEID("allowToOverrideSeatAutoAssignment");
	var invigilatorAutoAssignment ;
	var candidateAutoAssignment;
	
	var invigilatorAutoAssignment_radio = document.getElementsByName("data[InvigilatorAutoAssignment][ej019hl]");
    for (var i = 0; i < invigilatorAutoAssignment_radio.length; i++) {
        var button = invigilatorAutoAssignment_radio[i];
        if (button.checked) {
        	invigilatorAutoAssignment = button.value;
        }
    }
    var candidateAutoAssignment_radio = document.getElementsByName("data[CandidateAutoAssignment][ecmhdei]");
    for (var i = 0; i < candidateAutoAssignment_radio.length; i++) {
        var button = candidateAutoAssignment_radio[i];
        if (button.checked) {
        	candidateAutoAssignment = button.value;
        }
    }
    
	var seatplan={};
	//seatplan.SeatingPlanLayoutCode=generateSeatingPlanLayoutCode();
	
	seatplan.FacilityType=facilityType.value;
	seatplan.Facility=facilityName.value;
	seatplan.SubFacility=subFacilityName.value;
	seatplan.FacilityName=facilityName.options[facilityName.selectedIndex].text;
	seatplan.SubFacilityName=subFacilityName.options[subFacilityName.selectedIndex].text;
	seatplan.SeatingCapacity=seatingCapacity.value;
	seatplan.SeatingLayoutDescription=seatingLayoutDescription.value;
	seatplan.NoOfRows=noOfRows.value;
	seatplan.NoOfColumns=noOfColumns.value;
	seatplan.InvigilatorAutoAssignment = invigilatorAutoAssignment;
	seatplan.CandidateSeatAutoAssignment = candidateAutoAssignment;
	seatplan.AllowToOverrideSeatAutoAssignment = allowToOverrideSeatAutoAssignment.checked;
	seatplan.Validation = validation.checked;
	
	
	if(mode=="edit") {
		seatplan.Status = getEID("formStatus").value;
		seatplan.formStorageId = encodeURI(formStorageId);
	} else {
		if (action == "publish") {
			seatplan.Status = "Active";
		} else {
			seatplan.Status = "Draft";
		}
	}
	seatplan.formType = "seatingPlan";
	console.log(seatplan);
	console.log(JSON.stringify(seatplan));
	ajaxCallAPI('POST', 'persist', seatplan, function() {
		let data = this.get("responseData");
		if (data.error) {
			displayMessage('danger', data.error, 3000);
		}
		else if(data.duplicateError!=undefined && data.duplicateError!=""){
			displayMessage('danger', "Seating layout for this faciliy and sub facility is already exists.", 3000);
		} else if (Object.keys(data).length === 0) {
			console.log("data : "+data);
			//displayMessage('danger', 'Form submission failed.', 3000);
		} else {
			console.log(JSON.stringify(data));
			var message = "Form successfully submitted.";
			if (seatplan.Status == "Draft"){
				message = "Record is saved in draft";
				displayMessage('success', message, 3000);
				afterFormSubmissionFormIOForm(seatplan);
			}
			else{
				//loadDataForSeatingPlanInstance(seatplan,data.storageId,mode,seatplan);
				if(mode=="edit"){
					fetchSeatingInstance(seatplan,data.storageId);
				}else{
					loadDataForSeatingPlanInstance(seatplan,data.storageId);
				}
			}
			
		}
		showLoading(false);
	}, function() {
		displayMessage('danger', "Error in persisting dynamic form data.", 3000);
		showLoading(false);
	});
}

function loadDataForSeatingPlanInstance(data,seatingPlanCode){
	console.log("data : " + JSON.stringify(data));
	var instanceModel={};
	
	/*var instanceModel={};
	if(mode == "edit"){
		fetchSeatingInstance(data);
			instanceModel.SeatingPlanInstanceId = SPID;
		
	}else{
		instanceModel.SeatingPlanInstanceId = generateSeatingPlanInstanceCode();
	}*/
	
	console.log("Instance OOOOO = "+ SPID);
	if(SPID == undefined || SPID == ""){
		SPID = generateSeatingPlanInstanceCode();
	}else{
			instanceModel.formStorageId = SPID;
	}
	instanceModel.SeatingPlanInstanceId = SPID
	
	instanceModel.NoOfColumns = data.NoOfColumns;
	instanceModel.NoOfRows = data.NoOfRows;
	instanceModel.AvailSeats = data.NoOfColumns * data.NoOfRows;
	instanceModel.SeatingPlanId = seatingPlanCode;
	instanceModel.FacilityId = data.hasOwnProperty("Facility")?data.Facility:data.FacilityName;
	instanceModel.SubFacilityId = data.hasOwnProperty("SubFacility")?data.SubFacility:data.SubFacilityName;
	instanceModel.DeskNoFormat = "01";
	
	instanceModel.SeatPlanStatus = "UNKNOWN";
	instanceModel.AssignSeatStatus = "UNKNOWN";
	instanceModel.IsTemplate = true;
	//customiseseat.ScheduleId = scheduleCode;
	//customiseseat.AssignCand = assignCand;
	
	
	
	instanceModel.formType = "seatingplaninstance";
	console.log(JSON.stringify(instanceModel));
	ajaxCallAPI('POST', 'persist', instanceModel, function() {
		let data = this.get("responseData");
		if (data.error) {
			displayMessage('danger', data.error, 3000);
		} else if (Object.keys(data).length === 0) {
			console.log("data : "+data);
			//displayMessage('danger', 'Form submission failed.', 3000);
		} else {
			console.log(data.toString());
			
			createSettingTemplate(instanceModel.SeatingPlanInstanceId);
			//var message = "Form successfully submitted.";
		}
		showLoading(false);
	}, function() {
		//displayMessage('danger', "Error in persisting dynamic form data.", 3000);
		showLoading(false);
	});
	
}

function generateSeatingPlanInstanceCode() {
	var date = new Date();
	var now_utc =  Date.UTC(date.getUTCFullYear(), date.getUTCMonth(), date.getUTCDate(),
			 date.getUTCHours(), date.getUTCMinutes(), date.getUTCSeconds());
	return "SPI-"+now_utc;
}

function afterFormSubmissionFormIOForm(data) {
	console.log("data : " + JSON.stringify(data));
	console.log("data.formStorageId : " + data.formStorageId);
	var status = data.Status;
	var formType = "Seating Layout";
	console.log("status : " + status);
	var msg = "";
	var boundingBox = "#sucess-popup";
	var contentBox = "#sucess-popup-box";
	if (status == "Draft") {
		msg = formType + " saved to Draft";
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


function fetchSeatingInstance(modelData,seatingPlanCode,mode){
	data = {};
	data.formType = "seatingplaninstance";
	data.conditions = ["contentJson.FacilityId="+(modelData.hasOwnProperty("Facility")?modelData.Facility:modelData.FacilityName),"contentJson.SubFacilityId="+(modelData.hasOwnProperty("SubFacility")?modelData.SubFacility:modelData.SubFacilityName),"IsTemplate=1"];
	
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
					if(contentdata.hasOwnProperty("content")){
						for(var i=0;i<contentdata.content.length;i++){
							if(contentdata.content[i].contentJson.IsTemplate){
								SPID = contentdata.content[i].storageId;
								seatingPlanInstance = contentdata.content[i].contentJson;
								if(modelData.NoOfColumns<seatingPlanInstance.NoOfColumns || modelData.NoOfRows<seatingPlanInstance.NoOfRows){
									seatingPlanInstance["seatingPlanLayouts"] = [];
								}
								var modelName = "seatingplanlayout";
								var data = {};
								data.formType = modelName;
								data.seatingPlanInstace = seatingPlanInstance.SeatingPlanInstanceId;
								data.actionType = "removedbyinstanceid";
								ajaxCall('GET', 'removeUserAssignedSeat', ajaxUrl, data, function() {

									seatingPlanInstance.formType = "seatingplaninstance";
									seatingPlanInstance.formStorageId = seatingPlanInstance.SeatingPlanInstanceId;
									ajaxCallAPI('POST', 'persist', seatingPlanInstance, function() {
										let data = this.get("responseData");
										if (data.error) {
											displayMessage('danger', data.error, 3000);
										} else if (Object.keys(data).length === 0) {
											console.log("data : "+data);
											//displayMessage('danger', 'Form submission failed.', 3000);
										} else {
											console.log(data.toString());
											createSettingTemplate(seatingPlanInstance.SeatingPlanInstanceId);
											//var message = "Form successfully submitted.";
										}
										showLoading(false);
									}, function() {
										displayMessage('danger', "Error in persisting dynamic form data.", 3000);
										showLoading(false);
									});
								}, function() {

								});
							}
						}
					}
				}
				console.log("data : " + JSON.stringify(responseData));
				//callback(responseData);
			}, function() {
				displayMessage('danger',
						"Error in persisting dynamic form data.", 3000);
				//callback();
			});
}

function enableViewMode() {
	var form = document.getElementById("seatingLayout_form");
	var elements = form.elements;
	for (var i = 0, len = elements.length; i < len; ++i) {
		elements[i].readOnly = true;
		elements[i].disabled = true;
	}
}

function getEID(element) {
	return document.getElementById(element);
}
function showLoading(show) {
	if(show) {
		getEID("loadingDiv").style.display = "block";
	} else {
		getEID("loadingDiv").style.display = "none";
	}
}

function moveToList() {
	window.location.href = baseUrl;
}


function showPopupError(message){
	AUI().use('aui-base', function(A) {
		var boundingBox = "#action-error";
		var contentBox = "#action-error-box";
		document.getElementById("action-error-box").getElementsByClassName("message")[0].innerHTML=message;
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

function showPopupSuccess(status, d) {

	AUI().use('aui-base', function(A) {
		var boundingBox, contentBox;
		if (status.toLowerCase() == 'inactive') {
			boundingBox = "#deactivation-success";
			contentBox = "#inactive-success-box";
		}
		if (status.toLowerCase() == 'active') {
			boundingBox = "#activation-success";
			contentBox = "#active-success-box";
		}
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
			Y.one('.close').on('click', function() {
				modal.hide();
			});
		});

	});
}


function storageStatus1(status, storageId) {
	var popupdiv;
	var popupdivbox;
	if (status == 'Active') {
		popupdiv = "#active-record";
		popupdivbox = "#active-record-box";
		updateStorageStatus1(status, storageId);
	} else if (status == 'Inactive') {
		popupdiv = "#deactive-record";
		popupdivbox = "#deactive-record-box";
		AUI()
				.use(
						'aui-base',
						function(A) {

							A.one(popupdiv).set('hidden', false);

							YUI()
									.use(
											'aui-modal',
											function(Y) {
												var modal = new Y.Modal({
													boundingBox : popupdiv,
													contentBox : popupdivbox,
													headerContent : '',
													centered : true,
													destroyOnHide : false,
													modal : true,
													resizable : false,
													draggable : true,
												}).render();

												Y.one('.close').on('click',
														function() {
															modal.hide();
														});
												Y
														.one(
																'.popup-cancel-deactivate')
														.on(
																'click',
																function() {
																	modal
																			.hide();
																});

												Y
														.one(
																'.popup-confirm-deactivate')
														.on(
																'click',
																function() {

																	if (document
																			.getElementById("deactivate_reason").value.length > 4) {
																		updateStorageStatus1(
																				status,
																				storageId);
																		modal
																				.hide();
																	} else {
																		document
																				.getElementById("deactivate_msg").classList
																				.add("alert");
																		document
																				.getElementById("deactivate_msg").classList
																				.add("alert-error");
																	}

																});

											});

						});
	}

}

function updateStorageStatus1(status, storageId) {
	showLoading(true);
	var inactiveReason = "";
	if (status.toLowerCase() == 'inactive') {
		inactiveReason = document.getElementById("deactivate_reason").value;
	}

	ajaxCall('GET', 'loadData', ajaxUrl, {
		"formType" : "SeatingPlan",
		"formStorageId" : encodeURIComponent(storageId)
	}, function() {
		var data = this.get("responseData");
		if (data == null || data == "") {
			console.log("error");
		} else {
			var data1 = data.contentJson;
			data1.Status = status;
			data1.InactiveReason = inactiveReason;
			data1.formType = "SeatingPlan";
			data1.formStorageId = encodeURIComponent(storageId);
			ajaxCall('GET', 'update', ajaxUrl, data1, function() {
				console.log("hhh");
				var data = this.get("responseData");
				if (_.isEmpty(data)) {
					console.log("error");
					showPopupError("Failed to perform action");
				} else if(data.error && data.error=="inuse"){
					console.log("error1");
					showPopupError(data[Object.keys(data)[0]]);
				} else if(data.errorCode && data.errorCode=="reference-error"){
					console.log("error2");
					showPopupError(data[Object.keys(data)[0]]);
				} else {
					showPopupSuccess(status,storageId);
				}
				showLoading(false);
			}, function() {
				console.log("eee");
				showLoading(false);
			});
		}
	}, function() {
		showLoading(false);
	});
}

function goToEdit() {

	console.log("formStorageId : " + formStorageId);
	AUI().use('liferay-portlet-url', function(A) {
	var e = Liferay.PortletURL.createRenderURL();
	e.options.basePortletURL = baseUrl;
	e.setParameter("jspPage", config.editPage);
	e.setParameter("formTypeName", modelName);
	e.setParameter("storageId", formStorageId);
	e.setPortletId(namespace.replace(/(^\_+|\_+$)/mg, ''));
	e.setWindowState("normal");
	console.log("e : " + e.toString());
	window.location.href = e.toString();
	});
	}