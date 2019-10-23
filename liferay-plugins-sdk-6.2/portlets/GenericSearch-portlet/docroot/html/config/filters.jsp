
<%@page import="com.liferay.portal.kernel.search.Field"%>
<%@page import="com.sambaash.platform.genericsearch.model.GenericSearchFilter"%>
<%@page import="com.sambaash.platform.genericsearch.model.GenericSearchConfig"%>
<%@page import="com.liferay.portal.security.auth.AuthTokenUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.portlet.DefaultConfigurationAction"%>
<%@page import="com.liferay.portlet.asset.model.AssetVocabulary"%>
<%@page import="com.liferay.portlet.asset.service.AssetVocabularyLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.Arrays"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.sambaash.platform.genericsearch.GenericSearchConstants"%>
<%@page import="com.sambaash.platform.genericsearch.helper.GenericSearchAPIRegistry"%>
<%@page import="com.sambaash.platform.genericsearch.model.GenericSearchAPIModel"%>
<%@page import="com.sambaash.platform.genericsearch.helper.GenericSearchAPIHelper"%>
<%@page import="com.liferay.portal.kernel.log.Log" %>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util"%>

<portlet:defineObjects />
<liferay-theme:defineObjects />

<portlet:resourceURL var="resourceUrl">
</portlet:resourceURL>

<h4 class="margin-bottom-half">
	<liferay-ui:message key="configure-search-filters" />
</h4>

<%
String hideFiltersName = DefaultConfigurationAction.PREFERENCES_PREFIX + GenericSearchConstants.PREF_HIDE_FILTERS + StringPool.DOUBLE_DASH;
String hideFilters = portletPreferences.getValue(GenericSearchConstants.PREF_HIDE_FILTERS, "Off");
String disableUnwantedFiltersName = DefaultConfigurationAction.PREFERENCES_PREFIX + GenericSearchConstants.PREF_DISABLE_UNWANTED_FILTERS + StringPool.DOUBLE_DASH;
String disableUnwantedFilters = portletPreferences.getValue(GenericSearchConstants.PREF_DISABLE_UNWANTED_FILTERS, "Off");
String disableTextSearchName = DefaultConfigurationAction.PREFERENCES_PREFIX + GenericSearchConstants.PREF_DISABLE_TEXT_SEARCH + StringPool.DOUBLE_DASH;
String disableTextSearch = portletPreferences.getValue(GenericSearchConstants.PREF_DISABLE_TEXT_SEARCH, "Off");
String filterPlacementName = DefaultConfigurationAction.PREFERENCES_PREFIX + GenericSearchConstants.PREF_FILTER_PLACEMENT + StringPool.DOUBLE_DASH;
String filterPlacement = portletPreferences.getValue(GenericSearchConstants.PREF_FILTER_PLACEMENT, "On");
String filtersLabelName = DefaultConfigurationAction.PREFERENCES_PREFIX + GenericSearchConstants.PREF_FILTER_LABEL + StringPool.DOUBLE_DASH;
String filtersLabel = portletPreferences.getValue(GenericSearchConstants.PREF_FILTER_LABEL, GenericSearchConstants.DEFAULT_FILTER_LABEL);
String customColorMapName = DefaultConfigurationAction.PREFERENCES_PREFIX + GenericSearchConstants.PREF_CUSTOM_COLOR_MAP + StringPool.DOUBLE_DASH;
String customColorMap = portletPreferences.getValue(GenericSearchConstants.PREF_CUSTOM_COLOR_MAP, GenericSearchConstants.DEFAULT_CUSTOM_COLOR_MAP);
String compFilteringName = DefaultConfigurationAction.PREFERENCES_PREFIX + GenericSearchConstants.PREF_COMP_FILTERING + StringPool.DOUBLE_DASH;
String compFiltering = portletPreferences.getValue(GenericSearchConstants.PREF_COMP_FILTERING, "Off");
String dateFilteringName = DefaultConfigurationAction.PREFERENCES_PREFIX + GenericSearchConstants.PREF_DATE_FILTERING + StringPool.DOUBLE_DASH;
String dateFiltering = portletPreferences.getValue(GenericSearchConstants.PREF_DATE_FILTERING, "Off");
String dateFilteringFieldName = DefaultConfigurationAction.PREFERENCES_PREFIX + GenericSearchConstants.PREF_DATE_FILTERING_FIELD + StringPool.DOUBLE_DASH;
String dateFilteringField = portletPreferences.getValue(GenericSearchConstants.PREF_DATE_FILTERING_FIELD, Field.CREATE_DATE);
String clearFiltersOnTextSearchName = DefaultConfigurationAction.PREFERENCES_PREFIX + GenericSearchConstants.PREF_CLEAR_FILTERS_TEXTSEARCH + StringPool.DOUBLE_DASH;
String clearFiltersOnTextSearch = portletPreferences.getValue(GenericSearchConstants.PREF_CLEAR_FILTERS_TEXTSEARCH, "Off");
String freeTextSearchName = DefaultConfigurationAction.PREFERENCES_PREFIX + GenericSearchConstants.PREF_FREE_TEXT_SEARCH + StringPool.DOUBLE_DASH;
String freeTextSearch = portletPreferences.getValue(GenericSearchConstants.PREF_FREE_TEXT_SEARCH, GenericSearchConstants.PARTIAL_MATCH);
//List<AssetVocabulary> vocabs = AssetVocabularyLocalServiceUtil.getGroupVocabularies(scopeGroupId);
GenericSearchAPIRegistry registry = GenericSearchAPIRegistry.instance;
GenericSearchAPIModel apiModel = null;
Set<String> apiKeys = registry.getAPIKeySet();
String apiHelperStr = GenericSearchAPIHelper.getAPIModel().toString();
List<AssetVocabulary> vocabs = AssetVocabularyLocalServiceUtil.getGroupVocabularies(scopeGroupId);
%>

<aui:row>
	<aui:col span="6">
		<aui:select name="<%=hideFiltersName%>" label="<%=GenericSearchConstants.PREF_HIDE_FILTERS%>"
			required="true" value="<%=hideFilters%>">
			<aui:option label="yes" value="On"
				selected='<%="On".equalsIgnoreCase(hideFilters)%>' />
			<aui:option label="no" value="Off"
				selected='<%="Off".equalsIgnoreCase(hideFilters)%>' />
		</aui:select>
	</aui:col>
	<aui:col span="6">
		<aui:select name="<%=disableUnwantedFiltersName%>"
			label="<%=GenericSearchConstants.PREF_DISABLE_UNWANTED_FILTERS%>" required="true"
			value="<%=disableUnwantedFilters%>">
			<aui:option label="yes" value="On"
				selected='<%="On".equalsIgnoreCase(disableUnwantedFilters)%>' />
			<aui:option label="no" value="Off"
				selected='<%="Off".equalsIgnoreCase(disableUnwantedFilters)%>' />
		</aui:select>
	</aui:col>
</aui:row>
<aui:row>
	<aui:col span="6">
		<aui:select name="<%=disableTextSearchName%>"
			label="<%=GenericSearchConstants.PREF_DISABLE_TEXT_SEARCH%>" required="true"
			value="<%=disableTextSearch%>">
			<aui:option label="On" value="On"
				selected='<%="On".equalsIgnoreCase(disableTextSearch)%>' />
			<aui:option label="Off" value="Off"
				selected='<%="Off".equalsIgnoreCase(disableTextSearch)%>' />
		</aui:select>
	</aui:col>
	<aui:col span="6">
		<aui:select name="<%=filterPlacementName%>"
			label="<%=GenericSearchConstants.PREF_FILTER_PLACEMENT %>" required="true" value="<%=filterPlacement%>">
			<aui:option label="Left" value="On"
				selected='<%="On".equalsIgnoreCase(filterPlacement)%>' />
			<aui:option label="Top" value="Off"
				selected='<%="Off".equalsIgnoreCase(filterPlacement)%>' />
		</aui:select>
	</aui:col>
</aui:row>
<aui:row>
	<aui:col span="6">
		<aui:select name="<%=clearFiltersOnTextSearchName%>"
			label="<%=GenericSearchConstants.PREF_CLEAR_FILTERS_TEXTSEARCH%>"
			required="true" value="<%=clearFiltersOnTextSearch%>">
			<aui:option label="Yes" value="On"
				selected='<%="On".equalsIgnoreCase(clearFiltersOnTextSearch)%>' />
			<aui:option label="No" value="Off"
				selected='<%="Off".equalsIgnoreCase(clearFiltersOnTextSearch)%>' />
		</aui:select>
	</aui:col>
	<aui:col span="6">
		<aui:select name="<%=compFilteringName%>"
			label="<%=GenericSearchConstants.PREF_COMP_FILTERING%>"
			required="true" value="<%=compFiltering%>">
			<aui:option label="On" value="On"
				selected='<%="On".equalsIgnoreCase(compFiltering)%>' />
			<aui:option label="Off" value="Off"
				selected='<%="Off".equalsIgnoreCase(compFiltering)%>' />
		</aui:select>
	</aui:col>
</aui:row>
<aui:row>
	<aui:col span="6">
		<aui:input name="<%=filtersLabelName%>"
			label="<%=GenericSearchConstants.PREF_FILTER_LABEL%>" type="text"
			value="<%=filtersLabel%>" />
	</aui:col>
	<aui:col span="6">
		<aui:select name="<%=freeTextSearchName%>"
			label="<%=GenericSearchConstants.PREF_FREE_TEXT_SEARCH%>"
			required="true" value="<%=freeTextSearch%>">
			<aui:option label="Partial Match" value="<%=GenericSearchConstants.PARTIAL_MATCH%>"
				selected='<%=GenericSearchConstants.PARTIAL_MATCH.equalsIgnoreCase(freeTextSearch)%>' />
			<aui:option label="Exact Match" value="<%=GenericSearchConstants.EXACT_MATCH%>"
				selected='<%=GenericSearchConstants.EXACT_MATCH.equalsIgnoreCase(freeTextSearch)%>' />
		</aui:select>
	</aui:col>
</aui:row>
<aui:row>
	<aui:col span="6">
		<aui:select name="<%=dateFilteringName%>" id="dateFilteringId"
			label="<%=GenericSearchConstants.PREF_DATE_FILTERING%>"
			required="true" value="<%=dateFiltering%>" onChange="onChangeDateFilterConfig(this)">
			<aui:option label="On" value="On"
				selected='<%="On".equalsIgnoreCase(dateFiltering)%>' />
			<aui:option label="Off" value="Off"
				selected='<%="Off".equalsIgnoreCase(dateFiltering)%>' />
		</aui:select>
	</aui:col>
	<aui:col span="6" id="dateFilteringFieldNameId">
		<aui:select name="<%=dateFilteringFieldName%>"
			label="<%=GenericSearchConstants.PREF_DATE_FILTERING_FIELD%>"
			required="true" value="<%=dateFilteringField%>">
			<aui:option label="Create Date" value="<%=Field.CREATE_DATE%>"
				selected='<%=Field.CREATE_DATE.equalsIgnoreCase(dateFilteringField)%>' />
			<aui:option label="Modified Date" value="<%=Field.MODIFIED_DATE%>"
				selected='<%=Field.MODIFIED_DATE.equalsIgnoreCase(dateFilteringField)%>' />
			<aui:option label="Display Date" value="displayDate"
				selected='<%="displayDate".equalsIgnoreCase(dateFilteringField)%>' />
		</aui:select>
	</aui:col>
</aui:row>
<aui:row>
	<aui:col span="12">
		<aui:input name="<%=customColorMapName%>"
			label="<%=GenericSearchConstants.PREF_CUSTOM_COLOR_MAP%>" type="textarea" rows="5"
			value="<%=customColorMap%>" style="width:95%;"/>		
	</aui:col>
</aui:row>

<div class="generic-search-main-wrapper">
<div class="border-all white-bg padding-half" style="border-radius: 6px">
	<h4 class="margin-bottom-half">
		<liferay-ui:message key="configure-search-filters-common" />
	</h4>
	<div class="border-all padding-half bg-custom-color-4 margin-bottom-half" style="border-radius: 6px;">
		<h5 class="margin-bottom-half">COMMON<button onclick="javascript:return addFilterOnBClick('common');" style="float:right" type="button">Add Filter</button> </h5>
		<div class="bg-white border-all padding-half padding-bottom-quarter container-common hide">
			
		</div>
	</div>
</div>
<div class="border-all white-bg padding-half margin-top-half" style="border-radius: 6px">
	<h4 class="margin-bottom-half">
		<liferay-ui:message key="configure-search-filters-component" />
	</h4>
	<%
		String selected = GetterUtil.getString(portletPreferences.getValue(
				GenericSearchConstants.PREF_ENABLED_COMPONENTS, ""));
		List<String> classes = Arrays.asList(selected.split(","));
		for (String clazz : classes) {
			String name = LanguageUtil.get(pageContext, clazz).toLowerCase();
			try {
	%>
	<div class="component-row-wrapper border-all padding-half bg-custom-color-4 margin-bottom-half" style="border-radius: 6px;" data="<%=clazz%>">
		<h5 class="margin-bottom-half"><%=name.toUpperCase() %><button onclick="javascript:return addFilterOnBClick('<%=name%>');" style="float:right" type="button">Add Filter</button> </h5>
		<div class="bg-white border-all padding-half padding-bottom-quarter container-<%=name%> hide">
		</div>
	</div>
	<%
			} catch (Exception e) {
				_log.error(e.getMessage());
			}
		}
	%>
</div>
</div>

<style>
.aui .generic-search-main-wrapper .control-group{
	margin-bottom: 10px;
}
.aui select.select-opr,.aui select.select-count, .aui select.select-type {
	width : 115px;
}
.aui select.select-vocab, .aui select.select-field {
	width : 180px;
}
.aui select.select-fieldVocabulary, .aui select.select-field {
	width : 180px;
}
.filter-selector div {
	margin-right: 8px;
}
</style>


<div id = "sample-filter-selector" class="hide">
	<div class="filter-selector-row padding-top-quarter" id="rowID">
		<div class="filter-selector">
			<aui:input name="preferences--filter--filterId--rowID--" type="hidden" cssClass="select-filterId"></aui:input>
			<aui:select cssClass="select-1 select-type" name="preferences--filter--type--rowID--" label="select-filter-type" showEmptyOption="true" inlineField="true" onChange="typeSelect(this)">
				<aui:option value="<%=GenericSearchFilter.TYPE_VOCAB %>" label="label.vocabulary" data-selector="select-vocab"/>
				<aui:option value="<%=GenericSearchFilter.TYPE_TAG %>" label="label.tag" data-selector="select-tag"/>
				<aui:option value="<%=GenericSearchFilter.TYPE_FIELD %>" label="label.field" data-selector="select-field"/>
			</aui:select>
			
			<div class="sel select-2 select-count hide inline-block">
				<aui:select cssClass="select-count" name="preferences--filter--count--rowID--" label="select-count" onChange="countSelect(this)">
					<aui:option label="notapplicable" value="<%=StringPool.BLANK %>"></aui:option>
					<aui:option label="ratings" value="<%=GenericSearchFilter.SELECT_RATINGS %>"></aui:option>
					<aui:option label="dates" value="<%=GenericSearchFilter.SELECT_DATES %>"></aui:option>
					<aui:option label="vocabularies" value="<%=GenericSearchFilter.SELECT_VOCABULARIES %>"></aui:option>
					<aui:option label="api" value="<%=GenericSearchFilter.SELECT_API %>"></aui:option>
					<aui:option label="agerange" value="<%=GenericSearchFilter.SELECT_AGERANGE %>"></aui:option>
				</aui:select>
			</div>
			
			<div class="sel select-10 select-selection hide inline-block">
				<aui:select cssClass="select-selection" name="preferences--filter--selection--rowID--" label="select-selection" >
					<aui:option label="single" value="<%=GenericSearchFilter.SELECT_SINGLE %>"></aui:option>
					<aui:option label="multiple" value="<%=GenericSearchFilter.SELECT_MULTIPLE %>"></aui:option>
				</aui:select>
			</div>
			
			<div class="sel select-12 select-apiList hide inline-block">
				<aui:select cssClass="select-apiList" name="preferences--filter--apiList--rowID--" label="select-apiList" onChange="changeApi(this)" >
					<%for(String apiKey : apiKeys) {
					
						apiModel = registry.getAPIModel(apiKey); %>
						<aui:option label="<%=apiModel.getTitle() %>" value="<%=apiKey %>"></aui:option>
					<%}%>
				</aui:select>
			</div>
			
			<div class="sel select-11 select-config hide inline-block">
					<aui:input type="textarea" cssClass="select-config width-85" label="select-config" name="preferences--filter--config--rowID--" style="height: 11px;"></aui:input>
			</div>
			
			<div class="sel select-13 select-vocab hide inline-block">
				<aui:select cssClass="select-vocab" name="preferences--filter--vocab--rowID--" label="select-vocab" >
					<%for(AssetVocabulary vocab : vocabs) {%>
						<aui:option label="<%=vocab.getName()%>" value="<%=vocab.getVocabularyId() %>"></aui:option>
					<%}%>
				</aui:select>
			</div>
			<div class="sel select-3 select-field hide inline-block">
				<aui:select cssClass="select-field" name="preferences--filter--field--rowID--" label="select-field" >
				</aui:select>
			</div>
			<div class="sel select-5 select-opr hide inline-block">
				<aui:select cssClass="select-opr" name="preferences--filter--opr--rowID--" label="select-opr" >
					<aui:option value="eq" label="="/>
					<aui:option value="ne" label="&ne;"/>
					<aui:option value="lt" label="&lt;"/>
					<aui:option value="gt" label="&gt;"/>
					<aui:option value="le" label="&le;"/>
					<aui:option value="ge" label="&ge;"/>
					<aui:option value="bt" label="label-between"/>
					<aui:option value="contains" label="label-contains"/>
				</aui:select>
			</div>
			
			<div class="sel select-14 select-level hide inline-block">
				<aui:input cssClass="select-level" name="preferences--filter--level--rowID--" label="select-level" style="height: 11px;"></aui:input>
			</div>
			
			<div class="sel select-6 select-values hide inline-block">
				<aui:input cssClass="select-values" name="preferences--filter--values--rowID--" label="select-values" style="height: 11px;"></aui:input>
			</div>
			
			<div class="sel select-7 select-label hide inline-block">
				<aui:input cssClass="select-label width-85" label="select-label" name="preferences--filter--label--rowID--" style="height: 11px;"></aui:input>
			</div>
			
			<div class="sel select-8 select-position hide inline-block">
				<aui:input cssClass="select-position width-40" label="select-position" name="preferences--filter--position--rowID--" style="height: 11px;"></aui:input>
			</div>
			
			<div class="sel select-9 select-position hide inline-block">
				<aui:select cssClass="select-fieldVocabulary" name="preferences--filter--fieldVocabulary--rowID--" label="select-fieldVocabulary" >
					<%for(AssetVocabulary vocab : vocabs) {%>
						<aui:option label="<%=vocab.getName()%>" value="<%=vocab.getVocabularyId() %>"></aui:option>
					<%}%>
				</aui:select>
			</div>
			<div class="sel select-4 select-display hide inline-block">
				<aui:input cssClass="select-display" name="preferences--filter--display--rowID--" type="checkbox" label="should-display-filter" onChange="displaySelect(this)"/>
			</div>
			
			
			<div style="float:right">
				<liferay-ui:icon-delete id="deleteIcon" url="javascript:deleteRow('rowID');" confirmation="really-delete"></liferay-ui:icon-delete>
			</div>
		</div>
		<div class="error-row font-8 hide"></div>
	</div>
</div>


<script>
var filterId = 1000;
var A = AUI().use('aui-node', 'aui-base','aui-io-request-deprecated','liferay-util-window','aui-io-plugin-deprecated','liferay-portlet-url');

function addFilterOnBClick(component) {
	var rowId = addFilter(component);
	var sampleNode = A.one('.container-' + component + " #" + rowId);
	fireChangeEvents(sampleNode);
	return sampleNode;
}

function addFilter(component) {
	filterId = filterId + 100;
	var container = A.one('.container-' + component);
	var currentCount = container.all('.filter-selector-row').size();
	// add new node
	var sampleNode = A.one('#sample-filter-selector .filter-selector-row').clone();
	var newId = component + '_' + (currentCount+1);
	if (currentCount+1 >= 2)
		sampleNode.addClass('border-top');
	
	// fix delete names/icon link
	/* var jsParams = "'" + component + "'" + ',' + (currentCount+1);
	var deleteicon = sampleNode.one('#<portlet:namespace />deleteIcon');
	deleteicon.setAttribute('href', deleteicon.getAttribute('href').replace('deleteParams', jsParams)); */
	// remove field for common
	if (component == 'common') {
		sampleNode.one('.select-type').one("option[value='field']").remove();
	}
	sampleNode.one(".select-filterId").val(filterId);
	var htmlCode = sampleNode.get('outerHTML');
	htmlCode = htmlCode.replace(/rowID/g, newId);
	container.append(htmlCode);
	container.removeClass("hide");
	return newId;
}

function fireChangeEvents(sampleNode){
	// To show/hide the fields correctly
	try{
		  var typed = sampleNode.one(".select-type");
		  var typeDN = typed.getDOMNode();
		  typeSelect(typeDN);
		  
		  var countd = sampleNode.one(".select-count");
		  var coundDN = countd.getDOMNode();
		  countSelect(coundDN);
	}catch(err){
		console.log(err);
	}
}

function changeApi(obj){
	var selectedVal = A.one(obj).val();
	var apiDetails = <%=apiHelperStr%>;
	
	for(var inx=0;inx<apiDetails.length;inx++){
		if (selectedVal == apiDetails[inx].apiKey){
			var row = A.one(obj).ancestor('.filter-selector-row');
			row.one('.select-config').one('textarea').val(apiDetails[inx].defaultSettings);
		}
	}
}

function deleteRow(rowID) {
	var component = rowID.split('_')[0];
	var id = rowID.split('_')[1];
	A.one("#" + rowID).remove();
	var container = A.one('.container-' + component);
	var currentCount = container.all('.filter-selector-row').size();
	if (currentCount == 0)
		container.addClass("hide");
	return 0;
}

function typeSelect(obj) {
	var selectedVal = A.one(obj).val();
    var selectedOption = A.one(obj).one('option[value='+selectedVal+']');
	var select = selectedOption.getAttribute('data-selector');
	var row = selectedOption.ancestor('.filter-selector-row');
	
	row.all('.sel').addClass('hide');
	
	//reset value to empty
	 var dd2 = row.one(".select-2 select");
	 dd2.val('');

	// TODO unselect the checkbox 'select-4' and remove vals from textboxes
	if (select == '')
		return;
	try {
		row.all('.select-4').removeClass('hide'); //Viewable checkbox
		row.all('.select-8').removeClass('hide'); //position  
		row.all('.select-7').removeClass('hide'); //label  
		row.one('.'+ select).removeClass('hide');
	} catch (ee) {}
	
	if(selectedVal == '<%=GenericSearchFilter.TYPE_FIELD %>') {
		var componentClass = selectedOption.ancestor('.component-row-wrapper').getAttribute('data');
		populateFieldDropDown(componentClass, row.one('.'+ select).one('select'), A, '<%= AuthTokenUtil.getToken(request) %>');
		row.all('.select-2').removeClass('hide'); // Actions - Ratings,API, etc..
		row.all('.select-5').removeClass('hide'); // operators
		row.all('.select-6').removeClass('hide'); //Values textbox
	} else  if(selectedVal == '<%=GenericSearchFilter.TYPE_VOCAB %>') {
		row.all('.select-10').removeClass('hide'); //single/multiple selection 
		row.all('.select-14').removeClass('hide'); // to see level
	}  else  if(selectedVal == '<%=GenericSearchFilter.TYPE_TAG %>') {
		row.all('.select-10').removeClass('hide'); //single/multiple selection 
		row.all('.select-6').removeClass('hide'); //Values textbox
	}
	
}

function countSelect(obj) {
	var selectedType = A.one(obj);
	var row = selectedType.ancestor('.filter-selector-row');

    row.all('.select-5, .select-6, .select-9, .select-10, .select-11, .select-12, .select-13, .select-14').addClass('hide');
    row.all('.select-3,.select-4,.select-7,.select-8').removeClass("hide");
	
    if(selectedType.val() == '<%=GenericSearchFilter.SELECT_API %>'){
		row.all('.select-10, .select-11, .select-12').removeClass('hide');
		var selectedApi = row.one('.select-apiList').one('select').val();
		var apiDetails = <%=apiHelperStr%>;
		
		for(var inx=0;inx<apiDetails.length;inx++){
			if (selectedApi == apiDetails[inx].apiKey){
				row.one('.select-config').one('textarea').val(apiDetails[inx].defaultSettings);
			}
		}
	}else if(selectedType.val() == '<%=GenericSearchFilter.SELECT_VOCABULARIES %>'){
		row.all('.select-10,.select-9,.select-14').removeClass('hide');
	}else{
		row.all('.select-6').removeClass('hide');
	}
    
    if(selectedType.val() == '<%=GenericSearchFilter.SELECT_DATES %>'){
		row.all('.select-5').removeClass('hide'); // operator dropdown
	}
	
}

// not in use
function subTypeSelect(obj) {
	
}


function displaySelect(obj) {
	
}

//TODO complete later on
function validateFilters(A) {
	var rows = A.all('.filter-selector-row');
	var arr = [];
	//console.log('tets');
	rows.removeClass('animated pulse');
	for (var i=0;i<rows.size();i++) {
		// if sample row continue
		var row = rows.item(i);
		if (!row.ancestor('.component-row-wrapper'))
			continue;
		
		var errorText = null;
		var type = row.one('select.select-type').val();
		var vocab = row.one('select.select-vocab').val();
		var field = row.one('select.select-field').val();
		var value = row.one('input.select-values').val();
		var level = row.one('input.select-level').val();
		if (type == "") {
			errorText = 'Please select Criteria';
		} else {
			if (type == '<%=GenericSearchFilter.TYPE_VOCAB %>' && vocab == ""){
				errorText = 'Please select Vocabulary';
			} else if (type == '<%=GenericSearchFilter.TYPE_FIELD %>' && field == ""){
				errorText = 'Please select Field';
			} else if (type == '<%=GenericSearchFilter.TYPE_TAG %>' && value == ""){
				errorText = 'Please input a value for the tag';
			}
		}
		
		if (errorText) {
			showError(row, errorText);
			return false;
		}
		
		var count = row.one('select.select-count').val();
		var componentClass = row.ancestor('.component-row-wrapper').getAttribute('data');
		if (type == '<%=GenericSearchFilter.TYPE_VOCAB %>'){
			arr.push(row.get('id') + '--' + componentClass+type+vocab+level);
		} else if (type == '<%=GenericSearchFilter.TYPE_FIELD %>'){
			arr.push(row.get('id') + '--' + componentClass+type+field);
		} else {
			arr.push(row.get('id') + '--' + componentClass+type+value);
		}
	}
	if (arr.length > 1) {
		arr.sort();
		for (var i = 0 ; i < (arr.length-1);i++) {
			var row1 = arr[i].split('--');
			var row2 = arr[i+1].split('--');
			if (row1[1] === row2[1]) {
				showError(A.one('.filter-selector-row#' + row1[0]), "Duplicate row");
				return false;
			}
		}
	}
	return true;
}

function showError(row, errorText){
	row.scrollIntoView();
	var errorRow = row.one('.error-row');
	errorRow.text(errorText);
	errorRow.removeClass('hide');
	row.addClass('animated pulse');
	window.setTimeout(function() {
		errorRow.addClass('hide');
	}, 4000);
	return false;
}

function onChangeDateFilterConfig(node){
	if (node){
		var selectedVal = A.one(node).val();
	}else{
		var selectedVal = A.one("#<portlet:namespace />dateFilteringId").val();
	}
	if (selectedVal == "On"){
		A.one("#<portlet:namespace />dateFilteringFieldNameId").removeClass("hide");
	}else{
		A.one("#<portlet:namespace />dateFilteringFieldNameId").addClass("hide");
	}
	
}

A.ready(function () {
	onChangeDateFilterConfig();
	setTimeout(function(){ 
		loadFilters(A, '<%= AuthTokenUtil.getToken(request) %>');
		loadSorts(A, '<%= AuthTokenUtil.getToken(request) %>');
	}, 2000);
});


</script>

<%!
private static Log _log = LogFactoryUtil.getLog("html.config.filters_jsp");
%>