class SPFormLogicHandler {
	
    constructor(formInstance) {
        this.formInstance = formInstance;
        // to make private variable in es7
        this.actionHandlers = {};
        this.actionHandlers['disableComponent'] = this.disableComponent;
        this.actionHandlers['setValue'] = this.setValue;
        this.actionHandlers['reloadOptions'] = this.reloadOptions;
        this.actionHandlers['requireComponent'] = this.requireComponent;
        this.actionHandlers['requireComponentWithoutRefresh'] = this.requireComponentWithoutRefresh;
        this.actionHandlers['setItems'] = this.setItems;
        // common data for action handlers 
        // this will be accessible in the handlers as this.formInstance
        // we don't have to redundantly pass the form instance per handler
        this.actionHandlers.formInstance = formInstance;
    }
    
	disableComponent(action) {
        var targetComponent = this.formInstance.components[action.params.componentKey];
        targetComponent.disabled = action.params.disable;
    }
    
	setValue(action) {
        var targetComponent = this.formInstance.components[action.params.componentKey];
        if (action.params.hasOwnProperty("var")) {
            targetComponent.setValue(eval(action.params["var"]));
        } else {
            targetComponent.setValue(SambaashUtils.resolveValue(this.formInstance.form, action.params.value));
        }
    }
    
	reloadOptions(action) {
        //		var targetComponent = this.formInstance.components[action.params.componentKey];
        // to add generic implementation later
        // to handle by URL and static data list
    }
    
	requireComponentWithoutRefresh(action) {
        var targetComponent = this.formInstance.components[action.params.componentKey];
        targetComponent.component.validate.required=action.params.required;
		if (action.params.required) {
			targetComponent.labelElement.classList.add("field-required");
		} else {
			targetComponent.labelElement.classList.remove("field-required");
		}
    }
	
	requireComponent(action) {
        var targetComponent = this.formInstance.components[action.params.componentKey];
        targetComponent.component.validate.required=action.params.required;
		if (action.params.required) {
			targetComponent.labelElement.classList.add("field-required");
		} else {
			targetComponent.labelElement.classList.remove("field-required");
		}
    }
	
	setItems(action) {
        var targetComponent = this.formInstance.components[action.params.componentKey];
        if (action.params.hasOwnProperty("url")) {
            // via URL
        	var _itemsSrcUrl = SambaashUtils.resolveValue(this.formInstance.form, action.params["url"]);
            SambaashUtils.ajax(_itemsSrcUrl, "GET", null, function () {
                var data = this.get("responseData");
                targetComponent.resetValue();					
                targetComponent.setItems(data, false);
            });
        } else if (action.params.hasOwnProperty("data")) {
            // via static data
            targetComponent.resetValue();
            targetComponent.setItems(action.params["data"], false);
        }
    }
    
    handleFormComponentLogic(logicType, formComponent) {
        var platformLogic = formComponent.platform && formComponent.platform.logic && formComponent.platform.logic.hasOwnProperty(logicType) && formComponent.platform.logic[logicType].length > 0 ? formComponent.platform.logic[logicType] : [];
        if (platformLogic.length > 0) {
            console.log(platformLogic);
            var thisInstance = this;
            console.log(thisInstance);
            var components = thisInstance.formInstance.form.component.components;
            var data = thisInstance.formInstance.form.data;
            platformLogic.forEach(function (logic) {
                if (FormioUtils.jsonLogic.apply(logic.condition, { data: data, components: components, _: _ })) {
                    logic.actions.forEach(function (action) {
                        try {
                            console.log(action);
                            thisInstance.actionHandlers[action.type](action);
                        } catch (e) {
                            console.log(e);
                        }
                    });
                }
            });
        }
    }
    
}
