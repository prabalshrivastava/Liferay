
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>

	<script type="text/javascript">
	function <portlet:namespace />addNewField(){
		var xslOpt = document.getElementById('<portlet:namespace />-xsl-options');
		var newdiv=document.createElement("div");
		newdiv.setAttribute("id","<portlet:namespace />-xsl-options-details");
		newdiv.setAttribute("class","userprofile-edit-fieldset-details");
		newdiv.innerHTML='<span>Enter new field name: </span><input type="text" name="newFieldInput" id="<portlet:namespace />newFieldInput" value="" size="20" /><a title="Delete" href="javascript:<portlet:namespace />removeNewField()" class="book userprofile-delete-link">&nbsp;</a>';
		xslOpt.appendChild(newdiv);
		document.getElementById('<portlet:namespace />btnAddField').style.display="none";
		document.getElementById('<portlet:namespace />btnAddNewForm').style.display="none";
	}
	
	function <portlet:namespace />removeNewField(){
		removeElement('<portlet:namespace />-xsl-options-details');
		document.getElementById('<portlet:namespace />btnAddField').style.display="inline";
		document.getElementById('<portlet:namespace />btnAddNewForm').style.display="inline";
	}

	function <portlet:namespace />showEditFields(id){
		var divEdit = document.getElementById('<portlet:namespace />-'+id+'-edit-collapsed');
		divEdit.style.display = 'block';
		
		var showEdit = document.getElementById('<portlet:namespace />-'+id+'-show-edit-link');
		var hideEdit = document.getElementById('<portlet:namespace />-'+id+'-hide-edit-link');
		showEdit.style.display = 'none';
		hideEdit.style.display = 'inline';
	}
	function <portlet:namespace />hideEditFields(id){
		var divEdit = document.getElementById('<portlet:namespace />-'+id+'-edit-collapsed');
		divEdit.style.display = 'none';

		var showEdit = document.getElementById('<portlet:namespace />-'+id+'-show-edit-link');
		var hideEdit = document.getElementById('<portlet:namespace />-'+id+'-hide-edit-link');
		showEdit.style.display = 'inline';
		hideEdit.style.display = 'none';
	}

	function <portlet:namespace />showHideByXslName() {

		var selectObj = document.getElementById("<portlet:namespace />xslSelect");

		var options = selectObj.options;
		var selectedIndex = selectObj.selectedIndex;
		for(var i=0; i<options.length; i++) {
			var optVal = options[i].value;
			if(document.getElementById("<portlet:namespace />" + optVal)) {
				if(document.getElementById("<portlet:namespace />" + optVal).style.display != "none") {
					document.getElementById("<portlet:namespace />" + optVal).style.display = "none";
					document.getElementById("<portlet:namespace />btnAddField").style.display = "none";
					document.getElementById("<portlet:namespace />editFormSubmit").style.display = "none";
					document.getElementById("<portlet:namespace />btnAddNewForm").style.display = "inline";
				}
			}
		}

		var selectedXslName = options[selectedIndex].value;

		if(document.getElementById("<portlet:namespace />" + selectedXslName)) {
			document.getElementById("<portlet:namespace />" + selectedXslName).style.display = "block";
			document.getElementById("<portlet:namespace />btnAddField").style.display = "inline";
			document.getElementById("<portlet:namespace />editFormSubmit").style.display = "inline";
			document.getElementById("<portlet:namespace />btnAddNewForm").style.display = "none";
		}
	}
	
	function <portlet:namespace />checkIndexable(fldName, input){
		
		var checked = input.checked;
		var indexbleFld = document.getElementById(fldName + '-indexable');
		
		if(checked){
			if(indexbleFld){
				indexbleFld.checked = true;
				indexbleFld.disabled = true;
			}
		}else{
			if(indexbleFld){
				indexbleFld.checked = false;
				indexbleFld.disabled = false;
			}
		}
	}
	
	function <portlet:namespace />checkSearchable(fldName, input){
		
		var checked = input.checked;
		var searchableFld = document.getElementById(fldName + '-searchable');
		
		if(!checked){
			searchableFld.checked = false;
		}
	}
	
	function <portlet:namespace />checkDisplay(fldName, input){
		
		var checked = input.checked;
		var privateViewFld = document.getElementById(fldName + '-private');
		
		if(!checked){
			privateViewFld.checked = true;
		}
	}

	function <portlet:namespace />migrateToSocialProfile(){

		var A=AUI();
		var items = null;
		var reqUrl = '<portlet:resourceURL id="" />'+'&type=migrateSocialProfile';

		A.io.request(reqUrl, {
		   cache: false,
		   sync: true,
		   timeout: 1000,
		   dataType: 'json',
		   method: 'get',
		   on: {
			   start:function(){
				clearState('migration');
				//display loading icon
				loadingState('migration');
		 	   },
		       success: function() {
		          items = this.get('responseData');
		          //hide loading icon
				  clearState('migration');
				  successSaveState('migration', "Save Successful");
				  alert('data migration successful!');
		       },
		       failure: function() {
		        	//hide loading icon
					clearState('migration');
					//Show error icon
					errorState('migration',"Unexpected server error occured.");
		       }
		   }
		});
	}
	
	function <portlet:namespace />AddNewForm(){
		var A=AUI();
		A.one("#<portlet:namespace />xslSelect").hide();
		A.one("#<portlet:namespace />-xsl-options").hide();
		//A.one("#<portlet:namespace />-submitButtons").hide();
		//A.one("#<portlet:namespace />FormEdittableDiv").hide();
		
		var xslOpt = document.getElementById('<portlet:namespace />addFormDiv');//document.getElementById('<portlet:namespace />FormEdittableDiv');
		var newdiv=document.createElement("div");
		newdiv.setAttribute("id","<portlet:namespace />-add-new-form-details");
		newdiv.setAttribute("class","userprofile-edit-fieldset-details");
		newdiv.innerHTML='<span>Enter new form name: </span><input type="text" name="newFormNameInput" id="<portlet:namespace />newFormNameInput" value="" size="20" /><a title="Delete" href="javascript:<portlet:namespace />removeNewFormNameInput()" class="book userprofile-delete-link">&nbsp;</a>';
		xslOpt.appendChild(newdiv);
		
		A.one("#<portlet:namespace />btnAddNewForm").setStyle('display','none');
		A.one("#<portlet:namespace />btnAddField").setStyle('display','none');
		A.one("#<portlet:namespace />editFormSubmit").setStyle('display','none');
		A.one("#<portlet:namespace />btnAddFormSubmit").setStyle('display','inline');
	}
	
	function <portlet:namespace />removeNewFormNameInput(){
		var A=AUI();
		A.one("#<portlet:namespace />xslSelect").show();
		A.one("#<portlet:namespace />-xsl-options").show();
		
		removeElement('<portlet:namespace />-add-new-form-details');
		
		A.one("#<portlet:namespace />btnAddNewForm").setStyle('display','inline');
		A.one("#<portlet:namespace />editFormSubmit").setStyle('display','inline');
		A.one("#<portlet:namespace />btnAddFormSubmit").setStyle('display','none');
		
		var selectVal = A.one("#<portlet:namespace />xslSelect").val();
		if(selectVal != ''){
			A.one("#<portlet:namespace />btnAddField").setStyle('display','inline');
			A.one("#<portlet:namespace />editFormSubmit").setStyle('display','inline');
		}else{
			A.one("#<portlet:namespace />btnAddField").setStyle('display','none');
			A.one("#<portlet:namespace />editFormSubmit").setStyle('display','none');
		}
		
	}
	
	/*function <portlet:namespace />addNewField(){
		var xslOpt = document.getElementById('<portlet:namespace />-xsl-options');
		var newdiv=document.createElement("div");
		newdiv.setAttribute("id","<portlet:namespace />-xsl-options-details");
		newdiv.setAttribute("class","userprofile-edit-fieldset-details");
		newdiv.innerHTML='<span>Enter new field name: </span><input type="text" name="newFieldInput" id="<portlet:namespace />newFieldInput" value="" size="20" /><a title="Delete" href="javascript:<portlet:namespace />removeNewField()" class="book userprofile-delete-link">&nbsp;</a>';
		xslOpt.appendChild(newdiv);
		document.getElementById('<portlet:namespace />btnAddField').style.display="none";
	}*/

	function <portlet:namespace />syncAddress(){

		var A=AUI();
		var items = null;

		var selectObj = document.getElementById("<portlet:namespace />xslSelect");
		var options = selectObj.options;
		var selectedIndex = selectObj.selectedIndex;
		var selectedXslName = options[selectedIndex].value;
		var catDetails = "";

		if(selectedXslName == 'shipping_or_billing_address'){
			catDetails = "shipping_or_billing_address_details";
		}

		var reqUrl = '<portlet:resourceURL id="" />'+'&type=updateUserInfoXML&categoryName='+selectedXslName+'&categoryDetails='+catDetails;
		A.io.request(reqUrl, {
		   cache: false,
		   sync: true,
		   timeout: 1000,
		   dataType: 'json',
		   method: 'get',
		   on: {
			   start:function(){
					clearState('migration');
					//display loading icon
					loadingState('migration');
			   },
			   success: function() {
		          items = this.get('responseData');
		          //hide loading icon
				  clearState('migration');
				  successSaveState('migration', "Save Successful");
				  alert('reload XML successful!');
		       },
		       failure: function() {
		        	//hide loading icon
					clearState('migration');
					//Show error icon
					errorState('migration',"Unexpected server error occured.");
		       }
		   }
		});
	}
	
	
	
	
	function <portlet:namespace />reloadUserInfoXML(){

		var A=AUI();
		var items = null;

		var selectObj = document.getElementById("<portlet:namespace />xslSelect");
		var options = selectObj.options;
		var selectedIndex = selectObj.selectedIndex;
		var selectedXslName = options[selectedIndex].value;
		var catDetails = "";

		if(selectedXslName == 'workhistory'){
			catDetails = "work_details";
		}else if(selectedXslName == 'contact_info'){
			catDetails = "contact_details";
		}else if(selectedXslName == 'availability_info'){
			catDetails = "user_availability";
		}else if((selectedXslName == 'personal_info') || (selectedXslName == 'basic_info') || (selectedXslName == 'network_info')){
			catDetails = "";
		}else{	
			catDetails = selectedXslName + "_details";
		}

		var reqUrl = '<portlet:resourceURL id="" />'+'&type=updateUserInfoXML&categoryName='+selectedXslName+'&categoryDetails='+catDetails;
		A.io.request(reqUrl, {
		   cache: false,
		   sync: true,
		   timeout: 1000,
		   dataType: 'json',
		   method: 'get',
		   on: {
			   start:function(){
					clearState('migration');
					//display loading icon
					loadingState('migration');
			   },
			   success: function() {
		          items = this.get('responseData');
		          //hide loading icon
				  clearState('migration');
				  successSaveState('migration', "Save Successful");
				  alert('Reload XML triggered as background job. Processing time will vary based on number of user records!');
		       },
		       failure: function() {
		        	//hide loading icon
					clearState('migration');
					//Show error icon
					errorState('migration',"Unexpected server error occured.");
		       }
		   }
		});
	}
	
	function <portlet:namespace />reloadAllUserInfoXML(){

		var A=AUI();
		var items = null;

		var reqUrl = '<portlet:resourceURL id="" />'+'&type=updateAllUserInfoXML';
		A.io.request(reqUrl, {
		   cache: false,
		   sync: true,
		   timeout: 1000,
		   dataType: 'json',
		   method: 'get',
		   on: {
			   start:function(){
					clearState('migration');
					//display loading icon
					loadingState('migration');
			   },
			   success: function() {
		          items = this.get('responseData');
		          //hide loading icon
				  clearState('migration');
				  successSaveState('migration', "Save Successful");
				  alert('Reload All XML triggered as background job. Processing time will vary based on number of user records!');
		       },
		       failure: function() {
		        	//hide loading icon
					clearState('migration');
					//Show error icon
					errorState('migration',"Unexpected server error occured.");
		       }
		   }
		});
	}
	
	function <portlet:namespace />hideDivs(fieldName, fieldType){
		var divOptionEl = fieldName + '-option-div';
		var divMaxLenEl = fieldName + '-maxlen-div';
		var divValidationEl = fieldName + '-validation-div';
		var divDefaultEl = fieldName + '-default-div';
		
		if(fieldType == 'Dropdown' || fieldType == 'MultipleList'){
			document.getElementById(divOptionEl).style.display = "inline";
			document.getElementById(divMaxLenEl).style.display = "none";
			document.getElementById(divValidationEl).style.display = "none";
			if(document.getElementById(divDefaultEl)){
				document.getElementById(divDefaultEl).style.display = "inline";
			}	
		}else if(fieldType == 'TextField'){
			document.getElementById(divOptionEl).style.display = "none";
			document.getElementById(divMaxLenEl).style.display = "inline";
			document.getElementById(divValidationEl).style.display = "inline";
			if(document.getElementById(divDefaultEl)){
				document.getElementById(divDefaultEl).style.display = "inline";
			}	
		}else if(fieldType == 'TextArea'){
			document.getElementById(divOptionEl).style.display = "none";
			document.getElementById(divMaxLenEl).style.display = "inline";
			document.getElementById(divValidationEl).style.display = "inline";
			if(document.getElementById(divDefaultEl)){
				document.getElementById(divDefaultEl).style.display = "inline";
			}
		}else if(fieldType == 'CKEditor'){
			document.getElementById(divOptionEl).style.display = "none";
			document.getElementById(divMaxLenEl).style.display = "inline";
			document.getElementById(divValidationEl).style.display = "none";
			if(document.getElementById(divDefaultEl)){
				document.getElementById(divDefaultEl).style.display = "inline";
			}	
		}else if(fieldType == 'Radio'){
			document.getElementById(divOptionEl).style.display = "inline";
			document.getElementById(divMaxLenEl).style.display = "none";
			document.getElementById(divValidationEl).style.display = "none";
			if(document.getElementById(divDefaultEl)){
				document.getElementById(divDefaultEl).style.display = "inline";
			}
		}else if(fieldType == 'Calendar'){
			document.getElementById(divOptionEl).style.display = "none";
			document.getElementById(divMaxLenEl).style.display = "none";
			document.getElementById(divValidationEl).style.display = "none";
			if(document.getElementById(divDefaultEl)){
				document.getElementById(divDefaultEl).style.display = "none";
			}	
		}else {
			document.getElementById(divOptionEl).style.display = "none";
			document.getElementById(divMaxLenEl).style.display = "inline";
			document.getElementById(divValidationEl).style.display = "inline";
			if(document.getElementById(divDefaultEl)){
				document.getElementById(divDefaultEl).style.display = "inline";
			}	
		}
	}
	
	function <portlet:namespace />hideFieldOptions(fieldName, input){
		var fieldType = input.options[input.selectedIndex].value;
		<portlet:namespace />hideDivs(fieldName, fieldType);
	}
	
	function <portlet:namespace />validateDynamicFieldForm(){
		if(document.getElementById("<portlet:namespace />newFieldInput")){
			var newInput = document.getElementById("<portlet:namespace />newFieldInput").value;
		
			if(newInput == null || newInput == ""){
				alert('Field name is required.');
				return false;
			}
		}	
	}
	
</script>

<jsp:useBean class="java.lang.String" id="curXslName" scope="request" />
<jsp:useBean class="java.lang.String" id="xslNames" scope="request" />

<portlet:actionURL var="editFormSubmitURL">
	<portlet:param name="action" value="editFormSubmit"></portlet:param>
</portlet:actionURL>

<portlet:actionURL var="addFormSubmitURL">
	<portlet:param name="action" value="addFormSubmit"></portlet:param>
</portlet:actionURL>

<div style="display: block; margin-bottom: 10px;">
	<!-- <input type="button" value="migrate"
		onclick="javascript:<portlet:namespace />migrateToSocialProfile();" />  -->
	<input
		type="button" value="Reload XML"
		onclick="javascript:<portlet:namespace />reloadUserInfoXML();">
	<input
		type="button" value="Reload All XML"
		onclick="javascript:<portlet:namespace />reloadAllUserInfoXML();">
	<input
		type="button" value="Sync Address"
		onclick="javascript:<portlet:namespace />syncAddress();">
	<input
		type="button" value="Add New Form"
		onclick="javascript:<portlet:namespace />AddNewForm();" id="<portlet:namespace />btnAddNewForm" style="display: inline">
	<div id="migration_iconstatus" class="msg_tooltip"></div>
</div>

<form id="<portlet:namespace />editForm" name="<portlet:namespace />editForm"
	action='<c:out value="${editFormSubmitURL}" />' method="post" onsubmit="javascript:return <portlet:namespace />validateDynamicFieldForm()">
	<select name="<portlet:namespace />xslSelect" id="<portlet:namespace />xslSelect"
		onchange="<portlet:namespace />showHideByXslName();">
		<option value='' />
		<c:forEach items="${xslNamesArr}" var="xslNamesArr">
			<c:choose>
				<c:when test="${xslNamesArr == curXslName}">
					<option value='<c:out value="${xslNamesArr}" />'
						selected="selected">
						<c:out value="${xslNamesArr}" />
					</option>
				</c:when>
				<c:otherwise>
					<option value='<c:out value="${xslNamesArr}" />'>
						<c:out value="${xslNamesArr}" />
					</option>
				</c:otherwise>
			</c:choose>
		</c:forEach>
	</select>
	<div id="<portlet:namespace />FormEdittableDiv" style="padding: 7px 0;">
		<h4>
		<input type="checkbox" id="<portlet:namespace />formEdittable" name="<portlet:namespace />formEdittable" value="true" <c:if test="${formEdittable == true}">checked="checked"</c:if>/>
		 Form edittable</h4>
	</div>
	<div id="<portlet:namespace />-xsl-options">
		<c:forEach items="${xslNamesArr}" var="xslNamesArr">
			<ul id='<portlet:namespace /><c:out value="${xslNamesArr}" />'
				<c:if test="${xslNamesArr != curXslName}">style="display: none;"</c:if>>
				<li><h4>Select Fields to be displayed:</h4>
				</li>
				<c:choose>
					<c:when test="${curXslName == xslNamesArr}">
						<li>
							<h4>Form Label:
								<input type="text" id="<portlet:namespace />formLabel" name="<portlet:namespace />formLabel" value="${formLabel}"/>
							</h4>
						</li>
						<c:forEach items="${fieldList}" var="inputField">
							<li>
							<input name='<portlet:namespace /><c:out value="${xslNamesArr}" />-checkbox'
								type="checkbox"
								value='<c:out value="${inputField.fieldName}" />'
								onclick="javascript:<portlet:namespace />checkDisplay('<c:out value="${inputField.fieldName}" />', this)" <c:if test="${inputField.display == true}">checked="checked"</c:if> />
							
							<span class="userprofile-edit-label">
								<c:out value="${inputField.fieldName}" />
							</span>
							<span
								id='<portlet:namespace />-<c:out value="${xslNamesArr}" />-<c:out value="${inputField.fieldName}" />-show-edit-link'>
									<a href="javascript:<portlet:namespace />showEditFields('<c:out value="${xslNamesArr}" />-<c:out value="${inputField.fieldName}" />')">[edit]</a>
							</span>
							<span
								id='<portlet:namespace />-<c:out value="${xslNamesArr}" />-<c:out value="${inputField.fieldName}" />-hide-edit-link'
								style="display: none"> <a
									href="javascript:<portlet:namespace />hideEditFields('<c:out value="${xslNamesArr}" />-<c:out value="${inputField.fieldName}" />')">[hide]</a>
							</span>

								<div class="userprofile-edit-fieldset-details"
									style="display: none;"
									id='<portlet:namespace />-<c:out value="${xslNamesArr}" />-<c:out value="${inputField.fieldName}" />-edit-collapsed'>
									
									<div <c:if test="${inputField.systemField == true && inputField.fieldName != 'interest_category'}">style="display: none;"</c:if>>
										<span>*Label</span>
										<span><input
											name='<c:out value="${inputField.fieldName}" />-label' 
											id='<c:out value="${inputField.fieldName}" />-label'
											type="text"
											value='<c:out value="${inputField.fieldLabel}" />' />
										</span>
									</div>
									<div <c:if test="${inputField.systemField == true && inputField.fieldName != 'interest_category'}">style="display: none;"</c:if>>
										<span>*Field Type</span> <span> <select
											name='<c:out value="${inputField.fieldName}" />-fieldType' onchange="<portlet:namespace />hideFieldOptions('<c:out value="${inputField.fieldName}" />',this)">
												<c:forEach items="${fieldTypes}" var="fieldOptions">
													<option value='<c:out value="${fieldOptions}" />'
														<c:if test="${fieldOptions == inputField.type}">selected="selected"</c:if>>
														<c:out value="${fieldOptions}" />
													</option>
												</c:forEach>
										</select> </span>
									</div>
									<div <c:if test="${inputField.systemField == true}">style="display: none;"</c:if>>
										<div id='<c:out value="${inputField.fieldName}" />-validation-div'>
											<span>Validation Type</span> <span> <select
												name='<c:out value="${inputField.fieldName}" />-validation' 
												id='<c:out value="${inputField.fieldName}" />-validation'>
													<c:forEach items="${validationTypes}" var="entry">
														<option value='<c:out value="${entry.key}" />'
															<c:if test="${entry.key == inputField.validationType}">selected="selected"</c:if>>
															<c:out value="${entry.value}" />
														</option>
													</c:forEach>
											</select> </span>
										</div>
									</div>
									<div>
										<span>Indexable</span><span>
										<c:choose>
											<c:when test="${inputField.systemField == true}">
												<input type="checkbox" <c:if test="${inputField.indexable == true}">checked="checked" </c:if> disabled="disabled"/>
												<input
													name='<c:out value="${inputField.fieldName}" />-indexable'
													id='<c:out value="${inputField.fieldName}" />-indexable'
													type="hidden" value="${inputField.indexable}"
												/>
											</c:when>
											<c:otherwise>
												<input
												name='<c:out value="${inputField.fieldName}" />-indexable'
												id='<c:out value="${inputField.fieldName}" />-indexable'
												type="checkbox" value="true" onclick="javascript:<portlet:namespace />checkSearchable('<c:out value="${inputField.fieldName}" />', this)" 
												<c:if test="${inputField.indexable == true}"> checked="checked"</c:if> />
											</c:otherwise>
										</c:choose>
										</span>
									</div>
									<div>
										<span>Searchable</span><span>
										<c:choose>
											<c:when test="${inputField.systemField == true}">
												<input type="checkbox" <c:if test="${inputField.searchable == true}">checked="checked" </c:if> disabled="disabled"/>
												<input
													name='<c:out value="${inputField.fieldName}" />-searchable'
													id='<c:out value="${inputField.fieldName}" />-searchable'
													type="hidden" value="${inputField.searchable}" 
												/>
											</c:when>
											<c:otherwise>
												<input
												name='<c:out value="${inputField.fieldName}" />-searchable' 
												id='<c:out value="${inputField.fieldName}" />-searchable' 
												type="checkbox" value="true" onclick="javascript:<portlet:namespace />checkIndexable('<c:out value="${inputField.fieldName}" />', this)" 
												<c:if test="${inputField.searchable == true}"> checked="checked"</c:if> />
											</c:otherwise>
										</c:choose>
										</span>
									</div>
									<div <c:if test="${inputField.systemField == true && inputField.fieldName != 'interest_category'}">style="display: none;"</c:if>>
										<div id='<c:out value="${inputField.fieldName}" />-edittable-div'>
											<span>Edittable</span><span><input
												name='<c:out value="${inputField.fieldName}" />-edittable'
												id='<c:out value="${inputField.fieldName}" />-edittable'
												type="checkbox" value="true"
												<c:if test="${inputField.edittable == true}">checked="checked"</c:if> />
											</span>
										</div>
									</div>
									<div <c:if test="${inputField.systemField == true}">style="display: none;"</c:if>>
										<span>Default Value</span><span><input
											name='<c:out value="${inputField.fieldName}" />-default' 
											id='<c:out value="${inputField.fieldName}" />-default'
											type="text"
											value='<c:out value="${inputField.defaultValue}" />' />
										</span>
									</div>
									<div <c:if test="${inputField.systemField == true}">style="display: none;"</c:if>>
										<div id='<c:out value="${inputField.fieldName}" />-maxlen-div'>
											<span>*Max Length</span><span><input
												name='<c:out value="${inputField.fieldName}" />-maxlength' 
												id='<c:out value="${inputField.fieldName}" />-maxlength'
												type="text" value='<c:out value="${inputField.maxlength}" />' />
											</span>
										</div>
									</div>
									<div <c:if test="${inputField.systemField == true}">style="display: none;"</c:if>>
										<span>Mandatory</span><span><input
											name='<c:out value="${inputField.fieldName}" />-mandatory'
											id='<c:out value="${inputField.fieldName}" />-mandatory'
											type="checkbox" value="true"
											<c:if test="${inputField.mandatory == true}">checked="checked"</c:if> />
										</span>
									</div>
									<div <c:if test="${inputField.systemField == true && inputField.fieldName != 'interest_category'}">style="display: none;"</c:if>>
										<div id='<c:out value="${inputField.fieldName}" />-option-div'>
											<span>Options</span><span>
												<select name='<c:out value="${inputField.fieldName}" />-options'
													id='<c:out value="${inputField.fieldName}" />-options' >
													<c:forEach var="item" items="${assetVocabulary}">
														<option value="<c:out value="${item.key}"/>" <c:if test="${item.key == inputField.options}">selected</c:if> >
															<c:out value="${item.value}"/>
														</option>
													</c:forEach>
												</select>
											</span>
											<span>Level</span><span><input
											name='<c:out value="${inputField.fieldName}" />-level' 
											id='<c:out value="${inputField.fieldName}" />-level'
											type="text"
											value='<c:out value="${inputField.levelValue}" />' />
										</span>
										</div>
									</div>
									<div>
										<span>Private</span><span><input
											name='<c:out value="${inputField.fieldName}" />-private'
											id='<c:out value="${inputField.fieldName}" />-private'
											type="checkbox" value="true"
											<c:if test="${inputField.privateView == true}">checked="checked"</c:if> />
										</span>
									</div>
								</div></li>
								<script type="text/javascript">
									<portlet:namespace />hideDivs('<c:out value="${inputField.fieldName}" />','<c:out value="${inputField.type}" />')
								</script>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<c:set var="fieldsToDisplay"
							value="${fieldsByCategory[xslNamesArr]}" />
						<c:forEach items="${fieldsToDisplay}" var="inputField">
							<li><input name='<portlet:namespace /><c:out value="${xslNamesArr}" />-checkbox'
								type="checkbox"
								value='<c:out value="${inputField.fieldName}" />' 
								onclick="javascript:<portlet:namespace />checkDisplay('<c:out value="${inputField.fieldName}" />', this)" />
							<span
								class="userprofile-edit-label"><c:out
										value="${inputField.fieldName}" />
							</span>
							<span
								id='<portlet:namespace />-<c:out value="${xslNamesArr}" />-<c:out value="${inputField.fieldName}" />-show-edit-link'>
									<a href="javascript:<portlet:namespace />showEditFields('<c:out value="${xslNamesArr}" />-<c:out value="${inputField.fieldName}" />')">[edit]</a>
							</span> <span
								id='<portlet:namespace />-<c:out value="${xslNamesArr}" />-<c:out value="${inputField.fieldName}" />-hide-edit-link'
								style="display: none"> <a
									href="javascript:<portlet:namespace />hideEditFields('<c:out value="${xslNamesArr}" />-<c:out value="${inputField.fieldName}" />')">[hide]</a>
							</span>
								<div class="userprofile-edit-fieldset-details"
									style="display: none;"
									id='<portlet:namespace />-<c:out value="${xslNamesArr}" />-<c:out value="${inputField.fieldName}" />-edit-collapsed'>
									<div <c:if test="${inputField.systemField == true}">style="display: none;"</c:if>>
										<span>*Label</span>
										<span><input
											name='<c:out value="${inputField.fieldName}" />-label' 
											id='<c:out value="${inputField.fieldName}" />-label'
											type="text"
											value='<c:out value="${inputField.fieldLabel}" />' />
										</span>
									</div>
									<div <c:if test="${inputField.systemField == true}">style="display: none;"</c:if>>
										<span>Field Type</span> <span> <select
											name='<c:out value="${inputField.fieldName}" />-fieldType' onchange="<portlet:namespace />hideFieldOptions('<c:out value="${inputField.fieldName}" />',this)">
												<c:forEach items="${fieldTypes}" var="fieldOptions">
													<option value='<c:out value="${fieldOptions}" />'>
														<c:out value="${fieldOptions}" />
													</option>
												</c:forEach>
										</select> </span>
									</div>
									<div <c:if test="${inputField.systemField == true}">style="display: none;"</c:if>>
										<div id='<c:out value="${inputField.fieldName}" />-validation-div'>
											<span>Validation Type</span> <span> 
												<select
													name='<c:out value="${inputField.fieldName}" />-validation' 
													id='<c:out value="${inputField.fieldName}" />-validation'>
														<c:forEach items="${validationTypes}" var="entry">
															<option value='<c:out value="${entry.key}" />'
																<c:if test="${entry.key == inputField.validationType}">selected="selected"</c:if>>
																<c:out value="${entry.value}" />
															</option>
														</c:forEach>
												</select> 
											</span>
										</div>
									</div>
									<div>
										<span>Indexable</span><span>
										<c:choose>
											<c:when test="${inputField.systemField == true}">
												<input type="checkbox" <c:if test="${inputField.indexable == true}">checked="checked" </c:if> disabled="disabled"/>
												<input
													name='<c:out value="${inputField.fieldName}" />-indexable'
													id='<c:out value="${inputField.fieldName}" />-indexable'
													type="hidden" value="${inputField.indexable}"
												/>
											</c:when>
											<c:otherwise>
												<input
													name='<c:out value="${inputField.fieldName}" />-indexable'
													type="checkbox" value="true" onclick="javascript:<portlet:namespace />checkSearchable('<c:out value="${inputField.fieldName}" />', this)" 
													<c:if test="${inputField.indexable == true}"> checked="checked"</c:if> 
												/>
											</c:otherwise>
										</c:choose>
										</span>
									</div>
									<div>
										<span>Searchable</span><span>
										<c:choose>
											<c:when test="${inputField.systemField == true}">
												<input type="checkbox" <c:if test="${inputField.searchable == true}">checked="checked" </c:if> disabled="disabled"/>
												<input
													name='<c:out value="${inputField.fieldName}" />-searchable'
													id='<c:out value="${inputField.fieldName}" />-searchable'
													type="hidden" value="${inputField.searchable}"
												/>
											</c:when>
											<c:otherwise>
												<input
													name='<c:out value="${inputField.fieldName}" />-searchable' id='<c:out value="${inputField.fieldName}" />-searchable' 
													type="checkbox" value="true" onclick="javascript:<portlet:namespace />checkIndexable('<c:out value="${inputField.fieldName}" />', this)" 
													<c:if test="${inputField.indexable == true}"> checked="checked"</c:if> 
												/>
											</c:otherwise>
										</c:choose>
										
										</span>
									</div>
									<div <c:if test="${inputField.systemField == true}">style="display: none;"</c:if>>
										<div id='<c:out value="${inputField.fieldName}" />-edittable-div'>
											<span>Edittable</span><span><input
												name='<c:out value="${inputField.fieldName}" />-edittable'
												id='<c:out value="${inputField.fieldName}" />-edittable'
												type="checkbox" value="true" />
											</span>
										</div>
									</div>
									<div <c:if test="${inputField.systemField == true}">style="display: none;"</c:if>>
										<span>Default Value</span><span><input
											name='<c:out value="${inputField.fieldName}" />-default'
											id='<c:out value="${inputField.fieldName}" />-default'
											type="text" value="" />
										</span>
									</div>
									<div <c:if test="${inputField.systemField == true}">style="display: none;"</c:if>>
										<div id='<c:out value="${inputField.fieldName}" />-maxlen-div'>
											<span>Max Length</span><span><input
												name='<c:out value="${inputField.fieldName}" />-maxlength'
												id='<c:out value="${inputField.fieldName}" />-maxlength'
												type="text" value="" />
											</span>
										</div>
									</div>
									<div <c:if test="${inputField.systemField == true}">style="display: none;"</c:if>>
										<span>Mandatory</span><span><input
											name='<c:out value="${inputField.fieldName}" />-mandatory'
											id='<c:out value="${inputField.fieldName}" />-mandatory'
											type="checkbox" value="true" />
										</span>
									</div>
									<div <c:if test="${inputField.systemField == true}">style="display: none;"</c:if>>
										<div id='<c:out value="${inputField.fieldName}" />-option-div'>
											<span>Options</span><span><!-- <input
												name='<c:out value="${inputField.fieldName}" />-options'
												id='<c:out value="${inputField.fieldName}" />-options'
												type="text" value="" />-->
												<select name='<c:out value="${inputField.fieldName}" />-options'
													id='<c:out value="${inputField.fieldName}" />-options' >
													<c:forEach var="item" items="${assetVocabulary}">
														<option value="<c:out value="${item.key}"/>">
															<c:out value="${item.value}"/>
														</option>
													</c:forEach>
												</select>
											</span>
										</div>
									</div>
									<div>
										<span>Private</span><span>
										<input
											name='<c:out value="${inputField.privateView}" />-private'
											id='<c:out value="${inputField.privateView}" />-private'
											type="checkbox" value="true" />
										</span>
									</div>
								</div></li>
								<script type="text/javascript">
									<portlet:namespace />hideDivs('<c:out value="${inputField.fieldName}" />','<c:out value="${inputField.type}" />')
								</script>
						</c:forEach>
					</c:otherwise>
				</c:choose>

			</ul>

		</c:forEach>

	</div>
	<div class="userprofile-edit-submit">
		<input type="button" id="<portlet:namespace />btnAddField" value="Add Field"
			onclick="javascript:<portlet:namespace />addNewField();" style="display: inline"> 
		<input type="submit"
			id="<portlet:namespace />editFormSubmit" value="Save" style="display: inline">
	</div>

</form>
	
<form id="<portlet:namespace />addForm" name="<portlet:namespace />addForm"
	action='<c:out value="${addFormSubmitURL}" />' method="post" onsubmit="javascript:return <portlet:namespace />validateDynamicFieldForm()">
	<div id="<portlet:namespace />addFormDiv"></div>
	<input type="submit"
			id="<portlet:namespace />btnAddFormSubmit" value="Save" style="display: none">
</form>
