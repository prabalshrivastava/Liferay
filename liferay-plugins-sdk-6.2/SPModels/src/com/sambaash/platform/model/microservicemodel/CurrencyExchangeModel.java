package com.sambaash.platform.model.microservicemodel;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

public class CurrencyExchangeModel extends MicroServiceModel{
	
	public ArrayList<String> columnList(){
		
		return new ArrayList<String>(Arrays.asList("CurrencyCode","BaseCurrency","EffectiveDate","ExchangeRate","Status","Remark"));
	}
	@Override
	public ArrayList<String> filterColumnList(){
		return new ArrayList<String>(Arrays.asList("CurrencyCode"));
	}
	@Override
	public Map<String,String> columnTitleMap(){
		return new HashMap<String,String>(){
		    {
		        put("CurrencyCode", "Currency Code");
		        put("BaseCurrency", "Base Currency");
		        put("EffectiveDate", "Effective Date");
		        put("ExchangeRate", "Exchange Rate");
		        put("Remark", "Remark");
		        put("Status", "Status");		        
		    }
		};
	}
}