var freeTextArray = [];
//var filterdata=[{"contentJson.Status":["Active"]}];
var filterdata = [];
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
    console.log(rangeWithDots);
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
				populateSearchFields(data);     
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
				jsFilterColumnList();
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
	var allcolumns = data.contentJson.columnlist + "," + auditFields ;
	masterColumns = SambaashUtils.sortStringArray(allcolumns.split(','));
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

		if(selectBoxNumber == 0) {selectValue = data.contentJson.column1; }
		else if(selectBoxNumber == 1 && data.contentJson.column2 !=null) {selectValue = data.contentJson.column2;}
		else if(selectBoxNumber == 2 && data.contentJson.column3 !=null) {selectValue = data.contentJson.column3;}
		else if(selectBoxNumber == 3 && data.contentJson.column4 !=null) {selectValue = data.contentJson.column4;}
		else if(selectBoxNumber == 4 && data.contentJson.column5 !=null) {selectValue = data.contentJson.column5;}
		else if(selectBoxNumber == 5 && data.contentJson.column6 !=null) {selectValue = data.contentJson.column6;}
		else if(selectBoxNumber == 6 && data.contentJson.column7 !=null) {selectValue = data.contentJson.column7;}
		selectBoxNumber++;

		for (var i = 0; i < availableColumns.length; i++) {
			var o = document.createElement("option");
			o.value = availableColumns[i];
			o.text = capitalizeFirstLetter(availableColumns[i]).replace(/([A-Z])/g, " $1").replace('Srn Number','SRN Number');
			if (selectValue === o.value) {
				o.selected ='selected';
			}
			elm.appendChild(o);
		}
	})
	getFilterFields();

}


var filterStoreData={};
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
					'<label for="'+ portletns+key+'">'+filterFields.titles[h].value+'</label><select class="filterselect" id="'+portletns+key+'" '+
					((key === 'contentJson.subjects') ? 'multiple="multiple" size="6" style="height: auto;">' : '><option selected value>Select an option</option>');
					if (key.includes("contentJson."))
					{
						var contentjsonkey = key.replace("contentJson.","");

						for (var i=0; i< filterFields.distinct.contentJson[contentjsonkey].length; i++){
							optionval =filterFields.distinct.contentJson[contentjsonkey][i];
//							if(key != 'contentJson.subjects'){
								if(filterStoreData[key]==optionval){
									someHtmlOption +='<option g value="'+optionval+'" selected>'+optionval+'</option>';
								}else{
									someHtmlOption +='<option h value="'+optionval+'">'+optionval+'</option>';
								}
//							}
							


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
									subNode.set('value', A.Date.format(event.date,{format:datePicker.get('mask')}));
								}
							}
						}
					});


				});
			}

		}
		var selectProgrammeCode = document.getElementById(namespace + "contentJson.ProgrammeCode");
		selectProgrammeCode.onchange = function() {
			 fetchSubjects(selectProgrammeCode.value);
		};
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
				console.log(key);
				var inputval= inputfield? inputfield.get('value'): null;
				if (inputval){	
					var filter={};
					var aa = filterStoreData[key];
					if(key == "contentJson.ProgrammeCode" || key == "contentJson.ScheduleCode"){
						aa = [];
					} else if(key == "contentJson.subjects"){
						aa = SambaashUtils.getMultiSelectValues(inputfield._node).split(',');
					}
					if(!aa.includes(inputval)){
						aa.push(inputval);
					}
					filter[key]=aa;
					filterStoreData[key]=aa;
					filterdata.push(filter);
					pageRequested = 1;
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
		});
		buttonspan.append(filterbtn);
		buttonspan.append(clearbtn);


	});
}
function fetchSubjects(program_code){
	AUI().use('aui-io-request-deprecated', 'aui-base', function(A) {
		var _data = {};
		var qq = "/api/jsonws/SystemModelSetup-portlet.system/get-entity-link/group-id/" + EMS_SCOPE_GROUP_ID + "/query-by-example-json-string/{   ModelLeft:'Programme',   ModelRight:'Subject', StorageIdLeft:'"+ program_code +"'}/return-field-list/ModelRightDetails.SubjectCode,ModelRightDetails.SubjectTitle,ModelRightDetails.SubjectType/retrieve-model-details/ModelRight/flatten/true";
		// need to add p_auth since not using Liferay.Service() instead
		qq += "?p_auth="+p_auth_global;
		A.io.request(qq, {
			dataType : 'json',
			method : "GET",
			data : _data,
			on : {
				success : function() {
				      var data = this.get("responseData");
			    	  var selectsubjects = document.getElementById(namespace + "contentJson.subjects");
			    	  selectsubjects.setAttribute("multiple","multiple");
			    	  selectsubjects.setAttribute("size","6");
			    	  selectsubjects.style.height = "auto";
			    	  selectsubjects.options.length = 0;
				      if (_.isEmpty(data)) {
				        console.log("error");
				      } else {
				    	  console.log(data);
				    	  selectsubjects.options[selectsubjects.options.length] = new Option("Select an option", "", false, false);
				    	  for(var i = 0; i < data.length; i++){
				    		  selectsubjects.options[selectsubjects.options.length] = new Option(data[i].SubjectCode, data[i].SubjectCode, false, false);
				    	  }
				      }
				    },
				failure : function() {

				}
			}
		});
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
	showFilters();
	var itemsSelect = document.getElementById(namespace +"itemsPerPage");
	itemsPerPage = itemsSelect.options[itemsSelect.selectedIndex].value;
	var jsonfilterparameter = {"limit":itemsPerPage,"modelName":modelName,"page":(pageRequested - 1),"formType":modelName};
	jsonfilterparameter["filterdata"]=filterdata;

	jsonfilterparameter["conditions"]= freeTextArray;
	jsonfilterparameter["sortby"]= sortbyArray;
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
	showFilters();
	var itemsSelect = document.getElementById(namespace +"itemsPerPage");
	itemsPerPage = itemsSelect.options[itemsSelect.selectedIndex].value;
	var jsonfilterparameter = {"limit":itemsPerPage,"modelName":modelName,"page":(pageRequested - 1),"formType":modelName};
	jsonfilterparameter["filterdata"]=filterdata;

	jsonfilterparameter["conditions"]= freeTextArray;
	jsonfilterparameter["sortby"]= sortbyArray;
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
			jsFilterAllCandidates();
			if(pageRequested == 1){
				drawPagination(pageRequested)
			} else {
				makePaging(totalPages, pageRequested-1);
				pagination(pageRequested, totalPages);
			}
		}
	},
	function() {

	});


}
function jsFilterAllCandidates(){
	var jsonfilterparameter = {"limit":2147483647,"modelName":modelName,"page":(pageRequested - 1),"formType":modelName};
	jsonfilterparameter["filters"]=filterdata;
	jsonfilterparameter["conditions"]= freeTextArray;
	jsonfilterparameter["sortby"]= sortbyArray;
	jsonfilterparameter["endPoint"]= "getEnrolmentIds";
	jsonfilterparameter["fieldName"]= "enrolmentId";
	
	ajaxCall('GET','elastiSearchCandidateList',ajaxurl,jsonfilterparameter,
	function() {
		var data = this.get("responseData");
		if (_.isEmpty(data)) {
			console.log("error");

		} else {
			enrolmentIds = data.enrolmentId;
			showHideProgrammeContextMenu(data.enrolmentId.length);
			setCookie("enrolmentIds", JSON.stringify(data.enrolmentId), 3000);
			console.log(data);
		}
	},
	function() {

	});
}
function showHideProgrammeContextMenu(enrolmentLength)
{
	var visibility = "hidden";
	var display = "none";
	var filterDataStr =  JSON.stringify(filterdata);
	if(enrolmentLength > 0 && filterDataStr.includes("ScheduleCode") && filterDataStr.includes("ProgrammeCode") && filterDataStr.includes("subjects") ){
		visibility = "visible";
		display = "block";
	}
	var divsToHide = document.getElementsByClassName("ProgrammeContextMenu"); 
    for(var i = 0; i < divsToHide.length; i++){
        divsToHide[i].style.visibility = visibility; 
        divsToHide[i].style.display = display;
    }
}


function showColumnDiv(e, className){
	if(e[columnsToShow.length - 1].getElementsByClassName(className).length > 0){
		e[columnsToShow.length - 1].getElementsByClassName(className)[0].style.display = "block";	
	}
}

function displayContextMenuByStatus(e, enrollmentStatus){
	var status = enrollmentStatus.toUpperCase();
	if(status == "PENDING" || status == "VERIFIED" || status == "NOTIFIED" || status == "CONFIRMED"){
		if(status != "CONFIRMED"){
			showColumnDiv(e, "editEnrolment");
		}
		showColumnDiv(e, "switchProgramme");
		showColumnDiv(e, "switchSubjects");
		showColumnDiv(e, "cancelEnrolment");
		showColumnDiv(e, "withdrawEnrolment");
	}
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
			th[g].innerHTML = "<span>" + capitalizeFirstLetter(columnsToShow[g].replace(/([a-z0-9])([A-Z])/g, '$1 $2')) + "</span><i></i>";
		}
		clearTableData();
		var e;
		for (var c = 0; c < a.length; c++) {
			var rowclone = f.cloneNode(true);
			rowclone.setAttribute("rownum",c);
			e = rowclone.querySelectorAll("td");
			e[0].innerHTML = a[c][columnsToShow[0]];
			for(var i = 1; i < columnsToShow.length - 1; i++){
				if(typeof a[c].contentJson[columnsToShow[i]] === "undefined") {
					if(columnsToShow[i] == "createdDate" || columnsToShow[i] == "lastModifiedDate"){
						var ee = new Date(Date.parse(a[c][columnsToShow[i]]));
						var date = (ee.getDate()  + '/' + (ee.getMonth() + 1) +  '/' +  ee.getFullYear());
						e[i].innerHTML = date;
					}else if(columnsToShow[i] == "createdBy" || columnsToShow[i] == "lastModifiedBy"){
						e[i].innerHTML = a[c][columnsToShow[i]];
						if(typeof userArray[a[c][columnsToShow[i]]] !== "undefined"){
							e[i].innerHTML = userArray[a[c][columnsToShow[i]]];
						}
					}
					else if(columnsToShow[i].toLowerCase() == "subjects"){
						e[i].innerHTML = a[c][columnsToShow[i]];
						if(typeof userArray[a[c][columnsToShow[i]]] !== "undefined"){
							e[i].innerHTML = userArray[a[c][columnsToShow[i]]];
						}
					}
					else{
						e[i].innerHTML = (a[c].contentJson[columnsToShow[i]] === undefined ? "" : a[c].contentJson[columnsToShow[i]]);
					}

				} else {
					if(columnsToShow[i].toLowerCase() == "subjects"){
						var subjectss = "";
						for(var y = 0; y < a[c].contentJson[columnsToShow[i]].length; y++){
							subjectss = subjectss + a[c].contentJson[columnsToShow[i]][y].SubjectTitle + ",";
						}
						e[i].innerHTML = subjectss;
					}else{
					
						e[i].innerHTML = (a[c].contentJson[columnsToShow[i]] === undefined ? "" : a[c].contentJson[columnsToShow[i]]);
					}
				}
			}

			if(a[c].contentJson.Status == "Active" && e[columnsToShow.length - 1].getElementsByClassName("activate").length  > 0){
				e[columnsToShow.length - 1].getElementsByClassName("activate")[0].style.display = "none";	
			}else if(a[c].contentJson.Status == "Inactive" && e[columnsToShow.length - 1].getElementsByClassName("deactivate").length  > 0){
				e[columnsToShow.length - 1].getElementsByClassName("deactivate")[0].style.display = "none";	
			}else if(a[c].contentJson.Status == "Draft"){
				e[columnsToShow.length - 1].getElementsByClassName("deactivate")[0].style.display = "none";	
				e[columnsToShow.length - 1].getElementsByClassName("activate")[0].style.display = "none";
			}
			
			displayContextMenuByStatus(e, a[c].contentJson.EnrolmentStatus);
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
				console.log(sortbyArray);
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

		e.setParameter("storageId", tableData[0].contentJson.UserId);
		e.setPortletId(namespace.replace(/(^\_+|\_+$)/mg, ''));
		e.setWindowState("normal");
		console.log("path :: " + e.toString());
		window.location.href = e.toString();
	});
}

function doRecordManuallyAction(action) {
	filterdata={};
	Object.keys(filterStoreData).forEach(function(key){
		if (filterStoreData[key] != "" && typeof( filterStoreData[key]) == "object" && filterStoreData[key].length > 0){
			filterdata[key] = filterStoreData[key];
		}

	});
	
	AUI().use('liferay-portlet-url', function(A) {
		console.log(config.recordManuallyPage);
		var e =  Liferay.PortletURL.createRenderURL();
		e.options.basePortletURL = baseUrl;
		e.setParameter("jspPage", config.recordManuallyPage);
		e.setParameter("formTypeName", modelName);
		e.setPortletId(namespace.replace(/(^\_+|\_+$)/mg, ''));
		e.setWindowState("normal");
		e.setParameter("filterData" , encodeURI(JSON.stringify(filterdata)));
		console.log(e.toString());
		
		console.log("path :: " + e.toString());
		window.location.href = e.toString();
	});
}

function storageStatus1(status,d,_baseUrl){
	showLoading(true);
	var c = findAncestor(d, "Row");
	var rownum = c.getAttribute("rownum");
	var enrolmentData = tableData[rownum].contentJson;
	if ((status == 'Cancelled' || status == 'Withdrawn') && enrolmentData && enrolmentData.EnrolmentStatus === 'Confirmed') {
		var switchProgrammeUrl = _baseUrl.replace('switchprogramme.jsp','cancelOrWithdraw.jsp') + "&schedule_code=" + enrolmentData.ScheduleCode + "&programme_code=" + enrolmentData.ProgrammeCode+ "&enrolmentId=" + enrolmentData.enrolmentId ;
		switchProgrammeUrl += "&_vm=" + (status == 'Cancelled' ? CANCEL_MODE : WITHDRAW_MODE);
		status = "PaidEnrolment"+status; // so it will not display popup before changing url
	    window.location.href =  switchProgrammeUrl;
	    return;
	}
	
	var a = [];
	for (var b = 0; b < c.childElementCount; b++) {
		a.push(c.children[b].textContent.trim())
	}
	var storageIdLocal = encodeURIComponent(a[0]);
	if(status == 'Active'){
		var popupdiv = "#active-record";
		var popupdivbox = "#active-record-box";
		updateStorageStatus1(status,d);
	}else if(status == 'Confirmed'){
		var popupdiv = "#active-record";
		var popupdivbox = "#active-record-box";
		updateStorageStatus1(status,d);
		
	}else if(status == 'Inactive' || status == 'Blacklist' || status == 'Cancelled' || status == 'Withdrawn' ){
		if(status == 'Inactive'){
			var popupdiv = "#deactive-record";
			var popupdivbox = "#deactive-record-box";
		}else if(status == 'Blacklist'){
			var popupdiv = "#blacklist-record";
			var popupdivbox = "#blacklist-record-box";
		}else if(status == 'Cancelled'){
			var popupdiv = "#cancel-record";
			var popupdivbox = "#cancel-record-box";
		}else if(status == 'Withdrawn'){
			var popupdiv = "#withdraw-record";
			var popupdivbox = "#withdraw-record-box";
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
				Y.one('.popup-reactivate').on(
						'click',
						function() {
							modal.hide();
							//storageStatus1("Active",d);rajjan
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
				Y.all('.popup-cancel-blacklist,.popup-withdraw-blacklist').on(
						'click',
						function() {
							modal.hide();
							AUI().one("#withdraw_reason").val("");
							AUI().one("#cancel_reason").val("");
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
				Y.one('.popup-confirm-cancellation').on(
						'click',
						function() {
							showLoading(false); 
							if(document.getElementById("cancel_reason").value.length > 4){
								//updateStorageStatus1(status,d);
								updateEnrolmentStatus(status,storageIdLocal);
								modal.hide();
							}else{
								document.getElementById("cancel_msg").classList.add("alert");
								document.getElementById("cancel_msg").classList.add("alert-error");
							}
						}
				);
				Y.one('.popup-confirm-withdraw').on(
						'click',
						function() {
							showLoading(false); 
							if(document.getElementById("withdraw_reason").value.length > 4){
								//updateStorageStatus1(status,d);
								updateEnrolmentStatus(status,storageIdLocal);
								modal.hide();
							}else{
								document.getElementById("withdraw_msg").classList.add("alert");
								document.getElementById("withdraw_msg").classList.add("alert-error");
							}
						}
				);
			});
			AUI().one("#withdraw_reason").val("");
			AUI().one("#cancel_reason").val("");
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
		if(status.toLowerCase() == 'notified'){
			var boundingBox = "#notified-success";
			var contentBox = "#notified-success-box";
		}
		if(status.toLowerCase() == 'withdrawn'){
			var boundingBox = "#withdraw-success";
			var contentBox = "#withdraw-success-box";
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
						var c = findAncestor(d, "Row");
						var a = [];
						for (var b = 0; b < c.childElementCount; b++) {
							a.push(c.children[b].textContent.trim())
						}
						showLoading(true); 
						var data = {"formType":modelName,"formStorageId": encodeURIComponent(a[0])};
						console.log(data);
						ajaxCall('GET','archive',ajaxurl,data,
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
		//window.location.href = e.toString();
		var pattern = /__/g;
		var dd = e.toString();
		window.location.href = dd.replace(pattern,"_");
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
	globalexportlisturl += "&"+namespace+"formType"+"="+modelName+"&"+namespace+"formStorageId"+"="+encodeURIComponent(a[0]);
    window.open(globalexportlisturl);
}
function globalExportList(e){
	e.preventDefault();
	e.stopPropagation();
	globalexportlisturl += "&"+namespace+"formType"+"="+modelName;
	window.open(globalexportlisturl);
//	ajaxCall('GET','exportList',globalexportlisturl,{"formType":modelName},
//	function() {
//	var result = "data:application/vnd.openxmlformats-officedocument.spreadsheetml.sheet," +btoa(unescape(encodeURIComponent(this.get("responseData"))));

//	window.open(result,'_blank');
//	console.log("success in downloading file");
//	},
//	function() {

//	});

}
function globalDeactivateList(d){
	alert('here' + d);
}
function globalArchiveList(){
	alert('here');
}
function showFilters(){
	var filterlist = document.getElementById("filterlist");
	var txt = "<ul>";
	var hasText = 0;
	Object.keys(filterStoreData).forEach(function(key) {
		if(filterStoreData[key] != ""){
			if(typeof(filterStoreData[key]) == "object"){
				Object.keys(filterStoreData[key]).forEach(function(key1) {
					txt += '<li style="display: inline-block;" onclick="removeFilter(\'' + key + '\',\''+ filterStoreData[key][key1]+'\')"> <a >'+ filterStoreData[key][key1] +' </a>  </li>';
					hasText = 1;
				})
			}
			else{
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
	jsFilterColumnList();

}
setTimeout(function(){  drawPagination(pageRequested); }, 3000);
