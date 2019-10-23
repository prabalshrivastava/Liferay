var A;
var ContentType = {
	VIDEO : 'video',
	EMBED : 'embed',
	MUSIC : 'music',
	IMAGE : 'image',
	PDF   : 'pdf'  ,
	DOCUMENT : 'document'
}
function DetailView(config){
	var RIGHT = "right";
	var LEFT = "left";
	var configObj;
	var start = 0;
	var end = 0;
	var pageSize = 100;
	// ajax call fetches all the files entries in single call. files holds all the files in json format.
	var files = [];
	// complete response data - while fetching assetentry, assetEntryObj.items and files array will have same values. But use files[] to manipulate anything.
	// keep original response untouched
	var assetEntryObj;
	// gallery image file in popup
	var imageFile;
	var description;
	var assetEntryId;
	var fileId;
	// holds the position of displaying file
	var cursor = 0;
	var download ;
	var commentObj;
	
	var coverImage ;


	var videoPlayer = null;

	// Container for Image
	var imageDiv ;
	// Container for pdf
	var pdfDiv ;
	// Container for video
	var videoDiv;
	// container for other documents .doc,.html etc..
	var documentDiv;

	var galleryUrl;


	//thumbnail image template
	var thumbnailTemplate;

	// indiviudalu fiel viewer - the popup
	var galleryFileViewer;
	
	// button used to set the pic as cover image
	var setAsCoverButton;
	function initializeConfig(config){
		configObj = config;
		galleryUrl = config.galleryUrl;
		galleryFileViewer = A.one("#galleryFileViewer");
		imageFile = A.one('#imageFile');
		description = document.getElementById("description");//A.one('#description');
		assetEntryId = A.one('#assetEntryId');
		fileId = A.one('#fileId');
		download = A.one('#' + config.namespace + 'download');
		coverImage = A.one("#coverImage");

		imageDiv = A.one("#imageDiv");
		pdfDiv = A.one("#pdfDiv");
		videoDiv = A.one("#videoDiv");
		documentDiv = A.one("#documentDiv");

		thumbnailTemplate = A.one("#thumbnailTemplate");
		initializeArrows();
		//initializeDownloadLink();

		try{
			dataObj = { };
			// must be sync request
			dataObj.sync = true;
			fetchData(dataObj);
			renderGallery();
			var fileIdVal = fileId.val();
			if(fileIdVal && fileIdVal!= '0' && fileIdVal != ''){
				render('', parseInt(fileId.val()));
			}
		}catch(err){

		}
		commentObj = Liferay[configObj.namespace + "galleryFile" + "comment"];

		A.one("#closegalleryFileViewer").on("click",function(){
			closeGalleryView();
		});
		
		setAsCoverButton = A.one("#coverImage-galleryBtn");
		setAsCoverButton.on("click",function(){
			setAsCoverImage();
		});
		
		coverImage.on("click",function(){
			render("",assetEntryObj.coverFileEntryId);
		});
	}

	function closeGalleryView(){

		hide(galleryFileViewer);
		pauseCurrentVideo();
//		var temp = window.location.href;
		// get album url, by cutting the url till album id in url
	//	var newUrl = temp.substring(0, temp.lastIndexOf("/")  ) ;
		// now user is viewing album main view, so change browser url to album url
//		pushUrlState(newUrl);
		pushUrlState(galleryUrl);
	
	}

	function initializeArrows(){
		galleryFileViewer.on("keydown",function(ev){
			if(ev.target.ancestor("#fileCommentsDiv")){
				return;
			}
			
			// escape key
			if(ev.keyCode == 27){
				closeGalleryView();
			}
			// left arrow key
			if(ev.keyCode ==  37){
				pauseCurrentVideo();
				renderLeftFile();
			}
			//right
			if(ev.keyCode ==  39){
				pauseCurrentVideo();
				renderRightFile();
			}
		});
		A.one("#leftArrow").on("click",function(ev){
			pauseCurrentVideo();
			renderLeftFile();
		});
		A.one("#rightArrow").on("click",function(ev){
			pauseCurrentVideo();
			renderRightFile();
		});
		
	}
	function renderGallery(){
		// to make sure we have valid response
		if(assetEntryObj && assetEntryObj.assetEntryId){
			A.all("#galleryTitle").set('text',assetEntryObj.title);
			A.one("#uploaderImg").set('src',assetEntryObj.uploaderImg);
			A.one("#uploaderName").set('text',assetEntryObj.uploaderName);
			A.one("#uploadedTime").set('text',assetEntryObj.uploadedTime);
			coverImage.set('src',assetEntryObj.coverImage);
			document.getElementById("galleryDescription").innerHTML = assetEntryObj.description;
			//A.one("#galleryDescription").set('text',assetEntryObj.description);/** change made to show new line or <br> as given in textarea -- Harini **/
			renderTags(A.one("#galleryTags"), assetEntryObj.tags);
			renderCategories(A.one("#galleryCatgs"), assetEntryObj.catgs);
			if(files){
				for(var i = 0 ; i< files.length; i++){
					var tt = thumbnailTemplate.clone();
					tt.removeClass("hide");
					var file = files[i];
					var timg = tt.one("#thumbnail");
					timg.set("src", file.thumnailUrl);
					timg.setAttribute("data-fileId", file.fileId);
					timg.on("click",function(){
						render('', this.getAttribute('data-fileId'));
					});
					A.one("#thumbnailsDiv").append(tt);
				}
			}
		}
	}

	// common method for rendering tags - one call at asset entry main view, one call at file level(preview popup)
	function renderTags(node,tags){
		if(node){
			node.all("li").remove();
		}
		if(node && tags){
			var tagnames = tags.split(",");
			for( i in tagnames){
				var name = tagnames[i];
				if(name && name != ''){
					var li  = A.Node.create("<li></li>");
					li.set("text",name);
					node.append(li);
				}
			}
		}
	}
	// common method for rendering categories - one call at asset entry main view, one call at file level(preview popup)
	function renderCategories(node,cats){
		if(node){
			node.all("li").remove();
		}
		if(node && cats){
			for(var i = 0; i < cats.length; i++){
				var catg = cats[i];
				var li  = A.Node.create("<li></li>");
				li.set("text",catg.name);
				node.append(li);
			}
		}
	}
	// Pausing is required when user navigates to next file ( which is not video).else video keeps play in background;
	function pauseCurrentVideo(){
		var file = getCurrentFile();
		if(file.type == ContentType.VIDEO){
			videoPlayer.pause();
		}
	}
	function initializeLeftRightButtons(){
		A.one("#leftArrow").on("click",function(ev){
			renderLeftFile();
		});
		A.one("#rightArrow").on("click",function(ev){
			renderRightFile();
		});
	}
	// not required to use - keeping for future use
	function initializeDownloadLink(){
		download.on("click",function(ev){
			var file = getCurrentFile();
			if(file){
				window.location.href = file["downloadUrl"];
			}
		});
	}
	function loadComments(fileId){
		try{
			commentObj.reinitailze(fileId,config.className);
		}catch(err){

		}
	}
	function renderLeftFile(){
	    cursor = cursor - 1;
	    render(LEFT);
	}

	function renderRightFile(){
		cursor = cursor + 1;
		render(RIGHT);
	}

	// if fileId is passed, then it will be rendered else file at cursor position will be rendered
	function render(fetchDir,fileId){
		var total = files.length;

/*		// Get the files from server if nothing in our array
		if(total == 0){
			dataObj = { };
			// must be sync request
			dataObj.sync = true;
			fetchData(dataObj);
		}

		total = files.length; */


		if(fileId){
			var file = getFile(fileId);
			renderFile(file);
		}else{
			if(cursor >= total){
				cursor = total - 1;
			}
			if(cursor < 0){
				cursor = 0;
			}
			if(total > 0){
				renderFile(files[cursor]);
			}
		}
	}

	function getCurrentFile(){
		var file =  getFileAtIndex(cursor);
		return file;
	}
	function getFileAtIndex(pos){
		var file =  null;
		if(pos >= 0 && files.length > 0 && pos < files.length){
			file = files[pos];
			cursor = pos;
		}
		return file;
	}

	function getFile(fileId){
	/*	var file = null;
		if(fileId){
			for( var  i = 0; i < files.length; i++){
				if(fileId == files[i].fileId){
					file = files[i];
					break;
				}
			}
		} */
		var pos = getFileIndex(fileId);
		var file =  getFileAtIndex(pos);
		return file;
	}
	function getFileIndex(fileId){
		var pos = -1;
		if(fileId){
			for( var  i = 0; i < files.length; i++){
				if(fileId == files[i].fileId){
					pos =  i;
					break;
				}
			}
		}
		return pos;
	}
	function fetchData(dataObj){
		if(!dataObj){
			dataObj = { };
		}
		if(!dataObj["action"]){
			dataObj["action"] = "getFiles";
		}
		if(dataObj["async"] == undefined){
			dataObj["async"] = false;
		}

		dataObj["start"] = start;
		dataObj["end"] = end + pageSize;
		dataObj["assetEntryId"] = assetEntryId.val();

		A.io.request(configObj.ajaxUrl,{
			dataType : 'json',
			method : 'POST',
			data : dataObj,
			sync: dataObj.sync,
			on : {
				success : function() {
					var data = this.get('responseData');
					if(data && data.msg){
						if(data.msg != 'error'){
							handleResponse(dataObj,data);
						}
					}else{
					}
				},
				failure : function(){
				}
			}
		});
	}
	function handleResponse(dataObj,data){
		assetEntryObj = data;
		if(data && data.items){
			for(var i = 0 ; i < data.items.length; i++){
				var file = data.items[i];
				files.push(file);
			}
		}else{
			//TODO:handle this case
		}
	}

	// here file is json object containg file info like url,size,type ..
	function renderFile(file){

		if(file){
			show(galleryFileViewer);
			galleryFileViewer.focus();
			if(file.type == ContentType.IMAGE){
				renderImage(file);
			}else if(file.type == ContentType.PDF){
				renderPdfFile(file);
			}else if(file.type == ContentType.VIDEO){
				renderVideoFile(file);
			}else if(file.type == ContentType.DOCUMENT){
				renderDocument(file);
			}else{
				renderDocument(file);
			}
			renderFileInfo(file);
		}else{
			//TODO:handle this case
		}
	}

	function renderImage(file){
		showImageDiv();
		imageFile.set('src', file.url);
	}
	var pdfScriptLoaded = false;
	function renderPdfFile(file){
		showPdfDiv();
//		displayPdf("http://localhost:9080/documents/12788/0/sg+to+hyd.pdf/b2e27735-3e3e-4060-89f8-e91b4a030d4e?version=1.0",'the-canvas');
		// dynamically loading pdf script files
		if(!pdfScriptLoaded){
			A.Get.js("/html/js/sp/pdf.js", function(err){
				if(!err){
					A.Get.js("/html/js/sp/pdf.worker.js", function(err1){
						if(!err1){
							pdfScriptLoaded = true;
							displayPdf(file.url,'the-canvas');
						}
					});
				}
			});


		}
	}
	function renderVideoFile(file){
		showVideoDiv();
		if(videoPlayer == null){
			var urls =  file.urls;
			if(urls){
				var vsrc  = A.one("#videoSrc1");
				vsrc.set("src",urls[0].src);
				vsrc.set("type",urls[0].type);
				
				vsrc  = A.one("#videoSrc2");
				vsrc.set("src",urls[1].src);
				vsrc.set("type",urls[1].type);
				
				vsrc  = A.one("#videoSrc3");
				vsrc.set("src",urls[2].src);
				vsrc.set("type",urls[2].type);
			}
			videoPlayer = new VideoPlayer();
		}else{
			videoPlayer.play(urls);
		}
	}
	function renderDocument(file){
		showDocumentDiv();
		documentDiv.one("iframe").set("src","https://docs.google.com/viewer?url=" + file.url + "&embedded=true");
	}

	function renderFileInfo(file){
		fileId.set('value', file.fileId);
		download.set('href',file["downloadUrl"]);
		pushUrlState(file.friendlyUrl);
		updateSocialShareUrls(file);
		description.innerHTML = file.description;
		// description.set('text', file.description);/** change made to show new line or <br> as given in textarea -- Harini **/
		renderTags(A.one("#tags"), file.tags);
		renderCategories(A.one("#catgs"), file.catgs);
		if(file.size){
			download.one("span").set("text", "Download (" + formatBytes(file.size) + ")" );
		}
		loadComments(file.fileId);
		showHideCoverButton(file);
	}
	// to change the url without refreshing the page
	function pushUrlState(url){
		if(window.history.pushState){
			//var newUrl =  file.friendlyUrl;//getBrowserUrl(file);
			window.history.pushState("","", url );
		}
	}


	function getBrowserUrl(file){
		var temp = window.location.href;
		var newUrl = temp.substring(0, temp.lastIndexOf("/") + 1 ) + file.fileId;
		return newUrl;
	}

	function updateSocialShareUrls(file){
		var friendlyUrl = file.friendlyUrl;//getBrowserUrl(file);
		var prefix = configObj.namespace +  "galleryFile" ;
		updateSocialUrl(Liferay[ prefix + "fbShare"] ,friendlyUrl);
		updateSocialUrl(Liferay[ prefix  + "twitterShare"],friendlyUrl);
		updateSocialUrl(Liferay[ prefix  + "googleShare"] ,friendlyUrl);
		updateSocialUrl(Liferay[ prefix  + "linkedInShare"],friendlyUrl);
	}

	function showHideCoverButton(file){
		//show or hide the setascover button based on type of file and current file entry id
		//TODO: logic based on type of file
		
		if(assetEntryObj.coverFileEntryId  && file.fileId == assetEntryObj.coverFileEntryId  ){
			hide(setAsCoverButton);
		}else{
			show(setAsCoverButton);
		}
	}
	function setAsCoverImage(){
		var A = AUI();
		var action = "setAsCoverImage";
		var id = fileId.val();
		
		A.io.request(configObj.ajaxUrl, {
			cache : false,
			sync : true,
			timeout : 1000,
			dataType : 'json',
			method : 'post',
			data : {
				type : action,
				fileId : fileId.val(),
				assetEntryId:assetEntryId.val()
			},
			on : {
					success : function() {
							var data = this.get('responseData');
							if(data && data.msg == 'success'){
								hide(setAsCoverButton);
								assetEntryObj.coverFileEntryId = fileId.val();
								assetEntryObj.coverImage = data.coverImage;
								coverImage.set('src',assetEntryObj.coverImage);
								galleryFileViewer.focus();
							}
						  }
				}
			});
	}
	function updateSocialUrl(node,url){
		if(node){
			node.set('href', node.getAttribute('data-url-prefix') + url);
		}
	}

	function showImageDiv(){
		hide(pdfDiv);
		hide(videoDiv);
		hide(documentDiv);
		show(imageDiv);
	}
	function showPdfDiv(){
		hide(imageDiv);
		hide(videoDiv);
		hide(documentDiv);
		show(pdfDiv);
	}
	function showVideoDiv(){
		hide(imageDiv);
		hide(pdfDiv);
		hide(documentDiv);
		show(videoDiv);
	}
	function showDocumentDiv(){
		hide(imageDiv);
		hide(pdfDiv);
		hide(videoDiv);
		show(documentDiv);
	}
	function hide(node){
		if(node){
			//galleryFileViewer.removeClass("showViewer");
			//galleryFileViewer.toggleClass("hidden");
			node.addClass("hide");
		}
	}
	function show(node){
		if(node){
			galleryFileViewer.toggleClass("showViewer");
			galleryFileViewer.removeClass("hidden");
			node.removeClass("hide");
		}
	}

	function formatBytes(bytes,decimals) {
		   if(bytes == 0) return '0 Byte';
		   var k = 1000;
		   var dm = decimals + 1 || 3;
		   var sizes = ['Bytes', 'KB', 'MB', 'GB', 'TB', 'PB', 'EB', 'ZB', 'YB'];
		   var i = Math.floor(Math.log(bytes) / Math.log(k));
		   return (bytes / Math.pow(k, i)).toPrecision(dm) + ' ' + sizes[i];
		}

	initializeConfig(config);
}

function initalizeDetailView(config){
	AUI().use('aui-node','aui-base', 'aui-io-request-deprecated',function(A1){
		A = A1;
		var detailObj = new DetailView(config);
	});
}

function displayPdf(url,targetId){
/*	 PDFJS.getDocument(url).then(function getPdfHelloWorld(pdf) {
		    //
		    // Fetch the first page
		    //
		    pdf.getPage(1).then(function getPageHelloWorld(page) {
		      var scale = 1.5;
		      var viewport = page.getViewport(scale);

		      //
		      // Prepare canvas using PDF page dimensions
		      //
		      var canvas = document.getElementById('the-canvas');
		      var context = canvas.getContext('2d');
		      canvas.height = viewport.height;
		      canvas.width = viewport.width;

		      //
		      // Render PDF page into canvas context
		      //
		      var renderContext = {
		        canvasContext: context,
		        viewport: viewport
		      };
		      page.render(renderContext);
		    });
		  }); */

	 //
	  // Disable workers to avoid yet another cross-origin issue (workers need
	  // the URL of the script to be loaded, and dynamically loading a cross-origin
	  // script does not work).
	  //
	  // PDFJS.disableWorker = true;

	  //
	  // In cases when the pdf.worker.js is located at the different folder than the
	  // pdf.js's one, or the pdf.js is executed via eval(), the workerSrc property
	  // shall be specified.
	  //
	  // PDFJS.workerSrc = '../../build/pdf.worker.js';

	  var pdfDoc = null,
	      pageNum = 1,
	      pageRendering = false,
	      pageNumPending = null,
	      scale = 0.8,
	      canvas = document.getElementById(targetId),
	      ctx = canvas.getContext('2d');

	  /**
	   * Get page info from document, resize canvas accordingly, and render page.
	   * @param num Page number.
	   */
	  function renderPage(num) {
	    pageRendering = true;
	    // Using promise to fetch the page
	    pdfDoc.getPage(num).then(function(page) {
	      var viewport = page.getViewport(scale);
	      canvas.height = viewport.height;
	      canvas.width = viewport.width;

	      // Render PDF page into canvas context
	      var renderContext = {
	        canvasContext: ctx,
	        viewport: viewport
	      };
	      var renderTask = page.render(renderContext);

	      // Wait for rendering to finish
	      renderTask.promise.then(function () {
	        pageRendering = false;
	        if (pageNumPending !== null) {
	          // New page rendering is pending
	          renderPage(pageNumPending);
	          pageNumPending = null;
	        }
	      });
	    });

	    // Update page counters
	    document.getElementById('page_num').textContent = pageNum;
	  }

	  /**
	   * If another page rendering in progress, waits until the rendering is
	   * finised. Otherwise, executes rendering immediately.
	   */
	  function queueRenderPage(num) {
	    if (pageRendering) {
	      pageNumPending = num;
	    } else {
	      renderPage(num);
	    }
	  }

	  /**
	   * Displays previous page.
	   */
	  function onPrevPage() {
	    if (pageNum <= 1) {
	      return;
	    }
	    pageNum--;
	    queueRenderPage(pageNum);
	  }
	  document.getElementById('prev').addEventListener('click', onPrevPage);

	  /**
	   * Displays next page.
	   */
	  function onNextPage() {
	    if (pageNum >= pdfDoc.numPages) {
	      return;
	    }
	    pageNum++;
	    queueRenderPage(pageNum);
	  }
	  document.getElementById('next').addEventListener('click', onNextPage);

	  /**
	   * Asynchronously downloads PDF.
	   */
	  PDFJS.getDocument(url).then(function (pdfDoc_) {
	    pdfDoc = pdfDoc_;
	    document.getElementById('page_count').textContent = pdfDoc.numPages;

	    // Initial/first page rendering
	    renderPage(pageNum);
	  });
}
function VideoPlayer(){
	var player =  null;
	var videoJsLoaded = false;

	function loadVideoJsAndInitialize(){
		if(!videoJsLoaded){
			A.Get.css("/html/css/sp/video-js.min.css", function(err){
				if(!err){
					A.Get.js("/html/js/sp/video.min.js", function(err1){
						if(!err1){
							videoJsLoaded = true;
							videojs.options.flash.swf = "/html/js/sp/video-js.swf";
							initializePlayer();
						}
					});
				}
			});
		}else{
			initializePlayer();
		}
	}

	function initializePlayer(){
		videojs('videoTag', { "controls": true, "autoplay": false }, function() {
			player = this;
			//this.src({type:type,src:url});
			console.log('Good to go!');

			//  this.play(); // if you don't trust autoplay for some reason

			// How about an event listener?
			this.on('ended', function() {
				console.log('awww...over so soon?');
			});

		});
	}

	this.play = function(urls){
		var player  = this.getPlayerObj();
		if(player){
			player.src(urls);
		}
	}
	this.pause = function(){
		var player  = this.getPlayerObj();
		if(player){
			player.pause();
		}
	}

	this.getPlayerObj = function(){
		return videojs('videoTag'); ;
	}

	loadVideoJsAndInitialize();
}
