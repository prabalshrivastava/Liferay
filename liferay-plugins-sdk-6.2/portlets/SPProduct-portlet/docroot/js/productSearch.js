var productSearch = function(config){
	var instance = null;
	this.init = function(config){
		instance = this;
		
		instance.start = 0;
		instance.pageSize = 10;
		instance.sampleRow = config.sampleRow;
		instance.rowContainer = config.rowContainer;
		instance.productUpdatebox = config.productUpdatebox;
		//instance.start = config.start;
		//instance.pageSize = config.pageSize;
		instance.loadMoreNode = config.loadMoreNode; 
		instance.viewResultsText = config.viewResultsText;
		instance.resultCount = config.resultCount;
		
		instance.renderRowMethod = config.renderRowMethod;
		instance.reqUrl = config.reqUrl;
		instance.searchText = config.searchText;
		instance.startDate = config.startDate;
		instance.endDate = config.endDate;
		instance.actionMethod = config.actionMethod;
		instance.moreResult = config.moreResult;
		instance.noMoreResult = config.noMoreResult;
		instance.search();
		instance.initializeEnterKeySearch();
		instance.initializeTextSearch();
		instance.datePicker("startDateContainer","startDate");
		instance.datePicker("endDateContainer","endDate");
	}
	
	this.datePicker = function(containerId,triggerId){
		AUI().use('aui-node','aui-base','aui-io-request', 'aui-datepicker', function(A){
		var datePicker = new A.DatePicker(
				{
					container: '#' + containerId,
					mask: '%m/%d/%Y',
					popover: {
						zIndex: Liferay.zIndex.TOOLTIP
					},
					trigger: '#' + triggerId
				}
			);
			var calendar = datePicker.getCalendar();
			calendar.after('dateClick', instance.dateSelectionChange, datePicker);
			instance[triggerId+"Dp"] = datePicker;
		});
		}

	this.dateSelectionChange = function(){
		instance.searchCriteriaChange();
		}
	
	this.initializeTextSearch = function(){
		A.one("#textSearchButton").on("click",function(){
			
			instance.searchCriteriaChange();
		});
	}

	this.clearSearchResults = function(){
		instance.rowContainer.all(".Row").remove();
	}
	
	this.populateRequestData = function(data){
		data = data || {} ;
		data.searchText = searchText.val();
		data.startDate = startDate.val();
		data.endDate = endDate.val();
	}
	
	this.initializeLoadMore = function(){
		instance.loadMoreNode.on("click",function() {
			// in this case search criteria remains same so searchCriteriaChanged = false
			instance.search();
		});
		
	}
	
	this.renderProducts = function(products){
		var AArray = A.Array;
		if (!products) {
			return;
		}
		// iterate  array and create  row for each product json object
		AArray.each(products, function(product) {
			//renderProduct(products);
			instance.renderRowMethod(product);
		});
		
	}

	this.hide = function(node){
		if (node) {
			node.addClass("hide");
		}
	}
	
	this.setClass = function(){
		productUpdatebox.on("click",function() {
			newRow.one("#productUpdatebox").setAttribute('class', 'productUpdatebox');
		});
		
	}
	
	this.initializeEnterKeySearch = function(){
		var nodes = [searchText,startDate,endDate];
		var nodeList = new A.NodeList(nodes);
		nodeList.on("keypress",function(ev){
			// click on enter
			if(ev.keyCode ==  13){
				instance.searchCriteriaChange();
			}
		});
	}
	
	this.searchCriteriaChange = function(){
		var data = {};
		data.searchCriteriaChanged = true;
		instance.search(data);
	}
	
	this.search = function(data){
		if (instance.requestUnderProcess) {
			return;
		}
		instance.requestUnderProcess = true;
		
		startPreLoader("mainContainer");
		data = data || {};
		data.action = instance.actionMethod
		if(data.searchCriteriaChanged){
			instance.start = 0;
		}
		data.start = instance.start;
		data.pageSize = instance.pageSize;
		instance.populateRequestData(data);
		
		A.io.request(instance.reqUrl, {
			dataType : 'json',
			method : 'POST',
			data : data,
			on : {
				complete : function() {
					instance.requestUnderProcess = false;
					stopPreLoader("mainContainer");
					if(data.searchCriteriaChanged){
	            		// since it's fresh search, clear the existing results
						instance.clearSearchResults();
	            	}
				},
				success : function() {
					var data = this.get('responseData');
					if (data) {
						if (data.error) {
							alert(data.error);
						} else {
							instance.resultCount.html(data.resultCountText);
							// move the cursor
							instance.start =  instance.start + instance.pageSize;
							var totalResult = data.resultCountText.substring(0,data.resultCountText.indexOf(" "));
							// check if there are more rows to load or not.
							if (data.products.length == 0
									|| instance.start >= totalResult) {
								try {
									instance.viewResultsText.html(
											instance.noMoreResult + " ("+totalResult+" out of "+totalResult+")");
									instance.loadMoreNode.detach("click");

								} catch (err) {

								}
							} else {
								// initialize it.... as there are more rows to load
								instance.initializeLoadMore();
								instance.viewResultsText.html(
										instance.moreResult + " ("+instance.start+" out of "+totalResult+")"); 
							}
							// success response - render the process states
							instance.renderProducts(data.products);
						}
					} else {
						//handle due to some reason data is null
						alert("Error while displaying the products");
					}
				},
				failure : function() {
					alert("System error.");
				}
			}
		});
	}
		
	this.init(config);
}