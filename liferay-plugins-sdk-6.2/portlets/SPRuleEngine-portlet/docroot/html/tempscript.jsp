
<script>
"use strict";
        
const SPRuleBuilder = function SPRuleBuilder(authToken, containerId, ajaxUrl, namespace, ruleSetId, userInfo, spAuthSite, spAuthSiteAccess) {
	var _authToken = authToken;
	var _containerId= containerId;
	var _ruleSetId= ruleSetId;
	var _ajaxUrl= ajaxUrl;
	var _namespace= namespace;
	var _userInfo= userInfo;
	var _spAuthSite= spAuthSite ? spAuthSite : 0;
	var _spAuthSiteAccess= spAuthSiteAccess ? spAuthSiteAccess : [];
	var _globalKeys= {};  // for holding selected list option values with globalKeys setup
	var _listOptionData= {}; // for holding listoption data {name:name, data:responseData}
	var _API_PARAM_MAP= {}; // info used in listOption url e.g. $[FORM_ID]
	var _ruleBuilderComponent;
	var A = AUI();
	var _ruleSetTypes = {};
	var _loadedRuleSet;
	var _url_data_cache = {};
	var _ruleSetTypeIndex;
	var _loadingRuleCondition;
                
	if (userInfo) {
		_API_PARAM_MAP["USER_ID"] = userInfo.userId;
		_API_PARAM_MAP["USER_EMAIL"] = userInfo.userEmail;
		_API_PARAM_MAP["USER_ROLES"] = userInfo.roles;
		_API_PARAM_MAP["SPAUTH_SITE"] = spAuthSite;
		_API_PARAM_MAP["SPAUTH_SITE_ACCESS"] = spAuthSiteAccess;
		_API_PARAM_MAP["GROUP_ID"] = userInfo.groupId;
		_API_PARAM_MAP["COMPANY_ID"] = userInfo.companyId;
	}

	var _displayMessage = function _displayMessage(type, message, duration) {
		var alert_div = document.getElementById("alert_msg");
		alert_div.innerHTML = message;
		alert_div.className = "";
		alert_div.classList.add("alert-" + type);
		alert_div.classList.add("alert");
		alert_div.style.display = "block";
		setTimeout(function() {
	        alert_div.style.display = "none";
		}, duration);
	};

	var _simulateEvent = function _simulateEvent(node, eventName) {
		AUI().use('aui-node', 'aui-base','node-event-simulate', function(A) {
			node.simulate(eventName);
		});
	};

	var _removeNullId = function _removeNullId(dto, idField) {
		if (dto.hasOwnProperty(idField) && (!dto[idField] || dto[idField]==="0")) {
			delete dto[idField];
		}
	};

	var _setMultiSelectValues = function _setMultiSelectValues (select,values) {
		var options = select && select.options;
// 		console.log("_setMultiSelectValues", select, select.options);
// 		console.log("values",values);
		if(options!=undefined) {
			var valuesArray=values.split(',');
			for (var i=0, iLen=options.length; i<iLen; i++) {
				if(valuesArray.includes(options[i].value)){
				    options[i].selected='true';
				}   
			}
		}
	};

    var genOptionLabelByTemplate = function genOptionLabelByTemplate(data, template) {
        var splitArr = template.split("::");
        var optionTemplate = splitArr[0];
        splitArr[1].split(",").forEach(function (field) {
            optionTemplate = optionTemplate.replace("{}", data[field]);
        });
        return optionTemplate;
    };

	var processListOptionResponse = function processListOptionResponse(selectElement, listOption, response, callback) {
		if (listOption.hasOwnProperty("emptyValueText") && listOption.emptyValueText) {
			var emptyValueText = "";
			if (listOption.emptyValueText !== "_EMPTY_OPTION_") {
				emptyValueText = listOption.emptyValueText;
			}
			if (selectElement) _addOption(selectElement, "", emptyValueText);
		}
		if (response.constructor === Array) {
			response.forEach(function (option) {
				if (selectElement) _addOption(selectElement, option[listOption.listValueField], genOptionLabelByTemplate(option, listOption.listOptionTemplate));
			});
			if (callback) {
				callback(selectElement);
			}
		}
	};

	var _resolveUrl = function _resolveUrl(_url) {
		if (_url.indexOf("$[")>0) { // indicates a globalKey is use in the URL
		     // so replace all globalKeys in the URL
		     Object.keys(_globalKeys).forEach(function(globalKey) {
		    	 _url = _url.replace("$["+globalKey+"]", _globalKeys[globalKey]);
		     });     
		}
		if (_url.toLowerCase().indexOf("http") !== 0) {
		    if (_url.indexOf("?") === -1) {
		    	_url += "?";
		    } else {
		    	_url += "&";
		    }
		    _url += "p_auth=" + _authToken;
		}
		return _url;
	};

	var _addOption = function _addOption(selectComponent, value, text) {
		return new Promise((resolve, reject) => {
		    var o = document.createElement("option");
		    o.value = value;
		    o.text = text;
		    selectComponent.appendChild(o);
		    resolve(selectComponent);
		});
	};

	var _populateSelectOptions = function _populateSelectOptions(selectElement, listOption, optionData, callback) {
		return new Promise((resolve, reject) => {
			if (selectElement) A.one(selectElement).empty();
			if (optionData) {
				processListOptionResponse(selectElement, listOption, optionData, callback);
				resolve(selectElement);
			} else if (listOption.hasOwnProperty("listStaticOptions") && listOption.listStaticOptions) {
				var listStaticOptions = JSON.parse(listOption.listStaticOptions);
				processListOptionResponse(selectElement, listOption, listStaticOptions, callback);
				resolve(selectElement);
			} else {
				var _fetchOptions = async function _fetchOptions() {
// 					console.log('Cache', _url_data_cache);
					var loadUrl = _resolveUrl(listOption.listApiUrl);
					var data = _url_data_cache[loadUrl];
					if (data) {
						console.log('Got data from cache', data);
					} else {
						var response = await fetch(loadUrl);
						data = await response.json();						
						_url_data_cache[loadUrl] = data;
// 						console.log('Request succeeded with JSON response', loadUrl, _url_data_cache[loadUrl]);
					}
					if (selectElement) processListOptionResponse(selectElement, listOption, data, callback);
// 					console.log('_populateSelectOptions resolved', loadUrl);
				}();
			}
		});
	}

	var _preloadBasicListOptions = new Promise((resolve, reject) => {
		try {
			var loadList = ["listOptions", "ruleSetTypes", "booleanList", "logicalOperators", "conditionTypes", "dataTypes", "comparisonOperators"];
			var _loadedOptions = {};
			loadList.forEach(function (listName) {
				SambaashUtils.resourceAction(_ajaxUrl, "fetchListOptionByName", "GET", _namespace, listName,
					function success() {
						var data = this.get("responseData");
// 						console.log("got response", data);
						data.forEach(function (listOption) {
							_loadedOptions[listName] = listOption;
						});
						if (Object.getOwnPropertyNames(_loadedOptions).length == loadList.length) {
// 							console.log("resolved");
							resolve(_loadedOptions);
						}
				});
			});
		} catch (e) {	
			reject(new Error("Error Pre-loading options!"));
		}
	}); 

	var _preloadPropertyListOptions = function _preloadPropertyListOptions(ruleSet) {
		return new Promise((resolve, reject) => {
			var ruleSetData = {ruleSet: ruleSet, cache:{}};
			if (ruleSet) {
				var ruleSetType = _ruleSetTypes[ruleSet.ruleSetTypeId];
				if (ruleSetType.listOption && ruleSetType.listOption.globalKey) {
					_globalKeys[ruleSetType.listOption.globalKey] = ruleSet.componentId;
				}
				var consolidatedListOptions = ruleSet.consolidatedListOptions;
				if (consolidatedListOptions.length > 0) {
					consolidatedListOptions.forEach(function(listOption){
			        	var _fetchOptions = async function _fetchOptions() {
			        		if (listOption.listApiUrl) {
								var loadUrl = _resolveUrl(listOption.listApiUrl);
								var response = await fetch(loadUrl);
								var data = await response.json();			        			
								ruleSetData.cache[loadUrl] = data;
			        		} else {
								ruleSetData.cache[listOption.name] = listOption.listStaticOptions;	
			        		}
//	 						console.log('Pre Load Request succeeded with JSON response', loadUrl, ruleSetData.cache[loadUrl]);
							if (Object.getOwnPropertyNames(ruleSetData.cache).length == consolidatedListOptions.length) {
//	 							console.log("_preloadPropertyListOptions resolved");
								resolve(ruleSetData);
							}
						}();
					});					
				} else {
					resolve(ruleSetData);
				}
			} else {
				// no ruleset loaded
				resolve(ruleSetData);
			}
		});
	}

	var _fetchRuleSetTypes = new Promise((resolve, reject) => {
		SambaashUtils.resourceAction(_ajaxUrl, "fetchRuleSetTypes", "GET", _namespace, null,
			function success() {
				var data = this.get("responseData");
				var ruleSetTypeDropDown = _ruleBuilderComponent.one("#ruleSetTypeId");
				data.forEach(function (ruleSetType) {
				    _ruleSetTypes[ruleSetType.id] = ruleSetType;
				    _addOption(ruleSetTypeDropDown, ruleSetType.id, ruleSetType.displayText);
				});
				resolve(_ruleSetTypes);
		});
	});

	var _fetchRuleSet = new Promise((resolve, reject) => {
			if (_ruleSetId > 0) {
				SambaashUtils.resourceAction(_ajaxUrl, "fetchRuleSet", "GET", _namespace, _ruleSetId,
					function success() {
						_loadedRuleSet = this.get("responseData");
						resolve(_loadedRuleSet);
				});
			} else {
				// nothing to load
				resolve(null);
			}
	});

	var _addChildElement = function _addChildElement(parent, type, name, classList, _label, clearCurrentChildren, listOption, inlineStyle, initialData, callback) {
		if (clearCurrentChildren) {
		    parent.empty();
		}
		if (type !== "NONE" && type !== "BUTTON" && _label) {
			var label = document.createElement("LABEL");
			label.classList.add("control-label");
			label.textContent = _label;
			parent.appendChild(label);
		}

		var child;
		switch (type.toUpperCase()) {
			case "TEXT_INPUT":
			case "INPUT":
				child = document.createElement("INPUT");
				child.setAttribute("type", "text");
				break;
			case "HIDDEN":
				child = document.createElement("INPUT");
				child.setAttribute("type", "hidden");
				break;
			case "ROLE":
			case "PRODUCT":
			case "ENTITY":
			case "SELECT":
				child = document.createElement("SELECT");
				child.classList.add("aui-field-select");
				break;
			case "BUTTON":
				child = document.createElement("BUTTON");
				child.classList.add("btn");
			case "NONE":
			    // no element
			    break;
			default:
			    child = document.createElement(type);
		}
	
		if (child) {
			if (name) {
				child.id = name;
			}
			if (classList) {
				classList.split(" ").forEach(function (clazz) {
					child.classList.add(clazz);
				});
			}
			if (inlineStyle) {
				child.setAttribute("style", inlineStyle);
			}
			var childElement = parent.appendChild(child);
			if ((type.toUpperCase()) === "BUTTON") {
				childElement._node.innerHTML= _label;
			}
			if (listOption) {
				_populateSelectOptions(childElement, listOption, initialData, callback);
				if (listOption.hasOwnProperty("globalKey") && listOption.globalKey) {
					childElement.on("change", function(){
						_globalKeys[listOption.globalKey] = childElement.val();
					});
				}
			} else if(callback) {
				callback(childElement);
			}
			return childElement;
		} else {
			return null;
		}
	}

	var _addFieldElement = function _addFieldElement(parent, type, name, classList, _label, clearCurrentChildren, listOption, inlineStyle, initialData, isTable, callback) {
		var elParent = parent;
		if (isTable) {
			elParent = _addChildElement(elParent, "td", null, null, null, false, null, null);
		}
		var crtlGrp = _addChildElement(elParent, "div", null, "control-group", null, false, null, "display: block;");
		return _addChildElement(crtlGrp, type, name, classList, _label, clearCurrentChildren, listOption, inlineStyle, initialData, callback);
	}

	var _initRuleSetType = function _initRuleSetType(dropDownComponent, callback) {
		var oldIdx = _ruleSetTypeIndex;
		var resetWarning = oldIdx;  // check if there are rules defined
		if (resetWarning && !confirm("Changing the ruleset type will clear all the current rules. Proceed?")) {
			dropDownComponent.selectedIndex = oldIdx;
			return;
		}
		var ruleSetType = _ruleSetTypes[dropDownComponent.value||dropDownComponent.val()];
		var componentIdContainer = _ruleBuilderComponent.one("#componentIdContainer");
		componentIdContainer.empty();
		_ruleBuilderComponent.one("#rulesContainer").empty();
// 		console.log("init rule set type", ruleSetType);
		if (ruleSetType) {
			var compIdElement = _addFieldElement(componentIdContainer, 
			                ruleSetType.inputType, "componentId", "RuleSetDto", 
			                ruleSetType.displayText, true, ruleSetType.listOption, 
			                null, null, null, callback);
		}
		_ruleSetTypeIndex = dropDownComponent.selectedIndex;
	};

	var _initConditionType = function _initConditionType(e, thisInstance, conditionPropertiesContainer, conditionIdElement, callback, ruleCondition) {
		var ruleSetTypeId = A.one("#ruleSetTypeId").val();
		var ruleSetType = _ruleSetTypes[ruleSetTypeId];
		var conditionTypeMap = {};
		var loading = ruleCondition ? true : false;
		ruleSetType.conditionTypes.forEach(function (ct) {
			conditionTypeMap[ct.id] = ct;
		});
	
		conditionPropertiesContainer.empty();
		var conditionType = conditionTypeMap[conditionIdElement.val()];
		if (!conditionType) return;
		var dataTypeElement, operatorElement;
		var condtionDataTypeMap = {};
// 		console.log( "initConditionType => "+loading);
		conditionType.dataTypes.forEach(function (d) {
			condtionDataTypeMap[d.id] = d;
		});
	    
		var orderedProperties = [];
		var propertiesMapTemp = {};
		conditionType.properties.forEach(function (p) {
			propertiesMapTemp[p.name] = p;
		});
	    conditionType.propertiesOrder.split(",").forEach(function (p) {
			orderedProperties.push(propertiesMapTemp[p]);
			delete propertiesMapTemp[p];
	    });
	    // transfer remaining fields that are not listed on the order
	    Object.values(propertiesMapTemp).forEach(function (v) {
			orderedProperties.push(v);
	    });

// 	    console.log("traversing orderedProperties");
	    orderedProperties.forEach(function (p) {
			var listOption = p.hasOwnProperty("listOption") ? p.listOption : null;
			var inputType = p.hasOwnProperty("inputType") ? p.inputType : "INPUT";
			var listOptionData=null;
			if (p.type==="DATA_TYPE") {
			    listOptionData = conditionType.dataTypes;
			    listOption = _listOptionData["dataTypes"];
			}
			var e = _addFieldElement(conditionPropertiesContainer, 
						inputType, p.name, "RuleConditionDto "+p.type, " ", false, 
						listOption, 'max-width: 250px;', listOptionData, true, 
				function(e) {
					if(callback) {
// 						console.log("traversing orderedProperties CALLBACK", p.name, e);
						callback(p.name, e);
					}
			});
			if (p.type==="DATA_TYPE") {
		    	dataTypeElement = e;
			} else if (p.type==="OPERATOR") {
		    	operatorElement = e;
			}
	    });
	    
		dataTypeElement.on('change',function(e) {
			operatorElement.empty();
// 			console.log("dataTypeElement changed");
			var dataType = condtionDataTypeMap[dataTypeElement.val()];			
			var valueElement = dataTypeElement.ancestor("#conditionPropertiesContainer").one(".VALUE2");
			var valFieldName = valueElement.getAttribute("id");
			var valFieldVal = valueElement.val();
			valueElement.ancestor("td").remove();
			if (valueElement && dataType.hasOwnProperty("listOption")) {
				valueElement = _addFieldElement(conditionPropertiesContainer, "SELECT", valFieldName, "RuleConditionDto VALUE2", " ", false, dataType.listOption, null, null, true);
			} else {
				valueElement = _addFieldElement(conditionPropertiesContainer, "INPUT", valFieldName, "RuleConditionDto VALUE2", " ", false, null, null, null, true);
				valueElement.val(valFieldVal);
			}
			_populateSelectOptions(operatorElement, _listOptionData["comparisonOperators"], dataType.operators)
			.then(function(resolvedData) {
// 				console.log("_populateSelectOptions in dataTypeElement change", resolvedData);
				if(callback) {
// 					console.log("_populateSelectOptions callback");
					callback(operatorElement.getAttribute("id"), operatorElement);
				}
				if (loading) {
					_simulateEvent(AUI().one(operatorElement), "change");
				}
			});

		});
	    
		operatorElement.on('change',function(e) {
// 			console.log(">>> operator got changed!");
			var dataType = condtionDataTypeMap[dataTypeElement.val()];
			var selectedOperatorId = e.currentTarget.val();
			var chosenOperator;
			for (var i=0; i<dataType.operators.length; i++) {
				var o = dataType.operators[i];
				if (o.id == selectedOperatorId) {
					chosenOperator = o;
					break;
				}
			}
			var valueElement = dataTypeElement.ancestor("#conditionPropertiesContainer").one(".VALUE2");
			if (valueElement) {
				var isMultiSelect = dataType.listOption && chosenOperator && chosenOperator.multiValue;
				if (isMultiSelect) {
					valueElement.setAttribute("multiple","multiple");
					valueElement.setAttribute("size","4");                                  
					if (loading) {
						var jsonConditionPropertyMap = JSON.parse(ruleCondition.jsonConditionPropertyMap);
						_setMultiSelectValues(valueElement, jsonConditionPropertyMap[valueElement.getAttribute("id")]);
					}
				} else {
					valueElement.removeAttribute("multiple");
					valueElement.removeAttribute("size");
				}
				if (chosenOperator && chosenOperator.unaryOperator) {
			        valueElement.hide();
				} else {
			        valueElement.show();
				}
			}
		});

		if (loading) {
			// trigger dataType change to trigger operator change for multiple values
			_simulateEvent(AUI().one(dataTypeElement), "change");
		}

		if(callback) {
			var dataType = condtionDataTypeMap[dataTypeElement.val()];
			_populateSelectOptions(operatorElement, _listOptionData["comparisonOperators"], dataType.operators, 
				function() {
					if(callback) {
						callback(operatorElement.getAttribute("id"), operatorElement);
					}
			});
			callback("conditionId", conditionIdElement);
		}
	}

	var _addNewRuleCondition = function _addNewRuleCondition(parentRuleConditionSet,ruleCondition) {
		var newRuleDetailRow = _addChildElement(parentRuleConditionSet, "tr", null, "span12 RuleConditionSetDto Collection", null, false, null, null);
		
		var deleteRuleConditionBtnElement = _addFieldElement(newRuleDetailRow, "BUTTON", "deleteRuleConditionBtn", null, "-", false, null, null, null, true);
		deleteRuleConditionBtnElement.on('click',function(e){
			e.preventDefault();
			e.stopPropagation();
			deleteRuleConditionBtnElement.ancestor("tr").remove();
		});
	    
	    _addFieldElement(newRuleDetailRow, "HIDDEN", "ruleConditionId", "RuleConditionDto", null, false, null, null, null, true);
	    _addFieldElement(newRuleDetailRow, "SELECT", "logicalOperator", "RuleConditionDto", " ", false, _listOptionData["logicalOperators"], "width: 60px", null, true);
	    
	    var ruleSetTypeId = AUI().one("#ruleSetTypeId").val();
	    var ruleSetType = _ruleSetTypes[ruleSetTypeId];
	    var conditionIdElement = _addFieldElement(newRuleDetailRow, "SELECT", 
	                    "conditionId", "RuleConditionDto", " ", false, 
	                    _listOptionData["conditionTypes"], null, 
	                    ruleSetType.conditionTypes, true);
		var conditionTypeMap = {};
		ruleSetType.conditionTypes.forEach(function (ct) {
			conditionTypeMap[ct.id] = ct;
		});
	
		var conditionPropertiesContainer = _addChildElement(newRuleDetailRow, "div", "conditionPropertiesContainer", null, null, false, null, "display: contents;");
		conditionIdElement.on('change',_initConditionType, null, null, conditionPropertiesContainer, conditionIdElement);
		return newRuleDetailRow;
	}

	var _addNewRuleConditionSet = function _addNewRuleConditionSet(parentRule) {
		var tbody = _addChildElement(parentRule, "tbody", null, null, null, false, null, "display: inline-block;");
		var newRuleConditionSet = _addChildElement(tbody, "tr", "ruleConditionSets", "RuleDto Collection", null, false, null, "display: inline-block;");
		
		var deleteRuleConditionSetBtnElement = _addFieldElement(newRuleConditionSet, "BUTTON", "deleteRuleConditionSetBtn", null, "-", false, null, null, null, true);
		deleteRuleConditionSetBtnElement.on('click',function(e){
			e.preventDefault();
			e.stopPropagation();
			tbody.remove();
		});
		
		_addFieldElement(newRuleConditionSet, "HIDDEN", "ruleConditionSetId", "RuleConditionSetDto", null, false, null, null, null, true);
		_addFieldElement(newRuleConditionSet, "SELECT", "logicalOperator", "RuleConditionSetDto", " ", false, _listOptionData["logicalOperators"], "width: 60px", null, true);
		
		var newConditionSetElement = _addFieldElement(newRuleConditionSet, "BUTTON", "newConditionSetBtn", null, "Add Condition", false, null, null, null, true);
		newConditionSetElement.on('click',function(e){
			e.preventDefault();
			e.stopPropagation();
			_addNewRuleCondition(newRuleConditionSet.one("#ruleConditions"));
		});
		            
		var rctd = _addChildElement(newRuleConditionSet, "td", null, null, null, false, null, "display: inline-block;");
		_addChildElement(rctd, "table", "ruleConditions", null, null, false, null, "display: inline-block;");
		            
		return newRuleConditionSet;
	}

	var _addNewRuleRow = function _addNewRuleRow() {
		var rulesContainer = _ruleBuilderComponent.one("#rulesContainer");
		
		// rule header
		var newRule = _addChildElement(rulesContainer, "table", "rules", "RuleSetDto Collection", null, false, null, "display: block;");
		var newRuleHeader = _addChildElement(newRule, "thead", null, "span12", null, false, null, null);
		var newRuleHeaderRow = _addChildElement(newRuleHeader, "tr", null, "span12", null, false, null, null);
		var deleteRuleBtnElement = _addFieldElement(newRuleHeaderRow, "BUTTON", "deleteRuleBtn", null, "-", false, null, null, null, true);
		deleteRuleBtnElement.on('click',function(e){
			e.preventDefault();
			e.stopPropagation();
			newRule.remove();
		});
		var ruleId = _addFieldElement(newRuleHeaderRow, "HIDDEN", "ruleId", "RuleDto", null, false, null, null, null, true);
		ruleId.val(0);
		var ruleName = _addFieldElement(newRuleHeaderRow, "INPUT", "ruleName", "RuleDto", "Rule Name", false, null, null, null, true);
		var newConditionSetElement = _addFieldElement(newRuleHeaderRow, "BUTTON", "newConditionSet", null, "Add Condition Set", false, null, null, null, true);
		newConditionSetElement.on('click',function(e){
			e.preventDefault();
			e.stopPropagation();
			_addNewRuleConditionSet(newRule);
		});
		return newRule;
	}

	var _renderRuleSet = function _renderRuleSet() {
		return new Promise((resolve, reject) => {
// 			console.log("inside _renderRuleSet");
			if (_loadedRuleSet) {
				var ruleSetType = _ruleSetTypes[_loadedRuleSet.ruleSetTypeId];
			
				A.all(".RuleSetDto").each(function (field) {
					var fId = field.getAttribute("id");
// 					console.log("==> setting field: ", fId, " = ", _loadedRuleSet[fId]);
					field.val(_loadedRuleSet[fId]); 
					if (fId === "ruleSetTypeId") {
						_initRuleSetType(field, function(e) {
						if (_loadedRuleSet) {
							e.val(_loadedRuleSet.componentId);
							if (ruleSetType.listOption && ruleSetType.listOption.globalKey) {
								_globalKeys[ruleSetType.listOption.globalKey] = e.val();
							}
							_ruleSetTypeIndex = A.one("#ruleSetTypeId").selectedIndex;
						}
						});
					}
				});
			                 
				if (_loadedRuleSet.rules && _loadedRuleSet.rules.length>0) {
					_loadedRuleSet.rules.forEach(function (rule) {
// 						console.log("processing rule ", rule);
						var ruleComp = _addNewRuleRow();
						ruleComp.all(".RuleDto").each(function (_field) {
// 							console.log("Set rule value ",_field.getAttribute("id"),"=",rule[_field.getAttribute("id")]);
							_field.val(rule[_field.getAttribute("id")]);                                        
						});                     
				        if (rule.ruleConditionSets && rule.ruleConditionSets.length>0) {
							rule.ruleConditionSets.forEach(function (ruleConditionSet) {
								var newRuleConditionSet = _addNewRuleConditionSet(ruleComp);
								newRuleConditionSet.all(".RuleConditionSetDto").each(function (_field) {
									_field.val(ruleConditionSet[_field.getAttribute("id")]);                                            
								});             
								if (ruleConditionSet.ruleConditions && ruleConditionSet.ruleConditions.length>0) {
									ruleConditionSet.ruleConditions.forEach(function (ruleCondition) {
// 										console.log("processing rule condition", ruleCondition);
										var newRuleDetailRow = _addNewRuleCondition(newRuleConditionSet.one("#ruleConditions"),ruleCondition);                                                                                                          
										var conditionBasicFields = ["ruleConditionId","logicalOperator", "seq"];
// 										console.log("got rule properties", ruleCondition.jsonConditionPropertyMap);
										var jsonConditionPropertyMap = JSON.parse(ruleCondition.jsonConditionPropertyMap);
				                                        
										var setRuleConditionField = function(field) {
											var fId = field.getAttribute("id");
// 											console.log(ruleCondition.ruleConditionId," => setting rule condition field ",fId," from", jsonConditionPropertyMap);
											if (fId === "conditionId"){
												field.val(jsonConditionPropertyMap["conditionId"]); 
												_initConditionType(null, null, field.ancestor(".RuleConditionSetDto.Collection").one("#conditionPropertiesContainer"), field, function(type, e){
// 													console.log("_initConditionType callback",type,e);
													switch (type) {
														case "conditionId":
															e.val(ruleCondition.ruleConditionId);
															setTimeout(function() {
															var updatedPropertyFields = newRuleDetailRow.all(".RuleConditionDto");
															updatedPropertyFields.each(function (_field) {
															        var propId = _field.getAttribute("id");
// 															        console.log("Setting condition property: "+propId);
																	if (jsonConditionPropertyMap.hasOwnProperty(propId)) {
// 																		console.log(propId+" = "+jsonConditionPropertyMap[propId]);
																		_field.val(jsonConditionPropertyMap[propId]);
// 																			if (_field.hasAttribute("multiple")) {
// 																				console.log("set MULTIPLE values: "+jsonConditionPropertyMap[propId]);
																				_setMultiSelectValues(_field._node, jsonConditionPropertyMap[propId]);
// 																			}
																	}
															});
															}, 1000);
															break;
				                                                        
														default:
															var _field = newRuleDetailRow.one("#"+type);
// 															console.log("Got callback for ->",type,e,_field);
															_field.val(jsonConditionPropertyMap[type]);
															break;
													}
												}, ruleCondition);
											} else if (conditionBasicFields.indexOf(fId) < 0){
// 										        console.log("setting basic : ",fId,"=",jsonConditionPropertyMap[fId]);
												field.val(jsonConditionPropertyMap[fId]);    
											} else {
// 										        console.log("setting rule field : ",fId,"=",ruleCondition[fId]);
												field.val(ruleCondition[fId]);    
				                    		}
	                                	}
										// initial fields (ruleConditionSetId, logicalOperator, seq, conditionId)
										newRuleDetailRow.all(".RuleConditionDto").each(function (_field) {
								        	setRuleConditionField(_field);
										});
									});
		                        }
			                });
				        }
			        });
				}
				resolve(_loadedRuleSet);
			} else {
			    resolve(null);
			}
		});
	}

	var _load = function _load() {
		_ruleBuilderComponent = A.one("#"+_containerId);
		
		var listOptionDataPromise = _preloadBasicListOptions.then(function(options){
// 			console.log("On _preloadBasicListOptions then: ", options);
			return options;
		});
		
		var ruleSetTypesPromise = _fetchRuleSetTypes.then(function(options){
// 			console.log("On _fetchRuleSetTypes then: ", options);
			return options;
		});
		
		// using setTimeout we can postpone the execution of a function to the moment the stack is empty
		setTimeout(() => {
// 		    console.log("listOptionDataPromise on set timeout",listOptionDataPromise);
		    listOptionDataPromise.then((options) => {
		    	_listOptionData = options;
// 		    	console.log("final options", _listOptionData);
	    	});
// 		    console.log("ruleSetTypesPromise on set timeout",ruleSetTypesPromise);
		    ruleSetTypesPromise.then((options) => {
		    	_ruleSetTypes = options;
// 		    	console.log("final ruleset types", _ruleSetTypes);

			    //nested setTimeOut to access pre-loaded data
	    		var ruleSetPromise = _fetchRuleSet
				.then((ruleSet) => _preloadPropertyListOptions(ruleSet))
				.then(function(options){
// 					console.log("On _preloadPropertyListOptions then: ", options);
					return options;
				});
	    		setTimeout(() => {
// 				    console.log("ruleSetPromise on set timeout",ruleSetPromise);
				    ruleSetPromise.then((options) => {
				    	_loadedRuleSet = options.ruleSet;
				    	_url_data_cache = options.cache;
// 				    	console.log("final _loadedRuleSet", _loadedRuleSet);
// 				    	console.log("final _url_data_cache", _url_data_cache);
				    	_renderRuleSet();
			    	});
	    		});
		    	
	    	});
		    
		});
	}

	var _cancelEdit = function _cancelEdit(selectComponent, value, text) {
    	window.location.href = window.location.pathname;
    }

	var _validateAndSubmit = function _validateAndSubmit() {
		var getMultiSelectValues = function (select) {
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
   	 
		var ruleSetDto = {rules:[]};
		var validateError = null;

		// ruleset
		A.all(".RuleSetDto").each(function(rsf) {
			var isCollection = rsf.getAttribute("class").split(" ").indexOf("Collection") >= 0;
			if (isCollection) {
				// ignore collection 
			} else {
				ruleSetDto[rsf.getAttribute("id")] = rsf.val();            		 
			}
		});
		_removeNullId(ruleSetDto, "ruleSetId");

		// each "RuleSetDto Collection" => 1 rule
		A.all(".RuleSetDto.Collection").each(function(rule) {
		 
			var ruleDto = {ruleConditionSets:[]};
			rule.all(".RuleDto").each(function(rf) {
				var isCollection = rf.getAttribute("class").split(" ").indexOf("Collection") >= 0;
				if (isCollection) {
					// ignore collection         		 
				} else {
					ruleDto[rf.getAttribute("id")] = rf.val();            		 
				}                	 
			});
			_removeNullId(ruleDto, "ruleId");
			ruleSetDto.rules.push(ruleDto);
		 
			// each "RuleDto Collection" => 1 rule set condition
			rule.all(".RuleDto.Collection").each(function(rcs) {
				var ruleConditionSetDto = {ruleConditions:[]};
				rcs.all(".RuleConditionSetDto").each(function(rcsf) {
					var isCollection = rcsf.getAttribute("class").split(" ").indexOf("Collection") >= 0;
					if (isCollection) {
						// ignore collection         		 
					} else {
						ruleConditionSetDto[rcsf.getAttribute("id")] = rcsf.val();            		 
					}
				});
				_removeNullId(ruleConditionSetDto, "ruleConditionSetId");
				ruleDto.ruleConditionSets.push(ruleConditionSetDto);
		
				// each "RuleConditionSetDto Collection" => 1 Rule condition
				rcs.all(".RuleConditionSetDto.Collection").each(function(rc) {
					var ruleConditionDto = {};
					var jsonConditionPropertyMap = {};
					rc.all(".RuleConditionDto").each(function(rcf) {
						var isCollection = rcf.getAttribute("class").split(" ").indexOf("Collection") >= 0;
						if (isCollection) {
							// ignore collection         		 
						} else {
							var rcfName = rcf.getAttribute("id");
							if (rcf.hasAttribute("multiple")) {
								jsonConditionPropertyMap[rcfName] = getMultiSelectValues(rcf._node);
							} else {
								jsonConditionPropertyMap[rcfName] = rcf.val();   			 
							}
						}                		                 			 
					});
					ruleConditionDto.ruleConditionId = jsonConditionPropertyMap.ruleConditionId;
					ruleConditionDto.logicalOperator = jsonConditionPropertyMap.logicalOperator;
					delete jsonConditionPropertyMap["ruleConditionId"];
					delete jsonConditionPropertyMap["logicalOperator"];
					ruleConditionDto.jsonConditionPropertyMap = JSON.stringify(jsonConditionPropertyMap);
					_removeNullId(ruleConditionDto, "ruleConditionId");
					ruleConditionSetDto.ruleConditions.push(ruleConditionDto);
				});
			});
		
		});
        
		if (validateError) {
			alert(validateError);
			//return;
		}

// 		console.log("saving rules");
// 		console.log(ruleSetDto);
		SambaashUtils.resourceAction(_ajaxUrl, "saveRuleSet", "POST", 
			_namespace, ruleSetDto,
			function success() {
				var data = this.get("responseData");
				_displayMessage('success', 'Rule Set Saved Successfully.', 3000);		
		});

    }

	return {
		load : _load,
		displayMessage: _displayMessage,
		cancelEdit: _cancelEdit,
		addNewRuleRow: _addNewRuleRow,
		initRuleSetType: _initRuleSetType,
		validateAndSubmit: _validateAndSubmit
	};
}

</script>
