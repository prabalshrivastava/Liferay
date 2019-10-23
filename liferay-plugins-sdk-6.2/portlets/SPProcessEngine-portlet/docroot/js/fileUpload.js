var fileUpload = function() {
	this.ajaxurl = "";
	this.pns = "";
	var instance = this;
	
	this.removeFromProgress = function(file){
		if(instance.progressData){
			var index = instance.progressData.indexOf(file.name);
			if (index >= 0) {
				instance.progressData.splice( index, 1 );
			}
		}
	}
	this.isInProgress = function(){
		var progress = false;
		if(instance.progressData && instance.progressData.length > 0){
			progress = true;
		}
		return progress;
	}
	this.uploadFile = function (file) {
		
		var xhr = new XMLHttpRequest();
		if (xhr.upload) {
			instance.progressData = [];
			instance.progressData.push(file.name);
			// progress bar
			xhr.upload.addEventListener("progress", function(e) {
				  /* var pc = parseInt(100 - (e.loaded / e.total * 100));
				   var progressFrame = A.one('#myProgress');
				   var width = 1;
				   progressFrame.getDOMNode().style.backgroundPosition = pc + "% 0";
				   progressFrame.getDOMNode().style.display = "block";
				   width++; 
                   progressFrame.getDOMNode().style.width = width + pc + '%'; 
                   progressFrame.getDOMNode().innerHTML = width * 1 + pc + '%'; */
				    
			}, false);
			// file received/failed
			xhr.onreadystatechange = function(e) {
				if (xhr.readyState == 4) {
					instance.removeFromProgress(file);
					if(xhr.status == 200 ){
						var restext = xhr.responseText.replace(/\n/g,"");
						var jsonobj = JSON.parse(restext);
						if(instance.handleResponse){
							instance.handleResponse(jsonobj);
						}else if(instance.hiddenFieldId){
							if(jsonobj){
								if( jsonobj.tempFileEntryId){
									//alert("File uploaded successfully" + jsonobj.tempFileEntryId);
									console.log("File uploaded successfully" + jsonobj.tempFileEntryId);
									A.one("#" + instance.hiddenFieldId).val(jsonobj.tempFileEntryId);
									//A .one('#progress-bar').style.display = "none";
								}else{
									alert("error");
								}
							}else{
								alert("error");
							}
						
						}else{
							if(jsonobj){
								if( jsonobj.tempFileEntryId){
									//alert("File uploaded successfully" + jsonobj.tempFileEntryId);
									console.log("File uploaded successfully" + jsonobj.tempFileEntryId);
								}else{
									alert("error");
								}
							}else{
								alert("error");
							}
						}
					}
				}
			};
			var formData = new FormData();
			formData.append("file", file);
			formData.append("action", "uploadFileToTemp");
			// start upload
			xhr.open("POST", instance.ajaxurl , true);
			//	xhr.setRequestHeader("Content-Type", "multipart/form-data");
			xhr.send(formData);
		}
	};

	// initialize
	// hiddenFieldId is used to store the file entry id of file uploaded
	this.init = function (ajaxurl,pns,fileElementId, hiddenFieldId,handleResponse) {
		instance.ajaxurl = ajaxurl;
		instance.pns = pns;
		instance.fileElementId = fileElementId;
		instance.hiddenFieldId = hiddenFieldId;
		instance.handleResponse = handleResponse;
		var xhr = new XMLHttpRequest();
		if (xhr.upload) {
			var fileElmnt = A.one("#" + fileElementId);
			if(fileElmnt){
				fileElmnt.on('change',function(e){
					var flist = document.getElementById(instance.fileElementId).files;
					for (var i = 0; i < flist.length; i++) {
						  var file = flist[i];
						  instance.uploadFile(file);
					}
				});
			}
		}
	};
};
