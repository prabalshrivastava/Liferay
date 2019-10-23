
<%@ page import="com.liferay.portal.kernel.language.LanguageUtil" %>
<link href="/html/portlet/document_library/css/autocomplete.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="/html/portlet/document_library/js/auto_complete_ext_pure_javascript.js" ></script>

<portlet:resourceURL var="findInvitePeopleSuggestionsURL">
	<portlet:param name="action" value="findInvitePeopleSuggestions"></portlet:param>
</portlet:resourceURL>

<portlet:resourceURL var="inviteFriendsURL">
	<portlet:param name="action" value="inviteFriends"></portlet:param>
</portlet:resourceURL>

<div id="<portlet:namespace />inviteFriendsEmailContent">
	<form id="<portlet:namespace />ext_form" action="<%=inviteFriendsURL %>" method="POST" onsubmit="externalShare(event)" class="s1">
		<input type="hidden" name="<portlet:namespace />folderId" value="<%=folderId %>" />
		<input type="hidden" name="<portlet:namespace />fileEntryId" value="<%=fileEntryId %>" />
		<input type="hidden" name="<portlet:namespace />inviteBy" value="email" />
		<div class="fieldset">
			<div><label for="ip_to" class="sp-group-column sp-group-of-ten" style="vertical-align: top;"><span class="sp-group-ui-db">Share to:</span></label><div class="sp-group-nonuple-column sp-group-column sp-group-of-ten"><div data-autocomplete-dom-id="ext-sis-holder" data-group-id="<%=folderId %>" class="ip-to">
				<ul data-autocomplete-dom-id="ext-selected-items" class="horizontal sp-group-ui-dib sp-group-ui-vam">
					
				</ul>
				<span class="ip-to-input-outer"><span style="visibility: hidden; z-index: -10000; position: relative; width: 100%;">Add Email Address&nbsp;</span><input data-autocomplete-dom-id="ext-input" id="ext_to" type="text" tabindex="0" placeholder="Add Email Address" autocomplete="off" value="" class="ip-to-input" /></span></div>
				<div data-autocomplete-dom-id="ext-suggestions-board" class="ip-sb" style="display: none;">
					<div data-autocomplete-dom-id="ext-close-btn" class="ip-sb-c"></div>
					<div data-autocomplete-dom-id="ext-options" class="ip-sb-options">
						
					</div>
				
				</div>
			</div></div>
		</div>
		<div>
			<span class="sp-group-column sp-group-of-ten"></span><input id="ext_submit" type="submit" value="External Share" tabindex="3" class="sp-group-column" />
		</div>
	</form>
</div>

<script type="text/javascript">
	
	var xhr;

	/**
	* Ajax Get
	*/
	function ExtAjaxGet(url, successFunc, errorFunc) {
	try{
		if(window.XMLHttpRequest) {
			// code for IE7+, Firefox, Chrome, Opera, Safari
		  	xhr = new XMLHttpRequest();
		}
		else {
			// code for IE6, IE5
		 	xhr = new ActiveXObject("Microsoft.XMLHTTP");
		}
		xhr.onreadystatechange = function() {
			if(xhr.readyState == 4) {
			    if(xhr.status == 200) {
			    	successFunc();
			    }
			    else {
			    	errorFunc();
			    }
			}
		};
	   xhr.open("GET", url,  true); 
	   xhr.send(null);
	   
	}catch(err) {
		 alert("error" + err);
	}
	}

	function externalShare(e) {
	try{
		preventDefault(e);
		var ext_form = getEventTarget(e);
		var selected_items = getFirstElementsByAttribute(ext_form, "ul", "data-autocomplete-dom-id", "ext-selected-items");
		var sis = getElementsByAttribute(selected_items, "li", "data-autocomplete-dom-id", "ext-si");
		var send_to = "";
		
		for(var i=0; i<sis.length; i++) {
		
			var si = sis[i];
			
			var user_id = si.getAttribute("data-user-id");
			// document.title += " -user_id:" + user_id;
			
			if(user_id == 0) {
				
				var si_email_span = getFirstElementsByAttribute(si, "span", "data-autocomplete-dom-id", "ext-si-email");
				var si_email = si_email_span.innerHTML;
				
				if(send_to.length > 0) {
					send_to += ";";
				}
				send_to += si_email;
				
			}else {
				if(send_to.length > 0) {
					send_to += ";";
				}
				send_to += user_id;
			}
		}
		
		var durations = document.getElementsByName("eShareDuration");
		var durationList = "";
		for(var d=0;d<durations.length;d++){
			if(durationList.length > 0) {
				durationList += ",";
			}
			durationList += durations[d].value;
		}
		
		var rwArray = document.getElementsByName("eAllowWrite");
		var rwList = "";
		for(var d=0;d<rwArray.length;d++){
			if(rwList.length > 0) {
				rwList += ",";
			}
			rwList += rwArray[d].checked;
		}
		
		var folderId = ext_form.elements["<portlet:namespace />folderId"].value;
		var file_entry_id = ext_form.elements["<portlet:namespace />fileEntryId"].value;
   		var invite_by = ext_form.elements["<portlet:namespace />inviteBy"].value;
		
        if(send_to.length == 0) {
			alert("Please select atleast one email address.");
        }else {
        	
			var temp_url = ext_form.getAttribute("action");
			temp_url += "&folderId=" + folderId + "&fileEntryId=" + file_entry_id + "&send_to=" + send_to +"&invite_by=" + invite_by+"&shareType=0&durationList=" + durationList + "&permissionList=" + rwList;
			ExtAjaxGet(temp_url, extShareSuccess, extShareError);
			
        }
	}catch(err) {
		alert("externalShare " + err);
	}
	}

	function extShareSuccess() {
	try{
		var data = JSON.parse(xhr.responseText);

		var ip_form = document.getElementById("<portlet:namespace />ext_form");
		var selected_items_container = getFirstElementsByAttribute(ip_form, "ul", "data-autocomplete-dom-id", "ext-selected-items");
		selected_items_container.innerHTML = "";
		
		var success_msg = "Your request has been processed successfully!";
		var failed_msg = "Your request was not processed.";
		var atLeastOne = false;
		if(data){
			for(key in data) {
					//alert("key1 " + key);
					var sharedValues = data[key];
					var recordAdded = false;
					for(key in sharedValues){
						recordAdded = true;
						break;
					}
					if(recordAdded){
						var emptyMsgRow = document.getElementById('emptyMsgRow');
						if(emptyMsgRow){
							emptyMsgRow.parentNode.removeChild(emptyMsgRow);
						}
					}
					
					var table = document.getElementById("sharedFiles-table");
					var x = table.rows.length + 1;
					var tableBody = document.getElementById("sharedFiles-table-body");
				/*	if(tableBody){
						x = tableBody.rows.length + 1;
					} */
					x = indexVal + 1;
					for(key in sharedValues){
						if(key.indexOf('error') == 0) {
							alert(sharedValues[key]);
							continue;
						}
						var indSharedValues = sharedValues[key];
						var row = document.createElement("tr");
						var fileNameCol = document.createElement("td");
						fileNameCol.setAttribute("class","template-list");
						fileNameCol.setAttribute("style","padding: 10px");
						var sharedToCol = document.createElement("td");
						sharedToCol.setAttribute("class","template-list");
						sharedToCol.setAttribute("style","padding: 10px");
						var durationCol = document.createElement("td");
						durationCol.setAttribute("class","template-list");
						durationCol.setAttribute("style","padding: 10px");
						var extendCol = document.createElement("td");
						extendCol.setAttribute("class","template-list-actions");
						var removeId = "remove_"+x;
						var removeOption ="<a class='remove_icon' href='javascript:deleteSharedInfo(" + x + ")' id=" + removeId + " style='padding-left:9px'><img src='<%=themeDisplay.getPathThemeImages()%>/common/delete2.png' title='Remove' alt='Remove'></a>";
						for(key in indSharedValues){
						if(key == "sharedFileName"){
							fileNameCol.innerHTML=indSharedValues[key] + " ";
						}
						if(key == "sharingId"){
							var ip1 = document.createElement("input");
							ip1.setAttribute("type","hidden");
							ip1.setAttribute("id","sharingId_"+x);
							ip1.value = indSharedValues[key];
							
							fileNameCol.appendChild(ip1);
						}
						if(key == "shareUserEmail"){
							sharedToCol.innerHTML=indSharedValues[key];
							if(shareEmailList){
								shareEmailList.push(indSharedValues[key]);
							}
						}
						if(key == "shareUserId"){
							var ip1 = document.createElement("input");
							ip1.setAttribute("type","hidden");
							ip1.setAttribute("id","sharedToUserId_"+x);
							ip1.value = indSharedValues[key];
							sharedToCol.appendChild(ip1);
						}	
						if(key == "shareType"){
							if(indSharedValues[key]=="false"){
								var ipImg = document.createElement("img");
								ipImg.setAttribute("src", "<%=themeDisplay.getPathThemeImages()%>/common/externalShare.png");
								ipImg.setAttribute("title","External Share");
								ipImg.setAttribute("width","20px");
								fileNameCol.appendChild(ipImg);
							}
							var ip1 = document.createElement("input");
							ip1.setAttribute("type","hidden");
							ip1.setAttribute("id","shareType_"+x);
							ip1.value = indSharedValues[key];
							fileNameCol.appendChild(ip1);
						}
						if(key == "duration"){
							var durationSpan = document.createElement("span");
							durationSpan.setAttribute("id","durationRange_"+x);
							durationCol.appendChild(durationSpan);
							durationSpan.innerHTML=indSharedValues[key];
						}
						if(key == "extend"){
							var ipAnc = document.createElement("a");
							ipAnc.setAttribute("href","javascript:extendEndDate(" + x + ")");
							ipAnc.setAttribute("id","extendDate_"+x);
							ipAnc.setAttribute("class","ext_icon");
							ipAnc.setAttribute("style","padding-left:10px");
							
							var accessDiv = document.createElement("div");
							accessDiv.setAttribute("id" , "access_" + x);
							var checkboxInput = document.createElement("input");
							checkboxInput.setAttribute("id" , "writeAccess_" + indSharedValues.sharingId);
							checkboxInput.setAttribute("type" , "checkbox");
							checkboxInput.setAttribute("onchange" , "changeWriteAccess(this.id, '<portlet:resourceURL />')");
							if(indSharedValues.writeAccess == 'Enabled')
								checkboxInput.setAttribute("checked" , "true");
							accessDiv.appendChild(checkboxInput);
							accessDiv.innerHTML += "Write Access";
							
							var ipImg = document.createElement("img");
							ipImg.setAttribute("src","<%=themeDisplay.getPathThemeImages()%>/common/revision2.png");
							ipImg.setAttribute("title","Extend");
							ipAnc.appendChild(ipImg);
							
							var ipDiv = document.createElement("div");
							ipDiv.setAttribute("id","durationDiv_"+x);

							extendCol.appendChild(accessDiv);
							extendCol.appendChild(ipAnc);
							extendCol.appendChild(ipDiv);
							extendCol.innerHTML += '<div id="gap_' + x + '" style="margin-left: 20px; display:none">&nbsp;</div>';
							extendCol.innerHTML += removeOption;
						}
						
					}
					atLeastOne = true;
					row.appendChild(fileNameCol);
					row.appendChild(sharedToCol);
					row.appendChild(durationCol);
					row.appendChild(extendCol);
					if(tableBody){
						tableBody.appendChild(row);
					}else{
						table.appendChild(row);
					}
					x = x + 1;
					indexVal = indexVal + 1;
				}
			}
		/*	var table = document.getElementById("sharedFiles-table");
			var x = table.rows.length;
			if(x > 2){
				var tablemsg = document.getElementById("emptyTable_msg");
				if(tablemsg != null){
					table.deleteRow(1);
				}	
			}*/
			if(atLeastOne)
				alert(success_msg);
		}else{
			alert(failed_msg);
		}
		
	}catch(err) {
		 alert(err);
	}
	}

	function extShareError() {
	try{
		alert("Oops! An error occurred while processing your request.");
	}catch(err) {
		// alert(err);
	}
	}

</script>

<script type="text/javascript">

	var j_ip_form = document.getElementById("<portlet:namespace />ext_form");
	var j_autocomplete_sis_holder = getFirstElementsByAttribute(document, "div", "data-autocomplete-dom-id", "ext-sis-holder");
	var j_autocomplete_input = getFirstElementsByAttribute(document, "input", "data-autocomplete-dom-id", "ext-input");
	var j_autocomplete_suggestions_board = getFirstElementsByAttribute(document, "div", "data-autocomplete-dom-id", "ext-suggestions-board");
	var j_autocomplete_close_btn = getFirstElementsByAttribute(document, "div", "data-autocomplete-dom-id", "ext-close-btn");
	var j_autocomplete_options = getFirstElementsByAttribute(document, "div", "data-autocomplete-dom-id", "ext-options");
	var j_autocomplete_selected_items = getFirstElementsByAttribute(document, "ul", "data-autocomplete-dom-id", "ext-selected-items");
	
	new AutoComplete({
		'j_ip_form' : j_ip_form,
		'j_autocomplete_sis_holder' : j_autocomplete_sis_holder,
		'j_autocomplete_input' : j_autocomplete_input,
		'j_autocomplete_suggestions_board' : j_autocomplete_suggestions_board,
		'j_autocomplete_close_btn' : j_autocomplete_close_btn,
		'j_autocomplete_options' : j_autocomplete_options,
		'j_autocomplete_selected_items' : j_autocomplete_selected_items,
		'_duration_list' : '<%=durationList %>',
		'_find_suggestions_url' : '<%=findInvitePeopleSuggestionsURL %>',
		'_portlet_namespace' : '<portlet:namespace />',
		'shareEmailList' : shareEmailList
	});

</script>
