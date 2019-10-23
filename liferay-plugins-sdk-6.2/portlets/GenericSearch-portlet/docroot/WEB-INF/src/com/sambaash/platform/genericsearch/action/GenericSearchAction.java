package com.sambaash.platform.genericsearch.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.liferay.compat.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.servlet.HttpHeaders;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.JavaConstants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.security.auth.AuthTokenUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.model.AssetVocabulary;
import com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetVocabularyLocalServiceUtil;
import com.liferay.portlet.dynamicdatamapping.NoSuchTemplateException;
import com.liferay.portlet.dynamicdatamapping.service.DDMTemplateLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.sambaash.platform.genericsearch.GenericSearchConstants;
import com.sambaash.platform.genericsearch.helper.GSUserProfileHelper;
import com.sambaash.platform.genericsearch.helper.GSUserProfileHelper.GSUserPESearchRequest;
import com.sambaash.platform.genericsearch.helper.GSUserProfileHelper.GSUserPESearchResponse;
import com.sambaash.platform.genericsearch.helper.GenericSearchFavouriteHelper;
import com.sambaash.platform.genericsearch.helper.GenericSearchHelper;
import com.sambaash.platform.genericsearch.helper.GenericSearchHelper.GSSearchItems;
import com.sambaash.platform.genericsearch.model.GenericSearchConfig;
import com.sambaash.platform.genericsearch.model.GenericSearchFilter;
import com.sambaash.platform.model.Candidate;
import com.sambaash.platform.model.Programme;
import com.sambaash.platform.srv.spsocialprofile.model.SocialProfile;
import com.sambaash.platform.systemmodelsetup.service.SystemLocalServiceUtil;
import com.sambaash.platform.util.LabelUtil;
import com.sambaash.platform.util.wrapper.HttpServletRequestWrapperExtended;

/**
 * Portlet implementation class GenericSearchAction
 */
public class GenericSearchAction extends MVCPortlet {

	private static final Log logger = LogFactoryUtil.getLog(GenericSearchAction.class);

	private static String error = "error";
	private static String formStorageId = "formStorageId";
	private static String formType = "formType";
	private static String sortBy = "sortBy";
	private static String restUriGet = "/get/";
	private static String restUriSize = "&size=";
	private static String requestURL = "Request URL";
	private static String restUriContentType = "ContentType:";
	private static String restUriLimit = "limit";
	
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		String loadObjects = ParamUtil.getString(renderRequest, GenericSearchConstants.PARAM_LOAD_OBJECTS);

		GenericSearchConfig config = readConfig(renderRequest, themeDisplay);

		if (Validator.isNotNull(loadObjects)) {
			if (logger.isDebugEnabled())
				logger.debug("Starting to search");
			try {
				String[] enabledComponentClasses = GenericSearchHelper.getEnabledComponentClasses(renderRequest);
				
				if(enabledComponentClasses.length == 1 && enabledComponentClasses[0].split("\\.").length == 1){
					JSONArray documents = searchNewEMS(renderRequest, themeDisplay, config, false);
					loadEMSObjectsForView(documents, renderRequest, renderResponse);
					
				}else{
					List<Document> documents = determineAndSearch(renderRequest, themeDisplay, config, false);
					loadObjectsForView(documents, renderRequest, renderResponse);
				}
				
				if (logger.isDebugEnabled())
					logger.debug("End Search");
				return;
			} catch (Exception e) {
				logger.error("Error while loading objects", e);
			}
		}

		HttpServletRequest httpReq = PortalUtil
				.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest));
		String searchText = ParamUtil.getString(httpReq, "searchText");
		renderRequest.setAttribute("searchText", searchText);

		addInitialVocabularySearchToRequest(themeDisplay.getScopeGroupId(), renderRequest, httpReq);
		
		super.doView(renderRequest, renderResponse);
	}

	private void addInitialVocabularySearchToRequest(long groupId,
			RenderRequest renderRequest, HttpServletRequest httpReq) {
		String vocName = ParamUtil.getString(httpReq, GenericSearchConstants.SEARCH_VOCABULARY_NAME);
		String catName = ParamUtil.getString(httpReq, GenericSearchConstants.SEARCH_CATEGORY_NAME);
		if (StringUtils.isNotEmpty(vocName) && StringUtils.isNotEmpty(catName)) {
			long vocabId = -1, catId = -1;
			try {
				AssetVocabulary vocab = AssetVocabularyLocalServiceUtil.getGroupVocabulary(groupId, vocName);
				vocabId = vocab.getVocabularyId();
				for (AssetCategory cat: AssetCategoryLocalServiceUtil.getVocabularyCategories(vocabId, -1, -1, null)) {
					if (catName.equalsIgnoreCase(cat.getName())) {
						catId = cat.getCategoryId();
					}
				}
				renderRequest.setAttribute(GenericSearchConstants.SEARCH_VOCABULARY_NAME, String.valueOf(vocabId));
				renderRequest.setAttribute(GenericSearchConstants.SEARCH_CATEGORY_NAME, String.valueOf(catId));			
			} catch (Exception e) {
				logger.error(String.format("Unable to find vocabulary [%s] and category [%s]", vocName, catName));
			}
		}
	}

	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException {
		HttpServletRequestWrapper httpRequest = new HttpServletRequestWrapperExtended(
				PortalUtil.getHttpServletRequest(resourceRequest));
		JSONObject obj = JSONFactoryUtil.createJSONObject();
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		PortletConfig portletConfig = (PortletConfig) resourceRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
		try {
			AuthTokenUtil.checkCSRFToken(httpRequest, GenericSearchAction.class.getName());
		} catch (PortalException e1) {
			obj.put(GenericSearchConstants.RESP_MSG, LabelUtil.getLabel(portletConfig,themeDisplay,"label.error.auth.token"));
			logger.error("Invalid auth token", e1);
			resourceResponse.getWriter().append(obj.toString());
			return;
		}
		// only 1 action as of now.
		String action = ParamUtil.getString(resourceRequest, "action");
		if ("getFilters".equals(action)) {
			GenericSearchHelper helper = new GenericSearchHelper();
			GenericSearchConfig config = helper.parseConfiguration(resourceRequest.getPreferences());
			resourceResponse.getWriter().append(JSONFactoryUtil.serialize(config.getFilters()));
		} else if ("getSorts".equals(action)) {
			PortletPreferences preferences = resourceRequest.getPreferences();
			String defaultOption = preferences.getValue("sort--default", null);
			List<Map<String, String>> sorts = new ArrayList<Map<String, String>>();
			for (Entry<String, String[]> entry : preferences.getMap().entrySet()) {
				if (!entry.getKey().startsWith("sort--type--"))
					continue;
				String rowId = entry.getKey().replaceAll("sort--type--", StringPool.BLANK);
				if (rowId.equals("rowID"))
					continue;
				String label = preferences.getValue("sort--label--" + rowId, null);
				if (Validator.isNull(label))
					continue;

				// field
				String field = preferences.getValue("sort--field--" + rowId, null);
				// string/long
				String fieldType = preferences.getValue("sort--field--type--" + rowId, "3");
				Boolean isSelected = false;

				if (field.equals(defaultOption))
					isSelected = true;

				Map<String, String> dataMap = new HashMap<String, String>();
				dataMap.put("field", field);
				dataMap.put("label", label);
				dataMap.put("fieldType", fieldType);
				dataMap.put("type", entry.getValue()[0]);
				dataMap.put("sortDefault", String.valueOf(isSelected));
				sorts.add(dataMap);
			}
			resourceResponse.getWriter().append(JSONFactoryUtil.serialize(sorts));
		} else if ("exportResults".equals(action)) {
			try {
				GenericSearchHelper helper = new GenericSearchHelper();
				GenericSearchConfig config = readConfig(resourceRequest, themeDisplay);
				List<Document> docs = searchNew(resourceRequest, themeDisplay, config, true);
				XSSFWorkbook workbook = helper.generateReport(resourceRequest, themeDisplay, docs);
				if (Validator.isNull(workbook)) {
					throw new NullPointerException("Workbook generated is null");
				} else {

					resourceResponse
							.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
					resourceResponse.addProperty(HttpHeaders.CACHE_CONTROL, "max-age=3600, must-revalidate");
					resourceResponse.addProperty("Content-Disposition", "attachment; filename=\"Export_"
							+ DateUtil.getCurrentDate("MMM-dd-yyyy-hhmmss", themeDisplay.getLocale()) + ".xlsx\"");
					workbook.write(resourceResponse.getPortletOutputStream());
				}
			} catch (Exception e) {
				logger.error("Error while generating report", e);
				resourceResponse.setProperty(resourceResponse.HTTP_STATUS_CODE, 501 + "");
			}
		} else if ("saveFavourite".equals(action)){
			JSONObject data = GenericSearchFavouriteHelper.createUpdateFavourite(resourceRequest);
			resourceResponse.getWriter().append(data.toString());
		} else if ("saveFavouriteConfig".equals(action)){
			JSONObject data = GenericSearchFavouriteHelper.updateFavouriteConfig(resourceRequest);
			resourceResponse.getWriter().append(data.toString());
		}else if ("deleteFavourite".equals(action)){
			JSONObject data = GenericSearchFavouriteHelper.deleteFavourite(resourceRequest);
			resourceResponse.getWriter().append(data.toString());
		} else {
			
			String componentClass = ParamUtil.getString(resourceRequest, "compClass");
			int length = componentClass.split("\\.").length;
			if(length == 1){
				List<String> columns = SystemLocalServiceUtil.getMicroserviceModelColumnList(resourceRequest,componentClass);
				StringBuilder builder = new StringBuilder();
				for (String entry : columns) {
					builder.append("<option value='" + entry + "' data-row-identifier='" + componentClass + "_"
							+ entry + "'>" + entry + "</option>\n");
				}
				obj.put("options", builder.toString());
				resourceResponse.getWriter().append(obj.toString());
			}
			else{
				try {
					Indexer indexer = IndexerRegistryUtil.getIndexer(componentClass);
					Map<String, String> indexedFields = indexer.getIndexedFields();
					StringBuilder builder = new StringBuilder();
					for (Entry<String, String> entry : indexedFields.entrySet()) {
						builder.append("<option value='" + entry.getKey() + "' data-row-identifier='" + componentClass + "_"
								+ entry.getKey() + "'>" + entry.getValue() + "</option>\n");
					}
					obj.put("options", builder.toString());
					resourceResponse.getWriter().append(obj.toString());
				} catch (Exception e) {
					obj.put(GenericSearchConstants.RESP_MSG, LabelUtil.getLabel(portletConfig,themeDisplay,"label.error.index.fields"));
					logger.error("Error getting indexed fields", e);
					resourceResponse.getWriter().append(obj.toString());
				}
			}
			
			
			
		}
	}

	private GenericSearchConfig readConfig(PortletRequest renderRequest, ThemeDisplay themeDisplay) {
		GenericSearchHelper helper = new GenericSearchHelper();
		String[] enabledComponentClasses = GenericSearchHelper.getEnabledComponentClasses(renderRequest);
		GenericSearchConfig config = null;
		if (enabledComponentClasses != null && enabledComponentClasses.length > 0) {
			config = helper.parseConfiguration(renderRequest.getPreferences());
			renderRequest.setAttribute(GenericSearchConstants.ATTRIB_CONFIG_OBJ, config);
		}
		return config;
	}

	// Constants taken from SocialProfileIndexer
	public static final String USER_TYPE = "userType";
	public static final String COURSE_NAME = "courseName";
	public static final String COUNTRY_OF_RESIDENCE = "countryOfResidence";
	public static final String DOB = "dob";

	public static final String PROFILE_TAGGING = "profileTagging";

	public static final String PERSONA = "persona";
	public static final String SUB_PERSONA = "subPersona";


	/**
	 * This method first check's if the search is configured with only Social Profile
	 *  If the search is configured with social profile with some process engine data, 
	 *  then cusotm search logic will be invoked
	 *    -- From liferay there is  not support to handle parent and child (one to many relation) relation. Hence custom logic has to be placed.
	 *    -- There will be 3 cases can happen when user is doing search
	 *           - Only User profile filters selected  : In this case usual generic search logic will be invoked
	 *           - Only Process Engine filters selected : In this case, Process indexer will be queried  ( Using generic search ) then corresponding user documents will be fetched
	 *           - Both user profile filters and process engine filters selected : In this case, user profile indexer queried(using generic search) then processengine filters will be applied on users retrieved   
	 * If the search is not configured with Social profile then usual generics search will be invoked 
	 * @param req
	 * @param themeDisp
	 * @param config
	 * @param returnAllDocs
	 * @return
	 * @throws Exception
	 */
	private List<Document> determineAndSearch(PortletRequest req, ThemeDisplay themeDisp, GenericSearchConfig config,
			Boolean returnAllDocs) throws Exception {
		String[] classes = GenericSearchHelper.getEnabledComponentClasses(req);
		//1. Check if it user profile search
		if(classes.length == 1 && classes[0].indexOf(SocialProfile.class.getName()) != -1){
			
			String []USER_FIELDS = {USER_TYPE,COURSE_NAME,COUNTRY_OF_RESIDENCE,DOB,PERSONA,SUB_PERSONA};
			
			GenericSearchHelper.GSSearchItems searchItems = getSearchItems(req);
			JSONArray tempItems = searchItems.getSearchItems();
			JSONArray searchItemsArray = JSONFactoryUtil.createJSONArray();
			
			// Filter the age range if it configured the fourth param (exclude if min and max are default)
			for(int i = 0 ; i < tempItems.length() ; i++){
				JSONObject item = tempItems.getJSONObject(i);
				if(GenericSearchFilter.SELECT_AGERANGE.equalsIgnoreCase(item.getString(GenericSearchConstants.KEY_SECTION_TYPE_KEY))){
					String params = item.getString(GenericSearchConstants.KEY_VALUE);
					String values[] = StringUtil.split(params, StringPool.COMMA);
					if(values.length == 5 && GetterUtil.getBoolean(values[4]) == false){
						int selectedMin = (int) GetterUtil.getDouble(values[0]);
						int selectedMax = (int) GetterUtil.getDouble(values[1]);
						int defaultMin = GetterUtil.getInteger(values[2]);
						int defaultMax = GetterUtil.getInteger(values[3]);
						if(selectedMin == defaultMin && selectedMax == defaultMax){
							//ignore.. dont keep the element
						}else{
							searchItemsArray.put(item);
						}
					}else{
						searchItemsArray.put(item);
					}
				}else{
					searchItemsArray.put(item);
				}
			}
		
			// No filters selected. So go ahead with normal search
			if(searchItemsArray.length() == 0){
				return searchNew(req, themeDisp, config, returnAllDocs);
			}
			
			// 2. Differentiate the process engine filters and User Profile filters
			JSONArray usrFilters = JSONFactoryUtil.createJSONArray();
			JSONArray peFilters = JSONFactoryUtil.createJSONArray();
			
			for(int index = 0 ; index < searchItemsArray.length(); index++){
				JSONObject filter = searchItemsArray.getJSONObject(index);
				String field = filter.getString(GenericSearchConstants.KEY_TYPE_KEY);
				if(ArrayUtil.contains(USER_FIELDS, field)){
					usrFilters.put(filter);
				}else{
					peFilters.put(filter);
				}
			}
			boolean extraUsrFilter = false;
			if(Validator.isNotNull(searchItems.getSearchText()) || Validator.isNotNull(searchItems.getStartDate()) || Validator.isNotNull(searchItems.getEndDate())){
				extraUsrFilter = true;
			}
			
			// 3. Check if only if user profile filters exists.. go ahead with normal search
			if(peFilters.length() == 0 && usrFilters.length() > 0 ){
				return searchNew(req, themeDisp, config, returnAllDocs);
			}
			
			// 4. Check if only process engine filters exists
			if(peFilters.length() > 0 && usrFilters.length() == 0 && !extraUsrFilter){
				GSUserPESearchRequest searchRequest = buildUsrProfileSearchRequest(req);
				GSUserProfileHelper helper = new GSUserProfileHelper();
				GSUserPESearchResponse searchResponse = helper.searchUsingPEFilersOnly(searchRequest, peFilters,searchItems.getSortParams(),returnAllDocs);
				// few parameteres like startIndex,processedUserIds needs to be preserved for next request
				req.setAttribute(GenericSearchConstants.ATTRIB_USER_SEARCH_RESPONSE, searchResponse);
				return searchResponse.getDocs();
			}
			
			//5. Check if both process engine and user profile filters selected
			if(peFilters.length() > 0 && (usrFilters.length() > 0 || extraUsrFilter)){
				GSUserPESearchRequest searchRequest = buildUsrProfileSearchRequest(req);
				GSUserProfileHelper helper = new GSUserProfileHelper();
				GSUserPESearchResponse searchResponse = helper.searchUsingUsrAndPEFilters(searchRequest, usrFilters,peFilters,returnAllDocs);
				// few parameteres like startIndex needs to be preserved for next request
				req.setAttribute(GenericSearchConstants.ATTRIB_USER_SEARCH_RESPONSE, searchResponse);
				return searchResponse.getDocs();
			}
			
		}else{
			return searchNew(req, themeDisp, config, returnAllDocs);
		}
		
		return null;
		
	}
	private GSUserPESearchRequest buildUsrProfileSearchRequest(PortletRequest request) throws JSONException{
		ThemeDisplay themeDisp = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);
		int startIndex = ParamUtil.getInteger(request, "usrStartIndex");
		JSONArray processesdUserIds = JSONFactoryUtil.createJSONArray(ParamUtil.getString(request, "processesdUserIds"));
		String searchItemsStr = ParamUtil.getString(request, GenericSearchConstants.ATTRIB_SEARCH_ITEMS);
		JSONObject searchItemsJson = JSONFactoryUtil.createJSONObject(searchItemsStr); 
		
		PortletPreferences preferences = request.getPreferences();
		int itemsPerPage = GetterUtil
				.getInteger(preferences.getValue(GenericSearchConstants.PREF_ITEMS_PER_PAGE, StringPool.BLANK));
		
		GSUserPESearchRequest searchRequest = new  GSUserProfileHelper.GSUserPESearchRequest(themeDisp.getCompanyId(),
				themeDisp.getScopeGroupId(),startIndex,itemsPerPage);
		searchRequest.setProcessedUserIds(processesdUserIds).setSearchItems(searchItemsJson);
		
		return searchRequest;
	}
	private List<Document> searchNew(PortletRequest req, ThemeDisplay themeDisp, GenericSearchConfig config,
			Boolean returnAllDocs) throws Exception {
		String[] classes = GenericSearchHelper.getEnabledComponentClasses(req);
		PortletPreferences preferences = req.getPreferences();
		
		if (ArrayUtil.isEmpty(classes) || (classes.length == 1 && ArrayUtil.contains(classes, StringPool.BLANK))) {
			return null;
		}
		int start = -1;
		int end = -1;
		if (!returnAllDocs) {
			int itemsPerPage = GetterUtil
					.getInteger(preferences.getValue(GenericSearchConstants.PREF_ITEMS_PER_PAGE, StringPool.BLANK));
			int pageNo = GetterUtil.getInteger(ParamUtil.getInteger(req, GenericSearchConstants.ATTRIB_SEARCH_PAGE), 0);
			
			start = itemsPerPage * pageNo;
			end = start + itemsPerPage;
		}
		GenericSearchHelper.GSSearchItems searchItems = getSearchItems(req);
		GenericSearchHelper helper = new GenericSearchHelper();
		return helper.search(themeDisp.getCompanyId(), themeDisp.getScopeGroupId(), start, end, config, searchItems);
	}
	private JSONArray searchNewEMS(PortletRequest req, ThemeDisplay themeDisp, GenericSearchConfig config,Boolean returnAllDocs) throws Exception {
		String[] classes = GenericSearchHelper.getEnabledComponentClasses(req);
		PortletPreferences preferences = req.getPreferences();
		
		if (ArrayUtil.isEmpty(classes) || (classes.length == 1 && ArrayUtil.contains(classes, StringPool.BLANK))) {
			return null;
		}
		int start = -1;
		int end = -1;
		if (!returnAllDocs) {
			int itemsPerPage = GetterUtil.getInteger(preferences.getValue(GenericSearchConstants.PREF_ITEMS_PER_PAGE, StringPool.BLANK));
			int pageNo = GetterUtil.getInteger(ParamUtil.getInteger(req, GenericSearchConstants.ATTRIB_SEARCH_PAGE), 0);
			
			start = itemsPerPage * pageNo;
			end = start + itemsPerPage;
		}
		GenericSearchHelper.GSSearchItems searchItems = getSearchItems(req);
		GenericSearchHelper helper = new GenericSearchHelper();
		return helper.searchEMS(req,themeDisp.getCompanyId(), themeDisp.getScopeGroupId(), start, end, config, searchItems);
	}
	public JSONArray searchEMS(PortletRequest req,long companyId,long scropeGroupId,int start, int end,GenericSearchConfig config,GSSearchItems searchItems) throws Exception {

		JSONArray responseArray = JSONFactoryUtil.createJSONArray();
		JSONObject jsonElasticSearchQuery = JSONFactoryUtil.createJSONObject();
		String response = null;
		String subUrl = "";
		try {
			
				//JSONObject jsonModelData = JSONFactoryUtil.createJSONObject(data);
				String limit = "10";
				String model = searchItems.getComonentClasses()[0].toLowerCase();
				String page = "1";
				String conditions = "";
				JSONArray filters = JSONFactoryUtil.createJSONArray();
				subUrl = model + "/elasticsearch?" + "page=" + page + restUriSize + limit;
				String jsonString1 = "";
				JSONArray jsonTerms = JSONFactoryUtil.createJSONArray();
				if(!conditions.equalsIgnoreCase("")){
					jsonString1 ="{" + "\"query_string\": {" + "\"query\": \"" + conditions + "\"" + "}" + "}";
					JSONObject jsonQuery = JSONFactoryUtil.createJSONObject(jsonString1);
					
					jsonTerms.put(jsonQuery);
				}
				
				
				if (filters != null) {
					for (int index=0; index< filters.length(); index++){
						JSONObject term=filters.getJSONObject(index);
						 Iterator<String> keys = term.keys();
						    while(keys.hasNext()){
						        String key = keys.next();
						        String value = term.getString(key);
						        String jsonString2 = "{" + "\"terms\": {" + "\""+key+".keyword\": [\"" + value + "\"]" + "}" + "}";
						        JSONObject jsonTermQuery = JSONFactoryUtil
										.createJSONObject(jsonString2);
						        jsonTerms.put(jsonTermQuery);
						        }
	
					}
				}
				JSONObject jsonMustClause =JSONFactoryUtil.createJSONObject();
				if (filters.length() > 0 || !conditions.isEmpty()){
					jsonMustClause.put("must", jsonTerms);
				}
				jsonElasticSearchQuery.put("bool", jsonMustClause);
				logger.debug("Posting with requestbody" + jsonElasticSearchQuery.toString());
				
				
		} catch (Exception e) {
			logger.error(e);
			response = error;
		}
		ThemeDisplay td  =(ThemeDisplay)req.getAttribute(WebKeys.THEME_DISPLAY);
		response = SystemLocalServiceUtil.fetchElasticRecordsForGenericSearch(td.getUserId(),td.getScopeGroupId(),jsonElasticSearchQuery.toString(), subUrl);
		JSONObject responseObject = JSONFactoryUtil.createJSONObject(response);
		responseArray = responseObject.getJSONArray("content");
		return responseArray;
		
		
	}

	private GSSearchItems getSearchItems(PortletRequest request) throws JSONException{
		String searchItemsStr = ParamUtil.getString(request, GenericSearchConstants.ATTRIB_SEARCH_ITEMS);
		JSONObject searchItemsJson = JSONFactoryUtil.createJSONObject(searchItemsStr);
		String[] classes = GenericSearchHelper.getEnabledComponentClasses(request);
		
		GenericSearchHelper.GSSearchItems searchItems = new GenericSearchHelper.GSSearchItems(searchItemsJson,classes);
		return searchItems;
	}
	private void loadObjectsForView(List<Document> documents, RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		if (Validator.isNull(documents) || documents.size() == 0) {
			renderResponse.getWriter().write("<div id='generic-search-no-more-results'>No More Results</div>");
			return;
		}
		PortletPreferences preferences = renderRequest.getPreferences();

		int itemsPerPage = GetterUtil
				.getInteger(preferences.getValue(GenericSearchConstants.PREF_ITEMS_PER_PAGE, StringPool.BLANK));
		int pageNo = GetterUtil
				.getInteger(ParamUtil.getInteger(renderRequest, GenericSearchConstants.ATTRIB_SEARCH_PAGE), 0);
		Integer start = itemsPerPage * pageNo;
		String key = StringPool.BLANK;
		for (Document document : documents) {
			try {
				// The template for Social Profile is created using User class, so we are using the user class for fetching template for social profile
//				if(document.get(Field.ENTRY_CLASS_NAME).equalsIgnoreCase(SocialProfile.class.getCanonicalName())){
//					key = "displayStyle--" + User.class.getCanonicalName();
//				}else{
					key = "displayStyle--" + document.get(Field.ENTRY_CLASS_NAME);
				//}
				//	logger.error("selected class " + key);
				Long selectedTemplateId = GetterUtil.getLong(preferences.getValue(key, null));
				// check if exists
				DDMTemplateLocalServiceUtil.getTemplate(selectedTemplateId);
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("document", document);
				map.put("gsfIndex", ++start);

				renderRequest.setAttribute(Field.ENTRY_CLASS_NAME, document.get(Field.ENTRY_CLASS_NAME));
				renderRequest.setAttribute(GenericSearchConstants.ATTRIB_RESULT_TEMPLATE_ID, selectedTemplateId);
				renderRequest.setAttribute(GenericSearchConstants.ATTRIB_RESULT_LIST, new ArrayList());
				renderRequest.setAttribute(GenericSearchConstants.ATTRIB_RESULT_MAP, map);
				include("/html/view/view-single-result.jsp", renderRequest, renderResponse);
			} catch (NoSuchTemplateException e) {
				logger.error("Missing/Invalid template selected for " + document.get(Field.ENTRY_CLASS_NAME));
			} catch (Exception e) {
				logger.error("Error while converting to templates", e);
			}
		}
		
		GSUserPESearchResponse usrSearchResponse = (GSUserPESearchResponse) renderRequest.getAttribute(GenericSearchConstants.ATTRIB_USER_SEARCH_RESPONSE);
		if(usrSearchResponse != null){
			include("/html/view/usersearchinfo.jsp", renderRequest, renderResponse);
		}
	}
	private void loadEMSObjectsForView(JSONArray documents, RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		if (Validator.isNull(documents) || documents.length() == 0) {
			renderResponse.getWriter().write("<div id='generic-search-no-more-results'>No More Results</div>");
			return;
		}
		PortletPreferences preferences = renderRequest.getPreferences();

		int itemsPerPage = GetterUtil
				.getInteger(preferences.getValue(GenericSearchConstants.PREF_ITEMS_PER_PAGE, StringPool.BLANK));
		int pageNo = GetterUtil
				.getInteger(ParamUtil.getInteger(renderRequest, GenericSearchConstants.ATTRIB_SEARCH_PAGE), 0);
		Integer start = itemsPerPage * pageNo;
		String key = StringPool.BLANK;
		String[] enabledComponentClasses = GenericSearchHelper.getEnabledComponentClasses(renderRequest);
		JSONObject document = JSONFactoryUtil.createJSONObject();
		
		for (int i = 0; i < documents.length(); i++) {
			try {
				key = "displayStyle--" + enabledComponentClasses[0];
				document = documents.getJSONObject(i); 
				
				Long selectedTemplateId = GetterUtil.getLong(preferences.getValue(key, null));
				// check if exists
				DDMTemplateLocalServiceUtil.getTemplate(selectedTemplateId);
				Map<String, Object> map = new HashMap<String, Object>();
				
				if(enabledComponentClasses[0].equalsIgnoreCase("candidate")){
					Candidate candidate = new Candidate(document.toString());
					map.put("document",candidate);
				}else if(enabledComponentClasses[0].equalsIgnoreCase("programme")){
					Programme programme = new Programme(document.toString());
					map.put("document",programme);
					
				}
				
				map.put("gsfIndex", ++start);
				
				renderRequest.setAttribute(Field.ENTRY_CLASS_NAME, "com.sambaash.platform.model."+enabledComponentClasses[0]);
				renderRequest.setAttribute(GenericSearchConstants.ATTRIB_RESULT_TEMPLATE_ID, selectedTemplateId);
				renderRequest.setAttribute(GenericSearchConstants.ATTRIB_RESULT_LIST, new ArrayList());
				renderRequest.setAttribute(GenericSearchConstants.ATTRIB_RESULT_MAP, map);
				include("/html/view/view-single-result.jsp", renderRequest, renderResponse);
			} catch (NoSuchTemplateException e) {
				logger.error("Missing/Invalid template selected for ");
			} catch (Exception e) {
				logger.error("Error while converting to templates", e);
			}
		}
		
		GSUserPESearchResponse usrSearchResponse = (GSUserPESearchResponse) renderRequest.getAttribute(GenericSearchConstants.ATTRIB_USER_SEARCH_RESPONSE);
		if(usrSearchResponse != null){
			include("/html/view/usersearchinfo.jsp", renderRequest, renderResponse);
		}
	}

}
