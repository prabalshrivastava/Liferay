package com.sambaash.platform.model.microservicemodel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CandidateModel extends MicroServiceModel{
	
	public ArrayList<String> columnList(){
		return  new ArrayList<String>(Arrays.asList(""));
		//"UserId","Gender","FirstName","LastName","Salutation","FullName","IDType","IDNumber","IDType2","IDNumber2","DateOfBirth","PrimaryEmailAddress","SecondaryEmailAddress","ContactNumberSingapore","ContactNumberOthers"
	}
	@Override
	public Map<String,String> columnTitleMap(){
		return new HashMap<String,String>(){
		    {
		        put("Gender", "Gender");
		        put("FirstName", "First Name");
		        put("LastName", "Last Name");        
		    }
		};
	}
}