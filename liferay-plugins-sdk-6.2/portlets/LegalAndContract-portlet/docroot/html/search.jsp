<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page import="java.util.*"%>

<portlet:defineObjects />
<liferay-theme:defineObjects />
<portlet:actionURL var="searchURL" name="search">
	<portlet:param name="fromPage" value="search" />
</portlet:actionURL>
<portlet:renderURL portletMode="view" var="viewURL" />
<portlet:resourceURL var="resourceURL" id="myResourceID01" />

<%
	// resource url holds the old parameters used while searching, 
	// if params are changed and 'Export' is used the conditions for 'search' are passed on 
	//resourceURL = resourceURL.replaceAll("_" + portletDisplay.getId() + "_" + "searchField", "dummy");
	//resourceURL = resourceURL.replaceAll("_" + portletDisplay.getId() + "_" + "list", "dummy");
	resourceURL = resourceURL.replaceAll("_" + portletDisplay.getId() + "_" + "searchQueryJson", "dummy");
%>

<div class="esn_searchSection_wrap">
	<div class="searchSection_title">
		<a href="#"><span class="field-label"><%= LanguageUtil.get(pageContext,"search")%></span></a>
	</div>
	<div id="hiddenCriteriaRow" style='display:none'>
		<div id='searchCriteriaRow'>
					<div class="searchFieldDd" style="vertical-align:top;">
						<aui:select name="searchField" label="">
							<aui:option value="">--Search By--</aui:option>
							<c:forEach var="sf" items="${sfs}">
								<c:if test="${sf.type == 1 }">
									<aui:option value="${sf.key}" label="${sf.title}" />
								</c:if>	
								<c:if test="${sf.type == 2 ||  sf.type == 3}">
									<aui:option value="list_${sf.key}" label="${sf.title}" />
								</c:if>	
								<c:if test="${sf.type == 4}">
									<aui:option value="date_${sf.key}" label="${sf.title}" />
								</c:if>	
							</c:forEach>
						</aui:select>
					</div>
					<div id="searchFieldValueDiv" class="searchFieldValueDiv" style="vertical-align: text-bottom;">
						<div class="searchFieldText" id="searchFieldTextDiv">
							<aui:input type="text" name="searchValue" id="searchValue"
								class="searchValue" label="" size="100">
							</aui:input>
							<aui:input type="hidden" name="counter" id="counter"/>
						</div>
						<div id="dateRangeSection">
								<div id="fromDateDiv">
									<label class="field-label"><%= LanguageUtil.get(pageContext,"from")%>:</label>
									<liferay-ui:input-date 
										dayParam="fromDay" monthParam="fromMonth" yearParam="fromYear" 	disabled="false" nullable="true"
										name="fromDate"/>
										
								</div>	
								<div id="toDateDiv">
									<label class="field-label"><%= LanguageUtil.get(pageContext,"to")%>: </label>
									<liferay-ui:input-date 
										dayParam="toDay" monthParam="toMonth" yearParam="toYear" nullable="true"
										name="toDate"
										/>
								</div>	
						</div>
						<c:forEach var="sf" items="${sfs}">
							<c:if test="${sf.categoryField }">
								<aui:select name="list_${sf.key }" label="">
									<c:forEach var="cats" items="${requestScope[sf['listId']]}">
										<aui:option value="${cats.categoryId}" label="${cats.name}" />
									</c:forEach>
								</aui:select>
							</c:if>
							<c:if test="${sf.dropdownField }">
								<aui:select name="list_${sf.key }" label="">
									<c:forEach var="cats" items="${requestScope[sf['listId']]}">
										<aui:option value="${cats.key}" label="${cats.value}" />
									</c:forEach>
								</aui:select>
							</c:if>
						</c:forEach>
					</div>
					<div class="searchFieldCriteria">
						<a id='addCriteria' href="javascript:;">+</a>
					</div>
				</div>
	</div>
	<div class="esn_searchSection" id="esn_searchSection">
		<div class="esn_searchSection_content" id="esn_searchSection_content">
			<aui:form name="searchForm" action="<%=searchURL%>">
				<aui:input type="hidden" name="searchQueryJson"	 value="<%= renderRequest.getParameter(\"searchQueryJson\") %>"/>
				<aui:fieldset>
					<div id="searchContainer">
					</div>
					<aui:button-row>
						<aui:button type="submit" name="submitSearch" id="submitSearch"
							value='<%= LanguageUtil.get(pageContext,"search")%>' label=""/>
						<aui:button type="cancel" name="clearSearch" id="clearSearch"
							value='<%= LanguageUtil.get(pageContext,"clear.search")%>' label="" onClick="<%=viewURL%>" />
						<c:if test="${ showExports}">
							<aui:button type="button" name="export" id="export"
								value='<%= LanguageUtil.get(pageContext,"export.pdf")%>' label="" />
							<aui:button type="button" name="exportXls" id="exportXls"
								value='<%= LanguageUtil.get(pageContext,"export.xls")%>' label="" />
						</c:if>
					</aui:button-row>
				</aui:fieldset>
			</aui:form>
		</div>
	</div>

</div>
<script type="text/javascript" src="/LegalAndContract-portlet/js/search.js"></script>

<script>
var portletNs = "<portlet:namespace/>";
var ajaxUrl = "<%=resourceURL%>";
/*showhidesearchValObj(portletNs);
initializeSearchFields(portletNs);*/
var searchObj = new trademarksSearch({pns:portletNs,ajaxUrl:ajaxUrl});
</script>

<script>
var temp_search_content_height;	
var height_tobe_set;
	
YUI().use('event-hover','node', 'transition', 'event', 'animation', function (Y) {
		
	var search_content = Y.one('.esn_searchSection_content');
	var search_content_wrap = Y.one('.esn_searchSection');
	var search_content_height = search_content.get('offsetHeight') + 'px';
	var clicked = false;
	
	//console.log("ID: "+test_content.get('id') + " - Height: " +test_content_height);
	
	
	
	var search_content_cta = Y.one('.searchSection_title a');
	
	search_content_cta.on('click', revealContent);
	
	var searchFieldDd = Y.one('.searchFieldDd select');
	var searchFieldValue = searchFieldDd.get('value');
	var searchTextValue = Y.one('.searchFieldText input');
	
	searchFieldDd.on('change',searchFieldState);
	
	
	
	if(searchFieldValue != ""){
		searchTextValue.toggleClass('searchText_active');
	}
	else{
		searchTextValue.toggleClass('searchText_active');
	}
	
	function searchFieldState(){
		if(searchFieldDd.get('value') != ""){
			//console.log("Field Changed: " +searchFieldDd.get('value'));
			searchTextValue.toggleClass('searchText_active');
			search_content_wrap.setStyle('height','auto');
			temp_search_content_height = search_content_wrap.get('offsetHeight') + 'px';
		}
		else{
			//console.log("Field Changed: None");
			searchTextValue.removeClass('searchText_active');
			searchTextValue.setStyle('display','none');
		}
	}
	
	function revealContent(e){
		//e.preventDefault();
		search_content_cta.toggleClass('search_clicked');
		search_content_height = search_content.get('offsetHeight') + 'px';
		//console.log('REVEAL! :' +search_content_wrap.get('id') + "; height: " +search_content_height);
		if(!clicked){
			clicked = true;
			
			
			search_content_wrap.transition({
					easing: 'ease-out',
					height: 'auto',
					duration: 0.5
			});
			
			//temp_search_content_height = search_content_wrap.get('offsetHeight') + 'px';
			temp_search_content_height = search_content_height;
			//console.log('Expand: temp_search_content_height: '+temp_search_content_height );
		}
		else{
			clicked = false;
			
			search_content_height = temp_search_content_height;
			//console.log('Collapsed: temp_search_content_height: '+search_content_height );
			search_content_wrap.transition({
					easing: 'ease-out',
					height: 0,
					duration: 0.5
			});
		}
		
	}

	
	try{
		
		AUI().use('aui-node','aui-base', function(A){
			var searchVal = A.one("#" + portletNs + "searchQueryJson").val();
			if(searchVal && searchVal != ""){
				revealContent();
			}
		});
	}catch(err){
		console.log(err);
	}
	
});
	
</script>
