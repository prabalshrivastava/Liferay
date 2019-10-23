package com.sambaash.platform.model.microservicemodel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;


public class SubjectModel extends MicroServiceModel{
	@Override
	public ArrayList<String> columnList(){
		
		return new ArrayList<String>(Arrays.asList("SubjectCode","GraduationLevel","SubjectTitle","SubjectDescription","SubjectType","TotalHour","TotalMin","Remarks","InactiveReason","Status"));
		
	}
	@Override
	public ArrayList<String> filterColumnList(){
		return new ArrayList<String>(Arrays.asList("SubjectCode","GraduationLevel","SubjectType"));
	}
	@Override
	public Map<String,String> columnTitleMap(){
		return new HashMap<String,String>(){
		    {
		        put("SubjectCode", "Subject Code");
		        put("GraduationLevel", "Graduation Level");
		        put("SubjectTitle", "Subject Title");
		        put("SubjectDescription", "Subject Description");
		        put("SubjectType", "Subject Type");
		        put("TotalHour", "Total Hour");
		        put("TotalMin", "Total Minutes");
		        put("Remarks", "Remarks");
		        put("InactiveReason", "Inactive Reason");
		        put("Status", "Status");		        
		    }
		};
	}
}