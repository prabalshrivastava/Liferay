/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.sambaash.platform.srv.genericsearch.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;

import com.liferay.compat.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.service.PortletPreferencesLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortletKeys;
import com.sambaash.platform.genericsearch.GenericSearchConstants;
import com.sambaash.platform.genericsearch.helper.GSUserProfileHelper;
import com.sambaash.platform.genericsearch.helper.GenericSearchHelper;
import com.sambaash.platform.genericsearch.helper.GSUserProfileHelper.GSUserPESearchRequest;
import com.sambaash.platform.genericsearch.helper.GSUserProfileHelper.GSUserPESearchResponse;
import com.sambaash.platform.genericsearch.helper.GenericSearchHelper.GSSearchItems;
import com.sambaash.platform.genericsearch.model.GenericSearchConfig;
import com.sambaash.platform.genericsearch.model.GenericSearchFilter;
import com.sambaash.platform.srv.genericsearch.model.GSFavourite;
import com.sambaash.platform.srv.genericsearch.service.base.GSFavouriteLocalServiceBaseImpl;
import com.sambaash.platform.srv.spsocialprofile.model.SocialProfile;

/**
 * The implementation of the g s favourite local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sambaash.platform.srv.genericsearch.service.GSFavouriteLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author nareshchebolu
 * @see com.sambaash.platform.srv.genericsearch.service.base.GSFavouriteLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.genericsearch.service.GSFavouriteLocalServiceUtil
 */
public class GSFavouriteLocalServiceImpl extends GSFavouriteLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.sambaash.platform.srv.genericsearch.service.GSFavouriteLocalServiceUtil} to access the g s favourite local service.
	 */
	
	public static final Log _log = LogFactoryUtil.getLog(GSFavouriteLocalServiceImpl.class);
	public static final String USER_TYPE = "userType";
	public static final String COURSE_NAME = "courseName";
	public static final String COUNTRY_OF_RESIDENCE = "countryOfResidence";
	public static final String DOB = "dob";
	
	public List<GSFavourite> findByCreatedBy(long userId) throws SystemException{
		return gsFavouritePersistence.findBycreatedBy(userId);
	}
	public List<GSFavourite> findPrivateFavourites(long userId,long layoutId) throws SystemException{
		return gsFavouritePersistence.findBycreatedByLayoutIdPermissionType(userId, layoutId, GenericSearchConstants.PERMISSIONTYPE_PRIVATE);
	}
	public List<GSFavourite> findGlobalFavourites(long layoutId) throws SystemException{
		return gsFavouritePersistence.findByLayoutIdPermissionType( layoutId, GenericSearchConstants.PERMISSIONTYPE_GLOBAL);
	}
	public List<GSFavourite> findAll(long userId,long layoutId) throws SystemException{
		List<GSFavourite>list = new ArrayList<GSFavourite>();
		list.addAll(findPrivateFavourites(userId,layoutId));
		list.addAll(findGlobalFavourites(layoutId));
		return list;
	}
	
	public List<Document> getResults(GSFavourite fav,int start, int end){
		GenericSearchHelper helper = new GenericSearchHelper();
		try {
			return helper.search(fav, start, end);
		} catch (Exception e) {
			_log.error(e);
		}
		return null;
	}
	
	public GSFavourite create() throws SystemException {
		GSFavourite gsf = gsFavouritePersistence.create(counterLocalService
				.increment("GSFavourite"));
		return gsf;
	}
	
	public List<Document> searchByFavourite(int start, int end, GSFavourite gsFavourite){
		List<Document> resultDocs = null;
		try {
		
		String [] USER_FIELDS = {USER_TYPE,COURSE_NAME,COUNTRY_OF_RESIDENCE,DOB};
		boolean returnAllDocs = true;
		GenericSearchHelper.GSSearchItems searchItems;
		
			searchItems = getSearchItems(gsFavourite);
		
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
			resultDocs = searchNew(gsFavourite, start, end);
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
			resultDocs = searchNew(gsFavourite, start, end);
		}
		
		// 4. Check if only process engine filters exists
		if(peFilters.length() > 0 && usrFilters.length() == 0 && !extraUsrFilter){
			GSUserPESearchRequest searchRequest = buildUsrProfileSearchRequest(gsFavourite);
			GSUserProfileHelper helper = new GSUserProfileHelper();
			GSUserPESearchResponse searchResponse = helper.searchUsingPEFilersOnly(searchRequest, peFilters,searchItems.getSortParams(),true);
			// few parameteres like startIndex,processedUserIds needs to be preserved for next request
			//req.setAttribute(GenericSearchConstants.ATTRIB_USER_SEARCH_RESPONSE, searchResponse);
			resultDocs = searchResponse.getDocs();
		}
		
		//5. Check if both process engine and user profile filters selected
		if(peFilters.length() > 0 && (usrFilters.length() > 0 || extraUsrFilter)){
			GSUserPESearchRequest searchRequest = buildUsrProfileSearchRequest(gsFavourite);
			GSUserProfileHelper helper = new GSUserProfileHelper();
			GSUserPESearchResponse searchResponse = helper.searchUsingUsrAndPEFilters(searchRequest, usrFilters,peFilters,returnAllDocs);
			// few parameteres like startIndex needs to be preserved for next request
			//req.setAttribute(GenericSearchConstants.ATTRIB_USER_SEARCH_RESPONSE, searchResponse);
			resultDocs = searchResponse.getDocs();
		}
		
		} catch (Exception e) {
			_log.error(e);
		}
		return resultDocs;
		
	}
	
	
	private GSSearchItems getSearchItems(GSFavourite favourite) throws JSONException{
		String searchItemsStr = favourite.getConfig();
		JSONObject searchItemsJson = JSONFactoryUtil.createJSONObject(searchItemsStr);
		String[] classes = {SocialProfile.class.getCanonicalName()};
		GenericSearchHelper.GSSearchItems searchItems = new GenericSearchHelper.GSSearchItems(searchItemsJson,classes);
		return searchItems;
	}
	
	private List<Document> searchNew(GSFavourite favourite, int start, int end) throws Exception {
		String[] classes = {SocialProfile.class.getCanonicalName()};
		if (ArrayUtil.isEmpty(classes) || (classes.length == 1 && ArrayUtil.contains(classes, StringPool.BLANK))) {
			return null;
		}
		GenericSearchHelper.GSSearchItems searchItems = getSearchItems(favourite);
		GenericSearchHelper helper = new GenericSearchHelper();
		PortletPreferences prefs = PortletPreferencesLocalServiceUtil.fetchPreferences(favourite.getCompanyId(),PortletKeys.PREFS_OWNER_ID_DEFAULT, PortletKeys.PREFS_OWNER_TYPE_LAYOUT, favourite.getLayoutId(), favourite.getPortletInstanceId());
		GenericSearchConfig config = helper.parseConfiguration(prefs);
		return helper.search(favourite.getCompanyId(), favourite.getGroupId(), start, end, config, searchItems);
	}
	
	private GSUserPESearchRequest buildUsrProfileSearchRequest(GSFavourite favourite) throws JSONException{
		
		int startIndex = 0;
		int itemsPerPage = 0;
		String searchItemsStr = favourite.getConfig();
		JSONObject searchItemsJson = JSONFactoryUtil.createJSONObject(searchItemsStr); 
		GSUserPESearchRequest searchRequest = new  GSUserProfileHelper.GSUserPESearchRequest(favourite.getCompanyId(),
				favourite.getGroupId(),startIndex,itemsPerPage);
		searchRequest.setSearchItems(searchItemsJson);
		
		return searchRequest;
	}
}