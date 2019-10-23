class ConfigForm extends SPEventAware {

	customValidation(submission, next) { 
    	if (this.form.errors.length == 0) {
    		next();
    	} else {
    		this.form.showErrors();
    	}
    };
	
	constructor(p_auth, apiBaseUrl, formContainerId, formId, formStorageId, ajaxUrl, namespace, userInfo, scopeGroupId) 
	{
		super();
        this._props = {
        		p_auth : p_auth,
                baseUrl : apiBaseUrl,
                formContainerId : formContainerId,
                formId : formId,
                formStorageId : formStorageId,
                ajaxUrl: ajaxUrl,
                namespace : namespace,
                components: {},
                userInfo: userInfo,
                scopeGroupId: scopeGroupId,
                formLogicHandler: new SPFormLogicHandler(this)
            };
            let currentHost = window.location.protocol + "//" + window.location.host;
            Formio.setBaseUrl(currentHost);
            Formio.setApiUrl(this.baseUrl);
            Formio.setAppUrl(currentHost);
            this._props.userRoles = userInfo.roles;
	}
		
	getProperty(property, defaultValue) {
		if (this._props.hasOwnProperty(property)) {
			return this._props[property];
		} else {
			return defaultValue;
		}
	}

    get components() {
        return this._props.components;
    }
    	
    submit() {
        if (this.form) this.form.submit();
    }
    
    // types: danger, info, warning, success
    displayMessage(thisInstance, type, message, duration) {
    	if (thisInstance.form) {
    		thisInstance.form.setAlert(type, message);
            if (duration) {
                setTimeout(function(){ thisInstance.form.setAlert(false); }, duration);
            }    		
    	}
    }
    
    _resetFileProviderAndEvalLogic(thisInstance, logicType) {
        FormioUtils.eachComponent(thisInstance.form.components, (component) => {
            if (component.type == 'file') {
            	var namespace = thisInstance._props.namespace;
            	let storageId = thisInstance.getProperty('formStorageId', 0);
            	component.component.storage = "url";
                component.component.url = thisInstance.getProperty('ajaxUrl', '')+'&'+ namespace
                	+'formId='+thisInstance.getProperty('formId', 0);
                
                // for file upload
            	var downloadUrl = thisInstance._props.ajaxUrl+'&'+namespace+'action=fileDownload'
        		+'&'+namespace+'fileName={FILE_NAME}'
        		+'&'+namespace+'groupId={GROUP_ID}';
                
                component.component.url = thisInstance._props.ajaxUrl;
                component.component.url += '&'+ namespace+'downloadUrlPattern='+encodeURIComponent(downloadUrl);

                if (storageId) {
                	component.component.url += '&'+ namespace+'formStorageId='+storageId;
                }
            }
            thisInstance._props.formLogicHandler.handleFormComponentLogic(logicType, component);
        }, true);        
    }
	
    populate(data, pkFieldName) {
    	if (this.form) {
    		this.form.setValue({data:data},{});
    		this._resetFileProviderAndEvalLogic(this, 'populate');
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
        
        if (options.hasOwnProperty('spAuthSite')) {
            this._props.spAuthSite = options.spAuthSite;
            this._props.spAuthSiteAccess = options.spAuthSiteAccess;
            delete options["spAuthSite"];
            delete options["spAuthSiteAccess"];
        }

        let addHiddenField = function(components, hiddenFieldName, defaultValue) {
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
                lockKey: true,
                defaultValue : defaultValue
            };
            components.splice(components.length-1,0,hiddenField);
        };

        let persistData = options.persistData || function(formInstance, formData, callBack) {
            var storageId = formInstance.getProperty('formStorageId', 0);
        	let userInfo = formInstance.getProperty('userInfo', {});
        	Liferay.Service(
			  '/SPDynamicForms-portlet.spdynamicforms/persist-form-storage',
			  {
			    userId: userInfo.userId,
			    formId: thisInstance.getProperty('formId', 0),
			    formStorageId: storageId,
			    jsonString: JSON.stringify(formData)
			  },
			  function(response) {
                  if (response.error) {
                      thisInstance.displayMessage('danger', response.error);
                  	thisInstance.emit('submitFailed', submission, response);
                  } else if(Object.keys(response).length === 0){
                  	thisInstance.displayMessage('danger', 'Save failed.');
                  	thisInstance.emit('submitFailed', submission, response);
                  } else {
              		var message = "Save successful.";
                      thisInstance.displayMessage('success', message);
                      thisInstance.formStorageId = response.formStorageId;
                  	if (callBack) {
                  		callBack(formInstance, response);
                  	} else {
	                    	thisInstance.emit('formDataPersisted', response);	
                  	}
                  }
			  }
			);
        };
        
        let loadReq = new SPAjax();
        let loadUrl = "/api/jsonws/SPMicroservice-portlet.spmicroservice/get-form/form-id/"
        	+ this.getProperty('formId', 0) + "?p_auth=" + Formio.platformAuth;
        
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
            // NOTE: there is currently no need for these in the config form, hence commented for now
//            let userInfo = thisInstance.getProperty('userInfo', {});
//            addHiddenField(d.components,"_USER_ID", userInfo.userId);
//            addHiddenField(d.components,"_USER_ROLES", userInfo.roles);
//            addHiddenField(d.components,"_GROUP_ID", thisInstance.getProperty('scopeGroupId', 0));
//            addHiddenField(d.components,"_COMPANY_ID", userInfo.companyId);
//            addHiddenField(d.components,"_USER_NAME", userInfo.fullName);
//            addHiddenField(d.components,"_USER_FIRST_NAME", userInfo.firstName);
//            addHiddenField(d.components,"_USER_LAST_NAME", userInfo.lastName);
//            addHiddenField(d.components,"_USER_EMAIL", userInfo.userEmail);
            
            Formio.createForm(document.getElementById(thisInstance.getProperty('formContainerId', '')), {components: d.components}, options).then((form) => {
                thisInstance.form = form;
                var storageId = thisInstance.getProperty('formStorageId', 0);
                
                FormioUtils.eachComponent(form.components, (component) => {
                    thisInstance._props.components[component.component.key] = component;
                }, true);
                
                form.on('error', function(errorArray) {
                    thisInstance.emit('error', errorArray);
                });
                form.on('submit', function(submission) {
            		persistData(thisInstance, submission.data);
//            		thisInstance.emit('formDataPersisted', response);
                });
                form.on('cancelForm', function(submission) {
                	thisInstance.emit('cancelForm', submission);
                });
                form.on('nextPage', function(page) {
                    thisInstance.emit('nextPage', page);
                });
                form.on('prevPage', function(page) {
                    thisInstance.emit('prevPage', page);
                });  
                form.on('change', function(changePayload) {
                    if (!changePayload.changed || !changePayload.changed.value) {
                        return; // no change yet
                    }
                    let changedItem = changePayload.changed.component.key;
                    let curValue = changePayload.changed.value;
                    let curData = changePayload.data[changedItem];
                    if (curValue === curData) {  
                        //notify form changed
                        thisInstance.form.setAlert(false);
                        thisInstance._props.formLogicHandler.handleFormComponentLogic('change', changePayload.changed.component);
                        thisInstance.emit('change', changePayload);
                    }
                });               
                form.on('render', function() {
                    thisInstance.afterFormLoaded(thisInstance);
                	thisInstance.emit('formLoaded');
                });
                
            });
        };
        let failHandler = function (reply) {
            loadReq.removeListener('failed', failHandler);
            thisInstance.emit('formLoadFailed', reply);
        };
        
        loadReq.get(loadUrl, null);
        loadReq.on('success', successHandler);
        loadReq.on('failed', failHandler);
    }
    
    ajaxCall(method, action, data, successHandler, failHandler) {
        let thisInstance = this;
        AUI().use('aui-base','aui-io-request-deprecated',function(A){
            let _data = {};
            let storageId = thisInstance.getProperty('formStorageId', 0);
            _data[thisInstance._props.namespace + 'formId'] = thisInstance.getProperty('formId', 0);
            if (storageId > 0) {
            	_data[thisInstance.getProperty('namespace', '') + 'formStorageId'] = storageId;
            }else{
            	_data[thisInstance.getProperty('namespace', '') + 'formStorageId'] = 0;
            }
            _data[thisInstance.getProperty('namespace', '') + 'action'] = action;
            if (data) {
                _data[thisInstance.getProperty('namespace', '') + 'data'] = JSON.stringify(data);              
            }
            A.io.request(thisInstance.getProperty('ajaxUrl', ''),{
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
    
    fixFormIOInlineStyle(formInstance) {
        AUI().one('#'+formInstance.getProperty('formContainerId', '')).all('input').each(function(input){
            let curStyle = input.getAttribute('style');
            if (curStyle != undefined && curStyle > "" && curStyle.indexOf('!important')<0) {
                input.setAttribute('style', curStyle.replace(/;/g,' !important;'));                         
            }
        });   	
    }
    
    afterFormLoaded(formInstance) {
    	var storageId = formInstance.getProperty('formStorageId', 0);
    	if (storageId > 0 ) {
        	Liferay.Service(
      			  '/SPDynamicForms-portlet.spdynamicforms/get-form-storage',
  			  {formStorageId: storageId},
  			  function(data) {
                  if (data.error || Object.keys(data).length === 0) {
                      formInstance.displayMessage(formInstance, 'danger', data.error);
                  } else {
                      formInstance.populate(data);
                      formInstance.fixFormIOInlineStyle(formInstance);
                  }
  			  }
  			);
        } else {
            formInstance._resetFileProviderAndEvalLogic(this, 'formLoad');
            formInstance.fixFormIOInlineStyle(formInstance);
        }
    }

    get userRoles() {
        return this._props.userRoles || "";
    }    
    
}