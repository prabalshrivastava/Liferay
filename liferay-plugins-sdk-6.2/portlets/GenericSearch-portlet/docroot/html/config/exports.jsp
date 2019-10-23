<%@page import="java.util.Map.Entry"%>
<%@page import="java.util.Map"%>
<%@page import="com.liferay.portlet.asset.service.AssetVocabularyLocalServiceUtil"%>
<%@page import="com.liferay.portlet.asset.model.AssetVocabulary"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.portlet.DefaultConfigurationAction"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.util.KeyValuePair"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.search.IndexerRegistryUtil"%>
<%@page import="com.liferay.portal.kernel.search.Indexer"%>
<%@page import="com.sambaash.platform.genericsearch.GenericSearchConstants"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<portlet:defineObjects />
<liferay-theme:defineObjects />

<h4>
	<liferay-ui:message key="configure-search-exports" />
</h4>


<%
String hideExportsName = DefaultConfigurationAction.PREFERENCES_PREFIX + GenericSearchConstants.PREF_HIDE_EXPORTS + StringPool.DOUBLE_DASH;
String hideExports = portletPreferences.getValue(GenericSearchConstants.PREF_HIDE_EXPORTS, "Off");
String adminOnlyExportsName = DefaultConfigurationAction.PREFERENCES_PREFIX + GenericSearchConstants.PREF_ADMIN_EXPORTS + StringPool.DOUBLE_DASH;
String adminExports = portletPreferences.getValue(GenericSearchConstants.PREF_ADMIN_EXPORTS, "Off");
%>
<aui:row>
	<aui:col span="6">
		<aui:select name="<%=hideExportsName%>" label="<%=GenericSearchConstants.PREF_HIDE_FILTERS%>"
			required="true" value="<%=hideExports%>">
			<aui:option label="yes" value="On"
				selected='<%="On".equalsIgnoreCase(hideExports)%>' />
			<aui:option label="no" value="Off"
				selected='<%="Off".equalsIgnoreCase(hideExports)%>' />
		</aui:select>
	</aui:col>
	<aui:col span="6">
		<aui:select name="<%=adminOnlyExportsName%>" label="label.admin.only.export"
			required="true" value="<%=adminExports%>">
			<aui:option label="yes" value="On"
				selected='<%="On".equalsIgnoreCase(adminExports)%>' />
			<aui:option label="no" value="Off"
				selected='<%="Off".equalsIgnoreCase(adminExports)%>' />
		</aui:select>
	</aui:col>
</aui:row>
<%
String selected = GetterUtil.getString(portletPreferences.getValue(
	GenericSearchConstants.PREF_ENABLED_COMPONENTS, ""));
for (String clazz : selected.split(",")) {
	if (Validator.isNull(clazz))
		continue;
	Indexer indexer = IndexerRegistryUtil.getIndexer(clazz);
	Map<String, String> fieldMap = indexer.getIndexedFields();
	String existingValue = portletPreferences.getValue(GenericSearchConstants.PREF_EXPORTS
			+ LanguageUtil.get(pageContext, clazz).toLowerCase(), "");
	
	List<KeyValuePair> leftList = new ArrayList<KeyValuePair>();
	List<KeyValuePair> rightList = new ArrayList<KeyValuePair>();
	for (Entry<String, String> fieldEntry : fieldMap.entrySet()) {
		if(Validator.isNotNull(fieldEntry.getValue()))
			leftList.add(new KeyValuePair(fieldEntry.getKey(), fieldEntry.getValue()));
	}
	
	for (AssetVocabulary vocab : AssetVocabularyLocalServiceUtil.getGroupVocabularies(themeDisplay.getScopeGroupId())) {
		leftList.add(new KeyValuePair(vocab.getVocabularyId() + "", vocab.getName()));
	}
	
	for (String field: existingValue.split(",")) {
		if(Validator.isNotNull(fieldMap.get(field))) {
			rightList.add(new KeyValuePair(field, fieldMap.get(field)));
		} else if (GetterUtil.getLong(field) != 0) {
			AssetVocabulary voc = AssetVocabularyLocalServiceUtil.getAssetVocabulary(GetterUtil.getLong(field));
			rightList.add(new KeyValuePair(field, voc.getName()));
		}
	}
	
	leftList.removeAll(rightList);
	
	String leftName = "fields-" + LanguageUtil.get(pageContext, clazz).toLowerCase();
	String rightName = DefaultConfigurationAction.PREFERENCES_PREFIX
				+ GenericSearchConstants.PREF_EXPORTS
				+ LanguageUtil.get(pageContext, clazz).toLowerCase()
				+ StringPool.DOUBLE_DASH;
%>
<h5><liferay-ui:message key="<%=clazz%>" /></h5>
<liferay-ui:input-move-boxes rightList="<%=rightList %>" rightTitle="selected-fields" 
	leftBoxName="<%=leftName %>" leftList="<%=leftList %>" rightBoxName="<%=rightName %>" 
	leftTitle="available-fields"  leftReorder="false" rightReorder="true" cssClass="custom-move-boxes" >
</liferay-ui:input-move-boxes>
<%
}
%>

<aui:script use="aui-node, aui-base">
	A.all('.move-left, .move-right').on('click', function (ev) {
		setTimeout(function() {
			var node = ev.target.ancestor('.custom-move-boxes').one('.right-selector');
			node.get('options').set('selected', true);
		}, 300);
	});
	A.all('.right-selector').on('blur', function (ev) {
		setTimeout(function() {
			var node = ev.target;
			node.get('options').set('selected', true);
		}, 700);
	});
	A.ready(function () {
		var nodes = A.all('.right-selector');
		nodes.each(function (node) {
			node.get('options').set('selected', true);
		});
	});
</aui:script>
