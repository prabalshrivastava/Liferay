<%@page
	import="com.liferay.portlet.expando.service.ExpandoValueLocalServiceUtil"%>
<%@ page import="com.liferay.portal.util.PortalUtil"%>
<%@ include file="/html/portlet/login/init.jsp"%>

<%
	String microsoftAuthURL = PortalUtil.getPathContext()
			+ "/c/portal/microsoft_social_login_cmd";
	String taglibOpenMicrosoftLoginWindow = "javascript:var microsoftLoginWindow = window.open('"
			+ microsoftAuthURL.toString()
			+ "', 'microsoft', 'align=center,directories=no,height=560,location=no,menubar=no,resizable=yes,scrollbars=yes,status=no,toolbar=no,width=1000'); void(''); microsoftLoginWindow.focus();";

	long companyId = company.getCompanyId();

	boolean loginEnabled = ExpandoValueLocalServiceUtil.getData(
			companyId, Company.class.getName(), "SP_SOCIAL_LOGIN",
			"microsoftLoginEnabled", companyId, false);
%>

<c:if test="<%=loginEnabled%>">
	<liferay-ui:icon message=""
		src="/html/portlet/login/navigation/microsoftSocialLogin.png"
		url="<%=taglibOpenMicrosoftLoginWindow%>" />
</c:if>