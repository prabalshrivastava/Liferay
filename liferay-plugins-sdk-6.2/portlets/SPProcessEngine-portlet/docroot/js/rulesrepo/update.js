


function updateRuleSet() {

	var updatesValues = JSON.parse(getResponse);

	alert(updatesValues[0][0].field);

			var rules = [{
							id:'RuleSet',
							name:'',
							conditionSets :[

										]
							}];

				/**
				 * function to add new rule to the Rule Set
				 */
				function addNewRuleToRuleSet() {

					// first create the New Rule

					// generate the ID for new Rule

					var ruleID = "RuleSet" + rules.length;


					var newRule = document.getElementById("RuleSet2").cloneNode(true);
					newRule.setAttribute("id",ruleID);
					newRule.style.display = 'block';

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

					rules.push({
						'id':ruleID,
						'conditionSets' :[
										]
								});

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
					}

					/**
					 * DRAGGABE object Event Handlers End
					 */

					/**
					 * Drop areas event handlers
					 */

				    function handleDragEnter(e) {
				        event.target.style.border = "1px dotted red";
					}

				    function handleDragOver(e) {
				    	 event.preventDefault();
					}

				    function handleDragLeave(e) {
				    	 event.target.style.border = "";
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

						 if (event.dataTransfer.getData("text") === "CS" && $(event.target).hasClass('conditionSets') ) {

							/**
							 *  get the parent of current drop are and generate dynamic ID
							 */
							var parentID = event.target.parentElement.getAttribute("id");

							var index = rules.findIndex(function(obj) {
								return obj.id === parentID;

							});

							var newConditionSetID = parentID + "CS" + rules[index].conditionSets.length;

							var conditionSet = document.getElementById("conditionSet").cloneNode(true);
							conditionSet.setAttribute("id",newConditionSetID);
							conditionSet.style.display = "block";
							conditionSet.addEventListener("drop",handleDropForConditions,false);

							event.target.appendChild(conditionSet);

							rules[index].conditionSets.push({
										'id':newConditionSetID,
										'conditions':[
										            ]
										}
								);

						 }
				     }

					/**
					 * This method determines the conditions and creates ID's dynamically
					 */

				     function handleDropForConditions(event) {
				    	    event.preventDefault();

							if (event.dataTransfer.getData("text") === "C" && $(event.target).hasClass('conditions')) {

								// get the parent of current drop are and generate dynamic ID
								var conditionSetID = event.target.parentElement.getAttribute("id");
								var ruleID = event.target.parentElement.parentElement.parentElement.getAttribute("id");

								var indexOfRule = rules.findIndex(function(obj) {
									return obj.id === ruleID;


								});

								var indexOfConditionSetInRule = rules[indexOfRule].conditionSets.findIndex(function(obj) {
									return obj.id === conditionSetID;


								});


								var newConditionID = conditionSetID + "C" + rules[indexOfRule].conditionSets[indexOfConditionSetInRule].conditions.length;

								var condition = document.getElementById("ruleAddCondition").cloneNode(true);
								condition.setAttribute("id",newConditionID);
								condition.style.display = "block";


								var select = condition.getElementsByClassName('selectOption1');

								select[0].options.length = 0;

								// Populate dynamic field names to the Field  Selection
								var formJsonSize = conditionJSonData.length;
								for (var i = 0 ;i < formJsonSize; i++) {

									//alert (conditionJSonData[i].label);
									select[0].options[select[0].options.length] = new Option(conditionJSonData[i].label, conditionJSonData[i].id);

								}



								event.target.appendChild(condition);

								rules[indexOfRule].conditionSets[indexOfConditionSetInRule].conditions.push({
									'id': newConditionID,
									'field' : condition.getElementsByClassName('conditionField')[0].value,
									'type' : condition.getElementsByClassName('conditionDataType')[0].value,
									'operator' : condition.getElementsByClassName('conditionOperator')[0].value,
									'value' : condition.getElementsByClassName('conditionValue')[0].value ,
									'caseSensitive' : true
								});

								event.stopPropagation();
							}

				    	}


					assignListeners();

					document.getElementById("conditionSets").addEventListener("drop",handleDropForConditionSets,false);
					document.getElementById("conditions").addEventListener("drop",handleDropForConditions,false);

					document.getElementById("draggableConditionSet").addEventListener('dragstart', handleDragStartForConditionSet,false);
					document.getElementById("draggableCondition").addEventListener('dragstart', handleDragStartForCondition,false);


					/**
					 * This function populates the JSON data in Condition Sets and conditions
					 */
					function populateOperator(event) {

						var selectedDataType = event.value;

						var operatorSelectElement = event.parentElement.getElementsByClassName('operator')[0];

						var indexOfSelectedDataType = dataTypesOperators.findIndex(function(obj) {
							return obj.dataTypeName === selectedDataType;
						});

						/**
						 * clear the option
						 */
						operatorSelectElement.options.length = 0;

						// populate from the json
						var dataTypeOpLength = dataTypesOperators[indexOfSelectedDataType].operator.length;
						for (var i = 0 ;i < dataTypeOpLength; i++) {

							operatorSelectElement.options[operatorSelectElement.options.length] = new Option(dataTypesOperators[indexOfSelectedDataType].operator[i].label, operatorSelectElement.value);
						}



						var condition = findCondition(event);

						condition.type    =  selectedDataType;
						condition.operator    =  dataTypesOperators[indexOfSelectedDataType].operator[0].value;


					}



					function findCondition(event) {

						var conditionId = event.parentElement.parentElement.id;
						var conditionSetId = event.parentElement.parentElement.parentElement.parentElement.id;
						var RuleSetId = event.parentElement.parentElement.parentElement.parentElement.parentElement.parentElement.id;

						// find the element in Data Json and uupdate the value

						var indexOfRuleSet = rules.findIndex(function(obj) {
							return obj.id === RuleSetId;
						});

						var indexOfConditionSetInRuleSet = rules[indexOfRuleSet].conditionSets.findIndex(function(obj) {
							return obj.id === conditionSetId;
						});

						var indexOfConditionInConditionSet = rules[indexOfRuleSet].conditionSets[indexOfConditionSetInRuleSet].conditions.findIndex(function(obj) {
							return obj.id === conditionId;
						});



						return rules[indexOfRuleSet].conditionSets[indexOfConditionSetInRuleSet].conditions[indexOfConditionInConditionSet];

					}


					/**
					 *
					 * @param event
					 * Creates the input fields based on the JSON input fields
					 */
					function generateField(event) {

						var selectedField = event.value;

						var indexOfSelectedField = conditionJSonData.findIndex(function(obj) {
							return obj.id === selectedField;
						});


						var typeOfField = conditionJSonData[indexOfSelectedField].component;

						var dynamicInputField = event.parentElement.getElementsByClassName('inputField')[0];

						event.parentElement.removeChild(dynamicInputField);

						var element = document.createElement("input");
				    	element.setAttribute("class",'inputField conditionValue');


						switch(typeOfField) {
					    case 'textInput':
					    	element.type = 'text';
					    	break;

					    case 'radio':

					    	element = document.createElement("fieldset");
					    	element.setAttribute("class",'inputField');

					    	var optionSize = conditionJSonData[indexOfSelectedField].options.length;

					    	for (var i = 0 ;i < optionSize; i++) {

					    		var inputElement = document.createElement("input");
					    		inputElement.setAttribute("type", "radio");
					    		inputElement.setAttribute("value", conditionJSonData[indexOfSelectedField].options[i]);
					    		inputElement.setAttribute("name", event.parentElement.id + "radio");

					            element.appendChild(inputElement);

					    		element.innerHTML += conditionJSonData[indexOfSelectedField].options[i];
							}

					    	break;

					    case 'checkbox':

							element = document.createElement("fieldset");
					    	element.setAttribute("class",'inputField');


					    	var optionSize = conditionJSonData[indexOfSelectedField].options.length;

					    	var size = 0;

					    	for (var i = 0 ;i < optionSize; i++) {

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
					    	element.setAttribute("class",'inputField');

					    	element.options = [];

					    	var optionSize = conditionJSonData[indexOfSelectedField].options.length;
							for (var i = 0 ;i < optionSize; i++) {

								element.options[element.options.length] = new Option(conditionJSonData[indexOfSelectedField].options[i], i);
							}

					    	break;

					    case 'multipleselect':

					    	element = document.createElement("select");
					    	element.setAttribute("class",'inputField');
					    	element.setAttribute("multiple", true);

					    	element.options = [];

					    	var optionSize = conditionJSonData[indexOfSelectedField].optionlist.length;
							for (var i = 0 ; i < optionSize; i++) {

								element.options[element.options.length] = new Option(conditionJSonData[indexOfSelectedField].optionlist[i].Text, i);
							}


					    	break;

					    case 'fileupload':
					    	element.type = 'file';

					    	break;

					    case 'textArea':
					    	element = document.createElement("textarea");
					    	element.setAttribute("class",'inputField');
					    	break;

					    default:
					    	break;
						}

					    event.parentElement.appendChild(element);


					    //
					    var condition = findCondition(event) ;
					    condition.field = selectedField;

					}

}