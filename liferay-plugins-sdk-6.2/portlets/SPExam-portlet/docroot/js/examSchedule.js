var contentdata;
var sampleRow;
var rowContainer;
var A;
if(document.readyState == 'complete') {
	init1();
} else {
	window.addEventListener('load', init1);
}
var candidates = [];
var subjects = {};
console.log("build!");

function transformation(data){
	var dataArray = data.content;
	for(var i=0; i<dataArray.length; i++)
	{
		var obj = dataArray[i];
		var contentJson = obj.contentJson;
		if (obj.hasOwnProperty("enrolmentStatus")
	 			&& (obj.enrolmentStatus.toLocaleLowerCase() == "confirmed"
	 				|| obj.enrolmentStatus.toLocaleLowerCase() == "notified" 
	 				|| obj.enrolmentStatus.toLocaleLowerCase() == "verified")
	 			&& contentJson.hasOwnProperty("subjects")) {
			for(var j=0; j<contentJson.subjects.length; j++){
				var sub = contentJson.subjects[j];
				if(subjects.hasOwnProperty(sub.SubjectCode)){
					subjects[sub.SubjectCode] = sub;

					if(obj.hasOwnProperty("candidateId") && obj.candidateId!="" && candidates.indexOf(obj.candidateId) == -1){
						candidates.push(obj.candidateId);
					}
				}
			}
		}
	}
	document.getElementsByClassName("candidateEnrolledCount")[0].innerHTML = candidates.length;
}

function loadEnrolmentsBySchedule(sch) {
	var filter = {};
	filter.conditions = [ "scheduleCode=" + sch , "size="+2147483647 ];
	filter.formType = "enrolment";
	ajaxCallAPI(
			'GET',
			"searchList",
			filter,
			function() {
				var subData = this.get("responseData");
				if (subData.error) {
					displayMessage('danger', data.error, 3000);
				} else {
					if(subData && subData.hasOwnProperty("content")){
						transformation(subData);
					}
				}
				console.log("subData : " + JSON.stringify(subData));
			}, function() {

			});
}

function loadProgrammeSchedule(subjectSchedule){
	var filter = {};
	filter.conditions = [ "linkType=ProgrammeScheduleSubjectScheduleEntityLink", "storageIdRight=" + subjectSchedule , "size="+2147483647 ];
	filter.formType = "entityLink";
	ajaxCallAPI(
			'GET',
			"searchList",
			filter,
			function() {
				var subData = this.get("responseData");
				if (subData.error) {
					displayMessage('danger', data.error, 3000);
				} else {
					if(subData && subData.hasOwnProperty("content")){
						var ps = {};
						for(var i=0; i<subData.content.length; i++){
							if(!ps.hasOwnProperty(subData.content[i].storageIdLeft)){
								ps[subData.content[i].storageIdLeft] = subData.content[i].storageIdLeft;
								loadEnrolmentsBySchedule(subData.content[i].storageIdLeft);
							}
						}
					}
				}
				console.log("subData : " + JSON.stringify(subData));
				
				console.log("contentdata : " + JSON.stringify(contentdata));
			}, function() {

			});
}

function loadSubjectsBySchedule(sch) {
	candidates = [];
	document.getElementsByClassName("candidateEnrolledCount")[0].innerHTML = candidates.length;
	var filter = {};
	filter.conditions = [ "contentJson.ScheduleStorageID=" + sch, "size="+2147483647 ];
	filter.formType = "subschedule";
	ajaxCallAPI(
			'GET',
			"searchList",
			filter,
			function() {
				
				var subData = this.get("responseData");
				contentdata = this.get("responseData");
				console.log("contentdata : " + JSON.stringify(contentdata));

				if (subData.error) {
					displayMessage('danger', subData.error, 3000);
				} else {
					for (var i = 0; i < subData.content.length; i++) {
						var sub = subData.content[i];
						subjects[sub.contentJson.Subject] = sub.contentJson;
					}
				}
				loadProgrammeSchedule(sch);
			}, function() {

			});
}

function init1(){
	showLoading(true);
	AUI().use('aui-node','aui-io-request', 'liferay-util-window','aui-io-plugin-deprecated',
			'stylesheet','aui-datepicker','overlay','event', 'widget-anim', function(A1) {
		A = A1;
		var AArray = A.Array;
		sampleRow = A.one("#sampleEntityLinkRow");
		rowContainer = A.one("#entityLinkContainer");
		var element = document.getElementById("entityLinkContainer");

		while (element.childNodes.length > 2) {
			element.removeChild(element.lastChild);
		}
		var data = {};
		var schedule=selectedSchedule;
		loadSubjectsBySchedule(selectedSchedule);
		var contentdata;
		data.formType = "seatingplan";

		data.scheduleCode = schedule;
		ajaxCallAPI(
				'GET',
				"fetchEntityScheduleList",
				data,
				function() {
					data = this.get("responseData");
					contentdata = this.get("responseData");
					var responseData = [];
					if (data.error) {
						displayMessage('danger', data.error, 3000);
					} else {
						responseData = contentdata;
						populateEntityRecords(responseData);
					}
				}, function() {
					displayMessage('danger',
							"Error in persisting dynamic form data.", 3000);
				});


		function populateEntityRecords(dataList){
			AArray.each(dataList,function(data) {
				addRowCells(data);
			});
			showLoading(false);
		}

		function addRowCells(data){
			var newRow = this.sampleRow.cloneNode(true);

			console.log("contentdata Response : " + JSON.stringify(data));
			newRow.one("#facility").set('text',data.facilityName);
			newRow.one("#seatsAvailable").set('text',data.subFacilityCapacity - data.totalAssigned);
			newRow.one("#subFacility").set('text',data.subFacilityName);
			newRow.one("#noOfCandidateAssigned").set('text',data.totalAssigned);
			
			show(newRow.one("#seatPlan_CREATE"));
			show(newRow.one("#seatPlan_DRAFT"));
			show(newRow.one("#seatPlan_UPDATE"));
			show(newRow.one("#seatPlanDelete"));
			
			show(newRow.one("#assignCandidate_CREATE"));
			show(newRow.one("#assignCandidate_DRAFT"));
			show(newRow.one("#assignCandidate_UPDATE"));
			show(newRow.one("#assignCandidateDelete"));
			
			var action;
			if(data.seatPlanStatus === "UNKNOWN"){
				action = "SEATPLAN_CREATE";
				hide(newRow.one("#seatPlan_DRAFT"));
				hide(newRow.one("#seatPlan_UPDATE"));
				hide(newRow.one("#seatPlanDelete"));

				customiseSeatlayout(data.facilityId,data.subFacilityId,data.scheduleId,data.facilityCode,data.subFacilityCode,data.scheduleCode,action,function(responseData){
					newRow.one("#seatPlan_CREATE").setAttribute('href',responseData);
				});
			}else if(data.seatPlanStatus === "DRAFT"){
				action = "SEATPLAN_DRAFT";
				hide(newRow.one("#seatPlan_CREATE"));
				hide(newRow.one("#seatPlan_UPDATE"));

				customiseSeatlayout(data.facilityId,data.subFacilityId,data.scheduleId,data.facilityCode,data.subFacilityCode,data.scheduleCode,action,function(responseData){
					newRow.one("#seatPlan_DRAFT").setAttribute('href',responseData);
				});
			}else if(data.seatPlanStatus === "ACTIVE"){
				action = "SEATPLAN_ACTIVE";
				hide(newRow.one("#seatPlan_CREATE"));
				hide(newRow.one("#seatPlan_DRAFT"));

				customiseSeatlayout(data.facilityId,data.subFacilityId,data.scheduleId,data.facilityCode,data.subFacilityCode,data.scheduleCode,action,function(responseData){
					newRow.one("#seatPlan_UPDATE").setAttribute('href',responseData);
				});
			}

			newRow.one("#seatPlanDelete").setAttribute('onclick',"removeSeatingTemplate('"+data.instanceStorageId+"','SeatingPlan');");

			if(data.assignSeatStatus === "UNKNOWN"){
				action = "ASSIGNSEAT_CREATE";
				hide(newRow.one("#assignCandidate_DRAFT"));
				hide(newRow.one("#assignCandidate_UPDATE"));
				hide(newRow.one("#assignCandidateDelete"));

				customiseSeatlayout(data.facilityId,data.subFacilityId,data.scheduleId,data.facilityCode,data.subFacilityCode,data.scheduleCode,action,function(responseData){
					newRow.one("#assignCandidate_CREATE").setAttribute('href',responseData);
				});

			}else if(data.assignSeatStatus === "DRAFT"){
				action = "ASSIGNSEAT_DRAFT";
				hide(newRow.one("#assignCandidate_CREATE"));
				hide(newRow.one("#assignCandidate_UPDATE"));

				customiseSeatlayout(data.facilityId,data.subFacilityId,data.scheduleId,data.facilityCode,data.subFacilityCode,data.scheduleCode,action,function(responseData){
					newRow.one("#assignCandidate_DRAFT").setAttribute('href',responseData);
				});
			}else if(data.assignSeatStatus === "ACTIVE"){
				action = "ASSIGNSEAT_UPDATE";
				hide(newRow.one("#assignCandidate_CREATE"));
				hide(newRow.one("#assignCandidate_DRAFT"));

				customiseSeatlayout(data.facilityId,data.subFacilityId,data.scheduleId,data.facilityCode,data.subFacilityCode,data.scheduleCode,action,function(responseData){
					newRow.one("#assignCandidate_UPDATE").setAttribute('href',responseData);
				});
			}
				newRow.one("#assignCandidateDelete").setAttribute('onclick',"removeSeatingTemplate('"+data.instanceId+"','AssignCand');");

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

function customiseSeatlayout(facilityId,subFacilityId,scheduleId,facilityCode,subFacilityCode,scheduleCode,userAction,callback){
	
	
	AUI().ready('liferay-portlet-url', function(A){
		var renderURL = Liferay.PortletURL.createRenderURL();
		renderURL.setLifecycle(Liferay.PortletURL.RENDER_PHASE);
		renderURL.setPortletId("seatingplan_WAR_SPExamportlet");
		renderURL.setWindowState("maximized");
		if( userAction === "ASSIGNSEAT_CREATE" ||
			 userAction === "ASSIGNSEAT_DRAFT" ||
			 userAction === "ASSIGNSEAT_UPDATE"){
			renderURL.setParameter("jspPage","/html/seatingplan/seatingAssignment.jsp");
		}else{
			renderURL.setParameter("jspPage","/html/seatingplan/customiseSeatLayout.jsp");
			
			}
		renderURL.setParameter("facilityId", facilityId);
		renderURL.setParameter("subFacilityId", subFacilityId);
		renderURL.setParameter("scheduleId", scheduleId);
		renderURL.setParameter("facilityCode", facilityCode);
		renderURL.setParameter("subFacilityCode", subFacilityCode);
		renderURL.setParameter("scheduleCode", scheduleCode);
		renderURL.setParameter("userAction", userAction);
		
		callback(renderURL);
	});
}

function removeSeatingTemplate(instanceRecordId,template) {
	
	console.log("template : " + template);
	console.log("data : " + instanceRecordId);
	var msg = "Are you sure about deleting this Seating Plan record ?";
	var boundingBox = "#sucess-popup";
	var contentBox = "#sucess-popup-box";
	document.getElementById('success-msg').innerHTML = msg;
	AUI().use('aui-base', function(A) {

		A.one(boundingBox).set('hidden', false);

		YUI().use('aui-modal', function(Y) {
			var modal =new Y.Modal({
				boundingBox : boundingBox,
				contentBox : contentBox,
				headerContent : '',
				centered : true,
				destroyOnHide : false,
				modal : true,
				resizable : false,
				draggable : false
			}).render();
			Y.one('.popup-cancel').on(
					'click',
					function() {
						modal.hide();
						modal = null;
					});
			Y.one('.popup-confirm-archive').on(
					'click',
					function() {
						console.log("Confirm Clicked ......"+instanceRecordId);
						modal.hide();
						modal = null;
						if(template === "SeatingPlan"){
							console.log("Seating Plan delete .... ");
							archiveSeatingPlanModel(instanceRecordId);
						}else if(template === "AssignCand"){
							console.log("Deleting Assing Seats ....");
							removeAssignCandidateSeats(instanceRecordId);
						}

					});
		});

	});
}

function archiveSeatingPlanModel(instanceId){

	var modelName = "seatingplanlayout";
	var data = {};
	data.formType = modelName;
	data.seatingPlanInstace = instanceId;
	data.actionType = "removedbyinstanceid";
	ajaxCall('GET', 'removeUserAssignedSeat', ajaxUrl, data, function() {

		var modelName = "seatingPlanInstance";
		var data = {"formType":modelName,"formStorageId": instanceId};
	    ajaxCall('GET','archive',ajaxUrl,data,
	 	 function() {
	          var data = this.get("responseData");    
	          if (_.isEmpty(data)) {
	              console.log("error");
	          }
	          reloadPage();
	      },
	      function() {

	 	});
	}, function() {

	});
}

function removeAssignCandidateSeats(instanceId){
	
	var modelName = "userseatassign";
	var data = {};
	data.formType = modelName;
	data.seatingPlanInstace = instanceId;
	data.actionType = "removecandidateseat";
    ajaxCall('GET','removeUserAssignedSeat',ajaxUrl,data,
 	 function() {
          var data = this.get("responseData");    
          if (_.isEmpty(data)) {
              console.log("error");
          }
          reloadPage();
      },
      function() {
          
 	});
	
}
function showLoading(show) {
	if(show) {
		getEID("loadingDiv").style.display = "block";
	} else {
		getEID("loadingDiv").style.display = "none";
	}
}