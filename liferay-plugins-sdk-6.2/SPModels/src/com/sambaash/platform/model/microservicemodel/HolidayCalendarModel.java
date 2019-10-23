package com.sambaash.platform.model.microservicemodel;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

public class HolidayCalendarModel extends MicroServiceModel{
	public ArrayList<String> columnList(){
		return new ArrayList<String>(Arrays.asList("Country","Year","Date","Description","Status","Remark"));
	}
	@Override
	public ArrayList<String> filterColumnList(){
		return new ArrayList<String>(Arrays.asList("Country"));
	}
	@Override
	public Map<String,String> columnTitleMap(){
		return new HashMap<String,String>(){
		    {
		        put("Country", "Country");
		        put("Year", "Year");
		        put("Date", "Date");
		        put("Description", "Description");
		        put("Remark", "Remark");
		        put("Status", "Status");		        
		    }
		};
	}
}