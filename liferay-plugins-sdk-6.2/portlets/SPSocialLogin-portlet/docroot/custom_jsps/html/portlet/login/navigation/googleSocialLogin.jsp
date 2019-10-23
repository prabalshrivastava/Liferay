<%@page
	import="com.liferay.portlet.expando.service.ExpandoValueLocalServiceUtil"%>
<%@ page import="com.liferay.portal.util.PortalUtil"%>
<%@ include file="/html/portlet/login/init.jsp"%>

<%
	String redirect = PortalUtil.getOriginalServletRequest(request).getParameter("redirect");
	String googleAuthURL = PortalUtil.getPathContext()
			+ "/c/portal/google_social_login?cmd=login&redirect="+redirect;
	String taglibOpenGoogleLoginWindow = "javascript:var googleSocialLoginWindow = window.open('"
			+ googleAuthURL.toString()
			+ "', 'google', 'align=center,directories=no,height=560,location=no,menubar=no,resizable=yes,scrollbars=yes,status=no,toolbar=no,width=1000'); void(''); googleSocialLoginWindow.focus();";

	long companyId = company.getCompanyId();

	boolean loginEnabled = ExpandoValueLocalServiceUtil.getData(
			companyId, Company.class.getName(), "SP_SOCIAL_LOGIN",
			"googleLoginEnabled", companyId, false);
%>

<c:if test="<%=loginEnabled%>">
	<liferay-ui:icon message=""
		src="/html/portlet/login/navigation/gplus.svg"
		url="<%=taglibOpenGoogleLoginWindow%>" />
</c:if>