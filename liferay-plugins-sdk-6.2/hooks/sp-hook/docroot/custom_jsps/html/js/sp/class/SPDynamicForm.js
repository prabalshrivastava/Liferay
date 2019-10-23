/*
 * This javascript class is written in ES6.
 * As of writing, ES6 is not yet fully supported by most browsers.
 * Hence, we need to separate the script so we can use Babel to translate it to ES5.
 */
class SPDynamicForm extends SPForm { 
    constructor(apiUrl,formType, formContainerId, formId, formStorageId, ajaxUrl, namespace){
        super(apiUrl, formContainerId, formId, ajaxUrl, namespace);
        this.formStorageId = formStorageId;
        this.formType = formType;
    };
    
    // override ajaxCall to include the formStorageId
    // for data retrieval and saving
    ajaxCall(method, action, data, successHandler, failHandler) {
        let thisInstance = this;
        AUI().use('aui-base','aui-io-request-deprecated',function(A){
            let _data = {};
            _data[thisInstance.namespace + 'formId'] = thisInstance.formId;
            if (mode == "edit" || mode == "view" ||  (mode == "copy" && method == "GET" )) {
            	_data[thisInstance.namespace + 'formStorageId'] = thisInstance.formStorageId;
            }else{
            	_data[thisInstance.namespace + 'formStorageId'] = "0";
            }
            _data[thisInstance.namespace + 'formType'] = thisInstance.formType;
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
    };
    
    customSubmission(submission) {
        let thisInstance = this;
        this.ajaxCall('POST', 'persist', submission.data,
            function() {
                let data = this.get("responseData");
                if (data.error) {
                    thisInstance.displayMessage('danger', data.error);
                    thisInstance.emit('persistFailed', data);
                }else if(Object.keys(data).length === 0){
                	thisInstance.displayMessage('danger', 'Form submission failed.');
                	failedFormSubmissionFormIOForm(thisInstance);
                	thisInstance.emit('persistFailed', data);
                }else {
                	console.log(data.toString());
            		var message = "Form successfully submitted.";
                	if(submission.data.Status == "Draft") message = "Record is saved in draft";
                	
                    thisInstance.displayMessage('success', message);
                    thisInstance.formStorageId = data.storageId;
                    afterFormSubmissionFormIOForm(thisInstance);
                    thisInstance.emit('persistSuccess', data);
                }
            },
            function() {
                thisInstance.displayMessage('danger', "Error in persisting dynamic form data.");
//              thisInstance.debug("Error in persisting dynamic form data.");
        });
    };
    customValidation1(submission, next) {
    	let thisInstance = this;
    	validate(thisInstance);
    };
    enableButtons(thisInstance){
    	if( typeof thisInstance.components.Deactivate != "undefined"){
			thisInstance.components.Deactivate.disabled =  false;
		}
		if( typeof thisInstance.components.Reactivate != "undefined"){
			thisInstance.components.Reactivate.disabled =  false;
		}
		if( typeof thisInstance.components.Cancel != "undefined"){
			thisInstance.components.Cancel.disabled =  false;
		}
		if( typeof thisInstance.components.Clear != "undefined"){
			thisInstance.components.Clear.disabled =  false;
		}
		if( typeof thisInstance.components.Edit != "undefined"){
			thisInstance.components.Edit.disabled =  false;
		}
    };
    afterFormLoaded() {
        let thisInstance = this;
        var lastModifiedBy =  document.getElementsByClassName("lastModifiedBy");
		
        if((mode == "create") || mode == "copy"){
        	if(lastModifiedBy != null && lastModifiedBy.length > 0){
        		lastModifiedBy[0].style.opacity = 0;
        	}
			
		}
        afterFormLoadedFormIOForm(thisInstance);
        
        if (thisInstance.formStorageId && thisInstance.formStorageId!=0 ) {
            thisInstance.ajaxCall('GET', 'loadData', {},
                function() {
                    let data = this.get("responseData");
                    console.log(data);
                    
            		
                    if (data.error || Object.keys(data).length === 0) {
                        thisInstance.displayMessage('danger', data.error);
                    } else {
                    	if(typeof dontLoadData == "undefined" || dontLoadData == false){
                    		data.contentJson.Mode = mode;
                    		if(typeof thisInstance.components.Submit != "undefined"){
                    			thisInstance.components.Submit.buttonElement.textContent = "Update";
                    		}
                    		if(mode == "view"){
                    			
                    			setTimeout(function(){ 
                    				
                    				thisInstance.enableButtons(thisInstance);
                    				
                    			
                    			}, 1000);
                    			
                    			
                    			
                    		}
                    		if(mode == "copy"){
                    			data.contentJson.Status = "Draft";
                    			thisInstance.components.Status.setValue("Draft");
                    			thisInstance.components.Submit.buttonElement.textContent = "Publish";
                    		}
                    		
                    		
                            thisInstance.populate(data.contentJson);
                            thisInstance.fixFormIOInlineStyle(thisInstance);
                            afterFormDataLoadedFormIOForm(thisInstance);
                            
                            SPFormPermissionHandler.checkPermission(thisInstance);
                            
                    	}
                    	
                        
                    }
                },
                function() {
                    thisInstance.displayMessage('danger', "Error retrieving form storage");
//                  thisInstance.debug("Error retrieving form storage");
            });
        } else {
    		SPFormPermissionHandler.checkPermission(thisInstance);
        }
    };
 
};

