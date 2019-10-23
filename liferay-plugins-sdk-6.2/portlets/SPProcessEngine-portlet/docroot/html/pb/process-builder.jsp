<%@page import="java.util.Date"%>
<%@page import="com.sambaash.platform.pe.helpers.PEHelper"%>
<%@ page import="com.liferay.portal.theme.ThemeDisplay" %>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayPortletMode" %>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<link href="/SPProcessEngine-portlet/css/process-builder.css" rel="stylesheet" />
<link href="/SPProcessEngine-portlet/css/process-builder-fixes.css" rel="stylesheet" />

<portlet:defineObjects />

<!-- Resource URL for AJAX -->
<portlet:resourceURL id = "addNewProcess" var="processResourceURL"></portlet:resourceURL>
<portlet:resourceURL id = "addNewProcessStatusType" var="processStatusTypeResourceURL"></portlet:resourceURL>
<portlet:resourceURL id = "updateDesignerProcess" var="updateDesignerProcessURL"></portlet:resourceURL>
<portlet:resourceURL id = "retriveModelPopupDropDownList" var="retriveDownListURL"></portlet:resourceURL>
<portlet:resourceURL id = "retriveEntities" var="retriveEntitiesURL"></portlet:resourceURL>
<portlet:resourceURL id = "retriveSchedules" var="retriveSchedulesURL"></portlet:resourceURL>
<portlet:resourceURL id = "retriveSubProductType" var="retriveSubProductTypeURL"></portlet:resourceURL>
<portlet:resourceURL id = "retriveProductType" var="retriveProductTypeURL"></portlet:resourceURL>
<portlet:resourceURL id = "retriveProcess" var="retriveProcessURL"></portlet:resourceURL>
<portlet:resourceURL id = "retriveProcessDetail" var="retriveProcessDetailURL"></portlet:resourceURL>
<portlet:resourceURL id = "retriveStatusTypeDetail" var="retriveStatusTypeDetailURL"></portlet:resourceURL>
<portlet:resourceURL id = "editProcess" var="editProcessURL"></portlet:resourceURL>
<portlet:resourceURL id = "copyProcess" var="copyProcessURL"></portlet:resourceURL>
<portlet:resourceURL id = "editStatusType" var="editStatusTypeURL"></portlet:resourceURL>
<portlet:resourceURL id = "retrieveTableData" var="retrieveTableDataDetailURL"></portlet:resourceURL>


<div class="enrollmentContainer screen-max-width ">
<div class="enrollmentRow margin-top-40">

<div class="mainContentContainer roundedborder">
<div class="SearchBar-Container height82">
	<div style="width:25%; float:right;margin-right: 10px;">
		<select id="selectAddType" name="<portlet:namespace />selectAddType" onchange="changeFunc('selectAddType');">
			<option selected >Select Operation</option>
			<option value="addProcess">Add Process</option>
			<option value="addStatusType">Add Status type</option>
		</select>	
		
	</div>
	<div style="width:25%; float:right;margin-right: 10px;">
		<select id="selectEditType" name="<portlet:namespace />selectEditType" onchange="changeFunc('selectEditType');">
			<option selected>Manage</option>
			<option value="showProcesses">Show Processes</option>
			<option value="showStatusTypes">Show Status types</option>
		</select>
	</div>
	<div style="width:25%; float:right;display:none;">
		<select id="selectProcess" name="<portlet:namespace />selectProcess" onchange="filterTable('selectProcess');">
		</select>
	</div>
				
</div>

<div id = "tableId" class="Table-Layout">

	<div class="Heading">
		<div class="Cell Span-width-5">
			<p>ID</p>
		</div>
		<div class="Cell Span-width-40">
			<p>Process Name</p>
		</div>
		<div class="Cell">
			<p>Status</p>
		</div>
		<div class="Cell">
			<p>Steps Involved</p>
		</div>
	 	<div class="Cell">
			<p>Usage</p>
		</div>

		<div class="Cell Span-width-10">
			<p>Date Created</p>
		</div>
		 <div class="Cell">
			<p>Actions</p>
		</div>
	</div>

	<c:forEach items="${listOfProcess}" var="processList">
	<div class="Row">
		 	<div class="Cell Span-width-5">
				<p >${processList.spPEProcessId}</p>
		  	</div>

		  	<div class="Cell Span-width-40">
				<p>${processList.name}</p>
		  	</div>

		 	<div class="Cell">
				<p>${processList.status}</p>
			</div>

			 <div class="Cell">
				<p>....</p>
			</div>

			<div class="Cell">
				<p>...</p>
			</div>

			<div class="Cell Span-width-10">
			
			<c:set var="tempCreateDate"
							value="${processList.createDate }" />
			<%
				Date date = (Date)pageContext.getAttribute("tempCreateDate");
				String dateStr = PEHelper.getDateStrddMMYYYYHMS(date);
			%>
				<p><%=dateStr %></p>
			</div>

			<div class="Cell">
				<span class="Icon-right-border"   id="updateTable1" onclick="setProcessDetail(${processList.spPEProcessId})">
					<img alt="Edit" src="/SPProduct-portlet/images/Product_create/tool.svg">
				</span>
			</div>
		</div>

		
	</c:forEach>
</div>
</div>
</div>
</div>

<script type="text/javascript">

	function changeFunc(selectBox) {
	    var selectBox = document.getElementById(selectBox);
	    var selectedValue = selectBox.options[selectBox.selectedIndex].value;
	    var processBox = document.getElementById('selectProcess');
	    switch(selectedValue){
	    	case 'addProcess':
	    		displayRulePopup();
	    		break;
	    	case 'addStatusType':
	    		displayStatusPopup();
	    		break;
	    	case 'showProcesses':
	    		processBox.parentNode.style.display = 'none';
	    		updateTableData('process');
	    		break;
	    	case 'showStatusTypes':
	    		processBox.parentNode.style.display = 'block';
	    		loadProcessList('selectProcess');
	    		updateTableData('statusType');
	    		break;
	    }
	    
   }
	
	function filterTable(selectBox){
		var processBox = document.getElementById(selectBox);
		var processId = processBox.value; 
		reloadTable(tableData,'statusType',processId);
	}
	function updateTableData(requestType){
		AUI().use('aui.io.request', function(A) {A.io.request('${retrieveTableDataDetailURL}', {
			method : 'get', 
			data : {<portlet:namespace />requestedData : requestType},
			on : {success : 
					function() {
						if(this.get('responseData')){
							switch(requestType){
								case 'process':
									tableData = JSON.parse(this.get('responseData')).processes;
									reloadTable(tableData,requestType);
									break;
								case 'statusType':
									tableData = JSON.parse(this.get('responseData')).statusTypes;
									reloadTable(tableData,requestType);
									break;
							}
						}
					}
				}
		});});
	}
	
	function reloadTable(tableData,requestType,filterByProcessId){
		var tableDiv = document.getElementById('tableId');
		var headingChildrenDivs = document.querySelectorAll('#tableId .Heading div');
		var tableRowDivClone = document.querySelector('#tableId .Row').cloneNode(true);
		
		var statusTypeTableHeadings = ["ID","Status Name","Stage ID","Sequence No","Process ID","Date Created","Actions"];
		var processTableHeadings = ["ID","Process Name","Status","Steps Involved","Usage","Date Created","Actions"];
		
		var filterFlag = filterByProcessId ? true : false ;
		
		if(requestType==='statusType'){
			for(var idx=0;idx<headingChildrenDivs.length;idx++){
				headingChildrenDivs[idx].querySelector('p').innerHTML = statusTypeTableHeadings[idx];
			}
			 
			clearTableData();
			
			var clonedNodeDivs;
			for(var inx=0;inx<tableData.length;inx++){
				var newRow = tableRowDivClone.cloneNode(true);
				clonedNodeDivs = newRow.querySelectorAll('div');
				
				clonedNodeDivs[0].querySelector('p').innerHTML = tableData[inx].statusTypeId;
				clonedNodeDivs[1].querySelector('p').innerHTML = tableData[inx].statusTypeName;
				clonedNodeDivs[2].querySelector('p').innerHTML = tableData[inx].statusTypeStageId;
				clonedNodeDivs[3].querySelector('p').innerHTML = tableData[inx].statusTypeSeqNo;
				clonedNodeDivs[4].querySelector('p').innerHTML = tableData[inx].statusTypeProcessId;
				clonedNodeDivs[5].querySelector('p').innerHTML = tableData[inx].statusTypeDateCreated ? tableData[inx].statusTypeDateCreated : '...';
				clonedNodeDivs[6].querySelector('span').setAttribute('onclick','setStatusTypeDetail('+tableData[inx].statusTypeId+')');
				
				if(filterFlag && tableData[inx].statusTypeProcessId == filterByProcessId)
					tableDiv.appendChild(newRow);
				else if(!filterFlag)
					tableDiv.appendChild(newRow);
				else if(filterFlag && tableData[inx].statusTypeProcessId != filterByProcessId)
					continue;
				
			}
			
			
		}
		else if(requestType==='process'){
			for(var idx=0;idx<headingChildrenDivs.length;idx++){
				headingChildrenDivs[idx].querySelector('p').innerHTML = processTableHeadings[idx];
			}
			
			clearTableData();
			
			var clonedNodeDivs;
			for(var inx=0;inx<tableData.length;inx++){
				var newRow = tableRowDivClone.cloneNode(true);
				clonedNodeDivs = newRow.querySelectorAll('div');
				
				clonedNodeDivs[0].querySelector('p').innerHTML = tableData[inx].processId;
				clonedNodeDivs[1].querySelector('p').innerHTML = tableData[inx].processName;
				clonedNodeDivs[2].querySelector('p').innerHTML = tableData[inx].status;
				clonedNodeDivs[3].querySelector('p').innerHTML = tableData[inx].stepsInvolved ? tableData[inx].stepsInvolved : '...';
				clonedNodeDivs[4].querySelector('p').innerHTML = tableData[inx].usage ? tableData[inx].usage : '...' ;
				clonedNodeDivs[5].querySelector('p').innerHTML = tableData[inx].createDate ? tableData[inx].createDate: '...';
				clonedNodeDivs[6].querySelector('span').setAttribute('onclick','setProcessDetail('+tableData[inx].processId+')');
			
				tableDiv.appendChild(newRow);
				
			}
		}
	}
	
	function clearTableData(){
		//clear table contents 
		var elements=document.getElementById('tableId').getElementsByClassName('Row');
		   while(elements.length){
		       elements[0].parentNode.removeChild(elements[0]);
		}
	}
   
	function updateTable(processId, processName) { 
		
		var pageToRender = "/html/pb/designwizard.jsp";
		var isUpdate = true;
	
		rederToURL(pageToRender, processId, isUpdate, processName);
	}

	function setProcessDetail(processId) {
	
		AUI().use('aui.io.request', function(A) {A.io.request('${retriveProcessDetailURL}', {method : 'get', data : {<portlet:namespace />processId : processId},
	
			on : {success : 
					function() {
							var processDetail = JSON.parse(this.get('responseData')).processDetail;
							editProcess(processDetail);
						}
			}
		});});
	}
	
	function setStatusTypeDetail(statusTypeId) {
		
		AUI().use('aui.io.request', function(A) {A.io.request('${retriveStatusTypeDetailURL}', {
			method : 'get', 
			data : {<portlet:namespace />statusTypeId : statusTypeId},
			on : {
				success : 
					function() {
							var statusTypeDetail = JSON.parse(this.get('responseData')).statusTypeDetail;
							editStatusType(statusTypeDetail);
					}
			}
		});});
	}

	function editProcess(processDetail) {
		var enableAssignment = processDetail.isEnableAssignment;
		if(enableAssignment == true)
			enableAssignment = "checked";
		else
			enableAssignment = "";
		
		var enableSingleSubmission = processDetail.isEnableSingleSubmission;
		if(enableSingleSubmission == true)
			enableSingleSubmission = "checked";
		else
			enableSingleSubmission = "";
		
		var enableEmail = processDetail.isAccountCreationEmailEnabled;
		
		if(enableEmail == true)
			enableEmail = "checked";
		else
			enableEmail = "";
		
		var editFeeDetails = processDetail.isEditFeeDetails;
		
		if(editFeeDetails == true)
			editFeeDetails = "checked";
		else
			editFeeDetails = "";
	
		var showHeader = processDetail.isShowHeader;
		if(showHeader == true)
			showHeader = "checked";
		else
			showHeader = "";

		var enableFirstStepProgress = processDetail.isEnableFirstStepProgress;
		if(enableFirstStepProgress == true)
			enableFirstStepProgress = "checked";
		else
			enableFirstStepProgress = "";
		
		var topOrientationSelected = "selected";
		var leftOrientationSelected = "";
		
		if ("left" == processDetail.orientation) {
			topOrientationSelected = "";
			leftOrientationSelected = "selected";
		}

		AUI()
			.use(
				'aui-node',
				'aui-base',
				'aui-dialog',
				'liferay-util-window',
				'aui-overlay-manager-deprecated',
				'dd-constrain',
				'aui-aria',
	
				function(A) {
					titleMsg = "Process Details";
					var dialog = Liferay.Util.Window
						.getWindow({
							title : titleMsg,
							dialog : {
								bodyContent : '<form id = "editProcessFormId" action="">' +
												'<div class="column" style="margin:20px;  font-size:11pt;">'+
												'<span style="font-size:12px" >Name of Process</span><br>'+
												'<input type="hidden" id="processId" value=' + processDetail.processId + '>' +
												'<input type = "text" value="' + processDetail.processName + '" name = "<portlet:namespace />processName" /><br><br>'+
												'<span style="font-size:12px" >Entity Class</span><br>' +
												'<select name = "<portlet:namespace />processEntityClassOptions" id="processEntityClassOptions">'+ loadEntities(processDetail.enityClassId) +'</select><br><br>' +
												'<span style="font-size:12px">Agent Role Ids</span><br>' +
											    '<select name = "<portlet:namespace />agentRoleIds" multiple id="agentRoleIds">'+ loadJSONArrForDropDown('mail', 'agentRoleIds', processDetail.agentRoleIds) +'</select><br><br>' +
											    '<span style="font-size:12px">Approver Ids</span><br>' +
											    '<select name = "<portlet:namespace />approverIds" multiple id="approverIds">'+ loadJSONArrForDropDown('mail', 'approverIds', processDetail.approverIds) +'</select><br><br>' +
											    '<span style="font-size:12px">Supervisor Ids</span><br>' +
											    '<select name = "<portlet:namespace />supervisorRoleIds" multiple id="supervisorRoleIds">'+ loadJSONArrForDropDown('mail', 'supervisorRoleIds', processDetail.supervisorRoleIds) +'</select><br><br>' +
											    '<span style="font-size:12px">Schedule</span><br>' +
											    '<select name = "<portlet:namespace />scheduleOptions" id="scheduleOptions">'+ loadSchedules(processDetail.scheduleModelId) +'</select><br><br>' +
											    '<input type="checkbox" ' + enableSingleSubmission + ' name = "<portlet:namespace />enableSingleSubmission">Enable Single Submission<br><br>' +
											    '<span style="font-size:12px">Single Submission Error Message</span><br>' +
											    '<textarea rows = "3" name = "<portlet:namespace />singleSubmissionErrorMsg">' + processDetail.singleSubmissionErrorMsg + '</textarea><br><br>'+
											    '<span style="font-size:12px">Orientation</span><br>' +
											    '<select name = "<portlet:namespace />orientation" id="orientation"><option value="top" '+topOrientationSelected+'>Top</option><option value="left" '+leftOrientationSelected+'>Left</option></select><br><br>' +
											    '<input type="checkbox" ' + showHeader + ' name = "<portlet:namespace />showHeader">Show Process Header<br><br>' +
											    '<input type="checkbox" ' + enableFirstStepProgress + ' name = "<portlet:namespace />enableFirstStepProgress">Show Progress on Intial Step' +
											    '</div>'+
											    '<div class="column" style="margin:20px; font-size:11pt;">'+
											    '<span style="font-size:12px">Applicant RoleId</span><br>' +
											    '<select name = "<portlet:namespace />applicantRoleId" id="applicantRoleId">'+ loadJSONArrForDropDown('mail', 'applicantRoleId', processDetail.applicantRoleId) +'</select><br><br>' +
											    '<span style="font-size:12px">Agent Page Name</span><br>' +
											    '<input name = "<portlet:namespace />agentPageName" id="agentPageName" value="'+ processDetail.agentPageName +'" type="text"><br><br>' +
											    '<span style="font-size:12px">Approver Page Name</span><br>' +
											    '<input name = "<portlet:namespace />approverPageName" id="approverPageName" value="'+ processDetail.approverPagaeName +'" type="text"><br><br>' +
											    '<span style="font-size:12px">Supervisor Page Name</span><br>' +
											    '<input name = "<portlet:namespace />supervisorPageName" id="supervisorPageName" value="'+ processDetail.supervisorPageName +'" type="text"><br><br>' +
											    '<span style="font-size:12px">User Page Name</span><br>' +
											    '<input name = "<portlet:namespace />userPageName" id="userPageName" value="'+ processDetail.userPageName +'" type="text"><br><br>' +
											    '<span style="font-size:12px">Entity Title</span><br>' +
											    '<input name = "<portlet:namespace />entityTitle" id="entityTitle" value="'+ processDetail.entityTitle +'" type="text"><br><br>' +
											    '<span style="font-size:12px">Closed Lost Reason Vocabulary</span><br>' +
											    '<select name = "<portlet:namespace />closedReasonVocId" id="closedReasonVocId">'+ loadJSONArrForDropDown('vocabulary', 'closedReasonVocId', processDetail.closedReasonVocId) +'</select><br><br>' +
											    '<input type="checkbox" ' + enableEmail + ' name = "<portlet:namespace />accountCreationEmailEnabled">Account Creation Email Enabled<br><br>' +
											    '<input type="checkbox" ' + enableAssignment + ' name = "<portlet:namespace />enableAssignment">Enable Assignment<br><br>' +
											    '<input type="checkbox" ' + editFeeDetails + ' name = "<portlet:namespace />editFeeDetails">Edit Fee Details<br><br>' +
											    '<span style="font-size:12px">Sub Product Type</span><br>' +
											    '<select name = "<portlet:namespace />subProductTypeId" id="subProductTypeId"> '+ loadSubProductType(processDetail.subProductTypeId) +'</select><br><br>' +	
											    '<span style="font-size:12px">Product Type</span><br>' +
											    '<input name = "<portlet:namespace />productTypeId" type="hidden" id="productTypeId">' +
											    '<input name = "<portlet:namespace />productType" disabled id="productType" onload="'+ loadProductType(processDetail.subProductTypeId) +'" type="text"><br><br>' +									  
											    '</div>'+
											'</form>',
								centered : true,
								//cache: false,
								destroyOnClose : true,
								destroyOnHide : true,
								height : 550,
								width : 725,
								stack : true,
								modal : false,
								constrain2view : true,
								toolbars : {
									footer : [ {label : 'Open Diagram', on : { click : function() {updateTable(processDetail.processId, processDetail.processName);}}},
									           {label : 'Cancel', on : { click : function() {dialog.hide();}}},
									           {label : 'Save', on : {click : function() {updateProcess(processDetail.processId, dialog);}}},
									           {label : 'Copy', on : {click : function() {copyProcess(processDetail.processId, dialog);}}}
											 ]
									}
							}
						})
				hideVar = dialog;
				dialog.render();
	
			});
	}
	
	function editStatusType(statusTypeDetail) {
		AUI()
			.use(
				'aui-node',
				'aui-base',
				'aui-dialog',
				'liferay-util-window',
				'aui-overlay-manager-deprecated',
				'dd-constrain',
				'aui-aria',
	
				function(A) {
					titleMsg = "Status Type";
					var dialog = Liferay.Util.Window
						.getWindow({
							title : titleMsg,
							dialog : {
								bodyContent : '<form id = "editStatusTypeFormId" action="">'+
												'<span style="font-size:12px">Process list</span><br>'+
												'<select name = "<portlet:namespace />processNameOptions" id="processNameOptions">'+ loadProcessList('processNameOptions', statusTypeDetail.statusTypeProcessId) +'</select><br>'+
												'<span style="font-size:12px">Status name</span>' +
												'<input name = "<portlet:namespace />statusName" id="statusName" type="text" value='+statusTypeDetail.statusTypeName+'><br>' +
												'<span style="font-size:12px">Sequence Number</span><br>' +
												'<input name = "<portlet:namespace />sequenceNo" id="sequenceNo" type="number" value='+statusTypeDetail.statusTypeSeqNo+'><br>' +
											    '<span style="font-size:12px">Process Stage</span><br>' +
											    '<select name = "<portlet:namespace />processStage" id="processStage">'+ loadJSONArrForDropDown('stage', 'processStage',statusTypeDetail.statusTypeStageId) +'</select><br>' +
											'</form>',
								centered : true,
								//cache: false,
								destroyOnClose : true,
								destroyOnHide : true,
								height : 500,
								width : 400,
								stack : true,
								modal : false,
								constrain2view : true,
								toolbars : {
									footer : [ {label : 'Cancel', on : { click : function() {dialog.hide();}}},
									           {label : 'Save', on : {click : function() {updateStatusType(statusTypeDetail.statusTypeId, dialog);}}}
											 ]
									}
							}
						})
				hideVar = dialog;
				dialog.render();
	
			});
	}

	function updateProcess(processId, dialog) {
		
		if (document.getElementById('subProductTypeId').value == null || document.getElementById('subProductTypeId').value == "0"){
			alert('Please select Sub Product Type');
		} else {
	
			AUI().use('aui.io.request', function(A) {
				A.io.request('${editProcessURL}', {
					method : 'post',
		
					data : {
						<portlet:namespace />processId : processId
					},
		
					form : {
						id : 'editProcessFormId',
					},
		
					on : {
						success : function() {
							updateTableData('process');
							alert('Process updated succesfully...');
							dialog.hide();
						}
					}
				});
			});
		}
	}
	
	
	function copyProcess(processId, dialog) {
		
		AUI().use('aui.io.request', function(A) {
			A.io.request('${copyProcessURL}', {
				method : 'post',
	
				data : {
					<portlet:namespace />processId : processId
				},
	
				form : {
					id : 'editProcessFormId',
				},
	
				on : {
					success : function() {
						updateTableData('process');
						alert('Process copied succesfully...');
						dialog.hide();
					}
				}
			});
		});
	}
	
	function updateStatusType(statusTypeId, dialog) {
		
		AUI().use('aui.io.request', function(A) {
			A.io.request('${editStatusTypeURL}', {
				method : 'post',
	
				data : {
					<portlet:namespace />statusTypeId : statusTypeId
				},
	
				form : {
					id : 'editStatusTypeFormId',
				},
	
				on : {
					success : function() {
						updateTableData('statusType');
						alert('Process Status Type updated succesfully...');
						dialog.hide();
					}
				}
			});
		});
	}
	
	function displayRulePopup() {
		AUI()
			.use(
				'aui-node',
				'aui-base',
				'aui-dialog',
				'liferay-util-window',
				'aui-overlay-manager-deprecated',
				'dd-constrain',
				'aui-aria',
	
				function(A) {
					titleMsg = "Process Details";
					var dialog = Liferay.Util.Window
						.getWindow({
							title : titleMsg,
							dialog : {
								bodyContent : '<form id = "processName" action="">'+
												'<div class="column" style="margin:20px;  font-size:11pt;">'+
												'<span style="font-size:12px">Name of Process</span><br>'+
												'<input id="processNameId"  type = "text" name = "<portlet:namespace />processName" /><br><br>'+
												'<span style="font-size:12px">Entity Class</span><br>' +
												'<select name = "<portlet:namespace />processEntityClassOptions" id="processEntityClassOptions">'+ loadEntities() +'</select><br><br>' +
												'<span style="font-size:12px">Agent Role Ids</span><br>' +
											    '<select name = "<portlet:namespace />agentRoleIds" multiple id="agentRoleIds">'+ loadJSONArrForDropDown('mail', 'agentRoleIds') +'</select><br><br>' +
											    '<span style="font-size:12px">Approver Ids</span><br>' +
											    '<select name = "<portlet:namespace />approverIds" multiple id="approverIds">'+ loadJSONArrForDropDown('mail', 'approverIds') +'</select><br><br>' +
											    '<span style="font-size:12px">Supervisor Ids</span><br>' +
											    '<select name = "<portlet:namespace />supervisorRoleIds" multiple id="supervisorRoleIds">'+ loadJSONArrForDropDown('mail', 'supervisorRoleIds') +'</select><br><br>' +
											    '<span style="font-size:12px">Schedule</span><br>' +
											    '<select name = "<portlet:namespace />scheduleOptions" id="scheduleOptions">'+ loadSchedules() +'</select><br><br>' +   
											    '<input id = "enableSingleSubmission" type="checkbox" name = "<portlet:namespace />enableSingleSubmission">Enable Single Submission<br><br>' +
											    '<span style="font-size:12px">Single Submission Error Message</span><br>' +
											    '<textarea rows = "3" name = "<portlet:namespace />singleSubmissionErrorMsg" id="singleSubmissionErrorMsg"></textarea><br><br>'+
											    '<span style="font-size:12px">Orientation</span><br>' +
											    '<select name = "<portlet:namespace />orientation" id="orientation"><option value="top">Top</option><option value="left">Left</option></select><br><br>' +
											    '<input type="checkbox" name = "<portlet:namespace />showHeader">Show Process Header<br><br>' +
											    '<input type="checkbox" name = "<portlet:namespace />enableFirstStepProgress">Show Progress on Intial Step' +
											    '</div>'+
											    '<div class="column" style="margin:20px;  font-size:11pt;">'+
											    '<span style="font-size:12px">Applicant RoleId</span><br>' +
											    '<select name = "<portlet:namespace />applicantRoleId" id="applicantRoleId">'+ loadJSONArrForDropDown('mail', 'applicantRoleId') +'</select><br><br>' +
											    '<span style="font-size:12px">Agent Page Name</span><br>' +
											    '<input name = "<portlet:namespace />agentPageName" id="agentPageName" type="text"><br><br>' +
											    '<span style="font-size:12px">Approver Page Name</span><br>' +
											    '<input name = "<portlet:namespace />approverPageName" id="approverPageName" type="text"><br><br>' +
											    '<span style="font-size:12px">Supervisor Page Name</span><br>' +
											    '<input name = "<portlet:namespace />supervisorPageName" id="supervisorPageName" type="text"><br><br>' +
											    '<span style="font-size:12px">User Page Name</span><br>' +
											    '<input name = "<portlet:namespace />userPageName" id="userPageName" type="text"><br><br>' +
											    '<span style="font-size:12px">Entity Title</span><br>' +
											    '<input name = "<portlet:namespace />entityTitle" id="entityTitle" type="text"><br><br>' +
											    '<span style="font-size:12px">Closed Lost Reason Vocabulary</span><br>' +
											    '<select name = "<portlet:namespace />closedReasonVocId" id="closedReasonVocId">'+ loadJSONArrForDropDown('vocabulary', 'closedReasonVocId') +'</select><br><br>' +
												'<input id = "accountCreationEmailEnabled" type="checkbox" name = "<portlet:namespace />accountCreationEmailEnabled">Account Creation Email Enabled<br><br>' +
												'<input id = "enableAssignment" type="checkbox" name = "<portlet:namespace />enableAssignment">Enable Assignment<br><br>' +
												'<input id = "editFeeDetails" type="checkbox" name = "<portlet:namespace />editFeeDetails">Edit Fee Details<br><br>' +
												'<span style="font-size:12px">Sub Product Type</span><br>' +
											    '<select name = "<portlet:namespace />subProductTypeId" id="subProductTypeId"> '+ loadSubProductType() +'</select><br><br>' +	
											    '<span style="font-size:12px">Product Type</span><br>' +
											    '<input name = "<portlet:namespace />productTypeId" type="hidden" id="productTypeId">' +
											    '<input name = "<portlet:namespace />productType" disabled id="productType" type="text"><br><br>' +									  
												'</div>'+
											'</form>',
								centered : true,
								//cache: false,
								destroyOnClose : true,
								destroyOnHide : true,
								height : 550,
								width : 725,
								stack : true,
								modal : false,
								constrain2view : true,
								toolbars : {
									footer : [ {label : 'Cancel', on : { click : function() {dialog.hide();document.getElementById('selectAddType').selectedIndex = 0;}}},
									           {label : 'Save', on : {click : function() {addProcessSetAjax();}}}
											 ]
									}
							}
						})
				hideVar = dialog;
				dialog.render();
	
			});
	}
	
	function displayStatusPopup() {
		AUI()
			.use(
				'aui-node',
				'aui-base',
				'aui-dialog',
				'liferay-util-window',
				'aui-overlay-manager-deprecated',
				'dd-constrain',
				'aui-aria',
	
				function(A) {
					titleMsg = "Status Type";
					var dialog = Liferay.Util.Window
						.getWindow({
							title : titleMsg,
							dialog : {
								bodyContent : '<form id = "statusType" action="">'+
												'<span style="font-size:12px">Process list</span><br>'+
												'<select name = "<portlet:namespace />processNameOptions" id="processNameOptions">'+ loadProcessList('processNameOptions') +'</select><br>'+
												'<span style="font-size:12px">Status name</span>' +
												'<input name = "<portlet:namespace />statusName" id="statusName" type="text"><br>' +
												'<span style="font-size:12px">Sequence Number</span><br>' +
												'<input name = "<portlet:namespace />sequenceNo" id="sequenceNo" type="number"><br>' +
											    '<span style="font-size:12px">Process Stage</span><br>' +
											    '<select name = "<portlet:namespace />processStage" id="processStage">'+ loadJSONArrForDropDown('stage', 'processStage') +'</select><br>' +
											'</form>',
								centered : true,
								//cache: false,
								destroyOnClose : true,
								destroyOnHide : true,
								height : 500,
								width : 400,
								stack : true,
								modal : false,
								constrain2view : true,
								toolbars : {
									footer : [ {label : 'Cancel', on : { click : function() {dialog.hide();document.getElementById('selectAddType').selectedIndex = 0;}}},
									           {label : 'Save', on : {click : function() {addStatusTypeAjax(dialog);}}}
											 ]
									}
							}
						})
				hideVar = dialog;
				dialog.render();
	
			});
	}
	
	function loadEntities(enityClassId) {
	
		AUI().use('aui.io.request', function(A) {A.io.request('${retriveEntitiesURL}', {
				method : 'get',
	
				on : {
						success : function() {
	
							var entityNameIdMap = JSON.parse(this.get('responseData')).entities;
							//if (entityNameIdMap === undefined || entityNameIdMap == null || entityNameIdMap.length <= 0)
							if(!entityNameIdMap)
								return;
		
							var out = "<option value='' selected>Select Entity</option>";
							for (var key in entityNameIdMap)
								(key == enityClassId) ? out += '<option value="' + key + '" selected>' + entityNameIdMap[key] + '</option>': out += '<option value="' + key + '">' + entityNameIdMap[key] + '</option>';
		
							document.getElementById('processEntityClassOptions').innerHTML = out;
						}
					}
			});});
	}
	
	function loadSchedules(enityClassId) {
		
		AUI().use('aui.io.request', function(A) {A.io.request('${retriveSchedulesURL}', {
				method : 'get',
	
				on : {
						success : function() {
	
							var entityNameIdMap = JSON.parse(this.get('responseData')).schedules;
							//if (entityNameIdMap === undefined || entityNameIdMap == null || entityNameIdMap.length <= 0)
							if(!entityNameIdMap)
								return;
		
							var out = "<option value='' selected>Select Schedule</option>";
							for (var key in entityNameIdMap)
								(key == enityClassId) ? out += '<option value="' + key + '" selected>' + entityNameIdMap[key] + '</option>': out += '<option value="' + key + '">' + entityNameIdMap[key] + '</option>';
		
							document.getElementById('scheduleOptions').innerHTML = out;
						}
					}
			});});
	}
	
	function loadSubProductType(enityClassId) {
		
		AUI().use('aui.io.request', function(A) {A.io.request('${retriveSubProductTypeURL}', {
				method : 'get',
	
				on : {
						success : function() {
	
							var entityNameIdMap = JSON.parse(this.get('responseData')).subProductType;
							//if (entityNameIdMap === undefined || entityNameIdMap == null || entityNameIdMap.length <= 0)
							if(!entityNameIdMap)
								return;
		
							var out = "<option value='0' selected>Select Sub Product Type</option>";
							for (var key in entityNameIdMap)
								(key == enityClassId) ? out += '<option value="' + key + '" selected>' + entityNameIdMap[key] + '</option>': out += '<option value="' + key + '">' + entityNameIdMap[key] + '</option>';
		
							document.getElementById('subProductTypeId').innerHTML = out;
							document.getElementById('subProductTypeId').setAttribute("onchange","loadProductType(this.value)");
						}
					}
			});});
	}
	
	
	function loadProductType(subProductTypeId) {
		
		AUI().use('aui.io.request', function(A) {A.io.request('${retriveProductTypeURL}', {method : 'get', data : {<portlet:namespace />subProductTypeId : subProductTypeId},
	
				on : {
						success : function() {
	
								var entityNameIdMap = JSON.parse(this.get('responseData')).productType;
								for (var key in entityNameIdMap){
									document.getElementById('productTypeId').value = key;
									document.getElementById('productType').value = entityNameIdMap[key];
								}
						}
					}
			});});
	}
	
	function loadProcessList(selectBox,processId) {
		
		AUI().use('aui.io.request', function(A) {A.io.request('${retriveProcessURL}', {
				method : 'get',
	
				on : {
						success : function() {
	
							var processNameIdMap = JSON.parse(this.get('responseData')).processes;
							if(!processNameIdMap)
								return;
		
							var out = "<option value='' selected>Select Process</option>";
							for (var key in processNameIdMap)
								 (key == processId) ? out += '<option value="' + key + '" selected>' + processNameIdMap[key] + '</option>': out += '<option value="' + key + '">' + processNameIdMap[key] + '</option>';
		
							document.getElementById(selectBox).innerHTML = out;
						}
					}
			});});
	}
	
	function loadJSONArrForDropDown(componentType, dropDownSectionId, ids) {
		
		AUI().use('aui.io.request', function(A) {A.io.request('${retriveDownListURL}', {
				method : 'get',
					data : {
							 <portlet:namespace />componentType : componentType,
					},
				on : {
					success : function() {
						var dropDownOptionsJSONArr = JSON.parse(this.get('responseData')).model_popup_dropdown_json;
						var list;
						if(componentType==='mail'){
							list = dropDownOptionsJSONArr.roles || [], out = null;
							var out = "<option value='0'>Select Role/Roles</option>", isSelectet = false;
						}
						else if(componentType==='vocabulary'){
							list = dropDownOptionsJSONArr.vocabulary || [], out = null;
							var out = "<option value='0'>Select Vocabulary</option>", isSelectet = false;
						}
						else if(componentType==='stage'){
							list = dropDownOptionsJSONArr.stages || [], out = null;
							var out = "<option value='0'>Select stages</option>", isSelectet = false;
						}
						
						for (var indx = 0; indx < list.length; indx++)
							out += '<option value="' + list[indx].id + '">' + list[indx].name + '</option>';	
						
						var dropDownElement = document.getElementById(dropDownSectionId);
						dropDownElement.innerHTML = out;
						
						setSelectedIndex(document.getElementById(dropDownSectionId),(ids+"").split(','));
						
					}
					}
				});
			});
	}
	
	function addProcessSetAjax() {
	
		if (document.getElementById('subProductTypeId').value == null || document.getElementById('subProductTypeId').value == "0"){
			alert('Please select Sub Product Type');
		} else {
			AUI().use('aui.io.request', function(A) {
				A.io.request('${processResourceURL}', {
					method : 'post',
					form : {
						id : 'processName'
					},
		
					on : {
						success : function() {
		
							var pageToRender = "/html/pb/designwizard.jsp";
							var newProcessID = JSON.parse(this.get('responseData')).processID;
							var processName = document.getElementById('processNameId').value;
							var isUpdate = false;
							rederToURL(pageToRender, newProcessID, isUpdate, processName);
						}
					}
				});
			});
		}
	}
	
	function addStatusTypeAjax(dialog) {
		
		AUI().use('aui.io.request', function(A) {
			A.io.request('${processStatusTypeResourceURL}', {
				method : 'post',
				form : {
					id : 'statusType'
				},
	
				on : {
					success : function() {
						alert('Process Status Type added succesfully...');
						updateTableData('statusType');
						dialog.hide();
						document.getElementById('selectAddType').selectedIndex = 0;
					}
				}
			});
		});
	}
	
	function rederToURL(pageToRender, processId, isUpdate, processName) {
	    AUI().use('liferay-portlet-url',
	            function(A) {
	   				var renderURL = Liferay.PortletURL.createRenderURL();
	   				renderURL.setParameter("mvcPath", pageToRender);
	   				renderURL.setParameter("processId", processId);
	   				renderURL.setParameter("isUpdate",isUpdate);
	   				renderURL.setParameter("processName", processName);
	   				renderURL.setPortletId("processbuilderaction_WAR_SPProcessEngineportlet");
	   				renderURL.setWindowState("<%= LiferayWindowState.NORMAL.toString() %>");
	   				window.location.href = renderURL.toString();
	           }
	   );
	}
	
	function setSelectedIndex(s, v) {

		if (v == undefined)return;

		if (s == undefined)return;

		if (v.constructor === Array){//for multiselect
			for ( var i = 0; i < s.options.length; i++ )
		        if (v.includes(s.options[i].value.trim()))
		            s.options[i].selected = true;
		}

		else {
			for ( var i = 0; i < s.options.length; i++ )
		        if (v === s.options[i].value.trim()) {
		        	s.options[i].selected = true;
		        	return;
		        }
		}
	}

</script>
