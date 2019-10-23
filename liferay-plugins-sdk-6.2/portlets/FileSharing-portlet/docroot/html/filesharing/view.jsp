<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ page import="com.liferay.portal.kernel.util.Validator" %>

<%@ page import="com.sambaash.platform.portlet.filesharing.util.FileSharingHelper" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="javax.portlet.PortletURL" %>
<%@ page import="javax.portlet.ActionRequest" %>
<%@ page import="javax.portlet.PortletRequest" %>

<portlet:defineObjects />
<liferay-theme:defineObjects />
<liferay-portlet:renderURL var="portletURL" />

<%
String tabValue = ParamUtil.getString(renderRequest, "tab", "");
if (Validator.isNull(tabValue)) {
	tabValue = ParamUtil.getString(request, "tab", "sharedWithMe");
}
String token = FileSharingHelper.parseTokenId(renderRequest);
String includeURL = "/html/filesharing/" + tabValue.trim() + ".jsp";
%>

<liferay-ui:tabs names="Shared With Me,Shared by Me" param="tab" tabsValues="sharedWithMe,sharedByMe" url="<%= portletURL %>" />

<c:import url="<%= includeURL %>" />