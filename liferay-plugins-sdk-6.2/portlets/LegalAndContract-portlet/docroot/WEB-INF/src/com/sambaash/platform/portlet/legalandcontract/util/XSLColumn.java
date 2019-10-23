package com.sambaash.platform.portlet.legalandcontract.util;

public class XSLColumn {
	
	private  String name;
	private  boolean requiredField;
	private  boolean categoryField;
	private  String vocIdKey;
	private  String dataType;
	private  long length;
	
	public XSLColumn(String name,boolean requiredField,String dataType,long length){
		this.name = name;
		this.requiredField = requiredField;
		this.dataType = dataType;
		this.length = length;
	}
	public XSLColumn(String name,boolean requiredField){
		this.name = name;
		this.requiredField = requiredField;
	}
	public XSLColumn(String name,boolean requiredField,String dataType,boolean categoryField,String vocId){
		this.name = name;
		this.requiredField = requiredField;
		this.dataType = dataType;
		this.categoryField = categoryField;
		this.vocIdKey = vocId;
		
		if(categoryField){
			this.length = LegalConstants.NOT_APPLICABLE_LENGTH;
		}
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isRequiredField() {
		return requiredField;
	}
	public void setRequiredField(boolean requiredField) {
		this.requiredField = requiredField;
	}
	public boolean isCategoryField() {
		return categoryField;
	}
	public void setCategoryField(boolean categoryField) {
		this.categoryField = categoryField;
	}
	public String getVocIdKey() {
		return vocIdKey;
	}
	public void setVocIdKey(String vocIdKey) {
		this.vocIdKey = vocIdKey;
	}
	public String getDataType() {
		return dataType;
	}
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}
	public long getLength() {
		return length;
	}
	public void setLength(long length) {
		this.length = length;
	}
	
}
