function trademarksSearch(config){
	// ID'S SECTION
	
	//Search dropdown - contains all search fields
	var SEARCH_FIELD_ID = "searchField";
	//Search textbox - displayed when selected search field is  text type
	var SEARCH_VALUE_ID = "searchValue";
	var SEARCH_VALUE_DIV_ID ="searchFieldTextDiv";
	var COUNTER = "counter";
	
	//Used to create json object
	var JSON_SEARCH_FIELD_ID = "searchField";
	var JSON_SEARCH_VALUE_ID = "searchValue";
	var JSON_SEARCH_FROM = "searchFrom";
	var JSON_SEARCH_TO = "searchTo";
	
	var CRITERIA_ROW = "searchCriteriaRow";
	var SEARCH_CONTAINER_ID = "searchContainer";
	var LINK_ADD_CRITERIA_ID = "addCriteria";  
	var LINK_REMOVE_CRITERIA_ID = "removeCriteria";
	var QUERY_SEARCH_CRITERIAS = "#searchContainer #searchCriteriaRow";
	var QUERY_SEARCH_CRITERIA_TO_CLONE = "#hiddenCriteriaRow #searchCriteriaRow";
	var SEARCH_BUTTON_ID = "submitSearch";
	var SEARCH_JSON_ID = "searchQueryJson";
	var SEARCH_FORM_ID = "searchForm";
	var DATE_RANGE_DIV_ID = "dateRangeSection";
	var FROM_DATE = "fromDate";
	var FROM_YEAR = "fromYear";
	var FROM_MONTH = "fromMonth";
	var FROM_DAY = "fromDay";
	var TO_YEAR = "toYear";
	var TO_MONTH = "toMonth";
	var TO_DAY = "toDay";
	var TO_DATE = "toDate";
	
	var DATE_SPR = "/"; 
	
	var PNS  = ""
	var	ajaxUrl = "";	

	var counter = 1000;
	
	 function initializeSearch(config){
		PNS = config.pns;
		ajaxUrl = config.ajaxUrl;
		SEARCH_FIELD_ID = PNS + SEARCH_FIELD_ID;
		SEARCH_VALUE_ID = PNS + SEARCH_VALUE_ID;
		SEARCH_JSON_ID = PNS + SEARCH_JSON_ID;
		SEARCH_BUTTON_ID = PNS + SEARCH_BUTTON_ID;
		SEARCH_FORM_ID = PNS + SEARCH_FORM_ID;
		COUNTER = PNS + COUNTER;
		
		FROM_YEAR = PNS + FROM_YEAR;
		FROM_MONTH = PNS + FROM_MONTH;
		FROM_DAY = PNS + FROM_DAY;
		FROM_DATE = PNS + FROM_DATE;
		

		TO_YEAR = PNS + TO_YEAR;
		TO_MONTH = PNS + TO_MONTH;
		TO_DAY = PNS + TO_DAY;
		TO_DATE = PNS + TO_DATE;
		
		
		
		AUI().use('aui-node','aui-base', function(A){
			initializeSearchCrtiterias(A.one("#"+SEARCH_JSON_ID).val());
		});
		initalizeSubmitSearch();
		initializeExport();
	};
	
	function initalizeSubmitSearch(){
		AUI().use('aui-node','aui-base', function(A){
			A.one("#"+SEARCH_BUTTON_ID).on("click",function(){
				setJsonToHiddenField(A);
				A.one("#" + SEARCH_FORM_ID).submit();
			});
		});
	}
	function setJsonToHiddenField(A){
		A.one("#" + SEARCH_JSON_ID).val(getSearchJsonString());
	}
	function getSearchJsonString(){
		var json = createSearchJson();
		return JSON.stringify(json);
	}
	function initializeSearchCrtiterias(searchJsonStr){
		var searchJson= JSON.parse(searchJsonStr?searchJsonStr:null);
		if(searchJson && searchJson.length > 0 ){
			var json;
			for(var i = 0; i < searchJson.length; i++){
				json = searchJson[i];
				var criteria = cloneCriteria();
				criteria.one("#" + SEARCH_FIELD_ID).val(json[JSON_SEARCH_FIELD_ID]);
				
//				criteria.one("#" + json[JSON_SEARCH_FIELD_ID]).val(json[JSON_SEARCH_VALUE_ID]);
				showSearchField(false,criteria,json[JSON_SEARCH_FIELD_ID],json[JSON_SEARCH_VALUE_ID],json[JSON_SEARCH_FROM],json[JSON_SEARCH_TO]);
				registerSFChangeListener(criteria);
			}
			}else{
				AUI().use('aui-node','aui-base','aui-io-request-deprecated',function(A){
					//Seems no criterias, let's create first one. 
					addCriteria(false);
				});
			}
	}
	
	function cloneCriteria() {
		
		var clonedNode = {};
		var A = AUI().use('aui-node','aui-base','aui-io-request-deprecated');

		var sampleCont = A.one( QUERY_SEARCH_CRITERIA_TO_CLONE);
		var dup = sampleCont.clone();
		var inputs = dup.all("input, select");
		inputs.each(function(inp) {
			try {
				inp.val("");
			}catch (err) {
				console.log(err);
			}
		});
		var container = A.one("#" + SEARCH_CONTAINER_ID);
		dup.appendTo(container);
		var criterias = A.all(QUERY_SEARCH_CRITERIAS);
		//First row will have add criteria button, other rows will have remove option
		if(criterias.size() > 1){
			// 2nd row onwards
			var removeNode = dup.one("#" + LINK_ADD_CRITERIA_ID);
			
			removeNode.set('id', LINK_REMOVE_CRITERIA_ID);
			removeNode.setContent("-");
			removeNode.on("click",function(){
				dup.remove();
			});
		}else{
			//First row
			var addNode = dup.one("#" + LINK_ADD_CRITERIA_ID);
			addNode.on("click",function(){
				addCriteria(true);
			});
		}
		
		dup.one("#" + COUNTER).val(counter);
		try{
			// initialize calendar icon
			// When cloning date picker, below steps have to be done to assign unique id's to each field (month,year,day, datapicker etc.)
			/*** From Date **/
			var datePickerN = dup.one("#fromDateDiv .lfr-input-date");
			var dpcontent =  dup.one("#" + FROM_DATE);

			var dpId = "fromdisplayDate" + counter;
			var dpcId = FROM_DATE + counter;
			datePickerN.set("id",dpId);
			dpcontent.set("id",dpcId);
			
			var dayId = FROM_DAY + counter;
			var monthId = FROM_MONTH + counter;
			var yearId = FROM_YEAR +  counter;
			dup.one("#" + FROM_DAY).set('id',dayId);
			dup.one("#" + FROM_MONTH).set('id',monthId);
			dup.one("#" + FROM_YEAR).set('id',yearId);
			
			

			calenderHandler(dpId,dpcId, dayId, monthId,yearId);
			
			/** To Date */
			 datePickerN = dup.one("#toDateDiv .lfr-input-date");
			 dpcontent =  dup.one("#" + TO_DATE);

			 dpId = "todisplayDate" + counter;
			 dpcId = TO_DATE + counter;
			 datePickerN.set("id",dpId);
			 dpcontent.set("id",dpcId);
			
			dayId = TO_DAY + counter;
			monthId = TO_MONTH + counter;
			yearId = TO_YEAR +  counter;
			dup.one("#" + TO_DAY).set('id',dayId);
			dup.one("#" + TO_MONTH).set('id',monthId);
			dup.one("#" + TO_YEAR).set('id',yearId);
			
			

			calenderHandler(dpId,dpcId, dayId, monthId,yearId);
			
		}catch(err){
			console.log(err);
		}
		counter = counter + 1;
		clonedNode = dup; 
	
		return clonedNode;
	 }
	
	function addCriteria(onclick){
		
		var criteria = cloneCriteria();
		criteria.one("#" + SEARCH_FIELD_ID).val("");
		
		/*YUI().use('event-hover','node', 'transition', 'event', 'animation', function (Y) {
			
			var criteriaHeight = criteria.get('offsetHeight');
			var searchSectionHeight = Y.one('.esn_searchSection_content').get('offsetHeight');
			
			
			Y.one('.esn_searchSection').transition({
				easing: 'ease-out',
				height: criteriaHeight + searchSectionHeight + 'px',
				duration: 0.5
			});
			
			temp_search_content_height = criteriaHeight + searchSectionHeight + 'px';
			
		});*/
		
		showSearchField(onclick, criteria);
		registerSFChangeListener(criteria);
	}
	
	function hideAllFields(criteria){
		AUI().use('aui-node','aui-base',function(A){
			hideSearchDds(criteria);
			hideSearchTextField(criteria);
			hideDateRangeField(criteria);
		});
	}
	function hideSearchTextField(criteria){
		if(criteria){
			criteria.one("#" + SEARCH_VALUE_DIV_ID).setStyle('display','none');
		}
	}
	function showSearchTextField(criteria){
		if(criteria){
			criteria.one("#" + SEARCH_VALUE_DIV_ID).setStyle('display','inline-block');
		}
	}
	function hideDateRangeField(criteria){
		if(criteria){
			criteria.one("#" + DATE_RANGE_DIV_ID).setStyle('display','none');
		}
	}
	function showDateRangeField(criteria){
		if(criteria){
			criteria.one("#" + DATE_RANGE_DIV_ID).setStyle('display','inline-block');
		}
	}
	function setDate(criteria,type,dateStr){
		if(criteria){
			if(dateStr && dateStr != ""){
				try{
					var tempc = criteria.one("#"+COUNTER).val();
					if(dateStr.indexOf("/") > 0){
						var day  = dateStr.substring(0,dateStr.indexOf(DATE_SPR))
						var month  = dateStr.substring(dateStr.indexOf(DATE_SPR)+1,dateStr.lastIndexOf(DATE_SPR));
						var year  = dateStr.substring(dateStr.lastIndexOf(DATE_SPR)+1);
						if(type == JSON_SEARCH_FROM){
							criteria.one("#" + FROM_DATE + tempc).val((parseInt(month)+1)+"/"+day+"/"+year);
							criteria.one("#" + FROM_DAY + tempc).val(day);
							criteria.one("#" + FROM_MONTH + tempc).val(month);
							criteria.one("#" + FROM_YEAR + tempc).val(year);
							
						}else{
							criteria.one("#" + TO_DATE + tempc).val((parseInt(month)+1)+"/"+day+"/"+year);
							criteria.one("#" + TO_DAY + tempc).val(day);
							criteria.one("#" + TO_MONTH + tempc).val(month);
							criteria.one("#" + TO_YEAR + tempc).val(year);
						}
					}else{
						// year alone present.
						if(type == JSON_SEARCH_FROM){
							criteria.one("#" + FROM_YEAR + tempc).val(dateStr);
						}else{
							criteria.one("#" + TO_YEAR + tempc).val(dateStr);
						}
					}
				}catch(err){
					
				}
			}
			criteria.one("#" + DATE_RANGE_DIV_ID).setStyle('display','inline-block');
		}
	}
	
	function showListField(criteria,listFieldId,val){
		try{
			var sf = criteria.one("#" + listFieldId);
			//sf.setStyle('display','inline-block');
			sf.val(val);
			sf.ancestor(".control-group").setStyle('display','inline-block');
		}catch(error){
			
		}
		

	}
	function showSearchField(onclick, criteria,selectedSF,searchVal,fromVal,toVal){
		AUI().use('aui-node','aui-base',function(A){
			
			if (onclick) {
				A.one('.esn_searchSection').setStyle('height', 'auto');
			}
			
			if(selectedSF){
				var tid =    PNS +  selectedSF;
				//dropdowns
				if(selectedSF.indexOf('list_', 0) == 0){
					hideSearchDds(criteria);
			/*		var sf = criteria.one("#" + tid);
					sf.setStyle('display','inline-block');
					sf.val(searchVal); */
					showListField(criteria,tid,searchVal);
					hideSearchTextField(criteria);
					hideDateRangeField(criteria);
				}else if(selectedSF.indexOf('date_', 0) == 0){
					//Date type
					criteria.one("#" + SEARCH_VALUE_ID).val(searchVal);
					setDate(criteria,JSON_SEARCH_FROM,fromVal);
					setDate(criteria,JSON_SEARCH_TO,toVal);
					showDateRangeField(criteria);
					hideSearchDds(criteria);
					hideSearchTextField(criteria);
				}else{
					//text field type
					criteria.one("#" + SEARCH_VALUE_ID).val(searchVal);
					showSearchTextField(criteria);
					hideSearchDds(criteria);
					hideDateRangeField(criteria);
				}
			}else{
				hideSearchTextField(criteria);
				hideSearchDds(criteria);
				hideDateRangeField(criteria);
			}
		});
	}
	
	function registerSFChangeListener(criteria){
		AUI().use('aui-node','aui-base',function(A){
			criteria.one("#" + SEARCH_FIELD_ID).on("change",function(){
		        var value = this.get('value');
		        showSearchField(true, criteria,value);
			});
		});
	}

	function createSearchJson() {
		
		var criteriaRow = "searchCriteriaRow";
		var json = {};
		var creteriasJson = [];
		var A = AUI().use('aui-node','aui-base','aui-io-request-deprecated');

		
		var criterias = A.all(QUERY_SEARCH_CRITERIAS);
		criterias.each(function(criteria){
			json = {};
			var searchField = criteria.one("#" + SEARCH_FIELD_ID);
			var selectedSF = searchField.val();
			json[JSON_SEARCH_FIELD_ID] = selectedSF;
			if(selectedSF.indexOf('list_', 0) == 0){
				//dropdown type
				var tid =  PNS + selectedSF;
		        var dobj = criteria.one("#" + tid);
		        if(dobj){
		        	//dropdown type search criteria
		        	json[JSON_SEARCH_VALUE_ID] = dobj.val();
		        }
				
			}else if(selectedSF.indexOf('date_', 0) == 0){
				//date type
				
				var tempc = criteria.one("#"+COUNTER).val();
				//From Date
				var fromYear = criteria.one("#" + FROM_YEAR + tempc).val();
				var fromMonth = criteria.one("#" + FROM_MONTH + tempc).val();
				var fromDay = criteria.one("#" + FROM_DAY + tempc).val();
				
				var fromDate = fromYear;
				if(fromMonth != "" && fromDay != "" && fromYear != ""){
					fromDate = fromDay + DATE_SPR + fromMonth + DATE_SPR + fromYear;
				}
				
				//To Date
				var toYear = criteria.one("#" + TO_YEAR + tempc).val();
				var toMonth = criteria.one("#" + TO_MONTH + tempc).val();
				var toDay = criteria.one("#" + TO_DAY + tempc).val();
				
				var toDate = toYear;
				if(toYear != "" && toDay != "" && toMonth != ""){
					toDate = toDay + DATE_SPR + toMonth + DATE_SPR + toYear;
				}
				
				json[JSON_SEARCH_FROM] = fromDate;
				json[JSON_SEARCH_TO] = toDate;
				
			}else{
				// text field type
				json[JSON_SEARCH_VALUE_ID] = criteria.one("#" + SEARCH_VALUE_ID).val();
			}
		    
	        creteriasJson.push(json);
		});
	
		return creteriasJson;
	}

	function hideSearchDds(criteria){
		var sfId = "#" + PNS + "searchField";
		if(criteria){
			AUI().use('node','event',function(A){
				var opts = criteria.all( sfId + " option");
				if(opts){
					opts.each(function(opt,indx){
						var optval = opt.get('value');
						var listId = "#" + PNS +  optval;
						var listObj = criteria.one(listId);
						if(listObj){
							try{
							//	listObj.setStyle('display','none');
								listObj.ancestor(".control-group").setStyle('display','none');								
							}catch(error){
								
							}
						}
					});
				}
			});
		}
	}
	function initializeSearchCriteria(criteria){
		var sfId = "#" + PNS + "searchField";
		AUI().use('node','event',function(A){
			hideSearchDds(criteria);
			var  sopt = criteria.one(sfId + " option[selected]");
			if(sopt){
				var optval = sopt.get('value');
				var listId = "#" + PNS + "list_" +  optval;
				var valId = "#" + PNS + "searchValue";
				var listObj = criteria.one(listId);
				if(listObj){
					listObj.setStyle('display','inline-block');
					criteria.one(valId).setStyle('display','none');
				}else{
					criteria.one(valId).setStyle('display','inline-block');
				}
			}
		});
	};
	function calenderHandler(datePickerId,nameId, dayParam, monthParam,yearParam){

		
		AUI().use('aui-datepicker', function(A) {
			Liferay.component(
					nameId ,
					function() {
						var datePicker = new A.DatePicker(
							{
								container: '#' + datePickerId,
								mask: '%m/%d/%Y',
								on: {
									disabledChange: function(event) {
										var instance = this;

										var container = instance.get('container');

										var newVal = event.newVal;

										container.one('#' + dayParam).attr('disabled', newVal);
										container.one('#' + monthParam).attr('disabled', newVal);
										container.one('#' + nameId).attr('disabled', newVal);
										container.one('#' + yearParam).attr('disabled', newVal);
									},
									selectionChange: function(event) {
										var instance = this;

										var container = instance.get('container');

										var date = event.newSelection[0];
										var dateVal = container.one('#' + nameId).val();
										try{
											 if(dateVal && dateVal.trim()!="" && dateVal.indexOf("/") == -1){
												 date.setYear(parseInt(dateVal));
												 date.setDate(1);
												 date.setMonth(0);
											 }
										}catch(err){
											console.error(err);
										}
										if (date) {
											container.one('#' + dayParam).val(date.getDate());
											container.one('#' + monthParam).val(date.getMonth());
											container.one('#' + yearParam).val(date.getFullYear());
										}else{
											container.one('#' + dayParam).val('0');
											container.one('#' + monthParam).val('-1');
											container.one('#' + yearParam).val('0');
											alert();
										}
									}
								},
								  header: [[
			              {
			                icon:'icon-trash',
			                label: 'Clear',
			                on: {
			                  click: function() {
			                    datepicker.clearSelection();
			                  }
			                }
			              }]],

								popover: {
									zIndex: Liferay.zIndex.TOOLTIP
								},
								trigger: '#' + nameId
							}
						);

						datePicker.getDate = function() {
							var instance = this;

							var container = instance.get('container');

							return new Date(container.one('#' + yearParam).val(), container.one('#' + monthParam).val(), container.one('#' + dayParam).val());
						};

						return datePicker;
					}
				);
				Liferay.component(nameId );
		});
		
		

	};
	
	/** PDF, ExCEl   Exports */
	function initializeExport(){
		var func = function(event){
			AUI().use('aui-node','aui-base','aui-io-request-deprecated', function (A){
				var exptype = '';
				if(event.target.get('id') == PNS + "export")
					exptype = 'exportListPdf';
				else 
					exptype = 'exportListXls';
				var dataObj = {
						action: exptype
				};
				
				dataObj[SEARCH_JSON_ID] = getSearchJsonString();
				
				A.io.request(ajaxUrl,{
					dataType : 'json',
					method : 'POST',
					data : dataObj,
					on : {
						success : function() {
							var data = this.get('responseData');
							if(data && data.errorMsg){
								alert(data.errorMsg);
							}else{
								document.location.href = "/LegalAndContract-portlet/download?fileName=" + data.fileName ;
							}
						},
						failure : function(){
							var data = this.get('responseData');
							if(data && data.errorMsg){
								alert(data.errorMsg);
							}else{
								alert("Error while generating the report");
							}
						}
					}
				});
				
			});
			
		};
		
		AUI().use('aui-node','aui-base',function(A){
			var buttonId = "#" + PNS + "export";
			var buttonXlsId = "#" + PNS + "exportXls";
			var exportObj = A.one(buttonId);
			var exportXlsObj = A.one(buttonXlsId);
			
			if(exportObj){
				exportObj.on("click", func);
			}
			
			if(exportXlsObj) {
				exportXlsObj.on("click", func);
			}
			
		});
	};
		
	
	initializeSearch(config);
}




