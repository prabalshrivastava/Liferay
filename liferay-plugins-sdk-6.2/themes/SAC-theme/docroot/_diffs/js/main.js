AUI().ready(

    /*
    This function gets loaded when all the HTML, not including the portlets, is
    loaded.
    */

    function() {}
);

Liferay.Portlet.ready(

    /*
    This function gets loaded after each and every portlet on the page.

    portletId: the current portlet's id
    node: the Alloy Node object of the current portlet
    */

    function(portletId, node) {}
);

Liferay.on(
    'allPortletsReady',

    /*
    This function gets loaded when everything, including the portlets, is on
    the page.
    */

    function() {}
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
    } catch (err) {
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


//Mini Site
YUI().use(
    'aui-toggler',
    function(Y) {
        new Y.TogglerDelegate({
            animated: false,
            closeAllOnExpand: false,
            content: '.minisite-content',
            expanded: false,
            header: '.mini-accordianheader',


        });
    }
);



//Microsite Testoimonials Accordion
var accItemEvent = document.getElementsByClassName('emaccordionItem');
var accHDEvent = document.getElementsByClassName('emaccordionItemHeading');
for (i = 0; i < accHDEvent.length; i++) {
    accHDEvent[i].addEventListener('click', toggleItem1, false);
}

function toggleItem1() {
    var itemClassEvent = this.parentNode.className;
    for (i = 0; i < accItemEvent.length; i++) {
        accItemEvent[i].className = 'emaccordionItem emClose';
    }
    if (itemClassEvent == 'emaccordionItem emClose') {
        this.parentNode.className = 'emaccordionItem emOpen';
    }
}

function moveToDashboard(){
	window.location.href = "https://ems.sambaash.com";
}
function editFormIoPage(){
	window.location.href = window.location.href.replace("view","edit");
}
function reload(){
	window.location.reload();
}
function showLoading(show) {
	if(show) {
		document.getElementById("loadingDiv").style.display = "block";
	} else {
		document.getElementById("loadingDiv").style.display = "none";
	}
}
function setCookie(cname, cvalue, exSeconds) {
	  var d = new Date();
	  d.setTime(d.getTime() + (exSeconds*1000));
	  var expires = "expires="+ d.toUTCString();
	  document.cookie = cname + "=" + cvalue + ";" + expires + ";path=/";
}
function getCookie(cname) {
  var name = cname + "=";
  var decodedCookie = decodeURIComponent(document.cookie);
  var ca = decodedCookie.split(';');
  for(var i = 0; i <ca.length; i++) {
    var c = ca[i];
    while (c.charAt(0) == ' ') {
      c = c.substring(1);
    }
    if (c.indexOf(name) == 0) {
      return c.substring(name.length, c.length);
    }
  }
  return "";
}
function checkCookie() {
  var user = getCookie("username");
  if (user != "") {
    alert("Welcome again " + user);
  } else {
    user = prompt("Please enter your name:", "");
    if (user != "" && user != null) {
      setCookie("username", user, 365);
    }
  }
}

//Minisite Cover Section Testimonials

  var accItem = document.getElementsByClassName('accordionItem');
    var accHDMs = document.getElementsByClassName('accordionItemHeading');
    for (i = 0; i < accHDMs.length; i++) {
        accHDMs[i].addEventListener('click', toggleItem2, false);
    }
    function toggleItem2() {
        var itemClass = this.parentNode.className;
        for (i = 0; i < accItem.length; i++) {
            accItem[i].className = 'accordionItem enClose';
        }
        if (itemClass == 'accordionItem enClose') {
            this.parentNode.className = 'accordionItem enOpen';
        }
    }