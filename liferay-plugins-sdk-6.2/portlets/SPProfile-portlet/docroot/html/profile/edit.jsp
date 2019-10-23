<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>

<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.portlet.DefaultConfigurationAction"%>
<%@page import="com.liferay.portal.util.PortletKeys"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page
	import="com.liferay.portlet.portletdisplaytemplate.util.PortletDisplayTemplateUtil"%>
<%@page import="com.liferay.compat.portal.kernel.util.LocaleUtil"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.compat.portal.kernel.util.HtmlUtil"%>
<%@page
	import="com.liferay.portlet.dynamicdatamapping.model.DDMTemplate"%>
<%@page
	import="com.liferay.portlet.dynamicdatamapping.service.DDMTemplateLocalServiceUtil"%>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Arrays"%>
<%@page import="com.sambaash.platform.srv.spsocialprofile.model.SocialProfile" %>
<%@page import="com.liferay.portal.model.User" %>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>

<portlet:defineObjects />
<liferay-theme:defineObjects />


<style>
.aui .component-row-wrapper .control-group{
	margin-bottom: 10px;
}
.sort-selector div {
	margin-right: 8px;
}
</style>

<%
	String selected = "com.sambaash.platform.srv.spsocialprofile.model.SocialProfile";
//GetterUtil.getString(portletPreferences.getValue(
	//		"generic-search-components", ""));
	//List<String> classes = Arrays.asList(selected.split(","));

	String msg = null;
	//if (classes.size() == 1 && classes.contains("")) {
		if(!selected.isEmpty()){
		msg = "select-components-first";
	} else {
		msg = "select-display-template";
	}
%>

<portlet:actionURL var="savePreferencesActionURL">
</portlet:actionURL>
<portlet:renderURL portletMode="view" var="viewURL" />

<aui:row cssClass="ps-pref-container">
	<aui:col span="12">
		<aui:form name="editPreferences" action="<%=savePreferencesActionURL%>">
				
			<aui:input name="nav_config"
			label="Side bar Navigation Configuration" type="textarea" rows="20"
			required="true" value="${nav_config}" style="width:65%;" />
			<aui:input name="invigilatorUpdateUrl" label="Invigilator Update Url"></aui:input>
			<aui:input name="candidateUpdateUrl" label="Candidate Update Url"></aui:input>
			<%@ include file="/html/profile/results.jsp"%>
			
			<aui:button-row>
				<aui:button name="saveButton" type="submit" value="Save" />
				<aui:button type="cancel" onClick="<%=viewURL%>" />
			</aui:button-row>
		</aui:form>
	</aui:col>
</aui:row>