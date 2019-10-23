package com.sambaash.platform.model.microservicemodel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
public class SessionModel extends MicroServiceModel{
	
	public ArrayList<String> columnList(){
		return  new ArrayList<String>(Arrays.asList("SessionTypeName","StartTime","EndTime","Remarks","Status"));
	}
	@Override
	public Map<String,String> columnTitleMap(){
		return new HashMap<String,String>(){
		    {
		        put("SessionTypeName", "Session Type Name");
		        put("StartTime", "Start Time");
		        put("EndTime", "End Time");
		        put("Remarks", "Remarks");
		        put("Status", "Status");		        
		    }
		};
	}
}