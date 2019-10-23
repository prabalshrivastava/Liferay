
/**
 * This drag And drop file contains the core methods which are developed to handle dynamically creating condition sets, conditions and adding new rules.
 *Contains methods to handle events and their listeners, to handle the events generated during the creation of new conditions, sets, and rules. 
 *Reads the data from JSON file and has methods to populate them and generate input fields based on the JSON data. 
 */

/**
* This variable holds the dynamically created ID's of Condition Sets, Conditions and new rules
*/ 
	var entityNameIdMap = null;
	var roleNameIdMap = null;
	var draggedElementType = null;
	var draggedSrc = null;
	var entityFieldData =null;

	var rules = [{
				id:'RuleSet',
				name:'',
				DBId: -1,
				conditionSets :[

							]	
				}];
	
	/**
	 * function to add new rule to the Rule Set
	 */
	function addNewRuleToRuleSet(ruleName, ruleDBId) {
		
		// first create the New Rule
		
		// generate the ID for new Rule
		
		var ruleID = "RuleSet" + rules.length;
		
		var newRule = document.getElementById("cloneRuleSet2").cloneNode(true);
		newRule.setAttribute("id",ruleID);
		newRule.style.display = 'block';
	
		
		// Add a event listener to the text Field
		(newRule.getElementsByClassName('ruleName')[0]).addEventListener("change",setRuleName,false);
		
		if(ruleName === undefined){
			(newRule.getElementsByClassName('ruleName')[0]).value = '';
		}else{
			(newRule.getElementsByClassName('ruleName')[0]).value = ruleName;
		}

		
		var ruleCountText = '1st';
		if(rules.length === 0) {
			ruleCountText = "1st";
		}else if(rules.length === 1) {
			ruleCountText = "2nd";
		} else if(rules.length === 2) {
			ruleCountText = "3rd";
		} else {
			ruleCountText = rules.length + 1 + "th";
		}
		
		newRule.getElementsByTagName('span')[0].innerText = ruleCountText;
		
		/**
		 * creates the Condition Set in the newly created rule.
		 * get the parent of current drop are and generate dynamic ID
		 * 
		 */
		
		var newConditionSetID = ruleID + "conditionSets";
						
		var conditionSet = document.getElementById("conditionSets2").cloneNode(true);
		conditionSet.setAttribute("id",newConditionSetID);
		conditionSet.style.display = "block";
		
		conditionSet.addEventListener("drop",handleDropForConditionSets,false);
		assignListenersToElement(conditionSet);
		
		// append newly created conditionSet to rule
		newRule.appendChild(conditionSet);
	
		// append newly created ruleset to form
		var parentNode = document.getElementById("RulesArea")
		parentNode.appendChild(newRule);
		
		// it means it's new rule and not yet added to DB
		if(!ruleDBId) {
			ruleDBId = -1;
		}
		
		rules.push({
			'id':ruleID,
			'DBId' : ruleDBId,
			'name' : ruleName,
			'conditionSets' :[
							]
					});			
	
		return ruleID;
	}
	
	/**
	 * DRAGGABLE Object Event handlers for ConditionSet
	 */  
		function handleDragStartForConditionSet(e) {
			    	 
			// Target (this) element is the source node.
			  this.style.opacity = '0.4';

			  var dragSrcEl = this;

			  e.dataTransfer.effectAllowed = 'move';
			  e.dataTransfer.setData('text', "CS");
			  
			  draggedElementType = "conditionSet";
			  draggedSrc = this;
		}
		
		/**
		 * DRAGGABLE Object Event handlers for Conditions
		 */ 
		function handleDragStartForCondition(e) {
			    	 
			// Target (this) element is the source node.
			  this.style.opacity = '0.4';

			  var dragSrcEl = this;

			  e.dataTransfer.effectAllowed = 'move';
			  e.dataTransfer.setData('text', "C");
			  
			  draggedElementType = "condition";
			  draggedSrc = this;

		}
		
		/**
		 * DRAGGABLE Object Event handlers for Entity
		 */ 
		function handleDragStartForEntities(e) {
	    	 
			// Target (this) element is the source node.
			  this.style.opacity = '0.4';

			  var dragSrcEl = this;

			  e.dataTransfer.effectAllowed = 'move';
			  e.dataTransfer.setData('text', "E");
			  
			  draggedElementType = "condition";
			  draggedSrc = this;

		}
		
		/**
		 * DRAGGABLE Object Event handlers for Roles
		 */ 
		function handleDragStartForRoles(e) {
	    	 
			// Target (this) element is the source node.
			  this.style.opacity = '0.4';

			  var dragSrcEl = this;

			  e.dataTransfer.effectAllowed = 'move';
			  e.dataTransfer.setData('text', "R");
		}
		
		
		/**
		 * DRAGGABE object Event Handlers End
		 */

		/**
		 * Drop areas event handlers
		 */
	
	    function handleDragEnter(e) {
	    	if(draggedElementType == 'conditionSet'){	        	
	        	var condset = event.target.querySelector('#conditionSets')	        	
	        	if(condset != undefined)	        	
	        		condset.style.border = "1px dotted red";
	        	
	        }else if(draggedElementType == 'condition'){
	        	var conditions = event.target.querySelector('#conditions')	        	
	        	if(conditions != undefined)
	        		conditions.style.border = "1px dotted red";
	        }  
		}
	    
	    function handleDragOver(e) {
	    	 event.preventDefault();
		}
	    
	    function handleDragLeave(e) {
	    	if(draggedElementType == 'conditionSet'){	        	
	        	var condset = event.target.querySelector('#conditionSets')	        	
	        	if(condset != undefined)	        	
	        		condset.style.border = "";
	        	
	        }else if(draggedElementType == 'condition'){
	        	var conditions = event.target.querySelector('#conditions')	        	
	        	if(conditions != undefined)
	        		conditions.style.border = "";
	        }  
	    	
	    	draggedElementType = "";
		}
	    
	    function assignListeners() {
		    var cols = document.querySelectorAll('.dropArea');
		    [].forEach.call(cols, function(col) {
		      col.addEventListener('dragenter', handleDragEnter, true);
		      col.addEventListener('dragover', handleDragOver, false);
		      col.addEventListener('dragleave', handleDragLeave, false);
		      
		    });
		 }

	    function assignListenersToElement(element) {
		   
	    	element.addEventListener('dragenter', handleDragEnter, false);
	    	element.addEventListener('dragover', handleDragOver, false);
	    	element.addEventListener('dragleave', handleDragLeave, false);
		   
		 }	   
	    
		/**
		 * This method determines the conditions sets and creates ID's dynamically 
		 */
	    function handleDropForConditionSets(event) {
	    	   
	    	 event.preventDefault();
			 
			 if(event.dataTransfer.getData("text") === "CS" && $(event.target).hasClass('conditionSets') ) {
				 
				/**
				 *  get the parent of current drop are and generate dynamic ID
				 */
				var parentID = event.target.parentElement.getAttribute("id");
				
				var index = rules.findIndex(function(obj){
					return obj.id === parentID;	
					
				});
						
				var conditionSet = AddNewConditionSetToRule(parentID,index);
				
				//event.target.appendChild(conditionSet);
				event.target.insertBefore(conditionSet,event.target.getElementsByClassName("D&DTextCondSet")[0])
			
			 }   	        
	     }	   
	    	    
	    function AddNewConditionSetToRule(parentID,index ) {
	    	
	    	var newConditionSetID = parentID + "CS" + rules[index].conditionSets.length;
			
			var conditionSet = document.getElementById("conditionSet").cloneNode(true);
			conditionSet.setAttribute("id",newConditionSetID);
			conditionSet.style.display = "block";
			conditionSet.addEventListener("drop",handleDropForConditions,false);
			conditionSet.addEventListener("drop",handleDropForEntities,false);//By Ranjan
			conditionSet.addEventListener("drop",handleDropForRoles,false); //By Abhinay
			
			
			
			rules[index].conditionSets.push({
						'id':newConditionSetID,
						'conditions':[
						            ]
						}
				);		
	    	
			return conditionSet;
	    }
	    
		/**
		 * This method determines the conditions and creates ID's dynamically 
		 */
	    
	     function handleDropForConditions(event) {
	    	    event.preventDefault();
				
				if(event.dataTransfer.getData("text") === "C" && $(event.target).hasClass('conditions')) {
				 
					// get the parent of current drop are and generate dynamic ID
					var conditionSetID = event.target.parentElement.getAttribute("id");
					var ruleID = event.target.parentElement.parentElement.parentElement.getAttribute("id");
					
					var indexOfRule = rules.findIndex(function(obj){
						return obj.id === ruleID;
								
					});
					
					var indexOfConditionSetInRule = rules[indexOfRule].conditionSets.findIndex(function(obj){
						return obj.id === conditionSetID;
							
					});
							
					
					var condition = addConditionToConditionSet(conditionSetID,indexOfRule,indexOfConditionSetInRule);
					
					event.target.insertBefore(condition,event.target.getElementsByClassName("D&DTextCond")[0])
					
					if(isForm) {
						//generate the value field based on field value
						generateField(condition.getElementsByClassName('selectOption1')[0]);
					} else if (isProcess) {
						generateField(condition.getElementsByClassName('conditionFieldProcess')[0]);
					}
					
					event.stopPropagation();
				}

	    	}

	     /**
		 * This method determines the entities and creates ID's dynamically 
		 */
	    function handleDropForEntities(event) {
    	    event.preventDefault();
			
			if(event.dataTransfer.getData("text") === "E" && $(event.target).hasClass('conditions')) {
			 
				// get the parent of current drop are and generate dynamic ID
				var conditionSetID = event.target.parentElement.getAttribute("id");
				var ruleID = event.target.parentElement.parentElement.parentElement.getAttribute("id");
				
				var indexOfRule = rules.findIndex(function(obj){
					return obj.id === ruleID;
							
				});
				
				var indexOfConditionSetInRule = rules[indexOfRule].conditionSets.findIndex(function(obj){
					return obj.id === conditionSetID;
						
				});
						
				//populate entity list in drop-down.
				var entity = addEntitiesToConditionSet(conditionSetID, indexOfRule, indexOfConditionSetInRule);
				
				event.target.insertBefore(entity, event.target.getElementsByClassName("D&DTextCond")[0]);
				
				event.stopPropagation();
			}
    	}
	    
	    /**
		 * This method determines the Roles and creates ID's dynamically -By Abhinay 
		 */
	   
	    function handleDropForRoles(event) {
    	    event.preventDefault();
			
			if(event.dataTransfer.getData("text") === "R" && $(event.target).hasClass('conditions')) {
			 
				// get the parent of current drop are and generate dynamic ID
				var conditionSetID = event.target.parentElement.getAttribute("id");
				var ruleID = event.target.parentElement.parentElement.parentElement.getAttribute("id");
				
				var indexOfRule = rules.findIndex(function(obj){
					return obj.id === ruleID;
							
				});
				
				var indexOfConditionSetInRule = rules[indexOfRule].conditionSets.findIndex(function(obj){
					return obj.id === conditionSetID;
						
				});
				
				//populate role list in drop-down.
				var role = addRolesToConditionSet(conditionSetID, indexOfRule, indexOfConditionSetInRule);
				event.target.insertBefore(role, event.target.getElementsByClassName("D&DTextCond")[0]);
				event.stopPropagation();
						
			}
    	}
	    
	     /**
	      * Add condition to conditionSet  
	      * @param conditionSetID
	      * @param indexOfRule
	      * @param indexOfConditionSetInRule
	      * @returns {___anonymous9143_9151}
	      */
			     
	     function addConditionToConditionSet(conditionSetID,indexOfRule, indexOfConditionSetInRule) {
	    	 
	    		var newConditionID = conditionSetID + "C" + rules[indexOfRule].conditionSets[indexOfConditionSetInRule].conditions.length;
				
				var condition = null;
				
				if(isProcess) {
					condition = document.getElementById("ruleAddConditionProcess").cloneNode(true);
					rules[indexOfRule].conditionSets[indexOfConditionSetInRule].conditions.push({
						'id': newConditionID,
						'field' : condition.getElementsByClassName('conditionFieldProcess')[0].value,
						'type' : "String",	
						'operator' : condition.getElementsByClassName('conditionOperatorProcess')[0].value,
						'value' : condition.getElementsByClassName('conditionValueProcess')[0].value ,
						'caseSensitive' : false
					});
					
					

				} else if(isJSP) {
					condition = document.getElementById("ruleAddConditionJSP").cloneNode(true);
					rules[indexOfRule].conditionSets[indexOfConditionSetInRule].conditions.push({
						'id': newConditionID,
						'field' : condition.getElementsByClassName('conditionFieldJSP')[0].value,
						'type' : condition.getElementsByClassName('conditionDataTypeJSP')[0].value,	
						'operator' : condition.getElementsByClassName('conditionOperatorJSP')[0].value,
						'value' : condition.getElementsByClassName('conditionValueJSP')[0].value ,
						'caseSensitive' : false
					});
				} else {
				
					condition = document.getElementById("ruleAddCondition").cloneNode(true);
					var select = condition.getElementsByClassName('selectOption1');
					
					select[0].options.length = 0;
					
					// Populate dynamic field names to the Field  Selection				
					var formJsonSize = conditionJSonData.length;
					for(var i = 0 ;i < formJsonSize; i++) {
					
						//alert (conditionJSonData[i].label);
						select[0].options[select[0].options.length] = new Option(conditionJSonData[i].label, conditionJSonData[i].id);
									
					}	
					
					rules[indexOfRule].conditionSets[indexOfConditionSetInRule].conditions.push({
						'id': newConditionID,
						'field' : condition.getElementsByClassName('conditionField')[0].value,
						'type' : condition.getElementsByClassName('conditionDataType')[0].value,	
						'operator' : condition.getElementsByClassName('conditionOperator')[0].value,
						'value' : condition.getElementsByClassName('conditionValue')[0].value ,
						'caseSensitive' : false
					});
					
					
				}
				
				condition.setAttribute("id",newConditionID);
				condition.setAttribute("class","conditions");
				condition.style.display = "block";
				
				return condition;
	     }
		
	     /**
	      * Add Entities to conditionSet  
	      * @param conditionSetID
	      * @param indexOfRule
	      * @param indexOfConditionSetInRule
	      * @returns {___anonymous9143_9151}
	      * @author Abhinay
	      */ 
	     
	     function addEntitiesToConditionSet(conditionSetID, indexOfRule, indexOfConditionSetInRule) {
	    	 
	    	 var newEntityID = conditionSetID + "E" + rules[indexOfRule].conditionSets[indexOfConditionSetInRule].conditions.length;
			
	    	 var entity = document.getElementById("entityAddCondition").cloneNode(true);
	    	 var selectOption1 = entity.getElementsByClassName('selectOption1');
	    	 
	    	 selectOption1[0].options.length = 0;
			
	    	 if(entityNameIdMap === undefined || entityNameIdMap == null || entityNameIdMap.length <= 0){
	    		 return entity; 
	    	 }
			
	    	 var indx = 0;
	    	 
	    	var out='<option value="0">Select Entity Type</option>';
			for (var key in entityNameIdMap){
				out += '<option value="' + key + '" >' + entityNameIdMap[key] + '</option>';
			}
			selectOption1[0].innerHTML=out;
	    	 
	    	 //Add thee selected values to the rule obj
	    	 var isCaseSensitive = entity.getElementsByClassName('entityDataType')[0].value == "String" ? true : false;
	    	 rules[indexOfRule].conditionSets[indexOfConditionSetInRule].conditions.push({
					'id': newEntityID,
					'componentType':'Entity',
					'field' : entity.getElementsByClassName('selectOption4')[0].value,
					'EntityType' : entity.getElementsByClassName('entityField')[0].value,	
					'type' : entity.getElementsByClassName('entityDataType')[0].value,
					'operator' : entity.getElementsByClassName('entityOperator')[0].value,
					'value' : entity.getElementsByClassName('entityValue')[0].value ,
					'caseSensitive' : isCaseSensitive
				});	    	 
	    	 
	    	 entity.setAttribute("id",newEntityID);
	    	 entity.setAttribute("class","conditions");
	    	 entity.style.display = "block";
			
	    	 return entity ;
	     }
	     
	     /**
	      * Add Role to conditionSet  
	      * @param conditionSetID
	      * @param indexOfRule
	      * @param indexOfConditionSetInRule
	      * @returns {___anonymous9143_9151}
	      * @author Abhinay
	      */
	     function addRolesToConditionSet(conditionSetID, indexOfRule, indexOfConditionSetInRule) {
	    	 
	    	 var newRoleID = conditionSetID + "R" + rules[indexOfRule].conditionSets[indexOfConditionSetInRule].conditions.length;
			
	    	 var role = document.getElementById("roleAddCondition").cloneNode(true);
	    	 var selectOption3 = role.getElementsByClassName('selectOption3');
	    	 
	    	 selectOption3[0].options.length = 0;
			
	    	 if(roleNameIdMap === undefined || roleNameIdMap == null || roleNameIdMap.length <= 0){
	    		 return role; 
	    	 }
			
	    	 var indx = 0;
	    	 
    		var out='<option value="0">Select Role</option>';
			for (var key in roleNameIdMap){
				out += '<option value="' + roleNameIdMap[key].id + '" >' + roleNameIdMap[key].name + '</option>';
			}
			selectOption3[0].innerHTML=out;
	    	 
	    	 //Add thee selected values to the rule obj
	    	 rules[indexOfRule].conditionSets[indexOfConditionSetInRule].conditions.push({
					'id': newRoleID,
					'componentType':'Role',
					'field' : role.getElementsByClassName('selectOption2')[0].value,
					'type' : role.getElementsByClassName('roleDataType')[0].value,
					'operator' : role.getElementsByClassName('roleOperator')[0].value,
					'value' : role.getElementsByClassName('selectOption3')[0].value
				});	    	 
	    	 
	    	 role.setAttribute("id",newRoleID);
	    	 role.setAttribute("class","conditions");
	    	 role.style.display = "block";
			
	    	 return role;
	     }
	     
	     /**
	      * prepares multiselect drop down for condition drops
	      */
	     function getSelectValues(select) {
	    	  var result = [];
	    	  var options = select && select.options;
	    	  var opt;
	    	  for (var i=0, iLen=options.length; i<iLen; i++) {
	    	    opt = options[i];
	    	    if (opt.selected) {
	    	      result.push(opt.value);
	    	    }
	    	  }
	    	  return result.join();
	    }
	     
	    /**
	     * prepares multiselect drop down for condition drops
	     */
	    function setSelectValues(select,values) {
	    	  var options = select && select.options;
	    	  if(options!=undefined){
	    		  var valuesArray=values.split(',');
	    		  select.setAttribute('multiple','multiple');
		    	  select.setAttribute('size','4');
		    	  for (var i=0, iLen=options.length; i<iLen; i++) {
		    	    if(valuesArray.includes(options[i].value)){
		    	    	options[i].selected='true';
		    	    } 	
		    	  }  
	    	  }
	  
	    }
	     
		assignListeners();
		
		document.getElementById("conditionSets").addEventListener("drop",handleDropForConditionSets,false);
		document.getElementById("conditions").addEventListener("drop",handleDropForConditions,false);
		
		document.getElementById("draggableConditionSet").addEventListener('dragstart', handleDragStartForConditionSet,false);
		document.getElementById("draggableCondition").addEventListener('dragstart', handleDragStartForCondition,false);
		document.getElementById("draggableEntity").addEventListener('dragstart', handleDragStartForEntities,false);
		document.getElementById("draggableRole").addEventListener('dragstart', handleDragStartForRoles,false);
		
		/**
		 * This function populates the JSON data in Condition Sets and conditions
		 */		
		function populateOperator(dataTypeField) {
			
			var selectedDataType = dataTypeField.value;
			
			var operatorSelectElement = dataTypeField.parentElement.getElementsByClassName('operator')[0];
			var conditionSelectElement = dataTypeField.parentElement.getElementsByClassName('selectOption3')[0];

			if(conditionSelectElement!= undefined && conditionSelectElement.hasAttribute('multiple')){
				conditionSelectElement.value="";
				conditionSelectElement.removeAttribute('multiple');
				conditionSelectElement.removeAttribute('size');
			}
				
			
			var indexOfSelectedDataType = dataTypesOperators.findIndex(function(obj){
				return obj.dataTypeName === selectedDataType;
			});

			/**
			 * clear the option
			 */ 
			operatorSelectElement.options.length = 0;
			
			// populate from the json
			var dataTypeOpLength = dataTypesOperators[indexOfSelectedDataType].operator.length;
			for(var i = 0 ;i < dataTypeOpLength; i++) {	
				operatorSelectElement.options[operatorSelectElement.options.length] = new Option(dataTypesOperators[indexOfSelectedDataType].operator[i].label,dataTypesOperators[indexOfSelectedDataType].operator[i].value);
			}			
						
			var condition = findCondition(dataTypeField);
			
			condition.type    =  selectedDataType;
			condition.operator    =  dataTypesOperators[indexOfSelectedDataType].operator[0].value;
		}
		
		
		function findCondition(element) {
			
			var conditionElement = element;
			while(conditionElement.getAttribute("class") !== 'conditions') {
				
				conditionElement = conditionElement.parentElement;
			}
			
			var conditionId = conditionElement.id;
			var conditionSetId = conditionElement.parentElement.parentElement.id;
			var RuleSetId = conditionElement.parentElement.parentElement.parentElement.parentElement.id;
			
			// find the element in Data Json and update the value
			var indexOfRuleSet = rules.findIndex(function(obj){
				return obj.id === RuleSetId;
			});
			
			var indexOfConditionSetInRuleSet = rules[indexOfRuleSet].conditionSets.findIndex(function(obj){
				return obj.id === conditionSetId;
			});
			
			var indexOfConditionInConditionSet = rules[indexOfRuleSet].conditionSets[indexOfConditionSetInRuleSet].conditions.findIndex(function(obj){
				return obj.id === conditionId;
			});
	
			
			return rules[indexOfRuleSet].conditionSets[indexOfConditionSetInRuleSet].conditions[indexOfConditionInConditionSet];
			
		}
		
		/**
		 * Fired when condtion value is changed
		 * @param event
		 */
		function conditionValueChanged(event){
			
			var conditionToChange = findCondition(event.target);
			if(event.target.multiple) {
				conditionToChange.value = [];
				var options = event.target.options;
				for(var i =0;i<options.length;i++) {
					if(options[i].selected) {
						conditionToChange.value.push(options[i].value);
					}
				}
			} else if(event.target.type === "checkbox") {
				if(conditionToChange.value.constructor !== Array) {
					conditionToChange.value = [];
				}
				
				
				if(event.target.checked) {
					conditionToChange.value.push(event.target.value);
				} else {
					conditionToChange.value.pop(event.target.value);
				}
				
				
			}else {
			
				conditionToChange.value = event.target.value;
			}
			
		}
		
		/**
		 * 
		 * @param event
		 */
		function conditionOthersFieldChanged(event){
			
			var conditionToChange = findCondition(event.target);
			conditionToChange.field = event.target.value;
			
		}

		/**
		 * fires when entity field changes
		 * @param event
		 */
		function entityOthersFieldChanged(event){
			
			var conditionToChange = findCondition(event.target);
			conditionToChange.type = event.target.value;
			
			//populate operator drop down
			populateOperator(event.target);
			
		}
		
		/**
		 * Fires when condition operator changes
		 * @param event
		 */ 
		function conditionOperatorChanged(event){
			
			var conditionToChange = findCondition(event.target);
			conditionToChange.operator = event.target.value;
			
			var selectedOperatorVal = event.target.value;
			var selectElement = event.target.parentElement.getElementsByClassName('selectOption3')[0];
			var inputElement = event.target.parentElement.getElementsByClassName('conditionValue')[0]===undefined ? event.target.parentElement.getElementsByClassName('entityValue')[0] :event.target.parentElement.getElementsByClassName('conditionValue')[0] ;
			
			//checks type of operator and changes select element accordingly
			if(selectedOperatorVal==='in' || selectedOperatorVal==='notin'){
				if(selectElement){
					selectElement.setAttribute('multiple','multiple');
					selectElement.setAttribute('size','4');
				}else{
					if(event.target.parentElement.getElementsByClassName('conditionField')[0]!= undefined ){
						generateField(event.target.parentElement.getElementsByClassName('conditionField')[0]);
					}else if(event.target.parentElement.getElementsByClassName('selectOption4')[0]){
						var fieldId = event.target.parentElement.getElementsByClassName('selectOption4')[0].value;
						var fieldElemen = event.target;
						if(fieldElemen && fieldId)
							regenerateDropDown(fieldElemen, fieldId); //if values change, rebuild drop down	
					}
					
					selectElement = event.target.parentElement.getElementsByClassName('selectOption3')[0];
					selectElement.setAttribute('multiple','multiple');
					selectElement.setAttribute('size','4');
				}
				
			}else if(selectedOperatorVal==='isEmpty' || selectedOperatorVal==='isNotEmpty'){ // to remove element on any selection of any of these values
				if(selectElement){
					var conditionToChange = findCondition(selectElement);
					event.target.parentElement.removeChild(selectElement);
					conditionToChange.value="";
				}
					
				else if(inputElement){
					var conditionToChange = findCondition(inputElement);
					conditionToChange.value="";
					event.target.parentElement.removeChild(inputElement);
				}
					
				
			}else{
				if(event.target.parentElement.getElementsByClassName('conditionField')[0]!= undefined ){ //for condition
					generateField(event.target.parentElement.getElementsByClassName('conditionField')[0]);
				}else if(event.target.parentElement.getElementsByClassName('selectOption4')[0]){ //for entity
					var fieldId = event.target.parentElement.getElementsByClassName('selectOption4')[0].value;
					var fieldElemen = event.target;
					if(fieldElemen && fieldId)
						regenerateDropDown(fieldElemen, fieldId);
				}
				
				if(selectElement && selectElement.hasAttribute('multiple')){
					selectElement.removeAttribute('multiple');
					selectElement.removeAttribute('size');
				}
				
			}
			
			
		}
		
		
		/**
		 * Retrieves Entity list on field change,populates drop down
		 * @param event
		 * @author Abhinay
		 */
		function fieldChanged(event){
			var conditionToChange = findCondition(event.target);
			conditionToChange.field = event.target.value;
			
			var fieldId= event.target.value;
			regenerateDropDown(event.target,fieldId);
		}
		
		/**
		 * Creats drop down based on Entity field selected 
		 * @param fieldElemen
		 * @param fieldId
		 * @param entityVal
		 * @author Abhinay
		 */
		function regenerateDropDown(fieldElemen,fieldId,entityVal){
			var entityList=null;
			var type=null;
			if(entityFieldData==null)
				return;
			for(var idx=0;idx<entityFieldData.length;idx++){
				if(entityFieldData[idx].id===fieldId){
					entityList=entityFieldData[idx].values;
					type = entityFieldData[idx].type;
				}
					
			}
			
			var out='<option value="0">Select Entity</option>';
			var element="";
			if(type==='select'){
				var entityInput = fieldElemen.parentElement.getElementsByClassName('entityValue')[0];
				if(entityInput && entityInput.type==='text')
					fieldElemen.parentElement.removeChild(entityInput);
				
				var entitySelect=fieldElemen.parentElement.getElementsByClassName('selectOption3')[0];
				if(entitySelect===undefined){
					element = document.createElement("select");
			    	element.setAttribute("class",'inputField entityValue selectOption3');
			    	element.setAttribute("onchange","entityChanged(this)");
			    	fieldElemen.parentElement.appendChild(element);
				}else{
					element=entitySelect;
				}
				
				for(var idx=0;idx<entityList.length;idx++){
					out += '<option value="' + entityList[idx].prodId + '" >' + entityList[idx].prodName + '</option>';
				}
				element.innerHTML=out;
			}else{
				var entitySelect = fieldElemen.parentElement.getElementsByClassName('selectOption3')[0];
				if(entitySelect)
					fieldElemen.parentElement.removeChild(entitySelect);
			
				var entityInput = fieldElemen.parentElement.getElementsByClassName('entityValue')[0];
				if(entityInput && entityInput.type==='text')
					element=entityInput;
				else{
					element=document.createElement("input");
					element.setAttribute("class",'inputField entityValue');
					element.setAttribute("onchange","entityChanged(this)");
					element.type='text';
					fieldElemen.parentElement.appendChild(element);
				}
				
			}
			
			if(entityVal != undefined ){
				if(element != "" && type==="select" && (element.parentElement.getElementsByClassName('entityOperator')[0].value==='in' || element.parentElement.getElementsByClassName('entityOperator')[0].value==='notin')){
					setSelectValues(element, entityVal);
				}else{
					element.value=entityVal;
				}
			}
		}
		
		function entityChanged(fieldElement){
			var conditionToChange = findCondition(fieldElement);
			if(fieldElement.parentElement.getElementsByClassName('selectOption3')[0]!=undefined){
				conditionToChange.value = getSelectValues(fieldElement);
			}else{
				conditionToChange.value = fieldElement.value;
			}
			
			
		}
		
		function roleChanged(fieldElement){
			
			var conditionToChange = findCondition(fieldElement);
			conditionToChange.value = getSelectValues(fieldElement);
		}
		/**
		 * 
		 * @param event
		 * Creates the input fields based on the HTML Schema recieved
		 */
		
		function generateField(fieldElement) {
			
			var selectedField = fieldElement.value;
			var typeOfField;
			if(isForm || isProcess) {
				
					// first remove the existing inputField
					var dynamicInputField = fieldElement.parentElement.getElementsByClassName('inputField')[0];
					if(dynamicInputField)
						fieldElement.parentElement.removeChild(dynamicInputField);
				
					if(isForm) {
						
					
							var indexOfSelectedField = conditionJSonData.findIndex(function(obj){
								return obj.id === selectedField;
							});
							
							
							typeOfField = conditionJSonData[indexOfSelectedField].component;
							
							
							var element = document.createElement("input");
					    	element.setAttribute("class",'inputField conditionValue');
					    	
					    	    	
							switch(typeOfField) {
									case 'nameInput':
								    case 'textInput':
								    	element.type = 'text';
								    	break;
								    	
								    case 'radio':
								    	
								    	element = document.createElement("fieldset");
								    	element.setAttribute("class",'inputField conditionValue');
								    			    	
								    	var optionSize = conditionJSonData[indexOfSelectedField].options.length;
										
								    	var conditionElement = fieldElement.parentElement;
										while(conditionElement.getAttribute("class") !== 'conditions') {
											
											conditionElement = conditionElement.parentElement;
										}
										
								    	for(var i = 0 ;i < optionSize; i++) {
								    		
								    		var inputElement = document.createElement("input");
								    		
								    		inputElement.setAttribute("type", "radio");
								    		inputElement.setAttribute("value", conditionJSonData[indexOfSelectedField].options[i]);
								    		inputElement.setAttribute("name", conditionElement.id + "radio");
								            
								            element.appendChild(inputElement);
								    		
								    		element.innerHTML += conditionJSonData[indexOfSelectedField].options[i];								
										}	
						
								    	break;
								    	
								    case 'checkbox':
								    	
										element = document.createElement("fieldset");
								    	element.setAttribute("class",'inputField conditionValue');
								    	
								    	
								    	var optionSize = conditionJSonData[indexOfSelectedField].options.length;
										
								    	var size = 0;
								    	
								    	for(var i = 0 ;i < optionSize; i++) {
								    		
								    		var inputElement = document.createElement("input");
								    		
								    		inputElement.setAttribute("style", "width:" + conditionJSonData[indexOfSelectedField].options[i].length + 30 + "px;");
								    		inputElement.setAttribute("type", "checkbox");
								    		inputElement.setAttribute("value", conditionJSonData[indexOfSelectedField].options[i]);
								    		inputElement.setAttribute("name", "checkbox");
								            
								            element.appendChild(inputElement);
								    		
								    		element.innerHTML += conditionJSonData[indexOfSelectedField].options[i];
								    		
								    		
								    		size = size + conditionJSonData[indexOfSelectedField].options[i].length + 30;
										}	
								    	
								    	
								    	element.setAttribute("style", "width:" + size +"px");
								    	break;
								    	
								    	
								    case 'select':
								    	
								    	element = document.createElement("select");
								    	element.setAttribute("class",'inputField conditionValue selectOption3');	
								    	
								    	element.options = [];
								    	
								    	element.options[element.options.length] = new Option("", "");
								    	
								    	var optionSize = conditionJSonData[indexOfSelectedField].optionlist.length;
										for(var i = 0 ;i < optionSize; i++) {
										
											element.options[element.options.length] = new Option(conditionJSonData[indexOfSelectedField].optionlist[i].Text, conditionJSonData[indexOfSelectedField].optionlist[i].Value);								
										}	
								    	
								    	break;
								    	
								    case 'multipleselect':
								    	
								    	element = document.createElement("select");
								    	element.setAttribute("class",'inputField conditionValue');
								    	element.setAttribute("multiple", true);
								    	
								    	element.options = [];
								    	
								    	var optionSize = conditionJSonData[indexOfSelectedField].optionlist.length;
										for(var i = 0 ; i < optionSize; i++) {
										
											element.options[element.options.length] = new Option(conditionJSonData[indexOfSelectedField].optionlist[i].Text, i);								
										}
								    	
								    	
								    	break;  
								    	
								    case 'fileupload':
								    	element.type = 'file';
								    	
								    	break;  
								    	
								    case 'textArea':
								    	element = document.createElement("textarea");
								    	element.setAttribute("class",'inputField conditionValue');
								    	break; 
								    	
								    default:
								    	break;
							}
					} else {// comes here in case of process
						   var dynamicFieldElementForOther = fieldElement.parentElement.getElementsByClassName('conditionOthersField')[0];
						   if(dynamicFieldElementForOther) {
							   fieldElement.parentElement.removeChild(dynamicFieldElementForOther);
							   
						   }
						   
							switch(selectedField) {
									case 'Status':
										var element = document.createElement("select");
								    	element.setAttribute("class",'inputField conditionValueProcess');	
								    	
								    	element.options = [];
								    	
								    	element.options[element.options.length] = new Option("Approved", "Approved");
								    	element.options[element.options.length] = new Option("Rejected", "Rejected");
								    	element.options[element.options.length] = new Option("Pending", "Pending");
								    	findCondition(fieldElement).value = 'Approved';	
										break;
								    case 'StatusType':
								    	var element = document.createElement("input");
								    	element.setAttribute("class",'inputField conditionValueProcess');
								    	element.type = 'text';
								    	break;
								    case 'Others':
								    	var element = document.createElement("input");
								    	element.setAttribute("class",'fieldName conditionOthersField');
								    	element.type = 'text';
								    	element.addEventListener("change",conditionOthersFieldChanged,false);
								    	fieldElement.parentElement.insertBefore(element, fieldElement.parentElement.children[2]);
								    	
								    	
								    	element = document.createElement("input");
								    	element.setAttribute("class",'inputField conditionValueProcess');
								    	element.type = 'text';
								    	break;
								    	
								    case 'signedin':
								    	var element = document.createElement("select");
								    	element.setAttribute("class",'inputField conditionValueProcess');	
								    	
								    	element.options = [];
										element.options[element.options.length] = new Option("False", "false");
								    	element.options[element.options.length] = new Option("True", "true");
								    	
								    		
										findCondition(fieldElement).value = 'false';
										findCondition(fieldElement).type = 'Boolean';
								    	break;
								    	
								    case 'firstLogin':
								    	var element = document.createElement("select");
								    	element.setAttribute("class",'inputField conditionValueProcess');	
								    	
								    	element.options = [];
										element.options[element.options.length] = new Option("False", "false");
								    	element.options[element.options.length] = new Option("True", "true");
								    	
								    		
										findCondition(fieldElement).value = 'false';
										findCondition(fieldElement).type = 'Boolean';
								    	break;
								    default:
								    	break;
							}
						
						
					}
						    
					element.addEventListener("change",conditionValueChanged,false);
					fieldElement.parentElement.appendChild(element); 	
			}
			
		    var condition = findCondition(fieldElement) ;
		    condition.field = selectedField;
		    
		    return typeOfField;
   	
		}

		//Data table Publish rule
		function publishRule(){
			
			alert("Publish Successful");
		}
		
		//Data table Delete rule
		function deleteRule(){
			
			alert("Delete Successful");
		}
		
		/**
		 * Builds form from saved rules 
		 * @param rulesRetrieved
		 */	
		function redrawForm(rulesRetrieved) {
			var ruleId = 'RuleSet';
			for (var i=0; i < rulesRetrieved.length; i++){
				// Already present so we do not have to add rule first time
				if(i !== 0) {
					ruleId = addNewRuleToRuleSet(rulesRetrieved[i].ruleName,rulesRetrieved[i].ruleId);
					
				} else {
					(document.getElementById("RuleSet").getElementsByClassName('ruleName')[0]).value = rulesRetrieved[i].ruleName;
					rules[0].name = rulesRetrieved[i].ruleName;
					rules[0].DBId = rulesRetrieved[i].ruleId;
				}
				
				var ruleSetElement = document.getElementById(ruleId) ;
				var conditionSetArray = JSON.parse(rulesRetrieved[i].definition);//Here entity's and condition's rules are set to conditionSetArray.
				var rulesDropArea = ruleSetElement.getElementsByClassName('conditionSets')[0];
				
				for( var csIndex = 0; csIndex < conditionSetArray.length; csIndex++) {
					// Add New condition Set to rule
					var conditionSet = AddNewConditionSetToRule(ruleId,i);

					rulesDropArea.insertBefore(conditionSet,rulesDropArea.getElementsByClassName("D&DTextCondSet")[0]);
					
					var CSDropArea = conditionSet.getElementsByClassName('conditions')[0];
					
					//Snippet to insert condition/entity in conditionset
					var conditionObj = null, condition = null;
					
					for( var condIndex = 0; condIndex < conditionSetArray[csIndex].length; condIndex++) {
						// Add new condtion to condition Set
						conditionObj = conditionSetArray[csIndex][condIndex];
						if(conditionObj.hasOwnProperty('componentType')){
							if(conditionObj.componentType==='Entity')
								condition=addEntitiesToConditionSet(conditionSet.getAttribute("id"),i,csIndex);
							else
								condition=addRolesToConditionSet(conditionSet.getAttribute("id"),i,csIndex);
						}else{
							condition = addConditionToConditionSet(conditionSet.getAttribute("id"),i,csIndex)
						}
						
						CSDropArea.insertBefore(condition,CSDropArea.getElementsByClassName("D&DTextCond")[0]);
						setconditionValues(condition,conditionObj);
					}
				}
			}
		}
			
		/**
		 * Sets values for condition
		 * @param conditionElement
		 * @param conditionObj
		 */
		function setconditionValues(conditionElement, conditionObj) {
						
			var conditionElementInJson = findCondition(conditionElement);
			
			conditionElementInJson.field = conditionObj.field;
			conditionElementInJson.type = conditionObj.type;
			conditionElementInJson.value = conditionObj.value;
			
			if(conditionObj.hasOwnProperty('componentType')){
				if(conditionObj.componentType==='Entity'){
					conditionElementInJson.componentType = conditionObj.componentType;
					conditionElementInJson.EntityType = conditionObj.EntityType;
					
					//display the selected values of drop-down
					(conditionElement.getElementsByClassName('entityField')[0]).value = conditionObj.EntityType;
					(conditionElement.getElementsByClassName('entityDataType')[0]).value = conditionObj.type;
					 populateOperator(conditionElement.getElementsByClassName('entityDataType')[0]);
					(conditionElement.getElementsByClassName('entityOperator')[0]).value = conditionObj.operator;
					 conditionElementInJson.operator = conditionObj.operator;
					 
					 //Populate entities...
					var fieldElement = conditionElement.getElementsByClassName('entityField')[0];
					var entityElement = conditionElement.getElementsByClassName('selectOption4')[0];
					//var entitySelectElement = conditionElement.getElementsByClassName('entityValue')[0];
					retriveEntityFields(fieldElement,conditionObj.field,conditionObj.value);
					
					//remove last child if operator is [ isEmpty or isNotEmpty ]
					 if(conditionObj.operator==="isEmpty" || conditionObj.operator==="isNotEmpty")
						 conditionElement.getElementsByClassName('entityValue')[0].remove();
					return;
					
				}else if(conditionObj.componentType==='Role'){
					conditionElementInJson.componentType = conditionObj.componentType;
					//display the selected values of drop-down
					(conditionElement.getElementsByClassName('selectOption2')[0]).value = conditionObj.field;
					(conditionElement.getElementsByClassName('roleDataType')[0]).value = conditionObj.type;
					 populateOperator(conditionElement.getElementsByClassName('roleDataType')[0]);
					(conditionElement.getElementsByClassName('roleOperator')[0]).value = conditionObj.operator;
					 conditionElementInJson.operator = conditionObj.operator;
		
					//Populate roles...
					var fieldElement = conditionElement.getElementsByClassName('roleField')[0];
					var roleElement = conditionElement.getElementsByClassName('selectOption3')[0];
					if(roleElement.parentElement.getElementsByClassName('roleOperator')[0].value==='in' || roleElement.parentElement.getElementsByClassName('roleOperator')[0].value==='notin'){
						setSelectValues(roleElement, conditionObj.value);
					}	
					else
						roleElement.value=conditionObj.value;
					
					//remove last child if operator is [ isEmpty or isNotEmpty ]
					 if(conditionObj.operator==="isEmpty" || conditionObj.operator==="isNotEmpty")
						 conditionElement.getElementsByClassName('selectOption3')[0].remove();
					
					return;
				}
				
			}
			
			if(isForm) {
				(conditionElement.getElementsByClassName('conditionField')[0]).value = conditionObj.field;
				(conditionElement.getElementsByClassName('conditionDataType')[0]).value = conditionObj.type;
				populateOperator(conditionElement.getElementsByClassName('conditionDataType')[0]);
				(conditionElement.getElementsByClassName('conditionOperator')[0]).value = conditionObj.operator;
				conditionElementInJson.operator =conditionObj.operator;
				
				var typeOfField = generateField(conditionElement.getElementsByClassName('conditionField')[0]);
				switch(typeOfField) {
					case 'nameInput':
					case 'textInput':
					case 'textArea':
					case 'select':
						var selectElement =conditionElement.getElementsByClassName('conditionValue')[0];
						if(selectElement.parentElement.getElementsByClassName('conditionOperator')[0].value==='in' || selectElement.parentElement.getElementsByClassName('conditionOperator')[0].value==='notin')
							setSelectValues(selectElement, conditionObj.value);
						else
							selectElement.value = conditionObj.value;
						break;
					case 'radio' :
						(conditionElement.getElementsByClassName('conditionValue')[0]).value = conditionObj.value;
						var listofRadio = (conditionElement.getElementsByClassName('conditionValue')[0]).getElementsByTagName('input');
						for(var i = 0 ;i<listofRadio.length;i++) {
							if(listofRadio[i].value === conditionObj.value) {
								listofRadio[i].checked = true;
							}
						}
						break;
					case 'multipleselect' :
						var options = (conditionElement.getElementsByClassName('conditionValue')[0]).options;
						for(var i = 0 ;i<options.length;i++) {
							if(conditionObj.value.indexOf(options[i].value) !== -1) {
								options[i].selected = true;
							}
						}
						break;	
					case 'checkbox' :
						var listofCB = (conditionElement.getElementsByClassName('conditionValue')[0]).getElementsByTagName('input');
						for(var i = 0 ;i<listofCB.length;i++) {
							if(conditionObj.value.indexOf(listofCB[i].value) !== -1) {
								listofCB[i].checked = true;
							}
						}
						break;
			    	
				}
				
			} else if(isJSP) {
				(conditionElement.getElementsByClassName('conditionFieldJSP')[0]).value = conditionObj.field;
				(conditionElement.getElementsByClassName('conditionDataTypeJSP')[0]).value = conditionObj.type;
				(conditionElement.getElementsByClassName('conditionOperatorJSP')[0]).value = conditionObj.operator;
				(conditionElement.getElementsByClassName('conditionValueJSP')[0]).value = conditionObj.value;	
				conditionElementInJson.operator =conditionObj.operator;
			} else {
				if(conditionObj.field === 'Status' || conditionObj.field === 'StatusType' || conditionObj.field === 'signedin' || conditionObj.field === 'firstLogin') {
					(conditionElement.getElementsByClassName('conditionFieldProcess')[0]).value = conditionObj.field;
					generateField(conditionElement.getElementsByClassName('conditionFieldProcess')[0]);
				} else{
					(conditionElement.getElementsByClassName('conditionFieldProcess')[0]).value = "Others";
					generateField(conditionElement.getElementsByClassName('conditionFieldProcess')[0]);
					(conditionElement.getElementsByClassName('conditionOthersField')[0]).value = conditionObj.field;
				}
				
				(conditionElement.getElementsByClassName('conditionOperatorProcess')[0]).value = conditionObj.operator;
				(conditionElement.getElementsByClassName('conditionValueProcess')[0]).value = conditionObj.value;
				conditionElementInJson.operator =conditionObj.operator;
			}
			
			//remove last child if operator is [ isEmpty or isNotEmpty ]
			 if(conditionObj.operator==="isEmpty" || conditionObj.operator==="isNotEmpty")
				 conditionElement.getElementsByClassName('conditionValue')[0].remove();
		}
		
		function setRuleName(event) {
			
			var ruleName = event.target.value;
			var ruleID = event.target.parentElement.parentElement.getAttribute("id");
			
			for(var i=0;i < rules.length;i++) {
				if(rules[i].id === ruleID) {
					
					rules[i].name = ruleName;
					
				}
				
			}
		}
		
		function deleteCondition(obj) {
			
			//var conditionElement = obj.parentElement.parentElement;
			var conditionElement = obj;
			while(conditionElement.getAttribute("class") !== 'conditions') {
				
				conditionElement = conditionElement.parentElement;
			}
			
			var conditionId = conditionElement.id;
			var conditionSetId = conditionElement.parentElement.parentElement.id;
			var RuleSetId = conditionElement.parentElement.parentElement.parentElement.parentElement.id;
			
			// find the element in Data Json and uupdate the value
			
			var indexOfRuleSet = rules.findIndex(function(obj){
				return obj.id === RuleSetId;
			});
			
			var indexOfConditionSetInRuleSet = rules[indexOfRuleSet].conditionSets.findIndex(function(obj){
				return obj.id === conditionSetId;
			});
			
			var indexOfConditionInConditionSet = rules[indexOfRuleSet].conditionSets[indexOfConditionSetInRuleSet].conditions.findIndex(function(obj){
				return obj.id === conditionId;
			});
			
			 rules[indexOfRuleSet].conditionSets[indexOfConditionSetInRuleSet].conditions.splice(indexOfConditionInConditionSet,1);
			
			
			 conditionElement.remove();
			
		}
	     
		function deleteEntity(obj) {
			
			//var conditionElement = obj.parentElement.parentElement;
			var entityElement = obj;
			while(entityElement.getAttribute("class") !== 'entities') {
				
				entityElement = entityElement.parentElement;
			}
			
			var entityId = entityElement.id;
			var entitySetId = entityElement.parentElement.parentElement.id;
			var RuleSetId = entityElement.parentElement.parentElement.parentElement.parentElement.id;
			
			// find the element in Data Json and uupdate the value
			
			var indexOfRuleSet = rules.findIndex(function(obj){
				return obj.id === RuleSetId;
			});
			
			var indexOfConditionSetInRuleSet = rules[indexOfRuleSet].conditionSets.findIndex(function(obj){
				return obj.id === entitySetId;
			});
			
			var indexOfConditionInConditionSet = rules[indexOfRuleSet].conditionSets[indexOfConditionSetInRuleSet].conditions.findIndex(function(obj){
				return obj.id === entitySetId;
			});
			
			 rules[indexOfRuleSet].conditionSets[indexOfConditionSetInRuleSet].conditions.splice(indexOfConditionInConditionSet,1);
			
			 entityElement.remove();
			
		}
		
		function isValidDropDown(){
			
			var entities = document.getElementsByClassName("selectOption3");
			for (var i = 0; i < entities.length; i++) {
				
				if((getSelectValues(entities[i]) === "" || getSelectValues(entities[i]) === ",") && (entities[i].offsetParent != null)){
					entities[i].style.borderColor = 'red';
					alert('Select some value in the drop-down marked in red.')
					return false;	
				}
			}
			return true;
		}
		
		