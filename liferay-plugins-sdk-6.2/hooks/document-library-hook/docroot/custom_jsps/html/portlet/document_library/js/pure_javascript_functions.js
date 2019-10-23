/**
* add event handler.
*/
function addEventHandler(elem, eventType, handler) {
	if (elem.addEventListener) {
		elem.addEventListener(eventType, handler, false);
	}
	else if (elem.attachEvent) {
		elem.attachEvent('on' + eventType, handler); 
	}else {
		elem["on" + eventType] = handler;
	}
}

/**
* remove event handler.
*/
function removeEvent(elem, eventType, handler) {
    if(elem.removeEventListener) {
    	elem.removeEventListener(eventType, handler, false );
    }else if(elem.detachEvent) {
    	elem.detachEvent("on" + eventType, handler);
    }else{
    	elem["on" + eventType] = function() {};
    }
    return elem;
}

/**
* Getting the closest parent with custom attribute.
*/
function getClosestParentByAttribute(obj, strAttributeName, strAttributeValue) {
    var oAttributeValue = (typeof strAttributeValue != "undefined")? new RegExp("(^|\\s)" + strAttributeValue + "(\\s|$)", "i") : null;
	var obj_parent = obj.parentNode;
	if (!obj_parent) return false;
    var oAttribute = obj_parent.getAttribute && obj_parent.getAttribute(strAttributeName);
    if(typeof oAttribute == "string" && oAttribute.length > 0) {
        if(typeof strAttributeValue == "undefined" || (oAttributeValue && oAttributeValue.test(oAttribute))) {
        	return obj_parent;
        }else {
        	return getClosestParentByAttribute(obj_parent, strAttributeName, strAttributeValue);
        }
    }else {
    	return getClosestParentByAttribute(obj_parent, strAttributeName, strAttributeValue);
    }
}

/**
* Getting the closest parent with custom attribute name.
*/
function getClosestParentByAttributeName(obj, strAttributeName) {
	var obj_parent = obj.parentNode;
	if (!obj_parent) return false;
    var oAttribute = obj_parent.getAttribute && obj_parent.getAttribute(strAttributeName);
    if(typeof oAttribute == "string" && oAttribute.length > 0) {
        return obj_parent;
    }else {
    	return getClosestParentByAttributeName(obj_parent, strAttributeName);
    }
}

/**
* get elements by attribute.
*/
function getElementsByAttribute(oElm, strTagName, strAttributeName, strAttributeValue) {
    var arrElements = (strTagName == "*" && oElm.all)? oElm.all : oElm.getElementsByTagName(strTagName);
    var arrReturnElements = new Array();
    var oAttributeValue = (typeof strAttributeValue != "undefined")? new RegExp("(^|\\s)" + strAttributeValue + "(\\s|$)", "i") : null;
    var oCurrent;
    var oAttribute;
    for(var i=0; i<arrElements.length; i++) {
        oCurrent = arrElements[i];
        oAttribute = oCurrent.getAttribute && oCurrent.getAttribute(strAttributeName);
        if(typeof oAttribute == "string" && oAttribute.length > 0) {
            if(typeof strAttributeValue == "undefined" || (oAttributeValue && oAttributeValue.test(oAttribute))) {
                arrReturnElements.push(oCurrent);
            }
        }
    }
    return arrReturnElements;
}

/**
* get first element by attribute.
*/
function getFirstElementsByAttribute(oElm, strTagName, strAttributeName, strAttributeValue) {
	var elems = getElementsByAttribute(oElm, strTagName, strAttributeName, strAttributeValue);
	var elems_length = elems.length;
	if(elems_length > 0) {
		return elems[0];
	}
	return null;
}

/**
* get last element by attribute.
*/
function getLastElementsByAttribute(oElm, strTagName, strAttributeName, strAttributeValue) {
	var elems = getElementsByAttribute(oElm, strTagName, strAttributeName, strAttributeValue);
	var elems_length = elems.length;
	if(elems_length > 0) {
		return elems[elems_length - 1];
	}
	return null;
}

/**
* get elements by attribute name.
*/
function getElementsByAttributeName(oElm, strTagName, strAttributeName) {
    var arrElements = (strTagName == "*" && oElm.all)? oElm.all : oElm.getElementsByTagName(strTagName);
    var arrReturnElements = new Array();
    var oCurrent;
    var oAttribute;
    for(var i=0; i<arrElements.length; i++) {
        oCurrent = arrElements[i];
        oAttribute = oCurrent.getAttribute && oCurrent.getAttribute(strAttributeName);
        if(typeof oAttribute == "string" && oAttribute.length > 0) {
        	arrReturnElements.push(oCurrent);
        }
    }
    return arrReturnElements;
}

/**
* get first element by attribute.
*/
function getFirstElementsByAttributeName(oElm, strTagName, strAttributeName) {
	var elems = getElementsByAttributeName(oElm, strTagName, strAttributeName);
	var elems_length = elems.length;
	if(elems_length > 0) {
		return elems[0];
	}
	return null;
}

/**
* get last element by attribute.
*/
function getLastElementsByAttributeName(oElm, strTagName, strAttributeName) {
	var elems = getElementsByAttributeName(oElm, strTagName, strAttributeName);
	var elems_length = elems.length;
	if(elems_length > 0) {
		return elems[elems_length - 1];
	}
	return null;
}

/**
* prevent default event.
*/
function preventDefault(e) {
	var evt = e || window.event; // IE compatibility
	if(evt.preventDefault){  
		evt.preventDefault();  
	}else{  
		evt.returnValue = false;  
	}
}

function stopPropagation(e) {
	var evt = e || window.event; // IE compatibility
	if (evt.stopPropagation) {
		evt.stopPropagation();
	}
	evt.cancelBubble = true;//for IE
}

/**
* Get event target.
*/
function getEventTarget(e) {
	var targ;
	if (!e) var e = window.event;
	if (e.target) {
		targ = e.target;
	} else if (e.srcElement) {
		targ = e.srcElement;
	}
	
	if (targ.nodeType==3) { // defeat Safari bug 
		targ = targ.parentNode;
	}
	return targ;
}

function hasClass(elem, name) {
   return new RegExp('(\\s|^)'+name+'(\\s|$)').test(elem.className);
}

function addClass(elem, name) {
   if (!hasClass(elem, name)) { elem.className += (elem.className ? ' ' : '') +name; }
}

function removeClass(elem, name) {
   if (hasClass(elem, name)) {
      elem.className=elem.className.replace(new RegExp('(\\s|^)'+name+'(\\s|$)'),' ').replace(/^\s+|\s+$/g, '');
   }
}

function toggleClass(elem, name) {
	if (hasClass(elem, name)) {
		removeClass(elem, name);
	}else {
		addClass(elem, name);
	}
}

//check if the first node is an element node
function getFirstChild(elem) {
	var x = elem.firstChild;
	if(x) {
		while (x.nodeType != 1) {
			x = x.nextSibling;
		}
	}
	return x;
}

function getLastChild(elem) {
	var x = elem.lastChild;
	if(x) {
		while (x.nodeType != 1) {
			x = x.previousSibling;
		}
	}
	return x;
}

function getNextSibling(elem) {
	var x = elem.nextSibling;
	if(x) {
		while (x.nodeType != 1) {
			x = x.nextSibling;
		}
	}
	return x;
}

function getPreviousSibling(elem) {
	var x = elem.previousSibling;
	if(x) {
		while (x.nodeType != 1) {
			x = x.previousSibling;
		}
	}
	return x;
}

function trimStr(str) {
	return str.replace(/^\s\s*/, '').replace(/\s\s*$/, '');
}

function validateURL(urlStr){
	var regex = new RegExp('^(https?|ftp):\\/\\/(((([a-z]|\\d|-|\\.|_|~|[\\' +
            'u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])|(%[\\da-f]{2})' +
            '|[!\\$&\'\\(\\)\\*\\+,;=]|:)*@)?(((\\d|[1-9]\\d|1\\d\\d|' +
            '2[0-4]\\d|25[0-5])\\.(\\d|[1-9]\\d|1\\d\\d|2[0-4]\\d|25' +
            '[0-5])\\.(\\d|[1-9]\\d|1\\d\\d|2[0-4]\\d|25[0-5])\\.' +
            '(\\d|[1-9]\\d|1\\d\\d|2[0-4]\\d|25[0-5]))|((([a-z]|\\d' +
            '|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])|(([a-z]|\\' +
            'd|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])([a-z]|\\d|' +
            '-|\\.|_|~|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])*' +
            '([a-z]|\\d|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])))\\' +
            '.)*(([a-z]|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])|' +
            '(([a-z]|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])([a-z]' +
            '|\\d|-|\\.|_|~|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])' +
            '*([a-z]|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])))\\.?)' +
            '(:\\d*)?)(\\/((([a-z]|\\d|-|\\.|_|~|[\\u00A0-\\uD7FF\\uF900-\\' +
            'uFDCF\\uFDF0-\\uFFEF])|(%[\\da-f]{2})|[!\\$&\'\\(\\)\\*\\+,;=]' +
            '|:|@)+(\\/(([a-z]|\\d|-|\\.|_|~|[\\u00A0-\\uD7FF\\uF900-\\uFDCF' +
            '\\uFDF0-\\uFFEF])|(%[\\da-f]{2})|[!\\$&\'\\(\\)\\*\\+,;=]|:|@)*)' +
            '*)?)?(\\?((([a-z]|\\d|-|\\.|_|~|[\\u00A0-\\uD7FF\\uF900-\\' +
            'uFDCF\\uFDF0-\\uFFEF])|(%[\\da-f]{2})|[!\\$&\'\\(\\)\\*\\+,;=]|' +
            ':|@)|[\\uE000-\\uF8FF]|\\/|\\?)*)?(\\#((([a-z]|\\d|-|\\.|_|~|' +
            '[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])|(%[\\da-f]{2})' +
            '|[!\\$&\'\\(\\)\\*\\+,;=]|:|@)|\\/|\\?)*)?$', 'i');
	return regex.test(urlStr); 
}

function startPreLoader(id) {
	var node = document.getElementById(id);
	if (node) {
		addClass(node, 'sp-preloader-mask');
	}
}

function stopPreLoader(id) {
	var node = document.getElementById(id);
	if (node) {
		removeClass(node, 'sp-preloader-mask');
	}
}