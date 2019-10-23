var dd;
var dlink = [];

function removeThis(elem, side) {
	dd = elem;

	var value = dd.getElementsByTagName("span")[0].innerText;
	if (side == "left") {
		for (var i = 0; i < selectedLeftModel.length; i++) {
			if (selectedLeftModel[i].value.replace(/ /g,'') == value.replace(/ /g,'')) {
				selectedLeftModel.splice(i, 1);
			}
		}
	} else {
		for (var i = 0; i < selectedRightModel.length; i++) {
			if (selectedRightModel[i].key.replace(/ /g,'') == value.replace(/ /g,'')) {
				selectedRightModel.splice(i, 1);
			}
		}
	}
	drawFilter(elem, side);
	drawCheckBox(elem, side);
}
var ede;
function drawCheckBox(elem, side) {
	ede = elem;
	if (side == "left") {
		entitySearch = document.getElementsByClassName("entitySearch")[0];
	} else {
		entitySearch = document.getElementsByClassName("entitySearch")[1];
	}
	var allcheckbox = entitySearch.getElementsByClassName("listCheckBox");
	var allcheckboxkeys = entitySearch.getElementsByClassName("listSpanCode");
	if(selectedLeftModel.length == 0){
		selectedRightModel.length = 0;
	}
	
	var checkArray = [];
	if (side == "left") {
		checkArray = selectedLeftModel;
	} else {
		checkArray = selectedRightModel;
	}
	for (var i = 0; i < allcheckbox.length; i++) {
		allcheckbox[i].checked = false;
		for (var j = 0; j < checkArray.length; j++) {
			if (allcheckboxkeys[i].innerText == checkArray[j].key) {
				allcheckbox[i].checked = true;
			}

		}
	}

}

function checkmodifyList(elem, side) {
	elem1 = elem;
	var obj = {};
	var value = elem.parentElement.getElementsByClassName("listSpanTitle")[0].innerHTML;
	var key = elem.parentElement.getElementsByClassName("listSpanCode")[0].innerHTML;
	entitySearch = findAncestor(elem, "entitySearch");
	obj.key = key;
	obj.value = value;
	var deselectvalue = key;
	var p= "";
	for(var i=0;i<dlink.length;i++) {		
		if(dlink[i] == deselectvalue){
			 p=elem.parentElement.getElementsByClassName("listCheckBox")[0];
			 if(!p.checked)
			 DelinkAlertMsg(elem, side,p);
		}
	}
	if( p == ""){
		modifyList(elem, side);
	}
	
}

function modifyList(elem, side) {
	elem1 = elem;
	var obj = {};
	var value = elem.parentElement.getElementsByClassName("listSpanTitle")[0].innerHTML;
	var key = elem.parentElement.getElementsByClassName("listSpanCode")[0].innerHTML;
	entitySearch = findAncestor(elem, "entitySearch");
	obj.key = key;
	obj.value = value;
	var deselectvalue = key;
	
	allcheckbox = entitySearch.getElementsByClassName("listCheckBox");
	if (side == "left") {
		if (elem1.checked == true) {
			selectedLeftModel.push(obj);
		} else {
			for (var i = 0; i < selectedLeftModel.length; i++) {
				if (selectedLeftModel[i].value == value) {
					selectedLeftModel.splice(i, 1);
				}
			}
		}
		if(allcheckbox.length == selectedLeftModel.length){
			entitySearch.getElementsByClassName("checkAll")[0].checked = true;
		}
		else{
			entitySearch.getElementsByClassName("checkAll")[0].checked = false;
		}
		if (selectedLeftModel.length > 0) {
			getRightInfo(selectedLeftModel);
			document.getElementById("next_btn").disabled = false;
		} else {
			document.getElementById("next_btn").disabled = true;
			var elem1 = document.getElementsByClassName("subjectDiv")[0];
			
			selectedRightModel.length = 0;
			for (var i = 0; i < allcheckbox.length; i++) {
				allcheckbox[i].checked = false;
			}
			drawFilter(elem1, side);
			drawCheckBox(elem, "right");
			
		}
		drawFilter(elem, side);

	} else {
		if (elem1.checked == true) {
			selectedRightModel.push(obj);
		} else {
			for (var i = 0; i < selectedRightModel.length; i++) {
				if (selectedRightModel[i].value == value) {
					selectedRightModel.splice(i, 1);
				}
			}
		}
		if(allcheckbox.length == selectedRightModel.length){
			entitySearch.getElementsByClassName("checkAll")[0].checked = true;
		}
		else{
			entitySearch.getElementsByClassName("checkAll")[0].checked = false;
		}
		console.log(selectedRightModel);
		showNextBtn();
	}
	
	drawFilter(elem, side);
	

}
function checkAll(elem, side) {
	entitySearch = findAncestor(elem, "entitySearch");
	var allcheckboxkeys = entitySearch.getElementsByClassName("listSpanCode");
	var allcheckboxvalues = entitySearch
			.getElementsByClassName("listSpanTitle");
	var allcheckbox = entitySearch.getElementsByClassName("listCheckBox");
	if (side == "left") {
		selectedLeftModel = [];
		entitySearch.getElementsByClassName("checkNone")[0].checked = false;
		for (var i = 0; i < allcheckboxvalues.length; i++) {
			var obj = {};
			var value = allcheckboxvalues[i].innerHTML;
			var key = allcheckboxkeys[i].innerHTML;
			allcheckbox[i].checked = true;
			obj.key = key;
			obj.value = value;
			selectedLeftModel.push(obj);
		}
	} else {
		selectedRightModel = [];
		entitySearch.getElementsByClassName("checkNone")[0].checked = false;
		for (var i = 0; i < allcheckboxvalues.length; i++) {
			var obj = {};
			var value = allcheckboxvalues[i].innerHTML;
			var key = allcheckboxkeys[i].innerHTML;
			allcheckbox[i].checked = true;
			obj.key = key;
			obj.value = value;
			selectedRightModel.push(obj);
		}
		showNextBtn();
	}
	drawFilter(elem, side);
}
function checkNone(elem, side) {
	entitySearch = findAncestor(elem, "entitySearch");
	var allcheckbox = entitySearch.getElementsByClassName("listCheckBox");
	entitySearch.getElementsByClassName("checkAll")[0].checked = false;
	if (side == "left") {
		selectedLeftModel = [];
		for (var i = 0; i < allcheckbox.length; ++i) {
			allcheckbox[i].checked = false;
		}
	} else {
		selectedRightModel = [];
		for (var i = 0; i < allcheckbox.length; ++i) {
			allcheckbox[i].checked = false;
		}
	}
	drawFilter(elem, side);
}
function drawFilter(elem, side) {

	entitySearch = findAncestor(elem, "entitySearch");
	selectedItem = entitySearch.getElementsByClassName("selectedItem")[0];
	selectedItem.getElementsByTagName("ul")[0].innerHTML = '';
	if (side == "left") {
		for (var i = 0; i < selectedLeftModel.length; i++) {
			var clone = liAnchorElement.cloneNode(true);
			clone.style.display = "inline-block";
			clone.setAttribute("onclick", "removeThis(this,'left');");
			clone.getElementsByTagName("a")[0].innerHTML = selectedLeftModel[i].value;
			clone.getElementsByTagName("span")[0].innerHTML = selectedLeftModel[i].key;
			// clone.getElementsByTagName("a")[0].setAttribute("onClick","removeThis(this,'left');");
			selectedItem.getElementsByTagName("ul")[0].appendChild(clone);
		}
	} else {
		for (var i = 0; i < selectedRightModel.length; i++) {
			var clone = liAnchorElement.cloneNode(true);
			clone.style.display = "inline-block";
			clone.setAttribute("onclick", "removeThis(this,'right');");
			clone.getElementsByTagName("a")[0].innerHTML = selectedRightModel[i].value;
			clone.getElementsByTagName("span")[0].innerHTML = selectedRightModel[i].key;
			// clone.getElementsByTagName("a")[0].setAttribute("onClick","removeThis(this,'right');");
			selectedItem.getElementsByTagName("ul")[0].appendChild(clone);
		}
	}
}
var rrr = [];
var allcheckboxkeys;
var allcheckboxvalues;
var allcheckbox;
function getRightInfo(selectedLeftModel) {
	var elem = document.getElementsByClassName("subjectDiv")[0];
	entitySearch = findAncestor(elem, "entitySearch");
	allcheckbox = entitySearch.getElementsByClassName("listCheckBox");
	allcheckboxvalues = entitySearch.getElementsByClassName("listSpanTitle");
	selectedRightModel.length = 0;
	for (var i = 0; i < allcheckbox.length; i++) {
		allcheckbox[i].checked = false;
	}
	if (selectedLeftModel.length == 1) {
		
		drawFilter(elem, "right");

		var StorageIdLeft = "";
		if (selectedLeftModel[0].key.includes(' -- ')) {
			StorageIdLeft = selectedLeftModel[0].key.substr(0,selectedLeftModel[0].key.indexOf(' -- '));
		} else {
			StorageIdLeft = selectedLeftModel[0].key;
		}

		var data = {
			"formType" : formType,
			"ModelRight" : modelRight,
			"ModelLeft" : modelLeft,
			"linkType":fetchLeftLinkType,
			"formStorageId" : encodeURIComponent(StorageIdLeft)
		};
		ajaxCallAPI('GET', 'fetchEntity', data, function() {
			var data = this.get("responseData");
			dlink = data.list;
			rrr = data.list;
			
			
			if (_.isEmpty(data)) {
				console.log("error");
			} else {
				var elem = document.getElementsByClassName("subjectDiv")[0];
				entitySearch = findAncestor(elem, "entitySearch");
				allcheckboxkeys = entitySearch
						.getElementsByClassName("listSpanCode");
				allcheckboxvalues = entitySearch
						.getElementsByClassName("listSpanTitle");
				selectedRightModel.length = 0;
				for (var i = 0; i < allcheckboxvalues.length; i++) {
					allcheckbox[i].checked = false;
					if (rrr.includes(allcheckboxkeys[i].innerText)) {
						var obj = {};
						var value = allcheckboxvalues[i].innerHTML;
						var key = allcheckboxkeys[i].innerHTML;
						allcheckbox[i].checked = true;
						obj.key = key;
						obj.value = value;
						selectedRightModel.push(obj);
					}
				}
				drawFilter(elem, "right");
				// showSuccessfulMsg();

				if(fetchLeftLinkType == "ProgrammeEntityLink"){
					var others = JSON.parse(data.otherInfo);
					document.querySelector('#inp_subject_sub_type [value="' + others.SubjectSubType + '"]').selected = true;
					document.querySelector('#inp_waivefee [value="' + others.WaiveFee + '"]').selected = true;
					
				}
				var routeCode = document.getElementById("RouteCode");
				if(data.otherInfo){
					var otherInfo =  JSON.parse( data.otherInfo);
					
					if(routeCode != null){
						routeCode.value = otherInfo.RouteCode;
					}
				}
				
			}
		}, function() {

		});

	}else{
		
		selectedRightModel.length = 0;
		for (var i = 0; i < allcheckboxvalues.length; i++) {
			allcheckbox[i].checked = false;
		}
		drawFilter(elem, "right");
	}

}
var btNO
function DelinkAlertMsg(elem, side,e){
	btNO=e;
	AUI().use('aui-base', function(A) {
		var boundingBox = "#deactivation-success";
    	var contentBox = "#inactive-success-box";
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
           
            Y.one('.closeBtn').on(
            	      'click',
            	      function() {
            	        modal.hide();
            	        if(btNO!=null){
            	        	deLink(btNO.parentElement.getElementsByClassName("listSpanCode")[0].innerText)
              	    		btNO=null;
              	    	 }
            	      }
            	    );
            Y.one('.noButton').on(
          	      'click',
          	      function() { 
          	    	  modal.hide();
          	    	  if(btNO!=null){
          	    		btNO.checked=true;
          	    		btNO=null;
          	    	  }
          	    	
          	      }
          	    );
        });
    });
}


function deLink(StorageIdRightValue){
	var records = [];
	
	for(var i =0; i < selectedLeftModel.length; i++){
		var StorageIdRight="";
		var StorageIdRight1="";
		var StorageIdLeft="";
		var StorageIdLeft1="";
		
		if (selectedLeftModel[i].key.includes(' -- ')){
			StorageIdLeft=selectedLeftModel[i].key.substr(0, selectedLeftModel[i].key.indexOf(' -- ')); 
			StorageIdLeft1=selectedLeftModel[i].key.substr(selectedLeftModel[i].key.indexOf(' -- ')+4, selectedLeftModel[i].key.length); 
		}else{
			StorageIdLeft=selectedLeftModel[i].key;
		}
		if (StorageIdRightValue.includes(' -- ')){
			StorageIdRight=StorageIdRightValue.substr(0, StorageIdRightValue.indexOf(' -- ')); 
			StorageIdRight1=StorageIdRightValue.substr(StorageIdRightValue.indexOf(' -- ')+4, StorageIdRightValue.length); 
		}else{
			StorageIdRight=StorageIdRightValue;
		}
		var record = {
				"StorageIdRight":StorageIdRight,
				"StorageIdRight1":StorageIdRight1,
				"StorageIdLeft":StorageIdLeft,
				"StorageIdLeft1":StorageIdLeft1,
		}
		records.push(record);
		
		
	}
	var data = {
			"linkType":"ProgrammeEntityLink",
			"formType":"EntityLink",
			"ModelRight":modelRight,
			"ModelLeft":modelLeft,
			"ModelLeft1":"",
			"ModelRight1":"",
			"records":records,
			"endPoint":"delink"
			
			};
	ajaxCall('GET','sendRequest',ajaxUrl,data,
	function() {
        var data = this.get("responseData");
        if (_.isEmpty(data)) {
            console.log("error");
        } else {
        	var popup_msg = document.getElementById("popup-msg");
        	popup_msg.innerText = "Delinked ";
        	showSuccessfulMsg();
        }
    },
    function() {
    	 console.log("error");
		});
	
}



function showOverwiteAlert(elem, side){
	if(selectedLeftModel.length > 0 && elem.checked == true){
		AUI().use('aui-base', function(A) {
			var boundingBox = "#overwrite-popup";
	    	var contentBox = "#overwrite-popup-box";
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
	           
	           
	            Y.all('.closeBtn').on(
	            	      'click',
	            	      function() {
	            	        modal.hide();
	            	        modifyList(elem, side)
	            	      }
	            	    );
	            Y.all('.cancelBtn').on(
	          	      'click',
	          	      function() {
	          	        modal.hide();
	          	        elem.checked = false;
	          	      }
	          	    );
	        });

	    });
	}else{
		 modifyList(elem, side)
	}
	
}