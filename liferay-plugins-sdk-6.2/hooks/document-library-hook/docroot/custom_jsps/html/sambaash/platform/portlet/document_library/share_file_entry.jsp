<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page import="com.liferay.portal.kernel.util.GetterUtil" %>
<%@ page import="com.liferay.portal.kernel.util.Validator" %>
<%@ page import="com.liferay.portal.security.permission.ResourceActionsUtil" %>
<%@ page import="com.liferay.portal.kernel.util.HtmlUtil" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="com.sambaash.platform.srv.model.Sharing" %>
<%@ page import="com.sambaash.platform.srv.service.SharingLocalServiceUtil" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="com.liferay.portal.kernel.util.Constants"%>

<portlet:defineObjects />
<liferay-theme:defineObjects />

<style>

.icon-circle-triangle-b {
    background: url("<%= themeDisplay.getPathThemeImages()%>/arrows/05_down.png") no-repeat scroll 0 5px rgba(0, 0, 0, 0);
}

.buttonitem-icon-only {
    box-sizing: content-box;
    font-size: 0;
    height: 24px;
    overflow: hidden;
    padding: 3px;
    width: 8px;
}

input[type="button"]{
background:#fff;
}

#intShare_button, #extShare_button {
    background: none repeat scroll 0 0 #479e55 !important;
    text-shadow : none;
}

div#overlay {
	display: none;
	z-index: 2;
	position: fixed;
	width: 100%;
	height: 100%;
	top: 0px;
	left: 0px;
	text-align: center;
}
div#specialBox {
	display: none;
	position: relative;
	z-index: 3;
	margin: 0;
	width: 300px; 
	height: 150px;
	background: #FFF;
	color: #000;
	border: 1px solid black;
	float:right;
}

div#share_details {
	position:absolute;
	top: 170px;
	padding-left:24px;
	width: 95%;
}


.overlay_button{
	background: none;
    border: medium none;
    display: inline-table;
    float: right;
    margin-right: 10px;
}

.shareInlineText{
float: right; 
font-size: 8pt; 
font-style: italic;
font-weight: bold;
padding: 10px 0;
}

.template-list-actions {
	padding: 10px 10px 10px 40px !important;
	text-align: left !important;
}

.ext_icon {
  padding-left: 5px;
}

</style>

<%
String fileEntryId = request.getParameter("fileEntryId");
String folderId = request.getParameter("folderId");
String folderIds = request.getParameter("folderIds");
String fileEntryIds = request.getParameter("fileEntryIds");

if(Validator.isNull(folderId) && Validator.isNotNull(folderIds)){
	folderId = folderIds;
}
if(Validator.isNull(folderId) && Validator.isNull(folderIds)){
	folderId = "0";
}

if(Validator.isNull(fileEntryId) && Validator.isNotNull(fileEntryIds)){
	fileEntryId = fileEntryIds;
}
if(Validator.isNull(fileEntryId) && Validator.isNull(fileEntryIds)){
	fileEntryId = "0";
}

List sharedFileList= (List) request.getAttribute("sharingList");
String durationList= (String) request.getAttribute("durationList");
String sharedFileName= (String) request.getAttribute("sharedFileName");

%>
<script>
var shareEmailList = [${sharedEmailList}];
var indexVal = ${indexVal};
if(!indexVal){
	indexVal = 100;
}
</script>
<div id="overlay" onmousedown="toggleOverlay('')"></div>
<div id="specialBox">
 <button class="overlay_button" onmousedown="toggleOverlay('')">X</button>
	<div id="save_message" class="success_message" style="display: inline-table; margin-left: 20px; margin-top: 30px;">
 <b>  <%=sharedFileName %> shared Successfully</b></div> 
  <div id="delete_message" class="success_message" style="display: inline-table; margin-left: 20px; margin-top: 30px;">
 <b> File / Folder sharing removed Successfully</b></div> 
 
</div>
<div id="share_details">
<div class = "sharePageTitle" style="font-weight:bold;font-size:2.5em"><%=sharedFileName %></div>
<div class="user_item">
 	<div class="user_item_Bio">
        <ul class="accor_list accor_list_bio">
           <li id="accor_list1" class="accor_list_item accor_list_icon1">
               <a href="#">Internal Share <span class="shareInlineText" style="">Add Menarini Users only</span></a>
                  <div class="accor_subContent accor_subContent_Bio">
                      <%@ include file="/html/portlet/document_library/internal_share.jsp" %>
                  </div> 
           </li>
       </ul>    
    </div>
</div>   

<div class="user_item">
 	<div class="user_item_Bio">
        <ul class="accor_list accor_list_bio"> 
           <li id="accor_list2" class="accor_list_item accor_list_icon2">
               <a href="#">External Share</a>
                   <div class="accor_subContent accor_subContent_Bio">
                       <%@ include file="/html/portlet/document_library/external_share.jsp" %>
                   </div> 
           </li>
        </ul>    
    </div>
</div>

<div class="sharedFiles_list">
	<table id="sharedFiles-table" class="sharedFiles-table" style="width: 98%;">
		<tbody id ="sharedFiles-table-body">
				<tr>
					<td class="mailtemplate-list-title" width="25%">
						<b>File / Folder Name</b>
					</td>
					<td class="mailtemplate-list-title" width="34%">
						<b>Shared to</b>
					</td>
					<td class="mailtemplate-list-title" width="19%">
						<b>Duration</b>
					</td>
					<td class="mailtemplate-list-title" width="22%">
						<b>Action</b>
					</td>
				</tr>
				<c:if test="${not empty sharingList}">
				  <c:forEach var="sharing" items="${sharingList}" >
					<tr>
						<td class="template-list" style="padding: 10px">
							<input type="hidden" value="${sharing.sharingId}" id="sharingId_${sharing.index}">
							${sharing.title }
							<input type="hidden" value="${sharing.internalShare }" id="shareType_${sharing.index}">
							<c:if test="${sharing.internalShare == 'false' }">
								<img src="<%= themeDisplay.getPathThemeImages()%>/common/externalShare.png" width="20px" title="External Share" alt="External Share"/>
							</c:if>
						</td>
						<td class="template-list" style="padding: 10px">
							<input type="hidden" value="${sharing.userId }" id="sharedToUserId_${sharing.index}">
								${sharing.sharedName }
							</td>
						<td class="template-list" style="padding: 10px">
							<span id="durationRange_${sharing.index}">${sharing.duration }</span>
						</td>
						<td class="template-list-actions">
							<div id="access_${sharing.index}">
						    <input type="checkbox" <c:if test="${sharing.writeAccess == 'Enabled' }">checked</c:if> 
						    	id="writeAccess_${sharing.sharingId}" 
						    	onchange="changeWriteAccess(this.id, '<portlet:resourceURL />')" >Write Access</input>
						   	</div>
						    <c:if test="${sharing.showExtend }">
								<a href="javascript:extendEndDate('${sharing.index}')" class="ext_icon" id="extendDate_${sharing.index}" ><img src="<%=themeDisplay.getPathThemeImages()%>/common/revision2.png" title="Extend" alt="Extend"></a>
								<div id="durationDiv_${sharing.index}" ></div>
								<div id="gap_${sharing.index}" style="margin-left: 20px; display:none">&nbsp;</div>
							</c:if>
							<c:if test="${not sharing.showExtend }">
								<div style="margin-left: 20px;">&nbsp;</div>
							</c:if>
							<a href="javascript:deleteSharedInfo('${sharing.index}')" class="remove_icon" id="remove_${sharing.index}"><img src="<%=themeDisplay.getPathThemeImages()%>/common/delete2.png" title="Remove" alt="Remove"></a>  
						</td>
					</tr>
					</c:forEach>
				</c:if>
				<c:if test="${empty sharingList}">
					<tr id="emptyMsgRow">
						<td class="template-list" style="padding: 10px" id="emptyTable_msg">
							<b>This File / Folder is not yet shared with anyone</b></td>
					</tr>
				</c:if>
				</tbody>
	</table>
</div>
</div>

 <script>
 
 
 
 YUI().use('node', function (Y) {
     
     var list_items = Y.all('.user_item .accor_list .accor_list_item > a');
     var clicked = 0;
 	var tempItem = "";
 	for( var i=0; i<list_items.size(); i++){
 		list_items.removeClass('accordion_enable');
 	}
 	
 	list_items.on('click', accorClick);
 	
 	function accorClick(e){
 				e.preventDefault();
 				var selected = e.currentTarget;
 				
 				var selected_listItem = getEventTarget(e);
 				var selected_parentListItem = selected_listItem.get('parentNode');
 				
 				var itemName =  selected_parentListItem.get("id");
 				
 				
 				
 				list_items.each(function(a){
 					
 					a.removeClass('clicked');
 					
 				});
 				
 				selected.toggleClass('clicked');
 				
 				for( var i=0; i<list_items.size(); i++){
 					list_items.get('parentNode').removeClass('accordion_enable');
 					
 					
 				}
 				if(itemName == tempItem){
 					
 					selected_parentListItem.removeClass('accordion_enable');
 					selected.removeClass('clicked');
 					tempItem = "";
 				}
 				else{
 					selected_parentListItem.toggleClass('accordion_enable');
 					tempItem = itemName;
 					
 					
 				}
 				
 							
 	}

 	
 });
 
 function extendEndDate(k){
	 var duration_list = '<%= durationList%>';
	 var removeAnc = document.getElementById("remove_"+k);
	 removeAnc.style.display = "none";
	 var durationAnc = document.getElementById("extendDate_"+k);
	 durationAnc.style.display = "none";
	 var accessDiv = document.getElementById("access_"+k);
	 accessDiv.style.display = "none";
	 var selDiv = document.getElementById("durationDiv_"+k);
	 var daysSpan = document.createElement("span");
	 var daysDiv = document.createElement("select");
		daysDiv.setAttribute("id","shareSelectRow_"+k);
		daysDiv.setAttribute("name","InternalShareDurationRow");
		var dList = duration_list.split(",");
		for(d=0;d<dList.length;d++){
	  		var daysOption = document.createElement("Option");
	  		daysOption.value = dList[d];
	  		daysOption.text = dList[d];
	  		daysDiv.appendChild(daysOption);
		 }
		daysSpan.appendChild(daysDiv);
		 var saveSpan = document.createElement("span");
		 var saveAnc = document.createElement("a");
		 var saveText = document.createTextNode("Save");
		 saveAnc.setAttribute("href","javascript:extendDateForSharing(" + k + ")");
		 saveAnc.appendChild(saveText);
		 saveSpan.appendChild(saveAnc);
		selDiv.appendChild(daysSpan);
		selDiv.appendChild(saveSpan);
 }
 
 
 function deleteSharedInfo(k) {
	//	try {
			
			var sharingId = document.getElementById("sharingId_"+k).value;
			//var classPk = document.getElementById("classPk_"+k).value;
			var sharedToUser = document.getElementById("sharedToUserId_"+k).value;
			//var shareType = document.getElementById("shareType_"+k).value;
			var action="Delete";
						var A = AUI();
						var reqUrl = '<portlet:resourceURL id="" />';
						var successSave = true;
						A.io
								.request(
										reqUrl,
										{
											cache : false,
											sync : true,
											timeout : 1000,
											dataType : 'json',
											method : 'post',

											data : {
												sharingId : sharingId,
												sharedToUser : sharedToUser,
												action : action
											},
											on : {
												success : function() {
													items = this.get('responseData');
													if(shareEmailList && items && items.sharedEmail){
														for(var i=0; i<shareEmailList.length;i++){
															if(shareEmailList[i].indexOf(items.sharedEmail) != -1){
																shareEmailList.splice(i,1);
																break;
															}
														}
													}
													//alert(shareEmailList);
													var child = document.getElementById("sharedToUserId_"+k);
													child.parentNode.parentNode.parentNode.removeChild(child.parentNode.parentNode);
													var table = document.getElementById("sharedFiles-table");
													var x = table.rows.length;
													if(x == 1){
														var emptyMsgRow = document.createElement("tr");
														emptyMsgRow.setAttribute("id","emptyMsgRow");
														var emptyMsgDiv = document.createElement("td");
														emptyMsgDiv.setAttribute("class","template-list");
														emptyMsgDiv.setAttribute("style","padding: 10px");
														emptyMsgDiv.setAttribute("id","emptyTable_msg");
														emptyMsgDiv.innerHTML = "<b>This File / Folder is not yet shared with anyone</b>";
														emptyMsgRow.appendChild(emptyMsgDiv);
														table.appendChild(emptyMsgRow);
													}
													toggleOverlay('delete_message');
												},
												failure : function() {
												}
											}
										});
			// return true; 
		//} catch (err) {
			//alert("deleteSharedInfo: " + err);
		//}
	}

 function extendDateForSharing(k) {
		//	try {
				var sharingId = document.getElementById("sharingId_"+k).value;
				var extendDuration = document.getElementById("shareSelectRow_"+k).value;
				var action="extendDate";
							var A = AUI();
							var reqUrl = '<portlet:resourceURL id="" />';
							var successSave = true;
							A.io
									.request(
											reqUrl,
											{
												cache : false,
												sync : true,
												timeout : 1000,
												dataType : 'json',
												method : 'post',

												data : {
													extendDuration : extendDuration,
													sharingId : sharingId,
													action : action
												},
												on : {
													success : function() {
														items = this.get('responseData');
													//	var colToUpdate = document.getElementById('sharedFiles-table').rows[k].cells[2];
														colToUpdate = document.getElementById("durationRange_"+k);
														colToUpdate.innerHTML = "";
														colToUpdate.innerHTML = items;
														var selDiv = document.getElementById("durationDiv_"+k);
														selDiv.innerHTML = "";
														var removeAnc = document.getElementById("remove_"+k);
	 													removeAnc.style.display = "inline-block";
	 													//var durationAnc = document.getElementById("extendDate_"+k);
//	 													durationAnc.style.display = "inline-block";
	 													var accessDiv = document.getElementById("access_"+k);
	 													accessDiv.style.display = "inline-block";
	 													var gapDiv = document.getElementById("gap_"+k);
	 													gapDiv.style.display = "inline-block";
													},
													failure : function() {
													}
												}
											});
				// return true; 
			//} catch (err) {
				//alert("deleteSharedInfo: " + err);
			//}
		}

 
 function toggleOverlay(id){
		var overlay = document.getElementById('overlay');
		var specialBox = document.getElementById('specialBox');
		overlay.style.opacity = .8;
		if(overlay.style.display == "block"){
			overlay.style.display = "none";
			specialBox.style.display = "none";
		} else {
			overlay.style.display = "block";
			specialBox.style.display = "block";
			if(id=='save_message'){
				document.getElementById('save_message').style.display="block";
				document.getElementById('delete_message').style.display="none";
			}else if(id=='delete_message'){
				document.getElementById('delete_message').style.display="block";
				document.getElementById('save_message').style.display="none";
			}	
		}
	}

</script>
