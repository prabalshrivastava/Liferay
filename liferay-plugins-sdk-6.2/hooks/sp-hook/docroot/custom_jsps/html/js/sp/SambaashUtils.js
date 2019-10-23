'use strict';

const SambaashUtils = function SambaashUtils() {
    var isObject = function isObject (obj) {
        return obj === Object(obj);
    };
	
	var _newNameSpace = function _newNameSpace(_ns) {
	    var packages = _ns.split(".");
	    var parent = window;

	    for (var i = 0; i < packages.length; i++) {
	        var pkg = packages[i];
	        if (typeof parent[pkg] === "undefined") {
	            parent[pkg] = {};
	        }
	        parent = parent[pkg];
	    }
	    return parent;
	}
	
    var _ajaxCall = function _ajaxCall(url, method, data, successHandler, failHandler, headers) {
        if (Formio.platformAuth) {
            url += (!(url.indexOf('?') !== -1) ? '?' : '&') + "p_auth=" + Formio.platformAuth;
        }
        AUI().use('aui-base','aui-io-request-deprecated',function(A){
            A.io.request(url,{
                dataType : 'json', method : method, headers: headers,
                data : data,
                on : {
                    success : successHandler,
                    failure : failHandler || function() {
                        console.log("Error in the ajax call.");
                    }
                }
            });             
        });
    }
    var _resourceActionCall = function _resourceActionCall(ajaxUrl, action, method, namespace, data, successHandler, failHandler) {
    	_resourceWithParamsActionCall(ajaxUrl, action, null, method, namespace, data, successHandler, failHandler);
    }
    
    var _resourceWithParamsActionCall = function _resourceWithParamsActionCall(ajaxUrl, action, resourceParam, method, namespace, data, successHandler, failHandler) {
        let _data = resourceParam || {};
        _data[namespace + 'action'] = action;
        if (data) {
            _data[namespace + 'data'] = isObject(data) ? JSON.stringify(data) : data;              
        }
        _ajaxCall(ajaxUrl, method, _data, successHandler, failHandler);
    }

    var _displayMessage = function displayMessage(type, message, duration) {
    	var alert_div = document.getElementById("alert_msg");
    	alert_div.innerHTML = message;
    	alert_div.className = "";
    	alert_div.classList.add("alert-" + type);
    	alert_div.classList.add("alert");
    	alert_div.style.display = "block";
    	setTimeout(function() {
    		alert_div.style.display = "none";
    	}, duration);
    }
	
    var _jsonPathToValue = function jsonPathToValue(jsonData, path) {
        if (!(jsonData instanceof Object) || typeof (path) === "undefined") {
            throw "Not valid argument:jsonData:" + jsonData + ", path:" + path;
        }
        path = path.replace(/\[(\w+)\]/g, '.$1'); // convert indexes to properties
        path = path.replace(/^\./, ''); // strip a leading dot
        var pathArray = path.split('.');
        for (var i = 0, n = pathArray.length; i < n; ++i) {
            var key = pathArray[i];
            if (key in jsonData) {
                if (jsonData[key] !== null) {
                    jsonData = jsonData[key];
                } else {
                    return null;
                }
            } else {
                return key;
            }
        }
        return jsonData;
    } 
    
    var _resolveValue = function _resolveValue(referenceData, value) {
        var compiled = _.template(value);
        return compiled(referenceData);
    }
    
    var _today = function _today() {
    	var today = new Date();
    	var dd = today.getDate();
    	var mm = today.getMonth()+1; //January is 0!
    	var yyyy = today.getFullYear();

    	if(dd<10) {
    	    dd = '0'+dd;
    	} 

    	if(mm<10) {
    	    mm = '0'+mm;
    	} 

    	return mm + '/' + dd + '/' + yyyy;
    }
    var _todayFormat = function _todayFormat() {
    	var today = new Date();
    	var dd = today.getDate();
    	var mm = today.getMonth()+1; //January is 0!
    	var yyyy = today.getFullYear();

    	if(dd<10) {
    	    dd = '0'+dd;
    	} 

    	if(mm<10) {
    	    mm = '0'+mm;
    	} 

    	return dd + '/' + mm + '/' + yyyy;
    }
    
    var _validateNRIC = function (str) {
        if (str.length != 9) 
            return false;

        str = str.toUpperCase();

        var i, 
            icArray = [];
        for(i = 0; i < 9; i++) {
            icArray[i] = str.charAt(i);
        }

        icArray[1] = parseInt(icArray[1], 10) * 2;
        icArray[2] = parseInt(icArray[2], 10) * 7;
        icArray[3] = parseInt(icArray[3], 10) * 6;
        icArray[4] = parseInt(icArray[4], 10) * 5;
        icArray[5] = parseInt(icArray[5], 10) * 4;
        icArray[6] = parseInt(icArray[6], 10) * 3;
        icArray[7] = parseInt(icArray[7], 10) * 2;

        var weight = 0;
        for(i = 1; i < 8; i++) {
            weight += icArray[i];
        }

        var offset = (icArray[0] == "T" || icArray[0] == "G") ? 4:0;
        var temp = (offset + weight) % 11;

        var st = ["J","Z","I","H","G","F","E","D","C","B","A"];
        var fg = ["X","W","U","T","R","Q","P","N","M","L","K"];

        var theAlpha;
        if (icArray[0] == "S" || icArray[0] == "T") { theAlpha = st[temp]; }
        else if (icArray[0] == "F" || icArray[0] == "G") { theAlpha = fg[temp]; }

        return (icArray[8] === theAlpha);
    }
    
    function _loadLink(pageUrl, newTab) {
    	if (newTab) {
    		window.open(pageUrl);
    	} else {
    		window.location.replace(pageUrl);
    	}
    }

    var _applyContentJsonPatch = function _applyContentJsonPatch(scopeGroupId, model, storageId, jsonPatch, callback) {
    	Liferay.Service(
		  '/SPMicroservice-portlet.spmicroservice/update-content-json',
		  {
		    scopeGroupId: scopeGroupId,
		    modelName: model,
		    storageId: storageId,
		    patchJsonString: isObject(jsonPatch) ? JSON.stringify(jsonPatch) : jsonPatch
		  },
		  function(response) {
		    console.log("applyContentJsonPatch response", response);
		    if (callback) {
		    	callback(response);
		    }
		  }
		);
    }
    
    // param is document selector
    // If is from AUI Node, pass the _node property
    var _getMultiSelectValues = function _getMultiSelectValues(select) {
		var result = [];
		var options = select && select.options;
		var opt;
		for (var i=0, iLen=options.length; i<iLen; i++) {
			opt = options[i];
			if (opt.selected) {
				result.push(opt.value);
			}
		}
		return result.join();
	}
    
    var _sortStringArray = function _sortStringArray(arr) {
    	return arr.sort((a, b) => a.localeCompare(b, undefined, {sensitivity: 'base'}));
    }
    
    var getRandomInt = function getRandomInt(max) {
    	  return Math.floor(Math.random() * Math.floor(max));
	}
    
	return {
		namespace : _newNameSpace,
		resourceAction: _resourceActionCall,
		resourceActionWithParamsActionCall: _resourceWithParamsActionCall,
		displayMessage: _displayMessage,
		resolveValue: _resolveValue,
		ajax : _ajaxCall,
		today: _today,
		todayFormat:_todayFormat,
		validateNRIC : _validateNRIC,
		loadLink : _loadLink,
		isObject : isObject,
		applyContentJsonPatch: _applyContentJsonPatch,
		getMultiSelectValues: _getMultiSelectValues,
		sortStringArray: _sortStringArray,
		getRandomInt: getRandomInt
	}
}();

