var processStateSearch = function(config) {
	var AArray = A.Array;
	var USER_TYPE_NORMAL = "normal";
	var USER_TYPE_APPROVER = "approver";
	var APPLICATION_STATUS_ACTIVE = 1;
	var APPLICATION_STATUS_INACTIVE = 2;
	var instance;
	this.init = function(config) {
		instance = this;
		this.pns = config.pns;
		this.ajaxUrl = config.ajaxUrl;
		this.userType = config.userType;
		this.userId = config.userId;
		this.exportUrl = config.exportUrl;
		this.ajaxUrlBulkRegistration = config.ajaxUrlBulkRegistration;
		this.statusTypes = config.statusTypes;
		this.salesDrodpdownData = config.salesDrodpdownData;
		this.assigneeData = config.assigneeData;
		this.closedReasons = config.closedReasons;
		this.closedReasonsFilter = config.closedReasonsFilter;
		this.closedEnabledStages = config.closedEnabledStages;
		this.reasonForCloseLostTitle = config.reasonForCloseLostTitle;
		this.reasonForCloseWonTitle = config.reasonForCloseWonTitle;
		this.formDataUrlParam = config.formDataUrlParam;
		this.formDataParam = config.formDataParam;
		this.modelData = config.modelData;
		this.start = 0;
		this.pageSize = 10;
		this.rowContainer = A.one("#processStatesContainer");
		this.sampleRow = A.one("#sampleProcessStateRow");
		this.loadMoreNode = A.one("#loadMore");
		this.exportButton = A.one("#export");
		this.bulkRegistrationButton = A.one("#bulkRegistration");
		this.bulkUploadSpan = A.one("#bulkUploadSpan");
		this.processIdDD =  A.one('#processId');
		this.entityDD =  A.one('#entity');
		this.entityTypeDD =  A.one('#entityType');
		this.statusTypeDD =  A.one('#statusType');
		this.assigneeDD =  A.one('#assignee');
		this.stageDD =  A.one('#stage');
		this.dealStatusDD =  A.one('#dealStatus');
		this.filterClosedLostDD = A.one('#filterClosedLost');
		this.activeStatusDD = A.one("#activeStatus");
		this.searchText = A.one("#searchText");
		this.startDate = A.one("#startDate");
		this.endDate = A.one("#endDate");
		this.selectDateType = A.one("#selectDateType");
		
		this.closedLostDate = A.one("#closedLostDate");
		this.closedWonDate = A.one("#closedWonDate");
		
		if (A.one("#startDateContainer")){
			this.datePicker("startDateContainer","startDate");
		}
		
		if (A.one("#endDateContainer")){
			this.datePicker("endDateContainer","endDate");
		}

		this.datePickerCloseApplication("closeWonDateContainer", "closedWonDate");
		this.datePickerCloseApplication("closeLostDateContainer", "closedLostDate");
		this.resultCount = A.one("#resultCount");
		// Closed popup
		this.closedReasonId =  A.one("#closedReasonId");
		this.closedDec =  A.one("#closedDesc");

		//this.initDateIconClick();
		this.initExport();
		this.initBulkRegistration();
		this.initializeTextSearch();
		this.initializeEnterKeySearch();
		
		this.initProcessFilters();
		
		
		//TODO: integrating search
		//initially load some applicants, thereafter on click of load more load applicants
		this.loadProcessStates();
		
		this.containerClick();
		
	}
	this.initExport = function(){
		// this check is mandatory, bcz export functionality wont available in case the user is not authorized
		if(instance.exportButton){
			instance.exportButton.on("click",function(){
				this.set("disabled",true);
				this.set("text","Exporting...");
				instance.exportToXsl();
			});
		}
	}
	this.initBulkRegistration = function(){
		// this check is mandatory, bcz export functionality wont available in case the user is not authorized
		if(instance.bulkRegistrationButton){
			instance.bulkRegistrationButton.on("change",function(){
				this.set("disabled",true);
				instance.bulkUploadSpan.set("text","Uploading...");
				instance.bulkRegistration();
			});
		}
	}
	
	this.initializeLoadMore = function() {
		instance.loadMoreNode.on("click",function() {
			// in this case search criteria remains same so searchCriteriaChanged = false
			instance.loadProcessStates();
		});
	}
	this.initializeEnterKeySearch = function(){
		var nodes = [instance.searchText,instance.startDate,instance.endDate];
		var nodeList = new A.NodeList(nodes);
		nodeList.on("keypress",function(ev){
			// click on enter
			if(ev.keyCode ==  13){
				instance.searchCriteriaChange();
			}
		});
	}
	this.initializeTextSearch = function(){
		if (A.one("#textSearchButton")){
			A.one("#textSearchButton").on("click",function(){
				instance.searchCriteriaChange();
			});
		}

	}
	this.initFiltersWithCookie = function(){
		
		var processId = getCookie('searchCriteria_processId');
		var statusTypeId = getCookie('searchCriteria_statusType');
		var assigneeId = getCookie('searchCriteria_assignee');
		var dealStatusId = getCookie('searchCriteria_dealStatus');
		var activeStatus = getCookie('searchCriteria_activeStatus');
		var closedReasonCatgId = getCookie('searchCriteria_filterClosedLost');
		var stageId = getCookie('searchCriteria_stage');
		
		
		if(instance.entityDD){	
			var entityType = document.getElementById("entityType");
			var selEntityType = entityType.options[entityType.selectedIndex].value;
			var selEntityText = entityType.options[entityType.selectedIndex].value;
			var entityArray= new Array();
			if(instance.checkId(processId)){
				if(selEntityType == 0){
					for (i = 0; i < entityType.options.length; i++) {
						var entityArray = entityType .options[i].value;
						var entityArrayText = entityType .options[i].text;
						if(entityArrayText == "Product" || entityArrayText[i] == "Dummy Entity"){
							instance.fetchEntities(processId,entityArray,false);
						}else{
						   instance.fetchMicroServiceEntities(processId,entityArray,false);
						}
					}
				}else{
					if(selEntityText == "Product" || selEntityText == "Dummy Entity"){
						instance.fetchEntities(processId,selEntityType,false);
					}else{
						instance.fetchMicroServiceEntities(processId,selEntityType,false);
					}
				}	
				//instance.fetchEntities(processId,0,"f1");
				//instance.fetchMicroServiceEntities(processId,162611,"fm1");
				
			}else{
				//instance.fetchEntities(0,0,"f2");
				//instance.fetchMicroServiceEntities(0,162611,"fm2");
				if(selEntityType == 0){
					for (i = 0; i < entityType.options.length; i++) {
						var entityArray = entityType .options[i].value;
						var entityArrayText = entityType .options[i].text;
						if(entityArrayText == "Product" || entityArrayText == "Dummy Entity"){
							instance.fetchEntities("0",entityArray,false);
						}else{
						   instance.fetchMicroServiceEntities("0",entityArray,false);
						}
					}
				}else{
					if(selEntityText == "Product" || selEntityText == "Dummy Entity"){
						instance.fetchEntities("0",selEntityType,false);
					}else{
					   instance.fetchMicroServiceEntities("0",selEntityType,false);
					}
				}	
			}
		}
		
		if(instance.processIdDD && instance.checkId(processId) && A.one("#processId [value='"+processId+"']")){
			var processIndex = A.one("#processId [value='"+processId+"']")._node.index;
			document.getElementById("processId").selectedIndex = processIndex;
			
			instance.populateStatusTypes(processId);
			//instance.populateEntities(processId);
			instance.populateAssignee(processId);
			
			instance.updateFilterTagSelect(processId, 'processId');
		}else{
			instance.populateStatusTypes("0");
			//instance.populateEntities(processId);
			instance.populateAssignee("0");
		}
		
		if(instance.activeStatusDD && instance.checkId(activeStatus)){ // not visible for applicant
			if(A.one("#activeStatus [value='"+activeStatus+"']")){
				var activeStatusIndex = A.one("#activeStatus [value='"+activeStatus+"']")._node.index;
				document.getElementById("activeStatus").selectedIndex = activeStatusIndex;	
			}	
			instance.updateFilterTagSelect(activeStatus, 'activeStatus');
		}else if(instance.activeStatusDD){
			instance.updateFilterTagSelect(instance.activeStatusDD.val(), 'activeStatus');
		}
		
		if(instance.statusTypeDD && instance.checkId(statusTypeId) && A.one("#statusType [value='"+statusTypeId+"']")){
			var statusTypeIndex = A.one("#statusType [value='"+statusTypeId+"']")._node.index;
			document.getElementById("statusType").selectedIndex = statusTypeIndex;
			instance.updateFilterTagSelect(statusTypeId, 'statusType');
		}
		
		if(instance.checkId(assigneeId) && A.one("#assignee [value='"+assigneeId+"']")){
			var assigneeIndex = A.one("#assignee [value='"+assigneeId+"']")._node.index;
			document.getElementById("assignee").selectedIndex = assigneeIndex;
			instance.updateFilterTagSelect(assigneeId, 'assignee');
		}
		if(instance.checkId(dealStatusId) && A.one("#dealStatus [value='"+dealStatusId+"']")){
			var dealStatusIdIndex = A.one("#dealStatus [value='"+dealStatusId+"']")._node.index;
			document.getElementById("dealStatus").selectedIndex = dealStatusIdIndex;
			instance.updateFilterTagSelect(dealStatusId, 'dealStatus');
			
			if(instance.filterClosedLostDD){
				if(dealStatusId == "7"){
					document.getElementById("filterClosedLost").parentNode.style.display='block';
				}else{
					document.getElementById("filterClosedLost").parentNode.style.display='none';
				}
			}
			
		}
		if(!instance.checkId(dealStatusId) && instance.filterClosedLostDD){
			document.getElementById("filterClosedLost").parentNode.style.display='none';
		}
		if(instance.filterClosedLostDD){
			this.populateClosedLostReasonsFilter();	
		}
		
		if(instance.checkId(closedReasonCatgId) && A.one("#filterClosedLost [value='"+closedReasonCatgId+"']")){
			var closedReasonCatgIdIndex = A.one("#filterClosedLost [value='"+closedReasonCatgId+"']")._node.index;
			document.getElementById("filterClosedLost").selectedIndex = closedReasonCatgIdIndex;
			instance.updateFilterTagSelect(closedReasonCatgId, 'filterClosedLost');
		}
		if(instance.checkId(stageId)){
			try {
				var splitSelectId = stageId.split(",");
				for (var i = 0; i < splitSelectId.length; i++) {
					var multiSelectId = splitSelectId[i]
					if(multiSelectId && multiSelectId != "" && multiSelectId != "0"){
						A.one("#stage [value='"+multiSelectId+"']")._node.selected = true;
					}
				}				
				instance.updateFilterTagMultiSelect(stageId, 'stage');
			} catch (e) {
				console.log(e);
			}
		}
		
		if(instance.formDataParam && instance.formDataParam != ''){
			instance.populateDynamicSelect();	
		}
	}
	this.checkId = function(selectId){
		if(selectId && selectId != "" && selectId != "-1" && selectId != "0" && selectId != "undefined"){
			return true;
		}
		return false;
	}
	this.initProcessFilters = function(){
		instance.initFiltersWithCookie();
		
		if(instance.processIdDD){
			instance.processIdDD.on("change",function(){
				var statusTypeId = instance.statusTypeDD ? instance.statusTypeDD.val() : "";
				var assigneeId = instance.assigneeDD ? instance.assigneeDD.val() : "";
				var entityId = instance.entityDD ? instance.entityDD.val() : "";
				var id = this.val();
				if(instance.statusTypeDD){
					instance.populateStatusTypes(id);
					if(instance.checkId(statusTypeId)){
						if(A.one("#statusType [value='"+statusTypeId+"']")){
							var statusTypeIdIndex = A.one("#statusType [value='"+statusTypeId+"']")._node.index;
							document.getElementById("statusType").selectedIndex = statusTypeIdIndex;
						}else{
							document.getElementById("statusType").selectedIndex = 0;
						}
					}
				}
				if(instance.entityDD){
					instance.populateEntities(id);
					if(instance.checkId(entityId)){
						if(A.one("#entity [value='"+entityId+"']")){
							var entityIdIndex = A.one("#entity [value='"+entityId+"']")._node.index;
							document.getElementById("entity").selectedIndex = entityIdIndex;
						}else{
							document.getElementById("entity").selectedIndex = 0;
						}
					}
				}
				if(instance.assigneeDD){
					
					instance.populateAssignee(id);
					if(instance.checkId(assigneeId)){
						if(A.one("#assignee [value='"+assigneeId+"']")){
							var assigneeIdIndex = A.one("#assignee [value='"+assigneeId+"']")._node.index;
							document.getElementById("assignee").selectedIndex = assigneeIdIndex;
						}else{
							document.getElementById("assignee").selectedIndex = 0;
						}
					}
				}
				
				if(id > 0){
					instance.showAncestor(instance.exportButton);
					instance.showAncestor(instance.bulkRegistrationButton);
				}else{
					instance.hideAncestor(instance.exportButton);
					instance.hideAncestor(instance.bulkRegistrationButton);
				}
				
				instance.searchCriteriaChange();
			});
		}
		if(instance.formDataParam && instance.formDataParam != ''){
			var jsonObj = JSON.parse(instance.formDataParam);
			
			AArray.each(jsonObj,function(type){
				var selectStr =  type.fieldId + '_' + type.htmlFormId;
				if(A.one("#"+selectStr)){
					var selectList = A.one("#"+selectStr);
					selectList.on("change",function(){
						instance.searchCriteriaChange();
					});
				}
			});
			
		}
		
		if(instance.statusTypeDD){ // not visible for applicant
			instance.statusTypeDD.on("change",function(){
				instance.searchCriteriaChange();
			});
		}
		if(instance.assigneeDD){ // not visible for applicant
			instance.assigneeDD.on("change",function(){
				instance.searchCriteriaChange();
			});
		}
		if(instance.stageDD){ // not visible for applicant
			instance.stageDD.on("change",function(){
				instance.searchCriteriaChange();
			});
		}
		if(instance.selectDateType && instance.endDate && instance.startDate){ // not visible for applicant
				instance.selectDateType.on("change",function(){
					var endDate = instance.endDate.val();
					var startDate = instance.startDate.val();
					if(startDate != "" || endDate != ""){
						instance.searchCriteriaChange();
					}
				});	
		}
		
		if(instance.dealStatusDD){ // not visible for applicant
			instance.dealStatusDD.on("change",function(){
				instance.searchCriteriaChange();
				var testLost = instance.dealStatusDD.val();
				if(testLost == "7" && instance.filterClosedLostDD){
					document.getElementById("filterClosedLost").parentNode.style.display='block';
				}else{
					document.getElementById("filterClosedLost").parentNode.style.display='none';
				}
			});
		}
		
		if(instance.activeStatusDD){ // not visible for applicant
			instance.activeStatusDD.on("change",function(){
				instance.searchCriteriaChange();
			});
		}
		
		if(instance.entityDD){ // may not visible for applicant
			instance.entityDD.on("change",function(){
				instance.searchCriteriaChange();
			});
		}
		if(instance.filterClosedLostDD){ // may not visible for applicant
			instance.filterClosedLostDD.on("change",function(){
				instance.searchCriteriaChange();
			});
		}
		if(instance.entityTypeDD){ // may not visible for applicant
			var entityTypeId = getCookie('searchCriteria_entityType');
			if(instance.checkId(entityTypeId)){
				var entityIndex = A.one("#entityType [value='"+entityTypeId+"']")._node.index;
				document.getElementById("entityType").selectedIndex = entityIndex;	
				instance.updateFilterTagSelect(entityTypeId, 'entityType');
			}
			instance.entityTypeDD.on("change",function(){
				var entityType = document.getElementById("entityType");
				var selEntityType = entityType.options[entityType.selectedIndex].value;
				var selEntityText = entityType.options[entityType.selectedIndex].text;
				if(instance.checkId(processId)){
					if(selEntityType == 0){
						for (i = 0; i < entityType.options.length; i++) {
							var entityArray = entityType .options[i].value;
							var entityArrayText = entityType .options[i].text;
							if(entityArrayText == "Product" || entityArrayText[i] == "Dummy Entity"){
								instance.fetchEntities(processId,entityArray,true);
							}else{
							   instance.fetchMicroServiceEntities(processId,entityArray,true);
							}
						}
					}else{
						if(selEntityText == "Product" || selEntityText == "Dummy Entity"){
							instance.fetchEntities(processId,selEntityType,true);
						}else{
							instance.fetchMicroServiceEntities(processId,selEntityType,true);
						}
					}	
					
				}else{
					if(selEntityType == 0){
						for (i = 0; i < entityType.options.length; i++) {
							var entityArray = entityType .options[i].value;
							var entityArrayText = entityType .options[i].text;
							if(entityArrayText == "Product" || entityArrayText == "Dummy Entity"){
								instance.fetchEntities("0",entityArray,true);
							}else{
							   instance.fetchMicroServiceEntities("0",entityArray,true);
							}
						}
					}else{
						if(selEntityText == "Product" || selEntityText == "Dummy Entity"){
							instance.fetchEntities("0",selEntityType,true);
						}else{
						   instance.fetchMicroServiceEntities("0",selEntityType,true);
						}
					}	
				}
			});
		}
		
		
		
		if(instance.checkId(processId)){}else{}
	
		
	}
	this.hideAllContextMenus = function(){
		var allCMS = A.all('.conextMenuDiv');
		allCMS.addClass("hide");
	}
	this.containerClick = function(){
		var enrollmentContainer = A.one('body');
		enrollmentContainer.on('click', function(e){
			instance.hideAllContextMenus();
		});

	}
	this.contextMenu = function(processStateRow){
		if(!processStateRow) return;
		var cmenu = processStateRow.one('.threedot');
		cmenu.on('click', function(e){
			e.preventDefault();
			e.stopPropagation();
			instance.hideAllContextMenus();

			// current clicked menu
			var targ = e.currentTarget;
			var next = targ.next();
			next.removeClass('hide');
		});
	}
	this.showAncestor = function(node){
		if(node){
			instance.show(node.ancestor("div"));
		}
	}
	this.hideAncestor = function(node){
		if(node){
			instance.hide(node.ancestor("div"));
		}
	}
	this.populateStatusTypes = function(processId){
		
		if(instance.statusTypeDD){
			var oldValue = instance.statusTypeDD.val();
			instance.statusTypeDD.all("*").remove();
			var types = instance.statusTypes[processId] || [];
			AArray.each(types,function(type){
				instance.statusTypeDD.append(A.Node.create("<option value=" + type.id + ">" + type.name + "</option>"));
			});
			if(oldValue && oldValue !=''){
				instance.statusTypeDD.val(oldValue);
			}
		}
	}
	this.populateAssignee = function(processId){
		
		if(instance.assigneeDD){
			var oldValue = instance.assigneeDD.val();
			instance.assigneeDD.all("*").remove();
			var types = instance.salesDrodpdownData[processId] || [];
			AArray.each(types,function(type){
				instance.assigneeDD.append(A.Node.create("<option value=" + type.id + ">" + type.name + "</option>"));
			});
			if(oldValue && oldValue !=''){
				instance.assigneeDD.val(oldValue);
			}
		}
	}
	this.populateEntities = function(processId,isclearOptions){
		var entityType = document.getElementById("entity");
		if(instance.entityDD){
			var oldValue = instance.entityDD.val();
			if(isclearOptions){
				instance.entityDD.all("*").remove();
			}	
			var types = instance.entities[processId] || [];
			var isAddOption = true;
			AArray.each(types,function(type){
				for (i = 0; i < entityType.options.length; i++) {
					var entityArray = entityType.options[i].value;
					//alert("entityArray " + entityArray + " type.id " + type.id);
					if(entityArray == type.id){
						isAddOption = false;
					}
				}
				if(isAddOption){
					instance.entityDD.append(A.Node.create("<option value=" + type.id + ">" + type.name + "</option>"));
				}
			});
			if(oldValue && oldValue !=''){
				instance.entityDD.val(oldValue);
			}else{
				instance.entityDD.val("0");
			}
		}
	}
	this.populateMicroServiceEntities = function(processId,isclearOptions){
		var entityType = document.getElementById("entity");
		if(instance.entityDD){
			var oldValue = instance.entityDD.val();
			if(isclearOptions){
				instance.entityDD.all("*").remove();
			}
			var types = instance.entities["content"] || [];
			var isAddOption = true;
			AArray.each(types,function(type){
				for (i = 0; i < entityType.options.length; i++) {
					var entityArray = entityType.options[i].value;
					if(entityArray == type.id){
						isAddOption = false;
					}
				}
				if(isAddOption){
					instance.entityDD.append(A.Node.create("<option value=" + type.contentJson.ProgrammeCode + ">" + type.contentJson.ProgrammeTitle + "</option>"));
				}	
			});
			if(oldValue && oldValue !=''){
				instance.entityDD.val(oldValue);
			}else{
				instance.entityDD.val("0");
			}
		}
	}
	this.populateClosedLostReasonsFilter = function(){
		
		var items = instance.closedReasonsFilter[0];
		var types = instance.closedReasonsFilter[0] || [];
		AArray.each(types,function(type){
			instance.filterClosedLostDD.append(A.Node.create("<option value=" + type.id + ">" + type.name + "</option>"));
		});
	}
	this.populateDynamicSelect = function(){
		
		var jsonObj = JSON.parse(instance.formDataParam);
		
		for (var i = 0; i < jsonObj.length; i++) {
			var obj = jsonObj[i];
			
			var ajaxUrl = instance.formDataUrlParam + obj.htmlFormId;
			var selectStr =  obj.fieldId + '_' + obj.htmlFormId;
			
			var selectList = document.getElementById(selectStr);
            if(!selectList){
            	continue;
            }
            AArray.each(jsonObj, function(type){
				var selectStr =  type.fieldId + '_' + type.htmlFormId;
				var selectList = A.one("#"+selectStr);
				var selectId = getCookie('searchCriteria_'+selectStr);
				if(instance.checkId(selectId)){
					var selectIdIndex = A.one("#"+selectStr+" [value='"+selectId+"']")._node.index;
					document.getElementById(selectStr).selectedIndex = selectIdIndex;
					instance.updateFilterTagSelect(selectId, selectStr);
				}
			});
			
		}
		
	}
	this.exportToXsl = function(){
		if (instance.exportUnderProcess) {
			return;
		}
		instance.exportUnderProcess = true;
		data = {};
		data.action = "exportProessStates";
		data.start = instance.start;
		instance.populateRequestData(data);
		//instance.searchCriteria(data);
		A.io.request(instance.ajaxUrl,{
			dataType: 'json',
			method: 'POST',
			data: data,
			on: {
			complete: function() {
				// this is called before success and failure methods. So right place for any post processing of request.
				instance.exportUnderProcess = false;
				instance.exportButton.removeAttribute("disabled");
				instance.exportButton.set("text","Export");
			},
			success: function() {
				var data=this.get('responseData');
				if (data) {
					if (data.error) {
						alert(data.error);
					}else {
						// FILE_PATH is one parameter value in exportUrl
						var exportUrl = instance.exportUrl.replace("FILE_PATH", data.filePath);
						document.location.href = exportUrl;
					}
				}else {
					//handle due to some reason data is null
					alert("Failed to export the data");
				}
			  },
		    failure : function() {
		    	alert("Failed to export the data");
		    }
			}
		});
	
	}
	
	this.fetchEntities = function(processId,entityTypeVal,isclearOptions){
		var data = {};
		data.action = "getEntites";
		data.entityClassId = entityTypeVal;
		//instance.searchCriteria(data);
		A.io.request(instance.ajaxUrl,{
			dataType: 'json',
			method: 'POST',
			data: data,
			on: {
			success: function() {
				var data=this.get('responseData');
				if (data) {
					if (data.error) {
						//alert(data.error);//TODO:Handle
					}else {
						instance.entities = data;
						instance.populateEntities(processId,isclearOptions);
						var entityId = getCookie('searchCriteria_entity');
						if(instance.checkId(entityId)){
							var entityIndex = A.one("#entity [value='"+entityId+"']")._node.index;
							document.getElementById("entity").selectedIndex = entityIndex;	
							instance.updateFilterTagSelect(entityId, 'entity');
						}
					}
				}else {
					//handle due to some reason data is null
					//alert("Failed to export the data");
				}
			  },
		    failure : function() {
		    	//alert("Failed to export the data");
		    }
			}
		});
	
	}
	
	this.fetchMicroServiceEntities = function(processId,entityTypeVal,isclearOptions){
		var data = {};
		data.action = "getEntites";
		data.api="restApi";
		data.modelData = instance.modelData//"{'limit':'99999','modelName':'Programme','page':'0','formType':'Programme','filterdata':[]}";
		data.entityType = entityTypeVal;
		console.log("instance.modelData " + instance.modelData);
		console.log("instance.userType " + instance.userType);
		//instance.searchCriteria(data);
		A.io.request(instance.ajaxUrl,{
			dataType: 'json',
			method: 'POST',
			data: data,
			on: {
			success: function() {
				var data=this.get('responseData');
				if (data) {
					if (data.error) {
						//alert(data.error);//TODO:Handle
					}else {
						//alert("fetchMicroServiceEntities " + JSON.stringify(data));
						instance.entities = data;
						instance.populateMicroServiceEntities(processId,isclearOptions);
						var entityId = getCookie('searchCriteria_entity');
						if(instance.checkId(entityId)){
							if(A.one("#entity [value='"+entityId+"']")){
								var entityIndex = A.one("#entity [value='"+entityId+"']")._node.index;
								document.getElementById("entity").selectedIndex = entityIndex;	
								instance.updateFilterTagSelect(entityId, 'entity');
							}	
						}
					}
				}else {
					//handle due to some reason data is null
					//alert("Failed to export the data");
				}
			  },
		    failure : function() {
		    	//alert("Failed to export the data");
		    }
			}
		});
	
	}
	
	this.bulkRegistration = function(){

		var formData = new FormData();
		formData.append("bulkRegistration", document.getElementById('bulkRegistration').files[0]);
		formData.append("processId", instance.processIdDD ? instance.processIdDD.val() : "");
		
		var xhr = new XMLHttpRequest();
		
		xhr.onreadystatechange = function(e) {
			if (xhr.readyState == 4) {
				//instance.removeFromProgress(file);
				if(xhr.status == 200 ){
					var restext = xhr.responseText.replace(/\n/g,"");
					var jsonobj = JSON.parse(restext);
					alert(jsonobj.msg);
					instance.bulkRegistrationButton.set("disabled",false);
					instance.bulkUploadSpan.set("text","Bulk Upload");
				}
			}
		};
		
		// start upload
		xhr.open("POST", instance.ajaxUrlBulkRegistration , true);
		//	xhr.setRequestHeader("Content-Type", "multipart/form-data");
		xhr.send(formData);
	}
	
	this.searchCriteriaChange = function(){
		var data = {};
		data.searchCriteriaChanged = true;
		instance.loadProcessStates(data);
		instance.updateCookieSearch(data);
		instance.updateFilterTags();
	}
	this.loadProcessStates = function(data) {
		if (instance.requestUnderProcess) {
			return;
		}
		instance.requestUnderProcess = true;
		var contentId =  instance.rowContainer.get('id');
		//preloader
		startPreLoader(contentId);
		data = data || {};
		data.action = "fetchProcessStates";
		data.formStorageId = "PSC001";
		data.formType = "PriceScheme";
		console.log("formStorageId  "+  data.formStorageId + " formtype " + data.formType);
		if(data.searchCriteriaChanged){
			instance.start = 0;
		}
		data.start = instance.start;
		data.pageSize = instance.pageSize;
		instance.populateRequestData(data);
		A.io.request(instance.ajaxUrl,{
			dataType: 'json',
			method: 'POST',
			data: data,
			on: {
			complete: function() {
				// this is called before success and failure methods. So right place for any post processing of request.
				instance.requestUnderProcess = false;
				stopPreLoader(contentId);
				if(data.searchCriteriaChanged){
            		// since it's fresh search, clear the existing results
            		instance.clearSearchResults();
            	}
			},
			success: function() {
				var data=this.get('responseData');
				if (data) {
					if (data.error) {
						alert(data.error);
					}else {
						var total = data["total"];
						
						// move the cursor
						instance.start = instance.start + instance.pageSize;
						// check if there are more rows to load or not.
						if (data.procesStates.length == 0 || instance.start >= total ) {
							try{
								instance.hide(instance.loadMoreNode.one("a"));
								instance.loadMoreNode.one("p").html("No more results ("+total+" out of "+total+")");
								instance.loadMoreNode.addClass("normalText");
								// since there are no results to load, unregister the click event of load more
								instance.loadMoreNode.detach("click");

							}catch(err) {

							}
						}else {
							// initialize it.... as there are more rows to load
							instance.initializeLoadMore();
							instance.show(instance.loadMoreNode.one("a"));
							instance.loadMoreNode.one("p").html("Click and view more results ("+instance.start+" out of "+total+")"); 
							instance.loadMoreNode.addClass("normalText");
						}
						// success response - render the process states
						if (instance.resultCount){
							instance.resultCount.html(total+" Result(s)");
						}
						
						instance.renderProcessStates(data.procesStates);
					}
				}else {
					//handle due to some reason data is null
					alert("Process Error");
				}
			  },
		    failure : function() {
		    }
			}
		});
	}
	this.populateRequestData = function(data){
		data = data || {} ;
		data.searchText = instance.searchText ? instance.searchText.val() : "";
		data.startDate = instance.startDate ? instance.startDate.val() : "";
		data.endDate = instance.endDate ? instance.endDate.val() : "";
		data.selectDateType = instance.selectDateType ? instance.selectDateType.val() : "";
		
		data.processId = instance.processIdDD ? instance.processIdDD.val() : "";
		data.statusTypeId = instance.statusTypeDD ? instance.statusTypeDD.val() : "";
		data.assigneeId = instance.assigneeDD ? instance.assigneeDD.val() : "";
		//data.stageId = instance.stageDD ? instance.stageDD.val() : "";
		data.stageId = "";
		if (instance.stageDD) {
			try{
				for (var i = 0; i < instance.stageDD._node.selectedOptions.length; i++) {
					if (i != instance.stageDD._node.selectedOptions.length - 1) {
						data.stageId += instance.stageDD._node.selectedOptions[i].value + ",";
					} else {
						data.stageId += instance.stageDD._node.selectedOptions[i].value;
					}
				}
			}catch(err ){
				console.log("err " + err);
			}
		}
		data.dealStatusId = instance.dealStatusDD ? instance.dealStatusDD.val() : "";
		data.activeStatus = instance.activeStatusDD ? instance.activeStatusDD.val() : "1";
		data.entity = instance.entityDD ? instance.entityDD.val() : "";
		data.closedReasonCatgId = instance.filterClosedLostDD  ? instance.filterClosedLostDD.val() : "";
		
		if(instance.formDataParam && instance.formDataParam != ''){
			var jsonObj = JSON.parse(instance.formDataParam);
			
			for (var i = 0; i < jsonObj.length; i++) {
				var obj = jsonObj[i];
				var selectStr =  obj.fieldId + '_' + obj.htmlFormId;
				var selectList = document.getElementById(selectStr);
				data[selectStr] = selectList ? selectList.value : "";
			}
		}
		
	}
	this.updateCookieSearch = function(data){
		//setCookie('searchCriteria_searchText', data.searchText);
		//setCookie('searchCriteria_startDate', data.startDate);
		//setCookie('searchCriteria_endDate', data.endDate);
		setCookie('searchCriteria_processId', data.processId);
		setCookie('searchCriteria_statusType', data.statusTypeId);
		setCookie('searchCriteria_assignee', data.assigneeId);
		setCookie('searchCriteria_stage', data.stageId);
		setCookie('searchCriteria_dealStatus', data.dealStatusId);
		setCookie('searchCriteria_activeStatus', data.activeStatus);
		setCookie('searchCriteria_entity', data.entity);
		setCookie('searchCriteria_entityType', data.entity);
		setCookie('searchCriteria_filterClosedLost', data.closedReasonCatgId);
		
		if(instance.formDataParam && instance.formDataParam != ''){
			var jsonObj = JSON.parse(instance.formDataParam);
			for (var i = 0; i < jsonObj.length; i++) {
				var obj = jsonObj[i];
				var selectStr =  obj.fieldId + '_' + obj.htmlFormId;
				//var selectList = document.getElementById(selectStr);
				setCookie('searchCriteria_'+selectStr, data[selectStr]);
			}
		}
		
	}
	this.updateFilterTagSelect = function(selectId, selectStr){
		
		var ul = document.getElementById("filterSearchTags");
		
		var liSelectTagStr = "li_"+selectStr;
		
		if(selectId && selectId != "" && selectId != "-1" && (selectId != "0" || (A.one("#"+selectStr) && selectStr == "assignee")) && selectId != "allStatusTypes"){
			if(A.one("#"+liSelectTagStr)){
				var currentDealStatusId = A.one("#"+liSelectTagStr).getAttribute(selectStr);
				if(currentDealStatusId != selectId){
					A.one("#"+liSelectTagStr).remove();
				}else if(currentDealStatusId == selectId){
					return;
				}
			}
			if(!A.one("#"+selectStr)){
				return;
			}
			var statusText = A.one("#"+selectStr+" [value='"+selectId+"']").text();
			
			//alert("selected");
			var li = document.createElement("li");
			li.setAttribute(selectStr, selectId);
			li.setAttribute('id', liSelectTagStr);
			li.appendChild(document.createTextNode(statusText));
			
			var a = document.createElement("a");
			a.setAttribute('href', "#");
			a.setAttribute('class', "closeTag");
			a.setAttribute('searchCriteriaTag', selectStr);
			a.setAttribute(selectStr, selectId);
			a.setAttribute('data-dismiss', "closeTagdismiss");
			a.onclick = removeFilterTag;
			var img = document.createElement("img");
			img.setAttribute('src', "/SPProcessEngine-portlet/images/icon-close.svg");
			a.appendChild(img);
			li.appendChild(a);
			ul.appendChild(li);	
		}else{
			if(A.one("#"+liSelectTagStr)){
				A.one("#"+liSelectTagStr).remove();
			}
		}
	}
	this.updateFilterTagMultiSelect = function(selectId, selectStr){
		var ul = document.getElementById("filterSearchTags");
		
		var liSelectTagStr = "li_"+selectStr;
		var selObj = A.one("#"+selectStr)._node.options;
		
		for (var j=0; j < selObj.length; j++) { 
			var multiSelectId = selObj[j].value;
			if(multiSelectId && multiSelectId != "" && multiSelectId != "0"){
				if(document.getElementById(liSelectTagStr + "_" + multiSelectId)){
					A.one("#"+liSelectTagStr+"_"+multiSelectId).remove();
				}
			}
		}
		
		var splitSelectId = selectId.split(",");
		for (var i = 0; i < splitSelectId.length; i++) {
			var multiSelectId = splitSelectId[i]
			if(multiSelectId && multiSelectId != "" && multiSelectId != "0"){
				
				var statusText = A.one("#"+selectStr+" [value='"+multiSelectId+"']").text();
				 var liId = liSelectTagStr+"_"+multiSelectId;
				//alert("selected");
				var li = document.createElement("li");
				li.setAttribute(selectStr, multiSelectId);
				li.setAttribute('id', liId);
				li.appendChild(document.createTextNode(statusText));
				
				var a = document.createElement("a");
				a.setAttribute('href', "#");
				a.setAttribute('class', "closeTag");
				a.setAttribute('searchCriteriaTag', selectStr);
				a.setAttribute(selectStr, multiSelectId);
				a.setAttribute('data-dismiss', "closeTagdismiss");
				a.onclick = removeFilterTagMulti;
				var img = document.createElement("img");
				img.setAttribute('src', "/SPProcessEngine-portlet/images/icon-close.svg");
				a.appendChild(img);
				li.appendChild(a);
				ul.appendChild(li);	
			}
		}
		
	}
	this.updateFilterTags = function(){
		var ul = document.getElementById("filterSearchTags");
		
		var processId = getCookie('searchCriteria_processId');
		var statusTypeId = getCookie('searchCriteria_statusType');
		var assigneeId = getCookie('searchCriteria_assignee');
		var dealStatusId = getCookie('searchCriteria_dealStatus');
		var activeStatus = getCookie('searchCriteria_activeStatus');
		var entity = getCookie('searchCriteria_entity');
		var entityType = getCookie('searchCriteria_entityType');
		var closedReasonCatgId = getCookie('searchCriteria_filterClosedLost');
		
		instance.updateFilterTagSelect(processId, 'processId');
		
		instance.updateFilterTagSelect(statusTypeId, 'statusType');
		instance.updateFilterTagSelect(assigneeId, 'assignee');
		instance.updateFilterTagSelect(dealStatusId, 'dealStatus');
		instance.updateFilterTagSelect(activeStatus, 'activeStatus');
		instance.updateFilterTagSelect(entity, 'entity');
		instance.updateFilterTagSelect(closedReasonCatgId, 'filterClosedLost');
		
		if(instance.formDataParam && instance.formDataParam != ''){
			var jsonObj = JSON.parse(instance.formDataParam);
			for (var i = 0; i < jsonObj.length; i++) {
				var obj = jsonObj[i];
				var selectStr =  obj.fieldId + '_' + obj.htmlFormId;
				//var selectList = document.getElementById(selectStr);
				var selectId = getCookie('searchCriteria_'+selectStr);
				instance.updateFilterTagSelect(selectId, selectStr);
			}
		}
		
		var stageId = getCookie('searchCriteria_stage');
		instance.updateFilterTagMultiSelect(stageId, 'stage');
		
		
	}
	function removeFilterTag(){
		
		var searchCriteriaTag = this.getAttribute('searchCriteriaTag');
		var searchCriteria = this.getAttribute(searchCriteriaTag);
		
		//delete_cookie('searchCriteria_'+searchCriteria);
		var parentEle = this.parentNode;
		var rootUlEle = parentEle.parentNode;
		this.parentNode.remove();
		var selectIndex = 0;
		if(searchCriteriaTag == "activeStatus"){
			selectIndex = 2;
		}
		if(searchCriteriaTag == "dealStatus"){
			document.getElementById("filterClosedLost").selectedIndex = 0;
			
		}
		document.getElementById(searchCriteriaTag).selectedIndex = selectIndex;
		YUI().use('node-event-simulate', function(Y) {
			Y.one("#"+searchCriteriaTag).simulate('change');
		});
	}
	function removeFilterTagMulti(){
		
		var searchCriteriaTag = this.getAttribute('searchCriteriaTag');
		var searchCriteria = this.getAttribute(searchCriteriaTag);
		
		//delete_cookie('searchCriteria_'+searchCriteria);
		var parentEle = this.parentNode;
		var rootUlEle = parentEle.parentNode;
		this.parentNode.remove();
		if (A.one("#"+searchCriteriaTag) && A.one("#"+searchCriteriaTag+" [value='"+searchCriteria+"']")) {
			
			A.one("#"+searchCriteriaTag+" [value='"+searchCriteria+"']")._node.selected = false;
		}
		YUI().use('node-event-simulate', function(Y) {
			Y.one("#"+searchCriteriaTag).simulate('change');
		});
	}
	function setCookie(cname, cvalue) {
	    document.cookie = instance.userId + "_" +cname + "=" + cvalue + ";expires=-1; path=/";
	}
	function delete_cookie(name) {
		  document.cookie = instance.userId + "_" + name +'=; Expires=Thu, 01 Jan 1970 00:00:01 GMT;';
	}
	function getCookie(cname) {
		
	    var name = instance.userId + "_" +cname + "=";
	    var ca = document.cookie.split(';');
	    for(var i = 0; i < ca.length; i++) {
	        var c = ca[i];
	        while (c.charAt(0) == ' ') {
	            c = c.substring(1);
	        }
	        if (c.indexOf(name) == 0) {
	            return c.substring(name.length, c.length);
	        }
	    }
	    return "";
	}
	this.renderProcessStates = function(procesStates) {
		if (!procesStates) {
			return;
		}
		// iterate  array and create  row for each process state json object
		AArray.each(procesStates,function(processState) {
			instance.renderProcessState(processState);
		});

	}
	this.setTextSafe = function(node,text){
		if(node){
			node.set('text',text);
		}
	};
	this.renderProcessState = function(processState) {
		if (processState && processState.processStateId) {
			// clone the node - true indicates deep cloning
			var newRow = instance.sampleRow.cloneNode(true);
			//newRow.one(instance.idApplicant).set('text',applicant.applicantId);
			newRow.one("#processStateId").val(processState.processStateId);
			newRow.one("#id").set('text',processState.processStateId);
			newRow.one("#id").setAttribute('href',processState.url);
			newRow.one("#entityName").set('text',processState.entityName);
			
			instance.setTextSafe(newRow.one("#stageName"),processState.stageName);
			
			if(processState.stageName){
				if ((processState.stageName.indexOf("Conv") != -1) && (newRow.one("#stageName"))){
					newRow.one("#stageName").set('title', "Converted");
				}
			}	
			
			var statusInActive = newRow.one("#statusInActive");
			var statusActive = newRow.one("#statusActive");
			
			if (processState.activeStatus == APPLICATION_STATUS_ACTIVE){
				instance.show(newRow.one("#statusInActive"));
			} else {
				instance.show(newRow.one("#statusActive"));
			}
			
			if(statusInActive){
				statusInActive.on("click",function(){
					instance.rowClicked = instance.getRowNode(this);
					instance.changeStatus(APPLICATION_STATUS_ACTIVE);
				});
			}
			
			if(statusActive){
				statusActive.on("click",function(){
					instance.rowClicked = instance.getRowNode(this);
					instance.changeStatus(APPLICATION_STATUS_INACTIVE);
				});
			}
			
			if (processState.stageToolTip){
				instance.setTextSafe(newRow.one("#tooltip"),processState.stageToolTip);
			} else {
				if(newRow.one("#tooltip")) {
					newRow.one("#tooltip").set('style', "display:none;");
				}
            }
			
			instance.setTextSafe(newRow.one("#applicantName"),processState.applicantName);
			/**if(newRow.one("#applicantName") && processState.profileUrl){
				var sn = processState.profileUrl.replace("/","");
				newRow.one("#applicantName").setAttribute('href',"/profile?user=" + sn);
			}**/
			
			instance.setTextSafe(newRow.one("#supervisorName"),processState.supervisorName);
			instance.setTextSafe(newRow.one("#agentName"),processState.agentName);
			newRow.one("#currentStep").set('text',processState.currentStep);
			newRow.one("#dataCreated").set('text',processState.dataCreated);
			newRow.one("#dataModified").set('text',processState.dataModified);
			
			newRow.one("#viewUrl").setAttribute('href',processState.url);
			
			if(processState.convertedToUrl){
				newRow.one("#viewConvertedToUrl").setAttribute('href',processState.convertedToUrl);
				instance.hide(newRow.one("#closeLost"));
			}else{
				instance.hide(newRow.one("#viewConvertedTo"));
			}
			if(processState.convertedFromUrl){
				newRow.one("#viewConvertedFromUrl").setAttribute('href',processState.convertedFromUrl);
			}else{
				instance.hide(newRow.one("#viewConvertedFrom"));
			}
			newRow.setAttribute("data-processId", processState.processId);
			newRow.setAttribute("data-processStateId",processState.processStateId);

			try{
				var styleJson = JSON.parse(processState.style);
				
				if (processState.closedStageStyle){
					styleJson = JSON.parse(processState.closedStageStyle);
				}
			}catch(err ){
				
			}
			
			instance.setStageNodeStyle(newRow.one("#stageStyle"), styleJson);
			
			instance.contextMenu(newRow);
			var assignLink = newRow.one("#assign");
			if(assignLink){
				assignLink.on("click",function(){
					instance.rowClicked = instance.getRowNode(this);
					instance.showAssigneePopup();
				});
			}
			var closeLost = newRow.one("#closeLost");
			var closeWon = newRow.one("#closeWon");

			if(closeLost){
				closeLost.on("click",function(){
					instance.rowClicked = instance.getRowNode(this);
					instance.showClosedLostPopup();
				});
			}

			if(closeWon){
				closeWon.on("click",function(){
					instance.rowClicked = instance.getRowNode(this);
					instance.showClosedWonPopup();
				});
			}
			if(processState.enableCloseWon){
				if(closeWon) instance.show(closeWon);
			}
			if(processState.colsedStageId > 0){
				if(closeLost) closeLost.remove();
				if(closeWon) closeWon.remove();
				if(assignLink) assignLink.remove();
			}
			
			instance.show(newRow);

			//TODO: onclick of this row, load applicant detail screen
			instance.rowContainer.appendChild(newRow);
		}
	}
	this.getRowNode = function(subnode){
		return subnode.ancestor(".Row");
	}
	this.clearSearchResults = function(){
		instance.rowContainer.all(".Row").remove();
	}

	this.setStageNodeStyle = function(node, styleJson) {
		instance.seqNo = instance.seqNo ? instance.seqNo : 1;
		instance.seqNo = instance.seqNo  + 1;
		if (node && styleJson) {
			// preparin css class dynamically
			var name = "class" + instance.seqNo ;
			var css = "." + name + " { background: -moz-radial-gradient(center, circle cover,FROM 0%, TO 100%);" +
					  "background: -webkit-gradient(radial, center center, 0px, center center, 100%, color-stop(0%, FROM), color-stop(100%, TO));" +
					  "background: -webkit-radial-gradient(center, circle cover, FROM 0%, TO 100%);" +
					  "background: -o-radial-gradient(center, circle cover, FROM 0%, TO 100%);" +
					  "background: -ms-radial-gradient(center, circle cover, FROM 0%, TO 100%);" +
					  "background: radial-gradient(center, circle cover, FROM 0%, TO 100%);}" ;
			// /g is global identifier, to replace all occerences of FROM
			css = css.replace(/FROM/g, styleJson.circleColor1);
			css = css.replace(/TO/g, styleJson.circleColor2);
			// create style sheet with above class
			var sheet = A.StyleSheet(css, "styleCustom");
			// we have the class ready now.. just add the class.
			node.addClass(name);
		}
	}
	this.getProcessStateId = function(rowNode) { return rowNode.getAttribute("data-processStateId");}
	this.getProcessId = function(rowNode) { return rowNode.getAttribute("data-processId");}
	
	this.showAssigneePopup = function(){
		var processId = instance.getProcessId(instance.rowClicked);
		if(!instance.newAssigneeDD){
			instance.newAssigneeDD = A.one("#assigneeId");
		}
		var assignedd =  instance.newAssigneeDD;
		assignedd.all("*").remove();
		
		var types = instance.assigneeData[processId] || [];
		AArray.each(types,function(type){
			if (type.id != 0){ // 0 represents Unassigned
				assignedd.append(A.Node.create("<option value=" + type.id + ">" + type.name + "</option>"));
			} 
			
		});
		
		if(!instance.assignPopup){
			var dialog = 	Liferay.Util.Window.getWindow(
					{
						title : 'Assign',
						dialog: {
							bodyContent : A.one("#assignPopup").one("div"),
//							centered : true,
							cache: false,
							close:false,
							height : 250,
							width : 400,
							modal : true,
							constrain2view : true,
							toolbars:{ footer:[{label:'Cancel', on: { click:function() {
								dialog.hide();
							}}},
							{
								label:'Save', 
								on: {click: function() {
									instance.assign();  
								}
								}
							}
							]}
						}}).render();
			instance.assignPopup =dialog;
		}else{
			instance.assignPopup.show();
		}
	}
	
	
	this.assign = function(){
			var contentId =  instance.rowContainer.get('id');
			//preloader
			startPreLoader(contentId);
			var data =   {};
			data.action = "assign";
			data.processStateId = instance.getProcessStateId(instance.rowClicked);
			data.assigneeId = instance.newAssigneeDD.val();
			A.io.request(instance.ajaxUrl,{
				dataType: 'json',
				method: 'POST',
				data: data,
				sync: true,
				on: {
				complete: function() {
					stopPreLoader(contentId);
				},
				success: function() {
					var data=this.get('responseData');
					if (data) {
						if (data.error) {
							alert(data.error);
						}else {
							alert(data.msg);
							if(data.supervisorName) instance.setTextSafe(instance.rowClicked.one("#supervisorName"),data.supervisorName);
							if(data.agentName) instance.setTextSafe(instance.rowClicked.one("#agentName"),data.agentName);							
							instance.assignPopup.hide();
						}
					}else {
						//handle due to some reason data is null
						alert("Error");
					}
				  },
			    failure : function() {
			    	alert("Error");
			    }
				}
			});
	}
	this.changeStatus = function(status){
		var contentId =  instance.rowContainer.get('id');
		//preloader
		startPreLoader(contentId);
		var data =   {};
		data.action = "changeStatus";
		data.processStateId = instance.getProcessStateId(instance.rowClicked);
		data.status = status;
		A.io.request(instance.ajaxUrl,{
			dataType: 'json',
			method: 'POST',
			data: data,
			sync: true,
			on: {
			complete: function() {
				stopPreLoader(contentId);
			},
			success: function() {
				var data=this.get('responseData');
				if (data) {
					if (data.error) {
						alert(data.error);
					}else {
						alert(data.msg);
						instance.searchCriteriaChange();
					}
				}else {
					//handle due to some reason data is null
					alert("Error");
				}
			  },
		    failure : function() {
		    	alert("Error");
		    }
			}
		});
	}
	this.showClosedLostPopup = function(){
		var processId = instance.getProcessId(instance.rowClicked);
		var closedReasondd =  instance.closedReasonId;
		closedReasondd.all("*").remove();
		instance.closedDec.val("");//resetting to blank
		
		var date = new Date();

		var day = date.getDate();
		var month = date.getMonth() + 1;
		var year = date.getFullYear();

		if (month < 10) month = "0" + month;
		if (day < 10) day = "0" + day;

		var today = day + "/" + month + "/" + year;
		document.getElementById('closedLostDate').value  = today;
		
		var types = instance.closedReasons[processId] || [];
		AArray.each(types,function(type){
			closedReasondd.append(A.Node.create("<option value=" + type.id + ">" + type.name + "</option>"));
		});
		
		if(!instance.closedLostPoupup){
			var dialog = 	Liferay.Util.Window.getWindow(
					{
						title : reasonForCloseLostTitle,
						dialog: {
							bodyContent : A.one("#closeAppPopup").one("div"),
//							centered : true,
							cache: false,
							close:false,
							height : 470,
							width : 400,
							modal : true,
							constrain2view : true,
							toolbars:{ footer:[{label:'Cancel', on: { click:function() {
								dialog.hide();instance.closedLostDateDp.hide();
							}}},
							{
								label:'Save', 
								on: {click: function() {
									instance.closeApplication('Lost');  
								}
								}
							}
							]}
						}}).render();
			instance.closedLostPoupup =dialog;
		}else{
			instance.closedLostPoupup.show();
		}
	}
	this.showClosedWonPopup = function(){
		var processId = instance.getProcessId(instance.rowClicked);
		var date = new Date();

		var day = date.getDate();
		var month = date.getMonth() + 1;
		var year = date.getFullYear();

		if (month < 10) month = "0" + month;
		if (day < 10) day = "0" + day;

		var today = day + "/" + month + "/" + year;
		document.getElementById('closedWonDate').value  = today;
		
		
		
		if(!instance.closedWonPoupup){
			var dialog = 	Liferay.Util.Window.getWindow(
					{
						title : reasonForCloseWonTitle,
						dialog: {
							bodyContent : A.one("#closeWonPopup").one("div"),
//							centered : true,
							cache: false,
							close:false,
							height : 250,
							width : 400,
							modal : true,
							constrain2view : true,
							toolbars:{ footer:[{label:'Cancel', on: { click:function() {
								dialog.hide();instance.closedWonDateDp.hide();
							}}},
							{
								label:'Save', 
								on: {click: function() {
									instance.closeApplication('Won');  
								}
								}
							}
							]}
						}}).render();
			instance.closedWonPoupup =dialog;
		}else{
			instance.closedWonPoupup.show();
		}
	}
	
	this.closeApplication = function(closeType){
		var contentId =  instance.rowContainer.get('id');
		//preloader
		startPreLoader(contentId);
		var rowClicked = instance.rowClicked;
		var data =   {};
		data.action = "close";
		data.closedType = closeType;
		data.closedReasonId = instance.closedReasonId.val();
		data.closedDesc = instance.closedDec.val();
		data.processStateId = instance.getProcessStateId(rowClicked);
		if (closeType.toLowerCase() == 'lost'){
			data.closedDate = instance.closedLostDate.val();
		}else{
			data.closedDate = instance.closedWonDate.val();
		}
		
		A.io.request(instance.ajaxUrl,{
			dataType: 'json',
			method: 'POST',
			data: data,
			sync: true,
			on: {
				complete: function() {
					stopPreLoader(contentId);
				},
				success: function() {
					var data=this.get('responseData');
					if (data) {
						if (data.error) {
							alert(data.error);
						}else {
							
							alert(data.msg);
							try{
								rowClicked.one("#closeLost").remove();
								rowClicked.one("#closeWon").remove();
								if(closeType.toLowerCase() == 'lost'){
									instance.closedLostPoupup ? instance.closedLostPoupup.hide():"";
								}else{
									instance.closedWonPoupup ? instance.closedWonPoupup.hide():"";
								}
								
								// updating the row to reflect the change
								var stage = rowClicked.one("#stageName");
								stage.set('text',stage.get('text') + "(" + closeType +")");
								var toolTipText = stage.get("text");
								if(closeType.toLowerCase() == 'lost'){
									toolTipText =  instance.closedReasonId.one("[value="+instance.closedReasonId.val() + "]").get("text");
									if(instance.closedDec.val().length > 0){
										toolTipText = toolTipText + " - " + instance.closedDec.val();
									}
								}
								//var toolTip = rowClicked.one("#tooltip");
								//toolTip.set('text',toolTipText);
								
								try{
									var styleJson = JSON.parse(data.style);
									instance.setStageNodeStyle(rowClicked.one("#stageStyle"), styleJson);
								}catch(err) {

								}

								
							}catch(er){
								console.log(er);
							}
						}
					}else {
						//handle due to some reason data is null
						alert("Error");
					}
				},
				failure : function() {
					alert("Error");
				}
			}
		});
	}
	this.show = function(node) {
		if (node) {
			node.removeClass("hide");
		}
	}
	this.hide = function(node) {
		if (node) {
			node.addClass("hide");
		}
	}
	
	this.dateSelectionChange = function(){
	/*	 var dp = this;
         var calendar = dp.getCalendar();
         var selectionMode = calendar.get('selectionMode');

	     if (dp.get('autoHide') && (dp !== 'multiple')) {
	         dp.hide();
	     } */
	     instance.searchCriteriaChange();
	}
	
	this.datePicker = function(containerId,triggerId){
		var psInstance = instance;
		var datePicker = new A.DatePicker(
				{
					container: '#' + containerId,
					mask: '%d/%m/%Y',
					popover: {
						zIndex: Liferay.zIndex.TOOLTIP
					},
					trigger: '#' + triggerId
				}
			);
			var calendar = datePicker.getCalendar();
			calendar.after('dateClick', psInstance.dateSelectionChange, datePicker);
			instance[triggerId+"Dp"] = datePicker;
	}
	this.datePickerCloseApplication = function(containerId,triggerId){
		var psInstance = instance;
		var datePickerCloseApplication = new A.DatePicker(
				{
					container: '#' + containerId,
					mask: '%d/%m/%Y',
					popover: {
						zIndex: Liferay.zIndex.TOOLTIP
					},
					trigger: '#' + triggerId
				}
			);
			var calendar = datePickerCloseApplication.getCalendar();
			instance[triggerId+"Dp"] = datePickerCloseApplication;
	}
	/*this.initDateIconClick = function(){
		// start date
		A.one("#startDateIcon").on("click",function(){
			instance["startDateDp"].show();
		});
		A.one("#endDateIcon").on("click",function(){
			instance["endDateDp"].show();
		});
	} */
	this.init(config);
}
