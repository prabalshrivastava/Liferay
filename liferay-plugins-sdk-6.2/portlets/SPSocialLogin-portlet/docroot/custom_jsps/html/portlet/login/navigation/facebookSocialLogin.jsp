<%@page
	import="com.liferay.portlet.expando.service.ExpandoValueLocalServiceUtil"%>
<%@ page import="com.liferay.portal.util.PortalUtil"%>
<%@ include file="/html/portlet/login/init.jsp"%>

<%
	String redirect = PortalUtil.getOriginalServletRequest(request).getParameter("redirect");
	String facebookAuthURL = PortalUtil.getPathContext()
			+ "/c/portal/facebook_social_login?cmd=login&redirect="+redirect;
	String taglibOpenFacebookLoginWindow = "javascript:var facebookSocialLoginWindow = window.open('"
			+ facebookAuthURL.toString()
			+ "', 'facebooksocial', 'align=center,directories=no,height=560,location=no,menubar=no,resizable=yes,scrollbars=yes,status=no,toolbar=no,width=1000'); void(''); facebookSocialLoginWindow.focus();";

	long companyId = company.getCompanyId();

	boolean loginEnabled = ExpandoValueLocalServiceUtil.getData(
			companyId, Company.class.getName(), "SP_SOCIAL_LOGIN",
			"facebookLoginEnabled", companyId, false);
%>

<c:if test="<%=loginEnabled%>">
	<liferay-ui:icon message=""
		src="/html/portlet/login/navigation/fb.svg"
		url="<%=taglibOpenFacebookLoginWindow%>" />
</c:if>