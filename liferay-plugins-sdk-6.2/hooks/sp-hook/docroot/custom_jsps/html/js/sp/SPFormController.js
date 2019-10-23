'use strict';

const SPFormController = function SPFormController(spFormInstance) {
	var spForm = spFormInstance;
	
	var _getFormComponent = function _getFormComponent(componentKey) {
		return spForm.components[componentKey];
	}
	
	var _disableComponent = function _disableComponent(componentKey, disable) {
        var component = _getFormComponent(componentKey);
        component.disabled = disable;
        if (component.type == "datetime" && component.disabled) {
    		component.element.querySelector(".flatpickr-input.input").setAttribute("disabled","disabled");
    	}
    }

	/*
	 * For setting values. It can be used for single and multiple value components.
	 * Just pass the expected datatype values.
	 */
	var _setValue = function _setValue(componentKey, value, noUpdate, noValidate) {
		_getFormComponent(componentKey).setValue(value, {
			noUpdateEvent: noUpdate || false,
		    noValidate: noValidate || false
		});
    }

	/*
	 * Use for setting required fields based on certain conditions.
	 * Example, require only "NRIC No." when id type is "NRIC".
	 */
	var _requireComponent = function _requireComponent (componentKey, required) {
        var targetComponent = _getFormComponent(componentKey);
        targetComponent.component.validate.required=required;
        targetComponent.refresh();
		if (required) {
			targetComponent.labelElement.classList.add("field-required");
		} else {
			targetComponent.labelElement.classList.remove("field-required");
		}
    }
	
	/*
	 * populate component either via Ajax URL or static data.
	 * This is usually used for populating Select options.
	 * The API call must return that same json field names configured in the select component.
	 */
	var _setItems = function _setItems(componentKey, data, url, requestMethod, requestBody) {
		var targetComponent = _getFormComponent(componentKey);
        if (url) {
            // via Ajax URL
        	var _itemsSrcUrl = SambaashUtils.resolveValue(spForm.form, url);
            SambaashUtils.ajax(_itemsSrcUrl, requestMethod || "GET", requestBody || null, function () {
                var data = this.get("responseData");
                targetComponent.resetValue();
                targetComponent.setItems(data, false);
            });
        } else if (data) {
            // via static data
            targetComponent.resetValue();
            targetComponent.setItems(data, false);
        }
    }
	
	var _applyPermission = function _applyPermission() {
		SPFormPermissionHandler.checkPermission(spForm);
	}
	
	var _checkProcessAction = function _checkProcessAction (_data) {
		  var _mode = _data["_MODE"] || "";
		  _mode = _mode.toUpperCase();
		  return _mode == "SAVE" || _mode == "SUBMIT";
	}
	
	// setting errorMsg to null will clear the error message
    var _displayComponentErrorMessage = function _displayComponentErrorMessage (componentKey, errorMsg, focusToItem) {
    	var _comp = _getFormComponent(componentKey);
    	_comp.setCustomValidity(errorMsg, true);
    	_comp.error = errorMsg;
//	    	spForm.form.showErrors();
        if (focusToItem) {
        	_getFormComponent(componentKey).focus();
        	spForm.form.showErrors();
        }
    }
    
    var _displayMessage = function _displayMessage(type, message, duration) {
        if (spForm.form) {
        	spForm.form.setAlert(type, message);
            if (duration) {
                setTimeout(function(){ spForm.form.setAlert(false); }, duration);
            }
        }
    }

    var _setDropDownValue = function _setDropDownValue(instance, rowData, lovFieldName, lovDisplayValueTemplate, hiddenValueField, rowIndex) {
    	if (rowData.hasOwnProperty(hiddenValueField) && rowData[hiddenValueField]) {
    		setTimeout(function(){
    			instance.choices.currentState.choices.forEach(function(dropDown){
    				var dropDownDisplayedValue = _replaceTokens(dropDown.value, lovDisplayValueTemplate);
    				if (dropDownDisplayedValue == rowData[hiddenValueField]) {
    					_setValue(lovFieldName,dropDown.value, true, true);
    				}
    			});
    		});
    	}
    	return null;
    }

    var _setHiddenDropDownValueField = function _setHiddenDropDownValueField(instance, rowData, lovFieldName, lovDisplayValueTemplate, hiddenValueField, rowIndex) {
    	if (rowData.hasOwnProperty(hiddenValueField) && rowData[hiddenValueField]) {
    		setTimeout(function(){
    			instance.choices.currentState.choices.forEach(function(dropDown){
    				var dropDownDisplayedValue = _replaceTokens(dropDown.value, lovDisplayValueTemplate);
    				if (dropDownDisplayedValue == rowData[hiddenValueField]) {
    					_setValue(hiddenValueField,dropDownDisplayedValue, true, true);
    				}
    			});
    		});
    	}
    	return null;
    }
    
    var _replaceTokens = function _replaceTokens(sourceObject, tokenizedString) {
    	var regex = /\[\$[a-zA-Z0-9_\-\(\)]*\$\]/g;
    	var match = tokenizedString.match(regex);
    	var newString = tokenizedString;
    	if (match) {
	    	for (var i = 0; i<match.length; i++)
	    	{
	    		var token = match[i];
	    		var fieldName = token.replace("[$","").replace("$]","");
	    		if (sourceObject.hasOwnProperty(fieldName)) {
	    			newString = newString.replace(token, sourceObject[fieldName]);
	    		}
	    	}    		
    	}
    	return newString;
    }
    
	return {
		disable : _disableComponent,
		require : _requireComponent,
		setValue : _setValue,
		setItems: _setItems,
		applyPermission : _applyPermission,
//			checkProcessAction: _checkProcessAction,
		getFormComponent: _getFormComponent,
		displayComponentErrorMessage: _displayComponentErrorMessage,
		displayMessage : _displayMessage,
		setDropDownValue : _setDropDownValue,
		setHiddenDropDownValueField : _setHiddenDropDownValueField,
		replaceTokens : _replaceTokens,
		groupId : spForm ? spForm._props.userInfo.groupId : 0,
		groupIdms : spForm ? spForm._props.userInfo.groupIdms : 0,
		userId : spForm ? spForm._props.userInfo.userId : 0,
		userName : spForm ? spForm._props.userInfo.fullName : "",
		userRoles : spForm ? spForm._props.userInfo.roles : ""
	}
	
};

