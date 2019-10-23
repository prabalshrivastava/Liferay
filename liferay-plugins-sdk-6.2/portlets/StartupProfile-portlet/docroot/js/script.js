var formDirty = false;
YUI().use('event-hover','node', 'transition', 'event', 'event-valuechange',  function (Y) {
	var cbCTA = Y.one('.sp_profile section.head .cta_wrap .cta_item.cb a');
	if(cbCTA)
		cbCTA.on('click', profileCBClick);
	
	var newCTA = Y.one('.sp_profile section.head .cta_wrap .cta_item.new a');
	if(newCTA)
		newCTA.on('click', profileNewClick);
	
	var cbListOpt = Y.all('.crunchbaseSelectList input');
	if(!cbListOpt)
		return;
	cbListOpt.on('change',function(e) {
		try {
		var cbList = Y.one('.crunchbaseSelectList');
		var cbListW = Y.one('.crunchbaseSelectList .cbListWrap');
		var profileContent = Y.one('.profile_content');
			
			cbList.removeClass('fadeIn');
			cbListW.removeClass('fadeIn d_down');
			
			
			cbList.addClass('fadeOut d_down');
			cbList.addClass('no_height');
			cbListW.addClass('slideOutUp ');
			
			
			 var formNavigation = profileContent.one('.profile_form_navigation');
			   var profileContentForm = profileContent.one('.profile_form ');
			   
			   formNavigation.setStyle('display', 'none');
			   profileContentForm.setStyle('display', 'none');
			   
			   formNavigation.removeClass('slideOutLeft');
			   profileContentForm.removeClass('slideOutRight');
			
			
			var timeHandle3 = Y.later(700, cbList, function(t){
				try {
				cbList.removeClass('active');
				cbListW.removeClass('active');
				cbList.removeClass('fadeOut d_down');
				cbListW.removeClass('slideOutUp');
				
				profileContent.addClass('active');
				
				formNavigation.addClass('animated4 slideInLeft');
				   //formNavigation.addClass('posFixed');
				   formNavigation.setStyle('display', 'inline-block');
				   
				   
				   profileContentForm.addClass('animated4 slideInRight');
				   profileContentForm.setStyle('display', 'inline-block');
				
				}catch (err) {}
				
				
			},[],false);
		
		var head = Y.one('.sp_profile .head');
		var headW = head.one('.head_wrap');
		head.addClass('no_height');
		headW.addClass('animated3 slideOutUp2 ');
		}catch(err1){}
		
	});
	
	
	function profileCBClick(e){
		try {
			var targ = e.currentTarget;
			var targP = targ.get('parentNode');
			var head = Y.one('.sp_profile section.head');
			var profCTA = Y.all('.sp_profile section.head .cta_wrap .cta_item');

			profCTA.each(function(c) {
				c.removeClass('active');
			});
			targP.addClass('active');
			var cbList = Y.one('.crunchbaseSelectList');
			var cbListW = Y
					.one('.crunchbaseSelectList .cbListWrap');

			cbList.removeClass('no_height');
			head.addClass('no_height');

			cbList.addClass('active animate');
			cbList.setStyle('height', '162px');
			cbList.addClass('fadeIn ');
			cbListW.addClass('active');
			cbListW.addClass('fadeIn d_down');
		}catch (err) {}
	}
	
	
	
	
	
	function profileNewClick(e){
		var targ = e.currentTarget;
		var targP = targ.get('parentNode');
		try {
			var profCTA = Y.all('.sp_profile section.head .cta_wrap .cta_item');

			profCTA.each(function(c) {
				c.removeClass('active');
			});

			targP.addClass('active');
			var cbList = Y.one('.crunchbaseSelectList');
			var cbListW = Y.one('.crunchbaseSelectList .cbListWrap');
			var profileContent = Y.one('.profile_content');
			var profileContentForm = profileContent.one('.profile_form ');

			cbList.removeClass('fadeIn ');
			cbListW.removeClass('fadeIn d_down');

			cbList.addClass('fadeOut d_down');
			cbList.addClass('no_height');
			cbListW.addClass('slideOutUp ');

			var timeHandle = Y.later(800, cbList, function(t) {
				cbList.removeClass('active');
				cbListW.removeClass('active');
				cbList.removeClass('fadeOut d_down');
				cbListW.removeClass('slideOutUp');
				profileContent.addClass('active');

			}, [], false);

			var formNavigation = profileContent.one('.profile_form_navigation');
			var profileContentForm = profileContent.one('.profile_form ');

			formNavigation.setStyle('display', 'none');
			profileContentForm.setStyle('display', 'none');

			formNavigation.removeClass('slideOutLeft');
			profileContentForm.removeClass('slideOutRight');

			var timeHandle6 = Y.later(
							1000,
							formNavigation,
							function(t) {
								formNavigation
										.addClass('animated4 slideInLeft');
//								formNavigation
//										.addClass('posFixed');
								formNavigation.setStyle(
										'display',
										'inline-block');

								profileContentForm
										.addClass('animated4 slideInRight');
								profileContentForm.setStyle(
										'display',
										'inline-block');

							}, [], false);
			var head = Y.one('.sp_profile .head');
			var headW = head.one('.head_wrap');
			head.addClass('no_height');
			headW.addClass('animated3 slideOutUp2 ');
		}catch (err) {}
	}
	
	
});

YUI().use('event-hover','node', 'transition', 'event', 'event-valuechange',  function (Y) {
	var tabNavItems = Y.all('.profile_form_navigation nav ul li');
	var tabForms = Y.all('.profile_form .form');
	var formCTA_proceed = Y.all('.profile_form .form .formCTA .proceed ');
	var formCTA_top_proceed = Y.all('.proceedFromTop');
	var formCTA_cancel = Y.all('.profile_form .form .formCTA .cancel ');
//	added to fix the expand / collapse in mobile -- Harini
	var startup_more =  Y.one("#startup_more");
	var mobileNavSelect = Y.one('.mobileNavSelect');

	
	
	if(Y.one('.mobile') || Y.one('.vp1024.portraitMode')){
		var tabMobileClick = Y.all('.profile_form .form .formTitle');
		//tabMobileClick.on('click',tabItemClick_mobile);
		var mobileFormNavItem = Y.all('.profile_form_navigation nav ul li');
		var mobileProceedForm = Y.all('.profile_form .form .formCTA .proceed');
		
		
		mobileFormNavItem.on('click', mobileNavItemClick);
//		added to fix the expand / collapse in mobile -- Harini
		if(startup_more)
			startup_more.on('click', mobileNavSelectClick);
		if(mobileNavSelect)
			mobileNavSelect.on('click', mobileNavSelectClick);
		//mobileProceedForm.on('click', mobileFormProceedClick);
	}
	
	
	tabNavItems.on('click', tabNavItemClick);
	formCTA_proceed.on('click',proceedClick);
	formCTA_top_proceed.on('click',triggerProceedClick);
	
	function triggerProceedClick(e){
		var target = e.currentTarget;
		target.addClass("disabledButton");
		var parentForm = target.get('parentNode').get('parentNode');
		var formName = parentForm.getAttribute('form-name');
		var targId = formName + "Proceed";
		var targ = Y.one("#"+targId);
		proceedClick(targ);
	}
	
	function proceedClick(e){
		var targ = e.currentTarget;
		if(targ == undefined){
			targ = e;
		} 
		var customAction = targ._node.getAttribute('customAction');
		if (customAction && customAction==='signup') {
			proceedSignupClick(e);
			//targ.addClass("disabledButton");
		} else {
			proceedAndSaveClick(e);
		}
	}

	function proceedAndSaveClick(e){
		var targ = e.currentTarget;
		if(targ == undefined){
			targ = e;
		}
		var form = targ.ancestor('section.form');
		var formWrap = form.get('parentNode');
		var formName = form.getAttribute('form-name'); 
		var formTabNav = Y.one('.profile_form_navigation nav ul li#'+formName);
		
		try {
			var validator = eval('Liferay.Form._INSTANCES.' + namespace + 'addStartup.formValidator');
			validator.resetAllFields();
			validator.validateField(namespace+'organization_name');
			if(validator.hasErrors()) {
				gotoTab('form_1');
				validator.focusInvalidField();
				showNameMissingWarning();
				return;
			}
			validator.validateField(namespace+'organization_uen');
			if(validator.hasErrors()) {
				gotoTab('form_1');
				validator.focusInvalidField();
				showNameMissingWarning();
				return;
			}
			validator.validateField(namespace+'challengeLogo');
			if(validator.hasErrors()) {
				gotoTab('form_1');
				validator.focusInvalidField();
				showNameMissingWarning();
				return;
			}
			
			if(primaryemailExists == 1){
				displayMessage("Email address already in use.");
				return;
			}
			if(secondaryemailExists == 1){
				displayMessage("Email address already in use.");
				return;
			}
			if(mentorExists == 1){
				displayMessage("Email address already in use.");
				return;
			}
			
			 var testform = Liferay.Form.get(namespace+'addStartup').formValidator;
			 testform.validate();
			 
			//And to check whether error as exist
			if(testform.hasErrors() && formName !="form_1" && formName !="form_2"){
				var validationErrors = JSON.stringify(testform.errors);
				if((validationErrors.includes("appraisalForm") || validationErrors.includes("businessRegistration")|| 
					validationErrors.includes("jobDescription")|| validationErrors.includes("jobDescriptions")|| 
					validationErrors.includes("timesheets")|| validationErrors.includes("financialStatement")|| 
					validationErrors.includes("policy")|| validationErrors.includes("businessConduct"))  && isDocumentsMandatory){
					
					displayMessage("Please Upload Mandatory Documents");
					return;
				}
			 
			}
			targ.addClass("disabledButton");
		}catch (err){}
		//formTabNav.addClass('formDone');
		formTabNav.removeClass('active');
		
		form.removeClass('animated fadeIn');
		form.addClass('animated fadeOut');
		window.scrollTo(0,0);
		
		if (formName != "form_review") {
			if (formDirty) {
			   startPreLoader('profile_forms_wrap');
			   saveFormData(submitError,successMsg,errorMsg,sessionTimeOut,thankUMsg,startupSaveFail);
			   toggleFormDirty(false);
			   stopPreLoader('profile_forms_wrap');
			}
		}
		
		var nextForm = form.next('section.form');
		
			var nextFormName = nextForm.getAttribute('form-name');
			var nextFormTitleNode = nextForm.one('.formTitle');
			var nextFormTitle = "";
			if(nextFormTitleNode != null){
				nextFormTitle = nextFormTitleNode.get('innerHTML');
			}
			var nextFormTabNav = Y.one('.profile_form_navigation nav ul li#'+nextFormName);
			mobileNavSelect.set('innerHTML', '');
			mobileNavSelect.set('innerHTML', nextFormTitle);
			nextFormTabNav.addClass('active');
			
			var timeHandle = Y.later(500, form, function(t){
				//console.log(form);
				form.removeClass('active');
				form.removeClass('animated fadeOut');
			},[],false);
			
			var timeHandle1 = Y.later(500, nextForm, function(t){
				//console.log(nextForm);
				nextForm.addClass('active');
				nextForm.addClass('animated fadeIn');
				//formWrap.removeClass('loadForm');
			},[],false);
			var timeHandle2 = Y.later(1000, nextForm, function(t){
				//console.log(nextForm);
				nextForm.removeClass('fadeIn');
				//formWrap.removeClass('loadForm');
			},[],false);
			
			var formR = Y.one('.formFields_data');
			if(nextFormTabNav.get("id") == 'form_review'){
				formCTA_top_proceed.addClass("hide");
				formCTA_top_proceed.setAttribute("style","display:none!important");
				formR.empty();
				showReviewTab()
			} else {
				formR.empty();
				formCTA_top_proceed.removeClass("hide");
			}
			
			
			if(Y.one('.tab_helpText')){
				var tabHelp = Y.one('.tab_helpText');
				var targHelpText = nextFormTabNav.getAttribute('help-text');
				var targContent = nextFormTabNav.one('span').get('innerHTML');
				
				var tabHelpTitle = tabHelp.one('.title_helpText span b');
				var tabHelpContent = tabHelp.one('.content_helpText span ');
				
				tabHelpTitle.set('innerHTML', '');
				tabHelpContent.set('innerHTML', '');
				
				tabHelpTitle.set('innerHTML', targContent);
				tabHelpContent.set('innerHTML', targHelpText);
				
			}

	}

	function proceedSignupClick(e){
		var firstPageFields = [];
		firstPageFields.push('organization_name');
		firstPageFields.push('org_contact_fname');
		firstPageFields.push('org_contact_lname');
		firstPageFields.push('organization_emailId');
//		firstPageFields.push('organization_emailId2');
		firstPageFields.push('login_pwd1');
		firstPageFields.push('login_pwd2');		
		firstPageFields.push('organization_uen');
		var validator = eval('Liferay.Form._INSTANCES.' + namespace + 'addStartup.formValidator');
		var hasErrors = false;
		validator.resetAllFields();
		
		firstPageFields.forEach(function(item, index){
			validator.validateField(namespace + item);
			if(validator.hasErrors()) {
				hasErrors = true;
				return;
			}
		});
		
		if(hasErrors) {
			validator.focusInvalidField();
		} else {
			proceedToNextSignupPage()
		}		
	}
	
	function tabNavItemClick(e){
//		if(formDirty){
//			alert("Form contains unsaved changes. Please click Save And Proceed to save the changes");
//			toggleFormDirty(false);
//		}

		var targ = e.currentTarget;
		var proceedButtons = Y.all('.profile_form .form .formCTA .proceed ');
		proceedButtons.removeClass("disabledButton");
		var proceedTopButtons = Y.all('.proceedFromTop');
		proceedTopButtons.removeClass("disabledButton");
		var form = Y.one('.profile_form');
		if(targ.get("id") == 'form_review'){
			formCTA_top_proceed.addClass("hide");
			formCTA_top_proceed.setAttribute("style","display:none!important");
		}else{
			formCTA_top_proceed.removeClass("hide");
			formCTA_top_proceed.setAttribute("style","display:inline-block!important");
		}
		if (formDirty) {
			var formName = targ.get("id");
			try {
				var validator = eval('Liferay.Form._INSTANCES.' + namespace + 'addStartup.formValidator');
				validator.resetAllFields()
				validator.validateField(namespace+'organization_name');
				if(validator.hasErrors()) {
					gotoTab('form_1');
					validator.focusInvalidField();
					showNameMissingWarning();
					return;
				}
				validator.validateField(namespace+'organization_uen');
				if(validator.hasErrors()) {
					gotoTab('form_1');
					validator.focusInvalidField();
					showNameMissingWarning();
					return;
				}
				validator.validateField(namespace+'challengeLogo');
				if(validator.hasErrors()) {
					gotoTab('form_1');
					validator.focusInvalidField();
					showNameMissingWarning();
					return;
				}
				saveFormData(submitError,successMsg,errorMsg,sessionTimeOut,thankUMsg,startupSaveFail);
				toggleFormDirty(false);
			} catch (err) {}
		}
		
		
		//window.scrollTo(0,0);
		
		//form.addClass('loadForm');
		tabNavItems.each(function(a){
			a.removeClass('active');
		});
		targ.addClass('active');
		
		tabForms.each(function(b){
			
			b.removeClass('animated fadeIn');
			b.addClass('animated fadeOut');
		});
		
		var targName = targ.get('id');
		var targForm = Y.one('.profile_form .form.'+targName);
//		console.log(targForm);
		
		var timeHandle = Y.later(500, targForm, function(t){
			//console.log(nextForm);
			
			tabForms.each(function(c){
				c.removeClass('active');
				c.removeClass('animated fadeOut');
				
			});
			targForm.addClass('active');
			targForm.addClass('animated fadeIn');
			//form.removeClass('loadForm');
		},[],false);
		var timeHandle1 = Y.later(1000, targForm, function(t){
			
			targForm.removeClass('fadeIn');
			//form.removeClass('loadForm');
		},[],false);
		
		
		var formR = Y.one('.formFields_data');
		if(targ.get('id') == 'form_review'){
			showReviewTab();
		} else {
			try { formR.empty(); formR.ancestor('section').removeClass('active'); } catch (err) {}
		}
		
		
		if(Y.one('.tab_helpText')){
			var tabHelp = Y.one('.tab_helpText');
			var targHelpText = targ.getAttribute('help-text');
			var targContent = targ.one('span').get('innerHTML');
			
			var tabHelpTitle = tabHelp.one('.title_helpText span b');
			var tabHelpContent = tabHelp.one('.content_helpText span ');
			
			tabHelpTitle.set('innerHTML', '');
			tabHelpContent.set('innerHTML', '');
			
			tabHelpTitle.set('innerHTML', targContent);
			tabHelpContent.set('innerHTML', targHelpText);
		}
	}
	
	var clickedItem = false;
	var tempTarg;
	
	function tabItemClick_mobile(e){
		var targ = e.currentTarget;
		var targParent = targ.get('parentNode');
		//console.log(targParent);
		
		window.scrollTo(0,0);
		
		var forms = Y.all('.profile_form .form');
		forms.each(function(a){
			a.removeClass('mobileActive');
			a.one('.formContent').removeClass('animated fadeInLeft');
		});
		
		if(!clickedItem){
			targParent.addClass('mobileActive');
			targParent.one('.formContent').addClass('animated fadeInLeft');
			clickedItem = true;
			tempTarg = targ;
		}
		else{
			if(tempTarg != targ){
				targParent.addClass('mobileActive');
				targParent.one('.formContent').addClass('animated fadeInLeft');
				tempTarg = targ;
			}else{
				targParent.removeClass('mobileActive');
				targParent.one('.formContent').removeClass('animated fadeInLeft');
				clickedItem = false;
				tempTarg = '';
			}
			
			
		}
		
		var d = document.getElementById(targ.get('id'));
		window.scrollTo(0, findPos(d));
		
	}
	
	function mobileNavSelectClick(){
		var profileFormNavigationItems = Y.all('.profile_form_navigation nav ul li');
		window.scrollTo(0,0);
		if(!clickedItem){
			profileFormNavigationItems.each(function(a){
				a.setStyle('display','block');
				
			});
			clickedItem = true;
		}
		else{
			profileFormNavigationItems.each(function(a){
				a.setStyle('display','none');
				
			});
			clickedItem = false;
		}
	
	}
	
	function mobileNavItemClick(e){
		
		var targ = e.currentTarget;
		var targName = targ.one('span').get('innerHTML');
		var profileFormNavigationItems = Y.all('.profile_form_navigation nav ul li');
		mobileNavSelect.set('innerHTML', '');
		mobileNavSelect.set('innerHTML', targName);
		profileFormNavigationItems.each(function(a){
			a.setStyle('display','none');
			
		});
		
		clickedItem = false;
	
	}
	
	
	
});


function initAllFormElmntsChangeListeners(){
	AUI().use('aui-node', 'aui-base', function(A) {
		var tabs = A.all("section .form");
		tabs.each(function(tab){
			var elmnts = tab.all("input,select, textarea");
			elmnts.each(function(elmnt){
				elmnt.on("change",function(){
					toggleFormDirty(true);
				});
			});
		});
	});
}
function toggleFormDirty(dirty){
	try{
		formDirty = dirty;	
	}catch(error){
		
	}
}

function showReviewTab() {
	YUI().use('event-hover','node', 'transition', 'event', 'event-valuechange',  function (Y) {
	var formR = Y.one('.formFields_data');
	formR.empty();
	AUI().use('aui-node', 'aui-base', function(A) {
		try{
		    var tabs = A.all("#" + namespace + "addStartup .form");
		    tabs.each(function(r) {
		    	if(!r.hasClass('form_review') && !r.hasClass('form_22')) {
			    	var section = A.Node.create("<div class='form_section'></div>");
			    	var children = r.clone().get("children");
			    	children.each(function(e){
			    		if(e.hasClass("formTitle"))
			    			e.replaceClass("formTitle", "formSectionTitle");
			    		e.appendTo(section);
			    	});
			    	section.appendTo(formR);
		    	}
		    });
		    // remove buttons
		    removeItems(A, '.form_review .formFields_data .formCTA');
		    removeItems(A, '.form_review .addButton');
		    removeItems(A, '.form_review .removeButton');
		    removeItems(A, '.form_review #'+ namespace +'challengeLogo');// todo check this?
		    removeItems(A, '.form_review .sp_tab_buttons');
		    removeItems(A, '.form_review .sp_tabs');
		    removeItems(A, '.form_review .btn-content.btn');
//		    AUI().all('.form_review .btn-content.btn').setStyle('display','none')
		    var formRFields = A.all('.form_review input[type="text"]');
			formRFields.each(function(r){
				//Fix for Ie9. cloned node not able to get its value. So setting its value explicitly
				try{
					 // var value = A.one(" .smartForm #" + r.get('id')).val();
					//  A.one(".form_review  " + "#" + r.get('id')).val(value);
					var temp = A.one(".smartForm input[name='"+ r.get("name") + "']");
					r.val(temp.val());
				
				}catch(err){
					
				}
				
				r.setAttribute('disabled', 'true');
				r.removeClass("field");
			});
			var textareas = A.all('.form_review textarea');
			textareas.each(function(r){
				var temp = A.one(".smartForm textarea[name='"+ r.get("name") + "']");
				r.val(temp.val());
				r.setAttribute('disabled', 'true');
			});

			A.all('.form_review select option[value=""]').html('');
			
			 var selects = A.all('.form_review select');
			 selects.each(function(r){
				var temp = A.one(".smartForm select[name='"+ r.get("name") + "']");
				r.val(temp.val());
				r.setAttribute('disabled', 'true');
			 });
			 // populate multi select categories
			 var selectedOptions = A.all('section.form_1 #'+namespace+'multiSelectCategory :selected');
			 var reviewCat = A.one('section.form_review #'+namespace+'multiSelectCategory');
			 reviewCat.empty();
			 selectedOptions.each(function(o) {
				 var oClone = o.clone();
				 oClone.removeAttribute('selected');
				 reviewCat.insert(oClone);
			 });
			 reviewCat.setStyle('overflow-y','auto');
		} catch (err) {
//			console.log(err);
		}
	});
	});
}

function handleScroll(offset, delay) {
	YUI().use('event-hover','node', 'transition', 'event', 'event-valuechange',  function (Y) {
	
		//sticky navigation bar isnt required when on lower resolutions
		if(document.documentElement.scrollWidth < 777) {
			console.log('mobile view..');
			return;
		}
		//coz some of the page elements are loaded 
		window.setTimeout(enableSticky, delay);
	
		function enableSticky(){
			var footer=Y.one('footer');
			var sticky = Y.one('.profile_form_navigation');
			window.scrollTo(0,0);
			var stickytop = sticky.getY();
			var contentHeight = document.documentElement.scrollHeight;
			var stickyheight = sticky.getDOMNode().offsetHeight;
			var maxScroll =  (footer.offsetTop?footer.offsetTop:contentHeight) - stickyheight - offset;
			Y.on('scroll', function (e) {
				// contentHeight might change diff tabs are selected
				if (document.documentElement.scrollHeight != contentHeight) {
					contentHeight = document.documentElement.scrollHeight;
					maxScroll =  (footer.offsetTop?footer.offsetTop:contentHeight) - stickyheight - offset - 24;
					console.log('content height change..recalculating');
				}
				var currPos = window.pageYOffset;
				if ((currPos >= (stickytop - offset)) && currPos < maxScroll) { // between
					sticky.setStyle('position', 'fixed');
	                sticky.setStyle('top', offset);
	                sticky.setStyle('margin-top', '0px');
				} else if (currPos >= maxScroll) { // reached bottom
					sticky.setStyle('position', 'absolute');
					sticky.setStyle('top', maxScroll);
				} else { // reached top
					sticky.setStyle('position', 'absolute');
					sticky.setStyle('top', 'auto');
				} 
			});
		}
	});
}
function gotoTab(tabname) {
	YUI().use('event-hover','node', 'transition', 'event', 'event-valuechange',  function (Y) {
		try {
			try {
				var active = Y.one('.profile_form_navigation nav .active');
				if(active.get("id") == tabname)
					return;
			}catch (err) {}
			var tabForms = Y.all('.profile_form .form');
			var tabNavItems = Y.all('.profile_form_navigation nav ul li');
			var targ = Y.one("." + tabname);
			var form = Y.one('.profile_form');
			window.scrollTo(0,0);
			tabNavItems.each(function(a){
				a.removeClass('active');
			});
			
			tabForms.each(function(b){
				b.removeClass('animated fadeIn');
				b.addClass('animated fadeOut');
			});
			
			var targName = targ.get('id');
			var targForm = Y.one('.profile_form .form#' + targName);
			
			var timeHandle = Y.later(500, targForm, function(t){
				tabForms.each(function(c){
					c.removeClass('active');
					c.removeClass('animated fadeOut');
				});
				targForm.addClass('active');
				targForm.addClass('animated fadeIn');
			},[],false);
			var timeHandle2 = Y.later(1000, targForm, function(t){
				targForm.removeClass('fadeIn');
			},[],false);
			Y.all('.profile_form_navigation nav ul #' + tabname).addClass('active');
		} catch (err) {}
	});
}

function proceedToNextSignupPage() {
		try {
			showSignupForm('2');
		} catch (err) {}
}

function showSignupForm(formNumber) {
	YUI().use('event-hover','node', 'transition', 'event', 'event-valuechange',  function (Y) {
		var tabForms = Y.all('.profile_form .form');
		window.scrollTo(0,0);			
		tabForms.each(function(b){
			b.removeClass('animated fadeIn');
			b.addClass('animated fadeOut');
		});
		
		var targForm = Y.one('.profile_form .form.form_'+formNumber);
		
		var timeHandle = Y.later(500, targForm, function(t){
			tabForms.each(function(c){
				c.removeClass('active');
				c.removeClass('animated fadeOut');
			});
			targForm.addClass('active');
			targForm.addClass('animated fadeIn');
		},[],false);
		var timeHandle2 = Y.later(1000, targForm, function(t){
			targForm.removeClass('fadeIn');
		},[],false);
		targForm.addClass('active');	
	});
}

function showNameMissingWarning(){
	try {
		AUI().use('aui-node', 'aui-base', 'aui-io-request-deprecated', 'aui-aria', 'liferay-util-window', 'aui-overlay-manager-deprecated', 'dd-constrain',
				function(A) {
		 var wind = Liferay.Util.Window.getWindow(
					{
						dialog: {
									bodyContent :  nameLogo,
									centered : true,
									cache: false,
									destroyOnClose: true,
									destroyOnHide: true,
									height : 200,
									width : 400,
									modal : true,
									constrain2view : true,
									toolbars: {
										footer:[
											        { on: {click: function() {  
											        	wind.hide();
											        	}}, 
											        	label: 'Ok',
											        	text:'Ok'
											        }
										        ]
									}
							},
							title : warningLabel
							}).render();
		});
		
	} catch (err) {}
}


function removeItems(A, selector){
	try {
		if(A.all(selector) && A.all(selector).size() > 0)
			A.all(selector).remove();
	} catch (err) {
		console.log(err);
	}
}

