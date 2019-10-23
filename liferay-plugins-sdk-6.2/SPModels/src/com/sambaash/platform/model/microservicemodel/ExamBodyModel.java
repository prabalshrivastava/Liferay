package com.sambaash.platform.model.microservicemodel;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

public class ExamBodyModel extends MicroServiceModel{
	@Override
	public ArrayList<String> columnList(){
		
		return new ArrayList<String>(Arrays.asList("ExamBody","Description","Status","SelectPerson","UploadThumbnail"));
		
	}
	@Override
	public ArrayList<String> filterColumnList(){
		return new ArrayList<String>(Arrays.asList("ExamBody"));
	}
	@Override
	public Map<String,String> columnTitleMap(){
		return new HashMap<String,String>(){
		    {
		        put("ExamBody", "ExamBody");
		        put("Description", "Description");
		        put("Status", "Status");
		        put("SelectPerson", "SelectPerson");
		        put("UploadThumbnail", "UploadThumbnail");		        
		    }
		};
	}
}