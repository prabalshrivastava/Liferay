package com.sambaash.platform.portlet.legalandcontract.search;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.PortletURL;
import javax.portlet.WindowState;
import javax.portlet.WindowStateException;

import com.liferay.portal.kernel.dao.search.ResultRow;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.search.BooleanClause;
import com.liferay.portal.kernel.search.BooleanClauseFactoryUtil;
import com.liferay.portal.kernel.search.BooleanClauseOccur;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.BooleanQueryFactoryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.SortFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.PortletURLFactoryUtil;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil;
import com.sambaash.platform.constant.SambaashConstants;
import com.sambaash.platform.portlet.legalandcontract.permissions.LegalPermissionUtil;
import com.sambaash.platform.portlet.legalandcontract.util.LegalConstants;
import com.sambaash.platform.portlet.legalandcontract.util.LitigationConstants;
import com.sambaash.platform.portlet.legalandcontract.util.TrademarksConstants;
import com.sambaash.platform.portlet.legalandcontract.util.Utils;
import com.sambaash.platform.srv.legalandcontract.model.Litigation;
import com.sambaash.platform.srv.legalandcontract.model.RDL;
import com.sambaash.platform.srv.legalandcontract.service.LitigationLocalServiceUtil;
import com.sambaash.platform.srv.legalandcontract.service.RDLLocalServiceUtil;
import com.sambaash.platform.util.SambaashUtil;

public class LitigationSearch extends LegalContractSearch{
	private static List<SearchField> listFiellds;
	private static boolean initialized;
	private static Log _log = LogFactoryUtil.getLog(LitigationSearch.class);
	
	public LitigationSearch(PortletRequest request,PortletResponse response){
		super(request,response,Litigation.class.getName());
	}
	
	protected List<SearchField> getSearchFields(){
		if(!initialized){
			listFiellds = new ArrayList<SearchField>();
			
			SearchField sf = SearchFieldFactory.getSearchFieldDropdown(LitigationConstants.TRADEMARK_APP_NUMBER_COLUMN,LitigationConstants.TRADEMARK_REG_NUMBER, LitigationConstants.TRADEMARK_REG_NUMBER);
			listFiellds.add(sf);
			
			 sf = SearchFieldFactory.getSearchFieldText(LitigationConstants.ALL_SEARCH_COLUMN,LitigationConstants.ALL_SEARCH, LitigationConstants.ALL_SEARCH);
			listFiellds.add(sf);
			
			sf = SearchFieldFactory.getSearchFieldDate(LitigationConstants.FILED_ON_COLUMN, LitigationConstants.FILED_ON_DATE,  LitigationConstants.FILED_ON_DATE);
			listFiellds.add(sf);
			
			sf = SearchFieldFactory.getSearchFieldCategory(LitigationConstants.PROCEEDING_TYPE_COLUMN,LitigationConstants.PROCEEDING_TYPE,LitigationConstants.PROCEEDING_TYPE,LitigationConstants.PROCEEDING_TYPE_VOC_ID);
			listFiellds.add(sf);
			
			sf = SearchFieldFactory.getSearchFieldText(LitigationConstants.FILED_BY_COLUMN,LitigationConstants.FILED_BY,LitigationConstants.FILED_BY);
			listFiellds.add(sf) ;
			
		//	sf = new SearchField(LitigationConstants.FILED_AT_COUNTRY_COLUMN,LitigationConstants.FILED_AT_COUNTRY,LitigationConstants.FILED_AT_COUNTRY,LIST,true,LitigationConstants.FILED_AT_COUNTRY_VOC_ID);
		//	listFiellds.add(sf);

			sf = SearchFieldFactory.getSearchFieldCategory(LitigationConstants.RESPONSE_DEADLINE_COLUMN,LitigationConstants.ALERT_BEFORE,LitigationConstants.ALERT_BEFORE,LitigationConstants.ALERT_BEFORE_VOC_ID);
			listFiellds.add(sf);
			
			sf = SearchFieldFactory.getSearchFieldText(LitigationConstants.STATUS_COLUMN,LitigationConstants.STATUS,LitigationConstants.STATUS);
			listFiellds.add(sf) ;
			
			sf = SearchFieldFactory.getSearchField(LitigationConstants.LITIGATION_HISTORY_LABEL,LitigationConstants.LITIGATION_HISTORY,SearchField.DROPDOWN);
			listFiellds.add(sf);
			
			initialized = true;
		}
		
		return listFiellds;
	}
	
	public void extraSetup(){
		request.setAttribute("showExports", true);
	}
	
	private SearchContext getDefaultSearchContext(){
		return getDefaultSearchContext(themeDisplay.getUser().getCompanyId());
	}
	
	private static SearchContext getDefaultSearchContext(long companyId){
		SearchContext searchContext = new SearchContext();
		searchContext.setStart(-1);
		searchContext.setEnd(-1);
		searchContext.setCompanyId(companyId);
		
		Sort sort = SortFactoryUtil.create(LegalConstants.SORT_FIELD, Sort.STRING_TYPE, false);
		Sort sort1 = SortFactoryUtil.create(LitigationConstants.COUNTRY, Sort.STRING_TYPE,
				false);
		Sort sort2 = SortFactoryUtil.create(LitigationConstants.FILED_ON_DATE, Sort.STRING_TYPE,
				false);
		Sort[] sorts = new Sort[] { sort,sort1,sort2 };
		searchContext.setSorts(sorts);
		return searchContext;
	}
	
	public static Hits searchLitigations(SearchContext searchContext){
		Indexer indexer = IndexerRegistryUtil
				.getIndexer(Litigation.class.getName());
		Hits results = null;
		try {
			results = indexer.search(searchContext);
		} catch (SearchException e) {
			_log.error(e.getMessage(), e);
		}
		return results;
	}
	
	public List<Document> getLitigations(){
		setup();
		
		List<Document> list = new ArrayList<Document>();
		if(isRDLSearchCriteria()){
			
		}else{
			
		}
		String fkey = ParamUtil.getString(request, LegalConstants.SEARCH_FIELD);
		if(LitigationConstants.ALERT_BEFORE.equals(fkey)){

			try {
				SearchContext searchContext = getDefaultSearchContext();
				List<BooleanClause>bcList = super.getSearchConditions(searchContext);
				Map<String,Document>rdls  = getLitigationBasedOnRDLs(searchContext, themeDisplay.getCompanyId(), bcList);
					for (String key : rdls.keySet()) {
						Document litigation = getDocumentByPK(GetterUtil.getLong(key));
						list.add(litigation);
					}
			} catch (Exception e) {
				_log.error(e.getMessage(), e);
			}
//			return list;
		
		}else{
			SearchContext searchContext = getDefaultSearchContext();
			setSearchConditions(searchContext);
			Hits results = searchLitigations(searchContext);
			list = new ArrayList<Document>();
			if (Validator.isNotNull(results)) {
				int length = results.getDocs().length;
				for (int i = 0; i < length; i++) {
					Document doc = results.doc(i);
					list.add(doc);
				}
			}
		}
		
		return list;
	}
	
	public boolean isRDLSearchCriteria(){
		String searchQuery = getSearchQuery();
		boolean rdlCriteria = false;
		try{
			JSONArray array = JSONFactoryUtil.createJSONArray(searchQuery);
			for(int i = 0 ; i < array.length(); i++){
				JSONObject json = array.getJSONObject(i);
				if(LitigationConstants.ALERT_BEFORE.equalsIgnoreCase(getSearchFieldKeyTrimmed(json.getString(SEARCH_FIELD)))){
					rdlCriteria = true; break;
				}
				
			}
		}catch(Exception ex){
			_log.error(ex);
		}
		return rdlCriteria;
		
	}
	
	@SuppressWarnings("rawtypes")
	public SearchContainer getSearchContainer() throws WindowStateException{
		
		SearchContainer searchContainer ;
		if(isRDLSearchCriteria()){
			 searchContainer = SearchOnRDL();
		}else{
			 searchContainer = getRegSearchContainer();
		}
		return searchContainer;
	}
	public SearchContainer getRegSearchContainer() throws WindowStateException{
		boolean editPermission = false;
		try {
				LegalPermissionUtil.authorize(request,LitigationConstants.PORTLET_ID,
						LitigationConstants. ACTION_KEY_EDIT_LITIGATION); 
				editPermission = true;
			} catch (Exception e) {
				_log.error(e);
			} 

			//PortletURL portletURL = response.createRenderURL();
	    	PortletURL portletURL = getRenderUrl(LitigationConstants.PORTLET_ID);

			List<String> headerNames = new ArrayList<String>();
			headerNames.add("Trademark Application Number / Country");
			headerNames.add("Trademark Name");
			headerNames.add("Proceedings");
			headerNames.add("Filed By");
			headerNames.add("Filed on");
			//headerNames.add("Filed at Country");
			headerNames.add(LitigationConstants.THRID_PARTY_APP_NUMBER_COLUMN);
			headerNames.add("Response Deadline");
			//headerNames.add("Alert Before");
			//headerNames.add("Actual Response Date");
			headerNames.add("Status");
			headerNames.add("Version");
/*			headerNames.add("Custom Field 1");
			headerNames.add("Custom Field 2");
			headerNames.add("Custom Field 3");
			headerNames.add("Custom Date 1");
			headerNames.add("Custom Date 2");
			headerNames.add("Custom Date 3");
			headerNames.add("Custom List 1");
			headerNames.add("Custom List 2");
			headerNames.add("Custom List 3"); */
			if (editPermission) {
				headerNames.add("Edit");
			}
			headerNames.add("Details");

			// create search container, used to display table
			SearchContainer searchContainer = new SearchContainer(request,
					null, null, SearchContainer.DEFAULT_CUR_PARAM,
					SearchContainer.DEFAULT_DELTA, portletURL, headerNames,
					"There are no Contentious Proceedings to display");
			portletURL.setParameter(searchContainer.getCurParam(),
					String.valueOf(searchContainer.getCurValue()));

			// Fill searchparammap to retain the search criteria
			setSearchContainerParamsToSearchParamMap(searchContainer);
			
			SearchContext searchContext = new SearchContext();
			searchContext.setStart(searchContainer.getStart());
			searchContext.setEnd(searchContainer.getEnd());
			searchContext.setCompanyId(themeDisplay.getUser().getCompanyId());
			
			setSearchConditions(searchContext); 

			//String countryVocId = preferences.getValue(LitigationConstants.COUNTRY_VOC_ID, StringPool.BLANK);
			Sort sort = SortFactoryUtil.create(LegalConstants.SORT_FIELD, Sort.STRING_TYPE, false);
			Sort sort1 = SortFactoryUtil.create(LitigationConstants.COUNTRY, Sort.STRING_TYPE,
					false);
			Sort sort2 = SortFactoryUtil.create(LitigationConstants.FILED_ON_DATE, Sort.STRING_TYPE,
					false);
			Sort[] sorts = new Sort[] { sort , sort1, sort2 };
			searchContext.setSorts(sorts);

			Indexer indexer = IndexerRegistryUtil.getIndexer(Litigation.class.getName());
			Hits results = null;
			try {
				results = indexer.search(searchContext);
			} catch (SearchException e) {
				_log.error(e.getMessage(), e);
			}
			if (results != null) {
				// set count into search container
				searchContainer.setTotal(results.getLength());
				// fill table
				List<ResultRow> resultRows = searchContainer.getResultRows();
				int length = results.getDocs().length;
				PortletURL actionUrl;
				String countryName="";
				String procdingType = "";
				String filedAtCountry = "";
				String alertBefore = "";
		//		String customList1CatName = "";
		//		String customList2CatName = "";
		//		String customList3CatName = "";
				List<Long>catIds;
				long classPK;
				boolean isLatest;
				TrademarksSearch tsearch = new TrademarksSearch(request, response);
				
				//TODO: Due to time constraint, fetching rdls from db. Later it can be changed to indexer call.
				RDL rdl = null;
				for (int i = 0; i < length; i++) {
					
					Document doc = results.doc(i);
					classPK = GetterUtil.getLong(doc.get(Field.ENTRY_CLASS_PK));
					rdl = null;
					try{
						//TODO: Due to time constraint, fetching rdls from db. Later it can be changed to indexer call.
						List<RDL>rdls = RDLLocalServiceUtil.findBylitigationId(classPK);
						if(Validator.isNotNull(rdls) && rdls.size() > 0){
							rdl = rdls.get(rdls.size()-1);
						}
					}catch(Exception ex){
						
					}
					String tmTextRUrl = null;
					String rootTmId = doc.get(TrademarksConstants.TRADEMARKS_ID);
					Map<String, String> latestTmMap = tsearch.getLatestTrademarksByRootTrademarksId(
							rootTmId, false);
					
					
					catIds = Utils.getCategoryIds(doc);   
					procdingType = Utils.getCategoryName(preferences, LitigationConstants.PROCEEDING_TYPE_VOC_ID, catIds);
					
					ResultRow row = new ResultRow(doc, classPK, i);
					
					row.addText(tsearch.getTrademarkApplicationNumCountryByRootTrademarkId(GetterUtil.getString(doc.get(TrademarksConstants.TRADEMARKS_ID))));
					String tmUrl = Utils.getTrademarkDetailsFriendlyUrl(latestTmMap.get(TrademarksConstants.TRADEMARKS_ID));
					tmUrl = tmUrl.trim();
					
			/*		try {
						tmTextRUrl = TrademarksSearch.getTrademarkLogoFileEntryId(request, TrademarksConstants.LOGO, doc.get(TrademarksConstants.TRADEMARKS_ID));
					}catch (Exception e) {
						_log.error("error getting logo", e);
					} */
					
					
					String tmType = latestTmMap.get(TrademarksConstants.TRADEMARK_TYPE);
					if (TrademarksConstants.LOGO.equalsIgnoreCase(tmType)) {
						tmTextRUrl = TrademarksSearch.getTrademarkLogoUrl(request, rootTmId);
						

						String imageHtml = TrademarksConstants.TRADEMARK_LOGO_IMG_FORMAT;//"<img border='2' src='%s' width='100px' height='50px'>";
						imageHtml = String.format(imageHtml, tmTextRUrl);
						row.addText("<a class='tmLink' href='"+tmUrl+"' style='color: #b81106;background:none;'>" + imageHtml + "</a>");
					
						
					}else{
						tmTextRUrl = latestTmMap.get(TrademarksConstants.TRADEMARK);
						row.addText("<a class='tmLink' href='"+tmUrl+"' style='color: #b81106;background:none;'>" + GetterUtil.getString(tmTextRUrl) + "</a>");
					}
					
		/*			if(Validator.isNotNull(tmTextRUrl)) {
						String imageHtml = "<img border='2' src='%s' width='100px' height='50px'>";
						imageHtml = String.format(imageHtml, tmTextRUrl);
						row.addText("<a class='tmLink' href='"+tmUrl+"' style='color: #b81106;background:none;'>" + imageHtml + "</a>");
					} else {
						row.addText("<a class='tmLink' href='"+tmUrl+"' style='color: #b81106;background:none;'>" + GetterUtil.getString(doc.get(LitigationConstants.TRADEMARKS)) + "</a>");
					} */
					
					
					row.addText(procdingType);
					row.addText(GetterUtil.getString(doc.get(LitigationConstants.FILED_BY)));
					row.addText(Utils.getDateStrYMD(doc, LitigationConstants.FILED_ON_DATE));
					row.addText(GetterUtil.getString(doc.get(LitigationConstants.THRID_PARTY_APP_NUMBER)));
					if(Validator.isNotNull(rdl)){
						//row.addText(GetterUtil.getString(rdl.getClaimsRemarks()));
						row.addText(Utils.getDateStrYMD(rdl.getResponseDeadline()));
					;
					}else{
						//row.addText(" ");
						row.addText(" ");
						//row.addText(" ");
						
					}
					row.addText(GetterUtil.getString(doc.get(LitigationConstants.STATUS)));
					row.addText(GetterUtil.getString(doc.get(LitigationConstants.VERSION)));
				

					isLatest = GetterUtil.getBoolean(doc.get(LitigationConstants.LATEST));
					if(editPermission){
						if(isLatest){
							actionUrl = PortletURLFactoryUtil.create(request, LitigationConstants.PORTLET_ID, themeDisplay.getPlid(), PortletRequest.ACTION_PHASE);   //renderResponse.createActionURL();
							actionUrl.setWindowState(WindowState.MAXIMIZED);
							actionUrl.setParameter(LitigationConstants.LITIGATION_ID, classPK + "");
							actionUrl.setParameter("javax.portlet.action","displayEditLitigation");
							addSearchParams(actionUrl);
							row.addText("Edit", actionUrl.toString());
						}else{
							row.addText("  ");
						}
					}
					actionUrl = PortletURLFactoryUtil.create(request, LitigationConstants.PORTLET_ID, themeDisplay.getPlid(), PortletRequest.ACTION_PHASE);   //renderResponse.createActionURL();
					actionUrl.setWindowState(WindowState.MAXIMIZED);
					actionUrl.setParameter(LitigationConstants.LITIGATION_ID, classPK + "");
					actionUrl.setParameter("javax.portlet.action","displayLitigationDetails");
					addSearchParams(actionUrl);
					row.addText("Details", actionUrl.toString());
					resultRows.add(row);
				}
			} 
			return searchContainer;

	}
	public SearchContainer SearchOnRDL() throws WindowStateException{
		boolean editPermission = false;
		try {
			LegalPermissionUtil.authorize(request,LitigationConstants.PORTLET_ID,
					LitigationConstants. ACTION_KEY_EDIT_LITIGATION); 
			editPermission = true;
		} catch (Exception e) {
			_log.error(e);
		} 
		
		//PortletURL portletURL = response.createRenderURL();
		PortletURL portletURL = getRenderUrl(LitigationConstants.PORTLET_ID);
		
		List<String> headerNames = new ArrayList<String>();
		headerNames.add("Trademark Application Number / Country");
		headerNames.add("Trademark Name");
		headerNames.add("Proceedings");
		headerNames.add("Filed By");
		headerNames.add("Filed on");
		headerNames.add(LitigationConstants.THRID_PARTY_APP_NUMBER_COLUMN);
		headerNames.add("Response Deadline");
		//headerNames.add("Alert Before");
		headerNames.add("Status");
		headerNames.add("Version");
		if (editPermission) {
			headerNames.add("Edit");
		}
		headerNames.add("Details");
		
		// create search container, used to display table
		SearchContainer searchContainer = new SearchContainer(request,
				null, null, SearchContainer.DEFAULT_CUR_PARAM,
				SearchContainer.DEFAULT_DELTA, portletURL, headerNames,
				"There are no Contentious Proceedings to display");
		portletURL.setParameter(searchContainer.getCurParam(),
				String.valueOf(searchContainer.getCurValue()));
		
		setSearchContainerParamsToSearchParamMap(searchContainer);
		
		Map<String,Document>indexdMap = new LinkedHashMap<String,Document>();
		try {
				SearchContext searchContext = getDefaultSearchContext();
				List<BooleanClause>bcList = super.getSearchConditions(searchContext);
				Map<String,Document>rdls  = getLitigationBasedOnRDLs(searchContext, themeDisplay.getCompanyId(), bcList); //getRDLsInDays(days,themeDisplay.getUser().getCompanyId(),false,false);
				int index = 0;
				for (String key : rdls.keySet()) {
					indexdMap.put(String.valueOf(index), rdls.get(key));
					index ++;
				}
		} catch (Exception e) {
			_log.error(e.getMessage(), e);
		}
		if (indexdMap.size() > 0) {
			// set count into search container
			searchContainer.setTotal(indexdMap.size());
			int start = searchContainer.getStart();
			int end = searchContainer.getEnd();
			// fill table
			List<ResultRow> resultRows = searchContainer.getResultRows();
			PortletURL actionUrl;
			String procdingType = "";
			String alertBefore = "";
			List<Long>catIds;
			long classPK;
			boolean isLatest;
			TrademarksSearch tsearch = new TrademarksSearch(request, response);
			RDL rdlmodel = null;
			for (int i = start; i < end; i++) {
				try{
					Document rdl = indexdMap.get(String.valueOf(i));
					long rdlId = GetterUtil.getLong(rdl.get(Field.ENTRY_CLASS_PK));
					classPK = GetterUtil.getLong(rdl.get(LitigationConstants.LITIGATION_ID));
					try{
						//TODO: Due to time constraint, fetching rdls from db. Later it can be changed to indexer call.
						List<RDL>rdls = RDLLocalServiceUtil.findBylitigationId(classPK);
						if(Validator.isNotNull(rdls) && rdls.size() > 0){
							rdlmodel = rdls.get(rdls.size()-1);
						}
					}catch(Exception ex){
						
					}
					
					Document doc = getDocumentByPK(classPK);
					
					String tmTextRUrl = null;
					String rootTmId = doc.get(TrademarksConstants.TRADEMARKS_ID);
					Map<String, String> latestTmMap = tsearch.getLatestTrademarksByRootTrademarksId(
							rootTmId, false);
					
					catIds = Utils.getCategoryIds(doc);   
					//country = Utils.getCategoryName(preferences, TrademarksConstants.COUNTRY_VOC_ID, catIds);
					procdingType = Utils.getCategoryName(preferences, LitigationConstants.PROCEEDING_TYPE_VOC_ID, catIds);
					alertBefore = Utils.getCategoryName(preferences, LitigationConstants.ALERT_BEFORE_VOC_ID, catIds);
					
					ResultRow row = new ResultRow(doc, classPK, i);
					
					String tmUrl = Utils.getTrademarkDetailsFriendlyUrl(getLatestTrademarkId(doc.get(TrademarksConstants.TRADEMARKS_ID),tsearch));
					tmUrl = tmUrl.trim();
					row.addText( tsearch.getTrademarkApplicationNumCountryByRootTrademarkId(GetterUtil.getString(doc.get(TrademarksConstants.TRADEMARKS_ID))));
					
					String tmType = latestTmMap.get(TrademarksConstants.TRADEMARK_TYPE);
					if (TrademarksConstants.LOGO.equalsIgnoreCase(tmType)) {
						tmTextRUrl = TrademarksSearch.getTrademarkLogoUrl(request, rootTmId);

						String imageHtml = TrademarksConstants.TRADEMARK_LOGO_IMG_FORMAT;//"<img border='2' src='%s' width='100px' height='50px'>";
						imageHtml = String.format(imageHtml, tmTextRUrl);
						row.addText("<a class='tmLink' href='"+tmUrl+"' style='color: #b81106;background:none;'>" + imageHtml + "</a>");
						
					}else{
						tmTextRUrl = latestTmMap.get(TrademarksConstants.TRADEMARK);
						row.addText("<a class='tmLink' href='"+tmUrl+"' style='color: #b81106;background:none;'>" + GetterUtil.getString(tmTextRUrl) + "</a>");
					}
					row.addText(procdingType);
					row.addText(GetterUtil.getString(doc.get(LitigationConstants.FILED_BY)));
					row.addText(Utils.getDateStrYMD(doc, LitigationConstants.FILED_ON_DATE));
					row.addText(GetterUtil.getString(doc.get(LitigationConstants.THRID_PARTY_APP_NUMBER)));
					if(Validator.isNotNull(rdlmodel)){
						row.addText(Utils.getDateStrYMD(rdlmodel.getResponseDeadline()));
					}else{
						row.addText(" ");
						
					}
					row.addText(GetterUtil.getString(doc.get(LitigationConstants.STATUS)));
					row.addText(GetterUtil.getString(doc.get(LitigationConstants.VERSION)));

					
					isLatest = GetterUtil.getBoolean(doc.get(LitigationConstants.LATEST));
					if(editPermission){
						if(isLatest){
							actionUrl = PortletURLFactoryUtil.create(request, LitigationConstants.PORTLET_ID, themeDisplay.getPlid(), PortletRequest.ACTION_PHASE);   //renderResponse.createActionURL();
							actionUrl.setWindowState(WindowState.MAXIMIZED);
							actionUrl.setParameter(LitigationConstants.LITIGATION_ID, classPK + "");
							actionUrl.setParameter("javax.portlet.action","displayEditLitigation");
							addSearchParams(actionUrl);
							row.addText("Edit", actionUrl.toString());
						}else{
							row.addText("  ");
						}
					}
					actionUrl = PortletURLFactoryUtil.create(request, LitigationConstants.PORTLET_ID, themeDisplay.getPlid(), PortletRequest.ACTION_PHASE);   //renderResponse.createActionURL();
					actionUrl.setWindowState(WindowState.MAXIMIZED);
					actionUrl.setParameter(LitigationConstants.LITIGATION_ID, classPK + "");
					actionUrl.setParameter("javax.portlet.action","displayLitigationDetails");
					addSearchParams(actionUrl);
					row.addText("Details", actionUrl.toString());
					resultRows.add(row);
					
				}catch(Exception ex){
					
				}
			}
		} 
		return searchContainer;
		
	}
	
	public static BooleanClause getBCForRDL(SearchContext searchContext,int days,boolean withInOrOn){
		BooleanClause bc = null;
		Calendar fromCalendar = Calendar.getInstance();
		Calendar toCalender = Calendar.getInstance(); 
		if(withInOrOn){
			fromCalendar.add(Calendar.DAY_OF_MONTH, days);
		}
		toCalender.add(Calendar.DAY_OF_MONTH, days);
		
		bc = getBC4RangeTerm(LitigationConstants.RESPONSE_DEADLINE, fromCalendar, toCalender, searchContext);
		
		return bc;
	}
	
	//Used to get Litigations meething their response deadlines in given number of days
	 // withInOrOn - true indicates  get litigations expiring on 30th/60th/90th/ day etc..
 	 // withInOrOn - false indicates  get litigations expiring with 30/60/90/ days etc..
	
	public static Map<String,Document> getRDLsInDays(int days,long companyId,boolean withInOrOn, boolean considerAlertBefore) {
		
		SearchContext searchContext = new SearchContext();
		searchContext.setStart(-1);
		searchContext.setEnd(-1);
		searchContext.setCompanyId(companyId);
		
		List<BooleanClause> booleanClauseList = new ArrayList<BooleanClause>() ;
	/*	Calendar fromCalendar = Calendar.getInstance();
		Calendar toCalender = Calendar.getInstance(); 
		if(withInOrOn){
			fromCalendar.add(Calendar.DAY_OF_MONTH, days);
		}
		toCalender.add(Calendar.DAY_OF_MONTH, days);
		booleanClauseList.add(getBC4RangeTerm(LitigationConstants.RESPONSE_DEADLINE, fromCalendar, toCalender, searchContext)); */
		booleanClauseList.add(getBCForRDL(searchContext, days, withInOrOn));
		booleanClauseList.add(getBC4ExactTerm(LitigationConstants.LATEST, "true", searchContext));
		
		if(considerAlertBefore){
			try{
				long vocId = GetterUtil.getLong(SambaashUtil.getParameter(SambaashConstants.LITIGATION_ALERT_BEFOR_VOC_ID, 0));
				long catId = Utils.getCategoryId(vocId, String.valueOf(days));
				
				BooleanQuery bq = BooleanQueryFactoryUtil.create(searchContext);
				
				bq.addRequiredTerm(Field.ASSET_CATEGORY_IDS, catId);
				BooleanClause bc = BooleanClauseFactoryUtil.create(searchContext,bq,
						BooleanClauseOccur.MUST.getName());
				booleanClauseList.add(bc);
				
			}catch(Exception ex){
				_log.error("Error while adding alert before boolean clause ");
			}
		}
		
		BooleanClause []booleanClauses = toBCArray(booleanClauseList);
		if(Validator.isNotNull(booleanClauses) && booleanClauses.length > 0){
			searchContext.setBooleanClauses(booleanClauses);
		}
		
		searchContext.setBooleanClauses(booleanClauses);
		Sort sort = SortFactoryUtil.create(LegalConstants.SORT_FIELD, Sort.STRING_TYPE,
				false);
		Sort sort1 = SortFactoryUtil.create(LitigationConstants.COUNTRY, Sort.STRING_TYPE,
				false);
		Sort[] sorts = new Sort[] { sort,sort1 };
		searchContext.setSorts(sorts);
		
		Indexer indexer = IndexerRegistryUtil.getIndexer(RDL.class.getName());
		Hits results = null;
		try {
			results = indexer.search(searchContext);
		} catch (SearchException e) {
			_log.error(e.getMessage(), e);
		}
		Map<String,Document>map = new LinkedHashMap<String,Document>();
		if (results != null) {
			// Calculate the total number of records falling under given response deadlin
			//searchContainer.setTotal(results.getLength());
			// fill table
			int length = results.getDocs().length;
			for (int i = 0; i < length; i++) {
				Document doc = results.doc(i);
				map.put(doc.get(LitigationConstants.LITIGATION_ID), doc);
			}
		} 
		return map;
		
	}
	public static Map<String,Document> getLitigationBasedOnRDLs(SearchContext searchContext, long companyId, List<BooleanClause>bcList) {
		
		List<BooleanClause> booleanClauseList = new ArrayList<BooleanClause>() ;
		if(Validator.isNotNull(bcList)){
			booleanClauseList.addAll(bcList);
		}
		BooleanClause []booleanClauses = toBCArray(booleanClauseList);
		if(Validator.isNotNull(booleanClauses) && booleanClauses.length > 0){
			searchContext.setBooleanClauses(booleanClauses);
		}
		
		searchContext.setBooleanClauses(booleanClauses);
		
		Indexer indexer = IndexerRegistryUtil.getIndexer(RDL.class.getName());
		Hits results = null;
		try {
			results = indexer.search(searchContext);
		} catch (SearchException e) {
			_log.error(e.getMessage(), e);
		}
		Map<String,Document>map = new LinkedHashMap<String,Document>();
		if (results != null) {
			// Calculate the total number of records falling under given response deadlin
			//searchContainer.setTotal(results.getLength());
			// fill table
			int length = results.getDocs().length;
			for (int i = 0; i < length; i++) {
				Document doc = results.doc(i);
				map.put(doc.get(LitigationConstants.LITIGATION_ID), doc);
			}
		} 
		return map;
		
	}
	/*public static long[] reorderCategoryIds(PortletPreferences preferences,long[] categoryIds){

		String []vocIdFields = new String[LitigationConstants.CATEGORIES_IDS_SIZE];
		vocIdFields[0] = LitigationConstants.PROCEEDING_TYPE_VOC_ID;
		vocIdFields[1] = LitigationConstants.FILED_AT_COUNTRY_VOC_ID;
		vocIdFields[2] = LitigationConstants.ALERT_BEFORE_VOC_ID;
		vocIdFields[3] = LitigationConstants.CUSTOM_LIST_1_VOC_ID;
		vocIdFields[4] = LitigationConstants.CUSTOM_LIST_2_VOC_ID;
		vocIdFields[5] = LitigationConstants.CUSTOM_LIST_3_VOC_ID;
		
		return Utils.reorderCategoryIds(preferences, vocIdFields, categoryIds);
	} 
	public static long[] reorderCategoryIds(long[] categoryIds){
		long[] vocIds = new long[LitigationConstants.CATEGORIES_IDS_SIZE];
		vocIds[0] = GetterUtil.getLong(SambaashUtil.getParameter(SambaashConstants.LITIGATION_PROCEEDING_TYPE_VOC_ID, 0));
		vocIds[1] = GetterUtil.getLong(SambaashUtil.getParameter(SambaashConstants.LITIGATION_FILED_AT_COUNTRY_VOC_ID, 0));
		vocIds[2] = GetterUtil.getLong(SambaashUtil.getParameter(SambaashConstants.LITIGATION_ALERT_BEFOR_VOC_ID, 0));
		vocIds[3] = GetterUtil.getLong(SambaashUtil.getParameter(SambaashConstants.LITIGATION_CUSTOM_LIST_1_VOC_ID, 0));
		vocIds[4] = GetterUtil.getLong(SambaashUtil.getParameter(SambaashConstants.LITIGATION_CUSTOM_LIST_2_VOC_ID, 0));
		vocIds[5] = GetterUtil.getLong(SambaashUtil.getParameter(SambaashConstants.LITIGATION_CUSTOM_LIST_3_VOC_ID, 0));
		
		return Utils.reorderCategoryIds(vocIds, categoryIds);
	} */
	
	public Map<String,String> getLitigationMap(Document doc,boolean convertNltoBr){
		Map<String,String> map = new HashMap<String,String>();
		if(Validator.isNotNull(doc)){
			try{
				
				List<Long>catIds = Utils.getCategoryIds(doc);   
				//country = Utils.getCategoryName(preferences, TrademarksConstants.COUNTRY_VOC_ID, catIds);
				long proceedingVocId = GetterUtil.getLong(SambaashUtil.getParameter(SambaashConstants.LITIGATION_PROCEEDING_TYPE_VOC_ID, 0));
/*				long alertVocId = GetterUtil.getLong(SambaashUtil.getParameter(SambaashConstants.LITIGATION_ALERT_BEFOR_VOC_ID, 0));
				long cList1VocId = GetterUtil.getLong(SambaashUtil.getParameter(SambaashConstants.LITIGATION_CUSTOM_LIST_1_VOC_ID, 0));
				long cList2VocId = GetterUtil.getLong(SambaashUtil.getParameter(SambaashConstants.LITIGATION_CUSTOM_LIST_2_VOC_ID, 0));
				long cList3VocId = GetterUtil.getLong(SambaashUtil.getParameter(SambaashConstants.LITIGATION_CUSTOM_LIST_3_VOC_ID, 0)); */
				
				String procdingType = Utils.getCategoryName(proceedingVocId, catIds);
				//String alertBefore = Utils.getCategoryName(alertVocId, catIds);
/*				String customList1CatName = Utils.getCategoryName(cList1VocId, catIds);
				String customList2CatName = Utils.getCategoryName(cList2VocId, catIds);
				String customList3CatName = Utils.getCategoryName(cList3VocId, catIds); */
				
			
				TrademarksSearch tsearch = new TrademarksSearch(request,response);
				map.put(LitigationConstants.LITIGATION_ID,GetterUtil.getString(doc.get(Field.ENTRY_CLASS_PK)));
//				map.put(TrademarksConstants.TRADEMARK,tsearch.getTrademarkRegNumCountry(GetterUtil.getString(doc.get(TrademarksConstants.TRADEMARKS_ID))));
				map.put(TrademarksConstants.TRADEMARK,tsearch.getTrademarkApplicationNumCountryByRootTrademarkId(GetterUtil.getString(doc.get(TrademarksConstants.TRADEMARKS_ID))));
				map.put(LitigationConstants.VERSION,GetterUtil.getString(doc.get(LitigationConstants.VERSION)));
				map.put(LitigationConstants.PROCEEDING_TYPE, procdingType);
				map.put(LitigationConstants.FILED_BY,GetterUtil.getString(doc.get(LitigationConstants.FILED_BY)));
				map.put(LitigationConstants.FILED_ON_DATE,Utils.getDateStrYMD(doc, LitigationConstants.FILED_ON_DATE));
				//map.put(LitigationConstants.FILED_AT_COUNTRY,filedAtCountry);
			//	map.put(LitigationConstants.CLAIMS_REMARKS,GetterUtil.getString(doc.get(LitigationConstants.CLAIMS_REMARKS)));
			//	map.put(LitigationConstants.RESPONSE_DEADLINE,Utils.getDateStrYMD(doc, LitigationConstants.RESPONSE_DEADLINE));
				//map.put(LitigationConstants.ALERT_BEFORE,alertBefore);
				//map.put(LitigationConstants.ACTUAL_RESPONSE_DATE,Utils.getDateStrYMD(doc, LitigationConstants.ACTUAL_RESPONSE_DATE));
				map.put(LitigationConstants.STATUS,GetterUtil.getString(doc.get(LitigationConstants.STATUS)));
				map.put(LitigationConstants.LAW_FIRM,GetterUtil.getString(doc.get(LitigationConstants.LAW_FIRM)));
				map.put(LitigationConstants.THRID_PARTY_APP_NUMBER,GetterUtil.getString(doc.get(LitigationConstants.THRID_PARTY_APP_NUMBER)));
/*				map.put(LitigationConstants.CUSTOM_FIELD_3,GetterUtil.getString(doc.get(LitigationConstants.CUSTOM_FIELD_3)));
				map.put(LitigationConstants.CUSTOM_DATE_1,Utils.getDateStrYMD(doc, LitigationConstants.CUSTOM_DATE_1));
				map.put(LitigationConstants.CUSTOM_DATE_2,Utils.getDateStrYMD(doc, LitigationConstants.CUSTOM_DATE_2));
				map.put(LitigationConstants.CUSTOM_DATE_3,Utils.getDateStrYMD(doc, LitigationConstants.CUSTOM_DATE_3));
				map.put(LitigationConstants.CUSTOM_LIST_1,customList1CatName);
				map.put(LitigationConstants.CUSTOM_LIST_2,customList2CatName);
				map.put(LitigationConstants.CUSTOM_LIST_3,customList3CatName); */
				map.put(LitigationConstants.LATEST, doc.get(LitigationConstants.LATEST));
				map.put(LitigationConstants.ROOT_LITIGATION_ID, doc.get(LitigationConstants.ROOT_LITIGATION_ID));
				
				String desc = doc.get(TrademarksConstants.LEGAL_CONF_REMARKS);
				if(convertNltoBr){
					desc = Utils.toHtmlTags(desc);
				}
				map.put(TrademarksConstants.LEGAL_CONF_REMARKS, desc);
				
			}catch(Exception ex){
				
			}
			
		}
		return map;
	}
	public Map<String,String> getLitigationMap(Litigation litigation,boolean convertNltoBr){
		Map<String,String> map = new HashMap<String,String>();
		if(Validator.isNotNull(litigation)){
			try{
				
	//			AssetEntry assetEntry = AssetEntryLocalServiceUtil.fetchEntry(
		//				Litigation.class.getName(), litigation.getSpLitigationId());
				List<Long> catIds = Utils.getAssetCategoryIds(Litigation.class.getName(), litigation.getSpLitigationId());//Utils.getLongList(assetEntry.getCategoryIds());

				//country = Utils.getCategoryName(preferences, TrademarksConstants.COUNTRY_VOC_ID, catIds);
				long proceedingVocId = GetterUtil.getLong(SambaashUtil.getParameter(SambaashConstants.LITIGATION_PROCEEDING_TYPE_VOC_ID, 0));
				//long alertVocId = GetterUtil.getLong(SambaashUtil.getParameter(SambaashConstants.LITIGATION_ALERT_BEFOR_VOC_ID, 0));
			/*	long cList1VocId = GetterUtil.getLong(SambaashUtil.getParameter(SambaashConstants.LITIGATION_CUSTOM_LIST_1_VOC_ID, 0));
				long cList2VocId = GetterUtil.getLong(SambaashUtil.getParameter(SambaashConstants.LITIGATION_CUSTOM_LIST_2_VOC_ID, 0));
				long cList3VocId = GetterUtil.getLong(SambaashUtil.getParameter(SambaashConstants.LITIGATION_CUSTOM_LIST_3_VOC_ID, 0)); */
				
				String procdingType = Utils.getCategoryName(proceedingVocId, catIds);
		//		String alertBefore = Utils.getCategoryName(alertVocId, catIds);
				/*String customList1CatName = Utils.getCategoryName(cList1VocId, catIds);
				String customList2CatName = Utils.getCategoryName(cList2VocId, catIds);
				String customList3CatName = Utils.getCategoryName(cList3VocId, catIds);*/
			
				TrademarksSearch tsearch = new TrademarksSearch(request,response);
				map.put(LitigationConstants.LITIGATION_ID,String.valueOf(litigation.getSpLitigationId()));
				map.put(TrademarksConstants.TRADEMARK,tsearch.getTrademarkApplicationNumCountryByRootTrademarkId(String.valueOf(litigation.getSpTrademarksId())));
				map.put(LitigationConstants.VERSION,GetterUtil.getString(litigation.getVersion()));
				map.put(LitigationConstants.PROCEEDING_TYPE, procdingType);
				map.put(LitigationConstants.FILED_BY,GetterUtil.getString(litigation.getFiledBy()));
				map.put(LitigationConstants.FILED_ON_DATE,Utils.getDateStrYMD(litigation.getFiledOn()));
				//map.put(LitigationConstants.FILED_AT_COUNTRY,filedAtCountry);
			//	map.put(LitigationConstants.CLAIMS_REMARKS,GetterUtil.getString(litigation.getClaimsRemarks()));
			//	map.put(LitigationConstants.RESPONSE_DEADLINE,Utils.getDateStrYMD(litigation.getResponseDeadline()));
			//	map.put(LitigationConstants.ALERT_BEFORE,alertBefore);
				//map.put(LitigationConstants.ACTUAL_RESPONSE_DATE,Utils.getDateStrYMD(doc, LitigationConstants.ACTUAL_RESPONSE_DATE));
				map.put(LitigationConstants.STATUS,GetterUtil.getString(litigation.getStatus()));
				map.put(LitigationConstants.LAW_FIRM,GetterUtil.getString(litigation.getCustomField1()));
				map.put(LitigationConstants.THRID_PARTY_APP_NUMBER,GetterUtil.getString(litigation.getCustomField2()));
				map.put(LitigationConstants.CUSTOM_FIELD_3,GetterUtil.getString(litigation.getCustomField2()));
			/*	map.put(LitigationConstants.CUSTOM_DATE_1,Utils.getDateStrYMD(litigation.getCustomDate1()));
				map.put(LitigationConstants.CUSTOM_DATE_2,Utils.getDateStrYMD(litigation.getCustomDate2()));
				map.put(LitigationConstants.CUSTOM_DATE_3,Utils.getDateStrYMD(litigation.getCustomDate3()));
				map.put(LitigationConstants.CUSTOM_LIST_1,customList1CatName);
				map.put(LitigationConstants.CUSTOM_LIST_2,customList2CatName);
				map.put(LitigationConstants.CUSTOM_LIST_3,customList3CatName);*/
				map.put(LitigationConstants.UPDATE_BY, litigation.getUserName());
				map.put(LitigationConstants.MODIFIED_DATE, Utils.getDateTime(litigation.getModifiedDate()));
				map.put(LitigationConstants.LATEST, String.valueOf(isLitigationLatest(litigation)));
				map.put(LitigationConstants.ROOT_LITIGATION_ID, String.valueOf(litigation.getRootSpLitigationId()));
				String desc = litigation.getLegalConfRemarks();
				if(convertNltoBr){
					desc = Utils.toHtmlTags(desc);
				}
				map.put(TrademarksConstants.LEGAL_CONF_REMARKS,desc );
				
			}catch(Exception ex){
				_log.error("error while creating map", ex);
			}
		}
		return map;
	}
	
	public static boolean isLitigationLatest(Litigation litigation){
		boolean isLatest = true;
		List<Object[]> litigationIdArrList = LitigationLocalServiceUtil.getLatestLitigation(litigation.getRootSpLitigationId());
		if (Validator.isNotNull(litigationIdArrList) && litigationIdArrList.size() > 0) {
			Object[] litigationIdArr = ((Object[]) litigationIdArrList.get(0));

			if (((Long) litigationIdArr[1]).compareTo(litigation.getSpLitigationId()) == 0) {
				//document.addKeyword(TrademarksConstants.LATEST, true);
				isLatest = true;
			}else{
			//	document.addKeyword(TrademarksConstants.LATEST, false);
				isLatest = false;
			}
		}
		return isLatest;
	}
	public  Map<String,String> getLitigationMap(long litigationId,boolean convertNltoBr){
		Document doc = getDocumentByPK(litigationId);
		Map<String,String> map = getLitigationMap(doc,convertNltoBr);
		return map;
	}
	public  Map<String,String> getLitigationMap(String litigationId,boolean convertNltoBr){
		return getLitigationMap(GetterUtil.getLong(litigationId),convertNltoBr);
	}
	public  Map<String,String> getLatestLitigationByRootLitigationId(long rootLitigationId,boolean convertNltoBr){
		 Document doc = getLatestDocumentByRootId(rootLitigationId,LitigationConstants.ROOT_LITIGATION_ID);
		 Map<String,String> map = getLitigationMap(doc,convertNltoBr);
		 return map;
	}
	public  Map<String,String> getLatestLitigationByRootLitigationId(String rootLitigationId,boolean convertNltoBr){
		return getLatestLitigationByRootLitigationId(GetterUtil.getLong(rootLitigationId),convertNltoBr);
	}
	public  String getLatestLitigationIdByRootLitigationId(String rootLitigationId){
		Map<String,String> map = getLatestLitigationByRootLitigationId(GetterUtil.getLong(rootLitigationId),false);
		return map.get(LitigationConstants.LITIGATION_ID);
	}
	public  String getLatestLitigationFiledByRootLitigationId(String rootLitigationId){
		Map<String,String> map = getLatestLitigationByRootLitigationId(GetterUtil.getLong(rootLitigationId),false);
		return map.get(LitigationConstants.FILED_BY);
	}
	public  String geLitigationFiledBy(String litigationId){
		Map<String,String> map = getLitigationMap(GetterUtil.getLong(litigationId),false);
		return map.get(LitigationConstants.FILED_BY);
	}
	public  String getThirdPartyTMNum(String litigationId){
		Map<String,String> map = getLitigationMap(GetterUtil.getLong(litigationId),false);
		return map.get(LitigationConstants.THRID_PARTY_APP_NUMBER);
	}
	
	public static String getLitigationFolderName(String litigationId){
		String folderName = String.format(LitigationConstants.LITIGATION_FOLDER_NAME_FORMAT, litigationId);
		return folderName;
	}
	public static String getLitigationFolderName(long litigationId){
		return getLitigationFolderName(String.valueOf(litigationId));
	}
	
	public static long[] getFolderIds(PortletRequest actionRequest, String folderName) {
		long []folderIds = new long[2];
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		try {
			String rootPath = LegalConstants.LEGAL_ROOT_FOLDER_NAME + "/" + LitigationConstants.LITIGATION_ROOT_FOLDER_NAME  + "/" + folderName;
			String attachmentPath = rootPath + "/" + LitigationConstants.FOLDER_NAME_ATTACHEMENTS;
			String ConfattachmentPath = rootPath + "/" + LitigationConstants.FOLDER_NAME_CONF_ATTACHEMENTS;
			
			Folder attachmentFolder = (Folder) Utils.createGetFileOrFolder(actionRequest, themeDisplay.getUser(), LegalConstants.DL_ROOT_FOLDER_ID, attachmentPath, 
					LegalConstants.FOLDER, false, true, true);
			Folder ConfattachmentFolder = (Folder) Utils.createGetFileOrFolder(actionRequest, themeDisplay.getUser(), LegalConstants.DL_ROOT_FOLDER_ID, ConfattachmentPath, 
					LegalConstants.FOLDER, false, true, true);
			folderIds[0] = attachmentFolder.getFolderId();
			folderIds[1] = ConfattachmentFolder.getFolderId();
			
		} catch (Exception e) {
			_log.error(e.getMessage(), e);
		}

		return folderIds;
	}
	
	protected BooleanClause getSearchCondition(SearchContext searchContext,String searchField, String searchFieldValue,String from,String to) {
		BooleanClause bc = null;

		if(LitigationConstants.LITIGATION_HISTORY.equals(searchField)){
			if(LegalConstants.SEARCH_AUDIT_HISTORY.equals(searchFieldValue)){
				this.showLatestOnly = false;
			}
		}else if(LitigationConstants.ALERT_BEFORE.equals(searchField)){
			String strDays = Utils.getCategoryName(GetterUtil.getInteger(searchFieldValue));
			int days = GetterUtil.getInteger(strDays);
			//Get boolean clause to get litigations having responsed deadline in given days
			bc = getBCForRDL(searchContext, days, false);
		}else{
			bc = super.getSearchCondition(searchContext, searchField, searchFieldValue, from, to);
		}
		return bc;
	}
	
	public static RDL getLatestRDL(long litigaionId){
		RDL rdl = null;
		try{
			//TODO: Due to time constraint, fetching rdls from db. Later it can be changed to indexer call.
			List<RDL>rdls = RDLLocalServiceUtil.findBylitigationId(litigaionId);
			if(Validator.isNotNull(rdls) && rdls.size() > 0){
				rdl = rdls.get(rdls.size()-1);
			}
		}catch(Exception ex){
			
		}
		
		return rdl;
	}
	
	private String getLatestTrademarkId(String rootTmId, TrademarksSearch search) {
		Map<String, String> map = search.getLatestTrademarksByRootTrademarksId(
				rootTmId, false);
		if (Validator.isNotNull(map.get(TrademarksConstants.TRADEMARKS_ID)))
			return map.get(TrademarksConstants.TRADEMARKS_ID);
		else
			return rootTmId;
	}
}
