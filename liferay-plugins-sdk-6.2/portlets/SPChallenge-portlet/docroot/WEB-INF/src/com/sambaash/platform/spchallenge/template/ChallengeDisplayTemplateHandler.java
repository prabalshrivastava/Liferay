package com.sambaash.platform.spchallenge.template;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.liferay.portal.kernel.portletdisplaytemplate.BasePortletDisplayTemplateHandler;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.template.TemplateVariableGroup;
import com.liferay.portlet.portletdisplaytemplate.util.PortletDisplayTemplateConstants;
import com.sambaash.platform.spchallenge.helper.SPChallengeConstants;
import com.sambaash.platform.srv.spchallenge.model.SPChallenge;

public class ChallengeDisplayTemplateHandler extends
		BasePortletDisplayTemplateHandler {

	@Override
	public String getClassName() {
		return SPChallenge.class.getName();
	}

	@Override
	public String getName(Locale locale) {
		return "Challenge Display Template";
	}

	@Override
	public String getResourceName() {
		return SPChallengeConstants.PORTLET_ID;
	}

	public Map<String, TemplateVariableGroup> getTemplateVariableGroups(
			long classPK, String language, Locale locale) throws Exception {

		Map<String, TemplateVariableGroup> templateVariableGroups = super
				.getTemplateVariableGroups(classPK, language, locale);

		TemplateVariableGroup templateVariableGroup = templateVariableGroups
				.get("fields");

		templateVariableGroup.empty();

		templateVariableGroup.addCollectionVariable("challenges", List.class,
				PortletDisplayTemplateConstants.ENTRIES, "spChallenge",
				SPChallenge.class, "curChallenge", "spChallengeId");

		templateVariableGroup.addVariable("challenge", SPChallenge.class,
				"challenge");

		templateVariableGroup.addVariable("document", Document.class,
				"document");
		
		templateVariableGroup.addVariable("gsfIndex", Integer.class,
				"gsfIndex");
		
		return templateVariableGroups;
	}

}