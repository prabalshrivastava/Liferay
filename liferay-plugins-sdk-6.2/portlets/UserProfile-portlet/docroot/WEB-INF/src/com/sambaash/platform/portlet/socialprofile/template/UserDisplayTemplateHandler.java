package com.sambaash.platform.portlet.socialprofile.template;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.liferay.portal.kernel.portletdisplaytemplate.BasePortletDisplayTemplateHandler;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.template.TemplateVariableGroup;
import com.liferay.portal.model.User;
import com.liferay.portal.model.UserConstants;
import com.liferay.portlet.portletdisplaytemplate.util.PortletDisplayTemplateConstants;
import com.sambaash.platform.model.Candidate;
import com.sambaash.platform.srv.spsocialprofile.model.SocialProfile;

public class UserDisplayTemplateHandler extends
		BasePortletDisplayTemplateHandler {

	@Override
	public String getClassName() {
		return SocialProfile.class.getName();
	}

	@Override
	public String getName(Locale locale) {
		return "User Profile Display Template";
	}

	@Override
	public String getResourceName() {
		return "UserProfile_WAR_UserProfileportlet";
	}

	public Map<String, TemplateVariableGroup> getTemplateVariableGroups(
			long classPK, String language, Locale locale) throws Exception {

		Map<String, TemplateVariableGroup> templateVariableGroups = super
				.getTemplateVariableGroups(classPK, language, locale);
		TemplateVariableGroup templateVariableGroup = templateVariableGroups
				.get("fields");
		templateVariableGroup.empty();
		
		templateVariableGroup.addCollectionVariable("users", List.class,
				PortletDisplayTemplateConstants.ENTRIES, "user",
				SocialProfile.class, "currUser", "userId");
		
		templateVariableGroup.addVariable("user", User.class,
				"user");
		templateVariableGroup.addVariable("userProfile", SocialProfile.class,
				"userProfile");
		
		templateVariableGroup.addVariable("gsfIndex", Integer.class,
				"gsfIndex");
		
		templateVariableGroup.addVariable("document", Document.class,
				"document");
		
		templateVariableGroup.addVariable("userConstant", UserConstants.class,
				"userConstant");
		templateVariableGroup.addVariable("userId", String.class, 
				"userId");
		return templateVariableGroups;
	}

}
