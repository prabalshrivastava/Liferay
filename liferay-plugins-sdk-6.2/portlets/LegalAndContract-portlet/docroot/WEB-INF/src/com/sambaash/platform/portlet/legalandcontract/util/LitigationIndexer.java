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
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil;
import com.sambaash.platform.portlet.legalandcontract.search.LitigationSearch;
import com.sambaash.platform.srv.legalandcontract.model.Litigation;
import com.sambaash.platform.srv.legalandcontract.model.RDL;
import com.sambaash.platform.srv.legalandcontract.model.Trademarks;
import com.sambaash.platform.srv.legalandcontract.service.LitigationLocalServiceUtil;
import com.sambaash.platform.srv.legalandcontract.service.RDLLocalServiceUtil;
import com.sambaash.platform.srv.legalandcontract.service.TrademarksLocalServiceUtil;

public class LitigationIndexer extends BaseIndexer {
	
	public static final String[] CLASS_NAMES = { Litigation.class.getName() };
	
	public static final String PORTLET_ID = LitigationConstants.PORTLET_ID;
	

	public String[] getClassNames() {
		return CLASS_NAMES;
	}

	public String getPortletId() {
		return PORTLET_ID;
	}

	@Override
	protected void doDelete(Object obj) throws Exception {
		Litigation litigation = (Litigation) obj;
		deleteDocument(litigation.getCompanyId(), litigation.getSpLitigationId());
	}

	@Override
	protected Document doGetDocument(Object obj) throws Exception {
		Document document = null;
		try{
			Litigation litigation = (Litigation)obj;
			 document = getBaseModelDocument(PORTLET_ID, litigation);
			try{
				List<RDL>rdls = RDLLocalServiceUtil.findBylitigationId(litigation.getSpLitigationId());
				if(Validator.isNotNull(rdls)){
					for(RDL rdl : rdls){
						RDLLocalServiceUtil.reIndex(rdl);
					}
				}
			}catch(Exception ex){
				_log.error("Error while indexing rdl " + ex.getMessage());
			}
			
			addSearchFields(document, litigation);
			return document;
			
		}catch(Exception ex){
			_log.error(ex);
		}
		return document;
	}
	
	public static void addSearchFields(Document document, Litigation litigation){
		boolean isLatest = LitigationSearch.isLitigationLatest(litigation);
		document.addKeyword(TrademarksConstants.LATEST, isLatest);
		List<String> listOfSearchableToken = new ArrayList<String>();
		document.addKeyword(TrademarksConstants.TRADEMARKS_ID, litigation.getSpTrademarksId());
		Utils.addIndexKeywords(document, LitigationConstants.COUNTRY, litigation.getCountry());
		listOfSearchableToken.add(litigation.getCountry());
		Utils.addIndexKeywords(document, LitigationConstants.FILED_BY, litigation.getFiledBy());
		listOfSearchableToken.add(litigation.getFiledBy());
		document.addDate(LitigationConstants.FILED_ON_DATE, litigation.getFiledOn());
		listOfSearchableToken.add(litigation.getClaimsRemarks());
		Utils.addIndexKeywords(document, LitigationConstants.STATUS, litigation.getStatus());
		listOfSearchableToken.add(litigation.getStatus());
		Utils.addIndexKeywords(document, LitigationConstants.LAW_FIRM, litigation.getCustomField1());
		listOfSearchableToken.add(litigation.getCustomField1());
		Utils.addIndexKeywords(document, LitigationConstants.THRID_PARTY_APP_NUMBER, litigation.getCustomField2());
		listOfSearchableToken.add(litigation.getCustomField2());
		document.addKeyword(Field.USER_ID, litigation.getUserId());
		Utils.addIndexKeywords(document, Field.USER_NAME, litigation.getUserName());
		document.addDate(Field.CREATE_DATE, litigation.getCreateDate());
		document.addDate(Field.MODIFIED_DATE, litigation.getModifiedDate());
		document.addKeyword(LitigationConstants.VERSION,litigation.getVersion());
		document.addKeyword(LitigationConstants.ROOT_LITIGATION_ID,litigation.getRootSpLitigationId());
		try{
			List<RDL>rdls = RDLLocalServiceUtil.findBylitigationId(litigation.getSpLitigationId());
			//Collections.sort(rdls,new RdlComparator());
			
			 if(Validator.isNotNull(rdls) && rdls.size() > 0){
				 
				 for(RDL rd: rdls){
					 listOfSearchableToken.add(rd.getClaimsRemarks());
				 }
				 /*RDL rdl = rdls.get(rdls.size()-1);
				 document.addDate(LitigationConstants.RESPONSE_DEADLINE, rdl.getResponseDeadline());
				 document.addKeyword(LitigationConstants.ALERT_BEFORE, rdl.getAlertBefore());
				 Utils.addIndexKeywords(document, LitigationConstants.CLAIMS_REMARKS, rdl.getClaimsRemarks());*/
			 }
			 
		}catch(Exception ex){
			_log.error(ex);
		}
		try{
			Trademarks trademarks = TrademarksLocalServiceUtil.getTrademarks(litigation.getSpTrademarksId());
			listOfSearchableToken.add(trademarks.getApplicationNo());
			AssetEntry assetEntry = AssetEntryLocalServiceUtil.fetchEntry(
					Litigation.class.getName(), litigation.getSpLitigationId());
			long categoryIds[] = assetEntry.getCategoryIds();
			Utils.addCategoryNamesToList(categoryIds, listOfSearchableToken);
			trademarks = TrademarksLocalServiceUtil.getLatestTrademarksByApplicationNoCountry(
							trademarks.getApplicationNo(),
							trademarks.getCountry());
			Utils.addIndexKeywords(document, LitigationConstants.TRADEMARKS,
					GetterUtil.getString(trademarks.getTrademark()));
			listOfSearchableToken.add(GetterUtil.getString(trademarks.getTrademark()));
			document.addKeyword(LegalConstants.SORT_FIELD, 
					GetterUtil.getString(trademarks.getTrademark()).toLowerCase());
		}catch(Exception ex){
			_log.error(ex.getMessage());
		}
		try {
			String[] allTokensArray = Utils.createSearchTokenArray(listOfSearchableToken);
			document.addText(LitigationConstants.ALL_SEARCH, allTokensArray);
		} catch (Exception e) {
			_log.error(e.getMessage());
		}
	}

	@Override
	protected Summary doGetSummary(Document document, Locale locale, String snippet, PortletURL portletURL) {
		String title = document.get(LitigationConstants.TRADEMARK_REG_NUMBER);
		String description = snippet;
		if (Validator.isNull(snippet)) {
			description = document.get(LitigationConstants.TRADEMARK_REG_NUMBER);;
		}
		String entryId = document.get(Field.ENTRY_CLASS_PK);
		portletURL.setParameter("entryId", entryId);
		return new Summary(title, description, portletURL);
	}

	@Override
	protected void doReindex(Object obj) throws Exception {
		Litigation litigation = (Litigation) obj;
		Document document = getDocument(litigation);
		SearchEngineUtil.updateDocument(litigation.getCompanyId(), document);
	}

	@Override
	protected void doReindex(String[] ids) throws Exception {
		long companyId = GetterUtil.getLong(ids[0]);
		reindexEntries(companyId);
	}
	
	protected void reindexEntries(long companyId) throws Exception {
		List<Litigation> classs = LitigationLocalServiceUtil.getLitigations(-1, -1);
		if (classs.isEmpty()) {
			return;
		}
		Collection<Document> documents = new ArrayList<Document>();
		for (Litigation  classObj: classs) {
			Document document = getDocument(classObj);
			documents.add(document);
		}
		SearchEngineUtil.updateDocuments(companyId, documents);
	}

	@Override
	protected void doReindex(String arg0, long arg1) throws Exception {
		Litigation litigation = LitigationLocalServiceUtil.getLitigation(arg1);
		doReindex(litigation);
	}

	@Override
	protected String getPortletId(SearchContext arg0) {
		return PORTLET_ID;
		}

	@Override
	public Hits search(SearchContext searchContext) throws SearchException {
		return super.search(searchContext);
	}
	
	private static Log _log = LogFactoryUtil.getLog(LitigationIndexer.class.getName());

}
