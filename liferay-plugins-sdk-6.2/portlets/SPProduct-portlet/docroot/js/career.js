var careerDetails = function(config){
	this.init = function(config){
		this.pns = config.pns;
		this.courseId = config.courseId;
		this.linkUrl = config.linkUrl;
		this.data = config.data;
		this.ajaxUrl = config.ajaxUrl;
		this.addCoverImageUrl = config.addCoverImageUrl;
		this.imageUploadMsg = config.imageUploadMsg;
		this.imageRemoveMsg = config.imageRemoveMsg;
		this.successMsg = config.successMsg;
		this.editorErrorMsg = config.editorErrorMsg;
		this.saveErrorMsg = config.saveErrorMsg;
		this.deleteErrorMsg = config.deleteErrorMsg;
		this.processErrorMsg = config.processErrorMsg;
		this.studyDelErrorMsg = config.studyDelErrorMsg;
		
		this.msgNode = A.one("#msgContainer");
		this.introEdId = this.pns + "introEditor";

		// study option related
		this.studyOptionContainerNode = A.one("#" + "studyOptionInner");
		this.studyOptionNode = A.one("#" + "studyOptionWrapper_0");
		this.counterStudyOption = 0; // changing this value will impact everywhere including server side
		this.initSave();
		this.initAddStudyOption();
		this.createStudyOptions(A.JSON.parse(config.studyOptions));
		this.imageUploadMsg = config.imageUploadMsg;
		this.imageRemoveMsg = config.imageRemoveMsg;
	}
	this.initAddStudyOption = function(){
		var instance = this;
		A.one("#addStudyOption").on("click",function(){
			instance.addStudyOptionRow();
		});
	}
	// options - array of study options 
	this.createStudyOptions = function(options){
		var instance = this;
		if(!options || options.length == 0){
			//instance.addStudyOptionRow(); // by default keep one row
			return;
		}
		A.Array.each(options,function(option,index){
			var node = null;
		/*	if(index == 0){				// first row -- by default it exists
				node = A.one("#" + instance.getHtmlIdStudyOptionDiv(index + 1));
				instance.initEditorFileUploads(node,option);
			}else{
				// subsequent rows needs to be created
				node = instance.addStudyOptionRow(option);
			}*/
			node = instance.addStudyOptionRow(option);
			// populates all the fields except editors - editors must be populated with data during creation iteself using instanceready event
			instance.populateStudyOption(node, option);
		});
	
	}
	// populates html elements with the data from server
	this.populateStudyOption = function(optionNode,data){
		var instance = this;
		optionNode.all("input").each( function(node){
			 node.val(data[node.get('id')]);
		});
		// populate  editor
	/*	optionNode.all("[data-editor=true]").each(function(node){
			var id = instance.getHtmlIdEditor(node);
			var dataTemp = data[id];
			instance.setEditorData(id, dataTemp, "");
		}); */
	}
	// optional data object contains the editor data too. for newly created editors, data can be set using instanceready event only.
	// so when new study option row is created for existing data, we must pass editor data as well.
	this.addStudyOptionRow = function(data){
		data = data ? data : {};
		var instance = this;
		// clone the first row
		var cloned = instance.studyOptionNode.clone();
		instance.show(cloned);
		// increment counter - identified each study option uniquely -- this must be happen before doing any other action ater cloning
		instance.counterStudyOption = instance.counterStudyOption + 1;
		cloned.one("#close").setAttribute("data-counter", instance.counterStudyOption);
		cloned.all("[data-editor=true],[data-dropzone=true]").setAttribute("data-counter", instance.counterStudyOption);

		cloned.all("[data-editor=true]").each(function(node){
			var child = A.Node.create("<div></div>");
			child.set("id",instance.getHtmlIdEditor(node)); // setting id here itself
			node.append(child);
		});

		// 3. set unique ids
		instance.setIds(cloned);
		// reset to default values
		instance.setDefaults(cloned);
		
		// close icon handler
		cloned.one("#close").on("click",function(){
			var counter = this.getAttribute("data-counter");
			instance.removeStudOption(counter);
		});
		instance.studyOptionContainerNode.append(cloned);
	
		instance.initEditors(cloned, data); // we are sending the editor data as well
		
		instance.initFileUploads(cloned,data);
		
		return cloned;
	}
	this.initEditors = function(cloned,data){
		var instance = this;
		data = data ? data : {};
		// create editors here
		cloned.all("[data-editor=true]").each(function(node){
			// editor's intial data must be populated while creation itself. 
			var id = instance.getHtmlIdEditor(node); 
			var dataTemp = data[id];
			if(!dataTemp || dataTemp == ''){
				dataTemp = 'Key in description';
			}
			instance.createEditor(id, dataTemp);
		});
	}
	this.initFileUploads = function(cloned,data){
		var instance = this;
		data = data ? data : {};
		// image upload initialization here
		cloned.all("[data-dropzone=true]").each(function(node){
			node.addClass("dropzone"); 
			// imageId - stores the fileEntryId of uploaded image.It's hidden field
			var idImageFEId = instance.getHtmlIdImageId(node);
			var div = cloned.one("#" + instance.getHtmlIdExstngImgDiv(node));
			if(data[idImageFEId] > 0){ // if file exists
				try{
					instance.show(div);
					div.append(A.Node.create("<img></img><span>X</span>"));
					div.one("img").set("src",data[idImageFEId + "_url"]);
					div.one("img").set("alt","Close");
					div.one("span").on("click",function(){
						instance.clearExistingImg(node);
					});
				}catch(err){
					
				}
			}
			instance.initImageUpload(node.get("id"), idImageFEId);
		});
	}
	this.clearExistingImg = function(dropzone){
		var instance = this;
		try{
			var div = A.one("#" + instance.getHtmlIdExstngImgDiv(dropzone));
			div.setContent('');
			var idImageFEId = instance.getHtmlIdImageId(dropzone);
			A.one("#" + idImageFEId).val('');
		}catch(err){
			console.log(err);
		}
	}
	// set's the unique id
	this.setIds = function(studyOption){
		var instance = this;
		// for image drop zone div's also we need unique id
		studyOption.all("input,[data-dropzone=true],[data-exstng-img-div=true]").each(function(node){
			// example : old: title1_1 then new id will be title1_2 
			node.set("id",getNewId(node));
		});
		studyOption.set("id",getNewId(studyOption)); // mandatory - used while removing the section
		
		function getNewId(node){
			var old = node.get("id");
			// example : old: title1_1 then new id will be title1_2 
			var newId = old.substring(0,old.lastIndexOf('_')) + "_" + instance.counterStudyOption;	
			return newId;
		}
	}
	this.createEditor = function(id,data){
		var instance = this;
		try{
			//TODO: config options
			var editor = window.CKEDITOR.replace(id,{
				toolbar : [
				           ['Bold', 'Italic', 'Underline', 'Strike'],
				           ['NumberedList', 'BulletedList', '-', 'Outdent', 'Indent']
				       ]
			});
			editor.on("instanceReady",function(evt){
				editor.setData(data);
			});  
		}catch(err){
			console.log(err);
		}
	}
	// utility method returns the html tag id for studyoptionid hidden field 
	this.getHtmlIdStudyOptionId = function(counter){
		return "studyOptionId_" + counter;
	}
	// utility method returns the html tag id for study option dive 
	this.getHtmlIdStudyOptionDiv = function(counter){
		return "studyOptionWrapper_" + counter;
	}
	// multi instance editor fiels 
	this.getHtmlIdEditor = function(editorContainer){
		var name = editorContainer.getAttribute("data-name");
		var counter = editorContainer.getAttribute("data-counter");
		return name + counter;
	}
	// multi instance image upload fields 
	this.getHtmlIdImageId = function(dropzone){
		var name = dropzone.getAttribute("data-name");
		var counter = dropzone.getAttribute("data-counter");
		return name + counter;
	}
	// multi instance image upload fields 
	this.getHtmlIdExstngImgDiv = function(dropzone){
		var name = dropzone.getAttribute("data-exstng-img-div-id");
		var counter = dropzone.getAttribute("data-counter");
		return name + counter;
	}

	this.removeStudOption = function(counter){
		var instance = this;
		var id = instance.getHtmlIdStudyOptionDiv( counter);
		var studyOptionNode = A.one("#" + id);
		if(!studyOptionNode){
			alert(this.deleteErrorMsg);
			return;
		}
		var studyOptionId = studyOptionNode.one("#" + instance.getHtmlIdStudyOptionId(counter)).val();
		try{
			studyOptionId = parseInt(studyOptionId);
		}catch(err){
			studyOptionId = 0;
		}
		if(studyOptionId > 0){ // it's preserved one..
			var data = {};
			data.action = "deleteStudyOption";
			data.studyOptionId = studyOptionId;
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
	                		studyOptionNode.remove();
	                	}
	                }else{
	                	//handle due to some reason data is null
	                	instance.displayError(this.processErrorMsg);
	                }
	              },
			    failure : function(){
			    	instance.displayError(this.studyDelErrorMsg);
			    }
	            }
	        });
		}else{ // it's new row not yet preserved to db
			studyOptionNode.remove();
		}
	}
	// set's default values when you create study option row
	this.setDefaults = function(studyOption){
		var instance = this;
		studyOption.all("input").val('');
		// setting counter value is mandatory. it's indication to server that corresponding row exists
		studyOption.one("[data-indicator=true]").val(instance.counterStudyOption);
	}
	this.initSave = function(){
		var instance = this;
		A.one("#saveForm").on("click",function(){
			instance.save();
		});
	}
	this.save = function(){
		var instance = this;
		
		var contentId =  "formContainer";
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
                	instance.displayError(this.saveErrorMsg);
                }
                window.scrollTo(0,0);
              },
		    failure : function(){
		    	instance.displayError(this.saveErrorMsg);
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
		// all other input fields
		A.all("input").each(function(node){
			data[node.get('id')] = node.val();
		});
		// editors data
		A.all("[data-editor=true]").each(function(node){
			var editorId = instance.getHtmlIdEditor(node);
			data[editorId] = instance.getEditorData(editorId);
		});
		data["intro"] = instance.getEditorData(instance.introEdId);
		
		//TODO: populate editor data for study option
		data["studyOptioncount"] = instance.counterStudyOption;//A.all("[data-indicator=true]").size();
	}
	// used to get ckEditor data
	this.getEditorData = function(id){
		try{
			return CKEDITOR.instances[id].getData();
			//return window[id].getHTML();
		}catch(err){
			console.log(err);
		}
		return "";
	}
	this.setEditorData = function(id,data,defaultData){
		var instance = this;

		try{
			// to make null safe
			defaultData = defaultData ? defaultData : "";
			data = data ? data : defaultData;
			var editor = CKEDITOR.instances[id];
			editor.setData(data,function() {
				editor.resetDirty();
			});
		}catch(err){
			alert(this.editorErrorMsg);
		}
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
			instance.displaySuccess(this.successMsg);
			if(data.process == 'create'){
				courseTabslink(instance.linkUrl,'editGraduationCriteria','graduationCriteria');
			}
			
		}
		//  handle durationTyps
		if(data.studyOptions){
			A.Array.each(data.studyOptions,function(dataObj){
				// have to preserve the studyoptionid created by server so that when user do the further updates without page refresh
				// the preserved ids will be send to server. Otherwise everytime user cliks update new rows can be created in db
				A.one("#" + instance.getHtmlIdStudyOptionId(dataObj.counter)).val(dataObj.studyOptionId);
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
	this.initImageUpload = function(dropZoneId,imageValueId){
		var instance = this;
		var id = "div#"+dropZoneId;
		var myDropzone = new Dropzone(id, { 
			url: instance.addCoverImageUrl,
			thumbnailWidth : 300,
			thumbnailHeight : 300,
			dictDefaultMessage : this.imageUploadMsg,
			acceptedFiles : "image/*",

			init : function() {

				this.on("addedfile", function(file) {
					// Create the remove button
					var removeButton = Dropzone
							.createElement("<button>" + this.imageRemoveMsg + "</button>");

					// Capture the Dropzone instance as closure.
					var _this = this;

					// Listen to the click event
					removeButton.addEventListener("click", function(e) {
						// Make sure the button click doesn't submit the form:
						e.preventDefault();
						e.stopPropagation();

						// Remove the file preview.
						_this.removeFile(file);
						// If you want to the delete the file on the server as well,
						// you can do the AJAX request here.
					});

					// Add the button to the file preview element.
					file.previewElement.appendChild(removeButton);
				});
				this
						.on(
								"success",
								function(file, responseText) {
									var dropzonediv = A.one("#" + dropZoneId);
									instance.clearExistingImg(dropzonediv);
									var items = JSON.parse(responseText);
									var tempFileEntryId = items["tempFileEntryId"];
									A.one("#"+imageValueId).val(tempFileEntryId);
								});

			}
	});
	
	}
	this.init(config);
}
