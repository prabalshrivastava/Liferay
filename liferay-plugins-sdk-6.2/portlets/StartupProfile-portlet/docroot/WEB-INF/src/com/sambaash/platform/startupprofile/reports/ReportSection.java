package com.sambaash.platform.startupprofile.reports;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.xml.bind.annotation.XmlElement;

import com.liferay.portal.kernel.util.Validator;

public class ReportSection {
	
	private Map<String, String> data;
	
	public  void add(String key, String value){
		if(Validator.isNull(data)){
			data = new LinkedHashMap<String, String>(); 
		}
		data.put(key, value);
	}

	public Map<String, String> getData() {
		return data;
	}

	public void setData(Map<String, String> data) {
		this.data = data;
	}
}
