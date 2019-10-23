function ajaxCallAPI(method, action, data, successHandler, failHandler) {

	AUI().use('aui-io-request-deprecated', 'aui-base', function(A) {
		var _data = {};
		_data[namespace + 'formId'] = data.formId;
		if (mode == "view" ||mode == "edit" || (mode == "copy" && method == "GET")) {
			_data[namespace + 'formStorageId'] = data.formStorageId;
		} else {
			_data[namespace + 'formStorageId'] = "0";
		}
		_data[namespace + 'formType'] = data.formType;
		_data[namespace + 'action'] = action;
		if (data) {
			_data[namespace + 'data'] = JSON.stringify(data);

		}
		A.io.request(ajaxUrl, {
			dataType : 'json',
			method : method,
			data : _data,
			on : {
				success : successHandler,
				failure : failHandler || function() {

				}
			}
		});
	});
}

function ajaxCall(method, action,ajaxUrl, data, successHandler, failHandler) {
	var thisInstance = this;
	
	thisInstance.namespace = namespace;
        AUI().use('aui-base','aui-io-request-deprecated',function(A){
            var _data = {};
            _data[thisInstance.namespace + 'formStorageId'] = "";
            if(action == "update" || action == "loadData" || action == "loadList"|| action == "exportRow" || action == "archive"){
            	_data[thisInstance.namespace + 'formStorageId'] =  data.formStorageId;
            }
            _data[thisInstance.namespace + 'formType'] = data.formType;
            _data[thisInstance.namespace + 'action'] = action;
            if(action == "update")
             _data[thisInstance.namespace + 'action'] = "persist";
            if (data) {
                _data[thisInstance.namespace + 'data'] = JSON.stringify(data);              
            }
            A.io.request(ajaxUrl,{
                dataType : 'json', method : method,
                data : _data,
                on : {
                    success : successHandler,
                    failure : failHandler || function() {
                        thisInstance.debug("Error in the ajax call.");
                    }
                }
            });             
        });
}
function displayMessage(type, message, duration){
	var alert_div = document.getElementById("alert_msg");
	alert_div.innerHTML = message;
	alert_div.className = "";
	alert_div.classList.add("alert-"+type);
	alert_div.classList.add("alert");
	alert_div.style.display = "block";
	setTimeout(function(){ alert_div.style.display = "none"; }, duration);
	console.log(message);
}
function displayMessage(element,type, message, duration){
	var alert_div = document.getElementById(element);
	alert_div.innerHTML = message;
	alert_div.className = "";
	alert_div.classList.add("alert-"+type);
	alert_div.classList.add("alert");
	alert_div.style.display = "block";
	setTimeout(function(){ alert_div.style.display = "none"; }, duration);
	console.log(message);
}
function isNotNull(elementValue){
	var status = false;
	if(elementValue != undefined && elementValue != "" && elementValue != null){
		status = true;
	}
	return status;
}
function reloadPage() {
	window.location.reload();
}
function goBack(){
	window.history.back();
}
function findAncestor(el, cls) {
	while ((el = el.parentElement) && !el.classList.contains(cls))
		;
	return el;
}
function showSuccessfulMsg(){
	
	AUI().use('aui-base', function(A) {
		var boundingBox = "#sucess-popup";
    	var contentBox = "#sucess-popup-box";
        A.one(boundingBox).set('hidden', false);
        
        YUI().use('aui-modal', function(Y) {
           var modal = new Y.Modal({
                           boundingBox: boundingBox,
                           contentBox: contentBox,
                           headerContent: '',
                           centered: true,
                           destroyOnHide: false,
                           modal: true,
                           resizable: false,
                           draggable: true,
            }).render();
            Y.one('.close').on(
            	      'click',
            	      function() {
            	    	  
            	        modal.hide();
            	      }
            	    );
        });

    });
}
function showAlertDiv(msg){
	var showAlertDiv = document.getElementById('form-error-div');
	var errorDiv = document.getElementById('error_msg');
	showAlertDiv.style.display= "block";
	errorDiv.innerHTML = msg;
}
function hideAlert(){
	document.getElementById('form-error-div').style.display= "none";
}
function afterFormSubmissionCustomForm(formType,status){
	
	var msg = "";
	if(status == "Draft"){
		msg = formType + " saved to Draft";
	}else if(formStorageId == "0" || formStorageId == ""){
		msg = formType + " Created!";
	}
	else if(status == "Active" ){
		msg = formType + " Created!";
	}
	else if(status == "Inactive" ){
		msg = formType + " Updated!";
	}
	document.getElementById('success-msg').innerHTML = msg;  
	AUI().use('aui-base', function(A) {
		var boundingBox = "#sucess-popup";
    	var contentBox = "#sucess-popup-box";
        A.one(boundingBox).set('hidden', false);
        
        YUI().use('aui-modal', function(Y) {
           var modal = new Y.Modal({
                           boundingBox: boundingBox,
                           contentBox: contentBox,
                           headerContent: '',
                           centered: true,
                           destroyOnHide: false,
                           modal: true,
                           resizable: false,
                           draggable: false,
            }).render();
            Y.one('.close').hide();
        });

    });
}
function moveToDashboard(){
	window.location.href = dashboardLinkk;
}
function capitalizeFirstLetter(string) {
	return string.charAt(0).toUpperCase() + string.slice(1);
}
function editFormIoPage(){
	window.location.href = window.location.href.replace("view","edit");
}
function reload(){
	window.location.reload();
}
function showLoading(show) {
	if(show) {
		document.getElementById("loadingDiv").style.display = "block";
	} else {
		document.getElementById("loadingDiv").style.display = "none";
	}
}
function setCookie(cname, cvalue, exSeconds) {
	  var d = new Date();
	  d.setTime(d.getTime() + (exSeconds*1000));
	  var expires = "expires="+ d.toUTCString();
	  document.cookie = cname + "=" + cvalue + ";" + expires + ";path=/";
}
function getCookie(cname) {
  var name = cname + "=";
  var decodedCookie = decodeURIComponent(document.cookie);
  var ca = decodedCookie.split(';');
  for(var i = 0; i <ca.length; i++) {
    var c = ca[i];
    while (c.charAt(0) == ' ') {
      c = c.substring(1);
    }
    if (c.indexOf(name) == 0) {
      return c.substring(name.length, c.length);
    }
  }
  return "";
}
function checkCookie() {
  var user = getCookie("username");
  if (user != "") {
    alert("Welcome again " + user);
  } else {
    user = prompt("Please enter your name:", "");
    if (user != "" && user != null) {
      setCookie("username", user, 365);
    }
  }
}

function deleteCookie(cname) {
	document.cookie = cname + "=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;";
}
