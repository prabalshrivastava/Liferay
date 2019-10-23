<%@page import="com.liferay.portlet.asset.model.AssetEntry"%>
<%@page import="com.liferay.portlet.assetpublisher.util.AssetPublisher"%>
<%@page import="com.liferay.portal.kernel.search.Sort"%>
<%@page import="com.liferay.portal.security.auth.AuthTokenUtil"%>
<%@page import="com.sambaash.platform.genericsearch.model.GenericSearchFilter"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.portlet.DefaultConfigurationAction"%>
<%@page import="com.liferay.portal.util.PortletKeys"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page
	import="com.liferay.portlet.portletdisplaytemplate.util.PortletDisplayTemplateUtil"%>
<%@page import="com.liferay.compat.portal.kernel.util.LocaleUtil"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.compat.portal.kernel.util.HtmlUtil"%>
<%@page
	import="com.liferay.portlet.dynamicdatamapping.model.DDMTemplate"%>
<%@page
	import="com.liferay.portlet.dynamicdatamapping.service.DDMTemplateLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Arrays"%>
<%@page import="com.sambaash.platform.genericsearch.GenericSearchConstants"%>
<%@page import="com.sambaash.platform.srv.spsocialprofile.model.SocialProfile" %>
<%@page import="com.liferay.portal.model.User" %>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util"%>
<%@page import="com.liferay.portal.kernel.log.Log" %>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil" %>

<portlet:defineObjects />
<liferay-theme:defineObjects />


<h4 class="margin-bottom-half">
	<liferay-ui:message key="configure-search-results" />
</h4>

<%
	String selected = GetterUtil.getString(portletPreferences.getValue(
			GenericSearchConstants.PREF_ENABLED_COMPONENTS, ""));
	List<String> classes = Arrays.asList(selected.split(","));

	String msg = null;
	if (classes.size() == 1 && classes.contains("")) {
		msg = "select-components-first";
	} else {
		msg = "select-display-template";
	}
	String itemsPerPageName = DefaultConfigurationAction.PREFERENCES_PREFIX
			+ GenericSearchConstants.PREF_ITEMS_PER_PAGE + StringPool.DOUBLE_DASH;
	String itemsPerPage = portletPreferences.getValue(
			GenericSearchConstants.PREF_ITEMS_PER_PAGE, "3");
	
	String titleForResultsListName = DefaultConfigurationAction.PREFERENCES_PREFIX
			+ GenericSearchConstants.RESULT_TITLE + StringPool.DOUBLE_DASH;
	String titleForResultsList = portletPreferences.getValue(
			GenericSearchConstants.RESULT_TITLE, "");
	
	String loadMoreTextName = DefaultConfigurationAction.PREFERENCES_PREFIX
			+ GenericSearchConstants.LOAD_MORE_TEXT + StringPool.DOUBLE_DASH;
	String loadMoreText = portletPreferences.getValue(
			GenericSearchConstants.LOAD_MORE_TEXT, "More Records");
	
	String resultsOrientationName = DefaultConfigurationAction.PREFERENCES_PREFIX
			+ GenericSearchConstants.PREF_RESULTS_ORIENTATION + StringPool.DOUBLE_DASH;
	String resultsOrientation = portletPreferences.getValue(
			GenericSearchConstants.PREF_RESULTS_ORIENTATION,
			"Horizontal");
	String sortFilteringName = DefaultConfigurationAction.PREFERENCES_PREFIX + GenericSearchConstants.PREF_SORT_FILTERING + StringPool.DOUBLE_DASH;
	String sortFiltering = portletPreferences.getValue(GenericSearchConstants.PREF_SORT_FILTERING, "Off");
%>

<style>
.aui .component-row-wrapper .control-group{
	margin-bottom: 10px;
}
.sort-selector div {
	margin-right: 8px;
}
</style>

<aui:row>
	<aui:col span="6">
		<aui:input name="<%=itemsPerPageName%>"
			label="<%=GenericSearchConstants.PREF_ITEMS_PER_PAGE%>" type="text"
			required="true" value="<%=itemsPerPage%>" />
	</aui:col>
	<aui:col span="6">
		<aui:select name="<%=resultsOrientationName%>"
			label="<%=GenericSearchConstants.PREF_RESULTS_ORIENTATION%>"
			required="true" value="<%=resultsOrientation%>">
			<aui:option label="horizontal" value="Horizontal"
				selected='<%="Horizontal"
								.equalsIgnoreCase(resultsOrientation)%>' />
			<aui:option label="tiles" value="Tiles"
				selected='<%="Tiles".equalsIgnoreCase(resultsOrientation)%>' />
		</aui:select>
	</aui:col>
</aui:row>
<aui:row>
	<aui:col span="12">
		<label class="margin-bottom-quarter"> <liferay-ui:message
				key="<%=msg%>" /> <liferay-ui:icon image="help"
				message="create-template-help" toolTip="false" />
		</label>
	</aui:col>
</aui:row>
<%
	
	for (String clazz : classes) {
		try {
			
			String nameAttribute = DefaultConfigurationAction.PREFERENCES_PREFIX + "displayStyle" + StringPool.DOUBLE_DASH + clazz + StringPool.DOUBLE_DASH;
			Long selectedTemplateId = GetterUtil.getLong(portletPreferences.getValue("displayStyle" + StringPool.DOUBLE_DASH + clazz, null));
			List<DDMTemplate> companyPortletDDMTemplates = DDMTemplateLocalServiceUtil
					.getTemplates(themeDisplay.getScopeGroupId(),
							PortalUtil.getClassNameId(clazz), 0);
			List<DDMTemplate> groupDDMTemplates = DDMTemplateLocalServiceUtil
					.getTemplates(PortletDisplayTemplateUtil.getDDMTemplateGroupId(themeDisplay.getScopeGroupId()),
							PortalUtil.getClassNameId(AssetEntry.class));
			if ((Validator.isNotNull(companyPortletDDMTemplates) && companyPortletDDMTemplates.size()>0) ||
				(Validator.isNotNull(groupDDMTemplates) && groupDDMTemplates.size() > 0)) {
					%>
					<div class="generic-search-template-select">
					<aui:select id="displayStyle"
						label="<%=clazz%>" name="<%=nameAttribute%>">
						<optgroup label="<liferay-ui:message key="global-templates" />">
							<%
							if(companyPortletDDMTemplates.size() > 0) {
							try {
								for (DDMTemplate companyPortletDDMTemplate : companyPortletDDMTemplates) {
									Long value = companyPortletDDMTemplate.getTemplateId();
									boolean isSelected = (selectedTemplateId != null && value.equals(selectedTemplateId))? true : false;
									 %>
									<aui:option label="<%= HtmlUtil.escape(companyPortletDDMTemplate.getName(LocaleUtil.getDefault())) %>" 
											selected="<%= isSelected %>" value="<%= value %>" />
								   <%
								}
							}catch(Exception e){
								_log.error(e.getMessage());
							} else {
								out.println("<option disabled='true' value=''>No Templates</option>");
							}
							%>
						</optgroup>
						<optgroup label="<liferay-ui:message key="group-templates" />">
							<%
							try {
								for (DDMTemplate groupDDMTemplate : groupDDMTemplates) {
									Long value = groupDDMTemplate.getTemplateId();
									boolean isSelected = (selectedTemplateId != null && value.equals(selectedTemplateId))? true : false;
									 %>
									<aui:option label="<%= HtmlUtil.escape(groupDDMTemplate.getName(LocaleUtil.getDefault())) %>" 
											selected="<%= isSelected %>" value="<%= value %>" />
								   <%
								}
							}catch(Exception e){
								_log.error(e.getMessage());
								}
							}
							%>
						</optgroup>
					</aui:select>
					</div>
					<%
			} else {
				if (!clazz.equals("")) {
				%>
					<div>
						<%=LanguageUtil.format(pageContext, "no-display-template-found-for-x", clazz) %>. 
						<liferay-ui:icon message="create" label="true" target="_blank" 
							url="<%=PortalUtil.getControlPanelFullURL(themeDisplay.getScopeGroupId(), PortletKeys.PORTLET_DISPLAY_TEMPLATES, null) %>"></liferay-ui:icon>
					</div>
				<%
				}
			}
		} catch (Exception e) {
			_log.error(e.getMessage());
		}
	}
%>
	
<aui:row>
	<aui:col>
		<aui:select name="<%=sortFilteringName%>"
			label="<%=GenericSearchConstants.PREF_SORT_FILTERING%>"
			required="true" value="<%=sortFiltering%>">
			<aui:option label="On" value="On"
				selected='<%="On".equalsIgnoreCase(sortFiltering)%>' />
			<aui:option label="Off" value="Off"
				selected='<%="Off".equalsIgnoreCase(sortFiltering)%>' />
		</aui:select>
	</aui:col>
	
	
</aui:row>
<aui:row>
<aui:col span="6">
		<aui:input name="<%=titleForResultsListName%>"
			label="<%=GenericSearchConstants.RESULT_TITLE%>" type="text" value="<%=titleForResultsList%>" />
	</aui:col>
	
	<aui:col span="6">
		<aui:input name="<%=loadMoreTextName%>"
			label="<%=GenericSearchConstants.LOAD_MORE_TEXT%>" type="text" value="<%=loadMoreText%>" />
	</aui:col>
</aui:row>

<div class="border-all white-bg padding-half margin-top-half" style="border-radius: 6px">
	<div class="component-row-wrapper border-all padding-half bg-custom-color-4 margin-bottom-half" style="border-radius: 6px;">
		<h5 class="margin-bottom-half">Sort Results<button onclick="javascript:return addSortRow();" style="float:right" type="button">Add New Sort Field</button> </h5>
		<div class="bg-white border-all padding-half padding-bottom-quarter sort-container hide">
		</div>
	</div>
</div>
<div id="sample-sort-selector" class="hide">
	<div class="sort-selector-row padding-top-quarter" id="rowID">
		<div class="sort-selector">
		
			<aui:input name="preferences--sort--label--rowID--" cssClass="sort-label" style="height: 11px;" inlineField="true" label="label" />
			
			<aui:select name="preferences--sort--type--rowID--" label="select-sort-type" cssClass="select-sort-type"
				showEmptyOption="true" inlineField="true"
				onChange="sortTypeSelect(this)">
				<% for (String clazz : classes) {  %>
				<aui:option value="<%=clazz%>"
					label="<%=clazz %>" data-selector="select-field" data-clazz="<%=clazz%>"/>
				<% } %>
			</aui:select>
			<div class="sel select-field hide inline-block">
				<aui:select cssClass="select-field" showEmptyOption="true" name="preferences--sort--field--rowID--" label="select-field" onChange="changeDefaultRadioValue(this)"/>
			</div>
			
			<div class="sel select-field-type inline-block">
				<aui:select cssClass="select-field-type" name="preferences--sort--field--type--rowID--" label="select-field-type">
					<aui:option value="<%=Sort.STRING_TYPE %>" label="field-type-string"/>
					<aui:option value="<%=Sort.LONG_TYPE %>" label="field-type-long"/>
				</aui:select>
			</div>
			
			<div class = "sel select-default inline-block">
				<aui:input name="preferences--sort--default--" cssClass="select-default" inlineField="true" type="radio" value="rowID" label="default-sort"></aui:input>
			</div>
			<div style="float:right">
				<liferay-ui:icon-delete id="deleteIcon" url="javascript:deleteSortRow('rowID');" confirmation="really-delete"></liferay-ui:icon-delete>
			</div>
		</div>
	</div>
</div>

<script>

var A = AUI().use('aui-node', 'aui-base','aui-io-request-deprecated','liferay-util-window','aui-io-plugin-deprecated','liferay-portlet-url');

function addSortRow(){
	//console.log('test');
	var container = A.one('.sort-container');
	var currentCount = container.all('.sort-selector-row').size();
	// add new node
	var sampleNode = A.one('#sample-sort-selector .sort-selector-row').clone();
	var newId = 'sort_' + (currentCount + 1);
	if (currentCount + 1 >= 2)
		sampleNode.addClass('border-top');
	
	var htmlCode = sampleNode.get('outerHTML');
	htmlCode = htmlCode.replace(/rowID/g, newId);
	container.append(htmlCode);
	container.removeClass("hide");
	return newId;
}

function sortTypeSelect(obj) {
	var selectedVal = A.one(obj).val();
    var selectedOption = A.one(obj).one('option[value='+selectedVal+']');
	var row = selectedOption.ancestor('.sort-selector-row');
	var fieldDiv = row.one('.select-field');
	fieldDiv.addClass('hide');
	if (!selectedOption || selectedOption.val() == '')
		return;
	fieldDiv.removeClass('hide');
	populateFieldDropDown(selectedOption.val(), fieldDiv.one('select'), A, '<%= AuthTokenUtil.getToken(request) %>');
	changeDefaultRadioValue(fieldDiv.one('select'));
}

function changeDefaultRadioValue(obj) {
	var selectedVal = A.one(obj).val();
    var selectedOption = A.one(obj).one('option[value='+selectedVal+']');
	var row = selectedOption.ancestor('.sort-selector-row');
	var value = row.one('.select-field select').val();
	row.one('.select-default input').setAttribute("value", value);
}

function deleteSortRow(rowID) {
	var component = rowID.split('_')[0];
	var id = rowID.split('_')[1];
	A.one("#" + rowID).remove();
	var container = A.one('.sort-container');
	var currentCount = container.all('.sort-selector-row').size();
	if (currentCount == 0)
		container.addClass("hide");
	return 0;
}

</script>

<%!
private static Log _log = LogFactoryUtil.getLog("html.config.results_jsp");
%>
