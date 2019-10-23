var campaignCreate = function(config){
	
	this.init = function(config){
		var instance = this;
		// attributes used 
		instance.ATTR_EDM_SEQ = "data-edmSeq";
		instance.ATTR_EDM_JOB_STATUS = "data-job-status";
		instance.ATTR_EDM_ID = "data-edm-id";
		
		// various status for job w.r.t trigger state
		/**instance.STATUS_COMPLETE = "complete";
		instance.STATUS_NORMAL = "normal";
		instance.STATUS_PAUSED = "paused";
		instance.STATUS_UNSCHEDULED = "unscheduled";**/
		
		// Job status values changed with respect to data in table
		instance.STATUS_COMPLETE = "1";
		instance.STATUS_NORMAL = "0";
		instance.STATUS_PAUSED = "2";
		instance.STATUS_UNSCHEDULED = "-1";
		
		// campaign types
		instance.CAMPAIGN_TYPE_AUTOMATED = "automated";
		instance.CAMPAIGN_TYPE_SUBSCRIPTION = "subscription";
		
		// crone types
		instance.CRONE_ONE_TIME = "oneTime";
		instance.CRONE_WEEKLY = "weekly";
		instance.CRONE_MONTHLY = "monthly";
		
		// ids
		instance.idEditFieldsGrp = "editFieldsGrp";
		instance.idEdmId = "edmId";
		instance.idEdmName = "edmName";
		instance.idEdmSeqNo = "edmSeqNo";
		instance.idDelayAmount = "delayAmount";
		instance.idDelayUnit = "delayUnit";
		instance.idCroneType = "croneType";
		instance.idScheduleTime = "time";
		instance.idScheduleDate = "date";
		instance.idNextScheduleText = "nextSchedule";
		instance.idEditEdmLink = "editEdm";
		instance.idMailTemplate = "mailTemplateId";
		instance.idScheduleHour = "scheduleHour";
		instance.idScheduleMin = "scheduleMin";
		instance.idScheduleAmpm = "scheduleAmpm";
		instance.edmStartDateContainer = "dateContainer";
		instance.edmStartDate = "edmStartDate";
		instance.edmStartTime = "edmStartTime";
		instance.idRescheduleEdms = "rescheduleEdms";
		
		instance.config = config;
		instance.pns = config.pns;
		instance.ajaxUrl = config.ajaxUrl;
		instance.nodeForm =  A.one("#form1");
		instance.nodeCampaignName =  A.one("#campaignName");
		instance.nodeCampaignId =  A.one("#byCampaignId");
		instance.nodeCampaignType =  A.one("#campaignType");
		instance.CLS_NOT_ACTIVE  = 'not-active';
		
		instance.templateEdmRootNode = A.one("#templateEdmRootNode");
		instance.edmsList = A.one("#edmsList");
		
		// assuming this is start. DO NOT CHANGE THIS VALUE. THIS VALUE STORED IN DB AND HAS BUSINESS LOGIC. THIS NUMBER STORED AS SEQNO IN SPMAILCAMPAIGNEDM TABLE
		// USED IN AS PART OF QUARTZ JOB ID. ex: jobid format : <CAMPAIGNID>:<MAILTYPE-campaign>  here edmseq used as mailtype
		instance.edmSeq = 10000;
		instance.edmSeqNoLower = A.one("#edmSeqNoLower")
		//this is higher.when edm is added, this value will be incremented
		instance.edmSeqNoHigher = A.one("#edmSeqNoHigher")
		// lower value is fixed.
		instance.edmSeqNoLower.val(instance.edmSeq + 1);

		instance.addEdmListener();
		instance.fetchEdms();
		
		A.one("#save").on("click",function(){
			instance.onSubmit();
		});
		instance.nodeReschedule = A.one("#" + instance.idRescheduleEdms);
		var isEdit = instance.isEditCampaign();
		if(isEdit && instance.nodeCampaignType.val() == instance.CAMPAIGN_TYPE_AUTOMATED){
			var nodeReschedule = instance.nodeReschedule;
			instance.show(nodeReschedule.ancestor("div"));
			nodeReschedule.on("click",function(){
				if(this.get('checked') ){
					A.all("a[data-edit-link]").each(function(editLink){
						editLink.simulate("click");
					});
				}
			});
		}else{
			instance.hide(A.one("#" + instance.idRescheduleEdms));
		}
		
		instance.nodeCampaignType.on("change",function(){
				// hide dates for subscription based campaign
			if(instance.nodeCampaignType.val() == instance.CAMPAIGN_TYPE_SUBSCRIPTION){
				instance.hide(A.all("div[data-divide]"));
				instance.hide(A.all("div[data-date-container]"));
				instance.hide(A.all("div[data-time-container]"));
				instance.hide(A.all("div[data-label]"));
				instance.hide(A.all(".recurrenceWrap"));
			}else{
				instance.show(A.all("div[data-divide]"));
				instance.show(A.all("div[data-date-container]"));
				instance.show(A.all("div[data-time-container]"));
				instance.show(A.all("div[data-label]"));
				instance.show(A.all(".recurrenceWrap"));
			}
		});
	}
	
	this.addEdmListener = function(){
		var instance = this;
		A.one("#addEdm").on("click",function(){
			instance.renderEdm();
		});
	}

	this.fetchEdms = function(){
		var instance = this;
		
		A.io.request(this.ajaxUrl,{
			dataType : 'json',
			method : 'POST',
			data : {
				filterName: 'fetchEdms',
				campaignId: instance.nodeCampaignId.val()
			},
			on : {
			success : function() {
					var data = this.get('responseData');
					if(data && data.code==0){
						instance.handleFetchEdmsResponse(data);
					}else{
						instance.handleErrorResponse(data);
					}
				}
			}
		});
	}
	this.toggleJobStatus = function(nodePauseResume){
		var instance = this;
		nodePauseResume.addClass(instance.CLS_NOT_ACTIVE);
		A.io.request(this.ajaxUrl,{
			dataType : 'json',
			method : 'POST',
			data : {
				filterName: 'pauseResumeEdm',
				campaignId: instance.nodeCampaignId.val(),
				edmId: nodePauseResume.getAttribute(instance.ATTR_EDM_ID),
			},
			on : {
				success : function() {
					var data = this.get('responseData');
					
					if(data && data.code==0){
						var newStatus = data.jobStatus;
						instance.pausePlayLink(newStatus, nodePauseResume);
					}else{
						//instance.handleErrorResponse(data);
					}
					nodePauseResume.removeClass(instance.CLS_NOT_ACTIVE);
				}
			}
		});
	}
	this.handleFetchEdmsResponse = function(data){
		var instance = this;
		if(data){
			instance.renderEdms(data.edms);
		}
	}
	this.handleErrorResponse = function(data){
		
	}
	this.renderEdms = function(edms){
		var instance = this;
		if(edms){
			AArray.each(edms,function(edm,index,edms){
				instance.renderEdm(edm);
			});
		}
	}
	// core method. clones EdM row, populates it's data with given json, initalizes all listeners.
	this.renderEdm = function(edm){
		var instance = this;
		if(instance.isAddCampaign()){
			if(instance.nodeCampaignType.val() == ''){
				alert("Please select campaign type before adding EDM");
				return;
			}
		}
		//generate unique number for each edm
		if(edm && edm.edmId){
			// if the edm is existing one, take the seqno from it. 
			instance.edmSeq = edm.edmSeqNo;
		}else{
			// it's new edm, so get incremented value from previous one
			instance.edmSeq = instance.edmSeq + 1;
		}
		instance.edmSeqNoHigher.val(instance.edmSeq);
		
		var idEdmId = instance.idEdmId;
		var idEdmSeqNo = instance.idEdmSeqNo;
		var idEdmName = instance.idEdmName;
		var idEditFieldsGrp = instance.idEditFieldsGrp;
		var idDelayAmount = instance.idDelayAmount;
		var idDelayUnit = instance.idDelayUnit;
		var idCroneType = instance.idCroneType
		var idScheduleTime = instance.idScheduleTime 
		var idScheduleDate = instance.idScheduleDate 
		var edmStartDateContainer = instance.edmStartDateContainer ;
		var idNextScheduleText = instance.idNextScheduleText; 
		var idEditEdmLink = instance.idEditEdmLink ;
		var idMailTemplate = instance.idMailTemplate ;
		var idDelayContainer = "delayContainer";
		var idPauseResumeLink = "pauseResumeLink";
		var idDayOfWeekContainer = "dayOfWeekContainer";
		var idDayOfMonthContainer = "dayOfMonthContainer";
		var idNextScheduleContainer = "nextScheduleContainer";
		var idTemplatePreivew = "templatePreivew";
		var idTimeContainer = "timeContainer";
		var idstartTime = instance.edmStartTime;
		// clone the edm template
		var nodeEdm = instance.templateEdmRootNode.clone();
		// append to main list
		instance.edmsList.append(nodeEdm);
		nodeEdm.set(instance.ATTR_EDM_SEQ, instance.edmSeq);
		
		var nodeEditFieldsGrp = nodeEdm.one("#" + idEditFieldsGrp);
		var nodeNextSchdText = nodeEdm.one("#" + idNextScheduleText);
		var nodeEditEdmLink = nodeEdm.one("#" + idEditEdmLink);
		var nodePauseResumeLink = nodeEdm.one("#" + idPauseResumeLink);
		var nodeDelayUnit = nodeEdm.one("#" + idDelayUnit);
		var nodeDelayAmount = nodeEdm.one("#" + idDelayAmount);
		nodePauseResumeLink.setAttribute(instance.ATTR_EDM_SEQ,  instance.edmSeq);

		var nodeCroneType = nodeEdm.one("#" + idCroneType ); 
		
		// set id's for each fields in edm
		//All textbox and dropdowns
		nodeEdm.all("input,select").each(function(node){
			var name = node.get('name');
			if("edmSeqNo" ==  name){
				// edmSeqNo used at server side to indicate edm's sequence and grouping all fields belongs one edm 
				node.val(instance.edmSeq);
			}
			if(edm && edm.edmId){
				node.val(edm[name]);
			}
			instance.setNameAndId(node, name + instance.edmSeq);
		});
		
		// set date & time values for the edms
		if(edm){
		var delayField = document.getElementById("delayAmount"+ instance.edmSeq);
		delayField.value = edm.delayAmount;
		var startDateField = document.getElementById("edmStartDate"+ instance.edmSeq);
		var timeField = document.getElementById("edmStartTime"+ instance.edmSeq);
		if(edm.delayAmount == 0 && edm.scheduleDate != "" && edm.scheduleDate != null){
		var schDate = edm.scheduleDate.substring(0, 10);
		var schTime = edm.scheduleDate.substring(11, 16);
		startDateField.placeholder = schDate;
		timeField.value = schTime;
		}
		}
		// any other nodes like div,span etc..
		var others = ["#" +edmStartDateContainer,"#" +idEditFieldsGrp, "#" + idNextScheduleText, "#" + idEditEdmLink, "#" + idTemplatePreivew, "#" + idDelayContainer, "#" + idDayOfMonthContainer, "#" + idDayOfWeekContainer, "#" + idNextScheduleContainer, "#" + idTimeContainer, "#" + idstartTime,"#delayDateDivider","#startDatelabel","#startTimelabel","#recurrenceWrap"];
		nodeEdm.all(others.join(", ") ).each(function(node){
			instance.setNameAndId(node,node.get('id') + instance.edmSeq);
		});
		var recurrenceWrap  = A.one("#recurrenceWrap" + instance.edmSeq);
		// hide dates for subscription based campaign
		if(instance.nodeCampaignType.val() == instance.CAMPAIGN_TYPE_SUBSCRIPTION){
			instance.hide(nodeEdm.one("div[data-divide]"));
			instance.hide(nodeEdm.one("div[data-date-container]"));
			instance.hide(nodeEdm.one("div[data-time-container]"));
			instance.hide(nodeEdm.one("div[data-label]"));
			instance.hide(recurrenceWrap);
		}else{
			instance.show(recurrenceWrap);
		}
		
		// show or hide time field based on delay unit/delay amount and cronetype
		var showHideTime = function(seqNo){
			var DELAY_MINS = "mins";
			var DELAY_HOURS = "hours";
			var timeContainer  = A.one("#" + idTimeContainer + seqNo);
			var dateContainer  = A.one("#edmStartDate" + seqNo);
			var delayDateDivider  = A.one("#delayDateDivider" + seqNo);
			var startDatelabel  = A.one("#startDatelabel" + seqNo);
			var startTimelabel  = A.one("#startTimelabel" + seqNo);
			var nodeDelayUnit = A.one("#" + idDelayUnit + seqNo);
			var nodeDelayAmount = A.one("#" + idDelayAmount + seqNo);
			var nodeCroneType = A.one("#" + idCroneType + seqNo);
			if(nodeCroneType.val() == instance.CRONE_ONE_TIME && (nodeDelayUnit.val() ==  DELAY_MINS || nodeDelayUnit.val() ==  DELAY_HOURS)){
				if(instance.nodeCampaignType.val() == instance.CAMPAIGN_TYPE_SUBSCRIPTION){
					instance.hide(startTimelabel);
					instance.hide(timeContainer);
					instance.hide(dateContainer);
					instance.hide(delayDateDivider);
					instance.hide(startDatelabel);
				}else{
					if(nodeDelayAmount.val() > 0){
						instance.hide(timeContainer);
						instance.hide(dateContainer);
						instance.hide(delayDateDivider);
						instance.hide(startDatelabel);
						instance.hide(startTimelabel);
					}else{
						instance.show(timeContainer);
						instance.show(dateContainer);
						instance.show(delayDateDivider);
						instance.show(startDatelabel);
						instance.show(recurrenceWrap);
						instance.show(startTimelabel);
					}
				}
			}else{
				if(instance.nodeCampaignType.val() == instance.CAMPAIGN_TYPE_SUBSCRIPTION){
					instance.hide(dateContainer);
					instance.hide(startDatelabel);
					instance.hide(recurrenceWrap);
				}else{
					instance.show(dateContainer);
					instance.show(startDatelabel);
					instance.show(recurrenceWrap);
				}
				instance.show(timeContainer);
				instance.show(delayDateDivider);
				instance.show(startTimelabel);
			} 
		
		}
		// Delay Unit 
		nodeDelayUnit.setAttribute(instance.ATTR_EDM_SEQ,  instance.edmSeq);
		nodeDelayUnit.on("change",function(){
			var seqNo = this.getAttribute(instance.ATTR_EDM_SEQ);
			showHideTime(seqNo);
			
		});
		
		// Delay Amount
		nodeDelayAmount.setAttribute(instance.ATTR_EDM_SEQ,  instance.edmSeq);
		nodeDelayAmount.on("change",function(){
			var seqNo = this.getAttribute(instance.ATTR_EDM_SEQ);
			showHideTime(seqNo);
		});
		//nodeDelayUnit.simulate("change"); // No need to simulate as cronetype change event internally calls showHideTime	
		
		// template preview link
		var nodeTemplatePreview = A.one("#" + idTemplatePreivew + instance.edmSeq);
		nodeTemplatePreview.setAttribute(instance.ATTR_EDM_SEQ, instance.edmSeq);
		var selTemplateId  = A.one("#" + idMailTemplate + instance.edmSeq);
		selTemplateId.on("change",function(){
			nodeTemplatePreview.removeClass("hide");
		});
		nodeTemplatePreview.on("click",function(){
			var templateId  = A.one("#" + idMailTemplate + this.getAttribute(instance.ATTR_EDM_SEQ)).val();
			instance.previewTemplate(templateId);
		});
		
		// change in crone typ
		nodeCroneType.setAttribute(instance.ATTR_EDM_SEQ,  instance.edmSeq);
		nodeCroneType.on("change",function(){
			var dayOfWeekContainer  = A.one("#" + idDayOfWeekContainer + this.getAttribute(instance.ATTR_EDM_SEQ));
			var dayOfMonthContainer  = A.one("#" + idDayOfMonthContainer + this.getAttribute(instance.ATTR_EDM_SEQ));
			// first hide both then show based on value of cronetype
			instance.hide(dayOfMonthContainer);
			instance.hide(dayOfWeekContainer);
			
			// show date field if recurrence is set to one time
			var dateContainer  = A.one("#" + edmStartDateContainer + this.getAttribute(instance.ATTR_EDM_SEQ));
			var delayContainer  = A.one("#" + idDelayContainer + this.getAttribute(instance.ATTR_EDM_SEQ));
			if(this.val() ==  instance.CRONE_ONE_TIME){
				instance.show(dateContainer);
			//	instance.hide(delayContainer);
				if(instance.nodeCampaignType.val() == instance.CAMPAIGN_TYPE_SUBSCRIPTION){
				}
			}
			if(this.val() == instance.CRONE_WEEKLY ){
				instance.hide(dayOfMonthContainer);
				instance.show(dayOfWeekContainer);
			}else if(this.val() == instance.CRONE_MONTHLY ){
				instance.hide(dayOfWeekContainer);
				instance.show(dayOfMonthContainer);
			}
			showHideTime(this.getAttribute(instance.ATTR_EDM_SEQ));
		});
		
		//nodeCroneType.simulate("change");
		nodeEditEdmLink.setAttribute(instance.ATTR_EDM_SEQ, instance.edmSeq);
		nodeEditEdmLink.on("click",function(){
			instance.show(A.one("#" + instance.idEditFieldsGrp + this.getAttribute(instance.ATTR_EDM_SEQ)));
			var startTimelabel  = A.one("#startTimelabel" + instance.edmSeq);
			showHideTime(instance.edmSeq);
			var nextSchdCont  = A.one("#" + idNextScheduleContainer + this.getAttribute(instance.ATTR_EDM_SEQ));
			instance.hide(nextSchdCont);
			//A.one("#" + instance.idCroneType + this.getAttribute(instance.ATTR_EDM_SEQ)).simulate("change");
			instance.hide(this.ancestor());
			
		});

		// configure the calendar. must set unique id's for calender fields & time fields
		//try{
			
			var containerId = instance.edmStartDateContainer + instance.edmSeq;
			var startDateId = instance.edmStartDate + instance.edmSeq;
			//var startTimeId = instance.edmStartTime + instance.edmSeq;
			
			instance.calenderHandler(containerId,startDateId);
			//instance.timeHandler(containerId,startTimeId);

			//instance.calenderHandler(dpId,dpcId, idNewDay, idNewMonth,idNewYear,iid);
			
//		}catch(err){
//			console.log(err);
//		}
		
		if(edm && edm.edmId){
			//initially hide it. clicking on edit link show it.
			instance.hide(nodeEditFieldsGrp);
			if(edm.jobStatus == 0 || edm.jobStatus == 4 || edm.jobStatus == 2){
				instance.show(nodeEditEdmLink);
			}else{
				instance.hide(nodeEditEdmLink);
			}	
			
			if(instance.CAMPAIGN_TYPE_SUBSCRIPTION == instance.nodeCampaignType.val()){
				// for subscription basses, scheduling happens at subscriber level. so no need to display job status and pause/resume link
				instance.hide(nodePauseResumeLink);
			}else{
				instance.show(nodePauseResumeLink);
				nodePauseResumeLink.setAttribute(instance.ATTR_EDM_JOB_STATUS,  edm.jobStatus);
				nodePauseResumeLink.setAttribute(instance.ATTR_EDM_ID,  edm.edmId);
				instance.pausePlayLink(edm.jobStatus, nodePauseResumeLink);
				nodePauseResumeLink.on("click",function(){
					instance.toggleJobStatus(this);
				});
			}
			
			var nextSchdCont  = A.one("#" + idNextScheduleContainer + instance.edmSeq);
			var nextSchdText  =  A.one("#" + idNextScheduleText + instance.edmSeq);
			nextSchdText.html(edm.nextScheduleTime ? edm.nextScheduleTime : "");
			instance.show(nextSchdCont);
			
			
		}else{
			// new row --
			//TODO: set default values
			//it's node with unsaved data so no need to show edit link
			instance.hide(nodeEditEdmLink);
			instance.hide(nodePauseResumeLink);
			instance.hide(nodeNextSchdText.ancestor("div[id=container]"));
		}
		// display newly created edm
		instance.show(nodeEdm);
	}
	
	this.pausePlayLink = function(jobStatus,nodePlayPause){
		if(! nodePlayPause) return;
		jobStatus = jobStatus ? jobStatus.toLowerCase() : "";
		var instance = this;
		if(jobStatus == instance.STATUS_PAUSED){
			nodePlayPause.html('Resume');
		}else if(jobStatus == instance.STATUS_NORMAL){
			nodePlayPause.html('Pause');
		}else if(jobStatus == instance.STATUS_COMPLETE){
			nodePlayPause.html('Completed');
			nodePlayPause.addClass(instance.CLS_NOT_ACTIVE);
			//instance.hide(nodePlayPause);
		}else {
			nodePlayPause.html("");
			nodePlayPause.addClass(instance.CLS_NOT_ACTIVE);
		}
		nodePlayPause.setAttribute(instance.ATTR_EDM_JOB_STATUS, jobStatus);
	}
	
	this.setNameAndId = function(node,newVal){
		if(node){
			// id and name both must be available. name is required to send data to server when form is submitted. id to handle the node easily in script.
			node.set('id',newVal);
			node.set('name',newVal);
		}
	}
	
	this.calenderHandler = function(containerId,triggerId){
		//alert("calenderHandler triggerId " + triggerId);
		var datePicker = new A.DatePicker(
				{
					container: '#' + containerId,
					mask: '%m/%d/%Y',
					//setValue: true,
					popover: {
						zIndex: Liferay.zIndex.TOOLTIP
					},
					trigger: '#' + triggerId,
					calendar: {
						       // minimumDate: new Date(2011,00,01),
						       // maximumDate: new Date(2012,08,05),
						selectedDates:new Date(2012,08,05),
						    },
					on: {
				          selectionChange: function(event) {
				            console.log("date ",event.newSelection)
				          }
					}
				});
		datePicker.se
		//datePicker.defaultDate(new Date());
	}
	
//	this.timeHandler = function(containerId,triggerId){
//		//alert("triggerId " + triggerId);
//		var timePicker = A.TimePicker(
//			      {
//			    	  container: '#' + containerId,
//			          trigger: '#' + triggerId,
//			          mask: '%H:%M',
//			          popover: {
//			            zIndex: Liferay.zIndex.TOOLTIP
//			          },
//			          on: {
//			            selectionChange: function(event) {
//			              console.log(event.newSelection)
//			            }
//			          }
//			        }
//			      );
//	}
	
	this.previewTemplate = function(templateId){
		var instance = this;
		if(templateId){
			A.io.request(instance.ajaxUrl,{
				dataType : 'json',
				method : 'POST',
				data : {
					filterName: 'fetchTemplateDetailsNew',
					templateId: templateId,
				},
				on : {
				success : function() {
						var data = this.get('responseData');
						if(data && data.code==0){
							var myWindow = window.open("", data.subject,'width=680,location=no,toolbar=no,menubar=no,status=no,resizable=0,scrollbars=yes,height=700,top=100,left=100');
					   		myWindow.document.write(data.content);
						}else{
							alert("can not generate preview");
						}
					}
				}
			});
		
		}
	}
	
	this.isAddCampaign = function(){
		var instance = this;
		var isAdd = ! instance.isEditCampaign();
		return isAdd;
	}
	this.isEditCampaign = function(){
		var instance = this;
		var isEdit = (instance.nodeCampaignId.val().trim() != "");
		return isEdit;
	}
	
	this.onSubmit =  function(){
		var instance = this;
		var nodeCampaignType= instance.nodeCampaignType;
		var nodeCampaignName = instance.nodeCampaignName;
		var isEdit = (instance.nodeCampaignId.val().trim() != "");
		var isAdd = !isEdit;
		var edmFields = A.all(".edmName");

		// validate for atleast 1 edm
		if(edmFields.size() <= 1){
			alert("Atleast 1 EDM need to be added");
			return;
		}
	
		// validate campaign name
		if(nodeCampaignName.val().trim() == ""){
			alert("Campaign Name should not be empty!");
			nodeCampaignName.focus();
			nodeCampaignName.addClass("error");
			return;
		}

		// validate campaign type. In case of edit, campaign is disabled and not required to validate
		if(isAdd){
			if(nodeCampaignType.val().trim() == ""){
				alert("Please select campaign type");
				nodeCampaignType.focus();
				nodeCampaignType.addClass("error");
				return
			}else{
				nodeCampaignType.removeClass("error");
			}
		}
		if(isEdit){
		}
		var start = instance.getInt(instance.edmSeqNoLower.val());
		var end = instance.getInt(instance.edmSeqNoHigher.val());
		var validateSchdDate = false;
		// validating start date is required  if it automated scheduling and edit campaing screen and reschedule checkbox is checked
		// or new campaign
		if(nodeCampaignType.val() == instance.CAMPAIGN_TYPE_AUTOMATED){
			if(instance.isEditCampaign() && instance.nodeReschedule.get('checked') == true){
				validateSchdDate = true;
			}
			if(instance.isAddCampaign()){
				validateSchdDate = true;
			}
		}
		// validate edm name
		// validate mail template
		for(var i = start; i <= end; i++){
			var nodeEdmName = A.one("#" + instance.idEdmName + i);
			if(nodeEdmName && nodeEdmName.val().trim() == ""){
				alert("Please provide name for EDM");
				nodeEdmName.focus();
				return;
			}
			var nodeMailTemplate = A.one("#" + instance.idMailTemplate + i);
			if(nodeMailTemplate && nodeMailTemplate.val().trim() == "" || nodeMailTemplate.val() == "0"){
				alert("Please select mail template for " + nodeEdmName.val() );
				nodeMailTemplate.focus();
				return;
			}
			
			// validate delay amount

			var nodeDelayAmount = A.one("#" + instance.idDelayAmount + i);
			if(nodeDelayAmount){
				if(! instance.isValidInteger(nodeDelayAmount.val(),true)){
					alert("'Wait At Least value' " + nodeDelayAmount.val() + " is invalid. Please provide positive integer value.")
					nodeDelayAmount.focus();
					return;
				}else{
					if(instance.getInt(nodeDelayAmount.val()) < 0){
						alert("Wait At Least is not valid. Please provide positive integer value.")
						nodeDelayAmount.focus();
						return;
					}
				}
			}
			
			if(! validateSchdDate){
				continue;
			}
			// validate date

			var nodeDelayAmount = A.one("#" + instance.idDelayAmount + i);
			var startDateId = A.one("#" +instance.edmStartDate + instance.edmSeq);
			var startDateIdVal = startDateId.val();
			var startTimeId = A.one("#" +instance.edmStartTime + instance.edmSeq);
			var startTimeIdVal = startTimeId.val();
			var parts =startDateIdVal.split('/');
			var hrparts = startTimeIdVal.split(':');
			var timeLen = startTimeIdVal.length;
			
			if(nodeDelayAmount){
				if(instance.getInt(nodeDelayAmount.val()) == 0 ){
//					var day = A.one("#" + instance.pns + instance.idScheduleDay + i);
//					var month = A.one("#" + instance.pns + instance.idScheduleMonth + i);
//					var year = A.one("#" + instance.pns + instance.idScheduleYear + i);
					
					var nodeCroneType = A.one("#" + instance.idCroneType + i);
					var dateStart;
					if(nodeCroneType.val() ==  instance.CRONE_ONE_TIME){
						// if job is one time, then consider the time as well
						var hour = hrparts[0];
						var min = hrparts[1].substring(0, 1);
						var ampm = hrparts[1].substring(timeLen-1, timeLen);
						
						
						var dateString = startDateIdVal + "," + startTimeIdVal;
						var date = new Date(dateString);
						var yr = date.getFullYear();
						var mo = date.getMonth() + 1;
						var day = date.getDate();

						var hours = date.getHours();
						var hr = hours < 10 ? '0' + hours : hours;

						var minutes = date.getMinutes();
						var min = (minutes < 10) ? '0' + minutes : minutes;

						var seconds = date.getSeconds();
						var sec = (seconds < 10) ? '0' + seconds : seconds;

						var newDateString = yr + '-' + mo  + '-' + day;
						var newTimeString = hr + ':' + min + ':' + sec;

						var excelDateString = newDateString + ' ' + newTimeString;
						
						
						dateStart = newDateString + ' ' + newTimeString;//new Date(parts[2],parts[0]-1,parts[1]);//,instance.convertTo24Hr(hour,ampm),min, 0);
					}else{
						// all other cases, daily, weekly,yearly.. etc.. time is not required to consider. so putting max value 23,59, 1
						dateStart = new Date(parts[2],parts[0]-1,parts[1],23,59,1);
					}
										
					var now = new Date();
					now.setTime(now.getTime() + 2*60000); // min 2 min future..
					if(now.getTime() > new Date(dateStart).getTime()){
						alert("Start date for EDM"  + nodeEdmName.val() +  " can not be in past");
						startDateId.focus();
						return;
					}
				}
			}
			
		
		}
		instance.nodeForm.submit();
	}
	
	this.isValidInteger = function(num,emptyValid){
		var valid = true;
		try{
			 if(num){ 
				 // to make sure num is in string type.
				 num = num + "";
				 if(num.trim() != ''){
					 for(var i =0 ; i < num.length; i++){
						 if(num.charCodeAt(i) < 48 || num.charCodeAt(i) > 57){
							 valid = false;
							 break;
						 }
					 }
				 }else{
					 if(! emptyValid){
						 valid = false;
					 }
				 }
			 }else{
				 if(! emptyValid){
					 valid = false;
				 }
			 }
		}catch (e) {
			console.log(e);
		}
		return valid;
	}
	
	this.getInt = function(num){
		try{
			if(! this.isValidInteger(num,false)){
				return 0;
			}else{
				return parseInt(num);
			}
		}catch(e){
			console.log(e);
		}
		return 0;
	}
	
	this.convertTo24Hr = function(hours,ampm){
		var instance = this;
		hours = instance.getInt(hours);
		ampm = instance.getInt(ampm);
		// 0  - AM
		// 1  - PM
		// Hours start from 0 to 11
		
		// in case hours = 0
		if(hours  < 1){
			// if it is pm
			if(ampm == 1){
				hours = 12;
			}
		}else{
			hours = hours + 12;
		}
		return hours;
	}
	
	this.show = function(node){
		if(node){
			node.removeClass("hide");
		}
	}
	this.hide = function(node){
		if(node){
			node.addClass("hide");
		}
	}
	
	this.init(config);
	
}

