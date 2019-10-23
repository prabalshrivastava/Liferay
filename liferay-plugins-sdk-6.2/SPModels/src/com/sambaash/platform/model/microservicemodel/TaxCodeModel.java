package com.sambaash.platform.model.microservicemodel;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

public class TaxCodeModel extends MicroServiceModel{
	@Override
	public ArrayList<String> columnList(){
		
		return new ArrayList<String>(Arrays.asList("Country","DefaultGST","Percentage","Description","TaxCode","StartDate","Status"));
		
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
		        put("DefaultGST", "DefaultGST");
		        put("Percentage", "Percentage");
		        put("Description", "Description");
		        put("TaxCode", "Tax Code");
		        put("StartDate", "Start Date");		      
		        put("Status", "Status");		        
		    }
		};
	}
}