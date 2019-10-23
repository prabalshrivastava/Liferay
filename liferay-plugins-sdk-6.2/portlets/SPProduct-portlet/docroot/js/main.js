//VALIDATION
function requiredFieldValidation(elem,label,errorMessage){
	var fcodePlace = null;
	try {
		fcodePlace = document.getElementById(elem.id);
	} catch(err){
		
	}
	
	if(fcodePlace == null){
		fcodePlace= document.getElementById(elem);
	}
	var formvalue = "";
		if(fcodePlace.tagName == "SELECT"){
			var classNames = fcodePlace.getAttribute("class");
			if(classNames.indexOf("multiSelectFied") > -1){
				formvalue = fcodePlace.selectedIndex;
			}else{
				formvalue = fcodePlace.options[fcodePlace.selectedIndex].value;
			}
		}else{
			formvalue = fcodePlace.value.trim();	
		}
		
		if(fcodePlace.tagName == "SELECT"){
			if(formvalue == "" || formvalue == "0" || formvalue == 0 || formvalue == "NA"){
				formvalue = "";
			}
		}
		
	var validateForm = true;
        if (formvalue == "") {
        	
		 fcodePlace.classList.remove("Error-success");
		 fcodePlace.classList.add("Error");
		 if(fcodePlace.tagName == "SELECT"){
				fcodePlace.classList.remove("Error-success");
				 fcodePlace.classList.add("Error");
			 var formOption = fcodePlace.options;
			 formOption[0].innerHTML = errorMessage;
				 
		 }else{
			 var labelind = label.indexOf("*"); 
			 var labelStrip = label.substring(0,labelind+1);
			 fcodePlace.placeholder = labelStrip + errorMessage;
		
			
		 }
		 
		 validateForm = false;
         return false;

    } else {
    	fcodePlace.classList.remove("Error");
    	fcodePlace.classList.add("Error-success");
    	if(fcodePlace.tagName != "SELECT"){
    		fcodePlace.placeholder = label;
			 
		 }
    	validateForm = true;
    
    }
	 
	
	return validateForm;
}

function numberfieldValidation(elem,label,errorMessage,errorMessage1){
	var id_number = null;
	try {
		id_number = document.getElementById(elem.id);
	} catch(err){
		
	}
	if(id_number == null){
		id_number= document.getElementById(elem);
	}
	
	 label = id_number.getAttribute("placeholder");
	 var labelind = label.indexOf("*"); 
	 var labelStrip = label.substring(0,labelind+1);
	 className = id_number.getAttribute("class");
	var z1 = /^[0-9]*$/;
	var validateNumber = true;
	//if(className.indexOf("scheduleFields") == -1){
	if(id_number.value == ""){
		id_number.classList.remove("Error-success");
		id_number.classList.add("Error");
		id_number.placeholder = labelStrip + " " + errorMessage1;
		validateNumber = false;
		return false;
	}
	//}
	var z2 = /^\s*-?[0-9]\d*(\.\d{1,2})?\s*$/;
	if(className.indexOf("decimalField") > -1){
		if(!z2.test(id_number.value)) { 
			id_number.classList.remove("Error-success");
			id_number.classList.add("Error");
			id_number.placeholder = errorMessage;
			id_number.value = '';
			validateNumber = false;
			return false;
		}
		else{
			id_number.classList.remove("Error");
			id_number.classList.add("Error-success");
			id_number.placeholder = label;
			validateNumber = true;
		}
	}
	else{
		if(!z1.test(id_number.value)) { 
			id_number.classList.remove("Error-success");
			id_number.classList.add("Error");
			id_number.placeholder = errorMessage;
			id_number.value = '';
			validateNumber = false;
			return false;
		}
		else{
			id_number.classList.remove("Error");
			id_number.classList.add("Error-success");
			id_number.placeholder = label;
			validateNumber = true;
		}
	}	
	return validateNumber;
	   
}
function urlFieldValidation(elem,label,errorMessage){
	
	var field = null;
	try {
		field = document.getElementById(elem.id);
	} catch(err){
		
	}
	if(field == null){
		field= document.getElementById(elem);
	}
	
	label = field.getAttribute("placeholder");
	
	var validateNumber = true;
	if(field.value == ""){
		return true;
	}
	else if(!validateURL(field.value)) { // defined in pure_javascript_functions.js
		field.classList.remove("Error-success");
		field.classList.add("Error");
		field.placeholder = errorMessage;
		field.value = '';
		validateNumber = false;
		return false;
	}
	else{
		field.classList.remove("Error");
		field.classList.add("Error-success");
		field.placeholder = label+"";
		validateNumber = true;
	}
	return validateNumber;
	
}

function ValidateFileUpload() {
	var form_childclass_image = document.getElementsByClassName('imageField');
	var validateImage = true;
	for (var i = 0; i < form_childclass_image.length; i++)
	{
		var img_attrclassVal = form_childclass_image[i];
		var idImageValue= img_attrclassVal.getAttribute('value');
		var imgWrap = document.getElementsByClassName('Image_upload');
		var img_attrclassVal1 = imgWrap[i];
	    var z2 = /^[0-9]*$/;
	    
	    if (idImageValue == "") {

	    	img_attrclassVal1.classList.add("Error");
	    	validateImage = false;
	    	return false;

	    }else if(!z2.test(idImageValue)) { 

	    	img_attrclassVal1.classList.add("Error");
	    	validateImage = false;
			return false;
		}
	    
	    else{
	    	img_attrclassVal1.classList.remove("Error");
	    	img_attrclassVal1.classList.add("Error-success");
	    	validateImage = true;
	    	
	    }
	
	}
	return validateImage;

}

function validateForm(wrapperid,errorMessage1,errorMessage2,errorMessage3,errorMessage4) {
	
	var img_childclass = document.getElementById(wrapperid).getElementsByClassName('imageField');
	var isValidField = false;
	var errorMessage = errorMessage1
	for (var i = 0; i < img_childclass.length; i++)
	{
		var img_attrclass = img_childclass[i];
		var attribute_imgclass = img_attrclass.getAttribute("class");
		 if(attribute_imgclass.indexOf("imageField") > -1){
			 if(ValidateFileUpload() == false)
				
               return false;
			
			}
	}
	
	var form_childclass = document.getElementById(wrapperid).getElementsByClassName('Requiredfield');
	for (var i = 0; i < form_childclass.length; i++)
	{
		var form_attrclass = form_childclass[i];
		var formTag = form_attrclass.tagName;
		if(formTag == "SELECT"){
			errorMessage = errorMessage4;
		}else{
			errorMessage = errorMessage1;
		}
		//console.log("formTag " + formTag);
		var attribute_class = form_attrclass.getAttribute("class");
        if(attribute_class.indexOf("Requiredfield") > -1){
			var id1 = form_attrclass.getAttribute('id');
			var label1 = form_attrclass.getAttribute('placeholder');
			isValidField = requiredFieldValidation(id1,label1,errorMessage);
			
//			if(attribute_class.indexOf("RequiredfieldSchedule") > -1){
//				isValidField = requiredFieldValidation(id1,label1,"Please enter the values in Schedule Tab");
//				if(!isValidField){
//					document.getElementById("schCertErrorMsg").innerHTML = "Please enter the values in Schedule Tab";
//				}
//			}
//			if(attribute_class.indexOf("RequiredfieldCertificate") > -1){
//				isValidField = requiredFieldValidation(id1,label1,"Please enter the values in Certificate Tab");
//				if(!isValidField){
//					document.getElementById("schCertErrorMsg").innerHTML = "Please enter the values in Certificate Tab";
//				}
//			}
			
			if(attribute_class.indexOf("autoComplete") > -1){
				if(!isValidField){
					var valueNode = form_attrclass.nextElementSibling;
					 var labelind = label1.indexOf("*"); 
					 var labelStrip = label1.substring(0,labelind+1);
					 valueNode.placeholder = labelStrip + errorMessage;
					 valueNode.classList.remove("Error-success");
					 valueNode.classList.add("Error");
				}
			}
			
			if(isValidField){
				document.getElementById(id1).classList.remove("Error-success");
				document.getElementById(id1).classList.remove("Error");
				isValidField=true;
			}else{
				isValidField=false;
				return false;
			}
		
		}
		
		if(attribute_class.indexOf("Numberfield") > -1){
			var id2 = form_attrclass.getAttribute('id');
			var label2 = form_attrclass.getAttribute('placeholder');
			isValidField1 = numberfieldValidation(id2,label2,errorMessage2);
			if(isValidField1){
				document.getElementById(id2).classList.remove("Error-success");
				document.getElementById(id2).classList.remove("Error");
				isValidField=true;
				
			}else{
				isValidField=false;
				return false;
			}
		
		}
			
		
	}
	
	// validating url fields
	form_childclass = document.getElementById(wrapperid).getElementsByClassName('Urlfield');
	for (var i = 0; i < form_childclass.length; i++)
	{
		var form_attrclass = form_childclass[i];
		var attribute_class = form_attrclass.getAttribute("class");
		 
        if(attribute_class.indexOf("Urlfield") > -1){
			var id1 = form_attrclass.getAttribute('id');
			var label1 = form_attrclass.getAttribute('placeholder');
			isValidField = urlFieldValidation(id1,label1,errorMessage3);
			if(isValidField){
				document.getElementById(id1).classList.remove("Error-success");
				document.getElementById(id1).classList.remove("Error");
				isValidField=true;
			}else{
				isValidField=false;
				return false;
			}
		}
	}
	
	return isValidField;
    
}

function getMultiSelectValues(elementId) {
    var selectList = document.getElementById(elementId);
    var selectedItems = [];
    for (var i = 0; i < selectList.length; i++) {
        if (selectList.options[i].selected) selectedItems.push(selectList.options[i].value);
    }
    return selectedItems;
}

function getAutoCompleteValues(elementId) {
    var selectList = document.getElementById(elementId);
    var selectedItems = [];
    if (selectList != null){
    	var selectListValues = selectList.value;
        var selectListValue = selectListValues.split(",");
        for (var i = 0; i < selectListValue.length; i++) {
            if (selectListValue[i] >0) selectedItems.push(selectListValue[i]);
        }
    }
    return selectedItems;
}


function createInstanceElements(tag,className,id,name,type,placeholder,maxlength,event,eventValue,url,isMandatory,isNumberOnly,isTextOnly,reqMessage,numbMessage){
	var elem = document.createElement(tag);
	if(isMandatory){
		  className += " Requiredfield ";
		  elem.setAttribute("onblur","javacript:requiredFieldValidation(this,'"+ placeholder + "','"+ reqMessage + "')");
	}
	if(isNumberOnly){
		  className += " Numberfield ";
		  elem.setAttribute("onblur","javacript:numberfieldValidation(this,'"+ placeholder + "','"+ numbMessage + "')");
	}
	if(isTextOnly){
		className += " CharField ";
	
	}
	if(className != ''){
		elem.setAttribute("class",className);
	}
	if(id != ''){
		elem.setAttribute("id",id);
	}
	if(name != ''){
		elem.setAttribute("name",name);
	}
	if(type != ''){
		elem.setAttribute("type",type);
	}
	if(placeholder != ''){
		elem.setAttribute("placeholder",placeholder);
	}
	if(maxlength != ''){
		elem.setAttribute("maxlength",maxlength);
	}
	if(event != ''){
		elem.setAttribute(event,eventValue);
	}
	if(url != ''){
		elem.setAttribute("src",url);
	}
	return elem;
}


function addCKEditor(edtrName,resizable,ckeditordiv,editorText){
	CKEDITOR.replace( edtrName,
			{
				resize_enabled: resizable,
				toolbar :
				[
	         	        ['Bold', 'Italic', 'Underline', 'Strike'],
	         	        ['NumberedList', 'BulletedList', '-', 'Outdent', 'Indent', 'Link']
	         	]
				//onChangeMethod :'updateInputField'
			});
	
	window.CKEDITOR.instances[edtrName].setData(editorText);
	edtrName = "Ip_"+edtrName;
	var editorValue = createInstanceElements('input','editorValue',edtrName,edtrName,'hidden','','','','','','','','');
	if(editorText == ''){
		editorValue.value="Description";
	}
	ckeditordiv.appendChild(editorValue);
	
}

if( typeof(CKEDITOR) !== "undefined" ) {
	console.log("instance available to attach event");
	CKEDITOR.on('instanceReady', function (ev) {
	    ev.editor.on('afterPaste', function (ev) {
	        var pastedData = window.CKEDITOR.instances[ev.editor.name].getData();
	        pastedData = pastedData.replace(/<\/?[^>]+(>|$)/g, "");
	        window.CKEDITOR.instances[ev.editor.name].setData(pastedData);
	    });
	});
}

function addSelectOptions(tag,value,labelValue,optionList){
	
	var ssnTypeListOption = createElement("option");
	ssnTypeListOption.setAttribute("value","0");
	ssnTypeListOption.setAttribute("disabled","true");
	ssnTypeListOption.setAttribute("selected","true");
	var optTextNode = document.createTextNode("Session Type *");
	ssnTypeListOption.appendChild(optTextNode);
	if(optionList != ''){
		ssnTypeListSelect.innerHTML = optionList;
	}
	ssnTypeListSelect.appendChild(ssnTypeListOption);
	return ssnTypeListSelect;
}


function removeAddedInstance(instanceClass) {
	var elem = document.querySelectorAll("."+instanceClass)[1];
	elem.parentNode.removeChild(elem);
	return true;
}

function removeByInstanceId(instanceId) {
	var elem = document.getElementById(instanceId);
	elem.parentNode.removeChild(elem);
	return true;
}

function removeByInstanceIdWithMandatoryFields(instanceId,errMsg) {
	var elem = document.getElementById(instanceId);
	var elemInstLength = 1;
	if(elem){
		var elemClass = elem.getAttribute("class");
		var elemInst = document.getElementsByClassName(elemClass);
		elemInstLength = elemInst.length;
	if(elemInstLength > 1){
		elem.parentNode.removeChild(elem);
//		if(instanceId.indexOf('feeSectionId') != -1){
//			calculateTotalFees();
//		}
		return true;
	}else{
//		YUI().use(
//				  'aui-modal',
//				  function(Y) {
//				    var modal = new Y.Modal(
//				      {
//				        bodyContent: errMsg,
//				        centered: true,
//				        draggable: false,
//				        render: '#errorMsg-Modal',
//				        resizable: false
//				      }
//				    ).render();
//				  }
//				);
		alert(errMsg);
		return false;
	}
	return true;
	}	
}

function calculateTotalFees(){
	var fees = document.getElementsByClassName('feeAmountData');
	var totalFees = 0;
	for(var j =0;j<fees.length;j++){
		if(document.getElementById('feeAmountDataId_'+j)){
			var feeValue = document.getElementById('feeAmountDataId_'+j).value;
		}	
		totalFees  += Number(feeValue);
	}
    	document.getElementById('total_fees').innerHTML = Number(totalFees).toFixed(2);
}

//MENU


function Rightmenu_toggle(el, className) {
	var el = document.querySelectorAll(el);
	

	for (i = 0; i < el.length; i++) {

		if (el[i].classList) {
			el[i].classList.toggle(className);
		} else {
			var classes = el[i].className.split(' ');
			var existingIndex = -1;
			for (var j = classes.length; j--;) {
				if (classes[j] === className)
					existingIndex = j;
			}

			if (existingIndex >= 0)
				classes.splice(existingIndex, 1);
			else
				classes.push(className);

			el[i].className = classes.join(' ');
		}
	}
}

function removeImage(elem, elemVal){
	var imageDiv = document.getElementById(elem);
	imageDiv.innerHTML = "";
	var imageValueElem = document.getElementById(elemVal);
	imageValueElem.value = "0";
}

function clearAutoCompleteData(id){
	var elm = document.getElementById(id);
	elm.value = '';
}

// used to display error msg below the uploaded file. 
// this function has to be send as configuration param for "error"
function displayErrorMsgUnderFilePreview(file,message){
	if(file){
		var elmnt = file.previewElement.querySelector("#error-custom");
		if(!elmnt){
			elmnt = document.createElement("div")
			elmnt.setAttribute("class","alert alert-error"); // liferay in built error class
			file.previewElement.appendChild(elmnt);
		}
		elmnt.innerHTML=message;
	}
}

// used to clear the uloaded image previews.
function clearImages(newlyUploadedImagesId,existingImagesId){
	try{
		var container = document.getElementById(newlyUploadedImagesId);
		container.classList.remove = "Error-success"
		var elements = container.getElementsByClassName("dz-preview");
		while (elements[0]) { // remove all
			elements[0].parentNode.removeChild(elements[0]);
		}
		
	}catch(err){
		console.log(err);
	}
	
	try{
		var elmnt = document.getElementById(existingImagesId);
		elmnt.innerHTML = ''
	}catch(err){
		
	}

}

function setCKEditorValues(editorIp,editor,i){
	  var editorIpInst = document.getElementById(editorIp+i);
		var editorInst = editor+i;
		var editorpnInst = "_Product_WAR_SPProductportlet_"+editor+i;
		if(editorIpInst && window.CKEDITOR.instances[editorInst]){
			editorIpInst.value = window.CKEDITOR.instances[editorInst].getData();
		}else if(editorIpInst && window.CKEDITOR.instances[editorpnInst]){
			editorIpInst.value = window.CKEDITOR.instances[editorpnInst].getData();
		}
}

function htmlDecode(input)  {
    var doc = new DOMParser().parseFromString(input, "text/html");
    return doc.documentElement.textContent;
  }
  
function unicodeToChar(text) {
   return text.replace(/\\u[\dA-F]{4}/gi, 
          function (match) {
               return String.fromCharCode(parseInt(match.replace(/\\u/g, ''), 16));
          });
}


function decimalFieldValidation(id,errorMessage1){
	var z2 = /^[0-9]*\.?[0-9]*$/;
	var validateElem = document.getElementById(id);
		if(!z2.test(validateElem.value)) { 
			validateElem.classList.remove("Error-success");
			validateElem.classList.add("Error");
			validateElem.placeholder = errorMessage1;//"Enter only decimal numbers";
			validateElem.value = '';
			return false;
		}else{
			validateElem.classList.remove("Error");
			validateElem.classList.add("Error-success");
			return true;
		}
}

function changetoDecimal(id){
	var validateElem = document.getElementById(id);
	validateElem.value = Number(validateElem.value).toFixed(2);
}


//PRODUCT ONLICK

		 function contextMenu(productRow) {
		if (!productRow)
			return;

		var contextMenu = productRow.one('.threedot');
		var productScreen = A.one('.product_createsection');

		productScreen.on('click', function(e) {
			var productUpdatebox = document
					.getElementsByClassName('productUpdatebox');
			for (var k = 0; k < productUpdatebox.length; k++) {
				productUpdatebox[k].classList.add('Display-none');
			}
		});

		contextMenu.on('click', function(e) {
			e.preventDefault();
			e.stopPropagation();
			var productUpdatebox = document
					.getElementsByClassName('productUpdatebox');
			for (var k = 0; k < productUpdatebox.length; k++) {
				productUpdatebox[k].classList.add('Display-none');
			}
			var targ = e.currentTarget;
			var next = targ.next();
			next.removeClass('Display-none');
		});

	}
	 

