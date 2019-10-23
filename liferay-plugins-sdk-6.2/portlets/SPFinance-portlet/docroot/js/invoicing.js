var miscFeeTableId = document.getElementById('miscFeeTableId');
var miscContainerRow = document.getElementById('miscContainerRow');
var miscFeesDiv = document.getElementsByClassName('miscFees')[0];
var dueDateDiv = document.getElementsByClassName('dueDate')[0];
var miscFeeTableList = [];
var miscFeeSelectedMap = {};
var currencyList = [];
var data;
var contentdata = {};
contentdata.contentJson = {};
var productSubTypeList = [];
var modelName = "Invoicing";
var viewName = "Invoicing";
var ccLoaded = false;
var mfLoaded = false;
var oLoaded = false;
var formStorageId = formStorageId;
var subTotal = 0;
var count = 0;
var taxRate =0;
showLoading(true);
console.log("document.readyState : "+document.readyState);
var taxObj = {};
var miscFeeAllMap = {};
function init() {
	//dateInitialization();
	getTaxDetail();
	loadDefaultData(function() {
		if(mode == 'create'){
			document.getElementById("previewBtnId").disabled = true;
			document.getElementById("generateInvoiceBtnId").disabled = true;
		}
	});
}

function getTaxDetail(){
	var c = country? country : 'Singapore'
	var datas = {};
	datas.formStorageId = formStorageId;
	datas.formType = "taxcode";
	datas.conditions = ["contentJson.DefaultGST=yes",
	        			"contentJson.Status=Active", "contentJson.Country=" + c,
	        			"size=" + 2147483647, "sort=created_date,desc"];
	ajaxCallAPI(
			'GET',
			"searchList",
			datas,
			function(response) {
				datas = this.get("responseData").content[0];
				if(datas){
					taxObj = datas.contentJson;
				}
			}, function() {
				showLoading(false);
			});
}

function addMiscStructure() {
	drawTransactionRow();
}

function drawTransactionRow() {
	var rows =  miscFeeTableId.rows;
	var len = rows.length;
	for( var i=len-1;i>0; i--){
		miscFeeTableId.deleteRow(i);
	}
	for(var key in miscFeeSelectedMap){
		if(key && miscFeeSelectedMap[key] && (miscFeeSelectedMap[key] != null)){
			var node = miscContainerRow.cloneNode(true);
			  var miscFeeTable = miscFeeSelectedMap[key];
			  node.cells[0].innerHTML = miscFeeAllMap[miscFeeTable.title];
			  node.cells[0].setAttribute("title", miscFeeTable.title);
			  node.cells[1].getElementsByTagName("input")[0].value = miscFeeTable.description;
			  node.cells[2].getElementsByTagName("select")[0].value = miscFeeTable.taxable;
			  node.cells[3].getElementsByTagName("input")[0].value = miscFeeTable.unitPrice;
			  node.cells[4].getElementsByTagName("input")[0].value = miscFeeTable.quantity;
			  node.cells[5].getElementsByTagName("input")[0].value = miscFeeTable.amount;
			  node.cells[6].getElementsByClassName("deleteStatus")[0].innerHTML = miscFeeTable.deletStatus;
			  if (miscFeeTable.deleteStatus != "Remove") {
				  node.id=miscFeeTable.title;
				  miscFeeTableId.appendChild(node);
			  }
		}
	}
	changeTotalValue();
}

function changePriceQnty(element){
	var mainDiv = element.parentElement.parentElement;
	var unitPrice = mainDiv.getElementsByClassName("unitPrice")[0].value;
	var quantity = mainDiv.getElementsByClassName("quantity")[0].value;
	if(unitPrice && quantity){
		mainDiv.getElementsByClassName("amount")[0].value = (unitPrice * quantity).toFixed(2);
		changeTotalValue();
	}
}

function changeTotalValue(){
	addAllDataToArray();
	document.getElementById('subTotalId').innerHTML  = "";
	document.getElementById('subTotalId').innerHTML = "<b>Sub-Total : </b>$" + subTotal.toFixed(2);
}

function TransactionDetail(title, description, taxable, unitPrice, quantity, amount, tax,deleteStatus) {
	this.title = title;
	this.description = description;
	this.taxable = taxable;
	this.unitPrice = unitPrice;
	this.quantity = quantity;
	this.amount = amount;
	this.tax = tax;
	this.deleteStatus = deleteStatus;
}

function addAllDataToArray() {
	subTotal = 0;
	var rows =  miscFeeTableId.rows;
	for( var i=1;i<rows.length; i++){
		var title = rows[i].cells[0].getAttribute("title");
		var description = rows[i].cells[1].getElementsByTagName("input")[0].value;
		var taxable = rows[i].cells[2].getElementsByTagName("select")[0].value;
		var unitPrice = rows[i].cells[3].getElementsByTagName("input")[0].value;
		var quantity = rows[i].cells[4].getElementsByTagName("input")[0].value;
		var amount = rows[i].cells[5].getElementsByTagName("input")[0].value;
		var deleteStatus = rows[i].cells[6].getElementsByClassName("deleteStatus")[0];
		if (deleteStatus.innerHTML != "Remove") {
			if(miscFeeSelectedMap[title]){
				var taxAmount = miscFeeSelectedMap[title].tax;
				if(taxable=="No") {
					taxAmount = 0;
				}
				var transactionDetail = new TransactionDetail(title, 
						description, taxable, unitPrice, quantity, amount, taxAmount,deleteStatus.innerHTML)
				miscFeeSelectedMap[title] = transactionDetail;
				if(amount){
					subTotal = parseFloat(subTotal) + parseFloat(amount);
				}
			}
			
		}
	}
}

function removeMiscFeeRow(e){
	var elem = e.parentElement.parentElement;
	var title = elem.getElementsByClassName("title")[0].innerHTML;
	miscFeeChange(miscFeesDiv, title);
}

function miscFeeChange(selectElmt, value){
	
	addAllDataToArray();
    for (var i = 0; i < selectElmt.length; i++) {
    	var val = selectElmt.options[i].value;
    	if(value == val){
    		selectElmt.options[i].selected = false;
    	}
    	if(val){
    		if (selectElmt.options[i].selected){
    			if(!miscFeeSelectedMap[val]){
    				miscFeeSelectedMap[val] = new TransactionDetail(val, "", "Yes",  "",  1,  "",  0,"");
    			}
            } else{
            	miscFeeSelectedMap[val] = null;
            }
    	}
    }
    addMiscStructure();
}

function getDateByFormat(d){
	var m = (d.getMonth() + 1);
	var t = d.getDate();
	var y = d.getFullYear();
	var s = t + "/" + m + "/" + y;
	return s;
}

function dateInitialization(){
	/** ****************** Date Piker ********************* */
	var today = stringToDate(getDateByFormat(new Date()), "dd/mm/yyyy", "/");
	YUI().use('aui-datepicker','aui-form-validator', function(Y) {
			 new Y.DatePicker({
				trigger : '#' + namespace + 'dueDate',
				mask : '%d/%m/%Y',
				popover : {
					zIndex : 1
				},
				calendar : {
					dateFormat : '%Y-%m-%d',
					minimumDate : today,
				}

			});
	});
}

function creditTermChange(credit){
	var someDate =  new Date();
	someDate = new Date(someDate.getTime() +  credit*24*60*60*1000);
	getEID(namespace + "dueDate").value = getDateByFormat(someDate);
}

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

if(document.readyState == 'complete') {
	init();
} else {
	window.addEventListener('load', init);
}

function loadDefaultData(callback) {
	loadDropdowns(function() {
		if(ccLoaded == true && mfLoaded == true && oLoaded == true) {
			if (mode != "create") {
				fetchDetails(formStorageId);
			} else {
				addMiscStructure();
				showLoading(false);
			}
			callback();
		}
	});
}

function loadDropdowns(callback) {
	downloadVocabularyData("Currency%20Code", function(data) {
		currencyList = data;
		populateVocabularyDropDown('currency',currencyList, 'id', 'name', function(){
			ccLoaded = true;
			callback();
		});
	});
	miscFeeSelectedMap = {};
	loadCommonDropdownDataBy('miscFees', miscFeeList, function(){
		mfLoaded = true;
		callback();
	});
	populateVocabularyDropDown('organisationId',organizationList, 'organizationId', 'name', function(){
		oLoaded = true;
		callback();
	});
}

function populateVocabularyDropDown(dropdownId, data, keyColumn, valueColumn, callback) {
	var elementDrpDwn = getEID(namespace + dropdownId);
	for(var i=0; i<data.length; i++) {
		var opt = new Option(data[i][valueColumn], data[i][keyColumn]);
		elementDrpDwn.options[elementDrpDwn.options.length] = opt;
	}
	callback();
}

function loadCommonDropdownDataBy(dropdownId, valueList, callback) {
	var elementDrpDwn = getEID(namespace + dropdownId);
	loadCommonDropdownDataToElement(elementDrpDwn, valueList, callback, dropdownId);
}

function loadCommonDropdownDataToElement(elementDrpDwn, valueList, callback, dropdownId) {
	for(var i=0; i<valueList.length; i++) {
		var value = valueList[i];
		var opt = null;
		
		if(dropdownId == 'miscFees'){
			opt = new Option(value.displayName, value.displayName);
			if(i==0 && mode =='create'){
				opt.selected = true;
				miscFeeSelectedMap[value.displayName] = new TransactionDetail(value.displayName, "", "Yes",  "",  1,  "",  0,"");
			}
			miscFeeAllMap[value.displayName] = value.displayName;
			
		}else{
			opt = new Option(value.displayName, value.itemValue);
		}
		elementDrpDwn.options[elementDrpDwn.options.length] = opt;
	}
	callback();
}

function downloadVocabularyData(vocabulary, callback) {
	var strSubURI = vocabulary;
	var ajaxUrl = vocabularyURL.replace("$VCNAME", strSubURI);
	AUI().use('aui-base','aui-io-request-deprecated',
	function(A) {
		var _data = {};
		A.io.request(ajaxUrl,{
				dataType : 'json',
				method : "GET",
				data : _data,
				on : {
					success : function(){
								var responseData = this.get('responseData');
								callback(responseData);
							},
					failure : function() {
								console.log("Error in the ajax call.");
								callback([]);
							}
					}
			});
		});
}

function submitForApproval(){
	doInvoiceAction('submit');
}

function fetchDetails(formStorageId) {
	showLoading(true);
	if (formStorageId != "") {
		data = {};
		data.formStorageId = formStorageId;
		data.formType = "Invoicing";
		ajaxCallAPI(
				'GET',
				"loadData",
				data,
				function() {
					data = this.get("responseData");
					console.log("data : "+JSON.stringify(data));
					contentdata = this.get("responseData");
					if (data.error) {
						displayMessage('danger', data.error, 3000);
					} else {
						var sc = contentdata.contentJson.TransactionMasterCode;
						getEID(namespace + "transactionMasterCode").value = sc;
						getEID("descriptionMain").value = contentdata.contentJson.Description;
						getEID(namespace + "creditTerm").value = contentdata.contentJson.CreditTerm;
						getEID(namespace + "currency").value = contentdata.contentJson.TransactionDetails[0].currency;
						getEID(namespace + "dueDate").value = contentdata.contentJson.DueDate;
						var invoicing = contentdata.contentJson;
						miscFeeSelectedMap = {};
						var orgId = '';
						var tax = 0;
						var amount = 0;
						for(var i=0; i<invoicing.TransactionDetails.length;i++){
							var transactionDt = invoicing.TransactionDetails[i];
							if(transactionDt.organisationId){
								orgId = transactionDt.organisationId;
							} else {
								orgId = transactionDt.userId;
							}
							miscFeeSelectedMap[transactionDt.title] = new TransactionDetail(transactionDt.title, transactionDt.description, 
									transactionDt.taxable, parseFloat(transactionDt.unitPrice),  transactionDt.quantity, parseFloat(transactionDt.amount),  parseFloat(transactionDt.tax),"");
						
							amount = amount + parseFloat(transactionDt.amount);
							tax = tax + parseFloat(transactionDt.tax);
						}
						
						addMiscStructure();
						setMiscFees();
						if(getEID("invoiceTypeCP") && getEID("invoiceTypeIN")) {
							if(invoicing.Type == clientTypeMap['Corporate']) {
								getEID("invoiceTypeCP").checked = true;
								getEID("invoiceTypeIN").checked = false;
								changeInvoiceType('C');
								getEID(namespace + "organisationId").value = parseInt(orgId);
							} else {
								getEID("invoiceTypeCP").checked = false;
								getEID("invoiceTypeIN").checked = true;
								changeInvoiceType('I');
								getEID(namespace + "candidateids").value = parseInt(orgId);
							}
						}
						validateFields("CALCULATE");
						
					}
					showLoading(false);
				}, function() {
					displayMessage('danger',
							"Error in persisting dynamic form data.", 3000);
					showLoading(false);
				});
	}
}

function setMiscFees(){
	var selectElmt = miscFeesDiv;
	 for (var i = 0; i < selectElmt.length; i++) {
    	var val = selectElmt.options[i].value;
    	if(miscFeeSelectedMap[val]){
    		selectElmt.options[i].selected = true;
    	}
    }
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
		AUI().use('aui-base',function(A) {
			A.one(popupdiv).set('hidden', false);
			YUI().use('aui-modal',function(Y) {
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
				Y.one('.close').on('click',function() {modal.hide();});
				Y.one('.popup-cancel-deactivate').on('click',function() {modal.hide();});
				Y.one('.popup-confirm-deactivate').on('click',function() {
					if (document.getElementById("deactivate_reason").value.length > 4) {
						updateStorageStatus1(status,storageId);
						modal.hide();
					} else {
						document.getElementById("deactivate_msg").classList.add("alert");
						document.getElementById("deactivate_msg").classList.add("alert-error");
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
				var data = this.get("responseData");
				if (_.isEmpty(data)) {
					console.log("error");
				} else {
					//loadList();
					showPopupSuccess(status, storageId);
				}
				showLoading(false);
				//window.location.reload();
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


function validateFields(action) {
	if (checkIsValide()) {
		if(action == 'CALCULATE'){
			showLoading(true);
			getCurrencyExchangeActiveRate(baseCurrency, getEID(namespace + "currency").value, function(excRate) {
				if(mode=="create" || mode=="edit") {
					document.getElementById(namespace+"formRow").style.display = "flex";
					document.getElementById(namespace+"formCol").style.margin = "0";
					document.getElementById("payment-section").style.display = "block";
					
				}
				calculateFeeFnct(true, miscFeeSelectedMap, excRate);
				showLoading(false);
			});
		}
		if(action == 'GENERATE_INVOICE'){
			submitInvoicing();
		}
		if(action == 'PREVIEW'){
			getCurrencyExchangeActiveRate(baseCurrency, getEID(namespace + "currency").value, function(excRate) {
				//isPreviewPDF = true;
				exportPdf(formStorageId, getInvoiceModel(true, excRate));
			});
		}
	}
}

function isNormalInteger(str) {
    var n = Math.floor(Number(str));
    return n !== Infinity && String(n) === str && n >= 0;
}

document.querySelector(".validateNumber").addEventListener("keypress", function (evt) {
    if (evt.which != 8 && evt.which != 0 && evt.which < 48 || evt.which > 57)
    {
        evt.preventDefault();
    }
});

function validateCreditTerms(t){
	var credit = t.value;
	if(isNaN(credit) || credit<0 || credit > 99 || credit.length > 2){
		displayMessage('danger', "Credit Term must be range between 0 to 99 number.", 3000);
		t.value = "";
		return true;
	}
	return false;
}

function preventOtherCharacters(evt){
	if (evt.which != 8 && evt.which != 0 && evt.which < 48 || evt.which > 57)
    {
		if(evt.which!=46){
			evt.preventDefault();
		}
    }
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

function validateDecimalNumber(s,t){
	if(s==undefined){
		s="";
	}
if (t.value != "") {
	    if(!( /^(?:\d{1,15}\.\d{1,2}|\d{1,15})$/.test(t.value))){
	    	displayMessage('danger', s+" only 15 digit allowed with two decimal point.", 3000);
	        return true;
	    }
	}
	return false;
}

function validateDescription(t){
	if(t.value.length > 500){
		displayMessage('danger', "Description should be less than 500 characters", 3000);
		t.value = t.value.substring(0, 500);
		return true;
	}
	if (t.value != "") {
	    if(!( /^[a-zA-Z0-9.,:; ]+$/.test(t.value))){
	    	displayMessage('danger', "Description should not contain special characters", 3000);
	        return true;
	    }
	}
	return false;
}

function checkIsValide() {
	var eValid = true;
	addAllDataToArray();
	if(getEID("invoiceTypeIN") && getEID("invoiceTypeIN").checked && getEID(namespace + 'candidateids').value.trim() == ""){
		eValid = false;
		displayMessage('danger', "Candidate Name is Mandatory", 3000);
	}else if (getEID("invoiceTypeIN") && !getEID("invoiceTypeIN").checked && getEID(namespace + 'organisationId').value.trim() == "") {
		eValid = false;
		displayMessage('danger', "Corporate Name is Mandatory", 3000);
	} else if (getEID(namespace + 'creditTerm').value.trim() == "") {
		eValid = false;
		displayMessage('danger', "Credit Termis Mandatory", 3000);
	} else if (getEID(namespace + 'currency').value.trim() == "") {
		eValid = false;
		displayMessage('danger', "Currency Code is Mandatory", 3000);
	} else if (getEID(namespace + 'miscFees').value.trim() == "") {
		eValid = false;
		displayMessage('danger', "Misc Fees is Mandatory", 3000);
	} else if (getEID(namespace + 'creditTerm').value.trim() == "") {
		eValid = false;
		displayMessage('danger', "Credit Term is Mandatory", 3000);
	} else if (!isNormalInteger(getEID(namespace + 'creditTerm').value.trim())) {
		eValid = false;
		displayMessage('danger', "Credit Term must be positive number", 3000);
	}
	else if(validateCreditTerms(getEID(namespace + 'creditTerm'))){
		eValid = false;
	}
	else if (getEID("descriptionMain").value.length > 500) {
		eValid = false;
		displayMessage('danger', "Description should be less than 500 characters", 3000);
	}
	else if(validateDescription(getEID("descriptionMain"))){
		eValid = false;
	}
	else {
		var rows =  miscFeeTableId.rows;
		for( var i=1;i<rows.length; i++){
			var description = rows[i].cells[1].getElementsByTagName("input")[0].value;
			var taxable = rows[i].cells[2].getElementsByTagName("select")[0].value;
			var unitPrice = rows[i].cells[3].getElementsByTagName("input")[0].value;
			var quantity = rows[i].cells[4].getElementsByTagName("input")[0].value;
			var amount = rows[i].cells[5].getElementsByTagName("input")[0].value;
			if (!description || description.trim() == '') {
				eValid = false;
				displayMessage('danger', "Description is Mandatory", 3000);
				break;
			}
			if(validateDescription(rows[i].cells[1].getElementsByTagName("input")[0])){
				eValid = false;
				break;
			}
			if (!taxable || taxable.trim() == '') {
				eValid = false;
				displayMessage('danger', "Taxable is Mandatory", 3000);
				break;
			}
			if (!unitPrice || unitPrice.trim() == '') {
				eValid = false;
				displayMessage('danger', "Unit Price is Mandatory", 3000);
				break;
			}
			if (!quantity || quantity.trim() == '') {
				eValid = false;
				displayMessage('danger', "Quantity is Mandatory", 3000);
				break;
			}
			if (!amount || amount.trim() == '') {
				eValid = false;
				displayMessage('danger', "Amount is Mandatory", 3000);
				break;
			}
			if (validateDecimalNumber("For Unit Price",rows[i].cells[3].getElementsByTagName("input")[0])) {
				eValid = false;
				//displayMessage('danger', "Unit Price must be positive number", 3000);
				break;
			}
			if (!isNormalInteger(quantity) || quantity.length > 3) {
				eValid = false;
				displayMessage('danger', "Quantity must be positive number with 3 digit number", 3000);
				break;
			}
			if (validateDecimalNumber("For Amount",rows[i].cells[5].getElementsByTagName("input")[0])) {
				eValid = false;
				//displayMessage('danger', "Amount must be positive number", 3000);
				break;
			}
		}
	}
	
	return eValid;
}

function pdfRequest(){
	mode = "edit";
	exportPdf(formStorageId, null);
}

function submitInvoicing() {
	showLoading(true);
	var invoicing = getInvoiceModel(false, 1);
	invoicing.contentJson = null;
	invoicing.NameOfPayer = null;
	console.log(invoicing);
	if(invoicing.hasOwnProperty("ProductSubType") && invoicing.ProductSubType==undefined){
		invoicing["ProductSubType"] = "2005";
	}
	console.log(invoicing);
	invoicing.formType = "invoicing";
	ajaxCallAPI('POST', 'persist', invoicing, function() {
		let data = this.get("responseData");
		if (data.error) {
			displayMessage('danger', data.error, 3000);
		} else if (Object.keys(data).length === 0) {
			displayMessage('danger', 'Form submission failed.', 3000);
		} else {
			var message = "Invoice Generated Successfully.";
			displayMessage('success', message, 3000);
			formStorageId = data.storageId;
			console.log("formStorageId : "+formStorageId);
			if(enableApproval != undefined && enableApproval=="false"){
				sendEmailToCandidate = true;
				pdfRequest();
			}
			afterFormSubmissionFormIOForm(invoicing);
		}
		showLoading(false);
	}, function() {
		displayMessage('danger', "Error in persisting dynamic form data.", 3000);
		showLoading(false);
	});
}

function filterValue(json, key, def) {
	var value = json.hasOwnProperty(key) ? json[key] : "";
	return value == "" ? (def==""?"":(" "+def)) : (" "+value);
}

function getInvoiceModel(isPreview, exchRate){
	console.log("exchRate : "+exchRate);
	
	var invoicing = {};
	invoicing = contentdata.contentJson;
	invoicing.TransactionMasterCode=generateTransactionMasterCode();
	invoicing.Description=getEID("descriptionMain").value;
	invoicing.CreditTerm=getEID(namespace + "creditTerm").value;
	var d = getEID(namespace + "dueDate").value;
	invoicing.DueDate= d;
	invoicing.Currency=getEID(namespace + "currency").value;
	invoicing.SourceType=sourceTypeMap['MS'];
	invoicing.TransactionDetails = [];
	if(getEID("invoiceTypeCP") && getEID("invoiceTypeCP").checked==true) {
		invoicing.Type=clientTypeMap['Corporate'];
		invoicing.Source="Corporate";
	} else {
		invoicing.Type=clientTypeMap['Individual'];
		invoicing.Source="Adhoc";
		if(typeof candidateDetailMap != "undefined"){
			var userData = candidateDetailMap[getEID(namespace + 'candidateids').value];
			if(userData!=undefined && userData.hasOwnProperty("contentJson"))
			{
				var cd = userData["contentJson"];
				var postCode = filterValue(cd,"PostalCode");
				postCode = postCode==""?"":("("+postCode+")");
				invoicing.AddressOfPayer = filterValue(cd,"HouseBlockNo","") + " " + filterValue(cd,"BuildingName","") + " " + filterValue(cd,"StreetName","") + " " + filterValue(cd,"Country","Singapore") + " " + postCode;
				invoicing.AddressOfPayer = invoicing.AddressOfPayer.trim();
			} 
		}
	}
	
	if(mode=="edit") {
		invoicing.formStorageId = formStorageId;
	} else {
		invoicing.ProductType=productMap['SAC'];
		invoicing.ProductSubType= productSubtypeMap['SAC'];
		invoicing.FunctionalComponent="F";
		invoicing.CategoryType=categoryMap['IN'];
		var idt = getDateByFormat(new Date());
		invoicing.TxnDate=idt;
		invoicing.TxnType=transactionTypeMap['Invoice'];
		invoicing.Title="Title";
		invoicing.ApprovalStatus="Pending";
		invoicing.RequestType="New Invoice";
		invoicing.TransactionStatus="Pending";
		if(enableApproval != undefined && enableApproval=="false"){
			invoicing.ApprovalStatus="Approved";
			invoicing.TransactionStatus="Confirmed";
		}
	}
	
	for(var key in miscFeeSelectedMap){
		if(key && miscFeeSelectedMap[key] && (miscFeeSelectedMap[key] != null)){
			var miscFeeTable = miscFeeSelectedMap[key];
			var detail = {
			        "title":miscFeeTable.title,
			        "description":miscFeeTable.description,
			        "amountType": "Exam Fee",
			        "currency": invoicing.Currency,
			        "baseCurrency": baseCurrency ? baseCurrency : "SGD",
			        "quantity": miscFeeTable.quantity,
			        "unitPrice" :miscFeeTable.unitPrice,
			        "amount":miscFeeTable.amount,
			        "organisationId": getEID(namespace + "organisationId").value,
			        "taxable": miscFeeTable.taxable,
			        "tax": miscFeeTable.tax,
			        "taxCode": (miscFeeTable.taxable=="Yes")?taxObj.TaxCode:null
			};
			if(getEID("invoiceTypeIN") && getEID("invoiceTypeIN").checked){
				detail["userId"] = getEID(namespace + "candidateids").value;
			}
			if(isPreview == true){
				detail.exchangeRate = exchRate;
				detail.amountAtBaseCurrency = formatNumbers(miscFeeTable.amount * exchRate);
				detail.taxAtBaseCurrency = formatNumbers(miscFeeTable.tax * exchRate);
			}
			invoicing.TransactionDetails.push(detail);
		}
	}
	console.log("isPreview : "+isPreview);
	if(isPreview == true){
		console.log("setting payer");
		if(getEID("invoiceTypeIN") && getEID("invoiceTypeIN").checked){
			invoicing.NameOfPayer = getEID(namespace + 'candidateids').options[getEID(namespace + 'candidateids').selectedIndex].text;
		}else{
			invoicing.NameOfPayer = getEID(namespace + 'organisationId').options[getEID(namespace + 'organisationId').selectedIndex].text;
		}
		invoicing.contentJson = invoicing;
	}
	return invoicing;
}

function generateTransactionMasterCode() {
	if(mode=="edit") {
		 return getEID(namespace +"transactionMasterCode").value;
	} else {
		var date = new Date();
		var now_utc =  Date.UTC(date.getUTCFullYear(), date.getUTCMonth(), date.getUTCDate(),
				 date.getUTCHours(), date.getUTCMinutes(), date.getUTCSeconds());
		return "TMC-"+now_utc;
	}
}

function afterFormSubmissionFormIOForm(data) {
	console.log("status : " + status);
	var msg = "Invoice Generated Successfully.";
	if(enableApproval != undefined && enableApproval=="false"){
		getEID("submit").style="display: none;"
		getEID("popupexitaction").style="width: 110px;margin-right:120px;";
	}
	var boundingBox = "#sucess-popup";
	var contentBox = "#sucess-popup-box";
	document.getElementById('success-msg').innerHTML = msg;
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
			Y.one('.close').hide();
			Y.one('.popup-submit-button').on('click', function() {
				modal.hide();
				submitForApproval();
			});
		});

	});
}
function ebableOnceValide() {
	setInterval(function() {
		checkIsValide();
	}, 1000);
}

function reset() {
	document.getElementById("corporateInvoice_form").reset();
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

function gotoHome(){
	window.location = "/";
}

function showCancelPopup() {
	openDialog("cancel", function(modal) {
		modal.hide();
		gotoHome();
	}, function(modal) {
		modal.hide();
	});
	
}

function openDialog(dialogName, submitFun, cancelFun) {
	AUI().use('aui-base',function(A) {
		A.one("#"+dialogName+"-dialog-bound").set('hidden', false);
		YUI().use('aui-modal',function(Y) {
			var modal = new Y.Modal({
				boundingBox : "#"+dialogName+"-dialog-bound",
				contentBox : "#"+dialogName+"-dialog-content",
				headerContent : '',
				centered : true,
				destroyOnHide : false,
				modal : true,
				resizable : false,
				draggable : true,
			}).render();
			Y.one('.close').on('click',function() {modal.hide();});
			if(Y.one('.'+dialogName+'-dialog-cancel')) {
				Y.one('.'+dialogName+'-dialog-cancel').on('click',function() {modal.hide();});
			}
			Y.one('.'+dialogName+'-dialog-submit').on('click',function() {
				submitFun(modal);
			});
		});
	});
}

function getCurrencyExchangeRates(baseCurrency, targetCurrency, callback) {
	var data = {};
	data.formType = "CurrencyExchange";
	data.conditions = ["contentJson.Status=Active","contentJson.BaseCurrency="+baseCurrency,"contentJson.CurrencyCode="+targetCurrency,"size="+2147483647
	                   ,"sort=contentJson.EffectiveDate,desc"];
	ajaxCallAPI(
			'GET',
			"searchList",
			data,
			function() {
				var contentdata = this.get("responseData");
				console.log("contentdata: "+JSON.stringify(contentdata));
				var responseData = [];
				if (!contentdata || contentdata.error) {
					callback([]);
				} else {
					responseData = contentdata.content;
				}
				callback(responseData);
			}, function() {
				displayMessage('danger',
						"Error in getting exchange rates.", 3000);
				callback();
			});
}

function getCurrencyExchangeActiveRate(baseCurrency, targetCurrency, callback) {
	if(baseCurrency==targetCurrency) {
		callback(1);
		return;
	}
	getCurrencyExchangeRates(baseCurrency, targetCurrency, function(rateList) {
		console.log("rateList : " + JSON.stringify(rateList));
		if ((typeof rateList !== "undefined") && rateList.length != 0) {
			for (var i = 0; i < rateList.length; i++) {
				var rateP = rateList[i];
				console.log("rate.contentJson : "
						+ rateP.contentJson.EffectiveDate);
				var currDate = new Date();
				var rateDate = new Date(rateP.contentJson.EffectiveDate);
				console.log("currDate : " + currDate);
				console.log("rateDate : " + rateDate);
				if (currDate.getTime() >= rateDate.getTime()) {
					callback(rateP.contentJson.ExchangeRate);
					break;
				}
			}
		} else {
			callback(1);
		}
	})
}

function formatNumbers(num) {
	console.log("num : "+num);
	num = round(parseFloat(num),2).toFixed(2);
	console.log("num : "+num);
	return addCommas(num);
}

function round(value, decimals) {
	  return Number(Math.round(value+'e'+decimals)+'e-'+decimals);
	}

