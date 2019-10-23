function getList(modelName, callback) {
	var jsonfilterparameter = {"limit":2147483647,"modelName":modelName,"page":0,"formType":modelName};
	var filterData = [];
	jsonfilterparameter["conditions"]= [];
	var jobValue = "";
	jsonfilterparameter["sortby"]= [];
	
	
	if(modelName == "EntityLink"){
		var filter = {};
		filter["contentJson.linkType"] = ["ScheduleEntityLink"];
		filterData.push(filter); 
		
	}else{
		var filter = {};
		
		filter["contentJson.Status"] = ["Active"];	
		filterData.push(filter); 
	}
	if(modelName == "Programme"){
		jsonfilterparameter["sortby"] = [{"direction":"asc","field":"ProgrammeTitle","contentJSON":"true"}];
		jobValue = document.getElementById(namespace + "left").value ;
	}
	if(modelName == "Schedule"){
		jsonfilterparameter["sortby"] = [{"direction":"asc","field":"Name","contentJSON":"true"}];	
	}
	if(modelName == "PriceScheme"){
		jsonfilterparameter["sortby"] = [{"direction":"asc","field":"PricingSchemeName","contentJSON":"true"}];
		jobValue = document.getElementById(namespace + "right").value ;
	}
	
	jsonfilterparameter["conditions"]=[jobValue];	
	jsonfilterparameter["filterdata"]=filterData;
	ajaxCall('GET','elastiSearchList', ajaxUrl, jsonfilterparameter, function() {
		var data = this.get("responseData");
		if (_.isEmpty(data)) {
			console.log("error");
			showLoading(false);
		} else {
			tableData = data.content;
			totalRecords = data.totalElements;
			totalPages = data.totalPages;
			callback(tableData);
		}
	}, function() {

	});
}

function removeElements(container, className){
    var elements = document.getElementById(container).getElementsByClassName(className);
    while(elements.length > 0){
        elements[0].parentNode.removeChild(elements[0]);
    }
}

function reloadListing(div, data, key, value, side) {
	for (var i = 0; i < data.length; i++) {
		var obj = {};
		obj.key = data[i].contentJson[key];
		obj.value = data[i].contentJson[value];

		leftSideList.push(obj);
		var clone = listElement.cloneNode(true);
		clone.style.display = "block";
		clone.getElementsByClassName("listCheckBox")[0].setAttribute(
				"onChange", "modifyList(this,'"+side+"');");
		clone.getElementsByClassName("listSpanTitle")[0].innerHTML =  "[" + obj.key + "] " + obj.value;
		clone.getElementsByClassName("listSpanCode")[0].innerHTML = obj.key;
		document.getElementsByClassName(div)[0].appendChild(clone);
	}
	showLoading(false);
}
function reset1() {
	checkNone(document.getElementById("checkNoneLeft"), "left");
	checkNone(document.getElementById("checkNoneRight"), "right");
	var x = document.getElementsByClassName("selectedItem");
	var i;
	for (i = 0; i < x.length; i++) {
	    x[i].innerHTML= "<ul></ul>";
	}
	document.getElementById("mappingform").reset();
	document.getElementById("save_btn").disabled = true;
}

AUI().use('event-base', function(A) {
	A.on('domready', function() {
		leftDropdownChanged();
		rightDropdownChanged();
		var data = document.getElementsByClassName('control-label');
		data[0].style.display = "none";
		data[1].style.display = "none";
	});
});

function populateProgrammes(data) {
	reloadListing("programmeDiv", data, "ProgrammeCode", "ProgrammeTitle", "left");
}
function populateSubjects(data) {
	reloadListing("programmeDiv", data, "SubjectCode", "SubjectTitle", "left");
}
function populateSchedules(data) {
	reloadListing("programmeDiv", data, "ScheduleCode", "Name", "left");
}
function populatePriceSchemes(data) {
	reloadListing("priceSchemeDiv", data, "PricingSchemeCode", "PricingSchemeName", "right");
}
var programmeScheduleSideList = [];
function populateProgAndSchedules(div, side) {
	if(progLoaded && schLoaded && linkingLoaded) {
		for (var i = 0; i < entityLinkList.length; i++) {
			var obj = {};
			if(entityLinkList[i].contentJson.ModelRight == "Programme"
					&& entityLinkList[i].contentJson.ModelLeft == "Schedule") {
				
				obj.key = entityLinkList[i].storageId;
				var ids = entityLinkList[i].storageId.split("|");
				var progTitle = getProgrammeString(ids[2]);
				var schTitle = getScheduleString(ids[0]);
				if(typeof progTitle === "undefined" || 
						typeof schTitle === "undefined") {
					continue;
				}
				obj.value = progTitle+" - "+schTitle;
				programmeScheduleSideList.push(obj);
				var clone = listElement.cloneNode(true);
				clone.style.display = "block";
				clone.getElementsByClassName("listCheckBox")[0].setAttribute(
						"onChange", "modifyList(this,'"+side+"');");
				clone.getElementsByClassName("listSpanTitle")[0].innerHTML = obj.value;
				clone.getElementsByClassName("listSpanCode")[0].innerHTML = obj.key;
				document.getElementsByClassName(div)[0].appendChild(clone);
			}
		}
	}
	showLoading(false);
}

function getProgrammeString(storageId) {
	for(var i=0;i<programmeList.length;i++) {
		
		if(programmeList[i].storageId == storageId) {
			return "["+storageId+"] "+programmeList[i].contentJson.ProgrammeTitle;
		}
	}
}

function getScheduleString(storageId) {
	for(var i=0;i<scheduleList.length;i++) {
		
		if(scheduleList[i].storageId == storageId) {
			return "["+scheduleList[i].contentJson.Name +"] "+ scheduleList[i].contentJson.ScheduleCode;
			//return getDateString(scheduleList[i].contentJson.StartDate) + " to " +
			//getDateString(scheduleList[i].contentJson.EndDate) + ":" + scheduleList[i].contentJson.ScheduleCode;
		}
	}
}

function getSchedule(storageId) {
	for(var i=0;i<scheduleList.length;i++) {
		
		if(scheduleList[i].storageId == storageId) {
			return scheduleList[i];
		}
	}
}

function getPriceScheme(storageId) {
	for(var i=0;i<priceSchemeList.length;i++) {
		if(priceSchemeList[i].storageId == storageId) {
			return priceSchemeList[i];
		}
	}
}

function getDateString(date) {
	var dateS = date.split("/");
	var dt = new Date(dateS[2], dateS[1] - 1, dateS[0]);
	return monthNames[dt.getMonth()]+" "+dt.getFullYear();
}

function leftDropdownChanged() {
	showLoading(true);
	removeElements("programmeDiv", "listElement");
	var left = document.getElementById("leftDropdown").value;
	checkNone(document.getElementById("programmeDiv"), "left");	
	checkNone(document.getElementById("priceSchemeDiv"), "right");	
	var leftEntity = document.getElementById(namespace+"left");
	if(left == "programme") {
		modelLeft = "Programme";
		modelLeft1 = "";
		modelRight = "PriceScheme";
		leftEntity.setAttribute("placeholder","Search for a title or code");
		fetchLeftLinkType = "ProgrammePriceSchemeEntityLink";
		getList("Programme", populateProgrammes);
		
	}else if(left == "subject") {
		modelLeft = "Subject";
		modelLeft1 = "";
		modelRight = "PriceScheme";
		leftEntity.setAttribute("placeholder","Search for a title or code");
		fetchLeftLinkType = "SubjectPriceSchemeEntityLink";
		getList("Subject", populateSubjects);
		
	} else if(left == "programme-schedule") {
		progLoaded = schLoaded = linkingLoaded = false;
		modelLeft = "Schedule";
		modelLeft1 = "Programme";
		modelRight = "PriceScheme";
		leftEntity.setAttribute("placeholder","Search for a Porogramme/Schedule title or code");
		getList("Programme", function(data) {
			progLoaded = true;
			programmeList = data;
			populateProgAndSchedules("programmeDiv", "left");
		});
		getList("Schedule", function(data) {
			schLoaded = true;
			scheduleList = data;
			populateProgAndSchedules("programmeDiv", "left");
		});
		getList("EntityLink", function(data) {
			linkingLoaded = true;
			entityLinkList = data;
			linkType = "ScheduleEntityLink";
			fetchLeftLinkType = "ProgrammeSchedulePriceSchemeEntityLink";
			populateProgAndSchedules("programmeDiv", "left");
		});
	} else if(left == "schedule") {
		modelLeft = "Schedule";
		modelLeft1 = "";
		modelRight = "PriceScheme";
		leftEntity.setAttribute("placeholder","Search for a title or code");
		fetchLeftLinkType = "SchedulePriceSchemeEntityLink";
		getList("Schedule", populateSchedules);
	}
	showNextBtn();
}
function leftDropdownChanged1(elem){
	
	var tt = document.getElementById("leftDropdown").value;
	if(tt == "programme-schedule"){
		var fd = document.getElementById("programmeDiv");
		var gf = fd.getElementsByClassName("listElement").length;
		for(var i = 0; i < gf ; i++){
			fd.removeChild(fd.children[1]);
		}
		
		
		for(var i = 0; i < programmeScheduleSideList.length; i++){
			if(programmeScheduleSideList[i].value.toLowerCase().includes(elem.value.toLowerCase())){
				var obj = programmeScheduleSideList[i];
				var clone = listElement.cloneNode(true);
				clone.style.display = "block";
				clone.getElementsByClassName("listCheckBox")[0].setAttribute("onChange", "modifyList(this,'left');");
				clone.getElementsByClassName("listSpanTitle")[0].innerHTML = obj.value;
				clone.getElementsByClassName("listSpanCode")[0].innerHTML = obj.key;
				document.getElementsByClassName("programmeDiv")[0].appendChild(clone);
			}
		}
	}else{
		leftDropdownChanged();
	}
	
	
}

function rightDropdownChanged() {
	removeElements("priceSchemeDiv", "listElement");
	var right = document.getElementById("rightDropdown").value;
	if(right == "price-scheme") {
		
		getList("PriceScheme", function(data){
			priceSchemeList = data;
			populatePriceSchemes(data);
		});
	}
	showNextBtn();
}


function showNextBtn() {
	if (selectedLeftModel.length > 0 && selectedRightModel.length > 0) {
		document.getElementById("save_btn").disabled = false;
	} else {
		document.getElementById("save_btn").disabled = true;
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
		} else {
			var elem1 = document.getElementsByClassName("priceSchemeDiv")[0];
			
			selectedRightModel.length = 0;
			for (var i = 0; i < allcheckbox.length; i++) {
				allcheckbox[i].checked = false;
			}
			drawFilter(elem1, side);
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
function getRightInfo(selectedLeftModel) {
	var elem = document.getElementsByClassName("priceSchemeDiv")[0];
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
			rrr = data;
			if (_.isEmpty(data)) {
				console.log("error");
			} else {
				var elem = document.getElementsByClassName("priceSchemeDiv")[0];
				entitySearch = findAncestor(elem, "entitySearch");
				allcheckboxkeys = entitySearch
						.getElementsByClassName("listSpanCode");
				allcheckboxvalues = entitySearch
						.getElementsByClassName("listSpanTitle");
				selectedRightModel.length = 0;
				for (var i = 0; i < allcheckboxvalues.length; i++) {
					allcheckbox[i].checked = false;
					if (rrr.list.includes(allcheckboxkeys[i].innerText)) {
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
				var routeCode = document.getElementById("RouteCode");
				var otherInfo = JSON.parse(data.otherInfo);
				routeCode.value = otherInfo.RouteCode;
				// showSuccessfulMsg();

			}
		}, function() {

		});

	}else{
		showOverwiteAlert();
		selectedRightModel.length = 0;
		for (var i = 0; i < allcheckboxvalues.length; i++) {
			allcheckbox[i].checked = false;
		}
		drawFilter(elem, "right");
	}

}

function showOverwiteAlert(){
	
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
           
           
            Y.one('.closeBtn').on(
            	      'click',
            	      function() {
            	        modal.hide();
            	      }
            	    );
        });

    });
	
	
}

function validateEntityLink() {
	var valid = true;
	//return valid;
	for (var i = 0; i < selectedLeftModel.length; i++) {
		for (var j = 0; j < selectedRightModel.length; j++) {
			var schedule = getSchedule(selectedLeftModel[i].key.split("|")[0]);
			var priceScheme = getPriceScheme(selectedRightModel[j].key);
			var schEndDate = "31/12/9999";
			var schStartDate = "31/12/0000";
			var psEndDate = "31/12/9999";
			var psStartDate = "31/12/0000";
			if(typeof schedule.contentJson.StartDate !== "undefined" &&
					schedule.contentJson.StartDate != "") {
				schStartDate = schedule.contentJson.StartDate;
			}
			if(typeof schedule.contentJson.EndDate !== "undefined" &&
					schedule.contentJson.EndDate != "") {
				schEndDate = schedule.contentJson.EndDate;
			}
			
			if(typeof priceScheme.contentJson.StartDate !== "undefined" &&
					priceScheme.contentJson.StartDate != "") {
				psStartDate = priceScheme.contentJson.StartDate;
			}
			if(typeof priceScheme.contentJson.EndDate !== "undefined" &&
					priceScheme.contentJson.EndDate != "") {
				psEndDate = priceScheme.contentJson.EndDate;
			}
			var schStartDtComps = schStartDate.split("/");
			var schStartDt = new Date(schStartDtComps[2], schStartDtComps[1] - 1, schStartDtComps[0]);
			var schEndDtComps = schEndDate.split("/");
			var schEndDt = new Date(schEndDtComps[2], schEndDtComps[1] - 1, schEndDtComps[0]);
			var psStartDtComps = psStartDate.split("/");
			var psStartDt = new Date(psStartDtComps[2], psStartDtComps[1] - 1, psStartDtComps[0]);
			var psEndDtComps = psEndDate.split("/");
			var psEndDt = new Date(psEndDtComps[2], psEndDtComps[1] - 1, psEndDtComps[0]);
			if(!(psStartDt >= schStartDt && psEndDt <= schEndDt)) {
				valid = false;
			}
		}
	}
	console.log("valid : "+valid);
	return valid;
}

function saveLink() {
	var routeCode = document.getElementById("RouteCode");
	var records = parseInt(selectedLeftModel.length)
			* parseInt(selectedRightModel.length);
	var left = document.getElementById("leftDropdown").value;
	var records = [];
	
	for(var i =0; i < selectedLeftModel.length; i++){
		for(var j =0; j < selectedRightModel.length; j++){

			var StorageIdRight="";
			var StorageIdRight1="";
			var StorageIdLeft="";
			var StorageIdLeft1="";
			
			if (selectedRightModel[j].key.includes('|')){
				StorageIdRight=selectedRightModel[j].key.split("|")[0];  
				StorageIdRight1=selectedRightModel[j].key.split("|")[2]; 
			}else{
				StorageIdRight=selectedRightModel[j].key;
			}
			
			if (selectedLeftModel[i].key.includes('|')){
				StorageIdLeft=selectedLeftModel[i].key.split("|")[0]; 
				StorageIdLeft1=selectedLeftModel[i].key.split("|")[2];  
			}else{
				StorageIdLeft=selectedLeftModel[i].key;
			}
			var record = {
					"StorageIdRight":StorageIdRight,
					"StorageIdRight1":StorageIdRight1,
					"StorageIdLeft":StorageIdLeft,
					"StorageIdLeft1":StorageIdLeft1,
			}
			records.push(record);
			
		}
	}
	
	
	if(left == "programme-schedule") {
		
		if(!validateEntityLink()) {
			console.log("error...");
			showErrorMsg();
			return;
		}
	}
	
	
	var data = {
			"linkType":fetchLeftLinkType,
			"formType":formType,
			"ModelRight":modelRight,
			"ModelLeft":modelLeft,
			"ModelLeft1":modelLeft1,
			"ModelRight1":"",
			"records":records,
			"RouteCode" : routeCode.value
			};
	ajaxCall('GET','persist',ajaxUrl,data,
		function() {
	        var data = this.get("responseData");
	        if (_.isEmpty(data)) {
	            console.log("error");
	        } else {
	        	showSuccessfulMsg();
	        }
	    },
	    function() {
	    	 console.log("error");
		}
	 );
	
}

function showErrorMsg(){
	
	AUI().use('aui-base', function(A) {
		var boundingBox = "#error-popup";
    	var contentBox = "#error-popup-box";
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
                           draggable: true,
            }).render();
            Y.one('.close').on(
            	      'click',
            	      function() {
            	    	  
            	        modal.hide();
            	      }
            	    );
        });

    });
}

function removeThis(elem, side) {
	var value = elem.parentElement.getElementsByTagName("a")[0].innerHTML;
	if (side == "left") {
		for (var i = 0; i < selectedLeftModel.length; i++) {
			if (selectedLeftModel[i] == value) {
				selectedLeftModel.splice(i, 1);
			}
		}
	} else {
		for (var i = 0; i < selectedRightModel.length; i++) {
			if (selectedRightModel[i] == value) {
				selectedRightModel.splice(i, 1);
			}
		}
	}
	drawFilter(elem, side);
}
function showLoading(show) {
	if(show) {
		document.getElementById("loadingDiv").style.display = "block";
	} else {
		document.getElementById("loadingDiv").style.display = "none";
	}
}
function showDashboard() {
	window.location.href = dashBoardLink;
}