var linkedSearchConfig = function(config){
	var instance = null;
	var SINGLE = "single";
	var MULTIPLE = "multiple";
	this.init = function(config){
		this.pns = config.pns;
		this.levelsData = config.levelsData;
		this.ivdFiltersData = config.ivdFiltersData;
		this.ajaxUrl = config.ajaxUrl;
		this.linkedFilterVocNode = A.one("#" + this.pns + "linkedFilterVocId");
		this.levelsContainer  = A.one("#levelsContainer");
		this.filtersContainer  = A.one("#filtersContainer");
		instance = this;
		instance.counter  = 0;
		instance.linkedFilterVocNode.on("change",function(){
			instance.getMaxSubLevel();
		});
		A.one("#addFilter").on("click",function(){
			instance.addFilter();
		});
		instance.addLevelRowsUsingData(instance.levelsData);
		instance.addFilterRowsUsingData(instance.ivdFiltersData);
	}
	this.addFilterRowsUsingData = function(filtersData){
		if(filtersData){
			A.Array.each(filtersData,function(filterData){
				instance.addFilter(filterData);
			});
		}
	}
	this.addFilter = function(filterData){
		var newFilter = A.one("#sampleFilter").cloneNode(true);
		newFilter.set("id","filter");
		instance.filtersContainer.appendChild(newFilter);
		
		//Remove
		newFilter.one("#remove").on("click",function(){
			this.ancestor("#filter").remove();
		});
		// on type change
		newFilter.one("#type").on("change",function(){
		   var parent = this.ancestor("#filter");
		   var container = parent.one("#displayHeaderContainer");
		   instance.showHideHeaderOption(this.val(),container);
		});
		// populating the data if it exists
		if(filterData){
			instance.populateFilterData(newFilter,filterData);
		}
		// must be called after populating the data
		instance.showHideHeaderOption(newFilter.one("#type").val(),newFilter.one("#displayHeaderContainer")); 
	}
	this.showHideHeaderOption = function(value,container){
		if(value == SINGLE){
			   instance.show(container);
		   }else{
			   instance.hide(container);
		   }
	}
	this.populateFilterData = function(filterNode,filterData){
		filterNode.all("input,select").each(function(node){
			node.val(filterData[node.get('id')]);
			instance.checkboxSet(node,filterData[node.get('id')]);
		});
	}
	this.getJsonFilters = function(){
		var array = [];
		instance.filtersContainer.all("#filter").each(function(filter){
			var temp = {};
			filter.all("input,select").each(function(node){
				temp[node.get('id')] = node.val();
				
				if(node.get("type") == "checkbox"){
					temp[node.get('id')] = node.get("checked");
				}
			});
			array.push(temp);
		});
		return array;
	}
	this.getMaxSubLevel = function(){
		var contentId =  'formContainer';
		//preloader
		startPreLoader(contentId);
		var data = {};
		data.action = "getMaxSubLevel";
		data.vocId = instance.linkedFilterVocNode.val();
		A.io.request(instance.ajaxUrl,{
            dataType: 'json',
            method: 'POST',
            data: data,
            on: {
            complete: function(){
            	// this is called before success and failure methods. So right place for any post processing of request.
            	stopPreLoader(contentId);
            },
            success: function() {
                var data=this.get('responseData');
                if(data){
                	if(data.error){
                		alert(data.error);
                	}else{
                		instance.addLevelRowsUsingCount(data.maxLevel);
                	}
                }else{
                	//handle due to some reason data is null
                	alert("Error while fetching Maximum sub level for selected Vocabulary");
                }
              },
		    failure : function(){
		    	alert("Error while fetching Maximum sub level for selected Vocabulary");
		    }
            }
        });
	}
	this.cleanup = function(){
		instance.counter = 0;
		instance.levelsContainer.all("*").remove();
	}
	// items is array containing data for each level
	this.addLevelRowsUsingData = function(items){
		instance.cleanup();
		if(items){
			A.Array.each(items,function(item){
				instance.addLevelRow(item);
			});
		}
	}
	// count = no of levels to add
	this.addLevelRowsUsingCount = function(count){
		instance.cleanup();
		for(var i = 1 ; i <= count ; i++){
			instance.addLevelRow();
		}
	}
	
	this.addLevelRow = function(data){
	   instance.counter = instance.counter + 1;
	   var sample = A.one("#sampleLevel");
	   var newRow = sample.cloneNode(true);
	   newRow.set("id","level");
	   newRow.one("#name").val("Level " + instance.counter);
	   newRow.one("#levelNo").val( instance.counter);
	   
	   // on filter type change
	   newRow.one("#type").on("change",function(){
		   var parent = this.ancestor("#level");
		   var container = parent.one("#displayHeaderContainer");
		   
		   instance.showHideHeaderOption(this.val(),container);
	   });
	   instance.levelsContainer.appendChild(newRow);
	  
	   // populate the data if it exists
	   if(data){
		   instance.populateLevel(newRow, data);
	   }
	   instance.showHideHeaderOption(newRow.one("#type").val(),newRow.one("#displayHeaderContainer"));
	   instance.show(newRow);
	}
	this.populateLevel = function(level,data){
		if(data && level){
			level.all("input,select").each(function(node){
				node.val(data[node.get('id')]);
				instance.checkboxSet(node,data[node.get('id')]);
			});
			level.one("#levelSpan").setContent(data['levelNo']);
		}
	}
	this.getJsonLevels = function(){
		var instance = this;
		var array = [];
		instance.levelsContainer.all("#level").each(function(level){
			var temp = {};
			level.all("input,select").each(function(node){
				temp[node.get('id')] = node.val();
				if(node.get("type") == "checkbox"){
					temp[node.get('id')] = node.get("checked");
				}
			});
			array.push(temp);
		});
		return array;
	}
	
	this.onSubmit = function(){ // called from form onsubmit
		var data = JSON.stringify(instance.getJsonLevels());
		A.one("#"+ instance.pns  + "levelsData").val(data);
	
		var filtersData = JSON.stringify(instance.getJsonFilters());
		A.one("#"+ instance.pns  + "ivdFiltersData").val(filtersData);
		var formNode = A.one("#" + instance.pns + "fm");
		submitForm(formNode.get('id'),formNode.get('action'),true,true);
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
	this.checkboxSet = function(node,chk){
		if(node && node.get("type") == "checkbox"){
			if(chk == true){
				node.set("checked",true);
			}
		}
	}
	this.init(config);
}
