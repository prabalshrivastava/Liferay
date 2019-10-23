var departmentHolder = document.getElementById('departmentHolder');
var departmentContainer = document.getElementById('departmentContainer');
var departmentList = [];
var profitCentreList = [];
var data, contentdata;
var profitCentreLoaded = false;
var modelName = "Division";
showLoading(true);
console.log("document.readyState : "+document.readyState);

function init() {
	console.log("onload...");
	console.log("onload - departmentHolder : "+departmentHolder.hasChildNodes());
	profitCentreLoaded = false;
	while (departmentHolder.hasChildNodes()) {
		departmentHolder.removeChild(departmentHolder.lastChild);
	}
	loadDefaultData(function() {
		setInterval(function() {
			checkForm();
		}, 1000);
		console.log("onload - mode : "+mode);
		if (mode == "create") {
			addAnotherDepartment();
		}
	});
}
if(document.readyState == 'complete') {
	init();
} else {
	window.addEventListener('load', init);
}

function loadDefaultData(callback) {
	console.log("loadDefaultData - mode : "+mode);
	loadDropdowns(function() {
		if(profitCentreLoaded == true) {
			if (mode != "create") {
				fetchDetails(formStorageId);
			} else {
				getEID("formStatus").innerHTML = "Draft";
				getEID("formStatus").className = "";
				getEID("formStatus").classList.add("formStatus");
				getEID("formStatus").classList.add("form_draft");
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
		data.formStorageId = formStorageId;
		data.formType = modelName;
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
						var dc = contentdata.contentJson.DivisionCode;
						if (mode == "copy") {
							dc = "Copy-of-" + dc;
						}
						getEID(namespace + "divisionCode").value = dc;
						if(mode=="edit") {
							if(contentdata.contentJson.Status=="Draft") {
								getEID("status").value = "Active";
							} else {
								getEID("status").value = contentdata.contentJson.Status;
							}
						}
						getEID(namespace + "divisionDescription").value = contentdata.contentJson.DivisionDescription;
						if(mode=="view") {
							getEID(namespace + "divisionDescription").value = 
								(contentdata.contentJson.DivisionDescription === "")?"Not Specified":contentdata.contentJson.DivisionDescription;
						} else {
							getEID(namespace + "divisionDescription").value = contentdata.contentJson.DivisionDescription;
						}
						getEID("formStatus").innerHTML = contentdata.contentJson.Status;
						getEID("formStatus").className = "";
						getEID("formStatus").classList.add("formStatus");
						getEID("formStatus").classList.add("form_"+contentdata.contentJson.Status.toLowerCase());
						var departments = contentdata.contentJson.Departments;
						addAllDataToArray();
						for (var i = 0; i < departments.length; i++) {
							var ss = new Department(departments[i].department,
									departments[i].profitCentreId,"Active");
							console.log("ss : "+JSON.stringify(ss));
							departmentList.push(ss);
						}
						drawDepartments();
						if (mode == "edit"
								&& contentdata.contentJson.Status == "Inactive") {
							getEID("activate").style.display = "";
							getEID("deactivate").style.display = "none";
						} else if (mode == "edit") {
							getEID("activate").style.display = "none";
							getEID("deactivate").style.display = "";
							getEID(namespace + "divisionCode").disabled = true;
						}
					}
					if (mode == "view") {
						enableViewMode();
					}
					showLoading(false);
				}, function() {
					displayMessage('danger',
							"Error in persisting dynamic form data.", 3000);
					showLoading(false);
				});
	}
}

function enableViewMode() {
	var form = document.getElementById("divisionForm");
	var elements = form.elements;
	for (var i = 0, len = elements.length; i < len; ++i) {
		elements[i].readOnly = true;
		elements[i].disabled = true;
	}
}

function loadDropdowns(callback) {
	downloadDropdownData("ProfitCentre", function(data) {
		profitCentreList = data;
		profitCentreLoaded = true;
		callback();
	});
}

function downloadDropdownData(model, callback) {
	data = {};
	data.formType = model;
	data.conditions = ["contentJson.Status=Active","size="+2147483647];
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

function Department(department, profitCentreCode, deleteStatus) {
	this.department = department;
	this.profitCentreCode = profitCentreCode;
	this.deleteStatus = deleteStatus;
}

function addAnotherDepartment() {
	console.log("addAnotherDepartment...");
	addAllDataToArray();
	var ss = new Department("", "", "");
	departmentList.push(ss);
	drawDepartments();
}

function removeDepartment(e) {
	var eRmv = e.parentElement.parentElement.parentElement.parentElement;
	eRmv.getElementsByClassName("deleteStatus")[0].innerHTML = "Remove";
	addAllDataToArray();
	drawDepartments();
	if (departmentList.length == 0) {
		addAnotherDepartment();
	}
}

function closeDepartment(closeIcon) {
	var eRmv = closeIcon.parentElement.parentElement.parentElement.parentElement;
	console.log("eRmv : "+eRmv.id);
	var departmentDiv = eRmv.getElementsByClassName("departmentContent")[0];
	if(departmentDiv.style.display!="none") {
		departmentDiv.style.display = "none";
		closeIcon.style.background = "url(/html/images/expand.png) no-repeat";
	} else {
		departmentDiv.style.display = "block";
		closeIcon.style.background = "url(/html/images/close-minus.png) no-repeat";
	}
}

function addAllDataToArray() {
	while (departmentList.length > 0) {
		departmentList.pop();
	}
	var c = departmentHolder.childElementCount;
	for (var i = 0; i < c; i++) {
		var node = departmentHolder.childNodes[i];
		var department = node.getElementsByClassName("department")[0];
		var profitCentreCode = node.getElementsByClassName("profitCentreCode")[0];
		var deleteStatus = node.getElementsByClassName("deleteStatus")[0];
		if (deleteStatus.innerHTML != "Remove") {
			departmentList.push(new Department(department.value, profitCentreCode.value, deleteStatus.innerHTML));
		}
	}
}

function drawDepartments() {
	console.log("drawDepartments...");
	var count = 0;
	var i;
	while (departmentHolder.hasChildNodes()) {
		departmentHolder.removeChild(departmentHolder.lastChild);
	}
	console.log("drawDepartments - departmentList : "+JSON.stringify(departmentList));
	for (i = 0; i < departmentList.length; i++) {
		var node = departmentContainer.cloneNode(true);
		var header = node.getElementsByClassName("header")[0]
				.getElementsByTagName("div")[0];
		var department = node.getElementsByClassName("department")[0];
		var profitCentreCode = node.getElementsByClassName("profitCentreCode")[0];
		
		populateDropDown(profitCentreCode, profitCentreList, "ProfitCentreCode", "ProfitCentreCode");
		
		department.value = departmentList[i].department;
		profitCentreCode.value = departmentList[i].profitCentreCode;
		if(mode=="view") {
			department.value = departmentList[i].department==""?"Not Specified":departmentList[i].department;
			profitCentreCode.value = departmentList[i].profitCentreCode==""?"Not Specified":departmentList[i].profitCentreCode;
		}
		node.getElementsByClassName("deleteStatus")[0].innerHTML = departmentList[i].status;
		console.log("departmentList[i].deleteStatus : "
				+ departmentList[i].deleteStatus);
		if (departmentList[i].deleteStatus != "Remove") {
			count = count + 1;
			if (count <= 9) {
				header.innerText = "0" + count +" DEPARTMENT";
			} else {
				header.innerText = count+" DEPARTMENT";
			}
			node.style.display = "block";
			departmentHolder.appendChild(node);
		}
	}
}

function populateDropDown(elementDrpDwn, data, keyColumn, valueColumn) {
	for(var i=0; i<data.length; i++) {
		var opt = new Option(data[i].contentJson[valueColumn], 
				data[i].contentJson[keyColumn]);
		elementDrpDwn.options[elementDrpDwn.options.length] = opt;
	}
}

function checkForm() {
	if (document.getElementById(namespace + "divisionCode").value.trim() != ""
			&& document.getElementById(namespace + "divisionDescription").value.trim() != "") {
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

function validateFields(action) {
	if (checkIsValide()) {
		submitDivision(action);
	}
}

function checkIsValide() {
	var eValid = true;
	addAllDataToArray();
	if (getEID(namespace + 'divisionCode').value.trim() == "") {
		eValid = false;
		displayMessage('danger', "Division code is Mandatory", 3000);
	} else if (getEID(namespace + 'divisionDescription').value.trim() == "") {
		eValid = false;
		displayMessage('danger', "Division description is Mandatory", 3000);
	} else if (getEID(namespace + 'divisionCode').value.trim().length > 50) {
		eValid = false;
		displayMessage('danger', "Division Code must be shorter than 51 characters.", 3000);
	} else if (getEID(namespace + 'divisionDescription').value.trim().length > 100) {
		eValid = false;
		displayMessage('danger', "Description must be shorter than 101 characters.", 3000);
	} else {
		var dep = "";
		for (var i = 0; i < departmentList.length; i++) {
			console.log("departmentList[i].department.trim().length : "+departmentList[i].department.trim().length);
			if (departmentList[i].department == "") {
				eValid = false;
				displayMessage('danger', "Department is Mandatory", 3000);
				break;
			} else if (departmentList[i].profitCentreCode == "") {
				eValid = false;
				displayMessage('danger', "Profit Centre Code is Mandatory", 3000);
				break;
			} else if (departmentList[i].department.trim().length > 50) {
				eValid = false;
				displayMessage('danger', "Department must be shorter than 51 characters.", 3000);
			} else if(dep==departmentList[i].department.trim()) {
				eValid = false;
				displayMessage('danger', "Duplicate records for department.", 3000);
			} else if(dep!=departmentList[i].department.trim()) {
				dep = departmentList[i].department.trim();
			}
		}
	}
	return eValid;
}

function submitDivision(action) {
	showLoading(true);
	var divisionCode = getEID(namespace + "divisionCode");
	var divisionDescription = getEID(namespace + "divisionDescription");
	var division = {};
	division.DivisionCode = divisionCode.value.trim().replace(/\s+/g, '-');
	division.DivisionDescription = divisionDescription.value.trim();
	division.Departments = [];
	for (var i = 0; i < departmentList.length; i++) {
		var department = {};
		var departmentData = departmentList[i];
		department.department = departmentData.department;
		department.profitCentreId = departmentData.profitCentreCode;
		division.Departments.push(department);
	}
	if(mode=="edit") {
		division.Status = getEID("status").value;
		division.formStorageId = formStorageId;
	} else {
		if (action == "publish") {
			division.Status = "Active";
		} else {
			division.Status = "Draft";
		}
	}
	division.formType = modelName;
	console.log(JSON.stringify(division));
	ajaxCallAPI('POST', 'persist', division, function() {
		let data = this.get("responseData");
		if (data.error) {
			displayMessage('danger', data.error, 3000);
		} else if (Object.keys(data).length === 0) {
			console.log("data : "+data);
			displayMessage('danger', 'Form submission failed.', 3000);
		} else {
			console.log(data.toString());
			var message = "Form successfully submitted.";
			if (division.Status == "Draft")
				message = "Record is saved in draft";
			displayMessage('success', message, 3000);
			afterFormSubmissionFormIOForm(division);
		}
		showLoading(false);
	}, function() {
		displayMessage('danger', "Error in persisting dynamic form data.", 3000);
		showLoading(false);
	});
}

function afterFormSubmissionFormIOForm(data) {
	console.log("data : " + JSON.stringify(data));
	console.log("data.formStorageId : " + data.formStorageId);
	var status = data.Status;
	var formType = modelName;
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
		"formType" : modelName,
		"formStorageId" : encodeURIComponent(storageId)
	}, function() {
		var data = this.get("responseData");
		if (data == null || data == "") {
			console.log("error");
		} else {
			var data1 = data.contentJson;
			data1.Status = status;
			data1.InactiveReason = inactiveReason;
			data1.formType = modelName;
			data1.formStorageId = encodeURIComponent(storageId);
			ajaxCall('GET', 'update', ajaxUrl, data1, function() {
				console.log("hhh");
				var data = this.get("responseData");
				if (_.isEmpty(data)) {
					console.log("error");
				} else {
					showPopupSuccess(status, storageId);
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

//=============

function reset() {
	document.getElementById("divisionForm").reset();
}

function getEID(element) {
	return document.getElementById(element);
}

function showAlertDiv(msg) {
	var showAlertDiv = getEID('form-error-div');
	var errorDiv = getEID('error_msg');
	showAlertDiv.style.display = "block";
	errorDiv.innerHTML = msg;
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

