<%@page import="com.liferay.portal.util.PortletKeys"%>
<%@page import="com.liferay.compat.portal.kernel.util.LocaleUtil"%>
<%@page import="com.liferay.compat.portal.kernel.util.HtmlUtil"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portlet.dynamicdatamapping.model.DDMTemplate"%>
<%@page import="com.liferay.portlet.portletdisplaytemplate.util.PortletDisplayTemplateUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portlet.dynamicdatamapping.service.DDMTemplateLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.DefaultConfigurationAction"%>
<%@page import="com.sambaash.platform.srv.spsocialprofile.model.SocialProfile"%>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.log.Log" %>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil" %>


<portlet:defineObjects />
<liferay-theme:defineObjects /> 


<aui:row>
	<aui:col span="12">
		<label class="margin-bottom-quarter"> <liferay-ui:message
				key="<%=msg%>" /> <liferay-ui:icon image="help"
				message="create-template-help" toolTip="false" />
		</label>
	</aui:col>
</aui:row>
<%
	
	//for (String clazz : classes) {
		//try {
			String clazz = selected;
			if(clazz.equalsIgnoreCase(SocialProfile.class.getName())){
				clazz = SocialProfile.class.getName();
			}
			String nameAttribute = DefaultConfigurationAction.PREFERENCES_PREFIX + "displayStyle" + StringPool.DOUBLE_DASH + clazz + StringPool.DOUBLE_DASH;
			Long selectedTemplateId = GetterUtil.getLong(portletPreferences.getValue("displayStyle" + StringPool.DOUBLE_DASH + clazz, null));
			List<DDMTemplate> companyPortletDDMTemplates = DDMTemplateLocalServiceUtil
					.getTemplates(themeDisplay.getCompanyGroupId(),
							PortalUtil.getClassNameId(clazz), 0);
			List<DDMTemplate> groupDDMTemplates = DDMTemplateLocalServiceUtil
					.getTemplates(PortletDisplayTemplateUtil.getDDMTemplateGroupId(themeDisplay.getScopeGroupId()),
							PortalUtil.getClassNameId(clazz), 0);
			if ((Validator.isNotNull(companyPortletDDMTemplates) && companyPortletDDMTemplates.size()>0) ||
				(Validator.isNotNull(groupDDMTemplates) && groupDDMTemplates.size() > 0)) {
					%>
					<div class="generic-search-template-select">
					<aui:select id="displayStyle"
						label="<%=clazz%>" name="displayStyle">
						<optgroup label="<liferay-ui:message key="global-templates" />">
							<%
							if(companyPortletDDMTemplates.size() > 0) {
							try {
							for (DDMTemplate companyPortletDDMTemplate : companyPortletDDMTemplates) {
								Long value = companyPortletDDMTemplate.getTemplateId();
								boolean isSelected = (selectedTemplateId != null && value.equals(selectedTemplateId))? true : false;
								 %>
								<aui:option label="<%= HtmlUtil.escape(companyPortletDDMTemplate.getName(LocaleUtil.getDefault())) %>" 
										selected="<%= isSelected %>" value="<%= value %>" />
							   <%
							}}catch(Exception e){_log.error(e.getMessage());}
							} else {
								out.println("<option disabled='true' value=''>No Templates</option>");
							}
							%>
						</optgroup>
						<optgroup label="<liferay-ui:message key="group-templates" />">
							<%
							try {
							for (DDMTemplate groupDDMTemplate : groupDDMTemplates) {
								Long value = groupDDMTemplate.getTemplateId();
								boolean isSelected = (selectedTemplateId != null && value.equals(selectedTemplateId))? true : false;
								 %>
								<aui:option label="<%= HtmlUtil.escape(groupDDMTemplate.getName(LocaleUtil.getDefault())) %>" 
										selected="<%= isSelected %>" value="<%= value %>" />
							   <%
							}}catch(Exception e){_log.error(e.getMessage());}
							%>
						</optgroup>
					</aui:select>
					</div>
					<%
			} else {
				if (!clazz.equals("")) {
				%>
					<div>
						<%=LanguageUtil.format(pageContext, "no-display-template-found-for-x", clazz) %>. 
						<liferay-ui:icon message="create" label="true" target="_blank" 
							url="<%=PortalUtil.getControlPanelFullURL(themeDisplay.getScopeGroupId(), PortletKeys.PORTLET_DISPLAY_TEMPLATES, null) %>"></liferay-ui:icon>
					</div>
				<%
				}
			}
		//} catch (Exception e) {
		//}
	//}
%>

<%!
private static Log _log = LogFactoryUtil.getLog("html.profile.results_jsp");
%>
