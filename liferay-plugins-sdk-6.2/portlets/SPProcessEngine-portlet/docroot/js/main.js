function initializeDownloadUrls(data){
	var nodes = A.all("input[type=file]");
	nodes.each(function(node){
		var titleId = node.get("id") + "Title";
		var downloadId = node.get("id") + "DownloadUrl";
		var title = A.one("#" + titleId);
		if(title && data[titleId]){
			title.set("text",data[titleId]);
		}
		
		var download = A.one("#" + downloadId);
		if(download &&  data[downloadId] && data[downloadId] !='' ){
			download.setAttribute("href",data[downloadId]);
			A.one("#" + node.get('id') + "Info").removeClass("hide");
		}
	})
}


function validate(domNode){
	if (!(a instanceof SPDynamicForm)) {
		var node = A.one("#" + domNode.id);
		var cn = node.getAttribute("class");
			if(cn.includes("Requiredfield")){
				validateRequiredField(node);
			}		
	}
}


function validateRequiredField(node){
		var value = node.val();
		var errorDivId = fetchErrorDivId(node); 
		var errorDiv = A.one("#" + errorDivId);
		if(value.length == 0){
			errorDiv.html('<p class="portlet-msg-error">Please fill out this field</p>');
			errorDiv.removeClass("hide");
			return true;
		}
		else{
			errorDiv.html("");
			errorDiv.addClass("hide");
			return false;
		}
}

function fetchErrorDivId(node){
	return node.get("id") + "ErrorDiv";
}


function validateOnClickSave(contextNode){
	var nodes = contextNode.all("input[type=text],input[type=hidden],select");
	var result = false;
	nodes.each(function(node){
	var cn = node.getAttribute("class");
		if(cn.includes("Requiredfield")){
			var temp = validateRequiredField(node);
			if (temp){
				result = true;
			}
		}
	})
	return result;
}
