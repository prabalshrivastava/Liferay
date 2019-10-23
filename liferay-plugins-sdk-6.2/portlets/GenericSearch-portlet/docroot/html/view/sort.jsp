
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="java.util.Map.Entry"%>
<%@page import="java.util.Map"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util"%>
<%@ taglib uri="http://liferay.com/tld/security"
	prefix="liferay-security"%>

<portlet:defineObjects />
<select name="generic-search-sortby" id="generic-search-sortby" class="hide">
<%
Map<String, String[]> map = portletPreferences.getMap();
String defaultOption = portletPreferences.getValue("sort--default", null);
for (Entry<String, String[]> entry : map.entrySet()) {
	if (!entry.getKey().startsWith("sort--type--"))
		continue;
	String rowId = entry.getKey().replaceAll("sort--type--", StringPool.BLANK);
	if(rowId.equals("rowID"))
		continue;
	String label = portletPreferences.getValue("sort--label--" + rowId, null);
	if(Validator.isNull(label))
		continue;
	
	// field
	String field = portletPreferences.getValue("sort--field--" + rowId, null);
	// string/long
	String fieldType = portletPreferences.getValue("sort--field--type--" + rowId, "3");
	Boolean isSelected = false;
	
	if (field.equals(defaultOption))
		isSelected = true;
	
	String labelDsc = label.trim() + " (Desc) ";
	String labelAsc = label.trim() + " (Asc) ";
	Map<String, Object> dataMap = new HashMap<String, Object>();
	dataMap.put("field", field);
	dataMap.put("order", true);
	dataMap.put("field-type", fieldType);
%>

<script>
   
	document.getElementById("generic-search-sortby").classList.remove('hide')
</script>

	<aui:option label="<%=labelDsc %>" value="<%=field %>" data="<%=dataMap %>" />
	<%dataMap.put("order", false);field = field + "asc";%>
	<aui:option label="<%=labelAsc %>" value="<%=field %>" data="<%=dataMap %>" selected="<%=isSelected%>" />
<%
}
%>
</select>