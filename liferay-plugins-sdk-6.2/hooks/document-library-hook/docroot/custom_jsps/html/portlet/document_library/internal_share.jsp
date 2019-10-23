<%@ page import="com.liferay.portal.kernel.language.LanguageUtil" %>
<link href="/html/portlet/document_library/css/autocomplete.css" rel="stylesheet" type="text/html" />
<script type="text/javascript" src="/html/portlet/document_library/js/pure_javascript_functions.js" ></script>
<script type="text/javascript" src="/html/portlet/document_library/js/auto_complete_pure_javascript.js" ></script>

<portlet:resourceURL var="findInvitePeopleSuggestionsURL">
	<portlet:param name="action" value="findInvitePeopleSuggestions"></portlet:param>
</portlet:resourceURL>

<portlet:resourceURL var="inviteFriendsURL">
	<portlet:param name="action" value="inviteFriends"></portlet:param>
</portlet:resourceURL>

<div id="<portlet:namespace />inviteFriendsEmailContent">
	<form id="<portlet:namespace />ip_form" action="<%=inviteFriendsURL %>" method="POST" onsubmit="sendInvitations(event)" class="s1">
		<input type="hidden" name="<portlet:namespace />folderId" value="<%=folderId %>" />
		<input type="hidden" name="<portlet:namespace />fileEntryId" value="<%=fileEntryId %>" />
		<input type="hidden" name="<portlet:namespace />inviteBy" value="email" />
		<div class="fieldset">
			<div><label for="ip_to" class="sp-group-column sp-group-of-ten" style="vertical-align: middle;"><span class="sp-group-ui-db"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.shareto")%></span></label><div class="sp-group-nonuple-column sp-group-column sp-group-of-ten"><div data-autocomplete-dom-id="sis-holder" data-group-id="<%=folderId %>" class="ip-to">
				<ul data-autocomplete-dom-id="selected-items" class="horizontal sp-group-ui-dib sp-group-ui-vam">
					
				</ul>
				<span class="ip-to-input-outer"><span style="visibility: hidden; z-index: -10000; position: relative; width: 100%;"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.add.email.address")%>&nbsp;</span><input data-autocomplete-dom-id="input" id="ip_to" type="text" tabindex="0" placeholder="<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.add.email.address")%>" autocomplete="off" value="" class="ip-to-input" /></span></div>
				<div data-autocomplete-dom-id="suggestions-board" class="ip-sb" style="display: none;">
					<div data-autocomplete-dom-id="close-btn" class="ip-sb-c"></div>
					<div data-autocomplete-dom-id="options" class="ip-sb-options">
						
					</div>
				
				</div>
			</div></div>
		</div>
		<div style="text-align:center;">
			<span class="sp-group-column sp-group-of-ten"></span><input id="ag_submit" type="submit" value="<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.internal.share")%>" tabindex="3" class="sp-group-column" />
		</div>
	</form>
</div>

<script type="text/javascript">
	
	var xhr;

	/**
	* Ajax Get
	*/
	function AjaxGet(url, successFunc, errorFunc) {
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
		 stopPreLoader('share_details');
		 alert("error" + err);
	}
	}

	function sendInvitations(e) {
	try{
		startPreLoader('share_details');
		preventDefault(e);
		var ip_form = getEventTarget(e);
		var selected_items = getFirstElementsByAttribute(ip_form, "ul", "data-autocomplete-dom-id", "selected-items");
		var sis = getElementsByAttribute(selected_items, "li", "data-autocomplete-dom-id", "si");
		var send_to = "";
		
		for(var i=0; i<sis.length; i++) {
		
			var si = sis[i];
			
			var user_id = si.getAttribute("data-user-id");
			// document.title += " -user_id:" + user_id;
			
			if(user_id == 0) {
				
				var si_email_span = getFirstElementsByAttribute(si, "span", "data-autocomplete-dom-id", "si-email");
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
		
		var durations = document.getElementsByName("iShareDuration");
		var durationList = "";
		for(var d=0;d<durations.length;d++){
			if(durationList.length > 0) {
				durationList += ",";
			}
			durationList += durations[d].value;
		}
		
		var rwArray = document.getElementsByName("iAllowWrite");
		var rwList = "";
		for(var d=0;d<rwArray.length;d++){
			if(rwList.length > 0) {
				rwList += ",";
			}
			rwList += rwArray[d].checked;
		}
		var folderId = ip_form.elements["<portlet:namespace />folderId"].value;
		var file_entry_id = ip_form.elements["<portlet:namespace />fileEntryId"].value;
   		var invite_by = ip_form.elements["<portlet:namespace />inviteBy"].value;
		// document.title += " -invite_by:" + invite_by;
		
        if(send_to.length == 0) {
        	stopPreLoader('share_details');
			alert("Please select atleast one email address.");
        }else {
        	
			var temp_url = ip_form.getAttribute("action");
			temp_url += "&<portlet:namespace />folderId=" + folderId + "&<portlet:namespace />fileEntryId=" + file_entry_id + "&<portlet:namespace />send_to=" + send_to +"&<portlet:namespace />invite_by=" + invite_by+"&<portlet:namespace />shareType=1&<portlet:namespace />durationList=" + durationList + "&<portlet:namespace />permissionList=" + rwList;
			AjaxGet(temp_url, sendInvitationsSuccess, sendInvitationsError);
			
        }
	}catch(err) {
		// alert(err);
		stopPreLoader('share_details');
	}
	}

	function sendInvitationsSuccess() {
	try{
		stopPreLoader('share_details');
		var data = JSON.parse(xhr.responseText);

		var ip_form = document.getElementById("<portlet:namespace />ip_form");
		var selected_items_container = getFirstElementsByAttribute(ip_form, "ul", "data-autocomplete-dom-id", "selected-items");
		selected_items_container.innerHTML = "";
		
		var success_msg = "<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.request.processed.success")%>";
		var failed_msg = "<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.request.not.processed")%>";
		var atLeastOne = false;
		if(data){
			for(key in data) {
					var recordAdded = false;
					var sharedValues = data[key];
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
					//alert("sharedValues " + sharedValues);
					//alert("added " + recordAdded);
					var table = document.getElementById("sharedFiles-table");
					var tableBody = document.getElementById("sharedFiles-table-body");
			//		var x = table.rows.length + 1;
				//	if(tableBody){
//						x = tableBody.rows.length + 1;
	//				}
					
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
						var removeOption ="<a class='remove_icon' href='javascript:deleteSharedInfo(" + x + ")' id=" + removeId + " style='padding-left:9px'><img src='<%=themeDisplay.getPathThemeImages()%>/common/delete2.png' title='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.remove")%>' alt='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.remove")%>'></a>";
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
			if(atLeastOne)
				alert(success_msg);
		}else{
			alert(failed_msg);
		}
		
	}catch(err) {
		 alert(err);
	}
	}

	function sendInvitationsError() {
	try{
		stopPreLoader('share_details');
		alert("<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.error.ehile.processing")%>");
	}catch(err) {
		// alert(err);
	}
	}

</script>

<script type="text/javascript">

	var j_ip_form = document.getElementById("<portlet:namespace />ip_form");
	var j_autocomplete_sis_holder = getFirstElementsByAttribute(document, "div", "data-autocomplete-dom-id", "sis-holder");
	var j_autocomplete_input = getFirstElementsByAttribute(document, "input", "data-autocomplete-dom-id", "input");
	var j_autocomplete_suggestions_board = getFirstElementsByAttribute(document, "div", "data-autocomplete-dom-id", "suggestions-board");
	var j_autocomplete_close_btn = getFirstElementsByAttribute(document, "div", "data-autocomplete-dom-id", "close-btn");
	var j_autocomplete_options = getFirstElementsByAttribute(document, "div", "data-autocomplete-dom-id", "options");
	var j_autocomplete_selected_items = getFirstElementsByAttribute(document, "ul", "data-autocomplete-dom-id", "selected-items");
	
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
		'shareEmailList' : shareEmailList,
		'selectedUserAdded' : '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.selected.user.already.added")%>',
		'fileAlreadyShared' : '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.selected.file.already.shared")%>',
		'notValidEmail' : '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.not.valid.email.address")%>',
		'noExternalShares' : '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.external.share.not.possible")%>',
		'errorMatchingIdsMessage' : '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.error.matching.id")%>',
		'writeAccess' : '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.write.access")%>',
		'allowWrite' : '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.allow.write")%>'
	});

</script>
