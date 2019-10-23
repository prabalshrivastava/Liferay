
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ page import="javax.portlet.PortletPreferences"%>
<%@ page import="com.liferay.portal.theme.ThemeDisplay" %>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayPortletMode" %>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState" %>

<portlet:defineObjects />

<!-- Resource URL for AJAX  -->
<portlet:resourceURL id="saveRules" var="saveRulesResourceURL"></portlet:resourceURL>

<portlet:resourceURL id="retrieveFormRules" var="updateRuleResourceURL"></portlet:resourceURL>
<portlet:resourceURL id="deleteFormRules" var="deleteFormRulesURL"></portlet:resourceURL>
<portlet:resourceURL id="retrieveEntityDetails" var="entityDetailsURL"></portlet:resourceURL>
<portlet:resourceURL id="retrieveEntities" var="entityListURL"></portlet:resourceURL>
<portlet:resourceURL id="retrieveEntityFields" var="entityFieldURL"></portlet:resourceURL>
<portlet:resourceURL id="retrieveRoleDetails" var="roleDetailsURL"></portlet:resourceURL>


<script>
	var form_id = <%=renderRequest.getParameter("ruleSetId")%>;
	var form_name = '<%=renderRequest.getParameter("ruleSetName")%>';
	var ComponentType = '<%=GetterUtil.getString(renderRequest.getParameter("ComponentType"))%>';
	var ComponentId = '<%=renderRequest.getParameter("ComponentId")%>';
	var formVersion = '<%=renderRequest.getParameter("formVersion")%>';
	
	var isJSP = false;
	var isProcess = false;
	var isForm = false;
	
	if (ComponentType.toUpperCase() === "JSP") {
		isJSP = true;
	} else if (ComponentType.toUpperCase() === "PROCESS") {
		isProcess = true;
	} else {
		isForm = true;
	}

	var isUpdate = <%=renderRequest.getParameter("isUpdate")%>;
</script>

<div id="msgContainer" class="msgContainer portlet-msg-success hidden" tabindex="500">Ruleset Successfully Updated</div>
<div id="msgContainer-error" class="alert alert-error hidden" tabindex="500">Error while updating Ruleset</div>

<div class="enrollmentContainer screen-max-width ">
	
	<div class="enrollmentRow margin-top-40">
		<!--sidebarNavigation-->
		<div class="sidebarNavigation" id="side">
			<div class="roundedborder">
				<ul>
					<li class="sideNavHeader">
						<h6>RULE -SET COMPONENTS</h6>
					</li>
				</ul>
				<div class="Drag-Sec">
					<div class="draggableOne Drag-content" draggable="true"
						id="draggableConditionSet">
						<img src="/SPProcessEngine-portlet/images/drag.svg" alt="Alt"><span>Condition
							Set</span>
					</div>
					<div class="draggableTwo Drag-content" draggable="true"
						id="draggableCondition">
						<img src="/SPProcessEngine-portlet/images/Icon-Condition.svg" alt="Condition"> <span>Condition</span>

					</div>
					<!-- Ranjan -->
					<div class="draggableThree Drag-content" draggable="true"
						id="draggableEntity">
						<img src="/SPProcessEngine-portlet/images/list-form.svg" alt="List Form"> <span>Entity</span>

					</div>
					<!-- Abhinay -->
					<div class="draggableFour Drag-content" draggable="true"
						id="draggableRole">
						<img src="/SPProcessEngine-portlet/images/Icon-Role.svg" alt="Role"> <span>Role</span>

					</div>
				</div>
			</div>

			<div class="Drag-Notes" id="dragNotes">
				<h6>Notes :</h6>
				<ul class="Notes-list">
					<li>A Condition Set is a group of conditions</li>
					<li>Any two conditions are connected by an ‘AND’ operator.</li>
					<li>Any two condition sets are connected by an ‘OR’
						operator.</li>
					<li>One cannot create a condition set inside another condition
						set</li>
					<li>The outcome of any rule is just one.</li>

				</ul>
			</div>
		</div>
		
		
		<!--sidebarNavigation End-->
		<div class="maincontentRight">
			<div class="mainContentContainer">

				<div class="Header-white-two"><h4>CREATE RULES</h4></div>
				
				<div id="RulesArea" class="Rules-AreaSection dropArea">
					<div class="Rules-NameDiv">
						<label>Form Name</label><input type="text" value='<%=renderRequest.getParameter("ruleSetName")%>' name="" /><br>
						<p style="dispaly: none" id=""></p>
					</div>

					<div id="RuleSet" class="RulesetDiv" draggable="true">
						<div class="Rules-No">
							<span id="ruleNumber">1st</span>
						</div>

						<div class="RuleName_Entry">
							<input class="customForm ruleName" type="text" placeholder="Add a Custom Rule name" name="customRuleName" /><br>
						</div>

						<div class="dropArea conditionSets" id="conditionSets">
							<span class="D&DTextCondSet">Drag & drop Condition Set here</span>
						</div>

					</div>

					<div class="Addrule_btn">
						<a href="#" id="createNewAddRule" onclick="addNewRuleToRuleSet();">+ Add Rule</a>
					</div>
				</div>

				<div class="SaveCancel-Btn">
					<a href="#" id="cancelRule" onclick="navigateBack()">Cancel</a> 
					<a href="#" id="saveRule" onclick="addRuleSetAjax()">Submit</a>
				</div>

				<!-- Dummy Div to be cloned for each condition Set -->
				<div style="display: none;" id="conditionSet">
					<div class="dropArea conditions" id="conditions">
						<span class="D&DTextCond">Drag & drop Conditions/Entity/Roles here</span><br>	
					</div>
					<div class="OR-Div">OR</div>
				</div>
				

				<!-- Dummy div to be cloned for each condition on drop of condition -->
				<div style="display: none;" class="conditions condGrp" id="ruleAddCondition">
					<div id="ruleAddCondition">
						<span>AND</span> 
						<select id="conditionsOptions"
							name="<portlet:namespace />dropDownList1" class="selectOption1 conditionField" onchange="generateField(this)">
						</select> 
						<select name="<portlet:namespace />dropDownList2" class="selectOption2 conditionDataType" onchange="populateOperator(this)">
							<option value="String">String</option>
							<option value="Number">Number</option>
							<option value="Boolean">Boolean</option>
						</select> 
						<select name="<portlet:namespace />dropDownList2" class="operator conditionOperator" onchange="conditionOperatorChanged(event)">
							<option value="equals">Equal</option>
							<option value="notEquals">Not Equals</option>
							<option value="contains">Contains</option>
							<option value="notContains">Not Contains</option>
							<option value="startsWith">Starts With</option>
							<option value="in">In</option>
							<option value="notin">Not In</option>
							<option value="isEmpty">Is Empty</option>
							<option value="isNotEmpty">Is Not Empty</option>

						</select> 
						<input type="text" style="margin: 10px; width: 200px;" name="<portlet:namespace />addValue" placeholder="Add a value" class="inputField conditionValue" /> 
						<a class="close" onclick="deleteCondition(this)">&times;</a> 
						<a class="Formmenu-icon"><img src="/SPProcessEngine-portlet/images/Form-menu.svg" alt="Form Menu"></a>
					</div>
				</div>
				
				<!-- Dummy div to be cloned for each Entity on drop of Entity -->
				<div style="display: none;" class="conditions entities condGrp" id="entityAddCondition">
					<div>
						<span>AND</span> 
						
						<select id="entitiesOptions" name="<portlet:namespace />dropDownList1" class="selectOption1 entityField" onchange="retriveEntityFields(this)">
							<option></option>
						</select> 
						<select name="<portlet:namespace />dropDownList2" class="selectOption4" onchange="fieldChanged(event)">
							<option>Select Field</option>
						</select>
						
						<select name="<portlet:namespace />dropDownList2" class="entityDataType" onchange="entityOthersFieldChanged(event)">
							<option value="String">String</option>
							<option value="Number">Number</option>
						</select>
						
						<select name="<portlet:namespace />dropDownList2" class="operator entityOperator" onchange="conditionOperatorChanged(event)">
							<option value="equals">Equal</option>
							<option value="notEquals">Not Equals</option>
							<option value="contains">Contains</option>
							<option value="notContains">Not Contains</option>
							<option value="startsWith">Starts With</option>
							<option value="in">In</option>
							<option value="notin">Not In</option>
							<option value="isEmpty">Is Empty</option>
							<option value="isNotEmpty">Is Not Empty</option>
							
						</select>
						<!-- Remember selectOption3 is used only in case of entity, which also helps in validting entity drop-down, i.e 5th drop-down -->
						<select name="<portlet:namespace />dropDownList2" class="entityValue selectOption3" onchange="entityChanged(this)">
							<option ></option>
						</select>
						
						<a class="close" onclick="deleteCondition(this)">&times;</a>
						
						<a class="Formmenu-icon"><img src="/SPProcessEngine-portlet/images/Form-menu.svg" alt="Form Menu"></a>
					</div>
				</div>
				
				<!-- Dummy div to be cloned for each Role on drop of Role -->
				<div style="display: none;" class="conditions roles condGrp" id="roleAddCondition">
					<div>
						<span>AND</span> 
					
						<select name="<portlet:namespace />dropDownList2" class="selectOption2" onchange="conditionOthersFieldChanged(event)">
							<option value="roleId">Role</option>
						</select>
						
						<select name="<portlet:namespace />dropDownList2" class="roleDataType" onchange="populateOperator(this)">
							<option selected value="Number">Number</option>
						</select>
						
						<select name="<portlet:namespace />dropDownList2" class="operator roleOperator" onchange="conditionOperatorChanged(event)">
							<option value="equals">Equal</option>
							<option value="notEquals">Not Equals</option>
							<option value="in">In</option>
							<option value="notin">Not In</option>
							
						</select>
						
						<select id="rolesOptions" name="<portlet:namespace />dropDownList1" class="selectOption3" onchange="roleChanged(this)" >
							<optio></option>
						</select> 
						
						<a class="close" onclick="deleteCondition(this)">&times;</a>
						
						<a class="Formmenu-icon"><img src="/SPProcessEngine-portlet/images/Form-menu.svg" alt="Form Menu"></a>
					</div>
				</div>

				<!-- Dummy div to be cloned for each condition in conditionset for Process Only -->
				<div style="display: none;" class="conditions "
					id="ruleAddConditionProcess">

					<div id="ruleAddConditionProcess">
						<span>AND</span> <select id="conditionsOptions"
							name="<portlet:namespace />dropDownList1"
							class="selectOption1 conditionFieldProcess"
							onchange="generateField(this)">
							<option value="Status">Status</option>
							<option value="StatusType">Status Type</option>
							<option value="signedin">Signed In</option>
							<option value="firstLogin">First Login</option>

						</select>

						<select name="<portlet:namespace />dropDownList2"
							class="operator conditionOperatorProcess"
							onchange="conditionOperatorChanged(event)">

							<option value="equals">Equal</option>
							<option value="notEquals">Not Equals</option>
							<option value="contains">Contains</option>
							<option value="notContains">Not Contains</option>
							<option value="startsWith">Starts With</option>

						</select> <select name="<portlet:namespace />dropDownList2"
							class="inputField conditionValueProcess"
							onchange="conditionValueChanged(event)">

							<option value="Approved">Approved</option>
							<option value="Rejected">Rejected</option>
							<option value="Pending">Pending</option>

						</select> <a class="close" onclick="deleteCondition(this)">&times;</a> <a
							class="Formmenu-icon"><img
							src="/SPProcessEngine-portlet/images/Form-menu.svg" alt="Form Menu"></a>
					</div>
				</div>

				<!-- Dummy div to be cloned for each condition in conditionset for JSP Only -->
				<div style="display: none;" class="conditions"
					id="ruleAddConditionJSP">

					<span>AND</span> <input type="text"
						name="<portlet:namespace />addValue"
						placeholder="Enter Field Name" class="conditionFieldJSP"
						onchange="generateField(this)" /> <select
						name="<portlet:namespace />dropDownList2"
						class="selectOption2 conditionDataTypeJSP"
						onchange="populateOperator(this)">

						<option value="String">String</option>
						<option value="Number">Number</option>
						<option value="Boolean">Boolean</option>

					</select> <select name="<portlet:namespace />dropDownList2"
						class="operator conditionOperatorJSP"
						onchange="conditionOperatorChanged(event)">

						<option value="equals">Equal</option>
						<option value="notEquals">Not Equals</option>
						<option value="contains">Contains</option>
						<option value="notContains">Not Contains</option>
						<option value="startsWith">Starts With</option>
						<option value="in">In</option>
						<option value="notin">Not In</option>
						<option value="isEmpty">Is Empty</option>
						<option value="isNotEmpty">Is Not Empty</option>

					</select> <input type="text" style="margin: 10px; width: 200px;"
						name="<portlet:namespace />addValue" placeholder="Add a value"
						class="conditionValueJSP" onchange="conditionValueChanged(event)" />


					<a class="close" onclick="deleteCondition(this)">&times;</a> <a
						class="Formmenu-icon"><img
						src="/SPProcessEngine-portlet/images/Form-menu.svg" alt="Form Menu"></a>
				</div>

				<!-- div element to be cloned to add a new Rule  -->
				<div style="display: none;" id="cloneRuleSet2" class="RulesetDiv" draggable="true">
					<div class="Rules-No">
						<span id="ruleNumber">2nd</span>
					</div>

					<div class="RuleName_Entry">
						<input class="customForm ruleName" type="text" placeholder="Add a Custom Rule name" name="customFormName" /><br>
					</div>
				</div>

				<div style="display: none;" class="dropArea conditionSets" id="conditionSets2">
					<span class="D&DTextCondSet">Drag & drop Condition Set here</span>
				</div>
			</div>
		</div>
	</div>
</div>

<!-- Rule List Screen -->

<!-- Function to get a pop up window to add new rule to the Rule Set -->
<script type="text/javascript">
	function addRule() {

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
							titleMsg = "Rule-Set Details";
							var dialog = Liferay.Util.Window
									.getWindow({
										title : titleMsg,
										dialog : {
											bodyContent : 'Name<br><input type = "text" name = "name" value = "Enrolment - Eligibility check rule" /><br><input type = "text" value="Interest Registration Form" />',
											centered : true,
											//cache: false,
											destroyOnClose : true,
											destroyOnHide : true,
											height : 250,
											width : 300,
											stack : true,
											modal : false,
											constrain2view : true,
											toolbars : {
												footer : [
														{
															label : 'Cancel',
															on : {
																click : function() {
																	dialog.hide();
																}
															}
														},
														{
															label : 'Save',
															on : {
																click : function() {
																	addNewRuleToRuleSet();
																	dialog.hide();
																}
															}
														} ]
											}

										}
									})
							dialog.render();

						});
	}
</script>

<script type="text/javascript">

	function navigateBack(){
		AUI().use('liferay-portlet-url', function(A) {
			var renderURL = Liferay.PortletURL.createRenderURL();

			renderURL.setParameter("mvcPath", "/html/rulesrepo/view.jsp");
			renderURL.setPortletId("rulesrepository_WAR_SPProcessEngineportlet");
			renderURL.setWindowState("<%= LiferayWindowState.NORMAL.toString() %>");
			
			window.location.href = renderURL.toString();
		});
	}

	function addRuleSetAjax() {
					
		// first delete all record for this form id
		if(!isValidDropDown())
			return; 
		
		for (var i = 0; i < rules.length; i++) {

			var ruleToSave = [];

			for (var csIndex = 0; csIndex < rules[i].conditionSets.length; csIndex++) {

				ruleToSave[csIndex] = [];

				for (var condIndex = 0; condIndex < rules[i].conditionSets[csIndex].conditions.length; condIndex++) {

					if(rules[i].conditionSets[csIndex].conditions[condIndex].hasOwnProperty('componentType')){
						if(rules[i].conditionSets[csIndex].conditions[condIndex].componentType==='Entity'){
							ruleToSave[csIndex]
							.push({								
								"componentType" : rules[i].conditionSets[csIndex].conditions[condIndex].componentType,
								"EntityType" : rules[i].conditionSets[csIndex].conditions[condIndex].EntityType,
								"field" : rules[i].conditionSets[csIndex].conditions[condIndex].field,
								"type" : rules[i].conditionSets[csIndex].conditions[condIndex].type,
								"operator" : rules[i].conditionSets[csIndex].conditions[condIndex].operator,
								"value" : rules[i].conditionSets[csIndex].conditions[condIndex].value,
								"caseSensitive" : rules[i].conditionSets[csIndex].conditions[condIndex].caseSensitive
							});	
						}else if(rules[i].conditionSets[csIndex].conditions[condIndex].componentType==='Role'){
							ruleToSave[csIndex]
							.push({								
								"componentType" : rules[i].conditionSets[csIndex].conditions[condIndex].componentType,
								"field" : rules[i].conditionSets[csIndex].conditions[condIndex].field,
								"type" : rules[i].conditionSets[csIndex].conditions[condIndex].type,
								"operator" : rules[i].conditionSets[csIndex].conditions[condIndex].operator,
								"value" : rules[i].conditionSets[csIndex].conditions[condIndex].value
							});	
						}
						
					}else
						ruleToSave[csIndex]
							.push({
								"field" : rules[i].conditionSets[csIndex].conditions[condIndex].field,
								"type" : rules[i].conditionSets[csIndex].conditions[condIndex].type,
								"operator" : rules[i].conditionSets[csIndex].conditions[condIndex].operator,
								"value" : rules[i].conditionSets[csIndex].conditions[condIndex].value,
								"caseSensitive" : rules[i].conditionSets[csIndex].conditions[condIndex].caseSensitive
							})
				}
			}

			var customFormName = document.getElementsByClassName('customForm')[i].value;

			AUI().use(
					'aui.io.request',
					function(A) {
						A.io.request('${saveRulesResourceURL}', {
							method : 'post',
							data : {
								<portlet:namespace />RuleDetails : JSON
										.stringify(ruleToSave),
								<portlet:namespace />formId : form_id,
								<portlet:namespace />ruleDBId : rules[i].DBId,
								<portlet:namespace />ruleName : rules[i].name,
								<portlet:namespace />sequence : i,
							},

							on : {
								success : function() {
									var ruleDBId = (JSON.parse(this
											.get('responseData'))).ruleDBId;
									var ruleSequence = (JSON.parse(this
											.get('responseData'))).rueSequence;

									rules[ruleSequence].DBId = ruleDBId;
									
									//Show sucess message				
									$(document.getElementById('msgContainer')).fadeIn(2000);
									document.getElementById('msgContainer').classList.remove("hidden");
									$(document.getElementById('msgContainer')).fadeOut(2000);
									console.log("------success in loading saveRulesResourceURL---");
								},
								
								failure : function(){
									//Show failure message
									$(document.getElementById('msgContainer-error')).fadeIn(2000);
									document.getElementById('msgContainer-error').classList.remove("hidden");
									$(document.getElementById('msgContainer-error')).fadeOut(2000);
									console.log("Failed in loading saveRulesResourceURL---");
								}								
							}
						});
					});
		}

	}

	function loadExistingData() {

		AUI().use(
				'aui.io.request',
				function(A) {
					A.io.request('${updateRuleResourceURL}', {
						method : 'post',

						data : {
							<portlet:namespace />updateformID : form_id,
						},

						on : {
							success : function() {
								var retrievedRules = (JSON.parse(this
										.get('responseData'))).retrieveRules;
								redrawForm(retrievedRules);

							}
						}
					});
				});
	}
</script>

<!-- JavaScript functions -->
<script src="/SPProcessEngine-portlet/js/rulesrepo/jsonArrayData.js"></script>
<script src="/SPProcessEngine-portlet/js/rulesrepo/dragAndDrop.js"></script>
<script src="/SPProcessEngine-portlet/js/rulesrepo/jquery.js"></script>
<script src="/SPProcessEngine-portlet/js/rulesrepo/update.js"></script>

<script>

	function loadFormSchema() {

		Liferay.Service(
				  '/SPProcessEngine-portlet.formbuilder/get-form-schema',
				  {
				    userId: Liferay.ThemeDisplay.getUserId(),
				    formId: ComponentId
				  },
				  function(obj) {
				    console.log(obj);
				    conditionJSonData =  JSON.parse(obj);
				    if (isUpdate === 1) {
						loadExistingData();
					}
				  }
				);
	}

	//Added By Ranjan
	function loadEntityDetails() {
		
		AUI().use('aui.io.request', function(A) {A.io.request('${entityDetailsURL}', {
    		method : 'get',   
    		sync: true,		
			on : {
				success : function() {	
					
					entityNameIdMap = JSON.parse(this.get('responseData')).entities;
				},
				failure : function(){
					console.log("Failed in loading loadEntityDetails.");
				}
			}
		});});
	}
	
	//
	function loadRoleDetails() {
		
		AUI().use('aui.io.request', function(A) {A.io.request('${roleDetailsURL}', {
    		method : 'get',   
    		sync: true,		
			on : {
				success : function() {	
					
					roleNameIdMap = JSON.parse(this.get('responseData')).roles;
				},
				failure : function(){
					console.log("Failed in loading loadRoleDetails.");
				}
			}
		});});
	}
	
	//method to retrieve and populate dynamic entity fields and drop downs
	function retriveEntityFields(fieldElement,entityField,entityVal){

		var entityId = fieldElement.value;
		var entityListSelect = fieldElement.parentElement.getElementsByClassName('entityValue')[0];
		var entityElement = fieldElement.parentElement.getElementsByClassName('selectOption4')[0];
		
		if(entityId == ""){
			fieldElement.parentElement.getElementsByClassName('selectOption4')[0].innerHTML = "";
			entityElement.style.borderColor = 'red';
			return;
		}
		
		isEntityDropDownListEmpty = false;
		entityElement.style.borderColor = '';
				
		//Make an ajax call to fetch list of entities corresponding to that selected entity type.
		AUI().use('aui.io.request', function(A) {A.io.request('${entityFieldURL}', {
    		method : 'get',
    		
    		data : {
				<portlet:namespace />entityId : entityId,
			},
			sync : true,
			on : {
				success : function() {
					
					entityFields = JSON.parse(this.get('responseData')).entityFields;
				 	var entityOption = null, out = '<option value="">Select Entity Field</option>';
				 	
					if(entityFields != null){
						entityFieldData=entityFields;
						for(var indx = 0; indx < entityFields.length; indx++){
							entityOption = entityFields[indx];
								if(entityOption.id===entityField)
									out += '<option selected="true" value="' + entityOption.id + '" >' + entityOption.name + '</option>';
								else
									out += '<option value="' + entityOption.id + '" >' + entityOption.name + '</option>';
										
						}
					}
					
					entityElement.innerHTML = out;
	
					if(entityVal != undefined )
						regenerateDropDown(entityElement,entityField,entityVal);
					
					var entityToChange = findCondition(fieldElement);
					entityToChange.EntityType = fieldElement.value;

					entityToChange = findCondition(entityElement);
					entityToChange.field = entityElement.value;
					 
				},
				failure : function(){
					console.log("Failed in loading loadEntityFields");
				}
			}
		});});
	}
	
	function init() {
		(document.getElementById("RuleSet").getElementsByClassName('ruleName')[0])
				.addEventListener("change", setRuleName, false);
		(document.getElementsByClassName("conditionValue")[0])
				.addEventListener("change", conditionValueChanged, false);
		(document.getElementsByClassName("conditionOperator")[0])
				.addEventListener("change", conditionOperatorChanged, false);

	}

	AUI().ready('aui-node','aui-io-request', 'liferay-util-window','aui-io-plugin-deprecated',
			'stylesheet','aui-datepicker','overlay','event', 'widget-anim', function(A) {
		loadEntityDetails();
		loadRoleDetails();
		init();
		if (isForm) {
			loadFormSchema();			
		} else if (isUpdate) {
			loadExistingData();
		}

	});
	
</script>

<script type="text/javascript">
	 
var node = document.getElementById('side'),
    nodeOffs = node.offsetTop,    
    parent = node;
    var dragN = document.getElementById('dragNotes');

while(parent = parent.offsetParent)
  if(parent.offsetTop)
    nodeOffs += parent.offsetTop;

window.addEventListener('scroll', function(event){    
    var scrollPos = document.body.scrollTop;

    if(scrollPos > nodeOffs){
        
        if(scrollPos < (document.body.scrollHeight - node.clientHeight - nodeOffs))
          node.style.top = (scrollPos - nodeOffs) + 'px';
          node.style.paddingTop = '100px'
          dragN.style.display = 'none';
       
    }

    else{
        node.style.top = '0px';
        node.style.paddingTop = '0px'
        dragN.style.display = 'block';
    }

});   
</script>


