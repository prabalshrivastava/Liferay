//startup TABS

function startuptabs(evt, tabName) {
evt.preventDefault();
    
     var i, tabcontent, tablinks;
    tabcontent = document.getElementsByClassName("tabdetails-content");
    for (i = 0; i < tabcontent.length; i++) {
        tabcontent[i].style.display = "none";
    }
    tablinks = document.getElementsByClassName("tablinks");
    for (i = 0; i < tablinks.length; i++) {
        tablinks[i].className = tablinks[i].className.replace(" is-active", "");
    }
    document.getElementById(tabName).style.display = "block";
    evt.currentTarget.className += " is-active";
}

//startup TAB END

function initAutoCompleteFormField(A, inputNode, otherAction, onSelectCallback){
	if (inputNode) {
		var action = (otherAction) ? otherAction : "get_projects";
		var inputNodeSelector = '#'+inputNode;
//		console.log('init autocomplete ->> '+inputNodeSelector);
		AUI().use('autocomplete-list', 'aui-base', 'aui-io-request', 'autocomplete-filters','autocomplete-highlighters',
				function (A) {
					var testData;
					var ac = new A.AutoCompleteList(
					{
						allowBrowserAutocomplete : 'true',
						activateFirstItem : 'true',
						inputNode : inputNodeSelector,
						resultTextLocator : 'name',
						render : 'true',
						resultHighlighter : 'phraseMatch',
						resultFilters : [ 'phraseMatch' ],
						source : function() 
						{
							var inputValue = A.one(inputNodeSelector).get('value');
							var myAjaxRequest=A.io.request(ajax,{
								dataType : 'json',
								method : 'POST',
								data : {
									action: action,
									searchText : inputValue,
									sp_p_auth: getAuthToken()
								},
								autoLoad : false,
								sync : false,
								on : {
									success : function() {
										var data = this.get('responseData');
										testData = data;
									}
								}
							});
							myAjaxRequest.start();
							return testData;
						},
					});
					if (ac) {
						ac.after('select', function (e) {
						    if (onSelectCallback) {
						    	onSelectCallback(e);
						    }
						});
					}
 				});
	}
}

var ajax;
var isNew = true;
var orgNameId;
var rightOffset = 160;
var isSafari = navigator && navigator.userAgent && navigator.userAgent.toLowerCase().indexOf('safari');
function initialize(errorMessage1,profileSaveMessage,successMessage,profileError,errorMessage,errorMessage2,errorMessage3,deleteConfirmMsg,removeSuccessMsg,removeFailedMsg,removeFailRefreshMsg,thankuMsg,startupFailMsg,viewBrief,goToProfile,okLabel,ajaxUrl, isAddStartup, notAnimated) {
	ajax = ajaxUrl;
	orgNameId = namespace + "organization_name";
	initDynamicSections(deleteConfirmMsg,removeSuccessMsg,removeFailedMsg,removeFailRefreshMsg,successMessage,errorMessage,errorMessage3);
	if(organization) {
		isNew = false;
		populateData();
		onloadFormWrapper(notAnimated);
		challengeSectionClick();
	} else {
		// new button panel will be hidden by default..if create page..remove the hidden attribute
//		AUI().use('aui-node','aui-base','aui-io-request-deprecated', function(A) {
//			if (A.one(".sp_profile .head"))
//				A.one(".sp_profile .head").removeClass("hide-content");
//		});
		onloadFormWrapper(notAnimated);
	}
	// for IE 9 image upload 
	try{
		if(lowerVBrowser == 'true'){
			toggleFormDirty(true);
			if(logoError && logoError != '' && logoError != 'null'){
				displayMessage(logoError);
			}
			if(!organization){
				onloadFormWrapper(notAnimated);
			}
		}
	}catch(error){}
	registerAllTextAreaListener();
	if (isAddStartup) {
		initFilledBySelect();
		initSubmit(errorMessage1,profileSaveMessage,successMessage,profileError,errorMessage,errorMessage2,errorMessage3,thankuMsg,startupFailMsg,viewBrief,goToProfile,okLabel);
		//initCustomValidataions();
		initRemoveLogo('logo');
		initRemoveLogo('cover');
		showHideRemoveImageLink('logo');
		showHideRemoveImageLink('cover');
		if(organization && organization.organizationId) {
			updateOtherFiles(organization.organizationId);
			initPreview();
		}
	}
}

function checkOrgName(erromessage1,errormessage2){
	var A = AUI().use('aui-node','aui-base','aui-io-request-deprecated');
	var exists = false;
	var orgId = "";
	if (organization){
		orgId = organization.organizationId;
	}
	A.io.request(ajax,{
		dataType : 'json',
		method : 'POST',
		sync : true,
		data : {
			action : 'orgNameCheck',
			orgId :  orgId,
			name : A.one("#" + orgNameId).get('value'),
			sp_p_auth: getAuthToken()
		},
		on : {
			success : function() {
				var data = this.get('responseData');
				//var nameErrDiv =  A.one("#orgNameError");
				if(data && data.errorMsg){
					exists = true;
				}else{
					exists = false;
				}
			},
			failure : function() {
				if(isActiveUser()) {
					alert(errormessage1);
				} else {
					alert(errormessage2);
					window.location.href= "/signin";
				}
			}
		}
	});
	
	return !exists;
}

function checkEmailAddress(erromessage1,errormessage2){
	var A = AUI().use('aui-node','aui-base','aui-io-request-deprecated');
	var exists = false;
	var orgId = "";
	if (organization){
		orgId = organization.organizationId;
	}
	A.io.request(ajax,{
		dataType : 'json',
		method : 'POST',
		sync : true,
		data : {
			action : 'orgEmailAddressCheck',
			emailAddress : A.one("#"+ namespace+"organization_emailId").get('value'),
			sp_p_auth: getAuthToken()
		},
		on : {
			success : function() {
				var data = this.get('responseData');
				if(data && data.errorMsg){
					exists = true;
				}else{
					exists = false;
				}
			},
			failure : function() {
				if(isActiveUser()) {
					alert(erromessage1);
				} else {
					alert(erromessage2);
					window.location.href= "/signin";
				}
			}
		}
	});
	
	return !exists;
}

function checkPassword(fldNode,errorMessage){
	var A = AUI().use('aui-node','aui-base','aui-io-request-deprecated');
	var valid = false;
	var errorMesssage; 

	A.io.request(ajax,{
		dataType : 'json',
		method : 'POST',
		sync : true,
		data : {
			action : 'passwordCheck',
			pw1 : A.one("#"+ namespace+"login_pwd1").get('value'),
			pw2 : A.one("#"+ namespace+"login_pwd1").get('value'),
			sp_p_auth: getAuthToken()
		},
		on : {
			success : function() {
				var data = this.get('responseData');
				if(data && data.isValidPassword){
					valid = true;
				}else if(data && data.passErrMsg){
					errorMesssage = passwordErrorMap[data.passErrMsg];
					valid = false;
				}
			},
			failure : function() {
				alert(errorMessage);
			}
		}
	});
	
	if (!valid) {
		var myFormValidator = Liferay.Form.get(namespace+'addStartup').formValidator; 
		var _ruleData = myFormValidator.get('fieldStrings')[fldNode.get('name')]; 		
		for(var i in _ruleData){ 
			if(i.indexOf('custom')==0){
				myFormValidator.get('fieldStrings')[fldNode.get('name')][i] = errorMesssage;
			}
		}
	}
	
	return valid;
}

function initSubmit(errorMessage1,profileSaveMessage,successMessage,profileError,errorMessage,errorMessage2,errorMessage3,thankuMsg,startupFailMsg,viewBrief,goToProfile,okLabel) {
	AUI().use('aui-node','aui-base','aui-io-request-deprecated','aui-form-validator',function(A){
		var submitButton = A.all(".submit");
		if(!submitButton)
			return;
		submitButton.on("click", function () {
			var customAction;
			customAction = this._nodes[0].getAttribute('customAction');				
			if (formDirty && !customAction) {
				startPreLoader('profile_forms_wrap');
				addStartup(profileError,successMessage,errorMessage,errorMessage3,thankuMsg,startupFailMsg,true);			
				stopPreLoader('profile_forms_wrap');
			}
			var validator = eval('Liferay.Form._INSTANCES.' + namespace + 'addStartup.formValidator');
			validator.validate();
			if (validator.hasErrors()) {
				var formR = A.one('.formFields_data');
				formR.empty();
				showReviewTab();
				var errorNodes = A.all(".form_review .error");
				var firstError = null;
				errorNodes.each(function (node) {
					if(firstError == null)
						firstError = node;
					try {
						try {
							node.one('.error-field').setAttribute('placeholder', "Click here to edit");
							node.one('.error-field').removeAttribute('disabled');
							node.one('.error-field').setAttribute('readonly', 'true');
						} catch (err1) {}
						node.on('click', function (e) {
							// move to tab with the field with error
							var targ = e.currentTarget;
							var tab =  A.one("#" + namespace + "addStartup #" + targ.get("id")).ancestor(".form").getAttribute("form-name");
							gotoTab(tab);
							// scroll to the error field
							window.setTimeout(function() {
								try {
									var temp = A.one('.smartForm #' + arguments[0].one('input, select, textarea').getAttribute('name'));
									if (temp !=null) {
										scrollTo(0, temp.getY() - rightOffset);
									}
								} catch (err){}
							}, 1500, targ);
						});
					} catch (errr) {
						console.log(errr);
					}
				});
				// scroll to first error on the review tab
				alert(errorMessage1);
				if (firstError != null) {
					scrollTo(0, firstError.getY() - rightOffset);
				} else {
					gotoTab('form_1');
				}
				return;
			} else {
				submitButton.attr('disabled','disabled');
				startPreLoader('profile_forms_wrap');
				if (customAction) {
					addStartup(profileError,successMessage,errorMessage,errorMessage3,thankuMsg,startupFailMsg,true, customAction);
					stopPreLoader('profile_forms_wrap');
				} else {
					A.io.request(ajax,{
						dataType : 'json', method : 'POST',
						data : {
							action : 'profileComplete',
							orgId :  organization.organizationId,
							sp_p_auth: getAuthToken(),
							orgVideoLinkList: getVideoLinksToSave(A),
							orgBrandList: getBrandsToSave(A),
							orgProjectList: getProjectsToSave(A)
						},
						on : {
							success : function() {
								stopPreLoader('profile_forms_wrap');
								var data = this.get('responseData');
								var message = '';
								var titleMsg = '';
								var cancel = '';
								if (data) {
									if(data.success == 'success') {
										message = profileSaveMessage;
										titleMsg = successMessage;
										cancel = data.displayPathUrl;
										displayMessage2(message,titleMsg, cancel,viewBrief,goToProfile,okLabel);
									} else {
										message = profileError;
										titleMsg = errorMessage;
										displayMessage(message,titleMsg);
									}
								}
							},
							failure : function() {
								stopPreLoader('profile_forms_wrap');
								if(isActiveUser()) {
									alert(errorMessage2);
								} else {
									alert(errorMessage3);
									window.location.href= "/signin";
								}
							}
						}
					});					
				}
			}
		});
		}
	);
}

function getVideoLinksToSave(A) {
	var videoLinks = A.all('#video-url-fields .lfr-form-row:not(.hide) input').val();
	if (videoLinks && videoLinks.length > 0) {
		videoLinks = JSON.stringify(videoLinks);
//		console.log('saving video links: '+ videoLinks);
	} else {
		videoLinks = null;
	}
	return videoLinks;
}

function getBrandsToSave(A) {
	var brands = A.all('#projects-auto-fields .lfr-form-row:not(.hide) select').val();
	if (brands && brands.length > 0) {
		brands = JSON.stringify(brands);
//		console.log('saving brands: '+ brands);
	} else {
		brands = null;
	}
	return brands;
}

function getProjectsToSave(A) {
	var projects = A.all('#projects-auto-fields .lfr-form-row:not(.hide) input').val();
	if (projects && projects.length > 0) {
		projects = JSON.stringify(projects);
//		console.log('saving projects: '+ projects);
	} else {
		projects = null;
	}
	return projects;
}

function challengeSectionClick(){
	AUI().use('aui-node','aui-base','aui-io-request-deprecated',function(A){
		A.all(".challenge_section").each(function(obj){
			obj.on("click",function(e) {
				document.location.href = this.getAttribute("data-link");
			});
		});
	});
}

function onloadFormWrapper(isNotAnimated){
	if (isNotAnimated) {
		onloadFormNonAnimated();
	} else {
		onloadForm();
	}
}

function onloadForm(){
	YUI().use('event-hover','node', 'transition', 'event', 'event-valuechange',  function (Y) {
		try {
			var profileContent = Y.one('.profile_content');
			profileContent.addClass('active');
			profileContent.removeClass('slideOutDown');
			profileContent.addClass('animated slideInDown');

			var head = Y.one('.sp_profile .head');
			if(head) {
				var headW = head.one('.head_wrap');
				head.addClass('no_height ');
				headW.addClass('animated3 ');
				head.setStyle('display', 'none');
			}
			var profFormNav = Y.one('.profile_form_navigation');
			var profCont = Y.one('.profile_content');
			var time1 = Y.later(1000, profCont, function() {
				profileContent.removeClass('slideInDown');
				//profFormNav.addClass('posFixed');
			}, [], false);

		} catch(err) {}
	});
	
}

function onloadFormNonAnimated(){
	YUI().use('event-hover','node', 'transition', 'event', 'event-valuechange',  function (Y) {
		try {
			var profileContent = Y.one('.profile_content');
			profileContent.addClass('active');
			var head = Y.one('.sp_profile .head');
			if(head) {
				var headW = head.one('.head_wrap');
				head.addClass('no_height ');
				head.setStyle('display', 'none');
			}
			var profFormNav = Y.one('.profile_form_navigation');
			var profCont = Y.one('.profile_content');
		} catch(err) {}
	});
	
}

function initDynamicSections(deleteConfirmMsg,removeSuccessMsg,removeFailedMsg,removeFailRefreshMsg,successMessage,errorMessage,errorMessage3) {
	
	AUI().use('aui-node','aui-base','aui-io-request-deprecated',function(A){
 		 try {
		  A.one('#fundingRound1 .addButton').on('click', function() {
				addSection(deleteConfirmMsg,removeSuccessMsg,removeFailedMsg,removeFailRefreshMsg,successMessage,errorMessage,errorMessage3,"fundingRound", A);
		  });
		 
 		 } catch(err) {}
	 });
}

function addSection(deleteConfirmMsg,removeSuccessMsg,removeFailedMsg,removeFailRefreshMsg,successMessage,errorMessage,errorMessage3,fieldName) {
	AUI().use('aui-node','aui-base','aui-io-request-deprecated',function(A){
		var sampleCont = A.one("#" + fieldName + "1");
		var container = A.one('#' + fieldName +'Container');
		var dup = sampleCont.clone();
		var inputs = dup.all(".field");
		if(dynaSectionCounters[fieldName] == undefined)
			dynaSectionCounters[fieldName] = 2;
		var counterStr = fieldName + dynaSectionCounters[fieldName];
		inputs.each(function(inp) {
			try {
				var id = inp.get("name").replace(fieldName + "1", counterStr);
				inp.set("name", id);
				inp.set("id", id);
				inp.val("");
				try {inp.ancestor('.success').removeClass("success");} catch (e) {}
				try {inp.ancestor('.error').removeClass("error");} catch (e) {}
				inp.on("change",function(){
					toggleFormDirty(true);
				});
			}catch (err) {
				//console.log(err);
			}
		});
		dup.set("id", counterStr);
		dup.appendTo(container);
		dup.one(".removeButton").setStyle('display','inline-block').on("click",function(e){
			var result = window.confirm(deleteConfirmMsg);
			if(result){
				var ancestor = this.ancestor(".formGroupfield");
				var rid = namespace + ancestor.get("id") + "_" + ancestor.getAttribute("data-identifier");
				var dbIdObj = A.one("#" + rid);
				if(dbIdObj){
					try{
						var dbId = dbIdObj.get("value");
						if(dbId != null && dbId !="" && dbId != "0"){
							A.io.request(ajax,
									{
										dataType : 'json',
										method : 'POST',
										data : {
											dbId : dbId,
											action : 'delete',
											orgId :  organization.organizationId,
											name : ancestor.getAttribute("data-identifier"),
											sp_p_auth: getAuthToken()
										},
										on : {
											success : function() {
												var message = '';
												var titleMsg = '';
												if(this.get("responseData") == 'success') {
													message = removeSuccessMsg;
													titleMsg = successMessage;
												} else {
													message = removeFailedMsg;
													titleMsg = errorMessage;
												}
												displayMessage(message,titleMsg);
											},
											failure : function() {
												if(isActiveUser()) {
													alert(removeFailRefreshMsg);
												} else {
													alert(errorMessage3);
													window.location.href= "/signin";
												}
											}
										}
									});
						}
					}catch(error){
						
					}
				}
				this.ancestor(".formGroupfield").remove();
				
			}
		});
		dup.one(".addButton").on("click",function(){
			addSection(deleteConfirmMsg,removeSuccessMsg,removeFailedMsg,removeFailRefreshMsg,successMessage,errorMessage,errorMessage3,fieldName, A);
		});
		var tAreas = dup.all("textarea");
		tAreas.each(function(ta) {
			registerTextAreaListener(ta);
		});
		dynaSectionCounters[fieldName] = dynaSectionCounters[fieldName] + 1;
	});
 }

function registerAllTextAreaListener() {
	YUI().use('event-hover','node', 'transition', 'event', 'event-valuechange',  function (Y) {
		Y.later(2000, null, function(t) {
			try {
				var tAreas = Y.all(".smartForm textarea");
				tAreas.each(function(ta) {
					ta.setStyle("resize", "none");
					ta.setStyle("overflow-y", "hidden");
					registerTextAreaListener(ta);
					try {resizeTA(ta);}catch(err){}
				});
			} catch (err) {}
		},[],false);
	});
}

function initFilledBySelect() {
	AUI().use('aui-node', 'aui-base', function(A) {
		try {
			var selectBox = A.one(".filledBySelect");
			var sourceName = A.one("#" + namespace + "founder1_name");
			var sourceEmail = A.one("#" + namespace + "founder1_emailId");
			var destName = A.one("#" + namespace + "fillBy_name");
			var destEmail = A.one("#" + namespace + "fillBy_emailId");
			selectBox.on("change", function() {
				try {
					var val = this.get("value");
					if (val == '1') {
						destName.val(sourceName.val());
						destEmail.val(sourceEmail.val());
						A.one("#" + namespace + "fillBy_title").val('Founder');
					} else if (val == '0') {
						destName.val("");
						destEmail.val("");
						A.one("#" + namespace + "fillBy_title").val("");
					}
				} catch (e) {}
			});
		} catch (e) {
		}
	});
}

function resizeTA(ta) {
	var height = ta.getStyle('height').replace('px', '');
	var taHeight = ta.get('scrollHeight');
	if(taHeight > height) {
		ta.setStyle("height", taHeight + "px");
	}
}
function registerTextAreaListener(ta) {
	AUI().use('aui-node', 'aui-base', function(A) {
		ta.on("keydown", function() {
			resizeTA(this);
		});
	});
}

function disableAllFields() {
	AUI().use('aui-node', 'aui-base', function(A) {
		var inputs = A.all(".smartForm .field, .smartForm select, .smartForm textarea");
		if(inputs) {
			inputs.each(function() {
				this.setAttribute('disabled', 'true');
			});
		}
	});
}

function hideAllButtons() {
	AUI().use('aui-node', 'aui-base', function(A) {
		var buttons = A.all(".smartForm .formCTA");
		if(buttons) {
			buttons.each(function() {
				this.setStyle("display", "none");
			});
		}
		buttons = A.all(".smartForm .multipleCTA");
		if(buttons) {
			buttons.each(function() {
				this.setStyle("display", "none");
			});
		}
	});
}

function populateData(){
	var form = null;
	AUI().use('aui-node', 'aui-base',
	function(A) {
		form = A.one("#" + namespace + "addStartup");
		
		var ele = form.all(".field, select");
		var len = namespace.length;
		ele.each(function(){
			var name = this.get("name");
			
			try {
				name = name.substring(len);
				name = name.replace("_", ".");
				var data = eval(name);
				if (name==='organization.foundedOn') {
					data = eval('organization.foundedOnH5Format');
					
					if (this.val(data)._node.value == ""){
						data = eval('organization.foundedOn');
					}
				}
				var val = this.val(data);
			}catch(err){
				
			}
		});
		
		try {
			if ((fillBy.name == founder1.name) && (fillBy.emailId == founder1.emailId))
				A.one(".filledBySelect").val(1);
			else
				A.one(".filledBySelect").val(0);
			var showInBlackbook = organization.showInBlackbook;
			AUI().one(namespace+'showInBlackbook').one('option[value="'+showInBlackbook+'"]').setAttribute('selected','');
		} catch (err){}
	});
	
	
}

function addMultiSectionsToForm(deleteConfirmMsg,removeSuccessMsg,removeFailedMsg,removeFailRefreshMsg,successMessage,errorMessage,errorMessage3,fieldName, A) {
	for (var i = 2;; i++) {
		try {
			eval(fieldName + i);
			addSection(deleteConfirmMsg,removeSuccessMsg,removeFailedMsg,removeFailRefreshMsg,successMessage,errorMessage,errorMessage3,fieldName, A);
		} catch (err) {
			//console.log("Failed to add multiSectionsToForm.");
			break;
		}
	}
}

function addTeamMembersToForm(fieldName, A) {
	for (var i = 1;; i++) {
		try {
			var obj=eval(fieldName+i);
			if(obj.memberUserId!= undefined)
				addTeamMemberToDiv(obj.memberUserId, obj.name,obj.imageUrl);
		} catch (err) {
			break;
		}
	}
}

function setFieldValue(form, fieldName, val) {
	var temp = namespace + fieldName;
	try {
		form.getById(temp).val(val);
	}catch (err){
		//console.log(err);
	}
}

function getSelectedValues(selectNode) {
	try {
		var arr = AUI().one(selectNode).all('option:selected').val();
	    return arr.join();		
	} catch(e) {
		if (console) console.log(e);
		return null;
	}
}

function addStartup(profileError,successMessage,errorMessage,errorMessage3,thankuMsg,startupFailMsg,sync, customAction) {
	var obj = {};
	AUI().use('aui-node', 'aui-base', function(A) {
		var multiSelectCategoryObj=document.getElementById(namespace+'multiSelectCategory').querySelectorAll(':checked');
		var selectedCategories={};
		for(var idx=0;idx<multiSelectCategoryObj.length;idx++){
			selectedCategories[idx]=multiSelectCategoryObj[idx].value;
		}
//		console.log(selectedCategories);
		var ele = A.all(".smartForm .field, .smartForm  select");
		var len = namespace.length;
		ele.each(function(){
			var name = this.get("name");
			name = name.substring(len);
			var val = this.val();
			if(val != null)
				obj[name] = val;
		});
		
		obj['action'] = customAction ? customAction : 'import';
		obj['sp_p_auth'] = Liferay.authToken;
		obj['asset_orgCategoryList']=selectedCategories;
		if (organization){
			obj['orgId'] = organization.organizationId;
			
		}
		if (customAction) {
			A.all(".smartForm  select").each(function(){
				var name = this.get("name").substring(len);
				obj[name] = getSelectedValues(this);
			});
		}
			
		try {
		obj['apiPath'] = A.one(".apiPath").text();
		}catch(err){}
		
		obj['orgVideoLinkList'] = getVideoLinksToSave(A);
		obj['orgBrandList'] = getBrandsToSave(A);
		obj['orgProjectList'] = getProjectsToSave(A);

		sync = sync ? sync : false;
		
		if (console) {console.log('action to call => '+obj);}
		
		A.io.request(ajax,
				{
					dataType : 'json',
					method : 'POST',
					data : obj,
					sync:sync,
					timeout:180000,
					on : {
						success : function() {

							var message = '';
							var boxTitle = '';
							if (console) {console.log('response data => '+this.get("responseData"));}
							if(!this.get("responseData") || this.get("responseData") == 'fail') {
								message = profileError;
								boxTitle = errorMessage;
							} else if (this.get("responseData").passErrMsg || this.get("responseData").emailErrMsg) {
								message = '<p>' 
									+ (this.get("responseData").passErrMsg) 
										? passwordErrorMap[this.get("responseData").passErrMsg] 
										: this.get("responseData").emailErrMsg
									+ '</p>';
								boxTitle = 'Error!';
								displayMessage(message,boxTitle, function(dialog){
									showSignupForm('1');
									dialog.hide();
								});
								return;
							} else if (this.get("responseData").orgId) {
								if (obj.action === 'signup') {
									message = thankuMsg +obj.organization_emailId+'</p>';
									boxTitle = successMessage;
									dashBoardUrl = '/signin';
									displayMessage(message,boxTitle, cancel, 560, 205);
								} else {
									try {
										if (!organization) {
											organization = {};
										}
										if (this.get('responseData').orgId != "-1") {
											organization.organizationId = this.get('responseData').orgId;
											initPreview();
											if (this.get('responseData').dashBoardUrl) {
												dashBoardUrl = this.get('responseData').dashBoardUrl;
											}
										}
									}catch(err) {}
									try {
										if (this.get('responseData').orgId != "-1") {
											obj['orgId'] = this.get('responseData').orgId;
										}
									}catch(err) {}									
								}
								return;
							} else if (this.get("responseData").errorMsg) {
								message = this.get("responseData").errorMsg;
								boxTitle = "Error!";
							}
							if(message != ""){
								displayMessage(message,boxTitle);
							}	
						},
						failure : function(e) {
							if(isActiveUser()) {
								alert(startupFailMsg);
								if (console) {
									console.log('failure for action - '+ obj.action);
									console.log(e);
								}
							} else {
								alert(errorMessage3);
								window.location.href= "/signin";
							}
						}
					}
				});
		
	});

	return true;
}

function isActiveUser() {
	var activeUser = false;
	var A = AUI().use('aui-node','aui-base','aui-io-request-deprecated','aui-form-validator');
	// TODO need to make this configurable
	A.io.request('/profile',{
		method : "GET",
		sync: true,
		on : { 
			success: function(){activeUser = true}, failure: function() {activeUser=false;}
		}
	});
	return activeUser;
}

function saveFormData(profileError,successMessage,errorMessage,errorMessage3,thankuMsg,startupFailMsg) {
	addStartup(profileError,successMessage,errorMessage,errorMessage3,thankuMsg,startupFailMsg,true);
}
function fireRatingEvent(uuid){
	try{
		AUI().use('aui-node', 'aui-base', function(A) {
			A.on('domready', function () {
				var data = {
						objId : uuid,
						name: 'profile portlet'
				}
				Liferay.fire('spratingportletevent',  data);
			});
			
		});
		
	}catch(err){
		
	}
}

function initImageDragDiv(type, namespace,ajaxUrl){
	var typeUpper = toTitleCase(type);
	AUI().use('aui-node', 'aui-base', function(A) {
		//1. enable file upload
		if (window.File && window.FileList && window.FileReader) {
			try {
				var action = "upload"+typeUpper;
				var obj1 = new profileFileDragAndDrop();
				var afterFileUpload = function(jsonObj){
					try{
						AUI().use('aui-node','aui-base',function(A){
							if(jsonObj[type+"Url"]){
								A.one("#" + type +"Img").set("src",jsonObj[type+"Url"]);
//								A.one("#" + namespace +"remove" + typeUpper).set('value', false);//todo remove this
								showHideRemoveImageLink(type);
							} else if (type == 'otherFiles' && jsonObj == 'success') {
								if(organization.organizationId)
									updateOtherFiles(organization.organizationId);
								try {A.one('#' + namespace + "startup" + typeUpper).val('');}catch(err){}
							} else if(jsonObj.errorMsg){
									displayMessage(jsonObj.errorMsg);
							}
						});
					}catch(error){
					}
				}
				obj1.Init(type, 'filedrag' + type,'filesTable','startup'+typeUpper,ajaxUrl,'draganddrop',namespace,action,afterFileUpload);
				obj1.Init(type, 'filedrag' + type,'filesTable','startup'+typeUpper,ajaxUrl,'fileInput',namespace,action,afterFileUpload);
			} catch (err) { }
		} else {
			try {
				var fileObj = A.one("#" + namespace + "startup" + typeUpper);
				A.one("#filedrag" + type).removeClass("fd_container");
				A.one("#filedrag" + type + " .fdWrap").setContent('');
				fileObj.on('change',function(e){
					if (organization == null || !organization.organizationId) {
						try {
							var validator = eval('Liferay.Form._INSTANCES.' + namespace + 'addStartup.formValidator');
							validator.resetAllFields();
							validator.validateField(namespace+'organization_name');
							if(!validator.hasErrors()) {
								addStartup(submitError,successMsg,errorMsg,sessionTimeOut,thankUMsg,startupSaveFail,true);
							}
						}catch(error){
						}
					}
					
					var form = A.one("#" + namespace+ "addStartup");
					var ordIdObj = A.one("#" + namespace + "orgId");
					if (organization) {
						ordIdObj.set('value',organization.organizationId);
					}
					form.getDOMNode().submit();
				});
			} catch (err) { }
			}
		
		try {
		// update logo..cover and other images
		if( type == 'others') {
			updateOtherFiles();
		} else {
			if (logoObj && logoObj.logoUrl) {
				A.one("#logoImg").set("src",logoObj.logoUrl);
			}
			if (coverObj && coverObj.logoUrl) {
				A.one("#coverImg").set("src",coverObj.logoUrl);
			}
		}
		} catch (err){
		}
	});
}

function updateOtherFiles(orgId) {
	var A = AUI().use('aui-node','aui-base','aui-io-request-deprecated', function(A) {
		var obj = {};
		obj.action = 'getShowcaseFileDetails';
		obj.orgId = orgId;
		obj.sp_p_auth = getAuthToken();
		A.io.request(ajax,{
			dataType : 'json',
			method : 'POST',
			data : obj,
			on : { 
				success : function() {
					var responseData = this.get("responseData");
					var sampleFileEntry = A.one('#sampleFileEntry');
					var container = A.one('#otherFilesTable');
					if (responseData.length > 0)
						container.html('');
					for (i = 0; i < responseData.length; i++) {
						var arr = responseData[i].split('::');
						var filename = arr[0];
						var fileEntryId = arr[1];
						var fileIcon = arr[2];
						var isDraft = arr[3];
						var entryBox = sampleFileEntry.clone();
						entryBox.set('id', fileEntryId);
						entryBox.one('.fileEntryImg img').set('src' , fileIcon);
						entryBox.one('.fileEntryTitle').html(filename);
						if (isDraft && isDraft == 'true')
							entryBox.one('.fileEntryTitle').addClass('success');
						else
							entryBox.one('.fileEntryTitle').addClass('pending');
						entryBox.one('.fileEntryCta > a').set('href', 'javascript:deleteFileEntry(' + fileEntryId + ');');
						entryBox.removeClass('hide');
						entryBox.appendTo(container);
					}
				}, 
				failure: function() {activeUser=false;}
			}
		});
	});
}

function deleteFileEntry(id, type) {
	var result = window.confirm(deleteConfirm);
	if (!result){
		return false;
	}
	if (id == 0) {
		if (type == 'logo') {
			if (logoObj == null)
				return;
			id = logoObj.fileEntryId;
		}
		if (type == 'cover') {
			if (coverObj == null)
				return;
			id = coverObj.fileEntryId;
		}
	}
		
	AUI().use('aui-node', 'aui-base', 'aui-io-request-deprecated',
		function(A) {
			var obj = {};
			obj.action = 'deleteFileEntry';
			obj.fileEntryId = id;
			obj.sp_p_auth = getAuthToken();
			obj.orgId = organization.organizationId;
			A.io.request(ajax, {
				dataType : 'json',
				method : 'POST',
				data : obj,
				on : {
					success : function() {
						try {A.one('#' + id).remove();}catch(err){}
					},
					failure : function() {
						displayMessage(removeError, errorMsg);
					}
				}
			});
	});
}

function showLogo(){
	AUI().use('aui-node', 'aui-base', function(A) {
		if(A.one("#logoDiv-viewPage")){
			A.one("#logoDiv-viewPage").removeClass('hide-content');
		}
	});
}

function isValidURL(url){
    var RegExp = /(http(s)?:\/\/.)?(www\.)?[-a-zA-Z0-9@:%._\+~#=]{2,256}\.[a-z]{2,6}\b([-a-zA-Z0-9@:%_\+.~#?&//=]*)/;

    if(RegExp.test(url)){
        return true;
    }else{
        return false;
    }
} 

function showHideRemoveImageLink(type){
	var typeUpper = toTitleCase(type);
	AUI().use('aui-node', 'aui-base', function(A) {
		try {
			var image = A.one("#"+type+"Img");
			if (image) {
				var src = image.getAttribute("src");
				var temp = A.one("#removo"+typeUpper+"Div")
				if (!src || src == '') {
					temp.addClass('hide');
				} else {
					temp.removeClass('hide');
				}
			}
		}catch(err){
		}
	});
}

//initRemoveImage
function initRemoveLogo(type){
	//var type = 'logo';
	var typeUpper = toTitleCase(type);
	AUI().use('aui-node','aui-base',function(A){
		try {
			if (A.one("#remove" + typeUpper + "Link")) {
				A.one("#remove" + typeUpper + "Link").on("click", function() {
					A.one("#" + type +"Img").set("src", "");
					//delete logo
					showHideRemoveImageLink(type);
				});
			}
		} catch (err) {
		}
	});
}

function getAuthToken(){
	return Liferay.authToken;
}
function displayMessage(msg,titleMsg,callBack, w, h){
	AUI().use('aui-node','aui-base','liferay-util-window',function(A){
		titleMsg = titleMsg ? titleMsg : "Message";
		var dialog = Liferay.Util.Window.getWindow({
					title : titleMsg,	
					dialog: {
					bodyContent : msg, centered : true, cache: false,
					destroyOnClose: true, destroyOnHide: true, height : 280,
					width : (w) ? w : 400, modal : true, constrain2view : true,
					toolbars:{ footer:[{label:'Ok', 
						on: { click: function() { 
								if (callBack) { 
									if (callBack instanceof Function) {
										callBack(dialog);
									} else {
										window.location.href= callBack;
									}
								} else { 
									dialog.hide(); 
								}
							}}}
						]
					}
				}}).render();
	});
}

function displayMessage2(msg,titleMsg,redirectPath,viewBrief,goToProfile,okLabel){
	AUI().use('aui-node','aui-base','liferay-util-window',function(A){
		titleMsg = titleMsg ? titleMsg : "Message";
		var ft = [];
		if (briefsListPage) {
			ft.push({label:viewBrief, 
						on: { click: function() { 
								window.location.href= briefsListPage;
							}}});
		}
		ft.push({label:goToProfile, 
			on: { click: function() { 
				window.location.href= redirectPath;
			}}});
		ft.push({label:okLabel, 
			on: { click: function() { 
				window.location.href= redirectPath;
			}}});
		var dialog = Liferay.Util.Window.getWindow({
					title : titleMsg,	
					dialog: {
					bodyContent : msg, centered : true, cache: false,
					destroyOnClose: true, destroyOnHide: true, height : 280,
					width : 400, modal : true, constrain2view : true,
					toolbars:{ footer:ft }
				}}).render();
	});
}

function toTitleCase(str) {
    return str.replace(/\w\S*/g, function(txt){return txt.charAt(0).toUpperCase() + txt.substr(1);});
}

function initTabs() {
	var scrollInitialized = false;
	AUI().use('aui-node','aui-base',function(A){
		var tabButtons = A.all('.sp_tab_buttons .sp_tab_button');
		tabButtons.on('click', function(e) {
			// active for selected tab button
			var id = e.target.get('id');
			tabButtons.removeClass('active');
			e.target.addClass('active');
			
			// active for the selected tab
			var tabs = A.all('.sp_tabs .sp_tab');
			tabs.removeClass('fadeIn');
			tabs.removeClass('active');
			var tab = getFirstElementsByAttribute(document, 'section', 'form-name', id);
			A.one(tab).addClass('active');
			A.one(tab).addClass('fadeIn');
			
			if (id == 'sp_tab_3' && scrollInitialized==false) {
				try {
					handleScroll(170, 100);
					scrollInitialized = true;
				}catch(e){}
			}
		});
	});
}


function initPreview() {
	AUI().use('aui-node', 'aui-base', 'aui-io-request-deprecated','liferay-util-window','aui-io-plugin-deprecated', function(A) {
	try{
			A.one(".preview-button").removeClass('hide').on("click", function(e) {
			if (formDirty)
				addStartup(submitError,successMsg,errorMsg,sessionTimeOut,thankUMsg,startupSaveFail,true);
			window.setTimeout(function () {
			var popupWidth = window.innerWidth - (window.innerWidth * 0.1);
		    var login_popup = Liferay.Util.Window.getWindow(
		                {
		                    dialog: {
		                        centered: true,
		                        constrain2view: true,
		                        modal: true,
		                        resizable: true,
		                        width: popupWidth,
		                        destroyOnHide: true
		                    }
		                }).plug(A.Plugin.DialogIframe,
		                     {
		                     	autoLoad: true,
		                     	iframeCssClass: 'dialog-iframe',
		                     	uri:displayURL + organization.organizationId
		                     }).render();
		             	login_popup.show();
		                login_popup.titleNode.html("Preview");
			}, 2000);
			});
	} catch (err){}

	});
}

function getUserList(key){
	AUI().use('autocomplete-list','aui-base','aui-io-request-deprecated','autocomplete-filters','autocomplete-highlighters','datasource','datasource-get','datatable-datasource', function(A) {
		A.io.request(ajax,{
			dataType: 'json',
			method: 'POST',
			data:{
				action:'getUserList',
				keys:key,
				sp_p_auth: getAuthToken()
			},
			on: {
				success: function() {
					var jsonString=this.get('responseData');
					var dropDownLiItem;
					var dropDownUlItem = A.Node.create("<ul class='drop-down-ul'></ul>");
					A.one('#dropDown').empty();
					if(jsonString.length==0){
						dropDownLiItem=A.Node.create('<li class="inviteBox"><div style="color:#ffffff;height: 30px; background-color: #ec5062;">No User found</div>'+
								'<input type="text" name="inviteFN" placeholder="First Name">'+
								'<input type="text" name="inviteLN" placeholder="Last Name">'+
								'<input type="text" name="inviteEmail" placeholder="Email">'+
								'<input style="margin-top:5px;" type="button" value="Send Invite" onclick="sendInvitationEmail(this);" >'+
								'</li>');
						dropDownLiItem.appendTo(dropDownUlItem);
					}else{
						for(var i=0;i<jsonString.length;i++){
							dropDownLiItem=A.Node.create('<li onclick=\'addTeamMember("'+jsonString[i].userId+":"+jsonString[i].name+":"+jsonString[i].imgUrl+'");\'><img alt="Team Member Image" src="'+jsonString[i].imgUrl+'" width="25px" height="25px" style="border-radius:25px;"><span>'+jsonString[i].name+'</span></li>');
							dropDownLiItem.appendTo(dropDownUlItem);
						}
					}
					
					dropDownUlItem.appendTo("#dropDown");
					A.one("#dropDown").removeClass('hide');
					
				},
				failure:function(){
					console.log('failure');
				}
			}
			});
		
	});
	
	
}

function addTeamMember(userdata){
	AUI().use('autocomplete-list','aui-base','aui-io-request-deprecated','autocomplete-filters','autocomplete-highlighters','datasource','datasource-get','datatable-datasource', function(A) {
		var inputText=A.one('#'+namespace+'memberSearch').val();
		var data=userdata.split(':');
		var userId=data[0];
		var userName=data[1];
		var userImg=data[2];
	
		addTeamMemberToDiv(userId,userName,userImg);
	});
}

function addTeamMemberToDiv(userId,userName,userImg){
	AUI().use('autocomplete-list','aui-base','aui-io-request-deprecated','autocomplete-filters','autocomplete-highlighters','datasource','datasource-get','datatable-datasource', function(A) {
	A.one("#dropDown").addClass('hide');

	var fieldName="teamMember";
	var container = A.one('#' + fieldName +'Container');
	var sampleCont=container.one('.formGroupfieldDummy');
	var allFields =container.all('.field');
	var exists=false;
	
	//check if member already added
	allFields.each(function(ele){
			if(ele.val()==userId){
				exists=true;
				return;
			}
	});
	
	if(!exists){
		var dup = sampleCont.clone();
		var inputs = dup.all(".field");
	
		if(dynaSectionCounters[fieldName] == undefined)
			dynaSectionCounters[fieldName] = 1;
		var counterStr = fieldName + dynaSectionCounters[fieldName];
		inputs.each(function(inp){
			try {
				var id = inp.get("name").replace(fieldName, counterStr);
				inp.set("name", id);
				inp.set("id", id);
					
				try {inp.ancestor('.success').removeClass("success");} catch (e) {}
				try {inp.ancestor('.error').removeClass("error");} catch (e) {}

			}catch (err) {
				
			}
		});
		
		dup.set("id", counterStr);
		dup.removeClass('hide');
		dup.removeClass('formGroupfieldDummy');
		dup.addClass('formGroupfield');
		
		dup.appendTo(container);
		A.one('#'+counterStr+' .profileImage').setAttribute("src",userImg);
		A.one('#'+counterStr+' .memberFullName').set("innerHTML",userName);
		A.one('#'+namespace+counterStr+'_memberUserId').val(userId);
		A.one('#'+namespace+counterStr+'_name').val(userName);
		A.one('#'+namespace+counterStr+'_imageUrl').val(userImg);
		A.one('#'+namespace+counterStr+'_memberId').val(userId);

		dup.one(".removeButton").setStyle('display','inline-block').on("click",function(e){
			var result = window.confirm(deleteConfirm);
			if(result){
				var ancestor = this.ancestor(".formGroupfield");
				var rid = namespace + ancestor.get("id") + "_" + ancestor.getAttribute("data-identifier");
				var dbIdObj = A.one("#" + rid);
				if(dbIdObj){
					try{
						var dbId = dbIdObj.get("value");
						if(dbId != null && dbId !="" && dbId != "0"){
							A.io.request(ajax,
									{
										dataType : 'json',
										method : 'POST',
										data : {
											dbId : dbId,
											action : 'delete',
											orgId :  organization.organizationId,
											name : ancestor.getAttribute("data-identifier"),
											sp_p_auth: getAuthToken()
										},
										on : {
											success : function() {
												var message = '';
												var titleMsg = '';
												if(this.get("responseData") == 'success') {
													message = removeSuccess;
													titleMsg = successMsg;
												} 
											},
											failure : function() {
												if(isActiveUser()) {
													alert(removeFailrefresh);
												} else {
													alert(sessionTimeOut);
													window.location.href= "/signin";
												}
											}
										}
									});
						}
					}catch(error){
						
					}
				}
				this.ancestor(".formGroupfield").remove();
				
			}
		});
		
		dynaSectionCounters[fieldName] = dynaSectionCounters[fieldName] + 1;
	}		

	});
}

function sendInvitationEmail(clickedButton){
	AUI().use('aui-base','aui-io-request-deprecated','aui-node', function(A) {
		var inviteFields=A.one(clickedButton).ancestor('.inviteBox').all('input[type="text"]');
		var inviteData={};
		inviteFields.each(function(inp){
			var fieldName=this.get("name");
			inviteData[fieldName]=this.val();
		});
		
		inviteData['action']="addInvitedUser";
		inviteData['sp_p_auth']=getAuthToken();
		inviteData['apiKey'] ="cWqb6X63ut+SXix3RESxtIy1W412NbY/MLLZf3v4RA==";
		if(inviteData.length!=0){
			try{
					A.io.request(ajax,
							{
								dataType : 'json',
								method : 'POST',
								data : inviteData,
								on : {
									success : function() {
										var data=this.get('responseData');
										var message = '';
										var titleMsg = '';
										if(data.status == 'success') {
											A.one("#dropDown").addClass('hide');
											addTeamMemberToDiv(data.userId,data.userName,data.userImg);
											
											message = removeSuccess;
											titleMsg = successMsg;
											
										} else if(data.status=='failed') {
											message = errorAddingUser;
											titleMsg = errorMsg;
										}
										displayMessage(message,titleMsg);
										
									},
									failure : function() {
										message = errorAddingUser;
										titleMsg = errorMsg;
										displayMessage(message,titleMsg);
									}
								}
							});
			}catch(error){
				
			}
		}
	
	});
		
}




function getTagList(key){
	AUI().use('autocomplete-list','aui-base','aui-io-request-deprecated','autocomplete-filters','autocomplete-highlighters','datasource','datasource-get','datatable-datasource', function(A) {
		A.io.request(ajax,{
			dataType: 'json',
			method: 'POST',
			data:{
				action:'getTagList',
				keys:key,
				sp_p_auth: getAuthToken()
			},
			on: {
				success: function() {
					var jsonString=this.get('responseData');
					var dropDownLiItem;
					var dropDownUlItem = A.Node.create("<ul class='drop-down-ul'></ul>");
					var dropDownContainer = A.one('#tagsDropDown');
					dropDownContainer.empty();
					if(jsonString.length==0){
						//
					}else{
						for(var i=0;i<jsonString.length;i++){
							dropDownLiItem=A.Node.create('<li onclick=\'addAssetTag("'+jsonString[i].tagId+":"+jsonString[i].tagName+'");\'><span>'+jsonString[i].tagName+'</span></li>');
							dropDownLiItem.appendTo(dropDownUlItem);
						}
					}
					
					dropDownUlItem.appendTo("#tagsDropDown");
					dropDownContainer.removeClass('hide');
					
				},
				failure:function(){
					if (console) console.log('failure');
				}
			}
			});
		
	});
	
	
}

function addAssetTag(assetTagData){
	AUI().use('autocomplete-list','aui-base','aui-io-request-deprecated','autocomplete-filters','autocomplete-highlighters','datasource','datasource-get','datatable-datasource', function(A) {
		var maxAllowedNumberOfTags = 5;
		var inputText=A.one('#'+namespace+'tagSearch').val();
		var data=assetTagData.split(':');
		var tagId=data[0];
		var tagName=data[1];
		var tagListStr=A.one('#'+namespace+'startupTag_tagIdList').val();
		var tagArray = tagListStr ? tagListStr.split(",") : [];
		if (tagArray.length >= maxAllowedNumberOfTags) {
			displayMessage(maxAllowedChars,errorMsg);
			return;
		}
		var validInput = true;
		if (tagListStr) {
			tagArray.forEach( function(item, index) {
		      if (item === tagId) {
		    	  validInput = false;
		    	  displayMessage(duplicateTag,errorMsg);
		    	  return;
		      }
			});
		}
		if (validInput) {
			tagArray.push(tagId);
			A.one('#'+namespace+'startupTag_tagIdList').val(tagArray.join());
			addTagToDiv(tagId,tagName);
		}
	});
}

function addTagToDiv(tagId,tagName){
	AUI().use('autocomplete-list','aui-base','aui-io-request-deprecated','autocomplete-filters','autocomplete-highlighters','datasource','datasource-get','datatable-datasource', function(A) {
	A.one("#tagsDropDown").addClass('hide');

	var fieldName="startupTag";
	var container = A.one('#' + fieldName +'Container');
	var sampleCont=container.one('.formGroupfieldDummy');
	var allFields =container.all('.field');
	var exists=false;
	
	//check if tag already added
	allFields.each(function(ele){
			if(ele.val()==tagId){
				exists=true;
				return;
			}
	});
	
	if(!exists){
		var dup = sampleCont.clone();
		var inputs = dup.all(".field");
	
		if(dynaSectionCounters[fieldName] == undefined)
			dynaSectionCounters[fieldName] = 1;
		var counterStr = fieldName + dynaSectionCounters[fieldName];
		inputs.each(function(inp){
			try {
				var id = inp.get("name").replace(fieldName, counterStr);
				inp.set("name", id);
				inp.set("id", id);
					
				try {inp.ancestor('.success').removeClass("success");} catch (e) {}
				try {inp.ancestor('.error').removeClass("error");} catch (e) {}

			}catch (err) {
				
			}
		});
		
		dup.set("id", counterStr);
		dup.removeClass('hide');
		dup.removeClass('formGroupfieldDummy');
		dup.addClass('formGroupfield');
		
		dup.appendTo(container);
		A.one('#'+counterStr+' .tagDisplayName').set("innerHTML",tagName);
		A.one('#'+namespace+counterStr+'_tagId').val(tagId);
		A.one('#'+namespace+counterStr+'_tagName').val(tagName);

		dup.one(".removeButton").setStyle('display','inline-block').on("click",function(e){
			var ancestor = this.ancestor(".formGroupfield");
			var rid = namespace + ancestor.get("id") + "_" + ancestor.getAttribute("data-identifier");
			var tagId = A.one("#" + rid).get("value");
			this.ancestor(".formGroupfield").remove();
			var tagListStr=A.one('#'+namespace+'startupTag_tagIdList').val();
			var tagArray = tagListStr ? tagListStr.split(",") : [];
			var valIndex = -1;
			tagArray.forEach( function(item, index) {
			      if (item === tagId) {
			    	  valIndex = index;
			      }
			});
			if (valIndex > -1) {
				tagArray.splice(valIndex, 1);
				A.one('#'+namespace+'startupTag_tagIdList').val(tagArray.join());
			}
			toggleFormDirty(true);
		});
		
		dynaSectionCounters[fieldName] = dynaSectionCounters[fieldName] + 1;
	}		

	});
}


//IE&EDGE IMAGE COMPRESSING SCRIPT

if ('objectFit' in document.documentElement.style === false) {
    document.addEventListener('DOMContentLoaded', function() {
        Array.prototype.forEach.call(document.querySelectorAll('img[data-object-fit]'), function(image) {
            (image.runtimeStyle || image.style).background = 'url("' + image.src + '") no-repeat 50%/' + (image.currentStyle ? image.currentStyle['object-fit'] : image.getAttribute('data-object-fit'));

            image.src = 'data:image/svg+xml,%3Csvg xmlns=\'http://www.w3.org/2000/svg\' width=\'' + image.width + '\' height=\'' + image.height + '\'%3E%3C/svg%3E';
        });
    });
}
