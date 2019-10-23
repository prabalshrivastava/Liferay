var structureHolder = document.getElementById('structureHolder');
var structureContainer = document.getElementById('structureContainer');
var structureList = [];
var productSubTypeList = [];
var productIdValueMap = {};
var data, contentdata;
var ptLoaded = false;
var fcLoaded = false;
var ctLoaded = false;
var typeLoaded = false;
var strutureTypeId;
var strutureValueId;
var fLoaded = false;
var modelName = "ReferenceNumber";
var viewName = "Reference Number";
showLoading(true);
console.log("document.readyState : "+document.readyState);

function init() {
	ptLoaded = false;
	fcLoaded = false;
	ctLoaded = false;
	typeLoaded = false;
	fLoaded = false;
	while (structureHolder.hasChildNodes()) {
		structureHolder.removeChild(structureHolder.lastChild);
	}
	loadDefaultData(function() {
		setInterval(function() {
			validateForm();
		}, 1000);
		if (mode === "create") {
			addAnotherStruture();
		}
	});
}

if(document.readyState == 'complete') {
	init();
} else {
	window.addEventListener('load', init);
}

function loadDefaultData(callback) {
	loadDropdowns(function() {
		if(ptLoaded == true && fcLoaded == true && ctLoaded == true && typeLoaded == true && fLoaded == true) {
			if (mode != "create") {
				fetchDetails(formStorageId);
			} else {
				showLoading(false);
			}
			callback();
		}
	});
}

function showHideFrequencyDiv(model){
	if(model){
		getEID(namespace+"frequencyDivId").style.display = "block";
	}else{
		getEID(namespace+"frequencyDivId").style.display = "none";
	}
}

function loadDropdowns(callback) {
	productIdValueMap = {};
	loadCommonDropdownData("productType", productTypeList, function(){
		ptLoaded = true;
		callback();
	}, false);
	loadCommonDropdownData("functionalComponent", functionalComponentList, function(){
		fcLoaded = true;
		callback();
	}, true);
	loadCommonDropdownData("categoryType", categoryTypeList, function(){
		ctLoaded = true;
		callback();
	}, false);
	loadCommonDropdownData("frequency", frequencyList, function(){
		fLoaded = true;
		callback();
	}, true);
	loadCommonRadioData("type","typeRadioDiv", typeList, function(){
		typeLoaded = true;
		callback();
	});
}

function loadCommonDropdownData(dropdownId, valueList, callback, isItemValue) {
	var elementDrpDwn = getEID(namespace + dropdownId);
	loadCommonDropdownDataToElement(elementDrpDwn, valueList, callback, dropdownId, isItemValue);
}

function loadCommonDropdownDataBy(dropdownId, valueList, callback) {
	var elementDrpDwn = getEID(namespace + dropdownId);
	loadCommonDropdownDataToElement(elementDrpDwn, valueList, callback, dropdownId);
}

function loadCommonDropdownDataToElement(elementDrpDwn, valueList, callback, dropdownId, isItemValue) {
	for(var i=0; i<valueList.length; i++) {
		var value = valueList[i];
		var opt = null;
		if(isItemValue){
			opt = new Option(value.displayName, value.itemValue);
		}else{
			opt = new Option(value.displayName, value.spListTypeId);
		}
		elementDrpDwn.options[elementDrpDwn.options.length] = opt;
		if(dropdownId == "productType"){
			productIdValueMap[value.spListTypeId] = value.displayName;
		}
	}
	callback();
}

function loadCommonRadioData(field, divId, valueList, callback) {
	var divEl = getEID(divId);
	var checked = "";
	for(var i=0; i<valueList.length; i++) {
		checked = "";
		if(i==0) {
			checked = "checked";
		}
		divEl.innerHTML += '<input '+checked+' name="'+field+'" id="'+valueList[i].displayName+'" type="radio" value="'+valueList[i].spListTypeId+'"/> '
			+valueList[i].displayName+'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;';
	}
	callback();
}

function generateReferenceNumberCode() {
	if(mode=="edit") {
		 return getEID(namespace +"referenceNumberCode").value;
	} else if (mode=="copy") {
		return getEID(namespace+"referenceNumberCode").value;
	} else {
		var date = new Date();
		var now_utc =  Date.UTC(date.getUTCFullYear(), date.getUTCMonth(), date.getUTCDate(),
				 date.getUTCHours(), date.getUTCMinutes(), date.getUTCSeconds());
		return "RN-"+now_utc;
	}
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
					if (data.error) {
						displayMessage('danger', data.error, 3000);
					} else {
						var rnc = contentdata.contentJson.ReferenceNumberCode;
						if (mode == "copy") {
							rnc = "Copy-of-" + rnc;
						}				
						if(mode=="edit") {
							if(contentdata.contentJson.Status=="Draft") {
								getEID(namespace + "status").value = "Active";
							} else {
								getEID(namespace + "status").value = contentdata.contentJson.Status;
							}
						}
						getEID(namespace + "referenceNumberCode").value = rnc;
						getEID(namespace + "productType").value = contentdata.contentJson.ProductType;
						downloadDropdownData(contentdata.contentJson.ProductType, contentdata.contentJson.ProductSubType);
						getEID(namespace + "functionalComponent").value = contentdata.contentJson.FunctionalComponent;
						getEID(namespace + "categoryType").value = contentdata.contentJson.CategoryType;
						setSelectedRadio("type", contentdata.contentJson.Type);
						var snrVal = contentdata.contentJson.SequenceNoReset;
						document.getElementById('sequenceNoReset').checked = snrVal;
						showHideFrequencyDiv(snrVal);
						if(snrVal){
							getEID(namespace + "frequency").value = contentdata.contentJson.Frequency;
						}
						getEID("formStatus").innerHTML = contentdata.contentJson.Status;
						getEID("formStatus").className = "";
						getEID("formStatus").classList.add("formStatus");
						getEID("formStatus").classList.add("form_"+contentdata.contentJson.Status.toLowerCase());
						
						var referenceStructures = [];
						referenceStructures = contentdata.contentJson.ReferenceStructures;
						addAllDataToArray();
						for (var i = 0; i < referenceStructures.length; i++) {
							var ss = new ReferenceStructure(referenceStructures[i].structurePartType,
									referenceStructures[i].structurePartValue,"Active");
							structureList.push(ss);
						}
						drawReferenceStructures();
						if (mode == "edit"
								&& contentdata.contentJson.Status == "Inactive") {
							getEID("activate").style.display = "";
							getEID("deactivate").style.display = "none";
						} else if (mode == "edit") {
							getEID("activate").style.display = "none";
							getEID("deactivate").style.display = "";
							getEID(namespace + "referenceNumberCode").disabled = true;
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

function setSelectedRadio(radioName, value) {
	var rbs = document.getElementsByName(radioName);
	for(var i = 0; i < rbs.length; i++){
	    if(rbs[i].value == value){
	    	rbs[i].checked = true;
	    } else {
	    	rbs[i].checked = false;
	    }
	}
}

function getSelectedRadio(radioName) {
	var rbs = document.getElementsByName(radioName);
	for(var i = 0; i < rbs.length; i++){
	    if(rbs[i].checked){
	    	return rbs[i];
	    }
	}
}

function enableViewMode() {
	var form = document.getElementById("billingForm");
	var elements = form.elements;
	for (var i = 0, len = elements.length; i < len; ++i) {
		elements[i].readOnly = true;
		elements[i].disabled = true;
	}
}

function downloadDropdownData(model, subTypeId) {
	var productType = productIdValueMap[model];	
	var strSubURI ="finance.accountingtable."+productType.toLowerCase()+".producsubtype";
	var listUrl=window.location.origin+"/api/jsonws/SPServices-portlet.splisttype/get-list-by-key/key/$VCNAME/group-id/"+groupId;
	var ajaxUrl =listUrl.replace("$VCNAME", strSubURI);
	console.log("ajaxUrl : "+ajaxUrl);
	AUI().use('aui-base','aui-io-request-deprecated',function(A) {
		var _data = {};
		A.io.request(ajaxUrl,{
			dataType : 'json',
			method : "GET",
			data : _data,
			on : {
				success : function() {
					var responseData = this
							.get('responseData');
					productSubTypeList = responseData;
					populateProductSubType(subTypeId);
				},
				failure : function() {
					console.log("Error in the ajax call.");
				}
			}
		});
	});
}

function populateProductSubType(subTypeId) {
	var productSubType = getEID(namespace+"productSubType");
	getEID(namespace+"productSubType").innerHTML="";
	var opt = new Option(
			"Choose Product Sub Type",
			"");
	productSubType.options[productSubType.options.length] = opt;
	for (var j = 0; j < productSubTypeList.length; j++) {
		var option = new Option(
				productSubTypeList[j].displayName,
				productSubTypeList[j].spListTypeId);
		if (option.value == parseInt(subTypeId)) {
			option.selected = true;
		}
		productSubType.options[productSubType.options.length] = option;
	}
}

function changeStructurePartValue(value, partTypeDiv){
	var mainDiv = partTypeDiv.parentElement.parentElement.parentElement.parentElement;
	var structureValueDiv = mainDiv.getElementsByClassName("structurePartValue")[0];
	var structureValueTextDiv = mainDiv.getElementsByClassName("structurePartValueText")[0];
	if(value == "V"){
		structureValueDiv.style.display="block";
		structureValueTextDiv.setAttribute('style', 'display:none !important');
	}else{
		structureValueDiv.style.display="none";
		structureValueTextDiv.setAttribute('style', 'display:block !important');
	}
}

function ReferenceStructure(structurePartType, structurePartValue, deleteStatus) {
	this.structurePartType = structurePartType;
	this.structurePartValue = structurePartValue;
	this.deleteStatus = deleteStatus;
}

function addAnotherStruture() {
	addAllDataToArray();
	var ss = new ReferenceStructure("", "", "");
	structureList.push(ss);
	drawReferenceStructures();
}

function removeReferenceStructure(e) {
	var eRmv = e.parentElement.parentElement.parentElement.parentElement;
	eRmv.getElementsByClassName("deleteStatus")[0].innerHTML = "Remove";
	addAllDataToArray();
	drawReferenceStructures();
	if (structureList.length == 0) {
		addAnotherStruture();
	}
}

function closeReferenceStructure(closeIcon) {
	var eRmv = closeIcon.parentElement.parentElement.parentElement.parentElement;
	var ReferenceStructureDiv = eRmv.getElementsByClassName("ReferenceStructureContent")[0];
	if(ReferenceStructureDiv.style.display!="none") {
		ReferenceStructureDiv.style.display = "none";
		closeIcon.style.background = "url(/html/images/expand.png) no-repeat";
	} else {
		ReferenceStructureDiv.style.display = "block";
		closeIcon.style.background = "url(/html/images/close-minus.png) no-repeat";
	}
}

function addAllDataToArray() {
	while (structureList.length > 0) {
		structureList.pop();
	}
	var c = structureHolder.childElementCount;
	for (var i = 0; i < c; i++) {
		var node = structureHolder.childNodes[i];
		var structurePartType = node.getElementsByClassName("structurePartType")[0];
		var structurePartValue = '';
		if(structurePartType.value == 'V'){
			structurePartValue = node.getElementsByClassName("structurePartValue")[0]
		}else{
			structurePartValue = node.getElementsByClassName("structurePartValueText")[0]
		}
		console.log(structurePartValue);
		var deleteStatus = node.getElementsByClassName("deleteStatus")[0];
		if (deleteStatus.innerHTML != "Remove") {
			structureList.push(new ReferenceStructure(structurePartType.value, structurePartValue.value, deleteStatus.innerHTML));
		}
	}
}

function drawReferenceStructures() {
	var count = 0;
	var i;
	while (structureHolder.hasChildNodes()) {
		structureHolder.removeChild(structureHolder.lastChild);
	}
	for (i = 0; i < structureList.length; i++) {
		var node = structureContainer.cloneNode(true);
		var header = node.getElementsByClassName("header")[0]
				.getElementsByTagName("div")[0];
		var structurePartType = node.getElementsByClassName("structurePartType")[0];
		loadCommonDropdownDataToElement(structurePartType, structurePartTypeList, function(){},'', true);
		var spTypeOptionArray = structurePartType.getElementsByTagName("option");
		var typeId;
		for (var j = 0; j < spTypeOptionArray.length; j++) {
			if (spTypeOptionArray[j].value === structureList[i].structurePartType) {
				spTypeOptionArray[j].selected = true;
				typeId = spTypeOptionArray[j].value;
				break;
			}
		}
		
		var structurePartValue = node.getElementsByClassName("structurePartValue")[0];
		loadCommonDropdownDataToElement(structurePartValue, structurePartValueList, function(){},'', true);
		var spValueOptionArray = structurePartValue.getElementsByTagName("option");
		for (var k = 0; k < spValueOptionArray.length; k++) {
			if (spValueOptionArray[k].value === structureList[i].structurePartValue) {
				spValueOptionArray[k].selected = true;
				break;
			}
		}
		
		var structurePartValueText = node.getElementsByClassName("structurePartValueText")[0];
		structurePartValueText.value = structureList[i].structurePartValue;
		node.getElementsByClassName("deleteStatus")[0].innerHTML = structureList[i].status;
		if (structureList[i].deleteStatus != "Remove") {
			count = count + 1;
			if (count <= 9) {
				header.innerText = "0" + count +" STRUCTURE";
			} else {
				header.innerText = count+" STRUCTURE";
			}
			node.style.display = "block";
			structureHolder.appendChild(node);
		}
		changeStructurePartValue(typeId, structurePartType);
	}
}

function validateForm() {
	if (document.getElementById(namespace + "productType").value.trim() != ""
				&& document.getElementById(namespace + "functionalComponent").value.trim() != ""
					&& document.getElementById(namespace + "categoryType").value.trim() != "") {
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
		submitReferenceNumber(action);
	}
}

function checkIsValide() {
	var eValid = true;
	addAllDataToArray();
	if (getEID(namespace + 'productType').value.trim() == "") {
		eValid = false;
		displayMessage('danger', "Product Type is Mandatory", 3000);
	} else if (getEID(namespace + 'functionalComponent').value.trim() == "") {
		eValid = false;
		displayMessage('danger', "Functional Component is Mandatory", 3000);
	} else if (getEID(namespace + 'categoryType').value.trim() == "") {
		eValid = false;
		displayMessage('danger', "Category Type is Mandatory", 3000);
	} else if (document.getElementById('sequenceNoReset').checked && getEID(namespace + 'frequency').value == "") {
		eValid = false;
		displayMessage('danger', "Frequency is Mandatory to Reset the Squence", 3000);
	} else if (structureList.length == 0) {
		eValid = false;
		displayMessage('danger', "At least one Structure is required",
				3000);
	} else {
		var defaultStruct = false;
		for (var i = 0; i < structureList.length; i++) {
			if (structureList[i].structurePartType == "") {
				eValid = false;
				displayMessage('danger', "Settlement Part Type is Mandatory", 3000);
				break;
			}
			if (structureList[i].structurePartValue == "") {
				eValid = false;
				displayMessage('danger', "Settlement Part Value is Mandatory", 3000);
				break;
			}
			
			if(structureList[i].structurePartType == "V" && structureList[i].structurePartValue == "SRNN"){
				defaultStruct = true;
			}
		}
		
		if(!defaultStruct){
			eValid = false;
			displayMessage('danger', "There should atleast one structure having " +
					"Settlement Part Type as 'Variable' and " +
					"Settlement Part Value as 'Sequential running numeric number '", 3000);
		}
		
	}
	return eValid;
}

function submitReferenceNumber(action) {
	showLoading(true);
	var referenceNumber={};
	referenceNumber.ReferenceNumberCode=generateReferenceNumberCode();
	referenceNumber.ProductType=getEID(namespace + "productType").value;
	referenceNumber.ProductSubType=getEID(namespace + "productSubType").value;
	referenceNumber.FunctionalComponent=getEID(namespace + "functionalComponent").value;
	referenceNumber.CategoryType=getEID(namespace + "categoryType").value;
	referenceNumber.Type=getSelectedRadio("type").value;
	referenceNumber.SequenceNoReset=document.getElementById('sequenceNoReset').checked;
	referenceNumber.Frequency=getEID(namespace + "frequency").value;
	referenceNumber.ReferenceStructures = [];
	for (var i = 0; i < structureList.length; i++) {
		var structureListData = structureList[i];
		var structure = {};
		structure.structurePartType = structureListData.structurePartType;
		structure.structurePartValue = structureListData.structurePartValue;
		referenceNumber.ReferenceStructures.push(structure);
	}
	if(mode=="edit") {
		referenceNumber.Status = getEID(namespace + "status").value;
		referenceNumber.formStorageId = formStorageId;
	} else {
		if (action == "publish") {
			referenceNumber.Status = "Active";
		} else {
			referenceNumber.Status = "Draft";
		}
	}
	referenceNumber.formType = "referenceNumber";
	ajaxCallAPI('POST', 'persist', referenceNumber, function() {
		let data = this.get("responseData");
		if (data.error) {
			displayMessage('danger', data.error, 3000);
		} else if (Object.keys(data).length === 0) {
			console.log("data : "+data);
			displayMessage('danger', 'Form submission failed.', 3000);
		} else {
			console.log(data.toString());
			var message = "Form successfully submitted.";
			if (referenceNumber.Status == "Draft")
				message = "Record is saved in draft";
			displayMessage('success', message, 3000);
			afterFormSubmissionFormIOForm(referenceNumber);
		}
		showLoading(false);
	}, function() {
		displayMessage('danger', "Error in persisting dynamic form data.", 3000);
		showLoading(false);
	});
}
