<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="com.liferay.portal.security.auth.AuthTokenUtil"%>
<%
/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<portlet:defineObjects />
<liferay-theme:defineObjects />

<input name="sp_p_auth" type="hidden" value="<%= AuthTokenUtil.getToken(request) %>" id="sp_p_auth"/>
<script src="<%= themeDisplay.getPathJavaScript() %>/editor/ckeditor/ckeditor.js" type="text/javascript"></script>


<script type="text/javascript">

var JSON;
if (!JSON) {
    JSON = {};
}

(function() {
    'use strict';

    function f(n) {
        // Format integers to have at least two digits.
        return n < 10 ? '0' + n : n;
    }

    if (typeof Date.prototype.toJSON !== 'function') {

        Date.prototype.toJSON = function(key) {

            return isFinite(this.valueOf())
                ? this.getUTCFullYear()     + '-' +
                    f(this.getUTCMonth() + 1) + '-' +
                    f(this.getUTCDate())      + 'T' +
                    f(this.getUTCHours())     + ':' +
                    f(this.getUTCMinutes())   + ':' +
                    f(this.getUTCSeconds())   + 'Z'
                : null;
        };

        String.prototype.toJSON      =
            Number.prototype.toJSON  =
            Boolean.prototype.toJSON = function(key) {
                return this.valueOf();
            };
    }

    var cx = /[\u0000\u00ad\u0600-\u0604\u070f\u17b4\u17b5\u200c-\u200f\u2028-\u202f\u2060-\u206f\ufeff\ufff0-\uffff]/g,
        escapable = /[\\\"\x00-\x1f\x7f-\x9f\u00ad\u0600-\u0604\u070f\u17b4\u17b5\u200c-\u200f\u2028-\u202f\u2060-\u206f\ufeff\ufff0-\uffff]/g,
        gap,
        indent,
        meta = {    // table of character substitutions
            '\b': '\\b',
            '\t': '\\t',
            '\n': '\\n',
            '\f': '\\f',
            '\r': '\\r',
            '"' : '\\"',
            '\\': '\\\\'
        },
        rep;


    function quote(string) {

// If the string contains no control characters, no quote characters, and no
// backslash characters, then we can safely slap some quotes around it.
// Otherwise we must also replace the offending characters with safe escape
// sequences.

        escapable.lastIndex = 0;
        return escapable.test(string) ? '"' + string.replace(escapable, function(a) {
            var c = meta[a];
            return typeof c === 'string'
                ? c
                : '\\u' + ('0000' + a.charCodeAt(0).toString(16)).slice(-4);
        }) + '"' : '"' + string + '"';
    }


    function str(key, holder) {

// Produce a string from holder[key].

        var i;
        var          // The loop counter.
            k,          // The member key.
            v,          // The member value.
            length,
            mind = gap,
            partial,
            value = holder[key];

// If the value has a toJSON method, call it to obtain a replacement value.

        if (value && typeof value === 'object' &&
                typeof value.toJSON === 'function') {
            value = value.toJSON(key);
        }

// If we were called with a replacer function, then call the replacer to
// obtain a replacement value.

        if (typeof rep === 'function') {
            value = rep.call(holder, key, value);
        }

// What happens next depends on the value's type.

        switch (typeof value) {
        case 'string':
            return quote(value);

        case 'number':

// JSON numbers must be finite. Encode non-finite numbers as null.

            return isFinite(value) ? String(value) : 'null';

        case 'boolean':
        case 'null':

// If the value is a boolean or null, convert it to a string. Note:
// typeof null does not produce 'null'. The case is included here in
// the remote chance that this gets fixed someday.

            return String(value);

// If the type is 'object', we might be dealing with an object or an array or
// null.

        case 'object':

// Due to a specification blunder in ECMAScript, typeof null is 'object',
// so watch out for that case.

            if (!value) {
                return 'null';
            }

// Make an array to hold the partial results of stringifying this object value.

            gap += indent;
            partial = [];

// Is the value an array?

            if (Object.prototype.toString.apply(value) === '[object Array]') {

// The value is an array. Stringify every element. Use null as a placeholder
// for non-JSON values.

                length = value.length;
                for (i = 0; i < length; i += 1) {
                    partial[i] = str(i, value) || 'null';
                }

// Join all of the elements together, separated with commas, and wrap them in
// brackets.

                v = partial.length === 0
                    ? '[]'
                    : gap
                    ? '[\n' + gap + partial.join(',\n' + gap) + '\n' + mind + ']'
                    : '[' + partial.join(',') + ']';
                gap = mind;
                return v;
            }

// If the replacer is an array, use it to select the members to be stringified.

            if (rep && typeof rep === 'object') {
                length = rep.length;
                for (i = 0; i < length; i += 1) {
                    if (typeof rep[i] === 'string') {
                        k = rep[i];
                        v = str(k, value);
                        if (v) {
                            partial.push(quote(k) + (gap ? ': ' : ':') + v);
                        }
                    }
                }
            } else {

// Otherwise, iterate through all of the keys in the object.

                for (k in value) {
                    if (Object.prototype.hasOwnProperty.call(value, k)) {
                        v = str(k, value);
                        if (v) {
                            partial.push(quote(k) + (gap ? ': ' : ':') + v);
                        }
                    }
                }
            }

// Join all of the member texts together, separated with commas,
// and wrap them in braces.

            v = partial.length === 0
                ? '{}'
                : gap
                ? '{\n' + gap + partial.join(',\n' + gap) + '\n' + mind + '}'
                : '{' + partial.join(',') + '}';
            gap = mind;
            return v;
        }
    }

// If the JSON object does not yet have a stringify method, give it one.

    if (typeof JSON.stringify !== 'function') {
        JSON.stringify = function(value, replacer, space) {

// The stringify method takes a value and an optional replacer, and an optional
// space parameter, and returns a JSON text. The replacer can be a function
// that can replace values, or an array of strings that will select the keys.
// A default replacer method can be provided. Use of the space parameter can
// produce text that is more easily readable.

            var i;
            gap = '';
            indent = '';

// If the space parameter is a number, make an indent string containing that
// many spaces.

            if (typeof space === 'number') {
                for (i = 0; i < space; i += 1) {
                    indent += ' ';
                }

// If the space parameter is a string, it will be used as the indent string.

            } else if (typeof space === 'string') {
                indent = space;
            }

// If there is a replacer, it must be a function or an array.
// Otherwise, throw an error.

            rep = replacer;
            if (replacer && typeof replacer !== 'function' &&
                    (typeof replacer !== 'object' ||
                    typeof replacer.length !== 'number')) {
                throw new Error('JSON.stringify');
            }

// Make a fake root object containing our value under the key of ''.
// Return the result of stringifying the value.

            return str('', {'': value});
        };
    }


// If the JSON object does not yet have a parse method, give it one.

    if (typeof JSON.parse !== 'function') {
        JSON.parse = function(text, reviver) {

// The parse method takes a text and an optional reviver function, and returns
// a JavaScript value if the text is a valid JSON text.

            var j;

            function walk(holder, key) {

// The walk method is used to recursively walk the resulting structure so
// that modifications can be made.

                var k;
                var v;
                var value = holder[key];
                if (value && typeof value === 'object') {
                    for (k in value) {
                        if (Object.prototype.hasOwnProperty.call(value, k)) {
                            v = walk(value, k);
                            if (v !== undefined) {
                                value[k] = v;
                            } else {
                                delete value[k];
                            }
                        }
                    }
                }
                return reviver.call(holder, key, value);
            }


// Parsing happens in four stages. In the first stage, we replace certain
// Unicode characters with escape sequences. JavaScript handles many characters
// incorrectly, either silently deleting them, or treating them as line endings.

            text = String(text);
            cx.lastIndex = 0;
            if (cx.test(text)) {
                text = text.replace(cx, function(a) {
                    return '\\u' +
                        ('0000' + a.charCodeAt(0).toString(16)).slice(-4);
                });
            }

// In the second stage, we run the text against regular expressions that look
// for non-JSON patterns. We are especially concerned with '()' and 'new'
// because they can cause invocation, and '=' because it can cause mutation.
// But just to be safe, we want to reject all unexpected forms.

// We split the second stage into 4 regexp operations in order to work around
// crippling inefficiencies in IE's and Safari's regexp engines. First we
// replace the JSON backslash pairs with '@' (a non-JSON character). Second, we
// replace all simple value tokens with ']' characters. Third, we delete all
// open brackets that follow a colon or comma or that begin the text. Finally,
// we look to see that the remaining characters are only whitespace or ']' or
// ',' or ':' or '{' or '}'. If that is so, then the text is safe for eval.

            if (/^[\],:{}\s]*$/
                    .test(text.replace(/\\(?:["\\\/bfnrt]|u[0-9a-fA-F]{4})/g, '@')
                        .replace(/"[^"\\\n\r]*"|true|false|null|-?\d+(?:\.\d*)?(?:[eE][+\-]?\d+)?/g, ']')
                        .replace(/(?:^|:|,)(?:\s*\[)+/g, ''))) {

// In the third stage we use the eval function to compile the text into a
// JavaScript structure. The '{' operator is subject to a syntactic ambiguity
// in JavaScript: it can begin a block or an object literal. We wrap the text
// in parens to eliminate the ambiguity.

                j = eval('(' + text + ')');

// In the optional fourth stage, we recursively walk the new structure, passing
// each name/value pair to a reviver function for possible transformation.

                return typeof reviver === 'function'
                    ? walk({'': j}, '')
                    : j;
            }

// If the text is not JSON parseable, then a SyntaxError is thrown.

            throw new SyntaxError('JSON.parse');
        };
    }
}());

</script>

<script type="text/javascript">
function addWorkHistoryInfo(category,categoryDetails,type,displayfield){
	addWorkHistoryAjaxCall(category,categoryDetails,type,displayfield);
}

function addWorkHistoryAjaxCall(category, categoryDetails, type, displayfield, request){
	var A=AUI();
	var items = null;
	var reqUrl = '<portlet:resourceURL id="" />';
	var auth = document.getElementById("sp_p_auth").value;
	var currentUrl = encodeURI('<%=themeDisplay.getURLCurrent()%>');
	if((currentUrl.match(/([\<])([^\>]{1,})*([\>])/i) == null)){
		currentUrl = currentUrl;
	}
	if(currentUrl.toLowerCase().indexOf('<script>') == -1){
		currentUrl = currentUrl;
		//console.log("currentUrl 1 " + currentUrl);
	}else{
		var addWH = A.one('#'+category+'_add');
		addWH.addClass('cross');
		showTooltip(category+"_add","Please do not enter any HTML tags");
	}
	if(currentUrl.toLowerCase().indexOf('<style>') == -1){
		currentUrl = currentUrl;
		//console.log("currentUrl 2 " + currentUrl);
	}else{
		var addWH = A.one('#'+category+'_add');
		addWH.addClass('cross');
		showTooltip(category+"_add","Please do not enter any HTML tags");
	}
	if(currentUrl.toLowerCase().indexOf('<u0028>') == -1 || currentUrl.toLowerCase().indexOf('<u0029>') == -1 || currentUrl.toLowerCase().indexOf('<u003C>') == -1 || currentUrl.toLowerCase().indexOf('<u003E>') == -1 || currentUrl.toLowerCase().indexOf('<u0022>') == -1 || currentUrl.toLowerCase().indexOf('<u0022>') == -1){
		currentUrl = currentUrl;
		//console.log("currentUrl 3 " + currentUrl);
	}else{
		var addWH = A.one('#'+category+'_add');
		addWH.addClass('cross');
		showTooltip(category+"_add","Please do not enter any HTML tags");
	}
	A.io.request(reqUrl, {
     cache: false,
     sync: true,
     timeout: 1000,
     dataType: 'json',
     method: 'post',
     data:{
    	 categoryName:category,
    	 categoryDetails:categoryDetails,
    	 type:type,
    	 currentUrl:currentUrl,
    	 displayField:displayfield,
    	 sp_p_auth : auth
     },
     on: {
         success: function() {
        	 items = this.get('responseData');
        	 if(items){
        		 var auth1 = items.status;
        		 if(auth1 == "400"){
        			var addWH = A.one('#'+category+'_add');
        			addWH.addClass('cross');
        			showTooltip(category+"_add","You dont have permissions to perform requested operation");
        		 }else{
        		
        		insertHTMLforAdd(items[0].tag, items[0].category,items[0].instance,displayfield);
                hideAddButton(items[0].category, true);
                renderCalendarFields(items[0].category);
                var textAreaNodes = A.all('.ckeditor-textarea-'+items[0].category);
	   			 textAreaNodes.each(function() {
	   				var currentNode = this;
	   				makeCKEditor(currentNode.attr('id'));
	   			 });
        		}
        	}

         },
         failure: function() {
         }
     }
 });

 return items;
}

function renderCalendarSingleInput(category){
	AUI().ready('aui-datepicker-select', function(A) {
		var calendarNodes = A.all('.text_calendar_' + category);

		calendarNodes.each(function() {
			var currentNode = this;
			var dateValue = currentNode.val();
			var _date = new Date();
			
			if (dateValue == null || dateValue.trim().length < 1) {
				var _dateString = _date.getDate() + "/" + _date.getMonth()  + "/" + _date.getFullYear();
				currentNode.val(_dateString);
			} else {
				_date = GetDate(dateValue);
			}
			var currentYear = new Date().getFullYear();
			var _calendarField = "#" + currentNode.attr("id") + "_cal";
			var datePicker = new A.DatePickerSelect({
				calendar: {
					dates: [ _date ],
					dateFormat: '%d/%m/%Y'
				},
				selected:true,
				boundingBox: _calendarField,
				dateFormat: '%d/%m/%Y',
				yearRange: [currentYear - 90, currentYear + 10],
				on: {
						'calendar:select': function(event) {
							var id = currentNode.attr("id");
	    					var id1 = id+ "_cal";
	    					var elem = A.one("#"+id1);
							var month = parseInt(elem.one('.datepicker-month').get('value'))+1;
	    					var day = elem.one('.datepicker-day').get('value');
	    					var year = elem.one('.datepicker-year').get('value');
	    					var selectedDate = day + '/' + month + '/' + year;
							currentNode.val(selectedDate);
							saveSelectInput(currentNode.attr("id"),'personal_info');
	    				},'change': function(event) {
	    					var id = currentNode.attr("id");
	    					var id1 = id+ "_cal";
	    					var elem = A.one("#"+id1);
							var month = parseInt(elem.one('.datepicker-month').get('value'))+1;
	    					var day = elem.one('.datepicker-day').get('value');
	    					var year = elem.one('.datepicker-year').get('value');
	    					var selectedDate = day + '/' + month + '/' + year;
							currentNode.val(selectedDate);
							saveSelectInput(currentNode.attr("id"),'personal_info');
	    				}
    				}
			   }).render();
		});
	});
}

function renderCalendarFields(category, saveOnSelect) {
	AUI().ready('aui-datepicker-select', function(A) {	
		var calendarNodes = A.all('.text_calendar_' + category);
		calendarNodes.each(function() {
			var currentNode = this;
			var dateValue = trimString(currentNode.val());
			var _date = new Date();
			var currentYear = new Date().getFullYear();
			if (dateValue != null && dateValue != 'Present' && dateValue.length > 0){
				_date = GetDate(dateValue);
			}
			var yearRangeinCal = [currentYear - 90, currentYear+10];
			if(category == "workhistory"){
				yearRangeinCal = [currentYear - 90, currentYear];
			}
			if (dateValue == null || dateValue.length < 1) {
				var _dateString = _date.getDate() + "/" + (_date.getMonth() + 1) + "/" + _date.getFullYear();
				currentNode.val(_dateString);
			}
			var _calendarField = "#" + currentNode.attr("id") + "_cal";
			var datePicker = new A.DatePickerSelect({
				calendar: {
					dates: [ _date ],
					dateFormat: '%d/%m/%Y'					
				},
				selected:true,
				boundingBox: _calendarField,
				dateFormat: '%d/%m/%Y',
				yearRange: yearRangeinCal,
				on: {
						'calendar:select': function(event) {
							var id = currentNode.attr("id");
	    					var id1 = id+ "_cal";
	    					var elem = A.one("#"+id1);
							var month = parseInt(elem.one('.datepicker-month').get('value'))+1;
	    					var day = elem.one('.datepicker-day').get('value');
	    					var year = elem.one('.datepicker-year').get('value');
	    					var selectedDate = day + '/' + month + '/' + year;
							currentNode.val(selectedDate);
		    					if (saveOnSelect) {
		    						saveNetworkInfo(currentNode.attr("id"));
		    					}
	    				},'change': function(event) {
	    					var id = currentNode.attr("id");
	    					var id1 = id+ "_cal";
	    					var elem = A.one("#"+id1);
							var month = parseInt(elem.one('.datepicker-month').get('value'))+1;
	    					var day = elem.one('.datepicker-day').get('value');
	    					var year = elem.one('.datepicker-year').get('value');
	    					var selectedDate = day + '/' + month + '/' + year;
							currentNode.val(selectedDate);
		    					if (saveOnSelect) {
		    						saveNetworkInfo(currentNode.attr("id"));
		    					}
	    					}
    				}
			   }).render();

			if (dateValue.indexOf('Present') != -1) {
				A.one(_calendarField).hide();
			}
			var presentBox = A.one("#" + currentNode.attr("id") + "_presentBox");
			if (presentBox != null) {
				presentBox.on('click', function(event){
					if(this.attr("checked") == true) {
						A.one(_calendarField).hide();
						currentNode.val("Present");
					} else {
						A.one(_calendarField).show();
					}
				});
			}
		});
	});
}

//Remove added instance -- Harini

function removeInput(category, categoryDetails,instance,displayfield){
	var nodeId = category + instance;
	removeInputAjaxCall(category,categoryDetails, nodeId,instance,displayfield);
}

// remove input group by category id - eco
function removeGroupInput(category, categoryDetails,instance,displayfield){
	var nodeId = instance;
	removeInputAjaxCall(category,categoryDetails, nodeId,instance,displayfield);

	removeElement(category + '_edit_' + instance);
	
    //jq("." + category + "_editAlign").show();
    var A = AUI();
    var elem = A.one("." + category + "_editAlign");
    if(elem){
    	elem.setStyle('display','inline');
    }	
}

function removeInputAjaxCall(category, categoryDetails, instance, count, displayfield, request){
	var A=AUI();
	var items = null;
	var type="removeInput";
	var reqUrl = '<portlet:resourceURL id="" />';
	var auth = document.getElementById("sp_p_auth").value;
	var currentUrl = encodeURI('<%=themeDisplay.getURLCurrent()%>');
	if((currentUrl.match(/([\<])([^\>]{1,})*([\>])/i) == null)){
		currentUrl = currentUrl;
	}
	if(currentUrl.toLowerCase().indexOf('<script>') == -1){
		currentUrl = currentUrl;
		//console.log("currentUrl 1 " + currentUrl);
	}else{
		var addWH = A.one('#'+category+'_add');
   	 if(addWH != null){
 			addWH.addClass('cross');
 			showTooltip(category+"_add","Please do not enter any HTML tags");
    	}else{
    		addWH = A.one('#webinfo_input');
    		addWH.addClass('cross');
 			showTooltip(category+"_add","Please do not enter any HTML tags");
    	}
	}
	if(currentUrl.toLowerCase().indexOf('<style>') == -1){
		currentUrl = currentUrl;
		//console.log("currentUrl 2 " + currentUrl);
	}else{
		var addWH = A.one('#'+category+'_add');
   	 if(addWH != null){
 			addWH.addClass('cross');
 			showTooltip(category+"_add","Please do not enter any HTML tags");
    	}else{
    		addWH = A.one('#webinfo_input');
    		addWH.addClass('cross');
 			showTooltip(category+"_add","Please do not enter any HTML tags");
    	}
	}
	if(currentUrl.toLowerCase().indexOf('<u0028>') == -1 || currentUrl.toLowerCase().indexOf('<u0029>') == -1 || currentUrl.toLowerCase().indexOf('<u003C>') == -1 || currentUrl.toLowerCase().indexOf('<u003E>') == -1 || currentUrl.toLowerCase().indexOf('<u0022>') == -1 || currentUrl.toLowerCase().indexOf('<u0022>') == -1){
		currentUrl = currentUrl;
		//console.log("currentUrl 3 " + currentUrl);
	}else{
		var addWH = A.one('#'+category+'_add');
   	 if(addWH != null){
 			addWH.addClass('cross');
 			showTooltip(category+"_add","Please do not enter any HTML tags");
    	}else{
    		addWH = A.one('#webinfo_input');
    		addWH.addClass('cross');
 			showTooltip(category+"_add","Please do not enter any HTML tags");
    	}
	}
	A.io.request(reqUrl, {
     cache: false,
     sync: true,
     timeout: 1000,
     dataType: 'json',
     method: 'post',
     data:{
    	 categoryName:category,
    	 categoryDetails:categoryDetails,
    	 instance:instance,
    	 type:type,
    	 currentUrl:currentUrl,
    	 displayField:displayfield,
    	 sp_p_auth : auth
     },
     on: {
         success: function() {
             
             items = this.get('responseData');
             var status = items.status;
             if(status == "400"){
            	 var addWH = A.one('#'+category+'_add');
            	 if(addWH != null){
	      			addWH.addClass('cross');
	      			showTooltip(category+"_add","You dont have permissions to perform requested operation");
             	}else{
             		addWH = A.one('#webinfo_input');
             		addWH.addClass('cross');
	      			showTooltip(category+"_add","You dont have permissions to perform requested operation");
             	}
    		 }else{
    			 removeElement(category + '_' + count);
	             if (items[0].instanceCount == 0 && items[0].category == 'workhistory') {
	            	 displayWorkHistoryAddForm();
	             } else {
	            	
	            	 showButtonSaveUndo(category,instance);
	            	 hideAddButton(category, false);
           		 }
    		 } 
         },
         failure: function() {
         }
     }
 });

 return items;
}

function displayWorkHistoryAddForm() {
	var A=AUI();
	hideAddButton('workhistory', true);

	var _displayField = A.one('#workhistoryList').val();

	addWorkHistoryInfo('workhistory','work_details','addMultipleInput', _displayField);
}


//save data from multiple instances

function saveDataAjaxCall(type,sData,category,instance,displayfield,request){
	
	var A=AUI();
	var items = null;
	var auth = document.getElementById("sp_p_auth").value;
	var reqUrl = '<portlet:resourceURL id="" />'; 
	
	var currentUrl = encodeURI('<%=themeDisplay.getURLCurrent()%>');
	if((currentUrl.match(/([\<])([^\>]{1,})*([\>])/i) == null)){
		currentUrl = currentUrl;
	}
	if(currentUrl.toLowerCase().indexOf('<script>') == -1){
		currentUrl = currentUrl;
		//console.log("currentUrl 1 " + currentUrl);
	}else{
		errorState(category+'_'+instance,"Please do not enter any HTML tags");
	}
	if(currentUrl.toLowerCase().indexOf('<style>') == -1){
		currentUrl = currentUrl;
		//console.log("currentUrl 2 " + currentUrl);
	}else{
		errorState(category+'_'+instance,"Please do not enter any HTML tags");
	}
	if(currentUrl.toLowerCase().indexOf('<u0028>') == -1 || currentUrl.toLowerCase().indexOf('<u0029>') == -1 || currentUrl.toLowerCase().indexOf('<u003C>') == -1 || currentUrl.toLowerCase().indexOf('<u003E>') == -1 || currentUrl.toLowerCase().indexOf('<u0022>') == -1 || currentUrl.toLowerCase().indexOf('<u0022>') == -1){
		currentUrl = currentUrl;
		//console.log("currentUrl 3 " + currentUrl);
	}else{
		errorState(category+'_'+instance,"Please do not enter any HTML tags");
	}
	
	A.io.request(reqUrl, {
     cache: false,
     sync: true,
     timeout: 1000,
     dataType: 'json',
     method: 'post',
     data:{
    	 type:type,
    	 currentUrl:currentUrl,
    	 sData:sData,
    	 categoryName:category,
    	 instance:instance,
    	 displayField:displayfield,
    	 sp_p_auth : auth
     },
     on: {
		start:function(){
		 hideSaveButton(category);
		//display loading icon
		loadingState(category+'_'+instance);
	},
         success: function() {
             items = this.get('responseData');
             var authMsg =  items.status;
             if(authMsg == "400"){
            	 errorState(category+'_'+instance,"You dont have permissions to perform requested operation");
             }else{
	           	 //destroy instances of ckeditor after save
				 var textAreaNodes = A.all('.ckeditor-textarea-'+category);
				 textAreaNodes.each(function() {
					var currentNode = this;
					var ckId = currentNode.attr('id');
					var ckeditor = CKEDITOR.instances[ckId];
					 if (ckeditor != null) {
						 var idx = ckId.indexOf(instance);
						 if(ckId.substr(idx) == instance){ //check instance to avoid clearing off of other ckeditor on other portlets
							 ckeditor.destroy();
						 }
					 }
				 });
	
	             insertHTMLforSave(items[0].tag,items[0].category,instance);
	
	           	 //hide loading icon
				 clearState(items[0].category);
				 successSaveState(items[0].category, "Save Successful");
				 hideAddButton(items[0].category, false); 
             }	 
         },
         failure: function() {
        	//hide loading icon
			clearState(category);
			//Show error icon
			errorState(category,"Unexpected server error occured.");
         }
     }
 });

 return items;
}

function saveInfo(category,instance,list,displayfield)
{
	var fieldsList = document.getElementById(list).value;
	var arrFields = fieldsList.split(',');
	var shouldSave = true;
	var data = {};
	data['instance'] = instance;
	for(i=0; i < arrFields.length; i++)
	{
		var fieldName = arrFields[i];	

		if(fieldName == ''){
			continue;
		} //skip remaining code block if fieldName is blank
		
		var inputField = document.getElementById(fieldName + '_' + instance);
		
		var fieldVal = '';
		if(inputField){
			var objType = inputField.type;
			if(objType == 'select-one'){
				fieldVal = trimString( inputField.options[inputField.selectedIndex].value );
			}else if(objType == 'select-multiple'){
				//fieldVal = trimString( inputField.options[inputField.selectedIndex].value );
				var opt = inputField.options;
				for ( var j = 0; j < opt.length; j++) {
					if (opt[j].selected){
						if(fieldVal != ''){
							fieldVal += ', ' + trimString(opt[j].value);
						}else{
							fieldVal = trimString( opt[j].value );
						}
					}//end if
				}//end for
			}else if(objType == 'radio'){
				var radioElement = document.getElementsByName(fieldName + '_' + instance);
				if(radioElement.length > 0){
					for (var x = 0; x < radioElement.length; x++) {
						if (radioElement[x].checked) {
							fieldVal = trimString( radioElement[x].value );
				        }
				    }
				}
			}else if(objType == 'textarea'){
				var divId = fieldName + '_' + instance;
				var ckeditor = CKEDITOR.instances[divId];
				if (ckeditor != null) {
					fieldVal = ckeditor.getData();
					inputField.value = fieldVal;
				}else{
					fieldVal = inputField.value;
				}
			}else{//default text
				fieldVal = inputField.value;
			}
			data[fieldName] = fieldVal;
		}
	}//end for arrFields

	var jsn = JSON.stringify(data);
	var startDateField;
	var endDateField;
	for(j=0; j < arrFields.length; j++){

		var fieldName = arrFields[j];
		var inputFieldId = fieldName + '_' + instance;
		var inputField = document.getElementById(inputFieldId);
		
		if(fieldName == "phone_7" && inputField.value.length > 0 && inputField.value.length < 9) {
			errorState(fieldName + '_' + instance, 'The length must not be less than 9.');
			shouldSave = false;
		}else {
			var isValid = validateMultipleFields(inputFieldId);
			if(!isValid){
				shouldSave = false;
			}
		}

		//added mike
		var input = document.getElementById(inputFieldId);
		if( inputFieldId.indexOf('start_date') != -1 ) {
			startDateField = input;
		}
		if( inputFieldId.indexOf('end_date') != -1 ) {
			endDateField = input;
		}
		
		if(input){//validate radiobuttons
			var objType = input.type;
			if(objType == 'radio'){
				var radioElement = document.getElementsByName(fieldName + '_' + instance);
				if(radioElement.length > 0){
					var mandatory = '';
					var radioFieldVal = '';
					for (var x = 0; x < radioElement.length; x++) {
						if (radioElement[x].checked) {
							radioFieldVal = trimString( radioElement[x].value );
				        }
						mandatory = radioElement[x].getAttribute('mandatory');
				    }
					if((mandatory == "true") && (radioFieldVal == '')){
						errorState(fieldName + '_' + instance, 'This field is required.');
						shouldSave = false;
					}
				}
			}
		}//end validate radio

	}//end for arrFields
	// dates validations

	if(startDateField != null && endDateField != null && shouldSave) {
		shouldSave = validateStartEndDateRange(startDateField, endDateField, category);

		if (shouldSave && category == 'workhistory') {
			if (document.getElementById('isOverlapping') != null &&
					document.getElementById('isOverlapping').value == 'true') {
				shouldSave = checkHistoryOverlappingDate(startDateField, endDateField);
			}
		}
	}
	if(shouldSave && (displayfield.indexOf("default_billing_address") != -1)){
		var billingMessage = "Default Billing Address already set. Please select 'No' to save the new Address";
		shouldSave = validateBillingAndShippingAddress("default_billing_address_9",instance,billingMessage);
		if(shouldSave){
			var shippingMessage = "Default Shipping Address already set. Please select 'No' to save the new Address";
			shouldSave = validateBillingAndShippingAddress("default_shipping_address_8",instance,shippingMessage);
		}
	}
	
	if(shouldSave){
		if(category == 'workhistory')
		{
	   		saveDataAjaxCall('saveWorkHistory',jsn,category,instance,displayfield);
	   	}else if(category == 'availability_info'){
	   		saveDataAjaxCall('saveAvailabilityInfo',jsn,category,instance,displayfield);
	   	}else if(category == 'contact_info'){
	   		if (validateContactInfoPhoneAndAddress(arrFields, instance)) {
	   			saveDataAjaxCall('saveContactInfo',jsn,category,instance,displayfield);
	   		}
	   	}else{//dynamic section
	   		saveDataAjaxCall('saveDynamicSectionInfo',jsn,category,instance,displayfield);
	   	}
	}
	
}

function validateBillingAndShippingAddress(adrId,instance,message){
	var billingAdr = document.getElementsByName(adrId+"_"+instance);
	var noOfFields =  document.getElementsByName(adrId);
	var billingAdrValue;
	var fields = noOfFields.length;
	if(billingAdr.length > 0){
		for (var x = 0; x < billingAdr.length; x++) {
			if (billingAdr[x].checked) {
				billingAdrValue = trimString(billingAdr[x].value);
	        }
		}
	}
	if(fields>0){
		for(var b=1;b<=fields;b++){
			var ExistingBillingAdr = document.getElementById(adrId+"_info_"+b);
			if(ExistingBillingAdr != null){
				if((billingAdrValue == "Yes") && (ExistingBillingAdr.innerHTML == billingAdrValue)){
					errorState(adrId+"_"+instance,message);
					return false;
				}else{
					return true;
				}
			}else{
				fields = fields + 1;
			}
		}
	}else{
		return true;
	}
	
}

function validateStartEndDateRange(startDateField, endDateField, category) {
	var valid = true;
	var startDate = GetDate(startDateField.value);
	var endDate;
	var currentTime = new Date();
	var month = currentTime.getMonth() + 1;
	var day = currentTime.getDate();
	var year = currentTime.getFullYear();
	var currentDate = GetDate(day + "/" + month + "/" + year);

	if (endDateField.value == 'Present') {
		endDate = currentDate;
	} else {
		endDate = GetDate(endDateField.value);
	}

	if (startDate > currentDate && category == 'workhistory') {
		errorState(startDateField.getAttribute('id'), 'Start date cannot be future date');
		return false;
	}
	if (endDate > currentDate && category == 'workhistory') {
		errorState(endDateField.getAttribute('id'), 'End date cannot be future date');
		return false;
	}
	if(startDate > endDate ) {
		errorState(endDateField.getAttribute('id'), 'End date should be later than start date');
		return false;
	}

	return valid;
}


//validate contact info phone and address added by eco
function validateContactInfoPhoneAndAddress(inputFields, instance) {
	var valid = true;
	var A = AUI();
	for(j=0; j < inputFields.length; j++){
		var fieldName = inputFields[j];
		var fieldId = fieldName + "_" + instance;
		if (fieldName == 'phone_no') {
			var phoneValue = A.one("#" + fieldId).val();
			phoneValue = trimString( phoneValue );
			if(phoneValue == null || phoneValue.length < 1) 
			{
				
				var extValue = A.one("#ext_" + instance).val();
				if (extValue != null && extValue.length > 0) {
					/*jq('.msg_tooltip').tooltip({
						speed:700
					});*/
					errorState(fieldId, "This field is required");
					valid = false;
				}
			}
		} else if (fieldName == 'address') 
		{
			var addressValue = A.one("#" + fieldId).val();
			
			addressValue = trimString( addressValue );
			
			if(addressValue == null || addressValue.length < 1) 
			{
				var address1Value = A.one("#address1_" + instance).val();
				
				address1Value = trimString( address1Value );
				
				if (address1Value != null && address1Value.length > 0) {
					/*jq('.msg_tooltip').tooltip({
						speed:700
					});*/
					errorState(fieldId, "This field is required");
					valid = false;
				}
			}
		}
	}
	return valid;
}//end for validateContactInfoPhoneAndAddress

//edit details of workhistory -- Harini

function editDetails(category,instance,displayField){
	var type="editWorkHistoryDetails";
	editDetailsAjaxCall(category,instance,type,displayField);
	hideAddButton(category, true);
}

function makeCKEditor(inputId){
	var existingVal = document.getElementById(inputId).value;
	 var ckeditor = CKEDITOR.replace(inputId,
		{
			resize_enabled: false,
			toolbar :
			[
			[ 'TextColor','FontSize','Font','-','Bold', 'Italic', 'Underline', '-', 'Link', 'Unlink' , '-', 'JustifyLeft', 'JustifyCenter','JustifyRight','JustifyBlock','NumberedList','BulletedList' ]
			]
		});
	 if(existingVal != null && existingVal != ''){
		ckeditor.setData(existingVal); 
	 }	
}

//edit details of contact-info

function editContactInfo(category,instance,displayField){
	var type="editContactDetails";
	editDetailsAjaxCall(category,instance,type,displayField)
}

function checkHistoryOverlappingDate(startDateField, endDateField) {
	var A=AUI();
	var _dates = A.all('.work_history_dates');
	var valid = true;

	var startDate = GetDate(startDateField.value);
	var endDate;

	var currentTime = new Date();
	var month = currentTime.getMonth() + 1;
	var day = currentTime.getDate();
	var year = currentTime.getFullYear();
	var currentDate = GetDate(day + "/" + month + "/" + year);

	if (endDateField.value == 'Present') {
		endDate = currentDate;
	} else {
		endDate = GetDate(endDateField.value);
	}
	_dates.each(function() {
		var currentNode = this;
		var _start = currentNode.all('input').item(0).val();
		var _end = currentNode.all('input').item(1).val();
		var _startDate = GetDate(_start);
		var _endDate;
		if (_end == 'Present') {
			_endDate = currentDate;
		} else {
			_endDate = GetDate(_end);
		}
		if (dateWithin(_startDate, _endDate, startDate)) {
			errorState(endDateField.getAttribute('id'), 'Start date overlaps with the other workhistory date');
			valid = false;
		}
		if (dateWithin(_startDate, _endDate, endDate)) {
			errorState(endDateField.getAttribute('id'), 'End date overlaps with the other workhistory date');
			valid = false;
		}
	});
	return valid;
}

function dateWithin(beginDate,endDate,checkDate) {
	if((checkDate <= endDate && checkDate >= beginDate)) {
		return true;
	}
	return false;
}


function editDetailsAjaxCall(category,instance,type,displayField,request){
	var A=AUI();
	var items = null;
	var auth = document.getElementById("sp_p_auth").value;
	var reqUrl = '<portlet:resourceURL id="" />'; //+'&type=' + type+'&categoryName=' + category+'&instance=' + instance+'&displayField=' + displayField;
	
	var currentUrl = encodeURI('<%=themeDisplay.getURLCurrent()%>');
	if((currentUrl.match(/([\<])([^\>]{1,})*([\>])/i) == null)){
		currentUrl = currentUrl;
	}
	if(currentUrl.toLowerCase().indexOf('<script>') == -1){
		currentUrl = currentUrl;
		//console.log("currentUrl 1 " + currentUrl);
	}else{
		var addWH = A.one('#'+category+'_add');
			if(addWH != null){
 			addWH.addClass('cross');
 			showTooltip(category+"_add","Please do not enter any HTML tags");
			}
	}
	if(currentUrl.toLowerCase().indexOf('<style>') == -1){
		currentUrl = currentUrl;
		//console.log("currentUrl 2 " + currentUrl);
	}else{
		var addWH = A.one('#'+category+'_add');
			if(addWH != null){
 			addWH.addClass('cross');
 			showTooltip(category+"_add","Please do not enter any HTML tags");
			}
	}
	if(currentUrl.toLowerCase().indexOf('<u0028>') == -1 || currenturl.toLowerCase().indexOf('<u0029>') == -1 || currenturl.toLowerCase().indexOf('<u003C>') == -1 || currenturl.toLowerCase().indexOf('<u003E>') == -1 || currenturl.toLowerCase().indexOf('<u0022>') == -1 || currenturl.toLowerCase().indexOf('<u0022>') == -1){
		currentUrl = currentUrl;
		//console.log("currentUrl 3 " + currentUrl);
	}else{
		var addWH = A.one('#'+category+'_add');
			if(addWH != null){
 			addWH.addClass('cross');
 			showTooltip(category+"_add","Please do not enter any HTML tags");
			}
	}
	
	A.io.request(reqUrl, {
     cache: false,
     sync: true,
     timeout: 1000,
     dataType: 'json',
     method: 'post',
     data:{
    	 type:type,
    	 currentUrl:currentUrl,
    	 categoryName:category,
    	 instance:instance,
    	 displayField:displayField,
    	 sp_p_auth:auth
     },
     on: {
         success: function() {
             items = this.get('responseData');
             var status = items.status;
             if(status == "400"){
            	 var addWH = A.one('#'+category+'_add');
     			if(addWH != null){
	     			addWH.addClass('cross');
	     			showTooltip(category+"_add","You dont have permissions to perform requested operation");
     			}	
    		 }else{
	             insertHTMLForEdit(items[0].tag,items[0].category,items[0].instance,displayField);
	             renderCalendarFields(items[0].category);
	             var textAreaNodes = A.all('.ckeditor-textarea-'+items[0].category);
	             
				 textAreaNodes.each(function() {
					var currentNode = this;
					makeCKEditor(currentNode.attr('id'));
				 });
    		 }	 
         },
         failure: function() {
         }
     }
 });

 return items;
}

function cancelInfo(category, instance, listId, displayFields){
	cancelInfoAjaxCall(category, instance, displayFields);
}

function cancelInfoAjaxCall(category, instance, displayFields, request){
	var A=AUI();
	var items = null;
	var type = "cancelInfo";
	var reqUrl = '<portlet:resourceURL id="" />';
	var auth = document.getElementById("sp_p_auth").value;
	
	var currentUrl = encodeURI('<%=themeDisplay.getURLCurrent()%>');
	if((currentUrl.match(/([\<])([^\>]{1,})*([\>])/i) == null)){
		currentUrl = currentUrl;
	}
	if(currentUrl.toLowerCase().indexOf('<script>') == -1){
		currentUrl = currentUrl;
		//console.log("currentUrl 1 " + currentUrl);
	}else{
		errorState(category+'_'+instance, "Please do not enter any HTML tags");
	}
	if(currentUrl.toLowerCase().indexOf('<style>') == -1){
		currentUrl = currentUrl;
		//console.log("currentUrl 2 " + currentUrl);
	}else{
		errorState(category+'_'+instance, "Please do not enter any HTML tags");
	}
	if(currentUrl.toLowerCase().indexOf('<u0028>') == -1 || currenturl.toLowerCase().indexOf('<u0029>') == -1 || currenturl.toLowerCase().indexOf('<u003C>') == -1 || currenturl.toLowerCase().indexOf('<u003E>') == -1 || currenturl.toLowerCase().indexOf('<u0022>') == -1 || currenturl.toLowerCase().indexOf('<u0022>') == -1){
		currentUrl = currentUrl;
		//console.log("currentUrl 3 " + currentUrl);
	}else{
		errorState(category+'_'+instance, "Please do not enter any HTML tags");
	}
	
	A.io.request(reqUrl, {
	cache: false,
	sync: true,
	timeout: 1000,
	dataType: 'json',
	method: 'post',
	data:{
		type:type,
		currentUrl:currentUrl,
		categoryName:category,
		displayField:displayFields,
		instance:instance,
		sp_p_auth:auth
	},
	on: {
	success: function() {
		items = this.get('responseData');
		var status = items.status;
		if(status == "400"){
        	if(msg == null){
		        msg = "You dont have permissions to perform requested operation.";
        	}
        	errorState(items[0].category+'_'+items[0].instance, msg);
        }else{
		//destroy instances of ckeditor after save
		 var textAreaNodes = A.all('.ckeditor-textarea-'+category);
		 textAreaNodes.each(function() {
			var currentNode = this;
			var ckId = currentNode.attr('id');
			var ckeditor = CKEDITOR.instances[ckId];
			 if (ckeditor != null) {
				 var idx = ckId.indexOf(instance);
				 if(ckId.substr(idx) == instance){ //check instance to avoid clearing off of other ckeditor on other portlets
					 ckeditor.destroy();
				 }
			 }
		 });
		insertHTMLforSave(items[0].tag,items[0].category,items[0].instance);
		hideSaveButton(items[0].category);
		hideAddButton(items[0].category, false);
        }

	},
	failure: function() {}
	}
	});

	return items;
}

function ajaxSubmitSingleField(fieldToUpdate,fieldValue,categoryName){
	var urlS = '<portlet:resourceURL id="search" />';
	
	var section_name = document.getElementById(fieldToUpdate).getAttribute("section_name");
	var isvalid = false;
	var validation_key = document.getElementById(fieldToUpdate).getAttribute("validation_key");
	if(fieldToUpdate.indexOf('about_input') == -1){
		isvalid = validateInput(fieldToUpdate,"",validation_key);
	}else{
		isvalid = validateInputForScriptTag(fieldToUpdate,"",validation_key);
	}
	var auth = document.getElementById("sp_p_auth").value;
	
	var currentUrl = encodeURI('<%=themeDisplay.getURLCurrent()%>');
	if((currentUrl.match(/([\<])([^\>]{1,})*([\>])/i) == null)){
		currentUrl = currentUrl;
	}
	if(currentUrl.toLowerCase().indexOf('<script>') == -1){
		currentUrl = currentUrl;
		//console.log("currentUrl 1 " + currentUrl);
	}else{
		errorState(section_name, "Please do not enter any HTML tags");
	}
	if(currentUrl.toLowerCase().indexOf('<style>') == -1){
		currentUrl = currentUrl;
		//console.log("currentUrl 2 " + currentUrl);
	}else{
		errorState(section_name, "Please do not enter any HTML tags");
	}
	if(currentUrl.toLowerCase().indexOf('<u0028>') == -1 || currenturl.toLowerCase().indexOf('<u0029>') == -1 || currenturl.toLowerCase().indexOf('<u003C>') == -1 || currenturl.toLowerCase().indexOf('<u003E>') == -1 || currenturl.toLowerCase().indexOf('<u0022>') == -1 || currenturl.toLowerCase().indexOf('<u0022>') == -1){
		currentUrl = currentUrl;
		//console.log("currentUrl 3 " + currentUrl);
	}else{
		errorState(section_name, "Please do not enter any HTML tags");
	}
	
	if(isvalid){
		var A=AUI();
		var items = null;
		var successSave = true;

		var reqUrl = '<portlet:resourceURL id="search" />';

		A.io.request(reqUrl, {
		     cache: false,
		     sync: true,
		     timeout: 1000,
		     dataType: 'json',
		     method: 'post',
		     data:{
		    	 type:'updateSingleNodeField',
		    	 currentUrl:currentUrl,
		    	 name:section_name,
		    	 categoryName:categoryName,
		    	 value:fieldValue,
		    	 sp_p_auth:auth
		     },
		     on: {
				 start:function(){
					clearState(section_name);
					//display loading icon
					loadingState(section_name);
			 	 },
		         success: function() {
		        	items = this.get('responseData');
		            var status = items.status;
		            var msg = items.message;
					var fieldValue = items.fieldValue;
		            if(status == "404"){
		            	if(msg == null){
				           msg = "Unexpected server error occured.";
				        }
		            	errorState(section_name, msg);
		           		successSave = false;
		            }else if(status == "400"){
		            	if(msg == null){
					        msg = "You dont have permissions to perform requested operation.";
		            	}
		            	errorState(section_name, msg);
		            }else{
		            	//hide loading icon
						clearState(section_name);
						//show success icon
						successSaveState(section_name,"Update success.",fieldValue);
						successSave = true;
		            }
		         },
		         failure: function() {
		        	//hide loading icon
					clearState(section_name);
					//Show error icon
					errorState(section_name,"Unexpected server error occured.");
					successSave = false;
		         }
		     }
		 });
		return successSave;
	}else{
		return false;
	}
}

/*auto complete:*/
//Params: input id and type of values (i.e. getLocation or getAreaExpertise)
function CallAutoComplete(id, type){
	var A=AUI();
	var items = null;
	var reqUrl = '<portlet:resourceURL id="" />'; //+'&type=' + type;
	var auth = document.getElementById("sp_p_auth").value;
	
	var currentUrl = encodeURI('<%=themeDisplay.getURLCurrent()%>');
	if((currentUrl.match(/([\<])([^\>]{1,})*([\>])/i) == null)){
		currentUrl = currentUrl;
	}
	if(currentUrl.toLowerCase().indexOf('<script>') == -1){
		currentUrl = currentUrl;
		//console.log("currentUrl 1 " + currentUrl);
	}else{
		errorState(id, "Please do not enter any HTML tags");
	}
	if(currentUrl.toLowerCase().indexOf('<style>') == -1){
		currentUrl = currentUrl;
		//console.log("currentUrl 2 " + currentUrl);
	}else{
		errorState(id, "Please do not enter any HTML tags");
	}
	if(currentUrl.toLowerCase().indexOf('<u0028>') == -1 || currenturl.toLowerCase().indexOf('<u0029>') == -1 || currenturl.toLowerCase().indexOf('<u003C>') == -1 || currenturl.toLowerCase().indexOf('<u003E>') == -1 || currenturl.toLowerCase().indexOf('<u0022>') == -1 || currenturl.toLowerCase().indexOf('<u0022>') == -1){
		currentUrl = currentUrl;
		//console.log("currentUrl 3 " + currentUrl);
	}else{
		errorState(id, "Please do not enter any HTML tags");
	}
	
	A.io.request(reqUrl, {
   cache: false,
   sync: true,
   timeout: 1000,
   dataType: 'json',
   method: 'post',
   data:{
	   type:type,
	   currentUrl:currentUrl,
	   sp_p_auth:auth
   },
   on: {
       success: function() {
          items = this.get('responseData');
          var availableTags = items[0].values.split(',');
          InitAutoComplete([document.getElementById(id)],availableTags);
        },
       failure: function() {
       }
   }
	});

}

function migrateToSocialProfile(){

	var A=AUI();
	var items = null;
	var reqUrl = '<portlet:resourceURL id="" />'; //+'&type=migrateSocialProfile';

	A.io.request(reqUrl, {
	   cache: false,
	   sync: true,
	   timeout: 1000,
	   dataType: 'json',
	   method: 'post',
	   data:{
		   type:'migrateSocialProfile'
	   },
	   on: {
	       success: function() {
	          items = this.get('responseData');

	       },
	       failure: function() {
	       }
	   }
	});
}

/**
 * Submit to server and display the response as html
 */

function addSingleInputAjaxCall(category, catDetail, type, request){
	var A=AUI();
	var items = null;
	var instance = incrementCounter(category);
	var reqUrl = '<portlet:resourceURL id="" />';
	var auth = document.getElementById("sp_p_auth").value;
	
	var currentUrl = encodeURI('<%=themeDisplay.getURLCurrent()%>');
	if((currentUrl.match(/([\<])([^\>]{1,})*([\>])/i) == null)){
		currentUrl = currentUrl;
	}
	if(currentUrl.toLowerCase().indexOf('<script>') == -1){
		currentUrl = currentUrl;
		//console.log("currentUrl 1 " + currentUrl);
	}else{
		var addWH = A.one('#webinfo_input');
		addWH.addClass('cross');
		showTooltip("webinfo_input","Please do not enter any HTML tags");
	}
	if(currentUrl.toLowerCase().indexOf('<style>') == -1){
		currentUrl = currentUrl;
		//console.log("currentUrl 2 " + currentUrl);
	}else{
		var addWH = A.one('#webinfo_input');
		addWH.addClass('cross');
		showTooltip("webinfo_input","Please do not enter any HTML tags");
	}
	if(currentUrl.toLowerCase().indexOf('<u0028>') == -1 || currenturl.toLowerCase().indexOf('<u0029>') == -1 || currenturl.toLowerCase().indexOf('<u003C>') == -1 || currenturl.toLowerCase().indexOf('<u003E>') == -1 || currenturl.toLowerCase().indexOf('<u0022>') == -1 || currenturl.toLowerCase().indexOf('<u0022>') == -1){
		currentUrl = currentUrl;
		//console.log("currentUrl 3 " + currentUrl);
	}else{
		var addWH = A.one('#webinfo_input');
		addWH.addClass('cross');
		showTooltip("webinfo_input","Please do not enter any HTML tags");
	}
	
	A.io.request(reqUrl, {
     cache: false,
     sync: true,
     timeout: 1000,
     dataType: 'json',
     method: 'post',
     data:{
    	 categoryName:category,
    	 categoryDetails:catDetail,
    	 type:type,
    	 currentUrl:currentUrl,
    	 instance:instance,
    	 sp_p_auth:auth
     },
     on: {
         success: function() {
            items = this.get('responseData');
            var status = items.status;
            if(status == "400"){
            	var addWH = A.one('#webinfo_input');
    			addWH.addClass('cross');
    			showTooltip("webinfo_input","You dont have permissions to perform requested operation");
            }else{
            insertHTMLSingleInput(items[0].tag,items[0].category+'_new');
 	   		 var textAreaNodes = A.all('.ckeditor-textarea-'+items[0].category+'-'+items[0].instance);
			 textAreaNodes.each(function() {
				var currentNode = this;
				if(instance == items[0].instance){
					makeCKEditor(category + '_Input_' + instance);
				}

			 });
            renderCalendarFields(instance + "_" + items[0].category, true);
            }
         },
         failure: function() {
         }
     }
 });

 return items;
}


/**
 * Submit and Save network info
 */
 function ajaxSubmitAddSingleField(categoryName, categoryDetails, inputValue, position, inputId, xsl){
		var A=AUI();
		var reqUrl = '<portlet:resourceURL id="ajaxSubmitAddSingleField" />';
		var items = null;
		var auth = document.getElementById("sp_p_auth").value;
		
		var currentUrl = encodeURI('<%=themeDisplay.getURLCurrent()%>');
		if((currentUrl.match(/([\<])([^\>]{1,})*([\>])/i) == null)){
			currentUrl = currentUrl;
		}else{
			errorState(inputId, "Please do not enter any HTML tags");
		}
		if(currentUrl.toLowerCase().indexOf('<script>') == -1){
			currentUrl = currentUrl;
			//console.log("currentUrl 1 " + currentUrl);
		}else{
			errorState(inputId,"Please do not enter any HTML tags");
		}
		if(currentUrl.toLowerCase().indexOf('<style>') == -1){
			currentUrl = currentUrl;
			//console.log("currentUrl 2 " + currentUrl);
		}else{
			errorState(inputId,"Please do not enter any HTML tags");
		}
		if(currentUrl.toLowerCase().indexOf('<u0028>') == -1 || currenturl.toLowerCase().indexOf('<u0029>') == -1 || currenturl.toLowerCase().indexOf('<u003C>') == -1 || currenturl.toLowerCase().indexOf('<u003E>') == -1 || currenturl.toLowerCase().indexOf('<u0022>') == -1 || currenturl.toLowerCase().indexOf('<u0022>') == -1){
			currentUrl = currentUrl;
			//console.log("currentUrl 3 " + currentUrl);
		}else{
			errorState(inputId,"Please do not enter any HTML tags");
		}
		
		A.io.request(reqUrl, {
		     cache: false,
		     sync: true,
		     timeout: 1000,
		     dataType: 'json',
		     method: 'post',
		     data:{
		    	 type:'saveSingleInputField',
		    	 currentUrl:currentUrl,
		    	 categoryName:categoryName,
		    	 categoryDetails:categoryDetails,
		    	 instance:position,
		    	 value:inputValue,
		    	 sp_p_auth:auth
		     },
		     on: {
				 start:function(){
					clearState(inputId);
					//display loading icon
					loadingState(inputId);
			 	 },
		         success: function() {
		        	//hide loading icon
					clearState(inputId);

					items = this.get('responseData');
					var status = items.status;
					if(items == null){
			        	//hide loading icon
						clearState(inputId);

						//Show error icon
						errorState(inputId,"Duplicate network info.");
					} else {
						
			            if(status == "400"){
						    msg = "You dont have permissions to perform requested operation.";
			            	errorState(inputId, msg);
			            }else{
							var message = items[0].message;
		
				            if(message || (message != ""))
				            {
				            	//Show error icon
								errorState(inputId,message);
				            }else
				            {
								if(A.one("#"+inputId)){		            	
					            	var name = A.one("#"+inputId).attr("name");
					            	if (name == 'auicalendar') {
					            		successSaveState(inputId,"Update success.");
					            		return;
					            	}
								}	
				            	var position = A.one("#"+inputId).attr("position");
		
				            	var el = document.getElementById(items[0].category);
								el.innerHTML = items[0].tag;
		
								removeElement('new_' + items[0].category + '_' + position);
		
								//show success icon
								successSaveState(inputId,"Update success.");
				            }
		
							}
					}
		         },
		         failure: function() {
		        	//hide loading icon
					clearState(inputId);

					//Show error icon
					errorState(inputId,"Unexpected server error occured.");
		         }
		     }
		 });
	}
	
 function validatePostalCode(id,instance){
		var A=AUI();
		var items = null;
		var reqUrl = '<portlet:resourceURL id="" />';
		var codeElement = document.getElementById(id);
		var postalCode = codeElement.value;
		var type = "validatePostalCode";
		
		var currentUrl = encodeURI('<%=themeDisplay.getURLCurrent()%>');
		if((currentUrl.match(/([\<])([^\>]{1,})*([\>])/i) == null)){
			currentUrl = currentUrl;
		}else{
			errorState(id, "Please do not enter any HTML tags");
		}
		if(currentUrl.toLowerCase().indexOf('<script>') == -1){
			currentUrl = currentUrl;
			//console.log("currentUrl 1 " + currentUrl);
		}else{
			errorState(id, "Please do not enter any HTML tags");
		}
		if(currentUrl.toLowerCase().indexOf('<style>') == -1){
			currentUrl = currentUrl;
			//console.log("currentUrl 2 " + currentUrl);
		}else{
			errorState(id, "Please do not enter any HTML tags");
		}
		if(currentUrl.toLowerCase().indexOf('<u0028>') == -1 || currenturl.toLowerCase().indexOf('<u0029>') == -1 || currenturl.toLowerCase().indexOf('<u003C>') == -1 || currenturl.toLowerCase().indexOf('<u003E>') == -1 || currenturl.toLowerCase().indexOf('<u0022>') == -1 || currenturl.toLowerCase().indexOf('<u0022>') == -1){
			currentUrl = currentUrl;
			//console.log("currentUrl 3 " + currentUrl);
		}else{
			errorState(id, "Please do not enter any HTML tags");
		}
		
		A.io.request(reqUrl, {
	     cache: false,
	     sync: true,
	     timeout: 1000,
	     dataType: 'json',
	     method: 'post',
	     data:{
	    	 postalCode:postalCode,
	    	 type:type,
	    	 currentUrl:currentUrl,
	    	 instance:instance
	     },
	     on: {
	         success: function() {
	            items = this.get('responseData');
	            var status = items[0].status;
	            if(status == "404"){
			    	msg = "Please enter a valid Postal Code";
			    	errorState(id, msg);
			    }else{
			    	var cityElement = document.getElementById("city_5_"+instance);
			    	cityElement.value = items[0].category;
			    }
	            	
	         },
	         failure: function() {
	         }
	     } 
	 });

}	
 
 function sendMentorRequestMail(inputId){
		var A=AUI();
		
		var reqUrl = '<portlet:resourceURL id="ajaxSubmitAddSingleField" />';
		var items = null;
		
		var currentUrl = encodeURI('<%=themeDisplay.getURLCurrent()%>');
		if((currentUrl.match(/([\<])([^\>]{1,})*([\>])/i) == null)){
			currentUrl = currentUrl;
		}
		if(currentUrl.toLowerCase().indexOf('<script>') == -1){
			currentUrl = currentUrl;
			//console.log("currentUrl 1 " + currentUrl);
		}else{
			errorState(inputId, "Please do not enter any HTML tags");
		}
		if(currentUrl.toLowerCase().indexOf('<style>') == -1){
			currentUrl = currentUrl;
			//console.log("currentUrl 2 " + currentUrl);
		}else{
			errorState(inputId, "Please do not enter any HTML tags");
		}
		if(currentUrl.toLowerCase().indexOf('<u0028>') == -1 || currentUrl.toLowerCase().indexOf('<u0029>') == -1 || currentUrl.toLowerCase().indexOf('<u003C>') == -1 || currentUrl.toLowerCase().indexOf('<u003E>') == -1 || currentUrl.toLowerCase().indexOf('<u0022>') == -1 || currentUrl.toLowerCase().indexOf('<u0022>') == -1){
			currentUrl = currentUrl;
			//console.log("currentUrl 3 " + currentUrl);
		}else{
			errorState(inputId, "Please do not enter any HTML tags");
		}
		
		A.io.request(reqUrl, {
		     cache: false,
		     sync: true,
		     timeout: 1000,
		     dataType: 'json',
		     method: 'post',
		     data:{
		    	 type:'sendMentorRequestMail',
		    	 currentUrl:currentUrl
		     },
		     on: {
		         success: function() {
					items = this.get('responseData');
					
		         },
		         failure: function() {
					//Show error icon
					errorState(inputId,"Unexpected server error occured.");
		         }
		     }
		 });
	}
	
</script>
