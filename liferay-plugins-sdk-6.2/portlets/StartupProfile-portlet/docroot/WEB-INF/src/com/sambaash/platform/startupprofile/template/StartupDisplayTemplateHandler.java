package com.sambaash.platform.startupprofile.template;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.liferay.portal.kernel.portletdisplaytemplate.BasePortletDisplayTemplateHandler;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.template.TemplateVariableGroup;
import com.liferay.portlet.portletdisplaytemplate.util.PortletDisplayTemplateConstants;
import com.sambaash.platform.srv.startupprofile.model.Organization;
import com.sambaash.platform.startupprofile.StartupConstants;

public class StartupDisplayTemplateHandler extends
		BasePortletDisplayTemplateHandler {

	@Override
	public String getClassName() {
		return Organization.class.getName();
	}

	@Override
	public String getName(Locale locale) {
		return "Startup Display Template";
	}

	@Override
	public String getResourceName() {
		return StartupConstants.PORTLET_ID;
	}

	public Map<String, TemplateVariableGroup> getTemplateVariableGroups(
			long classPK, String language, Locale locale) throws Exception {

		Map<String, TemplateVariableGroup> templateVariableGroups = super
				.getTemplateVariableGroups(classPK, language, locale);

		TemplateVariableGroup templateVariableGroup = templateVariableGroups
				.get("fields");

		templateVariableGroup.empty();

		templateVariableGroup.addCollectionVariable("organizations", List.class,
				PortletDisplayTemplateConstants.ENTRIES, "spOrganization",
				Organization.class, "curOrg", "spOrganizationId");

		templateVariableGroup.addVariable("organization", Organization.class,
				"organization");
		
		templateVariableGroup.addVariable("document", Document.class,
				"document");
		
		templateVariableGroup.addVariable("gsfIndex", Integer.class,
				"gsfIndex");

		return templateVariableGroups;
	}

}