var ajax;
var viewUrl;
var challengeValidator;
var COLLAB_PREFIX = "challengeCollab_";
var autoCompleteObj = null;
var autoCompleteObj1 = null;
function initializeAddChallenge(ajaxUrl, view) {
	viewUrl = view;
	ajax = ajaxUrl;
	
	AUI().use('aui-node', 'aui-base', function (A){ 
		if (challenge) {
			populateData(A);
		}
		initAutoComplete();
		initDateFields();
		registerAllTextAreaListener();
		initCollabType();
		try{
			initLogoUpload();
			initRemoveLogo();
			showHideRemoveLogoLink();
		}catch(error){
		}
	});
	initCustomValidations();
	try{
		if(lowerVBrowser == 'true'){
			if(logoError && logoError != '' && logoError != 'null'){
				displayMessage(logoError);
			}
		}
		
	}catch(error){
		
	}
}

function isCollabTypeExternal(collabType){
	var A = AUI().use('aui-base');
	var isExternal = false;
	if(collabTypesProps){
		var props = collabTypesProps[COLLAB_PREFIX + collabType ] ;
		if(props && props.indexOf('external') != -1){
			isExternal = true;
		}
	}
	return isExternal;
}

function collabTypeOnChange() {
	AUI().use('aui-base', function(A) {
		var collabType = A.one("#" + namespace + "asset_collabTypeId");
		var temp = A.one("#" +  "foundryIdeasUrlDiv");
		if (isCollabTypeExternal(collabType.val())) {
			temp.addClass('show-block');
			temp.removeClass('hide-content');
		} else {
			temp.addClass('hide-content');
			temp.removeClass('show-block');
		}
	});
}

function initCollabType(){
	//Intially when page loads
	collabTypeOnChange();
	AUI().use('aui-base', function(A) {
		var collabType = A.one("#" + namespace + "asset_collabTypeId");
		collabType.on("change",function(){
			collabTypeOnChange();
		});
	});
}

function initDateFields() {
	AUI().use('aui-datepicker-deprecated', function(A) {
		var inp = '#' + namespace + 'startDateInput';
		var dp = new A.DatePicker({
	        trigger: inp
	      });
		if (challenge && challenge.startDate)
			dp.calendar.selectDates(new Date(challenge.startDate));
		dp.render('#startDatePicker');
		var endInp = '#' + namespace + 'endDateInput';
		var enddp = new A.DatePicker({
		        trigger: endInp
		      });
		if (challenge && challenge.endDate)
			enddp.calendar.selectDates(new Date(challenge.endDate));
		enddp.render('#endDatePicker');
	});
}

function registerAllTextAreaListener() {

	YUI().use('event-hover','node', 'transition', 'event', 'event-valuechange',  function (Y) {
		Y.later(2000, null, function(t){
			var tAreas = Y.all(".addChallenge textarea");
			tAreas.each(function(ta) {
				ta.setStyle("resize", "none");
				ta.setStyle("overflow-y", "hidden");
				registerTextAreaListener(ta);
				try {resizeTA(ta);}catch(err){}
			});
		},[],false);
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

function populateData(A) {
	// text fields
	var form = A.one("#" + namespace + "addChallenge");

	var ele = form.all("textarea,input,select");
	var len = namespace.length;
	ele.each(function() {
		var name = this.get("name");
		try {
			name = name.substring(len);
			name = name.replace("_", ".");
			this.val(eval(name));
		} catch (err) {
			//console.log(err);
		}
	});
	
}

AUI().ready('aui-node', 'aui-base', function(A) {
	var formCTA_submit = A.one('.formCTA .submit');
	var formCTA_draft = A.one('.formCTA .draft');
	
	if (formCTA_submit) {
		formCTA_submit.on('click', function(e) {
			submitForm(false);
			e.preventDefault();
			return false;
		});
	}
	
	if (formCTA_draft) {
		formCTA_draft.on('click', function(e) {
			submitForm(true);
			e.preventDefault();
			return false;
		});
	}
	
	if(formCTA_draft){
		if(challenge && !challenge.draft) {
			formCTA_draft.remove();
		}
	}
	
		function submitForm(isDraft) {
			var obj = {};
			AUI().use('aui-node', 'aui-base', function(A) {
				
				if(!isDraft) {
					//validations
					var validator = eval('Liferay.Form._INSTANCES.' + namespace + 'addChallenge.formValidator');
					validator.validate();
					if(validator.hasErrors()) {
						validator.focusInvalidField();
						return;
					}
					challengeValidator.validate();
					if(challengeValidator.hasErrors()) {
						challengeValidator.focusInvalidField();
						return;	
					}
				} else {
					var name = A.one("#" + namespace + "challenge_name");
					if(!name.val() || name.val().length <=0) {
						alert(addBriefTitle);
						name.focus();
						return;
					}
				}
				startPreLoader('add-challenge-form-wrapper');
				// setting values for scout and notify_to...if scout is selected append to notify_to
				var notificationIds = "";
				if(autoCompleteObj){
					A.one("#" + namespace + "challenge_notifyTo").set('value',autoCompleteObj.getSelectedIds());
					noficationIds = autoCompleteObj.getSelectedIds();
				}
				if(autoCompleteObj1){
					A.one("#" + namespace + "challenge_scout").set('value',autoCompleteObj1.getSelectedIds());
					if(autoCompleteObj1.getSelectedIds() && autoCompleteObj1.getSelectedIds().length > 5) {
						noficationIds = noficationIds + ";" + autoCompleteObj1.getSelectedIds();
						A.one("#" + namespace + "challenge_notifyTo").set('value',noficationIds);
					}
				}
				
				// remove namespace and send as part of request
				var ele = A.all(".addChallenge textarea,select,input");
				var len = namespace.length;
				ele.each(function(){
					var name = this.get("name");
					name = name.substring(len);
					var val = this.val();
					if(val != null)
						obj[name] = val;
				});
				
				// multi select patch
				ele = A.all(".addChallenge select[multiple]");
				ele.each(function(){
					var temp = this.all('option:selected');
					var name = this.get("name");
					name = name.substring(len);
					var values = temp.val();
					try {
						for (i = 0; i < values.length; i++) {
							if(i > 0)
								obj[name + i] = values[i];
							else 
								obj[name] = values[i];
						}
					} catch (err) {
						console.log(err);
					}
				});
				
				obj['action'] = 'addChallenge';
				if (challenge)
					obj['spChallengeId'] = challenge.spChallengeId;
				obj.challenge_draft = isDraft.toString();
				A.io.request(ajax,
						{
							dataType : 'json',
							method : 'POST',
							sync: true,
							data : obj,
							on : {
								success : function() {
									stopPreLoader('add-challenge-form-wrapper');
									var message = '';
									var titleMsg = '';
									if(this.get("responseData") == 'success') {
										if(!isDraft)
											message = publishedSuccessfully;
										else
											message = briefSavedDraft;
										titleMsg = successMSg;
									} else if (this.get("responseData").errorMsg) {
										message = this.get("responseData").errorMsg;
										boxTitle = errorMssg;
									} else {
										message = createChallenge;
										titleMsg = errorMssg;
									} 
									//displayMessage(message,titleMsg);
									
									var dialog = Liferay.Util.Window.getWindow({
												title : titleMsg,
												dialog: {
													bodyContent : message,
													centered : true,
													cache: false,
													destroyOnClose: true,
													destroyOnHide: true,
													height : 250,
													width : 400,
													modal : true,
													constrain2view : true,
													toolbars:{
														footer:[{label:okLbl, on: { click:function() {window.location.href = viewUrl;}}}]
													} 
												}
											}).render(); 
								},
								failure : function() {
									stopPreLoader('add-challenge-form-wrapper');
									alert(saveInfoFailed);
								}
							}
						});
				
			});

			return false;
		}
});


function addMultiSectionsToForm(fieldName) {
	AUI().use(
	'aui-node',
	'aui-base',
	function(A) {
		for (var i = 2;; i++) {
			try {
				eval(fieldName + i);
				addSection(fieldName);
			} catch (err) {
				//console.log(err);
				break;
			}
		}
	});
}


function addSection(fieldName) {
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
			}catch (err) {
				//console.log(err);
			}
		});
		dup.set("id", counterStr);
		dup.appendTo(container);
		dup.one(".removeButton").setStyle('display','inline-block').on("click",function(){
			this.ancestor(".formGroupfield").remove();
		});
		dup.one(".addButton").on("click",function(){
			addSection(fieldName);
		});
		var tAreas = dup.all("textarea");
		tAreas.each(function(ta) {
			registerTextAreaListener(ta);
		});
		dynaSectionCounters[fieldName] = dynaSectionCounters[fieldName] + 1;
	});
 }

function checkDate(str) {
	var A = AUI().use('aui-node', 'aui-base', 'aui-io-request-deprecated');
	var startStr = A.one("#" + namespace + "startDateInput");
	var endStr = A.one("#" + namespace + "endDateInput");
	var startDate = new Date(startStr.val());
	var endDate = new Date(endStr.val());
	return startDate.getTime() < endDate.getTime();
}

function initCustomValidations(){
	try{
		AUI().ready('alloy-node', 'aui-form-validator', function(A) {
			var rulesObj = {
					
			};
			rulesObj[namespace + 'asset_applicantTypesId'] = {
					required: true	
			};
			rulesObj[namespace + 'asset_challengeCategoryId'] = {
					required: true	
			};
//			rulesObj[namespace + 'asset_challengeTypeId'] = {
//					required: true	
//			};
			rulesObj[namespace + 'asset_regionId'] = {
					required: true	
			};
			rulesObj[namespace + 'asset_collabTypeId'] = {
					required: true	
			};
			
			var fieldStringObj = {
						
			};
			fieldStringObj[namespace + 'asset_applicantTypesId'] = {
					required : "Mandatory Field"
			};
			fieldStringObj[namespace + 'asset_challengeCategoryId'] = {
					required : "Mandatory Field"
			};
//			fieldStringObj[namespace + 'asset_challengeTypeId'] = {
//					required : "Mandatory Field"
//			};
			fieldStringObj[namespace + 'asset_regionId'] = {
					required : "Mandatory Field"
			};
			fieldStringObj[namespace + 'asset_collabTypeId'] = {
					required : "Mandatory Field"
			};
			challengeValidator = new A.FormValidator({
		        boundingBox: '#'+namespace + 'addChallenge',
		        rules: rulesObj,
		        fieldStrings:fieldStringObj,
		        showAllMessages:true
		        		    });
		});
	}catch(err){
		
	}
}
function initRemoveLogo(){
	try{
		AUI().use('aui-node','aui-base',function(A){
			A.one("#" + "removeLogoLink").on("click",function(){
				// when remove logo link clicked, removeLogo will be set to true,
				// and will be reset to false when logo is uploaded.
				// At server side, if removeLogo is true logo will be removed completely
				A.one("#" + "logoImg").set("src","");
				A.one("#" + namespace +"removeLogo").set('value',true);
				showHideRemoveLogoLink();
				
			});
		});
	}catch(error){
		
	}
}
function initLogoUpload(){
	//call initialization file
	try{
		if (window.File && window.FileList && window.FileReader) {
//			if (false) {
			var action = "uploadLogo";
			var obj1 = new challengesFileDragAndDrop();
			var afterFileUpload = function(jsonObj){
				try{
					AUI().use('aui-node','aui-base',function(A){
						if(jsonObj.logoUrl){
							A.one("#" + "logoImg").set("src",jsonObj.logoUrl);
							A.one("#" + namespace +"removeLogo").set('value',false);
						}else if(jsonObj.errorMsg){
							displayMessage(jsonObj.errorMsg);
						}
						
						showHideRemoveLogoLink();
					});
				}catch(error){
					
				}
			}
			obj1.Init('filedrag1','filesTable','challengeLogo',ajax,'draganddrop',namespace,action,afterFileUpload);
			obj1.Init('filedrag1','filesTable','challengeLogo',ajax,'fileInput',namespace,action,afterFileUpload);
		}else{
			AUI().use('aui-node','aui-base',function(A){
				var fileObj = A.one("#" + namespace + "challengeLogo");
				A.one("#filedrag1").removeClass("fd_container");
				A.one("#filedrag1 .fdWrap").setContent('');
				fileObj.on('change',function(e){
					
					var form = A.one("#" + namespace+ "addChallenge");
					var challengIdObj = A.one("#" + namespace + "challengeId");
					if(challenge){
						challengIdObj.set('value',challenge.spChallengeId);
					}
					form.getDOMNode().submit();
					
				});
				
			});

		}

	}catch(error){
		
	}
			
}
function showHideRemoveLogoLink(){
	AUI().use('aui-node', 'aui-base', function(A) {
		try{
			var logo = A.one("#logoImg");
			var src = logo.getAttribute("src");
			if(!src || src == '' ){
				A.one("#removoLogoDiv").addClass('hide-content');
			}else{
				A.one("#removoLogoDiv").removeClass('hide-content');
			}
		}catch(err){
			//console.log(err);
		}
	});
}


function displayMessage(msg,titleMsg){
	AUI().use('aui-node','aui-base','liferay-util-window',function(A){
		titleMsg = titleMsg ? titleMsg : messageLbl;
		var dialog = Liferay.Util.Window.getWindow({
				title : titleMsg,
				dialog: {
					bodyContent : msg,
					centered : true,
					cache: false,
					destroyOnClose: true,
					destroyOnHide: true,
					height : 250,
					width : 400,
					modal : true,
					constrain2view : true,
					toolbars:{ footer:[{label:okLbl, on: { click:function() {showChallengePage(); dialog.hide();}}}]}
				}}).render();
		
	});
}

function initAutoComplete() {
	try{
		var j_ip_form = document.getElementById("notefDiv");
		var notefToHiden = document.getElementById(namespace + "challenge_notifyTo");
		var scoutHiden = document.getElementById(namespace + "challenge_scout");
		var j_autocomplete_sis_holder = getFirstElementsByAttribute(document, "div", "data-autocomplete-dom-id", "sis-holder");
		var j_autocomplete_input = getFirstElementsByAttribute(document, "input", "data-autocomplete-dom-id", "input");
		var j_autocomplete_suggestions_board = getFirstElementsByAttribute(document, "div", "data-autocomplete-dom-id", "suggestions-board");
		var j_autocomplete_close_btn = getFirstElementsByAttribute(document, "div", "data-autocomplete-dom-id", "close-btn");
		var j_autocomplete_options = getFirstElementsByAttribute(document, "div", "data-autocomplete-dom-id", "options");
		var j_autocomplete_selected_items = getFirstElementsByAttribute(document, "ul", "data-autocomplete-dom-id", "selected-items");
		
		autoCompleteObj =	new AutoComplete({
			'j_ip_form' : j_ip_form,
			'j_autocomplete_sis_holder' : j_autocomplete_sis_holder,
			'j_autocomplete_input' : j_autocomplete_input,
			'j_autocomplete_suggestions_board' : j_autocomplete_suggestions_board,
			'j_autocomplete_close_btn' : j_autocomplete_close_btn,
			'j_autocomplete_options' : j_autocomplete_options,
			'j_autocomplete_selected_items' : j_autocomplete_selected_items,
			'_duration_list' : '',
			'_find_suggestions_url' : ajaxUrl,
			'_portlet_namespace' : namespace,
			'action' : 'notefToSuggestions',
			'shareEmailList' : []
		});
		var ids = notefToHiden.value;
		if (scoutHiden.value && scoutHiden.value.length > 0) {
			if(notefToHiden.value.length > 0)
				ids = ids.replace(scoutHiden.value,"");
		}
		autoCompleteObj.createMailIds(ids);	
	}catch(error){
	}

	try{
		var j_ip_form = document.getElementById("scoutnotefDiv");
		var scoutHiden = document.getElementById(namespace + "challenge_scout");
		var j_autocomplete_sis_holder = getFirstElementsByAttribute(document, "div", "data-autocomplete-dom-id", "scout-sis-holder");
		var j_autocomplete_input = getFirstElementsByAttribute(document, "input", "data-autocomplete-dom-id", "scout-input");
		var j_autocomplete_suggestions_board = getFirstElementsByAttribute(document, "div", "data-autocomplete-dom-id", "scout-suggestions-board");
		var j_autocomplete_close_btn = getFirstElementsByAttribute(document, "div", "data-autocomplete-dom-id", "scout-close-btn");
		var j_autocomplete_options = getFirstElementsByAttribute(document, "div", "data-autocomplete-dom-id", "scout-options");
		var j_autocomplete_selected_items = getFirstElementsByAttribute(document, "ul", "data-autocomplete-dom-id", "scout-selected-items");
		
		autoCompleteObj1 =	new AutoComplete({
			'j_ip_form' : j_ip_form,
			'j_autocomplete_sis_holder' : j_autocomplete_sis_holder,
			'j_autocomplete_input' : j_autocomplete_input,
			'j_autocomplete_suggestions_board' : j_autocomplete_suggestions_board,
			'j_autocomplete_close_btn' : j_autocomplete_close_btn,
			'j_autocomplete_options' : j_autocomplete_options,
			'j_autocomplete_selected_items' : j_autocomplete_selected_items,
			'_duration_list' : '',
			'_find_suggestions_url' : ajaxUrl,
			'_portlet_namespace' : namespace,
			'action' : 'scoutSuggestions',
			'shareEmailList' : []
		});
		autoCompleteObj1.createMailIds(scoutHiden.value);	
	}catch(error){
	}
}


function showChallengePage(show) {
	if (show !== undefined && show===false) {
		AUI().one('#displayChallengeContainer').addClass('hide');
	} else {
		AUI().one('#displayChallengeContainer').removeClass('hide');
	}
}

function defaultCancelHandler() {
	showChallengePage();
	location.href='#';
}