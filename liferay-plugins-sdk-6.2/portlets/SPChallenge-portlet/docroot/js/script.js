
YUI().use('event-hover','node', 'transition', 'event', 'event-valuechange',  function (Y) {
	
	
	
	var cbCTA = Y.one('.sp_profile section.head .cta_wrap .cta_item.cb a');
	if(cbCTA)
		cbCTA.on('click', profileCBClick);
	
	var newCTA = Y.one('.sp_profile section.head .cta_wrap .cta_item.new a');
	if(newCTA)
		newCTA.on('click', profileNewClick);
	
	var cbListOpt = Y.all('.crunchbaseSelectList input');
	cbListOpt.on('change',function(e){
		
		console.log('Selected' +e);
		var cbList = Y.one('.crunchbaseSelectList');
		var cbListW = Y.one('.crunchbaseSelectList .cbListWrap');
		var profileContent = Y.one('.profile_content');
			
			cbList.removeClass('fadeIn ');
			cbListW.removeClass('fadeInDown d_down');
			
			
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
				//console.log(form);
				cbList.removeClass('active');
				cbListW.removeClass('active');
				cbList.removeClass('fadeOut d_down');
				//cbList.removeClass('no_height');
				cbListW.removeClass('slideOutUp');
				
				profileContent.addClass('active');
				//profileContent.removeClass('slideOutDown ');
				//profileContent.addClass('animated slideInDown2');
				
				formNavigation.addClass('animated4 slideInLeft');
				   formNavigation.addClass('posFixed');
				   formNavigation.setStyle('display', 'inline-block');
				   
				   
				   profileContentForm.addClass('animated4 slideInRight');
				   profileContentForm.setStyle('display', 'inline-block');
				
				
				
				
			},[],false);
			
			
			
			var timeHandle4 = Y.later(2100, profileContent, function(t){
				
				
				
				//profileContent.removeClass('slideInDown2');
				
				
				
				
			},[],false);
		
		var head = Y.one('.sp_profile .head');
		var headW = head.one('.head_wrap');
		head.addClass('no_height');
		headW.addClass('animated3 slideOutUp2 ');
		
		
	});
	
	
	function profileCBClick(e){
		var targ = e.currentTarget;
		var targP = targ.get('parentNode');
		var head = Y.one('.sp_profile section.head');
		var profCTA = Y.all('.sp_profile section.head .cta_wrap .cta_item');
		
		profCTA.each(function(c){
			c.removeClass('active');
		});
		targP.addClass('active');
		var cbList = Y.one('.crunchbaseSelectList');
		var cbListW = Y.one('.crunchbaseSelectList .cbListWrap');
		
		cbList.removeClass('no_height');
		head.addClass('no_height');
		
		cbList.addClass('active animate');
		cbList.setStyle('height', '162px');
			cbList.addClass('fadeIn ');
			cbListW.addClass('active');
			cbListW.addClass('fadeInDown d_down');
		
		
	}
	
	
	
	
	
	function profileNewClick(e){
		var targ = e.currentTarget;
		var targP = targ.get('parentNode');
		var profCTA = Y.all('.sp_profile section.head .cta_wrap .cta_item');
		
		profCTA.each(function(c){
			c.removeClass('active');
		});
		
		targP.addClass('active');
		var cbList = Y.one('.crunchbaseSelectList');
		var cbListW = Y.one('.crunchbaseSelectList .cbListWrap');
		var profileContent = Y.one('.profile_content');
		var profileContentForm = profileContent.one('.profile_form ');
			
			cbList.removeClass('fadeIn ');
			cbListW.removeClass('fadeInDown d_down');
			
			
			cbList.addClass('fadeOut d_down');
			cbList.addClass('no_height');
			cbListW.addClass('slideOutUp ');
			
			
			
			var timeHandle = Y.later(800, cbList, function(t){
				//console.log(form);
				cbList.removeClass('active');
				cbListW.removeClass('active');
				cbList.removeClass('fadeOut d_down');
				//cbList.removeClass('no_height');
				cbListW.removeClass('slideOutUp');
				
				profileContent.addClass('active');
				//profileContent.removeClass('slideOutDown');
				//profileContent.addClass('animated slideInDown');
				
				
				
				
			},[],false);
		
		   var formNavigation = profileContent.one('.profile_form_navigation');
		   var profileContentForm = profileContent.one('.profile_form ');
		   
		   formNavigation.setStyle('display', 'none');
		   profileContentForm.setStyle('display', 'none');
		   
		   formNavigation.removeClass('slideOutLeft');
		   profileContentForm.removeClass('slideOutRight');
		  
		   
		   var timeHandle6 = Y.later(1000, formNavigation, function(t){
			   formNavigation.addClass('animated4 slideInLeft');
			   formNavigation.addClass('posFixed');
			   formNavigation.setStyle('display', 'inline-block');
			   
			   
			   profileContentForm.addClass('animated4 slideInRight');
			   profileContentForm.setStyle('display', 'inline-block');
			   
			},[],false);
		   var timeHandle5 = Y.later(1400, profileContent, function(t){
						//profileContent.removeClass('slideInDown');
						
						
			},[],false);
		  
			
		var head = Y.one('.sp_profile .head');
		var headW = head.one('.head_wrap');
		head.addClass('no_height');
		headW.addClass('animated3 slideOutUp2 ');
		
	}
	
	
});

YUI().use('event-hover','node', 'transition', 'event', 'event-valuechange',  function (Y) {
	
	var tabNavItems = Y.all('.profile_form_navigation nav ul li');
	var tabForms = Y.all('.profile_form .form');
	var formCTA_proceed = Y.all('.profile_form .form .formCTA .proceed ');
	var formCTA_cancel = Y.all('.profile_form .form .formCTA .cancel ');
	var mobileNavSelect = Y.one('.mobileNavSelect');
	
	
	
	if(Y.one('.vp480') || Y.one('.vp1024.portraitMode')){
		var tabMobileClick = Y.all('.profile_form .form .formTitle');
		//tabMobileClick.on('click',tabItemClick_mobile);
		var mobileFormNavItem = Y.all('.profile_form_navigation nav ul li');
		var mobileProceedForm = Y.all('.profile_form .form .formCTA .proceed');
		
		
		mobileFormNavItem.on('click', mobileNavItemClick);
		mobileNavSelect.on('click',mobileNavSelectClick);
		//mobileProceedForm.on('click', mobileFormProceedClick);
	}
	
	
	
	
	tabNavItems.on('click', tabNavItemClick);
	formCTA_proceed.on('click',proceedClick);
	formCTA_cancel.on('click',cancelClick);
	
	function cancelClick(e){
		var targ = e.currentTarget;
		var profContent = targ.ancestor('.profile_content');
		var profForm = targ.ancestor('.profile_form');
		var profFormNav = profContent.one('.profile_form_navigation');
		var profHead = Y.one('.sp_profile section.head');
		var profHeadW = Y.one('.head_wrap');
		
		
		profForm.removeClass('slideInRight');
		profForm.addClass('slideOutRight');
		
		profFormNav.removeClass('slideInLeft');
		profFormNav.addClass('slideOutLeft');
		//profContent.removeClass('animated slideInDown');
		
		//profHead.removeClass('no_height');
		//profHeadW.removeClass('animated3 slideOutUp2');
		//profHeadW.addClass('animated slideInDown');
		
		
		
		
		var timeHandle7 = Y.later(700, profForm, function(t){
					//profileContent.removeClass('slideInDown');
			
					profContent.removeClass('active');
					location.reload();
					window.scrollTo(0,0);

		},[],false);
		
	}
	
	function proceedClick(e){
		var targ = e.currentTarget;
		var form = targ.ancestor('section.form');
		var formWrap = form.get('parentNode');
		var formName = form.getAttribute('form-name'); 
		
		var formTabNav = Y.one('.profile_form_navigation nav ul li#'+formName);
		formTabNav.addClass('formDone');
		formTabNav.removeClass('active');
		
		//formWrap.addClass('loadForm');
		form.removeClass('animated fadeInDown');
		form.addClass('animated fadeOutDown');
		window.scrollTo(0,0);
		
		var nextForm = form.next('section.form');
		if(!nextForm){
			return;
		}
		var nextFormName = nextForm.getAttribute('form-name');
		var nextFormTitle = nextForm.one('.formTitle').get('innerHTML');
		var nextFormTabNav = Y.one('.profile_form_navigation nav ul li#'+nextFormName);
		
		// If it is brief review validate the form
		if(nextFormTabNav.get("id") == 'brief_review'){
			var hasErrors = validateApplyChallenge();
			if(hasErrors){
				return;
			}
		}
		
		mobileNavSelect.set('innerHTML', '');
		mobileNavSelect.set('innerHTML', nextFormTitle);
		
		nextFormTabNav.addClass('active');
		
		var timeHandle = Y.later(500, form, function(t){
			//console.log(form);
			form.removeClass('active');
			form.removeClass('animated fadeOutDown');
		},[],false);
		
		var timeHandle1 = Y.later(500, nextForm, function(t){
			//console.log(nextForm);
			nextForm.addClass('active');
			nextForm.addClass('animated fadeInDown');
			//formWrap.removeClass('loadForm');
		},[],false);
		
		var formR = Y.one('.formFields_data');
		if(nextFormTabNav.get("id") == 'form_review'){
			showReviewTab()
		} else if(nextFormTabNav.get("id") == 'brief_review'){
			showBriefReviewTab()
		} else {
			formR.empty();
		}
		
		
		if(Y.one('.tab_helpText')){
			try {
				var tabHelp = Y.one('.tab_helpText');
				var targHelpText = nextFormTabNav.getAttribute('help-text');
				var targContent = nextFormTabNav.one('span').get('innerHTML');
				
				var tabHelpTitle = tabHelp.one('.title_helpText span b');
				var tabHelpContent = tabHelp.one('.content_helpText span ');
				
				tabHelpTitle.set('innerHTML', '');
				tabHelpTitle.set('innerHTML', targContent);
				if (tabHelpContent != null) {
					tabHelpContent.set('innerHTML', '');
					tabHelpContent.set('innerHTML', targHelpText);
				}
			} catch (err) {
			}
		}
		
	}

	function tabNavItemClick(e){
		var targ = e.currentTarget;
		var form = Y.one('.profile_form');
		window.scrollTo(0,0);
		//form.addClass('loadForm');
		tabNavItems.each(function(a){
			a.removeClass('active');
			
		});
		targ.addClass('active');
		
		tabForms.each(function(b){
			
			b.removeClass('animated fadeInDown');
			b.addClass('animated fadeOutDown');
		});
		
		var targName = targ.get('id');
		var targForm = Y.one('.profile_form .form.'+targName);
		console.log(targForm);
		
		var timeHandle = Y.later(500, targForm, function(t){
			//console.log(nextForm);
			
			tabForms.each(function(c){
				c.removeClass('active');
				c.removeClass('animated fadeOutDown');
				
			});
			targForm.addClass('active');
			targForm.addClass('animated fadeInDown');
			//form.removeClass('loadForm');
		},[],false);
		
		
		var formR = Y.one('.formFields_data');
		if(targ.get('id') == 'form_review'){
			showReviewTab();
		} else if (targ.get('id') == 'brief_review') {
			showBriefReviewTab();
		} else {
			formR.empty();
		}
		
		
		if(Y.one('.tab_helpText')){
			var tabHelp = Y.one('.tab_helpText');
			var targHelpText = targ.getAttribute('help-text');
			var targContent = targ.one('span').get('innerHTML');
			
			var tabHelpTitle = tabHelp.one('.title_helpText span b');
			var tabHelpContent = tabHelp.one('.content_helpText span ');
			
			tabHelpTitle.set('innerHTML', '');
			if (tabHelpContent != null) {
				tabHelpContent.set('innerHTML', '');
				tabHelpContent.set('innerHTML', targHelpText);
			}
			tabHelpTitle.set('innerHTML', targContent);
			
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


function showReviewTab() {
	YUI().use('event-hover','node', 'transition', 'event', 'event-valuechange',  function (Y) {
	var formR = Y.one('.formFields_data');
	AUI().use('aui-node', 'aui-base', function(A) {
		try{
		    var tabs = A.all("#" + namespace + "addStartup .form");
		    tabs.each(function(r) {
		    	if(!r.hasClass('form_review') && !r.hasClass('form_applyBrief')) {
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
		    A.all('.form_review .formFields_data .formCTA').remove();
		    A.all('.form_review .addButton').remove();
		    A.all('.form_review .removeButton').remove();
		    
		    var formRFields = A.all('.form_review .formFields_data .field');
			formRFields.each(function(r){
				try{
					r.setAttribute('readonly', 'true');
					r.removeClass("field");
					var temp = A.one(".profileData input[name='"+ r.get("name") + "']");
					r.val(temp.val());
				}catch(error){
					
				}
			});
			var textareas = A.all('.form_review textarea');
			textareas.each(function(r){
				try{
					r.setAttribute('readonly', 'true');
					var temp = A.one(".profileData textarea[name='"+ r.get("name") + "']");
					r.val(temp.val());
				}catch(error){
					
				}
			});
			var selects = A.all('.form_review select');
			selects.each(function(r){
				try{
					r.setAttribute('disabled', 'true');
					var temp = A.one(".profileData select[name='"+ r.get("name") + "']");
					r.val(temp.val());
				}catch(error){
					
				}
			});
		} catch (err) {
			console.log(err);
		}
	});
	});
}


function showBriefReviewTab() {
	YUI().use('event-hover','node', 'transition', 'event', 'event-valuechange',  function (Y) {
	var formR = Y.one("#" + namespace + "applyChallenge .brief_review .formFields_data");
	formR.empty();
	AUI().use('aui-node', 'aui-base', function(A) {
		try{
		    var tabs = A.all("#" + namespace + "applyChallenge .form_applyBrief");
		    tabs.each(function(r) {
		    	
			    	var section = A.Node.create("<div class='form_section'></div>");
			    	var children = r.clone().get("children");
			    	children.each(function(e){
			    		if(e.hasClass("formTitle"))
			    			e.replaceClass("formTitle", "formSectionTitle");
			    		e.appendTo(section);
			    	});
			    	section.appendTo(formR);
		    	
		    });
		    // remove buttons
		    A.all('.brief_review .formFields_data .formCTA').remove();
		    
		    var formRFields = formR.all('.field');
			formRFields.each(function(r){
				r.setAttribute('disabled', 'true');
				r.removeClass("field");
			});
			
			var textareas = A.all('.brief_review textarea');
			textareas.each(function(r){
				var temp = A.one(".smartForm textarea[name='"+ r.get("name") + "']");
				r.val(temp.val());
			});
		} catch (err) {
			console.log(err);
		}
	});
	});
}


function gotoTab(tabname) {
	YUI().use('event-hover','node', 'transition', 'event', 'event-valuechange',  function (Y) {
	var tabForms = Y.all('.profile_form .form');
	var tabNavItems = Y.all('.profile_form_navigation nav ul li');
	var targ = Y.one("." + tabname);
	var form = Y.one('.profile_form');
	window.scrollTo(0,0);
	tabNavItems.each(function(a){
		a.removeClass('active');
	});
	
	tabForms.each(function(b){
		b.removeClass('animated fadeInDown');
		b.addClass('animated fadeOutDown');
	});
	
	var targName = targ.get('id');
	var targForm = Y.one('.profile_form .form#'+targName);
	
	var timeHandle = Y.later(500, targForm, function(t){
		tabForms.each(function(c){
			c.removeClass('active');
			c.removeClass('animated fadeOutDown');
		});
		targForm.addClass('active');
		targForm.addClass('animated fadeInDown');
	},[],false);
	Y.all('.profile_form_navigation nav ul #' + tabname).addClass('active');
	});
}


