var currentLevel = 1;
var exForm ;
var availableForms;
var key5,arrr;
function toggle(className, displayState){
    var elements = document.getElementsByClassName(className)

    for (var i = 0; i < elements.length; i++){
        elements[i].style.display = displayState;
    }
}
function addlevel(){
	if(currentLevel < maxLevels){
		currentLevel++ ;
		document.getElementById("selectField"+ currentLevel + "-1" ).style.display = "block";
		document.getElementById("subLevelBtn"+ currentLevel).style.display = "block";
		if(currentLevel == maxLevels){
			document.getElementById("addlevelbtn").style.display = "none";
		}
	}
}
function addsub(level){
	var children = document.getElementsByClassName("level"+ level);
	var count = 1;
	var activatedsubleveles = 1;
	for(var i = 0; i < children.length; i++){
		 //if (children[i].classList.contains('req'))
        if (children[i].style.display == "block"){
        	 count++;
        }
		if(activatedsubleveles < count){
			activatedsubleveles = count;
			document.getElementById("activatedsubleveles").value = activatedsubleveles;
		}	
	}
	if(count <= maxLevels){
	    document.getElementById("selectField"+ level + "-" + count ).style.display = "block";
	    if(count == maxLevels){
	    	document.getElementById("subLevelBtn"+ level).style.display = "none";
	    }
	}
}

function saveTemplate(){
	if(document.getElementById("_template_WAR_SPTemplateManagementportlet_templateName").value == ""){
		displayMessage('danger', "Template Name is empty", 3000);   
	}
	else if(document.getElementById("parentTemplate").value == ""){
		displayMessage('danger', "Parent Template is empty", 3000);
	}
	else{
		AUI().use('aui-io-request', function(A){
	    	document.getElementById("submitBtn").style.display = "none";
	    	var api_url = document.getElementById("apiUrl").value;
	    	var redirect_url = document.getElementById("redirectUrl").value;
	        A.io.request(api_url, {
	               method: 'post',
	               form: {
	                   id: '_template_WAR_SPTemplateManagementportlet_fm'
	               },
	               on: {
						success: function() {
							var status = this.get('responseData');
							if(status == "Template added" || status == "Template updated"){
								window.location.href= redirect_url;
							}
							else{
								
								displayMessage('danger',status, 3000);
								document.getElementById("submitBtn").style.display = "block";
							}
						},
						failure : function() {
							displayMessage('danger',"Bad Request", 3000);
						}
	                }
	        });
	    });
	}
}
function deleteTemplate(template_id){
	
	AUI().use('aui-io-request', function(A){
    	var api_url = document.getElementById("apiUrl").value;
    	var ns = document.getElementById("namespace").value;
        A.io.request(api_url, {
               method: 'post',
               data: {
            	   _template_WAR_SPTemplateManagementportlet_template_id: template_id
               },
               on: {
					success: function() {
						var status = this.get('responseData');
						if(status == "Template not deleted"){
							displayMessage('danger',status, 3000);
							document.getElementById("submitBtn").style.display = "block";
						}
						else{
							window.location.reload();
						}
					},
					failure : function() {
						displayMessage('danger','Bad request', 3000); 
					}
                }
        });
    });
	
}
function checkForm(){
	exForm = [];
	availableForms = [];
	[].forEach.call(  document.querySelectorAll('.selectbox :checked')  , function(elm){
	if(elm.value !=  0){
		//alert(elm.value);
		var str_array = elm.value.split('--');
		var key = str_array[0] + "" ;
		var val = str_array[1];
		var arr = {key : val};
		exForm[key] = arr;

		}
	})

	masterForm.forEach(function(entry,key) {
		key5 = key;
		if(!exForm.hasOwnProperty(key)){
			var formId = entry.FormId;
			availableForms.push(entry);
		}
	});
	[].forEach.call(  document.querySelectorAll('.selectbox')  , function(elm){
		var currkey = elm.options[elm.selectedIndex].text;
		var currvalue = elm.value;
		for(var j = elm.options.length; j > 0 ;j--){
			elm.remove(j);
		}
		var o = document.createElement("option");
		o.value = currvalue;
		o.text = currkey;
		o.selected ='selected';
	    elm.appendChild(o);
	    for (var i = 0; i < availableForms.length; i++) {
	        var o = document.createElement("option");
	        o.value = availableForms[i].FormId +"--" + availableForms[i].ClassName;
	        var formName = availableForms[i].FormName;
	        var res = formName.split("-");
	        o.text = res[0];
	        elm.appendChild(o);
	    }
	})
}
var timeOut;
function scrollToTop() {
	if (document.body.scrollTop != 0 || document.documentElement.scrollTop != 0) {
		window.scrollBy(0, -50);
		timeOut = setTimeout('scrollToTop()', 10);
	} else {
		clearTimeout(timeOut);
	}

}
function displayMessage(type, message, duration) {
	scrollToTop();
	var alert_div = document.getElementById("alert_msg");
	alert_div.innerHTML = message;
	alert_div.classList.add("alert-" + type);
	alert_div.style.display = "block";
	setTimeout(function() {
		alert_div.style.display = "none";
	}, duration);
	console.log(message);
}