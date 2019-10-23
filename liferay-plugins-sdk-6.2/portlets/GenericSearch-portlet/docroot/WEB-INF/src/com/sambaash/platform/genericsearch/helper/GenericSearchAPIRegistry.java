package com.sambaash.platform.genericsearch.helper;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.sambaash.platform.genericsearch.model.GenericSearchAPIModel;

public enum GenericSearchAPIRegistry {

	instance;
	
	public static final String USERS_FOR_ROLES = "USERS_FOR_ROLES";
	public static final String PRODUCTS = "PRODUCTS";
	public static final String PE_STAGES = "PE-STAGES";
	public static final String CUSTOM_DATA = "CUSTOM DATA";
	public static final String COUNTRIES_FROM_DB = "COUNTRIES_FROM_DB";

	static{
		GenericSearchAPIModel model = new GenericSearchAPIModel(USERS_FOR_ROLES, "Users having role");
		model.setDefaultSettings("{ \"roleNames\":[\"RoleName1\",\"RoleName2\"], \"userIdsToExclude\":[\"123\",\"124\"]}");
		instance.registry.put(USERS_FOR_ROLES, model);


		model = new GenericSearchAPIModel(PRODUCTS, "Products");
		model.setDefaultSettings("<No Configuration data required>");
		instance.registry.put(PRODUCTS, model);

		model = new GenericSearchAPIModel(PE_STAGES, "ProcessFlow Stages");
		model.setDefaultSettings("[\"Comma separated stage names\",\"STAGE1\",\"STAGE2\"]");
		instance.registry.put(PE_STAGES, model);

		model = new GenericSearchAPIModel(CUSTOM_DATA, "Customized Data");
		model.setDefaultSettings("[{\"key\":\"key1\",\"value\":\"value1\"}]");
		instance.registry.put(CUSTOM_DATA, model);

		model = new GenericSearchAPIModel(COUNTRIES_FROM_DB, "Countries (From DB)");
		model.setDefaultSettings("<No configurations required>");
		instance.registry.put(COUNTRIES_FROM_DB, model);
	}
	
	public GenericSearchAPIModel getAPIModel(String key){
		return registry.get(key);
	}
	
	public Set<String> getAPIKeySet(){
		return registry.keySet();
	}
	
	private Map<String,GenericSearchAPIModel>registry = new HashMap<String, GenericSearchAPIModel>(10);
	
}
