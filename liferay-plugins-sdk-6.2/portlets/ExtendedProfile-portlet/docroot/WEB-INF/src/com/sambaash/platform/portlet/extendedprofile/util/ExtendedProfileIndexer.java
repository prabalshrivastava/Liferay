package com.sambaash.platform.portlet.extendedprofile.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;

import javax.portlet.PortletURL;

import com.liferay.portal.NoSuchUserException;
import com.liferay.portal.kernel.search.BaseIndexer;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchEngineUtil;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.sambaash.platform.srv.extendedprofile.model.SPCompetency;
import com.sambaash.platform.srv.extendedprofile.service.SPCompetencyLocalServiceUtil;
import com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException;
import com.sambaash.platform.srv.spsocialprofile.model.SocialProfile;
import com.sambaash.platform.srv.spsocialprofile.service.SocialProfileLocalServiceUtil;
public class ExtendedProfileIndexer extends BaseIndexer {

	public static final String[] CLASS_NAMES = {SPCompetency.class.getName()};

	public static final String PORTLET_ID = "JobRole_WAR_ExtendedProfileportlet";

	public String[] getClassNames() {
		return CLASS_NAMES;
	}

	public String getPortletId() {
		return PORTLET_ID;
	}

	@Override
	protected void doDelete(Object obj) throws Exception {
		SPCompetency competency = (SPCompetency)obj;

		deleteDocument(competency.getCompanyId(), competency.getClasspk());
	}

	@Override
	protected Document doGetDocument(Object obj) throws Exception {
		SPCompetency competency = (SPCompetency)obj;

		Document document = getBaseModelDocument(PORTLET_ID, competency);

		long userId = competency.getUserId();

		try {
			User user = UserLocalServiceUtil.getUserById(userId);

			if (user != null) {
				document.addText("fullName", user.getFullName());
				document.addKeyword("portraitId", String.valueOf(user.getPortraitId()));
			}
		}catch (NoSuchUserException nsue) {
		}

		try {
			SocialProfile socialProfile = SocialProfileLocalServiceUtil.getSocialProfile(userId);
			document.addText("about", HtmlUtil.extractText(Validator.isNotNull(socialProfile.getAbout()) ? socialProfile.getAbout() : ""));
		}catch (NoSuchSocialProfileException nsspe) {
		}

		return document;
	}

	@Override
	protected Summary doGetSummary(Document document, Locale locale, String snippet,
			PortletURL portletURL) throws Exception {
		String fullName = document.get("fullName");
		String about = document.get("about");

		String title = fullName;
		String content = null;

		return new Summary(title, content, portletURL);
	}

	@Override
	protected void doReindex(Object obj) throws Exception {
		SPCompetency competency = (SPCompetency)obj;

		Document document = getDocument(competency);

		SearchEngineUtil.updateDocument(competency.getCompanyId(), document);
	}

	@Override
	protected void doReindex(String className, long classPK) throws Exception {
		SPCompetency competency = SPCompetencyLocalServiceUtil.getSPCompetency(classPK);

		doReindex(competency);
	}

	@Override
	protected void doReindex(String[] ids) throws Exception {
		long companyId = GetterUtil.getLong(ids[0]);

		reindexEntries(companyId);
	}

	@Override
	protected String getPortletId(SearchContext searchContext) {
		return PORTLET_ID;
	}

	protected void reindexEntries(long companyId) throws Exception {
		List<SPCompetency> competencies = SPCompetencyLocalServiceUtil.getSPCompetencies(-1, -1);

		if (competencies.isEmpty()) {
			return;
		}

		Collection<Document> documents = new ArrayList<Document>();

		for (SPCompetency competency : competencies) {
			Document document = getDocument(competency);

			documents.add(document);
		}

		SearchEngineUtil.updateDocuments(companyId, documents);
	}

}