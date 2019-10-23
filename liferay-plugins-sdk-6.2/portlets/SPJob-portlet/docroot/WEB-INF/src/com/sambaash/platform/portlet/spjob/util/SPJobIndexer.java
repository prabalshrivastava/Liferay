package com.sambaash.platform.portlet.spjob.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.portlet.PortletURL;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.BaseIndexer;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.DocumentImpl;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchEngineUtil;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.asset.NoSuchCategoryException;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetTagLocalServiceUtil;
import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeIndexerUtil;
import com.sambaash.platform.srv.spjob.model.SPJob;
import com.sambaash.platform.srv.spjob.service.SPJobLocalServiceUtil;
public class SPJobIndexer extends BaseIndexer {

	public static final String[] CLASS_NAMES = { SPJob.class.getName() };

	public static final String PORTLET_ID = "SPJobCreate_WAR_SPJobportlet";

	public String[] getClassNames() {
		return CLASS_NAMES;
	}

	public String getPortletId() {
		return PORTLET_ID;
	}

	@Override
	public Hits search(SearchContext searchContext) throws SearchException {
		searchContext.setUserId(0);
		return super.search(searchContext);
	}

	@Override
	protected void addSearchKeywords(BooleanQuery searchQuery, SearchContext searchContext) throws Exception {
		String keywords = searchContext.getKeywords();

		if (Validator.isNull(keywords)) {
			return;
		}

		searchQuery.addTerms(_KEYWORDS_FIELDS, keywords);
	}

	@Override
	protected void doDelete(Object obj) throws Exception {
		SPJob job = (SPJob)obj;
		Document document = new DocumentImpl();
		document.addUID(PORTLET_ID, job.getSpJobId());
		SearchEngineUtil.deleteDocument(job.getCompanyId(), document.get(Field.UID));
	}

	@Override
	protected Document doGetDocument(Object obj) throws Exception {
		SPJob job = (SPJob)obj;
		long groupId = job.getGroupId();
		long companyId = job.getCompanyId();
		long jobId = job.getSpJobId();
		String yearsOfExperience = job.getYearsOfExperience();
		String jobLocation = job.getJobLocation();
		String jobTitle = job.getJobTitle();
		Date modifiedDate = job.getModifiedDate();
		Date startDate = job.getStartDate();
		Date createDate = job.getCreateDate();
		Date closeDate = job.getClosingDate();
		Date endDate = job.getEndDate();
		String jobDescription = job.getJobDescription();
		String jobType = job.getJobType();
		String jobStatus = job.getStatus();
		String jobsImageDocId = job.getExtra1();
		String jobsSmallImageDocId = job.getExtra2();

		long[] assetCategoryIds = AssetCategoryLocalServiceUtil.getCategoryIds(SPJob.class.getName(), jobId);

		String[] assetTagNames = AssetTagLocalServiceUtil.getTagNames(SPJob.class.getName(), jobId);

		ExpandoBridge expandoBridge = job.getExpandoBridge();

		Document document = new DocumentImpl();
		document.addUID(PORTLET_ID, jobId);

		StringBuffer sb_extraText = new StringBuffer();

		document.addKeyword(Field.PORTLET_ID, PORTLET_ID);
		document.addKeyword(Field.GROUP_ID, groupId);
		document.addKeyword(Field.COMPANY_ID, companyId);
		document.addKeyword(Field.ASSET_CATEGORY_IDS, assetCategoryIds);
		document.addKeyword(Field.ASSET_TAG_NAMES, assetTagNames);
		document.addKeyword(Field.USER_ID, job.getCreatedBy());
		String userName = PortalUtil.getUserName(job.getCreatedBy(), "");
		document.addKeyword(Field.USER_NAME, userName, true);
		document.addDate(Field.MODIFIED_DATE, modifiedDate);

		document.addDate(SPJobFieldUtil.JOB_START_DATE, startDate);
		document.addDate(SPJobFieldUtil.JOB_CLOSING_DATE, closeDate);
		document.addDate(SPJobFieldUtil.JOB_CREATE_DATE, createDate);
		document.addDate(SPJobFieldUtil.JOB_END_DATE, endDate);

		document.addText(SPJobFieldUtil.JOB_TYPE, jobType);
		document.addText(SPJobFieldUtil.JOB_STATUS, jobStatus);

		document.addKeyword(Field.ENTRY_CLASS_NAME, SPJob.class.getName());
		document.addKeyword(Field.ENTRY_CLASS_PK, jobId);
		document.addKeyword(SPJobFieldUtil.JOB_CORPORATE_ID, job.getCorporateId());

		document.addKeyword(SPJobFieldUtil.YEARS_OF_EXPERIENCE, yearsOfExperience);
		document.addText(SPJobFieldUtil.JOB_LOCATION, jobLocation);
		sb_extraText.append(jobLocation);
		document.addText(Field.TITLE, jobTitle);
		document.addText(Field.DESCRIPTION, HtmlUtil.extractText(jobDescription));
		document.addText(SPJobFieldUtil.YEARS_OF_EXPERIENCE, yearsOfExperience);

		document.addText(SPJobFieldUtil.JOB_LARGE_IMAGE_DOC_ID, jobsImageDocId);
		document.addText(SPJobFieldUtil.JOB_SMALL_IMAGE_DOC_ID, jobsSmallImageDocId);

		StringBuffer acn_sb = new StringBuffer();

		if (assetCategoryIds != null && assetCategoryIds.length > 0) {
			for (int i = 0; i < assetCategoryIds.length; i++) {
				try {
					AssetCategory ac = AssetCategoryLocalServiceUtil.getAssetCategory(assetCategoryIds[i]);
					acn_sb.append(ac.getName() + " ");
				} catch (NoSuchCategoryException nsce) {
					_log.info("No such category exist with primary key: " + assetCategoryIds[i]);
				}
			}

			document.addText(SPJobFieldUtil.ASSET_CATEGORY_NAMES, acn_sb.toString());
		}

//		long creatorUserId = job.getCreatedBy();
//		long mpId;
//		boolean isCorporateUser = CorporateProfileUserLocalServiceUtil.isCorporateUser(creatorUserId);
//		if (isCorporateUser) {
//			CorporateProfileUser corpProfileUser = CorporateProfileUserLocalServiceUtil.getCorporateProfilesByUserId(creatorUserId);
//			CorporateProfile corp = CorporateProfileLocalServiceUtil.getCorporateProfile(corpProfileUser.getProfileId());
//			mpId = corp.getMembershipId();
//		} else {
//			SocialProfile socialProfile = SocialProfileLocalServiceUtil.getSocialProfile(creatorUserId);
//			mpId = socialProfile.getMemberPackage();
//		}
//		MembershipPackage membershipPackage = MembershipPackageLocalServiceUtil.getMembershipPackage(Long.valueOf(mpId));
//		String weightage = membershipPackage.getExtra7();
//		_log.info("membership package weightage : " + weightage + "for mpId : " + mpId);
//
//		try {
//			document.addKeyword(SPJobFieldUtil.JOB_WEIGHTAGE, Integer.valueOf(weightage));
//		} catch (NumberFormatException nfe) {
//		}
//
//		long corporateId = job.getCorporateId();
//		try {
//			CorporateProfile corpProfile = CorporateProfileLocalServiceUtil.getCorporateProfile(corporateId);
//			String companyName = corpProfile.getName();
//			String companyIndustry = CorporateProfileIndustryLocalServiceUtil.getCorpProfileIndustry(corporateId);
//			String companySize = corpProfile.getCompanySize();
//
//			document.addText(SPJobFieldUtil.COMPANY_NAME, companyName);
//			document.addText(SPJobFieldUtil.COMPANY_NAME_FIREST_LETTER, companyName.substring(0, 1));
//			document.addKeyword(SPJobFieldUtil.COMPANY_INDUSTRY, companyIndustry);
//			document.addKeyword(SPJobFieldUtil.COMPANY_SIZE, companySize);
//			sb_extraText.append(companyIndustry);
//			sb_extraText.append(companySize);
//		} catch (NoSuchCorporateProfileException nscpe) {
//			_log.error("No such corporateProfile exist with corpProfileId :" + corporateId);
//			if (Validator.isNotNull(job.getCorporateName())) {
//				document.addText(SPJobFieldUtil.COMPANY_NAME, job.getCorporateName());
//				document.addText(SPJobFieldUtil.COMPANY_NAME_FIREST_LETTER, job.getCorporateName().substring(0, 1));
//			}
//		}

		document.addText(SPJobFieldUtil.JOB_EXTRA_TEXT, sb_extraText.toString());

		ExpandoBridgeIndexerUtil.addAttributes(document, expandoBridge);

		return document;
	}

	@Override
	protected Summary doGetSummary(Document document, Locale locale, String snippet, PortletURL portletURL) throws Exception {
		String title = document.get(Field.TITLE);
		String content = snippet;

		if (Validator.isNull(snippet)) {
			content = StringUtil.shorten(HtmlUtil.stripHtml(document.get(Field.DESCRIPTION)), 200);
		}

		String entryId = document.get(Field.ENTRY_CLASS_PK);

		portletURL.setParameter("struts_action", "/job/view_entry");
		portletURL.setParameter("entryId", entryId);

		return new Summary(title, content, portletURL);
	}

	@Override
	protected void doReindex(Object obj) throws Exception {
		SPJob job = (SPJob)obj;
		Document document = getDocument(job);
		SearchEngineUtil.updateDocument(job.getCompanyId(), document);
	}

	@Override
	protected void doReindex(String className, long classPK) throws Exception {
		SPJob job = SPJobLocalServiceUtil.getSPJob(classPK);
		doReindex(job);
	}

	@Override
	protected void doReindex(String[] ids) throws Exception {
		long companyId = GetterUtil.getLong(ids[0]);

		List<SPJob> allJobs = SPJobLocalServiceUtil.getSPJobs(-1, -1);

		if (allJobs.isEmpty()) {
			return;
		}

		Collection<Document> documents = new ArrayList<Document>();

		for (SPJob job : allJobs) {
			String status = job.getStatus();
//			if (!"closed".equalsIgnoreCase(status) && !"draft".equalsIgnoreCase(status)) {
			if (!"closed".equalsIgnoreCase(status)) {
				Document document = getDocument(job);
				documents.add(document);
			}
		}

		SearchEngineUtil.updateDocuments(companyId, documents);
	}

	@Override
	protected String getPortletId(SearchContext searchContext) {
		return PORTLET_ID;
	}

	private static final String[] _KEYWORDS_FIELDS = { Field.ASSET_TAG_NAMES, Field.COMMENTS, Field.CONTENT, Field.DESCRIPTION, Field.PROPERTIES,
			Field.TITLE, Field.URL, Field.USER_NAME, SPJobFieldUtil.JOB_LOCATION, SPJobFieldUtil.COMPANY_NAME, SPJobFieldUtil.YEARS_OF_EXPERIENCE,
			SPJobFieldUtil.JOB_EXTRA_TEXT, SPJobFieldUtil.ASSET_CATEGORY_NAMES };

	private static Log _log = LogFactoryUtil.getLog(SPJobIndexer.class);

}