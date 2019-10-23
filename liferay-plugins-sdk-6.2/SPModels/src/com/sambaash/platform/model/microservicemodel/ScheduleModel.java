package com.sambaash.platform.model.microservicemodel;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

public class ScheduleModel extends MicroServiceModel{
	public ArrayList<String> columnList(){
		return new ArrayList<String>(Arrays.asList("ScheduleCode","Name","StartDate","EndDate","Type"));
	}
	@Override
	public ArrayList<String> filterColumnList(){
		return new ArrayList<String>(Arrays.asList("ScheduleCode","Name","StartDate","EndDate","Type"));
	}
	@Override
	public Map<String,String> columnTitleMap(){
		return new HashMap<String,String>(){
		    {
		        put("ScheduleCode", "Schedule Code");
		        put("Name", "Name");
		        put("StartDate", "Start Date");
		        put("EndDate", "End Date");
		        put("Type", "Type");	        
		    }
		};
	}
}