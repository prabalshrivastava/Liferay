var ajax;
var isNew = true;
var viewUrl;

function initialize(ajaxUrl, view) {
	viewUrl = view;
	ajax = ajaxUrl;
	registerAllTextAreaListener();
	if(organization || applicant) {
		isNew = false;
		populateData();
	}
	AUI().use('aui-node', 'aui-base', function(A) {
		var button = A.one('.modifyOrg');
		if (button) {
			button.on('click', function() {
				location.href = editOrgUrl;
			});
		}
		var nameNode = A.all('#challengeName');
		if(nameNode){
			nameNode.setContent(challenge["name"]);
		}
		
	});
}

function validateApplyChallenge(){
	var hasErrors = false;
	AUI().use('aui-node','aui-base','aui-io-request-deprecated','aui-form-validator',function(A){
		var validator = eval('Liferay.Form._INSTANCES.' + namespace + 'applyChallenge.formValidator');
		validator.validate();
		if(validator.hasErrors()) {
			var errorField = A.one(".form-validator-error");
			gotoTab('form_applyBrief');
			alert(missingInfo);
			validator.focusInvalidField();
			hasErrors = true;
		}
	});
	
	return hasErrors;
}
function initSubmit() {
	AUI().use('aui-node','aui-base','aui-io-request-deprecated','aui-form-validator',function(A){
		var submitButton = A.one(".submit");
		if(!submitButton){
			return;
		}
		submitButton.on("click", function () {
			if(validateApplyChallenge()) {
				return;
			} else {
				A.io.request(ajax,{
					dataType : 'json', method : 'POST',
					data : {
						action : 'profileComplete',
						orgId :  organization.organizationId,
					},
					on : {
						success : function() {
							cancel();
						},
						failure : function() {

							if(isActiveUser()) {
								alert(saveInfoFailed);
							} else {
								alert(sessionTimeout);
								window.location.href= "/signin";
							}
						
						}
					}
				});
			}
		});
		}
	);
}

function addSection(fieldName) {
	AUI().use('aui-node','aui-base','aui-io-request-deprecated',function(A){
		var sampleCont = A.one("#" + fieldName + "1");
		var container = A.one('#' + fieldName +'Container');
		var dup = sampleCont.clone();
		var inputs = dup.all(".field, select");
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

function populateData(){
	var form = null;
	AUI().use('aui-node', 'aui-base',
	function(A) {
		try {
			form = A.one("#" + namespace + "addStartup");
			
			var ele = form.all(".field, select");
			var len = namespace.length;
			ele.each(function(){
				var name = this.get("name");
				try {
					name = name.substring(len);
					name = name.replace("_", ".");
					if(this.get('tagName').toLowerCase() == 'select'){
						var option = this.one("option[value='"+eval(name)+"']");
						if(option){
							option.setAttribute('selected',true);
						}
					}else{
						var val = this.val(eval(name));
					}
				}catch(err){
					//console.log(err);
				}
			});
			
		} catch (err) {
		}
		
		try {
			form = A.one("#" + namespace + "applyChallenge");
			var ele = form.all(".field, select");
			var len = namespace.length;
			ele.each(function(){
				var name = this.get("name");
				try {
					name = name.substring(len);
					name = name.replace("_", ".");
					var val = this.val(eval(name));
				}catch(err){
				//console.log(err);
				}
			});
		} catch (err) {
		}
	});
}

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

function setFieldValue(form, fieldName, val) {
	var temp = namespace + fieldName;
	try {
		form.getById(temp).val(val);
	}catch (err){
		//console.log(err);
	}
}

function applyChallenge() {
	var obj = {};
	AUI().use('aui-node', 'aui-base', function(A) {
		var validator = eval('Liferay.Form._INSTANCES.' + namespace + 'applyChallenge.formValidator');
		validator.validate();
		if(validator.hasErrors()) {
			var errorField = A.one(".form-validator-error");
			gotoTab('form_applyBrief');
			alert(missingInfo);
			validator.focusInvalidField();
			return;
		} 
		var ele = A.all(".smartForm .field, .smartForm select");
		var len = namespace.length;
		ele.each(function(){
			var name = this.get("name");
			name = name.substring(len);
			
			var val = "";
			if(this.get('type') == 'checkbox'){
				var checked = this.get('checked');
				if(checked == true){
					val = this.val();
				}
				
			}else{
				val = this.val();
			} 
			if(val != null)
				obj[name] = val;
		});
		
		obj['action'] = 'saveBriefApplication';
		if(organization)
			obj['orgId'] = organization.organizationId;
		if(challenge)
			obj['spChallengeId'] = challenge.spChallengeId;
		if(applicant)
			obj['spChallengeApplicantId'] = applicant.spChallengeApplicantId;
		A.io.request(ajax,
				{
					dataType : 'json',
					method : 'POST',
					data : obj,
					on : {
						success : function() {
							var message = '';
							var titleMsg = '';
							if(this.get("responseData") == 'success') {
								message = applSubmitSuccess;
								titleMsg = successMSg;
							} else if (this.get("responseData").errorMsg) {
								message = this.get("responseData").errorMsg;
								boxTitle = errorMssg;
							} else {
								message = createChallenge;
								titleMsg = errorMssg;
							} 
							
						var dialog =	Liferay.Util.Window.getWindow(
										{
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
										toolbars:{ footer:[{label:'Ok', on: { click:function() {window.location.href = viewUrl;}}}]}
									}}).render();
						},
						failure : function() {
							if(isActiveUser()) {
								alert(saveInfoFailed);
							} else {
								alert(sessionTimeout);
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

YUI().use('event-hover','node', 'transition', 'event', 'event-valuechange',  function (Y) {
	try {
		Y.one("#applyChallenge").on("click", applyChallenge);
		Y.one("#cancelApply").on("click", function() {
			if(defaultDashBoardUrl)
				document.location.href=defaultDashBoardUrl;
		});
	}catch(err){}
});
function addTeamMembersToForm(fieldName) {
	
	AUI().use('aui-node','aui-base',function(A){
		for (var i = 1;; i++) {
			try {
				var obj=eval(fieldName+i);
				if(obj.memberUserId!= undefined)
					addTeamMemberToDiv(obj.memberUserId, obj.name,obj.imageUrl);
			} catch (err) {
				//console.log(err);
				break;
				
			}
		}
	});
}

function addTeamMemberToDiv(userId,userName,userImg){
	AUI().use('autocomplete-list','aui-base','aui-io-request-deprecated','autocomplete-filters','autocomplete-highlighters','datasource','datasource-get','datatable-datasource', function(A) {

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
		
		dynaSectionCounters[fieldName] = dynaSectionCounters[fieldName] + 1;
	}		

	});
}
