package com.sambaash.platform.portlet.legalandcontract.search;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionResponse;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.PortletURL;
import javax.portlet.WindowStateException;

import org.apache.commons.lang.StringEscapeUtils;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
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
import com.liferay.portal.kernel.util.FastDateFormatFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.PortletURLFactoryUtil;
import com.liferay.portlet.asset.model.AssetCategory;
import com.sambaash.platform.portlet.legalandcontract.util.AgencyConstants;
import com.sambaash.platform.portlet.legalandcontract.util.LegalConstants;
import com.sambaash.platform.portlet.legalandcontract.util.LitigationConstants;
import com.sambaash.platform.portlet.legalandcontract.util.TrademarksConstants;
import com.sambaash.platform.portlet.legalandcontract.util.Utils;
import com.sambaash.platform.util.SambaashUtil;

abstract public class LegalContractSearch {
	
	protected static final String LIST = "list";
	protected static final String TEXT = "text";
	protected static final String DELTA = "delta";
	protected static final String RESET_CUR = "resetCur";
	protected static final  String SEARCH_FIELD =  "searchField";
	protected static final  String SEARCH_FIELD_VALUE =  "searchValue";
	protected static final  String SEARCH_FROM =  "searchFrom";
	protected static final  String SEARCH_TO =  "searchTo";
	protected PortletRequest request;
	protected PortletResponse response;
	protected PortletPreferences preferences;
	protected ThemeDisplay themeDisplay;
	
	protected  List<SearchField>list;
	protected Map<String,String>searchParamMap;
	
	protected static String LIST_ID_FORMAT = "list_%s";
	protected static String _DATE_FORMAT_PATTERN = PropsUtil.get("index.date.format.pattern");
	boolean setupDone = false;
	protected  String className;
	private static Log _log = LogFactoryUtil.getLog(LegalContractSearch.class);

	protected static final String SEARCH_QUERY_PARAM =  "searchQueryJson";
	protected boolean showLatestOnly = true;
	public LegalContractSearch(PortletRequest request,PortletResponse response,String className){

		this.request = request;
		this.response = response;
		this.preferences = request.getPreferences();
		this.className = className;
		this.themeDisplay = (ThemeDisplay)request.getAttribute (WebKeys.THEME_DISPLAY);
		this.searchParamMap = new HashMap<String, String>();
	}
	
	public void setup(){
		if(!setupDone){
			initSearchFields();
			request.setAttribute("sfs", list);
			fillDropDownData();
		}
	}
	public void extraSetup(){
		
	}
	public SearchContainer search() throws WindowStateException, PortalException{
		setup();
		extraSetup();
		return getSearchContainer();
	}
	public void initSearchFields(){
		list = getSearchFields();
		Collections.sort(list);
	}
	
	protected long getVocId(String vocIdKey){
		  return Long.parseLong(preferences.getValue(vocIdKey,"0"));
	}
	
	protected String getListId(String id){
		return String.format(LIST_ID_FORMAT, id);
	}
	
	protected void fillDropDownData(){
		long vocId;
		List<AssetCategory> categoris;
		String listId;
		StringBuilder sb = new StringBuilder();
		Map<String,String>map;
		for (SearchField sf : list) {
			if(sf.isCategoryField()){
				if(sf.getVocId() != 0){
					vocId = sf.getVocId();
				}else{
					vocId = getVocId(sf.getVocIdKey());
				}
				if(TrademarksConstants.CLASS_CODE_VOC_ID.equalsIgnoreCase(sf.getVocIdKey()) || TrademarksConstants.RENEWAL_ALERT_BEFORE_VOC_ID.equalsIgnoreCase(sf.getVocIdKey())
						|| LitigationConstants.ALERT_BEFORE_VOC_ID.equalsIgnoreCase(sf.getVocIdKey())){
					categoris = Utils.getCategories(vocId,LegalConstants.SORT_INT);
				}else{
					categoris = Utils.getCategories(vocId);
				}
				listId = getListId(sf.getKey());
				sf.setListId(listId);
				sb.append("'");
				sb.append(listId);
				sb.append("'");
				sb.append(",");
				request.setAttribute(listId,categoris);
			}else if(sf.isDropdownField()){
				map = new LinkedHashMap<String,String>();
				if(sf.getKey().equals(LegalConstants.MODIFIED_TIME)){
					map.put("last_24_hours", "Last 24 hours");
					map.put("last_7_days", "Last 7 days");
					map.put("last_30_days", "Last 30 days");
					map.put("last_365_days", "Last 365 days");
				}else if(sf.getKey().equals(TrademarksConstants.PENDING_RENEWAL)){
					String renewalAlertVocId = preferences.getValue(TrademarksConstants.RENEWAL_ALERT_BEFORE_VOC_ID, "0");
					List<AssetCategory> renewalAlertList = Utils.getCategories(Long
							.parseLong(renewalAlertVocId),LegalConstants.SORT_INT);
					for (AssetCategory assetCategory : renewalAlertList) {
						map.put(assetCategory.getName()+"", assetCategory.getName());
					}
				}else if(sf.getKey().equals(TrademarksConstants.TRADEMARK_HISTORY)){
					map.put("all", "All");
					map.put("active", "Active");
					map.put("expired", "Expired");
					map.put("auditHistory", "Versions");
				} else if(sf.getKey().equals(LitigationConstants.TRADEMARK_REG_NUMBER)){
					TrademarksSearch search = new TrademarksSearch(request, response); 
					map = search.getTrademarksIdAdnRegNum();
				} else if(sf.getKey().equals(AgencyConstants.AGENCY_HISTORY)) {
					map.put("latest", "Latest Versions");
					map.put("auditHistory", "All Versions");
				} else if(sf.getKey().equals(LitigationConstants.LITIGATION_HISTORY)) {
					map.put("latest", "Latest Versions");
					map.put("auditHistory", "All Versions");
				}
				listId = getListId(sf.getKey());
				sf.setListId(listId);
				sb.append("'");
				sb.append(listId);
				sb.append("'");
				sb.append(",");
				request.setAttribute(listId,map);
			}
		}
		String str = sb.toString();
		request.setAttribute("listIds", str);
	}
	
	public String getSearchFieldKeyTrimmed(String id){
		String key = id;
		if(id.toLowerCase().startsWith("list_")){
			//Trim list_
			key = id.substring(5);
		}else if(id.toLowerCase().startsWith("date_")){
			//Trim date_
			key = id.substring(5);
		}else{
			//for the rest of the types not required ex:text
			key = id;
		}
		
		return key;
	}
	
	public  SearchField getSearchField(String id){
		SearchField sf = null;
		for(SearchField tsf: list){
			if(tsf.getKey().equals(id)){
				sf = tsf; break;
			}
		}
		return sf;
	}
	
	protected List<BooleanClause> getSearchConditions(SearchContext searchContext){
		String searchQuery = getSearchQuery();
		return getSearchConditions(searchContext,searchQuery);
	}
		
	protected String getSearchQuery(){
		return ParamUtil.getString(request, SEARCH_QUERY_PARAM);
	}
	
	
	protected List<BooleanClause> getSearchConditions(SearchContext searchContext,String searchQueryJson){
			List<BooleanClause> list = new ArrayList<BooleanClause>();
			if(Validator.isNotNull(searchQueryJson)){
				try{
					JSONArray array = JSONFactoryUtil.createJSONArray(searchQueryJson);
					for(int i = 0 ; i < array.length(); i++){
						JSONObject json = array.getJSONObject(i);
						BooleanClause bc = getSearchCondition(searchContext, getSearchFieldKeyTrimmed(json.getString(SEARCH_FIELD)), json.getString(SEARCH_FIELD_VALUE),json.getString(SEARCH_FROM),json.getString(SEARCH_TO));
						if(Validator.isNotNull(bc)){
							list.add(bc);
						}
					}
				}catch(Exception ex){
					_log.error(ex);
				}
			}
			if (this.showLatestOnly) {
				list.add(getBC4ExactTerm(TrademarksConstants.LATEST, "true", searchContext));
			}
			return list;
	}
	
	protected BooleanClause getSearchCondition1(SearchContext searchContext,String searchField, String searchFieldValue,String from,String to){
		return null;
		
	}
	protected BooleanClause getSearchCondition(SearchContext searchContext,String searchField, String searchFieldValue,String from,String to){
		SearchField sf = getSearchField(searchField);
		BooleanClause bc = null;
		if(Validator.isNotNull(sf)){
			if(sf.isCategoryField() && !LitigationConstants.ALERT_BEFORE.equalsIgnoreCase(sf.getKey())){
				BooleanQuery bq = BooleanQueryFactoryUtil.create(searchContext);
				bq.addRequiredTerm(Field.ASSET_CATEGORY_IDS, searchFieldValue);
				bc = BooleanClauseFactoryUtil.create(searchContext,bq,
						BooleanClauseOccur.MUST.getName());
			}else if(sf.isDropdownField()){
				if (LegalConstants.MODIFIED_TIME.equals(sf.getKey())) {
					String modifiedTime = ParamUtil.getString(request, getListId(LegalConstants.MODIFIED_TIME));
					Calendar fromCalendar = Calendar.getInstance();
					Calendar toCalendar = Calendar.getInstance();
					
					if ("last_24_hours".equalsIgnoreCase(modifiedTime)) {
						fromCalendar.add(Calendar.HOUR_OF_DAY, -24);
					} else if ("last_7_days".equalsIgnoreCase(modifiedTime)) {
						fromCalendar.add(Calendar.DAY_OF_MONTH, -7);
					} else if ("last_30_days".equalsIgnoreCase(modifiedTime)) {
						fromCalendar.add(Calendar.MONTH, -1);
					} else if ("last_365_days".equalsIgnoreCase(modifiedTime)) {
						fromCalendar.add(Calendar.YEAR, -1);
					}
					
					String fromDateString = FastDateFormatFactoryUtil.getSimpleDateFormat(_DATE_FORMAT_PATTERN).format(
							fromCalendar.getTime());
					String toDateString = FastDateFormatFactoryUtil.getSimpleDateFormat(_DATE_FORMAT_PATTERN).format(
							toCalendar.getTime());
					
					BooleanQuery dateBooleanQuery = BooleanQueryFactoryUtil.create(searchContext);
					dateBooleanQuery.addRangeTerm(Field.MODIFIED_DATE, fromDateString, toDateString);
					bc = BooleanClauseFactoryUtil.create(searchContext,dateBooleanQuery,
							BooleanClauseOccur.MUST.getName());
				}
				else if(LitigationConstants.TRADEMARK_REG_NUMBER.equals(sf.getKey())){
					bc = getBC4ExactTerm(TrademarksConstants.TRADEMARKS_ID, searchFieldValue, searchContext);
				}
			}else if(sf.isDateRangeField()){
				if(Validator.isNull(from)){
					from = String.valueOf(Calendar.getInstance().get(Calendar.YEAR) - 100);
					
				}else if(Validator.isNull(to)){
					to = String.valueOf(Calendar.getInstance().get(Calendar.YEAR) + 100) ;
				}
				Calendar fromDate = getDate(from,true);
				Calendar toDate = getDate(to,false);
				
				bc = getBC4RangeTerm(sf.getKey(), fromDate, toDate, searchContext);
			}
			else if(Validator.isNotNull(sf.getKey()) && sf.getKey().startsWith("searchAll")){
				bc = handleAllSearch(sf, searchFieldValue, searchContext);
			} else if(Validator.isNotNull(searchFieldValue)){
				BooleanQuery bq = BooleanQueryFactoryUtil.create(searchContext);
				try {
					if(Utils.startsWithNonEnglishChars(searchFieldValue))
						bq.addTerm(Utils.getIndexFieldInLower(sf.getIndexerFieldName()), Utils.getIndexFieldValueInLower(searchFieldValue).substring(0,1) + "*");
					else 
						bq.addTerm(Utils.getIndexFieldInLower(sf.getIndexerFieldName()), Utils.getIndexFieldValueInLower(searchFieldValue) + "*");
				}catch(Exception e) {
					_log.error("error in search", e);
				}
				 bc = BooleanClauseFactoryUtil.create(searchContext,bq,
						BooleanClauseOccur.MUST.getName());
			}
			
		}
		return bc;
	}
	
	//Even if year alone is present, this method will return date object having month,date 0 
	protected Calendar getDate(String dateStr, boolean rangeFrom){
		Calendar date = null;
		try {
			 if(Validator.isNotNull(dateStr)){
				 String lits[] = dateStr.split("/");
				 date = Calendar.getInstance();
				 date.set(Calendar.DATE,GetterUtil.getInteger(lits[0]));
				 date.set(Calendar.MONTH,GetterUtil.getInteger(lits[1]));
				 date.set(Calendar.YEAR,GetterUtil.getInteger(lits[2]));
			  }
		} catch(Exception ex){
			date = Calendar.getInstance();
			if(Validator.isNotNull(dateStr) && GetterUtil.getInteger(dateStr) > 0){
							//Year,	month,date,hours,min
				date.set(GetterUtil.getInteger(dateStr), 0, 1, 0, 0);
				if(!rangeFrom){
					date.set(Calendar.MONTH,11);
					date.set(Calendar.DATE,31);
				}
			}
		}
		return date;
	}
	

	public void setSearchParam(String key, String value){
		if(Validator.isNull(searchParamMap)){
			searchParamMap = new HashMap<String, String>();
		}
		
		searchParamMap.put("searchParam_"+key, value);
		
	}
	private BooleanClause handleAllSearch(SearchField sf, String fval, SearchContext searchContext) {
		BooleanQuery bq = BooleanQueryFactoryUtil.create(searchContext);
		try {
//			fval = fval + "*";
			if(Utils.startsWithNonEnglishChars(fval))
				bq.addTerm(sf.getIndexerFieldName(), Utils.getIndexFieldValueInLower(fval).substring(0,1) + "*");
			else
				bq.addTerm(sf.getIndexerFieldName(), Utils.getIndexFieldValueInLower(fval) + "*");
		}catch(Exception e) {
			_log.error("error in All search", e);
		}
		BooleanClause bc = BooleanClauseFactoryUtil.create(searchContext,bq,
				BooleanClauseOccur.MUST.getName());
		return bc;
	}

	static BooleanClause  getBC4RangeTerm(String field ,Calendar from, Calendar to, SearchContext searchContext){
		BooleanClause bc = null;
		if(Validator.isNotNull(field)){
			setHMS_0(from);
			setHMS_MAX(to);
			String fromDateString = FastDateFormatFactoryUtil.getSimpleDateFormat(_DATE_FORMAT_PATTERN).format(
					from.getTime());
			String toDateString = FastDateFormatFactoryUtil.getSimpleDateFormat(_DATE_FORMAT_PATTERN).format(
					to.getTime());
			BooleanQuery bq = BooleanQueryFactoryUtil.create(searchContext);
			bq.addRangeTerm(field, fromDateString, toDateString);
			bc = BooleanClauseFactoryUtil.create(searchContext,bq,
					BooleanClauseOccur.MUST.getName());
		}
		return bc;
	}
	static BooleanClause getBC4ExactTerm(String field,String val,SearchContext searchContext){
		BooleanClause bc = null;
		if(Validator.isNotNull(field)){
			BooleanQuery bq = BooleanQueryFactoryUtil.create(searchContext);
			bq.addExactTerm(field, "\"" + val +"\"");
			bc = BooleanClauseFactoryUtil.create(searchContext,bq,
					BooleanClauseOccur.MUST.getName());
		}
		return bc;
	}
	static void  setHMS_0(Calendar cal){
		if(Validator.isNotNull(cal)){
			cal.set(Calendar.AM_PM, Calendar.AM);
			cal.set(Calendar.HOUR,0);
			cal.set(Calendar.MINUTE,0);
			cal.set(Calendar.SECOND,0);
		}
	}
	static void  setHMS_MAX(Calendar cal){
		if(Validator.isNotNull(cal)){
			cal.set(Calendar.AM_PM, Calendar.PM);
			cal.set(Calendar.HOUR,11);
			cal.set(Calendar.MINUTE,59);
			cal.set(Calendar.SECOND,59);
		}
	}
	static BooleanClause[] toBCArray(List<BooleanClause> booleanClauseList){
		BooleanClause[] bcs = null;
		if(Validator.isNotNull(booleanClauseList)){
			bcs = new BooleanClause[booleanClauseList.size()];
			for(int i=0; i < booleanClauseList.size(); i++){
				bcs[i] = booleanClauseList.get(i);
			}
		}
		return bcs;
	}

	public void setSearchConditions(SearchContext searchContext){
		List<BooleanClause> list = getSearchConditions(searchContext);
		BooleanClause []bcs = toBCArray(list);
		if(Validator.isNotNull(bcs) && bcs.length > 0){
			searchContext.setBooleanClauses(bcs);
		}
 	}
	
	protected PortletURL getRenderUrl(String portledId){
		PortletURL portletURL = PortletURLFactoryUtil.create(request, portledId, themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);
		
	/*	String sfId = ParamUtil.getString(request, "searchField");
		String sval = ParamUtil.getString(request, "searchValue");
		String modifiedTime = ParamUtil.getString(request, "modifiedTime");
		String listId = StringPool.BLANK;
		SearchField sf =  getSearchField(sfId);
		if(Validator.isNotNull(sf)){
			portletURL.setParameter("searchField",sfId);
			portletURL.setParameter("modifiedTime",modifiedTime);
			if( sf.isCategoryField() || sf.isDropdownField()){
				listId = getListId(sfId);
				sval = ParamUtil.getString(request,listId );
				portletURL.setParameter(listId,sval); 
			} else{
				portletURL.setParameter("searchValue",sval); 
			}
		} */
		portletURL.setParameter(TrademarksConstants.FROM_PAGE, ParamUtil.getString(request,TrademarksConstants.FROM_PAGE));
		portletURL.setParameter(LegalContractSearch.SEARCH_QUERY_PARAM, ParamUtil.getString(request,LegalContractSearch.SEARCH_QUERY_PARAM));
		return portletURL;
	}
	public Document getDocumentByPK(long id){
		Document doc = getDocumentByPK(id, themeDisplay.getUser().getCompanyId(), className);
		return doc;
	}
	public Document getLatestDocumentByRootId(long rootId,String rootField){
		Document doc = getLatestDocumentByRootId(rootId,  rootField,themeDisplay.getUser().getCompanyId(), className);
		return doc;
	}
	public static Document getDocumentByPK(long id,long companyId,String className){
		SearchContext searchContext = new SearchContext();
		searchContext.setStart(0);
		searchContext.setEnd(1);
		searchContext.setCompanyId(companyId);
		
		BooleanClause[] booleanClauses = new BooleanClause[1];
		booleanClauses[0] = getBC4ExactTerm(Field.ENTRY_CLASS_PK, String.valueOf(id), searchContext);
		searchContext.setBooleanClauses(booleanClauses);
		
		Indexer indexer = IndexerRegistryUtil
				.getIndexer(className);
		Hits results = null;
		try {
			results = indexer.search(searchContext);
		} catch (SearchException e) {
			_log.error(e.getMessage(), e);
		}
		Document doc = null;
		if (results != null) {
			int length = results.getDocs().length;
			if(length > 0){
				doc = results.doc(0);
			}
		}
		return doc;
	}
	public static Document getLatestDocumentByRootId(long rootId,String rootIdField,long companyId,String className){
		SearchContext searchContext = new SearchContext();
		searchContext.setStart(0);
		searchContext.setEnd(1);
		searchContext.setCompanyId(companyId);
		
		BooleanClause[] booleanClauses = new BooleanClause[2];
		booleanClauses[0] = getBC4ExactTerm(rootIdField, String.valueOf(rootId), searchContext);
		booleanClauses[1] = getBC4ExactTerm(AgencyConstants.LATEST, "true", searchContext);
		searchContext.setBooleanClauses(booleanClauses);
		
		Indexer indexer = IndexerRegistryUtil
				.getIndexer(className);
		Hits results = null;
		try {
			results = indexer.search(searchContext);
		} catch (SearchException e) {
			_log.error(e.getMessage(), e);
		}
		Document doc = null;
		if (results != null) {
			int length = results.getDocs().length;
			if(length > 0){
				doc = results.doc(0);
			}
		}
		return doc;
	}
	
	public static String getEscapedString(String str){
		return StringEscapeUtils.escapeHtml(GetterUtil.getString(str));
	}
	abstract List<SearchField>getSearchFields();
	public abstract SearchContainer getSearchContainer() throws WindowStateException, PortalException;

	public PortletRequest getRequest() {
		return request;
	}

	public void setRequest(PortletRequest request) {
		this.request = request;
	}

	public Map<String, String> getSearchParamMap() {
		return searchParamMap;
	}

	public void setSearchParamMap(Map<String, String> searchParamMap) {
		this.searchParamMap = searchParamMap;
	}
	
	/*public void setSearchParams(PortletURL actionUrl){
		if(Validator.isNotNull(actionUrl) && Validator.isNotNull(searchParamMap)){
			for (String key : searchParamMap.keySet()) {
				if (key.startsWith("searchParam_")) {
					String temp = response.getNamespace() + key.substring("searchParam_".length());
					actionUrl.setParameter(temp, searchParamMap.get(key));
				}
			}
		}
	}*/
	
	public void addSearchParams(PortletURL actionUrl){
		if(Validator.isNotNull(searchParamMap) && Validator.isNotNull(actionUrl)){
			for(String key:searchParamMap.keySet()){
				actionUrl.setParameter(key, searchParamMap.get(key));
			}
			actionUrl.setParameter("searchParam_"+LegalContractSearch.SEARCH_QUERY_PARAM, ParamUtil.getString(request,LegalContractSearch.SEARCH_QUERY_PARAM));
		}
	}
	
	public void copySearchParamsToResponse(){
		copySearchParamsToResponse(request,response);
	}
	public static void copySearchParamsToResponse(PortletRequest request, PortletResponse response){
		Map<String,String>requestMap = SambaashUtil.getParameterMap(request);
		
		if( !(response instanceof ActionResponse)){
			return;
		}
		for(String key :requestMap.keySet()){
			 if(key.startsWith("searchParam_")){
				 ((ActionResponse) response).setRenderParameter(key, requestMap.get(key));
			 }
		}
		String searchQuery = requestMap.get(LegalContractSearch.SEARCH_QUERY_PARAM);
		if(Validator.isNotNull(searchQuery)){
			((ActionResponse) response).setRenderParameter("searchParam_"+LegalContractSearch.SEARCH_QUERY_PARAM, searchQuery);
		}
	}
	
	public void setSearchContainerParamsToSearchParamMap(SearchContainer searchContainer){
		if(Validator.isNotNull(searchContainer)){
			setSearchParam(searchContainer.getCurParam(), String.valueOf(searchContainer.getCurValue()));
			setSearchParam(LegalContractSearch.DELTA, ParamUtil.getString(request,LegalContractSearch.DELTA));
			setSearchParam(LegalContractSearch.RESET_CUR, ParamUtil.getString(request,LegalContractSearch.RESET_CUR));
			setSearchParam(LegalContractSearch.SEARCH_QUERY_PARAM, ParamUtil.getString(request,LegalContractSearch.SEARCH_QUERY_PARAM));
			
		}
	}
}
