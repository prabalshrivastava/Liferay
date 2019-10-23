
<%@page import="com.sambaash.platform.srv.spasset.model.SPAssetEntry"%>
<%@ include file="/html/init.jsp"%>

<portlet:actionURL var="saveAssetEntryActionURL" windowState="normal" name="saveAssetEntry" />

<liferay-portlet:resourceURL id="uploadFile" var="uploadResourceURL"></liferay-portlet:resourceURL>

<liferay-portlet:resourceURL id="saveTitle" var="titleSaveResourceURL"></liferay-portlet:resourceURL>

<liferay-portlet:resourceURL id="removeFile" var="removeResourceURL"></liferay-portlet:resourceURL>

<aui:form action='<%=saveAssetEntryActionURL%>'
	name='<portlet:namespace />fm' method="post">
	
<aui:model-context bean='<%=request.getAttribute("assetEntry")%>' model="<%= SPAssetEntry.class %>" />

	<div class="control-group">
		<label class="control-label bold" for="title"><%=LanguageUtil.get(pageContext,"label.title") %> <span class="txt-custom-color-warning">*</span></label>
		<div class="controls">
			<input type="text" name="<portlet:namespace/>title" <%-- onkeypress="return preventSubmit(event, '<%=titleSaveResourceURL%>','<portlet:namespace/>')"  --%>
				id="<portlet:namespace/>title" value="${assetEntry.title}"  <%-- onchange="callServeResource('<%=titleSaveResourceURL%>','<portlet:namespace/>');" --%> />
		</div>
	</div>
	<input type="hidden" name="<portlet:namespace/>spAssetEntryId"
				id="<portlet:namespace/>spAssetEntryId" value="${assetEntry.spAssetEntryId}"  />
				
	<div class="control-group">
		<label class="control-label" for="description strong"><%=LanguageUtil.get(pageContext,"label.description") %></label>
		<div class="controls">
			<textarea name="<portlet:namespace/>description"
				id="<portlet:namespace/>description">${assetEntry.description}</textarea>
		</div>
	</div>
	
	<div class="control-group">
		<div class="controls strong">
			<aui:input classPK="${assetEntry.spAssetEntryId}" name="tags" type="assetTags" />
		</div>
	</div>
	<div class="control-group">
		<label class="control-label strong" for="categories"><%=LanguageUtil.get(pageContext,"label.categories") %></label>
		<div class="controls">
			<aui:input  name="categories" type="assetCategories" />
			<!-- classPK="" --> 
		</div>
	</div>
	<div class="control-group">
		<div class="controls strong">
		
			<aui:field-wrapper label="permissions">
				<liferay-ui:input-permissions modelName="<%= SPAssetEntry.class.getName() %>" />
			</aui:field-wrapper>
		</div>
	</div>

	<div class="centerall ascolumn">

		<!-- <aside></aside> -->
		<section id="fileinput">
			<div>
				<input type="file" multiple>
				<!--  accept="image/*" -->
				<div class="arrow up centerall ascolumn">
					<!--<img src="curved_arrow.png">-->
					<span><%=LanguageUtil.get(pageContext,"label.select.file") %>Select file(s), or drag and drop files/folders on to
						me</span>
				</div>
			</div>
		</section>
		
		<section id="droparea">
			<div dropzone
				webkitdropzone="copy file:image/png file:image/gif file:image/jpeg"
				class="centerall">
				<%=LanguageUtil.get(pageContext,"label.drop.images") %>Drop images or a folder of them
				<div class="arrow left centerall ascolumn">
					<!--<img src="curved_arrow.png">-->
					<span><%=LanguageUtil.get(pageContext,"label.drag.drop.message") %>Drag and drop files/folders from your desktop</span>
				</div>
			</div>
		</section>

		<div class="centerall" id="drag_footer">
		
			<c:forEach var="ExistingAssetList" items="${ExistingAssetList}">
				<div class="outer_div highlight_success_field"">
					<span class="img_class">
						<img src="${ExistingAssetList.value[0]}" title="Calendar 02.png" alt="Calendar">
					</span>
					<span>${ExistingAssetList.value[1] }</span>
					<span class="close txt-custom-color-error">Remove</span>
				</div>
			</c:forEach>
		
		</div>

	</div>

	<div class="control-group">
		<label class="control-label strong" for="embed"><%=LanguageUtil.get(pageContext,"label.embed") %> </label>
		<div class="controls">
			<input type="text" name="<portlet:namespace/>embed"
				id="<portlet:namespace/>embed" value="" />
		</div>
	</div>
	<aui:button type="submit" value='<%=LanguageUtil.get(pageContext,"label.confirm") %>' id="confirmButton" onClick="validateBeforeSubmitForm();" />
	</div>

	<input type="hidden" id="randId" value="1">
	<input type="hidden" id="dlFolderId" name="dlFolderId" value="0">
	<input type="hidden" id="coverFileEntryId" name="coverFileEntryId" value="0">
	

</aui:form>

<%--  <script src="<%=request.getContextPath()%>/js/script.js"></script> --%>

<script>
var filesAdded = new Array();
var assetNameSpace;
var uploadUrl;
var removeUrl;
var folderId=0;
var maxFileSize = ${assetTypeValue.maxFileSize};
var minImageHeight = ${assetTypeValue.minImageHeight};
var minImageWidth = ${assetTypeValue.minImageWidth};
var allowedFileTypes = "${assetTypeValue.allowedFileTypes}";
var divHtml = "";
var fTypeArray = allowedFileTypes.split(',');

var rand1=document.getElementById('randId').value;

	window.requestFileSystem = window.requestFileSystem
			|| window.webkitRequestFileSystem;
	window.resolveLocalFileSystemURL = window.webkitResolveLocalFileSystemURL
			|| window.webkitResolveLocalFileSystemURL;

	var fs = null;
	var cwd = null;
	var DONE_MSG = '';
	var NOT_IMG_MSG = 'One or more files is not an image.';
	var NOT_CORRECT_IMG_SIZE = "Size of the file must be lessthan 2937 MB ";
	var footer = document.querySelector('#drag_footer');
	var errorMsg="";
	 function setLoadingTxt(obj) {
		var el = document.querySelector('aside');
		if (obj && obj.txt) {
			var stayOpen = obj.stayOpen || false;
			var isError = obj.error || false;
/* 
			if (isError) {
				el.classList.add('red');
			}

			el.textContent = obj.txt;
			el.classList.add('show');

			if (!stayOpen) {
				window.setTimeout(setLoadingTxt, 3000);
			} */
		} else {
			el.classList.remove('show');
			el.classList.remove('red');
		}
	} 

	function onError(e) {
		switch (e.code) {
		case FileError.INVALID_MODIFICATION_ERR:
			setLoadingTxt({
				txt : 'Error: that directory path already exists',
				error : true
			});
			break;
		default:
			setLoadingTxt({
				txt : 'Error code: ' + e.code,
				error : true
			});
			break;
		}
	}

	function toArray(list) {
		return Array.prototype.slice.call(list || [], 0);
	}

	function readDirectory(dirEntry, callback) {
		var dirReader = dirEntry.createReader();
		var entries = [];

		// Call the reader.readEntries() until no more results are returned.
		var readEntries = function() {
			dirReader.readEntries(function(results) {
				if (!results.length) {
					callback(entries);
				} else {
					entries = entries.concat(toArray(results));
					readEntries();
				}
			}, onError);
		};

		readEntries(); // Start reading dirs.
	}

	function getEntry(fullPath, callback) {
		var fsUrl = fs.root.toURL() + fullPath;
		window.resolveLocalFileSystemURL(fsUrl, function(entry) {
			if (entry.isDirectory) {
				cwd = entry;
			}
			callback(entry);
		});
	}

	function onThumbnailClick(e) {
		var el = e.target.parentElement;

		if (el.tagId == 'drag_footer') {
			getEntry(cwd.fullPath + '/..', renderImages);
			return;
		}

		var isDirectory = Boolean(el.dataset.isDirectory);
		if (isDirectory) {
			getEntry(el.dataset.fullPath, renderImages);
		} else {
			getEntry(el.dataset.fullPath, function(entry) {
				window.open(entry.toURL());
			});
		}
	}
	function onClose(e) {
		  e.stopPropagation();

		  var el = e.target.parentElement;
		  var imgName = el.dataset.fullPath.split('/').pop();
		if ( filesAdded.indexOf(el.dataset.fullPath.split('/').pop()) != -1) {
			filesAdded[filesAdded.indexOf(el.dataset.fullPath.split('/').pop())]="";
			
		}
		  el.classList.add('slim');

		  var onTransitionEnd = function(e) {
		    if (e.propertyName == 'width') {
		      getEntry(el.dataset.fullPath, function(entry) {
		        el.parentElement.removeChild(el);
		        
		        // Calling Remove Action 
		        var spAstEntryId=document.getElementById(assetNameSpace+"spAssetEntryId").value;
		 		var fd = new FormData();
				fd.append("imgName", imgName);
				fd.append("spAssetEntryId", spAstEntryId);
				var xhr = new XMLHttpRequest();
				xhr.open("POST",removeUrl);
				xhr.send(fd);

		        entry.isDirectory ? entry.removeRecursively(function() {}, onError) :
		                            entry.remove(function() {}, onError);
		      });
		    }
		  };

		  // Support every browser even though only Chrome supports the Filesystem
		  // and drag and drop folder API. Hopefully someone will polyfill :)
		  el.addEventListener('webkitTransitionEnd', onTransitionEnd);
		  el.addEventListener('transitionend', onTransitionEnd);
		  el.addEventListener('MSTransitionEnd', onTransitionEnd);
		  el.addEventListener('oTransitionEnd', onTransitionEnd);
		}
	
/* 	function onClose(e) {
		alert("remove");
		e.stopPropagation();

		var el = e.target.parentElement;

		if ( filesAdded.indexOf(el.dataset.fullPath.split('/').pop()) != -1) {
			filesAdded[filesAdded.indexOf(el.dataset.fullPath.split('/').pop())]="";
			
		}
		el.classList.add('slim');
		//alert(el);
		var onTransitionEnd = function(e) {
			if (e.propertyName == 'width') {
				getEntry(el.dataset.fullPath, function(entry) {
					el.parentElement.removeChild(el);

					entry.isDirectory ? entry.removeRecursively(function() {
					}, onError) : entry.remove(function() {
					}, onError);
				});
			}
		};

		// Support every browser even though only Chrome supports the Filesystem
		// and drag and drop folder API. Hopefully someone will polyfill :)
 		el.addEventListener('webkitTransitionEnd', onTransitionEnd);
		el.addEventListener('transitionend', onTransitionEnd);
		el.addEventListener('MSTransitionEnd', onTransitionEnd);
		el.addEventListener('oTransitionEnd', onTransitionEnd); 
	} */

	function renderImages(dirEntry) {
		
				
		readDirectory(dirEntry, function(entries) {
			
			entries.forEach(function(entry, i) {
				var fName = "";
				var div = document.createElement('div');
				div.classList.add('outer_div');
				div.classList.add('highlight_success_field');

				div.dataset.fullPath = entry.fullPath;

				if (entry.isDirectory) {
					getEntry(entry.fullPath, renderImages);
				} else {
					
					//img.src = window.URL.createObjectURL(files[i]); // Equivalent to item.getAsFile().
					var fileSize;
					entry.file(function(f,rand1) {
						
						var extension = (entry.name).split('.').pop();
						
						var img = new Image;
						
						if ( fTypeArray.indexOf(extension) == -1) {
							 errorMsg = "The file type of the image("+extension+") is not allowed.";
						}
						img.onload = function() {

							if(this.width>100 && this.height>100){
								 // Validation for Image height,width

								if(img.width<minImageWidth){
									 errorMsg = "The width of the image must be greater than "+minImageWidth+" px";
								}else if(img.height<minImageHeight){
									 errorMsg = " The Height of the image must be greater than "+minImageHeight+" px";
								}else if(((f.size * 100 / (1024 * 1024)) / 100)>maxFileSize){
								 	errorMsg = "File size should not exceed "+maxFileSize+" MB";
								} /* else if(((f.size * 100 / 1024) / 100)>maxFileSize){
									 errorMsg = "File size should not exceed "+maxFileSize+" KB";
								} */
							}
						};
						if (f.size > 1024 * 1024) {
							fileSize = (Math
									.round(f.size * 100 / (1024 * 1024)) / 100)
									.toString()
									+ 'MB';
						} else {
							fileSize = (Math.round(f.size * 100 / 1024) / 100)
									.toString()
									+ 'KB';
						}
						
						if (f.type.match('^image/')) {
							img.src = entry.toURL();
							
						} else if (f.type.match('^video/')) { 
							img.src = '/SPAsset-portlet/video.png';
						} else {
							img.src = '/SPAsset-portlet/video.png';
						} 
						
						fName = entry.name + "  " + fileSize;

						img.title = entry.name;
						img.alt = entry.name;

						var imgDiv = document.createElement('span');
						imgDiv.classList.add('img_class');
						imgDiv.appendChild(img);

						var span = document.createElement('span');
						span.textContent = fName;

						var span2 = document.createElement('span');
						span2.textContent = 'Remove';
						span2.classList.add('close');
						span2.classList.add('txt-custom-color-error');
						span2.addEventListener('click', onClose);
						
						var span3 = document.createElement('span');
						span3.textContent = errorMsg;
						span3.classList.add('errormsg');
						
						rand1=document.getElementById('randId').value;
						var span4 = document.createElement('span');
						span4.id="progressNumber"+rand1;
						
						var span5 = document.createElement('span');
						span5.id="prgsbarcolor"+rand1;
						span5.textContent = "Completed";
						span5.classList.add('prgsbwidth');
						span5.classList.add('success-bg');

						div.appendChild(imgDiv);
						div.appendChild(span);
						div.appendChild(span2);
						
						if(errorMsg !=""){
							div.appendChild(document.createElement("br"));
							div.appendChild(span3);
						}else{
							div.appendChild(document.createElement("br"));
							div.appendChild(span4);
							div.appendChild(span5);
						}
						
						div.addEventListener('click', onThumbnailClick);
						
						if (!entry.isDirectory) {
							//alert(filesAdded);
							if ( filesAdded.indexOf(entry.toURL().split('/').pop()) == -1) {
								footer.appendChild(div);
								filesAdded.push(entry.toURL().split('/').pop());
							}
						}
						if(errorMsg ==""){
							
	 						 // Calling Upload Action 
					 		var fd = new FormData();
							fd.append("fileToUpload", f);
							fd.append("imgName", f.name);
							fd.append("imgType", f.type);
							var spAstEntryId=document.getElementById(assetNameSpace+"spAssetEntryId").value;
							fd.append("spAssetEntryId", spAstEntryId);
							var xhr = new XMLHttpRequest();
							
							xhr.upload.addEventListener("progress", uploadProgress, false);
							xhr.upload.myParam = rand1;
							
							xhr.addEventListener("load", uploadComplete, false);
							xhr.addEventListener("error", uploadFailed, false);
							xhr.addEventListener("abort", uploadCanceled, false);
							xhr.open("POST",uploadUrl);
							xhr.send(fd);
						
						}
						
						rand1++;
						var elem = document.getElementById('randId');
						elem.value=rand1;
						errorMsg="";
						
					}, onError);

				}
			});
			

		});
	}


	function writeFile(file, dirEntry, callback) {
		dirEntry.getFile(file.name, {
			create : true
		}, function(fileEntry) {
			fileEntry.createWriter(function(writer) {
				writer.onwriteend = callback;
				writer.onerror = callback;
				writer.write(file);
			}, onError);
		}, onError);
	}
	function onChange(e) {
		//alert('onChange');
		  e.stopPropagation();
		  e.preventDefault();

		  var entries = e.target.webkitEntries;

		  // Dragging and dropping into the file input works fine but onchange doesn't
		  // populate .webkitEntries when selecting from the file dialog
		  // (crbug.com/138987). Thus, we need to explicitly write out files.
		  if (!entries.length) {
		    var files = e.target.files;
		    var numWritten = 0;

		    [].forEach.call(files, function(f, i) {
		      if (f.type.match('^image/') ||  (f.type.match('^video/'))) {
		        writeFile(f, cwd, function(e) {
		          if (++numWritten) {
		            //setLoadingTxt({txt: DONE_MSG + ' writing ' + files.length + ' files.'});
		            renderImages(cwd);
		          }
		        });
		      } else {
		        //setLoadingTxt({txt: NOT_IMG_MSG, error: true});
		      }
		    });
		    return;
		  }

		  [].forEach.call(entries, function(entry) {

		    // Copy entry over to the local filesystem.
		    entry.copyTo(cwd, null, function(copiedEntry) {
		      setLoadingTxt({txt: DONE_MSG});
		      renderImages(cwd);
		    }, onError);

		  });
		 
		}

	
	

	function onDrop(e) {
		e.preventDefault();
		e.stopPropagation();

		var items = e.dataTransfer.items;
		var files = e.dataTransfer.files;
		
		for (var i = 0, item; item = items[i]; ++i) {
			// Skip this one if we didn't get a file.
			if (item.kind != 'file') {
				continue;
			}
			
			var entry = item.webkitGetAsEntry();
			if (entry.isDirectory) {

				// Copy the dropped DirectoryEntry over to our local filesystem.
				entry.copyTo(cwd, null, function(copiedEntry) {
					renderImages(cwd);
				}, onError);
			} else {
				// Copy the dropped entry into local filesystem.
				 entry.copyTo(cwd, null, function(copiedEntry) {
					
			         renderImages(cwd);
			        }, onError); 

			}
		}
	}
	
	
	function uploadProgress(event) {
		
		try{
			var rand = event.target.myParam;
			
			if (event.lengthComputable) {
				
				var percentComplete = Math.round(event.loaded * 100 / event.total);
				document.getElementById('progressNumber'+rand).innerHTML = percentComplete.toString() + '%';
				document.getElementById("prgsbarcolor"+rand).style.width=percentComplete+'%';
				
			} else {
				document.getElementById('progressNumber'+rand1).innerHTML = 'Failed to compute file upload length';
			}	 
		
		}catch(err){
			
		}
		
	}

	function uploadComplete(evt) {
		// This event is raised when the server send back a response
		//document.getElementById('progressNumber'+rand1).innerHTML = evt.target.responseText;
		var data = JSON.parse(evt.target.responseText);
		folderId = data.folderId;
		if(data.folderId != undefined){
		document.getElementById('dlFolderId').value = data.folderId;}
		if(data.coverFileEntryId != undefined){
		document.getElementById('coverFileEntryId').value = data.coverFileEntryId;}
		console.log("evt.target.responseText "  + data.folderId);
	}

	function uploadFailed(evt) {
		//document.getElementById('progressNumber'+rand1).innerHTML ="There was an error attempting to upload the file.";
	}

	function uploadCanceled(evt) {
		//document.getElementById('progressNumber'+rand1).innerHTML ="The upload has been canceled by the user or the browser dropped the connection.";
	}

	function errorHandler(err){
		 var msg = 'An error occured: ';

		  switch (err.code) { 
		    case FileError.NOT_FOUND_ERR: 
		      msg += 'File or directory not found'; 
		      break;

		    case FileError.NOT_READABLE_ERR: 
		      msg += 'File or directory not readable'; 
		      break;

		    case FileError.PATH_EXISTS_ERR: 
		      msg += 'File or directory already exists'; 
		      break;

		    case FileError.TYPE_MISMATCH_ERR: 
		      msg += 'Invalid filetype'; 
		      break;

		    default:
		      msg += 'Unknown Error'; 
		      break;
		  };		 
	};
				
	function init(uploadUrlVar, nameSpace,removeUrlVar) {
		assetNameSpace = nameSpace;
		
		uploadUrl = uploadUrlVar;
		removeUrl =removeUrlVar;
		document.querySelector('input[type="file"]').addEventListener('change',
				onChange);

		var dropZone = document.querySelector('[dropzone]');

		dropZone.addEventListener('drop', onDrop);

		dropZone.addEventListener('dragover', function(e) {
			e.preventDefault(); // Necessary. Allows us to drop.
		});

		dropZone.addEventListener('dragenter', function(e) {
			e.target.classList.add('active');
		});

		dropZone.addEventListener('dragleave', function(e) {
			e.target.classList.remove('active');
		});

		window.addEventListener('keydown', function(e) {
			if (e.keyCode == 27) { // ESC
				document.querySelector('details').open = false;
			}
		});
 		  window.requestFileSystem(TEMPORARY, 1024 * 1204, function(fileSystem) {
			    fs = fileSystem;
			    cwd = fs.root;
			    console.log(cwd);
			    
			    var dirReader = fs.root.createReader();
			    var entries = [];

			    // Call the reader.readEntries() until no more results are returned.
			    var clearEntries = function() {
			       dirReader.readEntries (function(results) {
			        if (results.length) {
			          entries = toArray(results);
			          for (i = 0; i < entries.length; i++) { 
			        	  //  alert( entries[i].fullPath + " ===== " + entries[i].name);
			        	    entries[i].isDirectory ? entries[i].removeRecursively(function() {}, errorHandler) :
			        	    	entries[i].remove(function() {}, errorHandler);
			        	}
			        }
			      }, errorHandler);
			    };

			    clearEntries(); 
			    
			    
			    

			    renderImages(cwd);
			    
			    
			    
			  }, onError); 
/*  	 	window.requestFileSystem(TEMPORARY, 1024 * 1204, function(fileSystem) {
			fs = fileSystem;
			cwd = fs.root;
			console.log(cwd);
				
			fileSystem.root.getDirectory('/', {}, function(dirEntry) {
			    dirEntry.removeRecursively(function() {
			      console.log('Directory removed.');
			    }, errorHandler);
			  }, errorHandler);
			
			renderImages(cwd);
		}, onError) ; */
	}

	init("<%=uploadResourceURL%>","<portlet:namespace/>","<%=removeResourceURL%>");
	
	function validateBeforeSubmitForm(){
		var confirmButton = document.getElementById("confirmButton");
		var A = AUI();
		var reqUrl = '<portlet:resourceURL id="" />';
		var items = null;
		var type = "checkfilesBeforeConfirm"
		alert("folderId check" + folderId);
		A.io.request(reqUrl, {
		     cache: false,
		     sync: true,
		     dataType: 'json',
		     method: 'post',
		     data:{
		    	 type:type,
		    	 folderId : folderId,
		     },
		     on: {
		    	 start:function(){
			    		//display loading icon
			    		//loadingState(sectionName);
		    		 //confirmButton.disabled = true;
			    	},
		         success: function() {
		        	 items = this.get('responseData');
		        	 fileEntryCount = items.fileEntryCount;
			            alert("fileEntryCount " + fileEntryCount);
		        	 if(fileEntryCount == 0) {
 			        	var embededContentHiddenInput = document.getElementById("<portlet:namespace/>embed");
 			        	var embededContentHiddenInputVal = embededContentHiddenInput.value;
 			        	alert("length" + embededContentHiddenInputVal.length)
 			        	fileEntryCount += embededContentHiddenInputVal.length;
			        }
		        	 if(fileEntryCount > 0) {
							confirmButton.disabled = true;
						   	window.setTimeout(function() {
						   		document.getElementById("_SPAssetEntry_WAR_SPAssetportlet_<"+"portlet:namespace />fm").action="<%=saveAssetEntryActionURL%>";
						   		document.getElementById("_SPAssetEntry_WAR_SPAssetportlet_<"+"portlet:namespace />fm").submit();
					        }, 3000);
			        	}else {
			        		alert("Please make sure there is at least one file exist in this project.");
			        	}
			            	
		         },
		         failure: function() {
		        	
		         }
		     }
		 });
	}
	
</script>


