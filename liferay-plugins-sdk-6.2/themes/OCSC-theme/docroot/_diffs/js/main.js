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

YUI().ready('node', 'event', 'anim', function(Y) {
    try {
        console.log("Trigger content name update and content tracking");
        var j = 0;
        var k = 0;
        Y.all('.minisite-wrap').each(function() {
            if (this.hasClass('mini-accordion-wrap')) {
                if (k == 0) {
                    j = j + 1;
                    k = k + 1;
                }
                this.setAttribute('data-content-name', 'Section ' + j);
            } else {
                j = j + 1;
                var mn_data_content = this.setAttribute('data-content-name', 'Section ' + j);
            }
            var mn_wrapname = this.getAttribute('data-content-name');
            var mn_innervalue = this.getAttribute('data-content-piece');
            this.all('a').each(function() {
                if (this.getAttribute('data-content-name') == '') {
                    var mn_attrdata = this.getAttribute('href');
                    this.setAttribute('data-track-content', '');
                    this.setAttribute('data-content-name', mn_wrapname);
                    this.setAttribute('data-content-target', mn_attrdata);
                }
                if (this.getAttribute('data-content-piece') == '') {
                    this.setAttribute('data-content-piece', mn_innervalue);
                }
            });

            this.all('.mini-accordianheader').each(function() {
                if (this.getAttribute('data-content-name') == '') {
                    this.setAttribute('data-content-name', mn_wrapname);
                }
            });
        });
    } catch(err) {
        console.log("Failed to assign dynamic content name." + err)
    }

    if (typeof _paq != "undefined") {
        _paq.push(['trackAllContentImpressions']);
        _paq.push(['enableJSErrorTracking']);
        _paq.push(['logAllContentBlocksOnPage']);
    } else {
        console.log("Analytics not initialised.");
    }

});