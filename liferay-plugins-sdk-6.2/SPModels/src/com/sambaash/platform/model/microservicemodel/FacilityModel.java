package com.sambaash.platform.model.microservicemodel;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;


public class FacilityModel extends MicroServiceModel{
	
	public ArrayList<String> columnList(){
		
		return  new ArrayList<String>(Arrays.asList("FacilityType","FacilityCategory","FacilityCode","FacilityName","Address",
				"LocationMapURL","Capacity","ContactNumber","ContactPerson","EmailAddress","Equipments","Status","Remarks"));
	}
	@Override
	public ArrayList<String> filterColumnList(){
		return new ArrayList<String>(Arrays.asList("FacilityType","FacilityCategory"));
	}
	@Override
	public Map<String,String> columnTitleMap(){
		return new HashMap<String,String>(){
		    {
		        put("FacilityType", "Facility Type");
		        put("FacilityCategory", "Facility Category");
		        put("FacilityCode", "FacilityCode");
		        put("FacilityName", "FacilityName");
		        put("Address", "Address");
		        put("LocationMapURL", "LocationMapURL");
		        put("Capacity", "Capacity");
		        put("ContactNumber", "ContactNumber");
		        put("ContactPerson", "ContactPerson");
		        put("EmailAddress", "EmailAddress");
		        put("Equipments", "Equipments");
		        put("Remarks", "Remarks");
		        put("Status", "Status");		        
		    }
		};
	}
	
	public JSONObject FormIOToModelJSON(JSONObject in,JSONObject jsonModelExistingData){
		
		ArrayList<String> columns = columnList();
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
		if(!in.getString("FacilityIntCategory").equalsIgnoreCase("")){
			jsonModelExistingData.getJSONObject("contentJson").put("FacilityCategory", in.getString("FacilityIntCategory"));
		}
		if(!in.getString("FacilityExtCategory").equalsIgnoreCase("")){
			jsonModelExistingData.getJSONObject("contentJson").put("FacilityCategory", in.getString("FacilityExtCategory"));
		}
		return jsonModelExistingData;
	}
	
	public JSONObject ModelToFormIOJSON(JSONObject in){
		JSONObject out = in , contentJSON = in.getJSONObject("contentJson");
		
		if(contentJSON.getString("FacilityType").equalsIgnoreCase("internal")){
			out.getJSONObject("contentJson").put("FacilityIntCategory", contentJSON.getString("FacilityCategory"));
		}
		else if(contentJSON.getString("FacilityType").equalsIgnoreCase("external")){
			out.getJSONObject("contentJson").put("FacilityExtCategory", contentJSON.getString("FacilityCategory"));
		}
		return out;
	}

}