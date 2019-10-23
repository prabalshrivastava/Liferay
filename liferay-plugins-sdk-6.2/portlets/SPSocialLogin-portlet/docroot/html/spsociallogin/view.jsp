<%@ include file="../init.jsp" %>
<%
	String backURL = ParamUtil.getString(request, "redirect");
	PortletURL portletURL = renderResponse.createRenderURL();
	String redirect = portletURL.toString();
	String[] categoryNames = {"sp-social-login-config-category"};
	String[] categories = {"generalSettings","googlelogin","facebooklogin","twitterlogin","linkedinlogin","microsoftlogin"};
	String[][] categorySections = {categories};
%>

<portlet:actionURL var="saveSocialLoginConfigurationURL">
	<portlet:param name="redirect" value="<%=redirect%>"/>
</portlet:actionURL>

<aui:layout>
	<aui:form action="<%=saveSocialLoginConfigurationURL.toString() %>" name="form">
		<liferay-ui:form-navigator
			backURL="<%= backURL %>"
			categoryNames="<%= categoryNames %>"
			categorySections="<%= categorySections %>"
			formName="form"
			jspPath="/html/spsociallogin/sections/"
			showButtons="<%= true %>"
		/>
	</aui:form>
</aui:layout>