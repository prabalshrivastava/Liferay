var data, contentdata;
//showLoading(true);
//
var subSchemeHolder = document.getElementById('subSchemeHolder');
var subSchemeContainer = document.getElementById('subSchemeBase');
var subSchemeList = [];

var allScheduleData = {};
var allCandidateData = {};
var curSchedule = "";
var allPrograms = {};
var allEnrolment = {};
var usedProgram = {};
var awardTypes = [];
var allAwardTypes = {};
var candidateResultDetail = {};
var programSubjectResult = {};

//var isGradeChecked = true;
//var isAwardTypeChecked = false;

//
function fetchResultDetails() {
	showLoading(true); 
	if (typeof formStorageId != "undefined" && formStorageId != "" && formStorageId != "null") {
		data = {};
		console.log("StorageId === "+formStorageId);
		data.formStorageId = encodeURI(formStorageId);
		data.formType = "resultmaster";
		ajaxCallAPI(
				'GET',
				"loadData",
				data,
				function() {
					data = this.get("responseData");
					contentdata = this.get("responseData");
					console.log("contentdata : ");
					console.log(contentdata);
					if (data.error) {
						displayMessage('danger', data.error, 3000);
					} 
					else 
					{
						candidateResultDetail = data;
						fetchAllSceduleData(data.scheduleCode);
						document.getElementsByClassName("idNumber")[0].value = data.contentJson.IdNumber;
						document.getElementsByClassName("candidateName")[0].value = data.contentJson.CandidateName;
						for(var i=0; i<data.contentJson.ResultDetailModels.length; i++){
							var r = data.contentJson.ResultDetailModels[i];
							programSubjectResult[r.programmeCode+"_"+r.subjectCode] = r;
						}
						var conditions = ["candidateId="+data.contentJson.CandidateId, "scheduleCode="+data.scheduleCode, "size="+2147483647];
						fetchEnrolmentData(data.contentJson.CandidateId,conditions, function(cand, cdata) {
							populateCandidate(cand, cdata);
							populateProgram("", cdata);
							Object.keys(allPrograms).forEach(function(key) {
								console.table('Key : ' + key + ', Value : ' + data[key]);
								document.getElementById(namespace+"programTitle").value=key;
								programTitleChange(document.getElementsByClassName("programTitle")[0]);
							});
							document.getElementById(namespace+"programTitle").value="";
						});
					} 
					showLoading(false);
				}, 
				function(){
					showLoading(false);
				});
		} 
	}

//

function preventOtherCharacters(evt){
	if (evt.which != 8 && evt.which != 0 && evt.which < 48 || evt.which > 57)
    {
		if(evt.which!=46){
			evt.preventDefault();
		}
    }
}

function validateMarks(t){
	var credit = t.value;
	if(isNaN(credit) ||  credit<0 || credit >100 || credit.length > 5){
		if(credit==1000){
			return false;
		}
		scrollToTop();
		displayMessage('alert_msg','danger', "Result must be range between 0 to 100 number.", 3000);
		return true;
	} 
	return false;
}

function scrollToTop(){if(document.body.scrollTop!=0||document.documentElement.scrollTop!=0){window.scrollBy(0,-50);timeOut=setTimeout("scrollToTop()",10)}else{clearTimeout(timeOut)}}

function validateFields(action){
	var schedule = document.getElementsByClassName("schedule")[0].value;
	var candidateNumber = document.getElementsByClassName("candidateNumber")[0].value;
	addAllDataToArray();
	if(schedule==""){
		scrollToTop();
		displayMessage('alert_msg','danger', "Please select a schedule.", 3000);
		return;
	}
	if(candidateNumber==""){
		scrollToTop();
		displayMessage('alert_msg','danger', "Please select a candidate number.", 3000);
		return;
	}
	if(subSchemeList.length<=0){
		scrollToTop();
		displayMessage('alert_msg','danger', "Please select at least one program.", 3000);
		return;
	}
	
	console.log("subSchemeList = " + subSchemeList.length);
	
	console.log("drawSubSchemes - subSchemeListPPPP : "+JSON.stringify(subSchemeList));
	var resultData = [];
	var programTitleArr = [];
	var moduleTitleArr = [];
	var resultArr = [];
	var gradeArr = [];
	var awardArr = [];
	for(var i=0; i<subSchemeList.length; i++){
		var p = subSchemeList[i];
		
		console.log("Award Title = " + p.isGradeChecked);
		//p.resultType = "GRADE" ;
		console.log("resultsArr = " + JSON.stringify(p.resultsArr));
		if(p.isGradeChecked){
			for(var j=0;j<p.resultsArr.length;j++){
				var s = p.resultsArr[j];
				var sub = {};
				if(validateMarks(s)){
					return;
				}
				sub["grade"] = fetchGrade(s.value);
				sub["subjectCode"] = s.SubjectCode;
				sub["classPK"] = 1;
				sub["marks"] = s.value;
				sub["type"] = "GRADE";
				sub["programmeCode"] = p.program;
				sub["moduleTitle"] = s.SubjectTitle;
				sub["programmeTitle"] = allPrograms[p.program].programSemester.ProgrammeTitle;
				
				if(s.hasOwnProperty("reviewedMarks") && s.reviewedMarks != ""){
					sub["reviewedGrade"] = fetchGrade(s.reviewedMarks);
					sub["reviewedMarks"] = s.reviewedMarks;
					if(validateMarks({value:s.reviewedMarks})){
						return;
					}
				}
				
				programTitleArr.push(allPrograms[p.program].programSemester.ProgrammeTitle)
				moduleTitleArr.push(s.SubjectTitle);
				resultArr.push(s.value);
				gradeArr.push(fetchGrade(s.value))
				if(p.isAwardTypeChecked){
					if(!p.hasOwnProperty("awardTitle") || p.awardTitle == ""){
						scrollToTop();
						displayMessage('alert_msg','danger', "Please select an award.", 3000);
						return;
					}
					sub["awardCode"] = allAwardTypes[p.awardTitle]["awardTypeCode"];
					sub["award"] = allAwardTypes[p.awardTitle]["awardTypeCode"];
					awardArr.push(allAwardTypes[p.awardTitle]["awardTypeCode"]);
				}
				
				resultData.push(sub);
			}
		}
		else if(p.isAwardTypeChecked){
			var sub = {};
			sub["awardCode"] = allAwardTypes[p.awardTitle]["awardTypeCode"];
			sub["award"] = allAwardTypes[p.awardTitle]["awardTypeCode"];
			awardArr.push(allAwardTypes[p.awardTitle]["awardTypeCode"]);
			sub["grade"] = "";
			sub["subjectCode"] = "";
			sub["classPK"] = p.awardTitle;
			sub["type"] = "ClassificationAward";
			sub["programmeCode"] = p.program;
			sub["moduleTitle"] = "";
			sub["programmeTitle"] = allPrograms[p.program].programSemester.ProgrammeTitle;
			resultData.push(sub);
		}
		/*
		if(p.isAwardTypeChecked){
			var sub = {};
			sub["classPK"] = p.awardTitle;
			sub["type"] = "ClassificationAward";
			sub["programmeCode"] = p.program;
			resultData.push(sub);
		}
		*/
	}
	var data = {
	"ScheduleCode": schedule,
	"CandidateId": candidateNumber,
    "CandidateNumber": allCandidateData[candidateNumber]["CRNNumber"],
    "EnrollmentNumber": allCandidateData[candidateNumber]["enrolmentId"],
    "IdNumber":document.getElementsByClassName("idNumber")[0].value,
	"CandidateName":document.getElementsByClassName("candidateName")[0].value,
	"ResultDetailModels": resultData,
	"ProgrammeTitle": programTitleArr.toString(),
	"ModuleTitle": moduleTitleArr.toString(),
	"Result": resultArr.toString(),
	"Grade": gradeArr.toString(),
	"Award": awardArr.toString(),
	"Status":action
	}
	postCandidateResult(action, data);
}

function updateData(){
	
	//var postData programSubjectResult.contentJson.ResultDetailModels;
}

function postCandidateResult(action, data){
	data.formType = "resultmaster";
	if (typeof formStorageId != "undefined" && formStorageId != "null" && formStorageId != "" ) {
		data.formStorageId = formStorageId;
		data.StorageId = formStorageId;
	}
	ajaxCallAPI('POST', 'persist', data, function() {
		var data = this.get("responseData");
		console.log("Submitted Data===  " + JSON.stringify(data));
		var popupdiv = "#action-feedback-dialog";
		var popupdivbox = "#action-feedback-dialog-box";
		AUI().use('aui-base', function(A) {
			   A.one(popupdiv).set('hidden', false);
			     YUI().use('aui-modal', function(Y) {
			        var modal = new Y.Modal({
			                             boundingBox: popupdiv,
			                             contentBox: popupdivbox,
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
			         	    	 console.log("cloase...");
			         	        modal.hide();
			         	       window.location.reload();
			         	      }
			         	    );
			         Y.one('.popup-ok-action').on(
			         	      'click',
			         	      function() {
			         	    	  console.log("popup-ok-action...");
			         	        modal.hide();
			         	       window.location.reload();
			         	      }
			         	    );
			     });
			 });
	}, function() {

	});
}

function resetCandidate(){
	allCandidateData={};
	populateCandidate("", []);
	document.getElementsByClassName("idNumber")[0].value = "";
	document.getElementsByClassName("candidateName")[0].value = "";
	resetProgram();
}

function resetProgram(){
	allPrograms = {};
	allEnrolment = {};
	usedProgram = {};
	populateProgram("", []);
	subSchemeList = [];
	drawSubSchemes();
}

function fetchAllSceduleData(sch){
	var schData = {};
	schData.formType = "schedule";
	schData.conditions = ["contentJson.Status=Active", "contentJson.ScheduleStatus=Confirmed", "contentJson.Category=Programme", "size="+2147483647];
	ajaxCallAPI(
			'GET',
			"searchList",
			schData,
			function() {
				data = this.get("responseData");
				contentdata = this.get("responseData");
				var responseData = [];
				if (data.error) {
					displayMessage('danger', data.error, 3000);
				} else {
					responseData = contentdata.content;
					for(var i=0; i<responseData.length;i++){
						var o = responseData[i];
						if(!allScheduleData.hasOwnProperty(o.scheduleCode) && o.scheduleCode!=""){
							allScheduleData[o.scheduleCode] = o;
						}
					}
					populateScheduleDropdown(sch, allScheduleData)
				}
				
			}, function() {
				displayMessage('danger',
						"Error in persisting dynamic form data.", 3000);
				
			});
}	

function populateScheduleDropdown(sch, sdata){
	var options="<option value=''>Choose a schedule</option>";
	for(var s in sdata){
		var selected="";
		if(s==sch){
			selected = "selected";
		}
		options = options + "<option "+selected+" value='"+s+"'>["+s+"] "+sdata[s].name+"</option>";
	}
	document.getElementsByClassName("schedule")[0].innerHTML = options;
}

function populateCandidate(cand, cdata){
	var options="<option value=''>Choose a candidate</option>";
	for(var i=0; i<cdata.length;i++){
		var o = cdata[i];
		if(o.hasOwnProperty("contentJson") && o.contentJson.hasOwnProperty("CRNNumber") && o.contentJson.CRNNumber != ""){
			if(!allCandidateData.hasOwnProperty(o.candidateId)){
				allCandidateData[o.candidateId] = o.contentJson;
				var selected="";
				if(o.candidateId==cand){
					selected = "selected";
				}
				options = options + "<option "+selected+" value='"+o.candidateId+"'>"+o.contentJson.CRNNumber+"</option>";
			}
		}
	}
	document.getElementsByClassName("candidateNumber")[0].innerHTML = options;
	
}

function updateProgramTitle(){
	var options="<option value=''>Choose a program</option>";
	for(var p in allPrograms){
		if(p!=undefined){
			if(!usedProgram.hasOwnProperty(p)){
				options = options + "<option value='"+p.programSemester.ProgrammeCode+"'>"+p.programSemester.ProgrammeTitle+"</option>";
			}
		}
	}
	document.getElementsByClassName("programTitle")[0].innerHTML = options;
}

function populateProgram(prg, pdata){
	var isSelected = false;
	var options="<option value=''>Choose a program</option>";
	for(var i=0; i<pdata.length;i++){
		var o = pdata[i];
		if(o.hasOwnProperty("programmeCode") && o.programmeCode !=""){
			var p = o.contentJson.programSemester;
			var selected="";
			if(o.programmeCode==prg){
				selected = "selected";
				isSelected = true;
			}
			if(!allPrograms.hasOwnProperty(o.programmeCode)){
				options = options + "<option "+selected+" value='"+o.programmeCode+"'>"+p.ProgrammeTitle+"</option>";
			}
			console.log(o.programmeCode);
			console.log(o.contentJson);
			if(!allPrograms.hasOwnProperty(o.programmeCode)){
				allPrograms[o.programmeCode] = o.contentJson;
				allEnrolment[o.programmeCode] = o;
			} else {
				for(var si in o.contentJson.subjects) {
					allPrograms[o.programmeCode].subjects.push(o.contentJson.subjects[si]);
				}
				allEnrolment[o.programmeCode] = o;
			}
		}
	}
	document.getElementsByClassName("programTitle")[0].innerHTML = options;
	if(isSelected){
		programTitleChange(document.getElementsByClassName("programTitle")[0])
	}
}

function populateAwardType(aT){
	var options="<option value=''>Choose an award</option>";
	for(var i=0; i<awardTypes.length;i++){
		var a = awardTypes[i];
		var selected="";
		if(a.modelId==aT){
			selected = "selected";
		}
		allAwardTypes[a.modelId] = a ; 
		options = options + "<option "+selected+" value='"+a.modelId+"'>"+a.awardTypeCode+"</option>";
	}
	return options;
}

function resultTypeCAChange(t){
	if(t.checked){
		t.parentElement.parentElement.parentElement.parentElement.getElementsByClassName("ClassificationAward")[0].style="";
	}else{
		t.parentElement.parentElement.parentElement.parentElement.getElementsByClassName("ClassificationAward")[0].style="display:none;";
	}
}

function resultTypeGRADEChange(t){
	if(t.checked){
		t.parentElement.parentElement.parentElement.parentElement.getElementsByClassName("GRADE")[0].style="";
	}else{
		t.parentElement.parentElement.parentElement.parentElement.getElementsByClassName("GRADE")[0].style="display:none;";
	}
}

function resultTypeChange(t){
	
	
	var resultTypeCheckbox = document.getElementsByName("programm");
	
	console.log("resultTypeCheckbox Length == " + resultTypeCheckbox.length);
	
	for(var i = 0 ;i < resultTypeCheckbox.length ; i++){
		console.log("Value of check box : "+resultTypeCheckbox[i].value + "::"+resultTypeCheckbox[i].checked);
		
		if(resultTypeCheckbox[i].value == "GRADE"  ){
			isGradeChecked = resultTypeCheckbox[i].checked;
		}else{
			isAwardTypeChecked = resultTypeCheckbox[i].checked;
		}
	}
	
	if(isGradeChecked && isAwardTypeChecked){
		t.parentElement.parentElement.parentElement.parentElement.getElementsByClassName("GRADE")[0].style="";
		t.parentElement.parentElement.parentElement.parentElement.getElementsByClassName("ClassificationAward")[0].style="";
	}else if(isGradeChecked){
		t.parentElement.parentElement.parentElement.parentElement.getElementsByClassName("GRADE")[0].style="";
		t.parentElement.parentElement.parentElement.parentElement.getElementsByClassName("ClassificationAward")[0].style="display:none;";
	}else if(isAwardTypeChecked){
		t.parentElement.parentElement.parentElement.parentElement.getElementsByClassName("GRADE")[0].style="display:none;";
		t.parentElement.parentElement.parentElement.parentElement.getElementsByClassName("ClassificationAward")[0].style="";
	}
	/*var checkedValue = $('.messageCheckbox:checked').val();
	if(t.value=="GRADE"){
		t.parentElement.parentElement.parentElement.parentElement.getElementsByClassName("GRADE")[0].style="";
		t.parentElement.parentElement.parentElement.parentElement.getElementsByClassName("ClassificationAward")[0].style="display:none;";
	}
	else{
		//t.parentElement.parentElement.parentElement.parentElement.getElementsByClassName("GRADE")[0].style="display:none;";
		t.parentElement.parentElement.parentElement.parentElement.getElementsByClassName("ClassificationAward")[0].style="";
	}*/
}

function programTitleChange(t){
	if(t.value!="" && !usedProgram.hasOwnProperty(t.value)){
		addAnotherSubScheme(t);
		usedProgram[t.value] = allPrograms[t.value];
		//updateProgramTitle();
	}
}

function candidateNumberChange(t){
	programSubjectResult={};
	var candidateNumber = document.getElementById(namespace+"candidateNumber").value;
	var scheduleCode = document.getElementById(namespace+"schedule").value;
	
	showLoading(true);
	resetProgram();
	document.getElementsByClassName("idNumber")[0].value = allCandidateData[t.value].IDNumber;
	document.getElementsByClassName("candidateName")[0].value = allCandidateData[t.value].FirstName;
	var resData = {};
	resData.formType = "resultmaster";
	resData.conditions = ["scheduleCode="+curSchedule,"candidateNumber="+candidateNumber , "size="+2147483647];
	ajaxCallAPI(
			'GET',
			"searchList",
			resData,
			function() {
				var contentdata = this.get("responseData");
				var responseData = [];
				var conditions = ["candidateId="+t.value, "scheduleCode="+curSchedule, "size="+2147483647];
				if (contentdata.error) {
					formStorageId = "";
					mode="create";
					fetchEnrolmentData("",conditions, populateProgram);
					document.getElementById("publish").innerHTML = "Save";
					showLoading(false);
				} else {
					fetchEnrolmentData("",conditions, populateProgram);
					document.getElementById("publish").innerHTML = "Update";
					showLoading(false);
					if(contentdata.content.length>0){
						var data = contentdata.content[0];
						formStorageId = data.storageId;
						mode="edit";
						candidateResultDetail = data;
						for(var i=0; i<data.contentJson.ResultDetailModels.length; i++){
							var r = data.contentJson.ResultDetailModels[i];
							programSubjectResult[r.programmeCode+"_"+r.subjectCode] = r;
						}
					}
					showLoading(false);
				}
			}, function() {
				formStorageId = "";
				mode="create";
				var conditions = ["candidateId="+t.value, "scheduleCode="+curSchedule, "size="+2147483647];
				fetchEnrolmentData("",conditions, populateProgram);
				showLoading(false);
				document.getElementById("publish").innerHTML = "Save";
			});
	
}

function scheduleChange(t){
	resetCandidate();
	curSchedule = t.value;
	var conditions = ["scheduleCode="+t.value, "size="+2147483647];
	fetchEnrolmentData("",conditions, populateCandidate);
	//populateCandidateIds(t.value);
}

function fetchEnrolmentData(select, conditions, callback){
	var enrlData = {};
	enrlData.formType = "enrolment";
	enrlData.conditions = conditions;
	ajaxCallAPI(
			'GET',
			"searchList",
			enrlData,
			function() {
				data = this.get("responseData");
				contentdata = this.get("responseData");
				var responseData = [];
				if (data.error) {
					displayMessage('danger', data.error, 3000);
				} else {
					responseData = contentdata.content;
					callback(select, responseData);
				}
				
			}, function() {
				displayMessage('danger',
						"Error in persisting dynamic form data.", 3000);
				
			});
}

function fetchAwardTypeData(){
	var enrlData = {};
	enrlData.formType = "awardType";
	enrlData.conditions = [ "contentJson.Status=Active", "size="+2147483647];
	ajaxCallAPI(
			'GET',
			"searchList",
			enrlData,
			function() {
				data = this.get("responseData");
				contentdata = this.get("responseData");
				var responseData = [];
				if (data.error) {
					displayMessage('danger', data.error, 3000);
				} else {
					awardTypes = contentdata.content;
					populateAwardType("");
				}
				
			}, function() {
				displayMessage('danger',
						"Error in persisting dynamic form data.", 3000);
				
			});
}

while (subSchemeHolder.hasChildNodes()) {
	subSchemeHolder.removeChild(subSchemeHolder.lastChild);
}

function reset() {
	document.getElementById("candidateResultCapture_form").reset();
}

function getEID(element) {
	return document.getElementById(element);
}

function showAlertDiv(msg) {
	var showAlertDiv = getEID('form-error-div');
	var errorDiv = getEID('error_msg');
	showAlertDiv.style.display = "block";
	errorDiv.innerHTML = msg;
}

function showLoading(show) {
	if(show) {
		getEID("loadingDiv").style.display = "block";
	} else {
		getEID("loadingDiv").style.display = "none";
	}
}


if(document.readyState == 'complete') {
	init();
} else {
	window.addEventListener('load', init);
}

function init() {
	console.log("onload...");
}


function resultDetail(program, resultType, awardTitle, resultsArr, deleteStatus , isGradeChecked , isAwardTypeChecked) {
	this.program = program;
	this.resultType = resultType;
	this.awardTitle = awardTitle;
	this.resultsArr = resultsArr;
	this.deleteStatus = deleteStatus;
	this.isGradeChecked = isGradeChecked;
	this.isAwardTypeChecked = isAwardTypeChecked;
}

function closeSubScheme(closeIcon) {
	var eRmv = closeIcon.parentElement.parentElement.parentElement.parentElement;
	console.log("eRmv : "+eRmv.id);
	var subSchemeDiv = eRmv.getElementsByClassName("subSchemeContent")[0];
	if(subSchemeDiv.style.display!="none") {
		subSchemeDiv.style.display = "none";
		closeIcon.style.background = "url(/html/images/expand.png) no-repeat";
	} else {
		subSchemeDiv.style.display = "block";
		closeIcon.style.background = "url(/html/images/close-minus.png) no-repeat";
	}
}

function removeSubScheme(e) {
	var eRmv = e.parentElement.parentElement.parentElement.parentElement;
	console.log(eRmv);
	delete usedProgram[eRmv.id];
	eRmv.getElementsByClassName("deleteStatus")[0].innerHTML = "Remove";
	addAllDataToArray();
	drawSubSchemes();
}

function addAnotherSubScheme(e) {
	if(e!=undefined){
		addAllDataToArray();
		var subList = allPrograms.hasOwnProperty(e.value) && allPrograms[e.value].hasOwnProperty("subjects")?allPrograms[e.value].subjects:[];
		var resultTypeData="", awardTitleData="", resultsArrData=[], deleteStatusData="" , isGradeCheckedData=true , isAwardTypeCheckedData=false;
		if(typeof formStorageId != "undefined" && formStorageId != "" && formStorageId != "null"){
			for(var i=0 ; i<subList.length; i++){
				console.log(programSubjectResult);
				if(programSubjectResult.hasOwnProperty(e.value+"_"+subList[i].SubjectCode)){
					var res = programSubjectResult[e.value+"_"+subList[i].SubjectCode];
					console.log(res);
					
					if(res.hasOwnProperty("subjectCode") && res.subjectCode!=""){
						subList[i]["value"] = res.hasOwnProperty("marks")?res["marks"]:"";
						subList[i]["reviewedMarks"] = res.hasOwnProperty("reviewedMarks")?res["reviewedMarks"]:"";
						isGradeCheckedData=true;
					}
					else{
						isGradeCheckedData=false;
					}
					if(res.hasOwnProperty("awardCode") && res.awardCode!=""){
						for(var a in allAwardTypes){
							if(allAwardTypes[a].awardTypeCode == res.awardCode){
								awardTitleData = a;
								isAwardTypeCheckedData=true;
								break;
							}
						}
					}
					else{
						isAwardTypeCheckedData=false;
					}
				}
				else if(programSubjectResult.hasOwnProperty(e.value+"_")){
					var res = programSubjectResult[e.value+"_"];
					isGradeCheckedData=false;
					if(res.hasOwnProperty("awardCode") && res.awardCode!=""){
						for(var a in allAwardTypes){
							if(allAwardTypes[a].awardTypeCode == res.awardCode){
								awardTitleData = a;
								isAwardTypeCheckedData=true;
								break;
							}
						}
					}
					else{
						isAwardTypeCheckedData=false;
					}
					
				}
			}
		}
		
		console.log("Sub List Element Child = " + JSON.stringify(subList));
		var ss = new resultDetail(e.value, resultTypeData, awardTitleData, subList, deleteStatusData, isGradeCheckedData , isAwardTypeCheckedData);
		subSchemeList.push(ss);
		drawSubSchemes();
	}
}


function addAllDataToArray() {
	while (subSchemeList.length > 0) {
		subSchemeList.pop();
	}
	var c = subSchemeHolder.childElementCount;
	
	console.log("Child Element Size = "+ c);
	for (var i = 0; i < c; i++) {
		var node = subSchemeHolder.getElementsByClassName("subSchemeContainer")[i];
		var program = node.getElementsByClassName("program")[0];
		//var resultType = node.getElementsByClassName("resultType")[0];
		var resultTypeGRADE = node.getElementsByClassName("resultTypeGRADE")[0];
		var resultTypeCA = node.getElementsByClassName("resultTypeCA")[0];
		var awardTitle = node.getElementsByClassName("awardTitle")[0];
		var programSubjectResult = node.getElementsByClassName("programSubjectResult");
		
		
		
		console.log("programSubjectResult = " + JSON.stringify(programSubjectResult));
		
		console.log("Length = " + programSubjectResult.length);
		var resultType = "" + ( resultTypeGRADE.checked ? resultTypeGRADE.value + ( resultTypeCA.checked ? "," + resultTypeCA.value : "" ) : ( resultTypeCA.checked ? resultTypeCA.value : "" ) );
		var resultsArr = [];
		for(var p=0; p<programSubjectResult.length; p++){
			var sub = {};
			sub["SubjectCode"] = programSubjectResult[p].getElementsByClassName("SubjectCode")[0].value;
			sub["SubjectType"] = programSubjectResult[p].getElementsByClassName("SubjectType")[0].value;
			sub["SubjectTitle"] = programSubjectResult[p].getElementsByClassName("SubjectTitle")[0].value;
			if(programSubjectResult[p].getElementsByClassName("resultPercentage")[0].value!=""){
				sub["value"] = programSubjectResult[p].getElementsByClassName("resultPercentage")[0].value;
				sub["reviewedMarks"] = programSubjectResult[p].getElementsByClassName("reviewed_resultPercentage")[0].value;
			}
			resultsArr.push(sub);
		}
		var deleteStatus = node.getElementsByClassName("deleteStatus")[0];
		if (deleteStatus.innerHTML != "Remove") {
			subSchemeList.push(new resultDetail(program.value, resultType, awardTitle.value, resultsArr, deleteStatus.innerHTML , resultTypeGRADE.checked , resultTypeCA.checked));
		}
	}
}

function drawSubjectResults(program, sub){
	var stl = "display:none !important;";
	if (typeof formStorageId != "undefined" && formStorageId != "" && formStorageId != "null") {
		if(sub.value!=undefined && sub.value!=""){
			stl="";
		}
	}
	var sub = '<div class="row-fluid programSubjectResult" id="row_'+program+'_'+sub.SubjectCode+'_">'
	+'	<div class="span12 formio-component-textfield" id="">'
	+'		<label cssclass="control-label">Module Name</label>'
	+'		<div class="control-group" id="">'
	+'			<input class="span6 field form-control SubjectCode" id="" name="" type="hidden" value="'+sub.SubjectCode+'">'
	+'			<input class="span6 field form-control SubjectType" id="" name="" type="hidden" value="'+sub.SubjectType+'">'
	+'			<input class="span12 field form-control SubjectTitle" disabled id="" name="" type="text" value="'+sub.SubjectTitle+'">'
	+'		<span class="span6" style="margin-left: 0%;">Result</span>'
	+'		<span class="span6" >Grade</span>'
	+'		<input class="span5 field form-control resultPercentage"  id="sub_'+program+'_'+sub.SubjectCode+'_" name="" type="text" value="'+(sub.value!=undefined?sub.value:"")+'" onchange="validateMarks(this)" onkeypress="preventOtherCharacters(event)" onkeyup="validateMarks(this);validateGrade(this);">'
	+'		<input class="span1 field form-control resultPercentageUnit" disabled style="background:white;margin-left:-6px" id="" name="" type="text" value="%">'
	+'		<input class="span6 field form-control gradeType" style="margin-left: 4.9% !important;" disabled id="sub_'+program+'_'+sub.SubjectCode+'__" name="" type="text" value="'+(sub.value!=undefined?fetchGrade(sub.value):"")+'">'
	+'		<span class="span6 reviewed_data" style="margin-left: 0%;'+stl+'">Reviewed Result</span>'
	+'		<span class="span6 reviewed_data" style="'+stl+'" >Reviewed Grade</span>'
	+'		<input class="span5 reviewed_data field form-control reviewed_resultPercentage" style="'+stl+'" id="reviewed_sub_'+program+'_'+sub.SubjectCode+'_" name="" type="text" value="'+(sub.reviewedMarks!=undefined?sub.reviewedMarks:"")+'" onchange="validateMarks(this)" onkeypress="preventOtherCharacters(event)" onkeyup="validateMarks(this);validateGrade(this);">'
	+'		<input class="span1 reviewed_data field form-control reviewed_resultPercentageUnit" disabled style="background:white;margin-left:-6px;'+stl+'" id="" name="" type="text" value="%">'
	+'		<input class="span6 reviewed_data field form-control reviewed_gradeType" style="margin-left: 4.9%;'+stl+'" disabled id="reviewed_sub_'+program+'_'+sub.SubjectCode+'__" name="" type="text" value="'+(sub.reviewedMarks!=undefined&&!sub.reviewedMarks==""?fetchGrade(sub.reviewedMarks):"")+'">'
	+'	</div>'
	+'</div>';
	return sub;
}

function fetchGrade(marks){
	if(marks==undefined || marks==""){
		return "";
	}
	var grade = "";
	if(marks == 1000){
		grade = "Completed";
	}
	else if(marks>100){
		grade = "";
	}
	else if(marks < 50){
		grade="Fail";
	}else if(marks>=50 && marks<=64.9){
		grade = "Pass";
	}else if(marks>=65 && marks<=74.9){
		console.log("Marks of merit");
		grade = "Pass with Merit";
	}else if(marks>=75 && marks<=85.9){
		grade = "Pass with Distinction";
	}else if(marks >= 86){
		grade = "Pass with High Distinction";
	}
	return grade;
}

function validateGrade(gradeObj){
	var grade = "";
	var marks = Number(gradeObj.value);
	if(gradeObj.value!== ""){
		grade = fetchGrade(marks)
	}
	if(gradeObj.value==""){
		document.getElementById(gradeObj.getAttribute("id")+"_").value = "";
	}else{
		document.getElementById(gradeObj.getAttribute("id")+"_").value = grade;
	}
	return grade;
}
function drawSubSchemes() {
	var count = 0;
	var i;
	while (subSchemeHolder.hasChildNodes()) {
		subSchemeHolder.removeChild(subSchemeHolder.lastChild);
	}
	console.log("drawSubSchemes - subSchemeList : "+JSON.stringify(subSchemeList));
	for (i = 0; i < subSchemeList.length; i++) {
		var node = subSchemeContainer.cloneNode(true);
		var header = node.getElementsByClassName("header")[0]
				.getElementsByTagName("div")[0];
		var program = node.getElementsByClassName("program")[0];
		var resultType = node.getElementsByClassName("resultType")[0];
		var awardTitle = node.getElementsByClassName("awardTitle")[0];
		awardTitle.innerHTML = populateAwardType(subSchemeList[i].awardTitle);

		var resultTypeGRADE = node.getElementsByClassName("resultTypeGRADE")[0];
		var resultTypeCA = node.getElementsByClassName("resultTypeCA")[0];
		/*
		populateVocabularyDropDown(awardTitle, currencyList, "id", "name");
		populateDropDown(program, priceSubSchemeList, "PriceSubSchemeCode", "PriceSubSchemeName");
		populateTaxDropDown(resultType, taxCodeList);
		*/
		program.value = subSchemeList[i].program;
		resultType.value = subSchemeList[i].resultType;
		resultTypeGRADE.checked = subSchemeList[i].isGradeChecked;
		resultTypeCA.checked = subSchemeList[i].isAwardTypeChecked;
		awardTitle.value = subSchemeList[i].awardTitle;
		var resultHTML = "";
		for(var s=0; s<subSchemeList[i].resultsArr.length; s++){
			resultHTML = resultHTML + drawSubjectResults(program.value, subSchemeList[i].resultsArr[s]);
		}
		node.getElementsByClassName("GRADE")[0].innerHTML = resultHTML;
		/*
		if(subSchemeList[i].resultType == "GRADE"){
			node.getElementsByClassName("GRADE")[0].style="";
			node.getElementsByClassName("ClassificationAward")[0].style="display:none;";
		}
		*/
		if(subSchemeList[i].isGradeChecked){
			node.getElementsByClassName("GRADE")[0].style="";
		}
		else{
			node.getElementsByClassName("GRADE")[0].style="display:none;";
		}
		if(subSchemeList[i].isAwardTypeChecked){
			node.getElementsByClassName("ClassificationAward")[0].style="";
		}
		else{
			node.getElementsByClassName("ClassificationAward")[0].style="display:none;";
		}
		
		if(mode=="view") {
			resultType.value = subSchemeList[i].resultType==""?"Not Specified":subSchemeList[i].resultType;
			awardTitle.value = subSchemeList[i].awardTitle==""?"Not Specified":subSchemeList[i].awardTitle;
		}
		node.getElementsByClassName("deleteStatus")[0].innerHTML = subSchemeList[i].status;
		console.log("subSchemeList[i].deleteStatus : " + subSchemeList[i].deleteStatus);
		if (subSchemeList[i].deleteStatus != "Remove") {
			count = count + 1;
			header.innerText = allPrograms[subSchemeList[i].program].programSemester.ProgrammeTitle+" ["+subSchemeList[i].program+"]";
			header.parentElement.parentElement.id=subSchemeList[i].program;
			node.style.display = "block";
			subSchemeHolder.appendChild(node);
		}
	}
	
	if(typeof mode == "string" && mode=="view"){
		for(var i=0;i<document.getElementsByClassName("field").length;i++){document.getElementsByClassName("field")[i].setAttribute("disabled","disabled");}
	}
}


