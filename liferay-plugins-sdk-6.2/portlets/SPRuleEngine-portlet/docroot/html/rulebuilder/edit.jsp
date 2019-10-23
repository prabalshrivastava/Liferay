<%@page import="com.sambaash.platform.constant.SambaashConstants"%>
<%@page import="com.sambaash.platform.session.SPAuthContext"%>
<%@page import="com.sambaash.platform.util.SambaashUtil"%>
<%@ include file="/html/init.jsp" %>


<portlet:resourceURL var="resourceURL" >
	<portlet:param name="sp_p_auth" value="<%= AuthTokenUtil.getToken(request) %>"/>
</portlet:resourceURL>

<%@ include file="/html/rulebuilder/fragments/ruleBuilder.jspf"  %>

<%
   String ruleSetId  = request.getParameter("storageId"); 
%>
   
<script>
var builder;
AUI().on('domready', function () {
	var ns = "<portlet:namespace/>";
	AUI().one("#"+ns+"cancel")._node.classList.remove("hide");

	var userInfo = <%= SambaashUtil.getUserInfo(themeDisplay).toString() %>;
	var sp_auth_site_active;
	var sp_auth_site_access;
	var p_auth =  "<%= AuthTokenUtil.getToken(request) %>";
	<%
	String loginType = (String) SPAuthContext.getValue(session, SPAuthContext.Key.SP_LOGIN_TYPE);
	if (!SambaashConstants.SP_DEFAULT_LIFERAY_LOGIN.equals(loginType)) {
		Long spSite = (Long) SPAuthContext.getValue(session, SPAuthContext.Key.SPSITE_AUTH_ACTIVE);
		List<Long> spSiteAccess = (List<Long>) SPAuthContext.getValue(session, SPAuthContext.Key.SPSITE_AUTH_ACCESS);
	%>
		sp_auth_site_active =  "<%= spSite %>";
		sp_auth_site_access =  <%= spSiteAccess %>;
	<%}%>
	
	builder = new SPRuleBuilder(p_auth, "ruleBuilder", "<%= resourceURL.toString() %>", ns, <%= ruleSetId %>, userInfo, sp_auth_site_active, sp_auth_site_access);
	builder.load();
});
</script>