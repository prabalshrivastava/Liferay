var DndUpload = function(inputElem, uploadFileResourceURL, removeFileResourceURL, portletNamespace, fileSizeMax, imageWidthMin, imageHeightMin) {
	this.input = inputElem;
	this.uploadFileResourceURL = uploadFileResourceURL;
	this.removeFileResourceURL = removeFileResourceURL;
	this.portletNamespace = portletNamespace;
	this.fileSizeMax = fileSizeMax;
	this.imageWidthMin = imageWidthMin;
	this.imageHeightMin = imageHeightMin;
	//this.allowedTypes = allowedTypes;
	this.dropZone = null;
	this.isDragging = false;
	this.init();
};

var folderEnable = false;
var rootDir = false;
var dir_no = 0;
var dir_index = 0;
var thumbStat;
var folderName;
var directorySize = 0;
var directorySizeArray = [];
var arraySizeFolder = [];
var tm = "testmessage";
var objName = [];
var fileQueueT = [];

DndUpload.prototype.init = function() {
	this.buildDropZone();
};

DndUpload.prototype.buildDropZone = function() {
	//document.title += "-buildDropZone";
	var self = this, textDropZone;
	//this.input.style.display = 'none';
	this.dropZone = document.createElement('div');
	this.dropZone.setAttribute('id', 'drop-zone');
	textDropZone = document.createElement('p');
	textDropZone.setAttribute('id', 'drop-text1');
	textDropZone.setAttribute('class', 'drop-text-zone');

	textDropZone.appendChild(document.createTextNode('Choose a folder to upload files/folders'));
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
	//console.log(e.currentTarget);
	e.preventDefault();

	e.target.className = 'hover';
	//toggleClass(e.currentTarget,'hover');

};

DndUpload.prototype.handleDragEnter = function(e) {
	//document.title += "-handleDragEnter";
	e.preventDefault();
	var t = e.currentTarget;
	this.isDragging = true;
	this.dropZone.className = 'active';
	//toggleClass(t, 'active');
};

DndUpload.prototype.handleDragLeave = function(e) {
	//document.title += "-handleDragLeave";
	e.preventDefault();
	var t = e.currentTarget;
	var target = e.target, parentElem = target.parentNode, flag = false;
	target.className = '';
	//toggleClass(target, 'active');
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


var folderItemLength = 0;
var dc=0;
DndUpload.prototype.handleDrop = function(e) {
	//document.title += "-handleDrop";
	e.preventDefault();
	var elem;
	var files;
	var fileUpload;
	this.dropZone.className = '';
	e.target.className = '';
	e.dataTransfer.dropEffect = 'none';
	e.dataTransfer.effectAllowed = 'all';
	var obj = e.dataTransfer;
	/*
	elem = document.getElementById('drop-text');
	if (elem) {
		this.dropZone.removeChild(elem);
	}
	*/
	files = e.dataTransfer.files;

	var dataTransfer = e.dataTransfer;
	// this.objName;

	 if (obj) {
		 //console.log(obj);
	 }
	 else {
		 //console.log('nothing');
	 }


	  	 if (dataTransfer && dataTransfer.items) {
	  		//console.log('Dragged Item/s inside');
			  var items = dataTransfer.items,
				  len   = items.length,
				  i, entry;

			  for (i=0; i<len; i++) {
				  entry = items[i];
				  directorySize = 0;


				  if (entry.getAsEntry) {
					  //console.log("Not Chrome");
					  entry = entry.getAsEntry();


					}else if (entry.webkitGetAsEntry) {
						//console.log("Chrome");
						entry = entry.webkitGetAsEntry();

					}


				  //if (entry.name != objName)

				  if (objName.indexOf(entry.name) == -1) {
					  	objName.push(entry.name);
					  //this.uploadFileResourceURL = this.uploadFileResourceURL + entry.fullPath;
					  	if (entry.isFile) {

					  		thumbStat = 'showThumb';
					  		rootDir = false;
					  		folderName = '';

					  			//console.log("FResourceURL: "+this.uploadFileResourceURL);

//					  			readFile(entry, this.dropZone, this.uploadFileResourceURL, this.removeFileResourceURL,  this.portletNamespace, this.fileSizeMax, this.imageWidthMin, this.imageHeightMin, this.allowedTypes, thumbStat,-1);
					  			readFile(entry, this.dropZone, this.uploadFileResourceURL, this.removeFileResourceURL,  this.portletNamespace, this.fileSizeMax, this.imageWidthMin, this.imageHeightMin,  thumbStat,-1);
					  	}
					  	else if (entry.isDirectory) {
					  		folderItemLength = 0;
					  		dc=0;
					  		thumbStat = 'noThumb';
					  		rootDir = true;
					  		folderName = entry.name;
					  		createRootDir(folderName,dir_index );
					  		collapseFolder();
					  		tm = "testmessage" + dir_index;
//					  		readFile(entry, this.dropZone, this.uploadFileResourceURL, this.removeFileResourceURL,  this.portletNamespace, this.fileSizeMax, this.imageWidthMin, this.imageHeightMin, this.allowedTypes, thumbStat,dir_index);
					  		readFile(entry, this.dropZone, this.uploadFileResourceURL, this.removeFileResourceURL,  this.portletNamespace, this.fileSizeMax, this.imageWidthMin, this.imageHeightMin, thumbStat,dir_index);
					  		//console.log("Root Directory"+dir_index+" Size: " +directorySize);
					  		//console.log(" dir size " + directorySizeArray[dir_index]);

					  		dir_no++;
					  		dir_index++;
					  		//FileUpload.prototype.call(TestFunction);

					  	}
				  	}
				  else {
					  alert("Cannot upload same file/folder: " +entry.name);
				  }
			  	}
			  var arrayLength = directorySizeArray.length;
			  for (var i = 0; i < arrayLength; i++) {
			      //console.log(" dir size " + directorySizeArray[i]);
			      //Do something
			  }
		  }
	  	 else {
	  		 //console.log("Only Files");
	  		 thumbStat = 'showThumb';
	  		for (var i = 0, len = files.length; i < len; i++) {
	  			//alert("adding file"+i);
//	  			fileUpload = new FileUpload(this.dropZone, files[i], this.uploadFileResourceURL, this.removeFileResourceURL, this.portletNamespace, this.fileSizeMax, this.imageWidthMin, this.imageHeightMin, this.allowedTypes, thumbStat, -1 );
	  			fileUpload = new FileUpload(this.dropZone, files[i], this.uploadFileResourceURL, this.removeFileResourceURL, this.portletNamespace, this.fileSizeMax, this.imageWidthMin, this.imageHeightMin, thumbStat, -1 );
	  			//addItemToQueue(fileUpload);
	  		}
	  		//submitFiles();
	  	 }

};
function submitFiles() {
	//console.log("queue size"+fileQueueT.length);
	 while (!isQueueEmpty()) {

		var fileItem = fileQueueT.shift();
		fileItem.triggerUpload();
		//console.log("processed " + fileItem.processed + "name=" + fileItem.file.name);
		if (fileItem.file.name == '.DS_Store') {
			continue;
		}
	/*	while (fileItem.processed == false) {

		}
		setTimeout(function() {
			console.log("inside timeout" );
			fileItem.processed = true;
			console.log("inside timeout" + fileItem.processed );
		}, 2000); */

	 }
}
function isQueueEmpty() {
	if (fileQueueT.length == 0) {
		return true;
	}else {
		return false;
	}
}
function addItemToQueue(fileItemToUpload) {
	alert("adding entry"+fileItemToUpload+"at"+ fileQueueT.length);
	fileQueueT.push(fileItemToUpload);
}
var folderEnable = false;

var readFile = function(itemEntry, dz, ufr, rfr, pn, fsm, imgWmin, imgHmin, ts,dirind) {

	var fileUp;
	//this.objName;

	if (itemEntry.getAsEntry) {
		itemEntry = itemEntry.getAsEntry();
	}else if (itemEntry.webkitGetAsEntry) {
		itemEntry = itemEntry.webkitGetAsEntry();
	}



		if (itemEntry.isFile) {
			//console.log("Testing: File" + itemEntry);

			rf(itemEntry, FileUpload, dz, ufr, rfr, pn, fsm, imgWmin, imgHmin, ts, dirind, itemEntry.fullPath);

		}else if (itemEntry.isDirectory) {
				//console.log("Root Folder: " + itemEntry.name);

				folderItemLength = folderItemLength - dc;
				dc = 1;
				var dirReader = itemEntry.createReader();

				dirReader.readEntries(function(entries) {
					var idx = entries.length;
					folderItemLength = folderItemLength + idx;
					//console.log("No of Files in Folder"+dirind+": " +folderItemLength);
					//console.log("Entries in Directory: " +idx);

					for (var i = 0; i < idx; i++) {

						readFile(entries[i], dz, ufr, rfr, pn, fsm, imgWmin, imgHmin, ts,dirind );
						//console.log(entries[i]);
					}
				});

		}




};

function rf(fileEntry, callback, dz, ufr, rfr, pn, fsm, imgWmin, imgHmin, ts,dirind, fp) {
	//Get File object from FileEntry
	var fUp;

	fileEntry.file(function(callback, file) {
		if (callback) {

		//	fUp = new callback(dz,file, ufr, rfr, pn, fsm, imgWmin, imgHmin, ts,dirind, fp);
			 fUp = new FileUpload(dz,file, ufr, rfr, pn, fsm, imgWmin, imgHmin, ts,dirind, fp);
			//addItemToQueue(fUp);
			 //console.log("inside-callback-" + fileQueueT.length);
		//	 fileQueueT.push(fUp);
			// submitFiles();
		}
	}.bind(this, callback));
}


function createRootDir(fn, dir_index) {


	// container
	var folderWrapper = document.createElement('li');
	folderWrapper.setAttribute('class', 'uploader folderDirectory');
	folderWrapper.setAttribute('id','fd' + dir_index);

	// contentZone

	var folderMetaDiv = document.createElement('div');
	folderMetaDiv.setAttribute('class', 'file-metas');
	folderMetaDiv.setAttribute('id', 'file_metas_fd' + dir_index);



	var fileName = document.createElement('div');
	fileName.setAttribute('class', 'file-name');
	fileName.setAttribute('id','folderName_'+ dir_index);
	fileName.appendChild(document.createTextNode(fn + ' (Folder)'));



	var fileSize = document.createElement('span');
	fileSize.setAttribute('class', 'file-size');
	fileSize.setAttribute('id','rootDirSize_fd' + dir_index);
	//console.log('root dir id rootDirSize_fd' + dir_index);
	fileSize.appendChild(document.createTextNode(directorySize));

	fileName.appendChild(fileSize);


	var folderDropIcon = document.createElement('a');
	folderDropIcon.setAttribute('id','folderDropIcon_fd'+dir_index);
	folderDropIcon.setAttribute('class','folderDropIcon');

	folderDropIcon.addEventListener('click', revealList, false);


	var folderLoaderIcon = document.createElement('div');
	folderLoaderIcon.setAttribute('id','folderLoaderIcon_fd'+dir_index);
	folderLoaderIcon.setAttribute('class','folderLoaderIcon');

	var folderLoaderIconImg = document.createElement('img');
	folderLoaderIconImg.setAttribute('src','/FileSharing-portlet/images/loading_spinner.gif');

	folderLoaderIcon.appendChild(folderLoaderIconImg);


	fileName.appendChild(folderDropIcon);
	
	var uploadResultMsg = document.createElement('span');
	uploadResultMsg.setAttribute('id', 'uploadResultMsgId'+dir_index);
	uploadResultMsg.setAttribute('class', 'file-size');
	uploadResultMsg.setAttribute('style', 'color: #b94a48');
	
	
	fileName.appendChild(uploadResultMsg);
	
	//fileName.appendChild(folderLoaderIcon);

	folderMetaDiv.appendChild(fileName);

/*	var fileShare = document.createElement('div');
	fileShare.setAttribute('class', 'file-share');

	var fileShareTextBoxWrap = document.createElement('div');
	fileShareTextBoxWrap.setAttribute('class','fs-txtWrap');

	var fileShareBtn = document.createElement('a');
	fileShareBtn.setAttribute('class','file-shareCTA');
	fileShareBtn.setAttribute('id','file-shareCTA');
	fileShareBtn.setAttribute('href','#');
	fileShareBtn.appendChild(document.createTextNode('Share'));





	var fileShareTextBox = document.createElement('input');
	fileShareTextBox.setAttribute('type','text');

	var fileShareTextBoxSend = document.createElement('a');
	fileShareTextBoxSend.setAttribute('class','fs-txtCTA');
	fileShareTextBoxSend.setAttribute('id','fs-txtCTA');
	fileShareTextBoxSend.setAttribute('href','#');
	fileShareTextBoxSend.appendChild(document.createTextNode('Share'));

	var fileShareTextBoxCancel = document.createElement('a');
	fileShareTextBoxCancel.setAttribute('class','fs-txtCTACancel');
	fileShareTextBoxCancel.setAttribute('id','fs-txtCTACancel');
	fileShareTextBoxCancel.setAttribute('href','#');
	fileShareTextBoxCancel.appendChild(document.createTextNode('Cancel'));




	fileShareTextBoxWrap.appendChild(fileShareTextBox);

	fileShareTextBoxWrap.appendChild(fileShareTextBoxSend);
	fileShareTextBoxWrap.appendChild(fileShareTextBoxCancel);

	fileShare.appendChild(fileShareBtn);
	fileShare.appendChild(fileShareTextBoxWrap);

	fileShareTextBoxWrap.style.display = 'none';


	fileShareBtn.addEventListener('click', function(e) {
		e.preventDefault();
		fileShareTextBoxWrap.style.display = 'inline-block';
		e.target.style.display = 'none';

	}, false);

	fileShareTextBoxCancel.addEventListener('click', function(e) {
		e.preventDefault();
		fileShareTextBoxWrap.style.display = 'none';
		fileShareBtn.style.display = 'inline-block';


	}, false); */



	// progress Bar
	//console.log("create progressbar for folder" +dir_index);
	var progressBar = document.createElement('div');
	progressBar.setAttribute('class', 'progress-bar-folder');
	progressBar.setAttribute('id', 'progress_bar_fd' + dir_index);

	var progressBarPercent = document.createElement('div');
	progressBarPercent.setAttribute('class', 'progress-bar-folder-uploaded');
	progressBarPercent.setAttribute('id', 'progressBarPercentFd_' + dir_index);
	progressBarPercent.style.width = 0;




	var progressPercentData = document.createElement('span');
	progressPercentData.setAttribute('class', 'progress-folder-percent');
	progressPercentData.setAttribute('id', 'progressPercentDataFd_'+ dir_index);

	progressBar.appendChild(progressBarPercent);
	progressBar.appendChild(progressPercentData);
	//folderMetaDiv.appendChild(progressBar);


	//console.log("PROGRESS-BAR CREATED for folder" +dir_index +": "+progressBar.innerHTML);

	folderWrapper.appendChild(folderMetaDiv);

	//console.log(folderMetaDiv.innerHTML);

	var createAssetFolderList = document.createElement('ul');
	createAssetFolderList.setAttribute('class', 'assetCreateFolderList');
	createAssetFolderList.setAttribute('id', 'asset-create-folder-list-wrap-folderDropIcon_fd'+dir_index);

	var createFolderContentWrap = document.createElement('div');
	createFolderContentWrap.setAttribute('id', 'asset-create-folder-list-folderDropIcon_fd'+dir_index);
	createFolderContentWrap.setAttribute('class', 'asset-create-folder-list');

	createFolderContentWrap.appendChild(createAssetFolderList);

	var assetCreateList = document.getElementById('asset-create-list');

	/*folderWrapper.appendChild(fileShare);*/
	folderWrapper.appendChild(createFolderContentWrap);

	assetCreateList.appendChild(folderWrapper);

	//collapseFolder();

}


function handleFiles(files, uploadFileResourceURL, removeFileResourceURL, portletNamespace, fileSizeMax, imageWidthMin, imageHeightMin) {
try{
	//document.title += "-handleFiles";
	var fileUpload;
	var dropZone;
	var ts = 'showThumb';
	dropZone = document.getElementById('drop-zone');
	for (var i = 0, len = files.length; i < len; i++) {
		fileUpload = new FileUpload(dropZone, files[i], uploadFileResourceURL, removeFileResourceURL, portletNamespace, fileSizeMax, imageWidthMin, imageHeightMin, ts);
	}
}catch(err) {
	alert(err);
}
}

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


/*--------------------------------*/


var FileUpload = function(domAttach, file, uploadFileResourceURL, removeFileResourceURL, portletNamespace, fileSizeMax, imageWidthMin, imageHeightMin, ts,dirindt, fp) {
	this.file = file;
	this.fileSizeMax = fileSizeMax;
	this.imageWidthMin = imageWidthMin;
	this.imageHeightMin = imageHeightMin;
	//this.allowedTypes = allowedTypes;
	this.attachDropZone = domAttach;
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
	this.portletNamespace = portletNamespace;
	this.thumbStatus = ts;
	this.dirind = dirindt;
	this.fullPath = fp;
	this.processed = false;
	this.retryCount = 0;
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





	if (this.thumbStatus == 'noThumb') {


		directorySize = directorySize + this.file.size;
		if (this.dirind != -1) {
			if (!directorySizeArray[this.dirind]) {
				directorySizeArray[this.dirind] = 0;
			}
			directorySizeArray[this.dirind] = directorySizeArray[this.dirind] + this.file.size;
			//console.log("file size -- " + directorySizeArray[this.dirind] + ": folder index: " +this.dirind);
			if (document.getElementById('rootDirSize_fd'+this.dirind)) {
				document.getElementById('rootDirSize_fd'+this.dirind).innerHTML = this.getConvertSize(directorySizeArray[this.dirind]);
			}


		}
		arraySizeFolder.push(directorySize);
		//console.log("Directory "+dir_index+" : " + this.getConvertSize(directorySize));
		//console.log("arraySizeFolder: "+arraySizeFolder.length);
		//console.log(tm);
		//document.getElementById('rootDirSize_fd'+dir_index).innerHTML = this.getConvertSize(directorySize);

	}
	//console.log("File Path - "+ this.fullPath);

	this.buildUploader();
	this.triggerUpload();
};


FileUpload.prototype.refreshUploader = function(list) {
	
	if (list){
		list.parentElement.removeChild(list);
	}
		
}

FileUpload.prototype.buildUploader = function(nextSibling) {
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

	/*this.fileShare = document.createElement('div');
	this.fileShare.setAttribute('class', 'file-share');

	var fileShareTextBoxWrap = document.createElement('div');
	fileShareTextBoxWrap.setAttribute('class','fs-txtWrap');

	var fileShareBtn = document.createElement('a');
	fileShareBtn.setAttribute('class','file-shareCTA');
	fileShareBtn.setAttribute('id','file-shareCTA');
	fileShareBtn.setAttribute('href','#');
	fileShareBtn.appendChild(document.createTextNode('Share'));





	var fileShareTextBox = document.createElement('input');
	fileShareTextBox.setAttribute('type','text');

	var fileShareTextBoxSend = document.createElement('a');
	fileShareTextBoxSend.setAttribute('class','fs-txtCTA');
	fileShareTextBoxSend.setAttribute('id','fs-txtCTA');
	fileShareTextBoxSend.setAttribute('href','#');
	fileShareTextBoxSend.appendChild(document.createTextNode('Share'));

	var fileShareTextBoxCancel = document.createElement('a');
	fileShareTextBoxCancel.setAttribute('class','fs-txtCTACancel');
	fileShareTextBoxCancel.setAttribute('id','fs-txtCTACancel');
	fileShareTextBoxCancel.setAttribute('href','#');
	fileShareTextBoxCancel.appendChild(document.createTextNode('Cancel'));




	fileShareTextBoxWrap.appendChild(fileShareTextBox);

	fileShareTextBoxWrap.appendChild(fileShareTextBoxSend);
	fileShareTextBoxWrap.appendChild(fileShareTextBoxCancel);

	this.fileShare.appendChild(fileShareBtn);
	this.fileShare.appendChild(fileShareTextBoxWrap);

	fileShareTextBoxWrap.style.display = 'none';


	fileShareBtn.addEventListener('click', function(e) {
		e.preventDefault();
		fileShareTextBoxWrap.style.display = 'inline-block';
		e.target.style.display = 'none';

	}, false);

	fileShareTextBoxCancel.addEventListener('click', function(e) {
		e.preventDefault();
		fileShareTextBoxWrap.style.display = 'none';
		fileShareBtn.style.display = 'inline-block';


	}, false); */



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


	/*this.wrapperUploader.appendChild(this.fileShare);*/

	if (this.thumbStatus == 'showThumb') {
		assetCreateList.appendChild(this.wrapperUploader);
	}

	if (this.thumbStatus == 'noThumb') {
		var assetCreateFolderList = document.getElementById('asset-create-folder-list-wrap-folderDropIcon_fd'+this.dirind);

		//assetCreateFolderList.appendChild(this.wrapperUploader);
		assetCreateFolderList.insertBefore(this.wrapperUploader, nextSibling);

		var folderW = document.getElementById('folderName_'+this.dirind);

		var folderLoadW = document.createElement('div');
		folderLoadW.setAttribute('id', 'folderLoaderIcon_fd'+this.dirind);
		folderLoadW.setAttribute('class', 'folderLoaderIcon');

		var folderLoad = document.createElement('img');
		folderLoad.setAttribute('src', '/FileSharing-portlet/images/loading_spinner.gif');

		folderLoadW.appendChild(folderLoad);
		folderW.appendChild(folderLoadW);
	}

};

FileUpload.prototype.cancelUpload = function(e) {
	e.preventDefault();
	this.processed = true;
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
			imgPreview.setAttribute('alt', 'Image');
			imgPreview.setAttribute('width', '150px');

			previewWrap.appendChild(imgPreview);
			self.wrapperUploader.insertBefore(previewWrap, self.fileMetaDiv);
		}
	};
};



FileUpload.prototype.triggerUpload = function() {


	var self = this;

	//var allowedTypesArray = [];
	//console.log("allowedTypes3: " + self.portletNamespace);
	//allowedTypesArray = self.allowedTypes.split(",");

	//document.title += " -allowedTypes: " + self.allowedTypes;
	//document.title += " -allowedTypesArray: " + allowedTypesArray;


	 if (this.isImageFile() && this.hasFileReader) {

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
		    					//console.log('no support');
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
					//console.log('no support');
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
	//var confirmButton = document.getElementById(this.portletNamespace + "saveButton");
	//document.title += " -start-confirmButton: " + confirmButton;
	//confirmButton.disabled = true;
	//addClass(confirmButton.parentNode, "aui-button-disabled");

	var self = this;
	this.xhr = new XMLHttpRequest();

	if (this.xhr) {
		this.xhr.upload.addEventListener("progress", function(e) {
			self.updateProgress.call(self, e);
		}, false);
		this.xhr.addEventListener("load", function() {
			self.processed = true;
			self.endUpload.call(self);
		}, false);
		this.xhr.addEventListener("abort", function() {
			self.processed = true;
			self.closeXhr(self);
		}, false);
		document.body.addEventListener('offline', function() {
			self.processed = true;
			self.endProcess(0);
		}, false);

		this.xhr.onreadystatechange = function() {
			if(this.responseText){
				var statusMsg = JSON.parse(this.responseText).statusMsg;
			}
			
			if (this.readyState == 4) {
				self.processed = true;
				var status = this.status;

				if (status == 200) {
					if(statusMsg == 'error'){
						self.endProcess(6);
					} else if (statusMsg == 'Invalid file name'){
						self.endProcess(7);
					} else if (statusMsg == 'Reupload the files'){
						self.endProcess(8);
					} else{
						self.endProcess(1);
					}
				}
				if (status == 404 || status == 500) {
					self.endProcess(0);
				}
			}
		};


		//console.log('Item: '+this.file.name+' File Path: '+this.fullPath + ' : uploadFileResourceURL : ' + this.uploadFileResourceURL+'&filePath='+this.fullPath );
		var folderId = getCurrentFolderId();
		this.xhr.open("POST", this.uploadFileResourceURL.concat('&filePath='+this.fullPath + "&folderId="+folderId));
		this.processUpload(fileDatas);
	}
};


FileUpload.prototype.showMetadataContainer = function() {
	//document.title += "-showMetadataContainer";

	//var upload_portion = document.getElementById("uploader_content");
	//upload_portion.setAttribute("class","aui-column aui-w50");
	var dropZone = document.getElementById("drop-zone");
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

	if (this.thumbStatus == 'showThumb') {

		if (e.lengthComputable) {

				//console.log("Test");
				var currentState = (e.loaded / e.total) * 100;

				this.progressPercentData.innerHTML = Math.ceil(currentState) + '%';
				this.progressBarPercent.style.width = currentState + "%";
				// this.progressBarPercent.value = currentState;

		}
	}else {
		if (e.lengthComputable) {

				//console.log("Test");
				var currentState = (e.loaded / e.total) * 100;

				this.progressPercentData.innerHTML = Math.ceil(currentState) + '%';
				this.progressBarPercent.style.width = currentState + "%";
				// this.progressBarPercent.value = currentState;

		}
	}


};


FileUpload.prototype.endUpload = function() {
	this.processed = true;
	if (this.thumbStatus == 'showThumb') {
		this.progressPercentData.innerHTML = '100 %';
		this.progressBarPercent.style.width = '100%';
	}else {
		this.progressPercentData.innerHTML = '100 %';
		this.progressBarPercent.style.width = '100%';
	}
};

FileUpload.prototype.endProcess = function(control) {
	var self = this, cls = 'state', textResponse = null, del = false;
	this.processed = true;
	if (this.thumbStatus == 'showThumb') {
		this.fileMetaDiv.removeChild(this.progressPercentData);
		this.fileMetaDiv.removeChild(this.progressBar);
		this.fileMetaDiv.removeChild(this.btnCancel);
	}
	else if (this.thumbStatus == 'noThumb') {
		//var fw = document.getElementById('file_metas_fd'+this.dirind);
		//var pfd = document.getElementById('progress_bar_fd'+this.dirind);
		//fw.removeChild(pfd);
		var folderW = document.getElementById('folderName_'+this.dirind);
		var folderIcon = document.getElementById('folderLoaderIcon_fd'+this.dirind);
		var uploadResultMsg = document.getElementById('uploadResultMsgId'+this.dirind);
		folderW.removeChild(folderIcon);
		this.fileMetaDiv.removeChild(this.progressPercentData);
		this.fileMetaDiv.removeChild(this.progressBar);
		this.fileMetaDiv.removeChild(this.btnCancel);
		fw  = null;
		pfd = null;

	}


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
	case 6:
		cls += ' state-error';
		// checking the retry count
		this.retryCount = this.retryCount + 1;
		if (this.retryCount <= 3){
			textResponse = 'Upload failed.';
		}else{
			textResponse = 'Upload failed. Please reupload the files';
		}
		
		break;
	case 7:
		cls += ' state-error';
		textResponse = 'Invalid fine name. Please change the file name and reupload';
		break;
	case 8:
		cls += ' state-error';
		textResponse = 'Upload failed. Please reupload the files';
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
				if (this.thumbStatus == 'showThumb') {
					this.fileMetaDiv.appendChild(successFeedback);
				}
				else if (this.thumbStatus == 'noThumb') {
					this.fileMetaDiv.appendChild(successFeedback);
				}
			}else {
				successFeedback.setAttribute('class', cls);
				successFeedback.appendChild(document.createTextNode(textResponse));
				if (this.thumbStatus == 'showThumb') {
					this.fileMetaDiv.appendChild(successFeedback);
				}
				else if (this.thumbStatus == 'noThumb') {
					this.fileMetaDiv.appendChild(successFeedback);
				}

				var fileEntryId = data.fileEntryId;
				//document.title += "-fileEntryId: " + fileEntryId;
				var removeLink = document.createElement('a');
				removeLink.setAttribute('href', "#");
				removeLink.setAttribute('id', "file_" + fileEntryId);
				removeLink.setAttribute('data-file-entry-id', fileEntryId);
				removeLink.setAttribute('data-file-name-entry', this.file.name);
				removeLink.innerHTML = "Remove";
				removeLink.setAttribute('class', 'sp-mlm state-error');
				removeLink.addEventListener("click", function(e) {
					self.removeFile.call(self, e);
				}, false);
				if (this.thumbStatus == 'showThumb') {
					this.fileMetaDiv.appendChild(removeLink);
				}else {
					this.fileMetaDiv.appendChild(removeLink);
				}


				self.showMetadataContainer();
			}
		}
	}else {
		
		if (this.thumbStatus == 'noThumb'){
			uploadResultMsg.innerHTML = "Some files failed to upload. Please click on '+' to view details";
		}
		
		successFeedback.setAttribute('class', cls);
		successFeedback.appendChild(document.createTextNode(textResponse));
		
		if (control == 6 && this.retryCount <= 3){
			
			
			this.btnRetry = document.createElement('a');
			this.btnRetry.setAttribute('class', 'btn-cancel');
			this.btnRetry.setAttribute('id', 'btnRetryId');
			this.btnRetry.setAttribute('href', 'javascript:;');
			this.btnRetry.appendChild(document.createTextNode('Retry'));
			var listNode = this.fileMetaDiv.parentNode;
	      
			this.btnRetry.onclick = function() {
				var nextSibling = listNode.nextSibling;
				self.refreshUploader(listNode);
				self.buildUploader(nextSibling);
				self.triggerUpload();
			};
			successFeedback.appendChild(this.btnRetry);
			
		}
		
		
		
		
		if (this.thumbStatus == 'showThumb') {
			this.fileMetaDiv.appendChild(successFeedback);
		}else {
			this.fileMetaDiv.appendChild(successFeedback);
		}
	}
	if (this.thumbStatus == 'showThumb') {
		//var confirmButton = document.getElementById(this.portletNamespace + "saveButton");
		//document.title += " -end-confirmButton: " + confirmButton;
		//removeClass(confirmButton.parentNode, "aui-button-disabled");
		//confirmButton.disabled = false;
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
	var fileNameEntry = target.getAttribute("data-file-name-entry")
	var tempRemoveFileResourceURL = this.removeFileResourceURL.concat('&fileName='+fileNameEntry);
	tempRemoveFileResourceURL += "&fileEntryId=" + fileEntryId;
	//console.log("To be removed: " + tempRemoveFileResourceURL);
	objName.splice(objName.indexOf(fileNameEntry),1);


	AjaxGet("GET", tempRemoveFileResourceURL, removeFileSuccess, removeFileError);
};

function removeFileSuccess(xhr) {
try{
	//document.title += "-removeFileSuccess";
	var data = JSON.parse(xhr.responseText);
	var fileEntryId = data.fileEntryId;
	var fileNameEntry = data.fileName;
	//document.title += "**fileEntryId: " + fileEntryId;
	var removeFileLink = getFirstElementsByAttribute(document, "a", "data-file-entry-id", fileEntryId);
	//console.log('Removed' +fileNameEntry);
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

function AjaxGet(method, url, successFunc, errorFunc) {
try{
	var xhr;
	if (window.XMLHttpRequest) {
		// code for IE7+, Firefox, Chrome, Opera, Safari
		xhr = new XMLHttpRequest();
	}
	else {
		// code for IE6, IE5
		xhr = new ActiveXObject("Microsoft.XMLHTTP");
	}
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4) {
		    if (xhr.status == 200) {
		    	successFunc(xhr);
		    }
		    else {
		    	errorFunc();
		    }
		}
	};

	xhr.open(method, url,  true);
	xhr.send(null);

}catch(err) {
	alert(err);
}
}



var clicked = false;
var tempTarget = null;
function revealList(e) {
	e.preventDefault();

	var target = getEventTarget(e);
	//console.log(target+' has been clicked!');
	var targetID = 'asset-create-folder-list-'+target.getAttribute('id');
	var targetContentID = 'asset-create-folder-list-wrap-'+target.getAttribute('id');
	toggleClass(target,'folderDropIconActive');
	var asset_folder_wrap = document.getElementById(targetID);
	var asset_folder_wrap_height = document.getElementById(targetContentID).offsetHeight;

	var folderLists1 = document.getElementsByClassName("asset-create-folder-list");
	var folderListsLength1 = folderLists1.length;
	//console.log(target);

	for (var i=0; i<folderListsLength1; i++) {
		folderLists1[i].style.height = "0";
		var fdia1 = document.getElementById('folderDropIcon_fd'+i);
		//console.log(fdia1);
		removeClass(fdia1,'folderDropIconActive');
	}

	if (tempTarget == target) {
		tempTarget = " ";
		asset_folder_wrap.style.height = 0;
		//console.log('Same Target');

	}
	else {
		//console.log('Boom');
		var fdia_ = document.getElementById(target.id);
		toggleClass(fdia_, "folderDropIconActive");
		asset_folder_wrap.style.height = asset_folder_wrap_height + "px";
		tempTarget = target;
	}

}

function collapseFolder() {
	var folderLists = document.getElementsByClassName("asset-create-folder-list");
	var folderListsLength = folderLists.length;

	if (folderLists) {
		clicked = false;
		for (var i=0; i<folderListsLength; i++) {
			folderLists[i].style.height = "0";
			var fdia = document.getElementById('folderDropIcon_fd'+i);
			removeClass(fdia,'folderDropIconActive');
		}
	}

}

