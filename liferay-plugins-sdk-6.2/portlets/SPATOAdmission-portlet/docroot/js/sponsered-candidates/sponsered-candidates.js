var freeTextArray = [];
// var filterdata=[{"contentJson.Status":["Active"]}];
var filterdata = [];
var sortbyArray = [];
var tableDataForSelection;
var selectedStorageId = [];
var paymentReqArrTMS;
var sortBy = {};
var eee;
var searchBox;
var mapOfTMC = new Object();
var mapOfAtoEmail=new Object();
var mapOfPending = new Object();
var modelName = "ATOAdmission";

function makePaging(totalPages, pageIndex) {
    var oPaging, i, j, k;
    var totalPages = parseInt(totalPages);
    pageIndex++;
    i = pageIndex;
    j = pageIndex - 1;
    k = pageIndex + 1;
    var oBefore = "",
        oAfter = "";
    var disable = false;
    if (i <= 1) {
        disable = true;
    }
    while (j != 0 && j != i - 6 && j > 0) {
        oBefore = "<li id1='" + j + "'><a  href='javascript:showPage(" + j + ")' data-index='" + (j - 1) + "'>" + j + "</a></li>" + oBefore;
        j--;
    }
    if (disable) {
        oBefore = "<li id2='" + (i - 1) + "'><a class='prev' href='javascript:void(0)' data-index='" + (i - 2) + "'>  </a></li>" + oBefore;
        oBefore = "<li id3='1'><a class='first' href='javascript:void(0)' data-index='1'>  </a></li>" + oBefore;
    } else {
        oBefore = "<li id4='" + (i - 1) + "'><a class='prev' href='javascript:showPage(" + (i - 1) + ")' data-index='" + (i - 2) + "'>  </a></li>" + oBefore;
        oBefore = "<li id5='1'><a class='first' href='javascript:showPage(1)' data-index='1'>  </a></li>" + oBefore;
    }
    for (; k <= totalPages && k < (i + 6) && k > 0; k++) {
        oAfter += "<li id6='" + k + "'><a  href='javascript:showPage(" + k + ")' data-index='" + (k - 1) + "'>" + k + "</a></li>";
    }
    disable = false;
    if (i >= totalPages) {
        disable = true;
    }
    if (disable) {
        oAfter += "<li id2='" + (i + 1) + "'><a class='next' href='javascript:void(0)' data-index='" + (i) + "'>  </a></li>";
        oAfter += "<li id2='" + (k - 1) + "'><a class='last' href='javascript:void(0)' data-index='" + (k - 2) + "'>  </a></li>";
    } else {
        oAfter += "<li id2='" + (i + 1) + "'><a class='next' href='javascript:showPage(" + (i + 1) + ")' data-index='" + (i) + "'>  </a></li>";
        oAfter += "<li id2='" + (totalPages - 1) + "'><a class='last' href='javascript:showPage(" + totalPages + ")' data-index='" + (totalPages - 2) + "'>  </a></li>";
    }

    oPaging = "<ul  class='pagination-content'>" + oBefore + "<li id3='" + i + "'><a class='selected' href='javascript:showPage(" + i + ")'>" +
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
//    console.log(rangeWithDots);
    return rangeWithDots;
}

function drawPagination(pageRequested) {
    document.getElementById("jslarge").innerHTML = "";
    pageRequested = 0;
    makePaging(totalPages, pageRequested);
    pagination(pageRequested, totalPages);
}

function showPage(page) {
    pageRequested = page;
    jsFilterColumnList();
}

function ajaxCall(method, action, ajaxUrl, data, successHandler, failHandler) {
    var thisInstance = this;

    thisInstance.namespace = namespace;
    AUI().use('aui-base', 'aui-io-request-deprecated', function(A) {
        var _data = {};
        _data[thisInstance.namespace + 'formStorageId'] = "";
        if (action == "update" || action == "loadData" || action == "loadList" || action == "archive" || action == "exportRow") {
            _data[thisInstance.namespace + 'formStorageId'] = data.formStorageId;
        }
        _data[thisInstance.namespace + 'formType'] = data.formType;
        _data[thisInstance.namespace + 'action'] = action;
        if (action == "update")
            _data[thisInstance.namespace + 'action'] = "persist";
        if (data) {
            _data[thisInstance.namespace + 'data'] = JSON.stringify(data);
        }
        A.io.request(ajaxUrl, {
            dataType: 'json',
            method: method,
            data: _data,
            on: {
                success: successHandler,
                failure: failHandler || function() {
                    thisInstance.debug("Error in the ajax call.");
                }
            }
        });
    });
}

function getFormFields() {
    if (modelName == "" || modelName == undefined) {
//        console.log("modelName Missing");
    } else {
        searchBox = document.getElementById(namespace + "searchtextbox");
        ajaxCall('GET', 'loadData', ajaxurl, {
                "formType": "configuration",
                "formStorageId": modelName
            },
            function() {
                var data = this.get("responseData");
                if (_.isEmpty(data)) {
//                    console.log("error");
                } else {
                    populateSearchFields(data);
                }
            },
            function() {

            });
    }

}

function getFilterFields() {
    if (modelName == "" || modelName == undefined) {
//        console.log("modelName Missing");
    } else {
        var jsonfilterparameter = {
            "modelName": modelName,
            "formType": modelName
        };
        ajaxCall('GET', 'filterColumnList', filtercolumnlisturl, jsonfilterparameter,
            function() {

                var data = this.get("responseData");
                if (_.isEmpty(data)) {
//                    console.log("error");
                    jsFilterColumnList();
                } else {
                    if (!data.distinct.hasOwnProperty('contentJson')) {
                        var c = {}
                        c.Status = ["Active", "Inactive", "Draft"];
                        data.distinct.contentJson = c;
                    }
                    data.distinct.contentJson.Status = ["Active", "Inactive", "Draft"];
                    renameFilterFields(data);
                    jsFilterColumnList();
                }
            },
            function() {
//                console.log("No such microservicemodel name" + modelName);
                jsFilterColumnList();
            });
    }
    return null;
}

function isnull(dataJSON) {
    if (dataJSON == "null" || dataJSON == null || dataJSON == "") {
        return true;
    } else {
        return false;
    }
}
var auditFields = "createdBy,createdDate,lastModifiedBy,lastModifiedDate";

function populateSearchFields(data) {
    availableColumns = [], columnsToShow = [];
    masterColumns = [];
    var obj = {};
    var allcolumns = data.contentJson.columnlist + "," + auditFields;
    masterColumns = allcolumns.split(',');
    if (data.storageId != "null") columnsToShow.push("storageId");
    columnsToShow.push("checkbox");

    if (!isnull(data.contentJson.column1)) columnsToShow.push(data.contentJson.column1);
    if (!isnull(data.contentJson.column2)) columnsToShow.push(data.contentJson.column2);
    if (!isnull(data.contentJson.column3)) columnsToShow.push(data.contentJson.column3);
    if (!isnull(data.contentJson.column4)) columnsToShow.push(data.contentJson.column4);
    if (!isnull(data.contentJson.column5)) columnsToShow.push(data.contentJson.column5);
    if (!isnull(data.contentJson.column6)) columnsToShow.push(data.contentJson.column6);
    if (!isnull(data.contentJson.column7)) columnsToShow.push(data.contentJson.column7);

    if (data.contentJson.columnlist != "null") columnlist = data.contentJson.columnlist;
    columnsToShow.push("");
    [].forEach.call(document.querySelectorAll('.form-fields-select :checked'), function(elm) {
        if (elm.value != 0) {
            exForm[elm.value] = elm.value;
        }
    })
    Object.keys(masterColumns).forEach(function(entry, key) {
        if (!exForm.hasOwnProperty(key)) {
            availableColumns.push(masterColumns[key]);
        }
    });
    var selectBoxNumber = 0,
        selectValue, selectText;
    [].forEach.call(document.querySelectorAll('.form-fields-select'), function(elm) {

        if (elm.options[elm.selectedIndex] != undefined) {
            var currkey = elm.options[elm.selectedIndex].text;
            var currvalue = elm.value;
            for (var j = elm.options.length; j >= 0; j--) {
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

        if (selectBoxNumber == 0) {
            selectValue = data.contentJson.column1;
        } else if (selectBoxNumber == 1 && data.contentJson.column2 != null) {
            selectValue = data.contentJson.column2;
        } else if (selectBoxNumber == 2 && data.contentJson.column3 != null) {
            selectValue = data.contentJson.column3;
        } else if (selectBoxNumber == 3 && data.contentJson.column4 != null) {
            selectValue = data.contentJson.column4;
        } else if (selectBoxNumber == 4 && data.contentJson.column5 != null) {
            selectValue = data.contentJson.column5;
        } else if (selectBoxNumber == 5 && data.contentJson.column6 != null) {
            selectValue = data.contentJson.column6;
        } else if (selectBoxNumber == 6 && data.contentJson.column7 != null) {
            selectValue = data.contentJson.column7;
        }
        selectBoxNumber++;
        o.value = selectValue;

        if (isnull(selectValue)) {
            selectText = "Select";
        } else {
        	if(selectValue === "FeeAmount(SGD)")
            {
            	//availableColumns[i] = "FeeAmount";
        		selectText = capitalizeFirstLetter("FeeAmount").replace(/([A-Z])/g, " $1");
            }
        	else
        	{
        		selectText = capitalizeFirstLetter(selectValue.replace(/([A-Z])/g, " $1"));
        	}
            
        }

        o.text = selectText;
        o.selected = 'selected';
        elm.appendChild(o);

        for (var i = 0; i < availableColumns.length; i++) {
            var o = document.createElement("option");
            o.value = availableColumns[i];
            if(availableColumns[i] === "FeeAmount(SGD)")
            {
            	//availableColumns[i] = "FeeAmount";
            	o.text = capitalizeFirstLetter("FeeAmount").replace(/([A-Z])/g, " $1");
            }
            else
            {
            	o.text = capitalizeFirstLetter(availableColumns[i]).replace(/([A-Z])/g, " $1");
            }            
            elm.appendChild(o);
        }
    })
    getFilterFields();

}

function capitalizeFirstLetter(string) {
    return string.charAt(0).toUpperCase() + string.slice(1);
}
var filterStoreData = {};

function renameFilterFields(filterFields) {
    ;
    YUI().use("node", "event", "escape", "aui-datepicker", function(A) {
        var container = A.one("#" + portletns + "double-column-container");
        container.empty();
        var rowid = 1;
        var eleid = 1;
        var firstHtmlRow = '<div id="' + portletns + 'double-column-row' + rowid + '"></div>';
        var firstrow = A.Node.create(firstHtmlRow);
        container.append(firstrow);

        if (typeof filterFields !== "undefined") {

            for (var h = 0; h < filterFields.titles.length; h++) {
                var key = filterFields.titles[h].key;
                var row = A.one("#" + namespace + "double-column-row" + rowid);
                for (var i = 0; i < filterFields.userInfo.length; i++) {
                    userArray[filterFields.userInfo[i].id] = filterFields.userInfo[i].name;
                }

                if (filterFields.distinct[key] != null || (key.includes("contentJson.") && (filterFields.distinct.contentJson[key.replace("contentJson.", "")] != null))) {

                    if ((filterStoreData.hasOwnProperty(key)) == false) {
                        filterStoreData[key] = [];
                    }
                    var optionval;
                    var someHtmlOption = '<span style="width:49%;display:inline-block" class="filter-element">' +
                        '<label for="' + portletns + key + '">' + filterFields.titles[h].value + '</label><select class="filterselect" id="' + portletns + key + '">' + '<option selected value>Select an option</option>';
                    if (key.includes("contentJson.")) {
                    	
                        var contentjsonkey = key.replace("contentJson.", "");

                        for (var i = 0; i < filterFields.distinct.contentJson[contentjsonkey].length; i++) {
                            optionval = filterFields.distinct.contentJson[contentjsonkey][i];
                            if (key != 'contentJson.subjects') {
                                if (filterStoreData[key] == optionval) {
                                    someHtmlOption += '<option g value="' + optionval + '" selected>' + optionval + '</option>';
                                } else {
                                    someHtmlOption += '<option h value="' + optionval + '">' + optionval + '</option>';
                                }
                            } 



                        }
                        someHtmlOption += '</select>';
                        someHtmlOption += '</span>';
                    } else {
                        for (var i = 0; i < filterFields.distinct[key].length; i++) {
                            optionval = filterFields.distinct[key][i];
                            var optiontext = optionval;
                            if (key == "createdBy" || key == "lastModifiedBy") {
                                if (typeof userArray[optionval] !== "undefined") {
                                    optiontext = userArray[optionval];
                                }

                            }
                            if (filterStoreData[key] == optionval) {
                                someHtmlOption += '<option value="' + optionval + '" selected>' + optiontext + '</option>';
                            } else {
                                someHtmlOption += '<option class="asd" value="' + optionval + '">' + optiontext + '</option>';
                            }
                        }
                        someHtmlOption += '</select>';
                        someHtmlOption += '</span>';
                    }
                    if(key != "contentJson.AtoName")
                    {
                    	var col = A.Node.create(someHtmlOption);
                    	
                    }
                    else
                    {	if(userType=="")
                    	{
                    	var col = A.Node.create(someHtmlOption);
                    	}
                    	else
                    	{
                    	eleid--;
                    	}
                    }
                    row.append(col);
                    if (eleid && ((eleid % 2) == 0)) {
                        var rowcontainer = A.one("#" + namespace + "double-column-container");
                        rowid++;
                        var someHtmlRow = '<div id="' + portletns + 'double-column-row' + rowid + '"></div>';
                        var newrow = A.Node.create(someHtmlRow);
                        rowcontainer.append(newrow);
                    }
                    eleid++;
                }
                if (filterFields.datepicker != null && filterFields.datepicker.includes(key)) {
                    if ((filterStoreData.hasOwnProperty(key)) == false) {
                        filterStoreData[key] = [];
                    }

                    var someHtmlDatePick = '<span style="width:50%;display:inline-block" class="filter-element">' +
                        '<label for="' + portletns + key + '">' + filterFields.titles[h].value + '</label><div class="input-group"><input id="' + portletns + key + '" type="text" value="' + filterStoreData[key] + '" readOnly class="filtertext form-control  filter-datepicker" style="width:95%;cursor: pointer;">' +
                        '<span class="input-group-add-on"><i class="icon-calendar icon-white" ></i></span></div>' +
                        '</span>';
                    var col = A.Node.create(someHtmlDatePick);
                    row.append(col);
                    if (eleid && ((eleid % 2) == 0)) {
                        var rowcontainer = A.one("#" + namespace + "double-column-container");
                        rowid++;
                        var someHtmlRow = '<div id="' + portletns + 'double-column-row' + rowid + '"></div>';
                        var newrow = A.Node.create(someHtmlRow);
                        rowcontainer.append(newrow);
                    }
                    eleid++;
                }


            }
            if (filterFields.datepicker != null) {
                A.all(".filter-datepicker").each(function(subNode) {
                    var datePicker = new A.DatePicker({
                        trigger: "#" + subNode.get("id"),
                        popover: {
                            zIndex: 1000,
                        },
                        mask: '%d/%m/%Y',
                        calendar: {
                        	maximumDate : new Date(),
//                            on: {
//                                dateClick: function(event) {
//                                    subNode.set('value', A.Date.format(event.date, {
//                                        format: datePicker.get('mask')
//                                    }));
//                                }
//                            }
                        }
                    });


                });
            }

        }

        var buttonrow = A.one("#" + namespace + "double-column-container");
        var htmlButtonSpan = '<div class="text-center userAction"></div>';
        var buttonspan = A.Node.create(htmlButtonSpan);
        buttonrow.append(buttonspan);
        var someHtmlButton = '<button id="' + portletns + 'button' + rowid + '" class="btn btn-primary search">Search</button>';
        var filterbtn = A.Node.create(someHtmlButton);
        filterbtn.on('click', function(e) {

            e.preventDefault();
            e.stopPropagation();
            document.getElementsByClassName("orderIcon")[0].click();
            filterdata = [];
            for (var h = 0; h < filterFields.titles.length; h++) {
                var key = filterFields.titles[h].key;
                var escapedkey = key.replace(".", "\\.");
                var inputfield = A.one("#" + portletns + escapedkey);
//                console.log(key);
                var inputval = inputfield ? inputfield.get('value') : null;
                if (inputval) {
                    var filter = {};
                    var aa = filterStoreData[key];
                    var bb = [];
                    if (key == "contentJson.ProgrammeCode" || key == "contentJson.ScheduleCode") {
                        aa = [];
                    }
                    if (!aa.includes(inputval)) {
                    	aa=[];
                        aa.push(inputval);                      
                    }
                    if (key == "createdDate" || key == "lastModifiedDate") {
                    	debugger
                    	bb.push(inputfield._node.value);
                    }
                    else
                    	{
                    	bb.push(inputfield._node.options[inputfield._node.options.selectedIndex].text);
                    	}
                    filter[key] = aa;
                    filterStoreData[key] = bb;
                    filterdata.push(filter);
                    pageRequested = 1;
                }

            }
            jsFilterColumnList();
        });
        var someHtmlClearButton = '<button id="' + portletns + 'clrbutton' + rowid + '" class="btn btn-default clear">RESET</button>';
        var clearbtn = A.Node.create(someHtmlClearButton);
        clearbtn.on('click', function(e) {
            var selects = document.getElementsByClassName('filterselect');
            var sel;
            var relevantSelects = [];
            for (var z = 0; z < selects.length; z++) {
                sel = selects[z];
                sel.selectedIndex = 0;
            }
            var selects = document.getElementsByClassName('filtertext');
            var sel;
            var relevantSelects = [];
            for (var z = 0; z < selects.length; z++) {
                sel = selects[z];
                sel.value = "";
            }

            Object.keys(filterStoreData).forEach(function(key) {
                filterStoreData[key] = [];
            });
            document.getElementsByClassName("orderIcon")[0].click();
            e.preventDefault();
            e.stopPropagation();
            filterdata = [];
            freeTextArray = [];
            sortbyArray = [];
            jsFilterColumnList();
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

function jsElasticSearchList(e, d) {
    if (e.which != 13)
        return;
    if (freeTextArray.indexOf(d) == -1 && d != "" && d.length > 0) {
        freeTextArray.push(d);
        searchBox.value = "";
        pageRequested = 1;
        jsFilterColumnList();
    }

}

function loadList() {

	console.log("load list:1 ");
    showFilters();
    var itemsSelect = document.getElementById(namespace + "itemsPerPage");
    itemsPerPage = itemsSelect.options[itemsSelect.selectedIndex].value;
    var jsonfilterparameter = {
        "limit": itemsPerPage,
        "modelName": modelName,
        "page": (pageRequested - 1),
        "formType": modelName
    };
    if(atoName !== "")
    {
	    var filter = {};
	    var res = atoName.split(",");
	    filter["contentJson.AtoId"]=res;
	    filterdata.push(filter);
    }
    jsonfilterparameter["filterdata"] = filterdata;

    jsonfilterparameter["conditions"] = freeTextArray;
    jsonfilterparameter["sortby"] = sortbyArray;
    if (typeof selectedCategory !== "undefined" && selectedCategory && selectedCategory !== null && selectedCategory !== "") {
        jsonfilterparameter["selectedCategory"] = selectedCategory;
    }
    showLoading(true);
    ajaxCall('GET', 'elastiSearchList', elastisearchlisturl, jsonfilterparameter,
        function() {
    	console.log("load list:2 ");
            var data = this.get("responseData");
            showLoading(false);
            if (_.isEmpty(data)) {
//                console.log("error");

            } else {
                tableDataForSelection = data.content;
                tableData = data.content;
                totalRecords = data.totalElements;
                totalPages = data.totalPages;
                reloadTable(tableData, true);
                for (var b = 0; b < tableData.length; b++) {
                    mapOfTMC[tableData[b].storageId] = tableData[b].contentJson.TransactionMasterCode;
                    mapOfAtoEmail[tableData[b].storageId] = tableData[b].contentJson.AtoEmailId;
                    mapOfPending[tableData[b].storageId] = tableData[b].contentJson.ProcessStatus;
//                    console.log("DATA::" + JSON.stringify(mapOfTMC));

                }
                if (pageRequested == 1) {
                    drawPagination(pageRequested)
                }

            }

        },
        function() {

        });
}

function jsFilterColumnList() {
 
    showFilters();
    var itemsSelect = document.getElementById(namespace + "itemsPerPage");
    itemsPerPage = itemsSelect.options[itemsSelect.selectedIndex].value;
    var jsonfilterparameter = {
        "limit": itemsPerPage,
        "modelName": modelName,
        "page": (pageRequested - 1),
        "formType": modelName
    };
//    console.log("atoName:::::"+atoName);
    if(atoName !== "")
	{
	    var filter = {};
	    var res = atoName.split(",");
	    filter["contentJson.AtoId"]=res;
	    filterdata.push(filter);
	}
    jsonfilterparameter["filterdata"] = filterdata;
    // document.getElementsByName("selectval").checked = false;



    jsonfilterparameter["conditions"] = freeTextArray;
    jsonfilterparameter["sortby"] = sortbyArray;
    if (typeof selectedCategory !== "undefined" && selectedCategory && selectedCategory !== null && selectedCategory !== "") {
        jsonfilterparameter["selectedCategory"] = selectedCategory;
    }
    showLoading(true);
    ajaxCall('GET', 'elastiSearchList', ajaxurl, jsonfilterparameter,
        function() {
            showLoading(false);
            var data = this.get("responseData");
            if (_.isEmpty(data)) {
//                console.log("error");

            } else {
                tableData = data.content;
                tableDataForSelection = data.content;
                totalRecords = data.totalElements;
                totalPages = data.totalPages;
                if(freeTextArray.length>0 || filterdata.length>0)
                	{
                reloadTable(tableData, true);
                	}
                else
                	{
                	  reloadTable(tableData, false);
                	}
                for (var b = 0; b < tableData.length; b++) {
                    mapOfTMC[tableData[b].storageId] = tableData[b].contentJson.TransactionMasterCode;
                    mapOfAtoEmail[tableData[b].storageId] = tableData[b].contentJson.AtoId;
                    mapOfPending[tableData[b].storageId] = tableData[b].contentJson.ProcessStatus;


                }
//                console.log(JSON.stringify(tableData))
                if (pageRequested == 1) {
                    drawPagination(pageRequested)
                } else {
                    makePaging(totalPages, pageRequested - 1);
                    pagination(pageRequested, totalPages);
                }
            }

        },
        function() {

        });

}


function reloadTable(a, isSearchList) {
	
    var table = document.getElementById("tableId");
    var tbody = document.querySelector("#tableId tbody");
    var allheadings = document.querySelectorAll("#tableId .Heading")[0];

    if (a.length > 0) {

        while (allheadings.firstChild) {
            allheadings.removeChild(allheadings.firstChild);
        }

        for (var j = 0; j < columnsToShow.length; j++) {
            var th = document.createElement('th');
            
            var italic = document.createElement('i');
            if (columnsToShow[j] === "checkbox") {
                var text = document.createTextNode(checkbox);
                th.appendChild(checkbox);
            } else {
            	
                var text = document.createTextNode(columnsToShow[j]);
                if(columnsToShow[j]==="FeeAmount(SGD)")
        		{
        		th.style.textAlign="right";
        		}
                th.appendChild(text);
            }

            th.appendChild(italic);
            if (sortbyArray.length > 0 && sortbyArray[0].field == columnsToShow[j]) {
                th.classList.add("listsort" + sortbyArray[0].direction);
            }
            if (j == 0) th.style.display = "none";
            allheadings.appendChild(th);
        }

        var tr = document.createElement('tr');
        var td = document.createElement('td');
        var text = document.createTextNode("aaa");
        td.appendChild(text);
        td.style.display = "none";
        tr.appendChild(td);

        var td = document.createElement('td');
        var text = document.createTextNode(checkbox);
        td.appendChild(checkbox);
        tr.appendChild(td);
        tr.className += " Row ";
        tbody.appendChild(tr);

        for (var j = 1; j < columnsToShow.length - 2; j++) {
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
            if (columnsToShow[g] !== "checkbox") {
            	if(columnsToShow[g] === "FeeAmount")
            		{
            		th[g].innerHTML = "<span>" + "Fee Amount (SGD)" + "</span><i></i>";
            		}
            	else if(columnsToShow[g] === "AtoName")
            		{
            		th[g].innerHTML = "<span>" + "ATO Name" + "</span><i></i>";
            		}
            	else
            		{
            		  th[g].innerHTML = "<span>" + columnsToShow[g].replace(/([a-z0-9])([A-Z])/g, '$1 $2') + "</span><i></i>";
            		}
            } else {
                th[g].appendChild(checkbox);
            }
        }
        clearTableData();
        var e;
        for (var c = 0; c < a.length; c++) {
            var rowclone = f.cloneNode(true);
            e = rowclone.querySelectorAll("td");
            e[0].innerHTML = a[c][columnsToShow[0]];
            // e[1].appendChild(checkbox);
            for (var i = 2; i < columnsToShow.length - 1; i++) {
                if (typeof a[c].contentJson[columnsToShow[i]] === "undefined") {
                    if (columnsToShow[i] == "createdDate" || columnsToShow[i] == "lastModifiedDate") {
                        var ee = new Date(Date.parse(a[c][columnsToShow[i]]));
                        var date = (ee.getDate() + '/' + (ee.getMonth() + 1) + '/' + ee.getFullYear());
                        e[i].innerHTML = date;
                    } else if (columnsToShow[i] == "createdBy" || columnsToShow[i] == "lastModifiedBy") {
                        e[i].innerHTML = a[c][columnsToShow[i]];
                        if (typeof userArray[a[c][columnsToShow[i]]] !== "undefined") {
                            e[i].innerHTML = userArray[a[c][columnsToShow[i]]];
                        }
                    } else {
                        e[i].innerHTML = (a[c].contentJson[columnsToShow[i]] === undefined ? "" : a[c].contentJson[columnsToShow[i]]);
                    }

                } else {

                    e[i].innerHTML = (a[c].contentJson[columnsToShow[i]] === undefined ? "" : a[c].contentJson[columnsToShow[i]]);
                    if (columnsToShow[i] == "PaymentDueDate") {
                        var dueDate = a[c].contentJson[columnsToShow[i]].split("T")[0].split("-");
                        e[i].innerHTML = dueDate[2] + "/" + dueDate[1] + "/" + dueDate[0];
                    }
                    if (columnsToShow[i] === "ProcessStatus") {
                        if (a[c].contentJson["ProcessStatus"] === "PENDING") {
                        	for(var p=0;p<e[i + 1].lastElementChild.children[1].lastElementChild.children.length;p++)
                        	{
                        		if(e[i + 1].lastElementChild.children[1].lastElementChild.children[p].textContent=="Send Invoice(s)")
                        		{
                        			e[i + 1].lastElementChild.children[1].lastElementChild.children[p].className = " disabled ";
                        		}
//                        		if(e[i + 1].lastElementChild.children[1].lastElementChild.children[p].textContent=="Download Invoice(s)")
//                    			{
//                        			e[i + 1].lastElementChild.children[1].lastElementChild.children[p].className = " disabled ";
//                    			}         			
                        	}
                            //e[i + 1].lastElementChild.children[1].lastElementChild.children[2].className = " disabled ";
                            //e[i + 1].lastElementChild.children[1].lastElementChild.children[4].className = " disabled ";
                            e[i].classList.add("pending-button");
                        } else if (a[c].contentJson["ProcessStatus"] === "VERIFIED") {
                        	
                        	for(var p=0;p<e[i + 1].lastElementChild.children[1].lastElementChild.children.length;p++)
                        	{
                        		if(e[i + 1].lastElementChild.children[1].lastElementChild.children[p].textContent=="Mark as verified")
                        		{
                        			e[i + 1].lastElementChild.children[1].lastElementChild.children[p].className = " disabled ";
                        		}
                        		if(e[i + 1].lastElementChild.children[1].lastElementChild.children[p].textContent=="Mark as 'Self Sponsored'")
                    			{
                        			e[i + 1].lastElementChild.children[1].lastElementChild.children[p].className = " disabled ";
                    			}   
//                        		if(e[i + 1].lastElementChild.children[1].lastElementChild.children[p].textContent=="Download Invoice(s)")
//                    			{
//                        			e[i + 1].lastElementChild.children[1].lastElementChild.children[p].className = " disabled ";
//                    			}   
                        	}
                        	 // e[i + 1].lastElementChild.children[1].lastElementChild.children[0].className = " disabled ";
                             // e[i + 1].lastElementChild.children[1].lastElementChild.children[1].className = " disabled ";
                             // e[i + 1].lastElementChild.children[1].lastElementChild.children[4].className = " disabled ";
                            e[i].classList.add("verify-button");
                        } else if (a[c].contentJson["ProcessStatus"] === "INVOICED") {
                        	for(var p=0;p<e[i + 1].lastElementChild.children[1].lastElementChild.children.length;p++)
                        	{
                        		if(e[i + 1].lastElementChild.children[1].lastElementChild.children[p].textContent=="Mark as verified")
                        		{
                        			e[i + 1].lastElementChild.children[1].lastElementChild.children[p].className = " disabled ";
                        		}
                        		if(e[i + 1].lastElementChild.children[1].lastElementChild.children[p].textContent=="Mark as 'Self Sponsored'")
                    			{
                        			e[i + 1].lastElementChild.children[1].lastElementChild.children[p].className = " disabled ";
                    			}   
                        	}
                        	// e[i + 1].lastElementChild.children[1].lastElementChild.children[0].className = " disabled ";
                            // e[i + 1].lastElementChild.children[1].lastElementChild.children[1].className = " disabled ";
                            e[i].classList.add("invoiced-button");
                        }
                    }
                    if(columnsToShow[i]==="FeeAmount(SGD)")
                    	{
                    	e[i].style.textAlign="right";
                    	e[i].innerHTML=formatMoney(a[c].contentJson[columnsToShow[i]], 2, ".", ",");
                    	}
                }
            }

            if (a[c].contentJson.Status == "Active" && e[columnsToShow.length - 1].getElementsByClassName("activate").length > 0) {
                e[columnsToShow.length - 1].getElementsByClassName("activate")[0].style.display = "none";
            } else if (a[c].contentJson.Status == "Inactive" && e[columnsToShow.length - 1].getElementsByClassName("deactivate").length > 0) {
                e[columnsToShow.length - 1].getElementsByClassName("deactivate")[0].style.display = "none";
            } else if (a[c].contentJson.Status == "Draft") {
                e[columnsToShow.length - 1].getElementsByClassName("deactivate")[0].style.display = "none";
                e[columnsToShow.length - 1].getElementsByClassName("activate")[0].style.display = "none";
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
                var nodeHtml = eee.currentTarget._node.innerHTML.replace(/\s/g, '');
                var nodeTxt = eee.currentTarget._node.innerText.replace(/\s/g, '');
                var popupcontainer = A.all("th");
                popupcontainer.removeClass("sortField");
                sortbyArray = [];

                if (sortBy.field == nodeTxt) {
                    if (sortBy.direction == "asc") {
                        sortBy.direction = "desc";
                    } else {
                        sortBy.direction = "asc";
                    }
                } else {
                    sortBy.direction = "asc";
                }
                sortBy.field = node.firstElementChild.innerHTML.replace(/\s/g, '');

                if (auditFields.indexOf(nodeTxt) != -1) {
                    sortBy.contentJSON = "false";
                } else {
                    sortBy.contentJSON = "true";
                }
                sortbyArray.push(sortBy);
//                console.log(sortbyArray);
                jsFilterColumnList();
            })

        })
        YUI().use('aui-node', 'aui-io-request', 'liferay-util-window', 'aui-io-plugin-deprecated',
            'stylesheet', 'aui-datepicker', 'overlay', 'event', 'widget-anim',
            function(A) {

                var container = A.one('body');
                container.on('click', function(e) {
                    var actionsBox = document.getElementsByClassName('Pop-Action');
                    for (var k = 0; k < actionsBox.length; k++) {

                        actionsBox[k].classList.add('hide');
                    }
                });

            });
        document.getElementsByClassName('data-lising')[0].style.display = "block";
        document.getElementsByClassName('pagination')[0].style.display = "block";
        document.getElementsByClassName('no-data-listing')[0].style.display = "none";
    } else {
        document.getElementsByClassName('data-lising')[0].style.display = "none";
        document.getElementsByClassName('pagination')[0].style.display = "none";
        document.getElementsByClassName('no-data-listing')[0].style.display = "block";
        if (!isSearchList) {
            document.querySelector("h3.no-data-listing-message").innerHTML = "No " + modelName + " record present.";
            document.querySelector("p.no-data-listing-message").innerHTML = "There aren't any records of existing " + modelName + "'s as of now.\nIf you would like to create a new one, please click on the 'ADD NEW' button.";
        } else {
//            document.querySelector("h3.no-data-listing-message").innerHTML = "Search Results for " + modelName;
        	document.querySelector("h3.no-data-listing-message").innerHTML = "";
            document.querySelector("p.no-data-listing-message").innerHTML = "No search results were found for your query";
        }
    }

}

function selectThisValue(d) {


    AUI().use('liferay-portlet-url', function(A) {
        var c = findAncestor(d, "Row");

        if (c != null) {
            paymentReqArrTMS = "";
            var a = [];
            for (var b = 0; b < c.childElementCount; b++) {
                a.push(c.children[b].textContent.trim())
            }
//            console.log("storage Id :: " + a[0]);
            if (d.checked) {
//                var checkboxes = document.querySelectorAll("input[type='checkbox']");
//                checkboxes.forEach(function(elem) {
//                    elem.checked = true;
//                });

                selectedStorageId.push(a[0]);
                paymentReqArrTMS = "";
                tableDataForSelection = d.id;


            } else {
//                var checkboxes = document.querySelectorAll("input[type='checkbox']");
//                checkboxes.forEach(function(elem) {
//                    elem.checked = false;
//                });

                paymentReqArrTMS = "";
                var index = selectedStorageId.indexOf(a[0]);
                if (index > -1) {
                    selectedStorageId.splice(index, 1);
                }
//                console.log("2:" + JSON.stringify(selectedStorageId));
            }
            checkForPending();
         //   checkForVerified();
        } else {
            paymentReqArrTMS = "";
            selectedStorageId = [];
            if (d.checked) {
                tableDataForSelection = d.id;
//                console.log(JSON.stringify(tableData));
                for (var b = 0; b < tableData.length; b++) {
                    selectedStorageId.push(tableData[b].storageId);
                }
                var checkboxes = document.querySelectorAll("input[type='checkbox']");
                checkboxes.forEach(function(elem) {
                    elem.checked = true;
                });


//                console.log("3:" + JSON.stringify(selectedStorageId));
            } else {

                paymentReqArrTMS = "";
                selectedStorageId = [];
//                console.log("4:" + JSON.stringify(selectedStorageId));
                var checkboxes = document.querySelectorAll("input[type='checkbox']");
                checkboxes.forEach(function(elem) {
                    elem.checked = false;
                });

            }
            checkForPending();
            //checkForVerified();
        }
        checkForPending();
     //   checkForVerified();


    });


}

function selfSponsored() {


    var data = {};
//    console.log(JSON.stringify(selectedStorageId));
    var mainData = {};

    mainData["storageIds"] = selectedStorageId;
    data["contentJson"] = mainData;

    ajaxCall('POST', 'scanedData', ajaxurl, data,


        function() {


            var contentdata = this.get("responseData");
            var responseData = [];

            if (contentdata.error) {
                displayMessage('danger', contentdata.error, 3000);
                selectedStorageId = [];

            } else {
                displayMessage('success',
                    contentdata.message, 3000);
                var checkboxes = document.querySelectorAll("input[type='checkbox']");
                checkboxes.forEach(function(elem) {
                    elem.checked = false;
                });

                selectedStorageId = [];
                jsFilterColumnList();

            }

        },
        function() {
            displayMessage('danger',
                "Error in persisting dynamic form data.", 3000);
            callback();
        });
    selectedStorageId = [];

}

function singleSelfSponsored(d) {

    selectedStorageId = [];
    AUI().use('liferay-portlet-url', function(A) {
        var c = findAncestor(d, "Row");
        var a = [];
        for (var b = 0; b < c.childElementCount; b++) {
            a.push(c.children[b].textContent.trim())
        }
//        console.log("storage Id :: " + a[0]);

        selectedStorageId.push(a[0]);
//        console.log(JSON.stringify(a));

        selfSponsored();



    });
}

function singleMarkAsVerify(d) {


	selectedStorageId = [];
    AUI().use('liferay-portlet-url', function(A) {
        var c = findAncestor(d, "Row");

        var a = [];
        for (var b = 0; b < c.childElementCount; b++) {
            a.push(c.children[b].textContent.trim())
        }
//        console.log("storage Id :: " + a[0]);

        selectedStorageId.push(a[0]);
//        console.log(JSON.stringify(a));
        markAsVerify();


    });
}

function markAsVerify() {


    var data = {};
    console.log("Mark as Verified 1");
    var mainData = {};

    mainData["storageIds"] = selectedStorageId;
    data["contentJson"] = mainData;
    data["status"] = "VERIFIED";

    ajaxCall('POST', 'processStatus', ajaxurl, data,


        function() {


            var contentdata = this.get("responseData");
            var responseData = [];

            if (contentdata.error) {
                displayMessage('danger', contentdata.error, 3000);

            } else {
                displayMessage('success',
                    contentdata.message, 3000);
                var checkboxes = document.querySelectorAll("input[type='checkbox']");
                checkboxes.forEach(function(elem) {
                    elem.checked = false;
                });
                console.log("Mark as Verified 2");
                selectedStorageId = [];
                document.getElementsByName("selectval").checked = false;
               // jsFilterColumnList();
//                setTimeout(loadList(), 2000);
                loadList();

            }

        },
        function() {
            displayMessage('danger',
                "Error in persisting dynamic form data.", 3000);
            callback();
        });
    selectedStorageId = [];

}


function singleSendInvoice(d) {

	selectedStorageId=[];
    AUI().use('liferay-portlet-url', function(A) {
        var c = findAncestor(d, "Row");
        var a = [];
        for (var b = 0; b < c.childElementCount; b++) {
            a.push(c.children[b].textContent.trim())
        }
        
//        console.log("storage Id11 :: " + a);
       
        mapOfAtoEmail[a[0]];
        selectedStorageId.push(a[0]);
//        console.log(JSON.stringify(a));

        sendInvoice(d);



    });
}

function singleDownloadPDF(d, event) {

	selectedStorageId=[];
    AUI().use('liferay-portlet-url', function(A) {
        var c = findAncestor(d, "Row");
        var a = [];
        for (var b = 0; b < c.childElementCount; b++) {
            a.push(c.children[b].textContent.trim())
        }
//        console.log("storage Id :: " + a[0]);

        selectedStorageId.push(a[0]);
//        console.log(JSON.stringify(a));

        downloadPDF(event);



    });
}


function sendInvoicePopup(d) {

    AUI().use('aui-base', function(A) {
        var boundingBox = "#invoice-success";
        var contentBox = "#invoice-success-box";
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
        });

    });
}


function downloadPDF(e) {

    var data = {};
//    console.log(JSON.stringify(selectedStorageId));
    var mainData = {};

    mainData["storageIds"] = selectedStorageId;
    data["contentJson"] = mainData;
    e.preventDefault();
    e.stopPropagation();
    filterdata = [];
    Object.keys(filterStoreData).forEach(function(key) {
        var filter = {};
        if (filterStoreData[key] != "" && typeof(filterStoreData[key]) == "object" && filterStoreData[key].length > 0) {
            filter[key] = filterStoreData[key];
            filterdata.push(filter);
        }
    });


    selectedStorageId = [];
    window.location.reload();
    window.open(downloadPdfUrl + "&" + namespace + "formType" + "=" + modelName + "&" + namespace + "data=" + encodeURIComponent(JSON.stringify(data)));
}

function payOnline(d) {

    AUI().use('liferay-portlet-url', function(A) {
        var c = findAncestor(d, "Row");
        var a = [];
        for (var b = 0; b < c.childElementCount; b++) {
            a.push(c.children[b].textContent.trim())
        }
//        console.log("storage Id :: " + JSON.stringify(a));
//        console.log("storage Id :: " + a[0]);

        selectedStorageId.push(a[0]);
//        console.log("TMSCODE::" + mapOfTMC[a[0]]);

        window.open(window.location.href + "/../online-payment?id=" + (mapOfTMC[a[0]].toUpperCase().trim()),"_self");
    });

}




function makePaymentArr() {
    paymentReqArrTMS = "";
    for (var i = 0; i < selectedStorageId.length; i++) {
        paymentReqArrTMS = paymentReqArrTMS + mapOfTMC[selectedStorageId[i]] + ',';

    }
    if (paymentReqArrTMS.endsWith(",")) {
        paymentReqArrTMS = paymentReqArrTMS.substring(0, paymentReqArrTMS.length - 1);
    }
//    console.log(paymentReqArrTMS);
    window.open(window.location.href + "/../online-payment?id=" + (paymentReqArrTMS.toUpperCase().trim()),"_self");
}

function sendInvoice(d) {

	debugger
    var data = {};
//    console.log(JSON.stringify(selectedStorageId));
    var mainData = [];
    for (var i = 0; i < selectedStorageId.length; i++) {
    	var dataDet = {};
    	dataDet["storageIds"] = selectedStorageId[i];
    	dataDet["atoId"]=mapOfAtoEmail[selectedStorageId[i]];
    	mainData.push(dataDet);
    }
//    console.log(mainData);
    data["contentJson"] = mainData;
    // data["status"]="VERIFIED";
    showLoading(true);
    ajaxCall('POST', 'sendInvoice', ajaxurl, data,


        function() {

            showLoading(false);
            var contentdata = this.get("responseData");
            var responseData = [];

            if (contentdata.error) {
                displayMessage('danger', contentdata.error, 3000);

            } else {
                // displayMessage('success',
                // contentdata.message, 3000);
                sendInvoicePopup(d);
                var checkboxes = document.querySelectorAll("input[type='checkbox']");
                checkboxes.forEach(function(elem) {
                    elem.checked = false;
                });

                selectedStorageId = [];
                document.getElementsByName("selectval").checked = false;
                jsFilterColumnList();

            }


        },
        function() {
            displayMessage('danger',
                "Error in persisting dynamic form data.", 3000);
            callback();
        });
    selectedStorageId = [];

}
function checkForVerified()
{
	  var flagOfVerified = false;
//	 console.log("checkForPending:::" + JSON.stringify(selectedStorageId));
	    var flagOfPending = false;
	    var flagOfVerified = false;
	    var flagOfInvoiced = false;
	    for (var i = 0; i < selectedStorageId.length; i++) {
	 
	        if (mapOfPending[selectedStorageId[i]] === "VERIFIED") {
	            flagOfVerified = true;
	        }
	        if (flagOfVerified == true) {
	            document.getElementById("mainpopup").children[0].className = "disabled";
	            document.getElementById("mainpopup").children[1].className = "disabled";
	            document.getElementById("mainpopup").children[4].className = "disabled";
	        } else {
//	            console.log("flagOfPending:::" + flagOfPending);
	            document.getElementById("mainpopup").children[0].classList.remove("disabled");
	            document.getElementById("mainpopup").children[1].classList.remove("disabled");
	            document.getElementById("mainpopup").children[4].classList.remove("disabled");
	        }

	    }
	}
function checkForPending() {
//    console.log("checkForPending:::" + JSON.stringify(selectedStorageId));
    var flagOfPending = false;
    var flagOfVerified = false;
    var flagOfInvoiced = false;
    for (var i = 0; i < selectedStorageId.length; i++) {
        if (mapOfPending[selectedStorageId[i]] === "PENDING") {
            flagOfPending = true;
        }
        if (mapOfPending[selectedStorageId[i]] === "VERIFIED") {
            flagOfVerified = true;
        }
        if (mapOfPending[selectedStorageId[i]] === "INVOICED") {
            flagOfInvoiced = true;
        }

    }
    
    if(selectedStorageId.length > 0)
    {
    	for(var p=0;p<document.getElementById("mainpopup").children.length;p++)
    	{
    		if(document.getElementById("mainpopup").children[p].children[1].textContent=="Make Payment(s)")
    		{
    			document.getElementById("mainpopup").children[p].classList.remove("disabled");
    		}
        	
        	if(document.getElementById("mainpopup").children[p].children[1].textContent=="Export")
    		{
    			document.getElementById("mainpopup").children[p].classList.remove("disabled");
    		}
        	
        	if(document.getElementById("mainpopup").children[p].children[1].textContent=="Download Invoice(s)")
    		{
    			document.getElementById("mainpopup").children[p].classList.remove("disabled");
    		}
        	
        	if(document.getElementById("mainpopup").children[p].children[1].textContent=="Mark as 'Self Sponsored'")
    		{
    			document.getElementById("mainpopup").children[p].classList.remove("disabled");
    		}
        	
        	if(document.getElementById("mainpopup").children[p].children[1].textContent=="Mark as verified")
    		{
    			document.getElementById("mainpopup").children[p].classList.remove("disabled");
    		}
        	
        	if(document.getElementById("mainpopup").children[p].children[1].textContent=="Send Invoice(s)")
    		{
    			document.getElementById("mainpopup").children[p].classList.remove("disabled");
    		}
    	}
    }
    
    if (flagOfPending == true) {
    	for(var p=0;p<document.getElementById("mainpopup").children.length;p++)
    		{
    		if(document.getElementById("mainpopup").children[p].children[1].textContent=="Send Invoice(s)")
    		{
    			document.getElementById("mainpopup").children[p].className = "disabled";
    		}
//    		if(document.getElementById("mainpopup").children[p].children[1].textContent=="Download Invoice(s)")
//    		{
//    			document.getElementById("mainpopup").children[p].className = "disabled";
//    		}
        
    		}
    } else {
//        console.log("flagOfPending:::" + flagOfPending);
        for(var p=0;p<document.getElementById("mainpopup").children.length;p++)
		{
		if(document.getElementById("mainpopup").children[p].children[1].textContent=="Send Invoice(s)")
		{
			document.getElementById("mainpopup").children[p].classList.remove("disabled");
		}
		if(document.getElementById("mainpopup").children[p].children[1].textContent=="Download Invoice(s)")
		{
			document.getElementById("mainpopup").children[p].classList.remove("disabled");
		}
    
		}
      
    }
    if (flagOfVerified == true) {
    	
    	for(var p=0;p<document.getElementById("mainpopup").children.length;p++)
		{
			if(document.getElementById("mainpopup").children[p].children[1].textContent=="Mark as verified")
			{
				document.getElementById("mainpopup").children[p].className = "disabled";
			}
			if(document.getElementById("mainpopup").children[p].children[1].textContent=="Mark as 'Self Sponsored'")
			{
				document.getElementById("mainpopup").children[p].className = "disabled";
			}
//			if(document.getElementById("mainpopup").children[p].children[1].textContent=="Download Invoice(s)")
//			{
//				document.getElementById("mainpopup").children[p].className = "disabled";
//			}
    
		}
    	
    	
//        document.getElementById("mainpopup").children[0].className = "disabled";
//        document.getElementById("mainpopup").children[1].className = "disabled";
//        
//        document.getElementById("mainpopup").children[4].className = "disabled";
    } else {
    	for(var p=0;p<document.getElementById("mainpopup").children.length;p++)
		{
			if(document.getElementById("mainpopup").children[p].children[1].textContent=="Mark as verified")
			{
				document.getElementById("mainpopup").children[p].classList.remove("disabled");
			}
			if(document.getElementById("mainpopup").children[p].children[1].textContent=="Mark as 'Self Sponsored'")
			{
				document.getElementById("mainpopup").children[p].classList.remove("disabled");
			}
			if(document.getElementById("mainpopup").children[p].children[1].textContent=="Download Invoice(s)")
			{
				 if(!flagOfPending && flagOfVerified)
		         {
					 document.getElementById("mainpopup").children[p].classList.remove("disabled");
		         }
			}
		}
    }
    if (flagOfInvoiced == true) {
    	for(var p=0;p<document.getElementById("mainpopup").children.length;p++)
		{
			if(document.getElementById("mainpopup").children[p].children[1].textContent=="Mark as verified")
			{
				document.getElementById("mainpopup").children[p].className = "disabled";
			}
			if(document.getElementById("mainpopup").children[p].children[1].textContent=="Mark as 'Self Sponsored'")
			{
				document.getElementById("mainpopup").children[p].className = "disabled";
			}
		}

    } else {
//        console.log("flagOfPending:::" + flagOfPending);
        
        for(var p=0;p<document.getElementById("mainpopup").children.length;p++)
		{
			if(document.getElementById("mainpopup").children[p].children[1].textContent=="Mark as verified")
			{
				if(!flagOfVerified)
				{
					document.getElementById("mainpopup").children[p].classList.remove("disabled");
				}
			}
			if(document.getElementById("mainpopup").children[p].children[1].textContent=="Mark as 'Self Sponsored'")
			{
				if(flagOfInvoiced && !flagOfVerified)
		        {
					document.getElementById("mainpopup").children[p].classList.remove("disabled"); 
		        }
			}
		}
    }

    if(selectedStorageId.length == 0)
    {
    	for(var p=0;p<document.getElementById("mainpopup").children.length;p++)
    	{
    		if(document.getElementById("mainpopup").children[p].children[1].textContent=="Send Invoice(s)")
    		{
    			document.getElementById("mainpopup").children[p].className = "disabled";
    		}
    		if(document.getElementById("mainpopup").children[p].children[1].textContent=="Mark as verified")
			{
				document.getElementById("mainpopup").children[p].className = "disabled";
			}
			if(document.getElementById("mainpopup").children[p].children[1].textContent=="Mark as 'Self Sponsored'")
			{
				document.getElementById("mainpopup").children[p].className = "disabled";
			}
			if(document.getElementById("mainpopup").children[p].children[1].textContent=="Download Invoice(s)")
			{
					document.getElementById("mainpopup").children[p].className = "disabled";
			}
			if(document.getElementById("mainpopup").children[p].children[1].textContent=="Make Payment(s)")
			{
					document.getElementById("mainpopup").children[p].className = "disabled";
			}
			if(document.getElementById("mainpopup").children[p].children[1].textContent=="Export")
			{
					document.getElementById("mainpopup").children[p].className = "disabled";
			}
    	}
    } 
}

function setMenuBar() {
    YUI().use("node", "event", 'aui-popover', function(A) {
        var trigger = A.one('#more-popover');
        var multipopover = new A.Popover({
            align: {
                node: trigger
            },
            bodyContent: MultirowPopAction,
            position: 'bottom',
            zIndex: 1000,
            visible: false
        }).render();

        trigger.on('click', function() {
            checkForPending();
        //    checkForVerified();
            var popupcontainer = A.one(".Multi-Pop-Action");
            popupcontainer.removeClass("hide");
            multipopover.set('visible', !multipopover.get('visible'));

        });

        A.one("#searchbtn").on('click', function() {
            updateFormFields();
        });
        A.one(".itemsPerPage").on('change', function(event) {
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

function updateFormFields() {
    var data = {
        "formStorageId": modelName,
        "configurationModelName": modelName,
        "formType": "configuration"
    };
    data.column1 = document.getElementById(portletns + 'select1').value;
    data.column2 = document.getElementById(portletns + 'select2').value;
    data.column3 = document.getElementById(portletns + 'select3').value;
    data.column4 = document.getElementById(portletns + 'select4').value;
    data.column5 = document.getElementById(portletns + 'select5').value;
    data.column6 = document.getElementById(portletns + 'select6').value;
    data.column7 = document.getElementById(portletns + 'select7').value;
    data.columnlist = columnlist;
    document.getElementsByClassName("settingIcon")[0].click();

    ajaxCall('POST', 'update', ajaxurl, data,
        function() {
            var data = this.get("responseData");
            if (data.error) {
//                console.log("error");
            } else {
                getFormFields();
            }
        },
        function() {

        });
}

AUI().use("node", "event", "event-base", function(A) {
    A.on('domready', function() {
        setMenuBar();
        getFormFields();
    });
});

function doAction(action, d) {
    AUI().use('liferay-portlet-url', function(A) {
        var c = findAncestor(d, "Row");
        var a = [];
        for (var b = 0; b < c.childElementCount; b++) {
            a.push(c.children[b].textContent.trim())
        }
        var e = Liferay.PortletURL.createRenderURL();
        e.options.basePortletURL = baseUrl;
        if (action == 'edit') {
            e.setParameter("jspPage", config.editPage);
        } else if (action == 'detail') {
            e.setParameter("jspPage", config.detailPage);
        } else if (action == 'copy') {
            e.setParameter("jspPage", config.copyPage);
        } else if (action == 'masterview') {
            e.setParameter("jspPage", config.masterViewPage);
        } else if (action === 'recordmanually') {
            e.setParameter("jspPage", config.recordManuallyPage);
        }

        e.setParameter("formTypeName", modelName);

        e.setParameter("storageId", a[0]);
        e.setPortletId(namespace.replace(/(^\_+|\_+$)/mg, ''));
        e.setWindowState("normal");
        window.location.href = e.toString();
    });
}

function doRecordManuallyAction(action) {
    filterdata = {};
    Object.keys(filterStoreData).forEach(function(key) {
        if (filterStoreData[key] != "" && typeof(filterStoreData[key]) == "object" && filterStoreData[key].length > 0) {
            filterdata[key] = filterStoreData[key];
        }
    });

    AUI().use('liferay-portlet-url', function(A) {
        var e = Liferay.PortletURL.createRenderURL();
        e.options.basePortletURL = baseUrl;
        e.setParameter("jspPage", config.recordManuallyPage);
        e.setParameter("formTypeName", modelName);
        e.setPortletId(namespace.replace(/(^\_+|\_+$)/mg, ''));
        e.setWindowState("normal");
        e.setParameter("filterData", encodeURI(JSON.stringify(filterdata)));

        window.location.href = e.toString();
    });
}

function doRecordByBarcodeReaderAction() {
    AUI().use('liferay-portlet-url', function(A) {
        var e = Liferay.PortletURL.createRenderURL();
        e.options.basePortletURL = baseUrl;
        e.setParameter("jspPage", config.recordBarcodePage);
        e.setParameter("formTypeName", modelName);
        e.setPortletId(namespace.replace(/(^\_+|\_+$)/mg, ''));
        e.setWindowState("normal");

        window.location.href = e.toString();
    });
}

function doExportAsPDF(e) {
    e.preventDefault();
    e.stopPropagation();
    filterdata = [];
    Object.keys(filterStoreData).forEach(function(key) {
        var filter = {};
        if (filterStoreData[key] != "" && typeof(filterStoreData[key]) == "object" && filterStoreData[key].length > 0) {
            filter[key] = filterStoreData[key];
            filterdata.push(filter);
        }
    });

    var contentJson = {
        filterData: filterdata
    };
    var jsonData = {
        "modelName": modelName,
        "formType": modelName,
        "contentJson": contentJson
    };
    window.open(exportPdfUrl + "&" + namespace + "formType" + "=" + modelName + "&" + namespace + "data=" + encodeURIComponent(JSON.stringify(jsonData)));
}

function storageStatus1(status, d) {
    showLoading(true);
    if (status == 'Active') {
        var popupdiv = "#active-record";
        var popupdivbox = "#active-record-box";
        updateStorageStatus1(status, d);
    } else if (status == 'Cancelled') {
        var popupdiv = "#active-record";
        var popupdivbox = "#active-record-box";
        updateStorageStatus1(status, d);

    } else if (status == 'Confirmed') {
        var popupdiv = "#active-record";
        var popupdivbox = "#active-record-box";
        updateStorageStatus1(status, d);

    } else if (status == 'invoice') {
        var popupdiv = "#invoice-success";
        var popupdivbox = "#invoice-success-box";
        updateStorageStatus1(status, d);

    } else if (status == 'Inactive' || status == 'Blacklist' || status == 'invoice') {

        if (status == 'Inactive') {
            var popupdiv = "#deactive-record";
            var popupdivbox = "#deactive-record-box";
        } else if (status == 'Blacklist') {
            var popupdiv = "#blacklist-record";
            var popupdivbox = "#blacklist-record-box";
        } else if (status == 'invoice') {
            var popupdiv = "#invoice-success";
            var popupdivbox = "#invoice-success-box";
            showPopupSuccess(status, d);

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
                        // storageStatus1("Active",d);rajjan
                    }
                );
                Y.one('.popup-cancel-blacklist').on(
                    'click',
                    function() {
                        modal.hide();
                        showLoading(false);
                    }
                );



                Y.one('.popup-confirm-deactivate').on(
                    'click',
                    function() {
                        showLoading(false);
                        if (document.getElementById("deactivate_reason").value.length > 4) {
                            updateStorageStatus1(status, d);
                            modal.hide();
                        } else {
                            document.getElementById("deactivate_msg").classList.add("alert");
                            document.getElementById("deactivate_msg").classList.add("alert-error");
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
                        if (document.getElementById("blacklist_reason").value.length > 4) {
                            updateStorageStatus1(status, d);
                            modal.hide();
                        } else {
                            document.getElementById("blacklist_msg").classList.add("alert");
                            document.getElementById("blacklist_msg").classList.add("alert-error");
                        }

                    }
                );

            });

        });
    }

}

function updateStorageStatus1(status, d) {

    var c = findAncestor(d, "Row");
    var a = [];
    for (var b = 0; b < c.childElementCount; b++) {
        a.push(c.children[b].textContent.trim())
    }
    var inactiveReason = "";
    if (status.toLowerCase() == 'inactive') {
        inactiveReason = document.getElementById("deactivate_reason").value;
    }
    showLoading(true);
    ajaxCall('GET', 'loadData', ajaxurl, {
            "formType": modelName,
            "formStorageId": encodeURIComponent(a[0])
        },
        function() {
            ;
            var data = this.get("responseData");
            showLoading(false);
            if (data == null || data == "") {
//                console.log("error");

            } else {
                ;
                var data1 = data.contentJson;
                data1.Status = status;
                data1.InactiveReason = inactiveReason;
                data1.formType = modelName;
                data1.formStorageId = encodeURIComponent(a[0]);

                ajaxCall('GET', 'update', ajaxurl, data1,
                    function() {
                        var data = this.get("responseData");
                        if (_.isEmpty(data)) {
//                            console.log("error");
                            showPopupSuccess(status, d);
                        } else {
                            jsFilterColumnList();
                            showPopupSuccess(status, d);
                        }
                    },
                    function() {});
            }
        },
        function() {

        });
}

function updateScheduleStatus(status, d) {

    var c = findAncestor(d, "Row");
    var a = [];
    for (var b = 0; b < c.childElementCount; b++) {
        a.push(c.children[b].textContent.trim())
    }
    var inactiveReason = "";
    if (status.toLowerCase() == 'inactive') {
        inactiveReason = document.getElementById("deactivate_reason").value;
    }
    showLoading(true);
    ajaxCall('GET', 'loadData', ajaxurl, {
            "formType": modelName,
            "formStorageId": encodeURIComponent(a[0])
        },
        function() {
            showLoading(false);
            var data = this.get("responseData");
            if (data == null || data == "") {
//                console.log("error");

            } else {
                var data1 = data.contentJson;
                data1.ScheduleStatus = status;
                data1.InactiveReason = inactiveReason;
                data1.formType = modelName;
                data1.formStorageId = encodeURIComponent(a[0]);

                ajaxCall('GET', 'update', ajaxurl, data1,
                    function() {
                        var data = this.get("responseData");
                        if (_.isEmpty(data)) {
//                            console.log("error");
                            showPopupSuccess(status, d);
                        } else {
                            jsFilterColumnList();
                            showPopupSuccess(status, d);
                        }
                    },
                    function() {
//                        console.log("eee");
                    });
            }
        },
        function() {

        });
}

function showPopupSuccess(status, d) {

    AUI().use('aui-base', function(A) {
        if (status.toLowerCase() == 'inactive') {
            var boundingBox = "#deactivation-success";
            var contentBox = "#inactive-success-box";
        }
        if (status.toLowerCase() == 'active') {
            var boundingBox = "#activation-success";
            var contentBox = "#active-success-box";
        }
        if (status.toLowerCase() == 'confirmed') {
            var boundingBox = "#confirmed-success";
            var contentBox = "#confirmed-success-box";
        }
        if (status.toLowerCase() == 'cancelled') {
            var boundingBox = "#cancelled-success";
            var contentBox = "#cancelled-success-box";
        }
        if (status.toLowerCase() == 'blacklist') {
            var boundingBox = "#blacklist-success";
            var contentBox = "#blacklist-success-box";
        }
        if (status.toLowerCase() == 'invoice') {
            var boundingBox = "#invoice-success";
            var contentBox = "#invoice-success-box";
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

function archiveStorage1(d, flag) {

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
                    if (flag == true) {
                        selfSponsored();
                    }
                    if (flag == false) {
                    	if(d!=null)
                    	{
                        singleSelfSponsored(d)
                    	}
                    }
                    modal.hide();
                    d=null;
                    //jsFilterColumnList();
                }
            );

        });

    });
}

function setMarkAsVerifiedPopup(d, flag) {

    AUI().use('aui-base', function(A) {
        var boundingBox = "#mark-verified-record";
        var contentBox = "#mark-verified-record-box";
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
            Y.one('.popup-cancel-verified').on(
                'click',
                function() {
                    modal.hide();
                }
            );

            Y.one('.popup-confirm-verified').on(
                'click',
                function() {
                    if (flag == true) {
                        markAsVerify();
                    }
                    if (flag == false) {
                    	if(d!=null)
                    	{
                    		singleMarkAsVerify(d);
                    	}
                        
                    }
                   d=null;
                    modal.hide();
                 //   jsFilterColumnList();
                }
            );

        });

    });
}

function addNewRecord(d) {
    AUI().use('liferay-portlet-url', function(A) {
        var e = Liferay.PortletURL.createRenderURL();
        e.options.basePortletURL = baseUrl;
        jspPage = config.createPage;
        e.setParameter("formTypeName", modelName);
        e.setParameter("jspPage", jspPage);
        e.setPortletId(namespace.replace(/(^\_+|\_+$)/mg, ''));
        e.setWindowState("normal");
        // window.location.href = e.toString();
        var pattern = /__/g;
        var dd = e.toString();
        window.location.href = dd.replace(pattern, "_");
    });
}

function findAncestor(el, cls) {
    while ((el = el.parentElement) && !el.classList.contains(cls));
    return el;
}

function exportStorage1(e, d) {
    e.preventDefault();
    e.stopPropagation();
    var c = findAncestor(d, "Row");
    var a = [];
    for (var b = 0; b < c.childElementCount; b++) {
        a.push(c.children[b].textContent.trim())
    }

    ajaxCall('GET', 'exportRow', exportstorageurl, {
            "formType": modelName,
            "formStorageId": encodeURIComponent(a[0])
        },
        function() {
            var result = "data:application/vnd.openxmlformats-officedocument.spreadsheetml.sheet," + btoa(unescape(encodeURIComponent(this.get("responseData"))));
            window.open(result);
//            console.log("success in downloading file");
        },
        function() {

        });
}

function globalExportList(e) {
    e.preventDefault();
    e.stopPropagation();
    globalexportlisturl += "&" + namespace + "formType" + "=" + modelName;
    window.open(globalexportlisturl);
}

function exportBystorageId(e, d) {
    e.preventDefault();
    e.stopPropagation();
    var exportURL = exportstorageurl
    
    var c = findAncestor(d, "Row");
    var a = [];
    for (var b = 0; b < c.childElementCount; b++) {
        a.push(c.children[b].textContent.trim())
    }
    
    exportURL += "&" + namespace + "formType" + "=" + modelName;
    exportURL += "&" + namespace + "formStorageId" + "=" + a[0];
    window.open(exportURL);
}



function globalDeactivateList(d) {
    alert('here' + d);
}

function globalArchiveList() {
    alert('here');
}

function showFilters() {
    var filterlist = document.getElementById("filterlist");
    var txt = "<ul>";
    Object.keys(filterStoreData).forEach(function(key) {
        if (filterStoreData[key] != "") {
            if (typeof(filterStoreData[key]) == "object") {
                Object.keys(filterStoreData[key]).forEach(function(key1) {
                    txt += '<li style="display: inline-block;" onclick="removeFilter(\'' + key + '\',\'' + filterStoreData[key][key1] + '\')"> <a >' + filterStoreData[key][key1] + ' </a>  </li>';
                })
            } else {
                txt += '<li style="display: inline-block;" onclick="removeFilter(\'' + key + '\',\'' + filterStoreData[key] + '\')"> <a >' + filterStoreData[key] + ' </a>  </li>';
            }
        }
    });

    Object.keys(freeTextArray).forEach(function(key) {
        txt += '<li style="display: inline-block;" onclick="removeFilter(\'' + 'condition' + '\',\'' + freeTextArray[key] + '\')"> <a >' + freeTextArray[key] + ' </a>  </li>';
    });
    txt += "</ul>";
    filterlist.innerHTML = txt;
}

function removeFilter(key, value) {

    if (key == "condition") {
        var index = freeTextArray.indexOf(value);
        freeTextArray.splice(index, 1);
    } else {
        var index = filterStoreData[key].indexOf(value);
        filterStoreData[key].splice(index, 1);
        showFilters();

        var idx = "";
        filterdata.map(function(i){
        	var f= false;
        	if (Object.keys(i)[0].includes(key)) { 
        			f = true;
            }
        	(f) ? idx = filterdata.indexOf(i):'';
    	})
//        console.log(idx);
        filterdata.splice(idx,1);
//        console.log(filterdata);
        
//        filterdata = [];
//        Object.keys(filterStoreData).forEach(function(key) {
//            var filter = {};
//            if (filterStoreData[key] != "" && typeof(filterStoreData[key]) == "object" && filterStoreData[key].length > 0) {
//                filter[key] = filterStoreData[key];
//                filterdata.push(filter);
//            }
//
//        });
    }
    jsFilterColumnList();

}
function formatMoney(amount, decimalCount, decimal, thousands) 
{
	  try {
	    decimalCount = Math.abs(decimalCount);
	    decimalCount = isNaN(decimalCount) ? 2 : decimalCount;

	    const negativeSign = amount < 0 ? "-" : "";

	    let i = parseInt(amount = Math.abs(Number(amount) || 0).toFixed(decimalCount)).toString();
	    let j = (i.length > 3) ? i.length % 3 : 0;

	    return negativeSign + (j ? i.substr(0, j) + thousands : '') + i.substr(j).replace(/(\d{3})(?=\d)/g, "$1" + thousands) + (decimalCount ? decimal + Math.abs(amount - i).toFixed(decimalCount).slice(2) : "");
	  } catch (e) {
//	    console.log(e);
	  }
	}
function showLoading(show) {
    if (show) {
        getEID("loadingDiv").style.display = "block";
    } else {
        getEID("loadingDiv").style.display = "none";
    }
}

function getEID(element) {
    return document.getElementById(element);
}
setTimeout(function() {
    drawPagination(pageRequested);
}, 3000);



