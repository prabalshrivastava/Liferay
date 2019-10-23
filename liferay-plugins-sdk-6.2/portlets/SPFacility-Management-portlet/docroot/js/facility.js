var modelName = "facility"
var subFacilityList;
var responseData;
var modelStatus = "";
var contentJsonData;
var actStatus = "Active";

var scheduleFacilityLink = [];
subFacilityList = [];
function SubFacility(SubFacilityID, SFCode, SFName, SFUnit, SFCapacity,
		SFFloorPlan, SFMap, SFStatus,visible) {
	this.SubFacilityID = SubFacilityID;
	this.SFCode = SFCode;
	this.SFName = SFName;
	this.SFUnit = SFUnit;
	this.SFCapacity = SFCapacity;
	this.SFFloorPlan = SFFloorPlan;
	this.SFMap = SFMap;
	this.SFStatus = SFStatus;
	this.Visible = visible;
}
function drawTable() {
	var count = 0;
	var i;
	while (subFacilityHolder.hasChildNodes()) {
		subFacilityHolder.removeChild(subFacilityHolder.lastChild);
	}
	for (i = 0; i < subFacilityList.length; i++) {
		var node = subFacilityBase.cloneNode(true);

		var SubFacilityID = node.getElementsByClassName("subFacilityID")[0];
		var SFStatus = node.getElementsByClassName("SubStatus")[0];
		var Visible = node.getElementsByClassName("Visible")[0];

		var header = node.getElementsByClassName("header")[0]
				.getElementsByTagName("div")[0];
		var subSheduleContent = node.getElementsByClassName("subSheduleContent")[0];
        var expandCollapse = node.getElementsByClassName("expandCollapse")[0];
		var SFCode = node.getElementsByClassName("subFacilityCode")[0];
		var SFName = node.getElementsByClassName("subFacilityName")[0];
		var SFUnit = node.getElementsByClassName("subFacilityUnit")[0];
		var SFCapacity = node.getElementsByClassName("subFacilityCapacity")[0];
		var SFFloorPlan = node.getElementsByClassName("sbFloorPlan")[0];
		var SFMap = node.getElementsByClassName("sbLocationMap")[0];

		SubFacilityID.innerHTML = subFacilityList[i].SubFacilityID;
		SFStatus.innerHTML = subFacilityList[i].SFStatus;
		Visible.innerHTML = subFacilityList[i].Visible;
		SFCode.value = subFacilityList[i].SFCode;
		SFName.value = subFacilityList[i].SFName;
		SFUnit.value = subFacilityList[i].SFUnit;
		SFCapacity.value = subFacilityList[i].SFCapacity;
		SFFloorPlan.innerHTML = subFacilityList[i].SFFloorPlan;
		SFMap.innerHTML = subFacilityList[i].SFMap;
		if (subFacilityList[i].Visible == "hide") {
			subSheduleContent.style.display = "none";
			expandCollapse.className = expandCollapse.className.replace(
					/\bminusIcon\b/g, "addIcon");
		} else {
			subSheduleContent.style.display = "block";
			expandCollapse.className = expandCollapse.className.replace(
					/\baddIcon\b/g, "minusIcon");
		}
		if (subFacilityList[i].SFStatus != "Remove") {
			count = count + 1;
			header.innerText = count + " Sub-Facility";
			node.style.display = "block";
		} else {
			node.style.display = "none";
		}
		subFacilityHolder.appendChild(node);
	}
	if (mode == "view") {
		enableViewMode();
		
	}

}


function unhide(id) {
	var e = document.getElementById(id);
	var r = e.parentElement;
	r.children[2].classList.remove('hide');
	return 0
}
function hide(id) {
	var e = document.getElementById(id);
	var r = e.parentElement;
	r.children[2].classList.add('hide');
	return 1
}


function addAllDataToArray() {
	while (subFacilityList.length > 0) {
		subFacilityList.pop();
	}
	var c = subFacilityHolder.childElementCount;
	for (var i = 0; i < c; i++) {
		var node = subFacilityHolder.childNodes[i];
		// SubFacilityID, SFName, SFUnit, SFCapacity, SFFloorPlan,
		// SFMap,SubStatus

		var SubFacilityID = node.getElementsByClassName("subFacilityID")[0].innerHTML;
		var SFStatus = node.getElementsByClassName("SubStatus")[0].innerHTML;
	
		var SFCode = node.getElementsByClassName("subFacilityCode")[0].value;
		var SFName = node.getElementsByClassName("subFacilityName")[0].value;
		var SFUnit = node.getElementsByClassName("subFacilityUnit")[0].value;
		var SFCapacity = node.getElementsByClassName("subFacilityCapacity")[0].value;
		var SFFloorPlan = node.getElementsByClassName("sbFloorPlan")[0].innerHTML;
		var SFMap = node.getElementsByClassName("sbLocationMap")[0].innerHTML;
		var visible = node.getElementsByClassName("Visible")[0];
		var ss = new SubFacility(SubFacilityID, SFCode, SFName, SFUnit,
				SFCapacity, SFFloorPlan, SFMap, SFStatus,visible.innerHTML);

		subFacilityList.push(ss);
	}

}

var hasClassAddSubFacility = false;
function AddSubFacility() {
	console.log("AddSubFacility=>")
	if (!hasClassAddSubFacility) {
		var element = document.getElementsByClassName("addSubFacilityBtn")[0];
		element.classList.add("posChange");
		hasClassAddSubFacility = true;
	}

	addAllDataToArray()
	var ss = new SubFacility("", "", "", "", "", "", "", "");
	subFacilityList.push(ss);
	drawTable()
}
var remove = 0;
function RemoveSubFecility(e) {
	if(mode != "view"){
		parentt = findAncestor(e,"addSubFacility");
		var SubFacilityID = parentt.getElementsByClassName("subFacilityID")[0];
		var nonRemovable=false
		for(var i=0;i<scheduleFacilityLink.length;i++){
			if(SubFacilityID.innerHTML==scheduleFacilityLink[i].StorageIdRight1){
				nonRemovable=true;
				break;
			}
		}
		if(!nonRemovable){
			parentt.getElementsByClassName("SubStatus")[0].innerHTML = "Remove";
			addAllDataToArray();
			drawTable();
		}else{
			removeRejectAlert();
		}
	}
		
}

/* <<<=== Load Default Data ===>>> */

function loadDefaultData() {
	if (mode == "create") {
		loadDropdownList("Facility Type", facilityType);
		setTimeout(function() {
			loadFacilityCategory(); 
		},1500)
	} else if (mode == "edit" || mode == "copy" || mode == "view") {
		fetchDetails(formStorageId);
		if(mode == "edit"){
			getScheduleFacilityLinkData();
		}
		
	}
	
}

function loadFacilityCategory() {
	facilityCategory.options.length = 0;
	if (facilityType.value == "Internal") {
		loadDropdownList("Facility Internal Category", facilityCategory);
	} else if (facilityType.value == "External") {
		loadDropdownList("Facility External Category", facilityCategory);
	}
}

/* <<<=== Submit Form Value ===>>> */

var saveDraft = false;
function saveDraftFields() {
	saveDraft = true;
	submitFacility();
}

function validatevalue() {
	var facilityCode = document.getElementById('facilityCode');
	var facilityName = document.getElementById('facilityName');
	var facilityLocation = document.getElementById('facilityLocation');
	var contactPerson = document.getElementById('facilityContactPerson');
	var emailAddress = document.getElementById('facilityContactEmail');
	var contactNumber = document.getElementById('facilityContactNumber');
	
	if (contactPerson.value != "") {
		var e = document.getElementById('facilityContactPerson');
		var r = e.parentElement;
		r.children[2].classList.add('hide');
	}
	if (emailAddress.value != "") {
		var e = document.getElementById('facilityContactEmail');
		var r = e.parentElement;
		r.children[2].classList.add('hide');
	}
	if (contactNumber.value != "") {
		var e = document.getElementById('facilityContactNumber');
		var r = e.parentElement;
		r.children[2].classList.add('hide');
	}
	
	
	
	if (facilityCode.value != "") {
		var e = document.getElementById('facilityCode');
		var r = e.parentElement;
		r.children[2].classList.add('hide');
	}
	if (facilityName.value != "") {
		var e = document.getElementById('facilityName');
		var r = e.parentElement;
		r.children[2].classList.add('hide');
	}
	if (facilityLocation.value != "") {
		var e = document.getElementById('facilityLocation');
		var r = e.parentElement;
		r.children[2].classList.add('hide');
	}
}


function validateFields(e) {
	var facilityCode = document.getElementById('facilityCode');
	var facilityName = document.getElementById('facilityName');
	var facilityLocation = document.getElementById('facilityLocation');
	var facilityCode = document.getElementById('facilityType');
	var _contactNumber = document.getElementById('facilityContactNumber');
	var emailAddress = document.getElementById('facilityContactEmail');
	var contactPerson = document.getElementById('facilityContactPerson');
	
	var invalid_field = "Please fix the following errors before submitting.";
	var eValid = true;
	saveDraft = false;
	 /*var draftButton = e.name;
	 if(draftButton = "draft")
		 {
		  saveDraft = true;
		 }*/
	
	if (document.getElementById('facilityType').value == "") {		
		//selected_1 = unhide("scheduleCode");
		eValid = false;
	}
	if (document.getElementById('facilityCode').value == "") {		
		selected_1 = unhide("facilityCode");
		eValid = false;
	}
	if (document.getElementById('facilityCategory').value == "") {		
		eValid = false;
	}
	if (document.getElementById('facilityName').value == "") {
	//	invalid_field += "<br><b>Facility Name is required.</b>";
		selected_1 = unhide("facilityName");
		eValid = false;
	}
	if (document.getElementById('facilityLocation').value == "") {
		//invalid_field += "<br><b>Facility Location MAP URL is required.</b>";
		selected_1 = unhide("facilityLocation");
		eValid = false;
	}
	  if (facilityType.value == "External"
			&& document.getElementById('facilityContactEmail').value == "") {		
		  selected_1 = unhide('facilityContactEmail');
		eValid = false;
	}
	  if (facilityType.value == "External"
			&& document.getElementById('facilityContactNumber').value == "") {		
		  selected_1 = unhide('facilityContactNumber');
		eValid = false;
	}
	if (facilityType.value == "External"
			&& document.getElementById('facilityContactPerson').value == "") {		
		selected_1 = unhide('facilityContactPerson');
		eValid = false;
	}
	if (eValid) {
		addAllDataToArray();

		for (var i = 0; i < subFacilityList.length; i++) {
			if (subFacilityList[i].SFStatus != "Remove"
					&& subFacilityList[i].SFCode == "") {
				eValid = false;
				displayMessage('danger', "Sub-Facility Code is Mandatory", 3000);
				break;
			} else if (subFacilityList[i].SFStatus != "Remove"
					&& subFacilityList[i].SFName == "") {
				eValid = false;
				displayMessage('danger', "Sub-Facility Name is Mandatory", 3000);
				break;
			} else if (subFacilityList[i].SFStatus != "Remove"
					&& subFacilityList[i].SFUnit == "SFCapacity") {
				eValid = false;
				displayMessage('danger',
						"Sub-Facility Seat Capacity is Mandatory", 3000);
				break;
			}
		}
		if (eValid) {
			ValidateUniqueIDAndSubmit();
		}
	} else {
		displayMessage('danger', invalid_field, 3000);
	}
}

function ValidateUniqueIDAndSubmit() {
	if (mode == "copy"
			|| mode == "create"
			|| (mode == "edit" && formStorageId != document
					.getElementById("facilityCode").value)) {
		var dataV = {
			"limit" : 4,
			"modelName" : modelName,
			"page" : 0,
			"formType" : modelName
		};
		dataV.conditions = [ "contentJson.FacilityCode="
				+ encodeURIComponent(document.getElementById("facilityCode").value) ];
		dataV.sortBy = "contentJson.FacilityCode";
		console.log(dataV);
		ajaxCallAPI('GET', 'searchList', dataV, function() {

			var response = this.get("responseData");
			if (_.isEmpty(response)) {
				console.log("error");

			} else {
				if (response.numberOfElements > 0) {
					displayMessage('danger', "Duplicate Facility Code", 3000);
				} else {
					submitFacility();
				}
			}
		}, function() {

		});
	} else {
		submitFacility();
	}
}

function submitFacility() {
	var facilityType = document.getElementById("facilityType");
	var facilityCode = document.getElementById("facilityCode");
	var facilityCategory = document.getElementById("facilityCategory");
	var facilityName = document.getElementById("facilityName");
	var facilityAddress = document.getElementById("facilityAddress");
	
	var facilityLocationMap = document.getElementsByClassName("FSLocationMapName")[0];
	var facilityLocation = document.getElementById("facilityLocation");
	var facilityContactPerson = document
			.getElementById("facilityContactPerson");
	//var facilitySeating = document.getElementById("facilitySeating");
	var facilityContactEmail = document.getElementById("facilityContactEmail");
	var facilityContactNumber = document
			.getElementById("facilityContactNumber");

	var facilityEquipment = document.getElementById("facilityEquipment");
	var facilityRemarks = document.getElementById("facilityRemarks");

	var facilityObj = {};
	facilityObj.FacilityType = facilityType.value;
	facilityObj.FacilityCode = encodeURIComponent(facilityCode.value);
	facilityObj.FacilityCategory = facilityCategory.value;
	facilityObj.FacilityName = facilityName.value;

	facilityObj.Address = facilityAddress.value;
	facilityObj.LocationMap = facilityLocationMap.innerHTML;

	facilityObj.LocationMapURL = facilityLocation.value;
	facilityObj.ContactPerson = facilityContactPerson.value;
	//facilityObj.Capacity = facilitySeating.value;
	facilityObj.EmailAddress = facilityContactEmail.value;
	facilityObj.ContactNumber = facilityContactNumber.value;
	facilityObj.Equipment = facilityEquipment.value;
	facilityObj.Remarks = facilityRemarks.value;

	if (mode == "copy" || mode == "create") {
		formStorageId = "";
	}
	facilityObj.ModelName = modelName;
	if (saveDraft) {
		modelStatus = "Draft";
	} else {
		modelStatus = actStatus;
	}
	if(mode == 'edit' && actStatus == "Draft")
	{
		modelStatus = "Draft";
	}
	facilityObj.Status = modelStatus;
	facilityObj.formType = modelName;
	facilityObj.formStorageId = encodeURIComponent(formStorageId);
	facilityObj.SubFacilityCount = subFacilityList.length
	facilityObj.SubFacilityList = subFacilityList

	console.log("Facility=>" + JSON.stringify(facilityObj));

	ajaxCallAPI('POST', 'persist', facilityObj, function() {
		var data = this.get("responseData");
		if (data.error) {
			displayMessage('danger', data.error);
		} else {
			formStorageId = data.storageId;
			displayMessage('Data', data);
			addAllDataToArray();
			subFacPos = 0;
			//window.location = successFacilityURL;     
			//submitSubFacility(); //rajjan
			/*if(saveDraft == true)
				{
				  saveDraftSuccess();
				}else*/ if(mode == "edit"){
					submitFormConfirmation();
				}else{
					// showing sucess page
					AUI().use('liferay-portlet-url', function(A) {
					    var e =  Liferay.PortletURL.createRenderURL();
					    e.options.basePortletURL = baseUrl;
					    jspPage = "/html/facility/success.jsp";
					    e.setParameter("jspPage", jspPage);
					    e.setPortletId(namespace.replace(/(^\_+|\_+$)/mg, ''));
					    e.setWindowState("normal");
					    //window.location.href = e.toString();
					    var pattern = /__/g;
					    var dd = e.toString();
					    window.location.href = dd.replace(pattern,"_");
					 });
				}
				
			 
		}
	}, function() {
		displayMessage('danger', "Error in persisting dynamic form data.");
	});
}

var subFacPos = 0
function submitSubFacility() {
	if (subFacPos < subFacilityList.length) {
		var sub = subFacilityList[subFacPos];
		sub.ModelName = "sub" + modelName;
		sub.formType = "sub" + modelName;
		sub.Status = "Active";
		sub.FacilityStorageID = formStorageId;
		if (mode == "copy" || mode == "create") {
			sub.SubFacilityID = formStorageId + "_" + sub.SFCode;
		} else if (mode == "edit") {
			if (sub.SubFacilityID == null
					|| typeof sub.SubFacilityID == 'undefined'
					|| sub.SubFacilityID.length == 0) {

				sub.SubFacilityID = formStorageId + "_" + sub.SFCode;
			} else {
				sub.formStorageId = sub.SubFacilityID
			}

		}

		console.log("Sub-Facility =>" + JSON.stringify(sub));
		ajaxCallAPI('POST', 'persist', sub, function() {
			var data = this.get("responseData");
			if (data.error) {
				displayMessage('danger', data.error);
			} else {
				displayMessage('danger', data);
			}
			subFacPos = subFacPos + 1;
			//submitSubFacility(); rajjan
		}, function() {
			displayMessage('danger', "Error in persisting dynamic form data.");
		});
	} else {
		displayMessage('danger', "Submit Successfully !", 3000);

		// afterFormSubmissionCustomForm("Facility",modelStatus);

	}
}

/* <<< === Load Default Value === >>> */
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
													responseData = this
															.get('responseData');
													for (var i = 0; i < responseData.length; i++) {
														var opt = new Option(
																responseData[i].name,
																responseData[i].name);
														elementDrpDwn.options[elementDrpDwn.options.length] = opt;
													}

													if (mode == "edit"
															|| mode == "copy"
															|| mode == "view") {
														if (strSubURI == "Facility Type") {
															elementDrpDwn.value = contentdata.contentJson.FacilityType
															loadFacilityCategory();
														} else {
															elementDrpDwn.value = contentdata.contentJson.FacilityCategory
														}
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

// /Facility%20Sub-Category
var data, contentdata;
function fetchDetails(formStorageId) {
	var fCode = "";
	if (formStorageId != "") {
		data = {};

		data.formStorageId = encodeURIComponent(formStorageId);
		data.formType = "facility";
		console.log(data);
		ajaxCallAPI(
				'GET',
				"loadData",
				data,
				function() {
					data = this.get("responseData");
			
					contentdata = this.get("responseData");
					if (data.error) {
						displayMessage('danger', data.error);
					} else {
						fCode = contentdata.contentJson.FacilityCode;
						if (mode == "copy") {
							fCode = "Copy-of-" + fCode;
						}
						contentJsonData = contentdata.contentJson;
						actStatus = contentJsonData.Status;
						document.getElementById("facilityType").value = contentJsonData.FacilityType;
						document.getElementById("facilityCode").value = encodeURIComponent(fCode);
						document.getElementById("formStatus").classList.remove("view_holder");
						document.getElementById("formStatus").classList.add("form_"+ actStatus.toLowerCase());
						
						var dataStatus = document.getElementById("formStatus");
						dataStatus.innerText = actStatus;
						document.getElementById("facilityCategory").value = contentJsonData.FacilityCategory;
						document.getElementById("facilityName").value = contentJsonData.FacilityName;
						document.getElementById("facilityAddress").value = contentJsonData.Address;						
						document.getElementsByClassName("FSLocationMapName")[0].innerHTML = contentJsonData.LocationMap.toString();
						document.getElementById("facilityLocation").value = contentJsonData.LocationMapURL;
						document.getElementById("facilityContactPerson").value = contentJsonData.ContactPerson;
						//document.getElementById("facilitySeating").value = contentdata.contentJson.Capacity;
						document.getElementById("facilityContactEmail").value = contentJsonData.EmailAddress;
						document.getElementById("facilityContactNumber").value = contentJsonData.ContactNumber;

						document.getElementById("facilityEquipment").value = contentJsonData.Equipment;
						document.getElementById("facilityRemarks").value = contentJsonData.Remarks;
						
						if (mode == "copy" || mode =="create") 
						{
							dataStatus.innerText = "Draft";	
							actStatus = "Draft";
							
						}
						if (mode == "edit" &&  actStatus =="Draft") 
						{
							document.getElementById("publish").innerText = "Publish";
							document.getElementById("btn-draft").style.display = "inline-block";
							
						}
						if (actStatus == "Active"){
							document.getElementById("formStatus").classList.add("form_active");
						}else if (actStatus == "Inactive"){
							document.getElementById("formStatus").classList.add("form_inactive");
						}
						else if (actStatus == "Draft"){
							document.getElementById("formStatus").classList.add("form_draft");
						}
						if (mode == "edit" && actStatus == "Inactive") {
							document.getElementsByClassName("btn-reactive")[0].style.display = "inline-block";
							document.getElementsByClassName("btn-deactive")[0].style.display = "none";
						} else if (mode == "edit" && actStatus == "Active") {
							document.getElementsByClassName("btn-reactive")[0].style.display = "none";
							document.getElementsByClassName("btn-deactive")[0].style.display = "inline-block";
						}
						if (mode == "view" && actStatus == "Active") {
							document.getElementById('btn-deactive').removeAttribute('style');
						}
						if (mode == "view" && actStatus == "Inactive") {
							document.getElementById('btn-deactive').style.display = "none";
							document.getElementById('btn-reactive').removeAttribute('disabled');
							document.getElementById('btn-reactive').removeAttribute('style');	
						}
						if(actStatus == "Blacklist")
						{
						 document.getElementById("formStatus").classList.add("form_blacklist");
						}
						fetchSubFacility();
					}
				}, function() {
					displayMessage('danger',
							"Error in persisting dynamic form data.");
				});
	}

}
var subfacility;
function fetchSubFacility() {
	var FacilityCode = encodeURIComponent(contentdata.contentJson.FacilityCode);
	var data1 = {
		"limit" : 400,
		"modelName" : "sub" + modelName,
		"page" : 0,
		"formType" : "sub" + modelName
	};
	data1.conditions = [ "contentJson.FacilityStorageID=" + FacilityCode ];
	data1.sortBy = "contentJson.FacilityStorageID";
	ajaxCallAPI(
			'GET',
			'searchList',
			data1,
			function() {

				var response = this.get("responseData");

				subfacility = this.get("responseData");
				for (var i = 0; i < subfacility.content.length; i++) {

					var SubFacilityID = subfacility.content[i].contentJson.SubFacilityID;
					var SFCode = subfacility.content[i].contentJson.SFCode;
					var SFName = subfacility.content[i].contentJson.SFName;
					var SFUnit = subfacility.content[i].contentJson.SFUnit;
					var SFCapacity = subfacility.content[i].contentJson.SFCapacity;
					var SFFloorPlan = subfacility.content[i].contentJson.SFFloorPlan;
					var SFMap = subfacility.content[i].contentJson.SFMap;
					var SFStatus = subfacility.content[i].contentJson.SFStatus;
					var visible = (subfacility.content[i].contentJson
							.hasOwnProperty("Visible") ? subfacility.content[i].contentJson.Visible
							: "show");
					var ss = new SubFacility(SubFacilityID, SFCode, SFName,
							SFUnit, SFCapacity, SFFloorPlan, SFMap, SFStatus ,visible);
					 ss.FacilityStorageID
					subFacilityList.push(ss);

				}
				drawTable();
				if (_.isEmpty(response)) {
					console.log("error");

				}
			}, function() {

			});
	loadDropdownList("Facility Type", facilityType);

	if (mode == "view") {
		
		document.getElementById('cancel').removeAttribute('disabled');
		document.getElementById('edit').removeAttribute('style');
		document.getElementById('edit').removeAttribute('disabled');
		if (mode == "view" && actStatus == "Active") {
			document.getElementById('btn-deactive').removeAttribute('disabled');
			document.getElementById('btn-deactive').removeAttribute('style');
		}
		if (mode == "view" && actStatus == "Inactive") {
			document.getElementById('btn-reactive').removeAttribute('disabled');
			document.getElementById('btn-reactive').removeAttribute('style');
		}
		if (mode == "copy" && actStatus == "Active") {
			document.getElementById('btn-deactive').removeAttribute('disabled');
			document.getElementById('btn-deactive').removeAttribute('style');
		}
		if (mode == "copy" && actStatus == "Inactive") {
			document.getElementById('btn-reactive').removeAttribute('disabled');
			document.getElementById('btn-reactive').removeAttribute('style');
		}
		
		//document.getElementById('saveDraft').style.display="none";
		
	}
}

function enableViewMode() {
	var form = document.getElementById("facilityform");
	var elements = form.elements;
	for (var i = 0, len = elements.length; i < len; ++i) {
		elements[i].readOnly = true;
		elements[i].disabled = true;
	}
	document.getElementById('edit').removeAttribute('disabled');
	document.getElementById('btn-deactive').removeAttribute('disabled');
	document.getElementById('cancel').removeAttribute('disabled');
	/* var btn_cancel = document.getElementsByClassName("btn-cancel")[0];
	btn_cancel.readOnly = false;
	btn_cancel.disabled = false;*/
}

function editSchedude()
{
  editFormIoPage();
}
function showAlertDiv(msg) {
	var showAlertDiv = document.getElementById('form-error-div');
	var errorDiv = document.getElementById('error_msg');
	showAlertDiv.style.display = "block";
	errorDiv.innerHTML = msg;
}

function Active() {
	actStatus = "Active";
	validateFields();
	activatiionsucess();
}
var cancel = false;
 	
function confirm()
{	
	if(document.getElementById("deactivate_reason").value.length > 4){
		  actStatus = "Inactive";	
		  validateFields();
		  deactivationsucess();
		  //window.location = baseUrl
	}else{
		document.getElementById("deactivate_msg").classList.add("alert");
		document.getElementById("deactivate_msg").classList.add("alert-error");
	}
}

function Deactive() {
	deactivate_msg();
}

function backtolist()
  {
	window.location = successFacilityURL;  
  }


function activatiionsucess(){
	var boundingBox = '#activation-success';
	var contentBox = '#active-success-box';
	AUI().use('aui-base', function(A) {		
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
	    Y.all('.close').on(
	      	      'click',
	      	      function() {
	      	    	reload();
	      	        modal.hide();
	      	      }
	      	    );
	  });
	});
}

function deactivationsucess(){
	var boundingBox = '#deactivation-success';
	var contentBox = '#inactive-success-box';
	AUI().use('aui-base', function(A) {		
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
	    Y.all('.close').on(
	      	      'click',
	      	      function() {
	      	    	reload();
	      	        modal.hide();
	      	      }
	      	    );
	  });
	});
}



function deactivate_msg() {
	var boundingBox = '#deactive-record';
	var contentBox = '#deactive-record-box';
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

function cancelbtn() {
	var boundingBox = '#deactive-record';
	var contentBox = '#deactive-record-box';
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
				//reload();
				modal.hide();
			});
		});
	});
}

function removeRejectAlert() {
	var boundingBox = '#remove-popup';
	var contentBox = '#remove-popup-box';
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
				//reload();
				modal.hide();
			});
		});
	});
}
function submitFormConfirmation() {
	var boundingBox = '#sucess-popup';
	var contentBox = '#sucess-popup-box';
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
				//reload();
				modal.hide();
			});
		});
	});
}

function getScheduleFacilityLinkData() {
	var data1 = {};
	data1.limit = "1000";
	data1.page = 0;
	data1.filterdata = [];
	data1.formType = "EntityLink";
	data1.ModelName = "EntityLink";
	ajaxCallAPI(
			'GET',
			'uocommingFacilitySchedule',
			data1,
			function() {
				var data = this.get("responseData");
				if (data.error) {
					displayMessage('danger', data.error);
				} else {
					var cont = data;
					for (var i = 0; i < cont.length; i++) {
						if(mode == "edit"&&cont[i].StorageIdRight==formStorageId){
							scheduleFacilityLink.push(cont[i]);
						}
					}
				}
				
			}, function() {

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
	formType.setAttribute("value", "facility");
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
		template.innerHTML = resp.name;
		templateChanged.value = "changed";
		addAllDataToArray();
	});
	XHR.addEventListener("error", function(event) {
		showLoading(false);
		console.log("Failed to load the file");
		var templateChanged = fileControl.parentElement.parentElement.getElementsByClassName("templateChanged")[0];
		templateChanged.value = "";
	});
	XHR.send(FD);
	
}

function saveDraftSuccess(){
	var boundingBox = '#sucess-popup1';
	var contentBox = '#sucess-popup-box1';
	AUI().use('aui-base', function(A) {		
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
	    Y.all('.close').on(
	      	      'click',
	      	      function() {
	      	    	reload();
	      	        modal.hide();
	      	      }
	      	    );
	  });
	});
}
//To restricting space 
function AvoidSpace(event) {
    var k = event ? event.which : window.event.keyCode;
    if (k == 32) return false;
}
function maxLengthCheck(object) {
	if (object.value.length > object.maxLength)
		object.value = object.value.slice(0, object.maxLength)
}

function collapsOrExpand(e) {
	parentt = findAncestor(e, "facilityContainer");
	if (parentt.getElementsByClassName("Visible")[0].innerHTML == "hide") {
		parentt.getElementsByClassName("Visible")[0].innerHTML = "show";
	} else {
		parentt.getElementsByClassName("Visible")[0].innerHTML = "hide";
	}
	addAllDataToArray();
	drawTable();
}


function reset(myFormElement){
	var elements = myFormElement.elements;
	 myFormElement.reset();
}