var hasFileSizeError = false;

var DndUpload = function(html5Uploader, inputElem, uploadFileResourceURL, portletNamespace, fileSizeMax, imageWidthMin, imageHeightMin) {
	this.html5Uploader = html5Uploader;
	this.input = inputElem;
	this.uploadFileResourceURL = uploadFileResourceURL;
	this.portletNamespace = portletNamespace;
	this.fileSizeMax = fileSizeMax;
	this.imageWidthMin = imageWidthMin;
	this.imageHeightMin = imageHeightMin;
	this.dropZone = null;
	this.isDragging = false;
	this.init();
};

DndUpload.prototype.init = function() {
	this.buildDropZone();
};

DndUpload.prototype.buildDropZone = function() {
	//document.title += "-buildDropZone";
	var self = this, textDropZone;
	this.input.style.display = 'none';
	this.dropZone = document.createElement('div');
	this.dropZone.setAttribute('id', this.portletNamespace + 'pi-drop-zone');
	this.dropZone.setAttribute('class', 'pi-drop-zone');
	textDropZone = document.createElement('p');
	textDropZone.setAttribute('id', this.portletNamespace + 'pi-drop-text');
	textDropZone.setAttribute('class', 'pi-drop-text');
	textDropZone.appendChild(document.createTextNode('Drop your profile image here'));
	this.dropZone.appendChild(textDropZone);
	this.input.parentNode.appendChild(this.dropZone);

	this.dropZone.addEventListener('dragover', this.handleDragOver, false);
	this.dropZone.addEventListener('dragenter', function(e) {
		self.handleDragEnter.call(self, e);
	}, false);
	this.dropZone.addEventListener('drop', function(e) {
		self.handleDrop.call(self, e);
	}, false);

	this.dropZone.addEventListener('dragleave', function(e) {
		self.handleDragLeave.call(self, e);
	}, false);
};

DndUpload.prototype.handleDragOver = function(e) {
	//document.title += "-handleDragOver";
	e.preventDefault();
};

DndUpload.prototype.handleDragEnter = function(e) {
	//document.title += "-handleDragEnter";
	e.preventDefault();
	this.isDragging = true;
	this.dropZone.className = 'active';
};

DndUpload.prototype.handleDragLeave = function(e) {
	//document.title += "-handleDragLeave";
	e.preventDefault();
	/*
	var target = e.target, parentElem = target.parentNode, flag = false;

	if (target !== this.dropZone) {
		while (parentElem.nodeType != 9) {
			if (parentElem == this.dropZone) {
				flag = true;
				break;
			}
			parentElem = parentElem.parentNode;
		}
	} else {
		if (!flag) {
			this.isDragging = false;
			this.dropZone.className = '';
		}
	}
	*/
};

DndUpload.prototype.handleDrop = function(e) {
	//document.title += "-handleDrop";
	e.preventDefault();
	var elem;
	var files;
	var fileUpload;
	this.dropZone.className = '';

	/*
	elem = document.getElementById(this.portletNamespace + 'pi-drop-text');
	if (elem) {
		this.dropZone.removeChild(elem);
	}
	*/

	files = e.dataTransfer.files;
	for (var i = 0, len = files.length; i < len; i++) {
		fileUpload = new FileUpload(this.html5Uploader, this.dropZone, files[i], this.uploadFileResourceURL, this.portletNamespace, this.fileSizeMax, this.imageWidthMin, this.imageHeightMin);
	}

	return false;
};

function handleFiles(files, uploadFileResourceURL, portletNamespace, fileSizeMax, imageWidthMin, imageHeightMin) {
try{
	//document.title += "-handleFiles";
	var fileUpload;
	var selectZone;
	var html5Uploader;
	selectZone = document.getElementById(portletNamespace + 'pi-select-zone');
	html5Uploader = document.getElementById(portletNamespace + 'pi-html5-uploader');
	for (var i = 0, len = files.length; i < len; i++) {
		fileUpload = new FileUpload(html5Uploader, selectZone, files[i], uploadFileResourceURL, portletNamespace, fileSizeMax, imageWidthMin, imageHeightMin);
	}
}catch(err) {
	alert(err);
}
}

/*--------------------------------*/

var FileUpload = function(html5Uploader, domAttach, file, uploadFileResourceURL, portletNamespace, fileSizeMax, imageWidthMin, imageHeightMin) {
	this.html5Uploader = html5Uploader;
	this.file = file;
	this.fileSizeMax = fileSizeMax;
	this.imageWidthMin = imageWidthMin;
	this.imageHeightMin = imageHeightMin;
	this.attachDropZone = domAttach;
	this.xhr = null;
	this.progressBarPercent = null;
	this.progressPercentData = null;
	this.hasFormData = null;
	this.hasFileReader = null;
	this.fileMetaDiv = null;
	this.previewContainer = null;
	this.progressBar = null;
	this.patternImage = new RegExp('^image/*');
	this.uploadFileResourceURL = uploadFileResourceURL;
	this.portletNamespace = portletNamespace;
	this.init();
};

FileUpload.prototype.init = function() {

	try {
		new FormData();
		this.hasFormData = true;
	} catch (e) {
		this.hasFormData = false;
	}

	try {
		new FileReader();
		this.hasFileReader = true;
	} catch (e) {
		this.hasFileReader = false;
	}

	this.buildUploader();
	this.triggerUpload();
};

FileUpload.prototype.buildUploader = function() {
	var self = this;
	// container
	this.previewContainer = document.getElementById(this.portletNamespace + 'pi-preview-container');

	// contentZone
	this.fileMetaDiv = document.createElement('div');
	this.fileMetaDiv.setAttribute('class', 'file-metas');

	// progress Bar
	this.progressBar = document.createElement('div');
	this.progressBar.setAttribute('class', 'progress-bar');

	this.progressBarPercent = document.createElement('div');
	this.progressBarPercent.setAttribute('class', 'progress-bar-uploaded');
	this.progressBarPercent.style.width = 0;

	this.progressBar.appendChild(this.progressBarPercent);

	this.progressPercentData = document.createElement('span');
	this.progressPercentData.setAttribute('class', 'progress-percent');

	this.fileMetaDiv.appendChild(this.progressBar);
	this.fileMetaDiv.appendChild(this.progressPercentData);

	this.previewContainer.innerHTML = "";
	this.previewContainer.appendChild(this.fileMetaDiv);

	// test if file is an image
	if (this.isImageFile() && this.hasFileReader) {
		this.createPreview();
	}

	this.html5Uploader.appendChild(this.previewContainer);
};

FileUpload.prototype.cancelUpload = function(e) {
	e.preventDefault();
	if (this.xhr) {
		this.endProcess(0);
	}
};

FileUpload.prototype.getConvertSize = function(fileSize) {
	var test = fileSize, unitKey = 0, convert = null, result = null, unit = [
			'byte', 'KB', 'MB', 'GB', 'TB', 'PB' ];

	while ((test / 1024) >= 1) {
		convert = test = test / 1024;

		unitKey++;
	}
	result = Math.round(convert * 100) / 100;

	return (result + unit[unitKey]);
};

FileUpload.prototype.isImageFile = function() {
	return (this.file.type.match(this.patternImage)) ? true : false;
};

FileUpload.prototype.createPreview = function() {
	var self = this;
	var reader = new FileReader(), dataUrl = reader.readAsDataURL(this.file);

	reader.onloadend = function(e) {
		var result = e.target.result;

		if (result !== null && !hasFileSizeError) {

			var previewImg = document.getElementById("yui_img");
			previewImg.setAttribute('src', result);

			var resultsDiv = document.getElementById("yui_results");
			var resultsImg = getFirstChild(resultsDiv);
			resultsImg.setAttribute('src', result);

			var piPortrait = document.getElementById("pi_portrait");
			addClass(piPortrait, "hide");
			removeClass(resultsDiv, "hide");

			var previewImgContainer = document.getElementById("yui_img_container");
			removeClass(previewImgContainer, "hide");

		}
	};
};

function createReader(file, whenReady) {
	var reader = new FileReader();
	reader.onload = function(evt) {
		var image = new Image();
		image.onload = function(evt) {
			var width = this.width;
			var height = this.height;
			if (whenReady) whenReady(width, height);
		};
		image.src = evt.target.result;
	};
	reader.readAsDataURL(file);
}

FileUpload.prototype.triggerUpload = function() {
	var self = this;
	if (this.isImageFile() && this.hasFileReader) {
		if (this.file.size > this.fileSizeMax) {
			this.endProcess(2);
			hasFileSizeError = true;
		}else {
			hasFileSizeError = false;
			var reader = new FileReader();
		    reader.onload = function(evt) {
		        var image = new Image();
		        image.onload = function(evt) {
		            var width = this.width;
		            var height = this.height;
		            //document.title += "-width" + width + "-imageWidthMin" + self.imageWidthMin + "-height" + height + "-imageHeightMin" + self.imageHeightMin;
		            if (width < self.imageWidthMin) {
			        	//document.title += "-here0";
		    	    	self.endProcess(3);
		    	    }else  if (height < self.imageHeightMin) {
			        	//document.title += "-here1";
		    	    	self.endProcess(4);
		    	    }else {
		    			if (self.hasFormData) {
		    				self.uploadWithFormData();
		    			} else {
		    				if (self.hasFileReader) {
		    					self.uploadWithFileReader();
		    				} else {
		    					console.log('no support');
		    				}
		    			}
		    	    }
		        };
		        image.src = evt.target.result;
		    };
		    reader.readAsDataURL(this.file);
		}
	}else {
		if (this.file.size > this.fileSizeMax) {
			this.endProcess(2);
		}else {
			if (this.hasFormData) {
				this.uploadWithFormData();
			} else {
				if (this.hasFileReader) {
					this.uploadWithFileReader();
				} else {
					console.log('no support');
				}
			}
		}
	}
};

FileUpload.prototype.uploadWithFormData = function() {
	var datas = new FormData();
	datas.append('Filedata', this.file);

	this.sendDatas(datas);
};

FileUpload.prototype.uploadWithFileReader = function() {
	var self = this;
	var reader = new FileReader();
	reader.onload = function(e) {
		var bin = e.target.result;
		if (bin !== null) {
			self.sendDatas(bin, true);
		}
	};
	reader.readAsBinaryString(this.file);
};

FileUpload.prototype.sendDatas = function(fileDatas) {
	var saveButton = document.getElementById(this.portletNamespace + "pi-save-button");
	//document.title += " -start-saveButton: " + saveButton;
	saveButton.disabled = true;
	addClass(saveButton.parentNode, "aui-button-disabled");

	var self = this;
	this.xhr = new XMLHttpRequest();

	if (this.xhr) {
		this.xhr.upload.addEventListener("progress", function(e) {
			self.updateProgress.call(self, e);
		}, false);
		this.xhr.addEventListener("load", function() {
			self.endUpload.call(self);
		}, false);
		this.xhr.addEventListener("abort", function() {
			self.closeXhr(self);
		}, false);
		document.body.addEventListener('offline', function() {
			self.endProcess(0);
		}, false);

		this.xhr.onreadystatechange = function() {
			if (this.readyState == 4) {
				var status = this.status;

				if (status == 200) {
					self.endProcess(1);
					self.showMetadataContainer();
				}
				if (status == 404 || status == 500) {
					self.endProcess(0);
				}
			}
		};
		this.xhr.open("POST", this.uploadFileResourceURL);
		this.processUpload(fileDatas);
	}
};


FileUpload.prototype.showMetadataContainer = function() {
	//document.title += "-showMetadataContainer";
}

FileUpload.prototype.processUpload = function(fileDatas) {
	//document.title += "-processUpload";
	if (this.hasFormData) {
		//document.title += "-hasFormData";
		this.xhr.send(fileDatas);
	} else {
		if (this.hasFileReader) {

			var boundary = 'xxxxxx';
			this.xhr.setRequestHeader("Content-Type",
					"multipart/form-data; boundary=" + boundary); // simulate
			// a file
			// MIME POST
			// request.
			var body = "--" + boundary + "\r\n";
			body += "Content-Disposition: form-data; name='Filedata'; filename='"
					+ this.file.name + "'\r\n";
			body += "Content-Type:" + this.file.type + "\r\n\r\n";
			body += fileDatas + "\r\n";
			body += "--" + boundary + "--";

			this.xhr.sendAsBinary(body);
		}
	}
};

FileUpload.prototype.updateProgress = function(e) {
	if (e.lengthComputable) {
		var currentState = (e.loaded / e.total) * 100;

		this.progressPercentData.innerHTML = Math.ceil(currentState) + '%';
		this.progressBarPercent.style.width = currentState + "%";
		// this.progressBarPercent.value = currentState;
	}
};

FileUpload.prototype.endUpload = function() {
	this.progressPercentData.innerHTML = '100%';
	this.progressBarPercent.style.width = '100%';
};

FileUpload.prototype.endProcess = function(control) {
	var self = this, cls = 'state', textResponse = null;

	this.fileMetaDiv.removeChild(this.progressPercentData);
	this.fileMetaDiv.removeChild(this.progressBar);
	var feedback = document.createElement('span');
	var error = false;

	switch (control) {
	case 0:
		cls += ' state-error';
		textResponse = 'Canceled';
		error = true;
		break;
	case 1:
		cls += ' state-success';
		textResponse = 'Success';
		error = false;
		break;
	case 2:
		cls += ' state-error';
		textResponse = 'Image size must be less than ' + (this.fileSizeMax / 1024) + ' KB';
		error = true;
		break;
	case 3:
		cls += ' state-error';
		textResponse = 'The width of the image must be greater than ' + this.imageWidthMin;
		error = true;
		break;
	case 4:
		cls += ' state-error';
		textResponse = 'The height of the image must be greater than ' + this.imageHeightMin;
		error = true;
		break;
	}

	if (error) {
		feedback.setAttribute('class', cls);
		feedback.appendChild(document.createTextNode(textResponse));
		this.fileMetaDiv.appendChild(feedback);
	}else {
		var saveButton = document.getElementById(this.portletNamespace + "pi-save-button");
		//document.title += " -end-saveButton: " + saveButton;
		removeClass(saveButton.parentNode, "aui-button-disabled");
		saveButton.disabled = false;
	}

	if (this.xhr) {
		var data = JSON.parse(this.xhr.responseText);
		var fileEntryId = data.fileEntryId;
		//document.title += " -fileEntryId: " + fileEntryId;
		var tempInput = document.getElementById(this.portletNamespace + "pi-temp-input");
		tempInput.value = fileEntryId;
	}

	if (this.xhr) {
		this.xhr.abort();
	}

};

FileUpload.prototype.closeXhr = function() {
	this.xhr = null;
};