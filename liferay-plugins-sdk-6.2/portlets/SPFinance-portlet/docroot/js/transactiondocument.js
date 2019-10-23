var modelName = "TransactionDocument";
var viewName = "Transaction Document";
var data, contentdata;
var ptLoaded = false;
var psLoaded = false;
var fcLoaded = false;
var ctLoaded = false;
var typeLoaded = false;
var tfLoaded = false;
var aiLoaded = false;
var productIdValueMap = {};
var productSubTypeList = [];
showLoading(true);

console.log("document.readyState : "+document.readyState);
function init() {
	ptLoaded = false;
	psLoaded = false;
	fcLoaded = false;
	ctLoaded = false;
	typeLoaded = false;
	tfLoaded = false;
	aiLoaded = false;
	console.log("onload...");
	while (childrenHolder.hasChildNodes()) {
		childrenHolder.removeChild(childrenHolder.lastChild);
	}
	loadDefaultData(function() {
		setInterval(function() {
			validateForm();
		}, 1000);
		console.log("onload - mode : "+mode);
		if (mode == "create") {
			addAnotherChild();
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
		console.log("ptLoaded : "+ptLoaded);
		console.log("psLoaded : "+psLoaded);
		console.log("fcLoaded : "+fcLoaded);
		console.log("ctsLoaded : "+ctLoaded);
		console.log("typeLoaded : "+typeLoaded);
		console.log("tfLoaded : "+tfLoaded);
		if(ptLoaded == true && psLoaded == true && fcLoaded == true && ctLoaded == true
				&& typeLoaded == true && tfLoaded == true && aiLoaded == true) {
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

function loadDropdowns(callback) {
	console.log("advanceInvoiceList : "+advanceInvoiceList);
	productIdValueMap = {};
	loadCommonDropdownData("productType", productTypeList, "spListTypeId", "displayName", function(){
		ptLoaded = true;
		callback();
	});
	loadCommonDropdownData("productSubType", productSubTypeList, "spListTypeId", "displayName", function(){
		psLoaded = true;
		callback();
	});
	loadCommonDropdownData("functionalComponent", functionalComponentList, "itemValue", "displayName", function(){
		fcLoaded = true;
		callback();
	});
	loadCommonDropdownData("categoryType", categoryTypeList, "spListTypeId", "displayName", function(){
		ctLoaded = true;
		callback();
	});
	loadCommonDropdownData("advanceInvoice", advanceInvoiceList, "itemValue", "displayName", function(){
		aiLoaded = true;
		callback();
	});
	loadCommonRadioData("type","typeRadioDiv", typeList, "spListTypeId", "displayName", function(){
		typeLoaded = true;
		callback();
	});
	loadCommonRadioData("templateFor","templateForRadioDiv", templateForList, "itemValue", "displayName", function(){
		tfLoaded = true;
		callback();
	});
	templateForChange("Main-Category");
}

function loadCommonDropdownData(dropdownId, valueList, key, value, callback) {
	var elementDrpDwn = getEID(namespace + dropdownId);
	loadCommonDropdownDataToElement(elementDrpDwn, valueList, key, value, callback, dropdownId);
}

function loadCommonDropdownDataToElement(elementDrpDwn, valueList, key, value, callback, dropdownId) {
	for(var i=0; i<valueList.length; i++) {
		var opt = new Option(valueList[i][value], valueList[i][key]);
		elementDrpDwn.options[elementDrpDwn.options.length] = opt;
		if(dropdownId == "productType"){
			productIdValueMap[valueList[i][key]] = valueList[i][value];
		}
	}
	callback();
}

function populateProductSubType(subTypeId) {
	var productSubType = getEID(namespace+"productSubType");
	getEID(namespace+"productSubType").innerHTML="";
	var opt = new Option(
			"Choose Product Sub-Type",
			"");
	productSubType.options[productSubType.options.length] = opt;
	for (var j = 0; j < productSubTypeList.length; j++) {
		console.log("productSubTypeList[j] : "+JSON.stringify(productSubTypeList[j]));
		var option = new Option(
				productSubTypeList[j].displayName,
				productSubTypeList[j].spListTypeId);
		if (option.value == parseInt(subTypeId)) {
			option.selected = true;
		}
		productSubType.options[productSubType.options.length] = option;
	}
}

function loadCommonRadioData(field, divId, valueList, key, value, callback) {
	var divEl = getEID(divId);
	var checked = "";
	console.log("valueList : "+valueList);
	for(var i=0; i<valueList.length; i++) {
		checked = "";
		var changeFun = "";
		if(i==0) {
			checked = "checked";
		}
		if(field=="templateFor") {
			changeFun = "onchange=\"templateForChange(this.id)\"";
		}
		console.log("name : "+name);
		console.log("changeFun : "+changeFun);
		divEl.innerHTML += '<input '+checked+' name="'+field+'" id="'+valueList[i][value]+'" type="radio" value="'+valueList[i][key]+'" '+changeFun+' /> '
			+valueList[i][value]+'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;';
	}
	callback();
}

function templateForChange(selectedText) {
	console.log("selectedText : "+selectedText);
	if(selectedText == "Main-Category") {
		getEID(namespace+"mainCategorySection").style.display = "block";
		getEID(namespace+"subCategorySection").style.display = "none";
		if(mode!="view") {
			getEID(namespace+"subCategorySectionButton").style.display = "none";
		}
	} else {
		getEID(namespace+"mainCategorySection").style.display = "none";
		getEID(namespace+"subCategorySection").style.display = "block";
		if(mode!="view") {
			getEID(namespace+"subCategorySectionButton").style.display = "block";
		}
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
					console.log("contentdata : " + JSON.stringify(contentdata));
					if (data.error) {
						displayMessage('danger', data.error, 3000);
					} else {
						var dc = contentdata.contentJson.TransactionDocumentCode;
						getEID("transactionDocumentCode").value = dc;
						if(mode=="edit") {
							if(contentdata.contentJson.Status=="Draft") {
								getEID("status").value = "Active";
							} else {
								getEID("status").value = contentdata.contentJson.Status;
							}
						}
						getEID(namespace + "productType").value = contentdata.contentJson.ProductType;
						downloadDropdownData(contentdata.contentJson.ProductType, contentdata.contentJson.ProductSubType);
						getEID(namespace + "functionalComponent").value = contentdata.contentJson.FunctionalComponent;
						getEID(namespace + "categoryType").value = contentdata.contentJson.CategoryType;
						setSelectedRadio("type", contentdata.contentJson.Type);
						setSelectedRadio("templateFor", contentdata.contentJson.TemplateFor);
						console.log("000 : "+getSelectedRadio("templateFor").id);
						templateForChange(getSelectedRadio("templateFor").id);
						var templates = contentdata.contentJson.TransactionTemplates;
						addAllDataToArray();
						if(isMainCategory()) {
							getEID(namespace + "advanceInvoice").value = templates[0].advanceInvoice;
							getEID(namespace + "template").value = templates[0].template;
						} else {
							for (var i = 0; i < templates.length; i++) {
								var ss = new Child(templates[i].subCategory,
										templates[i].advanceInvoice, templates[i].template, "", "Active");
								console.log("ss : "+JSON.stringify(ss));
								childrenList.push(ss);
							}
						}
						drawChildrens();
						console.log("childrenHolder.hasChildNodes : "+childrenHolder.hasChildNodes());
						if(!childrenHolder.hasChildNodes()) {
							addAnotherChild();
						}
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

function validateAndSubmit(action) {
	if (isFormValid()) {
		submitTransactionDocument(action);
	}
}

function isMainCategory() {
	if(getEID(namespace+"mainCategorySection").style.display!="none") {
		return true;
	}
	return false;
}

function isFormValid() {
	var eValid = true;
	addAllDataToArray();
	if (getEID(namespace + 'productType').value.trim() == "") {
		eValid = false;
		displayMessage('danger', "Product Type is Mandatory", 3000);
	} else if (getEID(namespace + 'functionalComponent').value.trim() == "") {
		eValid = false;
		displayMessage('danger', "Functional Component is Mandatory.", 3000);
	} else if (getEID(namespace + 'categoryType').value.trim() == "") {
		eValid = false;
		displayMessage('danger', "Category Type is Mandatory.", 3000);
	}
	if(isMainCategory()) {
		if(getEID(namespace + 'advanceInvoice').value.trim() == "") {
			eValid = false;
			displayMessage('danger', "Advance Invoice Indicator is Mandatory.", 3000);
		}
	} else {
		for (var i = 0; i < childrenList.length; i++) {
			if (childrenList[i].subCategory == "") {
				eValid = false;
				displayMessage('danger', "Sub-Category is Mandatory", 3000);
				break;
			}
			if (childrenList[i].subCategory.trim().length > 50) {
				eValid = false;
				displayMessage('danger', "Sub-Category must be shorter than 51 characters", 3000);
				break;
			}
			if (childrenList[i].advanceInvoice == "") {
				eValid = false;
				displayMessage('danger', "Advance Invoice  Indicator is Mandatory", 3000);
				break;
			}
		}
	}
	return eValid;
}

function generateTransactionDocCode() {
	if(mode=="edit") {
		 return getEID("transactionDocumentCode").value;
	} else {
		var date = new Date();
		var now_utc =  Date.UTC(date.getUTCFullYear(), date.getUTCMonth(), date.getUTCDate(),
				 date.getUTCHours(), date.getUTCMinutes(), date.getUTCSeconds());
		return "TD-"+now_utc;
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

function setSelectedRadio(radioName, value) {
	var rbs = document.getElementsByName(radioName);
	for(var i = 0; i < rbs.length; i++){
		console.log('rbs[i].value : '+rbs[i].value);
		console.log('value : '+value);
		console.log('value : '+(rbs[i].value == value));
	    if(rbs[i].value == value){
	    	rbs[i].checked = true;
	    } else {
	    	rbs[i].checked = false;
	    }
	}
}

function submitTransactionDocument(action) {
	showLoading(true);
	var transactionDocumentCode = generateTransactionDocCode();
	var productType = getEID(namespace + "productType");
	var productSubType = getEID(namespace + "productSubType");
	var functionalComponent = getEID(namespace + "functionalComponent");
	var categoryType = getEID(namespace + "categoryType");
	var type = getSelectedRadio("type");
	var templateFor = getSelectedRadio("templateFor");
	var transactionDocument = {};
	transactionDocument.TransactionDocumentCode = transactionDocumentCode;
	transactionDocument.ProductType = productType.value.trim();
	transactionDocument.ProductSubType = productSubType.value.trim();
	transactionDocument.FunctionalComponent = functionalComponent.value.trim();
	transactionDocument.CategoryType = categoryType.value.trim();
	transactionDocument.Type = type.value.trim();
	transactionDocument.TemplateFor = templateFor.value.trim();
	transactionDocument.TransactionTemplates = [];
	if(isMainCategory()) {
		var child = {};
		child.advanceInvoice = getEID(namespace + "advanceInvoice").value;
		child.template = getEID(namespace + "template").value;
		if(getEID("templateChanged").value == "changed") {
			child.templateChanged = true;
		} else {
			child.templateChanged = false;
		}
		transactionDocument.TransactionTemplates.push(child);
	} else {
		for (var i = 0; i < childrenList.length; i++) {
			var chld = {};
			var childData = childrenList[i];
			if(!isMainCategory()) {
				chld.subCategory = childData.subCategory;
			}
			chld.advanceInvoice = childData.advanceInvoice;
			chld.template = childData.template;
			console.log("childData.templateChanged : "+childData.templateChanged);
			chld.templateChanged = childData.templateChanged;
			transactionDocument.TransactionTemplates.push(chld);
		}
	}
	if(mode=="edit") {
		transactionDocument.Status = getEID("status").value;
		transactionDocument.formStorageId = formStorageId;
	} else {
		if (action == "publish") {
			transactionDocument.Status = "Active";
		} else {
			transactionDocument.Status = "Draft";
		}
	}
	transactionDocument.formType = modelName;
	console.log(JSON.stringify(transactionDocument));
	ajaxCallAPI('POST', 'persist', transactionDocument, function() {
		let data = this.get("responseData");
		if (data.error) {
			displayMessage('danger', data.error, 3000);
		} else if (Object.keys(data).length === 0) {
			console.log("data : "+data);
			displayMessage('danger', 'Form submission failed.', 3000);
		} else {
			console.log(data.toString());
			var message = "Form successfully submitted.";
			if (transactionDocument.Status == "Draft")
				message = "Record is saved in draft";
			displayMessage('success', message, 3000);
			afterFormSubmissionFormIOForm(transactionDocument);
		}
		showLoading(false);
	}, function() {
		displayMessage('danger', "Error in persisting dynamic form data.", 3000);
		showLoading(false);
	});
}

function fileChange(fileControl) {
	showLoading(true);
	console.log("fileControl : "+fileControl);
	console.log("fileControl : "+fileControl.files[0]);
	console.log("fileControl : "+fileControl.files[0].name);
	var form = document.createElement("form");
    var node = fileControl.cloneNode(true);
	var formType = document.createElement("input");
	formType.setAttribute("type", "hidden");
	formType.setAttribute("name", "formType");
	formType.setAttribute("value", "transactiondocument");
	var fileName = document.createElement("input");
	fileName.setAttribute("type", "hidden");
	fileName.setAttribute("name", "fileName");
	fileName.setAttribute("value", Date.now()+"-"+node.files[0].name);
	
	form.action = ajaxUrl;
	form.method = "post";
	form.enctype = "multipart/form-data";
	form.appendChild(node);
	form.appendChild(formType);
	form.appendChild(fileName);
	form.style.display = "none";

	var XHR = new XMLHttpRequest();
	var FD = new FormData(form);
	XHR.open("POST", ajaxUrl);
	XHR.addEventListener("load", function(event) {
		var resp = JSON.parse(event.target.responseText).result[0];
		console.log("event.target.responseText : "+event.target.responseText);
		showLoading(false);
		  var template = fileControl.parentElement.parentElement.getElementsByClassName("template")[0];
		  var templateChanged = fileControl.parentElement.parentElement.getElementsByClassName("templateChanged")[0];
		  console.log('templateChanged- : '+templateChanged);
		  template.value = resp.name;
		  templateChanged.value = "changed";
	});
	XHR.addEventListener("error", function(event) {
		showLoading(false);
		console.log("Failed to load the file");
		var templateChanged = fileControl.parentElement.parentElement.getElementsByClassName("templateChanged")[0];
		templateChanged.value = "";
	});
	XHR.send(FD);
	
}

//=======================

var childrenHolder = document.getElementById('childrenHolder');
var childrenContainer = document.getElementById('childrenContainer');
var childrenList = [];

function Child(subCategory, advanceInvoice, template, templateChanged, deleteStatus) {
	this.subCategory = subCategory;
	this.advanceInvoice = advanceInvoice;
	this.template = template;
	this.deleteStatus = deleteStatus;
	console.log("--templateChanged : "+templateChanged);
	if(templateChanged == "changed") {
		console.log("--templateChanged : t");
		this.templateChanged = true;
	} else {
		this.templateChanged = false;
		console.log("--templateChanged : f");
	}
}

function addAnotherChild() {
	console.log("addAnotherChild...");
	addAllDataToArray();
	var ss = new Child("", "", "", "", "");
	childrenList.push(ss);
	drawChildrens();
}

function removeChild1(e) {
	console.log("e.parentElement.parentElement.parentElement : "+e.parentElement.parentElement.parentElement.id);
	var eRmv = e.parentElement.parentElement.parentElement.parentElement.parentElement;
	eRmv.getElementsByClassName("deleteStatus")[0].innerHTML = "Remove";
	addAllDataToArray();
	drawChildrens();
	if (childrenList.length == 0) {
		addAnotherChild();
	}
}

function closeChild(closeIcon) {
	var eRmv = closeIcon.parentElement.parentElement.parentElement.parentElement;
	console.log("eRmv : "+eRmv.id);
	var childContent = eRmv.getElementsByClassName("childContent")[0];
	if(childContent.style.display!="none") {
		childContent.style.display = "none";
		closeIcon.style.background = "url(/html/images/expand.png) no-repeat";
	} else {
		childContent.style.display = "block";
		closeIcon.style.background = "url(/html/images/close-minus.png) no-repeat";
	}
}

function addAllDataToArray() {
	while (childrenList.length > 0) {
		childrenList.pop();
	}
	var c = childrenHolder.childElementCount;
	console.log("c : "+c);
	for (var i = 0; i < c; i++) {
		var node = childrenHolder.childNodes[i];
		var subCategory = node.getElementsByClassName("subCategory")[0];
		var advanceInvoice = node.getElementsByClassName("advanceInvoice")[0];
		var template = node.getElementsByClassName("template")[0];
		var templateChanged = node.getElementsByClassName("templateChanged")[0];
		console.log("templateChanged : "+templateChanged);
		console.log("templateChanged : "+templateChanged.value);
		var deleteStatus = node.getElementsByClassName("deleteStatus")[0];
		if (deleteStatus.innerHTML != "Remove") {
			childrenList.push(new Child(subCategory.value, advanceInvoice.value, template.value, templateChanged.value, deleteStatus.innerHTML));
		}
	}
	console.log("childrenList : "+JSON.stringify(childrenList));
}

function downloadDropdownData(model, subTypeId) {
	var productType = productIdValueMap[model];
	console.log(productType);
	
	var strSubURI ="finance.accountingtable."+productType.toLowerCase()+".producsubtype";

	console.log("dashBoardLink : "+window.location.origin);
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
					console.log("productSubTypeList : "+productSubTypeList.length);
					populateProductSubType(subTypeId);
				},
				failure : function() {
					console
							.log("Error in the ajax call.");
				}
			}
		});
	});
}

function drawChildrens() {
	console.log("drawChildrens...");
	var count = 0;
	var i;
	while (childrenHolder.hasChildNodes()) {
		childrenHolder.removeChild(childrenHolder.lastChild);
	}
	console.log("drawChildrens - childrenList : "+JSON.stringify(childrenList));
	for (i = 0; i < childrenList.length; i++) {
		var node = childrenContainer.cloneNode(true);
		var header = node.getElementsByClassName("header")[0]
				.getElementsByTagName("div")[0];
		var subCategory = node.getElementsByClassName("subCategory")[0];
		var advanceInvoice = node.getElementsByClassName("advanceInvoice")[0];
		var template = node.getElementsByClassName("template")[0];
		var templateChanged = node.getElementsByClassName("templateChanged")[0];
		
		loadCommonDropdownDataToElement(advanceInvoice, advanceInvoiceList, "itemValue", "displayName", function(){});
		loadCommonDropdownDataToElement(subCategory, subCategoryList, "itemValue", "displayName", function(){});
		subCategory.value = childrenList[i].subCategory;
		advanceInvoice.value = childrenList[i].advanceInvoice;
		template.value = childrenList[i].template;
		if(childrenList[i].templateChanged==true) {
			templateChanged.value = "changed";
		} else {
			templateChanged.value = "";
		}
		if(mode=="view") {
			subCategory.value = childrenList[i].subCategory==""?"Not Specified":childrenList[i].subCategory;
			advanceInvoice.value = childrenList[i].advanceInvoice==""?"Not Specified":childrenList[i].advanceInvoice;
			template.value = childrenList[i].template==""?"Not Specified":childrenList[i].template;
		}
		node.getElementsByClassName("deleteStatus")[0].innerHTML = childrenList[i].status;
		console.log("childrenList[i].deleteStatus : "
				+ childrenList[i].deleteStatus);
		if (childrenList[i].deleteStatus != "Remove") {
			count = count + 1;
			if (count <= 9) {
				header.innerText = "0" + count +" SUB-CATEGORY";
			} else {
				header.innerText = count+" SUB-CATEGORY";
			}
			node.style.display = "block";
			childrenHolder.appendChild(node);
		}
	}
}

function showLoading(show) {
	if(show) {
		getEID("loadingDiv").style.display = "block";
	} else {
		getEID("loadingDiv").style.display = "none";
	}
}

function getFilename(url)
{
   if (url)
   {
      var m = url.toString().match(/.*\/(.+?)\./);
      if (m && m.length > 1)
      {
         return m[1];
      }
   }
   return "";
}

//==============


