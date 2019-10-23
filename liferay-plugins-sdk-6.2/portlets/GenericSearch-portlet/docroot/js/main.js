var ajaxUrl;
var pageNo = 0;
var dontSendRequest = false;
var filterTagColorMapVar;
var sliderUpdateFlag = false;
// Below two params, usrStartIndex and processesdUserIds applicable only 
//if generic search configured with user profile with some process engine data
var usrStartIndex = 0;
var processesdUserIds = 0;
//var orgItems = null;
function initializeFilters(A, ajax, filterTagColorMap) {
	filterTagColorMapVar =  filterTagColorMap;
	ajaxUrl = ajax;
	// on click of filters
	try {A.all('.filter-node').on('click', function(ev){
		onclickFilterNode(ev,filterTagColorMap);
	});}catch(ee){}
	
	// sorting	
	try {A.one('#generic-search-sortby').on('change', function(node) {
			forceSendRequest(A);
		});}catch(ee){}
	// clear filters	
	try {A.one("#generic-search-clear").on('click', function() {
			clearFilters(A);
			try {
			A.one('#user-text-search').val('');
			} catch (err) {}
			forceSendRequest(A);
		});}catch(ee){}
	// text search	
	try {
			A.one("#user-text-search").on('key', function() {
				sendTextSearch(A);
				},'down:13');
			A.one(".gs-text-search-icon").on('click', function() {
				sendTextSearch(A);
				});
		} catch(err) {}
	
	//orgItems = A.all('.gsf-countries .gsf-section-item');
	initializeSlider(A);
	clearFilters(A);

	if (initialSearchVocabulary && initialSearchCategory && initialSearchCategory != "-1") {
		var selectedCat = A.one('[data-gsf-type-key="assetCategoryIds"][data-gsf-type="'+initialSearchVocabulary+'"][data-gsf-value="'+initialSearchCategory+'"]');
		selectedCat.simulate('click');
	}	
	
	forceSendRequest(A);
	
	A.on('scroll', function(){
		try {
			var scrollY = window.scrollY //Modern Way (Chrome, Firefox)
			 || document.documentElement.scrollTop; // (IE)		
			var container=A.one('.generic-search-results-wrapper').getDOMNode();
			if(A.one("footer")){
				if (scrollY + A.one("footer").getDOMNode().offsetTop > container.scrollHeight) {
					fireRequest(A, false);
				}
			}else{
				if (scrollY + A.one(".footerDiv").getDOMNode().offsetTop > container.scrollHeight) {
					fireRequest(A, false);
				}
			}	
		} catch(ee) {console.log(ee);}
		});
}

function onclickFilterNode(ev,filterTagColorMap){
	var tagsContainer = A.one('.genericTags');
	var textSearchContainer = A.one('.genericTags ul');
	var getCloseTagId = function(filterNode){
		var filterId = filterNode.getAttribute("data-gsf-filter-id");
    	var closeId = 'filter-node-search-close-'+ filterId + "-" + filterNode.val().replace(new RegExp(" ", 'g'), "");
    	return closeId;
	}
    var initTextSearchEntry = function(filterNode) {
    	var searchText = filterNode.ancestor('label').text().trim();
    	var filterId = filterNode.getData("gsf-filter-id");
    	var closeId = getCloseTagId(filterNode);
    	var liCustomStyle = '';
    	if (filterTagColorMap.hasOwnProperty(''+filterNode.val())) {
    		liCustomStyle = 'style="background-color: '+filterTagColorMap[''+filterNode.val()]+' !important;"';
    	}
    	textSearchContainer.append('<li '+liCustomStyle+'>'+searchText+'<a href="#" class="closeTag" id="'+closeId+'"><img src="/GenericSearch-portlet/images/cancel.svg"/></a></li>');
    	var closeTag = A.one('#'+closeId);
    	closeTag.setData("gsf-filter-id",filterId);
    	closeTag.setData("gsf-value",filterNode.val());
    	closeTag.on('click', function(e) {
    		var filterNode = getFilterNode(this);
    		onClickClosedTag(filterNode);
    		//this.ancestor().remove();
    	});
    	tagsContainer.show();
    };
    var onClickClosedTag = function(filterNode){
		filterNode.set('checked',false)
	    filterNode.ancestor('.gsf-section-item').removeClass('active-item');
		var filterId = filterNode.getData("gsf-filter-id");
    	var closeId = A.one('#' + getCloseTagId(filterNode));
    	if(closeId){
    		closeId.ancestor().remove();
    	}
    	if (textSearchContainer.all("li").size() == 0) {
			//textSearchContainer.remove("*");
			tagsContainer.hide();
		}
		forceSendRequest(A);
    }
	// removing this if condition makes all single selects to behave as multi select.
	if (ev.target.get('nodeName') === 'A') {
		ev.target.ancestor('.gsf-section').all('.active-item').removeClass('active-item');
	}
	ev.target.ancestor('.gsf-section-item').toggleClass('active-item');
	if (textSearchContainer) {
		if (ev.target.attr('checked')) {
			initTextSearchEntry(ev.target);
			forceSendRequest(A);	
		} else{
			onClickClosedTag(ev.target);
		}			
	} else {
		forceSendRequest(A);			
	}

}

function getFilterNode(cn){
	var sq = ".gsf-section-item .filter-node[data-gsf-filter-id=FV1][data-gsf-value=FV2]";
	sq = sq.replace("FV1",cn.getData("gsf-filter-id"));
	sq = sq.replace("FV2",cn.getData("gsf-value"));
	var filterNode = A.one(sq);
	return filterNode;
}

function initializeSlider(A) {
	try {
		var slider = A.one('#slider');
		if (!slider) {
			return;
		}
		var step = 0.5;
		var sliderInput = slider.one('.gsf-rating-item input').getAttribute('data-gsf-value').split(',');
		var start = parseInt(sliderInput[0]);
		var end = parseInt(sliderInput[1]);
		if (sliderInput[2]){
			step = parseInt(sliderInput[2]);
		}
		
			
		
		slider.ancestor('.gsf-section').addClass('active-item');
		
		noUiSlider.create(slider.getDOMNode(), {
			start: [start, end],
			behaviour: 'drag',
			step : step,
			connect: true,
			range: {
				'min': start,
				'max': end
			}
		});
		
		// setting the default values for dob
		var values = [parseInt(sliderInput[0]), parseInt(sliderInput[1]), parseInt(sliderInput[0]), parseInt(sliderInput[1]), 0];

		if (sliderInput[3]){
			values[4]=parseInt(sliderInput[3]);
		}else{
			values[4]=0;
		}
		
		var hiddenField = A.one('#slider .filter-node');
		
		hiddenField.setAttribute('data-gsf-value', values);
		
		window.setTimeout(function (){
			var lowerValueNode = A.one('#slider .noUi-handle-lower');
			var upperValueNode = A.one('#slider .noUi-handle-upper');
			var snapValues = [lowerValueNode, upperValueNode];
			
			
			lowerValueNode.html(start);
			upperValueNode.html(end);
			slider.getDOMNode().noUiSlider.on('update', function( values, handle ) {
				var val = parseFloat(values[handle]).toString()
				snapValues[handle].html(val);
				hiddenField.val(values);
				values[2]=parseInt(sliderInput[0]);
				values[3]=parseInt(sliderInput[1]);
				if (sliderInput[3]){
					values[4]=parseInt(sliderInput[3]);
				}else{
					values[4]=0;
				}
				
				var hiddenFieldValuesStr = hiddenField.getAttribute('data-gsf-value');
				var valuesStr = values.toString();
				if (replaceAll(hiddenFieldValuesStr,".00","") != replaceAll(valuesStr,".00","")){
					sliderUpdateFlag = true;
				}
				
				hiddenField.setAttribute('data-gsf-value', values);
			});
			slider.getDOMNode().noUiSlider.on('set', function( values, handle ) {
				if(sliderUpdateFlag){
					forceSendRequest(A);
				}
			});
		}, 1000);
	} catch (e) {
	}
}

function replaceAll(originalString, find, replace) {
	  return originalString.replace(new RegExp(find, 'g'), replace);
}

function exportResults(A, auth, loaderInstance) {
	if (A.all('.generic-search-results .generic-search-single-result').size() == 0) {
		//todo show error;
		return;
	}
	var dataObj = A.JSON.stringify(createParamsObj(A));
	var url = Liferay.PortletURL.createResourceURL();
	url.setResourceId('id');
	url.setPortletId('genericsearch_WAR_GenericSearchportlet');
	url.setParameter('sp_p_auth', auth);
	url.setParameter('action', 'exportResults');
	//startPreLoader('generic-search-wrapper');
	
	var xhr = new XMLHttpRequest();
	xhr.open('POST', url.toString(), true);
	xhr.responseType = 'blob';
	xhr.onload = function () {
	    if (this.status === 200) {
	        var filename = "";
	        var disposition = xhr.getResponseHeader('Content-Disposition');
	        if (disposition && disposition.indexOf('attachment') !== -1) {
	            var filenameRegex = /filename[^;=\n]*=((['"]).*?\2|[^;\n]*)/;
	            var matches = filenameRegex.exec(disposition);
	            if (matches != null && matches[1]) 
	            	filename = matches[1].replace(/['"]/g, '');
	        }
	        var type = xhr.getResponseHeader('Content-Type');

	        var blob = new Blob([this.response], { type: type });
	        var status = -1;
	        if (blob.size > 0) {
		        if (typeof window.navigator.msSaveBlob !== 'undefined') {
		            // IE workaround for "HTML7007: One or more blob URLs were revoked by closing the blob for which they were created. These URLs will no longer resolve as the data backing the URL has been freed."
		            window.navigator.msSaveBlob(blob, filename);
		        } else {
		            var URL = window.URL || window.webkitURL;
		            var downloadUrl = URL.createObjectURL(blob);
	
		            if (filename) {
		                // use HTML5 a[download] attribute to specify filename
		                var a = document.createElement("a");
		                // safari doesn't support this yet
		                if (typeof a.download === 'undefined') {
		                    window.location = downloadUrl;
		                } else {
		                    a.href = downloadUrl;
		                    a.download = filename;
		                    document.body.appendChild(a);
		                    a.click();
		                }
		            } else {
		                window.location = downloadUrl;
		            }
		            setTimeout(function () { URL.revokeObjectURL(downloadUrl); }, 100); // cleanup
		        }
		        status = 1;
	        }
	        setTimeout(function () { loaderInstance.stop(status); }, 100);
	    } else {
	    	alert(errorGenReport);
	    	loaderInstance.stop(-1);
	    }
	   // stopPreLoader('generic-search-wrapper');
	};
	xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
	var postData = "searchItems=" + dataObj;
	/*for (var key in dataObj) {
		postData = postData + key + "=" + dataObj[key] + "&";
	}*/
	xhr.send(postData);
}


function sendTextSearch(A) {
	if (clearFiltersOnTextSearch)	
		clearFilters(A);
	forceSendRequest(A);
}

function sendDateSearch(A) {
	forceSendRequest(A);
	//fireRequest(A, true);
}

function clearFilters(A) {
	try {
		A.all('.filter-node').set('checked', false)
		A.all('.gsf-section-item').removeClass('active-item');
		A.one('.genericTags ul').empty();
		A.one('.genericTags').hide();
		handleOrderIngForAll(A);
	} catch (e) {}
}
function handleOrderIngForAll(A){
	var scList = A.all('.gsf-section-searchable-container');
	if (scList) {
		scList.each(function(scNode){
			handleOrdering(A, scNode);
		});
	}
}
// also used in filter.jsp
function handleOrdering(A,scNode) {
	if(!scNode){
		return;
	}
	var i, checked = document.createDocumentFragment(),
    unchecked = document.createDocumentFragment();
	var sitems = scNode.all(".gsf-section-item");
	for (i = 0; i < sitems.size(); i++) {
        if (sitems.item(i).one("input[type='checkbox']").get('checked')) {
            checked.appendChild(sitems.item(i).getDOMNode());
        } else {
        	unchecked.appendChild(sitems.item(i).getDOMNode())
        }
    }
	var countryFilter = scNode.one('.gsf-section-items');
	countryFilter.empty();
	var line = '';
	if (checked.childNodes.length)
		line = '<hr style="margin:0px"/>';
	countryFilter.append(checked).append(line).append(unchecked);
}

function forceSendRequest(A) {
	dontSendRequest = false;
	fireRequest(A, true);
}

function createParamsObj(A) {
	var dataObj = {};
	var textSearchInput = "";
	if (A.one('#user-text-search')){
		textSearchInput = A.one('#user-text-search').val();
		if(initialSearchText && initialSearchText.trim() != ''){
			textSearchInput = initialSearchText;
			initialSearchText = "";
		}
	}
	
	var searchParams = [];
	var items = A.all('.active-item .filter-node');
	items.each(function(item) {
		var map = item.getData();
		searchParams.push(map);
	});
	
	var sortParams = {};
	
	if (A.one('#generic-search-sortby')) {
		var sortOption = A.one('#generic-search-sortby').one('option:selected');
		if (sortOption) {
			sortParams.order = sortOption.getData().order;
			sortParams.field = sortOption.getData().field;
			sortParams.fieldType = sortOption.getData()["field-type"];
		}
	}
	
	dataObj.searchItems = searchParams;
	dataObj.sortParams = sortParams;
	dataObj.textSearchInput = textSearchInput;
	if (A.one('#startDate')){
		dataObj.startDate = A.one('#startDate').val();
		dataObj.endDate = A.one('#endDate').val();
	}
	
	
	return dataObj;
}

function resetUsrData(A){
	try{
		var sn = A.one("#usrStartIndex");
		if(sn){
			usrStartIndex = sn.val();
		}
		var ids = A.one("#processesdUserIds");
		if(ids){
			processesdUserIds = ids.val();
		}
	}catch(er){
		
	}
}
function fireRequest(A, clearResultsContainer) {
	if (dontSendRequest)
		return;
	dontSendRequest = true;

	if (clearResultsContainer) {
		startPreLoader('generic-search-wrapper');
		pageNo = 0;
		usrStartIndex = 0;
		processesdUserIds = [];
		var container = A.one(".generic-search-results");
		container.empty();
	} else {
		startPreLoader('gsf-bottom-preloader');
		resetUsrData(A);
	}
	
	var dataObj = {};
	dataObj.pageNo = pageNo;
	dataObj.usrStartIndex = usrStartIndex;
	dataObj.processesdUserIds = processesdUserIds;
	dataObj.searchItems = A.JSON.stringify(createParamsObj(A));
	console.log("firing fireRequest");
	A.io.request(ajaxUrl,
		{
			dataType : 'json',
			method : 'POST',
			data : dataObj,
			on : {
				success : function() {
					if (clearResultsContainer) {
						var container = A.one(".generic-search-results");
						container.empty();
					}
					onSuccess(this.get("responseData"), A);
					stopPreLoader('generic-search-wrapper');
					stopPreLoader('gsf-bottom-preloader');
				},
				failure : function() {
					alert(errorFetchResult);
					stopPreLoader('generic-search-wrapper');
					stopPreLoader('gsf-bottom-preloader');
					dontSendRequest = true;
				}
			}
		});
}

// TODO handle this properly
function onSuccess(respObj, A) {
	if (respObj) {
		var newNode = new A.Node.create('<div></div>');
		// ignore unwanted text
		newNode.setHTML(respObj.substring(16));
		
		var container = A.one(".generic-search-results");
		var noMore = respObj.substring(16).indexOf("generic-search-no-more-results") >= 0;
		if(!noMore) {
			var nodes = newNode.all('.generic-search-single-result');
			if (nodes.size() > 0) {
				pageNo = pageNo + 1;
				container.all('#gsf-bottom-preloader').remove();
				container.append(nodes);
				container.append('<div id="gsf-bottom-preloader">&nbsp;</div>')
				dontSendRequest = false;
			}
		} else {
			container.append("<div class='text-center gray margin-half'>" + noMoreResult + "</div>")
			dontSendRequest = true;
			var moreExamNoe = document.getElementById("_genericsearch_WAR_GenericSearchportlet_moreExams");
			moreExamNoe.classList.add("hide");
		}
		try{
			 var oldInfo = A.one("#usrsearchinfo");
			 var newinfo = newNode.one("#usrsearchinfo");
			 if(oldInfo){
				 if(newinfo){
					 oldInfo.setHTML(newinfo.getHTML());
				 }
			 }else{
				 container.append(newinfo); 
			 }
		}catch(e){
			
		}
	}
}

function populateFieldDropDown(clazz, selectObj, A, auth) {
	var obj = {};
	obj['action']  = 'getComponentFields';
	obj['compClass']  = clazz;
	var url = Liferay.PortletURL.createResourceURL();
	url.setResourceId('id');
	url.setPortletId('genericsearch_WAR_GenericSearchportlet');
	url.setParameter('sp_p_auth', auth);
	A.io.request(url.toString(), {
		dataType : 'json',
		method : 'POST',
		sync: true,
		data : obj,
		on : {
			success : function() {
				var resp = this.get("responseData");
				if(resp.options) {
					selectObj.html(resp.options)
				} else {
					alert(errorGetFieldMsg + resp.respMsg);
				}
			},
			failure: function () {
				alert(errorGetField);
			}
		}
	});
}

function loadFilters(A, auth) {
	var obj = {};
	obj['action'] = 'getFilters';
	var url = Liferay.PortletURL.createResourceURL();
	url.setResourceId('id');
	url.setPortletId('genericsearch_WAR_GenericSearchportlet');
	url.setParameter('sp_p_auth', auth);
	A.io.request(url.toString(), {
		dataType : 'json',
		method : 'POST',
		sync: true,
		data : obj,
		on : {
			success : function() {
				var resp = this.get("responseData");
				if (!resp || !resp.list)
					return;
				for (i = 0; i < resp.list.length; i++) {
					try {
					var obj = resp.list[i];
					//console.log(obj);
					var rowId = addFilter(obj.component);
					var row = A.one('.container-' + obj.component + " #" + rowId);
					if(obj.filterId){ // to make baackward compaitability, iam letting addFilter assign the value if there is no filterid
						//var row  = addFilter(obj.component);
						row.one('.select-filterId').val(obj.filterId);
						// filterId is declared in filters.jsp, summing all filter ids to get unique filter id.
						filterId = filterId + obj.filterId; 
					}
					row.one('.select-type').val(obj.type);
					typeSelect(row.one('.select-type'));
					if(obj.displayCount){
						row.one('select.select-count').val(obj.displayCount);
						countSelect(row.one('select.select-count'));
					}
					
					if (obj.vocabId)
						row.one('select.select-vocab').val(obj.vocabId);
					if (obj.fieldVocabularyId)
						row.one('select.select-fieldVocabulary').val(obj.fieldVocabularyId);
					if (obj.selection){
						row.one('select.select-selection').val(obj.selection);
					}

					//subTypeSelect(row.one('select.select-selection'));
					if (obj.config)
						row.one('.select-config').one('textarea').val(obj.config);
					if (obj.field)
						row.one('select.select-field').val(obj.field);
					if (obj.display) {
						row.one('input.select-display').set('checked', true);
						Liferay.Util.updateCheckboxValue(row.one('input.select-display'));
					}
					displaySelect(row.one('input.select-display'));
					if (obj.operator)
						row.one('select.select-opr').val(obj.operator);
					if (obj.values) {
						row.one('input.select-values').val(obj.values.list.toString());
					}
					if (obj.label)
						row.one('input.select-label').val(obj.label);
					if (obj.position) 
						row.one('input.select-position').val(obj.position);
					if (obj.level) 
						row.one('input.select-level').val(obj.level);
					if (obj.apiList)
						row.one('.select-apiList').one('select').val(obj.apiList);
					} catch (e) {
						console.log(e);
					}
				}
			},
			failure: function () {
				alert(errorGetFilters);
			}
		}
	});
}

function loadSorts(A, auth) {
	var obj = {};
	obj['action'] = 'getSorts';
	var url = Liferay.PortletURL.createResourceURL();
	url.setResourceId('id');
	url.setPortletId('genericsearch_WAR_GenericSearchportlet');
	url.setParameter('sp_p_auth', auth);
	A.io.request(url.toString(), {
		dataType : 'json',
		method : 'POST',
		sync: true,
		data : obj,
		on : {
			success : function() {
				var resp = this.get("responseData");
				//console.log(resp);
				if (!resp || !resp.list)
					return;
				for (i = 0; i < resp.list.length; i++) {
					try {
						var map = resp.list[i].map;
						if (!map)
							continue;
						var sortId = addSortRow();
						var row = A.one('.sort-container #' + sortId);
						row.one('.sort-label').val(map.label);
						row.one('select.select-sort-type').val(map.type);
						sortTypeSelect(row.one('select.select-sort-type'));
						row.one('select.select-field-type').val(map.fieldType);
						row.one('select.select-field').val(map.field);
						changeDefaultRadioValue(row.one('select.select-field'));
						if (map.sortDefault === "true")
							row.one('input.select-default').set('checked', true);
					} catch (e) {
						console.log(e);
					}
				}
			},
			failure: function () {
				alert(errorGetSorts);
			}
		}
	});
}



function showGSNode(node){
	if(node){
		node.removeClass("hide");
	}
}
function hideGSNode(node){
	if(node){
		node.addClass("hide");
	}
}

function addFavs(favs){
	if(favs){
		A.Array.each(favs,function(fav){
			addFavItem(fav);
		});
	}
}
function addFavItem(fav){
	if(fav){
		A.one(".adfSearchList").removeClass('hide');
		var sampleNode = A.one("#gsfavtemplates").one(".gs-fav-item").clone();
		sampleNode.all(".gs-fav-info").setAttribute("data-fav-id", fav.id);
		sampleNode.setAttribute("data-fav-id", fav.id);
		sampleNode.setAttribute("data-fav-name", fav.name);
		// edit,delete actions
		var actions = sampleNode.one(".gs-fav-actions");
		if(fav.canEdit){
			showGSNode(actions);
		}else{
			hideGSNode(actions);
		}
		// favname
		sampleNode.one(".gs-fav-name").set('text',fav.name);
		
		
		//appending to respective(private or global ) list
		var favsPrivate = A.one(".gs-fav-private-list");
		var favsGlobal = A.one(".gs-fav-global-list");
		if(fav.global){
			favsGlobal.appendChild(sampleNode);
			showGSNode(favsGlobal);
		}else{
			favsPrivate.appendChild(sampleNode);
			showGSNode(favsPrivate);
		}
		
	}
}
function getFavId(domNode){
	return getFavItem(domNode).getAttribute("data-fav-id");
}

function getFavName(domNode){
	return getFavItem(domNode).getAttribute("data-fav-name");
}

function getFavItem(domNode){
	return A.one(domNode).ancestor(".gs-fav-item");
}
function showEditFavourite(domNode){
	var favId = getFavId(domNode);
	var fav = getFavouriteJson(favId);
	if(fav){
		A.one('#'+pns+'favouriteName').val(fav.name);
		A.one('#'+pns+'favouriteId').val(fav.id);
		if(fav.global){
			A.one('#permissionType').set('checked',true)
		}else{
			A.one('#permissionType').set('checked',false)
		}
		createFavouritePopup();
	}
}
function showNewFavourite(){
	resetFavPopupValues();
	createFavouritePopup();
}

function clearFavourite(){
	A.one("#adfDropdown-favText").set('text','Favourites');
	A.one("#adfDropdown-favText").setAttribute("data-fav-id", '');
	clearFilters(A);
	clearSlider(A);
	forceSendRequest(A);
}

function resetFavPopupValues(){
	A.one('#'+pns+'favouriteName').val('');
	A.one('#'+pns+'favouriteId').val('');
	if (A.one('#permissionType')){
		A.one('#permissionType').set('checked',false)
	}
	
}
function getFavouriteJson(favId){
	if(!gsFavs) return null;
	
	var fav1 = A.Array.find(gsFavs,function(fav){
		if(fav.id == favId){
			return true;
		}
		return false;
	});
	return fav1;
}
function createFavouritePopup(){
	var createFavouritePopup = A.one('#createFavouritePopup'); 
	var dialog = 	Liferay.Util.Window.getWindow(
				{
					title : favDetailLbl,
					dialog: {
						bodyContent : A.one("#createFavouritePopupContainer"),
//						centered : true,
						cache: false,
						close:false,
						height : 400,
						width : 400,
						modal : true,
						constrain2view : true,
						toolbars:{ footer:[{label:cancelLbl, on: { click:function() {
							dialog.hide();
							resetFavPopupValues();
						}}},
						{
							label:saveLbl, 
							on: {
								click: function() {
									saveFavourite(dialog);  
							}
							}
						}
						]}
					}}).render();
}

function saveFavourite(dialog) {

	var obj = {};
	obj['action'] = 'saveFavourite';
	obj['filtersConfig'] = JSON.stringify(createParamsObj(A));	
	obj['favName'] = A.one('#'+pns+'favouriteName').val();	
	obj['favouriteId'] = A.one('#'+pns+'favouriteId').val();
	if (A.one('#permissionType')){
		obj['permissionType'] = A.one('#permissionType').get('checked');
	}else{
		obj['permissionType'] = 'false';
	}
		
	A.io.request(ajaxUrlSR, {
		dataType : 'json',
		method : 'POST',
		sync: true,
		data : obj,
		on : {
			success : function() {
				var data = this.get("responseData");
				if (data) {
					if (data.error) {
						alert(data.error);
					}else {
						alert(data.msg);
						dialog.hide();
						if(data.isNew){
							gsFavs.push(data.updatedFavourite);
							addFavItem(data.updatedFavourite);
						}else{
							updateFavDetails(data.updatedFavourite);
						}
						resetFavPopupValues();
						A.all("#update1").addClass("hide");
						A.all("#update2").addClass("hide");
					}
				}
				
			},
			failure: function () {
				alert(errorCreateFav);
			}
		}
	});
	  
}
function updateFavDetails(updatedFav){
	var oldFav = getFavouriteJson(updatedFav.id);
	var favItem = A.one(".gs-fav-item[data-fav-id=" + updatedFav.id + "]");
	if(favItem){
		favItem.one(".gs-fav-name").set('text',updatedFav.name);
		if (A.one("#adfDropdown-favText").getAttribute("data-fav-id") == updatedFav.id){
			A.one("#adfDropdown-favText").set('text',updatedFav.name);
		}
		if(oldFav.global != updatedFav.global){
			var favsPrivate = A.one(".gs-fav-private-list");
			var favsGlobal = A.one(".gs-fav-global-list");
			if(updatedFav.global){
				favsGlobal.appendChild(favItem);
			}else{
				favsPrivate.appendChild(favItem);
			}
		}
	}
	
	updateGSFavArray(updatedFav);
}
function updateGSFavArray(updatedFav){
	for(var i = 0; i < gsFavs.length; i++){
		if(gsFavs[i].id == updatedFav.id){
			gsFavs[i] = updatedFav;
			return;
		}
	}
}
function deleteFavourite(domNode) {
	var favId = getFavId(domNode);
	var obj = {};
	obj['action'] = 'deleteFavourite';
	obj['favouriteId'] = favId;	
	A.io.request(ajaxUrlSR, {
		dataType : 'json',
		method : 'POST',
		sync: true,
		data : obj,
		on : {
			success : function() {
				var data = this.get("responseData");
				if (data) {
					if (data.error) {
						alert(data.error);
					}else {
						getFavItem(domNode).remove();
						alert(data.msg);
						A.all("#update1").addClass('hide');
						A.all("#update2").addClass('hide');
						if (A.all(".gs-fav-item").size() > 1){
							A.one(".adfSearchList").removeClass('hide');
						}else{
							A.one(".adfSearchList").addClass('hide');
						}
						clearFavourite();
					}
				}
			},
			failure: function () {
				alert(errorDelFav);
			}
		}
	});
	  
}

function onFavSelected(domNode){
	clearFilters(A);
	clearSlider(A);
	var favId = getFavId(domNode);
	var favJ =  getFavouriteJson(favId);
	var configJ = JSON.parse(favJ.config);
	var chkb = null;
	if(configJ.searchItems){
		A.Array.each(configJ.searchItems,function(item){
			try{
				
				if (item["gsf-section-type-key"].indexOf("agerange") != -1 || item["gsf-section-type-key"].indexOf("rating") != -1){
					var sq = ".gsf-section-item.gsf-rating-item .field.filter-node[data-gsf-filter-id=FV1]";
					sq = sq.replace("FV1",item["gsf-filter-id"]);
					chkb = A.one(sq);
					
					// for slider
					if (chkb.getAttribute("id").indexOf("rating") != -1){
						chkb.ancestor().ancestor().getDOMNode().noUiSlider.set([item["gsf-value"].split(",")[0], item["gsf-value"].split(",")[1], item["gsf-value"].split(",")[2], item["gsf-value"].split(",")[3], item["gsf-value"].split(",")[4]]);
					}

					
				}else{
					var sq = ".gsf-section-item .filter-node[data-gsf-filter-id=FV1][data-gsf-value=FV2]";
					sq = sq.replace("FV1",item["gsf-filter-id"]);
					sq = sq.replace("FV2",item["gsf-value"]);
					chkb = A.one(sq);
					
					// for checkbox & single select
					if (chkb.getAttribute('type') == 'checkbox'){
						chkb.set("checked",true);
						addTextSearchEntry(chkb, favId);
					}
					
				}
				
				
				chkb.ancestor(".gsf-section-item").addClass("active-item");
				
				
			}catch(er){
				console.log(er);
			}
		});
	}
	
	try{
		 var sd = A.one('#startDate');
		 if(sd && configJ.startDate){
			 sd.val(configJ.startDate);
		 }
		 var ed = A.one('#endDate');
		 if(ed && configJ.endDate){
			 ed.val(configJ.endDate);
		 }
	}catch(err){
		
	}
	// sort parameters
	try{
		 var sort = document.getElementById("generic-search-sortby");
		 if(sort && configJ.sortParams){
			 var opts = sort.options;
			  for (var opt, j = 0; opt = opts[j]; j++) {
			    if (opt.getAttribute("data-field") == configJ.sortParams.field && opt.getAttribute("data-order") == configJ.sortParams.order) {
			    	sort.selectedIndex = j;
			      break;
			    }
			  }
		 }
		 
	}catch(err){
		
		
	}
	
	
	A.one("#adfDropdown-favText").set('text', getFavName(domNode));
	A.one("#adfDropdown-favText").setAttribute("data-fav-id", favId);
	A.one(".adfDropdown-selection").removeClass('active');
	
	A.all("#update1").addClass('hide');
	A.all("#update2").addClass('hide');
	
	if (hasGlobalFavPermmission && favJ.global || (!favJ.global)){
		A.one("#update2").setAttribute("data-fav-id", favId);
		
		try {A.all('.filter-node').on('click', function(ev){
			var selectedFavId = A.one("#adfDropdown-favText").getAttribute("data-fav-id");
			if(selectedFavId){
				A.one("#update1[data-fav-id="+selectedFavId+"]").removeClass('hide');
				A.one("#update2[data-fav-id="+selectedFavId+"]").removeClass('hide');
			}
		});}catch(ee){}
		
		// sorting	
		try {A.one('#generic-search-sortby').on('change', function(node) {
			var selectedFavId = A.one("#adfDropdown-favText").getAttribute("data-fav-id");
			if(selectedFavId){
				A.one("#update1[data-fav-id="+selectedFavId+"]").removeClass('hide');
				A.one("#update2[data-fav-id="+selectedFavId+"]").removeClass('hide');
			}
		});}catch(ee){}
		
		var slider = A.one('#slider');
		if (slider) {
			slider.getDOMNode().noUiSlider.on('set', function( values, handle ) {
				var selectedFavId = A.one("#adfDropdown-favText").getAttribute("data-fav-id");
				if(selectedFavId){
					A.one("#update1[data-fav-id="+selectedFavId+"]").removeClass('hide');
					A.one("#update2[data-fav-id="+selectedFavId+"]").removeClass('hide');
				}
			});			
		}		
		
	}
	forceSendRequest(A);
}


function clearSlider(A) {
	try {
		var slider = A.one('#slider');
		if (!slider) {
			return;
		}
	
		var sliderInput = slider.one('.gsf-rating-item input').getAttribute('data-gsf-value').split(',');
		var start = parseInt(sliderInput[2]);
		var end = parseInt(sliderInput[3]);
	
		
		slider.ancestor('.gsf-section').addClass('active-item');
		
		
		slider.getDOMNode().noUiSlider.set([start, end, start, end, parseInt(sliderInput[4])]);
		
		// setting the default values for dob
		var values = [start, end, start, end, parseInt(sliderInput[4])];

		
		var hiddenField = A.one('#slider .filter-node');
		
		hiddenField.setAttribute('data-gsf-value', values);

	} catch (e) {
	}
}

function addTextSearchEntry(filterNode, favId) {
	var tagsContainer = A.one('.genericTags');
	var textSearchContainer = A.one('.genericTags ul');
	var searchText = filterNode.ancestor('label').text().trim();
	var filterId = filterNode.getData("gsf-filter-id");
	var closeId = getCloseTagId(filterNode);
	var liCustomStyle = '';
	if (filterTagColorMapVar.hasOwnProperty(''+filterNode.val())) {
		liCustomStyle = 'style="background-color: '+filterTagColorMapVar[''+filterNode.val()]+' !important;"';
	}
	textSearchContainer.append('<li '+liCustomStyle+'>'+searchText+'<a href="#" class="closeTag" id="'+closeId+'"><img src="/GenericSearch-portlet/images/cancel.svg"/></a></li>');
	var closeTag = A.one('#'+closeId);
	closeTag.setData("gsf-filter-id",filterId);
	closeTag.setData("gsf-value",filterNode.val());
	closeTag.on('click', function(e) {
		var filterNode = getFilterNode(this);
		onClickClosedTag(filterNode);
		A.one("#update1[data-fav-id="+favId+"]").removeClass('hide');
		A.one("#update2[data-fav-id="+favId+"]").removeClass('hide');
	});
	tagsContainer.show();
}

function getCloseTagId(filterNode){
	var filterId = filterNode.getAttribute("data-gsf-filter-id");
	var closeId = 'filter-node-search-close-'+ filterId + "-" + filterNode.val();
	return closeId;
}

function onClickClosedTag(filterNode){
	var tagsContainer = A.one('.genericTags');
	var textSearchContainer = A.one('.genericTags ul');
	filterNode.set('checked',false)
    filterNode.ancestor('.gsf-section-item').removeClass('active-item');
	var filterId = filterNode.getData("gsf-filter-id");
	var closeId = A.one('#' + getCloseTagId(filterNode));
	if(closeId){
		closeId.ancestor().remove();
	}
	if (textSearchContainer.all("li").size() == 0) {
		//textSearchContainer.remove("*");
		tagsContainer.hide();
	}
	
	forceSendRequest(A);
}


function updateFavourite(domNode) {
	var favId = domNode.getAttribute("data-fav-id");
	var obj = {};
	obj['action'] = 'saveFavouriteConfig';
	obj['filtersConfig'] = JSON.stringify(createParamsObj(A));	
	obj['favouriteId'] = favId;		
	A.io.request(ajaxUrlSR, {
		dataType : 'json',
		method : 'POST',
		sync: true,
		data : obj,
		on : {
			success : function() {
				var data = this.get("responseData");
				if (data) {
					if (data.error) {
						alert(data.error);
					}else {
						alert(data.msg);
						A.one("#update1[data-fav-id="+favId+"]").addClass('hide');
						A.one("#update2[data-fav-id="+favId+"]").addClass('hide');
						var adfDropdownSelection = document.getElementById('adfDropdown-selection-id');
						  if(adfDropdownSelection.classList.contains('active')){
							  adfDropdownSelection.classList.remove('active');
						  }
						updateFavDetails(data.updatedFavourite);
					}
				}
				
			},
			failure: function () {
				alert(errorUpdateFav);
			}
		}
	});
	  
}


function showFavUsingSearchText(domNode){
	var searchText = domNode.value;
	var orgItems = A.all('.adfListSec');
	if(searchText){
		searchText = searchText.toLowerCase();
		orgItems.each(function(item) {
			var favName = item.one('.adfavname').text();
			var foundIndex = favName.trim().toLowerCase().indexOf(searchText);
			if(foundIndex >=0){
				item.removeClass('hide');
			}
			else{
				item.addClass('hide');
			}
		});
	}
	else{
		orgItems.removeClass('hide');
	}
	
}
