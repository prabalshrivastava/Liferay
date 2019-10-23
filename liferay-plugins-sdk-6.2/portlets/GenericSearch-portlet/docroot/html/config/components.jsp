<%@page import="com.liferay.portal.kernel.portlet.DefaultConfigurationAction"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="java.util.HashSet"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.Arrays"%>
<%@page import="com.sambaash.platform.genericsearch.GenericSearchConstants"%>
<%@page import="com.liferay.portal.kernel.util.PropsUtil"%>
<%@page import="com.liferay.portal.kernel.search.Indexer"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.search.IndexerRegistryUtil"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util"%>

<portlet:defineObjects />

<h4 class="margin-bottom-half">
	<liferay-ui:message key="configure-search-components" />
</h4>

<%
	String[] enabledArr = PropsUtil.getArray(GenericSearchConstants.PREF_ENABLED_COMPONENTS);

	String[] enabledEMSArr = PropsUtil.getArray(GenericSearchConstants.PREF_ENABLED_EMS_COMPONENTS);
	List<String> enabledComps = Arrays.asList(enabledArr);
	List<String> enabledEMSComps = Arrays.asList(enabledEMSArr);
	
	List<Indexer> indexers = IndexerRegistryUtil.getIndexers();
	Set<Indexer> enabledIndexers = new HashSet<Indexer>(
			enabledComps.size());
	for (Indexer indexer : indexers) {
		if (enabledComps.contains(indexer.getClassNames()[0]))
			enabledIndexers.add(indexer);
	}
	
	String selectName = DefaultConfigurationAction.PREFERENCES_PREFIX
			+ GenericSearchConstants.PREF_ENABLED_COMPONENTS + "--";
	String selected = GetterUtil.getString(portletPreferences.getValue(
			GenericSearchConstants.PREF_ENABLED_COMPONENTS, ""));
	pageContext.setAttribute("selected", selected);
%>
<div>
	<aui:select name="<%=selectName%>" label="<%=GenericSearchConstants.PREF_ENABLED_COMPONENTS%>"
		multiple="true" required="true" cssClass="width-30">
		<c:forEach var="indexer" items="<%=enabledIndexers%>">
			<c:set var="isselected" value="false"></c:set>
			<c:if
				test="${fn:containsIgnoreCase(selected, indexer.classNames[0])}">
				<c:set var="isselected" value="true"></c:set>
			</c:if>
			<aui:option label="${indexer.classNames[0]}"
				value="${indexer.classNames[0]}" selected="${isselected}"></aui:option>
		</c:forEach>
		
		<c:forEach var="emsmodel" items="<%=enabledEMSComps%>">
			<c:set var="isselected" value="false"></c:set>
			<c:if
				test="${fn:containsIgnoreCase(selected, emsmodel)}">
				<c:set var="isselected" value="true"></c:set>
			</c:if>
			<aui:option label="${emsmodel}"
				value="${emsmodel}" selected="${isselected}"></aui:option>
		</c:forEach>
	</aui:select>
</div>
<aui:script use="aui-base, aui-node">
try{
	var scrHeight = (A.one('#<portlet:namespace /><%=GenericSearchConstants.PREF_ENABLED_COMPONENTS%>').getDOMNode().scrollHeight) + 5;
	A.one('#<portlet:namespace /><%=GenericSearchConstants.PREF_ENABLED_COMPONENTS%>').height(scrHeight > 175? 175:scrHeight);
}catch(e){
	console.log(e);
}
</aui:script>