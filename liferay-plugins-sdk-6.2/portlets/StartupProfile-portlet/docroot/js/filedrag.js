//var type="";
	
function profileFileDragAndDrop() {
	this.rnum = 0;
	this.fileDragDiv = "";
	this.fltable = "";
	this.paramName = "";
	this.ajaxurl = "";
	this.pns = "";
	this.action="upload";
	this.afterFileUpload = null;
	// getElementById
	this.$id = function (id) {
		return document.getElementById(id);
	};


	// file drag hover
	this.FileDragHover = function (e) {
		e.stopPropagation();
		e.preventDefault();
		if(e.target.className.indexOf('fdWrap') >= 0) {
			e.target.className = (e.type == "dragover") ? "fdWrap hover" : "fdWrap";
		}
	};
	
	this.validateOrganizationName = function(thisobj) {
		try {
			if (organization == null || !organization.organizationId) {
				var validator = eval('Liferay.Form._INSTANCES.' + namespace
						+ 'addStartup.formValidator');
				validator.resetAllFields();
				validator.validateField(namespace + 'organization_name');
				validator.validateField(namespace + 'organization_uen');
				if (!validator.hasErrors()) {
					addStartup(true,"upload","","","","",true,"");
				} else {
					validator.focusInvalidField();
					try {AUI().use('aui-node', function (A) {A.one('#' + thisobj.pns + thisobj.paramName).val('')});}catch(err){console.log(err);}
					try {displayMessage('Please add Startup name to proceed further', 'Error');}catch(err){}
					return false;
				}
			}
			return true;
		} catch (error) {
		}
	};


	// file selection
	this.FileSelectHandler = function (e,thisobj, type) {

		// cancel event and hover styling
		thisobj.FileDragHover(e);

		// fetch FileList object
		var files = e.dataTransfer.files;
		
		if(!type=='otherFiles' && files.length > 1){
			return;
		}
		
		if (!thisobj.validateOrganizationName(thisobj)){
			return;
		}
		
		// process all File objects
		var wait = 0;
		for (var i = 0, f; f = files[i]; i++) {
			if (f.type == 'image/jpeg' || f.type == 'image/jpg' || f.type == 'image/png') {
				setTimeout(function() {
					thisobj.UploadFile(arguments[0],thisobj, arguments[1]);
				}, wait, f, type);
				wait = 2000;
			}
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

	this.UploadFile = function (file,thisobj, type) {
		var xhr = new XMLHttpRequest();
		if (xhr.upload) {
			var aui = new AUI();
			var spanProgress;
			var removeDiv;
			var msgDiv;
			var titleElmnt;
			var descElmnt;
			var fileNameDiv;

			// file received/failed
			xhr.onreadystatechange = function(e) {
				if (xhr.readyState == 4) {
					stopPreLoader(type + 'MainDiv-EditPage');
					if (xhr.status == 200) {
						var restext = xhr.responseText.replace(/\n/g, "");
						var jsonobj;
						try {
							jsonobj = JSON.parse(restext);
						} catch(err){
							jsonobj = restext;
						}
						if (thisobj.afterFileUpload) {
							thisobj.afterFileUpload(jsonobj);
						}
					}
				}
			};
			var formData = new FormData();
			formData.append(thisobj.paramName, file);
			formData.append("action", thisobj.action);
			formData.append("sp_p_auth", getAuthToken(thisobj.pns));
			if(document.getElementById(namespace + 'organization_name')){
				formData.append("orgName", document.getElementById(namespace + 'organization_name').value);
			}	
			if (organization && organization.organizationId) {
				formData.append("orgId", organization.organizationId);
			}
			// start upload
			xhr.open("POST", thisobj.ajaxurl, true);
			startPreLoader(type + 'MainDiv-EditPage');
			xhr.send(formData);

		}

	};


	// initialize
	this.Init = function (type1, dragDiv,fltable,paramName,ajaxurl,srcSelection,pns,action,afterFileUpload) {
		var type=type1;
		this.fileDragDiv = dragDiv;
		this.fltable = fltable;
		this.paramName = paramName;
		this.ajaxurl = ajaxurl;
		this.pns = pns;
		this.action = action;
		this.afterFileUpload = afterFileUpload;
		
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
				filedrag.addEventListener("drop", function(e){thisobj.FileSelectHandler(e,thisobj, type);}, false);
				//filedrag.style.display = "block";
			}else if(srcSelection == 'fileInput'){
				AUI().use('aui-node','aui-base',function(A){
					var id = "#" + pns + paramName;
					var fileElmnt = A.one(id);
					if(fileElmnt){
						fileElmnt.on('change',function(e){
							if(!thisobj.validateOrganizationName(thisobj)){
								return;
							}
							
							var wait = 0;
							var flist = document.getElementById(this.get('id')).files;
							for (var i = 0; i < flist.length; i++) {
								var f = flist[i];
								setTimeout(function() {
									thisobj.UploadFile(arguments[0],thisobj, type);
								}, wait, f);
								wait = 2000;
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