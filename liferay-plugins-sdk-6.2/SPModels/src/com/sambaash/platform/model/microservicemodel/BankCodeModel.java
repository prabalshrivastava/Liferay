package com.sambaash.platform.model.microservicemodel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
public class BankCodeModel extends MicroServiceModel{
	
	public ArrayList<String> columnList(){
		return  new ArrayList<String>(Arrays.asList("BankCode","BankName","ShortBankName","Status"));
	}
	@Override
	public Map<String,String> columnTitleMap(){
		return new HashMap<String,String>(){
		    {
		        put("BankCode", "Bank Code");
		        put("BankName", "Bank Name");
		        put("ShortBankName", "Short Bank Name");
		        put("Status", "Status");		        
		    }
		};
	}
}