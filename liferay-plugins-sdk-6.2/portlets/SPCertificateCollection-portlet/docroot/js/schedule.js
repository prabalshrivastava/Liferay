var data, contentdata;
var sessionScheduleList = [];
var ssLoaded = false;
var instance = this;
var totalRecord = 0;

function init() {
    console.log("onload...");
    if (mode == "view") {

        downloadDropdownData("schedule", function(data) {
            setInterval(function() {}, 1000);
            sessionScheduleList = data;
            ssLoaded = true;
            document.getElementById("selectedCount").innerHTML = 0;
            if (ssLoaded == true) {
                var sessionSchedule = getEID(namespace + "sessionSchedule");
                populateDropDown(sessionSchedule, sessionScheduleList,
                    "ScheduleCode", "ScheduleCode");

                sessionSchedule.value = selectedSchedule;
            }

        });
    }

}

if (document.readyState == 'complete') {
    init();
} else {
    window.addEventListener('load', init);
}

function downloadDropdownData(model, callback) {
    data = {};
    data.formType = model;


    ajaxCallAPI('GET', "loadList", data,

        function() {
            data = this.get("responseData");
            contentdata = this.get("responseData");
            var responseData = [];



            responseData = contentdata.content;

            callback(responseData);
        },
        function() {
            displayMessage('danger',
                "Error in persisting dynamic form data.", 3000);
            callback();
        });
}



function populateDropDown(elementDrpDwn, data, keyColumn, valueColumn) {
    document.getElementById("totalRec").innerHTML = totalRecord;
    var scheduleMap = new Map();

    for (var i = 0; i < data.length; i++) {

        scheduleMap.set(data[i].contentJson[keyColumn], "[" +
            data[i].contentJson[valueColumn] + "] " +
            data[i].contentJson["Name"]);
    }

    scheduleMap.forEach(function(value, key, scheduleMap) {

        var opt = new Option(value, key);
        elementDrpDwn.options[elementDrpDwn.options.length] = opt;
    })
}

function getEID(element) {
    return document.getElementById(element);
}