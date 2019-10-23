<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page import="com.sambaash.platform.srv.spasset.NoSuchTypeException" %>
<%@ page import="com.sambaash.platform.srv.spasset.model.SPAssetType" %>
<%@ page import="com.sambaash.platform.srv.spasset.service.SPAssetTypeLocalServiceUtil" %>
<%@ page import="com.liferay.portal.kernel.language.LanguageUtil" %>
<portlet:defineObjects />

<liferay-theme:defineObjects />

<portlet:resourceURL var="retrieveURL">
</portlet:resourceURL>

<portlet:renderURL var="searchRenderURL" windowState="<%= com.liferay.portal.kernel.portlet.LiferayWindowState.MAXIMIZED.toString() %>">
</portlet:renderURL>

<portlet:resourceURL var="activateURL">
	<portlet:param name="action" value="activate"></portlet:param>
</portlet:resourceURL>

<%
HttpServletRequest originalServletRequest = com.liferay.portal.util.PortalUtil.getOriginalServletRequest(request);
String selectedPortletId = originalServletRequest.getParameter("selectedPortletId");
long selectedSPAssetTypeId_ = 0;
String selectedSPAssetTypeName_ = "";
if ("SPCreateAsset_WAR_SPAssetportlet".equalsIgnoreCase(selectedPortletId)) {
	String selectedSPAssetTypeIdStr_ = originalServletRequest.getParameter("selectedSPAssetTypeId");
	try{
		selectedSPAssetTypeId_ = Long.valueOf(selectedSPAssetTypeIdStr_);
	}catch(NumberFormatException nfe) {
		// do nothing
	}
	try{
		SPAssetType selectedSPAssetType_ = SPAssetTypeLocalServiceUtil.getSPAssetType(selectedSPAssetTypeId_);
		if (selectedSPAssetType_ != null) {
			selectedSPAssetTypeName_ = selectedSPAssetType_.getSpAssetTypeName();
		}
	}catch(NoSuchTypeException nste) {
		// do nothing
	}
}
%>

<form class="as-stream-search-bar as-mbl screen-max-width" id="as_stream_form_<portlet:namespace />" method="post" <c:if test="${hideSearchBar == 'true'}">style="display: none;"</c:if> >
	<div class="as-stream-clearfix as-stream-search-bar-header" <c:if test="${hideSearchBarHeader == 'true'}">style="display: none;"</c:if>>
		<div class="as-stream-lfloat">
			<span class="as-stream-search-bar-header-text"><%= LanguageUtil.get(pageContext,"label.advanced.search")%></span>
		</div>
		<div class="as-stream-rfloat">
			<div class="styled-select inline-block">
				<select id="as_stream_filter_select_box" name="<portlet:namespace />filterSelectBox" onchange="javascript:addRowForFilter()">
					<option value=""><%= LanguageUtil.get(pageContext,"label.my.filters")%></option>
					<c:forEach var="filterValues" items="${filterNames}">
						<c:if test = "${filterValues.filterName != '' }">
							<option value="${filterValues.spSearchFilterId}">${filterValues.filterName}</option>
						</c:if>
					</c:forEach>
				</select>
			</div>
			<div class="styled-select inline-block">
				<select id="as_stream_portlet_select_box_<portlet:namespace />" name="<portlet:namespace />portletSelectBox" onchange="javascript:componentOnchange()"></select>
			</div>
			<div class="styled-select inline-block">	
				<select id="as_stream_date_select_box_<portlet:namespace />" name="<portlet:namespace />dateSelectBox">
					<option value=""><%= LanguageUtil.get(pageContext,"label.date")%></option>
					<option value="last_24_hours" <c:if test="${selectedDate == 'last_24_hours'}">selected="selected"</c:if> ><%= LanguageUtil.get(pageContext,"label.last.24.hours")%></option>
					<option value="last_7_days" <c:if test="${selectedDate == 'last_7_days'}">selected="selected"</c:if> ><%= LanguageUtil.get(pageContext,"label.last.7.days")%></option>
					<option value="last_30_days" <c:if test="${selectedDate == 'last_30_days'}">selected="selected"</c:if> ><%= LanguageUtil.get(pageContext,"label.last.30.days")%></option>
					<option value="last_365_days" <c:if test="${selectedDate == 'last_365_days'}">selected="selected"</c:if> ><%= LanguageUtil.get(pageContext,"label.last.365.days")%></option>
				</select>
			</div>
			<div class="styled-select inline-block">
				<select id="as_stream_bco_select_box_<portlet:namespace />" name="<portlet:namespace />bcoSelectBox">
					<option value="and"><%= LanguageUtil.get(pageContext,"label.exact")%></option>
					<option value="or"><%= LanguageUtil.get(pageContext,"label.any")%></option>
				</select>
			</div>
		</div>
	</div>
	<div class="as-stream-search-bar-filters section-bg" <c:if test="${hideSearchBar == 'true'}">style="display: none;"</c:if> >
		<table id="as_stream_filters_table_<portlet:namespace />" style="width: 100%;">

		</table>
		<br />
		<div align="center" class="as-stream-search-btn-box">
			<div class="filterDivHidden" id="filterNameDiv">
				<div id="secondFilterDiv" style="display: none;">
					<div style="display:inline-block;vertical-align: middle;" >
						<form id="serchfilterFrm" name="serchfilterFrm" method="post">
						<input type="hidden" name="<portlet:namespace />filterParameter" id="filterParameter"/>
							<span style="font-weight:bold;color:#666666;padding-right:10px;"><%= LanguageUtil.get(pageContext,"label.please.type")%></span> <input type="text" name="<portlet:namespace />txtFilterName" id="txtFilterName"/><span style="font-weight:bold;color:#666666;padding-left:10px;"><%= LanguageUtil.get(pageContext,"label.as.filter.name")%></span>
						</form>
					</div>
					<div style="display:inline-block;">
						<input type="button" value="<%= LanguageUtil.get(pageContext,"label.save")%>" onclick="saveSearch('saveFavorite');" class="btn-primary"/>
					</div>
					</div>
			</div>
			<input type="submit" value="<%= LanguageUtil.get(pageContext,"label.search.now")%>" onclick="OnSubmitForm('','');" id="submit-button" class="btn-primary"/>
			<input id="saveSearchButton" type="button" value="<%= LanguageUtil.get(pageContext,"label.add.to.my.favorites")%>" style="display:none;" onclick="addToFavorite();" class="btn-primary"/>
			<input type="button" value="<%= LanguageUtil.get(pageContext,"label.update.filter")%>" onclick="saveSearch('updateFavorite');" style="display:none;" id="filter-update" class="btn-primary"/>
			<c:if test="${showAdvancedSearchBtn == 'true'}"><input id="advanced_search_btn_<portlet:namespace />" type="button" value="<%= LanguageUtil.get(pageContext,"label.advanced.search")%>" class="btn-primary"/></c:if>
			<a id="as_stream_add_filter_<portlet:namespace />" href="javascript:addRow('','','','')" class="as-mrl addRowLink" style="display: none;float:right"><i>+ </i> <span><%= LanguageUtil.get(pageContext,"label.add.filter")%></span> </a>
		</div>
	</div>
</form>

<div id="as_stream_wrapper_<portlet:namespace />" class="screen-max-width search-stream-wrapper search-stream-${listingStyle}" style="display: none;">
	<c:if test="${hideResultsBar eq 'false'}">
		<div class="as-stream-results-header as-stream-clearfix">
			<span class="as-stream-lfloat"><%= LanguageUtil.get(pageContext,"label.search.results")%></span><span class="as-stream-results as-stream-rfloat"><span id="as_stream_results_count_<portlet:namespace />"> </span> <%= LanguageUtil.get(pageContext,"label.results")%></span>
		</div>
	</c:if>
	
	<c:if test="${isAdmin}">
	<div id="download_excel" style="float:right"><a href="#" id="download_excel_link"><%= LanguageUtil.get(pageContext,"label.download.excel")%></a></div><br><br>
	</c:if>
	
	<ul id="as_stream_mosaic_container_<portlet:namespace />" class="search-stream-mosaic-container">
	</ul>
	<a id="as_stream_pagination_next_<portlet:namespace />" title="Next" href="#" class="as-stream-loadmore" style="display: none;"><%= LanguageUtil.get(pageContext,"label.load.more")%></a>
</div>

<script type="text/javascript">

var allSearchFieldsJSONObject = ${allSearchFieldsJSONObject};
var assetVocabulariesJSONObject = ${assetVocabulariesJSONObject};
var countriesJSONObject = ${countriesJSONObject};
var filterJSONObject = ${filterJSONObject};

function componentOnchange() {
try {
	var table = document.getElementById("as_stream_filters_table_<portlet:namespace />");
	var rowCount = table.rows.length;

	for (var i=0; i<rowCount; i++) {
		table.deleteRow(i);
		rowCount--;
		i--;
	}

	var addFilterLink = document.getElementById("as_stream_add_filter_<portlet:namespace />");

	var portletSelectBox = document.getElementById("as_stream_portlet_select_box_<portlet:namespace />");
	var selectedPortletId = portletSelectBox.options[portletSelectBox.selectedIndex].value;
	if (selectedPortletId.length <= 0) {
		if (addFilterLink.style.display == "inline-block") {
			addFilterLink.style.display = "none";
		}
	}else {
		if (addFilterLink.style.display == "none") {
			addFilterLink.style.display = "inline-block";
		}
	}

}catch(e) {
	alert(e);
}
}

function fieldOnchange(row, fieldName, fieldValue,id) {
try {
	var thirdCell = "";
	thirdCell = document.getElementById(row);
	if (thirdCell == null) {
		thirdCell = row.cells[2];
	}
	if (fieldName == "") {
		thirdCell.innerHTML = "";
	}else {
	    var portletSelectBox = document.getElementById("as_stream_portlet_select_box_<portlet:namespace />");
	    var selectedPortletId = portletSelectBox.options[portletSelectBox.selectedIndex].value;
	    var curSearchFieldsJSONObject = allSearchFieldsJSONObject[selectedPortletId];
		var fieldDetail = curSearchFieldsJSONObject[fieldName];
		var fieldDetailLength = fieldDetail.length;
		if (fieldName == "location") {
			var locationSelectDiv = document.createElement("Div");
			locationSelectDiv.setAttribute('class','styled-select inline-block search-filter-column');
	        var locationSelectBox = document.createElement("Select");
	        for (countryId in countriesJSONObject) {
	        	var countryName = countriesJSONObject[countryId];
	            var countryOption = document.createElement("OPTION");
	            countryOption.text = countryName;
	            countryOption.value = countryName;
	            if (countryId == fieldValue) {
	            	countryOption.selected = true;
	            }
	            locationSelectBox.options.add(countryOption);
	        }
	        locationSelectDiv.appendChild(locationSelectBox);
			thirdCell.innerHTML = "";
			thirdCell.appendChild(locationSelectDiv);
		}else if (fieldDetailLength == 1) {
			var input = document.createElement("input");
			input.type = "text";
			input.style.width = "90%";
			input.value = fieldValue;
			var div = document.createElement("Div");
			div.setAttribute('class','inline-block search-filter-column');
			div.appendChild(input);
			thirdCell.innerHTML = "";
			thirdCell.appendChild(div);
		}else if (fieldDetailLength > 1) {
			var vocabularyId = fieldDetail[1];
			var categoryJSONOArray = assetVocabulariesJSONObject[vocabularyId];
			var categorySelectDiv = document.createElement("Div");
	        var categorySelectBox = document.createElement("Select");
	        categorySelectDiv.setAttribute('class','styled-select inline-block search-filter-column');
	        for (key in categoryJSONOArray) {
	            var category = categoryJSONOArray[key];
	            var categoryOption = document.createElement("OPTION");
	            categoryOption.text = category;
	            categoryOption.value = category;
	            if (category == fieldValue) {
	            	categoryOption.selected = true;
	            }
	            categorySelectBox.options.add(categoryOption);
	        }
	        categorySelectDiv.appendChild(categorySelectBox);
			thirdCell.innerHTML = "";
			thirdCell.appendChild(categorySelectDiv);
		}
	}
}catch(e) {
	alert(e);
}
}

function deleteRow(row) {
try{
	//document.title += " -rowIndex: " + row.rowIndex;
	var table = document.getElementById("as_stream_filters_table_<portlet:namespace />");
	table.deleteRow(row.rowIndex);
	// remove row1 cell1
	var rows = table.rows;
	if (rows.length > 0) {
		rows[0].cells[0].innerHTML = "";
	}
}catch(e) {
	alert(e);
}
}

function addRow(id,filterField,fieldValue,i) {
try{
	var table = document.getElementById("as_stream_filters_table_<portlet:namespace />");
	 if ((id=="storedFilter") && (i == 0)) {
		table.innerHTML = "";
	}
	var rowCount = table.rows.length;

	var row = document.createElement("TR") ;
	var td1 = document.createElement("TD");
	var columnDiv = document.createElement("div");
	td1.style.width = "12%";
	columnDiv.style.width="50%";
	if (rowCount > 0) {
		// Create BooleanClauseOccur Select Box
		var bcoSelectBox = document.createElement("Select");
		bcoSelectBox.name = "bcoSelectBox";

		var bcoOption1 = document.createElement("OPTION");
		bcoOption1.text = "OR";
		bcoOption1.value = "or";
		bcoSelectBox.options.add(bcoOption1);
		var bcoOption2 = document.createElement("OPTION");

		bcoOption2.text = "AND";
		bcoOption2.value = "and";
		bcoSelectBox.options.add(bcoOption2);

		columnDiv.setAttribute('class','styled-select search-filter-column-or');
		columnDiv.appendChild(bcoSelectBox);
		td1.appendChild(columnDiv);
	}else {
		td1.setAttribute('class','search-filter-column-or');
	}
	td1.setAttribute('class','aui-helper-hidden');

	var td2 = document.createElement("TD");
	td2.style.width = "20%";
	// Creat Field Select Box
	var fieldSelectDiv = document.createElement("Div");
	fieldSelectDiv.setAttribute('class','styled-select inline-block search-filter-column');

	var fieldSelectBox = document.createElement("Select");
	fieldSelectBox.style.width = "100%";
	fieldSelectBox.setAttribute('onchange', 'javascript:fieldOnchange(this.parentNode.parentNode.parentNode, this.options[this.selectedIndex].value, "")');

	// Create Blank Option
	fieldSelectBox.name="fieldSelectBox";
	var blankOption = document.createElement("OPTION");
	blankOption.text = "";
	blankOption.value = "";
	fieldSelectBox.options.add(blankOption);

	var portletSelectBox = document.getElementById("as_stream_portlet_select_box_<portlet:namespace />");
	var selectedPortletId = portletSelectBox.options[portletSelectBox.selectedIndex].value;
	var curSearchFieldsJSONObject = allSearchFieldsJSONObject[selectedPortletId];
	for (searchFieldName in curSearchFieldsJSONObject) {
		var searchFieldDetail = curSearchFieldsJSONObject[searchFieldName];
		//Creating Field Option
		var fieldOption = document.createElement("OPTION");
		fieldOption.text = searchFieldDetail[0];
		fieldOption.value = searchFieldName;
		fieldSelectBox.options.add(fieldOption);

		if (filterField == searchFieldName) {
			fieldName = searchFieldName;
			filterid = filterId;
			fieldOption.selected = true;
		}
	}

	fieldSelectDiv.appendChild(fieldSelectBox);
	td2.appendChild(fieldSelectDiv);

	var td3 = document.createElement("TD");
	td3.style.width = "56%";
	if (id == "storedFilter") {
		td3.setAttribute("id","cell2_"+i +"_"+filterId);
	}

	var td4 = document.createElement("TD");
	td4.style.width = "12%";
	td4.setAttribute('style', 'text-align:right;');
	var deleteLink = document.createElement('a');
	deleteLink.setAttribute('href', 'javascript:;');
	deleteLink.setAttribute('id', 'delete-row');
	deleteLink.setAttribute('onclick', 'deleteRow(this.parentNode.parentNode)');
	deleteLink.setAttribute('class', '');
	deleteLink.innerHTML = "<i>x</i> <span>Delete Filter</span>";
	td4.appendChild(deleteLink);

	row.appendChild(td1);
	row.appendChild(td2);
	row.appendChild(td3);
	row.appendChild(td4);

	table.appendChild(row);

	if (id == "storedFilter") {

		fieldOnchange("cell2_"+i +"_"+filterId, fieldName, fieldValue,"storedFilter");
		}
	var ftrSel = document.getElementById("as_stream_filter_select_box");
	var filterSelected = ftrSel.options[ftrSel.selectedIndex].value;

}catch(err) {
	alert(err);
}
}

function addRowForFilter() {
	var ftrSel = document.getElementById("as_stream_filter_select_box");
	var filterSelected = ftrSel.options[ftrSel.selectedIndex].value;
	alert("filterSelected " + filterSelected);
	var filerid = 0;
	for (filterId in filterJSONObject) {
		filterid = filterId;
		alert("filterId " + filterId);
		if (filterSelected == filterId) {
			var filterParam = filterJSONObject[filterId];
			for (key in filterParam) {
				var fParams = filterParam[key];
				if ((key == "filterDetails")) {
					if (filterSelected == filterId) {
						var fParamsVal = fParams.split(",");
						var fValues = fParamsVal[2].split("-");
						var filterFields = fParamsVal[1].split("-");
						for (i=0;i<filterFields.length;i++) {
							addRow("storedFilter",filterFields[i],fValues[i],i);
						}
					}
				}
	   	 	}
		}
	}
}

AUI().ready(function(A) {
try{

	var retrieveURL = '<%= retrieveURL.toString() %>';
	var searchRenderURL = '<%= searchRenderURL.toString() %>';
	var count = 0;
	var currentPage = 0;
	var delta = '${pageItems}';
	var maxPages = 0;
	var style = '${listingStyle}';
	var excelPath = null;

	var xhr;
	var retrieving;

	var next_btn = A.one("#as_stream_pagination_next_<portlet:namespace />");
	var count_span = A.one("#as_stream_results_count_<portlet:namespace />");
	var as_stream_form = A.one("#as_stream_form_<portlet:namespace />");
	var advancedSearchBtn = A.one("#advanced_search_btn_<portlet:namespace />");
	var downloadExcelLink = A.one("#download_excel_link");
	var searchWithStoredFilter = A.one("#as_stream_filter_select_box");

	var portletJSONArray = ${portletJSONArray};
	var defaultSelectedPortletId = '${defaultSelectedPortletId}';
	var disableComponentSelector = '${disableComponentSelector}';
	var enableAutoSearch = '${enableAutoSearch}';
	var redirectWhileSearching = ${redirectWhileSearching};

	var selectedSPAssetTypeId = '${selectedSPAssetTypeId}';
	var selectedSPAssetTypeId_ = '<%= selectedSPAssetTypeId_ %>';
	var selectedSPAssetTypeName_ = '<%= selectedSPAssetTypeName_ %>';

	// implement JSON.parse de-serialization
	JSON.parse = JSON.parse || function(str) {
	    if (str === "") str = '""';
	    eval("var p=" + str + ";");
	    return p;
	};

	// implement JSON.stringify serialization
	JSON.stringify = JSON.stringify || function(obj) {
	    var t = typeof (obj);
	    if (t != "object" || obj === null) {
	        // simple data type
	        if (t == "string") obj = '"'+obj+'"';
	        return String(obj);
	    }
	    else {
	        // recurse array or object
	        var n, v, json = [], arr = (obj && obj.constructor == Array);
	        for (n in obj) {
	            v = obj[n]; t = typeof(v);
	            if (t == "string") v = '"'+v+'"';
	            else if (t == "object" && v !== null) v = JSON.stringify(v);
	            json.push((arr ? "" : '"' + n + '":') + String(v));
	        }
	        return (arr ? "[" : "{") + String(json) + (arr ? "]" : "}");
	    }
	};

	function retrieve(url) {
	try{
		if (!retrieving) {
			retrieving = true;
			AjaxGet(url, retrieveSuccess, retrieveError);
		}
	}catch(err) {
		//alert(err);
	}
	}

	function AjaxGet(url, successFunc, errorFunc) {
	try{
		if (window.XMLHttpRequest) {
			// code for IE7+, Firefox, Chrome, Opera, Safari
		  	xhr=new XMLHttpRequest();
		}
		else {
			// code for IE6, IE5
		 	xhr=new ActiveXObject("Microsoft.XMLHTTP");
		}
		xhr.onreadystatechange = function() {
			if (xhr.readyState == 4) {
			    if (xhr.status == 200) {
			    	successFunc();
			    }
			    else {
			    	errorFunc();
			    }
			}
		};

	   xhr.open("GET", url, true);
	   xhr.send(null);

	}catch(err) {
		//alert(err);
	}
	}

	function retrieveSuccess() {
		//alert("retrieveSuccess");
	try{
		var as_stream_wrapper = document.getElementById("as_stream_wrapper_<portlet:namespace />");
		if (as_stream_wrapper.style.display == "none") {
			as_stream_wrapper.style.display = "block";
		}
		var data = JSON.parse(xhr.responseText);
		count = data.count.value;

		var ftrSel = document.getElementById("as_stream_filter_select_box");
		var filterSelected = ftrSel.options[ftrSel.selectedIndex].value;

		if ((document.getElementById("filterParameter").value != "")) {
			document.getElementById("saveSearchButton").style.display = "inline-block";
			document.getElementById("filter-update").style.display="inline-block";
		}

		if (count_span) {
			count_span.text(count);
		}
		maxPages = count / delta;
		var mod=count % delta;
		if (mod > 0) {
			maxPages++;
		}
		maxPages = parseInt(maxPages);

		var stream_container = document.getElementById("as_stream_mosaic_container_<portlet:namespace />");
		var items = data.items;
		excelPath = data.excelPath;
		if (items.length == 0) {
			stream_container.innerHTML = "No records available for viewing.";
		}else {
			for (var i = 0; i < items.length; i++) {
				stream_container.innerHTML += items[i].html;
			}
		}

		if (!(currentPage >= (maxPages - 1)) && maxPages > 0) {
			if(next_btn){
				if (next_btn.getStyle('display') == "none") {
					next_btn.setStyle('display', 'block');
				}
			}
		}else {
			if(next_btn){
				if (next_btn.getStyle('display') == "block") {
					next_btn.setStyle('display', 'none');
				}
			}	
		}

		retrieving = false;
	}catch(err) {
		//alert(err);
	}
	}

	function retrieveError() {
		alert("Oops! An unexpected error occurred while processing your request.");
	}

	if (next_btn) {
		next_btn.on('click', function(event) {
			event.preventDefault();
			if ((currentPage + 1) >= (maxPages - 1)) {
				if (next_btn.getStyle('display') == "block") {
					next_btn.setStyle('display', 'none');
				}
			}
			currentPage = currentPage + 1;
		    var portletSelectBox = document.getElementById("as_stream_portlet_select_box_<portlet:namespace />");
		    var selectedPortletId = portletSelectBox.options[portletSelectBox.selectedIndex].value;
		    var dateSelectBox = document.getElementById("as_stream_date_select_box_<portlet:namespace />");
		    var selectedDate = dateSelectBox.options[dateSelectBox.selectedIndex].value;
		    var tempRetrieveURL = retrieveURL + "&currentPage=" + currentPage + "&selectedPortletId=" + selectedPortletId + "&selectedDate=" + selectedDate;
		    var allFilters = getAllFilters();
		    tempRetrieveURL += "&occur=" + allFilters[0] + "&clause=" + allFilters[1] + "&q=" + allFilters[2];
			retrieve(tempRetrieveURL);
		});
	}

	function initComponents() {
	try{
		var portletSelectBox = document.getElementById("as_stream_portlet_select_box_<portlet:namespace />");
		var blankOption = document.createElement("OPTION");
		blankOption.text = "Component";
		blankOption.value = "";
		for (key in portletJSONArray) {
			var portletJSONObject = portletJSONArray[key];
			var portletOption = document.createElement("OPTION");
			portletOption.value = portletJSONObject.portletId;
			if (portletJSONObject.portletId == "SPCreateAsset_WAR_SPAssetportlet" && selectedSPAssetTypeName_.length > 0) {
				portletOption.text = selectedSPAssetTypeName_;
			}else {
				portletOption.text = portletJSONObject.portletIdLabel;
			}
			portletSelectBox.options.add(portletOption);
			if (defaultSelectedPortletId.length > 0 && defaultSelectedPortletId == portletJSONObject.portletId) {
				portletOption.selected = true;
				var addFilterLink = document.getElementById("as_stream_add_filter_<portlet:namespace />");
				if (addFilterLink.style.display == "none") {
					addFilterLink.style.display = "inline-block";
				}
			}
		}
		if (disableComponentSelector == "true") {
			portletSelectBox.disabled = true;
		}

		var addFilterLink = document.getElementById("as_stream_add_filter_<portlet:namespace />");

		var selectedPortletId = portletSelectBox.options[portletSelectBox.selectedIndex].value;
		if (selectedPortletId.length <= 0) {
			if (addFilterLink.style.display == "inline-block") {
				addFilterLink.style.display = "none";
			}
		}else {
			if (addFilterLink.style.display == "none") {
				addFilterLink.style.display = "inline-block";
			}
		}

	}catch(e) {
		alert(e);
	}
	}

	if (as_stream_form) {
		as_stream_form.on('submit', function(event) {
		try{
			event.preventDefault();
			searchFormSubmit(false,"");
		}catch(err) {
			//alert(err);
		}
		});
	}

	if (advancedSearchBtn) {
		advancedSearchBtn.on('click', function(event) {
			searchFormSubmit(true,"");
		});
	}

	if (searchWithStoredFilter) {
		searchWithStoredFilter.on('change', function(event) {
			searchFormSubmit(false,"");
		});
	}

	if (downloadExcelLink) {
		downloadExcelLink.on('click', function(event) {
			dlComplete = searchFormSubmit(false,"download");
			if (dlComplete)
				setTimeout(function(){document.location.href = "/AdvancedSearch-portlet/download?fileName="+excelPath},6000);

		});
	}

	function searchFormSubmit(isAdvancedSearch,download) {
		var stream_container = document.getElementById("as_stream_mosaic_container_<portlet:namespace />");
		stream_container.innerHTML = "";
		currentPage = 0;

	    var bcoSelectBox = document.getElementById("as_stream_bco_select_box_<portlet:namespace />");
	    var bcoValue = bcoSelectBox.options[bcoSelectBox.selectedIndex].value;

	    var portletSelectBox = document.getElementById("as_stream_portlet_select_box_<portlet:namespace />");
	    var selectedPortletId = portletSelectBox.options[portletSelectBox.selectedIndex].value;
	    var dateSelectBox = document.getElementById("as_stream_date_select_box_<portlet:namespace />");
	    var selectedDate = dateSelectBox.options[dateSelectBox.selectedIndex].value;
	    if (isAdvancedSearch == false) {
	        if (redirectWhileSearching) {
	        	var tempSeachRenderURL = "/search" + "?currentPage=" + 0 + "&selectedPortletId=" + selectedPortletId + "&selectedDate=" + selectedDate;
	        	if (selectedPortletId == "SPCreateAsset_WAR_SPAssetportlet") {
	        		tempSeachRenderURL += "&selectedSPAssetTypeId=" + selectedSPAssetTypeId;
	        	}
	    	    var allFilters = getAllFilters();
	    	    tempSeachRenderURL += "&occur=" + allFilters[0] + "&clause=" + allFilters[1] + "&q=" + allFilters[2];
				window.location.href = tempSeachRenderURL;
	        }else {
	    	    var tempRetrieveURL = retrieveURL + "&currentPage=" + currentPage + "&selectedPortletId=" + selectedPortletId + "&selectedDate=" + selectedDate + "&bcoValue=" + bcoValue;
	    	    var allFilters = getAllFilters();
	    	    if (selectedPortletId == "SPCreateAsset_WAR_SPAssetportlet") {
	    	    	tempRetrieveURL += "&selectedSPAssetTypeId_=" + selectedSPAssetTypeId_;
	        	}
	    	    tempRetrieveURL += "&occur=" + allFilters[0] + "&clause=" + allFilters[1] + "&q=" + allFilters[2]+"&download=" + download;

	    	    if (allFilters[2] != "") {
	    	    	document.getElementById("filterParameter").value=allFilters;

	    	    }
	    		retrieve(tempRetrieveURL);
	        }
	    }else if (isAdvancedSearch == true) {
			var tempSeachRenderURL = "/advanced-search" + "?currentPage=" + 0 + "&selectedPortletId=" + selectedPortletId + "&selectedDate=" + selectedDate;
			if (selectedPortletId == "SPCreateAsset_WAR_SPAssetportlet") {
				tempSeachRenderURL += "&selectedSPAssetTypeId=" + selectedSPAssetTypeId;
			}
		    var allFilters = getAllFilters();
		    tempSeachRenderURL += "&occur=" + allFilters[0] + "&clause=" + allFilters[1] + "&q=" + allFilters[2];
			window.location.href = tempSeachRenderURL;
	    }
	    return true;
	}

	function initSearchBar() {
	try{
		var occurFromRequest = '<%= originalServletRequest.getParameter("occur") %>';
		var clauseFromRequest = '<%= originalServletRequest.getParameter("clause") %>';
		var qFromRequest = '<%= originalServletRequest.getParameter("q") %>';
		var currentPage = '<%= originalServletRequest.getParameter("currentPage") %>';
		var selectedPortletId = '<%= originalServletRequest.getParameter("selectedPortletId") %>';
		var selectedDate = '<%= originalServletRequest.getParameter("selectedDate") %>';

		if (selectedPortletId != "null" && selectedPortletId.length > 0) {
		    var portletSelectBox = document.getElementById("as_stream_portlet_select_box_<portlet:namespace />");
			var portletSelectBoxCount = portletSelectBox.options.length;
			for (var i = 0; i < portletSelectBoxCount; i++) {
				var portletOption = portletSelectBox.options[i];
				if (portletOption.value == selectedPortletId) {
					portletOption.selected = true;
				    var addFilterLink = document.getElementById("as_stream_add_filter_<portlet:namespace />");
			    	if (addFilterLink.style.display == "none") {
			        	addFilterLink.style.display = "inline-block";
			    	}
				}
			}
		}

		if (selectedDate != "null" && selectedDate.length > 0) {
		    var dateSelectBox = document.getElementById("as_stream_date_select_box_<portlet:namespace />");
			var dateSelectBoxCount = dateSelectBox.options.length;
			for (var i = 0; i < dateSelectBoxCount; i++) {
				var dateOption = dateSelectBox.options[i];
				if (dateOption.value == selectedDate) {
					dateOption.selected = true;
				}
			}
		}
		if (occurFromRequest != "null" && occurFromRequest.length > 0) {
			var occurFromRequestArray = occurFromRequest.split("-");
			var clauseFromRequestArray = clauseFromRequest.split("-");
			var qFromRequestArray = qFromRequest.split("-");
			for (key in occurFromRequestArray) {
				addExistingRow(occurFromRequestArray[key], clauseFromRequestArray[key], qFromRequestArray[key]);
			}
		}
	}catch(e) {
		alert(e);
	}
	}

	function addExistingRow(_occurFromRequest, _clauseFromRequest, _qFromRequest) {
	try{
	    var table = document.getElementById("as_stream_filters_table_<portlet:namespace />");
	    var rowCount = table.rows.length;

	    var row = document.createElement("TR") ;
	    table.appendChild(row);
	    var td1 = document.createElement("TD");
	    td1.style.width = "12%";
	    var columnDiv = document.createElement("div");
	    columnDiv.style.width="50%";
	    row.appendChild(td1);
	    if (rowCount > 0) {
	    	td1.setAttribute('class','search-filter-column-or');
	        // Create BooleanClauseOccur Select Box
	        var bcoSelectBox = document.createElement("Select");
	        bcoSelectBox.name = "bcoSelectBox";

	        var bcoOption1 = document.createElement("OPTION");
	        bcoOption1.text = "OR";
	        bcoOption1.value = "or";
	        bcoSelectBox.options.add(bcoOption1);
	        var bcoOption2 = document.createElement("OPTION");

	        bcoOption2.text = "AND";
	        bcoOption2.value = "and";

	        if (_occurFromRequest == "and") {
	        	bcoOption2.selected = true;
	        }else if (_occurFromRequest == "or") {
	        	bcoOption1.selected = true;
	        }

	        bcoSelectBox.options.add(bcoOption2);

	        columnDiv.setAttribute('class','styled-select search-filter-column-or');
	        columnDiv.appendChild(bcoSelectBox);
	        td1.appendChild(columnDiv);
	    }else {
	    	td1.setAttribute('class','search-filter-column-or-none');
	    }
		td1.setAttribute('class','aui-helper-hidden');

	    var td2 = document.createElement("TD");
	    row.appendChild(td2);
	    td2.style.width = "20%";

	    // Creat Field Select Box
	    var fieldSelectDiv = document.createElement("Div");
		fieldSelectDiv.setAttribute('class','styled-select inline-block search-filter-column');

	    var fieldSelectBox = document.createElement("Select");
	    fieldSelectBox.style.width = "100%";
	    fieldSelectBox.setAttribute('onchange', 'javascript:fieldOnchange(this.parentNode.parentNode.parentNode, this.options[this.selectedIndex].value, "","")');

	    // Create Blank Option
	    fieldSelectBox.name="fieldSelectBox";
	    var blankOption = document.createElement("OPTION");
	    blankOption.text = "";
	    blankOption.value = "";
	    fieldSelectBox.options.add(blankOption);

	    var portletSelectBox = document.getElementById("as_stream_portlet_select_box_<portlet:namespace />");
	    var selectedPortletId = portletSelectBox.options[portletSelectBox.selectedIndex].value;
	    var curSearchFieldsJSONObject = allSearchFieldsJSONObject[selectedPortletId];
	    for (searchFieldName in curSearchFieldsJSONObject) {
			var searchFieldDetail = curSearchFieldsJSONObject[searchFieldName];
	        //Creating Field Option
	        var fieldOption = document.createElement("OPTION");
	        fieldOption.text = searchFieldDetail[0];
	        fieldOption.value = searchFieldName;
	        if (_clauseFromRequest == searchFieldName) {
	        	fieldOption.selected = true;
	        }
	        fieldSelectBox.options.add(fieldOption);
		}

	    fieldSelectDiv.appendChild(fieldSelectBox);
	    td2.appendChild(fieldSelectDiv);

	    var td3 = document.createElement("TD");
	    row.appendChild(td3);
	    td3.style.width = "56%";

	    fieldOnchange(row, _clauseFromRequest, _qFromRequest,"");

	    var td4 = document.createElement("TD");
	    row.appendChild(td4);
	    td4.style.width = "12%";
	    var deleteLink = document.createElement('a');
	    deleteLink.setAttribute('href', 'javascript:;');
	    deleteLink.setAttribute('id', 'delete-row');
	    deleteLink.setAttribute('onclick', 'deleteRow(this.parentNode.parentNode)');
	    deleteLink.setAttribute('class', '');
	    deleteLink.innerHTML = "x Delete Filter";
	    td4.appendChild(deleteLink);

	}catch(err) {
		//alert(err);
	}
	}

	function getAllFilters() {
	try{
	    var table = document.getElementById("as_stream_filters_table_<portlet:namespace />");
	    var rows = table.rows;
	    var rowCount = rows.length;
	    var occur = "";
	    var clause = "";
	    var q = "";
	    for (var i=0; i<rowCount; i++) {
	    	var row = rows[i];
	    	if (row.cells[2].childNodes[0]) {
		    	var fieldSelectBox = row.cells[1].childNodes[0].childNodes[0];
		    	var cell2ChildNode = row.cells[2].childNodes[0].childNodes[0];

		    	if (i == 0) {
			    	occur += "and";
		    	}else {
			    	var bcoSelectBox = row.cells[0].childNodes[0].childNodes[0];
		    		occur += bcoSelectBox.options[bcoSelectBox.selectedIndex].value;
		    	}
		    	clause += fieldSelectBox.options[fieldSelectBox.selectedIndex].value;

		    	if (cell2ChildNode) {
			    	var cell2ChildNodeTagName = cell2ChildNode.tagName;
			    	if (cell2ChildNodeTagName == "INPUT") {
				    	q += cell2ChildNode.value;
			    	}else if (cell2ChildNodeTagName == "SELECT") {
			    		q += cell2ChildNode.options[cell2ChildNode.selectedIndex].value;
			    	}
		    	}

		    	if (i < (rowCount-1)) {
		    		occur += "-";
		    		clause += "-";
		    		q += "-";
		    	}
	    	}
	    }
	    var filters = [occur, clause, q];
	    return filters;

	}catch(err) {
		//alert(err);
	}
	}

	initComponents();

	if (!redirectWhileSearching) {
		initSearchBar();
	}

	if (enableAutoSearch == "true") {
		searchFormSubmit(false,"");
	}

}catch(err) {
	//alert(err);
}
});

function OnSubmitForm(download,downloadPath)
{
	if (download == "download") {
document.getElementById("as_stream_form_<portlet:namespace />").action = "<%= retrieveURL.toString() %>?download=true";
searchFormSubmit(false,"");
document.location.href = "/AdvancedSearch-portlet/download?fileName="+downloadPath;
	}else if (download == "storedFilter") {
		document.getElementById("as_stream_form_<portlet:namespace />").action = "<%= retrieveURL.toString() %>";
		searchFormSubmit(true,"");
	}
	else {
		document.getElementById("as_stream_form_<portlet:namespace />").action = "<%= retrieveURL.toString() %>";
	}
return true;
}
function addToFavorite() {
	document.getElementById("filterNameDiv").className="filterDiv";

	setTimeout(function(){ document.getElementById("secondFilterDiv").style.display="inline-block"; }, 500);

	document.getElementById("filter-update").style.display="none";
	document.getElementById("submit-button").style.display="none";
}
function saveSearch(action) {
	var action = action;
	var isSave = true;
	var filterParameter = document.getElementById("filterParameter").value;
	var filterName= document.getElementById("txtFilterName").value;
	if ((action == "saveFavorite") && (filterName == "")) {
		isSave = false;
	}
	var ftrSel = document.getElementById("as_stream_filter_select_box");
	var filterSelected = ftrSel.options[ftrSel.selectedIndex].value;
	if (isSave) {
		try{
			var A=AUI();
			var items = null;
			var reqUrl = '<portlet:resourceURL id="" />';
			A.io.request(reqUrl, {
			    cache: false,
			    sync: true,
			    timeout: 1000,
			    dataType: 'json',
			    method: 'post',
			    data:{
			   	 action:action,
			   	filterParameter: filterParameter,
			   	filterName:filterName,
			   	filterSelected:filterSelected,
			    },
			    on: {
			    	success: function() {
			    		 items = this.get('responseData');
			    		if (action == "saveFavorite") {
			    			var ftrSel = document.getElementById("as_stream_filter_select_box");
			    			var optElm = document.createElement("OPTION");
			    			for (key in items) {
				    			optElm.value = key;
					    		optElm.text = items[key];
			    			}
			            	optElm.selected = true;
			            	ftrSel.options.add(optElm);
			    		}
			    		document.getElementById("secondFilterDiv").style.display="none";
			    		document.getElementById("filterNameDiv").className="filterDivHidden";
			    		document.getElementById("saveSearchButton").style.display="none";
			    		document.getElementById("submit-button").style.display="inline-block";
			    	}
			    },
		        failure: function() {
		        }

		});
		}catch(err) {
		}
	}else {
		alert("Please enter a name for search to add to favourites");
	}
}

</script>

<aui:script>

	AUI().ready('aui-base', 'aui-io-request', function(A) {

		var documentBody = A.one('document.body');
		if (documentBody) {

			documentBody.delegate(
				'click',
				function(event) {
					var classPK = this.get('title');
					var activateLink = this;
					var text = activateLink.html();
					A.io.request(
		    			'<%= activateURL %>',
		    			{
		    			    dataType: 'json',
		    				data: {
								<portlet:namespace />classPK: classPK,
								<portlet:namespace />text: text
		    				},
		    				sync: true,
		    				on: {
		    					success: function() {
	    							var result = this.get('responseData').result;
	    							var replaceText = this.get('responseData').replaceText;
	    							if (result == 'success') {
	    								activateLink.html(replaceText);
	    							}else {
	    								alert("Oops! An unexpected error occurred while processing your request.");
	    							}
		    					},
								failure: function() {
	    							alert("Oops! An unexpected error occurred while processing your request.");
								},
								end: function() {

								}
		    				}
		    			}
		   			);
				},
				'.as-profile-activate'
			);
		}
	});

</aui:script>
