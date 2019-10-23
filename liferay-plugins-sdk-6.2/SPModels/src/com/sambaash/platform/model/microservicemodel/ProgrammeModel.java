package com.sambaash.platform.model.microservicemodel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

public class ProgrammeModel extends MicroServiceModel{
	
	public ArrayList<String> columnList(){
		
		return new ArrayList<String>(Arrays.asList("ProgrammeCode","ProgrammeTitle","ProgrammeDescription","RegulationType","WithCourseWork","Remarks","InactiveReason","Status"));
		
	}
	@Override
	public ArrayList<String> filterColumnList(){
		return new ArrayList<String>(Arrays.asList("RegulationType"));
	}
	@Override
	public Map<String,String> columnTitleMap(){
		return new HashMap<String,String>(){
		    {
		        put("ProgrammeCode", "Programme Code");
		        put("ProgrammeTitle", "Programme Title");
		        put("ProgrammeDescription", "Programme Description");
		        put("RegulationType", "Regulation Type");
		        put("WithCourseWork", "With Course Work");
		        put("Remarks", "Remarks");
		        put("InactiveReason", "Inactive Reason");
		        put("Status", "Status");		        
		    }
		};
	}
}