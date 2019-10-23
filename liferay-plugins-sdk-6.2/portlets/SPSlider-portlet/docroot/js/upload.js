var DndUpload = function(inputElem, commonFileMetadataContainer, uploadFileResourceURL, removeFileResourceURL,saveLinkResourceUrl, portletNamespace, fileSizeMax, imageWidthMin, imageHeightMin, allowedTypes) {
	this.input = inputElem;
	this.commonFileMetadataContainer = commonFileMetadataContainer;
	this.uploadFileResourceURL = uploadFileResourceURL;
	this.removeFileResourceURL = removeFileResourceURL;
	this.saveLinkResourceUrl = saveLinkResourceUrl;
	this.portletNamespace = portletNamespace;
	this.fileSizeMax = fileSizeMax;
	this.imageWidthMin = imageWidthMin;
	this.imageHeightMin = imageHeightMin;
	this.allowedTypes = allowedTypes;
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
	this.dropZone.setAttribute('id', 'drop-zone');
	textDropZone = document.createElement('p');
	textDropZone.setAttribute('id', 'drop-text');
	textDropZone.appendChild(document.createTextNode('Drag & Drop Your Files Here'));
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
};

DndUpload.prototype.handleDrop = function(e) {
	//document.title += "-handleDrop";
	var defaultCategory = document.getElementById("countryDeparment");
	var selectedCustomCategoryId = document.getElementById("feedSearchCatId");
	var selectedCustomVocId = 0;
	var selectedCategoryId = 0;
	if (defaultCategory.checked) {
		selectedCategoryId = document.getElementById("defaultCategory_sel_list").value;
		feedSearchCriteria = "countryRegion";
		var opt1 = document.getElementById("country");
		if (opt1 && opt1.checked) {
			searchPriority = "country";
		}else {
			searchPriority = "region";
		}
	}else {
		feedSearchCriteria = "custom";
		searchPriority = "";
		selectedCategoryId = selectedCustomCategoryId.value;
		selectedCustomVocId = document.getElementById("feedSearchVocId").value;
	}

	var uploadFileResourceURLCatgId = this.uploadFileResourceURL + "&categoryId="+selectedCategoryId + "&customVocabId=" + selectedCustomVocId+"&feedSearchCriteria="+feedSearchCriteria+"&searchPriority="+searchPriority;
//	alert("uploadFileResourceURL " +this.uploadFileResourceURL + " #### selectedCategoryId ### " +selectedCategoryId);
	e.preventDefault();
	var elem;
	var files;
	var fileUpload;
	this.dropZone.className = '';

	/*
	elem = document.getElementById('drop-text');
	if (elem) {
		this.dropZone.removeChild(elem);
	}
	*/

	files = e.dataTransfer.files;
	for (var i = 0, len = files.length; i < len; i++) {
		fileUpload = new FileUpload(this.dropZone, this.commonFileMetadataContainer, files[i], uploadFileResourceURLCatgId, this.removeFileResourceURL, this.saveLinkResourceUrl, this.portletNamespace, this.fileSizeMax, this.imageWidthMin, this.imageHeightMin, this.allowedTypes);
	}

	return false;
};

function handleFiles(files, uploadFileResourceURL, removeFileResourceURL, saveLinkResourceUrl, portletNamespace, fileSizeMax, imageWidthMin, imageHeightMin, allowedTypes) {
	try{
	//document.title += "-handleFiles";
		//alert("uploadFileResourceURL " +uploadFileResourceURL);
		var defaultCategory = document.getElementById("countryDeparment");
		var selectedCustomCategoryId = document.getElementById("feedSearchCatId");
		var selectedCustomVocId = 0;
		var selectedCategoryId = 0;
		if (defaultCategory.checked) {
			selectedCategoryId = document.getElementById("defaultCategory_sel_list").value;
		}else {
			selectedCategoryId = selectedCustomCategoryId.value;
			selectedCustomVocId = document.getElementById("feedSearchVocId").value;
		}
		var opt = document.getElementById("custom");
		alert("opt " + opt);
		if (opt && opt.checked) {
			selectedSearch = opt.checked;
			alert("opt selectedSearch " + selectedSearch);
		}else {
			opt = document.getElementById("countryDeparment");
			selectedSearch = opt.checked;
			alert("opt selectedSearch else " + selectedSearch);
		}
	var fileUpload;
	var dropZone;
	var commonFileMetadataContainer;
	dropZone = document.getElementById('drop-zone');
	commonFileMetadataContainer = document.getElementById(portletNamespace + 'commonFileMetadataContainer');
	for (var i = 0, len = files.length; i < len; i++) {
		fileUpload = new FileUpload(dropZone, commonFileMetadataContainer, files[i], uploadFileResourceURL+"&categoryId="+selectedCategoryId+"&customVocabId=" + selectedCustomVocId+"&searchPriority="+selectedSearch, removeFileResourceURL, saveLinkResourceUrl, portletNamespace, fileSizeMax, imageWidthMin, imageHeightMin, allowedTypes);
	}
}catch(err) {
	alert(err);
}
}

/*--------------------------------*/

var FileUpload = function(domAttach, commonFileMetadataContainer, file, uploadFileResourceURL, removeFileResourceURL, saveLinkResourceUrl, portletNamespace, fileSizeMax, imageWidthMin, imageHeightMin, allowedTypes) {
	this.file = file;
	this.fileSizeMax = fileSizeMax;
	this.imageWidthMin = imageWidthMin;
	this.imageHeightMin = imageHeightMin;
	this.allowedTypes = allowedTypes;
	this.attachDropZone = domAttach;
	this.commonFileMetadataContainer = commonFileMetadataContainer;
	this.xhr = null;
	this._xhr = null;
	this.progressBarPercent = null;
	this.progressPercentData = null;
	this.hasFormData = null;
	this.hasFileReader = null;
	this.fileMetaDiv = null;
	this.wrapperUploader = null;
	this.progressBar = null;
	this.btnCancel = null;
	this.patternImage = new RegExp('^image/*');
	this.uploadFileResourceURL = uploadFileResourceURL;
	this.removeFileResourceURL = removeFileResourceURL;
	this.saveLinkResourceUrl = saveLinkResourceUrl;
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
	this.wrapperUploader = document.createElement('li');
	this.wrapperUploader.setAttribute('class', 'uploader');

	var selectUploadedFileCheckbox = document.createElement('input');
	selectUploadedFileCheckbox.setAttribute('name', this.portletNamespace + 'selectUploadedFileCheckbox');
	selectUploadedFileCheckbox.setAttribute('class', 'aui-helper-hidden select-file');
	selectUploadedFileCheckbox.setAttribute('checked', 'checked');
	selectUploadedFileCheckbox.setAttribute('data-fileName', this.file.name);
	selectUploadedFileCheckbox.setAttribute('type', 'checkbox');
	selectUploadedFileCheckbox.setAttribute('value', this.file.name);
	this.wrapperUploader.appendChild(selectUploadedFileCheckbox);

	// contentZone
	this.fileMetaDiv = document.createElement('div');
	this.fileMetaDiv.setAttribute('class', 'file-metas');

	var fileName = document.createElement('div');
	fileName.setAttribute('class', 'file-name');
	fileName.appendChild(document.createTextNode(this.file.name));

	var fileSize = document.createElement('span');
	fileSize.setAttribute('class', 'file-size');
	fileSize.appendChild(document.createTextNode(this
			.getConvertSize(this.file.size)));

	fileName.appendChild(fileSize);

	// progress Bar
	this.progressBar = document.createElement('div');
	this.progressBar.setAttribute('class', 'progress-bar');

	this.progressBarPercent = document.createElement('div');
	this.progressBarPercent.setAttribute('class', 'progress-bar-uploaded');
	this.progressBarPercent.style.width = 0;
	/*
	 * this.progressBarPercent = document.createElement('progress');
	 * this.progressBarPercent.setAttribute('class', 'progress-bar-uploaded');
	 * this.progressBarPercent.setAttribute('max', '100');
	 * this.progressBarPercent.value = '0';
	 */

	this.progressBar.appendChild(this.progressBarPercent);

	this.progressPercentData = document.createElement('span');
	this.progressPercentData.setAttribute('class', 'progress-percent');

	this.fileMetaDiv.appendChild(fileName);
	this.fileMetaDiv.appendChild(this.progressBar);
	this.fileMetaDiv.appendChild(this.progressPercentData);

	this.wrapperUploader.appendChild(this.fileMetaDiv);

	// test if file is an image
	if (this.isImageFile() && this.hasFileReader) {
		this.createPreview();
	}

	// btn cancel
	this.btnCancel = document.createElement('a');
	this.btnCancel.setAttribute('class', 'btn-cancel');
	this.btnCancel.setAttribute('href', '#');
	this.btnCancel.appendChild(document.createTextNode('Cancel'));
	this.btnCancel.addEventListener('click', function(e) {
		self.cancelUpload.call(self, e);
	}, false);
	this.fileMetaDiv.appendChild(this.btnCancel);

	var assetCreateList = document.getElementById('asset-create-list');
	assetCreateList.appendChild(this.wrapperUploader);
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

		if (result !== null) {
			var previewWrap = document.createElement('div');
			previewWrap.setAttribute('class', 'file-preview');

			var imgPreview = document.createElement('img');
			imgPreview.setAttribute('src', result);
			imgPreview.setAttribute('alt', 'Image Preview');

			previewWrap.appendChild(imgPreview);
			self.wrapperUploader.insertBefore(previewWrap, self.fileMetaDiv);
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
	var allowedTypesArray = [];
	allowedTypesArray = self.allowedTypes.split(",");
	//document.title += " -allowedTypes: " + self.allowedTypes;
	//document.title += " -allowedTypesArray: " + allowedTypesArray;
	if (allowedTypesArray.indexOf(this.file.type) == -1) {
		self.endProcess(5);
	}else if (this.isImageFile() && this.hasFileReader) {
		if (this.file.size > this.fileSizeMax) {
			this.endProcess(2);
		}else {
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
	var self = this, cls = 'state', textResponse = null, del = false;
	this.fileMetaDiv.removeChild(this.progressPercentData);
	this.fileMetaDiv.removeChild(this.progressBar);
	this.fileMetaDiv.removeChild(this.btnCancel);
	var successFeedback = document.createElement('span');
	switch (control) {
	case 0:
		cls += ' state-error';
		textResponse = 'Canceled';
		break;
	case 1:
		cls += ' state-success';
		textResponse = 'Success';
		del = true;
		break;
	case 2:
		cls += ' state-error';
		textResponse = 'Image size must be less than ' + this.fileSizeMax/(1024*1024) + 'MB';
		break;
	case 3:
		cls += ' state-error';
		textResponse = 'The width of the image must be greater than ' + this.imageWidthMin +' px';
		break;
	case 4:
		cls += ' state-error';
		textResponse = 'The height of the image must be greater than ' + this.imageHeightMin +' px';
		break;
	case 5:
		cls += ' state-error';
		textResponse = 'This file type is not supported';
		break;
	}
	if (del) {
		if (this.xhr) {
			var data = JSON.parse(this.xhr.responseText);
			var isDuplicate = data.isDuplicate;
			if (isDuplicate) {
				cls += ' state-error';
				textResponse = 'Cannot upload file with same name';

				successFeedback.setAttribute('class', cls);
				successFeedback.appendChild(document.createTextNode(textResponse));
				this.fileMetaDiv.appendChild(successFeedback);
			}else {
				successFeedback.setAttribute('class', cls);
				successFeedback.appendChild(document.createTextNode(textResponse));
				this.fileMetaDiv.appendChild(successFeedback);

				var fileEntryId = data.fileEntryId;
				//document.title += "-fileEntryId: " + fileEntryId;
				var removeLink = document.createElement('a');
				removeLink.setAttribute('href', "#");
				removeLink.setAttribute('data-file-entry-id', fileEntryId);
				removeLink.innerHTML = "Remove";
				removeLink.setAttribute('class', 'sp-mlm state-error');
				removeLink.addEventListener("click", function(e) {
					self.removeFile.call(self, e);
				}, false);
				this.fileMetaDiv.appendChild(removeLink);
				var linkLabel = document.createElement('div');
				var linkLabelText = document.createTextNode('HyperLink');
				var linkNodeDiv = document.createElement('div');
				linkNodeDiv.setAttribute('id', "linkUrl_saveDiv"+fileEntryId);
				var linkNode = document.createElement('input');
				linkNode.setAttribute('type', "text");
				linkNode.setAttribute('id', "imageLink"+fileEntryId);
				linkNode.setAttribute('name', "imageLink");
				linkLabel.appendChild(linkLabelText);
				linkNodeDiv.appendChild(linkLabel);
				linkNodeDiv.appendChild(linkNode);

				var saveLinkUrl = document.createElement('a');
				saveLinkUrl.setAttribute('href', "#");
				saveLinkUrl.setAttribute('id', "urlSaveLink"+fileEntryId);
				saveLinkUrl.setAttribute('data-file-entry-id', fileEntryId);
				saveLinkUrl.innerHTML = "Save";
				saveLinkUrl.setAttribute('class', 'sp-mlm');
				saveLinkUrl.addEventListener("click", function(e) {
					self.saveLink.call(self, e);
				}, false);
				linkNodeDiv.appendChild(saveLinkUrl);
				var imglinkEdit = document.createElement('div');
				imglinkEdit.setAttribute("id","linkUrl_editDiv"+fileEntryId);
				var linkText = document.createElement('div');
				linkText.setAttribute("id","linkUrl_span"+fileEntryId);
				var ediLinkUrl = document.createElement('a');
				ediLinkUrl.setAttribute('href', "javascript:editLinkUrl(" + fileEntryId + ")");
				ediLinkUrl.innerHTML = "Edit";
				imglinkEdit.appendChild(linkText);
				imglinkEdit.appendChild(ediLinkUrl);
//				var imgSave = document.createElement('div');
//				imgSave.setAttribute("id","urlSaveIcon"+fileEntryId);
//				imgSave.setAttribute("style","color:green;");
//				imgSave.setAttribute("style","display:none;");
//				imgSave.innerHTML = "Link Saved"
//				linkNodeDiv.appendChild(imgSave);
				this.fileMetaDiv.appendChild(imglinkEdit);
				this.fileMetaDiv.appendChild(linkNodeDiv);

			}
		}
	}else {
		successFeedback.setAttribute('class', cls);
		successFeedback.appendChild(document.createTextNode(textResponse));
		this.fileMetaDiv.appendChild(successFeedback);
	}

	if (this.xhr) {
		this.xhr.abort();
	}
};

FileUpload.prototype.closeXhr = function() {
	this.xhr = null;
};

FileUpload.prototype.removeFile = function(e) {
	//document.title += "-removeLinkClick";
	e.preventDefault();
	var self = this;
	var target = getEventTarget(e);
	var fileEntryId = target.getAttribute("data-file-entry-id");
	var tempRemoveFileResourceURL = this.removeFileResourceURL;
	tempRemoveFileResourceURL += "&fileEntryId=" + fileEntryId;
	AjaxGet("GET", tempRemoveFileResourceURL, removeFileSuccess, removeFileError);
};

FileUpload.prototype.saveLink = function(e) {
	//document.title += "-removeLinkClick";
	e.preventDefault();
	var self = this;
	var target = getEventTarget(e);
	var fileEntryId = target.getAttribute("data-file-entry-id");
	var linkUrl = document.getElementById("imageLink"+fileEntryId).value;
	if ((linkUrl.indexOf("http://") == 0 ) || (linkUrl.indexOf("https://") == 0 ) || (linkUrl.indexOf("/") == 0 )) {
		var tempSaveLinkURL = this.saveLinkResourceUrl;
		tempSaveLinkURL += "&fileEntryId=" + fileEntryId + "&linkUrl=" + linkUrl;
		AjaxGet("GET", tempSaveLinkURL, saveSuccess, saveError);
	} else {
	    alert("Please enter a valid URL.\nFormat for: \nExternal links - 'https://www.example.com (OR) http://www.example.com'.\nInternal page links - '/page-name'");
	}
};

function removeFileSuccess() {
try{
	//document.title += "-removeFileSuccess";
	var data = JSON.parse(_xhr.responseText);
	var fileEntryId = data.fileEntryId;
	//document.title += "**fileEntryId: " + fileEntryId;
	var removeFileLink = getFirstElementsByAttribute(document, "a", "data-file-entry-id", fileEntryId);
	var uploader = getClosestParentByAttribute(removeFileLink, "class", "uploader");
	uploader.parentNode.removeChild(uploader);

}catch(err) {
	alert(err);
}
}

function removeFileError() {
try{
	alert("Oops! An error occurred while processing your request.");
}catch(err) {
	alert(err);
}
}

function saveSuccess() {
	var data = JSON.parse(_xhr.responseText);
	var fileEntryId = data.fileEntryId;

	document.getElementById("linkUrl_span"+fileEntryId).innerHTML = data.linkUrl;
	document.getElementById("linkUrl_editDiv"+fileEntryId).style.display = "block";
	document.getElementById("linkUrl_saveDiv"+fileEntryId).style.display = "none";
//	var saveIcon = document.getElementById("urlSaveIcon"+fileEntryId);
//	saveIcon.style.display="block";
//	var savelink = document.getElementById("urlSaveLink"+fileEntryId);
//	savelink.style.display="none";
}

function saveError() {
	try{
		alert("Oops! An error occurred while processing your request.");
	}catch(err) {
		alert(err);
	}
}

function AjaxGet(method, url, successFunc, errorFunc) {
	alert("ajaxget");
try{
	if (window.XMLHttpRequest) {
		// code for IE7+, Firefox, Chrome, Opera, Safari
		_xhr = new XMLHttpRequest();
	}
	else {
		// code for IE6, IE5
		_xhr = new ActiveXObject("Microsoft.XMLHTTP");
	}
	_xhr.onreadystatechange = function() {
		if (_xhr.readyState == 4) {
		    if (_xhr.status == 200) {
		    	successFunc();
		    }
		    else {
		    	errorFunc();
		    }
		}
	};

	_xhr.open(method, url,  true);
	_xhr.send(null);

}catch(err) {
	alert(err);
}
}
