var modal;
var mode;
var isSaved = false;
var planList;
var formStorageId = "";
var ajaxResponse = "";
function addNew(status) {
	var plan;
	if (inp_id.value == "") {
		inp_id.value = "";
		plan = new Plan(inp_id.value, formHolidayDate, inp_desc.value, inp_exam_body.value,
				inp_country.value, inp_year.value, "HolidayCalendar", status);
		//plan.Status = status;
		mode = "create";
		ajaxCallAPI('POST', 'persist', plan,
				function() {
					var data = this.get("responseData");
					
					if (data.error) {
						displayMessage('danger', data.error, 3000);
					} else {
						isSaved = true;
						
						modal.hide();
						setTimeout(function(){ fetchHolidays();}, 1000);
						
						displayMessage('success',
								'Form successfully submitted.', 3000);
					}
				}, function() {
					displayMessage('danger',
							"Error in persisting dynamic form data.", 3000);
				});

	} else {
	
		for (var i = 0; i < planList.length; i++) {
			if (planList[i].formStorageId == inp_id.value) {

				plan = new Plan(encodeURIComponent(inp_id.value),
						inp_date.value, inp_desc.value,inp_exam_body.value, inp_country.value,
						inp_year.value, "HolidayCalendar", status);
			}
		}
		mode = "edit";
		ajaxCallAPI(
				'POST',
				'persist',
				plan,
				function() {
					var data = this.get("responseData");
					if (data.error) {
						displayMessage('danger', data.error, 3000);
					} else {
						isSaved = true;
						modal.hide();
						setTimeout(function(){ fetchHolidays();}, 1000);
						displayMessage('success',
								'Form successfully submitted.', 3000);
					}
				}, function() {
					displayMessage('danger',
							"Error in persisting dynamic form data.", 3000);
				});
	}
}

function drawTable() {
	var i;
	var rowCount = tbody.rows.length;
	for (i = rowCount - 1; i >= 0; i--) {
		tbody.deleteRow(i);
	}
	for (i = 0; i < planList.length; i++) {
		var tr = tr_base.cloneNode(true);
		tr.style.display = "";
		var v_date = tr.getElementsByClassName("v_date")[0];
		var v_desc = tr.getElementsByClassName("v_desc")[0];
		//var v_exmBody = tr.getElementsByClassName("v_exmBody")[0];
		var v_status = tr.getElementsByClassName("v_status")[0];

		var b_edit = tr.getElementsByClassName("b_edit")[0];
		var v_id_row = tr.getElementsByClassName("v_id_row")[0];
		v_date.style.display = "block";
		v_desc.style.display = "block";
		//v_exmBody.style.display = "block";
		if (!readOnly)
			b_edit.style.display = "block";
		v_date.innerHTML = planList[i].Date;
		v_desc.innerHTML = planList[i].Description;
		//v_exmBody.innerHTML = planList[i].ExamBody;
		v_status.innerHTML = planList[i].Status;
		v_id_row.innerHTML = planList[i].formStorageId;
		if (formStorageId == planList[i].formStorageId && !isSaved) {

			editRow(tr.getElementsByClassName("b_edit")[0]);
			if (mode == "copy") {
				inp_id.value = "";
			}
		}
		tbody.appendChild(tr);
	}

}

function DeactivationPopUp(status) {
	
	var stats = "Inactive"
	DeactivateReason();
	//DeactivationPopUp(status);
	//addNew(status);
	//editFormIoPage();
}
function Reactivation() {
	var stats = "Active";
	addNew(stats);
	ReactivationConfirm();

}

function ReactivationConfirm() {
	modal.hide();
	var boundingBox = '#activation-success1';
	var contentBox = '#active-success-box1';
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
				reload();
				//modal.hide();
				//DeactivateReason();
			});
		});
	});
}
function cancelbtn() {
	var boundingBox = '#deactive-record1';
	var contentBox = '#deactive-record-box1';
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
				reload();
				//modal.hide();
				//DeactivateReason();
			});
		});
	});
}

function backtolist() {
	window.location = holidayCalendarListing;
}
function confirm() {
	var status = "Inactive";
	addNew(status);
	modal.hide();
	DeactivationSucess();
}

function DeactivationSucess() {	
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

function fetchHolidays() {
	
	var d = new Date();
	var n = d.getFullYear();
	if (inp_country.value != "" && inp_year.value != ""
			&& inp_year.value.length == 4) {
		
		if (inp_year.value != "" && inp_year.value < n) {
			document.getElementById("addNewDiv").style.display = "none";
		} else {
			document.getElementById("addNewDiv").style.display = "block";
		}
		
		var p = {};
		p.formStorageId = "";
		p.formType = "holidaycalendar";
		p.limit = 1000;
		p.filterdata = [];
		p.conditions = [];
		p.sortby = [];
//		{"limit":"10","modelName":"TaxCode","page":0,"formType":"TaxCode","filterdata":[{"contentJson.Status":["Active"]}],"conditions":[],"sortby":[]}

		ajaxCallAPI('GET', 'elastiSearchList', p, function() {
			var data = this.get("responseData");
			if (data.error) {
				displayMessage('danger', data.error, 3000);
			} else {
				planList = [];
				for (var i = 0; i < data.content.length; i++) {
					var contentJson = data.content[i].contentJson;
					var examBody = (contentJson.hasOwnProperty('ExamBody')) ? contentJson.ExamBody : "";
					if (contentJson.Country == inp_country.value
							&& contentJson.Year == inp_year.value &&
							(inp_exam_body.value==""||examBody==inp_exam_body.value)) {
						
						var uDate=dbDateToUserDateConverter(contentJson.Date);
						
						var p = new Plan(data.content[i].storageId,
								uDate, contentJson.Description, examBody,
								contentJson.Country, contentJson.Year,
								contentJson.formType, contentJson.Status);
						planList.push(p);

					}
				}

				document.getElementById("modal").style.display = "none";
				drawTable();
				//document.getElementById("addNewDiv").style.display="block";								
			}
		}, function() {
			displayMessage('danger', "Error in persisting dynamic form data.",
					3000);

		});
	}
}
function editRow(e) {
	if (inp_year.value != "" && inp_country.value != "") {
		isSaved = false;
		var tbl = e.parentElement.parentElement;
		var v_date = tbl.getElementsByClassName("v_date")[0];
		var v_desc = tbl.getElementsByClassName("v_desc")[0];
		var v_exmBody = tbl.getElementsByClassName("v_exmBody")[0];
		var v_status = tbl.getElementsByClassName("v_status")[0];

		var v_id_row = tbl.getElementsByClassName("v_id_row")[0];
		inp_id.value = v_id_row.innerHTML;
		inp_date.value = v_date.innerHTML;

		var data = v_status.innerHTML;
		if(mode=="copy")
			{
			  var data = document.getElementById('formStatus');
			  data.textContent = 'Draft';
			}
		if (data == "Active" && mode != "copy") {
			document.getElementById("deactivate").removeAttribute('style');
			//var data = document.getElementById('addanother');
			//data.style.display = 'none';
		}
		if (data == "Inactive" && mode != "copy") {
			document.getElementById("reactivate").removeAttribute('style');
			//var data = document.getElementById('addanother');
			// data.style.display = 'none';
		}
		
		if (mode == "edit" && data == "Active") {
			document.getElementById("deactivate").removeAttribute('style');
		}
		if (mode == "edit" && data == "Inactive") {
			document.getElementById("reactivate").removeAttribute('style');
		}
		if (mode == "copy") {
			inp_desc.value = "Copy-of-" + v_desc.innerHTML;
			inp_date.disabled = false;
		} else {
			inp_desc.value = v_desc.innerHTML;
			inp_date.disabled = true;
		}

//		var save=document.getElementById("save");
//		save.innerHTML="Update";
		AUI().use('aui-base', function(A) {

			A.one("#modalBox").set('hidden', false);

			YUI().use('aui-modal', function(Y) {
				modal = new Y.Modal({
					boundingBox : '#modalBox',
					contentBox : '#modalContent',
					headerContent : '',
					centered : true,
					destroyOnHide : false,
					modal : true,
					width : 765,
					resizable : false,
					draggable : true,
				}).render();

				Y.one('.close').on('click', function() {
					modal.hide();
				});
			});

		});
	}
}
function showRecord() {

}

function Plan(formStorageId, date, desc, exmBody, country, year, formType, status) {
	this.formStorageId = formStorageId;
	this.Date = date;
	this.Description = desc;
	this.ExamBody = exmBody;
	this.Country = country;
	this.Year = year;
	this.formType = formType;
	this.Status = status;
}

function unhide(id) {
	var e = document.getElementById(id);
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

function validatevalue() {	
	var yearvalue =  document.getElementById('inp_year');
	if (yearvalue.value != "") {
		var e = document.getElementById('inp_year');
		var r = e.parentElement.parentElement;
		r.children[2].classList.add('hide');
	}
	
}

function showAddNewPopup() {
	if (inp_year.value != "" && inp_country.value != "") 
	 {
		var yearvalue =  document.getElementById('inp_year');
		inp_date.disabled = false;
		inp_id.value = "";
		inp_date.value = "";
		inp_desc.value = "";
		var data = document.getElementById('formStatus');
		data.textContent = 'Draft';
		//var save=document.getElementById("save");
		//save.innerHTML="Save";
		document.getElementById("draft").removeAttribute('style');
		//document.getElementById("reactivate").setAttribute('style',
		//	"display:none");
		document.getElementById("edit").setAttribute('style', "display:none");
		document.getElementById("deactivate").setAttribute('style',
				"display:none");
		document.getElementById("clear").removeAttribute('style');
		document.getElementById("save").removeAttribute('style');
		
		AUI().use('aui-base', function(A) {

			A.one("#modalBox").set('hidden', false);
			//A.one("#modalBox").width(760);

			YUI().use('aui-modal', function(Y) {
				modal = new Y.Modal({
					boundingBox : '#modalBox',
					contentBox : '#modalContent',
					headerContent : '',
					centered : true,
					destroyOnHide : false,
					modal : true,
					width : 765,
					resizable : false,
					draggable : false,
				}).render();

				Y.one('.close').on('click', function() {
					modal.hide();
				});
			});

		});
	 
	}else{
		selected_1 = unhide("inp_year");
	}
}

function DeactivateReason() {
	modal.hide();
	var boundingBox = '#deactive-record1';
	var contentBox = '#deactive-record-box1';
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

function fetchDetails(formStorageId, readonly) {
	if (formStorageId != "") {
		var data = {};
		data.formStorageId = encodeURIComponent(formStorageId);
		data.formType = "holidaycalendar";
		ajaxCallAPI(
				'GET',
				"loadData",
				data,
				function() {
					var data = this.get("responseData");
					if (data.error) {
						displayMessage('danger', data.error, 3000);
					} else {
						inp_year.value = data.contentJson.Year;

						document.getElementById("formStatus").innerText = data.contentJson.Status;
						if (data.contentJson.Status == "active"
								|| data.contentJson.Status == "Active") {
							document.getElementById("deactivate")
									.removeAttribute('style');
						}
						if(mode=="copy")
							{
								var _data = document.getElementById("deactivate")
								_data.style.display="none";
							}
						if (data.contentJson.Status == "Inactive") {
							document.getElementById("reactivate")
									.removeAttribute('style');
						}
						for (var i = 0; i < inp_country.options.length; i++) {
							if (inp_country.options[i].text == data.contentJson.Country) {
								inp_country.selectedIndex = i;
								break;
							}
						}
						for (var i = 0; i < inp_exam_body.options.length; i++) {
							if (inp_exam_body.options[i].text == data.contentJson.ExamBody) {
								inp_exam_body.selectedIndex = i;
								break;
							}
						}
						fetchHolidays();
					}
				}, function() {
					displayMessage('danger',
							"Error in persisting dynamic form data.", 3000);
					// thisInstance.debug("Error in persisting dynamic form data.");
				});
	}

}
function getCountriesList() {
	var ajaxUrl = countryListUrl;
	AUI()
			.use(
					'aui-io-request-deprecated',
					'aui-base',
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
													var responseData = this
															.get('responseData');

													var select = document
															.getElementById("inp_country");
													for (var i = 0; i < responseData.length; i++) {
														select.options[select.options.length] = new Option(
																responseData[i].nameCurrentValue,
																responseData[i].nameCurrentValue);
														if (select.options[i].text == "Singapore") {
															select.selectedIndex = i;
														}
													}

													fetchDetails(formStorageId,
															readOnly);
												},
												failure : function() {

												}
											}
										});
					});
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
													for (var i = 0; i < responseData.length; i++) {
														var opt = new Option( responseData[i].name,
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


function showAlertDiv(msg) {

	var alert_div = document.getElementById("alert_msg-popup");
	alert_div.innerHTML = msg;
	alert_div.classList.add("alert-");
	alert_div.style.display = "block";
	setTimeout(function() {
		hideAlert();
	}, 2000);
}
function hideAlert() {
	document.getElementById('alert_msg-popup').style.display = "none";
}

function storageStatus(status, d) {
	var popupdiv, popupdivbox;
	if (status == 'Active' || status == 'active') {
		popupdiv = "#active-record";
		popupdivbox = "#active-record-box";
		updateStorageStatus(status, d);
	} else if (status == 'Inactive') {

		popupdiv = "#deactive-record";
		popupdivbox = "#deactive-record-box";
		AUI().use('aui-base', function(A) {

			A.one(popupdiv).set('hidden', false);

			YUI().use('aui-modal', function(Y) {
				modal = new Y.Modal({
					boundingBox : popupdiv,
					contentBox : popupdivbox,
					headerContent : '',
					centered : true,
					destroyOnHide : false,
					modal : true,
					resizable : false,
					draggable : true,
				}).render();

				Y.one('.close').on('click', function() {
					modal.hide();
				});
				Y.one('.popup-confirm-deactivate').on('click', function() {
					updateStorageStatus(status, d);
					modal.hide();
				});

			});

		});
	}

}
function updateStorageStatus(status, d) {
	var c = findAncestor(d, "Row");
	var a = [];
	for (var b = 0; b < c.childElementCount; b++) {
		a.push(c.children[b].textContent.trim())
	}
	ajaxCall('GET', 'loadData', ajaxurl, {
		"formType" : modelName,
		"formStorageId" : a[0]
	}, function() {
		
		var data = this.get("responseData");
		// if (_.isEmpty(data)) {
		if (data.error) {
			console.log("error");

		} else {
			var data1 = data.contentJson;
			data1.Status = status;
			data1.formType = modelName;
			data1.formStorageId = a[0];

			ajaxCall('GET', 'update', ajaxurl, data1, function() {
				var data = this.get("responseData");
				// if (_.isEmpty(data)) {
				if (data.error) {
					console.log("error");
					showPopupSuccess(status, d);
				} else {
					showPopupSuccess(status, d);
				}
			}, function() {

			});
		}
	}, function() {

	});
}

function editHoliday() {
	editFormIoPage();
}

var boundingBox, contentBox;
function showPopupSuccess(status, d) {

	AUI().use('aui-base', function(A) {
		if (status == 'Inactive') {
			boundingBox = "#deactivation-success1";
			contentBox = "#inactive-success-box1";
		}
		if (status == 'Active') {
			boundingBox = "#activation-success";
			contentBox = "#active-success-box";
		}
		A.one(boundingBox).set('hidden', false);

		YUI().use('aui-modal', function(Y) {
			modal = new Y.Modal({
				boundingBox : boundingBox,
				contentBox : contentBox,
				headerContent : '',
				centered : true,
				destroyOnHide : false,
				modal : true,
				resizable : false,
				draggable : true,
			}).render();

			Y.one('.close').on('click', function() {
				modal.hide();
			});
		});

	});
}
var boundingBox1, contentBox1;
function DeactivationPopUp1(status) {
	modal.hide();
	AUI().use('aui-base', function(A) {
		if (status == 'Inactive') {
			boundingBox1 = "#deactivation-success1";
			contentBox1 = "#inactive-success-box1";
		}
		if (status == 'Active') {
			boundingBox1 = "#activation-success1";
			contentBox1 = "#active-success-box1";
		}
		A.one(boundingBox1).set('hidden', false);
		modal.hide();
		YUI().use('aui-modal', function(Y) {
			modal = new Y.Modal({
				boundingBox : boundingBox1,
				contentBox : contentBox1,
				headerContent : '',
				centered : true,
				destroyOnHide : false,
				modal : true,
				resizable : false,
				draggable : true,
			}).render();

			Y.one('.close').on('click', function() {
				modal.hide();
			});
		});

	});
}

function archiveStorage(d) {

	AUI().use('aui-base', function(A) {
		var boundingBox = "#archive-record";
		var contentBox = "#archive-record-box";
		A.one(boundingBox).set('hidden', false);

		YUI().use('aui-modal', function(Y) {
			modal = new Y.Modal({
				boundingBox : boundingBox,
				contentBox : contentBox,
				headerContent : '',
				centered : true,
				destroyOnHide : false,
				modal : true,
				resizable : false,
				draggable : true,
			}).render();

			Y.one('.close').on('click', function() {
				modal.hide();
			});
			Y.one('.popup-confirm-archive').on('click', function() {
				var c = findAncestor(d, "Row");
				var a = [];
				for (var b = 0; b < c.childElementCount; b++) {
					a.push(c.children[b].textContent.trim())
				}
				var data = {
					"formType" : modelName,
					"formStorageId" : a[0]
				};
				ajaxCall('GET', 'archive', ajaxurl, data, function() {
					var data = this.get("responseData");
					if (_.isEmpty(data)) {
						console.log("error");
					}
				}, function() {

				});
				modal.hide();
			});
		});

	});
	
	function DuplicatePopUp1(status) {
		modal.hide();
		AUI().use('aui-base', function(A) {
			
			boundingBox1 = "#deactivation-success1";
			contentBox1 = "#inactive-success-box1";
			
			A.one(boundingBox1).set('hidden', false);
			modal.hide();
			YUI().use('aui-modal', function(Y) {
				modal = new Y.Modal({
					boundingBox : boundingBox1,
					contentBox : contentBox1,
					headerContent : '',
					centered : true,
					destroyOnHide : false,
					modal : true,
					resizable : false,
					draggable : true,
				}).render();

				Y.one('.close').on('click', function() {
					modal.hide();
				});
			});

		});
	}
}
function handleEnter(e){
    var keycode = (e.keyCode ? e.keyCode : e.which);
    if (keycode == '13') {
    	event.preventDefault();
    	fetchHolidays();
    }
}
function dbDateToUserDateConverter(dbDate){
	var today = new Date(dbDate);
	if(today.toString() != "Invalid Date"){
		var dd = String(today.getDate()).padStart(2, '0');
		var mm = String(today.getMonth() + 1).padStart(2, '0'); //January is 0!
		var yyyy = today.getFullYear();
		return dd + '/' + mm + '/' + yyyy;
	}
	return dbDate;
	
}