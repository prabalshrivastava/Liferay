<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@include file="/html/template/init.jsp" %>
<%@page import="javax.portlet.PortletURL"%>
<%@taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>


<liferay-portlet:actionURL portletConfiguration="true" var="configurationURL">
   <portlet:param name="<%=Constants.CMD %>" value="<%=Constants.UPDATE %>" />
</liferay-portlet:actionURL> 
<%  
String maxLevels_cfg = GetterUtil.getString(portletPreferences.getValue("maxlevels", "10"));
%>

<aui:form action="<%= configurationURL %>" method="post" name="fm">
    <aui:input label="Mximum number of Hierarchy" name="maxlevels" type="text" value="<%= maxLevels_cfg %>" />

    <aui:button-row>
        <aui:button type="submit" />
    </aui:button-row>
</aui:form>