package com.sambaash.platform.portlet.lf.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil;

public class FiltersRenderHelper {
	
	private static String NAME_KEY = "name";
	private static String TYPE_KEY = "type";
	private static String CATEGORY_KEY = "category";
	private static String CATEGORIES_KEY = "categories";
	private static String DISPLAY_HEADER_KEY = "displayHeader";
	private static String FILTERDATA_KEY = "filterData";
	
	private static String SINGLE_FILTER_TYPE = "single";
	private static String MULTIPL_FILTER_TYPE = "multiple";
	private static String LINKED_CATEGORY = "linked";
	private static String IVD_CATEGORY = "individual";
	
	private static Log _log = LogFactoryUtil.getLog(FiltersRenderHelper.class);
	
	public static void loadLinkedFilters(PortletRequest request,JSONObject data){
		String []strCatIds = ParamUtil.getString(request,"catgIds").split(StringPool.COMMA);
		PortletPreferences prefs = request.getPreferences();
		// ancesotr path of one category
		List<Long>idsTillRoot = null;
		// it can hold multiple paths to ancestors. Each list item represents ancestor path of category.  
		List<List<Long>>lists = new ArrayList<List<Long>>();
		
		// holds resulting filters
		JSONArray array = JSONFactoryUtil.createJSONArray();
		StringBuilder allCatIdsTillRoot = new StringBuilder();
		
		// findins ancestors of each catid. 
		for(int i = 0 ; i < strCatIds.length; i++){
			long catId = GetterUtil.getLong(strCatIds[i]);
			if(catId == 0){
				continue;
			}
			idsTillRoot = new ArrayList<Long>();
			try {
				ancestors(catId, idsTillRoot,allCatIdsTillRoot);
				
			} catch (PortalException | SystemException e) {
				_log.error(e);
			}
		//	allCatIdsTillRoot = allCatIdsTillRoot + StringPool.COMMA + idsTillRoot;

			// to make sure all list sizes are same. taking first list as basis
			if(lists.size() > 0){
				int baseSize = lists.get(0).size();
				if(baseSize == idsTillRoot.size()){
					lists.add(idsTillRoot);
				}
			}else{
				lists.add(idsTillRoot);
			}
		}
		
		if(lists.size() > 0){
			int columnSize = lists.get(0).size(); //fixing column size as first path
			String catIds = StringPool.BLANK;
			for(int i = 0 ; i < columnSize; i++){
				catIds = StringPool.BLANK;
				for(int j = 0 ; j < lists.size() ; j++){
					catIds = catIds + StringPool.COMMA + lists.get(j).get(i);
				}
				try {
					if(Validator.isNotNull(catIds)){
						array.put(prepareChildCategories(catIds, i+1, request));
					}
				} catch (SystemException e) {
					_log.error(e);
				}
			}
		}
		
		data.put("linkedCatIds",  allCatIdsTillRoot.toString()); 
		data.put("sublevelFilters",  array); 
	}
	private static void ancestors(long catId, List<Long>idsTillRoot,StringBuilder allCatIdsTillRoot) throws PortalException, SystemException{
		AssetCategory catg = AssetCategoryLocalServiceUtil.getAssetCategory(catId);
		if(catg.getParentCategoryId() == 0){
			idsTillRoot.add(catId);
			allCatIdsTillRoot.append(catId);
			allCatIdsTillRoot.append(StringPool.COMMA);
			return;
		}
		ancestors(catg.getParentCategoryId(), idsTillRoot,allCatIdsTillRoot);
		idsTillRoot.add(catId);
		allCatIdsTillRoot.append(catId);
		allCatIdsTillRoot.append(StringPool.COMMA);
	}
	public static void loadFirstLevelFilter(JSONObject data,PortletPreferences prefs) {
		try {
			data.put(FILTERDATA_KEY, loadFirstLevelFilter(prefs));
		} catch (SystemException e) {
			data.put("error","Error while fetching sub level filters");
		}
	}
	public static JSONObject loadFirstLevelFilter(PortletPreferences prefs) throws SystemException {
		long vocId = GetterUtil.getLong(prefs.getValue("linkedFilterVocId", "0")); // check config.jsp
		JSONObject levelInfo = getLevelData(prefs, 0); // send index..
		String filterName = levelInfo.getString("name");
		String filterType = levelInfo.getString("type"); // Single or Multiple
		boolean isAll = levelInfo.getBoolean("displayAll");
		boolean displayHeader = levelInfo.getBoolean("displayHeader");
		return createFilterByVocId(vocId, filterName, filterType,LINKED_CATEGORY,isAll,displayHeader);
	}
	private static JSONObject createFilterByVocId(long vocId, String filterName,String filterType,String category,boolean isAllRequired, boolean displayHeader) throws SystemException{
		OrderByComparator nameAsc = OrderByComparatorFactoryUtil.create("AssetCategory", "name",true);
		List<AssetCategory>catgs = AssetCategoryLocalServiceUtil.getVocabularyCategories(0, vocId, -1, -1, nameAsc);
		JSONArray catgsJArray  = JSONFactoryUtil.createJSONArray();
		if(isAllRequired){
			catgsJArray.put(getJsonAllSearchItem());
		}
		for(AssetCategory catg : catgs){
			catgsJArray.put(getCatgJson(catg));
		}
		JSONObject obj = JSONFactoryUtil.createJSONObject();
		obj.put(NAME_KEY, filterName);
		obj.put(TYPE_KEY, filterType);
		obj.put(CATEGORY_KEY, category);
		obj.put(CATEGORIES_KEY, catgsJArray);
		obj.put(DISPLAY_HEADER_KEY, displayHeader);
		return obj;
	}
	
	public static void prepareChildCategories(JSONObject data, PortletRequest request){
		String catgIds = ParamUtil.getString(request, "catgIds");
		JSONObject obj;
		try {
			int levelNo = ParamUtil.getInteger(request,"levelNo");
			obj = prepareChildCategories(catgIds, levelNo,request);
			data.put(FILTERDATA_KEY, obj);
		} catch (SystemException e) {
			data.put("error", "Error while getting childs");
		}
	}
	public static JSONObject prepareChildCategories(String catgIds, int levelNo, PortletRequest request) throws SystemException{
		JSONArray catgsJArray  = JSONFactoryUtil.createJSONArray();
		JSONObject obj = JSONFactoryUtil.createJSONObject();
		JSONObject levelInfo = getLevelData(request.getPreferences(),levelNo );
		if(levelInfo == null){
			return obj;
		}
		if(levelInfo.getBoolean("displayAll")){
			catgsJArray.put(getJsonAllSearchItem());
		}
		String[] parentCatgIdsStrAr = catgIds.split(StringPool.COMMA);
		for(String idStr : parentCatgIdsStrAr){
			long parentCatgId = GetterUtil.getLong(idStr);
			if(parentCatgId == 0){
				continue;
			}
			List<AssetCategory>childCatgs = AssetCategoryLocalServiceUtil.getChildCategories(parentCatgId);
			for(AssetCategory catg : childCatgs){
				catgsJArray.put(getCatgJson(catg));
			}
		
		}
		
		obj.put(NAME_KEY, levelInfo.getString("name"));
		obj.put(TYPE_KEY, levelInfo.getString("type")); // single or multiselection
		obj.put(CATEGORY_KEY, LINKED_CATEGORY);
		obj.put(CATEGORIES_KEY, catgsJArray);
		obj.put(DISPLAY_HEADER_KEY, levelInfo.getBoolean("displayHeader"));
		
		return obj;
	}
	private static JSONObject getCatgJson(AssetCategory catg){
		JSONObject tempCatgJ = JSONFactoryUtil.createJSONObject();
		tempCatgJ.put("name", catg.getName());
		tempCatgJ.put("categoryId", catg.getCategoryId());
		
		String temp = GetterUtil.getString(catg.getDescription(Locale.ENGLISH,true));
		
		if(temp.contains("#link#")){
			String []afterSplit = temp.split("#link#");
			if(afterSplit.length > 0){
				tempCatgJ.put("desc", afterSplit[0]);
			}
			if(afterSplit.length > 1){
				tempCatgJ.put("viewLink", afterSplit[1]);
			}
		}else{
			tempCatgJ.put("desc", temp);
		}
		
		return tempCatgJ;
		
	}
	private static JSONObject getJsonAllSearchItem(){
		JSONObject tempCatgJ = JSONFactoryUtil.createJSONObject();
		tempCatgJ.put("name", "All");
		tempCatgJ.put("isAll", true);
		//tempCatgJ.put("categoryId", 0);
		
		return tempCatgJ;
		
	}
	private static JSONObject getLevelData(PortletPreferences portletPreferences,int levelNo){
		String levelsData = GetterUtil.getString(portletPreferences.getValue("levelsData", "[]"));
		try {
			JSONArray obj = JSONFactoryUtil.createJSONArray(levelsData);
			return obj.getJSONObject(levelNo);
		} catch (Exception e) {
			_log.error("Error while getting level info for  " + levelNo + e.getMessage());
		}
		JSONObject obj = JSONFactoryUtil.createJSONObject();
		obj.put("type", SINGLE_FILTER_TYPE);
		obj.put("name", "Filter");
		return obj;
	}
	
	// individual filters
	public static void prepareIvdFilters(PortletRequest request,JSONObject responseData) throws SystemException{
		PortletPreferences portletPreferences = request.getPreferences();
		JSONArray masterData = getIvdFiltersData(portletPreferences);
		JSONArray filters = JSONFactoryUtil.createJSONArray();
		if(masterData != null && masterData.length() > 0){
			for(int i = 0 ; i < masterData.length() ; i++){
				JSONObject details = masterData.getJSONObject(i);
				String filterName = details.getString("name");
				String filterType = details.getString("type"); // single or multiple
				boolean isAll = details.getBoolean("displayAll");
				boolean displayHeader = details.getBoolean("displayHeader");
				long vocId   = GetterUtil.getLong(details.getString("filterVocId"));
				if(vocId > 0){
					filters.put(createFilterByVocId(vocId, filterName, filterType,IVD_CATEGORY,isAll,displayHeader));
				}
			}
		}
		responseData.put("ivdFiltersData", filters);
	}
	private static JSONArray getIvdFiltersData(PortletPreferences portletPreferences){
		String ivdFiltersData = GetterUtil.getString(portletPreferences.getValue("ivdFiltersData", "[]"));
		try {
			JSONArray obj = JSONFactoryUtil.createJSONArray(ivdFiltersData);
			return obj;
		} catch (Exception e) {
			_log.error("Error while getting ivd filters data" +  e.getMessage());
		}
		return null;
	}
	
	
}
