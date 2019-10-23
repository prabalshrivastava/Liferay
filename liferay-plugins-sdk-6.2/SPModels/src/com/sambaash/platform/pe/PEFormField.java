package com.sambaash.platform.pe;

import java.util.ArrayList;
import java.util.List;

public class PEFormField {

	private String fieldId;
	private List<String>values = new ArrayList<String>();
	
	public PEFormField(String fieldId){
		this.fieldId = fieldId;
	}
	
	public void addValue(String value){
		values.add(value);
	}
	public void addAllValues(String values[]){
		if(values != null){
			for(String val: values){
				addValue(val);
			}
		}
	}

	public String getFieldId() {
		return fieldId;
	}

	public void setFieldId(String fieldId) {
		this.fieldId = fieldId;
	}

	public List<String> getValues() {
		return values;
	}

	public void setValues(List<String> values) {
		this.values = values;
	}
	
	
}
