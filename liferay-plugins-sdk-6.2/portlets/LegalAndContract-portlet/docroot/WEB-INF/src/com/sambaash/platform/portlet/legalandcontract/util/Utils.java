package com.sambaash.platform.portlet.legalandcontract.util;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.WindowState;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.WindowStateFactory;
import com.liferay.portal.kernel.repository.model.FileEntry;
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
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.SortFactoryUtil;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.User;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil;
import com.liferay.portlet.documentlibrary.NoSuchFolderException;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.model.DLFileVersion;
import com.liferay.portlet.documentlibrary.model.DLFolder;
import com.liferay.portlet.documentlibrary.service.DLAppServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFileVersionLocalServiceUtil;
import com.sambaash.platform.constant.SambaashConstants;
import com.sambaash.platform.portlet.legalandcontract.permissions.LegalPermissionUtil;
import com.sambaash.platform.srv.spservices.NoSuchSPParameterException;
import com.sambaash.platform.srv.spservices.model.SPParameter;
import com.sambaash.platform.srv.spservices.service.SPParameterLocalServiceUtil;
import com.sambaash.platform.srv.spservices.service.persistence.SPParameterUtil;
import com.sambaash.platform.util.PermissionUtil;
import com.sambaash.platform.util.SambaashUtil;

public class Utils {
	
	private static Log _log = LogFactoryUtil.getLog(Utils.class);

	public static Calendar getCalendar(ThemeDisplay themeDisplay, int day, int month,
			int year) {
		Calendar calendar = Calendar.getInstance();

		calendar.set(Calendar.DAY_OF_MONTH, day+1);
		calendar.set(Calendar.MONTH, month);
		calendar.set(Calendar.YEAR, year);

		return calendar;
	}
	
	public static List<AssetCategory> getCategories(long vocabularyId, String... type) {
		List<AssetCategory> temp = new ArrayList<AssetCategory>();
		if(vocabularyId != 0){
			
			try {
				List<AssetCategory>  categories = AssetCategoryLocalServiceUtil.getVocabularyCategories(
						vocabularyId, -1, -1, null);
				if(Validator.isNotNull(type) && type.length > 0){
					if(LegalConstants.SORT_INT.equalsIgnoreCase(type[0])){
						temp = sortInt(categories);
					}else{
						temp = sortString(categories);
					}
				}else{
					temp = sortString(categories);
				}
			} catch (Exception e) {
			//	_log.error(e.getMessage(), e);
			}
		}

		return temp;
	}

	public static String getCategoryName(long vocabularyId, long categoryId) {
	/*	List<AssetCategory> categories = getCategories(vocabularyId);
		for (AssetCategory cat : categories) {
			if (cat.getCategoryId() == categoryId) {
				return cat.getName();
			}
		} */
		String name = "";
		try {
			 AssetCategory cat = AssetCategoryLocalServiceUtil.getCategory(categoryId);
			 name = cat.getName();
		} catch (Exception e) {
		 // _log.error(e);
		}
		return name;
	}
	public static String getCategoryName(long categoryId) {
		String name = "";
		try {
			AssetCategory cat = AssetCategoryLocalServiceUtil.getCategory(categoryId);
			name = cat.getName();
		} catch (Exception e) {
			//_log.error(e);
		}
		return name;
	}
	
	public static long getCategoryId(long vocId,String categoryName){
		long catId = 0;
		
	/*	DynamicQuery dynaQuery = DynamicQueryFactoryUtil.forClass(
				AssetCategory.class,
				PortalClassLoaderUtil.getClassLoader());
		Criterion criterion1 = RestrictionsFactoryUtil.eq("vocabularyId",
				vocId);
		Criterion criterion2 = RestrictionsFactoryUtil.eq("name",
				categoryName);
		Criterion criterion = RestrictionsFactoryUtil.and(criterion1, criterion2);
		dynaQuery.add(criterion);
		try {
			List<AssetCategory> list = AssetCategoryLocalServiceUtil
					.dynamicQuery(dynaQuery);
			if(!list.isEmpty()){
				catId = list.get(0).getCategoryId();
			}
		} catch (Exception e) {
		//	_log.error(e);
			throw e;
		} */
		AssetCategory categ = getAssetCategory(vocId, categoryName);
		if(Validator.isNotNull(categ)){
			catId = categ.getCategoryId();
		}
		return catId;
	}
	
	public static AssetCategory getAssetCategory(long vocId, String name){

		AssetCategory categ = null;
		DynamicQuery dynaQuery = DynamicQueryFactoryUtil.forClass(
				AssetCategory.class,
				PortalClassLoaderUtil.getClassLoader());
		Criterion criterion1 = RestrictionsFactoryUtil.eq("vocabularyId",
				vocId);
		Criterion criterion2 = RestrictionsFactoryUtil.eq("name",
				name);
		Criterion criterion = RestrictionsFactoryUtil.and(criterion1, criterion2);
		dynaQuery.add(criterion);
		try {
			List<AssetCategory> list = AssetCategoryLocalServiceUtil
					.dynamicQuery(dynaQuery);
			if(!list.isEmpty()){
				categ = list.get(0);
			}
		} catch (Exception e) {
		}
		return categ;
	
	}
	public static long getCategoryIdIgnoreCase(long vocId, String categoryName){
		long catId = 0;
		List<AssetCategory>list = getCategories(vocId);
		categoryName = GetterUtil.getString(categoryName);
		if(Validator.isNotNull(list)){
			for(AssetCategory catg:list){
				if(catg.getName().equalsIgnoreCase(categoryName)){
					catId = catg.getCategoryId();break;
				}
			}
		}
		return catId;
	}
	
	public static String getCategoryName(Document doc, String vocubalaryId,String fieldName){
		String categoryName = "";
		try {
			long catId = GetterUtil.getLong(doc.get(fieldName));
			categoryName = Utils.getCategoryName(Long.parseLong(vocubalaryId),catId);
		} catch (Exception e) {
			//_log.error(e.getMessage(), e);
		} 
		return categoryName;
	}
	
	public static String getCategoryName( String vocubalaryId,long catId){
		String categoryName = "";
		try {
			categoryName = Utils.getCategoryName(Long.parseLong(vocubalaryId),catId);
		} catch (Exception e) {
		//	_log.error(e.getMessage(), e);
		} 
		return categoryName;
	}
	
	public static String getDateStrYMD(Date date){
		String dateStr = "";
		String format = "dd-MMM-yyyy";
		if(date != null){
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			dateStr = sdf.format(date); 
		}
		return dateStr;
	}
	
	public static String getDateTime(Date date){
		String dateStr = "";
		String format = "dd-MMM-yyyy HH:mm";
		if(date != null){
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			dateStr = sdf.format(date); 
		}
		return dateStr;
	}
	
	public static String getDateStrddMMYYYY(Date date){
		String dateStr = "";
		String format = "dd/MM/yyyy";
		if(date != null){
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			dateStr = sdf.format(date); 
		}
		return dateStr;
	}
	
	public static Date getDate4rDDMMYYYY(String str) throws ParseException{
		  if(Validator.isNotNull(str)){
			  str = str.trim();
			  SimpleDateFormat df = new SimpleDateFormat(ClassMasterConstants.DATE_FORMAT_DDMMYYYY);
			  df.setLenient(false);
			  //df.set2DigitYearStart(new Date().set);
			  Date date = df.parse(str);
			  int yearStartIndex = str.lastIndexOf("/") + 1 ;
			  String year = str.substring(yearStartIndex);
			  if(year.length() != 4){
				  throw (new ParseException("Invalid Year. year must be 4 digit length", yearStartIndex));
			  }
			  return date;
		  }
		  return null;
	  }
	public static Date getDate4rDDMMMYYYY(String str){
		if(Validator.isNotNull(str)){
			try{
				String format = "dd-MMM-yyyy";
				SimpleDateFormat df = new SimpleDateFormat(format);
				Date date = df.parse(str);
				return date;
			}catch(Exception ex){
				
			}
			
		}
		return null;
	}
	
	public static Calendar getCalendar(Date date){
		Calendar cal = null;
		if(Validator.isNotNull(date)){
			cal = Calendar.getInstance();
			cal.setTime(date);
		}
		return cal;
	}
	
	public static String getDateStrYMD(Document doc,String fieldName){
		String dateStr = "" ;
		try{
			if(Validator.isNotNull(doc.getDate(fieldName))){
				dateStr = getDateStrYMD(doc.getDate(fieldName));
			}
		}catch(Exception ex){
			//_log.error(ex);
		}
		return dateStr;
	}
	
	public static DateBean getDateBean(Date date) {
		DateBean dateBean = new DateBean();
		if (Validator.isNotNull(date)) {
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			dateBean.setDate(String.valueOf(cal.get(Calendar.DATE)));
			dateBean.setMonth(String.valueOf(cal.get(Calendar.MONTH)));
			dateBean.setYear(String.valueOf(cal.get(Calendar.YEAR)));
		}else{
			dateBean.setDate("0");
			dateBean.setMonth("-1");
			dateBean.setYear("0");
		}
		return dateBean;
	}
	
	public static long[] getCategoryIds(Document doc,int size){
		long [] catIds = new long[size];
		try{
			String str[] = doc.getValues(Field.ASSET_CATEGORY_IDS);
			if(str.length < catIds.length){
				size = str.length;
			}
			for(int i=0; i < size; i++){
				catIds[i] = Long.parseLong(str[i]);
			}
		}catch(Exception ex){
			//_log.error(ex);
		}
		return catIds;
 	}
	public static List<Long> getCategoryIds(Document doc){
		List<Long>list = new ArrayList<Long>();
		try{
			String str[] = doc.getValues(Field.ASSET_CATEGORY_IDS);
			if(Validator.isNotNull(str)){
				for(int i=0; i < str.length; i++){
					//catIds[i] = Long.parseLong(str[i]);
					list.add(GetterUtil.getLong(str[i]));
				}
			}
			
		}catch(Exception ex){
			//_log.error(ex);
		}
		return list;
	}
	
	public static List<Long> getLongList(long[] categoryIds){
		List<Long>list = new ArrayList<Long>();
		if(Validator.isNotNull(categoryIds)){
			for (Long long1 : categoryIds) {
				list.add(long1);	
			}
		}
		return list;
	}
	
	public static long[] getLongArray(List<Long>list){
		long array[] = null;
		if(Validator.isNotNull(list)){
			array = new long[list.size()];
			for(int i=0; i<list.size();i++){
				array[i] = GetterUtil.getLong(list.get(i));
			}
		}
		return array;
	}
	
	public static long[] filterZeros(long[] array){
		return ArrayUtil.remove(array, 0);
	}
	
	public static List<Long> getAssetCategoryIds(String className, long id){
		if(Validator.isNotNull(className) && id != 0){
			try {
				AssetEntry assetEntry = AssetEntryLocalServiceUtil.fetchEntry(
						className, id);
				List<Long> catIds = Utils.getLongList(assetEntry.getCategoryIds());
				return catIds;
			} catch (Exception e) {
				_log.error(e);
			}
		}
		return new ArrayList<Long>();
	}
	public static AssetCategory  getCategory(PortletPreferences prefs,String vocKey,List<Long>categoryIds ){
		long vocId = GetterUtil.getLong(prefs.getValue(vocKey, "0"));
	/*	AssetCategory assetCategory = null;
		try{
			if(Validator.isNotNull(categoryIds)){
				for (Long l : categoryIds) {
					if(Validator.isNotNull(l)){
						AssetCategory category = AssetCategoryLocalServiceUtil.getAssetCategory(l);
						if(category.getVocabularyId() == countryVocId){
							assetCategory = category;
							break;
						}
					}
				}
			}
			
		}catch(Exception ex){
			_log.error("error while getting category " + ex.getMessage());
		} */
		AssetCategory assetCategory = getCategory(vocId,categoryIds);
		return assetCategory;
	}
	public static AssetCategory  getCategory(long vocId,List<Long>categoryIds ){
		//long countryVocId = GetterUtil.getLong(prefs.getValue(vocKey, "0"));
		AssetCategory assetCategory = null;
		try{
			if(Validator.isNotNull(categoryIds)){
				for (Long l : categoryIds) {
					if(Validator.isNotNull(l)){
						AssetCategory category = AssetCategoryLocalServiceUtil.getAssetCategory(l);
						if(category.getVocabularyId() == vocId){
							assetCategory = category;
							break;
						}
					}
				}
			}
			
		}catch(Exception ex){
			_log.error("error while getting category " + ex.getMessage());
		}
		return assetCategory;
	}
	
	public static String  getCategoryName(PortletPreferences prefs,String vocKey,List<Long>categoryIds ){
		AssetCategory category = getCategory(prefs, vocKey, categoryIds);
		String name = "";
		if(Validator.isNotNull(category)){
			name = category.getName();
		}
		return name;
	}
	public static long  getCategoryId(PortletPreferences prefs,String vocKey,List<Long>categoryIds ){
		AssetCategory category = getCategory(prefs, vocKey, categoryIds);
		long id = 0;
		if(Validator.isNotNull(category)){
			id = category.getCategoryId();
		}
		return id;
	}
	public static String  getCategoryName(long vocId,List<Long>categoryIds ){
		AssetCategory category = getCategory(vocId, categoryIds);
		String name = "";
		if(Validator.isNotNull(category)){
			name = category.getName();
		}
		return name;
	}
	public static long  getCategoryId(long vocId,List<Long>categoryIds ){
		AssetCategory category = getCategory(vocId, categoryIds);
		long id = 0;
		if(Validator.isNotNull(category)){
			id = category.getCategoryId();
		}
		return id;
	}
	public static AssetCategory  getCategory(PortletPreferences prefs,String vocKey,long[] categoryIds ){
		AssetCategory assetCategory = null;
		List<Long>list = getLongList(categoryIds);
		assetCategory = getCategory(prefs, vocKey, list);
		return assetCategory;
	}
	
	public static String  getCategoryName(PortletPreferences prefs,String vocKey, long []categoryIds ){
		List<Long>list = getLongList(categoryIds);
		String name = getCategoryName(prefs, vocKey, list);
		return name;
	}
	public static long  getCategoryId(PortletPreferences prefs,String vocKey,long[]categoryIds ){
		List<Long>list = getLongList(categoryIds);
		long id = getCategoryId(prefs, vocKey, list);
		return id;
	}
	public static AssetCategory  getCategory(long vocId,long[] categoryIds ){
		AssetCategory assetCategory = null;
		List<Long>list = getLongList(categoryIds);
		assetCategory = getCategory(vocId, list);
		return assetCategory;
	}
	
	public static String  getCategoryName(long vocId, long []categoryIds ){
		List<Long>list = getLongList(categoryIds);
		String name = getCategoryName(vocId, list);
		return name;
	}
	public static long  getCategoryId(long vocId,long[]categoryIds ){
		List<Long>list = getLongList(categoryIds);
		long id = getCategoryId(vocId, list);
		return id;
	}
	
	public static long[] reorderCategoryIds(PortletPreferences preferences,String []vocIdFields,long[] categoryIds){
		long tempCatIds[] = new long[vocIdFields.length];
		try{
			long vocIds[] = new long[vocIdFields.length];
			 for(int i=0; i < vocIdFields.length ; i++){
				 vocIds[i] = Long.valueOf(preferences.getValue(vocIdFields[i], "0"));
			 }
			 tempCatIds = reorderCategoryIds(vocIds, categoryIds);
			
		} catch(Exception ex){
			_log.error(ex);
		}
		return tempCatIds;
	}
	public static long[] reorderCategoryIds(long vocIds[],long[] categoryIds){
		long tempCatIds[] = new long[vocIds.length];
		try{
			List<AssetCategory> catList = getAssetCategories(categoryIds);
			long vocId;
			for(AssetCategory categ:catList){
				vocId =  categ.getVocabularyId();
				for(int i=0; i < vocIds.length; i++){
					if(vocId == vocIds[i]){
						tempCatIds[i] = categ.getCategoryId();
						break;
					}
				}
			}
		} catch(Exception ex){
			_log.error(ex);
		}
		return tempCatIds;
	}
	
	public static AssetCategory getAssetCategory(long vocId,long[] categoryIds){
		AssetCategory temp = null;
		try{
			List<AssetCategory> catList = getAssetCategories(categoryIds);
			for(AssetCategory categ:catList){
				if(vocId == categ.getVocabularyId()){
						temp = categ;
						break;
				}
			}
		} catch(Exception ex){
			_log.error(ex);
		}
		return temp;
	}
	
	public static List<AssetCategory> getAssetCategories(long[]categoryIds) throws SystemException{
		Object objs[] = new Object[categoryIds.length];
		for(int i=0; i< categoryIds.length; i++){
			objs[i] = categoryIds[i];
		}
		
		DynamicQuery dynaQuery = DynamicQueryFactoryUtil.forClass(
				AssetCategory.class,
				PortalClassLoaderUtil.getClassLoader());
		Criterion criterion = RestrictionsFactoryUtil.in("categoryId",objs);
	
		dynaQuery.add(criterion);
	
		List<AssetCategory> catList = DLFileEntryLocalServiceUtil
				.dynamicQuery(dynaQuery);
		
		return catList;
		
	}
	public static long parseId(String strId){
		long id = 0;
		try{
			id = Long.parseLong(strId) ;
		}catch(Exception ex){
			
		}
		
		return id;
	}
	
	public static boolean nullOrEmpty(String str){
		boolean result = false;
		if(str == null || str.trim().isEmpty()){
			result = true;
		}
		return result;
	}
	
	public static String getNextVersion(String version){
		String nextV =  StringPool.BLANK;
		try{
			nextV = (Float.parseFloat(version) + 1 )+ "";
		}catch(Exception ex){
			_log.error(ex);
			nextV = "1.0";
		}
		return nextV;
	}
	
	public static Object[] parseRequest(PortletRequest actionRequest,
			PortletResponse actionResponse) throws FileUploadException {
		Object[] objs = new Object[2];
		Map<String, String> paramMap = new HashMap<String, String>();
		List<FileItem> files = new ArrayList<FileItem>();

		HttpServletRequest request_ = PortalUtil
				.getHttpServletRequest(actionRequest);
		HttpServletRequest httpRequest = PortalUtil
				.getOriginalServletRequest(request_);
		try {
			List<FileItem> items = new ServletFileUpload(
					new DiskFileItemFactory()).parseRequest(httpRequest);
			String key;
			for (FileItem item : items) {
				if (item.isFormField()) {
					key = item.getFieldName();
					key = key.substring(actionResponse.getNamespace().length());
					paramMap.put(key, item.getString());
				} else {
					files.add(item);
				}
			}

		} catch (FileUploadException e) {
			_log.error(e.getMessage(), e);
			throw e;
		}

		objs[0] = paramMap;
		objs[1] = files;

		return objs;
	}

	public static List<Map<String, String>> getFiles4mIndexer(long compnayId,
			long folderId,boolean convertNltoBr) {

		List<Map<String, String>> files = new ArrayList<Map<String, String>>();
		_log.debug("Getting files from indexer for folder : "  + folderId);
		Indexer indexer = IndexerRegistryUtil.getIndexer(DLFileEntry.class
				.getName());
		SearchContext searchContext = new SearchContext();
		searchContext.setCompanyId(compnayId);
		//TODO: setting -1,-1 not working. so keeping 0 to 50.
		searchContext.setStart(0);
		searchContext.setEnd(100);

		BooleanClause[] booleanClauses = new BooleanClause[1];
		BooleanQuery bq = BooleanQueryFactoryUtil.create(searchContext);
		bq.addRequiredTerm(Field.FOLDER_ID, folderId);
		BooleanClause bc = BooleanClauseFactoryUtil.create(searchContext,bq,
				BooleanClauseOccur.MUST.getName());
		booleanClauses[0] = bc;
		//_log.debug("Boolean clauses " + booleanClauses.toString());
		searchContext.setBooleanClauses(booleanClauses);
		Sort sort = SortFactoryUtil.create(Field.MODIFIED_DATE, Sort.LONG_TYPE,
				true);
		Sort[] sorts = new Sort[] { sort };
		searchContext.setSorts(sorts);

		Hits results = null;
		try {
			results = indexer.search(searchContext);
			if (results != null) {
				int length = results.getDocs().length;
				_log.debug("Length of results " + length);
				Map<String, String> map;
				for (int i = 0; i < length; i++) {
					map = new HashMap<String, String>();
					Document doc = results.doc(i);

					String title = GetterUtil.getString(doc.get(Field.TITLE));
					_log.debug(" File " + title);
					String version = GetterUtil.getString(doc.get(LegalConstants.VERSION));
					String fileEntryId = GetterUtil.getString(doc
							.get(Field.ENTRY_CLASS_PK));
				
					map.put(Field.TITLE, title);
					map.put(LegalConstants.FILE_ENTRY_ID, fileEntryId);
					map.put(LegalConstants.VERSION, version);
					String desc = GetterUtil.getString(doc.get(Field.DESCRIPTION));
					if(convertNltoBr){
						desc = Utils.toHtmlTags(desc);
					}
					map.put(Field.DESCRIPTION, desc);

					files.add(map);
				}
			}
		} catch (Exception e) {
			_log.error(e.getMessage(), e);
		}
		//_log.error("Length of files returning " + files.size());
		return files;
	}
	public static void saveSPParameter(String paramName,String paramValue){
		SPParameter spparm;
		try {
			spparm = SPParameterLocalServiceUtil.findBySPParameterGroupIdAndName(0,paramName);
			spparm.setValue(paramValue);
			SPParameterLocalServiceUtil.updateSPParameter(spparm);
			SPParameterUtil.clearCache(spparm);
		} catch (NoSuchSPParameterException e) {
		} catch (SystemException e) {
		}
	}
	
	public static String getUserFolderName(long userId){
		String folderName = "User_" + userId;
		return folderName;
	}

	public static  Map<String, String> getParameterMap(PortletRequest request){
		return SambaashUtil.getParameterMap(request);
	}
	
	public static String getTrademarkDetailsFriendlyUrl(String trademarkId){
		String trademarkUrlFormat = "%s/trademarks/-/trademarks/view/%s";
		String portalUrl =  SambaashUtil.getPortalURL(PortalUtil.getDefaultCompanyId(),
				GetterUtil.getLong(SambaashConstants.DEFAULT_GROUP_ID));
		String url = String.format(trademarkUrlFormat,portalUrl,trademarkId);
		return url;
		
	}
	

	public static String getAgencyDetailsFriendlyUrl(PortletRequest request,long agencyId) {
		ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);
		String trademarkUrlFormat = "%s/agency/-/agency/view/%s";
		String url = String.format(trademarkUrlFormat, themeDisplay.getPortalURL(),agencyId);
		
		return url;
	}
	

	public static String getLitigationDetailsFriendlyUrl(long litigationId) {
		String trademarkUrlFormat = "%s/litigation/-/litigation/view/%s";
		String portalUrl =  SambaashUtil.getPortalURL(PortalUtil.getDefaultCompanyId(),
				GetterUtil.getLong(SambaashConstants.DEFAULT_GROUP_ID));
		String url = String.format(trademarkUrlFormat,portalUrl,litigationId);
		return url;
	}
	
	public static String getAddLitigationFriendlyUrl(long trademarkId) {
		String trademarkUrlFormat = "%s/litigation/-/litigation/add/%s";
		String portalUrl =  SambaashUtil.getPortalURL(PortalUtil.getDefaultCompanyId(),
				GetterUtil.getLong(SambaashConstants.DEFAULT_GROUP_ID));
		String url  = String.format(trademarkUrlFormat, portalUrl,trademarkId);
		return url;
	}
	
	public static WindowState getWindowState(HttpServletRequest request) {
		WindowState windowState = WindowState.MAXIMIZED;

		String windowStateString = ParamUtil.getString(request, "windowState");

		if (Validator.isNotNull(windowStateString)) {
			windowState = WindowStateFactory.getWindowState(windowStateString);
		}

		return windowState;
	}
	public static String getDLFileUrl(PortletRequest request,String fileEntryId){
		return getDLFileUrl(request, GetterUtil.getLong(fileEntryId));
		
	}
	
	public static String getDLFileUrl(PortletRequest request,long fileEntryId){
		ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);
		FileEntry fileEntry;
		String url = StringPool.BLANK;
		try {
			fileEntry = DLAppServiceUtil.getFileEntry(fileEntryId);
			url = themeDisplay.getPortalURL() + themeDisplay.getPathContext() + "/documents/" + themeDisplay.getScopeGroupId() + StringPool.SLASH + fileEntry.getFolderId() + StringPool.SLASH + HttpUtil.encodeURL(fileEntry.getTitle(), true) + "?version=" + fileEntry.getLatestFileVersion().getVersion();
		} catch (PortalException e1) {
		} catch (SystemException e1) {
		}
		return url;
	}
	
	public static void addIndexKeywords(Document doc, String field, String value){
		if(Validator.isNotNull(doc)){
			field = GetterUtil.getString(field);
			value = GetterUtil.getString(value);
			
			doc.addKeyword(field, value);
			value = value.replaceAll("\\p{Punct}", "");
			doc.addText(getIndexFieldInLower(field), value.toLowerCase());
		}
	}
	
	public static String getIndexFieldInLower(String field){
		field = GetterUtil.getString(field);
		return String.format(LegalConstants.INDEX_FIELD_LOWER_FORMAT,field.toLowerCase());
	}

	public static String getIndexFieldValueInLower(String value){
		value = GetterUtil.getString(value).replaceAll("\\p{Punct}","");
		return value.toLowerCase();
	}
	
	public static boolean checkUserPermissionOnCountry(PortletRequest request,long countryVocId,String country){
		LegalPermissionUtil pu = new LegalPermissionUtil();
		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
	    List<AssetCategory> countryList = pu.getPermissionedCountries(themeDisplay.getUserId(), themeDisplay.getScopeGroupId(),countryVocId);
	    boolean authorized = false;
	    if(Validator.isNotNull(countryList)){
	    	for(AssetCategory asset:countryList){
	    		if(asset.getName().equalsIgnoreCase(country)){
	    			authorized = true;
	    			break;
	    		}
	    	}
	    }
	    return authorized;
	}
	
	public static void initalizeAdmin(){
		try{
			PermissionUtil.initializeAdminPermissionChecker();
		}catch(Exception ex){
			_log.error("Error while initialize admin permission checker " + ex.getMessage());
		}
	}
	public static void resetToUser(User user){
		try{
			PermissionUtil.resetPermissionChecker(user);;
		}catch(Exception ex){
			_log.error("Error while resetting admin permission checker " + ex.getMessage());
		}
	}
	public static Object createGetFileOrFolder(PortletRequest request,User user,long parentId,String childPath,
			String type,boolean doWithAdmin,boolean create,boolean assignDefaultPermissions) throws PortalException, SystemException{
		Object obj = null;
		_log.debug("Getting folder Id for " + childPath);
		if(doWithAdmin){
			try{
				PermissionUtil.initializeAdminPermissionChecker();
			}catch(Exception ex){
				_log.error("Error while initialize admin permission checker " + ex.getMessage());
				return obj;
			}
		}
		if(Validator.isNull(childPath)){
			return obj;
		}
		
		ServiceContext serviceContext = ServiceContextFactory.getInstance(
				DLFolder.class.getName(), request);
		ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);
		
		String []childs = childPath.split("/");
		long tempParentId = parentId;
		Folder tempFolder = null;
		
		boolean isFolder = false;
		boolean isAllSuccess = true;
		for(int i = 0; i < childs.length ; i++){
			isFolder = false;
			if(i == childs.length -1){
				if(LegalConstants.FILE.equalsIgnoreCase(type)){
					
				}else if(LegalConstants.FOLDER.equalsIgnoreCase(type)){
					isFolder = true;
				}
			}else{
				isFolder = true;
			}
			if(isFolder){
				try {
					tempFolder = DLAppServiceUtil.getFolder(themeDisplay.getScopeGroupId(), tempParentId,
							childs[i]);
					_log.debug("Folder Id for  " + childs[i] + "  " + tempFolder.getFolderId());
					
					addDefaultFolderPermissions(themeDisplay.getCompanyId(), tempFolder.getFolderId());
					
					tempParentId = tempFolder.getFolderId();
				} catch (NoSuchFolderException ex) {
					if(create){
						tempFolder = DLAppServiceUtil.addFolder(themeDisplay.getScopeGroupId(),
								tempParentId, childs[i], childs[i], serviceContext);
						tempParentId = tempFolder.getFolderId();
						if(assignDefaultPermissions){
							addDefaultFolderPermissions(themeDisplay.getCompanyId(), tempFolder.getFolderId());
						}
					}else{
						isAllSuccess = false;
						break;
					}
				}
			}
		}
		
		if(isAllSuccess){
			obj = tempFolder;
		}
		
		if(doWithAdmin){
			try{
				PermissionUtil.resetPermissionChecker(user);;
			}catch(Exception ex){
				_log.error("Error while resetting admin permission checker " + ex.getMessage());
			}
		}
		return obj;
	}
	
	public static void addDefaultFilePermissions(long companyId,long fileEntryId){
		
		PermissionUtil.addDefaultRoleResourcePermission(companyId,
				DLFileEntry.class.getName(), fileEntryId, new String[] {
			ActionKeys.VIEW, ActionKeys.UPDATE });
		
		String temp = GetterUtil.getString(SambaashUtil.getParameter(SambaashConstants.LEGAL_HIGH_PRIVILIGED_ROLES,0));
		String []privilegedRoles = temp.split(",");
		String actions[] = {"SHARE",ActionKeys.DELETE,ActionKeys.PERMISSIONS, ActionKeys.VIEW, ActionKeys.UPDATE};

		for(String roleName:privilegedRoles){
			try {
				Role role = RoleLocalServiceUtil.getRole(companyId, roleName);
				PermissionUtil.addResourcePermission(companyId, role.getRoleId(), DLFileEntry.class.getName(),
						fileEntryId, actions);
			} catch (Exception e) {
				_log.error("Error while assigning permissions to roles " + e.getMessage());
			}
		}
	
	}
	public static void addDefaultFolderPermissions(long companyId,long folderId){
		
		PermissionUtil.addDefaultRoleResourcePermission(companyId,
				DLFolder.class.getName(), folderId, new String[] {
			ActionKeys.ADD_DOCUMENT, ActionKeys.ADD_SUBFOLDER, ActionKeys.VIEW, ActionKeys.UPDATE, ActionKeys.DELETE });
		
		String temp = GetterUtil.getString(SambaashUtil.getParameter(SambaashConstants.LEGAL_HIGH_PRIVILIGED_ROLES,0));
		String []privilegedRoles = temp.split(",");
		String actions[] = {"SHARE",ActionKeys.ADD_DOCUMENT,ActionKeys.ACCESS,ActionKeys.ADD_SHORTCUT,ActionKeys.ADD_SUBFOLDER,
				ActionKeys.DELETE,ActionKeys.PERMISSIONS, ActionKeys.VIEW, ActionKeys.UPDATE};

		for(String roleName:privilegedRoles){
			try {
				Role role = RoleLocalServiceUtil.getRole(companyId, roleName);
				PermissionUtil.addResourcePermission(companyId, role.getRoleId(), DLFolder.class.getName(),
						folderId, actions);
			} catch (Exception e) {
				_log.error("Error while assigning permissions to roles " + e.getMessage());
			}
		}
		
	}
	
	public static void addDefaultFolderPermissionsToRole(long companyId,long folderId,String roleName){
		String actions[] = {"SHARE",ActionKeys.ADD_DOCUMENT,ActionKeys.ACCESS,ActionKeys.ADD_SHORTCUT,ActionKeys.ADD_SUBFOLDER,
				ActionKeys.DELETE,ActionKeys.PERMISSIONS, ActionKeys.VIEW, ActionKeys.UPDATE};
		try{
			Role role = RoleLocalServiceUtil.getRole(companyId, roleName);
			PermissionUtil.addResourcePermission(companyId, role.getRoleId(), DLFolder.class.getName(),
					folderId, actions);
		}catch(Exception ex){
			_log.error(ex.getMessage());
		}
		
	}
	
	public static void addDefaultFilePermissionsToRole(long companyId,long fileEntryId,String roleName){
		try{
			String actions[] = {"SHARE",ActionKeys.DELETE,ActionKeys.PERMISSIONS, ActionKeys.VIEW, ActionKeys.UPDATE};
			try {
				Role role = RoleLocalServiceUtil.getRole(companyId, roleName);
				PermissionUtil.addResourcePermission(companyId, role.getRoleId(), DLFileEntry.class.getName(),
						fileEntryId, actions);
			} catch (Exception e) {
				_log.error("Error while assigning permissions to roles " + e.getMessage());
			}
		
		}catch(Exception ex){
			_log.error("Error whiel assigning permissions");
		}
	}
	
	public static void markFileVersionsAsDelete(List<Long> fileEntryIds) {
		DLFileVersion dlFileVersion;
		for (long fileEntryId : fileEntryIds) {
			try {
				dlFileVersion = DLFileVersionLocalServiceUtil
						.getLatestFileVersion(fileEntryId, false);
				dlFileVersion.setStatus(WorkflowConstants.STATUS_INACTIVE);
				DLFileVersionLocalServiceUtil
						.updateDLFileVersion(dlFileVersion);
			} catch (Exception e) {
				_log.error(e.getMessage(), e);
			}
		}
	}
	
	public static void markAsDeletedFiles(String fileList,ActionRequest actionRequest){
		try{
			if (Validator.isNotNull(fileList)) {
				String[] idsArray = fileList.split(",");
				List<Long> fileEntryIds = new ArrayList<Long>();
				for (String id : idsArray) {
					try {
						fileEntryIds.add(Long.parseLong(id));
					} catch (Exception ex) {
						_log.error(ex.getCause(), ex);
					}
				}
				Utils.markFileVersionsAsDelete(fileEntryIds);
				DynamicQuery dynaQuery = DynamicQueryFactoryUtil.forClass(
						DLFileEntry.class,
						PortalClassLoaderUtil.getClassLoader());
				Criterion criterion = RestrictionsFactoryUtil.in(TrademarksConstants.FILE_ENTRY_ID,
						(List) fileEntryIds);
				dynaQuery.add(criterion);
				List<DLFileEntry> filesToReindx = DLFileEntryLocalServiceUtil
						.dynamicQuery(dynaQuery);
				Indexer indexer = IndexerRegistryUtil
						.getIndexer(DLFileEntry.class.getName());
				for (DLFileEntry dlFileEntry : filesToReindx) {
					indexer.reindex(dlFileEntry);
				}
			}
		}catch(Exception ex){
				
		}
	}
	
	public static List<DLFileEntry> getDLFileEntries(String fileName,long parentFolderId){
		DynamicQuery dynaQuery = DynamicQueryFactoryUtil.forClass(
				DLFileEntry.class,
				PortalClassLoaderUtil.getClassLoader());
		Criterion criterion1 = RestrictionsFactoryUtil.eq("folderId",
				parentFolderId);
		Criterion criterion2 = RestrictionsFactoryUtil.ilike("title",
				fileName + "%");
		dynaQuery.add(RestrictionsFactoryUtil.and(criterion1, criterion2));
		List<DLFileEntry> filesToReindx = null;
		try {
			 filesToReindx = DLFileEntryLocalServiceUtil
					.dynamicQuery(dynaQuery);
		} catch (Exception e) {
		}
		if(Validator.isNull(filesToReindx)){
			filesToReindx = new ArrayList<DLFileEntry>();
		}
		return filesToReindx;
	}
	public static String generateExportFileName(PortletRequest request, String prefix, String suffix) {
		ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);
		String tmp = prefix + "_" + System.currentTimeMillis() + "_"
				+ themeDisplay.getUserId() + suffix;
		
		return System.getProperty("java.io.tmpdir") + File.separator + tmp;
	}
	
	public static List<AssetCategory> sortString(List<AssetCategory> list){
		List<AssetCategory> list2 = new ArrayList<AssetCategory>();
		try{
			list2.addAll(list);
			Collections.sort(list2, new AssetCategoryStringComparator());
		}catch(Exception ex){
			
		}
		return list2;
	}
	public static List<AssetCategory> sortInt(List<AssetCategory> list){
		List<AssetCategory> list2 = new ArrayList<AssetCategory>();
		try{
			list2.addAll(list);
			Collections.sort(list2, new AssetCategoryIntComparator());
		}catch(Exception ex){
			
		}
		return list2;
	}
	
	public static void addCategoryNamesToList(long[]catIds,List<String>listOfSearchableToken){
		try{
			for(long catId:catIds){
				String name = getCategoryName(catId);
				if(Validator.isNotNull(name)){
					listOfSearchableToken.add(name);
				}
			}
		}catch(Exception ex){
			
		}
	}
	
	public static boolean checkNonEnglishChars(String str){
		boolean found = false;
		if(Validator.isNotNull(str)){
			for(int i=0; i< str.length();i++){
				if(str.charAt(i) > 879){
					//trademarks.setTrademarkLocalized(paramMap.get(TrademarksConstants.TRADEMARK_LOCALIZED));
					found = true;
					break;
				}
			}
		}
		return found;
	}
	
	public static boolean startsWithNonEnglishChars(String str) {
		boolean found = false;
		if (Validator.isNotNull(str)) {
			if (str.replaceAll("\\p{Punct}", "").charAt(0) > 879) {
				found = true;
			}
		}
		return found;
	}
	
	public static List<Map<String, String>> parseClassCodesJson(String jsonArrayStr, boolean convertNLToBr){
		JSONArray jsonArray = null;
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		Map<String,String>map;
		try{
			jsonArray = JSONFactoryUtil.createJSONArray(jsonArrayStr);
		} catch (Exception e) {
		}
		
		List<JSONObject>jsonlist = new ArrayList<JSONObject>();
		if(Validator.isNotNull(jsonArray)){
			for(int i = 0; i < jsonArray.length(); i++){
				JSONObject obj = jsonArray.getJSONObject(i);
				jsonlist.add(obj);
			}
		}
		try{
			Collections.sort(jsonlist, new ClassCodeIntComparator());
		}catch(Exception ex){
			
		}
		for(int i = 0; i < jsonlist.size(); i++){
			JSONObject obj = jsonlist.get(i);
			map = new HashMap<String, String>();
			map.put(TrademarksConstants.CC_PREFIX, obj.getString(TrademarksConstants.CC_PREFIX));
			String desc = obj.getString(TrademarksConstants.CC_SPEC_PREFIX);
			if(convertNLToBr){
				desc = Utils.toHtmlTags(desc);
			}
			map.put(TrademarksConstants.CC_SPEC_PREFIX, desc);
			map.put("counter", String.valueOf(i));
			list.add(map);			
		}
		
		return list;
	}

	public static List<Map<String, String>> parseRdlJson(String jsonArrayStr,boolean convertNLToBr) {
		JSONArray jsonArray = null;
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		Map<String, String> map;
		try {
			jsonArray = JSONFactoryUtil.createJSONArray(jsonArrayStr);
		} catch (Exception e) {
		}
		
		if(Validator.isNotNull(jsonArray)){
			String remarks ;
			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject obj = jsonArray.getJSONObject(i);
				map = new HashMap<String, String>();
				map.put(LitigationConstants.RESPONSE_DEADLINE, obj.getString(LitigationConstants.RESPONSE_DEADLINE));
				map.put(LitigationConstants.ALERT_BEFORE, Utils.getCategoryName(obj.getLong(LitigationConstants.ALERT_BEFORE)));
				remarks = obj.getString(LitigationConstants.CLAIMS_REMARKS);
				if(convertNLToBr){
					remarks = Utils.toHtmlTags(remarks);
				}
				map.put(LitigationConstants.CLAIMS_REMARKS,remarks );
				Date date = Utils.getDate4rDDMMMYYYY(obj.getString(LitigationConstants.RESPONSE_DEADLINE));
				
				if(Validator.isNotNull(date)){
					DateBean db = getDateBean(date);
					map.put(LitigationConstants.RESPONSE_DEADLINE_DAY, String.valueOf(db.getDate()));
					map.put(LitigationConstants.RESPONSE_DEADLINE_MONTH, String.valueOf(db.getMonth()));
					map.put(LitigationConstants.RESPONSE_DEADLINE_YEAR, String.valueOf(db.getYear()));
				}
				map.put("counter", String.valueOf(i));
				list.add(map);
			}
		}


		return list;
	}

	public static String[] createSearchTokenArray(
			List<String> listOfSearchableToken) {
		String[] arr = new String[listOfSearchableToken.size()];
		int i = 0;
		for (String token : listOfSearchableToken) {
			token = Utils.getIndexFieldValueInLower(token);
			arr[i++] = token;
		}
		return arr;
	}
	
	public static String toHtmlTags(String str){
		String temp = HtmlUtil.escape(GetterUtil.getString(str));
		temp = temp.replaceAll("\\n", "<br/>");
		return temp;
	}
	
	public static void logTheRequest(PortletRequest request, Log log){
		try{
			 if(log.isDebugEnabled()){
				 StringBuilder sb = new StringBuilder();
				 sb.append("********** LOGGING REQUEST OBJECT START **************");
				 sb.append("\n");
				 Enumeration<String>names = request.getParameterNames();
				 while(names.hasMoreElements()){
					 String name = names.nextElement();
					 sb.append(name);
					 sb.append(":");
					 sb.append(request.getParameter(name));
					 sb.append("\n");
				 }
				 
				 sb.append("********** LOGGING REQUEST OBJECT END **************");
				 log.debug(sb.toString());
			 }
		}catch(Exception ex){
			log.error("Error while logging the request object",ex);
		}
	}
}
