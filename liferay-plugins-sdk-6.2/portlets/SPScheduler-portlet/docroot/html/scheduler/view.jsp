<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@page import="com.liferay.portal.security.auth.AuthTokenUtil"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>

<portlet:defineObjects />
<portlet:resourceURL var="resourceURL">
	<portlet:param name="sp_p_auth"
		value="<%=AuthTokenUtil.getToken(request)%>" />
</portlet:resourceURL>
<portlet:actionURL name="testRequest" var="testRequestUrl">
</portlet:actionURL>
<portlet:actionURL name="testSambaashEDM" var="testSambaashEDMUrl">
</portlet:actionURL>

<div>
	<liferay-ui:search-iterator searchContainer="${searchContainer}" />
</div>

<a href="<%=testRequestUrl %>">Test</a>

<a href="<%=testSambaashEDMUrl %>">TestSambaashEDM</a>

<script type="text/javascript">
	var schedulerAjaxUrl = '<%=resourceURL%>';
</script>