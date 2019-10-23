package com.sambaash.platform.portlet.legalandcontract.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;

import javax.portlet.PortletURL;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.BaseIndexer;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchEngineUtil;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil;
import com.sambaash.platform.srv.legalandcontract.model.Agency;
import com.sambaash.platform.srv.legalandcontract.service.AgencyLocalServiceUtil;

public class AgencyIndexer extends BaseIndexer {
	
	public static final String[] CLASS_NAMES = { Agency.class.getName() };
	
	public static final String PORTLET_ID = "CreateAgency_WAR_LegalAndContractportlet";

	private static final Log _log = LogFactoryUtil.getLog(AgencyIndexer.class);
	public String[] getClassNames() {
		return CLASS_NAMES;
	}

	public String getPortletId() {
		return PORTLET_ID;
	}

	@Override
	protected void doDelete(Object obj) throws Exception {
		Agency agency = (Agency) obj;
		deleteDocument(agency.getCompanyId(), agency.getSpAgencyId());
	}

	@Override
	protected Document doGetDocument(Object obj) throws Exception {
		Document document = null;
		try {
			Agency agency = (Agency) obj;
			document = getBaseModelDocument(PORTLET_ID, agency);
			
			List<Object[]> agencyIdList = AgencyLocalServiceUtil.getLatestAgencyIdAndVersionNumber(agency.getNumber(), agency.getCountry());
			if (agencyIdList.size() > 0) {
				Object[] agencyIdArr = ((Object[]) agencyIdList.get(0));
				
				if (((Long) agencyIdArr[1]).compareTo(agency.getSpAgencyId()) == 0) {
					document.addKeyword(AgencyConstants.LATEST, true);
				}else{
					document.addKeyword(AgencyConstants.LATEST, false);
				}
			}
			
			List<String> listOfSearchableToken = new ArrayList<String>();
			
			document.addKeyword(Field.ENTRY_CLASS_PK, agency.getSpAgencyId());
			document.addKeyword(Field.COMPANY_ID, agency.getCompanyId());
			
			//document.addKeyword(AgencyConstants.NAME, agency.getName());
			Utils.addIndexKeywords(document, AgencyConstants.NAME, agency.getName());
			listOfSearchableToken.add(agency.getName());
			
			document.addKeyword(LegalConstants.SORT_FIELD, GetterUtil.getString(agency.getName()).toLowerCase());
			
			//document.addKeyword(AgencyConstants.COUNTRY, agency.getCountry());
			Utils.addIndexKeywords(document, AgencyConstants.COUNTRY, agency.getCountry());
			listOfSearchableToken.add(agency.getCountry());
			
			//document.addKeyword(AgencyConstants.NUMBER, agency.getNumber());
			Utils.addIndexKeywords(document, AgencyConstants.NUMBER, agency.getNumber());
			listOfSearchableToken.add(agency.getNumber());
			
			//document.addKeyword(AgencyConstants.REFERENCE, agency.getReference());
			Utils.addIndexKeywords(document, AgencyConstants.REFERENCE, agency.getReference());
			listOfSearchableToken.add(agency.getReference());
			
			Utils.addIndexKeywords(document,AgencyConstants.START_DATE, agency.getStartDate());
			listOfSearchableToken.add(agency.getStartDate());
			Utils.addIndexKeywords(document,AgencyConstants.END_DATE, agency.getEndDate());
			listOfSearchableToken.add(agency.getEndDate());
			
			//document.addKeyword(AgencyConstants.ADDRESS,agency.getAddress());
			Utils.addIndexKeywords(document, AgencyConstants.ADDRESS, agency.getAddress());
			listOfSearchableToken.add(agency.getAddress());
			
			//document.addKeyword(AgencyConstants.REMARKS, agency.getRemarks());
			Utils.addIndexKeywords(document, AgencyConstants.REMARKS, agency.getRemarks());
			listOfSearchableToken.add(agency.getRemarks());
			
//		document.addKeyword(Field.STATUS, agency.getStatus());
			Utils.addIndexKeywords(document, AgencyConstants.STATUS, agency.getStatus());
			listOfSearchableToken.add(agency.getStatus());
			
			/*		//document.addKeyword(AgencyConstants.CUSTOM_FIELD_1, agency.getCustomField1());
		Utils.addIndexKeywords(document, AgencyConstants.CUSTOM_FIELD_1, agency.getCustomField1());
		listOfSearchableToken.add(agency.getCustomField1());
		
		//document.addKeyword(AgencyConstants.CUSTOM_FIELD_2, agency.getCustomField2());
		Utils.addIndexKeywords(document, AgencyConstants.CUSTOM_FIELD_2, agency.getCustomField2());
		listOfSearchableToken.add(agency.getCustomField2());
		
		//document.addKeyword(AgencyConstants.CUSTOM_FIELD_3, agency.getCustomField3());
		Utils.addIndexKeywords(document, AgencyConstants.CUSTOM_FIELD_3, agency.getCustomField3());
		listOfSearchableToken.add(agency.getCustomField3());
		
		document.addDate(AgencyConstants.CUSTOM_DATE_1, agency.getCustomDate1());
		document.addDate(AgencyConstants.CUSTOM_DATE_2, agency.getCustomDate2());
		document.addDate(AgencyConstants.CUSTOM_DATE_3, agency.getCustomDate3()); */
			document.addKeyword(Field.USER_ID, agency.getUserId());
			//document.addKeyword(Field.USER_NAME, agency.getUserName());
			Utils.addIndexKeywords(document, Field.USER_NAME, agency.getUserName());
			document.addDate(Field.CREATE_DATE, agency.getCreateDate());
			document.addDate(Field.MODIFIED_DATE, agency.getModifiedDate());
			document.addKeyword(LegalConstants.VERSION,agency.getVersion());
			document.addKeyword(AgencyConstants.ROOT_AGENCY_ID,agency.getRootSpAgencyId());
			
			try{
				
				AssetEntry assetEntry = AssetEntryLocalServiceUtil.fetchEntry(
						Agency.class.getName(), agency.getSpAgencyId());
				long categoryIds[] = assetEntry.getCategoryIds();
				Utils.addCategoryNamesToList(categoryIds, listOfSearchableToken);
			}catch(Exception ex){
				_log.error(ex.getMessage());
			}
			
			try {
				String[] allTokensArray = Utils.createSearchTokenArray(listOfSearchableToken);
				document.addText(AgencyConstants.ALL_SEARCH, allTokensArray);
			} catch (Exception e) {
				_log.error(e.getMessage());
			}
			
		} catch (Exception e) {
				_log.error(e);
		}
		
		return document;
	}

	@Override
	protected Summary doGetSummary(Document document, Locale locale, String snippet, PortletURL portletURL) {
		String title = document.get(Field.NAME);
		String description = snippet;
		if (Validator.isNull(snippet)) {
			description = StringUtil.shorten(document.get(Field.COMMENTS), 200);
		}
		String entryId = document.get(Field.ENTRY_CLASS_PK);
		portletURL.setParameter("entryId", entryId);
		return new Summary(title, description, portletURL);
	}

	@Override
	protected void doReindex(Object obj) throws Exception {
		Agency agency = (Agency) obj;
		Document document = getDocument(agency);
		SearchEngineUtil.updateDocument(agency.getCompanyId(), document);
	}

	@Override
	protected void doReindex(String[] ids) throws Exception {
		long companyId = GetterUtil.getLong(ids[0]);
		reindexEntries(companyId);
	}
	
	protected void reindexEntries(long companyId) throws Exception {
		List<Agency> agencies = AgencyLocalServiceUtil.getAgencies(-1, -1);
		if (agencies.isEmpty()) {
			return;
		}
		Collection<Document> documents = new ArrayList<Document>();
		for (Agency agency : agencies) {
			Document document = getDocument(agency);
			documents.add(document);
		}
		SearchEngineUtil.updateDocuments(companyId, documents);
	}

	@Override
	protected void doReindex(String arg0, long arg1) throws Exception {
		Agency agency = AgencyLocalServiceUtil.getAgency(arg1);
		doReindex(agency);
	}

	@Override
	protected String getPortletId(SearchContext arg0) {
		return PORTLET_ID;
		}

	@Override
	public boolean hasPermission(PermissionChecker permissionChecker, String entryClassName,
			long entryClassPK, String actionId) throws Exception {
		// TODO Auto-generated method stub
		return super.hasPermission(permissionChecker, entryClassName, entryClassPK, actionId);
	}
	
	@Override
	public Hits search(SearchContext searchContext) throws SearchException {
//		searchContext.setUserId(10196);
		return super.search(searchContext);
	}

}
