<%@page import="com.liferay.portal.service.RoleLocalServiceUtil"%>
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
<%@page import="com.liferay.portal.kernel.portlet.DefaultConfigurationAction"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.liferay.portal.model.Role" %>
<%@page import="java.util.HashSet"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.Arrays"%>
<%@page import="com.sambaash.platform.genericsearch.GenericSearchConstants"%>
<%@page import="com.liferay.portal.kernel.util.PropsUtil"%>
<%@page import="com.liferay.portal.kernel.search.Indexer"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.search.IndexerRegistryUtil"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<portlet:defineObjects />
<liferay-theme:defineObjects />

<h4>
	<liferay-ui:message key="configure-search-favourites" />
</h4>


<%
	String hideFavouritesName = DefaultConfigurationAction.PREFERENCES_PREFIX + GenericSearchConstants.PREF_HIDE_FAVOURITES + StringPool.DOUBLE_DASH;
	String hideFavourites = portletPreferences.getValue(GenericSearchConstants.PREF_HIDE_FAVOURITES, "Off");

	List<Role> roleList = RoleLocalServiceUtil.getRoles(-1, -1);
	
	String selectName = DefaultConfigurationAction.PREFERENCES_PREFIX
			+ GenericSearchConstants.PREF_ENABLED_ROLES + "--";
	String selected = GetterUtil.getString(portletPreferences.getValue(
			GenericSearchConstants.PREF_ENABLED_ROLES, ""));
	pageContext.setAttribute("selected", selected);
%>

<aui:row>
	<aui:col span="6">
		<aui:select name="<%=hideFavouritesName%>" label="<%=GenericSearchConstants.PREF_HIDE_FAVOURITES%>"
			required="true" value="<%=hideFavourites%>">
			<aui:option label="yes" value="On"
				selected='<%="On".equalsIgnoreCase(hideFavourites)%>' />
			<aui:option label="no" value="Off"
				selected='<%="Off".equalsIgnoreCase(hideFavourites)%>' />
		</aui:select>
	</aui:col>
</aui:row>

<div>
	<aui:select name="<%=selectName%>" label="<%=GenericSearchConstants.PREF_ENABLED_ROLES%>"
		multiple="true" cssClass="width-30" style="height: 120px;">
		<%for(Role role : roleList) { %>
			<c:set var="isselected" value="false"></c:set>
			<% if(selected.contains(String.valueOf(role.getRoleId()))) { %>
				<c:set var="isselected" value="true"></c:set>
			<% } %>
			<aui:option label="<%=role.getName() %>" value="<%=role.getRoleId() %>" selected="${isselected}"></aui:option>
		<%}%>
	</aui:select>
</div>

