package com.sambaash.platform.portlet.legalandcontract.search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.PortletURL;
import javax.portlet.WindowState;
import javax.portlet.WindowStateException;

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
import com.sambaash.platform.constant.SambaashConstants;
import com.sambaash.platform.portlet.legalandcontract.permissions.LegalPermissionUtil;
import com.sambaash.platform.portlet.legalandcontract.util.ClassMasterConstants;
import com.sambaash.platform.portlet.legalandcontract.util.Utils;
import com.sambaash.platform.srv.legalandcontract.model.ClassMaster;
import com.sambaash.platform.util.SambaashUtil;

public class ClassSearch extends LegalContractSearch {

	private static List<SearchField> listFiellds;
	private static boolean initialized;
	private static Log _log = LogFactoryUtil.getLog(ClassSearch.class);

	public ClassSearch(PortletRequest request,PortletResponse response){
		super(request,response,ClassMaster.class.getName());
	}
	
	protected List<SearchField> getSearchFields(){
		if(!initialized){
			listFiellds = new ArrayList<SearchField>();
			
		/*	SearchField sf = new SearchField(ClassMasterConstants.CLASS_CODE_COLUMN,ClassMasterConstants.CLASS_CODE, ClassMasterConstants.CLASS_CODE,TEXT);
			listFiellds.add(sf);
			
			sf = new SearchField(ClassMasterConstants.COUNTRY_COLUMN,ClassMasterConstants.COUNTRY,ClassMasterConstants.COUNTRY,LIST,true,ClassMasterConstants.COUNTRY_VOC_ID);
			listFiellds.add(sf);
			
			sf = new SearchField(ClassMasterConstants.FILED_BY_COLUMN,ClassMasterConstants.FILED_BY,ClassMasterConstants.FILED_BY,TEXT);
			listFiellds.add(sf) ; */
			
			initialized = true;
		}
		
		return listFiellds;
		
	}
	
	public SearchContainer getSearchContainer() throws WindowStateException{
		boolean editPermission = false;
		try {
			LegalPermissionUtil.authorize(request,ClassMasterConstants.PORTLET_ID,
					ClassMasterConstants.ACTION_KEY_EDIT_CLASS);
			editPermission = true;
		} catch (Exception e) {
			_log.error(e);
		} 
		List<String> headerNames = new ArrayList<String>();
		headerNames.add("CLASS Code");
		headerNames.add("Country");
		headerNames.add("Version");
		headerNames.add("CLASS Description");
		headerNames.add("Filed By");
		headerNames.add("Custom Field 1");
		headerNames.add("Custom Field 2");
		headerNames.add("Custom Date 1");
		headerNames.add("Custom Date 2");
		headerNames.add("Custom List 1");
		headerNames.add("Custom List 2");
		if (editPermission) {
			headerNames.add("Edit Class Details");
		}
		headerNames.add("Class Details");
	
		PortletURL portletURL = getRenderUrl(ClassMasterConstants.PORTLET_ID);
		// create search container, used to display table
		SearchContainer searchContainer = new SearchContainer(request,
				null, null, SearchContainer.DEFAULT_CUR_PARAM,
				SearchContainer.DEFAULT_DELTA, portletURL, headerNames,
				"There are no Classes to display");
		portletURL.setParameter(searchContainer.getCurParam(),
				String.valueOf(searchContainer.getCurValue()));
		

		SearchContext searchContext = new SearchContext();
		searchContext.setStart(searchContainer.getStart());
		searchContext.setEnd(searchContainer.getEnd());
		searchContext.setCompanyId(themeDisplay.getUser().getCompanyId());
		//searchContext.setStart(0);
		//searchContext.setEnd(50);
		
		setSearchConditions(searchContext); 
		
		Sort sort = SortFactoryUtil.create(Field.MODIFIED_DATE, Sort.LONG_TYPE,true);
		Sort[] sorts = new Sort[] { sort };
		searchContext.setSorts(sorts);
		

		Indexer indexer = IndexerRegistryUtil.getIndexer(ClassMaster.class.getName());
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
			String description = "";
			String customList1CatName = "";
			String customList2CatName = "";
			long []catIds;
			long classPK;
			boolean isLatest = false;
			for (int i = 0; i < length; i++) {
				Document doc = results.doc(i);
				classPK = GetterUtil.getLong(doc.get(Field.ENTRY_CLASS_PK));
				catIds = Utils.getCategoryIds(doc,ClassMasterConstants.CATEGORIES_IDS_SIZE);
				catIds = reorderCategoryIds(request.getPreferences(), catIds);
				countryName = Utils.getCategoryName(catIds[0]);
				description = Utils.getCategoryName(catIds[1]);
				customList1CatName = Utils.getCategoryName(catIds[2]);
				customList2CatName = Utils.getCategoryName(catIds[3]);
				ResultRow row = new ResultRow(doc, classPK, i);
				row.addText(GetterUtil.getString(doc.get(ClassMasterConstants.CLASS_CODE)));
				row.addText(countryName);
				row.addText(GetterUtil.getString(doc.get(ClassMasterConstants.VERSION)));
				row.addText(description);
				row.addText(GetterUtil.getString(doc.get(ClassMasterConstants.FILED_BY)));
				row.addText(GetterUtil.getString(doc.get(ClassMasterConstants.CUSTOM_FIELD_1)));
				row.addText(GetterUtil.getString(doc.get(ClassMasterConstants.CUSTOM_FIELD_2)));
				row.addText(Utils.getDateStrYMD(doc, ClassMasterConstants.CUSTOM_DATE_1));
				row.addText(Utils.getDateStrYMD(doc, ClassMasterConstants.CUSTOM_DATE_2));
				row.addText(customList1CatName);
				row.addText(customList2CatName);
			
				isLatest = GetterUtil.getBoolean(doc.get(ClassMasterConstants.LATEST));
				if(editPermission && isLatest){
					actionUrl = PortletURLFactoryUtil.create(request, ClassMasterConstants.PORTLET_ID, themeDisplay.getPlid(), PortletRequest.ACTION_PHASE);   //renderResponse.createActionURL();
					actionUrl.setWindowState(WindowState.MAXIMIZED);
					actionUrl.setParameter(ClassMasterConstants.CLASS_ID, classPK + "");
					actionUrl.setParameter("javax.portlet.action","displayEditClass");
					row.addText("Edit", actionUrl.toString());
				}else{
					row.addText("    ");
				}

				actionUrl = PortletURLFactoryUtil.create(request, ClassMasterConstants.PORTLET_ID, themeDisplay.getPlid(), PortletRequest.ACTION_PHASE);   //renderResponse.createActionURL();
				actionUrl.setWindowState(WindowState.MAXIMIZED);
				actionUrl.setParameter(ClassMasterConstants.CLASS_ID, classPK + "");
				actionUrl.setParameter("javax.portlet.action","displayClassDetails");
				row.addText("Details", actionUrl.toString());
			
				resultRows.add(row);
			}
		} 
		
		return searchContainer;
	}
	
	public Map<String,String> getRootClasses4mIndexer(){
		Map<String,String> map = new LinkedHashMap<String,String>();
		SearchContext searchContext = new SearchContext();
		searchContext.setStart(-1);
		searchContext.setEnd(-1);
		searchContext.setCompanyId(themeDisplay.getUser().getCompanyId());
		
		Sort sort = SortFactoryUtil.create(Field.MODIFIED_DATE, Sort.LONG_TYPE,
				true);
		Sort[] sorts = new Sort[] { sort };
		searchContext.setSorts(sorts);
		BooleanClause[] booleanClauses = new BooleanClause[1];
		booleanClauses[0] = getBC4ExactTerm(ClassMasterConstants.VERSION, ClassMasterConstants.START_VERSION, searchContext);
		searchContext.setBooleanClauses(booleanClauses);

		Indexer indexer = IndexerRegistryUtil
				.getIndexer(ClassMaster.class.getName());
		Hits results = null;
		try {
			results = indexer.search(searchContext);
		} catch (SearchException e) {
			_log.error(e.getMessage(), e);
		}
		if (results != null) {
			int length = results.getDocs().length;
			String countryNam = "";
			String code;
			boolean isLatest = false;
			for (int i = 0; i < length; i++) {
				Document doc = results.doc(i);
				String rootClassId = doc.get(ClassMasterConstants.ROOT_CLASS_ID);
				code = GetterUtil.getString(doc.get(ClassMasterConstants.CLASS_CODE));
				countryNam = GetterUtil.getString(doc.get(ClassMasterConstants.COUNTRY));
				map.put(rootClassId,String.format(CODE_COUNTRY_FORMAT,code,countryNam));
			/*	isLatest = GetterUtil.getBoolean(doc.get(ClassMasterConstants.LATEST));
				String rootClassId = doc.get(ClassMasterConstants.ROOT_CLASS_ID);
				if(isLatest && !Utils.nullOrEmpty(rootClassId)) {
				    code = GetterUtil.getString(doc.get(ClassMasterConstants.CLASS_CODE));
				    countryNam = GetterUtil.getString(doc.get(ClassMasterConstants.COUNTRY));
					map.put(rootClassId,String.format(CODE_COUNTRY_FORMAT,code,countryNam));
				} */
			}
		}
		
		return map;
	}
	
	public static final String CODE_COUNTRY_FORMAT = " %s / %s ";
		
	public static long[] reorderCategoryIds(PortletPreferences preferences,long[] categoryIds){

		String []vocIdFields = new String[ClassMasterConstants.CATEGORIES_IDS_SIZE];
		vocIdFields[0] = ClassMasterConstants.COUNTRY_VOC_ID;
		vocIdFields[1] = ClassMasterConstants.DESCRIPTION_VOC_ID;
		vocIdFields[2] = ClassMasterConstants.CUSTOM_LIST_1_VOC_ID;
		vocIdFields[3] = ClassMasterConstants.CUSTOM_LIST_2_VOC_ID;
		
		return Utils.reorderCategoryIds(preferences, vocIdFields, categoryIds);
	}
	public static long[] reorderCategoryIds(long[] categoryIds){
		long []vocIds = new long[ClassMasterConstants.CATEGORIES_IDS_SIZE];
		vocIds[0] = GetterUtil.getLong(SambaashUtil.getParameter(SambaashConstants.CLASS_COUNTRY_VOC_ID, 0));
		vocIds[1] = GetterUtil.getLong(SambaashUtil.getParameter(SambaashConstants.CLASS_DESCRIPTION_VOC_ID, 0));
		vocIds[2] = GetterUtil.getLong(SambaashUtil.getParameter(SambaashConstants.CLASS_CUSTOM_LIST_1_VOC_ID, 0));
		vocIds[3] = GetterUtil.getLong(SambaashUtil.getParameter(SambaashConstants.CLASS_CUSTOM_LIST_2_VOC_ID, 0));
		
		return Utils.reorderCategoryIds(vocIds, categoryIds);
	}
	
	public String getClassCodeCountry(String classId){
		String result = StringPool.BLANK;
		try{
			result = getClassCodeCountry(Long.parseLong(classId));
		}catch(Exception e){
			
		}
		return result;
	}
	public String getClassCodeCountry(long classId){
		String result = StringPool.BLANK;
		Document doc = getDocumentByPK(classId);
		String name = GetterUtil.getString(doc.get(ClassMasterConstants.CLASS_CODE));
		String countryNam = GetterUtil.getString(doc.get(ClassMasterConstants.COUNTRY));
		result = String.format(CODE_COUNTRY_FORMAT,countryNam,name);
		return result;
	}
	
	private Map<String,String> getClassMap(Document doc){
		Map<String,String> map = new HashMap<String,String>();
		if(Validator.isNotNull(doc)){
			try{
				long[] catIds = Utils.getCategoryIds(doc,ClassMasterConstants.CATEGORIES_IDS_SIZE);
				catIds = reorderCategoryIds(catIds);
				String countryName = Utils.getCategoryName(catIds[0]);
				String description = Utils.getCategoryName(catIds[1]);
				String customList1CatName = Utils.getCategoryName(catIds[2]);
				String customList2CatName = Utils.getCategoryName(catIds[3]);
				map.put(ClassMasterConstants.CLASS_ID,GetterUtil.getString(doc.get(Field.ENTRY_CLASS_PK)));
				map.put(ClassMasterConstants.CLASS_CODE,GetterUtil.getString(doc.get(ClassMasterConstants.CLASS_CODE)));
				map.put(ClassMasterConstants.COUNTRY,countryName);
				map.put(ClassMasterConstants.VERSION,GetterUtil.getString(doc.get(ClassMasterConstants.VERSION)));
				map.put(ClassMasterConstants.DESCRIPTION,description);
				map.put(ClassMasterConstants.FILED_BY,GetterUtil.getString(doc.get(ClassMasterConstants.FILED_BY)));
				map.put(ClassMasterConstants.CUSTOM_FIELD_1,GetterUtil.getString(doc.get(ClassMasterConstants.CUSTOM_FIELD_1)));
				map.put(ClassMasterConstants.CUSTOM_FIELD_2,GetterUtil.getString(doc.get(ClassMasterConstants.CUSTOM_FIELD_2)));
				map.put(ClassMasterConstants.CUSTOM_DATE_1,Utils.getDateStrYMD(doc, ClassMasterConstants.CUSTOM_DATE_1));
				map.put(ClassMasterConstants.CUSTOM_DATE_2,Utils.getDateStrYMD(doc, ClassMasterConstants.CUSTOM_DATE_2));
				map.put(ClassMasterConstants.CUSTOM_LIST_1,customList1CatName);
				map.put(ClassMasterConstants.CUSTOM_LIST_2,customList2CatName);
			}catch(Exception ex){
				
			}
			
		}
		return map;
	}
	public  Map<String,String> getClassMap(long classId){
		Document doc = getDocumentByPK(classId);
		Map<String,String> map = getClassMap(doc);
		return map;
	}
	public  Map<String,String> getClassMap(String classId){
		return getClassMap(GetterUtil.getLong(classId));
	}
	public  Map<String,String> getLatestClassByRootClassId(long rootClassId){
		 Document doc = getLatestDocumentByRootId(rootClassId,ClassMasterConstants.ROOT_CLASS_ID);
		 Map<String,String> map = getClassMap(doc);
		 return map;
	}
	public  Map<String,String> getLatestClassByRootClassId(String rootClassId){
		return getLatestClassByRootClassId(GetterUtil.getLong(rootClassId));
	}
	public  String getLatestClassIdByRootClassId(String rootClassId){
		Map<String,String> map = getLatestClassByRootClassId(GetterUtil.getLong(rootClassId));
		return map.get(ClassMasterConstants.CLASS_ID);
	}
}
