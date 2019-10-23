package com.sambaash.platform.startupprofile.indexer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.PortletURL;

import org.apache.commons.lang.StringUtils;

import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.BaseIndexer;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchEngineUtil;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil;
import com.sambaash.platform.constant.SambaashConstants;
import com.sambaash.platform.srv.startupprofile.model.Address;
import com.sambaash.platform.srv.startupprofile.model.FundingRound;
import com.sambaash.platform.srv.startupprofile.model.Organization;
import com.sambaash.platform.srv.startupprofile.model.Person;
import com.sambaash.platform.srv.startupprofile.model.SPOrgContactUs;
import com.sambaash.platform.srv.startupprofile.service.OrganizationLocalServiceUtil;
import com.sambaash.platform.startupprofile.RatingConstants;
import com.sambaash.platform.startupprofile.StartupConstants;
import com.sambaash.platform.startupprofile.helper.RatingHelper;
import com.sambaash.platform.util.SambaashUtil;

public class StartupProfileIndexer extends BaseIndexer {

	private static final Log logger = LogFactoryUtil.getLog(StartupProfileIndexer.class);
	public static final String[] CLASS_NAMES = { Organization.class.getName() };

	@Override
	public String[] getClassNames() {
		return CLASS_NAMES;
	}

	@Override
	public String getPortletId() {
		return StartupConstants.PORTLET_ID;
	}

	@Override
	protected void doDelete(Object obj) throws Exception {
		Organization organization = (Organization) obj;
		deleteDocument(organization.getCompanyId(), organization.getOrganizationId());
	}

	@Override
	protected Document doGetDocument(Object obj) throws Exception {
		
		Organization org = (Organization) obj;
		
		if (logger.isDebugEnabled()) {
			logger.debug("org.getOrganizationId() : " + org.getOrganizationId());
		}
		
		String agentName = StringPool.BLANK;
		
		Document document = getBaseModelDocument(StartupConstants.PORTLET_ID, org);
		document.addUID(StartupConstants.PORTLET_ID, org.getUuid());
		document.addText(StartupConstants.NAME, org.getName());
		document.addText(StartupConstants.SHORT_DESCRIPTION, org.getShortPitch());
		document.addText(StartupConstants.DESCRIPTION, org.getDescription());
		document.addKeyword(StartupConstants.FILE_ENTRY_ID, org.getLogoId());
		document.addKeyword(StartupConstants.ACTIVE, org.isActive());
		document.addKeyword(StartupConstants.BASE_ORG, org.isIsBaseOrg());
		document.addKeyword(StartupConstants.ATO, org.isIsATO());
		document.addKeyword(StartupConstants.UEN, org.getUen());
		document.addKeyword(StartupConstants.CORPORATE_CODE, org.getCorporateCode());
		document.addText(StartupConstants.EMAIL, org.getEmailId());
		document.addText(StartupConstants.WEBSITE, org.getWebsite());
		document.addText(StartupConstants.FOUNDED, org.getFoundedOn());
		document.addText(StartupConstants.TOTAL_FUNDS, org.getTotalFunds());
//		document.addText(StartupConstants.STAGE, String.valueOf(org.getStage()));
		document.addText(StartupConstants.ATTRIB_SHOW_IN_BLACKBOOK, String.valueOf(org.getShowInBlackbook()));
		
		
		
		if (Validator.isNotNull(org.getBusinessDevManager()) && org.getBusinessDevManager() > 0){
			document.addText(StartupConstants.BUSINESS_DEV_MANAGER_ID, String.valueOf(org.getBusinessDevManager()));
			User user = UserLocalServiceUtil.getUser(org.getBusinessDevManager());
			agentName = user.getFullName();	
			document.addText(StartupConstants.BUSINESS_DEV_MANAGER_NAME, agentName);
		}
		

		// additional indexes
		addVocabularyNames(document, org);
		document.addText(SambaashConstants.ORGANIZATION_EMPLOYEE_SIZE, String.valueOf(org.getNoOfEmployees()));
		document.addText(SambaashConstants.ORGANIZATION_FOUNDED_DATE, org.getFoundedOn());
		document.addText(SambaashConstants.ORGANIZATION_BOARD_MEMBERS, "");
		document.addText(SambaashConstants.ORGANIZATION_PROFILE_OUTLINE, org.getProfileOutline());
		document.addText(SambaashConstants.ORGANIZATION_SHORT_PITCH, org.getShortPitch());
		document.addText(SambaashConstants.ORGANIZATION_DESCRIPTION, org.getDescription());
		document.addText(SambaashConstants.ORGANIZATION_EXTRA_INFO, org.getExtras());
		document.addText(SambaashConstants.ORGANIZATION_UNIQUE_DESC, org.getUniqueDesc());
		document.addText(SambaashConstants.ORGANIZATION_VIDEOS, org.getVideos());
		document.addText(SambaashConstants.ORGANIZATION_LINKS, org.getLinks());
		document.addText(SambaashConstants.ORGANIZATION_TWITTER_URL, org.getTwitter());
		document.addText(SambaashConstants.ORGANIZATION_LINKEDIN_URL, org.getLinkedIn());
		document.addText(SambaashConstants.ORGANIZATION_CRUNCHBASE_URL, org.getCrunchbase());
		document.addText(SambaashConstants.ORGANIZATION_STARTUP_TYPE, org.getCorporateType());
		document.addText(SambaashConstants.ORGANIZATION_STARTUP_CATEGORY, org.getCorporateCategory());
		
		// founders
		List<Person> founders = OrganizationLocalServiceUtil.getFounders(org.getOrganizationId());
		if (Validator.isNotNull(founders)) {
			StringBuilder sb = new StringBuilder();
			for (Person founder: founders) {
				String fName = founder.getName();
				if (StringUtils.isEmpty(fName)) continue;
				if (sb.length()>0) {
					sb.append("|| ");
				}
				sb.append(String.format("%s, %s, %s", fName, founder.getEmailId(), founder.getDescription()));
			}
			document.addText(SambaashConstants.ORGANIZATION_FOUNDERS, sb.toString());
		}
		
		// funding rounds
		List<FundingRound> fundingRounds = OrganizationLocalServiceUtil.getFundingRounds(org.getOrganizationId());
		if (Validator.isNotNull(fundingRounds)) {
			StringBuilder sb = new StringBuilder();
			for (FundingRound fr: fundingRounds) {
				String frName = fr.getName();
				if (StringUtils.isEmpty(frName)) continue;
				if (sb.length()>0) {
					sb.append("|| ");
				}
				sb.append(String.format("%s, %s", frName, fr.getDescription()));
			}
			document.addText(SambaashConstants.ORGANIZATION_CONTACTS, sb.toString()); 
		}
		// funding rounds
		List<Address> addresses = OrganizationLocalServiceUtil.getAddresses(org.getOrganizationId());
		if (Validator.isNotNull(addresses)) {
			StringBuilder sb = new StringBuilder();
			for (Address fr: addresses) {
				String frName = fr.getName();
				if (StringUtils.isEmpty(frName)) continue;
				if (sb.length()>0) {
					sb.append("|| ");
				}
				sb.append(String.format("%s, %s", frName, fr.getCity()));
			}
			document.addText(SambaashConstants.ORGANIZATION_ADDRESSES, sb.toString());
		}
		
		// funding rounds
		List<SPOrgContactUs> contacts = OrganizationLocalServiceUtil.getContacts(org.getOrganizationId());  
		if (Validator.isNotNull(contacts)) {
			StringBuilder sb = new StringBuilder();
			for (SPOrgContactUs fr: contacts) {
				String frName = fr.getPerson();
				if (StringUtils.isEmpty(frName)) continue;
				if (sb.length()>0) {
					sb.append("|| ");
				}
				sb.append(String.format("%s, %s", frName, fr.getDesignation()));
			}
			document.addText(SambaashConstants.ORGANIZATION_CONTACTS, sb.toString());
		}
		
		
		if (logger.isDebugEnabled()) {
			logger.debug(StartupConstants.NAME + " : " + document.get(StartupConstants.NAME));
			logger.debug(StartupConstants.ATTRIB_SHOW_IN_BLACKBOOK + " : " + document.get(StartupConstants.ATTRIB_SHOW_IN_BLACKBOOK));
		}
		
		Person filledBy = OrganizationLocalServiceUtil.getFilledBy(org.getOrganizationId());
		if (Validator.isNotNull(filledBy)) {
			document.addText(SambaashConstants.FILLED_BY, filledBy.getName());
			document.addText(StartupConstants.FILLED_BY_EMAIL, filledBy.getEmailId());
			document.addText(SambaashConstants.FILLED_BY_MOBILE, filledBy.getMobile());
			document.addText(SambaashConstants.FILLED_BY_SKYPE_ID, filledBy.getSkype());
			document.addText(SambaashConstants.FILLED_BY_TITLE, filledBy.getTitle());
		}

		// Save Organziation head quuarters location
		try {
			Address hq = OrganizationLocalServiceUtil.getOfficeHeadQuaterAddress(org.getOrganizationId());
			if (Validator.isNotNull(hq)) {
				document.addKeyword(StartupConstants.HQ_ADDRESS_ID, hq.getAddressId());
				document.addText(StartupConstants.HQ_ADDRESS, hq.getName());
				document.addText(StartupConstants.HQ_STREET1, hq.getStreet1());
				document.addText(StartupConstants.HQ_STREET2, hq.getStreet2());
				document.addText(StartupConstants.HQ_CITY, hq.getCity());
				document.addText(StartupConstants.HQ_REGION, hq.getRegion());
				document.addText(StartupConstants.HQ_COUNTRY, hq.getCountry());
				document.addText(StartupConstants.HQ_POSTALCODE, hq.getPostalCode());
				
				StringBuilder sb = new StringBuilder();
				if (Validator.isNotNull(hq.getName())) sb.append(hq.getName());
				if (Validator.isNotNull(hq.getStreet1())) sb.append(", ").append(hq.getStreet1());
				if (Validator.isNotNull(hq.getStreet2())) sb.append(", ").append(hq.getStreet2());
				if (Validator.isNotNull(hq.getCity())) sb.append(", ").append(hq.getCity());
				if (Validator.isNotNull(hq.getRegion())) sb.append(", ").append(hq.getRegion());
				String hqAddr = sb.toString();
				document.addText(SambaashConstants.ORGANIZATION_HQ, hqAddr);
			}
		} catch (Exception e) {
			logger.error("Error while indexing headquarters address section for org" + org, e);
		}

		try {
			String compId = SambaashUtil.getParameter(SambaashConstants.STARTUP_RATING_ID, org.getGroupId());
			RatingHelper ratingHelper = new RatingHelper();
			JSONObject allAvgRatingsJson = ratingHelper.getAllAvgRatingsJson(Long.valueOf(compId),
					String.valueOf(org.getOrganizationId()));
			Double ratingValue = allAvgRatingsJson.getDouble(RatingConstants.AVG_RATING);
			document.addNumber(RatingConstants.AVG_RATING_ROUNDED, GetterUtil.getInteger(Math.floor(ratingValue)));
			document.addNumber(RatingConstants.AVG_RATING, ratingValue);
		} catch (Exception e) {
			logger.error("Error while indexing rating for org = " + org.getOrganizationId(), e);
		}

		return document;
	}

	private void addVocabularyNames(Document document, Organization org) {
		long[] categoryIds = null;
		try {
			AssetEntry assetEntry = AssetEntryLocalServiceUtil.fetchEntry(
					Organization.class.getName(), org.getOrganizationId());
			if (Validator.isNotNull(assetEntry)) {
				categoryIds = assetEntry.getCategoryIds();
			}

			String incorpCategoryName = SambaashUtil.getCategoryNameForSpParamVocKey(SambaashConstants.STARTUP_INCORP_VOC_ID,
					categoryIds);	
			document.addText(SambaashConstants.ORGANIZATION_INCORP_CATEGORY,incorpCategoryName);
			String startupCategoryName = SambaashUtil.getCategoryNameForSpParamVocKey(SambaashConstants.STARTUP_CATGEORY_VOC_ID,
					categoryIds);	
			document.addText(SambaashConstants.ORGANIZATION_STARTUP_CATEGORY,startupCategoryName);
			String lifeCycleStageName = SambaashUtil.getCategoryNameForSpParamVocKey(SambaashConstants.STARTUP_LIFECYCLE_STAGE_VOC_ID,
					categoryIds);	
			document.addText(SambaashConstants.ORGANIZATION_LIFECYCLE_STAGE,lifeCycleStageName);
			String raisingFunds = SambaashUtil.getCategoryNameForSpParamVocKey(SambaashConstants.STARTUP_RAISINGFUNDS_VOC_ID,
					categoryIds);	
			document.addText(SambaashConstants.ORGANIZATION_RAISING_FUNDS,raisingFunds);
			String collabStage = SambaashUtil.getCategoryNameForSpParamVocKey(StartupConstants.VOC_ORG_COLLAB_STAGE_ID,
					categoryIds);	
			document.addText(StartupConstants.STAGE,collabStage);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	protected Summary doGetSummary(Document document, Locale locale, String snippet, PortletURL portletURL)
			throws Exception {
		if (Validator.isNull(snippet)) {
			snippet = document.get(StartupConstants.NAME);
		}
		String entryId = document.get(Field.ENTRY_CLASS_PK);
		portletURL.setParameter(StartupConstants.ORGANIZATION_ID, entryId);
		return new Summary(snippet, snippet, portletURL);
	}

	@Override
	protected void doReindex(Object obj) throws Exception {
		Organization applicant = (Organization) obj;
		Document document = getDocument(applicant);
		SearchEngineUtil.updateDocument(getSearchEngineId(), applicant.getCompanyId(), document, true);
	}

	@Override
	protected void doReindex(String[] ids) throws Exception {
		long companyId = GetterUtil.getLong(ids[0]);

		reindexEntries(companyId);

	}

	public void reindexEntries(long companyId) throws Exception {
		
		List<Organization> list = OrganizationLocalServiceUtil.getAllActiveOrganizations();
		if (list.isEmpty()) {
			return;
		}

		logger.error("reindexEntries : OrganizationLocalServiceUtil.size() : " + list.size());

		Collection<Document> documents = new ArrayList<Document>();
		for (Organization classObj : list) {
			Document document = getDocument(classObj);
			documents.add(document);
		}
		SearchEngineUtil.updateDocuments(getSearchEngineId(), companyId, documents, true);
	}

	@Override
	protected void doReindex(String arg0, long orgId) throws Exception {
		Organization organization = OrganizationLocalServiceUtil.getOrganization(orgId);
		doReindex(organization);
	}

	@Override
	protected String getPortletId(SearchContext arg0) {
		return StartupConstants.PORTLET_ID;
	}

	public Map<String, String> getIndexedFields() {
		Map<String, String> map = new HashMap<String, String>(super.getIndexedFields());
		map.put(StartupConstants.NAME, "Startup Name");
		map.put(StartupConstants.SHORT_DESCRIPTION, "Snappy Description");
		map.put(StartupConstants.DESCRIPTION, "Description");
		map.put(StartupConstants.FILE_ENTRY_ID, "Logo Id");
		map.put(StartupConstants.ACTIVE, "Active");
		map.put(StartupConstants.BASE_ORG, "Is Base Org");
		map.put(StartupConstants.ATO, "Is ATO");
		map.put(StartupConstants.UEN, "UEN");
		map.put(StartupConstants.CORPORATE_CODE, "Corporate Code");
		map.put(StartupConstants.EMAIL, "Email Address");
		map.put(StartupConstants.WEBSITE, "Website");
		map.put(StartupConstants.FOUNDED, "Founded On");
		map.put(StartupConstants.TOTAL_FUNDS, "Total Funding");
		map.put(StartupConstants.FILLED_BY_EMAIL, "Filled By Email");
		map.put(StartupConstants.HQ_ADDRESS_ID, "Address Id");
		map.put(StartupConstants.HQ_ADDRESS, "Address");
		map.put(StartupConstants.HQ_STREET1, "Address Line 1");
		map.put(StartupConstants.HQ_STREET2, "Address Line 2");
		map.put(StartupConstants.HQ_CITY, "City");
		map.put(StartupConstants.HQ_REGION, "Region");
		map.put(StartupConstants.HQ_COUNTRY, "Country");
		map.put(StartupConstants.HQ_POSTALCODE, "Postal Code");
		map.put(RatingConstants.AVG_RATING, "Average Rating");
		map.put(StartupConstants.STAGE, "Collaboration Stage");
		map.put(StartupConstants.ATTRIB_SHOW_IN_BLACKBOOK, "Show in Blackbook");
		map.put(StartupConstants.BUSINESS_DEV_MANAGER_ID, "Business Development Manager Id");
		map.put(StartupConstants.BUSINESS_DEV_MANAGER_NAME, "Business Development Manager Name");
		// additional indexes
		map.put(SambaashConstants.ORGANIZATION_INCORP_CATEGORY, "Incorporation Category");
		map.put(SambaashConstants.ORGANIZATION_STARTUP_CATEGORY, "Startup Category");
		map.put(SambaashConstants.ORGANIZATION_STARTUP_TYPE, "Startup Type");
		map.put(SambaashConstants.ORGANIZATION_FOUNDED_DATE, "Founded On");
		map.put(SambaashConstants.ORGANIZATION_EMPLOYEE_SIZE, "Number of Employees");
		map.put(SambaashConstants.ORGANIZATION_BOARD_MEMBERS, "Board Members");
		map.put(SambaashConstants.ORGANIZATION_PROFILE_OUTLINE, "Profile Outline");
		map.put(SambaashConstants.ORGANIZATION_SHORT_PITCH, "Short Pitch");
		map.put(SambaashConstants.ORGANIZATION_DESCRIPTION, "Organization Description");
		map.put(SambaashConstants.ORGANIZATION_EXTRA_INFO, "Organization extra info");
		map.put(SambaashConstants.ORGANIZATION_LIFECYCLE_STAGE, "Lifecycle stage");
		map.put(SambaashConstants.ORGANIZATION_UNIQUE_DESC, "Unique Description");
		map.put(SambaashConstants.ORGANIZATION_VIDEOS, "Video Links");
		map.put(SambaashConstants.ORGANIZATION_LINKS, "Links");
		map.put(SambaashConstants.ORGANIZATION_INVESTORS, "Investors");
		map.put(SambaashConstants.ORGANIZATION_FUNDING_ROUNDS, "Funding Rounds");
		map.put(SambaashConstants.ORGANIZATION_ADDRESSES, "Addresses");
		map.put(SambaashConstants.ORGANIZATION_CONTACTS, "Contacts");
		map.put(SambaashConstants.ORGANIZATION_TOTAL_FUNDS, "Total Funds");
		map.put(SambaashConstants.ORGANIZATION_RAISING_FUNDS, "Is Raising Funds");
		map.put(SambaashConstants.ORGANIZATION_FOUNDERS, "Founders");
		map.put(SambaashConstants.FILLED_BY, "Filled By");
		map.put(SambaashConstants.FILLED_BY_TITLE, "Filled By Title");
		map.put(SambaashConstants.FILLED_BY_MOBILE, "Filled By Mobile");
		map.put(SambaashConstants.FILLED_BY_SKYPE_ID, "Filled By Skype Id");
		map.put(SambaashConstants.ORGANIZATION_TWITTER_URL, "Twitter URL");
		map.put(SambaashConstants.ORGANIZATION_LINKEDIN_URL, "LinedIn URL");
		map.put(SambaashConstants.ORGANIZATION_CRUNCHBASE_URL, "Crunchbase URL");
		return map;
	}

}
