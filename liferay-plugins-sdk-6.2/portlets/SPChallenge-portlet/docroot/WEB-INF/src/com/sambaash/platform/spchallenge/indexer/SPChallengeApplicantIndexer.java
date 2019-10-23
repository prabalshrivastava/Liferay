package com.sambaash.platform.spchallenge.indexer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.PortletURL;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.BaseIndexer;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchEngineUtil;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.sambaash.platform.spchallenge.helper.SPChallengeConstants;
import com.sambaash.platform.srv.spchallenge.model.SPChallenge;
import com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant;
import com.sambaash.platform.srv.spchallenge.service.SPChallengeApplicantLocalServiceUtil;
import com.sambaash.platform.srv.spchallenge.service.SPChallengeLocalServiceUtil;
import com.sambaash.platform.srv.startupprofile.model.Organization;
import com.sambaash.platform.srv.startupprofile.service.OrganizationLocalServiceUtil;

public class SPChallengeApplicantIndexer extends BaseIndexer {

	public static final String[] CLASS_NAMES = { SPChallengeApplicant.class.getName() };
	private static final Log logger = LogFactoryUtil.getLog(SPChallengeApplicantIndexer.class);

	@Override
	public String[] getClassNames() {
		return CLASS_NAMES;
	}

	@Override
	public String getPortletId() {
		return SPChallengeConstants.APPLICANT_PORTLET_ID;
	}

	@Override
	protected void doDelete(Object obj) throws Exception {
		SPChallengeApplicant applicant = (SPChallengeApplicant) obj;
		deleteDocument(applicant.getCompanyId(), applicant.getSpChallengeApplicantId());
	}

	@Override
	protected Document doGetDocument(Object obj) throws Exception {
		SPChallengeApplicant applicant = (SPChallengeApplicant) obj;
		Document document = getBaseModelDocument(SPChallengeConstants.APPLICANT_PORTLET_ID, applicant);
		document.addKeyword(SPChallengeConstants.CHALLENGE_APPLICANT_ID, applicant.getSpChallengeApplicantId());
		document.addUID(SPChallengeConstants.PORTLET_ID, applicant.getUuid());
		document.addText(SPChallengeConstants.Q1, applicant.getQ1());
		document.addText(SPChallengeConstants.Q2, applicant.getQ2());
		document.addText(SPChallengeConstants.Q3, applicant.getQ3());
		document.addText(SPChallengeConstants.Q4, applicant.getQ4());
		document.addText(SPChallengeConstants.Q5, applicant.getQ5());
		document.addText(SPChallengeConstants.Q6, applicant.getQ6());
		document.addText(SPChallengeConstants.Q7, applicant.getQ7());
		document.addText(SPChallengeConstants.Q8, applicant.getQ8());
		document.addText(SPChallengeConstants.Q9, applicant.getQ9());
		document.addText(SPChallengeConstants.Q10, applicant.getQ10());
		document.addText(SPChallengeConstants.Q11, applicant.getQ11());
		document.addText(SPChallengeConstants.Q12, applicant.getQ12());
		document.addText(SPChallengeConstants.Q13, applicant.getQ13());
		document.addText(SPChallengeConstants.Q14, applicant.getQ14());
		document.addText(SPChallengeConstants.Q15, applicant.getQ15());
		document.addText(SPChallengeConstants.Q16, applicant.getQ16());
		document.addText(SPChallengeConstants.Q17, applicant.getQ17());
		document.addText(SPChallengeConstants.Q18, applicant.getQ18());
		document.addText(SPChallengeConstants.Q19, applicant.getQ19());
		document.addText(SPChallengeConstants.Q20, applicant.getQ20());
		document.addKeyword(SPChallengeConstants.CHALLENGE_ID, applicant.getSpChallengeId());
		SPChallenge challenge = SPChallengeLocalServiceUtil.fetchSPChallenge(applicant.getSpChallengeId());
		document.addKeyword(SPChallengeConstants.CHALLENGE_NAME, challenge.getName());
		document.addKeyword(SPChallengeConstants.TYPE, applicant.getApplicantType());
		document.addKeyword(SPChallengeConstants.APPLICANT_REF_ID, applicant.getApplicantRefId());
		// TODO check applicant type then get organizaiotn
		try {
			Organization org = OrganizationLocalServiceUtil.fetchOrganization(applicant.getApplicantRefId());
			document.addText(SPChallengeConstants.ORGANIZATION_NAME,org.getName());
			String orgEmailAddress = UserLocalServiceUtil.getUser(org.getUserId()).getEmailAddress();
			document.addText(SPChallengeConstants.ORGANIZATION_OWNER, orgEmailAddress);
		} catch (Exception ex) {
			logger.error(ex);
		}
		document.addKeyword(SPChallengeConstants.ACTIVE, applicant.getActive());
		document.addKeyword(SPChallengeConstants.CUSTOM_STATUS1, applicant.getCustomStatus1());
		document.addKeyword(SPChallengeConstants.CUSTOM_STATUS2, applicant.getCustomStatus2());
		document.addText(SPChallengeConstants.CHALLENGE_OWNER, challenge.getScout());
		document.addKeyword(SPChallengeConstants.FILE_ENTRY_ID, challenge.getLogoId());
		document.addDate(SPChallengeConstants.END_DATE, challenge.getEndDate());
		document.addKeyword(SPChallengeConstants.APPLICATION_STATUS, applicant.getApplicationStatus());
		document.addKeyword(SPChallengeConstants.NOTIFICATION_STATUS, applicant.getNotificationStatus());

		return document;
	}

	@Override
	protected Summary doGetSummary(Document document, Locale locale, String snippet, PortletURL portletURL)
			throws Exception {
		if (Validator.isNull(snippet)) {
			snippet = document.get(SPChallengeConstants.ORGANIZATION_NAME);
		}
		String entryId = document.get(Field.ENTRY_CLASS_PK);
		portletURL.setParameter(SPChallengeConstants.CHALLENGE_APPLICANT_ID, entryId);
		return new Summary(snippet, snippet, portletURL);
	}

	@Override
	protected void doReindex(Object obj) throws Exception {
		SPChallengeApplicant applicant = (SPChallengeApplicant) obj;
		Document document = getDocument(applicant);
		SearchEngineUtil.updateDocument(getSearchEngineId(), applicant.getCompanyId(), document, true);
	}

	@Override
	protected void doReindex(String[] ids) throws Exception {
		long companyId = GetterUtil.getLong(ids[0]);

		List<SPChallengeApplicant> list = SPChallengeApplicantLocalServiceUtil.getSPChallengeApplicants(-1, -1);
		if (list.isEmpty()) {
			return;
		}
		Collection<Document> documents = new ArrayList<Document>();
		for (SPChallengeApplicant classObj : list) {
			Document document = getDocument(classObj);
			documents.add(document);
		}
		SearchEngineUtil.updateDocuments(getSearchEngineId(), companyId, documents, true);

	}

	@Override
	protected void doReindex(String arg0, long arg1) throws Exception {
		SPChallengeApplicant applicant = SPChallengeApplicantLocalServiceUtil.getSPChallengeApplicant(arg1);
		doReindex(applicant);
	}

	@Override
	protected String getPortletId(SearchContext arg0) {
		return SPChallengeConstants.APPLICANT_PORTLET_ID;
	}

	@Override
	public Map<String, String> getIndexedFields() {
		Map<String, String> map = new HashMap<String, String>(super.getIndexedFields());
		map.put(SPChallengeConstants.CHALLENGE_APPLICANT_ID, "Challenge Applicant Id");
		map.put(SPChallengeConstants.CHALLENGE_ID, "Challenge Id");
		map.put(SPChallengeConstants.CHALLENGE_NAME, "Challenge Name");
		map.put(SPChallengeConstants.TYPE, "Challenge Type");
		map.put(SPChallengeConstants.APPLICANT_REF_ID, "Applicant Reference Id");
		map.put(SPChallengeConstants.ORGANIZATION_NAME, "Startup Name");
		map.put(SPChallengeConstants.ACTIVE, "Active");
		map.put(SPChallengeConstants.CUSTOM_STATUS1, "Custom Status 1");
		map.put(SPChallengeConstants.CUSTOM_STATUS2, "Custom Status 2");
		map.put(SPChallengeConstants.CHALLENGE_OWNER, "Challenge Owner");
		map.put(SPChallengeConstants.FILE_ENTRY_ID, "File Entry Id");
		map.put(SPChallengeConstants.END_DATE, "Challenge End Date");
		map.put(SPChallengeConstants.Q1, "Question 1");
		map.put(SPChallengeConstants.Q2, "Question 2");
		map.put(SPChallengeConstants.Q3, "Question 3");
		map.put(SPChallengeConstants.Q4, "Question 4");
		map.put(SPChallengeConstants.Q5, "Question 5");
		map.put(SPChallengeConstants.Q6, "Question 6");
		map.put(SPChallengeConstants.Q7, "Question 7");
		map.put(SPChallengeConstants.Q8, "Question 8");
		map.put(SPChallengeConstants.Q9, "Question 9");
		map.put(SPChallengeConstants.Q10, "Question 10");
		map.put(SPChallengeConstants.Q11, "Question 11");
		map.put(SPChallengeConstants.Q12, "Question 12");
		map.put(SPChallengeConstants.Q13, "Question 13");
		map.put(SPChallengeConstants.Q14, "Question 14");
		map.put(SPChallengeConstants.Q15, "Question 15");
		map.put(SPChallengeConstants.Q16, "Question 16");
		map.put(SPChallengeConstants.Q17, "Question 17");
		map.put(SPChallengeConstants.Q18, "Question 18");
		map.put(SPChallengeConstants.Q19, "Question 19");
		map.put(SPChallengeConstants.Q20, "Question 20");
		map.put(SPChallengeConstants.APPLICATION_STATUS, "Application Status");
		map.put(SPChallengeConstants.NOTIFICATION_STATUS, "Notification Status");
		map.put(SPChallengeConstants.ORGANIZATION_OWNER, "Organization Email");
		return map;
	}

}
