AUI().ready(

/*
 * This function gets loaded when all the HTML, not including the portlets, is
 * loaded.
 */

function() {
});

Liferay.Portlet.ready(

/*
 * This function gets loaded after each and every portlet on the page.
 * 
 * portletId: the current portlet's id node: the Alloy Node object of the
 * current portlet
 */

function(portletId, node) {
});

Liferay.on('allPortletsReady',

/*
 * This function gets loaded when everything, including the portlets, is on the
 * page.
 */

function() {
});

function findPos(obj) {
	var curtop = 0;
	if (obj.offsetParent) {
		do {
			curtop += obj.offsetTop;
		} while (obj = obj.offsetParent);
		return [ curtop - 140 ];
	}

};

function truncChar(elem, numChar) {
	YUI().use('event-hover', 'node', 'transition', 'event', function(Y) {

		var trunc = elem;
		var tempText = trunc.get('innerHTML');

		trunc.set('innerHTML', '');
		trunc.set('innerHTML', shorten(tempText, numChar));
	});
}

function shorten(text, maxLength) {
	var ret = text;

	if (ret.length > maxLength) {
		ret = ret.substr(0, maxLength - 3) + "...";
	}
	return ret;
}