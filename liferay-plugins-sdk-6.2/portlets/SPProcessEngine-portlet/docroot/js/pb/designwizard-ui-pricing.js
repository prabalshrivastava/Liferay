function processPricingModal(self, ajaxUrls){//self is JQuery Obj
	var popupContainerId = 'pricing_model_popup';
	var popupSkeletonId = 'pricing_model_popup_skelton';
	var out = "", schemeOptions = dropDownOptionsJSONArr.priceSchemes, subSchemeOptions;
	
	var populateSubSchemes = function(subSchemeOptions) {
		var subSchemeDropDown = modal.querySelector('#subScheme');
		out = "";
		subSchemeDropDown.innerHTML = out;

		if (!subSchemeOptions) {
			return;
		}

		for (var indx = 0; indx < subSchemeOptions.length; indx++) {
			var val = subSchemeOptions[indx].priceSubSchemeCode;
			var label = subSchemeOptions[indx].priceSubSchemeName;
			out += '<option value="' + val+ '"' 
		    + (self.data("subScheme") && self.data("subScheme").indexOf(val) != -1? " selected" : "")
			    + ">" + label + '</option>';
		}
		subSchemeDropDown.innerHTML = out;

//		if(self.data("subScheme")) {
//			setSelectedIndex(modal.querySelector('#subScheme'), self.data("subScheme"));		
//		}

	}
	
	var modal = document.getElementById(popupContainerId);
	var modalSkeleton = document.getElementById(popupSkeletonId);
	if(modalSkeleton)
		modalSkeleton.parentNode.removeChild(modalSkeleton);
		
	modal.getElementsByClassName('modal-content')[0].insertBefore(modalSkeleton.cloneNode(true), modal.getElementsByClassName('modal-submit')[0]);
	
	modal.classList.remove("modal-hidden");
	modal.classList.add("modal-visible");
	modal.querySelector('#'+popupSkeletonId).classList.remove("modal-hidden");
	modal.querySelector('#'+popupSkeletonId).classList.add("modal-visible");
	modal.querySelector('#allowReprocess').checked = self.data("allowReprocess")||"";
	
	var schemeDropDown = modal.querySelector('#scheme');	
	out="<option></option>";
	for (var indx = 0; indx < schemeOptions.length; indx++) {
		var val = schemeOptions[indx].priceSchemeCode;
		var label = schemeOptions[indx].priceSchemeName;
		out += '<option value="' + val+ '"' 
		    + ( val == self.data("scheme") ? " selected" : "")
		    + ">" + label + '</option>';
	}
	schemeDropDown.innerHTML = out;
	
	modal.querySelector('#scheme').onchange = function(){		
		var data = {};
		data[dwNameSpace + "action"] = "getPriceSubSchemes";
		data[dwNameSpace + "priceSchemeCode"] = modal.querySelector('#scheme').value;
		AUI().io.request(ajaxUrls[0],{
			dataType: 'json',
			method: 'POST',
			sync : true,
			data: data,
			on: {
				success: function() {
					var data=this.get('responseData');
					populateSubSchemes(data);
				  },
				error :function() {
				  }
		   }
		});	
		
	};
	
	if(self.data("name"))//If pop-up was already saved.
		modal.querySelector('#customNameTxtField').value = self.data("name");
	
	if(self.data("outstanding")) {
		modal.querySelector('#outstanding').checked = self.data("outstanding");		
	}

	if(self.data("consolidate")) {
		modal.querySelector('#consolidate').checked = self.data("consolidate");		
	}
	
	var selectedScheme = modal.querySelector("#scheme option[value='"+ self.data("scheme") +"']");
	if (selectedScheme) {
		selectedScheme.setAttribute('selected','');
		simulateEvent(modal.querySelector('#scheme'), "change");
	}

	var btnSave = modal.querySelector('#btnModelSave');
	btnSave.onclick = function() {
		self.data("allowReprocess", modal.querySelector('#allowReprocess').checked);
		self.data("name", modal.querySelector('#customNameTxtField').value);
		self.data("scheme", modal.querySelector('#scheme').value);
		self.data("subScheme", $(modal.querySelector('#subScheme')).val());
		self.data("outstanding", modal.querySelector('#outstanding').checked);
		self.data("consolidate", modal.querySelector('#consolidate').checked);
		
		modal.style.display = "none";
		
		//sets node text
		var currDivX = self.position().left - canvasPosition.left + self.outerWidth() + sLeft;
		var currDivY = self.position().top - canvasPosition.top + self.outerHeight() / 2 + sTop;
		
		var nodeText = "Pricing Scheme";
		
		//set tooltip text
		if(nodeText==="")
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


