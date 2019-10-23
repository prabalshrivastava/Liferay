function processEntityModal(self, ajaxUrls){//self is JQuery Obj
	var popupContainerId = 'entity_model_popup';
	var popupSkeletonId = 'entity_model_popup_skelton';
	var out = "";
	
	var populateClassPks = function(entities) {
		var entityIdDropDown = modal.querySelector('#identifier');
		entityIdDropDown.innerHTML="";
		if (!entities) {
			return;
		}
		
		out = "";
		for (var indx = 0; indx < entities.length; indx++) {
			var val = entities[indx].id;
			var label = entities[indx].name;
			out += '<option value="' + val+ '"' 
			    + ( val == self.data("identifier") ? " selected" : "")
			    + ">" + label + '</option>';
		}
		entityIdDropDown.innerHTML = out;		
	}
	
	var modal = document.getElementById(popupContainerId);
	var modalSkeleton = document.getElementById(popupSkeletonId);
	if(modalSkeleton)
		modalSkeleton.parentNode.removeChild(modalSkeleton);
		
	modal.getElementsByClassName('modal-content')[0].insertBefore(modalSkeleton.cloneNode(true), modal.getElementsByClassName('modal-submit')[0]);
	
	modal.classList.remove("modal-hidden");
	modal.classList.add("modal-visible");
	var modalPopup = modal.querySelector('#'+popupSkeletonId);
	modalPopup.classList.remove("modal-hidden");
	modalPopup.classList.add("modal-visible");
	
	modal.querySelector('#allowReprocess').checked = self.data("allowReprocess")||"";
	
	modal.querySelector('#entityClassTypeId').onchange = function(){
		var data = {};
		data[dwNameSpace + "action"] = "getPKs";
		data[dwNameSpace + "entityClassId"] = modal.querySelector('#entityClassTypeId').value;
		AUI().io.request(ajaxUrls[0],{
			dataType: 'json',
			method: 'POST',
			sync : true,
			data: data,
			on: {
				success: function() {
					var data=this.get('responseData');
					if (data.error) {
						console.log(data.error);
						populateClassPks(null);
					}else {
						populateClassPks(data.entities);
					}
				  },
				error :function() {
				  }
		   }
		});	
	};

	var selectedType = modal.querySelector("#entityClassTypeId option[value='"+ self.data("type") +"']");
	if (selectedType) {
		selectedType.setAttribute('selected','');
		simulateEvent(modal.querySelector('#entityClassTypeId'), "change");
	}

	var btnSave = modal.querySelector('#btnModelSave');
	btnSave.onclick = function() {
		self.data("allowReprocess", modal.querySelector('#allowReprocess').checked);
		self.data("type", modal.querySelector('#entityClassTypeId').value);
		self.data("identifier", modal.querySelector('#identifier').value);
		
		modal.style.display = "none";
		
		//sets node text
		var currDivX = self.position().left - canvasPosition.left + self.outerWidth() + sLeft;
		var currDivY = self.position().top - canvasPosition.top + self.outerHeight() / 2 + sTop;
		
		var nodeText = "Assign Entity";

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

