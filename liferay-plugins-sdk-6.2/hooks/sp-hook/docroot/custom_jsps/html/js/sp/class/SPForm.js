class SPForm extends SPEventAware {
    // START of all abstract methods that can be implemented
    
    // if you want to use Formio code on the returned Promised Form
    afterFormLoaded() { };
    // when the form cannot be loaded
    handleLoadingFailure(error) { this.debug('error loading form '+ this.formId + ': '+error); };
    // what else to do after form had been rendered
    afterFormRendered() { this.debug('form '+ this.formId + ' loaded'); };
    // on form error event
    handleFormError(errorArray) { this.debug('form errors encountered'); };
    // what else to do after form submission is done
    afterSaved(submission) { this.debug('after successful submission'); };
    previousPage(page) { this.debug('previous page'); };
    nextPage(page) { this.debug('next page'); };
    
    // besides the default Formio validation
    // custom validation can be performed on the submitted data
    // submission contains the data submitted
    // next is a function to proceed. if an array of errors is passed
    //   then the submission is aborted, and the errors are displayed
    customValidation(submission, next) { next(); };
    
    // besides saving the data in forms schema, custom submission code can be added
    // this method is called after saving the data in the forms schema
    customSubmission(submission) {};
    
    // END of all abstract methods that can be implemented
    
    constructor(apiBaseUrl, formContainerId, formId, ajaxUrl, namespace) {
        super();
        this._props = {
            baseUrl : apiBaseUrl,
            formContainerId : formContainerId,
            formId : formId,
            ajaxUrl: ajaxUrl,
            namespace : namespace,
            components: {}  // components map
        };
//        this.makeImmutable(this._props);
        let currentDomain = window.location.protocol + "//" + window.location.host;
        Formio.setBaseUrl(currentDomain);
        Formio.setApiUrl(this.baseUrl);
        Formio.setAppUrl(currentDomain);
//        this.load(options);
    };

	getProperty(property, defaultValue) {
		if (this._props.hasOwnProperty(property)) {
			return this._props[property];
		} else {
			return defaultValue;
		}
	}
    
    get baseUrl() {
//      retrieve this from SPParameter: api.form.v2.baseurl
//      call SambaashUtil.getFormV2BaseUrl()
//        return "https://forms.localsambaash.com:8443/v2/forms";
        return this._props.baseUrl;
    };
    
    get formId() {
        return this._props.formId;
    }
    
    get formContainerId() {
        return this._props.formContainerId;
    }
    
    get ajaxUrl() {
        return this._props.ajaxUrl;
    }
    
    get namespace() {
        return this._props.namespace || '';
    }
    
    get formLogicHandler() {
        return this._props.userId || 0;
    }
    
    set formLogicHandler(_formLogicHandler) {
        this._props.formLogicHandler = _formLogicHandler;
    }
    
    get userId() {
        return this._props.userId || 0;
    }
    
    set userId(_userId) {
        this._props.userId = _userId;
    }
    
    get userName() {
        return this._props.userName || "";
    }
    
    set userName(_userName) {
        this._props.userName = _userName;
    }
    
    get groupId() {
        return this._props.groupId || 0;
    }
    
    set groupId(_groupId) {
        this._props.groupId = _groupId;
    }
    
    get userRoles() {
        return this._props.userRoles || "";
    }
    
    set userRoles(_userRoles) {
        this._props.userRoles = _userRoles;
    }
    
    set userInfo(_userInfo) {
        this.userId = _userInfo.userId;
        this.userName = _userInfo.fullName;
        this.groupId = _userInfo.groupId;
        this.userRoles = _userInfo.roles;
        this._props.userInfo = _userInfo;
    }

    get components() {
        return this._props.components;
    }
        
    ajaxCall(method, action, data, successHandler, failHandler) {
        let thisInstance = this;
        AUI().use('aui-base','aui-io-request-deprecated',function(A){
            let _data = {};
            _data[thisInstance.namespace + 'formId'] = thisInstance.formId;
            _data[thisInstance.namespace + 'action'] = action;
            if (data) {
                _data[thisInstance.namespace + 'data'] = JSON.stringify(data);              
            }
            A.io.request(thisInstance.ajaxUrl,{
                dataType : 'json', method : method,
                data : _data,
                on : {
                    success : successHandler,
                    failure : failHandler || function() {
                        thisInstance.debug("Error in the ajax call.");
                    }
                }
            });             
        });
    }
    
    // Display message in specified duration 
    // or forever (if no duration) until a field gets inputted (see change event handler below)
    // types: danger, info, warning, success
    displayMessage(type, message, duration) {
        this.form.setAlert(type, message);
        if (duration) {
            var thisInstance = this;
            setTimeout(function(){ thisInstance.form.setAlert(false); }, duration);
        }       
    }
    
    reset() {
        if (this.form) this.form.cancel(true);
    }
    
    reload() {
        if (this.form) this.form.render();
    }
    
    submit() {
        if (this.form) this.form.submit();
    }
    
    displayMessage(type, message) {
        if (this.form) this.form.setAlert(type, message);
    }
    
    validateForm() {
        if (this.form) this.form.showErrors();
    }

    _resetFileProviderAndEvalLogic(thisInstance, logicType) {
        FormioUtils.eachComponent(thisInstance.form.components, (component) => {
            if (component.type == 'file') {
            	var downloadUrl = thisInstance.ajaxUrl+'&'+namespace+'action=fileDownload'
            		+'&'+namespace+'fileName={FILE_NAME}'
            		+'&'+namespace+'groupId={GROUP_ID}';
                component.component.url = thisInstance.ajaxUrl+'&'+ namespace+'formType='+thisInstance.formType;
                component.component.url += '&'+ namespace+'downloadUrlPattern='+encodeURIComponent(downloadUrl);
            }
            thisInstance._props.formLogicHandler.handleFormComponentLogic(logicType, component);
        }, true);
    }
    
    populate(data, pkFieldName) {
        if (this.form) {
    		this.form.setValue({data:data},{});
    		this._resetFileProviderAndEvalLogic(this, 'populate');

            if(typeof this.components.FormStat !== "undefined"){
            	this.components.FormStat.element.innerText = this.components.Status.value;
            	this.components.FormStat.element.classList.remove("form_draft");
            	this.components.FormStat.element.classList.add("form_"+ this.components.Status.value.toLowerCase());
            }
    		this.emit('formPopulated');            
            
        }
    }

    /*
     * _options - form loading option object
     * Option       Description                                             Default
     * readOnly     If the form should render as disabled (read only)       false
     * noAlerts     If the form should not render the alerts dialog 
     *              on top of the form. Pass "true" to disable.             false
     * i18n         An instance the translation you would like to 
     *              provide to the renderer. 
     *          
     * inputsOnly   If you wish to only show the inputs only and 
     *              no labels, etc.              
     */
    load(_options) {
        let thisInstance = this;
        let options = _options || {};
        options.hooks = {
                  beforeSubmit: (submission, next) => {
                    thisInstance.customValidation(submission, next);
                   
            }};
        options.fileService = spFileService;
        options.formio = Formio;
        
        let addHiddenField = function(components, hiddenFieldName) {
            let hiddenField = {
                input: true,
                tableView: true,
                key: hiddenFieldName,
                label: hiddenFieldName,
                protected: false,
                unique: false,
                persistent: true,
                type: "hidden",
                tags: [],
                conditional: { show: "", when: null, eq: "" },
                properties: { },
                lockKey: true
            };
            components.splice(components.length-1,0,hiddenField);
        };

        let loadReq = new SPAjax();
        let loadUrl = this.baseUrl+"/find?applicationId=forms-app-v2&authToken=4687559&userId=1&formId="+this.formId;
        let successHandler = function(reply) {
            thisInstance.debug('in success handler');
            loadReq.removeListener('success', successHandler);
            let response = reply.data;
            let d = JSON.parse(response.htmlFormSchema);
            /*
             * Hidden fields that can be used in condition or validation.
             * Example, to show or hide a component based on user role
             *      show = JSON.parse(data['_USER_ROLES']).indexOf('Administrator') >= 0
             * These hidden fields are populated like this (note: SampleForm extends SPForm):
             *      var userInfo = <%= SambaashUtil.getUserInfo(themeDisplay).toString() %>;
             *      var form = new SampleForm("formio", "1555", a, ns);
             *      form.userInfo = userInfo;
             */
            /*
            addHiddenField(d.components,"_USER_ID");
            addHiddenField(d.components,"_USER_ROLES");
            addHiddenField(d.components,"_GROUP_ID");
            addHiddenField(d.components,"_COMPANY_ID");
            addHiddenField(d.components,"_USER_NAME");
            // PK is set via the populate() method
            addHiddenField(d.components,"_PK");
            */
            Formio.createForm(document.getElementById(thisInstance.formContainerId), {components: d.components}, options).then((form) => {
                thisInstance.form = form;

                var _setGridUploadUrl = function(components) {
                    for (var key in components) {
                        var component = components[key];
                        if (component.type == 'file') {
                        	var downloadUrl = thisInstance.ajaxUrl+'&'+namespace+'action=fileDownload'
                        		+'&'+namespace+'fileName={FILE_NAME}'
                        		+'&'+namespace+'groupId={GROUP_ID}';
                            component.url = thisInstance.ajaxUrl+'&'+ namespace+'formType='+thisInstance.formType;
                            component.url += '&'+ namespace+'downloadUrlPattern='+encodeURIComponent(downloadUrl);
                        }
                    }
                };
                
                FormioUtils.eachComponent(form.components, (component) => {
                    let cKey = component.component.key;
                    /*
                    if (cKey === '_USER_ID') {
                        component.component.defaultValue = thisInstance.userId;
                    } else if (cKey === '_USER_ROLES') {
                        // you can use this in the Conditional property of the form component
                        // Example, to show the component for Administrator roles only
                        // show = JSON.parse(data['_USER_ROLES']).indexOf('Administrator') >= 0
                        component.component.defaultValue = JSON.stringify(thisInstance.userRoles);
                    } else if (cKey === '_USER_NAME') {
                        component.component.defaultValue = thisInstance.userName;
                    } else if (cKey === '_GROUP_ID') {
                        component.component.defaultValue = thisInstance.groupId;
                    }
                    */
                    thisInstance._props.components[cKey] = component;
                    if (component.type=='datagrid') {
                        component.on('editGridAddRow', function(payload) {
                            if (component.component.key == payload.component.key) {
                                console.log("editGridAddRow set url", payload.component.components);
                                _setGridUploadUrl(FormioUtils.flattenComponents(payload.component.components,true));
                            }
                        });
                    }
                }, true);

                form.on('submit', function(submission) { 
                    thisInstance.debug('In default saving of submission =>'); 
                    console.log(submission);
                    var submissiondata = {};
                    if(submission.data.Status == "Draft")
                	submission.data.Status = "Active";
                    thisInstance.debug(submission); 
                    //TODO: Insert default saving here e.g. saving to forms schema
                    validateFormIOForm(thisInstance);
                    //thisInstance.customSubmission(submission);
                });
                form.on('error', function(errorArray) {
                    thisInstance.handleFormError(errorArray);
                });
                form.on('submitDone', function(submission) {
                    thisInstance.afterSaved(submission);
                });
                form.on('saveDraft', function(submission) {
                	console.log(submission);
                	thisInstance.form.submitForm().then(result => {
                	submission.Status = "Draft";
                	actionPerformed = "Draft";
                	validateFormIOForm(thisInstance);
                	 }).catch(err => {
         	        	thisInstance.form.onSubmissionError(err);
         	        	thisInstance.loading(false);
         	            return Promise.reject(err);
         	          });
                });
                form.on('activate', function(submission) {
                	console.log(submission);
                	submission.Status = "Active";
                	submission.reactive = true;
                	actionPerformed = "Activated";
                	showActiveInactivePopup(thisInstance,'Active');
                });
                form.on('deactivate', function(submission) {
                	console.log(submission);
                	submission.Status = "Inactive";
                	actionPerformed = "Deactivated";
                	showActiveInactivePopup(thisInstance,'Inactive');
                	//validateFormIOForm(thisInstance);
                });
                form.on('blacklist', function(submission) {
                	console.log(submission);
                	submission.Status = "Blacklist";
                	actionPerformed = "Blacklisted";
                	showActiveInactivePopup(thisInstance,'Blacklist');
                	//validateFormIOForm(thisInstance);
                });
                form.on('cancelForm', function(submission) {
                	window.history.back();
                });
                form.on('editForm', function(submission) {
                	editFormIoPage();
                });
                form.on('nextPage', function(page) {
                    thisInstance.nextPage(page);
                });
                form.on('formLoadedAndPopulated', function(formInstance) {
                	alert(1);
                });
                form.on('change', function(changePayload) {
                    if (!changePayload.changed || !changePayload.changed.value) {
                        return; // no change yet
                    }
//                    thisInstance.debug(changePayload); 
                    let changedItem = changePayload.changed.component.key;
                    let curValue = changePayload.changed.value;
                    let curData = changePayload.data[changedItem];
                    if (curValue == curData) {  
                        // remove messages on input to any fields
                        thisInstance.form.setAlert(false);
//                        thisInstance.debug('changed, submitting partial submission => '); 
                        //TODO: insert partial submission code here
                        thisInstance.checkLogic(thisInstance, changePayload.changed.component);
                        thisInstance._props.formLogicHandler.handleFormComponentLogic('change', changePayload.changed.component);
                        //notify form changed
                        thisInstance.emit('partial', changePayload);
                    }
                    if(mode == "view"){
                    	
                    	thisInstance.enableButtons(thisInstance);
                    }
//                    SPFormPermissionHandler.checkPermission(thisInstance);
                });
               
                thisInstance.form.on('render', function() {
                	console.log("in on render");
                    if (!thisInstance._stop_render_event) {
                        thisInstance.afterFormLoaded();
                        // reset flag, in case render was invoked 
                        // just like by calling populate()
                        // inside afterFormLoaded() 
                        thisInstance.emit('formLoadedAndPopulated',thisInstance);
                        this._stop_render_event=false;
                    }else{
                    	thisInstance.emit('formLoaded',thisInstance);
                    }
                    FormioUtils.eachComponent(form.components, (component) => {
                        if (component.type == 'file') {
                        	var downloadUrl = thisInstance.ajaxUrl+'&'+namespace+'action=fileDownload'
                        		+'&'+namespace+'fileName={FILE_NAME}'
                        		+'&'+namespace+'groupId={GROUP_ID}';
                            component.component.url = thisInstance.ajaxUrl+'&'+ namespace+'formType='+thisInstance.formType;
                            component.component.url += '&'+ namespace+'downloadUrlPattern='+encodeURIComponent(downloadUrl);
                        }
                    });
                    AUI().one('#'+thisInstance.formContainerId).all('input').each(function(input){
                        let curStyle = input.getAttribute('style');
                        if (curStyle != undefined && curStyle > "" && curStyle.indexOf('!important')<0) {
                            input.setAttribute('style', curStyle.replace(/;/g,' !important;'));                         
                        }
                    });
                    // disable date fields when needed
                    Object.values(thisInstance.components).forEach(function (component) {
                    	if (component.type == "datetime" && component.disabled) {
                    		component.element.querySelector(".flatpickr-input.input").setAttribute("disabled","disabled");
                    	}
                    });                    
                });
            });
        };
        let failHandler = function (reply) {
            loadReq.removeListener('failed', failHandler);
            thisInstance.handleLoadingFailure(reply.error);
        };
        
        loadReq.get(loadUrl, null);
        loadReq.on('success', successHandler);
        loadReq.on('failed', failHandler);
    }

    fixFormIOInlineStyle(formInstance) {
        AUI().one('#'+formInstance.getProperty('formContainerId', '')).all('input').each(function(input){
            let curStyle = input.getAttribute('style');
            if (curStyle != undefined && curStyle > "" && curStyle.indexOf('!important')<0) {
                input.setAttribute('style', curStyle.replace(/;/g,' !important;'));                         
            }
        });   	
    }
        
    checkLogic(thisInstance, logicComponent) {
    	
        if (logicComponent.properties.hasOwnProperty("spLogic") && logicComponent.properties.spLogic) {
        	
            var spLogic = JSON.parse(logicComponent.properties.spLogic);
            console.log(spLogic  );
            var components = thisInstance.form.component.components;
            var data = thisInstance.form.data;
            spLogic.forEach(function (logic) {
                if (FormioUtils.jsonLogic.apply(logic.condition, 
                    { data: data, components: components, _} )
                ) {
                	
                    logic.actions.forEach( function (action) {
                    	console.log(action  );
                        switch(action.type) {
                            case "disableComponent": 
                                var targetComponent = thisInstance.components[action.params.componentKey];
                                targetComponent.disabled = action.params.disable;
                                console.log(action.params.disable + "----" + action.params.componentKey );
                                break;
                            case "setValue": 
                            	var targetComponent = thisInstance.components[action.params.componentKey];
                                if (action.params.hasOwnProperty("var")) {
                                	console.log(action.params["var"]);
                                	targetComponent.setValue(eval(action.params["var"]));
                                } else {
                                    targetComponent.setValue(action.params.value);                               
                                }
                                break;
                            case "reloadOptions": 
                                var targetComponent = thisInstance.components[action.params.componentKey];
                                reloadOptions(thisInstance);
                                //targetComponent.setValue(action.params.value)
                                break;
                            default:
                                // not handled
                        };
                    });
                }                
            });            
        }
    }
    
    /*
     Example response error in validate candidate model.
     
	    "error": [
	        "IDNumber::ID Type 1 Exists",
	        "IDNumber2::ID Type 2 Exists",
	        "IDNumber2::Cannot use the same ID."
	    ]
	
     */
    displayResponseErrors(responseErrors) {
    	var thisInstance = this;
    	var focusItem;
    	var itemErrorMap = {};
    	responseErrors.forEach(function(error) {
			var _err = error.split("::");
			var _errorComponent = _err[0];
			if (!itemErrorMap.hasOwnProperty(_errorComponent)) {
				itemErrorMap[_errorComponent] = [];
			}
			var errorMsg = _err[1];
			itemErrorMap[_errorComponent].push(errorMsg);
			thisInstance.displayComponentErrorMessage(_errorComponent, errorMsg);
			if (_errorComponent) {
				focusItem = _errorComponent;
			}
		});
    	// update errors for components with more than one error
    	Object.keys(itemErrorMap).forEach(function(component){
    		thisInstance.components[component].error = itemErrorMap[component];
    	});
    	this.form.showErrors();
    	if (focusItem) {  // focus to last error item
    		this.components[focusItem].focus();
    	}
    }

    /*
     * Error message is split into 2 with :: separator. 
     * First is the component key, and the second is the error message
     */
    displayComponentErrorMessage(componentKey, errorMsg, focusToItem) {
    	this.components[componentKey].addInputError(errorMsg, true);
    	this.components[componentKey].error = errorMsg;
    	this.form.showErrors();
    	if (focusToItem) {
        	this.components[componentKey].focus();
    	}
    }
    
    /**
     * Displays the loading icon.
     * 
     * @param {loadingFlag} Flag for displaying the loading icon.
     * @returns {loadingFlag|false}
     */
    loading(loadingFlag) {
    	try {
        	this.form.setLoading(this.form, loadingFlag);			
		} catch (e) {
			// NOOP
		}
    }
}