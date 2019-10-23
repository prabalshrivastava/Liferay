var contentdata;
var sampleRow;
var rowContainer;
var A;
var index = 0;
var gridData = {};
var selectedData = [];
var counter = 0;
if (document.readyState == 'complete') {
    init2();
} else {
    window.addEventListener('load', init2);
}

function init2() {

    document.getElementById("startDate").disabled = true;
    document.getElementById("endDate").disabled = true;
    document.getElementById("sendNotification").disabled = true;
    AUI().use('aui-node', 'aui-io-request', 'liferay-util-window', 'aui-io-plugin-deprecated',
        'stylesheet', 'aui-datepicker', 'overlay', 'event', 'widget-anim',
        function(A1) {
            A = A1;
            var AArray = A.Array;
            sampleRow = A.one("#sampleEntityLinkRow");
            rowContainer = A.one("#entityLinkContainer");
            var element = document.getElementById("entityLinkContainer");

            while (element.childNodes.length > 2) {
                element.removeChild(element.lastChild);
            }
            var contentdata;

            var schedule = selectedSchedule;
            var itemsSelect = document.getElementById(namespace + "itemsPerPage");
            itemsPerPage = itemsSelect.options[itemsSelect.selectedIndex].value;
            data = {};
            data.formType = "certificate";
            data.limit = itemsPerPage;
            data.page = (pageRequested - 1);

            data.filterdata = {
                "filters": [{
                    "contentJson.scheduleId": [selectedSchedule]
                }]
            };

            index = 0;
            document.getElementById("selectAll").checked = false;
            ajaxCallAPI('POST', "elastiSearchList", data,

                function() {


                    contentdata = this.get("responseData");
                    var responseData = [];
                    responseData = contentdata;
                    populateEntityRecords(responseData);
                    totalRecord = responseData.content.length;
                    document.getElementById("totalRec").innerHTML = totalRecord;


                    totalRecords = contentdata.totalElements;
                    totalPages = contentdata.totalPages;

                    if (pageRequested == 1) {
                        drawPagination(pageRequested)
                    } else {
                        makePaging(totalPages, pageRequested - 1);
                        pagination(pageRequested, totalPages);
                    }
                },
                function() {
                    displayMessage('danger',
                        "Error in persisting dynamic form data.", 3000);
                    callback();
                });


            function populateEntityRecords(dataList) {

                for (var i = 0; i < dataList.content.length; i++) {

                    addRowCells(dataList.content[i]);
                }

                /*
                 * dataList.forEach(function(data){ this.addRowCells(data); });
                 */
            }


            function addRowCells(data) {
                var facilityId, subFacility;
                var newRow = this.sampleRow.cloneNode(true);

                gridData[data.storageId] = data.contentJson.notificationStatus;

                newRow.one("#candidateName").set('text', data.contentJson.candidateName);
                newRow.one("#idNumber").set('text', maskingStr(data.contentJson.idNumber));
                newRow.one("#srnNumber").set('text', data.contentJson.srnNumber);
                newRow.one("#classificationAward").set('text', data.contentJson.classificationAward);
                newRow.one("#programeTitle").set('text', data.contentJson.programeTitle);
                if (data.contentJson.notificationOn == null) {
                    newRow.one("#notifiedOn").set('text', "");
                } else {
                    newRow.one("#notifiedOn").set('text', new Date(data.contentJson.notificationOn).toLocaleDateString());
                }
                index++;

                if (data.contentJson.notificationStatus === true) {
                    newRow.one("#notificationStatus").set('text', "YES");
                    var chk = "<input type='checkbox' name='chk_" + index + "' id='" + data.storageId + "' disabled='true'/>";
                    newRow.one("#selection").html(chk);

                } else {
                    newRow.one("#notificationStatus").set('text', "No");
                    var chk = "<input type='checkbox' name='chk_" + index + "' id='" + data.storageId + "' onchange='selectSingleOption(this)'/>";
                    newRow.one("#selection").html(chk);

                }
                show(newRow);

                rowContainer.appendChild(newRow);
            }

            function show(node) {
                if (node) {
                    node.removeClass("hide");
                }
            }

            function hide(node) {
                if (node) {
                    node.addClass("hide");
                }
            }
        });

}

function getModelData(formType, formStorageId, callback) {

    var filter = {};
    filter.formType = formType;
    filter.formStorageId = formStorageId;
    loadFilterData(filter, function(responseData) {
        setInterval(function() {}, 1000);
        var data = responseData;
        callback(data);
    });
}

function loadFilterData(filter, callback) {
    var data;
    ajaxCallAPI(
        'GET',
        "loadData",
        filter,
        function() {
            data = this.get("responseData");
            contentdata = this.get("responseData");

            if (data.error) {
                displayMessage('danger', data.error, 3000);
            } else {

            }
            callback(contentdata);
        },
        function() {
            displayMessage('danger',
                "Error in persisting dynamic form data.", 3000);
            callback();
        });
}



function selectAllOptions() {


    selectedData = [];
    counter = 0;

    var checkAll = document.getElementById("selectAll");

    if (index <= 0) {
        return;
    }


    if (checkAll.checked === true) {

        for (var i = 1; i <= index; i++) {

            var name = "chk_" + i;
            var checkBox = document.getElementsByName(name);
            var id = checkBox[0].id;

            if (!gridData[id]) {
                checkBox[0].checked = true;
                selectedData.push(checkBox[0].id);
                counter++;
            }
        }
        if (selectedData.length > 0) {
            document.getElementById("startDate").disabled = false;
        }
    } else {
        document.getElementById("startDate").disabled = true;

        for (var i = 1; i <= index; i++) {
            var name = "chk_" + i;
            var checkBox = document.getElementsByName(name);
            var id = checkBox[0].id;
            if (!gridData[id]) {
                checkBox[0].checked = false;
                counter = 0;
            }

        }
    }
    document.getElementById("selectedCount").innerHTML = counter;
}

function removeAllChild() {
    index = 0;
    gridData = {};
    document.getElementById("selectAll").checked = false;
    var list = document.getElementById("selection");
    while (list.hasChildNodes()) {
        list.removeChild(list.firstChild);
    }
}

function selectSingleOption(obj) {
	var selection = obj.checked;
    var nameOfCtrl = obj.name;

    if (selection) {
        selectedData.push(obj.id);
        counter++;
    } else {
        if (counter > 0) {
            if (selectedData.length > 0) {
                for (var i = 0; i <= selectedData.length - 1; i++) {
                    if (selectedData[i] === obj.id) {
                        selectedData.splice(i, 1);
                    }
                }
                if(selectedData.length <=0){
                    document.getElementById("startDate").valueAsDate = null;
                    document.getElementById("endDate").valueAsDate = null;
                	document.getElementById("startDate").disabled = true;
                	document.getElementById("endDate").disabled = true;
                    document.getElementById("sendNotification").disabled = true;
                }
            }
            counter--;
        }
    }
    if (selectedData.length > 0) {
        document.getElementById("startDate").disabled = false;
    } else {
        document.getElementById("startDate").disabled = true;
    }
    document.getElementById("selectedCount").innerHTML = counter;

}

function sendNotification() {


    var startDate = document.getElementById("startDate").value;
    var endDate = document.getElementById("endDate").value;

    var list = document.getElementById("selection");

    var data = {};
    data["startDate"] = startDate;
    data["endDate"] = endDate;
    data["storageIds"] = selectedData;

    ajaxCallAPI('POST', "scanedData", data,

        function() {


            var contentdata = this.get("responseData");
            var responseData = [];

            if (contentdata.error) {
                displayMessage('danger', contentdata.error, 3000);

            } else {
                displayMessage('success',
                    contentdata.message, 3000);
                clearDate();
                removeAllChild();
                init2();
                document.getElementById("selectedCount").innerHTML = 0;

            }

        },
        function() {
            displayMessage('danger',
                "Error in persisting dynamic form data.", 3000);
            callback();
        });


}

function maskingStr(str) {

    var ch = str.split('');
    var output = "";
    for (var i = 0; i < str.length; i++) {
        if (i < 4) {
            output += "X";
        } else {
            output += ch[i];
        }
    }
    return output;
}

function clearDate() {
    // document.getElementById("startDate").disabled = true;
    document.getElementById("endDate").disabled = true;
    document.getElementById("sendNotification").disabled = true;
    document.getElementById("startDate").valueAsDate = null;
    document.getElementById("endDate").valueAsDate = null;

}

function onCancel() {
    window.location.href="/workspace";
}

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
    console.log(rangeWithDots);
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
    init2();
}

function reloadTable() {
    pageRequested = 1;
    init2();
}