package com.sambaash.platform.announcement.helper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Country;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.User;
import com.liferay.portal.service.CountryServiceUtil;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.sambaash.platform.srv.model.Product;
import com.sambaash.platform.srv.processbuilder.model.PEProcessStage;
import com.sambaash.platform.srv.processbuilder.service.PEProcessStageLocalServiceUtil;
import com.sambaash.platform.srv.service.ProductLocalServiceUtil;

public class GenericSearchAPIHelper {
	
	private static final Log log = LogFactoryUtil.getLog(GenericSearchAPIHelper.class);
	private long companyId;

	public GenericSearchAPIHelper(long companyId){
		this.companyId = companyId;
	}
	public Map<String, String> getAPIData(String key,String settings){
		switch(key){
			case GenericSearchAPIRegistry.USERS_FOR_ROLES:  
				return getUsersForRoles(settings);
			case GenericSearchAPIRegistry.PRODUCTS:
				return getProducts();
			case GenericSearchAPIRegistry.PE_STAGES:
				return getStages(settings);
			case GenericSearchAPIRegistry.CUSTOM_DATA:
				return getCustomizedData(settings);
			case GenericSearchAPIRegistry.COUNTRIES_FROM_DB:
				return getCountriesFrmDb(settings);
		}
		
		return null;
	}
	
	public Map<String,String> getCustomizedData(String settings){
		Map<String,String>map = new LinkedHashMap<String, String>();
		if(Validator.isNotNull(settings)){
			try {
					JSONArray array = JSONFactoryUtil.createJSONArray(settings);
					for(int i = 0 ; i < array.length() ; i++){
						JSONObject obj = array.getJSONObject(i);
						map.put(obj.getString("key"), obj.getString("value"));
					}
			}catch(Exception e){
				log.error(e);
			}
		}
		
		return map;
	}
	public Map<String,String> getCountriesFrmDb(String settings){
		Map<String,String>map = new LinkedHashMap<String, String>();
		try {
			List<Country> countries = CountryServiceUtil.getCountries(true);
			for(Country country : countries){
				map.put(String.valueOf(country.getCountryId()), country.getName(Locale.US));
			}
		}catch(Exception e){
			log.error(e);
		}
			
		return map;
	}
	
	public Map<String,String> getUsersForRoles(String settings){
		Map<String,String>map = new LinkedHashMap<String, String>();
		if(Validator.isNotNull(settings)){
			try {
				JSONObject jsonObj = JSONFactoryUtil.createJSONObject(settings);
				JSONArray roleNames = JSONFactoryUtil.createJSONArray(jsonObj.getString("roleNames"));
				JSONArray userIdsToExclude = JSONFactoryUtil.createJSONArray(jsonObj.getString("userIdsToExclude"));
				List<User>list = new ArrayList<User>();
				for(int rnCounter = 0 ; rnCounter < roleNames.length() ; rnCounter++){
					String roleName = roleNames.getString(rnCounter);
					try {
						Role role = RoleLocalServiceUtil.getRole(companyId, roleName);
						List<User> roleUserList = UserLocalServiceUtil.getRoleUsers(role.getRoleId());
						
						if (userIdsToExclude.length() > 0){
							for(User user : roleUserList){
								boolean found = false;
								for(int uidXCounter = 0 ; uidXCounter < userIdsToExclude.length() ; uidXCounter++){
									if (userIdsToExclude.getLong(uidXCounter) == user.getUserId()){
										found = true; break;
									}
								}
								if(!found){
									list.add(user);
								}
							}
						} else{
							list.addAll(roleUserList);
						}
					} catch (PortalException | SystemException e) {
						log.error(e);
					}
				}
				
				Collections.sort(list, new Comparator<User>() {
					@Override
					public int compare(User o1, User o2) {
						return o1.getFullName().compareToIgnoreCase(o2.getFullName());
					}
				});
				
				for (User user : list) {
					map.put(String.valueOf(user.getUserId()), user.getFullName());
				}
				
			} catch (JSONException e) {
				log.error(e);
			}
		}
		
		return map;
	}
	
	
	public Map<String,String> getProducts(){
		Map<String,String>map = new LinkedHashMap<String, String>();
		try {
			List<Product> list = ProductLocalServiceUtil.getActiveProducts();
			for (Product product : list) {
				String customProductName = ProductLocalServiceUtil.customProductName(product);
				map.put(String.valueOf(product.getSpProductId()), customProductName);
			}
		} catch (SystemException e) {
			log.error(e);
		}
		return map;
	}
	
	public Map<String,PEProcessStage> getStagesMap(){
		Map<String,PEProcessStage>map = new LinkedHashMap<>();
		List<PEProcessStage> stages;
		try {
			stages = PEProcessStageLocalServiceUtil.getPEProcessStages(-1, -1);
			for (PEProcessStage stage : stages) {
				map.put(stage.getName().toLowerCase(), stage);
			}
		} catch (SystemException e) {
			log.error(e);
		}
		return map;
	}
	
	public Map<String,String> getStages(String settings){
		Map<String,String>map = new LinkedHashMap<String, String>();
		try {
			Map<String,PEProcessStage>allStages = getStagesMap();
			JSONArray array = JSONFactoryUtil.createJSONArray(settings);
			for(int i = 0 ; i < array.length(); i++ ){
				String stageName = array.getString(i).toLowerCase();
				if(allStages.containsKey(stageName)){
					PEProcessStage stage = allStages.get(stageName);
					map.put(String.valueOf(stage.getSpPEProcessStageId()), stage.getName());
				}else{
					log.error("Stage does not exist " + stageName);
					map.put(String.valueOf(0),  array.getString(i));
				}
			}
		} catch ( JSONException e) {
			log.error(e);
		}
		return map;
	}
	
	
	public static JSONArray getAPIModel(){
		JSONArray apiJsonArray = JSONFactoryUtil.createJSONArray();
		GenericSearchAPIRegistry apiRegistry = GenericSearchAPIRegistry.instance;
		Set<String> apiKeys = apiRegistry.getAPIKeySet();
		for(String apiKey : apiKeys){
			JSONObject jsonObj = JSONFactoryUtil.createJSONObject();
			jsonObj.put("apiKey", apiKey);
			jsonObj.put("title", apiRegistry.getAPIModel(apiKey).getTitle());
			jsonObj.put("defaultSettings", apiRegistry.getAPIModel(apiKey).getDefaultSettings());
			apiJsonArray.put(jsonObj);
		}
		return apiJsonArray;
		
	}
	
}
