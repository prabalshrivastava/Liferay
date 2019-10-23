function simulateEvent(node, eventName) {
   	AUI().use('aui-node', 'aui-base','node-event-simulate', function(A) {
   		AUI().one(node).simulate(eventName);
	});
}

var rootElmntDropFrame = null, dropDownOptionsJSONArr = null, result = null, nodeStructure = {},rootNodeStructure = {};

//Re-usable global variables
var kineticContent, canvasPosition, stage, layer, line, text, circle;
var kineticCanvas = {containerId:'containerId', width:'1500', height:'1000', left:'250px', top:'0px', canvas:{width:'1500', height:'1000'}};

//Constant declaration.
var headlen = 10, headSlope = (Math.PI)/6, circleRedius = 3, vNodeSpace = 80, hNodeSpace = 150, colorInterval = 'aa';

//modifiable global variables.
var lineColor = '000000', currNodeId = 1, loggedNodeIds = [],nodeGroupComponents = [],tableData;;
var lastScrollTop = 0, lastScrollLeft = 0, sTop = 0, sLeft = 0, direction = 0;
var htmlContent="";


$(document).ready(function() {

	dragInitAccordianElmt();
	
	canvasInit();
	
	rootElmntDropFrame = document.getElementById('1');
	addDragDropListner(rootElmntDropFrame);
	
	//Draw the saved designer-wizard by fetching data from request obj.
	if (isUpdate)
		retrieveDesignerWizard();	
	
	if(nodeGroupComponents.indexOf(rootElmntDropFrame.id) == -1 )
		nodeGroupComponents.push(rootElmntDropFrame.id);
	//Remove footer, to adjust place for single scroll bar throught the page.
	try {
		document.getElementById("footer").remove();		
	} catch (e) {
		// consider themes with no footer
	}
	document.getElementsByClassName("main-content-wrap")[0].style.maxHeight = "500px";
	document.getElementsByClassName("main-content-wrap")[0].style.minHeight = "500px";
	
});

/*
 * initializes the left side Process Component Panel. User can drag component from here
 */
function dragInitAccordianElmt(){
	
	$("#catalog").accordion({
		heightStyle: "fill"
	});

	$("#catalog li").draggable({
		appendTo: "body",
		helper: "clone"
	});

	$("#catalog img").draggable({
		appendTo: "body",
		helper: "clone",
		cursor: 'move'
	});	
}

/*
 * Initializes the Kinetic canvas with default size as defined in global var kineticCanvas. 
 * Initializes the stage which will be used further to draw on canvas
 */
function canvasInit() {

	stage = new Kinetic.Stage({
		container: kineticCanvas.containerId,
		width : kineticCanvas.width,
		height : kineticCanvas.height
		
	});
	
	layer = new Kinetic.Layer();
	stage.add(layer);
	
	kineticContent = document.getElementById("containerId").getElementsByClassName("kineticjs-content")[0];
	
	kineticContent.style.position = "absolute";//To prevent UI when its being resized		
	kineticContent.style.left=kineticCanvas.left;
	kineticContent.style.top=kineticCanvas.top;
	
	var canvas = document.getElementsByTagName("canvaS")[0];
	canvas.width = kineticCanvas.canvas.width;
	canvas.height = kineticCanvas.canvas.height;
	
	canvasPosition = $(kineticContent).position();
}

/*
 * this method detects canvas scroll direction and moves all the nodes in that direction 
 */
function moveRectDivs(self, e){
	
	var scrollDir = detectScrollDirection(self);
	
	var rectDivs = document.getElementsByClassName('drop-frame');
	
	for(var indx=0; indx<rectDivs.length; indx++){
		
		var currRectDiv = rectDivs[indx];
		var rectLeft = parseInt(currRectDiv.style.left);
		var scrollLeftDiff = lastScrollLeft - sLeft;
		
		var rectTop = parseInt(currRectDiv.style.top);
		var scrollTopDiff = lastScrollTop - sTop;
		
		switch(scrollDir){
		
			case 'up' : 
			case 'down' : currRectDiv.style.top = (rectTop + scrollTopDiff) + 'px';
				break;
				
			case 'left' :
			case 'right' : currRectDiv.style.left = (rectLeft + scrollLeftDiff) + 'px';
		}
	}
	lastScrollTop = sTop;	
	lastScrollLeft = sLeft;

	e.preventDefault();
}

/*
 * moves the dragged node in scrolled direction 
 */
function moveRectDivsHelper(currRectDiv, scrollDirection){

	var rectLeft = parseInt(currRectDiv.style.left);
	var scrollLeftDiff = lastScrollLeft - sLeft;
	
	var rectTop = parseInt(currRectDiv.style.top);
	var scrollTopDiff = lastScrollTop - sTop;
	
	switch(scrollDirection){
	
		case 'up' : 
		case 'down' : currRectDiv.style.top = (rectTop + scrollTopDiff) + 'px';
			break;
			
		case 'left' :
		case 'right' : currRectDiv.style.left = (rectLeft + scrollLeftDiff) + 'px';
	}
	
	var nodeList = $(currRectDiv).data('children');

	if (nodeList != undefined)
		for (var i = 0; i < nodeList.length; i++)	
			moveRectDivsHelper(nodeList[i], scrollDirection);			
}

/*
 * detects the canvas scroll direction 
 */
function detectScrollDirection(self) {

	sTop = document.body.scrollTop;	
	
	if (sTop > lastScrollTop)
		direction = "up";
	else if(sTop < lastScrollTop)
		direction = "down";
	    
	sLeft = document.body.scrollLeft;
	
	if(sLeft > lastScrollLeft)
		direction = "left";
	else if(sLeft < lastScrollLeft)
		direction = "right";
	
	return  direction;
}


function redrawNodeAttribute(self){//self is JQuery Obj.
	
	var selfX = self.position().left - canvasPosition.left + sLeft;
	var selfY = self.position().top - canvasPosition.top + sTop;
	var nodeWidth = self.outerWidth(), nodeHeight = self.outerHeight();
	
	//re-position self lines and its child lines as well.
	moveNodeLine(self, selfX, selfY);

	//re-position the circle
	var ownCircle = self.data('ownCircle');
	if (ownCircle != undefined) {
		ownCircle.attrs.x = selfX + nodeWidth;
		ownCircle.attrs.y = selfY + nodeHeight / 2;
	}
	
	//re-position the circle
	var ownText = self.data('ownText');
	if (ownText != undefined) {
		ownText.attrs.x = selfX - 10;
		ownText.attrs.y = selfY - 20;
	}
	
	resizeKineticLayer(self[0]);
	layer.draw();//To refresh
	
}

function moveNodeLine(self, selfX, selfY){
	
	var ownLines = self.data('ownLines');	
	var parent = null, angle = 0;
	
	if (ownLines != undefined)// if no case of parentNode.
	for(var cnt = 0; cnt < ownLines.length; cnt++){
		
		parent = $("#" + ownLines[cnt].attrs.parentId);
		angle = getInclination(parent, self);
	
		if((parent.position().left - canvasPosition.left + sLeft) > selfX)
			moveLineHead(ownLines[cnt], angle, selfX + self.outerWidth(), selfY + self.outerHeight() / 2);
		else
			moveLineHead(ownLines[cnt], angle, selfX, selfY + self.outerHeight() / 2);
		
	}			
	
	var children = self.data('children');
	if (children === undefined) //check for the leaf node.
		return;

	for (var cnt = 0; cnt < children.length; cnt++) {
		
		var ownLines = $(children[cnt]).data('ownLines');
		for(var indx = 0; indx < ownLines.length; indx++){
			if(self.attr('id') != ownLines[indx].attrs.parentId)//move only connected lines.
				continue;
			if(($(children[0]).position().left - canvasPosition.left + sLeft) > selfX)
				moveLineTail(ownLines[indx], selfX + self.outerWidth(), selfY + self.outerHeight() / 2);
			else
				moveLineTail(ownLines[indx], selfX, selfY + self.outerHeight() / 2);
		}			
	}	
}

function resizeKineticLayer(self){
	
	var isResizeWidth = (parseInt(kineticCanvas.canvas.width) + parseInt(kineticContent.style.left) - parseInt(self.style.left)) < 100;	
	var isResizHeight = (parseInt(kineticCanvas.canvas.height) + parseInt(kineticContent.style.top) - parseInt(self.style.top)) < 100;
	
	if(!(isResizeWidth || isResizHeight))//If neither of them are required then return;
		return;
	
	if(isResizeWidth){
		
		
		kineticCanvas.canvas.width = parseInt(self.style.left) + 100;
		document.getElementsByTagName("canvaS")[0].width = kineticCanvas.canvas.width;
		document.getElementsByTagName("canvaS")[0].style.width = kineticCanvas.canvas.width + 'px';
		
	}
		
	if(isResizHeight){
		
		kineticCanvas.canvas.height = parseInt(self.style.top) + 100;
		document.getElementsByTagName("canvaS")[0].height = kineticCanvas.canvas.height;		
		document.getElementsByTagName("canvaS")[0].style.height = kineticCanvas.canvas.height + 'px';
	}

}

function moveLineHead(line, lineSlope, headX, headY) {

	line.attrs.points[1].x = headX;
	line.attrs.points[1].y = headY;

	line.attrs.points[2].x = headX - headlen * Math.cos(lineSlope - headSlope);
	line.attrs.points[2].y = headY - headlen * Math.sin(lineSlope - headSlope);
	line.attrs.points[3].x = headX;
	line.attrs.points[3].y = headY;
	line.attrs.points[4].x = headX - headlen * Math.cos(lineSlope + headSlope);
	line.attrs.points[4].y = headY - headlen * Math.sin(lineSlope + headSlope);
}

function moveLineTail(line, tailX, tailY) {
	line.attrs.points[0].x = tailX;
	line.attrs.points[0].y = tailY;
}

function getInclination(nodeA, nodeB) {
	var nodeAX = $(nodeA).position().left - canvasPosition.left + $(nodeA).outerWidth();
	var nodeAY = $(nodeA).position().top - canvasPosition.top + $(nodeA).height() / 2;

	var nodeBX = $(nodeB).position().left - canvasPosition.left;;
	var nodeBY = $(nodeB).position().top - canvasPosition.top + $(nodeB).height() / 2;

	var angle = Math.atan2(nodeBY - nodeAY, nodeBX - nodeAX);
	return angle;
}

/*
 * adds Drag and Drop event listener to the Selector passed
 */
var dragged = null, target = null;
function addDragDropListner(selector) {

	var leafNodeStartx = null, leafNodeStarty = null;
	
	$(selector).draggable({
		
		start: function(event, ui) {
			
			dragged = $(this);
			target = null;
			
			leafNodeStartx = $(selector).position().left;
			leafNodeStarty = $(selector).position().top;	
			
	    },
	    
	    drag: function( event, ui ) {
			redrawNodeAttribute(dragged);
		},
		
		stop: function(event, ui) {			
			if(target && target.hasClass('drop-frame')){
				dragged.css({top: leafNodeStarty, left: leafNodeStartx});
				redrawNodeAttribute(dragged);//adjust the line...
			}				    	
        }
	});
	
	$(selector).droppable({
		
		drop: function(event, ui) {
			
			dragged = $(ui.draggable);
			target = $(this);
			
			nodeDropHandler(selector, dragged, target);
		}
	})
	
	//Assign context-menu, Right-Click event handler
	rootElmntDropFrame.addEventListener("contextmenu", function(){rightClickEventHandler('1');});
}

/*
 * This methods decides whether dragged element can be dropped on to target or not and then takes further actions
 */
function nodeDropHandler(selector, dragged, target){
	
	//code handling for Rect Box Drop
	if(dragged.hasClass('drop-frame') == true){//If image/icon is dragged.
		
		if (isNodeLinkRequired(dragged, target) == true)//***************Defensive strategy*****																			
			linkNode(dragged, target);//Code for linking nodes...										
	
		return;
	}
		
	//Code handling for image drop...
	if(isConnectingNode(target))// no component drop on connecting node 
		return ;
	
	if(($(dragged).is('img') && ($(target).data('children')!=undefined && $(target).data('children')!=0 ))){
		if (confirm('You changed the Component, it will clear child structure. Do you want to proceed?')){
			$(target).find('img').remove();
			var droppedObjClone = dragged.clone();
			droppedObjClone.appendTo(target);
			removeNode(target, new Array, true);
		}
		else
			return;
		
	}else{
		$(target).find('img').remove();
		var droppedObjClone = dragged.clone();
		droppedObjClone.appendTo(target);
	}
	
	if ($(dragged).hasClass("without-child"))
		prepareChildren(target, 1);//1 is no. of outcomes.
	
	var draggedElmntID = dragged.attr("id");
	
	//On click event of image, show the modal pop-up
	droppedObjClone[0].ondblclick = function(event) {
		loadJSONArrForDropDown(draggedElmntID, selector);
		initModal(draggedElmntID + '_model_popup');
	};
}

/*
 * This method decides whether dragged element can be dropped on to target or not and then takes further actions. 
	In the following scenarios, nodes can’t be attached:
		If dragged has children nodes 
		If both dragged and target are sibling nodes
		If dragged and target are root nodes of two detached diagram 
 */
function isNodeLinkRequired(dragged, target){
	
	//checking if not leaf node then return.
	var draggedChildren = dragged.data('children');
	var targetChildren = target.data('children');
	if (draggedChildren != undefined && draggedChildren.length > 0)//if dragged having children i.e dragged element is not the leaf node
		return false;
	
	//If leaf node then execute below snipet.
	var parent = dragged.data("parent");
	
	//Drop on parent is not valid.
	if (parent.is(target))
		return false;

	// connecting two leaf nodes not allowed
	if((draggedChildren != undefined && draggedChildren.length == 0) && (targetChildren != undefined && targetChildren.length == 0) )
		return false;
		
	return true;//If valid
}

function linkNode(dragged, target) {//dragged is JQuery obj
	
	/**Draw a line from dragged to target.
	 * If target is a detached node then connected it directly with the parent of dragged
	 * Dragged is parent
	 * Target is children
	 * */
	var tempDragged=null;
	var index = nodeGroupComponents.indexOf(target[0].id);
	if(!target.data('parent') && index > -1){
		tempDragged = dragged.data('parent');
		var ownLines = dragged.data('ownLines');
		target.data('ownLines',ownLines);
		
		//remove target from the nodeGroupComponents 
		if( index> -1)
			nodeGroupComponents.splice(index, 1);
		
		//traverse each line and change parent to newly created node
		for(var indx=0 ; indx<ownLines.length ; indx++){
			var node = $('#'+ownLines[indx].attrs.parentId);
			var index = node.data('children').indexOf(target[0]);
			if(index == -1)
				node.data('children').push(target[0]);
			
			index = node.data('children').indexOf(dragged[0]);
			if(index > -1)
				node.data('children').splice(index,1);
				
		}
		
		target.data('parent',tempDragged);
		
		if(dragged.data('ownText')) dragged.data('ownText').remove();
		
		$(dragged).removeData('ownLines');
		$(dragged).removeData('parent');
		$(dragged).remove();
		redrawNodeAttribute($(target));


	}
	else{
		if(!dragged.data('children'))
			dragged.data('children', new Array());
		
		dragged.data('children').push(target[0]);
			
		if(!target.data('ownLines'))
			target.data('ownLines', new Array());

		var ownLines = target.data('ownLines');
			
		var lineTailX = dragged.position().left - canvasPosition.left + sLeft;;
		var lineTailY = dragged.position().top - canvasPosition.top + dragged.outerHeight() / 2 + sTop;;
		
		var lineHeadX = target.position().left - canvasPosition.left + sLeft;
		var lineHeadY = target.position().top - canvasPosition.top + target.outerHeight() / 2 + sTop;
		
		var line = drawLine(lineTailX, lineTailY, lineHeadX, lineHeadY, dragged.attr('id'));
		ownLines.push(line);
		
		dragged.data('ownCircle', drawCircle(lineTailX, lineTailY, circleRedius));
	}
		
	
}


function initModal(modalPopupId) {

	var modal = document.getElementById(modalPopupId);// Get the modal

	//When the user clicks anywhere outside of the modal, close it
	window.onclick = function(event) {
		if (event.target == modal)
			modal.style.display = "none";
	}

	// When the user clicks on <span> (x), close the modal
	var span = modal.getElementsByClassName('close')[0];
	span.onclick = function() {
		modal.style.display = "none";
	}

	var btnCancel = modal.querySelector('#btnModelCancel');
	btnCancel.onclick = function() {
		modal.style.display = "none";
	}
}

/*
 * shows modal popups based on Process component 
 */
function displayModelPopup(modalPopupId, self, ajaxUrls) {

	switch(modalPopupId) {
		case 'form_model_popup' : processFormModal($(self)); break;
		case 'formV2_model_popup' : processFormV2Modal($(self)); break;
		case 'process_model_popup' : processProcessModal($(self)); break;
		case 'jsp_model_popup' : processJSPModal($(self)); break;
		case 'mail_model_popup' : processMailModal($(self)); break;
		case 'message_model_popup' : processMessageModal($(self)); break;
		case 'status_model_popup' : processStatusModal($(self)); break;
		case 'account_model_popup' : processAccountModal($(self)); break;
		case 'timer_model_popup' : processTimerModal($(self)); break;
		case 'customAction_model_popup' : processCustomActionModal($(self)); break;
		case 'payment_model_popup' : processPaymentModal($(self), 'payment_model_popup', 'payment_model_popup_skelton', 1); break;
		case 'paymentV2_model_popup' : processPaymentModal($(self), 'paymentV2_model_popup', 'paymentV2_model_popup_skelton', 2); break;
		case 'pricing_model_popup' : processPricingModal($(self), ajaxUrls); break;
		case 'api_model_popup' : processApiModal($(self)); break;
		case 'entity_model_popup' : processEntityModal($(self), ajaxUrls); break;
		case 'preview_model_popup' : processPreviewModal($(self)); break;
		default : break;
	}
}

function processFormModal(self){//self is JQuery Obj
	
	var out = "", dropDownOptions = dropDownOptionsJSONArr.RuleSetsForm, componentId = 0, prevSelectedRuleSetId,dropDownSubmitterOptions = dropDownOptionsJSONArr.roles;
	
	var modal = document.getElementById('form_model_popup');
	var formSkelton = modal.querySelector('#form_model_popup_skelton');
	if(formSkelton)
		formSkelton.parentNode.removeChild(formSkelton);
		
	modal.getElementsByClassName('modal-content')[0].insertBefore(document.getElementById('form_model_popup_skelton').cloneNode(true), modal.getElementsByClassName('modal-body')[0]);
	
	document.getElementById('form_model_popup').classList.remove("modal-hidden");
	document.getElementById('form_model_popup').classList.add("modal-visible");
	modal.querySelector('#form_model_popup_skelton').classList.remove("modal-hidden");
	modal.querySelector('#form_model_popup_skelton').classList.add("modal-visible");
	modal.querySelector('#allowReprocess').checked = self.data("allowReprocess")||"";
	
	var formRuleOptions = modal.querySelector('#formRuleOptions');
	var formSubmitterOptions = modal.querySelector("#submitterRoleIds");
	
	
	
	for (var indx = 0; indx < dropDownOptions.length; indx++)
		out += '<option value="' + dropDownOptions[indx].id + '">' + dropDownOptions[indx].name + '</option>';
	formRuleOptions.innerHTML = out;
	
	//populate submitterRoleIds
	out= "<option value='0'>Select Role/Roles</option>";
	for (var indx = 0; indx < dropDownSubmitterOptions.length; indx++)
		out += '<option value="' + dropDownSubmitterOptions[indx].id + '">' + dropDownSubmitterOptions[indx].name + '</option>';
	formSubmitterOptions.innerHTML = out;
	
	
	if(self.data("name"))//If pop-up was already saved.
		modal.querySelector('#customNameTxtField').value = self.data("name");
	
	if(self.data("waitMsg"))//If pop-up was already saved.
		modal.querySelector('#waitMessage').value = self.data("waitMsg");
	
	if(self.data("submittableByApplicant"))//If pop-up was already saved.
		modal.querySelector('#submittableByApplicant').checked = self.data("submittableByApplicant");

	if(self.data("submitterRoleIds"))
		setSelectedIndex(modal.querySelector('#submitterRoleIds'), self.data("submitterRoleIds"));
	
	var selectedFormRule = self.data('selectedIndx') || dropDownOptions[0].id || -1;//selectedFormRule itself is ruleSetId--- '#formRuleOptions'
	var selectedFormSubmitter = self.data('submitterRoleIds') || dropDownSubmitterOptions[0].id || -1;
	
	
	setSelectedIndex(formRuleOptions, selectedFormRule);
	setSelectedIndex(formSubmitterOptions, selectedFormSubmitter);
	prevSelectedRuleSetId = selectedFormRule;
	
	//set listner for selection change event.
	$("#formRuleOptions").bind("change", function() {
		selectedFormRule = parseInt(modal.querySelector('#formRuleOptions').value);				
		dropDownOptions.forEach(function(o) {if(o.id == selectedFormRule) componentId = o.componentId;});
		self.data("dataMapping",  new Array());
		populateDataMapSection(componentId, self, modal);
	});
	
	dropDownOptions.forEach(function(o) {if(o.id == selectedFormRule) componentId = o.componentId;});//set componentId.
	populateDataMapSection(componentId, self, modal);	//Populate dataMapOption Section for 1st selected ruleset.
	addRuleSection(self, modal, "ruleFormId");

	var btnSave = modal.querySelector('#btnModelSave');
	btnSave.onclick = function() {
		self.data("allowReprocess", modal.querySelector('#allowReprocess').checked);
		selectedFormRule = parseInt(modal.querySelector('#formRuleOptions').value);
		self.data('selectedIndx', selectedFormRule);
		
		var selectedOptionObj = null;
		for(var i = 0; i < dropDownOptions.length; i++){
			if(dropDownOptions[i].id == selectedFormRule){
				selectedOptionObj = dropDownOptions[i];
				break;
			}
		}		
		
		var dataMapSection = modal.getElementsByClassName("dataMapSection");
		var dataMapOptions = [], dataMapTextFields = [], selectedDataMapOption = null; dataMappingArr = [], mappingElement = {}, dataMapTextFieldVal = null;

		for (var indx = 0; indx < dataMapSection.length; indx++) {
			
			//Keep track of duplicate selection of drop down in formDataMapOptions field.
			selectedDataMapOption = dataMapSection[indx].querySelector('#formDataMapOptions').value;
			if (dataMapOptions.indexOf(selectedDataMapOption) > -1) {
				dataMapSection[indx].querySelector('#formDataMapOptions').style.borderColor = "red";
				//If there are no datamaprows
				if(document.getElementById('addDataMapSectionBtnId').style.display == 'none')
					return;
			}
			if(selectedDataMapOption != 0){
			dataMapOptions.push(selectedDataMapOption);
			
			dataMapTextFieldVal = dataMapSection[indx].querySelector('#formDataMapTextField').value;
			if(dataMapTextFieldVal){
				var regExp = /^[a-zA-Z0-9_]*$/;
				     if (regExp.test(dataMapTextFieldVal)) {
				    	 dataMapTextFields.push(dataMapTextFieldVal);
				        }
				      else {      
				    	  dataMapSection[indx].querySelector('#formDataMapTextField').style.borderColor = "red";
							if(document.getElementById('addDataMapSectionBtnId').style.display == 'none')
								return;	
				        }
				
			}
			else{
				dataMapSection[indx].querySelector('#formDataMapTextField').style.borderColor = "red";
				if(document.getElementById('addDataMapSectionBtnId').style.display == 'none')
					return;				
			}
			
			mappingElement = {};
			mappingElement.processFieldId = dataMapSection[indx].querySelector('#formDataMapTextField').value;
			mappingElement.fieldId = dataMapSection[indx].querySelector('#formDataMapOptions').value;
			
			dataMappingArr.push(mappingElement);	
			}
		}
		
		
		var ruleSection = modal.getElementsByClassName("ruleSection");
		var selectedEditableSteps = null, selectedEditableByRoles = null; rulesArr = [], mappingElementRules = {}, validationError = false;

		for (var indx = 0; indx < ruleSection.length; indx++) {

			selectedEditableByRoles = $(ruleSection[indx].querySelector('#editableByRoles')).val();
			selectedFieldName = ruleSection[indx].querySelector('#fieldName').text;
			selectedEditableSteps = $(ruleSection[indx].querySelector('#editableSteps')).val();
			
			if((selectedEditableByRoles != null) && (selectedEditableSteps != null)){
				
				ruleSection[indx].querySelector('#editableByRoles').style.border = "solid 1px #d9dce3";
				ruleSection[indx].querySelector('#editableSteps').style.border = "solid 1px #d9dce3";
			
				mappingElementRules = {};
				mappingElementRules.roles = selectedEditableByRoles;
				mappingElementRules.fieldName = selectedFieldName;
				mappingElementRules.steps = selectedEditableSteps;
			
				rulesArr.push(mappingElementRules);	
				
			}else {
				if((selectedEditableByRoles == null) && (selectedEditableSteps != null)){
					validationError = true;
					ruleSection[indx].querySelector('#editableByRoles').style.borderColor = "red";
					ruleSection[indx].querySelector('#editableSteps').style.border = "solid 1px #d9dce3";
				
				
			}	if((selectedEditableByRoles != null) && (selectedEditableSteps == null)){
					validationError = true;
					ruleSection[indx].querySelector('#editableByRoles').style.border = "solid 1px #d9dce3";
					ruleSection[indx].querySelector('#editableSteps').style.borderColor = "red";
				
				
			}
			
			}
		}
		
		if(validationError == true){
			return;
		}
		
		
		modal.style.display = "none";
		
		var childrenObsrver = isChildRequired(self, prevSelectedRuleSetId, selectedOptionObj.id);
		if(childrenObsrver == false) return;
		
		self.data("submitterRoleIds",$(modal.querySelector('#submitterRoleIds')).val());
		self.data("submittableByApplicant",modal.querySelector('#submittableByApplicant').checked);
		self.data("dataMapTextFields", dataMapTextFields);
		self.data("dataMapping", dataMappingArr);
		self.data("editOptions", rulesArr);
		self.data("name", modal.querySelector('#customNameTxtField').value);
		
		//extract html content from editor 
		htmlContent = modal.querySelector('#waitMessage').value;
		self.data("waitMsg",htmlContent);
		
		//sets node text
		var currDivX = self.position().left - canvasPosition.left + self.outerWidth() + sLeft;
		var currDivY = self.position().top - canvasPosition.top + self.outerHeight() / 2 + sTop;
		
		var nodeText = $("#formRuleOptions option:selected").text();
		
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

function isChildRequired(self, prevSelectedRuleSetId, currSelectedRuleSetId){
	
	//If ruleSet is chnaged i.e in case of reconfiuration, pass a flag to indicate that rulset is changed and take decision from user.
	
	var children = self.data("children");
	var childrenCnt = children ? children.length : -1;
	if(childrenCnt <= 0)//if first time configuration
		return true;
	
	if(!(currSelectedRuleSetId == prevSelectedRuleSetId)){//if seleccted rulesetid is changed
		if (confirm('You changed the ruleset, it will clear child structure. Do you want to proceed?')){
			removeNode(self, new Array(), true);
			return true;
		}else
			return false;
	}
	
	return 'updateAllExceptRule';
}

function addFormDataMapSection(dataMapOptionList, self, modal) {

	var formDataMapRowElement = modal.getElementsByClassName("dataMapSection");
	var formDataMapOptions = null, createOption = null;
	for (var outerCntIndx = 0; outerCntIndx < formDataMapRowElement.length; outerCntIndx++) {
		formDataMapOptions = formDataMapRowElement[outerCntIndx].querySelector('#formDataMapOptions');
		formDataMapOptions.innerHTML = "";
		var out = "<option value='0'>Select Field</option>";
		for (var innerCntIndex = 0 ; innerCntIndex < dataMapOptionList.length; innerCntIndex++ ) 
			out += "<option value=" + dataMapOptionList[innerCntIndex].id + ">" + dataMapOptionList[innerCntIndex].label + "</option>";
		formDataMapOptions.innerHTML = out;
	}
	
	//set data map options selcted....
	var dataMappingArr = self.data("dataMapping");
	var dataMappingArrLen = dataMappingArr == undefined ? -1 : dataMappingArr.length;//var dataMappingArrLen = dataMappingArr == undefined ? -1 : dataMappingArr.length;
	
	var dataMapSection = formDataMapRowElement[0];//.cloneNode(true);
	
	//if nothing was set in DataMapSection then show "Add Data Map Section" button, else make this button invisible.
	if(dataMappingArrLen > 0)
		showDataMapSection();
	else 
		hideDataMapSection(dataMapSection);
	
	for ( var indx = 0; indx < dataMappingArrLen; indx++) {	
		formDataMapRowElement = modal.getElementsByClassName("dataMapSection");
		formDataMapRowElement[indx].querySelector('#formDataMapOptions').value = dataMappingArr[indx].fieldId;
		formDataMapRowElement[indx].querySelector('#formDataMapTextField').value = dataMappingArr[indx].processFieldId;
		
		if (formDataMapRowElement.length < dataMappingArrLen)
			modal.querySelector('#dataMapId').appendChild(dataMapSection.cloneNode(true));
	}
}


function addJspDataMapSection(self, modal) {

	var jspDataMapRowElement = modal.getElementsByClassName("dataMapSectionJsp");
	var jspDataMapOptions = null, createOption = null;
	
	//set data map options selcted....
	var dataMappingArr = self.data("dataMapping");
	var dataMappingArrLen = dataMappingArr == undefined ? -1 : dataMappingArr.length;//var dataMappingArrLen = dataMappingArr == undefined ? -1 : dataMappingArr.length;
	
	var dataMapSection = jspDataMapRowElement[0];//.cloneNode(true);
	
	//if nothing was set in DataMapSection then show "Add Data Map Section" button, else make this button invisible.
	if(dataMappingArrLen > 0)
		showDataMapSectionJsp();
	else 
		hideDataMapSectionJsp(dataMapSection);
	
	for ( var indx = 0; indx < dataMappingArrLen; indx++) {	
		jspDataMapRowElement = modal.getElementsByClassName("dataMapSectionJsp");
		jspDataMapRowElement[indx].querySelector('#jspDataMapOptions').value = dataMappingArr[indx].fieldId;
		jspDataMapRowElement[indx].querySelector('#jspDataMapTextField').value = dataMappingArr[indx].processFieldId;
		
		if (jspDataMapRowElement.length < dataMappingArrLen)
			modal.querySelector('#dataMapJspId').appendChild(dataMapSection.cloneNode(true));
	}
}

function addPaymentDataMapSection(self, modal) {

	var paymentDataMapRowElement = modal.getElementsByClassName("dataMapSectionPayment");
	var paymentDataMapOptions = null, createOption = null;
	
	//set data map options selcted....
	var dataMappingArr = self.data("dataMapping");
	var dataMappingArrLen = dataMappingArr == undefined ? -1 : dataMappingArr.length;//var dataMappingArrLen = dataMappingArr == undefined ? -1 : dataMappingArr.length;
	
	var dataMapSection = paymentDataMapRowElement[0];//.cloneNode(true);
	
	//if nothing was set in DataMapSection then show "Add Data Map Section" button, else make this button invisible.
	if(dataMappingArrLen > 0)
		showDataMapSectionPayment();
	else 
		hideDataMapSectionPayment(dataMapSection);
	
	for ( var indx = 0; indx < dataMappingArrLen; indx++) {	
		paymentDataMapRowElement = modal.getElementsByClassName("dataMapSectionPayment");
		paymentDataMapRowElement[indx].querySelector('#paymentDataMapOptions').value = dataMappingArr[indx].fieldId;
		paymentDataMapRowElement[indx].querySelector('#paymentDataMapTextField').value = dataMappingArr[indx].processFieldId;
		
		if (paymentDataMapRowElement.length < dataMappingArrLen)
			modal.querySelector('#dataMapPaymentId').appendChild(dataMapSection.cloneNode(true));
	}
}

function addRuleSection(self, modal, id) {
	
	var dropDownEditableByOptions = dropDownOptionsJSONArr.roles,dropDownEditableStepsOptions = dropDownOptionsJSONArr.steps;
	var formRuleRowElement = modal.getElementsByClassName("ruleSection");
	var formEditableByOptions = null, formEditableStepOptions = null, createOption = null, fieldNameOptions = null;
	for (var outerCntIndx = 0; outerCntIndx < formRuleRowElement.length; outerCntIndx++) {
		formEditableByOptions = formRuleRowElement[outerCntIndx].querySelector('#editableByRoles');
		formEditableByOptions.innerHTML = "";
		var out = "<option value='0'>Select Role/Roles</option>";
		for (var innerCntIndex = 0 ; innerCntIndex < dropDownEditableByOptions.length; innerCntIndex++ ) 
			out += "<option value=" + dropDownEditableByOptions[innerCntIndex].id + ">" + dropDownEditableByOptions[innerCntIndex].name + "</option>";
		formEditableByOptions.innerHTML = out;
		
		formEditableStepOptions = formRuleRowElement[outerCntIndx].querySelector('#editableSteps');
		formEditableStepOptions.innerHTML = "";
		var out = "<option value='0'>Select Status Type/Status Types</option>";
		for (var innerCntIndex = 0 ; innerCntIndex < dropDownEditableStepsOptions.length; innerCntIndex++ ) 
			out += "<option value=" + dropDownEditableStepsOptions[innerCntIndex].id + ">" + dropDownEditableStepsOptions[innerCntIndex].name + "</option>";
		formEditableStepOptions.innerHTML = out;
		
		fieldNameOptions = formRuleRowElement[outerCntIndx].querySelector('#stepId');
		fieldNameOptions.innerHTML = "";
		var out = "<option id='fieldName' value='Status Type'>Status Type</option>";
		fieldNameOptions.innerHTML = out;
		
	}
	
	//set data map options selcted....
	var rulesArr = self.data("editOptions");
	var rulesArrLen = rulesArr == undefined ? -1 : rulesArr.length;
	
	var ruleSection = formRuleRowElement[0];//.cloneNode(true);
		
	//if nothing was set in rule section then show "Add Rule Section" button, else make this button invisible.
	if (id == "ruleJspId"){
		if(rulesArrLen > 0)
			showRuleSectionJsp();
		else 
			hideRuleSectionJsp(ruleSection);
	} else{
		if(rulesArrLen > 0)
			showRuleSectionForm();
		else 
			hideRuleSectionForm(ruleSection);
	}
	
	for ( var indx = 0; indx < rulesArrLen; indx++) {	
		formRuleRowElement = modal.getElementsByClassName("ruleSection");
			
			setSelectedIndex(formRuleRowElement[indx].querySelector('#editableByRoles'), rulesArr[indx].roles);
			formRuleRowElement[indx].querySelector('#fieldName').value = rulesArr[indx].fieldName;
			setSelectedIndex(formRuleRowElement[indx].querySelector('#editableSteps'), rulesArr[indx].steps);
		
		if (formRuleRowElement.length < rulesArrLen)
			modal.querySelector('#'+id).appendChild(ruleSection.cloneNode(true));
	}
}

function processProcessModal(self){//self is JQuery Obj

	var modal = document.getElementById('process_model_popup');// Get the modal

	var out = null, dropDownOptions = dropDownOptionsJSONArr.processRulesV1;

	var ruleVersion = self.data("ruleVersion") || "1";
	
	var _populateRuleOptions = function() {
		if (ruleVersion == "2") {
			dropDownOptions = dropDownOptionsJSONArr.processRulesV2;
		} else {
			dropDownOptions = dropDownOptionsJSONArr.processRulesV1;
		}
		out= "";
		for (var indx = 0; indx < dropDownOptions.length; indx++)
			out += '<option value="' + dropDownOptions[indx].id + '">' + dropDownOptions[indx].name + '</option>';
		document.getElementById('processRuleOptions').innerHTML = out;		
	}
	
	var ruleVersionComp = $(modal.querySelector('#ruleVersion'));
	var ruleVersionChangeHandler = function() {
		ruleVersion = ruleVersionComp.val();
		_populateRuleOptions();
	}
	
	_populateRuleOptions();

	//Resume the previously selected options
	var selectedIndex = self.data('selectedIndx') || -1;
	setSelectedIndex(document.getElementById('processRuleOptions'), selectedIndex);
	var prevSelectedRuleSetId = selectedIndex;
	
	ruleVersionComp.val(ruleVersion);
	try {
		ruleVersionComp.unbind("change", ruleVersionChangeHandler);
		ruleVersionComp.bind("change", ruleVersionChangeHandler);		
	} catch (e) {
		console.log("error in binding rule version change handler", e);
	}
	
	var btnSave = modal.querySelector('#btnModelSave');
	btnSave.onclick = function() {
		self.data("allowReprocess", modal.querySelector('#allowReprocess').checked);
		modal.style.display = "none";

		var selectedIndx = parseInt(modal.querySelector('#processRuleOptions').value);
		var selectedOptionObj = null;
		for(var i = 0; i < dropDownOptions.length; i++)
		  if(dropDownOptions[i].id == selectedIndx)
			  selectedOptionObj = dropDownOptions[i];
				
		var ruleNames = [];
		var ruleId = [];

		var childrenObsrver = isChildRequired(self, prevSelectedRuleSetId, selectedOptionObj.id);
		if(childrenObsrver == false) return;
		
		self.data("rulesetId", selectedOptionObj.id);
		self.data("selectedIndx", selectedIndx);	
		self.data("ruleVersion", ruleVersionComp.val());

		selectedOptionObj.rules.forEach(function(entry) {ruleNames.push(entry.name);});
		selectedOptionObj.rules.forEach(function(entry) {ruleId.push(entry.id);});

		if(childrenObsrver == 'updateAllExceptRule') return;
		prepareChildren(self, parseInt(selectedOptionObj.rules.length) + 1, ruleNames, ruleId);

		lineColor = addHexColor(lineColor, colorInterval);
		
		var currDivX = self.position().left - canvasPosition.left + self.outerWidth() + sLeft;
		var currDivY = self.position().top - canvasPosition.top + self.outerHeight() / 2 + sTop;
		
		var nodeText = $("#processRuleOptions option:selected").text();
		self.data('ownText').remove();
		self.data('nodeText', nodeText);
		self.data('ownText', drawText(currDivX - 70, currDivY - 70 , nodeText));
		
		//set tooltip text
		if(nodeText==="")
			self[0].setAttribute('title',"Default");
		else
			self[0].setAttribute('title',nodeText);
		
		layer.draw();
	}
	modal.style.display = "block";
}

function processJSPModal(self){//self is JQuery Obj

	var modal = document.getElementById('jsp_model_popup');// Get the modal
	var jspSkelton = modal.querySelector('#jsp_model_popup_skelton');
	if(jspSkelton)
		jspSkelton.parentNode.removeChild(jspSkelton);
		
	modal.getElementsByClassName('modal-content')[0].insertBefore(document.getElementById('jsp_model_popup_skelton').cloneNode(true), modal.getElementsByClassName('modal-submit')[0]);
	
	document.getElementById('jsp_model_popup').classList.remove("modal-hidden");
	document.getElementById('jsp_model_popup').classList.add("modal-visible");
	modal.querySelector('#jsp_model_popup_skelton').classList.remove("modal-hidden");
	modal.querySelector('#jsp_model_popup_skelton').classList.add("modal-visible");
	modal.querySelector('#allowReprocess').checked = self.data("allowReprocess")||"";
	
	var out = "<option value='0'>Select Role/Roles</option>", dropDownOptions = dropDownOptionsJSONArr.ruleSetJsp, dropDownSubmitterOptions = dropDownOptionsJSONArr.roles;

	var formSubmitterOptions = modal.querySelector("#submitterRoleIds");
	
	//populate submitterRoleIds
	
	for (var indx = 0; indx < dropDownSubmitterOptions.length; indx++)
		out += '<option value="' + dropDownSubmitterOptions[indx].id + '">' + dropDownSubmitterOptions[indx].name + '</option>';
	formSubmitterOptions.innerHTML = out;

	var ruleVersion = self.data("ruleVersion") || "1";
	
	//populate jsp rule options
	var _populateJSPRuleOptions = function() {
		if (ruleVersion == "2") {
			dropDownOptions = dropDownOptionsJSONArr.RuleSetsJSP;
		} else {
			dropDownOptions = dropDownOptionsJSONArr.ruleSetJsp;
		}
		out= "";
		for (var indx = 0; indx < dropDownOptions.length; indx++)
			out += '<option value="' + dropDownOptions[indx].id + '">' + dropDownOptions[indx].name + '</option>';
		document.getElementById('jspRuleOptions').innerHTML = out;		
	}
	
	var jspRuleVersionComp = $(modal.querySelector('#ruleVersion'));
	var jspRuleVersionChangeHandler = function() {
		ruleVersion = jspRuleVersionComp.val();
		_populateJSPRuleOptions();
	}
	
	_populateJSPRuleOptions();
	jspRuleVersionComp.val(ruleVersion);
	try {
		jspRuleVersionComp.unbind("change", jspRuleVersionChangeHandler);
		jspRuleVersionComp.bind("change", jspRuleVersionChangeHandler);		
	} catch (e) {
		console.log("error in binding rule version change handler", e);
	}
	
	if(self.data("waitMsg")){//If pop-up was already saved.
		modal.querySelector('#waitMessage').value = self.data("waitMsg");
		htmlContent=self.data("waitMsg");
	}
		
	if(self.data("submittableByApplicant"))//If pop-up was already saved.
		modal.querySelector('#submittableByApplicant').checked = self.data("submittableByApplicant");

	if(self.data("submitterRoleIds"))
		setSelectedIndex(modal.querySelector('#submitterRoleIds'), self.data("submitterRoleIds"));
	
	var selectedFormSubmitter = self.data('submitterRoleIds') || -1;

	setSelectedIndex(formSubmitterOptions, selectedFormSubmitter);

	//Resume the previously selected options
	modal.querySelector('#customNameTxtField').value = self.data("name")||"";
	var selectedIndex = self.data('selectedIndx') || -1;
	setSelectedIndex(document.getElementById('jspRuleOptions'), selectedIndex);
	var prevSelectedRuleSetId = selectedIndex;
	
	addJspDataMapSection(self, modal);
	addRuleSection(self, modal, "ruleJspId");
	
	var btnSave = modal.querySelector('#btnModelSave');
	btnSave.onclick = function() {
		self.data("allowReprocess", modal.querySelector('#allowReprocess').checked);
		var selectedIndx = parseInt(modal.querySelector('#jspRuleOptions').value);
		var selectedOptionObj = null;
		for(var i = 0; i < dropDownOptions.length; i++)
		  if(dropDownOptions[i].id == selectedIndx)
			  selectedOptionObj = dropDownOptions[i];
		
		
		var dataMapSection = modal.getElementsByClassName("dataMapSectionJsp");
		var dataMapOptions = [], dataMapTextFields = [], selectedDataMapOption = null; dataMappingArr = [], mappingElement = {}, dataMapTextFieldVal = null;

		for (var indx = 0; indx < dataMapSection.length; indx++) {
			
			//Keep track of duplicate selection of drop down in jspDataMapOptions field.
			selectedDataMapOption = dataMapSection[indx].querySelector('#jspDataMapOptions').value;
			if (dataMapOptions.indexOf(selectedDataMapOption) > -1) {
				dataMapSection[indx].querySelector('#jspDataMapOptions').style.borderColor = "red";
				//If there are no datamaprows
				if(document.getElementById('addDataMapSectionJspBtnId').style.display == 'none')
					return;
			}
			else{
				dataMapSection[indx].querySelector('#jspDataMapOptions').style.border = "solid 1px #d9dce3";
			}
			if(selectedDataMapOption){
			dataMapOptions.push(selectedDataMapOption);
			
			dataMapTextFieldVal = dataMapSection[indx].querySelector('#jspDataMapTextField').value;
			if(dataMapTextFieldVal){
				var regExp = /^[a-zA-Z0-9_]*$/;
				     if (regExp.test(dataMapTextFieldVal)) {
				    	 dataMapSection[indx].querySelector('#jspDataMapTextField').style.border = "solid 1px #d9dce3";
				    	 dataMapTextFields.push(dataMapTextFieldVal);
				        }
				      else {      
				    	  dataMapSection[indx].querySelector('#jspDataMapTextField').style.borderColor = "red";
							if(document.getElementById('addDataMapSectionJspBtnId').style.display == 'none')
								return;	
				        }
				
			}
			else{
				dataMapSection[indx].querySelector('#jspDataMapTextField').style.borderColor = "red";
				if(document.getElementById('addDataMapSectionJspBtnId').style.display == 'none')
					return;				
			}
			
			mappingElement = {};
			mappingElement.processFieldId = dataMapSection[indx].querySelector('#jspDataMapTextField').value;
			mappingElement.fieldId = dataMapSection[indx].querySelector('#jspDataMapOptions').value;
			
			dataMappingArr.push(mappingElement);	
			}
		}
		
		var ruleSection = modal.getElementsByClassName("ruleSection");
		var selectedEditableSteps = null, selectedEditableByRoles = null; rulesArr = [], mappingElementRules = {}, validationError = false;

		for (var indx = 0; indx < ruleSection.length; indx++) {

			selectedEditableByRoles = $(ruleSection[indx].querySelector('#editableByRoles')).val();
			selectedFieldName = ruleSection[indx].querySelector('#fieldName').text;
			selectedEditableSteps = $(ruleSection[indx].querySelector('#editableSteps')).val();
			
			if((selectedEditableByRoles != null) && (selectedEditableSteps != null)){
				
				ruleSection[indx].querySelector('#editableByRoles').style.border = "solid 1px #d9dce3";
				ruleSection[indx].querySelector('#editableSteps').style.border = "solid 1px #d9dce3";
			
				mappingElementRules = {};
				mappingElementRules.roles = selectedEditableByRoles;
				mappingElementRules.fieldName = selectedFieldName;
				mappingElementRules.steps = selectedEditableSteps;
			
				rulesArr.push(mappingElementRules);	
				
			}else {
				if((selectedEditableByRoles == null) && (selectedEditableSteps != null)){
					validationError = true;
					ruleSection[indx].querySelector('#editableByRoles').style.borderColor = "red";
					ruleSection[indx].querySelector('#editableSteps').style.border = "solid 1px #d9dce3";
				
				
			}	if((selectedEditableByRoles != null) && (selectedEditableSteps == null)){
					validationError = true;
					ruleSection[indx].querySelector('#editableByRoles').style.border = "solid 1px #d9dce3";
					ruleSection[indx].querySelector('#editableSteps').style.borderColor = "red";
				
				
			}
			
			}
		}
		
		if(validationError == true){
			return;
		}
		
		modal.style.display = "none";
		
		var ruleNames = [];
		var ruleId = [];

		var childrenObsrver = isChildRequired(self, prevSelectedRuleSetId, selectedOptionObj.id);
		if(childrenObsrver == false) return;
		
		self.data("configuredType", selectedOptionObj.type);
		self.data("rulesetId", selectedOptionObj.id);
		self.data("name", modal.querySelector('#customNameTxtField').value);
		self.data("selectedIndx", selectedIndx);
		self.data("submitterRoleIds",$(modal.querySelector('#submitterRoleIds')).val());
		self.data("submittableByApplicant",modal.querySelector('#submittableByApplicant').checked);
		self.data("editOptions", rulesArr);
		self.data("dataMapTextFields", dataMapTextFields);
		self.data("dataMapping", dataMappingArr);
		self.data("ruleVersion", jspRuleVersionComp.val());

		//extract html content from editor 
		/*htmlContent = extractCodeFromEditor();*/
		htmlContent= modal.querySelector('#waitMessage').value;
		self.data("waitMsg",htmlContent);
		
		selectedOptionObj.rules.forEach(function(entry) {ruleNames.push(entry.name);});
		selectedOptionObj.rules.forEach(function(entry) {ruleId.push(entry.id);});

		var currDivX = self.position().left - canvasPosition.left + self.outerWidth() + sLeft;
		var currDivY = self.position().top - canvasPosition.top + self.outerHeight() / 2 + sTop;
		
		var nodeText = $("#jspRuleOptions option:selected").text();
		
		//set tooltip text
		if(nodeText==="")
			self[0].setAttribute('title',"Default");
		else
			self[0].setAttribute('title',nodeText);
		
		if(self.data('ownText'))
			self.data('ownText').remove();
		
		self.data('ownText', drawText(currDivX - 70, currDivY - 70 , nodeText))
		self.data('nodeText', nodeText);
		layer.draw();
		
		if(childrenObsrver == 'updateAllExceptRule') return;
		prepareChildren(self, parseInt(selectedOptionObj.rules.length) + 1, ruleNames, ruleId);

		lineColor = addHexColor(lineColor, colorInterval);
		
	}
	modal.style.display = "block";
}

function processPaymentModal(self, popupContainerId, popupSkeletonId, version) {

	var modal = document.getElementById(popupContainerId);
	var modalSkeleton = modal.querySelector('#'+popupSkeletonId);
	if(modalSkeleton)
		modalSkeleton.parentNode.removeChild(modalSkeleton);
		
	modal.getElementsByClassName('modal-content')[0].insertBefore(document.getElementById(popupSkeletonId).cloneNode(true), modal.getElementsByClassName('modal-submit')[0]);
	
	modal.classList.remove("modal-hidden");
	modal.classList.add("modal-visible");
	modal.querySelector('#'+popupSkeletonId).classList.remove("modal-hidden");
	modal.querySelector('#'+popupSkeletonId).classList.add("modal-visible");
	modal.querySelector('#allowReprocess').checked = self.data("allowReprocess")||"";
	
	var out = "", dropDownOptions = dropDownOptionsJSONArr.ruleSetJsp || dropDownOptionsJSONArr.RuleSetsJSP, providerOptions = dropDownOptionsJSONArr.providerList;
	
	//populate jsp rule options
	out= "";
	for (var indx = 0; indx < dropDownOptions.length; indx++)
		out += '<option value="' + dropDownOptions[indx].id + '">' + dropDownOptions[indx].name + '</option>';
	modal.querySelector('#paymentRuleOptions').innerHTML = out;
	
	// populate provider list
	out= "";
	var defaultProviderSelected = self.data("provider") && self.data("provider")!=='' ? self.data("provider") : "stripe";
	for (var indx = 0; indx < providerOptions.length; indx++)
		out += '<option value="' + providerOptions[indx].id +'"' + (providerOptions[indx].id===defaultProviderSelected?' selected':'')+'>' + providerOptions[indx].name + '</option>';
	modal.querySelector('#providerLOV').innerHTML = out;
				
	if(self.data("waitMsg")){//If pop-up was already saved.
		modal.querySelector('#waitMessage').value = self.data("waitMsg");
		htmlContent=self.data("waitMsg");
	}
	
	//Resume the previously selected options
//	modal.querySelector('#providerTxtField').value = self.data("provider")||"";
	if (version==1) {
		modal.querySelector('#payCcyTxtField').value = self.data("payCcy")||"";
		modal.querySelector('#payAmountTxtField').value = self.data("payAmount")||"";
		modal.querySelector('#payDescTxtField').value = self.data("payDesc")||"";
		modal.querySelector('#payItemClassNameTxtField').value = "";
		modal.querySelector('#payItemClassPkTxtField').value = "";		
	} else {
		// version 2 only
		modal.querySelector('#enableOfflinePayment').checked = self.data("enableOfflinePayment")||"";		
	}
	modal.querySelector('#paymentCancelTxtField').checked = self.data("paymentCancel")||"";
	modal.querySelector('#paymentRefundTxtField').checked = self.data("paymentRefundOn")||"";
	modal.querySelector('#siteNameTxtField').value = self.data("paySiteName")||"";
	modal.querySelector('#siteLogoTxtField').value = self.data("paySiteLogo")||"";
	modal.querySelector('#paidMessage').value = self.data("paidMsg") || defaultPaidMessage;
	modal.querySelector('#refundedMessage').value = self.data("refundedMsg") || defaultRefundedMessage;
	modal.querySelector('#customNameTxtField').value = self.data("name")||"Payment";
	if (self.data("termsAndCondition")) {
		modal.querySelector('#termsAndCondition').value = self.data("termsAndCondition");
	}

	var selectedIndex = self.data('selectedIndx') || -1;
	setSelectedIndex(modal.querySelector('#paymentRuleOptions'), selectedIndex);
	var prevSelectedRuleSetId = selectedIndex;
	
	addPaymentDataMapSection(self, modal);
	
	var btnSave = modal.querySelector('#btnModelSave');
	btnSave.onclick = function() {
		var validationError = false;
		self.data("allowReprocess", modal.querySelector('#allowReprocess').checked);
		var selectedIndx = parseInt(modal.querySelector('#paymentRuleOptions').value);
		var selectedOptionObj = null;
		for(var i = 0; i < dropDownOptions.length; i++)
		  if(dropDownOptions[i].id == selectedIndx)
			  selectedOptionObj = dropDownOptions[i];
		
		var selectedProviderIndx = modal.querySelector('#providerLOV').value;
		var selectedProviderOptionObj = null;
		for(var i = 0; i < providerOptions.length; i++)
		  if(providerOptions[i].id == selectedProviderIndx)
			  selectedProviderOptionObj = providerOptions[i];
				
		var dataMapSection = modal.getElementsByClassName("dataMapSectionPayment");
		var dataMapOptions = [], dataMapTextFields = [], selectedDataMapOption = null; dataMappingArr = [], mappingElement = {}, dataMapTextFieldVal = null;

		for (var indx = 0; indx < dataMapSection.length; indx++) {
			
			//Keep track of duplicate selection of drop down in paymentDataMapOptions field.
			selectedDataMapOption = dataMapSection[indx].querySelector('#paymentDataMapOptions').value;
			if (dataMapOptions.indexOf(selectedDataMapOption) > -1) {
				dataMapSection[indx].querySelector('#paymentDataMapOptions').style.borderColor = "red";
				//If there are no datamaprows
				if(modal.querySelector('#addDataMapSectionPaymentBtnId').style.display == 'none')
					return;
			}
			else{
				dataMapSection[indx].querySelector('#paymentDataMapOptions').style.border = "solid 1px #d9dce3";
			}
			if(selectedDataMapOption){
			dataMapOptions.push(selectedDataMapOption);
			
			dataMapTextFieldVal = dataMapSection[indx].querySelector('#paymentDataMapTextField').value;
			if(dataMapTextFieldVal){
//				var regExp = /^[a-zA-Z0-9_]*$/;
//				     if (regExp.test(dataMapTextFieldVal)) {
				    	 dataMapSection[indx].querySelector('#paymentDataMapTextField').style.border = "solid 1px #d9dce3";
				    	 dataMapTextFields.push(dataMapTextFieldVal);
//				        }
//				      else {      
//				    	  dataMapSection[indx].querySelector('#paymentDataMapTextField').style.borderColor = "red";
//							if(modal.querySelector('#addDataMapSectionPaymenbtBtnId').style.display == 'none')
//								return;	
//				        }
				
			}
			else{
				dataMapSection[indx].querySelector('#paymentDataMapTextField').style.borderColor = "red";
				if(modal.querySelector('#addDataMapSectionPaymentBtnId').style.display == 'none')
					return;				
			}
			
			mappingElement = {};
			mappingElement.processFieldId = dataMapSection[indx].querySelector('#paymentDataMapTextField').value;
			mappingElement.fieldId = dataMapSection[indx].querySelector('#paymentDataMapOptions').value;
			
			dataMappingArr.push(mappingElement);	
			}
		}
		
		if(validationError == true){
			return;
		}
		
		modal.style.display = "none";
		
		var ruleNames = [];
		var ruleId = [];

		var childrenObsrver = isChildRequired(self, prevSelectedRuleSetId, selectedOptionObj.id);
		if(childrenObsrver == false) return;
		if (version==1) {
			self.data("payCcy", modal.querySelector('#payCcyTxtField').value);
			self.data("payAmount", modal.querySelector('#payAmountTxtField').value);
			self.data("payDesc", modal.querySelector('#payDescTxtField').value);
			self.data("payItemClassName", "com.sambaash.platform.srv.model.Product");
			self.data("payItemClassPk", "spProductId");			
		} else {
			self.data("enableOfflinePayment", modal.querySelector('#enableOfflinePayment').checked);			
		}
		self.data("configuredType", selectedOptionObj.type);
		self.data("rulesetId", selectedOptionObj.id);
		self.data("provider", selectedProviderOptionObj.id);
		self.data("paymentCancel", modal.querySelector('#paymentCancelTxtField').checked);
		self.data("paymentRefundOn", modal.querySelector('#paymentRefundTxtField').checked);
		
		self.data("paySiteName", modal.querySelector('#siteNameTxtField').value);
		self.data("paySiteLogo", modal.querySelector('#siteLogoTxtField').value);
		self.data("selectedIndx", selectedIndx);
		self.data("dataMapTextFields", dataMapTextFields);
		self.data("dataMapping", dataMappingArr);
		self.data("name", modal.querySelector('#customNameTxtField').value);

		htmlContent= modal.querySelector('#waitMessage').value;
		self.data("waitMsg",htmlContent);
		self.data("termsAndCondition",modal.querySelector('#termsAndCondition').value);
		self.data("paidMsg",modal.querySelector('#paidMessage').value);
		self.data("refundedMsg",modal.querySelector('#refundedMessage').value);
		
		selectedOptionObj.rules.forEach(function(entry) {ruleNames.push(entry.name);});
		selectedOptionObj.rules.forEach(function(entry) {ruleId.push(entry.id);});
		
		var currDivX = self.position().left - canvasPosition.left + self.outerWidth() + sLeft;
		var currDivY = self.position().top - canvasPosition.top + self.outerHeight() / 2 + sTop;
		
		var nodeText = modal.querySelector('#paymentRuleOptions').querySelector('option:checked').text;

		//set tooltip text
		if(nodeText==="")
			self[0].setAttribute('title',"Default");
		else
			self[0].setAttribute('title',nodeText);
		
		if(self.data('ownText'))
			self.data('ownText').remove();
		
		self.data('ownText', drawText(currDivX - 70, currDivY - 70 , nodeText))
		self.data('nodeText', nodeText);
		layer.draw();
		
		if(childrenObsrver == 'updateAllExceptRule') return;
		prepareChildren(self, parseInt(selectedOptionObj.rules.length) + 1, ruleNames, ruleId);

		lineColor = addHexColor(lineColor, colorInterval);
		
	}
	modal.style.display = "block";
}


function processPreviewModal(self) {

	var modal = document.getElementById('preview_model_popup');
	var previewSkelton = modal.querySelector('#preview_model_popup_skelton');
	if(previewSkelton)
		previewSkelton.parentNode.removeChild(previewSkelton);
		
	modal.getElementsByClassName('modal-content')[0].insertBefore(document.getElementById('preview_model_popup_skelton').cloneNode(true), modal.getElementsByClassName('modal-submit')[0]);
	
	document.getElementById('preview_model_popup').classList.remove("modal-hidden");
	document.getElementById('preview_model_popup').classList.add("modal-visible");
	modal.querySelector('#preview_model_popup_skelton').classList.remove("modal-hidden");
	modal.querySelector('#preview_model_popup_skelton').classList.add("modal-visible");
	modal.querySelector('#allowReprocess').checked = self.data("allowReprocess")||"";
	
	var out = "", previewOptions = dropDownOptionsJSONArr.previewList, customOptions = dropDownOptionsJSONArr.customList;
	
	//populate preview options
	out= "";
	for (var indx = 0; indx < previewOptions.length; indx++)
		out += '<option value="' + previewOptions[indx].id + '">' + previewOptions[indx].name + '</option>';
	document.getElementById('previewOptions').innerHTML = out;
	
	//populate custom options
	out= "";
	for (var indx = 0; indx < customOptions.length; indx++)
		out += '<option value="' + customOptions[indx].id + '">' + customOptions[indx].name + '</option>';
	document.getElementById('customOptions').innerHTML = out;
	
	
	//Resume the previously selected options
	modal.querySelector('#previewOptions').value = self.data("previewId")||"";
	modal.querySelector('#customOptions').value = self.data("customId")||"";
	modal.querySelector('#previewJspNodeTxtField').value = self.data("previewJspNode")||"";
	modal.querySelector('#esignApiUrlTxtField').value = self.data("esignApiUrl")||defaultEsignApiUrl;
	modal.querySelector('#esignApiKeyTxtField').value = self.data("esignApiKey") || defaultEsignApiKey;
	modal.querySelector('#enablePreviewField').checked = self.data("enablePreview")||"";
	modal.querySelector('#enableEsignField').checked = self.data("enableEsign")||"";

	
	var btnSave = modal.querySelector('#btnModelSave');
	btnSave.onclick = function() {
		var validationError = false;
		self.data("allowReprocess", modal.querySelector('#allowReprocess').checked);		
		var selectedPreviewIndx = modal.querySelector('#previewOptions').value;
		var selectedPreviewOptionObj = null;
		for(var i = 0; i < previewOptions.length; i++)
		  if(previewOptions[i].id == selectedPreviewIndx)
			  selectedPreviewOptionObj = previewOptions[i];
		
		var selectedCustomIndx = modal.querySelector('#customOptions').value;
		var selectedCustomOptionObj = null;
		for(var i = 0; i < customOptions.length; i++)
		  if(customOptions[i].id == selectedCustomIndx)
			  selectedCustomOptionObj = customOptions[i];
				
		
		if(validationError == true){
			return;
		}
		
		modal.style.display = "none";
		
		self.data("previewId", modal.querySelector('#previewOptions').value);
		self.data("customId", modal.querySelector('#customOptions').value);
		self.data("previewJspNode", modal.querySelector('#previewJspNodeTxtField').value);
		self.data("esignApiUrl", modal.querySelector('#esignApiUrlTxtField').value);
		self.data("esignApiKey", modal.querySelector('#esignApiKeyTxtField').value);
		self.data("enablePreview", modal.querySelector('#enablePreviewField').checked);
		self.data("enableEsign", modal.querySelector('#enableEsignField').checked);
		
		var currDivX = self.position().left - canvasPosition.left + self.outerWidth() + sLeft;
		var currDivY = self.position().top - canvasPosition.top + self.outerHeight() / 2 + sTop;
		
		var nodeText = $("#previewOptions option:selected").text();
		
		//set tooltip text
		if(nodeText==="")
			self[0].setAttribute('title',"Default");
		else
			self[0].setAttribute('title',nodeText);
		
		if(self.data('ownText'))
			self.data('ownText').remove();
		
		self.data('ownText', drawText(currDivX - 70, currDivY - 70 , nodeText))
		self.data('nodeText', nodeText);
		layer.draw();
		
	}
	
	
	$('#enableEsignField').bind("change", function(){
		 if(modal.querySelector('#enableEsignField').checked){
			 modal.querySelector("#esignDiv").style.display = "block";
		 }
		 else{
			 modal.querySelector("#esignDiv").style.display = "none";
		 }
	});
	
	$('#previewOptions').bind("change", function(){
		 if(modal.querySelector('#previewOptions').value==="Custom"){
			 modal.querySelector("#customOptionsDiv").style.display = "block";
		 }
		 else{
			 modal.querySelector("#customOptionsDiv").style.display = "none";
		 }
	});
	
	modal.style.display = "block";
}

function getResult(resultEmailVerification){
	result = resultEmailVerification;
}

function processMailModal(self){//self is JQuery Obj, the current clicked div box.

	var modal = document.getElementById('mail_model_popup');// Get the modal

	var out = "", dropDownMailTemplateOptions = dropDownOptionsJSONArr.mailTemplate;
	var dropDownOfficerRoleIds=dropDownOptionsJSONArr.roles;

	for (var indx = 0; indx < dropDownMailTemplateOptions.length; indx++)
		out += '<option value="' + dropDownMailTemplateOptions[indx].id + '">' + dropDownMailTemplateOptions[indx].name + '</option>';
	document.getElementById('mailTemplateOptions').innerHTML = out;
	
	//Resume the selected values
	setSelectedIndex(modal.querySelector('#mailTemplateOptions'), self.data("templateId"));
	setSelectedIndex(modal.querySelector('#recipient'), self.data("recipient"));
	setSelectedIndex(modal.querySelector('#cc'), self.data("cc")||"select");
	modal.querySelector('#ccEmailAddressText').value = self.data("ccEmailAddressText")||"";
	modal.querySelector('#allowReprocess').checked = self.data("allowReprocess")||"";
	
	//populate roles drop down
	out="<option value='0'>Select Role/Roles</option>";
	for (var indx = 0; indx < dropDownOfficerRoleIds.length; indx++)
		out += '<option value="' + dropDownOfficerRoleIds[indx].id + '">' + dropDownOfficerRoleIds[indx].name + '</option>';
	document.getElementById('officerRoleIds').innerHTML = out;
	setSelectedIndex(modal.querySelector('#officerRoleIds'), self.data("officerRoleIds"));
	
	if(self.data("recipient")==="officer")
		modal.querySelector("#mailRoleDiv").style.display = "block";
	else
		modal.querySelector("#mailRoleDiv").style.display = "none";
	
//	if(self.data("recipient")==="user")
//		modal.querySelector("#ccOptions").style.display = "block";
//	else
//		modal.querySelector("#ccOptions").style.display = "none";
	
	if(self.data("cc")==="ccEmailAddress")
		modal.querySelector("#mailAddressDiv").style.display = "block";
	else
		modal.querySelector("#mailAddressDiv").style.display = "none";
	
	var btnSave = modal.querySelector('#btnModelSave');
	
	btnSave.onclick = function() {
		self.data("allowReprocess", modal.querySelector('#allowReprocess').checked);
		result = null;
		if($(modal.querySelector('#cc')).val()==="ccEmailAddress"){
			validateEmailAddress(modal.querySelector('#ccEmailAddressText'));
		}
		
		if (result != "Undeliverable"){
			modal.style.display = "none";
					
			self.data("templateId", $(modal.querySelector('#mailTemplateOptions')).val());
			self.data("recipient", $(modal.querySelector('#recipient')).val());
			self.data("cc", $(modal.querySelector('#cc')).val());
			self.data("ccEmailAddressText", modal.querySelector('#ccEmailAddressText').value);
			if($(modal.querySelector('#recipient')).val()==="officer")
				self.data("officerRoleIds", $(modal.querySelector('#officerRoleIds')).val());
			else
				self.data("officerRoleIds", "");
			
			lineColor = addHexColor(lineColor, colorInterval);
			
			var currDivX = self.position().left - canvasPosition.left + self.outerWidth() + sLeft;
			var currDivY = self.position().top - canvasPosition.top + self.outerHeight() / 2 + sTop;
			
			var nodeText = $("#mailTemplateOptions option:selected").text();
			
			//set tooltip text
			if(nodeText==="")
				self[0].setAttribute('title',"Default");
			else
				self[0].setAttribute('title',nodeText);
			
			self.data('ownText').remove();
			self.data('ownText', drawText(currDivX-70, currDivY - 80 , nodeText))
			self.data('nodeText', nodeText);
			layer.draw();
		} else {
			alert("Enter a valid Email Address");
		}
		
	}
	$('#recipient').bind("change", function(){
		 if($(modal.querySelector('#recipient')).val()==="officer")
			 modal.querySelector("#mailRoleDiv").style.display = "block";
		 else
			 modal.querySelector("#mailRoleDiv").style.display = "none";
		 
//		 if($(modal.querySelector('#recipient')).val()==="user")
//			 modal.querySelector("#ccOptions").style.display = "block";
//		 else
//			 modal.querySelector("#ccOptions").style.display = "none";
	});
	
	$(modal.querySelector('#cc')).bind("change", function(){
		 if($(modal.querySelector('#cc')).val()==="ccEmailAddress")
			 modal.querySelector("#mailAddressDiv").style.display = "block";
		 else
			 modal.querySelector("#mailAddressDiv").style.display = "none";
	});
	
	modal.style.display = "block";
}

function processCustomActionModal(self){//self is JQuery Obj, the current clicked div box.

	var modal = document.getElementById('customAction_model_popup');// Get the modal

	var out = "", dropDownCustomActionOptions = dropDownOptionsJSONArr.customAction;

	if(dropDownCustomActionOptions.length > 0){
	for (var indx = 0; indx < dropDownCustomActionOptions.length; indx++)
		out += '<option value="' + dropDownCustomActionOptions[indx].id + '">' + dropDownCustomActionOptions[indx].name + '</option>';
	document.getElementById('customActionTitleOptions').innerHTML = out;
	
	
	//Resume the selected values
	setSelectedIndex(modal.querySelector('#customActionTitleOptions'), self.data("customActionTitleOptions"));
	var index = $(modal.querySelector('#customActionTitleOptions')).val();
	modal.querySelector('#configurationText').value = (self.data('configurationText') == undefined ? dropDownCustomActionOptions[index-1].configurationText:self.data('configurationText'));
	modal.querySelector('#allowReprocess').checked = self.data("allowReprocess")||"";
	
	var dropdowncustomAction = modal.querySelector('#customActionTitleOptions');
	
	dropdowncustomAction.onchange = function() {
	
		var index = $(modal.querySelector('#customActionTitleOptions')).val();
		//modal.querySelector('#configurationText').value = (self.data('configurationText') == undefined ? dropDownCustomActionOptions[index-1].configurationText:self.data('configurationText'));
		modal.querySelector('#configurationText').value = dropDownCustomActionOptions[index-1].configurationText;
	}
	}
	
	var btnSave = modal.querySelector('#btnModelSave');
	
	btnSave.onclick = function() {
		
		modal.style.display = "none";
				
		self.data("customActionTitleOptions", $(modal.querySelector('#customActionTitleOptions')).val());
		self.data("allowReprocess", modal.querySelector('#allowReprocess').checked);
		
		var html = $(modal.querySelector('#configurationText')).val();
		var nodeText = html.split('<script type="text/javascript">')[0].replace(/<(?:.|\n)*?>/gm, '').trim();
		self.data('nodeText',nodeText);
		self.data('configurationText', $(modal.querySelector('#configurationText')).val());
		
		lineColor = addHexColor(lineColor, colorInterval);
		
		var currDivX = self.position().left - canvasPosition.left + self.outerWidth() + sLeft;
		var currDivY = self.position().top - canvasPosition.top + self.outerHeight() / 2 + sTop;
		
		var nodeText = $("#customActionTitleOptions option:selected").text();
		
		//set tooltip text
		if(nodeText==="")
			self[0].setAttribute('title',"Default");
		else
			self[0].setAttribute('title',nodeText);
		
		if(self.data('ownText'))
			self.data('ownText').remove();
		self.data('ownText', drawText(currDivX-50, currDivY - 50 , nodeText))
		self.data('nodeText', nodeText);
		layer.draw();
	}
	
	modal.style.display = "block";
}

function setSelectedIndex(s, v) {

	if (v == undefined)return;

	if (s == undefined)return;

	if (v.constructor === Array){//for multiselect
		for ( var i = 0; i < s.options.length; i++ )
	        if (v.includes(s.options[i].value))
	            s.options[i].selected = true;
	}

	else {
		for ( var i = 0; i < s.options.length; i++ )
	        if (v == s.options[i].value) {
	        	s.options[i].selected = true;
	        	return;
	        }
	}
}

function processMessageModal(self){//self is JQuery Obj

	var modal = document.getElementById('message_model_popup');// Get the modal

	//Resume the previously selected options
	modal.querySelector('#messgeInputId').value = (self.data('messageInput') == undefined ? "":self.data('messageInput'));
	modal.querySelector('#allowReprocess').checked = self.data("allowReprocess")||"";
	
	var btnSave = modal.querySelector('#btnModelSave');
	btnSave.onclick = function() {
		modal.style.display = "none";
		self.data("allowReprocess", modal.querySelector('#allowReprocess').checked);
		var html = $(modal.querySelector('#messgeInputId')).val();
		var nodeText = html.split('<script type="text/javascript">')[0].replace(/<(?:.|\n)*?>/gm, '').trim();
		self.data('nodeText',nodeText);
		self.data('messageInput', $(modal.querySelector('#messgeInputId')).val());
		
		//set tooltip text
		if(nodeText==="")
			self[0].setAttribute('title',"Default");
		else
			self[0].setAttribute('title',nodeText);

		lineColor = addHexColor(lineColor, colorInterval);
	}
	modal.style.display = "block";
}

function processAccountModal(self){//self is JQuery Obj

	var modal = document.getElementById('account_model_popup');// Get the modal

	var out = "", dropDownMailTemplateOptions = dropDownOptionsJSONArr;

	for (var indx = 0; indx < dropDownMailTemplateOptions.length; indx++)
		out += '<option value="' + dropDownMailTemplateOptions[indx].id + '">' + dropDownMailTemplateOptions[indx].name + '</option>';
	modal.querySelector('#mailTemplateOptions').innerHTML = out;

	setSelectedIndex(modal.querySelector('#mailTemplateOptions'), self.data("templateId"));
	setSelectedIndex(modal.querySelector('#accountStatusOptions'), self.data("accountStatusId"));
	setSelectedIndex(modal.querySelector('#emailAddressVerifiedOptions'), self.data("emailAddressVerifiedId"));
	modal.querySelector('#allowReprocess').checked = self.data("allowReprocess")||"";
	
	var btnSave = modal.querySelector('#btnModelSave');
	btnSave.onclick = function() {

		modal.style.display = "none";
		self.data("allowReprocess", modal.querySelector('#allowReprocess').checked);
		var children = self.data("children");
		var childrenCnt = children ? children.length : -1;
		var currTemplId = $(modal.querySelector('#mailTemplateOptions')).val();
		var accountStatusId = $(modal.querySelector('#accountStatusOptions')).val();
		var emailAddressVerifiedId = $(modal.querySelector('#emailAddressVerifiedOptions')).val();
		
		//if(self.data("templateId") == currTemplId || childrenCnt > 0)//if no selection change or child is already present
		//	return;
		
		self.data("templateId", currTemplId);
		self.data("accountStatusId", accountStatusId);
		self.data("emailAddressVerifiedId", emailAddressVerifiedId);
		//prepareChildren(self, 1);
		
		lineColor = addHexColor(lineColor, colorInterval);
	}
	modal.style.display = "block";
}

function processStatusModal(self){//self is JQuery Obj

	var modal = document.getElementById('status_model_popup');// Get the modal

	var out = "", statusDropDownOptions = dropDownOptionsJSONArr.statusTypes, mailTemplateDropDownOptions = dropDownOptionsJSONArr.mailTemplate, approverRolesDropDownOptions = dropDownOptionsJSONArr.roles;

	//populate status drop down
	for (var indx = 0; indx < statusDropDownOptions.length; indx++)
		out += '<option value="' + statusDropDownOptions[indx].id + '">' + statusDropDownOptions[indx].name + '</option>';
	document.getElementById('statusDropDownOptions').innerHTML = out;

	//populate status approver roles drop down
	out="<option value='0'>Select Role/Roles</option>";
	for (var indx = 0; indx < approverRolesDropDownOptions.length; indx++)
		out += '<option value="' + approverRolesDropDownOptions[indx].id + '">' + approverRolesDropDownOptions[indx].name + '</option>';
	document.getElementById('approverDropDownOptions').innerHTML = out;
	
	//populate mail templates drop down
	out="";
	for (var indx = 0; indx < mailTemplateDropDownOptions.length; indx++)
		out += '<option value="' + mailTemplateDropDownOptions[indx].id + '">' + mailTemplateDropDownOptions[indx].name + '</option>';
	document.getElementById('emailTemplateDropDownOptions').innerHTML = out;
	
	setSelectedIndex(modal.querySelector('#statusOptions'), self.data("status"));
	setSelectedIndex(modal.querySelector('#statusDropDownOptions'), self.data("statusTypeId") == undefined ? "-1": self.data("statusTypeId"));
	setSelectedIndex(modal.querySelector('#approverDropDownOptions'), self.data("statusApproverIds") == undefined ? "-1": self.data("statusApproverIds"));
	setSelectedIndex(modal.querySelector('#emailTemplateDropDownOptions'), self.data("emailTemplateId") == undefined ? "-1": self.data("emailTemplateId"));
	modal.querySelector('#allowReprocess').checked = self.data("allowReprocess")||"";
	
	if($(modal.querySelector('#statusOptions')).val()==="Pending")
		 modal.querySelector("#mailTemplateDiv").style.display = "block";
	 else
		 modal.querySelector("#mailTemplateDiv").style.display = "none";
	
	var btnSave = modal.querySelector('#btnModelSave');
	btnSave.onclick = function() {

		modal.style.display = "none";
		self.data("allowReprocess", modal.querySelector('#allowReprocess').checked);
		self.data('status', $(modal.querySelector('#statusOptions')).val());
		self.data('statusTypeId', $(modal.querySelector('#statusDropDownOptions')).val());
		self.data('statusApproverIds', $(modal.querySelector('#approverDropDownOptions')).val());
		if($(modal.querySelector('#statusOptions')).val()==="Pending")
			self.data('emailTemplateId', $(modal.querySelector('#emailTemplateDropDownOptions')).val());

		lineColor = addHexColor(lineColor, colorInterval);
		
		var currDivX = self.position().left - canvasPosition.left + self.outerWidth() + sLeft;
		var currDivY = self.position().top - canvasPosition.top + self.outerHeight() / 2 + sTop;
		
		var nodeText = $("#statusDropDownOptions option:selected").text() + '/' + $('#statusOptions option:selected').text();
		
		//set tooltip text
		if(nodeText==="")
			self[0].setAttribute('title',"Default");
		else
			self[0].setAttribute('title',nodeText);
		
		if (self.data('ownText')) self.data('ownText').remove();
		self.data('ownText', drawText(currDivX - 70, currDivY - 70 , nodeText))
		self.data('nodeText', nodeText);
		layer.draw();
		
		layer.draw();
	}
	
	$('#statusOptions').bind("change", function(){
		 if($(modal.querySelector('#statusOptions')).val()==="Pending")
			 modal.querySelector("#mailTemplateDiv").style.display = "block";
		 else
			 modal.querySelector("#mailTemplateDiv").style.display = "none";
	});
	
	modal.style.display = "block";
}

function processTimerModal(self){//self is JQuery Obj

	var modal = document.getElementById('timer_model_popup');// Get the modal

	var out = "", dropDownMailTemplateOptions = dropDownOptionsJSONArr.mailTemplate;
	var dropDownOfficerRoleIds=dropDownOptionsJSONArr.roles;

	for (var indx = 0; indx < dropDownMailTemplateOptions.length; indx++)
		out += '<option value="' + dropDownMailTemplateOptions[indx].id + '">' + dropDownMailTemplateOptions[indx].name + '</option>';
	modal.querySelector('#mailTemplateOptions').innerHTML = out;
	
	var rulesDropDownOptions = dropDownOptionsJSONArr.RuleSetsProcess;	
	//populate rule options
	out= "<option value='0'>No Rule. Execute Always.</option>";
	for (var indx = 0; indx < rulesDropDownOptions.length; indx++)
		out += '<option value="' + rulesDropDownOptions[indx].id + '">' + rulesDropDownOptions[indx].name + '</option>';
	modal.querySelector('#timerRuleSetId').innerHTML = out;

	var jobListenerDropDownOptions = dropDownOptionsJSONArr.peJobListeners;	
	//populate PE Job Listeners
	out= "";
	for (var indx = 0; indx < jobListenerDropDownOptions.length; indx++)
		out += '<option value="' + jobListenerDropDownOptions[indx].id + '">' + jobListenerDropDownOptions[indx].name + '</option>';
	modal.querySelector('#jobListener').innerHTML = out;

	var cronScheduleComp = $(modal.querySelector('#cronSchedule'));
	cronScheduleComp.empty();
	var cronOptions = {
		    customValues: {
		        "5 Minutes" : "0 */5 * * * ?",
		        "10 Minutes" : "0 */10 * * * ?",
		        "15 Minutes" : "0 */15 * * * ?",
		        "30 Minutes" : "0 */30 * * * ?"
		    },
		    onChange: function() {
		        console.log("got cron schedule",$(this).cron("value"));
		    },
		    useGentleSelect: true // default: false
		};
	
	cronOptions.initial = self.data("cronSchedule") || "0 */5 * * * ?";
	cronScheduleComp.cron(cronOptions);
	
	//Resume the selected values
	setSelectedIndex(modal.querySelector('#mailTemplateOptions'), self.data("templateId"));
	setSelectedIndex(modal.querySelector('#recipient'), self.data("recipient"));
	setSelectedIndex(modal.querySelector('#cc'), self.data("cc")||"select");
	setSelectedIndex(modal.querySelector('#timerRuleSetId'), self.data("rulesetId")||"0");
	setSelectedIndex(modal.querySelector('#jobListener'), self.data("jobListener")||"ScheduledMailJob");
	modal.querySelector('#ccEmailAddressText').value = self.data("ccEmailAddressText")||"";
	modal.querySelector('#allowReprocess').checked = self.data("allowReprocess")||"";
	modal.querySelector('#execOnceCB').checked = self.data("execOnce")||"";
	
	//populate roles drop down
	out="<option value='0'>Select Role/Roles</option>";
	for (var indx = 0; indx < dropDownOfficerRoleIds.length; indx++)
		out += '<option value="' + dropDownOfficerRoleIds[indx].id + '">' + dropDownOfficerRoleIds[indx].name + '</option>';
	modal.querySelector('#officerRoleIds').innerHTML = out;
	setSelectedIndex(modal.querySelector('#officerRoleIds'), self.data("officerRoleIds"));
	
	if(self.data("recipient")==="officer")
		modal.querySelector("#mailRoleDiv").style.display = "block";
	else
		modal.querySelector("#mailRoleDiv").style.display = "none";
	
//	if(self.data("recipient")==="user")
//		modal.querySelector("#ccOptions").style.display = "block";
//	else
//		modal.querySelector("#ccOptions").style.display = "none";
	
	if(self.data("cc")==="ccEmailAddress")
		modal.querySelector("#mailAddressDiv").style.display = "block";
	else
		modal.querySelector("#mailAddressDiv").style.display = "none";
	
	var btnSave = modal.querySelector('#btnModelSave');
	
	btnSave.onclick = function() {
		self.data("allowReprocess", modal.querySelector('#allowReprocess').checked);
		self.data("execOnce", modal.querySelector('#execOnceCB').checked);
		result = null;
		if($(modal.querySelector('#cc')).val()==="ccEmailAddress"){
			validateEmailAddress(modal.querySelector('#ccEmailAddressText'));
		}
		self.data("rulesetId", $(modal.querySelector('#timerRuleSetId')).val());
		self.data("jobListener", $(modal.querySelector('#jobListener')).val());
		self.data("cronSchedule", cronScheduleComp.cron("value"));
		
		if (result != "Undeliverable"){
			modal.style.display = "none";
					
			self.data("templateId", $(modal.querySelector('#mailTemplateOptions')).val());
			self.data("recipient", $(modal.querySelector('#recipient')).val());
			self.data("cc", $(modal.querySelector('#cc')).val());
			self.data("ccEmailAddressText", modal.querySelector('#ccEmailAddressText').value);
			if($(modal.querySelector('#recipient')).val()==="officer")
				self.data("officerRoleIds", $(modal.querySelector('#officerRoleIds')).val());
			else
				self.data("officerRoleIds", "");
			
			lineColor = addHexColor(lineColor, colorInterval);
			
			var currDivX = self.position().left - canvasPosition.left + self.outerWidth() + sLeft;
			var currDivY = self.position().top - canvasPosition.top + self.outerHeight() / 2 + sTop;
			
			var nodeText = $(modal.querySelector("#mailTemplateOptions option:selected")).text();
			
			//set tooltip text
			if(nodeText==="")
				self[0].setAttribute('title',"Default");
			else
				self[0].setAttribute('title',nodeText);
			
			self.data('ownText').remove();
			self.data('ownText', drawText(currDivX-70, currDivY - 80 , nodeText))
			self.data('nodeText', nodeText);
			layer.draw();
		} else {
			alert("Enter a valid Email Address");
		}
		
	}
	$(modal.querySelector('#recipient')).bind("change", function(){
		 if($(modal.querySelector('#recipient')).val()==="officer")
			 modal.querySelector("#mailRoleDiv").style.display = "block";
		 else
			 modal.querySelector("#mailRoleDiv").style.display = "none";
		 
//		 if($(modal.querySelector('#recipient')).val()==="user")
//			 modal.querySelector("#ccOptions").style.display = "block";
//		 else
//			 modal.querySelector("#ccOptions").style.display = "none";
	});
	
	$(modal.querySelector('#cc')).bind("change", function(){
		 if($(modal.querySelector('#cc')).val()==="ccEmailAddress")
			 modal.querySelector("#mailAddressDiv").style.display = "block";
		 else
			 modal.querySelector("#mailAddressDiv").style.display = "none";
	});
	
	modal.style.display = "block";
}

function addPopupRows(self, className) {

	var toBeAdded = findAncestor(self, className);

	var cloned = toBeAdded.cloneNode(true);
	toBeAdded.insertAdjacentElement("AfterEnd", cloned);
	
	if(cloned.querySelector("#formDataMapTextField"))
	cloned.querySelector("#formDataMapTextField").value="";
	
}

function addPopupRowsJsp(self, className) {

	var toBeAdded = findAncestor(self, className);

	var cloned = toBeAdded.cloneNode(true);
	toBeAdded.insertAdjacentElement("AfterEnd", cloned);
	
	if(cloned.querySelector("#jspDataMapTextField"))
	cloned.querySelector("#jspDataMapTextField").value="";
	
	if(cloned.querySelector("#jspDataMapOptions"))
	cloned.querySelector("#jspDataMapOptions").value="";
	
}

function addPopupRowsPayment(self, className) {

	var toBeAdded = findAncestor(self, className);

	var cloned = toBeAdded.cloneNode(true);
	toBeAdded.insertAdjacentElement("AfterEnd", cloned);
	
	if(cloned.querySelector("#paymentDataMapTextField"))
	cloned.querySelector("#paymentDataMapTextField").value="";
	
	if(cloned.querySelector("#paymentDataMapOptions"))
	cloned.querySelector("#paymentDataMapOptions").value="";
	
}

function removePopupRows(self, className) {

	var toBeRemoved = findAncestor(self, className);
		toBeRemoved.remove();
}

function removeFormPopupRowsHelper(self, className, id){
	
	removePopupRows(self, className);
	
}

function findAncestor (el, cls) {
	while ((el = el.parentElement) && !el.classList.contains(cls));
	return el;
}

/*
 * generates child nodes sbased on the process properties set 
 */
function prepareChildren(self, noOfChild, childrenText, ruleIds, isSelectedRuleSetChanged) {//self is JQuery Obj, althoug no need of having JQuery obj.

	var newDropFrame, line, text
	var childX, childY;
	var childLineHeadX, childLineHeadY;

	var currDivX = self.position().left - canvasPosition.left + self.outerWidth() + sLeft;
	var currDivY = self.position().top - canvasPosition.top + self.outerHeight() / 2 + sTop;

	var circle = drawCircle(currDivX, currDivY, circleRedius);
	self.data('ownCircle', circle);
	if (!self.data('children'))
		self.data('children', new Array());

	var vNodeSpaceMultiplier = -1*Math.floor(noOfChild/2);//Vertical spacing multiplier between the nodes.
	for (var indx = 0; indx < noOfChild; indx++) {

		childX = self.position().left + hNodeSpace;
		childY = self.position().top + vNodeSpaceMultiplier*vNodeSpace;
		if ((vNodeSpaceMultiplier == -1) && (noOfChild % 2 == 0))// Avoid placing node just infront of parent if number of children are odd.
			++vNodeSpaceMultiplier;
		
		++vNodeSpaceMultiplier;
		
		newDropFrame = rootElmntDropFrame.cloneNode(false); //true means clone all childNodes and all event handlers
		$('<div class="id-div" style="position: absolute;top:0px;left:5px;font-size:10px;"></div>').appendTo($(newDropFrame));
		
		$(newDropFrame).css({ top: childY, left: childX});//set position
		newDropFrame.id = ++currNodeId;
			
		$(newDropFrame).find('.id-div').html(currNodeId);//To display NodeId over rect-Div.

		childLineHeadX = childX - canvasPosition.left + sLeft;
		childLineHeadY = childY - canvasPosition.top + self.outerHeight() / 2 + sTop;
		line = drawLine(currDivX, currDivY, childLineHeadX, childLineHeadY, self.attr('id'));

		var nodeText = (childrenText == undefined) ? "" : ((childrenText[indx] == undefined) ? "" : childrenText[indx]);
		text = drawText(childLineHeadX, childLineHeadY - self.height() - 20, nodeText);
		$(newDropFrame).data('nodeText',nodeText);
		var ruleId = (ruleIds == undefined) ? -1 : ((ruleIds[indx] == undefined) ? -1 : ruleIds[indx]);
		
		setNodeProperties(self[0], newDropFrame, line, text, ruleId);

	}
	return newDropFrame;
}

/*
 * deleted the selected node and it's descendents 
 */
function removeNode(self, visitedNode, isNewNode) {//Cascade remove.

	var nodeList = $(self).data('children');
	if (nodeList === undefined)
		return false;

	for (var cnt = 0; cnt < nodeList.length; cnt++) {
		
		var currNode = nodeList[cnt], currentNodeId = currNode.id;
		
		if(visitedNode.includes(currentNodeId))
			continue;
		visitedNode.push(currentNodeId);	
		
		removeNode(nodeList[cnt], visitedNode, isNewNode);	
				
		var ownLines = $(nodeList[cnt]).data('ownLines');
		if (ownLines != undefined){
			
			for(var indx=0; indx<ownLines.length; indx++)
				ownLines[indx].remove();				
		}
		
		var ownText = $(nodeList[cnt]).data('ownText');
		if (ownText != undefined)
			ownText.remove();
		
		/*var ownCircle = $(self).data('ownCircle');
		if (ownCircle != undefined){
			$(self).removeData("ownCircle");
			ownCircle.remove();
		}*/
			
		
		$(nodeList[cnt]).remove();
		currentNodeId--;
		
	}
	
	if(!isNewNode){
	$(self).find('img').remove();
	if (($(self).data('ownText')) != undefined) $(self).data('ownText').remove();
	}
	
	var ownCircle = $(self).data('ownCircle');
	if (ownCircle != undefined){
		ownCircle.remove();
	}
	
	if($(self).data('children')){
		$(self).removeData("children");	
		
	}
	
	stage.draw();
}

/*
 * removes link between connector node and other node 
 */
function removeLink(self) {// Unlink connector node

	var nodeList = $(self).data('children');
	if (nodeList === undefined)
		return false;

	var child = nodeList[0];
	if(!child)
		return ;
	var ownLines = $(child).data('ownLines');
	for(var indx=0; indx<ownLines.length; indx++){
		if(ownLines[indx].attrs.parentId === self.id)
			ownLines[indx].remove();
	}

	var ownCircle = $(self).data('ownCircle');
	if (ownCircle != undefined)
		ownCircle.remove();
	
	if($(self).data('children'))
		$(self).removeData("children");	
	
	stage.draw();
}

/*
 * inserts a new node before selected node and disconnects it from it's children 
 */
function insertNodeBefore(self){  // insert new node before selected node 
	if(nodeGroupComponents.indexOf(self.id) == -1 )
		nodeGroupComponents.push(self.id);
	var ownLines = $(self).data('ownLines');
	var thisNodeParent = $(self).data('parent');
	var ruleId = $(self).data('ruleId');
	
	var newNode = prepareChildren(thisNodeParent, 1);
	$(newNode).data('ownLines')[0].remove();
	
	//remove selected node from children of parent node 
	var selfNodeIndex = thisNodeParent.data('children').indexOf(self);
	if(selfNodeIndex > -1)
		thisNodeParent.data('children').splice(selfNodeIndex,1);
		
	// add ownLines of selected node to new node
	
	//$(newNode).data('ownLines',new Array());
	$(newNode).data('ownLines',ownLines);
	
	if (ruleId != undefined && ruleId != -1){
		$(newNode).data('ruleId',ruleId);
		$(self).removeData('ruleId');
	}
	
	//traverse each line and change parent to newly created node
	for(var indx=0 ; indx<ownLines.length ; indx++){
		var node = $('#'+ownLines[indx].attrs.parentId);
		var index = node.data('children').indexOf(newNode);
		if(index == -1)
			node.data('children').push(newNode);
		
		index = node.data('children').indexOf(self);
		if(index > -1)
			node.data('children').splice(index,1);
			
	}
	
	//remove incoming lines for selected parent
	$(self).removeData('ownLines');
	$(self).removeData('parent');
	redrawNodeAttribute($(self));
	stage.draw();
	layer.draw();
	
}

/*
 * sets node properties ownLine,ownText,ownCircle and ruleId
 */
function setNodeProperties(parent, child, childLine, childText, childRuleId) {
	
	document.body.appendChild(child);
	
	child.style.visibility = "visible";
	
	addDragDropListner(child);
	
	//Right-Click event handler
	document.getElementById(child.id).addEventListener("contextmenu", function(){rightClickEventHandler(child.id);});

	$(child).data('parent', $(parent));
	
	var childList = $(parent).data('children');
	childList.push(child);
	
	if($(child).data('ownLines') == undefined)
		$(child).data('ownLines', new Array());
	$(child).data('ownLines').push(childLine);
	
	$(child).data('ownText', childText);
	$(child).data('ruleId', childRuleId);
	
	layer.draw();//To refresh
}

function drawCircle(x, y, radius) {

	circle = new Kinetic.Circle({
		x: x,
		y: y,
		radius: radius,
		fill: 'green' //change this function to set default color to green.
	});

	layer.add(circle);
	return circle;
}

/*
 * draws text over a process Node 
 */
function drawText(x, y, simpletext) {

	text = new Kinetic.Text({
		x: x,
		y: y,
	    width: 100,
		text: simpletext,
		fontSize: 10,
		fontFamily: 'Calibri',
		fill: 'green'
	});
	
	layer.add(text);
	return text;
}

/*
 *  draws line between two nodes 
 */
function drawLine(fromx, fromy, tox, toy, parentId) {

	angle = Math.atan2(toy - fromy, tox - fromx);

	line = new Kinetic.Line({
		draggable: true, stroke: '#' + lineColor, strokeWidth: 1,
		points: [fromx, fromy, tox, toy, tox - headlen * Math.cos(angle - Math.PI / 6), toy - headlen * Math.sin(angle - Math.PI / 6),
				 tox, toy, tox - headlen * Math.cos(angle + Math.PI / 6), toy - headlen * Math.sin(angle + Math.PI / 6)],
		parentId:parentId		 
	});

	layer.add(line);
	return line;
}

function addHexColor(c1, c2) {

	var hexStr = (parseInt(c1, 16) + parseInt(c2, 16)).toString(16);
	
	while (hexStr.length < 6) {
		hexStr = '0' + hexStr; // Zero pad.
	} 
	
	return hexStr;
}

/*
 * traverses through the nodeStructure data and logs Node properties 
 */
function traverse(obj, nodeStr) {//obj is JQuery obj.
	
	logNodeStructureProperties(nodeStr, obj[0]);//pass JavaScript Obj.
						
	var nodeList = obj.data('children');

	if (nodeList != undefined) {

		for (var i = 0; i < nodeList.length; i++) {
			
			nodeStr.child.push(new Object());
			
			if(loggedNodeIds.indexOf(nodeList[i].id) != -1){
				logNodeStructureProperties(nodeStr.child[i], nodeList[i]);
				continue;
			}
			else 
				loggedNodeIds.push(nodeList[i].id);
			
			//set paramters to the nodsStr object... for each object
			traverse($(nodeList[i]), nodeStr.child[i]);			
		}
	}
	
}

/*
 * logs Node structure properties to nodeStructure object 
 */
function logNodeStructureProperties(nodeStr, obj) {
	
	if(!nodeStr)
		return;
	nodeStr.nodeId = obj.id;
	nodeStr.position = {};
	nodeStr.position.x = parseInt($(obj).css("left"))+sLeft+'px';
	nodeStr.position.y = parseInt($(obj).css("top"))+sTop+'px';
	
	var img = obj.getElementsByTagName('img')[0];
	if (img != undefined) {
		nodeStr.image = {};
		nodeStr.image.src = img.getAttribute('src');
		nodeStr.image.id = img.getAttribute('id');
	}

	nodeStr.nodeText  = $(obj).data('nodeText') || "";
	nodeStr.ruleId  = $(obj).data('ruleId') || -1;//nodeStr.ruleId  = obj.ruleId == undefined ? -1 : obj.ruleId;
	
	//check if not having child, defensive stretegy
	if((obj.children != undefined && obj.children.length > 0) && img)
	switch(nodeStr.image.id) {

	    case 'form' :
	    case 'formV2' :
	    	nodeStr.dataMapTextFields = $(obj).data("dataMapTextFields") || "";
	    	nodeStr.dataMapping = $(obj).data("dataMapping") || [];
	    	nodeStr.editOptions = $(obj).data("editOptions") || [];
		case 'jsp' :
			nodeStr.submitterRoleIds = $(obj).data("submitterRoleIds") || "";
	    	nodeStr.submittableByApplicant = $(obj).data("submittableByApplicant") || "";
	    	nodeStr.waitMsg = $(obj).data("waitMsg") || "";
			nodeStr.name = $(obj).data("name") || "";
			nodeStr.editOptions = $(obj).data("editOptions") || [];
			nodeStr.dataMapTextFields = $(obj).data("dataMapTextFields") || "";
	    	nodeStr.dataMapping = $(obj).data("dataMapping") || [];
	    	nodeStr.ruleVersion = $(obj).data("ruleVersion") || "1";
		case 'process':
			nodeStr.rulesetId = $(obj).data("rulesetId") || "";
			nodeStr.selectedIndx = $(obj).data("selectedIndx") || "";
			nodeStr.ruleVersion = $(obj).data("ruleVersion") || "1";
			break;

		case 'payment' : 
			nodeStr.name = $(obj).data("name") || "";
			nodeStr.provider = $(obj).data("provider") || "";
			nodeStr.payCcy = $(obj).data("payCcy") || "";
			nodeStr.paymentCancel = $(obj).data("paymentCancel") || "";
			nodeStr.paymentRefundOn = $(obj).data("paymentRefundOn") || "";
			nodeStr.payAmount = $(obj).data("payAmount") || "";
			nodeStr.payDesc = $(obj).data("payDesc") || "";
			nodeStr.paySiteName = $(obj).data("paySiteName") || "";
			nodeStr.paySiteLogo = $(obj).data("paySiteLogo") || "";
			nodeStr.payItemClassName = $(obj).data("payItemClassName") || "";
			nodeStr.payItemClassPk = $(obj).data("payItemClassPk") || "";
			nodeStr.dataMapTextFields = $(obj).data("dataMapTextFields") || "";
	    	nodeStr.dataMapping = $(obj).data("dataMapping") || [];
			nodeStr.rulesetId = $(obj).data("rulesetId") || "";
			nodeStr.selectedIndx = $(obj).data("selectedIndx") || "";
	    	nodeStr.waitMsg = $(obj).data("waitMsg") || "";
	    	nodeStr.paidMsg = $(obj).data("paidMsg") || defaultPaidMessage;
	    	nodeStr.refundedMsg = $(obj).data("refundedMsg") || defaultRefundedMessage;
			break;
			
		case 'paymentV2' : 
			nodeStr.name = $(obj).data("name") || "";
			nodeStr.provider = $(obj).data("provider") || "";
			nodeStr.paymentCancel = $(obj).data("paymentCancel") || "";
			nodeStr.paymentRefundOn = $(obj).data("paymentRefundOn") || "";
			nodeStr.paySiteName = $(obj).data("paySiteName") || "";
			nodeStr.paySiteLogo = $(obj).data("paySiteLogo") || "";
			nodeStr.dataMapTextFields = $(obj).data("dataMapTextFields") || "";
	    	nodeStr.dataMapping = $(obj).data("dataMapping") || [];
			nodeStr.rulesetId = $(obj).data("rulesetId") || "";
			nodeStr.selectedIndx = $(obj).data("selectedIndx") || "";
	    	nodeStr.waitMsg = $(obj).data("waitMsg") || "";
	    	nodeStr.termsAndCondition = $(obj).data("termsAndCondition") || "";
	    	nodeStr.paidMsg = $(obj).data("paidMsg") || defaultPaidMessage;
	    	nodeStr.refundedMsg = $(obj).data("refundedMsg") || defaultRefundedMessage;
	    	nodeStr.enableOfflinePayment = $(obj).data("enableOfflinePayment") || "";
			break;
			
		case 'api' :
			nodeStr.url = $(obj).data("url") || "";
			nodeStr.method = $(obj).data("method") || "GET";
			nodeStr.asynchronous = $(obj).data("asynchronous") || false;
			nodeStr.encode = $(obj).data("encode") || false;
	    	nodeStr.header = $(obj).data("header") || [];
	    	nodeStr.responseMapping = $(obj).data("responseMapping") || "";
	    	break;

		case 'entity' :
			nodeStr.type = $(obj).data("type") || "";
			nodeStr.identifier = $(obj).data("identifier") || "";
			break;

		case 'pricing' :
			nodeStr.name = $(obj).data("name") || "";
			nodeStr.scheme = $(obj).data("scheme") || "";
			nodeStr.subScheme = $(obj).data("subScheme") || "";
			nodeStr.outstanding = $(obj).data("outstanding") || "";
			nodeStr.consolidate = $(obj).data("consolidate") || "";
			break;

		case 'preview' : 
			nodeStr.previewId = $(obj).data("previewId") || "";
			nodeStr.customId = $(obj).data("customId") || "";
			nodeStr.enablePreview = $(obj).data("enablePreview") || "";
			nodeStr.enableEsign = $(obj).data("enableEsign") || "";
			nodeStr.esignApiKey = $(obj).data("esignApiKey") || defaultEsignApiKey;
			nodeStr.esignApiUrl = $(obj).data("esignApiUrl") || defaultEsignApiUrl;
			nodeStr.previewJspNode = $(obj).data("previewJspNode") || "";
			break;
			
		case 'message' : 
			nodeStr.messageInput = $(obj).data("messageInput") || ""; break;

		case 'mail' :
			nodeStr.recipient = $(obj).data("recipient") || "";
			nodeStr.officerRoleIds = $(obj).data("officerRoleIds") || "";
			nodeStr.cc = $(obj).data("cc") || "";
			nodeStr.ccEmailAddressText = $(obj).data("ccEmailAddressText") || "";
			
		case 'customAction' :
			nodeStr.customActionTitleOptions = $(obj).data("customActionTitleOptions") || "";
			nodeStr.configurationText = $(obj).data("configurationText") || "";
			
		case 'account' :
			nodeStr.templateId = $(obj).data("templateId") || "";
			nodeStr.accountStatusId = $(obj).data("accountStatusId") || "";
			nodeStr.emailAddressVerifiedId = $(obj).data("emailAddressVerifiedId") || "";
			break;

		case 'status' :
			nodeStr.statusTypeId = $(obj).data("statusTypeId") || "";
			nodeStr.status = $(obj).data("status") || "";
			nodeStr.statusApproverIds = $(obj).data("statusApproverIds") || "";
			if(nodeStr.status==="Pending")
				nodeStr.emailTemplateId = $(obj).data("emailTemplateId") || "";
			break;

		case 'timer' :
			nodeStr.templateId = $(obj).data("templateId") || "";
			nodeStr.recipient = $(obj).data("recipient") || "";
			nodeStr.officerRoleIds = $(obj).data("officerRoleIds") || "";
			nodeStr.cc = $(obj).data("cc") || "";
			nodeStr.ccEmailAddressText = $(obj).data("ccEmailAddressText") || "";
			nodeStr.rulesetId = $(obj).data("rulesetId") || "0";
			nodeStr.jobListener = $(obj).data("jobListener") || "ScheduledMailJob";
			nodeStr.execOnce = $(obj).data("execOnce") || "";
			nodeStr.cronSchedule = $(obj).data("cronSchedule") || "0 */5 * * * ?";
			break;
			
		default : break;
	}
	// common to all
	nodeStr.allowReprocess = $(obj).data("allowReprocess") || "";

	if($(obj).data('children') && $(obj).data('children').length > 0)
		nodeStr.child = [];
}

/*
 * redraws design wizard from the JSON data received from database
 */
function reDrawDesignerWizard(nodeStructure) {
	
	//set properties for root element
	$(rootElmntDropFrame).css({left: nodeStructure.position.x, top: nodeStructure.position.y});
	rootElmntDropFrame.id = nodeStructure.nodeId;
	$(rootElmntDropFrame).data('ownText', drawText(nodeStructure.position.x-65,nodeStructure.position.y-80 , nodeStructure.nodeText));
	$(rootElmntDropFrame).data('nodeText', nodeStructure.nodeText);
	$(rootElmntDropFrame).data('children', new Array());
	
	//set tooltip text
	if(nodeStructure.nodeText==="")
		rootElmntDropFrame.setAttribute('title',"Default");
	else
		rootElmntDropFrame.setAttribute('title',nodeStructure.nodeText);
	
	// set node id 
	$('<div class="id-div" style="position: absolute;top:0px;left:5px;font-size:10px;"></div>').appendTo($(rootElmntDropFrame));
	rootElmntDropFrame.id = nodeStructure.nodeId;
	$(rootElmntDropFrame).find('.id-div').html(nodeStructure.nodeId);

	if(nodeGroupComponents.indexOf(rootElmntDropFrame.id) == -1 )
		nodeGroupComponents.push(rootElmntDropFrame.id);
	
	setNodeAttributeForRedraw(nodeStructure, rootElmntDropFrame);
	redrawHelper(nodeStructure, rootElmntDropFrame);	
}

/*
 *  traverses through JSON nodeStructure and draws nodes 
 */
function redrawHelper(parentJsonStructure, parent) {

	var childNodeElement;
	var childNodeJson;
	var line, text;
	var childLineTailX, childLineTailY;
	var childLineHeadX, childLineHeadY;

	var children = parentJsonStructure.child;

	if (children != undefined) {

		childLineTailX = parseInt(parentJsonStructure.position.x) - canvasPosition.left + $(rootElmntDropFrame).outerWidth();
		childLineTailY = parseInt(parentJsonStructure.position.y) - canvasPosition.top + $(rootElmntDropFrame).outerHeight() / 2;

		if (children.length > 0)
			$(parent).data('ownCircle', drawCircle(childLineTailX, childLineTailY, circleRedius));

		for (var cnt = 0; cnt < children.length; cnt++) {

			childNodeJson = children[cnt];
			var currDivX = parseInt(childNodeJson.position.x);
		    var currDivY = parseInt(childNodeJson.position.y);
		    
		    childLineHeadX = currDivX - canvasPosition.left;
		    childLineHeadY = currDivY - canvasPosition.top + $(parent).outerHeight() / 2;
		    line = drawLine(childLineTailX, childLineTailY, childLineHeadX, childLineHeadY, parent.id);
		    
		    //var childNodeElement = document.getElementById(childNodeJson.nodeId);
		    if(handleDuplicateNode(parent, childNodeJson.nodeId, line)){//childNodeJson.nodeId, is already drawn.
		    	childNodeElement = document.getElementById(childNodeJson.nodeId);
		    }else{
		    	childNodeElement = rootElmntDropFrame.cloneNode(false);
		    	$('<div class="id-div" style="position: absolute;top:0px;left:5px;font-size:10px;"></div>').appendTo($(childNodeElement));
		    	
			    $(childNodeElement).css({ top: currDivY, left: currDivX});
			    $(childNodeElement).data('children', new Array());

			    childNodeElement.id = childNodeJson.nodeId;
			    if(parseInt(currNodeId) < parseInt(childNodeElement.id))
			    	currNodeId = childNodeJson.nodeId;
			    
			    $(childNodeElement).find('.id-div').html(childNodeElement.id);
			    
			    var nodeText =  childNodeJson.nodeText;
			    nodeText=nodeText.replace(/[0-9/]/g,"");
			    if(childNodeJson.ruleId!=-1)
			    	nodeText = childNodeJson.ruleId + "/"+nodeText;
			    
			    if(childNodeJson.image && childNodeJson.image.id != "message"){
			    	 text = drawText(childLineHeadX-10, childLineHeadY - $(parent).height(), nodeText);
				     $(childNodeElement).data('nodeText',nodeText);
			    }
			    else{
			    	nodeText = childNodeJson.messageInput ? childNodeJson.messageInput.split('<script type="text/javascript">')[0].replace(/<(?:.|\n)*?>/gm, '').trim():"";
			    }
		        // set tooltip text
		        if(nodeText==="")
		        	childNodeElement.setAttribute('title',"Default");
		    	else
		    		childNodeElement.setAttribute('title',nodeText);
		        
		        var ruleId =  childNodeJson.ruleId;

				setNodeAttributeForRedraw(childNodeJson, childNodeElement);
				
			    setNodeProperties(parent, childNodeElement, line, text, ruleId);
			    
			    redrawNodeAttribute($(childNodeElement));
		    }
		    
		    redrawHelper(childNodeJson, childNodeElement);
		}
	}
}

/*
 * checks for duplicate nodes 
 */
function handleDuplicateNode(parent, nodeId, line){

	var childNodeElement = document.getElementById(nodeId);
	
	if(childNodeElement == undefined)
		return false;
	
	//Add child
	var childList = $(parent).data('children');
	childList.push(childNodeElement);
	
	//Add line
	if($(childNodeElement).data('ownLines') == undefined)
		$(childNodeElement).data('ownLines', new Array());
	$(childNodeElement).data('ownLines').push(line);
	
	layer.draw();//To refresh
	
	return true;
	
}

function setNodeAttributeForRedraw(nodeJson, nodeElement) {
	
	if (nodeJson.image != undefined)
		$(nodeElement).append("<img alt='Image' id=" + nodeJson.image.id + " src=" + nodeJson.image.src + ">");

	if ($(nodeElement).find('img') != undefined && $(nodeElement).find('img')[0] != undefined)
	    $(nodeElement).find('img')[0].ondblclick = function(event) {
			loadJSONArrForDropDown(nodeJson.image.id, nodeElement);
			initModal(nodeJson.image.id + '_model_popup');
	    };

	$(nodeElement).data("ruleId", nodeJson.ruleId);
	$(nodeElement).data("nodeId", nodeJson.nodeId);
	
	if (nodeJson.image != undefined && nodeJson.image.id != undefined)
	switch(nodeJson.image.id) {
	    case 'formV2' :
	    case 'form' :
	    	$(nodeElement).data("dataMapOptions", nodeJson.dataMapOptions);
	    	$(nodeElement).data("dataMapTextFields", nodeJson.dataMapTextFields);
	    	$(nodeElement).data("dataMapping", nodeJson.dataMapping);
	    	$(nodeElement).data("editOptions", nodeJson.editOptions);
		case 'jsp' :
			$(nodeElement).data("submitterRoleIds", nodeJson.submitterRoleIds);
	    	$(nodeElement).data("submittableByApplicant", nodeJson.submittableByApplicant);
	    	$(nodeElement).data("waitMsg", nodeJson.waitMsg);
			$(nodeElement).data("name", nodeJson.name);
			$(nodeElement).data("editOptions", nodeJson.editOptions);
			$(nodeElement).data("dataMapOptions", nodeJson.dataMapOptions);
	    	$(nodeElement).data("dataMapTextFields", nodeJson.dataMapTextFields);
	    	$(nodeElement).data("dataMapping", nodeJson.dataMapping);
	    	$(nodeElement).data("ruleVersion", nodeJson.ruleVersion || "1");		
		case 'process':
			$(nodeElement).data("rulesetId", nodeJson.rulesetId);
			$(nodeElement).data("selectedIndx", nodeJson.selectedIndx);
			$(nodeElement).data("ruleVersion", nodeJson.ruleVersion || "1");
			break;

		case 'payment' : 
			$(nodeElement).data("name", nodeJson.name);
			$(nodeElement).data("provider", nodeJson.provider);
			$(nodeElement).data("payCcy", nodeJson.payCcy);
			$(nodeElement).data("paymentCancel", nodeJson.paymentCancel);
			$(nodeElement).data("paymentRefundOn", nodeJson.paymentRefundOn);
			$(nodeElement).data("payAmount", nodeJson.payAmount);
			$(nodeElement).data("payDesc", nodeJson.payDesc);
			$(nodeElement).data("paySiteName", nodeJson.paySiteName);
			$(nodeElement).data("paySiteLogo", nodeJson.paySiteLogo);
			$(nodeElement).data("payItemClassName", nodeJson.payItemClassName);
			$(nodeElement).data("payItemClassPk", nodeJson.payItemClassPk);
			$(nodeElement).data("dataMapTextFields", nodeJson.dataMapTextFields);
			$(nodeElement).data("dataMapping", nodeJson.dataMapping);
			$(nodeElement).data("rulesetId", nodeJson.rulesetId);
			$(nodeElement).data("selectedIndx", nodeJson.selectedIndx);
			$(nodeElement).data("waitMsg", nodeJson.waitMsg);
			$(nodeElement).data("paidMsg", nodeJson.paidMsg);
			$(nodeElement).data("refundedMsg", nodeJson.refundedMsg);			
			break;
			
		case 'paymentV2' : 
			$(nodeElement).data("name", nodeJson.name);
			$(nodeElement).data("provider", nodeJson.provider);
			$(nodeElement).data("paymentCancel", nodeJson.paymentCancel);
			$(nodeElement).data("paymentRefundOn", nodeJson.paymentRefundOn);
			$(nodeElement).data("paySiteName", nodeJson.paySiteName);
			$(nodeElement).data("paySiteLogo", nodeJson.paySiteLogo);
			$(nodeElement).data("dataMapTextFields", nodeJson.dataMapTextFields);
			$(nodeElement).data("dataMapping", nodeJson.dataMapping);
			$(nodeElement).data("rulesetId", nodeJson.rulesetId);
			$(nodeElement).data("selectedIndx", nodeJson.selectedIndx);
			$(nodeElement).data("waitMsg", nodeJson.waitMsg);
			$(nodeElement).data("termsAndCondition", nodeJson.termsAndCondition);
			$(nodeElement).data("paidMsg", nodeJson.paidMsg);
			$(nodeElement).data("refundedMsg", nodeJson.refundedMsg);
			$(nodeElement).data("enableOfflinePayment", nodeJson.enableOfflinePayment);			
			break;
			
		case 'api' :
			$(nodeElement).data("url", nodeJson.url);
			$(nodeElement).data("method", nodeJson.method);
			$(nodeElement).data("asynchronous", nodeJson.asynchronous);
			$(nodeElement).data("encode", nodeJson.encode == undefined ? true : nodeJson.encode);
			$(nodeElement).data("header", nodeJson.header);
			$(nodeElement).data("responseMapping", nodeJson.responseMapping);
	    	break;

		case 'entity' :
			$(nodeElement).data("type", nodeJson.type);
			$(nodeElement).data("identifier", nodeJson.identifier);
			break;

		case 'pricing' :
			$(nodeElement).data("name", nodeJson.name);
			$(nodeElement).data("scheme", nodeJson.scheme);
			$(nodeElement).data("subScheme", nodeJson.subScheme);
			$(nodeElement).data("outstanding", nodeJson.outstanding);
			$(nodeElement).data("consolidate", nodeJson.consolidate);
			break;
			
		case 'preview' : 
			$(nodeElement).data("previewId", nodeJson.previewId);
			$(nodeElement).data("customId", nodeJson.customId);
			$(nodeElement).data("enablePreview", nodeJson.enablePreview);
			$(nodeElement).data("enableEsign", nodeJson.enableEsign);
			$(nodeElement).data("esignApiKey", nodeJson.esignApiKey);
			$(nodeElement).data("esignApiUrl", nodeJson.esignApiUrl);
			$(nodeElement).data("previewJspNode", nodeJson.previewJspNode);
			break;
			
		case 'message' : $(nodeElement).data("messageInput", nodeJson.messageInput); break;

		case 'mail' :
			$(nodeElement).data("recipient", nodeJson.recipient);
			$(nodeElement).data("officerRoleIds", nodeJson.officerRoleIds);
			$(nodeElement).data("cc", nodeJson.cc);
			$(nodeElement).data("ccEmailAddressText", nodeJson.ccEmailAddressText);
			
		case 'customAction' :
			$(nodeElement).data("customActionTitleOptions", nodeJson.customActionTitleOptions);
			$(nodeElement).data("configurationText", nodeJson.configurationText);
			
		case 'account' :
			
			$(nodeElement).data("templateId", nodeJson.templateId);
			$(nodeElement).data("accountStatusId", nodeJson.accountStatusId);
			$(nodeElement).data("emailAddressVerifiedId", nodeJson.emailAddressVerifiedId);
			break;

		case 'status' :
			$(nodeElement).data("statusTypeId", nodeJson.statusTypeId);
			$(nodeElement).data("status", nodeJson.status);
			$(nodeElement).data("statusApproverIds", nodeJson.statusApproverIds);
			$(nodeElement).data("emailTemplateId", nodeJson.emailTemplateId);
			
			break;

		case 'timer' :
			$(nodeElement).data("templateId", nodeJson.templateId);
			$(nodeElement).data("recipient", nodeJson.recipient);
			$(nodeElement).data("officerRoleIds", nodeJson.officerRoleIds);
			$(nodeElement).data("cc", nodeJson.cc);
			$(nodeElement).data("ccEmailAddressText", nodeJson.ccEmailAddressText);
			$(nodeElement).data("rulesetId", nodeJson.rulesetId);
			$(nodeElement).data("jobListener", nodeJson.jobListener);
			$(nodeElement).data("execOnce", nodeJson.execOnce);
			$(nodeElement).data("cronSchedule", nodeJson.cronSchedule);
		default : break;
	}
	// common to all
	$(nodeElement).data("allowReprocess", nodeJson.allowReprocess);
}

function rightClickEventHandler(rightClkdElmtId){
	var connectingNode = document.getElementById(rightClkdElmtId); 
	var confirmMsg = 'It will clear child structure. Do you want to proceed?'; 
	var menuItems = {
					"copy" : {name:"Copy"},
					"insert": {name: "Insert Node Before"},
					"delete": {name: "Delete"},
					"quit": {name: "Quit", icon: function(){
						return 'context-menu-icon context-menu-icon-quit';
					}}
				};
	
	// checking if connecting node or not 
	if(isConnectingNode(connectingNode)){
		confirmMsg = 'It will revert your latest connection. Do you want to proceed ?';
		menuItems = {
				"copy" : {name:"Copy"},
				"insert": {name: "Insert Node Before"},
				"unlink": {name: "Unlink Node"},
				"quit": {name: "Quit", icon: function(){
					return 'context-menu-icon context-menu-icon-quit';
				}}
			};
	}
	
	$.contextMenu({
		selector: '#' + rightClkdElmtId,
		callback: function(key, options) {
			switch(key){
			
				case 'insert':
					confirmMsg = 'Unlink current node and insert a new node before ?';
					if (confirm(confirmMsg)) 
						insertNodeBefore(connectingNode);
					break;
				case 'delete':
					if (confirm(confirmMsg)) 
						removeNode(connectingNode, new Array, false);
				break;
				
				case 'unlink':
					if (confirm(confirmMsg)) 
						removeLink(connectingNode);
				break;
			}
				
		},
		items: menuItems
		
	});  
	
}

function rederToURL(pageToRender) {
    AUI().use('liferay-portlet-url',
            function(A) {
   				var renderURL = Liferay.PortletURL.createRenderURL();
   				renderURL.setParameter("mvcPath", pageToRender);
   				renderURL.setPortletId("processbuilderaction_WAR_SPProcessEngineportlet");
   				renderURL.setWindowState("<%= LiferayWindowState.NORMAL.toString() %>");
   				window.location.href = renderURL.toString();
           }
   );
}

/*
 * checks if selected node is connected node or not 
 */
function isConnectingNode(node){
	return ($(node).find('img').length == 0) && ($(node).data('children')!=undefined && $(node).data('children')!=0 )? true : false;
}
function showDataMapSection(){
	
	document.getElementById('addDataMapSectionBtnId').style.display = 'none';
	document.getElementById('dataMapId').style.display = 'block';
}


function showDataMapSectionJsp(){
	
	document.getElementById('addDataMapSectionJspBtnId').style.display = 'none';
	document.getElementById('dataMapJspId').style.display = 'block';
}

function showDataMapSectionPayment(){
	
	document.getElementById('addDataMapSectionPaymentBtnId').style.display = 'none';
	document.getElementById('dataMapPaymentId').style.display = 'block';
}

function showRuleSectionForm(){
	
	document.getElementById('addRuleSectionFormBtnId').style.display = 'none';
	document.getElementById('ruleFormId').style.display = 'block';
}

function showRuleSectionJsp(){
	
	document.getElementById('addRuleSectionJspBtnId').style.display = 'none';
	document.getElementById('ruleJspId').style.display = 'block';
}

function hideDataMapSection(dataMapSection){
	document.getElementById('addDataMapSectionBtnId').style.display = 'block';
	document.getElementById('dataMapId').style.display = 'none';
	$('#dataMapId').find('.dataMapSection').remove();
	$('#dataMapId').append(dataMapSection);
}

function hideDataMapSectionJsp(dataMapSection){
	document.getElementById('addDataMapSectionJspBtnId').style.display = 'block';
	document.getElementById('dataMapJspId').style.display = 'none';
	$('#dataMapJspId').find('.dataMapSectionJsp').remove();
	$('#dataMapJspId').append(dataMapSection);
}

function hideDataMapSectionPayment(dataMapSection){
	document.getElementById('addDataMapSectionPaymentBtnId').style.display = 'block';
	document.getElementById('dataMapPaymentId').style.display = 'none';
	$('#dataMapPaymentId').find('.dataMapSectionPayment').remove();
	$('#dataMapPaymentId').append(dataMapSection);
}

function hideRuleSectionJsp(ruleSection){
	document.getElementById('addRuleSectionJspBtnId').style.display = 'block';
	document.getElementById('ruleJspId').style.display = 'none';
	$('#ruleJspId').find('.ruleSection').remove();
	$('#ruleJspId').append(ruleSection);
}

function hideRuleSectionForm(ruleSection){
	document.getElementById('addRuleSectionFormBtnId').style.display = 'block';
	document.getElementById('ruleFormId').style.display = 'none';
	$('#ruleFormId').find('.ruleSection').remove();
	$('#ruleFormId').append(ruleSection);
}

