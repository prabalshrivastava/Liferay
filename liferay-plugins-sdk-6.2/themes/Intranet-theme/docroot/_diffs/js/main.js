AUI().ready(

	/*
	This function gets loaded when all the HTML, not including the portlets, is
	loaded.
	*/

	function() {
	}
);

Liferay.Portlet.ready(

	/*
	This function gets loaded after each and every portlet on the page.

	portletId: the current portlet's id
	node: the Alloy Node object of the current portlet
	*/

	function(portletId, node) {
	}
);

Liferay.on(
	'allPortletsReady',

	/*
	This function gets loaded when everything, including the portlets, is on
	the page.
	*/

	function() {
	}
);


YUI().ready('node', 'event', 'anim', function(Y) {
	var th = Y.one('html.th');
	var header = Y.one('header#banner');
	if (header) {
		if (th) {

			header.addClass('abs');
			header.removeClass('theme-bg');

			if (window.scrollY || window.pageYOffset >= 10) {
				header.addClass('theme-bg');
			} else {
				header.removeClass('theme-bg');
			}

			Y.on('scroll', function(e) {
				if (window.scrollY || window.pageYOffset >= 10) {
					header.addClass('theme-bg');
				} else {
					header.removeClass('theme-bg');
				}

			});
		} else {
			header.addClass('theme-bg');
		}
	}
});

YUI().use('node','event','anim',function(Y){
	
	var mobile_menu = Y.one('.mobile-navigation-button button');
	if(mobile_menu){
		mobile_menu.on('click', mobileMenuClick);
		
		
		
	}
});


function mobileMenuClick(e){
	
	var targ = e.currentTarget;

	
	YUI().use('node','event','anim',function(Y){
		
		targ.toggleClass('active');
		
		var mobile_menu_content = Y.one('.mobile-menu-content');
		if(mobile_menu_content){
			mobile_menu_content.toggleClass('active');
		}
		
	});
}