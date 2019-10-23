function initialize(page) {
	common();
	if (page == 'create-item')
		initializeCreateItem();
	else if (page == 'create-package')
		initializeCreatePackage();
	else if (page == 'create-discounts')
		initializeCreateDiscounts();
	else if (page == 'settings')
		initializeSettings();
}

function common() {
	AUI().use('aui-node', 'aui-base', 'aui-io-request-deprecated','autocomplete-list','aui-io-request','autocomplete-filters','autocomplete-highlighters', function(A) {
		if(currencyCodesJSON) {
			new A.AutoCompleteList(
		      {
		    	allowBrowserAutocomplete: 'false',
		        inputNode: '.currencyCode',
		        activateFirstItem: 'true',
		        source: currencyCodesJSON,
		        resultTextLocator: 'code',
		        resultHighlighter: 'phraseMatch',
		        resultFilters: 'phraseMatch',
		        render: 'true'
		      }
		    ).render();
		}
	});
}

function initializeCreateItem() {
	AUI().use('aui-node', 'aui-base', 'aui-io-request-deprecated', function(A) {
		handleTaxPriceCalculation(A);
		var itemCreateSuccess = function (respData) {}
		var itemPreProcess = function (obj) { return obj; }
		handleFormSubmission(A, 'createItemForm', 'addItem', 	
				item.spSellingItemId, itemPreProcess, itemCreateSuccess);
	});
}

function initializeCreatePackage() {
	AUI().use('aui-node', 'aui-base', 'aui-io-request-deprecated','liferay-util-window','aui-io-plugin-deprecated', function(A) {
		handleTaxPriceCalculation(A);
		var packageCreateSuccess = function (respData) {}
		var packagePreProcess = function (obj) {
			obj.price_currencyCode = obj.pkg_currencyCode;
			if(obj.orderSequencePrefix && obj.orderSequencePrefix.length > 0)
				obj.pkg_orderSequence = obj.orderSequencePrefix;
			if(obj.orderSequenceSuffx && obj.orderSequenceSuffx.length > 0)
				obj.pkg_orderSequence += (":" + obj.orderSequenceSuffx);
			return obj;
		}
		handleFormSubmission(A, 'createPackageForm', 'addPackage',
				pkg.spSellingPackageId, packagePreProcess, packageCreateSuccess);
		
		try{
			A.one(".addProductsButton").on("click", function(e){
				var popupWidth = window.innerWidth - (window.innerWidth * 0.4);
			    var login_popup = Liferay.Util.Window.getWindow(
			                {
			                    dialog: {
			                        centered: true,
			                        constrain2view: true,
			                          modal: true,
			                        resizable: false,
			                        width: popupWidth
			                    }
			                }).plug(A.Plugin.DialogIframe,
			                     {
			                     autoLoad: true,
			                     iframeCssClass: 'dialog-iframe',
			                     uri:itemsUrl
			                     }).render();
			             		login_popup.show();
			                     login_popup.titleNode.html("Select Items");
			                     
			       try {
			    	   login_popup.on('load', function (e) {
			    		   A.one('.selItems_cancelButton').on('click', function(e) {
					    	   login_popup.close();
					       });
			    	   });
			       } catch (err) {}
			});
		} catch (err){}
		
	});
}


function initializeCreateDiscounts() {
	AUI().use('aui-node', 'aui-base', 'aui-io-request-deprecated', function(A) {
		var discountCreateSuccess = function (respData) {}
		var discountPreProcess = function (obj) { return obj; }
		handleFormSubmission(A, 'createDiscountForm', 'addDiscount', 	
				discount.spDiscountId, discountPreProcess, discountCreateSuccess);
		// show / hide promoCode textbox
		var hasPromoCB = A.one("#" + namespace + 'discount_hasPromoCodeCheckbox');
		hasPromoCB.on('change', function(e) {
			var couponCodeNode = A.one("#" + namespace +  'discount_couponCode');
			var temp = couponCodeNode.ancestor('.form-row-one');
			if (this.attr('checked') == true)
				temp.removeClass('hidden');
			else {
				temp.addClass('hidden');
				couponCodeNode.val('');
			}
		});
		
		A.one("#" + namespace + 'discount_packageId').on('change', function(e){
			var value = A.one("#" + namespace + 'discount_packageId').val();
			var listTitle = A.one('.discount-title');
			var discContainer = A.one('.discount-list');
			var sample = A.one('#sample-disc-row');
			discContainer.empty();
			listTitle.addClass('hidden');
			A.io.request(resourceURL, {
				dataType : 'json',
				method : 'POST',
				data : {
					action: 'getPackageDiscounts',
					id: value
				},
				on : {
					success : function() {
						try {
							var discArray = JSON.parse(this.get("responseData").object);
							if (discArray.length > 0)
								listTitle.removeClass('hidden');
							for (i=0 ; i<discArray.length ; i++) {
								var discObj = discArray[i];
								var newRow = sample.clone();
								newRow.appendTo(discContainer);
								newRow.removeClass('hidden');
								newRow.one('.disc-title').text(discObj.title);
								//TODO format dates
								newRow.one('.disc-dates').text(new Date(discObj.startDate) + "-" + new Date(discObj.endDate));
								newRow.one('.disc-quantities').text(discObj.minQuantity + " - " +discObj.maxQuantity);
								newRow.one('.disc-couponcodes').text(discObj.couponCode);
								if (discObj.percent)
									newRow.one('.disc-value').text(discObj.value + "%");
								else 
									newRow.one('.disc-value').text(discObj.value + "%");
							}
						} catch (ee) {console.log(ee);}
					}
				}
			});
			
		});
	});
	
	
}


function initializeSettings() {
	// add Tax
	AUI().use('aui-node', 'aui-base', 'aui-io-request-deprecated', function(A) {
		var taxCreateSuccess = function (respData) {}
		var taxPreProcess = function (obj) { return obj; }
		handleFormSubmission(A, 'addTaxForm', 'addTax',
				tax.spTaxId, taxPreProcess, taxCreateSuccess);
	});
	
	//
}

// Common

function handleFormSubmission(A, formName, action, id, preProcess, successCallbackFunction) {
	A.one('.form .submit').on('click', function(e) {
		//validations
		var validator = eval('Liferay.Form._INSTANCES.' + namespace + formName + '.formValidator');
		validator.validate();
		if (validator.hasErrors()) {
			validator.focusInvalidField();
			return;
		}
		var obj = {};
		startPreLoader('form');
		
		// remove namespace and send as part of request
		var ele = A.all(".form textarea,select,input");
		var len = namespace.length;
		ele.each(function(){
			var name = this.get("name");
			name = name.substring(len);
			var val = this.val();
			if(val != null)
				obj[name] = val;
		});
		clearErrorMessage();
		obj['action'] = action;
		if (id)
			obj['id'] = id;
		if (preProcess)
			obj = preProcess(obj);
		A.io.request(resourceURL, {
			dataType : 'json',
			method : 'POST',
			data : obj,
			on : {
				success : function() {
					stopPreLoader('form');
					var success = true;
					try {
						if (this.get("responseData").status == 'success') {
							showSuccessMessage();
							if (successCallbackFunction)
								successCallbackFunction(this.get("responseData"));
						} else {
							showFailedMessage(this.get("responseData").errorMsg);
						}
					} catch (e) {
						showFailedMessage(e);
					}
				},
				failure : function() {
					showFailedMessage('Error occured while saving information. Please contact development team');
					stopPreLoader('form');
				}
			}
		});
	});
}

var getCurrencyData = function(A, currencyCodeNode, taxNameNode, taxValueNode) {
	if (!currencyCodeNode)
		return;
	try {
		taxNameNode.val('');
		taxValueNode.val('');
		A.io.request(resourceURL, {
			dataType : 'json',
			method : 'POST',
			data : {
				action: 'getTax',
				currencyCode : currencyCodeNode.val()
			},
			on : {
				success : function() {
					try {
						var object = JSON.parse(this.get("responseData").object);
						if(object == null) {
							alert('Tax not configured for this currency! Please use Settings tab to add tax configuration');
						} else {
							taxNameNode.val(object.taxName);
							taxValueNode.val(object.taxValue);
						} 
					} catch (err) {console.log(err);}
				}
			}
		});
	} catch (err) {
		console.log('error while getting currency info');
	}
};

function handleTaxPriceCalculation(A) {
	// total price
	var basePriceNode = A.one('#' + namespace + 'price_basePrice');
	var taxValueNode = A.one('#' + namespace + 'price_taxValue');
	var taxNameNode = A.one('#' + namespace + 'price_taxName');
	var currencyCodeNode = A.one('.currencyCode');
	var recalculateTax = function(e) {
		if(taxValueNode.val() && taxValueNode.val() > 0) {
			var totalPrice = +basePriceNode.val() + +(basePriceNode.val() * taxValueNode.val() / 100);
		} else {
			totalPrice = basePriceNode.val();
		}
		totalPriceNode = A.one('#' + namespace + 'price_totalPrice');
		totalPriceNode.val(totalPrice);
		totalPriceNode = A.one('#' + namespace + 'totalPrice');
		totalPriceNode.val(totalPrice);
	};
	basePriceNode.on('change', recalculateTax);
	taxValueNode.on('change', recalculateTax);
	var getCurrencyInfoNRecalc = function(e) {
		getCurrencyData(A, currencyCodeNode, taxNameNode, taxValueNode);
		recalculateTax();
	};
	currencyCodeNode.on('change', getCurrencyInfoNRecalc);
}

function showSuccessMessage() {
	document.getElementById("successMsg").style.display = "block";
	window.setTimeout(function() {
		document.getElementById("successMsg").style.display = "none";
		window.location.href = homeLocation;
	}, 2000);
}

function showFailedMessage(msg) {
	var errorNode = document.getElementById("errorMsg");
	errorNode.innerHTML = " " + msg;
	errorNode.style.display="block";
}

function clearErrorMessage() {
	var errorNode = document.getElementById("errorMsg");
	errorNode.innerHTML = "";
	errorNode.style.display="none";
}

AUI().ready(function(A) {
	var menuitems = A.all(".left-main-menu li[menu-item]");
	var selected = false;
	try {
	menuitems.each(function(menuitem) {
		if(document.location.href.indexOf(menuitem.getAttribute('menu-item')) > 0) {
			menuitem.addClass('selected');
			selected = true;
		}
	});
	if(!selected) {
		A.one(".left-main-menu li[menu-item='package']").addClass('selected');
	}
	A.all(".left-main-menu > li > a").on('click', function(e) {
		if (!e.target.hasClass('active')) {
			var subMenu = e.target.next("ul");
			if (!subMenu)
				return;
			subMenu.setStyle("display", "block");
			e.target.addClass("active");
		} else {
			e.target.removeClass('active');
			e.target.next("ul").setStyle("display", "none");
		}
	});}catch(err){}
});





/// was working on close popup on select items




