//var panelVisible = {
//	ato : false,
//	review : false,
//	competence : false
//}
//var dateFrom;
//var dateTo;
//var practicalExperience;
//var atoName = getEID("atoName").value;
//var mentorName = getEID("mentorName").value;
//var jobRole = getEID("jobRole").value;
//var trainingPrincipal = getEID("trainingPrincipal").value;
//var dateFromJobRole = getEID("dateFromJobRole").value;
//var dateToJobRole = getEID("dateToJobRole").value;
//var subjectsByPanel = {};
//var competencyQuestions = {
//	          "question": [
//	                 {
//	                     "questionId": "que1",
//	                     "questionDesc": "Paragraphs are the building blocks of papers. Many students define paragraphs in terms of length: a paragraph is a group of at least five sentences, a paragraph is half a page long, etc. In reality, though, the unity and coherence of ideas among sentences is what constitutes a paragraph. A paragraph is defined as “a group of sentences or a single sentence that forms a unit” (Lunsford and Connors 116). Length and appearance do not determine whether a section in a paper is a paragraph. "
//	                 },
//	                 {
//	                	 "questionId": "que2",
//	                     "questionDesc": "Paragraphs are the building blocks of papers. Many students define paragraphs in terms of length: a paragraph is a group of at least five sentences, a paragraph is half a page long, etc. In reality, though, the unity and coherence of ideas among sentences is what constitutes a paragraph. A paragraph is defined as “a group of sentences or a single sentence that forms a unit” (Lunsford and Connors 116). Length and appearance do not determine whether a section in a paper is a paragraph. "
//	                 }
//	             ],
//	             "typeId": "1",
//	             "subjectId": "1",
//	             "proficiencyList": [
//	                 {
//	                     "proficiencyId": "1",
//	                     "score": "1",
//	                     "levelValue": "Basic"
//	                 },
//	                 {
//	                     "proficiencyId": "2",
//	                     "score": "2",
//	                     "levelValue": "Intermediate"
//	                 },
//	                 {
//	                     "proficiencyId": "3",
//	                     "score": "3",
//	                     "levelValue": "Advance"
//	                 }
//	             ]
//	         }
//var remarks = [
////                {
////                	"remarksId" : "r1",
////                	"date" : "04:55",
////                	"remarklabel" : "today",
////                	"remarkheader" : "Lillian Parks remarked",
////                	"remarkdata" : "Kindly review and approve."
////                },
////                {
////                	"remarksId" : "r2",
////                	"date" : "01/10/2016 at 7:00",
////                	"remarklabel" : "older",
////                	"remarkheader" : "Lillian Parks remarked",
////                	"remarkdata" : "Kindly review and approve."
////                }
//               ]
//function getDateFromDate() {
//	dateFrom = getEID("dateFrom").value;
//	getEID("dateFrom").style.borderColor = "#b1bed7"
//	getEID("mandatoryDateFrom").style.display = "none"
//
//}
//function getDateToDate() {
//	dateTo = getEID("dateTo").value;
//	getEID("dateTo").style.borderColor = "#b1bed7"
//	getEID("error_date").style.display = "none"
//	if (Date.parse(getEID("dateFrom").value) > Date.parse(dateTo)) {
//		getEID("error_date").innerHTML = "<img src= '/html/images/error.png'></img>Date To must be greater than Date From";
//		getEID("error_date").style.display = "block";
//		getEID("dateTo").style.borderColor = "#c03643"
//	} else {
//		getEID("error_date").innerHTML = "";
//		getEID("error_date").style.display = "none";
//		getEID("dateTo").style.borderColor = "#b1bed7"
//	}
//}
//function validatePracticalExperience() {
//	practicalExperience = getEID("practicalExp").value;
//	getEID("practicalExp").style.borderColor = "#b1bed7"
//	getEID("prcExp").style.display = "none"
//	if (getEID("dateTo").value !== "" && getEID("dateFrom").value !== "") {
//		var differencetime = Date.parse(getEID("dateTo").value)
//				- Date.parse(getEID("dateFrom").value);
//		var differenceDays = Math.ceil(differencetime / (1000 * 60 * 60 * 24));
//		if (differenceDays < practicalExperience) {
//			getEID("practicalExp").style.borderColor = "#c03643";
//			getEID("prcExp").innerHTML = "<img src= '/html/images/error.png'></img>The number of days entered are more than the selected Dates difference";
//			getEID("prcExp").style.display = "block";
//		} else if (parseInt(practicalExperience, 10) > parseInt(maximumDays, 10)) {
//			getEID("practicalExp").style.borderColor = "#c03643";
//			getEID("prcExp").innerHTML = "<img src= '/html/images/error.png'></img>The number of days entered are more than the actual calendar days. Please modify this number.";
//			getEID("prcExp").style.display = "block";
//		} else {
//			getEID("prcExp").innerHTML = "";
//			getEID("prcExp").style.display = "none";
//			getEID("practicalExp").style.borderColor = "#b1bed7"
//		}
//	}
//}
//function validateMandatoryFields() {
//	var isError = false;
//	if (getEID("dateTo").value === "" || getEID("dateTo").value === null
//			|| getEID("dateTo").value === undefined) {
//		getEID("error_date").innerHTML = "<img src= '/html/images/error.png'></img>Date To is mandatory";
//		getEID("error_date").style.display = "block";
//		getEID("dateTo").style.borderColor = "#c03643"
//		isError = true;
//	}
//	if (getEID("dateFrom").value === "" || getEID("dateFrom").value === null
//			|| getEID("dateFrom").value === undefined) {
//		getEID("mandatoryDateFrom").innerHTML = "<img src= '/html/images/error.png'></img>Date From is mandatory";
//		getEID("mandatoryDateFrom").style.display = "block";
//		getEID("dateFrom").style.borderColor = "#c03643"
//		isError = true;
//	}
//	if (getEID("practicalExp").value === ""
//			|| getEID("practicalExp").value === null
//			|| getEID("practicalExp").value === undefined) {
//		getEID("prcExp").innerHTML = "<img src= '/html/images/error.png'></img>Practical Experience is mandatory";
//		getEID("prcExp").style.display = "block";
//		getEID("practicalExp").style.borderColor = "#c03643"
//		isError = true;
//	}
//	if (!panelVisible.review && isError) {
//		togglePanels('Review', null);
//	}
//	if (!isError) {
//		saveRPECData();
//	}
//}
//
//function saveRPECData() {
//	showLoading(true);
//	var RPECData = {};
//	RPECData.startDate = dateFromJobRole;
//	RPECData.endDate = dateToJobRole;
//	RPECData.accreditedTrainingOrganisation = atoName;
//	RPECData.mentorName = mentorName;
//	RPECData.candidateJobRole = jobRole;
//	RPECData.totalDaysSpentOnPracticalExperience = practicalExperience;
//	RPECData.repcStatus = "DRAFT";
//	RPECData.trainingPrincipalName = trainingPrincipal;
//	RPECData.reviewFromDate = parseDateForRPEC(dateFrom);
//	RPECData.reviewToDate = parseDateForRPEC(dateTo);
//	RPECData.candidateId = "12345678590";
//	RPECData.isPublished = true;
//	RPECData.userType = "candidate";
//	RPECData.formType = modelName.toLowerCase();
//	console.log(JSON.stringify(RPECData));
//	ajaxCallAPI('POST', 'persist', RPECData, function() {
//		var data = this.get("responseData");
//		if (data.error) {
//			displayMessageDiv('danger', data.error, 3000);
//		} else if (Object.keys(data).length === 0) {
//			console.log("data : " + data);
//			displayMessageDiv('danger', 'Form submission failed.', 3000);
//		} else {
//			console.log(data.toString());
//			var message = "RPEC Record added successfully.";
//			displayMessageDiv("success", message, 3000);
//			clearRPECForm();
//		}
//		showLoading(false);
//	}, function() {
//		displayMessageDiv('danger', "Error in persisting dynamic form data.",
//				3000);
//		showLoading(false);
//	});
//}
//
//function parseDateForRPEC(date) {
//	var t = new Date(date);
//	var dt = ((t.getDate() + '').length === 1) ? '0' + t.getDate() : t
//			.getDate();
//	var month = t.getMonth() + 1;
//	month = ((month + '').length === 1) ? '0' + month : month;
//	var year = t.getFullYear();
//	return dt + '-' + month + '-' + year;
//}
//function displayMessageDiv(type, message, duration) {
//	var alert_div = getEID("alert_msg");
//	alert_div.innerHTML = message;
//	alert_div.className = "";
//	alert_div.classList.add("alert-" + type);
//	alert_div.classList.add("alert");
//	alert_div.style.display = "block";
//	setTimeout(function() {
//		alert_div.style.display = "none";
//	}, duration);
//	console.log(message);
//}
//function clearRPECForm() {
//	getEID("dateFrom").value = "";
//	getEID("dateTo").value = "";
//	getEID("practicalExp").value = "";
//}
//function setImpInfoWidth() {
//	var w = document.body.clientWidth;
//	var ml = (w - 1200) / 2;
//	var el = document.getElementsByClassName('info-block')[0];
//	if (el) {
//		el.style.width = w + 'px';
//		el.style.marginLeft = '-' + ml + 'px';
//		el.style.paddingLeft = ml + 'px';
//	}
//}
//function loadCompetenceData() {
//	if(getEID('panelCompetenceDiv').innerHTML === "") {
//	var competenceData = {
//			"formType" : "erpec" 
//	}
//	ajaxCallAPI('POST', 'competenceType', competenceData, function() {
//		let competencies = this.get("responseData");
//		if(competencies !== null && competencies !== undefined && competencies.error) {
//			displayMessage('danger', competencies.error, 3000);
//		}
//	    if(competencies !== null && competencies !== undefined) {
//	    	competencies.forEach(function(comp) {
//				getEID('panelCompetenceDiv').innerHTML += createPanel(comp.typeName,
//						comp.typeId, 'CompetenceSubject', false);
//			});
//			}
//		
//	 }, function() {
//		
//	});
// }
//}
//function createPanel(panelName, panelId, panelType, isRemovable) {
//	if(!isRemovable) {
//	return '<div class= "mb-2 card border panel panel-default">'
//			+ '<div class="card-header bg-default panel-heading formio-clickable" onclick="togglePanels('
//			+ panelId
//			+ ',\''
//			+ panelType
//			+ '\')">'
//			+ '<h4 class="mb-0 card-title panel-title">'
//			+ '<i class="glyphicon glyphicon-plus formio-collapse-icon" id="panel'
//			+ panelId
//			+ 'plus"></i>'
//			+ '<i class="glyphicon glyphicon-minus formio-collapse-icon" style="display: none;" id="panel'
//			+ panelId
//			+ 'minus"></i> '
//			+ panelName.toUpperCase()
//			+ '</h4>'
//			+ '</div>'
//			+ '<div class="card-body panel-body" style="display: none;"	hidden="true" id="panel'
//			+ panelId + 'Div" >' + '</div>' + '</div>';
//	} else {
//		return '<div class = "d-flex" id="panel'+panelId +'parent"><div class= "mb-2 card border panel panel-default left-panel">'
//		+ '<div class="card-header bg-default panel-heading formio-clickable" style="margin-top:0px" onclick="togglePanels(\''
//		+ panelId
//		+ '\',\''
//		+ panelType
//		+ '\')">'
//		+ '<h4 class="mb-0 card-title panel-title">'
//		+ '<i class="glyphicon glyphicon-plus formio-collapse-icon" id="panel'
//		+ panelId
//		+ 'plus"></i>'
//		+ '<i class="glyphicon glyphicon-minus formio-collapse-icon" style="display: none;" id="panel'
//		+ panelId
//		+ 'minus"></i> '
//		+ panelName.toUpperCase()
//		+ '</h4>'
//		+ '</div>'
//		+ '<div class="card-body panel-body" style="display: none;"	hidden="true" id="panel'
//		+ panelId + 'Div" >' + '</div>' + '</div><div class = "remove-icon" onclick = "removePanel(\''+ panelId + '\',\'' + panelName +'\')"><img src = "/html/images/close-02.svg" /> </div></div>';
//	}
//}
//function togglePanels(panelId, panelType) {
//	var panelMinus = getEID('panel' + panelId + 'minus');
//	var panelPlus = getEID('panel' + panelId + 'plus');
//	var panelDiv = getEID('panel' + panelId + 'Div');
//	if (panelMinus.style.display === 'none') {
//		if (panelType === 'CompetenceType') {
//			loadCompetenceData();
//		}
//		else if (panelType === 'CompetenceSubject') {
//			loadCompetenceSubject(panelId);
//		}
//		else if (panelType === 'CompetenceQuestion') {
//			loadCompetenceQuestions(panelId);
//		}
//		panelDiv.style.display = "block";
//		panelPlus.style.display = "none";
//		panelMinus.style.display = "block";
//	} else {
//		panelDiv.style.display = "none";
//		panelPlus.style.display = "block";
//		panelMinus.style.display = "none";
//	}
//
//}
//function loadCompetenceSubject(panelId) {
//	var panelDiv = getEID('panel' + panelId + 'Div');
//	if(panelDiv.innerHTML === "") {
//		var competenceSubjectData = {
//				"formType" : "erpec",
//				"competenceTypeId" : panelId
//		}
//		ajaxCallAPI('POST', 'competenceSubject', competenceSubjectData, function() {
//			debugger;
//			let competenciesSubjects = this.get("responseData");
//			if(competenciesSubjects !== null && competenciesSubjects !== undefined && competenciesSubjects.error) {
//				displayMessage('danger', competenciesSubjects.error, 3000);
//			}
//			else {
//				subjectsByPanel[panelId] = competenciesSubjects;
//				panelDiv.innerHTML = createSearchBar(panelId);
//			}
//			
//		 }, function() {
//			
//		});
//		
//	}
//}
//function loadCompetenceQuestions(panelId) {
//	var panelDiv = getEID('panel' + panelId + 'Div');
//	if(panelDiv.innerHTML === "") {
//		panelDiv.innerHTML = '<table id= "table' + panelId +'" class="table-border"> </table>';
//		createQuestionsHeader('table' + panelId,competencyQuestions);
//		panelDiv.innerHTML  += '<div class="remarks-div" id = "remark_'+panelId+'"> </div>';
//		createRemarks(panelId , remarks);
//	}
//}
//function  createRemarks(panelId , remarks)
//{   var remarksDiv =  getEID('remark_'+panelId);
//	remarksDiv.innerHTML = '<div class="col-sm-12 border-bottom-gray"><div class="col-sm-2 remarks-tab">' +
//	                        '<h4 class="text-center">REMARKS</h4></div><div class="col-sm-10 counter text-right">' +
//	                        '<strong id="counter_'+panelId+'">0</strong> <span class="text-grey"> Remarks</span></div></div>';
//	if(remarks.length <= 0) {
//		remarksDiv.innerHTML += loadNodataRemarksDiv();
//	} else {
//		 remarks.forEach(function(remObj) {
//			remarksDiv.innerHTML += createRemarksdata(panelId , remObj);
//		});
//	}
//	remarksDiv.innerHTML += '<div style="padding:20px" class="remarks-comment"> <input type = "text" id="input_'+panelId+'"+ class="remark-log" placeholder = "Log a remark..." style="width: 99%;" oninput="addRemarks(event,'+panelId+')"/><img src="/html/images/inactive.svg" id="inactive_'+panelId+'" class="inactive-icon"/></div>'
//}
//function loadRemarksData(panelId , remarks) {
//	var remarksLog = getEID('remark_'+panelId);
//	remarks.forEach(function(remObj) {
//		remarksLog.innerHTML += createRemarksdata(panelId , remObj);
//	});
//}
//function addRemarks(event , panelId) {
//	 debugger 
//	}
//function createRemarksdata(panelId , remObj) {
//	return '<div class="remarks-data col-sm-12"><div class="col-sm-11"><div><h5 class="r-label">'+ remObj.remarklabel + '</h5></div>' +
//	       '<div class="col-sm-12 d-flex"><div class="col-sm-1 remarks-info"><img src="/html/images/note.svg"/></div>' +
//	       '<div class="col-sm-10"><p class="r-header">'+ remObj.remarkheader + '</p><span class="r-data">'+ remObj.remarkdata + '</span></div> </div></div>' +
//	       '<div class="col-sm-2 text-right text-grey"><span>'+ remObj.date + '</span></div></div>'
//}
//function loadNodataRemarksDiv() {
//	return '<div><div class="text-center"><img src="/html/images/remarks.svg"></img></div><div class="no-remarks-label"><h3>No Remarks yet!</h3></div></div>';
//}
//function propogateSearchOptions(panelId) {
//	var competenciesSubjects = subjectsByPanel[panelId];
//	if (getEID('choices' + panelId).style.display === "none") {
//		competenciesSubjects.forEach(function(sub) {
//			getEID('choices' + panelId).innerHTML += createOptions(sub.subjectName,
//					sub.subjectId, panelId);
//		});
//		getEID('choices' + panelId).style.display = "block";
//		getEID('searchbar' + panelId).style.display = "block";
//		getEID('selectButton' + panelId).classList.add("search-open");
//		getEID('selectButton' + panelId).classList.remove("search-close");
//	} else {
//		getEID('choices' + panelId).innerHTML = "";
//		getEID('searchbar' + panelId).innerHTML = "";
//		getEID('choices' + panelId).style.display = "none";
//		getEID('searchbar' + panelId).style.display = "none";
//		getEID('selectButton' + panelId).classList.remove("search-open");
//		getEID('selectButton' + panelId).classList.add("search-close");
//	}
//}
//function propogateSearchResults(searchTerm , panelId) {
//	var competenciesSubjects = subjectsByPanel[panelId];
//	getEID('choices' + panelId).innerHTML = "";
//	if (searchTerm !== undefined && searchTerm.length > 0) {
//		searchTerm = searchTerm.toLowerCase();
//		var filtered = competenciesSubjects.filter(function(i) {
//			return i.subjectName.toLowerCase().includes(searchTerm);
//		});
//		filtered.forEach(function(sub) {
//			getEID('choices' + panelId).innerHTML += createOptions(sub.subjectName,
//					sub.subjectId , panelId);
//		});
//}
//	else {
//		competenciesSubjects.forEach(function(sub) {
//			getEID('choices' + panelId).innerHTML += createOptions(sub.subjectName,
//					sub.subjectId, panelId);
//		});	
//	}
//}
//function getEID(element) {
//	return document.getElementById(element);
//}
//function createSearchBar(panelId) {
//		return '<div class="choices form-group formio-choices" id="parentSearch' + panelId + '">' +
//	'<div class="form-control dropdown-container" tabindex="0" id="container' + panelId + '">' +
//		'<Button class="col-sm-12 form-control select-button search-close text-grey" lang="en" tabindex="-1" onclick="propogateSearchOptions(\''+panelId+'\')" id="selectButton' + panelId + '"' + 
//			'style="text-align: left; font-size: 18px">Choose a Competence</Button>' +
//		'<input type="text" placeholder="Type & Search..." style="display: none;background-color: #f5f7fb;" id="searchbar' +  panelId + '" oninput="propogateSearchResults(this.value , \''+ panelId +'\')">' +
//		'<div class="choices__list" style="display: none;" id="choices' + panelId + '">' +
//        '</div></div></div>';
//}
//function createQuestionsHeader(tableId , competencyQuestions) {
//    var table = getEID(tableId);
//    table.innerHTML = '<thead id= "thead'+ tableId +'"><tr id = "tr'+ tableId +'" style="border-top: 1px solid #b1bed7;"><th class="first-td header-border">Statement Of Competence</th></tr></thead>';
//    var proficiencies = competencyQuestions.proficiencyList;
//    var tr = getEID('tr'+tableId);
//    proficiencies.forEach(function(prof) {
//    	tr.innerHTML += createDynamicHeader(prof.levelValue); 
//    })
//    tr.innerHTML += "<th style='border-left:1px solid #b1bed7' class='header-border'>Reset to Previous State</th>"
//    	createQuestionTable(tableId , competencyQuestions);
//}
//function createDynamicHeader(levelValue) {
//	return '<th class="header-border">' + levelValue + '</th>';
//}
//function createQuestionTable(tableId , competencyQuestions) {
//	var table = getEID(tableId); 
//	table.innerHTML += '<tbody id = "tbody'+ tableId +'"></tbody>';
//	var questions = competencyQuestions.question;
//	var tbody = getEID('tbody'+ tableId);
//	questions.forEach(function(que) {
//		tbody.innerHTML += createTableRows(que.questionDesc , competencyQuestions , que.questionId , tableId);
//		var quetr = getEID('que_'+ tableId + '_' + que.questionId);
//		var proficiencies = competencyQuestions.proficiencyList;
//		proficiencies.forEach(function(prof) {
//			 quetr.innerHTML += createDynamicButtons(que.questionId , prof.levelValue , prof.score); 
//		})
//		quetr.innerHTML += '<td class="radio-baseline"><img class="pointer" src = "/html/images/refresh.svg" / ></td>';
//	})
//}
//function createDynamicButtons(questionId, levelVal , score) {
//	var dynamicId = questionId + '_' + levelVal + '_' + score;
//	return '<td class="form-group radio-baseline"><div class="form-check form-check-inline radio-inline"><label class="control-label form-check-label"><input name="button'+ questionId +'" type="radio" class="form-check-input" lang="en" id="'+dynamicId+'" value="no"><span></span></label></div></td>';
//}
//function createTableRows(questionDesc , competencyQuestions , questionId , tableId) {
//	return '<tr id="que_'+tableId + '_' + questionId +'" class="table-border-bottom"><td class="first-td"><span>'+questionDesc + '</span><br/><br/><div class="d-flex"><div class="col-sm-3"><h5 style="color: #0f349f;">Review</h5><span>01</span><br><span>02</span> </div> <div class="col-sm-3"><h5 style="color: #0f349f;">Proficiency</h5><span>Basic</span><br/><span>Basic</span></div></div><br/></td></tr>'; 
//}
//function createOptions(subjectName, subjectId, panelId) {
//	return '<div class="choices__item choices__item--choice choices__item--selectable is-highlighted" id= '
//			+ subjectId
//			+ ' onclick = "selectSubject(\''
//			+ subjectName
//			+ '\', \''+ panelId +'\',\''+subjectId +'\')">' + '<span>' + subjectName + '</span></div>';
//}
//function selectSubject(subjectName , panelId , subjectId) {
//	getEID('selectButton' + panelId).classList.remove("text-grey");
//	getEID('selectButton' + panelId).innerHTML = subjectName;
//	getEID('choices' + panelId).innerHTML = "";
//	getEID('choices' + panelId).style.display = "none";
//	getEID('searchbar' + panelId).style.display = "none";
//	getEID('selectButton' + panelId).classList.remove("search-open");
//	getEID('selectButton' + panelId).classList.add("search-close");
//	var panelDiv =  getEID('panel' + panelId + 'Div');
//	if (getEID("panel"+subjectId +"parent") !==null &&  getEID("panel"+subjectId +"parent") !== undefined) {
//		toggleClass("panel"+subjectId +"parent", "d-flex", "d-none");
//	//	getEID("panel"+subjectId +"parent").style.display = "block";	
//	} else {
//	 var  newsubjectId = panelId + '_' + subjectId;
//	  panelDiv.innerHTML += createPanel(subjectName , newsubjectId , 'CompetenceQuestion' , true);
//	}
//	var competenciesSubjects = subjectsByPanel[panelId];
//	var found = competenciesSubjects.filter(function(i) { return i.subjectId === subjectId })
//	if(found.length > 0) {
//		var idx = competenciesSubjects.indexOf(found[0]);
//		competenciesSubjects.splice(idx,1);
//	}
//		
//	//propogateDropDownOptions(subjects , panelId);
//}
//function propogateDropDownOptions(subjectsArray , panelId) {
//	getEID('choices' + panelId).innerHTML = "";
//	subjectsArray.forEach(function(sub) {
//		getEID('choices' + panelId).innerHTML += createOptions(sub.subjectName,
//				sub.subjectId, panelId);
//	});	
//}
//window.onresize = function() {
//	setImpInfoWidth();
//}
//function removePanel (panelId , panelName) {
//	var ids = panelId.split('_');
////	var panel = getEID('panel' + panelId + 'parent');
////	var searchId = panel.parentNode.childNodes[0].id;
////	var searchBarID = searchId.substr(12);
//	getEID('selectButton' + ids[0]).classList.add("text-grey");
//	getEID('selectButton' + ids[0]).innerHTML = "Choose a Competence";
//	toggleClass('panel' + panelId + 'parent' , 'd-none' , 'd-flex');
//	var competenciesSubjects = subjectsByPanel[ids[0]];
//	var found = competenciesSubjects.filter(function(i) { return i.subjectId === ids[1] })
//	if(found.length === 0) {
//		var sub = {
//				subjectId : ids[1]+'',
//				subjectName : panelName
//			}
//		competenciesSubjects.push(sub);	
//	}
//}
//setImpInfoWidth()
//
//function toggleClass(id, addClasses, removeClasses) {
//	var el = getEID(id);
//	el.classList.remove(removeClasses);
//	el.classList.add(addClasses);
//}
//
