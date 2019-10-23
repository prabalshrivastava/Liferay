var uploadLogId = 0;
var intervalId;
function clearAll(){
	A.all(".log-field").set("text","");
}
function disableFields(){
//	A.one("#file").set("disabled",true);
	A.one("#uploadButton").set("disabled",true);
}
function enableFields(){
	A.one("#file").set("disabled",false);
	A.one("#uploadButton").set("disabled",false);
}
function upload(){
	disableFields();
	clearAll();
	A.io.request(uploadUrl,{
		method: 'POST',
		form :{
			id: "uploadForm",
            upload: true
		},
		on: {
            complete: function(id, o, args) {
            	var resp = args.responseText;
            	if(!resp ){
            		alert("Error"); return;
            	}
            	resp = JSON.parse(args.responseText);
            	if(resp.error){
            		alert(resp.error);
            	}else {
            		displayUploadLog(resp);
            	}
            	// start getting logs.
            	keepGettingLog();
            	enableFields();
            },
            start : function(id, args){
            	// id - transaction id
            }
		}
	});
}

function displayUploadLog(logJson){
	A.one("#logContainer").removeClass("hide");
	A.one("#uploadForm").hide();
	if(logJson){
		
		// Upload completed. so stop pooling for logs.
		if(logJson.endTime){
			clearInterval(intervalId);
			
			if(logJson.uploadedFileUrl){
				var node = A.one("#uploadedFileUrl");
				node.set("href",logJson.uploadedFileUrl);
				node.set("text","Download");
				A.one("#uploadedFileUrl").removeClass("hide");
			}
			if(logJson.errorFileUrl){
				var node = A.one("#errorFileUrl");
				node.set("href",logJson.errorFileUrl);
				node.set("text","Download");
				A.one("#errorFileUrl").removeClass("hide");
			}
		}
		A.one("#logContainer").all(".log-text").each(function(node){
			var ttemp = logJson[node.get("id")];
			if(ttemp){
				node.set("text",ttemp);
			}else{
				node.set("text","");
				
			}
		});
		/*A.each(logJson,function(value,key){
			if(key=='errors' || key=='msgs'|| key=='errorFileUrl' || key == 'uploadedFileUrl') return;
			var node = A.one("#" + key);
			if(node){
				node.set("text",value);
			}
		}); */
		uploadLogId = logJson.uploadLogId;
		displayMsgs(logJson.msgs);
		displayErrors(logJson.errors);
	}
}

function displayMsgs(msgs){
	if(!msgs){
		return;
	}
	if(typeof msgs == "string"){
		msgs = JSON.parse(msgs);
	}
	var container = A.one("#msgs");
	container.all("*").remove();
	A.each(msgs,function(msgJson){
		var cloned = displayMsgRecord(msgJson);
		container.appendChild(cloned);
	})
}
function displayErrors(msgs){
	if(!msgs){
		return;
	}
	if(typeof msgs == "string"){
		msgs = JSON.parse(msgs);
	}
	var container = A.one("#errors");
	container.all("*").remove();
	A.Array.each(msgs,function(msgJson){
		var cloned = displayMsgRecord(msgJson);
		container.appendChild(cloned);
	})
}



function displayMsgRecord(msgJson){
	var template = A.one("#sampleMsgRow");
	var cloned = template.cloneNode(true);
	cloned.set("id","");
	
	A.each(msgJson,function(value,key){
		var node = cloned.one("#" + key);
		if(node){
			if(key == 'rowNo'){
				node.set("text",value+1);
			}else{
				node.set("text",value);
			}
		}
	});
	
	return cloned;
}

var getUploadLog =  function(){
	if(uploadLogId == 0){
		return;
	}
	var data = {};
	data["uploadLogId"] = uploadLogId;
	A.io.request(uploadLogUrl,{
		dataType: 'json',
		method: 'POST',
		data: data,
		on: {
            complete: function() {
            },
            success: function() {
                var data = this.get('responseData');
                displayUploadLog(data);
              },
		    failure : function() {
		    }
		}
	});
}

function keepGettingLog(){
	intervalId = setInterval(getUploadLog, 10000 * 10);
}
	
