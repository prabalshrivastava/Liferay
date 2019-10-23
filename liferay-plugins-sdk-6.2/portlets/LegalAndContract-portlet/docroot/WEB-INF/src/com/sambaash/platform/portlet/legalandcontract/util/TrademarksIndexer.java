package com.sambaash.platform.portlet.legalandcontract.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Map;

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
import com.sambaash.platform.portlet.legalandcontract.search.TrademarksSearch;
import com.sambaash.platform.srv.legalandcontract.model.Agency;
import com.sambaash.platform.srv.legalandcontract.model.Trademarks;
import com.sambaash.platform.srv.legalandcontract.service.AgencyLocalServiceUtil;
import com.sambaash.platform.srv.legalandcontract.service.TrademarksLocalServiceUtil;

public class TrademarksIndexer extends BaseIndexer {

	public static final String[] CLASS_NAMES = { Trademarks.class.getName() };

	public static final String PORTLET_ID = TrademarksConstants.PORTLET_ID;
	
	private static final Log _log = LogFactoryUtil.getLog(TrademarksIndexer.class);

	public String[] getClassNames() {
		return CLASS_NAMES;
	}

	public String getPortletId() {
		return PORTLET_ID;
	}

	@Override
	protected void doDelete(Object obj) throws Exception {
		Trademarks trademark = (Trademarks) obj;
		deleteDocument(trademark.getCompanyId(), trademark.getSpTrademarksId());
	}

	@Override
	protected Document doGetDocument(Object obj) throws Exception {
		Document document = null;
		try{
			Trademarks tradeMark = (Trademarks) obj;
			 document = getBaseModelDocument(PORTLET_ID, tradeMark);
			document.addKeyword(TrademarksConstants.LATEST, TrademarksSearch.isTrademarkLatest(tradeMark));
			List<String> listOfSearchableToken = new ArrayList<String>();
			String litigations = TrademarksSearch.getTrademarksLitigations(tradeMark.getRootSpTrademarksId());
			document.addKeyword(TrademarksConstants.LITIGATION_IDS, litigations);
			document.addKeyword(Field.ENTRY_CLASS_PK, tradeMark.getSpTrademarksId());
			document.addKeyword(Field.COMPANY_ID, tradeMark.getCompanyId());
			Utils.addIndexKeywords(document, TrademarksConstants.REGISTRATION_NUMBER, tradeMark.getRegistrationNumber());
			listOfSearchableToken.add(tradeMark.getRegistrationNumber());
			Utils.addIndexKeywords(document, TrademarksConstants.APPLICATION_NO, tradeMark.getApplicationNo());
			listOfSearchableToken.add(tradeMark.getApplicationNo());
			Utils.addIndexKeywords(document, TrademarksConstants.COUNTRY, tradeMark.getCountry());
			listOfSearchableToken.add(tradeMark.getCountry());
			String temp = "";
			if(Validator.isNotNull(tradeMark.getTrademark())) {
				temp += tradeMark.getTrademark();
			}
			if(Validator.isNotNull(tradeMark.getTrademarkLocalized())) {
				temp += " ";
				temp += tradeMark.getTrademarkLocalized();
			}
			Utils.addIndexKeywords(document, TrademarksConstants.TRADEMARK_KEY, temp);
			Utils.addIndexKeywords(document, TrademarksConstants.TRADEMARK, tradeMark.getTrademark());
			listOfSearchableToken.add(tradeMark.getTrademark());
			document.addKeyword(LegalConstants.SORT_FIELD, GetterUtil.getString(tradeMark.getTrademark()).toLowerCase());
			Utils.addIndexKeywords(document, TrademarksConstants.TRADEMARK_LOCALIZED , tradeMark.getTrademarkLocalized());
			listOfSearchableToken.add(tradeMark.getTrademarkLocalized());
			Utils.addIndexKeywords(document, TrademarksConstants.REGISTERED_OWNER, tradeMark.getRegisteredOwner());
			listOfSearchableToken.add(tradeMark.getRegisteredOwner());
			
			document.addDate(TrademarksConstants.APPLICATION_DATE, tradeMark.getApplicationDate());
			document.addDate(TrademarksConstants.FIRST_REG_DATE, tradeMark.getFirstRegistrationDate());
			document.addDate(TrademarksConstants.EXPIRY_DATE, tradeMark.getRenewalDate());
			Utils.addIndexKeywords(document, TrademarksConstants.REMARKS, tradeMark.getPendingComments());
			listOfSearchableToken.add(tradeMark.getPendingComments());
			Utils.addIndexKeywords(document, TrademarksConstants.LEGAL_CONF_REMARKS, tradeMark.getLegalConfRemarks());
			listOfSearchableToken.add(tradeMark.getLegalConfRemarks());
			document.addKeyword(TrademarksConstants.AGENCY_ID, tradeMark.getSpAgencyId());
			
			try{
				Agency agency = AgencyLocalServiceUtil.getAgency(tradeMark.getSpAgencyId());
				listOfSearchableToken.add(agency.getName());
				//listOfSearchableToken.add(agency.getNumber());
			}catch(Exception ex){
				
			}
			
			List<Map<String, String>> classCodes = Utils.parseClassCodesJson(tradeMark.getClassCodes(),false);
			for(Map<String, String> ccMap : classCodes) {
				listOfSearchableToken.add(ccMap.get("cSpec"));
			}
			Utils.addIndexKeywords(document, TrademarksConstants.ACTIVE_IN_GREDIENTS, tradeMark.getCustomField1());
			listOfSearchableToken.add(tradeMark.getCustomField1());
			Utils.addIndexKeywords(document, TrademarksConstants.INTERNATIONAL_REG_NUM, tradeMark.getCustomField2());
			listOfSearchableToken.add(tradeMark.getCustomField2());
			Utils.addIndexKeywords(document, TrademarksConstants.CUSTOM_FIELD_3, tradeMark.getCustomField3());
			listOfSearchableToken.add(tradeMark.getCustomField3());
			document.addDate(TrademarksConstants.PRIORITY_DATE, tradeMark.getCustomDate1());
			//document.addDate(TrademarksConstants.CUSTOM_DATE_2, tradeMark.getCustomDate2());
			//document.addDate(TrademarksConstants.CUSTOM_DATE_3, tradeMark.getCustomDate3());
			document.addKeyword(Field.USER_ID, tradeMark.getUserId());
			Utils.addIndexKeywords(document, Field.USER_NAME, tradeMark.getUserName());
			document.addDate(Field.CREATE_DATE, tradeMark.getCreateDate());
			document.addDate(Field.MODIFIED_DATE, tradeMark.getModifiedDate());
			document.addKeyword(TrademarksConstants.VERSION, tradeMark.getVersion());
			Utils.addIndexKeywords(document, TrademarksConstants.TRADEMARK_TYPE, tradeMark.getTrademarkType());
			document.addKeyword(TrademarksConstants.ROOT_TRADEMARK_ID, tradeMark.getRootSpTrademarksId());
			try{
				AssetEntry assetEntry = AssetEntryLocalServiceUtil.fetchEntry(
						Trademarks.class.getName(), tradeMark.getSpTrademarksId());
				long categoryIds[] = assetEntry.getCategoryIds();
				Utils.addCategoryNamesToList(categoryIds, listOfSearchableToken);
			}catch(Exception ex){
				_log.error(ex.getMessage());
			}
			
			try {
				String[] allTokensArray = Utils.createSearchTokenArray(listOfSearchableToken);
				document.addText(TrademarksConstants.ALL_SEARCH, allTokensArray);
			} catch (Exception e) {
				_log.error(e.getMessage());
			}
			return document;
		}catch(Exception ex){
			_log.error(ex);
		}
		return document;
	}

	@Override
	protected Summary doGetSummary(Document document, Locale locale, String snippet, PortletURL portletURL) {
		String title = document.get(TrademarksConstants.APPLICATION_NO);
		String description = snippet;
		if (Validator.isNull(snippet)) {
			description = StringUtil.shorten(document.get(Field.COMMENTS), 200);
		}
		String entryId = document.get(Field.ENTRY_CLASS_PK);
		portletURL.setParameter("entryId", entryId);
		return new Summary(title, description, portletURL);
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void doReindex(Object obj) throws Exception {
	/*	Map<String, Object> map = (Map<String, Object>) obj;
		Trademarks trademarks = (Trademarks) map.get(TrademarksConstants.TRADEMARK);
		boolean isLatest = new Boolean(map.get(TrademarksConstants.LATEST) + "");
		Document document = getDocument(trademarks);
		document.addKeyword(TrademarksConstants.LATEST, isLatest);
		document.addKeyword(TrademarksConstants.LITIGATION_IDS, (String) map.get(TrademarksConstants.LITIGATION_IDS));
		SearchEngineUtil.updateDocument(trademarks.getCompanyId(), document); */
		
		Trademarks trademarks = (Trademarks) obj;
		Document document = getDocument(trademarks);
		SearchEngineUtil.updateDocument(trademarks.getCompanyId(), document);
	}

	@Override
	protected void doReindex(String[] ids) throws Exception {
		long companyId = GetterUtil.getLong(ids[0]);
		reindexEntries(companyId);
	}

	protected void reindexEntries(long companyId) throws Exception {
		List<Trademarks> trademarks = TrademarksLocalServiceUtil.getTrademarkses(-1, -1);
		if (trademarks.isEmpty()) {
			return;
		}
		Collection<Document> documents = new ArrayList<Document>();
		for (Trademarks trademark : trademarks) {
			Document document = getDocument(trademark);
			documents.add(document);
		}
		SearchEngineUtil.updateDocuments(companyId, documents);
	}

	@Override
	protected void doReindex(String arg0, long arg1) throws Exception {
		Trademarks trademark = TrademarksLocalServiceUtil.getTrademarks(arg1);
		doReindex(trademark);
	}

	@Override
	protected String getPortletId(SearchContext arg0) {
		return PORTLET_ID;
	}

	@Override
	public boolean hasPermission(PermissionChecker permissionChecker, String entryClassName,long entryClassPK, String actionId)
			throws Exception {
		// TODO Auto-generated method stub
		return super.hasPermission(permissionChecker, entryClassName,entryClassPK, actionId);
	}

	@Override
	public Hits search(SearchContext searchContext) throws SearchException {
		// searchContext.setUserId(10196);
		return super.search(searchContext);
	}

}
