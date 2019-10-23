AUI.add(
	'liferay-ddm-repeatable-fields',
	function(A) {
		var Lang = A.Lang;

		var SELECTOR_REPEAT_BUTTONS = '.add_button_below, .lfr-ddm-repeatable-delete-button, .toggler_icon, .add_button_top';
		
		//var TPL_ADD_REPEATABLE_TOP = '<a class="add_button_top" href="javascript:;">v</a>';
		var TPL_ADD_REPEATABLE_TOP = '<a class="add_button_top" href="javascript:;"><svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 16 16"><defs></defs><title>Add-Up</title><circle class="add_up" cx="8" cy="8" r="8"/><rect class="b" x="7.57769" y="2.55755" width="1" height="5"/><rect class="b" x="7.57769" y="2.55755" width="1" height="5" transform="translate(13.13524 -3.02014) rotate(90)"/><polygon class="b" points="4.078 9.582 5.078 8.582 11.078 8.582 12.078 9.582 4.078 9.582"/><polygon class="b" points="3.078 11.582 4.078 10.582 12.078 10.582 13.078 11.582 3.078 11.582"/></svg></a>';

		var TPL_ADD_TOGGLE = '<a class="toggler_icon" href="javascript:;"><svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 16 16"><defs></defs><title>Minimize</title><circle class="toggle_minimize" cx="8" cy="8" r="8"/><rect class="b" x="4.2991" y="5.408" width="1" height="6"/><rect class="b" x="3.20419" y="7.05755" width="9.89072" height="1" transform="translate(-2.95705 7.97616) rotate(-45)"/><rect class="b" x="6.7991" y="7.908" width="1" height="6" transform="translate(18.2071 3.6089) rotate(90)"/></svg></a>';
		
		var TPL_ADD_REPEATABLE = '<a class="add_button_below" href="javascript:;"><svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 16 16"><defs></defs><title>Add-down</title><circle class="add_down" cx="8" cy="8" r="8"/><rect class="b" x="7.57769" y="7.55755" width="1" height="5"/><rect class="b" x="7.57769" y="7.55755" width="1" height="5" transform="translate(18.13524 1.97986) rotate(90)"/><polygon class="b" points="4.078 4.582 5.078 3.582 11.078 3.582 12.078 4.582 4.078 4.582"/><polygon class="b" points="3.078 6.582 4.078 5.582 12.078 5.582 13.078 6.582 3.078 6.582"/></svg></a>';

		var TPL_DELETE_REPEATABLE = '<a class="lfr-ddm-repeatable-delete-button icon-minus-sign" style="right: 60px;" href="javascript:;"></a>';
		
		var addToTopFlag = false;

		var RepeatableFields = A.Component.create(
			{
				ATTRS: {
					classNameId: {
					},

					classPK: {
					},

					container: {
						setter: A.one
					},

					doAsGroupId: {
					},

					fieldsDisplayInput: {
						setter: A.one
					},

					namespace: {
					},

					p_l_id: {
					},

					portletNamespace: {
					},

					repeatable: {
						validator: Lang.isBoolean,
						value: false
					}
				},

				EXTENDS: A.Base,

				NAME: 'liferay-ddm-repeatable-fields',

				eventHandlers: {},

				prototype: {
					initializer: function() {
						var instance = this;

						instance.bindUI();
						instance.syncUI();
					},

					bindUI: function() {
						var instance = this;

						var container = instance.get('container');

						container.delegate('click', instance._onClickRepeatableButton, SELECTOR_REPEAT_BUTTONS, instance);

						var hoverHandler = instance._onHoverRepeatableButton;

						container.delegate('hover', hoverHandler, hoverHandler, SELECTOR_REPEAT_BUTTONS, instance);

						Liferay.after('form:registered', instance._afterFormRegistered, instance);

						instance.on(
							['repeat', 'remove'],
							function(event) {
								var fieldInputName = instance.getFieldInputName(event.fieldNode);

								var liferayForm = instance.liferayForm;

								if (liferayForm) {
									var validatorRules = liferayForm.formValidator.get('rules');

									if (event.type === 'liferay-ddm-repeatable-fields:repeat') {
										var originalFieldRules = validatorRules[instance.getFieldInputName(event.originalFieldNode)];

										if (originalFieldRules) {
											validatorRules[fieldInputName] = originalFieldRules;
										}
									}
									else if (event.type === 'liferay-ddm-repeatable-fields:remove') {
										delete validatorRules[fieldInputName];

										var validatorField = liferayForm.formValidator.getField(fieldInputName);

										if (validatorField) {
											liferayForm.formValidator.resetField(validatorField);
										}
									}

									liferayForm.formValidator.set('rules', validatorRules);
								}
							}
						);
					},

					syncUI: function() {
						var instance = this;

						instance.syncFieldsTreeUI();
					},

					createFieldTree: function(fieldNode) {
						var instance = this;

						var fieldName = fieldNode.getData('fieldName');
						var fieldNamespace = fieldNode.getData('fieldNamespace');

						var tree = [fieldName + fieldNamespace];

						instance.getFieldsList(null, fieldNode).each(
							function(item, index, collection) {
								tree = tree.concat(instance.createFieldTree(item));
							}
						);

						return tree;
					},

					getField: function(fieldName, callback) {
						var instance = this;

						A.io.request(
							themeDisplay.getPathMain() + '/dynamic_data_mapping/render_structure_field',
							{
								data: {
									classNameId: instance.get('classNameId'),
									classPK: instance.get('classPK'),
									controlPanelCategory: 'portlet',
									doAsGroupId: instance.get('doAsGroupId'),
									fieldName: fieldName,
									namespace: instance.get('namespace'),
									p_l_id: instance.get('p_l_id'),
									p_p_id: '166',
									p_p_isolated: true,
									portletNamespace: instance.get('portletNamespace'),
									readOnly: instance.get('readOnly')
								},
								on: {
									success: function(event, id, xhr) {
										if (callback) {
											callback.call(instance, xhr.responseText);
										}
									}
								}
							}
						);
					},

					getFieldInputName: function(fieldNode) {
						var instance = this;

						var portletNamespace = instance.get('portletNamespace');
						var namespace = instance.get('namespace');

						var prefix = [portletNamespace];

						if (namespace) {
							prefix.push(namespace);
						}

						return prefix.concat(
							[
								fieldNode.getData('fieldName'),
								fieldNode.getData('fieldNamespace')
							]
						).join('');
					},

					getFieldParentNode: function(fieldNode) {
						var instance = this;

						var parentNode = fieldNode.ancestor('.field-wrapper');

						if (!parentNode) {
							parentNode = instance.get('container');
						}

						return parentNode;
					},

					getFieldsList: function(fieldName, parentNode) {
						var instance = this;

						var container;

						if (parentNode) {
							container = parentNode;
						}
						else {
							container = instance.get('container');
						}

						var selector = ['>'];

						selector.push(' .field-wrapper');

						if (fieldName) {
							selector.push('[data-fieldName="' + fieldName + '"]');
						}

						return container.all(selector.join(''));
					},

					insertField: function(fieldNode) {
						var instance = this;

						instance.getField(
							fieldNode.getData('fieldName'),
							function(newFieldHTML) {
								fieldNode.insert(newFieldHTML, 'after');

								instance.fire(
									'repeat',
									{
										fieldNode: fieldNode.next(),
										originalFieldNode: fieldNode
									}
								);

								instance.syncFieldsTreeUI();
							}
						);
					},
					
					insertFieldBefore: function(fieldNode) {
						var instance = this;

						instance.getField(
							fieldNode.getData('fieldName'),
							function(newFieldHTML) {
								fieldNode.insert(newFieldHTML, 'before');

								instance.fire(
									'repeat',
									{
										fieldNode: fieldNode.next(),
										originalFieldNode: fieldNode
									}
								);

								instance.syncFieldsTreeUI();
							}
						);
					},

					removeField: function(fieldNode) {
						var instance = this;

						instance.fire(
							'remove',
							{
								fieldNode: fieldNode
							}
						);

						fieldNode.remove();

						var eventHandlers = RepeatableFields.eventHandlers[instance.getFieldInputName(fieldNode)];

						A.Array.invoke(eventHandlers, 'detach');

						instance.syncFieldsTreeUI();
					},

					renderRepeatableUI: function(fieldNode) {
						var instance = this;

						var fieldRepeatable = A.DataType.Boolean.parse(fieldNode.getData('repeatable'));

						if (instance.get('repeatable') && fieldRepeatable) {
							if (!fieldNode.getData('rendered-toolbar')) {
								var fieldName = fieldNode.getData('fieldName');

								var parentNode = instance.getFieldParentNode(fieldNode);

								var fieldsList = instance.getFieldsList(fieldName, parentNode);

								var html = TPL_ADD_REPEATABLE;

								if (fieldsList.indexOf(fieldNode) > 0) {
									html += TPL_DELETE_REPEATABLE;
								}
								
								if (fieldsList.indexOf(fieldNode) >= 0 && addToTopFlag){
									html += TPL_DELETE_REPEATABLE;
								}
								
								html += TPL_ADD_REPEATABLE_TOP;

								fieldNode.append('<div class="repeataable_icons">'+html);

								fieldNode.plug(A.Plugin.ParseContent);
								
								if (fieldNode._node.hasChildNodes()){
									var children = fieldNode._node.children;
									for (var i = 0; i < fieldNode._node.children.length; i++) {
										if (children[i].classList.contains('field-wrapper')){
											fieldNode.append(TPL_ADD_TOGGLE);
											break;
										}
									}
								}

								fieldNode.setData('rendered-toolbar', true);
							}
						}
						
						
						
						instance.getFieldsList(null, fieldNode).each(
							function(item, index, collection) {
								instance.renderRepeatableUI(item);
							}
						);
					},

					syncFieldsTreeUI: function() {
						var instance = this;

						var fieldsDisplay = [];

						var fieldsDisplayInput = instance.get('fieldsDisplayInput');

						instance.getFieldsList().each(
							function(item, index, collection) {
								instance.renderRepeatableUI(item);

								fieldsDisplay = fieldsDisplay.concat(instance.createFieldTree(item));
							}
						);

						fieldsDisplayInput.val(fieldsDisplay.join());
					},

					_afterFormRegistered: function(event) {
						var instance = this;

						var container = instance.get('container');

						var formNode = container.ancestor('form', true);

						if (formNode && (event.formName === formNode.attr('name'))) {
							instance.liferayForm = event.form;
						}
					},

					_onClickRepeatableButton: function(event) {
						var instance = this;

						var currentTarget = event.currentTarget;

						var fieldNode = currentTarget.ancestor('.field-wrapper');

						if (currentTarget.hasClass('add_button_below')) {
							instance.insertField(fieldNode);
						}
						else if (currentTarget.hasClass('lfr-ddm-repeatable-delete-button')) {
							instance.removeField(fieldNode);
						}
						else if (currentTarget.hasClass('toggler_icon')) {
							var children = fieldNode._node.childNodes;
							for (var i = 0; i < children.length; i++) {
								if (children[i].className || children[i].nodeName == "DIV"){
									if ((!children[i].classList.contains('toggler_icon')) && (!children[i].classList.contains('control-label')) && (!children[i].classList.contains('repeataable_icons'))){
										if (children[i].classList.contains('wcm-image-preview')){
											if ((children[i].classList.contains('hide')) && (children[i].previousElementSibling.text == 'Show')){
												//children[i].classList.remove('hide');
											}else if ((children[i].classList.contains('hide')) && (children[i].previousElementSibling.text == 'Hide')){
												children[i].classList.remove('hide');
											}else{
												children[i].classList.add('hide');
											}
										}else{
											if (children[i].classList.contains('hide')){
												children[i].classList.remove('hide');
											}else{
												children[i].classList.add('hide');
											}
										}
										
										
									}
										
								} else {
									if (children[i].nodeName == 'A'){
										if (children[i].style.display == 'none'){
											children[i].style.display='inline';
											if (children[i].id.includes('ToggleImage')){
												children[i].previousSibling.replaceWith("[ ");
												children[i].nextSibling.replaceWith(" ]");
											}
										} else{
											children[i].style.display='none';
											children[i].previousSibling.replaceWith("");
											children[i].nextSibling.replaceWith("");
										}
									}		
								}	
							}
						}
						else if (currentTarget.hasClass('add_button_top')){
							instance.insertFieldBefore(fieldNode);
							addToTopFlag = true;
						}
					},

					_onHoverRepeatableButton: function(event) {
						var instance = this;

						var fieldNode = event.currentTarget.ancestor('.field-wrapper');

						fieldNode.toggleClass('lfr-ddm-repeatable-active', (event.phase === 'over'));
					}

				}
			}
		);

		Liferay.namespace('DDM').RepeatableFields = RepeatableFields;
	},
	'',
	{
		requires: ['aui-base', 'aui-datatype', 'aui-io-request', 'aui-parse-content']
	}
);