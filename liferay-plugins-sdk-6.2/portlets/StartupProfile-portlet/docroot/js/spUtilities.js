function spUtilities(){
	
}
/**
 * 
 * configObj.afterClone : Callback method and will be called after cloning. It will receive the newly cloned object and configObject as parameters.
 * @param configObj
 */
spUtilities.initAddClone = function(configObj){
	AUI().use('aui-node','aui-base', function(A){
		A.one('#' + configObj.addButtonId).on('click',function(){
			spUtilities.cloneNode(configObj);
			if(configObj.afterClone){
				configObj.afterClone(configObj.clonedNode,configObj);
			}
			
		});
	});
}

/***
 * Method used to clone given node and append to given target node.
 * Useful when same section needs to be added everytime when clicking on button.
 * configObj.nodeId -- Node Id which is going to be cloned
 * configObj.targetNodeId -- Node Id to which  cloned  node will be added if dntAddToTarget is not true
 * configObj.dontAssignIds - true represents , id and name attributes wont be generated dynamically for cloned node.
 * config.removeLinkId - Cloned section will have remove link/button to facilitate remove option. config.removeLinkId reprents that remove link/button id 
 * By default after cloning ,new id and name attributes will be set to all form elements
 * configObj.counter - when the given node is cloned , counter will be incremented and its value used to generated id and name
 * config.dontInitRemove - By default remove button will be initialized. If this parameter is set to true, then remove will be initialized.
 * configObj.addAsFirstChild - By default newly cloned node appended as last node to target node, if this parameter is set true then cloned node will be added
 * as first child to target node.
 * 
 * 
 * TODO: Implementation must be changed to return cloned node
 * @param configObj
 */
spUtilities.cloneNode = function (configObj) {
	
	var fieldName = configObj.nodeId;
	
	AUI().use('aui-node','aui-base','aui-io-request',function(A){
		var sampleCont = A.one("#" + fieldName);
		var dup = sampleCont.clone();

		if(!configObj.dontAssignIds){
			var inputs = dup.all(".aui-field-input");
			if(configObj.counter == undefined){
				configObj.counter = 100;
			}
			configObj.counter =  configObj.counter + 1;
			var counterStr = fieldName + configObj.counter;
			inputs.each(function(inp) {
				try {
					var id = "";
					if(configObj.dontusePrefix){
						id = inp.get("name") + configObj.counter;
					}else{
						id = inp.get("name").replace(fieldName, counterStr);
					}
					inp.set("name", id);
					inp.set("id", id);
					inp.val("");
					if(configObj.counterId){
						var counterObj = dup.one("#" + configObj.counterId);
						if(counterObj){
							counterObj.set('value',configObj.counter);
						}
					}
				}catch (err) {
					console.log(err);
				}
			});
			//dup.one("#" + configObj.removeLinkId).set("id",configObj.removeLinkId+counterStr);
			dup.set("id", counterStr);
		}
		
		if(configObj.dntAddToTarget){
			
		}else{
			var container = A.one('#' + configObj.targetNodeId);
			if(configObj.addAsFirstChild){
				
			}else{
				dup.appendTo(container);
			}
		}
		
		if(configObj.dontInitRemove){
			
		}else{
			var removeNode = dup.one("#" + configObj.removeLinkId);
			if(removeNode){
				removeNode.on("click",function(){
					dup.remove();
				});
			}
		}
	//	dup.removeClass('hide-content');
	//	dup.addClass('show-inline');
		
		configObj.clonedNode = dup; 
		
	});
 }

spUtilities.actionUsingAjax = function(configObj){
	var sync = false;
	if(configObj.sync){
		sync = configObj.sync;
	}
	AUI().use('aui-node', 'aui-base', 'aui-io-request', function(A) {
		A.io.request(configObj.ajaxUrl,{
			dataType : 'json',
			method : 'POST',
			data : configObj.data,
			sync: sync,
			on : {
				success : function() {
					var data = this.get('responseData');
					if(configObj.afterReceivingData){
						configObj.afterReceivingData(data,configObj);
					}
				}
			}
		});
	});
}


spUtilities.fillDropDownUsingAjax = function(obj){
	if(obj.freshLoad){
		AUI().use('aui-node', 'aui-base',  function(A){
			A.all("#" + obj.ddId + " option").remove();
		});
	}
	obj.afterReceivingData = function(data,cobj){
		if(data) {
			spUtilities.fillDropDownWithJsonData(obj.ddId,data.items);
		}	
	}
	spUtilities.actionUsingAjax(obj);
}

spUtilities.fillDropDownWithJsonData = function(ddId,items,key,value){
	AUI().use('aui-node', 'aui-base',  function(A){
		var dd = A.one("#" + ddId);
		if(dd && items){
			for(var i=0,tol=items.length; i<tol; i++){
				var item = items[i];
				var optn;
				if(key && value){
					 optn = A.Node.create("<option value='" + item[key] + "'>" + item[value] + "</option>");
				}else{
					 optn = A.Node.create("<option value='" + item.key + "'>" + item.value + "</option>");
				}
				optn.appendTo(dd);
			}
		}
	});
} 
spUtilities.getFormDataInJson = function(configObj) {
	var obj = {};
	AUI().use('aui-node', 'aui-base', function(A) {
		var form = A.one("#" + configObj.formId);
		var ele = form.all(".aui-field-input");
		var len = -1;
		if(configObj.pns){
			 len = configObj.pns.length;
		}
		ele.each(function(){
			var process = true;
			if(configObj.elmntFilter){
				process = configObj.elmntFilter(this);
			}
			if(process){
				var name = this.get("name");
				if(configObj.pns){
					name = name.substring(len);
				}
				var val;
				if(this.get('type') == 'checkbox'){
						val = this.get('checked');
				}else{
					val = this.val();
				} 
				if(val != null)
					obj[name] = val;
			}
		});
	});

	return obj;
}

spUtilities.setFormDataUsingJson = function(configObj,jsonObj) {
	AUI().use('aui-node', 'aui-base', function(A) {
		var form = A.one("#" + configObj.formId);
		var ele = form.all(".aui-field-input");
		var len = -1;
		if(configObj.pns){
			 len = configObj.pns.length;
		}
		var copy = jsonObj;
		if(configObj.suffix){
			copy = spUtilities.cloneJson(jsonObj,configObj.suffix);
		}
		ele.each(function(){
			var process = true;
			if(configObj.elmntFilter){
				process = configObj.elmntFilter(this);
			}
			if(process){
				var name = this.get("name");
				if(configObj.pns){
					name = name.substring(len);
				}
				if(this.get('type') == 'checkbox'){
					this.set('checked',copy[name]);
				}else{
					this.set('value',copy[name]);
				}
			}
		});
	});
}
spUtilities.setFormDataToBlank = function(configObj) {
	AUI().use('aui-node', 'aui-base', function(A) {
		var form = A.one("#" + configObj.formId);
		var ele = form.all(".aui-field-input");
		ele.each(function(){
			var process = true;
			if(configObj.elmntFilter){
				process = configObj.elmntFilter(this);
			}
			if(process){
				var name = this.get("name");
				if(this.get('type') == 'checkbox'){
					this.set('checked',false);
				}else{
					this.set('value',"");
				}
			}
		});
	});
}

spUtilities.cloneJson = function(jsonObj,suffix){
	var copy = {};
	if(jsonObj){
		for (var key in jsonObj) {
			  if (jsonObj.hasOwnProperty(key)) {
				  if(suffix){
					  copy[key + suffix] = jsonObj[key];
				  }else{
					  copy[key] = jsonObj[key];
				  }
			  }
		}
	}
	return copy;
}
spUtilities.ERROR = "error";
spUtilities.SUCCESS = "success";
