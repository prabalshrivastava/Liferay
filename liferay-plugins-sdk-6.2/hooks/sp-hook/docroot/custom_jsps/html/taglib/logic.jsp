<!-- 
  TODO: The usage of this JSP is during development only, so that we can modify
        the javascript at runtime.
        The content of this script should be the output of translating
        SPFormLogicHandler.js from es6 to es5 via https://es6console.com/.
        Then to indicate development status, it is renamed to SPFormLogicHandlerUnderDev.
        Once all action handlers had been defined and tested, 
        we will use SPFormLogicHandler.js directly.
-->
<script>
'use strict';

var _createClass = function () { function defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } } return function (Constructor, protoProps, staticProps) { if (protoProps) defineProperties(Constructor.prototype, protoProps); if (staticProps) defineProperties(Constructor, staticProps); return Constructor; }; }();

function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }

var SPFormLogicHandlerUnderDev = function () {
    function SPFormLogicHandlerUnderDev(formInstance) {
        _classCallCheck(this, SPFormLogicHandlerUnderDev);

        this.formInstance = formInstance;
        // to make private variable in es7
        this.actionHandlers = {};
        this.actionHandlers['disableComponent'] = this.disableComponent;
        this.actionHandlers['setValue'] = this.setValue;
        this.actionHandlers['reloadOptions'] = this.reloadOptions;
        this.actionHandlers['requireComponent'] = this.requireComponent;
        this.actionHandlers['setItems'] = this.setItems;
    }

    _createClass(SPFormLogicHandlerUnderDev, [{
        key: 'disableComponent',
        value: function disableComponent(formInstance, action) {
            var targetComponent = formInstance.components[action.params.componentKey];
            targetComponent.disabled = action.params.disable;
        }
    }, {
        key: 'setValue',
        value: function setValue(formInstance, action) {
            var targetComponent = formInstance.components[action.params.componentKey];
            if (action.params.hasOwnProperty("var")) {
                targetComponent.setValue(eval(action.params["var"]));
            } else {
                targetComponent.setValue(action.params.value);
            }
        }
    }, {
        key: 'reloadOptions',
        value: function reloadOptions(formInstance, action) {
            //		var targetComponent = formInstance.components[action.params.componentKey];
            // to add generic implementation later
            // to handle by URL and static data list
        }
    }, {
        key: 'requireComponent',
        value: function requireComponent(formInstance, action) {
            var targetComponent = formInstance.components[action.params.componentKey];
            targetComponent.component.validate.required=action.params.required;
            targetComponent.refresh();
    		if (action.params.required) {
    			targetComponent.labelElement.classList.add("field-required");
    		} else {
    			targetComponent.labelElement.classList.remove("field-required");
    		}
        }
    }, {
        key: 'setItems',
        value: function setItems(formInstance, action) {
            var targetComponent = formInstance.components[action.params.componentKey];
            if (action.params.hasOwnProperty("url")) {
                // via URL
                var compiled = _.template(action.params["url"]);
                var _itemsSrcUrl = compiled(form1.form);
                SambaashUtils.ajax(_itemsSrcUrl, "GET", null, function () {
                    var data = this.get("responseData");
                    targetComponent.setValue(null);
                    targetComponent.setItems(data, false);
                });
            } else if (action.params.hasOwnProperty("data")) {
                // via static data
                targetComponent.setValue(null);
                targetComponent.setItems(action.params["data"], false);
            }
        }
    }, {
        key: 'handleFormComponentLogic',
        value: function handleFormComponentLogic(logicType, formComponent) {
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
                                thisInstance.actionHandlers[action.type](thisInstance.formInstance, action);
                            } catch (e) {
                                console.log(e);
                            }
                        });
                    }
                });
            }
        }
    }]);

    return SPFormLogicHandlerUnderDev;
}();
</script>