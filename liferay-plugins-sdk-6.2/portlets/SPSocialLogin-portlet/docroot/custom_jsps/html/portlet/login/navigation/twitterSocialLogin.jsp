<%@page
	import="com.liferay.portlet.expando.service.ExpandoValueLocalServiceUtil"%>
<%@ page import="com.liferay.portal.util.PortalUtil"%>
<%@ include file="/html/portlet/login/init.jsp"%>

<%
	String twitterAuthURL = PortalUtil.getPathContext()
			+ "/c/portal/twitter_social_login?cmd=login";
	String taglibOpenTwitterLoginWindow = "javascript:var twitterLoginWindow = window.open('"
			+ twitterAuthURL.toString()
			+ "', 'twitter', 'align=center,directories=no,height=560,location=no,menubar=no,resizable=yes,scrollbars=yes,status=no,toolbar=no,width=1000'); void(''); twitterLoginWindow.focus();";

	long companyId = company.getCompanyId();

	boolean loginEnabled = ExpandoValueLocalServiceUtil.getData(
			companyId, Company.class.getName(), "SP_SOCIAL_LOGIN",
			"twitterLoginEnabled", companyId, false);
%>

<c:if test="<%=loginEnabled%>">
	<liferay-ui:icon message=""
		src="/html/portlet/login/navigation/twitterSocialLogin.png"
		url="<%=taglibOpenTwitterLoginWindow%>" />
</c:if>