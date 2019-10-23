<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>


<%@ page import="java.util.List" %>

<portlet:defineObjects />
<liferay-theme:defineObjects />

<%
String noOfCategories = (String)request.getAttribute("noOfCategories");
%>
<section class="webContent-search-wrap">
	<div class="webContent-search-wrap-content screen-max-width">
		<div class="searchHeader padding-top-one padding-bottom-one">
			<div class="searchHeaderText inline-block text-left align-middle">
				<h1 class="margin-none">Make yourself future ready</h1>
			</div>
			<div class="openSearch inline-block text-right font-none searchField align-middle" id="openSearch">
				<input type="text" id="openSearchText" placeholder="Search Course Information" class="font-std" onKeyDown="if(event.keyCode==13) startSearch('','textSearch','')" >
				
				<div class="search-btn" onClick="javascript:startSearch('','textSearch','')" id="textSearch">
					<input type="button" value="Search">
				</div>
				
				<div class="filter-btn">
					
				</div>
				
				
			</div>
		</div>
		<div class="webContent-search-content block">
			<c:if test="${searchFilterWrappers != ''}">
			<%int k = 1; %>
				<div class="aui-helper-clearfix webContent-searchFilters font-10" id="webContent-searchFilters" >
					<div class="searchFilters-list">
								<c:forEach items="${searchFilterWrappers}" var="searchFilterWrappers">
									<div class="filter-category-item padding-top-half">
										<div class="searchFilter-title group-title-2">${searchFilterWrappers.vocabularyName} </div>
										<input type='hidden' value='${searchFilterWrappers.selectionType}'  id="selectionType<%=k%>" name="selectionType<%=k%>"></input>
										<ul style="padding-bottom:15px;">
									    	<c:if test="${searchFilterWrappers.selectionType == 'single'}">
									    	   <script>
									    	   	  window.searchAllQuery = window.searchAllQuery ? window.searchAllQuery + "&&" : "";
									    	      window.searchAllQuery = "singleAll," + ${searchFilterWrappers.vocabularyId};
									    	      window.searchAllVocId = '${searchFilterWrappers.vocabularyId}';
									    	   </script>
									    		<li class="block pointer">
										    		<a href="#" onClick='javascript:startSearch(${searchFilterWrappers.vocabularyId},"singleSelAll",<%=k %>);setSearchParam()' class="selectedCatg<%=k %> link" id="${searchFilterWrappers.vocabularyId}">
										    			<span>All</span>
										    		</a>
										    	</li>
										    	<%int ct = 0;%>
										    	<c:forEach items ="${searchFilterWrappers.assetCategory}" var="assetCatg">
										    	<%if (ct < Integer.parseInt(noOfCategories)){ %>
										    		<c:if test="${assetCatg.getCategoryId() == searchFilterWrappers.catgId}">
											    		<li class="block pointer active">
											    			<a href="#" onClick='javascript:startSearch(${assetCatg.getCategoryId()},"singleSel",<%=k %>);setSearchParam()' id='${assetCatg.getCategoryId()}' class="link">
											    				<span>${assetCatg.getName()}</span>
											    			</a>
											    		</li>
										    		</c:if>
										    		<c:if test="${assetCatg.getCategoryId() != searchFilterWrappers.catgId}">
											    		<li class="block pointer">
											    			<a href="#" onClick='javascript:startSearch(${assetCatg.getCategoryId()},"singleSel",<%=k %>);setSearchParam()' id='${assetCatg.getCategoryId()}' class="link">
											    				<span>${assetCatg.getName()}</span>
											    			</a>
											    		</li>
										    		</c:if>
										    	<%}else{ %>	
										    		<li class="block pointer filter<%=k %>" style="display:none">
										    			<a href="#" onClick='javascript:startSearch(${assetCatg.getCategoryId()},"singleSel",<%=k %>);setSearchParam()' id='${assetCatg.getCategoryId()}' class="link">
										    				<span>${assetCatg.getName()}</span>
										    			</a>
										    		</li>
										    	<%}ct = ct + 1; %>
										    	</c:forEach>
										    	<%if(ct > Integer.parseInt(noOfCategories)){ %>
										    	<div id="viewAll<%=k %>" class="viewAllDiv"><a href="javascript:categoryViewAll(<%=k %>);setSearchParam()" class="link">View All</a></div>
										    	<%} %>
									    	</c:if>
									    	<c:if test="${searchFilterWrappers.selectionType == 'multiple'}">
									    	<%int mct = 0; %>
										    	<c:forEach items ="${searchFilterWrappers.assetCategory}" var="assetCatg">
										    	<%if (mct < Integer.parseInt(noOfCategories)){ %>
										    		<c:if test="${assetCatg.getCategoryId() == searchFilterWrappers.catgId}">
											    		<li class="block pointer">
											    			<input type="checkbox" value="${assetCatg.getCategoryId()}" onClick='javascript:startSearch(${assetCatg.getCategoryId()},"multiSel",<%=k %>);' name="multiSelectBox<%=k %>" checked>
											    			<span class="checkbox-label">${assetCatg.getName()}</span>
											    		</li>
											    	</c:if>	
											    	<c:if test="${assetCatg.getCategoryId() != searchFilterWrappers.catgId}">
											    		<li class="block pointer">
											    			<input type="checkbox" value="${assetCatg.getCategoryId()}" onClick='javascript:startSearch(${assetCatg.getCategoryId()},"multiSel",<%=k %>)' name="multiSelectBox<%=k %>">
											    			<span class="checkbox-label">${assetCatg.getName()}</span>
											    		</li>
											    	</c:if>	
										    	<%}else{ %>		
										    		<c:if test="${assetCatg.getCategoryId() == searchFilterWrappers.catgId}">
											    		<li class="block pointer filter<%=k %>" style="display:none">
											    			<input type="checkbox" value="${assetCatg.getCategoryId()}" onClick='javascript:startSearch(${assetCatg.getCategoryId()},"multiSel",<%=k %>)' name="multiSelectBox<%=k %>" checked>
											    			<span class="checkbox-label">${assetCatg.getName()}</span>
											    		</li>
											    	</c:if>
											    	<c:if test="${assetCatg.getCategoryId() != searchFilterWrappers.catgId}">
											    		<li class="block pointer filter<%=k %>" style="display:none">
											    			<input type="checkbox" value="${assetCatg.getCategoryId()}" onClick='javascript:startSearch(${assetCatg.getCategoryId()},"multiSel",<%=k %>)' name="multiSelectBox<%=k %>">
											    			<span class="checkbox-label">${assetCatg.getName()}</span>
											    		</li>
											    	</c:if>	
										    	<%}mct = mct + 1; %>	
										    	</c:forEach>
										    	<%if(mct > Integer.parseInt(noOfCategories)){ %>
										    		<div id="viewAll<%=k %>" class="viewAllDiv"><a href="javascript:categoryViewAll(<%=k %>)" class="link">View All</a></div>
										    	<%} %>
									    	</c:if>
									    	 </ul>
									    	 <%if(k == 1) {%>
									    	 <input type="hidden" value="${searchFilterWrappers.vocabularyId}" name="firstFilter" id="firstFilter">
									    	 <input type="hidden" value="${searchFilterWrappers.vocabularyName}" name="firstFilterName" id="firstFilterName">
									    	 <%} %>
									    	 <input type="hidden" value="" name="filterValues" id="filter<%=k %>">
									    	 <%k=k+1; %>
								    </div>
						    	</c:forEach>			
						   <input type="hidden" id="totalFilters" value="<%=k-1 %>">
					</div>
				</div>
			</c:if>	
			
			<div class="webContent-searchResultsMainDiv webContent-searchResults-wrap font-std">
			<c:if test="${!selectedMainCategoryName.isEmpty()}">
				<div id="searchFilter-Category" class="searchFilter-Category">
					<div class="selectedCatgName">${selectedMainCategoryName}</div>
					<div class="selectedCatgDesc">
						${selectedMainCategoryDesc}
					</div>
					<c:if test="${!selectedMainCategoryUrl.isEmpty()}">
						<div class="selectedCatgUrl normal-cta">
							<a href="${selectedMainCategoryUrl}"><span>Learn More</span></a>
						</div>
					</c:if>
				</div>
			</c:if>	
			<c:if test="${selectedMainCategoryName == ''}">
				<div id="searchFilter-Category">
				</div>
			</c:if>
				<div class="aui-helper-clearfix webContent-searchResults" id="webContent-searchResults">
					<c:if test="${webContentSearchResultsWrapperList != '[]'}">
					<c:forEach items ="${webContentSearchResultsWrapperList}" var="webContentSearchResultsWrapper">
					<div class="search-stream-mosaic-block-content block">
						<div class="wcResult-stream-item block aui-helper-clearfix">
							<div class="wcResult-image align-top relative overflow-hidden">
								<a title="${webContentSearchResultsWrapper.title}" href="${webContentSearchResultsWrapper.link}" class="block">
									<img alt="${webContentSearchResultsWrapper.title}" title="${webContentSearchResultsWrapper.title}" src="${webContentSearchResultsWrapper.imageUrl}" class="">
								</a>
							</div>
							<div class="wcResult-body align-top relative">
								<div class="wcResult-header">
									<a title="${webContentSearchResultsWrapper.title}" href="${webContentSearchResultsWrapper.link}" class="wcResult-title link">${webContentSearchResultsWrapper.title}</a>
									<div class="wcResult-provider text-right">
										<img alt="Logo" src="${webContentSearchResultsWrapper.logo}" class="wcResult-logo block">
										<div class="wcResult-type block  type-${webContentSearchResultsWrapper.type }">${webContentSearchResultsWrapper.type }</div>
									</div>
								</div>
								<div class="wcResult-desc">${webContentSearchResultsWrapper.description}</div>
								<div class="wcResult-details font-none block">
									<c:if test="${webContentSearchResultsWrapper.duration != ''}">
										<div class="wcResult-duration inline-block">
											${webContentSearchResultsWrapper.duration}<span class="detail-label">${webContentSearchResultsWrapper.durationType}</span>
										</div>
									</c:if>
									<c:if test="${webContentSearchResultsWrapper.size != ''}">
										<div class="wcResult-size inline-block">
											${webContentSearchResultsWrapper.size}<span class="detail-label">modules</span>
										</div>
									</c:if>
									<div class="wcResult-splz inline-block">${webContentSearchResultsWrapper.specialization}</div>
								</div>
							</div>
							<div class="wcResult-desc wcResult-mobile">${webContentSearchResultsWrapper.description}</div>
						</div>
					</div>
					</c:forEach>
					</c:if>
					<c:if test="${emptyResultMsg != '[]'}">
						${emptyResultMsg}
					</c:if>
				</div>
				<div class="search-loadMore">
				<c:if test = "${showLoadmore }">
					<div id="pagination_next" title="Next" class="as-stream-loadmore link" style="display: block;" onClick="javascript:startSearch('','loadMore','')">
						Load More
					</div>
				</c:if>	
				<c:if test = "${!showLoadmore }">
					<div id="pagination_next" title="Next" class="as-stream-loadmore link" style="display: none;" onClick="javascript:startSearch('','loadMore','')">
						Load More
					</div>
				</c:if>	
				</div>
				<input type="hidden" id="paginationValue" value="0">
				<input type="hidden" id="totalDisplayResults" value="${totalDisplayResults }">
			</div>
		</div>	
	</div>
</section>

<script>
var keepAllSelected = true;
function initSearch(){
	var vocIdElem= document.getElementById('firstFilter');
	var vocId = 0;
	if(vocIdElem){
		vocId = vocIdElem.value;
	}
	startSearch(vocId,"singleSelAll",1);
}

function setSearchParam(){
	var ldMoreDiv = document.getElementById("pagination_next");
	ldMoreDiv.setAttribute("onclick","javascript:startSearch('','loadMore','')");
	var textSearchDiv = document.getElementById("textSearch");
	textSearchDiv.setAttribute("onclick","javascript:startSearch('','textSearch','')");
	var textSearchip = document.getElementById("openSearchText");
	textSearchip.setAttribute("onKeyDown","if(event.keyCode==13) startSearch('','textSearch','')");
}

function selectAllCategory(){
	try{
		var selectedParentNode = document.getElementById(window.searchAllVocId);
		selectedParentNode.parentNode.className += " active";
	}catch(err){
		
	}
}

function startSearch(categoryId,selType,count){
	var A = AUI();
	var reqUrl = '<portlet:resourceURL id="" />';
	var action = "search";
	if(categoryId == 'UrlParameterSearch'){
		action = "UrlParameterSearch";
	}else{
		action = "search";
	}	
	var ldMoreDiv = document.getElementById("pagination_next");
	var paginationDiv =  document.getElementById("paginationValue");
	var pagination = paginationDiv.value;
	var totalDisplayResults =  document.getElementById("totalDisplayResults").value;
	var singleMainCatg = 0;
	var searchText = document.getElementById("openSearchText").value;
	
	var singleMainCatgDiv = document.getElementById("filter"+1).value;
	var singleMainCatgValues = singleMainCatgDiv.split(",");
	singleMainCatg = singleMainCatgValues[1];

	if(selType != 'loadMore'){
		// make pagenation value to blank, as search creteria changed
		paginationDiv.value = 0;
		pagination = paginationDiv.value;
	}
	
	var singleSelFiltersVal = "single,";
	if(selType == 'singleSel' || selType == 'singleSelAll'){
			var parntNodes = document.getElementsByClassName("active");
			for(var i=0;i<parntNodes.length;i++){
				parntNodes[i].className = "block pointer";
			}
			var selectedParentNode = document.getElementById(categoryId);
			selectedParentNode.parentNode.className += " active";
			var singleFilter = document.getElementById("filter"+count);
			singleFilter.value="";
			if(count == 1){
				singleMainCatg = categoryId;
			}
			if(selType == 'singleSelAll'){
				singleSelFiltersVal = "singleAll,";
			}
			//alert(singleSelFiltersVal);
			singleFilter.value = singleSelFiltersVal + categoryId;
			// make it false, once any category is selected
			keepAllSelected = false;
		}
		
		if(keepAllSelected){
			// to make All is selected, in case no other filter is selected
			var singleFilter = document.getElementById("filter1");
			singleFilter.value = window.searchAllQuery;
			selectAllCategory();
		}

		var totalFilters = document.getElementById("totalFilters");
		for(var j=1;j<=totalFilters.value;j++){
			var selectionType = document.getElementById("selectionType"+j);
			if(selectionType.value == 'single'){
				continue;
			}
			
			var multiSelFilters = document.getElementsByName("multiSelectBox"+j);
			var multiSelFiltersVal = "";
			var multiFilter = document.getElementById("filter"+j);
			for(var l=0;l<multiSelFilters.length;l++){
				if (multiSelFilters[l].checked) {
					multiSelFiltersVal = multiSelFiltersVal + multiSelFilters[l].value + ",";
				}
			}
			if(multiSelFiltersVal.trim() != ''){
				multiFilter.value = "multiselect," + multiSelFiltersVal;
			}else{
				multiFilter.value = "";
			}
		}
		
	var selectedCategories = "";
	var selFilters = document.getElementsByName("filterValues");
	for(var l=1;l<selFilters.length+1;l++){
		var selFiltersVal = document.getElementById("filter"+l);
		if(selFiltersVal != null && selFiltersVal.value.trim() != ""){
			selectedCategories = selectedCategories + selFiltersVal.value + "&&";
		}
	}
	// as safety measure, in case no search cateogry selected then send all search query which fetches all results
	if(selectedCategories.trim() == ''){
		selectedCategories = window.searchAllQuery;
		selectAllCategory();
	}
	A.io.request(reqUrl, {
		cache : false,
		sync : true,
		timeout : 1000,
		dataType : 'json',
		method : 'post',
		data : {
			selectedCategories : selectedCategories,
			action : action,
			pagination : pagination,
			searchText : searchText,
			singleMainCatg : singleMainCatg
		},
		sync : true,
		on : {
			success : function() {
				items = this.get('responseData');
				if(items.length > 0){
					for(key in items){
							var indItem = items[key];
							for(key in indItem){
								ldMoreDiv.style.display = "block";
									if(key == "resultHtml"){
										if(indItem[key] != '[]'){
											paginationDiv.value =parseInt(pagination,10)+ parseInt(totalDisplayResults,10);
											if(selType == 'loadMore'){
												var existingHtml = document.getElementById("webContent-searchResults").innerHTML;
												document.getElementById("webContent-searchResults").innerHTML = existingHtml+ indItem[key];
											}else{
												document.getElementById("webContent-searchResults").innerHTML = indItem[key];
											}
										}else{
											if(selType != 'loadMore'){
												var mainVocName = document.getElementById("firstFilterName").value;
												var noResultMsg = "There are no matching " + mainVocName +" under your selection. Please modify your search or feel free to browse all " + mainVocName + ".";
												document.getElementById("webContent-searchResults").innerHTML = noResultMsg;
												ldMoreDiv.style.display = "none";
											}else{
												ldMoreDiv.style.display = "none";
											}	
										}		
									}
									else if(key == "catgHtml")	{
										catgDescDiv = document.getElementById("searchFilter-Category");
										if((indItem[key].length > 79)){
											catgDescDiv.removeAttribute('class');
											catgDescDiv.innerHTML = indItem[key];
											catgDescDiv.style.display = "block";
										}
										//if((categoryId == 'UrlParameterSearch')){
											//catgDescDiv.style.display = "block";
										//}
										
								}else if(key == "showLoadmore"){
									if(indItem[key]){
										ldMoreDiv.style.display = "block";
									}else{
										ldMoreDiv.style.display = "none";
									}
								}
								
						}
					}
					//alert("singleSelFiltersVal" + singleSelFiltersVal);
					if((singleSelFiltersVal == 'singleSelAll') || (singleSelFiltersVal == 'singleAll,')){
						document.getElementById("searchFilter-Category").style.display = "none";
					}
				}
			}
		}
	});
}


function searchByUrlParameter(){
	var ldMoreDiv = document.getElementById("pagination_next");
	ldMoreDiv.setAttribute("onclick","javascript:startSearch('','loadMore','')");
	var textSearchDiv = document.getElementById("textSearch");
	textSearchDiv.setAttribute("onclick","javascript:startSearch('','textSearch','')");
	var textSearchip = document.getElementById("openSearchText");
	textSearchip.setAttribute("onKeyDown","if(event.keyCode==13) startSearch('','textSearch','')");
	var paginationDiv =  document.getElementById("paginationValue");
	var pagination = paginationDiv.value;
	var totalDisplayResults =  document.getElementById("totalDisplayResults").value;
	paginationDiv.value =parseInt(pagination,10)+ parseInt(totalDisplayResults,10);
}

function categoryViewAll(k){
	var hiddenLi = document.getElementsByClassName("filter"+k);
	for(var i=0;i<hiddenLi.length;i++){
		hiddenLi[i].style.display = "block";
	}
	var viewAllDiv = document.getElementById("viewAll"+k);
	viewAllDiv.style.display = "none";
}

YUI().ready('node','event','anim', function(Y){
	var filterBtn = Y.one('.filter-btn');
	if(filterBtn){
		filterBtn.on('click', function(e){
			var filterSection = Y.one('.webContent-searchFilters');
			var targ = e.currentTarget;
			if(filterSection){
				targ.toggleClass('active-filter');
				filterSection.toggleClass('active-filter');
			}
		});
	}
});

</script>

<c:if test="${!searchDefaultResult}">
<script>
	searchByUrlParameter();
</script>
</c:if>

<c:if test="${searchDefaultResult}">
<aui:script>
AUI().ready('aui-base', 'aui-io-request', function(A) {
	initSearch();
});
</aui:script>
</c:if>
