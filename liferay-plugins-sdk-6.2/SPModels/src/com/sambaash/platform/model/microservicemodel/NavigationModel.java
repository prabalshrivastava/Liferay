package com.sambaash.platform.model.microservicemodel;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

public class NavigationModel extends MicroServiceModel{
	@Override
	public ArrayList<String> columnList(){
		
		return new ArrayList<String>(Arrays.asList("ModelName","Status","NavigationId","DataGrid"));
		
	}
	@Override
	public ArrayList<String> filterColumnList(){
		return new ArrayList<String>(Arrays.asList(""));
	}
	@Override
	public Map<String,String> columnTitleMap(){
		return new HashMap<String,String>(){
		    {
		        put("ModelName", "Model Name");
		        put("Status", "Status");	        
		    }
		};
	}
}