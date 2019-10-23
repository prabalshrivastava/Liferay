class SPRuleBuilder extends SPEventAware {
	constructor(authToken, containerId, ajaxUrl, namespace, ruleSetId, userInfo, spAuthSite, spAuthSiteAccess) {
		super();
        // need to make this private (Note: es7 now supports private attributes)
        this._props = {
        	authToken: authToken,
            containerId: containerId,
            ruleSetId: ruleSetId,
            ajaxUrl: ajaxUrl,
            namespace: namespace,
            userInfo: userInfo,
            spAuthSite: spAuthSite ? spAuthSite : 0,
            spAuthSiteAccess: spAuthSiteAccess ? spAuthSiteAccess : [],
            listOptionData: {}, // for holding listoption data {name:name, data:responseData}
            API_PARAM_MAP: {} // info used in listOption url e.g. ${GROUP_ID}
        };

        if (userInfo) {
            this._props.API_PARAM_MAP["USER_ID"] = userInfo.userId;
            this._props.API_PARAM_MAP["USER_EMAIL"] = userInfo.userEmail;
            this._props.API_PARAM_MAP["USER_ROLES"] = userInfo.roles;
            this._props.API_PARAM_MAP["SPAUTH_SITE"] = spAuthSite;
            this._props.API_PARAM_MAP["SPAUTH_SITE_ACCESS"] = spAuthSiteAccess;
            this._props.API_PARAM_MAP["GROUP_ID"] = userInfo.groupId;
            this._props.API_PARAM_MAP["COMPANY_ID"] = userInfo.companyId;
        }        
	}

    ajaxCall(method, action, data, successHandler, failHandler) {
        var isObject = function isObject(obj) {
            return obj === Object(obj);
        };
        var thisInstance = this;
        AUI().use('aui-base', 'aui-io-request-deprecated', function (A) {
            var _data = {};
            _data[thisInstance._props.namespace + 'action'] = action;
            if (data) {
                _data[thisInstance._props.namespace + 'data'] = isObject(data) ? JSON.stringify(data) : data;
            }
            A.io.request(thisInstance._props.ajaxUrl, {
                dataType: 'json', method: method,
                data: _data,
                on: {
                    success: successHandler,
                    failure: failHandler || function () {
                        thisInstance.debug("Error in the ajax call.");
                    }
                }
            });
        });
    }
    
    debug(msg) {
    	if (console) {
    		console.log(msg);
    	}
    }
	
	load(_options) {
        var thisInstance = this;
        this.ruleBuilderComponent = AUI().one("#ruleBuilder");
        ["listOptions", "ruleSetTypes"].forEach(function (listName) {
            thisInstance.ajaxCall("GET", "fetchListOptionByName", listName, function () {
                var data = this.get("responseData");
                data.forEach(function (listOption) {
                    thisInstance._props.listOptionData[listOption.id] = listOption;
                });
                console.log(thisInstance._props.listOptionData);
            });
        });
        
        thisInstance.ajaxCall("GET", "fetchRuleSetTypes", {}, function () {
            var data = this.get("responseData");
            var ruleSetTypeDropDown = thisInstance.ruleBuilderComponent.one("#ruleSetTypeId");
            thisInstance._props.ruleSetTypes = {};
            data.forEach(function (ruleSetType) {
                thisInstance._props.ruleSetTypes[ruleSetType.id] = ruleSetType;
                thisInstance.addOption(ruleSetTypeDropDown, ruleSetType.id, ruleSetType.displayText);
            });
            console.log(thisInstance._props.ruleSetTypes);
        });
	}
	
	addNewRuleRow() {
        console.log("addNewRuleRow");
        var itm = document.getElementById('ruleTable').getElementsByTagName('tbody')[0]; // document.getElementById("sampleRow");
        var tr = itm.getElementsByTagName("tr")[0];
        var cln = tr.cloneNode(true);

        var ruletype = cln.getElementsByClassName("ruletype");
        var and_or = cln.getElementsByClassName("and_or");
        var select_div_rules_field = cln.getElementsByClassName("select_div_rules_field");
        var datatypes = cln.getElementsByClassName("datatypes");
        var operatorlocal = cln.getElementsByClassName("operators");

        var rules_delete = cln.getElementsByClassName("div_rules_delete");
        var ruleId = cln.getElementsByClassName("ruleId");
        var input_div_rules_field = cln.getElementsByClassName("input_div_rules_field");
        var rules_value = cln.getElementsByClassName("rules_value");

        ruleId[0].innerHTML = "";
        rules_delete[0].style.display = "block";
        input_div_rules_field[0].value = "";
        rules_value[0].value = "";

        ruletype[0].selectedIndex = 0;
        and_or[0].selectedIndex = 0;
        select_div_rules_field[0].selectedIndex = 0;
        datatypes[0].selectedIndex = 0;
        operatorlocal[0].selectedIndex = 0;

        document.getElementById("ruleTable").getElementsByTagName('tbody')[0].appendChild(cln);
	}
	
	addOption(selectComponent, value, text) {
		var o = document.createElement("option");
        o.value = value;
        o.text = text;
        selectComponent.appendChild(o);
	}
	
	initRuleSetType(dropDownComponent) {
		console.log(dropDownComponent.selectedIndex);
    	if (!confirm("Changing the result set type will clear all the current rules. Proceed?")) {
    		return false;
    	}
    	var thisInstance = this;
    	var addDocElement = function(parent, type, name, _label, clearCurrentChildren) {
    		if (clearCurrentChildren) {
    			parent.empty();
    		}
    		if (type !== "NONE"){
        		var label = document.createElement("LABEL");
        		label.classList.add("control-label");
        		label.textContent = _label;
        		parent.appendChild(label);       			
    		}
   			var child;
    		if (type === "SELECT") {
    			child = document.createElement("SELECT");
        		child.classList.add("aui-field-select");     			
        		child.id = name;
    		} else if (type === "NONE"){
    			// no element
    		} else {
    			child = document.createElement("INPUT");
    			child.classList.add("field");
        		child.id = name;
    		}
    		
    		return parent.appendChild(child);
    	}
    	
    	var populateSelectOptions = function(selectElement, listOption) {
    		var loadReq = new SPAjax();
            var loadUrl = listOption.listApiUrl;
            if (loadUrl.toLowerCase().indexOf("http") !== 0) {
            	if(loadUrl.indexOf("?") === -1) {
            		loadUrl += "?";
            	} else {
            		loadUrl += "&";
            	}
            	loadUrl += "p_auth=" + thisInstance._props.authToken;
            }
            var successHandler = function(reply) {
            	loadReq.removeListener('success', successHandler);
                var response = reply.data;
                var genOptionLabelByTemplate = function(data, template) {
                	var splitArr = template.split("::");
                	var optionTemplate = splitArr[0];
                	splitArr[1].split(",").forEach(function (field) {
                		optionTemplate = optionTemplate.replace("{}", data[field]);
                	});
                	return optionTemplate;
                }
                var isdone = false;
                response.forEach(function (option) {
                	var listOption = ruleSetType.listOption;
                	if (!isdone) {
                    	console.log(listOption.listValueField);
                    	console.log(option[listOption.listValueField]);
                    	isdone = true;
                	}
                    thisInstance.addOption(selectElement, option[listOption.listValueField], genOptionLabelByTemplate(option, listOption.listOptionTemplate));                    	
                });
            }
            var failHandler = function (reply) {
                loadReq.removeListener('failed', failHandler);
                console.log("Failed with URL:" + loadUrl);
                console.log(reply);
            };
            loadReq.get(loadUrl, null);
            loadReq.on('success', successHandler);
            loadReq.on('failed', failHandler);
    	}
    	
        console.log("Selected type => " + dropDownComponent.value);
        console.log(this._props.ruleSetTypes[dropDownComponent.value]);
        var ruleSetType = this._props.ruleSetTypes[dropDownComponent.value];
        var componentIdContainer = this.ruleBuilderComponent.one("#componentIdContainer"); 
        if (!ruleSetType) {
        	componentIdContainer.empty();
        } else {
            var componentIdElement = addDocElement(componentIdContainer, ruleSetType.inputType, this._props.namespace+"componentId", ruleSetType.displayText, true);
            if (ruleSetType.hasOwnProperty("listOption")) {
            	populateSelectOptions(componentIdElement, ruleSetType.listOption);
            }
        }
	}
	
    addChildElement(parent, type, name, classList, _label, clearCurrentChildren, listOption, inlineStyle) {
        if (clearCurrentChildren) {
            parent.empty();
        }
        if (type !== "NONE" && _label) {
            var label = document.createElement("LABEL");
            label.classList.add("control-label");
            label.textContent = _label;
            parent.appendChild(label);
        }
        
        var child;
        switch (type) {
        	case "INPUT":
        	case "INPUT_TYPE":
                child = document.createElement("INPUT");            
                break;
        	case "SELECT":
                child = document.createElement("SELECT");
                break;
            default:
            	// no element
        }
        
        if (child) {
            child.id = name;
            if (classList) {
            	child.classList.add(classList);
            }
            if (inlineStyle) {
            	child.setAttribute("style", inlineStyle);
            }
            var childElement = parent.appendChild(child);
            if (listOption) {
            	populateSelectOptions(childElement, listOption);
            }
            return childElement;
        } else {
        	return null;
        }
    };	
    
	populateSelectOptions (selectElement, listOption) {
		var loadReq = new SPAjax();
        var loadUrl = listOption.listApiUrl;
        if (loadUrl.toLowerCase().indexOf("http") !== 0) {
        	if(loadUrl.indexOf("?") === -1) {
        		loadUrl += "?";
        	} else {
        		loadUrl += "&";
        	}
        	loadUrl += "p_auth=" + thisInstance._props.authToken;
        }
        var successHandler = function(reply) {
        	loadReq.removeListener('success', successHandler);
            var response = reply.data;
            var genOptionLabelByTemplate = function(data, template) {
            	var splitArr = template.split("::");
            	var optionTemplate = splitArr[0];
            	splitArr[1].split(",").forEach(function (field) {
            		optionTemplate = optionTemplate.replace("{}", data[field]);
            	});
            	return optionTemplate;
            }
            var isdone = false;
            response.forEach(function (option) {
            	var listOption = ruleSetType.listOption;
            	if (!isdone) {
                	console.log(listOption.listValueField);
                	console.log(option[listOption.listValueField]);
                	isdone = true;
            	}
                thisInstance.addOption(selectElement, option[listOption.listValueField], genOptionLabelByTemplate(option, listOption.listOptionTemplate));                    	
            });
        }
        var failHandler = function (reply) {
            loadReq.removeListener('failed', failHandler);
            console.log("Failed with URL:" + loadUrl);
            console.log(reply);
        };
        loadReq.get(loadUrl, null);
        loadReq.on('success', successHandler);
        loadReq.on('failed', failHandler);
	}

	addFieldElement(parent, type, name, classList, _label, clearCurrentChildren, listOption, inlineStyle) {
		var crtlGrp = thisInstance.addChildElement(parent, "div", null, "control-group", null, false, null, "display: block;");
		return this.addChildElement(crtlGrp, type, name, classList, _label, clearCurrentChildren, listOption, inlineStyle);
	}
	
	addNewRuleConditionSet(parentRule) {
		console.log();
	}
	
	addNewRuleCondition(parentRule) {
		console.log();
	}

	validateAndSubmit() {
		console.log();
	}	
}