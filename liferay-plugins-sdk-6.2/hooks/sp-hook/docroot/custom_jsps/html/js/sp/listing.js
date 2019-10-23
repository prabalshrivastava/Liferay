var columnTitles = {};
var freeTextArray = [];
var filterdata=[{"contentJson.Status":["Active"]}];
if(typeof modelName != "undefined" && typeof modelName == "string" && 
		(modelName.toLowerCase() == "transactionmaster" || 
		 modelName.toLowerCase() == "resultmaster" || 
		 modelName.toLowerCase() == "submittedclaim")){
	filterdata = [];
}

//var filterdata = [];
var sortbyArray = [];
var sortBy = {};
var eee ;
var searchBox;
function makePaging(totalPages, pageIndex) {
	var oPaging, i, j, k;
	var totalPages = parseInt(totalPages);
	pageIndex++;
	i = pageIndex;
	j = pageIndex - 1;
	k = pageIndex + 1;
	var oBefore = "", oAfter= "";
	var disable = false;
	if(i<=1) {
		disable = true;
	}
	while (j != 0 && j != i - 6 && j>0) {
		oBefore = "<li id1='"+ j +"'><a  href='javascript:showPage("+ j +")' data-index='" + (j - 1) + "'>" + j + "</a></li>" + oBefore;
		j--;
	}
	if(disable) {
		oBefore = "<li id2='"+ (i-1) +"'><a class='prev' href='javascript:void(0)' data-index='" + (i-2) + "'>  </a></li>" + oBefore;
		oBefore = "<li id3='1'><a class='first' href='javascript:void(0)' data-index='1'>  </a></li>" + oBefore;
	} else {
		oBefore = "<li id4='"+ (i-1) +"'><a class='prev' href='javascript:showPage("+ (i-1) +")' data-index='" + (i-2) + "'>  </a></li>" + oBefore;
		oBefore = "<li id5='1'><a class='first' href='javascript:showPage(1)' data-index='1'>  </a></li>" + oBefore;
	}
	for (; k <= totalPages && k < (i + 6) && k > 0; k++) {
		oAfter += "<li id6='"+ k +"'><a  href='javascript:showPage("+ k +")' data-index='" + (k - 1) + "'>" + k + "</a></li>";
	}
	disable = false;
	if(i>=totalPages) {
		disable = true;
	}
	if(disable) {
		oAfter += "<li id2='"+ (i+1) +"'><a class='next' href='javascript:void(0)' data-index='" + (i) + "'>  </a></li>";
		oAfter += "<li id2='"+ (k-1) +"'><a class='last' href='javascript:void(0)' data-index='" + (k-2) + "'>  </a></li>";
	} else {
		oAfter += "<li id2='"+ (i+1) +"'><a class='next' href='javascript:showPage("+ (i+1) +")' data-index='" + (i) + "'>  </a></li>";
		oAfter += "<li id2='"+ (totalPages-1) +"'><a class='last' href='javascript:showPage("+ totalPages +")' data-index='" + (totalPages-2) + "'>  </a></li>";
	}

	oPaging = "<ul  class='pagination-content'>" + oBefore + "<li id3='"+ i +"'><a class='selected' href='javascript:showPage("+ i +")'>" + 
	i.toString() + "</a></li>" + oAfter + "</ul>";
	document.getElementById("jslarge").innerHTML = oPaging;
}
function pagination(c, m) {
    var current = c,
        last = m,
        delta = 2,
        left = current - delta,
        right = current + delta + 1,
        range = [],
        rangeWithDots = [],
        l;

    for (var i = 1; i <= last; i++) {
        if (i == 1 || i == last || i >= left && i < right) {
            range.push(i);
        }
    }

    for (var i of range) {
        if (l) {
            if (i - l === 2) {
                rangeWithDots.push(l + 1);
            } else if (i - l !== 1) {
                rangeWithDots.push('...');
            }
        }
        rangeWithDots.push(i);
        l = i;
    }
    return rangeWithDots;
}

function drawPagination(pageRequested){
	document.getElementById("jslarge").innerHTML = "";
	pageRequested = 0;
	makePaging(totalPages,pageRequested);
	pagination(pageRequested, totalPages);
}
function showPage(page){
	pageRequested = page;
	jsFilterColumnList();
}

function ajaxCall(method, action,ajaxUrl, data, successHandler, failHandler) {
	var thisInstance = this;

	thisInstance.namespace = namespace;
	AUI().use('aui-base','aui-io-request-deprecated',function(A){
		var _data = {};
		_data[thisInstance.namespace + 'formStorageId'] = "";
		if(action == "update" || action == "loadData" || action == "loadList" || action == "archive" || action=="exportRow"){
			_data[thisInstance.namespace + 'formStorageId'] =  data.formStorageId;
		}
		_data[thisInstance.namespace + 'formType'] = data.formType;
		_data[thisInstance.namespace + 'action'] = action;
		if(action == "update")
			_data[thisInstance.namespace + 'action'] = "persist";
		if (data) {
			_data[thisInstance.namespace + 'data'] = JSON.stringify(data);              
		}
		A.io.request(ajaxUrl,{
			dataType : 'json', method : method,
			data : _data,
			on : {
				success : successHandler,
				failure : failHandler || function() {
					thisInstance.debug("Error in the ajax call.");
				}
			}
		});             
	});
}
function getFormFields(){
if(modelName == "" || modelName == undefined){
		console.log("modelName Missing");
	}else{
		searchBox = document.getElementById(namespace +"searchtextbox");
		ajaxCall('GET','loadData',ajaxurl,{"formType":"configuration","formStorageId":modelName},
				function() {
			var data = this.get("responseData");
			if (_.isEmpty(data)) {
				console.log("error");
			} else {
				if(modelName=="Invigilator" || modelName=="submittedClaim") {
					var jsonfilterparameter = {"modelName":modelName,"formType":modelName};
					ajaxCall('GET','filterColumnList',filtercolumnlisturl,jsonfilterparameter,
							function() {
			            var titleData = this.get("responseData");
						if (_.isEmpty(titleData)) {
							console.log("error");
						} else {
							columnTitles = titleData.titles;
							populateSearchFields(data);  
						}
					},
					function() {
						console.log("No such microservicemodel name"+modelName);
					}); 
				} else {
					populateSearchFields(data);  
				}
			}
		},
		function() {

		});
	}

}
function getFilterFields(){
	if(modelName == "" || modelName == undefined){
		console.log("modelName Missing");
	}else{
		var jsonfilterparameter = {"modelName":modelName,"formType":modelName};
		ajaxCall('GET','filterColumnList',filtercolumnlisturl,jsonfilterparameter,
				function() {
            var data = this.get("responseData");
            if (_.isEmpty(data)) {
				console.log("error");
				jsFilterColumnList();
			} else {
				if(!data.distinct.hasOwnProperty('contentJson')){
					var c={}
					c.Status=["Active","Inactive","Draft"];
					data.distinct.contentJson=c;
				}
				data.distinct.contentJson.Status=["Active","Inactive","Draft"];
				renameFilterFields(data);
				
			}
		},
		function() {
			console.log("No such microservicemodel name"+modelName);
			jsFilterColumnList();
		});
	}
	return null;
}
function isnull(dataJSON){
	if(dataJSON == "null" || dataJSON == null  || dataJSON == ""){
		return true;
	}else{
		return false;
	}
}
var auditFields = "createdBy,createdDate,lastModifiedBy,lastModifiedDate";
function populateSearchFields(data){
    availableColumns = [],columnsToShow=[];
	masterColumns = [];
	var obj = {};
	if(modelName.toLowerCase() == "mastertimetable"){
		auditFields="";
		var allcolumns = data.contentJson.columnlist;
	}else{
		var allcolumns = data.contentJson.columnlist + "," + auditFields ;
	}
	masterColumns = allcolumns.split(',');
	if(data.storageId != "null") columnsToShow.push("storageId");
	if(!isnull(data.contentJson.column1)) columnsToShow.push(data.contentJson.column1);
	if(!isnull(data.contentJson.column2)) columnsToShow.push(data.contentJson.column2);
	if(!isnull(data.contentJson.column3)) columnsToShow.push(data.contentJson.column3);
	if(!isnull(data.contentJson.column4)) columnsToShow.push(data.contentJson.column4);
	if(!isnull(data.contentJson.column5)) columnsToShow.push(data.contentJson.column5);
	if(!isnull(data.contentJson.column6)) columnsToShow.push(data.contentJson.column6);
	if(!isnull(data.contentJson.column7)) columnsToShow.push(data.contentJson.column7);
	if(data.contentJson.columnlist != "null") columnlist = data.contentJson.columnlist;;
	columnsToShow.push("");
	[].forEach.call(  document.querySelectorAll('.form-fields-select :checked')  , function(elm){
		if(elm.value !=  0){
			exForm[elm.value] = elm.value;
		}
	})
	Object.keys(masterColumns).forEach(function(entry,key) {
		if(!exForm.hasOwnProperty(key)){
			availableColumns.push(masterColumns[key]);
		}
	});
	var selectBoxNumber = 0,selectValue,selectText;
	[].forEach.call(  document.querySelectorAll('.form-fields-select')  , function(elm){

		if(elm.options[elm.selectedIndex] != undefined){
			var currkey = elm.options[elm.selectedIndex].text;
			var currvalue = elm.value;
			for(var j = elm.options.length; j >= 0 ;j--){
				elm.remove(j);
			}
		}

		selectText = "Select";
		selectValue = "";

		var o = document.createElement("option");
		o.value = selectValue;
		o.text = selectText;
		elm.appendChild(o);

		var o = document.createElement("option");
		for (var key in data.contentJson) {
			  if (data.contentJson[key] == "IsAttendance") {
				  data.contentJson[key] = "Attended?";
			  }
			  if (data.contentJson[key] == "Nric" || data.contentJson[key] == " N R I C") {
				  data.contentJson[key] = "NRIC";
			  }
			}
		if(selectBoxNumber == 0) {selectValue = data.contentJson.column1; }
		else if(selectBoxNumber == 1 && data.contentJson.column2 !=null) {selectValue = data.contentJson.column2;}
		else if(selectBoxNumber == 2 && data.contentJson.column3 !=null) {selectValue = data.contentJson.column3;}
		else if(selectBoxNumber == 3 && data.contentJson.column4 !=null) {selectValue = data.contentJson.column4;}
		else if(selectBoxNumber == 4 && data.contentJson.column5 !=null) {selectValue = data.contentJson.column5;}
		else if(selectBoxNumber == 5 && data.contentJson.column6 !=null) {selectValue = data.contentJson.column6;}
		else if(selectBoxNumber == 6 && data.contentJson.column7 !=null) {selectValue = data.contentJson.column7;}
		selectBoxNumber++;
		o.value = selectValue;

		if(isnull(selectValue)){ 
			selectText = "Select";
		}else{
			selectText = capitalizeFirstLetter(selectValue.replace(/([A-Z])/g, " $1"));
			if(selectText == " N R I C" || selectText== "Nric"){
				selectText="NRIC";
			}
		}

		o.text = selectText;
		o.selected ='selected';
		elm.appendChild(o);

		for (var i = 0; i < availableColumns.length; i++) {
			if(availableColumns[i] == "IsAttendance"){
				availableColumns[i] = "Attended?";
			}
			var o = document.createElement("option");
			o.value = availableColumns[i];
			o.text = capitalizeFirstLetter(availableColumns[i]).replace(/([A-Z])/g, " $1");
			if(availableColumns[i].toLowerCase() == "nric" || availableColumns[i].toLowerCase() == " n r i c"){
				o.text = "NRIC";
			}
			elm.appendChild(o);
		}
	})
	getFilterFields();

}

function capitalizeFirstLetter(string) {
	return string.charAt(0).toUpperCase() + string.slice(1);
}
var filterStoreData={};
filterStoreData["contentJson.Status"] = ["Active"];

if(typeof modelName != "undefined" && typeof modelName == "string" && (modelName.toLowerCase() == "transactionmaster" || 
		modelName.toLowerCase() == "resultmaster" || modelName.toLowerCase() == "submittedclaim")){
	filterStoreData={};
}
function renameFilterFields(filterFields){
	YUI().use("node", "event", "escape","aui-datepicker", function(A) {
		var container =A.one("#"+portletns+"double-column-container");
		container.empty();
		var rowid=1;
		var eleid=1;
		var firstHtmlRow='<div id="'+ portletns+'double-column-row'+rowid+'"></div>';
		var firstrow= A.Node.create(firstHtmlRow);
		container.append(firstrow);
		
		if(typeof filterFields !== "undefined" ) {
			
			for(var h = 0; h < filterFields.titles.length; h++){
				var key = filterFields.titles[h].key;
				var row=A.one("#"+ namespace +"double-column-row"+rowid);	
				for(var i = 0; i < filterFields.userInfo.length; i++){
					userArray[filterFields.userInfo[i].id] = filterFields.userInfo[i].name; 
				}

				if(filterFields.distinct[key]!=null || (key.includes("contentJson.") && (filterFields.distinct.contentJson[key.replace("contentJson.","")]!=null) ) ) {

					if((filterStoreData.hasOwnProperty(key))==false){
						filterStoreData[key]=[];
					}
					var optionval;
					var someHtmlOption = '<span style="width:49%;display:inline-block" class="filter-element">'+
					'<label for="'+ portletns+key+'">'+filterFields.titles[h].value+'</label><select class="filterselect" id="'+portletns+key+'">'+'<option selected value>Select an option</option>';
					if (key.includes("contentJson."))
					{
						var contentjsonkey = key.replace("contentJson.","");
						
						for (var i=0; i< filterFields.distinct.contentJson[contentjsonkey].length; i++){
							optionval =filterFields.distinct.contentJson[contentjsonkey][i];
							var optiontext = optionval;
							if(contentjsonkey == "NameOfPayer"){
								if(typeof userArray[optionval] !== "undefined"){
									optiontext = userArray[optionval];
								}

							}
							if(key != 'contentJson.subjects' || key == 'contentJson.Status'){
								if(filterStoreData[key]==optionval || optionval == "Active"){
									someHtmlOption +='<option g value="'+optionval+'" selected>'+optiontext+'</option>';
								}else{
									someHtmlOption +='<option h value="'+optionval+'">'+optiontext+'</option>';
								}
							}
							


						}
						someHtmlOption += '</select>';
						someHtmlOption += '</span>';
					}
					else{
						for (var i=0; i< filterFields.distinct[key].length; i++){
							optionval =filterFields.distinct[key][i];
							var optiontext = optionval;
							if(key == "createdBy" || key == "lastModifiedBy"){
								if(typeof userArray[optionval] !== "undefined"){
									optiontext = userArray[optionval];
								}

							}
							if(filterStoreData[key]==optionval){
								someHtmlOption +='<option value="'+optionval+'" selected>'+optiontext+'</option>';
							}else{
								someHtmlOption +='<option class="asd" value="'+optionval+'">'+optiontext+'</option>';
							}
						}
						someHtmlOption += '</select>';
						someHtmlOption += '</span>';
					}
					
					var col = A.Node.create(someHtmlOption);
					row.append(col);	
					if (eleid && ((eleid %2)==0)){
						var rowcontainer = A.one("#"+ namespace +"double-column-container");
						rowid++;
						var someHtmlRow='<div id="'+ portletns+'double-column-row'+rowid+'"></div>';
						var newrow= A.Node.create(someHtmlRow);
						rowcontainer.append(newrow);
					}
					eleid++;
				}
				if (filterFields.datepicker!=null && filterFields.datepicker.includes(key)){
					if((filterStoreData.hasOwnProperty(key))==false){
						filterStoreData[key]=[];
					}

					var someHtmlDatePick = '<span style="width:50%;display:inline-block" class="filter-element">'+
					'<label for="'+ portletns+key+'">'+filterFields.titles[h].value+'</label><div class="input-group"><input id="'+portletns+key+'" type="text" value="'+filterStoreData[key]+'" readOnly class="filtertext form-control  filter-datepicker" style="width:95%">'
					+'<span class="input-group-add-on"><i class="icon-calendar icon-white" ></i></span></div>'
					+'</span>';
					var col = A.Node.create(someHtmlDatePick);
					row.append(col);
					if (eleid && ((eleid %2)==0)){
						var rowcontainer = A.one("#" +namespace + "double-column-container");
						rowid++;
						var someHtmlRow='<div id="'+ portletns+'double-column-row'+rowid+'"></div>';
						var newrow= A.Node.create(someHtmlRow);
						rowcontainer.append(newrow);
					}
					eleid++;
				}


			}
			if (filterFields.datepicker!=null){
				A.all(".filter-datepicker").each(function(subNode){
					var datePicker = new A.DatePicker({
						trigger: "#"+subNode.get("id"),
						popover: {
							zIndex: 1000,
						},
						mask: '%d/%m/%Y',
						calendar: {
							on: {
								dateClick: function(event) {
									var d = new Date();
									if(event.date <= new Date(d.getFullYear(),d.getMonth(),d.getDate(),12,0,0)){
										subNode.set('value', A.Date.format(event.date,{format:datePicker.get('mask')}));
									}
								}
							},
						    maximumDate : new Date()
						}
					});


				});
			}
			jsFilterColumnList();

		}
		
		var buttonrow=A.one("#" + namespace +  "double-column-container");
		var htmlButtonSpan='<div class="text-center userAction"></div>';
		var buttonspan= A.Node.create(htmlButtonSpan);
		buttonrow.append(buttonspan);
		var someHtmlButton='<button id="'+ portletns+'button'+rowid+'" class="btn btn-primary search">Search</button>';
		var filterbtn = A.Node.create(someHtmlButton);
		filterbtn.on('click',function(e){
			e.preventDefault();
			e.stopPropagation();
			document.getElementsByClassName("orderIcon")[0].click();
			filterdata=[];
			for(var h = 0; h < filterFields.titles.length; h++){
				var key = filterFields.titles[h].key;
				var escapedkey = key.replace(".","\\.");
				var inputfield=A.one("#"+portletns+escapedkey);		
				
				var inputval= inputfield? inputfield.get('value'): null;
				if (inputval){	
					var filter={};
					var aa = filterStoreData[key];
					if(key == "contentJson.ProgrammeCode" || key == "contentJson.ScheduleCode"){
						aa = [];
					}
					if(!aa.includes(inputval)){
						aa.push(inputval);
					}
					filter[key]=aa;
					filterStoreData[key]=aa;
					filterdata.push(filter);
					pageRequested = 1;
					if(modelName.toLowerCase() == "invigilatorattendance"){
					if(filterStoreData["contentJson.Schedule"].length > 0 && 
					   filterStoreData["contentJson.Facility"].length > 0 &&
					   filterStoreData["contentJson.SubFacility"].length > 0 &&
					   filterStoreData["contentJson.AppointmentType"].length > 0 &&
					   filterStoreData["contentJson.AppointmentStatus"].length > 0){
						document.getElementById("recordManually").style.removeProperty('pointer-events');
						document.getElementById("recordManually").style.removeProperty('opacity');
						document.getElementById("recordByBarcode").style.removeProperty('pointer-events');
						document.getElementById("recordByBarcode").style.removeProperty('opacity');
					}
					}
					
					
					if(modelName.toLowerCase() == "candidateattendance"){
					if(filterStoreData["contentJson.Schedule"].length > 0 && 
					   filterStoreData["contentJson.Facility"].length > 0 &&
					   filterStoreData["contentJson.SubFacility"].length > 0 &&
					   filterStoreData["contentJson.AppointmentType"].length > 0){
						document.getElementById("recordManually").style.removeProperty('pointer-events');
						document.getElementById("recordManually").style.removeProperty('opacity');
						document.getElementById("recordByBarcode").style.removeProperty('pointer-events');
						document.getElementById("recordByBarcode").style.removeProperty('opacity');
					}
					}
				}

			}
			jsFilterColumnList();
		});
		var someHtmlClearButton='<button id="'+ portletns+'clrbutton'+rowid+'" class="btn btn-default clear">RESET</button>';
		var clearbtn = A.Node.create(someHtmlClearButton);
		clearbtn.on('click',function(e){
			var selects = document.getElementsByClassName('filterselect');
			var sel;
			var relevantSelects = [];
			for(var z=0; z<selects.length; z++){
				sel = selects[z];
				sel.selectedIndex = 0;
			}
			var selects = document.getElementsByClassName('filtertext');
			var sel;
			var relevantSelects = [];
			for(var z=0; z<selects.length; z++){
				sel = selects[z];
				sel.value = "";
			}

			Object.keys(filterStoreData).forEach(function(key) {
				filterStoreData[key] = [];
			});
			document.getElementsByClassName("orderIcon")[0].click();
			e.preventDefault();
			e.stopPropagation();
			filterdata=[];
			freeTextArray = [];
			sortbyArray = [];
			jsFilterColumnList();
			
			if(modelName.toLowerCase() == "invigilatorattendance" || 
								modelName.toLowerCase() == "candidateattendance"){
				document.getElementById("recordManually").style["pointer-events"] = "none";
				document.getElementById("recordManually").style["opacity"] = "0.6";
				document.getElementById("recordByBarcode").style["pointer-events"] = "none";
				document.getElementById("recordByBarcode").style["opacity"] = "0.6";
			}
		});
		buttonspan.append(filterbtn);
		buttonspan.append(clearbtn);


	});
}
function initialiseSearch(a) {
	if (a.keyCode == 13) {
		jsFilterColumnList()
	}
}
function jsElasticSearchList(e,d) {
	if (e.which !=13)
		return;
	if(freeTextArray.indexOf(d) == -1 && d != "" && d.length > 0){
		freeTextArray.push(d);
		searchBox.value = "";
		pageRequested = 1;
		jsFilterColumnList();
	}
	
}
function loadList() {
	if(modelName === "attendance") {
		if(typeof selectedUserType !== "undefined" && selectedUserType && selectedUserType  !== null && selectedUserType !== "") {
			var obj = {};
			if(selectedUserType.toLowerCase() === "candidate") {
				obj["contentJson.AppointmentType"] = ["Candidate"]
			} else if(selectedUserType.toLowerCase() === "invigilator") {
				obj["contentJson.AppointmentType"] = ["Invigilator"]
			}
			
		}
		filterdata.push(obj);
	}
	showFilters();
	var itemsSelect = document.getElementById(namespace +"itemsPerPage");
	itemsPerPage = itemsSelect.options[itemsSelect.selectedIndex].value;
	var jsonfilterparameter = {"limit":itemsPerPage,"modelName":modelName,"page":(pageRequested - 1),"formType":modelName};
	jsonfilterparameter["filterdata"]=filterdata;

	jsonfilterparameter["conditions"]= freeTextArray;
	jsonfilterparameter["sortby"]= sortbyArray;
	if(typeof selectedCategory !== "undefined" && selectedCategory && selectedCategory  !== null && selectedCategory !== "") {
		jsonfilterparameter["selectedCategory"] = selectedCategory;
	}
	showLoading(true); 
	ajaxCall('GET','elastiSearchList',elastisearchlisturl,jsonfilterparameter,
			function() {
		var data = this.get("responseData");
		showLoading(false); 
		if (_.isEmpty(data)) {
			console.log("error");

		} else {
			tableData = data.content;
			totalRecords = data.totalElements;
			totalPages = data.totalPages;
			reloadTable(tableData,true);
			if(pageRequested == 1){
				drawPagination(pageRequested)
			}

		}

	},
	function() {

	});
}

function jsFilterColumnList(){
	
	if(modelName === "attendance") {
		if(typeof selectedUserType !== "undefined" && selectedUserType && selectedUserType  !== null && selectedUserType !== "") {
			var obj = {};
			if(selectedUserType.toLowerCase() === "candidate") {
				obj["contentJson.AppointmentType"] = ["0"]
			} else if(selectedUserType.toLowerCase() === "invigilator") {
				obj["contentJson.AppointmentType"] = ["Invigilator"]
			}
		}
		filterdata.push(obj);
	} 
	if(modelName === "UserAnnouncement" ) {
		if(typeof UserId !== "undefined" && UserId && UserId !== null && UserId !== "") {
			var obj = {};
			obj["contentJson.UserId"] = [UserId]
		}
		filterdata.push(obj);
	}
	if(modelName === "Announcement" && sortbyArray.length == 0){
		sortbyArray = [{"direction":"desc","field":"createdDate","contentJSON":"false"}];
	}
	//add user id in elastic search filter if user id is present in
	if(modelName === "TransactionMaster") {
		for(var fdi in filterdata) {
			if('createdDate' in filterdata[fdi]) {
				var cdateValues = filterdata[fdi]['createdDate'];
				filterdata[fdi]['contentJson.TxnDate'] = cdateValues;
				delete filterdata[fdi]['createdDate'];
			}
		}
		
		if(UserId!="null" && typeof UserId !== "undefined" && UserId && UserId !== null && UserId !== "") {
			var obj = {};
			obj["contentJson.NameOfPayer"] = [parseInt(UserId)];
			filterdata.push(obj);
			sortbyArray.push({"direction":"desc","field":"createdDate","contentJSON":"false"});
		}
		
		var newSortbyArray = [];
		var isTxnDate = false;
		for(var asi in sortbyArray) {
			console.log(sortbyArray[asi]);
			if(sortbyArray[asi].field=="TxnDate") {
				var txnSort = {};
				txnSort.field = "createdDate";
				txnSort.contentJSON = "false";
				txnSort.direction = sortbyArray[asi].direction;
				newSortbyArray.push(txnSort);
				isTxnDate = true;
			} else {
				newSortbyArray.push(sortbyArray[asi]);
			}
		}
		if(!isTxnDate) {
			newSortbyArray.push({"direction":"desc","field":"createdDate","contentJSON":"false"});
			newSortbyArray.push({"direction":"desc","field":"ExtRefNumber","contentJSON":"true"});
		}
	} 
	
	if(modelName.toLowerCase() == "resultmaster"){
		newSortbyArray = sortbyArray;
	}
	
	if(modelName.toLowerCase() == "invigilatorattendance"){
		newSortbyArray = sortbyArray;
	}
	if(modelName.toLowerCase() == "mastertimetable"){
		newSortbyArray = sortbyArray;
	}
	if(modelName.toLowerCase() == "candidateattendance"){
		newSortbyArray = sortbyArray;
	}
	
	if(modelName.toLowerCase() === "CreditBalance".toLowerCase()) {
		var obj = {};
		obj["contentJson.Status"] = ["Active"];
		filterdata.push(obj);
	} 

	
	showFilters();
	
	var itemsSelect = document.getElementById(namespace +"itemsPerPage");
	itemsPerPage = itemsSelect.options[itemsSelect.selectedIndex].value;
	var jsonfilterparameter = {"limit":itemsPerPage,"modelName":modelName,"page":(pageRequested - 1),"formType":modelName};
	jsonfilterparameter["filterdata"]=filterdata;

	jsonfilterparameter["conditions"]= freeTextArray;
	jsonfilterparameter["sortby"]= newSortbyArray;
	if(typeof selectedCategory !== "undefined" && selectedCategory && selectedCategory  !== null && selectedCategory !== "") {
		jsonfilterparameter["selectedCategory"] = selectedCategory;
	}
	showLoading(true); 
    ajaxCall('GET','elastiSearchList',ajaxurl,jsonfilterparameter,
			function() {
		showLoading(false); 
		var data = this.get("responseData");
		if (_.isEmpty(data)) {
			console.log("error");

		} else {
			tableData = data.content;
			totalRecords = data.totalElements;
			totalPages = data.totalPages;
			reloadTable(tableData,false);
			jsFilterAllStorageIds(totalRecords);
			if(pageRequested == 1){
				drawPagination(pageRequested)
			} else {
				makePaging(totalPages, pageRequested-1);
				pagination(pageRequested, totalPages);
			}
			var display = "none";
			if((filterdata.length > 0  || freeTextArray.length > 0) && tableData.length > 0){
				if(freeTextArray.length == 0 && filterdata.length == 1  && filterdata[0].hasOwnProperty("contentJson.Status") && filterdata[0]["contentJson.Status"][0] == "Active"){
				
				}else{
					display = "block";
				}
				
			}
			var globalActions = document.getElementsByClassName("globalAction");
			for (var i = 0; i < globalActions.length; i++) {
				globalActions[i].style.display = display;
			}
		}
	},
	function() {

	});
	
}
var storageIds = [];
function jsFilterAllStorageIds(totalRecords){
	var jsonfilterparameter = {"limit":(totalRecords).toString(),"modelName":modelName,"page":(pageRequested - 1),"formType":modelName};
	jsonfilterparameter["filters"]=filterdata;
	jsonfilterparameter["conditions"]= freeTextArray;
	jsonfilterparameter["sortby"]= sortbyArray;
	jsonfilterparameter["endPoint"]= "getStorageIds";
	jsonfilterparameter["fieldName"]= "storageId";
	
	ajaxCall('GET','sendRequest',ajaxurl,jsonfilterparameter,
	function() {
		var data = this.get("responseData");
		if (_.isEmpty(data)) {
			console.log("error");

		} else {
			storageIds = data.storageId;
		}
	},
	function() {

	});
}

function getTitleLabel(key) {
	for(var cti=0;cti<columnTitles.length;cti++) {
		var titleObj = columnTitles[cti];
		if((typeof titleObj !== "undefined") && titleObj.key == ("contentJson."+key)) {
			return titleObj.value;
		}
	}
	return key;
}

function formatDate(date) {
	var dd = date.getDate();
	var mm = date.getMonth() + 1; //January is 0!
	var yyyy = date.getFullYear();
	if (dd < 10) {
	  dd = '0' + dd;
	} 
	if (mm < 10) {
	  mm = '0' + mm;
	} 
	return dd + '/' + mm + '/' + yyyy;
}

function reloadTable(a,isSearchList) {
	var table = document.getElementById("tableId");
	var tbody = document.querySelector("#tableId tbody");
	var allheadings = document.querySelectorAll("#tableId .Heading")[0];

	if(a.length > 0){
		while (allheadings.firstChild) {
			allheadings.removeChild(allheadings.firstChild);
		}

		for (var j = 0; j < columnsToShow.length; j++) {
			var th = document.createElement('th');
			var italic = document.createElement('i');
			var text = document.createTextNode(columnsToShow[j]);
			th.appendChild(text);
			th.appendChild(italic);
			if(sortbyArray.length > 0 && sortbyArray[0].field == columnsToShow[j]){
				th.classList.add("listsort" + sortbyArray[0].direction);
			}
			if(j == 0) th.style.display = "none";
			allheadings.appendChild(th);
		}

		var tr = document.createElement('tr');
		var td = document.createElement('td'); 
		var text = document.createTextNode("aaa"); 
		td.appendChild(text);
		td.style.display= "none";
		tr.appendChild(td);
		for (var j = 1; j < columnsToShow.length-1; j++) {
			var td = document.createElement('td'); 
			var text = document.createTextNode("aaa");
			td.appendChild(text);
			tr.appendChild(td);
		}
		var td = document.createElement('td'); 
		var text = document.createTextNode(threedot);
		td.appendChild(threedot);
		tr.appendChild(td);
		tr.className += " Row ";
		tbody.appendChild(tr);
		var th = document.querySelectorAll("#tableId .Heading th");
		var f = document.querySelector("#tableId .Row").cloneNode(true);
		
		for (var g = 0; g < th.length; g++) {
			console.log("columnsToShow[j] : "+columnsToShow[g]);
			if(columnsToShow[g] == "Nric" || columnsToShow[g] == " N R I C") {
				th[g].innerHTML = "<span class='dd'>NRIC</span><i></i>";
			}
			else if(columnsToShow[g]=="IdAndName") {
				th[g].innerHTML = "<span class='dd'>Id & Name</span><i></i>";
			} else {
				if(modelName=="Invigilator" || modelName=="submittedClaim") {
					var newHeading = getTitleLabel(columnsToShow[g]);
					th[g].innerHTML = "<span class='dd'>" + capitalizeFirstLetter(newHeading.replace(/([a-z0-9])([A-Z])/g, '$1 $2')) + "</span><i></i>";
				} else {
					th[g].innerHTML = "<span class='dd'>" + capitalizeFirstLetter(columnsToShow[g].replace(/([a-z0-9])([A-Z])/g, '$1 $2')) + "</span><i></i>";
					if(columnsToShow[g] == "IsAttendance") {
						th[g].innerHTML = "<span class='dd'>Attended?</span><i></i>";
					}				}
			}
		}
		clearTableData();
		var e;
		for (var c = 0; c < a.length; c++) {
			var rowclone = f.cloneNode(true);
			e = rowclone.querySelectorAll("td");
			e[0].innerHTML = a[c][columnsToShow[0]];
			for(var i = 1; i < columnsToShow.length - 1; i++){
				if(typeof a[c].contentJson[columnsToShow[i]] === "undefined") {
					if(columnsToShow[i] == "createdDate" || columnsToShow[i] == "lastModifiedDate" ){
						//var dateParts = a[c][columnsToShow[i]].split("/");
						//var date1 = new Date(+dateParts[2], dateParts[1] - 1, +dateParts[0]);
						var ee = new Date(Date.parse(a[c][columnsToShow[i]]));
						var date = (ee.getDate()  + '/' + (ee.getMonth() + 1) +  '/' +  ee.getFullYear());
						e[i].innerHTML = date;
					}else if(columnsToShow[i] == "createdBy" || columnsToShow[i] == "lastModifiedBy"){
						e[i].innerHTML = a[c][columnsToShow[i]];
						if(typeof userArray[a[c][columnsToShow[i]]] !== "undefined"){
							e[i].innerHTML = userArray[a[c][columnsToShow[i]]];
						}
					}
					else{
						e[i].innerHTML = (a[c].contentJson[columnsToShow[i]] === undefined ? "" : a[c].contentJson[columnsToShow[i]]);
					}

				} else {
					if(columnsToShow[i] == "Date" || columnsToShow[i] == "StartDate" || columnsToShow[i] == "EndDate" || columnsToShow[i] == "EffectiveDate"){
						var dateParts = a[c].contentJson[columnsToShow[i]].split("/");
						var date1 = new Date(+dateParts[2], dateParts[1] - 1, +dateParts[0]);
						var ee = new Date(Date.parse(date1));
						if(ee.toString() == "Invalid Date"){
							e[i].innerHTML = a[c].contentJson[columnsToShow[i]]
						}else{
							var date = (ee.getDate()  + '/' + (ee.getMonth() + 1) +  '/' +  ee.getFullYear());
							e[i].innerHTML = date;
						}
					} else if (columnsToShow[i]=="DateOfBirth") {
						var dobString = (a[c].contentJson[columnsToShow[i]] === undefined ? "" : a[c].contentJson[columnsToShow[i]]);
						if(dobString!="") {
							var dob = new Date(dobString);
							e[i].innerHTML = formatDate(dob);
						} else {
							e[i].innerHTML = dobString;
						}
					} else{
						e[i].innerHTML = (a[c].contentJson[columnsToShow[i]] === undefined ? "" : a[c].contentJson[columnsToShow[i]]);
					}
					
				}
			}

			if(a[c].contentJson.Status == "Active" && e[columnsToShow.length - 1].getElementsByClassName("activate").length  > 0){
				e[columnsToShow.length - 1].getElementsByClassName("activate")[0].style.display = "none";	
			}else if(a[c].contentJson.Status == "Inactive" && e[columnsToShow.length - 1].getElementsByClassName("deactivate").length  > 0){
				e[columnsToShow.length - 1].getElementsByClassName("deactivate")[0].style.display = "none";	
			}else if(a[c].contentJson.Status == "Draft" && e[columnsToShow.length - 1].getElementsByClassName("deactivate").length  > 0){
				e[columnsToShow.length - 1].getElementsByClassName("deactivate")[0].style.display = "none";	
				e[columnsToShow.length - 1].getElementsByClassName("activate")[0].style.display = "none";
			}
			if(modelName.toLowerCase()=="schedule"){
				if(e[columnsToShow.length - 1].getElementsByClassName("masterview").length > 0)
				e[columnsToShow.length - 1].getElementsByClassName("masterview")[0].style.display = "none";
				if(e[columnsToShow.length - 1].getElementsByClassName("blacklist").length > 0)
				e[columnsToShow.length - 1].getElementsByClassName("blacklist")[0].style.display = "none";
				if(e[columnsToShow.length - 1].getElementsByClassName("recordmanually").length > 0)
				e[columnsToShow.length - 1].getElementsByClassName("recordmanually")[0].style.display = "none";
				if(e[columnsToShow.length - 1].getElementsByClassName("print").length > 0)
				e[columnsToShow.length - 1].getElementsByClassName("print")[0].style.display = "none";
				if(a[c].contentJson.ScheduleStatus == "Confirmed"){
					e[columnsToShow.length - 1].getElementsByClassName("confirmed")[0].style.display = "none";
				}else if(a[c].contentJson.ScheduleStatus == "Cancelled"){
					e[columnsToShow.length - 1].getElementsByClassName("confirmed")[0].style.display = "none";
					e[columnsToShow.length - 1].getElementsByClassName("cancelled")[0].style.display = "none";
				}
			}
			table.appendChild(rowclone);

		}

		YUI().use("node", "event", function(A) {
			var j = A.all(".threedot");
			j.on("click", function(o) {
				o.preventDefault();
				o.stopPropagation();
				var p = document.getElementsByClassName("Pop-Action");
				for (var l = 0; l < p.length; l++) {
					p[l].classList.add("hide")
				}
				var m = o.currentTarget;
				var n = m.next();
				n.removeClass("hide")
			})

			var k = A.all("th");
			k.on("click", function(o) {
				eee = o;
				
				var node = eee.currentTarget._node;
				var nodeHtml = eee.currentTarget._node.innerHTML.replace(/\s/g,'');
				var nodeTxt  = eee.currentTarget._node.innerText.replace(/\s/g,'');
				var popupcontainer= A.all("th");
				popupcontainer.removeClass("sortField");
				sortbyArray = [];

				if(sortBy.field == nodeTxt){
					if(sortBy.direction == "asc"){
						sortBy.direction = "desc";
					}else{
						sortBy.direction = "asc";
					} 
				}else{
					sortBy.direction = "asc";
				}
				sortBy.field = node.firstElementChild.innerHTML.replace(/\s/g,'');

				if(auditFields.indexOf(nodeTxt) != -1){
					sortBy.contentJSON = "false";
				}else{
					sortBy.contentJSON = "true";
				}
				sortbyArray.push(sortBy);
				jsFilterColumnList();
			})

		})
		YUI().use('aui-node','aui-io-request', 'liferay-util-window','aui-io-plugin-deprecated',
				'stylesheet','aui-datepicker','overlay','event', 'widget-anim', function(A){

			var container = A.one('body');
			container.on('click', function(e){
				var actionsBox = document.getElementsByClassName('Pop-Action');
				for(var k = 0;k< actionsBox.length;k++){
					actionsBox[k].classList.add('hide');
				}
			});

		});
		document.getElementsByClassName('data-lising')[0].style.display = "block";
		document.getElementsByClassName('pagination')[0].style.display = "block";
		document.getElementsByClassName('no-data-listing')[0].style.display = "none";
	}else{
		document.getElementsByClassName('data-lising')[0].style.display = "none";
		document.getElementsByClassName('pagination')[0].style.display = "none";
		document.getElementsByClassName('no-data-listing')[0].style.display = "block";
		if(!isSearchList) {	
			document.querySelector("h3.no-data-listing-message").innerHTML="No " + modelName  + " record present.";
			document.querySelector("p.no-data-listing-message").innerHTML="There aren't any records of existing "+modelName+"'s as of now.\nIf you would like to create a new one, please click on the 'ADD NEW' button.";
		}
		else {
			document.querySelector("h3.no-data-listing-message").innerHTML="Search Results for " + modelName;
			document.querySelector("p.no-data-listing-message").innerHTML="No search results were found for your query"; 		
		}    	
	}

}
function capitalizeFirstLetter(string) {
    return string.charAt(0).toUpperCase() + string.slice(1);
}
function setMenuBar(){
	YUI().use("node", "event",'aui-popover', function(A) {
		var trigger = A.one('#more-popover');
		var multipopover =new A.Popover({
			align: {
				node: trigger
			},
			bodyContent: MultirowPopAction,
			position: 'bottom',
			zIndex: 1000,
			visible: false
		}).render();

		trigger.on('click', function() {
			var popupcontainer=A.one(".Multi-Pop-Action");
			popupcontainer.removeClass("hide");
			multipopover.set('visible', !multipopover.get('visible'));

		});

		A.one("#searchbtn").on('click',function(){
			updateFormFields();
		});
		A.one(".itemsPerPage").on('change',function(event){ 
			pageRequested = 1;	
			ajaxLock = 0;
			jsFilterColumnList();

		});


	});
}
function clearTableData() {
	var a = document.getElementById("tableId").getElementsByClassName("Row");
	while (a.length) {
		a[0].parentNode.removeChild(a[0])
	}
};
function updateFormFields(){
	var data = {"formStorageId":modelName,"configurationModelName":modelName,"formType":"configuration"};
	data.column1 = document.getElementById(portletns + 'select1').value;
	data.column2 = document.getElementById(portletns + 'select2').value;
	data.column3 = document.getElementById(portletns + 'select3').value;
	data.column4 = document.getElementById(portletns + 'select4').value;
	data.column5 = document.getElementById(portletns + 'select5').value;
	data.column6 = document.getElementById(portletns + 'select6').value;
	data.column7 = document.getElementById(portletns + 'select7').value;
	data.columnlist = columnlist;
	document.getElementsByClassName("settingIcon")[0].click();
	for (var key in data) {
		  if (data[key] == "Attended?") {
			  data[key] = "IsAttendance";
		  }
		}
	ajaxCall('POST','update',ajaxurl,data,
			function() {
		var data = this.get("responseData");
		if (data.error) {
			console.log("error");
		} else {    
			getFormFields(); 
		}
	},
	function() {

	});
}

AUI().use("node", "event","event-base", function (A) {
	A.on('domready', function () {
		setMenuBar();
		getFormFields();



	});
});

function doAction(action,d) {	 
	AUI().use('liferay-portlet-url', function(A) {
		var c = findAncestor(d, "Row");
		var a = [];
		for (var b = 0; b < c.childElementCount; b++) {
			a.push(c.children[b].textContent.trim())
		}
		var e =  Liferay.PortletURL.createRenderURL();
		e.options.basePortletURL = baseUrl;
		if(action == 'edit'){
			e.setParameter("jspPage", config.editPage);   
		}else if(action == 'detail'){
			e.setParameter("jspPage", config.detailPage);   
		}else if(action == 'copy'){
			e.setParameter("jspPage", config.copyPage);   
		}
		else if(action == 'masterview'){
			e.setParameter("jspPage", config.masterViewPage);   
		} else if (action === 'recordmanually') {
			e.setParameter("jspPage", config.recordManuallyPage);
		}
		
		e.setParameter("formTypeName", modelName);

		e.setParameter("storageId", a[0]);
		e.setPortletId(namespace.replace(/(^\_+|\_+$)/mg, ''));
		e.setWindowState("normal");
		window.location.href =  e.toString().replace(/candidatelist/g, 'candidate');


	});
}

function doRecordManuallyAction(action) {
	showPaymentSection(null);
}

function doRecordByBarcodeReaderAction() {
	filterdata={};
	Object.keys(filterStoreData).forEach(function(key){
		if (filterStoreData[key] != "" && typeof( filterStoreData[key]) == "object" && filterStoreData[key].length > 0){
			filterdata[key] = filterStoreData[key];
		}
	 });
	AUI().use('liferay-portlet-url', function(A) {
		var e =  Liferay.PortletURL.createRenderURL();
		e.options.basePortletURL = baseUrl;
		e.setParameter("jspPage", config.recordBarcodePage);
		e.setParameter("formTypeName", modelName);
		e.setPortletId(namespace.replace(/(^\_+|\_+$)/mg, ''));
		e.setWindowState("normal");
		e.setParameter("filterData" , encodeURI(JSON.stringify(filterdata)));
		
		window.location.href = e.toString();
	});
}

function doExportAsPDF(e) {
	e.preventDefault();
	e.stopPropagation();
	filterdata=[];
	Object.keys(filterStoreData).forEach(function(key){
		var filter = {};
		if (filterStoreData[key] != "" && typeof( filterStoreData[key]) == "object" && filterStoreData[key].length > 0){
			filter[key] = filterStoreData[key];
			filterdata.push(filter);
		}
      });
		
			var contentJson = {
					filterData: filterdata		
			};
			var jsonData = {"modelName":modelName,"formType":modelName, "contentJson": contentJson};
			window.open(exportPdfUrl+"&"+namespace+"formType"+"="+modelName+"&"+namespace+"data="+encodeURIComponent(JSON.stringify(jsonData)));
}

function storageStatus1(status,d){
	showLoading(true);
	if(status == 'Active'){
		var popupdiv = "#active-record";
		var popupdivbox = "#active-record-box";
		updateStorageStatus1(status,d);
	}else if(modelName!="Schedule" && status == 'Cancelled'){
		var popupdiv = "#active-record";
		var popupdivbox = "#active-record-box";
		updateStorageStatus1(status,d);
	}else if(status == 'Confirmed'){
		var popupdiv = "#active-record";
		var popupdivbox = "#active-record-box";
		if(modelName=="Schedule"){
			updateScheduleStatus(status,d);
		}else{
			updateStorageStatus1(status,d);
		}
	}else if(status == 'Inactive' || status == 'Blacklist' || status == "Cancelled"){
		if(status == 'Inactive'){
			var popupdiv = "#deactive-record";
			var popupdivbox = "#deactive-record-box";
			var ee = document.getElementById("deactivate_msg");
			var ef = document.getElementById("deactivate_title");
			ee.innerText = ee.innerText.replace("these","this");
			ef.innerText = ef.innerText.replace("these","this");
		}else if(status == 'Blacklist'){
			var popupdiv = "#blacklist-record";
			var popupdivbox = "#blacklist-record-box";
		}
		else if(status == 'Cancelled'){
			var popupdiv = "#cancelled-record";
			var popupdivbox = "#cancelled-record-box";
		}

		AUI().use('aui-base', function(A) {

			A.one(popupdiv).set('hidden', false);
			showLoading(false);     
			YUI().use('aui-modal', function(Y) {
				var modal = new Y.Modal({
					boundingBox: popupdiv,
					contentBox: popupdivbox,
					headerContent: '',
					centered: true,
					destroyOnHide: false,
					modal: true,
					resizable: false,
					draggable: false,
				}).render();


				Y.one('.close').on(
						'click',
						function() {
							//window.location.reload();
							modal.hide();
							showLoading(false); 
						}
				);
				Y.one('.popup-cancel-deactivate').on(
						'click',
						function() {
							modal.hide();
							showLoading(false); 
						}
				);
				Y.one('.popup-reactivate').on(
						'click',
						function() {
							modal.hide();
							// storageStatus1("Active",d);rajjan
						}
				);

				Y.one('.popup-confirm-deactivate').on(
						'click',
						function() {
							showLoading(false); 
							if(document.getElementById("deactivate_reason").value.length > 4){
								updateStorageStatus1(status,d);
								modal.hide();
							}else{
								document.getElementById("deactivate_msg").classList.add("alert");
								document.getElementById("deactivate_msg").classList.add("alert-error");
							}

						}
				);
				Y.one('.popup-confirm-cancel').on(
						'click',
						function() {
							showLoading(false); 
							if(document.getElementById("cancel_reason").value.length > 4){
								//updateStorageStatus1(status,d);
								if(modelName=="Schedule"){
									updateScheduleStatus(status,d);
								}else{
									updateStorageStatus1(status,d);
								}
								modal.hide();
							}else{
								document.getElementById("cancel_msg").classList.add("alert");
								document.getElementById("cancel_msg").classList.add("alert-error");
							}

						}
				);
				Y.one('.popup-cancel-blacklist').on(
						'click',
						function() {
							modal.hide();
							showLoading(false); 
						}
				);

				Y.one('.popup-confirm-blacklist').on(
						'click',
						function() {
							showLoading(false); 
							if(document.getElementById("blacklist_reason").value.length > 4){
								updateStorageStatus1(status,d);
								modal.hide();
							}else{
								document.getElementById("blacklist_msg").classList.add("alert");
								document.getElementById("blacklist_msg").classList.add("alert-error");
							}

						}
				);

			});

		});
	}	

}
function updateStorageStatus1(status,d){

	var c = findAncestor(d, "Row");
	var a = [];
	for (var b = 0; b < c.childElementCount; b++) {
		a.push(c.children[b].textContent.trim())
	}
	var inactiveReason = "";
	if(status.toLowerCase() == 'inactive'){
		inactiveReason = document.getElementById("deactivate_reason").value;
	}
	showLoading(true); 
	ajaxCall('GET','loadData',ajaxurl,{"formType":modelName,"formStorageId": encodeURIComponent(a[0])},
			function() {
		var data = this.get("responseData");  
		showLoading(false); 
		if (data == null || data == "") {
			console.log("error");

		} else {
			var data1 = data.contentJson;
			data1.Status = status;
			data1.InactiveReason = inactiveReason;
			data1.formType = modelName;
			data1.formStorageId = encodeURIComponent(a[0]);

			ajaxCall('GET','update',ajaxurl,data1,
					function() {
				var data = this.get("responseData");
				if (_.isEmpty(data)) {
					console.log("error");
					showPopupSuccess(status,d);
				} else if(data.error && data.error=="inuse"){
					console.log("error1");
					showPopupError(data[Object.keys(data)[0]]);
				} else if(data.errorCode && data.errorCode=="reference-error"){
					console.log("error2");
					showPopupError(data[Object.keys(data)[0]]);
				} else {
					jsFilterColumnList();
					showPopupSuccess(status,d);
				}
			},
			function() {
			});
		}
	},
	function() {

	});
}

function updateScheduleStatus(status,d){

	var c = findAncestor(d, "Row");
	var a = [];
	for (var b = 0; b < c.childElementCount; b++) {
		a.push(c.children[b].textContent.trim())
	}
	var inactiveReason = "";
	if(status.toLowerCase() == 'inactive'){
		inactiveReason = document.getElementById("deactivate_reason").value;
	}
	var cancellationReason=""
	if(status.toLowerCase() == 'Cancelled'){
		//cancel_reason status == "Cancelled"
		cancellationReason = document.getElementById("cancel_reason").value;
	}
	showLoading(true);  
	ajaxCall('GET','loadData',ajaxurl,{"formType":modelName,"formStorageId": encodeURIComponent(a[0])},
			function() {
		showLoading(false); 
		var data = this.get("responseData");   
		if (data == null || data == "") {
			console.log("error");

		} else {
			var data1 = data.contentJson;
			data1.ScheduleStatus = status;
			data1.InactiveReason = inactiveReason;
			data1.CancellationReason = cancellationReason;
			data1.formType = modelName;
			data1.formStorageId = encodeURIComponent(a[0]);

			ajaxCall('GET','update',ajaxurl,data1,
					function() {
				var data = this.get("responseData");   
				if (_.isEmpty(data)) {
					console.log("error");
					showPopupSuccess(status,d);
				} else {
					jsFilterColumnList();
					showPopupSuccess(status,d);
				}
			},
			function() {
				console.log("eee");
			});
		}
	},
	function() {

	});
}

function showPopupError(message){
	AUI().use('aui-base', function(A) {
		var boundingBox = "#action-error";
		var contentBox = "#action-error-box";
		document.getElementById("action-error-box").getElementsByClassName("message")[0].innerHTML=message;
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
			Y.one('.close').on(
					'click',
					function() {
						window.location.reload();
						modal.hide();
					}
			);
		});

	});
}

function showPopupSuccess(status,d){

	AUI().use('aui-base', function(A) {
		if(status.toLowerCase() == 'inactive'){
			var boundingBox = "#deactivation-success";
			var contentBox = "#inactive-success-box";
		}
		if(status.toLowerCase() == 'active'){
			var boundingBox = "#activation-success";
			var contentBox = "#active-success-box";
		}
		if(status.toLowerCase() == 'confirmed'){
			var boundingBox = "#confirmed-success";
			var contentBox = "#confirmed-success-box";
		}
		if(status.toLowerCase() == 'cancelled'){
			var boundingBox = "#cancelled-success";
			var contentBox = "#cancelled-success-box";
		}
		if(status.toLowerCase() == 'blacklist'){
			var boundingBox = "#blacklist-success";
			var contentBox = "#blacklist-success-box";
		}
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


			Y.one('.close').on(
					'click',
					function() {
						window.location.reload();
						modal.hide();
					}
			);
		});

	});
}

function archiveStorage1(d){

	AUI().use('aui-base', function(A) {
		var boundingBox = "#archive-record";
		var contentBox = "#archive-record-box";
		var ee = document.getElementById("archive_msg");
		var ef = document.getElementById("archive_title");
		ee.innerText = ee.innerText.replace("these","this");
		ef.innerText = ef.innerText.replace("these","this");
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


			Y.one('.close').on(
					'click',
					function() {
						//window.location.reload();
						modal.hide();
					}
			);
			Y.one('.popup-cancel-archive').on(
					'click',
					function() {
						modal.hide();
					}
			);

			Y.one('.popup-confirm-archive').on(
					'click',
					function() {
						var c = findAncestor(d, "Row");
						var a = [];
						for (var b = 0; b < c.childElementCount; b++) {
							a.push(c.children[b].textContent.trim())
						}
						showLoading(true); 
						var data = {"formType":modelName,"formStorageId": encodeURIComponent(a[0])};
						
						ajaxCall('GET','archive',ajaxurl,data,
								function() {
							var data = this.get("responseData");  
							showLoading(false);
							if (_.isEmpty(data)) {
								console.log("error");
							} else if(data.error && data.error=="inuse"){
								showPopupError(data[Object.keys(data)[0]]);
							} else if(data.errorCode && data.errorCode=="reference-error"){
								console.log("error2");
								showPopupError(data.errorMessage);
							} else {
								window.location.reload();
							}
						},
						function() {

						});
						modal.hide();
					}
			);

		});

	});
}

function recordManually() {
	alert("record manually called");
}

function addNewRecord(d){
	AUI().use('liferay-portlet-url', function(A) {
		var e =  Liferay.PortletURL.createRenderURL();
		e.options.basePortletURL = baseUrl;
		jspPage = config.createPage;
		e.setParameter("formTypeName", modelName);
		e.setParameter("jspPage", jspPage);
		e.setPortletId(namespace.replace(/(^\_+|\_+$)/mg, ''));
		e.setWindowState("normal");
		// window.location.href = e.toString();
		var pattern = /__/g;
		var dd = e.toString();
		window.location.href = dd.replace(pattern,"_");
		window.location.href =  e.toString().replace(/candidatelist/g, 'candidate');
	});
}
function findAncestor (el, cls) {
	while ((el = el.parentElement) && !el.classList.contains(cls));
	return el;
}
function exportStorage1(e,d){
	e.preventDefault();
	e.stopPropagation();
	var c = findAncestor(d, "Row");
	var a = [];
	for (var b = 0; b < c.childElementCount; b++) {
		a.push(c.children[b].textContent.trim())
	}
	var exportUrl = globalexportlisturl + "&"+namespace+"formType"+"="+modelName+"&"+namespace+"formStorageId"+"="+encodeURIComponent(a[0]);
    window.open(exportUrl);

}
function globalExportList(e){
	e.preventDefault();
	e.stopPropagation();
	var exportUrl = globalexportlisturl + "&"+namespace+"formType"+"="+modelName;
    if(modelName == "CreditBalance")
    	window.location.href = exportUrl;
    else 
    	window.open(exportUrl);
}
function globalDeactivateList(d){
	var popupdiv = "#deactive-record";
	var popupdivbox = "#deactive-record-box";
	var ee = document.getElementById("deactivate_msg");
	var ef = document.getElementById("deactivate_title");
	ee.innerText = ee.innerText.replace("this","these");
	ef.innerText = ef.innerText.replace("this","these");
	AUI().use('aui-base', function(A) {

		A.one(popupdiv).set('hidden', false);
		showLoading(false);     
		YUI().use('aui-modal', function(Y) {
			var modal = new Y.Modal({
				boundingBox: popupdiv,
				contentBox: popupdivbox,
				headerContent: '',
				centered: true,
				destroyOnHide: false,
				modal: true,
				resizable: false,
				draggable: false,
			}).render();


			Y.one('.close').on(
					'click',
					function() {
						window.location.reload();
						modal.hide();
						showLoading(false); 
					}
			);
			Y.one('.popup-cancel-deactivate').on(
					'click',
					function() {
						modal.hide();
						showLoading(false); 
					}
			);
			Y.one('.popup-cancel-cancel').on(
					'click',
					function() {
						modal.hide();
						showLoading(false); 
					}
			);
			Y.one('.popup-reactivate').on(
					'click',
					function() {
						modal.hide();
						// storageStatus1("Active",d);rajjan
					}
			);

			Y.one('.popup-confirm-deactivate').on(
					'click',
					function() {
						showLoading(true); 
						inactiveReason = document.getElementById("deactivate_reason").value;
						var data = {"formType":modelName,"storageIds": storageIds,"inactiveReason":inactiveReason};
						data.endPoint = "deactivateglobal";
					
						ajaxCall('GET','sendRequest',ajaxurl,data,
								function() {
							var data = this.get("responseData");  
							showLoading(false);
							if (_.isEmpty(data)) {
								console.log("error");
							} else {
								window.location.reload();
							}
						},
						function() {

						});

					}
			);
			Y.one('.popup-cancel-blacklist').on(
					'click',
					function() {
						modal.hide();
						showLoading(false); 
					}
			);

			Y.one('.popup-confirm-blacklist').on(
					'click',
					function() {
						showLoading(false); 
						if(document.getElementById("blacklist_reason").value.length > 4){
							updateStorageStatus1(status,d);
							modal.hide();
						}else{
							document.getElementById("blacklist_msg").classList.add("alert");
							document.getElementById("blacklist_msg").classList.add("alert-error");
						}

					}
			);

		});

	});
	
	
	
	
}
function globalArchiveList(){
	AUI().use('aui-base', function(A) {
		var boundingBox = "#archive-record";
		var contentBox = "#archive-record-box";
		var ee = document.getElementById("archive_msg");
		var ef = document.getElementById("archive_title");
		ee.innerText = ee.innerText.replace("this","these");
		ef.innerText = ef.innerText.replace("this","these");
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


			Y.one('.close').on(
					'click',
					function() {
						window.location.reload();
						modal.hide();
					}
			);
			Y.one('.popup-cancel-archive').on(
					'click',
					function() {
						modal.hide();
					}
			);

			Y.one('.popup-confirm-archive').on(
					'click',
					function() {
						showLoading(true); 
						var data = {"formType":modelName,"storageIds": storageIds};
						data.endPoint = "archiveglobal";
					
						ajaxCall('GET','sendRequest',ajaxurl,data,
								function() {
							var data = this.get("responseData");  
							showLoading(false);
							if (_.isEmpty(data)) {
								console.log("error");
							} else {
								window.location.reload();
							}
						},
						function() {

						});
						modal.hide();
					}
			);

		});

	});
}
function showFilters(){
	var filterlist = document.getElementById("filterlist");
	var txt = "<ul>";
	var hasText = 0;
	Object.keys(filterStoreData).forEach(function(key) {
		if(filterStoreData[key] != ""){
			if(typeof(filterStoreData[key]) == "object"){
				Object.keys(filterStoreData[key]).forEach(function(key1) {
					if(key == "createdBy" || key == "modifiedBy" || key == "contentJson.NameOfPayer"){
						txt += '<li style="display: inline-block;" onclick="removeFilter(\'' + key + '\',\''+ filterStoreData[key][key1]+'\')"> <a >'+ userArray[filterStoreData[key][key1]] +' </a>  </li>';
					}else{
						txt += '<li style="display: inline-block;" onclick="removeFilter(\'' + key + '\',\''+ filterStoreData[key][key1]+'\')"> <a >'+ filterStoreData[key][key1] +' </a>  </li>';	
					}
					
					hasText = 1;
				})
			}
			else {
				txt += '<li style="display: inline-block;" onclick="removeFilter(\'' + key + '\',\''+ filterStoreData[key]+'\')"> <a >'+ filterStoreData[key] +' </a>  </li>';
				hasText = 1;
			}
		}
	});

	Object.keys(freeTextArray).forEach(function(key) {
		txt += '<li style="display: inline-block;" onclick="removeFilter(\'' + 'condition' + '\',\''+ freeTextArray[key]+'\')"> <a >'+ freeTextArray[key] +' </a>  </li>';
		hasText = 1;
	});
	txt += "</ul>";
	if(hasText == 0)txt = "";
	filterlist.innerHTML = txt;
}
function removeFilter(key, value){
debugger;
	if(key == "condition"){
		var index = freeTextArray.indexOf(value);
		freeTextArray.splice(index,1);
	}else{
		var index = filterStoreData[key].indexOf(value);
		filterStoreData[key].splice(index,1);
		showFilters();

		filterdata=[];
		Object.keys(filterStoreData).forEach(function(key){
			var filter = {};
			if (filterStoreData[key] != "" && typeof( filterStoreData[key]) == "object" && filterStoreData[key].length > 0){
				filter[key] = filterStoreData[key];
				filterdata.push(filter);
			}

		});
	}
	if(modelName.toLowerCase() == "invigilatorattendance"){
		if(filterStoreData["contentJson.Schedule"].length <= 0 || 
				   filterStoreData["contentJson.Facility"].length <= 0 ||
				   filterStoreData["contentJson.SubFacility"].length <= 0 ||
				   filterStoreData["contentJson.AppointmentType"].length <= 0 ||
				   filterStoreData["contentJson.AppointmentStatus"].length <= 0){
			document.getElementById("recordManually").style["pointer-events"] = 'none';
			document.getElementById("recordManually").style["opacity"] = '0.6';
			document.getElementById("recordByBarcode").style["pointer-events"] = 'none';
			document.getElementById("recordByBarcode").style["opacity"] = '0.6';
		}
	}
	
	
	if(modelName.toLowerCase() == "candidateattendance"){
		if(filterStoreData["contentJson.Schedule"].length <= 0 || 
				   filterStoreData["contentJson.Facility"].length <= 0 ||
				   filterStoreData["contentJson.SubFacility"].length <= 0 ||
				   filterStoreData["contentJson.AppointmentType"].length <= 0){
			document.getElementById("recordManually").style["pointer-events"] = 'none';
			document.getElementById("recordManually").style["opacity"] = '0.6';
			document.getElementById("recordByBarcode").style["pointer-events"] = 'none';
			document.getElementById("recordByBarcode").style["opacity"] = '0.6';
		}
	}
	jsFilterColumnList();

}
setTimeout(function(){  drawPagination(pageRequested); }, 3000);
function showLoading(show) {
	if(show) {
		getEID("loadingDiv").style.display = "block";
	} else {
		getEID("loadingDiv").style.display = "none";
	}
}
function getEID(element) {
	return document.getElementById(element);
}

function sendNotification(action,obj){
	var jsonfilterparameter = {"limit":(totalRecords).toString(),"modelName":modelName,"page":(pageRequested - 1),"formType":modelName};
	jsonfilterparameter["filters"]=filterdata;
	ajaxCall('GET','sendNotification',ajaxurl,jsonfilterparameter,
			function() {
		var data = this.get("responseData");
		if (_.isEmpty(data)) {
			showPopupSuccess(action,obj);
		} else {
			jsFilterColumnList();
			showPopupSuccess(action,obj);
		}
	},
	function() {
	});
}
