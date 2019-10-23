showLoading(true);
if(document.readyState == 'complete') {
	init();
} else {
	window.addEventListener('load', init);
}

function showLoading(show) {
	if(show) {
		getEID("loadingDiv").style.display = "block";
	} else {
		getEID("loadingDiv").style.display = "none";
	}
}

function getEID(element) {
	return document.getElementById(element);
}

var organizationMap = {};

function init(){
	/*for(var i=0; i <organizationList.length; i++){
		organizationMap[organizationList[i].organizationId] = organizationList[i];
	}*/
	showLoading(false);
	fetchReportType();
	getEID(namespace+"due-date-colId").style.display = "none";
	getEID(namespace+"organisation-colId").style.display = "none";
}

function fetchReportType(){
	showLoading(true);
	var data = {};
	data.formType = "report"
	ajaxCallAPI(
			'GET',
			'fetchReportType',
			data,
			function() {
				data = this.get("responseData");
				if (data.error) {
					displayMessage('danger', data.error, 3000);
					showLoading(false);
				} else {
					populateReportType(data);
					populateVocabularyDropDown('organisationId',organizationList, 'organizationId', 'name', function(){
					});
					populateCommonDropdownData("regulationType",regulationTypeMap, function() {});
					populateCommonDropdownData("examBody",productSubTypeMap, function() {});
					
				}
			}, function() {
				displayMessage('danger', "Error in processing record.", 3000);
				showLoading(false);
			});
}

function populateVocabularyDropDown(dropdownId, data, keyColumn, valueColumn, callback) {
	organizationMap = {};
	var elementDrpDwn = getEID(namespace + dropdownId);
	for(var i=0; i<data.length; i++) {
		organizationMap[data[i][keyColumn]] = data[i];
		var opt = new Option(data[i][valueColumn],data[i][keyColumn]);
		elementDrpDwn.options[elementDrpDwn.options.length] = opt;
	}
	callback();
}

function populateReportType(data) {
	var reportType = getEID(namespace+"reportType");
	getEID(namespace+"reportType").innerHTML="";
	var opt = new Option(
			"Select Report Type...",
			"");
	reportType.options[reportType.options.length] = opt;
	for (var j = 0; j < data.length; j++) {
		if(data[j] != "Unknown"){
			var option = new Option(data[j],data[j]);
			reportType.options[reportType.options.length] = option;
		}
		
	}
	showLoading(false);
}

function reportChange(ele){
	if(ele.value=="Statement of Account Report"){
		getEID(namespace+"due-date-colId").style.display = "block";
		getEID(namespace+"organisation-colId").style.display = "block";
		getEID(namespace+"start-date-colId").style.display = "none";
		getEID(namespace+"end-date-colId").style.display = "none";
		getEID(namespace+"exam-body-colId").style.display = "none";
		getEID(namespace+"regulation-type-colId").style.display = "none";
	}else{
		getEID(namespace+"exam-body-colId").style.display = "block";
		getEID(namespace+"due-date-colId").style.display = "none";
		getEID(namespace+"organisation-colId").style.display = "none";
		getEID(namespace+"start-date-colId").style.display = "block";
		getEID(namespace+"end-date-colId").style.display = "block";
	}
	if(ele.value=="Statement Of Fees Report" || ele.value=="Statement Of Collection Report") {
		getEID(namespace+"regulation-type-colId").style.display = "block";
	} else {
		getEID(namespace+"regulation-type-colId").style.display = "none";
	}
}

function validateField(reportEnum){
	var eValid = true;
	if(reportEnum == "" && getEID(namespace + 'reportType').value.trim() == ""){
		eValid = false;
		_displayMessage('danger', "Report Type is Mandatory", 3000);
	}else if(reportEnum == "Statement of Account Report" && 
			getEID(namespace + 'dueDate').value.trim() == ""){
		eValid = false;
		_displayMessage('danger', "Date is Mandatory", 3000);
	}else if (reportEnum != "Statement of Account Report" && 
			getEID(namespace + 'startDate').value.trim() == "") {
		eValid = false;
		_displayMessage('danger', "Start Date is Mandatory", 3000);
	} else if (reportEnum != "Statement of Account Report" && 
			getEID(namespace + 'endDate').value.trim() == "") {
		eValid = false;
		_displayMessage('danger', "End Date is Mandatory", 3000);
	}else if (getEID(namespace + 'examBody') && 
			getEID(namespace + 'examBody').offsetParent!=null &&
			getEID(namespace + 'examBody').value.trim() == "") {
		eValid = false;
		_displayMessage('danger', "Exam body is Mandatory", 3000);
	} 
	console.log(eValid)
	return eValid;
}

function _displayMessage(type, message, duration) {
	scrollToTop();
	var alert_div = getEID("alert_msg_id");
	alert_div.innerHTML = message;
	alert_div.classList.add("alert-" + type);
	alert_div.style.display = "block";
	setTimeout(function() {
		alert_div.style.display = "none";
	}, duration);
}

function generateReport(){
	var reportDto = {};
	reportDto.reportEnum = getEID(namespace + "reportType").value;
	reportDto.categoryType = categoryMap["RE"];
	reportDto.sourceType = sourceType["OP"];
	reportDto.categoryMap = categoryMap;
	reportDto = setDateDetail(reportDto);
	reportDto = setOtherDetails(reportDto);
	if(validateField(reportDto.reportEnum)){
		switch(reportDto.reportEnum){
			case "Credit Note Report":	
				reportDto.categoryType = categoryMap["CN"];
				generatePDF(reportDto);
				break;
				
			case "Other Fees Report":
				reportDto.designation = designation;
				reportDto.amountType = "Misc Fee";
				generatePDF(reportDto);
				break;
				
			case "Statement of Account Report":
				console.log("Inside This ");
				reportDto = setDueDate(reportDto);
				reportDto.categoryType = categoryMap["IN"];
				var organisationId = getEID(namespace + "organisationId").value
				console.log(" organisationId ==== ");
				console.log(organisationId);
				if(organisationId != null && organisationId != ""){
					console.log("IF");
					var list = [];
					list.push(organisationId);
					reportDto.organizationIds = list;
					var map = {};
					map[organisationId] = JSON.stringify(organizationMap[organisationId]);
					reportDto.organizationDetailMap = map;
					generatePDF(reportDto);
				}else{
					console.log("ELSE");
					getOrganizationIds(reportDto);
				}								
				break;
			case "List of Overpayment Report":
				
				getReportPdfData(reportDto);
				break;	
			default: generatePDF(reportDto);
		}
		
	}
}

function getReportPdfData(reportDto){
	console.log("getReportPdfData **** ");
	var data = {};
	data.formType = "report";
	data.reportDto = reportDto;
	ajaxCallAPI(
			'POST',
			'getReportPdfData',
			data,
			function() {
				data = this.get("responseData");
				if (data.error) {
					displayMessage('danger', data.error, 3000);
				} else {
					if(data != null){
						reportDto.reportPDF = data;
						generatePDF(reportDto)
					}
					
				}
				showLoading(false);
			}, function() {
				displayMessage('danger', "Error in processing record.", 3000);
				showLoading(false);
			});
}

function getOrganizationIds(reportDto){
	console.log("getOrganizationIds **** ");
	var data = {};
	data.formType = "report";
	data.reportDto = reportDto;
	ajaxCallAPI(
			'POST',
			'fetchOrganizationIds',
			data,
			function() {
				data = this.get("responseData");
				if (data.error) {
					displayMessage('danger', data.error, 3000);
				} else {
					if(data != null){
						reportDto.organizationIds = data;
						var map = {};
						for(var i=0;i<data.length;i++){
							map[data[i]] = JSON.stringify(organizationMap[data[i]]);
						}
						reportDto.organizationDetailMap = map;
						console.log(reportDto);
						generateZipPDF(reportDto)
					}else{
						displayMessage('danger', "No organization have due balance", 3000);
					}
					
				}
				showLoading(false);
			}, function() {
				displayMessage('danger', "Error in processing record.", 3000);
				showLoading(false);
			});
}

function setDueDate(reportDto){
	reportDto.date =  getEID(namespace + "dueDate").value;
	reportDto.date = stringToDate(reportDto.date, "dd/mm/yyyy", "/");
	return reportDto;
}

function setOtherDetails(reportDto){
	var ebEle = getEID(namespace + "examBody");
	if(ebEle) {
		reportDto.productSubType = ebEle.value;
		reportDto.examBody = ebEle.options[ebEle.selectedIndex].text;
	}
	var rtEle = getEID(namespace + "regulationType");
	if(rtEle) {
		reportDto.regulationType = rtEle.value;
		reportDto.regulationTypeString = rtEle.options[rtEle.selectedIndex].text;
	}
	reportDto.userName = userName;
	reportDto.creditCategory = categoryMap["CN"];
	return reportDto;
}

function setDateDetail(reportDto){
	reportDto.from =  getEID(namespace + "startDate").value;
	reportDto.from = stringToDate(reportDto.from, "dd/mm/yyyy", "/");
	reportDto.to = getEID(namespace + "endDate").value;
	reportDto.to = stringToDate(reportDto.to, "dd/mm/yyyy", "/");
	return reportDto;
}


function generatePDF(reportDto){
	var data = {};
	data.formType = "report";
	data.reportDto = reportDto;
	ajaxCallAPI(
			'POST',
			'generateReport',
			data,
			function() {
				data = this.get("responseData");
				if (data.error) {
					displayMessage('danger', data.error, 3000);
				} else {
					let responseText = this.get("responseData");
					window.open(downloadPdfUrl+"&"+namespace+"filePath="+encodeURIComponent(responseText));
				}
				showLoading(false);
			}, function() {
				displayMessage('danger', "Error in processing record.", 3000);
				showLoading(false);
			});
}

function generateZipPDF(reportDto){
	var data = {};
	data.formType = "report";
	data.reportDto = reportDto;
	// window.open(exportPdfUrl + "&" + namespace + "formType=report&" + namespace + "data=" + encodeURIComponent(JSON.stringify(data)));
	ajaxCallAPI(
			'POST',
			'generateZipReport',
			data,
			function() {
				data = this.get("responseData");
				if (data.error) {
					displayMessage('danger', data.error, 3000);
				} else {
					let responseText = this.get("responseData");
					window.open(exportPdfUrl+"&"+namespace+"filePath="+encodeURIComponent(responseText));
				}
				showLoading(false);
			}, function() {
				displayMessage('danger', "Error in processing record.", 3000);
				showLoading(false);
			});
}

var d = new Date();
var m = (d.getMonth() + 1);
var t = d.getDate();
var y = d.getFullYear();
var s = m + "/" + t + "/" + y;
var today = stringToDate(s, "mm/dd/yyyy", "/");

var toDatepicker;
YUI().use(
		'aui-datepicker',
		'aui-form-validator',
		function(Y) {
			var dueDatePicker;
			var toDatePicker;
			var fromDatePicker = new Y.DatePicker({
				trigger : '#' + namespace + 'startDate',
				mask : '%d/%m/%Y',
				popover : {
					zIndex : 1
				},
				calendar : {
					dateFormat : '%Y-%m-%d',
					//minimumDate : today,
				},
				on : {
					selectionChange : function(event) {
						if (event.newSelection[0]) {
							if(toDatePicker){
								toDatePicker.getCalendar().set('minimumDate',
										event.newSelection[0]);
							}
							
						} else {
							/*toDatePicker.getCalendar()
									.set('minimumDate', today);*/
						}
					}

				}
			}
			);
			toDatePicker = new Y.DatePicker({
				trigger : '#' + namespace + 'endDate',
				mask : '%d/%m/%Y',
				popover : {
					zIndex : 1
				},
				calendar : {
					dateFormat : '%Y-%m-%d',
					//minimumDate : today,
				},
				on : {
					selectionChange : function(event) {
						//fromDatePicker.getCalendar().set('minimumDate', today);
					}
				}

			});
			dueDatePicker = new Y.DatePicker({
				trigger : '#' + namespace + 'dueDate',
				mask : '%d/%m/%Y',
				popover : {
					zIndex : 1
				},
				calendar : {
					dateFormat : '%Y-%m-%d',
					//minimumDate : today,
				},
				on : {
					selectionChange : function(event) {
						//fromDatePicker.getCalendar().set('minimumDate', today);
					}
				}

			});
		});
setInterval(function() {
	//run();
}, 2000);


function stringToDate(_date, _format, _delimiter) {
	var formatLowerCase = _format.toLowerCase();
	var formatItems = formatLowerCase.split(_delimiter);
	var dateItems = _date.split(_delimiter);
	var monthIndex = formatItems.indexOf("mm");
	var dayIndex = formatItems.indexOf("dd");
	var yearIndex = formatItems.indexOf("yyyy");
	var month = parseInt(dateItems[monthIndex]);
	month -= 1;
	var formatedDate = new Date(dateItems[yearIndex], month,
			dateItems[dayIndex]);
	return formatedDate;
}