var contentdata;
var sampleRow;
var expandDet;
var statusOfAllRecFlag = true;
var isNullify = true;
var isRPECCompleted = false;
var dataRow;
var rowContainer;
var A;
var index = 0;
var classArr = [];
var gridData = {};
var classArrForMenu = [];
var reviewPeriodNo = 0;
var selectedData = [];
var selectedRow = {};
var counter = 0;
var responseData = [];
var candidateList;
if (document.readyState == 'complete') {
    init2('false',"");
} else {
    window.addEventListener('load', function() {
        init2('false',"");
    }, false);
}

function getEID(element) {
	return document.getElementById(element);
}

function displayMessageCustom(type, message, duration) {
	scrollToTop();
	var alert_div = document.getElementById("alert_msg1");
	console.log("alert_div : "+alert_div);
	alert_div.innerHTML = message;
	alert_div.classList.add("alert-" + type);
	alert_div.style.display = "block";
	setTimeout(function() {
		alert_div.style.display = "none";
	}, duration);
	console.log(message);
}
var timeOut;
function scrollToTop() {
	if (document.body.scrollTop != 0 || document.documentElement.scrollTop != 0) {
		window.scrollBy(0, -50);
		timeOut = setTimeout('scrollToTop()', 10);
	} else {
		clearTimeout(timeOut);
	}

}

function loadCandidate(sortFlag)
{
	showAddRPEC = false;
// if(userType.toLowerCase() === "relcuser" || userType.toLowerCase() ===
// "mentor" || userType.toLowerCase() === "trainingprincipal")
// {
		var candidateData = {};
     	candidateData.userId = userIdDD;
     	
     	 ajaxCallAPI(
                  'POST',
                  "candidateProfile",
                  candidateData,
                  function() {
                 	 var cadidateProfile = this.get("responseData");
                 	 if(cadidateProfile !== undefined && cadidateProfile !== null)
                 	 {
                 		 var candidatesData = cadidateProfile.contentJson;
                 			if ((candidatesData !== undefined && candidatesData !== null && candidatesData.AtoDetails !== undefined
                       				&& candidatesData.AtoDetails !== null
                       				&& candidatesData.AtoDetails !== "")) {
                       			if (candidatesData.AtoDetails instanceof Array && candidatesData.AtoDetails[0].AtoName !== undefined && candidatesData.AtoDetails[0].AtoName !== null) {
                       				showAddRPEC = true;
                       			}
                       			else
                       			{
                       				if(candidatesData.AtoDetails.AtoName !== undefined && candidatesData.AtoDetails.AtoName !== null)
                       				{
                       					showAddRPEC = true;
                       				}
                       			}
                          	 }
                 	}
                 	init2(sortFlag,"");
                  });
// }
}

function init2(sortFlag,sortField) {
    showLoading(true);
    counter = 0;
    if(document.getElementById("selectedCount") !== null) {
    	document.getElementById("selectedCount").innerHTML = 0;
    }
    AUI()
        .use(
            'aui-node',
            'aui-io-request',
            'liferay-util-window',
            'aui-io-plugin-deprecated',
            'stylesheet',
            'aui-datepicker',
            'overlay',
            'event',
            'widget-anim',
            function(A1) {
                A = A1;
                var AArray = A.Array;
                sampleRow = A.one("#mainRow");
                dataRow = A.one("#sampleEntityLinkRow");
                expandDet = A.one("#expandDet");
                var tbl = document.getElementById("tbl");
                rowContainer = A.one("#entityLinkContainer");
                var element = document.getElementById("entityLinkContainer");
                document.getElementById("_eRPEC_WAR_SPRPECportlet_leftTbl").innerHTML = "";
                document.getElementById("_eRPEC_WAR_SPRPECportlet_rightTbl").innerHTML = "";
                while (element.childNodes.length > 2) {
                    element.removeChild(element.lastChild);
                }
                var contentdata;
                var bodyData = {};
               
                var deletedCond = {
                		"contentJson.isDeleted": [false]
                }
                if (userType.toLowerCase() == "candidate") {
                    bodyData.filters = [{
                        "contentJson.candidateId": [userId
                            .toString()
                        ]
                    }, deletedCond];
                } else if (userType.toLowerCase() == "mentor" || userType.toLowerCase() == "trainingprincipal") {
                	var rpecStatus = ["Pending Standard Approval","Pending Final Approval","Completed","Approved","Rejected","Pending Sign Off"]
                    if (isDDCan && userIdDD != undefined && userIdDD!="") {
                        bodyData.filters = [{
                                "contentJson.candidateId": [userIdDD.toString()]
                            },
                            deletedCond ,
                            {
                                "contentJson.rpecStatus": rpecStatus
                            }
                        ];
                    } else {
                    	var candArray = csvCandidates.split(",");
                        bodyData.filters = [{
                            "contentJson.candidateId": candArray
                            },
                            deletedCond,
                            {
                                "contentJson.rpecStatus": rpecStatus
                            }
                        ];
                    }
                } else if (userType.toLowerCase() == "relcuser") {
                    if (isDDCan && userIdDD != undefined && userIdDD!="") {
                        bodyData.filters = [{
                            "contentJson.candidateId": [userIdDD.toString()]
                        }, deletedCond];
                    } else {
                        bodyData.filters = [deletedCond];

                    }
                } else {
                    bodyData.filters = [deletedCond];
                }
                bodyData.formType = modelName;
                index = 0;
                ajaxCallAPI(
                    'POST',
                    "elastiSearchList",
                    bodyData,
                    function() {
                        contentdata = this.get("responseData");
                        responseData = [];
                        if(contentdata !== null) {
                        	responseData = contentdata.content;
                        }
                        if (responseData.length == 0) {
                            reviewPeriodNo = 1;
                            document.getElementById("no-data").classList
                                .remove("hide");
                            document.getElementById("have-data").classList
                                .add("hide");
                            if (document.getElementById("addRpec") !== null && showAddRPEC) {
                                document.getElementById("addRpec").disabled = false;
                            }
                            else{
                            	if(document.getElementById("addRpec") !== null)
                            	{
                            		document.getElementById("addRpec").disabled = true;
                            	}
                            }
                            
                            if(!showAddRPEC && document.getElementById("tooltipmsg") && document.getElementById("addRpec") !== null)
                         	{
                         		document.getElementById("tooltipmsg").innerText = 'Sorry, you are not allowed to submit a new record since you are currently not associated with any ATO. Please update in \'Candidate Details\' if you\'re part of an ATO already.';
                         	}
                            
                        } else {
                            reviewPeriodNo = contentdata.totalElements + 1;
                            document.getElementById("have-data").classList
                                .remove("hide");
                            document.getElementById("no-data").classList
                                .add("hide");
                            for (var i = 0; i < responseData.length; i++) {
                                if (responseData[i].contentJson.rpecStatus == "Approved" || responseData[i].contentJson.rpecStatus == "Approved By Mentor"||
                                    responseData[i].contentJson.rpecStatus == "Nullified" || responseData[i].contentJson.rpecStatus == "Completed") {
                                    statusOfAllRecFlag = true;
                                } else {
                                    statusOfAllRecFlag = false;
                                    break;
                                }
                            }
                            
                            for (var i = 0; i < responseData.length; i++) {
                            	if(responseData[i].contentJson.rpecStatus === "Pending Final Approval" || responseData[i].contentJson.rpecStatus == "Pending Sign Off" || responseData[i].contentJson.rpecStatus == "Completed")
                            	{
                            		isNullify = false;
                            		break;
                            	}
                            	else
                            	{
                            		isNullify = true;
                            	}
                            }
                            
                            for (var i = 0; i < responseData.length; i++) {
                            	if(responseData[i].contentJson.rpecStatus == "Completed")
                            	{
                            		isRPECCompleted = true;
                            		break;
                            	}
                            	else{
                            		isRPECCompleted = false;
                            	}
                            }
                            
                            if (document.getElementById("addRpec") != null) {
                            	
                            	if(isRPECCompleted)
                             	{
                             		document.getElementById("tooltipmsg").innerText = 'You’re not allowed to add any further records, since the RPEC for this candidate is complete.';
                             	}else if(!statusOfAllRecFlag)
                             	{
                             		document.getElementById("tooltipmsg").innerText = 'Sorry, you are not allowed to submit a new record, due an existing RPEC draft record or one of your records could be pending review.';
                             	}else if(!showAddRPEC)
                             	{
                             		document.getElementById("tooltipmsg").innerText = 'Sorry, you are not allowed to submit a new record since you are currently not associated with any ATO. Please update in \'Candidate Details\' if you\'re part of an ATO already.';
                             	}
                            	
// if(!showAddRPEC)
// {
// document.getElementById("tooltipmsg").innerText = 'Sorry, you are not allowed
// to submit a new record since you are currently not associated with any ATO.
// Please update in \'Candidate Details\' if you\'re part of an ATO already.';
// }else if(!statusOfAllRecFlag)
// {
// document.getElementById("tooltipmsg").innerText = 'Sorry, you are not allowed
// to submit a new record, due an existing RPEC draft record or one of your
// records could be pending review.';
// }
// else if(isRPECCompleted)
// {
// document.getElementById("tooltipmsg").innerText = 'You’re not allowed to add
// any further records, since the RPEC for this candidate is complete.';
// }
                            }
                            
                            if (document.getElementById("addRpec") != null) {
                                if (statusOfAllRecFlag &&
                                    isAddRpecVisible && showAddRPEC && !isRPECCompleted) {

                                    document.getElementById("addRpec").disabled = false;
                                } else {
                                    document.getElementById("addRpec").disabled = true;
                                }
                            }
                        }
                       
                        sortMain(responseData,sortFlag,sortField);
                        showLoading(false);
                    },
                    function() {
                        showLoading(false);
                        displayMessageCustom(
                            'danger',
                            "Error in persisting dynamic form data.",
                            3000);
                        callback();
                    });

                function populateEntityRecords(dataList) {
                    for (var i = 0; i < dataList.length; i++) {
                        addRowCells(dataList[i]);
                    }
                }

                function addRowCells(data) {
                    // var mainRow = this.sampleRow.cloneNode(true);
                    var newRow = this.dataRow.cloneNode(true);
                    var newRow1 = this.expandDet.cloneNode(true);
                    var contextMenu = A.one("#MultirowPopAction");
                    var contectMenuEle = contextMenu.cloneNode(true);
                    newRow.one("#id").set('text',
                        data.contentJson.storageId);
                    newRow.one("#candidateId").set('text',
                        data.contentJson.candidateId);
                    newRow.one("#isStandardReview").set('text',
                        data.contentJson.isStandardReview);
                    newRow.one("#isFinalReview").set('text',
                        data.contentJson.isFinalReview);
                    newRow.one("#isSignOff").set('text',
                        data.contentJson.isSignOff);
                    if (data.contentJson.userType == "RELCUser") {
                        newRow.one("#reviewPeriodNumber").set('text',
                            data.contentJson.reviewPeriodNumber);
                        newRow._node.children[2].firstElementChild.classList
                            .add("star");
                    } else {
                        newRow.one("#reviewPeriodNumber").set('text',
                            data.contentJson.reviewPeriodNumber);
                        newRow._node.children[2].firstElementChild.classList
                        .remove("star");
                    }
                    newRow
                    .one("#candidateName")
                    .set(
                        'text',
                        data.contentJson.candidateName);
                    newRow.one("#startDate")
                        .set(
                            'text',
                            data.contentJson.reviewFromDate
                            .split(" ")[0].replace(
                                /-/g, '/'));
                    newRow.one("#endDate").set(
                        'text',
                        data.contentJson.reviewToDate.split(" ")[0]
                        .replace(/-/g, '/'));
                    newRow
                        .one("#accreditedTrainingOrganisation")
                        .set(
                            'text',
                            data.contentJson.accreditedTrainingOrganisation);
                    newRow.one("#mentorName").set('text',
                        data.contentJson.mentorName);

                    newRow.one("#candidateJobRole").set('text',
                        data.contentJson.candidateJobRole);
                    newRow
                        .one("#totalDaysSpentOnPracticalExperience")
                        .set(
                            'text',
                            data.contentJson.totalDaysSpentOnPracticalExperience);
                    counter += data.contentJson.totalDaysSpentOnPracticalExperience;
                    // var statusOfRpec="Draft";
                    var statusOfRpec = data.contentJson.rpecStatus;
                    // newRow.one("#status").set('text',data.contentJson.rpecStatus);
                    if (statusOfRpec == "Draft") {
                        newRow.one("#statusOfRpec")
                            .set('text', "Draft");
                        newRow.one("#statusOfRpec").set('title',
                            "Draft");
                        newRow
                            .one("#statusOfRpec")
                            .set(
                                'style',
                                'background-color: #dfe3e8;color: #3b475f !important;padding:3px !important;white-space: nowrap;overflow: hidden;text-overflow: ellipsis;');

                    } else if (statusOfRpec == "Pending Standard Approval") {
                        newRow.one("#statusOfRpec").set('text',
                            "Pending Standard Approval");
                        newRow.one("#statusOfRpec").set('title',
                            "Pending Standard Approval");
                        newRow
                            .one("#statusOfRpec")
                            .set(
                                'style',
                                'background-color: #ffd724;color: #715e04 !important;padding:3px !important;white-space: nowrap;overflow: hidden;text-overflow: ellipsis;');

                    } else if (statusOfRpec == "Pending Final Approval") {
                        newRow.one("#statusOfRpec").set('text',
                            "Pending Final Approval");
                        newRow.one("#statusOfRpec").set('title',
                            "Pending Final Approval");
                        newRow
                            .one("#statusOfRpec")
                            .set(
                                'style',
                                'background-color: #ffd724;color:#715e04 !important;padding:3px !important;white-space: nowrap;overflow: hidden;text-overflow: ellipsis;');
                    } else if (statusOfRpec == "Approved") {
                        newRow.one("#statusOfRpec").set('text',
                            "Approved");
                        newRow.one("#statusOfRpec").set('title',
                            "Approved");
                        newRow
                            .one("#statusOfRpec")
                            .set(
                                'style',
                                'background-color: #8bdb7c;color:#115a03 !important;padding:3px !important;white-space: nowrap;overflow: hidden;text-overflow: ellipsis;');
                    } 
	                 else if (statusOfRpec == "Approved By Mentor") {
	                    newRow.one("#statusOfRpec").set('text',
	                        "Approved By Mentor");
	                    newRow.one("#statusOfRpec").set('title',
	                        "Approved By Mentor");
	                    newRow
	                        .one("#statusOfRpec")
	                        .set(
	                            'style',
	                            'background-color: #8bdb7c;color:#115a03 !important;padding:3px !important;white-space: nowrap;overflow: hidden;text-overflow: ellipsis;');
	                }else if (statusOfRpec == "Completed") {
	                        newRow.one("#statusOfRpec").set('text',
	                            "Completed");
	                        newRow.one("#statusOfRpec").set('title',
	                            "Completed");
	                        newRow
	                            .one("#statusOfRpec")
	                            .set(
	                                'style',
	                                'background-color: #8BDB7C;color: #29721A !important;padding:3px !important;white-space: nowrap;overflow: hidden;text-overflow: ellipsis;');

                    } else if (statusOfRpec == "Rejected") {
                        newRow.one("#statusOfRpec").set('text',
                            "Rejected");
                        newRow.one("#statusOfRpec").set('title',
                            "Rejected");
                        newRow
                            .one("#statusOfRpec")
                            .set(
                                'style',
                                'background-color: #ffb5b5;color: #810000 !important;padding:3px !important;white-space: nowrap;overflow: hidden;text-overflow: ellipsis;');

                    } else if (statusOfRpec == "Pending Sign Off") {
                        newRow.one("#statusOfRpec").set('text',
                            "Pending Sign Off");
                        newRow.one("#statusOfRpec").set('title',
                            "Pending Sign Off");
                        newRow
                            .one("#statusOfRpec")
                            .set(
                                'style',
                                'background-color: #ffd724;color:#715e04 !important;padding:3px !important;white-space: nowrap;overflow: hidden;text-overflow: ellipsis;');

                    } else if (statusOfRpec == "Nullified") {
                        newRow.one("#statusOfRpec").set('text',
                            "Nullified");
                        newRow.one("#statusOfRpec").set('title',
                            "Nullified");
                        newRow
                            .one("#statusOfRpec")
                            .set(
                                'style',
                                'background-color: #ffb5b5;color: #810000 !important;padding:3px !important;white-space: nowrap;overflow: hidden;text-overflow: ellipsis;');
                    }

                    var expandBtn = "<button id='expand-popover' onclick='show(this," +
                        "\"" +
                        data.contentJson.storageId +
                        "\"" +
                        ")' Class='more pop expand' style='padding: 11px 8px 11px 13px !important; '></button>";
                    newRow.one("#expandCell").html(expandBtn);

                    var contextMenuBtn = "<button id='more-popover' onclick='showPopOver(this)' Class='more pop' style='background: url(/SPRPEC-portlet/img/big.png) 0px 5px no-repeat'></button>";

                    newRow.one("#context").html(contextMenuBtn);
                    callContextMenuList(statusOfRpec, contectMenuEle, data.contentJson);
                    newRow.one("#context").append(contectMenuEle);

                    var detRow = newRow1
                        .one("#_eRPEC_WAR_SPRPECportlet_detRow");
                    detRow._node.classList
                        .add("#_eRPEC_WAR_SPRPECportlet_detRow_" +
                            data.contentJson.storageId);
                    var det2Row = detRow
                        .one("#_eRPEC_WAR_SPRPECportlet_leftTbl");
                    var det3Row = detRow
                        .one("#_eRPEC_WAR_SPRPECportlet_rightTbl");
                    var nodataDet = newRow1
                        .one("#_eRPEC_WAR_SPRPECportlet_nodata");
                    nodataDet._node.classList
                        .add("#_eRPEC_WAR_SPRPECportlet_nodata_" +
                            data.contentJson.storageId);
                    //
                    if (data.contentJson.competency.length <= 0) {
                        hide(det2Row);
                        hide(det3Row);
                        show(nodataDet);
                        // detRow.removeChild(detRow._node.firstElementChild);
                        // detRow.removeChild(detRow._node.firstElementChild);

                        // var divPro = document.createElement("DIV");
                        //
                        // divPro.setAttribute("style", "width:100%
                        // !important;text-align: center !important;
                        // color:rgb(154, 158, 162) !important;");
                        // divPro.innerHTML = "No Data Found!"
                        // detRow.appendChild(divPro);

                    } else {
                        hide(nodataDet);
                        show(det2Row);
                        show(det3Row);

                        var det2Row = detRow
                            .one("#_eRPEC_WAR_SPRPECportlet_leftTbl");

                        var det3Row = detRow
                            .one("#_eRPEC_WAR_SPRPECportlet_rightTbl");
                        for (var k = 0; k < data.contentJson.competency.length; k++) {
                            var falg = true;

                            var tblPro = document
                                .createElement("TABLE");
                            tblPro
                                .setAttribute("style",
                                    "margin:0px auto !important;text-align:left!important");
                            tblPro.setAttribute("id", "tbl_" + k + "_" +
                                data.contentJson.storageId);
                            var thead = document.createElement("thead");
                            var rowth = document.createElement("tr");
                            var th = document.createElement("th");
                            var thText1 = document
                                .createTextNode("Sr No");
                            th.style.textAlign = "right";
                            th.appendChild(thText1);
                            rowth.appendChild(th);
                            var th1 = document.createElement("th");
                            var thText2 = document
                                .createTextNode("Competency Type");
                            th1.appendChild(thText2);
                            rowth.appendChild(th1);
                            var th2 = document.createElement("th");
                            var thText3 = document
                                .createTextNode("Average Profenciency Level");
                            th2.style.textAlign = "right"
                            th2.appendChild(thText3);
                            rowth.appendChild(th2);
                            thead.appendChild(rowth);
                            tblPro.appendChild(thead);
                            var srNo = k + 1;
                            var tbody = document.createElement("tbody");
                            var row1 = document.createElement("tr");

                            var cellMain1 = document
                                .createElement("td");
                            var cellMainText1 = document
                                .createTextNode(srNo);
                            cellMain1.appendChild(cellMainText1);
                            cellMain1.style.textAlign = "right";
                            row1.appendChild(cellMain1);

                            var cellMain2 = document
                                .createElement("td");
                            var cellMainText2 = document
                                .createTextNode(data.contentJson.competency[k].competencyName);
                            cellMain2.appendChild(cellMainText2);

                            row1.appendChild(cellMain2);

                            var cellMain3 = document
                                .createElement("td");
                            var cellMainText3 = document
                                .createTextNode(0);
                            cellMain3.style.textAlign = "right";
                            cellMain3.appendChild(cellMainText3);

                            row1.appendChild(cellMain3);
                            tbody.appendChild(row1);

                            // tblPro.removeClass("hide");
                            var wholeScore = 0;
                            for (var i = 0; i < data.contentJson.competency[k].competencyDetail.length; i++) {

                                // creates a table row

                                srNo += 0.1;
                                for (var j = 0; j < 2; j++) {
                                    var row = document
                                        .createElement("tr");

                                    var cell1 = document
                                        .createElement("td");
                                    var cellText1 = document
                                        .createTextNode(parseFloat(srNo
                                            .toFixed(2)));
                                    cell1.style.textAlign = "right";
                                    cell1.appendChild(cellText1);
                                    row.appendChild(cell1);
                                    var cell2 = document
                                        .createElement("td");
                                    var cellText2 = document
                                        .createTextNode(data.contentJson.competency[k].competencyDetail[i].subjectName);
                                    cell2.appendChild(cellText2);
                                    row.appendChild(cell2);
                                    var cell3 = document
                                        .createElement("td");
                                    
                                    var totalScore = 0;
                                    for (var t = 0; t < data.contentJson.competency[k].competencyDetail[i].questionList.length; t++) {
                                        totalScore += data.contentJson.competency[k].competencyDetail[i].questionList[t].score;

                                    }
                                    var totalScoreAvg=(totalScore / data.contentJson.competency[k].competencyDetail[i].questionList.length).toFixed(2);
                                    var cellText3 ;
                                   
                                    if(totalScoreAvg=="NaN")
                                    {
                                    	cellText3 = document.createTextNode("0.0");
                                    	
                                    }
                                    else
                                    {
                                    	cellText3= document
                                        .createTextNode(totalScoreAvg);
                                    }
                                           
                                    cell3.style.textAlign = "right";
                                    cell3.appendChild(cellText3);             	
                                                                      
                                    row.appendChild(cell3);
                                }
                                tbody.appendChild(row);

                            }
                            tblPro.appendChild(tbody);

                            for (var t = 1; t < tblPro.children[1].childElementCount; t++) {
                                wholeScore += Number(tblPro.children[1].children[t].children[2].textContent);
                            }

                            if (data.contentJson.competency[k].competencyName
                                .includes("generic") ||
                                data.contentJson.competency[k].competencyName
                                .includes("GENERIC COMPETENCES")) {
                                for (var t = 1; t < tblPro.children[1].childElementCount; t++) {
                                    tblPro.children[1].children[t].classList
                                        .add("hide");

                                }

                            }
                            tblPro.children[1].children[0].children[2].textContent = (wholeScore / (tblPro.children[1].childElementCount - 1))
                                .toFixed(2);

                            if ((k + 1) % 2 == 0) {
                                det3Row.appendChild(tblPro);
                            } else {
                                det2Row.appendChild(tblPro);
                            }

                        }
                        if (data.contentJson.competency.length == 1) {
                            hide(det3Row);
                        }
                    }
                    hide(newRow1);
                    show(newRow);
                    rowContainer.appendChild(newRow);
                    rowContainer.appendChild(newRow1);
                    document.getElementById("selectedCount").innerHTML = counter;
                    var mrVal = document.querySelectorAll('.Row')[0].firstElementChild.clientWidth -
                        document.querySelectorAll('.Row')[0].clientWidth;
                    document
                        .querySelector("#_eRPEC_WAR_SPRPECportlet_detRow").style.marginRight = mrVal +
                        'px !important';
                    detRow._node.classList.remove('row-fluid');

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
         

function sortMain(responseData,sortFlag,sortField)
{
	
	
	

	console.log("sortField::"+sortField);
	if(sortField=="reviewPeriodNumber")
	{
    	 if (sortFlag == 'true') {
             populateEntityRecords(responseData
                 .sort(function(a, b) {
                     return b.contentJson.reviewPeriodNumber -
                         a.contentJson.reviewPeriodNumber;
                 }));
         } else {

             populateEntityRecords(responseData
                 .sort(function(a, b) {
                     return a.contentJson.reviewPeriodNumber -
                         b.contentJson.reviewPeriodNumber;
                 }));
         }
		
	}
	else if(sortField=="totalDaysSpentOnPracticalExperience")
	{
   	 if (sortFlag == 'true') {
            populateEntityRecords(responseData
                .sort(function(a, b) {
                    return b.contentJson.totalDaysSpentOnPracticalExperience -
                        a.contentJson.totalDaysSpentOnPracticalExperience;
                }));
        } else {

            populateEntityRecords(responseData
                .sort(function(a, b) {
                    return a.contentJson.totalDaysSpentOnPracticalExperience -
                        b.contentJson.totalDaysSpentOnPracticalExperience;
                }));
        }
		
	}
	else if(sortField=="candidateName")
	{
			if (sortFlag == 'true') {
	           
	             populateEntityRecords(responseData
	                     .sort(function(a, b) {
	                     
	                         
	                      var nameA = a.contentJson.candidateName.toUpperCase(); 
	                   	  var nameB = b.contentJson.candidateName.toUpperCase(); 
	                   	  if (nameA > nameB) {
	                   	    return -1;
	                   	  }
	                   	  if (nameA < nameB) {
	                   	    return 1;
	                   	  }

	                   	  // names must be equal
	                   	  return 0;
	                   	 
	                         
	                         
	                         
	                     }));
			}
			else{
                 populateEntityRecords(responseData
                         .sort(function(a, b) {
                         
                             
                          var nameA = a.contentJson.candidateName.toUpperCase(); 
                       	  var nameB = b.contentJson.candidateName.toUpperCase(); 
                       	  if (nameA < nameB) {
                       	    return -1;
                       	  }
                       	  if (nameA > nameB) {
                       	    return 1;
                       	  }

                       	  // names must be equal
                       	  return 0;
                       	 
                             
                             
                             
                         }));
                     
             }
         
    }
	else if(sortField=="rpecStatus")
	{
			if (sortFlag == 'true') {
	           
	             populateEntityRecords(responseData
	                     .sort(function(a, b) {
	                     
	                         
	                      var nameA = a.contentJson.rpecStatus.toUpperCase(); 
	                   	  var nameB = b.contentJson.rpecStatus.toUpperCase(); 
	                   	  if (nameA > nameB) {
	                   	    return -1;
	                   	  }
	                   	  if (nameA < nameB) {
	                   	    return 1;
	                   	  }

	                   	  // names must be equal
	                   	  return 0;
	                   	 
	                         
	                         
	                         
	                     }));
			}
			else{
                 populateEntityRecords(responseData
                         .sort(function(a, b) {
                         
                             
                          var nameA = a.contentJson.rpecStatus.toUpperCase(); 
                       	  var nameB = b.contentJson.rpecStatus.toUpperCase(); 
                       	  if (nameA < nameB) {
                       	    return -1;
                       	  }
                       	  if (nameA > nameB) {
                       	    return 1;
                       	  }

                       	  // names must be equal
                       	  return 0;
                       	 
                             
                             
                             
                         }));
                     
             }
         
    }
	else if(sortField=="accreditedTrainingOrganisation")
	{
			if (sortFlag == 'true') {
	           
	             populateEntityRecords(responseData
	                     .sort(function(a, b) {
	                     
	                         
	                      var nameA = a.contentJson.accreditedTrainingOrganisation.toUpperCase(); 
	                   	  var nameB = b.contentJson.accreditedTrainingOrganisation.toUpperCase(); 
	                   	  if (nameA > nameB) {
	                   	    return -1;
	                   	  }
	                   	  if (nameA < nameB) {
	                   	    return 1;
	                   	  }

	                   	  // names must be equal
	                   	  return 0;
	                   	 
	                         
	                         
	                         
	                     }));
			}
			else{
                 populateEntityRecords(responseData
                         .sort(function(a, b) {
                         
                             
                          var nameA = a.contentJson.accreditedTrainingOrganisation.toUpperCase(); 
                       	  var nameB = b.contentJson.accreditedTrainingOrganisation.toUpperCase(); 
                       	  if (nameA < nameB) {
                       	    return -1;
                       	  }
                       	  if (nameA > nameB) {
                       	    return 1;
                       	  }

                       	  // names must be equal
                       	  return 0;
                       	 
                             
                             
                             
                         }));
                     
             }
         
    }
	else if(sortField=="mentorName")
	{
			if (sortFlag == 'true') {
	           
	             populateEntityRecords(responseData
	                     .sort(function(a, b) {
	                     
	                         
	                      var nameA = a.contentJson.mentorName.toUpperCase(); 
	                   	  var nameB = b.contentJson.mentorName.toUpperCase(); 
	                   	  if (nameA > nameB) {
	                   	    return -1;
	                   	  }
	                   	  if (nameA < nameB) {
	                   	    return 1;
	                   	  }

	                   	  // names must be equal
	                   	  return 0;
	                   	 
	                         
	                         
	                         
	                     }));
			}
			else{
                 populateEntityRecords(responseData
                         .sort(function(a, b) {
                         
                             
                          var nameA = a.contentJson.mentorName.toUpperCase(); 
                       	  var nameB = b.contentJson.mentorName.toUpperCase(); 
                       	  if (nameA < nameB) {
                       	    return -1;
                       	  }
                       	  if (nameA > nameB) {
                       	    return 1;
                       	  }

                       	  // names must be equal
                       	  return 0;
                       	 
                             
                             
                             
                         }));
                     
             }
         
    }
	else if(sortField=="candidateJobRole")
	{
			if (sortFlag == 'true') {
	           
	             populateEntityRecords(responseData
	                     .sort(function(a, b) {
	                     
	                         
	                      var nameA = a.contentJson.candidateJobRole.toUpperCase(); 
	                   	  var nameB = b.contentJson.candidateJobRole.toUpperCase(); 
	                   	  if (nameA > nameB) {
	                   	    return -1;
	                   	  }
	                   	  if (nameA < nameB) {
	                   	    return 1;
	                   	  }

	                   	  // names must be equal
	                   	  return 0;
	                   	 
	                         
	                         
	                         
	                     }));
			}
			else{
                 populateEntityRecords(responseData
                         .sort(function(a, b) {
                         
                             
                          var nameA = a.contentJson.candidateJobRole.toUpperCase(); 
                       	  var nameB = b.contentJson.candidateJobRole.toUpperCase(); 
                       	  if (nameA < nameB) {
                       	    return -1;
                       	  }
                       	  if (nameA > nameB) {
                       	    return 1;
                       	  }

                       	  // names must be equal
                       	  return 0;
                       	 
                             
                             
                             
                         }));
                     
             }
         
    }
	else if(sortField=="reviewFromDate")
	{
		
			if (sortFlag == 'true') {
	           
	             populateEntityRecords(responseData
	                     .sort(function(a, b) {
	                     
	                    	 var date1=a.contentJson.reviewFromDate.split(" ")[0].replace(/-/g, '/');
	                    	 var date2=b.contentJson.reviewFromDate.split(" ")[0].replace(/-/g, '/');
	                    	 var nameA=date1.split("/");
	                       	  var nameB =date2.split("/");
	                       	
	                    	 return (new Date(nameB[1]+"/"+nameB[0]+"/"+nameB[2]).getTime()) - (new Date(nameA[1]+"/"+nameA[0]+"/"+nameA[2]).getTime()) ;
	                   	 
	                         
	                         
	                         
	                     }));
			}
			else{
                 populateEntityRecords(responseData
                         .sort(function(a, b) {
                         
                        	 
                        	 var date1=a.contentJson.reviewFromDate.split(" ")[0].replace(/-/g, '/');
	                    	 var date2=b.contentJson.reviewFromDate.split(" ")[0].replace(/-/g, '/');
	                    	 var nameA=date1.split("/");
	                       	  var nameB =date2.split("/");
	                       	
	                    	 return (new Date(nameA[1]+"/"+nameA[0]+"/"+nameA[2]).getTime()) - (new Date(nameB[1]+"/"+nameB[0]+"/"+nameB[2]).getTime()) ;
	                   	 
                        	
                             
                         }));
                     
             }
         
    }
	else if(sortField=="reviewToDate")
	{
		
			if (sortFlag == 'true') {
	           
	             populateEntityRecords(responseData
	                     .sort(function(a, b) {
	                     
	                    	
	                       
	                    	 
	                    	 var date1=a.contentJson.reviewToDate.split(" ")[0].replace(/-/g, '/');
	                    	 var date2=b.contentJson.reviewToDate.split(" ")[0].replace(/-/g, '/');
	                    	 var nameA=date1.split("/");
	                       	  var nameB =date2.split("/");
	                       
	                    	 return (new Date(nameB[1]+"/"+nameB[0]+"/"+nameB[2]).getTime()) - (new Date(nameA[1]+"/"+nameA[0]+"/"+nameA[2]).getTime()) ;
	                   	 
	                         
	                         
	                     }));
			}
			else{
                 populateEntityRecords(responseData
                         .sort(function(a, b) {
                         
                        	
                        	  
                       	 
                        	 
                        	 var date1=a.contentJson.reviewToDate.split(" ")[0].replace(/-/g, '/');
	                    	 var date2=b.contentJson.reviewToDate.split(" ")[0].replace(/-/g, '/');
	                    	 var nameA=date1.split("/");
	                       	  var nameB =date2.split("/");
	                       	
	                    	 return (new Date(nameA[1]+"/"+nameA[0]+"/"+nameA[2]).getTime()) - (new Date(nameB[1]+"/"+nameB[0]+"/"+nameB[2]).getTime()) ;
	                   	 
                        	
                             
                         }));
                     
             }
         
    }
	else
	{
		if (sortFlag == 'true') {
            populateEntityRecords(responseData
                .sort(function(a, b) {
                    return b.contentJson.reviewPeriodNumber -
                        a.contentJson.reviewPeriodNumber;
                }));
        } else {

            populateEntityRecords(responseData
                .sort(function(a, b) {
                    return a.contentJson.reviewPeriodNumber -
                        b.contentJson.reviewPeriodNumber;
                }));
        }
		
		
		
		
	}
	
}
            });

    
    	var requestCandidate	= {
             	"formType": "erpec",
               	"userType": userType
          		}
    
    	ajaxCallAPI(
                'POST',
                'getcandidateforinternaluser',
                requestCandidate,
                function() {
                	debugger;
                	
                	candidateList = this.get("responseData");
                	
//                	if(userType.toLowerCase() === 'mentor' || userType.toLowerCase() === "trainingprincipal")
//                	{
//                		candidateList = JSON.parse(this.get("responseData"));
//                	}
//                	else
//                	{
//                		candidateList = this.get("responseData");
//                	}
                });
    }
    
function sortData(e,a) {
    var classArrSort = e.classList;
    if (classArrSort.contains("listsortasc")) {
        e.classList.remove("listsortasc");
        e.classList.add("listsortdesc");
        init2('true',a);

    } else if (classArrSort.contains("listsortdesc")) {

        e.classList.remove("listsortdesc");
        e.classList.add("listsortasc");
        init2('false',a);
    }

    console.log("called");

}

function callContextMenuList(status, ele, contentJson) {

    for (var i = 0; i < ele._node.firstElementChild.childElementCount; i++) {
        ele._node.firstElementChild.children[i].classList.remove("hide");
        
        if (status === "Draft") {
        	if (userType.toLowerCase() === "candidate") {
        		if(ele._node.firstElementChild.children[i].innerText !== "View Detail"
        			&& ele._node.firstElementChild.children[i].innerText !== "Edit Detail"
        			&& ele._node.firstElementChild.children[i].innerText !== "Export"
        			&& ele._node.firstElementChild.children[i].innerText !== "Archive")
        		{
        			ele._node.firstElementChild.children[i].classList.add("hide");
        		}
        	}else if (userType.toLowerCase() === "mentor")
        	{
        		if(ele._node.firstElementChild.children[i].innerText !== "View Detail" && ele._node.firstElementChild.children[i].innerText !== "Export")
        		{
        			ele._node.firstElementChild.children[i].classList.add("hide");
        		}
        	}else if (userType.toLowerCase() === "trainingprincipal")
        	{
        		if(ele._node.firstElementChild.children[i].innerText !== "View Detail" && ele._node.firstElementChild.children[i].innerText !== "Export")
        			ele._node.firstElementChild.children[i].classList.add("hide");
        	}else if (userType.toLowerCase() === "relcuser")
        	{
        		if(ele._node.firstElementChild.children[i].innerText !== "View Detail" && ele._node.firstElementChild.children[i].innerText !== "Edit Detail"
        			&& ele._node.firstElementChild.children[i].innerText !== "Export" && ele._node.firstElementChild.children[i].innerText !== "Archive")
        			ele._node.firstElementChild.children[i].classList.add("hide");
        	}
        } else if (status === "Rejected") {
        	if (userType.toLowerCase() === "candidate") {
        		if(ele._node.firstElementChild.children[i].innerText !== "View Detail" && ele._node.firstElementChild.children[i].innerText !== "Update/Amend Detail"
        			&& ele._node.firstElementChild.children[i].innerText !== "Export")
        			ele._node.firstElementChild.children[i].classList.add("hide");
        	}else if (userType.toLowerCase() === "mentor")
        	{
        		if(ele._node.firstElementChild.children[i].innerText !== "View Detail" && ele._node.firstElementChild.children[i].innerText !== "Export")
        		{
        			ele._node.firstElementChild.children[i].classList.add("hide");
        		}
        	}else if (userType.toLowerCase() === "trainingprincipal")
        	{
        		if(ele._node.firstElementChild.children[i].innerText !== "View Detail" && ele._node.firstElementChild.children[i].innerText !== "Export")
        			ele._node.firstElementChild.children[i].classList.add("hide");
        	}else if (userType.toLowerCase() === "relcuser")
        	{
        		if(ele._node.firstElementChild.children[i].innerText !== "View Detail" && ele._node.firstElementChild.children[i].innerText !== "Update/Amend Detail"
        			&& ele._node.firstElementChild.children[i].innerText !== "Export")
        			ele._node.firstElementChild.children[i].classList.add("hide");
        	}
        } else if (status === "Completed") {
        	if (userType.toLowerCase() === "candidate") {
        		if(ele._node.firstElementChild.children[i].innerText !== "View Detail" && ele._node.firstElementChild.children[i].innerText !== "Export")
        			ele._node.firstElementChild.children[i].classList.add("hide");
        	} else if (userType.toLowerCase() === "mentor"){
        		if(ele._node.firstElementChild.children[i].innerText !== "View Detail" && ele._node.firstElementChild.children[i].innerText !== "Export")
        		{
        			ele._node.firstElementChild.children[i].classList.add("hide");
        		}
        	} else if (userType.toLowerCase() === "trainingprincipal"){
        		if (ele._node.firstElementChild.children[i].innerText !== "View Detail" && ele._node.firstElementChild.children[i].innerText !== "Export")
        		{
        			ele._node.firstElementChild.children[i].classList.add("hide");
        		}
        	} else if (userType.toLowerCase() === "relcuser"){
        		if (ele._node.firstElementChild.children[i].innerText !== "View Detail" && ele._node.firstElementChild.children[i].innerText !== "Export")
        		{
        			ele._node.firstElementChild.children[i].classList.add("hide");
        		}
        	} else if (userType.toLowerCase() === "relcuser")
        	{
        		if(ele._node.firstElementChild.children[i].innerText !== "View Detail" && ele._node.firstElementChild.children[i].innerText !== "Edit Detail"
        			&& ele._node.firstElementChild.children[i].innerText !== "Export" && ele._node.firstElementChild.children[i].innerText !== "Archive")
        			ele._node.firstElementChild.children[i].classList.add("hide");
        	}
        } else if (status === "Pending Standard Approval")
        {
        	if (userType.toLowerCase() === "candidate") {
        		if(ele._node.firstElementChild.children[i].innerText !== "View Detail" && ele._node.firstElementChild.children[i].innerText !== "Export")
        			ele._node.firstElementChild.children[i].classList.add("hide");
        	} else if (userType.toLowerCase() === "mentor"){
        		if(ele._node.firstElementChild.children[i].innerText !== "View Detail" && ele._node.firstElementChild.children[i].innerText !== "Export"
        			&& ele._node.firstElementChild.children[i].innerText !== "Review RPEC Record")
        		{
        			ele._node.firstElementChild.children[i].classList.add("hide");
        		}
        	} else if (userType.toLowerCase() === "trainingprincipal"){
        		if(ele._node.firstElementChild.children[i].innerText !== "View Detail" && ele._node.firstElementChild.children[i].innerText !== "Export")
        		{
        			ele._node.firstElementChild.children[i].classList.add("hide");
        		}
        			
        	}else if (userType.toLowerCase() === "relcuser")
        	{
        		if(ele._node.firstElementChild.children[i].innerText !== "View Detail" && ele._node.firstElementChild.children[i].innerText !== "Edit Detail")
        			ele._node.firstElementChild.children[i].classList.add("hide");
        	}
        } else if (status === "Pending Final Approval")
        {
        	if (userType.toLowerCase() === "candidate") {
        		if(ele._node.firstElementChild.children[i].innerText !== "View Detail" && ele._node.firstElementChild.children[i].innerText !== "Export")
        		{
        			ele._node.firstElementChild.children[i].classList.add("hide");
        		}
        			
        	} else if (userType.toLowerCase() === "mentor"){
        		if(ele._node.firstElementChild.children[i].innerText !== "View Detail" && ele._node.firstElementChild.children[i].innerText !== "Export"
        			&& ele._node.firstElementChild.children[i].innerText !== "Review RPEC Record")
        		{
        			ele._node.firstElementChild.children[i].classList.add("hide");
        		}
        	} else if (userType.toLowerCase() === "trainingprincipal"){
        		if(ele._node.firstElementChild.children[i].innerText !== "View Detail" && ele._node.firstElementChild.children[i].innerText !== "Export")
        		{
        			ele._node.firstElementChild.children[i].classList.add("hide");
        		}
        			
        	} else if (userType.toLowerCase() === "relcuser")
        	{
        		if(ele._node.firstElementChild.children[i].innerText !== "View Detail" && ele._node.firstElementChild.children[i].innerText !== "Edit Detail")
        			ele._node.firstElementChild.children[i].classList.add("hide");
        	}
        } else if (status === "Pending Sign Off") {
        	if (userType.toLowerCase() === "candidate") {
        		if(ele._node.firstElementChild.children[i].innerText !== "View Detail" && ele._node.firstElementChild.children[i].innerText !== "Export")
        			ele._node.firstElementChild.children[i].classList.add("hide");
        	} else if (userType.toLowerCase() === "mentor"){
        		if(ele._node.firstElementChild.children[i].innerText !== "View Detail" && ele._node.firstElementChild.children[i].innerText !== "Export")
        		{
        			ele._node.firstElementChild.children[i].classList.add("hide");
        		}
        	} else if (userType.toLowerCase() === "trainingprincipal"){
        		if(ele._node.firstElementChild.children[i].innerText !== "View Detail" && ele._node.firstElementChild.children[i].innerText !== "Export"
        			&& ele._node.firstElementChild.children[i].innerText !== "Review RPEC Record")
        		{
        			ele._node.firstElementChild.children[i].classList.add("hide");
        		}
        			
        	} else if (userType.toLowerCase() === "relcuser")
        	{
        		if(ele._node.firstElementChild.children[i].innerText !== "View Detail" && ele._node.firstElementChild.children[i].innerText !== "Edit Detail"
        			&& ele._node.firstElementChild.children[i].innerText !== "Nullify Record")
        			ele._node.firstElementChild.children[i].classList.add("hide");
        	}
        } else if (status === "Nullified") {
        	if (userType.toLowerCase() === "candidate") {
        		if(ele._node.firstElementChild.children[i].innerText !== "View Detail" && ele._node.firstElementChild.children[i].innerText !== "Export")
        		{
        			ele._node.firstElementChild.children[i].classList.add("hide");
        		}
        	} else if (userType.toLowerCase() === "mentor"){
        		if(ele._node.firstElementChild.children[i].innerText !== "View Detail" && ele._node.firstElementChild.children[i].innerText !== "Export")
        		{
        			ele._node.firstElementChild.children[i].classList.add("hide");
        		}
        	} else if (userType.toLowerCase() === "trainingprincipal"){
        		if(ele._node.firstElementChild.children[i].innerText !== "View Detail" && ele._node.firstElementChild.children[i].innerText !== "Export")
        		{
        			ele._node.firstElementChild.children[i].classList.add("hide");
        		}
        	} else if (userType.toLowerCase() === "relcuser"){
        		if(ele._node.firstElementChild.children[i].innerText !== "View Detail" && ele._node.firstElementChild.children[i].innerText !== "Export"
        			&& ele._node.firstElementChild.children[i].innerText !== "Archive")
        		{
        			ele._node.firstElementChild.children[i].classList.add("hide");
        		}
        	}
        } else if (status === "Approved") {
        	if (userType.toLowerCase() === "candidate") {
        		if(ele._node.firstElementChild.children[i].innerText !== "View Detail" && ele._node.firstElementChild.children[i].innerText !== "Export")
        		{
        			ele._node.firstElementChild.children[i].classList.add("hide");
        		}
        	} else if (userType.toLowerCase() === "mentor"){
        		if(ele._node.firstElementChild.children[i].innerText !== "View Detail" && ele._node.firstElementChild.children[i].innerText !== "Export")
        		{
        			ele._node.firstElementChild.children[i].classList.add("hide");
        		}
        	} else if (userType.toLowerCase() === "trainingprincipal"){
        		if(ele._node.firstElementChild.children[i].innerText !== "View Detail" && ele._node.firstElementChild.children[i].innerText !== "Export")
        		{
        			ele._node.firstElementChild.children[i].classList.add("hide");
        		}
        			
        	} else if (userType.toLowerCase() === "relcuser")
        	{
        		if(ele._node.firstElementChild.children[i].innerText !== "View Detail" && ele._node.firstElementChild.children[i].innerText !== "Nullify Record"
        			&& ele._node.firstElementChild.children[i].innerText !== "Export")
        		{
        				ele._node.firstElementChild.children[i].classList.add("hide");
        		}
        		
        		if(ele._node.firstElementChild.children[i].innerText === "Nullify Record" && !isNullify)
        		{
        			ele._node.firstElementChild.children[i].classList.add("hide");
        		}
        			
        	}
        }
        
        
// if (status == "Draft") {
// if (ele._node.firstElementChild.children[i].innerText == "Update/Amend
// Detail") {
// ele._node.firstElementChild.children[i].classList.add("hide");
// } else if (ele._node.firstElementChild.children[i].innerText == "Review RPEC
// Record") {
// ele._node.firstElementChild.children[i].classList.add("hide");
// } else if (ele._node.firstElementChild.children[i].innerText == "Mark As
// Approved") {
// ele._node.firstElementChild.children[i].classList.add("hide");
// } else if (ele._node.firstElementChild.children[i].innerText == "Nullify
// Record") {
// ele._node.firstElementChild.children[i].classList.add("hide");
// }
//
// } else if (status == "Rejected") {
// if (ele._node.firstElementChild.children[i].innerText == "Edit Detail" ||
// ele._node.firstElementChild.children[i].innerText == "Archive") {
// ele._node.firstElementChild.children[i].classList.add("hide");
// }
// } else if (status == "Completed") {
//
// if (ele._node.firstElementChild.children[i].innerText != "View Detail") {
// if (ele._node.firstElementChild.children[i].innerText != "Export") {
// // if (ele._node.firstElementChild.children[i].innerText != "Archive") {
// ele._node.firstElementChild.children[i].classList
// .add("hide");
// // }
// }
//
// }
// // if (userType.toLowerCase() == "relcuser") {
// // if (ele._node.firstElementChild.children[i].innerText == "Nullify Record")
// {
// // ele._node.firstElementChild.children[i].classList
// // .remove("hide");
// // }
// // }
//
// } else if (status == "Pending Standard Approval" ||
// status == "Pending Final Approval") {
// if (userType.toLowerCase() == "candidate") {
// if (ele._node.firstElementChild.children[i].innerText != "View Detail") {
// if (ele._node.firstElementChild.children[i].innerText != "Export") {
// // if (ele._node.firstElementChild.children[i].innerText != "Archive") {
//
// ele._node.firstElementChild.children[i].classList
// .add("hide");
// //}
// }
// }
// }
// else if(userType.toLowerCase() == "relcuser")
// {
// if (ele._node.firstElementChild.children[i].innerText != "Export") {
// if (ele._node.firstElementChild.children[i].innerText != "View Detail") {
// ele._node.firstElementChild.children[i].classList.add("hide");
// }
// }
// }else {
// //if (ele._node.firstElementChild.children[i].innerText != "Archive") {
// if (ele._node.firstElementChild.children[i].innerText != "Review RPEC
// Record") {
// if (ele._node.firstElementChild.children[i].innerText != "Export") {
// if (ele._node.firstElementChild.children[i].innerText != "View Detail") {
// ele._node.firstElementChild.children[i].classList
// .add("hide");
// }
// }
// //}
// }
// }
// } else if (status == "Pending Sign Off") {
//        	
// if(userType.toLowerCase() == "relcuser")
// {
// if (ele._node.firstElementChild.children[i].innerText != "Export") {
// if (ele._node.firstElementChild.children[i].innerText != "View Detail") {
// ele._node.firstElementChild.children[i].classList.add("hide");
// }
// }
// }else
// {
// if (ele._node.firstElementChild.children[i].innerText != "Export") {
// if (ele._node.firstElementChild.children[i].innerText != "View Detail") {
// if (ele._node.firstElementChild.children[i].innerText != "Review RPEC
// Record") {
// ele._node.firstElementChild.children[i].classList.add("hide");
// }
// }
// }
// }
// } else if (status == "Nullified") {
// if (ele._node.firstElementChild.children[i].innerText != "Archive") {
// if (ele._node.firstElementChild.children[i].innerText != "Export") {
// if (ele._node.firstElementChild.children[i].innerText != "View Detail") {
// ele._node.firstElementChild.children[i].classList
// .add("hide");
// }
//
// }
// }
//
// } else if (status == "Approved") {
// if (ele._node.firstElementChild.children[i].innerText === "Edit Detail") {
// ele._node.firstElementChild.children[i].classList.add("hide");
// } else if (ele._node.firstElementChild.children[i].innerText ===
// "Update/Amend Detail") {
// ele._node.firstElementChild.children[i].classList.add("hide");
// } else if (ele._node.firstElementChild.children[i].innerText === "Nullify
// Record") {
// if(userType.toLowerCase() !== "relcuser")
// {
// ele._node.firstElementChild.children[i].classList.add("hide");
// }
// } else if (ele._node.firstElementChild.children[i].innerText === "Review RPEC
// Record") {
// if(userType.toLowerCase() === "mentor".toLowerCase() &&
// contentJson.isFinalReview === true)
// {
// //ele._node.firstElementChild.children[i].classList.add("hide");
// }
// else
// {
// ele._node.firstElementChild.children[i].classList.add("hide");
// }
// } else if (ele._node.firstElementChild.children[i].innerText === "Mark As
// Approved") {
// ele._node.firstElementChild.children[i].classList.add("hide");
// } else if (ele._node.firstElementChild.children[i].innerText === "Archive") {
// if(userType.toLowerCase() === "relcuser")
// {
// ele._node.firstElementChild.children[i].classList.add("hide");
// }
// }
//            
// // else if (ele._node.firstElementChild.children[i].innerText ==
// // "Archive") {
// // ele._node.firstElementChild.children[i].classList.add("hide");
// // }
// }

    }
}

function show(child, storageId) {
    classArr = child.parentNode.parentElement.parentNode.nextElementSibling.classList;

    if (classArr.contains("hide")) {
        var mrVal = (document.querySelectorAll('.Row')[0].firstElementChild.clientWidth + 105) -
            document.querySelectorAll('.Row')[0].clientWidth;
        document.getElementsByClassName("#_eRPEC_WAR_SPRPECportlet_detRow_" +
            storageId)[0].setAttribute('style', "margin-right:" + mrVal +
            'px !important; padding: 15px;');
        var halfH = (mrVal / 2) - 100;
        document.getElementsByClassName("#_eRPEC_WAR_SPRPECportlet_nodata_" +
            storageId)[0].setAttribute('style', "margin-right:" + halfH +
            'px !important;margin-left: auto;');

        child.classList.remove("expand");
        child.classList.add("collapse");

        child.parentNode.parentElement.parentNode.nextElementSibling.classList
            .remove("hide");
        var heigthOfTec = document.getElementById("tbl_0_" + storageId).clientHeight;
        document.getElementById("tbl_1_" + storageId).parentNode.style.minHeight = heigthOfTec +
            "px";
    } else {
        child.classList.remove("collapse");
        child.classList.add("expand");
        child.parentNode.parentElement.parentNode.nextElementSibling.classList
            .add("hide");
    }

}

function showPopOver(child, status) {

    classArrForMenu = child.nextElementSibling.classList;
    if (classArrForMenu.contains("hide")) {

        child.nextElementSibling.classList.remove("hide");
    } else {

        child.nextElementSibling.classList.add("hide");
    }
}

function nullifyThisRecord(d) {
    var c = findAncestor(d, "Row");
    var storageId = c.children[0].children[0].textContent;
    // updateStatus("Nullified" , storageId);
    openSuccessPopup("#nullify-confirm", "#nullify-confirm-box", storageId);
}

function markAsApproved(d) {
    var c = findAncestor(d, "Row");
    var storageId = c.children[0].children[0].textContent;
    updateRPECStatus("Completed", storageId);
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
    ajaxCallAPI('POST', "elastiSearchList", filter, function() {
            data = this.get("responseData");
            contentdata = this.get("responseData");

            if (data.error) {
                displayMessageCustom('danger', data.error, 3000);
            } else {
                // responseData = contentdata.content;

            }
            callback(contentdata);
        },
        function() {
            displayMessageCustom('danger',
                "Error in persisting dynamic form data.", 3000);
            callback();
        });
}

function onCancel() {
    window.location.reload();
}

function showPage(page) {
    pageRequested = page;
    init2('false',"");
}

function reloadTable() {
    pageRequested = 1;
    init2('false',"");
}

function doAction(action, d) {
    AUI().use(
        'liferay-portlet-url',
        function(A) {
            var e = Liferay.PortletURL.createRenderURL();
            var c = findAncestor(d, "Row");
            e.setParameter("jspPage", config.createPage);

            if (c == null) {
                e.setParameter("formTypeName", modelName);
                e.options.basePortletURL = baseUrl;
                e.setParameter("mode", "create");
                if (userType.toLowerCase() == "candidate") {
                    e.setParameter("candidateId", userId);
                } else {
//                    var candidateId = document.getElementById(namespace +
//                        "candidates").value;
                    e.setParameter("candidateId", userIdDD);
                }
                e.setPortletId(namespace.replace(/(^\_+|\_+$)/mg, ''));
                e.setParameter("storageId", "0");
                e.setWindowState("normal");
                e.setParameter("reviewPeriod", reviewPeriodNo);
                e.setParameter("isStandardReview", "false");
                e.setParameter("isFinalReview", "false");
                e.setParameter("isSignOff", "false");
                console.log("reviewPeriodNo:" + reviewPeriodNo);
            } else {

                e.setParameter("storageId",
                    c.children[0].children[0].textContent);
                e.setParameter("formTypeName", modelName);

                e.options.basePortletURL = baseUrl;

                if (action == 'edit') {
                    e.setParameter("mode", "edit");
                } else if (action == 'detail') {
                    e.setParameter("mode", "view");
                } else if (action == 'review') {
                    e.setParameter("mode", "review");
                } else if (action === 'nullify') {
                    e.setParameter("mode", "nullify");
                } else if (action === 'amend') {
                    e.setParameter("mode", "amend");
                }
                e.setPortletId(namespace.replace(/(^\_+|\_+$)/mg, ''));
                e.setParameter("candidateId",
                    c.children[1].firstElementChild.textContent);
                e.setWindowState("normal");
                e.setParameter("rpecStatus",
                    c.children[10].firstElementChild.textContent);
                e.setParameter("isStandardReview",
                    c.children[13].firstElementChild.textContent);
                e.setParameter("isFinalReview",
                    c.children[14].firstElementChild.textContent);
                e.setParameter("isSignOff",
                    c.children[15].firstElementChild.textContent);
            }
            e.setParameter("loggedInUser", userId);
            e.setParameter("userType", userType);
            window.location.href = e.toString();

        });
}

function archiveRecord(d) {
    debugger
    var c = findAncestor(d, "Row");

    var deleteData = {
        "storageId": c.children[0].children[0].textContent,
        "formType": "erpec",
    }

    ajaxCallAPI('POST', 'archiveRecord', deleteData, function() {
        if (this.get("responseData") !== undefined &&
            this.get("responseData") !== null) {
        	displayMessageCustom('success', "Record archive successfully", 3000);
            init2('false',"");
        }

    }, function() {

    });
}

function exportRecord(d) {
    debugger
    var c = findAncestor(d, "Row");

    var deleteData = {
        "storageId": c.children[0].children[0].textContent,
        "formType": "erpec",
    }

    ajaxCall('GET', 'exportRow', deleteData, function() {
        if (this.get("responseData") !== undefined &&
            this.get("responseData") !== null) {
            init2('false',"");
        }

    }, function() {

    });
}

function toggleToolTip(status) {
	if(status)
	{
		 if (document.getElementById("addRpec") != null) {
		        if (document.getElementById("addRpec").disabled) {
		            if (document.getElementById("tooltip").style.display === "none") {
		                document.getElementById("tooltip").style.display = "block";
		            }
		        }
		    }
	}
	
	if(!status)
	{
		if (document.getElementById("addRpec") != null) {
	        if (document.getElementById("addRpec").disabled) {
	            if (document.getElementById("tooltip").style.display === "block") {
	               document.getElementById("tooltip").style.display = "none";
	            }
	        }
	    }
	}
}

function openSuccessPopup(boundingBox, contentBox, storageId) {
    AUI()
        .use(
            'aui-base',
            function(A) {
                A.one(boundingBox).set('hidden', false);
                YUI()
                    .use(
                        'aui-modal',
                        function(Y) {
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
                            document.getElementById(contentBox
                                .substring(1)).childNodes[0].childNodes[0].childNodes[0].style.display = 'none';

                            Y
                                .one(
                                    '.popup-confirm-nullify')
                                .on(
                                    'click',
                                    function() {
                                        var remark = getEID("nullifyreason").value;
                                        updateRPECStatus(
                                            "Nullified",
                                            storageId);
                                        nullifyThisRecordWithRemarks(
                                            remark,
                                            storageId);
                                        modal.hide();
                                    });
                            Y.one('.popup-cancel-nullify').on(
                                'click',
                                function() {
                                    modal.hide();
                                });
                            Y
                                .one(
                                    '.popup-back-to-record-status')
                                .on(
                                    'click',
                                    function() {
                                        window.location
                                            .reload();
                                        modal.hide();
                                    });
                            Y
                                .one(
                                    '.popup-back-to-home-status')
                                .on(
                                    'click',
                                    function() {
                                        window.location.href = dashBoardLink;
                                        modal.hide();
                                    });

                        });

            });
}

function nullifyThisRecordWithRemarks(remark, storageId) {
    showLoading(true);
    var icode = new Date().getTime();
    var refID = storageId + "_Nullify";
    var contentJson = {
        "InvoiceRemarkCode": icode,
        "ReferenceId": refID,
        "ApprovalStatus": "pending",
        "RequestType": "RPEC",
        "Remark": remark,
        "UserName": userName
    }
    var remark = {
        "invoiceRemarkCode": icode,
        "referenceId": refID,
        "approvalStatus": "pending",
        "requestType": "RPEC",
        "remark": remark,
        "contentJson": contentJson
    }
    remark.formType = "invoiceremarks";
    remark.formStorageId = "0";

    ajaxCallAPI('POST', 'addRemarks', remark, function() {
        var data = this.get("responseData");
        if (data.error) {
            // displayMessageDiv('danger', data.error, 3000);
        } else if (Object.keys(data).length === 0) {
            console.log("data : " + data);
        } else {
            init2('false',"");
        }
        showLoading(false);
    }, function() {
        displayMessageDiv('danger', "Error in persisting dynamic form data.",
            3000);
        showLoading(false);
    });
}

function updateRPECStatus(status, storageId) {
	for(var i=0;i<responseData.length;i++)
	{
			if(responseData[i].storageId==storageId)
			{
				selectedData=responseData[i];
			}
	}
    showLoading(true);
    var contentJson = {
        "status": status,
        "userType": userType,
        "statusUpdateBy": userId,
        "modifiedByName" : userName,
        "trainingPrincipalId":selectedData.contentJson.trainingPrincipalId,
		"mentorId":selectedData.contentJson.mentorId
    }
    var statusData = {
        "contentJson": contentJson,
        "storageId": storageId,
        "formType": "erpec",
    }

    ajaxCallAPI('POST', 'updateStatus', statusData, function() {
        showLoading(false);
        if (this.get("responseData") !== undefined &&
            this.get("responseData") !== null) {
            if (status !== "Nullified") {
                openSuccessPopup("#success-status-update",
                    "#success-status-update-box");
            }
        }
    }, function() {
        showLoading(false);
    });
}

function globalExportList(e) {
    e.preventDefault();
    e.stopPropagation();
    var globalexportlisturlcopy = globalexportlisturl;
    globalexportlisturlcopy += "&" + namespace + "formType" + "=" + modelName;
    window.open(globalexportlisturlcopy);
}

function exportStorage1(e, d) {
    e.preventDefault();
    e.stopPropagation();
    var c = findAncestor(d, "Row");
    var a = [];
    for (var b = 0; b < c.childElementCount; b++) {
        a.push(c.children[b].textContent.trim())
    }
    
    var globalexportlisturlcopy = globalexportlisturl;
    
    globalexportlisturlcopy += "&" + namespace + "formType" + "=" + modelName + "&" +
        namespace + "formStorageId" + "=" + encodeURIComponent(a[0]);
    
    
    window.open(globalexportlisturlcopy);

}

function propogateCandidateSearchOptions()
{
	if (getEID('choicesList').style.display === "none") {
		getEID('choicesList').style.display = "block";
		getEID('Candidatesearchbar').style.display = "block";
		//getEID('choices__list').style.display = "block";
		getEID('candidateSearchButton').classList.add("search-open");
		getEID('candidateSearchButton').classList.remove("search-close");
	}else
	{
		getEID('choicesList').style.display = "none";
		getEID('Candidatesearchbar').style.display = "none";
		//getEID('choices__list').style.display = "none";
		getEID('candidateSearchButton').classList.add("search-close");
		getEID('candidateSearchButton').classList.remove("search-open");
	}
}

function propogateCandidateSearchResults(searchTerm) {
	//var competenciesSubjects = subjectsByPanel[panelId];
	
	getEID('choicesList').innerHTML = "";
//	var candidateListParse = JSON.parse(candidatesList);
	if (searchTerm !== undefined && searchTerm.length > 0) {
		searchTerm = searchTerm.toLowerCase();
		var filtered = candidateList.filter(function(i) {debugger;
			if(typeof i === 'object')
			{
				return (i.IDNumber + i.FirstName).toLowerCase().includes(searchTerm);
			}
		});
		filtered.forEach(function(candidate) {
			getEID('choicesList').innerHTML += createOptions(
					'['+candidate.IDNumber+'] '+candidate.FirstName ,candidate.UserId);
		});
	} else {
		candidateList.forEach(function(candidate) {
			if(typeof candidate === 'object')
			{
				getEID('choicesList').innerHTML += createOptions(
						'['+candidate.IDNumber+'] '+candidate.FirstName ,candidate.UserId);
			}
		});
	}
}


function createOptions(candidateName, candidateId) {
	return '<div class="choices__item choices__item--choice choices__item--selectable is-highlighted" id= '
			+ candidateId
			+ ' onclick = "selectCandidate(\''
			+ candidateName
			+ '\',\''
			+ candidateId
			+ '\')">'
			+ '<span>'
			+ candidateName + '</span></div>';
}

function selectCandidate(candidateName, candidateId)
{
	userIdDD = candidateId;
	isDDCan = true;
	isAddRpecVisible = true;
	
	getEID('candidateSearchButton').classList.remove("text-grey");
	getEID('candidateSearchButton').innerHTML = candidateName;
	getEID('choicesList').style.display = "none";
	getEID('Candidatesearchbar').style.display = "none";
	//getEID('choices__list').style.display = "none";
	getEID('candidateSearchButton').classList.add("search-close");
	getEID('candidateSearchButton').classList.remove("search-open");
	loadCandidate("false");
}
