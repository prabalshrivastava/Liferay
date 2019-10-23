<%@page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.json.JSONObject"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib	uri="http://liferay.com/tld/security" prefix="liferay-security"%>
<%@ taglib	uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib	uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib	uri="http://liferay.com/tld/util" prefix="liferay-util"%>


<%@page import="com.liferay.portal.util.PortalUtil" %>

<portlet:defineObjects />
<liferay-theme:defineObjects />

<liferay-util:buffer var="sbhtml">
	<liferay-ui:social-bookmarks
				    displayStyle="vertical"
				    target="_blank"
				    title="testing soccial bookmarks"
				    url="${url }" 
				/>
</liferay-util:buffer>
<%
	JSONObject json = JSONFactoryUtil.createJSONObject();
	json.put("html",sbhtml);
	out.write(json.toString());
%>