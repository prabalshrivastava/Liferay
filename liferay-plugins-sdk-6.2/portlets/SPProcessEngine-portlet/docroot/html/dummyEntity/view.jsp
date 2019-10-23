<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

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

<portlet:defineObjects />

<!-- Resource URL for AJAX -->
<portlet:resourceURL id = "addNewDummyEntity" var="dummyEntityResourceURL"></portlet:resourceURL>
<portlet:resourceURL id = "editDummyEntity" var="editDummyEntityURL"></portlet:resourceURL>
<portlet:resourceURL id = "retrieveTableData" var="retrieveTableDataDetailURL"></portlet:resourceURL>
<portlet:resourceURL id = "retriveDummyEntityDetail" var="retriveDummyEntityDetailURL"></portlet:resourceURL>
<portlet:resourceURL id = "searchDummyEntity" var="searchDummyEntityURL"></portlet:resourceURL>



<div class="enrollmentContainer screen-max-width ">
<div class="enrollmentRow margin-top-40">

<div class="mainContentContainer roundedborder">

			<div class="SearchBar-Container height82">
				<div class="Searchdiv Span-width-30">
					<div class=" Icon-Search ">
						<img
							src="/SPProcessEngine-portlet/images/ios-search-ion-icons.png" onclick="searchCriteriaChange()"
							alt="Search">
					</div>
					<input id="searchText" name="searchText" placeholder="search" onkeypress="initialiseSearch(event)"
						type="text" value="" />
				</div>
				<div class="btn-process">
					<a id="createNew" href="#" onclick="displayDummyEntityPopup()">Add Entity</a>

				</div>
			</div>

			<div id = "tableId" class="Table-Layout">

	<div class="Heading">
		<div class="Cell Span-width-5">
			<p>ID</p>
		</div>
		<div class="Cell Span-width-40">
			<p>Entity Name</p>
		</div>
		<div class="Cell Span-width-10">
			<p>Date Created</p>
		</div>
		 <div class="Cell">
			<p>Edit</p>
		</div>
	</div>

	<c:forEach items="${listOfDummyEntities}" var="dummyEntityList">
	<div class="Row">
		 	<div class="Cell Span-width-5">
				<p >${dummyEntityList.spPEDummyEntityId}</p>
		  	</div>

		  	<div class="Cell Span-width-40">
				<p>${dummyEntityList.name}</p>
		  	</div>

			<div class="Cell Span-width-10">
			
			<c:set var="tempCreateDate"
							value="${dummyEntityList.createDate }" />
			<%
				Date date = (Date)pageContext.getAttribute("tempCreateDate");
				String dateStr = PEHelper.getDateStrddMMYYYYHMS(date);
			%>
				<p><%=dateStr %></p>
			</div>

			<div class="Cell">
				<span class="Icon-right-border" style="width: 40%;" id="updateTable1" onclick="setDummyEntityDetail(${dummyEntityList.spPEDummyEntityId})">
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
	
	function initialiseSearch(event){
		
		if(event.keyCode ==  13){
			searchCriteriaChange();
		}
	}
	
	function searchCriteriaChange(){
		
		var searchText = document.getElementById("searchText").value;
		
		AUI().use('aui.io.request', function(A) {A.io.request('${searchDummyEntityURL}', {
			method : 'get', 
			data : {<portlet:namespace />searchText : searchText},
			on : {
				success : 
					function() {
						tableData = JSON.parse(this.get('responseData')).dummyEntities;
						reloadTable(tableData);
					}
			}
		});});
	}
	
	function setDummyEntityDetail(dummyEntityId) {
		
		AUI().use('aui.io.request', function(A) {A.io.request('${retriveDummyEntityDetailURL}', {
			method : 'get', 
			data : {<portlet:namespace />dummyEntityId : dummyEntityId},
			on : {
				success : 
					function() {
							var dummyEntityDetail = JSON.parse(this.get('responseData')).dummyEntityDetail;
							editDummyEntity(dummyEntityDetail);
					}
			}
		});});
	}
	

	function updateTableData(requestType){
		AUI().use('aui.io.request', function(A) {A.io.request('${retrieveTableDataDetailURL}', {
			method : 'get', 
			data : {<portlet:namespace />requestedData : requestType},
			on : {success : 
					function() {
						if(this.get('responseData')){
							switch(requestType){
								case 'dummyEntity':
									tableData = JSON.parse(this.get('responseData')).dummyEntities;
									reloadTable(tableData);
									break;
							}
						}
					}
				}
		});});
	}
	
	function reloadTable(tableData){
		var tableDiv = document.getElementById('tableId');
		var headingChildrenDivs = document.querySelectorAll('#tableId .Heading div');
		var tableRowDivClone = document.querySelector('#tableId .Row').cloneNode(true);
		
		var dummyEntityTableHeadings = ["ID","Entity Name","Date Created","Actions"];
		
		
			for(var idx=0;idx<headingChildrenDivs.length;idx++){
				headingChildrenDivs[idx].querySelector('p').innerHTML = dummyEntityTableHeadings[idx];
			}
			 
			clearTableData();
			
			var clonedNodeDivs;
			for(var inx=0;inx<tableData.length;inx++){
				var newRow = tableRowDivClone.cloneNode(true);
				clonedNodeDivs = newRow.querySelectorAll('div');
				
				clonedNodeDivs[0].querySelector('p').innerHTML = tableData[inx].dummyEntityId;
				clonedNodeDivs[1].querySelector('p').innerHTML = tableData[inx].dummyEntityName;
				clonedNodeDivs[2].querySelector('p').innerHTML = tableData[inx].dummyEntityDateCreated ? tableData[inx].dummyEntityDateCreated : '...';
				clonedNodeDivs[3].querySelector('span').setAttribute('onclick','setDummyEntityDetail('+tableData[inx].dummyEntityId+')');
				
				tableDiv.appendChild(newRow);
			}
			
			
		}
	
	
	function clearTableData(){
		//clear table contents 
		var elements=document.getElementById('tableId').getElementsByClassName('Row');
		   while(elements.length){
		       elements[0].parentNode.removeChild(elements[0]);
		}
	}

	
	function setDummyEntityDetail(dummyEntityId) {
		
		AUI().use('aui.io.request', function(A) {A.io.request('${retriveDummyEntityDetailURL}', {
			method : 'get', 
			data : {<portlet:namespace />dummyEntityId : dummyEntityId},
			on : {
				success : 
					function() {
							var dummyEntityDetail = JSON.parse(this.get('responseData')).dummyEntityDetail;
							editDummyEntity(dummyEntityDetail);
					}
			}
		});});
	}
	
	function editDummyEntity(dummyEntityDetail) {
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
					titleMsg = "Entity";
					var dialog = Liferay.Util.Window
						.getWindow({
							title : titleMsg,
							dialog : {
								bodyContent : '<form id = "editDummyEntityFormId" action="">'+
												'<span style="font-size:12px">Entity Id</span><br>' +
												'<input name = "<portlet:namespace />dummyEntityId" id="dummyEntityId" type="number" value="' + dummyEntityDetail.dummyEntityId + '" readonly="readonly"><br>' +
												'<span style="font-size:12px">Entity Name</span>' +
												'<input name = "<portlet:namespace />dummyEntityName" class="Requiredfield" onchange="validateReq(this)" id="dummyEntityName" type="text" value="' + dummyEntityDetail.dummyEntityName + '">' +
												'<p id="dummyEntityNameErrorDiv" class="hide"></p><br>'+
											'</form>',
								centered : true,
								//cache: false,
								destroyOnClose : true,
								destroyOnHide : true,
								height : 350,
								width : 400,
								stack : true,
								modal : false,
								constrain2view : true,
								toolbars : {
									footer : [ {label : 'Cancel', on : { click : function() {dialog.hide();}}},
									           {label : 'Save', on : {click : function() {updateDummyEntity(dummyEntityDetail.dummyEntityId, dialog);}}}
											 ]
									}
							}
						})
				hideVar = dialog;
				dialog.render();
	
			});
	}
	
	function updateDummyEntity(dummyEntityId, dialog) {
		
		
		AUI().use('aui.io.request','aui-node', function(A) {
			var node = A.one("#dummyEntityName");
			var validationResult = validateRequiredFieldDummyEntity(node);
			if(!validationResult){
			A.io.request('${editDummyEntityURL}', {
				method : 'post',
	
				data : {
					<portlet:namespace />dummyEntityId : dummyEntityId
				},
	
				form : {
					id : 'editDummyEntityFormId',
				},
	
				on : {
					success : function() {
						var duplicate = JSON.parse(this.get('responseData')).duplicateFlag;
						if(duplicate == false){
						updateTableData('dummyEntity');
						alert('Entity updated succesfully.');
						dialog.hide();
						}
						else{
							alert('Another Entity exists with same name. Please provide unique name.');	
						}
					}
				}
			});
			}
		});
		}
	
	
	
	function displayDummyEntityPopup() {
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
					titleMsg = "Entity";
					var dialog = Liferay.Util.Window
						.getWindow({
							title : titleMsg,
							dialog : {
								bodyContent : '<form id = "dummyEntity" action="">'+
												'<span style="font-size:12px">Entity Name</span>' +
												'<input name = "<portlet:namespace />dummyEntityName" class="Requiredfield" onchange="validateReq(this)" id="dummyEntityName" type="text" required >' +
												'<p id="dummyEntityNameErrorDiv" class="hide"></p><br>'+
											'</form>',
								centered : true,
								//cache: false,
								destroyOnClose : true,
								destroyOnHide : true,
								height : 300,
								width : 400,
								stack : true,
								modal : false,
								constrain2view : true,
								toolbars : {
									footer : [ {label : 'Cancel', on : { click : function() {dialog.hide();}}},
									           {label : 'Add', on : {click : function() {addDummyEntityAjax(dialog);}}}
											 ]
									}
							}
						})
				hideVar = dialog;
				dialog.render();
	
			});
	}
	

	function addDummyEntityAjax(dialog) {
		
		AUI().use('aui.io.request', function(A) {
			var node = A.one("#dummyEntityName");
			var validationResult = validateRequiredFieldDummyEntity(node);
			if(!validationResult){
			A.io.request('${dummyEntityResourceURL}', {
				method : 'post',
				form : {
					id : 'dummyEntity'
				},
	
				on : {
					success : function() {
						var duplicate = JSON.parse(this.get('responseData')).duplicateFlag;
						if(duplicate == false){
							alert('Entity added succesfully.');
							updateTableData('dummyEntity');
							dialog.hide();
						}
						else{
							alert('Another Entity exists with same name. Please provide unique name.');	
						}
					}
				}
			});
			}
		});
	}
	
	function validateReq(domNode){
		AUI().use('aui-node',function(A) {
		var node = A.one("#" + domNode.id);
		var cn = node.getAttribute("class");
			if(cn.includes("Requiredfield")){
				validateRequiredFieldDummyEntity(node);
			}
	});
	}


	function validateRequiredFieldDummyEntity(node){
		var validationResult;
		AUI().use('aui-node',function(A) {
			var value = node.val();
			var errorDivId = node.get("id") + "ErrorDiv";
			var errorDiv = A.one("#" + errorDivId);
			if(value.length == 0){
				errorDiv.html('<p class="portlet-msg-error">Please fill out this field</p>');
				errorDiv.removeClass("hide");
				validationResult = true;
			}
			else{
				errorDiv.html("");
				errorDiv.addClass("hide");
				validationResult = false;
			}
			});
		return validationResult;
	}


	

</script>

