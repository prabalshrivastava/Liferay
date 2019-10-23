var spLogActivity = function(config) {
    var AArray = A.Array;
    var instance;
    var searchCriteriaChangedLogActivty = false;
    this.init = function(config) {
        instance = this;
        this.pns = config.pns;
        this.ajaxUrl = config.ajaxUrl;
        this.entityId = config.entityId;
        this.entityClassId = config.entityClassId;
        this.entityClassName = config.entityClassName;
        this.ajaxUrlFileUpload = config.ajaxUrlFileUpload;
        this.associatedWith = config.associatedWith;
        this.extUser = config.extUser;
        this.closedStageId = config.closedStageId;

        this.logActivityTitle = A.one("#logActivityTitle");
        this.logActivityContent = A.one("#logTxtArea");
        this.logActivityType = A.one("#normal-select-1");
        this.logActivityOutcome = A.one("#normal-select-2");
        this.uploadsFileEntryId = A.one("#uploadsFileEntryIdLogActivity");
        this.saveLogActivityElem = A.one("#saveLogActivity");
        this.logActivityDate = A.one("#logActivityDate");
        this.logActivityTime = A.one("#logActivityTime");

        if (A.one("#logActivityDateContainer")) {
            instance.logActivityDate.setAttribute('dpId', 'dp0');
            this.datePickerLogActivity("logActivityDateContainer", "logActivityDate", "dp0");
        }

        if (A.one("#logActivityTimeContainer")) {
            instance.logActivityTime.setAttribute('tpId', 'tp0');
            this.timePickerLogActivity("logActivityTimeContainer", "logActivityTime", "tp0");
        }

        
        if (instance.closedStageId != 0) {
         	 var convosAddremove = document.getElementById('myTab');
              convosAddremove.classList.add("hide");
       }else{
      	   var convosAddremove = document.getElementById('myTab');
             convosAddremove.classList.remove("hide");
       }
        
        this.initializeSaveLogActivity();
        this.initializeLoadLogActivity();
        this.initializeFileUpload();
        this.initializeTypeDropdown();
       
    }


    this.initializeSaveLogActivity = function() {
        if (A.one("#saveLogActivity")) {
            A.one("#saveLogActivity").on("click", function() {
                instance.saveLogActivity();
            });
        }

    }

    this.initializeTypeDropdown = function() {
        if (A.one("#normal-select-1")) {
            A.one("#normal-select-1").on("change", function() {
                if (A.one('#normal-select-1').val() == "Log a Call") {
                    instance.logActivityOutcome.ancestor().removeClass('hide');
                    instance.logActivityOutcome.addClass('Requiredfield');
                } else {
                    instance.logActivityOutcome.ancestor().addClass('hide');
                    instance.logActivityOutcome.removeClass('Requiredfield');
                    instance.logActivityOutcome.ancestor().removeClass('ErrorValidation');
                }
            });
        }

    }

    this.initializeFileUpload = function() {
        if (A.one("#logActivityFile")) {
            A.one("#logActivityFile").on("change", function() {
                instance.GetFileSizeNameAndTypeLogActivity();
                A.one("#logActivityFile").ancestor().ancestor().removeClass('activeAction');
            });
        }

    }

    this.initializeEnterKeySearch = function() {
        var nodes = [A.one("#searchLogActivityInpBar_Id")];
        var nodeList = new A.NodeList(nodes);
        nodeList.on("keypress", function(ev) {
            // click on enter
            if (ev.keyCode == 13) {
                searchCriteriaChangedLogActivty = true;
                instance.loadLogActivity();
            }
        });
    }

    this.initializeLoadLogActivity = function() {
        if (A.one("#logActivityLoad")) {
            A.one("#logActivityLoad").on("click", function() {

                instance.loadLogActivity();
            });


        }

    }


    this.saveLogActivity = function() {
    	
    	var validationResult = validateReqField("tab-logActivity","");

    	if (!validationResult){
	        var obj = {};
	        obj.action = "saveLogActivity";
	
	        if (instance.logActivityType) {
	            obj.logActivityType = instance.logActivityType.val();
	        }
	        if (instance.logActivityDate) {
	            obj.logActivityDate = instance.logActivityDate.val();
	        }	
	        if (instance.logActivityTime) {
	            obj.logActivityTime = instance.logActivityTime.val();
	        }
	        if (instance.logActivityTitle) {
	            obj.logActivityTitle = instance.logActivityTitle.val();
	        }
	        if (instance.logActivityContent) {
	            obj.logActivityContent = instance.logActivityContent.getDOMNode().innerHTML;
	        }
	
	        if(instance.logActivityOutcome){
	            obj.logActivityOutcome = instance.logActivityOutcome.val();
	        }
	
	        obj.entityId = instance.entityId;
	        obj.entityClassId = instance.entityClassId;
	        obj.entityClassName = instance.entityClassName;
	        obj.associatedWith = instance.associatedWith;
	        obj.uploadsFileEntryId = instance.uploadsFileEntryId.val();
	
	        A.io.request(instance.ajaxUrl, {
	            dataType: 'json',
	            method: 'POST',
	            sync: true,
	            data: obj,
	            on: {
	                success: function() {
	                    var data = this.get("responseData");
	                    if (data) {
	                        if (data.error) {
	                            alert(data.error);
	                        } else {
	                        	instance.clearLogActivity();
	                            instance.loadLogActivity();
	                        }
	                    }
	
	                },
	                failure: function() {
	                    alert('Error while saving message');
	                }
	            }
	        });
    	}

    }
    
    this.clearLogActivity =  function(){
    	document.getElementById('logActivityTitle').value = "";
    	instance.logActivityContent.getDOMNode().innerHTML = "";
    	if (document.getElementById('fileUploadLogActivity')){
    		document.getElementById('fileUploadLogActivity').innerHTML = "";    
    	}
    	document.getElementById('logActivityDate').value = "";
    	document.getElementById('logActivityTime').value = "";
    	
    	var options = document.querySelectorAll('#normal-select-1' + ' option');
        for (var i = 0, l = options.length; i < l; i++) {
            options[i].selected = options[i].defaultSelected;
        }
        
        var options = document.querySelectorAll('#normal-select-2' + ' option');
        for (var i = 0, l = options.length; i < l; i++) {
            options[i].selected = options[i].defaultSelected;
        }
        
        instance.logActivityOutcome.ancestor().removeClass('hide');
         
    }



    this.updateLogActivity = function(logActivity) {

    	var counterId = logActivity.getAttribute('counter-id');
    	var validationResult = validateReqField("logContainerid", "_"+counterId);
    	
    	if (!validationResult){
	        var obj = {};
	        obj.action = "updateLogActivity";
	        var logActivityContent = document.getElementById('notifyMessageLog_' + (+counterId));
	        if (logActivityContent) {
	            obj.logActivityContent = logActivityContent.innerHTML;
	        }
	        var logActivityTitle = document.getElementById('notifyTitleIdLog_' + (+counterId));
	        if (logActivityTitle) {
	            obj.logActivityTitle = logActivityTitle.innerHTML;
	        }
	        var logActivityOutcome = document.getElementById('selectActivity_' + (+counterId));
	        if (logActivityOutcome) {
	            obj.logActivityOutcome = logActivityOutcome.value;
	        }
	        var logActivityDate = document.getElementById('notifyDateEdit_' + (+counterId));
	        if (logActivityDate) {
	            obj.logActivityDate = logActivityDate.value;
	        }
	        var logActivityTime = document.getElementById('notifyTimeEdit_' + (+counterId));
	        if (logActivityTime) {
	            obj.logActivityTime = logActivityTime.value;
	        }
	        obj.logActivityId = logActivity.id;
	        var logActivityAttachment = document.getElementById('input-fileAtn1' + (+counterId));
	        if (logActivityAttachment) {
	            obj.uploadsFileEntryId = logActivityAttachment.value;
	        }
	        obj.classNameToUpdate = logActivity.getAttribute('classNameToUpdate');
	
	        A.io.request(instance.ajaxUrl, {
	            dataType: 'json',
	            method: 'POST',
	            sync: true,
	            data: obj,
	            on: {
	                success: function() {
	                    var data = this.get("responseData");
	                    if (data) {
	                        if (data.error) {
	                            alert(data.error);
	                        } else {
	                            instance.loadLogActivity();
	                        }
	                    }
	
	                },
	                failure: function() {
	                    alert('Error while saving message');
	                }
	            }
	        });
	        
    	}

    }

    this.loadLogActivity = function() {

        var obj = {};
        obj.action = "loadLogActivity";
        obj.entityId = instance.entityId;
        obj.entityClassId = instance.entityClassId;
        obj.searchText = A.one("#searchLogActivityInpBar_Id") ? A.one("#searchLogActivityInpBar_Id").val() : "";
        A.io.request(instance.ajaxUrl, {
            dataType: 'json',
            method: 'POST',
            sync: true,
            data: obj,
            on: {
                success: function() {
                    var data = this.get("responseData");
                    if (data) {
                        if (data.error) {
                            alert(data.error);
                        } else {
                            instance.addElement(data);
                        }
                    }

                },
                failure: function() {
                    alert('Error while saving message');
                }
            }
        });

    }

    this.addSearchSection = function() {

        //clear the existing data
        if (document.getElementById('tabActivity')) {
            document.getElementById('tabActivity').innerHTML = '';
        }


        //NO OF INTERACTIONS
        var divTitlebar = document.createElement('div');
        divTitlebar.setAttribute('class', 'tabTitleBar');
        divTitlebar.setAttribute('id', 'tabLogTitleBarId');
        var titleSpan = document.createElement('span');
        titleSpan.setAttribute('id', 'titleLogSpanId');
        var dvP = document.createElement('P');
        // titleSpan.textContent = data.total;
        dvP.textContent = "INTERACTIONS";

        var searchCon = document.createElement('div');
        searchCon.setAttribute('class', 'searchListWrap');
        searchCon.setAttribute('id', 'searchLogsListID');

        var searchCon_Img = document.createElement('IMG');

        searchCon_Img.setAttribute("id", "searchLogsListIDimg");
        searchCon_Img.src = '/SPActivityHub-portlet/images/searchuser.svg';
        var searchConClose_Img = document.createElement('IMG');
        searchConClose_Img.setAttribute("id", "searchLogsListIDimgclose");
        searchConClose_Img.setAttribute("class", "closeSearch");


        searchConClose_Img.src = '/SPActivityHub-portlet/images/closeSearch.svg';
        var searchInpBar = document.createElement('input');
        searchInpBar.setAttribute('class', 'searchInpBar');
        searchInpBar.setAttribute('id', 'searchLogActivityInpBar_Id');
        searchInpBar.setAttribute('type', 'text');
        searchInpBar.setAttribute('placeholder', 'SEARCH INTERACTION');
        searchInpBar.setAttribute('name', 'searchBarId');
        var searchResultP = document.createElement('p');
        searchResultP.setAttribute('class', 'searcgresultDiv');
        searchResultP.setAttribute('id', 'searchLogresultDivId');
        //searchResultP.innerHTML = "<b>0</b>results";

        divTitlebar.appendChild(titleSpan);
        divTitlebar.appendChild(dvP);
        searchCon.appendChild(searchInpBar);
        searchCon.appendChild(searchCon_Img);
        searchCon.appendChild(searchConClose_Img);
        searchCon.appendChild(searchResultP);


        divTitlebar.appendChild(searchCon);
        document.getElementById('tabActivity').appendChild(divTitlebar);

        if (A.one("#searchLogsListIDimg")) {
            A.one("#searchLogsListIDimg").on("click", function() {
                instance.searchLogActivity();
            });
        }

        if (A.one("#searchLogsListIDimgclose")) {
            A.one("#searchLogsListIDimgclose").on("click", function() {
                instance.searchLogActivityClose();
            });
        }



    }

    this.searchLogActivity = function() {

        var serachIc = document.getElementById("searchLogsListID");
        serachIc.classList.add("showSearch");


    }
    this.searchLogActivityClose = function() {

        var serachIcClose = document.getElementById("searchLogsListID");
        serachIcClose.classList.remove("showSearch");
        var searchInputClear = document.getElementById('searchLogActivityInpBar_Id');
        searchInputClear.value = "";
        instance.loadLogActivity();


    }

    //add listing section
    this.addElement = function(data) {

        if (data.total != 0 && !searchCriteriaChangedLogActivty) {
            instance.addSearchSection();
            instance.initializeEnterKeySearch();
        }


        if (document.getElementById('searchLogresultDivId')) {
            document.getElementById('searchLogresultDivId').innerHTML = "<b>" + data.total + "</b>results";
        }


        if (document.getElementById('titleLogSpanId')) {
            document.getElementById('titleLogSpanId').textContent = data.total;
        }


        //clear the existing data
        if (document.getElementById('logDetailsWrapperId')) {
            A.all('#logDetailsWrapperId').remove();
        }

        if (A.one('.emptyContainer')) {
            A.one('.emptyContainer').remove();
        }



        //NOTE CONTENT WRAP
        var divLogsWrap = document.createElement('div');
        divLogsWrap.setAttribute('class', 'actDetailsWrapper');
        divLogsWrap.setAttribute('id', 'logDetailsWrapperId');




        var divLogsinnerWrap = document.createElement('div');
        divLogsinnerWrap.setAttribute('class', 'innerActd');
        divLogsinnerWrap.setAttribute('id', 'logdetailsec');

        divLogsWrap.appendChild(divLogsinnerWrap);
        document.getElementById('tabActivity').appendChild(divLogsWrap);



      



        if (data.total == 0 && instance.extUser == "Internal" && !searchCriteriaChangedLogActivty) {
            var logsList = document.getElementById('tabActivity');
            logsList.innerHTML = '';
            var emptyLogContainerLog = document.createElement('DIV');
            emptyLogContainerLog.setAttribute('class', 'emptyContainer');
            var eContTitleLog = document.createElement('p');
            eContTitleLog.setAttribute('class', 'emTitle');
            eContTitleLog.innerHTML = "<b>0</b>Activity";
            var econtIconLog = document.createElement('IMG');
            econtIconLog.src = "/SPActivityHub-portlet/images/conversations_Empty.svg";
            var econtTaglineLog = document.createElement('H2');
            econtTaglineLog.setAttribute('class', 'empTag');
            econtTaglineLog.innerHTML = "Record and track all activities!";
            var econtMessageLog = document.createElement('P');
            econtMessageLog.setAttribute('class', 'emptyMessage');
            econtMessageLog.innerHTML = 'Create one using the section above';

            emptyLogContainerLog.appendChild(eContTitleLog);
            emptyLogContainerLog.appendChild(econtIconLog);
            emptyLogContainerLog.appendChild(econtTaglineLog);
            emptyLogContainerLog.appendChild(econtMessageLog);
            logsList.appendChild(emptyLogContainerLog);
        } else {
            //ACTIVITY CONTENT WRAP **REPEAT SECTION***
            var chkForToday = false;
            var chkForOlder = false;
            for (var i = 1; i <= data.total; i++) {

                var counter = i;

                if (!data.logActivities[i - 1].createDate.includes("at") && !chkForToday) {
                    var logsType = document.createElement('div');
                    logsType.setAttribute('class', 'InActTitle');
                    var ctypeP = document.createElement('P');
                    ctypeP.textContent = "Today";
                    logsType.appendChild(ctypeP);
                    divLogsinnerWrap.appendChild(logsType);
                    chkForToday = true;
                } else if (data.logActivities[i - 1].createDate.includes("at") && !chkForOlder) {
                    var logsType = document.createElement('div');
                    logsType.setAttribute('class', 'InActTitle');
                    var ctypeP = document.createElement('P');
                    ctypeP.textContent = "Older";
                    logsType.appendChild(ctypeP);
                    divLogsinnerWrap.appendChild(logsType);
                    chkForOlder = true;
                }

                var logContainer = document.createElement('div');
                logContainer.setAttribute('class', 'noteContainerDiv');
                logContainer.setAttribute('id', 'logContainerid_' + (+counter));

                
               

                var logContentWrap = document.createElement('div');
                logContentWrap.setAttribute('class', 'actDetailContent_notes');
                logContentWrap.setAttribute('id', 'noteWrapId' + (+counter));
                // logContentWrap.setAttribute('onclick', 'focusEditNotes(this)');

                var logCloseSpan = document.createElement('SPAN');
                logCloseSpan.setAttribute('class', 'closePopEditaction viewClose');
                logCloseSpan.setAttribute('id', 'closeLogView_' + (+counter));
                var logCloseSpanImg = document.createElement('IMG');
                logCloseSpanImg.src = '/SPActivityHub-portlet/images/cancelactivity.svg';
                logCloseSpan.appendChild(logCloseSpanImg);
                logContentWrap.appendChild(logCloseSpan);

                logCloseSpan.addEventListener('click', function(closeView) {
                    this.parentElement.classList.remove("editDetailact");
                })


                //-Notify Icon Img  
                var notifIcon = document.createElement('div');
                notifIcon.setAttribute('class', 'notifyIcon ');
                var notifIconImg = document.createElement('IMG');
                notifIconImg.src = "/SPActivityHub-portlet/images/activity_icon.svg";
                notifIcon.appendChild(notifIconImg);

                //-Time & User Details 
                var notifTimeweap = document.createElement('div');
                notifTimeweap.setAttribute('class', 'notifySenderTime');
                var notifySender = document.createElement('P');
                notifySender.textContent = data.logActivities[i - 1].caption;
                notifySender.setAttribute('class', 'notifySender');

                var str = data.logActivities[i - 1].createDate;
                notifyTime = document.createElement('SPAN');
                notifyTime.setAttribute('class', 'notifyTime');
                notifyTime.innerHTML = str;

                notifTimeweap.appendChild(notifySender);
                notifTimeweap.appendChild(notifyTime);

                logContentWrap.appendChild(notifIcon);
                logContentWrap.appendChild(notifTimeweap);




                //ActivityEdit
                if (data.logActivities[i - 1].classNameResult.includes('Activity')) {
                    notifyActivityEditWrap = document.createElement('DIV');
                    notifyActivityEditWrap.setAttribute('class', 'notifyActivityEditWrap');

                    if (data.logActivities[i - 1].logActivityType == "Log a Call") {
                        var notifyselectWrap = document.createElement('DIV');
                        notifyselectWrap.setAttribute('class', 'notifyActivityselect');
                        var notifyActivityEdit = document.createElement('SELECT');
                        
                        notifyActivityEdit.setAttribute('class', 'notifyActivityEdit Requiredfield');
                        notifyActivityEdit.setAttribute('id', 'selectActivity_' + (+counter));
                        notifyActivityEdit.setAttribute('onchange', 'validate(this)');
                        notifyActivityEdit.disabled = true;
                        var notifyOption1 = document.createElement('OPTION');
                        notifyOption1.value = '';
                        notifyOption1.innerHTML = 'Outcome';
                        notifyOption1.disabled = true;
                        notifyOption1.setAttribute('class', 'select-dropdown__list-item');
                        if (data.logActivities[i - 1].logActivityOutcome == notifyOption1.value) {
                            notifyOption1.setAttribute('selected', true);
                            notifyOption1.setAttribute('defaultSelected', true);
                        }

                        var notifyOption2 = document.createElement('OPTION');
                        notifyOption2.innerHTML = 'No Answer';
                        notifyOption2.value = 'No Answer';
                        notifyOption2.setAttribute('class', 'select-dropdown__list-item');
                        if (data.logActivities[i - 1].logActivityOutcome == notifyOption2.value) {
                            notifyOption2.setAttribute('selected', true);
                            notifyOption2.setAttribute('defaultSelected', true);
                        }

                        var notifyOption3 = document.createElement('OPTION');
                        notifyOption3.innerHTML = 'Busy';
                        notifyOption3.value = 'Busy';
                        notifyOption3.setAttribute('class', 'select-dropdown__list-item');
                        if (data.logActivities[i - 1].logActivityOutcome == notifyOption3.value) {
                            notifyOption3.setAttribute('selected', true);
                            notifyOption3.setAttribute('defaultSelected', true);
                        }

                        var notifyOption4 = document.createElement('OPTION');
                        notifyOption4.innerHTML = 'Wrong number';
                        notifyOption4.value = 'Wrong number';
                        notifyOption4.setAttribute('class', 'select-dropdown__list-item');
                        if (data.logActivities[i - 1].logActivityOutcome == notifyOption4.value) {
                            notifyOption4.setAttribute('selected', true);
                            notifyOption4.setAttribute('defaultSelected', true);
                        }

                        var notifyOption5 = document.createElement('OPTION');
                        notifyOption5.innerHTML = 'Left live message';
                        notifyOption5.value = 'Left live message';
                        notifyOption5.setAttribute('class', 'select-dropdown__list-item');
                        if (data.logActivities[i - 1].logActivityOutcome == notifyOption5.value) {
                            notifyOption5.setAttribute('selected', true);
                            notifyOption5.setAttribute('defaultSelected', true);
                        }

                        var notifyOption6 = document.createElement('OPTION');
                        notifyOption6.innerHTML = 'Left Voicemail';
                        notifyOption6.value = 'Left Voicemail';
                        notifyOption6.setAttribute('class', 'select-dropdown__list-item');
                        if (data.logActivities[i - 1].logActivityOutcome == notifyOption6.value) {
                            notifyOption6.setAttribute('selected', true);
                            notifyOption6.setAttribute('defaultSelected', true);
                        }

                        var notifyOption7 = document.createElement('OPTION');
                        notifyOption7.innerHTML = 'Connected';
                        notifyOption7.value = 'Connected';
                        notifyOption7.setAttribute('class', 'select-dropdown__list-item');
                        if (data.logActivities[i - 1].logActivityOutcome == notifyOption7.value) {
                            notifyOption7.setAttribute('selected', true);
                            notifyOption7.setAttribute('defaultSelected', true);
                        }

                        notifyActivityEdit.appendChild(notifyOption1);
                        notifyActivityEdit.appendChild(notifyOption2);
                        notifyActivityEdit.appendChild(notifyOption3);
                        notifyActivityEdit.appendChild(notifyOption4);
                        notifyActivityEdit.appendChild(notifyOption5);
                        notifyActivityEdit.appendChild(notifyOption6);
                        notifyActivityEdit.appendChild(notifyOption7);
                        notifyselectWrap.appendChild(notifyActivityEdit);
                        notifyActivityEditWrap.appendChild(notifyselectWrap);

                    }

                    //DATE
                   
                    var notifyDateEditSpan = document.createElement('SPAN');
                    notifyDateEditSpan.setAttribute('class', 'lfr-input-dateAct');
                    notifyDateEditSpan.setAttribute('id', 'notifyDateEditSpan_' + (+counter));
                    var notifyDateEdit = document.createElement('INPUT');
                    notifyDateEdit.setAttribute('type', 'text');
                    notifyDateEdit.setAttribute('placeholder', 'Date');
                    notifyDateEdit.disabled = true;
                    notifyDateEdit.setAttribute('class', 'notifyDateEdit Requiredfield');
                    notifyDateEdit.setAttribute('id', 'notifyDateEdit_' + (+counter));
                    var notifyDateEditError = document.createElement('SPAN');
                    notifyDateEditError.setAttribute('class', 'actErrorNotif');
                    notifyDateEditError.textContent = "This field is required";
                    var notifyDateEditErrorImg = document.createElement('IMG');
                    notifyDateEditErrorImg.src = "/SPActivityHub-portlet/images/act-error.svg";
                    notifyDateEditError.appendChild(notifyDateEditErrorImg);
                    notifyDateEdit.innerHTML = data.logActivities[i - 1].logActivityDate;
                    notifyDateEdit.defaultValue = data.logActivities[i - 1].logActivityDate;
                    notifyDateEditSpan.appendChild(notifyDateEdit);
                    notifyDateEditSpan.appendChild(notifyDateEditError);
                    notifyActivityEditWrap.appendChild(notifyDateEditSpan);



                    //TIME
                    var notifyTimeEditSpan = document.createElement('SPAN');
                    notifyTimeEditSpan.setAttribute('class', 'lfr-input-timeAct');
                    notifyTimeEditSpan.setAttribute('id', 'notifyTimeEditSpan_' + (+counter));
                    var notifyTimeEdit = document.createElement('INPUT');
                    notifyTimeEdit.setAttribute('type', 'text');
                    notifyTimeEdit.setAttribute('placeholder', 'Time');
                    notifyTimeEdit.disabled = true;
                    notifyTimeEdit.setAttribute('class', 'timeSlct Requiredfield');
                    notifyTimeEdit.setAttribute('id', 'notifyTimeEdit_' + (+counter));
                    var notifyTimeEditError = document.createElement('SPAN');
                    notifyTimeEditError.setAttribute('class', 'actErrorNotif');
                    notifyTimeEditError.textContent = "This field is required";
                    var notifyTimeEditErrorImg = document.createElement('IMG');
                    notifyTimeEditErrorImg.src = "/SPActivityHub-portlet/images/act-error.svg";
                    notifyTimeEditError.appendChild(notifyTimeEditErrorImg);
                    notifyTimeEdit.innerHTML = data.logActivities[i - 1].logActivityTime;
                    notifyTimeEdit.defaultValue = data.logActivities[i - 1].logActivityTime;
                    notifyTimeEditSpan.appendChild(notifyTimeEdit);
                    notifyTimeEditSpan.appendChild(notifyTimeEditError);
                    notifyActivityEditWrap.appendChild(notifyTimeEditSpan);
                    logContentWrap.appendChild(notifyActivityEditWrap);
                    //instance.timePickerLogActivity('notifyTimeEditSpan_' + (+counter), 'notifyTimeEdit_' + (+counter));
                }

                //Message Title
                if (!data.logActivities[i - 1].classNameResult.includes('Conversation')) {
                    var notifyTitleWrap = document.createElement('DIV');
                    notifyTitleWrap.setAttribute('class', 'notifyTitleWrap');
                    var notifyTitle = document.createElement('H2');
                    notifyTitle.setAttribute('class', 'contentEditError notifyTitle Requiredfield');
                    notifyTitle.setAttribute('id', 'notifyTitleIdLog_' + (+counter));
                    notifyTitle.innerHTML = data.logActivities[i - 1].logActivityTitle;
                    notifyTitle.defaultValue = data.logActivities[i - 1].logActivityTitle;
                    var notifyTitleError = document.createElement('SPAN');
                    notifyTitleError.setAttribute('class', 'actErrorNotif');
                    notifyTitleError.textContent = "This field is required";
                    var notifyTitleErrorImg = document.createElement('IMG');
                    notifyTitleErrorImg.src = "/SPActivityHub-portlet/images/act-error.svg";
                    notifyTitleError.appendChild(notifyTitleErrorImg);
                    notifyTitleWrap.appendChild(notifyTitle);
                    notifyTitleWrap.appendChild(notifyTitleError);
                    logContentWrap.appendChild(notifyTitleWrap);
                }


                //-Notification Message Content
                var notifyMessageWrap = document.createElement('DIV');
                notifyMessageWrap.setAttribute('class', 'notifyMessageWrap');
                var notifyMessage = document.createElement('P');
                notifyMessage.setAttribute('class', 'contentEditError notifyMessage Requiredfield');
                notifyMessage.setAttribute('id', 'notifyMessageLog_' + (+counter));
                notifyMessage.innerHTML = data.logActivities[i - 1].logActivityContent;
                notifyMessage.defaultValue = data.logActivities[i - 1].logActivityContent;
                var notifyError = document.createElement('SPAN');
                notifyError.setAttribute('class', 'actErrorNotif');
                notifyError.textContent = "This field is required";
                var notifyErrorImg = document.createElement('IMG');
                notifyErrorImg.src = "/SPActivityHub-portlet/images/act-error.svg";
                notifyError.appendChild(notifyErrorImg);



                var fileUploadEditNote = document.createElement('P');
                fileUploadEditNote.setAttribute('class', 'file-return');
                fileUploadEditNote.setAttribute('id', 'fileUploadEditLogActivity' + (+counter));

                //Append Notes ICON,TimeWrap,Title, Message 
                //logContentWrap.appendChild(notifIcon);
                //logContentWrap.appendChild(notifTimeweap);
                //notifyActivityEditWrap.appendChild(notifyActivityEdit);
                //notifyActivityEditWrap.appendChild(notifyDateEdit);
                //notifyActivityEditWrap.appendChild(notifyTimeEdit);
                //logContentWrap.appendChild(notifyActivityEditWrap);
                //logContentWrap.appendChild(notifyTitle);
                notifyMessageWrap.appendChild(notifyMessage);
                notifyMessageWrap.appendChild(notifyError);
                logContentWrap.appendChild(notifyMessageWrap);
                logContentWrap.appendChild(fileUploadEditNote);
                logContainer.appendChild(logContentWrap);
                divLogsinnerWrap.appendChild(logContainer);



                //-USER & SECTION Section
                var logEditWrap = document.createElement('DIV');
                logEditWrap.setAttribute('class', 'convEditWrapper_notes');

                // EDIT TEXTFORMAT &ACTIVE LINK & FILEUPLOAD
                var logTextFormat = document.createElement('DIV');
                logTextFormat.setAttribute('class', 'ceTextFormatWrap');

                var LogsEditAct = document.createElement('DIV');
                LogsEditAct.setAttribute('class', 'nEditactionsIcons');

                //LINK
                var linkEdAddnote = document.createElement('A');
                linkEdAddnote.setAttribute('class', 'actBtns');
                linkEdAddnote.setAttribute('id', 'linkLogBtns' + (+counter));
                linkEdAddnote.setAttribute('onclick', 'focusLinkLogActionDiv(this)');
                var imgEdAddnote = document.createElement('IMG');
                imgEdAddnote.src = '/SPActivityHub-portlet/images/inactive.svg';
                linkEdAddnote.appendChild(imgEdAddnote);
                LogsEditAct.appendChild(linkEdAddnote);




                //TEXT FORMAT
                var txtFmtEdAddnote = document.createElement('A');
                txtFmtEdAddnote.setAttribute('class', 'actBtns');
                txtFmtEdAddnote.setAttribute('id', 'txtFmtadnBtns' + (+counter));
                txtFmtEdAddnote.setAttribute('onclick', 'focusTxtFormatLogActionDiv(this)');
                var imgtextAddnote = document.createElement('IMG');
                imgtextAddnote.src = '/SPActivityHub-portlet/images/ac-icon-a.svg';
                txtFmtEdAddnote.appendChild(imgtextAddnote);
                LogsEditAct.appendChild(txtFmtEdAddnote);

                //UPLOAD NOTE ATTACHMENT
                var uploadEdAddnote = document.createElement('A');
                uploadEdAddnote.setAttribute('class', 'actBtns');
                uploadEdAddnote.setAttribute('id', 'uplEdadnBtns' + (+counter));
                uploadEdAddnote.setAttribute('onclick', 'focusUploadLogActionDiv(this)');
                var imguploadIconnote = document.createElement('IMG');
                imguploadIconnote.src = '/SPActivityHub-portlet/images/attachment.svg';
                uploadEdAddnote.appendChild(imguploadIconnote);
                LogsEditAct.appendChild(uploadEdAddnote);



                var logLinkeditContent = document.createElement('DIV');
                logLinkeditContent.setAttribute('class', 'linkTools');
                logLinkeditContent.setAttribute('id', 'editLogLink' + (+counter));

                var linkSpan = document.createElement('SPAN');
                linkSpan.setAttribute('class', 'closePopEditaction');
                linkSpan.setAttribute('id', 'closeLogEditPop_' + (+counter));

                linkSpan.addEventListener('click', function(closeEdit) {
                    this.parentElement.classList.remove("activeAction");
                })

                var linkSpanImg = document.createElement('IMG');
                linkSpanImg.src = '/SPActivityHub-portlet/images/cancelactivity.svg';
                linkSpan.appendChild(linkSpanImg);
                var linkH2 = document.createElement('H2');
                linkH2.innerHTML = 'ADD LINK';
                var linkInputTxt = document.createElement("INPUT");
                linkInputTxt.setAttribute('type', 'text');
                linkInputTxt.setAttribute('class', 'inputlinkacted');
                linkInputTxt.setAttribute('id', 'cLinkLogTxt_' + (+counter));
                linkInputTxt.setAttribute('placeholder', 'Add Text');
                var linkInputUrl = document.createElement("INPUT");
                linkInputUrl.setAttribute('type', 'text');
                linkInputUrl.setAttribute('id', 'cLinkLogUrl_' + (+counter));
                linkInputUrl.setAttribute('placeholder', 'Add Url');

                //ADD AND DELETE Button

                var editActWrap = document.createElement('DIV');
                editActWrap.setAttribute('class', 'linkActions');
                var addapplyWrapA = document.createElement('A');
                addapplyWrapA.innerHTML = 'Apply';
                addapplyWrapA.setAttribute('class', 'linkAnchor');
                addapplyWrapA.setAttribute('id', 'applyLogBtn_' + (+counter));
                addapplyWrapA.setAttribute('counter-id', counter);
                var addCancelWrapA = document.createElement('A');
                addCancelWrapA.innerHTML = 'Cancel';
                addCancelWrapA.setAttribute('class', 'linkAnchor');
                addCancelWrapA.setAttribute('id', 'cancelLogBtn_' + (+counter));
                addCancelWrapA.setAttribute('counter-id', counter);
                editActWrap.appendChild(addapplyWrapA);
                editActWrap.appendChild(addCancelWrapA);



                addapplyWrapA.addEventListener('click', function() {


                    this.parentNode.parentNode.classList.remove('activeAction');
                    var counterId = this.getAttribute('counter-id');
                    var applyContarea = document.getElementById('notifyMessageLog_' + (+counterId));
                    if (applyContarea != null) {
                        var applyContareaText = applyContarea.innerHTML;
                        var applyContareaTextLength = applyContareaText.trim().length;
                        var startPosition = applyContarea.selectionStart;
                        var endPosition = applyContarea.selectionEnd;

                        var linkText = document.getElementById('cLinkLogTxt_' + (+counterId)).value;
                        var linkUrl = document.getElementById('cLinkLogUrl_' + (+counterId)).value;
                        if (startPosition == endPosition) {
                            applyContarea.innerHTML += '<a href="' + linkUrl + '" target="_blank">' + linkText + '</a>';

                        }



                        document.getElementById('cLinkLogTxt_' + (+counterId)).value = "";
                        document.getElementById('cLinkLogUrl_' + (+counterId)).value = "";

                        return false;
                    }

                });
                addCancelWrapA.addEventListener('click', function() {

                    this.parentNode.parentNode.classList.remove('activeAction');
                    var counterId = this.getAttribute('counter-id');
                    var linkTextEmpty = document.getElementById('cLinkLogTxt_' + (+counterId));
                    var linkUrlEmpty = document.getElementById('cLinkLogUrl_' + (+counterId));
                    linkTextEmpty.value = "";
                    linkUrlEmpty.value = "";

                    return false;

                });



                logLinkeditContent.appendChild(linkSpan); //Span
                logLinkeditContent.appendChild(linkH2); //h2
                logLinkeditContent.appendChild(linkInputTxt); //InputAddText
                logLinkeditContent.appendChild(linkInputUrl); //InputAddUrl
                logLinkeditContent.appendChild(editActWrap); //action wrap



                var logtextEditContent = document.createElement('DIV');
                logtextEditContent.setAttribute('class', 'txtFormatTools');
                logtextEditContent.setAttribute('id', 'txtLogFmtLink' + (+counter));

                var txtFmtSpan = document.createElement('SPAN');
                txtFmtSpan.setAttribute('class', 'closePopEditaction');
                txtFmtSpan.setAttribute('id', 'closeLogFmtPop_' + (+counter));
                var txtFmtSpanImg = document.createElement('IMG');
                txtFmtSpanImg.src = '/SPActivityHub-portlet/images/cancelactivity.svg';
                txtFmtSpan.appendChild(txtFmtSpanImg);

                var formatterWrap = document.createElement('DIV');
                formatterWrap.setAttribute('class', 'formatter');


                var fmtBold = document.createElement('BUTTON');
                fmtBold.setAttribute('class', 'btnAc btn-default');
                fmtBold.setAttribute('onclick', 'document.execCommand (' + "'" + 'bold' + "'" + ',' + false + ',' + null + ')');
                var fmtBoldImg = document.createElement('IMG');
                fmtBoldImg.src = '/SPActivityHub-portlet/images/textFormat-icons/bold.svg';
                fmtBold.appendChild(fmtBoldImg);

                var fmtItalic = document.createElement('BUTTON');
                fmtItalic.setAttribute('class', 'btnAc btn-default');
                fmtItalic.setAttribute('onclick', 'document.execCommand (' + "'" + 'italic' + "'" + ',' + false + ',' + null + ')');
                var fmtItalicImg = document.createElement('IMG');
                fmtItalicImg.src = '/SPActivityHub-portlet/images/textFormat-icons/italic.svg';
                fmtItalic.appendChild(fmtItalicImg);

                var fmtUnderLine = document.createElement('BUTTON');
                fmtUnderLine.setAttribute('class', 'btnAc btn-default');
                fmtUnderLine.setAttribute('onclick', 'document.execCommand (' + "'" + 'underline' + "'" + ',' + false + ',' + null + ')');
                var fmtUnderLineImg = document.createElement('IMG');
                fmtUnderLineImg.src = '/SPActivityHub-portlet/images/textFormat-icons/underline.svg';
                fmtUnderLine.appendChild(fmtUnderLineImg);

                var fmtStrike = document.createElement('BUTTON');
                fmtStrike.setAttribute('class', 'btnAc btn-default');
                fmtStrike.setAttribute('onclick', 'document.execCommand (' + "'" + 'strikeThrough' + "'" + ',' + false + ',' + null + ')');
                var fmtStrikeImg = document.createElement('IMG');
                fmtStrikeImg.src = '/SPActivityHub-portlet/images/textFormat-icons/strikethrough.svg';
                fmtStrike.appendChild(fmtStrikeImg);

                var fmtUl = document.createElement('BUTTON');
                fmtUl.setAttribute('class', 'btnAc btn-default');
                fmtUl.setAttribute('onclick', 'document.execCommand (' + "'" + 'insertUnorderedList' + "'" + ',' + false + ',' + null + ')');
                var fmtUlImg = document.createElement('IMG');
                fmtUlImg.src = '/SPActivityHub-portlet/images/textFormat-icons/ul-list.svg';
                fmtUl.appendChild(fmtUlImg);

                var fmtOl = document.createElement('BUTTON');
                fmtOl.setAttribute('class', 'btnAc btn-default');
                fmtOl.setAttribute('onclick', 'document.execCommand (' + "'" + 'insertOrderedList' + "'" + ',' + false + ',' + null + ')');
                var fmtOlImg = document.createElement('IMG');
                fmtOlImg.src = '/SPActivityHub-portlet/images/textFormat-icons/ol-list.svg';
                fmtOl.appendChild(fmtOlImg);


                formatterWrap.appendChild(fmtBold);
                formatterWrap.appendChild(fmtItalic);
                formatterWrap.appendChild(fmtUnderLine);
                formatterWrap.appendChild(fmtStrike);
                formatterWrap.appendChild(fmtUl);
                formatterWrap.appendChild(fmtOl);
                logtextEditContent.appendChild(formatterWrap);
                logtextEditContent.appendChild(txtFmtSpan);

                txtFmtSpan.addEventListener('click', function(closetxtFmt) {
                    this.parentElement.classList.remove("activeAction");
                })

                //ATTACHMENT 
                var logAtcEditContent = document.createElement('DIV');
                logAtcEditContent.setAttribute('class', 'convAttchment');
                logAtcEditContent.setAttribute('id', 'noteAtcEdit' + (+counter));

                var logAtcSpan = document.createElement('SPAN');
                logAtcSpan.setAttribute('class', 'closePopEditaction');
                logAtcSpan.setAttribute('id', 'closeLogFmtPop_' + (+counter));
                var logAtcSpanImg = document.createElement('IMG');
                logAtcSpanImg.src = '/SPActivityHub-portlet/images/cancelactivity.svg';
                logAtcSpan.appendChild(logAtcSpanImg);
                logAtcEditContent.appendChild(logAtcSpan);

                logAtcSpan.addEventListener('click', function(closeupload) {
                    this.parentElement.classList.remove("activeAction");
                })

                var logAtcDiv = document.createElement('DIV');
                logAtcDiv.setAttribute('class', 'input-file-container');
                var logAtcInput = document.createElement('INPUT');
                logAtcInput.setAttribute('type', 'hidden');
                logAtcInput.setAttribute('id', 'input-fileAtn1' + (+counter));
                logAtcInput.setAttribute('value', '0');
                var logAtcInputFile = document.createElement('INPUT');
                logAtcInputFile.setAttribute('type', 'file');
                logAtcInputFile.setAttribute('id', 'input-fileAtn2' + (+counter));
                logAtcInputFile.setAttribute('class', 'input-file');
                logAtcInputFile.setAttribute('counter-id', counter);
                logAtcInputFile.setAttribute('multiple', true);
                
                logAtcInputFile.addEventListener('change', function(a) {
                    instance.GetFileSizeNameAndTypeLogActivityUpdate(a.target);
                     this.parentElement.parentElement.classList.remove("activeAction");
                });
                var logAtcInputLabel = document.createElement('LABEL');
                logAtcInputLabel.setAttribute('tabindex', '0' + (+counter));
                logAtcInputLabel.setAttribute('for', 'input-fileAtn2' + (+counter));
                logAtcInputLabel.setAttribute('class', 'input-file-trigger');
                logAtcInputLabel.innerHTML = 'Upload from computer';

                logAtcDiv.appendChild(logAtcInput);
                logAtcDiv.appendChild(logAtcInputFile);
                logAtcDiv.appendChild(logAtcInputLabel);
                logAtcEditContent.appendChild(logAtcDiv);




                //TEXT FORMAT
                logTextFormat.appendChild(LogsEditAct);
                logTextFormat.appendChild(logLinkeditContent);
                logTextFormat.appendChild(logtextEditContent);
                logTextFormat.appendChild(logAtcEditContent);







                // EDIT ACTION UPDATE & ASSOCIATE & CANCEL
                var logActionWrap = document.createElement('DIV');
                logActionWrap.setAttribute('class', 'ceActionIcon');

                if (instance.associatedWith != null && instance.associatedWith != "0") {
                    //Associate User Check
                    var logAssocWrap = document.createElement('DIV');
                    logAssocWrap.setAttribute('class', 'notesAccociate');
                    var logAssocP = document.createElement('P');
                    logAssocP.innerHTML = "Associated<br> with";
                    var logAssocIconImg = document.createElement('IMG');
                    logAssocIconImg.src = "/SPActivityHub-portlet/images/user.png";

                    logAssocWrap.appendChild(logAssocP);
                    logAssocWrap.appendChild(logAssocIconImg);
                    logActionWrap.appendChild(logAssocWrap);
                }



                //UPDATE BUTTON CREATION
                var logUpdateIcon = document.createElement('DIV');
                logUpdateIcon.setAttribute('class', 'updateButtonWrap');
                var logUpdateIconButton = document.createElement('A');
                logUpdateIconButton.textContent = "UPDATE";
                logUpdateIconButton.setAttribute('href', '#');
                logUpdateIconButton.setAttribute('classNameToUpdate', data.logActivities[i - 1].classNameResult);
                logUpdateIconButton.setAttribute('class', 'updateNotesButton');
                logUpdateIconButton.setAttribute('id', data.logActivities[i - 1].logActivityId);
                logUpdateIconButton.setAttribute('counter-id', counter);
                logUpdateIcon.appendChild(logUpdateIconButton);
                logActionWrap.appendChild(logUpdateIcon);

                logUpdateIconButton.addEventListener('click', function(a) {
                    var current = a.target;
                    instance.updateLogActivity(current);

                });



                //CANCEL BUTTON CREATION
                var logCancelIcon = document.createElement('DIV');
                logCancelIcon.setAttribute('id', 'cancelLogid_' + (+counter));
                logCancelIcon.setAttribute('class', 'cancelButtonWrap');
                logCancelIcon.setAttribute('counter-id', counter);
                var logCancelIconButton = document.createElement('A');
                logCancelIconButton.textContent = "CANCEL";
                logCancelIconButton.setAttribute('href', 'javascript:void(0)');
                logCancelIconButton.setAttribute('class', 'cancelNotesButton');
                logCancelIconButton.setAttribute('counter-id', counter);

                logCancelIcon.appendChild(logCancelIconButton);
                logActionWrap.appendChild(logCancelIcon);

                logCancelIcon.addEventListener('click', function(a) {
                    var current = a.target;
                    var currentCounterId = current.getAttribute('counter-id');
                    var cancelLogEdit = document.getElementById('logContainerid_' + (+currentCounterId));
                    cancelLogEdit.classList.remove('editDetail');
                    document.getElementById('notifyMessageLog_' + (+currentCounterId)).innerHTML = document.getElementById('notifyMessageLog_' + (+currentCounterId)).defaultValue;
                    if (document.getElementById('notifyTitleIdLog_' + (+currentCounterId))) {
                        document.getElementById('notifyTitleIdLog_' + (+currentCounterId)).innerHTML = document.getElementById('notifyTitleIdLog_' + (+currentCounterId)).defaultValue;
                    }
                    if (document.getElementById('notifyTimeEdit_' + (+currentCounterId))) {
                        document.getElementById('notifyTimeEdit_' + (+currentCounterId)).value = document.getElementById('notifyTimeEdit_' + (+currentCounterId)).defaultValue;
                    }
                    if (document.getElementById('notifyDateEdit_' + (+currentCounterId))) {
                        document.getElementById('notifyDateEdit_' + (+currentCounterId)).value = document.getElementById('notifyDateEdit_' + (+currentCounterId)).defaultValue;
                    }
                    var options = document.querySelectorAll('#selectActivity_' + (+currentCounterId) + ' option');
                    for (var i = 0, l = options.length; i < l; i++) {
                        options[i].selected = options[i].defaultSelected;
                    }
                    if (document.getElementById('notifyDateEdit_' + (+currentCounterId))) {
                        document.getElementById('notifyDateEdit_' + (+currentCounterId)).disabled = true;
                    }
                    if (document.getElementById('notifyTimeEdit_' + (+currentCounterId))) {
                        document.getElementById('notifyTimeEdit_' + (+currentCounterId)).disabled = true;
                    }
                    document.getElementById('fileUploadEditLogActivity' + (+currentCounterId)).innerHTML = "";

                    for (var i = 0; i < cancelLogEdit.children[0].children.length; i++){
                    	cancelLogEdit.children[0].children[i].classList.remove("ErrorValidation");
                    }
                    
                    for (var i = 0; i < cancelLogEdit.children[0].children[3].children.length; i++){
                    	cancelLogEdit.children[0].children[3].children[i].classList.remove("ErrorValidation");
                    }

                });

                //APPEND ACTION & EDIT WRAP

                logEditWrap.appendChild(logTextFormat);
                logEditWrap.appendChild(logActionWrap);
                logContentWrap.appendChild(logEditWrap);


                //VIEW, EDIT & DELETE ACTIONS
                var logActionDiv = document.createElement('DIV');
                logActionDiv.setAttribute('class', 'noteListAction');
                //NOTES VIEW
                var logViewIcon = document.createElement('DIV');
                logViewIcon.setAttribute('class', 'actViewIcon');
                logViewIcon.setAttribute('counter-id', counter);
                var logViewIconImg = document.createElement('IMG');
                logViewIconImg.src = "/SPActivityHub-portlet/images/view-edit.svg";
                logViewIconImg.setAttribute('counter-id', counter);
                logViewIcon.appendChild(logViewIconImg);
                logActionDiv.appendChild(logViewIcon);
                logViewIcon.setAttribute('id', 'view_Notes' + (+counter));


                logViewIcon.addEventListener('click', function(a) {
                    var current = a.target;
                    var currentCounterId = current.getAttribute('counter-id');
                    var elemsView = document.querySelector(".viewShow");
                    if (elemsView != null) {

                        elemsView.classList.remove('viewShow');
                        elemsView.parentNode.parentNode.childNodes[0].classList.remove('editDetailact');
                    }
                    this.classList.add('viewShow');
                    this.parentNode.parentNode.childNodes[0].classList.add('editDetailact');

                    if (document.getElementById('selectActivity_' + (+currentCounterId))) {
                        document.getElementById('selectActivity_' + (+currentCounterId)).disabled = true;
                    }
                    if (document.getElementById('notifyDateEdit_' + (+currentCounterId))) {
                        document.getElementById('notifyDateEdit_' + (+currentCounterId)).disabled = true;
                    }
                    if (document.getElementById('notifyTimeEdit_' + (+currentCounterId))) {
                        document.getElementById('notifyTimeEdit_' + (+currentCounterId)).disabled = true;
                    }

                })

                //NOTES EDIT
                if (!data.logActivities[i - 1].classNameResult.includes('Conversation')) {
                    var logEditIcon = document.createElement('DIV');
                    logEditIcon.setAttribute('class', 'acteditIcon');
                    logEditIcon.setAttribute('counter-id', counter);
                    var logEditIconImg = document.createElement('IMG');
                    logEditIconImg.src = "/SPActivityHub-portlet/images/edit-icon.svg";
                    logEditIconImg.setAttribute('counter-id', counter);
                    logEditIcon.appendChild(logEditIconImg);
                    logActionDiv.appendChild(logEditIcon);


                    logEditIcon.setAttribute('id', 'edit_Notes' + (+counter));

                    logEditIcon.addEventListener('click', function(a) {

                        var current = a.target;
                        var currentCounterId = current.getAttribute('counter-id');
                        var elemsLogs = document.querySelector(".editShow");
                        if (elemsLogs != null) {

                            elemsLogs.classList.remove('editShow');
                            elemsLogs.parentNode.parentNode.classList.remove('editDetail');
                        }
                        this.classList.add('editShow');
                        this.parentNode.parentNode.classList.add('editDetail');
                        document.getElementById('notifyMessageLog_' + (+currentCounterId)).setAttribute('contenteditable', 'true');
                        if (document.getElementById('notifyTitleIdLog_' + (+currentCounterId))) {
                            document.getElementById('notifyTitleIdLog_' + (+currentCounterId)).setAttribute('contenteditable', 'true');
                        }
                        if (document.getElementById('selectActivity_' + (+currentCounterId))) {
                            document.getElementById('selectActivity_' + (+currentCounterId)).disabled = false;
                        }
                        if (document.getElementById('notifyDateEdit_' + (+currentCounterId))) {
                            document.getElementById('notifyDateEdit_' + (+currentCounterId)).disabled = false;
                        }
                        if (document.getElementById('notifyTimeEdit_' + (+currentCounterId))) {
                            document.getElementById('notifyTimeEdit_' + (+currentCounterId)).disabled = false;
                        }


                    });


                    //NOTES DELETE
                    var logDeleteIcon = document.createElement('DIV');
                    logDeleteIcon.setAttribute('class', 'actdeleteIcon');
                    var logDeleteIconButton = document.createElement('A');
                    logDeleteIconButton.setAttribute('href', '#deleteLogContent' + (+counter));
                    logDeleteIconButton.setAttribute('class', 'deleteAct');
                    var logDeleteIconImg = document.createElement('IMG');
                    logDeleteIconImg.src = "/SPActivityHub-portlet/images/delete-icon.svg";
                    logDeleteIconButton.appendChild(logDeleteIconImg);
                    logDeleteIcon.appendChild(logDeleteIconButton);
                    logActionDiv.appendChild(logDeleteIcon);
                }

                logContainer.appendChild(logActionDiv);


                // DELETE FUNCTION
                //deleteFunction


                var deletePopop = document.createElement('DIV');
                deletePopop.setAttribute('class', 'comwOverlay');
                deletePopop.setAttribute('id', 'deleteLogContent' + (+counter));
                var deletePopopinner = document.createElement('DIV');
                deletePopopinner.setAttribute('class', 'comwPopup');
                var deleteContentArea = document.createElement('DIV');
                deleteContentArea.setAttribute('class', 'comwContent');


                var noteinfoIconImg = document.createElement('IMG');
                noteinfoIconImg.setAttribute('class', 'infoIcon');
                noteinfoIconImg.src = "/SPActivityHub-portlet/images/infoIcon.svg";
                var deleteContentTitle = document.createElement('H2');
                deleteContentTitle.textContent = 'Are you sure you want to delete this activity?';
                var deleteMessage = document.createElement('p');
                deleteMessage.textContent = "This action cannot be undone";



                var dcActionwrap = document.createElement('DIV');
                dcActionwrap.setAttribute('class', 'popDeleteWrap');
                var deleteact = document.createElement('A');
                deleteact.textContent = "DELETE ACTIVITY";
                deleteact.setAttribute('class', 'deleteActButton');
                deleteact.setAttribute('href', 'javascript:;');
                deleteact.setAttribute('id', data.logActivities[i - 1].logActivityId);
                deleteact.setAttribute('classNameToUpdate', data.logActivities[i - 1].classNameResult);


                var keepact = document.createElement('A');
                keepact.textContent = "KEEP ACTIVITY";
                keepact.setAttribute('class', 'keepAnchor');
                keepact.setAttribute('href', '#');
                dcActionwrap.appendChild(deleteact);
                dcActionwrap.appendChild(keepact);

                deleteContentArea.appendChild(noteinfoIconImg);
                deleteContentArea.appendChild(deleteContentTitle);
                deleteContentArea.appendChild(deleteMessage);
                deleteContentArea.appendChild(dcActionwrap);
                deletePopopinner.appendChild(deleteContentArea);

                deleteact.addEventListener('click', function(a) {
                    var current = a.target;
                    instance.deleteLogActivity(current);

                });

                deletePopop.appendChild(deletePopopinner);
                logContainer.appendChild(deletePopop);




                //attachment section - start
                if (data.logActivities[i - 1].numberOfAttachments > 0) {



                    var fileUploadDiv = document.createElement('DIV');
                    fileUploadDiv.setAttribute('class', 'file-save');
                    for (var k = 0; k < data.logActivities[i - 1].attachments.length; k++) {
                        var attachmentDetail = data.logActivities[i - 1].attachments[k];

                        var fileName = attachmentDetail.fileName;
                        var fileSize = attachmentDetail.fileSize;
                        var downloadUrl = attachmentDetail.downloadUrl;

                        var filesaveDiv = document.createElement('DIV');
                        filesaveDiv.setAttribute('class', 'Filenamedetailsave');

                        var fileNameP = document.createElement('A');
                        fileNameP.setAttribute('target', '_blank');
                        fileNameP.href = downloadUrl;
                        var fileNameSize = document.createElement('P');
                        fileNameSize.innerHTML = fileSize;

                        fileNameP.innerHTML = fileName;
                        filesaveDiv.appendChild(fileNameP);
                        filesaveDiv.appendChild(fileNameSize);
                        fileUploadDiv.appendChild(filesaveDiv);


                    }
                    logContentWrap.appendChild(fileUploadDiv);


                }
                //attachment section - end

            }





        }

        //**REPEAT SECTION END***
        
        //validate content area onchange
        var contentValidateArea = document.getElementsByClassName("contentEditError");
        for (var i = 0; i < contentValidateArea.length; i++) {
            contentValidateArea[i].addEventListener("input", function() {
                validateContentArea(this);
            }, false);
        }
        
        var count = 1;
        A.all('.lfr-input-dateAct').each(function(node) {
            node._node.children[0].setAttribute("dpId", 'dp' + (+count));
            instance.datePickerLogActivity(node._node.id, node._node.children[0].id, 'dp' + (+count));
            count += 1;
        });

        var count = 1;
        A.all('.lfr-input-timeAct').each(function(node) {
            node._node.children[0].setAttribute("tpId", 'tp' + (+count));
            instance.timePickerLogActivity(node._node.id, node._node.children[0].id, 'tp' + (+count));
            count += 1;
        });

    }



    this.deleteLogActivity = function(logActivity) {
        var obj = {};
        obj.action = "deleteLogActivity";
        obj.logActivityId = logActivity.id;
        obj.classNameToUpdate = logActivity.getAttribute('classNameToUpdate');
        A.io.request(instance.ajaxUrl, {
            dataType: 'json',
            method: 'POST',
            sync: true,
            data: obj,
            on: {
                success: function() {
                    var data = this.get("responseData");
                    if (data) {
                        if (data.error) {
                            alert(data.error);
                        } else {
                            instance.loadLogActivity();
                        }
                    }

                },
                failure: function() {
                    alert('Error while saving message');
                }
            }
        });
    }

    //Content Edit
    this.GetFileSizeNameAndTypeLogActivity = function() {
        var fiLogs = document.getElementById('logActivityFile'); // GET THE FILE INPUT AS VARIABLE.

        var totalFileSize = 0;

        // VALIDATE OR CHECK IF ANY FILE IS SELECTED.
        if (fiLogs.files.length > 0) {
            // RUN A LOOP TO CHECK EACH SELECTED FILE.
            for (var i = 0; i <= fiLogs.files.length - 1; i++) {
                //ACCESS THE SIZE PROPERTY OF THE ITEM OBJECT IN FILES COLLECTION. IN THIS WAY ALSO GET OTHER PROPERTIES LIKE FILENAME AND FILETYPE
                var fsize = fiLogs.files.item(i).size;
                totalFileSize = totalFileSize + fsize;
                document.getElementById('fileUploadLogActivity').innerHTML =
                    document.getElementById('fileUploadLogActivity').innerHTML +
                    '<div class="Filenamedetail"> ' + '<p>' + fiLogs.files.item(i).name + '</p>' + Math.round(totalFileSize / 1024) + '&nbsp;' + 'KB' + '<p class="fileProgressLogAdd" >' + '</p>' + '</div>'
                var uploader = new fileUploadActivityHub();
                uploader.init(instance.ajaxUrlFileUpload, instance.pns, 'logActivityFile', 'uploadsFileEntryIdLogActivity', '', 'fileProgressLogAdd');

            }
        }

    }

    this.GetFileSizeNameAndTypeLogActivityUpdate = function(elem) {
        var fiLogs = document.getElementById(elem.id); // GET THE FILE INPUT AS VARIABLE.
        var counterId = elem.getAttribute('counter-id');
        var totalFileSize = 0;

        // VALIDATE OR CHECK IF ANY FILE IS SELECTED.
        if (fiLogs.files.length > 0) {
            // RUN A LOOP TO CHECK EACH SELECTED FILE.
            for (var i = 0; i <= fiLogs.files.length - 1; i++) {
                //ACCESS THE SIZE PROPERTY OF THE ITEM OBJECT IN FILES COLLECTION. IN THIS WAY ALSO GET OTHER PROPERTIES LIKE FILENAME AND FILETYPE
                var fsize = fiLogs.files.item(i).size;
                totalFileSize = totalFileSize + fsize;
                document.getElementById('fileUploadEditLogActivity' + (+counterId)).innerHTML =
                    document.getElementById('fileUploadEditLogActivity' + (+counterId)).innerHTML +
                    '<div class="Filenamedetail"> ' + '<p>' + fiLogs.files.item(i).name + '</p>' + Math.round(totalFileSize / 1024) + '&nbsp;' + 'KB' + '<p class="fileProgressLogEdit" >' + '</p>' + '</div>'
                var uploader = new fileUploadActivityHub();
                uploader.init(instance.ajaxUrlFileUpload, instance.pns, elem.id, 'input-fileAtn1' + (+counterId), '', 'fileProgressLogEdit');

            }
        }

    }


    //anchor link add



    var applyLogBtnLog = document.getElementById("applyLogBtn");

    applyLogBtnLog.onclick = function() {
        var applyContarea = document.getElementById('logTxtArea');
        if (applyContarea != null) {
            var applyContareaText = applyContarea.innerHTML;
            var applyContareaTextLength = applyContareaText.trim().length;
            var startPosition = applyContarea.selectionStart;
            var endPosition = applyContarea.selectionEnd;


            var linkText = document.getElementById("lLinkTxt").value;
            var linkUrl = document.getElementById("lLinkUrl").value;
            if (startPosition == endPosition) {
                applyContarea.innerHTML += '<a href="' + linkUrl + '" target="_blank">' + linkText + '</a>';

            }

            var closeLinkWrap = document.getElementById('logAnchorLink');
            closeLinkWrap.classList.remove('activeAction');

            document.getElementById("lLinkTxt").value = "";
            document.getElementById("lLinkUrl").value = "";

            return false;
        }

    };
    var cancelLogClear = document.getElementById("applyLogAnchor");
    cancelLogClear.onclick = function() {


        var linkTextEmpty = document.getElementById("lLinkTxt");
        var linkUrlEmpty = document.getElementById("lLinkUrl");
        linkTextEmpty.value = "";
        linkUrlEmpty.value = "";
        var closeLinkWrapTXT = document.getElementById('logAnchorLink');
        closeLinkWrapTXT.classList.remove('activeAction');

        return false;

    };



    this.datePickerLogActivity = function(containerId, triggerId, idDp) {
        var today = new Date();
        var psInstance = instance;
        var datePickerLogActivity = new A.DatePicker({
            container: '#' + containerId,
            mask: '%d/%m/%Y',
            popover: {
                zIndex: '12000',
                id: idDp
            },
            calendar: {
                maximumDate: new Date(today.getFullYear(), today.getMonth(), today.getDate())
            },
            after: {
                selectionChange: function(event) {
                	validate(A.one("#" +triggerId).getDOMNode());
                }
            },
            trigger: '#' + triggerId
        });
//        var calendarLogActivity = datePickerLogActivity.getCalendar();
//        calendarLogActivity.after('dateClick', validateReqField("tab-logActivity",""), datePickerLogActivity);
        instance[triggerId + "DpLogActivity"] = datePickerLogActivity;
    }




    this.timePickerLogActivity = function(containerId, triggerId, idTp) {
        var psInstance = instance;
        var timePicker = new A.TimePicker({
            id: 'timePickerId',
            container: '#' + containerId,
            mask: '%H:%M',
            popover: {
                zIndex: '12000',
                id: idTp
            },
            after: {
                selectionChange: function(event) {
                	validate(A.one("#" +triggerId).getDOMNode());
                }
            },
            trigger: '#' + triggerId
        });
        // instance[triggerId + "Dp"] = psInstance;




    }


    window.onload = function() {
        var leftAttrTp = "0px";
        var topAttrTp = "0px";
        var leftAttrDp = "0px";
        var topAttrDp = "0px";
        var tpId;
        var dpId;
        document.onclick = function(e) {
            if (e.target.classList.contains("timeSlct")) {
                tpId = e.target.getAttribute("tpId");
                var parentId = e.target.parentElement.id;
                document.getElementById(parentId).insertBefore(document.getElementById(tpId), document.getElementById(parentId).childNodes[0]);
                if (document.getElementById(tpId).style.display == 'none') {
                    document.getElementById(tpId).style.display = 'block';
                    if (leftAttrTp != "0px") {
                        document.getElementById(tpId).style.left = leftAttrTp;
                        document.getElementById(tpId).style.top = topAttrTp;
                    }

                }
            } else if (e.target.classList.contains("notifyDateEdit")) {
                dpId = e.target.getAttribute("dpId");
                var parentId = e.target.parentElement.id;
                document.getElementById(parentId).insertBefore(document.getElementById(dpId), document.getElementById(parentId).childNodes[0]);
                if (document.getElementById(dpId).style.display == 'none') {
                    document.getElementById(dpId).style.display = 'block';
                    if (leftAttrDp != "0px") {
                        document.getElementById(dpId).style.left = leftAttrDp;
                        document.getElementById(dpId).style.top = topAttrDp;
                    }
                }
            } else {
                var hideMe = document.getElementsByClassName("timepicker-popover");
                for (var i = 0; i < hideMe.length; i++) {
                    if (hideMe[i].id == tpId && hideMe[i].style.display == 'block') {
                        leftAttrTp = hideMe[i].style.left;
                        topAttrTp = hideMe[i].style.top;
                        hideMe[i].style.display = 'none';
                    }



                }

                if (!e.target.classList.value.includes("calendar")) {
                    var hideMe = document.getElementsByClassName("datepicker-popover");
                    for (var i = 0; i < hideMe.length; i++) {
                        if (hideMe[i].id == dpId && hideMe[i].style.display == 'block') {
                            leftAttrDp = hideMe[i].style.left;
                            topAttrDp = hideMe[i].style.top;
                            hideMe[i].style.display = 'none';
                        }


                    }
                }
            }


        };
    };



    this.init(config);

}




function focusLinkLogActionDiv(linkedLogId) {

    linkedLogId.parentNode.parentNode.childNodes[1].classList.add('activeAction');

}

function focusTxtFormatLogActionDiv(txtformtLogId) {
    txtformtLogId.parentNode.parentNode.childNodes[2].classList.add('activeAction');

}

function focusUploadLogActionDiv(uploadLogAction) {
    uploadLogAction.parentNode.parentNode.childNodes[3].classList.add('activeAction');

}
