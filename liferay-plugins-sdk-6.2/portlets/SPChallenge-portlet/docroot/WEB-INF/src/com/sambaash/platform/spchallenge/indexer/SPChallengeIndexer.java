package com.sambaash.platform.spchallenge.indexer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.PortletURL;

import com.liferay.portal.kernel.search.BaseIndexer;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchEngineUtil;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.sambaash.platform.spchallenge.helper.SPChallengeConstants;
import com.sambaash.platform.srv.spchallenge.model.SPChallenge;
import com.sambaash.platform.srv.spchallenge.service.SPChallengeLocalServiceUtil;
import com.sambaash.platform.util.SPHtmlUtil;

public class SPChallengeIndexer extends BaseIndexer {
	
	public static final String[] CLASS_NAMES = { SPChallenge.class.getName() };

	@Override
	public String[] getClassNames() {
		return CLASS_NAMES;
	}

	@Override
	public String getPortletId() {
		return SPChallengeConstants.PORTLET_ID;
	}

	@Override
	protected void doDelete(Object obj) throws Exception {
		SPChallenge challenge = (SPChallenge) obj;
		deleteDocument(challenge.getCompanyId(), challenge.getSpChallengeId());
	}

	@Override
	protected Document doGetDocument(Object obj) throws Exception {
		SPChallenge challenge = (SPChallenge) obj;
		Document document = getBaseModelDocument(SPChallengeConstants.PORTLET_ID, challenge);
		document.addUID(SPChallengeConstants.PORTLET_ID, challenge.getUuid());
		document.addText(SPChallengeConstants.NAME, challenge.getName());		
		document.addText(SPChallengeConstants.OPEN_TO, challenge.getOpenTo());
		document.addText(SPChallengeConstants.TYPE, challenge.getType());
		String formatDescription = challenge.getBackground();
		formatDescription = formatDescription.replaceAll("[\r\n]", "<br>");
		document.addText(SPChallengeConstants.BACKGROUND, formatDescription);
		document.addText(SPChallengeConstants.DESCRIPTION, challenge.getDescription());
		document.addText(SPChallengeConstants.SCOPE, challenge.getScope());
		document.addText(SPChallengeConstants.BUDGET, challenge.getBudget());
		document.addText(SPChallengeConstants.BENEFIT, challenge.getBenefits());
		document.addText(SPChallengeConstants.EXTRAS, challenge.getExtras());
		document.addDate(SPChallengeConstants.START_DATE, challenge.getStartDate());
		document.addDate(SPChallengeConstants.END_DATE, challenge.getEndDate());
		document.addKeyword(SPChallengeConstants.FILE_ENTRY_ID, challenge.getLogoId());
		document.addDate(SPChallengeConstants.APPLY_BY, challenge.getApplyBy());
		document.addKeyword(SPChallengeConstants.ACTIVE, challenge.getActive());
		document.addKeyword(SPChallengeConstants.DRAFT, challenge.getDraft());
		return document;
	}

	@Override
	protected Summary doGetSummary(Document document, Locale locale,
			String snippet, PortletURL portletURL) throws Exception {
		if (Validator.isNull(snippet)) {
			snippet = document.get(SPChallengeConstants.NAME);
		}
		String entryId = document.get(Field.ENTRY_CLASS_PK);
		portletURL.setParameter(SPChallengeConstants.CHALLENGE_ID, entryId);
		return new Summary(snippet, snippet, portletURL);
	}

	@Override
	protected void doReindex(Object obj) throws Exception {
		SPChallenge challenge = (SPChallenge) obj;
		Document document = getDocument(challenge);
		SearchEngineUtil.updateDocument(getSearchEngineId(), challenge.getCompanyId(), document, true);
	}

	@Override
	protected void doReindex(String[] ids) throws Exception {
		long companyId = GetterUtil.getLong(ids[0]);

		List<SPChallenge> list = SPChallengeLocalServiceUtil.getSPChallenges(-1, -1);
		if (list.isEmpty()) {
			return;
		}
		Collection<Document> documents = new ArrayList<Document>();
		for (SPChallenge classObj: list) {
			Document document = getDocument(classObj);
			documents.add(document);
		}
		SearchEngineUtil.updateDocuments(getSearchEngineId(), companyId, documents, true);
	
	}

	@Override
	protected void doReindex(String arg0, long arg1) throws Exception {
		SPChallenge challenge = SPChallengeLocalServiceUtil.getSPChallenge(arg1);
		doReindex(challenge);
	}

	@Override
	protected String getPortletId(SearchContext arg0) {
		return SPChallengeConstants.PORTLET_ID;
	}
	
	
	public Map<String, String> getIndexedFields() {
		Map<String, String> map = new HashMap<String, String>(super.getIndexedFields());
		map.put(SPChallengeConstants.NAME, "Challenge Name");
		map.put(SPChallengeConstants.OPEN_TO, "Open To");
		map.put(SPChallengeConstants.TYPE, "Challenge Type");
		map.put(SPChallengeConstants.BACKGROUND, "Background");
		map.put(SPChallengeConstants.DESCRIPTION, "Description");
		map.put(SPChallengeConstants.SCOPE, "Scope");
		map.put(SPChallengeConstants.BUDGET, "Budget");
		map.put(SPChallengeConstants.BENEFIT, "Benefits");
		map.put(SPChallengeConstants.EXTRAS, "Extras");
		map.put(SPChallengeConstants.START_DATE, "Start Date");
		map.put(SPChallengeConstants.END_DATE, "End Date");
		map.put(SPChallengeConstants.FILE_ENTRY_ID, "Logo Id");
		map.put(SPChallengeConstants.APPLY_BY, "Apply By");
		map.put(SPChallengeConstants.ACTIVE, "Active");
		map.put(SPChallengeConstants.DRAFT, "Draft");
		return map;
	}
	
}
