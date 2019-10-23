function trademarkFileDrag() {

	this.rnum = 0;
	this.fileDragDiv = "";
	this.fltable = "";
	this.paramName = "";
	this.ajaxurl = "";
	this.pns = "";
	// getElementById
	this.$id = function (id) {
		return document.getElementById(id);
	};


	// file drag hover
	this.FileDragHover = function (e) {
		e.stopPropagation();
		e.preventDefault();
		//e.target.className = 'hover';
		e.target.className = (e.type == "dragover" ? "hover" : "");
	};


	// file selection
	this.FileSelectHandler = function (e,thisobj) {

		// cancel event and hover styling
		thisobj.FileDragHover(e);

		// fetch FileList object
		var files = e.dataTransfer.files;

		// process all File objects
		for (var i = 0, f; f = files[i]; i++) {
			thisobj.UploadFile(f,thisobj);
		}
	};
	
	this.getRowId = function(num,thisobj){
		return thisobj.fileDragDiv + "rn" + num;
	};
	
	this.getProgressId = function(num,thisobj){
		return thisobj.fileDragDiv + "prog" + num;
	};
	this.getRemoveDivId = function(num,thisobj){
		return thisobj.fileDragDiv + "rdiv" + num;
	};
	this.getMsgDivId = function(num,thisobj){
		return thisobj.fileDragDiv + "msgdiv" + num;
	};
	this.getTitleId = function(num,thisobj){
		return thisobj.fileDragDiv + "title" + num;
	};
	this.getDescId = function(num,thisobj){
		return thisobj.fileDragDiv + "fileDesc" + num;
	};
	this.getFileNameDivId = function(num,thisobj){
		return thisobj.fileDragDiv + "fileName" + num;
	};
	
	this.bytesToSize = function bytesToSize(bytes) {
		   if(bytes == 0) return '0 Byte';
		   var k = 1024;
		   var sizes = ['Bytes', 'KB', 'MB', 'GB', 'TB', 'PB', 'EB', 'ZB', 'YB'];
		   var i = Math.floor(Math.log(bytes) / Math.log(k));
		   return (bytes / Math.pow(k, i)).toPrecision(3) + ' ' + sizes[i];
		};

	this.UploadFile = function (file,thisobj) {
		var xhr = new XMLHttpRequest();
		if (xhr.upload) {
			var aui = new AUI();
			var spanProgress;
			var removeDiv;
			var msgDiv;
			var titleElmnt;
			var descElmnt;
			var fileNameDiv;
			aui.use('aui-node', function (aui) {
		        var rn = aui.Node.create("<tr id='" + thisobj.getRowId(thisobj.rnum,thisobj) + "'><td><div id='" + thisobj.getFileNameDivId(thisobj.rnum,thisobj) +"'>" + file.name + "</div></td><td><p id='"+ thisobj.getProgressId(thisobj.rnum,thisobj) +"' style='padding-right:50px;height:5px'></p></td><td>"+ thisobj.bytesToSize(file.size) + "</td><td><div id='" + thisobj.getMsgDivId(thisobj.rnum,thisobj) +"'></div></td><td><div id='" + thisobj.getRemoveDivId(thisobj.rnum,thisobj) + "'></div></td><td><input type='text' style='display:none' id='" + thisobj.getTitleId(thisobj.rnum,thisobj) + "'/></td><td><textarea style='display:none' id='" + thisobj.getDescId(thisobj.rnum,thisobj) + "'></textarea></td></tr>");
		        var to = aui.one("#" + thisobj.fltable);
		        to.append(rn);
		        spanProgress = aui.one("#" + thisobj.getProgressId(thisobj.rnum,thisobj));
		        removeDiv = aui.one("#"+ thisobj.getRemoveDivId(thisobj.rnum,thisobj));
		        msgDiv = aui.one("#"+ thisobj.getMsgDivId(thisobj.rnum,thisobj));
		        titleElmnt = aui.one("#"+ thisobj.getTitleId(thisobj.rnum,thisobj));
		        descElmnt = aui.one("#"+ thisobj.getDescId(thisobj.rnum,thisobj));
		        thisobj.rnum = thisobj.rnum + 1;
		        
		      /*  fileNameDiv = aui.one("#"+ thisobj.getFileNameDivId(thisobj.rnum,thisobj));
		        titleElmnt.on("change",function(){
		        	fileNameDiv.setHtml(titleElmnt.get("value"));
		        }) */
		    });
	
			// progress bar
			xhr.upload.addEventListener("progress", function(e) {
				   var pc = parseInt(100 - (e.loaded / e.total * 100));
					spanProgress.getDOMNode().style.backgroundPosition = pc + "% 0";
			}, false);

			// file received/failed
			xhr.onreadystatechange = function(e) {
				if (xhr.readyState == 4) {
					if(xhr.status == 200 ){
						var restext = xhr.responseText.replace(/\n/g,"");
						var jsonobj = JSON.parse(restext);
						if(jsonobj){
							if( jsonobj.fileEntryId){
								msgDiv.html("Success");
								titleElmnt.setStyle('display','inline');
								titleElmnt.set('id',thisobj.pns +  "title_" + jsonobj.fileEntryId);
								titleElmnt.set('name',thisobj.pns + "title_" + jsonobj.fileEntryId) ;

								descElmnt.setStyle('display','inline');
								descElmnt.set('id',thisobj.pns +  "fileDesc_" + jsonobj.fileEntryId);
								descElmnt.set('name',thisobj.pns + "fileDesc_" + jsonobj.fileEntryId) ;
								spanProgress.addClass( "success");
							}else{
								msgDiv.html(jsonobj.errorMsg);
								spanProgress.addClass( "failed");
							}
							
						}else{
							msgDiv.html(jsonobj.errorMsg);
							spanProgress.addClass( "failed");
						}
						var linkN = aui.Node.create("<a href='javascript:'>Remove</a>");
						linkN.setData("fileEntryId",jsonobj.fileEntryId);	
						
						aui.one(linkN).on("click",function(e){
							this.ancestor('tr').remove();
							var feId = this.getData("fileEntryId");
							aui.use('aui-io-request', function (){
								aui.io.request(thisobj.ajaxurl,{
									dataType : 'json',
									method : 'POST',
									data : {
										action: 'removeFile',
										fileEntryId: feId
									},
									on : {
									success : function() {
											var data = this.get('responseData');
											var result = data.result;
											}
									}
								});
								
							});
							
						});
						
						removeDiv.append(linkN);
					}
				}
			};
			var formData = new FormData();
			formData.append(thisobj.paramName, file);
			
			// start upload
			xhr.open("POST", ajaxurl, true);
		//	xhr.setRequestHeader("Content-Type", "multipart/form-data");
			xhr.send(formData);

		}

	};


	// initialize
	this.Init = function (dragDiv,fltable,paramName,ajaxurl,srcSelection,pns) {
	
		this.fileDragDiv = dragDiv;
		this.fltable = fltable;
		this.paramName = paramName;
		this.ajaxurl = ajaxurl;
		this.pns = pns;
		
		var	filedrag = this.$id(dragDiv);
		//	submitbutton = $id("submitbutton");

		// is XHR2 available?
		var xhr = new XMLHttpRequest();
		if (xhr.upload) {

			var thisobj = this;
			if(srcSelection == 'draganddrop'){
				// file drop
				filedrag.addEventListener("dragover", function(e){thisobj.FileDragHover(e,thisobj);}, false);
				filedrag.addEventListener("dragleave",function(e){thisobj.FileDragHover(e,thisobj);}, false);
				filedrag.addEventListener("drop", function(e){thisobj.FileSelectHandler(e,thisobj);}, false);
				filedrag.style.display = "block";
			}else if(srcSelection == 'fileInput'){
				AUI().use('aui-node','aui-base',function(A){
					var id = "#" + pns + paramName;
					var fileElmnt = A.one(id);
					if(fileElmnt){
						fileElmnt.on('change',function(e){
							if(thisobj.paramName == 'trademarkLogo'){
								var filesTable = A.one("#" + thisobj.fltable);
								if(filesTable){
									filesTable.all("tr").remove();
								}
							}
							var flist = document.getElementById(this.get('id')).files;
							for (var i = 0; i < flist.length; i++) {
								  var file = flist[i];
								  thisobj.UploadFile(file,thisobj);
							}
						});
					}
				});
			}

			// remove submit button
			//submitbutton.style.display = "none";
		}

	};

};