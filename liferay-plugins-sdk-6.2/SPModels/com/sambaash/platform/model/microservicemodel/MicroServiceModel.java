package com.sambaash.platform.model.microservicemodel;


import com.liferay.portal.kernel.json.JSONObject;
import java.util.Map; 
import java.util.ArrayList;
import java.util.HashMap;

import com.liferay.portal.kernel.json.JSONFactoryUtil;

public class MicroServiceModel {
	public ArrayList<String> columnList(){
		return new ArrayList<String>();
	}
	public ArrayList<String> filterColumnList(){
		return new ArrayList<String>();
	}
	public Map<String,String> columnTitleMap(){
		return new HashMap<String,String>();
	}
public JSONObject FormIOToModelJSON(JSONObject in,JSONObject jsonModelExistingData){
		
	ArrayList<String> columns = columnList();
	if(columns.size()==0)
		return No_Op_FormIOToModelJSON(in,jsonModelExistingData);
	if(jsonModelExistingData.toString().equals("{}")){
		JSONObject contentJson = JSONFactoryUtil.createJSONObject();
		contentJson.put("Status", "Active");
		jsonModelExistingData.put("contentJson",contentJson);
	}
	for(int i = 0; i< in.names().length(); i++){
		if(columns.contains(in.names().getString(i))){
			jsonModelExistingData.getJSONObject("contentJson").put(in.names().getString(i), in.getString(in.names().getString(i)));
		}
	}
	return jsonModelExistingData;
	
}

protected JSONObject No_Op_FormIOToModelJSON(JSONObject in,JSONObject jsonModelExistingData){
	JSONObject apiJsonModelData = JSONFactoryUtil.createJSONObject();
	apiJsonModelData.put("contentJson",in.toString());
	return apiJsonModelData;
}

public JSONObject ModelToFormIOJSON(JSONObject in){
	return in;
}

}