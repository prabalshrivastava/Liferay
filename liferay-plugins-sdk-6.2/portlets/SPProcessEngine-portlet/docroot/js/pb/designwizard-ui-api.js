function processApiModal(self){//self is JQuery Obj
	var popupId = 'api_model_popup';
	var popupSkeletonId = 'api_model_popup_skelton';
	var out = "";
	
	var modal = document.getElementById(popupId);
	var modalSkeleton = modal.querySelector('#'+popupSkeletonId);
	if(modalSkeleton)
		modalSkeleton.parentNode.removeChild(modalSkeleton);
		
	modal.getElementsByClassName('modal-content')[0].insertBefore(document.getElementById(popupSkeletonId).cloneNode(true), modal.getElementsByClassName('modal-submit')[0]);
	
	document.getElementById(popupId).classList.remove("modal-hidden");
	document.getElementById(popupId).classList.add("modal-visible");
	var modalPopup = modal.querySelector('#'+popupSkeletonId);
	modalPopup.classList.remove("modal-hidden");
	modalPopup.classList.add("modal-visible");
	
	if(self.data("url")) {
		modal.querySelector('#urlTxtField').value = self.data("url");	
	}
	
	if(self.data("responseMapping")) {
		modal.querySelector('#responseMapping').value = self.data("responseMapping");	
	}
	
	if(self.data("asynchronous"))  {
		modal.querySelector('#asynchronousCheckBox').checked = self.data("asynchronous");
	}
	modal.querySelector('#allowReprocess').checked = self.data("allowReprocess")||"";
	if(self.data("encode"))  {
		modal.querySelector('#encodeCheckBox').checked = self.data("encode");
	}
	
	var selectedMethod = modal.querySelector("#method option[value='"+ (self.data("method") || "GET") +"']");
	if (selectedMethod) {
		selectedMethod.setAttribute('selected','');
	}

	addApiHeaderSection(self, modal);

	var btnSave = modal.querySelector('#btnModelSave');
	btnSave.onclick = function() {
		modal.style.display = "none";
		self.data("allowReprocess", modal.querySelector('#allowReprocess').checked);
		self.data("url", modal.querySelector('#urlTxtField').value);
		self.data("method", modal.querySelector('#method').value);
		self.data("asynchronous",modal.querySelector('#asynchronousCheckBox').checked);
		self.data("encode",modal.querySelector('#encodeCheckBox').checked);
		self.data('responseMapping', modal.querySelector('#responseMapping').value);

		var headerArr = [];
		var apiHeaderSection = modal.getElementsByClassName("apiHeaderSection");
		for (var indx = 0; indx < apiHeaderSection.length; indx++) {
			headerArr.push({
				key: apiHeaderSection[indx].querySelector('#apiHeaderKey').value,
				value: apiHeaderSection[indx].querySelector('#apiHeaderValue').value
			});
		}
		self.data("header", headerArr);
		
		//sets node text
		var currDivX = self.position().left - canvasPosition.left + self.outerWidth() + sLeft;
		var currDivY = self.position().top - canvasPosition.top + self.outerHeight() / 2 + sTop;
		
		var nodeText = "Invoke API";
		
		//set tooltip text
		if(nodeText === "")
			self[0].setAttribute('title',"Default");
		else
			self[0].setAttribute('title',nodeText);
		
		if(self.data('ownText')) self.data('ownText').remove();
		self.data('ownText', drawText(currDivX - 70, currDivY - 70 , nodeText))
		self.data('nodeText', nodeText);
		layer.draw();
		lineColor = addHexColor(lineColor, colorInterval);		
	}

	modal.style.display = "block";	
}

function showApiHeaderSection(buttonElement) {
	var apiHeaderContainer = buttonElement.parentElement.querySelector('#apiHeaderContainer');
	apiHeaderContainer.style.display = "block";
	buttonElement.style.display = "none";
}

function hideApiHeaderSection(modal, headerSection){
	var addHeaderButton = modal.querySelector('#addApiHeaderSection');
	var apiHeaderContainer = modal.querySelector('#apiHeaderContainer');
	addHeaderButton.style.display = 'block';
	apiHeaderContainer.style.display = 'none';
	$(apiHeaderContainer).find('.apiHeaderSection').remove();
	$(apiHeaderContainer).append(headerSection);
}

function addApiHeaderSection(self, modal) {
	var apiHeaderRowElement = modal.getElementsByClassName("apiHeaderSection");
	var headerArr = self.data("header");
	var headerArrLen = headerArr == undefined ? -1 : headerArr.length;
	var headerSection = apiHeaderRowElement[0];
	
	if(headerArrLen > 0)
		showApiHeaderSection(modal.querySelector('#addApiHeaderSection'));
	else 
		hideApiHeaderSection(modal, headerSection);

	for ( var indx = 0; indx < headerArrLen; indx++) {	
		apiHeaderRowElement = modal.getElementsByClassName("apiHeaderSection");
		apiHeaderRowElement[indx].querySelector('#apiHeaderKey').value = headerArr[indx].key;
		apiHeaderRowElement[indx].querySelector('#apiHeaderValue').value = headerArr[indx].value;
		
		if (apiHeaderRowElement.length < headerArrLen)
			modal.querySelector('#apiHeaderContainer').appendChild(headerSection.cloneNode(true));
	}
	
}