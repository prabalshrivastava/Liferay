var learingDetails = function(config){
	this.init = function(config){
		this.pns = config.pns;
		this.courseId = config.courseId;
		this.linkUrl = config.linkUrl;
		this.data = config.data;
		this.ajaxUrl = config.ajaxUrl;
		this.deleteError = config.deleteError;
		this.durationRemoved = config.durationRemoved;
		this.processError = config.processError;
		this.durationDelete = config.durationDelete;
		this.learningUpdate = config.learningUpdate;
		
		this.msgNode = A.one("#msgContainer");
		this.introEdId = this.pns + "introEditor";
		this.option1EdId = this.pns + "option1Editor";
		this.option2EdId = this.pns + "option2Editor";
		this.noteEdId = this.pns + "noteEditor";
		this.optionTitleNode = A.one("#" +  "optionTitle");
		
		// duration related
		this.durationTitleNode = A.one("#" +  "durationTitle");
		this.durationContainerNode = A.one("#" + "durationTypeInner");
		this.durationTypeNode = A.one("#" + "durationTypeWrapper_1");
		this.counterDurationType = 1; // changing this value will impact everywhere including server side
		this.initSave();
		this.initAddDuration();
		this.createDurationTypes(config.durationTypes);
	}
	this.initAddDuration = function(){
		var instance = this;
		A.one("#addDuration").on("click",function(){
			instance.addDuraitonRow();
		});
	}
	this.addDuraitonRow = function(){
		var instance = this;
		// clone the first row
		var cloned = instance.durationTypeNode.clone();
		// increment counter - identified each durationType uniquely -- this must be happen before doing any other action ater cloning
		instance.counterDurationType = instance.counterDurationType + 1;
		// set unique ids
		instance.setIds(cloned);
		// reset to default values
		instance.setDefaults(cloned);
		
		cloned.one("#close").setAttribute("data-counter", instance.counterDurationType);
		// close icon handler
		cloned.one("#close").on("click",function(){
			var counter = this.getAttribute("data-counter");
			instance.removeDurationType(counter);
		});
		instance.durationContainerNode.append(cloned);
		return cloned;
	}
	// utility method returns the html tag id for durationTypeId hidden field 
	this.getIdDurationTypeId = function(counter){
		return "durationTypeId_" + counter;
	}
	// utility method returns the html tag id for durationType dive 
	this.getIdDurationType = function(counter){
		return "durationTypeWrapper_" + counter;
	}
	// types - array of duration types 
	this.createDurationTypes = function(types){
		var instance = this;
		if(types){
			A.Array.each(types,function(type,index){
				if(index == 0){
					// first row -- by default it exists
					var node = A.one("#" + instance.getIdDurationType(index + 1));
					instance.populateDurationType(node, type);
				}else{
					// subsequent rows needs to be created
					var node = instance.addDuraitonRow();
					instance.populateDurationType(node, type);
				}
			});
		}
	}
	// populates html elements with the data from server
	this.populateDurationType = function(typeNode,typeData){
		typeNode.all("input").each( function(node){
			 node.val(typeData[node.get('id')]);
		});
	}
	this.removeDurationType = function(counter){
		var instance = this;
		if(counter == 1){
			// dont remove first node
			return;
		}
		var id = instance.getIdDurationType( counter);
		var durationTypeNode = A.one("#" + id);
		if(!durationTypeNode){
			alert(instance.deleteError);
			return;
		}
		var durationId = durationTypeNode.one("#" + instance.getIdDurationTypeId(counter)).val();
		try{
			durationId = parseInt(durationId);
		}catch(err){
			durationId = 0;
		}
		if(durationId > 0){ // it's preserved one..
			var data = {};
			data.action = "deleteDurationType";
			data.durationTypeId = durationId;
			var contentId = "formContainer";
			startPreLoader(contentId);
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
	                		instance.displayError(data.error);
	                	}else{
	                		//success
	                		durationTypeNode.remove();
	                		instance.displaySuccess(instance.durationRemoved);
	                	}
	                }else{
	                	//handle due to some reason data is null
	                	instance.displayError(instance.processError);
	                }
	              },
			    failure : function(){
			    	instance.displayError(instance.durationDelete);
			    }
	            }
	        });
		}else{ // it's new row not yet preserved to db
			durationTypeNode.remove();
			instance.displaySuccess(instance.durationRemoved);
		}
	}
	this.setDefaults = function(durationType){
		var instance = this;
		durationType.all("input").val('');
		durationType.one("[data-indicator=true]").val(instance.counterDurationType);
	}
	this.setIds = function(durationType){
		var instance = this;
		durationType.all("input").each(function(node){
		//	var old = node.get("id");
			// example : old: title1_1 then new id will be title1_2 
		//	var newId = old.substring(0,old.lastIndexOf('_')) + "_" + instance.counterDurationType;
			node.set("id",getNewId(node));
		});
		durationType.set("id",getNewId(durationType)); // mandatory - used while removing the section
		
		function getNewId(node){
			var old = node.get("id");
			// example : old: title1_1 then new id will be title1_2 
			var newId = old.substring(0,old.lastIndexOf('_')) + "_" + instance.counterDurationType;	
			return newId;
		}
	}
	this.initSave = function(){
		var instance = this;
		A.one("#saveForm").on("click",function(){
			instance.save();
		});
	}
	
	// get's all ck editors data and stores into given json object
	this.editorDataToJson = function(data){
		var instance = this;
		data = data ? data : {};
		try{
			data.intro = instance.getEditorData(instance.introEdId);
			data.option1 = instance.getEditorData(instance.option1EdId); 
			data.option2 = instance.getEditorData(instance.option2EdId); 
			data.note = instance.getEditorData(instance.noteEdId); 
		}catch(err){
			console.log(err);
		}
	}
	// used to get ckEditor data
	this.getEditorData = function(id){
		try{
			return window[id].getHTML();
		}catch(err){
			console.log(err);
		}
		return "";
	}
	this.setEditorData = function(id,data,defaultData){
		var instance = this;

		// to make null safe
		defaultData = defaultData ? defaultData : "";
		data = data ? data : defaultData;

		CKEDITOR.instances[instance.pns + id].setData(data);
	}

	this.save = function(){
		var instance = this;
		instance.hide(instance.msgNode);
		var contentId =  "formContainer";
		var valid = validateForm(contentId);
		if(!valid){
			return;
		}
		//preloader
		startPreLoader(contentId);
		var data ={};
		instance.populateReqData(data);
		
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
                	instance.handleSaveResponse(data);
                }else{
                	//handle due to some reason data is null
                	instance.displayError(instance.processError);
                }
                window.scrollTo(0,0);
              },
		    failure : function(){
		    	instance.displayError(instance.processError);
		    	window.scrollTo(0,0);
		    }
            }
        });
	}
	// fill all data to save 
	this.populateReqData = function(data){
		var instance = this;
		data = data ? data : {};
		// course id
		data.spCourseId = instance.courseId;
		// fill editors data
		instance.editorDataToJson(data);
		// all other input fields
		A.all("input").each(function(node){
			data[node.get('id')] = node.val();
		});
		data["durationTypecount"] = instance.counterDurationType;//A.all("[data-indicator=true]").size();
	}
	this.displayError = function(msg){
		var instance = this;
		instance.show(instance.msgNode);
		instance.msgNode.focus();
		instance.msgNode.setContent(msg);
		instance.msgNode.removeClass("portlet-msg-success");
		instance.msgNode.addClass("alert-error");
	}
	this.displaySuccess = function(msg){
		var instance = this;
		instance.show(instance.msgNode);
		instance.msgNode.focus();
		instance.msgNode.setContent(msg);
		instance.msgNode.removeClass("alert-error");
		instance.msgNode.addClass("portlet-msg-success");
	}
	// handle the response after saving data
	this.handleSaveResponse = function(data){
		var instance = this;
		if(data.error){
			instance.displayError(data.error);
		}else{
			instance.displaySuccess(instance.learningUpdate);
			if(data.process == 'create'){
				courseTabslink(instance.linkUrl,'editCareerDetails','careerDetails');
			}
		}
		
		//  handle durationTyps
		if(data.durationTypes){
			A.Array.each(data.durationTypes,function(dataObj){
				// have to preserve the durationtypeId created by server so that when user do the further updates without page refresh
				// the preserved ids will be send to server. Otherwise everytime user cliks update new rows can be created in db
				A.one("#" + instance.getIdDurationTypeId(dataObj.counter)).val(dataObj.durationTypeId);
			});
		}
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