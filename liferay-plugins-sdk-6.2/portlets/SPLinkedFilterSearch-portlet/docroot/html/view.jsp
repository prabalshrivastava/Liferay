<%@ include file="/html/init.jsp" %>

<section class="webContent-search-wrap" id="mainSection">
	<div class="webContent-search-wrap-content screen-max-width">
		<div class="searchHeader padding-top-one padding-bottom-one">
			<div class="searchHeaderText inline-block text-left align-middle">
				<h1 class="margin-none">Make yourself future ready</h1>
			</div>
			<div class="openSearch inline-block text-right font-none searchField align-middle" id="openSearch">
				<input type="text" id="openSearchText" placeholder="Search Course Information" class="font-std" >
				
				<div class="search-btn" id="textSearchButton">
					<input type="button" value="Search">
				</div>
				
				<div class="filter-btn">
					
				</div>
			</div>
		</div>
		<div class="webContent-search-content block">
			<div class="aui-helper-clearfix webContent-searchFilters font-10" id="webContent-searchFilters" >
				<div class="searchFilters-list" id="linkedFilters-list">
				</div>
				<div class="searchFilters-list" id="ivdFilters-list">
				</div>
			</div>
			<div class="webContent-searchResultsMainDiv webContent-searchResults-wrap font-std">
			   <div id="topicHeader" class="hide"> 
			   		<div class="searchFilter-Category">
			   			<div class="selectedCatgName" id="headerCatgName"></div>
			   			<div class="selectedCatgDesc" id="headerCatgDesc"></div>
			   			<div class="selectedCatgUrl" id="headerCatgUrl"><a href="javascript:;"><span>Learn More</span></a></div>
			   		</div>
			   </div>
			   <div class="aui-helper-clearfix webContent-searchResults" id="searchResults">
			   </div>
			   <div class="search-loadMore hide" id="loadmoreContainer">
					<div title="Next" class="as-stream-loadmore link" id="loadMore">
						Load More
					</div>
		       </div>
			</div>
		</div>
		
	</div>
</section>
<div class="hide"><!-- All samples are here in this div -->
	<div id="sampleFilterContainer" class="filter-category-item padding-top-half">
		<div class="searchFilter-title group-title-2" id="name"></div>
		<ul id="list">
			
		</ul>
	</div>
	<ul>
		<li class="block pointer" id='sampleItemFilterSingle'> <!-- sample filter sinle selection -->
			<a href="javascript:;" class="link" id="item">
				<span id="name"></span>
			</a>	
		</li>
		<li id='sampleItemFilterMultiple'>  <!-- sample filter item type multi selection allowed -->
			<input type="checkbox"  name="item"  id="item">
			<span class="checkbox-label" id="name"></span>
		</li>
	</ul>
	<div class="search-stream-mosaic-block-content block" id="searchResult"> <!-- Sample filter result -->
		<div class="wcResult-stream-item block aui-helper-clearfix">
			<div class="wcResult-image align-top relative overflow-hidden">
				<a title="" href="javascript:;" class="block" id="imgLink">
					<img alt="logo" title="" src="" class="" id="logo">
				</a>
			</div>
			<div class="wcResult-body align-top relative">
					<div class="wcResult-header">
						<a title="" href="javascript:;" class="wcResult-title link" id="titleLink"></a>
						
						<div class="wcResult-provider-wrap text-right">
							<div class="wcResult-provider text-right">
								<img src="" class="wcResult-logo block" id="frameworkLogo" alt="Logo">
							</div>
							<div class="wcResult-type block" id="type"></div>
						</div>
					</div>
					<div class="wcResult-desc" id="desc"></div>
					<div class="wcResult-details font-none block">
							<div class="wcResult-size inline-block">
								<span id="moduleCount"></span>
								<span class="detail-label" id="moduleLabel"></span>
							</div>
						<div class="wcResult-splz inline-block" id="specialization"></div>
						<div class="wcResult-duration inline-block">
								<span class="detail-label" id="duration"></span>
								<span class="detail-label" id="durationUnit"></span>
							</div>
					</div>
			</div>
			<div class="wcResult-desc wcResult-mobile" id="mobiledesc"></div>
		</div>
	</div>
	
</div>
<%
String levelsData = GetterUtil.getString(portletPreferences.getValue("levelsData", "[]"));
if(Validator.isNull(levelsData)){
	levelsData = "[]";
}
boolean enableLinkedFilter = GetterUtil.getBoolean(portletPreferences.getValue("enableLinkedFilter", "false"));
boolean enableIvdFilter = GetterUtil.getBoolean(portletPreferences.getValue("enableIvdFilter", "false"));
String filtersFrmUrl = (String)request.getAttribute("filtersFrmUrl");
if(Validator.isNull(filtersFrmUrl)){
	filtersFrmUrl  = "{}";
}
%>
<liferay-portlet:resourceURL  var="ajaxUrl">
</liferay-portlet:resourceURL>
<script src="/SPLinkedFilterSearch-portlet/js/linkedSearch.js?t=1"></script>
<script>
var A;
var searchObj = null;
AUI().use('aui-node','aui-io-request', 'liferay-util-window','aui-io-plugin-deprecated','stylesheet',function(A1){
	A = A1;
	var pns ="<portlet:namespace/>";
	var ajaxUrl = "<%= ajaxUrl %>";
	searchObj = new LinkedSearch( { pns:pns, ajaxUrl:ajaxUrl,levelsData:<%=levelsData%>,
								    linkedFiltersEnabled:<%=enableLinkedFilter %>,
									ivdFiltersEnabled:<%=enableIvdFilter%>,
									filtersFrmUrl:<%=filtersFrmUrl%>});
});


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
