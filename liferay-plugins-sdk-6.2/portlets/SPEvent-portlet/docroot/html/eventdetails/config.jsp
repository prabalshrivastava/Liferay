<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.liferay.portal.kernel.util.LocaleUtil"%>
<%@page import="com.liferay.portal.util.PortletKeys"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portlet.portletdisplaytemplate.util.PortletDisplayTemplateUtil"%>
<%@page import="com.liferay.calendar.model.CalendarBooking"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.liferay.portlet.dynamicdatamapping.model.DDMTemplate"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portlet.dynamicdatamapping.service.DDMTemplateLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.portlet.DefaultConfigurationAction"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.liferay.portal.kernel.log.Log" %>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>

<portlet:defineObjects />
<liferay-theme:defineObjects />

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>

<liferay-portlet:actionURL portletConfiguration="true"
	var="configurationURL" />
<div class="margin-half">
	<liferay-ui:message key="select-template-for-event-detail" />
</div>
<aui:form action="<%=configurationURL%>" method="post" name="fm"
	cssClass="margin-left-half margin-right-one">
	<div class="cta-links">
		<aui:button-row cssClass="inline-block">
			<aui:button type="submit" />
		</aui:button-row>
		<aui:button-row cssClass="inline-block">
			<aui:button type="cancel" />
		</aui:button-row>
	</div>
	<aui:input name="<%=Constants.CMD%>" type="hidden"
		value="<%=Constants.UPDATE%>" />
		
		<%
		try {
			String clazz = CalendarBooking.class.getName();
			String nameAttribute = DefaultConfigurationAction.PREFERENCES_PREFIX + "displayStyle" + StringPool.DOUBLE_DASH;
			Long selectedTemplateId = GetterUtil.getLong(portletPreferences.getValue("displayStyle", null));
			Long classId = PortalUtil.getClassNameId(clazz);
			List<DDMTemplate> companyPortletDDMTemplates = DDMTemplateLocalServiceUtil
					.getTemplates(themeDisplay.getCompanyGroupId(), classId
							, 0);
			List<DDMTemplate> groupDDMTemplates = DDMTemplateLocalServiceUtil
					.getTemplates(PortletDisplayTemplateUtil.getDDMTemplateGroupId(themeDisplay.getScopeGroupId()),
							classId, 0);
			if ((Validator.isNotNull(companyPortletDDMTemplates) && companyPortletDDMTemplates.size()>0) ||
				(Validator.isNotNull(groupDDMTemplates) && groupDDMTemplates.size() > 0)) {
					%>
					<aui:select id="displayStyle"
						label="<%=clazz%>" name="<%=nameAttribute%>">
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
								<% }
							}catch(Exception e){_log.error(e.getMessage());}
							%>
						</optgroup>
					</aui:select>
					<%
			} else {
				%>
					<div>
						<%=LanguageUtil.format(pageContext, "no-display-template-found-for-x", clazz) %>. 
						<liferay-ui:icon message="create" label="true" target="_blank" 
							url="<%=PortalUtil.getControlPanelFullURL(themeDisplay.getScopeGroupId(), PortletKeys.PORTLET_DISPLAY_TEMPLATES, null) %>"></liferay-ui:icon>
					</div>
				<%
			}
		} catch (Exception e) {
			_log.error(e.getMessage());
		}
	%>

</aui:form>

<%!
private static Log _log = LogFactoryUtil.getLog("html.eventdetails.config_jsp");
%>