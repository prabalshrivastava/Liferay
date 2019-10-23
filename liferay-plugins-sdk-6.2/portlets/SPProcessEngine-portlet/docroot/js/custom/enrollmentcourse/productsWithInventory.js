var ProductsWithInventoryUtil = (function() {
	var A = AUI();
	var config;
	
	var _init = function (_config) {
		config = _config;
		_disableScreen(config.disabled);
	};
	
	var _disableScreen = function (_disabled) {
		if (_disabled != undefined && _disabled==true) {
			A.all("input,select,button,textarea").each(function(node){
				node.set("disabled",_disabled);
			});
		}
	}
	
	var _validateInventory = function(entityClassId, entityId, qty, callBack) {
	    var wsUrl = '/api/jsonws/SPShopping-portlet.spshopping/has-enough-inventory';
	        wsUrl += '/class-name-id/' + entityClassId;
	        wsUrl += '/class-pk/' + entityId;
	        wsUrl += '/inventory-needed/' + qty;
	        console.log('ProductsWithInventoryUtil validate url: '+wsUrl);
	    _doGet(wsUrl, callBack);
	}

	var _doGet = function (url, callback) {
	    var xhr = new XMLHttpRequest();
	    xhr.open("GET", url, true);
	    xhr.onload = function () {
	      if (callback) {
	          callback(JSON.parse(xhr.responseText));
	      }
	    };
	    xhr.send();
	};
	
	var _displayMessage = function (msg,titleMsg,callBack, w, h) {
		AUI().use('aui-node','aui-base','liferay-util-window',function(A){
			titleMsg = titleMsg ? titleMsg : "Message";
			var dialog = Liferay.Util.Window.getWindow({
						title : titleMsg,	
						dialog: {
						bodyContent : msg, centered : true, cache: false,
						destroyOnClose: true, destroyOnHide: true, height : 280,
						width : (w) ? w : 400, modal : true, constrain2view : true,
						toolbars:{ footer:[{label:'Ok', 
							on: { click: function() { 
									if (callBack) { 
										if (callBack instanceof Function) {
											callBack(dialog);
										} else {
											window.location.href= callBack;
										}
									} else { 
										dialog.hide(); 
									}
								}}}
							]
						}
					}}).render();
		});
	};
	
	var _publicMethods = {
		init: _init,
		disableScreen: _disableScreen,
		validateInventory: _validateInventory,
		displayMessage : _displayMessage
	};
	
	return _publicMethods;
})();