<%@page import="com.sambaash.platform.spchallenge.helper.SPChallengeConstants"%>
<%@page import="com.sambaash.platform.util.SambaashUtil"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<portlet:defineObjects />
<liferay-theme:defineObjects />

<% 
	String listUrl = SambaashUtil.getParameter(SPChallengeConstants.SP_PARAM_CHALLENGE_LIST_HOME, 0);
%>

<script type="text/javascript">
	window.location.replace("<%= listUrl %>");
</script>
