<%@page import="com.sambaash.platform.util.SambaashUtil"%>
<%@page import="com.liferay.portal.security.auth.AuthTokenUtil"%>
<%@ page import="com.liferay.portal.kernel.util.Constants" %>
<%@ page import="com.liferay.portal.kernel.util.GetterUtil" %>
<%@ include file="/html/init.jsp" %>

<link rel='stylesheet' href='/html/css/hook.css?minifierType=css'>
<link rel='stylesheet' href='/html/css/sp/formio.full.min.css?minifierType=css'>

<script type="text/babel" src='/SPProcessEngine-portlet/js/formv2/ConfigForm.js?v=3'></script>

<%
	long configFormId = 2083; // defaulted
	try {
		String paramFormId = SambaashUtil.getParameter("pe.state.listing.config.form", themeDisplay.getScopeGroupId());
		configFormId = Long.parseLong(paramFormId);
	} catch (Exception e) {
		_log.error(e.getMessage());
	}
	long configStorageId = GetterUtil.getLong(portletPreferences.getValue("configStorageId", "0"));
%>

<liferay-portlet:resourceURL var="resourceURL" plid="<%=themeDisplay.getPlid()%>" portletName="processstatelisting_WAR_SPProcessEngineportlet">
	<portlet:param name="sp_p_auth" value="<%= AuthTokenUtil.getToken(request) %>"/>
</liferay-portlet:resourceURL>

<liferay-portlet:actionURL portletConfiguration="true" var="configurationURL" />

<div id="formContainer">
	<aui:form action="<%=configurationURL%>" method="post" name="configForm">
		<aui:input name="<%=Constants.CMD%>" type="hidden" value="<%=Constants.UPDATE%>" />
		<aui:input name="preferences--configStorageId--" type="hidden" value="<%=configStorageId%>" />
	</aui:form>
</div>

<div class="newPortlets">
	<div id='configFormio' class="formContainer container" ></div>
</div>
	
<aui:script use="aui-base,aui-node,aui-io-request">
	Formio.setPlatformAuth("<%= AuthTokenUtil.getToken(request) %>");
	var userInfo = <%= SambaashUtil.getUserInfo(themeDisplay).toString() %>;
	var p_auth =  "<%= AuthTokenUtil.getToken(request) %>";
	var apiUrl = '<%= SambaashUtil.getFormV2BaseUrl() %>';

	AUI().on('domready', function () {
		var formInstance = new ConfigForm(p_auth, apiUrl, 'configFormio', <%=configFormId%>, <%=configStorageId%>, 
				'<%=resourceURL%>', '<portlet:namespace/>', userInfo,
				<%= SambaashUtil.getScopeGroupId(themeDisplay.getScopeGroupId()) %>
		);	

        window.SPConfigControl = new SPFormController(formInstance);
        formInstance.load();
        formInstance.on('formDataPersisted', function(response) {
        	console.log("Config saved", response);
        	AUI().one("#_86_configStorageId").val(response.formStorageId);
        	AUI().one("#_86_configForm").submit();
        });
	});

</aui:script>

<%!
private static Log _log = LogFactoryUtil.getLog("html.processstate.config_jsp");
%> 
