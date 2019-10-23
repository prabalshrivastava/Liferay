<%@page
	import="com.liferay.portlet.expando.service.ExpandoValueLocalServiceUtil"%>
<%@ page import="com.liferay.portal.util.PortalUtil"%>
<%@ include file="/html/portlet/login/init.jsp"%>

<%
	String redirect = PortalUtil.getOriginalServletRequest(request).getParameter("redirect");
	String linkedinAuthURL = PortalUtil.getPathContext()
			+ "/c/portal/linkedin_social_login?cmd=login&redirect="+redirect;
	String taglibOpenLinkedinLoginWindow = "javascript:var linkedinLoginWindow = window.open('"
			+ linkedinAuthURL.toString()
			+ "', 'linkedin', 'align=center,directories=no,height=560,location=no,menubar=no,resizable=yes,scrollbars=yes,status=no,toolbar=no,width=1000'); void(''); linkedinLoginWindow.focus();";

	long companyId = company.getCompanyId();

	boolean loginEnabled = ExpandoValueLocalServiceUtil.getData(
			companyId, Company.class.getName(), "SP_SOCIAL_LOGIN",
			"linkedinLoginEnabled", companyId, false);
%>

<c:if test="<%=loginEnabled%>">
	<liferay-ui:icon message=""
		src="/html/portlet/login/navigation/linkedin.svg"
		url="<%=taglibOpenLinkedinLoginWindow%>" />
</c:if>