if (document.readyState == 'complete') {
	showLoading(false);
} else {
	window.addEventListener('load', function() {
		showLoading(false);
	}, false);
}
function showLoading(show) {
	if (show) {
		document.getElementById("loadingDiv").style.display = "block";
	} else {
		document.getElementById("loadingDiv").style.display = "none";
	}
}

function getEID(element) {
	return document.getElementById(element);
}

function validateFields(storageId, filterData) {
	debugger;
	if (storageId === null || storageId === undefined) {
		storageId = "-1";
	}
	console.log("storageID :: " + storageId);
	console.log("filterData :: " + decodeURI(filterData));
	if (checkIsValide(storageId)) {
		if (storageId === "-1") {
			submitRecords(storageId, filterData);
		} else {
			submitRecords(storageId, null);
		}

	}
}

function checkIsValide(storageId) {
	debugger;
	var eValid = true;
	if (getEID(namespace + 'timeOutHH').value !== ""
			&& getEID(namespace + 'timeInHH').value !== ""
			&& getEID(namespace + 'timeOutHH').value !== ""
			&& getEID(namespace + 'timeOutMM').value !== "") {
		if ((getEID(namespace + 'timeOutHH').value.trim()) <= getEID(namespace
				+ 'timeInHH').value.trim()) {
			if (getEID(namespace + 'timeOutHH').value.trim() === getEID(namespace
					+ 'timeInHH').value.trim()) {
				if (getEID(namespace + 'timeOutMM').value.trim() <= getEID(namespace
						+ 'timeInMM').value.trim()) {
					eValid = false;
					document.getElementById("saveError").style.display = 'block';
					setTimeout(
							function() {
								document.getElementById("saveError").style.display = 'none';
							}, 10000);

				}
			} else {
				eValid = false;
				document.getElementById("saveError").style.display = 'block';
				setTimeout(
						function() {
							document.getElementById("saveError").style.display = 'none';
						}, 10000);
			}
		}
	}
	return eValid;
}

function submitRecords(storageId, filterData) {
	debugger;
	showLoading(true);

	var timeInHH = getEID(namespace + "timeInHH");
	var timeInMM = getEID(namespace + "timeInMM");
	var timeOutHH = getEID(namespace + "timeOutHH");
	var timeOutMM = getEID(namespace + "timeOutMM");
	var remarks = getEID("remarks");
	if (timeOutHH.value != "" && timeOutMM.value == "") {
		timeOutMM.value = '00';
	}
	var recordHistory = {};
	if (timeInHH.value !== "" && timeInMM.value !== "") {
		recordHistory.TimeIn = timeInHH.value + ":" + timeInMM.value;
	}
	if (timeOutHH.value !== "" && timeInMM.value !== "") {
		recordHistory.TimeOut = timeOutHH.value + ":" + timeOutMM.value;
	}
	if (remarks.value !== "") {
		recordHistory.Remark = remarks.value;
	}
	recordHistory.AttendanceId = storageId;
	recordHistory.formType = "attendance";

	var d = new Date();
	var curr_date = d.getDate();
	var curr_month = d.getMonth() + 1; // Months are zero based
	var curr_year = d.getFullYear();
	console.log(curr_date + "/" + curr_month + "/" + curr_year);
	recordHistory.date = ((curr_date <= 9 ? '0' + curr_date : curr_date) + "/"
			+ (curr_month <= 9 ? '0' + curr_month : curr_month) + "/" + curr_year);

	recordHistory.IsPaymentEligible = isEligible == false ? true : false;
	if (filterData !== null) {
		recordHistory.filterData = decodeURI(filterData);
	}
	console.log(JSON.stringify(recordHistory));
	if (storageId == null) {
		storageId = "-1";
	}
	if (typeof claimTypes !== 'undefined') {
		recordHistory.InvigilationId = claimTypes["INV"];
	}
	recordHistory.formStorageId = storageId;
	ajaxCallAPI('POST', 'persist', recordHistory, function() {
		let
		data = this.get("responseData");
		showLoading(false);
		if (data.error) {
			showLoading(false);
			displayMessage('alert_msg', data.error, 3000);
			return;
		} else if (Object.keys(data).length === 0) {
			console.log("data : " + data);
			showLoading(false);
			displayMessage('alert_msg', 'danger', "Form submission failed.",
					3000);
			return;
		} else {
			console.log(data.toString());
			document.getElementById("saveSuccess").style.display = 'block';
			document.getElementById("saveError").style.display = 'none';
			setTimeout(function() {
				document.getElementById("saveSuccess").style.display = 'none';
			}, 10000);
			savedSuccessfully = true;
		}
		// moveToList();

	},
			function() {
				displayMessage('danger',
						"Error in persisting dynamic form data.", 3000);
				showLoading(false);
			});
}

function submitScannedTime(barcodeData, filterData, modelName) {
	// showLoading(true);
	debugger;
	var recordHistory = {};

	var time = new Date();
	console.log(((time.getHours() <= 9 ? '0' + time.getHours() : time
			.getHours())
			+ ":" + (time.getMinutes() <= 9 ? '0' + time.getMinutes() : time
			.getMinutes())));
	recordHistory.time = ((time.getHours() <= 9 ? '0' + time.getHours() : time
			.getHours())
			+ ":" + (time.getMinutes() <= 9 ? '0' + time.getMinutes() : time
			.getMinutes()));
	var d = new Date();
	var curr_date = d.getDate();
	var curr_month = d.getMonth() + 1; // Months are zero based
	var curr_year = d.getFullYear();
	console.log(curr_date + "/" + curr_month + "/" + curr_year);
	recordHistory.date = ((curr_date <= 9 ? '0' + curr_date : curr_date) + "/"
			+ (curr_month <= 9 ? '0' + curr_month : curr_month) + "/" + curr_year);
	recordHistory.formType = "attendance";
	recordHistory.nric = barcodeData;
	console.log(JSON.stringify({
		contentJson : recordHistory
	}));
	debugger;
	if (filterData !== null) {
		recordHistory["limit"] = 10;
		recordHistory["modelName"] = modelName;
		recordHistory["page"] = 0;
		recordHistory["formType"] = modelName;
		recordHistory["filterData"] = decodeURI(filterData);
	}
	ajaxCallAPI('POST', 'scanedData', recordHistory, function() {
		debugger;
		let
		data = this.get("responseData");
		console.log("data::" + data);
		if (data == 0) {
			showLoading(false);
			displayMessage('danger', "No Data Found For NRIC " + barcodeData, 3000);
			resetBarcodeTextBox();
		} else {

			if (data.error) {
				showLoading(false);
				displayMessage('danger', data.error, 3000);
				resetBarcodeTextBox();

			} else {
				// getBarcode();
				AUI().use(
						'aui-node',
						'aui-io-request',
						'liferay-util-window',
						'aui-io-plugin-deprecated',
						'stylesheet',
						'aui-datepicker',
						'overlay',
						'event',
						'widget-anim',
						function(A1) {
							A = A1;
							var AArray = A.Array;
							sampleRow = A.one("#sampleEntityLinkRow");
							rowContainer = A.one("#entityLinkContainer");
							// document.getElementById("sampleEntityLinkRow")
							var contentToRemove = document
									.querySelectorAll("#sampleEntityLinkRow");
							contentToRemove.forEach(myFunction);

							function myFunction(item, index) {
								item.remove();
							}

							var contentdata;

							/*
							 * data = {}; data.formType = modelName; data.limit =
							 * 100000; data.page = 0; data.modelName= modelName;
							 * console.log("filterData::"+decodeURI(filterData));
							 * data.filterdata = [decodeURI(filterData)];
							 */
							console.log("data::" + data);
							index = 0;
							showLoading(true);
							populateEntityRecords(data);
							/*
							 * ajaxCallAPI('POST', "elastiSearchList", data,
							 * 
							 * function() {
							 * 
							 * debugger; contentdata = this.get("responseData");
							 * var responseData = []; responseData =
							 * contentdata; }, function() {
							 * displayMessage('danger', "Error in persisting
							 * dynamic form data.", 3000); callback(); });
							 */

							debugger;
							function populateEntityRecords(dataList) {
								debugger;
								/*
								 * for (var i = 0; i < dataList.content.length;
								 * i++) {
								 * 
								 * addRowCells(dataList.content[i]); }
								 */
								addRowCells(dataList);

							}

							function addRowCells(dataList) {
								// var facilityId, subFacility;
								debugger;
								var newRow = this.sampleRow.cloneNode(true);

								// gridData[data.storageId] =
								// data.contentJson.notificationStatus;

								newRow.one("#nirc").set('text',
										dataList.contentJson.NRIC);
								newRow.one("#schedule").set('text',
										dataList.contentJson.Schedule);
								newRow.one("#name").set('text',
										dataList.contentJson.Name);
								newRow.one("#timein").set('text',
										dataList.contentJson.TimeIn);
								newRow.one("#timeout").set('text',
										dataList.contentJson.TimeOut);
								newRow.one("#subjectcode").set('text',
										dataList.contentJson.SubjectCode);
								newRow.one("#subfacility").set('text',
										dataList.contentJson.SubFacility);
								show(newRow);
								rowContainer.appendChild(newRow);
								showLoading(false);
							}

							function show(node) {
								if (node) {
									node.removeClass("hide");
								}
							}

							function hide(node) {
								if (node) {
									node.addClass("hide");
								}
							}
						});

				resetBarcodeTextBox();
			}
		}
	}, function() {
		resetBarcodeTextBox();
	});
}

// showLoading(false);

function goBackAttendance(e) {
	debugger;
	console.log("IN goBackAttendance --->");
	// window.history.back();

}

function moveToList() {
	window.history.back();
}

function isEligibleForPayment() {
	isEligible = getEID("isEligible").checked;
}

function saveScannedValue(e, filterData, formTypeName) {
	debugger;
	var value = e.target.value;
	submitScannedTime(e.target.value, filterData, formTypeName);
}

function resetBarcodeTextBox() {
	var el = document.querySelector(".barcode-value");
	el.value = "";
	el.focus();
}

function displayMessage(type, message, duration) {

	scrollToTop();
	var alert_div = document.getElementById("alert_msg");
	console.log("alert_div : " + alert_div);
	alert_div.innerHTML = message;
	alert_div.classList.add("alert-" + type);
	alert_div.style.display = "block";
	setTimeout(function() {
		alert_div.style.display = "none";
	}, duration);
	console.log(message);
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
function doActionPopup(a, d) {
	var c = findAncestor(d, "Row");
	var a = [];
	for (var b = 0; b < c.childElementCount; b++) {
		a.push(c.children[b].textContent.trim())
	}
	console.log("main::::doAction::::::::::::" + a[0]);
	showPaymentSection(a[0]);
}

// function getBarcode() {
//
//
// AUI().use('aui-node', 'aui-io-request', 'liferay-util-window',
// 'aui-io-plugin-deprecated',
// 'stylesheet', 'aui-datepicker', 'overlay', 'event', 'widget-anim',
// function(A1) {
// A = A1;
// var AArray = A.Array;
// sampleRow = A.one("#sampleEntityLinkRow");
// rowContainer = A.one("#entityLinkContainer");
// //document.getElementById("sampleEntityLinkRow")
// var contentToRemove = document.querySelectorAll("#sampleEntityLinkRow");
// contentToRemove.forEach(myFunction);
//
// function myFunction(item, index) {
// item.remove();
// }
//            
// var contentdata;
//
//
// data = {};
// data.formType = modelName;
// data.limit = 100000;
// data.page = 0;
// data.modelName= modelName;
// console.log("filterData::"+decodeURI(filterData));
// data.filterdata = [decodeURI(filterData)];
// console.log("data::"+data);
// index = 0;
// showLoading(true);
// ajaxCallAPI('POST', "elastiSearchList", data,
//
// function() {
//
// debugger;
// contentdata = this.get("responseData");
// var responseData = [];
// responseData = contentdata;
// populateEntityRecords(responseData);
//
// },
// function() {
// displayMessage('danger',
// "Error in persisting dynamic form data.", 3000);
// callback();
// });
//
//            
// function populateEntityRecords(dataList) {
// debugger;
// for (var i = 0; i < dataList.content.length; i++) {
//
// addRowCells(dataList.content[i]);
// }
//
// }
//
//
// function addRowCells(data) {
// //var facilityId, subFacility;
// debugger;
// var newRow = this.sampleRow.cloneNode(true);
//
// //gridData[data.storageId] = data.contentJson.notificationStatus;
//
// newRow.one("#nirc").set('text', data.contentJson.NRIC);
// newRow.one("#schedule").set('text', data.contentJson.Schedule);
// newRow.one("#name").set('text', data.contentJson.Name);
// newRow.one("#timein").set('text', data.contentJson.TimeIn);
// newRow.one("#timeout").set('text', data.contentJson.TimeOut);
// newRow.one("#subjectcode").set('text', data.contentJson.SubjectCode);
// newRow.one("#subfacility").set('text', data.contentJson.SubFacility);
// show(newRow);
// rowContainer.appendChild(newRow);
// showLoading(false);
// }
//
// function show(node) {
// if (node) {
// node.removeClass("hide");
// }
// }
//
// function hide(node) {
// if (node) {
// node.addClass("hide");
// }
// }
// });
//
// }
