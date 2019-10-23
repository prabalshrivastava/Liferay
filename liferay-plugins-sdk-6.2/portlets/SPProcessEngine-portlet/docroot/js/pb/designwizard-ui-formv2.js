function processFormV2Modal(self){//self is JQuery Obj
	var popupId = 'formV2_model_popup';
	var popupSkeletonId = 'formV2_model_popup_skelton';
	var out = "", dropDownOptions = dropDownOptionsJSONArr.RuleSetsForm, componentId = 0, prevSelectedRuleSetId,dropDownSubmitterOptions = dropDownOptionsJSONArr.roles;
	
	var modal = document.getElementById(popupId);
	var formSkelton = modal.querySelector('#'+popupSkeletonId);
	if(formSkelton)
		formSkelton.parentNode.removeChild(formSkelton);
		
	modal.getElementsByClassName('modal-content')[0].insertBefore(document.getElementById(popupSkeletonId).cloneNode(true), modal.getElementsByClassName('modal-body')[0]);
	
	document.getElementById(popupId).classList.remove("modal-hidden");
	document.getElementById(popupId).classList.add("modal-visible");
	modal.querySelector('#'+popupSkeletonId).classList.remove("modal-hidden");
	modal.querySelector('#'+popupSkeletonId).classList.add("modal-visible");
	modal.querySelector('#allowReprocess').checked = self.data("allowReprocess")||"";

	var formRuleOptions = modal.querySelector('#formRuleOptionsV2');
	var formSubmitterOptions = modal.querySelector("#submitterRoleIdsV2");
	
	
	for (var indx = 0; indx < dropDownOptions.length; indx++) {
		out += '<option value="' + dropDownOptions[indx].id + '">' + dropDownOptions[indx].name + '</option>';
	}
	formRuleOptions.innerHTML = out;
	
	//populate submitterRoleIdsV2
	out= "<option value='0'>Select Role/Roles</option>";
	for (var indx = 0; indx < dropDownSubmitterOptions.length; indx++)
		out += '<option value="' + dropDownSubmitterOptions[indx].id + '">' + dropDownSubmitterOptions[indx].name + '</option>';
	formSubmitterOptions.innerHTML = out;
	
	
	if(self.data("name"))//If pop-up was already saved.
		modal.querySelector('#customNameTxtFieldV2').value = self.data("name");
	
	if(self.data("waitMsg"))//If pop-up was already saved.
		modal.querySelector('#waitMessageV2').value = self.data("waitMsg");
	
	if(self.data("submittableByApplicant"))//If pop-up was already saved.
		modal.querySelector('#submittableByApplicantV2').checked = self.data("submittableByApplicant");

	if(self.data("submitterRoleIds"))
		setSelectedIndex(modal.querySelector('#submitterRoleIds'), self.data("submitterRoleIds"));
	
	var selectedFormRule = self.data('selectedIndx') || dropDownOptions[0].id || -1;//selectedFormRule itself is ruleSetId--- '#formRuleOptions'
	var selectedFormSubmitter = self.data('submitterRoleIds') || dropDownSubmitterOptions[0].id || -1;
	
	
	setSelectedIndex(formRuleOptions, selectedFormRule);
	setSelectedIndex(formSubmitterOptions, selectedFormSubmitter);
	prevSelectedRuleSetId = selectedFormRule;
	
	$("#formRuleOptionsV2").bind("change", function() {
		selectedFormRule = parseInt(modal.querySelector('#formRuleOptionsV2').value);				
		dropDownOptions.forEach(function(o) {
			if(o.id == selectedFormRule) {
				componentId = o.componentId;
			}
		});
		self.data("dataMapping",  new Array());
		populateDataMapSectionV2(componentId, self, modal);
	});
	
	dropDownOptions.forEach(function(o) {
		if (o.id == selectedFormRule) {
			componentId = o.componentId;
		}
	});
	
	populateDataMapSectionV2(componentId, self, modal);	//Populate dataMapOption Section for 1st selected ruleset.
	addRuleSectionV2(self, modal, "ruleFormIdV2");

	var btnSave = modal.querySelector('#btnModelSave');
	btnSave.onclick = function() {
		self.data("allowReprocess", modal.querySelector('#allowReprocess').checked);
		selectedFormRule = parseInt(modal.querySelector('#formRuleOptionsV2').value);
		self.data('selectedIndx', selectedFormRule);
		
		var selectedOptionObj = null;
		for(var i = 0; i < dropDownOptions.length; i++){
			if(dropDownOptions[i].id == selectedFormRule){
				selectedOptionObj = dropDownOptions[i];
				break;
			}
		}		
		
		var dataMapSection = modal.getElementsByClassName("dataMapSectionV2");
		var dataMapOptions = [], dataMapTextFields = [], selectedDataMapOption = null; dataMappingArr = [], mappingElement = {}, dataMapTextFieldVal = null;

		for (var indx = 0; indx < dataMapSection.length; indx++) {
			
			//Keep track of duplicate selection of drop down in formDataMapOptions field.
			selectedDataMapOption = dataMapSection[indx].querySelector('#formDataMapOptionsV2').value;
			if (dataMapOptions.indexOf(selectedDataMapOption) > -1) {
				dataMapSection[indx].querySelector('#formDataMapOptionsV2').style.borderColor = "red";
				//If there are no datamaprows
				if(document.getElementById('addDataMapSectionBtnIdV2').style.display == 'none')
					return;
			}
			if(selectedDataMapOption != 0){
			dataMapOptions.push(selectedDataMapOption);
			
			dataMapTextFieldVal = dataMapSection[indx].querySelector('#formDataMapTextFieldV2').value;
			if(dataMapTextFieldVal){
				var regExp = /^[a-zA-Z0-9_]*$/;
				     if (regExp.test(dataMapTextFieldVal)) {
				    	 dataMapTextFields.push(dataMapTextFieldVal);
				        }
				      else {      
				    	  dataMapSection[indx].querySelector('#formDataMapTextFieldV2').style.borderColor = "red";
							if(document.getElementById('addDataMapSectionBtnIdV2').style.display == 'none')
								return;	
				        }
				
			}
			else{
				dataMapSection[indx].querySelector('#formDataMapTextFieldV2').style.borderColor = "red";
				if(document.getElementById('addDataMapSectionBtnIdV2').style.display == 'none')
					return;				
			}
			
			mappingElement = {};
			mappingElement.processFieldId = dataMapSection[indx].querySelector('#formDataMapTextFieldV2').value;
			mappingElement.fieldId = dataMapSection[indx].querySelector('#formDataMapOptionsV2').value;
			
			dataMappingArr.push(mappingElement);	
			}
		}
		
		
		var ruleSection = modal.getElementsByClassName("ruleSectionV2");
		var selectedEditableSteps = null, selectedEditableByRoles = null; rulesArr = [], mappingElementRules = {}, validationError = false;

		for (var indx = 0; indx < ruleSection.length; indx++) {

			selectedEditableByRoles = $(ruleSection[indx].querySelector('#editableByRolesV2')).val();
			selectedFieldName = ruleSection[indx].querySelector('#fieldName').text;
			selectedEditableSteps = $(ruleSection[indx].querySelector('#editableStepsV2')).val();
			
			if((selectedEditableByRoles != null) && (selectedEditableSteps != null)){
				
				ruleSection[indx].querySelector('#editableByRolesV2').style.border = "solid 1px #d9dce3";
				ruleSection[indx].querySelector('#editableStepsV2').style.border = "solid 1px #d9dce3";
			
				mappingElementRules = {};
				mappingElementRules.roles = selectedEditableByRoles;
				mappingElementRules.fieldName = selectedFieldName;
				mappingElementRules.steps = selectedEditableSteps;
			
				rulesArr.push(mappingElementRules);	
				
			}else {
				if((selectedEditableByRoles == null) && (selectedEditableSteps != null)){
					validationError = true;
					ruleSection[indx].querySelector('#editableByRolesV2').style.borderColor = "red";
					ruleSection[indx].querySelector('#editableStepsV2').style.border = "solid 1px #d9dce3";
				
				
			}	if((selectedEditableByRoles != null) && (selectedEditableSteps == null)){
					validationError = true;
					ruleSection[indx].querySelector('#editableByRolesV2').style.border = "solid 1px #d9dce3";
					ruleSection[indx].querySelector('#editableStepsV2').style.borderColor = "red";
				
				
			}
			
			}
		}
		
		if(validationError == true){
			return;
		}
		
		
		modal.style.display = "none";
		
		var childrenObsrver = isChildRequired(self, prevSelectedRuleSetId, selectedOptionObj.id);
		if(childrenObsrver == false) return;
		
		self.data("submitterRoleIds",$(modal.querySelector('#submitterRoleIdsV2')).val());
		self.data("submittableByApplicant",modal.querySelector('#submittableByApplicantV2').checked);
		self.data("dataMapTextFields", dataMapTextFields);
		self.data("dataMapping", dataMappingArr);
		self.data("editOptions", rulesArr);
		self.data("name", modal.querySelector('#customNameTxtFieldV2').value);
		
		//extract html content from editor 
		htmlContent = modal.querySelector('#waitMessageV2').value;
		self.data("waitMsg",htmlContent);
		
		//sets node text
		var currDivX = self.position().left - canvasPosition.left + self.outerWidth() + sLeft;
		var currDivY = self.position().top - canvasPosition.top + self.outerHeight() / 2 + sTop;
		
		var nodeText = $("#formRuleOptionsV2 option:selected").text();
		
		//set tooltip text
		if(nodeText==="")
			self[0].setAttribute('title',"Default");
		else
			self[0].setAttribute('title',nodeText);
		
		if(self.data('ownText')) self.data('ownText').remove();
		self.data('ownText', drawText(currDivX - 70, currDivY - 70 , nodeText))
		self.data('nodeText', nodeText);
		layer.draw();
		
		if(childrenObsrver === 'updateAllExceptRule') return;
		
		self.data("rulesetId", selectedOptionObj.id);
		
		var ruleNames = [];
		var ruleIds = [];

		selectedOptionObj.rules.forEach(function(entry) {ruleNames.push(entry.name);});
		selectedOptionObj.rules.forEach(function(entry) {ruleIds.push(entry.id);});
		lineColor = addHexColor(lineColor, colorInterval);
		
		prepareChildren(self, parseInt(selectedOptionObj.rules.length) + 1, ruleNames, ruleIds);
		
	}

	modal.style.display = "block";	
}

function showDataMapSectionV2(){
	
	document.getElementById('addDataMapSectionBtnIdV2').style.display = 'none';
	document.getElementById('dataMapIdV2').style.display = 'block';
}

function hideDataMapSectionV2(dataMapSection){
	document.getElementById('addDataMapSectionBtnIdV2').style.display = 'block';
	document.getElementById('dataMapIdV2').style.display = 'none';
	$('#dataMapIdV2').find('.dataMapSectionV2').remove();
	$('#dataMapIdV2').append(dataMapSection);
}

function showRuleSectionFormV2(){
	
	document.getElementById('addRuleSectionFormBtnIdV2').style.display = 'none';
	document.getElementById('ruleFormIdV2').style.display = 'block';
}

function hideRuleSectionFormV2(ruleSection){
	document.getElementById('addRuleSectionFormBtnIdV2').style.display = 'block';
	document.getElementById('ruleFormIdV2').style.display = 'none';
	$('#ruleFormIdV2').find('.ruleSectionV2').remove();
	$('#ruleFormIdV2').append(ruleSection);
}

function populateDataMapSectionV2(componentId, self, modal) {
	// rest call to FormBuilderServiceImpl
	Liferay.Service(
	  '/SPMicroservice-portlet.spmicroservice/get-form-fields',
	  {
	    userId: Liferay.ThemeDisplay.getUserId(),
	    formId: componentId,
	    includeLayout: false,
	    fullInfo: false
	  },
	  function(obj) {
	    console.log(obj);
	    dataMapOptionList =  obj;
	  	addFormV2DataMapSection(dataMapOptionList, self, modal);
	  }
	);
}

function addFormV2DataMapSection(dataMapOptionList, self, modal) {

	var formDataMapRowElement = modal.getElementsByClassName("dataMapSectionV2");
	var formDataMapOptions = null, createOption = null;
	for (var outerCntIndx = 0; outerCntIndx < formDataMapRowElement.length; outerCntIndx++) {
		formDataMapOptions = formDataMapRowElement[outerCntIndx].querySelector('#formDataMapOptionsV2');
		formDataMapOptions.innerHTML = "";
		var out = "<option value='0'>Select Field</option>";
		for (var innerCntIndex = 0 ; innerCntIndex < dataMapOptionList.length; innerCntIndex++ ) 
			out += "<option value=" + dataMapOptionList[innerCntIndex].id + ">" + dataMapOptionList[innerCntIndex].label + "</option>";
		formDataMapOptions.innerHTML = out;
	}
	
	//set data map options selcted....
	var dataMappingArr = self.data("dataMapping");
	var dataMappingArrLen = dataMappingArr == undefined ? -1 : dataMappingArr.length;
	
	var dataMapSection = formDataMapRowElement[0];
	
	//if nothing was set in DataMapSection then show "Add Data Map Section" button, else make this button invisible.
	if(dataMappingArrLen > 0)
		showDataMapSectionV2();
	else 
		hideDataMapSectionV2(dataMapSection);
	
	for ( var indx = 0; indx < dataMappingArrLen; indx++) {	
		formDataMapRowElement = modal.getElementsByClassName("dataMapSectionV2");
		formDataMapRowElement[indx].querySelector('#formDataMapOptionsV2').value = dataMappingArr[indx].fieldId;
		formDataMapRowElement[indx].querySelector('#formDataMapTextFieldV2').value = dataMappingArr[indx].processFieldId;
		
		if (formDataMapRowElement.length < dataMappingArrLen)
			modal.querySelector('#dataMapIdV2').appendChild(dataMapSection.cloneNode(true));
	}
}

function addRuleSectionV2(self, modal, id) {
	
	var dropDownEditableByOptions = dropDownOptionsJSONArr.roles,dropDownEditableStepsOptions = dropDownOptionsJSONArr.steps;
	var formRuleRowElement = modal.getElementsByClassName("ruleSectionV2");
	var formEditableByOptions = null, formEditableStepOptions = null, createOption = null, fieldNameOptions = null;
	for (var outerCntIndx = 0; outerCntIndx < formRuleRowElement.length; outerCntIndx++) {
		formEditableByOptions = formRuleRowElement[outerCntIndx].querySelector('#editableByRolesV2');
		formEditableByOptions.innerHTML = "";
		var out = "<option value='0'>Select Role/Roles</option>";
		for (var innerCntIndex = 0 ; innerCntIndex < dropDownEditableByOptions.length; innerCntIndex++ ) 
			out += "<option value=" + dropDownEditableByOptions[innerCntIndex].id + ">" + dropDownEditableByOptions[innerCntIndex].name + "</option>";
		formEditableByOptions.innerHTML = out;
		
		formEditableStepOptions = formRuleRowElement[outerCntIndx].querySelector('#editableStepsV2');
		formEditableStepOptions.innerHTML = "";
		var out = "<option value='0'>Select Status Type/Status Types</option>";
		for (var innerCntIndex = 0 ; innerCntIndex < dropDownEditableStepsOptions.length; innerCntIndex++ ) 
			out += "<option value=" + dropDownEditableStepsOptions[innerCntIndex].id + ">" + dropDownEditableStepsOptions[innerCntIndex].name + "</option>";
		formEditableStepOptions.innerHTML = out;
		
		fieldNameOptions = formRuleRowElement[outerCntIndx].querySelector('#stepIdV2');
		fieldNameOptions.innerHTML = "";
		var out = "<option id='fieldName' value='Status Type'>Status Type</option>";
		fieldNameOptions.innerHTML = out;
		
	}
	
	//set data map options selcted....
	var rulesArr = self.data("editOptions");
	var rulesArrLen = rulesArr == undefined ? -1 : rulesArr.length;
	
	var ruleSection = formRuleRowElement[0];//.cloneNode(true);
		
	//if nothing was set in rule section then show "Add Rule Section" button, else make this button invisible.
	if(rulesArrLen > 0)
		showRuleSectionFormV2();
	else 
		hideRuleSectionFormV2(ruleSection);
	
	for ( var indx = 0; indx < rulesArrLen; indx++) {	
		formRuleRowElement = modal.getElementsByClassName("ruleSectionV2");
			
			setSelectedIndex(formRuleRowElement[indx].querySelector('#editableByRolesV2'), rulesArr[indx].roles);
			formRuleRowElement[indx].querySelector('#fieldName').value = rulesArr[indx].fieldName;
			setSelectedIndex(formRuleRowElement[indx].querySelector('#editableStepsV2'), rulesArr[indx].steps);
		
		if (formRuleRowElement.length < rulesArrLen)
			modal.querySelector('#'+id).appendChild(ruleSection.cloneNode(true));
	}
}
