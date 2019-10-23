var ProductConfig = function(config){
	
	this.init = function(config){
		this.pns = config.pns;
		this.levelsData = config.levelsData;
		this.ajaxUrl = config.ajaxUrl;
		this.errorMsg = config.errorMsg;
		this.vocbNode = A.one("#" + this.pns + "vocIdSpecialization");
		this.pVocbNode = A.one("#" + this.pns + "personaVocIdSpecialization");
		this.levelsContainer  = A.one("#levelsContainer");
		var instance = this;
		instance.counter  = 0;
		instance.vocbNode.on("change",function(){
			instance.getMaxSubLevel();
		});
		instance.addLevelRowsUsingData(instance.levelsData);
	}
	this.getMaxSubLevel = function(){
		var instance = this;
		var contentId =  'formContainer';
		//preloader
		startPreLoader(contentId);
		var data = {};
		data.action = "getMaxSubLevel";
		data.vocId = instance.vocbNode.val();
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
                	alert(instance.errorMsg);
                }
              },
		    failure : function(){
		    	alert(instance.errorMsg);
		    }
            }
        });
	}
	this.cleanup = function(){
		var instance = this;
		instance.counter = 0;
		instance.levelsContainer.all("*").remove();
	}
	// items is json object containing data for each level
	this.addLevelRowsUsingData = function(data){
		var instance = this;
		instance.cleanup();
		if(data){
			A.each(data,function(value,key){
				instance.addLevelRow(value);
			});
		}
	}
	// count = no of levels to add
	this.addLevelRowsUsingCount = function(count){
		var instance = this;
		instance.cleanup();
		for(var i = 1 ; i <= count ; i++){
			instance.addLevelRow();
		}
	}
	
	this.addLevelRow = function(data){
	   var instance = this;
	   if(data){
		   instance.counter = data.levelNo;
	   }else{
		   instance.counter = instance.counter + 1;
	   }
	   var sample = A.one("#sampleLevel");
	   var newRow = sample.cloneNode(true);
	   newRow.set("id","level");
	   newRow.one("#levelSpan").setContent("Include Level " +  instance.counter + " Categories");
	   newRow.one("#levelNo").val( instance.counter);
	   instance.levelsContainer.appendChild(newRow);
	   if(data){
		   instance.populateLevel(newRow, data);
	   }
	   instance.show(newRow);
	}
	this.populateLevel = function(level,data){
		if(data && level){
			level.all("input,select").each(function(node){
				node.val(data[node.get('id')]);
			});
			var incLvlVal = data["includeLevel"];
			level.one("#includeLevel").set("checked",incLvlVal);
		}
	}
	this.getLevelsDataAsJson = function(){
		var instance = this;
		var levelsData = {};
		instance.levelsContainer.all("#level").each(function(level){
			var temp = {};
			level.all("input,select").each(function(node){
				temp[node.get('id')] = node.val();
			});
			temp["includeLevel"] = level.one("#includeLevel").get("checked");
			
			// key is level no
			levelsData[level.one("#levelNo").val()] = temp;
		});
		return levelsData;
	}
	
	this.onSubmit = function(){ // called from form onsubmit
		var instance = this;
		var data = JSON.stringify(instance.getLevelsDataAsJson());
		A.one("#"+ instance.pns  + "levelsData").val(data);
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
	this.init(config);
}