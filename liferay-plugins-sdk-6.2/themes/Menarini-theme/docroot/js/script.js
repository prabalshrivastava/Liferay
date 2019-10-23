YUI().use('event-hover', 'node', 'transition', 'event', 'anim', function(Y) {
	console.log('loaded');
	Y.on('scroll', function(e){
		//console.log('scrolling...');
		var nav = Y.one('.main-navigation');
		
		
		if(window.scrollY > 10 || window.pageYOffset > 10 ){
			console.log('hit');
			//nav.setStyle('top','0px');
			if(nav)
			nav.addClass('scrolled');
		}
		
		else{
			//nav.setStyle('top','63px');
			if(nav)
			nav.removeClass('scrolled');
		}
	});
	
});



//Ripple 


YUI().use('event-hover', 'node', 'transition', 'event', function(Y) {
	
	var prof_view = Y.one('.sp_profile_view');
	if(prof_view){
		var prof_view_formItem = prof_view.all('.form .formViewItem .formTitle');
		prof_view_formItem.each(function(a){
			
			
			a.on('click', formViewClick);
		});
		
	
	}
	
	function formViewClick(e){
		var targ = e.currentTarget;
		var pTarg = targ.get('parentNode');
		
		pTarg.toggleClass('active');
		
		//is in main.js of startupprofile portlet
		try{registerAllTextAreaListener()}catch(err){}
	}
	
});


YUI().use('event-hover', 'node', 'transition', 'event', function(Y) {
	
	var trunc = Y.all('.maxChar');
	trunc.each(function(a){
		var truncItem = a.all(' ul li > a');
		
		truncItem.each(function(b){
			var tempText = b.get('innerHTML');
			//console.log(tempText);
			b.set('innerHTML','');
			b.set('innerHTML',shorten(tempText,23));
		});
		
		
		
	});
	
});

var body = document.body;


function animMenuRight() {
    toggleClass(menuRight, 'menu-open');
};

function disableOther(button) {

    if (button !== 'showright') {
        toggleClass(showRight, 'disabled');
    }

};

YUI().use('event-hover','node', 'transition', 'event', 'anim', 'datatype-number', function (Y) {
		Y.on('load', function() {
							
							node = Y.one('.se-pre-con');
							if(node)
							node.hide();
							
							node = Y.one('.bullets');
							if(node)
							node.show();
		});
		var header = Y.one('header.main-header');
		
		if(Y.one('.adminCtrls')){
			console.log('adminC')
			var adminCtrl = Y.one('.adminCtrls');
			adminCtrl.on('click', adminCtrlClick);
		}
		
		if(Y.one('.backToTop')){
			var backToTop = Y.one('.backToTop');
			backToTop.on('click', backTop);
		}
		 if(window.scrollY > 10 || window.pageYOffset > 10 ){
			 	header.addClass('down');
				backToTop.addClass('vis');
			 }
			 else{
			 	header.removeClass('down');
				backToTop.setStyle('opacity','1');
				backToTop.removeClass('vis');
			 }
		
		Y.on('scroll', function(e) {     
			 backToTop.removeClass('vis');
			 
			 if(window.scrollY > 10 || window.pageYOffset > 10 ){
			 	
				
				header.addClass('down');
				backToTop.addClass('fadeIn');
				backToTop.removeClass('fadeOut');
				backToTop.setStyle('right', '2%');
			 }
			 else{
			 	header.removeClass('down');
				backToTop.removeClass('fadeIn');
				backToTop.addClass('fadeOut');
				backToTop.setStyle('right', '-20%');
			 }
		});
		
		function adminCtrlClick(e){
			var targ = e.currentTarget;
			var htmlElem = Y.one('html');
			
			if(htmlElem.hasClass('no-ad')){
				htmlElem.removeClass('no-ad');
				targ.one('span.test').setStyle('display','none');
				targ.one('span.ad').setStyle('display','block');
				targ.setStyle('top','15%');
			}else{
				htmlElem.addClass('no-ad');
				targ.one('span.test').setStyle('display','block');
				targ.one('span.ad').setStyle('display','none');
				targ.setStyle('top','11%');
			}
			
			
		}
		
		function backTop(e){
			e.preventDefault();
			
			var targ = e.currentTarget;
			
			//window.scrollTo(0,0);
			var scrollAnim = new Y.Anim({
				node: Y.one(Y.UA.gecko || Y.UA.ie || !!navigator.userAgent.match(/Trident.*rv.11\./) ? 'html' : 'body'),
				to: {
					scrollTop : Y.one('html.aui').getY()
				},
				duration: 1.3,
				easing: 'easeBoth'
			});
			
			scrollAnim.run();
			
		}
		
	});

	YUI().use('event-hover','node', 'transition', 'event', 'anim', 'datatype-number', function (Y) {
		
	if(Y.one('.toggleAdminControls a')){
		var toggleAdmin = Y.one('.toggleAdminControls a');
		var clickedTog = false;

		toggleAdmin.on('click', toggleClick);
		}

		function toggleClick(e){
			var targ = e.currentTarget;

			var header = Y.one('header.main-header');
			header.setStyle('margin-top', 0);
			if( Y.one('.dp')){
				var content = Y.one('.dp .content');
				content.setStyle('margin-top', '82px');
			} else{
				Y.one('.content').setStyle('margin-top','82px');
			}

			var db = Y.one('.portlet-dockbar');
			var portletTopper = Y.all('.portlet-topper');
			var portletAction = Y.all('.icons-container');

			db.toggleClass('toggleOff');
			portletTopper.each(function(a){
				a.toggleClass('toggleOff');
			});
			portletAction.each(function(b){
				b.toggleClass('toggleOff');
			});

			if(clickedTog){
				//console.log('Clicked True');
				clickedTog = false;
				if( Y.one('.dp')){
					var content1 = Y.one('.dp .content');
					content1.setStyle('margin-top', '112px');
					header.setStyle('margin-top', '30px');
				}
				else{
					Y.one('.content').setStyle('margin-top','82px');
				}

			}else{
				//console.log('Clicked False');
				clickedTog = true;
			}

		}

	});
	
	
//Mobile
	
	YUI().use('event-hover','node', 'transition', 'event', 'anim', 'datatype-number', function (Y) {
		
		var mobileMenu  = Y.one('.main-navigation-mobile');
		var mobileMenuBtn = Y.one('.mobile-navigation-button');
		var mobile_header = Y.one('.main-header-mobile');
		var didScroll;
		   var lastScrollTop = 0;
		   var delta = 5;
		   var navbarHeight = mobile_header.get('offsetHeight');
		
		
		if(mobileMenuBtn){
			mobileMenuBtn.on('click', mobileMenuBtnClicked);
		}
		
		
		
		Y.on('scroll', function(e) {    
			if(window.scrollY > 10 || window.pageYOffset > 10 ){
				didScroll = true;
			}
		});
		
		setInterval(function() {
		    if (didScroll) {
		        //hasScrolled();
		        didScroll = false;
		    }
		}, 10);
		
		function hasScrolled() {
		    var st = this.scrollTop();
		    
		    if(Math.abs(lastScrollTop - st) <= delta)
		        return;
		    
		    if (st > lastScrollTop && st > navbarHeight){
		        // Scroll Down
		        //header_lp.removeClass('nav-down').addClass('nav-up');
		    	mobile_header.removeClass('nav-down').addClass('nav-up');

		        if(mobileMenuBtn){
		        	mobileMenuBtn.removeClass('nav-down').addClass('nav-up');
		        	mobileMenu.removeClass('active');
		        }
		    } else {
		        // Scroll Up
		        if(st + win.get('offsetHeight') < doc.get('offsetHeight')) {
		            //header_lp.removeClass('nav-up').addClass('nav-down');
		        	mobile_header.removeClass('nav-up').addClass('nav-down');
		            if(mobileMenuBtn){
			        	mobileMenuBtn.removeClass('nav-up').addClass('nav-down');
			        	mobileMenu.removeClass('active');
			        }

		        }
		    }
		    
		    lastScrollTop = st;
		}

		
		
		function mobileMenuBtnClicked(e){
			var targ = e.currentTarget;
			
			var parentTarg = targ.get('parentNode').get('parentNode');
			parentTarg.toggleClass('active');
		}
		
	});

	
	function shorten(text, maximumLen) {
		
		var ret = text ? text : "" ;
		var maxLength = maximumLen ? maximumLen : 200 ;
		if (ret.length > maxLength) {
			ret = ret.trim().substr(0, maxLength - 3) + "...";
		}
		return ret;
	}
