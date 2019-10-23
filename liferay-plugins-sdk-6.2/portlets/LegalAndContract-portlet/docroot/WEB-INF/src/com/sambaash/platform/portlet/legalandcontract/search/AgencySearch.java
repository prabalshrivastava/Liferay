package com.sambaash.platform.portlet.legalandcontract.search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.PortletURL;
import javax.portlet.WindowState;
import javax.portlet.WindowStateException;

import org.apache.commons.lang.WordUtils;

import com.liferay.portal.kernel.dao.search.ResultRow;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.BooleanClause;
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
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portlet.PortletURLFactoryUtil;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil;
import com.sambaash.platform.constant.SambaashConstants;
import com.sambaash.platform.portlet.legalandcontract.permissions.LegalPermissionUtil;
import com.sambaash.platform.portlet.legalandcontract.util.AgencyConstants;
import com.sambaash.platform.portlet.legalandcontract.util.LegalConstants;
import com.sambaash.platform.portlet.legalandcontract.util.Utils;
import com.sambaash.platform.srv.legalandcontract.model.Agency;
import com.sambaash.platform.srv.legalandcontract.service.AgencyLocalServiceUtil;
import com.sambaash.platform.util.SambaashUtil;

public class AgencySearch extends LegalContractSearch {

	private static List<SearchField> listFiellds;
	private static boolean initialized;
	private static Log _log = LogFactoryUtil.getLog(AgencySearch.class);

	public static final String COUNTRY_NAME_FORMAT = " %s / %s ";
	
	public AgencySearch(PortletRequest request,PortletResponse response){
		super(request,response ,Agency.class.getName());
	}
	
	protected List<SearchField> getSearchFields(){
		if(!initialized){
			listFiellds = new ArrayList<SearchField>();
			
			SearchField sf = SearchFieldFactory.getSearchFieldText(AgencyConstants.ALL_SEARCH_COLUMN,AgencyConstants.ALL_SEARCH, AgencyConstants.ALL_SEARCH);
			listFiellds.add(sf);
			
			sf = SearchFieldFactory.getSearchFieldText(AgencyConstants.NUMBER_COLUMN,AgencyConstants.NUMBER, AgencyConstants.NUMBER);
			listFiellds.add(sf);

			sf = SearchFieldFactory.getSearchFieldText(AgencyConstants.NAME_COLUMN,AgencyConstants.NAME, AgencyConstants.NAME);
			listFiellds.add(sf);
			
			sf = SearchFieldFactory.getSearchFieldText(AgencyConstants.REFERENCE_COLUMN,AgencyConstants.REFERENCE, AgencyConstants.REFERENCE);
			listFiellds.add(sf);
			
			sf = SearchFieldFactory.getSearchFieldCategory(AgencyConstants.COUNTRY_COLUMN,AgencyConstants.COUNTRY,AgencyConstants.COUNTRY,AgencyConstants.COUNTRY_VOC_ID);
			listFiellds.add(sf);

			sf = SearchFieldFactory.getSearchFieldCategory(AgencyConstants.TYPE_COLUMN,AgencyConstants.TYPE,AgencyConstants.TYPE,AgencyConstants.TYPE_VOC_ID);
			listFiellds.add(sf);
			
			sf = SearchFieldFactory.getSearchFieldText(AgencyConstants.STATUS_COLUMN,AgencyConstants.STATUS, AgencyConstants.STATUS);
			listFiellds.add(sf);
			
			sf = SearchFieldFactory.getSearchField(AgencyConstants.AGENCY_HISTORY_LABEL,AgencyConstants.AGENCY_HISTORY,SearchField.DROPDOWN);
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
		Sort sort1 = SortFactoryUtil.create(AgencyConstants.COUNTRY, Sort.STRING_TYPE, false);
		Sort[] sorts = new Sort[] { sort,sort1 };
		searchContext.setSorts(sorts);
		return searchContext;
	}
	
	public static Hits searchAgencies(SearchContext searchContext){
		Indexer indexer = IndexerRegistryUtil
				.getIndexer(Agency.class.getName());
		Hits results = null;
		try {
			results = indexer.search(searchContext);
		} catch (SearchException e) {
			_log.error(e.getMessage(), e);
		}
		return results;
	}
	
	public List<Document> getAgencies(){
		SearchContext searchContext = getDefaultSearchContext();
		setup();
		setSearchConditions(searchContext);
		Hits results = searchAgencies(searchContext);
		List<Document> list = new ArrayList<Document>();
		if (Validator.isNotNull(results)) {
			int length = results.getDocs().length;
			for (int i = 0; i < length; i++) {
				Document doc = results.doc(i);
				list.add(doc);
			}
		}
		return list;
	}
	
	public SearchContainer getSearchContainer() throws WindowStateException{
		boolean editPermission = false;
		try {
			LegalPermissionUtil.authorize(request,AgencyConstants.PORTLET_ID,
					AgencyConstants.ACTION_KEY_EDIT_AGENCY);
			editPermission = true;
		} catch (Exception e) {
			_log.error(e);
		}

		PortletURL portletURL = getRenderUrl(AgencyConstants.PORTLET_ID);

		List<String> headerNames = new ArrayList<String>();
		headerNames.add(AgencyConstants.NUMBER_COLUMN);
		headerNames.add(AgencyConstants.NAME_COLUMN);
		headerNames.add(AgencyConstants.COUNTRY_COLUMN);
		headerNames.add(AgencyConstants.REFERENCE_COLUMN);
		headerNames.add(AgencyConstants.START_DATE_COLUMN);
		headerNames.add(AgencyConstants.END_DATE_COLUMN);
		headerNames.add(AgencyConstants.TYPE_COLUMN);
		headerNames.add(AgencyConstants.ADDRESS_COLUMN);
		//headerNames.add("Remarks");
		headerNames.add(AgencyConstants.STATUS_COLUMN);
		headerNames.add(WordUtils.capitalize(LegalConstants.VERSION));
		
		if (editPermission) {
			headerNames.add("Edit");
		}

		headerNames.add("Details");
		// create search container, used to display table
		SearchContainer searchContainer = new SearchContainer(request,
				null, null, SearchContainer.DEFAULT_CUR_PARAM,
				SearchContainer.DEFAULT_DELTA, portletURL, headerNames,
				"There are no Law Firms to display");
		portletURL.setParameter(searchContainer.getCurParam(),
				String.valueOf(searchContainer.getCurValue()));
		// Fill searchparammap to retain the search criteria
		setSearchContainerParamsToSearchParamMap(searchContainer);

		SearchContext searchContext = new SearchContext();
		searchContext.setStart(searchContainer.getStart());
		searchContext.setEnd(searchContainer.getEnd());
		setSearchConditions(searchContext);
		searchContext.setCompanyId(themeDisplay.getUser().getCompanyId());
		
		Sort sort = SortFactoryUtil.create(LegalConstants.SORT_FIELD, Sort.STRING_TYPE, false);
		Sort sort1 = SortFactoryUtil.create(AgencyConstants.COUNTRY, Sort.STRING_TYPE, false);
		Sort[] sorts = new Sort[] { sort,sort1 };
		searchContext.setSorts(sorts);

		Indexer indexer = IndexerRegistryUtil
				.getIndexer(Agency.class.getName());
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
			String countryNam = "";
			String type = "";
		//	long catIds[];
			List<Long>catIds;
			boolean isLatest = false;
			long countryVocId = GetterUtil.getLong(preferences.getValue(AgencyConstants.COUNTRY_VOC_ID,"0"));
			for (int i = 0; i < length; i++) {
				Document doc = results.doc(i);
				long classPK = GetterUtil.getLong(doc.get(Field.ENTRY_CLASS_PK));
				String name = getEscapedString(doc.get(Field.NAME));
				catIds = Utils.getCategoryIds(doc);   
				countryNam = Utils.getCategoryName(preferences,AgencyConstants.COUNTRY_VOC_ID,catIds);
				type = Utils.getCategoryName(preferences,AgencyConstants.TYPE_VOC_ID,catIds);
				ResultRow row = new ResultRow(doc, classPK, i);
				row.addText(getEscapedString(doc.get(AgencyConstants.NUMBER)));
				row.addText(name);
				row.addText(countryNam);
				row.addText(getEscapedString(doc.get(AgencyConstants.REFERENCE)));
				row.addText(getEscapedString(doc.get(AgencyConstants.START_DATE)));
				row.addText(getEscapedString(doc.get(AgencyConstants.END_DATE)));
				row.addText(type);
				row.addText(Utils.toHtmlTags(doc.get(AgencyConstants.ADDRESS)));
				//row.addText(getEscapedString(doc.get(Field.COMMENTS)));
				row.addText(getEscapedString(doc.get(Field.STATUS)));
				
				row.addText(getEscapedString(doc.get(LegalConstants.VERSION)));
				isLatest = GetterUtil.getBoolean(doc.get(AgencyConstants.LATEST));
				if(editPermission){
					if (isLatest) {
						boolean canEdit = Utils.checkUserPermissionOnCountry(request,countryVocId, countryNam);
						if(canEdit){
							actionUrl = PortletURLFactoryUtil.create(request, AgencyConstants.PORTLET_ID, themeDisplay.getPlid(), PortletRequest.ACTION_PHASE);   //renderResponse.createActionURL();
							actionUrl.setWindowState(WindowState.MAXIMIZED);
							actionUrl.setParameter(AgencyConstants.AGENCY_ID, String.valueOf(classPK) );
							actionUrl.setParameter("javax.portlet.action",
									"displayEditAgency");
							addSearchParams(actionUrl);
							row.addText("Edit", actionUrl.toString());
						}else{
							row.addText("      ");
						}
					}else{
						row.addText("      ");
					}
				}
				actionUrl = PortletURLFactoryUtil.create(request, AgencyConstants.PORTLET_ID, themeDisplay.getPlid(), PortletRequest.ACTION_PHASE);   //renderResponse.createActionURL();
				actionUrl.setWindowState(WindowState.MAXIMIZED);
				actionUrl.setParameter(AgencyConstants.AGENCY_ID, String.valueOf(classPK) );
				actionUrl.setParameter("javax.portlet.action",
						"displayAgencyDetails");
				addSearchParams(actionUrl);
				row.addText("Details", actionUrl.toString());
				resultRows.add(row);
			}
		}
		return searchContainer;
		
	}
	
	protected BooleanClause getSearchCondition(SearchContext searchContext,String searchField, String searchFieldValue,String from,String to) {
		BooleanClause bc = null;

		if(AgencyConstants.AGENCY_HISTORY.equals(searchField)){
			if(LegalConstants.SEARCH_AUDIT_HISTORY.equals(searchFieldValue)){
				this.showLatestOnly = false;
			}
		}else{
			bc = super.getSearchCondition(searchContext, searchField, searchFieldValue, from, to);
		}
	
		return bc;
	}
	
/*	public static long[] reorderCategoryIds(PortletPreferences preferences,long[] categoryIds){
		String[] temp = new String[AgencyConstants.CATEGORIES_IDS_SIZE];
		temp[0] = AgencyConstants.COUNTRY_VOC_ID;
		temp[1] = AgencyConstants.TYPE_VOC_ID;
		temp[2] = AgencyConstants.CUSTOM_LIST_1_VOC_ID;
		temp[3] = AgencyConstants.CUSTOM_LIST_2_VOC_ID;
		temp[4] = AgencyConstants.CUSTOM_LIST_3_VOC_ID;
		
		return Utils.reorderCategoryIds(preferences, temp, categoryIds);
	} */

	
	public Map<String,String> geRootAgencies4mIndexer(){
		Map<String,String> map = new LinkedHashMap<String,String>();
		SearchContext searchContext = getDefaultSearchContext();
		
		BooleanClause[] booleanClauses = new BooleanClause[1];
		booleanClauses[0] = getBC4ExactTerm(LegalConstants.VERSION, AgencyConstants.START_VERSION, searchContext);
		searchContext.setBooleanClauses(booleanClauses);

		Indexer indexer = IndexerRegistryUtil
				.getIndexer(Agency.class.getName());
		Hits results = null;
		try {
			results = indexer.search(searchContext);
		} catch (SearchException e) {
			_log.error(e.getMessage(), e);
		}
		if (results != null) {
			int length = results.getDocs().length;
			String countryNam = "";
			String name;
			String rootAgencyId;
			boolean isLatest = false;
			for (int i = 0; i < length; i++) {
				Document rootDoc = results.doc(i);
				rootAgencyId = rootDoc.get(AgencyConstants.ROOT_AGENCY_ID);
				Map<String,String> latest = getLatestAgencyByRootAgencyId(rootAgencyId,false);
				
				if(Validator.isNotNull(latest)){
					name = GetterUtil.getString(latest.get(Field.NAME));
					countryNam = GetterUtil.getString(latest.get(AgencyConstants.COUNTRY));
				}else{
					// Usually below won't be executed. But safer side written
					name = GetterUtil.getString(rootDoc.get(Field.NAME));
					countryNam = GetterUtil.getString(rootDoc.get(AgencyConstants.COUNTRY));
				}
				
				
				map.put(rootAgencyId,String.format(COUNTRY_NAME_FORMAT,countryNam,name));
			/*	isLatest = GetterUtil.getBoolean(doc.get(AgencyConstants.LATEST));

				if(isLatest && !Utils.nullOrEmpty(rootAgencyId)) {
					name = GetterUtil.getString(doc.get(Field.NAME));
					countryNam = GetterUtil.getString(doc.get(AgencyConstants.COUNTRY));
					map.put(rootAgencyId,String.format(COUNTRY_NAME_FORMAT,countryNam,name));
				} */
			}
		}
		
		return map;
	}
	public String getAgencyCountryName(String agencyId){
		String result = StringPool.BLANK;
		try{
			result = getAgencyCountryName(Long.parseLong(agencyId));
		}catch(Exception e){
			
		}
		return result;
	}
	public String getAgencyCountryName(long agencyId){
		String result = StringPool.BLANK;
		Document doc = getDocumentByPK(agencyId);
		if(Validator.isNotNull(doc)){
			String name = GetterUtil.getString(doc.get(Field.NAME));
			String countryNam = GetterUtil.getString(doc.get(AgencyConstants.COUNTRY));
			result = String.format(COUNTRY_NAME_FORMAT,countryNam,name);
		}
		return result;
	}
	
	private Map<String,String> getAgencyMap(Document doc,boolean convertNlToBr){
		Map<String,String> map = new HashMap<String,String>();
		if(Validator.isNotNull(doc)){
			try{
				List<Long> catIds = Utils.getCategoryIds(doc);
				long countryVocId = GetterUtil.getLong(SambaashUtil.getParameter(SambaashConstants.AGENCY_COUNTRY_VOC_ID, 0));
				long typeVocId= GetterUtil.getLong(SambaashUtil.getParameter(SambaashConstants.AGENCY_TYPE_VOC_ID, 0));
	/*			long cList1VocId = GetterUtil.getLong(SambaashUtil.getParameter(SambaashConstants.AGENCY_CUSTOM_LIST_1_VOC_ID, 0));
				long cList2VocId = GetterUtil.getLong(SambaashUtil.getParameter(SambaashConstants.AGENCY_CUSTOM_LIST_2_VOC_ID, 0));
				long cList3VocId = GetterUtil.getLong(SambaashUtil.getParameter(SambaashConstants.AGENCY_CUSTOM_LIST_3_VOC_ID, 0));*/
				String	countryNam = Utils.getCategoryName(countryVocId,catIds);
				String	type = Utils.getCategoryName(typeVocId,catIds);
		/*		String customList1CatName = Utils.getCategoryName( cList1VocId,catIds);
				String customList2CatName = Utils.getCategoryName( cList2VocId,catIds);
				String customList3CatName = Utils.getCategoryName( cList3VocId,catIds); */
				
				if(convertNlToBr){
					map.put(AgencyConstants.ADDRESS,Utils.toHtmlTags(doc.get(AgencyConstants.ADDRESS)));
					map.put(AgencyConstants.REMARKS,Utils.toHtmlTags(doc.get(AgencyConstants.REMARKS)));
				}else{
					map.put(AgencyConstants.ADDRESS,GetterUtil.getString(doc.get(AgencyConstants.ADDRESS)));
					map.put(AgencyConstants.REMARKS,GetterUtil.getString(doc.get(AgencyConstants.REMARKS)));	
				}
				String name = GetterUtil.getString(doc.get(Field.NAME));
				map.put(AgencyConstants.AGENCY_ID,GetterUtil.getString(doc.get(Field.ENTRY_CLASS_PK)));
				map.put(AgencyConstants.NUMBER, GetterUtil.getString(doc.get(AgencyConstants.NUMBER)));
				map.put(AgencyConstants.NAME,name);
				map.put(AgencyConstants.COUNTRY,countryNam);
				map.put(LegalConstants.VERSION,GetterUtil.getString(doc.get(LegalConstants.VERSION)));
				map.put(AgencyConstants.REFERENCE,GetterUtil.getString(doc.get(AgencyConstants.REFERENCE)));
				map.put(AgencyConstants.START_DATE,GetterUtil.getString(doc,AgencyConstants.START_DATE));
				map.put(AgencyConstants.END_DATE,GetterUtil.getString(doc,AgencyConstants.END_DATE));
				map.put(AgencyConstants.TYPE,type);
				
				map.put(AgencyConstants.STATUS,GetterUtil.getString(doc.get(AgencyConstants.STATUS)));
			/*	map.put(AgencyConstants.CUSTOM_FIELD_1,GetterUtil.getString(doc.get(AgencyConstants.CUSTOM_FIELD_1)));
				map.put(AgencyConstants.CUSTOM_FIELD_2,GetterUtil.getString(doc.get(AgencyConstants.CUSTOM_FIELD_2)));
				map.put(AgencyConstants.CUSTOM_FIELD_3,GetterUtil.getString(doc.get(AgencyConstants.CUSTOM_FIELD_3)));
				map.put(AgencyConstants.CUSTOM_DATE_1,Utils.getDateStrYMD(doc, AgencyConstants.CUSTOM_DATE_1));
				map.put(AgencyConstants.CUSTOM_DATE_2,Utils.getDateStrYMD(doc, AgencyConstants.CUSTOM_DATE_2));
				map.put(AgencyConstants.CUSTOM_DATE_3,Utils.getDateStrYMD(doc, AgencyConstants.CUSTOM_DATE_3));
				map.put(AgencyConstants.CUSTOM_LIST_1,customList1CatName);
				map.put(AgencyConstants.CUSTOM_LIST_2,customList2CatName);
				map.put(AgencyConstants.CUSTOM_LIST_3,customList3CatName); */
				map.put(AgencyConstants.LATEST, GetterUtil.getString(doc.get(AgencyConstants.LATEST)));
			}catch(Exception ex){
				
			}
			
		}
		return map;
	}
	public Map<String,String> getAgencyMap(Agency agency, boolean convertNlToBr){
		Map<String,String> map = new HashMap<String,String>();
		if(Validator.isNotNull(agency)){
			try{
				
				//AssetEntry assetEntry = AssetEntryLocalServiceUtil.fetchEntry(
						//Agency.class.getName(), agency.getSpAgencyId());
				List<Long> catIds = Utils.getAssetCategoryIds(Agency.class.getName(), agency.getSpAgencyId());//Utils.getLongList(assetEntry.getCategoryIds());
				long countryVocId = GetterUtil.getLong(SambaashUtil.getParameter(SambaashConstants.AGENCY_COUNTRY_VOC_ID, 0));
				long typeVocId= GetterUtil.getLong(SambaashUtil.getParameter(SambaashConstants.AGENCY_TYPE_VOC_ID, 0));
				/*long cList1VocId = GetterUtil.getLong(SambaashUtil.getParameter(SambaashConstants.AGENCY_CUSTOM_LIST_1_VOC_ID, 0));
				long cList2VocId = GetterUtil.getLong(SambaashUtil.getParameter(SambaashConstants.AGENCY_CUSTOM_LIST_2_VOC_ID, 0));
				long cList3VocId = GetterUtil.getLong(SambaashUtil.getParameter(SambaashConstants.AGENCY_CUSTOM_LIST_3_VOC_ID, 0)); */
				
				if(convertNlToBr){
					map.put(AgencyConstants.ADDRESS,Utils.toHtmlTags(agency.getAddress()));
					map.put(AgencyConstants.REMARKS,Utils.toHtmlTags(agency.getRemarks()));
				}else{
					map.put(AgencyConstants.ADDRESS,GetterUtil.getString(agency.getAddress()));
					map.put(AgencyConstants.REMARKS,GetterUtil.getString(agency.getRemarks()));	
				}
				
				String	countryNam = Utils.getCategoryName(countryVocId,catIds);
				String	type = Utils.getCategoryName(typeVocId,catIds);
				/*String customList1CatName = Utils.getCategoryName( cList1VocId,catIds);
				String customList2CatName = Utils.getCategoryName( cList2VocId,catIds);
				String customList3CatName = Utils.getCategoryName( cList3VocId,catIds);*/
				
				String name = GetterUtil.getString(agency.getName());
				map.put(AgencyConstants.AGENCY_ID, String.valueOf(agency.getSpAgencyId()));
				map.put(AgencyConstants.NUMBER, GetterUtil.getString(agency.getNumber()));
				map.put(AgencyConstants.NAME,name);
				map.put(AgencyConstants.COUNTRY,countryNam);
				map.put(LegalConstants.VERSION,GetterUtil.getString(agency.getVersion()));
				map.put(AgencyConstants.REFERENCE,GetterUtil.getString(agency.getReference()));
				map.put(AgencyConstants.START_DATE,agency.getStartDate());
				map.put(AgencyConstants.END_DATE,  agency.getEndDate());
				map.put(AgencyConstants.TYPE,type);
				map.put(AgencyConstants.STATUS,GetterUtil.getString(agency.getStatus()));
				/*map.put(AgencyConstants.CUSTOM_FIELD_1,GetterUtil.getString(agency.getCustomField1()));
				map.put(AgencyConstants.CUSTOM_FIELD_2,GetterUtil.getString(agency.getCustomField2()));
				map.put(AgencyConstants.CUSTOM_FIELD_3,GetterUtil.getString(agency.getCustomField3()));
				map.put(AgencyConstants.CUSTOM_DATE_1,Utils.getDateStrYMD(agency.getCustomDate1()));
				map.put(AgencyConstants.CUSTOM_DATE_2,Utils.getDateStrYMD(agency.getCustomDate2()));
				map.put(AgencyConstants.CUSTOM_DATE_3,Utils.getDateStrYMD(agency.getCustomDate3()));
				map.put(AgencyConstants.CUSTOM_LIST_1,customList1CatName);
				map.put(AgencyConstants.CUSTOM_LIST_2,customList2CatName);
				map.put(AgencyConstants.CUSTOM_LIST_3,customList3CatName);*/
				map.put(AgencyConstants.UPDATE_BY, agency.getUserName());
				map.put(AgencyConstants.MODIFIED_DATE, Utils.getDateTime(agency.getModifiedDate()));
				map.put(AgencyConstants.LATEST, String.valueOf(isAgencyLatest(agency)));
			}catch(Exception ex){
				
			}
			
		}
		return map;
	}
	public static boolean isAgencyLatest(Agency agency){
		boolean isLatest = true;
		List<Object[]> agencyIdList = AgencyLocalServiceUtil.getLatestAgencyIdAndVersionNumber(agency.getNumber(), agency.getCountry());
		if (agencyIdList.size() > 0) {
			Object[] agencyIdArr = ((Object[]) agencyIdList.get(0));

			if (((Long) agencyIdArr[1]).compareTo(agency.getSpAgencyId()) == 0) {
			//	document.addKeyword(AgencyConstants.LATEST, true);
				isLatest = true;
			}else{
				//document.addKeyword(AgencyConstants.LATEST, false);
				isLatest = false;
			}
		}
		return isLatest;
	}
	public  Map<String,String> getAgencyMap(long agencyId,boolean convertNlToBr){
		Document doc = getDocumentByPK(agencyId);
		Map<String,String> map = getAgencyMap(doc, convertNlToBr);
		return map;
	}
	public  Map<String,String> getAgencyMap(String agencyId,boolean convertNlToBr){
		return getAgencyMap(GetterUtil.getLong(agencyId), convertNlToBr);
	}
	public  Map<String,String> getLatestAgencyByRootAgencyId(long rootAgencyId, boolean convertNlToBr){
		 Document doc = getLatestDocumentByRootId(rootAgencyId,AgencyConstants.ROOT_AGENCY_ID);
		 Map<String,String> map = getAgencyMap(doc,convertNlToBr);
		 return map;
	}
	public  Map<String,String> getLatestAgencyByRootAgencyId(String rootAgencyId,boolean convertNlToBr){
		return getLatestAgencyByRootAgencyId(GetterUtil.getLong(rootAgencyId), convertNlToBr);
	}
	public  String getLatestAgencyIdByRootAgencyId(String rootAgencyId,boolean convertNlToBr){
		Map<String,String> map = getLatestAgencyByRootAgencyId(GetterUtil.getLong(rootAgencyId),convertNlToBr);
		String latestAgencyId = map.get(AgencyConstants.AGENCY_ID);
		return latestAgencyId;
	}
	
	public static String getAgencyFolderName(String rootAgencyId ){
		_log.error("Getting Folder Name for " + rootAgencyId);
		String folderName = String.format(AgencyConstants.AGENCY_FOLDER_NAME_FORMAT, rootAgencyId);
		_log.error("Folder Name  " + folderName);
		return folderName;
	}
	public static String getAgencyFolderName(long rootAgencyId ){
		return getAgencyFolderName(String.valueOf(rootAgencyId));
	}
}
